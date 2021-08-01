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
    "\11\0\1\5\1\7\2\10\1\4\22\0\1\5\1\0\1\6\1\11\4\0\1\56\1\57\2\0\1\50\1\54\1"+
    "\3\1\0\12\2\1\51\1\52\1\0\1\53\1\55\1\0\1\12\1\44\4\13\1\47\2\13\1\42\4\13"+
    "\1\46\1\13\1\41\2\13\1\36\1\43\1\45\5\13\4\0\1\1\1\0\1\24\1\37\1\22\1\20\1"+
    "\14\1\26\1\33\1\13\1\35\1\13\1\40\1\23\1\25\1\17\1\30\1\34\1\13\1\32\1\21"+
    "\1\16\1\27\1\31\1\13\1\15\2\13\1\0\1\13\10\0\1\10\242\0\2\10\26\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\1\3\1\4\1\5\1\6\1\1"+
    "\1\7\1\10\20\2\1\11\1\12\1\13\1\14\1\1"+
    "\1\15\1\16\1\17\1\3\1\0\1\20\2\7\20\2"+
    "\1\21\3\2\1\22\12\2\1\23\3\2\1\24\2\2"+
    "\1\25\1\26\1\27\1\2\1\30\1\31\1\32\1\2"+
    "\1\33\4\2\1\34\1\35\1\2\1\36\6\2\1\37"+
    "\1\40\2\2\1\41\1\2\1\42\2\2\1\43\1\44"+
    "\1\45\3\2\1\46\1\2\1\47";

  private static int [] zzUnpackAction() {
    int [] result = new int[119];
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
    "\0\0\0\60\0\140\0\220\0\300\0\360\0\140\0\u0120"+
    "\0\u0150\0\u0180\0\u01b0\0\u01e0\0\u0210\0\u0240\0\u0270\0\u02a0"+
    "\0\u02d0\0\u0300\0\u0330\0\u0360\0\u0390\0\u03c0\0\u03f0\0\u0420"+
    "\0\u0450\0\u0480\0\u04b0\0\140\0\140\0\140\0\140\0\u04e0"+
    "\0\140\0\140\0\140\0\360\0\u0150\0\u0150\0\u0510\0\140"+
    "\0\u0540\0\u0570\0\u05a0\0\u05d0\0\u0600\0\u0630\0\u0660\0\u0690"+
    "\0\u06c0\0\u06f0\0\u0720\0\u0750\0\u0780\0\u07b0\0\u07e0\0\u0810"+
    "\0\220\0\u0840\0\u0870\0\u08a0\0\140\0\u08d0\0\u0900\0\u0930"+
    "\0\u0960\0\u0990\0\u09c0\0\u09f0\0\u0a20\0\u0a50\0\u0a80\0\220"+
    "\0\u0ab0\0\u0ae0\0\u0b10\0\220\0\u0b40\0\u0b70\0\220\0\220"+
    "\0\220\0\u0ba0\0\220\0\220\0\220\0\u0bd0\0\220\0\u0c00"+
    "\0\u0c30\0\u0c60\0\u0c90\0\220\0\220\0\u0cc0\0\220\0\u0cf0"+
    "\0\u0d20\0\u0d50\0\u0d80\0\u0db0\0\u0de0\0\220\0\220\0\u0e10"+
    "\0\u0e40\0\220\0\u0e70\0\220\0\u0ea0\0\u0ed0\0\220\0\220"+
    "\0\220\0\u0f00\0\u0f30\0\u0f60\0\220\0\u0f90\0\220";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[119];
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
    "\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\7"+
    "\1\3\1\12\1\13\1\4\1\14\1\4\1\15\1\16"+
    "\1\4\1\17\1\20\3\4\1\21\2\4\1\22\1\23"+
    "\1\4\1\24\1\25\1\26\1\27\1\4\1\30\1\31"+
    "\1\32\2\4\1\33\1\4\1\34\1\35\1\36\1\37"+
    "\1\40\1\3\1\41\1\42\1\3\1\4\1\5\1\6"+
    "\1\43\1\10\1\11\1\43\1\3\1\12\1\13\1\4"+
    "\1\14\1\4\1\15\1\16\1\4\1\17\1\20\3\4"+
    "\1\21\2\4\1\22\1\23\1\4\1\24\1\25\1\26"+
    "\1\27\1\4\1\30\1\31\1\32\2\4\1\33\1\4"+
    "\1\34\1\35\1\36\1\37\1\40\1\3\1\41\1\42"+
    "\61\0\2\4\10\0\35\4\12\0\1\5\1\44\56\0"+
    "\1\44\62\0\1\10\52\0\4\45\1\0\1\45\1\46"+
    "\2\0\47\45\4\12\1\47\2\12\1\50\50\12\13\0"+
    "\35\13\11\0\2\4\10\0\2\4\1\51\32\4\11\0"+
    "\2\4\10\0\15\4\1\52\1\4\1\53\15\4\11\0"+
    "\2\4\10\0\14\4\1\54\20\4\11\0\2\4\10\0"+
    "\1\4\1\55\33\4\11\0\2\4\10\0\10\4\1\56"+
    "\4\4\1\57\17\4\11\0\2\4\10\0\11\4\1\60"+
    "\2\4\1\61\20\4\11\0\2\4\10\0\11\4\1\62"+
    "\3\4\1\63\17\4\11\0\2\4\10\0\1\4\1\64"+
    "\33\4\11\0\2\4\10\0\11\4\1\65\23\4\11\0"+
    "\2\4\10\0\4\4\1\66\30\4\11\0\2\4\10\0"+
    "\3\4\1\67\31\4\11\0\2\4\10\0\17\4\1\70"+
    "\15\4\11\0\2\4\10\0\27\4\1\71\5\4\11\0"+
    "\2\4\10\0\33\4\1\72\1\4\11\0\2\4\10\0"+
    "\31\4\1\73\3\4\11\0\2\4\10\0\31\4\1\74"+
    "\3\4\65\0\1\75\11\0\1\50\51\0\2\4\10\0"+
    "\3\4\1\76\31\4\11\0\2\4\10\0\15\4\1\77"+
    "\17\4\11\0\2\4\10\0\14\4\1\100\20\4\11\0"+
    "\2\4\10\0\10\4\1\101\24\4\11\0\2\4\10\0"+
    "\3\4\1\102\4\4\1\103\24\4\11\0\2\4\10\0"+
    "\11\4\1\104\23\4\11\0\2\4\10\0\4\4\1\105"+
    "\30\4\11\0\2\4\10\0\10\4\1\106\24\4\11\0"+
    "\2\4\10\0\4\4\1\107\30\4\11\0\2\4\10\0"+
    "\17\4\1\110\15\4\11\0\2\4\10\0\22\4\1\111"+
    "\12\4\11\0\2\4\10\0\3\4\1\112\31\4\11\0"+
    "\2\4\10\0\6\4\1\113\26\4\11\0\2\4\10\0"+
    "\3\4\1\114\31\4\11\0\2\4\10\0\17\4\1\115"+
    "\15\4\11\0\2\4\10\0\1\4\1\116\33\4\11\0"+
    "\2\4\10\0\34\4\1\117\11\0\2\4\10\0\32\4"+
    "\1\120\2\4\11\0\2\4\10\0\33\4\1\121\1\4"+
    "\11\0\2\4\10\0\1\4\1\122\33\4\11\0\2\4"+
    "\10\0\10\4\1\123\24\4\11\0\2\4\10\0\1\4"+
    "\1\124\33\4\11\0\2\4\10\0\10\4\1\125\24\4"+
    "\11\0\2\4\10\0\20\4\1\126\14\4\11\0\2\4"+
    "\10\0\13\4\1\127\21\4\11\0\2\4\10\0\6\4"+
    "\1\130\26\4\11\0\2\4\10\0\3\4\1\131\2\4"+
    "\1\132\26\4\11\0\2\4\10\0\6\4\1\133\26\4"+
    "\11\0\2\4\10\0\7\4\1\134\25\4\11\0\2\4"+
    "\10\0\5\4\1\135\27\4\11\0\2\4\10\0\14\4"+
    "\1\136\20\4\11\0\2\4\10\0\6\4\1\137\26\4"+
    "\11\0\2\4\10\0\22\4\1\140\12\4\11\0\2\4"+
    "\10\0\11\4\1\141\23\4\11\0\2\4\10\0\4\4"+
    "\1\142\30\4\11\0\2\4\10\0\1\4\1\143\33\4"+
    "\11\0\2\4\10\0\6\4\1\144\26\4\11\0\2\4"+
    "\10\0\22\4\1\145\12\4\11\0\2\4\10\0\3\4"+
    "\1\146\31\4\11\0\2\4\10\0\1\4\1\147\33\4"+
    "\11\0\2\4\10\0\17\4\1\150\15\4\11\0\2\4"+
    "\10\0\4\4\1\151\30\4\11\0\2\4\10\0\25\4"+
    "\1\152\7\4\11\0\2\4\10\0\5\4\1\153\27\4"+
    "\11\0\2\4\10\0\3\4\1\154\31\4\11\0\1\155"+
    "\1\4\10\0\35\4\11\0\2\4\10\0\4\4\1\156"+
    "\30\4\11\0\2\4\10\0\4\4\1\157\30\4\11\0"+
    "\2\4\10\0\20\4\1\160\14\4\11\0\2\4\10\0"+
    "\6\4\1\161\26\4\11\0\2\4\10\0\4\4\1\162"+
    "\30\4\11\0\2\4\10\0\14\4\1\163\20\4\11\0"+
    "\2\4\10\0\11\4\1\164\23\4\11\0\2\4\10\0"+
    "\1\4\1\165\33\4\11\0\2\4\10\0\12\4\1\166"+
    "\22\4\11\0\2\4\10\0\1\4\1\167\33\4\10\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4032];
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
    "\2\0\1\11\3\1\1\11\24\1\4\11\1\1\3\11"+
    "\1\1\1\0\2\1\1\11\24\1\1\11\72\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[119];
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
    int indent = 0;
    Stack<Integer> indentSizes = new Stack<>();
    int yycolumn;

    public IElementType dedentRoot(IElementType type) {
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
          case 40: break;
          case 2: 
            { return dedentRoot(GdTypes.IDENTIFIER);
            } 
            // fall through
          case 41: break;
          case 3: 
            { return dedentRoot(GdTypes.NUMBER);
            } 
            // fall through
          case 42: break;
          case 4: 
            { return GdTypes.DOT;
            } 
            // fall through
          case 43: break;
          case 5: 
            { return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 44: break;
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
          case 45: break;
          case 7: 
            { return GdTypes.COMMENT;
            } 
            // fall through
          case 46: break;
          case 8: 
            { return GdTypes.ANNOTATOR;
            } 
            // fall through
          case 47: break;
          case 9: 
            { return dedentRoot(GdTypes.COMMA);
            } 
            // fall through
          case 48: break;
          case 10: 
            { return dedentRoot(GdTypes.COLON);
            } 
            // fall through
          case 49: break;
          case 11: 
            { yybegin(YYINITIAL); return dedentRoot(GdTypes.SEMICON);
            } 
            // fall through
          case 50: break;
          case 12: 
            { return dedentRoot(GdTypes.EQ);
            } 
            // fall through
          case 51: break;
          case 13: 
            { return dedentRoot(GdTypes.LRBR);
            } 
            // fall through
          case 52: break;
          case 14: 
            { return dedentRoot(GdTypes.RRBR);
            } 
            // fall through
          case 53: break;
          case 15: 
            { yybegin(YYINITIAL); return GdTypes.NEW_LINE;
            } 
            // fall through
          case 54: break;
          case 16: 
            { return dedentRoot(GdTypes.STRING);
            } 
            // fall through
          case 55: break;
          case 17: 
            { return dedentRoot(GdTypes.PI);
            } 
            // fall through
          case 56: break;
          case 18: 
            { return GdTypes.RET;
            } 
            // fall through
          case 57: break;
          case 19: 
            { yybegin(AWAIT_NEW_LINE); return dedentRoot(GdTypes.VAR);
            } 
            // fall through
          case 58: break;
          case 20: 
            { return dedentRoot(GdTypes.INT);
            } 
            // fall through
          case 59: break;
          case 21: 
            { return dedentRoot(GdTypes.INF);
            } 
            // fall through
          case 60: break;
          case 22: 
            { return dedentRoot(GdTypes.TAU);
            } 
            // fall through
          case 61: break;
          case 23: 
            { return dedentRoot(GdTypes.NAN);
            } 
            // fall through
          case 62: break;
          case 24: 
            { yybegin(AWAIT_NEW_LINE); return dedentRoot(GdTypes.TOOL);
            } 
            // fall through
          case 63: break;
          case 25: 
            { return dedentRoot(GdTypes.TRUE);
            } 
            // fall through
          case 64: break;
          case 26: 
            { return dedentRoot(GdTypes.NULL);
            } 
            // fall through
          case 65: break;
          case 27: 
            { return dedentRoot(GdTypes.SELF);
            } 
            // fall through
          case 66: break;
          case 28: 
            { yybegin(AWAIT_NEW_LINE); return dedentRoot(GdTypes.FUNC);
            } 
            // fall through
          case 67: break;
          case 29: 
            { return GdTypes.VOID;
            } 
            // fall through
          case 68: break;
          case 30: 
            { yybegin(AWAIT_NEW_LINE); return dedentRoot(GdTypes.PASS);
            } 
            // fall through
          case 69: break;
          case 31: 
            { yybegin(AWAIT_NEW_LINE); return dedentRoot(GdTypes.CONST);
            } 
            // fall through
          case 70: break;
          case 32: 
            { return dedentRoot(GdTypes.FALSE);
            } 
            // fall through
          case 71: break;
          case 33: 
            { return dedentRoot(GdTypes.BREAK);
            } 
            // fall through
          case 72: break;
          case 34: 
            { return GdTypes.SETGET;
            } 
            // fall through
          case 73: break;
          case 35: 
            { return dedentRoot(GdTypes.RETURN);
            } 
            // fall through
          case 74: break;
          case 36: 
            { return dedentRoot(GdTypes.STR);
            } 
            // fall through
          case 75: break;
          case 37: 
            { yybegin(AWAIT_NEW_LINE); return dedentRoot(GdTypes.EXTENDS);
            } 
            // fall through
          case 76: break;
          case 38: 
            { return dedentRoot(GdTypes.CONTINUE);
            } 
            // fall through
          case 77: break;
          case 39: 
            { yybegin(AWAIT_NEW_LINE); return dedentRoot(GdTypes.CLASS_NAME);
            } 
            // fall through
          case 78: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
