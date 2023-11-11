package gdscript.parser.common

import com.intellij.lang.PsiBuilder
import gdscript.parser.GdBaseParser
import gdscript.parser.expr.GdExprParser
import gdscript.psi.GdTypes.*

class GdTypedParser : GdBaseParser {

    companion object {
        lateinit var INSTANCE: GdTypedParser
    }

    constructor(builder: PsiBuilder): super(builder) {
        INSTANCE = this
    }

    override fun parse(optional: Boolean): Boolean {
        if (!nextTokenIs(COLON)) return optional

        var ok = true
        val typed = mark()
        advance() // Colon

        ok = ok && typedVal(false)

        if (ok) {
            typed.done(TYPED)
        } else {
            typed.rollbackTo()
        }

        return true
    }

    fun parseWithAssignTypedAndExpr(optional: Boolean): Boolean {
        var ok = true
        if (nextTokenIs(CEQ)) {
            ok = ok && mcAnyOf(ASSIGN_TYPED, CEQ)
            ok = ok && GdExprParser.INSTANCE.parse()
        } else if (nextTokenIs(COLON)) {
            ok = ok && parse(optional)
            if (ok && mcAnyOf(ASSIGN_TYPED, EQ)) {
                ok = ok && GdExprParser.INSTANCE.parse()
            }
        } else if (mcAnyOf(ASSIGN_TYPED, EQ)) {
            ok = ok && GdExprParser.INSTANCE.parse()
        } else if (!optional) {
            return false
        }

        return true
    }

    fun typedVal(optional: Boolean): Boolean {
        val typedVal = mark()

        var ok = parseTypeHint()
        if (ok && nextTokenIs(LSBR)) {
            advance()
            ok = parseTypeHint()
            ensureNextTokenIs(RSBR)
        }

        if (ok) typedVal.done(TYPED_VAL)
        else typedVal.rollbackTo()

        return ok || optional
    }

    private fun parseTypeHint(): Boolean {
        if (!nextTokenIs(IDENTIFIER)) return false

        val hint = mark()

        var ok = mceIdentifier(TYPE_HINT_NM)
        while (ok && nextTokenIs(DOT)) {
            advance()
            ok = mceIdentifier(TYPE_HINT_NM)
        }

        hint.done(TYPE_HINT)

        return true
    }

}