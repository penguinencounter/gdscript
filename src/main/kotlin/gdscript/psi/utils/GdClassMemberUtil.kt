package gdscript.psi.utils

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FilenameIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import gdscript.GdKeywords
import gdscript.index.impl.GdClassNamingIndex
import gdscript.index.impl.GdClassVarDeclIndex
import gdscript.model.BoolVal
import gdscript.psi.*
import project.psi.util.ProjectAutoloadUtil

object GdClassMemberUtil {

    /**
     * Finds declaration (const, var, enum, signal, method, ...) of given NamedElement skipping itself
     */
    fun findDeclaration(
        element: GdNamedElement,
        onlyLocalScope: Boolean = false,
        ignoreParents: Boolean = false,
        ignoreGlobalScope: Boolean = false,
    ): Any? {
        return listDeclarations(element, element, onlyLocalScope, ignoreParents, ignoreGlobalScope).firstOrNull()
    }

    /**
     * List available declarations (const, var, enum, signal, method, ...) from given PsiElement skipping itself
     * @param searchFor stops and returns matching element
     */
    @SuppressWarnings()
    fun listDeclarations(
        element: PsiElement,
        searchFor: GdNamedElement,
        onlyLocalScope: Boolean = false,
        ignoreParents: Boolean = false,
        ignoreGlobalScope: Boolean = false,
    ): Array<Any> {
        return listDeclarations(element, searchFor.name, onlyLocalScope, ignoreParents, ignoreGlobalScope)
    }

    /**
     * List available declarations (const, var, enum, signal, method, ...) from given PsiElement skipping itself
     * @param searchFor stops and returns matching element
     */
    fun listDeclarations(
        element: PsiElement,
        searchFor: String? = null,
        onlyLocalScope: Boolean = false,
        ignoreParents: Boolean = false,
        ignoreGlobalScope: Boolean = false,
        allowResource: Boolean = false,
    ): Array<Any> {
        var static = false

        val result = mutableListOf<Any>()
        var calledOn: String? = GdKeywords.SELF

        val calledOnPsi: GdExpr? = calledUpon(element)
        if (calledOnPsi != null && calledOnPsi.text != GdKeywords.SELF) {
            // Check if there is an assertion check 'if (node is Node3D):'
            calledOn = findIsTypeCheck(calledOnPsi) ?: calledOnPsi.getReturnTypeOrRes(allowResource)
            if (calledOn.startsWith("Array[")) calledOn = "Array"
            static = (calledOn == calledOnPsi.text) && checkGlobalStaticMatch(element, calledOn)
        }

        if (!static) {
            when (val ownerMethod = PsiTreeUtil.getParentOfType(
                calledOnPsi ?: element,
                GdMethodDeclTl::class.java,
                GdFuncDeclEx::class.java,
            )) {
                is GdMethodDeclTl -> {
                    static = ownerMethod.isStatic
                }

                is GdFuncDeclEx -> {}
            }
        }

        when (calledOn) {
            GdKeywords.SELF -> calledOn = null
            GdKeywords.SUPER -> calledOn = GdInheritanceUtil.getExtendedClassId(element)
        }

        var parent: PsiElement?

        // If it's stand-alone ref_id, adds also _Global & ClassNames - Classes are added as last due to matching name of some GlobalVars with class_name
        if (calledOn == null && !ignoreGlobalScope) {
            arrayOf(GdKeywords.GLOBAL_SCOPE, GdKeywords.GLOBAL_GD_SCRIPT).forEach {
                val globalParent = GdClassUtil.getClassIdElement(it, element)
                if (globalParent != null) {
                    val local = addsParentDeclarations(
                        GdClassUtil.getOwningClassElement(globalParent),
                        result,
                        static,
                        searchFor
                    )
                    if (searchFor != null && local != null) return arrayOf(local)
                }
            }
        }

        val hitLocal = BoolVal.new()
        // Checks locals only when it's not attribute/call expression moving declaration possibly outside
        if (calledOn == null) {
            val locals = listLocalDeclarationsUpward(element, onlyLocalScope, hitLocal)
            if (searchFor != null && locals.containsKey(searchFor)) return arrayOf(locals[searchFor]!!)
            result.addAll(locals.values)

            // This class is already scanned via localDecl - so move to extended one
            parent = if (onlyLocalScope) {
                GdInheritanceUtil.getExtendedElement(element)
            } else {
                GdClassUtil.getOwningClassElement(element)
            }
        } else {
            // For Enum add also all it's values
            if (calledOn.startsWith("Array[")) calledOn = "Array"

            if (calledOn.endsWith("Dictionary")) {
                val firstChild = PsiTreeUtil.collectElementsOfType(calledOnPsi, GdRefIdNm::class.java).lastOrNull()
                if (firstChild != null) {
                    val dictDecl = findDeclaration(firstChild)
                    if (dictDecl is GdEnumDeclTl) {
                        if (searchFor != null) {
                            val localVal = dictDecl.enumValueList.find { eval -> eval.enumValueNmi.name == searchFor }
                            if (localVal != null) return arrayOf(localVal)
                        }
                        result.addAll(dictDecl.enumValueList)
                    }
                }
                calledOn = "Dictionary"
            }

            parent = GdClassUtil.getClassIdElement(calledOn, element)
            if (parent == null) {
                val classId = GdClassUtil.getFullClassId(element)
                parent = GdClassUtil.getClassIdElement(
                    "$classId.${calledOn}",
                    element,
                )
                // Try autoload classes
                if (parent == null) {
                    parent = ProjectAutoloadUtil.findFromAlias(calledOn, element)
                    if (parent != null) static = false
                }
            }

            if (parent != null) {
                parent = GdClassUtil.getOwningClassElement(parent)
            }
        }

        // Recursively iterate over all extended classes
        if (!ignoreParents && !hitLocal.value) {
            val local = collectFromParents(parent, result, static, searchFor)
            if (local != null) return arrayOf(local)
        }

        if (calledOn == null) {
            val autoLoads = ProjectAutoloadUtil.listGlobals(element.project)
            if (searchFor != null) {
                val localClass = GdClassNamingIndex.INSTANCE.getGlobally(searchFor, element).firstOrNull()
                if (localClass != null) return arrayOf(localClass)
                val autoLoaded = autoLoads.find { it.key == searchFor }
                if (autoLoaded != null) return arrayOf(autoLoaded)
            }
            result.addAll(GdClassNamingIndex.INSTANCE.getAllValues(element.project))
            result.addAll(autoLoads)
        }

        if (searchFor != null) return emptyArray()
        return result.toTypedArray()
    }

    /**
     * Recursively iterate over all extended classes
     * Separately used for method overriding completion
     */
    fun collectFromParents(
        parent: PsiElement?,
        result: MutableList<Any>,
        static: Boolean? = null,
        search: String? = null,
    ): PsiElement? {
        var par = parent
        while (par != null) {
            val local = addsParentDeclarations(par, result, static, search)
            if (search != null && local != null) return local
            par = GdInheritanceUtil.getExtendedElement(par)
        }

        return null
    }

    /**
     * Finds local declarations from current position upwards
     *
     * @return HashMap<name, PsiElement>
     */
    fun listLocalDeclarationsUpward(
        element: PsiElement,
        onlyLocalScope: Boolean = false,
        hitLocal: BoolVal? = null,
    ): HashMap<String, PsiElement> {
        val locals: HashMap<String, PsiElement> = hashMapOf()
        var it: PsiElement = element

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
            is GdForSt,
            is GdBindingPattern,
            -> {
                it = it.parent
            }
        }
        var isParam = false
        when (it) {
            is GdParam,
            -> {
                isParam = true
                it = it.prevSibling ?: it.parent
            }
        }

        while (true) {
            val movedToParent = it.prevSibling == null
            it = it.prevSibling ?: it.parent ?: break
            when (it) {
                is GdClassVarDeclTl -> if (!locals.contains(it.name)) locals[it.name] = it
                is GdVarDeclSt -> if (!locals.contains(it.name)) locals[it.name] = it
                is GdConstDeclTl -> if (!locals.contains(it.name)) locals[it.name] = it
                is GdConstDeclSt -> if (!locals.contains(it.name)) locals[it.name] = it
                is GdEnumDeclTl -> if (!locals.contains(it.name)) locals[it.name] = it
                is GdSignalDeclTl -> if (!locals.contains(it.name)) locals[it.name] = it
                is GdParam -> {
                    if (!locals.contains(it.varNmi.name)) locals[it.varNmi.name] = it
                }

                is GdForSt -> if (movedToParent && !locals.contains(it.varNmi?.name ?: "")) locals[it.varNmi?.name
                    ?: ""] = it

                is GdPatternList -> {
                    if (movedToParent) {
                        PsiTreeUtil.getChildrenOfType(it, GdBindingPattern::class.java)
                            ?.map { b -> if (!locals.contains(b.varNmi.name)) locals[b.varNmi.name] = b }
                    }
                }

                is GdSetDecl -> {
                    if (movedToParent) {
                        if (!locals.contains(it.varNmi?.name.orEmpty())) locals[it.varNmi?.name.orEmpty()] = it.varNmi!!
                    }
                }

                is GdFuncDeclEx -> {
                    if (movedToParent && !isParam) {
                        it.paramList?.paramList?.forEach { p ->
                            if (!locals.contains(p.varNmi.name)) locals[p.varNmi.name] = p
                        }
                    }
                }

                is GdMethodDeclTl -> {
                    if (onlyLocalScope) {
                        if (!isParam) {
                            it.paramList?.paramList?.forEach { p ->
                                if (!locals.contains(p.varNmi.name)) locals[p.varNmi.name] = p
                            }
                        }
                        if (hitLocal != null) hitLocal.value = true
                        break
                    }
                    if (movedToParent) {
                        it.paramList?.paramList?.forEach { p ->
                            if (!locals.contains(p.varNmi.name)) locals[p.varNmi.name] = p
                        }
                    } else {
                        if (!locals.contains(it.name)) locals[it.name] = it
                    }
                }

                // End of scope
                is GdClassDeclTl -> break
            }
        }

        return locals
    }

    @SuppressWarnings()
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

    /**
     * Filters out GdMethodsDeclTl
     */
    fun Array<Any>.methods(): Array<GdMethodDeclTl> {
        return this.filterIsInstance<GdMethodDeclTl>().toTypedArray()
    }

    /**
     * Filters out GdMethodsDeclTl
     */
    fun List<Any>.methods(): Array<GdMethodDeclTl> {
        return this.filterIsInstance<GdMethodDeclTl>().toTypedArray()
    }

    /**
     * Filters out GdMethodsDeclTl of constructors
     */
    fun List<PsiElement>.constructors(): Array<GdMethodDeclTl> {
        return this.filterIsInstance<GdMethodDeclTl>().filter { it.isConstructor }.toTypedArray()
    }

    /**
     * Filters out GdClassVarDeclTl
     */
    fun List<PsiElement>.variables(): Array<GdClassVarDeclTl> {
        return this.filterIsInstance<GdClassVarDeclTl>().toTypedArray()
    }

    /**
     * Filters out GdEnumDeclTl
     */
    fun List<PsiElement>.enums(): Array<GdEnumDeclTl> {
        return this.filterIsInstance<GdEnumDeclTl>().toTypedArray()
    }

    /**
     * Filters out GdConstDeclTl
     */
    fun List<PsiElement>.constants(): Array<GdConstDeclTl> {
        return this.filterIsInstance<GdConstDeclTl>().toTypedArray()
    }

    /**
     * Filters out GdSignalDeclTl
     */
    fun List<PsiElement>.signals(): Array<GdSignalDeclTl> {
        return this.filterIsInstance<GdSignalDeclTl>().toTypedArray()
    }

    /**
     * Finds local declarations from current position upwards
     *
     * @param element GdClassDecl|GdFile class containing element
     *
     * @return HashMap<name, MutableList<PsiElement>>
     */
    fun listClassMemberDeclarations(
        element: PsiElement,
        static: Boolean? = false,
        search: String? = null,
        constructors: Boolean = false,
    ): MutableList<PsiElement> {
        val classElement = when (element) {
            is GdFile, is GdClassDeclTl -> element
            else -> GdClassUtil.getOwningClassElement(element)
        }

        val members = mutableListOf<PsiElement>()

        PsiTreeUtil.getStubChildrenOfTypeAsList(classElement, GdConstDeclTl::class.java).forEach {
            if (search != null && it.name == search) return mutableListOf(it)
            members.add(it)
        }
        PsiTreeUtil.getStubChildrenOfTypeAsList(classElement, GdEnumDeclTl::class.java).forEach {
            if (it.enumDeclNmi != null) {
                if (search != null && it.name == search) return mutableListOf(it)
                members.add(it)
            } else {
                it.enumValueList.forEach { value ->
                    if (search != null && value.enumValueNmi.name == search) return mutableListOf(value)
                    members.add(value)
                }
            }
        }
        PsiTreeUtil.getStubChildrenOfTypeAsList(classElement, GdSignalDeclTl::class.java).forEach {
            if (search != null && it.name == search) return mutableListOf(it)
            members.add(it)
        }
        PsiTreeUtil.getStubChildrenOfTypeAsList(classElement, GdClassDeclTl::class.java).forEach {
            if (search != null && it.name == search) return mutableListOf(it)
            members.add(it)
            members.addAll(listClassMemberDeclarations(it, static, search))
        }

        if (static != true) {
            PsiTreeUtil.getStubChildrenOfTypeAsList(classElement, GdClassVarDeclTl::class.java).forEach {
                if (search != null && it.name == search) return mutableListOf(it)
                members.add(it)
            }
        }

        PsiTreeUtil.getStubChildrenOfTypeAsList(classElement, GdMethodDeclTl::class.java).forEach {
            if ((static == null || it.isStatic == static)) {
                if (constructors || !it.isConstructor) {
                    if (search != null && it.name == search) return mutableListOf(it)
                    members.add(it)
                }
            }
        }
        if (search != null) return mutableListOf()

        return members
    }

    /**
     * @param classElement GdClassDecl|GdFile class containing element
     * @param search String|null if looking for specific declaration
     *
     * @return should search param be not null, returns matching element
     */
    private fun addsParentDeclarations(
        classElement: PsiElement,
        result: MutableList<Any>,
        static: Boolean? = false,
        search: String? = null,
    ): PsiElement? {
        val list = listClassMemberDeclarations(classElement, static, search)
        if (search != null) return list.firstOrNull()
        result.addAll(list)

        return null
    }

    fun calledUpon(element: PsiElement): GdExpr? {
        val getAttrIfAny = fun(el: PsiElement): GdExpr? {
            val previous = PsiTreeUtil.prevVisibleLeaf(el) ?: return null
            val parent = previous.parent ?: return null
            if (previous.elementType == GdTypes.DOT && parent is GdAttributeEx) {
                return parent.exprList.first()
            }
            return null
        }

        val attr = getAttrIfAny(element)
        if (attr != null) return attr

        val next = PsiTreeUtil.nextVisibleLeaf(element)
        if (next?.elementType == GdTypes.LRBR && next?.parent?.elementType == GdTypes.CALL_EX) {
            return getAttrIfAny(next!!.parent)
        }

        return null
    }

    /**
     * _GlobalScope has matching variables with classes
     */
    private fun checkGlobalStaticMatch(element: PsiElement, name: String): Boolean {
        val virtualFile = FilenameIndex.getVirtualFilesByName(
            "${GdKeywords.GLOBAL_SCOPE}.gd",
            GlobalSearchScope.allScope(element.project)
        ).firstOrNull() ?: return true
        val psiFile = PsiManager.getInstance(element.project).findFile(virtualFile) ?: return true

        return GdClassVarDeclIndex.INSTANCE.get(
            name,
            element.project,
            GlobalSearchScope.fileScope(psiFile),
        ).isEmpty()
    }

    /**
     * Looks for statements of type checks
     *  if node is Node3D:
     *  while next is Node3D:
     * and returns correct type for hint & validation
     */
    private fun findIsTypeCheck(element: PsiElement): String? {
        // TODO je to dost na hrubo a nekontroluje to negace a pod
        return getConditioned(element) { el, stmt ->
            val expr = PsiTreeUtil.findChildOfType(stmt, GdIsEx::class.java)
            if (expr != null && el.text == expr.expr.text) return@getConditioned expr.returnType
            null
        }
    }

    /**
     * Looks for statements of has_method
     *  if node.has_method("asd"):
     */
    fun hasMethodCheck(element: PsiElement): Boolean {
        // TODO je to dost na hrubo a nekontroluje to negace a pod
        return getConditioned(element) { el, stmt ->
            val expr = PsiTreeUtil.findChildOfType(stmt, GdCallEx::class.java)
            if (expr != null && expr.expr.text == "has_method") {
                if (expr.argList?.argExprList?.firstOrNull()?.text == "\"${el.text}\"") {
                    return@getConditioned true
                }
            }
            null
        } ?: false
    }

    private fun <T> getConditioned(element: PsiElement, action: (element: PsiElement, stmt: PsiElement?) -> T?): T? {
        val getParent = fun(stmt: PsiElement?): PsiElement? {
            return PsiTreeUtil.getParentOfType(stmt, GdIfSt::class.java, GdWhileSt::class.java, GdElifSt::class.java)
        }

        var parent = getParent(element)
        while (parent != null) {
            when (parent) {
                is GdIfSt -> {
                    val typed = action(element, parent.expr)
                    if (typed != null) return typed
                }

                is GdElifSt -> {
                    val typed = action(element, parent.expr)
                    if (typed != null) return typed
                    // To avoid matching from base condition that is not part of this suite
                    parent = PsiTreeUtil.getParentOfType(parent, GdIfSt::class.java)
                }

                is GdWhileSt -> {
                    val typed = action(element, parent.expr)
                    if (typed != null) return typed
                }
            }
            parent = getParent(parent)
        }

        return null
    }

}
