package gdscript.formatter.typedHandler

import com.intellij.codeInsight.AutoPopupController
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.codeInsight.editorActions.TypedHandlerDelegate
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile

// TODO smazat ??
class GdAnnotationTypedHandler : TypedHandlerDelegate() {

    // TODO smazat
    override fun charTyped(c: Char, project: Project, editor: Editor, file: PsiFile): Result {
        if (c == '@') {

        }

        return Result.CONTINUE;
    }

    override fun checkAutoPopup(c: Char, project: Project, editor: Editor, file: PsiFile): Result {
        val offset = editor.caretModel.offset
        if (c == '@') {
            AutoPopupController.getInstance(project).scheduleAutoPopup(editor, CompletionType.BASIC) {
                true
//                val leaf = it.findElementAt(offset - PsiKeyword.NEW.length)
//                leaf is PsiKeyword &&
//                        leaf.textMatches(PsiKeyword.NEW) &&
//                        !psiElement().insideStarting(PsiJavaPatterns.psiExpressionStatement())
//                            .accepts(leaf)
            }

            return Result.STOP;
        }

        return Result.CONTINUE;
    }

}