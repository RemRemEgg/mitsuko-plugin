package mitsuko_plugin.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;
import mitsuko_plugin.MitsukoFile;
import mitsuko_plugin.MitsukoFileType;

public class MitsukoElementFactory {
    public static MitsukoFnDefine createFunction(Project project, String name) {
        MitsukoFile file = createFile(project, name);
        return (MitsukoFnDefine) file.getFirstChild();
    }

    public static MitsukoFile createFile(Project project, String text) {
        String name = "dummy.msk";
        return (MitsukoFile) PsiFileFactory.getInstance(project).
                createFileFromText(name, MitsukoFileType.INSTANCE, text);
    }
}
