// This is a generated file. Not intended for manual editing.
package tscn.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import tscn.psi.impl.TscnNodeHeaderElementType;
import tscn.psi.impl.TscnParagraphElementType;
import tscn.psi.impl.TscnResourceHeaderElementType;
import tscn.psi.impl.*;

public interface TscnTypes {

  IElementType DATA_LINE = new TscnElementType("DATA_LINE");
  IElementType DATA_LINE_NM = new TscnElementType("DATA_LINE_NM");
  IElementType DATA_LINE_VALUE = new TscnElementType("DATA_LINE_VALUE");
  IElementType HEADER = new TscnElementType("HEADER");
  IElementType HEADER_VALUE = new TscnElementType("HEADER_VALUE");
  IElementType HEADER_VALUE_NM = new TscnElementType("HEADER_VALUE_NM");
  IElementType HEADER_VALUE_VAL = new TscnElementType("HEADER_VALUE_VAL");
  IElementType NODE_HEADER = TscnNodeHeaderElementType.getInstance("NODE_HEADER");
  IElementType PARAGRAPH = TscnParagraphElementType.getInstance("PARAGRAPH");
  IElementType RESOURCE_HEADER = TscnResourceHeaderElementType.getInstance("RESOURCE_HEADER");
  IElementType SCENE_HEADER = new TscnElementType("SCENE_HEADER");
  IElementType SUB_HEADER = new TscnElementType("SUB_HEADER");

  IElementType BAD_CHARACTER = new TscnTokenType("bad_character");
  IElementType COMMENT = new TscnTokenType("comment");
  IElementType CONNECTION = new TscnTokenType("CONNECTION");
  IElementType EQ = new TscnTokenType("EQ");
  IElementType EXT_RESOURCE = new TscnTokenType("EXT_RESOURCE");
  IElementType GD_SCENE = new TscnTokenType("GD_SCENE");
  IElementType IDENTIFIER = new TscnTokenType("IDENTIFIER");
  IElementType LSBR = new TscnTokenType("LSBR");
  IElementType NODE = new TscnTokenType("NODE");
  IElementType RSBR = new TscnTokenType("RSBR");
  IElementType SUB_RESOURCE = new TscnTokenType("SUB_RESOURCE");
  IElementType VALUE = new TscnTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == DATA_LINE) {
        return new TscnDataLineImpl(node);
      }
      else if (type == DATA_LINE_NM) {
        return new TscnDataLineNmImpl(node);
      }
      else if (type == DATA_LINE_VALUE) {
        return new TscnDataLineValueImpl(node);
      }
      else if (type == HEADER_VALUE) {
        return new TscnHeaderValueImpl(node);
      }
      else if (type == HEADER_VALUE_NM) {
        return new TscnHeaderValueNmImpl(node);
      }
      else if (type == HEADER_VALUE_VAL) {
        return new TscnHeaderValueValImpl(node);
      }
      else if (type == NODE_HEADER) {
        return new TscnNodeHeaderImpl(node);
      }
      else if (type == PARAGRAPH) {
        return new TscnParagraphImpl(node);
      }
      else if (type == RESOURCE_HEADER) {
        return new TscnResourceHeaderImpl(node);
      }
      else if (type == SCENE_HEADER) {
        return new TscnSceneHeaderImpl(node);
      }
      else if (type == SUB_HEADER) {
        return new TscnSubHeaderImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
