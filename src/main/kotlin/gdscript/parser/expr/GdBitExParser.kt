package gdscript.parser.expr

import com.intellij.lang.PsiBuilder
import com.intellij.psi.tree.IElementType
import gdscript.psi.GdTypes.*
import gdscript.utils.PsiBuilderUtil.mcAnyOfForce

object GdBitExParser : GdExprBaseParser {

    override val EXPR_TYPE: IElementType = BIT_AND_EX

    override fun parse(b: PsiBuilder, optional: Boolean): Boolean {
        val m = b.mark()
        var ok = true
        ok = ok && b.mcAnyOfForce(BIT_AND_SIGN, AND, XOR, OR)
        ok = ok && GdExprParser.parse(b, false)

        if (ok) m.drop()
        else m.rollbackTo()

        return ok
    }

}
