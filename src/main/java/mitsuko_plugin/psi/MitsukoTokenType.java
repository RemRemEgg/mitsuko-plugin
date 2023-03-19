package mitsuko_plugin.psi;

import com.intellij.lang.Language;
import com.intellij.psi.tree.IElementType;
import mitsuko_plugin.MitsukoLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class MitsukoTokenType extends IElementType {
    public MitsukoTokenType(@NotNull @NonNls String debugName) {
        super(debugName, MitsukoLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "Mitsuko." + super.toString();
    }
}
