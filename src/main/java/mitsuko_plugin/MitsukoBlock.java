package mitsuko_plugin;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.TokenType;
import com.intellij.psi.formatter.common.AbstractBlock;
import com.intellij.psi.tree.IElementType;
import mitsuko_plugin.psi.MitsukoTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MitsukoBlock extends AbstractBlock {
    private final SpacingBuilder spacingBuilder;
    private Boolean branch;
    private Boolean indenter;

    protected MitsukoBlock(@NotNull ASTNode node, @Nullable Wrap wrap, @Nullable Alignment alignment,
                           SpacingBuilder spacingBuilder) {
        super(node, wrap, alignment);
        this.spacingBuilder = spacingBuilder;
        IElementType thistype = node.getElementType();
        this.indenter = false;
        this.branch = node.getFirstChildNode() != null;
        if (this.branch) {
            switch (thistype.toString()) {
                case "CODE":
                    this.indenter = true;
                case "Mitsuko.FN_OPEN":
                case "Mitsuko.FN_CLOSE":
                    this.branch = false;
                    break;
            }
        }
    }

    @Override
    protected List<Block> buildChildren() {
        List<Block> blocks = new ArrayList<>();
        ASTNode child = myNode.getFirstChildNode();
        while (child != null) {
            if (child.getElementType() != TokenType.WHITE_SPACE && child.getElementType() != MitsukoTypes.CRLF) {
                Block block = new MitsukoBlock(child, Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment(),
                        spacingBuilder);
                blocks.add(block);
            }
            child = child.getTreeNext();
        }
        return blocks;
    }

    @Override
    public Indent getIndent() {
        return this.indenter ? Indent.getIndent(Indent.Type.NORMAL, false, false) : Indent.getNoneIndent();
    }

    @Override
    public @Nullable Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
        return null;
    }

    @Override
    public boolean isLeaf() {
        return !branch;
    }
}