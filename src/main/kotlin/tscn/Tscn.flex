package tscn;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import tscn.psi.TscnTokenType;
import tscn.psi.TscnTypes;
import java.util.List;
import java.util.HashMap;
import java.util.Stack;

%%

%class TscnLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

%{
    boolean dataJson = false;
    Character endingChar = '{';
    HashMap<Character, Character> endings = new HashMap<>();
    StringBuilder dataJsonValue = new StringBuilder();

    private List<Character> valueEndingChars(char current) {
        switch (current) {
            case '"':
                return List.of('"');
            case '(':
                return List.of(')');
            case '[':
                return List.of(']');
            default:
                return List.of(' ', ']');
        }
    }

    private boolean valueEndingIncluded(char current) {
        switch (current) {
            case '"':
                return true;
            case '(':
                return true;
            case '[':
                return true;
            default:
                return false;
        }
    }
%}

%init{
    endings.put('{', '}');
    endings.put('"', '"');
%init}

LETTER = [a-z|A-Z_\-0-9]
DIGIT = [0-9]

NEW_LINE = [\r\n]
IDENTIFIER = {LETTER}({LETTER}|{DIGIT}|\/)*

VALUE = [^\r\n]+ // ( \[[^\R]*?\] ) | ( \"[^\R]*?\" ) | ( {LETTER}*\([^\R\]]*?\) ) | ( {LETTER}+[^\(\R\]]+ )
DATA_LINE = [^\r\n]+

WHITE_SPACE = [ \t]+
WHITE_SPACE_ANY = {WHITE_SPACE}|{NEW_LINE}
COMMENT = ";"[^\r\n]*(\n|\r|\r\n)?

%xstate HEADER
%xstate VALUE
%xstate DATA_LINE
%xstate DATA_VALUE

%%

<HEADER> {
    "gd_scene"     { return TscnTypes.GD_SCENE; }
    "ext_resource" { return TscnTypes.EXT_RESOURCE; }
//    "sub_resource" { return TscnTypes.SUB_RESOURCE; }
    "node"         { return TscnTypes.NODE; }
    "connection"   { return TscnTypes.CONNECTION; }
    {IDENTIFIER}   { return TscnTypes.IDENTIFIER; }
    {WHITE_SPACE}  { return TokenType.WHITE_SPACE; }
    "]"            { yybegin(YYINITIAL); return TscnTypes.RSBR; }
    "="            { yybegin(VALUE); return TscnTypes.EQ; }
}

<VALUE> {
    {VALUE}        {
        CharSequence line = yytext();
        Stack<Character> openings = new Stack<>();
        char currentOpening = line.charAt(0);
        List<Character> searchFor = valueEndingChars(currentOpening);
        List<Character> allowedOpening = List.of('"', '(', '[');
        boolean includeEnding = valueEndingIncluded(currentOpening);

        int i = 1;
        for (; i < line.length(); i++) {
            char current = line.charAt(i);
            if (searchFor.contains(current)) {
                if (openings.empty()) {
                    if (includeEnding) {
                       i++;
                    }
                    break;
                } else {
                    currentOpening = openings.pop();
                    includeEnding = valueEndingIncluded(currentOpening);
                    searchFor = valueEndingChars(currentOpening);
                }
            } else if (allowedOpening.contains(current)) {
                openings.push(currentOpening);
                currentOpening = current;
                includeEnding = valueEndingIncluded(currentOpening);
                searchFor = valueEndingChars(currentOpening);
            }
        }

        yypushback(line.length() - i);
        yybegin(HEADER);

        return TscnTypes.VALUE;
    }
}

<DATA_LINE> {
    {IDENTIFIER}   { return TscnTypes.IDENTIFIER; }
    {WHITE_SPACE}  { return TokenType.WHITE_SPACE; }
    "="            { yybegin(DATA_VALUE); return TscnTypes.EQ; }
}

<DATA_VALUE> {
    {WHITE_SPACE_ANY}  {
          if (dataJson) {
              dataJsonValue.append(yytext());
          } else {
              return TokenType.WHITE_SPACE;
          }
    }
    {DATA_LINE}    {
          String text = yytext().toString().trim();
          char firstChar = text.charAt(0);
          char lastChar = text.charAt(text.length() - 1);
          if (dataJson) {
              dataJsonValue.append(yytext());
              if (firstChar == endingChar || lastChar == endingChar) {
                  dataJson = false;
                  yybegin(YYINITIAL);
                  return TscnTypes.VALUE;
              }
              continue;
          } else {
              if (firstChar == '{' || firstChar == '"') {
                  endingChar = endings.get(firstChar);
                  // Check oneliners
                  if (lastChar == endingChar) {
                      yybegin(YYINITIAL);
                      return TscnTypes.VALUE;
                  }

                  dataJson = true;
                  dataJsonValue = new StringBuilder(yytext());
                  continue;
              } else {
                  yybegin(YYINITIAL);
                  return TscnTypes.VALUE;
              }
          }
    }
}

"["                { yybegin(HEADER); return TscnTypes.LSBR; }
{DATA_LINE}        {
                      if (yytext().charAt(0) == '[') {
                          yypushback(yylength() - 1);
                          yybegin(HEADER);

                          return TscnTypes.LSBR;
                      } else {
                          yypushback(yylength() - 1);
                          yybegin(DATA_LINE);

                          continue;
                      }
                   }
{COMMENT}          { return TscnTypes.COMMENT; }
{NEW_LINE}         { return TokenType.WHITE_SPACE; }

<<EOF>> {
    return null;
}

[^] { return TscnTypes.BAD_CHARACTER; }
