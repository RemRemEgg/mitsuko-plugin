package mitsuko_plugin;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class MitsukoFileType  extends LanguageFileType {
    public static final MitsukoFileType INSTANCE = new MitsukoFileType();

    private MitsukoFileType() {
        super(MitsukoLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Mitsuko";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Mitsuko language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "msk";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return MitsukoIcons.FILE;
    }
}