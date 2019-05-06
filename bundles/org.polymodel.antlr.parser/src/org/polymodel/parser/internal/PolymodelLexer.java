// $ANTLR 3.3 Nov 30, 2010 12:50:56 Polymodel__.g 2011-07-20 16:31:07

package org.polymodel.parser.internal;


import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

public class PolymodelLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int WS=4;
    public static final int ID=5;
    public static final int INT=6;
    public static final int NEWLINE=7;
    public static final int Tokens=31;

    // delegates
    public Polymodel_Lexer gLexer;
    // delegators

    public PolymodelLexer() {;} 
    public PolymodelLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public PolymodelLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
        gLexer = new Polymodel_Lexer(input, state, this);
    }
    public String getGrammarFileName() { return "Polymodel__.g"; }

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Polymodel__.g:11:6: ( '<=' )
            // Polymodel__.g:11:8: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__8"

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Polymodel__.g:12:6: ( '<' )
            // Polymodel__.g:12:8: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Polymodel__.g:13:7: ( '=' )
            // Polymodel__.g:13:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Polymodel__.g:14:7: ( '>=' )
            // Polymodel__.g:14:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Polymodel__.g:15:7: ( '>' )
            // Polymodel__.g:15:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Polymodel__.g:16:7: ( '&' )
            // Polymodel__.g:16:9: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Polymodel__.g:17:7: ( 'and' )
            // Polymodel__.g:17:9: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Polymodel__.g:18:7: ( '|' )
            // Polymodel__.g:18:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Polymodel__.g:19:7: ( 'or' )
            // Polymodel__.g:19:9: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Polymodel__.g:20:7: ( '+' )
            // Polymodel__.g:20:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Polymodel__.g:21:7: ( '-' )
            // Polymodel__.g:21:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Polymodel__.g:22:7: ( '/' )
            // Polymodel__.g:22:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Polymodel__.g:23:7: ( '%' )
            // Polymodel__.g:23:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Polymodel__.g:24:7: ( '(' )
            // Polymodel__.g:24:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Polymodel__.g:25:7: ( ')' )
            // Polymodel__.g:25:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Polymodel__.g:26:7: ( '{' )
            // Polymodel__.g:26:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Polymodel__.g:27:7: ( '[' )
            // Polymodel__.g:27:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Polymodel__.g:28:7: ( ']' )
            // Polymodel__.g:28:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Polymodel__.g:29:7: ( ':' )
            // Polymodel__.g:29:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Polymodel__.g:30:7: ( '}' )
            // Polymodel__.g:30:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Polymodel__.g:31:7: ( 'exists' )
            // Polymodel__.g:31:9: 'exists'
            {
            match("exists"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Polymodel__.g:32:7: ( ',' )
            // Polymodel__.g:32:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Polymodel__.g:33:7: ( '->' )
            // Polymodel__.g:33:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    public void mTokens() throws RecognitionException {
        // Polymodel__.g:1:8: ( T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | Lexer. Tokens )
        int alt1=24;
        alt1 = dfa1.predict(input);
        switch (alt1) {
            case 1 :
                // Polymodel__.g:1:10: T__8
                {
                mT__8(); 

                }
                break;
            case 2 :
                // Polymodel__.g:1:15: T__9
                {
                mT__9(); 

                }
                break;
            case 3 :
                // Polymodel__.g:1:20: T__10
                {
                mT__10(); 

                }
                break;
            case 4 :
                // Polymodel__.g:1:26: T__11
                {
                mT__11(); 

                }
                break;
            case 5 :
                // Polymodel__.g:1:32: T__12
                {
                mT__12(); 

                }
                break;
            case 6 :
                // Polymodel__.g:1:38: T__13
                {
                mT__13(); 

                }
                break;
            case 7 :
                // Polymodel__.g:1:44: T__14
                {
                mT__14(); 

                }
                break;
            case 8 :
                // Polymodel__.g:1:50: T__15
                {
                mT__15(); 

                }
                break;
            case 9 :
                // Polymodel__.g:1:56: T__16
                {
                mT__16(); 

                }
                break;
            case 10 :
                // Polymodel__.g:1:62: T__17
                {
                mT__17(); 

                }
                break;
            case 11 :
                // Polymodel__.g:1:68: T__18
                {
                mT__18(); 

                }
                break;
            case 12 :
                // Polymodel__.g:1:74: T__19
                {
                mT__19(); 

                }
                break;
            case 13 :
                // Polymodel__.g:1:80: T__20
                {
                mT__20(); 

                }
                break;
            case 14 :
                // Polymodel__.g:1:86: T__21
                {
                mT__21(); 

                }
                break;
            case 15 :
                // Polymodel__.g:1:92: T__22
                {
                mT__22(); 

                }
                break;
            case 16 :
                // Polymodel__.g:1:98: T__23
                {
                mT__23(); 

                }
                break;
            case 17 :
                // Polymodel__.g:1:104: T__24
                {
                mT__24(); 

                }
                break;
            case 18 :
                // Polymodel__.g:1:110: T__25
                {
                mT__25(); 

                }
                break;
            case 19 :
                // Polymodel__.g:1:116: T__26
                {
                mT__26(); 

                }
                break;
            case 20 :
                // Polymodel__.g:1:122: T__27
                {
                mT__27(); 

                }
                break;
            case 21 :
                // Polymodel__.g:1:128: T__28
                {
                mT__28(); 

                }
                break;
            case 22 :
                // Polymodel__.g:1:134: T__29
                {
                mT__29(); 

                }
                break;
            case 23 :
                // Polymodel__.g:1:140: T__30
                {
                mT__30(); 

                }
                break;
            case 24 :
                // Polymodel__.g:1:146: Lexer. Tokens
                {
                gLexer.mTokens(); 

                }
                break;

        }

    }


    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS =
        "\1\uffff\1\27\1\uffff\1\31\1\uffff\1\25\1\uffff\1\25\1\uffff\1\35"+
        "\11\uffff\1\25\6\uffff\1\25\1\40\2\uffff\1\25\1\42\1\uffff\1\25"+
        "\1\uffff\2\25\1\46\1\uffff";
    static final String DFA1_eofS =
        "\47\uffff";
    static final String DFA1_minS =
        "\1\11\1\75\1\uffff\1\75\1\uffff\1\156\1\uffff\1\162\1\uffff\1\76"+
        "\11\uffff\1\170\6\uffff\1\144\1\60\2\uffff\1\151\1\60\1\uffff\1"+
        "\163\1\uffff\1\164\1\163\1\60\1\uffff";
    static final String DFA1_maxS =
        "\1\175\1\75\1\uffff\1\75\1\uffff\1\156\1\uffff\1\162\1\uffff\1\76"+
        "\11\uffff\1\170\6\uffff\1\144\1\172\2\uffff\1\151\1\172\1\uffff"+
        "\1\163\1\uffff\1\164\1\163\1\172\1\uffff";
    static final String DFA1_acceptS =
        "\2\uffff\1\3\1\uffff\1\6\1\uffff\1\10\1\uffff\1\12\1\uffff\1\14"+
        "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\uffff\1\26\1\30\1\1\1"+
        "\2\1\4\1\5\2\uffff\1\27\1\13\2\uffff\1\11\1\uffff\1\7\3\uffff\1"+
        "\25";
    static final String DFA1_specialS =
        "\47\uffff}>";
    static final String[] DFA1_transitionS = {
            "\2\25\2\uffff\1\25\22\uffff\1\25\4\uffff\1\13\1\4\1\uffff\1"+
            "\14\1\15\1\uffff\1\10\1\24\1\11\1\uffff\1\12\12\25\1\21\1\uffff"+
            "\1\1\1\2\1\3\2\uffff\32\25\1\17\1\uffff\1\20\1\uffff\1\25\1"+
            "\uffff\1\5\3\25\1\23\11\25\1\7\13\25\1\16\1\6\1\22",
            "\1\26",
            "",
            "\1\30",
            "",
            "\1\32",
            "",
            "\1\33",
            "",
            "\1\34",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\36",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\37",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "",
            "\1\41",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "\1\43",
            "",
            "\1\44",
            "\1\45",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | Lexer. Tokens );";
        }
    }
 

}