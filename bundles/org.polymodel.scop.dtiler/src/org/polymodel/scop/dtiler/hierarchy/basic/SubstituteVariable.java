package org.polymodel.scop.dtiler.hierarchy.basic;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.polynomials.PolynomialVariable;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.dtiler.DTilingOptions;

import tom.library.sl.VisitFailure;

@SuppressWarnings("all")
public class SubstituteVariable  {


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
private static boolean tom_is_fun_sym_EL( EList<org.polymodel.algebra.IntExpression>  t) {
return  t instanceof EList<?> &&
 		(((EList<org.polymodel.algebra.IntExpression>)t).size() == 0 
 		|| (((EList<org.polymodel.algebra.IntExpression>)t).size()>0 && ((EList<org.polymodel.algebra.IntExpression>)t).get(0) instanceof org.polymodel.algebra.IntExpression));
}
private static  EList<org.polymodel.algebra.IntExpression>  tom_empty_array_EL(int n) { 
return  new BasicEList<org.polymodel.algebra.IntExpression>(n) ;
}
private static  EList<org.polymodel.algebra.IntExpression>  tom_cons_array_EL(IntExpression e,  EList<org.polymodel.algebra.IntExpression>  l) { 
return  append(e,l) ;
}
private static IntExpression tom_get_element_EL_EL( EList<org.polymodel.algebra.IntExpression>  l, int n) {
return  l.get(n) ;
}
private static int tom_get_size_EL_EL( EList<org.polymodel.algebra.IntExpression>  l) {
return  l.size() ;
}

  private static   EList<org.polymodel.algebra.IntExpression>  tom_get_slice_EL( EList<org.polymodel.algebra.IntExpression>  subject, int begin, int end) {
     EList<org.polymodel.algebra.IntExpression>  result =  new BasicEList<org.polymodel.algebra.IntExpression>(end-begin) ;
    while(begin!=end) {
      result =  append( subject.get(begin) ,result) ;
      begin++;
    }
    return result;
  }

  private static   EList<org.polymodel.algebra.IntExpression>  tom_append_array_EL( EList<org.polymodel.algebra.IntExpression>  l2,  EList<org.polymodel.algebra.IntExpression>  l1) {
    int size1 =  l1.size() ;
    int size2 =  l2.size() ;
    int index;
     EList<org.polymodel.algebra.IntExpression>  result =  new BasicEList<org.polymodel.algebra.IntExpression>(size1+size2) ;
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
  }private static boolean tom_equal_term_V(Object l1, Object l2) {
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
private static boolean tom_is_fun_sym_terms( EList<org.polymodel.algebra.IntTerm>  t) {
return  t instanceof EList<?> &&
 		(((EList<org.polymodel.algebra.IntTerm>)t).size() == 0 
 		|| (((EList<org.polymodel.algebra.IntTerm>)t).size()>0 && ((EList<org.polymodel.algebra.IntTerm>)t).get(0) instanceof org.polymodel.algebra.IntTerm));
}
private static  EList<org.polymodel.algebra.IntTerm>  tom_empty_array_terms(int n) { 
return  new BasicEList<org.polymodel.algebra.IntTerm>(n) ;
}
private static  EList<org.polymodel.algebra.IntTerm>  tom_cons_array_terms(org.polymodel.algebra.IntTerm e,  EList<org.polymodel.algebra.IntTerm>  l) { 
return  append(e,l) ;
}
private static org.polymodel.algebra.IntTerm tom_get_element_terms_terms( EList<org.polymodel.algebra.IntTerm>  l, int n) {
return  l.get(n) ;
}
private static int tom_get_size_terms_terms( EList<org.polymodel.algebra.IntTerm>  l) {
return  l.size() ;
}

  private static   EList<org.polymodel.algebra.IntTerm>  tom_get_slice_terms( EList<org.polymodel.algebra.IntTerm>  subject, int begin, int end) {
     EList<org.polymodel.algebra.IntTerm>  result =  new BasicEList<org.polymodel.algebra.IntTerm>(end-begin) ;
    while(begin!=end) {
      result =  append( subject.get(begin) ,result) ;
      begin++;
    }
    return result;
  }

  private static   EList<org.polymodel.algebra.IntTerm>  tom_append_array_terms( EList<org.polymodel.algebra.IntTerm>  l2,  EList<org.polymodel.algebra.IntTerm>  l1) {
    int size1 =  l1.size() ;
    int size2 =  l2.size() ;
    int index;
     EList<org.polymodel.algebra.IntTerm>  result =  new BasicEList<org.polymodel.algebra.IntTerm>(size1+size2) ;
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
  }private static boolean tom_equal_term_C(Object l1, Object l2) {
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
private static boolean tom_is_fun_sym_affine(IntExpression t) {
return t instanceof org.polymodel.algebra.affine.AffineExpression;
}
private static IntExpression tom_make_affine( EList<org.polymodel.algebra.IntTerm>  _terms) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createAffine(_terms);
}
private static  EList<org.polymodel.algebra.IntTerm>  tom_get_slot_affine_terms(IntExpression t) {
return enforce(((org.polymodel.algebra.affine.AffineExpression)t).getTerms());
}
private static boolean tom_is_fun_sym_term(org.polymodel.algebra.IntTerm t) {
return t instanceof org.polymodel.algebra.affine.AffineTerm;
}
private static  long  tom_get_slot_term_coef(org.polymodel.algebra.IntTerm t) {
return ((org.polymodel.algebra.affine.AffineTerm)t).getCoef();
}
private static org.polymodel.algebra.Variable tom_get_slot_term_variable(org.polymodel.algebra.IntTerm t) {
return ((org.polymodel.algebra.affine.AffineTerm)t).getVariable();
}
private static org.polymodel.algebra.IntTerm tom_make_constant( long  _coef) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createConstant(_coef);
}
private static IntExpression tom_make_prod( EList<org.polymodel.algebra.IntExpression>  _expressions) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createProd(_expressions);
}
private static boolean tom_is_fun_sym_sum(IntExpression t) {
return t instanceof org.polymodel.algebra.reductions.ReductionExpression && ((org.polymodel.algebra.reductions.ReductionExpression)t).getOperator().equals(org.polymodel.algebra.reductions.ReductionOperator.SUM);
}
private static IntExpression tom_make_sum( EList<org.polymodel.algebra.IntExpression>  _expressions) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createSum(_expressions);
}
private static  EList<org.polymodel.algebra.IntExpression>  tom_get_slot_sum_expressions(IntExpression t) {
return enforce(((org.polymodel.algebra.reductions.ReductionExpression)t).getExpressions());
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
private static boolean tom_equal_term_DTilingOptions(Object l1, Object l2) {
return l1.equals(l2);
}
private static boolean tom_is_sort_DTilingOptions(Object t) {
return t instanceof DTilingOptions;
}



/**
* Shift up an expression. Shifted expression isn'modified and has to be
* contained into a {@link ScopFor} in order to find outer indexes.
* 
* @param e
* @param options
* @return
*/
public static IntExpression substitute(IntExpression af, Variable v, IntExpression newExpr){
SubstituteVariable t = new SubstituteVariable();
try{
IntExpression s  = t.subVarWithExpression(af, v, newExpr);
return s;
}catch(VisitFailure ex){
throw new RuntimeException(ex);
}
}

protected IntExpression subVarWithExpression(IntExpression af, Variable v, IntExpression newExpr) throws VisitFailure{
//System.out.println("handle expression " + af + " variable " + v.getName() + " with expression " + newExpr);
IntExpression res = 
tom_make_BottomUp(tom_make_subTrans(v,newExpr)).visitLight(af,tom.mapping.GenericIntrospector.INSTANCE);;

return res;
}
/**
Convert affine expression to summation of affine terms to make it easier to deal with.
The result of ShiftUp/Down is no longer an affine expression.
*/

public static class toSummation extends tom.library.sl.AbstractStrategyBasic {
public toSummation() {
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
if (tom_is_sort_E(v)) {
return ((T)visit_E(((IntExpression)v),introspector));
}
if (!(( null  == environment))) {
return ((T)any.visit(environment,introspector));
} else {
return any.visitLight(v,introspector);
}
}
@SuppressWarnings("unchecked")
public IntExpression _visit_E(IntExpression arg, tom.library.sl.Introspector introspector)
 throws tom.library.sl.VisitFailure {
if (!(( null  == environment))) {
return ((IntExpression)any.visit(environment,introspector));
} else {
return any.visitLight(arg,introspector);
}
}
@SuppressWarnings("unchecked")
public IntExpression visit_E(IntExpression tom__arg, tom.library.sl.Introspector introspector)
 throws tom.library.sl.VisitFailure {
{
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_sum(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1=tom_get_slot_sum_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1))) {
int tomMatch1_5=0;
int tomMatch1_end_8=tomMatch1_5;
do {
{
if (!(tomMatch1_end_8 >= tom_get_size_EL_EL(tomMatch1_1))) {
IntExpression tomMatch1_12=tom_get_element_EL_EL(tomMatch1_1,tomMatch1_end_8);
if (tom_is_sort_E(tomMatch1_12)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_12))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_11=tom_get_slot_affine_terms(tomMatch1_12);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_11))) {
if (0 >= tom_get_size_terms_terms(tomMatch1_11)) {
return 
tom_make_sum(tom_append_array_EL(tom_get_slice_EL(tomMatch1_1,tomMatch1_end_8 + 1,tom_get_size_EL_EL(tomMatch1_1)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_1,tomMatch1_5,tomMatch1_end_8),tom_empty_array_EL(2)))); 
}
}
}
}
}
tomMatch1_end_8=tomMatch1_end_8 + 1;
}
} while(!(tomMatch1_end_8 > tom_get_size_EL_EL(tomMatch1_1)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_sum(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_17=tom_get_slot_sum_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_17))) {
int tomMatch1_21=0;
int tomMatch1_end_24=tomMatch1_21;
do {
{
if (!(tomMatch1_end_24 >= tom_get_size_EL_EL(tomMatch1_17))) {
IntExpression tomMatch1_28=tom_get_element_EL_EL(tomMatch1_17,tomMatch1_end_24);
if (tom_is_sort_E(tomMatch1_28)) {
if (tom_is_fun_sym_sum(((IntExpression)tomMatch1_28))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_27=tom_get_slot_sum_expressions(tomMatch1_28);
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_27))) {
return 
tom_make_sum(tom_append_array_EL(tom_get_slice_EL(tomMatch1_17,tomMatch1_end_24 + 1,tom_get_size_EL_EL(tomMatch1_17)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_27,0,tom_get_size_EL_EL(tomMatch1_27)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_17,tomMatch1_21,tomMatch1_end_24),tom_empty_array_EL(3))))); 
}
}
}
}
tomMatch1_end_24=tomMatch1_end_24 + 1;
}
} while(!(tomMatch1_end_24 > tom_get_size_EL_EL(tomMatch1_17)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_affine(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_34=tom_get_slot_affine_terms(((IntExpression)tom__arg));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_34))) {
int tomMatch1_38=0;
if (!(tomMatch1_38 >= tom_get_size_terms_terms(tomMatch1_34))) {
int tomMatch1_39=tomMatch1_38 + 1;
if (!(tomMatch1_39 >= tom_get_size_terms_terms(tomMatch1_34))) {
return 
tom_make_sum(tom_cons_array_EL(tom_make_affine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_34,tomMatch1_39 + 1,tom_get_size_terms_terms(tomMatch1_34)),tom_cons_array_terms(tom_get_element_terms_terms(tomMatch1_34,tomMatch1_39),tom_empty_array_terms(2)))),tom_cons_array_EL(tom_make_affine(tom_cons_array_terms(tom_get_element_terms_terms(tomMatch1_34,tomMatch1_38),tom_empty_array_terms(1))),tom_empty_array_EL(2))));
}
}
}
}
}
}
}
}
return _visit_E(tom__arg,introspector);
}
}
public static class subTrans extends tom.library.sl.AbstractStrategyBasic {
private org.polymodel.algebra.Variable idx;
private IntExpression newExpr;
public subTrans(org.polymodel.algebra.Variable idx, IntExpression newExpr) {
super(tom_make_Identity());
this.idx=idx;
this.newExpr=newExpr;
}
public org.polymodel.algebra.Variable getidx() {
return idx;
}
public IntExpression getnewExpr() {
return newExpr;
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
if (tom_is_sort_E(v)) {
return ((T)visit_E(((IntExpression)v),introspector));
}
if (!(( null  == environment))) {
return ((T)any.visit(environment,introspector));
} else {
return any.visitLight(v,introspector);
}
}
@SuppressWarnings("unchecked")
public IntExpression _visit_E(IntExpression arg, tom.library.sl.Introspector introspector)
 throws tom.library.sl.VisitFailure {
if (!(( null  == environment))) {
return ((IntExpression)any.visit(environment,introspector));
} else {
return any.visitLight(arg,introspector);
}
}
@SuppressWarnings("unchecked")
public IntExpression visit_E(IntExpression tom__arg, tom.library.sl.Introspector introspector)
 throws tom.library.sl.VisitFailure {
{
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_affine(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch2_1=tom_get_slot_affine_terms(((IntExpression)tom__arg));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch2_1))) {
int tomMatch2_5=0;
if (!(tomMatch2_5 >= tom_get_size_terms_terms(tomMatch2_1))) {
org.polymodel.algebra.IntTerm tomMatch2_9=tom_get_element_terms_terms(tomMatch2_1,tomMatch2_5);
if (tom_is_sort_T(tomMatch2_9)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch2_9))) {
 long  tom_c=tom_get_slot_term_coef(tomMatch2_9);
org.polymodel.algebra.Variable tom_v=tom_get_slot_term_variable(tomMatch2_9);
if (tomMatch2_5 + 1 >= tom_get_size_terms_terms(tomMatch2_1)) {

//System.out.println("current variable " + `v);
//all expressions involving outer loop indices (not including the current loop)
if((
tom_v!= null) && (
tom_v.getName().contentEquals(idx.getName()))){
if(
tom_c> 1){
return  
tom_make_prod(tom_cons_array_EL(newExpr.copy(),tom_cons_array_EL(tom_make_affine(tom_cons_array_terms(tom_make_constant(tom_c),tom_empty_array_terms(1))),tom_empty_array_EL(2))));
}else{
return newExpr.copy();
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
return _visit_E(tom__arg,introspector);
}
}
private static  tom.library.sl.Strategy  tom_make_subTrans(org.polymodel.algebra.Variable t0, IntExpression t1) { 
return new subTrans(t0,t1);
}



}
