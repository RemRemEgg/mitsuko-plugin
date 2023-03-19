package mitsuko_plugin;

import com.intellij.lexer.FlexAdapter;

public class MitsukoLexerAdapter extends FlexAdapter {
    public MitsukoLexerAdapter() {
        super(new MitsukoLexer(null));
    }
}