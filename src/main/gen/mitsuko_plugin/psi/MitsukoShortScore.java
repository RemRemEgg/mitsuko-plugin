// This is a generated file. Not intended for manual editing.
package mitsuko_plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MitsukoShortScore extends PsiElement {

  @Nullable
  MitsukoOneline getOneline();

  @NotNull
  List<MitsukoScoreboard> getScoreboardList();

}
