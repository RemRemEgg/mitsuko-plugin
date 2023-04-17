package mitsuko_plugin;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.ui.JBColor;
import mitsuko_plugin.psi.MitsukoTypes;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class MitsukoSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("MSK_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("MSK_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
    public static final TextAttributesKey BRACES =
            createTextAttributesKey("MSK_BRACES", HighlighterColors.NO_HIGHLIGHTING);
    public static final TextAttributesKey VALUE =
            createTextAttributesKey("MSK_VALUE", DefaultLanguageHighlighterColors.VALID_STRING_ESCAPE);

    public static final TextAttributesKey TAG_DEF =
            createTextAttributesKey("MSK_TAG_DEF", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey TAG_NAME =
            createTextAttributesKey("MSK_TAG_NAME", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey TAG_VALUE =
            createTextAttributesKey("MSK_TAG_VALUE", DefaultLanguageHighlighterColors.VALID_STRING_ESCAPE);

    public static final TextAttributesKey FN_KEYWORD =
            createTextAttributesKey("MSK_FN_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey FN_NAME =
            createTextAttributesKey("MSK_FN_NAME", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);

    public static final TextAttributesKey COMMAND_START =
            createTextAttributesKey("MSK_COMMAND_START", new TextAttributes(JBColor.getHSBColor(.06f, .6f, 1f), null, null, null, Font.PLAIN));
    public static final TextAttributesKey COMMAND_START_CUSTOM =
            createTextAttributesKey("MSK_COMMAND_START_CUSTOM", new TextAttributes(JBColor.getHSBColor(.05f, .5f, 1f), null, null, null, Font.PLAIN));

    public static final TextAttributesKey SUB_COMMAND =
            createTextAttributesKey("MSK_SUB_COMMAND", new TextAttributes(JBColor.getHSBColor(.48f, .8f, .9f), null, null, null, Font.PLAIN));
    public static final TextAttributesKey SUB_SUB_COMMAND =
            createTextAttributesKey("MSK_SUB_SUB_COMMAND", new TextAttributes(JBColor.getHSBColor(.55f, .6f, .9f), null, null, null, Font.PLAIN));
    public static final TextAttributesKey EXE_SUB_COMMAND =
            createTextAttributesKey("MSK_EXE_SUB_COMMAND", new TextAttributes(JBColor.getHSBColor(.4f, .35f, .85f), null, null, null, Font.PLAIN));
    public static final TextAttributesKey SUB_CUSTOM =
            createTextAttributesKey("MSK_SUB_CUSTOM", new TextAttributes(JBColor.getHSBColor(.35f, .35f, .85f), null, null, null, Font.PLAIN));

    public static final TextAttributesKey FN_CALL =
            createTextAttributesKey("MSK_FN_CALL", DefaultLanguageHighlighterColors.FUNCTION_CALL);

    public static final TextAttributesKey NUMBER =
            createTextAttributesKey("MSK_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey STRING =
            createTextAttributesKey("MSK_STRING", DefaultLanguageHighlighterColors.STRING);

    public static final TextAttributesKey NBT_BRACES =
            createTextAttributesKey("MSK_NBT_BRACES", DefaultLanguageHighlighterColors.DOC_COMMENT_TAG_VALUE);
    public static final TextAttributesKey NBT_PROPERTY =
            createTextAttributesKey("MSK_NBT_PROPERTY", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey NBT_VALUE =
            createTextAttributesKey("MSK_NBT_VALUE", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey SELECTOR =
            createTextAttributesKey("MSK_NBT_SELECTOR", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);

    public static final TextAttributesKey SCORE_NAME =
            createTextAttributesKey("MSK_SCORE_NAME", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey SCORE_OPERATION =
            createTextAttributesKey("MSK_SCORE_OPERATION", SUB_COMMAND);
    public static final TextAttributesKey SCORE_TEMP =
            createTextAttributesKey("MSK_SCORE_TEMP", DefaultLanguageHighlighterColors.CONSTANT);

    public static final TextAttributesKey FLOW_CONTROL =
            createTextAttributesKey("MSK_FLOW_CONTROL", COMMAND_START_CUSTOM);
    public static final TextAttributesKey FLOW_PARENS =
            createTextAttributesKey("MSK_FLOW_PARENS", BRACES);


    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] BRACES_KEYS = new TextAttributesKey[]{BRACES};
    private static final TextAttributesKey[] VALUE_KEYS = new TextAttributesKey[]{VALUE};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    private static final TextAttributesKey[] TAG_DEF_KEYS = new TextAttributesKey[]{TAG_DEF};
    private static final TextAttributesKey[] TAG_NAME_KEYS = new TextAttributesKey[]{TAG_NAME};
    private static final TextAttributesKey[] TAG_VALUE_KEYS = new TextAttributesKey[]{TAG_VALUE};

    private static final TextAttributesKey[] FN_KEYWORD_KEYS = new TextAttributesKey[]{FN_KEYWORD};
    private static final TextAttributesKey[] FN_NAME_KEYS = new TextAttributesKey[]{FN_NAME};

    private static final TextAttributesKey[] FN_COMMAND_START = new TextAttributesKey[]{COMMAND_START};
    private static final TextAttributesKey[] FN_COMMAND_START_CUSTOM = new TextAttributesKey[]{COMMAND_START_CUSTOM};

    private static final TextAttributesKey[] SUB_COMMAND_KEYS = new TextAttributesKey[]{SUB_COMMAND};
    private static final TextAttributesKey[] SUB_SUB_COMMAND_KEYS = new TextAttributesKey[]{SUB_SUB_COMMAND};
    private static final TextAttributesKey[] EXE_SUB_COMMAND_KEYS = new TextAttributesKey[]{EXE_SUB_COMMAND};
    private static final TextAttributesKey[] SUB_CUSTOM_KEYS = new TextAttributesKey[]{SUB_CUSTOM};
    
    private static final TextAttributesKey[] FN_CALL_KEYS = new TextAttributesKey[]{FN_CALL};
    
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] NBT_BRACES_KEYS = new TextAttributesKey[]{NBT_BRACES};
    private static final TextAttributesKey[] NBT_PROPERTY_KEYS = new TextAttributesKey[]{NBT_PROPERTY};
    private static final TextAttributesKey[] NBT_VALUE_KEYS = new TextAttributesKey[]{NBT_VALUE};
    private static final TextAttributesKey[] SELECTOR_KEYS = new TextAttributesKey[]{SELECTOR};
    
    private static final TextAttributesKey[] SCORE_NAME_KEYS = new TextAttributesKey[]{SCORE_NAME};
    private static final TextAttributesKey[] SCORE_OPERATION_KEYS = new TextAttributesKey[]{SCORE_OPERATION};
    private static final TextAttributesKey[] SCORE_TEMP_KEYS = new TextAttributesKey[]{SCORE_TEMP};
    
    private static final TextAttributesKey[] FLOW_CONTROL_KEYS = new TextAttributesKey[]{FLOW_CONTROL};
    private static final TextAttributesKey[] FLOW_PARENS_KEYS = new TextAttributesKey[]{FLOW_PARENS};

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new MitsukoLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(MitsukoTypes.MSK_COMMENT)) {
            return COMMENT_KEYS;
        }
        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        }
        if (tokenType.equals(MitsukoTypes.VALUE)) {
            return VALUE_KEYS;
        }
        if (tokenType.equals(MitsukoTypes.TAG_DEF)) {
            return TAG_DEF_KEYS;
        }
        if (tokenType.equals(MitsukoTypes.TAG_VALUE)) {
            return TAG_VALUE_KEYS;
        }
        if (tokenType.equals(MitsukoTypes.TAG_NAME)) {
            return TAG_NAME_KEYS;
        }
        if (tokenType.equals(MitsukoTypes.FN_KEYWORD)) {
            return FN_KEYWORD_KEYS;
        }
        if (tokenType.equals(MitsukoTypes.FN_NAME)) {
            return FN_NAME_KEYS;
        }
        if (tokenType.equals(MitsukoTypes.FN_OPEN) || tokenType.equals(MitsukoTypes.FN_CLOSE)) {
            return BRACES_KEYS;
        }
        if (tokenType.equals(MitsukoTypes.COMMAND_START)) {
            return FN_COMMAND_START;
        }
        if (tokenType.equals(MitsukoTypes.CODE_CUSTOM)) {
            return FN_COMMAND_START_CUSTOM;
        }
        if (tokenType.equals(MitsukoTypes.SUB_1)) {
            return SUB_COMMAND_KEYS;
        }
        if (tokenType.equals(MitsukoTypes.SUB_2)) {
            return SUB_SUB_COMMAND_KEYS;
        }
        if (tokenType.equals(MitsukoTypes.EXE_SUB)) {
            return EXE_SUB_COMMAND_KEYS;
        }
        if (tokenType.equals(MitsukoTypes.SUB_CUSTOM)) {
            return EXE_SUB_COMMAND_KEYS;
        }
        if (tokenType.equals(MitsukoTypes.PIDENT)) {
            return NUMBER_KEYS;
        }
        if (tokenType.equals(MitsukoTypes.FN_CALL)) {
            return FN_CALL_KEYS;
        }
        if (tokenType.equals(MitsukoTypes.NBT_STRING)) {
            return STRING_KEYS;
        }
        if (tokenType.equals(MitsukoTypes.NBT_BRACES)) {
            return NBT_BRACES_KEYS;
        }
        if (tokenType.equals(MitsukoTypes.NBT_VALUE)) {
            return NBT_VALUE_KEYS;
        }
        if (tokenType.equals(MitsukoTypes.NBT_PROPERTY)) {
            return NBT_PROPERTY_KEYS;
        }
        if (tokenType.equals(MitsukoTypes.SELECTOR)) {
            return SELECTOR_KEYS;
        }
        if (tokenType.equals(MitsukoTypes.SCORE_NAME)) {
            return SCORE_NAME_KEYS;
        }
        if (tokenType.equals(MitsukoTypes.SCORE_OPERATION)) {
            return SCORE_OPERATION_KEYS;
        }
        if (tokenType.equals(MitsukoTypes.SCOREBOARD_TEMP)) {
            return SCORE_TEMP_KEYS;
        }
        if (tokenType.equals(MitsukoTypes.FLOW_CONTROL)) {
            return FLOW_CONTROL_KEYS;
        }
        if (tokenType.equals(MitsukoTypes.PARENS)) {
            return FLOW_PARENS_KEYS;
        }
        return EMPTY_KEYS;
    }

}