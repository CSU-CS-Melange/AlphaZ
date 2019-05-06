// $ANTLR 3.3 Nov 30, 2010 12:50:56 IntAlgebra.g 2011-07-20 16:31:07

package org.polymodel.parser.internal;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraint;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraintSystem;
import static org.polymodel.algebra.factory.IntExpressionBuilder.floord;
import static org.polymodel.algebra.factory.IntExpressionBuilder.mod;
import static org.polymodel.algebra.factory.IntExpressionBuilder.mul;
import static org.polymodel.algebra.factory.IntExpressionBuilder.qaffine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.quasiAffine.QuasiAffineExpression;
import org.polymodel.algebra.quasiAffine.QuasiAffineFactory;
import org.polymodel.algebra.quasiAffine.QuasiAffineTerm;

public class Polymodel_IntAlgebra extends Parser {
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
    // delegators
    public PolymodelParser gPolymodel;
    public PolymodelParser gParent;


        public Polymodel_IntAlgebra(TokenStream input, PolymodelParser gPolymodel) {
            this(input, new RecognizerSharedState(), gPolymodel);
        }
        public Polymodel_IntAlgebra(TokenStream input, RecognizerSharedState state, PolymodelParser gPolymodel) {
            super(input, state);
            this.gPolymodel = gPolymodel;
             
            gParent = gPolymodel;
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return PolymodelParser.tokenNames; }
    public String getGrammarFileName() { return "IntAlgebra.g"; }


      VariableScopeManager manager ;


    public static class intExpr_return extends ParserRuleReturnScope {
        public IntExpression value;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "intExpr"
    // IntAlgebra.g:8:1: intExpr returns [IntExpression value] : (e= quasiAffineExpr ) ;
    public final Polymodel_IntAlgebra.intExpr_return intExpr() throws RecognitionException {
        Polymodel_IntAlgebra.intExpr_return retval = new Polymodel_IntAlgebra.intExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Polymodel_IntAlgebra.quasiAffineExpr_return e = null;



        try {
            // IntAlgebra.g:8:38: ( (e= quasiAffineExpr ) )
            // IntAlgebra.g:9:3: (e= quasiAffineExpr )
            {
            root_0 = (Object)adaptor.nil();

            // IntAlgebra.g:9:3: (e= quasiAffineExpr )
            // IntAlgebra.g:9:4: e= quasiAffineExpr
            {
            pushFollow(FOLLOW_quasiAffineExpr_in_intExpr74);
            e=quasiAffineExpr();

            state._fsp--;

            adaptor.addChild(root_0, e.getTree());
            retval.value =(e!=null?e.value:null);

            }


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
    // $ANTLR end "intExpr"

    public static class intConstr_return extends ParserRuleReturnScope {
        public IntConstraint value;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "intConstr"
    // IntAlgebra.g:11:1: intConstr returns [IntConstraint value] : lhs= intExpr ( ( '<=' ) | ( '<' ) | ( '=' ) | ( '>=' ) | ( '>' ) ) rhs= intExpr ;
    public final Polymodel_IntAlgebra.intConstr_return intConstr() throws RecognitionException {
        Polymodel_IntAlgebra.intConstr_return retval = new Polymodel_IntAlgebra.intConstr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal1=null;
        Token char_literal2=null;
        Token char_literal3=null;
        Token string_literal4=null;
        Token char_literal5=null;
        Polymodel_IntAlgebra.intExpr_return lhs = null;

        Polymodel_IntAlgebra.intExpr_return rhs = null;


        Object string_literal1_tree=null;
        Object char_literal2_tree=null;
        Object char_literal3_tree=null;
        Object string_literal4_tree=null;
        Object char_literal5_tree=null;

        try {
            // IntAlgebra.g:11:40: (lhs= intExpr ( ( '<=' ) | ( '<' ) | ( '=' ) | ( '>=' ) | ( '>' ) ) rhs= intExpr )
            // IntAlgebra.g:12:3: lhs= intExpr ( ( '<=' ) | ( '<' ) | ( '=' ) | ( '>=' ) | ( '>' ) ) rhs= intExpr
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_intExpr_in_intConstr94);
            lhs=intExpr();

            state._fsp--;

            adaptor.addChild(root_0, lhs.getTree());
            ComparisonOperator op = ComparisonOperator.LE;
            // IntAlgebra.g:13:3: ( ( '<=' ) | ( '<' ) | ( '=' ) | ( '>=' ) | ( '>' ) )
            int alt1=5;
            switch ( input.LA(1) ) {
            case 8:
                {
                alt1=1;
                }
                break;
            case 9:
                {
                alt1=2;
                }
                break;
            case 10:
                {
                alt1=3;
                }
                break;
            case 11:
                {
                alt1=4;
                }
                break;
            case 12:
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // IntAlgebra.g:14:5: ( '<=' )
                    {
                    // IntAlgebra.g:14:5: ( '<=' )
                    // IntAlgebra.g:14:6: '<='
                    {
                    string_literal1=(Token)match(input,8,FOLLOW_8_in_intConstr108); 
                    string_literal1_tree = (Object)adaptor.create(string_literal1);
                    adaptor.addChild(root_0, string_literal1_tree);

                    op=ComparisonOperator.LE;

                    }


                    }
                    break;
                case 2 :
                    // IntAlgebra.g:15:5: ( '<' )
                    {
                    // IntAlgebra.g:15:5: ( '<' )
                    // IntAlgebra.g:15:6: '<'
                    {
                    char_literal2=(Token)match(input,9,FOLLOW_9_in_intConstr120); 
                    char_literal2_tree = (Object)adaptor.create(char_literal2);
                    adaptor.addChild(root_0, char_literal2_tree);

                    op=ComparisonOperator.LT;

                    }


                    }
                    break;
                case 3 :
                    // IntAlgebra.g:16:5: ( '=' )
                    {
                    // IntAlgebra.g:16:5: ( '=' )
                    // IntAlgebra.g:16:6: '='
                    {
                    char_literal3=(Token)match(input,10,FOLLOW_10_in_intConstr135); 
                    char_literal3_tree = (Object)adaptor.create(char_literal3);
                    adaptor.addChild(root_0, char_literal3_tree);

                    op=ComparisonOperator.EQ;

                    }


                    }
                    break;
                case 4 :
                    // IntAlgebra.g:17:5: ( '>=' )
                    {
                    // IntAlgebra.g:17:5: ( '>=' )
                    // IntAlgebra.g:17:6: '>='
                    {
                    string_literal4=(Token)match(input,11,FOLLOW_11_in_intConstr148); 
                    string_literal4_tree = (Object)adaptor.create(string_literal4);
                    adaptor.addChild(root_0, string_literal4_tree);

                    op=ComparisonOperator.GE;

                    }


                    }
                    break;
                case 5 :
                    // IntAlgebra.g:18:5: ( '>' )
                    {
                    // IntAlgebra.g:18:5: ( '>' )
                    // IntAlgebra.g:18:6: '>'
                    {
                    char_literal5=(Token)match(input,12,FOLLOW_12_in_intConstr160); 
                    char_literal5_tree = (Object)adaptor.create(char_literal5);
                    adaptor.addChild(root_0, char_literal5_tree);

                    op=ComparisonOperator.GT;

                    }


                    }
                    break;

            }

            pushFollow(FOLLOW_intExpr_in_intConstr190);
            rhs=intExpr();

            state._fsp--;

            adaptor.addChild(root_0, rhs.getTree());
            retval.value =constraint((lhs!=null?lhs.value:null),(rhs!=null?rhs.value:null),op);

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
    // $ANTLR end "intConstr"

    public static class intConstrSystem_return extends ParserRuleReturnScope {
        public IntConstraintSystem value;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "intConstrSystem"
    // IntAlgebra.g:25:1: intConstrSystem returns [IntConstraintSystem value] : e= intConstr ( ( '&' | 'and' ) e= intConstr )* ;
    public final Polymodel_IntAlgebra.intConstrSystem_return intConstrSystem() throws RecognitionException {
        Polymodel_IntAlgebra.intConstrSystem_return retval = new Polymodel_IntAlgebra.intConstrSystem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set6=null;
        Polymodel_IntAlgebra.intConstr_return e = null;


//        Object set6_tree=null;

        try {
            // IntAlgebra.g:25:52: (e= intConstr ( ( '&' | 'and' ) e= intConstr )* )
            // IntAlgebra.g:26:3: e= intConstr ( ( '&' | 'and' ) e= intConstr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_intConstr_in_intConstrSystem209);
            e=intConstr();

            state._fsp--;

            adaptor.addChild(root_0, e.getTree());
            retval.value =constraintSystem((e!=null?e.value:null));
            // IntAlgebra.g:26:53: ( ( '&' | 'and' ) e= intConstr )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=13 && LA2_0<=14)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // IntAlgebra.g:26:54: ( '&' | 'and' ) e= intConstr
            	    {
            	    set6=(Token)input.LT(1);
            	    if ( (input.LA(1)>=13 && input.LA(1)<=14) ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (Object)adaptor.create(set6));
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_intConstr_in_intConstrSystem222);
            	    e=intConstr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e.getTree());
            	     retval.value .getConstraints().add((e!=null?e.value:null));

            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "intConstrSystem"

    public static class intConstrSystemUnion_return extends ParserRuleReturnScope {
        public List<IntConstraintSystem> value;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "intConstrSystemUnion"
    // IntAlgebra.g:28:1: intConstrSystemUnion returns [List<IntConstraintSystem> value] : e= intConstrSystem ( ( '|' | 'or' ) e= intConstrSystem )* ;
    public final Polymodel_IntAlgebra.intConstrSystemUnion_return intConstrSystemUnion() throws RecognitionException {
        Polymodel_IntAlgebra.intConstrSystemUnion_return retval = new Polymodel_IntAlgebra.intConstrSystemUnion_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set7=null;
        Polymodel_IntAlgebra.intConstrSystem_return e = null;


//        Object set7_tree=null;

        try {
            // IntAlgebra.g:28:63: (e= intConstrSystem ( ( '|' | 'or' ) e= intConstrSystem )* )
            // IntAlgebra.g:29:3: e= intConstrSystem ( ( '|' | 'or' ) e= intConstrSystem )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_intConstrSystem_in_intConstrSystemUnion243);
            e=intConstrSystem();

            state._fsp--;

            adaptor.addChild(root_0, e.getTree());
            retval.value = new ArrayList<IntConstraintSystem>();retval.value.add((e!=null?e.value:null));
            // IntAlgebra.g:29:91: ( ( '|' | 'or' ) e= intConstrSystem )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=15 && LA3_0<=16)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // IntAlgebra.g:29:92: ( '|' | 'or' ) e= intConstrSystem
            	    {
            	    set7=(Token)input.LT(1);
            	    if ( (input.LA(1)>=15 && input.LA(1)<=16) ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (Object)adaptor.create(set7));
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_intConstrSystem_in_intConstrSystemUnion256);
            	    e=intConstrSystem();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e.getTree());
            	     retval.value.add((e!=null?e.value:null));

            	    }
            	    break;

            	default :
            	    break loop3;
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
    // $ANTLR end "intConstrSystemUnion"

    public static class quasiAffineExpr_return extends ParserRuleReturnScope {
        public QuasiAffineExpression value;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "quasiAffineExpr"
    // IntAlgebra.g:34:1: quasiAffineExpr returns [QuasiAffineExpression value] : m= multiplicativeExp (op= ( '+' | '-' ) m= multiplicativeExp )* ;
    public final Polymodel_IntAlgebra.quasiAffineExpr_return quasiAffineExpr() throws RecognitionException {
        Polymodel_IntAlgebra.quasiAffineExpr_return retval = new Polymodel_IntAlgebra.quasiAffineExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        Polymodel_IntAlgebra.multiplicativeExp_return m = null;


//        Object op_tree=null;

        try {
            // IntAlgebra.g:34:54: (m= multiplicativeExp (op= ( '+' | '-' ) m= multiplicativeExp )* )
            // IntAlgebra.g:35:3: m= multiplicativeExp (op= ( '+' | '-' ) m= multiplicativeExp )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_multiplicativeExp_in_quasiAffineExpr285);
            m=multiplicativeExp();

            state._fsp--;

            adaptor.addChild(root_0, m.getTree());

                  QuasiAffineExpression qaffExpr = QuasiAffineFactory.eINSTANCE.createQuasiAffineExpression();
                  qaffExpr.getTerms().add((m!=null?m.value:null));
                  retval.value = qaffExpr;
              
            // IntAlgebra.g:40:3: (op= ( '+' | '-' ) m= multiplicativeExp )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=17 && LA4_0<=18)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // IntAlgebra.g:40:4: op= ( '+' | '-' ) m= multiplicativeExp
            	    {
            	    op=(Token)input.LT(1);
            	    if ( (input.LA(1)>=17 && input.LA(1)<=18) ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (Object)adaptor.create(op));
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_multiplicativeExp_in_quasiAffineExpr304);
            	    m=multiplicativeExp();

            	    state._fsp--;

            	    adaptor.addChild(root_0, m.getTree());

            	          if((op.getText()).equals("+")) {
            	            qaffExpr.getTerms().add((m!=null?m.value:null));
            	            retval.value = qaffExpr;
            	          } else {
            	            qaffExpr.getTerms().add(mul(qaffine((m!=null?m.value:null)),-1));
            	          }
            	      

            	    }
            	    break;

            	default :
            	    break loop4;
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
    // $ANTLR end "quasiAffineExpr"

    public static class multiplicativeExp_return extends ParserRuleReturnScope {
        public QuasiAffineTerm value;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "multiplicativeExp"
    // IntAlgebra.g:50:1: multiplicativeExp returns [QuasiAffineTerm value] : e= unaryTerm (op= ( '/' | '%' ) c= INT )? ;
    public final Polymodel_IntAlgebra.multiplicativeExp_return multiplicativeExp() throws RecognitionException {
        Polymodel_IntAlgebra.multiplicativeExp_return retval = new Polymodel_IntAlgebra.multiplicativeExp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        Token c=null;
        Polymodel_IntAlgebra.unaryTerm_return e = null;


//        Object op_tree=null;
        Object c_tree=null;

        try {
            // IntAlgebra.g:50:50: (e= unaryTerm (op= ( '/' | '%' ) c= INT )? )
            // IntAlgebra.g:51:3: e= unaryTerm (op= ( '/' | '%' ) c= INT )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_unaryTerm_in_multiplicativeExp326);
            e=unaryTerm();

            state._fsp--;

            adaptor.addChild(root_0, e.getTree());

                retval.value = (e!=null?e.value:null);
              
            // IntAlgebra.g:54:3: (op= ( '/' | '%' ) c= INT )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=19 && LA5_0<=20)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // IntAlgebra.g:54:4: op= ( '/' | '%' ) c= INT
                    {
                    op=(Token)input.LT(1);
                    if ( (input.LA(1)>=19 && input.LA(1)<=20) ) {
                        input.consume();
                        adaptor.addChild(root_0, (Object)adaptor.create(op));
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    c=(Token)match(input,INT,FOLLOW_INT_in_multiplicativeExp343); 
                    c_tree = (Object)adaptor.create(c);
                    adaptor.addChild(root_0, c_tree);


                             
                          if((op.getText()).equals("/"))
                            retval.value = floord(qaffine((e!=null?e.value:null)), Integer.parseInt(c.getText()));
                          else 
                            retval.value = mod(qaffine((e!=null?e.value:null)), Integer.parseInt(c.getText()));
                      

                    }
                    break;

            }


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
    // $ANTLR end "multiplicativeExp"

    public static class unaryTerm_return extends ParserRuleReturnScope {
        public QuasiAffineTerm value;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unaryTerm"
    // IntAlgebra.g:63:1: unaryTerm returns [QuasiAffineTerm value] : ( '-' )? base= baseAffTerm ;
    public final Polymodel_IntAlgebra.unaryTerm_return unaryTerm() throws RecognitionException {
        Polymodel_IntAlgebra.unaryTerm_return retval = new Polymodel_IntAlgebra.unaryTerm_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal8=null;
        Polymodel_IntAlgebra.baseAffTerm_return base = null;


        Object char_literal8_tree=null;

        try {
            // IntAlgebra.g:63:42: ( ( '-' )? base= baseAffTerm )
            // IntAlgebra.g:64:3: ( '-' )? base= baseAffTerm
            {
            root_0 = (Object)adaptor.nil();

            int neg=0;
            // IntAlgebra.g:65:3: ( '-' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==18) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // IntAlgebra.g:65:4: '-'
                    {
                    char_literal8=(Token)match(input,18,FOLLOW_18_in_unaryTerm369); 
                    char_literal8_tree = (Object)adaptor.create(char_literal8);
                    adaptor.addChild(root_0, char_literal8_tree);

                    neg=-1;

                    }
                    break;

            }

            pushFollow(FOLLOW_baseAffTerm_in_unaryTerm377);
            base=baseAffTerm();

            state._fsp--;

            adaptor.addChild(root_0, base.getTree());

                if(neg==-1) {
                    retval.value = mul(qaffine((base!=null?base.value:null)), -1);
                } else {
                    retval.value = (base!=null?base.value:null);
                }
              

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
    // $ANTLR end "unaryTerm"

    public static class baseAffTerm_return extends ParserRuleReturnScope {
        public QuasiAffineTerm value;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "baseAffTerm"
    // IntAlgebra.g:74:1: baseAffTerm returns [QuasiAffineTerm value] : ( INT | ( INT ID ) | ID | '(' e= quasiAffineExpr ')' | INT '(' e= quasiAffineExpr ')' );
    public final Polymodel_IntAlgebra.baseAffTerm_return baseAffTerm() throws RecognitionException {
        Polymodel_IntAlgebra.baseAffTerm_return retval = new Polymodel_IntAlgebra.baseAffTerm_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token INT9=null;
        Token INT10=null;
        Token ID11=null;
        Token ID12=null;
        Token char_literal13=null;
        Token char_literal14=null;
        Token INT15=null;
        Token char_literal16=null;
        Token char_literal17=null;
        Polymodel_IntAlgebra.quasiAffineExpr_return e = null;


        Object INT9_tree=null;
        Object INT10_tree=null;
        Object ID11_tree=null;
        Object ID12_tree=null;
        Object char_literal13_tree=null;
        Object char_literal14_tree=null;
        Object INT15_tree=null;
        Object char_literal16_tree=null;
        Object char_literal17_tree=null;

        try {
            // IntAlgebra.g:74:44: ( INT | ( INT ID ) | ID | '(' e= quasiAffineExpr ')' | INT '(' e= quasiAffineExpr ')' )
            int alt7=5;
            switch ( input.LA(1) ) {
            case INT:
                {
                switch ( input.LA(2) ) {
                case ID:
                    {
                    alt7=2;
                    }
                    break;
                case 21:
                    {
                    alt7=5;
                    }
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 22:
                case 27:
                    {
                    alt7=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }

                }
                break;
            case ID:
                {
                alt7=3;
                }
                break;
            case 21:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // IntAlgebra.g:75:5: INT
                    {
                    root_0 = (Object)adaptor.nil();

                    INT9=(Token)match(input,INT,FOLLOW_INT_in_baseAffTerm395); 
                    INT9_tree = (Object)adaptor.create(INT9);
                    adaptor.addChild(root_0, INT9_tree);


                          retval.value = mul(affine(term(Integer.parseInt((INT9!=null?INT9.getText():null)))),1);  
                          

                    }
                    break;
                case 2 :
                    // IntAlgebra.g:79:5: ( INT ID )
                    {
                    root_0 = (Object)adaptor.nil();

                    // IntAlgebra.g:79:5: ( INT ID )
                    // IntAlgebra.g:79:6: INT ID
                    {
                    INT10=(Token)match(input,INT,FOLLOW_INT_in_baseAffTerm413); 
                    INT10_tree = (Object)adaptor.create(INT10);
                    adaptor.addChild(root_0, INT10_tree);

                    ID11=(Token)match(input,ID,FOLLOW_ID_in_baseAffTerm415); 
                    ID11_tree = (Object)adaptor.create(ID11);
                    adaptor.addChild(root_0, ID11_tree);


                    }

                        
                            // helo
                            Variable v = VariableScopeManager.getInstance().getVariable((ID11!=null?ID11.getText():null)); 
                            Integer  l = Integer.parseInt((INT10!=null?INT10.getText():null));
                            retval.value = mul(affine(term((long)l,v)),1);  
                           
                            

                    }
                    break;
                case 3 :
                    // IntAlgebra.g:87:9: ID
                    {
                    root_0 = (Object)adaptor.nil();

                    ID12=(Token)match(input,ID,FOLLOW_ID_in_baseAffTerm436); 
                    ID12_tree = (Object)adaptor.create(ID12);
                    adaptor.addChild(root_0, ID12_tree);


                            Variable v = VariableScopeManager.getInstance().getVariable((ID12!=null?ID12.getText():null));
                            retval.value = mul(affine(term((long)1,v)),1);
                            

                    }
                    break;
                case 4 :
                    // IntAlgebra.g:93:7: '(' e= quasiAffineExpr ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal13=(Token)match(input,21,FOLLOW_21_in_baseAffTerm463); 
                    char_literal13_tree = (Object)adaptor.create(char_literal13);
                    adaptor.addChild(root_0, char_literal13_tree);

                    pushFollow(FOLLOW_quasiAffineExpr_in_baseAffTerm467);
                    e=quasiAffineExpr();

                    state._fsp--;

                    adaptor.addChild(root_0, e.getTree());
                    char_literal14=(Token)match(input,22,FOLLOW_22_in_baseAffTerm469); 
                    char_literal14_tree = (Object)adaptor.create(char_literal14);
                    adaptor.addChild(root_0, char_literal14_tree);

                      
                            retval.value = mul((e!=null?e.value:null),1);
                        

                    }
                    break;
                case 5 :
                    // IntAlgebra.g:96:7: INT '(' e= quasiAffineExpr ')'
                    {
                    root_0 = (Object)adaptor.nil();

                    INT15=(Token)match(input,INT,FOLLOW_INT_in_baseAffTerm479); 
                    INT15_tree = (Object)adaptor.create(INT15);
                    adaptor.addChild(root_0, INT15_tree);

                    char_literal16=(Token)match(input,21,FOLLOW_21_in_baseAffTerm481); 
                    char_literal16_tree = (Object)adaptor.create(char_literal16);
                    adaptor.addChild(root_0, char_literal16_tree);

                    pushFollow(FOLLOW_quasiAffineExpr_in_baseAffTerm485);
                    e=quasiAffineExpr();

                    state._fsp--;

                    adaptor.addChild(root_0, e.getTree());
                    char_literal17=(Token)match(input,22,FOLLOW_22_in_baseAffTerm487); 
                    char_literal17_tree = (Object)adaptor.create(char_literal17);
                    adaptor.addChild(root_0, char_literal17_tree);


                            retval.value = mul((e!=null?e.value:null),Integer.parseInt((INT15!=null?INT15.getText():null)));
                        

                    }
                    break;

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
    // $ANTLR end "baseAffTerm"

    // Delegated rules


 

    public static final BitSet FOLLOW_quasiAffineExpr_in_intExpr74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_intExpr_in_intConstr94 = new BitSet(new long[]{0x0000000000001F00L});
    public static final BitSet FOLLOW_8_in_intConstr108 = new BitSet(new long[]{0x0000000000240060L});
    public static final BitSet FOLLOW_9_in_intConstr120 = new BitSet(new long[]{0x0000000000240060L});
    public static final BitSet FOLLOW_10_in_intConstr135 = new BitSet(new long[]{0x0000000000240060L});
    public static final BitSet FOLLOW_11_in_intConstr148 = new BitSet(new long[]{0x0000000000240060L});
    public static final BitSet FOLLOW_12_in_intConstr160 = new BitSet(new long[]{0x0000000000240060L});
    public static final BitSet FOLLOW_intExpr_in_intConstr190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_intConstr_in_intConstrSystem209 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_set_in_intConstrSystem214 = new BitSet(new long[]{0x0000000000240060L});
    public static final BitSet FOLLOW_intConstr_in_intConstrSystem222 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_intConstrSystem_in_intConstrSystemUnion243 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_set_in_intConstrSystemUnion248 = new BitSet(new long[]{0x0000000000240060L});
    public static final BitSet FOLLOW_intConstrSystem_in_intConstrSystemUnion256 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_multiplicativeExp_in_quasiAffineExpr285 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_set_in_quasiAffineExpr295 = new BitSet(new long[]{0x0000000000240060L});
    public static final BitSet FOLLOW_multiplicativeExp_in_quasiAffineExpr304 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_unaryTerm_in_multiplicativeExp326 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_set_in_multiplicativeExp335 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_multiplicativeExp343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_unaryTerm369 = new BitSet(new long[]{0x0000000000240060L});
    public static final BitSet FOLLOW_baseAffTerm_in_unaryTerm377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_baseAffTerm395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_baseAffTerm413 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_baseAffTerm415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_baseAffTerm436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_baseAffTerm463 = new BitSet(new long[]{0x0000000000240060L});
    public static final BitSet FOLLOW_quasiAffineExpr_in_baseAffTerm467 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_baseAffTerm469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_baseAffTerm479 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_baseAffTerm481 = new BitSet(new long[]{0x0000000000240060L});
    public static final BitSet FOLLOW_quasiAffineExpr_in_baseAffTerm485 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_baseAffTerm487 = new BitSet(new long[]{0x0000000000000002L});

}