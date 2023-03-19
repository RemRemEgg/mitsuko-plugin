// This is a generated file. Not intended for manual editing.
package mitsuko_plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MitsukoFunctionFile extends PsiElement {

  @NotNull
  List<MitsukoFunction> getFunctionList();

  @NotNull
  List<MitsukoTag> getTagList();

}
