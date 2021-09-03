/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package gdscript;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import gdscript.psi.GdTokenType;import gdscript.psi.GdTypes;
import java.util.Stack;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>Gd.flex</tt>
 */
class GdLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int AWAIT_NEW_LINE = 2;
  public static final int AWAIT_NEW_LINE_ONCE = 4;
  public static final int STRING = 6;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3, 3
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [8, 6, 7]
   * Total runtime size is 1040 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[ZZ_CMAP_Y[ZZ_CMAP_Z[ch>>13]|((ch>>7)&0x3f)]|(ch&0x7f)];
  }

  /* The ZZ_CMAP_Z table has 136 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\207\100");

  /* The ZZ_CMAP_Y table has 128 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\177\200");

  /* The ZZ_CMAP_A table has 256 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\5\1\17\2\0\1\4\22\0\1\5\1\35\1\16\1\21\1\24\1\31\1\32\1\20\1\74\1"+
    "\75\1\27\1\25\1\71\1\15\1\3\1\30\1\7\1\13\10\2\1\72\1\73\1\33\1\26\1\34\1"+
    "\0\1\22\1\62\4\23\1\65\2\23\1\60\4\23\1\64\1\23\1\57\2\23\1\55\1\61\1\63\5"+
    "\23\1\76\1\0\1\77\1\102\1\6\1\0\1\44\1\12\1\42\1\40\1\14\1\11\1\51\1\67\1"+
    "\54\1\23\1\56\1\43\1\45\1\37\1\46\1\53\1\23\1\50\1\41\1\36\1\52\1\47\1\66"+
    "\1\10\1\70\1\23\1\100\1\1\1\101\1\103\201\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\4\3\10\1\11\2\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\2\24\1\25"+
    "\22\10\1\26\1\27\1\30\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\1\37\1\40\1\41\1\42\1\1\1\43"+
    "\2\44\1\45\1\46\4\0\10\10\1\47\1\50\1\0"+
    "\2\13\1\51\1\24\1\52\1\53\1\54\11\10\1\55"+
    "\6\10\1\56\1\57\1\60\1\10\1\61\5\10\1\0"+
    "\1\4\1\0\2\4\2\10\1\62\10\10\1\25\6\10"+
    "\1\52\2\10\1\63\4\10\1\64\1\10\1\65\1\66"+
    "\1\67\2\10\1\4\2\10\1\70\1\71\2\10\1\72"+
    "\1\73\1\74\1\75\1\76\1\10\1\77\6\10\1\100"+
    "\1\10\1\101\4\10\1\102\1\103\1\104\5\10\1\105"+
    "\1\10\1\106\3\10\1\107\1\110\2\10\1\111\1\112"+
    "\2\10\1\113\1\114\1\10\1\115\1\10\1\116\2\10"+
    "\1\117\2\10\1\120\2\10\1\121\1\122";

  private static int [] zzUnpackAction() {
    int [] result = new int[218];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\104\0\210\0\314\0\u0110\0\u0154\0\u0198\0\u0110"+
    "\0\u0110\0\u01dc\0\u0220\0\u0264\0\u02a8\0\u02ec\0\u0330\0\u0374"+
    "\0\u03b8\0\u0110\0\u03fc\0\u0440\0\u0484\0\u04c8\0\u050c\0\u0550"+
    "\0\u0550\0\u0550\0\u0594\0\u05d8\0\u061c\0\u050c\0\u0660\0\u06a4"+
    "\0\u06e8\0\u072c\0\u0770\0\u07b4\0\u07f8\0\u083c\0\u0880\0\u08c4"+
    "\0\u0908\0\u094c\0\u0990\0\u09d4\0\u0a18\0\u0a5c\0\u0aa0\0\u0ae4"+
    "\0\u0110\0\u0110\0\u0110\0\u0110\0\u0110\0\u0110\0\u0110\0\u0110"+
    "\0\u0110\0\u0110\0\u0110\0\u0110\0\u0110\0\u0b28\0\u0110\0\u0b6c"+
    "\0\u0110\0\u0220\0\u0110\0\u0bb0\0\u0bf4\0\u0c38\0\u0c7c\0\u0cc0"+
    "\0\u0d04\0\u0d48\0\u0d8c\0\u0dd0\0\u0e14\0\u0e58\0\u0e9c\0\u0110"+
    "\0\u0110\0\u0ee0\0\u0f24\0\u0110\0\u0110\0\u0110\0\u0110\0\u0110"+
    "\0\u0110\0\u0f68\0\u0fac\0\u0ff0\0\u1034\0\u1078\0\u10bc\0\u1100"+
    "\0\u1144\0\u1188\0\u11cc\0\u1210\0\u1254\0\u1298\0\u12dc\0\u1320"+
    "\0\u1364\0\u0220\0\u13a8\0\u0220\0\u13ec\0\u0220\0\u1430\0\u1474"+
    "\0\u14b8\0\u14fc\0\u1540\0\u1584\0\u15c8\0\u160c\0\u0c38\0\u0c7c"+
    "\0\u1650\0\u1694\0\u0220\0\u16d8\0\u171c\0\u1760\0\u17a4\0\u17e8"+
    "\0\u182c\0\u1870\0\u18b4\0\u0220\0\u18f8\0\u193c\0\u1980\0\u19c4"+
    "\0\u1a08\0\u1a4c\0\u0220\0\u1a90\0\u1ad4\0\u0220\0\u1b18\0\u1b5c"+
    "\0\u1ba0\0\u1be4\0\u0220\0\u1c28\0\u0220\0\u0220\0\u0220\0\u1c6c"+
    "\0\u1cb0\0\u160c\0\u1cf4\0\u1d38\0\u0220\0\u0220\0\u1d7c\0\u1dc0"+
    "\0\u0220\0\u0220\0\u0220\0\u0220\0\u0220\0\u1e04\0\u0220\0\u1e48"+
    "\0\u1e8c\0\u1ed0\0\u1f14\0\u1f58\0\u1f9c\0\u0220\0\u1fe0\0\u0220"+
    "\0\u2024\0\u2068\0\u20ac\0\u20f0\0\u0220\0\u0220\0\u2134\0\u2178"+
    "\0\u21bc\0\u2200\0\u2244\0\u2288\0\u0220\0\u22cc\0\u0220\0\u2310"+
    "\0\u2354\0\u2398\0\u0220\0\u0220\0\u23dc\0\u2420\0\u0220\0\u0220"+
    "\0\u2464\0\u24a8\0\u0220\0\u0220\0\u24ec\0\u0220\0\u2530\0\u0220"+
    "\0\u2574\0\u25b8\0\u0220\0\u25fc\0\u2640\0\u0220\0\u2684\0\u26c8"+
    "\0\u0220\0\u0220";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[218];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
    "\1\13\1\15\1\16\1\7\1\17\1\20\1\21\1\11"+
    "\1\22\1\23\1\24\1\13\1\25\1\26\1\27\1\30"+
    "\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40"+
    "\1\13\1\41\1\42\1\13\1\43\1\44\1\45\1\46"+
    "\1\47\2\13\1\50\1\51\1\52\1\13\1\53\1\54"+
    "\1\55\2\13\1\56\1\13\1\57\1\13\1\60\1\61"+
    "\1\62\1\63\1\64\1\65\1\66\1\67\1\70\1\71"+
    "\1\72\1\73\1\5\1\6\1\7\1\10\1\74\1\12"+
    "\1\13\1\14\1\13\1\15\1\16\1\7\1\17\1\20"+
    "\1\21\1\74\1\22\1\23\1\24\1\13\1\25\1\26"+
    "\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36"+
    "\1\37\1\40\1\13\1\41\1\42\1\13\1\43\1\44"+
    "\1\45\1\46\1\47\2\13\1\50\1\51\1\52\1\13"+
    "\1\53\1\54\1\55\2\13\1\56\1\13\1\57\1\13"+
    "\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67"+
    "\1\70\1\71\1\72\1\73\1\5\1\6\1\7\1\10"+
    "\1\75\1\12\1\13\1\14\1\13\1\15\1\16\1\7"+
    "\1\17\1\20\1\21\1\75\1\22\1\23\1\24\1\13"+
    "\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\1\37\1\40\1\13\1\41\1\42\1\13"+
    "\1\43\1\44\1\45\1\46\1\47\2\13\1\50\1\51"+
    "\1\52\1\13\1\53\1\54\1\55\2\13\1\56\1\13"+
    "\1\57\1\13\1\60\1\61\1\62\1\63\1\64\1\65"+
    "\1\66\1\67\1\70\1\71\1\72\1\73\4\76\1\77"+
    "\11\76\1\100\1\77\1\101\63\76\105\0\1\102\1\13"+
    "\3\0\7\13\6\0\1\13\2\0\1\103\7\0\33\13"+
    "\15\0\1\7\1\104\2\0\2\7\3\0\1\7\1\105"+
    "\74\0\1\12\77\0\2\13\3\0\7\13\6\0\1\13"+
    "\12\0\33\13\15\0\1\7\1\104\2\0\2\7\1\106"+
    "\1\0\1\107\1\7\1\105\70\0\2\13\3\0\7\13"+
    "\6\0\1\13\12\0\5\13\1\110\1\111\1\13\1\112"+
    "\3\13\1\113\16\13\14\0\2\13\3\0\7\13\6\0"+
    "\1\13\12\0\10\13\1\114\1\13\1\115\20\13\14\0"+
    "\2\13\3\0\2\13\1\116\4\13\6\0\1\13\12\0"+
    "\5\13\1\117\25\13\30\0\1\120\10\0\1\103\5\0"+
    "\1\121\65\0\1\122\65\0\4\23\1\123\12\23\1\124"+
    "\64\23\10\0\3\24\1\0\1\24\6\0\1\24\12\0"+
    "\33\24\15\0\1\25\3\0\7\25\6\0\1\25\12\0"+
    "\33\25\40\0\1\125\1\103\103\0\1\126\103\0\1\103"+
    "\103\0\1\103\3\0\1\127\77\0\1\126\4\0\1\130"+
    "\76\0\1\126\5\0\1\131\50\0\2\13\3\0\7\13"+
    "\6\0\1\13\12\0\10\13\1\132\1\13\1\133\20\13"+
    "\14\0\2\13\3\0\7\13\6\0\1\13\12\0\10\13"+
    "\1\134\3\13\1\135\16\13\14\0\2\13\3\0\6\13"+
    "\1\136\6\0\1\13\12\0\16\13\1\137\14\13\14\0"+
    "\2\13\3\0\7\13\6\0\1\13\12\0\5\13\1\140"+
    "\2\13\1\141\22\13\14\0\2\13\3\0\7\13\6\0"+
    "\1\13\12\0\1\13\1\142\1\13\1\143\27\13\14\0"+
    "\2\13\3\0\7\13\6\0\1\13\12\0\6\13\1\144"+
    "\24\13\14\0\2\13\3\0\7\13\6\0\1\13\12\0"+
    "\12\13\1\102\20\13\14\0\2\13\3\0\7\13\6\0"+
    "\1\13\12\0\6\13\1\145\1\13\1\146\22\13\14\0"+
    "\2\13\3\0\6\13\1\147\6\0\1\13\12\0\33\13"+
    "\14\0\2\13\3\0\7\13\6\0\1\13\12\0\6\13"+
    "\1\150\3\13\1\151\20\13\14\0\2\13\3\0\3\13"+
    "\1\152\3\13\6\0\1\13\12\0\1\13\1\153\1\13"+
    "\1\154\27\13\14\0\2\13\3\0\7\13\6\0\1\13"+
    "\12\0\1\155\32\13\14\0\2\13\3\0\7\13\6\0"+
    "\1\13\12\0\22\13\1\156\10\13\14\0\2\13\3\0"+
    "\7\13\6\0\1\13\12\0\26\13\1\157\4\13\14\0"+
    "\2\13\3\0\7\13\6\0\1\13\12\0\24\13\1\160"+
    "\6\13\14\0\2\13\3\0\7\13\6\0\1\13\12\0"+
    "\24\13\1\161\6\13\14\0\2\13\3\0\7\13\6\0"+
    "\1\13\12\0\31\13\1\162\1\13\14\0\2\13\3\0"+
    "\7\13\6\0\1\13\12\0\16\13\1\163\14\13\13\0"+
    "\4\76\1\0\11\76\3\0\63\76\16\0\1\164\67\0"+
    "\1\165\3\0\2\165\3\0\1\165\105\0\1\166\70\0"+
    "\1\167\3\0\2\167\1\0\4\167\23\0\1\167\1\0"+
    "\1\167\1\0\1\167\45\0\2\170\3\0\1\170\71\0"+
    "\2\13\3\0\7\13\6\0\1\13\12\0\10\13\1\171"+
    "\22\13\14\0\2\13\3\0\7\13\6\0\1\13\12\0"+
    "\5\13\1\172\25\13\14\0\2\13\3\0\7\13\6\0"+
    "\1\13\12\0\12\13\1\173\20\13\14\0\2\13\3\0"+
    "\7\13\6\0\1\13\12\0\1\13\1\174\31\13\14\0"+
    "\2\13\3\0\7\13\6\0\1\13\12\0\10\13\1\175"+
    "\22\13\14\0\2\13\3\0\6\13\1\176\6\0\1\13"+
    "\12\0\33\13\14\0\2\13\3\0\7\13\6\0\1\13"+
    "\12\0\1\177\32\13\14\0\2\13\3\0\7\13\6\0"+
    "\1\13\12\0\3\13\1\200\12\13\1\201\14\13\31\0"+
    "\1\22\104\0\1\124\65\0\2\13\3\0\7\13\6\0"+
    "\1\13\12\0\10\13\1\202\22\13\14\0\2\13\3\0"+
    "\7\13\6\0\1\13\12\0\14\13\1\203\16\13\14\0"+
    "\2\13\3\0\7\13\6\0\1\13\12\0\1\204\32\13"+
    "\14\0\2\13\3\0\7\13\6\0\1\13\12\0\5\13"+
    "\1\205\25\13\14\0\2\13\3\0\7\13\6\0\1\13"+
    "\12\0\1\206\4\13\1\207\25\13\14\0\2\13\3\0"+
    "\7\13\6\0\1\13\12\0\13\13\1\210\17\13\14\0"+
    "\2\13\3\0\7\13\6\0\1\13\12\0\6\13\1\211"+
    "\24\13\14\0\2\13\3\0\7\13\6\0\1\13\12\0"+
    "\1\13\1\212\31\13\14\0\2\13\3\0\7\13\6\0"+
    "\1\13\12\0\2\13\1\213\30\13\14\0\2\13\3\0"+
    "\7\13\6\0\1\13\12\0\3\13\1\214\27\13\14\0"+
    "\2\13\3\0\7\13\6\0\1\13\12\0\1\215\32\13"+
    "\14\0\2\13\3\0\7\13\6\0\1\13\12\0\12\13"+
    "\1\216\20\13\14\0\2\13\3\0\7\13\6\0\1\13"+
    "\12\0\16\13\1\217\14\13\14\0\2\13\3\0\7\13"+
    "\6\0\1\13\12\0\1\220\32\13\14\0\2\13\3\0"+
    "\7\13\6\0\1\13\12\0\3\13\1\221\27\13\14\0"+
    "\2\13\3\0\6\13\1\222\6\0\1\13\12\0\33\13"+
    "\14\0\2\13\3\0\7\13\6\0\1\13\12\0\1\223"+
    "\32\13\14\0\2\13\3\0\7\13\6\0\1\13\12\0"+
    "\12\13\1\224\20\13\14\0\2\13\3\0\7\13\6\0"+
    "\1\13\12\0\27\13\1\225\3\13\14\0\2\13\3\0"+
    "\7\13\6\0\1\13\12\0\25\13\1\226\5\13\14\0"+
    "\2\13\3\0\7\13\6\0\1\13\12\0\26\13\1\227"+
    "\4\13\14\0\2\13\3\0\7\13\6\0\1\13\12\0"+
    "\16\13\1\230\14\13\14\0\2\13\3\0\6\13\1\231"+
    "\6\0\1\13\12\0\33\13\31\0\1\101\67\0\1\165"+
    "\3\0\2\165\3\0\1\165\1\105\71\0\1\232\4\0"+
    "\1\232\3\0\1\232\71\0\2\13\3\0\7\13\6\0"+
    "\1\13\12\0\6\13\1\233\24\13\14\0\2\13\3\0"+
    "\7\13\6\0\1\13\12\0\3\13\1\234\27\13\14\0"+
    "\2\13\3\0\7\13\6\0\1\13\12\0\4\13\1\235"+
    "\26\13\14\0\2\13\3\0\7\13\6\0\1\13\12\0"+
    "\5\13\1\236\25\13\14\0\2\13\3\0\7\13\6\0"+
    "\1\13\12\0\6\13\1\237\24\13\14\0\2\13\3\0"+
    "\6\13\1\240\6\0\1\13\12\0\33\13\14\0\2\13"+
    "\3\0\6\13\1\241\6\0\1\13\12\0\33\13\14\0"+
    "\2\13\3\0\3\13\1\242\3\13\6\0\1\13\12\0"+
    "\33\13\14\0\2\13\3\0\7\13\6\0\1\13\12\0"+
    "\5\13\1\243\25\13\14\0\2\13\3\0\6\13\1\244"+
    "\6\0\1\13\12\0\33\13\14\0\2\13\3\0\7\13"+
    "\6\0\1\13\12\0\5\13\1\245\25\13\14\0\2\13"+
    "\3\0\7\13\6\0\1\13\12\0\13\13\1\246\17\13"+
    "\14\0\2\13\3\0\3\13\1\247\3\13\6\0\1\13"+
    "\12\0\33\13\14\0\2\13\3\0\7\13\6\0\1\13"+
    "\12\0\1\13\1\250\31\13\14\0\2\13\3\0\7\13"+
    "\6\0\1\13\12\0\3\13\1\251\27\13\14\0\2\13"+
    "\3\0\7\13\6\0\1\13\12\0\1\252\2\13\1\253"+
    "\27\13\14\0\2\13\3\0\6\13\1\254\6\0\1\13"+
    "\12\0\33\13\14\0\2\13\3\0\7\13\6\0\1\13"+
    "\12\0\4\13\1\255\26\13\14\0\2\13\3\0\7\13"+
    "\6\0\1\13\12\0\2\13\1\256\30\13\14\0\2\13"+
    "\3\0\7\13\6\0\1\13\12\0\14\13\1\257\16\13"+
    "\14\0\2\13\3\0\7\13\6\0\1\13\12\0\3\13"+
    "\1\260\27\13\14\0\2\13\3\0\7\13\6\0\1\13"+
    "\12\0\5\13\1\261\25\13\14\0\2\13\3\0\7\13"+
    "\6\0\1\13\12\0\16\13\1\262\14\13\14\0\2\13"+
    "\3\0\7\13\6\0\1\13\12\0\5\13\1\263\25\13"+
    "\14\0\2\13\3\0\7\13\6\0\1\13\12\0\5\13"+
    "\1\264\25\13\14\0\2\13\3\0\7\13\6\0\1\13"+
    "\12\0\1\265\32\13\14\0\2\13\3\0\6\13\1\266"+
    "\6\0\1\13\12\0\33\13\14\0\2\13\3\0\7\13"+
    "\6\0\1\13\12\0\20\13\1\267\12\13\14\0\2\13"+
    "\3\0\7\13\6\0\1\13\12\0\1\13\1\270\31\13"+
    "\14\0\2\13\3\0\6\13\1\271\6\0\1\13\12\0"+
    "\33\13\14\0\2\13\3\0\7\13\6\0\1\13\12\0"+
    "\6\13\1\272\24\13\14\0\2\13\3\0\7\13\6\0"+
    "\1\13\12\0\3\13\1\273\27\13\14\0\2\13\3\0"+
    "\7\13\6\0\1\13\12\0\16\13\1\274\14\13\14\0"+
    "\2\13\3\0\7\13\6\0\1\13\12\0\1\275\32\13"+
    "\14\0\2\13\3\0\7\13\6\0\1\13\12\0\12\13"+
    "\1\276\20\13\14\0\2\13\3\0\7\13\6\0\1\13"+
    "\12\0\31\13\1\277\1\13\14\0\2\13\3\0\7\13"+
    "\6\0\1\13\12\0\12\13\1\300\20\13\14\0\2\13"+
    "\3\0\7\13\6\0\1\13\12\0\10\13\1\301\22\13"+
    "\14\0\2\13\3\0\7\13\6\0\1\13\12\0\1\13"+
    "\1\302\31\13\14\0\2\13\3\0\6\13\1\303\6\0"+
    "\1\13\12\0\33\13\14\0\2\13\3\0\7\13\6\0"+
    "\1\13\12\0\2\13\1\304\30\13\14\0\2\13\3\0"+
    "\7\13\6\0\1\13\12\0\15\13\1\305\15\13\14\0"+
    "\2\13\3\0\7\13\6\0\1\13\12\0\2\13\1\306"+
    "\30\13\14\0\2\13\3\0\7\13\6\0\1\13\12\0"+
    "\1\307\32\13\14\0\2\13\3\0\7\13\6\0\1\13"+
    "\12\0\5\13\1\310\25\13\14\0\2\13\3\0\1\311"+
    "\6\13\6\0\1\13\12\0\33\13\14\0\2\13\3\0"+
    "\7\13\6\0\1\13\12\0\1\13\1\312\31\13\14\0"+
    "\2\13\3\0\7\13\6\0\1\13\12\0\1\313\32\13"+
    "\14\0\2\13\3\0\7\13\6\0\1\13\12\0\1\13"+
    "\1\314\31\13\14\0\2\13\3\0\7\13\6\0\1\13"+
    "\12\0\6\13\1\315\24\13\14\0\2\13\3\0\7\13"+
    "\6\0\1\13\12\0\13\13\1\316\17\13\14\0\2\13"+
    "\3\0\7\13\6\0\1\13\12\0\10\13\1\317\22\13"+
    "\14\0\2\13\3\0\7\13\6\0\1\13\12\0\3\13"+
    "\1\320\27\13\14\0\2\13\3\0\7\13\6\0\1\13"+
    "\12\0\1\13\1\321\31\13\14\0\2\13\3\0\7\13"+
    "\6\0\1\13\12\0\14\13\1\322\16\13\14\0\2\13"+
    "\3\0\7\13\6\0\1\13\12\0\2\13\1\323\30\13"+
    "\14\0\2\13\3\0\7\13\6\0\1\13\12\0\16\13"+
    "\1\324\14\13\14\0\2\13\3\0\7\13\6\0\1\13"+
    "\12\0\6\13\1\325\24\13\14\0\2\13\3\0\6\13"+
    "\1\326\6\0\1\13\12\0\33\13\14\0\2\13\3\0"+
    "\7\13\6\0\1\13\12\0\1\13\1\327\31\13\14\0"+
    "\2\13\3\0\7\13\6\0\1\13\12\0\7\13\1\330"+
    "\23\13\14\0\2\13\3\0\7\13\6\0\1\13\12\0"+
    "\1\331\32\13\14\0\2\13\3\0\6\13\1\332\6\0"+
    "\1\13\12\0\33\13\13\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[9996];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\3\0\1\1\1\11\2\1\2\11\10\1\1\11\36\1"+
    "\15\11\1\1\1\11\1\1\1\11\1\1\1\11\4\0"+
    "\10\1\2\11\1\0\1\1\6\11\32\1\1\0\1\1"+
    "\1\0\144\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[218];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    String oppening = "";
    int lastState = YYINITIAL;
    boolean lineEnded = false;
    int indent = 0;
    Stack<Integer> indentSizes = new Stack<>();
    int yycolumn;

    public IElementType dedentRoot(IElementType type) {
        lineEnded = false;
        if (yycolumn > 0 || indent <= 0 || indentSizes.empty()) {
            return type;
        }

        dedent();
        yypushback(yylength());

        return GdTypes.DEDENT;
    }

    public boolean dedentSpaces() {
        if (indent <= 0 || indentSizes.empty()) { // For EOF rule
            return false;
        }

        dedent();

        if (indent > yylength()) {
            yypushback(yylength());
        }

        return true;
    }

    private void dedent() {
        indent = Math.max(0, indent - indentSizes.pop());
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  GdLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzMarkedPosL*/);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        zzDoEOF();
              {
                if (yystate() == AWAIT_NEW_LINE && !lineEnded) {
        yybegin(YYINITIAL);
        return GdTypes.NEW_LINE;
    } else if (dedentSpaces()) {
        return GdTypes.DEDENT;
    } else {
        return null;
    }
              }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { continue;
            } 
            // fall through
          case 83: break;
          case 2: 
            { return GdTypes.BAD_CHARACTER;
            } 
            // fall through
          case 84: break;
          case 3: 
            { return GdTypes.OR;
            } 
            // fall through
          case 85: break;
          case 4: 
            { return dedentRoot(GdTypes.NUMBER);
            } 
            // fall through
          case 86: break;
          case 5: 
            { return GdTypes.DOT;
            } 
            // fall through
          case 87: break;
          case 6: 
            { return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 88: break;
          case 7: 
            { if (yycolumn == 0) {
            int spaces = yytext().length();
            if (spaces > indent) {
                indentSizes.push(spaces - indent);
                indent = spaces;
                return GdTypes.INDENT;
            } else if (indent > spaces) {
                dedentSpaces();
                return GdTypes.DEDENT;
            }
        }

        return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 89: break;
          case 8: 
            { return dedentRoot(GdTypes.IDENTIFIER);
            } 
            // fall through
          case 90: break;
          case 9: 
            { return GdTypes.MINUS;
            } 
            // fall through
          case 91: break;
          case 10: 
            { oppening = yytext().toString(); lastState = yystate(); yybegin(STRING);
            } 
            // fall through
          case 92: break;
          case 11: 
            { return GdTypes.COMMENT;
            } 
            // fall through
          case 93: break;
          case 12: 
            { return GdTypes.ANNOTATOR;
            } 
            // fall through
          case 94: break;
          case 13: 
            { return dedentRoot(GdTypes.NODE_PATH_LEX);
            } 
            // fall through
          case 95: break;
          case 14: 
            { return GdTypes.PLUS;
            } 
            // fall through
          case 96: break;
          case 15: 
            { return GdTypes.EQ;
            } 
            // fall through
          case 97: break;
          case 16: 
            { return GdTypes.MUL;
            } 
            // fall through
          case 98: break;
          case 17: 
            { return GdTypes.DIV;
            } 
            // fall through
          case 99: break;
          case 18: 
            { return GdTypes.MOD;
            } 
            // fall through
          case 100: break;
          case 19: 
            { return GdTypes.AND;
            } 
            // fall through
          case 101: break;
          case 20: 
            { return GdTypes.TEST_OPERATOR;
            } 
            // fall through
          case 102: break;
          case 21: 
            { return GdTypes.NEGATE;
            } 
            // fall through
          case 103: break;
          case 22: 
            { return GdTypes.COMMA;
            } 
            // fall through
          case 104: break;
          case 23: 
            { return GdTypes.COLON;
            } 
            // fall through
          case 105: break;
          case 24: 
            { lineEnded = true; return GdTypes.SEMICON;
            } 
            // fall through
          case 106: break;
          case 25: 
            { return dedentRoot(GdTypes.LRBR);
            } 
            // fall through
          case 107: break;
          case 26: 
            { return dedentRoot(GdTypes.RRBR);
            } 
            // fall through
          case 108: break;
          case 27: 
            { return dedentRoot(GdTypes.LSBR);
            } 
            // fall through
          case 109: break;
          case 28: 
            { return dedentRoot(GdTypes.RSBR);
            } 
            // fall through
          case 110: break;
          case 29: 
            { return dedentRoot(GdTypes.LCBR);
            } 
            // fall through
          case 111: break;
          case 30: 
            { return dedentRoot(GdTypes.RCBR);
            } 
            // fall through
          case 112: break;
          case 31: 
            { return GdTypes.XOR;
            } 
            // fall through
          case 113: break;
          case 32: 
            { return GdTypes.NOT;
            } 
            // fall through
          case 114: break;
          case 33: 
            { if (!lineEnded) {
              lineEnded = true;
              yypushback(yylength());
              return GdTypes.NEW_LINE;
          }

          return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 115: break;
          case 34: 
            { yybegin(YYINITIAL);
          if (lineEnded) { // For signal, etc.
              return TokenType.WHITE_SPACE;
          }
          yypushback(yylength());

          return GdTypes.NEW_LINE;
            } 
            // fall through
          case 116: break;
          case 35: 
            { if (!oppening.equals("\"\"\"")) {
            yybegin(lastState);
            return TokenType.BAD_CHARACTER;
        }
            } 
            // fall through
          case 117: break;
          case 36: 
            { if (oppening.equals(yytext().toString())) {
            yybegin(lastState);
            return GdTypes.STRING;
        }
            } 
            // fall through
          case 118: break;
          case 37: 
            { return GdTypes.OROR;
            } 
            // fall through
          case 119: break;
          case 38: 
            { return GdTypes.ASSIGN;
            } 
            // fall through
          case 120: break;
          case 39: 
            { return dedentRoot(GdTypes.MMINUS);
            } 
            // fall through
          case 121: break;
          case 40: 
            { return GdTypes.RET;
            } 
            // fall through
          case 122: break;
          case 41: 
            { return dedentRoot(GdTypes.PPLUS);
            } 
            // fall through
          case 123: break;
          case 42: 
            { return GdTypes.ANDAND;
            } 
            // fall through
          case 124: break;
          case 43: 
            { return GdTypes.LBSHIFT;
            } 
            // fall through
          case 125: break;
          case 44: 
            { return GdTypes.RBSHIFT;
            } 
            // fall through
          case 126: break;
          case 45: 
            { return dedentRoot(GdTypes.AS);
            } 
            // fall through
          case 127: break;
          case 46: 
            { return dedentRoot(GdTypes.IF);
            } 
            // fall through
          case 128: break;
          case 47: 
            { return dedentRoot(GdTypes.IN);
            } 
            // fall through
          case 129: break;
          case 48: 
            { return dedentRoot(GdTypes.IS);
            } 
            // fall through
          case 130: break;
          case 49: 
            { return dedentRoot(GdTypes.PI);
            } 
            // fall through
          case 131: break;
          case 50: 
            { return dedentRoot(GdTypes.FOR);
            } 
            // fall through
          case 132: break;
          case 51: 
            { yybegin(AWAIT_NEW_LINE_ONCE); return dedentRoot(GdTypes.VAR);
            } 
            // fall through
          case 133: break;
          case 52: 
            { return dedentRoot(GdTypes.INT);
            } 
            // fall through
          case 134: break;
          case 53: 
            { return dedentRoot(GdTypes.INF);
            } 
            // fall through
          case 135: break;
          case 54: 
            { return dedentRoot(GdTypes.TAU);
            } 
            // fall through
          case 136: break;
          case 55: 
            { return dedentRoot(GdTypes.NAN);
            } 
            // fall through
          case 137: break;
          case 56: 
            { yybegin(AWAIT_NEW_LINE); return dedentRoot(GdTypes.FUNC);
            } 
            // fall through
          case 138: break;
          case 57: 
            { return dedentRoot(GdTypes.BOOL);
            } 
            // fall through
          case 139: break;
          case 58: 
            { return dedentRoot(GdTypes.ELSE);
            } 
            // fall through
          case 140: break;
          case 59: 
            { return dedentRoot(GdTypes.ELIF);
            } 
            // fall through
          case 141: break;
          case 60: 
            { yybegin(AWAIT_NEW_LINE_ONCE); return dedentRoot(GdTypes.TOOL);
            } 
            // fall through
          case 142: break;
          case 61: 
            { return dedentRoot(GdTypes.TRUE);
            } 
            // fall through
          case 143: break;
          case 62: 
            { return dedentRoot(GdTypes.NULL);
            } 
            // fall through
          case 144: break;
          case 63: 
            { return dedentRoot(GdTypes.SELF);
            } 
            // fall through
          case 145: break;
          case 64: 
            { return dedentRoot(GdTypes.VOID);
            } 
            // fall through
          case 146: break;
          case 65: 
            { yybegin(AWAIT_NEW_LINE); return dedentRoot(GdTypes.PASS);
            } 
            // fall through
          case 147: break;
          case 66: 
            { return dedentRoot(GdTypes.FLOAT);
            } 
            // fall through
          case 148: break;
          case 67: 
            { return dedentRoot(GdTypes.FALSE);
            } 
            // fall through
          case 149: break;
          case 68: 
            { yybegin(AWAIT_NEW_LINE); return dedentRoot(GdTypes.BREAK);
            } 
            // fall through
          case 150: break;
          case 69: 
            { yybegin(AWAIT_NEW_LINE_ONCE); return dedentRoot(GdTypes.CONST);
            } 
            // fall through
          case 151: break;
          case 70: 
            { return dedentRoot(GdTypes.MATCH);
            } 
            // fall through
          case 152: break;
          case 71: 
            { return dedentRoot(GdTypes.WHILE);
            } 
            // fall through
          case 153: break;
          case 72: 
            { return dedentRoot(GdTypes.YIELD);
            } 
            // fall through
          case 154: break;
          case 73: 
            { return GdTypes.SETGET;
            } 
            // fall through
          case 155: break;
          case 74: 
            { yybegin(AWAIT_NEW_LINE_ONCE); return GdTypes.SIGNAL;
            } 
            // fall through
          case 156: break;
          case 75: 
            { return dedentRoot(GdTypes.ASSERT);
            } 
            // fall through
          case 157: break;
          case 76: 
            { yybegin(AWAIT_NEW_LINE); return dedentRoot(GdTypes.RETURN);
            } 
            // fall through
          case 158: break;
          case 77: 
            { return dedentRoot(GdTypes.STR);
            } 
            // fall through
          case 159: break;
          case 78: 
            { yybegin(AWAIT_NEW_LINE_ONCE); return dedentRoot(GdTypes.EXTENDS);
            } 
            // fall through
          case 160: break;
          case 79: 
            { return dedentRoot(GdTypes.PRELOAD);
            } 
            // fall through
          case 161: break;
          case 80: 
            { yybegin(AWAIT_NEW_LINE); return dedentRoot(GdTypes.CONTINUE);
            } 
            // fall through
          case 162: break;
          case 81: 
            { yybegin(AWAIT_NEW_LINE); return dedentRoot(GdTypes.BREAKPOINT);
            } 
            // fall through
          case 163: break;
          case 82: 
            { yybegin(AWAIT_NEW_LINE_ONCE); return dedentRoot(GdTypes.CLASS_NAME);
            } 
            // fall through
          case 164: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
