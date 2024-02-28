// This is a generated file. Not intended for manual editing.
package tscn.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static tscn.psi.TscnTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import tscn.psi.*;

public class TscnJsonValueImpl extends ASTWrapperPsiElement implements TscnJsonValue {

  public TscnJsonValueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TscnVisitor visitor) {
    visitor.visitJsonValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TscnVisitor) accept((TscnVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public TscnArray getArray() {
    return PsiTreeUtil.getChildOfType(this, TscnArray.class);
  }

  @Override
  @Nullable
  public TscnExprValue getExprValue() {
    return PsiTreeUtil.getChildOfType(this, TscnExprValue.class);
  }

  @Override
  @Nullable
  public TscnNumberValue getNumberValue() {
    return PsiTreeUtil.getChildOfType(this, TscnNumberValue.class);
  }

  @Override
  @Nullable
  public TscnObject getObject() {
    return PsiTreeUtil.getChildOfType(this, TscnObject.class);
  }

}
