package org.polymodel.polyhedralIR.transformation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
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
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.IntegerExpression;
import org.polymodel.polyhedralIR.expression.RealExpression;
import org.polymodel.polyhedralIR.expression.UnaryExpression;
import org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;

import tom.library.sl.VisitFailure;

public class DistributeMultiplications extends PolyhedralIRTomTransformation {

public static void apply(Program p){
DistributeMultiplications s = new DistributeMultiplications();
s.transform(p);
}

public static void apply(AffineSystem as){
DistributeMultiplications s = new DistributeMultiplications();
s.transform(as);
}

public static void apply(StandardEquation eq){
DistributeMultiplications s = new DistributeMultiplications();
s.transform(eq);
}

protected DistributeMultiplications(){} 

@Override
protected EObject apply(EObject o) throws VisitFailure {

o = 
tom_make_InnermostId(tom_make_NormalizeBinarySubtractions()).visitLight(o, tom.mapping.GenericIntrospector.INSTANCE);
o = 
tom_make_InnermostId(tom_make_PropagateUnaryMinus()).visitLight(o, tom.mapping.GenericIntrospector.INSTANCE);
o = 
tom_make_InnermostId(tom_make_DistributeMults()).visitLight(o, tom.mapping.GenericIntrospector.INSTANCE);
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
private static boolean tom_is_fun_sym_intConst(Expression t) {
return t instanceof IntegerExpression;
}
private static Expression tom_make_intConst( long  _value) { 
return org.polymodel.polyhedralIR.internal.PolyhedralIRTomFactory.createIntConst(_value);
}
private static  long  tom_get_slot_intConst_value(Expression t) {
return ((IntegerExpression)t).getValue();
}
private static boolean tom_is_fun_sym_realConst(Expression t) {
return t instanceof RealExpression;
}
private static Expression tom_make_realConst( double  _value) { 
return org.polymodel.polyhedralIR.internal.PolyhedralIRTomFactory.createRealConst(_value);
}
private static  double  tom_get_slot_realConst_value(Expression t) {
return ((RealExpression)t).getValue();
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
private static boolean tom_is_fun_sym_binAdd(Expression t) {
return t instanceof BinaryExpression && ((BinaryExpression)t).getOperator().equals(OP.ADD);
}
private static Expression tom_make_binAdd(Expression _lexp, Expression _rexp) { 
return org.polymodel.polyhedralIR.internal.PolyhedralIRTomFactory.createBinAdd(_lexp, _rexp);
}
private static Expression tom_get_slot_binAdd_lexp(Expression t) {
return ((BinaryExpression)t).getLexp();
}
private static Expression tom_get_slot_binAdd_rexp(Expression t) {
return ((BinaryExpression)t).getRexp();
}
private static boolean tom_is_fun_sym_binSub(Expression t) {
return t instanceof BinaryExpression && ((BinaryExpression)t).getOperator().equals(OP.SUB);
}
private static Expression tom_get_slot_binSub_lexp(Expression t) {
return ((BinaryExpression)t).getLexp();
}
private static Expression tom_get_slot_binSub_rexp(Expression t) {
return ((BinaryExpression)t).getRexp();
}
private static boolean tom_is_fun_sym_binMul(Expression t) {
return t instanceof BinaryExpression && ((BinaryExpression)t).getOperator().equals(OP.MUL);
}
private static Expression tom_make_binMul(Expression _lexp, Expression _rexp) { 
return org.polymodel.polyhedralIR.internal.PolyhedralIRTomFactory.createBinMul(_lexp, _rexp);
}
private static Expression tom_get_slot_binMul_lexp(Expression t) {
return ((BinaryExpression)t).getLexp();
}
private static Expression tom_get_slot_binMul_rexp(Expression t) {
return ((BinaryExpression)t).getRexp();
}
private static boolean tom_is_fun_sym_unaryMinus(Expression t) {
return t instanceof UnaryExpression && ((UnaryExpression)t).getOperator().equals(OP.SUB);
}
private static Expression tom_make_unaryMinus(Expression _expr) { 
return org.polymodel.polyhedralIR.internal.PolyhedralIRTomFactory.createUnaryMinus(_expr);
}
private static Expression tom_get_slot_unaryMinus_expr(Expression t) {
return ((UnaryExpression)t).getExpr();
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
public static class NormalizeBinarySubtractions extends tom.library.sl.AbstractStrategyBasic {
public NormalizeBinarySubtractions() {
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
if (tom_is_fun_sym_binSub(((Expression)((Expression)tom__arg)))) {

return 
tom_make_binAdd(tom_get_slot_binSub_lexp(((Expression)tom__arg)),tom_make_unaryMinus(tom_get_slot_binSub_rexp(((Expression)tom__arg))));

}
}
}
}
}
return _visit_Expression(tom__arg,introspector);
}
}
private static  tom.library.sl.Strategy  tom_make_NormalizeBinarySubtractions() { 
return new NormalizeBinarySubtractions();
}
public static class PropagateUnaryMinus extends tom.library.sl.AbstractStrategyBasic {
public PropagateUnaryMinus() {
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
if (tom_is_fun_sym_unaryMinus(((Expression)((Expression)tom__arg)))) {
Expression tomMatch2_1=tom_get_slot_unaryMinus_expr(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch2_1)) {
if (tom_is_fun_sym_unaryMinus(((Expression)tomMatch2_1))) {

return 
tom_get_slot_unaryMinus_expr(tomMatch2_1);

}
}
}
}
}
}
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_unaryMinus(((Expression)((Expression)tom__arg)))) {
Expression tomMatch2_8=tom_get_slot_unaryMinus_expr(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch2_8)) {
if (tom_is_fun_sym_binOp(((Expression)tomMatch2_8))) {

return 
tom_make_binOp(tom_get_slot_binOp_operator(tomMatch2_8),tom_make_unaryMinus(tom_get_slot_binOp_lexp(tomMatch2_8)),tom_make_unaryMinus(tom_get_slot_binOp_rexp(tomMatch2_8)));

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
Expression tomMatch2_17=tom_get_slot_binMul_lexp(((Expression)tom__arg));
Expression tomMatch2_18=tom_get_slot_binMul_rexp(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch2_17)) {
if (tom_is_fun_sym_unaryMinus(((Expression)tomMatch2_17))) {
if (tom_is_sort_Expression(tomMatch2_18)) {
if (tom_is_fun_sym_unaryMinus(((Expression)tomMatch2_18))) {

return 
tom_make_binMul(tom_get_slot_unaryMinus_expr(tomMatch2_17),tom_get_slot_unaryMinus_expr(tomMatch2_18));

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
if (tom_is_fun_sym_unaryMinus(((Expression)((Expression)tom__arg)))) {
Expression tomMatch2_28=tom_get_slot_unaryMinus_expr(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch2_28)) {
if (tom_is_fun_sym_depExpr(((Expression)tomMatch2_28))) {
Expression tomMatch2_32=tom_get_slot_depExpr_expr(tomMatch2_28);
if (tom_is_sort_Expression(tomMatch2_32)) {
if (tom_is_fun_sym_intConst(((Expression)tomMatch2_32))) {

return 
tom_make_depExpr(tom_get_slot_depExpr_dep(tomMatch2_28),tom_make_intConst(-tom_get_slot_intConst_value(tomMatch2_32)));

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
if (tom_is_fun_sym_unaryMinus(((Expression)((Expression)tom__arg)))) {
Expression tomMatch2_39=tom_get_slot_unaryMinus_expr(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch2_39)) {
if (tom_is_fun_sym_depExpr(((Expression)tomMatch2_39))) {
Expression tomMatch2_43=tom_get_slot_depExpr_expr(tomMatch2_39);
if (tom_is_sort_Expression(tomMatch2_43)) {
if (tom_is_fun_sym_realConst(((Expression)tomMatch2_43))) {

return 
tom_make_depExpr(tom_get_slot_depExpr_dep(tomMatch2_39),tom_make_realConst(-tom_get_slot_realConst_value(tomMatch2_43)));

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
private static  tom.library.sl.Strategy  tom_make_PropagateUnaryMinus() { 
return new PropagateUnaryMinus();
}
public static class DistributeMults extends tom.library.sl.AbstractStrategyBasic {
public DistributeMults() {
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
if (tom_is_fun_sym_binMul(((Expression)((Expression)tom__arg)))) {
Expression tomMatch3_2=tom_get_slot_binMul_rexp(((Expression)tom__arg));
Expression tom_distExpr=tom_get_slot_binMul_lexp(((Expression)tom__arg));
if (tom_is_sort_Expression(tomMatch3_2)) {
if (tom_is_fun_sym_binAdd(((Expression)tomMatch3_2))) {

//System.err.println(PolyhedralIRToAlphabets.toSimplifiedString(`expr));
Expression distExprCopy = 
tom_distExpr.copy();
return 
tom_make_binAdd(tom_make_binMul(tom_distExpr,tom_get_slot_binAdd_lexp(tomMatch3_2)),tom_make_binMul(distExprCopy,tom_get_slot_binAdd_rexp(tomMatch3_2))); 
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
private static  tom.library.sl.Strategy  tom_make_DistributeMults() { 
return new DistributeMults();
}


/*		S3[t,i,j] = case
{ | i==0 && j-1>=0 && t-1>=0 } : S3[t-1,i,j] - 0.699999988079071 * (S2[t,i,j+1] - S2 + S1[t,i+1,j] - S0[t,j]) ;
{ | t-1>=0 && j-1>=0 && i-1>=0 } : S3[t-1,i,j] - 0.699999988079071 * (S2[t,i,j+1] - S2 + S1[t,i+1,j] - S1) ;
{ | j==0 && i==0 && t-1>=0 } : S3[t-1,i,j] - 0.699999988079071 * (S2[t,i,j+1] - ex[i,j] + S1[t,i+1,j] - S0[t,j]) ;
{ | j==0 && i-1>=0 && t-1>=0 } : S3[t-1,i,j] - 0.699999988079071 * (S2[t,i,j+1] - ex[i,j] + S1[t,i+1,j] - S1) ;
{ | i==0 && t==0 && j-1>=0 } : hz[i,j] - 0.699999988079071 * (S2[t,i,j+1] - S2 + S1[t,i+1,j] - S0[t,j]) ;
{ | t==0 && j-1>=0 && i-1>=0 } : hz[i,j] - 0.699999988079071 * (S2[t,i,j+1] - S2 + S1[t,i+1,j] - S1) ;
{ | j==0 && i==0 && t==0 } : hz[i,j] - 0.699999988079071 * (S2[t,i,j+1] - ex[i,j] + S1[t,i+1,j] - S0[t,j]) ;
{ | j==0 && t==0 && i-1>=0 } : hz[i,j] - 0.699999988079071 * (S2[t,i,j+1] - ex[i,j] + S1[t,i+1,j] - S1) ;
esac;
*/
}
