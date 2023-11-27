package mitsuko_plugin;

import static com.intellij.codeInsight.completion.CompletionType.*;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.ProcessingContext;

import static mitsuko_plugin.psi.MitsukoTypes.*;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;


public class MitsukoCompletionContributor extends CompletionContributor {
    public MitsukoCompletionContributor() {
        
//        _extend(SUB_UNKNOWN, "simple_1", "simple_2");
        
//        extend(BASIC, PlatformPatterns.psiElement(SUB_UNKNOWN),
//                new CompletionProvider<>() {
//                    public void addCompletions(@NotNull CompletionParameters parameters,
//                                               @NotNull ProcessingContext context,
//                                               @NotNull CompletionResultSet resultSet) {
//                        resultSet.addElement(LookupElementBuilder.create("complex_1"));
//                        resultSet.addElement(LookupElementBuilder.create("complex_2"));
//                    }
//                }
//        );
        _extend(TAG_NAME, "comments", "debug", "optimizations", "recursive_replace");
        _extend(BASIC, TAG_NAME, (p,c,r) -> {
            if (p.getOriginalFile().getName().trim().equals("pack.msk")) {
                _add(r, "description", "name", "remgine", "version");
            }
        });
        _extend(BASIC, ITEM_GROUP, (p,c,r) -> _add(r, "materials", "recipe", "path", "item"));
        _extend(BASIC, TAG_VALUE, (p,c,r) -> {
            switch (Objects.requireNonNull(p.getPosition().getParent().getNode().findChildByType(TAG_NAME)).getText().trim()) {
                case "comments": case "remgine": _add(r, true, false); break;
                case "optimizations": case "debug": _add(r, 0, 1, 2); break;
                case "version": _add(r, 12); break;
                case "description": _add(r, "\u00a7"); break;
            }
        });
        _extend(SUB_UNKNOWN, "return", "advancement","attribute","bossbar","clear","clone","data","datapack","debug","defaultgamemode","difficulty","effect","enchant","execute","experience","fill","forceload","function","gamemode","gamerule","give","help","kick","kill","list","locate","loot","me","msg","particle","playsound","publish","recipe","reload","item","say","schedule","scoreboard","seed","setblock","setworldspawn","spawnpoint","spectate","spreadplayers","stopsound","summon","tag","team","teammsg","teleport","tell","tellraw","time","title","tm","tp","trigger","weather","worldborder","xp","jfr","place","fillbiome","ride","damage","exe","ast","set","if","while","loop","for","rmm","cmd","create","remove");
    }

    public void _add(CompletionResultSet r, Object... s) {
        for (Object _s : s) {
            r.addElement(LookupElementBuilder.create(_s));
        }
    }
    
    public void _extend(IElementType e, Object... s) {
        _extend(BASIC, e, (p, c, r) -> _add(r, s));
    }

    public void _extend(CompletionType type, IElementType element, Completions c) {
        extend(type, PlatformPatterns.psiElement(element),
                new CompletionProvider<>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        c.complete(parameters, context, resultSet);
                    }
                }
        );
    }

    private interface Completions {
        void complete(CompletionParameters parameters, ProcessingContext context, CompletionResultSet resultSet);
    }
}

