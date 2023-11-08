package gdscript.parser.expr

import com.intellij.lang.PsiBuilder
import com.intellij.psi.tree.IElementType
import gdscript.psi.GdTypes.*

class GdBitExParser : GdExprBaseParser {

    override val EXPR_TYPE: IElementType = BIT_AND_EX

    companion object {
        lateinit var INSTANCE: GdBitExParser
    }

    constructor(builder: PsiBuilder): super(builder) {
        INSTANCE = this
    }

    override fun parse(optional: Boolean): Boolean {
        val m = mark()
        var ok = true
        ok = ok && mcAnyOfForce(BIT_AND_SIGN, AND, XOR, OR)
        ok = ok && GdExprParser.INSTANCE.parse(false)

        if (ok) m.drop()
        else m.rollbackTo()

        return ok
    }

}
