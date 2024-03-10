package gdscript.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity.ERROR
import com.intellij.lang.annotation.HighlightSeverity.WARNING
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.descendantsOfType
import com.intellij.refactoring.suggested.startOffset
import gdscript.psi.GdClassDeclTl
import gdscript.psi.GdFile
import gdscript.psi.GdMethodDeclTl
import gdscript.psi.GdVarNmi
import gdscript.psi.utils.GdInheritanceUtil
import gdscript.utils.PsiElementUtil.psi

/**
 * Checks for uniqueness of variables
 */
class GdVarNmiAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element !is GdVarNmi) return

        val par = findFirstParent(element)
        val shadowDeclaration = findShadowDeclaration(element, par, element.project)

        if (shadowDeclaration != null) {
            var shadowPar = findFirstParent(shadowDeclaration)

            if (par is GdMethodDeclTl) {
                if (par == shadowPar && shadowDeclaration.psi().startOffset < element.psi().startOffset) {
                    // method parameter overriding a parameter inside the same method before the current
                    holder
                        .newAnnotation(ERROR, "[${element.name}] is already defined in method")
                        .range(element.textRange)
                        .create();
                } else if (shadowPar !is GdMethodDeclTl) {
                    // method parameter shadowing a par ameter defined in the class or parent class
                    holder
                        .newAnnotation(WARNING, "[${element.name}] is shadowing an existing variable in ${shadowPar!!.psi().containingFile.name}")
                        .range(element.textRange)
                        .create();
                }
            } else {
                // class parameter overriding parameter with the same name in a parent class
                holder
                    .newAnnotation(ERROR, "[${element.name}] is already defined in ${shadowPar!!.psi().containingFile.name}")
                    .range(element.textRange)
                    .create();
            }
        }
    }

    /**
     * Finds shadowing variable
     */
    private fun findShadowDeclaration(element: GdVarNmi, initialParent: PsiElement?, project: Project): GdVarNmi? {
        var par: PsiElement? = initialParent
        while (par != null) {
            par.descendantsOfType<GdVarNmi>().find { it != element && it.name == element.name }?.let { return it }
            par = GdInheritanceUtil.getExtendedElement(par, project)
        }
        return null
    }

    private fun findFirstParent(element: PsiElement) : PsiElement? {
        return PsiTreeUtil.findFirstParent(element) {
            it is GdClassDeclTl || it is GdMethodDeclTl || it is GdFile
        }
    }
}
