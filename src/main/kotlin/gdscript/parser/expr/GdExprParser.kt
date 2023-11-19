package gdscript.parser.expr

import com.intellij.lang.PsiBuilder
import com.intellij.psi.tree.IElementType
import gdscript.parser.GdBaseParser
import gdscript.psi.GdTypes.EXPR

object GdExprParser : GdBaseParser {

    val parsers = mutableListOf<GdExprBaseParser>()
    val leftLeadParsers = mutableListOf<GdExprBaseParser>()

    init {
        parsers.add(GdFuncDeclExParser)
        parsers.add(GdNegateExParser)
        parsers.add(GdAwaitExParser)
        parsers.add(GdPlusExParser)
        parsers.add(GdBitNotExParser)
        parsers.add(GdPrimaryExParser)
        parsers.add(GdLiteralExParser)

        leftLeadParsers.add(GdArrayExParser)
        leftLeadParsers.add(GdCastExParser)
        leftLeadParsers.add(GdTernaryExParser)
        leftLeadParsers.add(GdLogicExParser)
        leftLeadParsers.add(GdInExParser)
        leftLeadParsers.add(GdComparisonExParser)
        leftLeadParsers.add(GdBitExParser)
        leftLeadParsers.add(GdShiftExParser)
        leftLeadParsers.add(GdPlusExParser)
        leftLeadParsers.add(GdFactorExParser)
        leftLeadParsers.add(GdIsExParser)
        leftLeadParsers.add(GdAttributeExParser)
        leftLeadParsers.add(GdCallExParser)
    }

    override fun parse(b: PsiBuilder, optional: Boolean): Boolean {
        var left = b.mark()
        var leftType: IElementType = EXPR

        if (
            !parsers.any {
                leftType = it.EXPR_TYPE
                it.parse(b)
            }
        ) {
            left.drop()
            return optional
        }

        left.done(leftType)
        left = left.precede()
        var rightType: IElementType = EXPR
        while (
            leftLeadParsers.any {
                rightType = it.EXPR_TYPE
                it.parse(b)
            }
        ) {
            left.done(rightType)
            left = left.precede()
        }

        left.drop()

        return true
    }
}
