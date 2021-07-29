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
import gdscript.index.stub.GdClassVarDeclStub;
import com.intellij.psi.stubs.IStubElementType;

public class GdClassVarDeclTlImpl extends GdClassVarDeclElementImpl implements GdClassVarDeclTl {

  public GdClassVarDeclTlImpl(@NotNull ASTNode node) {
    super(node);
  }

  public GdClassVarDeclTlImpl(@NotNull GdClassVarDeclStub stub, @NotNull IStubElementType<?, ?> nodeType) {
    super(stub, nodeType);
  }

  public void accept(@NotNull GdVisitor visitor) {
    visitor.visitClassVarDeclTl(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GdVisitor) accept((GdVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<GdAnnotation> getAnnotationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, GdAnnotation.class);
  }

  @Override
  @Nullable
  public GdClassVarIdNmi getClassVarIdNmi() {
    return PsiTreeUtil.getChildOfType(this, GdClassVarIdNmi.class);
  }

  @Override
  @Nullable
  public GdEndStmt getEndStmt() {
    return PsiTreeUtil.getChildOfType(this, GdEndStmt.class);
  }

  @Override
  @Nullable
  public GdExpr getExpr() {
    return PsiTreeUtil.getChildOfType(this, GdExpr.class);
  }

  @Override
  @Nullable
  public GdSetgetDecl getSetgetDecl() {
    return PsiTreeUtil.getChildOfType(this, GdSetgetDecl.class);
  }

  @Override
  @Nullable
  public GdTyped getTyped() {
    return PsiTreeUtil.getChildOfType(this, GdTyped.class);
  }

  @Override
  @Nullable
  public String getVarName() {
    return GdPsiUtils.getVarName(this);
  }

  @Override
  @Nullable
  public String getReturnType() {
    return GdPsiUtils.getReturnType(this);
  }

}
