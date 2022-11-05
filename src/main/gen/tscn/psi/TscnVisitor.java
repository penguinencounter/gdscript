// This is a generated file. Not intended for manual editing.
package tscn.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class TscnVisitor extends PsiElementVisitor {

  public void visitConnectionHeader(@NotNull TscnConnectionHeader o) {
    visitHeader(o);
  }

  public void visitDataLine(@NotNull TscnDataLine o) {
    visitPsiElement(o);
  }

  public void visitDataLineNm(@NotNull TscnDataLineNm o) {
    visitPsiElement(o);
  }

  public void visitDataLineValue(@NotNull TscnDataLineValue o) {
    visitPsiElement(o);
  }

  public void visitHeader(@NotNull TscnHeader o) {
    visitPsiElement(o);
  }

  public void visitHeaderValue(@NotNull TscnHeaderValue o) {
    visitPsiElement(o);
  }

  public void visitHeaderValueNm(@NotNull TscnHeaderValueNm o) {
    visitPsiElement(o);
  }

  public void visitHeaderValueVal(@NotNull TscnHeaderValueVal o) {
    visitPsiElement(o);
  }

  public void visitNodeHeader(@NotNull TscnNodeHeader o) {
    visitHeader(o);
  }

  public void visitParagraph(@NotNull TscnParagraph o) {
    visitPsiElement(o);
  }

  public void visitResourceHeader(@NotNull TscnResourceHeader o) {
    visitHeader(o);
  }

  public void visitSceneHeader(@NotNull TscnSceneHeader o) {
    visitHeader(o);
  }

  public void visitUnknownHeader(@NotNull TscnUnknownHeader o) {
    visitHeader(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
