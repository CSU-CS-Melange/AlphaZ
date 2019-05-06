// $ANTLR 3.3 Nov 30, 2010 12:50:56 /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/Polymodel.g 2011-07-20 16:31:06

package org.polymodel.parser.internal;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;
import org.polymodel.Domain;
import org.polymodel.Relation;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.Variable;

public class PolymodelParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "WS", "ID", "INT", "NEWLINE", "'<='", "'<'", "'='", "'>='", "'>'", "'&'", "'and'", "'|'", "'or'", "'+'", "'-'", "'/'", "'%'", "'('", "')'", "'{'", "'['", "']'", "':'", "'}'", "'exists'", "','", "'->'"
    };
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

    // delegates
    public Polymodel_IntAlgebra gIntAlgebra;
    // delegators


        public PolymodelParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PolymodelParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            gIntAlgebra = new Polymodel_IntAlgebra(input, state, this);         
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
        gIntAlgebra.setTreeAdaptor(this.adaptor);
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return PolymodelParser.tokenNames; }
    public String getGrammarFileName() { return "/home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/Polymodel.g"; }



          public static Domain parseDomain(String input) throws RecognitionException {
            CharStream cs = new ANTLRStringStream(input);
            PolymodelLexer lexer = new PolymodelLexer(cs);
            CommonTokenStream tokens = new CommonTokenStream();
            tokens.setTokenSource(lexer);
            PolymodelParser parser = new PolymodelParser(tokens);
            return (Domain) parser.domain().dom;
          }

          public static Relation parseRelation(String input) throws RecognitionException {
            CharStream cs = new ANTLRStringStream(input);
            PolymodelLexer lexer = new PolymodelLexer(cs);
            CommonTokenStream tokens = new CommonTokenStream();
            tokens.setTokenSource(lexer);
            PolymodelParser parser = new PolymodelParser(tokens);
            return (Relation) parser.relation().rel;
          }
          
          
          


    public static class domain_return extends ParserRuleReturnScope {
        public Domain dom;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "domain"
    // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/Polymodel.g:105:1: domain returns [Domain dom] : paramIds= paramIdList '{' '[' setIds= idList ']' ':' systemUnion= intConstrSystemUnion '}' ;
    public final PolymodelParser.domain_return domain() throws RecognitionException {
        PolymodelParser.domain_return retval = new PolymodelParser.domain_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal1=null;
        Token char_literal2=null;
        Token char_literal3=null;
        Token char_literal4=null;
        Token char_literal5=null;
        PolymodelParser.paramIdList_return paramIds = null;

        PolymodelParser.idList_return setIds = null;

        Polymodel_IntAlgebra.intConstrSystemUnion_return systemUnion = null;


        Object char_literal1_tree=null;
        Object char_literal2_tree=null;
        Object char_literal3_tree=null;
        Object char_literal4_tree=null;
        Object char_literal5_tree=null;

        try {
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/Polymodel.g:105:28: (paramIds= paramIdList '{' '[' setIds= idList ']' ':' systemUnion= intConstrSystemUnion '}' )
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/Polymodel.g:106:4: paramIds= paramIdList '{' '[' setIds= idList ']' ':' systemUnion= intConstrSystemUnion '}'
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_paramIdList_in_domain72);
            paramIds=paramIdList();

            state._fsp--;

            adaptor.addChild(root_0, paramIds.getTree());
            char_literal1=(Token)match(input,23,FOLLOW_23_in_domain74); 
            char_literal1_tree = (Object)adaptor.create(char_literal1);
            adaptor.addChild(root_0, char_literal1_tree);

            char_literal2=(Token)match(input,24,FOLLOW_24_in_domain76); 
            char_literal2_tree = (Object)adaptor.create(char_literal2);
            adaptor.addChild(root_0, char_literal2_tree);

            pushFollow(FOLLOW_idList_in_domain80);
            setIds=idList();

            state._fsp--;

            adaptor.addChild(root_0, setIds.getTree());
            char_literal3=(Token)match(input,25,FOLLOW_25_in_domain82); 
            char_literal3_tree = (Object)adaptor.create(char_literal3);
            adaptor.addChild(root_0, char_literal3_tree);

            char_literal4=(Token)match(input,26,FOLLOW_26_in_domain85); 
            char_literal4_tree = (Object)adaptor.create(char_literal4);
            adaptor.addChild(root_0, char_literal4_tree);

            pushFollow(FOLLOW_intConstrSystemUnion_in_domain89);
            systemUnion=intConstrSystemUnion();

            state._fsp--;

            adaptor.addChild(root_0, systemUnion.getTree());
            char_literal5=(Token)match(input,27,FOLLOW_27_in_domain91); 
            char_literal5_tree = (Object)adaptor.create(char_literal5);
            adaptor.addChild(root_0, char_literal5_tree);


                    retval.dom = PolymodelParserHelper.domain((paramIds!=null?paramIds.vars:null),(setIds!=null?setIds.vars:null),(systemUnion!=null?systemUnion.value:null));
              

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "domain"

    public static class exist_return extends ParserRuleReturnScope {
        public IntConstraintSystem system;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exist"
    // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/Polymodel.g:110:1: exist returns [IntConstraintSystem system] : 'exists' s= ID '(' ssystem= intConstrSystem ')' ;
    public final PolymodelParser.exist_return exist() throws RecognitionException {
        PolymodelParser.exist_return retval = new PolymodelParser.exist_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token s=null;
        Token string_literal6=null;
        Token char_literal7=null;
        Token char_literal8=null;
        Polymodel_IntAlgebra.intConstrSystem_return ssystem = null;


        Object s_tree=null;
        Object string_literal6_tree=null;
        Object char_literal7_tree=null;
        Object char_literal8_tree=null;

        try {
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/Polymodel.g:110:44: ( 'exists' s= ID '(' ssystem= intConstrSystem ')' )
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/Polymodel.g:110:46: 'exists' s= ID '(' ssystem= intConstrSystem ')'
            {
            root_0 = (Object)adaptor.nil();

            string_literal6=(Token)match(input,28,FOLLOW_28_in_exist108); 
            string_literal6_tree = (Object)adaptor.create(string_literal6);
            adaptor.addChild(root_0, string_literal6_tree);

            s=(Token)match(input,ID,FOLLOW_ID_in_exist112); 
            s_tree = (Object)adaptor.create(s);
            adaptor.addChild(root_0, s_tree);

              
//                Variable v = 
                		VariableScopeManager.getInstance().addVariable((s!=null?s.getText():null));   
              
            char_literal7=(Token)match(input,21,FOLLOW_21_in_exist116); 
            char_literal7_tree = (Object)adaptor.create(char_literal7);
            adaptor.addChild(root_0, char_literal7_tree);

            pushFollow(FOLLOW_intConstrSystem_in_exist120);
            ssystem=intConstrSystem();

            state._fsp--;

            adaptor.addChild(root_0, ssystem.getTree());
            char_literal8=(Token)match(input,22,FOLLOW_22_in_exist121); 
            char_literal8_tree = (Object)adaptor.create(char_literal8);
            adaptor.addChild(root_0, char_literal8_tree);


                
              

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "exist"

    public static class idList_return extends ParserRuleReturnScope {
        public List<Variable> vars;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "idList"
    // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/Polymodel.g:117:1: idList returns [List<Variable> vars] : s= ID ( ',' s= ID )* ;
    public final PolymodelParser.idList_return idList() throws RecognitionException {
        PolymodelParser.idList_return retval = new PolymodelParser.idList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token s=null;
        Token char_literal9=null;

        Object s_tree=null;
        Object char_literal9_tree=null;

        try {
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/Polymodel.g:117:37: (s= ID ( ',' s= ID )* )
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/Polymodel.g:118:3: s= ID ( ',' s= ID )*
            {
            root_0 = (Object)adaptor.nil();

             List<Variable> l = new ArrayList<Variable>();
            s=(Token)match(input,ID,FOLLOW_ID_in_idList150); 
            s_tree = (Object)adaptor.create(s);
            adaptor.addChild(root_0, s_tree);

              
                Variable v = VariableScopeManager.getInstance().addVariable((s!=null?s.getText():null));
                  l.add(v);
                
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/Polymodel.g:123:4: ( ',' s= ID )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==29) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/Polymodel.g:123:5: ',' s= ID
            	    {
            	    char_literal9=(Token)match(input,29,FOLLOW_29_in_idList161); 
            	    char_literal9_tree = (Object)adaptor.create(char_literal9);
            	    adaptor.addChild(root_0, char_literal9_tree);

            	    s=(Token)match(input,ID,FOLLOW_ID_in_idList165); 
            	    s_tree = (Object)adaptor.create(s);
            	    adaptor.addChild(root_0, s_tree);

            	     
            	          v = VariableScopeManager.getInstance().addVariable((s!=null?s.getText():null));
            	          l.add(v);
            	          retval.vars =l;
            	      

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "idList"

    public static class paramIdList_return extends ParserRuleReturnScope {
        public List<Variable> vars;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "paramIdList"
    // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/Polymodel.g:129:1: paramIdList returns [List<Variable> vars] : '[' (s= ID ( ',' s= ID )* )? ']' '->' ;
    public final PolymodelParser.paramIdList_return paramIdList() throws RecognitionException {
        PolymodelParser.paramIdList_return retval = new PolymodelParser.paramIdList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token s=null;
        Token char_literal10=null;
        Token char_literal11=null;
        Token char_literal12=null;
        Token string_literal13=null;

        Object s_tree=null;
        Object char_literal10_tree=null;
        Object char_literal11_tree=null;
        Object char_literal12_tree=null;
        Object string_literal13_tree=null;

        try {
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/Polymodel.g:129:42: ( '[' (s= ID ( ',' s= ID )* )? ']' '->' )
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/Polymodel.g:130:3: '[' (s= ID ( ',' s= ID )* )? ']' '->'
            {
            root_0 = (Object)adaptor.nil();

            char_literal10=(Token)match(input,24,FOLLOW_24_in_paramIdList192); 
            char_literal10_tree = (Object)adaptor.create(char_literal10);
            adaptor.addChild(root_0, char_literal10_tree);

             List<Variable> l = new ArrayList<Variable>();
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/Polymodel.g:131:3: (s= ID ( ',' s= ID )* )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/Polymodel.g:131:4: s= ID ( ',' s= ID )*
                    {
                    s=(Token)match(input,ID,FOLLOW_ID_in_paramIdList202); 
                    s_tree = (Object)adaptor.create(s);
                    adaptor.addChild(root_0, s_tree);

                      
                        Variable v = VariableScopeManager.getInstance().addVariable((s!=null?s.getText():null));   
                        l.add(v); 
                      
                    // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/Polymodel.g:135:3: ( ',' s= ID )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==29) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/Polymodel.g:135:4: ',' s= ID
                    	    {
                    	    char_literal11=(Token)match(input,29,FOLLOW_29_in_paramIdList211); 
                    	    char_literal11_tree = (Object)adaptor.create(char_literal11);
                    	    adaptor.addChild(root_0, char_literal11_tree);

                    	    s=(Token)match(input,ID,FOLLOW_ID_in_paramIdList215); 
                    	    s_tree = (Object)adaptor.create(s);
                    	    adaptor.addChild(root_0, s_tree);

                    	     
                    	          v = VariableScopeManager.getInstance().addVariable((s!=null?s.getText():null));
                    	          l.add(v);
                    	          ;
                    	      

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal12=(Token)match(input,25,FOLLOW_25_in_paramIdList223); 
            char_literal12_tree = (Object)adaptor.create(char_literal12);
            adaptor.addChild(root_0, char_literal12_tree);

            string_literal13=(Token)match(input,30,FOLLOW_30_in_paramIdList225); 
            string_literal13_tree = (Object)adaptor.create(string_literal13);
            adaptor.addChild(root_0, string_literal13_tree);

            retval.vars =l;

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "paramIdList"

    public static class relation_return extends ParserRuleReturnScope {
        public Relation rel;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "relation"
    // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/Polymodel.g:141:1: relation returns [Relation rel] : params= paramIdList '{' '[' in= idList ']' '->' '[' out= idList ']' ':' systemUnion= intConstrSystemUnion '}' ;
    public final PolymodelParser.relation_return relation() throws RecognitionException {
        PolymodelParser.relation_return retval = new PolymodelParser.relation_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal14=null;
        Token char_literal15=null;
        Token char_literal16=null;
        Token string_literal17=null;
        Token char_literal18=null;
        Token char_literal19=null;
        Token char_literal20=null;
        Token char_literal21=null;
        PolymodelParser.paramIdList_return params = null;

        PolymodelParser.idList_return in = null;

        PolymodelParser.idList_return out = null;

        Polymodel_IntAlgebra.intConstrSystemUnion_return systemUnion = null;


        Object char_literal14_tree=null;
        Object char_literal15_tree=null;
        Object char_literal16_tree=null;
        Object string_literal17_tree=null;
        Object char_literal18_tree=null;
        Object char_literal19_tree=null;
        Object char_literal20_tree=null;
        Object char_literal21_tree=null;

        try {
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/Polymodel.g:141:32: (params= paramIdList '{' '[' in= idList ']' '->' '[' out= idList ']' ':' systemUnion= intConstrSystemUnion '}' )
            // /home/steven/workspace/alternate/org.polymodel.antlr.parser/src/org/polymodel/parser/Polymodel.g:142:3: params= paramIdList '{' '[' in= idList ']' '->' '[' out= idList ']' ':' systemUnion= intConstrSystemUnion '}'
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_paramIdList_in_relation254);
            params=paramIdList();

            state._fsp--;

            adaptor.addChild(root_0, params.getTree());
            char_literal14=(Token)match(input,23,FOLLOW_23_in_relation256); 
            char_literal14_tree = (Object)adaptor.create(char_literal14);
            adaptor.addChild(root_0, char_literal14_tree);

            char_literal15=(Token)match(input,24,FOLLOW_24_in_relation258); 
            char_literal15_tree = (Object)adaptor.create(char_literal15);
            adaptor.addChild(root_0, char_literal15_tree);

            pushFollow(FOLLOW_idList_in_relation262);
            in=idList();

            state._fsp--;

            adaptor.addChild(root_0, in.getTree());
            char_literal16=(Token)match(input,25,FOLLOW_25_in_relation264); 
            char_literal16_tree = (Object)adaptor.create(char_literal16);
            adaptor.addChild(root_0, char_literal16_tree);

            string_literal17=(Token)match(input,30,FOLLOW_30_in_relation266); 
            string_literal17_tree = (Object)adaptor.create(string_literal17);
            adaptor.addChild(root_0, string_literal17_tree);

            char_literal18=(Token)match(input,24,FOLLOW_24_in_relation268); 
            char_literal18_tree = (Object)adaptor.create(char_literal18);
            adaptor.addChild(root_0, char_literal18_tree);

            pushFollow(FOLLOW_idList_in_relation272);
            out=idList();

            state._fsp--;

            adaptor.addChild(root_0, out.getTree());
            char_literal19=(Token)match(input,25,FOLLOW_25_in_relation274); 
            char_literal19_tree = (Object)adaptor.create(char_literal19);
            adaptor.addChild(root_0, char_literal19_tree);

            char_literal20=(Token)match(input,26,FOLLOW_26_in_relation276); 
            char_literal20_tree = (Object)adaptor.create(char_literal20);
            adaptor.addChild(root_0, char_literal20_tree);

            pushFollow(FOLLOW_intConstrSystemUnion_in_relation280);
            systemUnion=intConstrSystemUnion();

            state._fsp--;

            adaptor.addChild(root_0, systemUnion.getTree());
            char_literal21=(Token)match(input,27,FOLLOW_27_in_relation282); 
            char_literal21_tree = (Object)adaptor.create(char_literal21);
            adaptor.addChild(root_0, char_literal21_tree);


                    retval.rel = PolymodelParserHelper.relation(params.vars,in.vars,out.vars,systemUnion.value);
              

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "relation"

    // Delegated rules
    public Polymodel_IntAlgebra.intConstr_return intConstr() throws RecognitionException { return gIntAlgebra.intConstr(); }
    public Polymodel_IntAlgebra.unaryTerm_return unaryTerm() throws RecognitionException { return gIntAlgebra.unaryTerm(); }
    public Polymodel_IntAlgebra.intConstrSystemUnion_return intConstrSystemUnion() throws RecognitionException { return gIntAlgebra.intConstrSystemUnion(); }
    public Polymodel_IntAlgebra.intExpr_return intExpr() throws RecognitionException { return gIntAlgebra.intExpr(); }
    public Polymodel_IntAlgebra.intConstrSystem_return intConstrSystem() throws RecognitionException { return gIntAlgebra.intConstrSystem(); }
    public Polymodel_IntAlgebra.multiplicativeExp_return multiplicativeExp() throws RecognitionException { return gIntAlgebra.multiplicativeExp(); }
    public Polymodel_IntAlgebra.baseAffTerm_return baseAffTerm() throws RecognitionException { return gIntAlgebra.baseAffTerm(); }
    public Polymodel_IntAlgebra.quasiAffineExpr_return quasiAffineExpr() throws RecognitionException { return gIntAlgebra.quasiAffineExpr(); }


 

    public static final BitSet FOLLOW_paramIdList_in_domain72 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_domain74 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_domain76 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_idList_in_domain80 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_domain82 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_domain85 = new BitSet(new long[]{0x0000000000240060L});
    public static final BitSet FOLLOW_intConstrSystemUnion_in_domain89 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_domain91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_exist108 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_exist112 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_exist116 = new BitSet(new long[]{0x0000000000240060L});
    public static final BitSet FOLLOW_intConstrSystem_in_exist120 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_exist121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_idList150 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_idList161 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_idList165 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_24_in_paramIdList192 = new BitSet(new long[]{0x0000000002000020L});
    public static final BitSet FOLLOW_ID_in_paramIdList202 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_29_in_paramIdList211 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_paramIdList215 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_25_in_paramIdList223 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_paramIdList225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_paramIdList_in_relation254 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_relation256 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_relation258 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_idList_in_relation262 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_relation264 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_relation266 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_relation268 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_idList_in_relation272 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_relation274 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_relation276 = new BitSet(new long[]{0x0000000000240060L});
    public static final BitSet FOLLOW_intConstrSystemUnion_in_relation280 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_relation282 = new BitSet(new long[]{0x0000000000000002L});

}