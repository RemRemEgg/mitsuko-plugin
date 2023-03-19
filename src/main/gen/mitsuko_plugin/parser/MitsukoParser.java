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
  // BLOCK_OPEN (CODE | COMMENT | CRLF | WHITE1)* BLOCK_CLOSE
  public static boolean BLOCK(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BLOCK")) return false;
    if (!nextTokenIs(b, BLOCK_OPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BLOCK_OPEN);
    r = r && BLOCK_1(b, l + 1);
    r = r && consumeToken(b, BLOCK_CLOSE);
    exit_section_(b, m, BLOCK, r);
    return r;
  }

  // (CODE | COMMENT | CRLF | WHITE1)*
  private static boolean BLOCK_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BLOCK_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!BLOCK_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "BLOCK_1", c)) break;
    }
    return true;
  }

  // CODE | COMMENT | CRLF | WHITE1
  private static boolean BLOCK_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BLOCK_1_0")) return false;
    boolean r;
    r = CODE(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    if (!r) r = consumeToken(b, WHITE1);
    return r;
  }

  /* ********************************************************** */
  // BLOCK | ((FOR | CODE_CUSTOM | COMMAND_START | SHORT_SCORE | FLOW | FN_OPEN | VALUE) ((SCOREBOARD !(W SCORE_OPERATION)) | VALUE | EQUALS | (E_SELECTOR !EQUALS) | SUB_CUSTOM | PIDENT | EXE_SUB | SUB_1 | SUB_2 | SUB_UNKNOWN | WHITE1 | NBT)* CODE?) | FN_CALL
  public static boolean CODE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CODE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, CODE, "<code>");
    r = BLOCK(b, l + 1);
    if (!r) r = CODE_1(b, l + 1);
    if (!r) r = consumeToken(b, FN_CALL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (FOR | CODE_CUSTOM | COMMAND_START | SHORT_SCORE | FLOW | FN_OPEN | VALUE) ((SCOREBOARD !(W SCORE_OPERATION)) | VALUE | EQUALS | (E_SELECTOR !EQUALS) | SUB_CUSTOM | PIDENT | EXE_SUB | SUB_1 | SUB_2 | SUB_UNKNOWN | WHITE1 | NBT)* CODE?
  private static boolean CODE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CODE_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CODE_1_0(b, l + 1);
    r = r && CODE_1_1(b, l + 1);
    r = r && CODE_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FOR | CODE_CUSTOM | COMMAND_START | SHORT_SCORE | FLOW | FN_OPEN | VALUE
  private static boolean CODE_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CODE_1_0")) return false;
    boolean r;
    r = FOR(b, l + 1);
    if (!r) r = consumeToken(b, CODE_CUSTOM);
    if (!r) r = consumeToken(b, COMMAND_START);
    if (!r) r = SHORT_SCORE(b, l + 1);
    if (!r) r = FLOW(b, l + 1);
    if (!r) r = consumeToken(b, FN_OPEN);
    if (!r) r = consumeToken(b, VALUE);
    return r;
  }

  // ((SCOREBOARD !(W SCORE_OPERATION)) | VALUE | EQUALS | (E_SELECTOR !EQUALS) | SUB_CUSTOM | PIDENT | EXE_SUB | SUB_1 | SUB_2 | SUB_UNKNOWN | WHITE1 | NBT)*
  private static boolean CODE_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CODE_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!CODE_1_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "CODE_1_1", c)) break;
    }
    return true;
  }

  // (SCOREBOARD !(W SCORE_OPERATION)) | VALUE | EQUALS | (E_SELECTOR !EQUALS) | SUB_CUSTOM | PIDENT | EXE_SUB | SUB_1 | SUB_2 | SUB_UNKNOWN | WHITE1 | NBT
  private static boolean CODE_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CODE_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CODE_1_1_0_0(b, l + 1);
    if (!r) r = consumeToken(b, VALUE);
    if (!r) r = consumeToken(b, EQUALS);
    if (!r) r = CODE_1_1_0_3(b, l + 1);
    if (!r) r = consumeToken(b, SUB_CUSTOM);
    if (!r) r = consumeToken(b, PIDENT);
    if (!r) r = consumeToken(b, EXE_SUB);
    if (!r) r = consumeToken(b, SUB_1);
    if (!r) r = consumeToken(b, SUB_2);
    if (!r) r = consumeToken(b, SUB_UNKNOWN);
    if (!r) r = consumeToken(b, WHITE1);
    if (!r) r = NBT(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SCOREBOARD !(W SCORE_OPERATION)
  private static boolean CODE_1_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CODE_1_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SCOREBOARD(b, l + 1);
    r = r && CODE_1_1_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(W SCORE_OPERATION)
  private static boolean CODE_1_1_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CODE_1_1_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !CODE_1_1_0_0_1_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // W SCORE_OPERATION
  private static boolean CODE_1_1_0_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CODE_1_1_0_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = W(b, l + 1);
    r = r && consumeToken(b, SCORE_OPERATION);
    exit_section_(b, m, null, r);
    return r;
  }

  // E_SELECTOR !EQUALS
  private static boolean CODE_1_1_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CODE_1_1_0_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = E_SELECTOR(b, l + 1);
    r = r && CODE_1_1_0_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !EQUALS
  private static boolean CODE_1_1_0_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CODE_1_1_0_3_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, EQUALS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // CODE?
  private static boolean CODE_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CODE_1_2")) return false;
    CODE(b, l + 1);
    return true;
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
  // FLOW_CONTROL W PARENS (CONDITION W)+ PARENS
  public static boolean FLOW(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FLOW")) return false;
    if (!nextTokenIs(b, FLOW_CONTROL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FLOW_CONTROL);
    r = r && W(b, l + 1);
    r = r && consumeToken(b, PARENS);
    r = r && FLOW_3(b, l + 1);
    r = r && consumeToken(b, PARENS);
    exit_section_(b, m, FLOW, r);
    return r;
  }

  // (CONDITION W)+
  private static boolean FLOW_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FLOW_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FLOW_3_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!FLOW_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FLOW_3", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // CONDITION W
  private static boolean FLOW_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FLOW_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CONDITION(b, l + 1);
    r = r && W(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FN_OPEN (CODE | COMMENT | CRLF | WHITE1)* FN_CLOSE
  public static boolean FN_BODY(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FN_BODY")) return false;
    if (!nextTokenIs(b, FN_OPEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FN_OPEN);
    r = r && FN_BODY_1(b, l + 1);
    r = r && consumeToken(b, FN_CLOSE);
    exit_section_(b, m, FN_BODY, r);
    return r;
  }

  // (CODE | COMMENT | CRLF | WHITE1)*
  private static boolean FN_BODY_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FN_BODY_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!FN_BODY_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FN_BODY_1", c)) break;
    }
    return true;
  }

  // CODE | COMMENT | CRLF | WHITE1
  private static boolean FN_BODY_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FN_BODY_1_0")) return false;
    boolean r;
    r = CODE(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    if (!r) r = consumeToken(b, WHITE1);
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
  // CODE_CUSTOM W PARENS SCOREBOARD COMMA W (PIDENT | VALUE) (COMMA W (PIDENT | VALUE))? PARENS
  public static boolean FOR(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FOR")) return false;
    if (!nextTokenIs(b, CODE_CUSTOM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CODE_CUSTOM);
    r = r && W(b, l + 1);
    r = r && consumeToken(b, PARENS);
    r = r && SCOREBOARD(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && W(b, l + 1);
    r = r && FOR_6(b, l + 1);
    r = r && FOR_7(b, l + 1);
    r = r && consumeToken(b, PARENS);
    exit_section_(b, m, FOR, r);
    return r;
  }

  // PIDENT | VALUE
  private static boolean FOR_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FOR_6")) return false;
    boolean r;
    r = consumeToken(b, PIDENT);
    if (!r) r = consumeToken(b, VALUE);
    return r;
  }

  // (COMMA W (PIDENT | VALUE))?
  private static boolean FOR_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FOR_7")) return false;
    FOR_7_0(b, l + 1);
    return true;
  }

  // COMMA W (PIDENT | VALUE)
  private static boolean FOR_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FOR_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && W(b, l + 1);
    r = r && FOR_7_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // PIDENT | VALUE
  private static boolean FOR_7_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FOR_7_0_2")) return false;
    boolean r;
    r = consumeToken(b, PIDENT);
    if (!r) r = consumeToken(b, VALUE);
    return r;
  }

  /* ********************************************************** */
  // FN_DEFINE FN_BODY
  public static boolean FUNCTION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION")) return false;
    if (!nextTokenIs(b, FN_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FN_DEFINE(b, l + 1);
    r = r && FN_BODY(b, l + 1);
    exit_section_(b, m, FUNCTION, r);
    return r;
  }

  /* ********************************************************** */
  // HEADER_FN_FILE (TAG|COMMENT|CRLF|FUNCTION|WHITE1)+
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

  // (TAG|COMMENT|CRLF|FUNCTION|WHITE1)+
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

  // TAG|COMMENT|CRLF|FUNCTION|WHITE1
  private static boolean FUNCTION_FILE_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FUNCTION_FILE_1_0")) return false;
    boolean r;
    r = TAG(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    if (!r) r = FUNCTION(b, l + 1);
    if (!r) r = consumeToken(b, WHITE1);
    return r;
  }

  /* ********************************************************** */
  // NBT_STRING | (TAG_NAME W EQUALS W TAG_VALUE) | (CODE | COMMENT | CRLF | WHITE1)+
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

  // TAG_NAME W EQUALS W TAG_VALUE
  private static boolean ITEM_CONTENT_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ITEM_CONTENT_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TAG_NAME);
    r = r && W(b, l + 1);
    r = r && consumeToken(b, EQUALS);
    r = r && W(b, l + 1);
    r = r && consumeToken(b, TAG_VALUE);
    exit_section_(b, m, null, r);
    return r;
  }

  // (CODE | COMMENT | CRLF | WHITE1)+
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

  // CODE | COMMENT | CRLF | WHITE1
  private static boolean ITEM_CONTENT_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ITEM_CONTENT_2_0")) return false;
    boolean r;
    r = CODE(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    if (!r) r = consumeToken(b, WHITE1);
    return r;
  }

  /* ********************************************************** */
  // HEADER_ITEM_FILE ((ITEM_GROUP W BLOCK_OPEN W (ITEM_CONTENT W)+ BLOCK_CLOSE) | WHITE1 | (ITEM_GROUP W EQUALS W TAG_VALUE))+
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

  // ((ITEM_GROUP W BLOCK_OPEN W (ITEM_CONTENT W)+ BLOCK_CLOSE) | WHITE1 | (ITEM_GROUP W EQUALS W TAG_VALUE))+
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

  // (ITEM_GROUP W BLOCK_OPEN W (ITEM_CONTENT W)+ BLOCK_CLOSE) | WHITE1 | (ITEM_GROUP W EQUALS W TAG_VALUE)
  private static boolean ITEM_FILE_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ITEM_FILE_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ITEM_FILE_1_0_0(b, l + 1);
    if (!r) r = consumeToken(b, WHITE1);
    if (!r) r = ITEM_FILE_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ITEM_GROUP W BLOCK_OPEN W (ITEM_CONTENT W)+ BLOCK_CLOSE
  private static boolean ITEM_FILE_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ITEM_FILE_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ITEM_GROUP);
    r = r && W(b, l + 1);
    r = r && consumeToken(b, BLOCK_OPEN);
    r = r && W(b, l + 1);
    r = r && ITEM_FILE_1_0_0_4(b, l + 1);
    r = r && consumeToken(b, BLOCK_CLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ITEM_CONTENT W)+
  private static boolean ITEM_FILE_1_0_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ITEM_FILE_1_0_0_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ITEM_FILE_1_0_0_4_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!ITEM_FILE_1_0_0_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ITEM_FILE_1_0_0_4", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // ITEM_CONTENT W
  private static boolean ITEM_FILE_1_0_0_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ITEM_FILE_1_0_0_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ITEM_CONTENT(b, l + 1);
    r = r && W(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ITEM_GROUP W EQUALS W TAG_VALUE
  private static boolean ITEM_FILE_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ITEM_FILE_1_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ITEM_GROUP);
    r = r && W(b, l + 1);
    r = r && consumeToken(b, EQUALS);
    r = r && W(b, l + 1);
    r = r && consumeToken(b, TAG_VALUE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (NBT_BRACES W NBT_INTERNAL*) | (NBT_STRING+)
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

  // NBT_BRACES W NBT_INTERNAL*
  private static boolean NBT_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NBT_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NBT_BRACES);
    r = r && W(b, l + 1);
    r = r && NBT_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NBT_INTERNAL*
  private static boolean NBT_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NBT_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!NBT_INTERNAL(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "NBT_0_2", c)) break;
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
  // (NBT_PROPERTY | (EQUALS W NBT_INTERNAL) | COMMA | NBT_VALUE | NBT_STRING | CODE_CUSTOM | NBT_BRACES | VALUE) W
  public static boolean NBT_INTERNAL(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NBT_INTERNAL")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NBT_INTERNAL, "<nbt internal>");
    r = NBT_INTERNAL_0(b, l + 1);
    r = r && W(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NBT_PROPERTY | (EQUALS W NBT_INTERNAL) | COMMA | NBT_VALUE | NBT_STRING | CODE_CUSTOM | NBT_BRACES | VALUE
  private static boolean NBT_INTERNAL_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NBT_INTERNAL_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NBT_PROPERTY);
    if (!r) r = NBT_INTERNAL_0_1(b, l + 1);
    if (!r) r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, NBT_VALUE);
    if (!r) r = consumeToken(b, NBT_STRING);
    if (!r) r = consumeToken(b, CODE_CUSTOM);
    if (!r) r = consumeToken(b, NBT_BRACES);
    if (!r) r = consumeToken(b, VALUE);
    exit_section_(b, m, null, r);
    return r;
  }

  // EQUALS W NBT_INTERNAL
  private static boolean NBT_INTERNAL_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NBT_INTERNAL_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUALS);
    r = r && W(b, l + 1);
    r = r && NBT_INTERNAL(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // HEADER_PACK_FILE ((W TAG_NAME W EQUALS W TAG_VALUE W) | WHITE1)+
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

  // ((W TAG_NAME W EQUALS W TAG_VALUE W) | WHITE1)+
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

  // (W TAG_NAME W EQUALS W TAG_VALUE W) | WHITE1
  private static boolean PACK_FILE_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PACK_FILE_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PACK_FILE_1_0_0(b, l + 1);
    if (!r) r = consumeToken(b, WHITE1);
    exit_section_(b, m, null, r);
    return r;
  }

  // W TAG_NAME W EQUALS W TAG_VALUE W
  private static boolean PACK_FILE_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PACK_FILE_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = W(b, l + 1);
    r = r && consumeToken(b, TAG_NAME);
    r = r && W(b, l + 1);
    r = r && consumeToken(b, EQUALS);
    r = r && W(b, l + 1);
    r = r && consumeToken(b, TAG_VALUE);
    r = r && W(b, l + 1);
    exit_section_(b, m, null, r);
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
  // (SCOREBOARD W SCORE_OPERATION W ((SCOREBOARD !(W SCORE_OPERATION)) | PIDENT | CODE)?) | (SCOREBOARD W CRLF)
  public static boolean SHORT_SCORE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SHORT_SCORE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SHORT_SCORE, "<short score>");
    r = SHORT_SCORE_0(b, l + 1);
    if (!r) r = SHORT_SCORE_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SCOREBOARD W SCORE_OPERATION W ((SCOREBOARD !(W SCORE_OPERATION)) | PIDENT | CODE)?
  private static boolean SHORT_SCORE_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SHORT_SCORE_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SCOREBOARD(b, l + 1);
    r = r && W(b, l + 1);
    r = r && consumeToken(b, SCORE_OPERATION);
    r = r && W(b, l + 1);
    r = r && SHORT_SCORE_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ((SCOREBOARD !(W SCORE_OPERATION)) | PIDENT | CODE)?
  private static boolean SHORT_SCORE_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SHORT_SCORE_0_4")) return false;
    SHORT_SCORE_0_4_0(b, l + 1);
    return true;
  }

  // (SCOREBOARD !(W SCORE_OPERATION)) | PIDENT | CODE
  private static boolean SHORT_SCORE_0_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SHORT_SCORE_0_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SHORT_SCORE_0_4_0_0(b, l + 1);
    if (!r) r = consumeToken(b, PIDENT);
    if (!r) r = CODE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SCOREBOARD !(W SCORE_OPERATION)
  private static boolean SHORT_SCORE_0_4_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SHORT_SCORE_0_4_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SCOREBOARD(b, l + 1);
    r = r && SHORT_SCORE_0_4_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(W SCORE_OPERATION)
  private static boolean SHORT_SCORE_0_4_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SHORT_SCORE_0_4_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !SHORT_SCORE_0_4_0_0_1_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // W SCORE_OPERATION
  private static boolean SHORT_SCORE_0_4_0_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SHORT_SCORE_0_4_0_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = W(b, l + 1);
    r = r && consumeToken(b, SCORE_OPERATION);
    exit_section_(b, m, null, r);
    return r;
  }

  // SCOREBOARD W CRLF
  private static boolean SHORT_SCORE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SHORT_SCORE_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SCOREBOARD(b, l + 1);
    r = r && W(b, l + 1);
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
  // WHITE1*
  public static boolean W(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "W")) return false;
    Marker m = enter_section_(b, l, _NONE_, W, "<w>");
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE1)) break;
      if (!empty_element_parsed_guard_(b, "W", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // WHITE1* (FUNCTION_FILE | PACK_FILE | ITEM_FILE)
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = item__0(b, l + 1);
    r = r && item__1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WHITE1*
  private static boolean item__0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item__0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE1)) break;
      if (!empty_element_parsed_guard_(b, "item__0", c)) break;
    }
    return true;
  }

  // FUNCTION_FILE | PACK_FILE | ITEM_FILE
  private static boolean item__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item__1")) return false;
    boolean r;
    r = FUNCTION_FILE(b, l + 1);
    if (!r) r = PACK_FILE(b, l + 1);
    if (!r) r = ITEM_FILE(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // item_?
  static boolean mitsukoFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mitsukoFile")) return false;
    item_(b, l + 1);
    return true;
  }

}
