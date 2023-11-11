package gdscript.parser.roots

import com.intellij.lang.PsiBuilder
import gdscript.parser.GdBaseParser
import gdscript.psi.GdTypes.*

class GdInheritanceParser : GdBaseParser {

    constructor(builder: PsiBuilder): super(builder)

    override fun parse(optional: Boolean): Boolean {
        if (!nextTokenIs(EXTENDS)) return optional

        val m = mark()
        var ok = consumeToken(EXTENDS)
        ok = ok && mcAnyOf(INHERITANCE_ID_NM, STRING, IDENTIFIER)
        while (ok && consumeToken(DOT)) {
            ok = mcToken(INHERITANCE_SUB_ID_NM, IDENTIFIER)
        }
        ok = ok && mceEndStmt()
        if (!ok) {
            // TODO
        }
        m.done(INHERITANCE)

        return true
    }

}