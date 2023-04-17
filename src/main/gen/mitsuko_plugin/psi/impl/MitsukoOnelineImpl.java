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

public class MitsukoOnelineImpl extends ASTWrapperPsiElement implements MitsukoOneline {

  public MitsukoOnelineImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MitsukoVisitor visitor) {
    visitor.visitOneline(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MitsukoVisitor) accept((MitsukoVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<MitsukoESelector> getESelectorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MitsukoESelector.class);
  }

  @Override
  @NotNull
  public List<MitsukoNbt> getNbtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MitsukoNbt.class);
  }

  @Override
  @NotNull
  public List<MitsukoScoreboard> getScoreboardList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MitsukoScoreboard.class);
  }

  @Override
  @Nullable
  public MitsukoShortScore getShortScore() {
    return findChildByClass(MitsukoShortScore.class);
  }

}
