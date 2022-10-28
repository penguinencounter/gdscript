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
import com.intellij.psi.PsiFile;

public class GdInheritanceIdNmImpl extends GdNamedElementImpl implements GdInheritanceIdNm {

  public GdInheritanceIdNmImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GdVisitor visitor) {
    visitor.visitInheritanceIdNm(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GdVisitor) accept((GdVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiFile getPsiFile() {
    return GdPsiUtils.getPsiFile(this);
  }

  @Override
  public boolean isClassName() {
    return GdPsiUtils.isClassName(this);
  }

  @Override
  @NotNull
  public String getName() {
    return GdPsiUtils.getName(this);
  }

  @Override
  @NotNull
  public PsiElement setName(@Nullable String newName) {
    return GdPsiUtils.setName(this, newName);
  }

}