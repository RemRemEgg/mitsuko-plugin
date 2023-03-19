package mitsuko_plugin;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class MitsukoFile extends PsiFileBase {
    public MitsukoFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, MitsukoLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return MitsukoFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Mitsuko File";
    }
}