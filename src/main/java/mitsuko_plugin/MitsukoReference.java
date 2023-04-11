package mitsuko_plugin;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import mitsuko_plugin.psi.MitsukoFnDefine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MitsukoReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
    private final String key;
    public MitsukoReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
        key = element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset());
    }

    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        final List<MitsukoFnDefine> properties = MitsukoUtil.findFnDefines(project, key);
        List<ResolveResult> results = new ArrayList<>();
        for (MitsukoFnDefine property : properties) {
            results.add(new PsiElementResolveResult(property));
        }
        return results.toArray(new ResolveResult[results.size()]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @Override
    public Object @NotNull [] getVariants() {
        Project project = myElement.getProject();
        List<MitsukoFnDefine> properties = MitsukoUtil.findFnDefines(project);
        List<LookupElement> variants = new ArrayList<>();
        for (final MitsukoFnDefine property : properties) {
//            if (property.getName() != null && property.getName().length() > 0) {
//                variants.add(LookupElementBuilder
//                        .create(property).withIcon(MitsukoIcons.FILE)
//                        .withTypeText(property.getContainingFile().getName())
//                );
//            }
        }
        return variants.toArray();
    }
}