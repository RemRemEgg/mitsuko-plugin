// This is a generated file. Not intended for manual editing.
package mitsuko_plugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static mitsuko_plugin.psi.MitsukoTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class MitsukoParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return mitsukoFile(b, l + 1);
  }

  /* ********************************************************** */
  // BLOCK_OPEN LINES BLOCK_CLOSE
  public static boolean BLOCK(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BLOCK")) return false;
    if (!nextTokenIs(b, BLOCK_OPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BLOCK_OPEN);
    r = r && LINES(b, l + 1);
    r = r && consumeToken(b, BLOCK_CLOSE);
    exit_section_(b, m, BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // BLOCK |
  //         MULTILINE |
  //         FN_CALL |
  //         ONELINE
  public static boolean CODE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CODE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CODE, "<code>");
    r = BLOCK(b, l + 1);
    if (!r) r = MULTILINE(b, l + 1);
    if (!r) r = consumeToken(b, FN_CALL);
    if (!r) r = ONELINE(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (SUB_1 | SUB_2 | SUB_UNKNOWN | SCOREBOARD | (E_SELECTOR !EQUALS) | SCORE_OPERATION | PIDENT | NBT | VALUE)+
  public static boolean CONDITION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CONDITION")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITION, "<condition>");
    r = CONDITION_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!CONDITION_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "CONDITION", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SUB_1 | SUB_2 | SUB_UNKNOWN | SCOREBOARD | (E_SELECTOR !EQUALS) | SCORE_OPERATION | PIDENT | NBT | VALUE
  private static boolean CONDITION_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CONDITION_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SUB_1);
    if (!r) r = consumeToken(b, SUB_2);
    if (!r) r = consumeToken(b, SUB_UNKNOWN);
    if (!r) r = SCOREBOARD(b, l + 1);
    if (!r) r = CONDITION_0_4(b, l + 1);
    if (!r) r = consumeToken(b, SCORE_OPERATION);
    if (!r) r = consumeToken(b, PIDENT);
    if (!r) r = NBT(b, l + 1);
    if (!r) r = consumeToken(b, VALUE);
    exit_section_(b, m, null, r);
    return r;
  }

  // E_SELECTOR !EQUALS
  private static boolean CONDITION_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CONDITION_0_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = E_SELECTOR(b, l + 1);
    r = r && CONDITION_0_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !EQUALS
  private static boolean CONDITION_0_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CONDITION_0_4_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, EQUALS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SELECTOR NBT?
  public static boolean E_SELECTOR(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "E_SELECTOR")) return false;
    if (!nextTokenIs(b, SELECTOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SELECTOR);
    r = r && E_SELECTOR_1(b, l + 1);
    exit_section_(b, m, E_SELECTOR, r);
    return r;
  }

  // NBT?
  private static boolean E_SELECTOR_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "E_SELECTOR_1")) return false;
    NBT(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // FLOW_CONTROL PARENS (CONDITION)+ PARENS
  public static boolean FLOW(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FLOW")) return false;
    if (!nextTokenIs(b, FLOW_CONTROL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FLOW_CONTROL, PARENS);
    r = r && FLOW_2(b, l + 1);
    r = r && consumeToken(b, PARENS);
    exit_section_(b, m, FLOW, r);
    return r;
  }

  // (CONDITION)+
  private static boolean FLOW_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FLOW_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FLOW_2_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!FLOW_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FLOW_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // (CONDITION)
  private static boolean FLOW_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FLOW_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CONDITION(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FN_KEYWORD FN_NAME
  public static boolean FN_DEFINE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FN_DEFINE")) return false;
    if (!nextTokenIs(b, FN_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FN_KEYWORD, FN_NAME);
    exit_section_(b, m, FN_DEFINE, r);
    return r;
  }

  /* ********************************************************** */
  // CODE_CUSTOM PARENS SCOREBOARD COMMA (PIDENT | VALUE) (COMMA (PIDENT | VALUE))? PARENS
  public static boolean FOR(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FOR")) return false;
    if (!nextTokenIs(b, CODE_CUSTOM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CODE_CUSTOM, PARENS);
    r = r && SCOREBOARD(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && FOR_4(b, l + 1);
    r = r && FOR_5(b, l + 1);
    r = r && consumeToken(b, PARENS);
    exit_section_(b, m, FOR, r);
    return r;
  }

  // PIDENT | VALUE
  private static boolean FOR_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FOR_4")) return false;
    boolean r;
    r = consumeToken(b, PIDENT);
    if (!r) r = consumeToken(b, VALUE);
    return r;
  }

  // (COMMA (PIDENT | VALUE))?
  private static boolean FOR_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FOR_5")) return false;
    FOR_5_0(b, l + 1);
    return true;
  }

  // COMMA (PIDENT | VALUE)
  private static boolean FOR_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FOR_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && FOR_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // PIDENT | VALUE
  private static boolean FOR_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FOR_5_0_1")) return false;
    boolean r;
    r = consumeToken(b, PIDENT);
    if (!r) r = consumeToken(b, VALUE);
    return r;
  }

  /* ********************************************************** */
  // FN_DEFINE FN_OPEN LINES FN_CLOSE
  public static boolean FUNCTION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION")) return false;
    if (!nextTokenIs(b, FN_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FN_DEFINE(b, l + 1);
    r = r && consumeToken(b, FN_OPEN);
    r = r && LINES(b, l + 1);
    r = r && consumeToken(b, FN_CLOSE);
    exit_section_(b, m, FUNCTION, r);
    return r;
  }

  /* ********************************************************** */
  // HEADER_FN_FILE (TAG|COMMENT|CRLF|FUNCTION)+
  public static boolean FUNCTION_FILE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_FILE")) return false;
    if (!nextTokenIs(b, HEADER_FN_FILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HEADER_FN_FILE);
    r = r && FUNCTION_FILE_1(b, l + 1);
    exit_section_(b, m, FUNCTION_FILE, r);
    return r;
  }

  // (TAG|COMMENT|CRLF|FUNCTION)+
  private static boolean FUNCTION_FILE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_FILE_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FUNCTION_FILE_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!FUNCTION_FILE_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FUNCTION_FILE_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // TAG|COMMENT|CRLF|FUNCTION
  private static boolean FUNCTION_FILE_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_FILE_1_0")) return false;
    boolean r;
    r = TAG(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    if (!r) r = FUNCTION(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // NBT_STRING | (TAG_NAME EQUALS TAG_VALUE) | (CODE | COMMENT | CRLF)+
  public static boolean ITEM_CONTENT(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ITEM_CONTENT")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ITEM_CONTENT, "<item content>");
    r = consumeToken(b, NBT_STRING);
    if (!r) r = ITEM_CONTENT_1(b, l + 1);
    if (!r) r = ITEM_CONTENT_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // TAG_NAME EQUALS TAG_VALUE
  private static boolean ITEM_CONTENT_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ITEM_CONTENT_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, TAG_NAME, EQUALS, TAG_VALUE);
    exit_section_(b, m, null, r);
    return r;
  }

  // (CODE | COMMENT | CRLF)+
  private static boolean ITEM_CONTENT_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ITEM_CONTENT_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ITEM_CONTENT_2_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!ITEM_CONTENT_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ITEM_CONTENT_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // CODE | COMMENT | CRLF
  private static boolean ITEM_CONTENT_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ITEM_CONTENT_2_0")) return false;
    boolean r;
    r = CODE(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    return r;
  }

  /* ********************************************************** */
  // HEADER_ITEM_FILE ((ITEM_GROUP BLOCK_OPEN (ITEM_CONTENT)+ BLOCK_CLOSE) | (ITEM_GROUP EQUALS TAG_VALUE))+
  public static boolean ITEM_FILE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ITEM_FILE")) return false;
    if (!nextTokenIs(b, HEADER_ITEM_FILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HEADER_ITEM_FILE);
    r = r && ITEM_FILE_1(b, l + 1);
    exit_section_(b, m, ITEM_FILE, r);
    return r;
  }

  // ((ITEM_GROUP BLOCK_OPEN (ITEM_CONTENT)+ BLOCK_CLOSE) | (ITEM_GROUP EQUALS TAG_VALUE))+
  private static boolean ITEM_FILE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ITEM_FILE_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ITEM_FILE_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!ITEM_FILE_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ITEM_FILE_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // (ITEM_GROUP BLOCK_OPEN (ITEM_CONTENT)+ BLOCK_CLOSE) | (ITEM_GROUP EQUALS TAG_VALUE)
  private static boolean ITEM_FILE_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ITEM_FILE_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ITEM_FILE_1_0_0(b, l + 1);
    if (!r) r = ITEM_FILE_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ITEM_GROUP BLOCK_OPEN (ITEM_CONTENT)+ BLOCK_CLOSE
  private static boolean ITEM_FILE_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ITEM_FILE_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ITEM_GROUP, BLOCK_OPEN);
    r = r && ITEM_FILE_1_0_0_2(b, l + 1);
    r = r && consumeToken(b, BLOCK_CLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ITEM_CONTENT)+
  private static boolean ITEM_FILE_1_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ITEM_FILE_1_0_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ITEM_FILE_1_0_0_2_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!ITEM_FILE_1_0_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ITEM_FILE_1_0_0_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // (ITEM_CONTENT)
  private static boolean ITEM_FILE_1_0_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ITEM_FILE_1_0_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ITEM_CONTENT(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ITEM_GROUP EQUALS TAG_VALUE
  private static boolean ITEM_FILE_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ITEM_FILE_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ITEM_GROUP, EQUALS, TAG_VALUE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ((CODE+ CRLF) | COMMENT | CRLF)*
  public static boolean LINES(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LINES")) return false;
    Marker m = enter_section_(b, l, _NONE_, LINES, "<lines>");
    while (true) {
      int c = current_position_(b);
      if (!LINES_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "LINES", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // (CODE+ CRLF) | COMMENT | CRLF
  private static boolean LINES_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LINES_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = LINES_0_0(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    exit_section_(b, m, null, r);
    return r;
  }

  // CODE+ CRLF
  private static boolean LINES_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LINES_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = LINES_0_0_0(b, l + 1);
    r = r && consumeToken(b, CRLF);
    exit_section_(b, m, null, r);
    return r;
  }

  // CODE+
  private static boolean LINES_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LINES_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CODE(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!CODE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "LINES_0_0_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (FLOW | FOR | (CODE_CUSTOM PIDENT)) CODE?
  public static boolean MULTILINE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MULTILINE")) return false;
    if (!nextTokenIs(b, "<multiline>", CODE_CUSTOM, FLOW_CONTROL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULTILINE, "<multiline>");
    r = MULTILINE_0(b, l + 1);
    r = r && MULTILINE_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // FLOW | FOR | (CODE_CUSTOM PIDENT)
  private static boolean MULTILINE_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MULTILINE_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FLOW(b, l + 1);
    if (!r) r = FOR(b, l + 1);
    if (!r) r = MULTILINE_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // CODE_CUSTOM PIDENT
  private static boolean MULTILINE_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MULTILINE_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CODE_CUSTOM, PIDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  // CODE?
  private static boolean MULTILINE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MULTILINE_1")) return false;
    CODE(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (NBT_BRACES NBT_INTERNAL*) | (NBT_STRING+)
  public static boolean NBT(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NBT")) return false;
    if (!nextTokenIs(b, "<nbt>", NBT_BRACES, NBT_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NBT, "<nbt>");
    r = NBT_0(b, l + 1);
    if (!r) r = NBT_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NBT_BRACES NBT_INTERNAL*
  private static boolean NBT_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NBT_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NBT_BRACES);
    r = r && NBT_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NBT_INTERNAL*
  private static boolean NBT_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NBT_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!NBT_INTERNAL(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "NBT_0_1", c)) break;
    }
    return true;
  }

  // NBT_STRING+
  private static boolean NBT_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NBT_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NBT_STRING);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, NBT_STRING)) break;
      if (!empty_element_parsed_guard_(b, "NBT_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NBT_PROPERTY | (EQUALS NBT_INTERNAL) | COMMA | NBT_VALUE | NBT_STRING | CODE_CUSTOM | NBT_BRACES | VALUE
  public static boolean NBT_INTERNAL(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NBT_INTERNAL")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NBT_INTERNAL, "<nbt internal>");
    r = consumeToken(b, NBT_PROPERTY);
    if (!r) r = NBT_INTERNAL_1(b, l + 1);
    if (!r) r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, NBT_VALUE);
    if (!r) r = consumeToken(b, NBT_STRING);
    if (!r) r = consumeToken(b, CODE_CUSTOM);
    if (!r) r = consumeToken(b, NBT_BRACES);
    if (!r) r = consumeToken(b, VALUE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // EQUALS NBT_INTERNAL
  private static boolean NBT_INTERNAL_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NBT_INTERNAL_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUALS);
    r = r && NBT_INTERNAL(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (CODE_CUSTOM | COMMAND_START | SHORT_SCORE | VALUE) 
  //             ((SCOREBOARD !(SCORE_OPERATION)) | VALUE | EQUALS | (E_SELECTOR !EQUALS) | SUB_CUSTOM | PIDENT | EXE_SUB | SUB_1 | SUB_2 | SUB_UNKNOWN | NBT)* 
  //             (!CRLF CODE)?
  public static boolean ONELINE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ONELINE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ONELINE, "<oneline>");
    r = ONELINE_0(b, l + 1);
    r = r && ONELINE_1(b, l + 1);
    r = r && ONELINE_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // CODE_CUSTOM | COMMAND_START | SHORT_SCORE | VALUE
  private static boolean ONELINE_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ONELINE_0")) return false;
    boolean r;
    r = consumeToken(b, CODE_CUSTOM);
    if (!r) r = consumeToken(b, COMMAND_START);
    if (!r) r = SHORT_SCORE(b, l + 1);
    if (!r) r = consumeToken(b, VALUE);
    return r;
  }

  // ((SCOREBOARD !(SCORE_OPERATION)) | VALUE | EQUALS | (E_SELECTOR !EQUALS) | SUB_CUSTOM | PIDENT | EXE_SUB | SUB_1 | SUB_2 | SUB_UNKNOWN | NBT)*
  private static boolean ONELINE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ONELINE_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ONELINE_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ONELINE_1", c)) break;
    }
    return true;
  }

  // (SCOREBOARD !(SCORE_OPERATION)) | VALUE | EQUALS | (E_SELECTOR !EQUALS) | SUB_CUSTOM | PIDENT | EXE_SUB | SUB_1 | SUB_2 | SUB_UNKNOWN | NBT
  private static boolean ONELINE_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ONELINE_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ONELINE_1_0_0(b, l + 1);
    if (!r) r = consumeToken(b, VALUE);
    if (!r) r = consumeToken(b, EQUALS);
    if (!r) r = ONELINE_1_0_3(b, l + 1);
    if (!r) r = consumeToken(b, SUB_CUSTOM);
    if (!r) r = consumeToken(b, PIDENT);
    if (!r) r = consumeToken(b, EXE_SUB);
    if (!r) r = consumeToken(b, SUB_1);
    if (!r) r = consumeToken(b, SUB_2);
    if (!r) r = consumeToken(b, SUB_UNKNOWN);
    if (!r) r = NBT(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SCOREBOARD !(SCORE_OPERATION)
  private static boolean ONELINE_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ONELINE_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SCOREBOARD(b, l + 1);
    r = r && ONELINE_1_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(SCORE_OPERATION)
  private static boolean ONELINE_1_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ONELINE_1_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, SCORE_OPERATION);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // E_SELECTOR !EQUALS
  private static boolean ONELINE_1_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ONELINE_1_0_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = E_SELECTOR(b, l + 1);
    r = r && ONELINE_1_0_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !EQUALS
  private static boolean ONELINE_1_0_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ONELINE_1_0_3_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, EQUALS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (!CRLF CODE)?
  private static boolean ONELINE_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ONELINE_2")) return false;
    ONELINE_2_0(b, l + 1);
    return true;
  }

  // !CRLF CODE
  private static boolean ONELINE_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ONELINE_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ONELINE_2_0_0(b, l + 1);
    r = r && CODE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !CRLF
  private static boolean ONELINE_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ONELINE_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, CRLF);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // HEADER_PACK_FILE (PACK_TAG | CRLF)+
  public static boolean PACK_FILE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PACK_FILE")) return false;
    if (!nextTokenIs(b, HEADER_PACK_FILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HEADER_PACK_FILE);
    r = r && PACK_FILE_1(b, l + 1);
    exit_section_(b, m, PACK_FILE, r);
    return r;
  }

  // (PACK_TAG | CRLF)+
  private static boolean PACK_FILE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PACK_FILE_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PACK_FILE_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!PACK_FILE_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "PACK_FILE_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // PACK_TAG | CRLF
  private static boolean PACK_FILE_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PACK_FILE_1_0")) return false;
    boolean r;
    r = PACK_TAG(b, l + 1);
    if (!r) r = consumeToken(b, CRLF);
    return r;
  }

  /* ********************************************************** */
  // TAG_NAME EQUALS TAG_VALUE
  public static boolean PACK_TAG(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PACK_TAG")) return false;
    if (!nextTokenIs(b, TAG_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, TAG_NAME, EQUALS, TAG_VALUE);
    exit_section_(b, m, PACK_TAG, r);
    return r;
  }

  /* ********************************************************** */
  // (E_SELECTOR EQUALS SCORE_NAME) | (SCOREBOARD_TEMP) | VALUE
  public static boolean SCOREBOARD(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SCOREBOARD")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SCOREBOARD, "<scoreboard>");
    r = SCOREBOARD_0(b, l + 1);
    if (!r) r = consumeToken(b, SCOREBOARD_TEMP);
    if (!r) r = consumeToken(b, VALUE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // E_SELECTOR EQUALS SCORE_NAME
  private static boolean SCOREBOARD_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SCOREBOARD_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = E_SELECTOR(b, l + 1);
    r = r && consumeTokens(b, 0, EQUALS, SCORE_NAME);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (SCOREBOARD SCORE_OPERATION ((SCOREBOARD !(SCORE_OPERATION)) | PIDENT | CODE)?) | (SCOREBOARD CRLF)
  public static boolean SHORT_SCORE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SHORT_SCORE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SHORT_SCORE, "<short score>");
    r = SHORT_SCORE_0(b, l + 1);
    if (!r) r = SHORT_SCORE_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SCOREBOARD SCORE_OPERATION ((SCOREBOARD !(SCORE_OPERATION)) | PIDENT | CODE)?
  private static boolean SHORT_SCORE_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SHORT_SCORE_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SCOREBOARD(b, l + 1);
    r = r && consumeToken(b, SCORE_OPERATION);
    r = r && SHORT_SCORE_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ((SCOREBOARD !(SCORE_OPERATION)) | PIDENT | CODE)?
  private static boolean SHORT_SCORE_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SHORT_SCORE_0_2")) return false;
    SHORT_SCORE_0_2_0(b, l + 1);
    return true;
  }

  // (SCOREBOARD !(SCORE_OPERATION)) | PIDENT | CODE
  private static boolean SHORT_SCORE_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SHORT_SCORE_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SHORT_SCORE_0_2_0_0(b, l + 1);
    if (!r) r = consumeToken(b, PIDENT);
    if (!r) r = CODE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SCOREBOARD !(SCORE_OPERATION)
  private static boolean SHORT_SCORE_0_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SHORT_SCORE_0_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SCOREBOARD(b, l + 1);
    r = r && SHORT_SCORE_0_2_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(SCORE_OPERATION)
  private static boolean SHORT_SCORE_0_2_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SHORT_SCORE_0_2_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, SCORE_OPERATION);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SCOREBOARD CRLF
  private static boolean SHORT_SCORE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SHORT_SCORE_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SCOREBOARD(b, l + 1);
    r = r && consumeToken(b, CRLF);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TAG_DEF TAG_NAME EQUALS TAG_VALUE TAG_DEF
  public static boolean TAG(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TAG")) return false;
    if (!nextTokenIs(b, TAG_DEF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, TAG_DEF, TAG_NAME, EQUALS, TAG_VALUE, TAG_DEF);
    exit_section_(b, m, TAG, r);
    return r;
  }

  /* ********************************************************** */
  // (FUNCTION_FILE | PACK_FILE | ITEM_FILE)?
  static boolean mitsukoFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mitsukoFile")) return false;
    mitsukoFile_0(b, l + 1);
    return true;
  }

  // FUNCTION_FILE | PACK_FILE | ITEM_FILE
  private static boolean mitsukoFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mitsukoFile_0")) return false;
    boolean r;
    r = FUNCTION_FILE(b, l + 1);
    if (!r) r = PACK_FILE(b, l + 1);
    if (!r) r = ITEM_FILE(b, l + 1);
    return r;
  }

}
