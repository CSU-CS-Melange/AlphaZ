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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_UNION", "RULE_INTERSECTION", "RULE_PLUSOP", "RULE_MINUSOP", "RULE_INT", "RULE_OROP", "RULE_XOROP", "RULE_ANDOP", "RULE_NANDOP", "RULE_MODOP", "RULE_MULOP", "RULE_DIVOP", "RULE_MINOP", "RULE_MAXOP", "RULE_BOOLEAN", "RULE_REAL", "RULE_EQOP", "RULE_GEOP", "RULE_GTOP", "RULE_LEOP", "RULE_LTOP", "RULE_NEOP", "RULE_SL_COMMENT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "','", "')'", "';'", "'affine'", "'input'", "'output'", "'local'", "'over'", "'let'", "'.'", "'given'", "'returns'", "'using'", "'through'", "'while'", "'{'", "'|'", "'}'", "'['", "']'", "'='", "'use'", "'not'", "'case'", "'esac'", "'@'", "'if'", "'then'", "'else'", "'val('", "'->'", "'reduce'", "':'", "'unsigned'", "'int'", "'longlong'", "'long'", "'short'", "'bool'", "'float'", "'double'", "'char'"
    };
    public static final int RULE_GEOP=22;
    public static final int T__50=50;
    public static final int RULE_MINUSOP=8;
    public static final int RULE_NANDOP=13;
    public static final int RULE_BOOLEAN=19;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int RULE_XOROP=11;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int RULE_NEOP=26;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_MULOP=15;
    public static final int RULE_REAL=20;
    public static final int RULE_DIVOP=16;
    public static final int RULE_ANDOP=12;
    public static final int RULE_MINOP=17;
    public static final int RULE_INT=9;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=29;
    public static final int T__67=67;
    public static final int RULE_UNION=5;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int RULE_MAXOP=18;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int RULE_OROP=10;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=28;
    public static final int RULE_SL_COMMENT=27;
    public static final int RULE_EQOP=21;
    public static final int RULE_GTOP=23;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int RULE_LEOP=24;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__32=32;
    public static final int RULE_MODOP=14;
    public static final int RULE_WS=30;
    public static final int RULE_LTOP=25;
    public static final int RULE_ANY_OTHER=31;
    public static final int RULE_PLUSOP=7;
    public static final int RULE_INTERSECTION=6;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalAlphabetsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalAlphabetsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalAlphabetsParser.tokenNames; }
    public String getGrammarFileName() { return "../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g"; }



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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:67:1: entryRuleAProgram returns [EObject current=null] : iv_ruleAProgram= ruleAProgram EOF ;
    public final EObject entryRuleAProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAProgram = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:68:2: (iv_ruleAProgram= ruleAProgram EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:69:2: iv_ruleAProgram= ruleAProgram EOF
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:76:1: ruleAProgram returns [EObject current=null] : ( ( (lv_externalFunctions_0_0= ruleAExternalFunctionDeclaration ) )* ( (lv_systems_1_0= ruleAAffineSystem ) )+ ) ;
    public final EObject ruleAProgram() throws RecognitionException {
        EObject current = null;

        EObject lv_externalFunctions_0_0 = null;

        EObject lv_systems_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:79:28: ( ( ( (lv_externalFunctions_0_0= ruleAExternalFunctionDeclaration ) )* ( (lv_systems_1_0= ruleAAffineSystem ) )+ ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:80:1: ( ( (lv_externalFunctions_0_0= ruleAExternalFunctionDeclaration ) )* ( (lv_systems_1_0= ruleAAffineSystem ) )+ )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:80:1: ( ( (lv_externalFunctions_0_0= ruleAExternalFunctionDeclaration ) )* ( (lv_systems_1_0= ruleAAffineSystem ) )+ )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:80:2: ( (lv_externalFunctions_0_0= ruleAExternalFunctionDeclaration ) )* ( (lv_systems_1_0= ruleAAffineSystem ) )+
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:80:2: ( (lv_externalFunctions_0_0= ruleAExternalFunctionDeclaration ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=66 && LA1_0<=74)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:81:1: (lv_externalFunctions_0_0= ruleAExternalFunctionDeclaration )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:81:1: (lv_externalFunctions_0_0= ruleAExternalFunctionDeclaration )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:82:3: lv_externalFunctions_0_0= ruleAExternalFunctionDeclaration
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

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:98:3: ( (lv_systems_1_0= ruleAAffineSystem ) )+
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
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:99:1: (lv_systems_1_0= ruleAAffineSystem )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:99:1: (lv_systems_1_0= ruleAAffineSystem )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:100:3: lv_systems_1_0= ruleAAffineSystem
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:124:1: entryRuleAExternalFunctionDeclaration returns [EObject current=null] : iv_ruleAExternalFunctionDeclaration= ruleAExternalFunctionDeclaration EOF ;
    public final EObject entryRuleAExternalFunctionDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAExternalFunctionDeclaration = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:125:2: (iv_ruleAExternalFunctionDeclaration= ruleAExternalFunctionDeclaration EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:126:2: iv_ruleAExternalFunctionDeclaration= ruleAExternalFunctionDeclaration EOF
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:133:1: ruleAExternalFunctionDeclaration returns [EObject current=null] : ( ( (lv_output_0_0= ruleAType ) ) ( (lv_name_1_0= ruleAExternalFunctionIdentifier ) ) otherlv_2= '(' ( (lv_inputs_3_0= ruleAType ) )? (otherlv_4= ',' ( (lv_inputs_5_0= ruleAType ) ) )* otherlv_6= ')' otherlv_7= ';' ) ;
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
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:136:28: ( ( ( (lv_output_0_0= ruleAType ) ) ( (lv_name_1_0= ruleAExternalFunctionIdentifier ) ) otherlv_2= '(' ( (lv_inputs_3_0= ruleAType ) )? (otherlv_4= ',' ( (lv_inputs_5_0= ruleAType ) ) )* otherlv_6= ')' otherlv_7= ';' ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:137:1: ( ( (lv_output_0_0= ruleAType ) ) ( (lv_name_1_0= ruleAExternalFunctionIdentifier ) ) otherlv_2= '(' ( (lv_inputs_3_0= ruleAType ) )? (otherlv_4= ',' ( (lv_inputs_5_0= ruleAType ) ) )* otherlv_6= ')' otherlv_7= ';' )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:137:1: ( ( (lv_output_0_0= ruleAType ) ) ( (lv_name_1_0= ruleAExternalFunctionIdentifier ) ) otherlv_2= '(' ( (lv_inputs_3_0= ruleAType ) )? (otherlv_4= ',' ( (lv_inputs_5_0= ruleAType ) ) )* otherlv_6= ')' otherlv_7= ';' )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:137:2: ( (lv_output_0_0= ruleAType ) ) ( (lv_name_1_0= ruleAExternalFunctionIdentifier ) ) otherlv_2= '(' ( (lv_inputs_3_0= ruleAType ) )? (otherlv_4= ',' ( (lv_inputs_5_0= ruleAType ) ) )* otherlv_6= ')' otherlv_7= ';'
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:137:2: ( (lv_output_0_0= ruleAType ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:138:1: (lv_output_0_0= ruleAType )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:138:1: (lv_output_0_0= ruleAType )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:139:3: lv_output_0_0= ruleAType
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

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:155:2: ( (lv_name_1_0= ruleAExternalFunctionIdentifier ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:156:1: (lv_name_1_0= ruleAExternalFunctionIdentifier )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:156:1: (lv_name_1_0= ruleAExternalFunctionIdentifier )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:157:3: lv_name_1_0= ruleAExternalFunctionIdentifier
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
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:177:1: ( (lv_inputs_3_0= ruleAType ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=66 && LA3_0<=74)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:178:1: (lv_inputs_3_0= ruleAType )
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:178:1: (lv_inputs_3_0= ruleAType )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:179:3: lv_inputs_3_0= ruleAType
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

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:195:3: (otherlv_4= ',' ( (lv_inputs_5_0= ruleAType ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==33) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:195:5: otherlv_4= ',' ( (lv_inputs_5_0= ruleAType ) )
            	    {
            	    otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleAExternalFunctionDeclaration314); 

            	        	newLeafNode(otherlv_4, grammarAccess.getAExternalFunctionDeclarationAccess().getCommaKeyword_4_0());
            	        
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:199:1: ( (lv_inputs_5_0= ruleAType ) )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:200:1: (lv_inputs_5_0= ruleAType )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:200:1: (lv_inputs_5_0= ruleAType )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:201:3: lv_inputs_5_0= ruleAType
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:233:1: entryRuleAExternalFunctionIdentifier returns [EObject current=null] : iv_ruleAExternalFunctionIdentifier= ruleAExternalFunctionIdentifier EOF ;
    public final EObject entryRuleAExternalFunctionIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAExternalFunctionIdentifier = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:234:2: (iv_ruleAExternalFunctionIdentifier= ruleAExternalFunctionIdentifier EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:235:2: iv_ruleAExternalFunctionIdentifier= ruleAExternalFunctionIdentifier EOF
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:242:1: ruleAExternalFunctionIdentifier returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleAExternalFunctionIdentifier() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:245:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:246:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:246:1: ( (lv_name_0_0= RULE_ID ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:247:1: (lv_name_0_0= RULE_ID )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:247:1: (lv_name_0_0= RULE_ID )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:248:3: lv_name_0_0= RULE_ID
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:272:1: entryRuleAAffineSystem returns [EObject current=null] : iv_ruleAAffineSystem= ruleAAffineSystem EOF ;
    public final EObject entryRuleAAffineSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAAffineSystem = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:273:2: (iv_ruleAAffineSystem= ruleAAffineSystem EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:274:2: iv_ruleAAffineSystem= ruleAAffineSystem EOF
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:281:1: ruleAAffineSystem returns [EObject current=null] : (this_AAffineSystemA_0= ruleAAffineSystemA | this_AAffineSystemB_1= ruleAAffineSystemB ) ;
    public final EObject ruleAAffineSystem() throws RecognitionException {
        EObject current = null;

        EObject this_AAffineSystemA_0 = null;

        EObject this_AAffineSystemB_1 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:284:28: ( (this_AAffineSystemA_0= ruleAAffineSystemA | this_AAffineSystemB_1= ruleAAffineSystemB ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:285:1: (this_AAffineSystemA_0= ruleAAffineSystemA | this_AAffineSystemB_1= ruleAAffineSystemB )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:285:1: (this_AAffineSystemA_0= ruleAAffineSystemA | this_AAffineSystemB_1= ruleAAffineSystemB )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:286:5: this_AAffineSystemA_0= ruleAAffineSystemA
                    {
                     
                            newCompositeNode(grammarAccess.getAAffineSystemAccess().getAAffineSystemAParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAAffineSystemA_in_ruleAAffineSystem545);
                    this_AAffineSystemA_0=ruleAAffineSystemA();

                    state._fsp--;

                     
                            current = this_AAffineSystemA_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:296:5: this_AAffineSystemB_1= ruleAAffineSystemB
                    {
                     
                            newCompositeNode(grammarAccess.getAAffineSystemAccess().getAAffineSystemBParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleAAffineSystemB_in_ruleAAffineSystem572);
                    this_AAffineSystemB_1=ruleAAffineSystemB();

                    state._fsp--;

                     
                            current = this_AAffineSystemB_1; 
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
    // $ANTLR end "ruleAAffineSystem"


    // $ANTLR start "entryRuleAAffineSystemA"
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:312:1: entryRuleAAffineSystemA returns [EObject current=null] : iv_ruleAAffineSystemA= ruleAAffineSystemA EOF ;
    public final EObject entryRuleAAffineSystemA() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAAffineSystemA = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:313:2: (iv_ruleAAffineSystemA= ruleAAffineSystemA EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:314:2: iv_ruleAAffineSystemA= ruleAAffineSystemA EOF
            {
             newCompositeNode(grammarAccess.getAAffineSystemARule()); 
            pushFollow(FOLLOW_ruleAAffineSystemA_in_entryRuleAAffineSystemA607);
            iv_ruleAAffineSystemA=ruleAAffineSystemA();

            state._fsp--;

             current =iv_ruleAAffineSystemA; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAAffineSystemA617); 

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
    // $ANTLR end "entryRuleAAffineSystemA"


    // $ANTLR start "ruleAAffineSystemA"
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:321:1: ruleAAffineSystemA returns [EObject current=null] : (otherlv_0= 'affine' ( (lv_name_1_0= ruleSystemID ) ) ( (lv_parameters_2_0= ruleADomain ) ) ( (otherlv_3= 'input' ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )* )? (otherlv_5= 'output' ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )* )? (otherlv_7= 'local' ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )* )? (otherlv_9= 'over' ( (lv_whileDeclaration_10_0= ruleAWhileDeclaration ) ) )? (otherlv_11= 'let' ( ( (lv_equations_12_0= ruleAEquation ) ) otherlv_13= ';' )* )? ) otherlv_14= '.' ) ;
    public final EObject ruleAAffineSystemA() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_parameters_2_0 = null;

        EObject lv_inputDeclarations_4_0 = null;

        EObject lv_outputDeclarations_6_0 = null;

        EObject lv_localvarDeclarations_8_0 = null;

        EObject lv_whileDeclaration_10_0 = null;

        EObject lv_equations_12_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:324:28: ( (otherlv_0= 'affine' ( (lv_name_1_0= ruleSystemID ) ) ( (lv_parameters_2_0= ruleADomain ) ) ( (otherlv_3= 'input' ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )* )? (otherlv_5= 'output' ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )* )? (otherlv_7= 'local' ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )* )? (otherlv_9= 'over' ( (lv_whileDeclaration_10_0= ruleAWhileDeclaration ) ) )? (otherlv_11= 'let' ( ( (lv_equations_12_0= ruleAEquation ) ) otherlv_13= ';' )* )? ) otherlv_14= '.' ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:325:1: (otherlv_0= 'affine' ( (lv_name_1_0= ruleSystemID ) ) ( (lv_parameters_2_0= ruleADomain ) ) ( (otherlv_3= 'input' ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )* )? (otherlv_5= 'output' ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )* )? (otherlv_7= 'local' ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )* )? (otherlv_9= 'over' ( (lv_whileDeclaration_10_0= ruleAWhileDeclaration ) ) )? (otherlv_11= 'let' ( ( (lv_equations_12_0= ruleAEquation ) ) otherlv_13= ';' )* )? ) otherlv_14= '.' )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:325:1: (otherlv_0= 'affine' ( (lv_name_1_0= ruleSystemID ) ) ( (lv_parameters_2_0= ruleADomain ) ) ( (otherlv_3= 'input' ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )* )? (otherlv_5= 'output' ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )* )? (otherlv_7= 'local' ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )* )? (otherlv_9= 'over' ( (lv_whileDeclaration_10_0= ruleAWhileDeclaration ) ) )? (otherlv_11= 'let' ( ( (lv_equations_12_0= ruleAEquation ) ) otherlv_13= ';' )* )? ) otherlv_14= '.' )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:325:3: otherlv_0= 'affine' ( (lv_name_1_0= ruleSystemID ) ) ( (lv_parameters_2_0= ruleADomain ) ) ( (otherlv_3= 'input' ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )* )? (otherlv_5= 'output' ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )* )? (otherlv_7= 'local' ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )* )? (otherlv_9= 'over' ( (lv_whileDeclaration_10_0= ruleAWhileDeclaration ) ) )? (otherlv_11= 'let' ( ( (lv_equations_12_0= ruleAEquation ) ) otherlv_13= ';' )* )? ) otherlv_14= '.'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_36_in_ruleAAffineSystemA654); 

                	newLeafNode(otherlv_0, grammarAccess.getAAffineSystemAAccess().getAffineKeyword_0());
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:329:1: ( (lv_name_1_0= ruleSystemID ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:330:1: (lv_name_1_0= ruleSystemID )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:330:1: (lv_name_1_0= ruleSystemID )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:331:3: lv_name_1_0= ruleSystemID
            {
             
            	        newCompositeNode(grammarAccess.getAAffineSystemAAccess().getNameSystemIDParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleSystemID_in_ruleAAffineSystemA675);
            lv_name_1_0=ruleSystemID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAAffineSystemARule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"SystemID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:347:2: ( (lv_parameters_2_0= ruleADomain ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:348:1: (lv_parameters_2_0= ruleADomain )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:348:1: (lv_parameters_2_0= ruleADomain )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:349:3: lv_parameters_2_0= ruleADomain
            {
             
            	        newCompositeNode(grammarAccess.getAAffineSystemAAccess().getParametersADomainParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleADomain_in_ruleAAffineSystemA696);
            lv_parameters_2_0=ruleADomain();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAAffineSystemARule());
            	        }
                   		set(
                   			current, 
                   			"parameters",
                    		lv_parameters_2_0, 
                    		"ADomain");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:365:2: ( (otherlv_3= 'input' ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )* )? (otherlv_5= 'output' ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )* )? (otherlv_7= 'local' ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )* )? (otherlv_9= 'over' ( (lv_whileDeclaration_10_0= ruleAWhileDeclaration ) ) )? (otherlv_11= 'let' ( ( (lv_equations_12_0= ruleAEquation ) ) otherlv_13= ';' )* )? )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:365:3: (otherlv_3= 'input' ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )* )? (otherlv_5= 'output' ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )* )? (otherlv_7= 'local' ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )* )? (otherlv_9= 'over' ( (lv_whileDeclaration_10_0= ruleAWhileDeclaration ) ) )? (otherlv_11= 'let' ( ( (lv_equations_12_0= ruleAEquation ) ) otherlv_13= ';' )* )?
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:365:3: (otherlv_3= 'input' ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==37) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:365:5: otherlv_3= 'input' ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )*
                    {
                    otherlv_3=(Token)match(input,37,FOLLOW_37_in_ruleAAffineSystemA710); 

                        	newLeafNode(otherlv_3, grammarAccess.getAAffineSystemAAccess().getInputKeyword_3_0_0());
                        
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:369:1: ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=66 && LA6_0<=74)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:370:1: (lv_inputDeclarations_4_0= ruleAInputDeclaration )
                    	    {
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:370:1: (lv_inputDeclarations_4_0= ruleAInputDeclaration )
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:371:3: lv_inputDeclarations_4_0= ruleAInputDeclaration
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAAffineSystemAAccess().getInputDeclarationsAInputDeclarationParserRuleCall_3_0_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAInputDeclaration_in_ruleAAffineSystemA731);
                    	    lv_inputDeclarations_4_0=ruleAInputDeclaration();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAAffineSystemARule());
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
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:387:5: (otherlv_5= 'output' ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==38) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:387:7: otherlv_5= 'output' ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )*
                    {
                    otherlv_5=(Token)match(input,38,FOLLOW_38_in_ruleAAffineSystemA747); 

                        	newLeafNode(otherlv_5, grammarAccess.getAAffineSystemAAccess().getOutputKeyword_3_1_0());
                        
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:391:1: ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>=66 && LA8_0<=74)) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:392:1: (lv_outputDeclarations_6_0= ruleAOutputDeclaration )
                    	    {
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:392:1: (lv_outputDeclarations_6_0= ruleAOutputDeclaration )
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:393:3: lv_outputDeclarations_6_0= ruleAOutputDeclaration
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAAffineSystemAAccess().getOutputDeclarationsAOutputDeclarationParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAOutputDeclaration_in_ruleAAffineSystemA768);
                    	    lv_outputDeclarations_6_0=ruleAOutputDeclaration();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAAffineSystemARule());
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
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:409:5: (otherlv_7= 'local' ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==39) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:409:7: otherlv_7= 'local' ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )*
                    {
                    otherlv_7=(Token)match(input,39,FOLLOW_39_in_ruleAAffineSystemA784); 

                        	newLeafNode(otherlv_7, grammarAccess.getAAffineSystemAAccess().getLocalKeyword_3_2_0());
                        
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:413:1: ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>=66 && LA10_0<=74)) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:414:1: (lv_localvarDeclarations_8_0= ruleALocalDeclaration )
                    	    {
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:414:1: (lv_localvarDeclarations_8_0= ruleALocalDeclaration )
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:415:3: lv_localvarDeclarations_8_0= ruleALocalDeclaration
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAAffineSystemAAccess().getLocalvarDeclarationsALocalDeclarationParserRuleCall_3_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleALocalDeclaration_in_ruleAAffineSystemA805);
                    	    lv_localvarDeclarations_8_0=ruleALocalDeclaration();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAAffineSystemARule());
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
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:431:5: (otherlv_9= 'over' ( (lv_whileDeclaration_10_0= ruleAWhileDeclaration ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==40) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:431:7: otherlv_9= 'over' ( (lv_whileDeclaration_10_0= ruleAWhileDeclaration ) )
                    {
                    otherlv_9=(Token)match(input,40,FOLLOW_40_in_ruleAAffineSystemA821); 

                        	newLeafNode(otherlv_9, grammarAccess.getAAffineSystemAAccess().getOverKeyword_3_3_0());
                        
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:435:1: ( (lv_whileDeclaration_10_0= ruleAWhileDeclaration ) )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:436:1: (lv_whileDeclaration_10_0= ruleAWhileDeclaration )
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:436:1: (lv_whileDeclaration_10_0= ruleAWhileDeclaration )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:437:3: lv_whileDeclaration_10_0= ruleAWhileDeclaration
                    {
                     
                    	        newCompositeNode(grammarAccess.getAAffineSystemAAccess().getWhileDeclarationAWhileDeclarationParserRuleCall_3_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAWhileDeclaration_in_ruleAAffineSystemA842);
                    lv_whileDeclaration_10_0=ruleAWhileDeclaration();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAAffineSystemARule());
                    	        }
                           		set(
                           			current, 
                           			"whileDeclaration",
                            		lv_whileDeclaration_10_0, 
                            		"AWhileDeclaration");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:453:4: (otherlv_11= 'let' ( ( (lv_equations_12_0= ruleAEquation ) ) otherlv_13= ';' )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==41) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:453:6: otherlv_11= 'let' ( ( (lv_equations_12_0= ruleAEquation ) ) otherlv_13= ';' )*
                    {
                    otherlv_11=(Token)match(input,41,FOLLOW_41_in_ruleAAffineSystemA857); 

                        	newLeafNode(otherlv_11, grammarAccess.getAAffineSystemAAccess().getLetKeyword_3_4_0());
                        
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:457:1: ( ( (lv_equations_12_0= ruleAEquation ) ) otherlv_13= ';' )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==RULE_ID||LA13_0==54) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:457:2: ( (lv_equations_12_0= ruleAEquation ) ) otherlv_13= ';'
                    	    {
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:457:2: ( (lv_equations_12_0= ruleAEquation ) )
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:458:1: (lv_equations_12_0= ruleAEquation )
                    	    {
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:458:1: (lv_equations_12_0= ruleAEquation )
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:459:3: lv_equations_12_0= ruleAEquation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAAffineSystemAAccess().getEquationsAEquationParserRuleCall_3_4_1_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAEquation_in_ruleAAffineSystemA879);
                    	    lv_equations_12_0=ruleAEquation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAAffineSystemARule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"equations",
                    	            		lv_equations_12_0, 
                    	            		"AEquation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	    otherlv_13=(Token)match(input,35,FOLLOW_35_in_ruleAAffineSystemA891); 

                    	        	newLeafNode(otherlv_13, grammarAccess.getAAffineSystemAAccess().getSemicolonKeyword_3_4_1_1());
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            otherlv_14=(Token)match(input,42,FOLLOW_42_in_ruleAAffineSystemA908); 

                	newLeafNode(otherlv_14, grammarAccess.getAAffineSystemAAccess().getFullStopKeyword_4());
                

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
    // $ANTLR end "ruleAAffineSystemA"


    // $ANTLR start "entryRuleAAffineSystemB"
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:491:1: entryRuleAAffineSystemB returns [EObject current=null] : iv_ruleAAffineSystemB= ruleAAffineSystemB EOF ;
    public final EObject entryRuleAAffineSystemB() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAAffineSystemB = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:492:2: (iv_ruleAAffineSystemB= ruleAAffineSystemB EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:493:2: iv_ruleAAffineSystemB= ruleAAffineSystemB EOF
            {
             newCompositeNode(grammarAccess.getAAffineSystemBRule()); 
            pushFollow(FOLLOW_ruleAAffineSystemB_in_entryRuleAAffineSystemB944);
            iv_ruleAAffineSystemB=ruleAAffineSystemB();

            state._fsp--;

             current =iv_ruleAAffineSystemB; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAAffineSystemB954); 

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
    // $ANTLR end "entryRuleAAffineSystemB"


    // $ANTLR start "ruleAAffineSystemB"
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:500:1: ruleAAffineSystemB returns [EObject current=null] : (otherlv_0= 'affine' ( (lv_name_1_0= ruleSystemID ) ) ( (lv_parameters_2_0= ruleADomain ) ) ( (otherlv_3= 'given' ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )* )? (otherlv_5= 'returns' ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )* )? (otherlv_7= 'using' ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )* )? (otherlv_9= 'through' ( ( (lv_equations_10_0= ruleAEquation ) ) otherlv_11= ';' )* )? ) otherlv_12= '.' ) ;
    public final EObject ruleAAffineSystemB() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_parameters_2_0 = null;

        EObject lv_inputDeclarations_4_0 = null;

        EObject lv_outputDeclarations_6_0 = null;

        EObject lv_localvarDeclarations_8_0 = null;

        EObject lv_equations_10_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:503:28: ( (otherlv_0= 'affine' ( (lv_name_1_0= ruleSystemID ) ) ( (lv_parameters_2_0= ruleADomain ) ) ( (otherlv_3= 'given' ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )* )? (otherlv_5= 'returns' ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )* )? (otherlv_7= 'using' ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )* )? (otherlv_9= 'through' ( ( (lv_equations_10_0= ruleAEquation ) ) otherlv_11= ';' )* )? ) otherlv_12= '.' ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:504:1: (otherlv_0= 'affine' ( (lv_name_1_0= ruleSystemID ) ) ( (lv_parameters_2_0= ruleADomain ) ) ( (otherlv_3= 'given' ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )* )? (otherlv_5= 'returns' ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )* )? (otherlv_7= 'using' ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )* )? (otherlv_9= 'through' ( ( (lv_equations_10_0= ruleAEquation ) ) otherlv_11= ';' )* )? ) otherlv_12= '.' )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:504:1: (otherlv_0= 'affine' ( (lv_name_1_0= ruleSystemID ) ) ( (lv_parameters_2_0= ruleADomain ) ) ( (otherlv_3= 'given' ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )* )? (otherlv_5= 'returns' ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )* )? (otherlv_7= 'using' ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )* )? (otherlv_9= 'through' ( ( (lv_equations_10_0= ruleAEquation ) ) otherlv_11= ';' )* )? ) otherlv_12= '.' )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:504:3: otherlv_0= 'affine' ( (lv_name_1_0= ruleSystemID ) ) ( (lv_parameters_2_0= ruleADomain ) ) ( (otherlv_3= 'given' ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )* )? (otherlv_5= 'returns' ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )* )? (otherlv_7= 'using' ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )* )? (otherlv_9= 'through' ( ( (lv_equations_10_0= ruleAEquation ) ) otherlv_11= ';' )* )? ) otherlv_12= '.'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_36_in_ruleAAffineSystemB991); 

                	newLeafNode(otherlv_0, grammarAccess.getAAffineSystemBAccess().getAffineKeyword_0());
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:508:1: ( (lv_name_1_0= ruleSystemID ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:509:1: (lv_name_1_0= ruleSystemID )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:509:1: (lv_name_1_0= ruleSystemID )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:510:3: lv_name_1_0= ruleSystemID
            {
             
            	        newCompositeNode(grammarAccess.getAAffineSystemBAccess().getNameSystemIDParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleSystemID_in_ruleAAffineSystemB1012);
            lv_name_1_0=ruleSystemID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAAffineSystemBRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"SystemID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:526:2: ( (lv_parameters_2_0= ruleADomain ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:527:1: (lv_parameters_2_0= ruleADomain )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:527:1: (lv_parameters_2_0= ruleADomain )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:528:3: lv_parameters_2_0= ruleADomain
            {
             
            	        newCompositeNode(grammarAccess.getAAffineSystemBAccess().getParametersADomainParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleADomain_in_ruleAAffineSystemB1033);
            lv_parameters_2_0=ruleADomain();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAAffineSystemBRule());
            	        }
                   		set(
                   			current, 
                   			"parameters",
                    		lv_parameters_2_0, 
                    		"ADomain");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:544:2: ( (otherlv_3= 'given' ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )* )? (otherlv_5= 'returns' ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )* )? (otherlv_7= 'using' ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )* )? (otherlv_9= 'through' ( ( (lv_equations_10_0= ruleAEquation ) ) otherlv_11= ';' )* )? )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:544:3: (otherlv_3= 'given' ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )* )? (otherlv_5= 'returns' ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )* )? (otherlv_7= 'using' ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )* )? (otherlv_9= 'through' ( ( (lv_equations_10_0= ruleAEquation ) ) otherlv_11= ';' )* )?
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:544:3: (otherlv_3= 'given' ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==43) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:544:5: otherlv_3= 'given' ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )*
                    {
                    otherlv_3=(Token)match(input,43,FOLLOW_43_in_ruleAAffineSystemB1047); 

                        	newLeafNode(otherlv_3, grammarAccess.getAAffineSystemBAccess().getGivenKeyword_3_0_0());
                        
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:548:1: ( (lv_inputDeclarations_4_0= ruleAInputDeclaration ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>=66 && LA15_0<=74)) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:549:1: (lv_inputDeclarations_4_0= ruleAInputDeclaration )
                    	    {
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:549:1: (lv_inputDeclarations_4_0= ruleAInputDeclaration )
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:550:3: lv_inputDeclarations_4_0= ruleAInputDeclaration
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAAffineSystemBAccess().getInputDeclarationsAInputDeclarationParserRuleCall_3_0_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAInputDeclaration_in_ruleAAffineSystemB1068);
                    	    lv_inputDeclarations_4_0=ruleAInputDeclaration();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAAffineSystemBRule());
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
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:566:5: (otherlv_5= 'returns' ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==44) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:566:7: otherlv_5= 'returns' ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )*
                    {
                    otherlv_5=(Token)match(input,44,FOLLOW_44_in_ruleAAffineSystemB1084); 

                        	newLeafNode(otherlv_5, grammarAccess.getAAffineSystemBAccess().getReturnsKeyword_3_1_0());
                        
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:570:1: ( (lv_outputDeclarations_6_0= ruleAOutputDeclaration ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( ((LA17_0>=66 && LA17_0<=74)) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:571:1: (lv_outputDeclarations_6_0= ruleAOutputDeclaration )
                    	    {
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:571:1: (lv_outputDeclarations_6_0= ruleAOutputDeclaration )
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:572:3: lv_outputDeclarations_6_0= ruleAOutputDeclaration
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAAffineSystemBAccess().getOutputDeclarationsAOutputDeclarationParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAOutputDeclaration_in_ruleAAffineSystemB1105);
                    	    lv_outputDeclarations_6_0=ruleAOutputDeclaration();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAAffineSystemBRule());
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
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:588:5: (otherlv_7= 'using' ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )* )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==45) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:588:7: otherlv_7= 'using' ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )*
                    {
                    otherlv_7=(Token)match(input,45,FOLLOW_45_in_ruleAAffineSystemB1121); 

                        	newLeafNode(otherlv_7, grammarAccess.getAAffineSystemBAccess().getUsingKeyword_3_2_0());
                        
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:592:1: ( (lv_localvarDeclarations_8_0= ruleALocalDeclaration ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( ((LA19_0>=66 && LA19_0<=74)) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:593:1: (lv_localvarDeclarations_8_0= ruleALocalDeclaration )
                    	    {
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:593:1: (lv_localvarDeclarations_8_0= ruleALocalDeclaration )
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:594:3: lv_localvarDeclarations_8_0= ruleALocalDeclaration
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAAffineSystemBAccess().getLocalvarDeclarationsALocalDeclarationParserRuleCall_3_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleALocalDeclaration_in_ruleAAffineSystemB1142);
                    	    lv_localvarDeclarations_8_0=ruleALocalDeclaration();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAAffineSystemBRule());
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
                    	    break loop19;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:610:5: (otherlv_9= 'through' ( ( (lv_equations_10_0= ruleAEquation ) ) otherlv_11= ';' )* )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==46) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:610:7: otherlv_9= 'through' ( ( (lv_equations_10_0= ruleAEquation ) ) otherlv_11= ';' )*
                    {
                    otherlv_9=(Token)match(input,46,FOLLOW_46_in_ruleAAffineSystemB1158); 

                        	newLeafNode(otherlv_9, grammarAccess.getAAffineSystemBAccess().getThroughKeyword_3_3_0());
                        
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:614:1: ( ( (lv_equations_10_0= ruleAEquation ) ) otherlv_11= ';' )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==RULE_ID||LA21_0==54) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:614:2: ( (lv_equations_10_0= ruleAEquation ) ) otherlv_11= ';'
                    	    {
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:614:2: ( (lv_equations_10_0= ruleAEquation ) )
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:615:1: (lv_equations_10_0= ruleAEquation )
                    	    {
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:615:1: (lv_equations_10_0= ruleAEquation )
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:616:3: lv_equations_10_0= ruleAEquation
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAAffineSystemBAccess().getEquationsAEquationParserRuleCall_3_3_1_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAEquation_in_ruleAAffineSystemB1180);
                    	    lv_equations_10_0=ruleAEquation();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAAffineSystemBRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"equations",
                    	            		lv_equations_10_0, 
                    	            		"AEquation");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	    otherlv_11=(Token)match(input,35,FOLLOW_35_in_ruleAAffineSystemB1192); 

                    	        	newLeafNode(otherlv_11, grammarAccess.getAAffineSystemBAccess().getSemicolonKeyword_3_3_1_1());
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            otherlv_12=(Token)match(input,42,FOLLOW_42_in_ruleAAffineSystemB1209); 

                	newLeafNode(otherlv_12, grammarAccess.getAAffineSystemBAccess().getFullStopKeyword_4());
                

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
    // $ANTLR end "ruleAAffineSystemB"


    // $ANTLR start "entryRuleAOutputDeclaration"
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:650:1: entryRuleAOutputDeclaration returns [EObject current=null] : iv_ruleAOutputDeclaration= ruleAOutputDeclaration EOF ;
    public final EObject entryRuleAOutputDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAOutputDeclaration = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:651:2: (iv_ruleAOutputDeclaration= ruleAOutputDeclaration EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:652:2: iv_ruleAOutputDeclaration= ruleAOutputDeclaration EOF
            {
             newCompositeNode(grammarAccess.getAOutputDeclarationRule()); 
            pushFollow(FOLLOW_ruleAOutputDeclaration_in_entryRuleAOutputDeclaration1247);
            iv_ruleAOutputDeclaration=ruleAOutputDeclaration();

            state._fsp--;

             current =iv_ruleAOutputDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAOutputDeclaration1257); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:659:1: ruleAOutputDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';' ) ;
    public final EObject ruleAOutputDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject lv_type_0_0 = null;

        EObject lv_identifierList_1_0 = null;

        EObject lv_domain_2_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:662:28: ( ( ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';' ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:663:1: ( ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';' )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:663:1: ( ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';' )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:663:2: ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';'
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:663:2: ( (lv_type_0_0= ruleAType ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:664:1: (lv_type_0_0= ruleAType )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:664:1: (lv_type_0_0= ruleAType )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:665:3: lv_type_0_0= ruleAType
            {
             
            	        newCompositeNode(grammarAccess.getAOutputDeclarationAccess().getTypeATypeParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleAType_in_ruleAOutputDeclaration1303);
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

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:681:2: ( (lv_identifierList_1_0= ruleAIdentifierList ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:682:1: (lv_identifierList_1_0= ruleAIdentifierList )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:682:1: (lv_identifierList_1_0= ruleAIdentifierList )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:683:3: lv_identifierList_1_0= ruleAIdentifierList
            {
             
            	        newCompositeNode(grammarAccess.getAOutputDeclarationAccess().getIdentifierListAIdentifierListParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleAIdentifierList_in_ruleAOutputDeclaration1324);
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

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:699:2: ( (lv_domain_2_0= ruleADomain ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==48) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:700:1: (lv_domain_2_0= ruleADomain )
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:700:1: (lv_domain_2_0= ruleADomain )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:701:3: lv_domain_2_0= ruleADomain
                    {
                     
                    	        newCompositeNode(grammarAccess.getAOutputDeclarationAccess().getDomainADomainParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleADomain_in_ruleAOutputDeclaration1345);
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

            otherlv_3=(Token)match(input,35,FOLLOW_35_in_ruleAOutputDeclaration1358); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:729:1: entryRuleAInputDeclaration returns [EObject current=null] : iv_ruleAInputDeclaration= ruleAInputDeclaration EOF ;
    public final EObject entryRuleAInputDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAInputDeclaration = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:730:2: (iv_ruleAInputDeclaration= ruleAInputDeclaration EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:731:2: iv_ruleAInputDeclaration= ruleAInputDeclaration EOF
            {
             newCompositeNode(grammarAccess.getAInputDeclarationRule()); 
            pushFollow(FOLLOW_ruleAInputDeclaration_in_entryRuleAInputDeclaration1394);
            iv_ruleAInputDeclaration=ruleAInputDeclaration();

            state._fsp--;

             current =iv_ruleAInputDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAInputDeclaration1404); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:738:1: ruleAInputDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';' ) ;
    public final EObject ruleAInputDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject lv_type_0_0 = null;

        EObject lv_identifierList_1_0 = null;

        EObject lv_domain_2_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:741:28: ( ( ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';' ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:742:1: ( ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';' )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:742:1: ( ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';' )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:742:2: ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';'
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:742:2: ( (lv_type_0_0= ruleAType ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:743:1: (lv_type_0_0= ruleAType )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:743:1: (lv_type_0_0= ruleAType )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:744:3: lv_type_0_0= ruleAType
            {
             
            	        newCompositeNode(grammarAccess.getAInputDeclarationAccess().getTypeATypeParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleAType_in_ruleAInputDeclaration1450);
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

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:760:2: ( (lv_identifierList_1_0= ruleAIdentifierList ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:761:1: (lv_identifierList_1_0= ruleAIdentifierList )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:761:1: (lv_identifierList_1_0= ruleAIdentifierList )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:762:3: lv_identifierList_1_0= ruleAIdentifierList
            {
             
            	        newCompositeNode(grammarAccess.getAInputDeclarationAccess().getIdentifierListAIdentifierListParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleAIdentifierList_in_ruleAInputDeclaration1471);
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

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:778:2: ( (lv_domain_2_0= ruleADomain ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==48) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:779:1: (lv_domain_2_0= ruleADomain )
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:779:1: (lv_domain_2_0= ruleADomain )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:780:3: lv_domain_2_0= ruleADomain
                    {
                     
                    	        newCompositeNode(grammarAccess.getAInputDeclarationAccess().getDomainADomainParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleADomain_in_ruleAInputDeclaration1492);
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

            otherlv_3=(Token)match(input,35,FOLLOW_35_in_ruleAInputDeclaration1505); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:808:1: entryRuleALocalDeclaration returns [EObject current=null] : iv_ruleALocalDeclaration= ruleALocalDeclaration EOF ;
    public final EObject entryRuleALocalDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleALocalDeclaration = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:809:2: (iv_ruleALocalDeclaration= ruleALocalDeclaration EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:810:2: iv_ruleALocalDeclaration= ruleALocalDeclaration EOF
            {
             newCompositeNode(grammarAccess.getALocalDeclarationRule()); 
            pushFollow(FOLLOW_ruleALocalDeclaration_in_entryRuleALocalDeclaration1541);
            iv_ruleALocalDeclaration=ruleALocalDeclaration();

            state._fsp--;

             current =iv_ruleALocalDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleALocalDeclaration1551); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:817:1: ruleALocalDeclaration returns [EObject current=null] : ( ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';' ) ;
    public final EObject ruleALocalDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject lv_type_0_0 = null;

        EObject lv_identifierList_1_0 = null;

        EObject lv_domain_2_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:820:28: ( ( ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';' ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:821:1: ( ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';' )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:821:1: ( ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';' )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:821:2: ( (lv_type_0_0= ruleAType ) ) ( (lv_identifierList_1_0= ruleAIdentifierList ) ) ( (lv_domain_2_0= ruleADomain ) )? otherlv_3= ';'
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:821:2: ( (lv_type_0_0= ruleAType ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:822:1: (lv_type_0_0= ruleAType )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:822:1: (lv_type_0_0= ruleAType )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:823:3: lv_type_0_0= ruleAType
            {
             
            	        newCompositeNode(grammarAccess.getALocalDeclarationAccess().getTypeATypeParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleAType_in_ruleALocalDeclaration1597);
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

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:839:2: ( (lv_identifierList_1_0= ruleAIdentifierList ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:840:1: (lv_identifierList_1_0= ruleAIdentifierList )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:840:1: (lv_identifierList_1_0= ruleAIdentifierList )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:841:3: lv_identifierList_1_0= ruleAIdentifierList
            {
             
            	        newCompositeNode(grammarAccess.getALocalDeclarationAccess().getIdentifierListAIdentifierListParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleAIdentifierList_in_ruleALocalDeclaration1618);
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

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:857:2: ( (lv_domain_2_0= ruleADomain ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==48) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:858:1: (lv_domain_2_0= ruleADomain )
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:858:1: (lv_domain_2_0= ruleADomain )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:859:3: lv_domain_2_0= ruleADomain
                    {
                     
                    	        newCompositeNode(grammarAccess.getALocalDeclarationAccess().getDomainADomainParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleADomain_in_ruleALocalDeclaration1639);
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

            otherlv_3=(Token)match(input,35,FOLLOW_35_in_ruleALocalDeclaration1652); 

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


    // $ANTLR start "entryRuleAWhileDeclaration"
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:887:1: entryRuleAWhileDeclaration returns [EObject current=null] : iv_ruleAWhileDeclaration= ruleAWhileDeclaration EOF ;
    public final EObject entryRuleAWhileDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAWhileDeclaration = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:888:2: (iv_ruleAWhileDeclaration= ruleAWhileDeclaration EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:889:2: iv_ruleAWhileDeclaration= ruleAWhileDeclaration EOF
            {
             newCompositeNode(grammarAccess.getAWhileDeclarationRule()); 
            pushFollow(FOLLOW_ruleAWhileDeclaration_in_entryRuleAWhileDeclaration1688);
            iv_ruleAWhileDeclaration=ruleAWhileDeclaration();

            state._fsp--;

             current =iv_ruleAWhileDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAWhileDeclaration1698); 

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
    // $ANTLR end "entryRuleAWhileDeclaration"


    // $ANTLR start "ruleAWhileDeclaration"
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:896:1: ruleAWhileDeclaration returns [EObject current=null] : ( ( (lv_timeDomain_0_0= ruleADomain ) ) otherlv_1= 'while' ( (lv_cond_2_0= ruleAAlphabetsExpression ) ) ) ;
    public final EObject ruleAWhileDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_timeDomain_0_0 = null;

        EObject lv_cond_2_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:899:28: ( ( ( (lv_timeDomain_0_0= ruleADomain ) ) otherlv_1= 'while' ( (lv_cond_2_0= ruleAAlphabetsExpression ) ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:900:1: ( ( (lv_timeDomain_0_0= ruleADomain ) ) otherlv_1= 'while' ( (lv_cond_2_0= ruleAAlphabetsExpression ) ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:900:1: ( ( (lv_timeDomain_0_0= ruleADomain ) ) otherlv_1= 'while' ( (lv_cond_2_0= ruleAAlphabetsExpression ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:900:2: ( (lv_timeDomain_0_0= ruleADomain ) ) otherlv_1= 'while' ( (lv_cond_2_0= ruleAAlphabetsExpression ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:900:2: ( (lv_timeDomain_0_0= ruleADomain ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:901:1: (lv_timeDomain_0_0= ruleADomain )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:901:1: (lv_timeDomain_0_0= ruleADomain )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:902:3: lv_timeDomain_0_0= ruleADomain
            {
             
            	        newCompositeNode(grammarAccess.getAWhileDeclarationAccess().getTimeDomainADomainParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleADomain_in_ruleAWhileDeclaration1744);
            lv_timeDomain_0_0=ruleADomain();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAWhileDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"timeDomain",
                    		lv_timeDomain_0_0, 
                    		"ADomain");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,47,FOLLOW_47_in_ruleAWhileDeclaration1756); 

                	newLeafNode(otherlv_1, grammarAccess.getAWhileDeclarationAccess().getWhileKeyword_1());
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:922:1: ( (lv_cond_2_0= ruleAAlphabetsExpression ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:923:1: (lv_cond_2_0= ruleAAlphabetsExpression )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:923:1: (lv_cond_2_0= ruleAAlphabetsExpression )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:924:3: lv_cond_2_0= ruleAAlphabetsExpression
            {
             
            	        newCompositeNode(grammarAccess.getAWhileDeclarationAccess().getCondAAlphabetsExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleAWhileDeclaration1777);
            lv_cond_2_0=ruleAAlphabetsExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAWhileDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"cond",
                    		lv_cond_2_0, 
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
    // $ANTLR end "ruleAWhileDeclaration"


    // $ANTLR start "entryRuleAIdentifierList"
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:948:1: entryRuleAIdentifierList returns [EObject current=null] : iv_ruleAIdentifierList= ruleAIdentifierList EOF ;
    public final EObject entryRuleAIdentifierList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAIdentifierList = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:949:2: (iv_ruleAIdentifierList= ruleAIdentifierList EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:950:2: iv_ruleAIdentifierList= ruleAIdentifierList EOF
            {
             newCompositeNode(grammarAccess.getAIdentifierListRule()); 
            pushFollow(FOLLOW_ruleAIdentifierList_in_entryRuleAIdentifierList1813);
            iv_ruleAIdentifierList=ruleAIdentifierList();

            state._fsp--;

             current =iv_ruleAIdentifierList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAIdentifierList1823); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:957:1: ruleAIdentifierList returns [EObject current=null] : ( ( (lv_identifiers_0_0= ruleVariableIdentifier ) ) (otherlv_1= ',' ( (lv_identifiers_2_0= ruleVariableIdentifier ) ) )* ) ;
    public final EObject ruleAIdentifierList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_identifiers_0_0 = null;

        AntlrDatatypeRuleToken lv_identifiers_2_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:960:28: ( ( ( (lv_identifiers_0_0= ruleVariableIdentifier ) ) (otherlv_1= ',' ( (lv_identifiers_2_0= ruleVariableIdentifier ) ) )* ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:961:1: ( ( (lv_identifiers_0_0= ruleVariableIdentifier ) ) (otherlv_1= ',' ( (lv_identifiers_2_0= ruleVariableIdentifier ) ) )* )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:961:1: ( ( (lv_identifiers_0_0= ruleVariableIdentifier ) ) (otherlv_1= ',' ( (lv_identifiers_2_0= ruleVariableIdentifier ) ) )* )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:961:2: ( (lv_identifiers_0_0= ruleVariableIdentifier ) ) (otherlv_1= ',' ( (lv_identifiers_2_0= ruleVariableIdentifier ) ) )*
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:961:2: ( (lv_identifiers_0_0= ruleVariableIdentifier ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:962:1: (lv_identifiers_0_0= ruleVariableIdentifier )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:962:1: (lv_identifiers_0_0= ruleVariableIdentifier )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:963:3: lv_identifiers_0_0= ruleVariableIdentifier
            {
             
            	        newCompositeNode(grammarAccess.getAIdentifierListAccess().getIdentifiersVariableIdentifierParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleVariableIdentifier_in_ruleAIdentifierList1869);
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

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:979:2: (otherlv_1= ',' ( (lv_identifiers_2_0= ruleVariableIdentifier ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==33) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:979:4: otherlv_1= ',' ( (lv_identifiers_2_0= ruleVariableIdentifier ) )
            	    {
            	    otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleAIdentifierList1882); 

            	        	newLeafNode(otherlv_1, grammarAccess.getAIdentifierListAccess().getCommaKeyword_1_0());
            	        
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:983:1: ( (lv_identifiers_2_0= ruleVariableIdentifier ) )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:984:1: (lv_identifiers_2_0= ruleVariableIdentifier )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:984:1: (lv_identifiers_2_0= ruleVariableIdentifier )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:985:3: lv_identifiers_2_0= ruleVariableIdentifier
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAIdentifierListAccess().getIdentifiersVariableIdentifierParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleVariableIdentifier_in_ruleAIdentifierList1903);
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
            	    break loop26;
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1009:1: entryRuleVariableIdentifier returns [String current=null] : iv_ruleVariableIdentifier= ruleVariableIdentifier EOF ;
    public final String entryRuleVariableIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVariableIdentifier = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1010:2: (iv_ruleVariableIdentifier= ruleVariableIdentifier EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1011:2: iv_ruleVariableIdentifier= ruleVariableIdentifier EOF
            {
             newCompositeNode(grammarAccess.getVariableIdentifierRule()); 
            pushFollow(FOLLOW_ruleVariableIdentifier_in_entryRuleVariableIdentifier1942);
            iv_ruleVariableIdentifier=ruleVariableIdentifier();

            state._fsp--;

             current =iv_ruleVariableIdentifier.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableIdentifier1953); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1018:1: ruleVariableIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleVariableIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1021:28: (this_ID_0= RULE_ID )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1022:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableIdentifier1992); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1037:1: entryRuleADomain returns [EObject current=null] : iv_ruleADomain= ruleADomain EOF ;
    public final EObject entryRuleADomain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleADomain = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1038:2: (iv_ruleADomain= ruleADomain EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1039:2: iv_ruleADomain= ruleADomain EOF
            {
             newCompositeNode(grammarAccess.getADomainRule()); 
            pushFollow(FOLLOW_ruleADomain_in_entryRuleADomain2036);
            iv_ruleADomain=ruleADomain();

            state._fsp--;

             current =iv_ruleADomain; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleADomain2046); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1046:1: ruleADomain returns [EObject current=null] : ( ( (lv_polyhedra_0_0= ruleAPolyhedron ) ) (this_UNION_1= RULE_UNION ( (lv_polyhedra_2_0= ruleAPolyhedron ) ) )* ) ;
    public final EObject ruleADomain() throws RecognitionException {
        EObject current = null;

        Token this_UNION_1=null;
        EObject lv_polyhedra_0_0 = null;

        EObject lv_polyhedra_2_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1049:28: ( ( ( (lv_polyhedra_0_0= ruleAPolyhedron ) ) (this_UNION_1= RULE_UNION ( (lv_polyhedra_2_0= ruleAPolyhedron ) ) )* ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1050:1: ( ( (lv_polyhedra_0_0= ruleAPolyhedron ) ) (this_UNION_1= RULE_UNION ( (lv_polyhedra_2_0= ruleAPolyhedron ) ) )* )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1050:1: ( ( (lv_polyhedra_0_0= ruleAPolyhedron ) ) (this_UNION_1= RULE_UNION ( (lv_polyhedra_2_0= ruleAPolyhedron ) ) )* )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1050:2: ( (lv_polyhedra_0_0= ruleAPolyhedron ) ) (this_UNION_1= RULE_UNION ( (lv_polyhedra_2_0= ruleAPolyhedron ) ) )*
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1050:2: ( (lv_polyhedra_0_0= ruleAPolyhedron ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1051:1: (lv_polyhedra_0_0= ruleAPolyhedron )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1051:1: (lv_polyhedra_0_0= ruleAPolyhedron )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1052:3: lv_polyhedra_0_0= ruleAPolyhedron
            {
             
            	        newCompositeNode(grammarAccess.getADomainAccess().getPolyhedraAPolyhedronParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleAPolyhedron_in_ruleADomain2092);
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

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1068:2: (this_UNION_1= RULE_UNION ( (lv_polyhedra_2_0= ruleAPolyhedron ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_UNION) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1068:3: this_UNION_1= RULE_UNION ( (lv_polyhedra_2_0= ruleAPolyhedron ) )
            	    {
            	    this_UNION_1=(Token)match(input,RULE_UNION,FOLLOW_RULE_UNION_in_ruleADomain2104); 
            	     
            	        newLeafNode(this_UNION_1, grammarAccess.getADomainAccess().getUNIONTerminalRuleCall_1_0()); 
            	        
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1072:1: ( (lv_polyhedra_2_0= ruleAPolyhedron ) )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1073:1: (lv_polyhedra_2_0= ruleAPolyhedron )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1073:1: (lv_polyhedra_2_0= ruleAPolyhedron )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1074:3: lv_polyhedra_2_0= ruleAPolyhedron
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getADomainAccess().getPolyhedraAPolyhedronParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAPolyhedron_in_ruleADomain2124);
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
            	    break loop27;
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1098:1: entryRuleAPolyhedron returns [EObject current=null] : iv_ruleAPolyhedron= ruleAPolyhedron EOF ;
    public final EObject entryRuleAPolyhedron() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAPolyhedron = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1099:2: (iv_ruleAPolyhedron= ruleAPolyhedron EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1100:2: iv_ruleAPolyhedron= ruleAPolyhedron EOF
            {
             newCompositeNode(grammarAccess.getAPolyhedronRule()); 
            pushFollow(FOLLOW_ruleAPolyhedron_in_entryRuleAPolyhedron2162);
            iv_ruleAPolyhedron=ruleAPolyhedron();

            state._fsp--;

             current =iv_ruleAPolyhedron; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAPolyhedron2172); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1107:1: ruleAPolyhedron returns [EObject current=null] : (otherlv_0= '{' ( (lv_indexes_1_0= ruleAIndexList ) ) otherlv_2= '|' ( ( (lv_constraints_3_0= ruleInEquality ) ) (this_INTERSECTION_4= RULE_INTERSECTION ( (lv_constraints_5_0= ruleInEquality ) ) )* )? otherlv_6= '}' ) ;
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
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1110:28: ( (otherlv_0= '{' ( (lv_indexes_1_0= ruleAIndexList ) ) otherlv_2= '|' ( ( (lv_constraints_3_0= ruleInEquality ) ) (this_INTERSECTION_4= RULE_INTERSECTION ( (lv_constraints_5_0= ruleInEquality ) ) )* )? otherlv_6= '}' ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1111:1: (otherlv_0= '{' ( (lv_indexes_1_0= ruleAIndexList ) ) otherlv_2= '|' ( ( (lv_constraints_3_0= ruleInEquality ) ) (this_INTERSECTION_4= RULE_INTERSECTION ( (lv_constraints_5_0= ruleInEquality ) ) )* )? otherlv_6= '}' )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1111:1: (otherlv_0= '{' ( (lv_indexes_1_0= ruleAIndexList ) ) otherlv_2= '|' ( ( (lv_constraints_3_0= ruleInEquality ) ) (this_INTERSECTION_4= RULE_INTERSECTION ( (lv_constraints_5_0= ruleInEquality ) ) )* )? otherlv_6= '}' )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1111:3: otherlv_0= '{' ( (lv_indexes_1_0= ruleAIndexList ) ) otherlv_2= '|' ( ( (lv_constraints_3_0= ruleInEquality ) ) (this_INTERSECTION_4= RULE_INTERSECTION ( (lv_constraints_5_0= ruleInEquality ) ) )* )? otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,48,FOLLOW_48_in_ruleAPolyhedron2209); 

                	newLeafNode(otherlv_0, grammarAccess.getAPolyhedronAccess().getLeftCurlyBracketKeyword_0());
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1115:1: ( (lv_indexes_1_0= ruleAIndexList ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1116:1: (lv_indexes_1_0= ruleAIndexList )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1116:1: (lv_indexes_1_0= ruleAIndexList )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1117:3: lv_indexes_1_0= ruleAIndexList
            {
             
            	        newCompositeNode(grammarAccess.getAPolyhedronAccess().getIndexesAIndexListParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleAIndexList_in_ruleAPolyhedron2230);
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

            otherlv_2=(Token)match(input,49,FOLLOW_49_in_ruleAPolyhedron2242); 

                	newLeafNode(otherlv_2, grammarAccess.getAPolyhedronAccess().getVerticalLineKeyword_2());
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1137:1: ( ( (lv_constraints_3_0= ruleInEquality ) ) (this_INTERSECTION_4= RULE_INTERSECTION ( (lv_constraints_5_0= ruleInEquality ) ) )* )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID||(LA29_0>=RULE_MINUSOP && LA29_0<=RULE_INT)||LA29_0==32) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1137:2: ( (lv_constraints_3_0= ruleInEquality ) ) (this_INTERSECTION_4= RULE_INTERSECTION ( (lv_constraints_5_0= ruleInEquality ) ) )*
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1137:2: ( (lv_constraints_3_0= ruleInEquality ) )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1138:1: (lv_constraints_3_0= ruleInEquality )
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1138:1: (lv_constraints_3_0= ruleInEquality )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1139:3: lv_constraints_3_0= ruleInEquality
                    {
                     
                    	        newCompositeNode(grammarAccess.getAPolyhedronAccess().getConstraintsInEqualityParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleInEquality_in_ruleAPolyhedron2264);
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

                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1155:2: (this_INTERSECTION_4= RULE_INTERSECTION ( (lv_constraints_5_0= ruleInEquality ) ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==RULE_INTERSECTION) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1155:3: this_INTERSECTION_4= RULE_INTERSECTION ( (lv_constraints_5_0= ruleInEquality ) )
                    	    {
                    	    this_INTERSECTION_4=(Token)match(input,RULE_INTERSECTION,FOLLOW_RULE_INTERSECTION_in_ruleAPolyhedron2276); 
                    	     
                    	        newLeafNode(this_INTERSECTION_4, grammarAccess.getAPolyhedronAccess().getINTERSECTIONTerminalRuleCall_3_1_0()); 
                    	        
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1159:1: ( (lv_constraints_5_0= ruleInEquality ) )
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1160:1: (lv_constraints_5_0= ruleInEquality )
                    	    {
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1160:1: (lv_constraints_5_0= ruleInEquality )
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1161:3: lv_constraints_5_0= ruleInEquality
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAPolyhedronAccess().getConstraintsInEqualityParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleInEquality_in_ruleAPolyhedron2296);
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
                    	    break loop28;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,50,FOLLOW_50_in_ruleAPolyhedron2312); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1189:1: entryRuleInEquality returns [String current=null] : iv_ruleInEquality= ruleInEquality EOF ;
    public final String entryRuleInEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInEquality = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1190:2: (iv_ruleInEquality= ruleInEquality EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1191:2: iv_ruleInEquality= ruleInEquality EOF
            {
             newCompositeNode(grammarAccess.getInEqualityRule()); 
            pushFollow(FOLLOW_ruleInEquality_in_entryRuleInEquality2349);
            iv_ruleInEquality=ruleInEquality();

            state._fsp--;

             current =iv_ruleInEquality.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInEquality2360); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1198:1: ruleInEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_IDList_0= ruleIDList | this_IDExpression_1= ruleIDExpression ) (this_RelationalOp_2= ruleRelationalOp (this_IDList_3= ruleIDList | this_IDExpression_4= ruleIDExpression ) )+ ) ;
    public final AntlrDatatypeRuleToken ruleInEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_IDList_0 = null;

        AntlrDatatypeRuleToken this_IDExpression_1 = null;

        AntlrDatatypeRuleToken this_RelationalOp_2 = null;

        AntlrDatatypeRuleToken this_IDList_3 = null;

        AntlrDatatypeRuleToken this_IDExpression_4 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1201:28: ( ( (this_IDList_0= ruleIDList | this_IDExpression_1= ruleIDExpression ) (this_RelationalOp_2= ruleRelationalOp (this_IDList_3= ruleIDList | this_IDExpression_4= ruleIDExpression ) )+ ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1202:1: ( (this_IDList_0= ruleIDList | this_IDExpression_1= ruleIDExpression ) (this_RelationalOp_2= ruleRelationalOp (this_IDList_3= ruleIDList | this_IDExpression_4= ruleIDExpression ) )+ )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1202:1: ( (this_IDList_0= ruleIDList | this_IDExpression_1= ruleIDExpression ) (this_RelationalOp_2= ruleRelationalOp (this_IDList_3= ruleIDList | this_IDExpression_4= ruleIDExpression ) )+ )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1202:2: (this_IDList_0= ruleIDList | this_IDExpression_1= ruleIDExpression ) (this_RelationalOp_2= ruleRelationalOp (this_IDList_3= ruleIDList | this_IDExpression_4= ruleIDExpression ) )+
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1202:2: (this_IDList_0= ruleIDList | this_IDExpression_1= ruleIDExpression )
            int alt30=2;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1203:5: this_IDList_0= ruleIDList
                    {
                     
                            newCompositeNode(grammarAccess.getInEqualityAccess().getIDListParserRuleCall_0_0()); 
                        
                    pushFollow(FOLLOW_ruleIDList_in_ruleInEquality2408);
                    this_IDList_0=ruleIDList();

                    state._fsp--;


                    		current.merge(this_IDList_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1215:5: this_IDExpression_1= ruleIDExpression
                    {
                     
                            newCompositeNode(grammarAccess.getInEqualityAccess().getIDExpressionParserRuleCall_0_1()); 
                        
                    pushFollow(FOLLOW_ruleIDExpression_in_ruleInEquality2441);
                    this_IDExpression_1=ruleIDExpression();

                    state._fsp--;


                    		current.merge(this_IDExpression_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1225:2: (this_RelationalOp_2= ruleRelationalOp (this_IDList_3= ruleIDList | this_IDExpression_4= ruleIDExpression ) )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=RULE_EQOP && LA32_0<=RULE_NEOP)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1226:5: this_RelationalOp_2= ruleRelationalOp (this_IDList_3= ruleIDList | this_IDExpression_4= ruleIDExpression )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getInEqualityAccess().getRelationalOpParserRuleCall_1_0()); 
            	        
            	    pushFollow(FOLLOW_ruleRelationalOp_in_ruleInEquality2470);
            	    this_RelationalOp_2=ruleRelationalOp();

            	    state._fsp--;


            	    		current.merge(this_RelationalOp_2);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1236:1: (this_IDList_3= ruleIDList | this_IDExpression_4= ruleIDExpression )
            	    int alt31=2;
            	    alt31 = dfa31.predict(input);
            	    switch (alt31) {
            	        case 1 :
            	            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1237:5: this_IDList_3= ruleIDList
            	            {
            	             
            	                    newCompositeNode(grammarAccess.getInEqualityAccess().getIDListParserRuleCall_1_1_0()); 
            	                
            	            pushFollow(FOLLOW_ruleIDList_in_ruleInEquality2498);
            	            this_IDList_3=ruleIDList();

            	            state._fsp--;


            	            		current.merge(this_IDList_3);
            	                
            	             
            	                    afterParserOrEnumRuleCall();
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1249:5: this_IDExpression_4= ruleIDExpression
            	            {
            	             
            	                    newCompositeNode(grammarAccess.getInEqualityAccess().getIDExpressionParserRuleCall_1_1_1()); 
            	                
            	            pushFollow(FOLLOW_ruleIDExpression_in_ruleInEquality2531);
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
            	    if ( cnt32 >= 1 ) break loop32;
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1267:1: entryRuleIDList returns [String current=null] : iv_ruleIDList= ruleIDList EOF ;
    public final String entryRuleIDList() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIDList = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1268:2: (iv_ruleIDList= ruleIDList EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1269:2: iv_ruleIDList= ruleIDList EOF
            {
             newCompositeNode(grammarAccess.getIDListRule()); 
            pushFollow(FOLLOW_ruleIDList_in_entryRuleIDList2580);
            iv_ruleIDList=ruleIDList();

            state._fsp--;

             current =iv_ruleIDList.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIDList2591); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1276:1: ruleIDList returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_InEqID_0= ruleInEqID (kw= ',' this_InEqID_2= ruleInEqID )* ) | (kw= '(' this_InEqID_4= ruleInEqID (kw= ',' this_InEqID_6= ruleInEqID )* kw= ')' ) ) ;
    public final AntlrDatatypeRuleToken ruleIDList() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_InEqID_0 = null;

        AntlrDatatypeRuleToken this_InEqID_2 = null;

        AntlrDatatypeRuleToken this_InEqID_4 = null;

        AntlrDatatypeRuleToken this_InEqID_6 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1279:28: ( ( (this_InEqID_0= ruleInEqID (kw= ',' this_InEqID_2= ruleInEqID )* ) | (kw= '(' this_InEqID_4= ruleInEqID (kw= ',' this_InEqID_6= ruleInEqID )* kw= ')' ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1280:1: ( (this_InEqID_0= ruleInEqID (kw= ',' this_InEqID_2= ruleInEqID )* ) | (kw= '(' this_InEqID_4= ruleInEqID (kw= ',' this_InEqID_6= ruleInEqID )* kw= ')' ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1280:1: ( (this_InEqID_0= ruleInEqID (kw= ',' this_InEqID_2= ruleInEqID )* ) | (kw= '(' this_InEqID_4= ruleInEqID (kw= ',' this_InEqID_6= ruleInEqID )* kw= ')' ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID||(LA35_0>=RULE_MINUSOP && LA35_0<=RULE_INT)) ) {
                alt35=1;
            }
            else if ( (LA35_0==32) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1280:2: (this_InEqID_0= ruleInEqID (kw= ',' this_InEqID_2= ruleInEqID )* )
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1280:2: (this_InEqID_0= ruleInEqID (kw= ',' this_InEqID_2= ruleInEqID )* )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1281:5: this_InEqID_0= ruleInEqID (kw= ',' this_InEqID_2= ruleInEqID )*
                    {
                     
                            newCompositeNode(grammarAccess.getIDListAccess().getInEqIDParserRuleCall_0_0()); 
                        
                    pushFollow(FOLLOW_ruleInEqID_in_ruleIDList2639);
                    this_InEqID_0=ruleInEqID();

                    state._fsp--;


                    		current.merge(this_InEqID_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1291:1: (kw= ',' this_InEqID_2= ruleInEqID )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==33) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1292:2: kw= ',' this_InEqID_2= ruleInEqID
                    	    {
                    	    kw=(Token)match(input,33,FOLLOW_33_in_ruleIDList2658); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getIDListAccess().getCommaKeyword_0_1_0()); 
                    	        
                    	     
                    	            newCompositeNode(grammarAccess.getIDListAccess().getInEqIDParserRuleCall_0_1_1()); 
                    	        
                    	    pushFollow(FOLLOW_ruleInEqID_in_ruleIDList2680);
                    	    this_InEqID_2=ruleInEqID();

                    	    state._fsp--;


                    	    		current.merge(this_InEqID_2);
                    	        
                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1309:6: (kw= '(' this_InEqID_4= ruleInEqID (kw= ',' this_InEqID_6= ruleInEqID )* kw= ')' )
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1309:6: (kw= '(' this_InEqID_4= ruleInEqID (kw= ',' this_InEqID_6= ruleInEqID )* kw= ')' )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1310:2: kw= '(' this_InEqID_4= ruleInEqID (kw= ',' this_InEqID_6= ruleInEqID )* kw= ')'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleIDList2708); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getIDListAccess().getLeftParenthesisKeyword_1_0()); 
                        
                     
                            newCompositeNode(grammarAccess.getIDListAccess().getInEqIDParserRuleCall_1_1()); 
                        
                    pushFollow(FOLLOW_ruleInEqID_in_ruleIDList2730);
                    this_InEqID_4=ruleInEqID();

                    state._fsp--;


                    		current.merge(this_InEqID_4);
                        
                     
                            afterParserOrEnumRuleCall();
                        
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1326:1: (kw= ',' this_InEqID_6= ruleInEqID )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==33) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1327:2: kw= ',' this_InEqID_6= ruleInEqID
                    	    {
                    	    kw=(Token)match(input,33,FOLLOW_33_in_ruleIDList2749); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getIDListAccess().getCommaKeyword_1_2_0()); 
                    	        
                    	     
                    	            newCompositeNode(grammarAccess.getIDListAccess().getInEqIDParserRuleCall_1_2_1()); 
                    	        
                    	    pushFollow(FOLLOW_ruleInEqID_in_ruleIDList2771);
                    	    this_InEqID_6=ruleInEqID();

                    	    state._fsp--;


                    	    		current.merge(this_InEqID_6);
                    	        
                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);

                    kw=(Token)match(input,34,FOLLOW_34_in_ruleIDList2791); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1357:1: entryRuleIDExpression returns [String current=null] : iv_ruleIDExpression= ruleIDExpression EOF ;
    public final String entryRuleIDExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIDExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1358:2: (iv_ruleIDExpression= ruleIDExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1359:2: iv_ruleIDExpression= ruleIDExpression EOF
            {
             newCompositeNode(grammarAccess.getIDExpressionRule()); 
            pushFollow(FOLLOW_ruleIDExpression_in_entryRuleIDExpression2833);
            iv_ruleIDExpression=ruleIDExpression();

            state._fsp--;

             current =iv_ruleIDExpression.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIDExpression2844); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1366:1: ruleIDExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_InEqID_0= ruleInEqID ( (this_PlusOp_1= RULE_PLUSOP | this_MinusOp_2= RULE_MINUSOP ) this_InEqID_3= ruleInEqID )+ ) ;
    public final AntlrDatatypeRuleToken ruleIDExpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_PlusOp_1=null;
        Token this_MinusOp_2=null;
        AntlrDatatypeRuleToken this_InEqID_0 = null;

        AntlrDatatypeRuleToken this_InEqID_3 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1369:28: ( (this_InEqID_0= ruleInEqID ( (this_PlusOp_1= RULE_PLUSOP | this_MinusOp_2= RULE_MINUSOP ) this_InEqID_3= ruleInEqID )+ ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1370:1: (this_InEqID_0= ruleInEqID ( (this_PlusOp_1= RULE_PLUSOP | this_MinusOp_2= RULE_MINUSOP ) this_InEqID_3= ruleInEqID )+ )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1370:1: (this_InEqID_0= ruleInEqID ( (this_PlusOp_1= RULE_PLUSOP | this_MinusOp_2= RULE_MINUSOP ) this_InEqID_3= ruleInEqID )+ )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1371:5: this_InEqID_0= ruleInEqID ( (this_PlusOp_1= RULE_PLUSOP | this_MinusOp_2= RULE_MINUSOP ) this_InEqID_3= ruleInEqID )+
            {
             
                    newCompositeNode(grammarAccess.getIDExpressionAccess().getInEqIDParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleInEqID_in_ruleIDExpression2891);
            this_InEqID_0=ruleInEqID();

            state._fsp--;


            		current.merge(this_InEqID_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1381:1: ( (this_PlusOp_1= RULE_PLUSOP | this_MinusOp_2= RULE_MINUSOP ) this_InEqID_3= ruleInEqID )+
            int cnt37=0;
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( ((LA37_0>=RULE_PLUSOP && LA37_0<=RULE_MINUSOP)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1381:2: (this_PlusOp_1= RULE_PLUSOP | this_MinusOp_2= RULE_MINUSOP ) this_InEqID_3= ruleInEqID
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1381:2: (this_PlusOp_1= RULE_PLUSOP | this_MinusOp_2= RULE_MINUSOP )
            	    int alt36=2;
            	    int LA36_0 = input.LA(1);

            	    if ( (LA36_0==RULE_PLUSOP) ) {
            	        alt36=1;
            	    }
            	    else if ( (LA36_0==RULE_MINUSOP) ) {
            	        alt36=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 36, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt36) {
            	        case 1 :
            	            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1381:7: this_PlusOp_1= RULE_PLUSOP
            	            {
            	            this_PlusOp_1=(Token)match(input,RULE_PLUSOP,FOLLOW_RULE_PLUSOP_in_ruleIDExpression2913); 

            	            		current.merge(this_PlusOp_1);
            	                
            	             
            	                newLeafNode(this_PlusOp_1, grammarAccess.getIDExpressionAccess().getPlusOpTerminalRuleCall_1_0_0()); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1389:10: this_MinusOp_2= RULE_MINUSOP
            	            {
            	            this_MinusOp_2=(Token)match(input,RULE_MINUSOP,FOLLOW_RULE_MINUSOP_in_ruleIDExpression2939); 

            	            		current.merge(this_MinusOp_2);
            	                
            	             
            	                newLeafNode(this_MinusOp_2, grammarAccess.getIDExpressionAccess().getMinusOpTerminalRuleCall_1_0_1()); 
            	                

            	            }
            	            break;

            	    }

            	     
            	            newCompositeNode(grammarAccess.getIDExpressionAccess().getInEqIDParserRuleCall_1_1()); 
            	        
            	    pushFollow(FOLLOW_ruleInEqID_in_ruleIDExpression2967);
            	    this_InEqID_3=ruleInEqID();

            	    state._fsp--;


            	    		current.merge(this_InEqID_3);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt37 >= 1 ) break loop37;
                        EarlyExitException eee =
                            new EarlyExitException(37, input);
                        throw eee;
                }
                cnt37++;
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1415:1: entryRuleInEqID returns [String current=null] : iv_ruleInEqID= ruleInEqID EOF ;
    public final String entryRuleInEqID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInEqID = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1416:2: (iv_ruleInEqID= ruleInEqID EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1417:2: iv_ruleInEqID= ruleInEqID EOF
            {
             newCompositeNode(grammarAccess.getInEqIDRule()); 
            pushFollow(FOLLOW_ruleInEqID_in_entryRuleInEqID3015);
            iv_ruleInEqID=ruleInEqID();

            state._fsp--;

             current =iv_ruleInEqID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInEqID3026); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1424:1: ruleInEqID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_MinusOp_0= RULE_MINUSOP )? ( (this_INT_1= RULE_INT )+ | ( (this_INT_2= RULE_INT )* this_ID_3= RULE_ID ) ) ) ;
    public final AntlrDatatypeRuleToken ruleInEqID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_MinusOp_0=null;
        Token this_INT_1=null;
        Token this_INT_2=null;
        Token this_ID_3=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1427:28: ( ( (this_MinusOp_0= RULE_MINUSOP )? ( (this_INT_1= RULE_INT )+ | ( (this_INT_2= RULE_INT )* this_ID_3= RULE_ID ) ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1428:1: ( (this_MinusOp_0= RULE_MINUSOP )? ( (this_INT_1= RULE_INT )+ | ( (this_INT_2= RULE_INT )* this_ID_3= RULE_ID ) ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1428:1: ( (this_MinusOp_0= RULE_MINUSOP )? ( (this_INT_1= RULE_INT )+ | ( (this_INT_2= RULE_INT )* this_ID_3= RULE_ID ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1428:2: (this_MinusOp_0= RULE_MINUSOP )? ( (this_INT_1= RULE_INT )+ | ( (this_INT_2= RULE_INT )* this_ID_3= RULE_ID ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1428:2: (this_MinusOp_0= RULE_MINUSOP )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_MINUSOP) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1428:7: this_MinusOp_0= RULE_MINUSOP
                    {
                    this_MinusOp_0=(Token)match(input,RULE_MINUSOP,FOLLOW_RULE_MINUSOP_in_ruleInEqID3067); 

                    		current.merge(this_MinusOp_0);
                        
                     
                        newLeafNode(this_MinusOp_0, grammarAccess.getInEqIDAccess().getMinusOpTerminalRuleCall_0()); 
                        

                    }
                    break;

            }

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1435:3: ( (this_INT_1= RULE_INT )+ | ( (this_INT_2= RULE_INT )* this_ID_3= RULE_ID ) )
            int alt41=2;
            alt41 = dfa41.predict(input);
            switch (alt41) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1435:4: (this_INT_1= RULE_INT )+
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1435:4: (this_INT_1= RULE_INT )+
                    int cnt39=0;
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==RULE_INT) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1435:9: this_INT_1= RULE_INT
                    	    {
                    	    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleInEqID3091); 

                    	    		current.merge(this_INT_1);
                    	        
                    	     
                    	        newLeafNode(this_INT_1, grammarAccess.getInEqIDAccess().getINTTerminalRuleCall_1_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt39 >= 1 ) break loop39;
                                EarlyExitException eee =
                                    new EarlyExitException(39, input);
                                throw eee;
                        }
                        cnt39++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1443:6: ( (this_INT_2= RULE_INT )* this_ID_3= RULE_ID )
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1443:6: ( (this_INT_2= RULE_INT )* this_ID_3= RULE_ID )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1443:7: (this_INT_2= RULE_INT )* this_ID_3= RULE_ID
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1443:7: (this_INT_2= RULE_INT )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==RULE_INT) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1443:12: this_INT_2= RULE_INT
                    	    {
                    	    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleInEqID3121); 

                    	    		current.merge(this_INT_2);
                    	        
                    	     
                    	        newLeafNode(this_INT_2, grammarAccess.getInEqIDAccess().getINTTerminalRuleCall_1_1_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);

                    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInEqID3143); 

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


    // $ANTLR start "entryRuleAEquation"
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1465:1: entryRuleAEquation returns [EObject current=null] : iv_ruleAEquation= ruleAEquation EOF ;
    public final EObject entryRuleAEquation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAEquation = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1466:2: (iv_ruleAEquation= ruleAEquation EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1467:2: iv_ruleAEquation= ruleAEquation EOF
            {
             newCompositeNode(grammarAccess.getAEquationRule()); 
            pushFollow(FOLLOW_ruleAEquation_in_entryRuleAEquation3190);
            iv_ruleAEquation=ruleAEquation();

            state._fsp--;

             current =iv_ruleAEquation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAEquation3200); 

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
    // $ANTLR end "entryRuleAEquation"


    // $ANTLR start "ruleAEquation"
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1474:1: ruleAEquation returns [EObject current=null] : (this_AStandardEquation_0= ruleAStandardEquation | this_AUseEquation_1= ruleAUseEquation ) ;
    public final EObject ruleAEquation() throws RecognitionException {
        EObject current = null;

        EObject this_AStandardEquation_0 = null;

        EObject this_AUseEquation_1 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1477:28: ( (this_AStandardEquation_0= ruleAStandardEquation | this_AUseEquation_1= ruleAUseEquation ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1478:1: (this_AStandardEquation_0= ruleAStandardEquation | this_AUseEquation_1= ruleAUseEquation )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1478:1: (this_AStandardEquation_0= ruleAStandardEquation | this_AUseEquation_1= ruleAUseEquation )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ID) ) {
                alt42=1;
            }
            else if ( (LA42_0==54) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1479:5: this_AStandardEquation_0= ruleAStandardEquation
                    {
                     
                            newCompositeNode(grammarAccess.getAEquationAccess().getAStandardEquationParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAStandardEquation_in_ruleAEquation3247);
                    this_AStandardEquation_0=ruleAStandardEquation();

                    state._fsp--;

                     
                            current = this_AStandardEquation_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1489:5: this_AUseEquation_1= ruleAUseEquation
                    {
                     
                            newCompositeNode(grammarAccess.getAEquationAccess().getAUseEquationParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleAUseEquation_in_ruleAEquation3274);
                    this_AUseEquation_1=ruleAUseEquation();

                    state._fsp--;

                     
                            current = this_AUseEquation_1; 
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
    // $ANTLR end "ruleAEquation"


    // $ANTLR start "entryRuleAStandardEquation"
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1505:1: entryRuleAStandardEquation returns [EObject current=null] : iv_ruleAStandardEquation= ruleAStandardEquation EOF ;
    public final EObject entryRuleAStandardEquation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAStandardEquation = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1506:2: (iv_ruleAStandardEquation= ruleAStandardEquation EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1507:2: iv_ruleAStandardEquation= ruleAStandardEquation EOF
            {
             newCompositeNode(grammarAccess.getAStandardEquationRule()); 
            pushFollow(FOLLOW_ruleAStandardEquation_in_entryRuleAStandardEquation3309);
            iv_ruleAStandardEquation=ruleAStandardEquation();

            state._fsp--;

             current =iv_ruleAStandardEquation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAStandardEquation3319); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1514:1: ruleAStandardEquation returns [EObject current=null] : ( ( (lv_var_0_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_indexes_2_0= ruleAIndexList ) ) otherlv_3= ']' )? otherlv_4= '=' ( (lv_expr_5_0= ruleAAlphabetsExpression ) ) ) ;
    public final EObject ruleAStandardEquation() throws RecognitionException {
        EObject current = null;

        Token lv_var_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_indexes_2_0 = null;

        EObject lv_expr_5_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1517:28: ( ( ( (lv_var_0_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_indexes_2_0= ruleAIndexList ) ) otherlv_3= ']' )? otherlv_4= '=' ( (lv_expr_5_0= ruleAAlphabetsExpression ) ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1518:1: ( ( (lv_var_0_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_indexes_2_0= ruleAIndexList ) ) otherlv_3= ']' )? otherlv_4= '=' ( (lv_expr_5_0= ruleAAlphabetsExpression ) ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1518:1: ( ( (lv_var_0_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_indexes_2_0= ruleAIndexList ) ) otherlv_3= ']' )? otherlv_4= '=' ( (lv_expr_5_0= ruleAAlphabetsExpression ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1518:2: ( (lv_var_0_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_indexes_2_0= ruleAIndexList ) ) otherlv_3= ']' )? otherlv_4= '=' ( (lv_expr_5_0= ruleAAlphabetsExpression ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1518:2: ( (lv_var_0_0= RULE_ID ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1519:1: (lv_var_0_0= RULE_ID )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1519:1: (lv_var_0_0= RULE_ID )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1520:3: lv_var_0_0= RULE_ID
            {
            lv_var_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAStandardEquation3361); 

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

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1536:2: (otherlv_1= '[' ( (lv_indexes_2_0= ruleAIndexList ) ) otherlv_3= ']' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==51) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1536:4: otherlv_1= '[' ( (lv_indexes_2_0= ruleAIndexList ) ) otherlv_3= ']'
                    {
                    otherlv_1=(Token)match(input,51,FOLLOW_51_in_ruleAStandardEquation3379); 

                        	newLeafNode(otherlv_1, grammarAccess.getAStandardEquationAccess().getLeftSquareBracketKeyword_1_0());
                        
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1540:1: ( (lv_indexes_2_0= ruleAIndexList ) )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1541:1: (lv_indexes_2_0= ruleAIndexList )
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1541:1: (lv_indexes_2_0= ruleAIndexList )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1542:3: lv_indexes_2_0= ruleAIndexList
                    {
                     
                    	        newCompositeNode(grammarAccess.getAStandardEquationAccess().getIndexesAIndexListParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAIndexList_in_ruleAStandardEquation3400);
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

                    otherlv_3=(Token)match(input,52,FOLLOW_52_in_ruleAStandardEquation3412); 

                        	newLeafNode(otherlv_3, grammarAccess.getAStandardEquationAccess().getRightSquareBracketKeyword_1_2());
                        

                    }
                    break;

            }

            otherlv_4=(Token)match(input,53,FOLLOW_53_in_ruleAStandardEquation3426); 

                	newLeafNode(otherlv_4, grammarAccess.getAStandardEquationAccess().getEqualsSignKeyword_2());
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1566:1: ( (lv_expr_5_0= ruleAAlphabetsExpression ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1567:1: (lv_expr_5_0= ruleAAlphabetsExpression )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1567:1: (lv_expr_5_0= ruleAAlphabetsExpression )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1568:3: lv_expr_5_0= ruleAAlphabetsExpression
            {
             
            	        newCompositeNode(grammarAccess.getAStandardEquationAccess().getExprAAlphabetsExpressionParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleAStandardEquation3447);
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


    // $ANTLR start "entryRuleAUseEquation"
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1592:1: entryRuleAUseEquation returns [EObject current=null] : iv_ruleAUseEquation= ruleAUseEquation EOF ;
    public final EObject entryRuleAUseEquation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAUseEquation = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1593:2: (iv_ruleAUseEquation= ruleAUseEquation EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1594:2: iv_ruleAUseEquation= ruleAUseEquation EOF
            {
             newCompositeNode(grammarAccess.getAUseEquationRule()); 
            pushFollow(FOLLOW_ruleAUseEquation_in_entryRuleAUseEquation3483);
            iv_ruleAUseEquation=ruleAUseEquation();

            state._fsp--;

             current =iv_ruleAUseEquation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAUseEquation3493); 

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
    // $ANTLR end "entryRuleAUseEquation"


    // $ANTLR start "ruleAUseEquation"
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1601:1: ruleAUseEquation returns [EObject current=null] : (otherlv_0= 'use' ( (lv_extDom_1_0= ruleADomain ) )? ( (lv_nameSubSys_2_0= RULE_ID ) ) otherlv_3= '[' ( (lv_param_4_0= ruleAIndexAffineExpressionList ) ) otherlv_5= ']' otherlv_6= '(' ( (lv_inputs_7_0= ruleAAlphabetsExpression ) )? (otherlv_8= ',' ( (lv_inputs_9_0= ruleAAlphabetsExpression ) ) )* otherlv_10= ')' otherlv_11= 'returns' otherlv_12= '(' ( (lv_outputs_13_0= ruleAIdentifierList ) ) otherlv_14= ')' ) ;
    public final EObject ruleAUseEquation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_nameSubSys_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        EObject lv_extDom_1_0 = null;

        EObject lv_param_4_0 = null;

        EObject lv_inputs_7_0 = null;

        EObject lv_inputs_9_0 = null;

        EObject lv_outputs_13_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1604:28: ( (otherlv_0= 'use' ( (lv_extDom_1_0= ruleADomain ) )? ( (lv_nameSubSys_2_0= RULE_ID ) ) otherlv_3= '[' ( (lv_param_4_0= ruleAIndexAffineExpressionList ) ) otherlv_5= ']' otherlv_6= '(' ( (lv_inputs_7_0= ruleAAlphabetsExpression ) )? (otherlv_8= ',' ( (lv_inputs_9_0= ruleAAlphabetsExpression ) ) )* otherlv_10= ')' otherlv_11= 'returns' otherlv_12= '(' ( (lv_outputs_13_0= ruleAIdentifierList ) ) otherlv_14= ')' ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1605:1: (otherlv_0= 'use' ( (lv_extDom_1_0= ruleADomain ) )? ( (lv_nameSubSys_2_0= RULE_ID ) ) otherlv_3= '[' ( (lv_param_4_0= ruleAIndexAffineExpressionList ) ) otherlv_5= ']' otherlv_6= '(' ( (lv_inputs_7_0= ruleAAlphabetsExpression ) )? (otherlv_8= ',' ( (lv_inputs_9_0= ruleAAlphabetsExpression ) ) )* otherlv_10= ')' otherlv_11= 'returns' otherlv_12= '(' ( (lv_outputs_13_0= ruleAIdentifierList ) ) otherlv_14= ')' )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1605:1: (otherlv_0= 'use' ( (lv_extDom_1_0= ruleADomain ) )? ( (lv_nameSubSys_2_0= RULE_ID ) ) otherlv_3= '[' ( (lv_param_4_0= ruleAIndexAffineExpressionList ) ) otherlv_5= ']' otherlv_6= '(' ( (lv_inputs_7_0= ruleAAlphabetsExpression ) )? (otherlv_8= ',' ( (lv_inputs_9_0= ruleAAlphabetsExpression ) ) )* otherlv_10= ')' otherlv_11= 'returns' otherlv_12= '(' ( (lv_outputs_13_0= ruleAIdentifierList ) ) otherlv_14= ')' )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1605:3: otherlv_0= 'use' ( (lv_extDom_1_0= ruleADomain ) )? ( (lv_nameSubSys_2_0= RULE_ID ) ) otherlv_3= '[' ( (lv_param_4_0= ruleAIndexAffineExpressionList ) ) otherlv_5= ']' otherlv_6= '(' ( (lv_inputs_7_0= ruleAAlphabetsExpression ) )? (otherlv_8= ',' ( (lv_inputs_9_0= ruleAAlphabetsExpression ) ) )* otherlv_10= ')' otherlv_11= 'returns' otherlv_12= '(' ( (lv_outputs_13_0= ruleAIdentifierList ) ) otherlv_14= ')'
            {
            otherlv_0=(Token)match(input,54,FOLLOW_54_in_ruleAUseEquation3530); 

                	newLeafNode(otherlv_0, grammarAccess.getAUseEquationAccess().getUseKeyword_0());
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1609:1: ( (lv_extDom_1_0= ruleADomain ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==48) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1610:1: (lv_extDom_1_0= ruleADomain )
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1610:1: (lv_extDom_1_0= ruleADomain )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1611:3: lv_extDom_1_0= ruleADomain
                    {
                     
                    	        newCompositeNode(grammarAccess.getAUseEquationAccess().getExtDomADomainParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleADomain_in_ruleAUseEquation3551);
                    lv_extDom_1_0=ruleADomain();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAUseEquationRule());
                    	        }
                           		set(
                           			current, 
                           			"extDom",
                            		lv_extDom_1_0, 
                            		"ADomain");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1627:3: ( (lv_nameSubSys_2_0= RULE_ID ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1628:1: (lv_nameSubSys_2_0= RULE_ID )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1628:1: (lv_nameSubSys_2_0= RULE_ID )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1629:3: lv_nameSubSys_2_0= RULE_ID
            {
            lv_nameSubSys_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAUseEquation3569); 

            			newLeafNode(lv_nameSubSys_2_0, grammarAccess.getAUseEquationAccess().getNameSubSysIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAUseEquationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"nameSubSys",
                    		lv_nameSubSys_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,51,FOLLOW_51_in_ruleAUseEquation3586); 

                	newLeafNode(otherlv_3, grammarAccess.getAUseEquationAccess().getLeftSquareBracketKeyword_3());
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1649:1: ( (lv_param_4_0= ruleAIndexAffineExpressionList ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1650:1: (lv_param_4_0= ruleAIndexAffineExpressionList )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1650:1: (lv_param_4_0= ruleAIndexAffineExpressionList )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1651:3: lv_param_4_0= ruleAIndexAffineExpressionList
            {
             
            	        newCompositeNode(grammarAccess.getAUseEquationAccess().getParamAIndexAffineExpressionListParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleAIndexAffineExpressionList_in_ruleAUseEquation3607);
            lv_param_4_0=ruleAIndexAffineExpressionList();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAUseEquationRule());
            	        }
                   		set(
                   			current, 
                   			"param",
                    		lv_param_4_0, 
                    		"AIndexAffineExpressionList");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,52,FOLLOW_52_in_ruleAUseEquation3619); 

                	newLeafNode(otherlv_5, grammarAccess.getAUseEquationAccess().getRightSquareBracketKeyword_5());
                
            otherlv_6=(Token)match(input,32,FOLLOW_32_in_ruleAUseEquation3631); 

                	newLeafNode(otherlv_6, grammarAccess.getAUseEquationAccess().getLeftParenthesisKeyword_6());
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1675:1: ( (lv_inputs_7_0= ruleAAlphabetsExpression ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_ID||(LA45_0>=RULE_PLUSOP && LA45_0<=RULE_ANDOP)||LA45_0==RULE_MULOP||(LA45_0>=RULE_MINOP && LA45_0<=RULE_REAL)||LA45_0==32||LA45_0==48||LA45_0==51||(LA45_0>=55 && LA45_0<=56)||LA45_0==59||LA45_0==62||LA45_0==64) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1676:1: (lv_inputs_7_0= ruleAAlphabetsExpression )
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1676:1: (lv_inputs_7_0= ruleAAlphabetsExpression )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1677:3: lv_inputs_7_0= ruleAAlphabetsExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getAUseEquationAccess().getInputsAAlphabetsExpressionParserRuleCall_7_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleAUseEquation3652);
                    lv_inputs_7_0=ruleAAlphabetsExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAUseEquationRule());
                    	        }
                           		add(
                           			current, 
                           			"inputs",
                            		lv_inputs_7_0, 
                            		"AAlphabetsExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1693:3: (otherlv_8= ',' ( (lv_inputs_9_0= ruleAAlphabetsExpression ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==33) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1693:5: otherlv_8= ',' ( (lv_inputs_9_0= ruleAAlphabetsExpression ) )
            	    {
            	    otherlv_8=(Token)match(input,33,FOLLOW_33_in_ruleAUseEquation3666); 

            	        	newLeafNode(otherlv_8, grammarAccess.getAUseEquationAccess().getCommaKeyword_8_0());
            	        
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1697:1: ( (lv_inputs_9_0= ruleAAlphabetsExpression ) )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1698:1: (lv_inputs_9_0= ruleAAlphabetsExpression )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1698:1: (lv_inputs_9_0= ruleAAlphabetsExpression )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1699:3: lv_inputs_9_0= ruleAAlphabetsExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAUseEquationAccess().getInputsAAlphabetsExpressionParserRuleCall_8_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleAUseEquation3687);
            	    lv_inputs_9_0=ruleAAlphabetsExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAUseEquationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"inputs",
            	            		lv_inputs_9_0, 
            	            		"AAlphabetsExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            otherlv_10=(Token)match(input,34,FOLLOW_34_in_ruleAUseEquation3701); 

                	newLeafNode(otherlv_10, grammarAccess.getAUseEquationAccess().getRightParenthesisKeyword_9());
                
            otherlv_11=(Token)match(input,44,FOLLOW_44_in_ruleAUseEquation3713); 

                	newLeafNode(otherlv_11, grammarAccess.getAUseEquationAccess().getReturnsKeyword_10());
                
            otherlv_12=(Token)match(input,32,FOLLOW_32_in_ruleAUseEquation3725); 

                	newLeafNode(otherlv_12, grammarAccess.getAUseEquationAccess().getLeftParenthesisKeyword_11());
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1727:1: ( (lv_outputs_13_0= ruleAIdentifierList ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1728:1: (lv_outputs_13_0= ruleAIdentifierList )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1728:1: (lv_outputs_13_0= ruleAIdentifierList )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1729:3: lv_outputs_13_0= ruleAIdentifierList
            {
             
            	        newCompositeNode(grammarAccess.getAUseEquationAccess().getOutputsAIdentifierListParserRuleCall_12_0()); 
            	    
            pushFollow(FOLLOW_ruleAIdentifierList_in_ruleAUseEquation3746);
            lv_outputs_13_0=ruleAIdentifierList();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAUseEquationRule());
            	        }
                   		set(
                   			current, 
                   			"outputs",
                    		lv_outputs_13_0, 
                    		"AIdentifierList");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_14=(Token)match(input,34,FOLLOW_34_in_ruleAUseEquation3758); 

                	newLeafNode(otherlv_14, grammarAccess.getAUseEquationAccess().getRightParenthesisKeyword_13());
                

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
    // $ANTLR end "ruleAUseEquation"


    // $ANTLR start "entryRuleAAlphabetsExpression"
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1757:1: entryRuleAAlphabetsExpression returns [EObject current=null] : iv_ruleAAlphabetsExpression= ruleAAlphabetsExpression EOF ;
    public final EObject entryRuleAAlphabetsExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAAlphabetsExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1758:2: (iv_ruleAAlphabetsExpression= ruleAAlphabetsExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1759:2: iv_ruleAAlphabetsExpression= ruleAAlphabetsExpression EOF
            {
             newCompositeNode(grammarAccess.getAAlphabetsExpressionRule()); 
            pushFollow(FOLLOW_ruleAAlphabetsExpression_in_entryRuleAAlphabetsExpression3794);
            iv_ruleAAlphabetsExpression=ruleAAlphabetsExpression();

            state._fsp--;

             current =iv_ruleAAlphabetsExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAAlphabetsExpression3804); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1766:1: ruleAAlphabetsExpression returns [EObject current=null] : (this_AIfExpression_0= ruleAIfExpression | this_ARestrictExpression_1= ruleARestrictExpression | this_AOrExpression_2= ruleAOrExpression ) ;
    public final EObject ruleAAlphabetsExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AIfExpression_0 = null;

        EObject this_ARestrictExpression_1 = null;

        EObject this_AOrExpression_2 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1769:28: ( (this_AIfExpression_0= ruleAIfExpression | this_ARestrictExpression_1= ruleARestrictExpression | this_AOrExpression_2= ruleAOrExpression ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1770:1: (this_AIfExpression_0= ruleAIfExpression | this_ARestrictExpression_1= ruleARestrictExpression | this_AOrExpression_2= ruleAOrExpression )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1770:1: (this_AIfExpression_0= ruleAIfExpression | this_ARestrictExpression_1= ruleARestrictExpression | this_AOrExpression_2= ruleAOrExpression )
            int alt47=3;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt47=1;
                }
                break;
            case 48:
                {
                alt47=2;
                }
                break;
            case RULE_ID:
            case RULE_PLUSOP:
            case RULE_MINUSOP:
            case RULE_INT:
            case RULE_OROP:
            case RULE_XOROP:
            case RULE_ANDOP:
            case RULE_MULOP:
            case RULE_MINOP:
            case RULE_MAXOP:
            case RULE_BOOLEAN:
            case RULE_REAL:
            case 32:
            case 51:
            case 55:
            case 56:
            case 62:
            case 64:
                {
                alt47=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1771:5: this_AIfExpression_0= ruleAIfExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAAlphabetsExpressionAccess().getAIfExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAIfExpression_in_ruleAAlphabetsExpression3851);
                    this_AIfExpression_0=ruleAIfExpression();

                    state._fsp--;

                     
                            current = this_AIfExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1781:5: this_ARestrictExpression_1= ruleARestrictExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAAlphabetsExpressionAccess().getARestrictExpressionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleARestrictExpression_in_ruleAAlphabetsExpression3878);
                    this_ARestrictExpression_1=ruleARestrictExpression();

                    state._fsp--;

                     
                            current = this_ARestrictExpression_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1791:5: this_AOrExpression_2= ruleAOrExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAAlphabetsExpressionAccess().getAOrExpressionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleAOrExpression_in_ruleAAlphabetsExpression3905);
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1807:1: entryRuleAAlphabetsTerminalExpression returns [EObject current=null] : iv_ruleAAlphabetsTerminalExpression= ruleAAlphabetsTerminalExpression EOF ;
    public final EObject entryRuleAAlphabetsTerminalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAAlphabetsTerminalExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1808:2: (iv_ruleAAlphabetsTerminalExpression= ruleAAlphabetsTerminalExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1809:2: iv_ruleAAlphabetsTerminalExpression= ruleAAlphabetsTerminalExpression EOF
            {
             newCompositeNode(grammarAccess.getAAlphabetsTerminalExpressionRule()); 
            pushFollow(FOLLOW_ruleAAlphabetsTerminalExpression_in_entryRuleAAlphabetsTerminalExpression3940);
            iv_ruleAAlphabetsTerminalExpression=ruleAAlphabetsTerminalExpression();

            state._fsp--;

             current =iv_ruleAAlphabetsTerminalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAAlphabetsTerminalExpression3950); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1816:1: ruleAAlphabetsTerminalExpression returns [EObject current=null] : (this_AParanthesizedAlphabetsExpression_0= ruleAParanthesizedAlphabetsExpression | this_ACaseExpression_1= ruleACaseExpression | this_AReduceExpression_2= ruleAReduceExpression | this_AMultiArgExpression_3= ruleAMultiArgExpression | this_AConstantExpression_4= ruleAConstantExpression | this_AVariableExpression_5= ruleAVariableExpression | this_AIndexExpression_6= ruleAIndexExpression | this_ADependenceExpression_7= ruleADependenceExpression | this_ADependenceInArrayNotation_8= ruleADependenceInArrayNotation ) ;
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
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1819:28: ( (this_AParanthesizedAlphabetsExpression_0= ruleAParanthesizedAlphabetsExpression | this_ACaseExpression_1= ruleACaseExpression | this_AReduceExpression_2= ruleAReduceExpression | this_AMultiArgExpression_3= ruleAMultiArgExpression | this_AConstantExpression_4= ruleAConstantExpression | this_AVariableExpression_5= ruleAVariableExpression | this_AIndexExpression_6= ruleAIndexExpression | this_ADependenceExpression_7= ruleADependenceExpression | this_ADependenceInArrayNotation_8= ruleADependenceInArrayNotation ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1820:1: (this_AParanthesizedAlphabetsExpression_0= ruleAParanthesizedAlphabetsExpression | this_ACaseExpression_1= ruleACaseExpression | this_AReduceExpression_2= ruleAReduceExpression | this_AMultiArgExpression_3= ruleAMultiArgExpression | this_AConstantExpression_4= ruleAConstantExpression | this_AVariableExpression_5= ruleAVariableExpression | this_AIndexExpression_6= ruleAIndexExpression | this_ADependenceExpression_7= ruleADependenceExpression | this_ADependenceInArrayNotation_8= ruleADependenceInArrayNotation )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1820:1: (this_AParanthesizedAlphabetsExpression_0= ruleAParanthesizedAlphabetsExpression | this_ACaseExpression_1= ruleACaseExpression | this_AReduceExpression_2= ruleAReduceExpression | this_AMultiArgExpression_3= ruleAMultiArgExpression | this_AConstantExpression_4= ruleAConstantExpression | this_AVariableExpression_5= ruleAVariableExpression | this_AIndexExpression_6= ruleAIndexExpression | this_ADependenceExpression_7= ruleADependenceExpression | this_ADependenceInArrayNotation_8= ruleADependenceInArrayNotation )
            int alt48=9;
            alt48 = dfa48.predict(input);
            switch (alt48) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1821:5: this_AParanthesizedAlphabetsExpression_0= ruleAParanthesizedAlphabetsExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAAlphabetsTerminalExpressionAccess().getAParanthesizedAlphabetsExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAParanthesizedAlphabetsExpression_in_ruleAAlphabetsTerminalExpression3997);
                    this_AParanthesizedAlphabetsExpression_0=ruleAParanthesizedAlphabetsExpression();

                    state._fsp--;

                     
                            current = this_AParanthesizedAlphabetsExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1831:5: this_ACaseExpression_1= ruleACaseExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAAlphabetsTerminalExpressionAccess().getACaseExpressionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleACaseExpression_in_ruleAAlphabetsTerminalExpression4024);
                    this_ACaseExpression_1=ruleACaseExpression();

                    state._fsp--;

                     
                            current = this_ACaseExpression_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1841:5: this_AReduceExpression_2= ruleAReduceExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAAlphabetsTerminalExpressionAccess().getAReduceExpressionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleAReduceExpression_in_ruleAAlphabetsTerminalExpression4051);
                    this_AReduceExpression_2=ruleAReduceExpression();

                    state._fsp--;

                     
                            current = this_AReduceExpression_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1851:5: this_AMultiArgExpression_3= ruleAMultiArgExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAAlphabetsTerminalExpressionAccess().getAMultiArgExpressionParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleAMultiArgExpression_in_ruleAAlphabetsTerminalExpression4078);
                    this_AMultiArgExpression_3=ruleAMultiArgExpression();

                    state._fsp--;

                     
                            current = this_AMultiArgExpression_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1861:5: this_AConstantExpression_4= ruleAConstantExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAAlphabetsTerminalExpressionAccess().getAConstantExpressionParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleAConstantExpression_in_ruleAAlphabetsTerminalExpression4105);
                    this_AConstantExpression_4=ruleAConstantExpression();

                    state._fsp--;

                     
                            current = this_AConstantExpression_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1871:5: this_AVariableExpression_5= ruleAVariableExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAAlphabetsTerminalExpressionAccess().getAVariableExpressionParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleAVariableExpression_in_ruleAAlphabetsTerminalExpression4132);
                    this_AVariableExpression_5=ruleAVariableExpression();

                    state._fsp--;

                     
                            current = this_AVariableExpression_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1881:5: this_AIndexExpression_6= ruleAIndexExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAAlphabetsTerminalExpressionAccess().getAIndexExpressionParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleAIndexExpression_in_ruleAAlphabetsTerminalExpression4159);
                    this_AIndexExpression_6=ruleAIndexExpression();

                    state._fsp--;

                     
                            current = this_AIndexExpression_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1891:5: this_ADependenceExpression_7= ruleADependenceExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAAlphabetsTerminalExpressionAccess().getADependenceExpressionParserRuleCall_7()); 
                        
                    pushFollow(FOLLOW_ruleADependenceExpression_in_ruleAAlphabetsTerminalExpression4186);
                    this_ADependenceExpression_7=ruleADependenceExpression();

                    state._fsp--;

                     
                            current = this_ADependenceExpression_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1901:5: this_ADependenceInArrayNotation_8= ruleADependenceInArrayNotation
                    {
                     
                            newCompositeNode(grammarAccess.getAAlphabetsTerminalExpressionAccess().getADependenceInArrayNotationParserRuleCall_8()); 
                        
                    pushFollow(FOLLOW_ruleADependenceInArrayNotation_in_ruleAAlphabetsTerminalExpression4213);
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1917:1: entryRuleAParanthesizedAlphabetsExpression returns [EObject current=null] : iv_ruleAParanthesizedAlphabetsExpression= ruleAParanthesizedAlphabetsExpression EOF ;
    public final EObject entryRuleAParanthesizedAlphabetsExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAParanthesizedAlphabetsExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1918:2: (iv_ruleAParanthesizedAlphabetsExpression= ruleAParanthesizedAlphabetsExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1919:2: iv_ruleAParanthesizedAlphabetsExpression= ruleAParanthesizedAlphabetsExpression EOF
            {
             newCompositeNode(grammarAccess.getAParanthesizedAlphabetsExpressionRule()); 
            pushFollow(FOLLOW_ruleAParanthesizedAlphabetsExpression_in_entryRuleAParanthesizedAlphabetsExpression4248);
            iv_ruleAParanthesizedAlphabetsExpression=ruleAParanthesizedAlphabetsExpression();

            state._fsp--;

             current =iv_ruleAParanthesizedAlphabetsExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAParanthesizedAlphabetsExpression4258); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1926:1: ruleAParanthesizedAlphabetsExpression returns [EObject current=null] : (otherlv_0= '(' this_AAlphabetsExpression_1= ruleAAlphabetsExpression otherlv_2= ')' ) ;
    public final EObject ruleAParanthesizedAlphabetsExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_AAlphabetsExpression_1 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1929:28: ( (otherlv_0= '(' this_AAlphabetsExpression_1= ruleAAlphabetsExpression otherlv_2= ')' ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1930:1: (otherlv_0= '(' this_AAlphabetsExpression_1= ruleAAlphabetsExpression otherlv_2= ')' )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1930:1: (otherlv_0= '(' this_AAlphabetsExpression_1= ruleAAlphabetsExpression otherlv_2= ')' )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1930:3: otherlv_0= '(' this_AAlphabetsExpression_1= ruleAAlphabetsExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleAParanthesizedAlphabetsExpression4295); 

                	newLeafNode(otherlv_0, grammarAccess.getAParanthesizedAlphabetsExpressionAccess().getLeftParenthesisKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getAParanthesizedAlphabetsExpressionAccess().getAAlphabetsExpressionParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleAParanthesizedAlphabetsExpression4317);
            this_AAlphabetsExpression_1=ruleAAlphabetsExpression();

            state._fsp--;

             
                    current = this_AAlphabetsExpression_1; 
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleAParanthesizedAlphabetsExpression4328); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1955:1: entryRuleAOrExpression returns [EObject current=null] : iv_ruleAOrExpression= ruleAOrExpression EOF ;
    public final EObject entryRuleAOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAOrExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1956:2: (iv_ruleAOrExpression= ruleAOrExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1957:2: iv_ruleAOrExpression= ruleAOrExpression EOF
            {
             newCompositeNode(grammarAccess.getAOrExpressionRule()); 
            pushFollow(FOLLOW_ruleAOrExpression_in_entryRuleAOrExpression4364);
            iv_ruleAOrExpression=ruleAOrExpression();

            state._fsp--;

             current =iv_ruleAOrExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAOrExpression4374); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1964:1: ruleAOrExpression returns [EObject current=null] : (this_AAndExpression_0= ruleAAndExpression ( () ( ( (lv_operator_2_1= RULE_OROP | lv_operator_2_2= RULE_XOROP ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )* ) ;
    public final EObject ruleAOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_AAndExpression_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1967:28: ( (this_AAndExpression_0= ruleAAndExpression ( () ( ( (lv_operator_2_1= RULE_OROP | lv_operator_2_2= RULE_XOROP ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )* ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1968:1: (this_AAndExpression_0= ruleAAndExpression ( () ( ( (lv_operator_2_1= RULE_OROP | lv_operator_2_2= RULE_XOROP ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )* )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1968:1: (this_AAndExpression_0= ruleAAndExpression ( () ( ( (lv_operator_2_1= RULE_OROP | lv_operator_2_2= RULE_XOROP ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )* )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1969:5: this_AAndExpression_0= ruleAAndExpression ( () ( ( (lv_operator_2_1= RULE_OROP | lv_operator_2_2= RULE_XOROP ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAOrExpressionAccess().getAAndExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleAAndExpression_in_ruleAOrExpression4421);
            this_AAndExpression_0=ruleAAndExpression();

            state._fsp--;

             
                    current = this_AAndExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1977:1: ( () ( ( (lv_operator_2_1= RULE_OROP | lv_operator_2_2= RULE_XOROP ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( ((LA50_0>=RULE_OROP && LA50_0<=RULE_XOROP)) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1977:2: () ( ( (lv_operator_2_1= RULE_OROP | lv_operator_2_2= RULE_XOROP ) ) ) ( (lv_right_3_0= ruleAAndExpression ) )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1977:2: ()
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1978:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getAOrExpressionAccess().getAOrExpressionLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1983:2: ( ( (lv_operator_2_1= RULE_OROP | lv_operator_2_2= RULE_XOROP ) ) )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1984:1: ( (lv_operator_2_1= RULE_OROP | lv_operator_2_2= RULE_XOROP ) )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1984:1: ( (lv_operator_2_1= RULE_OROP | lv_operator_2_2= RULE_XOROP ) )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1985:1: (lv_operator_2_1= RULE_OROP | lv_operator_2_2= RULE_XOROP )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1985:1: (lv_operator_2_1= RULE_OROP | lv_operator_2_2= RULE_XOROP )
            	    int alt49=2;
            	    int LA49_0 = input.LA(1);

            	    if ( (LA49_0==RULE_OROP) ) {
            	        alt49=1;
            	    }
            	    else if ( (LA49_0==RULE_XOROP) ) {
            	        alt49=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 49, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt49) {
            	        case 1 :
            	            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:1986:3: lv_operator_2_1= RULE_OROP
            	            {
            	            lv_operator_2_1=(Token)match(input,RULE_OROP,FOLLOW_RULE_OROP_in_ruleAOrExpression4449); 

            	            			newLeafNode(lv_operator_2_1, grammarAccess.getAOrExpressionAccess().getOperatorOrOpTerminalRuleCall_1_1_0_0()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAOrExpressionRule());
            	            	        }
            	                   		setWithLastConsumed(
            	                   			current, 
            	                   			"operator",
            	                    		lv_operator_2_1, 
            	                    		"OrOp");
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2001:8: lv_operator_2_2= RULE_XOROP
            	            {
            	            lv_operator_2_2=(Token)match(input,RULE_XOROP,FOLLOW_RULE_XOROP_in_ruleAOrExpression4469); 

            	            			newLeafNode(lv_operator_2_2, grammarAccess.getAOrExpressionAccess().getOperatorXorOpTerminalRuleCall_1_1_0_1()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAOrExpressionRule());
            	            	        }
            	                   		setWithLastConsumed(
            	                   			current, 
            	                   			"operator",
            	                    		lv_operator_2_2, 
            	                    		"XorOp");
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2019:2: ( (lv_right_3_0= ruleAAndExpression ) )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2020:1: (lv_right_3_0= ruleAAndExpression )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2020:1: (lv_right_3_0= ruleAAndExpression )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2021:3: lv_right_3_0= ruleAAndExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAOrExpressionAccess().getRightAAndExpressionParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAAndExpression_in_ruleAOrExpression4498);
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
            	    break loop50;
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2045:1: entryRuleAAndExpression returns [EObject current=null] : iv_ruleAAndExpression= ruleAAndExpression EOF ;
    public final EObject entryRuleAAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAAndExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2046:2: (iv_ruleAAndExpression= ruleAAndExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2047:2: iv_ruleAAndExpression= ruleAAndExpression EOF
            {
             newCompositeNode(grammarAccess.getAAndExpressionRule()); 
            pushFollow(FOLLOW_ruleAAndExpression_in_entryRuleAAndExpression4536);
            iv_ruleAAndExpression=ruleAAndExpression();

            state._fsp--;

             current =iv_ruleAAndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAAndExpression4546); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2054:1: ruleAAndExpression returns [EObject current=null] : (this_ARelationalExpression_0= ruleARelationalExpression ( () ( ( (lv_operator_2_1= RULE_ANDOP | lv_operator_2_2= RULE_NANDOP ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )* ) ;
    public final EObject ruleAAndExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_ARelationalExpression_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2057:28: ( (this_ARelationalExpression_0= ruleARelationalExpression ( () ( ( (lv_operator_2_1= RULE_ANDOP | lv_operator_2_2= RULE_NANDOP ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )* ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2058:1: (this_ARelationalExpression_0= ruleARelationalExpression ( () ( ( (lv_operator_2_1= RULE_ANDOP | lv_operator_2_2= RULE_NANDOP ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )* )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2058:1: (this_ARelationalExpression_0= ruleARelationalExpression ( () ( ( (lv_operator_2_1= RULE_ANDOP | lv_operator_2_2= RULE_NANDOP ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )* )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2059:5: this_ARelationalExpression_0= ruleARelationalExpression ( () ( ( (lv_operator_2_1= RULE_ANDOP | lv_operator_2_2= RULE_NANDOP ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAAndExpressionAccess().getARelationalExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleARelationalExpression_in_ruleAAndExpression4593);
            this_ARelationalExpression_0=ruleARelationalExpression();

            state._fsp--;

             
                    current = this_ARelationalExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2067:1: ( () ( ( (lv_operator_2_1= RULE_ANDOP | lv_operator_2_2= RULE_NANDOP ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( ((LA52_0>=RULE_ANDOP && LA52_0<=RULE_NANDOP)) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2067:2: () ( ( (lv_operator_2_1= RULE_ANDOP | lv_operator_2_2= RULE_NANDOP ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2067:2: ()
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2068:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getAAndExpressionAccess().getAAndExpressionLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2073:2: ( ( (lv_operator_2_1= RULE_ANDOP | lv_operator_2_2= RULE_NANDOP ) ) )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2074:1: ( (lv_operator_2_1= RULE_ANDOP | lv_operator_2_2= RULE_NANDOP ) )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2074:1: ( (lv_operator_2_1= RULE_ANDOP | lv_operator_2_2= RULE_NANDOP ) )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2075:1: (lv_operator_2_1= RULE_ANDOP | lv_operator_2_2= RULE_NANDOP )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2075:1: (lv_operator_2_1= RULE_ANDOP | lv_operator_2_2= RULE_NANDOP )
            	    int alt51=2;
            	    int LA51_0 = input.LA(1);

            	    if ( (LA51_0==RULE_ANDOP) ) {
            	        alt51=1;
            	    }
            	    else if ( (LA51_0==RULE_NANDOP) ) {
            	        alt51=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 51, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt51) {
            	        case 1 :
            	            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2076:3: lv_operator_2_1= RULE_ANDOP
            	            {
            	            lv_operator_2_1=(Token)match(input,RULE_ANDOP,FOLLOW_RULE_ANDOP_in_ruleAAndExpression4621); 

            	            			newLeafNode(lv_operator_2_1, grammarAccess.getAAndExpressionAccess().getOperatorAndOpTerminalRuleCall_1_1_0_0()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAAndExpressionRule());
            	            	        }
            	                   		setWithLastConsumed(
            	                   			current, 
            	                   			"operator",
            	                    		lv_operator_2_1, 
            	                    		"AndOp");
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2091:8: lv_operator_2_2= RULE_NANDOP
            	            {
            	            lv_operator_2_2=(Token)match(input,RULE_NANDOP,FOLLOW_RULE_NANDOP_in_ruleAAndExpression4641); 

            	            			newLeafNode(lv_operator_2_2, grammarAccess.getAAndExpressionAccess().getOperatorNandOpTerminalRuleCall_1_1_0_1()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAAndExpressionRule());
            	            	        }
            	                   		setWithLastConsumed(
            	                   			current, 
            	                   			"operator",
            	                    		lv_operator_2_2, 
            	                    		"NandOp");
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2109:2: ( (lv_right_3_0= ruleARelationalExpression ) )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2110:1: (lv_right_3_0= ruleARelationalExpression )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2110:1: (lv_right_3_0= ruleARelationalExpression )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2111:3: lv_right_3_0= ruleARelationalExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAAndExpressionAccess().getRightARelationalExpressionParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleARelationalExpression_in_ruleAAndExpression4670);
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
            	    break loop52;
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2135:1: entryRuleARelationalExpression returns [EObject current=null] : iv_ruleARelationalExpression= ruleARelationalExpression EOF ;
    public final EObject entryRuleARelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleARelationalExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2136:2: (iv_ruleARelationalExpression= ruleARelationalExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2137:2: iv_ruleARelationalExpression= ruleARelationalExpression EOF
            {
             newCompositeNode(grammarAccess.getARelationalExpressionRule()); 
            pushFollow(FOLLOW_ruleARelationalExpression_in_entryRuleARelationalExpression4708);
            iv_ruleARelationalExpression=ruleARelationalExpression();

            state._fsp--;

             current =iv_ruleARelationalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleARelationalExpression4718); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2144:1: ruleARelationalExpression returns [EObject current=null] : (this_AAdditiveExpression_0= ruleAAdditiveExpression ( () ( (lv_operator_2_0= ruleRelationalOp ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )* ) ;
    public final EObject ruleARelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AAdditiveExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2147:28: ( (this_AAdditiveExpression_0= ruleAAdditiveExpression ( () ( (lv_operator_2_0= ruleRelationalOp ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )* ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2148:1: (this_AAdditiveExpression_0= ruleAAdditiveExpression ( () ( (lv_operator_2_0= ruleRelationalOp ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )* )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2148:1: (this_AAdditiveExpression_0= ruleAAdditiveExpression ( () ( (lv_operator_2_0= ruleRelationalOp ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )* )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2149:5: this_AAdditiveExpression_0= ruleAAdditiveExpression ( () ( (lv_operator_2_0= ruleRelationalOp ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getARelationalExpressionAccess().getAAdditiveExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleAAdditiveExpression_in_ruleARelationalExpression4765);
            this_AAdditiveExpression_0=ruleAAdditiveExpression();

            state._fsp--;

             
                    current = this_AAdditiveExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2157:1: ( () ( (lv_operator_2_0= ruleRelationalOp ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( ((LA53_0>=RULE_EQOP && LA53_0<=RULE_NEOP)) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2157:2: () ( (lv_operator_2_0= ruleRelationalOp ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2157:2: ()
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2158:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getARelationalExpressionAccess().getARelationalExpressionLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2163:2: ( (lv_operator_2_0= ruleRelationalOp ) )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2164:1: (lv_operator_2_0= ruleRelationalOp )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2164:1: (lv_operator_2_0= ruleRelationalOp )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2165:3: lv_operator_2_0= ruleRelationalOp
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getARelationalExpressionAccess().getOperatorRelationalOpParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRelationalOp_in_ruleARelationalExpression4795);
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

            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2181:2: ( (lv_right_3_0= ruleAAdditiveExpression ) )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2182:1: (lv_right_3_0= ruleAAdditiveExpression )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2182:1: (lv_right_3_0= ruleAAdditiveExpression )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2183:3: lv_right_3_0= ruleAAdditiveExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getARelationalExpressionAccess().getRightAAdditiveExpressionParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAAdditiveExpression_in_ruleARelationalExpression4816);
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
            	    break loop53;
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2207:1: entryRuleAAdditiveExpression returns [EObject current=null] : iv_ruleAAdditiveExpression= ruleAAdditiveExpression EOF ;
    public final EObject entryRuleAAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAAdditiveExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2208:2: (iv_ruleAAdditiveExpression= ruleAAdditiveExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2209:2: iv_ruleAAdditiveExpression= ruleAAdditiveExpression EOF
            {
             newCompositeNode(grammarAccess.getAAdditiveExpressionRule()); 
            pushFollow(FOLLOW_ruleAAdditiveExpression_in_entryRuleAAdditiveExpression4854);
            iv_ruleAAdditiveExpression=ruleAAdditiveExpression();

            state._fsp--;

             current =iv_ruleAAdditiveExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAAdditiveExpression4864); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2216:1: ruleAAdditiveExpression returns [EObject current=null] : (this_AModuloExpression_0= ruleAModuloExpression ( () ( ( (lv_op_2_1= RULE_PLUSOP | lv_op_2_2= RULE_MINUSOP ) ) ) ( (lv_right_3_0= ruleAModuloExpression ) ) )* ) ;
    public final EObject ruleAAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_AModuloExpression_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2219:28: ( (this_AModuloExpression_0= ruleAModuloExpression ( () ( ( (lv_op_2_1= RULE_PLUSOP | lv_op_2_2= RULE_MINUSOP ) ) ) ( (lv_right_3_0= ruleAModuloExpression ) ) )* ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2220:1: (this_AModuloExpression_0= ruleAModuloExpression ( () ( ( (lv_op_2_1= RULE_PLUSOP | lv_op_2_2= RULE_MINUSOP ) ) ) ( (lv_right_3_0= ruleAModuloExpression ) ) )* )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2220:1: (this_AModuloExpression_0= ruleAModuloExpression ( () ( ( (lv_op_2_1= RULE_PLUSOP | lv_op_2_2= RULE_MINUSOP ) ) ) ( (lv_right_3_0= ruleAModuloExpression ) ) )* )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2221:5: this_AModuloExpression_0= ruleAModuloExpression ( () ( ( (lv_op_2_1= RULE_PLUSOP | lv_op_2_2= RULE_MINUSOP ) ) ) ( (lv_right_3_0= ruleAModuloExpression ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getAModuloExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleAModuloExpression_in_ruleAAdditiveExpression4911);
            this_AModuloExpression_0=ruleAModuloExpression();

            state._fsp--;

             
                    current = this_AModuloExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2229:1: ( () ( ( (lv_op_2_1= RULE_PLUSOP | lv_op_2_2= RULE_MINUSOP ) ) ) ( (lv_right_3_0= ruleAModuloExpression ) ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( ((LA55_0>=RULE_PLUSOP && LA55_0<=RULE_MINUSOP)) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2229:2: () ( ( (lv_op_2_1= RULE_PLUSOP | lv_op_2_2= RULE_MINUSOP ) ) ) ( (lv_right_3_0= ruleAModuloExpression ) )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2229:2: ()
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2230:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getAAdditiveExpressionAccess().getAAdditiveExpressionLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2235:2: ( ( (lv_op_2_1= RULE_PLUSOP | lv_op_2_2= RULE_MINUSOP ) ) )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2236:1: ( (lv_op_2_1= RULE_PLUSOP | lv_op_2_2= RULE_MINUSOP ) )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2236:1: ( (lv_op_2_1= RULE_PLUSOP | lv_op_2_2= RULE_MINUSOP ) )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2237:1: (lv_op_2_1= RULE_PLUSOP | lv_op_2_2= RULE_MINUSOP )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2237:1: (lv_op_2_1= RULE_PLUSOP | lv_op_2_2= RULE_MINUSOP )
            	    int alt54=2;
            	    int LA54_0 = input.LA(1);

            	    if ( (LA54_0==RULE_PLUSOP) ) {
            	        alt54=1;
            	    }
            	    else if ( (LA54_0==RULE_MINUSOP) ) {
            	        alt54=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 54, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt54) {
            	        case 1 :
            	            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2238:3: lv_op_2_1= RULE_PLUSOP
            	            {
            	            lv_op_2_1=(Token)match(input,RULE_PLUSOP,FOLLOW_RULE_PLUSOP_in_ruleAAdditiveExpression4939); 

            	            			newLeafNode(lv_op_2_1, grammarAccess.getAAdditiveExpressionAccess().getOpPlusOpTerminalRuleCall_1_1_0_0()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAAdditiveExpressionRule());
            	            	        }
            	                   		setWithLastConsumed(
            	                   			current, 
            	                   			"op",
            	                    		lv_op_2_1, 
            	                    		"PlusOp");
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2253:8: lv_op_2_2= RULE_MINUSOP
            	            {
            	            lv_op_2_2=(Token)match(input,RULE_MINUSOP,FOLLOW_RULE_MINUSOP_in_ruleAAdditiveExpression4959); 

            	            			newLeafNode(lv_op_2_2, grammarAccess.getAAdditiveExpressionAccess().getOpMinusOpTerminalRuleCall_1_1_0_1()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAAdditiveExpressionRule());
            	            	        }
            	                   		setWithLastConsumed(
            	                   			current, 
            	                   			"op",
            	                    		lv_op_2_2, 
            	                    		"MinusOp");
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2271:2: ( (lv_right_3_0= ruleAModuloExpression ) )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2272:1: (lv_right_3_0= ruleAModuloExpression )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2272:1: (lv_right_3_0= ruleAModuloExpression )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2273:3: lv_right_3_0= ruleAModuloExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getRightAModuloExpressionParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAModuloExpression_in_ruleAAdditiveExpression4988);
            	    lv_right_3_0=ruleAModuloExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAAdditiveExpressionRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"AModuloExpression");
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


    // $ANTLR start "entryRuleAModuloExpression"
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2297:1: entryRuleAModuloExpression returns [EObject current=null] : iv_ruleAModuloExpression= ruleAModuloExpression EOF ;
    public final EObject entryRuleAModuloExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAModuloExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2298:2: (iv_ruleAModuloExpression= ruleAModuloExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2299:2: iv_ruleAModuloExpression= ruleAModuloExpression EOF
            {
             newCompositeNode(grammarAccess.getAModuloExpressionRule()); 
            pushFollow(FOLLOW_ruleAModuloExpression_in_entryRuleAModuloExpression5026);
            iv_ruleAModuloExpression=ruleAModuloExpression();

            state._fsp--;

             current =iv_ruleAModuloExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAModuloExpression5036); 

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
    // $ANTLR end "entryRuleAModuloExpression"


    // $ANTLR start "ruleAModuloExpression"
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2306:1: ruleAModuloExpression returns [EObject current=null] : (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( () ( (lv_op_2_0= RULE_MODOP ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAModuloExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_AMultiplicativeExpression_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2309:28: ( (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( () ( (lv_op_2_0= RULE_MODOP ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )* ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2310:1: (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( () ( (lv_op_2_0= RULE_MODOP ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )* )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2310:1: (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( () ( (lv_op_2_0= RULE_MODOP ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )* )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2311:5: this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( () ( (lv_op_2_0= RULE_MODOP ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAModuloExpressionAccess().getAMultiplicativeExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleAMultiplicativeExpression_in_ruleAModuloExpression5083);
            this_AMultiplicativeExpression_0=ruleAMultiplicativeExpression();

            state._fsp--;

             
                    current = this_AMultiplicativeExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2319:1: ( () ( (lv_op_2_0= RULE_MODOP ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==RULE_MODOP) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2319:2: () ( (lv_op_2_0= RULE_MODOP ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2319:2: ()
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2320:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getAModuloExpressionAccess().getAModuloExpressionLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2325:2: ( (lv_op_2_0= RULE_MODOP ) )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2326:1: (lv_op_2_0= RULE_MODOP )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2326:1: (lv_op_2_0= RULE_MODOP )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2327:3: lv_op_2_0= RULE_MODOP
            	    {
            	    lv_op_2_0=(Token)match(input,RULE_MODOP,FOLLOW_RULE_MODOP_in_ruleAModuloExpression5109); 

            	    			newLeafNode(lv_op_2_0, grammarAccess.getAModuloExpressionAccess().getOpModOpTerminalRuleCall_1_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getAModuloExpressionRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"op",
            	            		lv_op_2_0, 
            	            		"ModOp");
            	    	    

            	    }


            	    }

            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2343:2: ( (lv_right_3_0= ruleAMultiplicativeExpression ) )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2344:1: (lv_right_3_0= ruleAMultiplicativeExpression )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2344:1: (lv_right_3_0= ruleAMultiplicativeExpression )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2345:3: lv_right_3_0= ruleAMultiplicativeExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAModuloExpressionAccess().getRightAMultiplicativeExpressionParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAMultiplicativeExpression_in_ruleAModuloExpression5135);
            	    lv_right_3_0=ruleAMultiplicativeExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAModuloExpressionRule());
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
            	    break loop56;
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
    // $ANTLR end "ruleAModuloExpression"


    // $ANTLR start "entryRuleAMultiplicativeExpression"
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2369:1: entryRuleAMultiplicativeExpression returns [EObject current=null] : iv_ruleAMultiplicativeExpression= ruleAMultiplicativeExpression EOF ;
    public final EObject entryRuleAMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAMultiplicativeExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2370:2: (iv_ruleAMultiplicativeExpression= ruleAMultiplicativeExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2371:2: iv_ruleAMultiplicativeExpression= ruleAMultiplicativeExpression EOF
            {
             newCompositeNode(grammarAccess.getAMultiplicativeExpressionRule()); 
            pushFollow(FOLLOW_ruleAMultiplicativeExpression_in_entryRuleAMultiplicativeExpression5173);
            iv_ruleAMultiplicativeExpression=ruleAMultiplicativeExpression();

            state._fsp--;

             current =iv_ruleAMultiplicativeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAMultiplicativeExpression5183); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2378:1: ruleAMultiplicativeExpression returns [EObject current=null] : (this_AMinMaxExpression_0= ruleAMinMaxExpression ( () ( ( (lv_op_2_1= RULE_MULOP | lv_op_2_2= RULE_DIVOP ) ) ) ( (lv_right_3_0= ruleAMinMaxExpression ) ) )* ) ;
    public final EObject ruleAMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_AMinMaxExpression_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2381:28: ( (this_AMinMaxExpression_0= ruleAMinMaxExpression ( () ( ( (lv_op_2_1= RULE_MULOP | lv_op_2_2= RULE_DIVOP ) ) ) ( (lv_right_3_0= ruleAMinMaxExpression ) ) )* ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2382:1: (this_AMinMaxExpression_0= ruleAMinMaxExpression ( () ( ( (lv_op_2_1= RULE_MULOP | lv_op_2_2= RULE_DIVOP ) ) ) ( (lv_right_3_0= ruleAMinMaxExpression ) ) )* )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2382:1: (this_AMinMaxExpression_0= ruleAMinMaxExpression ( () ( ( (lv_op_2_1= RULE_MULOP | lv_op_2_2= RULE_DIVOP ) ) ) ( (lv_right_3_0= ruleAMinMaxExpression ) ) )* )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2383:5: this_AMinMaxExpression_0= ruleAMinMaxExpression ( () ( ( (lv_op_2_1= RULE_MULOP | lv_op_2_2= RULE_DIVOP ) ) ) ( (lv_right_3_0= ruleAMinMaxExpression ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getAMinMaxExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleAMinMaxExpression_in_ruleAMultiplicativeExpression5230);
            this_AMinMaxExpression_0=ruleAMinMaxExpression();

            state._fsp--;

             
                    current = this_AMinMaxExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2391:1: ( () ( ( (lv_op_2_1= RULE_MULOP | lv_op_2_2= RULE_DIVOP ) ) ) ( (lv_right_3_0= ruleAMinMaxExpression ) ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( ((LA58_0>=RULE_MULOP && LA58_0<=RULE_DIVOP)) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2391:2: () ( ( (lv_op_2_1= RULE_MULOP | lv_op_2_2= RULE_DIVOP ) ) ) ( (lv_right_3_0= ruleAMinMaxExpression ) )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2391:2: ()
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2392:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getAMultiplicativeExpressionAccess().getAMultiplicativeExpressionLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2397:2: ( ( (lv_op_2_1= RULE_MULOP | lv_op_2_2= RULE_DIVOP ) ) )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2398:1: ( (lv_op_2_1= RULE_MULOP | lv_op_2_2= RULE_DIVOP ) )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2398:1: ( (lv_op_2_1= RULE_MULOP | lv_op_2_2= RULE_DIVOP ) )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2399:1: (lv_op_2_1= RULE_MULOP | lv_op_2_2= RULE_DIVOP )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2399:1: (lv_op_2_1= RULE_MULOP | lv_op_2_2= RULE_DIVOP )
            	    int alt57=2;
            	    int LA57_0 = input.LA(1);

            	    if ( (LA57_0==RULE_MULOP) ) {
            	        alt57=1;
            	    }
            	    else if ( (LA57_0==RULE_DIVOP) ) {
            	        alt57=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 57, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt57) {
            	        case 1 :
            	            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2400:3: lv_op_2_1= RULE_MULOP
            	            {
            	            lv_op_2_1=(Token)match(input,RULE_MULOP,FOLLOW_RULE_MULOP_in_ruleAMultiplicativeExpression5258); 

            	            			newLeafNode(lv_op_2_1, grammarAccess.getAMultiplicativeExpressionAccess().getOpMulOpTerminalRuleCall_1_1_0_0()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAMultiplicativeExpressionRule());
            	            	        }
            	                   		setWithLastConsumed(
            	                   			current, 
            	                   			"op",
            	                    		lv_op_2_1, 
            	                    		"MulOp");
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2415:8: lv_op_2_2= RULE_DIVOP
            	            {
            	            lv_op_2_2=(Token)match(input,RULE_DIVOP,FOLLOW_RULE_DIVOP_in_ruleAMultiplicativeExpression5278); 

            	            			newLeafNode(lv_op_2_2, grammarAccess.getAMultiplicativeExpressionAccess().getOpDivOpTerminalRuleCall_1_1_0_1()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAMultiplicativeExpressionRule());
            	            	        }
            	                   		setWithLastConsumed(
            	                   			current, 
            	                   			"op",
            	                    		lv_op_2_2, 
            	                    		"DivOp");
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2433:2: ( (lv_right_3_0= ruleAMinMaxExpression ) )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2434:1: (lv_right_3_0= ruleAMinMaxExpression )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2434:1: (lv_right_3_0= ruleAMinMaxExpression )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2435:3: lv_right_3_0= ruleAMinMaxExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getRightAMinMaxExpressionParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAMinMaxExpression_in_ruleAMultiplicativeExpression5307);
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
            	    break loop58;
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2459:1: entryRuleAMinMaxExpression returns [EObject current=null] : iv_ruleAMinMaxExpression= ruleAMinMaxExpression EOF ;
    public final EObject entryRuleAMinMaxExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAMinMaxExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2460:2: (iv_ruleAMinMaxExpression= ruleAMinMaxExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2461:2: iv_ruleAMinMaxExpression= ruleAMinMaxExpression EOF
            {
             newCompositeNode(grammarAccess.getAMinMaxExpressionRule()); 
            pushFollow(FOLLOW_ruleAMinMaxExpression_in_entryRuleAMinMaxExpression5345);
            iv_ruleAMinMaxExpression=ruleAMinMaxExpression();

            state._fsp--;

             current =iv_ruleAMinMaxExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAMinMaxExpression5355); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2468:1: ruleAMinMaxExpression returns [EObject current=null] : (this_AUnaryOrTerminalExpression_0= ruleAUnaryOrTerminalExpression ( () ( ( (lv_op_2_1= RULE_MINOP | lv_op_2_2= RULE_MAXOP ) ) ) ( (lv_right_3_0= ruleAUnaryOrTerminalExpression ) ) )* ) ;
    public final EObject ruleAMinMaxExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_AUnaryOrTerminalExpression_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2471:28: ( (this_AUnaryOrTerminalExpression_0= ruleAUnaryOrTerminalExpression ( () ( ( (lv_op_2_1= RULE_MINOP | lv_op_2_2= RULE_MAXOP ) ) ) ( (lv_right_3_0= ruleAUnaryOrTerminalExpression ) ) )* ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2472:1: (this_AUnaryOrTerminalExpression_0= ruleAUnaryOrTerminalExpression ( () ( ( (lv_op_2_1= RULE_MINOP | lv_op_2_2= RULE_MAXOP ) ) ) ( (lv_right_3_0= ruleAUnaryOrTerminalExpression ) ) )* )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2472:1: (this_AUnaryOrTerminalExpression_0= ruleAUnaryOrTerminalExpression ( () ( ( (lv_op_2_1= RULE_MINOP | lv_op_2_2= RULE_MAXOP ) ) ) ( (lv_right_3_0= ruleAUnaryOrTerminalExpression ) ) )* )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2473:5: this_AUnaryOrTerminalExpression_0= ruleAUnaryOrTerminalExpression ( () ( ( (lv_op_2_1= RULE_MINOP | lv_op_2_2= RULE_MAXOP ) ) ) ( (lv_right_3_0= ruleAUnaryOrTerminalExpression ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAMinMaxExpressionAccess().getAUnaryOrTerminalExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleAUnaryOrTerminalExpression_in_ruleAMinMaxExpression5402);
            this_AUnaryOrTerminalExpression_0=ruleAUnaryOrTerminalExpression();

            state._fsp--;

             
                    current = this_AUnaryOrTerminalExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2481:1: ( () ( ( (lv_op_2_1= RULE_MINOP | lv_op_2_2= RULE_MAXOP ) ) ) ( (lv_right_3_0= ruleAUnaryOrTerminalExpression ) ) )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( ((LA60_0>=RULE_MINOP && LA60_0<=RULE_MAXOP)) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2481:2: () ( ( (lv_op_2_1= RULE_MINOP | lv_op_2_2= RULE_MAXOP ) ) ) ( (lv_right_3_0= ruleAUnaryOrTerminalExpression ) )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2481:2: ()
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2482:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getAMinMaxExpressionAccess().getAMinMaxExpressionLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2487:2: ( ( (lv_op_2_1= RULE_MINOP | lv_op_2_2= RULE_MAXOP ) ) )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2488:1: ( (lv_op_2_1= RULE_MINOP | lv_op_2_2= RULE_MAXOP ) )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2488:1: ( (lv_op_2_1= RULE_MINOP | lv_op_2_2= RULE_MAXOP ) )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2489:1: (lv_op_2_1= RULE_MINOP | lv_op_2_2= RULE_MAXOP )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2489:1: (lv_op_2_1= RULE_MINOP | lv_op_2_2= RULE_MAXOP )
            	    int alt59=2;
            	    int LA59_0 = input.LA(1);

            	    if ( (LA59_0==RULE_MINOP) ) {
            	        alt59=1;
            	    }
            	    else if ( (LA59_0==RULE_MAXOP) ) {
            	        alt59=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 59, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt59) {
            	        case 1 :
            	            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2490:3: lv_op_2_1= RULE_MINOP
            	            {
            	            lv_op_2_1=(Token)match(input,RULE_MINOP,FOLLOW_RULE_MINOP_in_ruleAMinMaxExpression5430); 

            	            			newLeafNode(lv_op_2_1, grammarAccess.getAMinMaxExpressionAccess().getOpMinOpTerminalRuleCall_1_1_0_0()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAMinMaxExpressionRule());
            	            	        }
            	                   		setWithLastConsumed(
            	                   			current, 
            	                   			"op",
            	                    		lv_op_2_1, 
            	                    		"MinOp");
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2505:8: lv_op_2_2= RULE_MAXOP
            	            {
            	            lv_op_2_2=(Token)match(input,RULE_MAXOP,FOLLOW_RULE_MAXOP_in_ruleAMinMaxExpression5450); 

            	            			newLeafNode(lv_op_2_2, grammarAccess.getAMinMaxExpressionAccess().getOpMaxOpTerminalRuleCall_1_1_0_1()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAMinMaxExpressionRule());
            	            	        }
            	                   		setWithLastConsumed(
            	                   			current, 
            	                   			"op",
            	                    		lv_op_2_2, 
            	                    		"MaxOp");
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2523:2: ( (lv_right_3_0= ruleAUnaryOrTerminalExpression ) )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2524:1: (lv_right_3_0= ruleAUnaryOrTerminalExpression )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2524:1: (lv_right_3_0= ruleAUnaryOrTerminalExpression )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2525:3: lv_right_3_0= ruleAUnaryOrTerminalExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAMinMaxExpressionAccess().getRightAUnaryOrTerminalExpressionParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAUnaryOrTerminalExpression_in_ruleAMinMaxExpression5479);
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
            	    break loop60;
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2549:1: entryRuleAUnaryOrTerminalExpression returns [EObject current=null] : iv_ruleAUnaryOrTerminalExpression= ruleAUnaryOrTerminalExpression EOF ;
    public final EObject entryRuleAUnaryOrTerminalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAUnaryOrTerminalExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2550:2: (iv_ruleAUnaryOrTerminalExpression= ruleAUnaryOrTerminalExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2551:2: iv_ruleAUnaryOrTerminalExpression= ruleAUnaryOrTerminalExpression EOF
            {
             newCompositeNode(grammarAccess.getAUnaryOrTerminalExpressionRule()); 
            pushFollow(FOLLOW_ruleAUnaryOrTerminalExpression_in_entryRuleAUnaryOrTerminalExpression5517);
            iv_ruleAUnaryOrTerminalExpression=ruleAUnaryOrTerminalExpression();

            state._fsp--;

             current =iv_ruleAUnaryOrTerminalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAUnaryOrTerminalExpression5527); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2558:1: ruleAUnaryOrTerminalExpression returns [EObject current=null] : (this_AUnaryExpression_0= ruleAUnaryExpression | this_AAlphabetsTerminalExpression_1= ruleAAlphabetsTerminalExpression ) ;
    public final EObject ruleAUnaryOrTerminalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AUnaryExpression_0 = null;

        EObject this_AAlphabetsTerminalExpression_1 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2561:28: ( (this_AUnaryExpression_0= ruleAUnaryExpression | this_AAlphabetsTerminalExpression_1= ruleAAlphabetsTerminalExpression ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2562:1: (this_AUnaryExpression_0= ruleAUnaryExpression | this_AAlphabetsTerminalExpression_1= ruleAAlphabetsTerminalExpression )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2562:1: (this_AUnaryExpression_0= ruleAUnaryExpression | this_AAlphabetsTerminalExpression_1= ruleAAlphabetsTerminalExpression )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==RULE_MINUSOP||LA61_0==55) ) {
                alt61=1;
            }
            else if ( (LA61_0==RULE_ID||LA61_0==RULE_PLUSOP||(LA61_0>=RULE_INT && LA61_0<=RULE_ANDOP)||LA61_0==RULE_MULOP||(LA61_0>=RULE_MINOP && LA61_0<=RULE_REAL)||LA61_0==32||LA61_0==51||LA61_0==56||LA61_0==62||LA61_0==64) ) {
                alt61=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2563:5: this_AUnaryExpression_0= ruleAUnaryExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAUnaryOrTerminalExpressionAccess().getAUnaryExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAUnaryExpression_in_ruleAUnaryOrTerminalExpression5574);
                    this_AUnaryExpression_0=ruleAUnaryExpression();

                    state._fsp--;

                     
                            current = this_AUnaryExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2573:5: this_AAlphabetsTerminalExpression_1= ruleAAlphabetsTerminalExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAUnaryOrTerminalExpressionAccess().getAAlphabetsTerminalExpressionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleAAlphabetsTerminalExpression_in_ruleAUnaryOrTerminalExpression5601);
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2589:1: entryRuleAUnaryExpression returns [EObject current=null] : iv_ruleAUnaryExpression= ruleAUnaryExpression EOF ;
    public final EObject entryRuleAUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAUnaryExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2590:2: (iv_ruleAUnaryExpression= ruleAUnaryExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2591:2: iv_ruleAUnaryExpression= ruleAUnaryExpression EOF
            {
             newCompositeNode(grammarAccess.getAUnaryExpressionRule()); 
            pushFollow(FOLLOW_ruleAUnaryExpression_in_entryRuleAUnaryExpression5636);
            iv_ruleAUnaryExpression=ruleAUnaryExpression();

            state._fsp--;

             current =iv_ruleAUnaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAUnaryExpression5646); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2598:1: ruleAUnaryExpression returns [EObject current=null] : (this_ANotExpression_0= ruleANotExpression | this_ANegateExpression_1= ruleANegateExpression ) ;
    public final EObject ruleAUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ANotExpression_0 = null;

        EObject this_ANegateExpression_1 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2601:28: ( (this_ANotExpression_0= ruleANotExpression | this_ANegateExpression_1= ruleANegateExpression ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2602:1: (this_ANotExpression_0= ruleANotExpression | this_ANegateExpression_1= ruleANegateExpression )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2602:1: (this_ANotExpression_0= ruleANotExpression | this_ANegateExpression_1= ruleANegateExpression )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==55) ) {
                alt62=1;
            }
            else if ( (LA62_0==RULE_MINUSOP) ) {
                alt62=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2603:5: this_ANotExpression_0= ruleANotExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAUnaryExpressionAccess().getANotExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleANotExpression_in_ruleAUnaryExpression5693);
                    this_ANotExpression_0=ruleANotExpression();

                    state._fsp--;

                     
                            current = this_ANotExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2613:5: this_ANegateExpression_1= ruleANegateExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAUnaryExpressionAccess().getANegateExpressionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleANegateExpression_in_ruleAUnaryExpression5720);
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2629:1: entryRuleANotExpression returns [EObject current=null] : iv_ruleANotExpression= ruleANotExpression EOF ;
    public final EObject entryRuleANotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleANotExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2630:2: (iv_ruleANotExpression= ruleANotExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2631:2: iv_ruleANotExpression= ruleANotExpression EOF
            {
             newCompositeNode(grammarAccess.getANotExpressionRule()); 
            pushFollow(FOLLOW_ruleANotExpression_in_entryRuleANotExpression5755);
            iv_ruleANotExpression=ruleANotExpression();

            state._fsp--;

             current =iv_ruleANotExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleANotExpression5765); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2638:1: ruleANotExpression returns [EObject current=null] : ( ( (lv_op_0_0= 'not' ) ) ( (lv_expr_1_0= ruleAAlphabetsTerminalExpression ) ) ) ;
    public final EObject ruleANotExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_0_0=null;
        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2641:28: ( ( ( (lv_op_0_0= 'not' ) ) ( (lv_expr_1_0= ruleAAlphabetsTerminalExpression ) ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2642:1: ( ( (lv_op_0_0= 'not' ) ) ( (lv_expr_1_0= ruleAAlphabetsTerminalExpression ) ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2642:1: ( ( (lv_op_0_0= 'not' ) ) ( (lv_expr_1_0= ruleAAlphabetsTerminalExpression ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2642:2: ( (lv_op_0_0= 'not' ) ) ( (lv_expr_1_0= ruleAAlphabetsTerminalExpression ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2642:2: ( (lv_op_0_0= 'not' ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2643:1: (lv_op_0_0= 'not' )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2643:1: (lv_op_0_0= 'not' )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2644:3: lv_op_0_0= 'not'
            {
            lv_op_0_0=(Token)match(input,55,FOLLOW_55_in_ruleANotExpression5808); 

                    newLeafNode(lv_op_0_0, grammarAccess.getANotExpressionAccess().getOpNotKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getANotExpressionRule());
            	        }
                   		setWithLastConsumed(current, "op", lv_op_0_0, "not");
            	    

            }


            }

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2657:2: ( (lv_expr_1_0= ruleAAlphabetsTerminalExpression ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2658:1: (lv_expr_1_0= ruleAAlphabetsTerminalExpression )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2658:1: (lv_expr_1_0= ruleAAlphabetsTerminalExpression )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2659:3: lv_expr_1_0= ruleAAlphabetsTerminalExpression
            {
             
            	        newCompositeNode(grammarAccess.getANotExpressionAccess().getExprAAlphabetsTerminalExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleAAlphabetsTerminalExpression_in_ruleANotExpression5842);
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2683:1: entryRuleANegateExpression returns [EObject current=null] : iv_ruleANegateExpression= ruleANegateExpression EOF ;
    public final EObject entryRuleANegateExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleANegateExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2684:2: (iv_ruleANegateExpression= ruleANegateExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2685:2: iv_ruleANegateExpression= ruleANegateExpression EOF
            {
             newCompositeNode(grammarAccess.getANegateExpressionRule()); 
            pushFollow(FOLLOW_ruleANegateExpression_in_entryRuleANegateExpression5878);
            iv_ruleANegateExpression=ruleANegateExpression();

            state._fsp--;

             current =iv_ruleANegateExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleANegateExpression5888); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2692:1: ruleANegateExpression returns [EObject current=null] : ( ( (lv_op_0_0= RULE_MINUSOP ) ) ( (lv_expr_1_0= ruleAAlphabetsTerminalExpression ) ) ) ;
    public final EObject ruleANegateExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_0_0=null;
        EObject lv_expr_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2695:28: ( ( ( (lv_op_0_0= RULE_MINUSOP ) ) ( (lv_expr_1_0= ruleAAlphabetsTerminalExpression ) ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2696:1: ( ( (lv_op_0_0= RULE_MINUSOP ) ) ( (lv_expr_1_0= ruleAAlphabetsTerminalExpression ) ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2696:1: ( ( (lv_op_0_0= RULE_MINUSOP ) ) ( (lv_expr_1_0= ruleAAlphabetsTerminalExpression ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2696:2: ( (lv_op_0_0= RULE_MINUSOP ) ) ( (lv_expr_1_0= ruleAAlphabetsTerminalExpression ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2696:2: ( (lv_op_0_0= RULE_MINUSOP ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2697:1: (lv_op_0_0= RULE_MINUSOP )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2697:1: (lv_op_0_0= RULE_MINUSOP )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2698:3: lv_op_0_0= RULE_MINUSOP
            {
            lv_op_0_0=(Token)match(input,RULE_MINUSOP,FOLLOW_RULE_MINUSOP_in_ruleANegateExpression5930); 

            			newLeafNode(lv_op_0_0, grammarAccess.getANegateExpressionAccess().getOpMinusOpTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getANegateExpressionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"op",
                    		lv_op_0_0, 
                    		"MinusOp");
            	    

            }


            }

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2714:2: ( (lv_expr_1_0= ruleAAlphabetsTerminalExpression ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2715:1: (lv_expr_1_0= ruleAAlphabetsTerminalExpression )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2715:1: (lv_expr_1_0= ruleAAlphabetsTerminalExpression )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2716:3: lv_expr_1_0= ruleAAlphabetsTerminalExpression
            {
             
            	        newCompositeNode(grammarAccess.getANegateExpressionAccess().getExprAAlphabetsTerminalExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleAAlphabetsTerminalExpression_in_ruleANegateExpression5956);
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2740:1: entryRuleACaseExpression returns [EObject current=null] : iv_ruleACaseExpression= ruleACaseExpression EOF ;
    public final EObject entryRuleACaseExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleACaseExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2741:2: (iv_ruleACaseExpression= ruleACaseExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2742:2: iv_ruleACaseExpression= ruleACaseExpression EOF
            {
             newCompositeNode(grammarAccess.getACaseExpressionRule()); 
            pushFollow(FOLLOW_ruleACaseExpression_in_entryRuleACaseExpression5992);
            iv_ruleACaseExpression=ruleACaseExpression();

            state._fsp--;

             current =iv_ruleACaseExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleACaseExpression6002); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2749:1: ruleACaseExpression returns [EObject current=null] : (otherlv_0= 'case' ( ( (lv_exprs_1_0= ruleAAlphabetsExpression ) ) otherlv_2= ';' )+ otherlv_3= 'esac' ) ;
    public final EObject ruleACaseExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_exprs_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2752:28: ( (otherlv_0= 'case' ( ( (lv_exprs_1_0= ruleAAlphabetsExpression ) ) otherlv_2= ';' )+ otherlv_3= 'esac' ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2753:1: (otherlv_0= 'case' ( ( (lv_exprs_1_0= ruleAAlphabetsExpression ) ) otherlv_2= ';' )+ otherlv_3= 'esac' )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2753:1: (otherlv_0= 'case' ( ( (lv_exprs_1_0= ruleAAlphabetsExpression ) ) otherlv_2= ';' )+ otherlv_3= 'esac' )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2753:3: otherlv_0= 'case' ( ( (lv_exprs_1_0= ruleAAlphabetsExpression ) ) otherlv_2= ';' )+ otherlv_3= 'esac'
            {
            otherlv_0=(Token)match(input,56,FOLLOW_56_in_ruleACaseExpression6039); 

                	newLeafNode(otherlv_0, grammarAccess.getACaseExpressionAccess().getCaseKeyword_0());
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2757:1: ( ( (lv_exprs_1_0= ruleAAlphabetsExpression ) ) otherlv_2= ';' )+
            int cnt63=0;
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==RULE_ID||(LA63_0>=RULE_PLUSOP && LA63_0<=RULE_ANDOP)||LA63_0==RULE_MULOP||(LA63_0>=RULE_MINOP && LA63_0<=RULE_REAL)||LA63_0==32||LA63_0==48||LA63_0==51||(LA63_0>=55 && LA63_0<=56)||LA63_0==59||LA63_0==62||LA63_0==64) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2757:2: ( (lv_exprs_1_0= ruleAAlphabetsExpression ) ) otherlv_2= ';'
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2757:2: ( (lv_exprs_1_0= ruleAAlphabetsExpression ) )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2758:1: (lv_exprs_1_0= ruleAAlphabetsExpression )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2758:1: (lv_exprs_1_0= ruleAAlphabetsExpression )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2759:3: lv_exprs_1_0= ruleAAlphabetsExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getACaseExpressionAccess().getExprsAAlphabetsExpressionParserRuleCall_1_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleACaseExpression6061);
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

            	    otherlv_2=(Token)match(input,35,FOLLOW_35_in_ruleACaseExpression6073); 

            	        	newLeafNode(otherlv_2, grammarAccess.getACaseExpressionAccess().getSemicolonKeyword_1_1());
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt63 >= 1 ) break loop63;
                        EarlyExitException eee =
                            new EarlyExitException(63, input);
                        throw eee;
                }
                cnt63++;
            } while (true);

            otherlv_3=(Token)match(input,57,FOLLOW_57_in_ruleACaseExpression6087); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2791:1: entryRuleADependenceExpression returns [EObject current=null] : iv_ruleADependenceExpression= ruleADependenceExpression EOF ;
    public final EObject entryRuleADependenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleADependenceExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2792:2: (iv_ruleADependenceExpression= ruleADependenceExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2793:2: iv_ruleADependenceExpression= ruleADependenceExpression EOF
            {
             newCompositeNode(grammarAccess.getADependenceExpressionRule()); 
            pushFollow(FOLLOW_ruleADependenceExpression_in_entryRuleADependenceExpression6123);
            iv_ruleADependenceExpression=ruleADependenceExpression();

            state._fsp--;

             current =iv_ruleADependenceExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleADependenceExpression6133); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2800:1: ruleADependenceExpression returns [EObject current=null] : ( ( (lv_func_0_0= ruleAFunction ) ) otherlv_1= '@' ( (lv_expr_2_0= ruleAAlphabetsTerminalExpression ) ) ) ;
    public final EObject ruleADependenceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_func_0_0 = null;

        EObject lv_expr_2_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2803:28: ( ( ( (lv_func_0_0= ruleAFunction ) ) otherlv_1= '@' ( (lv_expr_2_0= ruleAAlphabetsTerminalExpression ) ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2804:1: ( ( (lv_func_0_0= ruleAFunction ) ) otherlv_1= '@' ( (lv_expr_2_0= ruleAAlphabetsTerminalExpression ) ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2804:1: ( ( (lv_func_0_0= ruleAFunction ) ) otherlv_1= '@' ( (lv_expr_2_0= ruleAAlphabetsTerminalExpression ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2804:2: ( (lv_func_0_0= ruleAFunction ) ) otherlv_1= '@' ( (lv_expr_2_0= ruleAAlphabetsTerminalExpression ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2804:2: ( (lv_func_0_0= ruleAFunction ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2805:1: (lv_func_0_0= ruleAFunction )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2805:1: (lv_func_0_0= ruleAFunction )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2806:3: lv_func_0_0= ruleAFunction
            {
             
            	        newCompositeNode(grammarAccess.getADependenceExpressionAccess().getFuncAFunctionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleAFunction_in_ruleADependenceExpression6179);
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

            otherlv_1=(Token)match(input,58,FOLLOW_58_in_ruleADependenceExpression6191); 

                	newLeafNode(otherlv_1, grammarAccess.getADependenceExpressionAccess().getCommercialAtKeyword_1());
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2826:1: ( (lv_expr_2_0= ruleAAlphabetsTerminalExpression ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2827:1: (lv_expr_2_0= ruleAAlphabetsTerminalExpression )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2827:1: (lv_expr_2_0= ruleAAlphabetsTerminalExpression )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2828:3: lv_expr_2_0= ruleAAlphabetsTerminalExpression
            {
             
            	        newCompositeNode(grammarAccess.getADependenceExpressionAccess().getExprAAlphabetsTerminalExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleAAlphabetsTerminalExpression_in_ruleADependenceExpression6212);
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2852:1: entryRuleADependenceInArrayNotation returns [EObject current=null] : iv_ruleADependenceInArrayNotation= ruleADependenceInArrayNotation EOF ;
    public final EObject entryRuleADependenceInArrayNotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleADependenceInArrayNotation = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2853:2: (iv_ruleADependenceInArrayNotation= ruleADependenceInArrayNotation EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2854:2: iv_ruleADependenceInArrayNotation= ruleADependenceInArrayNotation EOF
            {
             newCompositeNode(grammarAccess.getADependenceInArrayNotationRule()); 
            pushFollow(FOLLOW_ruleADependenceInArrayNotation_in_entryRuleADependenceInArrayNotation6248);
            iv_ruleADependenceInArrayNotation=ruleADependenceInArrayNotation();

            state._fsp--;

             current =iv_ruleADependenceInArrayNotation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleADependenceInArrayNotation6258); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2861:1: ruleADependenceInArrayNotation returns [EObject current=null] : ( ( (lv_var_0_0= ruleVariableIdentifier ) ) otherlv_1= '[' ( (lv_dep_2_0= ruleAIndexAffineExpressionList ) ) otherlv_3= ']' ) ;
    public final EObject ruleADependenceInArrayNotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_var_0_0 = null;

        EObject lv_dep_2_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2864:28: ( ( ( (lv_var_0_0= ruleVariableIdentifier ) ) otherlv_1= '[' ( (lv_dep_2_0= ruleAIndexAffineExpressionList ) ) otherlv_3= ']' ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2865:1: ( ( (lv_var_0_0= ruleVariableIdentifier ) ) otherlv_1= '[' ( (lv_dep_2_0= ruleAIndexAffineExpressionList ) ) otherlv_3= ']' )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2865:1: ( ( (lv_var_0_0= ruleVariableIdentifier ) ) otherlv_1= '[' ( (lv_dep_2_0= ruleAIndexAffineExpressionList ) ) otherlv_3= ']' )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2865:2: ( (lv_var_0_0= ruleVariableIdentifier ) ) otherlv_1= '[' ( (lv_dep_2_0= ruleAIndexAffineExpressionList ) ) otherlv_3= ']'
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2865:2: ( (lv_var_0_0= ruleVariableIdentifier ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2866:1: (lv_var_0_0= ruleVariableIdentifier )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2866:1: (lv_var_0_0= ruleVariableIdentifier )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2867:3: lv_var_0_0= ruleVariableIdentifier
            {
             
            	        newCompositeNode(grammarAccess.getADependenceInArrayNotationAccess().getVarVariableIdentifierParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleVariableIdentifier_in_ruleADependenceInArrayNotation6304);
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

            otherlv_1=(Token)match(input,51,FOLLOW_51_in_ruleADependenceInArrayNotation6316); 

                	newLeafNode(otherlv_1, grammarAccess.getADependenceInArrayNotationAccess().getLeftSquareBracketKeyword_1());
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2887:1: ( (lv_dep_2_0= ruleAIndexAffineExpressionList ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2888:1: (lv_dep_2_0= ruleAIndexAffineExpressionList )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2888:1: (lv_dep_2_0= ruleAIndexAffineExpressionList )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2889:3: lv_dep_2_0= ruleAIndexAffineExpressionList
            {
             
            	        newCompositeNode(grammarAccess.getADependenceInArrayNotationAccess().getDepAIndexAffineExpressionListParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleAIndexAffineExpressionList_in_ruleADependenceInArrayNotation6337);
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

            otherlv_3=(Token)match(input,52,FOLLOW_52_in_ruleADependenceInArrayNotation6349); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2917:1: entryRuleAIfExpression returns [EObject current=null] : iv_ruleAIfExpression= ruleAIfExpression EOF ;
    public final EObject entryRuleAIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAIfExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2918:2: (iv_ruleAIfExpression= ruleAIfExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2919:2: iv_ruleAIfExpression= ruleAIfExpression EOF
            {
             newCompositeNode(grammarAccess.getAIfExpressionRule()); 
            pushFollow(FOLLOW_ruleAIfExpression_in_entryRuleAIfExpression6385);
            iv_ruleAIfExpression=ruleAIfExpression();

            state._fsp--;

             current =iv_ruleAIfExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAIfExpression6395); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2926:1: ruleAIfExpression returns [EObject current=null] : (otherlv_0= 'if' ( (lv_cond_1_0= ruleAAlphabetsExpression ) ) otherlv_2= 'then' ( (lv_then_3_0= ruleAAlphabetsExpression ) ) otherlv_4= 'else' ( (lv_else_5_0= ruleAAlphabetsExpression ) ) ) ;
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
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2929:28: ( (otherlv_0= 'if' ( (lv_cond_1_0= ruleAAlphabetsExpression ) ) otherlv_2= 'then' ( (lv_then_3_0= ruleAAlphabetsExpression ) ) otherlv_4= 'else' ( (lv_else_5_0= ruleAAlphabetsExpression ) ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2930:1: (otherlv_0= 'if' ( (lv_cond_1_0= ruleAAlphabetsExpression ) ) otherlv_2= 'then' ( (lv_then_3_0= ruleAAlphabetsExpression ) ) otherlv_4= 'else' ( (lv_else_5_0= ruleAAlphabetsExpression ) ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2930:1: (otherlv_0= 'if' ( (lv_cond_1_0= ruleAAlphabetsExpression ) ) otherlv_2= 'then' ( (lv_then_3_0= ruleAAlphabetsExpression ) ) otherlv_4= 'else' ( (lv_else_5_0= ruleAAlphabetsExpression ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2930:3: otherlv_0= 'if' ( (lv_cond_1_0= ruleAAlphabetsExpression ) ) otherlv_2= 'then' ( (lv_then_3_0= ruleAAlphabetsExpression ) ) otherlv_4= 'else' ( (lv_else_5_0= ruleAAlphabetsExpression ) )
            {
            otherlv_0=(Token)match(input,59,FOLLOW_59_in_ruleAIfExpression6432); 

                	newLeafNode(otherlv_0, grammarAccess.getAIfExpressionAccess().getIfKeyword_0());
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2934:1: ( (lv_cond_1_0= ruleAAlphabetsExpression ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2935:1: (lv_cond_1_0= ruleAAlphabetsExpression )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2935:1: (lv_cond_1_0= ruleAAlphabetsExpression )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2936:3: lv_cond_1_0= ruleAAlphabetsExpression
            {
             
            	        newCompositeNode(grammarAccess.getAIfExpressionAccess().getCondAAlphabetsExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleAIfExpression6453);
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

            otherlv_2=(Token)match(input,60,FOLLOW_60_in_ruleAIfExpression6465); 

                	newLeafNode(otherlv_2, grammarAccess.getAIfExpressionAccess().getThenKeyword_2());
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2956:1: ( (lv_then_3_0= ruleAAlphabetsExpression ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2957:1: (lv_then_3_0= ruleAAlphabetsExpression )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2957:1: (lv_then_3_0= ruleAAlphabetsExpression )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2958:3: lv_then_3_0= ruleAAlphabetsExpression
            {
             
            	        newCompositeNode(grammarAccess.getAIfExpressionAccess().getThenAAlphabetsExpressionParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleAIfExpression6486);
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

            otherlv_4=(Token)match(input,61,FOLLOW_61_in_ruleAIfExpression6498); 

                	newLeafNode(otherlv_4, grammarAccess.getAIfExpressionAccess().getElseKeyword_4());
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2978:1: ( (lv_else_5_0= ruleAAlphabetsExpression ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2979:1: (lv_else_5_0= ruleAAlphabetsExpression )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2979:1: (lv_else_5_0= ruleAAlphabetsExpression )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:2980:3: lv_else_5_0= ruleAAlphabetsExpression
            {
             
            	        newCompositeNode(grammarAccess.getAIfExpressionAccess().getElseAAlphabetsExpressionParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleAIfExpression6519);
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3004:1: entryRuleAIndexExpression returns [EObject current=null] : iv_ruleAIndexExpression= ruleAIndexExpression EOF ;
    public final EObject entryRuleAIndexExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAIndexExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3005:2: (iv_ruleAIndexExpression= ruleAIndexExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3006:2: iv_ruleAIndexExpression= ruleAIndexExpression EOF
            {
             newCompositeNode(grammarAccess.getAIndexExpressionRule()); 
            pushFollow(FOLLOW_ruleAIndexExpression_in_entryRuleAIndexExpression6555);
            iv_ruleAIndexExpression=ruleAIndexExpression();

            state._fsp--;

             current =iv_ruleAIndexExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAIndexExpression6565); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3013:1: ruleAIndexExpression returns [EObject current=null] : ( (otherlv_0= '[' ( (lv_func_1_0= ruleIndexAffineExpression ) ) otherlv_2= ']' ) | (otherlv_3= 'val(' ( (lv_indexes_4_0= ruleAIndexList ) ) otherlv_5= '->' ( (lv_func_6_0= ruleIndexAffineExpression ) ) otherlv_7= ')' ) ) ;
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
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3016:28: ( ( (otherlv_0= '[' ( (lv_func_1_0= ruleIndexAffineExpression ) ) otherlv_2= ']' ) | (otherlv_3= 'val(' ( (lv_indexes_4_0= ruleAIndexList ) ) otherlv_5= '->' ( (lv_func_6_0= ruleIndexAffineExpression ) ) otherlv_7= ')' ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3017:1: ( (otherlv_0= '[' ( (lv_func_1_0= ruleIndexAffineExpression ) ) otherlv_2= ']' ) | (otherlv_3= 'val(' ( (lv_indexes_4_0= ruleAIndexList ) ) otherlv_5= '->' ( (lv_func_6_0= ruleIndexAffineExpression ) ) otherlv_7= ')' ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3017:1: ( (otherlv_0= '[' ( (lv_func_1_0= ruleIndexAffineExpression ) ) otherlv_2= ']' ) | (otherlv_3= 'val(' ( (lv_indexes_4_0= ruleAIndexList ) ) otherlv_5= '->' ( (lv_func_6_0= ruleIndexAffineExpression ) ) otherlv_7= ')' ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==51) ) {
                alt64=1;
            }
            else if ( (LA64_0==62) ) {
                alt64=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3017:2: (otherlv_0= '[' ( (lv_func_1_0= ruleIndexAffineExpression ) ) otherlv_2= ']' )
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3017:2: (otherlv_0= '[' ( (lv_func_1_0= ruleIndexAffineExpression ) ) otherlv_2= ']' )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3017:4: otherlv_0= '[' ( (lv_func_1_0= ruleIndexAffineExpression ) ) otherlv_2= ']'
                    {
                    otherlv_0=(Token)match(input,51,FOLLOW_51_in_ruleAIndexExpression6603); 

                        	newLeafNode(otherlv_0, grammarAccess.getAIndexExpressionAccess().getLeftSquareBracketKeyword_0_0());
                        
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3021:1: ( (lv_func_1_0= ruleIndexAffineExpression ) )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3022:1: (lv_func_1_0= ruleIndexAffineExpression )
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3022:1: (lv_func_1_0= ruleIndexAffineExpression )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3023:3: lv_func_1_0= ruleIndexAffineExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getAIndexExpressionAccess().getFuncIndexAffineExpressionParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleIndexAffineExpression_in_ruleAIndexExpression6624);
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

                    otherlv_2=(Token)match(input,52,FOLLOW_52_in_ruleAIndexExpression6636); 

                        	newLeafNode(otherlv_2, grammarAccess.getAIndexExpressionAccess().getRightSquareBracketKeyword_0_2());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3044:6: (otherlv_3= 'val(' ( (lv_indexes_4_0= ruleAIndexList ) ) otherlv_5= '->' ( (lv_func_6_0= ruleIndexAffineExpression ) ) otherlv_7= ')' )
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3044:6: (otherlv_3= 'val(' ( (lv_indexes_4_0= ruleAIndexList ) ) otherlv_5= '->' ( (lv_func_6_0= ruleIndexAffineExpression ) ) otherlv_7= ')' )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3044:8: otherlv_3= 'val(' ( (lv_indexes_4_0= ruleAIndexList ) ) otherlv_5= '->' ( (lv_func_6_0= ruleIndexAffineExpression ) ) otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,62,FOLLOW_62_in_ruleAIndexExpression6656); 

                        	newLeafNode(otherlv_3, grammarAccess.getAIndexExpressionAccess().getValKeyword_1_0());
                        
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3048:1: ( (lv_indexes_4_0= ruleAIndexList ) )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3049:1: (lv_indexes_4_0= ruleAIndexList )
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3049:1: (lv_indexes_4_0= ruleAIndexList )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3050:3: lv_indexes_4_0= ruleAIndexList
                    {
                     
                    	        newCompositeNode(grammarAccess.getAIndexExpressionAccess().getIndexesAIndexListParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAIndexList_in_ruleAIndexExpression6677);
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

                    otherlv_5=(Token)match(input,63,FOLLOW_63_in_ruleAIndexExpression6689); 

                        	newLeafNode(otherlv_5, grammarAccess.getAIndexExpressionAccess().getHyphenMinusGreaterThanSignKeyword_1_2());
                        
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3070:1: ( (lv_func_6_0= ruleIndexAffineExpression ) )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3071:1: (lv_func_6_0= ruleIndexAffineExpression )
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3071:1: (lv_func_6_0= ruleIndexAffineExpression )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3072:3: lv_func_6_0= ruleIndexAffineExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getAIndexExpressionAccess().getFuncIndexAffineExpressionParserRuleCall_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleIndexAffineExpression_in_ruleAIndexExpression6710);
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

                    otherlv_7=(Token)match(input,34,FOLLOW_34_in_ruleAIndexExpression6722); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3100:1: entryRuleAReduceExpression returns [EObject current=null] : iv_ruleAReduceExpression= ruleAReduceExpression EOF ;
    public final EObject entryRuleAReduceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAReduceExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3101:2: (iv_ruleAReduceExpression= ruleAReduceExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3102:2: iv_ruleAReduceExpression= ruleAReduceExpression EOF
            {
             newCompositeNode(grammarAccess.getAReduceExpressionRule()); 
            pushFollow(FOLLOW_ruleAReduceExpression_in_entryRuleAReduceExpression6759);
            iv_ruleAReduceExpression=ruleAReduceExpression();

            state._fsp--;

             current =iv_ruleAReduceExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAReduceExpression6769); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3109:1: ruleAReduceExpression returns [EObject current=null] : (otherlv_0= 'reduce' otherlv_1= '(' ( (lv_op_2_0= ruleReductionOp ) ) otherlv_3= ',' ( ( (lv_projection_4_1= ruleAFunction | lv_projection_4_2= ruleAFunctionInArrayNotation ) ) ) otherlv_5= ',' ( (lv_expr_6_0= ruleAAlphabetsExpression ) ) otherlv_7= ')' ) ;
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
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3112:28: ( (otherlv_0= 'reduce' otherlv_1= '(' ( (lv_op_2_0= ruleReductionOp ) ) otherlv_3= ',' ( ( (lv_projection_4_1= ruleAFunction | lv_projection_4_2= ruleAFunctionInArrayNotation ) ) ) otherlv_5= ',' ( (lv_expr_6_0= ruleAAlphabetsExpression ) ) otherlv_7= ')' ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3113:1: (otherlv_0= 'reduce' otherlv_1= '(' ( (lv_op_2_0= ruleReductionOp ) ) otherlv_3= ',' ( ( (lv_projection_4_1= ruleAFunction | lv_projection_4_2= ruleAFunctionInArrayNotation ) ) ) otherlv_5= ',' ( (lv_expr_6_0= ruleAAlphabetsExpression ) ) otherlv_7= ')' )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3113:1: (otherlv_0= 'reduce' otherlv_1= '(' ( (lv_op_2_0= ruleReductionOp ) ) otherlv_3= ',' ( ( (lv_projection_4_1= ruleAFunction | lv_projection_4_2= ruleAFunctionInArrayNotation ) ) ) otherlv_5= ',' ( (lv_expr_6_0= ruleAAlphabetsExpression ) ) otherlv_7= ')' )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3113:3: otherlv_0= 'reduce' otherlv_1= '(' ( (lv_op_2_0= ruleReductionOp ) ) otherlv_3= ',' ( ( (lv_projection_4_1= ruleAFunction | lv_projection_4_2= ruleAFunctionInArrayNotation ) ) ) otherlv_5= ',' ( (lv_expr_6_0= ruleAAlphabetsExpression ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,64,FOLLOW_64_in_ruleAReduceExpression6806); 

                	newLeafNode(otherlv_0, grammarAccess.getAReduceExpressionAccess().getReduceKeyword_0());
                
            otherlv_1=(Token)match(input,32,FOLLOW_32_in_ruleAReduceExpression6818); 

                	newLeafNode(otherlv_1, grammarAccess.getAReduceExpressionAccess().getLeftParenthesisKeyword_1());
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3121:1: ( (lv_op_2_0= ruleReductionOp ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3122:1: (lv_op_2_0= ruleReductionOp )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3122:1: (lv_op_2_0= ruleReductionOp )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3123:3: lv_op_2_0= ruleReductionOp
            {
             
            	        newCompositeNode(grammarAccess.getAReduceExpressionAccess().getOpReductionOpParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleReductionOp_in_ruleAReduceExpression6839);
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

            otherlv_3=(Token)match(input,33,FOLLOW_33_in_ruleAReduceExpression6851); 

                	newLeafNode(otherlv_3, grammarAccess.getAReduceExpressionAccess().getCommaKeyword_3());
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3143:1: ( ( (lv_projection_4_1= ruleAFunction | lv_projection_4_2= ruleAFunctionInArrayNotation ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3144:1: ( (lv_projection_4_1= ruleAFunction | lv_projection_4_2= ruleAFunctionInArrayNotation ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3144:1: ( (lv_projection_4_1= ruleAFunction | lv_projection_4_2= ruleAFunctionInArrayNotation ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3145:1: (lv_projection_4_1= ruleAFunction | lv_projection_4_2= ruleAFunctionInArrayNotation )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3145:1: (lv_projection_4_1= ruleAFunction | lv_projection_4_2= ruleAFunctionInArrayNotation )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==32) ) {
                alt65=1;
            }
            else if ( (LA65_0==51) ) {
                alt65=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3146:3: lv_projection_4_1= ruleAFunction
                    {
                     
                    	        newCompositeNode(grammarAccess.getAReduceExpressionAccess().getProjectionAFunctionParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAFunction_in_ruleAReduceExpression6874);
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
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3161:8: lv_projection_4_2= ruleAFunctionInArrayNotation
                    {
                     
                    	        newCompositeNode(grammarAccess.getAReduceExpressionAccess().getProjectionAFunctionInArrayNotationParserRuleCall_4_0_1()); 
                    	    
                    pushFollow(FOLLOW_ruleAFunctionInArrayNotation_in_ruleAReduceExpression6893);
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

            otherlv_5=(Token)match(input,33,FOLLOW_33_in_ruleAReduceExpression6908); 

                	newLeafNode(otherlv_5, grammarAccess.getAReduceExpressionAccess().getCommaKeyword_5());
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3183:1: ( (lv_expr_6_0= ruleAAlphabetsExpression ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3184:1: (lv_expr_6_0= ruleAAlphabetsExpression )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3184:1: (lv_expr_6_0= ruleAAlphabetsExpression )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3185:3: lv_expr_6_0= ruleAAlphabetsExpression
            {
             
            	        newCompositeNode(grammarAccess.getAReduceExpressionAccess().getExprAAlphabetsExpressionParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleAReduceExpression6929);
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

            otherlv_7=(Token)match(input,34,FOLLOW_34_in_ruleAReduceExpression6941); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3213:1: entryRuleARestrictExpression returns [EObject current=null] : iv_ruleARestrictExpression= ruleARestrictExpression EOF ;
    public final EObject entryRuleARestrictExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleARestrictExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3214:2: (iv_ruleARestrictExpression= ruleARestrictExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3215:2: iv_ruleARestrictExpression= ruleARestrictExpression EOF
            {
             newCompositeNode(grammarAccess.getARestrictExpressionRule()); 
            pushFollow(FOLLOW_ruleARestrictExpression_in_entryRuleARestrictExpression6977);
            iv_ruleARestrictExpression=ruleARestrictExpression();

            state._fsp--;

             current =iv_ruleARestrictExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleARestrictExpression6987); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3222:1: ruleARestrictExpression returns [EObject current=null] : ( ( (lv_domain_0_0= ruleADomain ) ) otherlv_1= ':' ( (lv_expr_2_0= ruleAAlphabetsExpression ) ) ) ;
    public final EObject ruleARestrictExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_domain_0_0 = null;

        EObject lv_expr_2_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3225:28: ( ( ( (lv_domain_0_0= ruleADomain ) ) otherlv_1= ':' ( (lv_expr_2_0= ruleAAlphabetsExpression ) ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3226:1: ( ( (lv_domain_0_0= ruleADomain ) ) otherlv_1= ':' ( (lv_expr_2_0= ruleAAlphabetsExpression ) ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3226:1: ( ( (lv_domain_0_0= ruleADomain ) ) otherlv_1= ':' ( (lv_expr_2_0= ruleAAlphabetsExpression ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3226:2: ( (lv_domain_0_0= ruleADomain ) ) otherlv_1= ':' ( (lv_expr_2_0= ruleAAlphabetsExpression ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3226:2: ( (lv_domain_0_0= ruleADomain ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3227:1: (lv_domain_0_0= ruleADomain )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3227:1: (lv_domain_0_0= ruleADomain )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3228:3: lv_domain_0_0= ruleADomain
            {
             
            	        newCompositeNode(grammarAccess.getARestrictExpressionAccess().getDomainADomainParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleADomain_in_ruleARestrictExpression7033);
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

            otherlv_1=(Token)match(input,65,FOLLOW_65_in_ruleARestrictExpression7045); 

                	newLeafNode(otherlv_1, grammarAccess.getARestrictExpressionAccess().getColonKeyword_1());
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3248:1: ( (lv_expr_2_0= ruleAAlphabetsExpression ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3249:1: (lv_expr_2_0= ruleAAlphabetsExpression )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3249:1: (lv_expr_2_0= ruleAAlphabetsExpression )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3250:3: lv_expr_2_0= ruleAAlphabetsExpression
            {
             
            	        newCompositeNode(grammarAccess.getARestrictExpressionAccess().getExprAAlphabetsExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleARestrictExpression7066);
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3274:1: entryRuleAVariableExpression returns [EObject current=null] : iv_ruleAVariableExpression= ruleAVariableExpression EOF ;
    public final EObject entryRuleAVariableExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAVariableExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3275:2: (iv_ruleAVariableExpression= ruleAVariableExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3276:2: iv_ruleAVariableExpression= ruleAVariableExpression EOF
            {
             newCompositeNode(grammarAccess.getAVariableExpressionRule()); 
            pushFollow(FOLLOW_ruleAVariableExpression_in_entryRuleAVariableExpression7102);
            iv_ruleAVariableExpression=ruleAVariableExpression();

            state._fsp--;

             current =iv_ruleAVariableExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAVariableExpression7112); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3283:1: ruleAVariableExpression returns [EObject current=null] : ( (lv_var_0_0= ruleVariableIdentifier ) ) ;
    public final EObject ruleAVariableExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_var_0_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3286:28: ( ( (lv_var_0_0= ruleVariableIdentifier ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3287:1: ( (lv_var_0_0= ruleVariableIdentifier ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3287:1: ( (lv_var_0_0= ruleVariableIdentifier ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3288:1: (lv_var_0_0= ruleVariableIdentifier )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3288:1: (lv_var_0_0= ruleVariableIdentifier )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3289:3: lv_var_0_0= ruleVariableIdentifier
            {
             
            	        newCompositeNode(grammarAccess.getAVariableExpressionAccess().getVarVariableIdentifierParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleVariableIdentifier_in_ruleAVariableExpression7157);
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3313:1: entryRuleAConstantExpression returns [EObject current=null] : iv_ruleAConstantExpression= ruleAConstantExpression EOF ;
    public final EObject entryRuleAConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAConstantExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3314:2: (iv_ruleAConstantExpression= ruleAConstantExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3315:2: iv_ruleAConstantExpression= ruleAConstantExpression EOF
            {
             newCompositeNode(grammarAccess.getAConstantExpressionRule()); 
            pushFollow(FOLLOW_ruleAConstantExpression_in_entryRuleAConstantExpression7192);
            iv_ruleAConstantExpression=ruleAConstantExpression();

            state._fsp--;

             current =iv_ruleAConstantExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAConstantExpression7202); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3322:1: ruleAConstantExpression returns [EObject current=null] : (this_ABooleanExpression_0= ruleABooleanExpression | this_ARealExpression_1= ruleARealExpression | this_AIntegerExpression_2= ruleAIntegerExpression ) ;
    public final EObject ruleAConstantExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ABooleanExpression_0 = null;

        EObject this_ARealExpression_1 = null;

        EObject this_AIntegerExpression_2 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3325:28: ( (this_ABooleanExpression_0= ruleABooleanExpression | this_ARealExpression_1= ruleARealExpression | this_AIntegerExpression_2= ruleAIntegerExpression ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3326:1: (this_ABooleanExpression_0= ruleABooleanExpression | this_ARealExpression_1= ruleARealExpression | this_AIntegerExpression_2= ruleAIntegerExpression )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3326:1: (this_ABooleanExpression_0= ruleABooleanExpression | this_ARealExpression_1= ruleARealExpression | this_AIntegerExpression_2= ruleAIntegerExpression )
            int alt66=3;
            switch ( input.LA(1) ) {
            case RULE_BOOLEAN:
                {
                alt66=1;
                }
                break;
            case RULE_REAL:
                {
                alt66=2;
                }
                break;
            case RULE_INT:
                {
                alt66=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3327:5: this_ABooleanExpression_0= ruleABooleanExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAConstantExpressionAccess().getABooleanExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleABooleanExpression_in_ruleAConstantExpression7249);
                    this_ABooleanExpression_0=ruleABooleanExpression();

                    state._fsp--;

                     
                            current = this_ABooleanExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3337:5: this_ARealExpression_1= ruleARealExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAConstantExpressionAccess().getARealExpressionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleARealExpression_in_ruleAConstantExpression7276);
                    this_ARealExpression_1=ruleARealExpression();

                    state._fsp--;

                     
                            current = this_ARealExpression_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3347:5: this_AIntegerExpression_2= ruleAIntegerExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAConstantExpressionAccess().getAIntegerExpressionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleAIntegerExpression_in_ruleAConstantExpression7303);
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3363:1: entryRuleABooleanExpression returns [EObject current=null] : iv_ruleABooleanExpression= ruleABooleanExpression EOF ;
    public final EObject entryRuleABooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleABooleanExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3364:2: (iv_ruleABooleanExpression= ruleABooleanExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3365:2: iv_ruleABooleanExpression= ruleABooleanExpression EOF
            {
             newCompositeNode(grammarAccess.getABooleanExpressionRule()); 
            pushFollow(FOLLOW_ruleABooleanExpression_in_entryRuleABooleanExpression7338);
            iv_ruleABooleanExpression=ruleABooleanExpression();

            state._fsp--;

             current =iv_ruleABooleanExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleABooleanExpression7348); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3372:1: ruleABooleanExpression returns [EObject current=null] : ( (lv_value_0_0= RULE_BOOLEAN ) ) ;
    public final EObject ruleABooleanExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3375:28: ( ( (lv_value_0_0= RULE_BOOLEAN ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3376:1: ( (lv_value_0_0= RULE_BOOLEAN ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3376:1: ( (lv_value_0_0= RULE_BOOLEAN ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3377:1: (lv_value_0_0= RULE_BOOLEAN )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3377:1: (lv_value_0_0= RULE_BOOLEAN )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3378:3: lv_value_0_0= RULE_BOOLEAN
            {
            lv_value_0_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_RULE_BOOLEAN_in_ruleABooleanExpression7389); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3402:1: entryRuleAIntegerExpression returns [EObject current=null] : iv_ruleAIntegerExpression= ruleAIntegerExpression EOF ;
    public final EObject entryRuleAIntegerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAIntegerExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3403:2: (iv_ruleAIntegerExpression= ruleAIntegerExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3404:2: iv_ruleAIntegerExpression= ruleAIntegerExpression EOF
            {
             newCompositeNode(grammarAccess.getAIntegerExpressionRule()); 
            pushFollow(FOLLOW_ruleAIntegerExpression_in_entryRuleAIntegerExpression7429);
            iv_ruleAIntegerExpression=ruleAIntegerExpression();

            state._fsp--;

             current =iv_ruleAIntegerExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAIntegerExpression7439); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3411:1: ruleAIntegerExpression returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleAIntegerExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3414:28: ( ( (lv_value_0_0= RULE_INT ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3415:1: ( (lv_value_0_0= RULE_INT ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3415:1: ( (lv_value_0_0= RULE_INT ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3416:1: (lv_value_0_0= RULE_INT )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3416:1: (lv_value_0_0= RULE_INT )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3417:3: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAIntegerExpression7480); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3441:1: entryRuleARealExpression returns [EObject current=null] : iv_ruleARealExpression= ruleARealExpression EOF ;
    public final EObject entryRuleARealExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleARealExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3442:2: (iv_ruleARealExpression= ruleARealExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3443:2: iv_ruleARealExpression= ruleARealExpression EOF
            {
             newCompositeNode(grammarAccess.getARealExpressionRule()); 
            pushFollow(FOLLOW_ruleARealExpression_in_entryRuleARealExpression7520);
            iv_ruleARealExpression=ruleARealExpression();

            state._fsp--;

             current =iv_ruleARealExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleARealExpression7530); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3450:1: ruleARealExpression returns [EObject current=null] : ( (lv_value_0_0= RULE_REAL ) ) ;
    public final EObject ruleARealExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3453:28: ( ( (lv_value_0_0= RULE_REAL ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3454:1: ( (lv_value_0_0= RULE_REAL ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3454:1: ( (lv_value_0_0= RULE_REAL ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3455:1: (lv_value_0_0= RULE_REAL )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3455:1: (lv_value_0_0= RULE_REAL )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3456:3: lv_value_0_0= RULE_REAL
            {
            lv_value_0_0=(Token)match(input,RULE_REAL,FOLLOW_RULE_REAL_in_ruleARealExpression7571); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3480:1: entryRuleAMultiArgExpression returns [EObject current=null] : iv_ruleAMultiArgExpression= ruleAMultiArgExpression EOF ;
    public final EObject entryRuleAMultiArgExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAMultiArgExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3481:2: (iv_ruleAMultiArgExpression= ruleAMultiArgExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3482:2: iv_ruleAMultiArgExpression= ruleAMultiArgExpression EOF
            {
             newCompositeNode(grammarAccess.getAMultiArgExpressionRule()); 
            pushFollow(FOLLOW_ruleAMultiArgExpression_in_entryRuleAMultiArgExpression7611);
            iv_ruleAMultiArgExpression=ruleAMultiArgExpression();

            state._fsp--;

             current =iv_ruleAMultiArgExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAMultiArgExpression7621); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3489:1: ruleAMultiArgExpression returns [EObject current=null] : (this_AMultiArgArithmeticExpression_0= ruleAMultiArgArithmeticExpression | this_AMultiArgLogicalExpression_1= ruleAMultiArgLogicalExpression | this_AExternalFunctionCall_2= ruleAExternalFunctionCall ) ;
    public final EObject ruleAMultiArgExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AMultiArgArithmeticExpression_0 = null;

        EObject this_AMultiArgLogicalExpression_1 = null;

        EObject this_AExternalFunctionCall_2 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3492:28: ( (this_AMultiArgArithmeticExpression_0= ruleAMultiArgArithmeticExpression | this_AMultiArgLogicalExpression_1= ruleAMultiArgLogicalExpression | this_AExternalFunctionCall_2= ruleAExternalFunctionCall ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3493:1: (this_AMultiArgArithmeticExpression_0= ruleAMultiArgArithmeticExpression | this_AMultiArgLogicalExpression_1= ruleAMultiArgLogicalExpression | this_AExternalFunctionCall_2= ruleAExternalFunctionCall )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3493:1: (this_AMultiArgArithmeticExpression_0= ruleAMultiArgArithmeticExpression | this_AMultiArgLogicalExpression_1= ruleAMultiArgLogicalExpression | this_AExternalFunctionCall_2= ruleAExternalFunctionCall )
            int alt67=3;
            switch ( input.LA(1) ) {
            case RULE_PLUSOP:
            case RULE_MULOP:
            case RULE_MINOP:
            case RULE_MAXOP:
                {
                alt67=1;
                }
                break;
            case RULE_OROP:
            case RULE_XOROP:
            case RULE_ANDOP:
                {
                alt67=2;
                }
                break;
            case RULE_ID:
                {
                alt67=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }

            switch (alt67) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3494:5: this_AMultiArgArithmeticExpression_0= ruleAMultiArgArithmeticExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAMultiArgExpressionAccess().getAMultiArgArithmeticExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAMultiArgArithmeticExpression_in_ruleAMultiArgExpression7668);
                    this_AMultiArgArithmeticExpression_0=ruleAMultiArgArithmeticExpression();

                    state._fsp--;

                     
                            current = this_AMultiArgArithmeticExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3504:5: this_AMultiArgLogicalExpression_1= ruleAMultiArgLogicalExpression
                    {
                     
                            newCompositeNode(grammarAccess.getAMultiArgExpressionAccess().getAMultiArgLogicalExpressionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleAMultiArgLogicalExpression_in_ruleAMultiArgExpression7695);
                    this_AMultiArgLogicalExpression_1=ruleAMultiArgLogicalExpression();

                    state._fsp--;

                     
                            current = this_AMultiArgLogicalExpression_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3514:5: this_AExternalFunctionCall_2= ruleAExternalFunctionCall
                    {
                     
                            newCompositeNode(grammarAccess.getAMultiArgExpressionAccess().getAExternalFunctionCallParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleAExternalFunctionCall_in_ruleAMultiArgExpression7722);
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3530:1: entryRuleAMultiArgArithmeticExpression returns [EObject current=null] : iv_ruleAMultiArgArithmeticExpression= ruleAMultiArgArithmeticExpression EOF ;
    public final EObject entryRuleAMultiArgArithmeticExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAMultiArgArithmeticExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3531:2: (iv_ruleAMultiArgArithmeticExpression= ruleAMultiArgArithmeticExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3532:2: iv_ruleAMultiArgArithmeticExpression= ruleAMultiArgArithmeticExpression EOF
            {
             newCompositeNode(grammarAccess.getAMultiArgArithmeticExpressionRule()); 
            pushFollow(FOLLOW_ruleAMultiArgArithmeticExpression_in_entryRuleAMultiArgArithmeticExpression7757);
            iv_ruleAMultiArgArithmeticExpression=ruleAMultiArgArithmeticExpression();

            state._fsp--;

             current =iv_ruleAMultiArgArithmeticExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAMultiArgArithmeticExpression7767); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3539:1: ruleAMultiArgArithmeticExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleArithmeticOp ) ) otherlv_1= '(' ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )+ otherlv_5= ')' ) ;
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
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3542:28: ( ( ( (lv_op_0_0= ruleArithmeticOp ) ) otherlv_1= '(' ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )+ otherlv_5= ')' ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3543:1: ( ( (lv_op_0_0= ruleArithmeticOp ) ) otherlv_1= '(' ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )+ otherlv_5= ')' )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3543:1: ( ( (lv_op_0_0= ruleArithmeticOp ) ) otherlv_1= '(' ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )+ otherlv_5= ')' )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3543:2: ( (lv_op_0_0= ruleArithmeticOp ) ) otherlv_1= '(' ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )+ otherlv_5= ')'
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3543:2: ( (lv_op_0_0= ruleArithmeticOp ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3544:1: (lv_op_0_0= ruleArithmeticOp )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3544:1: (lv_op_0_0= ruleArithmeticOp )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3545:3: lv_op_0_0= ruleArithmeticOp
            {
             
            	        newCompositeNode(grammarAccess.getAMultiArgArithmeticExpressionAccess().getOpArithmeticOpParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleArithmeticOp_in_ruleAMultiArgArithmeticExpression7813);
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

            otherlv_1=(Token)match(input,32,FOLLOW_32_in_ruleAMultiArgArithmeticExpression7825); 

                	newLeafNode(otherlv_1, grammarAccess.getAMultiArgArithmeticExpressionAccess().getLeftParenthesisKeyword_1());
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3565:1: ( (lv_exprs_2_0= ruleAAlphabetsExpression ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3566:1: (lv_exprs_2_0= ruleAAlphabetsExpression )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3566:1: (lv_exprs_2_0= ruleAAlphabetsExpression )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3567:3: lv_exprs_2_0= ruleAAlphabetsExpression
            {
             
            	        newCompositeNode(grammarAccess.getAMultiArgArithmeticExpressionAccess().getExprsAAlphabetsExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleAMultiArgArithmeticExpression7846);
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

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3583:2: (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )+
            int cnt68=0;
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==33) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3583:4: otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) )
            	    {
            	    otherlv_3=(Token)match(input,33,FOLLOW_33_in_ruleAMultiArgArithmeticExpression7859); 

            	        	newLeafNode(otherlv_3, grammarAccess.getAMultiArgArithmeticExpressionAccess().getCommaKeyword_3_0());
            	        
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3587:1: ( (lv_exprs_4_0= ruleAAlphabetsExpression ) )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3588:1: (lv_exprs_4_0= ruleAAlphabetsExpression )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3588:1: (lv_exprs_4_0= ruleAAlphabetsExpression )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3589:3: lv_exprs_4_0= ruleAAlphabetsExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAMultiArgArithmeticExpressionAccess().getExprsAAlphabetsExpressionParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleAMultiArgArithmeticExpression7880);
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
            	    if ( cnt68 >= 1 ) break loop68;
                        EarlyExitException eee =
                            new EarlyExitException(68, input);
                        throw eee;
                }
                cnt68++;
            } while (true);

            otherlv_5=(Token)match(input,34,FOLLOW_34_in_ruleAMultiArgArithmeticExpression7894); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3617:1: entryRuleAMultiArgLogicalExpression returns [EObject current=null] : iv_ruleAMultiArgLogicalExpression= ruleAMultiArgLogicalExpression EOF ;
    public final EObject entryRuleAMultiArgLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAMultiArgLogicalExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3618:2: (iv_ruleAMultiArgLogicalExpression= ruleAMultiArgLogicalExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3619:2: iv_ruleAMultiArgLogicalExpression= ruleAMultiArgLogicalExpression EOF
            {
             newCompositeNode(grammarAccess.getAMultiArgLogicalExpressionRule()); 
            pushFollow(FOLLOW_ruleAMultiArgLogicalExpression_in_entryRuleAMultiArgLogicalExpression7930);
            iv_ruleAMultiArgLogicalExpression=ruleAMultiArgLogicalExpression();

            state._fsp--;

             current =iv_ruleAMultiArgLogicalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAMultiArgLogicalExpression7940); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3626:1: ruleAMultiArgLogicalExpression returns [EObject current=null] : ( ( (lv_op_0_0= ruleLogicalOp ) ) otherlv_1= '(' ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )+ otherlv_5= ')' ) ;
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
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3629:28: ( ( ( (lv_op_0_0= ruleLogicalOp ) ) otherlv_1= '(' ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )+ otherlv_5= ')' ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3630:1: ( ( (lv_op_0_0= ruleLogicalOp ) ) otherlv_1= '(' ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )+ otherlv_5= ')' )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3630:1: ( ( (lv_op_0_0= ruleLogicalOp ) ) otherlv_1= '(' ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )+ otherlv_5= ')' )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3630:2: ( (lv_op_0_0= ruleLogicalOp ) ) otherlv_1= '(' ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )+ otherlv_5= ')'
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3630:2: ( (lv_op_0_0= ruleLogicalOp ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3631:1: (lv_op_0_0= ruleLogicalOp )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3631:1: (lv_op_0_0= ruleLogicalOp )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3632:3: lv_op_0_0= ruleLogicalOp
            {
             
            	        newCompositeNode(grammarAccess.getAMultiArgLogicalExpressionAccess().getOpLogicalOpParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleLogicalOp_in_ruleAMultiArgLogicalExpression7986);
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

            otherlv_1=(Token)match(input,32,FOLLOW_32_in_ruleAMultiArgLogicalExpression7998); 

                	newLeafNode(otherlv_1, grammarAccess.getAMultiArgLogicalExpressionAccess().getLeftParenthesisKeyword_1());
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3652:1: ( (lv_exprs_2_0= ruleAAlphabetsExpression ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3653:1: (lv_exprs_2_0= ruleAAlphabetsExpression )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3653:1: (lv_exprs_2_0= ruleAAlphabetsExpression )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3654:3: lv_exprs_2_0= ruleAAlphabetsExpression
            {
             
            	        newCompositeNode(grammarAccess.getAMultiArgLogicalExpressionAccess().getExprsAAlphabetsExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleAMultiArgLogicalExpression8019);
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

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3670:2: (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )+
            int cnt69=0;
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==33) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3670:4: otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) )
            	    {
            	    otherlv_3=(Token)match(input,33,FOLLOW_33_in_ruleAMultiArgLogicalExpression8032); 

            	        	newLeafNode(otherlv_3, grammarAccess.getAMultiArgLogicalExpressionAccess().getCommaKeyword_3_0());
            	        
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3674:1: ( (lv_exprs_4_0= ruleAAlphabetsExpression ) )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3675:1: (lv_exprs_4_0= ruleAAlphabetsExpression )
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3675:1: (lv_exprs_4_0= ruleAAlphabetsExpression )
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3676:3: lv_exprs_4_0= ruleAAlphabetsExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAMultiArgLogicalExpressionAccess().getExprsAAlphabetsExpressionParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleAMultiArgLogicalExpression8053);
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
            	    if ( cnt69 >= 1 ) break loop69;
                        EarlyExitException eee =
                            new EarlyExitException(69, input);
                        throw eee;
                }
                cnt69++;
            } while (true);

            otherlv_5=(Token)match(input,34,FOLLOW_34_in_ruleAMultiArgLogicalExpression8067); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3704:1: entryRuleAExternalFunctionCall returns [EObject current=null] : iv_ruleAExternalFunctionCall= ruleAExternalFunctionCall EOF ;
    public final EObject entryRuleAExternalFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAExternalFunctionCall = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3705:2: (iv_ruleAExternalFunctionCall= ruleAExternalFunctionCall EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3706:2: iv_ruleAExternalFunctionCall= ruleAExternalFunctionCall EOF
            {
             newCompositeNode(grammarAccess.getAExternalFunctionCallRule()); 
            pushFollow(FOLLOW_ruleAExternalFunctionCall_in_entryRuleAExternalFunctionCall8103);
            iv_ruleAExternalFunctionCall=ruleAExternalFunctionCall();

            state._fsp--;

             current =iv_ruleAExternalFunctionCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAExternalFunctionCall8113); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3713:1: ruleAExternalFunctionCall returns [EObject current=null] : ( ( (lv_func_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )* )? otherlv_5= ')' ) ;
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
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3716:28: ( ( ( (lv_func_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )* )? otherlv_5= ')' ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3717:1: ( ( (lv_func_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )* )? otherlv_5= ')' )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3717:1: ( ( (lv_func_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )* )? otherlv_5= ')' )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3717:2: ( (lv_func_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )* )? otherlv_5= ')'
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3717:2: ( (lv_func_0_0= RULE_ID ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3718:1: (lv_func_0_0= RULE_ID )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3718:1: (lv_func_0_0= RULE_ID )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3719:3: lv_func_0_0= RULE_ID
            {
            lv_func_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAExternalFunctionCall8155); 

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

            otherlv_1=(Token)match(input,32,FOLLOW_32_in_ruleAExternalFunctionCall8172); 

                	newLeafNode(otherlv_1, grammarAccess.getAExternalFunctionCallAccess().getLeftParenthesisKeyword_1());
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3739:1: ( ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )* )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==RULE_ID||(LA71_0>=RULE_PLUSOP && LA71_0<=RULE_ANDOP)||LA71_0==RULE_MULOP||(LA71_0>=RULE_MINOP && LA71_0<=RULE_REAL)||LA71_0==32||LA71_0==48||LA71_0==51||(LA71_0>=55 && LA71_0<=56)||LA71_0==59||LA71_0==62||LA71_0==64) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3739:2: ( (lv_exprs_2_0= ruleAAlphabetsExpression ) ) (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )*
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3739:2: ( (lv_exprs_2_0= ruleAAlphabetsExpression ) )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3740:1: (lv_exprs_2_0= ruleAAlphabetsExpression )
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3740:1: (lv_exprs_2_0= ruleAAlphabetsExpression )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3741:3: lv_exprs_2_0= ruleAAlphabetsExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getAExternalFunctionCallAccess().getExprsAAlphabetsExpressionParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleAExternalFunctionCall8194);
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

                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3757:2: (otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) ) )*
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==33) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3757:4: otherlv_3= ',' ( (lv_exprs_4_0= ruleAAlphabetsExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,33,FOLLOW_33_in_ruleAExternalFunctionCall8207); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getAExternalFunctionCallAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3761:1: ( (lv_exprs_4_0= ruleAAlphabetsExpression ) )
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3762:1: (lv_exprs_4_0= ruleAAlphabetsExpression )
                    	    {
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3762:1: (lv_exprs_4_0= ruleAAlphabetsExpression )
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3763:3: lv_exprs_4_0= ruleAAlphabetsExpression
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAExternalFunctionCallAccess().getExprsAAlphabetsExpressionParserRuleCall_2_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAAlphabetsExpression_in_ruleAExternalFunctionCall8228);
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
                    	    break loop70;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,34,FOLLOW_34_in_ruleAExternalFunctionCall8244); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3791:1: entryRuleIndexIdentifier returns [String current=null] : iv_ruleIndexIdentifier= ruleIndexIdentifier EOF ;
    public final String entryRuleIndexIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIndexIdentifier = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3792:2: (iv_ruleIndexIdentifier= ruleIndexIdentifier EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3793:2: iv_ruleIndexIdentifier= ruleIndexIdentifier EOF
            {
             newCompositeNode(grammarAccess.getIndexIdentifierRule()); 
            pushFollow(FOLLOW_ruleIndexIdentifier_in_entryRuleIndexIdentifier8281);
            iv_ruleIndexIdentifier=ruleIndexIdentifier();

            state._fsp--;

             current =iv_ruleIndexIdentifier.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIndexIdentifier8292); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3800:1: ruleIndexIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleIndexIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3803:28: (this_ID_0= RULE_ID )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3804:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIndexIdentifier8331); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3819:1: entryRuleAIndexList returns [EObject current=null] : iv_ruleAIndexList= ruleAIndexList EOF ;
    public final EObject entryRuleAIndexList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAIndexList = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3820:2: (iv_ruleAIndexList= ruleAIndexList EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3821:2: iv_ruleAIndexList= ruleAIndexList EOF
            {
             newCompositeNode(grammarAccess.getAIndexListRule()); 
            pushFollow(FOLLOW_ruleAIndexList_in_entryRuleAIndexList8375);
            iv_ruleAIndexList=ruleAIndexList();

            state._fsp--;

             current =iv_ruleAIndexList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAIndexList8385); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3828:1: ruleAIndexList returns [EObject current=null] : ( () ( ( (lv_ids_1_0= ruleIndexIdentifier ) ) (otherlv_2= ',' ( (lv_ids_3_0= ruleIndexIdentifier ) ) )* )? ) ;
    public final EObject ruleAIndexList() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_ids_1_0 = null;

        AntlrDatatypeRuleToken lv_ids_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3831:28: ( ( () ( ( (lv_ids_1_0= ruleIndexIdentifier ) ) (otherlv_2= ',' ( (lv_ids_3_0= ruleIndexIdentifier ) ) )* )? ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3832:1: ( () ( ( (lv_ids_1_0= ruleIndexIdentifier ) ) (otherlv_2= ',' ( (lv_ids_3_0= ruleIndexIdentifier ) ) )* )? )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3832:1: ( () ( ( (lv_ids_1_0= ruleIndexIdentifier ) ) (otherlv_2= ',' ( (lv_ids_3_0= ruleIndexIdentifier ) ) )* )? )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3832:2: () ( ( (lv_ids_1_0= ruleIndexIdentifier ) ) (otherlv_2= ',' ( (lv_ids_3_0= ruleIndexIdentifier ) ) )* )?
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3832:2: ()
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3833:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAIndexListAccess().getAIndexListAction_0(),
                        current);
                

            }

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3838:2: ( ( (lv_ids_1_0= ruleIndexIdentifier ) ) (otherlv_2= ',' ( (lv_ids_3_0= ruleIndexIdentifier ) ) )* )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==RULE_ID) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3838:3: ( (lv_ids_1_0= ruleIndexIdentifier ) ) (otherlv_2= ',' ( (lv_ids_3_0= ruleIndexIdentifier ) ) )*
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3838:3: ( (lv_ids_1_0= ruleIndexIdentifier ) )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3839:1: (lv_ids_1_0= ruleIndexIdentifier )
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3839:1: (lv_ids_1_0= ruleIndexIdentifier )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3840:3: lv_ids_1_0= ruleIndexIdentifier
                    {
                     
                    	        newCompositeNode(grammarAccess.getAIndexListAccess().getIdsIndexIdentifierParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleIndexIdentifier_in_ruleAIndexList8441);
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

                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3856:2: (otherlv_2= ',' ( (lv_ids_3_0= ruleIndexIdentifier ) ) )*
                    loop72:
                    do {
                        int alt72=2;
                        int LA72_0 = input.LA(1);

                        if ( (LA72_0==33) ) {
                            alt72=1;
                        }


                        switch (alt72) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3856:4: otherlv_2= ',' ( (lv_ids_3_0= ruleIndexIdentifier ) )
                    	    {
                    	    otherlv_2=(Token)match(input,33,FOLLOW_33_in_ruleAIndexList8454); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getAIndexListAccess().getCommaKeyword_1_1_0());
                    	        
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3860:1: ( (lv_ids_3_0= ruleIndexIdentifier ) )
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3861:1: (lv_ids_3_0= ruleIndexIdentifier )
                    	    {
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3861:1: (lv_ids_3_0= ruleIndexIdentifier )
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3862:3: lv_ids_3_0= ruleIndexIdentifier
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAIndexListAccess().getIdsIndexIdentifierParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleIndexIdentifier_in_ruleAIndexList8475);
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
                    	    break loop72;
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3886:1: entryRuleIndexAffineExpression returns [String current=null] : iv_ruleIndexAffineExpression= ruleIndexAffineExpression EOF ;
    public final String entryRuleIndexAffineExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIndexAffineExpression = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3887:2: (iv_ruleIndexAffineExpression= ruleIndexAffineExpression EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3888:2: iv_ruleIndexAffineExpression= ruleIndexAffineExpression EOF
            {
             newCompositeNode(grammarAccess.getIndexAffineExpressionRule()); 
            pushFollow(FOLLOW_ruleIndexAffineExpression_in_entryRuleIndexAffineExpression8516);
            iv_ruleIndexAffineExpression=ruleIndexAffineExpression();

            state._fsp--;

             current =iv_ruleIndexAffineExpression.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIndexAffineExpression8527); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3895:1: ruleIndexAffineExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_MinusOp_0= RULE_MINUSOP )? this_IndexAffineExpressionTerminal_1= ruleIndexAffineExpressionTerminal ( (this_PlusOp_2= RULE_PLUSOP | this_MinusOp_3= RULE_MINUSOP ) this_IndexAffineExpression_4= ruleIndexAffineExpression )* ) ;
    public final AntlrDatatypeRuleToken ruleIndexAffineExpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_MinusOp_0=null;
        Token this_PlusOp_2=null;
        Token this_MinusOp_3=null;
        AntlrDatatypeRuleToken this_IndexAffineExpressionTerminal_1 = null;

        AntlrDatatypeRuleToken this_IndexAffineExpression_4 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3898:28: ( ( (this_MinusOp_0= RULE_MINUSOP )? this_IndexAffineExpressionTerminal_1= ruleIndexAffineExpressionTerminal ( (this_PlusOp_2= RULE_PLUSOP | this_MinusOp_3= RULE_MINUSOP ) this_IndexAffineExpression_4= ruleIndexAffineExpression )* ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3899:1: ( (this_MinusOp_0= RULE_MINUSOP )? this_IndexAffineExpressionTerminal_1= ruleIndexAffineExpressionTerminal ( (this_PlusOp_2= RULE_PLUSOP | this_MinusOp_3= RULE_MINUSOP ) this_IndexAffineExpression_4= ruleIndexAffineExpression )* )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3899:1: ( (this_MinusOp_0= RULE_MINUSOP )? this_IndexAffineExpressionTerminal_1= ruleIndexAffineExpressionTerminal ( (this_PlusOp_2= RULE_PLUSOP | this_MinusOp_3= RULE_MINUSOP ) this_IndexAffineExpression_4= ruleIndexAffineExpression )* )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3899:2: (this_MinusOp_0= RULE_MINUSOP )? this_IndexAffineExpressionTerminal_1= ruleIndexAffineExpressionTerminal ( (this_PlusOp_2= RULE_PLUSOP | this_MinusOp_3= RULE_MINUSOP ) this_IndexAffineExpression_4= ruleIndexAffineExpression )*
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3899:2: (this_MinusOp_0= RULE_MINUSOP )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==RULE_MINUSOP) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3899:7: this_MinusOp_0= RULE_MINUSOP
                    {
                    this_MinusOp_0=(Token)match(input,RULE_MINUSOP,FOLLOW_RULE_MINUSOP_in_ruleIndexAffineExpression8568); 

                    		current.merge(this_MinusOp_0);
                        
                     
                        newLeafNode(this_MinusOp_0, grammarAccess.getIndexAffineExpressionAccess().getMinusOpTerminalRuleCall_0()); 
                        

                    }
                    break;

            }

             
                    newCompositeNode(grammarAccess.getIndexAffineExpressionAccess().getIndexAffineExpressionTerminalParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleIndexAffineExpressionTerminal_in_ruleIndexAffineExpression8597);
            this_IndexAffineExpressionTerminal_1=ruleIndexAffineExpressionTerminal();

            state._fsp--;


            		current.merge(this_IndexAffineExpressionTerminal_1);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3917:1: ( (this_PlusOp_2= RULE_PLUSOP | this_MinusOp_3= RULE_MINUSOP ) this_IndexAffineExpression_4= ruleIndexAffineExpression )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==RULE_PLUSOP) ) {
                    alt76=1;
                }
                else if ( (LA76_0==RULE_MINUSOP) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3917:2: (this_PlusOp_2= RULE_PLUSOP | this_MinusOp_3= RULE_MINUSOP ) this_IndexAffineExpression_4= ruleIndexAffineExpression
            	    {
            	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3917:2: (this_PlusOp_2= RULE_PLUSOP | this_MinusOp_3= RULE_MINUSOP )
            	    int alt75=2;
            	    int LA75_0 = input.LA(1);

            	    if ( (LA75_0==RULE_PLUSOP) ) {
            	        alt75=1;
            	    }
            	    else if ( (LA75_0==RULE_MINUSOP) ) {
            	        alt75=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 75, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt75) {
            	        case 1 :
            	            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3917:7: this_PlusOp_2= RULE_PLUSOP
            	            {
            	            this_PlusOp_2=(Token)match(input,RULE_PLUSOP,FOLLOW_RULE_PLUSOP_in_ruleIndexAffineExpression8619); 

            	            		current.merge(this_PlusOp_2);
            	                
            	             
            	                newLeafNode(this_PlusOp_2, grammarAccess.getIndexAffineExpressionAccess().getPlusOpTerminalRuleCall_2_0_0()); 
            	                

            	            }
            	            break;
            	        case 2 :
            	            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3925:10: this_MinusOp_3= RULE_MINUSOP
            	            {
            	            this_MinusOp_3=(Token)match(input,RULE_MINUSOP,FOLLOW_RULE_MINUSOP_in_ruleIndexAffineExpression8645); 

            	            		current.merge(this_MinusOp_3);
            	                
            	             
            	                newLeafNode(this_MinusOp_3, grammarAccess.getIndexAffineExpressionAccess().getMinusOpTerminalRuleCall_2_0_1()); 
            	                

            	            }
            	            break;

            	    }

            	     
            	            newCompositeNode(grammarAccess.getIndexAffineExpressionAccess().getIndexAffineExpressionParserRuleCall_2_1()); 
            	        
            	    pushFollow(FOLLOW_ruleIndexAffineExpression_in_ruleIndexAffineExpression8673);
            	    this_IndexAffineExpression_4=ruleIndexAffineExpression();

            	    state._fsp--;


            	    		current.merge(this_IndexAffineExpression_4);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop76;
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3951:1: entryRuleIndexAffineExpressionTerminal returns [String current=null] : iv_ruleIndexAffineExpressionTerminal= ruleIndexAffineExpressionTerminal EOF ;
    public final String entryRuleIndexAffineExpressionTerminal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIndexAffineExpressionTerminal = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3952:2: (iv_ruleIndexAffineExpressionTerminal= ruleIndexAffineExpressionTerminal EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3953:2: iv_ruleIndexAffineExpressionTerminal= ruleIndexAffineExpressionTerminal EOF
            {
             newCompositeNode(grammarAccess.getIndexAffineExpressionTerminalRule()); 
            pushFollow(FOLLOW_ruleIndexAffineExpressionTerminal_in_entryRuleIndexAffineExpressionTerminal8721);
            iv_ruleIndexAffineExpressionTerminal=ruleIndexAffineExpressionTerminal();

            state._fsp--;

             current =iv_ruleIndexAffineExpressionTerminal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIndexAffineExpressionTerminal8732); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3960:1: ruleIndexAffineExpressionTerminal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | ( (this_INT_1= RULE_INT )? this_IndexIdentifier_2= ruleIndexIdentifier ) ) ;
    public final AntlrDatatypeRuleToken ruleIndexAffineExpressionTerminal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token this_INT_1=null;
        AntlrDatatypeRuleToken this_IndexIdentifier_2 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3963:28: ( (this_INT_0= RULE_INT | ( (this_INT_1= RULE_INT )? this_IndexIdentifier_2= ruleIndexIdentifier ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3964:1: (this_INT_0= RULE_INT | ( (this_INT_1= RULE_INT )? this_IndexIdentifier_2= ruleIndexIdentifier ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3964:1: (this_INT_0= RULE_INT | ( (this_INT_1= RULE_INT )? this_IndexIdentifier_2= ruleIndexIdentifier ) )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==RULE_INT) ) {
                int LA78_1 = input.LA(2);

                if ( (LA78_1==RULE_ID) ) {
                    alt78=2;
                }
                else if ( (LA78_1==EOF||(LA78_1>=RULE_PLUSOP && LA78_1<=RULE_MINUSOP)||(LA78_1>=33 && LA78_1<=34)||LA78_1==52) ) {
                    alt78=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 78, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA78_0==RULE_ID) ) {
                alt78=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3964:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIndexAffineExpressionTerminal8772); 

                    		current.merge(this_INT_0);
                        
                     
                        newLeafNode(this_INT_0, grammarAccess.getIndexAffineExpressionTerminalAccess().getINTTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3972:6: ( (this_INT_1= RULE_INT )? this_IndexIdentifier_2= ruleIndexIdentifier )
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3972:6: ( (this_INT_1= RULE_INT )? this_IndexIdentifier_2= ruleIndexIdentifier )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3972:7: (this_INT_1= RULE_INT )? this_IndexIdentifier_2= ruleIndexIdentifier
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3972:7: (this_INT_1= RULE_INT )?
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==RULE_INT) ) {
                        alt77=1;
                    }
                    switch (alt77) {
                        case 1 :
                            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3972:12: this_INT_1= RULE_INT
                            {
                            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIndexAffineExpressionTerminal8800); 

                            		current.merge(this_INT_1);
                                
                             
                                newLeafNode(this_INT_1, grammarAccess.getIndexAffineExpressionTerminalAccess().getINTTerminalRuleCall_1_0()); 
                                

                            }
                            break;

                    }

                     
                            newCompositeNode(grammarAccess.getIndexAffineExpressionTerminalAccess().getIndexIdentifierParserRuleCall_1_1()); 
                        
                    pushFollow(FOLLOW_ruleIndexIdentifier_in_ruleIndexAffineExpressionTerminal8829);
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3998:1: entryRuleAIndexAffineExpressionList returns [EObject current=null] : iv_ruleAIndexAffineExpressionList= ruleAIndexAffineExpressionList EOF ;
    public final EObject entryRuleAIndexAffineExpressionList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAIndexAffineExpressionList = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:3999:2: (iv_ruleAIndexAffineExpressionList= ruleAIndexAffineExpressionList EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4000:2: iv_ruleAIndexAffineExpressionList= ruleAIndexAffineExpressionList EOF
            {
             newCompositeNode(grammarAccess.getAIndexAffineExpressionListRule()); 
            pushFollow(FOLLOW_ruleAIndexAffineExpressionList_in_entryRuleAIndexAffineExpressionList8875);
            iv_ruleAIndexAffineExpressionList=ruleAIndexAffineExpressionList();

            state._fsp--;

             current =iv_ruleAIndexAffineExpressionList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAIndexAffineExpressionList8885); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4007:1: ruleAIndexAffineExpressionList returns [EObject current=null] : ( () ( ( (lv_exprs_1_0= ruleIndexAffineExpression ) ) (otherlv_2= ',' ( (lv_exprs_3_0= ruleIndexAffineExpression ) ) )* )? ) ;
    public final EObject ruleAIndexAffineExpressionList() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_exprs_1_0 = null;

        AntlrDatatypeRuleToken lv_exprs_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4010:28: ( ( () ( ( (lv_exprs_1_0= ruleIndexAffineExpression ) ) (otherlv_2= ',' ( (lv_exprs_3_0= ruleIndexAffineExpression ) ) )* )? ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4011:1: ( () ( ( (lv_exprs_1_0= ruleIndexAffineExpression ) ) (otherlv_2= ',' ( (lv_exprs_3_0= ruleIndexAffineExpression ) ) )* )? )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4011:1: ( () ( ( (lv_exprs_1_0= ruleIndexAffineExpression ) ) (otherlv_2= ',' ( (lv_exprs_3_0= ruleIndexAffineExpression ) ) )* )? )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4011:2: () ( ( (lv_exprs_1_0= ruleIndexAffineExpression ) ) (otherlv_2= ',' ( (lv_exprs_3_0= ruleIndexAffineExpression ) ) )* )?
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4011:2: ()
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4012:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAIndexAffineExpressionListAccess().getAIndexAffineExpressionListAction_0(),
                        current);
                

            }

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4017:2: ( ( (lv_exprs_1_0= ruleIndexAffineExpression ) ) (otherlv_2= ',' ( (lv_exprs_3_0= ruleIndexAffineExpression ) ) )* )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==RULE_ID||(LA80_0>=RULE_MINUSOP && LA80_0<=RULE_INT)) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4017:3: ( (lv_exprs_1_0= ruleIndexAffineExpression ) ) (otherlv_2= ',' ( (lv_exprs_3_0= ruleIndexAffineExpression ) ) )*
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4017:3: ( (lv_exprs_1_0= ruleIndexAffineExpression ) )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4018:1: (lv_exprs_1_0= ruleIndexAffineExpression )
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4018:1: (lv_exprs_1_0= ruleIndexAffineExpression )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4019:3: lv_exprs_1_0= ruleIndexAffineExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getAIndexAffineExpressionListAccess().getExprsIndexAffineExpressionParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleIndexAffineExpression_in_ruleAIndexAffineExpressionList8941);
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

                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4035:2: (otherlv_2= ',' ( (lv_exprs_3_0= ruleIndexAffineExpression ) ) )*
                    loop79:
                    do {
                        int alt79=2;
                        int LA79_0 = input.LA(1);

                        if ( (LA79_0==33) ) {
                            alt79=1;
                        }


                        switch (alt79) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4035:4: otherlv_2= ',' ( (lv_exprs_3_0= ruleIndexAffineExpression ) )
                    	    {
                    	    otherlv_2=(Token)match(input,33,FOLLOW_33_in_ruleAIndexAffineExpressionList8954); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getAIndexAffineExpressionListAccess().getCommaKeyword_1_1_0());
                    	        
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4039:1: ( (lv_exprs_3_0= ruleIndexAffineExpression ) )
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4040:1: (lv_exprs_3_0= ruleIndexAffineExpression )
                    	    {
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4040:1: (lv_exprs_3_0= ruleIndexAffineExpression )
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4041:3: lv_exprs_3_0= ruleIndexAffineExpression
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAIndexAffineExpressionListAccess().getExprsIndexAffineExpressionParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleIndexAffineExpression_in_ruleAIndexAffineExpressionList8975);
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
                    	    break loop79;
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4065:1: entryRuleAFunction returns [EObject current=null] : iv_ruleAFunction= ruleAFunction EOF ;
    public final EObject entryRuleAFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAFunction = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4066:2: (iv_ruleAFunction= ruleAFunction EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4067:2: iv_ruleAFunction= ruleAFunction EOF
            {
             newCompositeNode(grammarAccess.getAFunctionRule()); 
            pushFollow(FOLLOW_ruleAFunction_in_entryRuleAFunction9015);
            iv_ruleAFunction=ruleAFunction();

            state._fsp--;

             current =iv_ruleAFunction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAFunction9025); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4074:1: ruleAFunction returns [EObject current=null] : (otherlv_0= '(' ( (lv_indexes_1_0= ruleAIndexList ) ) otherlv_2= '->' ( (lv_func_3_0= ruleAIndexAffineExpressionList ) ) otherlv_4= ')' ) ;
    public final EObject ruleAFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_indexes_1_0 = null;

        EObject lv_func_3_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4077:28: ( (otherlv_0= '(' ( (lv_indexes_1_0= ruleAIndexList ) ) otherlv_2= '->' ( (lv_func_3_0= ruleAIndexAffineExpressionList ) ) otherlv_4= ')' ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4078:1: (otherlv_0= '(' ( (lv_indexes_1_0= ruleAIndexList ) ) otherlv_2= '->' ( (lv_func_3_0= ruleAIndexAffineExpressionList ) ) otherlv_4= ')' )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4078:1: (otherlv_0= '(' ( (lv_indexes_1_0= ruleAIndexList ) ) otherlv_2= '->' ( (lv_func_3_0= ruleAIndexAffineExpressionList ) ) otherlv_4= ')' )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4078:3: otherlv_0= '(' ( (lv_indexes_1_0= ruleAIndexList ) ) otherlv_2= '->' ( (lv_func_3_0= ruleAIndexAffineExpressionList ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleAFunction9062); 

                	newLeafNode(otherlv_0, grammarAccess.getAFunctionAccess().getLeftParenthesisKeyword_0());
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4082:1: ( (lv_indexes_1_0= ruleAIndexList ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4083:1: (lv_indexes_1_0= ruleAIndexList )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4083:1: (lv_indexes_1_0= ruleAIndexList )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4084:3: lv_indexes_1_0= ruleAIndexList
            {
             
            	        newCompositeNode(grammarAccess.getAFunctionAccess().getIndexesAIndexListParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleAIndexList_in_ruleAFunction9083);
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

            otherlv_2=(Token)match(input,63,FOLLOW_63_in_ruleAFunction9095); 

                	newLeafNode(otherlv_2, grammarAccess.getAFunctionAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4104:1: ( (lv_func_3_0= ruleAIndexAffineExpressionList ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4105:1: (lv_func_3_0= ruleAIndexAffineExpressionList )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4105:1: (lv_func_3_0= ruleAIndexAffineExpressionList )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4106:3: lv_func_3_0= ruleAIndexAffineExpressionList
            {
             
            	        newCompositeNode(grammarAccess.getAFunctionAccess().getFuncAIndexAffineExpressionListParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleAIndexAffineExpressionList_in_ruleAFunction9116);
            lv_func_3_0=ruleAIndexAffineExpressionList();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAFunctionRule());
            	        }
                   		set(
                   			current, 
                   			"func",
                    		lv_func_3_0, 
                    		"AIndexAffineExpressionList");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,34,FOLLOW_34_in_ruleAFunction9128); 

                	newLeafNode(otherlv_4, grammarAccess.getAFunctionAccess().getRightParenthesisKeyword_4());
                

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4134:1: entryRuleAFunctionInArrayNotation returns [EObject current=null] : iv_ruleAFunctionInArrayNotation= ruleAFunctionInArrayNotation EOF ;
    public final EObject entryRuleAFunctionInArrayNotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAFunctionInArrayNotation = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4135:2: (iv_ruleAFunctionInArrayNotation= ruleAFunctionInArrayNotation EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4136:2: iv_ruleAFunctionInArrayNotation= ruleAFunctionInArrayNotation EOF
            {
             newCompositeNode(grammarAccess.getAFunctionInArrayNotationRule()); 
            pushFollow(FOLLOW_ruleAFunctionInArrayNotation_in_entryRuleAFunctionInArrayNotation9164);
            iv_ruleAFunctionInArrayNotation=ruleAFunctionInArrayNotation();

            state._fsp--;

             current =iv_ruleAFunctionInArrayNotation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAFunctionInArrayNotation9174); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4143:1: ruleAFunctionInArrayNotation returns [EObject current=null] : (otherlv_0= '[' ( (lv_newIds_1_0= ruleAIndexAffineExpressionList ) ) otherlv_2= ']' ) ;
    public final EObject ruleAFunctionInArrayNotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_newIds_1_0 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4146:28: ( (otherlv_0= '[' ( (lv_newIds_1_0= ruleAIndexAffineExpressionList ) ) otherlv_2= ']' ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4147:1: (otherlv_0= '[' ( (lv_newIds_1_0= ruleAIndexAffineExpressionList ) ) otherlv_2= ']' )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4147:1: (otherlv_0= '[' ( (lv_newIds_1_0= ruleAIndexAffineExpressionList ) ) otherlv_2= ']' )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4147:3: otherlv_0= '[' ( (lv_newIds_1_0= ruleAIndexAffineExpressionList ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,51,FOLLOW_51_in_ruleAFunctionInArrayNotation9211); 

                	newLeafNode(otherlv_0, grammarAccess.getAFunctionInArrayNotationAccess().getLeftSquareBracketKeyword_0());
                
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4151:1: ( (lv_newIds_1_0= ruleAIndexAffineExpressionList ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4152:1: (lv_newIds_1_0= ruleAIndexAffineExpressionList )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4152:1: (lv_newIds_1_0= ruleAIndexAffineExpressionList )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4153:3: lv_newIds_1_0= ruleAIndexAffineExpressionList
            {
             
            	        newCompositeNode(grammarAccess.getAFunctionInArrayNotationAccess().getNewIdsAIndexAffineExpressionListParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleAIndexAffineExpressionList_in_ruleAFunctionInArrayNotation9232);
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

            otherlv_2=(Token)match(input,52,FOLLOW_52_in_ruleAFunctionInArrayNotation9244); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4181:1: entryRuleAType returns [EObject current=null] : iv_ruleAType= ruleAType EOF ;
    public final EObject entryRuleAType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAType = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4182:2: (iv_ruleAType= ruleAType EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4183:2: iv_ruleAType= ruleAType EOF
            {
             newCompositeNode(grammarAccess.getATypeRule()); 
            pushFollow(FOLLOW_ruleAType_in_entryRuleAType9280);
            iv_ruleAType=ruleAType();

            state._fsp--;

             current =iv_ruleAType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAType9290); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4190:1: ruleAType returns [EObject current=null] : ( ( (lv_unsigned_0_0= 'unsigned' ) )? ( ( (lv_type_1_1= ruleATypeInteger | lv_type_1_2= ruleATypeFloat | lv_type_1_3= ruleATypeBoolean | lv_type_1_4= ruleATypeChar ) ) ) ) ;
    public final EObject ruleAType() throws RecognitionException {
        EObject current = null;

        Token lv_unsigned_0_0=null;
        AntlrDatatypeRuleToken lv_type_1_1 = null;

        AntlrDatatypeRuleToken lv_type_1_2 = null;

        AntlrDatatypeRuleToken lv_type_1_3 = null;

        AntlrDatatypeRuleToken lv_type_1_4 = null;


         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4193:28: ( ( ( (lv_unsigned_0_0= 'unsigned' ) )? ( ( (lv_type_1_1= ruleATypeInteger | lv_type_1_2= ruleATypeFloat | lv_type_1_3= ruleATypeBoolean | lv_type_1_4= ruleATypeChar ) ) ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4194:1: ( ( (lv_unsigned_0_0= 'unsigned' ) )? ( ( (lv_type_1_1= ruleATypeInteger | lv_type_1_2= ruleATypeFloat | lv_type_1_3= ruleATypeBoolean | lv_type_1_4= ruleATypeChar ) ) ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4194:1: ( ( (lv_unsigned_0_0= 'unsigned' ) )? ( ( (lv_type_1_1= ruleATypeInteger | lv_type_1_2= ruleATypeFloat | lv_type_1_3= ruleATypeBoolean | lv_type_1_4= ruleATypeChar ) ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4194:2: ( (lv_unsigned_0_0= 'unsigned' ) )? ( ( (lv_type_1_1= ruleATypeInteger | lv_type_1_2= ruleATypeFloat | lv_type_1_3= ruleATypeBoolean | lv_type_1_4= ruleATypeChar ) ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4194:2: ( (lv_unsigned_0_0= 'unsigned' ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==66) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4195:1: (lv_unsigned_0_0= 'unsigned' )
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4195:1: (lv_unsigned_0_0= 'unsigned' )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4196:3: lv_unsigned_0_0= 'unsigned'
                    {
                    lv_unsigned_0_0=(Token)match(input,66,FOLLOW_66_in_ruleAType9333); 

                            newLeafNode(lv_unsigned_0_0, grammarAccess.getATypeAccess().getUnsignedUnsignedKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getATypeRule());
                    	        }
                           		setWithLastConsumed(current, "unsigned", lv_unsigned_0_0, "unsigned");
                    	    

                    }


                    }
                    break;

            }

            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4209:3: ( ( (lv_type_1_1= ruleATypeInteger | lv_type_1_2= ruleATypeFloat | lv_type_1_3= ruleATypeBoolean | lv_type_1_4= ruleATypeChar ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4210:1: ( (lv_type_1_1= ruleATypeInteger | lv_type_1_2= ruleATypeFloat | lv_type_1_3= ruleATypeBoolean | lv_type_1_4= ruleATypeChar ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4210:1: ( (lv_type_1_1= ruleATypeInteger | lv_type_1_2= ruleATypeFloat | lv_type_1_3= ruleATypeBoolean | lv_type_1_4= ruleATypeChar ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4211:1: (lv_type_1_1= ruleATypeInteger | lv_type_1_2= ruleATypeFloat | lv_type_1_3= ruleATypeBoolean | lv_type_1_4= ruleATypeChar )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4211:1: (lv_type_1_1= ruleATypeInteger | lv_type_1_2= ruleATypeFloat | lv_type_1_3= ruleATypeBoolean | lv_type_1_4= ruleATypeChar )
            int alt82=4;
            switch ( input.LA(1) ) {
            case 67:
            case 68:
            case 69:
            case 70:
                {
                alt82=1;
                }
                break;
            case 72:
            case 73:
                {
                alt82=2;
                }
                break;
            case 71:
                {
                alt82=3;
                }
                break;
            case 74:
                {
                alt82=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }

            switch (alt82) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4212:3: lv_type_1_1= ruleATypeInteger
                    {
                     
                    	        newCompositeNode(grammarAccess.getATypeAccess().getTypeATypeIntegerParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleATypeInteger_in_ruleAType9370);
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
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4227:8: lv_type_1_2= ruleATypeFloat
                    {
                     
                    	        newCompositeNode(grammarAccess.getATypeAccess().getTypeATypeFloatParserRuleCall_1_0_1()); 
                    	    
                    pushFollow(FOLLOW_ruleATypeFloat_in_ruleAType9389);
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
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4242:8: lv_type_1_3= ruleATypeBoolean
                    {
                     
                    	        newCompositeNode(grammarAccess.getATypeAccess().getTypeATypeBooleanParserRuleCall_1_0_2()); 
                    	    
                    pushFollow(FOLLOW_ruleATypeBoolean_in_ruleAType9408);
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
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4257:8: lv_type_1_4= ruleATypeChar
                    {
                     
                    	        newCompositeNode(grammarAccess.getATypeAccess().getTypeATypeCharParserRuleCall_1_0_3()); 
                    	    
                    pushFollow(FOLLOW_ruleATypeChar_in_ruleAType9427);
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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4283:1: entryRuleATypeInteger returns [String current=null] : iv_ruleATypeInteger= ruleATypeInteger EOF ;
    public final String entryRuleATypeInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleATypeInteger = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4284:2: (iv_ruleATypeInteger= ruleATypeInteger EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4285:2: iv_ruleATypeInteger= ruleATypeInteger EOF
            {
             newCompositeNode(grammarAccess.getATypeIntegerRule()); 
            pushFollow(FOLLOW_ruleATypeInteger_in_entryRuleATypeInteger9467);
            iv_ruleATypeInteger=ruleATypeInteger();

            state._fsp--;

             current =iv_ruleATypeInteger.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleATypeInteger9478); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4292:1: ruleATypeInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'int' | kw= 'longlong' | kw= 'long' | kw= 'short' ) ;
    public final AntlrDatatypeRuleToken ruleATypeInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4295:28: ( (kw= 'int' | kw= 'longlong' | kw= 'long' | kw= 'short' ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4296:1: (kw= 'int' | kw= 'longlong' | kw= 'long' | kw= 'short' )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4296:1: (kw= 'int' | kw= 'longlong' | kw= 'long' | kw= 'short' )
            int alt83=4;
            switch ( input.LA(1) ) {
            case 67:
                {
                alt83=1;
                }
                break;
            case 68:
                {
                alt83=2;
                }
                break;
            case 69:
                {
                alt83=3;
                }
                break;
            case 70:
                {
                alt83=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }

            switch (alt83) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4297:2: kw= 'int'
                    {
                    kw=(Token)match(input,67,FOLLOW_67_in_ruleATypeInteger9516); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getATypeIntegerAccess().getIntKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4304:2: kw= 'longlong'
                    {
                    kw=(Token)match(input,68,FOLLOW_68_in_ruleATypeInteger9535); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getATypeIntegerAccess().getLonglongKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4311:2: kw= 'long'
                    {
                    kw=(Token)match(input,69,FOLLOW_69_in_ruleATypeInteger9554); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getATypeIntegerAccess().getLongKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4318:2: kw= 'short'
                    {
                    kw=(Token)match(input,70,FOLLOW_70_in_ruleATypeInteger9573); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4331:1: entryRuleATypeBoolean returns [String current=null] : iv_ruleATypeBoolean= ruleATypeBoolean EOF ;
    public final String entryRuleATypeBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleATypeBoolean = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4332:2: (iv_ruleATypeBoolean= ruleATypeBoolean EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4333:2: iv_ruleATypeBoolean= ruleATypeBoolean EOF
            {
             newCompositeNode(grammarAccess.getATypeBooleanRule()); 
            pushFollow(FOLLOW_ruleATypeBoolean_in_entryRuleATypeBoolean9614);
            iv_ruleATypeBoolean=ruleATypeBoolean();

            state._fsp--;

             current =iv_ruleATypeBoolean.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleATypeBoolean9625); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4340:1: ruleATypeBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'bool' ;
    public final AntlrDatatypeRuleToken ruleATypeBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4343:28: (kw= 'bool' )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4345:2: kw= 'bool'
            {
            kw=(Token)match(input,71,FOLLOW_71_in_ruleATypeBoolean9662); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4358:1: entryRuleATypeFloat returns [String current=null] : iv_ruleATypeFloat= ruleATypeFloat EOF ;
    public final String entryRuleATypeFloat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleATypeFloat = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4359:2: (iv_ruleATypeFloat= ruleATypeFloat EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4360:2: iv_ruleATypeFloat= ruleATypeFloat EOF
            {
             newCompositeNode(grammarAccess.getATypeFloatRule()); 
            pushFollow(FOLLOW_ruleATypeFloat_in_entryRuleATypeFloat9702);
            iv_ruleATypeFloat=ruleATypeFloat();

            state._fsp--;

             current =iv_ruleATypeFloat.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleATypeFloat9713); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4367:1: ruleATypeFloat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'float' | kw= 'double' ) ;
    public final AntlrDatatypeRuleToken ruleATypeFloat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4370:28: ( (kw= 'float' | kw= 'double' ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4371:1: (kw= 'float' | kw= 'double' )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4371:1: (kw= 'float' | kw= 'double' )
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==72) ) {
                alt84=1;
            }
            else if ( (LA84_0==73) ) {
                alt84=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }
            switch (alt84) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4372:2: kw= 'float'
                    {
                    kw=(Token)match(input,72,FOLLOW_72_in_ruleATypeFloat9751); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getATypeFloatAccess().getFloatKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4379:2: kw= 'double'
                    {
                    kw=(Token)match(input,73,FOLLOW_73_in_ruleATypeFloat9770); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4392:1: entryRuleATypeChar returns [String current=null] : iv_ruleATypeChar= ruleATypeChar EOF ;
    public final String entryRuleATypeChar() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleATypeChar = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4393:2: (iv_ruleATypeChar= ruleATypeChar EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4394:2: iv_ruleATypeChar= ruleATypeChar EOF
            {
             newCompositeNode(grammarAccess.getATypeCharRule()); 
            pushFollow(FOLLOW_ruleATypeChar_in_entryRuleATypeChar9811);
            iv_ruleATypeChar=ruleATypeChar();

            state._fsp--;

             current =iv_ruleATypeChar.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleATypeChar9822); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4401:1: ruleATypeChar returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'char' ;
    public final AntlrDatatypeRuleToken ruleATypeChar() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4404:28: (kw= 'char' )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4406:2: kw= 'char'
            {
            kw=(Token)match(input,74,FOLLOW_74_in_ruleATypeChar9859); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4419:1: entryRuleReductionOp returns [String current=null] : iv_ruleReductionOp= ruleReductionOp EOF ;
    public final String entryRuleReductionOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReductionOp = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4420:2: (iv_ruleReductionOp= ruleReductionOp EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4421:2: iv_ruleReductionOp= ruleReductionOp EOF
            {
             newCompositeNode(grammarAccess.getReductionOpRule()); 
            pushFollow(FOLLOW_ruleReductionOp_in_entryRuleReductionOp9899);
            iv_ruleReductionOp=ruleReductionOp();

            state._fsp--;

             current =iv_ruleReductionOp.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReductionOp9910); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4428:1: ruleReductionOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_AndOp_0= RULE_ANDOP | this_MaxOp_1= RULE_MAXOP | this_MinOp_2= RULE_MINOP | this_MulOp_3= RULE_MULOP | this_OrOp_4= RULE_OROP | this_PlusOp_5= RULE_PLUSOP | this_XorOp_6= RULE_XOROP ) ;
    public final AntlrDatatypeRuleToken ruleReductionOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_AndOp_0=null;
        Token this_MaxOp_1=null;
        Token this_MinOp_2=null;
        Token this_MulOp_3=null;
        Token this_OrOp_4=null;
        Token this_PlusOp_5=null;
        Token this_XorOp_6=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4431:28: ( (this_AndOp_0= RULE_ANDOP | this_MaxOp_1= RULE_MAXOP | this_MinOp_2= RULE_MINOP | this_MulOp_3= RULE_MULOP | this_OrOp_4= RULE_OROP | this_PlusOp_5= RULE_PLUSOP | this_XorOp_6= RULE_XOROP ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4432:1: (this_AndOp_0= RULE_ANDOP | this_MaxOp_1= RULE_MAXOP | this_MinOp_2= RULE_MINOP | this_MulOp_3= RULE_MULOP | this_OrOp_4= RULE_OROP | this_PlusOp_5= RULE_PLUSOP | this_XorOp_6= RULE_XOROP )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4432:1: (this_AndOp_0= RULE_ANDOP | this_MaxOp_1= RULE_MAXOP | this_MinOp_2= RULE_MINOP | this_MulOp_3= RULE_MULOP | this_OrOp_4= RULE_OROP | this_PlusOp_5= RULE_PLUSOP | this_XorOp_6= RULE_XOROP )
            int alt85=7;
            switch ( input.LA(1) ) {
            case RULE_ANDOP:
                {
                alt85=1;
                }
                break;
            case RULE_MAXOP:
                {
                alt85=2;
                }
                break;
            case RULE_MINOP:
                {
                alt85=3;
                }
                break;
            case RULE_MULOP:
                {
                alt85=4;
                }
                break;
            case RULE_OROP:
                {
                alt85=5;
                }
                break;
            case RULE_PLUSOP:
                {
                alt85=6;
                }
                break;
            case RULE_XOROP:
                {
                alt85=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }

            switch (alt85) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4432:6: this_AndOp_0= RULE_ANDOP
                    {
                    this_AndOp_0=(Token)match(input,RULE_ANDOP,FOLLOW_RULE_ANDOP_in_ruleReductionOp9950); 

                    		current.merge(this_AndOp_0);
                        
                     
                        newLeafNode(this_AndOp_0, grammarAccess.getReductionOpAccess().getAndOpTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4440:10: this_MaxOp_1= RULE_MAXOP
                    {
                    this_MaxOp_1=(Token)match(input,RULE_MAXOP,FOLLOW_RULE_MAXOP_in_ruleReductionOp9976); 

                    		current.merge(this_MaxOp_1);
                        
                     
                        newLeafNode(this_MaxOp_1, grammarAccess.getReductionOpAccess().getMaxOpTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4448:10: this_MinOp_2= RULE_MINOP
                    {
                    this_MinOp_2=(Token)match(input,RULE_MINOP,FOLLOW_RULE_MINOP_in_ruleReductionOp10002); 

                    		current.merge(this_MinOp_2);
                        
                     
                        newLeafNode(this_MinOp_2, grammarAccess.getReductionOpAccess().getMinOpTerminalRuleCall_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4456:10: this_MulOp_3= RULE_MULOP
                    {
                    this_MulOp_3=(Token)match(input,RULE_MULOP,FOLLOW_RULE_MULOP_in_ruleReductionOp10028); 

                    		current.merge(this_MulOp_3);
                        
                     
                        newLeafNode(this_MulOp_3, grammarAccess.getReductionOpAccess().getMulOpTerminalRuleCall_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4464:10: this_OrOp_4= RULE_OROP
                    {
                    this_OrOp_4=(Token)match(input,RULE_OROP,FOLLOW_RULE_OROP_in_ruleReductionOp10054); 

                    		current.merge(this_OrOp_4);
                        
                     
                        newLeafNode(this_OrOp_4, grammarAccess.getReductionOpAccess().getOrOpTerminalRuleCall_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4472:10: this_PlusOp_5= RULE_PLUSOP
                    {
                    this_PlusOp_5=(Token)match(input,RULE_PLUSOP,FOLLOW_RULE_PLUSOP_in_ruleReductionOp10080); 

                    		current.merge(this_PlusOp_5);
                        
                     
                        newLeafNode(this_PlusOp_5, grammarAccess.getReductionOpAccess().getPlusOpTerminalRuleCall_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4480:10: this_XorOp_6= RULE_XOROP
                    {
                    this_XorOp_6=(Token)match(input,RULE_XOROP,FOLLOW_RULE_XOROP_in_ruleReductionOp10106); 

                    		current.merge(this_XorOp_6);
                        
                     
                        newLeafNode(this_XorOp_6, grammarAccess.getReductionOpAccess().getXorOpTerminalRuleCall_6()); 
                        

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4495:1: entryRuleArithmeticOp returns [String current=null] : iv_ruleArithmeticOp= ruleArithmeticOp EOF ;
    public final String entryRuleArithmeticOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleArithmeticOp = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4496:2: (iv_ruleArithmeticOp= ruleArithmeticOp EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4497:2: iv_ruleArithmeticOp= ruleArithmeticOp EOF
            {
             newCompositeNode(grammarAccess.getArithmeticOpRule()); 
            pushFollow(FOLLOW_ruleArithmeticOp_in_entryRuleArithmeticOp10152);
            iv_ruleArithmeticOp=ruleArithmeticOp();

            state._fsp--;

             current =iv_ruleArithmeticOp.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArithmeticOp10163); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4504:1: ruleArithmeticOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MaxOp_0= RULE_MAXOP | this_MinOp_1= RULE_MINOP | this_MulOp_2= RULE_MULOP | this_PlusOp_3= RULE_PLUSOP ) ;
    public final AntlrDatatypeRuleToken ruleArithmeticOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_MaxOp_0=null;
        Token this_MinOp_1=null;
        Token this_MulOp_2=null;
        Token this_PlusOp_3=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4507:28: ( (this_MaxOp_0= RULE_MAXOP | this_MinOp_1= RULE_MINOP | this_MulOp_2= RULE_MULOP | this_PlusOp_3= RULE_PLUSOP ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4508:1: (this_MaxOp_0= RULE_MAXOP | this_MinOp_1= RULE_MINOP | this_MulOp_2= RULE_MULOP | this_PlusOp_3= RULE_PLUSOP )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4508:1: (this_MaxOp_0= RULE_MAXOP | this_MinOp_1= RULE_MINOP | this_MulOp_2= RULE_MULOP | this_PlusOp_3= RULE_PLUSOP )
            int alt86=4;
            switch ( input.LA(1) ) {
            case RULE_MAXOP:
                {
                alt86=1;
                }
                break;
            case RULE_MINOP:
                {
                alt86=2;
                }
                break;
            case RULE_MULOP:
                {
                alt86=3;
                }
                break;
            case RULE_PLUSOP:
                {
                alt86=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }

            switch (alt86) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4508:6: this_MaxOp_0= RULE_MAXOP
                    {
                    this_MaxOp_0=(Token)match(input,RULE_MAXOP,FOLLOW_RULE_MAXOP_in_ruleArithmeticOp10203); 

                    		current.merge(this_MaxOp_0);
                        
                     
                        newLeafNode(this_MaxOp_0, grammarAccess.getArithmeticOpAccess().getMaxOpTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4516:10: this_MinOp_1= RULE_MINOP
                    {
                    this_MinOp_1=(Token)match(input,RULE_MINOP,FOLLOW_RULE_MINOP_in_ruleArithmeticOp10229); 

                    		current.merge(this_MinOp_1);
                        
                     
                        newLeafNode(this_MinOp_1, grammarAccess.getArithmeticOpAccess().getMinOpTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4524:10: this_MulOp_2= RULE_MULOP
                    {
                    this_MulOp_2=(Token)match(input,RULE_MULOP,FOLLOW_RULE_MULOP_in_ruleArithmeticOp10255); 

                    		current.merge(this_MulOp_2);
                        
                     
                        newLeafNode(this_MulOp_2, grammarAccess.getArithmeticOpAccess().getMulOpTerminalRuleCall_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4532:10: this_PlusOp_3= RULE_PLUSOP
                    {
                    this_PlusOp_3=(Token)match(input,RULE_PLUSOP,FOLLOW_RULE_PLUSOP_in_ruleArithmeticOp10281); 

                    		current.merge(this_PlusOp_3);
                        
                     
                        newLeafNode(this_PlusOp_3, grammarAccess.getArithmeticOpAccess().getPlusOpTerminalRuleCall_3()); 
                        

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4547:1: entryRuleLogicalOp returns [String current=null] : iv_ruleLogicalOp= ruleLogicalOp EOF ;
    public final String entryRuleLogicalOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOp = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4548:2: (iv_ruleLogicalOp= ruleLogicalOp EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4549:2: iv_ruleLogicalOp= ruleLogicalOp EOF
            {
             newCompositeNode(grammarAccess.getLogicalOpRule()); 
            pushFollow(FOLLOW_ruleLogicalOp_in_entryRuleLogicalOp10327);
            iv_ruleLogicalOp=ruleLogicalOp();

            state._fsp--;

             current =iv_ruleLogicalOp.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOp10338); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4556:1: ruleLogicalOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_AndOp_0= RULE_ANDOP | this_OrOp_1= RULE_OROP | this_XorOp_2= RULE_XOROP ) ;
    public final AntlrDatatypeRuleToken ruleLogicalOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_AndOp_0=null;
        Token this_OrOp_1=null;
        Token this_XorOp_2=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4559:28: ( (this_AndOp_0= RULE_ANDOP | this_OrOp_1= RULE_OROP | this_XorOp_2= RULE_XOROP ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4560:1: (this_AndOp_0= RULE_ANDOP | this_OrOp_1= RULE_OROP | this_XorOp_2= RULE_XOROP )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4560:1: (this_AndOp_0= RULE_ANDOP | this_OrOp_1= RULE_OROP | this_XorOp_2= RULE_XOROP )
            int alt87=3;
            switch ( input.LA(1) ) {
            case RULE_ANDOP:
                {
                alt87=1;
                }
                break;
            case RULE_OROP:
                {
                alt87=2;
                }
                break;
            case RULE_XOROP:
                {
                alt87=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }

            switch (alt87) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4560:6: this_AndOp_0= RULE_ANDOP
                    {
                    this_AndOp_0=(Token)match(input,RULE_ANDOP,FOLLOW_RULE_ANDOP_in_ruleLogicalOp10378); 

                    		current.merge(this_AndOp_0);
                        
                     
                        newLeafNode(this_AndOp_0, grammarAccess.getLogicalOpAccess().getAndOpTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4568:10: this_OrOp_1= RULE_OROP
                    {
                    this_OrOp_1=(Token)match(input,RULE_OROP,FOLLOW_RULE_OROP_in_ruleLogicalOp10404); 

                    		current.merge(this_OrOp_1);
                        
                     
                        newLeafNode(this_OrOp_1, grammarAccess.getLogicalOpAccess().getOrOpTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4576:10: this_XorOp_2= RULE_XOROP
                    {
                    this_XorOp_2=(Token)match(input,RULE_XOROP,FOLLOW_RULE_XOROP_in_ruleLogicalOp10430); 

                    		current.merge(this_XorOp_2);
                        
                     
                        newLeafNode(this_XorOp_2, grammarAccess.getLogicalOpAccess().getXorOpTerminalRuleCall_2()); 
                        

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4591:1: entryRuleRelationalOp returns [String current=null] : iv_ruleRelationalOp= ruleRelationalOp EOF ;
    public final String entryRuleRelationalOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOp = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4592:2: (iv_ruleRelationalOp= ruleRelationalOp EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4593:2: iv_ruleRelationalOp= ruleRelationalOp EOF
            {
             newCompositeNode(grammarAccess.getRelationalOpRule()); 
            pushFollow(FOLLOW_ruleRelationalOp_in_entryRuleRelationalOp10476);
            iv_ruleRelationalOp=ruleRelationalOp();

            state._fsp--;

             current =iv_ruleRelationalOp.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalOp10487); 

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
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4600:1: ruleRelationalOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_EQOp_0= RULE_EQOP | this_GEOp_1= RULE_GEOP | this_GTOp_2= RULE_GTOP | this_LEOp_3= RULE_LEOP | this_LTOp_4= RULE_LTOP | this_NEOp_5= RULE_NEOP ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_EQOp_0=null;
        Token this_GEOp_1=null;
        Token this_GTOp_2=null;
        Token this_LEOp_3=null;
        Token this_LTOp_4=null;
        Token this_NEOp_5=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4603:28: ( (this_EQOp_0= RULE_EQOP | this_GEOp_1= RULE_GEOP | this_GTOp_2= RULE_GTOP | this_LEOp_3= RULE_LEOP | this_LTOp_4= RULE_LTOP | this_NEOp_5= RULE_NEOP ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4604:1: (this_EQOp_0= RULE_EQOP | this_GEOp_1= RULE_GEOP | this_GTOp_2= RULE_GTOP | this_LEOp_3= RULE_LEOP | this_LTOp_4= RULE_LTOP | this_NEOp_5= RULE_NEOP )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4604:1: (this_EQOp_0= RULE_EQOP | this_GEOp_1= RULE_GEOP | this_GTOp_2= RULE_GTOP | this_LEOp_3= RULE_LEOP | this_LTOp_4= RULE_LTOP | this_NEOp_5= RULE_NEOP )
            int alt88=6;
            switch ( input.LA(1) ) {
            case RULE_EQOP:
                {
                alt88=1;
                }
                break;
            case RULE_GEOP:
                {
                alt88=2;
                }
                break;
            case RULE_GTOP:
                {
                alt88=3;
                }
                break;
            case RULE_LEOP:
                {
                alt88=4;
                }
                break;
            case RULE_LTOP:
                {
                alt88=5;
                }
                break;
            case RULE_NEOP:
                {
                alt88=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }

            switch (alt88) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4604:6: this_EQOp_0= RULE_EQOP
                    {
                    this_EQOp_0=(Token)match(input,RULE_EQOP,FOLLOW_RULE_EQOP_in_ruleRelationalOp10527); 

                    		current.merge(this_EQOp_0);
                        
                     
                        newLeafNode(this_EQOp_0, grammarAccess.getRelationalOpAccess().getEQOpTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4612:10: this_GEOp_1= RULE_GEOP
                    {
                    this_GEOp_1=(Token)match(input,RULE_GEOP,FOLLOW_RULE_GEOP_in_ruleRelationalOp10553); 

                    		current.merge(this_GEOp_1);
                        
                     
                        newLeafNode(this_GEOp_1, grammarAccess.getRelationalOpAccess().getGEOpTerminalRuleCall_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4620:10: this_GTOp_2= RULE_GTOP
                    {
                    this_GTOp_2=(Token)match(input,RULE_GTOP,FOLLOW_RULE_GTOP_in_ruleRelationalOp10579); 

                    		current.merge(this_GTOp_2);
                        
                     
                        newLeafNode(this_GTOp_2, grammarAccess.getRelationalOpAccess().getGTOpTerminalRuleCall_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4628:10: this_LEOp_3= RULE_LEOP
                    {
                    this_LEOp_3=(Token)match(input,RULE_LEOP,FOLLOW_RULE_LEOP_in_ruleRelationalOp10605); 

                    		current.merge(this_LEOp_3);
                        
                     
                        newLeafNode(this_LEOp_3, grammarAccess.getRelationalOpAccess().getLEOpTerminalRuleCall_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4636:10: this_LTOp_4= RULE_LTOP
                    {
                    this_LTOp_4=(Token)match(input,RULE_LTOP,FOLLOW_RULE_LTOP_in_ruleRelationalOp10631); 

                    		current.merge(this_LTOp_4);
                        
                     
                        newLeafNode(this_LTOp_4, grammarAccess.getRelationalOpAccess().getLTOpTerminalRuleCall_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4644:10: this_NEOp_5= RULE_NEOP
                    {
                    this_NEOp_5=(Token)match(input,RULE_NEOP,FOLLOW_RULE_NEOP_in_ruleRelationalOp10657); 

                    		current.merge(this_NEOp_5);
                        
                     
                        newLeafNode(this_NEOp_5, grammarAccess.getRelationalOpAccess().getNEOpTerminalRuleCall_5()); 
                        

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


    // $ANTLR start "entryRuleSystemID"
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4659:1: entryRuleSystemID returns [String current=null] : iv_ruleSystemID= ruleSystemID EOF ;
    public final String entryRuleSystemID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSystemID = null;


        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4660:2: (iv_ruleSystemID= ruleSystemID EOF )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4661:2: iv_ruleSystemID= ruleSystemID EOF
            {
             newCompositeNode(grammarAccess.getSystemIDRule()); 
            pushFollow(FOLLOW_ruleSystemID_in_entryRuleSystemID10703);
            iv_ruleSystemID=ruleSystemID();

            state._fsp--;

             current =iv_ruleSystemID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemID10714); 

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
    // $ANTLR end "entryRuleSystemID"


    // $ANTLR start "ruleSystemID"
    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4668:1: ruleSystemID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | ( (this_INT_1= RULE_INT | this_ID_2= RULE_ID ) ( (this_MinusOp_3= RULE_MINUSOP | this_INT_4= RULE_INT | this_ID_5= RULE_ID )* this_ID_6= RULE_ID ) ) ) ;
    public final AntlrDatatypeRuleToken ruleSystemID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_INT_1=null;
        Token this_ID_2=null;
        Token this_MinusOp_3=null;
        Token this_INT_4=null;
        Token this_ID_5=null;
        Token this_ID_6=null;

         enterRule(); 
            
        try {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4671:28: ( (this_ID_0= RULE_ID | ( (this_INT_1= RULE_INT | this_ID_2= RULE_ID ) ( (this_MinusOp_3= RULE_MINUSOP | this_INT_4= RULE_INT | this_ID_5= RULE_ID )* this_ID_6= RULE_ID ) ) ) )
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4672:1: (this_ID_0= RULE_ID | ( (this_INT_1= RULE_INT | this_ID_2= RULE_ID ) ( (this_MinusOp_3= RULE_MINUSOP | this_INT_4= RULE_INT | this_ID_5= RULE_ID )* this_ID_6= RULE_ID ) ) )
            {
            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4672:1: (this_ID_0= RULE_ID | ( (this_INT_1= RULE_INT | this_ID_2= RULE_ID ) ( (this_MinusOp_3= RULE_MINUSOP | this_INT_4= RULE_INT | this_ID_5= RULE_ID )* this_ID_6= RULE_ID ) ) )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==RULE_ID) ) {
                int LA91_1 = input.LA(2);

                if ( (LA91_1==RULE_ID||(LA91_1>=RULE_MINUSOP && LA91_1<=RULE_INT)) ) {
                    alt91=2;
                }
                else if ( (LA91_1==EOF||LA91_1==48) ) {
                    alt91=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 91, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA91_0==RULE_INT) ) {
                alt91=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }
            switch (alt91) {
                case 1 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4672:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSystemID10754); 

                    		current.merge(this_ID_0);
                        
                     
                        newLeafNode(this_ID_0, grammarAccess.getSystemIDAccess().getIDTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4680:6: ( (this_INT_1= RULE_INT | this_ID_2= RULE_ID ) ( (this_MinusOp_3= RULE_MINUSOP | this_INT_4= RULE_INT | this_ID_5= RULE_ID )* this_ID_6= RULE_ID ) )
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4680:6: ( (this_INT_1= RULE_INT | this_ID_2= RULE_ID ) ( (this_MinusOp_3= RULE_MINUSOP | this_INT_4= RULE_INT | this_ID_5= RULE_ID )* this_ID_6= RULE_ID ) )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4680:7: (this_INT_1= RULE_INT | this_ID_2= RULE_ID ) ( (this_MinusOp_3= RULE_MINUSOP | this_INT_4= RULE_INT | this_ID_5= RULE_ID )* this_ID_6= RULE_ID )
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4680:7: (this_INT_1= RULE_INT | this_ID_2= RULE_ID )
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==RULE_INT) ) {
                        alt89=1;
                    }
                    else if ( (LA89_0==RULE_ID) ) {
                        alt89=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 89, 0, input);

                        throw nvae;
                    }
                    switch (alt89) {
                        case 1 :
                            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4680:12: this_INT_1= RULE_INT
                            {
                            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSystemID10782); 

                            		current.merge(this_INT_1);
                                
                             
                                newLeafNode(this_INT_1, grammarAccess.getSystemIDAccess().getINTTerminalRuleCall_1_0_0()); 
                                

                            }
                            break;
                        case 2 :
                            // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4688:10: this_ID_2= RULE_ID
                            {
                            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSystemID10808); 

                            		current.merge(this_ID_2);
                                
                             
                                newLeafNode(this_ID_2, grammarAccess.getSystemIDAccess().getIDTerminalRuleCall_1_0_1()); 
                                

                            }
                            break;

                    }

                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4695:2: ( (this_MinusOp_3= RULE_MINUSOP | this_INT_4= RULE_INT | this_ID_5= RULE_ID )* this_ID_6= RULE_ID )
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4695:3: (this_MinusOp_3= RULE_MINUSOP | this_INT_4= RULE_INT | this_ID_5= RULE_ID )* this_ID_6= RULE_ID
                    {
                    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4695:3: (this_MinusOp_3= RULE_MINUSOP | this_INT_4= RULE_INT | this_ID_5= RULE_ID )*
                    loop90:
                    do {
                        int alt90=4;
                        switch ( input.LA(1) ) {
                        case RULE_ID:
                            {
                            int LA90_1 = input.LA(2);

                            if ( (LA90_1==RULE_ID||(LA90_1>=RULE_MINUSOP && LA90_1<=RULE_INT)) ) {
                                alt90=3;
                            }


                            }
                            break;
                        case RULE_MINUSOP:
                            {
                            alt90=1;
                            }
                            break;
                        case RULE_INT:
                            {
                            alt90=2;
                            }
                            break;

                        }

                        switch (alt90) {
                    	case 1 :
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4695:8: this_MinusOp_3= RULE_MINUSOP
                    	    {
                    	    this_MinusOp_3=(Token)match(input,RULE_MINUSOP,FOLLOW_RULE_MINUSOP_in_ruleSystemID10831); 

                    	    		current.merge(this_MinusOp_3);
                    	        
                    	     
                    	        newLeafNode(this_MinusOp_3, grammarAccess.getSystemIDAccess().getMinusOpTerminalRuleCall_1_1_0_0()); 
                    	        

                    	    }
                    	    break;
                    	case 2 :
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4703:10: this_INT_4= RULE_INT
                    	    {
                    	    this_INT_4=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSystemID10857); 

                    	    		current.merge(this_INT_4);
                    	        
                    	     
                    	        newLeafNode(this_INT_4, grammarAccess.getSystemIDAccess().getINTTerminalRuleCall_1_1_0_1()); 
                    	        

                    	    }
                    	    break;
                    	case 3 :
                    	    // ../edu.csu.melange.alphabets/src-gen/edu/csu/melange/alphabets/xtext/parser/antlr/internal/InternalAlphabets.g:4711:10: this_ID_5= RULE_ID
                    	    {
                    	    this_ID_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSystemID10883); 

                    	    		current.merge(this_ID_5);
                    	        
                    	     
                    	        newLeafNode(this_ID_5, grammarAccess.getSystemIDAccess().getIDTerminalRuleCall_1_1_0_2()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop90;
                        }
                    } while (true);

                    this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSystemID10905); 

                    		current.merge(this_ID_6);
                        
                     
                        newLeafNode(this_ID_6, grammarAccess.getSystemIDAccess().getIDTerminalRuleCall_1_1_1()); 
                        

                    }


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
    // $ANTLR end "ruleSystemID"

    // Delegated rules


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA31 dfa31 = new DFA31(this);
    protected DFA41 dfa41 = new DFA41(this);
    protected DFA48 dfa48 = new DFA48(this);
    static final String DFA5_eotS =
        "\u00d9\uffff";
    static final String DFA5_eofS =
        "\u00d9\uffff";
    static final String DFA5_minS =
        "\1\44\7\4\1\41\4\4\1\7\1\4\1\5\1\41\13\4\1\41\1\60\3\uffff\2\4\1\7\2\4\1\25\2\4\1\6\2\4\1\25\7\4\1\41\2\4\2\41\3\4\1\6\2\4\1\7\3\4\1\6\1\4\1\6\3\4\1\7\1\4\1\5\13\4\1\41\2\4\2\41\13\4\1\41\2\4\1\25\2\4\1\6\3\4\1\7\1\4\1\25\2\4\1\25\2\4\1\6\3\4\1\7\1\4\1\25\5\4\1\41\2\4\1\41\6\4\1\41\2\4\1\41\2\4\1\6\2\4\1\6\1\4\1\6\2\4\1\6\2\4\1\6\2\4\1\7\2\4\1\6\2\4\1\41\13\4\1\41\2\4\1\41\2\4\1\25\2\4\1\6\3\4\1\7\1\4\1\25\5\4\1\41\2\4\1\41\2\4\1\6\2\4\1\6\1\4\1\6\2\4\1\41";
    static final String DFA5_maxS =
        "\1\44\1\11\1\60\3\11\1\60\2\61\1\62\1\4\1\11\2\41\1\11\1\56\1\61\3\11\6\40\1\11\2\42\1\60\3\uffff\1\11\2\32\1\11\2\41\1\11\2\62\2\11\1\32\1\61\1\11\1\40\3\11\2\42\1\11\2\42\1\61\1\62\1\11\2\62\1\11\2\41\2\11\2\62\1\11\1\62\1\4\1\11\2\41\1\11\1\56\1\11\6\40\3\11\2\42\1\11\2\42\1\61\1\11\6\40\3\11\2\42\1\11\2\41\1\11\2\62\2\11\2\32\1\11\1\32\1\11\2\41\1\11\2\62\2\11\2\32\1\11\1\32\4\11\2\42\1\11\2\42\3\11\1\40\1\11\2\42\1\11\2\42\1\11\2\62\1\11\2\62\1\11\1\62\1\11\2\62\1\11\2\62\1\11\2\41\2\11\1\62\1\11\2\42\1\11\6\40\3\11\2\42\1\11\2\42\1\11\2\41\1\11\2\62\2\11\2\32\1\11\1\32\4\11\2\42\1\11\2\42\1\11\2\62\1\11\2\62\1\11\1\62\1\11\2\42";
    static final String DFA5_acceptS =
        "\36\uffff\2\1\1\2\u00b8\uffff";
    static final String DFA5_specialS =
        "\u00d9\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1",
            "\1\2\4\uffff\1\3",
            "\1\6\3\uffff\1\4\1\5\46\uffff\1\7",
            "\1\6\3\uffff\1\4\1\5",
            "\1\6\3\uffff\1\4\1\5",
            "\1\6\3\uffff\1\4\1\5",
            "\1\6\3\uffff\1\4\1\5\46\uffff\1\7",
            "\1\10\54\uffff\1\11",
            "\1\12\17\uffff\1\11",
            "\1\15\3\uffff\1\13\1\14\26\uffff\1\16\21\uffff\1\17",
            "\1\20",
            "\1\15\4\uffff\1\14",
            "\1\15\2\uffff\1\21\1\22\1\14\13\uffff\1\24\1\25\1\26\1\27\1\30\1\31\6\uffff\1\23",
            "\1\21\1\22\14\uffff\1\24\1\25\1\26\1\27\1\30\1\31\6\uffff\1\23",
            "\1\34\3\uffff\1\32\1\33",
            "\1\35\37\uffff\5\36\1\37\4\40",
            "\1\12\17\uffff\1\11",
            "\1\43\3\uffff\1\41\1\42",
            "\1\43\3\uffff\1\41\1\42",
            "\1\46\3\uffff\1\44\1\45",
            "\1\51\3\uffff\1\47\1\50\26\uffff\1\52",
            "\1\51\3\uffff\1\47\1\50\26\uffff\1\52",
            "\1\51\3\uffff\1\47\1\50\26\uffff\1\52",
            "\1\51\3\uffff\1\47\1\50\26\uffff\1\52",
            "\1\51\3\uffff\1\47\1\50\26\uffff\1\52",
            "\1\51\3\uffff\1\47\1\50\26\uffff\1\52",
            "\1\34\4\uffff\1\33",
            "\1\34\4\uffff\1\33\27\uffff\1\53\1\54",
            "\1\53\1\54",
            "\1\55",
            "",
            "",
            "",
            "\1\43\4\uffff\1\42",
            "\1\43\2\uffff\1\21\1\22\1\42\13\uffff\1\24\1\25\1\26\1\27\1\30\1\31",
            "\1\21\1\22\14\uffff\1\24\1\25\1\26\1\27\1\30\1\31",
            "\1\46\4\uffff\1\45",
            "\1\46\4\uffff\1\45\13\uffff\1\24\1\25\1\26\1\27\1\30\1\31\6\uffff\1\23",
            "\1\24\1\25\1\26\1\27\1\30\1\31\6\uffff\1\23",
            "\1\51\4\uffff\1\50",
            "\1\51\1\uffff\1\57\1\60\1\61\1\50\13\uffff\1\24\1\25\1\26\1\27\1\30\1\31\6\uffff\1\56\20\uffff\1\17",
            "\1\57\1\60\1\61\14\uffff\1\24\1\25\1\26\1\27\1\30\1\31\6\uffff\1\56\20\uffff\1\17",
            "\1\64\3\uffff\1\62\1\63",
            "\1\67\3\uffff\1\65\1\66",
            "\1\24\1\25\1\26\1\27\1\30\1\31",
            "\1\70\54\uffff\1\71",
            "\1\74\3\uffff\1\72\1\73",
            "\1\77\3\uffff\1\75\1\76\26\uffff\1\100",
            "\1\103\3\uffff\1\101\1\102",
            "\1\103\3\uffff\1\101\1\102",
            "\1\64\4\uffff\1\63",
            "\1\64\4\uffff\1\63\27\uffff\1\104\1\105",
            "\1\104\1\105",
            "\1\67\4\uffff\1\66",
            "\1\67\4\uffff\1\66\27\uffff\1\53\1\54",
            "\1\53\1\54",
            "\1\106\17\uffff\1\71",
            "\1\111\3\uffff\1\107\1\110\26\uffff\1\112\21\uffff\1\113",
            "\1\74\4\uffff\1\73",
            "\1\74\1\uffff\1\57\2\uffff\1\73\13\uffff\1\24\1\25\1\26\1\27\1\30\1\31\6\uffff\1\56\20\uffff\1\17",
            "\1\57\16\uffff\1\24\1\25\1\26\1\27\1\30\1\31\6\uffff\1\56\20\uffff\1\17",
            "\1\77\4\uffff\1\76",
            "\1\77\2\uffff\1\123\1\124\1\76\13\uffff\1\115\1\116\1\117\1\120\1\121\1\122\6\uffff\1\114",
            "\1\123\1\124\14\uffff\1\115\1\116\1\117\1\120\1\121\1\122\6\uffff\1\114",
            "\1\127\3\uffff\1\125\1\126",
            "\1\103\4\uffff\1\102",
            "\1\103\1\uffff\1\57\1\60\1\61\1\102\13\uffff\1\24\1\25\1\26\1\27\1\30\1\31\27\uffff\1\17",
            "\1\57\1\60\1\61\14\uffff\1\24\1\25\1\26\1\27\1\30\1\31\27\uffff\1\17",
            "\1\132\3\uffff\1\130\1\131",
            "\1\57\16\uffff\1\24\1\25\1\26\1\27\1\30\1\31\27\uffff\1\17",
            "\1\133",
            "\1\111\4\uffff\1\110",
            "\1\111\2\uffff\1\143\1\144\1\110\13\uffff\1\135\1\136\1\137\1\140\1\141\1\142\6\uffff\1\134",
            "\1\143\1\144\14\uffff\1\135\1\136\1\137\1\140\1\141\1\142\6\uffff\1\134",
            "\1\147\3\uffff\1\145\1\146",
            "\1\35\37\uffff\1\36\5\37\4\40",
            "\1\152\3\uffff\1\150\1\151",
            "\1\155\3\uffff\1\153\1\154\26\uffff\1\156",
            "\1\155\3\uffff\1\153\1\154\26\uffff\1\156",
            "\1\155\3\uffff\1\153\1\154\26\uffff\1\156",
            "\1\155\3\uffff\1\153\1\154\26\uffff\1\156",
            "\1\155\3\uffff\1\153\1\154\26\uffff\1\156",
            "\1\155\3\uffff\1\153\1\154\26\uffff\1\156",
            "\1\161\3\uffff\1\157\1\160",
            "\1\161\3\uffff\1\157\1\160",
            "\1\127\4\uffff\1\126",
            "\1\127\4\uffff\1\126\27\uffff\1\162\1\163",
            "\1\162\1\163",
            "\1\132\4\uffff\1\131",
            "\1\132\4\uffff\1\131\27\uffff\1\104\1\105",
            "\1\104\1\105",
            "\1\106\17\uffff\1\71",
            "\1\166\3\uffff\1\164\1\165",
            "\1\171\3\uffff\1\167\1\170\26\uffff\1\172",
            "\1\171\3\uffff\1\167\1\170\26\uffff\1\172",
            "\1\171\3\uffff\1\167\1\170\26\uffff\1\172",
            "\1\171\3\uffff\1\167\1\170\26\uffff\1\172",
            "\1\171\3\uffff\1\167\1\170\26\uffff\1\172",
            "\1\171\3\uffff\1\167\1\170\26\uffff\1\172",
            "\1\175\3\uffff\1\173\1\174",
            "\1\175\3\uffff\1\173\1\174",
            "\1\147\4\uffff\1\146",
            "\1\147\4\uffff\1\146\27\uffff\1\176\1\177",
            "\1\176\1\177",
            "\1\152\4\uffff\1\151",
            "\1\152\4\uffff\1\151\13\uffff\1\115\1\116\1\117\1\120\1\121\1\122\6\uffff\1\114",
            "\1\115\1\116\1\117\1\120\1\121\1\122\6\uffff\1\114",
            "\1\155\4\uffff\1\154",
            "\1\155\1\uffff\1\57\1\u0080\1\u0081\1\154\13\uffff\1\115\1\116\1\117\1\120\1\121\1\122\6\uffff\1\u0082\20\uffff\1\17",
            "\1\57\1\u0080\1\u0081\14\uffff\1\115\1\116\1\117\1\120\1\121\1\122\6\uffff\1\u0082\20\uffff\1\17",
            "\1\u0085\3\uffff\1\u0083\1\u0084",
            "\1\161\4\uffff\1\160",
            "\1\161\2\uffff\1\123\1\124\1\160\13\uffff\1\115\1\116\1\117\1\120\1\121\1\122",
            "\1\123\1\124\14\uffff\1\115\1\116\1\117\1\120\1\121\1\122",
            "\1\u0088\3\uffff\1\u0086\1\u0087",
            "\1\115\1\116\1\117\1\120\1\121\1\122",
            "\1\166\4\uffff\1\165",
            "\1\166\4\uffff\1\165\13\uffff\1\135\1\136\1\137\1\140\1\141\1\142\6\uffff\1\134",
            "\1\135\1\136\1\137\1\140\1\141\1\142\6\uffff\1\134",
            "\1\171\4\uffff\1\170",
            "\1\171\1\uffff\1\u008c\1\u0089\1\u008a\1\170\13\uffff\1\135\1\136\1\137\1\140\1\141\1\142\6\uffff\1\u008b\20\uffff\1\113",
            "\1\u008c\1\u0089\1\u008a\14\uffff\1\135\1\136\1\137\1\140\1\141\1\142\6\uffff\1\u008b\20\uffff\1\113",
            "\1\u008f\3\uffff\1\u008d\1\u008e",
            "\1\175\4\uffff\1\174",
            "\1\175\2\uffff\1\143\1\144\1\174\13\uffff\1\135\1\136\1\137\1\140\1\141\1\142",
            "\1\143\1\144\14\uffff\1\135\1\136\1\137\1\140\1\141\1\142",
            "\1\u0092\3\uffff\1\u0090\1\u0091",
            "\1\135\1\136\1\137\1\140\1\141\1\142",
            "\1\u0095\3\uffff\1\u0093\1\u0094",
            "\1\u0095\3\uffff\1\u0093\1\u0094",
            "\1\u0098\3\uffff\1\u0096\1\u0097",
            "\1\u0085\4\uffff\1\u0084",
            "\1\u0085\4\uffff\1\u0084\27\uffff\1\u0099\1\u009a",
            "\1\u0099\1\u009a",
            "\1\u0088\4\uffff\1\u0087",
            "\1\u0088\4\uffff\1\u0087\27\uffff\1\162\1\163",
            "\1\162\1\163",
            "\1\u009d\3\uffff\1\u009b\1\u009c",
            "\1\u009d\3\uffff\1\u009b\1\u009c",
            "\1\u00a0\3\uffff\1\u009e\1\u009f",
            "\1\u00a3\3\uffff\1\u00a1\1\u00a2\26\uffff\1\u00a4",
            "\1\u008f\4\uffff\1\u008e",
            "\1\u008f\4\uffff\1\u008e\27\uffff\1\u00a5\1\u00a6",
            "\1\u00a5\1\u00a6",
            "\1\u0092\4\uffff\1\u0091",
            "\1\u0092\4\uffff\1\u0091\27\uffff\1\176\1\177",
            "\1\176\1\177",
            "\1\u0095\4\uffff\1\u0094",
            "\1\u0095\1\uffff\1\57\1\u0080\1\u0081\1\u0094\13\uffff\1\115\1\116\1\117\1\120\1\121\1\122\27\uffff\1\17",
            "\1\57\1\u0080\1\u0081\14\uffff\1\115\1\116\1\117\1\120\1\121\1\122\27\uffff\1\17",
            "\1\u0098\4\uffff\1\u0097",
            "\1\u0098\1\uffff\1\57\2\uffff\1\u0097\13\uffff\1\115\1\116\1\117\1\120\1\121\1\122\6\uffff\1\u0082\20\uffff\1\17",
            "\1\57\16\uffff\1\115\1\116\1\117\1\120\1\121\1\122\6\uffff\1\u0082\20\uffff\1\17",
            "\1\u00a9\3\uffff\1\u00a7\1\u00a8",
            "\1\57\16\uffff\1\115\1\116\1\117\1\120\1\121\1\122\27\uffff\1\17",
            "\1\u009d\4\uffff\1\u009c",
            "\1\u009d\1\uffff\1\u008c\1\u0089\1\u008a\1\u009c\13\uffff\1\135\1\136\1\137\1\140\1\141\1\142\27\uffff\1\113",
            "\1\u008c\1\u0089\1\u008a\14\uffff\1\135\1\136\1\137\1\140\1\141\1\142\27\uffff\1\113",
            "\1\u00a0\4\uffff\1\u009f",
            "\1\u00a0\1\uffff\1\u008c\2\uffff\1\u009f\13\uffff\1\135\1\136\1\137\1\140\1\141\1\142\6\uffff\1\u008b\20\uffff\1\113",
            "\1\u008c\16\uffff\1\135\1\136\1\137\1\140\1\141\1\142\6\uffff\1\u008b\20\uffff\1\113",
            "\1\u00a3\4\uffff\1\u00a2",
            "\1\u00a3\2\uffff\1\u00b1\1\u00b2\1\u00a2\13\uffff\1\u00ab\1\u00ac\1\u00ad\1\u00ae\1\u00af\1\u00b0\6\uffff\1\u00aa",
            "\1\u00b1\1\u00b2\14\uffff\1\u00ab\1\u00ac\1\u00ad\1\u00ae\1\u00af\1\u00b0\6\uffff\1\u00aa",
            "\1\u00b5\3\uffff\1\u00b3\1\u00b4",
            "\1\u00b8\3\uffff\1\u00b6\1\u00b7",
            "\1\u008c\16\uffff\1\135\1\136\1\137\1\140\1\141\1\142\27\uffff\1\113",
            "\1\u00a9\4\uffff\1\u00a8",
            "\1\u00a9\4\uffff\1\u00a8\27\uffff\1\u0099\1\u009a",
            "\1\u0099\1\u009a",
            "\1\u00bb\3\uffff\1\u00b9\1\u00ba",
            "\1\u00be\3\uffff\1\u00bc\1\u00bd\26\uffff\1\u00bf",
            "\1\u00be\3\uffff\1\u00bc\1\u00bd\26\uffff\1\u00bf",
            "\1\u00be\3\uffff\1\u00bc\1\u00bd\26\uffff\1\u00bf",
            "\1\u00be\3\uffff\1\u00bc\1\u00bd\26\uffff\1\u00bf",
            "\1\u00be\3\uffff\1\u00bc\1\u00bd\26\uffff\1\u00bf",
            "\1\u00be\3\uffff\1\u00bc\1\u00bd\26\uffff\1\u00bf",
            "\1\u00c2\3\uffff\1\u00c0\1\u00c1",
            "\1\u00c2\3\uffff\1\u00c0\1\u00c1",
            "\1\u00b5\4\uffff\1\u00b4",
            "\1\u00b5\4\uffff\1\u00b4\27\uffff\1\u00c3\1\u00c4",
            "\1\u00c3\1\u00c4",
            "\1\u00b8\4\uffff\1\u00b7",
            "\1\u00b8\4\uffff\1\u00b7\27\uffff\1\u00a5\1\u00a6",
            "\1\u00a5\1\u00a6",
            "\1\u00bb\4\uffff\1\u00ba",
            "\1\u00bb\4\uffff\1\u00ba\13\uffff\1\u00ab\1\u00ac\1\u00ad\1\u00ae\1\u00af\1\u00b0\6\uffff\1\u00aa",
            "\1\u00ab\1\u00ac\1\u00ad\1\u00ae\1\u00af\1\u00b0\6\uffff\1\u00aa",
            "\1\u00be\4\uffff\1\u00bd",
            "\1\u00be\1\uffff\1\u008c\1\u00c6\1\u00c7\1\u00bd\13\uffff\1\u00ab\1\u00ac\1\u00ad\1\u00ae\1\u00af\1\u00b0\6\uffff\1\u00c5\20\uffff\1\113",
            "\1\u008c\1\u00c6\1\u00c7\14\uffff\1\u00ab\1\u00ac\1\u00ad\1\u00ae\1\u00af\1\u00b0\6\uffff\1\u00c5\20\uffff\1\113",
            "\1\u00ca\3\uffff\1\u00c8\1\u00c9",
            "\1\u00c2\4\uffff\1\u00c1",
            "\1\u00c2\2\uffff\1\u00b1\1\u00b2\1\u00c1\13\uffff\1\u00ab\1\u00ac\1\u00ad\1\u00ae\1\u00af\1\u00b0",
            "\1\u00b1\1\u00b2\14\uffff\1\u00ab\1\u00ac\1\u00ad\1\u00ae\1\u00af\1\u00b0",
            "\1\u00cd\3\uffff\1\u00cb\1\u00cc",
            "\1\u00ab\1\u00ac\1\u00ad\1\u00ae\1\u00af\1\u00b0",
            "\1\u00d0\3\uffff\1\u00ce\1\u00cf",
            "\1\u00d3\3\uffff\1\u00d1\1\u00d2",
            "\1\u00d3\3\uffff\1\u00d1\1\u00d2",
            "\1\u00ca\4\uffff\1\u00c9",
            "\1\u00ca\4\uffff\1\u00c9\27\uffff\1\u00d4\1\u00d5",
            "\1\u00d4\1\u00d5",
            "\1\u00cd\4\uffff\1\u00cc",
            "\1\u00cd\4\uffff\1\u00cc\27\uffff\1\u00c3\1\u00c4",
            "\1\u00c3\1\u00c4",
            "\1\u00d0\4\uffff\1\u00cf",
            "\1\u00d0\1\uffff\1\u008c\2\uffff\1\u00cf\13\uffff\1\u00ab\1\u00ac\1\u00ad\1\u00ae\1\u00af\1\u00b0\6\uffff\1\u00c5\20\uffff\1\113",
            "\1\u008c\16\uffff\1\u00ab\1\u00ac\1\u00ad\1\u00ae\1\u00af\1\u00b0\6\uffff\1\u00c5\20\uffff\1\113",
            "\1\u00d3\4\uffff\1\u00d2",
            "\1\u00d3\1\uffff\1\u008c\1\u00c6\1\u00c7\1\u00d2\13\uffff\1\u00ab\1\u00ac\1\u00ad\1\u00ae\1\u00af\1\u00b0\27\uffff\1\113",
            "\1\u008c\1\u00c6\1\u00c7\14\uffff\1\u00ab\1\u00ac\1\u00ad\1\u00ae\1\u00af\1\u00b0\27\uffff\1\113",
            "\1\u00d8\3\uffff\1\u00d6\1\u00d7",
            "\1\u008c\16\uffff\1\u00ab\1\u00ac\1\u00ad\1\u00ae\1\u00af\1\u00b0\27\uffff\1\113",
            "\1\u00d8\4\uffff\1\u00d7",
            "\1\u00d8\4\uffff\1\u00d7\27\uffff\1\u00d4\1\u00d5",
            "\1\u00d4\1\u00d5"
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
            return "285:1: (this_AAffineSystemA_0= ruleAAffineSystemA | this_AAffineSystemB_1= ruleAAffineSystemB )";
        }
    }
    static final String DFA30_eotS =
        "\6\uffff";
    static final String DFA30_eofS =
        "\6\uffff";
    static final String DFA30_minS =
        "\3\4\1\7\2\uffff";
    static final String DFA30_maxS =
        "\1\40\1\11\2\41\2\uffff";
    static final String DFA30_acceptS =
        "\4\uffff\1\1\1\2";
    static final String DFA30_specialS =
        "\6\uffff}>";
    static final String[] DFA30_transitionS = {
            "\1\3\3\uffff\1\1\1\2\26\uffff\1\4",
            "\1\3\4\uffff\1\2",
            "\1\3\2\uffff\2\5\1\2\13\uffff\6\4\6\uffff\1\4",
            "\2\5\14\uffff\6\4\6\uffff\1\4",
            "",
            ""
    };

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "1202:2: (this_IDList_0= ruleIDList | this_IDExpression_1= ruleIDExpression )";
        }
    }
    static final String DFA31_eotS =
        "\6\uffff";
    static final String DFA31_eofS =
        "\2\uffff\2\4\2\uffff";
    static final String DFA31_minS =
        "\3\4\1\6\2\uffff";
    static final String DFA31_maxS =
        "\1\40\1\11\2\62\2\uffff";
    static final String DFA31_acceptS =
        "\4\uffff\1\1\1\2";
    static final String DFA31_specialS =
        "\6\uffff}>";
    static final String[] DFA31_transitionS = {
            "\1\3\3\uffff\1\1\1\2\26\uffff\1\4",
            "\1\3\4\uffff\1\2",
            "\1\3\1\uffff\1\4\2\5\1\2\13\uffff\6\4\6\uffff\1\4\20\uffff\1\4",
            "\1\4\2\5\14\uffff\6\4\6\uffff\1\4\20\uffff\1\4",
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
            return "1236:1: (this_IDList_3= ruleIDList | this_IDExpression_4= ruleIDExpression )";
        }
    }
    static final String DFA41_eotS =
        "\4\uffff";
    static final String DFA41_eofS =
        "\1\uffff\1\3\2\uffff";
    static final String DFA41_minS =
        "\2\4\2\uffff";
    static final String DFA41_maxS =
        "\1\11\1\62\2\uffff";
    static final String DFA41_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA41_specialS =
        "\4\uffff}>";
    static final String[] DFA41_transitionS = {
            "\1\2\4\uffff\1\1",
            "\1\2\1\uffff\3\3\1\1\13\uffff\6\3\6\uffff\2\3\17\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA41_eot = DFA.unpackEncodedString(DFA41_eotS);
    static final short[] DFA41_eof = DFA.unpackEncodedString(DFA41_eofS);
    static final char[] DFA41_min = DFA.unpackEncodedStringToUnsignedChars(DFA41_minS);
    static final char[] DFA41_max = DFA.unpackEncodedStringToUnsignedChars(DFA41_maxS);
    static final short[] DFA41_accept = DFA.unpackEncodedString(DFA41_acceptS);
    static final short[] DFA41_special = DFA.unpackEncodedString(DFA41_specialS);
    static final short[][] DFA41_transition;

    static {
        int numStates = DFA41_transitionS.length;
        DFA41_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA41_transition[i] = DFA.unpackEncodedString(DFA41_transitionS[i]);
        }
    }

    class DFA41 extends DFA {

        public DFA41(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 41;
            this.eot = DFA41_eot;
            this.eof = DFA41_eof;
            this.min = DFA41_min;
            this.max = DFA41_max;
            this.accept = DFA41_accept;
            this.special = DFA41_special;
            this.transition = DFA41_transition;
        }
        public String getDescription() {
            return "1435:3: ( (this_INT_1= RULE_INT )+ | ( (this_INT_2= RULE_INT )* this_ID_3= RULE_ID ) )";
        }
    }
    static final String DFA48_eotS =
        "\15\uffff";
    static final String DFA48_eofS =
        "\5\uffff\1\13\7\uffff";
    static final String DFA48_minS =
        "\2\4\3\uffff\1\7\3\uffff\1\7\3\uffff";
    static final String DFA48_maxS =
        "\2\100\3\uffff\1\75\3\uffff\1\77\3\uffff";
    static final String DFA48_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\uffff\1\5\1\7\1\1\1\uffff\1\10\1\6\1\11";
    static final String DFA48_specialS =
        "\15\uffff}>";
    static final String[] DFA48_transitionS = {
            "\1\5\2\uffff\1\4\1\uffff\1\6\3\4\2\uffff\1\4\1\uffff\2\4\2\6\13\uffff\1\1\22\uffff\1\7\4\uffff\1\2\5\uffff\1\7\1\uffff\1\3",
            "\1\11\2\uffff\6\10\2\uffff\1\10\1\uffff\4\10\13\uffff\1\10\17\uffff\1\10\2\uffff\1\10\3\uffff\2\10\2\uffff\1\10\2\uffff\1\10\1\12\1\10",
            "",
            "",
            "",
            "\2\13\1\uffff\11\13\2\uffff\6\13\5\uffff\1\4\3\13\5\uffff\2\13\10\uffff\1\14\10\uffff\2\13",
            "",
            "",
            "",
            "\2\10\1\uffff\11\10\2\uffff\6\10\5\uffff\1\10\1\12\1\10\20\uffff\1\10\13\uffff\1\12",
            "",
            "",
            ""
    };

    static final short[] DFA48_eot = DFA.unpackEncodedString(DFA48_eotS);
    static final short[] DFA48_eof = DFA.unpackEncodedString(DFA48_eofS);
    static final char[] DFA48_min = DFA.unpackEncodedStringToUnsignedChars(DFA48_minS);
    static final char[] DFA48_max = DFA.unpackEncodedStringToUnsignedChars(DFA48_maxS);
    static final short[] DFA48_accept = DFA.unpackEncodedString(DFA48_acceptS);
    static final short[] DFA48_special = DFA.unpackEncodedString(DFA48_specialS);
    static final short[][] DFA48_transition;

    static {
        int numStates = DFA48_transitionS.length;
        DFA48_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA48_transition[i] = DFA.unpackEncodedString(DFA48_transitionS[i]);
        }
    }

    class DFA48 extends DFA {

        public DFA48(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 48;
            this.eot = DFA48_eot;
            this.eof = DFA48_eof;
            this.min = DFA48_min;
            this.max = DFA48_max;
            this.accept = DFA48_accept;
            this.special = DFA48_special;
            this.transition = DFA48_transition;
        }
        public String getDescription() {
            return "1820:1: (this_AParanthesizedAlphabetsExpression_0= ruleAParanthesizedAlphabetsExpression | this_ACaseExpression_1= ruleACaseExpression | this_AReduceExpression_2= ruleAReduceExpression | this_AMultiArgExpression_3= ruleAMultiArgExpression | this_AConstantExpression_4= ruleAConstantExpression | this_AVariableExpression_5= ruleAVariableExpression | this_AIndexExpression_6= ruleAIndexExpression | this_ADependenceExpression_7= ruleADependenceExpression | this_ADependenceInArrayNotation_8= ruleADependenceInArrayNotation )";
        }
    }
 

    public static final BitSet FOLLOW_ruleAProgram_in_entryRuleAProgram75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAProgram85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAExternalFunctionDeclaration_in_ruleAProgram131 = new BitSet(new long[]{0x0000001000000000L,0x00000000000007FCL});
    public static final BitSet FOLLOW_ruleAAffineSystem_in_ruleAProgram153 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_ruleAExternalFunctionDeclaration_in_entryRuleAExternalFunctionDeclaration190 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAExternalFunctionDeclaration200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAType_in_ruleAExternalFunctionDeclaration246 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAExternalFunctionIdentifier_in_ruleAExternalFunctionDeclaration267 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleAExternalFunctionDeclaration279 = new BitSet(new long[]{0x0000001600000000L,0x00000000000007FCL});
    public static final BitSet FOLLOW_ruleAType_in_ruleAExternalFunctionDeclaration300 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_33_in_ruleAExternalFunctionDeclaration314 = new BitSet(new long[]{0x0000001000000000L,0x00000000000007FCL});
    public static final BitSet FOLLOW_ruleAType_in_ruleAExternalFunctionDeclaration335 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_34_in_ruleAExternalFunctionDeclaration349 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleAExternalFunctionDeclaration361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAExternalFunctionIdentifier_in_entryRuleAExternalFunctionIdentifier397 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAExternalFunctionIdentifier407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAExternalFunctionIdentifier448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAffineSystem_in_entryRuleAAffineSystem488 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAAffineSystem498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAffineSystemA_in_ruleAAffineSystem545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAffineSystemB_in_ruleAAffineSystem572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAffineSystemA_in_entryRuleAAffineSystemA607 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAAffineSystemA617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleAAffineSystemA654 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_ruleSystemID_in_ruleAAffineSystemA675 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_ruleADomain_in_ruleAAffineSystemA696 = new BitSet(new long[]{0x000007E000000000L});
    public static final BitSet FOLLOW_37_in_ruleAAffineSystemA710 = new BitSet(new long[]{0x000007D000000000L,0x00000000000007FCL});
    public static final BitSet FOLLOW_ruleAInputDeclaration_in_ruleAAffineSystemA731 = new BitSet(new long[]{0x000007D000000000L,0x00000000000007FCL});
    public static final BitSet FOLLOW_38_in_ruleAAffineSystemA747 = new BitSet(new long[]{0x0000079000000000L,0x00000000000007FCL});
    public static final BitSet FOLLOW_ruleAOutputDeclaration_in_ruleAAffineSystemA768 = new BitSet(new long[]{0x0000079000000000L,0x00000000000007FCL});
    public static final BitSet FOLLOW_39_in_ruleAAffineSystemA784 = new BitSet(new long[]{0x0000071000000000L,0x00000000000007FCL});
    public static final BitSet FOLLOW_ruleALocalDeclaration_in_ruleAAffineSystemA805 = new BitSet(new long[]{0x0000071000000000L,0x00000000000007FCL});
    public static final BitSet FOLLOW_40_in_ruleAAffineSystemA821 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_ruleAWhileDeclaration_in_ruleAAffineSystemA842 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_41_in_ruleAAffineSystemA857 = new BitSet(new long[]{0x0040040000000010L});
    public static final BitSet FOLLOW_ruleAEquation_in_ruleAAffineSystemA879 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleAAffineSystemA891 = new BitSet(new long[]{0x0040040000000010L});
    public static final BitSet FOLLOW_42_in_ruleAAffineSystemA908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAffineSystemB_in_entryRuleAAffineSystemB944 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAAffineSystemB954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleAAffineSystemB991 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_ruleSystemID_in_ruleAAffineSystemB1012 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_ruleADomain_in_ruleAAffineSystemB1033 = new BitSet(new long[]{0x00007C0000000000L});
    public static final BitSet FOLLOW_43_in_ruleAAffineSystemB1047 = new BitSet(new long[]{0x0000741000000000L,0x00000000000007FCL});
    public static final BitSet FOLLOW_ruleAInputDeclaration_in_ruleAAffineSystemB1068 = new BitSet(new long[]{0x0000741000000000L,0x00000000000007FCL});
    public static final BitSet FOLLOW_44_in_ruleAAffineSystemB1084 = new BitSet(new long[]{0x0000641000000000L,0x00000000000007FCL});
    public static final BitSet FOLLOW_ruleAOutputDeclaration_in_ruleAAffineSystemB1105 = new BitSet(new long[]{0x0000641000000000L,0x00000000000007FCL});
    public static final BitSet FOLLOW_45_in_ruleAAffineSystemB1121 = new BitSet(new long[]{0x0000441000000000L,0x00000000000007FCL});
    public static final BitSet FOLLOW_ruleALocalDeclaration_in_ruleAAffineSystemB1142 = new BitSet(new long[]{0x0000441000000000L,0x00000000000007FCL});
    public static final BitSet FOLLOW_46_in_ruleAAffineSystemB1158 = new BitSet(new long[]{0x0040040000000010L});
    public static final BitSet FOLLOW_ruleAEquation_in_ruleAAffineSystemB1180 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleAAffineSystemB1192 = new BitSet(new long[]{0x0040040000000010L});
    public static final BitSet FOLLOW_42_in_ruleAAffineSystemB1209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAOutputDeclaration_in_entryRuleAOutputDeclaration1247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAOutputDeclaration1257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAType_in_ruleAOutputDeclaration1303 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAIdentifierList_in_ruleAOutputDeclaration1324 = new BitSet(new long[]{0x0001000800000000L});
    public static final BitSet FOLLOW_ruleADomain_in_ruleAOutputDeclaration1345 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleAOutputDeclaration1358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAInputDeclaration_in_entryRuleAInputDeclaration1394 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAInputDeclaration1404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAType_in_ruleAInputDeclaration1450 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAIdentifierList_in_ruleAInputDeclaration1471 = new BitSet(new long[]{0x0001000800000000L});
    public static final BitSet FOLLOW_ruleADomain_in_ruleAInputDeclaration1492 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleAInputDeclaration1505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleALocalDeclaration_in_entryRuleALocalDeclaration1541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleALocalDeclaration1551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAType_in_ruleALocalDeclaration1597 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAIdentifierList_in_ruleALocalDeclaration1618 = new BitSet(new long[]{0x0001000800000000L});
    public static final BitSet FOLLOW_ruleADomain_in_ruleALocalDeclaration1639 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleALocalDeclaration1652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAWhileDeclaration_in_entryRuleAWhileDeclaration1688 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAWhileDeclaration1698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleADomain_in_ruleAWhileDeclaration1744 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleAWhileDeclaration1756 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleAWhileDeclaration1777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIdentifierList_in_entryRuleAIdentifierList1813 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAIdentifierList1823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableIdentifier_in_ruleAIdentifierList1869 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleAIdentifierList1882 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVariableIdentifier_in_ruleAIdentifierList1903 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ruleVariableIdentifier_in_entryRuleVariableIdentifier1942 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableIdentifier1953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableIdentifier1992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleADomain_in_entryRuleADomain2036 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleADomain2046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAPolyhedron_in_ruleADomain2092 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_UNION_in_ruleADomain2104 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_ruleAPolyhedron_in_ruleADomain2124 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleAPolyhedron_in_entryRuleAPolyhedron2162 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAPolyhedron2172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleAPolyhedron2209 = new BitSet(new long[]{0x0002000000000010L});
    public static final BitSet FOLLOW_ruleAIndexList_in_ruleAPolyhedron2230 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleAPolyhedron2242 = new BitSet(new long[]{0x0004000100000310L});
    public static final BitSet FOLLOW_ruleInEquality_in_ruleAPolyhedron2264 = new BitSet(new long[]{0x0004000000000040L});
    public static final BitSet FOLLOW_RULE_INTERSECTION_in_ruleAPolyhedron2276 = new BitSet(new long[]{0x0000000100000310L});
    public static final BitSet FOLLOW_ruleInEquality_in_ruleAPolyhedron2296 = new BitSet(new long[]{0x0004000000000040L});
    public static final BitSet FOLLOW_50_in_ruleAPolyhedron2312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInEquality_in_entryRuleInEquality2349 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInEquality2360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDList_in_ruleInEquality2408 = new BitSet(new long[]{0x0000000007E00000L});
    public static final BitSet FOLLOW_ruleIDExpression_in_ruleInEquality2441 = new BitSet(new long[]{0x0000000007E00000L});
    public static final BitSet FOLLOW_ruleRelationalOp_in_ruleInEquality2470 = new BitSet(new long[]{0x0000000100000310L});
    public static final BitSet FOLLOW_ruleIDList_in_ruleInEquality2498 = new BitSet(new long[]{0x0000000007E00002L});
    public static final BitSet FOLLOW_ruleIDExpression_in_ruleInEquality2531 = new BitSet(new long[]{0x0000000007E00002L});
    public static final BitSet FOLLOW_ruleIDList_in_entryRuleIDList2580 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIDList2591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInEqID_in_ruleIDList2639 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleIDList2658 = new BitSet(new long[]{0x0000000000000310L});
    public static final BitSet FOLLOW_ruleInEqID_in_ruleIDList2680 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_32_in_ruleIDList2708 = new BitSet(new long[]{0x0000000000000310L});
    public static final BitSet FOLLOW_ruleInEqID_in_ruleIDList2730 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_33_in_ruleIDList2749 = new BitSet(new long[]{0x0000000000000310L});
    public static final BitSet FOLLOW_ruleInEqID_in_ruleIDList2771 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_34_in_ruleIDList2791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIDExpression_in_entryRuleIDExpression2833 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIDExpression2844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInEqID_in_ruleIDExpression2891 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_RULE_PLUSOP_in_ruleIDExpression2913 = new BitSet(new long[]{0x0000000000000310L});
    public static final BitSet FOLLOW_RULE_MINUSOP_in_ruleIDExpression2939 = new BitSet(new long[]{0x0000000000000310L});
    public static final BitSet FOLLOW_ruleInEqID_in_ruleIDExpression2967 = new BitSet(new long[]{0x0000000000000182L});
    public static final BitSet FOLLOW_ruleInEqID_in_entryRuleInEqID3015 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInEqID3026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MINUSOP_in_ruleInEqID3067 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleInEqID3091 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleInEqID3121 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInEqID3143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAEquation_in_entryRuleAEquation3190 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAEquation3200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAStandardEquation_in_ruleAEquation3247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAUseEquation_in_ruleAEquation3274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAStandardEquation_in_entryRuleAStandardEquation3309 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAStandardEquation3319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAStandardEquation3361 = new BitSet(new long[]{0x0028000000000000L});
    public static final BitSet FOLLOW_51_in_ruleAStandardEquation3379 = new BitSet(new long[]{0x0010000000000010L});
    public static final BitSet FOLLOW_ruleAIndexList_in_ruleAStandardEquation3400 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_ruleAStandardEquation3412 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleAStandardEquation3426 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleAStandardEquation3447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAUseEquation_in_entryRuleAUseEquation3483 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAUseEquation3493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleAUseEquation3530 = new BitSet(new long[]{0x0001000000000010L});
    public static final BitSet FOLLOW_ruleADomain_in_ruleAUseEquation3551 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAUseEquation3569 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleAUseEquation3586 = new BitSet(new long[]{0x0010000000000310L});
    public static final BitSet FOLLOW_ruleAIndexAffineExpressionList_in_ruleAUseEquation3607 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_ruleAUseEquation3619 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleAUseEquation3631 = new BitSet(new long[]{0x49890007001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleAUseEquation3652 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_33_in_ruleAUseEquation3666 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleAUseEquation3687 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_34_in_ruleAUseEquation3701 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleAUseEquation3713 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleAUseEquation3725 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAIdentifierList_in_ruleAUseEquation3746 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleAUseEquation3758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_entryRuleAAlphabetsExpression3794 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAAlphabetsExpression3804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIfExpression_in_ruleAAlphabetsExpression3851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARestrictExpression_in_ruleAAlphabetsExpression3878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAOrExpression_in_ruleAAlphabetsExpression3905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAlphabetsTerminalExpression_in_entryRuleAAlphabetsTerminalExpression3940 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAAlphabetsTerminalExpression3950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAParanthesizedAlphabetsExpression_in_ruleAAlphabetsTerminalExpression3997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleACaseExpression_in_ruleAAlphabetsTerminalExpression4024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAReduceExpression_in_ruleAAlphabetsTerminalExpression4051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAMultiArgExpression_in_ruleAAlphabetsTerminalExpression4078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAConstantExpression_in_ruleAAlphabetsTerminalExpression4105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAVariableExpression_in_ruleAAlphabetsTerminalExpression4132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIndexExpression_in_ruleAAlphabetsTerminalExpression4159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleADependenceExpression_in_ruleAAlphabetsTerminalExpression4186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleADependenceInArrayNotation_in_ruleAAlphabetsTerminalExpression4213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAParanthesizedAlphabetsExpression_in_entryRuleAParanthesizedAlphabetsExpression4248 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAParanthesizedAlphabetsExpression4258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleAParanthesizedAlphabetsExpression4295 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleAParanthesizedAlphabetsExpression4317 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleAParanthesizedAlphabetsExpression4328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAOrExpression_in_entryRuleAOrExpression4364 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAOrExpression4374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAndExpression_in_ruleAOrExpression4421 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_RULE_OROP_in_ruleAOrExpression4449 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_RULE_XOROP_in_ruleAOrExpression4469 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAndExpression_in_ruleAOrExpression4498 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_ruleAAndExpression_in_entryRuleAAndExpression4536 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAAndExpression4546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARelationalExpression_in_ruleAAndExpression4593 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_RULE_ANDOP_in_ruleAAndExpression4621 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_RULE_NANDOP_in_ruleAAndExpression4641 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleARelationalExpression_in_ruleAAndExpression4670 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_ruleARelationalExpression_in_entryRuleARelationalExpression4708 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleARelationalExpression4718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAdditiveExpression_in_ruleARelationalExpression4765 = new BitSet(new long[]{0x0000000007E00002L});
    public static final BitSet FOLLOW_ruleRelationalOp_in_ruleARelationalExpression4795 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAdditiveExpression_in_ruleARelationalExpression4816 = new BitSet(new long[]{0x0000000007E00002L});
    public static final BitSet FOLLOW_ruleAAdditiveExpression_in_entryRuleAAdditiveExpression4854 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAAdditiveExpression4864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAModuloExpression_in_ruleAAdditiveExpression4911 = new BitSet(new long[]{0x0000000000000182L});
    public static final BitSet FOLLOW_RULE_PLUSOP_in_ruleAAdditiveExpression4939 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_RULE_MINUSOP_in_ruleAAdditiveExpression4959 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAModuloExpression_in_ruleAAdditiveExpression4988 = new BitSet(new long[]{0x0000000000000182L});
    public static final BitSet FOLLOW_ruleAModuloExpression_in_entryRuleAModuloExpression5026 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAModuloExpression5036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAMultiplicativeExpression_in_ruleAModuloExpression5083 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_RULE_MODOP_in_ruleAModuloExpression5109 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAMultiplicativeExpression_in_ruleAModuloExpression5135 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleAMultiplicativeExpression_in_entryRuleAMultiplicativeExpression5173 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAMultiplicativeExpression5183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAMinMaxExpression_in_ruleAMultiplicativeExpression5230 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_RULE_MULOP_in_ruleAMultiplicativeExpression5258 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_RULE_DIVOP_in_ruleAMultiplicativeExpression5278 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAMinMaxExpression_in_ruleAMultiplicativeExpression5307 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_ruleAMinMaxExpression_in_entryRuleAMinMaxExpression5345 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAMinMaxExpression5355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAUnaryOrTerminalExpression_in_ruleAMinMaxExpression5402 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_RULE_MINOP_in_ruleAMinMaxExpression5430 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_RULE_MAXOP_in_ruleAMinMaxExpression5450 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAUnaryOrTerminalExpression_in_ruleAMinMaxExpression5479 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_ruleAUnaryOrTerminalExpression_in_entryRuleAUnaryOrTerminalExpression5517 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAUnaryOrTerminalExpression5527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAUnaryExpression_in_ruleAUnaryOrTerminalExpression5574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAAlphabetsTerminalExpression_in_ruleAUnaryOrTerminalExpression5601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAUnaryExpression_in_entryRuleAUnaryExpression5636 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAUnaryExpression5646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleANotExpression_in_ruleAUnaryExpression5693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleANegateExpression_in_ruleAUnaryExpression5720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleANotExpression_in_entryRuleANotExpression5755 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleANotExpression5765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleANotExpression5808 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAlphabetsTerminalExpression_in_ruleANotExpression5842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleANegateExpression_in_entryRuleANegateExpression5878 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleANegateExpression5888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MINUSOP_in_ruleANegateExpression5930 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAlphabetsTerminalExpression_in_ruleANegateExpression5956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleACaseExpression_in_entryRuleACaseExpression5992 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleACaseExpression6002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleACaseExpression6039 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleACaseExpression6061 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleACaseExpression6073 = new BitSet(new long[]{0x4B890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_57_in_ruleACaseExpression6087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleADependenceExpression_in_entryRuleADependenceExpression6123 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleADependenceExpression6133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAFunction_in_ruleADependenceExpression6179 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_ruleADependenceExpression6191 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAlphabetsTerminalExpression_in_ruleADependenceExpression6212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleADependenceInArrayNotation_in_entryRuleADependenceInArrayNotation6248 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleADependenceInArrayNotation6258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableIdentifier_in_ruleADependenceInArrayNotation6304 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleADependenceInArrayNotation6316 = new BitSet(new long[]{0x0010000000000310L});
    public static final BitSet FOLLOW_ruleAIndexAffineExpressionList_in_ruleADependenceInArrayNotation6337 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_ruleADependenceInArrayNotation6349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIfExpression_in_entryRuleAIfExpression6385 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAIfExpression6395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleAIfExpression6432 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleAIfExpression6453 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_ruleAIfExpression6465 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleAIfExpression6486 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_ruleAIfExpression6498 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleAIfExpression6519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIndexExpression_in_entryRuleAIndexExpression6555 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAIndexExpression6565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleAIndexExpression6603 = new BitSet(new long[]{0x0000000000000310L});
    public static final BitSet FOLLOW_ruleIndexAffineExpression_in_ruleAIndexExpression6624 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_ruleAIndexExpression6636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleAIndexExpression6656 = new BitSet(new long[]{0x8000000000000010L});
    public static final BitSet FOLLOW_ruleAIndexList_in_ruleAIndexExpression6677 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_ruleAIndexExpression6689 = new BitSet(new long[]{0x0000000000000310L});
    public static final BitSet FOLLOW_ruleIndexAffineExpression_in_ruleAIndexExpression6710 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleAIndexExpression6722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAReduceExpression_in_entryRuleAReduceExpression6759 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAReduceExpression6769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleAReduceExpression6806 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleAReduceExpression6818 = new BitSet(new long[]{0x0000000000069C80L});
    public static final BitSet FOLLOW_ruleReductionOp_in_ruleAReduceExpression6839 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleAReduceExpression6851 = new BitSet(new long[]{0x0008000100000000L});
    public static final BitSet FOLLOW_ruleAFunction_in_ruleAReduceExpression6874 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_ruleAFunctionInArrayNotation_in_ruleAReduceExpression6893 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleAReduceExpression6908 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleAReduceExpression6929 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleAReduceExpression6941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARestrictExpression_in_entryRuleARestrictExpression6977 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleARestrictExpression6987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleADomain_in_ruleARestrictExpression7033 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleARestrictExpression7045 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleARestrictExpression7066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAVariableExpression_in_entryRuleAVariableExpression7102 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAVariableExpression7112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableIdentifier_in_ruleAVariableExpression7157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAConstantExpression_in_entryRuleAConstantExpression7192 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAConstantExpression7202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleABooleanExpression_in_ruleAConstantExpression7249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARealExpression_in_ruleAConstantExpression7276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIntegerExpression_in_ruleAConstantExpression7303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleABooleanExpression_in_entryRuleABooleanExpression7338 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleABooleanExpression7348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOLEAN_in_ruleABooleanExpression7389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIntegerExpression_in_entryRuleAIntegerExpression7429 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAIntegerExpression7439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAIntegerExpression7480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleARealExpression_in_entryRuleARealExpression7520 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleARealExpression7530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REAL_in_ruleARealExpression7571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAMultiArgExpression_in_entryRuleAMultiArgExpression7611 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAMultiArgExpression7621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAMultiArgArithmeticExpression_in_ruleAMultiArgExpression7668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAMultiArgLogicalExpression_in_ruleAMultiArgExpression7695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAExternalFunctionCall_in_ruleAMultiArgExpression7722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAMultiArgArithmeticExpression_in_entryRuleAMultiArgArithmeticExpression7757 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAMultiArgArithmeticExpression7767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArithmeticOp_in_ruleAMultiArgArithmeticExpression7813 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleAMultiArgArithmeticExpression7825 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleAMultiArgArithmeticExpression7846 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleAMultiArgArithmeticExpression7859 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleAMultiArgArithmeticExpression7880 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_34_in_ruleAMultiArgArithmeticExpression7894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAMultiArgLogicalExpression_in_entryRuleAMultiArgLogicalExpression7930 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAMultiArgLogicalExpression7940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOp_in_ruleAMultiArgLogicalExpression7986 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleAMultiArgLogicalExpression7998 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleAMultiArgLogicalExpression8019 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleAMultiArgLogicalExpression8032 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleAMultiArgLogicalExpression8053 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_34_in_ruleAMultiArgLogicalExpression8067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAExternalFunctionCall_in_entryRuleAExternalFunctionCall8103 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAExternalFunctionCall8113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAExternalFunctionCall8155 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleAExternalFunctionCall8172 = new BitSet(new long[]{0x49890005001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleAExternalFunctionCall8194 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_33_in_ruleAExternalFunctionCall8207 = new BitSet(new long[]{0x49890001001E9F90L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleAAlphabetsExpression_in_ruleAExternalFunctionCall8228 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_34_in_ruleAExternalFunctionCall8244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIndexIdentifier_in_entryRuleIndexIdentifier8281 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIndexIdentifier8292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIndexIdentifier8331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIndexList_in_entryRuleAIndexList8375 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAIndexList8385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIndexIdentifier_in_ruleAIndexList8441 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleAIndexList8454 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleIndexIdentifier_in_ruleAIndexList8475 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ruleIndexAffineExpression_in_entryRuleIndexAffineExpression8516 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIndexAffineExpression8527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MINUSOP_in_ruleIndexAffineExpression8568 = new BitSet(new long[]{0x0000000000000310L});
    public static final BitSet FOLLOW_ruleIndexAffineExpressionTerminal_in_ruleIndexAffineExpression8597 = new BitSet(new long[]{0x0000000000000182L});
    public static final BitSet FOLLOW_RULE_PLUSOP_in_ruleIndexAffineExpression8619 = new BitSet(new long[]{0x0000000000000310L});
    public static final BitSet FOLLOW_RULE_MINUSOP_in_ruleIndexAffineExpression8645 = new BitSet(new long[]{0x0000000000000310L});
    public static final BitSet FOLLOW_ruleIndexAffineExpression_in_ruleIndexAffineExpression8673 = new BitSet(new long[]{0x0000000000000182L});
    public static final BitSet FOLLOW_ruleIndexAffineExpressionTerminal_in_entryRuleIndexAffineExpressionTerminal8721 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIndexAffineExpressionTerminal8732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIndexAffineExpressionTerminal8772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIndexAffineExpressionTerminal8800 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleIndexIdentifier_in_ruleIndexAffineExpressionTerminal8829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAIndexAffineExpressionList_in_entryRuleAIndexAffineExpressionList8875 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAIndexAffineExpressionList8885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIndexAffineExpression_in_ruleAIndexAffineExpressionList8941 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleAIndexAffineExpressionList8954 = new BitSet(new long[]{0x0000000000000310L});
    public static final BitSet FOLLOW_ruleIndexAffineExpression_in_ruleAIndexAffineExpressionList8975 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ruleAFunction_in_entryRuleAFunction9015 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAFunction9025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleAFunction9062 = new BitSet(new long[]{0x8000000000000010L});
    public static final BitSet FOLLOW_ruleAIndexList_in_ruleAFunction9083 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_ruleAFunction9095 = new BitSet(new long[]{0x0000000400000310L});
    public static final BitSet FOLLOW_ruleAIndexAffineExpressionList_in_ruleAFunction9116 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleAFunction9128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAFunctionInArrayNotation_in_entryRuleAFunctionInArrayNotation9164 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAFunctionInArrayNotation9174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleAFunctionInArrayNotation9211 = new BitSet(new long[]{0x0010000000000310L});
    public static final BitSet FOLLOW_ruleAIndexAffineExpressionList_in_ruleAFunctionInArrayNotation9232 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_ruleAFunctionInArrayNotation9244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAType_in_entryRuleAType9280 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAType9290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleAType9333 = new BitSet(new long[]{0x0000001000000000L,0x00000000000007FCL});
    public static final BitSet FOLLOW_ruleATypeInteger_in_ruleAType9370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleATypeFloat_in_ruleAType9389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleATypeBoolean_in_ruleAType9408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleATypeChar_in_ruleAType9427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleATypeInteger_in_entryRuleATypeInteger9467 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleATypeInteger9478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleATypeInteger9516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleATypeInteger9535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleATypeInteger9554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleATypeInteger9573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleATypeBoolean_in_entryRuleATypeBoolean9614 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleATypeBoolean9625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleATypeBoolean9662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleATypeFloat_in_entryRuleATypeFloat9702 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleATypeFloat9713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleATypeFloat9751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleATypeFloat9770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleATypeChar_in_entryRuleATypeChar9811 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleATypeChar9822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleATypeChar9859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReductionOp_in_entryRuleReductionOp9899 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReductionOp9910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ANDOP_in_ruleReductionOp9950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MAXOP_in_ruleReductionOp9976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MINOP_in_ruleReductionOp10002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MULOP_in_ruleReductionOp10028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OROP_in_ruleReductionOp10054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PLUSOP_in_ruleReductionOp10080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_XOROP_in_ruleReductionOp10106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArithmeticOp_in_entryRuleArithmeticOp10152 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArithmeticOp10163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MAXOP_in_ruleArithmeticOp10203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MINOP_in_ruleArithmeticOp10229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MULOP_in_ruleArithmeticOp10255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PLUSOP_in_ruleArithmeticOp10281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOp_in_entryRuleLogicalOp10327 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOp10338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ANDOP_in_ruleLogicalOp10378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OROP_in_ruleLogicalOp10404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_XOROP_in_ruleLogicalOp10430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOp_in_entryRuleRelationalOp10476 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalOp10487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EQOP_in_ruleRelationalOp10527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_GEOP_in_ruleRelationalOp10553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_GTOP_in_ruleRelationalOp10579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LEOP_in_ruleRelationalOp10605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LTOP_in_ruleRelationalOp10631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEOP_in_ruleRelationalOp10657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemID_in_entryRuleSystemID10703 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemID10714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemID10754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSystemID10782 = new BitSet(new long[]{0x0000000000000310L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemID10808 = new BitSet(new long[]{0x0000000000000310L});
    public static final BitSet FOLLOW_RULE_MINUSOP_in_ruleSystemID10831 = new BitSet(new long[]{0x0000000000000310L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSystemID10857 = new BitSet(new long[]{0x0000000000000310L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemID10883 = new BitSet(new long[]{0x0000000000000310L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemID10905 = new BitSet(new long[]{0x0000000000000002L});

}