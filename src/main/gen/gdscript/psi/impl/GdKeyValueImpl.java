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

public class GdKeyValueImpl extends ASTWrapperPsiElement implements GdKeyValue {

  public GdKeyValueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GdVisitor visitor) {
    visitor.visitKeyValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GdVisitor) accept((GdVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<GdExpr> getExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GdExpr.class);
  }

  @Override
  @Nullable
  public GdNewLineEnd getNewLineEnd() {
    return PsiTreeUtil.getChildOfType(this, GdNewLineEnd.class);
  }

}
