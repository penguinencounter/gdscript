package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.patterns.PsiJavaPatterns.psiElement
import gdscript.completion.util.GdLiteralCompletionUtil
import gdscript.psi.GdRefIdNm
import gdscript.psi.GdTyped
import gdscript.psi.GdTypes

class GdTypeHintCompletionContributor : CompletionContributor() {

    val TYPED = psiElement().afterLeaf(psiElement().withText(":"))
        .withSuperParent(2, GdTyped::class.java);
    val REF_ID = psiElement().withParent(GdRefIdNm::class.java)

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        if (TYPED.accepts(parameters.position)) {
            GdLiteralCompletionUtil.builtInTypes(result);
        } else if (REF_ID.accepts(parameters.position)) {
            GdLiteralCompletionUtil.builtIns(result);
        }

    }

}