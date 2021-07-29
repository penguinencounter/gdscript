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
    "\11\0\1\5\1\7\2\10\1\4\22\0\1\5\1\0\1\6\1\11\4\0\1\47\1\50\2\0\1\41\1\45\1"+
    "\3\1\0\12\2\1\42\1\43\1\0\1\44\1\46\1\0\1\12\22\13\1\36\7\13\4\0\1\1\1\0\1"+
    "\24\1\37\1\22\1\20\1\14\1\26\1\33\1\13\1\35\1\13\1\40\1\23\1\25\1\17\1\30"+
    "\1\34\1\13\1\32\1\21\1\16\1\27\1\31\1\13\1\15\2\13\1\0\1\13\10\0\1\10\242"+
    "\0\2\10\26\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\1\3\1\4\1\5\1\6\1\1"+
    "\1\7\1\10\14\2\1\11\1\12\1\13\1\14\1\1"+
    "\1\15\1\16\1\17\1\3\1\0\1\20\2\7\20\2"+
    "\1\21\12\2\1\22\3\2\1\23\3\2\1\24\1\25"+
    "\1\26\1\2\1\27\4\2\1\30\1\31\1\2\1\32"+
    "\6\2\1\33\1\34\2\2\1\35\1\2\1\36\2\2"+
    "\1\37\1\40\1\41\3\2\1\42\1\2\1\43";

  private static int [] zzUnpackAction() {
    int [] result = new int[108];
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
    "\0\0\0\51\0\122\0\173\0\244\0\315\0\122\0\366"+
    "\0\u011f\0\u0148\0\u0171\0\u019a\0\u01c3\0\u01ec\0\u0215\0\u023e"+
    "\0\u0267\0\u0290\0\u02b9\0\u02e2\0\u030b\0\u0334\0\u035d\0\122"+
    "\0\122\0\122\0\122\0\u0386\0\122\0\122\0\122\0\315"+
    "\0\u011f\0\u011f\0\u03af\0\122\0\u03d8\0\u0401\0\u042a\0\u0453"+
    "\0\u047c\0\u04a5\0\u04ce\0\u04f7\0\u0520\0\u0549\0\u0572\0\u059b"+
    "\0\u05c4\0\u05ed\0\u0616\0\u063f\0\122\0\u0668\0\u0691\0\u06ba"+
    "\0\u06e3\0\u070c\0\u0735\0\u075e\0\u0787\0\u07b0\0\u07d9\0\173"+
    "\0\u0802\0\u082b\0\u0854\0\173\0\u087d\0\u08a6\0\u08cf\0\173"+
    "\0\173\0\173\0\u08f8\0\173\0\u0921\0\u094a\0\u0973\0\u099c"+
    "\0\173\0\173\0\u09c5\0\173\0\u09ee\0\u0a17\0\u0a40\0\u0a69"+
    "\0\u0a92\0\u0abb\0\173\0\173\0\u0ae4\0\u0b0d\0\173\0\u0b36"+
    "\0\173\0\u0b5f\0\u0b88\0\173\0\173\0\173\0\u0bb1\0\u0bda"+
    "\0\u0c03\0\173\0\u0c2c\0\173";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[108];
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
    "\1\32\1\33\1\34\1\3\1\35\1\36\1\3\1\4"+
    "\1\5\1\6\1\37\1\10\1\11\1\37\1\3\1\12"+
    "\1\13\1\4\1\14\1\4\1\15\1\16\1\4\1\17"+
    "\1\20\3\4\1\21\2\4\1\22\1\23\1\4\1\24"+
    "\1\25\1\26\1\27\1\4\1\30\1\31\1\32\1\33"+
    "\1\34\1\3\1\35\1\36\52\0\2\4\10\0\26\4"+
    "\12\0\1\5\1\40\47\0\1\40\53\0\1\10\43\0"+
    "\4\41\1\0\1\41\1\42\2\0\40\41\4\12\1\43"+
    "\2\12\1\44\41\12\13\0\26\13\11\0\2\4\10\0"+
    "\2\4\1\45\23\4\11\0\2\4\10\0\15\4\1\46"+
    "\1\4\1\47\6\4\11\0\2\4\10\0\14\4\1\50"+
    "\11\4\11\0\2\4\10\0\1\4\1\51\24\4\11\0"+
    "\2\4\10\0\10\4\1\52\4\4\1\53\10\4\11\0"+
    "\2\4\10\0\11\4\1\54\2\4\1\55\11\4\11\0"+
    "\2\4\10\0\11\4\1\56\3\4\1\57\10\4\11\0"+
    "\2\4\10\0\1\4\1\60\24\4\11\0\2\4\10\0"+
    "\11\4\1\61\14\4\11\0\2\4\10\0\4\4\1\62"+
    "\21\4\11\0\2\4\10\0\3\4\1\63\22\4\11\0"+
    "\2\4\10\0\17\4\1\64\6\4\56\0\1\65\11\0"+
    "\1\44\42\0\2\4\10\0\3\4\1\66\22\4\11\0"+
    "\2\4\10\0\15\4\1\67\10\4\11\0\2\4\10\0"+
    "\14\4\1\70\11\4\11\0\2\4\10\0\10\4\1\71"+
    "\15\4\11\0\2\4\10\0\3\4\1\72\4\4\1\73"+
    "\15\4\11\0\2\4\10\0\11\4\1\74\14\4\11\0"+
    "\2\4\10\0\4\4\1\75\21\4\11\0\2\4\10\0"+
    "\10\4\1\76\15\4\11\0\2\4\10\0\4\4\1\77"+
    "\21\4\11\0\2\4\10\0\17\4\1\100\6\4\11\0"+
    "\2\4\10\0\22\4\1\101\3\4\11\0\2\4\10\0"+
    "\3\4\1\102\22\4\11\0\2\4\10\0\6\4\1\103"+
    "\17\4\11\0\2\4\10\0\3\4\1\104\22\4\11\0"+
    "\2\4\10\0\17\4\1\105\6\4\11\0\2\4\10\0"+
    "\1\4\1\106\24\4\11\0\2\4\10\0\1\4\1\107"+
    "\24\4\11\0\2\4\10\0\10\4\1\110\15\4\11\0"+
    "\2\4\10\0\1\4\1\111\24\4\11\0\2\4\10\0"+
    "\10\4\1\112\15\4\11\0\2\4\10\0\20\4\1\113"+
    "\5\4\11\0\2\4\10\0\13\4\1\114\12\4\11\0"+
    "\2\4\10\0\6\4\1\115\17\4\11\0\2\4\10\0"+
    "\3\4\1\116\2\4\1\117\17\4\11\0\2\4\10\0"+
    "\6\4\1\120\17\4\11\0\2\4\10\0\7\4\1\121"+
    "\16\4\11\0\2\4\10\0\5\4\1\122\20\4\11\0"+
    "\2\4\10\0\14\4\1\123\11\4\11\0\2\4\10\0"+
    "\6\4\1\124\17\4\11\0\2\4\10\0\22\4\1\125"+
    "\3\4\11\0\2\4\10\0\11\4\1\126\14\4\11\0"+
    "\2\4\10\0\4\4\1\127\21\4\11\0\2\4\10\0"+
    "\1\4\1\130\24\4\11\0\2\4\10\0\6\4\1\131"+
    "\17\4\11\0\2\4\10\0\22\4\1\132\3\4\11\0"+
    "\2\4\10\0\3\4\1\133\22\4\11\0\2\4\10\0"+
    "\1\4\1\134\24\4\11\0\2\4\10\0\17\4\1\135"+
    "\6\4\11\0\2\4\10\0\4\4\1\136\21\4\11\0"+
    "\2\4\10\0\25\4\1\137\11\0\2\4\10\0\5\4"+
    "\1\140\20\4\11\0\2\4\10\0\3\4\1\141\22\4"+
    "\11\0\1\142\1\4\10\0\26\4\11\0\2\4\10\0"+
    "\4\4\1\143\21\4\11\0\2\4\10\0\4\4\1\144"+
    "\21\4\11\0\2\4\10\0\20\4\1\145\5\4\11\0"+
    "\2\4\10\0\6\4\1\146\17\4\11\0\2\4\10\0"+
    "\4\4\1\147\21\4\11\0\2\4\10\0\14\4\1\150"+
    "\11\4\11\0\2\4\10\0\11\4\1\151\14\4\11\0"+
    "\2\4\10\0\1\4\1\152\24\4\11\0\2\4\10\0"+
    "\12\4\1\153\13\4\11\0\2\4\10\0\1\4\1\154"+
    "\24\4\10\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3157];
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
    "\2\0\1\11\3\1\1\11\20\1\4\11\1\1\3\11"+
    "\1\1\1\0\2\1\1\11\20\1\1\11\67\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[108];
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
          case 36: break;
          case 2: 
            { return dedentRoot(GdTypes.IDENTIFIER);
            } 
            // fall through
          case 37: break;
          case 3: 
            { return dedentRoot(GdTypes.NUMBER);
            } 
            // fall through
          case 38: break;
          case 4: 
            { return GdTypes.DOT;
            } 
            // fall through
          case 39: break;
          case 5: 
            { return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 40: break;
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
          case 41: break;
          case 7: 
            { return GdTypes.COMMENT;
            } 
            // fall through
          case 42: break;
          case 8: 
            { return GdTypes.ANNOTATOR;
            } 
            // fall through
          case 43: break;
          case 9: 
            { return dedentRoot(GdTypes.COMMA);
            } 
            // fall through
          case 44: break;
          case 10: 
            { return dedentRoot(GdTypes.COLON);
            } 
            // fall through
          case 45: break;
          case 11: 
            { yybegin(YYINITIAL); return dedentRoot(GdTypes.SEMICON);
            } 
            // fall through
          case 46: break;
          case 12: 
            { return dedentRoot(GdTypes.EQ);
            } 
            // fall through
          case 47: break;
          case 13: 
            { return dedentRoot(GdTypes.LRBR);
            } 
            // fall through
          case 48: break;
          case 14: 
            { return dedentRoot(GdTypes.RRBR);
            } 
            // fall through
          case 49: break;
          case 15: 
            { yybegin(YYINITIAL); return GdTypes.NEW_LINE;
            } 
            // fall through
          case 50: break;
          case 16: 
            { return dedentRoot(GdTypes.STRING);
            } 
            // fall through
          case 51: break;
          case 17: 
            { return GdTypes.RET;
            } 
            // fall through
          case 52: break;
          case 18: 
            { yybegin(AWAIT_NEW_LINE); return dedentRoot(GdTypes.VAR);
            } 
            // fall through
          case 53: break;
          case 19: 
            { return dedentRoot(GdTypes.INT);
            } 
            // fall through
          case 54: break;
          case 20: 
            { yybegin(AWAIT_NEW_LINE); return dedentRoot(GdTypes.TOOL);
            } 
            // fall through
          case 55: break;
          case 21: 
            { return dedentRoot(GdTypes.TRUE);
            } 
            // fall through
          case 56: break;
          case 22: 
            { return dedentRoot(GdTypes.NULL);
            } 
            // fall through
          case 57: break;
          case 23: 
            { return dedentRoot(GdTypes.SELF);
            } 
            // fall through
          case 58: break;
          case 24: 
            { yybegin(AWAIT_NEW_LINE); return dedentRoot(GdTypes.FUNC);
            } 
            // fall through
          case 59: break;
          case 25: 
            { return GdTypes.VOID;
            } 
            // fall through
          case 60: break;
          case 26: 
            { yybegin(AWAIT_NEW_LINE); return dedentRoot(GdTypes.PASS);
            } 
            // fall through
          case 61: break;
          case 27: 
            { yybegin(AWAIT_NEW_LINE); return dedentRoot(GdTypes.CONST);
            } 
            // fall through
          case 62: break;
          case 28: 
            { return dedentRoot(GdTypes.FALSE);
            } 
            // fall through
          case 63: break;
          case 29: 
            { return dedentRoot(GdTypes.BREAK);
            } 
            // fall through
          case 64: break;
          case 30: 
            { return GdTypes.SETGET;
            } 
            // fall through
          case 65: break;
          case 31: 
            { return dedentRoot(GdTypes.RETURN);
            } 
            // fall through
          case 66: break;
          case 32: 
            { return dedentRoot(GdTypes.STR);
            } 
            // fall through
          case 67: break;
          case 33: 
            { yybegin(AWAIT_NEW_LINE); return dedentRoot(GdTypes.EXTENDS);
            } 
            // fall through
          case 68: break;
          case 34: 
            { return dedentRoot(GdTypes.CONTINUE);
            } 
            // fall through
          case 69: break;
          case 35: 
            { yybegin(AWAIT_NEW_LINE); return dedentRoot(GdTypes.CLASS_NAME);
            } 
            // fall through
          case 70: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
