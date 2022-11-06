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
    create_token_set_(ANNOTATION_TL, CLASS_DECL_TL, CLASS_VAR_DECL_TL, CONST_DECL_TL,
      ENUM_DECL_TL, METHOD_DECL_TL, SIGNAL_DECL_TL, TOP_LEVEL_DECL),
    create_token_set_(ASSERT_ST, ASSIGN_ST, AWAIT_ST, CONST_DECL_ST,
      EXPR_ST, FLOW_ST, FOR_ST, IF_ST,
      MATCH_ST, STMT, VAR_DECL_ST, WHILE_ST),
    create_token_set_(ARR_EX, ATTRIBUTE_EX, BIT_AND_EX, BIT_NOT_EX,
      CALL_EX, CAST_EX, COMPARISON_EX, EXPR,
      FACTOR_EX, FUNC_DECL_EX, IN_EX, IS_EX,
      LITERAL_EX, LOGIC_EX, NEGATE_EX, PLUS_EX,
      PLUS_MINUS_EX, PLUS_MINUS_PRE_EX, PRELOAD_EX, PRIMARY_EX,
      SHIFT_EX, SIGN_EX, TERNARY_EX),
  };

  /* ********************************************************** */
  // literal_ex (COMMA literal_ex)*
  public static boolean annotationParams(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotationParams")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ANNOTATION_PARAMS, "<annotation params>");
    r = literal_ex(b, l + 1);
    r = r && annotationParams_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA literal_ex)*
  private static boolean annotationParams_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotationParams_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!annotationParams_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "annotationParams_1", c)) break;
    }
    return true;
  }

  // COMMA literal_ex
  private static boolean annotationParams_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotationParams_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && literal_ex(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ANNOTATOR (LRBR annotationParams? RRBR)? newLineEnd?
  public static boolean annotation_tl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_tl")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ANNOTATION_TL, "<annotation tl>");
    r = consumeTokenFast(b, ANNOTATOR);
    p = r; // pin = 1
    r = r && report_error_(b, annotation_tl_1(b, l + 1));
    r = p && annotation_tl_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, GdParser::topLevelDecl_r);
    return r || p;
  }

  // (LRBR annotationParams? RRBR)?
  private static boolean annotation_tl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_tl_1")) return false;
    annotation_tl_1_0(b, l + 1);
    return true;
  }

  // LRBR annotationParams? RRBR
  private static boolean annotation_tl_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_tl_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, LRBR);
    r = r && annotation_tl_1_0_1(b, l + 1);
    r = r && consumeToken(b, RRBR);
    exit_section_(b, m, null, r);
    return r;
  }

  // annotationParams?
  private static boolean annotation_tl_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_tl_1_0_1")) return false;
    annotationParams(b, l + 1);
    return true;
  }

  // newLineEnd?
  private static boolean annotation_tl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_tl_2")) return false;
    newLineEnd(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // expr (COMMA expr)*
  public static boolean argList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argList")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ARG_LIST, "<arg list>");
    r = expr(b, l + 1, -1);
    p = r; // pin = 1
    r = r && argList_1(b, l + 1);
    exit_section_(b, l, m, r, p, GdParser::argList_r);
    return r || p;
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
  // !(RRBR) & topLevelDecl_r
  static boolean argList_r(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argList_r")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = argList_r_0(b, l + 1);
    r = r && argList_r_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(RRBR)
  private static boolean argList_r_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argList_r_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, RRBR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // & topLevelDecl_r
  private static boolean argList_r_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argList_r_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = topLevelDecl_r(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  // LSBR ( pattern (COMMA pattern)* (COMMA DOTDOT)? )? RSBR
  public static boolean arrayPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayPattern")) return false;
    if (!nextTokenIs(b, LSBR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LSBR);
    r = r && arrayPattern_1(b, l + 1);
    r = r && consumeToken(b, RSBR);
    exit_section_(b, m, ARRAY_PATTERN, r);
    return r;
  }

  // ( pattern (COMMA pattern)* (COMMA DOTDOT)? )?
  private static boolean arrayPattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayPattern_1")) return false;
    arrayPattern_1_0(b, l + 1);
    return true;
  }

  // pattern (COMMA pattern)* (COMMA DOTDOT)?
  private static boolean arrayPattern_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayPattern_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern(b, l + 1);
    r = r && arrayPattern_1_0_1(b, l + 1);
    r = r && arrayPattern_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA pattern)*
  private static boolean arrayPattern_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayPattern_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!arrayPattern_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arrayPattern_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA pattern
  private static boolean arrayPattern_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayPattern_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && pattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA DOTDOT)?
  private static boolean arrayPattern_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayPattern_1_0_2")) return false;
    arrayPattern_1_0_2_0(b, l + 1);
    return true;
  }

  // COMMA DOTDOT
  private static boolean arrayPattern_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayPattern_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, DOTDOT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ASSERT LRBR expr (COMMA STRING)? RRBR endStmt
  public static boolean assert_st(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assert_st")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ASSERT_ST, "<assert st>");
    r = consumeTokens(b, 1, ASSERT, LRBR);
    p = r; // pin = 1
    r = r && report_error_(b, expr(b, l + 1, -1));
    r = p && report_error_(b, assert_st_3(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RRBR)) && r;
    r = p && endStmt(b, l + 1) && r;
    exit_section_(b, l, m, r, p, GdParser::stmt_r);
    return r || p;
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
  // EQ | CEQ
  public static boolean assignTyped(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignTyped")) return false;
    if (!nextTokenIs(b, "<assign typed>", CEQ, EQ)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGN_TYPED, "<assign typed>");
    r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, CEQ);
    exit_section_(b, l, m, r, false, null);
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
  // AWAIT expr_st
  public static boolean await_st(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "await_st")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, AWAIT_ST, "<await st>");
    r = consumeTokenFast(b, AWAIT);
    p = r; // pin = 1
    r = r && expr_st(b, l + 1);
    exit_section_(b, l, m, r, p, GdParser::stmt_r);
    return r || p;
  }

  /* ********************************************************** */
  // VAR var_nmi
  public static boolean bindingPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bindingPattern")) return false;
    if (!nextTokenIs(b, VAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VAR);
    r = r && var_nmi(b, l + 1);
    exit_section_(b, m, BINDING_PATTERN, r);
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
  // CLASS className_nmi inheritance? COLON NEW_LINE INDENT (inheritance | topLevelDecl)+ DEDENT
  public static boolean classDecl_tl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classDecl_tl")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CLASS_DECL_TL, "<class decl tl>");
    r = consumeTokenFast(b, CLASS);
    p = r; // pin = 1
    r = r && report_error_(b, className_nmi(b, l + 1));
    r = p && report_error_(b, classDecl_tl_2(b, l + 1)) && r;
    r = p && report_error_(b, consumeTokens(b, -1, COLON, NEW_LINE, INDENT)) && r;
    r = p && report_error_(b, classDecl_tl_6(b, l + 1)) && r;
    r = p && consumeToken(b, DEDENT) && r;
    exit_section_(b, l, m, r, p, GdParser::topLevelDecl_r);
    return r || p;
  }

  // inheritance?
  private static boolean classDecl_tl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classDecl_tl_2")) return false;
    inheritance(b, l + 1);
    return true;
  }

  // (inheritance | topLevelDecl)+
  private static boolean classDecl_tl_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classDecl_tl_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = classDecl_tl_6_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!classDecl_tl_6_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "classDecl_tl_6", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // inheritance | topLevelDecl
  private static boolean classDecl_tl_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classDecl_tl_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = inheritance(b, l + 1);
    if (!r) r = topLevelDecl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean className_nmi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "className_nmi")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, CLASS_NAME_NMI, r);
    return r;
  }

  /* ********************************************************** */
  // CLASS_NAME className_nmi newLineEnd?
  public static boolean classNaming(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classNaming")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CLASS_NAMING, "<class naming>");
    r = consumeToken(b, CLASS_NAME);
    p = r; // pin = 1
    r = r && report_error_(b, className_nmi(b, l + 1));
    r = p && classNaming_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, GdParser::topLevelDecl_r);
    return r || p;
  }

  // newLineEnd?
  private static boolean classNaming_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classNaming_2")) return false;
    newLineEnd(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // VAR classVarId_nmi typed? (assignTyped expr)? (setgetDecl | endStmt)
  public static boolean classVarDecl_tl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classVarDecl_tl")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CLASS_VAR_DECL_TL, "<class var decl tl>");
    r = consumeTokenFast(b, VAR);
    p = r; // pin = 1
    r = r && report_error_(b, classVarId_nmi(b, l + 1));
    r = p && report_error_(b, classVarDecl_tl_2(b, l + 1)) && r;
    r = p && report_error_(b, classVarDecl_tl_3(b, l + 1)) && r;
    r = p && classVarDecl_tl_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, GdParser::topLevelDecl_r);
    return r || p;
  }

  // typed?
  private static boolean classVarDecl_tl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classVarDecl_tl_2")) return false;
    typed(b, l + 1);
    return true;
  }

  // (assignTyped expr)?
  private static boolean classVarDecl_tl_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classVarDecl_tl_3")) return false;
    classVarDecl_tl_3_0(b, l + 1);
    return true;
  }

  // assignTyped expr
  private static boolean classVarDecl_tl_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classVarDecl_tl_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = assignTyped(b, l + 1);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // setgetDecl | endStmt
  private static boolean classVarDecl_tl_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classVarDecl_tl_4")) return false;
    boolean r;
    r = setgetDecl(b, l + 1);
    if (!r) r = endStmt(b, l + 1);
    return r;
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
  // CONST var_nmi typed? (assignTyped expr)? endStmt
  public static boolean constDecl_st(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constDecl_st")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONST_DECL_ST, "<const decl st>");
    r = consumeTokenFast(b, CONST);
    r = r && var_nmi(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, constDecl_st_2(b, l + 1));
    r = p && report_error_(b, constDecl_st_3(b, l + 1)) && r;
    r = p && endStmt(b, l + 1) && r;
    exit_section_(b, l, m, r, p, GdParser::stmt_r);
    return r || p;
  }

  // typed?
  private static boolean constDecl_st_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constDecl_st_2")) return false;
    typed(b, l + 1);
    return true;
  }

  // (assignTyped expr)?
  private static boolean constDecl_st_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constDecl_st_3")) return false;
    constDecl_st_3_0(b, l + 1);
    return true;
  }

  // assignTyped expr
  private static boolean constDecl_st_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constDecl_st_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = assignTyped(b, l + 1);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CONST constId_nmi typed? assignTyped expr endStmt
  public static boolean constDecl_tl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constDecl_tl")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONST_DECL_TL, "<const decl tl>");
    r = consumeTokenFast(b, CONST);
    p = r; // pin = 1
    r = r && report_error_(b, constId_nmi(b, l + 1));
    r = p && report_error_(b, constDecl_tl_2(b, l + 1)) && r;
    r = p && report_error_(b, assignTyped(b, l + 1)) && r;
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
  // IDENTIFIER | INF
  public static boolean constId_nmi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constId_nmi")) return false;
    if (!nextTokenIs(b, "<const id nmi>", IDENTIFIER, INF)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONST_ID_NMI, "<const id nmi>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, INF);
    exit_section_(b, l, m, r, false, null);
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
  // LCBR keyValuePattern? (COMMA keyValuePattern)* (COMMA DOTDOT)? RCBR
  public static boolean dictPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictPattern")) return false;
    if (!nextTokenIs(b, LCBR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LCBR);
    r = r && dictPattern_1(b, l + 1);
    r = r && dictPattern_2(b, l + 1);
    r = r && dictPattern_3(b, l + 1);
    r = r && consumeToken(b, RCBR);
    exit_section_(b, m, DICT_PATTERN, r);
    return r;
  }

  // keyValuePattern?
  private static boolean dictPattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictPattern_1")) return false;
    keyValuePattern(b, l + 1);
    return true;
  }

  // (COMMA keyValuePattern)*
  private static boolean dictPattern_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictPattern_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!dictPattern_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "dictPattern_2", c)) break;
    }
    return true;
  }

  // COMMA keyValuePattern
  private static boolean dictPattern_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictPattern_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && keyValuePattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA DOTDOT)?
  private static boolean dictPattern_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictPattern_3")) return false;
    dictPattern_3_0(b, l + 1);
    return true;
  }

  // COMMA DOTDOT
  private static boolean dictPattern_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictPattern_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, DOTDOT);
    exit_section_(b, m, null, r);
    return r;
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
  // enumValue_nmi (EQ (PLUS | MINUS)? NUMBER)?
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

  // (EQ (PLUS | MINUS)? NUMBER)?
  private static boolean enumValue_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumValue_1")) return false;
    enumValue_1_0(b, l + 1);
    return true;
  }

  // EQ (PLUS | MINUS)? NUMBER
  private static boolean enumValue_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumValue_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQ);
    r = r && enumValue_1_0_1(b, l + 1);
    r = r && consumeToken(b, NUMBER);
    exit_section_(b, m, null, r);
    return r;
  }

  // (PLUS | MINUS)?
  private static boolean enumValue_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumValue_1_0_1")) return false;
    enumValue_1_0_1_0(b, l + 1);
    return true;
  }

  // PLUS | MINUS
  private static boolean enumValue_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumValue_1_0_1_0")) return false;
    boolean r;
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
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
    exit_section_(b, l, m, r, p, GdParser::stmt_r);
    return r || p;
  }

  /* ********************************************************** */
  // (CONTINUE endStmt)
  //     | (BREAK endStmt)
  //     | (PASS endStmt)
  //     | (BREAKPOINT endStmt) // TODO existuje ještě totok?
  //     | (RETURN expr? endStmt)
  public static boolean flow_st(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flow_st")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FLOW_ST, "<flow st>");
    r = flow_st_0(b, l + 1);
    if (!r) r = flow_st_1(b, l + 1);
    if (!r) r = flow_st_2(b, l + 1);
    if (!r) r = flow_st_3(b, l + 1);
    if (!r) r = flow_st_4(b, l + 1);
    exit_section_(b, l, m, r, false, GdParser::stmt_r);
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

  // RETURN expr? endStmt
  private static boolean flow_st_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flow_st_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, RETURN);
    r = r && flow_st_4_1(b, l + 1);
    r = r && endStmt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // expr?
  private static boolean flow_st_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flow_st_4_1")) return false;
    expr(b, l + 1, -1);
    return true;
  }

  /* ********************************************************** */
  // FOR var_nmi IN expr COLON stmtOrSuite
  public static boolean for_st(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_st")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FOR_ST, "<for st>");
    r = consumeTokenFast(b, FOR);
    r = r && var_nmi(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, consumeToken(b, IN));
    r = p && report_error_(b, expr(b, l + 1, -1)) && r;
    r = p && report_error_(b, consumeToken(b, COLON)) && r;
    r = p && stmtOrSuite(b, l + 1) && r;
    exit_section_(b, l, m, r, p, GdParser::stmt_r);
    return r || p;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean funcDeclId_nmi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "funcDeclId_nmi")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, FUNC_DECL_ID_NMI, r);
    return r;
  }

  /* ********************************************************** */
  // (inheritance | classNaming | topLevelDecl)*
  static boolean gdfile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gdfile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!gdfile_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "gdfile", c)) break;
    }
    return true;
  }

  // inheritance | classNaming | topLevelDecl
  private static boolean gdfile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gdfile_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = inheritance(b, l + 1);
    if (!r) r = classNaming(b, l + 1);
    if (!r) r = topLevelDecl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // GET ((COLON stmtOrSuite) | (EQ getMethodId_nm COMMA? NEW_LINE?))
  public static boolean getDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "getDecl")) return false;
    if (!nextTokenIs(b, GET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GET);
    r = r && getDecl_1(b, l + 1);
    exit_section_(b, m, GET_DECL, r);
    return r;
  }

  // (COLON stmtOrSuite) | (EQ getMethodId_nm COMMA? NEW_LINE?)
  private static boolean getDecl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "getDecl_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = getDecl_1_0(b, l + 1);
    if (!r) r = getDecl_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON stmtOrSuite
  private static boolean getDecl_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "getDecl_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && stmtOrSuite(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EQ getMethodId_nm COMMA? NEW_LINE?
  private static boolean getDecl_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "getDecl_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQ);
    r = r && getMethodId_nm(b, l + 1);
    r = r && getDecl_1_1_2(b, l + 1);
    r = r && getDecl_1_1_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean getDecl_1_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "getDecl_1_1_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // NEW_LINE?
  private static boolean getDecl_1_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "getDecl_1_1_3")) return false;
    consumeToken(b, NEW_LINE);
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
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IF_ST, "<if st>");
    r = consumeTokenFast(b, IF);
    r = r && expr(b, l + 1, -1);
    p = r; // pin = 2
    r = r && report_error_(b, consumeToken(b, COLON));
    r = p && report_error_(b, stmtOrSuite(b, l + 1)) && r;
    r = p && report_error_(b, if_st_4(b, l + 1)) && r;
    r = p && if_st_5(b, l + 1) && r;
    exit_section_(b, l, m, r, p, GdParser::stmt_r);
    return r || p;
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
  // EXTENDS inheritanceId newLineEnd?
  public static boolean inheritance(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inheritance")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INHERITANCE, "<inheritance>");
    r = consumeToken(b, EXTENDS);
    p = r; // pin = 1
    r = r && report_error_(b, inheritanceId(b, l + 1));
    r = p && inheritance_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, GdParser::inheritance_r);
    return r || p;
  }

  // newLineEnd?
  private static boolean inheritance_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inheritance_2")) return false;
    newLineEnd(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // inheritanceId_nm (DOT inheritanceSubId_nm)*
  public static boolean inheritanceId(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inheritanceId")) return false;
    if (!nextTokenIs(b, "<inheritance id>", IDENTIFIER, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INHERITANCE_ID, "<inheritance id>");
    r = inheritanceId_nm(b, l + 1);
    r = r && inheritanceId_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (DOT inheritanceSubId_nm)*
  private static boolean inheritanceId_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inheritanceId_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!inheritanceId_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "inheritanceId_1", c)) break;
    }
    return true;
  }

  // DOT inheritanceSubId_nm
  private static boolean inheritanceId_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inheritanceId_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && inheritanceSubId_nm(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STRING | IDENTIFIER
  public static boolean inheritanceId_nm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inheritanceId_nm")) return false;
    if (!nextTokenIs(b, "<inheritance id nm>", IDENTIFIER, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INHERITANCE_ID_NM, "<inheritance id nm>");
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean inheritanceSubId_nm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inheritanceSubId_nm")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, INHERITANCE_SUB_ID_NM, r);
    return r;
  }

  /* ********************************************************** */
  // !(TOOL | COLON) & topLevelDecl_r
  static boolean inheritance_r(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inheritance_r")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = inheritance_r_0(b, l + 1);
    r = r && inheritance_r_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(TOOL | COLON)
  private static boolean inheritance_r_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inheritance_r_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !inheritance_r_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // TOOL | COLON
  private static boolean inheritance_r_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inheritance_r_0_0")) return false;
    boolean r;
    r = consumeToken(b, TOOL);
    if (!r) r = consumeToken(b, COLON);
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
  // typeHint_nm (LSBR typeHintArray_nm RSBR)?
  public static boolean isTyped(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "isTyped")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = typeHint_nm(b, l + 1);
    r = r && isTyped_1(b, l + 1);
    exit_section_(b, m, IS_TYPED, r);
    return r;
  }

  // (LSBR typeHintArray_nm RSBR)?
  private static boolean isTyped_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "isTyped_1")) return false;
    isTyped_1_0(b, l + 1);
    return true;
  }

  // LSBR typeHintArray_nm RSBR
  private static boolean isTyped_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "isTyped_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LSBR);
    r = r && typeHintArray_nm(b, l + 1);
    r = r && consumeToken(b, RSBR);
    exit_section_(b, m, null, r);
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
  // STRING [ COLON pattern ]
  public static boolean keyValuePattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keyValuePattern")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    r = r && keyValuePattern_1(b, l + 1);
    exit_section_(b, m, KEY_VALUE_PATTERN, r);
    return r;
  }

  // [ COLON pattern ]
  private static boolean keyValuePattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keyValuePattern_1")) return false;
    keyValuePattern_1_0(b, l + 1);
    return true;
  }

  // COLON pattern
  private static boolean keyValuePattern_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keyValuePattern_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && pattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (patternList COLON stmtOrSuite)+
  public static boolean matchBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchBlock")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATCH_BLOCK, "<match block>");
    r = matchBlock_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!matchBlock_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "matchBlock", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // patternList COLON stmtOrSuite
  private static boolean matchBlock_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "matchBlock_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = patternList(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && stmtOrSuite(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MATCH expr COLON NEW_LINE INDENT matchBlock DEDENT
  public static boolean match_st(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_st")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MATCH_ST, "<match st>");
    r = consumeTokenFast(b, MATCH);
    p = r; // pin = 1
    r = r && report_error_(b, expr(b, l + 1, -1));
    r = p && report_error_(b, consumeTokens(b, -1, COLON, NEW_LINE, INDENT)) && r;
    r = p && report_error_(b, matchBlock(b, l + 1)) && r;
    r = p && consumeToken(b, DEDENT) && r;
    exit_section_(b, l, m, r, p, GdParser::stmt_r);
    return r || p;
  }

  /* ********************************************************** */
  // STATIC? VARARG? FUNC methodId_nmi LRBR paramList? RRBR returnHint? COLON stmtOrSuite
  public static boolean methodDecl_tl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodDecl_tl")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, METHOD_DECL_TL, "<method decl tl>");
    r = methodDecl_tl_0(b, l + 1);
    r = r && methodDecl_tl_1(b, l + 1);
    r = r && consumeToken(b, FUNC);
    p = r; // pin = 3
    r = r && report_error_(b, methodId_nmi(b, l + 1));
    r = p && report_error_(b, consumeToken(b, LRBR)) && r;
    r = p && report_error_(b, methodDecl_tl_5(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RRBR)) && r;
    r = p && report_error_(b, methodDecl_tl_7(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, COLON)) && r;
    r = p && stmtOrSuite(b, l + 1) && r;
    exit_section_(b, l, m, r, p, GdParser::topLevelDecl_r);
    return r || p;
  }

  // STATIC?
  private static boolean methodDecl_tl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodDecl_tl_0")) return false;
    consumeTokenFast(b, STATIC);
    return true;
  }

  // VARARG?
  private static boolean methodDecl_tl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodDecl_tl_1")) return false;
    consumeTokenFast(b, VARARG);
    return true;
  }

  // paramList?
  private static boolean methodDecl_tl_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodDecl_tl_5")) return false;
    paramList(b, l + 1);
    return true;
  }

  // returnHint?
  private static boolean methodDecl_tl_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodDecl_tl_7")) return false;
    returnHint(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER | GET | SET
  public static boolean methodId_nmi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodId_nmi")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD_ID_NMI, "<method id nmi>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, GET);
    if (!r) r = consumeToken(b, SET);
    exit_section_(b, l, m, r, false, null);
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
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PARAM_LIST, "<param list>");
    r = param(b, l + 1);
    p = r; // pin = 1
    r = r && paramList_1(b, l + 1);
    exit_section_(b, l, m, r, p, GdParser::argList_r);
    return r || p;
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
  // literal_ex | builtInType | UNDER | bindingPattern | arrayPattern | dictPattern
  public static boolean pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN, "<pattern>");
    r = literal_ex(b, l + 1);
    if (!r) r = builtInType(b, l + 1);
    if (!r) r = consumeToken(b, UNDER);
    if (!r) r = bindingPattern(b, l + 1);
    if (!r) r = arrayPattern(b, l + 1);
    if (!r) r = dictPattern(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // pattern (COMMA pattern)*
  public static boolean patternList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patternList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN_LIST, "<pattern list>");
    r = pattern(b, l + 1);
    r = r && patternList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA pattern)*
  private static boolean patternList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patternList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!patternList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "patternList_1", c)) break;
    }
    return true;
  }

  // COMMA pattern
  private static boolean patternList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "patternList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && pattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STRING
  public static boolean preload_nm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "preload_nm")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    exit_section_(b, m, PRELOAD_NM, r);
    return r;
  }

  /* ********************************************************** */
  // !(NEW_LINE | COLON) & stmt_r
  static boolean preload_r(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "preload_r")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = preload_r_0(b, l + 1);
    r = r && preload_r_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(NEW_LINE | COLON)
  private static boolean preload_r_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "preload_r_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !preload_r_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NEW_LINE | COLON
  private static boolean preload_r_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "preload_r_0_0")) return false;
    boolean r;
    r = consumeToken(b, NEW_LINE);
    if (!r) r = consumeToken(b, COLON);
    return r;
  }

  // & stmt_r
  private static boolean preload_r_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "preload_r_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = stmt_r(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER | SELF | SUPER
  public static boolean refId_nm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refId_nm")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REF_ID_NM, "<ref id nm>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, SELF);
    if (!r) r = consumeToken(b, SUPER);
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
  // typedVal | VOID
  public static boolean returnHintVal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "returnHintVal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RETURN_HINT_VAL, "<return hint val>");
    r = typedVal(b, l + 1);
    if (!r) r = consumeToken(b, VOID);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SET ((LRBR var_nmi typed? RRBR COLON stmtOrSuite) | (EQ setMethodId_nm COMMA? NEW_LINE?))
  public static boolean setDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setDecl")) return false;
    if (!nextTokenIs(b, SET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SET);
    r = r && setDecl_1(b, l + 1);
    exit_section_(b, m, SET_DECL, r);
    return r;
  }

  // (LRBR var_nmi typed? RRBR COLON stmtOrSuite) | (EQ setMethodId_nm COMMA? NEW_LINE?)
  private static boolean setDecl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setDecl_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = setDecl_1_0(b, l + 1);
    if (!r) r = setDecl_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LRBR var_nmi typed? RRBR COLON stmtOrSuite
  private static boolean setDecl_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setDecl_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LRBR);
    r = r && var_nmi(b, l + 1);
    r = r && setDecl_1_0_2(b, l + 1);
    r = r && consumeTokens(b, 0, RRBR, COLON);
    r = r && stmtOrSuite(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // typed?
  private static boolean setDecl_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setDecl_1_0_2")) return false;
    typed(b, l + 1);
    return true;
  }

  // EQ setMethodId_nm COMMA? NEW_LINE?
  private static boolean setDecl_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setDecl_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQ);
    r = r && setMethodId_nm(b, l + 1);
    r = r && setDecl_1_1_2(b, l + 1);
    r = r && setDecl_1_1_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean setDecl_1_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setDecl_1_1_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // NEW_LINE?
  private static boolean setDecl_1_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setDecl_1_1_3")) return false;
    consumeToken(b, NEW_LINE);
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
  // COLON (NEW_LINE INDENT)? (getDecl | setDecl)+ DEDENT?
  public static boolean setgetDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setgetDecl")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && setgetDecl_1(b, l + 1);
    r = r && setgetDecl_2(b, l + 1);
    r = r && setgetDecl_3(b, l + 1);
    exit_section_(b, m, SETGET_DECL, r);
    return r;
  }

  // (NEW_LINE INDENT)?
  private static boolean setgetDecl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setgetDecl_1")) return false;
    setgetDecl_1_0(b, l + 1);
    return true;
  }

  // NEW_LINE INDENT
  private static boolean setgetDecl_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setgetDecl_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NEW_LINE, INDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  // (getDecl | setDecl)+
  private static boolean setgetDecl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setgetDecl_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = setgetDecl_2_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!setgetDecl_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "setgetDecl_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // getDecl | setDecl
  private static boolean setgetDecl_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setgetDecl_2_0")) return false;
    boolean r;
    r = getDecl(b, l + 1);
    if (!r) r = setDecl(b, l + 1);
    return r;
  }

  // DEDENT?
  private static boolean setgetDecl_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setgetDecl_3")) return false;
    consumeToken(b, DEDENT);
    return true;
  }

  /* ********************************************************** */
  // SIGNAL signalId_nmi (LRBR paramList RRBR)? endStmt
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

  // (LRBR paramList RRBR)?
  private static boolean signalDecl_tl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signalDecl_tl_2")) return false;
    signalDecl_tl_2_0(b, l + 1);
    return true;
  }

  // LRBR paramList RRBR
  private static boolean signalDecl_tl_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signalDecl_tl_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenFast(b, LRBR);
    r = r && paramList(b, l + 1);
    r = r && consumeToken(b, RRBR);
    exit_section_(b, m, null, r);
    return r;
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
  // assign_st
  //     | varDecl_st
  //     | constDecl_st
  //     | if_st
  //     | while_st
  //     | for_st
  //     | match_st
  //     | flow_st
  //     | assert_st
  //     | await_st
  //     | expr_st
  //     | (expr endStmt)
  public static boolean stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, STMT, "<stmt>");
    r = assign_st(b, l + 1);
    if (!r) r = varDecl_st(b, l + 1);
    if (!r) r = constDecl_st(b, l + 1);
    if (!r) r = if_st(b, l + 1);
    if (!r) r = while_st(b, l + 1);
    if (!r) r = for_st(b, l + 1);
    if (!r) r = match_st(b, l + 1);
    if (!r) r = flow_st(b, l + 1);
    if (!r) r = assert_st(b, l + 1);
    if (!r) r = await_st(b, l + 1);
    if (!r) r = expr_st(b, l + 1);
    if (!r) r = stmt_11(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // expr endStmt
  private static boolean stmt_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt_11")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr(b, l + 1, -1);
    r = r && endStmt(b, l + 1);
    exit_section_(b, m, null, r);
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
  // !(SET | GET | VAR | CONST | IF | PASS
  //     | CONTINUE | BREAK | BREAKPOINT | WHILE | FOR | MATCH
  //     | RETURN | AWAIT | ASSET | PRELOAD | INDENT | DEDENT
  //     | LOAD
  //     | IDENTIFIER | literal_ex | primary_ex) & topLevelDecl_r
  static boolean stmt_r(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt_r")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = stmt_r_0(b, l + 1);
    r = r && stmt_r_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(SET | GET | VAR | CONST | IF | PASS
  //     | CONTINUE | BREAK | BREAKPOINT | WHILE | FOR | MATCH
  //     | RETURN | AWAIT | ASSET | PRELOAD | INDENT | DEDENT
  //     | LOAD
  //     | IDENTIFIER | literal_ex | primary_ex)
  private static boolean stmt_r_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt_r_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !stmt_r_0_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SET | GET | VAR | CONST | IF | PASS
  //     | CONTINUE | BREAK | BREAKPOINT | WHILE | FOR | MATCH
  //     | RETURN | AWAIT | ASSET | PRELOAD | INDENT | DEDENT
  //     | LOAD
  //     | IDENTIFIER | literal_ex | primary_ex
  private static boolean stmt_r_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt_r_0_0")) return false;
    boolean r;
    r = consumeToken(b, SET);
    if (!r) r = consumeToken(b, GET);
    if (!r) r = consumeToken(b, VAR);
    if (!r) r = consumeToken(b, CONST);
    if (!r) r = consumeToken(b, IF);
    if (!r) r = consumeToken(b, PASS);
    if (!r) r = consumeToken(b, CONTINUE);
    if (!r) r = consumeToken(b, BREAK);
    if (!r) r = consumeToken(b, BREAKPOINT);
    if (!r) r = consumeToken(b, WHILE);
    if (!r) r = consumeToken(b, FOR);
    if (!r) r = consumeToken(b, MATCH);
    if (!r) r = consumeToken(b, RETURN);
    if (!r) r = consumeToken(b, AWAIT);
    if (!r) r = consumeToken(b, ASSET);
    if (!r) r = consumeToken(b, PRELOAD);
    if (!r) r = consumeToken(b, INDENT);
    if (!r) r = consumeToken(b, DEDENT);
    if (!r) r = consumeToken(b, LOAD);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = literal_ex(b, l + 1);
    if (!r) r = primary_ex(b, l + 1);
    return r;
  }

  // & topLevelDecl_r
  private static boolean stmt_r_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt_r_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = topLevelDecl_r(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NEW_LINE? INDENT stmt+ DEDENT
  public static boolean suite(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "suite")) return false;
    if (!nextTokenIs(b, "<suite>", INDENT, NEW_LINE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SUITE, "<suite>");
    r = suite_0(b, l + 1);
    r = r && consumeToken(b, INDENT);
    p = r; // pin = 2
    r = r && report_error_(b, suite_2(b, l + 1));
    r = p && consumeToken(b, DEDENT) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // NEW_LINE?
  private static boolean suite_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "suite_0")) return false;
    consumeToken(b, NEW_LINE);
    return true;
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
  // constDecl_tl
  //     | enumDecl_tl
  //     | signalDecl_tl
  //     | classVarDecl_tl
  //     | annotation_tl
  //     | methodDecl_tl
  //     | classDecl_tl
  public static boolean topLevelDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topLevelDecl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, TOP_LEVEL_DECL, "<top level decl>");
    r = constDecl_tl(b, l + 1);
    if (!r) r = enumDecl_tl(b, l + 1);
    if (!r) r = signalDecl_tl(b, l + 1);
    if (!r) r = classVarDecl_tl(b, l + 1);
    if (!r) r = annotation_tl(b, l + 1);
    if (!r) r = methodDecl_tl(b, l + 1);
    if (!r) r = classDecl_tl(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !(
  //     FUNC | CONST | SIGNAL | VAR | ENUM | ANNOTATOR | IDENTIFIER | DEDENT
  //     | CLASS_NAME | STATIC | VARARG | RRBR | RCBR | RSBR | EXTENDS | CLASS )
  static boolean topLevelDecl_r(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topLevelDecl_r")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !topLevelDecl_r_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // FUNC | CONST | SIGNAL | VAR | ENUM | ANNOTATOR | IDENTIFIER | DEDENT
  //     | CLASS_NAME | STATIC | VARARG | RRBR | RCBR | RSBR | EXTENDS | CLASS
  private static boolean topLevelDecl_r_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topLevelDecl_r_0")) return false;
    boolean r;
    r = consumeToken(b, FUNC);
    if (!r) r = consumeToken(b, CONST);
    if (!r) r = consumeToken(b, SIGNAL);
    if (!r) r = consumeToken(b, VAR);
    if (!r) r = consumeToken(b, ENUM);
    if (!r) r = consumeToken(b, ANNOTATOR);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, DEDENT);
    if (!r) r = consumeToken(b, CLASS_NAME);
    if (!r) r = consumeToken(b, STATIC);
    if (!r) r = consumeToken(b, VARARG);
    if (!r) r = consumeToken(b, RRBR);
    if (!r) r = consumeToken(b, RCBR);
    if (!r) r = consumeToken(b, RSBR);
    if (!r) r = consumeToken(b, EXTENDS);
    if (!r) r = consumeToken(b, CLASS);
    return r;
  }

  /* ********************************************************** */
  // builtInType | IDENTIFIER
  public static boolean typeHintArray_nm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeHintArray_nm")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_HINT_ARRAY_NM, "<type hint array nm>");
    r = builtInType(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean typeHint_nm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeHint_nm")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, TYPE_HINT_NM, r);
    return r;
  }

  /* ********************************************************** */
  // COLON typedVal
  public static boolean typed(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typed")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && typedVal(b, l + 1);
    exit_section_(b, m, TYPED, r);
    return r;
  }

  /* ********************************************************** */
  // typedValRoot (LSBR typeHint_nm RSBR)?
  public static boolean typedVal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typedVal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPED_VAL, "<typed val>");
    r = typedValRoot(b, l + 1);
    r = r && typedVal_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (LSBR typeHint_nm RSBR)?
  private static boolean typedVal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typedVal_1")) return false;
    typedVal_1_0(b, l + 1);
    return true;
  }

  // LSBR typeHint_nm RSBR
  private static boolean typedVal_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typedVal_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LSBR);
    r = r && typeHint_nm(b, l + 1);
    r = r && consumeToken(b, RSBR);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // builtInType | typeHint_nm
  public static boolean typedValRoot(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typedValRoot")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPED_VAL_ROOT, "<typed val root>");
    r = builtInType(b, l + 1);
    if (!r) r = typeHint_nm(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // VAR var_nmi typed? (assignTyped expr)? endStmt?
  public static boolean varDecl_st(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varDecl_st")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VAR_DECL_ST, "<var decl st>");
    r = consumeTokenFast(b, VAR);
    r = r && var_nmi(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, varDecl_st_2(b, l + 1));
    r = p && report_error_(b, varDecl_st_3(b, l + 1)) && r;
    r = p && varDecl_st_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, GdParser::stmt_r);
    return r || p;
  }

  // typed?
  private static boolean varDecl_st_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varDecl_st_2")) return false;
    typed(b, l + 1);
    return true;
  }

  // (assignTyped expr)?
  private static boolean varDecl_st_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varDecl_st_3")) return false;
    varDecl_st_3_0(b, l + 1);
    return true;
  }

  // assignTyped expr
  private static boolean varDecl_st_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varDecl_st_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = assignTyped(b, l + 1);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // endStmt?
  private static boolean varDecl_st_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varDecl_st_4")) return false;
    endStmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER | SIGNAL | FUNC | CLASS_NAME
  public static boolean var_nmi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_nmi")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_NMI, "<var nmi>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, SIGNAL);
    if (!r) r = consumeToken(b, FUNC);
    if (!r) r = consumeToken(b, CLASS_NAME);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // WHILE expr COLON stmtOrSuite
  public static boolean while_st(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "while_st")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, WHILE_ST, "<while st>");
    r = consumeTokenFast(b, WHILE);
    r = r && expr(b, l + 1, -1);
    p = r; // pin = 2
    r = r && report_error_(b, consumeToken(b, COLON));
    r = p && stmtOrSuite(b, l + 1) && r;
    exit_section_(b, l, m, r, p, GdParser::stmt_r);
    return r || p;
  }

  /* ********************************************************** */
  // Expression root: expr
  // Operator priority table:
  // 0: POSTFIX(plusMinus_ex)
  // 1: ATOM(preload_ex)
  // 2: BINARY(attribute_ex)
  // 3: POSTFIX(cast_ex)
  // 4: BINARY(arr_ex)
  // 5: POSTFIX(call_ex)
  // 6: BINARY(ternary_ex)
  // 7: BINARY(logic_ex)
  // 8: PREFIX(negate_ex)
  // 9: BINARY(in_ex)
  // 10: BINARY(comparison_ex)
  // 11: BINARY(bitAnd_ex)
  // 12: BINARY(shift_ex)
  // 13: BINARY(plus_ex)
  // 14: BINARY(factor_ex)
  // 15: PREFIX(sign_ex)
  // 16: PREFIX(bitNot_ex)
  // 17: PREFIX(plusMinusPre_ex)
  // 18: POSTFIX(is_ex)
  // 19: ATOM(primary_ex)
  // 20: ATOM(literal_ex)
  // 21: ATOM(funcDecl_ex)
  public static boolean expr(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expr")) return false;
    addVariant(b, "<expr>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<expr>");
    r = preload_ex(b, l + 1);
    if (!r) r = negate_ex(b, l + 1);
    if (!r) r = sign_ex(b, l + 1);
    if (!r) r = bitNot_ex(b, l + 1);
    if (!r) r = plusMinusPre_ex(b, l + 1);
    if (!r) r = primary_ex(b, l + 1);
    if (!r) r = literal_ex(b, l + 1);
    if (!r) r = funcDecl_ex(b, l + 1);
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
      else if (g < 2 && consumeTokenSmart(b, DOT)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, ATTRIBUTE_EX, r, true, null);
      }
      else if (g < 3 && cast_ex_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, CAST_EX, r, true, null);
      }
      else if (g < 4 && consumeTokenSmart(b, LSBR)) {
        r = report_error_(b, expr(b, l, 4));
        r = consumeToken(b, RSBR) && r;
        exit_section_(b, l, m, ARR_EX, r, true, null);
      }
      else if (g < 5 && call_ex_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, CALL_EX, r, true, null);
      }
      else if (g < 6 && consumeTokenSmart(b, IF)) {
        r = report_error_(b, expr(b, l, 6));
        r = ternary_ex_1(b, l + 1) && r;
        exit_section_(b, l, m, TERNARY_EX, r, true, null);
      }
      else if (g < 7 && logic_ex_0(b, l + 1)) {
        r = expr(b, l, 7);
        exit_section_(b, l, m, LOGIC_EX, r, true, null);
      }
      else if (g < 9 && consumeTokenSmart(b, IN)) {
        r = expr(b, l, 9);
        exit_section_(b, l, m, IN_EX, r, true, null);
      }
      else if (g < 10 && consumeTokenSmart(b, TEST_OPERATOR)) {
        r = expr(b, l, 10);
        exit_section_(b, l, m, COMPARISON_EX, r, true, null);
      }
      else if (g < 11 && bitAnd_ex_0(b, l + 1)) {
        r = expr(b, l, 11);
        exit_section_(b, l, m, BIT_AND_EX, r, true, null);
      }
      else if (g < 12 && shift_ex_0(b, l + 1)) {
        r = expr(b, l, 12);
        exit_section_(b, l, m, SHIFT_EX, r, true, null);
      }
      else if (g < 13 && plus_ex_0(b, l + 1)) {
        r = expr(b, l, 13);
        exit_section_(b, l, m, PLUS_EX, r, true, null);
      }
      else if (g < 14 && factor_ex_0(b, l + 1)) {
        r = expr(b, l, 14);
        exit_section_(b, l, m, FACTOR_EX, r, true, null);
      }
      else if (g < 18 && is_ex_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, IS_EX, r, true, null);
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

  // (PRELOAD | LOAD) LRBR preload_nm RRBR
  public static boolean preload_ex(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "preload_ex")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PRELOAD_EX, "<preload ex>");
    r = preload_ex_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, LRBR));
    r = p && report_error_(b, preload_nm(b, l + 1)) && r;
    r = p && consumeToken(b, RRBR) && r;
    exit_section_(b, l, m, r, p, GdParser::preload_r);
    return r || p;
  }

  // PRELOAD | LOAD
  private static boolean preload_ex_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "preload_ex_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, PRELOAD);
    if (!r) r = consumeTokenSmart(b, LOAD);
    return r;
  }

  // AS isTyped
  private static boolean cast_ex_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cast_ex_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, AS);
    r = r && isTyped(b, l + 1);
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
    r = p && expr(b, l, 8);
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
    r = p && expr(b, l, 15);
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
    r = p && expr(b, l, 16);
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
    r = p && expr(b, l, 17);
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

  // IS isTyped
  private static boolean is_ex_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "is_ex_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, IS);
    r = r && isTyped(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
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

  // FUNC funcDeclId_nmi? LRBR paramList? RRBR returnHint? COLON stmtOrSuite
  public static boolean funcDecl_ex(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "funcDecl_ex")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNC_DECL_EX, "<func decl ex>");
    r = consumeTokenSmart(b, FUNC);
    p = r; // pin = 1
    r = r && report_error_(b, funcDecl_ex_1(b, l + 1));
    r = p && report_error_(b, consumeToken(b, LRBR)) && r;
    r = p && report_error_(b, funcDecl_ex_3(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RRBR)) && r;
    r = p && report_error_(b, funcDecl_ex_5(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, COLON)) && r;
    r = p && stmtOrSuite(b, l + 1) && r;
    exit_section_(b, l, m, r, p, GdParser::stmt_r);
    return r || p;
  }

  // funcDeclId_nmi?
  private static boolean funcDecl_ex_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "funcDecl_ex_1")) return false;
    funcDeclId_nmi(b, l + 1);
    return true;
  }

  // paramList?
  private static boolean funcDecl_ex_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "funcDecl_ex_3")) return false;
    paramList(b, l + 1);
    return true;
  }

  // returnHint?
  private static boolean funcDecl_ex_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "funcDecl_ex_5")) return false;
    returnHint(b, l + 1);
    return true;
  }

}
