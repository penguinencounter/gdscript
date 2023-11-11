package gdscript.parser.roots

import com.intellij.lang.PsiBuilder
import gdscript.parser.GdBaseParser
import gdscript.parser.expr.GdLiteralExParser
import gdscript.parser.recovery.GdRecovery
import gdscript.psi.GdTypes.*

class GdAnnotationParser : GdBaseParser {

    constructor(builder: PsiBuilder): super(builder)

    override fun parse(optional: Boolean): Boolean {
        if (!nextTokenIs(ANNOTATOR)) return optional

        val m = mark()
        var ok = markToken(ANNOTATION_TYPE)
        if (ok && nextTokenIs(LRBR)) {
            advance()
            ok = ok && parseParams()
            ok = ok && consumeToken(RRBR)
        }
        GdRecovery.topLevel()

        m.done(ANNOTATION_TL)
        return true
    }

    private fun parseParams(): Boolean {
        val params = mark()

        var ok = GdLiteralExParser.INSTANCE.parseAndMark()
        while (ok && nextTokenIs(COMMA)) {
            ok = GdLiteralExParser.INSTANCE.parseAndMark()
        }
        GdRecovery.argumentList()
        params.done(ANNOTATION_PARAMS)

        return ok
    }

}