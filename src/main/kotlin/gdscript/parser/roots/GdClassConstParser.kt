package gdscript.parser.roots

import com.intellij.lang.PsiBuilder
import gdscript.parser.GdBaseParser
import gdscript.parser.common.GdTypedParser
import gdscript.parser.expr.GdExprParser
import gdscript.parser.recovery.GdRecovery
import gdscript.psi.GdTypes.*

class GdClassConstParser : GdBaseParser {

    constructor(builder: PsiBuilder): super(builder)

    override fun parse(optional: Boolean): Boolean {
        if (!nextTokenIs(CONST)) return optional

        val m = mark()
        advance() // const
        var ok = mceIdentifier(VAR_NMI)
        ok = ok && GdTypedParser.INSTANCE.parse(true)
        ok = ok && mcAnyOf(ASSIGN_TYPED, EQ, CEQ)
        ok = ok && GdExprParser.INSTANCE.parse()
        ok && mcEndStmt()

        GdRecovery.topLevel()
        m.done(CONST_DECL_TL)

        return true
    }

}
