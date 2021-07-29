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

public class GdSetgetDeclImpl extends ASTWrapperPsiElement implements GdSetgetDecl {

  public GdSetgetDeclImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GdVisitor visitor) {
    visitor.visitSetgetDecl(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GdVisitor) accept((GdVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GdGetMethodIdNm getGetMethodIdNm() {
    return PsiTreeUtil.getChildOfType(this, GdGetMethodIdNm.class);
  }

  @Override
  @NotNull
  public GdSetMethodIdNm getSetMethodIdNm() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, GdSetMethodIdNm.class));
  }

}
