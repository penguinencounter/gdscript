package gdscript.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import gdscript.GdKeywords
import gdscript.highlighter.GdHighlighterColors
import gdscript.psi.GdTypeHint
import gdscript.psi.GdTypeHintNm
import gdscript.utils.PsiFileUtil.isInSdk
import gdscript.utils.PsiReferenceUtil.resolveRef

/**
 * Checks that given return type is valid (built-in or Class)
 */
class GdTypeHintAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element !is GdTypeHint) return
        val typeHints = element.typeHintNmList

        if (invalidType(typeHints.last())) {
            holder
                .newAnnotation(HighlightSeverity.ERROR, "Invalid type")
                .range(element.textRange)
                .create()
            return
        }

        // color all type hints
        typeHints.forEach{ colorTypeHints(it, holder)}
    }

    private fun invalidType(element: GdTypeHintNm) : Boolean {
        // don't spend time on resolving builtin types
        if (GdKeywords.BUILT_TYPES.contains(element.name)) return false
        return element.resolveRef() == null
    }

    private fun colorTypeHints(element: GdTypeHintNm, holder: AnnotationHolder) {
        var color = GdHighlighterColors.CLASS_TYPE
        if (GdKeywords.BUILT_TYPES.contains(element.name)) {
            color = GdHighlighterColors.BASE_TYPE
        } else if (element.resolveRef()?.containingFile?.isInSdk() == true) {
            color = GdHighlighterColors.ENGINE_TYPE
        }

        holder
            .newSilentAnnotation(HighlightSeverity.INFORMATION)
            .range(element.textRange)
            .textAttributes(color)
            .create()
    }

}
