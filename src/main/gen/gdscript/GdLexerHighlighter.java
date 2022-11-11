/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package gdscript;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import gdscript.psi.GdTokenType;
import gdscript.psi.GdTypes;
import java.util.Stack;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>GdHighlight.flex</tt>
 */
class GdLexerHighlighter implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int STRING = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [9, 6, 6]
   * Total runtime size is 1568 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[ZZ_CMAP_Z[ch>>12]|((ch>>6)&0x3f)]<<6)|(ch&0x3f)];
  }

  /* The ZZ_CMAP_Z table has 272 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\100\1\200\u010d\100");

  /* The ZZ_CMAP_Y table has 192 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\2\175\3\1\4\77\3");

  /* The ZZ_CMAP_A table has 320 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\5\1\20\2\21\1\4\22\0\1\5\1\37\1\16\1\23\1\26\1\30\1\34\1\22\1\66\1"+
    "\67\1\33\1\31\1\63\1\15\1\3\1\27\1\7\1\13\10\2\1\64\1\65\1\35\1\32\1\36\1"+
    "\0\1\24\6\11\24\25\1\70\1\17\1\71\1\74\1\6\1\0\1\46\1\12\1\44\1\42\1\14\1"+
    "\55\1\53\1\62\1\57\1\25\1\60\1\45\1\47\1\41\1\52\1\56\1\25\1\51\1\43\1\40"+
    "\1\54\1\50\1\61\1\10\2\25\1\72\1\1\1\73\1\75\6\0\1\21\242\0\2\21\26\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\2\6\1\7"+
    "\1\4\3\10\1\11\2\2\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\2\23\1\24\16\10"+
    "\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\1\37\1\1\1\40\2\41\1\42\1\43"+
    "\2\0\1\44\2\0\4\10\1\45\1\46\1\0\1\47"+
    "\3\0\1\47\2\12\1\14\1\0\1\14\1\50\1\23"+
    "\1\51\1\52\1\53\13\10\1\54\12\10\1\55\1\56"+
    "\1\57\1\10\1\60\1\0\1\4\1\0\2\4\5\10"+
    "\1\0\1\14\1\10\1\61\1\24\1\10\1\62\6\10"+
    "\1\51\2\10\1\63\2\10\1\64\1\10\1\65\2\10"+
    "\1\66\1\10\1\4\2\10\1\67\1\70\1\71\2\0"+
    "\1\72\1\73\1\74\11\10\1\75\2\10\1\76\1\77"+
    "\1\10\1\100\1\10\1\0\1\10\1\101\1\10\1\102"+
    "\1\10\1\103\1\104\1\105\2\10\1\106\1\107\2\10"+
    "\1\110\1\111\2\10\1\112\1\113\1\10\1\114\4\10"+
    "\1\115\2\10\1\116\1\117";

  private static int [] zzUnpackAction() {
    int [] result = new int[209];
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
    "\0\0\0\76\0\174\0\272\0\370\0\u0136\0\174\0\u0174"+
    "\0\u01b2\0\u01f0\0\u01b2\0\u022e\0\u026c\0\u02aa\0\u02e8\0\u0326"+
    "\0\u0364\0\u03a2\0\u03e0\0\u041e\0\u045c\0\u049a\0\u04d8\0\u041e"+
    "\0\u0516\0\u0554\0\u0592\0\u04d8\0\u05d0\0\u060e\0\u064c\0\u068a"+
    "\0\u06c8\0\u0706\0\u0744\0\u0782\0\u07c0\0\u07fe\0\u083c\0\u087a"+
    "\0\u08b8\0\u08f6\0\174\0\u0934\0\174\0\174\0\174\0\174"+
    "\0\174\0\174\0\174\0\174\0\174\0\u0972\0\174\0\u09b0"+
    "\0\174\0\u01b2\0\174\0\u09ee\0\u0a2c\0\174\0\u0a6a\0\u0aa8"+
    "\0\u0ae6\0\u0b24\0\u0b62\0\u0ba0\0\174\0\174\0\u0bde\0\u0c1c"+
    "\0\u0c5a\0\u0326\0\u0c98\0\174\0\u0cd6\0\174\0\u0d14\0\u0d52"+
    "\0\u0d90\0\174\0\174\0\174\0\174\0\174\0\u0dce\0\u0e0c"+
    "\0\u0e4a\0\u0e88\0\u0ec6\0\u0f04\0\u0f42\0\u0f80\0\u0fbe\0\u0ffc"+
    "\0\u103a\0\u01b2\0\u1078\0\u10b6\0\u10f4\0\u1132\0\u1170\0\u11ae"+
    "\0\u11ec\0\u122a\0\u1268\0\u12a6\0\u12e4\0\u01b2\0\u01b2\0\u1322"+
    "\0\174\0\u1360\0\u139e\0\u13dc\0\u0a6a\0\u0aa8\0\u141a\0\u1458"+
    "\0\u1496\0\u14d4\0\u1512\0\u1550\0\174\0\u158e\0\u01b2\0\u01b2"+
    "\0\u15cc\0\u01b2\0\u160a\0\u1648\0\u1686\0\u16c4\0\u1702\0\u1740"+
    "\0\u01b2\0\u177e\0\u17bc\0\u17fa\0\u1838\0\u1876\0\u01b2\0\u18b4"+
    "\0\u01b2\0\u18f2\0\u1930\0\u01b2\0\u196e\0\u13dc\0\u19ac\0\u19ea"+
    "\0\u01b2\0\u01b2\0\u01b2\0\u1a28\0\u1a66\0\u01b2\0\u01b2\0\u01b2"+
    "\0\u1aa4\0\u1ae2\0\u1b20\0\u1b5e\0\u1b9c\0\u1bda\0\u1c18\0\u1c56"+
    "\0\u1c94\0\u01b2\0\u1cd2\0\u1d10\0\u01b2\0\u01b2\0\u1d4e\0\u1d8c"+
    "\0\u1dca\0\u1e08\0\u1e46\0\u01b2\0\u1e84\0\u1ec2\0\u1f00\0\u01b2"+
    "\0\u01b2\0\u01b2\0\u1f3e\0\u1f7c\0\u01b2\0\u01b2\0\u1fba\0\u1ff8"+
    "\0\u01b2\0\u01b2\0\u2036\0\u2074\0\u01b2\0\u01b2\0\u20b2\0\u01b2"+
    "\0\u20f0\0\u212e\0\u216c\0\u21aa\0\u01b2\0\u21e8\0\u2226\0\u01b2"+
    "\0\u01b2";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[209];
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
    "\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12"+
    "\2\13\1\14\1\5\1\15\1\16\1\17\1\3\1\7"+
    "\1\3\1\20\1\21\1\22\1\13\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\1\36\1\13\1\37\1\40\1\13\1\41\1\42\1\43"+
    "\1\44\1\45\1\46\1\13\1\47\1\50\1\51\1\13"+
    "\1\52\1\13\1\53\1\54\1\55\1\56\1\57\1\60"+
    "\1\61\1\62\1\63\1\64\1\65\4\66\1\67\11\66"+
    "\1\70\1\66\1\67\1\66\1\71\53\66\77\0\1\72"+
    "\1\13\3\0\7\13\10\0\1\13\4\0\1\73\5\0"+
    "\23\13\15\0\1\5\1\74\2\0\2\5\3\0\1\5"+
    "\1\75\64\0\1\76\77\0\1\10\71\0\2\13\3\0"+
    "\7\13\10\0\1\13\12\0\23\13\15\0\1\5\1\74"+
    "\2\0\2\5\1\77\1\0\1\100\1\5\1\75\62\0"+
    "\2\13\3\0\7\13\10\0\1\13\12\0\11\13\1\101"+
    "\11\13\14\0\2\13\3\0\2\13\1\102\4\13\10\0"+
    "\1\13\12\0\1\13\1\103\3\13\1\104\15\13\30\0"+
    "\1\105\14\0\1\73\3\0\1\106\37\0\4\107\1\0"+
    "\11\107\1\110\1\111\1\0\55\107\4\112\1\0\12\112"+
    "\1\113\1\0\1\112\1\114\53\112\4\21\1\115\13\21"+
    "\1\116\55\21\6\0\1\22\1\0\3\22\1\0\1\22"+
    "\10\0\1\22\12\0\23\22\15\0\1\117\3\0\7\117"+
    "\1\0\1\120\6\0\1\117\1\0\1\117\10\0\23\117"+
    "\45\0\1\73\45\0\2\121\2\0\7\121\10\0\1\121"+
    "\1\0\1\121\2\0\1\73\5\0\23\121\44\0\1\122"+
    "\1\73\75\0\1\123\75\0\1\73\1\0\1\124\73\0"+
    "\1\123\2\0\1\125\72\0\1\123\3\0\1\126\40\0"+
    "\2\13\3\0\7\13\10\0\1\13\12\0\11\13\1\127"+
    "\11\13\14\0\2\13\3\0\7\13\10\0\1\13\12\0"+
    "\6\13\1\130\3\13\1\131\1\13\1\132\6\13\14\0"+
    "\2\13\3\0\6\13\1\133\10\0\1\13\12\0\1\134"+
    "\13\13\1\135\2\13\1\136\3\13\14\0\2\13\3\0"+
    "\7\13\10\0\1\13\12\0\5\13\1\137\4\13\1\140"+
    "\10\13\14\0\2\13\3\0\7\13\10\0\1\13\12\0"+
    "\1\13\1\141\1\13\1\142\15\13\1\143\1\13\14\0"+
    "\2\13\3\0\7\13\10\0\1\13\12\0\6\13\1\144"+
    "\14\13\14\0\2\13\3\0\7\13\10\0\1\13\12\0"+
    "\6\13\1\145\3\13\1\146\10\13\14\0\2\13\3\0"+
    "\6\13\1\147\10\0\1\13\12\0\23\13\14\0\2\13"+
    "\3\0\7\13\10\0\1\13\12\0\11\13\1\72\11\13"+
    "\14\0\2\13\3\0\6\13\1\150\10\0\1\13\12\0"+
    "\23\13\14\0\2\13\3\0\7\13\10\0\1\13\12\0"+
    "\6\13\1\151\3\13\1\152\1\13\1\153\6\13\14\0"+
    "\2\13\3\0\7\13\10\0\1\13\12\0\6\13\1\154"+
    "\14\13\14\0\2\13\3\0\7\13\10\0\1\13\12\0"+
    "\1\13\1\155\1\13\1\156\11\13\1\157\5\13\14\0"+
    "\2\13\3\0\7\13\10\0\1\13\12\0\22\13\1\160"+
    "\45\0\1\161\43\0\4\66\1\0\11\66\1\0\1\66"+
    "\1\0\1\66\1\0\53\66\16\0\1\162\61\0\1\163"+
    "\3\0\2\163\3\0\1\163\77\0\1\164\62\0\1\165"+
    "\3\0\2\165\1\0\4\165\25\0\1\165\1\0\1\165"+
    "\1\0\1\165\6\0\1\165\26\0\2\166\3\0\1\166"+
    "\63\0\2\13\3\0\6\13\1\167\10\0\1\13\12\0"+
    "\23\13\14\0\2\13\3\0\7\13\10\0\1\13\12\0"+
    "\1\170\22\13\14\0\2\13\3\0\7\13\10\0\1\13"+
    "\12\0\14\13\1\171\6\13\14\0\2\13\3\0\7\13"+
    "\10\0\1\13\12\0\3\13\1\172\13\13\1\173\3\13"+
    "\13\0\4\107\1\0\11\107\1\114\1\111\1\0\55\107"+
    "\16\0\1\174\57\0\4\107\1\0\13\107\2\0\54\107"+
    "\4\112\1\0\13\112\2\0\54\112\20\0\1\116\57\0"+
    "\1\117\3\0\7\117\10\0\1\117\1\0\1\117\10\0"+
    "\23\117\15\0\2\120\2\0\7\120\1\0\1\175\6\0"+
    "\1\120\1\0\1\120\10\0\23\120\15\0\2\121\2\0"+
    "\7\121\10\0\1\121\1\0\1\121\10\0\23\121\14\0"+
    "\2\13\3\0\7\13\10\0\1\13\12\0\14\13\1\176"+
    "\6\13\14\0\2\13\3\0\7\13\10\0\1\13\12\0"+
    "\1\13\1\177\21\13\14\0\2\13\3\0\7\13\10\0"+
    "\1\13\12\0\1\200\22\13\14\0\2\13\3\0\7\13"+
    "\10\0\1\13\12\0\5\13\1\201\15\13\14\0\2\13"+
    "\3\0\7\13\10\0\1\13\12\0\1\202\4\13\1\203"+
    "\15\13\14\0\2\13\3\0\7\13\10\0\1\13\12\0"+
    "\6\13\1\204\14\13\14\0\2\13\3\0\7\13\10\0"+
    "\1\13\12\0\16\13\1\205\4\13\14\0\2\13\3\0"+
    "\7\13\10\0\1\13\12\0\13\13\1\206\7\13\14\0"+
    "\2\13\3\0\7\13\10\0\1\13\12\0\6\13\1\207"+
    "\14\13\14\0\2\13\3\0\7\13\10\0\1\13\12\0"+
    "\1\13\1\210\21\13\14\0\2\13\3\0\7\13\10\0"+
    "\1\13\12\0\2\13\1\211\20\13\14\0\2\13\3\0"+
    "\7\13\10\0\1\13\12\0\6\13\1\212\14\13\14\0"+
    "\2\13\3\0\7\13\10\0\1\13\12\0\1\213\22\13"+
    "\14\0\2\13\3\0\7\13\10\0\1\13\12\0\11\13"+
    "\1\214\11\13\14\0\2\13\3\0\7\13\10\0\1\13"+
    "\12\0\17\13\1\215\3\13\14\0\2\13\3\0\7\13"+
    "\10\0\1\13\12\0\1\216\22\13\14\0\2\13\3\0"+
    "\7\13\10\0\1\13\12\0\1\217\22\13\14\0\2\13"+
    "\3\0\7\13\10\0\1\13\12\0\5\13\1\220\15\13"+
    "\14\0\2\13\3\0\7\13\10\0\1\13\12\0\11\13"+
    "\1\221\11\13\14\0\2\13\3\0\7\13\10\0\1\13"+
    "\12\0\1\13\1\222\21\13\14\0\2\13\3\0\7\13"+
    "\10\0\1\13\12\0\3\13\1\223\17\13\14\0\2\13"+
    "\3\0\7\13\10\0\1\13\12\0\15\13\1\224\5\13"+
    "\14\0\2\13\3\0\7\13\10\0\1\13\12\0\17\13"+
    "\1\225\3\13\31\0\1\71\61\0\1\163\3\0\2\163"+
    "\3\0\1\163\1\75\63\0\1\226\4\0\1\226\3\0"+
    "\1\226\63\0\2\13\3\0\7\13\10\0\1\13\12\0"+
    "\6\13\1\227\14\13\14\0\2\13\3\0\6\13\1\230"+
    "\10\0\1\13\12\0\23\13\14\0\2\13\3\0\7\13"+
    "\10\0\1\13\12\0\7\13\1\231\13\13\14\0\2\13"+
    "\3\0\6\13\1\232\10\0\1\13\12\0\23\13\14\0"+
    "\2\13\3\0\7\13\10\0\1\13\12\0\15\13\1\233"+
    "\5\13\13\0\16\174\1\234\1\235\56\174\1\0\2\13"+
    "\3\0\6\13\1\236\10\0\1\13\12\0\23\13\14\0"+
    "\2\13\3\0\7\13\10\0\1\13\12\0\5\13\1\237"+
    "\15\13\14\0\2\13\3\0\7\13\10\0\1\13\12\0"+
    "\15\13\1\240\5\13\14\0\2\13\3\0\7\13\10\0"+
    "\1\13\12\0\1\241\22\13\14\0\2\13\3\0\6\13"+
    "\1\242\10\0\1\13\12\0\23\13\14\0\2\13\3\0"+
    "\7\13\10\0\1\13\12\0\1\13\1\243\21\13\14\0"+
    "\2\13\3\0\7\13\10\0\1\13\12\0\3\13\1\244"+
    "\17\13\14\0\2\13\3\0\7\13\10\0\1\13\12\0"+
    "\1\245\2\13\1\246\17\13\14\0\2\13\3\0\7\13"+
    "\10\0\1\13\12\0\17\13\1\247\3\13\14\0\2\13"+
    "\3\0\7\13\10\0\1\13\12\0\4\13\1\250\16\13"+
    "\14\0\2\13\3\0\7\13\10\0\1\13\12\0\6\13"+
    "\1\251\14\13\14\0\2\13\3\0\7\13\10\0\1\13"+
    "\12\0\2\13\1\252\20\13\14\0\2\13\3\0\7\13"+
    "\10\0\1\13\12\0\14\13\1\253\6\13\14\0\2\13"+
    "\3\0\7\13\10\0\1\13\12\0\3\13\1\254\17\13"+
    "\14\0\2\13\3\0\7\13\10\0\1\13\12\0\4\13"+
    "\1\255\16\13\14\0\2\13\3\0\7\13\10\0\1\13"+
    "\12\0\3\13\1\256\17\13\14\0\2\13\3\0\7\13"+
    "\10\0\1\13\12\0\5\13\1\257\15\13\14\0\2\13"+
    "\3\0\7\13\10\0\1\13\12\0\20\13\1\260\2\13"+
    "\14\0\2\13\3\0\7\13\10\0\1\13\12\0\1\13"+
    "\1\261\21\13\31\0\1\262\57\0\4\174\1\0\13\174"+
    "\2\0\54\174\1\0\2\13\3\0\7\13\10\0\1\13"+
    "\12\0\17\13\1\263\3\13\14\0\2\13\3\0\7\13"+
    "\10\0\1\13\12\0\11\13\1\264\11\13\14\0\2\13"+
    "\3\0\7\13\10\0\1\13\12\0\6\13\1\265\14\13"+
    "\14\0\2\13\3\0\7\13\10\0\1\13\12\0\3\13"+
    "\1\266\17\13\14\0\2\13\3\0\7\13\10\0\1\13"+
    "\12\0\17\13\1\267\3\13\14\0\2\13\3\0\7\13"+
    "\10\0\1\13\12\0\1\270\22\13\14\0\2\13\3\0"+
    "\7\13\10\0\1\13\12\0\1\271\22\13\14\0\2\13"+
    "\3\0\7\13\10\0\1\13\12\0\22\13\1\272\14\0"+
    "\2\13\3\0\7\13\10\0\1\13\12\0\11\13\1\273"+
    "\11\13\14\0\2\13\3\0\7\13\10\0\1\13\12\0"+
    "\11\13\1\274\11\13\14\0\2\13\3\0\6\13\1\275"+
    "\10\0\1\13\12\0\23\13\14\0\2\13\3\0\6\13"+
    "\1\276\10\0\1\13\12\0\23\13\14\0\2\13\3\0"+
    "\7\13\10\0\1\13\12\0\16\13\1\277\4\13\14\0"+
    "\2\13\3\0\7\13\10\0\1\13\12\0\2\13\1\300"+
    "\20\13\31\0\1\114\60\0\2\13\3\0\7\13\10\0"+
    "\1\13\12\0\4\13\1\301\16\13\14\0\2\13\3\0"+
    "\7\13\10\0\1\13\12\0\5\13\1\302\15\13\14\0"+
    "\2\13\3\0\1\303\6\13\10\0\1\13\12\0\23\13"+
    "\14\0\2\13\3\0\7\13\10\0\1\13\12\0\1\13"+
    "\1\304\21\13\14\0\2\13\3\0\7\13\10\0\1\13"+
    "\12\0\13\13\1\305\7\13\14\0\2\13\3\0\7\13"+
    "\10\0\1\13\12\0\1\13\1\306\21\13\14\0\2\13"+
    "\3\0\7\13\10\0\1\13\12\0\12\13\1\307\10\13"+
    "\14\0\2\13\3\0\7\13\10\0\1\13\12\0\3\13"+
    "\1\310\17\13\14\0\2\13\3\0\7\13\10\0\1\13"+
    "\12\0\1\13\1\311\21\13\14\0\2\13\3\0\7\13"+
    "\10\0\1\13\12\0\14\13\1\312\6\13\14\0\2\13"+
    "\3\0\7\13\10\0\1\13\12\0\17\13\1\313\3\13"+
    "\14\0\2\13\3\0\7\13\10\0\1\13\12\0\6\13"+
    "\1\314\14\13\14\0\2\13\3\0\6\13\1\315\10\0"+
    "\1\13\12\0\23\13\14\0\2\13\3\0\7\13\10\0"+
    "\1\13\12\0\1\13\1\316\21\13\14\0\2\13\3\0"+
    "\7\13\10\0\1\13\12\0\7\13\1\317\13\13\14\0"+
    "\2\13\3\0\7\13\10\0\1\13\12\0\1\320\22\13"+
    "\14\0\2\13\3\0\6\13\1\321\10\0\1\13\12\0"+
    "\23\13\13\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[8804];
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
    "\1\0\1\1\1\11\3\1\1\11\43\1\1\11\1\1"+
    "\11\11\1\1\1\11\1\1\1\11\1\1\1\11\2\0"+
    "\1\11\2\0\4\1\2\11\1\0\1\1\3\0\1\11"+
    "\1\1\1\11\1\1\1\0\1\1\5\11\32\1\1\11"+
    "\1\0\1\1\1\0\7\1\1\0\1\11\36\1\2\0"+
    "\24\1\1\0\37\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[209];
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


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  GdLexerHighlighter(java.io.Reader in) {
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
        switch (zzLexicalState) {
            case STRING: {
              yybegin(YYINITIAL);
        return GdTypes.STRING;
            }  // fall though
            case 210: break;
            default:
              {
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
          case 80: break;
          case 2: 
            { return GdTypes.BAD_CHARACTER;
            } 
            // fall through
          case 81: break;
          case 3: 
            { return GdTypes.OR;
            } 
            // fall through
          case 82: break;
          case 4: 
            { return GdTypes.NUMBER;
            } 
            // fall through
          case 83: break;
          case 5: 
            { return GdTypes.DOT;
            } 
            // fall through
          case 84: break;
          case 6: 
            { return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 85: break;
          case 7: 
            { return GdTypes.UNDER;
            } 
            // fall through
          case 86: break;
          case 8: 
            { return GdTypes.IDENTIFIER;
            } 
            // fall through
          case 87: break;
          case 9: 
            { return GdTypes.MINUS;
            } 
            // fall through
          case 88: break;
          case 10: 
            { return GdTypes.COMMENT;
            } 
            // fall through
          case 89: break;
          case 11: 
            { return GdTypes.ANNOTATOR;
            } 
            // fall through
          case 90: break;
          case 12: 
            { return GdTypes.NODE_PATH_LEX;
            } 
            // fall through
          case 91: break;
          case 13: 
            { return GdTypes.DIV;
            } 
            // fall through
          case 92: break;
          case 14: 
            { return GdTypes.MOD;
            } 
            // fall through
          case 93: break;
          case 15: 
            { return GdTypes.PLUS;
            } 
            // fall through
          case 94: break;
          case 16: 
            { return GdTypes.EQ;
            } 
            // fall through
          case 95: break;
          case 17: 
            { return GdTypes.MUL;
            } 
            // fall through
          case 96: break;
          case 18: 
            { return GdTypes.AND;
            } 
            // fall through
          case 97: break;
          case 19: 
            { return GdTypes.TEST_OPERATOR;
            } 
            // fall through
          case 98: break;
          case 20: 
            { return GdTypes.NEGATE;
            } 
            // fall through
          case 99: break;
          case 21: 
            { return GdTypes.COMMA;
            } 
            // fall through
          case 100: break;
          case 22: 
            { return GdTypes.COLON;
            } 
            // fall through
          case 101: break;
          case 23: 
            { return GdTypes.SEMICON;
            } 
            // fall through
          case 102: break;
          case 24: 
            { return GdTypes.LRBR;
            } 
            // fall through
          case 103: break;
          case 25: 
            { return GdTypes.RRBR;
            } 
            // fall through
          case 104: break;
          case 26: 
            { return GdTypes.LSBR;
            } 
            // fall through
          case 105: break;
          case 27: 
            { return GdTypes.RSBR;
            } 
            // fall through
          case 106: break;
          case 28: 
            { return GdTypes.LCBR;
            } 
            // fall through
          case 107: break;
          case 29: 
            { return GdTypes.RCBR;
            } 
            // fall through
          case 108: break;
          case 30: 
            { return GdTypes.XOR;
            } 
            // fall through
          case 109: break;
          case 31: 
            { return GdTypes.NOT;
            } 
            // fall through
          case 110: break;
          case 32: 
            { if (!oppening.equals("\"\"\"")) {
            yybegin(lastState);
            return TokenType.BAD_CHARACTER;
        }
            } 
            // fall through
          case 111: break;
          case 33: 
            { if (oppening.equals(yytext().toString())) {
            yybegin(lastState);
            return GdTypes.STRING;
        }
            } 
            // fall through
          case 112: break;
          case 34: 
            { return GdTypes.OROR;
            } 
            // fall through
          case 113: break;
          case 35: 
            { return GdTypes.ASSIGN;
            } 
            // fall through
          case 114: break;
          case 36: 
            { return GdTypes.DOTDOT;
            } 
            // fall through
          case 115: break;
          case 37: 
            { return GdTypes.MMINUS;
            } 
            // fall through
          case 116: break;
          case 38: 
            { return GdTypes.RET;
            } 
            // fall through
          case 117: break;
          case 39: 
            { return GdTypes.STRING;
            } 
            // fall through
          case 118: break;
          case 40: 
            { return GdTypes.PPLUS;
            } 
            // fall through
          case 119: break;
          case 41: 
            { return GdTypes.ANDAND;
            } 
            // fall through
          case 120: break;
          case 42: 
            { return GdTypes.LBSHIFT;
            } 
            // fall through
          case 121: break;
          case 43: 
            { return GdTypes.RBSHIFT;
            } 
            // fall through
          case 122: break;
          case 44: 
            { return GdTypes.AS;
            } 
            // fall through
          case 123: break;
          case 45: 
            { return GdTypes.IN;
            } 
            // fall through
          case 124: break;
          case 46: 
            { return GdTypes.IS;
            } 
            // fall through
          case 125: break;
          case 47: 
            { return GdTypes.IF;
            } 
            // fall through
          case 126: break;
          case 48: 
            { return GdTypes.CEQ;
            } 
            // fall through
          case 127: break;
          case 49: 
            { return GdTypes.NAN;
            } 
            // fall through
          case 128: break;
          case 50: 
            { return GdTypes.SET;
            } 
            // fall through
          case 129: break;
          case 51: 
            { return GdTypes.VAR;
            } 
            // fall through
          case 130: break;
          case 52: 
            { return GdTypes.GET;
            } 
            // fall through
          case 131: break;
          case 53: 
            { return GdTypes.FOR;
            } 
            // fall through
          case 132: break;
          case 54: 
            { return GdTypes.INF;
            } 
            // fall through
          case 133: break;
          case 55: 
            { return GdTypes.ENUM;
            } 
            // fall through
          case 134: break;
          case 56: 
            { return GdTypes.ELSE;
            } 
            // fall through
          case 135: break;
          case 57: 
            { return GdTypes.ELIF;
            } 
            // fall through
          case 136: break;
          case 58: 
            { return GdTypes.TRUE;
            } 
            // fall through
          case 137: break;
          case 59: 
            { return GdTypes.NULL;
            } 
            // fall through
          case 138: break;
          case 60: 
            { return GdTypes.SELF;
            } 
            // fall through
          case 139: break;
          case 61: 
            { return GdTypes.VOID;
            } 
            // fall through
          case 140: break;
          case 62: 
            { return GdTypes.FUNC;
            } 
            // fall through
          case 141: break;
          case 63: 
            { return GdTypes.PASS;
            } 
            // fall through
          case 142: break;
          case 64: 
            { return GdTypes.BREAK;
            } 
            // fall through
          case 143: break;
          case 65: 
            { return GdTypes.SUPER;
            } 
            // fall through
          case 144: break;
          case 66: 
            { return GdTypes.CLASS;
            } 
            // fall through
          case 145: break;
          case 67: 
            { return GdTypes.CONST;
            } 
            // fall through
          case 146: break;
          case 68: 
            { return GdTypes.AWAIT;
            } 
            // fall through
          case 147: break;
          case 69: 
            { return GdTypes.MATCH;
            } 
            // fall through
          case 148: break;
          case 70: 
            { return GdTypes.FALSE;
            } 
            // fall through
          case 149: break;
          case 71: 
            { return GdTypes.WHILE;
            } 
            // fall through
          case 150: break;
          case 72: 
            { return GdTypes.STATIC;
            } 
            // fall through
          case 151: break;
          case 73: 
            { return GdTypes.SIGNAL;
            } 
            // fall through
          case 152: break;
          case 74: 
            { return GdTypes.VARARG;
            } 
            // fall through
          case 153: break;
          case 75: 
            { return GdTypes.RETURN;
            } 
            // fall through
          case 154: break;
          case 76: 
            { return GdTypes.EXTENDS;
            } 
            // fall through
          case 155: break;
          case 77: 
            { return GdTypes.CONTINUE;
            } 
            // fall through
          case 156: break;
          case 78: 
            { return GdTypes.BREAKPOINT;
            } 
            // fall through
          case 157: break;
          case 79: 
            { return GdTypes.CLASS_NAME;
            } 
            // fall through
          case 158: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
