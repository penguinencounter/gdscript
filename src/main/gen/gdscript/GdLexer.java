/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package gdscript;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import gdscript.psi.GdTypes;
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

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2, 2
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
    "\11\0\1\5\1\7\2\10\1\4\22\0\1\5\1\60\1\6\1\11\1\0\2\17\1\0\1\62\1\63\1\17"+
    "\1\14\1\55\1\16\1\3\1\17\12\2\1\56\1\57\1\0\1\15\1\61\1\0\1\12\1\51\4\13\1"+
    "\54\2\13\1\47\4\13\1\53\1\13\1\46\2\13\1\43\1\50\1\52\5\13\4\0\1\1\1\0\1\31"+
    "\1\44\1\27\1\25\1\21\1\37\1\36\1\13\1\42\1\13\1\45\1\30\1\32\1\24\1\33\1\41"+
    "\1\13\1\35\1\26\1\23\1\40\1\34\1\13\1\22\2\13\1\0\1\20\10\0\1\10\242\0\2\10"+
    "\26\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\1\1\1\2\1\3\1\4\1\5\1\6\1\1"+
    "\1\7\1\10\1\1\1\11\2\1\21\2\1\12\1\13"+
    "\1\14\1\15\1\16\1\17\1\20\1\21\1\3\1\0"+
    "\1\22\2\7\1\23\1\24\1\25\1\26\21\2\1\27"+
    "\14\2\1\30\5\2\1\31\2\2\1\32\1\33\1\34"+
    "\1\2\1\35\1\36\1\37\1\2\1\40\4\2\1\41"+
    "\2\2\1\42\1\43\7\2\1\44\1\2\1\45\1\2"+
    "\1\46\1\2\1\47\1\50\2\2\1\51\1\52\1\2"+
    "\1\53\4\2\1\54\3\2\1\55\1\56";

  private static int [] zzUnpackAction() {
    int [] result = new int[138];
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
    "\0\0\0\64\0\150\0\234\0\320\0\u0104\0\u0138\0\234"+
    "\0\u016c\0\u01a0\0\u01d4\0\u0208\0\u023c\0\234\0\u0270\0\u02a4"+
    "\0\u02d8\0\u030c\0\u0340\0\u0374\0\u03a8\0\u03dc\0\u0410\0\u0444"+
    "\0\u0478\0\u04ac\0\u04e0\0\u0514\0\u0548\0\u057c\0\u05b0\0\u05e4"+
    "\0\u0618\0\234\0\234\0\234\0\234\0\234\0\234\0\234"+
    "\0\234\0\u0138\0\u01a0\0\u01a0\0\u064c\0\234\0\234\0\234"+
    "\0\234\0\234\0\u0680\0\u06b4\0\u06e8\0\u071c\0\u0750\0\u0784"+
    "\0\u07b8\0\u07ec\0\u0820\0\u0854\0\u0888\0\u08bc\0\u08f0\0\u0924"+
    "\0\u0958\0\u098c\0\u09c0\0\320\0\u09f4\0\u0a28\0\u0a5c\0\u0a90"+
    "\0\u0ac4\0\u0af8\0\u0b2c\0\u0b60\0\u0b94\0\u0bc8\0\u0bfc\0\u0c30"+
    "\0\320\0\u0c64\0\u0c98\0\u0ccc\0\u0d00\0\u0d34\0\320\0\u0d68"+
    "\0\u0d9c\0\320\0\320\0\320\0\u0dd0\0\320\0\320\0\320"+
    "\0\u0e04\0\320\0\u0e38\0\u0e6c\0\u0ea0\0\u0ed4\0\320\0\u0f08"+
    "\0\u0f3c\0\320\0\320\0\u0f70\0\u0fa4\0\u0fd8\0\u100c\0\u1040"+
    "\0\u1074\0\u10a8\0\320\0\u10dc\0\320\0\u1110\0\u1144\0\u1178"+
    "\0\320\0\320\0\u11ac\0\u11e0\0\320\0\320\0\u1214\0\320"+
    "\0\u1248\0\u127c\0\u12b0\0\u12e4\0\320\0\u1318\0\u134c\0\u1380"+
    "\0\320\0\320";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[138];
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
    "\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\10"+
    "\1\4\1\13\1\14\1\5\1\15\1\16\1\17\1\20"+
    "\1\21\1\22\1\5\1\23\1\24\1\5\1\25\1\26"+
    "\4\5\1\27\1\30\1\5\1\31\1\5\1\32\1\33"+
    "\1\34\1\35\1\5\1\36\1\37\1\40\2\5\1\41"+
    "\1\5\1\42\1\43\1\44\1\45\1\4\1\46\1\47"+
    "\1\4\1\5\1\6\1\7\1\50\1\11\1\12\1\50"+
    "\1\4\1\13\1\14\1\5\1\15\1\16\1\17\1\20"+
    "\1\21\1\22\1\5\1\23\1\24\1\5\1\25\1\26"+
    "\4\5\1\27\1\30\1\5\1\31\1\5\1\32\1\33"+
    "\1\34\1\35\1\5\1\36\1\37\1\40\2\5\1\41"+
    "\1\5\1\42\1\43\1\44\1\45\1\4\1\46\1\47"+
    "\1\4\1\5\1\6\1\7\1\51\1\11\1\12\1\51"+
    "\1\4\1\13\1\14\1\5\1\15\1\16\1\17\1\20"+
    "\1\21\1\22\1\5\1\23\1\24\1\5\1\25\1\26"+
    "\4\5\1\27\1\30\1\5\1\31\1\5\1\32\1\33"+
    "\1\34\1\35\1\5\1\36\1\37\1\40\2\5\1\41"+
    "\1\5\1\42\1\43\1\44\1\45\1\4\1\46\1\47"+
    "\65\0\2\5\10\0\1\5\4\0\35\5\11\0\1\6"+
    "\1\52\62\0\1\52\66\0\1\11\56\0\4\53\1\0"+
    "\1\53\1\54\2\0\53\53\4\13\1\55\2\13\1\56"+
    "\54\13\13\0\1\14\4\0\35\14\23\0\1\57\1\60"+
    "\63\0\1\60\1\61\42\0\1\62\17\0\1\60\47\0"+
    "\2\5\10\0\1\5\1\0\1\60\2\0\35\5\10\0"+
    "\2\5\10\0\1\5\4\0\2\5\1\63\32\5\10\0"+
    "\2\5\10\0\1\5\4\0\13\5\1\64\1\5\1\65"+
    "\17\5\10\0\2\5\10\0\1\5\4\0\20\5\1\66"+
    "\14\5\10\0\2\5\10\0\1\5\4\0\1\5\1\67"+
    "\20\5\1\70\12\5\10\0\2\5\10\0\1\5\4\0"+
    "\10\5\1\71\2\5\1\72\21\5\10\0\2\5\10\0"+
    "\1\5\4\0\11\5\1\73\1\5\1\74\21\5\10\0"+
    "\2\5\10\0\1\5\4\0\1\5\1\75\33\5\10\0"+
    "\2\5\10\0\1\5\4\0\11\5\1\76\6\5\1\77"+
    "\14\5\10\0\2\5\10\0\1\5\4\0\11\5\1\100"+
    "\23\5\10\0\2\5\10\0\1\5\4\0\4\5\1\101"+
    "\30\5\10\0\2\5\10\0\1\5\4\0\3\5\1\102"+
    "\31\5\10\0\2\5\10\0\1\5\4\0\15\5\1\103"+
    "\17\5\10\0\2\5\10\0\1\5\4\0\27\5\1\104"+
    "\5\5\10\0\2\5\10\0\1\5\4\0\33\5\1\105"+
    "\1\5\10\0\2\5\10\0\1\5\4\0\31\5\1\106"+
    "\3\5\10\0\2\5\10\0\1\5\4\0\31\5\1\107"+
    "\3\5\16\0\1\56\55\0\2\5\10\0\1\5\4\0"+
    "\3\5\1\110\31\5\10\0\2\5\10\0\1\5\4\0"+
    "\13\5\1\111\21\5\10\0\2\5\10\0\1\5\4\0"+
    "\20\5\1\112\14\5\10\0\2\5\10\0\1\5\4\0"+
    "\10\5\1\113\24\5\10\0\2\5\10\0\1\5\4\0"+
    "\3\5\1\114\4\5\1\115\24\5\10\0\2\5\10\0"+
    "\1\5\4\0\16\5\1\116\16\5\10\0\2\5\10\0"+
    "\1\5\4\0\11\5\1\117\23\5\10\0\2\5\10\0"+
    "\1\5\4\0\4\5\1\120\30\5\10\0\2\5\10\0"+
    "\1\5\4\0\15\5\1\121\17\5\10\0\2\5\10\0"+
    "\1\5\4\0\22\5\1\122\12\5\10\0\2\5\10\0"+
    "\1\5\4\0\3\5\1\123\31\5\10\0\2\5\10\0"+
    "\1\5\4\0\10\5\1\124\24\5\10\0\2\5\10\0"+
    "\1\5\4\0\4\5\1\125\30\5\10\0\2\5\10\0"+
    "\1\5\4\0\6\5\1\126\26\5\10\0\2\5\10\0"+
    "\1\5\4\0\3\5\1\127\31\5\10\0\2\5\10\0"+
    "\1\5\4\0\15\5\1\130\17\5\10\0\2\5\10\0"+
    "\1\5\4\0\1\5\1\131\33\5\10\0\2\5\10\0"+
    "\1\5\4\0\34\5\1\132\10\0\2\5\10\0\1\5"+
    "\4\0\32\5\1\133\2\5\10\0\2\5\10\0\1\5"+
    "\4\0\33\5\1\134\1\5\10\0\2\5\10\0\1\5"+
    "\4\0\1\5\1\135\33\5\10\0\2\5\10\0\1\5"+
    "\4\0\10\5\1\136\24\5\10\0\2\5\10\0\1\5"+
    "\4\0\1\5\1\137\33\5\10\0\2\5\10\0\1\5"+
    "\4\0\10\5\1\140\24\5\10\0\2\5\10\0\1\5"+
    "\4\0\16\5\1\141\16\5\10\0\2\5\10\0\1\5"+
    "\4\0\17\5\1\142\15\5\10\0\2\5\10\0\1\5"+
    "\4\0\4\5\1\143\30\5\10\0\2\5\10\0\1\5"+
    "\4\0\6\5\1\144\26\5\10\0\2\5\10\0\1\5"+
    "\4\0\3\5\1\145\2\5\1\146\26\5\10\0\2\5"+
    "\10\0\1\5\4\0\5\5\1\147\27\5\10\0\2\5"+
    "\10\0\1\5\4\0\20\5\1\150\14\5\10\0\2\5"+
    "\10\0\1\5\4\0\6\5\1\151\26\5\10\0\2\5"+
    "\10\0\1\5\4\0\7\5\1\152\25\5\10\0\2\5"+
    "\10\0\1\5\4\0\6\5\1\153\26\5\10\0\2\5"+
    "\10\0\1\5\4\0\22\5\1\154\12\5\10\0\2\5"+
    "\10\0\1\5\4\0\11\5\1\155\23\5\10\0\2\5"+
    "\10\0\1\5\4\0\4\5\1\156\30\5\10\0\2\5"+
    "\10\0\1\5\4\0\1\5\1\157\33\5\10\0\2\5"+
    "\10\0\1\5\4\0\11\5\1\160\23\5\10\0\2\5"+
    "\10\0\1\5\4\0\6\5\1\161\26\5\10\0\2\5"+
    "\10\0\1\5\4\0\22\5\1\162\12\5\10\0\2\5"+
    "\10\0\1\5\4\0\3\5\1\163\31\5\10\0\2\5"+
    "\10\0\1\5\4\0\15\5\1\164\17\5\10\0\2\5"+
    "\10\0\1\5\4\0\1\5\1\165\33\5\10\0\2\5"+
    "\10\0\1\5\4\0\4\5\1\166\30\5\10\0\2\5"+
    "\10\0\1\5\4\0\25\5\1\167\7\5\10\0\2\5"+
    "\10\0\1\5\4\0\5\5\1\170\27\5\10\0\2\5"+
    "\10\0\1\5\4\0\3\5\1\171\31\5\10\0\2\5"+
    "\10\0\1\5\4\0\10\5\1\172\24\5\10\0\1\173"+
    "\1\5\10\0\1\5\4\0\35\5\10\0\2\5\10\0"+
    "\1\5\4\0\4\5\1\174\30\5\10\0\2\5\10\0"+
    "\1\5\4\0\4\5\1\175\30\5\10\0\2\5\10\0"+
    "\1\5\4\0\16\5\1\176\16\5\10\0\2\5\10\0"+
    "\1\5\4\0\21\5\1\177\13\5\10\0\2\5\10\0"+
    "\1\5\4\0\6\5\1\200\26\5\10\0\2\5\10\0"+
    "\1\5\4\0\4\5\1\201\30\5\10\0\2\5\10\0"+
    "\1\5\4\0\20\5\1\202\14\5\10\0\2\5\10\0"+
    "\1\5\4\0\13\5\1\203\21\5\10\0\2\5\10\0"+
    "\1\5\4\0\11\5\1\204\23\5\10\0\2\5\10\0"+
    "\1\5\4\0\1\5\1\205\33\5\10\0\2\5\10\0"+
    "\1\5\4\0\22\5\1\206\12\5\10\0\2\5\10\0"+
    "\1\5\4\0\12\5\1\207\22\5\10\0\2\5\10\0"+
    "\1\5\4\0\4\5\1\210\30\5\10\0\2\5\10\0"+
    "\1\5\4\0\1\5\1\211\33\5\10\0\2\5\10\0"+
    "\1\5\4\0\3\5\1\212\31\5\7\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[5044];
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
    "\3\0\1\11\3\1\1\11\5\1\1\11\23\1\10\11"+
    "\1\1\1\0\2\1\5\11\130\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[138];
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
                if (dedentSpaces()) {
        return GdTypes.DEDENT;
    } else {
        return null;
    }
              }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return GdTypes.BAD_CHARACTER;
            } 
            // fall through
          case 47: break;
          case 2: 
            { return dedentRoot(GdTypes.IDENTIFIER);
            } 
            // fall through
          case 48: break;
          case 3: 
            { return dedentRoot(GdTypes.NUMBER);
            } 
            // fall through
          case 49: break;
          case 4: 
            { return GdTypes.DOT;
            } 
            // fall through
          case 50: break;
          case 5: 
            { return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 51: break;
          case 6: 
            { int spaces = yytext().length();
        if (yycolumn <= spaces) {
            if (spaces == 1) spaces = 0;

            if (spaces > indent) {
                indentSizes.push(spaces - indent);
                indent += spaces;
                return GdTypes.INDENT;
            } else if (indent > spaces) {
                dedentSpaces();
                return GdTypes.DEDENT;
            }
        }

        return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 52: break;
          case 7: 
            { return GdTypes.COMMENT;
            } 
            // fall through
          case 53: break;
          case 8: 
            { return GdTypes.ANNOTATOR;
            } 
            // fall through
          case 54: break;
          case 9: 
            { return GdTypes.EQ;
            } 
            // fall through
          case 55: break;
          case 10: 
            { return GdTypes.COMMA;
            } 
            // fall through
          case 56: break;
          case 11: 
            { return GdTypes.COLON;
            } 
            // fall through
          case 57: break;
          case 12: 
            { lineEnded = true; return GdTypes.SEMICON;
            } 
            // fall through
          case 58: break;
          case 13: 
            { return GdTypes.EXCLA;
            } 
            // fall through
          case 59: break;
          case 14: 
            { return dedentRoot(GdTypes.LRBR);
            } 
            // fall through
          case 60: break;
          case 15: 
            { return dedentRoot(GdTypes.RRBR);
            } 
            // fall through
          case 61: break;
          case 16: 
            { if (!lineEnded) {
              lineEnded = true;
              return GdTypes.NEW_LINE;
          }
          return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 62: break;
          case 17: 
            { yybegin(YYINITIAL);
          if (lineEnded) { // For signal, etc.
              return TokenType.WHITE_SPACE;
          }
          return GdTypes.NEW_LINE;
            } 
            // fall through
          case 63: break;
          case 18: 
            { return dedentRoot(GdTypes.STRING);
            } 
            // fall through
          case 64: break;
          case 19: 
            { return dedentRoot(GdTypes.PPLUS);
            } 
            // fall through
          case 65: break;
          case 20: 
            { return GdTypes.ASSIGN;
            } 
            // fall through
          case 66: break;
          case 21: 
            { return dedentRoot(GdTypes.MMINUS);
            } 
            // fall through
          case 67: break;
          case 22: 
            { return GdTypes.RET;
            } 
            // fall through
          case 68: break;
          case 23: 
            { return dedentRoot(GdTypes.PI);
            } 
            // fall through
          case 69: break;
          case 24: 
            { yybegin(AWAIT_NEW_LINE_ONCE); return dedentRoot(GdTypes.VAR);
            } 
            // fall through
          case 70: break;
          case 25: 
            { return dedentRoot(GdTypes.INT);
            } 
            // fall through
          case 71: break;
          case 26: 
            { return dedentRoot(GdTypes.INF);
            } 
            // fall through
          case 72: break;
          case 27: 
            { return dedentRoot(GdTypes.TAU);
            } 
            // fall through
          case 73: break;
          case 28: 
            { return dedentRoot(GdTypes.NAN);
            } 
            // fall through
          case 74: break;
          case 29: 
            { yybegin(AWAIT_NEW_LINE_ONCE); return dedentRoot(GdTypes.TOOL);
            } 
            // fall through
          case 75: break;
          case 30: 
            { return dedentRoot(GdTypes.TRUE);
            } 
            // fall through
          case 76: break;
          case 31: 
            { return dedentRoot(GdTypes.NULL);
            } 
            // fall through
          case 77: break;
          case 32: 
            { return dedentRoot(GdTypes.SELF);
            } 
            // fall through
          case 78: break;
          case 33: 
            { return dedentRoot(GdTypes.VOID);
            } 
            // fall through
          case 79: break;
          case 34: 
            { yybegin(AWAIT_NEW_LINE); return dedentRoot(GdTypes.FUNC);
            } 
            // fall through
          case 80: break;
          case 35: 
            { return dedentRoot(GdTypes.PASS);
            } 
            // fall through
          case 81: break;
          case 36: 
            { yybegin(AWAIT_NEW_LINE_ONCE); return dedentRoot(GdTypes.CONST);
            } 
            // fall through
          case 82: break;
          case 37: 
            { return dedentRoot(GdTypes.FALSE);
            } 
            // fall through
          case 83: break;
          case 38: 
            { return dedentRoot(GdTypes.BREAK);
            } 
            // fall through
          case 84: break;
          case 39: 
            { return GdTypes.SETGET;
            } 
            // fall through
          case 85: break;
          case 40: 
            { yybegin(AWAIT_NEW_LINE_ONCE); return GdTypes.SIGNAL;
            } 
            // fall through
          case 86: break;
          case 41: 
            { return dedentRoot(GdTypes.RETURN);
            } 
            // fall through
          case 87: break;
          case 42: 
            { return dedentRoot(GdTypes.STR);
            } 
            // fall through
          case 88: break;
          case 43: 
            { yybegin(AWAIT_NEW_LINE_ONCE); return dedentRoot(GdTypes.EXTENDS);
            } 
            // fall through
          case 89: break;
          case 44: 
            { return dedentRoot(GdTypes.CONTINUE);
            } 
            // fall through
          case 90: break;
          case 45: 
            { yybegin(AWAIT_NEW_LINE_ONCE); return dedentRoot(GdTypes.CLASS_NAME);
            } 
            // fall through
          case 91: break;
          case 46: 
            { return dedentRoot(GdTypes.BREAKPOINT);
            } 
            // fall through
          case 92: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
