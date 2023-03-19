package mitsuko_plugin;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class MitsukoColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Tag//Defining area", MitsukoSyntaxHighlighter.TAG_DEF),
            new AttributesDescriptor("Tag//Name", MitsukoSyntaxHighlighter.TAG_NAME),
            new AttributesDescriptor("Tag//Value", MitsukoSyntaxHighlighter.TAG_VALUE),
            new AttributesDescriptor("Function//Keyword", MitsukoSyntaxHighlighter.FN_KEYWORD),
            new AttributesDescriptor("Function//Name", MitsukoSyntaxHighlighter.FN_NAME),
            new AttributesDescriptor("Function//Call", MitsukoSyntaxHighlighter.FN_CALL),
            new AttributesDescriptor("Command//Start", MitsukoSyntaxHighlighter.COMMAND_START),
            new AttributesDescriptor("Command//Custom", MitsukoSyntaxHighlighter.COMMAND_START_CUSTOM),
            new AttributesDescriptor("Command//Sub", MitsukoSyntaxHighlighter.SUB_COMMAND),
            new AttributesDescriptor("Command//Sub-Sub", MitsukoSyntaxHighlighter.SUB_SUB_COMMAND),
            new AttributesDescriptor("Command//Execute sub", MitsukoSyntaxHighlighter.EXE_SUB_COMMAND),
            new AttributesDescriptor("Command//Custom sub", MitsukoSyntaxHighlighter.SUB_CUSTOM),
            new AttributesDescriptor("NBT//Braces", MitsukoSyntaxHighlighter.NBT_BRACES),
            new AttributesDescriptor("NBT//String", MitsukoSyntaxHighlighter.STRING),
            new AttributesDescriptor("NBT//Property", MitsukoSyntaxHighlighter.NBT_PROPERTY),
            new AttributesDescriptor("NBT//Value", MitsukoSyntaxHighlighter.NBT_VALUE),
            new AttributesDescriptor("Score//Name", MitsukoSyntaxHighlighter.SCORE_NAME),
            new AttributesDescriptor("Score//Operation", MitsukoSyntaxHighlighter.SCORE_OPERATION),
            new AttributesDescriptor("Score//Temp", MitsukoSyntaxHighlighter.SCORE_TEMP),
            new AttributesDescriptor("Flow control//Command", MitsukoSyntaxHighlighter.FLOW_CONTROL),
            new AttributesDescriptor("Flow control//Parens", MitsukoSyntaxHighlighter.FLOW_PARENS),
            new AttributesDescriptor("Selector", MitsukoSyntaxHighlighter.SELECTOR),
            new AttributesDescriptor("Braces", MitsukoSyntaxHighlighter.BRACES),
            new AttributesDescriptor("Value", MitsukoSyntaxHighlighter.VALUE),
            new AttributesDescriptor("Bad value", MitsukoSyntaxHighlighter.BAD_CHARACTER)
    };

    @Override
    public Icon getIcon() {
        return MitsukoIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new MitsukoSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "// This is a comment uwu\n" +
                "\n" +
                "fn init() {\n" +
                "   // Runs on reload\n" +
                "   ast @a if block ~ ~-1 ~ stone run effect give @e[tag=&glow] glowing 1 1 true\n" +
                "   tellraw @a {\"text\":\"{$NAME} is installed!\"}\n" +
                "}\n" +
                "\n" +
                "fn main() {\n" +
                "   // Runs each tick (if bound to #minecraft:main or #remgine:tick)\n" +
                "   effect give @e[limit=1,sort=random] levitation 1 0 true\n" +
                "}\n" +
                "\n" +
                "// Something isn't right with this function, it won't compile!\n" +
                "#[debug = 2]\n" +
                "fn subfolder/problematic_function() {\n" +
                "   if (setblock) kill @s\n" +
                "}\n" +
                "\n" +
                "fn example() {\n" +
                "   ast @a if block ~ ~-1.0 ~ stone run data modify storage @e[limit=1,sort=nearest,type=!player] {NoGravity:1b}\n" +
                "   data modify storage @e[limit=1,sort=nearest,type=!player] {NoGravity:1b}\n" +
                "   give @s stick{display:{Name:'{\"text\":\"Sticky Stick\"}'}}\n" +
                "}";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Mitsuko";
    }
}