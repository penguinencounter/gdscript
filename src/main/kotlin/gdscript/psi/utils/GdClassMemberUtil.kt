package gdscript.psi.utils

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FilenameIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import gdscript.GdKeywords
import gdscript.index.impl.GdClassIdIndex
import gdscript.index.impl.GdClassNamingIndex
import gdscript.index.impl.GdClassVarDeclIndex
import gdscript.psi.*
import gdscript.settings.GdSettingsState

object GdClassMemberUtil {

    /**
     * Finds declaration (const, var, enum, signal, method, ...) of given NamedElement skipping itself
     */
    fun findDeclaration(
        element: GdNamedElement,
        onlyPreceding: Boolean = false,
    ): PsiElement? {
        return listDeclarations(element, element, onlyPreceding).firstOrNull();
    }

    /**
     * List available declarations (const, var, enum, signal, method, ...) from given PsiElement skipping itself
     * @param searchFor stops and returns matching element
     */
    fun listDeclarations(
        element: PsiElement,
        searchFor: GdNamedElement,
        onlyPreceding: Boolean = false,
    ): Array<PsiElement> {
        return listDeclarations(element, searchFor.name, onlyPreceding);
    }

    /**
     * List available declarations (const, var, enum, signal, method, ...) from given PsiElement skipping itself
     * @param searchFor stops and returns matching element
     */
    fun listDeclarations(
        element: PsiElement,
        searchFor: String? = null,
        onlyPreceding: Boolean = false,
    ): Array<PsiElement> {
        var static = false;

        val result = mutableListOf<PsiElement>()
        var calledOn: String? = GdKeywords.SELF;
        when (val parent = element.parent?.parent) {
            is GdAttributeEx -> {
                if (element.parent.prevSibling != null) {
                    val ex = parent.exprList.first()!!;
                    calledOn = ex.returnType;
                    static = calledOn == ex.text;
                }
            }
            is GdCallEx -> {
                val prev = parent.parent;
                if (prev.text != GdKeywords.SELF && prev is GdAttributeEx) {
                    if (parent.prevSibling != null) {
                        val ex = prev.exprList.first()!!;
                        calledOn = ex.returnType;
                        static = calledOn == ex.text;
                        if (static) { // _GlobalScope has matching variables with classes
                            val virtualFile = FilenameIndex.getVirtualFilesByName("${GdKeywords.GLOBAL_SCOPE}.gd", GlobalSearchScope.allScope(element.project)).firstOrNull();
                            if (virtualFile != null) {
                                val psiFile = PsiManager.getInstance(element.project).findFile(virtualFile);
                                static = GdClassVarDeclIndex.get(
                                    calledOn,
                                    element.project,
                                    GlobalSearchScope.fileScope(psiFile!!),
                                ).isEmpty();
                            }
                        }
                    }
                }
            }
        }

        when (calledOn) {
            GdKeywords.SELF -> calledOn = null;
            GdKeywords.SUPER -> calledOn = GdInheritanceUtil.getExtendedClassId(element);
        }

        var parent: PsiElement?;

        // If it's stand-alone ref_id, adds also _Global & ClassNames - Classes are added as last due to matching name of some GlobalVars with class_name
        if (calledOn == null) {
            arrayOf(GdKeywords.GLOBAL_SCOPE, GdKeywords.GLOBAL_GD_SCRIPT).forEach {
                val globalParent = GdClassIdIndex.getGloballyResolved(it, element.project).firstOrNull();
                if (globalParent != null) {
                    val local = addsParentDeclarations(
                        GdClassUtil.getOwningClassElement(globalParent),
                        result,
                        static,
                        searchFor
                    );
                    if (searchFor != null && local != null) return arrayOf(local);
                }
            }
        }

        // Checks locals only when it's not attribute/call expression moving declaration possibly outside
        if (calledOn == null) {
            val locals = listLocalDeclarationsUpward(element);
            if (searchFor != null && locals.containsKey(searchFor)) return arrayOf(locals[searchFor]!!);
            result.addAll(locals.values);

            // This class is already scanned via localDecl - so move to extended one
            parent = if (onlyPreceding) {
                GdInheritanceUtil.getExtendedElement(element);
            } else {
                GdClassUtil.getOwningClassElement(element);
            }
        } else {
            parent = GdClassIdIndex.getGloballyResolved(calledOn, element.project).firstOrNull();
            if (parent != null)
                parent = GdClassUtil.getOwningClassElement(parent);
        }

        // Recursively iterate over all extended classes
        val local = collectFromParents(parent, result, static, searchFor);
        if (local != null) return arrayOf(local);

        if (calledOn == null) {
            if (searchFor != null) {
                val localClass = GdClassNamingIndex.getGlobally(searchFor, element).firstOrNull();
                if (localClass != null) return arrayOf(localClass);
            }
            result.addAll(GdClassNamingIndex.getAllValues(element.project));
        }

        if (searchFor != null) return emptyArray();
        return result.toTypedArray();
    }

    /**
     * Recursively iterate over all extended classes
     * Separately used for method overriding completion
     */
    fun collectFromParents(
        parent: PsiElement?,
        result: MutableList<PsiElement>,
        static: Boolean? = null,
        search: String? = null,
    ): PsiElement? {
        var par = parent;
        while (par != null) {
            val local = addsParentDeclarations(par, result, static, search);
            if (search != null && local != null) return local;
            par = GdInheritanceUtil.getExtendedElement(par);
        }

        return null;
    }

    /**
     * Finds local declarations from current position upwards
     *
     * @return HashMap<name, PsiElement>
     */
    fun listLocalDeclarationsUpward(
        element: PsiElement,
    ): HashMap<String, PsiElement> {
        val locals: HashMap<String, PsiElement> = hashMapOf();
        var it: PsiElement = element;

        // To avoid matching self
        when (it.parent) {
            is GdClassVarDeclTl,
            is GdVarDeclSt,
            is GdConstDeclTl,
            is GdConstDeclSt,
            is GdEnumDeclTl,
            is GdSetDecl,
            is GdSignalDeclTl,
            is GdMethodDeclTl,
            is GdParam,
            is GdForSt, // todo neodzkoušeno
            is GdBindingPattern, // todo neodzkoušeno
            -> {
                it = it.parent;
            }
        }

        while (true) {
            val movedToParent = it.prevSibling == null;
            it = it.prevSibling ?: it.parent ?: break;
            when (it) {
                is GdClassVarDeclTl -> locals[it.name] = it;
                is GdVarDeclSt -> locals[it.name] = it;
                is GdConstDeclTl -> locals[it.name] = it;
                is GdConstDeclSt -> locals[it.name] = it;
                is GdEnumDeclTl -> locals[it.name] = it;
                is GdSignalDeclTl -> locals[it.name] = it;
                is GdParam -> {
                    locals[it.varNmi.name] = it;
                };
                is GdForSt -> if (movedToParent) locals[it.varNmi.name] = it;
                is GdPatternList -> {
                    if (movedToParent) { // TODO potřeba?
                        PsiTreeUtil.getChildrenOfType(it, GdBindingPattern::class.java)
                            ?.map { b -> locals[b.varNmi.name] = b }
                    }
                }
                is GdSetDecl -> {
                    if (movedToParent) {
                        locals[it.varNmi?.name.orEmpty()] = it
                    }
                };
                is GdMethodDeclTl -> {
                    locals[it.name] = it;
                }

                // End of scope
                is GdClassDeclTl -> break;
            }
        }

        return locals;
    }

    fun firstNamedDeclaration(element: PsiElement): PsiElement? {
        return PsiTreeUtil.findFirstParent(element) {
            it is GdClassVarDeclTl
                    || it is GdVarDeclSt
                    || it is GdConstDeclTl
                    || it is GdConstDeclSt
                    || it is GdMethodDeclTl
                    || it is GdClassDeclTl
                    || it is GdParam
        }
    }

    fun firstNamedDeclarationName(element: PsiElement): String? {
        return when (val it = firstNamedDeclaration(element)) {
            is GdClassVarDeclTl -> it.name
            is GdVarDeclSt -> it.name
            is GdConstDeclTl -> it.name
            is GdConstDeclSt -> it.name
            is GdMethodDeclTl -> it.name
            is GdClassDeclTl -> it.name
            is GdParam -> it.varNmi.name
            is GdSignalDeclTl -> it.name
            else -> null
        }
    }

    // TODO ii
    //    abs() -> Variant:
    //    Tady je potřeba z variant udělat cokoliv? .. resp. to je jako generic?

    /**
     * Filters out GdMethodsDeclTl & returns typed array
     */
    fun Array<PsiElement>.methods(): Array<GdMethodDeclTl> {
        return this.filterIsInstance<GdMethodDeclTl>().toTypedArray();
    }

    /**
     * Filters out GdMethodsDeclTl & returns typed array
     */
    fun List<PsiElement>.methods(): Array<GdMethodDeclTl> {
        return this.filterIsInstance<GdMethodDeclTl>().toTypedArray();
    }

    /**
     * List given element's class declarations
     */
    fun listClassMemberDeclarations(element: PsiElement, static: Boolean? = false): Array<PsiElement> {
        return listNamedClassMemberDeclarations(element, static).array();
    }

    /**
     * @param classElement GdClassDecl|GdFile class containing element
     * @param search String|null if looking for specific declaration
     *
     * @return should search param be not null, returns matching element
     */
    private fun addsParentDeclarations(
        classElement: PsiElement,
        result: MutableList<PsiElement>,
        static: Boolean? = false,
        search: String? = null,
    ): PsiElement? {
        val members = listNamedClassMemberDeclarations(classElement, static);
        if (search != null && members.containsKey(search)) {
            return members[search]!!.first();
        }

        result.addAll(members.array());

        return null;
    }

    /**
     * Finds local declarations from current position upwards
     *
     * @param element GdClassDecl|GdFile class containing element
     *
     * @return HashMap<name, MutableList<PsiElement>>
     */
    private fun listNamedClassMemberDeclarations(
        element: PsiElement,
        static: Boolean? = false,
    ): HashMap<String, MutableList<PsiElement>> {
        val classElement = when (element) {
            is GdFile, is GdClassDeclTl -> element;
            else -> GdClassUtil.getOwningClassElement(element);
        }

        val members: HashMap<String, MutableList<PsiElement>> = hashMapOf();

        PsiTreeUtil.getStubChildrenOfTypeAsList(classElement, GdConstDeclTl::class.java).forEach {
            val name = it.name;
            if (!members.containsKey(name)) members[name] = mutableListOf();
            members[name]!!.add(it)
        }

        if (static != true) {
            PsiTreeUtil.getStubChildrenOfTypeAsList(classElement, GdClassVarDeclTl::class.java).forEach {
                val name = it.name;
                if (!members.containsKey(name)) members[name] = mutableListOf();
                members[name]!!.add(it)
            }
            PsiTreeUtil.getStubChildrenOfTypeAsList(classElement, GdEnumDeclTl::class.java).forEach {
                val name = it.name;
                if (!members.containsKey(name)) members[name] = mutableListOf();
                members[name]!!.add(it)
            }
            PsiTreeUtil.getStubChildrenOfTypeAsList(classElement, GdSignalDeclTl::class.java).forEach {
                val name = it.name;
                if (!members.containsKey(name)) members[name] = mutableListOf();
                members[name]!!.add(it)
            }
        }

        PsiTreeUtil.getStubChildrenOfTypeAsList(classElement, GdMethodDeclTl::class.java).forEach {
            if ((static == null || it.isStatic == static) && !it.isConstructor) {
                val name = it.name;
                if (!members.containsKey(name)) members[name] = mutableListOf();
                members[name]!!.add(it);
            }
        }
        // TODO ii inner classes musí napovídat také po resource ... :/
        //PsiTreeUtil.getStubChildrenOfTypeAsList(classElement, GdClassDeclTl::class.java).map { members[it.name] = it; }

        return members;
    }

    /**
     * NamedClassMembers to Array
     */
    fun HashMap<String, MutableList<PsiElement>>.array(): Array<PsiElement> {
        return this.entries.flatMap {
            if (!GdSettingsState.hidePrivate || !it.key.startsWith("_")) {
                it.value
            } else {
                emptyList()
            }
        }.toTypedArray();
    }

}
