// This is a generated file. Not intended for manual editing.
package mitsuko_plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MitsukoLines extends PsiElement {

  @NotNull
  List<MitsukoLines> getLinesList();

  @NotNull
  List<MitsukoMultiline> getMultilineList();

  @NotNull
  List<MitsukoNbt> getNbtList();

  @NotNull
  List<MitsukoOneline> getOnelineList();

}
