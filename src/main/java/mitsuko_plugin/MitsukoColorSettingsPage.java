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
        return "#[optimizations=2]\n" +
                "#[debug=1]\n" +
                "\n" +
                "fn install() {\n" +
                "    create &const\n" +
                "    .seed:&const result seed\n" +
                "    .rng:&const = .seed:&const\n" +
                "    gamerule randomTickSpeed 100\n" +
                "    tellraw @a *JSON{aqua bold underlined : Successfully installed *{NS}}\n" +
                "}\n" +
                "\n" +
                "fn uninstall() {\n" +
                "    remove &const\n" +
                "}\n" +
                "\n" +
                "fn init() {\n" +
                "    effect give @a[tag=&vision] night_vision 10 100 true\n" +
                "}\n" +
                "\n" +
                "fn main() {\n" +
                "    .rng:&const *= 65535\n" +
                "    .rng:&const --\n" +
                "    ast @e run entity/tick()\n" +
                "    ast @a run player/tick()\n" +
                "}\n" +
                "\n" +
                "fn entity/tick() {\n" +
                "    @s:&const += .rng:&const\n" +
                "    if (entity @s[type=#remgine:projectile,tag=!r&ignore,tag=&boost]) {\n" +
                "        ast @s run tp @s ~ ~ ~ facing entity @p[gamemode=!spectator] eyes\n" +
                "        rmm @s 10\n" +
                "    }\n" +
                "    if (block ~ ~-1 ~ stone && @s:&const == 0..144000) #mixins/rng_on_stone()\n" +
                "}\n" +
                "\n" +
                "fn summon_hoard_1() {\n" +
                "    set type zombie\n" +
                "    for ($i, 10) {\n" +
                "        summon *{type} ~ ~ ~ {Tags:[*{NS}.hoard]}\n" +
                "    }\n" +
                "    ast @e[tag=&hoard,type=*{type}] run {\n" +
                "        set effect effect give @s\n" +
                "        *{effect} speed 1 infinite\n" +
                "        *{effect} strength 1 infinite\n" +
                "        *{effect} resistance 0 infinite\n" +
                "        if (random 25) *{effect} absorption 5 infinite\n" +
                "    }\n" +
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