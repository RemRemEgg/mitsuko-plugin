package mitsuko_plugin;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import mitsuko_plugin.parser.MitsukoParser;
import mitsuko_plugin.psi.MitsukoTokenSets;
import mitsuko_plugin.psi.MitsukoTypes;
import org.jetbrains.annotations.NotNull;

public class MitsukoParserDefinition implements ParserDefinition {
    public static final IFileElementType FILE = new IFileElementType(MitsukoLanguage.INSTANCE);

    @Override
    public @NotNull Lexer createLexer(Project project) {
        return new MitsukoLexerAdapter();
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return MitsukoTokenSets.COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @Override
    public @NotNull PsiParser createParser(final Project project) {
        return new MitsukoParser();
    }

    @NotNull
    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @Override
    public @NotNull PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new MitsukoFile(viewProvider);
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return MitsukoTypes.Factory.createElement(node);
    }
}