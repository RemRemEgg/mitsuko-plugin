package mitsuko_plugin;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import mitsuko_plugin.psi.MitsukoTypes;
import org.jetbrains.annotations.NotNull;

public class MitsukoCompletionContributor extends CompletionContributor {
    public MitsukoCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(MitsukoTypes.WHITE1),
                new CompletionProvider<>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("fn"));
                    }
                }
        );
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(MitsukoTypes.TAG_NAME),
                new CompletionProvider<>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("comments"));
                        resultSet.addElement(LookupElementBuilder.create("debug"));
                        resultSet.addElement(LookupElementBuilder.create("optimizations"));
                        resultSet.addElement(LookupElementBuilder.create("recursive_replace"));
                    }
                }
        );
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(MitsukoTypes.TAG_VALUE),
                new CompletionProvider<>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        PsiElement pos = parameters.getOriginalPosition();
                        if (pos != null) {
                            String tag = "";
                            int offset = -1;
                            while (offset > -16) {
                                PsiElement o = parameters.getOriginalFile().findElementAt(pos.getTextOffset() + offset);
                                if (o != null && o.isValid() && o.getNode().getElementType().equals(MitsukoTypes.TAG_NAME)) {
                                    tag = o.getText();
                                    break;
                                }
                                offset--;
                            }
                            if (!tag.equals("")) {
                                if (tag.equals("comments")) {
                                    resultSet.addElement(LookupElementBuilder.create("true"));
                                    resultSet.addElement(LookupElementBuilder.create("false"));
                                } else if (tag.equals("debug") || tag.equals("optimizations")) {
                                    resultSet.addElement(LookupElementBuilder.create("0"));
                                    resultSet.addElement(LookupElementBuilder.create("1"));
                                    resultSet.addElement(LookupElementBuilder.create("2"));
                                }
                            }
                        }
                    }
                }
        );
    }

}