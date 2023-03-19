package mitsuko_plugin;

import com.intellij.lang.Language;

public class MitsukoLanguage extends Language {
    public static final MitsukoLanguage INSTANCE = new MitsukoLanguage();

    private MitsukoLanguage() {
        super("Mitsuko");
    }
}
