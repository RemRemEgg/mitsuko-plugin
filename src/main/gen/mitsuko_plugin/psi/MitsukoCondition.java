// This is a generated file. Not intended for manual editing.
package mitsuko_plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MitsukoCondition extends PsiElement {

  @NotNull
  List<MitsukoESelector> getESelectorList();

  @NotNull
  List<MitsukoNbt> getNbtList();

  @NotNull
  List<MitsukoScoreboard> getScoreboardList();

}
