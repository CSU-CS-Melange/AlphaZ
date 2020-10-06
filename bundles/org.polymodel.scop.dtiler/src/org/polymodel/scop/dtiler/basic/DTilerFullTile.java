package org.polymodel.scop.dtiler.basic;

import java.util.List;
import java.util.LinkedList;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.polynomials.PolynomialVariable;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopFactory;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopGuard;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopUserFactory;
import org.polymodel.scop.annotation.AnnotationFactory;
import org.polymodel.scop.annotation.DescriptionAnnotation;
import org.polymodel.scop.dtiler.DTilingOptions;
import org.polymodel.scop.dtiler.OptimizationOptions;
import org.polymodel.scop.util.ScopPrinter;

import tom.library.sl.VisitFailure;

@SuppressWarnings("all")
public class DTilerFullTile {



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
private static boolean tom_equal_term_org_polymodel_algebra_Value(Object l1, Object l2) {
return l1==l2;
}
private static boolean tom_is_sort_org_polymodel_algebra_Value(Object t) {
return true;
}
private static boolean tom_equal_term_org_polymodel_algebra_ComparisonOperator(Object l1, Object l2) {
return l1==l2;
}
private static boolean tom_is_sort_org_polymodel_algebra_ComparisonOperator(Object t) {
return t instanceof org.polymodel.algebra.ComparisonOperator;
}
private static boolean tom_equal_term_org_polymodel_algebra_FuzzyBoolean(Object l1, Object l2) {
return l1==l2;
}
private static boolean tom_is_sort_org_polymodel_algebra_FuzzyBoolean(Object t) {
return t instanceof org.polymodel.algebra.FuzzyBoolean;
}
private static boolean tom_equal_term_org_polymodel_algebra_CompositeOperator(Object l1, Object l2) {
return l1==l2;
}
private static boolean tom_is_sort_org_polymodel_algebra_CompositeOperator(Object t) {
return t instanceof org.polymodel.algebra.CompositeOperator;
}
private static boolean tom_equal_term_org_polymodel_algebra_quasiAffine_QuasiAffineOperator(Object l1, Object l2) {
return l1==l2;
}
private static boolean tom_is_sort_org_polymodel_algebra_quasiAffine_QuasiAffineOperator(Object t) {
return t instanceof org.polymodel.algebra.quasiAffine.QuasiAffineOperator;
}
private static boolean tom_equal_term_org_polymodel_algebra_reductions_ReductionOperator(Object l1, Object l2) {
return l1==l2;
}
private static boolean tom_is_sort_org_polymodel_algebra_reductions_ReductionOperator(Object t) {
return t instanceof org.polymodel.algebra.reductions.ReductionOperator;
}
private static boolean tom_equal_term_ICS(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_ICS(Object t) {
return t instanceof org.polymodel.algebra.IntConstraintSystem;
}
private static boolean tom_equal_term_ICSL(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_ICSL(Object t) {
return  t instanceof EList<?> &&
    	(((EList<org.polymodel.algebra.IntConstraintSystem>)t).size() == 0 
    	|| (((EList<org.polymodel.algebra.IntConstraintSystem>)t).size()>0 && ((EList<org.polymodel.algebra.IntConstraintSystem>)t).get(0) instanceof org.polymodel.algebra.IntConstraintSystem));
}
private static boolean tom_equal_term_E(Object l1, Object l2) {
return (l1!=null && l2 instanceof IntExpression && ((IntExpression)l1).isEquivalent((IntExpression)l2) == FuzzyBoolean.YES) || l1==l2;
}
private static boolean tom_is_sort_E(Object t) {
return t instanceof IntExpression;
}
private static boolean tom_equal_term_EL(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_EL(Object t) {
return  t instanceof EList<?> &&
    	(((EList<org.polymodel.algebra.IntExpression>)t).size() == 0 
    	|| (((EList<org.polymodel.algebra.IntExpression>)t).size()>0 && ((EList<org.polymodel.algebra.IntExpression>)t).get(0) instanceof org.polymodel.algebra.IntExpression));
}
private static boolean tom_equal_term_V(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_V(Object t) {
return t instanceof org.polymodel.algebra.Variable;
}
private static boolean tom_equal_term_vars(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_vars(Object t) {
return  t instanceof EList<?> &&
    	(((EList<org.polymodel.algebra.Variable>)t).size() == 0 
    	|| (((EList<org.polymodel.algebra.Variable>)t).size()>0 && ((EList<org.polymodel.algebra.Variable>)t).get(0) instanceof org.polymodel.algebra.Variable));
}
private static boolean tom_equal_term_T(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_T(Object t) {
return t instanceof org.polymodel.algebra.IntTerm;
}
private static boolean tom_equal_term_terms(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_terms(Object t) {
return  t instanceof EList<?> &&
    	(((EList<org.polymodel.algebra.IntTerm>)t).size() == 0 
    	|| (((EList<org.polymodel.algebra.IntTerm>)t).size()>0 && ((EList<org.polymodel.algebra.IntTerm>)t).get(0) instanceof org.polymodel.algebra.IntTerm));
}
private static boolean tom_equal_term_C(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_C(Object t) {
return t instanceof org.polymodel.algebra.IntConstraint;
}
private static boolean tom_equal_term_CL(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_CL(Object t) {
return  t instanceof EList<?> &&
    	(((EList<org.polymodel.algebra.IntConstraint>)t).size() == 0 
    	|| (((EList<org.polymodel.algebra.IntConstraint>)t).size()>0 && ((EList<org.polymodel.algebra.IntConstraint>)t).get(0) instanceof org.polymodel.algebra.IntConstraint));
}
private static boolean tom_equal_term_pterm(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_pterm(Object t) {
return t instanceof org.polymodel.algebra.polynomials.PolynomialTerm;
}
private static boolean tom_equal_term_pterms(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_pterms(Object t) {
return  t instanceof EList<?> &&
    	(((EList<org.polymodel.algebra.polynomials.PolynomialTerm>)t).size() == 0 
    	|| (((EList<org.polymodel.algebra.polynomials.PolynomialTerm>)t).size()>0 && ((EList<org.polymodel.algebra.polynomials.PolynomialTerm>)t).get(0) instanceof org.polymodel.algebra.polynomials.PolynomialTerm));
}
private static boolean tom_equal_term_pvar(Object l1, Object l2) {
return (l1!=null && l2 instanceof PolynomialVariable && ((PolynomialVariable)l1).isEquivalent((PolynomialVariable)l2)) || l1==l2;
}
private static boolean tom_is_sort_pvar(Object t) {
return t instanceof PolynomialVariable;
}
private static boolean tom_equal_term_pvars(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_pvars(Object t) {
return  t instanceof EList<?> &&
    	(((EList<org.polymodel.algebra.polynomials.PolynomialVariable>)t).size() == 0 
    	|| (((EList<org.polymodel.algebra.polynomials.PolynomialVariable>)t).size()>0 && ((EList<org.polymodel.algebra.polynomials.PolynomialVariable>)t).get(0) instanceof org.polymodel.algebra.polynomials.PolynomialVariable));
}
private static boolean tom_equal_term_JNIISLUnionMap(Object l1, Object l2) {
return l1.equals(l2);
}
private static boolean tom_is_sort_JNIISLUnionMap(Object t) {
return t instanceof fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionMap;
}
private static boolean tom_equal_term_nodes(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_nodes(Object t) {
return  t instanceof EList<?> &&
    	(((EList<AbstractScopNode>)t).size() == 0 
    	|| (((EList<AbstractScopNode>)t).size()>0 && ((EList<AbstractScopNode>)t).get(0) instanceof AbstractScopNode));
}
private static boolean tom_equal_term_node(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_node(Object t) {
return t instanceof AbstractScopNode;
}
private static boolean tom_equal_term_ScopRoot(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_ScopRoot(Object t) {
return t instanceof ScopRoot;
}
private static boolean tom_equal_term_ICSList(Object l1, Object l2) {
return (l1!=null && l1.equals(l2)) || l1==l2;
}
private static boolean tom_is_sort_ICSList(Object t) {
return  t instanceof EList<?> &&
    	(((EList<IntConstraintSystem>)t).size() == 0 
    	|| (((EList<IntConstraintSystem>)t).size()>0 && ((EList<IntConstraintSystem>)t).get(0) instanceof IntConstraintSystem));
}
private static boolean tom_is_fun_sym_loop(AbstractScopNode t) {
return t instanceof ScopFor;
}
private static org.polymodel.algebra.Variable tom_get_slot_loop_iterator(AbstractScopNode t) {
return ((ScopFor)t).getIterator();
}
private static IntExpression tom_get_slot_loop_LB(AbstractScopNode t) {
return ((ScopFor)t).getLB();
}
private static IntExpression tom_get_slot_loop_UB(AbstractScopNode t) {
return ((ScopFor)t).getUB();
}
private static IntExpression tom_get_slot_loop_stride(AbstractScopNode t) {
return ((ScopFor)t).getStride();
}
private static AbstractScopNode tom_get_slot_loop_body(AbstractScopNode t) {
return ((ScopFor)t).getBody();
}
private static boolean tom_is_fun_sym_guard(AbstractScopNode t) {
return t instanceof ScopGuard;
}
private static AbstractScopNode tom_make_guard( EList<IntConstraintSystem>  _constraintSystems, AbstractScopNode _thenBody, AbstractScopNode _elseBody) { 
return org.polymodel.scop.internal.ScopTomFactory.createGuard(_constraintSystems, _thenBody, _elseBody);
}
private static  EList<IntConstraintSystem>  tom_get_slot_guard_constraintSystems(AbstractScopNode t) {
return enforce(((ScopGuard)t).getConstraintSystems());
}
private static AbstractScopNode tom_get_slot_guard_thenBody(AbstractScopNode t) {
return ((ScopGuard)t).getThenBody();
}
private static AbstractScopNode tom_get_slot_guard_elseBody(AbstractScopNode t) {
return ((ScopGuard)t).getElseBody();
}
private static boolean tom_equal_term_DTilingOptions(Object l1, Object l2) {
return l1.equals(l2);
}
private static boolean tom_is_sort_DTilingOptions(Object t) {
return t instanceof DTilingOptions;
}


protected final DTilingOptions _options;
protected final OptimizationOptions _optOptions;

public DTilerFullTile(DTilingOptions options, OptimizationOptions optOptions) {
_options = options;
_optOptions = optOptions;
}

public DTilerFullTile(DTilingOptions options){
_options = options;
_optOptions = null;
}


private List<String> indexes;

/**
* Build the conditions of full tile for a loop nest and build box loops.
* Each loop is transformed into a box loop. Transformed box loop nest is
* surrounded by the full tile conditions guard. Input {@link ScopFor} is
* not modified.
* 
* @param stmt
* @return
*/
public static ScopGuard build(ScopFor stmt, DTilingOptions options) {
DTilerFullTile builder = new DTilerFullTile(options);
return (ScopGuard) builder.generate(stmt);
}

public static ScopGuard build(ScopFor stmt, DTilingOptions options, OptimizationOptions _optOptions) {
DTilerFullTile builder = new DTilerFullTile(options, _optOptions);
return (ScopGuard) builder.generate(stmt);
}

protected AbstractScopNode generate(ScopFor o) {
try {
ScopGuard fullTileGuard =  (ScopGuard)
tom_make_BottomUp(tom_make_FullTileTest(_options)).visitLight(EcoreUtil.copy(o),tom.mapping.introspectors.scop.ScopIntrospector.INSTANCE);
fullTileGuard = (ScopGuard)
tom_make_BottomUp(tom_make_CollapseGuards()).visitLight(fullTileGuard,tom.mapping.introspectors.scop.ScopIntrospector.INSTANCE);

DescriptionAnnotation annotation = AnnotationFactory.eINSTANCE.createDescriptionAnnotation();
annotation.setDescription("full-tile guard");
fullTileGuard.getScopAnnotations().add(annotation);

if(_optOptions != null && _optOptions.optimizedPointLoop != null){
List<AbstractScopNode> _stmts = new LinkedList<AbstractScopNode>();
_stmts.addAll(_optOptions.optimizedPointLoop.getStatements());
ScopBlock sb = ScopUserFactory.scopBlock(_stmts);
fullTileGuard.setThenBody(sb);
}else{
ScopFor boxLoops = (ScopFor)
tom_make_BottomUp(tom_make_BoxLoop(_options)).visitLight(EcoreUtil.copy(o),tom.mapping.introspectors.scop.ScopIntrospector.INSTANCE);
//add box loop inside full tile guard
fullTileGuard.setThenBody(boxLoops);
}

fullTileGuard.setElseBody((new DTilerPointLoops(_options)).generate(o));
return fullTileGuard.simplify();
} catch (VisitFailure vf) {
vf.printStackTrace();
throw new RuntimeException("VisitFailure at DTilerTileLoops : " + vf.getMessage());
}
}


public static class FullTileTest extends tom.library.sl.AbstractStrategyBasic {
private DTilingOptions options;
public FullTileTest(DTilingOptions options) {
super(tom_make_Identity());
this.options=options;
}
public DTilingOptions getoptions() {
return options;
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
if (tom_is_sort_node(v)) {
return ((T)visit_node(((AbstractScopNode)v),introspector));
}
if (!(( null  == environment))) {
return ((T)any.visit(environment,introspector));
} else {
return any.visitLight(v,introspector);
}
}
@SuppressWarnings("unchecked")
public AbstractScopNode _visit_node(AbstractScopNode arg, tom.library.sl.Introspector introspector)
 throws tom.library.sl.VisitFailure {
if (!(( null  == environment))) {
return ((AbstractScopNode)any.visit(environment,introspector));
} else {
return any.visitLight(arg,introspector);
}
}
@SuppressWarnings("unchecked")
public AbstractScopNode visit_node(AbstractScopNode tom__arg, tom.library.sl.Introspector introspector)
 throws tom.library.sl.VisitFailure {
{
{
if (tom_is_sort_node(tom__arg)) {
if (tom_is_sort_node(((AbstractScopNode)tom__arg))) {
if (tom_is_fun_sym_loop(((AbstractScopNode)((AbstractScopNode)tom__arg)))) {
org.polymodel.algebra.Variable tom_ite=tom_get_slot_loop_iterator(((AbstractScopNode)tom__arg));
AbstractScopNode tom_o=((AbstractScopNode)tom__arg);

int depth = 
tom_o.getLoopDepth();
List<ScopFor> loops = 
tom_o.getSurroundingScopFors();
//replace all iterators with loop index
Variable tileIndex = options.getTileIndex(depth);
//shift up/down by the current dim
IntExpression lbc = Shift.up(
tom_get_slot_loop_LB(((AbstractScopNode)tom__arg)), 
tom_ite, options);
IntExpression ubc = Shift.down(
tom_get_slot_loop_UB(((AbstractScopNode)tom__arg)), 
tom_ite, options);
lbc = 
lbc.substitute(
tom_ite, tileIndex);
ubc = 
ubc.substitute(
tom_ite, tileIndex);
for (int i = 1; i < depth; i++) {
Variable lite = loops.get(i-1).getIterator();
lbc = lbc.substitute(lite, options.getTileIndex(i));
ubc = ubc.substitute(lite, options.getTileIndex(i));
}

AffineExpression afTI = IntExpressionBuilder.affine(IntExpressionBuilder.term(tileIndex));

IntConstraintSystem ics = IntExpressionBuilder.constraintSystem(
IntExpressionBuilder.constraint(lbc, EcoreUtil.copy(afTI), ComparisonOperator.LE),
IntExpressionBuilder.constraint(afTI, ubc, ComparisonOperator.LE)
);
EList<IntConstraintSystem> icsList = new BasicEList<IntConstraintSystem>(1);
icsList.add(ics);

return 
tom_make_guard(icsList,tom_get_slot_loop_body(((AbstractScopNode)tom__arg)),null);

}
}
}
}
}
return _visit_node(tom__arg,introspector);
}
}
private static  tom.library.sl.Strategy  tom_make_FullTileTest(DTilingOptions t0) { 
return new FullTileTest(t0);
}
public static class CollapseGuards extends tom.library.sl.AbstractStrategyBasic {
public CollapseGuards() {
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
if (tom_is_sort_node(v)) {
return ((T)visit_node(((AbstractScopNode)v),introspector));
}
if (!(( null  == environment))) {
return ((T)any.visit(environment,introspector));
} else {
return any.visitLight(v,introspector);
}
}
@SuppressWarnings("unchecked")
public AbstractScopNode _visit_node(AbstractScopNode arg, tom.library.sl.Introspector introspector)
 throws tom.library.sl.VisitFailure {
if (!(( null  == environment))) {
return ((AbstractScopNode)any.visit(environment,introspector));
} else {
return any.visitLight(arg,introspector);
}
}
@SuppressWarnings("unchecked")
public AbstractScopNode visit_node(AbstractScopNode tom__arg, tom.library.sl.Introspector introspector)
 throws tom.library.sl.VisitFailure {
{
{
if (tom_is_sort_node(tom__arg)) {
if (tom_is_sort_node(((AbstractScopNode)tom__arg))) {
if (tom_is_fun_sym_guard(((AbstractScopNode)((AbstractScopNode)tom__arg)))) {
AbstractScopNode tomMatch2_2=tom_get_slot_guard_thenBody(((AbstractScopNode)tom__arg));
 EList<IntConstraintSystem>  tom_cond1=tom_get_slot_guard_constraintSystems(((AbstractScopNode)tom__arg));
if (tom_is_sort_node(tomMatch2_2)) {
if (tom_is_fun_sym_guard(((AbstractScopNode)tomMatch2_2))) {
 EList<IntConstraintSystem>  tom_cond2=tom_get_slot_guard_constraintSystems(tomMatch2_2);

if (
tom_cond1.size() == 1 && 
tom_cond2.size() == 1) {

tom_cond1.get(0).getConstraints().addAll(
tom_cond2.get(0).getConstraints());
return 
tom_make_guard(tom_cond1,tom_get_slot_guard_thenBody(tomMatch2_2),tom_get_slot_guard_elseBody(tomMatch2_2));
}
throw new RuntimeException("Expecting single constraint system in guards.");

}
}
}
}
}
}
}
return _visit_node(tom__arg,introspector);
}
}
private static  tom.library.sl.Strategy  tom_make_CollapseGuards() { 
return new CollapseGuards();
}
public static class BoxLoop extends tom.library.sl.AbstractStrategyBasic {
private DTilingOptions options;
public BoxLoop(DTilingOptions options) {
super(tom_make_Identity());
this.options=options;
}
public DTilingOptions getoptions() {
return options;
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
if (tom_is_sort_node(v)) {
return ((T)visit_node(((AbstractScopNode)v),introspector));
}
if (!(( null  == environment))) {
return ((T)any.visit(environment,introspector));
} else {
return any.visitLight(v,introspector);
}
}
@SuppressWarnings("unchecked")
public AbstractScopNode _visit_node(AbstractScopNode arg, tom.library.sl.Introspector introspector)
 throws tom.library.sl.VisitFailure {
if (!(( null  == environment))) {
return ((AbstractScopNode)any.visit(environment,introspector));
} else {
return any.visitLight(arg,introspector);
}
}
@SuppressWarnings("unchecked")
public AbstractScopNode visit_node(AbstractScopNode tom__arg, tom.library.sl.Introspector introspector)
 throws tom.library.sl.VisitFailure {
{
{
if (tom_is_sort_node(tom__arg)) {
if (tom_is_sort_node(((AbstractScopNode)tom__arg))) {
if (tom_is_fun_sym_loop(((AbstractScopNode)((AbstractScopNode)tom__arg)))) {
AbstractScopNode tom_o=((AbstractScopNode)tom__arg);

int depth = 
tom_o.getLoopDepth();
AffineTerm tileSize = options.getTileSize(depth);
AffineTerm tileIndex = IntExpressionBuilder.term(options.getTileIndex(depth));
IntExpression boxLB = IntExpressionBuilder.affine(EcoreUtil.copy(tileIndex));
IntExpression boxUB = IntExpressionBuilder.affine(tileIndex, tileSize, IntExpressionBuilder.term(-1));
((ScopFor)
tom_o).setLB(boxLB);
((ScopFor)
tom_o).setUB(boxUB);
return 
tom_o;

}
}
}
}
}
return _visit_node(tom__arg,introspector);
}
}
private static  tom.library.sl.Strategy  tom_make_BoxLoop(DTilingOptions t0) { 
return new BoxLoop(t0);
}

}
