package org.polymodel.polyhedralIR.transformation;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.DimensionsManager;
import org.polymodel.algebra.Variable;
import org.polymodel.factory.PolymodelComponent;
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
import org.polymodel.polyhedralIR.expression.BooleanExpression;
import org.polymodel.polyhedralIR.expression.CaseExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.ExternalFunctionCall;
import org.polymodel.polyhedralIR.expression.IfExpression;
import org.polymodel.polyhedralIR.expression.IndexExpression;
import org.polymodel.polyhedralIR.expression.IntegerExpression;
import org.polymodel.polyhedralIR.expression.MultiArgExpression;
import org.polymodel.polyhedralIR.expression.RealExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.expression.UnaryExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRModule;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;
import org.polymodel.polyhedralIR.transformation.helper.FunctionOperations;
import org.polymodel.polyhedralIR.util.ContextDomainCalculator;

import tom.library.sl.VisitFailure;

public class LowerDependences extends PolyhedralIRTomTransformation {

public static boolean DEBUG = true;

private static DimensionsManager _dimMana = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);

public static void lowerDependences(AffineSystem syst) {
AffineSystem nsyst = syst.copy();
for (StandardEquation stEq : nsyst.getEquations())
stEq.setExpression(lowerDependences(stEq.getExpression()));
for (UseEquation uEq : nsyst.getUseEquations()) {
List<Expression> uEqnInputs = new BasicEList<Expression>();
for (int k=0; k<uEq.getInputs().size(); k++)
uEq.getInputs().set(k, lowerDependences(uEq.getInputs().get(k)));
}
ContextDomainCalculator.computeContextDomain(nsyst);
}


public static Expression lowerDependences(Expression expr){
// DEBUG
//System.out.println("Expression in : " + PolyhedralIRToAlphabets.toString(expr));

LowerDependences lDep = new LowerDependences();
Expression nExpr = lDep.ntransform(expr);

// DEBUG
//System.out.println("Expression out : " + PolyhedralIRToAlphabets.toString(nExpr) + "\n");
return nExpr;
}

protected Expression ntransform(Expression expr){
return (Expression) gtransform(expr);
}

protected LowerDependences(){}

@Override
protected EObject apply(EObject o) throws VisitFailure {
EObject t = null;
if (o instanceof Expression) {
t = 
tom_make_BottomUp(tom_make_AddDependencesVariables()).visitLight(o, tom.mapping.GenericIntrospector.INSTANCE);
//t = `TopDown(LowerDependencesStrat()).visitLight(t, tom.mapping.GenericIntrospector.INSTANCE);
//t = `TopDown(MergeDependences()).visitLight(t, tom.mapping.GenericIntrospector.INSTANCE);
return t;
} else {
throw new RuntimeException("LowerDependences can only be applied to Expression");
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
private static boolean tom_is_fun_sym_var(Expression t) {
return t instanceof VariableExpression;
}
private static VariableDeclaration tom_get_slot_var_varDecl(Expression t) {
return ((VariableExpression)t).getVarDecl();
}
private static boolean tom_is_fun_sym_boolConst(Expression t) {
return t instanceof BooleanExpression;
}
private static  boolean  tom_get_slot_boolConst_value(Expression t) {
return ((BooleanExpression)t).isValue();
}
private static boolean tom_is_fun_sym_intConst(Expression t) {
return t instanceof IntegerExpression;
}
private static  long  tom_get_slot_intConst_value(Expression t) {
return ((IntegerExpression)t).getValue();
}
private static boolean tom_is_fun_sym_realConst(Expression t) {
return t instanceof RealExpression;
}
private static  double  tom_get_slot_realConst_value(Expression t) {
return ((RealExpression)t).getValue();
}
private static boolean tom_is_fun_sym_reduce(Expression t) {
return t instanceof ReduceExpression;
}
private static Expression tom_make_reduce(OP _OP, AffineFunction _projection, Expression _expr) { 
return org.polymodel.polyhedralIR.internal.PolyhedralIRTomFactory.createReduce(_OP, _projection, _expr);
}
private static OP tom_get_slot_reduce_OP(Expression t) {
return ((ReduceExpression)t).getOP();
}
private static AffineFunction tom_get_slot_reduce_projection(Expression t) {
return ((ReduceExpression)t).getProjection();
}
private static Expression tom_get_slot_reduce_expr(Expression t) {
return ((ReduceExpression)t).getExpr();
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
private static boolean tom_equal_term_UseEquation(Object l1, Object l2) {
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


private static void debug(String name, String rule, String other) {
if (DEBUG) System.out.println(name+": " + rule + " " + other);
}


public static class AddDependencesVariables extends tom.library.sl.AbstractStrategyBasic {
public AddDependencesVariables() {
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
if (tom_is_fun_sym_var(((Expression)((Expression)tom__arg)))) {
Expression tom_varExpr=((Expression)tom__arg);

int nDimVar = 
tom_varExpr.getExpressionDomain().getNIndices();
long[][] linId = new long[nDimVar][nDimVar];
for (int i=0; i<linId.length; i++)
linId[i][i] = 1;
AffineFunction idFunc = FunctionOperations.createAffineFunctionFromMatrix(new long[nDimVar][0],
linId, new long[nDimVar], 
tom_varExpr.getExpressionDomain().getParams(), 
tom_varExpr.getExpressionDomain().getIndices());			
return PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(idFunc,
PolyhedralIRUserFactory.eINSTANCE.createVariableExpression(
tom_get_slot_var_varDecl(((Expression)tom__arg))));

}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_boolConst(((Expression)((Expression)tom__arg)))) {
Expression tom_cst=((Expression)tom__arg);

int nDimVar = 
tom_cst.getExpressionDomain().getNIndices();
long[][] linId = new long[nDimVar][nDimVar];
for (int i=0; i<linId.length; i++)
linId[i][i] = 1;
AffineFunction idFunc = FunctionOperations.createAffineFunctionFromMatrix(new long[nDimVar][0],
linId, new long[nDimVar], 
tom_cst.getExpressionDomain().getParams(), 
tom_cst.getExpressionDomain().getIndices());
return PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(idFunc,
PolyhedralIRUserFactory.eINSTANCE.createBooleanExpression(
tom_get_slot_boolConst_value(((Expression)tom__arg))));

}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_intConst(((Expression)((Expression)tom__arg)))) {
Expression tom_cst=((Expression)tom__arg);

int nDimVar = 
tom_cst.getExpressionDomain().getNIndices();
long[][] linId = new long[nDimVar][nDimVar];
for (int i=0; i<linId.length; i++)
linId[i][i] = 1;
AffineFunction idFunc = FunctionOperations.createAffineFunctionFromMatrix(new long[nDimVar][0],
linId, new long[nDimVar], 
tom_cst.getExpressionDomain().getParams(), 
tom_cst.getExpressionDomain().getIndices());
return PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(idFunc,
PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(
tom_get_slot_intConst_value(((Expression)tom__arg))));

}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_realConst(((Expression)((Expression)tom__arg)))) {
Expression tom_cst=((Expression)tom__arg);

int nDimVar = 
tom_cst.getExpressionDomain().getNIndices();
long[][] linId = new long[nDimVar][nDimVar];
for (int i=0; i<linId.length; i++)
linId[i][i] = 1;
AffineFunction idFunc = FunctionOperations.createAffineFunctionFromMatrix(new long[nDimVar][0],
linId, new long[nDimVar], 
tom_cst.getExpressionDomain().getParams(), 
tom_cst.getExpressionDomain().getIndices());
return PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(idFunc,
PolyhedralIRUserFactory.eINSTANCE.createRealExpression(
tom_get_slot_realConst_value(((Expression)tom__arg))));

}
}
}
}
}
return _visit_Expression(tom__arg,introspector);
}
}
private static  tom.library.sl.Strategy  tom_make_AddDependencesVariables() { 
return new AddDependencesVariables();
}
public static class LowerDependencesStrat extends tom.library.sl.AbstractStrategyBasic {
public LowerDependencesStrat() {
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
Expression tomMatch2_2=tom_get_slot_depExpr_expr(((Expression)tom__arg));
AffineFunction tom_func=tom_get_slot_depExpr_dep(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch2_2)) {
if (tom_is_fun_sym_binOp(((Expression)tomMatch2_2))) {

debug("rule1", "dep@(A op B) -> dep@A op dep@B", "");
return 
tom_make_binOp(tom_get_slot_binOp_operator(tomMatch2_2),tom_make_depExpr(tom_func.copy(),tom_get_slot_binOp_lexp(tomMatch2_2)),tom_make_depExpr(tom_func,tom_get_slot_binOp_rexp(tomMatch2_2)));

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
Expression tomMatch2_12=tom_get_slot_depExpr_expr(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch2_12)) {
if (tom_is_fun_sym_depExpr(((Expression)tomMatch2_12))) {

debug("rule3", "depA@depB@E -> (depB o depA)@E", "");
return 
tom_make_depExpr(tom_get_slot_depExpr_dep(tomMatch2_12).compose(tom_get_slot_depExpr_dep(((Expression)tom__arg))),tom_get_slot_depExpr_expr(tomMatch2_12));

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
Expression tomMatch2_21=tom_get_slot_depExpr_expr(((Expression)tom__arg));
AffineFunction tom_func=tom_get_slot_depExpr_dep(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch2_21)) {
if (tom_is_fun_sym_restrictExpr(((Expression)tomMatch2_21))) {

debug("rule5", "dep@(dom : E)-> dom.preimage(dep) : (dep@E)", "");

return 
tom_make_restrictExpr(tom_get_slot_restrictExpr_restrictDomain(tomMatch2_21).preimage(tom_func),tom_make_depExpr(tom_func,tom_get_slot_restrictExpr_expr(tomMatch2_21)));

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
Expression tomMatch2_30=tom_get_slot_depExpr_expr(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch2_30)) {
if (tom_is_fun_sym_unaryOp(((Expression)tomMatch2_30))) {

debug("rule6", "dep@(op E)-> op (dep@E)", "");
return 
tom_make_unaryOp(tom_get_slot_unaryOp_operator(tomMatch2_30),tom_make_depExpr(tom_get_slot_depExpr_dep(((Expression)tom__arg)),tom_get_slot_unaryOp_expr(tomMatch2_30)));

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
Expression tomMatch2_39=tom_get_slot_depExpr_expr(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch2_39)) {
if (tom_is_fun_sym_externalCall(((Expression)tomMatch2_39))) {

debug("rule8b", "dep @ exf(op, E)-> exf(op, dep@E)", "");

EList<Expression> newExprs = new BasicEList<Expression>();
List<Expression> tempList = new LinkedList<Expression>();
tempList.addAll(
tom_get_slot_externalCall_exprs(tomMatch2_39));

for(Expression expn :tempList)
newExprs.add(PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(
tom_get_slot_depExpr_dep(((Expression)tom__arg)).copy(), expn));
return 
tom_make_externalCall(tom_get_slot_externalCall_operator(tomMatch2_39),newExprs,tom_get_slot_externalCall_exFunc(tomMatch2_39));

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
Expression tomMatch2_49=tom_get_slot_depExpr_expr(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch2_49)) {
if (tom_is_fun_sym_multOp(((Expression)tomMatch2_49))) {

debug("rule8a", "dep @ f(op, E)-> f(op, dep@E)", "");

EList<Expression> newExprs = new BasicEList<Expression>();
List<Expression> tempList = new LinkedList<Expression>();
tempList.addAll(
tom_get_slot_multOp_exprs(tomMatch2_49));

for(Expression expn : tempList)
newExprs.add(PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(
tom_get_slot_depExpr_dep(((Expression)tom__arg)).copy(), expn));

return 
tom_make_multOp(tom_get_slot_multOp_operator(tomMatch2_49),newExprs);

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
Expression tomMatch2_58=tom_get_slot_depExpr_expr(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch2_58)) {
if (tom_is_fun_sym_indexExpr(((Expression)tomMatch2_58))) {

debug("rule9", "dep@(val(f) -> val(f o dep)", "");

return 
tom_make_indexExpr(tom_get_slot_indexExpr_function(tomMatch2_58).compose(tom_get_slot_depExpr_dep(((Expression)tom__arg))));

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
Expression tomMatch2_66=tom_get_slot_depExpr_expr(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch2_66)) {
if (tom_is_fun_sym_caseExpr(((Expression)tomMatch2_66))) {

debug("rule14", "dep case E; esac -> case dep E; esac", "");

EList<Expression> newExprs = new BasicEList<Expression>();
List<Expression> tempList = new LinkedList<Expression>();
tempList.addAll(
tom_get_slot_caseExpr_exprs(tomMatch2_66));

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
if (tom_is_fun_sym_depExpr(((Expression)((Expression)tom__arg)))) {
Expression tomMatch2_74=tom_get_slot_depExpr_expr(((Expression)tom__arg));
AffineFunction tom_func=tom_get_slot_depExpr_dep(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch2_74)) {
if (tom_is_fun_sym_ifExpr(((Expression)tomMatch2_74))) {

debug("rule16", "dep @ if (cond, then, else) -> if(dep@cond, dep@then, dep@else) ", "");

return 
tom_make_ifExpr(tom_make_depExpr(tom_func.copy(),tom_get_slot_ifExpr_cond(tomMatch2_74)),tom_make_depExpr(tom_func.copy(),tom_get_slot_ifExpr_then(tomMatch2_74)),tom_make_depExpr(tom_func.copy(),tom_get_slot_ifExpr_else(tomMatch2_74)));

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
Expression tomMatch2_84=tom_get_slot_depExpr_expr(((Expression)tom__arg));
AffineFunction tom_g=tom_get_slot_depExpr_dep(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch2_84)) {
if (tom_is_fun_sym_reduce(((Expression)tomMatch2_84))) {
AffineFunction tom_f=tom_get_slot_reduce_projection(tomMatch2_84);

debug("rule42", "dep @ red(op, f, expr) -> red(op, f1, dep1@expr)", "");

// Define f' as "Id-like" projection function
int qDim = 
tom_f.getNIndices() + 
tom_g.getNIndices() - 
tom_g.getDimRHS();
long[][] linF1 = new long[
tom_g.getDimRHS()][qDim];
for (int i=0; i<linF1.length; i++)
linF1[i][i] = 1;

List<Variable> lIndsf1 = new BasicEList<Variable>();
for (int i=0; i<qDim; i++)
lIndsf1.add(_dimMana.getDimension(i));

AffineFunction f1 = FunctionOperations.createAffineFunctionFromMatrix(new long[
tom_g.getDimRHS()][0],
linF1, new long[
tom_g.getDimRHS()], 
tom_g.getParams(), lIndsf1);

// Define g' = f_{right inverse} o g o f'
AffineFunction fRInv = FunctionOperations.computeRightInverse(
tom_f);

// DEBUG TODO
//System.out.println("f1 = " + f1);
//System.out.println("g = " +`g);
//System.out.println("fRInv = " + fRInv);

AffineFunction gf1 = 
tom_g.compose(f1);
AffineFunction g1 = fRInv.compose(gf1);

return 
tom_make_reduce(tom_get_slot_reduce_OP(tomMatch2_84),f1,tom_make_depExpr(g1,tom_get_slot_reduce_expr(tomMatch2_84)));


}
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_reduce(((Expression)((Expression)tom__arg)))) {
OP tom_op=tom_get_slot_reduce_OP(((Expression)tom__arg));
AffineFunction tom_f=tom_get_slot_reduce_projection(((Expression)tom__arg));
Expression tom_exprBody=tom_get_slot_reduce_expr(((Expression)tom__arg));

debug("rule42b", "red(op, f, expr) -> red(op, f1, dep@expr) if f is not canonic", "");

// Is f canonic ?
long[][] fLinPart = FunctionOperations.getMatrixRepresentation(
tom_f).getValue1();
boolean isCanonic = true;
for (int i=0; i<fLinPart.length; i++)
for (int j=0; j<fLinPart[0].length; j++)
if (i==j) {
if (fLinPart[i][j]!=1)
isCanonic = false;
} else {
if (fLinPart[i][j]!=0)
isCanonic = false;
}

if (isCanonic)
return 
tom_make_reduce(tom_op,tom_f,tom_exprBody);

// f is not canonic => we extract the dependence (cf rule42 for the details)

// New projection functionZ
long[][] linF1 = new long[
tom_f.getDimRHS()][
tom_f.getNIndices()];
for (int i=0; i<linF1.length; i++)
linF1[i][i] = 1;
List<Variable> lIndsf1 = new BasicEList<Variable>();
for (int i=0; i<
tom_f.getNIndices(); i++)
lIndsf1.add(_dimMana.getDimension(i));

AffineFunction f1 = FunctionOperations.createAffineFunctionFromMatrix(new long[
tom_f.getDimRHS()][0],
linF1, new long[
tom_f.getDimRHS()], 
tom_f.getParams(), lIndsf1);

AffineFunction fRInv = FunctionOperations.computeRightInverse(
tom_f);
AffineFunction g1 = fRInv.compose(f1);

return 
tom_make_reduce(tom_op,f1,tom_make_depExpr(g1,tom_exprBody));

}
}
}
}
}
return _visit_Expression(tom__arg,introspector);
}
}
public static class MergeDependences extends tom.library.sl.AbstractStrategyBasic {
public MergeDependences() {
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
if (tom_is_sort_Expression(tomMatch3_2)) {
if (tom_is_fun_sym_depExpr(((Expression)tomMatch3_2))) {

debug("rule3", "depA@depB@E -> (depB o depA)@E", "");
return 
tom_make_depExpr(tom_get_slot_depExpr_dep(tomMatch3_2).compose(tom_get_slot_depExpr_dep(((Expression)tom__arg))),tom_get_slot_depExpr_expr(tomMatch3_2));

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

}
