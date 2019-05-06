package org.polymodel.polyhedralIR.transformation;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.algebra.Variable;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ExternalFunctionDeclaration;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.SIGNED;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.VariableIdentifier;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.CaseExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.ExternalFunctionCall;
import org.polymodel.polyhedralIR.expression.IfExpression;
import org.polymodel.polyhedralIR.expression.IndexExpression;
import org.polymodel.polyhedralIR.expression.MultiArgExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.expression.UnaryExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;

import tom.library.sl.VisitFailure;
import tom.mapping.introspectors.polyhedralIR.expression.ExpressionIntrospector;

public class NormalizeExpression extends PolyhedralIRTomTransformation {

public static boolean DEBUG = false;
public static int EMPTY_BRANCH_THOLD = 0;

public static Expression normalizeExpression(Expression expr){
// DEBUG
//System.out.println("Expression in : " + PolyhedralIRToAlphabets.toString(expr));

NormalizeExpression norm = new NormalizeExpression();
Expression nExpr = norm.ntransform(expr);

//System.out.println("Expression out : " + PolyhedralIRToAlphabets.toString(nExpr) + "\n");

return nExpr;
}

protected Expression ntransform(Expression expr){
return (Expression) gtransform(expr);
}

protected NormalizeExpression(){}

@Override
protected EObject apply(EObject o) throws VisitFailure {
EObject t = null;
if (o instanceof Expression) {
ExpressionIntrospector.REMOVE_EMPTY_BRANCH_AT_SETTER = true;
EMPTY_BRANCH_THOLD = 10;
t = 
tom_make_InnermostId(tom_make_EfficientNormalizeRule()).visitLight(o, tom.mapping.GenericIntrospector.INSTANCE);
EMPTY_BRANCH_THOLD = 0;
t = 
tom_make_BottomUp(tom_make_RemoveEmptyBranch()).visitLight(t, tom.mapping.GenericIntrospector.INSTANCE);

//t = `BottomUp(NormalizeIdentityFunction()).visitLight(t, tom.mapping.GenericIntrospector.INSTANCE);
ExpressionIntrospector.REMOVE_EMPTY_BRANCH_AT_SETTER = false;
return t;
} else {
throw new RuntimeException("NormalizeExpression can only be applied to Expression");
}
}


private static boolean tom_equal_term_Strategy(Object t1, Object t2) {
return  (t1.equals(t2)) ;
}
private static boolean tom_is_sort_Strategy(Object t) {
return  (t instanceof tom.library.sl.Strategy) ;
}
private static boolean tom_equal_term_Position(Object t1, Object t2) {
return  (t1.equals(t2)) ;
}
private static boolean tom_is_sort_Position(Object t) {
return  (t instanceof tom.library.sl.Position) ;
}
private static boolean tom_equal_term_int(int t1, int t2) {
return  t1==t2 ;
}
private static boolean tom_is_sort_int(int t) {
return  true ;
}
private static boolean tom_equal_term_char(char t1, char t2) {
return  t1==t2 ;
}
private static boolean tom_is_sort_char(char t) {
return  true ;
}
private static boolean tom_equal_term_String(String t1, String t2) {
return  t1.equals(t2) ;
}
private static boolean tom_is_sort_String(String t) {
return  t instanceof String ;
}
private static  tom.library.sl.Strategy  tom_make_mu( tom.library.sl.Strategy  var,  tom.library.sl.Strategy  v) { 
return ( new tom.library.sl.Mu(var,v) );
}
private static  tom.library.sl.Strategy  tom_make_MuVar( String  name) { 
return ( new tom.library.sl.MuVar(name) );
}
private static  tom.library.sl.Strategy  tom_make_Identity() { 
return ( new tom.library.sl.Identity() );
}
private static  tom.library.sl.Strategy  tom_make_One( tom.library.sl.Strategy  v) { 
return ( new tom.library.sl.One(v) );
}
private static  tom.library.sl.Strategy  tom_make_All( tom.library.sl.Strategy  v) { 
return ( new tom.library.sl.All(v) );
}
private static  tom.library.sl.Strategy  tom_make_Fail() { 
return ( new tom.library.sl.Fail() );
}
private static boolean tom_is_fun_sym_Sequence( tom.library.sl.Strategy  t) {
return ( t instanceof tom.library.sl.Sequence );
}
private static  tom.library.sl.Strategy  tom_empty_list_Sequence() { 
return  null ;
}
private static  tom.library.sl.Strategy  tom_cons_list_Sequence( tom.library.sl.Strategy  head,  tom.library.sl.Strategy  tail) { 
return  tom.library.sl.Sequence.make(head,tail) ;
}
private static  tom.library.sl.Strategy  tom_get_head_Sequence_Strategy( tom.library.sl.Strategy  t) {
return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.Sequence.FIRST) );
}
private static  tom.library.sl.Strategy  tom_get_tail_Sequence_Strategy( tom.library.sl.Strategy  t) {
return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.Sequence.THEN) );
}
private static boolean tom_is_empty_Sequence_Strategy( tom.library.sl.Strategy  t) {
return ( t == null );
}

  private static   tom.library.sl.Strategy  tom_append_list_Sequence( tom.library.sl.Strategy  l1,  tom.library.sl.Strategy  l2) {
    if(( l1 == null )) {
      return l2;
    } else if(( l2 == null )) {
      return l1;
    } else if(( l1 instanceof tom.library.sl.Sequence )) {
      if(( ( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Sequence.THEN) ) == null )) {
        return  tom.library.sl.Sequence.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Sequence.FIRST) ),l2) ;
      } else {
        return  tom.library.sl.Sequence.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Sequence.FIRST) ),tom_append_list_Sequence(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Sequence.THEN) ),l2)) ;
      }
    } else {
      return  tom.library.sl.Sequence.make(l1,l2) ;
    }
  }
  private static   tom.library.sl.Strategy  tom_get_slice_Sequence( tom.library.sl.Strategy  begin,  tom.library.sl.Strategy  end, tom.library.sl.Strategy  tail) {
    if( (begin.equals(end)) ) {
      return tail;
    } else if( (end.equals(tail))  && (( end == null ) ||  (end.equals(tom_empty_list_Sequence())) )) {
      /* code to avoid a call to make, and thus to avoid looping during list-matching */
      return begin;
    }
    return  tom.library.sl.Sequence.make(((( begin instanceof tom.library.sl.Sequence ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.Sequence.FIRST) ):begin),( tom.library.sl.Strategy )tom_get_slice_Sequence(((( begin instanceof tom.library.sl.Sequence ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.Sequence.THEN) ):tom_empty_list_Sequence()),end,tail)) ;
  }
  private static boolean tom_is_fun_sym_Choice( tom.library.sl.Strategy  t) {
return ( t instanceof tom.library.sl.Choice );
}
private static  tom.library.sl.Strategy  tom_empty_list_Choice() { 
return  null ;
}
private static  tom.library.sl.Strategy  tom_cons_list_Choice( tom.library.sl.Strategy  head,  tom.library.sl.Strategy  tail) { 
return  tom.library.sl.Choice.make(head,tail) ;
}
private static  tom.library.sl.Strategy  tom_get_head_Choice_Strategy( tom.library.sl.Strategy  t) {
return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.Choice.FIRST) );
}
private static  tom.library.sl.Strategy  tom_get_tail_Choice_Strategy( tom.library.sl.Strategy  t) {
return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.Choice.THEN) );
}
private static boolean tom_is_empty_Choice_Strategy( tom.library.sl.Strategy  t) {
return ( t ==null );
}

  private static   tom.library.sl.Strategy  tom_append_list_Choice( tom.library.sl.Strategy  l1,  tom.library.sl.Strategy  l2) {
    if(( l1 ==null )) {
      return l2;
    } else if(( l2 ==null )) {
      return l1;
    } else if(( l1 instanceof tom.library.sl.Choice )) {
      if(( ( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Choice.THEN) ) ==null )) {
        return  tom.library.sl.Choice.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Choice.FIRST) ),l2) ;
      } else {
        return  tom.library.sl.Choice.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Choice.FIRST) ),tom_append_list_Choice(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.Choice.THEN) ),l2)) ;
      }
    } else {
      return  tom.library.sl.Choice.make(l1,l2) ;
    }
  }
  private static   tom.library.sl.Strategy  tom_get_slice_Choice( tom.library.sl.Strategy  begin,  tom.library.sl.Strategy  end, tom.library.sl.Strategy  tail) {
    if( (begin.equals(end)) ) {
      return tail;
    } else if( (end.equals(tail))  && (( end ==null ) ||  (end.equals(tom_empty_list_Choice())) )) {
      /* code to avoid a call to make, and thus to avoid looping during list-matching */
      return begin;
    }
    return  tom.library.sl.Choice.make(((( begin instanceof tom.library.sl.Choice ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.Choice.FIRST) ):begin),( tom.library.sl.Strategy )tom_get_slice_Choice(((( begin instanceof tom.library.sl.Choice ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.Choice.THEN) ):tom_empty_list_Choice()),end,tail)) ;
  }
  private static boolean tom_is_fun_sym_SequenceId( tom.library.sl.Strategy  t) {
return ( t instanceof tom.library.sl.SequenceId );
}
private static  tom.library.sl.Strategy  tom_empty_list_SequenceId() { 
return  null ;
}
private static  tom.library.sl.Strategy  tom_cons_list_SequenceId( tom.library.sl.Strategy  head,  tom.library.sl.Strategy  tail) { 
return  tom.library.sl.SequenceId.make(head,tail) ;
}
private static  tom.library.sl.Strategy  tom_get_head_SequenceId_Strategy( tom.library.sl.Strategy  t) {
return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.SequenceId.FIRST) );
}
private static  tom.library.sl.Strategy  tom_get_tail_SequenceId_Strategy( tom.library.sl.Strategy  t) {
return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.SequenceId.THEN) );
}
private static boolean tom_is_empty_SequenceId_Strategy( tom.library.sl.Strategy  t) {
return ( t == null );
}

  private static   tom.library.sl.Strategy  tom_append_list_SequenceId( tom.library.sl.Strategy  l1,  tom.library.sl.Strategy  l2) {
    if(( l1 == null )) {
      return l2;
    } else if(( l2 == null )) {
      return l1;
    } else if(( l1 instanceof tom.library.sl.SequenceId )) {
      if(( ( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.SequenceId.THEN) ) == null )) {
        return  tom.library.sl.SequenceId.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.SequenceId.FIRST) ),l2) ;
      } else {
        return  tom.library.sl.SequenceId.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.SequenceId.FIRST) ),tom_append_list_SequenceId(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.SequenceId.THEN) ),l2)) ;
      }
    } else {
      return  tom.library.sl.SequenceId.make(l1,l2) ;
    }
  }
  private static   tom.library.sl.Strategy  tom_get_slice_SequenceId( tom.library.sl.Strategy  begin,  tom.library.sl.Strategy  end, tom.library.sl.Strategy  tail) {
    if( (begin.equals(end)) ) {
      return tail;
    } else if( (end.equals(tail))  && (( end == null ) ||  (end.equals(tom_empty_list_SequenceId())) )) {
      /* code to avoid a call to make, and thus to avoid looping during list-matching */
      return begin;
    }
    return  tom.library.sl.SequenceId.make(((( begin instanceof tom.library.sl.SequenceId ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.SequenceId.FIRST) ):begin),( tom.library.sl.Strategy )tom_get_slice_SequenceId(((( begin instanceof tom.library.sl.SequenceId ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.SequenceId.THEN) ):tom_empty_list_SequenceId()),end,tail)) ;
  }
  private static boolean tom_is_fun_sym_ChoiceId( tom.library.sl.Strategy  t) {
return ( t instanceof tom.library.sl.ChoiceId );
}
private static  tom.library.sl.Strategy  tom_empty_list_ChoiceId() { 
return  null ;
}
private static  tom.library.sl.Strategy  tom_cons_list_ChoiceId( tom.library.sl.Strategy  head,  tom.library.sl.Strategy  tail) { 
return  tom.library.sl.ChoiceId.make(head,tail) ;
}
private static  tom.library.sl.Strategy  tom_get_head_ChoiceId_Strategy( tom.library.sl.Strategy  t) {
return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.ChoiceId.FIRST) );
}
private static  tom.library.sl.Strategy  tom_get_tail_ChoiceId_Strategy( tom.library.sl.Strategy  t) {
return ( (tom.library.sl.Strategy)t.getChildAt(tom.library.sl.ChoiceId.THEN) );
}
private static boolean tom_is_empty_ChoiceId_Strategy( tom.library.sl.Strategy  t) {
return ( t ==null );
}

  private static   tom.library.sl.Strategy  tom_append_list_ChoiceId( tom.library.sl.Strategy  l1,  tom.library.sl.Strategy  l2) {
    if(( l1 ==null )) {
      return l2;
    } else if(( l2 ==null )) {
      return l1;
    } else if(( l1 instanceof tom.library.sl.ChoiceId )) {
      if(( ( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.ChoiceId.THEN) ) ==null )) {
        return  tom.library.sl.ChoiceId.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.ChoiceId.FIRST) ),l2) ;
      } else {
        return  tom.library.sl.ChoiceId.make(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.ChoiceId.FIRST) ),tom_append_list_ChoiceId(( (tom.library.sl.Strategy)l1.getChildAt(tom.library.sl.ChoiceId.THEN) ),l2)) ;
      }
    } else {
      return  tom.library.sl.ChoiceId.make(l1,l2) ;
    }
  }
  private static   tom.library.sl.Strategy  tom_get_slice_ChoiceId( tom.library.sl.Strategy  begin,  tom.library.sl.Strategy  end, tom.library.sl.Strategy  tail) {
    if( (begin.equals(end)) ) {
      return tail;
    } else if( (end.equals(tail))  && (( end ==null ) ||  (end.equals(tom_empty_list_ChoiceId())) )) {
      /* code to avoid a call to make, and thus to avoid looping during list-matching */
      return begin;
    }
    return  tom.library.sl.ChoiceId.make(((( begin instanceof tom.library.sl.ChoiceId ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.ChoiceId.FIRST) ):begin),( tom.library.sl.Strategy )tom_get_slice_ChoiceId(((( begin instanceof tom.library.sl.ChoiceId ))?( (tom.library.sl.Strategy)begin.getChildAt(tom.library.sl.ChoiceId.THEN) ):tom_empty_list_ChoiceId()),end,tail)) ;
  }
  private static  tom.library.sl.Strategy  tom_make_OneId( tom.library.sl.Strategy  v) { 
return ( new tom.library.sl.OneId(v) );
}
private static  tom.library.sl.Strategy  tom_make_AllSeq( tom.library.sl.Strategy  s) { 
return ( new tom.library.sl.AllSeq(s) );
}
private static  tom.library.sl.Strategy  tom_make_AUCtl( tom.library.sl.Strategy  s1,  tom.library.sl.Strategy  s2) { 
return ( 
tom_make_mu(tom_make_MuVar("x"),tom_cons_list_Choice(s2,tom_cons_list_Choice(tom_cons_list_Sequence(tom_cons_list_Sequence(s1,tom_cons_list_Sequence(tom_make_All(tom_make_MuVar("x")),tom_empty_list_Sequence())),tom_cons_list_Sequence(tom_make_One(tom_make_Identity()),tom_empty_list_Sequence())),tom_empty_list_Choice()))))
;
}
private static  tom.library.sl.Strategy  tom_make_EUCtl( tom.library.sl.Strategy  s1,  tom.library.sl.Strategy  s2) { 
return ( 
tom_make_mu(tom_make_MuVar("x"),tom_cons_list_Choice(s2,tom_cons_list_Choice(tom_cons_list_Sequence(s1,tom_cons_list_Sequence(tom_make_One(tom_make_MuVar("x")),tom_empty_list_Sequence())),tom_empty_list_Choice()))))
;
}
private static  tom.library.sl.Strategy  tom_make_Try( tom.library.sl.Strategy  s) { 
return ( 
tom_cons_list_Choice(s,tom_cons_list_Choice(tom_make_Identity(),tom_empty_list_Choice())))
;
}
private static  tom.library.sl.Strategy  tom_make_Repeat( tom.library.sl.Strategy  s) { 
return ( 
tom_make_mu(tom_make_MuVar("_x"),tom_cons_list_Choice(tom_cons_list_Sequence(s,tom_cons_list_Sequence(tom_make_MuVar("_x"),tom_empty_list_Sequence())),tom_cons_list_Choice(tom_make_Identity(),tom_empty_list_Choice()))))
;
}
private static  tom.library.sl.Strategy  tom_make_TopDown( tom.library.sl.Strategy  v) { 
return ( 
tom_make_mu(tom_make_MuVar("_x"),tom_cons_list_Sequence(v,tom_cons_list_Sequence(tom_make_All(tom_make_MuVar("_x")),tom_empty_list_Sequence()))))
;
}
private static  tom.library.sl.Strategy  tom_make_BottomUp( tom.library.sl.Strategy  v) { 
return ( 
tom_make_mu(tom_make_MuVar("_x"),tom_cons_list_Sequence(tom_make_All(tom_make_MuVar("_x")),tom_cons_list_Sequence(v,tom_empty_list_Sequence()))))
;
}
private static  tom.library.sl.Strategy  tom_make_OnceTopDown( tom.library.sl.Strategy  v) { 
return ( 
tom_make_mu(tom_make_MuVar("_x"),tom_cons_list_Choice(v,tom_cons_list_Choice(tom_make_One(tom_make_MuVar("_x")),tom_empty_list_Choice()))))
;
}
private static  tom.library.sl.Strategy  tom_make_RepeatId( tom.library.sl.Strategy  v) { 
return ( 
tom_make_mu(tom_make_MuVar("_x"),tom_cons_list_SequenceId(v,tom_cons_list_SequenceId(tom_make_MuVar("_x"),tom_empty_list_SequenceId()))))
;
}
private static  tom.library.sl.Strategy  tom_make_OnceTopDownId( tom.library.sl.Strategy  v) { 
return ( 
tom_make_mu(tom_make_MuVar("_x"),tom_cons_list_ChoiceId(v,tom_cons_list_ChoiceId(tom_make_OneId(tom_make_MuVar("_x")),tom_empty_list_ChoiceId()))))
;
}
private static  tom.library.sl.Strategy  tom_make_InnermostId( tom.library.sl.Strategy  v) { 
return ( 
tom_make_mu(tom_make_MuVar("_x"),tom_cons_list_Sequence(tom_make_All(tom_make_MuVar("_x")),tom_cons_list_Sequence(tom_cons_list_SequenceId(v,tom_cons_list_SequenceId(tom_make_MuVar("_x"),tom_empty_list_SequenceId())),tom_empty_list_Sequence()))))
;
}
private static boolean tom_equal_term_boolean(boolean t1, boolean t2) {
return  t1==t2 ;
}
private static boolean tom_is_sort_boolean(boolean t) {
return  true ;
}
private static boolean tom_equal_term_long(long t1, long t2) {
return  t1==t2 ;
}
private static boolean tom_is_sort_long(long t) {
return  true ;
}
private static boolean tom_equal_term_float(float t1, float t2) {
return  t1==t2 ;
}
private static boolean tom_is_sort_float(float t) {
return  true ;
}
private static boolean tom_equal_term_double(double t1, double t2) {
return  t1==t2 ;
}
private static boolean tom_is_sort_double(double t) {
return  true ;
}


private static <O> EList<O> enforce(EList l) {
return l;
}

private static <O> EList<O> append(O e,EList<O> l) {
l.add(e);
return l;
}
private static Expression tom_make_intConst( long  _value) { 
return org.polymodel.polyhedralIR.internal.PolyhedralIRTomFactory.createIntConst(_value);
}
private static boolean tom_is_fun_sym_caseExpr(Expression t) {
return t instanceof CaseExpression;
}
private static Expression tom_make_caseExpr( EList<Expression>  _exprs) { 
return org.polymodel.polyhedralIR.internal.PolyhedralIRTomFactory.createCaseExpr(_exprs);
}
private static  EList<Expression>  tom_get_slot_caseExpr_exprs(Expression t) {
return enforce(((CaseExpression)t).getExprs());
}
private static boolean tom_is_fun_sym_ifExpr(Expression t) {
return t instanceof IfExpression;
}
private static Expression tom_make_ifExpr(Expression _cond, Expression _then, Expression _else) { 
return org.polymodel.polyhedralIR.internal.PolyhedralIRTomFactory.createIfExpr(_cond, _then, _else);
}
private static Expression tom_get_slot_ifExpr_cond(Expression t) {
return ((IfExpression)t).getCond();
}
private static Expression tom_get_slot_ifExpr_then(Expression t) {
return ((IfExpression)t).getThen();
}
private static Expression tom_get_slot_ifExpr_else(Expression t) {
return ((IfExpression)t).getElse();
}
private static boolean tom_is_fun_sym_restrictExpr(Expression t) {
return t instanceof RestrictExpression;
}
private static Expression tom_make_restrictExpr(Domain _restrictDomain, Expression _expr) { 
return org.polymodel.polyhedralIR.internal.PolyhedralIRTomFactory.createRestrictExpr(_restrictDomain, _expr);
}
private static Domain tom_get_slot_restrictExpr_restrictDomain(Expression t) {
return ((RestrictExpression)t).getRestrictDomain();
}
private static Expression tom_get_slot_restrictExpr_expr(Expression t) {
return ((RestrictExpression)t).getExpr();
}
private static boolean tom_is_fun_sym_depExpr(Expression t) {
return t instanceof DependenceExpression;
}
private static Expression tom_make_depExpr(AffineFunction _dep, Expression _expr) { 
return org.polymodel.polyhedralIR.internal.PolyhedralIRTomFactory.createDepExpr(_dep, _expr);
}
private static AffineFunction tom_get_slot_depExpr_dep(Expression t) {
return ((DependenceExpression)t).getDep();
}
private static Expression tom_get_slot_depExpr_expr(Expression t) {
return ((DependenceExpression)t).getExpr();
}
private static boolean tom_is_fun_sym_indexExpr(Expression t) {
return t instanceof IndexExpression;
}
private static Expression tom_make_indexExpr(AffineFunction _function) { 
return org.polymodel.polyhedralIR.internal.PolyhedralIRTomFactory.createIndexExpr(_function);
}
private static AffineFunction tom_get_slot_indexExpr_function(Expression t) {
return ((IndexExpression)t).getFunction();
}
private static boolean tom_is_fun_sym_binOp(Expression t) {
return t instanceof BinaryExpression;
}
private static Expression tom_make_binOp(OP _operator, Expression _lexp, Expression _rexp) { 
return org.polymodel.polyhedralIR.internal.PolyhedralIRTomFactory.createBinOp(_operator, _lexp, _rexp);
}
private static OP tom_get_slot_binOp_operator(Expression t) {
return ((BinaryExpression)t).getOperator();
}
private static Expression tom_get_slot_binOp_lexp(Expression t) {
return ((BinaryExpression)t).getLexp();
}
private static Expression tom_get_slot_binOp_rexp(Expression t) {
return ((BinaryExpression)t).getRexp();
}
private static boolean tom_is_fun_sym_unaryOp(Expression t) {
return t instanceof UnaryExpression;
}
private static Expression tom_make_unaryOp(OP _operator, Expression _expr) { 
return org.polymodel.polyhedralIR.internal.PolyhedralIRTomFactory.createUnaryOp(_operator, _expr);
}
private static OP tom_get_slot_unaryOp_operator(Expression t) {
return ((UnaryExpression)t).getOperator();
}
private static Expression tom_get_slot_unaryOp_expr(Expression t) {
return ((UnaryExpression)t).getExpr();
}
private static boolean tom_is_fun_sym_multOp(Expression t) {
return t instanceof MultiArgExpression;
}
private static Expression tom_make_multOp(OP _operator,  EList<Expression>  _exprs) { 
return org.polymodel.polyhedralIR.internal.PolyhedralIRTomFactory.createMultOp(_operator, _exprs);
}
private static OP tom_get_slot_multOp_operator(Expression t) {
return ((MultiArgExpression)t).getOperator();
}
private static  EList<Expression>  tom_get_slot_multOp_exprs(Expression t) {
return enforce(((MultiArgExpression)t).getExprs());
}
private static boolean tom_is_fun_sym_externalCall(Expression t) {
return t instanceof ExternalFunctionCall;
}
private static Expression tom_make_externalCall(OP _operator,  EList<Expression>  _exprs, ExternalFunctionDeclaration _exFunc) { 
return org.polymodel.polyhedralIR.internal.PolyhedralIRTomFactory.createExternalCall(_operator, _exprs, _exFunc);
}
private static OP tom_get_slot_externalCall_operator(Expression t) {
return ((ExternalFunctionCall)t).getOperator();
}
private static  EList<Expression>  tom_get_slot_externalCall_exprs(Expression t) {
return enforce(((ExternalFunctionCall)t).getExprs());
}
private static ExternalFunctionDeclaration tom_get_slot_externalCall_exFunc(Expression t) {
return ((ExternalFunctionCall)t).getExFunc();
}
private static boolean tom_equal_term_SIGNED(Object l1, Object l2) {
return l1==l2;
}
private static boolean tom_is_sort_SIGNED(Object t) {
return t instanceof SIGNED;
}
private static boolean tom_equal_term_DATATYPE(Object l1, Object l2) {
return l1==l2;
}
private static boolean tom_is_sort_DATATYPE(Object t) {
return t instanceof DATATYPE;
}
private static boolean tom_equal_term_OP(Object l1, Object l2) {
return l1==l2;
}
private static boolean tom_is_sort_OP(Object t) {
return t instanceof OP;
}
private static boolean tom_equal_term_TILING_TYPE(Object l1, Object l2) {
return l1==l2;
}
private static boolean tom_is_sort_TILING_TYPE(Object t) {
return t instanceof TILING_TYPE;
}
private static boolean tom_equal_term_TILE_SIZE_TYPE(Object l1, Object l2) {
return l1==l2;
}
private static boolean tom_is_sort_TILE_SIZE_TYPE(Object t) {
return t instanceof TILE_SIZE_TYPE;
}
private static boolean tom_equal_term_MEMORY_TYPE(Object l1, Object l2) {
return l1==l2;
}
private static boolean tom_is_sort_MEMORY_TYPE(Object t) {
return t instanceof MEMORY_TYPE;
}
private static boolean tom_equal_term_Program(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_Program(Object t) {
return t instanceof Program;
}
private static boolean tom_equal_term_System(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_System(Object t) {
return t instanceof AffineSystem;
}
private static boolean tom_equal_term_AffineFunction(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_AffineFunction(Object t) {
return t instanceof AffineFunction;
}
private static boolean tom_equal_term_Domain(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_Domain(Object t) {
return t instanceof Domain;
}
private static boolean tom_equal_term_ParameterDomain(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_ParameterDomain(Object t) {
return t instanceof ParameterDomain;
}
private static boolean tom_equal_term_Expression(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_Expression(Object t) {
return t instanceof Expression;
}
private static boolean tom_equal_term_exprList(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_exprList(Object t) {
return  t instanceof EList<?> &&
    	(((EList<Expression>)t).size() == 0 
    	|| (((EList<Expression>)t).size()>0 && ((EList<Expression>)t).get(0) instanceof Expression));
}
private static boolean tom_is_fun_sym_exprList( EList<Expression>  t) {
return  t instanceof EList<?> &&
 		(((EList<Expression>)t).size() == 0 
 		|| (((EList<Expression>)t).size()>0 && ((EList<Expression>)t).get(0) instanceof Expression));
}
private static  EList<Expression>  tom_empty_array_exprList(int n) { 
return  new BasicEList<Expression>(n) ;
}
private static  EList<Expression>  tom_cons_array_exprList(Expression e,  EList<Expression>  l) { 
return  append(e,l) ;
}
private static Expression tom_get_element_exprList_exprList( EList<Expression>  l, int n) {
return  l.get(n) ;
}
private static int tom_get_size_exprList_exprList( EList<Expression>  l) {
return  l.size() ;
}

  private static   EList<Expression>  tom_get_slice_exprList( EList<Expression>  subject, int begin, int end) {
     EList<Expression>  result =  new BasicEList<Expression>(end-begin) ;
    while(begin!=end) {
      result =  append( subject.get(begin) ,result) ;
      begin++;
    }
    return result;
  }

  private static   EList<Expression>  tom_append_array_exprList( EList<Expression>  l2,  EList<Expression>  l1) {
    int size1 =  l1.size() ;
    int size2 =  l2.size() ;
    int index;
     EList<Expression>  result =  new BasicEList<Expression>(size1+size2) ;
    index=size1;
    while(index >0) {
      result =  append( l1.get(size1-index) ,result) ;
      index--;
    }

    index=size2;
    while(index > 0) {
      result =  append( l2.get(size2-index) ,result) ;
      index--;
    }
    return result;
  }private static boolean tom_equal_term_UseEquation(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_UseEquation(Object t) {
return t instanceof UseEquation;
}
private static boolean tom_equal_term_StandardEquation(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_StandardEquation(Object t) {
return t instanceof StandardEquation;
}
private static boolean tom_equal_term_VariableDeclaration(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_VariableDeclaration(Object t) {
return t instanceof VariableDeclaration;
}
private static boolean tom_equal_term_VariableIdentifier(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_VariableIdentifier(Object t) {
return t instanceof VariableIdentifier;
}
private static boolean tom_equal_term_ExternalFunctionDeclaration(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_ExternalFunctionDeclaration(Object t) {
return t instanceof ExternalFunctionDeclaration;
}
private static boolean tom_equal_term_extFuncDeclList(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_extFuncDeclList(Object t) {
return  t instanceof EList<?> &&
    	(((EList<ExternalFunctionDeclaration>)t).size() == 0 
    	|| (((EList<ExternalFunctionDeclaration>)t).size()>0 && ((EList<ExternalFunctionDeclaration>)t).get(0) instanceof ExternalFunctionDeclaration));
}
private static boolean tom_equal_term_SystemList(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_SystemList(Object t) {
return  t instanceof EList<?> &&
    	(((EList<AffineSystem>)t).size() == 0 
    	|| (((EList<AffineSystem>)t).size()>0 && ((EList<AffineSystem>)t).get(0) instanceof AffineSystem));
}
private static boolean tom_equal_term_VariableDeclarationList(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_VariableDeclarationList(Object t) {
return  t instanceof EList<?> &&
    	(((EList<VariableDeclaration>)t).size() == 0 
    	|| (((EList<VariableDeclaration>)t).size()>0 && ((EList<VariableDeclaration>)t).get(0) instanceof VariableDeclaration));
}
private static boolean tom_equal_term_StandardEquationList(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_StandardEquationList(Object t) {
return  t instanceof EList<?> &&
    	(((EList<StandardEquation>)t).size() == 0 
    	|| (((EList<StandardEquation>)t).size()>0 && ((EList<StandardEquation>)t).get(0) instanceof StandardEquation));
}
private static boolean tom_equal_term_UseEquationList(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_UseEquationList(Object t) {
return  t instanceof EList<?> &&
    	(((EList<UseEquation>)t).size() == 0 
    	|| (((EList<UseEquation>)t).size()>0 && ((EList<UseEquation>)t).get(0) instanceof UseEquation));
}


public static Expression removeEmptyBranch(Expression e) {
try {
//System.out.println();
//System.out.println("EMPTY BRANCH: " + PolyhedralIRToAlphabets.toString(e));

if (!(e instanceof CaseExpression))
return e;
CaseExpression caseExpr = (CaseExpression) e;
if (caseExpr.getExprs().size() < EMPTY_BRANCH_THOLD)
return e;

Domain tempDom = null;
List<Expression> nonEmptyExprs = new BasicEList<Expression>();
for(Expression expr : caseExpr.getExprs()) {
if (expr instanceof RestrictExpression) {
if (!((RestrictExpression) expr).getRestrictDomain().isEmpty())
nonEmptyExprs.add(expr);
tempDom = ((RestrictExpression) expr).getRestrictDomain();
}
}

//remove empty branches
caseExpr.getExprs().clear();
caseExpr.getExprs().addAll(nonEmptyExprs);



if (caseExpr.getExprs().size() == 0) {
Domain emptyDom = PolyhedralIRUtility.createEmptyDomain(tempDom.getParams(), tempDom.getIndices());		// TODO: potential bug here
AffineFunction emptyFunc = PolyhedralIRUtility.createProjection(emptyDom, new BasicEList<Variable>());	

return 
tom_make_restrictExpr(emptyDom,tom_make_depExpr(emptyFunc,tom_make_intConst(1)));
} else if (caseExpr.getExprs().size() == 1) {
return caseExpr.getExprs().get(0);
} else {
return caseExpr;
}
} catch (Exception ex) {
return e;
}
}


public static class RemoveEmptyBranch extends tom.library.sl.AbstractStrategyBasic {
public RemoveEmptyBranch() {
super(tom_make_Identity());
}
public tom.library.sl.Visitable[] getChildren() {
tom.library.sl.Visitable[] stratChildren = new tom.library.sl.Visitable[getChildCount()];
stratChildren[0] = super.getChildAt(0);
return stratChildren;}
public tom.library.sl.Visitable setChildren(tom.library.sl.Visitable[] children) {
super.setChildAt(0, children[0]);
return this;
}
public int getChildCount() {
return 1;
}
public tom.library.sl.Visitable getChildAt(int index) {
switch (index) {
case 0: return super.getChildAt(0);
default: throw new IndexOutOfBoundsException();
}
}
public tom.library.sl.Visitable setChildAt(int index, tom.library.sl.Visitable child) {
switch (index) {
case 0: return super.setChildAt(0, child);
default: throw new IndexOutOfBoundsException();
}
}
@SuppressWarnings("unchecked")
public <T> T visitLight(T v, tom.library.sl.Introspector introspector)
 throws tom.library.sl.VisitFailure {
if (tom_is_sort_Expression(v)) {
return ((T)visit_Expression(((Expression)v),introspector));
}
if (!(( null  == environment))) {
return ((T)any.visit(environment,introspector));
} else {
return any.visitLight(v,introspector);
}
}
@SuppressWarnings("unchecked")
public Expression _visit_Expression(Expression arg, tom.library.sl.Introspector introspector)
 throws tom.library.sl.VisitFailure {
if (!(( null  == environment))) {
return ((Expression)any.visit(environment,introspector));
} else {
return any.visitLight(arg,introspector);
}
}
@SuppressWarnings("unchecked")
public Expression visit_Expression(Expression tom__arg, tom.library.sl.Introspector introspector)
 throws tom.library.sl.VisitFailure {
{
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_caseExpr(((Expression)((Expression)tom__arg)))) {

return removeEmptyBranch((CaseExpression)
((Expression)tom__arg));

}
}
}
}
}
return _visit_Expression(tom__arg,introspector);
}
}
private static  tom.library.sl.Strategy  tom_make_RemoveEmptyBranch() { 
return new RemoveEmptyBranch();
}
public static class NormalizeIdentityFunction extends tom.library.sl.AbstractStrategyBasic {
public NormalizeIdentityFunction() {
super(tom_make_Identity());
}
public tom.library.sl.Visitable[] getChildren() {
tom.library.sl.Visitable[] stratChildren = new tom.library.sl.Visitable[getChildCount()];
stratChildren[0] = super.getChildAt(0);
return stratChildren;}
public tom.library.sl.Visitable setChildren(tom.library.sl.Visitable[] children) {
super.setChildAt(0, children[0]);
return this;
}
public int getChildCount() {
return 1;
}
public tom.library.sl.Visitable getChildAt(int index) {
switch (index) {
case 0: return super.getChildAt(0);
default: throw new IndexOutOfBoundsException();
}
}
public tom.library.sl.Visitable setChildAt(int index, tom.library.sl.Visitable child) {
switch (index) {
case 0: return super.setChildAt(0, child);
default: throw new IndexOutOfBoundsException();
}
}
@SuppressWarnings("unchecked")
public <T> T visitLight(T v, tom.library.sl.Introspector introspector)
 throws tom.library.sl.VisitFailure {
if (tom_is_sort_Expression(v)) {
return ((T)visit_Expression(((Expression)v),introspector));
}
if (!(( null  == environment))) {
return ((T)any.visit(environment,introspector));
} else {
return any.visitLight(v,introspector);
}
}
@SuppressWarnings("unchecked")
public Expression _visit_Expression(Expression arg, tom.library.sl.Introspector introspector)
 throws tom.library.sl.VisitFailure {
if (!(( null  == environment))) {
return ((Expression)any.visit(environment,introspector));
} else {
return any.visitLight(arg,introspector);
}
}
@SuppressWarnings("unchecked")
public Expression visit_Expression(Expression tom__arg, tom.library.sl.Introspector introspector)
 throws tom.library.sl.VisitFailure {
{
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_depExpr(((Expression)((Expression)tom__arg)))) {
Expression tom_expr=tom_get_slot_depExpr_expr(((Expression)tom__arg));

if(DEBUG){
//System.out.println("start normalize identity funciton");
}
AffineFunction identity = PolyhedralIRUtility.createIdentityFunction(
tom_expr.getExpressionDomain());
if(
tom_get_slot_depExpr_dep(((Expression)tom__arg)).equivalence(identity)){
if(DEBUG){
System.out.println("dependence expression with identity function");
System.out.flush();
}
return 
tom_expr;
}

}
}
}
}
}
return _visit_Expression(tom__arg,introspector);
}
}


private static void debug(String name, String rule, String other) {
if (DEBUG) System.out.println(name+": " + rule + " " + other);
}


public static class EfficientNormalizeRule extends tom.library.sl.AbstractStrategyBasic {
public EfficientNormalizeRule() {
super(tom_make_Identity());
}
public tom.library.sl.Visitable[] getChildren() {
tom.library.sl.Visitable[] stratChildren = new tom.library.sl.Visitable[getChildCount()];
stratChildren[0] = super.getChildAt(0);
return stratChildren;}
public tom.library.sl.Visitable setChildren(tom.library.sl.Visitable[] children) {
super.setChildAt(0, children[0]);
return this;
}
public int getChildCount() {
return 1;
}
public tom.library.sl.Visitable getChildAt(int index) {
switch (index) {
case 0: return super.getChildAt(0);
default: throw new IndexOutOfBoundsException();
}
}
public tom.library.sl.Visitable setChildAt(int index, tom.library.sl.Visitable child) {
switch (index) {
case 0: return super.setChildAt(0, child);
default: throw new IndexOutOfBoundsException();
}
}
@SuppressWarnings("unchecked")
public <T> T visitLight(T v, tom.library.sl.Introspector introspector)
 throws tom.library.sl.VisitFailure {
if (tom_is_sort_Expression(v)) {
return ((T)visit_Expression(((Expression)v),introspector));
}
if (!(( null  == environment))) {
return ((T)any.visit(environment,introspector));
} else {
return any.visitLight(v,introspector);
}
}
@SuppressWarnings("unchecked")
public Expression _visit_Expression(Expression arg, tom.library.sl.Introspector introspector)
 throws tom.library.sl.VisitFailure {
if (!(( null  == environment))) {
return ((Expression)any.visit(environment,introspector));
} else {
return any.visitLight(arg,introspector);
}
}
@SuppressWarnings("unchecked")
public Expression visit_Expression(Expression tom__arg, tom.library.sl.Introspector introspector)
 throws tom.library.sl.VisitFailure {
{
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_depExpr(((Expression)((Expression)tom__arg)))) {
Expression tomMatch3_2=tom_get_slot_depExpr_expr(((Expression)tom__arg));
AffineFunction tom_func=tom_get_slot_depExpr_dep(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch3_2)) {
if (tom_is_fun_sym_binOp(((Expression)tomMatch3_2))) {

debug("rule1", "dep@(A op B) -> dep@A op dep@B", "");
return 
tom_make_binOp(tom_get_slot_binOp_operator(tomMatch3_2),tom_make_depExpr(tom_func.copy(),tom_get_slot_binOp_lexp(tomMatch3_2)),tom_make_depExpr(tom_func,tom_get_slot_binOp_rexp(tomMatch3_2)));

}
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_binOp(((Expression)((Expression)tom__arg)))) {
Expression tomMatch3_12=tom_get_slot_binOp_lexp(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch3_12)) {
if (tom_is_fun_sym_restrictExpr(((Expression)tomMatch3_12))) {

debug("rule2a", "((dom : A) op B) -> dom : (A op B)", "");
return 
tom_make_restrictExpr(tom_get_slot_restrictExpr_restrictDomain(tomMatch3_12),tom_make_binOp(tom_get_slot_binOp_operator(((Expression)tom__arg)),tom_get_slot_restrictExpr_expr(tomMatch3_12),tom_get_slot_binOp_rexp(((Expression)tom__arg))));

}
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_binOp(((Expression)((Expression)tom__arg)))) {
Expression tomMatch3_23=tom_get_slot_binOp_rexp(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch3_23)) {
if (tom_is_fun_sym_restrictExpr(((Expression)tomMatch3_23))) {

debug("rule2b", "(A op (dom : B)) -> dom : (A op B)", "");
return 
tom_make_restrictExpr(tom_get_slot_restrictExpr_restrictDomain(tomMatch3_23),tom_make_binOp(tom_get_slot_binOp_operator(((Expression)tom__arg)),tom_get_slot_binOp_lexp(((Expression)tom__arg)),tom_get_slot_restrictExpr_expr(tomMatch3_23)));

}
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_depExpr(((Expression)((Expression)tom__arg)))) {
Expression tomMatch3_32=tom_get_slot_depExpr_expr(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch3_32)) {
if (tom_is_fun_sym_depExpr(((Expression)tomMatch3_32))) {

debug("rule3", "depA@depB@E -> (depB o depA)@E", "");
return 
tom_make_depExpr(tom_get_slot_depExpr_dep(tomMatch3_32).compose(tom_get_slot_depExpr_dep(((Expression)tom__arg))),tom_get_slot_depExpr_expr(tomMatch3_32));

}
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_restrictExpr(((Expression)((Expression)tom__arg)))) {
Expression tomMatch3_41=tom_get_slot_restrictExpr_expr(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch3_41)) {
if (tom_is_fun_sym_restrictExpr(((Expression)tomMatch3_41))) {

debug("rule4", "domA : domB : E -> (domA intersection domB)@E", "");

Domain domain = 
tom_get_slot_restrictExpr_restrictDomain(((Expression)tom__arg)).intersection(
tom_get_slot_restrictExpr_restrictDomain(tomMatch3_41));
return 
tom_make_restrictExpr(domain,tom_get_slot_restrictExpr_expr(tomMatch3_41).copy());

}
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_depExpr(((Expression)((Expression)tom__arg)))) {
Expression tomMatch3_50=tom_get_slot_depExpr_expr(((Expression)tom__arg));
AffineFunction tom_func=tom_get_slot_depExpr_dep(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch3_50)) {
if (tom_is_fun_sym_restrictExpr(((Expression)tomMatch3_50))) {

debug("rule5", "dep@(dom : E)-> dom.preimage(dep) : (dep@E)", "");

return 
tom_make_restrictExpr(tom_get_slot_restrictExpr_restrictDomain(tomMatch3_50).preimage(tom_func),tom_make_depExpr(tom_func,tom_get_slot_restrictExpr_expr(tomMatch3_50)));

}
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_depExpr(((Expression)((Expression)tom__arg)))) {
Expression tomMatch3_59=tom_get_slot_depExpr_expr(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch3_59)) {
if (tom_is_fun_sym_unaryOp(((Expression)tomMatch3_59))) {

debug("rule6", "dep@(op E)-> op (dep@E)", "");
return 
tom_make_unaryOp(tom_get_slot_unaryOp_operator(tomMatch3_59),tom_make_depExpr(tom_get_slot_depExpr_dep(((Expression)tom__arg)),tom_get_slot_unaryOp_expr(tomMatch3_59)));

}
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_unaryOp(((Expression)((Expression)tom__arg)))) {
Expression tomMatch3_68=tom_get_slot_unaryOp_expr(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch3_68)) {
if (tom_is_fun_sym_restrictExpr(((Expression)tomMatch3_68))) {

debug("rule7", "(op dom : E)-> dom : (op E)", "");
return 
tom_make_restrictExpr(tom_get_slot_restrictExpr_restrictDomain(tomMatch3_68),tom_make_unaryOp(tom_get_slot_unaryOp_operator(((Expression)tom__arg)),tom_get_slot_restrictExpr_expr(tomMatch3_68)));

}
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_depExpr(((Expression)((Expression)tom__arg)))) {
Expression tomMatch3_77=tom_get_slot_depExpr_expr(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch3_77)) {
if (tom_is_fun_sym_externalCall(((Expression)tomMatch3_77))) {

debug("rule8b", "dep @ exf(op, E)-> exf(op, dep@E)", "");

EList<Expression> newExprs = new BasicEList<Expression>();
List<Expression> tempList = new LinkedList<Expression>();
tempList.addAll(
tom_get_slot_externalCall_exprs(tomMatch3_77));

for(Expression expn :tempList)
newExprs.add(PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(
tom_get_slot_depExpr_dep(((Expression)tom__arg)).copy(), expn));
return 
tom_make_externalCall(tom_get_slot_externalCall_operator(tomMatch3_77),newExprs,tom_get_slot_externalCall_exFunc(tomMatch3_77));

}
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_depExpr(((Expression)((Expression)tom__arg)))) {
Expression tomMatch3_87=tom_get_slot_depExpr_expr(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch3_87)) {
if (tom_is_fun_sym_multOp(((Expression)tomMatch3_87))) {

debug("rule8a", "dep @ f(op, E)-> f(op, dep@E)", "");

EList<Expression> newExprs = new BasicEList<Expression>();
List<Expression> tempList = new LinkedList<Expression>();
tempList.addAll(
tom_get_slot_multOp_exprs(tomMatch3_87));

for(Expression expn : tempList)
newExprs.add(PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(
tom_get_slot_depExpr_dep(((Expression)tom__arg)).copy(), expn));

return 
tom_make_multOp(tom_get_slot_multOp_operator(tomMatch3_87),newExprs);

}
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_depExpr(((Expression)((Expression)tom__arg)))) {
Expression tomMatch3_96=tom_get_slot_depExpr_expr(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch3_96)) {
if (tom_is_fun_sym_indexExpr(((Expression)tomMatch3_96))) {

debug("rule9", "dep@(val(f) -> val(f o dep)", "");

return 
tom_make_indexExpr(tom_get_slot_indexExpr_function(tomMatch3_96).compose(tom_get_slot_depExpr_dep(((Expression)tom__arg))));

}
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_caseExpr(((Expression)((Expression)tom__arg)))) {
 EList<Expression>  tomMatch3_103=tom_get_slot_caseExpr_exprs(((Expression)tom__arg));
if (tom_is_fun_sym_exprList((( EList<Expression> )tomMatch3_103))) {
int tomMatch3_107=0;
int tomMatch3_end_110=tomMatch3_107;
do {
{
if (!(tomMatch3_end_110 >= tom_get_size_exprList_exprList(tomMatch3_103))) {
Expression tomMatch3_116=tom_get_element_exprList_exprList(tomMatch3_103,tomMatch3_end_110);
if (tom_is_sort_Expression(tomMatch3_116)) {
if (tom_is_fun_sym_caseExpr(((Expression)tomMatch3_116))) {

debug("rule10", "case E1; case E2 esac; E3; esac -> case E1; E2; E3; esac", "");

EList<Expression> newExprs = new BasicEList<Expression>();
newExprs.addAll(
tom_get_slice_exprList(tomMatch3_103,tomMatch3_107,tomMatch3_end_110));
newExprs.addAll(
tom_get_slot_caseExpr_exprs(tomMatch3_116));
newExprs.addAll(
tom_get_slice_exprList(tomMatch3_103,tomMatch3_end_110 + 1,tom_get_size_exprList_exprList(tomMatch3_103)));

CaseExpression caseExpr =  (CaseExpression)
tom_make_caseExpr(newExprs);

assert(caseExpr.getExprs().size() > 0);

return caseExpr;

}
}
}
tomMatch3_end_110=tomMatch3_end_110 + 1;
}
} while(!(tomMatch3_end_110 > tom_get_size_exprList_exprList(tomMatch3_103)));
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_binOp(((Expression)((Expression)tom__arg)))) {
Expression tomMatch3_120=tom_get_slot_binOp_lexp(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch3_120)) {
if (tom_is_fun_sym_caseExpr(((Expression)tomMatch3_120))) {

debug("rule11a", "case E1; esac op E2 -> case E1 op E2; esac", "");

EList<Expression> newExprs = new BasicEList<Expression>();
List<Expression> tempList = new LinkedList<Expression>();
tempList.addAll(
tom_get_slot_caseExpr_exprs(tomMatch3_120));

for(Expression expn : tempList)
newExprs.add(
tom_make_binOp(tom_get_slot_binOp_operator(((Expression)tom__arg)),expn,tom_get_slot_binOp_rexp(((Expression)tom__arg)).copy()));

CaseExpression caseExpr =  (CaseExpression)
tom_make_caseExpr(newExprs);

assert(caseExpr.getExprs().size() > 0);

return caseExpr;

}
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_binOp(((Expression)((Expression)tom__arg)))) {
Expression tomMatch3_130=tom_get_slot_binOp_rexp(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch3_130)) {
if (tom_is_fun_sym_caseExpr(((Expression)tomMatch3_130))) {

debug("rule11b", "E1 op case E2; esac -> case E1 op E2; esac", "");

EList<Expression> newExprs = new BasicEList<Expression>();
List<Expression> tempList = new LinkedList<Expression>();
tempList.addAll(
tom_get_slot_caseExpr_exprs(tomMatch3_130));

for(Expression expn : tempList)
newExprs.add(
tom_make_binOp(tom_get_slot_binOp_operator(((Expression)tom__arg)),tom_get_slot_binOp_lexp(((Expression)tom__arg)).copy(),expn));

CaseExpression caseExpr =  (CaseExpression)
tom_make_caseExpr(newExprs);

assert(caseExpr.getExprs().size() > 0);

return caseExpr;

}
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_unaryOp(((Expression)((Expression)tom__arg)))) {
Expression tomMatch3_138=tom_get_slot_unaryOp_expr(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch3_138)) {
if (tom_is_fun_sym_caseExpr(((Expression)tomMatch3_138))) {

debug("rule12", "op case E; esac -> case op E; esac", "");

EList<Expression> newExprs = new BasicEList<Expression>();
List<Expression> tempList = new LinkedList<Expression>();
tempList.addAll(
tom_get_slot_caseExpr_exprs(tomMatch3_138));

for(Expression expn :tempList)
newExprs.add(
tom_make_unaryOp(tom_get_slot_unaryOp_operator(((Expression)tom__arg)),expn));

CaseExpression caseExpr =  (CaseExpression)
tom_make_caseExpr(newExprs);

assert(caseExpr.getExprs().size() > 0);

return caseExpr;

}
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_externalCall(((Expression)((Expression)tom__arg)))) {
 EList<Expression>  tomMatch3_146=tom_get_slot_externalCall_exprs(((Expression)tom__arg));
if (tom_is_fun_sym_exprList((( EList<Expression> )tomMatch3_146))) {
int tomMatch3_151=0;
if (!(tomMatch3_151 >= tom_get_size_exprList_exprList(tomMatch3_146))) {
Expression tomMatch3_154=tom_get_element_exprList_exprList(tomMatch3_146,tomMatch3_151);
if (tom_is_sort_Expression(tomMatch3_154)) {
if (tom_is_fun_sym_caseExpr(((Expression)tomMatch3_154))) {
if (tomMatch3_151 + 1 >= tom_get_size_exprList_exprList(tomMatch3_146)) {

debug("rule13", "f(op, case E; esac) -> case f(op, E) esac;", "");

EList<Expression> newExprs = new BasicEList<Expression>();
List<Expression> tempList = new LinkedList<Expression>();
tempList.addAll(
tom_get_slot_caseExpr_exprs(tomMatch3_154));

for(Expression expn : tempList){
ExternalFunctionCall ext = (ExternalFunctionCall)
tom_make_externalCall(tom_get_slot_externalCall_operator(((Expression)tom__arg)),tom_cons_array_exprList(expn.copy(),tom_empty_array_exprList(1)),tom_get_slot_externalCall_exFunc(((Expression)tom__arg)));
ext.setExFunc(((ExternalFunctionCall)
((Expression)tom__arg)).getExFunc());
newExprs.add(ext);
}

CaseExpression caseExpr =  (CaseExpression)
tom_make_caseExpr(newExprs);

assert(caseExpr.getExprs().size() > 0);

return caseExpr;

}
}
}
}
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_depExpr(((Expression)((Expression)tom__arg)))) {
Expression tomMatch3_158=tom_get_slot_depExpr_expr(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch3_158)) {
if (tom_is_fun_sym_caseExpr(((Expression)tomMatch3_158))) {

debug("rule14", "dep case E; esac -> case dep E; esac", "");

EList<Expression> newExprs = new BasicEList<Expression>();
List<Expression> tempList = new LinkedList<Expression>();
tempList.addAll(
tom_get_slot_caseExpr_exprs(tomMatch3_158));

for(Expression expn : tempList){
Expression depExpn = 
tom_make_depExpr(tom_get_slot_depExpr_dep(((Expression)tom__arg)).copy(),expn);
newExprs.add(depExpn);
}

CaseExpression caseExpr =  (CaseExpression)
tom_make_caseExpr(newExprs);

assert(caseExpr.getExprs().size() > 0);

return caseExpr;

}
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_restrictExpr(((Expression)((Expression)tom__arg)))) {
Expression tomMatch3_166=tom_get_slot_restrictExpr_expr(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch3_166)) {
if (tom_is_fun_sym_caseExpr(((Expression)tomMatch3_166))) {

debug("rule15", "dom : case E; esac -> case dom : E; esac", "");

EList<Expression> newExprs = new BasicEList<Expression>();
List<Expression> tempList = new LinkedList<Expression>();
tempList.addAll(
tom_get_slot_caseExpr_exprs(tomMatch3_166));


for(Expression expn : tempList){
Expression restExp = 
tom_make_restrictExpr(tom_get_slot_restrictExpr_restrictDomain(((Expression)tom__arg)).copy(),expn.copy());
newExprs.add(restExp);
}

CaseExpression caseExpr =  (CaseExpression)
tom_make_caseExpr(newExprs);

assert(caseExpr.getExprs().size() > 0);

return caseExpr;

}
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_depExpr(((Expression)((Expression)tom__arg)))) {
Expression tomMatch3_174=tom_get_slot_depExpr_expr(((Expression)tom__arg));
AffineFunction tom_func=tom_get_slot_depExpr_dep(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch3_174)) {
if (tom_is_fun_sym_ifExpr(((Expression)tomMatch3_174))) {

debug("rule16", "dep @ if (cond, then, else) -> if(dep@cond, dep@then, dep@else) ", "");

return 
tom_make_ifExpr(tom_make_depExpr(tom_func.copy(),tom_get_slot_ifExpr_cond(tomMatch3_174)),tom_make_depExpr(tom_func.copy(),tom_get_slot_ifExpr_then(tomMatch3_174)),tom_make_depExpr(tom_func.copy(),tom_get_slot_ifExpr_else(tomMatch3_174)));

}
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_ifExpr(((Expression)((Expression)tom__arg)))) {
Expression tomMatch3_183=tom_get_slot_ifExpr_cond(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch3_183)) {
if (tom_is_fun_sym_restrictExpr(((Expression)tomMatch3_183))) {

debug("rule17a", "if(dom : cond, then, else) -> dom : if (cond, then, else)", "");

return 
tom_make_restrictExpr(tom_get_slot_restrictExpr_restrictDomain(tomMatch3_183),tom_make_ifExpr(tom_get_slot_restrictExpr_expr(tomMatch3_183),tom_get_slot_ifExpr_then(((Expression)tom__arg)),tom_get_slot_ifExpr_else(((Expression)tom__arg))));

}
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_ifExpr(((Expression)((Expression)tom__arg)))) {
Expression tomMatch3_194=tom_get_slot_ifExpr_then(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch3_194)) {
if (tom_is_fun_sym_restrictExpr(((Expression)tomMatch3_194))) {

debug("rule17b", "if(cond, dom : then, else) -> dom : if (cond, then, else)", "");

return 
tom_make_restrictExpr(tom_get_slot_restrictExpr_restrictDomain(tomMatch3_194),tom_make_ifExpr(tom_get_slot_ifExpr_cond(((Expression)tom__arg)),tom_get_slot_restrictExpr_expr(tomMatch3_194),tom_get_slot_ifExpr_else(((Expression)tom__arg))));

}
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_ifExpr(((Expression)((Expression)tom__arg)))) {
Expression tomMatch3_205=tom_get_slot_ifExpr_else(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch3_205)) {
if (tom_is_fun_sym_restrictExpr(((Expression)tomMatch3_205))) {

debug("rule17c", "if(cond, then, dom : else) -> dom : if (cond, then, else)", "");

return 
tom_make_restrictExpr(tom_get_slot_restrictExpr_restrictDomain(tomMatch3_205),tom_make_ifExpr(tom_get_slot_ifExpr_cond(((Expression)tom__arg)),tom_get_slot_ifExpr_then(((Expression)tom__arg)),tom_get_slot_restrictExpr_expr(tomMatch3_205)));

}
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_ifExpr(((Expression)((Expression)tom__arg)))) {
Expression tomMatch3_213=tom_get_slot_ifExpr_cond(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch3_213)) {
if (tom_is_fun_sym_caseExpr(((Expression)tomMatch3_213))) {

debug("rule18a", "if(case E; esac, then, else) -> esac if (E, then, else); case", "");

EList<Expression> newExprs = new BasicEList<Expression>();
List<Expression> tempList = new LinkedList<Expression>();
tempList.addAll(
tom_get_slot_caseExpr_exprs(tomMatch3_213));

for(Expression expn : tempList){
Expression ifExpn = 
tom_make_ifExpr(expn.copy(),tom_get_slot_ifExpr_then(((Expression)tom__arg)).copy(),tom_get_slot_ifExpr_else(((Expression)tom__arg)).copy());
newExprs.add(ifExpn);
}

CaseExpression caseExpr = (CaseExpression)
tom_make_caseExpr(newExprs);
assert(caseExpr.getExprs().size() > 0);

return 
caseExpr;

}
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_ifExpr(((Expression)((Expression)tom__arg)))) {
Expression tomMatch3_223=tom_get_slot_ifExpr_then(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch3_223)) {
if (tom_is_fun_sym_caseExpr(((Expression)tomMatch3_223))) {

debug("rule18b", "if(cond, case E; esac, else) -> esac if (cond, E, else); case", "");

EList<Expression> newExprs = new BasicEList<Expression>();
List<Expression> tempList = new LinkedList<Expression>();
tempList.addAll(
tom_get_slot_caseExpr_exprs(tomMatch3_223));

for(Expression expn : tempList){
Expression ifExpn = 
tom_make_ifExpr(tom_get_slot_ifExpr_cond(((Expression)tom__arg)).copy(),expn.copy(),tom_get_slot_ifExpr_else(((Expression)tom__arg)).copy());
newExprs.add(ifExpn);
}

CaseExpression caseExpr = (CaseExpression)
tom_make_caseExpr(newExprs);
assert(caseExpr.getExprs().size() > 0);

return 
caseExpr;

}
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_ifExpr(((Expression)((Expression)tom__arg)))) {
Expression tomMatch3_233=tom_get_slot_ifExpr_else(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch3_233)) {
if (tom_is_fun_sym_caseExpr(((Expression)tomMatch3_233))) {

debug("rule18c", "if(cond, then, case E; esac) -> esac if (cond, then, E); case", "");

EList<Expression> newExprs = new BasicEList<Expression>();
List<Expression> tempList = new LinkedList<Expression>();
tempList.addAll(
tom_get_slot_caseExpr_exprs(tomMatch3_233));

for(Expression expn : tempList){
Expression ifExpn = 
tom_make_ifExpr(tom_get_slot_ifExpr_cond(((Expression)tom__arg)).copy(),tom_get_slot_ifExpr_then(((Expression)tom__arg)).copy(),expn.copy());
newExprs.add(ifExpn);
}

CaseExpression caseExpr = (CaseExpression)
tom_make_caseExpr(newExprs);
assert(caseExpr.getExprs().size() > 0);

return 
caseExpr;

}
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_externalCall(((Expression)((Expression)tom__arg)))) {
 EList<Expression>  tomMatch3_241=tom_get_slot_externalCall_exprs(((Expression)tom__arg));
if (tom_is_fun_sym_exprList((( EList<Expression> )tomMatch3_241))) {
int tomMatch3_246=0;
if (!(tomMatch3_246 >= tom_get_size_exprList_exprList(tomMatch3_241))) {
Expression tomMatch3_250=tom_get_element_exprList_exprList(tomMatch3_241,tomMatch3_246);
if (tom_is_sort_Expression(tomMatch3_250)) {
if (tom_is_fun_sym_restrictExpr(((Expression)tomMatch3_250))) {
if (tomMatch3_246 + 1 >= tom_get_size_exprList_exprList(tomMatch3_241)) {

debug("rule19", "exFunc(op, dom : E) -> dom : exFunc(op, E)", "");
return 
tom_make_restrictExpr(tom_get_slot_restrictExpr_restrictDomain(tomMatch3_250),tom_make_externalCall(tom_get_slot_externalCall_operator(((Expression)tom__arg)),tom_cons_array_exprList(tom_get_slot_restrictExpr_expr(tomMatch3_250),tom_empty_array_exprList(1)),tom_get_slot_externalCall_exFunc(((Expression)tom__arg))));

}
}
}
}
}
}
}
}
}
}
return _visit_Expression(tom__arg,introspector);
}
}
private static  tom.library.sl.Strategy  tom_make_EfficientNormalizeRule() { 
return new EfficientNormalizeRule();
}


}
