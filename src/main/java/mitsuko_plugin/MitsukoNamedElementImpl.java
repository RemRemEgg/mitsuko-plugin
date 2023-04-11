package mitsuko_plugin;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public abstract class MitsukoNamedElementImpl extends ASTWrapperPsiElement implements MitsukoNamedElement {
    public MitsukoNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}