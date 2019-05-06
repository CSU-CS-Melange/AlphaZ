package edu.csu.melange.alphabets.xtext.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import edu.csu.melange.alphabets.xtext.services.AlphabetsGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalAlphabetsParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_UNION", "RULE_INTERSECTION", "RULE_OP_PLUS", "RULE_OP_MINUS", "RULE_INT", "RULE_OP_OR", "RULE_XOP_OR", "RULE_OP_AND", "RULE_OP_NAND", "RULE_OP_MUL", "RULE_OP_DIV", "RULE_OP_MIN", "RULE_OP_MAX", "RULE_BOOLEAN", "RULE_REAL", "RULE_OP_EQ", "RULE_OP_GE", "RULE_OP_GT", "RULE_OP_LE", "RULE_OP_LT", "RULE_OP_NE", "RULE_OP_MOD", "RULE_SL_COMMENT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "','", "')'", "';'", "'affine'", "'given'", "'returns'", "'using'", "'through'", "'.'", "'{'", "'|'", "'}'", "'['", "']'", "'='", "'not'", "'case'", "'esac'", "'@'", "'if'", "'then'", "'else'", "'val('", "'->'", "'reduce'", "':'", "'unsigned'", "'int'", "'longlong'", "'long'", "'short'", "'bool'", "'float'", "'double'", "'char'"
    };
    public static final int RULE_BOOLEAN=18;
    public static final int T__66=66;
    public static final int RULE_ID=4;
    public static final int T__67=67;
    public static final int RULE_OP_OR=10;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int RULE_ANY_OTHER=31;
    public static final int RULE_OP_GE=21;
    public static final int T__61=61;
    public static final int EOF=-1;
    public static final int T__60=60;
    public static final int RULE_OP_PLUS=7;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_OP_NE=25;
    public static final int RULE_OP_EQ=20;
    public static final int T__59=59;
    public static final int RULE_OP_AND=12;
    public static final int RULE_INT=9;
    public static final int RULE_REAL=19;
    public static final int T__50=50;
    public static final int RULE_OP_MOD=26;
    public static final int RULE_XOP_OR=11;
    public static final int RULE_OP_MINUS=8;
    public static final int RULE_OP_MAX=17;
    public static final int RULE_OP_DIV=15;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_UNION=5;
    public static final int T__48=48;
    public static final int RULE_OP_NAND=13;
    public static final int T__49=49;
    public static final int RULE_INTERSECTION=6;
    public static final int RULE_SL_COMMENT=27;
    public static final int RULE_OP_LT=24;
    public static final int RULE_OP_MIN=16;
    public static final int RULE_ML_COMMENT=29;
    public static final int RULE_STRING=28;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int RULE_OP_LE=23;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=30;
    public static final int RULE_OP_GT=22;
    public static final int RULE_OP_MUL=14;

    // delegates
    // delegators


        public InternalAlphabetsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalAlphabetsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalAlphabetsParser.tokenNames; }
    public String getGrammarFileName() { return "../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g"; }



     	private AlphabetsGrammarAccess grammarAccess;
     	
        public InternalAlphabetsParser(TokenStream input, AlphabetsGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "AProgram";	
       	}
       	
       	@Override
       	protected AlphabetsGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleAProgram"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:67:1: entryRuleAProgram returns [EObject current=null] : iv_ruleAProgram= ruleAProgram EOF ;
    public final EObject entryRuleAProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAProgram = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:68:2: (iv_ruleAProgram= ruleAProgram EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:69:2: iv_ruleAProgram= ruleAProgram EOF
            {
             newCompositeNode(grammarAccess.getAProgramRule()); 
            pushFollow(FOLLOW_ruleAProgram_in_entryRuleAProgram75);
            iv_ruleAProgram=ruleAProgram();

            state._fsp--;

             current =iv_ruleAProgram; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAProgram85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAProgram"


    // $ANTLR start "ruleAProgram"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:76:1: ruleAProgram returns [EObject current=null] : ( ( (lv_externalFunctions_0_0= ruleAExternalFunctionDeclaration ) )* ( (lv_systems_1_0= ruleAAffineSystem ) )+ ) ;
    public final EObject ruleAProgram() throws RecognitionException {
        EObject current = null;

        EObject lv_externalFunctions_0_0 = null;

        EObject lv_systems_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:79:28: ( ( ( (lv_externalFunctions_0_0= ruleAExternalFunctionDeclaration ) )* ( (lv_systems_1_0= ruleAAffineSystem ) )+ ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:80:1: ( ( (lv_externalFunctions_0_0= ruleAExternalFunctionDeclaration ) )* ( (lv_systems_1_0= ruleAAffineSystem ) )+ )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:80:1: ( ( (lv_externalFunctions_0_0= ruleAExternalFunctionDeclaration ) )* ( (lv_systems_1_0= ruleAAffineSystem ) )+ )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:80:2: ( (lv_externalFunctions_0_0= ruleAExternalFunctionDeclaration ) )* ( (lv_systems_1_0= ruleAAffineSystem ) )+
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:80:2: ( (lv_externalFunctions_0_0= ruleAExternalFunctionDeclaration ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=59 && LA1_0<=67)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:81:1: (lv_externalFunctions_0_0= ruleAExternalFunctionDeclaration )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:81:1: (lv_externalFunctions_0_0= ruleAExternalFunctionDeclaration )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:82:3: lv_externalFunctions_0_0= ruleAExternalFunctionDeclaration
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAProgramAccess().getExternalFunctionsAExternalFunctionDeclarationParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAExternalFunctionDeclaration_in_ruleAProgram131);
            	    lv_externalFunctions_0_0=ruleAExternalFunctionDeclaration();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAProgramRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"externalFunctions",
            	            		lv_externalFunctions_0_0, 
            	            		"AExternalFunctionDeclaration");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:98:3: ( (lv_systems_1_0= ruleAAffineSystem ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==36) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:99:1: (lv_systems_1_0= ruleAAffineSystem )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:99:1: (lv_systems_1_0= ruleAAffineSystem )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:100:3: lv_systems_1_0= ruleAAffineSystem
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAProgramAccess().getSystemsAAffineSystemParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAAffineSystem_in_ruleAProgram153);
            	    lv_systems_1_0=ruleAAffineSystem();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAProgramRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"systems",
            	            		lv_systems_1_0, 
            	            		"AAffineSystem");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


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


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAProgram"


    // $ANTLR start "entryRuleAExternalFunctionDeclaration"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:124:1: entryRuleAExternalFunctionDeclaration returns [EObject current=null] : iv_ruleAExternalFunctionDeclaration= ruleAExternalFunctionDeclaration EOF ;
    public final EObject entryRuleAExternalFunctionDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAExternalFunctionDeclaration = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:125:2: (iv_ruleAExternalFunctionDeclaration= ruleAExternalFunctionDeclaration EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:126:2: iv_ruleAExternalFunctionDeclaration= ruleAExternalFunctionDeclaration EOF
            {
             newCompositeNode(grammarAccess.getAExternalFunctionDeclarationRule()); 
            pushFollow(FOLLOW_ruleAExternalFunctionDeclaration_in_entryRuleAExternalFunctionDeclaration190);
            iv_ruleAExternalFunctionDeclaration=ruleAExternalFunctionDeclaration();

            state._fsp--;

             current =iv_ruleAExternalFunctionDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAExternalFunctionDeclaration200); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAExternalFunctionDeclaration"


    // $ANTLR start "ruleAExternalFunctionDeclaration"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:133:1: ruleAExternalFunctionDeclaration returns [EObject current=null] : ( ( (lv_output_0_0= ruleAType ) ) ( (lv_name_1_0= ruleAExternalFunctionIdentifier ) ) otherlv_2= '(' ( (lv_inputs_3_0= ruleAType ) )? (otherlv_4= ',' ( (lv_inputs_5_0= ruleAType ) ) )* otherlv_6= ')' otherlv_7= ';' ) ;
    public final EObject ruleAExternalFunctionDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_output_0_0 = null;

        EObject lv_name_1_0 = null;

        EObject lv_inputs_3_0 = null;

        EObject lv_inputs_5_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:136:28: ( ( ( (lv_output_0_0= ruleAType ) ) ( (lv_name_1_0= ruleAExternalFunctionIdentifier ) ) otherlv_2= '(' ( (lv_inputs_3_0= ruleAType ) )? (otherlv_4= ',' ( (lv_inputs_5_0= ruleAType ) ) )* otherlv_6= ')' otherlv_7= ';' ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:137:1: ( ( (lv_output_0_0= ruleAType ) ) ( (lv_name_1_0= ruleAExternalFunctionIdentifier ) ) otherlv_2= '(' ( (lv_inputs_3_0= ruleAType ) )? (otherlv_4= ',' ( (lv_inputs_5_0= ruleAType ) ) )* otherlv_6= ')' otherlv_7= ';' )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:137:1: ( ( (lv_output_0_0= ruleAType ) ) ( (lv_name_1_0= ruleAExternalFunctionIdentifier ) ) otherlv_2= '(' ( (lv_inputs_3_0= ruleAType ) )? (otherlv_4= ',' ( (lv_inputs_5_0= ruleAType ) ) )* otherlv_6= ')' otherlv_7= ';' )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:137:2: ( (lv_output_0_0= ruleAType ) ) ( (lv_name_1_0= ruleAExternalFunctionIdentifier ) ) otherlv_2= '(' ( (lv_inputs_3_0= ruleAType ) )? (otherlv_4= ',' ( (lv_inputs_5_0= ruleAType ) ) )* otherlv_6= ')' otherlv_7= ';'
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:137:2: ( (lv_output_0_0= ruleAType ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:138:1: (lv_output_0_0= ruleAType )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:138:1: (lv_output_0_0= ruleAType )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:139:3: lv_output_0_0= ruleAType
            {
             
            	        newCompositeNode(grammarAccess.getAExternalFunctionDeclarationAccess().getOutputATypeParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleAType_in_ruleAExternalFunctionDeclaration246);
            lv_output_0_0=ruleAType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAExternalFunctionDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"output",
                    		lv_output_0_0, 
                    		"AType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:155:2: ( (lv_name_1_0= ruleAExternalFunctionIdentifier ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:156:1: (lv_name_1_0= ruleAExternalFunctionIdentifier )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:156:1: (lv_name_1_0= ruleAExternalFunctionIdentifier )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:157:3: lv_name_1_0= ruleAExternalFunctionIdentifier
            {
             
            	        newCompositeNode(grammarAccess.getAExternalFunctionDeclarationAccess().getNameAExternalFunctionIdentifierParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleAExternalFunctionIdentifier_in_ruleAExternalFunctionDeclaration267);
            lv_name_1_0=ruleAExternalFunctionIdentifier();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAExternalFunctionDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"AExternalFunctionIdentifier");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,32,FOLLOW_32_in_ruleAExternalFunctionDeclaration279); 

                	newLeafNode(otherlv_2, grammarAccess.getAExternalFunctionDeclarationAccess().getLeftParenthesisKeyword_2());
                
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:177:1: ( (lv_inputs_3_0= ruleAType ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=59 && LA3_0<=67)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:178:1: (lv_inputs_3_0= ruleAType )
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:178:1: (lv_inputs_3_0= ruleAType )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:179:3: lv_inputs_3_0= ruleAType
                    {
                     
                    	        newCompositeNode(grammarAccess.getAExternalFunctionDeclarationAccess().getInputsATypeParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAType_in_ruleAExternalFunctionDeclaration300);
                    lv_inputs_3_0=ruleAType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAExternalFunctionDeclarationRule());
                    	        }
                           		add(
                           			current, 
                           			"inputs",
                            		lv_inputs_3_0, 
                            		"AType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:195:3: (otherlv_4= ',' ( (lv_inputs_5_0= ruleAType ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==33) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:195:5: otherlv_4= ',' ( (lv_inputs_5_0= ruleAType ) )
            	    {
            	    otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleAExternalFunctionDeclaration314); 

            	        	newLeafNode(otherlv_4, grammarAccess.getAExternalFunctionDeclarationAccess().getCommaKeyword_4_0());
            	        
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:199:1: ( (lv_inputs_5_0= ruleAType ) )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:200:1: (lv_inputs_5_0= ruleAType )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:200:1: (lv_inputs_5_0= ruleAType )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:201:3: lv_inputs_5_0= ruleAType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAExternalFunctionDeclarationAccess().getInputsATypeParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAType_in_ruleAExternalFunctionDeclaration335);
            	    lv_inputs_5_0=ruleAType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAExternalFunctionDeclarationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"inputs",
            	            		lv_inputs_5_0, 
            	            		"AType");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_6=(Token)match(input,34,FOLLOW_34_in_ruleAExternalFunctionDeclaration349); 

                	newLeafNode(otherlv_6, grammarAccess.getAExternalFunctionDeclarationAccess().getRightParenthesisKeyword_5());
                
            otherlv_7=(Token)match(input,35,FOLLOW_35_in_ruleAExternalFunctionDeclaration361); 

                	newLeafNode(otherlv_7, grammarAccess.getAExternalFunctionDeclarationAccess().getSemicolonKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAExternalFunctionDeclaration"


    // $ANTLR start "entryRuleAExternalFunctionIdentifier"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:233:1: entryRuleAExternalFunctionIdentifier returns [EObject current=null] : iv_ruleAExternalFunctionIdentifier= ruleAExternalFunctionIdentifier EOF ;
    public final EObject entryRuleAExternalFunctionIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAExternalFunctionIdentifier = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:234:2: (iv_ruleAExternalFunctionIdentifier= ruleAExternalFunctionIdentifier EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:235:2: iv_ruleAExternalFunctionIdentifier= ruleAExternalFunctionIdentifier EOF
            {
             newCompositeNode(grammarAccess.getAExternalFunctionIdentifierRule()); 
            pushFollow(FOLLOW_ruleAExternalFunctionIdentifier_in_entryRuleAExternalFunctionIdentifier397);
            iv_ruleAExternalFunctionIdentifier=ruleAExternalFunctionIdentifier();

            state._fsp--;

             current =iv_ruleAExternalFunctionIdentifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAExternalFunctionIdentifier407); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAExternalFunctionIdentifier"


    // $ANTLR start "ruleAExternalFunctionIdentifier"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:242:1: ruleAExternalFunctionIdentifier returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleAExternalFunctionIdentifier() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:245:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:246:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:246:1: ( (lv_name_0_0= RULE_ID ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:247:1: (lv_name_0_0= RULE_ID )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:247:1: (lv_name_0_0= RULE_ID )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:248:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAExternalFunctionIdentifier448); 

            			newLeafNode(lv_name_0_0, grammarAccess.getAExternalFunctionIdentifierAccess().getNameIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAExternalFunctionIdentifierRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAExternalFunctionIdentifier"


    // $ANTLR start "entryRuleAAffineSystem"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:272:1: entryRuleAAffineSystem returns [EObject current=null] : iv_ruleAAffineSystem= ruleAAffineSystem EOF ;
    public final EObject entryRuleAAffineSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAAffineSystem = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:273:2: (iv_ruleAAffineSystem= ruleAAffineSystem EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:274:2: iv_ruleAAffineSystem= ruleAAffineSystem EOF
            {
             newCompositeNode(grammarAccess.getAAffineSystemRule()); 
            pushFollow(FOLLOW_ruleAAffineSystem_in_entryRuleAAffineSystem488);
            iv_ruleAAffineSystem=ruleAAffineSystem();

            state._fsp--;

             current =iv_ruleAAffineSystem; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAAffineSystem498); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAAffineSystem"


    // $ANTLR start "ruleAAffineSystem"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:281:1: ruleAAffineSystem returns [EObject current=null] : (otherlv_0= 'affine' ( (lv_name_1_0= RULE_ID ) ) ( (lv_parameters_2_0= ruleADomain ) ) (otherlv_3= 'given' ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )* )? (otherlv_5= 'returns' ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )* )? (otherlv_7= 'using' ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )* )? (otherlv_9= 'through' ( (lv_equations_10_0= ruleAStandardEquation ) )* )? otherlv_11= '.' ) ;
    public final EObject ruleAAffineSystem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_parameters_2_0 = null;

        EObject lv_inputDeclarations_4_0 = null;

        EObject lv_outputDeclarations_6_0 = null;

        EObject lv_localvarDeclarations_8_0 = null;

        EObject lv_equations_10_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:284:28: ( (otherlv_0= 'affine' ( (lv_name_1_0= RULE_ID ) ) ( (lv_parameters_2_0= ruleADomain ) ) (otherlv_3= 'given' ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )* )? (otherlv_5= 'returns' ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )* )? (otherlv_7= 'using' ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )* )? (otherlv_9= 'through' ( (lv_equations_10_0= ruleAStandardEquation ) )* )? otherlv_11= '.' ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:285:1: (otherlv_0= 'affine' ( (lv_name_1_0= RULE_ID ) ) ( (lv_parameters_2_0= ruleADomain ) ) (otherlv_3= 'given' ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )* )? (otherlv_5= 'returns' ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )* )? (otherlv_7= 'using' ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )* )? (otherlv_9= 'through' ( (lv_equations_10_0= ruleAStandardEquation ) )* )? otherlv_11= '.' )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:285:1: (otherlv_0= 'affine' ( (lv_name_1_0= RULE_ID ) ) ( (lv_parameters_2_0= ruleADomain ) ) (otherlv_3= 'given' ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )* )? (otherlv_5= 'returns' ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )* )? (otherlv_7= 'using' ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )* )? (otherlv_9= 'through' ( (lv_equations_10_0= ruleAStandardEquation ) )* )? otherlv_11= '.' )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:285:3: otherlv_0= 'affine' ( (lv_name_1_0= RULE_ID ) ) ( (lv_parameters_2_0= ruleADomain ) ) (otherlv_3= 'given' ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )* )? (otherlv_5= 'returns' ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )* )? (otherlv_7= 'using' ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )* )? (otherlv_9= 'through' ( (lv_equations_10_0= ruleAStandardEquation ) )* )? otherlv_11= '.'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_36_in_ruleAAffineSystem535); 

                	newLeafNode(otherlv_0, grammarAccess.getAAffineSystemAccess().getAffineKeyword_0());
                
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:289:1: ( (lv_name_1_0= RULE_ID ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:290:1: (lv_name_1_0= RULE_ID )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:290:1: (lv_name_1_0= RULE_ID )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:291:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAAffineSystem552); 

            			newLeafNode(lv_name_1_0, grammarAccess.getAAffineSystemAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAAffineSystemRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:307:2: ( (lv_parameters_2_0= ruleADomain ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:308:1: (lv_parameters_2_0= ruleADomain )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:308:1: (lv_parameters_2_0= ruleADomain )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:309:3: lv_parameters_2_0= ruleADomain
            {
             
            	        newCompositeNode(grammarAccess.getAAffineSystemAccess().getParametersADomainParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleADomain_in_ruleAAffineSystem578);
            lv_parameters_2_0=ruleADomain();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAAffineSystemRule());
            	        }
                   		set(
                   			current, 
                   			"parameters",
                    		lv_parameters_2_0, 
                    		"ADomain");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:325:2: (otherlv_3= 'given' ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==37) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:325:4: otherlv_3= 'given' ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )*
                    {
                    otherlv_3=(Token)match(input,37,FOLLOW_37_in_ruleAAffineSystem591); 

                        	newLeafNode(otherlv_3, grammarAccess.getAAffineSystemAccess().getGivenKeyword_3_0());
                        
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:329:1: ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>=59 && LA5_0<=67)) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:330:1: (lv_inputDeclarations_4_0= ruleAInputDeclaration )
                    	    {
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:330:1: (lv_inputDeclarations_4_0= ruleAInputDeclaration )
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:331:3: lv_inputDeclarations_4_0= ruleAInputDeclaration
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAAffineSystemAccess().getInputDeclarationsAInputDeclarationParserRuleCall_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAInputDeclaration_in_ruleAAffineSystem612);
                    	    lv_inputDeclarations_4_0=ruleAInputDeclaration();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAAffineSystemRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"inputDeclarations",
                    	            		lv_inputDeclarations_4_0, 
                    	            		"AInputDeclaration");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:347:5: (otherlv_5= 'returns' ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==38) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:347:7: otherlv_5= 'returns' ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )*
                    {
                    otherlv_5=(Token)match(input,38,FOLLOW_38_in_ruleAAffineSystem628); 

                        	newLeafNode(otherlv_5, grammarAccess.getAAffineSystemAccess().getReturnsKeyword_4_0());
                        
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:351:1: ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>=59 && LA7_0<=67)) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:352:1: (lv_outputDeclarations_6_0= ruleAOutputDeclaration )
                    	    {
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:352:1: (lv_outputDeclarations_6_0= ruleAOutputDeclaration )
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:353:3: lv_outputDeclarations_6_0= ruleAOutputDeclaration
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAAffineSystemAccess().getOutputDeclarationsAOutputDeclarationParserRuleCall_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAOutputDeclaration_in_ruleAAffineSystem649);
                    	    lv_outputDeclarations_6_0=ruleAOutputDeclaration();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAAffineSystemRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"outputDeclarations",
                    	            		lv_outputDeclarations_6_0, 
                    	            		"AOutputDeclaration");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:369:5: (otherlv_7= 'using' ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==39) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:369:7: otherlv_7= 'using' ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )*
                    {
                    otherlv_7=(Token)match(input,39,FOLLOW_39_in_ruleAAffineSystem665); 

                        	newLeafNode(otherlv_7, grammarAccess.getAAffineSystemAccess().getUsingKeyword_5_0());
                        
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:373:1: ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( ((LA9_0>=59 && LA9_0<=67)) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:374:1: (lv_localvarDeclarations_8_0= ruleALocalDeclaration )
                    	    {
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:374:1: (lv_localvarDeclarations_8_0= ruleALocalDeclaration )
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:375:3: lv_localvarDeclarations_8_0= ruleALocalDeclaration
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAAffineSystemAccess().getLocalvarDeclarationsALocalDeclarationParserRuleCall_5_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleALocalDeclaration_in_ruleAAffineSystem686);
                    	    lv_localvarDeclarations_8_0=ruleALocalDeclaration();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAAffineSystemRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"localvarDeclarations",
                    	            		lv_localvarDeclarations_8_0, 
                    	            		"ALocalDeclaration");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:391:5: (otherlv_9= 'through' ( (lv_equations_10_0= ruleAStandardEquation ) )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==40) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:391:7: otherlv_9= 'through' ( (lv_equations_10_0= ruleAStandardEquation ) )*
                    {
                    otherlv_9=(Token)match(input,40,FOLLOW_40_in_ruleAAffineSystem702); 

                        	newLeafNode(otherlv_9, grammarAccess.getAAffineSystemAccess().getThroughKeyword_6_0());
                        
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:395:1: ( (lv_equations_10_0= ruleAStandardEquation ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==RULE_ID) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:396:1: (lv_equations_10_0= ruleAStandardEquation )
                    	    {
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:396:1: (lv_equations_10_0= ruleAStandardEquation )
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:397:3: lv_equations_10_0= ruleAStandardEquation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAAffineSystemAccess().getEquationsAStandardEquationParserRuleCall_6_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAStandardEquation_in_ruleAAffineSystem723);
                    	    lv_equations_10_0=ruleAStandardEquation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAAffineSystemRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"equations",
                    	            		lv_equations_10_0, 
                    	            		"AStandardEquation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_11=(Token)match(input,41,FOLLOW_41_in_ruleAAffineSystem738); 

                	newLeafNode(otherlv_11, grammarAccess.getAAffineSystemAccess().getFullStopKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAAffineSystem"


    // $ANTLR start "entryRuleAOutputDeclaration"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:425:1: entryRuleAOutputDeclaration returns [EObject current=null] : iv_ruleAOutputDeclaration= ruleAOutputDeclaration EOF ;
    public final EObject entryRuleAOutputDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAOutputDeclaration = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:426:2: (iv_ruleAOutputDeclaration= ruleAOutputDeclaration EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:427:2: iv_ruleAOutputDeclaration= ruleAOutputDeclaration EOF
            {
             newCompositeNode(grammarAccess.getAOutputDeclarationRule()); 
            pushFollow(FOLLOW_ruleAOutputDeclaration_in_entryRuleAOutputDeclaration774);
            iv_ruleAOutputDeclaration=ruleAOutputDeclaration();

            state._fsp--;

             current =iv_ruleAOutputDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAOutputDeclaration784); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAOutputDeclaration"


    // $ANTLR start "ruleAOutputDeclaration"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:434:1: ruleAOutputDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';' ) ;
    public final EObject ruleAOutputDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject lv_type_0_0 = null;

        EObject lv_identifierList_1_0 = null;

        EObject lv_domain_2_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:437:28: ( ( ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';' ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:438:1: ( ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';' )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:438:1: ( ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';' )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:438:2: ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';'
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:438:2: ( (lv_type_0_0= ruleAType ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:439:1: (lv_type_0_0= ruleAType )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:439:1: (lv_type_0_0= ruleAType )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:440:3: lv_type_0_0= ruleAType
            {
             
            	        newCompositeNode(grammarAccess.getAOutputDeclarationAccess().getTypeATypeParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleAType_in_ruleAOutputDeclaration830);
            lv_type_0_0=ruleAType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAOutputDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_0_0, 
                    		"AType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:456:2: ( (lv_identifierList_1_0= ruleAIdentifierList ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:457:1: (lv_identifierList_1_0= ruleAIdentifierList )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:457:1: (lv_identifierList_1_0= ruleAIdentifierList )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:458:3: lv_identifierList_1_0= ruleAIdentifierList
            {
             
            	        newCompositeNode(grammarAccess.getAOutputDeclarationAccess().getIdentifierListAIdentifierListParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleAIdentifierList_in_ruleAOutputDeclaration851);
            lv_identifierList_1_0=ruleAIdentifierList();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAOutputDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"identifierList",
                    		lv_identifierList_1_0, 
                    		"AIdentifierList");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:474:2: ( (lv_domain_2_0= ruleADomain ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==42) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:475:1: (lv_domain_2_0= ruleADomain )
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:475:1: (lv_domain_2_0= ruleADomain )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:476:3: lv_domain_2_0= ruleADomain
                    {
                     
                    	        newCompositeNode(grammarAccess.getAOutputDeclarationAccess().getDomainADomainParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleADomain_in_ruleAOutputDeclaration872);
                    lv_domain_2_0=ruleADomain();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAOutputDeclarationRule());
                    	        }
                           		set(
                           			current, 
                           			"domain",
                            		lv_domain_2_0, 
                            		"ADomain");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,35,FOLLOW_35_in_ruleAOutputDeclaration885); 

                	newLeafNode(otherlv_3, grammarAccess.getAOutputDeclarationAccess().getSemicolonKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAOutputDeclaration"


    // $ANTLR start "entryRuleAInputDeclaration"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:504:1: entryRuleAInputDeclaration returns [EObject current=null] : iv_ruleAInputDeclaration= ruleAInputDeclaration EOF ;
    public final EObject entryRuleAInputDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAInputDeclaration = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:505:2: (iv_ruleAInputDeclaration= ruleAInputDeclaration EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:506:2: iv_ruleAInputDeclaration= ruleAInputDeclaration EOF
            {
             newCompositeNode(grammarAccess.getAInputDeclarationRule()); 
            pushFollow(FOLLOW_ruleAInputDeclaration_in_entryRuleAInputDeclaration921);
            iv_ruleAInputDeclaration=ruleAInputDeclaration();

            state._fsp--;

             current =iv_ruleAInputDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAInputDeclaration931); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAInputDeclaration"


    // $ANTLR start "ruleAInputDeclaration"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:513:1: ruleAInputDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';' ) ;
    public final EObject ruleAInputDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject lv_type_0_0 = null;

        EObject lv_identifierList_1_0 = null;

        EObject lv_domain_2_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:516:28: ( ( ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';' ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:517:1: ( ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';' )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:517:1: ( ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';' )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:517:2: ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';'
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:517:2: ( (lv_type_0_0= ruleAType ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:518:1: (lv_type_0_0= ruleAType )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:518:1: (lv_type_0_0= ruleAType )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:519:3: lv_type_0_0= ruleAType
            {
             
            	        newCompositeNode(grammarAccess.getAInputDeclarationAccess().getTypeATypeParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleAType_in_ruleAInputDeclaration977);
            lv_type_0_0=ruleAType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAInputDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_0_0, 
                    		"AType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:535:2: ( (lv_identifierList_1_0= ruleAIdentifierList ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:536:1: (lv_identifierList_1_0= ruleAIdentifierList )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:536:1: (lv_identifierList_1_0= ruleAIdentifierList )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:537:3: lv_identifierList_1_0= ruleAIdentifierList
            {
             
            	        newCompositeNode(grammarAccess.getAInputDeclarationAccess().getIdentifierListAIdentifierListParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleAIdentifierList_in_ruleAInputDeclaration998);
            lv_identifierList_1_0=ruleAIdentifierList();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAInputDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"identifierList",
                    		lv_identifierList_1_0, 
                    		"AIdentifierList");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:553:2: ( (lv_domain_2_0= ruleADomain ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==42) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:554:1: (lv_domain_2_0= ruleADomain )
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:554:1: (lv_domain_2_0= ruleADomain )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:555:3: lv_domain_2_0= ruleADomain
                    {
                     
                    	        newCompositeNode(grammarAccess.getAInputDeclarationAccess().getDomainADomainParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleADomain_in_ruleAInputDeclaration1019);
                    lv_domain_2_0=ruleADomain();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAInputDeclarationRule());
                    	        }
                           		set(
                           			current, 
                           			"domain",
                            		lv_domain_2_0, 
                            		"ADomain");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,35,FOLLOW_35_in_ruleAInputDeclaration1032); 

                	newLeafNode(otherlv_3, grammarAccess.getAInputDeclarationAccess().getSemicolonKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAInputDeclaration"


    // $ANTLR start "entryRuleALocalDeclaration"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:583:1: entryRuleALocalDeclaration returns [EObject current=null] : iv_ruleALocalDeclaration= ruleALocalDeclaration EOF ;
    public final EObject entryRuleALocalDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleALocalDeclaration = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:584:2: (iv_ruleALocalDeclaration= ruleALocalDeclaration EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:585:2: iv_ruleALocalDeclaration= ruleALocalDeclaration EOF
            {
             newCompositeNode(grammarAccess.getALocalDeclarationRule()); 
            pushFollow(FOLLOW_ruleALocalDeclaration_in_entryRuleALocalDeclaration1068);
            iv_ruleALocalDeclaration=ruleALocalDeclaration();

            state._fsp--;

             current =iv_ruleALocalDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleALocalDeclaration1078); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleALocalDeclaration"


    // $ANTLR start "ruleALocalDeclaration"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:592:1: ruleALocalDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';' ) ;
    public final EObject ruleALocalDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject lv_type_0_0 = null;

        EObject lv_identifierList_1_0 = null;

        EObject lv_domain_2_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:595:28: ( ( ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';' ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:596:1: ( ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';' )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:596:1: ( ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';' )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:596:2: ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';'
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:596:2: ( (lv_type_0_0= ruleAType ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:597:1: (lv_type_0_0= ruleAType )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:597:1: (lv_type_0_0= ruleAType )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:598:3: lv_type_0_0= ruleAType
            {
             
            	        newCompositeNode(grammarAccess.getALocalDeclarationAccess().getTypeATypeParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleAType_in_ruleALocalDeclaration1124);
            lv_type_0_0=ruleAType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getALocalDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_0_0, 
                    		"AType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:614:2: ( (lv_identifierList_1_0= ruleAIdentifierList ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:615:1: (lv_identifierList_1_0= ruleAIdentifierList )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:615:1: (lv_identifierList_1_0= ruleAIdentifierList )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:616:3: lv_identifierList_1_0= ruleAIdentifierList
            {
             
            	        newCompositeNode(grammarAccess.getALocalDeclarationAccess().getIdentifierListAIdentifierListParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleAIdentifierList_in_ruleALocalDeclaration1145);
            lv_identifierList_1_0=ruleAIdentifierList();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getALocalDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"identifierList",
                    		lv_identifierList_1_0, 
                    		"AIdentifierList");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:632:2: ( (lv_domain_2_0= ruleADomain ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==42) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:633:1: (lv_domain_2_0= ruleADomain )
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:633:1: (lv_domain_2_0= ruleADomain )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:634:3: lv_domain_2_0= ruleADomain
                    {
                     
                    	        newCompositeNode(grammarAccess.getALocalDeclarationAccess().getDomainADomainParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleADomain_in_ruleALocalDeclaration1166);
                    lv_domain_2_0=ruleADomain();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getALocalDeclarationRule());
                    	        }
                           		set(
                           			current, 
                           			"domain",
                            		lv_domain_2_0, 
                            		"ADomain");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,35,FOLLOW_35_in_ruleALocalDeclaration1179); 

                	newLeafNode(otherlv_3, grammarAccess.getALocalDeclarationAccess().getSemicolonKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleALocalDeclaration"


    // $ANTLR start "entryRuleAIdentifierList"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:662:1: entryRuleAIdentifierList returns [EObject current=null] : iv_ruleAIdentifierList= ruleAIdentifierList EOF ;
    public final EObject entryRuleAIdentifierList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAIdentifierList = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:663:2: (iv_ruleAIdentifierList= ruleAIdentifierList EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:664:2: iv_ruleAIdentifierList= ruleAIdentifierList EOF
            {
             newCompositeNode(grammarAccess.getAIdentifierListRule()); 
            pushFollow(FOLLOW_ruleAIdentifierList_in_entryRuleAIdentifierList1215);
            iv_ruleAIdentifierList=ruleAIdentifierList();

            state._fsp--;

             current =iv_ruleAIdentifierList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAIdentifierList1225); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAIdentifierList"


    // $ANTLR start "ruleAIdentifierList"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:671:1: ruleAIdentifierList returns [EObject current=null] : ( ( (lv_identifiers_0_0= ruleVariableIdentifier ) ) (otherlv_1= ',' ( (lv_identifiers_2_0= ruleVariableIdentifier ) ) )* ) ;
    public final EObject ruleAIdentifierList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_identifiers_0_0 = null;

        AntlrDatatypeRuleToken lv_identifiers_2_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:674:28: ( ( ( (lv_identifiers_0_0= ruleVariableIdentifier ) ) (otherlv_1= ',' ( (lv_identifiers_2_0= ruleVariableIdentifier ) ) )* ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:675:1: ( ( (lv_identifiers_0_0= ruleVariableIdentifier ) ) (otherlv_1= ',' ( (lv_identifiers_2_0= ruleVariableIdentifier ) ) )* )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:675:1: ( ( (lv_identifiers_0_0= ruleVariableIdentifier ) ) (otherlv_1= ',' ( (lv_identifiers_2_0= ruleVariableIdentifier ) ) )* )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:675:2: ( (lv_identifiers_0_0= ruleVariableIdentifier ) ) (otherlv_1= ',' ( (lv_identifiers_2_0= ruleVariableIdentifier ) ) )*
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:675:2: ( (lv_identifiers_0_0= ruleVariableIdentifier ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:676:1: (lv_identifiers_0_0= ruleVariableIdentifier )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:676:1: (lv_identifiers_0_0= ruleVariableIdentifier )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:677:3: lv_identifiers_0_0= ruleVariableIdentifier
            {
             
            	        newCompositeNode(grammarAccess.getAIdentifierListAccess().getIdentifiersVariableIdentifierParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleVariableIdentifier_in_ruleAIdentifierList1271);
            lv_identifiers_0_0=ruleVariableIdentifier();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAIdentifierListRule());
            	        }
                   		add(
                   			current, 
                   			"identifiers",
                    		lv_identifiers_0_0, 
                    		"VariableIdentifier");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:693:2: (otherlv_1= ',' ( (lv_identifiers_2_0= ruleVariableIdentifier ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==33) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:693:4: otherlv_1= ',' ( (lv_identifiers_2_0= ruleVariableIdentifier ) )
            	    {
            	    otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleAIdentifierList1284); 

            	        	newLeafNode(otherlv_1, grammarAccess.getAIdentifierListAccess().getCommaKeyword_1_0());
            	        
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:697:1: ( (lv_identifiers_2_0= ruleVariableIdentifier ) )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:698:1: (lv_identifiers_2_0= ruleVariableIdentifier )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:698:1: (lv_identifiers_2_0= ruleVariableIdentifier )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:699:3: lv_identifiers_2_0= ruleVariableIdentifier
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAIdentifierListAccess().getIdentifiersVariableIdentifierParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleVariableIdentifier_in_ruleAIdentifierList1305);
            	    lv_identifiers_2_0=ruleVariableIdentifier();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAIdentifierListRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"identifiers",
            	            		lv_identifiers_2_0, 
            	            		"VariableIdentifier");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAIdentifierList"


    // $ANTLR start "entryRuleVariableIdentifier"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:723:1: entryRuleVariableIdentifier returns [String current=null] : iv_ruleVariableIdentifier= ruleVariableIdentifier EOF ;
    public final String entryRuleVariableIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVariableIdentifier = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:724:2: (iv_ruleVariableIdentifier= ruleVariableIdentifier EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:725:2: iv_ruleVariableIdentifier= ruleVariableIdentifier EOF
            {
             newCompositeNode(grammarAccess.getVariableIdentifierRule()); 
            pushFollow(FOLLOW_ruleVariableIdentifier_in_entryRuleVariableIdentifier1344);
            iv_ruleVariableIdentifier=ruleVariableIdentifier();

            state._fsp--;

             current =iv_ruleVariableIdentifier.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableIdentifier1355); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableIdentifier"


    // $ANTLR start "ruleVariableIdentifier"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:732:1: ruleVariableIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleVariableIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:735:28: (this_ID_0= RULE_ID )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:736:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableIdentifier1394); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getVariableIdentifierAccess().getIDTerminalRuleCall()); 
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableIdentifier"


    // $ANTLR start "entryRuleADomain"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:751:1: entryRuleADomain returns [EObject current=null] : iv_ruleADomain= ruleADomain EOF ;
    public final EObject entryRuleADomain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleADomain = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:752:2: (iv_ruleADomain= ruleADomain EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:753:2: iv_ruleADomain= ruleADomain EOF
            {
             newCompositeNode(grammarAccess.getADomainRule()); 
            pushFollow(FOLLOW_ruleADomain_in_entryRuleADomain1438);
            iv_ruleADomain=ruleADomain();

            state._fsp--;

             current =iv_ruleADomain; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleADomain1448); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleADomain"


    // $ANTLR start "ruleADomain"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:760:1: ruleADomain returns [EObject current=null] : ( ( (lv_polyhedra_0_0= ruleAPolyhedron ) ) (this_UNION_1= RULE_UNION ( (lv_polyhedra_2_0= ruleAPolyhedron ) ) )* ) ;
    public final EObject ruleADomain() throws RecognitionException {
        EObject current = null;

        Token this_UNION_1=null;
        EObject lv_polyhedra_0_0 = null;

        EObject lv_polyhedra_2_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:763:28: ( ( ( (lv_polyhedra_0_0= ruleAPolyhedron ) ) (this_UNION_1= RULE_UNION ( (lv_polyhedra_2_0= ruleAPolyhedron ) ) )* ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:764:1: ( ( (lv_polyhedra_0_0= ruleAPolyhedron ) ) (this_UNION_1= RULE_UNION ( (lv_polyhedra_2_0= ruleAPolyhedron ) ) )* )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:764:1: ( ( (lv_polyhedra_0_0= ruleAPolyhedron ) ) (this_UNION_1= RULE_UNION ( (lv_polyhedra_2_0= ruleAPolyhedron ) ) )* )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:764:2: ( (lv_polyhedra_0_0= ruleAPolyhedron ) ) (this_UNION_1= RULE_UNION ( (lv_polyhedra_2_0= ruleAPolyhedron ) ) )*
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:764:2: ( (lv_polyhedra_0_0= ruleAPolyhedron ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:765:1: (lv_polyhedra_0_0= ruleAPolyhedron )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:765:1: (lv_polyhedra_0_0= ruleAPolyhedron )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:766:3: lv_polyhedra_0_0= ruleAPolyhedron
            {
             
            	        newCompositeNode(grammarAccess.getADomainAccess().getPolyhedraAPolyhedronParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleAPolyhedron_in_ruleADomain1494);
            lv_polyhedra_0_0=ruleAPolyhedron();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getADomainRule());
            	        }
                   		add(
                   			current, 
                   			"polyhedra",
                    		lv_polyhedra_0_0, 
                    		"APolyhedron");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:782:2: (this_UNION_1= RULE_UNION ( (lv_polyhedra_2_0= ruleAPolyhedron ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_UNION) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:782:3: this_UNION_1= RULE_UNION ( (lv_polyhedra_2_0= ruleAPolyhedron ) )
            	    {
            	    this_UNION_1=(Token)match(input,RULE_UNION,FOLLOW_RULE_UNION_in_ruleADomain1506); 
            	     
            	        newLeafNode(this_UNION_1, grammarAccess.getADomainAccess().getUNIONTerminalRuleCall_1_0()); 
            	        
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:786:1: ( (lv_polyhedra_2_0= ruleAPolyhedron ) )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:787:1: (lv_polyhedra_2_0= ruleAPolyhedron )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:787:1: (lv_polyhedra_2_0= ruleAPolyhedron )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:788:3: lv_polyhedra_2_0= ruleAPolyhedron
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getADomainAccess().getPolyhedraAPolyhedronParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAPolyhedron_in_ruleADomain1526);
            	    lv_polyhedra_2_0=ruleAPolyhedron();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getADomainRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"polyhedra",
            	            		lv_polyhedra_2_0, 
            	            		"APolyhedron");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleADomain"


    // $ANTLR start "entryRuleAPolyhedron"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:812:1: entryRuleAPolyhedron returns [EObject current=null] : iv_ruleAPolyhedron= ruleAPolyhedron EOF ;
    public final EObject entryRuleAPolyhedron() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAPolyhedron = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:813:2: (iv_ruleAPolyhedron= ruleAPolyhedron EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:814:2: iv_ruleAPolyhedron= ruleAPolyhedron EOF
            {
             newCompositeNode(grammarAccess.getAPolyhedronRule()); 
            pushFollow(FOLLOW_ruleAPolyhedron_in_entryRuleAPolyhedron1564);
            iv_ruleAPolyhedron=ruleAPolyhedron();

            state._fsp--;

             current =iv_ruleAPolyhedron; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAPolyhedron1574); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAPolyhedron"


    // $ANTLR start "ruleAPolyhedron"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:821:1: ruleAPolyhedron returns [EObject current=null] : (otherlv_0= '{' ( (lv_indexes_1_0= ruleAIndexList ) ) otherlv_2= '|' ( ( (lv_constraints_3_0= ruleInEquality ) ) (this_INTERSECTION_4= RULE_INTERSECTION ( (lv_constraints_5_0= ruleInEquality ) ) )* )? otherlv_6= '}' ) ;
    public final EObject ruleAPolyhedron() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token this_INTERSECTION_4=null;
        Token otherlv_6=null;
        EObject lv_indexes_1_0 = null;

        AntlrDatatypeRuleToken lv_constraints_3_0 = null;

        AntlrDatatypeRuleToken lv_constraints_5_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:824:28: ( (otherlv_0= '{' ( (lv_indexes_1_0= ruleAIndexList ) ) otherlv_2= '|' ( ( (lv_constraints_3_0= ruleInEquality ) ) (this_INTERSECTION_4= RULE_INTERSECTION ( (lv_constraints_5_0= ruleInEquality ) ) )* )? otherlv_6= '}' ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:825:1: (otherlv_0= '{' ( (lv_indexes_1_0= ruleAIndexList ) ) otherlv_2= '|' ( ( (lv_constraints_3_0= ruleInEquality ) ) (this_INTERSECTION_4= RULE_INTERSECTION ( (lv_constraints_5_0= ruleInEquality ) ) )* )? otherlv_6= '}' )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:825:1: (otherlv_0= '{' ( (lv_indexes_1_0= ruleAIndexList ) ) otherlv_2= '|' ( ( (lv_constraints_3_0= ruleInEquality ) ) (this_INTERSECTION_4= RULE_INTERSECTION ( (lv_constraints_5_0= ruleInEquality ) ) )* )? otherlv_6= '}' )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:825:3: otherlv_0= '{' ( (lv_indexes_1_0= ruleAIndexList ) ) otherlv_2= '|' ( ( (lv_constraints_3_0= ruleInEquality ) ) (this_INTERSECTION_4= RULE_INTERSECTION ( (lv_constraints_5_0= ruleInEquality ) ) )* )? otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,42,FOLLOW_42_in_ruleAPolyhedron1611); 

                	newLeafNode(otherlv_0, grammarAccess.getAPolyhedronAccess().getLeftCurlyBracketKeyword_0());
                
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:829:1: ( (lv_indexes_1_0= ruleAIndexList ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:830:1: (lv_indexes_1_0= ruleAIndexList )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:830:1: (lv_indexes_1_0= ruleAIndexList )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:831:3: lv_indexes_1_0= ruleAIndexList
            {
             
            	        newCompositeNode(grammarAccess.getAPolyhedronAccess().getIndexesAIndexListParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleAIndexList_in_ruleAPolyhedron1632);
            lv_indexes_1_0=ruleAIndexList();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAPolyhedronRule());
            	        }
                   		set(
                   			current, 
                   			"indexes",
                    		lv_indexes_1_0, 
                    		"AIndexList");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,43,FOLLOW_43_in_ruleAPolyhedron1644); 

                	newLeafNode(otherlv_2, grammarAccess.getAPolyhedronAccess().getVerticalLineKeyword_2());
                
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:851:1: ( ( (lv_constraints_3_0= ruleInEquality ) ) (this_INTERSECTION_4= RULE_INTERSECTION ( (lv_constraints_5_0= ruleInEquality ) ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID||(LA19_0>=RULE_OP_MINUS && LA19_0<=RULE_INT)||LA19_0==32) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:851:2: ( (lv_constraints_3_0= ruleInEquality ) ) (this_INTERSECTION_4= RULE_INTERSECTION ( (lv_constraints_5_0= ruleInEquality ) ) )*
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:851:2: ( (lv_constraints_3_0= ruleInEquality ) )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:852:1: (lv_constraints_3_0= ruleInEquality )
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:852:1: (lv_constraints_3_0= ruleInEquality )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:853:3: lv_constraints_3_0= ruleInEquality
                    {
                     
                    	        newCompositeNode(grammarAccess.getAPolyhedronAccess().getConstraintsInEqualityParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleInEquality_in_ruleAPolyhedron1666);
                    lv_constraints_3_0=ruleInEquality();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAPolyhedronRule());
                    	        }
                           		add(
                           			current, 
                           			"constraints",
                            		lv_constraints_3_0, 
                            		"InEquality");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:869:2: (this_INTERSECTION_4= RULE_INTERSECTION ( (lv_constraints_5_0= ruleInEquality ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==RULE_INTERSECTION) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:869:3: this_INTERSECTION_4= RULE_INTERSECTION ( (lv_constraints_5_0= ruleInEquality ) )
                    	    {
                    	    this_INTERSECTION_4=(Token)match(input,RULE_INTERSECTION,FOLLOW_RULE_INTERSECTION_in_ruleAPolyhedron1678); 
                    	     
                    	        newLeafNode(this_INTERSECTION_4, grammarAccess.getAPolyhedronAccess().getINTERSECTIONTerminalRuleCall_3_1_0()); 
                    	        
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:873:1: ( (lv_constraints_5_0= ruleInEquality ) )
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:874:1: (lv_constraints_5_0= ruleInEquality )
                    	    {
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:874:1: (lv_constraints_5_0= ruleInEquality )
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:875:3: lv_constraints_5_0= ruleInEquality
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAPolyhedronAccess().getConstraintsInEqualityParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleInEquality_in_ruleAPolyhedron1698);
                    	    lv_constraints_5_0=ruleInEquality();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAPolyhedronRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"constraints",
                    	            		lv_constraints_5_0, 
                    	            		"InEquality");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,44,FOLLOW_44_in_ruleAPolyhedron1714); 

                	newLeafNode(otherlv_6, grammarAccess.getAPolyhedronAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAPolyhedron"


    // $ANTLR start "entryRuleInEquality"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:903:1: entryRuleInEquality returns [String current=null] : iv_ruleInEquality= ruleInEquality EOF ;
    public final String entryRuleInEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInEquality = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:904:2: (iv_ruleInEquality= ruleInEquality EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:905:2: iv_ruleInEquality= ruleInEquality EOF
            {
             newCompositeNode(grammarAccess.getInEqualityRule()); 
            pushFollow(FOLLOW_ruleInEquality_in_entryRuleInEquality1751);
            iv_ruleInEquality=ruleInEquality();

            state._fsp--;

             current =iv_ruleInEquality.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInEquality1762); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInEquality"


    // $ANTLR start "ruleInEquality"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:912:1: ruleInEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_IDList_0= ruleIDList | this_IDExpression_1= ruleIDExpression ) (this_RelationalOp_2= ruleRelationalOp (this_IDList_3= ruleIDList | this_IDExpression_4= ruleIDExpression ) )+ ) ;
    public final AntlrDatatypeRuleToken ruleInEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_IDList_0 = null;

        AntlrDatatypeRuleToken this_IDExpression_1 = null;

        AntlrDatatypeRuleToken this_RelationalOp_2 = null;

        AntlrDatatypeRuleToken this_IDList_3 = null;

        AntlrDatatypeRuleToken this_IDExpression_4 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:915:28: ( ( (this_IDList_0= ruleIDList | this_IDExpression_1= ruleIDExpression ) (this_RelationalOp_2= ruleRelationalOp (this_IDList_3= ruleIDList | this_IDExpression_4= ruleIDExpression ) )+ ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:916:1: ( (this_IDList_0= ruleIDList | this_IDExpression_1= ruleIDExpression ) (this_RelationalOp_2= ruleRelationalOp (this_IDList_3= ruleIDList | this_IDExpression_4= ruleIDExpression ) )+ )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:916:1: ( (this_IDList_0= ruleIDList | this_IDExpression_1= ruleIDExpression ) (this_RelationalOp_2= ruleRelationalOp (this_IDList_3= ruleIDList | this_IDExpression_4= ruleIDExpression ) )+ )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:916:2: (this_IDList_0= ruleIDList | this_IDExpression_1= ruleIDExpression ) (this_RelationalOp_2= ruleRelationalOp (this_IDList_3= ruleIDList | this_IDExpression_4= ruleIDExpression ) )+
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:916:2: (this_IDList_0= ruleIDList | this_IDExpression_1= ruleIDExpression )
            int alt20=2;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:917:5: this_IDList_0= ruleIDList
                    {
                     
                            newCompositeNode(grammarAccess.getInEqualityAccess().getIDListParserRuleCall_0_0()); 
                        
                    pushFollow(FOLLOW_ruleIDList_in_ruleInEquality1810);
                    this_IDList_0=ruleIDList();

                    state._fsp--;


                    		current.merge(this_IDList_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:929:5: this_IDExpression_1= ruleIDExpression
                    {
                     
                            newCompositeNode(grammarAccess.getInEqualityAccess().getIDExpressionParserRuleCall_0_1()); 
                        
                    pushFollow(FOLLOW_ruleIDExpression_in_ruleInEquality1843);
                    this_IDExpression_1=ruleIDExpression();

                    state._fsp--;


                    		current.merge(this_IDExpression_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:939:2: (this_RelationalOp_2= ruleRelationalOp (this_IDList_3= ruleIDList | this_IDExpression_4= ruleIDExpression ) )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=RULE_OP_EQ && LA22_0<=RULE_OP_NE)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:940:5: this_RelationalOp_2= ruleRelationalOp (this_IDList_3= ruleIDList | this_IDExpression_4= ruleIDExpression )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getInEqualityAccess().getRelationalOpParserRuleCall_1_0()); 
            	        
            	    pushFollow(FOLLOW_ruleRelationalOp_in_ruleInEquality1872);
            	    this_RelationalOp_2=ruleRelationalOp();

            	    state._fsp--;


            	    		current.merge(this_RelationalOp_2);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:950:1: (this_IDList_3= ruleIDList | this_IDExpression_4= ruleIDExpression )
            	    int alt21=2;
            	    alt21 = dfa21.predict(input);
            	    switch (alt21) {
            	        case 1 :
            	            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:951:5: this_IDList_3= ruleIDList
            	            {
            	             
            	                    newCompositeNode(grammarAccess.getInEqualityAccess().getIDListParserRuleCall_1_1_0()); 
            	                
            	            pushFollow(FOLLOW_ruleIDList_in_ruleInEquality1900);
            	            this_IDList_3=ruleIDList();

            	            state._fsp--;


            	            		current.merge(this_IDList_3);
            	                
            	             
            	                    afterParserOrEnumRuleCall();
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:963:5: this_IDExpression_4= ruleIDExpression
            	            {
            	             
            	                    newCompositeNode(grammarAccess.getInEqualityAccess().getIDExpressionParserRuleCall_1_1_1()); 
            	                
            	            pushFollow(FOLLOW_ruleIDExpression_in_ruleInEquality1933);
            	            this_IDExpression_4=ruleIDExpression();

            	            state._fsp--;


            	            		current.merge(this_IDExpression_4);
            	                
            	             
            	                    afterParserOrEnumRuleCall();
            	                

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInEquality"


    // $ANTLR start "entryRuleIDList"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:981:1: entryRuleIDList returns [String current=null] : iv_ruleIDList= ruleIDList EOF ;
    public final String entryRuleIDList() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIDList = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:982:2: (iv_ruleIDList= ruleIDList EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:983:2: iv_ruleIDList= ruleIDList EOF
            {
             newCompositeNode(grammarAccess.getIDListRule()); 
            pushFollow(FOLLOW_ruleIDList_in_entryRuleIDList1982);
            iv_ruleIDList=ruleIDList();

            state._fsp--;

             current =iv_ruleIDList.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIDList1993); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIDList"


    // $ANTLR start "ruleIDList"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:990:1: ruleIDList returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_InEqID_0= ruleInEqID (kw= ',' this_InEqID_2= ruleInEqID )* ) | (kw= '(' this_InEqID_4= ruleInEqID (kw= ',' this_InEqID_6= ruleInEqID )* kw= ')' ) ) ;
    public final AntlrDatatypeRuleToken ruleIDList() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_InEqID_0 = null;

        AntlrDatatypeRuleToken this_InEqID_2 = null;

        AntlrDatatypeRuleToken this_InEqID_4 = null;

        AntlrDatatypeRuleToken this_InEqID_6 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:993:28: ( ( (this_InEqID_0= ruleInEqID (kw= ',' this_InEqID_2= ruleInEqID )* ) | (kw= '(' this_InEqID_4= ruleInEqID (kw= ',' this_InEqID_6= ruleInEqID )* kw= ')' ) ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:994:1: ( (this_InEqID_0= ruleInEqID (kw= ',' this_InEqID_2= ruleInEqID )* ) | (kw= '(' this_InEqID_4= ruleInEqID (kw= ',' this_InEqID_6= ruleInEqID )* kw= ')' ) )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:994:1: ( (this_InEqID_0= ruleInEqID (kw= ',' this_InEqID_2= ruleInEqID )* ) | (kw= '(' this_InEqID_4= ruleInEqID (kw= ',' this_InEqID_6= ruleInEqID )* kw= ')' ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID||(LA25_0>=RULE_OP_MINUS && LA25_0<=RULE_INT)) ) {
                alt25=1;
            }
            else if ( (LA25_0==32) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:994:2: (this_InEqID_0= ruleInEqID (kw= ',' this_InEqID_2= ruleInEqID )* )
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:994:2: (this_InEqID_0= ruleInEqID (kw= ',' this_InEqID_2= ruleInEqID )* )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:995:5: this_InEqID_0= ruleInEqID (kw= ',' this_InEqID_2= ruleInEqID )*
                    {
                     
                            newCompositeNode(grammarAccess.getIDListAccess().getInEqIDParserRuleCall_0_0()); 
                        
                    pushFollow(FOLLOW_ruleInEqID_in_ruleIDList2041);
                    this_InEqID_0=ruleInEqID();

                    state._fsp--;


                    		current.merge(this_InEqID_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1005:1: (kw= ',' this_InEqID_2= ruleInEqID )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==33) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1006:2: kw= ',' this_InEqID_2= ruleInEqID
                    	    {
                    	    kw=(Token)match(input,33,FOLLOW_33_in_ruleIDList2060); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getIDListAccess().getCommaKeyword_0_1_0()); 
                    	        
                    	     
                    	            newCompositeNode(grammarAccess.getIDListAccess().getInEqIDParserRuleCall_0_1_1()); 
                    	        
                    	    pushFollow(FOLLOW_ruleInEqID_in_ruleIDList2082);
                    	    this_InEqID_2=ruleInEqID();

                    	    state._fsp--;


                    	    		current.merge(this_InEqID_2);
                    	        
                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1023:6: (kw= '(' this_InEqID_4= ruleInEqID (kw= ',' this_InEqID_6= ruleInEqID )* kw= ')' )
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1023:6: (kw= '(' this_InEqID_4= ruleInEqID (kw= ',' this_InEqID_6= ruleInEqID )* kw= ')' )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1024:2: kw= '(' this_InEqID_4= ruleInEqID (kw= ',' this_InEqID_6= ruleInEqID )* kw= ')'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleIDList2110); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getIDListAccess().getLeftParenthesisKeyword_1_0()); 
                        
                     
                            newCompositeNode(grammarAccess.getIDListAccess().getInEqIDParserRuleCall_1_1()); 
                        
                    pushFollow(FOLLOW_ruleInEqID_in_ruleIDList2132);
                    this_InEqID_4=ruleInEqID();

                    state._fsp--;


                    		current.merge(this_InEqID_4);
                        
                     
                            afterParserOrEnumRuleCall();
                        
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1040:1: (kw= ',' this_InEqID_6= ruleInEqID )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==33) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1041:2: kw= ',' this_InEqID_6= ruleInEqID
                    	    {
                    	    kw=(Token)match(input,33,FOLLOW_33_in_ruleIDList2151); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getIDListAccess().getCommaKeyword_1_2_0()); 
                    	        
                    	     
                    	            newCompositeNode(grammarAccess.getIDListAccess().getInEqIDParserRuleCall_1_2_1()); 
                    	        
                    	    pushFollow(FOLLOW_ruleInEqID_in_ruleIDList2173);
                    	    this_InEqID_6=ruleInEqID();

                    	    state._fsp--;


                    	    		current.merge(this_InEqID_6);
                    	        
                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    kw=(Token)match(input,34,FOLLOW_34_in_ruleIDList2193); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getIDListAccess().getRightParenthesisKeyword_1_3()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIDList"


    // $ANTLR start "entryRuleIDExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1071:1: entryRuleIDExpression returns [String current=null] : iv_ruleIDExpression= ruleIDExpression EOF ;
    public final String entryRuleIDExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIDExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1072:2: (iv_ruleIDExpression= ruleIDExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1073:2: iv_ruleIDExpression= ruleIDExpression EOF
            {
             newCompositeNode(grammarAccess.getIDExpressionRule()); 
            pushFollow(FOLLOW_ruleIDExpression_in_entryRuleIDExpression2235);
            iv_ruleIDExpression=ruleIDExpression();

            state._fsp--;

             current =iv_ruleIDExpression.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIDExpression2246); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIDExpression"


    // $ANTLR start "ruleIDExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1080:1: ruleIDExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_InEqID_0= ruleInEqID ( (this_OP_PLUS_1= RULE_OP_PLUS | this_OP_MINUS_2= RULE_OP_MINUS ) this_InEqID_3= ruleInEqID )+ ) ;
    public final AntlrDatatypeRuleToken ruleIDExpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_OP_PLUS_1=null;
        Token this_OP_MINUS_2=null;
        AntlrDatatypeRuleToken this_InEqID_0 = null;

        AntlrDatatypeRuleToken this_InEqID_3 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1083:28: ( (this_InEqID_0= ruleInEqID ( (this_OP_PLUS_1= RULE_OP_PLUS | this_OP_MINUS_2= RULE_OP_MINUS ) this_InEqID_3= ruleInEqID )+ ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1084:1: (this_InEqID_0= ruleInEqID ( (this_OP_PLUS_1= RULE_OP_PLUS | this_OP_MINUS_2= RULE_OP_MINUS ) this_InEqID_3= ruleInEqID )+ )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1084:1: (this_InEqID_0= ruleInEqID ( (this_OP_PLUS_1= RULE_OP_PLUS | this_OP_MINUS_2= RULE_OP_MINUS ) this_InEqID_3= ruleInEqID )+ )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1085:5: this_InEqID_0= ruleInEqID ( (this_OP_PLUS_1= RULE_OP_PLUS | this_OP_MINUS_2= RULE_OP_MINUS ) this_InEqID_3= ruleInEqID )+
            {
             
                    newCompositeNode(grammarAccess.getIDExpressionAccess().getInEqIDParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleInEqID_in_ruleIDExpression2293);
            this_InEqID_0=ruleInEqID();

            state._fsp--;


            		current.merge(this_InEqID_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1095:1: ( (this_OP_PLUS_1= RULE_OP_PLUS | this_OP_MINUS_2= RULE_OP_MINUS ) this_InEqID_3= ruleInEqID )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=RULE_OP_PLUS && LA27_0<=RULE_OP_MINUS)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1095:2: (this_OP_PLUS_1= RULE_OP_PLUS | this_OP_MINUS_2= RULE_OP_MINUS ) this_InEqID_3= ruleInEqID
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1095:2: (this_OP_PLUS_1= RULE_OP_PLUS | this_OP_MINUS_2= RULE_OP_MINUS )
            	    int alt26=2;
            	    int LA26_0 = input.LA(1);

            	    if ( (LA26_0==RULE_OP_PLUS) ) {
            	        alt26=1;
            	    }
            	    else if ( (LA26_0==RULE_OP_MINUS) ) {
            	        alt26=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 26, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt26) {
            	        case 1 :
            	            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1095:7: this_OP_PLUS_1= RULE_OP_PLUS
            	            {
            	            this_OP_PLUS_1=(Token)match(input,RULE_OP_PLUS,FOLLOW_RULE_OP_PLUS_in_ruleIDExpression2315); 

            	            		current.merge(this_OP_PLUS_1);
            	                
            	             
            	                newLeafNode(this_OP_PLUS_1, grammarAccess.getIDExpressionAccess().getOP_PLUSTerminalRuleCall_1_0_0()); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1103:10: this_OP_MINUS_2= RULE_OP_MINUS
            	            {
            	            this_OP_MINUS_2=(Token)match(input,RULE_OP_MINUS,FOLLOW_RULE_OP_MINUS_in_ruleIDExpression2341); 

            	            		current.merge(this_OP_MINUS_2);
            	                
            	             
            	                newLeafNode(this_OP_MINUS_2, grammarAccess.getIDExpressionAccess().getOP_MINUSTerminalRuleCall_1_0_1()); 
            	                

            	            }
            	            break;

            	    }

            	     
            	            newCompositeNode(grammarAccess.getIDExpressionAccess().getInEqIDParserRuleCall_1_1()); 
            	        
            	    pushFollow(FOLLOW_ruleInEqID_in_ruleIDExpression2369);
            	    this_InEqID_3=ruleInEqID();

            	    state._fsp--;


            	    		current.merge(this_InEqID_3);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIDExpression"


    // $ANTLR start "entryRuleInEqID"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1129:1: entryRuleInEqID returns [String current=null] : iv_ruleInEqID= ruleInEqID EOF ;
    public final String entryRuleInEqID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInEqID = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1130:2: (iv_ruleInEqID= ruleInEqID EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1131:2: iv_ruleInEqID= ruleInEqID EOF
            {
             newCompositeNode(grammarAccess.getInEqIDRule()); 
            pushFollow(FOLLOW_ruleInEqID_in_entryRuleInEqID2417);
            iv_ruleInEqID=ruleInEqID();

            state._fsp--;

             current =iv_ruleInEqID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInEqID2428); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInEqID"


    // $ANTLR start "ruleInEqID"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1138:1: ruleInEqID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_OP_MINUS_0= RULE_OP_MINUS )? ( (this_INT_1= RULE_INT )+ | ( (this_INT_2= RULE_INT )* this_ID_3= RULE_ID ) ) ) ;
    public final AntlrDatatypeRuleToken ruleInEqID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_OP_MINUS_0=null;
        Token this_INT_1=null;
        Token this_INT_2=null;
        Token this_ID_3=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1141:28: ( ( (this_OP_MINUS_0= RULE_OP_MINUS )? ( (this_INT_1= RULE_INT )+ | ( (this_INT_2= RULE_INT )* this_ID_3= RULE_ID ) ) ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1142:1: ( (this_OP_MINUS_0= RULE_OP_MINUS )? ( (this_INT_1= RULE_INT )+ | ( (this_INT_2= RULE_INT )* this_ID_3= RULE_ID ) ) )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1142:1: ( (this_OP_MINUS_0= RULE_OP_MINUS )? ( (this_INT_1= RULE_INT )+ | ( (this_INT_2= RULE_INT )* this_ID_3= RULE_ID ) ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1142:2: (this_OP_MINUS_0= RULE_OP_MINUS )? ( (this_INT_1= RULE_INT )+ | ( (this_INT_2= RULE_INT )* this_ID_3= RULE_ID ) )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1142:2: (this_OP_MINUS_0= RULE_OP_MINUS )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_OP_MINUS) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1142:7: this_OP_MINUS_0= RULE_OP_MINUS
                    {
                    this_OP_MINUS_0=(Token)match(input,RULE_OP_MINUS,FOLLOW_RULE_OP_MINUS_in_ruleInEqID2469); 

                    		current.merge(this_OP_MINUS_0);
                        
                     
                        newLeafNode(this_OP_MINUS_0, grammarAccess.getInEqIDAccess().getOP_MINUSTerminalRuleCall_0()); 
                        

                    }
                    break;

            }

            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1149:3: ( (this_INT_1= RULE_INT )+ | ( (this_INT_2= RULE_INT )* this_ID_3= RULE_ID ) )
            int alt31=2;
            alt31 = dfa31.predict(input);
            switch (alt31) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1149:4: (this_INT_1= RULE_INT )+
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1149:4: (this_INT_1= RULE_INT )+
                    int cnt29=0;
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==RULE_INT) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1149:9: this_INT_1= RULE_INT
                    	    {
                    	    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleInEqID2493); 

                    	    		current.merge(this_INT_1);
                    	        
                    	     
                    	        newLeafNode(this_INT_1, grammarAccess.getInEqIDAccess().getINTTerminalRuleCall_1_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt29 >= 1 ) break loop29;
                                EarlyExitException eee =
                                    new EarlyExitException(29, input);
                                throw eee;
                        }
                        cnt29++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1157:6: ( (this_INT_2= RULE_INT )* this_ID_3= RULE_ID )
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1157:6: ( (this_INT_2= RULE_INT )* this_ID_3= RULE_ID )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1157:7: (this_INT_2= RULE_INT )* this_ID_3= RULE_ID
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1157:7: (this_INT_2= RULE_INT )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==RULE_INT) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1157:12: this_INT_2= RULE_INT
                    	    {
                    	    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleInEqID2523); 

                    	    		current.merge(this_INT_2);
                    	        
                    	     
                    	        newLeafNode(this_INT_2, grammarAccess.getInEqIDAccess().getINTTerminalRuleCall_1_1_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);

                    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInEqID2545); 

                    		current.merge(this_ID_3);
                        
                     
                        newLeafNode(this_ID_3, grammarAccess.getInEqIDAccess().getIDTerminalRuleCall_1_1_1()); 
                        

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInEqID"


    // $ANTLR start "entryRuleAStandardEquation"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1179:1: entryRuleAStandardEquation returns [EObject current=null] : iv_ruleAStandardEquation= ruleAStandardEquation EOF ;
    public final EObject entryRuleAStandardEquation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAStandardEquation = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1180:2: (iv_ruleAStandardEquation= ruleAStandardEquation EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1181:2: iv_ruleAStandardEquation= ruleAStandardEquation EOF
            {
             newCompositeNode(grammarAccess.getAStandardEquationRule()); 
            pushFollow(FOLLOW_ruleAStandardEquation_in_entryRuleAStandardEquation2592);
            iv_ruleAStandardEquation=ruleAStandardEquation();

            state._fsp--;

             current =iv_ruleAStandardEquation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAStandardEquation2602); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAStandardEquation"


    // $ANTLR start "ruleAStandardEquation"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1188:1: ruleAStandardEquation returns [EObject current=null] : ( ( (lv_var_0_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_indexes_2_0= ruleAIndexList ) ) otherlv_3= ']' )? otherlv_4= '=' ( (lv_expr_5_0= ruleAAlphabetsExpression ) ) otherlv_6= ';' ) ;
    public final EObject ruleAStandardEquation() throws RecognitionException {
        EObject current = null;

        Token lv_var_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_indexes_2_0 = null;

        EObject lv_expr_5_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1191:28: ( ( ( (lv_var_0_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_indexes_2_0= ruleAIndexList ) ) otherlv_3= ']' )? otherlv_4= '=' ( (lv_expr_5_0= ruleAAlphabetsExpression ) ) otherlv_6= ';' ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1192:1: ( ( (lv_var_0_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_indexes_2_0= ruleAIndexList ) ) otherlv_3= ']' )? otherlv_4= '=' ( (lv_expr_5_0= ruleAAlphabetsExpression ) ) otherlv_6= ';' )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1192:1: ( ( (lv_var_0_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_indexes_2_0= ruleAIndexList ) ) otherlv_3= ']' )? otherlv_4= '=' ( (lv_expr_5_0= ruleAAlphabetsExpression ) ) otherlv_6= ';' )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1192:2: ( (lv_var_0_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_indexes_2_0= ruleAIndexList ) ) otherlv_3= ']' )? otherlv_4= '=' ( (lv_expr_5_0= ruleAAlphabetsExpression ) ) otherlv_6= ';'
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1192:2: ( (lv_var_0_0= RULE_ID ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1193:1: (lv_var_0_0= RULE_ID )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1193:1: (lv_var_0_0= RULE_ID )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1194:3: lv_var_0_0= RULE_ID
            {
            lv_var_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAStandardEquation2644); 

            			newLeafNode(lv_var_0_0, grammarAccess.getAStandardEquationAccess().getVarIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAStandardEquationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"var",
                    		lv_var_0_0, 
                    		"ID");
            	    

            }


            }

            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1210:2: (otherlv_1= '[' ( (lv_indexes_2_0= ruleAIndexList ) ) otherlv_3= ']' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==45) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1210:4: otherlv_1= '[' ( (lv_indexes_2_0= ruleAIndexList ) ) otherlv_3= ']'
                    {
                    otherlv_1=(Token)match(input,45,FOLLOW_45_in_ruleAStandardEquation2662); 

                        	newLeafNode(otherlv_1, grammarAccess.getAStandardEquationAccess().getLeftSquareBracketKeyword_1_0());
                        
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1214:1: ( (lv_indexes_2_0= ruleAIndexList ) )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1215:1: (lv_indexes_2_0= ruleAIndexList )
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1215:1: (lv_indexes_2_0= ruleAIndexList )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1216:3: lv_indexes_2_0= ruleAIndexList
                    {
                     
                    	        newCompositeNode(grammarAccess.getAStandardEquationAccess().getIndexesAIndexListParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAIndexList_in_ruleAStandardEquation2683);
                    lv_indexes_2_0=ruleAIndexList();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAStandardEquationRule());
                    	        }
                           		set(
                           			current, 
                           			"indexes",
                            		lv_indexes_2_0, 
                            		"AIndexList");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,46,FOLLOW_46_in_ruleAStandardEquation2695); 

                        	newLeafNode(otherlv_3, grammarAccess.getAStandardEquationAccess().getRightSquareBracketKeyword_1_2());
                        

                    }
                    break;

            }

            otherlv_4=(Token)match(input,47,FOLLOW_47_in_ruleAStandardEquation2709); 

                	newLeafNode(otherlv_4, grammarAccess.getAStandardEquationAccess().getEqualsSignKeyword_2());
                
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1240:1: ( (lv_expr_5_0= ruleAAlphabetsExpression ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1241:1: (lv_expr_5_0= ruleAAlphabetsExpression )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1241:1: (lv_expr_5_0= ruleAAlphabetsExpression )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1242:3: lv_expr_5_0= ruleAAlphabetsExpression
            {
             
            	        newCompositeNode(grammarAccess.getAStandardEquationAccess().getExprAAlphabetsExpressionParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleAStandardEquation2730);
            lv_expr_5_0=ruleAAlphabetsExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAStandardEquationRule());
            	        }
                   		set(
                   			current, 
                   			"expr",
                    		lv_expr_5_0, 
                    		"AAlphabetsExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,35,FOLLOW_35_in_ruleAStandardEquation2742); 

                	newLeafNode(otherlv_6, grammarAccess.getAStandardEquationAccess().getSemicolonKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAStandardEquation"


    // $ANTLR start "entryRuleAAlphabetsExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1270:1: entryRuleAAlphabetsExpression returns [EObject current=null] : iv_ruleAAlphabetsExpression= ruleAAlphabetsExpression EOF ;
    public final EObject entryRuleAAlphabetsExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAAlphabetsExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1271:2: (iv_ruleAAlphabetsExpression= ruleAAlphabetsExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1272:2: iv_ruleAAlphabetsExpression= ruleAAlphabetsExpression EOF
            {
             newCompositeNode(grammarAccess.getAAlphabetsExpressionRule()); 
            pushFollow(FOLLOW_ruleAAlphabetsExpression_in_entryRuleAAlphabetsExpression2778);
            iv_ruleAAlphabetsExpression=ruleAAlphabetsExpression();

            state._fsp--;

             current =iv_ruleAAlphabetsExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAAlphabetsExpression2788); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAAlphabetsExpression"


    // $ANTLR start "ruleAAlphabetsExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1279:1: ruleAAlphabetsExpression returns [EObject current=null] : (this_AIfExpression_0= ruleAIfExpression | this_ARestrictExpression_1= ruleARestrictExpression | this_AOrExpression_2= ruleAOrExpression ) ;
    public final EObject ruleAAlphabetsExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AIfExpression_0 = null;

        EObject this_ARestrictExpression_1 = null;

        EObject this_AOrExpression_2 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1282:28: ( (this_AIfExpression_0= ruleAIfExpression | this_ARestrictExpression_1= ruleARestrictExpression | this_AOrExpression_2= ruleAOrExpression ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1283:1: (this_AIfExpression_0= ruleAIfExpression | this_ARestrictExpression_1= ruleARestrictExpression | this_AOrExpression_2= ruleAOrExpression )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1283:1: (this_AIfExpression_0= ruleAIfExpression | this_ARestrictExpression_1= ruleARestrictExpression | this_AOrExpression_2= ruleAOrExpression )
            int alt33=3;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt33=1;
                }
                break;
            case 42:
                {
                alt33=2;
                }
                break;
            case RULE_ID:
            case RULE_OP_PLUS:
            case RULE_OP_MINUS:
            case RULE_INT:
            case RULE_OP_OR:
            case RULE_XOP_OR:
            case RULE_OP_AND:
            case RULE_OP_MUL:
            case RULE_OP_MIN:
            case RULE_OP_MAX:
            case RULE_BOOLEAN:
            case RULE_REAL:
            case 32:
            case 45:
            case 48:
            case 49:
            case 55:
            case 57:
                {
                alt33=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1284:5: this_AIfExpression_0= ruleAIfExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAAlphabetsExpressionAccess().getAIfExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAIfExpression_in_ruleAAlphabetsExpression2835);
                    this_AIfExpression_0=ruleAIfExpression();

                    state._fsp--;

                     
                            current = this_AIfExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1294:5: this_ARestrictExpression_1= ruleARestrictExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAAlphabetsExpressionAccess().getARestrictExpressionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleARestrictExpression_in_ruleAAlphabetsExpression2862);
                    this_ARestrictExpression_1=ruleARestrictExpression();

                    state._fsp--;

                     
                            current = this_ARestrictExpression_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1304:5: this_AOrExpression_2= ruleAOrExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAAlphabetsExpressionAccess().getAOrExpressionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleAOrExpression_in_ruleAAlphabetsExpression2889);
                    this_AOrExpression_2=ruleAOrExpression();

                    state._fsp--;

                     
                            current = this_AOrExpression_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAAlphabetsExpression"


    // $ANTLR start "entryRuleAAlphabetsTerminalExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1320:1: entryRuleAAlphabetsTerminalExpression returns [EObject current=null] : iv_ruleAAlphabetsTerminalExpression= ruleAAlphabetsTerminalExpression EOF ;
    public final EObject entryRuleAAlphabetsTerminalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAAlphabetsTerminalExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1321:2: (iv_ruleAAlphabetsTerminalExpression= ruleAAlphabetsTerminalExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1322:2: iv_ruleAAlphabetsTerminalExpression= ruleAAlphabetsTerminalExpression EOF
            {
             newCompositeNode(grammarAccess.getAAlphabetsTerminalExpressionRule()); 
            pushFollow(FOLLOW_ruleAAlphabetsTerminalExpression_in_entryRuleAAlphabetsTerminalExpression2924);
            iv_ruleAAlphabetsTerminalExpression=ruleAAlphabetsTerminalExpression();

            state._fsp--;

             current =iv_ruleAAlphabetsTerminalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAAlphabetsTerminalExpression2934); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAAlphabetsTerminalExpression"


    // $ANTLR start "ruleAAlphabetsTerminalExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1329:1: ruleAAlphabetsTerminalExpression returns [EObject current=null] : (this_AParanthesizedAlphabetsExpression_0= ruleAParanthesizedAlphabetsExpression | this_ACaseExpression_1= ruleACaseExpression | this_AReduceExpression_2= ruleAReduceExpression | this_AMultiArgExpression_3= ruleAMultiArgExpression | this_AConstantExpression_4= ruleAConstantExpression | this_AVariableExpression_5= ruleAVariableExpression | this_AIndexExpression_6= ruleAIndexExpression | this_ADependenceExpression_7= ruleADependenceExpression | this_ADependenceInArrayNotation_8= ruleADependenceInArrayNotation ) ;
    public final EObject ruleAAlphabetsTerminalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AParanthesizedAlphabetsExpression_0 = null;

        EObject this_ACaseExpression_1 = null;

        EObject this_AReduceExpression_2 = null;

        EObject this_AMultiArgExpression_3 = null;

        EObject this_AConstantExpression_4 = null;

        EObject this_AVariableExpression_5 = null;

        EObject this_AIndexExpression_6 = null;

        EObject this_ADependenceExpression_7 = null;

        EObject this_ADependenceInArrayNotation_8 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1332:28: ( (this_AParanthesizedAlphabetsExpression_0= ruleAParanthesizedAlphabetsExpression | this_ACaseExpression_1= ruleACaseExpression | this_AReduceExpression_2= ruleAReduceExpression | this_AMultiArgExpression_3= ruleAMultiArgExpression | this_AConstantExpression_4= ruleAConstantExpression | this_AVariableExpression_5= ruleAVariableExpression | this_AIndexExpression_6= ruleAIndexExpression | this_ADependenceExpression_7= ruleADependenceExpression | this_ADependenceInArrayNotation_8= ruleADependenceInArrayNotation ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1333:1: (this_AParanthesizedAlphabetsExpression_0= ruleAParanthesizedAlphabetsExpression | this_ACaseExpression_1= ruleACaseExpression | this_AReduceExpression_2= ruleAReduceExpression | this_AMultiArgExpression_3= ruleAMultiArgExpression | this_AConstantExpression_4= ruleAConstantExpression | this_AVariableExpression_5= ruleAVariableExpression | this_AIndexExpression_6= ruleAIndexExpression | this_ADependenceExpression_7= ruleADependenceExpression | this_ADependenceInArrayNotation_8= ruleADependenceInArrayNotation )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1333:1: (this_AParanthesizedAlphabetsExpression_0= ruleAParanthesizedAlphabetsExpression | this_ACaseExpression_1= ruleACaseExpression | this_AReduceExpression_2= ruleAReduceExpression | this_AMultiArgExpression_3= ruleAMultiArgExpression | this_AConstantExpression_4= ruleAConstantExpression | this_AVariableExpression_5= ruleAVariableExpression | this_AIndexExpression_6= ruleAIndexExpression | this_ADependenceExpression_7= ruleADependenceExpression | this_ADependenceInArrayNotation_8= ruleADependenceInArrayNotation )
            int alt34=9;
            alt34 = dfa34.predict(input);
            switch (alt34) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1334:5: this_AParanthesizedAlphabetsExpression_0= ruleAParanthesizedAlphabetsExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAAlphabetsTerminalExpressionAccess().getAParanthesizedAlphabetsExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAParanthesizedAlphabetsExpression_in_ruleAAlphabetsTerminalExpression2981);
                    this_AParanthesizedAlphabetsExpression_0=ruleAParanthesizedAlphabetsExpression();

                    state._fsp--;

                     
                            current = this_AParanthesizedAlphabetsExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1344:5: this_ACaseExpression_1= ruleACaseExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAAlphabetsTerminalExpressionAccess().getACaseExpressionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleACaseExpression_in_ruleAAlphabetsTerminalExpression3008);
                    this_ACaseExpression_1=ruleACaseExpression();

                    state._fsp--;

                     
                            current = this_ACaseExpression_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1354:5: this_AReduceExpression_2= ruleAReduceExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAAlphabetsTerminalExpressionAccess().getAReduceExpressionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleAReduceExpression_in_ruleAAlphabetsTerminalExpression3035);
                    this_AReduceExpression_2=ruleAReduceExpression();

                    state._fsp--;

                     
                            current = this_AReduceExpression_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1364:5: this_AMultiArgExpression_3= ruleAMultiArgExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAAlphabetsTerminalExpressionAccess().getAMultiArgExpressionParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleAMultiArgExpression_in_ruleAAlphabetsTerminalExpression3062);
                    this_AMultiArgExpression_3=ruleAMultiArgExpression();

                    state._fsp--;

                     
                            current = this_AMultiArgExpression_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1374:5: this_AConstantExpression_4= ruleAConstantExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAAlphabetsTerminalExpressionAccess().getAConstantExpressionParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleAConstantExpression_in_ruleAAlphabetsTerminalExpression3089);
                    this_AConstantExpression_4=ruleAConstantExpression();

                    state._fsp--;

                     
                            current = this_AConstantExpression_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1384:5: this_AVariableExpression_5= ruleAVariableExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAAlphabetsTerminalExpressionAccess().getAVariableExpressionParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleAVariableExpression_in_ruleAAlphabetsTerminalExpression3116);
                    this_AVariableExpression_5=ruleAVariableExpression();

                    state._fsp--;

                     
                            current = this_AVariableExpression_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1394:5: this_AIndexExpression_6= ruleAIndexExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAAlphabetsTerminalExpressionAccess().getAIndexExpressionParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleAIndexExpression_in_ruleAAlphabetsTerminalExpression3143);
                    this_AIndexExpression_6=ruleAIndexExpression();

                    state._fsp--;

                     
                            current = this_AIndexExpression_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1404:5: this_ADependenceExpression_7= ruleADependenceExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAAlphabetsTerminalExpressionAccess().getADependenceExpressionParserRuleCall_7()); 
                        
                    pushFollow(FOLLOW_ruleADependenceExpression_in_ruleAAlphabetsTerminalExpression3170);
                    this_ADependenceExpression_7=ruleADependenceExpression();

                    state._fsp--;

                     
                            current = this_ADependenceExpression_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1414:5: this_ADependenceInArrayNotation_8= ruleADependenceInArrayNotation
                    {
                     
                            newCompositeNode(grammarAccess.getAAlphabetsTerminalExpressionAccess().getADependenceInArrayNotationParserRuleCall_8()); 
                        
                    pushFollow(FOLLOW_ruleADependenceInArrayNotation_in_ruleAAlphabetsTerminalExpression3197);
                    this_ADependenceInArrayNotation_8=ruleADependenceInArrayNotation();

                    state._fsp--;

                     
                            current = this_ADependenceInArrayNotation_8; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAAlphabetsTerminalExpression"


    // $ANTLR start "entryRuleAParanthesizedAlphabetsExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1430:1: entryRuleAParanthesizedAlphabetsExpression returns [EObject current=null] : iv_ruleAParanthesizedAlphabetsExpression= ruleAParanthesizedAlphabetsExpression EOF ;
    public final EObject entryRuleAParanthesizedAlphabetsExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAParanthesizedAlphabetsExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1431:2: (iv_ruleAParanthesizedAlphabetsExpression= ruleAParanthesizedAlphabetsExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1432:2: iv_ruleAParanthesizedAlphabetsExpression= ruleAParanthesizedAlphabetsExpression EOF
            {
             newCompositeNode(grammarAccess.getAParanthesizedAlphabetsExpressionRule()); 
            pushFollow(FOLLOW_ruleAParanthesizedAlphabetsExpression_in_entryRuleAParanthesizedAlphabetsExpression3232);
            iv_ruleAParanthesizedAlphabetsExpression=ruleAParanthesizedAlphabetsExpression();

            state._fsp--;

             current =iv_ruleAParanthesizedAlphabetsExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAParanthesizedAlphabetsExpression3242); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAParanthesizedAlphabetsExpression"


    // $ANTLR start "ruleAParanthesizedAlphabetsExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1439:1: ruleAParanthesizedAlphabetsExpression returns [EObject current=null] : (otherlv_0= '(' this_AAlphabetsExpression_1= ruleAAlphabetsExpression otherlv_2= ')' ) ;
    public final EObject ruleAParanthesizedAlphabetsExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_AAlphabetsExpression_1 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1442:28: ( (otherlv_0= '(' this_AAlphabetsExpression_1= ruleAAlphabetsExpression otherlv_2= ')' ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1443:1: (otherlv_0= '(' this_AAlphabetsExpression_1= ruleAAlphabetsExpression otherlv_2= ')' )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1443:1: (otherlv_0= '(' this_AAlphabetsExpression_1= ruleAAlphabetsExpression otherlv_2= ')' )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1443:3: otherlv_0= '(' this_AAlphabetsExpression_1= ruleAAlphabetsExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleAParanthesizedAlphabetsExpression3279); 

                	newLeafNode(otherlv_0, grammarAccess.getAParanthesizedAlphabetsExpressionAccess().getLeftParenthesisKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getAParanthesizedAlphabetsExpressionAccess().getAAlphabetsExpressionParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleAParanthesizedAlphabetsExpression3301);
            this_AAlphabetsExpression_1=ruleAAlphabetsExpression();

            state._fsp--;

             
                    current = this_AAlphabetsExpression_1; 
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleAParanthesizedAlphabetsExpression3312); 

                	newLeafNode(otherlv_2, grammarAccess.getAParanthesizedAlphabetsExpressionAccess().getRightParenthesisKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAParanthesizedAlphabetsExpression"


    // $ANTLR start "entryRuleAOrExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1468:1: entryRuleAOrExpression returns [EObject current=null] : iv_ruleAOrExpression= ruleAOrExpression EOF ;
    public final EObject entryRuleAOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAOrExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1469:2: (iv_ruleAOrExpression= ruleAOrExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1470:2: iv_ruleAOrExpression= ruleAOrExpression EOF
            {
             newCompositeNode(grammarAccess.getAOrExpressionRule()); 
            pushFollow(FOLLOW_ruleAOrExpression_in_entryRuleAOrExpression3348);
            iv_ruleAOrExpression=ruleAOrExpression();

            state._fsp--;

             current =iv_ruleAOrExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAOrExpression3358); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAOrExpression"


    // $ANTLR start "ruleAOrExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1477:1: ruleAOrExpression returns [EObject current=null] : (this_AAndExpression_0= ruleAAndExpression ( () ( ( (lv_operator_2_1= RULE_OP_OR | lv_operator_2_2= RULE_XOP_OR ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )* ) ;
    public final EObject ruleAOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_AAndExpression_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1480:28: ( (this_AAndExpression_0= ruleAAndExpression ( () ( ( (lv_operator_2_1= RULE_OP_OR | lv_operator_2_2= RULE_XOP_OR ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )* ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1481:1: (this_AAndExpression_0= ruleAAndExpression ( () ( ( (lv_operator_2_1= RULE_OP_OR | lv_operator_2_2= RULE_XOP_OR ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )* )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1481:1: (this_AAndExpression_0= ruleAAndExpression ( () ( ( (lv_operator_2_1= RULE_OP_OR | lv_operator_2_2= RULE_XOP_OR ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )* )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1482:5: this_AAndExpression_0= ruleAAndExpression ( () ( ( (lv_operator_2_1= RULE_OP_OR | lv_operator_2_2= RULE_XOP_OR ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAOrExpressionAccess().getAAndExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleAAndExpression_in_ruleAOrExpression3405);
            this_AAndExpression_0=ruleAAndExpression();

            state._fsp--;

             
                    current = this_AAndExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1490:1: ( () ( ( (lv_operator_2_1= RULE_OP_OR | lv_operator_2_2= RULE_XOP_OR ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=RULE_OP_OR && LA36_0<=RULE_XOP_OR)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1490:2: () ( ( (lv_operator_2_1= RULE_OP_OR | lv_operator_2_2= RULE_XOP_OR ) ) ) ( (lv_right_3_0= ruleAAndExpression ) )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1490:2: ()
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1491:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getAOrExpressionAccess().getAOrExpressionLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1496:2: ( ( (lv_operator_2_1= RULE_OP_OR | lv_operator_2_2= RULE_XOP_OR ) ) )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1497:1: ( (lv_operator_2_1= RULE_OP_OR | lv_operator_2_2= RULE_XOP_OR ) )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1497:1: ( (lv_operator_2_1= RULE_OP_OR | lv_operator_2_2= RULE_XOP_OR ) )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1498:1: (lv_operator_2_1= RULE_OP_OR | lv_operator_2_2= RULE_XOP_OR )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1498:1: (lv_operator_2_1= RULE_OP_OR | lv_operator_2_2= RULE_XOP_OR )
            	    int alt35=2;
            	    int LA35_0 = input.LA(1);

            	    if ( (LA35_0==RULE_OP_OR) ) {
            	        alt35=1;
            	    }
            	    else if ( (LA35_0==RULE_XOP_OR) ) {
            	        alt35=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 35, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt35) {
            	        case 1 :
            	            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1499:3: lv_operator_2_1= RULE_OP_OR
            	            {
            	            lv_operator_2_1=(Token)match(input,RULE_OP_OR,FOLLOW_RULE_OP_OR_in_ruleAOrExpression3433); 

            	            			newLeafNode(lv_operator_2_1, grammarAccess.getAOrExpressionAccess().getOperatorOP_ORTerminalRuleCall_1_1_0_0()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAOrExpressionRule());
            	            	        }
            	                   		setWithLastConsumed(
            	                   			current, 
            	                   			"operator",
            	                    		lv_operator_2_1, 
            	                    		"OP_OR");
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1514:8: lv_operator_2_2= RULE_XOP_OR
            	            {
            	            lv_operator_2_2=(Token)match(input,RULE_XOP_OR,FOLLOW_RULE_XOP_OR_in_ruleAOrExpression3453); 

            	            			newLeafNode(lv_operator_2_2, grammarAccess.getAOrExpressionAccess().getOperatorXOP_ORTerminalRuleCall_1_1_0_1()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAOrExpressionRule());
            	            	        }
            	                   		setWithLastConsumed(
            	                   			current, 
            	                   			"operator",
            	                    		lv_operator_2_2, 
            	                    		"XOP_OR");
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1532:2: ( (lv_right_3_0= ruleAAndExpression ) )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1533:1: (lv_right_3_0= ruleAAndExpression )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1533:1: (lv_right_3_0= ruleAAndExpression )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1534:3: lv_right_3_0= ruleAAndExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAOrExpressionAccess().getRightAAndExpressionParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAAndExpression_in_ruleAOrExpression3482);
            	    lv_right_3_0=ruleAAndExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAOrExpressionRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"AAndExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAOrExpression"


    // $ANTLR start "entryRuleAAndExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1558:1: entryRuleAAndExpression returns [EObject current=null] : iv_ruleAAndExpression= ruleAAndExpression EOF ;
    public final EObject entryRuleAAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAAndExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1559:2: (iv_ruleAAndExpression= ruleAAndExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1560:2: iv_ruleAAndExpression= ruleAAndExpression EOF
            {
             newCompositeNode(grammarAccess.getAAndExpressionRule()); 
            pushFollow(FOLLOW_ruleAAndExpression_in_entryRuleAAndExpression3520);
            iv_ruleAAndExpression=ruleAAndExpression();

            state._fsp--;

             current =iv_ruleAAndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAAndExpression3530); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAAndExpression"


    // $ANTLR start "ruleAAndExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1567:1: ruleAAndExpression returns [EObject current=null] : (this_ARelationalExpression_0= ruleARelationalExpression ( () ( ( (lv_operator_2_1= RULE_OP_AND | lv_operator_2_2= RULE_OP_NAND ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )* ) ;
    public final EObject ruleAAndExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_ARelationalExpression_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1570:28: ( (this_ARelationalExpression_0= ruleARelationalExpression ( () ( ( (lv_operator_2_1= RULE_OP_AND | lv_operator_2_2= RULE_OP_NAND ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )* ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1571:1: (this_ARelationalExpression_0= ruleARelationalExpression ( () ( ( (lv_operator_2_1= RULE_OP_AND | lv_operator_2_2= RULE_OP_NAND ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )* )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1571:1: (this_ARelationalExpression_0= ruleARelationalExpression ( () ( ( (lv_operator_2_1= RULE_OP_AND | lv_operator_2_2= RULE_OP_NAND ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )* )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1572:5: this_ARelationalExpression_0= ruleARelationalExpression ( () ( ( (lv_operator_2_1= RULE_OP_AND | lv_operator_2_2= RULE_OP_NAND ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAAndExpressionAccess().getARelationalExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleARelationalExpression_in_ruleAAndExpression3577);
            this_ARelationalExpression_0=ruleARelationalExpression();

            state._fsp--;

             
                    current = this_ARelationalExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1580:1: ( () ( ( (lv_operator_2_1= RULE_OP_AND | lv_operator_2_2= RULE_OP_NAND ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=RULE_OP_AND && LA38_0<=RULE_OP_NAND)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1580:2: () ( ( (lv_operator_2_1= RULE_OP_AND | lv_operator_2_2= RULE_OP_NAND ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1580:2: ()
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1581:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getAAndExpressionAccess().getAAndExpressionLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1586:2: ( ( (lv_operator_2_1= RULE_OP_AND | lv_operator_2_2= RULE_OP_NAND ) ) )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1587:1: ( (lv_operator_2_1= RULE_OP_AND | lv_operator_2_2= RULE_OP_NAND ) )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1587:1: ( (lv_operator_2_1= RULE_OP_AND | lv_operator_2_2= RULE_OP_NAND ) )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1588:1: (lv_operator_2_1= RULE_OP_AND | lv_operator_2_2= RULE_OP_NAND )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1588:1: (lv_operator_2_1= RULE_OP_AND | lv_operator_2_2= RULE_OP_NAND )
            	    int alt37=2;
            	    int LA37_0 = input.LA(1);

            	    if ( (LA37_0==RULE_OP_AND) ) {
            	        alt37=1;
            	    }
            	    else if ( (LA37_0==RULE_OP_NAND) ) {
            	        alt37=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 37, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt37) {
            	        case 1 :
            	            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1589:3: lv_operator_2_1= RULE_OP_AND
            	            {
            	            lv_operator_2_1=(Token)match(input,RULE_OP_AND,FOLLOW_RULE_OP_AND_in_ruleAAndExpression3605); 

            	            			newLeafNode(lv_operator_2_1, grammarAccess.getAAndExpressionAccess().getOperatorOP_ANDTerminalRuleCall_1_1_0_0()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAAndExpressionRule());
            	            	        }
            	                   		setWithLastConsumed(
            	                   			current, 
            	                   			"operator",
            	                    		lv_operator_2_1, 
            	                    		"OP_AND");
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1604:8: lv_operator_2_2= RULE_OP_NAND
            	            {
            	            lv_operator_2_2=(Token)match(input,RULE_OP_NAND,FOLLOW_RULE_OP_NAND_in_ruleAAndExpression3625); 

            	            			newLeafNode(lv_operator_2_2, grammarAccess.getAAndExpressionAccess().getOperatorOP_NANDTerminalRuleCall_1_1_0_1()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAAndExpressionRule());
            	            	        }
            	                   		setWithLastConsumed(
            	                   			current, 
            	                   			"operator",
            	                    		lv_operator_2_2, 
            	                    		"OP_NAND");
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1622:2: ( (lv_right_3_0= ruleARelationalExpression ) )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1623:1: (lv_right_3_0= ruleARelationalExpression )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1623:1: (lv_right_3_0= ruleARelationalExpression )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1624:3: lv_right_3_0= ruleARelationalExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAAndExpressionAccess().getRightARelationalExpressionParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleARelationalExpression_in_ruleAAndExpression3654);
            	    lv_right_3_0=ruleARelationalExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAAndExpressionRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"ARelationalExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAAndExpression"


    // $ANTLR start "entryRuleARelationalExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1648:1: entryRuleARelationalExpression returns [EObject current=null] : iv_ruleARelationalExpression= ruleARelationalExpression EOF ;
    public final EObject entryRuleARelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleARelationalExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1649:2: (iv_ruleARelationalExpression= ruleARelationalExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1650:2: iv_ruleARelationalExpression= ruleARelationalExpression EOF
            {
             newCompositeNode(grammarAccess.getARelationalExpressionRule()); 
            pushFollow(FOLLOW_ruleARelationalExpression_in_entryRuleARelationalExpression3692);
            iv_ruleARelationalExpression=ruleARelationalExpression();

            state._fsp--;

             current =iv_ruleARelationalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleARelationalExpression3702); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleARelationalExpression"


    // $ANTLR start "ruleARelationalExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1657:1: ruleARelationalExpression returns [EObject current=null] : (this_AAdditiveExpression_0= ruleAAdditiveExpression ( () ( (lv_operator_2_0= ruleRelationalOp ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )* ) ;
    public final EObject ruleARelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AAdditiveExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1660:28: ( (this_AAdditiveExpression_0= ruleAAdditiveExpression ( () ( (lv_operator_2_0= ruleRelationalOp ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )* ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1661:1: (this_AAdditiveExpression_0= ruleAAdditiveExpression ( () ( (lv_operator_2_0= ruleRelationalOp ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )* )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1661:1: (this_AAdditiveExpression_0= ruleAAdditiveExpression ( () ( (lv_operator_2_0= ruleRelationalOp ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )* )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1662:5: this_AAdditiveExpression_0= ruleAAdditiveExpression ( () ( (lv_operator_2_0= ruleRelationalOp ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getARelationalExpressionAccess().getAAdditiveExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleAAdditiveExpression_in_ruleARelationalExpression3749);
            this_AAdditiveExpression_0=ruleAAdditiveExpression();

            state._fsp--;

             
                    current = this_AAdditiveExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1670:1: ( () ( (lv_operator_2_0= ruleRelationalOp ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( ((LA39_0>=RULE_OP_EQ && LA39_0<=RULE_OP_NE)) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1670:2: () ( (lv_operator_2_0= ruleRelationalOp ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1670:2: ()
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1671:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getARelationalExpressionAccess().getARelationalExpressionLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1676:2: ( (lv_operator_2_0= ruleRelationalOp ) )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1677:1: (lv_operator_2_0= ruleRelationalOp )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1677:1: (lv_operator_2_0= ruleRelationalOp )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1678:3: lv_operator_2_0= ruleRelationalOp
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getARelationalExpressionAccess().getOperatorRelationalOpParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRelationalOp_in_ruleARelationalExpression3779);
            	    lv_operator_2_0=ruleRelationalOp();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getARelationalExpressionRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"operator",
            	            		lv_operator_2_0, 
            	            		"RelationalOp");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1694:2: ( (lv_right_3_0= ruleAAdditiveExpression ) )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1695:1: (lv_right_3_0= ruleAAdditiveExpression )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1695:1: (lv_right_3_0= ruleAAdditiveExpression )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1696:3: lv_right_3_0= ruleAAdditiveExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getARelationalExpressionAccess().getRightAAdditiveExpressionParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAAdditiveExpression_in_ruleARelationalExpression3800);
            	    lv_right_3_0=ruleAAdditiveExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getARelationalExpressionRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"AAdditiveExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleARelationalExpression"


    // $ANTLR start "entryRuleAAdditiveExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1720:1: entryRuleAAdditiveExpression returns [EObject current=null] : iv_ruleAAdditiveExpression= ruleAAdditiveExpression EOF ;
    public final EObject entryRuleAAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAAdditiveExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1721:2: (iv_ruleAAdditiveExpression= ruleAAdditiveExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1722:2: iv_ruleAAdditiveExpression= ruleAAdditiveExpression EOF
            {
             newCompositeNode(grammarAccess.getAAdditiveExpressionRule()); 
            pushFollow(FOLLOW_ruleAAdditiveExpression_in_entryRuleAAdditiveExpression3838);
            iv_ruleAAdditiveExpression=ruleAAdditiveExpression();

            state._fsp--;

             current =iv_ruleAAdditiveExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAAdditiveExpression3848); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAAdditiveExpression"


    // $ANTLR start "ruleAAdditiveExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1729:1: ruleAAdditiveExpression returns [EObject current=null] : (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( () ( ( (lv_op_2_1= RULE_OP_PLUS | lv_op_2_2= RULE_OP_MINUS ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_AMultiplicativeExpression_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1732:28: ( (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( () ( ( (lv_op_2_1= RULE_OP_PLUS | lv_op_2_2= RULE_OP_MINUS ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )* ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1733:1: (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( () ( ( (lv_op_2_1= RULE_OP_PLUS | lv_op_2_2= RULE_OP_MINUS ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )* )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1733:1: (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( () ( ( (lv_op_2_1= RULE_OP_PLUS | lv_op_2_2= RULE_OP_MINUS ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )* )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1734:5: this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( () ( ( (lv_op_2_1= RULE_OP_PLUS | lv_op_2_2= RULE_OP_MINUS ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getAMultiplicativeExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleAMultiplicativeExpression_in_ruleAAdditiveExpression3895);
            this_AMultiplicativeExpression_0=ruleAMultiplicativeExpression();

            state._fsp--;

             
                    current = this_AMultiplicativeExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1742:1: ( () ( ( (lv_op_2_1= RULE_OP_PLUS | lv_op_2_2= RULE_OP_MINUS ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( ((LA41_0>=RULE_OP_PLUS && LA41_0<=RULE_OP_MINUS)) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1742:2: () ( ( (lv_op_2_1= RULE_OP_PLUS | lv_op_2_2= RULE_OP_MINUS ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1742:2: ()
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1743:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getAAdditiveExpressionAccess().getAAdditiveExpressionLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1748:2: ( ( (lv_op_2_1= RULE_OP_PLUS | lv_op_2_2= RULE_OP_MINUS ) ) )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1749:1: ( (lv_op_2_1= RULE_OP_PLUS | lv_op_2_2= RULE_OP_MINUS ) )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1749:1: ( (lv_op_2_1= RULE_OP_PLUS | lv_op_2_2= RULE_OP_MINUS ) )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1750:1: (lv_op_2_1= RULE_OP_PLUS | lv_op_2_2= RULE_OP_MINUS )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1750:1: (lv_op_2_1= RULE_OP_PLUS | lv_op_2_2= RULE_OP_MINUS )
            	    int alt40=2;
            	    int LA40_0 = input.LA(1);

            	    if ( (LA40_0==RULE_OP_PLUS) ) {
            	        alt40=1;
            	    }
            	    else if ( (LA40_0==RULE_OP_MINUS) ) {
            	        alt40=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 40, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt40) {
            	        case 1 :
            	            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1751:3: lv_op_2_1= RULE_OP_PLUS
            	            {
            	            lv_op_2_1=(Token)match(input,RULE_OP_PLUS,FOLLOW_RULE_OP_PLUS_in_ruleAAdditiveExpression3923); 

            	            			newLeafNode(lv_op_2_1, grammarAccess.getAAdditiveExpressionAccess().getOpOP_PLUSTerminalRuleCall_1_1_0_0()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAAdditiveExpressionRule());
            	            	        }
            	                   		setWithLastConsumed(
            	                   			current, 
            	                   			"op",
            	                    		lv_op_2_1, 
            	                    		"OP_PLUS");
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1766:8: lv_op_2_2= RULE_OP_MINUS
            	            {
            	            lv_op_2_2=(Token)match(input,RULE_OP_MINUS,FOLLOW_RULE_OP_MINUS_in_ruleAAdditiveExpression3943); 

            	            			newLeafNode(lv_op_2_2, grammarAccess.getAAdditiveExpressionAccess().getOpOP_MINUSTerminalRuleCall_1_1_0_1()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAAdditiveExpressionRule());
            	            	        }
            	                   		setWithLastConsumed(
            	                   			current, 
            	                   			"op",
            	                    		lv_op_2_2, 
            	                    		"OP_MINUS");
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1784:2: ( (lv_right_3_0= ruleAMultiplicativeExpression ) )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1785:1: (lv_right_3_0= ruleAMultiplicativeExpression )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1785:1: (lv_right_3_0= ruleAMultiplicativeExpression )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1786:3: lv_right_3_0= ruleAMultiplicativeExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getRightAMultiplicativeExpressionParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAMultiplicativeExpression_in_ruleAAdditiveExpression3972);
            	    lv_right_3_0=ruleAMultiplicativeExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAAdditiveExpressionRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"AMultiplicativeExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAAdditiveExpression"


    // $ANTLR start "entryRuleAMultiplicativeExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1810:1: entryRuleAMultiplicativeExpression returns [EObject current=null] : iv_ruleAMultiplicativeExpression= ruleAMultiplicativeExpression EOF ;
    public final EObject entryRuleAMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAMultiplicativeExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1811:2: (iv_ruleAMultiplicativeExpression= ruleAMultiplicativeExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1812:2: iv_ruleAMultiplicativeExpression= ruleAMultiplicativeExpression EOF
            {
             newCompositeNode(grammarAccess.getAMultiplicativeExpressionRule()); 
            pushFollow(FOLLOW_ruleAMultiplicativeExpression_in_entryRuleAMultiplicativeExpression4010);
            iv_ruleAMultiplicativeExpression=ruleAMultiplicativeExpression();

            state._fsp--;

             current =iv_ruleAMultiplicativeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAMultiplicativeExpression4020); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAMultiplicativeExpression"


    // $ANTLR start "ruleAMultiplicativeExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1819:1: ruleAMultiplicativeExpression returns [EObject current=null] : (this_AMinMaxExpression_0= ruleAMinMaxExpression ( () ( ( (lv_op_2_1= RULE_OP_MUL | lv_op_2_2= RULE_OP_DIV ) ) ) ( (lv_right_3_0= ruleAMinMaxExpression ) ) )* ) ;
    public final EObject ruleAMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_AMinMaxExpression_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1822:28: ( (this_AMinMaxExpression_0= ruleAMinMaxExpression ( () ( ( (lv_op_2_1= RULE_OP_MUL | lv_op_2_2= RULE_OP_DIV ) ) ) ( (lv_right_3_0= ruleAMinMaxExpression ) ) )* ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1823:1: (this_AMinMaxExpression_0= ruleAMinMaxExpression ( () ( ( (lv_op_2_1= RULE_OP_MUL | lv_op_2_2= RULE_OP_DIV ) ) ) ( (lv_right_3_0= ruleAMinMaxExpression ) ) )* )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1823:1: (this_AMinMaxExpression_0= ruleAMinMaxExpression ( () ( ( (lv_op_2_1= RULE_OP_MUL | lv_op_2_2= RULE_OP_DIV ) ) ) ( (lv_right_3_0= ruleAMinMaxExpression ) ) )* )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1824:5: this_AMinMaxExpression_0= ruleAMinMaxExpression ( () ( ( (lv_op_2_1= RULE_OP_MUL | lv_op_2_2= RULE_OP_DIV ) ) ) ( (lv_right_3_0= ruleAMinMaxExpression ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getAMinMaxExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleAMinMaxExpression_in_ruleAMultiplicativeExpression4067);
            this_AMinMaxExpression_0=ruleAMinMaxExpression();

            state._fsp--;

             
                    current = this_AMinMaxExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1832:1: ( () ( ( (lv_op_2_1= RULE_OP_MUL | lv_op_2_2= RULE_OP_DIV ) ) ) ( (lv_right_3_0= ruleAMinMaxExpression ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( ((LA43_0>=RULE_OP_MUL && LA43_0<=RULE_OP_DIV)) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1832:2: () ( ( (lv_op_2_1= RULE_OP_MUL | lv_op_2_2= RULE_OP_DIV ) ) ) ( (lv_right_3_0= ruleAMinMaxExpression ) )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1832:2: ()
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1833:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getAMultiplicativeExpressionAccess().getAMultiplicativeExpressionLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1838:2: ( ( (lv_op_2_1= RULE_OP_MUL | lv_op_2_2= RULE_OP_DIV ) ) )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1839:1: ( (lv_op_2_1= RULE_OP_MUL | lv_op_2_2= RULE_OP_DIV ) )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1839:1: ( (lv_op_2_1= RULE_OP_MUL | lv_op_2_2= RULE_OP_DIV ) )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1840:1: (lv_op_2_1= RULE_OP_MUL | lv_op_2_2= RULE_OP_DIV )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1840:1: (lv_op_2_1= RULE_OP_MUL | lv_op_2_2= RULE_OP_DIV )
            	    int alt42=2;
            	    int LA42_0 = input.LA(1);

            	    if ( (LA42_0==RULE_OP_MUL) ) {
            	        alt42=1;
            	    }
            	    else if ( (LA42_0==RULE_OP_DIV) ) {
            	        alt42=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 42, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt42) {
            	        case 1 :
            	            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1841:3: lv_op_2_1= RULE_OP_MUL
            	            {
            	            lv_op_2_1=(Token)match(input,RULE_OP_MUL,FOLLOW_RULE_OP_MUL_in_ruleAMultiplicativeExpression4095); 

            	            			newLeafNode(lv_op_2_1, grammarAccess.getAMultiplicativeExpressionAccess().getOpOP_MULTerminalRuleCall_1_1_0_0()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAMultiplicativeExpressionRule());
            	            	        }
            	                   		setWithLastConsumed(
            	                   			current, 
            	                   			"op",
            	                    		lv_op_2_1, 
            	                    		"OP_MUL");
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1856:8: lv_op_2_2= RULE_OP_DIV
            	            {
            	            lv_op_2_2=(Token)match(input,RULE_OP_DIV,FOLLOW_RULE_OP_DIV_in_ruleAMultiplicativeExpression4115); 

            	            			newLeafNode(lv_op_2_2, grammarAccess.getAMultiplicativeExpressionAccess().getOpOP_DIVTerminalRuleCall_1_1_0_1()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAMultiplicativeExpressionRule());
            	            	        }
            	                   		setWithLastConsumed(
            	                   			current, 
            	                   			"op",
            	                    		lv_op_2_2, 
            	                    		"OP_DIV");
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1874:2: ( (lv_right_3_0= ruleAMinMaxExpression ) )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1875:1: (lv_right_3_0= ruleAMinMaxExpression )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1875:1: (lv_right_3_0= ruleAMinMaxExpression )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1876:3: lv_right_3_0= ruleAMinMaxExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getRightAMinMaxExpressionParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAMinMaxExpression_in_ruleAMultiplicativeExpression4144);
            	    lv_right_3_0=ruleAMinMaxExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAMultiplicativeExpressionRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"AMinMaxExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAMultiplicativeExpression"


    // $ANTLR start "entryRuleAMinMaxExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1900:1: entryRuleAMinMaxExpression returns [EObject current=null] : iv_ruleAMinMaxExpression= ruleAMinMaxExpression EOF ;
    public final EObject entryRuleAMinMaxExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAMinMaxExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1901:2: (iv_ruleAMinMaxExpression= ruleAMinMaxExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1902:2: iv_ruleAMinMaxExpression= ruleAMinMaxExpression EOF
            {
             newCompositeNode(grammarAccess.getAMinMaxExpressionRule()); 
            pushFollow(FOLLOW_ruleAMinMaxExpression_in_entryRuleAMinMaxExpression4182);
            iv_ruleAMinMaxExpression=ruleAMinMaxExpression();

            state._fsp--;

             current =iv_ruleAMinMaxExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAMinMaxExpression4192); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAMinMaxExpression"


    // $ANTLR start "ruleAMinMaxExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1909:1: ruleAMinMaxExpression returns [EObject current=null] : (this_AUnaryOrTerminalExpression_0= ruleAUnaryOrTerminalExpression ( () ( ( (lv_op_2_1= RULE_OP_MIN | lv_op_2_2= RULE_OP_MAX ) ) ) ( (lv_right_3_0= ruleAUnaryOrTerminalExpression ) ) )* ) ;
    public final EObject ruleAMinMaxExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_AUnaryOrTerminalExpression_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1912:28: ( (this_AUnaryOrTerminalExpression_0= ruleAUnaryOrTerminalExpression ( () ( ( (lv_op_2_1= RULE_OP_MIN | lv_op_2_2= RULE_OP_MAX ) ) ) ( (lv_right_3_0= ruleAUnaryOrTerminalExpression ) ) )* ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1913:1: (this_AUnaryOrTerminalExpression_0= ruleAUnaryOrTerminalExpression ( () ( ( (lv_op_2_1= RULE_OP_MIN | lv_op_2_2= RULE_OP_MAX ) ) ) ( (lv_right_3_0= ruleAUnaryOrTerminalExpression ) ) )* )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1913:1: (this_AUnaryOrTerminalExpression_0= ruleAUnaryOrTerminalExpression ( () ( ( (lv_op_2_1= RULE_OP_MIN | lv_op_2_2= RULE_OP_MAX ) ) ) ( (lv_right_3_0= ruleAUnaryOrTerminalExpression ) ) )* )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1914:5: this_AUnaryOrTerminalExpression_0= ruleAUnaryOrTerminalExpression ( () ( ( (lv_op_2_1= RULE_OP_MIN | lv_op_2_2= RULE_OP_MAX ) ) ) ( (lv_right_3_0= ruleAUnaryOrTerminalExpression ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAMinMaxExpressionAccess().getAUnaryOrTerminalExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleAUnaryOrTerminalExpression_in_ruleAMinMaxExpression4239);
            this_AUnaryOrTerminalExpression_0=ruleAUnaryOrTerminalExpression();

            state._fsp--;

             
                    current = this_AUnaryOrTerminalExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1922:1: ( () ( ( (lv_op_2_1= RULE_OP_MIN | lv_op_2_2= RULE_OP_MAX ) ) ) ( (lv_right_3_0= ruleAUnaryOrTerminalExpression ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( ((LA45_0>=RULE_OP_MIN && LA45_0<=RULE_OP_MAX)) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1922:2: () ( ( (lv_op_2_1= RULE_OP_MIN | lv_op_2_2= RULE_OP_MAX ) ) ) ( (lv_right_3_0= ruleAUnaryOrTerminalExpression ) )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1922:2: ()
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1923:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getAMinMaxExpressionAccess().getAMinMaxExpressionLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1928:2: ( ( (lv_op_2_1= RULE_OP_MIN | lv_op_2_2= RULE_OP_MAX ) ) )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1929:1: ( (lv_op_2_1= RULE_OP_MIN | lv_op_2_2= RULE_OP_MAX ) )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1929:1: ( (lv_op_2_1= RULE_OP_MIN | lv_op_2_2= RULE_OP_MAX ) )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1930:1: (lv_op_2_1= RULE_OP_MIN | lv_op_2_2= RULE_OP_MAX )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1930:1: (lv_op_2_1= RULE_OP_MIN | lv_op_2_2= RULE_OP_MAX )
            	    int alt44=2;
            	    int LA44_0 = input.LA(1);

            	    if ( (LA44_0==RULE_OP_MIN) ) {
            	        alt44=1;
            	    }
            	    else if ( (LA44_0==RULE_OP_MAX) ) {
            	        alt44=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 44, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt44) {
            	        case 1 :
            	            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1931:3: lv_op_2_1= RULE_OP_MIN
            	            {
            	            lv_op_2_1=(Token)match(input,RULE_OP_MIN,FOLLOW_RULE_OP_MIN_in_ruleAMinMaxExpression4267); 

            	            			newLeafNode(lv_op_2_1, grammarAccess.getAMinMaxExpressionAccess().getOpOP_MINTerminalRuleCall_1_1_0_0()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAMinMaxExpressionRule());
            	            	        }
            	                   		setWithLastConsumed(
            	                   			current, 
            	                   			"op",
            	                    		lv_op_2_1, 
            	                    		"OP_MIN");
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1946:8: lv_op_2_2= RULE_OP_MAX
            	            {
            	            lv_op_2_2=(Token)match(input,RULE_OP_MAX,FOLLOW_RULE_OP_MAX_in_ruleAMinMaxExpression4287); 

            	            			newLeafNode(lv_op_2_2, grammarAccess.getAMinMaxExpressionAccess().getOpOP_MAXTerminalRuleCall_1_1_0_1()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAMinMaxExpressionRule());
            	            	        }
            	                   		setWithLastConsumed(
            	                   			current, 
            	                   			"op",
            	                    		lv_op_2_2, 
            	                    		"OP_MAX");
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1964:2: ( (lv_right_3_0= ruleAUnaryOrTerminalExpression ) )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1965:1: (lv_right_3_0= ruleAUnaryOrTerminalExpression )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1965:1: (lv_right_3_0= ruleAUnaryOrTerminalExpression )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1966:3: lv_right_3_0= ruleAUnaryOrTerminalExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAMinMaxExpressionAccess().getRightAUnaryOrTerminalExpressionParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAUnaryOrTerminalExpression_in_ruleAMinMaxExpression4316);
            	    lv_right_3_0=ruleAUnaryOrTerminalExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAMinMaxExpressionRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"AUnaryOrTerminalExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAMinMaxExpression"


    // $ANTLR start "entryRuleAUnaryOrTerminalExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1990:1: entryRuleAUnaryOrTerminalExpression returns [EObject current=null] : iv_ruleAUnaryOrTerminalExpression= ruleAUnaryOrTerminalExpression EOF ;
    public final EObject entryRuleAUnaryOrTerminalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAUnaryOrTerminalExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1991:2: (iv_ruleAUnaryOrTerminalExpression= ruleAUnaryOrTerminalExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1992:2: iv_ruleAUnaryOrTerminalExpression= ruleAUnaryOrTerminalExpression EOF
            {
             newCompositeNode(grammarAccess.getAUnaryOrTerminalExpressionRule()); 
            pushFollow(FOLLOW_ruleAUnaryOrTerminalExpression_in_entryRuleAUnaryOrTerminalExpression4354);
            iv_ruleAUnaryOrTerminalExpression=ruleAUnaryOrTerminalExpression();

            state._fsp--;

             current =iv_ruleAUnaryOrTerminalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAUnaryOrTerminalExpression4364); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAUnaryOrTerminalExpression"


    // $ANTLR start "ruleAUnaryOrTerminalExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1999:1: ruleAUnaryOrTerminalExpression returns [EObject current=null] : (this_AUnaryExpression_0= ruleAUnaryExpression | this_AAlphabetsTerminalExpression_1= ruleAAlphabetsTerminalExpression ) ;
    public final EObject ruleAUnaryOrTerminalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AUnaryExpression_0 = null;

        EObject this_AAlphabetsTerminalExpression_1 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2002:28: ( (this_AUnaryExpression_0= ruleAUnaryExpression | this_AAlphabetsTerminalExpression_1= ruleAAlphabetsTerminalExpression ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2003:1: (this_AUnaryExpression_0= ruleAUnaryExpression | this_AAlphabetsTerminalExpression_1= ruleAAlphabetsTerminalExpression )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2003:1: (this_AUnaryExpression_0= ruleAUnaryExpression | this_AAlphabetsTerminalExpression_1= ruleAAlphabetsTerminalExpression )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_OP_MINUS||LA46_0==48) ) {
                alt46=1;
            }
            else if ( (LA46_0==RULE_ID||LA46_0==RULE_OP_PLUS||(LA46_0>=RULE_INT && LA46_0<=RULE_OP_AND)||LA46_0==RULE_OP_MUL||(LA46_0>=RULE_OP_MIN && LA46_0<=RULE_REAL)||LA46_0==32||LA46_0==45||LA46_0==49||LA46_0==55||LA46_0==57) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2004:5: this_AUnaryExpression_0= ruleAUnaryExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAUnaryOrTerminalExpressionAccess().getAUnaryExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAUnaryExpression_in_ruleAUnaryOrTerminalExpression4411);
                    this_AUnaryExpression_0=ruleAUnaryExpression();

                    state._fsp--;

                     
                            current = this_AUnaryExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2014:5: this_AAlphabetsTerminalExpression_1= ruleAAlphabetsTerminalExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAUnaryOrTerminalExpressionAccess().getAAlphabetsTerminalExpressionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleAAlphabetsTerminalExpression_in_ruleAUnaryOrTerminalExpression4438);
                    this_AAlphabetsTerminalExpression_1=ruleAAlphabetsTerminalExpression();

                    state._fsp--;

                     
                            current = this_AAlphabetsTerminalExpression_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAUnaryOrTerminalExpression"


    // $ANTLR start "entryRuleAUnaryExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2030:1: entryRuleAUnaryExpression returns [EObject current=null] : iv_ruleAUnaryExpression= ruleAUnaryExpression EOF ;
    public final EObject entryRuleAUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAUnaryExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2031:2: (iv_ruleAUnaryExpression= ruleAUnaryExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2032:2: iv_ruleAUnaryExpression= ruleAUnaryExpression EOF
            {
             newCompositeNode(grammarAccess.getAUnaryExpressionRule()); 
            pushFollow(FOLLOW_ruleAUnaryExpression_in_entryRuleAUnaryExpression4473);
            iv_ruleAUnaryExpression=ruleAUnaryExpression();

            state._fsp--;

             current =iv_ruleAUnaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAUnaryExpression4483); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAUnaryExpression"


    // $ANTLR start "ruleAUnaryExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2039:1: ruleAUnaryExpression returns [EObject current=null] : (this_ANotExpression_0= ruleANotExpression | this_ANegateExpression_1= ruleANegateExpression ) ;
    public final EObject ruleAUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ANotExpression_0 = null;

        EObject this_ANegateExpression_1 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2042:28: ( (this_ANotExpression_0= ruleANotExpression | this_ANegateExpression_1= ruleANegateExpression ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2043:1: (this_ANotExpression_0= ruleANotExpression | this_ANegateExpression_1= ruleANegateExpression )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2043:1: (this_ANotExpression_0= ruleANotExpression | this_ANegateExpression_1= ruleANegateExpression )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==48) ) {
                alt47=1;
            }
            else if ( (LA47_0==RULE_OP_MINUS) ) {
                alt47=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2044:5: this_ANotExpression_0= ruleANotExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAUnaryExpressionAccess().getANotExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleANotExpression_in_ruleAUnaryExpression4530);
                    this_ANotExpression_0=ruleANotExpression();

                    state._fsp--;

                     
                            current = this_ANotExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2054:5: this_ANegateExpression_1= ruleANegateExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAUnaryExpressionAccess().getANegateExpressionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleANegateExpression_in_ruleAUnaryExpression4557);
                    this_ANegateExpression_1=ruleANegateExpression();

                    state._fsp--;

                     
                            current = this_ANegateExpression_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAUnaryExpression"


    // $ANTLR start "entryRuleANotExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2070:1: entryRuleANotExpression returns [EObject current=null] : iv_ruleANotExpression= ruleANotExpression EOF ;
    public final EObject entryRuleANotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleANotExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2071:2: (iv_ruleANotExpression= ruleANotExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2072:2: iv_ruleANotExpression= ruleANotExpression EOF
            {
             newCompositeNode(grammarAccess.getANotExpressionRule()); 
            pushFollow(FOLLOW_ruleANotExpression_in_entryRuleANotExpression4592);
            iv_ruleANotExpression=ruleANotExpression();

            state._fsp--;

             current =iv_ruleANotExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleANotExpression4602); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleANotExpression"


    // $ANTLR start "ruleANotExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2079:1: ruleANotExpression returns [EObject current=null] : ( ( (lv_op_0_0= 'not' ) ) ( (lv_expr_1_0= ruleAAlphabetsTerminalExpression ) ) ) ;
    public final EObject ruleANotExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_0_0=null;
        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2082:28: ( ( ( (lv_op_0_0= 'not' ) ) ( (lv_expr_1_0= ruleAAlphabetsTerminalExpression ) ) ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2083:1: ( ( (lv_op_0_0= 'not' ) ) ( (lv_expr_1_0= ruleAAlphabetsTerminalExpression ) ) )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2083:1: ( ( (lv_op_0_0= 'not' ) ) ( (lv_expr_1_0= ruleAAlphabetsTerminalExpression ) ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2083:2: ( (lv_op_0_0= 'not' ) ) ( (lv_expr_1_0= ruleAAlphabetsTerminalExpression ) )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2083:2: ( (lv_op_0_0= 'not' ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2084:1: (lv_op_0_0= 'not' )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2084:1: (lv_op_0_0= 'not' )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2085:3: lv_op_0_0= 'not'
            {
            lv_op_0_0=(Token)match(input,48,FOLLOW_48_in_ruleANotExpression4645); 

                    newLeafNode(lv_op_0_0, grammarAccess.getANotExpressionAccess().getOpNotKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getANotExpressionRule());
            	        }
                   		setWithLastConsumed(current, "op", lv_op_0_0, "not");
            	    

            }


            }

            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2098:2: ( (lv_expr_1_0= ruleAAlphabetsTerminalExpression ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2099:1: (lv_expr_1_0= ruleAAlphabetsTerminalExpression )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2099:1: (lv_expr_1_0= ruleAAlphabetsTerminalExpression )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2100:3: lv_expr_1_0= ruleAAlphabetsTerminalExpression
            {
             
            	        newCompositeNode(grammarAccess.getANotExpressionAccess().getExprAAlphabetsTerminalExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleAAlphabetsTerminalExpression_in_ruleANotExpression4679);
            lv_expr_1_0=ruleAAlphabetsTerminalExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getANotExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"expr",
                    		lv_expr_1_0, 
                    		"AAlphabetsTerminalExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleANotExpression"


    // $ANTLR start "entryRuleANegateExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2124:1: entryRuleANegateExpression returns [EObject current=null] : iv_ruleANegateExpression= ruleANegateExpression EOF ;
    public final EObject entryRuleANegateExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleANegateExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2125:2: (iv_ruleANegateExpression= ruleANegateExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2126:2: iv_ruleANegateExpression= ruleANegateExpression EOF
            {
             newCompositeNode(grammarAccess.getANegateExpressionRule()); 
            pushFollow(FOLLOW_ruleANegateExpression_in_entryRuleANegateExpression4715);
            iv_ruleANegateExpression=ruleANegateExpression();

            state._fsp--;

             current =iv_ruleANegateExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleANegateExpression4725); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleANegateExpression"


    // $ANTLR start "ruleANegateExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2133:1: ruleANegateExpression returns [EObject current=null] : ( ( (lv_op_0_0= RULE_OP_MINUS ) ) ( (lv_expr_1_0= ruleAAlphabetsTerminalExpression ) ) ) ;
    public final EObject ruleANegateExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_0_0=null;
        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2136:28: ( ( ( (lv_op_0_0= RULE_OP_MINUS ) ) ( (lv_expr_1_0= ruleAAlphabetsTerminalExpression ) ) ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2137:1: ( ( (lv_op_0_0= RULE_OP_MINUS ) ) ( (lv_expr_1_0= ruleAAlphabetsTerminalExpression ) ) )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2137:1: ( ( (lv_op_0_0= RULE_OP_MINUS ) ) ( (lv_expr_1_0= ruleAAlphabetsTerminalExpression ) ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2137:2: ( (lv_op_0_0= RULE_OP_MINUS ) ) ( (lv_expr_1_0= ruleAAlphabetsTerminalExpression ) )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2137:2: ( (lv_op_0_0= RULE_OP_MINUS ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2138:1: (lv_op_0_0= RULE_OP_MINUS )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2138:1: (lv_op_0_0= RULE_OP_MINUS )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2139:3: lv_op_0_0= RULE_OP_MINUS
            {
            lv_op_0_0=(Token)match(input,RULE_OP_MINUS,FOLLOW_RULE_OP_MINUS_in_ruleANegateExpression4767); 

            			newLeafNode(lv_op_0_0, grammarAccess.getANegateExpressionAccess().getOpOP_MINUSTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getANegateExpressionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"op",
                    		lv_op_0_0, 
                    		"OP_MINUS");
            	    

            }


            }

            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2155:2: ( (lv_expr_1_0= ruleAAlphabetsTerminalExpression ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2156:1: (lv_expr_1_0= ruleAAlphabetsTerminalExpression )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2156:1: (lv_expr_1_0= ruleAAlphabetsTerminalExpression )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2157:3: lv_expr_1_0= ruleAAlphabetsTerminalExpression
            {
             
            	        newCompositeNode(grammarAccess.getANegateExpressionAccess().getExprAAlphabetsTerminalExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleAAlphabetsTerminalExpression_in_ruleANegateExpression4793);
            lv_expr_1_0=ruleAAlphabetsTerminalExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getANegateExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"expr",
                    		lv_expr_1_0, 
                    		"AAlphabetsTerminalExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleANegateExpression"


    // $ANTLR start "entryRuleACaseExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2181:1: entryRuleACaseExpression returns [EObject current=null] : iv_ruleACaseExpression= ruleACaseExpression EOF ;
    public final EObject entryRuleACaseExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleACaseExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2182:2: (iv_ruleACaseExpression= ruleACaseExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2183:2: iv_ruleACaseExpression= ruleACaseExpression EOF
            {
             newCompositeNode(grammarAccess.getACaseExpressionRule()); 
            pushFollow(FOLLOW_ruleACaseExpression_in_entryRuleACaseExpression4829);
            iv_ruleACaseExpression=ruleACaseExpression();

            state._fsp--;

             current =iv_ruleACaseExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleACaseExpression4839); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleACaseExpression"


    // $ANTLR start "ruleACaseExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2190:1: ruleACaseExpression returns [EObject current=null] : (otherlv_0= 'case' ( ( (lv_exprs_1_0= ruleAAlphabetsExpression ) ) otherlv_2= ';' )+ otherlv_3= 'esac' ) ;
    public final EObject ruleACaseExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_exprs_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2193:28: ( (otherlv_0= 'case' ( ( (lv_exprs_1_0= ruleAAlphabetsExpression ) ) otherlv_2= ';' )+ otherlv_3= 'esac' ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2194:1: (otherlv_0= 'case' ( ( (lv_exprs_1_0= ruleAAlphabetsExpression ) ) otherlv_2= ';' )+ otherlv_3= 'esac' )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2194:1: (otherlv_0= 'case' ( ( (lv_exprs_1_0= ruleAAlphabetsExpression ) ) otherlv_2= ';' )+ otherlv_3= 'esac' )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2194:3: otherlv_0= 'case' ( ( (lv_exprs_1_0= ruleAAlphabetsExpression ) ) otherlv_2= ';' )+ otherlv_3= 'esac'
            {
            otherlv_0=(Token)match(input,49,FOLLOW_49_in_ruleACaseExpression4876); 

                	newLeafNode(otherlv_0, grammarAccess.getACaseExpressionAccess().getCaseKeyword_0());
                
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2198:1: ( ( (lv_exprs_1_0= ruleAAlphabetsExpression ) ) otherlv_2= ';' )+
            int cnt48=0;
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==RULE_ID||(LA48_0>=RULE_OP_PLUS && LA48_0<=RULE_OP_AND)||LA48_0==RULE_OP_MUL||(LA48_0>=RULE_OP_MIN && LA48_0<=RULE_REAL)||LA48_0==32||LA48_0==42||LA48_0==45||(LA48_0>=48 && LA48_0<=49)||LA48_0==52||LA48_0==55||LA48_0==57) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2198:2: ( (lv_exprs_1_0= ruleAAlphabetsExpression ) ) otherlv_2= ';'
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2198:2: ( (lv_exprs_1_0= ruleAAlphabetsExpression ) )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2199:1: (lv_exprs_1_0= ruleAAlphabetsExpression )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2199:1: (lv_exprs_1_0= ruleAAlphabetsExpression )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2200:3: lv_exprs_1_0= ruleAAlphabetsExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getACaseExpressionAccess().getExprsAAlphabetsExpressionParserRuleCall_1_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleACaseExpression4898);
            	    lv_exprs_1_0=ruleAAlphabetsExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getACaseExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"exprs",
            	            		lv_exprs_1_0, 
            	            		"AAlphabetsExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    otherlv_2=(Token)match(input,35,FOLLOW_35_in_ruleACaseExpression4910); 

            	        	newLeafNode(otherlv_2, grammarAccess.getACaseExpressionAccess().getSemicolonKeyword_1_1());
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt48 >= 1 ) break loop48;
                        EarlyExitException eee =
                            new EarlyExitException(48, input);
                        throw eee;
                }
                cnt48++;
            } while (true);

            otherlv_3=(Token)match(input,50,FOLLOW_50_in_ruleACaseExpression4924); 

                	newLeafNode(otherlv_3, grammarAccess.getACaseExpressionAccess().getEsacKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleACaseExpression"


    // $ANTLR start "entryRuleADependenceExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2232:1: entryRuleADependenceExpression returns [EObject current=null] : iv_ruleADependenceExpression= ruleADependenceExpression EOF ;
    public final EObject entryRuleADependenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleADependenceExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2233:2: (iv_ruleADependenceExpression= ruleADependenceExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2234:2: iv_ruleADependenceExpression= ruleADependenceExpression EOF
            {
             newCompositeNode(grammarAccess.getADependenceExpressionRule()); 
            pushFollow(FOLLOW_ruleADependenceExpression_in_entryRuleADependenceExpression4960);
            iv_ruleADependenceExpression=ruleADependenceExpression();

            state._fsp--;

             current =iv_ruleADependenceExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleADependenceExpression4970); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleADependenceExpression"


    // $ANTLR start "ruleADependenceExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2241:1: ruleADependenceExpression returns [EObject current=null] : ( ( (lv_func_0_0= ruleAFunction ) ) otherlv_1= '@' ( (lv_expr_2_0= ruleAAlphabetsTerminalExpression ) ) ) ;
    public final EObject ruleADependenceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_func_0_0 = null;

        EObject lv_expr_2_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2244:28: ( ( ( (lv_func_0_0= ruleAFunction ) ) otherlv_1= '@' ( (lv_expr_2_0= ruleAAlphabetsTerminalExpression ) ) ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2245:1: ( ( (lv_func_0_0= ruleAFunction ) ) otherlv_1= '@' ( (lv_expr_2_0= ruleAAlphabetsTerminalExpression ) ) )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2245:1: ( ( (lv_func_0_0= ruleAFunction ) ) otherlv_1= '@' ( (lv_expr_2_0= ruleAAlphabetsTerminalExpression ) ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2245:2: ( (lv_func_0_0= ruleAFunction ) ) otherlv_1= '@' ( (lv_expr_2_0= ruleAAlphabetsTerminalExpression ) )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2245:2: ( (lv_func_0_0= ruleAFunction ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2246:1: (lv_func_0_0= ruleAFunction )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2246:1: (lv_func_0_0= ruleAFunction )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2247:3: lv_func_0_0= ruleAFunction
            {
             
            	        newCompositeNode(grammarAccess.getADependenceExpressionAccess().getFuncAFunctionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleAFunction_in_ruleADependenceExpression5016);
            lv_func_0_0=ruleAFunction();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getADependenceExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"func",
                    		lv_func_0_0, 
                    		"AFunction");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,51,FOLLOW_51_in_ruleADependenceExpression5028); 

                	newLeafNode(otherlv_1, grammarAccess.getADependenceExpressionAccess().getCommercialAtKeyword_1());
                
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2267:1: ( (lv_expr_2_0= ruleAAlphabetsTerminalExpression ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2268:1: (lv_expr_2_0= ruleAAlphabetsTerminalExpression )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2268:1: (lv_expr_2_0= ruleAAlphabetsTerminalExpression )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2269:3: lv_expr_2_0= ruleAAlphabetsTerminalExpression
            {
             
            	        newCompositeNode(grammarAccess.getADependenceExpressionAccess().getExprAAlphabetsTerminalExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleAAlphabetsTerminalExpression_in_ruleADependenceExpression5049);
            lv_expr_2_0=ruleAAlphabetsTerminalExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getADependenceExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"expr",
                    		lv_expr_2_0, 
                    		"AAlphabetsTerminalExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleADependenceExpression"


    // $ANTLR start "entryRuleADependenceInArrayNotation"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2293:1: entryRuleADependenceInArrayNotation returns [EObject current=null] : iv_ruleADependenceInArrayNotation= ruleADependenceInArrayNotation EOF ;
    public final EObject entryRuleADependenceInArrayNotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleADependenceInArrayNotation = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2294:2: (iv_ruleADependenceInArrayNotation= ruleADependenceInArrayNotation EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2295:2: iv_ruleADependenceInArrayNotation= ruleADependenceInArrayNotation EOF
            {
             newCompositeNode(grammarAccess.getADependenceInArrayNotationRule()); 
            pushFollow(FOLLOW_ruleADependenceInArrayNotation_in_entryRuleADependenceInArrayNotation5085);
            iv_ruleADependenceInArrayNotation=ruleADependenceInArrayNotation();

            state._fsp--;

             current =iv_ruleADependenceInArrayNotation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleADependenceInArrayNotation5095); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleADependenceInArrayNotation"


    // $ANTLR start "ruleADependenceInArrayNotation"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2302:1: ruleADependenceInArrayNotation returns [EObject current=null] : ( ( (lv_var_0_0= ruleVariableIdentifier ) ) otherlv_1= '[' ( (lv_dep_2_0= ruleAIndexAffineExpressionList ) ) otherlv_3= ']' ) ;
    public final EObject ruleADependenceInArrayNotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_var_0_0 = null;

        EObject lv_dep_2_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2305:28: ( ( ( (lv_var_0_0= ruleVariableIdentifier ) ) otherlv_1= '[' ( (lv_dep_2_0= ruleAIndexAffineExpressionList ) ) otherlv_3= ']' ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2306:1: ( ( (lv_var_0_0= ruleVariableIdentifier ) ) otherlv_1= '[' ( (lv_dep_2_0= ruleAIndexAffineExpressionList ) ) otherlv_3= ']' )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2306:1: ( ( (lv_var_0_0= ruleVariableIdentifier ) ) otherlv_1= '[' ( (lv_dep_2_0= ruleAIndexAffineExpressionList ) ) otherlv_3= ']' )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2306:2: ( (lv_var_0_0= ruleVariableIdentifier ) ) otherlv_1= '[' ( (lv_dep_2_0= ruleAIndexAffineExpressionList ) ) otherlv_3= ']'
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2306:2: ( (lv_var_0_0= ruleVariableIdentifier ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2307:1: (lv_var_0_0= ruleVariableIdentifier )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2307:1: (lv_var_0_0= ruleVariableIdentifier )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2308:3: lv_var_0_0= ruleVariableIdentifier
            {
             
            	        newCompositeNode(grammarAccess.getADependenceInArrayNotationAccess().getVarVariableIdentifierParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleVariableIdentifier_in_ruleADependenceInArrayNotation5141);
            lv_var_0_0=ruleVariableIdentifier();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getADependenceInArrayNotationRule());
            	        }
                   		set(
                   			current, 
                   			"var",
                    		lv_var_0_0, 
                    		"VariableIdentifier");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,45,FOLLOW_45_in_ruleADependenceInArrayNotation5153); 

                	newLeafNode(otherlv_1, grammarAccess.getADependenceInArrayNotationAccess().getLeftSquareBracketKeyword_1());
                
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2328:1: ( (lv_dep_2_0= ruleAIndexAffineExpressionList ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2329:1: (lv_dep_2_0= ruleAIndexAffineExpressionList )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2329:1: (lv_dep_2_0= ruleAIndexAffineExpressionList )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2330:3: lv_dep_2_0= ruleAIndexAffineExpressionList
            {
             
            	        newCompositeNode(grammarAccess.getADependenceInArrayNotationAccess().getDepAIndexAffineExpressionListParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleAIndexAffineExpressionList_in_ruleADependenceInArrayNotation5174);
            lv_dep_2_0=ruleAIndexAffineExpressionList();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getADependenceInArrayNotationRule());
            	        }
                   		set(
                   			current, 
                   			"dep",
                    		lv_dep_2_0, 
                    		"AIndexAffineExpressionList");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,46,FOLLOW_46_in_ruleADependenceInArrayNotation5186); 

                	newLeafNode(otherlv_3, grammarAccess.getADependenceInArrayNotationAccess().getRightSquareBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleADependenceInArrayNotation"


    // $ANTLR start "entryRuleAIfExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2358:1: entryRuleAIfExpression returns [EObject current=null] : iv_ruleAIfExpression= ruleAIfExpression EOF ;
    public final EObject entryRuleAIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAIfExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2359:2: (iv_ruleAIfExpression= ruleAIfExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2360:2: iv_ruleAIfExpression= ruleAIfExpression EOF
            {
             newCompositeNode(grammarAccess.getAIfExpressionRule()); 
            pushFollow(FOLLOW_ruleAIfExpression_in_entryRuleAIfExpression5222);
            iv_ruleAIfExpression=ruleAIfExpression();

            state._fsp--;

             current =iv_ruleAIfExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAIfExpression5232); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAIfExpression"


    // $ANTLR start "ruleAIfExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2367:1: ruleAIfExpression returns [EObject current=null] : (otherlv_0= 'if' ( (lv_cond_1_0= ruleAAlphabetsExpression ) ) otherlv_2= 'then' ( (lv_then_3_0= ruleAAlphabetsExpression ) ) otherlv_4= 'else' ( (lv_else_5_0= ruleAAlphabetsExpression ) ) ) ;
    public final EObject ruleAIfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_cond_1_0 = null;

        EObject lv_then_3_0 = null;

        EObject lv_else_5_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2370:28: ( (otherlv_0= 'if' ( (lv_cond_1_0= ruleAAlphabetsExpression ) ) otherlv_2= 'then' ( (lv_then_3_0= ruleAAlphabetsExpression ) ) otherlv_4= 'else' ( (lv_else_5_0= ruleAAlphabetsExpression ) ) ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2371:1: (otherlv_0= 'if' ( (lv_cond_1_0= ruleAAlphabetsExpression ) ) otherlv_2= 'then' ( (lv_then_3_0= ruleAAlphabetsExpression ) ) otherlv_4= 'else' ( (lv_else_5_0= ruleAAlphabetsExpression ) ) )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2371:1: (otherlv_0= 'if' ( (lv_cond_1_0= ruleAAlphabetsExpression ) ) otherlv_2= 'then' ( (lv_then_3_0= ruleAAlphabetsExpression ) ) otherlv_4= 'else' ( (lv_else_5_0= ruleAAlphabetsExpression ) ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2371:3: otherlv_0= 'if' ( (lv_cond_1_0= ruleAAlphabetsExpression ) ) otherlv_2= 'then' ( (lv_then_3_0= ruleAAlphabetsExpression ) ) otherlv_4= 'else' ( (lv_else_5_0= ruleAAlphabetsExpression ) )
            {
            otherlv_0=(Token)match(input,52,FOLLOW_52_in_ruleAIfExpression5269); 

                	newLeafNode(otherlv_0, grammarAccess.getAIfExpressionAccess().getIfKeyword_0());
                
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2375:1: ( (lv_cond_1_0= ruleAAlphabetsExpression ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2376:1: (lv_cond_1_0= ruleAAlphabetsExpression )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2376:1: (lv_cond_1_0= ruleAAlphabetsExpression )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2377:3: lv_cond_1_0= ruleAAlphabetsExpression
            {
             
            	        newCompositeNode(grammarAccess.getAIfExpressionAccess().getCondAAlphabetsExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleAIfExpression5290);
            lv_cond_1_0=ruleAAlphabetsExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAIfExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"cond",
                    		lv_cond_1_0, 
                    		"AAlphabetsExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,53,FOLLOW_53_in_ruleAIfExpression5302); 

                	newLeafNode(otherlv_2, grammarAccess.getAIfExpressionAccess().getThenKeyword_2());
                
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2397:1: ( (lv_then_3_0= ruleAAlphabetsExpression ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2398:1: (lv_then_3_0= ruleAAlphabetsExpression )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2398:1: (lv_then_3_0= ruleAAlphabetsExpression )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2399:3: lv_then_3_0= ruleAAlphabetsExpression
            {
             
            	        newCompositeNode(grammarAccess.getAIfExpressionAccess().getThenAAlphabetsExpressionParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleAIfExpression5323);
            lv_then_3_0=ruleAAlphabetsExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAIfExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"then",
                    		lv_then_3_0, 
                    		"AAlphabetsExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,54,FOLLOW_54_in_ruleAIfExpression5335); 

                	newLeafNode(otherlv_4, grammarAccess.getAIfExpressionAccess().getElseKeyword_4());
                
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2419:1: ( (lv_else_5_0= ruleAAlphabetsExpression ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2420:1: (lv_else_5_0= ruleAAlphabetsExpression )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2420:1: (lv_else_5_0= ruleAAlphabetsExpression )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2421:3: lv_else_5_0= ruleAAlphabetsExpression
            {
             
            	        newCompositeNode(grammarAccess.getAIfExpressionAccess().getElseAAlphabetsExpressionParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleAIfExpression5356);
            lv_else_5_0=ruleAAlphabetsExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAIfExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"else",
                    		lv_else_5_0, 
                    		"AAlphabetsExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAIfExpression"


    // $ANTLR start "entryRuleAIndexExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2445:1: entryRuleAIndexExpression returns [EObject current=null] : iv_ruleAIndexExpression= ruleAIndexExpression EOF ;
    public final EObject entryRuleAIndexExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAIndexExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2446:2: (iv_ruleAIndexExpression= ruleAIndexExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2447:2: iv_ruleAIndexExpression= ruleAIndexExpression EOF
            {
             newCompositeNode(grammarAccess.getAIndexExpressionRule()); 
            pushFollow(FOLLOW_ruleAIndexExpression_in_entryRuleAIndexExpression5392);
            iv_ruleAIndexExpression=ruleAIndexExpression();

            state._fsp--;

             current =iv_ruleAIndexExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAIndexExpression5402); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAIndexExpression"


    // $ANTLR start "ruleAIndexExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2454:1: ruleAIndexExpression returns [EObject current=null] : ( (otherlv_0= '[' ( (lv_func_1_0= ruleIndexAffineExpression ) ) otherlv_2= ']' ) | (otherlv_3= 'val(' ( (lv_indexes_4_0= ruleAIndexList ) ) otherlv_5= '->' ( (lv_func_6_0= ruleIndexAffineExpression ) ) otherlv_7= ')' ) ) ;
    public final EObject ruleAIndexExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_func_1_0 = null;

        EObject lv_indexes_4_0 = null;

        AntlrDatatypeRuleToken lv_func_6_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2457:28: ( ( (otherlv_0= '[' ( (lv_func_1_0= ruleIndexAffineExpression ) ) otherlv_2= ']' ) | (otherlv_3= 'val(' ( (lv_indexes_4_0= ruleAIndexList ) ) otherlv_5= '->' ( (lv_func_6_0= ruleIndexAffineExpression ) ) otherlv_7= ')' ) ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2458:1: ( (otherlv_0= '[' ( (lv_func_1_0= ruleIndexAffineExpression ) ) otherlv_2= ']' ) | (otherlv_3= 'val(' ( (lv_indexes_4_0= ruleAIndexList ) ) otherlv_5= '->' ( (lv_func_6_0= ruleIndexAffineExpression ) ) otherlv_7= ')' ) )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2458:1: ( (otherlv_0= '[' ( (lv_func_1_0= ruleIndexAffineExpression ) ) otherlv_2= ']' ) | (otherlv_3= 'val(' ( (lv_indexes_4_0= ruleAIndexList ) ) otherlv_5= '->' ( (lv_func_6_0= ruleIndexAffineExpression ) ) otherlv_7= ')' ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==45) ) {
                alt49=1;
            }
            else if ( (LA49_0==55) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2458:2: (otherlv_0= '[' ( (lv_func_1_0= ruleIndexAffineExpression ) ) otherlv_2= ']' )
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2458:2: (otherlv_0= '[' ( (lv_func_1_0= ruleIndexAffineExpression ) ) otherlv_2= ']' )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2458:4: otherlv_0= '[' ( (lv_func_1_0= ruleIndexAffineExpression ) ) otherlv_2= ']'
                    {
                    otherlv_0=(Token)match(input,45,FOLLOW_45_in_ruleAIndexExpression5440); 

                        	newLeafNode(otherlv_0, grammarAccess.getAIndexExpressionAccess().getLeftSquareBracketKeyword_0_0());
                        
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2462:1: ( (lv_func_1_0= ruleIndexAffineExpression ) )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2463:1: (lv_func_1_0= ruleIndexAffineExpression )
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2463:1: (lv_func_1_0= ruleIndexAffineExpression )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2464:3: lv_func_1_0= ruleIndexAffineExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getAIndexExpressionAccess().getFuncIndexAffineExpressionParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleIndexAffineExpression_in_ruleAIndexExpression5461);
                    lv_func_1_0=ruleIndexAffineExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAIndexExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"func",
                            		lv_func_1_0, 
                            		"IndexAffineExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_2=(Token)match(input,46,FOLLOW_46_in_ruleAIndexExpression5473); 

                        	newLeafNode(otherlv_2, grammarAccess.getAIndexExpressionAccess().getRightSquareBracketKeyword_0_2());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2485:6: (otherlv_3= 'val(' ( (lv_indexes_4_0= ruleAIndexList ) ) otherlv_5= '->' ( (lv_func_6_0= ruleIndexAffineExpression ) ) otherlv_7= ')' )
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2485:6: (otherlv_3= 'val(' ( (lv_indexes_4_0= ruleAIndexList ) ) otherlv_5= '->' ( (lv_func_6_0= ruleIndexAffineExpression ) ) otherlv_7= ')' )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2485:8: otherlv_3= 'val(' ( (lv_indexes_4_0= ruleAIndexList ) ) otherlv_5= '->' ( (lv_func_6_0= ruleIndexAffineExpression ) ) otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,55,FOLLOW_55_in_ruleAIndexExpression5493); 

                        	newLeafNode(otherlv_3, grammarAccess.getAIndexExpressionAccess().getValKeyword_1_0());
                        
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2489:1: ( (lv_indexes_4_0= ruleAIndexList ) )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2490:1: (lv_indexes_4_0= ruleAIndexList )
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2490:1: (lv_indexes_4_0= ruleAIndexList )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2491:3: lv_indexes_4_0= ruleAIndexList
                    {
                     
                    	        newCompositeNode(grammarAccess.getAIndexExpressionAccess().getIndexesAIndexListParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAIndexList_in_ruleAIndexExpression5514);
                    lv_indexes_4_0=ruleAIndexList();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAIndexExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"indexes",
                            		lv_indexes_4_0, 
                            		"AIndexList");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,56,FOLLOW_56_in_ruleAIndexExpression5526); 

                        	newLeafNode(otherlv_5, grammarAccess.getAIndexExpressionAccess().getHyphenMinusGreaterThanSignKeyword_1_2());
                        
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2511:1: ( (lv_func_6_0= ruleIndexAffineExpression ) )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2512:1: (lv_func_6_0= ruleIndexAffineExpression )
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2512:1: (lv_func_6_0= ruleIndexAffineExpression )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2513:3: lv_func_6_0= ruleIndexAffineExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getAIndexExpressionAccess().getFuncIndexAffineExpressionParserRuleCall_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleIndexAffineExpression_in_ruleAIndexExpression5547);
                    lv_func_6_0=ruleIndexAffineExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAIndexExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"func",
                            		lv_func_6_0, 
                            		"IndexAffineExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_7=(Token)match(input,34,FOLLOW_34_in_ruleAIndexExpression5559); 

                        	newLeafNode(otherlv_7, grammarAccess.getAIndexExpressionAccess().getRightParenthesisKeyword_1_4());
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAIndexExpression"


    // $ANTLR start "entryRuleAReduceExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2541:1: entryRuleAReduceExpression returns [EObject current=null] : iv_ruleAReduceExpression= ruleAReduceExpression EOF ;
    public final EObject entryRuleAReduceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAReduceExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2542:2: (iv_ruleAReduceExpression= ruleAReduceExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2543:2: iv_ruleAReduceExpression= ruleAReduceExpression EOF
            {
             newCompositeNode(grammarAccess.getAReduceExpressionRule()); 
            pushFollow(FOLLOW_ruleAReduceExpression_in_entryRuleAReduceExpression5596);
            iv_ruleAReduceExpression=ruleAReduceExpression();

            state._fsp--;

             current =iv_ruleAReduceExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAReduceExpression5606); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAReduceExpression"


    // $ANTLR start "ruleAReduceExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2550:1: ruleAReduceExpression returns [EObject current=null] : (otherlv_0= 'reduce' otherlv_1= '(' ( (lv_op_2_0= ruleReductionOp ) ) otherlv_3= ',' ( ( (lv_projection_4_1= ruleAFunction | lv_projection_4_2= ruleAFunctionInArrayNotation ) ) ) otherlv_5= ',' ( (lv_expr_6_0= ruleAAlphabetsExpression ) ) otherlv_7= ')' ) ;
    public final EObject ruleAReduceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_projection_4_1 = null;

        EObject lv_projection_4_2 = null;

        EObject lv_expr_6_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2553:28: ( (otherlv_0= 'reduce' otherlv_1= '(' ( (lv_op_2_0= ruleReductionOp ) ) otherlv_3= ',' ( ( (lv_projection_4_1= ruleAFunction | lv_projection_4_2= ruleAFunctionInArrayNotation ) ) ) otherlv_5= ',' ( (lv_expr_6_0= ruleAAlphabetsExpression ) ) otherlv_7= ')' ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2554:1: (otherlv_0= 'reduce' otherlv_1= '(' ( (lv_op_2_0= ruleReductionOp ) ) otherlv_3= ',' ( ( (lv_projection_4_1= ruleAFunction | lv_projection_4_2= ruleAFunctionInArrayNotation ) ) ) otherlv_5= ',' ( (lv_expr_6_0= ruleAAlphabetsExpression ) ) otherlv_7= ')' )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2554:1: (otherlv_0= 'reduce' otherlv_1= '(' ( (lv_op_2_0= ruleReductionOp ) ) otherlv_3= ',' ( ( (lv_projection_4_1= ruleAFunction | lv_projection_4_2= ruleAFunctionInArrayNotation ) ) ) otherlv_5= ',' ( (lv_expr_6_0= ruleAAlphabetsExpression ) ) otherlv_7= ')' )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2554:3: otherlv_0= 'reduce' otherlv_1= '(' ( (lv_op_2_0= ruleReductionOp ) ) otherlv_3= ',' ( ( (lv_projection_4_1= ruleAFunction | lv_projection_4_2= ruleAFunctionInArrayNotation ) ) ) otherlv_5= ',' ( (lv_expr_6_0= ruleAAlphabetsExpression ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,57,FOLLOW_57_in_ruleAReduceExpression5643); 

                	newLeafNode(otherlv_0, grammarAccess.getAReduceExpressionAccess().getReduceKeyword_0());
                
            otherlv_1=(Token)match(input,32,FOLLOW_32_in_ruleAReduceExpression5655); 

                	newLeafNode(otherlv_1, grammarAccess.getAReduceExpressionAccess().getLeftParenthesisKeyword_1());
                
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2562:1: ( (lv_op_2_0= ruleReductionOp ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2563:1: (lv_op_2_0= ruleReductionOp )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2563:1: (lv_op_2_0= ruleReductionOp )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2564:3: lv_op_2_0= ruleReductionOp
            {
             
            	        newCompositeNode(grammarAccess.getAReduceExpressionAccess().getOpReductionOpParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleReductionOp_in_ruleAReduceExpression5676);
            lv_op_2_0=ruleReductionOp();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAReduceExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"op",
                    		lv_op_2_0, 
                    		"ReductionOp");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,33,FOLLOW_33_in_ruleAReduceExpression5688); 

                	newLeafNode(otherlv_3, grammarAccess.getAReduceExpressionAccess().getCommaKeyword_3());
                
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2584:1: ( ( (lv_projection_4_1= ruleAFunction | lv_projection_4_2= ruleAFunctionInArrayNotation ) ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2585:1: ( (lv_projection_4_1= ruleAFunction | lv_projection_4_2= ruleAFunctionInArrayNotation ) )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2585:1: ( (lv_projection_4_1= ruleAFunction | lv_projection_4_2= ruleAFunctionInArrayNotation ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2586:1: (lv_projection_4_1= ruleAFunction | lv_projection_4_2= ruleAFunctionInArrayNotation )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2586:1: (lv_projection_4_1= ruleAFunction | lv_projection_4_2= ruleAFunctionInArrayNotation )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==32) ) {
                alt50=1;
            }
            else if ( (LA50_0==45) ) {
                alt50=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2587:3: lv_projection_4_1= ruleAFunction
                    {
                     
                    	        newCompositeNode(grammarAccess.getAReduceExpressionAccess().getProjectionAFunctionParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAFunction_in_ruleAReduceExpression5711);
                    lv_projection_4_1=ruleAFunction();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAReduceExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"projection",
                            		lv_projection_4_1, 
                            		"AFunction");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2602:8: lv_projection_4_2= ruleAFunctionInArrayNotation
                    {
                     
                    	        newCompositeNode(grammarAccess.getAReduceExpressionAccess().getProjectionAFunctionInArrayNotationParserRuleCall_4_0_1()); 
                    	    
                    pushFollow(FOLLOW_ruleAFunctionInArrayNotation_in_ruleAReduceExpression5730);
                    lv_projection_4_2=ruleAFunctionInArrayNotation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAReduceExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"projection",
                            		lv_projection_4_2, 
                            		"AFunctionInArrayNotation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;

            }


            }


            }

            otherlv_5=(Token)match(input,33,FOLLOW_33_in_ruleAReduceExpression5745); 

                	newLeafNode(otherlv_5, grammarAccess.getAReduceExpressionAccess().getCommaKeyword_5());
                
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2624:1: ( (lv_expr_6_0= ruleAAlphabetsExpression ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2625:1: (lv_expr_6_0= ruleAAlphabetsExpression )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2625:1: (lv_expr_6_0= ruleAAlphabetsExpression )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2626:3: lv_expr_6_0= ruleAAlphabetsExpression
            {
             
            	        newCompositeNode(grammarAccess.getAReduceExpressionAccess().getExprAAlphabetsExpressionParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleAReduceExpression5766);
            lv_expr_6_0=ruleAAlphabetsExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAReduceExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"expr",
                    		lv_expr_6_0, 
                    		"AAlphabetsExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_7=(Token)match(input,34,FOLLOW_34_in_ruleAReduceExpression5778); 

                	newLeafNode(otherlv_7, grammarAccess.getAReduceExpressionAccess().getRightParenthesisKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAReduceExpression"


    // $ANTLR start "entryRuleARestrictExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2654:1: entryRuleARestrictExpression returns [EObject current=null] : iv_ruleARestrictExpression= ruleARestrictExpression EOF ;
    public final EObject entryRuleARestrictExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleARestrictExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2655:2: (iv_ruleARestrictExpression= ruleARestrictExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2656:2: iv_ruleARestrictExpression= ruleARestrictExpression EOF
            {
             newCompositeNode(grammarAccess.getARestrictExpressionRule()); 
            pushFollow(FOLLOW_ruleARestrictExpression_in_entryRuleARestrictExpression5814);
            iv_ruleARestrictExpression=ruleARestrictExpression();

            state._fsp--;

             current =iv_ruleARestrictExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleARestrictExpression5824); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleARestrictExpression"


    // $ANTLR start "ruleARestrictExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2663:1: ruleARestrictExpression returns [EObject current=null] : ( ( (lv_domain_0_0= ruleADomain ) ) otherlv_1= ':' ( (lv_expr_2_0= ruleAAlphabetsExpression ) ) ) ;
    public final EObject ruleARestrictExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_domain_0_0 = null;

        EObject lv_expr_2_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2666:28: ( ( ( (lv_domain_0_0= ruleADomain ) ) otherlv_1= ':' ( (lv_expr_2_0= ruleAAlphabetsExpression ) ) ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2667:1: ( ( (lv_domain_0_0= ruleADomain ) ) otherlv_1= ':' ( (lv_expr_2_0= ruleAAlphabetsExpression ) ) )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2667:1: ( ( (lv_domain_0_0= ruleADomain ) ) otherlv_1= ':' ( (lv_expr_2_0= ruleAAlphabetsExpression ) ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2667:2: ( (lv_domain_0_0= ruleADomain ) ) otherlv_1= ':' ( (lv_expr_2_0= ruleAAlphabetsExpression ) )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2667:2: ( (lv_domain_0_0= ruleADomain ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2668:1: (lv_domain_0_0= ruleADomain )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2668:1: (lv_domain_0_0= ruleADomain )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2669:3: lv_domain_0_0= ruleADomain
            {
             
            	        newCompositeNode(grammarAccess.getARestrictExpressionAccess().getDomainADomainParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleADomain_in_ruleARestrictExpression5870);
            lv_domain_0_0=ruleADomain();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getARestrictExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"domain",
                    		lv_domain_0_0, 
                    		"ADomain");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,58,FOLLOW_58_in_ruleARestrictExpression5882); 

                	newLeafNode(otherlv_1, grammarAccess.getARestrictExpressionAccess().getColonKeyword_1());
                
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2689:1: ( (lv_expr_2_0= ruleAAlphabetsExpression ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2690:1: (lv_expr_2_0= ruleAAlphabetsExpression )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2690:1: (lv_expr_2_0= ruleAAlphabetsExpression )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2691:3: lv_expr_2_0= ruleAAlphabetsExpression
            {
             
            	        newCompositeNode(grammarAccess.getARestrictExpressionAccess().getExprAAlphabetsExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleARestrictExpression5903);
            lv_expr_2_0=ruleAAlphabetsExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getARestrictExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"expr",
                    		lv_expr_2_0, 
                    		"AAlphabetsExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleARestrictExpression"


    // $ANTLR start "entryRuleAVariableExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2715:1: entryRuleAVariableExpression returns [EObject current=null] : iv_ruleAVariableExpression= ruleAVariableExpression EOF ;
    public final EObject entryRuleAVariableExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAVariableExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2716:2: (iv_ruleAVariableExpression= ruleAVariableExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2717:2: iv_ruleAVariableExpression= ruleAVariableExpression EOF
            {
             newCompositeNode(grammarAccess.getAVariableExpressionRule()); 
            pushFollow(FOLLOW_ruleAVariableExpression_in_entryRuleAVariableExpression5939);
            iv_ruleAVariableExpression=ruleAVariableExpression();

            state._fsp--;

             current =iv_ruleAVariableExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAVariableExpression5949); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAVariableExpression"


    // $ANTLR start "ruleAVariableExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2724:1: ruleAVariableExpression returns [EObject current=null] : ( (lv_var_0_0= ruleVariableIdentifier ) ) ;
    public final EObject ruleAVariableExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_var_0_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2727:28: ( ( (lv_var_0_0= ruleVariableIdentifier ) ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2728:1: ( (lv_var_0_0= ruleVariableIdentifier ) )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2728:1: ( (lv_var_0_0= ruleVariableIdentifier ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2729:1: (lv_var_0_0= ruleVariableIdentifier )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2729:1: (lv_var_0_0= ruleVariableIdentifier )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2730:3: lv_var_0_0= ruleVariableIdentifier
            {
             
            	        newCompositeNode(grammarAccess.getAVariableExpressionAccess().getVarVariableIdentifierParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleVariableIdentifier_in_ruleAVariableExpression5994);
            lv_var_0_0=ruleVariableIdentifier();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAVariableExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"var",
                    		lv_var_0_0, 
                    		"VariableIdentifier");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAVariableExpression"


    // $ANTLR start "entryRuleAConstantExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2754:1: entryRuleAConstantExpression returns [EObject current=null] : iv_ruleAConstantExpression= ruleAConstantExpression EOF ;
    public final EObject entryRuleAConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAConstantExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2755:2: (iv_ruleAConstantExpression= ruleAConstantExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2756:2: iv_ruleAConstantExpression= ruleAConstantExpression EOF
            {
             newCompositeNode(grammarAccess.getAConstantExpressionRule()); 
            pushFollow(FOLLOW_ruleAConstantExpression_in_entryRuleAConstantExpression6029);
            iv_ruleAConstantExpression=ruleAConstantExpression();

            state._fsp--;

             current =iv_ruleAConstantExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAConstantExpression6039); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAConstantExpression"


    // $ANTLR start "ruleAConstantExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2763:1: ruleAConstantExpression returns [EObject current=null] : (this_ABooleanExpression_0= ruleABooleanExpression | this_ARealExpression_1= ruleARealExpression | this_AIntegerExpression_2= ruleAIntegerExpression ) ;
    public final EObject ruleAConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ABooleanExpression_0 = null;

        EObject this_ARealExpression_1 = null;

        EObject this_AIntegerExpression_2 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2766:28: ( (this_ABooleanExpression_0= ruleABooleanExpression | this_ARealExpression_1= ruleARealExpression | this_AIntegerExpression_2= ruleAIntegerExpression ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2767:1: (this_ABooleanExpression_0= ruleABooleanExpression | this_ARealExpression_1= ruleARealExpression | this_AIntegerExpression_2= ruleAIntegerExpression )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2767:1: (this_ABooleanExpression_0= ruleABooleanExpression | this_ARealExpression_1= ruleARealExpression | this_AIntegerExpression_2= ruleAIntegerExpression )
            int alt51=3;
            switch ( input.LA(1) ) {
            case RULE_BOOLEAN:
                {
                alt51=1;
                }
                break;
            case RULE_REAL:
                {
                alt51=2;
                }
                break;
            case RULE_INT:
                {
                alt51=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2768:5: this_ABooleanExpression_0= ruleABooleanExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAConstantExpressionAccess().getABooleanExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleABooleanExpression_in_ruleAConstantExpression6086);
                    this_ABooleanExpression_0=ruleABooleanExpression();

                    state._fsp--;

                     
                            current = this_ABooleanExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2778:5: this_ARealExpression_1= ruleARealExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAConstantExpressionAccess().getARealExpressionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleARealExpression_in_ruleAConstantExpression6113);
                    this_ARealExpression_1=ruleARealExpression();

                    state._fsp--;

                     
                            current = this_ARealExpression_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2788:5: this_AIntegerExpression_2= ruleAIntegerExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAConstantExpressionAccess().getAIntegerExpressionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleAIntegerExpression_in_ruleAConstantExpression6140);
                    this_AIntegerExpression_2=ruleAIntegerExpression();

                    state._fsp--;

                     
                            current = this_AIntegerExpression_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAConstantExpression"


    // $ANTLR start "entryRuleABooleanExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2804:1: entryRuleABooleanExpression returns [EObject current=null] : iv_ruleABooleanExpression= ruleABooleanExpression EOF ;
    public final EObject entryRuleABooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleABooleanExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2805:2: (iv_ruleABooleanExpression= ruleABooleanExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2806:2: iv_ruleABooleanExpression= ruleABooleanExpression EOF
            {
             newCompositeNode(grammarAccess.getABooleanExpressionRule()); 
            pushFollow(FOLLOW_ruleABooleanExpression_in_entryRuleABooleanExpression6175);
            iv_ruleABooleanExpression=ruleABooleanExpression();

            state._fsp--;

             current =iv_ruleABooleanExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleABooleanExpression6185); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleABooleanExpression"


    // $ANTLR start "ruleABooleanExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2813:1: ruleABooleanExpression returns [EObject current=null] : ( (lv_value_0_0= RULE_BOOLEAN ) ) ;
    public final EObject ruleABooleanExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2816:28: ( ( (lv_value_0_0= RULE_BOOLEAN ) ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2817:1: ( (lv_value_0_0= RULE_BOOLEAN ) )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2817:1: ( (lv_value_0_0= RULE_BOOLEAN ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2818:1: (lv_value_0_0= RULE_BOOLEAN )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2818:1: (lv_value_0_0= RULE_BOOLEAN )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2819:3: lv_value_0_0= RULE_BOOLEAN
            {
            lv_value_0_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_RULE_BOOLEAN_in_ruleABooleanExpression6226); 

            			newLeafNode(lv_value_0_0, grammarAccess.getABooleanExpressionAccess().getValueBOOLEANTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getABooleanExpressionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"BOOLEAN");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleABooleanExpression"


    // $ANTLR start "entryRuleAIntegerExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2843:1: entryRuleAIntegerExpression returns [EObject current=null] : iv_ruleAIntegerExpression= ruleAIntegerExpression EOF ;
    public final EObject entryRuleAIntegerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAIntegerExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2844:2: (iv_ruleAIntegerExpression= ruleAIntegerExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2845:2: iv_ruleAIntegerExpression= ruleAIntegerExpression EOF
            {
             newCompositeNode(grammarAccess.getAIntegerExpressionRule()); 
            pushFollow(FOLLOW_ruleAIntegerExpression_in_entryRuleAIntegerExpression6266);
            iv_ruleAIntegerExpression=ruleAIntegerExpression();

            state._fsp--;

             current =iv_ruleAIntegerExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAIntegerExpression6276); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAIntegerExpression"


    // $ANTLR start "ruleAIntegerExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2852:1: ruleAIntegerExpression returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleAIntegerExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2855:28: ( ( (lv_value_0_0= RULE_INT ) ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2856:1: ( (lv_value_0_0= RULE_INT ) )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2856:1: ( (lv_value_0_0= RULE_INT ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2857:1: (lv_value_0_0= RULE_INT )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2857:1: (lv_value_0_0= RULE_INT )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2858:3: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAIntegerExpression6317); 

            			newLeafNode(lv_value_0_0, grammarAccess.getAIntegerExpressionAccess().getValueINTTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAIntegerExpressionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"INT");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAIntegerExpression"


    // $ANTLR start "entryRuleARealExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2882:1: entryRuleARealExpression returns [EObject current=null] : iv_ruleARealExpression= ruleARealExpression EOF ;
    public final EObject entryRuleARealExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleARealExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2883:2: (iv_ruleARealExpression= ruleARealExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2884:2: iv_ruleARealExpression= ruleARealExpression EOF
            {
             newCompositeNode(grammarAccess.getARealExpressionRule()); 
            pushFollow(FOLLOW_ruleARealExpression_in_entryRuleARealExpression6357);
            iv_ruleARealExpression=ruleARealExpression();

            state._fsp--;

             current =iv_ruleARealExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleARealExpression6367); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleARealExpression"


    // $ANTLR start "ruleARealExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2891:1: ruleARealExpression returns [EObject current=null] : ( (lv_value_0_0= RULE_REAL ) ) ;
    public final EObject ruleARealExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2894:28: ( ( (lv_value_0_0= RULE_REAL ) ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2895:1: ( (lv_value_0_0= RULE_REAL ) )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2895:1: ( (lv_value_0_0= RULE_REAL ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2896:1: (lv_value_0_0= RULE_REAL )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2896:1: (lv_value_0_0= RULE_REAL )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2897:3: lv_value_0_0= RULE_REAL
            {
            lv_value_0_0=(Token)match(input,RULE_REAL,FOLLOW_RULE_REAL_in_ruleARealExpression6408); 

            			newLeafNode(lv_value_0_0, grammarAccess.getARealExpressionAccess().getValueREALTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getARealExpressionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"REAL");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleARealExpression"


    // $ANTLR start "entryRuleAMultiArgExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2921:1: entryRuleAMultiArgExpression returns [EObject current=null] : iv_ruleAMultiArgExpression= ruleAMultiArgExpression EOF ;
    public final EObject entryRuleAMultiArgExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAMultiArgExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2922:2: (iv_ruleAMultiArgExpression= ruleAMultiArgExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2923:2: iv_ruleAMultiArgExpression= ruleAMultiArgExpression EOF
            {
             newCompositeNode(grammarAccess.getAMultiArgExpressionRule()); 
            pushFollow(FOLLOW_ruleAMultiArgExpression_in_entryRuleAMultiArgExpression6448);
            iv_ruleAMultiArgExpression=ruleAMultiArgExpression();

            state._fsp--;

             current =iv_ruleAMultiArgExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAMultiArgExpression6458); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAMultiArgExpression"


    // $ANTLR start "ruleAMultiArgExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2930:1: ruleAMultiArgExpression returns [EObject current=null] : (this_AMultiArgArithmeticExpression_0= ruleAMultiArgArithmeticExpression | this_AMultiArgLogicalExpression_1= ruleAMultiArgLogicalExpression | this_AExternalFunctionCall_2= ruleAExternalFunctionCall ) ;
    public final EObject ruleAMultiArgExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AMultiArgArithmeticExpression_0 = null;

        EObject this_AMultiArgLogicalExpression_1 = null;

        EObject this_AExternalFunctionCall_2 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2933:28: ( (this_AMultiArgArithmeticExpression_0= ruleAMultiArgArithmeticExpression | this_AMultiArgLogicalExpression_1= ruleAMultiArgLogicalExpression | this_AExternalFunctionCall_2= ruleAExternalFunctionCall ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2934:1: (this_AMultiArgArithmeticExpression_0= ruleAMultiArgArithmeticExpression | this_AMultiArgLogicalExpression_1= ruleAMultiArgLogicalExpression | this_AExternalFunctionCall_2= ruleAExternalFunctionCall )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2934:1: (this_AMultiArgArithmeticExpression_0= ruleAMultiArgArithmeticExpression | this_AMultiArgLogicalExpression_1= ruleAMultiArgLogicalExpression | this_AExternalFunctionCall_2= ruleAExternalFunctionCall )
            int alt52=3;
            switch ( input.LA(1) ) {
            case RULE_OP_PLUS:
            case RULE_OP_MUL:
            case RULE_OP_MIN:
            case RULE_OP_MAX:
                {
                alt52=1;
                }
                break;
            case RULE_OP_OR:
            case RULE_XOP_OR:
            case RULE_OP_AND:
                {
                alt52=2;
                }
                break;
            case RULE_ID:
                {
                alt52=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2935:5: this_AMultiArgArithmeticExpression_0= ruleAMultiArgArithmeticExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAMultiArgExpressionAccess().getAMultiArgArithmeticExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAMultiArgArithmeticExpression_in_ruleAMultiArgExpression6505);
                    this_AMultiArgArithmeticExpression_0=ruleAMultiArgArithmeticExpression();

                    state._fsp--;

                     
                            current = this_AMultiArgArithmeticExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2945:5: this_AMultiArgLogicalExpression_1= ruleAMultiArgLogicalExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAMultiArgExpressionAccess().getAMultiArgLogicalExpressionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleAMultiArgLogicalExpression_in_ruleAMultiArgExpression6532);
                    this_AMultiArgLogicalExpression_1=ruleAMultiArgLogicalExpression();

                    state._fsp--;

                     
                            current = this_AMultiArgLogicalExpression_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2955:5: this_AExternalFunctionCall_2= ruleAExternalFunctionCall
                    {
                     
                            newCompositeNode(grammarAccess.getAMultiArgExpressionAccess().getAExternalFunctionCallParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleAExternalFunctionCall_in_ruleAMultiArgExpression6559);
                    this_AExternalFunctionCall_2=ruleAExternalFunctionCall();

                    state._fsp--;

                     
                            current = this_AExternalFunctionCall_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAMultiArgExpression"


    // $ANTLR start "entryRuleAMultiArgArithmeticExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2971:1: entryRuleAMultiArgArithmeticExpression returns [EObject current=null] : iv_ruleAMultiArgArithmeticExpression= ruleAMultiArgArithmeticExpression EOF ;
    public final EObject entryRuleAMultiArgArithmeticExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAMultiArgArithmeticExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2972:2: (iv_ruleAMultiArgArithmeticExpression= ruleAMultiArgArithmeticExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2973:2: iv_ruleAMultiArgArithmeticExpression= ruleAMultiArgArithmeticExpression EOF
            {
             newCompositeNode(grammarAccess.getAMultiArgArithmeticExpressionRule()); 
            pushFollow(FOLLOW_ruleAMultiArgArithmeticExpression_in_entryRuleAMultiArgArithmeticExpression6594);
            iv_ruleAMultiArgArithmeticExpression=ruleAMultiArgArithmeticExpression();

            state._fsp--;

             current =iv_ruleAMultiArgArithmeticExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAMultiArgArithmeticExpression6604); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAMultiArgArithmeticExpression"


    // $ANTLR start "ruleAMultiArgArithmeticExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2980:1: ruleAMultiArgArithmeticExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleArithmeticOp ) ) otherlv_1= '(' ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )+ otherlv_5= ')' ) ;
    public final EObject ruleAMultiArgArithmeticExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_exprs_2_0 = null;

        EObject lv_exprs_4_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2983:28: ( ( ( (lv_op_0_0= ruleArithmeticOp ) ) otherlv_1= '(' ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )+ otherlv_5= ')' ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2984:1: ( ( (lv_op_0_0= ruleArithmeticOp ) ) otherlv_1= '(' ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )+ otherlv_5= ')' )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2984:1: ( ( (lv_op_0_0= ruleArithmeticOp ) ) otherlv_1= '(' ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )+ otherlv_5= ')' )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2984:2: ( (lv_op_0_0= ruleArithmeticOp ) ) otherlv_1= '(' ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )+ otherlv_5= ')'
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2984:2: ( (lv_op_0_0= ruleArithmeticOp ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2985:1: (lv_op_0_0= ruleArithmeticOp )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2985:1: (lv_op_0_0= ruleArithmeticOp )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2986:3: lv_op_0_0= ruleArithmeticOp
            {
             
            	        newCompositeNode(grammarAccess.getAMultiArgArithmeticExpressionAccess().getOpArithmeticOpParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleArithmeticOp_in_ruleAMultiArgArithmeticExpression6650);
            lv_op_0_0=ruleArithmeticOp();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAMultiArgArithmeticExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"op",
                    		lv_op_0_0, 
                    		"ArithmeticOp");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,32,FOLLOW_32_in_ruleAMultiArgArithmeticExpression6662); 

                	newLeafNode(otherlv_1, grammarAccess.getAMultiArgArithmeticExpressionAccess().getLeftParenthesisKeyword_1());
                
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3006:1: ( (lv_exprs_2_0= ruleAAlphabetsExpression ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3007:1: (lv_exprs_2_0= ruleAAlphabetsExpression )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3007:1: (lv_exprs_2_0= ruleAAlphabetsExpression )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3008:3: lv_exprs_2_0= ruleAAlphabetsExpression
            {
             
            	        newCompositeNode(grammarAccess.getAMultiArgArithmeticExpressionAccess().getExprsAAlphabetsExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleAMultiArgArithmeticExpression6683);
            lv_exprs_2_0=ruleAAlphabetsExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAMultiArgArithmeticExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"exprs",
                    		lv_exprs_2_0, 
                    		"AAlphabetsExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3024:2: (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )+
            int cnt53=0;
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==33) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3024:4: otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) )
            	    {
            	    otherlv_3=(Token)match(input,33,FOLLOW_33_in_ruleAMultiArgArithmeticExpression6696); 

            	        	newLeafNode(otherlv_3, grammarAccess.getAMultiArgArithmeticExpressionAccess().getCommaKeyword_3_0());
            	        
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3028:1: ( (lv_exprs_4_0= ruleAAlphabetsExpression ) )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3029:1: (lv_exprs_4_0= ruleAAlphabetsExpression )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3029:1: (lv_exprs_4_0= ruleAAlphabetsExpression )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3030:3: lv_exprs_4_0= ruleAAlphabetsExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAMultiArgArithmeticExpressionAccess().getExprsAAlphabetsExpressionParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleAMultiArgArithmeticExpression6717);
            	    lv_exprs_4_0=ruleAAlphabetsExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAMultiArgArithmeticExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"exprs",
            	            		lv_exprs_4_0, 
            	            		"AAlphabetsExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt53 >= 1 ) break loop53;
                        EarlyExitException eee =
                            new EarlyExitException(53, input);
                        throw eee;
                }
                cnt53++;
            } while (true);

            otherlv_5=(Token)match(input,34,FOLLOW_34_in_ruleAMultiArgArithmeticExpression6731); 

                	newLeafNode(otherlv_5, grammarAccess.getAMultiArgArithmeticExpressionAccess().getRightParenthesisKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAMultiArgArithmeticExpression"


    // $ANTLR start "entryRuleAMultiArgLogicalExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3058:1: entryRuleAMultiArgLogicalExpression returns [EObject current=null] : iv_ruleAMultiArgLogicalExpression= ruleAMultiArgLogicalExpression EOF ;
    public final EObject entryRuleAMultiArgLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAMultiArgLogicalExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3059:2: (iv_ruleAMultiArgLogicalExpression= ruleAMultiArgLogicalExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3060:2: iv_ruleAMultiArgLogicalExpression= ruleAMultiArgLogicalExpression EOF
            {
             newCompositeNode(grammarAccess.getAMultiArgLogicalExpressionRule()); 
            pushFollow(FOLLOW_ruleAMultiArgLogicalExpression_in_entryRuleAMultiArgLogicalExpression6767);
            iv_ruleAMultiArgLogicalExpression=ruleAMultiArgLogicalExpression();

            state._fsp--;

             current =iv_ruleAMultiArgLogicalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAMultiArgLogicalExpression6777); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAMultiArgLogicalExpression"


    // $ANTLR start "ruleAMultiArgLogicalExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3067:1: ruleAMultiArgLogicalExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleLogicalOp ) ) otherlv_1= '(' ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )+ otherlv_5= ')' ) ;
    public final EObject ruleAMultiArgLogicalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_exprs_2_0 = null;

        EObject lv_exprs_4_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3070:28: ( ( ( (lv_op_0_0= ruleLogicalOp ) ) otherlv_1= '(' ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )+ otherlv_5= ')' ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3071:1: ( ( (lv_op_0_0= ruleLogicalOp ) ) otherlv_1= '(' ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )+ otherlv_5= ')' )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3071:1: ( ( (lv_op_0_0= ruleLogicalOp ) ) otherlv_1= '(' ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )+ otherlv_5= ')' )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3071:2: ( (lv_op_0_0= ruleLogicalOp ) ) otherlv_1= '(' ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )+ otherlv_5= ')'
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3071:2: ( (lv_op_0_0= ruleLogicalOp ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3072:1: (lv_op_0_0= ruleLogicalOp )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3072:1: (lv_op_0_0= ruleLogicalOp )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3073:3: lv_op_0_0= ruleLogicalOp
            {
             
            	        newCompositeNode(grammarAccess.getAMultiArgLogicalExpressionAccess().getOpLogicalOpParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleLogicalOp_in_ruleAMultiArgLogicalExpression6823);
            lv_op_0_0=ruleLogicalOp();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAMultiArgLogicalExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"op",
                    		lv_op_0_0, 
                    		"LogicalOp");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,32,FOLLOW_32_in_ruleAMultiArgLogicalExpression6835); 

                	newLeafNode(otherlv_1, grammarAccess.getAMultiArgLogicalExpressionAccess().getLeftParenthesisKeyword_1());
                
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3093:1: ( (lv_exprs_2_0= ruleAAlphabetsExpression ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3094:1: (lv_exprs_2_0= ruleAAlphabetsExpression )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3094:1: (lv_exprs_2_0= ruleAAlphabetsExpression )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3095:3: lv_exprs_2_0= ruleAAlphabetsExpression
            {
             
            	        newCompositeNode(grammarAccess.getAMultiArgLogicalExpressionAccess().getExprsAAlphabetsExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleAMultiArgLogicalExpression6856);
            lv_exprs_2_0=ruleAAlphabetsExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAMultiArgLogicalExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"exprs",
                    		lv_exprs_2_0, 
                    		"AAlphabetsExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3111:2: (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )+
            int cnt54=0;
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==33) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3111:4: otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) )
            	    {
            	    otherlv_3=(Token)match(input,33,FOLLOW_33_in_ruleAMultiArgLogicalExpression6869); 

            	        	newLeafNode(otherlv_3, grammarAccess.getAMultiArgLogicalExpressionAccess().getCommaKeyword_3_0());
            	        
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3115:1: ( (lv_exprs_4_0= ruleAAlphabetsExpression ) )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3116:1: (lv_exprs_4_0= ruleAAlphabetsExpression )
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3116:1: (lv_exprs_4_0= ruleAAlphabetsExpression )
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3117:3: lv_exprs_4_0= ruleAAlphabetsExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAMultiArgLogicalExpressionAccess().getExprsAAlphabetsExpressionParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleAMultiArgLogicalExpression6890);
            	    lv_exprs_4_0=ruleAAlphabetsExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAMultiArgLogicalExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"exprs",
            	            		lv_exprs_4_0, 
            	            		"AAlphabetsExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt54 >= 1 ) break loop54;
                        EarlyExitException eee =
                            new EarlyExitException(54, input);
                        throw eee;
                }
                cnt54++;
            } while (true);

            otherlv_5=(Token)match(input,34,FOLLOW_34_in_ruleAMultiArgLogicalExpression6904); 

                	newLeafNode(otherlv_5, grammarAccess.getAMultiArgLogicalExpressionAccess().getRightParenthesisKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAMultiArgLogicalExpression"


    // $ANTLR start "entryRuleAExternalFunctionCall"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3145:1: entryRuleAExternalFunctionCall returns [EObject current=null] : iv_ruleAExternalFunctionCall= ruleAExternalFunctionCall EOF ;
    public final EObject entryRuleAExternalFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAExternalFunctionCall = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3146:2: (iv_ruleAExternalFunctionCall= ruleAExternalFunctionCall EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3147:2: iv_ruleAExternalFunctionCall= ruleAExternalFunctionCall EOF
            {
             newCompositeNode(grammarAccess.getAExternalFunctionCallRule()); 
            pushFollow(FOLLOW_ruleAExternalFunctionCall_in_entryRuleAExternalFunctionCall6940);
            iv_ruleAExternalFunctionCall=ruleAExternalFunctionCall();

            state._fsp--;

             current =iv_ruleAExternalFunctionCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAExternalFunctionCall6950); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAExternalFunctionCall"


    // $ANTLR start "ruleAExternalFunctionCall"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3154:1: ruleAExternalFunctionCall returns [EObject current=null] : ( ( (lv_func_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleAExternalFunctionCall() throws RecognitionException {
        EObject current = null;

        Token lv_func_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_exprs_2_0 = null;

        EObject lv_exprs_4_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3157:28: ( ( ( (lv_func_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )* )? otherlv_5= ')' ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3158:1: ( ( (lv_func_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )* )? otherlv_5= ')' )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3158:1: ( ( (lv_func_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )* )? otherlv_5= ')' )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3158:2: ( (lv_func_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )* )? otherlv_5= ')'
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3158:2: ( (lv_func_0_0= RULE_ID ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3159:1: (lv_func_0_0= RULE_ID )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3159:1: (lv_func_0_0= RULE_ID )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3160:3: lv_func_0_0= RULE_ID
            {
            lv_func_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAExternalFunctionCall6992); 

            			newLeafNode(lv_func_0_0, grammarAccess.getAExternalFunctionCallAccess().getFuncIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAExternalFunctionCallRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"func",
                    		lv_func_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,32,FOLLOW_32_in_ruleAExternalFunctionCall7009); 

                	newLeafNode(otherlv_1, grammarAccess.getAExternalFunctionCallAccess().getLeftParenthesisKeyword_1());
                
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3180:1: ( ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )* )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_ID||(LA56_0>=RULE_OP_PLUS && LA56_0<=RULE_OP_AND)||LA56_0==RULE_OP_MUL||(LA56_0>=RULE_OP_MIN && LA56_0<=RULE_REAL)||LA56_0==32||LA56_0==42||LA56_0==45||(LA56_0>=48 && LA56_0<=49)||LA56_0==52||LA56_0==55||LA56_0==57) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3180:2: ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )*
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3180:2: ( (lv_exprs_2_0= ruleAAlphabetsExpression ) )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3181:1: (lv_exprs_2_0= ruleAAlphabetsExpression )
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3181:1: (lv_exprs_2_0= ruleAAlphabetsExpression )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3182:3: lv_exprs_2_0= ruleAAlphabetsExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getAExternalFunctionCallAccess().getExprsAAlphabetsExpressionParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleAExternalFunctionCall7031);
                    lv_exprs_2_0=ruleAAlphabetsExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAExternalFunctionCallRule());
                    	        }
                           		add(
                           			current, 
                           			"exprs",
                            		lv_exprs_2_0, 
                            		"AAlphabetsExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3198:2: (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==33) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3198:4: otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,33,FOLLOW_33_in_ruleAExternalFunctionCall7044); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getAExternalFunctionCallAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3202:1: ( (lv_exprs_4_0= ruleAAlphabetsExpression ) )
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3203:1: (lv_exprs_4_0= ruleAAlphabetsExpression )
                    	    {
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3203:1: (lv_exprs_4_0= ruleAAlphabetsExpression )
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3204:3: lv_exprs_4_0= ruleAAlphabetsExpression
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAExternalFunctionCallAccess().getExprsAAlphabetsExpressionParserRuleCall_2_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleAExternalFunctionCall7065);
                    	    lv_exprs_4_0=ruleAAlphabetsExpression();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAExternalFunctionCallRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"exprs",
                    	            		lv_exprs_4_0, 
                    	            		"AAlphabetsExpression");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop55;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,34,FOLLOW_34_in_ruleAExternalFunctionCall7081); 

                	newLeafNode(otherlv_5, grammarAccess.getAExternalFunctionCallAccess().getRightParenthesisKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAExternalFunctionCall"


    // $ANTLR start "entryRuleIndexIdentifier"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3232:1: entryRuleIndexIdentifier returns [String current=null] : iv_ruleIndexIdentifier= ruleIndexIdentifier EOF ;
    public final String entryRuleIndexIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIndexIdentifier = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3233:2: (iv_ruleIndexIdentifier= ruleIndexIdentifier EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3234:2: iv_ruleIndexIdentifier= ruleIndexIdentifier EOF
            {
             newCompositeNode(grammarAccess.getIndexIdentifierRule()); 
            pushFollow(FOLLOW_ruleIndexIdentifier_in_entryRuleIndexIdentifier7118);
            iv_ruleIndexIdentifier=ruleIndexIdentifier();

            state._fsp--;

             current =iv_ruleIndexIdentifier.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIndexIdentifier7129); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIndexIdentifier"


    // $ANTLR start "ruleIndexIdentifier"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3241:1: ruleIndexIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleIndexIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3244:28: (this_ID_0= RULE_ID )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3245:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIndexIdentifier7168); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getIndexIdentifierAccess().getIDTerminalRuleCall()); 
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIndexIdentifier"


    // $ANTLR start "entryRuleAIndexList"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3260:1: entryRuleAIndexList returns [EObject current=null] : iv_ruleAIndexList= ruleAIndexList EOF ;
    public final EObject entryRuleAIndexList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAIndexList = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3261:2: (iv_ruleAIndexList= ruleAIndexList EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3262:2: iv_ruleAIndexList= ruleAIndexList EOF
            {
             newCompositeNode(grammarAccess.getAIndexListRule()); 
            pushFollow(FOLLOW_ruleAIndexList_in_entryRuleAIndexList7212);
            iv_ruleAIndexList=ruleAIndexList();

            state._fsp--;

             current =iv_ruleAIndexList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAIndexList7222); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAIndexList"


    // $ANTLR start "ruleAIndexList"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3269:1: ruleAIndexList returns [EObject current=null] : ( () ( ( (lv_ids_1_0= ruleIndexIdentifier ) ) (otherlv_2= ',' ( (lv_ids_3_0= ruleIndexIdentifier ) ) )* )? ) ;
    public final EObject ruleAIndexList() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_ids_1_0 = null;

        AntlrDatatypeRuleToken lv_ids_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3272:28: ( ( () ( ( (lv_ids_1_0= ruleIndexIdentifier ) ) (otherlv_2= ',' ( (lv_ids_3_0= ruleIndexIdentifier ) ) )* )? ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3273:1: ( () ( ( (lv_ids_1_0= ruleIndexIdentifier ) ) (otherlv_2= ',' ( (lv_ids_3_0= ruleIndexIdentifier ) ) )* )? )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3273:1: ( () ( ( (lv_ids_1_0= ruleIndexIdentifier ) ) (otherlv_2= ',' ( (lv_ids_3_0= ruleIndexIdentifier ) ) )* )? )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3273:2: () ( ( (lv_ids_1_0= ruleIndexIdentifier ) ) (otherlv_2= ',' ( (lv_ids_3_0= ruleIndexIdentifier ) ) )* )?
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3273:2: ()
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3274:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAIndexListAccess().getAIndexListAction_0(),
                        current);
                

            }

            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3279:2: ( ( (lv_ids_1_0= ruleIndexIdentifier ) ) (otherlv_2= ',' ( (lv_ids_3_0= ruleIndexIdentifier ) ) )* )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==RULE_ID) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3279:3: ( (lv_ids_1_0= ruleIndexIdentifier ) ) (otherlv_2= ',' ( (lv_ids_3_0= ruleIndexIdentifier ) ) )*
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3279:3: ( (lv_ids_1_0= ruleIndexIdentifier ) )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3280:1: (lv_ids_1_0= ruleIndexIdentifier )
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3280:1: (lv_ids_1_0= ruleIndexIdentifier )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3281:3: lv_ids_1_0= ruleIndexIdentifier
                    {
                     
                    	        newCompositeNode(grammarAccess.getAIndexListAccess().getIdsIndexIdentifierParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleIndexIdentifier_in_ruleAIndexList7278);
                    lv_ids_1_0=ruleIndexIdentifier();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAIndexListRule());
                    	        }
                           		add(
                           			current, 
                           			"ids",
                            		lv_ids_1_0, 
                            		"IndexIdentifier");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3297:2: (otherlv_2= ',' ( (lv_ids_3_0= ruleIndexIdentifier ) ) )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==33) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3297:4: otherlv_2= ',' ( (lv_ids_3_0= ruleIndexIdentifier ) )
                    	    {
                    	    otherlv_2=(Token)match(input,33,FOLLOW_33_in_ruleAIndexList7291); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getAIndexListAccess().getCommaKeyword_1_1_0());
                    	        
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3301:1: ( (lv_ids_3_0= ruleIndexIdentifier ) )
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3302:1: (lv_ids_3_0= ruleIndexIdentifier )
                    	    {
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3302:1: (lv_ids_3_0= ruleIndexIdentifier )
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3303:3: lv_ids_3_0= ruleIndexIdentifier
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAIndexListAccess().getIdsIndexIdentifierParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleIndexIdentifier_in_ruleAIndexList7312);
                    	    lv_ids_3_0=ruleIndexIdentifier();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAIndexListRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"ids",
                    	            		lv_ids_3_0, 
                    	            		"IndexIdentifier");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop57;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAIndexList"


    // $ANTLR start "entryRuleIndexAffineExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3327:1: entryRuleIndexAffineExpression returns [String current=null] : iv_ruleIndexAffineExpression= ruleIndexAffineExpression EOF ;
    public final String entryRuleIndexAffineExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIndexAffineExpression = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3328:2: (iv_ruleIndexAffineExpression= ruleIndexAffineExpression EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3329:2: iv_ruleIndexAffineExpression= ruleIndexAffineExpression EOF
            {
             newCompositeNode(grammarAccess.getIndexAffineExpressionRule()); 
            pushFollow(FOLLOW_ruleIndexAffineExpression_in_entryRuleIndexAffineExpression7353);
            iv_ruleIndexAffineExpression=ruleIndexAffineExpression();

            state._fsp--;

             current =iv_ruleIndexAffineExpression.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIndexAffineExpression7364); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIndexAffineExpression"


    // $ANTLR start "ruleIndexAffineExpression"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3336:1: ruleIndexAffineExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_OP_MINUS_0= RULE_OP_MINUS )? this_IndexAffineExpressionTerminal_1= ruleIndexAffineExpressionTerminal ( (this_OP_PLUS_2= RULE_OP_PLUS | this_OP_MINUS_3= RULE_OP_MINUS ) this_IndexAffineExpression_4= ruleIndexAffineExpression )* ) ;
    public final AntlrDatatypeRuleToken ruleIndexAffineExpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_OP_MINUS_0=null;
        Token this_OP_PLUS_2=null;
        Token this_OP_MINUS_3=null;
        AntlrDatatypeRuleToken this_IndexAffineExpressionTerminal_1 = null;

        AntlrDatatypeRuleToken this_IndexAffineExpression_4 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3339:28: ( ( (this_OP_MINUS_0= RULE_OP_MINUS )? this_IndexAffineExpressionTerminal_1= ruleIndexAffineExpressionTerminal ( (this_OP_PLUS_2= RULE_OP_PLUS | this_OP_MINUS_3= RULE_OP_MINUS ) this_IndexAffineExpression_4= ruleIndexAffineExpression )* ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3340:1: ( (this_OP_MINUS_0= RULE_OP_MINUS )? this_IndexAffineExpressionTerminal_1= ruleIndexAffineExpressionTerminal ( (this_OP_PLUS_2= RULE_OP_PLUS | this_OP_MINUS_3= RULE_OP_MINUS ) this_IndexAffineExpression_4= ruleIndexAffineExpression )* )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3340:1: ( (this_OP_MINUS_0= RULE_OP_MINUS )? this_IndexAffineExpressionTerminal_1= ruleIndexAffineExpressionTerminal ( (this_OP_PLUS_2= RULE_OP_PLUS | this_OP_MINUS_3= RULE_OP_MINUS ) this_IndexAffineExpression_4= ruleIndexAffineExpression )* )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3340:2: (this_OP_MINUS_0= RULE_OP_MINUS )? this_IndexAffineExpressionTerminal_1= ruleIndexAffineExpressionTerminal ( (this_OP_PLUS_2= RULE_OP_PLUS | this_OP_MINUS_3= RULE_OP_MINUS ) this_IndexAffineExpression_4= ruleIndexAffineExpression )*
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3340:2: (this_OP_MINUS_0= RULE_OP_MINUS )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_OP_MINUS) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3340:7: this_OP_MINUS_0= RULE_OP_MINUS
                    {
                    this_OP_MINUS_0=(Token)match(input,RULE_OP_MINUS,FOLLOW_RULE_OP_MINUS_in_ruleIndexAffineExpression7405); 

                    		current.merge(this_OP_MINUS_0);
                        
                     
                        newLeafNode(this_OP_MINUS_0, grammarAccess.getIndexAffineExpressionAccess().getOP_MINUSTerminalRuleCall_0()); 
                        

                    }
                    break;

            }

             
                    newCompositeNode(grammarAccess.getIndexAffineExpressionAccess().getIndexAffineExpressionTerminalParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleIndexAffineExpressionTerminal_in_ruleIndexAffineExpression7434);
            this_IndexAffineExpressionTerminal_1=ruleIndexAffineExpressionTerminal();

            state._fsp--;


            		current.merge(this_IndexAffineExpressionTerminal_1);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3358:1: ( (this_OP_PLUS_2= RULE_OP_PLUS | this_OP_MINUS_3= RULE_OP_MINUS ) this_IndexAffineExpression_4= ruleIndexAffineExpression )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==RULE_OP_PLUS) ) {
                    alt61=1;
                }
                else if ( (LA61_0==RULE_OP_MINUS) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3358:2: (this_OP_PLUS_2= RULE_OP_PLUS | this_OP_MINUS_3= RULE_OP_MINUS ) this_IndexAffineExpression_4= ruleIndexAffineExpression
            	    {
            	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3358:2: (this_OP_PLUS_2= RULE_OP_PLUS | this_OP_MINUS_3= RULE_OP_MINUS )
            	    int alt60=2;
            	    int LA60_0 = input.LA(1);

            	    if ( (LA60_0==RULE_OP_PLUS) ) {
            	        alt60=1;
            	    }
            	    else if ( (LA60_0==RULE_OP_MINUS) ) {
            	        alt60=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 60, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt60) {
            	        case 1 :
            	            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3358:7: this_OP_PLUS_2= RULE_OP_PLUS
            	            {
            	            this_OP_PLUS_2=(Token)match(input,RULE_OP_PLUS,FOLLOW_RULE_OP_PLUS_in_ruleIndexAffineExpression7456); 

            	            		current.merge(this_OP_PLUS_2);
            	                
            	             
            	                newLeafNode(this_OP_PLUS_2, grammarAccess.getIndexAffineExpressionAccess().getOP_PLUSTerminalRuleCall_2_0_0()); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3366:10: this_OP_MINUS_3= RULE_OP_MINUS
            	            {
            	            this_OP_MINUS_3=(Token)match(input,RULE_OP_MINUS,FOLLOW_RULE_OP_MINUS_in_ruleIndexAffineExpression7482); 

            	            		current.merge(this_OP_MINUS_3);
            	                
            	             
            	                newLeafNode(this_OP_MINUS_3, grammarAccess.getIndexAffineExpressionAccess().getOP_MINUSTerminalRuleCall_2_0_1()); 
            	                

            	            }
            	            break;

            	    }

            	     
            	            newCompositeNode(grammarAccess.getIndexAffineExpressionAccess().getIndexAffineExpressionParserRuleCall_2_1()); 
            	        
            	    pushFollow(FOLLOW_ruleIndexAffineExpression_in_ruleIndexAffineExpression7510);
            	    this_IndexAffineExpression_4=ruleIndexAffineExpression();

            	    state._fsp--;


            	    		current.merge(this_IndexAffineExpression_4);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIndexAffineExpression"


    // $ANTLR start "entryRuleIndexAffineExpressionTerminal"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3392:1: entryRuleIndexAffineExpressionTerminal returns [String current=null] : iv_ruleIndexAffineExpressionTerminal= ruleIndexAffineExpressionTerminal EOF ;
    public final String entryRuleIndexAffineExpressionTerminal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIndexAffineExpressionTerminal = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3393:2: (iv_ruleIndexAffineExpressionTerminal= ruleIndexAffineExpressionTerminal EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3394:2: iv_ruleIndexAffineExpressionTerminal= ruleIndexAffineExpressionTerminal EOF
            {
             newCompositeNode(grammarAccess.getIndexAffineExpressionTerminalRule()); 
            pushFollow(FOLLOW_ruleIndexAffineExpressionTerminal_in_entryRuleIndexAffineExpressionTerminal7558);
            iv_ruleIndexAffineExpressionTerminal=ruleIndexAffineExpressionTerminal();

            state._fsp--;

             current =iv_ruleIndexAffineExpressionTerminal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIndexAffineExpressionTerminal7569); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIndexAffineExpressionTerminal"


    // $ANTLR start "ruleIndexAffineExpressionTerminal"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3401:1: ruleIndexAffineExpressionTerminal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | ( (this_INT_1= RULE_INT )? this_IndexIdentifier_2= ruleIndexIdentifier ) ) ;
    public final AntlrDatatypeRuleToken ruleIndexAffineExpressionTerminal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token this_INT_1=null;
        AntlrDatatypeRuleToken this_IndexIdentifier_2 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3404:28: ( (this_INT_0= RULE_INT | ( (this_INT_1= RULE_INT )? this_IndexIdentifier_2= ruleIndexIdentifier ) ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3405:1: (this_INT_0= RULE_INT | ( (this_INT_1= RULE_INT )? this_IndexIdentifier_2= ruleIndexIdentifier ) )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3405:1: (this_INT_0= RULE_INT | ( (this_INT_1= RULE_INT )? this_IndexIdentifier_2= ruleIndexIdentifier ) )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==RULE_INT) ) {
                int LA63_1 = input.LA(2);

                if ( (LA63_1==RULE_ID) ) {
                    alt63=2;
                }
                else if ( (LA63_1==EOF||(LA63_1>=RULE_OP_PLUS && LA63_1<=RULE_OP_MINUS)||(LA63_1>=33 && LA63_1<=34)||LA63_1==46) ) {
                    alt63=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA63_0==RULE_ID) ) {
                alt63=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3405:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIndexAffineExpressionTerminal7609); 

                    		current.merge(this_INT_0);
                        
                     
                        newLeafNode(this_INT_0, grammarAccess.getIndexAffineExpressionTerminalAccess().getINTTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3413:6: ( (this_INT_1= RULE_INT )? this_IndexIdentifier_2= ruleIndexIdentifier )
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3413:6: ( (this_INT_1= RULE_INT )? this_IndexIdentifier_2= ruleIndexIdentifier )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3413:7: (this_INT_1= RULE_INT )? this_IndexIdentifier_2= ruleIndexIdentifier
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3413:7: (this_INT_1= RULE_INT )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==RULE_INT) ) {
                        alt62=1;
                    }
                    switch (alt62) {
                        case 1 :
                            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3413:12: this_INT_1= RULE_INT
                            {
                            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIndexAffineExpressionTerminal7637); 

                            		current.merge(this_INT_1);
                                
                             
                                newLeafNode(this_INT_1, grammarAccess.getIndexAffineExpressionTerminalAccess().getINTTerminalRuleCall_1_0()); 
                                

                            }
                            break;

                    }

                     
                            newCompositeNode(grammarAccess.getIndexAffineExpressionTerminalAccess().getIndexIdentifierParserRuleCall_1_1()); 
                        
                    pushFollow(FOLLOW_ruleIndexIdentifier_in_ruleIndexAffineExpressionTerminal7666);
                    this_IndexIdentifier_2=ruleIndexIdentifier();

                    state._fsp--;


                    		current.merge(this_IndexIdentifier_2);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIndexAffineExpressionTerminal"


    // $ANTLR start "entryRuleAIndexAffineExpressionList"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3439:1: entryRuleAIndexAffineExpressionList returns [EObject current=null] : iv_ruleAIndexAffineExpressionList= ruleAIndexAffineExpressionList EOF ;
    public final EObject entryRuleAIndexAffineExpressionList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAIndexAffineExpressionList = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3440:2: (iv_ruleAIndexAffineExpressionList= ruleAIndexAffineExpressionList EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3441:2: iv_ruleAIndexAffineExpressionList= ruleAIndexAffineExpressionList EOF
            {
             newCompositeNode(grammarAccess.getAIndexAffineExpressionListRule()); 
            pushFollow(FOLLOW_ruleAIndexAffineExpressionList_in_entryRuleAIndexAffineExpressionList7712);
            iv_ruleAIndexAffineExpressionList=ruleAIndexAffineExpressionList();

            state._fsp--;

             current =iv_ruleAIndexAffineExpressionList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAIndexAffineExpressionList7722); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAIndexAffineExpressionList"


    // $ANTLR start "ruleAIndexAffineExpressionList"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3448:1: ruleAIndexAffineExpressionList returns [EObject current=null] : ( () ( ( (lv_exprs_1_0= ruleIndexAffineExpression ) ) (otherlv_2= ',' ( (lv_exprs_3_0= ruleIndexAffineExpression ) ) )* )? ) ;
    public final EObject ruleAIndexAffineExpressionList() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_exprs_1_0 = null;

        AntlrDatatypeRuleToken lv_exprs_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3451:28: ( ( () ( ( (lv_exprs_1_0= ruleIndexAffineExpression ) ) (otherlv_2= ',' ( (lv_exprs_3_0= ruleIndexAffineExpression ) ) )* )? ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3452:1: ( () ( ( (lv_exprs_1_0= ruleIndexAffineExpression ) ) (otherlv_2= ',' ( (lv_exprs_3_0= ruleIndexAffineExpression ) ) )* )? )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3452:1: ( () ( ( (lv_exprs_1_0= ruleIndexAffineExpression ) ) (otherlv_2= ',' ( (lv_exprs_3_0= ruleIndexAffineExpression ) ) )* )? )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3452:2: () ( ( (lv_exprs_1_0= ruleIndexAffineExpression ) ) (otherlv_2= ',' ( (lv_exprs_3_0= ruleIndexAffineExpression ) ) )* )?
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3452:2: ()
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3453:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAIndexAffineExpressionListAccess().getAIndexAffineExpressionListAction_0(),
                        current);
                

            }

            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3458:2: ( ( (lv_exprs_1_0= ruleIndexAffineExpression ) ) (otherlv_2= ',' ( (lv_exprs_3_0= ruleIndexAffineExpression ) ) )* )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==RULE_ID||(LA65_0>=RULE_OP_MINUS && LA65_0<=RULE_INT)) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3458:3: ( (lv_exprs_1_0= ruleIndexAffineExpression ) ) (otherlv_2= ',' ( (lv_exprs_3_0= ruleIndexAffineExpression ) ) )*
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3458:3: ( (lv_exprs_1_0= ruleIndexAffineExpression ) )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3459:1: (lv_exprs_1_0= ruleIndexAffineExpression )
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3459:1: (lv_exprs_1_0= ruleIndexAffineExpression )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3460:3: lv_exprs_1_0= ruleIndexAffineExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getAIndexAffineExpressionListAccess().getExprsIndexAffineExpressionParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleIndexAffineExpression_in_ruleAIndexAffineExpressionList7778);
                    lv_exprs_1_0=ruleIndexAffineExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAIndexAffineExpressionListRule());
                    	        }
                           		add(
                           			current, 
                           			"exprs",
                            		lv_exprs_1_0, 
                            		"IndexAffineExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3476:2: (otherlv_2= ',' ( (lv_exprs_3_0= ruleIndexAffineExpression ) ) )*
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==33) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3476:4: otherlv_2= ',' ( (lv_exprs_3_0= ruleIndexAffineExpression ) )
                    	    {
                    	    otherlv_2=(Token)match(input,33,FOLLOW_33_in_ruleAIndexAffineExpressionList7791); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getAIndexAffineExpressionListAccess().getCommaKeyword_1_1_0());
                    	        
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3480:1: ( (lv_exprs_3_0= ruleIndexAffineExpression ) )
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3481:1: (lv_exprs_3_0= ruleIndexAffineExpression )
                    	    {
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3481:1: (lv_exprs_3_0= ruleIndexAffineExpression )
                    	    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3482:3: lv_exprs_3_0= ruleIndexAffineExpression
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAIndexAffineExpressionListAccess().getExprsIndexAffineExpressionParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleIndexAffineExpression_in_ruleAIndexAffineExpressionList7812);
                    	    lv_exprs_3_0=ruleIndexAffineExpression();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAIndexAffineExpressionListRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"exprs",
                    	            		lv_exprs_3_0, 
                    	            		"IndexAffineExpression");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop64;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAIndexAffineExpressionList"


    // $ANTLR start "entryRuleAFunction"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3506:1: entryRuleAFunction returns [EObject current=null] : iv_ruleAFunction= ruleAFunction EOF ;
    public final EObject entryRuleAFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAFunction = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3507:2: (iv_ruleAFunction= ruleAFunction EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3508:2: iv_ruleAFunction= ruleAFunction EOF
            {
             newCompositeNode(grammarAccess.getAFunctionRule()); 
            pushFollow(FOLLOW_ruleAFunction_in_entryRuleAFunction7852);
            iv_ruleAFunction=ruleAFunction();

            state._fsp--;

             current =iv_ruleAFunction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAFunction7862); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAFunction"


    // $ANTLR start "ruleAFunction"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3515:1: ruleAFunction returns [EObject current=null] : ( (otherlv_0= '(' ( (lv_indexes_1_0= ruleAIndexList ) ) otherlv_2= '->' otherlv_3= ')' ) | (otherlv_4= '(' ( (lv_indexes_5_0= ruleAIndexList ) ) otherlv_6= '->' ( (lv_func_7_0= ruleAIndexAffineExpressionList ) ) otherlv_8= ')' ) ) ;
    public final EObject ruleAFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_indexes_1_0 = null;

        EObject lv_indexes_5_0 = null;

        EObject lv_func_7_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3518:28: ( ( (otherlv_0= '(' ( (lv_indexes_1_0= ruleAIndexList ) ) otherlv_2= '->' otherlv_3= ')' ) | (otherlv_4= '(' ( (lv_indexes_5_0= ruleAIndexList ) ) otherlv_6= '->' ( (lv_func_7_0= ruleAIndexAffineExpressionList ) ) otherlv_8= ')' ) ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3519:1: ( (otherlv_0= '(' ( (lv_indexes_1_0= ruleAIndexList ) ) otherlv_2= '->' otherlv_3= ')' ) | (otherlv_4= '(' ( (lv_indexes_5_0= ruleAIndexList ) ) otherlv_6= '->' ( (lv_func_7_0= ruleAIndexAffineExpressionList ) ) otherlv_8= ')' ) )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3519:1: ( (otherlv_0= '(' ( (lv_indexes_1_0= ruleAIndexList ) ) otherlv_2= '->' otherlv_3= ')' ) | (otherlv_4= '(' ( (lv_indexes_5_0= ruleAIndexList ) ) otherlv_6= '->' ( (lv_func_7_0= ruleAIndexAffineExpressionList ) ) otherlv_8= ')' ) )
            int alt66=2;
            alt66 = dfa66.predict(input);
            switch (alt66) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3519:2: (otherlv_0= '(' ( (lv_indexes_1_0= ruleAIndexList ) ) otherlv_2= '->' otherlv_3= ')' )
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3519:2: (otherlv_0= '(' ( (lv_indexes_1_0= ruleAIndexList ) ) otherlv_2= '->' otherlv_3= ')' )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3519:4: otherlv_0= '(' ( (lv_indexes_1_0= ruleAIndexList ) ) otherlv_2= '->' otherlv_3= ')'
                    {
                    otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleAFunction7900); 

                        	newLeafNode(otherlv_0, grammarAccess.getAFunctionAccess().getLeftParenthesisKeyword_0_0());
                        
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3523:1: ( (lv_indexes_1_0= ruleAIndexList ) )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3524:1: (lv_indexes_1_0= ruleAIndexList )
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3524:1: (lv_indexes_1_0= ruleAIndexList )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3525:3: lv_indexes_1_0= ruleAIndexList
                    {
                     
                    	        newCompositeNode(grammarAccess.getAFunctionAccess().getIndexesAIndexListParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAIndexList_in_ruleAFunction7921);
                    lv_indexes_1_0=ruleAIndexList();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAFunctionRule());
                    	        }
                           		set(
                           			current, 
                           			"indexes",
                            		lv_indexes_1_0, 
                            		"AIndexList");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_2=(Token)match(input,56,FOLLOW_56_in_ruleAFunction7933); 

                        	newLeafNode(otherlv_2, grammarAccess.getAFunctionAccess().getHyphenMinusGreaterThanSignKeyword_0_2());
                        
                    otherlv_3=(Token)match(input,34,FOLLOW_34_in_ruleAFunction7945); 

                        	newLeafNode(otherlv_3, grammarAccess.getAFunctionAccess().getRightParenthesisKeyword_0_3());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3550:6: (otherlv_4= '(' ( (lv_indexes_5_0= ruleAIndexList ) ) otherlv_6= '->' ( (lv_func_7_0= ruleAIndexAffineExpressionList ) ) otherlv_8= ')' )
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3550:6: (otherlv_4= '(' ( (lv_indexes_5_0= ruleAIndexList ) ) otherlv_6= '->' ( (lv_func_7_0= ruleAIndexAffineExpressionList ) ) otherlv_8= ')' )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3550:8: otherlv_4= '(' ( (lv_indexes_5_0= ruleAIndexList ) ) otherlv_6= '->' ( (lv_func_7_0= ruleAIndexAffineExpressionList ) ) otherlv_8= ')'
                    {
                    otherlv_4=(Token)match(input,32,FOLLOW_32_in_ruleAFunction7965); 

                        	newLeafNode(otherlv_4, grammarAccess.getAFunctionAccess().getLeftParenthesisKeyword_1_0());
                        
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3554:1: ( (lv_indexes_5_0= ruleAIndexList ) )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3555:1: (lv_indexes_5_0= ruleAIndexList )
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3555:1: (lv_indexes_5_0= ruleAIndexList )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3556:3: lv_indexes_5_0= ruleAIndexList
                    {
                     
                    	        newCompositeNode(grammarAccess.getAFunctionAccess().getIndexesAIndexListParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAIndexList_in_ruleAFunction7986);
                    lv_indexes_5_0=ruleAIndexList();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAFunctionRule());
                    	        }
                           		set(
                           			current, 
                           			"indexes",
                            		lv_indexes_5_0, 
                            		"AIndexList");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,56,FOLLOW_56_in_ruleAFunction7998); 

                        	newLeafNode(otherlv_6, grammarAccess.getAFunctionAccess().getHyphenMinusGreaterThanSignKeyword_1_2());
                        
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3576:1: ( (lv_func_7_0= ruleAIndexAffineExpressionList ) )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3577:1: (lv_func_7_0= ruleAIndexAffineExpressionList )
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3577:1: (lv_func_7_0= ruleAIndexAffineExpressionList )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3578:3: lv_func_7_0= ruleAIndexAffineExpressionList
                    {
                     
                    	        newCompositeNode(grammarAccess.getAFunctionAccess().getFuncAIndexAffineExpressionListParserRuleCall_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAIndexAffineExpressionList_in_ruleAFunction8019);
                    lv_func_7_0=ruleAIndexAffineExpressionList();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAFunctionRule());
                    	        }
                           		set(
                           			current, 
                           			"func",
                            		lv_func_7_0, 
                            		"AIndexAffineExpressionList");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_8=(Token)match(input,34,FOLLOW_34_in_ruleAFunction8031); 

                        	newLeafNode(otherlv_8, grammarAccess.getAFunctionAccess().getRightParenthesisKeyword_1_4());
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAFunction"


    // $ANTLR start "entryRuleAFunctionInArrayNotation"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3606:1: entryRuleAFunctionInArrayNotation returns [EObject current=null] : iv_ruleAFunctionInArrayNotation= ruleAFunctionInArrayNotation EOF ;
    public final EObject entryRuleAFunctionInArrayNotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAFunctionInArrayNotation = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3607:2: (iv_ruleAFunctionInArrayNotation= ruleAFunctionInArrayNotation EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3608:2: iv_ruleAFunctionInArrayNotation= ruleAFunctionInArrayNotation EOF
            {
             newCompositeNode(grammarAccess.getAFunctionInArrayNotationRule()); 
            pushFollow(FOLLOW_ruleAFunctionInArrayNotation_in_entryRuleAFunctionInArrayNotation8068);
            iv_ruleAFunctionInArrayNotation=ruleAFunctionInArrayNotation();

            state._fsp--;

             current =iv_ruleAFunctionInArrayNotation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAFunctionInArrayNotation8078); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAFunctionInArrayNotation"


    // $ANTLR start "ruleAFunctionInArrayNotation"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3615:1: ruleAFunctionInArrayNotation returns [EObject current=null] : (otherlv_0= '[' ( (lv_newIds_1_0= ruleAIndexAffineExpressionList ) ) otherlv_2= ']' ) ;
    public final EObject ruleAFunctionInArrayNotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_newIds_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3618:28: ( (otherlv_0= '[' ( (lv_newIds_1_0= ruleAIndexAffineExpressionList ) ) otherlv_2= ']' ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3619:1: (otherlv_0= '[' ( (lv_newIds_1_0= ruleAIndexAffineExpressionList ) ) otherlv_2= ']' )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3619:1: (otherlv_0= '[' ( (lv_newIds_1_0= ruleAIndexAffineExpressionList ) ) otherlv_2= ']' )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3619:3: otherlv_0= '[' ( (lv_newIds_1_0= ruleAIndexAffineExpressionList ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,45,FOLLOW_45_in_ruleAFunctionInArrayNotation8115); 

                	newLeafNode(otherlv_0, grammarAccess.getAFunctionInArrayNotationAccess().getLeftSquareBracketKeyword_0());
                
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3623:1: ( (lv_newIds_1_0= ruleAIndexAffineExpressionList ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3624:1: (lv_newIds_1_0= ruleAIndexAffineExpressionList )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3624:1: (lv_newIds_1_0= ruleAIndexAffineExpressionList )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3625:3: lv_newIds_1_0= ruleAIndexAffineExpressionList
            {
             
            	        newCompositeNode(grammarAccess.getAFunctionInArrayNotationAccess().getNewIdsAIndexAffineExpressionListParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleAIndexAffineExpressionList_in_ruleAFunctionInArrayNotation8136);
            lv_newIds_1_0=ruleAIndexAffineExpressionList();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAFunctionInArrayNotationRule());
            	        }
                   		set(
                   			current, 
                   			"newIds",
                    		lv_newIds_1_0, 
                    		"AIndexAffineExpressionList");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,46,FOLLOW_46_in_ruleAFunctionInArrayNotation8148); 

                	newLeafNode(otherlv_2, grammarAccess.getAFunctionInArrayNotationAccess().getRightSquareBracketKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAFunctionInArrayNotation"


    // $ANTLR start "entryRuleAType"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3653:1: entryRuleAType returns [EObject current=null] : iv_ruleAType= ruleAType EOF ;
    public final EObject entryRuleAType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAType = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3654:2: (iv_ruleAType= ruleAType EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3655:2: iv_ruleAType= ruleAType EOF
            {
             newCompositeNode(grammarAccess.getATypeRule()); 
            pushFollow(FOLLOW_ruleAType_in_entryRuleAType8184);
            iv_ruleAType=ruleAType();

            state._fsp--;

             current =iv_ruleAType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAType8194); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAType"


    // $ANTLR start "ruleAType"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3662:1: ruleAType returns [EObject current=null] : ( ( (lv_unsigned_0_0= 'unsigned' ) )? ( ( (lv_type_1_1= ruleATypeInteger | lv_type_1_2= ruleATypeFloat | lv_type_1_3= ruleATypeBoolean | lv_type_1_4= ruleATypeChar ) ) ) ) ;
    public final EObject ruleAType() throws RecognitionException {
        EObject current = null;

        Token lv_unsigned_0_0=null;
        AntlrDatatypeRuleToken lv_type_1_1 = null;

        AntlrDatatypeRuleToken lv_type_1_2 = null;

        AntlrDatatypeRuleToken lv_type_1_3 = null;

        AntlrDatatypeRuleToken lv_type_1_4 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3665:28: ( ( ( (lv_unsigned_0_0= 'unsigned' ) )? ( ( (lv_type_1_1= ruleATypeInteger | lv_type_1_2= ruleATypeFloat | lv_type_1_3= ruleATypeBoolean | lv_type_1_4= ruleATypeChar ) ) ) ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3666:1: ( ( (lv_unsigned_0_0= 'unsigned' ) )? ( ( (lv_type_1_1= ruleATypeInteger | lv_type_1_2= ruleATypeFloat | lv_type_1_3= ruleATypeBoolean | lv_type_1_4= ruleATypeChar ) ) ) )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3666:1: ( ( (lv_unsigned_0_0= 'unsigned' ) )? ( ( (lv_type_1_1= ruleATypeInteger | lv_type_1_2= ruleATypeFloat | lv_type_1_3= ruleATypeBoolean | lv_type_1_4= ruleATypeChar ) ) ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3666:2: ( (lv_unsigned_0_0= 'unsigned' ) )? ( ( (lv_type_1_1= ruleATypeInteger | lv_type_1_2= ruleATypeFloat | lv_type_1_3= ruleATypeBoolean | lv_type_1_4= ruleATypeChar ) ) )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3666:2: ( (lv_unsigned_0_0= 'unsigned' ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==59) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3667:1: (lv_unsigned_0_0= 'unsigned' )
                    {
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3667:1: (lv_unsigned_0_0= 'unsigned' )
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3668:3: lv_unsigned_0_0= 'unsigned'
                    {
                    lv_unsigned_0_0=(Token)match(input,59,FOLLOW_59_in_ruleAType8237); 

                            newLeafNode(lv_unsigned_0_0, grammarAccess.getATypeAccess().getUnsignedUnsignedKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getATypeRule());
                    	        }
                           		setWithLastConsumed(current, "unsigned", lv_unsigned_0_0, "unsigned");
                    	    

                    }


                    }
                    break;

            }

            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3681:3: ( ( (lv_type_1_1= ruleATypeInteger | lv_type_1_2= ruleATypeFloat | lv_type_1_3= ruleATypeBoolean | lv_type_1_4= ruleATypeChar ) ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3682:1: ( (lv_type_1_1= ruleATypeInteger | lv_type_1_2= ruleATypeFloat | lv_type_1_3= ruleATypeBoolean | lv_type_1_4= ruleATypeChar ) )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3682:1: ( (lv_type_1_1= ruleATypeInteger | lv_type_1_2= ruleATypeFloat | lv_type_1_3= ruleATypeBoolean | lv_type_1_4= ruleATypeChar ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3683:1: (lv_type_1_1= ruleATypeInteger | lv_type_1_2= ruleATypeFloat | lv_type_1_3= ruleATypeBoolean | lv_type_1_4= ruleATypeChar )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3683:1: (lv_type_1_1= ruleATypeInteger | lv_type_1_2= ruleATypeFloat | lv_type_1_3= ruleATypeBoolean | lv_type_1_4= ruleATypeChar )
            int alt68=4;
            switch ( input.LA(1) ) {
            case 60:
            case 61:
            case 62:
            case 63:
                {
                alt68=1;
                }
                break;
            case 65:
            case 66:
                {
                alt68=2;
                }
                break;
            case 64:
                {
                alt68=3;
                }
                break;
            case 67:
                {
                alt68=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }

            switch (alt68) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3684:3: lv_type_1_1= ruleATypeInteger
                    {
                     
                    	        newCompositeNode(grammarAccess.getATypeAccess().getTypeATypeIntegerParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleATypeInteger_in_ruleAType8274);
                    lv_type_1_1=ruleATypeInteger();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getATypeRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_1_1, 
                            		"ATypeInteger");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3699:8: lv_type_1_2= ruleATypeFloat
                    {
                     
                    	        newCompositeNode(grammarAccess.getATypeAccess().getTypeATypeFloatParserRuleCall_1_0_1()); 
                    	    
                    pushFollow(FOLLOW_ruleATypeFloat_in_ruleAType8293);
                    lv_type_1_2=ruleATypeFloat();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getATypeRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_1_2, 
                            		"ATypeFloat");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;
                case 3 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3714:8: lv_type_1_3= ruleATypeBoolean
                    {
                     
                    	        newCompositeNode(grammarAccess.getATypeAccess().getTypeATypeBooleanParserRuleCall_1_0_2()); 
                    	    
                    pushFollow(FOLLOW_ruleATypeBoolean_in_ruleAType8312);
                    lv_type_1_3=ruleATypeBoolean();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getATypeRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_1_3, 
                            		"ATypeBoolean");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;
                case 4 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3729:8: lv_type_1_4= ruleATypeChar
                    {
                     
                    	        newCompositeNode(grammarAccess.getATypeAccess().getTypeATypeCharParserRuleCall_1_0_3()); 
                    	    
                    pushFollow(FOLLOW_ruleATypeChar_in_ruleAType8331);
                    lv_type_1_4=ruleATypeChar();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getATypeRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_1_4, 
                            		"ATypeChar");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;

            }


            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAType"


    // $ANTLR start "entryRuleATypeInteger"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3755:1: entryRuleATypeInteger returns [String current=null] : iv_ruleATypeInteger= ruleATypeInteger EOF ;
    public final String entryRuleATypeInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleATypeInteger = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3756:2: (iv_ruleATypeInteger= ruleATypeInteger EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3757:2: iv_ruleATypeInteger= ruleATypeInteger EOF
            {
             newCompositeNode(grammarAccess.getATypeIntegerRule()); 
            pushFollow(FOLLOW_ruleATypeInteger_in_entryRuleATypeInteger8371);
            iv_ruleATypeInteger=ruleATypeInteger();

            state._fsp--;

             current =iv_ruleATypeInteger.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleATypeInteger8382); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleATypeInteger"


    // $ANTLR start "ruleATypeInteger"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3764:1: ruleATypeInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'int' | kw= 'longlong' | kw= 'long' | kw= 'short' ) ;
    public final AntlrDatatypeRuleToken ruleATypeInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3767:28: ( (kw= 'int' | kw= 'longlong' | kw= 'long' | kw= 'short' ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3768:1: (kw= 'int' | kw= 'longlong' | kw= 'long' | kw= 'short' )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3768:1: (kw= 'int' | kw= 'longlong' | kw= 'long' | kw= 'short' )
            int alt69=4;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt69=1;
                }
                break;
            case 61:
                {
                alt69=2;
                }
                break;
            case 62:
                {
                alt69=3;
                }
                break;
            case 63:
                {
                alt69=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }

            switch (alt69) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3769:2: kw= 'int'
                    {
                    kw=(Token)match(input,60,FOLLOW_60_in_ruleATypeInteger8420); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getATypeIntegerAccess().getIntKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3776:2: kw= 'longlong'
                    {
                    kw=(Token)match(input,61,FOLLOW_61_in_ruleATypeInteger8439); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getATypeIntegerAccess().getLonglongKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3783:2: kw= 'long'
                    {
                    kw=(Token)match(input,62,FOLLOW_62_in_ruleATypeInteger8458); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getATypeIntegerAccess().getLongKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3790:2: kw= 'short'
                    {
                    kw=(Token)match(input,63,FOLLOW_63_in_ruleATypeInteger8477); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getATypeIntegerAccess().getShortKeyword_3()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleATypeInteger"


    // $ANTLR start "entryRuleATypeBoolean"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3803:1: entryRuleATypeBoolean returns [String current=null] : iv_ruleATypeBoolean= ruleATypeBoolean EOF ;
    public final String entryRuleATypeBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleATypeBoolean = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3804:2: (iv_ruleATypeBoolean= ruleATypeBoolean EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3805:2: iv_ruleATypeBoolean= ruleATypeBoolean EOF
            {
             newCompositeNode(grammarAccess.getATypeBooleanRule()); 
            pushFollow(FOLLOW_ruleATypeBoolean_in_entryRuleATypeBoolean8518);
            iv_ruleATypeBoolean=ruleATypeBoolean();

            state._fsp--;

             current =iv_ruleATypeBoolean.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleATypeBoolean8529); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleATypeBoolean"


    // $ANTLR start "ruleATypeBoolean"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3812:1: ruleATypeBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'bool' ;
    public final AntlrDatatypeRuleToken ruleATypeBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3815:28: (kw= 'bool' )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3817:2: kw= 'bool'
            {
            kw=(Token)match(input,64,FOLLOW_64_in_ruleATypeBoolean8566); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getATypeBooleanAccess().getBoolKeyword()); 
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleATypeBoolean"


    // $ANTLR start "entryRuleATypeFloat"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3830:1: entryRuleATypeFloat returns [String current=null] : iv_ruleATypeFloat= ruleATypeFloat EOF ;
    public final String entryRuleATypeFloat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleATypeFloat = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3831:2: (iv_ruleATypeFloat= ruleATypeFloat EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3832:2: iv_ruleATypeFloat= ruleATypeFloat EOF
            {
             newCompositeNode(grammarAccess.getATypeFloatRule()); 
            pushFollow(FOLLOW_ruleATypeFloat_in_entryRuleATypeFloat8606);
            iv_ruleATypeFloat=ruleATypeFloat();

            state._fsp--;

             current =iv_ruleATypeFloat.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleATypeFloat8617); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleATypeFloat"


    // $ANTLR start "ruleATypeFloat"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3839:1: ruleATypeFloat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'float' | kw= 'double' ) ;
    public final AntlrDatatypeRuleToken ruleATypeFloat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3842:28: ( (kw= 'float' | kw= 'double' ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3843:1: (kw= 'float' | kw= 'double' )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3843:1: (kw= 'float' | kw= 'double' )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==65) ) {
                alt70=1;
            }
            else if ( (LA70_0==66) ) {
                alt70=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3844:2: kw= 'float'
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleATypeFloat8655); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getATypeFloatAccess().getFloatKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3851:2: kw= 'double'
                    {
                    kw=(Token)match(input,66,FOLLOW_66_in_ruleATypeFloat8674); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getATypeFloatAccess().getDoubleKeyword_1()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleATypeFloat"


    // $ANTLR start "entryRuleATypeChar"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3864:1: entryRuleATypeChar returns [String current=null] : iv_ruleATypeChar= ruleATypeChar EOF ;
    public final String entryRuleATypeChar() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleATypeChar = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3865:2: (iv_ruleATypeChar= ruleATypeChar EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3866:2: iv_ruleATypeChar= ruleATypeChar EOF
            {
             newCompositeNode(grammarAccess.getATypeCharRule()); 
            pushFollow(FOLLOW_ruleATypeChar_in_entryRuleATypeChar8715);
            iv_ruleATypeChar=ruleATypeChar();

            state._fsp--;

             current =iv_ruleATypeChar.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleATypeChar8726); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleATypeChar"


    // $ANTLR start "ruleATypeChar"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3873:1: ruleATypeChar returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'char' ;
    public final AntlrDatatypeRuleToken ruleATypeChar() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3876:28: (kw= 'char' )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3878:2: kw= 'char'
            {
            kw=(Token)match(input,67,FOLLOW_67_in_ruleATypeChar8763); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getATypeCharAccess().getCharKeyword()); 
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleATypeChar"


    // $ANTLR start "entryRuleReductionOp"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3891:1: entryRuleReductionOp returns [String current=null] : iv_ruleReductionOp= ruleReductionOp EOF ;
    public final String entryRuleReductionOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReductionOp = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3892:2: (iv_ruleReductionOp= ruleReductionOp EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3893:2: iv_ruleReductionOp= ruleReductionOp EOF
            {
             newCompositeNode(grammarAccess.getReductionOpRule()); 
            pushFollow(FOLLOW_ruleReductionOp_in_entryRuleReductionOp8803);
            iv_ruleReductionOp=ruleReductionOp();

            state._fsp--;

             current =iv_ruleReductionOp.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReductionOp8814); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReductionOp"


    // $ANTLR start "ruleReductionOp"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3900:1: ruleReductionOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_OP_AND_0= RULE_OP_AND | this_OP_MAX_1= RULE_OP_MAX | this_OP_MIN_2= RULE_OP_MIN | this_OP_MUL_3= RULE_OP_MUL | this_OP_OR_4= RULE_OP_OR | this_OP_PLUS_5= RULE_OP_PLUS | this_XOP_OR_6= RULE_XOP_OR ) ;
    public final AntlrDatatypeRuleToken ruleReductionOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_OP_AND_0=null;
        Token this_OP_MAX_1=null;
        Token this_OP_MIN_2=null;
        Token this_OP_MUL_3=null;
        Token this_OP_OR_4=null;
        Token this_OP_PLUS_5=null;
        Token this_XOP_OR_6=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3903:28: ( (this_OP_AND_0= RULE_OP_AND | this_OP_MAX_1= RULE_OP_MAX | this_OP_MIN_2= RULE_OP_MIN | this_OP_MUL_3= RULE_OP_MUL | this_OP_OR_4= RULE_OP_OR | this_OP_PLUS_5= RULE_OP_PLUS | this_XOP_OR_6= RULE_XOP_OR ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3904:1: (this_OP_AND_0= RULE_OP_AND | this_OP_MAX_1= RULE_OP_MAX | this_OP_MIN_2= RULE_OP_MIN | this_OP_MUL_3= RULE_OP_MUL | this_OP_OR_4= RULE_OP_OR | this_OP_PLUS_5= RULE_OP_PLUS | this_XOP_OR_6= RULE_XOP_OR )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3904:1: (this_OP_AND_0= RULE_OP_AND | this_OP_MAX_1= RULE_OP_MAX | this_OP_MIN_2= RULE_OP_MIN | this_OP_MUL_3= RULE_OP_MUL | this_OP_OR_4= RULE_OP_OR | this_OP_PLUS_5= RULE_OP_PLUS | this_XOP_OR_6= RULE_XOP_OR )
            int alt71=7;
            switch ( input.LA(1) ) {
            case RULE_OP_AND:
                {
                alt71=1;
                }
                break;
            case RULE_OP_MAX:
                {
                alt71=2;
                }
                break;
            case RULE_OP_MIN:
                {
                alt71=3;
                }
                break;
            case RULE_OP_MUL:
                {
                alt71=4;
                }
                break;
            case RULE_OP_OR:
                {
                alt71=5;
                }
                break;
            case RULE_OP_PLUS:
                {
                alt71=6;
                }
                break;
            case RULE_XOP_OR:
                {
                alt71=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }

            switch (alt71) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3904:6: this_OP_AND_0= RULE_OP_AND
                    {
                    this_OP_AND_0=(Token)match(input,RULE_OP_AND,FOLLOW_RULE_OP_AND_in_ruleReductionOp8854); 

                    		current.merge(this_OP_AND_0);
                        
                     
                        newLeafNode(this_OP_AND_0, grammarAccess.getReductionOpAccess().getOP_ANDTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3912:10: this_OP_MAX_1= RULE_OP_MAX
                    {
                    this_OP_MAX_1=(Token)match(input,RULE_OP_MAX,FOLLOW_RULE_OP_MAX_in_ruleReductionOp8880); 

                    		current.merge(this_OP_MAX_1);
                        
                     
                        newLeafNode(this_OP_MAX_1, grammarAccess.getReductionOpAccess().getOP_MAXTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3920:10: this_OP_MIN_2= RULE_OP_MIN
                    {
                    this_OP_MIN_2=(Token)match(input,RULE_OP_MIN,FOLLOW_RULE_OP_MIN_in_ruleReductionOp8906); 

                    		current.merge(this_OP_MIN_2);
                        
                     
                        newLeafNode(this_OP_MIN_2, grammarAccess.getReductionOpAccess().getOP_MINTerminalRuleCall_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3928:10: this_OP_MUL_3= RULE_OP_MUL
                    {
                    this_OP_MUL_3=(Token)match(input,RULE_OP_MUL,FOLLOW_RULE_OP_MUL_in_ruleReductionOp8932); 

                    		current.merge(this_OP_MUL_3);
                        
                     
                        newLeafNode(this_OP_MUL_3, grammarAccess.getReductionOpAccess().getOP_MULTerminalRuleCall_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3936:10: this_OP_OR_4= RULE_OP_OR
                    {
                    this_OP_OR_4=(Token)match(input,RULE_OP_OR,FOLLOW_RULE_OP_OR_in_ruleReductionOp8958); 

                    		current.merge(this_OP_OR_4);
                        
                     
                        newLeafNode(this_OP_OR_4, grammarAccess.getReductionOpAccess().getOP_ORTerminalRuleCall_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3944:10: this_OP_PLUS_5= RULE_OP_PLUS
                    {
                    this_OP_PLUS_5=(Token)match(input,RULE_OP_PLUS,FOLLOW_RULE_OP_PLUS_in_ruleReductionOp8984); 

                    		current.merge(this_OP_PLUS_5);
                        
                     
                        newLeafNode(this_OP_PLUS_5, grammarAccess.getReductionOpAccess().getOP_PLUSTerminalRuleCall_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3952:10: this_XOP_OR_6= RULE_XOP_OR
                    {
                    this_XOP_OR_6=(Token)match(input,RULE_XOP_OR,FOLLOW_RULE_XOP_OR_in_ruleReductionOp9010); 

                    		current.merge(this_XOP_OR_6);
                        
                     
                        newLeafNode(this_XOP_OR_6, grammarAccess.getReductionOpAccess().getXOP_ORTerminalRuleCall_6()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReductionOp"


    // $ANTLR start "entryRuleArithmeticOp"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3967:1: entryRuleArithmeticOp returns [String current=null] : iv_ruleArithmeticOp= ruleArithmeticOp EOF ;
    public final String entryRuleArithmeticOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleArithmeticOp = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3968:2: (iv_ruleArithmeticOp= ruleArithmeticOp EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3969:2: iv_ruleArithmeticOp= ruleArithmeticOp EOF
            {
             newCompositeNode(grammarAccess.getArithmeticOpRule()); 
            pushFollow(FOLLOW_ruleArithmeticOp_in_entryRuleArithmeticOp9056);
            iv_ruleArithmeticOp=ruleArithmeticOp();

            state._fsp--;

             current =iv_ruleArithmeticOp.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArithmeticOp9067); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArithmeticOp"


    // $ANTLR start "ruleArithmeticOp"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3976:1: ruleArithmeticOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_OP_MAX_0= RULE_OP_MAX | this_OP_MIN_1= RULE_OP_MIN | this_OP_MUL_2= RULE_OP_MUL | this_OP_PLUS_3= RULE_OP_PLUS ) ;
    public final AntlrDatatypeRuleToken ruleArithmeticOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_OP_MAX_0=null;
        Token this_OP_MIN_1=null;
        Token this_OP_MUL_2=null;
        Token this_OP_PLUS_3=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3979:28: ( (this_OP_MAX_0= RULE_OP_MAX | this_OP_MIN_1= RULE_OP_MIN | this_OP_MUL_2= RULE_OP_MUL | this_OP_PLUS_3= RULE_OP_PLUS ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3980:1: (this_OP_MAX_0= RULE_OP_MAX | this_OP_MIN_1= RULE_OP_MIN | this_OP_MUL_2= RULE_OP_MUL | this_OP_PLUS_3= RULE_OP_PLUS )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3980:1: (this_OP_MAX_0= RULE_OP_MAX | this_OP_MIN_1= RULE_OP_MIN | this_OP_MUL_2= RULE_OP_MUL | this_OP_PLUS_3= RULE_OP_PLUS )
            int alt72=4;
            switch ( input.LA(1) ) {
            case RULE_OP_MAX:
                {
                alt72=1;
                }
                break;
            case RULE_OP_MIN:
                {
                alt72=2;
                }
                break;
            case RULE_OP_MUL:
                {
                alt72=3;
                }
                break;
            case RULE_OP_PLUS:
                {
                alt72=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }

            switch (alt72) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3980:6: this_OP_MAX_0= RULE_OP_MAX
                    {
                    this_OP_MAX_0=(Token)match(input,RULE_OP_MAX,FOLLOW_RULE_OP_MAX_in_ruleArithmeticOp9107); 

                    		current.merge(this_OP_MAX_0);
                        
                     
                        newLeafNode(this_OP_MAX_0, grammarAccess.getArithmeticOpAccess().getOP_MAXTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3988:10: this_OP_MIN_1= RULE_OP_MIN
                    {
                    this_OP_MIN_1=(Token)match(input,RULE_OP_MIN,FOLLOW_RULE_OP_MIN_in_ruleArithmeticOp9133); 

                    		current.merge(this_OP_MIN_1);
                        
                     
                        newLeafNode(this_OP_MIN_1, grammarAccess.getArithmeticOpAccess().getOP_MINTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3996:10: this_OP_MUL_2= RULE_OP_MUL
                    {
                    this_OP_MUL_2=(Token)match(input,RULE_OP_MUL,FOLLOW_RULE_OP_MUL_in_ruleArithmeticOp9159); 

                    		current.merge(this_OP_MUL_2);
                        
                     
                        newLeafNode(this_OP_MUL_2, grammarAccess.getArithmeticOpAccess().getOP_MULTerminalRuleCall_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4004:10: this_OP_PLUS_3= RULE_OP_PLUS
                    {
                    this_OP_PLUS_3=(Token)match(input,RULE_OP_PLUS,FOLLOW_RULE_OP_PLUS_in_ruleArithmeticOp9185); 

                    		current.merge(this_OP_PLUS_3);
                        
                     
                        newLeafNode(this_OP_PLUS_3, grammarAccess.getArithmeticOpAccess().getOP_PLUSTerminalRuleCall_3()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArithmeticOp"


    // $ANTLR start "entryRuleLogicalOp"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4019:1: entryRuleLogicalOp returns [String current=null] : iv_ruleLogicalOp= ruleLogicalOp EOF ;
    public final String entryRuleLogicalOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOp = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4020:2: (iv_ruleLogicalOp= ruleLogicalOp EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4021:2: iv_ruleLogicalOp= ruleLogicalOp EOF
            {
             newCompositeNode(grammarAccess.getLogicalOpRule()); 
            pushFollow(FOLLOW_ruleLogicalOp_in_entryRuleLogicalOp9231);
            iv_ruleLogicalOp=ruleLogicalOp();

            state._fsp--;

             current =iv_ruleLogicalOp.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOp9242); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalOp"


    // $ANTLR start "ruleLogicalOp"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4028:1: ruleLogicalOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_OP_AND_0= RULE_OP_AND | this_OP_OR_1= RULE_OP_OR | this_XOP_OR_2= RULE_XOP_OR ) ;
    public final AntlrDatatypeRuleToken ruleLogicalOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_OP_AND_0=null;
        Token this_OP_OR_1=null;
        Token this_XOP_OR_2=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4031:28: ( (this_OP_AND_0= RULE_OP_AND | this_OP_OR_1= RULE_OP_OR | this_XOP_OR_2= RULE_XOP_OR ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4032:1: (this_OP_AND_0= RULE_OP_AND | this_OP_OR_1= RULE_OP_OR | this_XOP_OR_2= RULE_XOP_OR )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4032:1: (this_OP_AND_0= RULE_OP_AND | this_OP_OR_1= RULE_OP_OR | this_XOP_OR_2= RULE_XOP_OR )
            int alt73=3;
            switch ( input.LA(1) ) {
            case RULE_OP_AND:
                {
                alt73=1;
                }
                break;
            case RULE_OP_OR:
                {
                alt73=2;
                }
                break;
            case RULE_XOP_OR:
                {
                alt73=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }

            switch (alt73) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4032:6: this_OP_AND_0= RULE_OP_AND
                    {
                    this_OP_AND_0=(Token)match(input,RULE_OP_AND,FOLLOW_RULE_OP_AND_in_ruleLogicalOp9282); 

                    		current.merge(this_OP_AND_0);
                        
                     
                        newLeafNode(this_OP_AND_0, grammarAccess.getLogicalOpAccess().getOP_ANDTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4040:10: this_OP_OR_1= RULE_OP_OR
                    {
                    this_OP_OR_1=(Token)match(input,RULE_OP_OR,FOLLOW_RULE_OP_OR_in_ruleLogicalOp9308); 

                    		current.merge(this_OP_OR_1);
                        
                     
                        newLeafNode(this_OP_OR_1, grammarAccess.getLogicalOpAccess().getOP_ORTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4048:10: this_XOP_OR_2= RULE_XOP_OR
                    {
                    this_XOP_OR_2=(Token)match(input,RULE_XOP_OR,FOLLOW_RULE_XOP_OR_in_ruleLogicalOp9334); 

                    		current.merge(this_XOP_OR_2);
                        
                     
                        newLeafNode(this_XOP_OR_2, grammarAccess.getLogicalOpAccess().getXOP_ORTerminalRuleCall_2()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalOp"


    // $ANTLR start "entryRuleRelationalOp"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4063:1: entryRuleRelationalOp returns [String current=null] : iv_ruleRelationalOp= ruleRelationalOp EOF ;
    public final String entryRuleRelationalOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOp = null;


        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4064:2: (iv_ruleRelationalOp= ruleRelationalOp EOF )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4065:2: iv_ruleRelationalOp= ruleRelationalOp EOF
            {
             newCompositeNode(grammarAccess.getRelationalOpRule()); 
            pushFollow(FOLLOW_ruleRelationalOp_in_entryRuleRelationalOp9380);
            iv_ruleRelationalOp=ruleRelationalOp();

            state._fsp--;

             current =iv_ruleRelationalOp.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalOp9391); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalOp"


    // $ANTLR start "ruleRelationalOp"
    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4072:1: ruleRelationalOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_OP_EQ_0= RULE_OP_EQ | this_OP_GE_1= RULE_OP_GE | this_OP_GT_2= RULE_OP_GT | this_OP_LE_3= RULE_OP_LE | this_OP_LT_4= RULE_OP_LT | this_OP_NE_5= RULE_OP_NE ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_OP_EQ_0=null;
        Token this_OP_GE_1=null;
        Token this_OP_GT_2=null;
        Token this_OP_LE_3=null;
        Token this_OP_LT_4=null;
        Token this_OP_NE_5=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4075:28: ( (this_OP_EQ_0= RULE_OP_EQ | this_OP_GE_1= RULE_OP_GE | this_OP_GT_2= RULE_OP_GT | this_OP_LE_3= RULE_OP_LE | this_OP_LT_4= RULE_OP_LT | this_OP_NE_5= RULE_OP_NE ) )
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4076:1: (this_OP_EQ_0= RULE_OP_EQ | this_OP_GE_1= RULE_OP_GE | this_OP_GT_2= RULE_OP_GT | this_OP_LE_3= RULE_OP_LE | this_OP_LT_4= RULE_OP_LT | this_OP_NE_5= RULE_OP_NE )
            {
            // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4076:1: (this_OP_EQ_0= RULE_OP_EQ | this_OP_GE_1= RULE_OP_GE | this_OP_GT_2= RULE_OP_GT | this_OP_LE_3= RULE_OP_LE | this_OP_LT_4= RULE_OP_LT | this_OP_NE_5= RULE_OP_NE )
            int alt74=6;
            switch ( input.LA(1) ) {
            case RULE_OP_EQ:
                {
                alt74=1;
                }
                break;
            case RULE_OP_GE:
                {
                alt74=2;
                }
                break;
            case RULE_OP_GT:
                {
                alt74=3;
                }
                break;
            case RULE_OP_LE:
                {
                alt74=4;
                }
                break;
            case RULE_OP_LT:
                {
                alt74=5;
                }
                break;
            case RULE_OP_NE:
                {
                alt74=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }

            switch (alt74) {
                case 1 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4076:6: this_OP_EQ_0= RULE_OP_EQ
                    {
                    this_OP_EQ_0=(Token)match(input,RULE_OP_EQ,FOLLOW_RULE_OP_EQ_in_ruleRelationalOp9431); 

                    		current.merge(this_OP_EQ_0);
                        
                     
                        newLeafNode(this_OP_EQ_0, grammarAccess.getRelationalOpAccess().getOP_EQTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4084:10: this_OP_GE_1= RULE_OP_GE
                    {
                    this_OP_GE_1=(Token)match(input,RULE_OP_GE,FOLLOW_RULE_OP_GE_in_ruleRelationalOp9457); 

                    		current.merge(this_OP_GE_1);
                        
                     
                        newLeafNode(this_OP_GE_1, grammarAccess.getRelationalOpAccess().getOP_GETerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4092:10: this_OP_GT_2= RULE_OP_GT
                    {
                    this_OP_GT_2=(Token)match(input,RULE_OP_GT,FOLLOW_RULE_OP_GT_in_ruleRelationalOp9483); 

                    		current.merge(this_OP_GT_2);
                        
                     
                        newLeafNode(this_OP_GT_2, grammarAccess.getRelationalOpAccess().getOP_GTTerminalRuleCall_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4100:10: this_OP_LE_3= RULE_OP_LE
                    {
                    this_OP_LE_3=(Token)match(input,RULE_OP_LE,FOLLOW_RULE_OP_LE_in_ruleRelationalOp9509); 

                    		current.merge(this_OP_LE_3);
                        
                     
                        newLeafNode(this_OP_LE_3, grammarAccess.getRelationalOpAccess().getOP_LETerminalRuleCall_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4108:10: this_OP_LT_4= RULE_OP_LT
                    {
                    this_OP_LT_4=(Token)match(input,RULE_OP_LT,FOLLOW_RULE_OP_LT_in_ruleRelationalOp9535); 

                    		current.merge(this_OP_LT_4);
                        
                     
                        newLeafNode(this_OP_LT_4, grammarAccess.getRelationalOpAccess().getOP_LTTerminalRuleCall_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../edu.csu.melange.alphabets.xtext/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4116:10: this_OP_NE_5= RULE_OP_NE
                    {
                    this_OP_NE_5=(Token)match(input,RULE_OP_NE,FOLLOW_RULE_OP_NE_in_ruleRelationalOp9561); 

                    		current.merge(this_OP_NE_5);
                        
                     
                        newLeafNode(this_OP_NE_5, grammarAccess.getRelationalOpAccess().getOP_NETerminalRuleCall_5()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationalOp"

    // Delegated rules


    protected DFA20 dfa20 = new DFA20(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA31 dfa31 = new DFA31(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA66 dfa66 = new DFA66(this);
    static final String DFA20_eotS =
        "\6\uffff";
    static final String DFA20_eofS =
        "\6\uffff";
    static final String DFA20_minS =
        "\3\4\1\7\2\uffff";
    static final String DFA20_maxS =
        "\1\40\1\11\2\41\2\uffff";
    static final String DFA20_acceptS =
        "\4\uffff\1\1\1\2";
    static final String DFA20_specialS =
        "\6\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\3\3\uffff\1\1\1\2\26\uffff\1\4",
            "\1\3\4\uffff\1\2",
            "\1\3\2\uffff\2\5\1\2\12\uffff\6\4\7\uffff\1\4",
            "\2\5\13\uffff\6\4\7\uffff\1\4",
            "",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "916:2: (this_IDList_0= ruleIDList | this_IDExpression_1= ruleIDExpression )";
        }
    }
    static final String DFA21_eotS =
        "\6\uffff";
    static final String DFA21_eofS =
        "\2\uffff\2\4\2\uffff";
    static final String DFA21_minS =
        "\3\4\1\6\2\uffff";
    static final String DFA21_maxS =
        "\1\40\1\11\2\54\2\uffff";
    static final String DFA21_acceptS =
        "\4\uffff\1\1\1\2";
    static final String DFA21_specialS =
        "\6\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\3\3\uffff\1\1\1\2\26\uffff\1\4",
            "\1\3\4\uffff\1\2",
            "\1\3\1\uffff\1\4\2\5\1\2\12\uffff\6\4\7\uffff\1\4\12\uffff"+
            "\1\4",
            "\1\4\2\5\13\uffff\6\4\7\uffff\1\4\12\uffff\1\4",
            "",
            ""
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "950:1: (this_IDList_3= ruleIDList | this_IDExpression_4= ruleIDExpression )";
        }
    }
    static final String DFA31_eotS =
        "\4\uffff";
    static final String DFA31_eofS =
        "\1\uffff\1\3\2\uffff";
    static final String DFA31_minS =
        "\2\4\2\uffff";
    static final String DFA31_maxS =
        "\1\11\1\54\2\uffff";
    static final String DFA31_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA31_specialS =
        "\4\uffff}>";
    static final String[] DFA31_transitionS = {
            "\1\2\4\uffff\1\1",
            "\1\2\1\uffff\3\3\1\1\12\uffff\6\3\7\uffff\2\3\11\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA31_eot = DFA.unpackEncodedString(DFA31_eotS);
    static final short[] DFA31_eof = DFA.unpackEncodedString(DFA31_eofS);
    static final char[] DFA31_min = DFA.unpackEncodedStringToUnsignedChars(DFA31_minS);
    static final char[] DFA31_max = DFA.unpackEncodedStringToUnsignedChars(DFA31_maxS);
    static final short[] DFA31_accept = DFA.unpackEncodedString(DFA31_acceptS);
    static final short[] DFA31_special = DFA.unpackEncodedString(DFA31_specialS);
    static final short[][] DFA31_transition;

    static {
        int numStates = DFA31_transitionS.length;
        DFA31_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA31_transition[i] = DFA.unpackEncodedString(DFA31_transitionS[i]);
        }
    }

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = DFA31_eot;
            this.eof = DFA31_eof;
            this.min = DFA31_min;
            this.max = DFA31_max;
            this.accept = DFA31_accept;
            this.special = DFA31_special;
            this.transition = DFA31_transition;
        }
        public String getDescription() {
            return "1149:3: ( (this_INT_1= RULE_INT )+ | ( (this_INT_2= RULE_INT )* this_ID_3= RULE_ID ) )";
        }
    }
    static final String DFA34_eotS =
        "\15\uffff";
    static final String DFA34_eofS =
        "\5\uffff\1\14\7\uffff";
    static final String DFA34_minS =
        "\2\4\3\uffff\1\7\2\uffff\1\7\4\uffff";
    static final String DFA34_maxS =
        "\2\71\3\uffff\1\66\2\uffff\1\70\4\uffff";
    static final String DFA34_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\uffff\1\5\1\7\1\uffff\1\10\1\1\1\11\1\6";
    static final String DFA34_specialS =
        "\15\uffff}>";
    static final String[] DFA34_transitionS = {
            "\1\5\2\uffff\1\4\1\uffff\1\6\3\4\1\uffff\1\4\1\uffff\2\4\2\6"+
            "\14\uffff\1\1\14\uffff\1\7\3\uffff\1\2\5\uffff\1\7\1\uffff\1"+
            "\3",
            "\1\10\2\uffff\6\12\1\uffff\1\12\1\uffff\4\12\14\uffff\1\12"+
            "\11\uffff\1\12\2\uffff\1\12\2\uffff\2\12\2\uffff\1\12\2\uffff"+
            "\1\12\1\11\1\12",
            "",
            "",
            "",
            "\2\14\1\uffff\10\14\2\uffff\6\14\6\uffff\1\4\3\14\11\uffff"+
            "\1\13\7\uffff\2\14",
            "",
            "",
            "\2\12\1\uffff\10\12\2\uffff\6\12\6\uffff\1\12\1\11\1\12\12"+
            "\uffff\1\12\12\uffff\1\11",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA34_eot = DFA.unpackEncodedString(DFA34_eotS);
    static final short[] DFA34_eof = DFA.unpackEncodedString(DFA34_eofS);
    static final char[] DFA34_min = DFA.unpackEncodedStringToUnsignedChars(DFA34_minS);
    static final char[] DFA34_max = DFA.unpackEncodedStringToUnsignedChars(DFA34_maxS);
    static final short[] DFA34_accept = DFA.unpackEncodedString(DFA34_acceptS);
    static final short[] DFA34_special = DFA.unpackEncodedString(DFA34_specialS);
    static final short[][] DFA34_transition;

    static {
        int numStates = DFA34_transitionS.length;
        DFA34_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA34_transition[i] = DFA.unpackEncodedString(DFA34_transitionS[i]);
        }
    }

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = DFA34_eot;
            this.eof = DFA34_eof;
            this.min = DFA34_min;
            this.max = DFA34_max;
            this.accept = DFA34_accept;
            this.special = DFA34_special;
            this.transition = DFA34_transition;
        }
        public String getDescription() {
            return "1333:1: (this_AParanthesizedAlphabetsExpression_0= ruleAParanthesizedAlphabetsExpression | this_ACaseExpression_1= ruleACaseExpression | this_AReduceExpression_2= ruleAReduceExpression | this_AMultiArgExpression_3= ruleAMultiArgExpression | this_AConstantExpression_4= ruleAConstantExpression | this_AVariableExpression_5= ruleAVariableExpression | this_AIndexExpression_6= ruleAIndexExpression | this_ADependenceExpression_7= ruleADependenceExpression | this_ADependenceInArrayNotation_8= ruleADependenceInArrayNotation )";
        }
    }
    static final String DFA66_eotS =
        "\10\uffff";
    static final String DFA66_eofS =
        "\10\uffff";
    static final String DFA66_minS =
        "\1\40\1\4\1\41\2\4\2\uffff\1\41";
    static final String DFA66_maxS =
        "\1\40\2\70\1\42\1\4\2\uffff\1\70";
    static final String DFA66_acceptS =
        "\5\uffff\1\1\1\2\1\uffff";
    static final String DFA66_specialS =
        "\10\uffff}>";
    static final String[] DFA66_transitionS = {
            "\1\1",
            "\1\2\63\uffff\1\3",
            "\1\4\26\uffff\1\3",
            "\1\6\3\uffff\2\6\30\uffff\1\5",
            "\1\7",
            "",
            "",
            "\1\4\26\uffff\1\3"
    };

    static final short[] DFA66_eot = DFA.unpackEncodedString(DFA66_eotS);
    static final short[] DFA66_eof = DFA.unpackEncodedString(DFA66_eofS);
    static final char[] DFA66_min = DFA.unpackEncodedStringToUnsignedChars(DFA66_minS);
    static final char[] DFA66_max = DFA.unpackEncodedStringToUnsignedChars(DFA66_maxS);
    static final short[] DFA66_accept = DFA.unpackEncodedString(DFA66_acceptS);
    static final short[] DFA66_special = DFA.unpackEncodedString(DFA66_specialS);
    static final short[][] DFA66_transition;

    static {
        int numStates = DFA66_transitionS.length;
        DFA66_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA66_transition[i] = DFA.unpackEncodedString(DFA66_transitionS[i]);
        }
    }

    class DFA66 extends DFA {

        public DFA66(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 66;
            this.eot = DFA66_eot;
            this.eof = DFA66_eof;
            this.min = DFA66_min;
            this.max = DFA66_max;
            this.accept = DFA66_accept;
            this.special = DFA66_special;
            this.transition = DFA66_transition;
        }
        public String getDescription() {
            return "3519:1: ( (otherlv_0= '(' ( (lv_indexes_1_0= ruleAIndexList ) ) otherlv_2= '->' otherlv_3= ')' ) | (otherlv_4= '(' ( (lv_indexes_5_0= ruleAIndexList ) ) otherlv_6= '->' ( (lv_func_7_0= ruleAIndexAffineExpressionList ) ) otherlv_8= ')' ) )";
        }
    }
 

    public static final BitSet FOLLOW_ruleAProgram_in_entryRuleAProgram75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAProgram85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAExternalFunctionDeclaration_in_ruleAProgram131 = new BitSet(new long[]{0xF800001000000000L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleAAffineSystem_in_ruleAProgram153 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_ruleAExternalFunctionDeclaration_in_entryRuleAExternalFunctionDeclaration190 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAExternalFunctionDeclaration200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAType_in_ruleAExternalFunctionDeclaration246 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAExternalFunctionIdentifier_in_ruleAExternalFunctionDeclaration267 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleAExternalFunctionDeclaration279 = new BitSet(new long[]{0xF800001600000000L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleAType_in_ruleAExternalFunctionDeclaration300 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_33_in_ruleAExternalFunctionDeclaration314 = new BitSet(new long[]{0xF800001000000000L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleAType_in_ruleAExternalFunctionDeclaration335 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_34_in_ruleAExternalFunctionDeclaration349 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleAExternalFunctionDeclaration361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAExternalFunctionIdentifier_in_entryRuleAExternalFunctionIdentifier397 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAExternalFunctionIdentifier407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAExternalFunctionIdentifier448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAffineSystem_in_entryRuleAAffineSystem488 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAAffineSystem498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleAAffineSystem535 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAAffineSystem552 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleADomain_in_ruleAAffineSystem578 = new BitSet(new long[]{0x000003E000000000L});
    public static final BitSet FOLLOW_37_in_ruleAAffineSystem591 = new BitSet(new long[]{0xF80003D000000000L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleAInputDeclaration_in_ruleAAffineSystem612 = new BitSet(new long[]{0xF80003D000000000L,0x000000000000000FL});
    public static final BitSet FOLLOW_38_in_ruleAAffineSystem628 = new BitSet(new long[]{0xF800039000000000L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleAOutputDeclaration_in_ruleAAffineSystem649 = new BitSet(new long[]{0xF800039000000000L,0x000000000000000FL});
    public static final BitSet FOLLOW_39_in_ruleAAffineSystem665 = new BitSet(new long[]{0xF800031000000000L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleALocalDeclaration_in_ruleAAffineSystem686 = new BitSet(new long[]{0xF800031000000000L,0x000000000000000FL});
    public static final BitSet FOLLOW_40_in_ruleAAffineSystem702 = new BitSet(new long[]{0x0000020000000010L});
    public static final BitSet FOLLOW_ruleAStandardEquation_in_ruleAAffineSystem723 = new BitSet(new long[]{0x0000020000000010L});
    public static final BitSet FOLLOW_41_in_ruleAAffineSystem738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAOutputDeclaration_in_entryRuleAOutputDeclaration774 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAOutputDeclaration784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAType_in_ruleAOutputDeclaration830 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAIdentifierList_in_ruleAOutputDeclaration851 = new BitSet(new long[]{0x0000040800000000L});
    public static final BitSet FOLLOW_ruleADomain_in_ruleAOutputDeclaration872 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleAOutputDeclaration885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAInputDeclaration_in_entryRuleAInputDeclaration921 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAInputDeclaration931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAType_in_ruleAInputDeclaration977 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAIdentifierList_in_ruleAInputDeclaration998 = new BitSet(new long[]{0x0000040800000000L});
    public static final BitSet FOLLOW_ruleADomain_in_ruleAInputDeclaration1019 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleAInputDeclaration1032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleALocalDeclaration_in_entryRuleALocalDeclaration1068 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleALocalDeclaration1078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAType_in_ruleALocalDeclaration1124 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAIdentifierList_in_ruleALocalDeclaration1145 = new BitSet(new long[]{0x0000040800000000L});
    public static final BitSet FOLLOW_ruleADomain_in_ruleALocalDeclaration1166 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleALocalDeclaration1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIdentifierList_in_entryRuleAIdentifierList1215 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAIdentifierList1225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableIdentifier_in_ruleAIdentifierList1271 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleAIdentifierList1284 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVariableIdentifier_in_ruleAIdentifierList1305 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ruleVariableIdentifier_in_entryRuleVariableIdentifier1344 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableIdentifier1355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableIdentifier1394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleADomain_in_entryRuleADomain1438 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleADomain1448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAPolyhedron_in_ruleADomain1494 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_UNION_in_ruleADomain1506 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleAPolyhedron_in_ruleADomain1526 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleAPolyhedron_in_entryRuleAPolyhedron1564 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAPolyhedron1574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleAPolyhedron1611 = new BitSet(new long[]{0x0000080000000010L});
    public static final BitSet FOLLOW_ruleAIndexList_in_ruleAPolyhedron1632 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleAPolyhedron1644 = new BitSet(new long[]{0x0000100100000310L});
    public static final BitSet FOLLOW_ruleInEquality_in_ruleAPolyhedron1666 = new BitSet(new long[]{0x0000100000000040L});
    public static final BitSet FOLLOW_RULE_INTERSECTION_in_ruleAPolyhedron1678 = new BitSet(new long[]{0x0000000100000310L});
    public static final BitSet FOLLOW_ruleInEquality_in_ruleAPolyhedron1698 = new BitSet(new long[]{0x0000100000000040L});
    public static final BitSet FOLLOW_44_in_ruleAPolyhedron1714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInEquality_in_entryRuleInEquality1751 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInEquality1762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDList_in_ruleInEquality1810 = new BitSet(new long[]{0x0000000003F00000L});
    public static final BitSet FOLLOW_ruleIDExpression_in_ruleInEquality1843 = new BitSet(new long[]{0x0000000003F00000L});
    public static final BitSet FOLLOW_ruleRelationalOp_in_ruleInEquality1872 = new BitSet(new long[]{0x0000000100000310L});
    public static final BitSet FOLLOW_ruleIDList_in_ruleInEquality1900 = new BitSet(new long[]{0x0000000003F00002L});
    public static final BitSet FOLLOW_ruleIDExpression_in_ruleInEquality1933 = new BitSet(new long[]{0x0000000003F00002L});
    public static final BitSet FOLLOW_ruleIDList_in_entryRuleIDList1982 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIDList1993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInEqID_in_ruleIDList2041 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleIDList2060 = new BitSet(new long[]{0x0000000000000310L});
    public static final BitSet FOLLOW_ruleInEqID_in_ruleIDList2082 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_32_in_ruleIDList2110 = new BitSet(new long[]{0x0000000000000310L});
    public static final BitSet FOLLOW_ruleInEqID_in_ruleIDList2132 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_33_in_ruleIDList2151 = new BitSet(new long[]{0x0000000000000310L});
    public static final BitSet FOLLOW_ruleInEqID_in_ruleIDList2173 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_34_in_ruleIDList2193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDExpression_in_entryRuleIDExpression2235 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIDExpression2246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInEqID_in_ruleIDExpression2293 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_RULE_OP_PLUS_in_ruleIDExpression2315 = new BitSet(new long[]{0x0000000000000310L});
    public static final BitSet FOLLOW_RULE_OP_MINUS_in_ruleIDExpression2341 = new BitSet(new long[]{0x0000000000000310L});
    public static final BitSet FOLLOW_ruleInEqID_in_ruleIDExpression2369 = new BitSet(new long[]{0x0000000000000182L});
    public static final BitSet FOLLOW_ruleInEqID_in_entryRuleInEqID2417 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInEqID2428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OP_MINUS_in_ruleInEqID2469 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleInEqID2493 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleInEqID2523 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInEqID2545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAStandardEquation_in_entryRuleAStandardEquation2592 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAStandardEquation2602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAStandardEquation2644 = new BitSet(new long[]{0x0000A00000000000L});
    public static final BitSet FOLLOW_45_in_ruleAStandardEquation2662 = new BitSet(new long[]{0x0000400000000010L});
    public static final BitSet FOLLOW_ruleAIndexList_in_ruleAStandardEquation2683 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleAStandardEquation2695 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleAStandardEquation2709 = new BitSet(new long[]{0x02932401000F5F90L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleAStandardEquation2730 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleAStandardEquation2742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_entryRuleAAlphabetsExpression2778 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAAlphabetsExpression2788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIfExpression_in_ruleAAlphabetsExpression2835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARestrictExpression_in_ruleAAlphabetsExpression2862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAOrExpression_in_ruleAAlphabetsExpression2889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAlphabetsTerminalExpression_in_entryRuleAAlphabetsTerminalExpression2924 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAAlphabetsTerminalExpression2934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAParanthesizedAlphabetsExpression_in_ruleAAlphabetsTerminalExpression2981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleACaseExpression_in_ruleAAlphabetsTerminalExpression3008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAReduceExpression_in_ruleAAlphabetsTerminalExpression3035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAMultiArgExpression_in_ruleAAlphabetsTerminalExpression3062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAConstantExpression_in_ruleAAlphabetsTerminalExpression3089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAVariableExpression_in_ruleAAlphabetsTerminalExpression3116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIndexExpression_in_ruleAAlphabetsTerminalExpression3143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleADependenceExpression_in_ruleAAlphabetsTerminalExpression3170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleADependenceInArrayNotation_in_ruleAAlphabetsTerminalExpression3197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAParanthesizedAlphabetsExpression_in_entryRuleAParanthesizedAlphabetsExpression3232 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAParanthesizedAlphabetsExpression3242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleAParanthesizedAlphabetsExpression3279 = new BitSet(new long[]{0x02932401000F5F90L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleAParanthesizedAlphabetsExpression3301 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleAParanthesizedAlphabetsExpression3312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAOrExpression_in_entryRuleAOrExpression3348 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAOrExpression3358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAndExpression_in_ruleAOrExpression3405 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_RULE_OP_OR_in_ruleAOrExpression3433 = new BitSet(new long[]{0x02932401000F5F90L});
    public static final BitSet FOLLOW_RULE_XOP_OR_in_ruleAOrExpression3453 = new BitSet(new long[]{0x02932401000F5F90L});
    public static final BitSet FOLLOW_ruleAAndExpression_in_ruleAOrExpression3482 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_ruleAAndExpression_in_entryRuleAAndExpression3520 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAAndExpression3530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARelationalExpression_in_ruleAAndExpression3577 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_RULE_OP_AND_in_ruleAAndExpression3605 = new BitSet(new long[]{0x02932401000F5F90L});
    public static final BitSet FOLLOW_RULE_OP_NAND_in_ruleAAndExpression3625 = new BitSet(new long[]{0x02932401000F5F90L});
    public static final BitSet FOLLOW_ruleARelationalExpression_in_ruleAAndExpression3654 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_ruleARelationalExpression_in_entryRuleARelationalExpression3692 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleARelationalExpression3702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAdditiveExpression_in_ruleARelationalExpression3749 = new BitSet(new long[]{0x0000000003F00002L});
    public static final BitSet FOLLOW_ruleRelationalOp_in_ruleARelationalExpression3779 = new BitSet(new long[]{0x02932401000F5F90L});
    public static final BitSet FOLLOW_ruleAAdditiveExpression_in_ruleARelationalExpression3800 = new BitSet(new long[]{0x0000000003F00002L});
    public static final BitSet FOLLOW_ruleAAdditiveExpression_in_entryRuleAAdditiveExpression3838 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAAdditiveExpression3848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAMultiplicativeExpression_in_ruleAAdditiveExpression3895 = new BitSet(new long[]{0x0000000000000182L});
    public static final BitSet FOLLOW_RULE_OP_PLUS_in_ruleAAdditiveExpression3923 = new BitSet(new long[]{0x02932401000F5F90L});
    public static final BitSet FOLLOW_RULE_OP_MINUS_in_ruleAAdditiveExpression3943 = new BitSet(new long[]{0x02932401000F5F90L});
    public static final BitSet FOLLOW_ruleAMultiplicativeExpression_in_ruleAAdditiveExpression3972 = new BitSet(new long[]{0x0000000000000182L});
    public static final BitSet FOLLOW_ruleAMultiplicativeExpression_in_entryRuleAMultiplicativeExpression4010 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAMultiplicativeExpression4020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAMinMaxExpression_in_ruleAMultiplicativeExpression4067 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_RULE_OP_MUL_in_ruleAMultiplicativeExpression4095 = new BitSet(new long[]{0x02932401000F5F90L});
    public static final BitSet FOLLOW_RULE_OP_DIV_in_ruleAMultiplicativeExpression4115 = new BitSet(new long[]{0x02932401000F5F90L});
    public static final BitSet FOLLOW_ruleAMinMaxExpression_in_ruleAMultiplicativeExpression4144 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_ruleAMinMaxExpression_in_entryRuleAMinMaxExpression4182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAMinMaxExpression4192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAUnaryOrTerminalExpression_in_ruleAMinMaxExpression4239 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_RULE_OP_MIN_in_ruleAMinMaxExpression4267 = new BitSet(new long[]{0x02932401000F5F90L});
    public static final BitSet FOLLOW_RULE_OP_MAX_in_ruleAMinMaxExpression4287 = new BitSet(new long[]{0x02932401000F5F90L});
    public static final BitSet FOLLOW_ruleAUnaryOrTerminalExpression_in_ruleAMinMaxExpression4316 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_ruleAUnaryOrTerminalExpression_in_entryRuleAUnaryOrTerminalExpression4354 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAUnaryOrTerminalExpression4364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAUnaryExpression_in_ruleAUnaryOrTerminalExpression4411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAlphabetsTerminalExpression_in_ruleAUnaryOrTerminalExpression4438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAUnaryExpression_in_entryRuleAUnaryExpression4473 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAUnaryExpression4483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleANotExpression_in_ruleAUnaryExpression4530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleANegateExpression_in_ruleAUnaryExpression4557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleANotExpression_in_entryRuleANotExpression4592 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleANotExpression4602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleANotExpression4645 = new BitSet(new long[]{0x02932401000F5F90L});
    public static final BitSet FOLLOW_ruleAAlphabetsTerminalExpression_in_ruleANotExpression4679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleANegateExpression_in_entryRuleANegateExpression4715 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleANegateExpression4725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OP_MINUS_in_ruleANegateExpression4767 = new BitSet(new long[]{0x02932401000F5F90L});
    public static final BitSet FOLLOW_ruleAAlphabetsTerminalExpression_in_ruleANegateExpression4793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleACaseExpression_in_entryRuleACaseExpression4829 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleACaseExpression4839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleACaseExpression4876 = new BitSet(new long[]{0x02932401000F5F90L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleACaseExpression4898 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleACaseExpression4910 = new BitSet(new long[]{0x02972401000F5F90L});
    public static final BitSet FOLLOW_50_in_ruleACaseExpression4924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleADependenceExpression_in_entryRuleADependenceExpression4960 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleADependenceExpression4970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAFunction_in_ruleADependenceExpression5016 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleADependenceExpression5028 = new BitSet(new long[]{0x02932401000F5F90L});
    public static final BitSet FOLLOW_ruleAAlphabetsTerminalExpression_in_ruleADependenceExpression5049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleADependenceInArrayNotation_in_entryRuleADependenceInArrayNotation5085 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleADependenceInArrayNotation5095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableIdentifier_in_ruleADependenceInArrayNotation5141 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleADependenceInArrayNotation5153 = new BitSet(new long[]{0x0000400000000310L});
    public static final BitSet FOLLOW_ruleAIndexAffineExpressionList_in_ruleADependenceInArrayNotation5174 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleADependenceInArrayNotation5186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIfExpression_in_entryRuleAIfExpression5222 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAIfExpression5232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleAIfExpression5269 = new BitSet(new long[]{0x02932401000F5F90L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleAIfExpression5290 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleAIfExpression5302 = new BitSet(new long[]{0x02932401000F5F90L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleAIfExpression5323 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ruleAIfExpression5335 = new BitSet(new long[]{0x02932401000F5F90L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleAIfExpression5356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIndexExpression_in_entryRuleAIndexExpression5392 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAIndexExpression5402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleAIndexExpression5440 = new BitSet(new long[]{0x0000000000000310L});
    public static final BitSet FOLLOW_ruleIndexAffineExpression_in_ruleAIndexExpression5461 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleAIndexExpression5473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleAIndexExpression5493 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleAIndexList_in_ruleAIndexExpression5514 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleAIndexExpression5526 = new BitSet(new long[]{0x0000000000000310L});
    public static final BitSet FOLLOW_ruleIndexAffineExpression_in_ruleAIndexExpression5547 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleAIndexExpression5559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAReduceExpression_in_entryRuleAReduceExpression5596 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAReduceExpression5606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleAReduceExpression5643 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleAReduceExpression5655 = new BitSet(new long[]{0x0000000000035C80L});
    public static final BitSet FOLLOW_ruleReductionOp_in_ruleAReduceExpression5676 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleAReduceExpression5688 = new BitSet(new long[]{0x0000200100000000L});
    public static final BitSet FOLLOW_ruleAFunction_in_ruleAReduceExpression5711 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_ruleAFunctionInArrayNotation_in_ruleAReduceExpression5730 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleAReduceExpression5745 = new BitSet(new long[]{0x02932401000F5F90L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleAReduceExpression5766 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleAReduceExpression5778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARestrictExpression_in_entryRuleARestrictExpression5814 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleARestrictExpression5824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleADomain_in_ruleARestrictExpression5870 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_ruleARestrictExpression5882 = new BitSet(new long[]{0x02932401000F5F90L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleARestrictExpression5903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAVariableExpression_in_entryRuleAVariableExpression5939 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAVariableExpression5949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableIdentifier_in_ruleAVariableExpression5994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAConstantExpression_in_entryRuleAConstantExpression6029 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAConstantExpression6039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleABooleanExpression_in_ruleAConstantExpression6086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARealExpression_in_ruleAConstantExpression6113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIntegerExpression_in_ruleAConstantExpression6140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleABooleanExpression_in_entryRuleABooleanExpression6175 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleABooleanExpression6185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOLEAN_in_ruleABooleanExpression6226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIntegerExpression_in_entryRuleAIntegerExpression6266 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAIntegerExpression6276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAIntegerExpression6317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARealExpression_in_entryRuleARealExpression6357 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleARealExpression6367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REAL_in_ruleARealExpression6408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAMultiArgExpression_in_entryRuleAMultiArgExpression6448 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAMultiArgExpression6458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAMultiArgArithmeticExpression_in_ruleAMultiArgExpression6505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAMultiArgLogicalExpression_in_ruleAMultiArgExpression6532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAExternalFunctionCall_in_ruleAMultiArgExpression6559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAMultiArgArithmeticExpression_in_entryRuleAMultiArgArithmeticExpression6594 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAMultiArgArithmeticExpression6604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArithmeticOp_in_ruleAMultiArgArithmeticExpression6650 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleAMultiArgArithmeticExpression6662 = new BitSet(new long[]{0x02932401000F5F90L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleAMultiArgArithmeticExpression6683 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleAMultiArgArithmeticExpression6696 = new BitSet(new long[]{0x02932401000F5F90L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleAMultiArgArithmeticExpression6717 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_34_in_ruleAMultiArgArithmeticExpression6731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAMultiArgLogicalExpression_in_entryRuleAMultiArgLogicalExpression6767 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAMultiArgLogicalExpression6777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOp_in_ruleAMultiArgLogicalExpression6823 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleAMultiArgLogicalExpression6835 = new BitSet(new long[]{0x02932401000F5F90L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleAMultiArgLogicalExpression6856 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleAMultiArgLogicalExpression6869 = new BitSet(new long[]{0x02932401000F5F90L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleAMultiArgLogicalExpression6890 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_34_in_ruleAMultiArgLogicalExpression6904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAExternalFunctionCall_in_entryRuleAExternalFunctionCall6940 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAExternalFunctionCall6950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAExternalFunctionCall6992 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleAExternalFunctionCall7009 = new BitSet(new long[]{0x02932405000F5F90L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleAExternalFunctionCall7031 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_33_in_ruleAExternalFunctionCall7044 = new BitSet(new long[]{0x02932401000F5F90L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleAExternalFunctionCall7065 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_34_in_ruleAExternalFunctionCall7081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIndexIdentifier_in_entryRuleIndexIdentifier7118 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIndexIdentifier7129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIndexIdentifier7168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIndexList_in_entryRuleAIndexList7212 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAIndexList7222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIndexIdentifier_in_ruleAIndexList7278 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleAIndexList7291 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleIndexIdentifier_in_ruleAIndexList7312 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ruleIndexAffineExpression_in_entryRuleIndexAffineExpression7353 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIndexAffineExpression7364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OP_MINUS_in_ruleIndexAffineExpression7405 = new BitSet(new long[]{0x0000000000000310L});
    public static final BitSet FOLLOW_ruleIndexAffineExpressionTerminal_in_ruleIndexAffineExpression7434 = new BitSet(new long[]{0x0000000000000182L});
    public static final BitSet FOLLOW_RULE_OP_PLUS_in_ruleIndexAffineExpression7456 = new BitSet(new long[]{0x0000000000000310L});
    public static final BitSet FOLLOW_RULE_OP_MINUS_in_ruleIndexAffineExpression7482 = new BitSet(new long[]{0x0000000000000310L});
    public static final BitSet FOLLOW_ruleIndexAffineExpression_in_ruleIndexAffineExpression7510 = new BitSet(new long[]{0x0000000000000182L});
    public static final BitSet FOLLOW_ruleIndexAffineExpressionTerminal_in_entryRuleIndexAffineExpressionTerminal7558 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIndexAffineExpressionTerminal7569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIndexAffineExpressionTerminal7609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIndexAffineExpressionTerminal7637 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleIndexIdentifier_in_ruleIndexAffineExpressionTerminal7666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIndexAffineExpressionList_in_entryRuleAIndexAffineExpressionList7712 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAIndexAffineExpressionList7722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIndexAffineExpression_in_ruleAIndexAffineExpressionList7778 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleAIndexAffineExpressionList7791 = new BitSet(new long[]{0x0000000000000310L});
    public static final BitSet FOLLOW_ruleIndexAffineExpression_in_ruleAIndexAffineExpressionList7812 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ruleAFunction_in_entryRuleAFunction7852 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAFunction7862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleAFunction7900 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleAIndexList_in_ruleAFunction7921 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleAFunction7933 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleAFunction7945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleAFunction7965 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleAIndexList_in_ruleAFunction7986 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleAFunction7998 = new BitSet(new long[]{0x0000000400000310L});
    public static final BitSet FOLLOW_ruleAIndexAffineExpressionList_in_ruleAFunction8019 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleAFunction8031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAFunctionInArrayNotation_in_entryRuleAFunctionInArrayNotation8068 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAFunctionInArrayNotation8078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleAFunctionInArrayNotation8115 = new BitSet(new long[]{0x0000400000000310L});
    public static final BitSet FOLLOW_ruleAIndexAffineExpressionList_in_ruleAFunctionInArrayNotation8136 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleAFunctionInArrayNotation8148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAType_in_entryRuleAType8184 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAType8194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleAType8237 = new BitSet(new long[]{0xF800001000000000L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleATypeInteger_in_ruleAType8274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleATypeFloat_in_ruleAType8293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleATypeBoolean_in_ruleAType8312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleATypeChar_in_ruleAType8331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleATypeInteger_in_entryRuleATypeInteger8371 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleATypeInteger8382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleATypeInteger8420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleATypeInteger8439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleATypeInteger8458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleATypeInteger8477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleATypeBoolean_in_entryRuleATypeBoolean8518 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleATypeBoolean8529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleATypeBoolean8566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleATypeFloat_in_entryRuleATypeFloat8606 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleATypeFloat8617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleATypeFloat8655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleATypeFloat8674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleATypeChar_in_entryRuleATypeChar8715 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleATypeChar8726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleATypeChar8763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReductionOp_in_entryRuleReductionOp8803 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReductionOp8814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OP_AND_in_ruleReductionOp8854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OP_MAX_in_ruleReductionOp8880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OP_MIN_in_ruleReductionOp8906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OP_MUL_in_ruleReductionOp8932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OP_OR_in_ruleReductionOp8958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OP_PLUS_in_ruleReductionOp8984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_XOP_OR_in_ruleReductionOp9010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArithmeticOp_in_entryRuleArithmeticOp9056 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArithmeticOp9067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OP_MAX_in_ruleArithmeticOp9107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OP_MIN_in_ruleArithmeticOp9133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OP_MUL_in_ruleArithmeticOp9159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OP_PLUS_in_ruleArithmeticOp9185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOp_in_entryRuleLogicalOp9231 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOp9242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OP_AND_in_ruleLogicalOp9282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OP_OR_in_ruleLogicalOp9308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_XOP_OR_in_ruleLogicalOp9334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOp_in_entryRuleRelationalOp9380 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalOp9391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OP_EQ_in_ruleRelationalOp9431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OP_GE_in_ruleRelationalOp9457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OP_GT_in_ruleRelationalOp9483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OP_LE_in_ruleRelationalOp9509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OP_LT_in_ruleRelationalOp9535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OP_NE_in_ruleRelationalOp9561 = new BitSet(new long[]{0x0000000000000002L});

}