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

public class MitsukoItemFileImpl extends ASTWrapperPsiElement implements MitsukoItemFile {

  public MitsukoItemFileImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MitsukoVisitor visitor) {
    visitor.visitItemFile(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MitsukoVisitor) accept((MitsukoVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<MitsukoItemContent> getItemContentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MitsukoItemContent.class);
  }

  @Override
  @NotNull
  public List<MitsukoW> getWList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MitsukoW.class);
  }

}
