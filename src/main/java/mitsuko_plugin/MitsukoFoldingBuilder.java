package mitsuko_plugin;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.FoldingGroup;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLiteralExpression;
import com.intellij.psi.util.PsiTreeUtil;
import mitsuko_plugin.psi.MitsukoBlock;
import mitsuko_plugin.psi.MitsukoFnBody;
import mitsuko_plugin.psi.MitsukoLines;
import mitsuko_plugin.psi.MitsukoNbt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MitsukoFoldingBuilder extends FoldingBuilderEx implements DumbAware {

    @Override
    public FoldingDescriptor @NotNull [] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document, boolean quick) {
        List<FoldingDescriptor> descriptors = new ArrayList<>();

        Collection<MitsukoLines> blocks =
                PsiTreeUtil.findChildrenOfType(root, MitsukoLines.class);
        for (final MitsukoLines block : blocks) {
            if (block.getTextRange().getLength() > 0) {
                descriptors.add(new FoldingDescriptor(block.getNode(),
                        new TextRange(block.getTextRange().getStartOffset(),
                                block.getTextRange().getEndOffset())));
            }
        }
        Collection<MitsukoFnBody> fns =
                PsiTreeUtil.findChildrenOfType(root, MitsukoFnBody.class);
        for (final MitsukoFnBody block : fns) {
            if (block.getTextRange().getLength() > 0) {
                descriptors.add(new FoldingDescriptor(block.getNode(),
                        new TextRange(block.getTextRange().getStartOffset() + 1,
                                block.getTextRange().getEndOffset())));
            }
        }
        Collection<MitsukoNbt> nbts =
                PsiTreeUtil.findChildrenOfType(root, MitsukoNbt.class);
        for (final MitsukoNbt block : nbts) {
            if (block.getTextRange().getLength() > 0) {
                try {
                    descriptors.add(new FoldingDescriptor(block.getNode(),
                            new TextRange(block.getTextRange().getStartOffset(),
                                    block.getTextRange().getEndOffset() - (block.getText().endsWith(" ") ? 1 : 0))));
                } catch (Exception ignored) {
                    descriptors.add(new FoldingDescriptor(block.getNode(),
                            new TextRange(block.getTextRange().getStartOffset(),
                                    block.getTextRange().getStartOffset() + 1)));
                }
            }
        }

        return descriptors.toArray(new FoldingDescriptor[0]);
    }

    @Nullable
    @Override
    public String getPlaceholderText(@NotNull ASTNode node) {
        return node.getText().trim().startsWith("{") ? "{...}" : node.getText().trim().startsWith("[") ? "[...]" : "...";
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }
}