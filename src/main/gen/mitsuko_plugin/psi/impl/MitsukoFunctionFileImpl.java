// This is a generated file. Not intended for manual editing.
package mitsuko_plugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static mitsuko_plugin.psi.MitsukoTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import mitsuko_plugin.psi.*;

public class MitsukoFunctionFileImpl extends ASTWrapperPsiElement implements MitsukoFunctionFile {

  public MitsukoFunctionFileImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MitsukoVisitor visitor) {
    visitor.visitFunctionFile(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MitsukoVisitor) accept((MitsukoVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<MitsukoFunction> getFunctionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MitsukoFunction.class);
  }

  @Override
  @NotNull
  public List<MitsukoTag> getTagList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MitsukoTag.class);
  }

}
