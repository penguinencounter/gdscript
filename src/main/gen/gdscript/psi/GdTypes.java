// This is a generated file. Not intended for manual editing.
package gdscript.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import gdscript.psi.impl.GdClassNamingElementType;
import gdscript.psi.impl.GdClassVarDeclElementType;
import gdscript.psi.impl.GdConstDeclElementType;
import gdscript.psi.impl.GdInheritanceElementType;
import gdscript.psi.impl.GdMethodDeclElementType;
import gdscript.psi.impl.GdSignalDeclElementType;
import gdscript.psi.impl.*;

public interface GdTypes {

  IElementType ANNOTATION = new GdElementType("ANNOTATION");
  IElementType ARG_LIST = new GdElementType("ARG_LIST");
  IElementType ASSIGN_ST = new GdElementType("ASSIGN_ST");
  IElementType ATTRIBUTE_EX = new GdElementType("ATTRIBUTE_EX");
  IElementType ATT_EX_NM = new GdElementType("ATT_EX_NM");
  IElementType BUILT_IN_TYPE = new GdElementType("BUILT_IN_TYPE");
  IElementType CLASS_NAME_NM = new GdElementType("CLASS_NAME_NM");
  IElementType CLASS_NAMING = GdClassNamingElementType.getInstance("CLASS_NAMING");
  IElementType CLASS_VAR_DECL_TL = GdClassVarDeclElementType.getInstance("CLASS_VAR_DECL_TL");
  IElementType CLASS_VAR_ID_NMI = new GdElementType("CLASS_VAR_ID_NMI");
  IElementType CONST_DECL_TL = GdConstDeclElementType.getInstance("CONST_DECL_TL");
  IElementType CONST_ID_NMI = new GdElementType("CONST_ID_NMI");
  IElementType END_STMT = new GdElementType("END_STMT");
  IElementType EXPR = new GdElementType("EXPR");
  IElementType EXPR_ST = new GdElementType("EXPR_ST");
  IElementType FLOW_ST = new GdElementType("FLOW_ST");
  IElementType GET_METHOD_ID_NM = new GdElementType("GET_METHOD_ID_NM");
  IElementType INHERITANCE = GdInheritanceElementType.getInstance("INHERITANCE");
  IElementType INHERITANCE_ID_NMI = new GdElementType("INHERITANCE_ID_NMI");
  IElementType LITERAL_EX = new GdElementType("LITERAL_EX");
  IElementType METHOD_DECL_TL = GdMethodDeclElementType.getInstance("METHOD_DECL_TL");
  IElementType METHOD_ID_NMI = new GdElementType("METHOD_ID_NMI");
  IElementType NEW_LINE_END = new GdElementType("NEW_LINE_END");
  IElementType PARAM = new GdElementType("PARAM");
  IElementType PARAM_LIST = new GdElementType("PARAM_LIST");
  IElementType PARENT_METHOD_CALL = new GdElementType("PARENT_METHOD_CALL");
  IElementType PLUS_MINUS_EX = new GdElementType("PLUS_MINUS_EX");
  IElementType PLUS_MINUS_PRE_EX = new GdElementType("PLUS_MINUS_PRE_EX");
  IElementType REF_ID_NM = new GdElementType("REF_ID_NM");
  IElementType RETURN_HINT = new GdElementType("RETURN_HINT");
  IElementType SETGET_DECL = new GdElementType("SETGET_DECL");
  IElementType SET_METHOD_ID_NM = new GdElementType("SET_METHOD_ID_NM");
  IElementType SIGNAL_DECL_TL = GdSignalDeclElementType.getInstance("SIGNAL_DECL_TL");
  IElementType SIGNAL_ID_NMI = new GdElementType("SIGNAL_ID_NMI");
  IElementType SIGNAL_PAR_LIST = new GdElementType("SIGNAL_PAR_LIST");
  IElementType STMT = new GdElementType("STMT");
  IElementType STMT_OR_SUITE = new GdElementType("STMT_OR_SUITE");
  IElementType SUITE = new GdElementType("SUITE");
  IElementType TOOLLINE = new GdElementType("TOOLLINE");
  IElementType TOP_LEVEL_DECL = new GdElementType("TOP_LEVEL_DECL");
  IElementType TYPED = new GdElementType("TYPED");
  IElementType TYPE_HINT_NM = new GdElementType("TYPE_HINT_NM");

  IElementType ANNOTATOR = new GdTokenType("ANNOTATOR");
  IElementType ASSIGN = new GdTokenType("ASSIGN");
  IElementType BAD_CHARACTER = new GdTokenType("bad_character");
  IElementType BREAK = new GdTokenType("BREAK");
  IElementType BREAKPOINT = new GdTokenType("BREAKPOINT");
  IElementType CLASS_NAME = new GdTokenType("CLASS_NAME");
  IElementType COLON = new GdTokenType("COLON");
  IElementType COMMA = new GdTokenType("COMMA");
  IElementType COMMENT = new GdTokenType("comment");
  IElementType CONST = new GdTokenType("CONST");
  IElementType CONTINUE = new GdTokenType("CONTINUE");
  IElementType DEDENT = new GdTokenType("DEDENT");
  IElementType DOT = new GdTokenType("DOT");
  IElementType EQ = new GdTokenType("EQ");
  IElementType EXCLA = new GdTokenType("EXCLA");
  IElementType EXTENDS = new GdTokenType("EXTENDS");
  IElementType FALSE = new GdTokenType("FALSE");
  IElementType FUNC = new GdTokenType("FUNC");
  IElementType IDENTIFIER = new GdTokenType("IDENTIFIER");
  IElementType INDENT = new GdTokenType("INDENT");
  IElementType INF = new GdTokenType("INF");
  IElementType INT = new GdTokenType("INT");
  IElementType LRBR = new GdTokenType("LRBR");
  IElementType MMINUS = new GdTokenType("MMINUS");
  IElementType NAN = new GdTokenType("NAN");
  IElementType NEW_LINE = new GdTokenType("NEW_LINE");
  IElementType NULL = new GdTokenType("NULL");
  IElementType NUMBER = new GdTokenType("NUMBER");
  IElementType PASS = new GdTokenType("PASS");
  IElementType PI = new GdTokenType("PI");
  IElementType PPLUS = new GdTokenType("PPLUS");
  IElementType RET = new GdTokenType("RET");
  IElementType RETURN = new GdTokenType("RETURN");
  IElementType RRBR = new GdTokenType("RRBR");
  IElementType SELF = new GdTokenType("SELF");
  IElementType SEMICON = new GdTokenType("SEMICON");
  IElementType SETGET = new GdTokenType("SETGET");
  IElementType SIGNAL = new GdTokenType("SIGNAL");
  IElementType STR = new GdTokenType("STR");
  IElementType STRING = new GdTokenType("STRING");
  IElementType TAU = new GdTokenType("TAU");
  IElementType TOOL = new GdTokenType("TOOL");
  IElementType TRUE = new GdTokenType("TRUE");
  IElementType VAR = new GdTokenType("VAR");
  IElementType VOID = new GdTokenType("VOID");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ANNOTATION) {
        return new GdAnnotationImpl(node);
      }
      else if (type == ARG_LIST) {
        return new GdArgListImpl(node);
      }
      else if (type == ASSIGN_ST) {
        return new GdAssignStImpl(node);
      }
      else if (type == ATTRIBUTE_EX) {
        return new GdAttributeExImpl(node);
      }
      else if (type == ATT_EX_NM) {
        return new GdAttExNmImpl(node);
      }
      else if (type == BUILT_IN_TYPE) {
        return new GdBuiltInTypeImpl(node);
      }
      else if (type == CLASS_NAME_NM) {
        return new GdClassNameNmImpl(node);
      }
      else if (type == CLASS_NAMING) {
        return new GdClassNamingImpl(node);
      }
      else if (type == CLASS_VAR_DECL_TL) {
        return new GdClassVarDeclTlImpl(node);
      }
      else if (type == CLASS_VAR_ID_NMI) {
        return new GdClassVarIdNmiImpl(node);
      }
      else if (type == CONST_DECL_TL) {
        return new GdConstDeclTlImpl(node);
      }
      else if (type == CONST_ID_NMI) {
        return new GdConstIdNmiImpl(node);
      }
      else if (type == END_STMT) {
        return new GdEndStmtImpl(node);
      }
      else if (type == EXPR_ST) {
        return new GdExprStImpl(node);
      }
      else if (type == FLOW_ST) {
        return new GdFlowStImpl(node);
      }
      else if (type == GET_METHOD_ID_NM) {
        return new GdGetMethodIdNmImpl(node);
      }
      else if (type == INHERITANCE) {
        return new GdInheritanceImpl(node);
      }
      else if (type == INHERITANCE_ID_NMI) {
        return new GdInheritanceIdNmiImpl(node);
      }
      else if (type == LITERAL_EX) {
        return new GdLiteralExImpl(node);
      }
      else if (type == METHOD_DECL_TL) {
        return new GdMethodDeclTlImpl(node);
      }
      else if (type == METHOD_ID_NMI) {
        return new GdMethodIdNmiImpl(node);
      }
      else if (type == NEW_LINE_END) {
        return new GdNewLineEndImpl(node);
      }
      else if (type == PARAM) {
        return new GdParamImpl(node);
      }
      else if (type == PARAM_LIST) {
        return new GdParamListImpl(node);
      }
      else if (type == PARENT_METHOD_CALL) {
        return new GdParentMethodCallImpl(node);
      }
      else if (type == PLUS_MINUS_EX) {
        return new GdPlusMinusExImpl(node);
      }
      else if (type == PLUS_MINUS_PRE_EX) {
        return new GdPlusMinusPreExImpl(node);
      }
      else if (type == REF_ID_NM) {
        return new GdRefIdNmImpl(node);
      }
      else if (type == RETURN_HINT) {
        return new GdReturnHintImpl(node);
      }
      else if (type == SETGET_DECL) {
        return new GdSetgetDeclImpl(node);
      }
      else if (type == SET_METHOD_ID_NM) {
        return new GdSetMethodIdNmImpl(node);
      }
      else if (type == SIGNAL_DECL_TL) {
        return new GdSignalDeclTlImpl(node);
      }
      else if (type == SIGNAL_ID_NMI) {
        return new GdSignalIdNmiImpl(node);
      }
      else if (type == SIGNAL_PAR_LIST) {
        return new GdSignalParListImpl(node);
      }
      else if (type == STMT_OR_SUITE) {
        return new GdStmtOrSuiteImpl(node);
      }
      else if (type == SUITE) {
        return new GdSuiteImpl(node);
      }
      else if (type == TOOLLINE) {
        return new GdToollineImpl(node);
      }
      else if (type == TYPED) {
        return new GdTypedImpl(node);
      }
      else if (type == TYPE_HINT_NM) {
        return new GdTypeHintNmImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
