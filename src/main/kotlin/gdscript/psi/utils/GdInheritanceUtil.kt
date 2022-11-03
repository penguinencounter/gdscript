package gdscript.psi.utils

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.util.PsiTreeUtil
import gdscript.index.impl.GdClassIdIndex
import gdscript.index.impl.GdFileResIndex
import gdscript.psi.GdClassDeclTl
import gdscript.psi.GdClassNaming
import gdscript.psi.GdFile
import gdscript.psi.GdInheritance

object GdInheritanceUtil {

    /**
     * Get extended classId
     *
     * @param element: GdClassDeclTL|GdClassNaming|GdFile
     */
    fun getExtendedClassId(element: PsiElement): String {
        return when (element) {
            is GdClassNaming -> element.parentName;
            is GdClassDeclTl -> element.parentName;
            is GdFile -> PsiTreeUtil.getStubChildOfType(element, GdInheritance::class.java)?.inheritancePath.orEmpty();
            else -> getExtendedClassId(PsiGdClassUtil.getParentClassElement(element));
        }
    }

    /**
     * @param element GdClassDeclTL|GdClassNaming|GdFile
     *
     * @return GdClassDeclTL|GdFile
     */
    fun getExtendedElement(element: PsiElement): PsiElement? {
        return getExtendedElement(
            getExtendedClassId(element),
            element.project,
        );
    }

    /**
     * @param classId FQN like MyClass.DataClass or "res://Item.gd"
     *
     * @return GdClassDeclTL|GdFile
     */
    fun getExtendedElement(classId: String, project: Project): PsiElement? {
        val classEl = GdClassIdIndex.getGloballyResolved(classId, project).firstOrNull();
        // Extending directly named class (includes "res://Item.gd".InnerClass)
        if (classEl != null) {
            return if (classEl.parent is GdClassDeclTl) {
                classEl.parent;
            } else {
                classEl.containingFile;
            }
        }

        return null;
        // In case of unnamed "res://Item.gd" check for the resource itself
        val file = GdFileResIndex.getFiles(classId.trim('"'), project).firstOrNull() ?: return null;

        return PsiManager.getInstance(project).findFile(file);
    }

}
