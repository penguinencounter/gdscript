package gdscript.parser.expr

import com.intellij.lang.PsiBuilder
import com.intellij.psi.tree.IElementType
import gdscript.psi.GdTypes.*
import gdscript.utils.PsiBuilderUtil.mcAnyOfForce

class GdPlusExParser : GdExprBaseParser {

    override val EXPR_TYPE: IElementType = PLUS_EX

    companion object {
        lateinit var INSTANCE: GdPlusExParser
    }

    constructor() {
        INSTANCE = this
    }

    override fun parse(b: PsiBuilder, optional: Boolean): Boolean {
        val m = b.mark()
        var ok = true
        ok = ok && b.mcAnyOfForce(SIGN, PLUS, MINUS)
        ok = ok && GdExprParser.INSTANCE.parse(b, false)

        if (ok) m.drop()
        else m.rollbackTo()

        return ok
    }

}
