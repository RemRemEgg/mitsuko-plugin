package mitsuko_plugin;

import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import mitsuko_plugin.psi.MitsukoFnDefine;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class MitsukoUtil {
    public static List<MitsukoFnDefine> findFnDefines(Project project, String key) {
        List<MitsukoFnDefine> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(MitsukoFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            MitsukoFile mitsukoFile = (MitsukoFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (mitsukoFile != null) {
                MitsukoFnDefine[] properties = PsiTreeUtil.getChildrenOfType(mitsukoFile, MitsukoFnDefine.class);
                if (properties != null) {
                    for (MitsukoFnDefine property : properties) {
//                        if (key.equals(property.getName())) {
//                            result.add(property);
//                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<MitsukoFnDefine> findFnDefines(Project project) {
        List<MitsukoFnDefine> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(MitsukoFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            MitsukoFile simpleFile = (MitsukoFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (simpleFile != null) {
                MitsukoFnDefine[] properties = PsiTreeUtil.getChildrenOfType(simpleFile, MitsukoFnDefine.class);
                if (properties != null) {
                    Collections.addAll(result, properties);
                }
            }
        }
        return result;
    }

    public static @NotNull String findDocumentationComment(MitsukoFnDefine property) {
        List<String> result = new LinkedList<>();
        PsiElement element = property.getPrevSibling();
        while (element instanceof PsiComment || element instanceof PsiWhiteSpace) {
            if (element instanceof PsiComment) {
                String commentText = element.getText().replaceFirst("[!# ]+", "");
                result.add(commentText);
            }
            element = element.getPrevSibling();
        }
        return StringUtil.join(Lists.reverse(result),"\n ");
    }
}
