package gdscript.psi.utils

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import gdscript.index.impl.GdClassIdIndex
import gdscript.index.impl.GdFileResIndex
import gdscript.psi.GdClassDeclTl
import gdscript.psi.GdClassNaming
import gdscript.psi.GdFile
import gdscript.utils.VirtualFileUtil.getPsiFile
import gdscript.utils.VirtualFileUtil.resourcePath

object GdClassUtil {

    fun getClassIdElement(name: String, project: Project): PsiElement? {
        return GdClassIdIndex.INSTANCE.getGloballyResolved(name, project).firstOrNull()
            ?: GdFileResIndex.INSTANCE.getFiles(name.trim('"'), project).firstOrNull()
                ?.let { return it.getPsiFile(project) }
    }

    fun getClassIdElement(name: String, element: PsiElement): PsiElement? {
        return getClassIdElement(name, element.project)
    }

    /**
     * @param element current element
     *
     * @return String owning className (resource if not named)
     */
    fun getOwningClassName(element: PsiElement): String {
        return when (val it = getOwningClassElement(element)) {
            is GdClassDeclTl -> it.name;
            else -> {
                val cln = PsiTreeUtil.getStubChildOfType(it, GdClassNaming::class.java);
                if (cln != null) return cln.classname;

                (element.containingFile.virtualFile ?: element.containingFile.originalFile.virtualFile)
                    .resourcePath();
            }
        }
    }

    /**
     * @param element GdClassDecl|GdFile
     * @return Full classId to given class "Class.Inner" (can be resource)
     */
    fun getFullClassId(element: PsiElement): String {
        return when (element) {
            is GdClassDeclTl -> element.classNameNmi?.classId ?: ""
            is GdFile -> {
                val named = PsiTreeUtil.getStubChildOfType(element, GdClassNaming::class.java);
                if (named != null) {
                    named.classNameNmi?.classId ?: ""
                } else {
                    val file = element.virtualFile ?: element.originalFile.virtualFile;
                    "\"${PsiGdResourceUtil.resourcePath(file)}\""
                }
            }

            else -> getFullClassId(getOwningClassElement(element))
        }
    }

    /**
     * @return GdClassDecl|GdFile containing element
     */
    fun getOwningClassElement(element: PsiElement): PsiElement {
        val inner = PsiTreeUtil.getStubOrPsiParentOfType(element, GdClassDeclTl::class.java);
        if (inner != null) return inner

        return element.containingFile
    }

    fun getName(element: GdClassDeclTl): String {
        val stub = element.stub;
        if (stub != null) return stub.name();

        return element.classNameNmi?.name.orEmpty();
    }

}
