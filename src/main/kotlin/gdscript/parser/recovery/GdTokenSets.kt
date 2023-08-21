package gdscript.parser.recovery

import gdscript.psi.GdTypes.*

val END_STMT_SET = arrayOf(SEMICON, NEW_LINE)
val ARG_END = arrayOf(RRBR, *END_STMT_SET)
val TOP_LEVEL = arrayOf(FUNC, CONST, SIGNAL, VAR, ENUM, ANNOTATOR, IDENTIFIER, DEDENT, INDENT,
    REMOTE, REMOTESYNC, MASTER, PUPPET, STATIC, VARARG, CLASS_NAME, CLASS_NAME,
    RRBR, RCBR, RSBR, EXTENDS, CLASS, *END_STMT_SET)
