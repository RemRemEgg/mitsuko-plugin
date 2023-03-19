package mitsuko_plugin.psi;

import com.intellij.psi.tree.IElementType;
import mitsuko_plugin.MitsukoLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class MitsukoElementType extends IElementType {
    public MitsukoElementType(@NotNull @NonNls String debugName) {
        super(debugName, MitsukoLanguage.INSTANCE);
    }
}
