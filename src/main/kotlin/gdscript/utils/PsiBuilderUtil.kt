package gdscript.utils

object PsiBuilderUtil {

//    fun PsiBuilder.consumeAnyOfToken(force: Boolean, vararg elementTypes: IElementType): Boolean {
//        if (nextTokenIs(*elementTypes)) {
//            advanceLexer()
//            return true
//        } else if (force) {
//            val m = mark()
//            val err = "expected ${elementTypes[0]}, got $tokenText"
//            advanceLexer()
//            m.error(err)
//            return false
//        }
//
//        return false
//    }
//
//    fun PsiBuilder.mcToken(markToken: IElementType, vararg elementTypes: IElementType): Boolean {
//        if (nextTokenIs(*elementTypes)) {
//            return markToken(markToken)
//        } else {
//            val m = mark()
//            advanceLexer()
//            m.error("expected [$elementTypes]")
//        }
//
//        return false
//    }
//
//    fun PsiBuilder.mcAnyOfForce(markElement: IElementType, vararg elementTypes: IElementType): Boolean {
//        if (!mcAnyOf(markElement, *elementTypes)) {
//            markError("expected [$elementTypes]")
//            return false
//        }
//
//        return true
//    }
//
//    fun PsiBuilder.markToken(markType: IElementType, steps: Int = 1): Boolean {
//        val m = mark()
//        repeat(steps) { advanceLexer() }
//        m.done(markType)
//
//        return true
//    }
//
//    fun PsiBuilder.consumeNewLine() {
//        if (nextTokenIs(GdTypes.NEW_LINE)) {
//            remapCurrentToken(TokenType.WHITE_SPACE)
//            advanceLexer()
//        }
//    }
//
//    fun PsiBuilder.ensureNextTokenIs(vararg elementTypes: IElementType): Boolean {
//        val searchFor = tokenType
//        if (elementTypes.none { it == searchFor }) {
//            val m = mark()
//            advanceLexer()
//            m.error("${elementTypes.first()} expected, got $tokenText")
//
//            return false
//        }
//
//        return true
//    }
//
//    /** CHECKERS **/
//
//    fun PsiBuilder.followingTokensAre(vararg elementTypes: IElementType): Boolean {
//        var step = 0
//
//        return elementTypes.all {
//            it == lookAhead(step++)
//        }
//    }

}
