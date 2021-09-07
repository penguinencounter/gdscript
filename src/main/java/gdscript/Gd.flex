package gdscript;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import gdscript.psi.GdTokenType;import gdscript.psi.GdTypes;
import java.util.Stack;

%%

%class GdLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%column
%eof{  return;
%eof}

%{
    String oppening = "";
    int lastState = YYINITIAL;
    boolean lineEnded = false;
    boolean enumValEnded = false;
    boolean indented = false;
    int indent = 0;
    Stack<Integer> indentSizes = new Stack<>();
    int yycolumn;

    public IElementType dedentRoot(IElementType type) {
        lineEnded = false;
        if (yycolumn > 0 || indent <= 0 || indentSizes.empty()) {
            return type;
        }

        dedent();
        yypushback(yylength());

        return GdTypes.DEDENT;
    }

    public boolean dedentSpaces() {
        if (indent <= 0 || indentSizes.empty()) { // For EOF rule
            return false;
        }

        indented = false;
        dedent();

        if (indent > yylength()) {
            yypushback(yylength());
        }

        return true;
    }

    private void dedent() {
        indent = Math.max(0, indent - indentSizes.pop());
    }
%}

LETTER = [a-z|A-Z|_]
DIGIT = [0-9]
//STRING_CH = [^\"\r\n\\]
//CHAR_CH = [^'\r\n\\]
//PRINTABLE = [\ -~]
//HEX = [0-9a-f]
FLIT1 = [0-9]+ \. [0-9]*
FLIT2 = \. [0-9]+
FLIT3 = [0-9]+

NEW_LINE = [\r\n]
INDENT = [ \t]+
//WHITE_SPACE = {NEW_LINE} | {INDENT}
IDENTIFIER = {LETTER}({LETTER}|{DIGIT})*
NUMBER = [0-9][0-9_]*(\.[0-9_]+)?
HEX_NUMBER = 0x[0-9_a-f]+
BIN_NUMBER = 0b[01_]+
REAL_NUMBER = {NUMBER}e-[0-9]+

STRING = \"([^\\\"]|\\.)*\"|\'([^\\\"]|\\.)*\'
STRING_MARKER = \"\"\"|\"|\'
STRING_MARKER_REV = [^\"\'\n\r]*
//ML_STRING = \"\"\"([^\\\"]|\\.)*\"|\'([^\\\"]|\\.)*\'\"\"\"

COMMENT = "#"[^\r\n]*(\n|\r|\r\n)?
ANNOTATOR = "@"[a-zA-Z]*
NODE_PATH_LEX = "$"[a-zA-Z0-9_]*

ASSIGN = "+=" | "-=" | "*=" | "/=" | "%=" | "&=" | "|="
TEST_OPERATOR = "<" | ">" | "==" | "!=" | ">=" | "<="
//OPERATOR = "+" | "-" | "*" | "/" | "%" | "^" | "&" | "|"
//    | "<<" | ">>" | "!" | "&&" | "||"

%state AWAIT_NEW_LINE
%state AWAIT_NEW_LINE_ONCE
%state AWAIT_ENUM_SEPARATOR
%xstate STRING

%%

<STRING> {
    // Stringers
    {STRING_MARKER} {
        if (oppening.equals(yytext().toString())) {
            yybegin(lastState);
            return GdTypes.STRING;
        }
    }

    {NEW_LINE} {
        if (!oppening.equals("\"\"\"")) {
            yybegin(lastState);
            return TokenType.BAD_CHARACTER;
        }
    }

    {STRING_MARKER_REV} {
        continue;
    }
}

<AWAIT_ENUM_SEPARATOR> {
    {NEW_LINE}     {
          if (enumValEnded) {
              return TokenType.WHITE_SPACE;
          }
          enumValEnded = true;

          return GdTypes.NEW_LINE;
    }
    {IDENTIFIER} {
          enumValEnded = false;
          return GdTypes.IDENTIFIER;
    }
    "," {
          enumValEnded = true;
          return GdTypes.COMMA;
    }
    "{" {
          enumValEnded = true;
          return GdTypes.LCBR;
    }
    "}" {
          yybegin(AWAIT_NEW_LINE_ONCE);
          enumValEnded = false;
          lineEnded = false;
          return GdTypes.RCBR;
    }
}

<AWAIT_NEW_LINE_ONCE> {
    {NEW_LINE}     {
          yybegin(YYINITIAL);
          if (lineEnded) { // For signal, etc.
              return TokenType.WHITE_SPACE;
          }
          yypushback(yylength());

          return GdTypes.NEW_LINE;
      }
}

<AWAIT_NEW_LINE> {
    {NEW_LINE}     {
          if (!lineEnded) {
              lineEnded = true;
              yypushback(yylength());
              return GdTypes.NEW_LINE;
          }

          return TokenType.WHITE_SPACE;
      }
}

    "extends"      { yybegin(AWAIT_NEW_LINE_ONCE); return dedentRoot(GdTypes.EXTENDS); }
    "class_name"   { yybegin(AWAIT_NEW_LINE_ONCE); return dedentRoot(GdTypes.CLASS_NAME); }
    "tool"         { yybegin(AWAIT_NEW_LINE_ONCE); return dedentRoot(GdTypes.TOOL); }
    "var"          { yybegin(AWAIT_NEW_LINE_ONCE); return dedentRoot(GdTypes.VAR); }
    "const"        { yybegin(AWAIT_NEW_LINE_ONCE); return dedentRoot(GdTypes.CONST); }
    "setget"       { return GdTypes.SETGET; }

    "enum"         { yybegin(AWAIT_ENUM_SEPARATOR); enumValEnded = true; return GdTypes.ENUM; }
    "func"         { yybegin(AWAIT_NEW_LINE); return dedentRoot(GdTypes.FUNC); }
    "pass"         { yybegin(AWAIT_NEW_LINE); return dedentRoot(GdTypes.PASS); }
    "true"         { return dedentRoot(GdTypes.TRUE); }
    "false"        { return dedentRoot(GdTypes.FALSE); }
    "null"         { return dedentRoot(GdTypes.NULL); }
    "int"          { return dedentRoot(GdTypes.INT); }
    "float"        { return dedentRoot(GdTypes.FLOAT); }
    "bool"         { return dedentRoot(GdTypes.BOOL); }
    "String"       { return dedentRoot(GdTypes.STR); }
    "self"         { return dedentRoot(GdTypes.SELF); }
    "continue"     { yybegin(AWAIT_NEW_LINE); return dedentRoot(GdTypes.CONTINUE); }
    "breakpoint"   { yybegin(AWAIT_NEW_LINE); return dedentRoot(GdTypes.BREAKPOINT); }
    "break"        { yybegin(AWAIT_NEW_LINE); return dedentRoot(GdTypes.BREAK); }
    "return"       { yybegin(AWAIT_NEW_LINE); return dedentRoot(GdTypes.RETURN); }
    "void"         { return dedentRoot(GdTypes.VOID); }
    "PI"           { return dedentRoot(GdTypes.PI); }
    "TAU"          { return dedentRoot(GdTypes.TAU); }
    "NAN"          { return dedentRoot(GdTypes.NAN); }
    "INF"          { return dedentRoot(GdTypes.INF); }
    "signal"       { yybegin(AWAIT_NEW_LINE_ONCE); return GdTypes.SIGNAL; }
    "in"           { return dedentRoot(GdTypes.IN); }
    "if"           { return dedentRoot(GdTypes.IF); }
    "else"         { return dedentRoot(GdTypes.ELSE); }
    "elif"         { return dedentRoot(GdTypes.ELIF); }
    "as"           { return dedentRoot(GdTypes.AS); }
    "is"           { return dedentRoot(GdTypes.IS); }
    "while"        { return dedentRoot(GdTypes.WHILE); }
    "for"          { return dedentRoot(GdTypes.FOR); }
    "in"           { return dedentRoot(GdTypes.IN); }
    "match"        { return dedentRoot(GdTypes.MATCH); }
    "assert"       { return dedentRoot(GdTypes.ASSERT); }
    "yield"        { return dedentRoot(GdTypes.YIELD); }
    "preload"      { return dedentRoot(GdTypes.PRELOAD); }

    "*"            { return dedentRoot(GdTypes.MUL); }
    "/"            { return dedentRoot(GdTypes.DIV); }
    "%"            { return dedentRoot(GdTypes.MOD); }
    "+"            { return dedentRoot(GdTypes.PLUS); }
    "-"            { return dedentRoot(GdTypes.MINUS); }
    "++"           { return dedentRoot(GdTypes.PPLUS); }
    "--"           { return dedentRoot(GdTypes.MMINUS); }
    "."            { return dedentRoot(GdTypes.DOT); }
    ","            { return dedentRoot(GdTypes.COMMA); }
    ":"            { return dedentRoot(GdTypes.COLON); }
    ";"            { lineEnded = true; return GdTypes.SEMICON; }
    "!"            { return dedentRoot(GdTypes.NEGATE); }
    "not"          { return dedentRoot(GdTypes.NEGATE); }
    "="            { return dedentRoot(GdTypes.EQ); }
    "->"           { return dedentRoot(GdTypes.RET); }
    ">>"           { return dedentRoot(GdTypes.RBSHIFT); }
    "<<"           { return dedentRoot(GdTypes.LBSHIFT); }
    "("            { return dedentRoot(GdTypes.LRBR); }
    ")"            { return dedentRoot(GdTypes.RRBR); }
    "["            { return dedentRoot(GdTypes.LSBR); }
    "]"            { return dedentRoot(GdTypes.RSBR); }
    "{"            { return dedentRoot(GdTypes.LCBR); }
    "}"            { return dedentRoot(GdTypes.RCBR); }
    "&"            { return dedentRoot(GdTypes.AND); }
    "&&"           { return dedentRoot(GdTypes.ANDAND); }
    "and"          { return dedentRoot(GdTypes.ANDAND); }
    "|"            { return dedentRoot(GdTypes.OR); }
    "||"           { return dedentRoot(GdTypes.OROR); }
    "or"           { return dedentRoot(GdTypes.OROR); }
    "^"            { return dedentRoot(GdTypes.XOR); }
    "~"            { return dedentRoot(GdTypes.NOT); }

    {STRING_MARKER} { oppening = yytext().toString(); lastState = yystate(); yybegin(STRING); }
    {ASSIGN}        { return GdTypes.ASSIGN; }
    {TEST_OPERATOR} { return GdTypes.TEST_OPERATOR; }
    {ANNOTATOR}     { return GdTypes.ANNOTATOR; }
    {NODE_PATH_LEX} { return dedentRoot(GdTypes.NODE_PATH_LEX); }
    {IDENTIFIER}    { return dedentRoot(GdTypes.IDENTIFIER); }
    {REAL_NUMBER}   { return dedentRoot(GdTypes.NUMBER); }
    {NUMBER}        { return dedentRoot(GdTypes.NUMBER); }
    {HEX_NUMBER}    { return dedentRoot(GdTypes.NUMBER); }
    {BIN_NUMBER}    { return dedentRoot(GdTypes.NUMBER); }
    {COMMENT}       { return GdTypes.COMMENT; }

    {INDENT}  {
        if (yycolumn == 0) {
            int spaces = yytext().length();
            if (spaces > indent && !indented) {
                indentSizes.push(spaces - indent);
                indent = spaces;
                yypushback(yylength());
                indented = true;

                return GdTypes.INDENT;
            } else if (indent > spaces) {
                indented = false;
                dedentSpaces();
                return GdTypes.DEDENT;
            }
        }
        indented = false;

        return TokenType.WHITE_SPACE;
    }

    {NEW_LINE}     { return TokenType.WHITE_SPACE; }

<<EOF>> {
    if (yystate() == AWAIT_NEW_LINE && !lineEnded) {
        yybegin(YYINITIAL);
        return GdTypes.NEW_LINE;
    } else if (dedentSpaces()) {
        return GdTypes.DEDENT;
    } else {
        return null;
    }
}

//    "class" { return GdTypes.CLASS; }
//
//    "static" { return GdTypes.STATIC; }
//    "_" { return GdTypes.UNDER; }
//
//    /* Syntax */
//    "?" { return GdTypes.TERNARY; }
//    ".." { return GdTypes.DOTDOT; }

[^] { return GdTypes.BAD_CHARACTER; }