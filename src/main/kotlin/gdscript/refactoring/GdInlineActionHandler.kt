package gdscript.refactoring

import com.intellij.lang.Language
import com.intellij.lang.refactoring.InlineActionHandler
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.search.GlobalSearchScope.FilesScope
import com.intellij.psi.search.searches.ReferencesSearch
import gdscript.GdLanguage
import gdscript.psi.GdMethodIdNmi

class GdInlineActionHandler : InlineActionHandler() {

    override fun isEnabledForLanguage(l: Language?): Boolean {
        return l == GdLanguage
    }

    override fun canInlineElement(element: PsiElement?): Boolean {
        return element is GdMethodIdNmi
    }

    override fun inlineElement(project: Project?, editor: Editor?, element: PsiElement?) {
        if (project == null || editor == null || element == null) return

        val offset = editor.caretModel.offset
        val targetReference =
            ReferencesSearch.search(element, FilesScope.fileScope(project, element.containingFile.virtualFile)).find {
                it.element.textRange.contains(offset)
            } ?: return

        val dialog = GdInlineOptionsDialog(project, element as GdMethodIdNmi, targetReference)
        dialog.show()
    }

}
