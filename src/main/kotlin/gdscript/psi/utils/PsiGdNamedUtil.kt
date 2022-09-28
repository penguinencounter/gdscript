package gdscript.psi.utils

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.refactoring.suggested.startOffset
import gdscript.GdKeywords
import gdscript.index.impl.GdClassNamingIndex
import gdscript.index.impl.GdClassVarDeclIndex
import gdscript.index.impl.GdConstDeclIndex
import gdscript.index.impl.GdMethodDeclIndex
import gdscript.psi.*

object PsiGdNamedUtil {

    /**
     * List all parent Classes
     */
    fun listParents(element: PsiElement): MutableList<GdClassNaming> {
        var parentName: String? =
            PsiTreeUtil.getChildOfType(element.containingFile, GdInheritance::class.java)?.inheritanceName;
        val parents = mutableListOf<GdClassNaming>();

        while (parentName !== null) {
            val parent =
                GdClassNamingIndex.get(parentName, element.project, GlobalSearchScope.allScope(element.project))
                    .firstOrNull();
            if (parent === null) {
                return parents;
            }

            parents.add(parent);
            parentName = parent.parentName;
        }

        return parents;
    }

    /**
     * Check if is a child of given Class
     */
    fun hasParent(myType: String, lookFor: String, project: Project): Boolean {
        var parentName: String? = myType;

        while (parentName !== null) {
            val parent =
                GdClassNamingIndex.get(parentName, project, GlobalSearchScope.allScope(project))
                    .firstOrNull();
            if (parent === null) {
                return false;
            }

            parentName = parent.parentName;
            if (lookFor == parentName) {
                return true;
            }
        }

        return false;
    }

    fun findLocalDecl(
        element: GdNamedElement,
    ): PsiElement? {
        // TODO stejný offset jako dole?
        val thisName = element.name.orEmpty();
        var suited = false;
        var parent = PsiTreeUtil.getParentOfType(element.parent, GdSuite::class.java, GdAttributeEx::class.java, GdCallEx::class.java);
        while (parent != null) {
            if (parent is GdSuite) {
                suited = true;
            } else if (suited) {
                break;
            }
            val locals = PsiTreeUtil.getChildrenOfAnyType(parent, GdVarDeclSt::class.java, GdConstDeclSt::class.java);
            val local = locals.find {
                when (it) {
                    is GdVarDeclSt -> it.name == thisName;
                    is GdConstDeclSt -> it.name== thisName;
                    else -> false
                }
            };
            if (local != null) {
                return local;
            }
            parent = PsiTreeUtil.getParentOfType(parent, GdSuite::class.java, GdAttributeEx::class.java, GdCallEx::class.java);
        }

        return null;
    }

    fun listLocalDecls(
        element: PsiElement,
    ): MutableList<PsiElement> {
        val startOffset = element.textOffset;
        var parent = PsiTreeUtil.getParentOfType(element.parent, GdSuite::class.java, GdAttributeEx::class.java, GdCallEx::class.java);
        val list = mutableListOf<PsiElement>();
        while (parent != null && parent is GdSuite) {
            list.addAll(
                PsiTreeUtil
                    .getChildrenOfAnyType(parent, GdVarDeclSt::class.java, GdConstDeclSt::class.java)
                    .filter { it.startOffset <= startOffset }
            );
            parent = PsiTreeUtil.getParentOfType(parent, GdSuite::class.java, GdAttributeEx::class.java, GdCallEx::class.java);
        }

        return list;
    }

    fun findInParent(
        element: GdNamedElement,
        method: Boolean = true,
        variable: Boolean = true,
        constant: Boolean = true,
        enum: Boolean = true,
        includingSelf: Boolean = false,
        containingFile: PsiFile? = null,
        withLocalScopes: Boolean = true,
    ): PsiElement? {
        val thisName = element.name.orEmpty();

        if (withLocalScopes) {
            val local = this.findLocalDecl(element);
            if (local != null) {
                return local; // TODO tohle rozbije nápovědu
            }
        }

        val psiFile = containingFile ?: element.containingFile;
        var parentName: String? =
            PsiTreeUtil.getChildOfType(psiFile, GdInheritance::class.java)?.inheritanceName;
        if (includingSelf) {
            lookFor(psiFile.originalFile, thisName, element.project, constant, variable, method, enum)?.let {
                return it
            }
        }

        while (parentName !== null) {
            val parent =
                GdClassNamingIndex.get(parentName, element.project, GlobalSearchScope.allScope(element.project))
                    .firstOrNull();
            if (parent === null) {
                return null;
            }

            lookFor(parent.containingFile.originalFile,
                thisName,
                element.project,
                constant,
                variable,
                method,
                enum)?.let {
                return it
            }

            parentName = parent.parentName;
        }

        return null;
    }

    private fun lookFor(
        file: PsiFile,
        thisName: String,
        project: Project,
        constant: Boolean,
        variable: Boolean,
        method: Boolean,
        enum: Boolean,
    ): PsiElement? {
        if (constant) {
            val parentConst = GdConstDeclIndex.get(thisName, project, GlobalSearchScope.fileScope(file));
            if (!parentConst.isEmpty()) {
                return parentConst.first();
            }
        }

        if (variable) {
            val parentVar = GdClassVarDeclIndex.get(thisName, project, GlobalSearchScope.fileScope(file));
            if (!parentVar.isEmpty()) {
                return parentVar.first();
            }
        }

        if (method) {
            val parentMethod = GdMethodDeclIndex.get(thisName, project, GlobalSearchScope.fileScope(file));
            if (!parentMethod.isEmpty()) {
                return parentMethod.first();
            }
        }

        if (enum) {
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