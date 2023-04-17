// This is a generated file. Not intended for manual editing.
package mitsuko_plugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import mitsuko_plugin.psi.impl.*;

public interface MitsukoTypes {

  IElementType CONDITION = new MitsukoElementType("CONDITION");
  IElementType E_SELECTOR = new MitsukoElementType("E_SELECTOR");
  IElementType FLOW = new MitsukoElementType("FLOW");
  IElementType FN_DEFINE = new MitsukoElementType("FN_DEFINE");
  IElementType FOR = new MitsukoElementType("FOR");
  IElementType FUNCTION = new MitsukoElementType("FUNCTION");
  IElementType FUNCTION_FILE = new MitsukoElementType("FUNCTION_FILE");
  IElementType ITEM_CONTENT = new MitsukoElementType("ITEM_CONTENT");
  IElementType ITEM_FILE = new MitsukoElementType("ITEM_FILE");
  IElementType LINES = new MitsukoElementType("LINES");
  IElementType MULTILINE = new MitsukoElementType("MULTILINE");
  IElementType NBT = new MitsukoElementType("NBT");
  IElementType NBT_INTERNAL = new MitsukoElementType("NBT_INTERNAL");
  IElementType ONELINE = new MitsukoElementType("ONELINE");
  IElementType PACK_FILE = new MitsukoElementType("PACK_FILE");
  IElementType PACK_TAG = new MitsukoElementType("PACK_TAG");
  IElementType SCOREBOARD = new MitsukoElementType("SCOREBOARD");
  IElementType SHORT_SCORE = new MitsukoElementType("SHORT_SCORE");
  IElementType TAG = new MitsukoElementType("TAG");

  IElementType BLOCK_CLOSE = new MitsukoTokenType("BLOCK_CLOSE");
  IElementType BLOCK_OPEN = new MitsukoTokenType("BLOCK_OPEN");
  IElementType CODE_CUSTOM = new MitsukoTokenType("CODE_CUSTOM");
  IElementType COMMA = new MitsukoTokenType("COMMA");
  IElementType COMMAND_START = new MitsukoTokenType("COMMAND_START");
  IElementType CRLF = new MitsukoTokenType("CRLF");
  IElementType EQUALS = new MitsukoTokenType("EQUALS");
  IElementType EXE_SUB = new MitsukoTokenType("EXE_SUB");
  IElementType FLOW_CONTROL = new MitsukoTokenType("FLOW_CONTROL");
  IElementType FN_CALL = new MitsukoTokenType("FN_CALL");
  IElementType FN_CLOSE = new MitsukoTokenType("FN_CLOSE");
  IElementType FN_KEYWORD = new MitsukoTokenType("FN_KEYWORD");
  IElementType FN_NAME = new MitsukoTokenType("FN_NAME");
  IElementType FN_OPEN = new MitsukoTokenType("FN_OPEN");
  IElementType HEADER_FN_FILE = new MitsukoTokenType("HEADER_FN_FILE");
  IElementType HEADER_ITEM_FILE = new MitsukoTokenType("HEADER_ITEM_FILE");
  IElementType HEADER_PACK_FILE = new MitsukoTokenType("HEADER_PACK_FILE");
  IElementType ITEM_GROUP = new MitsukoTokenType("ITEM_GROUP");
  IElementType MSK_COMMENT = new MitsukoTokenType("MSK_COMMENT");
  IElementType NBT_BRACES = new MitsukoTokenType("NBT_BRACES");
  IElementType NBT_PROPERTY = new MitsukoTokenType("NBT_PROPERTY");
  IElementType NBT_STRING = new MitsukoTokenType("NBT_STRING");
  IElementType NBT_VALUE = new MitsukoTokenType("NBT_VALUE");
  IElementType PARENS = new MitsukoTokenType("PARENS");
  IElementType PIDENT = new MitsukoTokenType("PIDENT");
  IElementType SCOREBOARD_TEMP = new MitsukoTokenType("SCOREBOARD_TEMP");
  IElementType SCORE_NAME = new MitsukoTokenType("SCORE_NAME");
  IElementType SCORE_OPERATION = new MitsukoTokenType("SCORE_OPERATION");
  IElementType SELECTOR = new MitsukoTokenType("SELECTOR");
  IElementType SUB_1 = new MitsukoTokenType("SUB_1");
  IElementType SUB_2 = new MitsukoTokenType("SUB_2");
  IElementType SUB_CUSTOM = new MitsukoTokenType("SUB_CUSTOM");
  IElementType SUB_UNKNOWN = new MitsukoTokenType("SUB_UNKNOWN");
  IElementType TAG_DEF = new MitsukoTokenType("TAG_DEF");
  IElementType TAG_NAME = new MitsukoTokenType("TAG_NAME");
  IElementType TAG_VALUE = new MitsukoTokenType("TAG_VALUE");
  IElementType VALUE = new MitsukoTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == CONDITION) {
        return new MitsukoConditionImpl(node);
      }
      else if (type == E_SELECTOR) {
        return new MitsukoESelectorImpl(node);
      }
      else if (type == FLOW) {
        return new MitsukoFlowImpl(node);
      }
      else if (type == FN_DEFINE) {
        return new MitsukoFnDefineImpl(node);
      }
      else if (type == FOR) {
        return new MitsukoForImpl(node);
      }
      else if (type == FUNCTION) {
        return new MitsukoFunctionImpl(node);
      }
      else if (type == FUNCTION_FILE) {
        return new MitsukoFunctionFileImpl(node);
      }
      else if (type == ITEM_CONTENT) {
        return new MitsukoItemContentImpl(node);
      }
      else if (type == ITEM_FILE) {
        return new MitsukoItemFileImpl(node);
      }
      else if (type == LINES) {
        return new MitsukoLinesImpl(node);
      }
      else if (type == MULTILINE) {
        return new MitsukoMultilineImpl(node);
      }
      else if (type == NBT) {
        return new MitsukoNbtImpl(node);
      }
      else if (type == NBT_INTERNAL) {
        return new MitsukoNbtInternalImpl(node);
      }
      else if (type == ONELINE) {
        return new MitsukoOnelineImpl(node);
      }
      else if (type == PACK_FILE) {
        return new MitsukoPackFileImpl(node);
      }
      else if (type == PACK_TAG) {
        return new MitsukoPackTagImpl(node);
      }
      else if (type == SCOREBOARD) {
        return new MitsukoScoreboardImpl(node);
      }
      else if (type == SHORT_SCORE) {
        return new MitsukoShortScoreImpl(node);
      }
      else if (type == TAG) {
        return new MitsukoTagImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
