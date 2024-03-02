package gdscript.refactoring

import com.intellij.lang.refactoring.InlineHandler
import com.intellij.lang.refactoring.InlineHandler.Inliner
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.usageView.UsageInfo
import com.intellij.util.containers.MultiMap
import gdscript.psi.GdMethodDeclTl

class GdInlineHandler : InlineHandler {

    override fun prepareInlineElement(
        element: PsiElement,
        editor: Editor?,
        invokedOnReference: Boolean
    ): InlineHandler.Settings? {
        return null
    }

    override fun removeDefinition(element: PsiElement, settings: InlineHandler.Settings) {
        element.delete()
    }

    override fun createInliner(element: PsiElement, settings: InlineHandler.Settings): Inliner? {
        return object : Inliner {
            override fun getConflicts(reference: PsiReference, referenced: PsiElement): MultiMap<PsiElement, String>? {
                return null
            }

            // multiple return not supported
            // 0 return - inplace
            // 1 return store into var if there is

            // if not reasigned - remove return , but not if there is call... -_-
            // params - replace literals

            override fun inlineUsage(usage: UsageInfo, referenced: PsiElement) {
                if (referenced !is GdMethodDeclTl || referenced.stmtOrSuite == null) return

                usage.element?.replace(referenced.stmtOrSuite!!)
            }

        }
    }

}
