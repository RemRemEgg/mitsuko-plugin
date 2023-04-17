package mitsuko_plugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static mitsuko_plugin.psi.MitsukoTypes.*;
import static com.intellij.psi.TokenType.*;
import java.util.ArrayList;

%%

%class MitsukoLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

%{
    public boolean zzAtBOL = false;
    public boolean zzEOFDone;
    public int curl_depth = 0;
    public ArrayList<Character> nbt_stack = new ArrayList<>();
    public int nbt_return;
    public char nbt_string = 'x';
    public boolean is_item = false;
    
    public IElementType NBT_START(char start) {
        nbt_return = yystate();
        yybegin(NBT);
        nbt_stack.clear();
        nbt_stack.add(start);
        nbt_string = 'x';
        return NBT_BRACES;
    }
    
    public void NBT_OPEN(char open) {
        if (nbt_string == 'x') {nbt_stack.add(open);}
    }
    
    public void NBT_STRING(char open) {
        if (nbt_string == open) {
            nbt_string = 'x';
        } else if (nbt_string == 'x') {
            nbt_string = open;
        }
    }
    
    public IElementType NBT_POS(IElementType nbt) {
        if (nbt_string == 'x') {return nbt;} else {return NBT_STRING;}
    }
    
    public IElementType NBT_CLOSE(char open) {
        if (nbt_string == 'x') {
            int siz = nbt_stack.size();
            if (siz == 0) return BAD_CHARACTER;
            if (nbt_stack.get(siz-1) == open) {
                nbt_stack.remove(nbt_stack.size()-1);
                if (siz == 1) NBT_FORCE_END();
                return NBT_BRACES;
            } else {
                return BAD_CHARACTER;
            }
        } else {return NBT_STRING;}
    }
    
    public IElementType NBT_FORCE_END() {
        yybegin(nbt_return);
        nbt_stack.clear();
        nbt_string = 'x';
        return CRLF;
    }
    
    public void SELECTOR(int next) {
        if (yycharat(yylength()-1) == '[') {
            yypushback(1);
            NBT_START('[');
            nbt_return = next;
            yybegin(wSELECTOR);
        } else {
            yybegin(next);
        }
    }
    
    public IElementType fn_close_brace() {
        curl_depth--; 
        if (curl_depth == 0) yybegin(FUNCTION_FILE); 
        if (curl_depth == 1 && is_item) yybegin(ITEM_FILE);
        return curl_depth == 0 ? FN_CLOSE : BLOCK_CLOSE;
    }
    
    public void yydesselect() {
        yypushback(yylength());
    }
%}

CRLF = \R
WHITE_SPACE = [\ \t\b]
W = {WHITE_SPACE}*
Wr = {WHITE_SPACE}+
EQUALS = "="

FN_WORDS = [a-z0-9_.]
WORD = [A-Za-z_0-9/*-+§$.]+
WORD_SYM_NO_BRACKETS = [A-Za-z_0-9/*\-+§!@#$%\^&*(){}\\<>,.\"\'?~`]+
WORD_SYM_NO_NBTS = [A-Za-z_0-9/*\-+§!@#$%\^&*\\<>,.?~`]+
WORDS = {WORD} ({W}{WORD})*
WORDS_SYM_NO_BRACKETS = {WORD_SYM_NO_BRACKETS} ({W}{WORD_SYM_NO_BRACKETS})*

BOL_COMMENT = {W}"//"[^\r\n]*
FN_NAME = {FN_WORDS} ("/" | {FN_WORDS})*

COMMANDS = ("advancement"|"attribute"|"bossbar"|"clear"|"clone"|"data"|"datapack"|"debug"|"defaultgamemode"|"difficulty"|"effect"|"enchant"|"experience"|"fill"|"forceload"|"function"|"gamemode"|"gamerule"|"give"|"help"|"kick"|"kill"|"list"|"locate"|"loot"|"me"|"msg"|"particle"|"playsound"|"publish"|"recipe"|"reload"|"item"|"say"|"schedule"|"scoreboard"|"seed"|"setblock"|"setworldspawn"|"spawnpoint"|"spectate"|"spreadplayers"|"stopsound"|"summon"|"tag"|"team"|"teammsg"|"teleport"|"tell"|"tellraw"|"time"|"title"|"tm"|"tp"|"trigger"|"weather"|"worldborder"|"xp"|"jfr"|"place"|"fillbiome"|"ride"|"damage")
SUBS = ("set" | "give" | "get" | "remove" | "merge" | "modify" | "enable" | "reset" | "operation" | "entity" | "block" | "storage" | "replace" | "keep" | "outline" | "destroy" | "hollow" | "mount" | "dismount" | "grant" | "revoke" | "add" | "clear"|modify|multiply|add_base|color|style|visible|max|value)
EXECUTES = ("execute"|"exe"|"ast")
EXECUTE_SUBS = ("align" | "anchored" | "as" | "at" | "facing" | "in" | "on" | "positioned" | "rotated" | "summon" | "if" | "unless" | "store")
EXECUTE_SUBS_SUBS = ("biome" | "block" | "blocks" | "data" | "dimension" | "entity" | "loaded" | "predicate" | "score" | "bossbar" | "storage" | "result" | "success")
SHORTHANDS = ("rmm" | set)
SCORE_OPS = ("+=" | "-=" | "/=" | "*=" | "=" | "<" | ">" | "><" | "%=")
NUMBER = ((-?[0-9.]+) | ("~" -?[0-9.]*) | ("^" -?[0-9.]*))
BOOLEAN = ("true" | "false")
PIDENT = {BOOLEAN} | {NUMBER}
FUNCTION_CALL = (&|#)? {FN_NAME} "()"
SELECTOR = "@" ("a"|"s"|"e"|"r"|"p") "["?
SCORE_TEMP = "$"[#$%._A-Za-z0-9]+
SCORE_NON_SELECTOR = [#$%._A-Za-z0-9-]+
FLOW_CONTROL = ("if" | "while")
FLOW_CONTROL_SUBS = ("biome" | "block" | "blocks" | "data" | "dimension" | "entity" | "loaded" | "predicate" | "score" | "random")
FLOW_CONTROL_SUBS_SUBS = ("storage" | "all" | "masked" | "matches" | (">" | ">=" | "==" | "<=" | "<"))

%state PACK_FILE
%state wEQUALS
%state wVALUE

%state LINK_FILE
%state wCOLON
%state wFUNCTIONS

%state ITEM_FILE
%state wRECIPE
%state wMATERIALS

%state FUNCTION_FILE
%state wTAG_NAME
%state wTAG_EQUALS
%state wTAG_VALUE
%state wTAG_END

%state wFN_NAME
%state wFN_BEGIN
%state wSELECTOR
%state wEOC
%state wFLOW
%state wLOOP
%state wSCORE_NAME
%state wJSON_MODS
%state wJSON_TEXT
%state wFOR
%state wFOR_SCORE
%state wFOR_NUMS
%state FOR_SCOREBOARD

%state FN_INSIDE
%state COMMAND
%state EXECUTE
%state NBT
%state SCOREBOARD
%state SCOREBOARD_OP
%state SCOREBOARD_NO_OP
%state FLOW
%state FLOW_SCOREBOARD

%%
// TODO ######################################################################################################

^{BOL_COMMENT}                                               { if (yystate() == YYINITIAL) {yydesselect(); yybegin(FUNCTION_FILE); return HEADER_FN_FILE; } else {return MSK_COMMENT;} }
<YYINITIAL> (recipe|materials|item){Wr}"{"                   { yydesselect(); yybegin(ITEM_FILE); is_item = true; return HEADER_ITEM_FILE; }
<YYINITIAL> "fn "                                            { yydesselect(); yybegin(FUNCTION_FILE); return HEADER_FN_FILE; }
<YYINITIAL> "#["                                             { yydesselect(); yybegin(FUNCTION_FILE); return HEADER_FN_FILE; }
<YYINITIAL> {FN_NAME}/{Wr}:                                  { yydesselect(); yybegin(LINK_FILE); return HEADER_PACK_FILE; }
<YYINITIAL> {WORD_SYM_NO_NBTS}/{Wr}=                         { yydesselect(); yybegin(PACK_FILE); return HEADER_PACK_FILE; }
<YYINITIAL> (de|ve|na|re|co|op)[a-z]{W}*/[^:\{]              { yydesselect(); yybegin(PACK_FILE); return HEADER_PACK_FILE; }

<FUNCTION_FILE> {CRLF}                                       { return CRLF; }
<FUNCTION_FILE> {WHITE_SPACE}                                { return WHITE_SPACE; }

<FUNCTION_FILE> "#["{W}                                      { yybegin(wTAG_NAME); return TAG_DEF; }
<wTAG_NAME> {WORD}{W}                                        { yybegin(wTAG_EQUALS); return TAG_NAME;}
<wTAG_EQUALS> {EQUALS}{W}                                    { yybegin(wTAG_VALUE); return EQUALS;}
<wTAG_VALUE> {WORDS_SYM_NO_BRACKETS}{W}                      { yybegin(wTAG_END); return TAG_VALUE;}
<wTAG_END> ("]"{W})$                                         { yybegin(FUNCTION_FILE); return TAG_DEF;}
      
<FUNCTION_FILE> "fn"                                         { yybegin(wFN_NAME); return FN_KEYWORD;}
<wFN_NAME> {Wr}{FN_NAME}"()"{Wr}                             { yybegin(wFN_BEGIN); return FN_NAME;}
<wFN_BEGIN> "{"/{W}{CRLF}                                    { yybegin(FN_INSIDE); curl_depth++; return FN_OPEN;}
<wFN_BEGIN> "{"{W}/\}                                        { yybegin(FN_INSIDE); curl_depth++; return FN_OPEN;}

<FN_INSIDE> {
    {COMMANDS}                                               { yybegin(COMMAND); return COMMAND_START; }
    "cmd"                                                    { return COMMAND_START; }
    {SHORTHANDS}                                             { yybegin(COMMAND); return CODE_CUSTOM; }
    {EXECUTES}                                               { yybegin(EXECUTE); return COMMAND_START; }
    {CRLF}                                                   { return CRLF; }
    "{"                                                      { curl_depth++; return BLOCK_OPEN;}
    "}"                                                      { return fn_close_brace(); }
    {FUNCTION_CALL}                                          { return FN_CALL; }
    #?{SCORE_NON_SELECTOR}":"{FUNCTION_CALL}                 { return FN_CALL; }
    {SCORE_TEMP}                                             { yybegin(SCOREBOARD_OP); return SCOREBOARD_TEMP; }
    ({SCORE_NON_SELECTOR}|\*\{{WORD_SYM_NO_NBTS}\})/":"      { yybegin(SCOREBOARD); return SELECTOR; }
    {SELECTOR}                                               { SELECTOR(SCOREBOARD); return SELECTOR; }
    {FLOW_CONTROL}                                           { yybegin(wFLOW); return FLOW_CONTROL; }
    "loop"                                                   { yybegin(wLOOP); return CODE_CUSTOM; }
    (create|remove){Wr}                                      { yybegin(wSCORE_NAME); return CODE_CUSTOM; }
    for                                                      { yybegin(wFOR); return CODE_CUSTOM; }
    "*JSON{"                                                 { yybegin(wJSON_MODS); return SUB_CUSTOM; }
    \*\{{WORD_SYM_NO_NBTS}\}                                 { return VALUE; }
    {Wr}                                                     { return WHITE_SPACE; }
    [a-zA-Z0-9]+                                             { yybegin(COMMAND); return SUB_UNKNOWN; }
}

<COMMAND> {
    "{"                                                      { return NBT_START('{'); }
    "["                                                      { return NBT_START('['); }
    \"                                                       { NBT_START('"'); NBT_STRING('"'); return NBT_STRING; }
    {SELECTOR}                                               { SELECTOR(COMMAND); return SELECTOR; }
    {PIDENT}                                                 { return PIDENT; }
    {SUBS}                                                   { return SUB_1; }
    {WORD_SYM_NO_NBTS}                                       { return SUB_UNKNOWN; }
    {WHITE_SPACE}                                            { return WHITE_SPACE; }
    {CRLF}                                                   { yybegin(FN_INSIDE); return CRLF; }
    "*JSON{"                                                 { yybegin(wJSON_MODS); return SUB_CUSTOM; }
    \*\{{WORD_SYM_NO_NBTS}\}                                 { return VALUE; }
    [^{]                                                     { return SUB_UNKNOWN; }
}

<EXECUTE> {
    "{"                                                      { return NBT_START('{'); }
    "["                                                      { return NBT_START('['); }
    {SELECTOR}                                               { SELECTOR(EXECUTE); return SELECTOR; }
    {Wr}{EXECUTE_SUBS}                                       { return EXE_SUB; }
    {Wr}{EXECUTE_SUBS_SUBS}                                  { return SUB_2; }
    {PIDENT}                                                 { return PIDENT; }
    {Wr}"run"                                                { yybegin(FN_INSIDE); return EXE_SUB; }
    {WHITE_SPACE}                                            { return WHITE_SPACE; }
    {CRLF}                                                   { yybegin(FN_INSIDE); return CRLF; }
    [^]                                                      { return SUB_UNKNOWN; }
}

<NBT> {
    "{"                                                      { NBT_OPEN('{'); return NBT_POS(NBT_BRACES); }
    "["                                                      { NBT_OPEN('['); return NBT_POS(NBT_BRACES); }
    "("                                                      { NBT_OPEN('('); return NBT_POS(NBT_BRACES); }
    "}"                                                      { return NBT_CLOSE('{'); }
    "]"                                                      { return NBT_CLOSE('['); }
    ")"                                                      { return NBT_CLOSE('('); }
    "\""                                                     { NBT_STRING('"'); if (nbt_stack.get(0).equals('"')) { NBT_CLOSE('"'); } return NBT_STRING; }
    "\'"                                                     { NBT_STRING('\''); return NBT_STRING; }
    ":"                                                      { return NBT_POS(EQUALS); }
    "="                                                      { return NBT_POS(EQUALS); }
    {CRLF}                                                   { return NBT_FORCE_END(); }
    ","                                                      { return COMMA; }
    "*NEAR1"                                                 { return CODE_CUSTOM; }
    \*\{{WORD_SYM_NO_NBTS}\}                                 { return VALUE; }
    [^\"\'(){}\[\]:=, ]+/[A-Za-z_0-9.]*{W}[:=]               { return NBT_POS(NBT_PROPERTY); }
    [^\"\'(){}\[\]:=, ]+                                     { return NBT_POS(NBT_VALUE); }
}

<SCOREBOARD> {
    ":"                                                      { return EQUALS; }
    "r"?"&"?{FN_WORDS}+                                      { yybegin(SCOREBOARD_OP); return SCORE_NAME; }
    {Wr}                                                     { return WHITE_SPACE; }
    {CRLF}                                                   { yybegin(FN_INSIDE); return BAD_CHARACTER; }
}

<SCOREBOARD_NO_OP> {
    ":"                                                      { return EQUALS; }
    "r"?"&"?{FN_WORDS}+                                      { yybegin(wEOC); return SCORE_NAME; }
    {CRLF}                                                   { yybegin(wEOC); return BAD_CHARACTER; }
}

<SCOREBOARD_OP> {
    ("--" | "++" | "enable" | "reset" | "get")               { yybegin(wEOC); return SCORE_OPERATION; }
    "result"                                                 { yybegin(FN_INSIDE); return SCORE_OPERATION; }
    {SCORE_OPS}                                              { return SCORE_OPERATION; }
    "-"?[0-9]+                                               { yybegin(wEOC); return PIDENT; }
    {SELECTOR}                                               { SELECTOR(SCOREBOARD_NO_OP); return SELECTOR; }
    ({SCORE_NON_SELECTOR}|\*\{{WORD_SYM_NO_NBTS}\})/":"      { yybegin(SCOREBOARD_NO_OP); return SELECTOR; }
    {SCORE_TEMP}                                             { yybegin(wEOC); return SCOREBOARD_TEMP; }
    \*\{{WORD_SYM_NO_NBTS}\}                                 { return VALUE; }
    {CRLF}                                                   { yybegin(FN_INSIDE); return CRLF; }
}

<wSELECTOR> {
    "["                                                      { yybegin(NBT); return NBT_BRACES; }
}

<wEOC> {
    ^{WHITE_SPACE}                                           { yybegin(FN_INSIDE); return WHITE_SPACE; }
    {WHITE_SPACE}                                            { return WHITE_SPACE; }
    {CRLF}                                                   { yybegin(FN_INSIDE); return CRLF; }
}

<wFLOW> {
    "!"?"("                                                  { yybegin(FLOW); return PARENS; }
}

<FLOW> {
    {FLOW_CONTROL_SUBS}                                      { return SUB_1; }
    {FLOW_CONTROL_SUBS_SUBS}                                 { return SUB_2; }
    {SELECTOR}/":"                                           { SELECTOR(FLOW_SCOREBOARD); return SELECTOR; }
    ({SCORE_NON_SELECTOR}|\*\{{WORD_SYM_NO_NBTS}\})/":"      { yybegin(FLOW_SCOREBOARD); return SELECTOR; }
    {SCORE_TEMP}                                             { return SCOREBOARD_TEMP; }
    {SELECTOR}                                               { SELECTOR(FLOW_SCOREBOARD); return SELECTOR; }
    {PIDENT}                                                 { return PIDENT; }
    "&&"                                                     { return SCORE_OPERATION; }
    "{"                                                      { return NBT_START('{'); }
    ")"                                                      { yybegin(FN_INSIDE); return PARENS; }
    \*\{{WORD_SYM_NO_NBTS}\}                                 { return VALUE; }
    [^{)\ \t\b@$:]+                                          { return SUB_UNKNOWN; }
}

<FLOW_SCOREBOARD> {
    ":"                                                      { return EQUALS; }
    "r"?"&"?{FN_WORDS}+                                      { yybegin(FLOW); return SCORE_NAME; }
    {Wr}                                                     { yybegin(FLOW); return WHITE_SPACE; }
    ")"                                                      { yybegin(FN_INSIDE); return PARENS; }
}

<wLOOP> {
    {PIDENT}                                                 { yybegin(FN_INSIDE); return PIDENT; }
    {Wr}                                                     { return WHITE_SPACE; }
}

<wSCORE_NAME> {
    [A-Za-z_0-9!@#$%&*(){}:.\ ]+/{CRLF}                      { yybegin(FN_INSIDE); return SUB_CUSTOM; }
    {Wr}                                                     { return WHITE_SPACE; }
    {CRLF}                                                   { yybegin(FN_INSIDE); return CRLF; }
}

<wJSON_MODS> {
    [^\ :]                                                   { return SUB_1; }
    :                                                        { yybegin(wJSON_TEXT); return EQUALS; }
    {Wr}                                                     { return WHITE_SPACE; }
}

<wJSON_TEXT> {
    [^\ }]                                                   { return NBT_STRING; }
    \}                                                       { yybegin(COMMAND); return SUB_CUSTOM; }
    \*\{{WORD_SYM_NO_NBTS}\}                                 { return VALUE; }
    {Wr}                                                     { return WHITE_SPACE; }
}

<wFOR> {
    \(                                                       { yybegin(wFOR_SCORE); return PARENS; }
}

<wFOR_SCORE> {
    \*\{{WORD_SYM_NO_NBTS}\}                                 { yybegin(wFOR_NUMS); return VALUE; }
    {SCORE_TEMP}                                             { yybegin(wFOR_NUMS); return SCOREBOARD_TEMP; }
    ({SCORE_NON_SELECTOR}|\*\{{WORD_SYM_NO_NBTS}\})/":"      { yybegin(FOR_SCOREBOARD); return SELECTOR; }
    {SELECTOR}                                               { SELECTOR(FOR_SCOREBOARD); return SELECTOR; }
}

<FOR_SCOREBOARD> {
    ":"                                                      { return EQUALS; }
    "r"?"&"?{FN_WORDS}+                                      { yybegin(wFOR_NUMS); return SCORE_NAME; }
}

<wFOR_NUMS> {
    {PIDENT}                                                 { return PIDENT; }
    \*\{{WORD_SYM_NO_NBTS}\}                                 { yybegin(wFOR_NUMS); return VALUE; }
    \,                                                       { return COMMA; }
    \)                                                       { yybegin(FN_INSIDE); return PARENS; }
}

// TODO ######################################################################################################

<PACK_FILE> {CRLF}                                           { return CRLF; }
<PACK_FILE> {WORD_SYM_NO_NBTS}                               { yybegin(wEQUALS); return TAG_NAME; }
<wEQUALS> =                                                  { yybegin(wVALUE); return EQUALS; }
<wVALUE> [^\n\r]+                                            { yybegin(PACK_FILE); return TAG_VALUE; }

// TODO ######################################################################################################

<LINK_FILE> {CRLF}                                           { return CRLF; }
<LINK_FILE> {FN_NAME}                                        { yybegin(wCOLON); return TAG_NAME; }
<wCOLON> :                                                   { yybegin(wFUNCTIONS); return EQUALS; }
<wFUNCTIONS> [^\n\r]+                                        { yybegin(is_item ? nbt_return : LINK_FILE); return TAG_VALUE; }

// TODO ######################################################################################################

<ITEM_FILE> {
    recipe/{Wr}\{                                            { yybegin(wRECIPE); return ITEM_GROUP; }
    materials/{Wr}\{                                         { yybegin(wMATERIALS); return ITEM_GROUP; }
    path/{Wr}\:                                              { nbt_return = ITEM_FILE; yybegin(wCOLON); return ITEM_GROUP; }
    item/{Wr}\{                                              { curl_depth = 1; yybegin(FN_INSIDE); return ITEM_GROUP; }
    {CRLF}                                                   { return CRLF; }
}

<wRECIPE> {
    \{                                                       { return BLOCK_OPEN; }
    "\""~"\""                                                { return NBT_STRING; }
    \}                                                       { yybegin(ITEM_FILE); return BLOCK_CLOSE; }
    {CRLF}                                                   { return CRLF; }
}

<wMATERIALS> {
    \{                                                       { return BLOCK_OPEN; }
    [A-Za-z_0-9!@#$%\^&*]                                    { nbt_return = wMATERIALS; yybegin(wCOLON); return TAG_NAME; }
    \}                                                       { yybegin(ITEM_FILE); return BLOCK_CLOSE; }
    {CRLF}                                                   { return CRLF; }
}

{Wr}                                                         { return WHITE_SPACE; }
[^]                                                          { return BAD_CHARACTER; }