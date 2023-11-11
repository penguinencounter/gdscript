package gdscript.parser.stmt

import com.intellij.lang.PsiBuilder
import com.intellij.psi.tree.IElementType
import gdscript.parser.expr.GdExprParser
import gdscript.psi.GdTypes.EXPR_ST

class GdExStmtParser : GdStmtBaseParser {

    override val STMT_TYPE: IElementType = EXPR_ST
    override val endWithEndStmt: Boolean = true

    constructor(builder: PsiBuilder) : super(builder)

    override fun parse(optional: Boolean): Boolean {
        var ok = true
        ok = ok && GdExprParser.INSTANCE.parse()

        return ok
    }

}