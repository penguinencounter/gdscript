// This is a generated file. Not intended for manual editing.
package tscn.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TscnJsonValue extends PsiElement {

  @Nullable
  TscnArray getArray();

  @Nullable
  TscnExprValue getExprValue();

  @Nullable
  TscnNumberValue getNumberValue();

  @Nullable
  TscnObject getObject();

}