package gdscript.parser.stmt

import com.intellij.lang.PsiBuilder
import gdscript.parser.GdBaseParser
import gdscript.parser.expr.GdExprParser
import gdscript.psi.GdTypes.*

class GdAssignStmtParser : GdBaseParser {

    constructor(builder: PsiBuilder) : super(builder)

    override fun parse(optional: Boolean): Boolean {
        val stmt = mark()
        var ok = GdExprParser.INSTANCE.parse()
        ok = ok && mcAnyOf(ASSIGN_SIGN, EQ, ASSIGN)
        ok = ok && GdExprParser.INSTANCE.parse()
        if (ok) {
            stmt.done(ASSIGN_SIGN)
        } else {
            stmt.rollbackTo()
        }

        return ok
    }

}
