// This is a generated file. Not intended for manual editing.
package gdscript.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static gdscript.psi.GdTypes.*;
import gdscript.psi.*;

public class GdForStImpl extends GdStmtImpl implements GdForSt {

  public GdForStImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull GdVisitor visitor) {
    visitor.visitForSt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GdVisitor) accept((GdVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public GdExpr getExpr() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, GdExpr.class));
  }

  @Override
  @NotNull
  public GdStmtOrSuite getStmtOrSuite() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, GdStmtOrSuite.class));
  }

  @Override
  @NotNull
  public GdVarNmi getVarNmi() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, GdVarNmi.class));
  }

}
