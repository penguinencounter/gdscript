package gdscript.psi.utils

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.refactoring.suggested.startOffset
import gdscript.GdKeywords
import gdscript.index.impl.*
import gdscript.psi.*

object PsiGdNamedUtil {

    /**
     * List all parent Classes
     */
    fun listParents(element: PsiElement): MutableList<PsiFile> {
        var parentName: String? =
            PsiTreeUtil.getChildOfType(element.containingFile, GdInheritance::class.java)?.inheritanceName;
        val parents = mutableListOf<PsiFile>();

        while (parentName !== null) {
            val parent = PsiGdInheritanceUtil.getPsiFile(parentName, element.project);
            if (parent === null) {
                return parents;
            }

            parents.add(parent);
            parentName = PsiGdInheritanceUtil.getParentName(parent);
        }

        return parents;
    }

    /**
     * Check if is a child of given Class
     */
    fun hasParent(myType: String, lookFor: String, project: Project): Boolean {
        var parentName: String? = myType;

        while (parentName !== null) {
            val parent = PsiGdInheritanceUtil.getPsiFile(parentName, project);
            if (parent === null) {
                return false;
            }

            parentName = PsiGdInheritanceUtil.getParentName(parent);
            if (lookFor == parentName) {
                return true;
            }
        }

        return false;
    }

    fun findLocalDecl(
        element: GdNamedElement,
        containingFile: PsiFile? = null,
    ): PsiElement? {
        // TODO use listLocals?
        val thisName = element.name.orEmpty();
        var parent: PsiElement = element;
        if (containingFile != null && containingFile != element.containingFile) {
            parent = containingFile.lastChild;
        }

        while (true) {
            parent = parent.prevSibling ?: parent.parent ?: return null;
            val match = when (parent) {
                is GdConstDeclSt -> if (parent.name == thisName) parent else null;
                is GdVarDeclSt -> if (parent.name == thisName) parent else null;
                is GdForSt -> if (parent.varNmi.name == thisName) parent.varNmi else null;
                is GdSetDecl -> if (parent.varNmi?.name == thisName) parent.varNmi else null;
                is GdSignalDeclTl -> if (parent.signalIdNmi?.name == thisName) parent.signalIdNmi else null;
                is GdPatternList -> {
                    val bindings = PsiTreeUtil.findChildrenOfType(parent, GdBindingPattern::class.java);
                    val patternMatch = bindings.find {
                        it.varNmi.name == thisName
                    }?.varNmi;
                    parent = PsiTreeUtil.getParentOfType(parent, GdMatchSt::class.java)!!;

                    patternMatch
                };
                is GdMethodDeclTl -> {
                    return parent.paramList?.paramList?.find {
                        it.varNmi.text == thisName
                    }
                };
                else -> null;
            }

            if (match != null) return match;
        }
    }

    fun listLocalDecls(
        element: PsiElement,
    ): MutableList<PsiElement> {
        val list = mutableListOf<PsiElement>();
        var parent: PsiElement = element;
        while (true) {
            parent = parent.prevSibling ?: parent.parent ?: return list;
            when (parent) {
                is GdConstDeclSt, is GdVarDeclSt, is GdForSt, is GdSetDecl, is GdSignalDeclTl -> list.add(parent);
                is GdPatternList -> {
                    list.addAll(PsiTreeUtil.findChildrenOfType(parent, GdBindingPattern::class.java));
                }
                is GdMethodDeclTl -> {
                    list.addAll(parent.paramList?.paramList?.toList() ?: emptyList());
                    return list;
                };
            }
        }
    }

    fun findInParent(
        element: GdNamedElement,
        method: Boolean = true,
        variables: Boolean = true,
        includingSelf: Boolean = false,
        containingFile: PsiFile? = null,
        withLocalScopes: Boolean = true,
    ): PsiElement? {
        val thisName = element.name.orEmpty();

        if (withLocalScopes) {
            val local = this.findLocalDecl(element, containingFile);
            if (local != null) {
                return local;
            }
        }

        val psiFile = containingFile ?: element.containingFile;
        var parentName: String? =
            PsiTreeUtil.getChildOfType(psiFile, GdInheritance::class.java)?.inheritanceName;
        if (includingSelf) {
            lookFor(psiFile.originalFile, thisName, element.project, variables, method)?.let {
                return it
            }
        }

        while (parentName !== null) {
            val parent = PsiGdInheritanceUtil.getPsiFile(parentName, element.project);
            if (parent === null) {
                return null;
            }

            lookFor(parent,
                thisName,
                element.project,
                variables,
                method,
            )?.let {
                return it
            }

            parentName = PsiGdInheritanceUtil.getParentName(parent);
        }

        return null;
    }

    private fun lookFor(
        file: PsiFile,
        thisName: String,
        project: Project,
        variables: Boolean,
        method: Boolean,
    ): PsiElement? {
        if (variables) {
            // Constants
            val parentConst = GdConstDeclIndex.get(thisName, project, GlobalSearchScope.fileScope(file));
            if (!parentConst.isEmpty()) return parentConst.first();

            // Variables
            val parentVar = GdClassVarDeclIndex.get(thisName, project, GlobalSearchScope.fileScope(file));
            if (!parentVar.isEmpty()) return parentVar.first();

            // Signals
            val signalVar = GdSignalDeclIndex.get(thisName, project, GlobalSearchScope.fileScope(file));
            if (!signalVar.isEmpty()) return signalVar.first();

            // Enums
            val enums = PsiTreeUtil.getChildrenOfType(file, GdEnumDeclTl::class.java);
            enums?.forEach {
                val name = PsiGdEnumUtil.name(it);
                if (name != null) {
                    if (name == thisName) {
                        return it;
                    }
                } else {
                    it.enumValueList.forEach { value ->
                        if (value.enumValueNmi.name == thisName) {
                            return value;
                        }
                    }
                }
            }
        }

        if (method) {
            val parentMethod = GdMethodDeclIndex.get(thisName, project, GlobalSearchScope.fileScope(file));
            if (!parentMethod.isEmpty()) {
                return parentMethod.first();
            }
        }

        return null;
    }

    fun setName(element: GdNamedElement, newName: String?): PsiElement {
        // TODO INF u const + signal u param name
        val keyNode = element.node.findChildByType(GdTypes.IDENTIFIER)
        if (keyNode != null) {
            val id = GdElementFactory.identifier(element.project, newName!!)
            element.node.replaceChild(keyNode, id.node)
        }
        return element
    }

    fun getName(element: GdNamedElement): String {
        return element.text;
    }

    fun getNameIdentifier(element: GdNamedIdElement): PsiElement? {
        val keyNode = element.node.findChildByType(GdTypes.IDENTIFIER);
        return keyNode?.psi;
    }

}