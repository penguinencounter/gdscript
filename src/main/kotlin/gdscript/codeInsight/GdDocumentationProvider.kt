package gdscript.codeInsight

import com.intellij.lang.documentation.AbstractDocumentationProvider
import com.intellij.lang.documentation.DocumentationMarkup
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import gdscript.index.impl.GdClassNamingIndex
import gdscript.psi.*
import gdscript.psi.utils.PsiGdCommentUtils
import gdscript.reference.GdClassMemberReference

class GdDocumentationProvider : AbstractDocumentationProvider() {

    override fun generateDoc(element: PsiElement, originalElement: PsiElement?): String? {
        if (originalElement != null && originalElement.parent is PsiNamedElement) {
            return findDocumentationComment(originalElement.parent as PsiNamedElement, PsiGdCommentUtils.DESCRIPTION);
        }

        return null;
    }

    override fun generateHoverDoc(element: PsiElement, originalElement: PsiElement?): String? {
        if (originalElement != null && originalElement.parent is PsiNamedElement) {
            val doc = findDocumentationComment(originalElement.parent as PsiNamedElement, PsiGdCommentUtils.BRIEF_DESCRIPTION);
            if (doc != null && doc.isNotEmpty()) {
                return doc;
            }

            return findDocumentationComment(originalElement.parent as PsiNamedElement, PsiGdCommentUtils.DESCRIPTION);
        }

        return null;
    }

    private fun findDocumentationComment(property: PsiNamedElement, key: String): String? {
        var declaration = GdClassMemberReference(property).resolveDeclaration();
        if (declaration == null) {
            declaration = GdClassNamingIndex.getGlobally(property)
                .firstOrNull() ?: return null;
        }

        val comments = PsiGdCommentUtils.collectDescriptions(declaration, key);

        return renderFullDoc(comments);
    }

    private fun renderFullDoc(docLines: Array<String>): String {
        val sb = StringBuilder();

        docLines.forEach {
            val line = it
                .replace("[b]", "<strong>")
                .replace("[/b]", "</strong>")
                .replace("[code]", "<i>")
                .replace("[/code]", "</i>")
                .replace("[codeblocks]", DocumentationMarkup.DEFINITION_START)
                .replace("[/codeblocks]", DocumentationMarkup.DEFINITION_END)

                .replace("[gdscript]", "${DocumentationMarkup.CONTENT_START}<strong>GdScript</strong>")
                .replace("[csharp]", "${DocumentationMarkup.CONTENT_START}<strong>C#</strong>")
                .replace("[/gdscript]", DocumentationMarkup.CONTENT_END)
                .replace("[/csharp]", DocumentationMarkup.CONTENT_END)

            sb.append(line);
            sb.append("<br />");
        }

        return sb.toString();
    }

}
