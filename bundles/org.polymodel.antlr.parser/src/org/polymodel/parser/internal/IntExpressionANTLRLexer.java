// $ANTLR 3.3 Nov 30, 2010 12:50:56 /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g 2011-07-19 22:42:41

package org.polymodel.parser.internal;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

public class IntExpressionANTLRLexer extends Lexer {
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
    public static final int INT=4;
    public static final int ID=5;
    public static final int NEWLINE=6;
    public static final int WS=7;

    // delegates
    // delegators

    public IntExpressionANTLRLexer() {;} 
    public IntExpressionANTLRLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public IntExpressionANTLRLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g"; }

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:13:6: ( '<=' )
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:13:8: '<='
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
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:14:6: ( '<' )
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:14:8: '<'
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
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:15:7: ( '=' )
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:15:9: '='
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
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:16:7: ( '>=' )
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:16:9: '>='
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
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:17:7: ( '>' )
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:17:9: '>'
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
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:18:7: ( '&' )
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:18:9: '&'
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
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:19:7: ( 'and' )
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:19:9: 'and'
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
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:20:7: ( '|' )
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:20:9: '|'
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
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:21:7: ( 'or' )
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:21:9: 'or'
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
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:22:7: ( '+' )
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:22:9: '+'
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
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:23:7: ( '-' )
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:23:9: '-'
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
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:24:7: ( '/' )
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:24:9: '/'
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
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:25:7: ( '%' )
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:25:9: '%'
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
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:26:7: ( '(' )
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:26:9: '('
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
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:27:7: ( ')' )
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:27:9: ')'
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

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:217:5: ( ( 'a' .. 'z' | 'A' .. 'Z' )+ )
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:217:9: ( 'a' .. 'z' | 'A' .. 'Z' )+
            {
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:217:9: ( 'a' .. 'z' | 'A' .. 'Z' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='A' && LA1_0<='Z')||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:
            	    {
            	    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:218:5: ( ( '0' .. '9' )+ )
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:218:9: ( '0' .. '9' )+
            {
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:218:9: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:218:9: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:219:8: ( ( '\\r' )? '\\n' )
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:219:9: ( '\\r' )? '\\n'
            {
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:219:9: ( '\\r' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\r') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:219:9: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:220:5: ( ( ' ' | '\\t' )+ )
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:220:9: ( ' ' | '\\t' )+
            {
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:220:9: ( ' ' | '\\t' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\t'||LA4_0==' ') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:1:8: ( T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | ID | INT | NEWLINE | WS )
        int alt5=19;
        alt5 = dfa5.predict(input);
        switch (alt5) {
            case 1 :
                // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:1:10: T__8
                {
                mT__8(); 

                }
                break;
            case 2 :
                // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:1:15: T__9
                {
                mT__9(); 

                }
                break;
            case 3 :
                // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:1:20: T__10
                {
                mT__10(); 

                }
                break;
            case 4 :
                // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:1:26: T__11
                {
                mT__11(); 

                }
                break;
            case 5 :
                // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:1:32: T__12
                {
                mT__12(); 

                }
                break;
            case 6 :
                // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:1:38: T__13
                {
                mT__13(); 

                }
                break;
            case 7 :
                // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:1:44: T__14
                {
                mT__14(); 

                }
                break;
            case 8 :
                // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:1:50: T__15
                {
                mT__15(); 

                }
                break;
            case 9 :
                // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:1:56: T__16
                {
                mT__16(); 

                }
                break;
            case 10 :
                // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:1:62: T__17
                {
                mT__17(); 

                }
                break;
            case 11 :
                // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:1:68: T__18
                {
                mT__18(); 

                }
                break;
            case 12 :
                // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:1:74: T__19
                {
                mT__19(); 

                }
                break;
            case 13 :
                // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:1:80: T__20
                {
                mT__20(); 

                }
                break;
            case 14 :
                // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:1:86: T__21
                {
                mT__21(); 

                }
                break;
            case 15 :
                // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:1:92: T__22
                {
                mT__22(); 

                }
                break;
            case 16 :
                // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:1:98: ID
                {
                mID(); 

                }
                break;
            case 17 :
                // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:1:101: INT
                {
                mINT(); 

                }
                break;
            case 18 :
                // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:1:105: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 19 :
                // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/IntExpressionANTLR.g:1:113: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\1\uffff\1\23\1\uffff\1\25\1\uffff\1\16\1\uffff\1\16\16\uffff\1"+
        "\16\1\31\1\32\2\uffff";
    static final String DFA5_eofS =
        "\33\uffff";
    static final String DFA5_minS =
        "\1\11\1\75\1\uffff\1\75\1\uffff\1\156\1\uffff\1\162\16\uffff\1\144"+
        "\2\101\2\uffff";
    static final String DFA5_maxS =
        "\1\174\1\75\1\uffff\1\75\1\uffff\1\156\1\uffff\1\162\16\uffff\1"+
        "\144\2\172\2\uffff";
    static final String DFA5_acceptS =
        "\2\uffff\1\3\1\uffff\1\6\1\uffff\1\10\1\uffff\1\12\1\13\1\14\1\15"+
        "\1\16\1\17\1\20\1\21\1\22\1\23\1\1\1\2\1\4\1\5\3\uffff\1\11\1\7";
    static final String DFA5_specialS =
        "\33\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\21\1\20\2\uffff\1\20\22\uffff\1\21\4\uffff\1\13\1\4\1\uffff"+
            "\1\14\1\15\1\uffff\1\10\1\uffff\1\11\1\uffff\1\12\12\17\2\uffff"+
            "\1\1\1\2\1\3\2\uffff\32\16\6\uffff\1\5\15\16\1\7\13\16\1\uffff"+
            "\1\6",
            "\1\22",
            "",
            "\1\24",
            "",
            "\1\26",
            "",
            "\1\27",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\30",
            "\32\16\6\uffff\32\16",
            "\32\16\6\uffff\32\16",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | ID | INT | NEWLINE | WS );";
        }
    }
 

}