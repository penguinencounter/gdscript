// This is a generated file. Not intended for manual editing.
package gdscript.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static gdscript.psi.GdTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import gdscript.psi.*;

public class GdMatchBlockImpl extends ASTWrapperPsiElement implements GdMatchBlock {

  public GdMatchBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GdVisitor visitor) {
    visitor.visitMatchBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GdVisitor) accept((GdVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<GdPatternList> getPatternListList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GdPatternList.class);
  }

  @Override
  @NotNull
  public List<GdStmtOrSuite> getStmtOrSuiteList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GdStmtOrSuite.class);
  }

}
