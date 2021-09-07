// This is a generated file. Not intended for manual editing.
package gdscript.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static gdscript.psi.GdTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class GdParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return gdfile(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(CLASS_VAR_DECL_TL, CONST_DECL_TL, ENUM_DECL_TL, METHOD_DECL_TL,
      SIGNAL_DECL_TL, TOP_LEVEL_DECL),
    create_token_set_(ASSERT_ST, ASSIGN_ST, EXPR_ST, FLOW_ST,
      FOR_ST, IF_ST, MATCH_ST, PRELOAD_ST,
      STMT, VAR_DECL_ST, WHILE_ST, YIELD_ST),
    create_token_set_(ARR_EX, ATTRIBUTE_EX, BIT_AND_EX, BIT_NOT_EX,
      CALL_EX, CAST_EX, COMPARISON_EX, EXPR,
      FACTOR_EX, IN_EX, IS_EX, LITERAL_EX,
      LOGIC_EX, NEGATE_EX, PLUS_EX, PLUS_MINUS_EX,
      PLUS_MINUS_PRE_EX, PRIMARY_EX, SHIFT_EX, SIGN_EX,
      TERNARY_EX),
  };

  /* ********************************************************** */
  // ANNOTATOR
  public static boolean annotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation")) return false;
    if (!nextTokenIs(b, ANNOTATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ANNOTATOR);
    exit_section_(b, m, ANNOTATION, r);
    return r;
  }

  /* ********************************************************** */
  // expr (COMMA expr)*
  public static boolean argList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARG_LIST, "<arg list>");
    r = expr(b, l + 1, -1);
    r = r && argList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA expr)*
  private static boolean argList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "argList_1", c)) break;
    }
    return true;
  }

  // COMMA expr
  private static boolean argList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LSBR (expr (COMMA expr)* COMMA?)? RSBR
  public static boolean arrayDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayDecl")) return false;
    if (!nextTokenIs(b, LSBR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LSBR);
    r = r && arrayDecl_1(b, l + 1);
    r = r && consumeToken(b, RSBR);
    exit_section_(b, m, ARRAY_DECL, r);
    return r;
  }

  // (expr (COMMA expr)* COMMA?)?
  private static boolean arrayDecl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayDecl_1")) return false;
    arrayDecl_1_0(b, l + 1);
    return true;
  }

  // expr (COMMA expr)* COMMA?
  private static boolean arrayDecl_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayDecl_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr(b, l + 1, -1);
    r = r && arrayDecl_1_0_1(b, l + 1);
    r = r && arrayDecl_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA expr)*
  private static boolean arrayDecl_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayDecl_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!arrayDecl_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arrayDecl_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA expr
  private static boolean arrayDecl_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayDecl_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean arrayDecl_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayDecl_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // ASSERT LRBR expr (COMMA STRING)? RRBR endStmt
  public static boolean assert_st(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assert_st")) return false;
    if (!nextTokenIsFast(b, ASSERT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ASSERT, LRBR);
    r = r && expr(b, l + 1, -1);
    r = r && assert_st_3(b, l + 1);
    r = r && consumeToken(b, RRBR);
    r = r && endStmt(b, l + 1);
    exit_section_(b, m, ASSERT_ST, r);
    return r;
  }

  // (COMMA STRING)?
  private static boolean assert_st_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assert_st_3")) return false;
    assert_st_3_0(b, l + 1);
    return true;
  }

  // COMMA STRING
  private static boolean assert_st_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assert_st_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, STRING);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expr (EQ | ASSIGN) expr endStmt
  public static boolean assign_st(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_st")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGN_ST, "<assign st>");
    r = expr(b, l + 1, -1);
    r = r && assign_st_1(b, l + 1);
    r = r && expr(b, l + 1, -1);
    r = r && endStmt(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // EQ | ASSIGN
  private static boolean assign_st_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_st_1")) return false;
    boolean r;
    r = consumeTokenFast(b, EQ);
    if (!r) r = consumeTokenFast(b, ASSIGN);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean attEx_nm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attEx_nm")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, ATT_EX_NM, r);
    return r;
  }

  /* ********************************************************** */
  // INT | STR | FLOAT | BOOL
  public static boolean builtInType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtInType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BUILT_IN_TYPE, "<built in type>");
    r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, STR);
    if (!r) r = consumeToken(b, FLOAT);
    if (!r) r = consumeToken(b, BOOL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean className_nm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "className_nm")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, CLASS_NAME_NM, r);
    return r;
  }

  /* ********************************************************** */
  // CLASS_NAME className_nm (COMMA STRING)? newLineEnd
  public static boolean classNaming(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classNaming")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CLASS_NAMING, "<class naming>");
    r = consumeToken(b, CLASS_NAME);
    p = r; // pin = 1
    r = r && report_error_(b, className_nm(b, l + 1));
    r = p && report_error_(b, classNaming_2(b, l + 1)) && r;
    r = p && newLineEnd(b, l + 1) && r;
    exit_section_(b, l, m, r, p, GdParser::classNaming_r);
    return r || p;
  }

  // (COMMA STRING)?
  private static boolean classNaming_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classNaming_2")) return false;
    classNaming_2_0(b, l + 1);
    return true;
  }

  // COMMA STRING
  private static boolean classNaming_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classNaming_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, STRING);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !(TOOL) & topLevelDecl_r
  static boolean classNaming_r(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classNaming_r")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = classNaming_r_0(b, l + 1);
    r = r && classNaming_r_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(TOOL)
  private static boolean classNaming_r_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classNaming_r_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, TOOL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // & topLevelDecl_r
  private static boolean classNaming_r_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classNaming_r_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = topLevelDecl_r(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // annotation* VAR classVarId_nmi typed? (EQ expr)? setgetDecl? endStmt
  public static boolean classVarDecl_tl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classVarDecl_tl")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CLASS_VAR_DECL_TL, "<class var decl tl>");
    r = classVarDecl_tl_0(b, l + 1);
    r = r && consumeToken(b, VAR);
    p = r; // pin = 2
    r = r && report_error_(b, classVarId_nmi(b, l + 1));
    r = p && report_error_(b, classVarDecl_tl_3(b, l + 1)) && r;
    r = p && report_error_(b, classVarDecl_tl_4(b, l + 1)) && r;
    r = p && report_error_(b, classVarDecl_tl_5(b, l + 1)) && r;
    r = p && endStmt(b, l + 1) && r;
    exit_section_(b, l, m, r, p, GdParser::topLevelDecl_r);
    return r || p;
  }

  // annotation*
  private static boolean classVarDecl_tl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classVarDecl_tl_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!annotation(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "classVarDecl_tl_0", c)) break;
    }
    return true;
  }

  // typed?
  private static boolean classVarDecl_tl_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classVarDecl_tl_3")) return false;
    typed(b, l + 1);
    return true;
  }

  // (EQ expr)?
  private static boolean classVarDecl_tl_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classVarDecl_tl_4")) return false;
    classVarDecl_tl_4_0(b, l + 1);
    return true;
  }

  // EQ expr
  private static boolean classVarDecl_tl_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classVarDecl_tl_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, EQ);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // setgetDecl?
  private static boolean classVarDecl_tl_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classVarDecl_tl_5")) return false;
    setgetDecl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean classVarId_nmi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classVarId_nmi")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, CLASS_VAR_ID_NMI, r);
    return r;
  }

  /* ********************************************************** */
  // CONST constId_nmi typed? EQ expr endStmt
  public static boolean constDecl_tl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constDecl_tl")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONST_DECL_TL, "<const decl tl>");
    r = consumeTokenFast(b, CONST);
    p = r; // pin = 1
    r = r && report_error_(b, constId_nmi(b, l + 1));
    r = p && report_error_(b, constDecl_tl_2(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, EQ)) && r;
    r = p && report_error_(b, expr(b, l + 1, -1)) && r;
    r = p && endStmt(b, l + 1) && r;
    exit_section_(b, l, m, r, p, GdParser::topLevelDecl_r);
    return r || p;
  }

  // typed?
  private static boolean constDecl_tl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constDecl_tl_2")) return false;
    typed(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean constId_nmi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constId_nmi")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, CONST_ID_NMI, r);
    return r;
  }

  /* ********************************************************** */
  // LCBR (keyValue (COMMA keyValue)* COMMA?)? RCBR
  public static boolean dictDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictDecl")) return false;
    if (!nextTokenIs(b, LCBR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LCBR);
    r = r && dictDecl_1(b, l + 1);
    r = r && consumeToken(b, RCBR);
    exit_section_(b, m, DICT_DECL, r);
    return r;
  }

  // (keyValue (COMMA keyValue)* COMMA?)?
  private static boolean dictDecl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictDecl_1")) return false;
    dictDecl_1_0(b, l + 1);
    return true;
  }

  // keyValue (COMMA keyValue)* COMMA?
  private static boolean dictDecl_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictDecl_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = keyValue(b, l + 1);
    r = r && dictDecl_1_0_1(b, l + 1);
    r = r && dictDecl_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA keyValue)*
  private static boolean dictDecl_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictDecl_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!dictDecl_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "dictDecl_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA keyValue
  private static boolean dictDecl_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictDecl_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && keyValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean dictDecl_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictDecl_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // SEMICON | newLineEnd
  public static boolean endStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "endStmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, END_STMT, "<end stmt>");
    r = consumeToken(b, SEMICON);
    if (!r) r = newLineEnd(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean enumDecl_nmi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumDecl_nmi")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, ENUM_DECL_NMI, r);
    return r;
  }

  /* ********************************************************** */
  // ENUM enumDecl_nmi? LCBR enumValue ((COMMA | NEW_LINE) enumValue)* (COMMA | NEW_LINE)? RCBR endStmt
  public static boolean enumDecl_tl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumDecl_tl")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ENUM_DECL_TL, "<enum decl tl>");
    r = consumeTokenFast(b, ENUM);
    p = r; // pin = 1
    r = r && report_error_(b, enumDecl_tl_1(b, l + 1));
    r = p && report_error_(b, consumeToken(b, LCBR)) && r;
    r = p && report_error_(b, enumValue(b, l + 1)) && r;
    r = p && report_error_(b, enumDecl_tl_4(b, l + 1)) && r;
    r = p && report_error_(b, enumDecl_tl_5(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RCBR)) && r;
    r = p && endStmt(b, l + 1) && r;
    exit_section_(b, l, m, r, p, GdParser::topLevelDecl_r);
    return r || p;
  }

  // enumDecl_nmi?
  private static boolean enumDecl_tl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumDecl_tl_1")) return false;
    enumDecl_nmi(b, l + 1);
    return true;
  }

  // ((COMMA | NEW_LINE) enumValue)*
  private static boolean enumDecl_tl_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumDecl_tl_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!enumDecl_tl_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enumDecl_tl_4", c)) break;
    }
    return true;
  }

  // (COMMA | NEW_LINE) enumValue
  private static boolean enumDecl_tl_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumDecl_tl_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = enumDecl_tl_4_0_0(b, l + 1);
    r = r && enumValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA | NEW_LINE
  private static boolean enumDecl_tl_4_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumDecl_tl_4_0_0")) return false;
    boolean r;
    r = consumeTokenFast(b, COMMA);
    if (!r) r = consumeTokenFast(b, NEW_LINE);
    return r;
  }

  // (COMMA | NEW_LINE)?
  private static boolean enumDecl_tl_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumDecl_tl_5")) return false;
    enumDecl_tl_5_0(b, l + 1);
    return true;
  }

  // COMMA | NEW_LINE
  private static boolean enumDecl_tl_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumDecl_tl_5_0")) return false;
    boolean r;
    r = consumeTokenFast(b, COMMA);
    if (!r) r = consumeTokenFast(b, NEW_LINE);
    return r;
  }

  /* ********************************************************** */
  // enumValue_nmi (EQ NUMBER)?
  public static boolean enumValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumValue")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = enumValue_nmi(b, l + 1);
    r = r && enumValue_1(b, l + 1);
    exit_section_(b, m, ENUM_VALUE, r);
    return r;
  }

  // (EQ NUMBER)?
  private static boolean enumValue_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumValue_1")) return false;
    enumValue_1_0(b, l + 1);
    return true;
  }

  // EQ NUMBER
  private static boolean enumValue_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumValue_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, EQ, NUMBER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean enumValue_nmi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumValue_nmi")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, ENUM_VALUE_NMI, r);
    return r;
  }

  /* ********************************************************** */
  // expr endStmt
  public static boolean expr_st(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_st")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, EXPR_ST, "<expr st>");
    r = expr(b, l + 1, -1);
    p = r; // pin = 1
    r = r && endStmt(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // (CONTINUE endStmt)
  //     | (BREAK endStmt)
  //     | (PASS endStmt)
  //     | (BREAKPOINT endStmt)
  //     | returnStmt
  public static boolean flow_st(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flow_st")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FLOW_ST, "<flow st>");
    r = flow_st_0(b, l + 1);
    if (!r) r = flow_st_1(b, l + 1);
    if (!r) r = flow_st_2(b, l + 1);
    if (!r) r = flow_st_3(b, l + 1);
    if (!r) r = returnStmt(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // CONTINUE endStmt
  private static boolean flow_st_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flow_st_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, CONTINUE);
    r = r && endStmt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // BREAK endStmt
  private static boolean flow_st_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flow_st_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, BREAK);
    r = r && endStmt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // PASS endStmt
  private static boolean flow_st_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flow_st_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, PASS);
    r = r && endStmt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // BREAKPOINT endStmt
  private static boolean flow_st_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flow_st_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, BREAKPOINT);
    r = r && endStmt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FOR var_nmi IN expr COLON stmtOrSuite
  public static boolean for_st(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_st")) return false;
    if (!nextTokenIsFast(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, FOR);
    r = r && var_nmi(b, l + 1);
    r = r && consumeToken(b, IN);
    r = r && expr(b, l + 1, -1);
    r = r && consumeToken(b, COLON);
    r = r && stmtOrSuite(b, l + 1);
    exit_section_(b, m, FOR_ST, r);
    return r;
  }

  /* ********************************************************** */
  // inheritance? classNaming? toolline? topLevelDecl*
  static boolean gdfile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gdfile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = gdfile_0(b, l + 1);
    r = r && gdfile_1(b, l + 1);
    r = r && gdfile_2(b, l + 1);
    r = r && gdfile_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // inheritance?
  private static boolean gdfile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gdfile_0")) return false;
    inheritance(b, l + 1);
    return true;
  }

  // classNaming?
  private static boolean gdfile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gdfile_1")) return false;
    classNaming(b, l + 1);
    return true;
  }

  // toolline?
  private static boolean gdfile_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gdfile_2")) return false;
    toolline(b, l + 1);
    return true;
  }

  // topLevelDecl*
  private static boolean gdfile_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gdfile_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!topLevelDecl(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "gdfile_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean getMethodId_nm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "getMethodId_nm")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, GET_METHOD_ID_NM, r);
    return r;
  }

  /* ********************************************************** */
  // IF expr COLON stmtOrSuite (ELIF expr COLON stmtOrSuite)* (ELSE COLON stmtOrSuite)?
  public static boolean if_st(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_st")) return false;
    if (!nextTokenIsFast(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, IF);
    r = r && expr(b, l + 1, -1);
    r = r && consumeToken(b, COLON);
    r = r && stmtOrSuite(b, l + 1);
    r = r && if_st_4(b, l + 1);
    r = r && if_st_5(b, l + 1);
    exit_section_(b, m, IF_ST, r);
    return r;
  }

  // (ELIF expr COLON stmtOrSuite)*
  private static boolean if_st_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_st_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_st_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_st_4", c)) break;
    }
    return true;
  }

  // ELIF expr COLON stmtOrSuite
  private static boolean if_st_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_st_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, ELIF);
    r = r && expr(b, l + 1, -1);
    r = r && consumeToken(b, COLON);
    r = r && stmtOrSuite(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ELSE COLON stmtOrSuite)?
  private static boolean if_st_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_st_5")) return false;
    if_st_5_0(b, l + 1);
    return true;
  }

  // ELSE COLON stmtOrSuite
  private static boolean if_st_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_st_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ELSE, COLON);
    r = r && stmtOrSuite(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // EXTENDS inheritanceId_nmi (DOT IDENTIFIER)? newLineEnd
  public static boolean inheritance(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inheritance")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INHERITANCE, "<inheritance>");
    r = consumeToken(b, EXTENDS);
    p = r; // pin = 1
    r = r && report_error_(b, inheritanceId_nmi(b, l + 1));
    r = p && report_error_(b, inheritance_2(b, l + 1)) && r;
    r = p && newLineEnd(b, l + 1) && r;
    exit_section_(b, l, m, r, p, GdParser::inheritance_r);
    return r || p;
  }

  // (DOT IDENTIFIER)?
  private static boolean inheritance_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inheritance_2")) return false;
    inheritance_2_0(b, l + 1);
    return true;
  }

  // DOT IDENTIFIER
  private static boolean inheritance_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inheritance_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean inheritanceId_nmi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inheritanceId_nmi")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, INHERITANCE_ID_NMI, r);
    return r;
  }

  /* ********************************************************** */
  // !(CLASS_NAME | TOOL) & topLevelDecl_r
  static boolean inheritance_r(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inheritance_r")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = inheritance_r_0(b, l + 1);
    r = r && inheritance_r_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(CLASS_NAME | TOOL)
  private static boolean inheritance_r_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inheritance_r_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !inheritance_r_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // CLASS_NAME | TOOL
  private static boolean inheritance_r_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inheritance_r_0_0")) return false;
    boolean r;
    r = consumeToken(b, CLASS_NAME);
    if (!r) r = consumeToken(b, TOOL);
    return r;
  }

  // & topLevelDecl_r
  private static boolean inheritance_r_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inheritance_r_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = topLevelDecl_r(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (expr COLON expr) | (IDENTIFIER EQ expr)
  public static boolean keyValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keyValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KEY_VALUE, "<key value>");
    r = keyValue_0(b, l + 1);
    if (!r) r = keyValue_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // expr COLON expr
  private static boolean keyValue_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keyValue_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr(b, l + 1, -1);
    r = r && consumeToken(b, COLON);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER EQ expr
  private static boolean keyValue_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keyValue_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, EQ);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MATCH
  public static boolean match_st(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_st")) return false;
    if (!nextTokenIsFast(b, MATCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, MATCH);
    exit_section_(b, m, MATCH_ST, r);
    return r;
  }

  /* ********************************************************** */
  // FUNC methodId_nmi LRBR paramList? RRBR parentMethodCall? returnHint? COLON stmtOrSuite
  public static boolean methodDecl_tl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodDecl_tl")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, METHOD_DECL_TL, "<method decl tl>");
    r = consumeTokenFast(b, FUNC);
    p = r; // pin = 1
    r = r && report_error_(b, methodId_nmi(b, l + 1));
    r = p && report_error_(b, consumeToken(b, LRBR)) && r;
    r = p && report_error_(b, methodDecl_tl_3(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RRBR)) && r;
    r = p && report_error_(b, methodDecl_tl_5(b, l + 1)) && r;
    r = p && report_error_(b, methodDecl_tl_6(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, COLON)) && r;
    r = p && stmtOrSuite(b, l + 1) && r;
    exit_section_(b, l, m, r, p, GdParser::topLevelDecl_r);
    return r || p;
  }

  // paramList?
  private static boolean methodDecl_tl_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodDecl_tl_3")) return false;
    paramList(b, l + 1);
    return true;
  }

  // parentMethodCall?
  private static boolean methodDecl_tl_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodDecl_tl_5")) return false;
    parentMethodCall(b, l + 1);
    return true;
  }

  // returnHint?
  private static boolean methodDecl_tl_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodDecl_tl_6")) return false;
    returnHint(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean methodId_nmi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodId_nmi")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, METHOD_ID_NMI, r);
    return r;
  }

  /* ********************************************************** */
  // NEW_LINE | <<eof>>
  public static boolean newLineEnd(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "newLineEnd")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NEW_LINE_END, "<new line end>");
    r = consumeToken(b, NEW_LINE);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NODE_PATH_LEX
  public static boolean nodePath(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nodePath")) return false;
    if (!nextTokenIs(b, NODE_PATH_LEX)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NODE_PATH_LEX);
    exit_section_(b, m, NODE_PATH, r);
    return r;
  }

  /* ********************************************************** */
  // VAR? var_nmi typed? (EQ expr)?
  public static boolean param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param")) return false;
    if (!nextTokenIs(b, "<param>", IDENTIFIER, VAR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAM, "<param>");
    r = param_0(b, l + 1);
    r = r && var_nmi(b, l + 1);
    r = r && param_2(b, l + 1);
    r = r && param_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // VAR?
  private static boolean param_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_0")) return false;
    consumeToken(b, VAR);
    return true;
  }

  // typed?
  private static boolean param_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_2")) return false;
    typed(b, l + 1);
    return true;
  }

  // (EQ expr)?
  private static boolean param_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_3")) return false;
    param_3_0(b, l + 1);
    return true;
  }

  // EQ expr
  private static boolean param_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQ);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // param (COMMA param)*
  public static boolean paramList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramList")) return false;
    if (!nextTokenIs(b, "<param list>", IDENTIFIER, VAR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAM_LIST, "<param list>");
    r = param(b, l + 1);
    r = r && paramList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA param)*
  private static boolean paramList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!paramList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "paramList_1", c)) break;
    }
    return true;
  }

  // COMMA param
  private static boolean paramList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && param(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DOT LRBR argList? RRBR
  public static boolean parentMethodCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parentMethodCall")) return false;
    if (!nextTokenIs(b, DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, LRBR);
    r = r && parentMethodCall_2(b, l + 1);
    r = r && consumeToken(b, RRBR);
    exit_section_(b, m, PARENT_METHOD_CALL, r);
    return r;
  }

  // argList?
  private static boolean parentMethodCall_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parentMethodCall_2")) return false;
    argList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // PRELOAD LRBR STRING RRBR
  public static boolean preload_st(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "preload_st")) return false;
    if (!nextTokenIsFast(b, PRELOAD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PRELOAD, LRBR, STRING, RRBR);
    exit_section_(b, m, PRELOAD_ST, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER | SELF
  public static boolean refId_nm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refId_nm")) return false;
    if (!nextTokenIs(b, "<ref id nm>", IDENTIFIER, SELF)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REF_ID_NM, "<ref id nm>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, SELF);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // RET returnHintVal
  public static boolean returnHint(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "returnHint")) return false;
    if (!nextTokenIs(b, RET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RET);
    r = r && returnHintVal(b, l + 1);
    exit_section_(b, m, RETURN_HINT, r);
    return r;
  }

  /* ********************************************************** */
  // typeHint_nm | VOID
  public static boolean returnHintVal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "returnHintVal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RETURN_HINT_VAL, "<return hint val>");
    r = typeHint_nm(b, l + 1);
    if (!r) r = consumeToken(b, VOID);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // RETURN expr? endStmt
  public static boolean returnStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "returnStmt")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    r = r && returnStmt_1(b, l + 1);
    r = r && endStmt(b, l + 1);
    exit_section_(b, m, RETURN_STMT, r);
    return r;
  }

  // expr?
  private static boolean returnStmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "returnStmt_1")) return false;
    expr(b, l + 1, -1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean setMethodId_nm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setMethodId_nm")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, SET_METHOD_ID_NM, r);
    return r;
  }

  /* ********************************************************** */
  // SETGET setMethodId_nm? (COMMA getMethodId_nm)?
  public static boolean setgetDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setgetDecl")) return false;
    if (!nextTokenIs(b, SETGET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SETGET);
    r = r && setgetDecl_1(b, l + 1);
    r = r && setgetDecl_2(b, l + 1);
    exit_section_(b, m, SETGET_DECL, r);
    return r;
  }

  // setMethodId_nm?
  private static boolean setgetDecl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setgetDecl_1")) return false;
    setMethodId_nm(b, l + 1);
    return true;
  }

  // (COMMA getMethodId_nm)?
  private static boolean setgetDecl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setgetDecl_2")) return false;
    setgetDecl_2_0(b, l + 1);
    return true;
  }

  // COMMA getMethodId_nm
  private static boolean setgetDecl_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setgetDecl_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && getMethodId_nm(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SIGNAL signalId_nmi signalParList? endStmt
  public static boolean signalDecl_tl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signalDecl_tl")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SIGNAL_DECL_TL, "<signal decl tl>");
    r = consumeTokenFast(b, SIGNAL);
    p = r; // pin = 1
    r = r && report_error_(b, signalId_nmi(b, l + 1));
    r = p && report_error_(b, signalDecl_tl_2(b, l + 1)) && r;
    r = p && endStmt(b, l + 1) && r;
    exit_section_(b, l, m, r, p, GdParser::topLevelDecl_r);
    return r || p;
  }

  // signalParList?
  private static boolean signalDecl_tl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signalDecl_tl_2")) return false;
    signalParList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean signalId_nmi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signalId_nmi")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, SIGNAL_ID_NMI, r);
    return r;
  }

  /* ********************************************************** */
  // LRBR IDENTIFIER (COMMA IDENTIFIER)* RRBR
  public static boolean signalParList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signalParList")) return false;
    if (!nextTokenIs(b, LRBR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LRBR, IDENTIFIER);
    r = r && signalParList_2(b, l + 1);
    r = r && consumeToken(b, RRBR);
    exit_section_(b, m, SIGNAL_PAR_LIST, r);
    return r;
  }

  // (COMMA IDENTIFIER)*
  private static boolean signalParList_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signalParList_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!signalParList_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "signalParList_2", c)) break;
    }
    return true;
  }

  // COMMA IDENTIFIER
  private static boolean signalParList_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signalParList_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // assign_st
  //     | varDecl_st
  //     | if_st
  //     | while_st
  //     | for_st
  //     | match_st
  //     | expr_st
  //     | flow_st
  //     | assert_st
  //     | yield_st
  //     | preload_st
  public static boolean stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, STMT, "<stmt>");
    r = assign_st(b, l + 1);
    if (!r) r = varDecl_st(b, l + 1);
    if (!r) r = if_st(b, l + 1);
    if (!r) r = while_st(b, l + 1);
    if (!r) r = for_st(b, l + 1);
    if (!r) r = match_st(b, l + 1);
    if (!r) r = expr_st(b, l + 1);
    if (!r) r = flow_st(b, l + 1);
    if (!r) r = assert_st(b, l + 1);
    if (!r) r = yield_st(b, l + 1);
    if (!r) r = preload_st(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // stmt | suite
  public static boolean stmtOrSuite(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmtOrSuite")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STMT_OR_SUITE, "<stmt or suite>");
    r = stmt(b, l + 1);
    if (!r) r = suite(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NEW_LINE INDENT stmt+ DEDENT
  public static boolean suite(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "suite")) return false;
    if (!nextTokenIs(b, NEW_LINE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SUITE, null);
    r = consumeTokens(b, 0, NEW_LINE, INDENT);
    r = r && suite_2(b, l + 1);
    p = r; // pin = 3
    r = r && consumeToken(b, DEDENT);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // stmt+
  private static boolean suite_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "suite_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = stmt(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "suite_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TOOL newLineEnd
  public static boolean toolline(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "toolline")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TOOLLINE, "<toolline>");
    r = consumeToken(b, TOOL);
    p = r; // pin = 1
    r = r && newLineEnd(b, l + 1);
    exit_section_(b, l, m, r, p, GdParser::topLevelDecl_r);
    return r || p;
  }

  /* ********************************************************** */
  // constDecl_tl
  //     | classVarDecl_tl
  //     | methodDecl_tl
  //     | enumDecl_tl
  //     | signalDecl_tl
  public static boolean topLevelDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topLevelDecl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, TOP_LEVEL_DECL, "<top level decl>");
    r = constDecl_tl(b, l + 1);
    if (!r) r = classVarDecl_tl(b, l + 1);
    if (!r) r = methodDecl_tl(b, l + 1);
    if (!r) r = enumDecl_tl(b, l + 1);
    if (!r) r = signalDecl_tl(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !(FUNC | CONST | SIGNAL | VAR | ENUM | annotation)
  static boolean topLevelDecl_r(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topLevelDecl_r")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !topLevelDecl_r_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // FUNC | CONST | SIGNAL | VAR | ENUM | annotation
  private static boolean topLevelDecl_r_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topLevelDecl_r_0")) return false;
    boolean r;
    r = consumeToken(b, FUNC);
    if (!r) r = consumeToken(b, CONST);
    if (!r) r = consumeToken(b, SIGNAL);
    if (!r) r = consumeToken(b, VAR);
    if (!r) r = consumeToken(b, ENUM);
    if (!r) r = annotation(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // builtInType | IDENTIFIER
  public static boolean typeHint_nm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeHint_nm")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_HINT_NM, "<type hint nm>");
    r = builtInType(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // COLON typeHint_nm
  public static boolean typed(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typed")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && typeHint_nm(b, l + 1);
    exit_section_(b, m, TYPED, r);
    return r;
  }

  /* ********************************************************** */
  // VAR var_nmi typed? (EQ expr)? endStmt
  public static boolean varDecl_st(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varDecl_st")) return false;
    if (!nextTokenIsFast(b, VAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, VAR);
    r = r && var_nmi(b, l + 1);
    r = r && varDecl_st_2(b, l + 1);
    r = r && varDecl_st_3(b, l + 1);
    r = r && endStmt(b, l + 1);
    exit_section_(b, m, VAR_DECL_ST, r);
    return r;
  }

  // typed?
  private static boolean varDecl_st_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varDecl_st_2")) return false;
    typed(b, l + 1);
    return true;
  }

  // (EQ expr)?
  private static boolean varDecl_st_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varDecl_st_3")) return false;
    varDecl_st_3_0(b, l + 1);
    return true;
  }

  // EQ expr
  private static boolean varDecl_st_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varDecl_st_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, EQ);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean var_nmi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_nmi")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, VAR_NMI, r);
    return r;
  }

  /* ********************************************************** */
  // WHILE expr COLON stmtOrSuite
  public static boolean while_st(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "while_st")) return false;
    if (!nextTokenIsFast(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, WHILE);
    r = r && expr(b, l + 1, -1);
    r = r && consumeToken(b, COLON);
    r = r && stmtOrSuite(b, l + 1);
    exit_section_(b, m, WHILE_ST, r);
    return r;
  }

  /* ********************************************************** */
  // YIELD LRBR (expr COMMA expr)? RRBR
  public static boolean yield_st(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yield_st")) return false;
    if (!nextTokenIsFast(b, YIELD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, YIELD, LRBR);
    r = r && yield_st_2(b, l + 1);
    r = r && consumeToken(b, RRBR);
    exit_section_(b, m, YIELD_ST, r);
    return r;
  }

  // (expr COMMA expr)?
  private static boolean yield_st_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yield_st_2")) return false;
    yield_st_2_0(b, l + 1);
    return true;
  }

  // expr COMMA expr
  private static boolean yield_st_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yield_st_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr(b, l + 1, -1);
    r = r && consumeToken(b, COMMA);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Expression root: expr
  // Operator priority table:
  // 0: POSTFIX(plusMinus_ex)
  // 1: POSTFIX(cast_ex)
  // 2: BINARY(ternary_ex)
  // 3: BINARY(logic_ex)
  // 4: PREFIX(negate_ex)
  // 5: BINARY(in_ex)
  // 6: BINARY(comparison_ex)
  // 7: BINARY(bitAnd_ex)
  // 8: BINARY(shift_ex)
  // 9: BINARY(plus_ex)
  // 10: BINARY(factor_ex)
  // 11: PREFIX(sign_ex)
  // 12: PREFIX(bitNot_ex)
  // 13: PREFIX(plusMinusPre_ex)
  // 14: POSTFIX(attribute_ex)
  // 15: POSTFIX(is_ex)
  // 16: POSTFIX(call_ex)
  // 17: BINARY(arr_ex)
  // 18: ATOM(primary_ex)
  // 19: ATOM(literal_ex)
  public static boolean expr(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expr")) return false;
    addVariant(b, "<expr>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<expr>");
    r = negate_ex(b, l + 1);
    if (!r) r = sign_ex(b, l + 1);
    if (!r) r = bitNot_ex(b, l + 1);
    if (!r) r = plusMinusPre_ex(b, l + 1);
    if (!r) r = primary_ex(b, l + 1);
    if (!r) r = literal_ex(b, l + 1);
    p = r;
    r = r && expr_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean expr_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expr_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 0 && plusMinus_ex_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, PLUS_MINUS_EX, r, true, null);
      }
      else if (g < 1 && cast_ex_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, CAST_EX, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, IF)) {
        r = report_error_(b, expr(b, l, 2));
        r = ternary_ex_1(b, l + 1) && r;
        exit_section_(b, l, m, TERNARY_EX, r, true, null);
      }
      else if (g < 3 && logic_ex_0(b, l + 1)) {
        r = expr(b, l, 3);
        exit_section_(b, l, m, LOGIC_EX, r, true, null);
      }
      else if (g < 5 && consumeTokenSmart(b, IN)) {
        r = expr(b, l, 5);
        exit_section_(b, l, m, IN_EX, r, true, null);
      }
      else if (g < 6 && consumeTokenSmart(b, TEST_OPERATOR)) {
        r = expr(b, l, 6);
        exit_section_(b, l, m, COMPARISON_EX, r, true, null);
      }
      else if (g < 7 && bitAnd_ex_0(b, l + 1)) {
        r = expr(b, l, 7);
        exit_section_(b, l, m, BIT_AND_EX, r, true, null);
      }
      else if (g < 8 && shift_ex_0(b, l + 1)) {
        r = expr(b, l, 8);
        exit_section_(b, l, m, SHIFT_EX, r, true, null);
      }
      else if (g < 9 && plus_ex_0(b, l + 1)) {
        r = expr(b, l, 9);
        exit_section_(b, l, m, PLUS_EX, r, true, null);
      }
      else if (g < 10 && factor_ex_0(b, l + 1)) {
        r = expr(b, l, 10);
        exit_section_(b, l, m, FACTOR_EX, r, true, null);
      }
      else if (g < 14 && attribute_ex_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, ATTRIBUTE_EX, r, true, null);
      }
      else if (g < 15 && is_ex_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, IS_EX, r, true, null);
      }
      else if (g < 16 && call_ex_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, CALL_EX, r, true, null);
      }
      else if (g < 17 && consumeTokenSmart(b, LSBR)) {
        r = report_error_(b, expr(b, l, 17));
        r = consumeToken(b, RSBR) && r;
        exit_section_(b, l, m, ARR_EX, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  // PPLUS | MMINUS
  private static boolean plusMinus_ex_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "plusMinus_ex_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, PPLUS);
    if (!r) r = consumeTokenSmart(b, MMINUS);
    return r;
  }

  // AS typeHint_nm
  private static boolean cast_ex_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cast_ex_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, AS);
    r = r && typeHint_nm(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ELSE expr
  private static boolean ternary_ex_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ternary_ex_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, ELSE);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ANDAND | OROR
  private static boolean logic_ex_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logic_ex_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, ANDAND);
    if (!r) r = consumeTokenSmart(b, OROR);
    return r;
  }

  public static boolean negate_ex(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "negate_ex")) return false;
    if (!nextTokenIsSmart(b, NEGATE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, NEGATE);
    p = r;
    r = p && expr(b, l, 4);
    exit_section_(b, l, m, NEGATE_EX, r, p, null);
    return r || p;
  }

  // AND | XOR | OR
  private static boolean bitAnd_ex_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitAnd_ex_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, AND);
    if (!r) r = consumeTokenSmart(b, XOR);
    if (!r) r = consumeTokenSmart(b, OR);
    return r;
  }

  // LBSHIFT | RBSHIFT
  private static boolean shift_ex_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shift_ex_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, LBSHIFT);
    if (!r) r = consumeTokenSmart(b, RBSHIFT);
    return r;
  }

  // PLUS | MINUS
  private static boolean plus_ex_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "plus_ex_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, PLUS);
    if (!r) r = consumeTokenSmart(b, MINUS);
    return r;
  }

  // MUL | DIV | MOD
  private static boolean factor_ex_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "factor_ex_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, MUL);
    if (!r) r = consumeTokenSmart(b, DIV);
    if (!r) r = consumeTokenSmart(b, MOD);
    return r;
  }

  public static boolean sign_ex(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sign_ex")) return false;
    if (!nextTokenIsSmart(b, MINUS, PLUS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = sign_ex_0(b, l + 1);
    p = r;
    r = p && expr(b, l, 11);
    exit_section_(b, l, m, SIGN_EX, r, p, null);
    return r || p;
  }

  // MINUS | PLUS
  private static boolean sign_ex_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sign_ex_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, MINUS);
    if (!r) r = consumeTokenSmart(b, PLUS);
    return r;
  }

  public static boolean bitNot_ex(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitNot_ex")) return false;
    if (!nextTokenIsSmart(b, NOT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, NOT);
    p = r;
    r = p && expr(b, l, 12);
    exit_section_(b, l, m, BIT_NOT_EX, r, p, null);
    return r || p;
  }

  public static boolean plusMinusPre_ex(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "plusMinusPre_ex")) return false;
    if (!nextTokenIsSmart(b, MMINUS, PPLUS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = plusMinusPre_ex_0(b, l + 1);
    p = r;
    r = p && expr(b, l, 13);
    exit_section_(b, l, m, PLUS_MINUS_PRE_EX, r, p, null);
    return r || p;
  }

  // PPLUS | MMINUS
  private static boolean plusMinusPre_ex_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "plusMinusPre_ex_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, PPLUS);
    if (!r) r = consumeTokenSmart(b, MMINUS);
    return r;
  }

  // DOT attEx_nm
  private static boolean attribute_ex_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_ex_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, DOT);
    r = r && attEx_nm(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IS typeHint_nm
  private static boolean is_ex_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "is_ex_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, IS);
    r = r && typeHint_nm(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LRBR argList? RRBR
  private static boolean call_ex_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_ex_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, LRBR);
    r = r && call_ex_0_1(b, l + 1);
    r = r && consumeToken(b, RRBR);
    exit_section_(b, m, null, r);
    return r;
  }

  // argList?
  private static boolean call_ex_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_ex_0_1")) return false;
    argList(b, l + 1);
    return true;
  }

  // nodePath | arrayDecl | dictDecl | (LRBR expr RRBR)
  public static boolean primary_ex(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_ex")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMARY_EX, "<primary ex>");
    r = nodePath(b, l + 1);
    if (!r) r = arrayDecl(b, l + 1);
    if (!r) r = dictDecl(b, l + 1);
    if (!r) r = primary_ex_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LRBR expr RRBR
  private static boolean primary_ex_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_ex_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, LRBR);
    r = r && expr(b, l + 1, -1);
    r = r && consumeToken(b, RRBR);
    exit_section_(b, m, null, r);
    return r;
  }

  // TRUE | FALSE | STRING | NUMBER | NULL | PI | TAU | NAN | INF | refId_nm
  public static boolean literal_ex(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_ex")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_EX, "<literal ex>");
    r = consumeTokenSmart(b, TRUE);
    if (!r) r = consumeTokenSmart(b, FALSE);
    if (!r) r = consumeTokenSmart(b, STRING);
    if (!r) r = consumeTokenSmart(b, NUMBER);
    if (!r) r = consumeTokenSmart(b, NULL);
    if (!r) r = consumeTokenSmart(b, PI);
    if (!r) r = consumeTokenSmart(b, TAU);
    if (!r) r = consumeTokenSmart(b, NAN);
    if (!r) r = consumeTokenSmart(b, INF);
    if (!r) r = refId_nm(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
