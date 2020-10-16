package org.polymodel.polyhedralIR.transformation;

import java.util.Map;


import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.isl.ISLSet;
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
import org.polymodel.polyhedralIR.expression.IfExpression;
import org.polymodel.polyhedralIR.expression.IndexExpression;
import org.polymodel.polyhedralIR.expression.IntegerExpression;
import org.polymodel.polyhedralIR.expression.RealExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations;

import tom.library.sl.VisitFailure;

public class Simplify extends PolyhedralIRTomTransformation {

private static boolean modified = false;

public static void simplify(Program p){
Simplify s = new Simplify();
s.transform(p);
}


public static void simplify(AffineSystem as){
Simplify s = new Simplify();
s.transform(as);
}
protected Simplify(){} 

@Override
protected EObject apply(EObject o) throws VisitFailure {
modified = true;
while (modified) {
modified = false;
o = 
tom_make_BottomUp(tom_make_SimplifyExpr()).visitLight(o, tom.mapping.GenericIntrospector.INSTANCE);
}
return o;
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
private static boolean tom_is_fun_sym_intConst(Expression t) {
return t instanceof IntegerExpression;
}
private static Expression tom_make_intConst( long  _value) { 
return org.polymodel.polyhedralIR.internal.PolyhedralIRTomFactory.createIntConst(_value);
}
private static  long  tom_get_slot_intConst_value(Expression t) {
return ((IntegerExpression)t).getValue();
}
private static boolean tom_is_fun_sym_reduce(Expression t) {
return t instanceof ReduceExpression;
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
private static  EList<Expression>  tom_get_slot_caseExpr_exprs(Expression t) {
return enforce(((CaseExpression)t).getExprs());
}
private static boolean tom_is_fun_sym_ifExpr(Expression t) {
return t instanceof IfExpression;
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
private static boolean tom_is_fun_sym_binAdd(Expression t) {
return t instanceof BinaryExpression && ((BinaryExpression)t).getOperator().equals(OP.ADD);
}
private static Expression tom_get_slot_binAdd_lexp(Expression t) {
return ((BinaryExpression)t).getLexp();
}
private static Expression tom_get_slot_binAdd_rexp(Expression t) {
return ((BinaryExpression)t).getRexp();
}
private static boolean tom_is_fun_sym_binMul(Expression t) {
return t instanceof BinaryExpression && ((BinaryExpression)t).getOperator().equals(OP.MUL);
}
private static Expression tom_get_slot_binMul_lexp(Expression t) {
return ((BinaryExpression)t).getLexp();
}
private static Expression tom_get_slot_binMul_rexp(Expression t) {
return ((BinaryExpression)t).getRexp();
}
private static boolean tom_is_fun_sym_binEq(Expression t) {
return t instanceof BinaryExpression && ((BinaryExpression)t).getOperator().equals(OP.EQ);
}
private static Expression tom_get_slot_binEq_lexp(Expression t) {
return ((BinaryExpression)t).getLexp();
}
private static Expression tom_get_slot_binEq_rexp(Expression t) {
return ((BinaryExpression)t).getRexp();
}
private static boolean tom_is_fun_sym_val(Expression t) {
return t instanceof IndexExpression;
}
private static AffineFunction tom_get_slot_val_function(Expression t) {
return ((IndexExpression)t).getFunction();
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
public static class SimplifyExpr extends tom.library.sl.AbstractStrategyBasic {
public SimplifyExpr() {
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
if (tom_is_fun_sym_ifExpr(((Expression)((Expression)tom__arg)))) {
Expression tomMatch1_1=tom_get_slot_ifExpr_cond(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch1_1)) {
if (tom_is_fun_sym_binEq(((Expression)tomMatch1_1))) {

return simplifyIfExpr((IfExpression)
((Expression)tom__arg), (BinaryExpression)
tomMatch1_1);

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
Expression tom_expr=((Expression)tom__arg);

if (checkScalarReduction((ReduceExpression)
tom_expr)) {
modified = true;
return simplifyScalarReduction((ReduceExpression)
tom_expr);
} else {
return 
tom_expr;
}

}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_caseExpr(((Expression)((Expression)tom__arg)))) {
 EList<Expression>  tomMatch1_17=tom_get_slot_caseExpr_exprs(((Expression)tom__arg));
if (tom_is_fun_sym_exprList((( EList<Expression> )tomMatch1_17))) {
int tomMatch1_21=0;
if (!(tomMatch1_21 >= tom_get_size_exprList_exprList(tomMatch1_17))) {
if (tomMatch1_21 + 1 >= tom_get_size_exprList_exprList(tomMatch1_17)) {

modified = true;
return 
tom_get_element_exprList_exprList(tomMatch1_17,tomMatch1_21);

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
if (tom_is_fun_sym_caseExpr(((Expression)((Expression)tom__arg)))) {
 EList<Expression>  tomMatch1_24=tom_get_slot_caseExpr_exprs(((Expression)tom__arg));
if (tom_is_fun_sym_exprList((( EList<Expression> )tomMatch1_24))) {
int tomMatch1_28=0;
if (!(tomMatch1_28 >= tom_get_size_exprList_exprList(tomMatch1_24))) {
Expression tom_exprA=tom_get_element_exprList_exprList(tomMatch1_24,tomMatch1_28);
int tomMatch1_29=tomMatch1_28 + 1;
int tomMatch1_end_32=tomMatch1_29;
do {
{
if (!(tomMatch1_end_32 >= tom_get_size_exprList_exprList(tomMatch1_24))) {
Expression tom_exprB=tom_get_element_exprList_exprList(tomMatch1_24,tomMatch1_end_32);
if (tomMatch1_end_32 + 1 >= tom_get_size_exprList_exprList(tomMatch1_24)) {

EList<Expression> newExprs = 
tom_get_slice_exprList(tomMatch1_24,tomMatch1_29,tomMatch1_end_32);
int count = 0;
if (!
tom_exprA.getContextDomain().isEmpty()) {
newExprs.add(
tom_exprA);
count++;
}
if (!
tom_exprB.getContextDomain().isEmpty()) {
newExprs.add(
tom_exprB);
count++;
}
if (count < 2) {
modified = true;
return PolyhedralIRUserFactory.eINSTANCE.createCaseExpression(newExprs);
} else {
return 
((Expression)tom__arg);
}

}
}
tomMatch1_end_32=tomMatch1_end_32 + 1;
}
} while(!(tomMatch1_end_32 > tom_get_size_exprList_exprList(tomMatch1_24)));
}
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_val(((Expression)((Expression)tom__arg)))) {
AffineFunction tom_f=tom_get_slot_val_function(((Expression)tom__arg));

boolean isConstant = 
tom_f.getExpressions().size() == 1 && 
tom_f.getExpressions().get(0).isConstant() == FuzzyBoolean.YES;
if (isConstant) { return 
tom_make_intConst(tom_f.getExpressions().get(0).getConstantTerm().getCoef()); } else { return 
((Expression)tom__arg); } 

}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_binAdd(((Expression)((Expression)tom__arg)))) {
Expression tomMatch1_40=tom_get_slot_binAdd_lexp(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch1_40)) {
if (tom_is_fun_sym_depExpr(((Expression)tomMatch1_40))) {
Expression tomMatch1_45=tom_get_slot_depExpr_expr(tomMatch1_40);
if (tom_is_sort_Expression(tomMatch1_45)) {
if (tom_is_fun_sym_intConst(((Expression)tomMatch1_45))) {
 long  tomMatch1_48=tom_get_slot_intConst_value(tomMatch1_45);
if ( true ) {
if (tom_equal_term_long(0L, tomMatch1_48)) {
return 
tom_get_slot_binAdd_rexp(((Expression)tom__arg)); 
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
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_binAdd(((Expression)((Expression)tom__arg)))) {
Expression tomMatch1_55=tom_get_slot_binAdd_rexp(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch1_55)) {
if (tom_is_fun_sym_depExpr(((Expression)tomMatch1_55))) {
Expression tomMatch1_59=tom_get_slot_depExpr_expr(tomMatch1_55);
if (tom_is_sort_Expression(tomMatch1_59)) {
if (tom_is_fun_sym_intConst(((Expression)tomMatch1_59))) {
 long  tomMatch1_62=tom_get_slot_intConst_value(tomMatch1_59);
if ( true ) {
if (tom_equal_term_long(0L, tomMatch1_62)) {
return 
tom_get_slot_binAdd_lexp(((Expression)tom__arg)); 
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
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_binAdd(((Expression)((Expression)tom__arg)))) {
Expression tomMatch1_68=tom_get_slot_binAdd_lexp(((Expression)tom__arg));
Expression tomMatch1_69=tom_get_slot_binAdd_rexp(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch1_68)) {
if (tom_is_fun_sym_depExpr(((Expression)tomMatch1_68))) {
Expression tomMatch1_73=tom_get_slot_depExpr_expr(tomMatch1_68);
AffineFunction tom_func=tom_get_slot_depExpr_dep(tomMatch1_68);
if (tom_is_sort_Expression(tomMatch1_73)) {
if (tom_is_fun_sym_intConst(((Expression)tomMatch1_73))) {
 long  tomMatch1_76=tom_get_slot_intConst_value(tomMatch1_73);
if ( true ) {
if (tom_equal_term_long(0L, tomMatch1_76)) {
if (tom_is_sort_Expression(tomMatch1_69)) {
if (tom_is_fun_sym_depExpr(((Expression)tomMatch1_69))) {
Expression tomMatch1_82=tom_get_slot_depExpr_expr(tomMatch1_69);
if (tom_equal_term_AffineFunction(tom_func, tom_get_slot_depExpr_dep(tomMatch1_69))) {
if (tom_is_sort_Expression(tomMatch1_82)) {
if (tom_is_fun_sym_intConst(((Expression)tomMatch1_82))) {
 long  tomMatch1_85=tom_get_slot_intConst_value(tomMatch1_82);
if ( true ) {
if (tom_equal_term_long(0L, tomMatch1_85)) {
return 
tom_make_depExpr(tom_func,tom_make_intConst(0L)); 
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
if (tom_is_fun_sym_binMul(((Expression)((Expression)tom__arg)))) {
Expression tomMatch1_92=tom_get_slot_binMul_lexp(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch1_92)) {
if (tom_is_fun_sym_depExpr(((Expression)tomMatch1_92))) {
Expression tomMatch1_97=tom_get_slot_depExpr_expr(tomMatch1_92);
if (tom_is_sort_Expression(tomMatch1_97)) {
if (tom_is_fun_sym_intConst(((Expression)tomMatch1_97))) {
 long  tomMatch1_100=tom_get_slot_intConst_value(tomMatch1_97);
if ( true ) {
if (tom_equal_term_long(1L, tomMatch1_100)) {
return 
tom_get_slot_binMul_rexp(((Expression)tom__arg)); 
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
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_binMul(((Expression)((Expression)tom__arg)))) {
Expression tomMatch1_107=tom_get_slot_binMul_rexp(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch1_107)) {
if (tom_is_fun_sym_depExpr(((Expression)tomMatch1_107))) {
Expression tomMatch1_111=tom_get_slot_depExpr_expr(tomMatch1_107);
if (tom_is_sort_Expression(tomMatch1_111)) {
if (tom_is_fun_sym_intConst(((Expression)tomMatch1_111))) {
 long  tomMatch1_114=tom_get_slot_intConst_value(tomMatch1_111);
if ( true ) {
if (tom_equal_term_long(1L, tomMatch1_114)) {
return 
tom_get_slot_binMul_lexp(((Expression)tom__arg)); 
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
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_binMul(((Expression)((Expression)tom__arg)))) {
Expression tomMatch1_120=tom_get_slot_binMul_lexp(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch1_120)) {
if (tom_is_fun_sym_depExpr(((Expression)tomMatch1_120))) {
Expression tomMatch1_125=tom_get_slot_depExpr_expr(tomMatch1_120);
if (tom_is_sort_Expression(tomMatch1_125)) {
if (tom_is_fun_sym_intConst(((Expression)tomMatch1_125))) {
 long  tomMatch1_128=tom_get_slot_intConst_value(tomMatch1_125);
if ( true ) {
if (tom_equal_term_long(0L, tomMatch1_128)) {
return 
tom_make_depExpr(tom_get_slot_depExpr_dep(tomMatch1_120),tom_make_intConst(0L)); 
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
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_binMul(((Expression)((Expression)tom__arg)))) {
Expression tomMatch1_135=tom_get_slot_binMul_rexp(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch1_135)) {
if (tom_is_fun_sym_depExpr(((Expression)tomMatch1_135))) {
Expression tomMatch1_139=tom_get_slot_depExpr_expr(tomMatch1_135);
if (tom_is_sort_Expression(tomMatch1_139)) {
if (tom_is_fun_sym_intConst(((Expression)tomMatch1_139))) {
 long  tomMatch1_142=tom_get_slot_intConst_value(tomMatch1_139);
if ( true ) {
if (tom_equal_term_long(0L, tomMatch1_142)) {
return 
tom_make_depExpr(tom_get_slot_depExpr_dep(tomMatch1_135),tom_make_intConst(0L)); 
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
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_restrictExpr(((Expression)((Expression)tom__arg)))) {
Expression tom_restrict=((Expression)tom__arg);

Domain context = 
tom_restrict.getContextDomain().copy();
if (
tom_restrict.eContainer() instanceof StandardEquation) {
context.simplifyInContext(((StandardEquation)
tom_restrict.eContainer()).getVariable().getDomain());
} else if (
tom_restrict.eContainer() instanceof ReduceExpression) {
ReduceExpression re = (ReduceExpression)
tom_restrict.eContainer();
context.simplifyInContext(re.getContextDomain().preimage(re.getProjection()));
} else if (
tom_restrict.eContainer() instanceof DependenceExpression) {
DependenceExpression de = (DependenceExpression)
tom_restrict.eContainer();
context.simplifyInContext(de.getContextDomain().image(de.getDep()));
} else if (
tom_restrict.eContainer() instanceof Expression) {
context.simplifyInContext(((Expression)
tom_restrict.eContainer()).getContextDomain());
}
if (
context.isUniverse()) {
modified = true;
return 
tom_get_slot_restrictExpr_expr(((Expression)tom__arg));
} else {
return 
tom_restrict;
}

}
}
}
}
}
return _visit_Expression(tom__arg,introspector);
}
}
private static  tom.library.sl.Strategy  tom_make_SimplifyExpr() { 
return new SimplifyExpr();
}



private static Expression addIdentityTest(OP op, Expression sexp, Expression expr) {
if (op.getValue() == OP.ADD_VALUE) {
return sexp;
} else {
return expr;
}
}

private static Expression multIdentityTest(OP op, Expression sexp, Expression expr) {
if (op.getValue() == OP.MUL_VALUE) {
return sexp;
} else {
return expr;
}
}

private static boolean checkScalarReduction(ReduceExpression reduce) {
ParameterDomain params;

if (reduce.getContainerEquation() instanceof StandardEquation)
params = ((StandardEquation)reduce.getContainerEquation()).getContainerSystem().getParameters();
else
params = ((UseEquation)reduce.getContainerEquation()).getContainerSystem().getParameters();

//create the problem domain where domain of reduction expression is equated with projection function to another copy of the domain now as parameters
Domain prob = DomainOperations.extendParameterDomain(reduce.getExpr().getContextDomain(), reduce.getExpr().getContextDomain());
DomainOperations.addConstraintsRelatingExtendedParameterIndicesAndIndices(params, prob, 
new DomainOperations.Constraint(reduce.getProjection(), reduce.getProjection(), ComparisonOperator.EQ));
//If lex min and max is the same, then there is a constant point
org.polymodel.Domain max = ((ISLSet)prob.getPMdomain()).lexMax();
org.polymodel.Domain min = ((ISLSet)prob.getPMdomain()).lexMin();
return max.equivalence(min);
}

private static Expression simplifyScalarReduction(ReduceExpression reduce) {
ParameterDomain params;

if (reduce.getContainerEquation() instanceof StandardEquation)
params = ((StandardEquation)reduce.getContainerEquation()).getContainerSystem().getParameters();
else
params = ((UseEquation)reduce.getContainerEquation()).getContainerSystem().getParameters();
//If the domain is only a constant point, the returned quast should actually be a function
Map<Domain,AffineFunction> quast = DomainOperations.findDependencies(params, reduce.getContextDomain(), reduce.getExpr().getContextDomain(), 
new DomainOperations.Constraint(PolyhedralIRUtility.createIdentityFunction(reduce.getContextDomain()), reduce.getProjection(), ComparisonOperator.EQ), null);


if (quast.size() == 1) {
AffineFunction dep = quast.values().iterator().next();
if (dep != null) {
return PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(dep, reduce.getExpr());
}
}
throw new RuntimeException("Unexpected case : possible bug in scalar reduction detection");
}

private static Expression simplifyIfExpr(IfExpression ifExpr, BinaryExpression binExpr) {

IntExpression lexpr = getIntExpression(binExpr.getLexp());
IntExpression rexpr = getIntExpression(binExpr.getRexp());

if (lexpr == null || rexpr == null)
return ifExpr;

IntConstraint trueCond = IntExpressionBuilder.constraint(lexpr, rexpr, ComparisonOperator.EQ);
org.polymodel.Domain trueDom = EcoreUtil.copy(ifExpr.getContextDomain().getPMdomain());
trueDom.addConstraint(trueCond);

if (trueDom.isEmpty()) {
return ifExpr.getElse();
}

IntConstraint falseCond1 = IntExpressionBuilder.constraint(lexpr, rexpr, ComparisonOperator.LT);
IntConstraint falseCond2 = IntExpressionBuilder.constraint(lexpr, rexpr, ComparisonOperator.GT);
org.polymodel.Domain falseDom1 = EcoreUtil.copy(ifExpr.getContextDomain().getPMdomain());
org.polymodel.Domain falseDom2 = EcoreUtil.copy(ifExpr.getContextDomain().getPMdomain());
falseDom1.addConstraint(falseCond1);
falseDom2.addConstraint(falseCond2);

if (falseDom1.isEmpty() && falseDom2.isEmpty()) {
return ifExpr.getThen();
}

return ifExpr;
}

private static IntExpression getIntExpression(Expression expr) {
if (expr instanceof DependenceExpression) {
expr = ((DependenceExpression)expr).getExpr();

if (expr instanceof IntegerExpression)
return IntExpressionBuilder.constant((int)((IntegerExpression) expr).getValue());
}

if (expr instanceof IndexExpression) {
return ((IndexExpression) expr).getFunction().getExpressions().get(0).copy();
}

return null;
}


}
