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

public class MitsukoItemContentImpl extends ASTWrapperPsiElement implements MitsukoItemContent {

  public MitsukoItemContentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MitsukoVisitor visitor) {
    visitor.visitItemContent(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MitsukoVisitor) accept((MitsukoVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<MitsukoLines> getLinesList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MitsukoLines.class);
  }

  @Override
  @NotNull
  public List<MitsukoMultiline> getMultilineList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MitsukoMultiline.class);
  }

  @Override
  @NotNull
  public List<MitsukoNbt> getNbtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MitsukoNbt.class);
  }

  @Override
  @NotNull
  public List<MitsukoOneline> getOnelineList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MitsukoOneline.class);
  }

}
