package mitsuko_plugin.psi;

import com.intellij.psi.tree.TokenSet;

public interface MitsukoTokenSets {
    TokenSet COMMENTS = TokenSet.create(MitsukoTypes.MSK_COMMENT);
}
