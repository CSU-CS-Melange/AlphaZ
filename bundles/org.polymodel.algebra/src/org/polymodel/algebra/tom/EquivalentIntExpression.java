package org.polymodel.algebra.tom;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.polynomials.PolynomialExpression;
import org.polymodel.algebra.polynomials.PolynomialVariable;
import org.polymodel.algebra.quasiAffine.QuasiAffineExpression;
import org.polymodel.algebra.reductions.ReductionExpression;

@SuppressWarnings("all")
public class EquivalentIntExpression {


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
private static  tom.library.sl.Strategy  tom_make_Outermost( tom.library.sl.Strategy  v) { 
return ( 
tom_make_Repeat(tom_make_OnceTopDown(v)))
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
private static boolean tom_equal_term_long(long t1, long t2) {
return  t1==t2 ;
}
private static boolean tom_is_sort_long(long t) {
return  true ;
}
private static boolean tom_equal_term_boolean(boolean t1, boolean t2) {
return  t1==t2 ;
}
private static boolean tom_is_sort_boolean(boolean t) {
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
private static boolean tom_is_fun_sym_constant(org.polymodel.algebra.IntTerm t) {
return t instanceof org.polymodel.algebra.affine.AffineTerm && ((org.polymodel.algebra.affine.AffineTerm)t).getVariable() == null;
}
private static  long  tom_get_slot_constant_coef(org.polymodel.algebra.IntTerm t) {
return ((org.polymodel.algebra.affine.AffineTerm)t).getCoef();
}
private static boolean tom_is_fun_sym_eq(org.polymodel.algebra.IntConstraint t) {
return t instanceof org.polymodel.algebra.IntConstraint && ((org.polymodel.algebra.IntConstraint)t).getComparisonOperator().equals(org.polymodel.algebra.ComparisonOperator.EQ);
}
private static org.polymodel.algebra.IntConstraint tom_make_eq(IntExpression _lhs, IntExpression _rhs) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createEq(_lhs, _rhs);
}
private static IntExpression tom_get_slot_eq_lhs(org.polymodel.algebra.IntConstraint t) {
return ((org.polymodel.algebra.IntConstraint)t).getLhs();
}
private static IntExpression tom_get_slot_eq_rhs(org.polymodel.algebra.IntConstraint t) {
return ((org.polymodel.algebra.IntConstraint)t).getRhs();
}
private static boolean tom_is_fun_sym_qaffine(IntExpression t) {
return t instanceof org.polymodel.algebra.quasiAffine.QuasiAffineExpression;
}
private static IntExpression tom_make_qaffine( EList<org.polymodel.algebra.IntTerm>  _terms) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createQaffine(_terms);
}
private static  EList<org.polymodel.algebra.IntTerm>  tom_get_slot_qaffine_terms(IntExpression t) {
return enforce(((org.polymodel.algebra.quasiAffine.QuasiAffineExpression)t).getTerms());
}
private static boolean tom_is_fun_sym_mul(org.polymodel.algebra.IntTerm t) {
return t instanceof org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm && ((org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm)t).getOperator().equals(org.polymodel.algebra.quasiAffine.QuasiAffineOperator.MUL);
}
private static IntExpression tom_get_slot_mul_expression(org.polymodel.algebra.IntTerm t) {
return ((org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm)t).getExpression();
}
private static  long  tom_get_slot_mul_coef(org.polymodel.algebra.IntTerm t) {
return ((org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm)t).getCoef();
}
private static boolean tom_is_fun_sym_mod(org.polymodel.algebra.IntTerm t) {
return t instanceof org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm && ((org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm)t).getOperator().equals(org.polymodel.algebra.quasiAffine.QuasiAffineOperator.MOD);
}
private static IntExpression tom_get_slot_mod_expression(org.polymodel.algebra.IntTerm t) {
return ((org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm)t).getExpression();
}
private static  long  tom_get_slot_mod_coef(org.polymodel.algebra.IntTerm t) {
return ((org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm)t).getCoef();
}
private static boolean tom_is_fun_sym_ceil(org.polymodel.algebra.IntTerm t) {
return t instanceof org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm && ((org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm)t).getOperator().equals(org.polymodel.algebra.quasiAffine.QuasiAffineOperator.CEIL);
}
private static IntExpression tom_get_slot_ceil_expression(org.polymodel.algebra.IntTerm t) {
return ((org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm)t).getExpression();
}
private static  long  tom_get_slot_ceil_coef(org.polymodel.algebra.IntTerm t) {
return ((org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm)t).getCoef();
}
private static boolean tom_is_fun_sym_floor(org.polymodel.algebra.IntTerm t) {
return t instanceof org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm && ((org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm)t).getOperator().equals(org.polymodel.algebra.quasiAffine.QuasiAffineOperator.FLOOR);
}
private static IntExpression tom_get_slot_floor_expression(org.polymodel.algebra.IntTerm t) {
return ((org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm)t).getExpression();
}
private static  long  tom_get_slot_floor_coef(org.polymodel.algebra.IntTerm t) {
return ((org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm)t).getCoef();
}
private static boolean tom_is_fun_sym_div(org.polymodel.algebra.IntTerm t) {
return t instanceof org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm && ((org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm)t).getOperator().equals(org.polymodel.algebra.quasiAffine.QuasiAffineOperator.DIV);
}
private static IntExpression tom_get_slot_div_expression(org.polymodel.algebra.IntTerm t) {
return ((org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm)t).getExpression();
}
private static  long  tom_get_slot_div_coef(org.polymodel.algebra.IntTerm t) {
return ((org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm)t).getCoef();
}
private static boolean tom_is_fun_sym_nmul(org.polymodel.algebra.IntTerm t) {
return t instanceof org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm && ((org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm)t).getOperator().equals(org.polymodel.algebra.quasiAffine.QuasiAffineOperator.MUL);
}
private static IntExpression tom_get_slot_nmul_expression(org.polymodel.algebra.IntTerm t) {
return ((org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm)t).getExpression();
}
private static  long  tom_get_slot_nmul_coef(org.polymodel.algebra.IntTerm t) {
return ((org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm)t).getCoef();
}
private static boolean tom_is_fun_sym_nmod(org.polymodel.algebra.IntTerm t) {
return t instanceof org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm && ((org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm)t).getOperator().equals(org.polymodel.algebra.quasiAffine.QuasiAffineOperator.MOD);
}
private static IntExpression tom_get_slot_nmod_expression(org.polymodel.algebra.IntTerm t) {
return ((org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm)t).getExpression();
}
private static  long  tom_get_slot_nmod_coef(org.polymodel.algebra.IntTerm t) {
return ((org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm)t).getCoef();
}
private static boolean tom_is_fun_sym_nceil(org.polymodel.algebra.IntTerm t) {
return t instanceof org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm && ((org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm)t).getOperator().equals(org.polymodel.algebra.quasiAffine.QuasiAffineOperator.CEIL);
}
private static IntExpression tom_get_slot_nceil_expression(org.polymodel.algebra.IntTerm t) {
return ((org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm)t).getExpression();
}
private static  long  tom_get_slot_nceil_coef(org.polymodel.algebra.IntTerm t) {
return ((org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm)t).getCoef();
}
private static boolean tom_is_fun_sym_nfloor(org.polymodel.algebra.IntTerm t) {
return t instanceof org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm && ((org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm)t).getOperator().equals(org.polymodel.algebra.quasiAffine.QuasiAffineOperator.FLOOR);
}
private static IntExpression tom_get_slot_nfloor_expression(org.polymodel.algebra.IntTerm t) {
return ((org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm)t).getExpression();
}
private static  long  tom_get_slot_nfloor_coef(org.polymodel.algebra.IntTerm t) {
return ((org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm)t).getCoef();
}
private static boolean tom_is_fun_sym_ndiv(org.polymodel.algebra.IntTerm t) {
return t instanceof org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm && ((org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm)t).getOperator().equals(org.polymodel.algebra.quasiAffine.QuasiAffineOperator.DIV);
}
private static IntExpression tom_get_slot_ndiv_expression(org.polymodel.algebra.IntTerm t) {
return ((org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm)t).getExpression();
}
private static  long  tom_get_slot_ndiv_coef(org.polymodel.algebra.IntTerm t) {
return ((org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm)t).getCoef();
}
private static boolean tom_is_fun_sym_prod(IntExpression t) {
return t instanceof org.polymodel.algebra.reductions.ReductionExpression && ((org.polymodel.algebra.reductions.ReductionExpression)t).getOperator().equals(org.polymodel.algebra.reductions.ReductionOperator.PROD);
}
private static IntExpression tom_make_prod( EList<org.polymodel.algebra.IntExpression>  _expressions) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createProd(_expressions);
}
private static  EList<org.polymodel.algebra.IntExpression>  tom_get_slot_prod_expressions(IntExpression t) {
return enforce(((org.polymodel.algebra.reductions.ReductionExpression)t).getExpressions());
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
private static boolean tom_is_fun_sym_max(IntExpression t) {
return t instanceof org.polymodel.algebra.reductions.ReductionExpression && ((org.polymodel.algebra.reductions.ReductionExpression)t).getOperator().equals(org.polymodel.algebra.reductions.ReductionOperator.MAX);
}
private static IntExpression tom_make_max( EList<org.polymodel.algebra.IntExpression>  _expressions) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createMax(_expressions);
}
private static  EList<org.polymodel.algebra.IntExpression>  tom_get_slot_max_expressions(IntExpression t) {
return enforce(((org.polymodel.algebra.reductions.ReductionExpression)t).getExpressions());
}
private static boolean tom_is_fun_sym_min(IntExpression t) {
return t instanceof org.polymodel.algebra.reductions.ReductionExpression && ((org.polymodel.algebra.reductions.ReductionExpression)t).getOperator().equals(org.polymodel.algebra.reductions.ReductionOperator.MIN);
}
private static IntExpression tom_make_min( EList<org.polymodel.algebra.IntExpression>  _expressions) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createMin(_expressions);
}
private static  EList<org.polymodel.algebra.IntExpression>  tom_get_slot_min_expressions(IntExpression t) {
return enforce(((org.polymodel.algebra.reductions.ReductionExpression)t).getExpressions());
}


private static boolean VERBOSE = false;

private static boolean isEquivalent;
private static boolean isDecidable;

public static FuzzyBoolean isEquivalent(IntExpression intExpression1, IntExpression intExpression2) {
try {
isEquivalent = false;
isDecidable = false; 
if(VERBOSE)
System.out.println("*** isEquivalent : \n\t"+intExpression1 + "\n\t" + intExpression2);
IntConstraint intConstraint = IntExpressionBuilder.constraint(intExpression1, intExpression2, ComparisonOperator.EQ);

tom_make_Outermost(tom_make_IsEquivalent()).visitLight(intConstraint, tom.mapping.GenericIntrospector.INSTANCE);
if(VERBOSE)
System.out.println("*** decidable : "+isDecidable);
if(VERBOSE)
System.out.println("*** equivalent  : "+isEquivalent+"\n");
if (!isDecidable)
return FuzzyBoolean.MAYBE;
else if (isEquivalent)
return FuzzyBoolean.YES;
else
return FuzzyBoolean.NO;
} catch(Exception e) {
System.err.println("Visitor failure on "+intExpression1+ ":"+e.getMessage());
throw new RuntimeException("Visitor failure on "+intExpression1+ ":"+e.getMessage(),e);
}
}

private static void debug(String name, IntConstraint intConstraint) {
if(VERBOSE)
System.out.println("rule "+name+" :\n\t"+intConstraint);
}

private static void checkEmptiness(IntExpression intExpressionA, IntExpression intExpressionB) {
if (intExpressionA instanceof QuasiAffineExpression && intExpressionB instanceof QuasiAffineExpression) {
QuasiAffineExpression quasiAffineExpressionA = (QuasiAffineExpression)intExpressionA;
QuasiAffineExpression quasiAffineExpressionB = (QuasiAffineExpression)intExpressionB;
if (quasiAffineExpressionA.getTerms().isEmpty() && quasiAffineExpressionB.getTerms().isEmpty()) {
isEquivalent = true;
isDecidable = true;
} else if (quasiAffineExpressionA.getTerms().isEmpty() || quasiAffineExpressionB.getTerms().isEmpty()) {
isEquivalent = false;
isDecidable = true;
} else {
isEquivalent = false;
isDecidable = false;
}
}
if (intExpressionA instanceof PolynomialExpression && intExpressionB instanceof PolynomialExpression) {
PolynomialExpression polynomialExpressionA = (PolynomialExpression)intExpressionA;
PolynomialExpression polynomialExpressionB = (PolynomialExpression)intExpressionB;
if (polynomialExpressionA.getTerms().isEmpty() && polynomialExpressionB.getTerms().isEmpty()) {
isEquivalent = true;
isDecidable = true;
} else if (polynomialExpressionA.getTerms().isEmpty() || polynomialExpressionB.getTerms().isEmpty()) {
isEquivalent = false;
isDecidable = true;
} else {
isEquivalent = false;
isDecidable = false;
}
}
if (intExpressionA instanceof ReductionExpression && intExpressionB instanceof ReductionExpression) {
ReductionExpression reductionExpressionA = (ReductionExpression)intExpressionA;
ReductionExpression reductionExpressionB = (ReductionExpression)intExpressionB;
if (reductionExpressionA.getExpressions().isEmpty() && reductionExpressionB.getExpressions().isEmpty()) {
isEquivalent = true;
isDecidable = true;
} else if (reductionExpressionA.getExpressions().isEmpty() || reductionExpressionB.getExpressions().isEmpty()) {
isEquivalent = false;
isDecidable = true;
} else {
isEquivalent = false;
isDecidable = false;
}
}
}


public static class IsEquivalent extends tom.library.sl.AbstractStrategyBasic {
public IsEquivalent() {
super(tom_make_Fail());
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
if (tom_is_sort_C(v)) {
return ((T)visit_C(((org.polymodel.algebra.IntConstraint)v),introspector));
}
if (!(( null  == environment))) {
return ((T)any.visit(environment,introspector));
} else {
return any.visitLight(v,introspector);
}
}
@SuppressWarnings("unchecked")
public org.polymodel.algebra.IntConstraint _visit_C(org.polymodel.algebra.IntConstraint arg, tom.library.sl.Introspector introspector)
 throws tom.library.sl.VisitFailure {
if (!(( null  == environment))) {
return ((org.polymodel.algebra.IntConstraint)any.visit(environment,introspector));
} else {
return any.visitLight(arg,introspector);
}
}
@SuppressWarnings("unchecked")
public org.polymodel.algebra.IntConstraint visit_C(org.polymodel.algebra.IntConstraint tom__arg, tom.library.sl.Introspector introspector)
 throws tom.library.sl.VisitFailure {
{
{
if (tom_is_sort_C(tom__arg)) {
if (tom_is_sort_C(((org.polymodel.algebra.IntConstraint)tom__arg))) {
if (tom_is_fun_sym_eq(((org.polymodel.algebra.IntConstraint)((org.polymodel.algebra.IntConstraint)tom__arg)))) {
IntExpression tomMatch1_1=tom_get_slot_eq_lhs(((org.polymodel.algebra.IntConstraint)tom__arg));
IntExpression tomMatch1_2=tom_get_slot_eq_rhs(((org.polymodel.algebra.IntConstraint)tom__arg));
if (tom_is_sort_E(tomMatch1_1)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_5=tom_get_slot_affine_terms(tomMatch1_1);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_5))) {
int tomMatch1_12=0;
if (!(tomMatch1_12 >= tom_get_size_terms_terms(tomMatch1_5))) {
org.polymodel.algebra.IntTerm tomMatch1_18=tom_get_element_terms_terms(tomMatch1_5,tomMatch1_12);
if (tom_is_sort_T(tomMatch1_18)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_18))) {
if (tomMatch1_12 + 1 >= tom_get_size_terms_terms(tomMatch1_5)) {
if (tom_is_sort_E(tomMatch1_2)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_2))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_8=tom_get_slot_affine_terms(tomMatch1_2);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_8))) {
int tomMatch1_15=0;
if (!(tomMatch1_15 >= tom_get_size_terms_terms(tomMatch1_8))) {
org.polymodel.algebra.IntTerm tomMatch1_21=tom_get_element_terms_terms(tomMatch1_8,tomMatch1_15);
if (tom_is_sort_T(tomMatch1_21)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_21))) {
if (tom_equal_term_long(tom_get_slot_constant_coef(tomMatch1_18), tom_get_slot_constant_coef(tomMatch1_21))) {
if (tomMatch1_15 + 1 >= tom_get_size_terms_terms(tomMatch1_8)) {

debug("R-1-1",
((org.polymodel.algebra.IntConstraint)tom__arg));
isEquivalent = true;
isDecidable = true;
return 
tom_make_eq(null,null);

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
}
}
{
if (tom_is_sort_C(tom__arg)) {
if (tom_is_sort_C(((org.polymodel.algebra.IntConstraint)tom__arg))) {
if (tom_is_fun_sym_eq(((org.polymodel.algebra.IntConstraint)((org.polymodel.algebra.IntConstraint)tom__arg)))) {
IntExpression tomMatch1_25=tom_get_slot_eq_lhs(((org.polymodel.algebra.IntConstraint)tom__arg));
IntExpression tomMatch1_26=tom_get_slot_eq_rhs(((org.polymodel.algebra.IntConstraint)tom__arg));
if (tom_is_sort_E(tomMatch1_25)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_25))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_29=tom_get_slot_affine_terms(tomMatch1_25);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_29))) {
int tomMatch1_36=0;
if (!(tomMatch1_36 >= tom_get_size_terms_terms(tomMatch1_29))) {
org.polymodel.algebra.IntTerm tomMatch1_43=tom_get_element_terms_terms(tomMatch1_29,tomMatch1_36);
if (tom_is_sort_T(tomMatch1_43)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_43))) {
if (tomMatch1_36 + 1 >= tom_get_size_terms_terms(tomMatch1_29)) {
if (tom_is_sort_E(tomMatch1_26)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_26))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_32=tom_get_slot_affine_terms(tomMatch1_26);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_32))) {
int tomMatch1_39=0;
if (!(tomMatch1_39 >= tom_get_size_terms_terms(tomMatch1_32))) {
org.polymodel.algebra.IntTerm tomMatch1_47=tom_get_element_terms_terms(tomMatch1_32,tomMatch1_39);
if (tom_is_sort_T(tomMatch1_47)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_47))) {
if (tom_equal_term_long(tom_get_slot_term_coef(tomMatch1_43), tom_get_slot_term_coef(tomMatch1_47))) {
if (tom_equal_term_V(tom_get_slot_term_variable(tomMatch1_43), tom_get_slot_term_variable(tomMatch1_47))) {
if (tomMatch1_39 + 1 >= tom_get_size_terms_terms(tomMatch1_32)) {

debug("R-1-1",
((org.polymodel.algebra.IntConstraint)tom__arg));
isEquivalent = true;
isDecidable = true;
return 
tom_make_eq(null,null);

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
}
}
}
{
if (tom_is_sort_C(tom__arg)) {
if (tom_is_sort_C(((org.polymodel.algebra.IntConstraint)tom__arg))) {
if (tom_is_fun_sym_eq(((org.polymodel.algebra.IntConstraint)((org.polymodel.algebra.IntConstraint)tom__arg)))) {
IntExpression tomMatch1_52=tom_get_slot_eq_lhs(((org.polymodel.algebra.IntConstraint)tom__arg));
IntExpression tomMatch1_53=tom_get_slot_eq_rhs(((org.polymodel.algebra.IntConstraint)tom__arg));
if (tom_is_sort_E(tomMatch1_52)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_52))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_56=tom_get_slot_affine_terms(tomMatch1_52);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_56))) {
int tomMatch1_63=0;
int tomMatch1_end_66=tomMatch1_63;
do {
{
if (!(tomMatch1_end_66 >= tom_get_size_terms_terms(tomMatch1_56))) {
org.polymodel.algebra.IntTerm tomMatch1_78=tom_get_element_terms_terms(tomMatch1_56,tomMatch1_end_66);
if (tom_is_sort_T(tomMatch1_78)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_78))) {
if (tom_is_sort_E(tomMatch1_53)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_53))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_59=tom_get_slot_affine_terms(tomMatch1_53);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_59))) {
int tomMatch1_70=0;
int tomMatch1_end_73=tomMatch1_70;
do {
{
if (!(tomMatch1_end_73 >= tom_get_size_terms_terms(tomMatch1_59))) {
org.polymodel.algebra.IntTerm tomMatch1_82=tom_get_element_terms_terms(tomMatch1_59,tomMatch1_end_73);
if (tom_is_sort_T(tomMatch1_82)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_82))) {
if (tom_equal_term_long(tom_get_slot_term_coef(tomMatch1_78), tom_get_slot_term_coef(tomMatch1_82))) {
if (tom_equal_term_V(tom_get_slot_term_variable(tomMatch1_78), tom_get_slot_term_variable(tomMatch1_82))) {

debug("R-1-2",
((org.polymodel.algebra.IntConstraint)tom__arg));
return 
tom_make_eq(tom_make_affine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_56,tomMatch1_end_66 + 1,tom_get_size_terms_terms(tomMatch1_56)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_56,tomMatch1_63,tomMatch1_end_66),tom_empty_array_terms(2)))),tom_make_affine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_59,tomMatch1_end_73 + 1,tom_get_size_terms_terms(tomMatch1_59)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_59,tomMatch1_70,tomMatch1_end_73),tom_empty_array_terms(2)))));

}
}
}
}
}
tomMatch1_end_73=tomMatch1_end_73 + 1;
}
} while(!(tomMatch1_end_73 > tom_get_size_terms_terms(tomMatch1_59)));
}
}
}
}
}
}
tomMatch1_end_66=tomMatch1_end_66 + 1;
}
} while(!(tomMatch1_end_66 > tom_get_size_terms_terms(tomMatch1_56)));
}
}
}
}
}
}
}
{
if (tom_is_sort_C(tom__arg)) {
if (tom_is_sort_C(((org.polymodel.algebra.IntConstraint)tom__arg))) {
if (tom_is_fun_sym_eq(((org.polymodel.algebra.IntConstraint)((org.polymodel.algebra.IntConstraint)tom__arg)))) {
IntExpression tomMatch1_87=tom_get_slot_eq_lhs(((org.polymodel.algebra.IntConstraint)tom__arg));
IntExpression tomMatch1_88=tom_get_slot_eq_rhs(((org.polymodel.algebra.IntConstraint)tom__arg));
if (tom_is_sort_E(tomMatch1_87)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_87))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_91=tom_get_slot_qaffine_terms(tomMatch1_87);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_91))) {
int tomMatch1_98=0;
if (!(tomMatch1_98 >= tom_get_size_terms_terms(tomMatch1_91))) {
org.polymodel.algebra.IntTerm tomMatch1_105=tom_get_element_terms_terms(tomMatch1_91,tomMatch1_98);
if (tom_is_sort_T(tomMatch1_105)) {
if (tom_is_fun_sym_ceil(((org.polymodel.algebra.IntTerm)tomMatch1_105))) {
if (tomMatch1_98 + 1 >= tom_get_size_terms_terms(tomMatch1_91)) {
if (tom_is_sort_E(tomMatch1_88)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_88))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_94=tom_get_slot_qaffine_terms(tomMatch1_88);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_94))) {
int tomMatch1_101=0;
if (!(tomMatch1_101 >= tom_get_size_terms_terms(tomMatch1_94))) {
org.polymodel.algebra.IntTerm tomMatch1_109=tom_get_element_terms_terms(tomMatch1_94,tomMatch1_101);
if (tom_is_sort_T(tomMatch1_109)) {
if (tom_is_fun_sym_ceil(((org.polymodel.algebra.IntTerm)tomMatch1_109))) {
if (tom_equal_term_long(tom_get_slot_ceil_coef(tomMatch1_105), tom_get_slot_ceil_coef(tomMatch1_109))) {
if (tomMatch1_101 + 1 >= tom_get_size_terms_terms(tomMatch1_94)) {

debug("R-2-1-1",
((org.polymodel.algebra.IntConstraint)tom__arg));
return 
tom_make_eq(tom_get_slot_ceil_expression(tomMatch1_105),tom_get_slot_ceil_expression(tomMatch1_109));

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
}
}
{
if (tom_is_sort_C(tom__arg)) {
if (tom_is_sort_C(((org.polymodel.algebra.IntConstraint)tom__arg))) {
if (tom_is_fun_sym_eq(((org.polymodel.algebra.IntConstraint)((org.polymodel.algebra.IntConstraint)tom__arg)))) {
IntExpression tomMatch1_113=tom_get_slot_eq_lhs(((org.polymodel.algebra.IntConstraint)tom__arg));
IntExpression tomMatch1_114=tom_get_slot_eq_rhs(((org.polymodel.algebra.IntConstraint)tom__arg));
if (tom_is_sort_E(tomMatch1_113)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_113))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_117=tom_get_slot_qaffine_terms(tomMatch1_113);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_117))) {
int tomMatch1_124=0;
int tomMatch1_end_127=tomMatch1_124;
do {
{
 EList<org.polymodel.algebra.IntTerm>  tom_x1=tom_get_slice_terms(tomMatch1_117,tomMatch1_124,tomMatch1_end_127);
if (!(tomMatch1_end_127 >= tom_get_size_terms_terms(tomMatch1_117))) {
org.polymodel.algebra.IntTerm tomMatch1_139=tom_get_element_terms_terms(tomMatch1_117,tomMatch1_end_127);
if (tom_is_sort_T(tomMatch1_139)) {
if (tom_is_fun_sym_ceil(((org.polymodel.algebra.IntTerm)tomMatch1_139))) {
 EList<org.polymodel.algebra.IntTerm>  tom_x2=tom_get_slice_terms(tomMatch1_117,tomMatch1_end_127 + 1,tom_get_size_terms_terms(tomMatch1_117));
if (tom_is_sort_E(tomMatch1_114)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_114))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_120=tom_get_slot_qaffine_terms(tomMatch1_114);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_120))) {
int tomMatch1_131=0;
int tomMatch1_end_134=tomMatch1_131;
do {
{
 EList<org.polymodel.algebra.IntTerm>  tom_x3=tom_get_slice_terms(tomMatch1_120,tomMatch1_131,tomMatch1_end_134);
if (!(tomMatch1_end_134 >= tom_get_size_terms_terms(tomMatch1_120))) {
org.polymodel.algebra.IntTerm tomMatch1_143=tom_get_element_terms_terms(tomMatch1_120,tomMatch1_end_134);
if (tom_is_sort_T(tomMatch1_143)) {
if (tom_is_fun_sym_ceil(((org.polymodel.algebra.IntTerm)tomMatch1_143))) {
if (tom_equal_term_E(tom_get_slot_ceil_expression(tomMatch1_139), tom_get_slot_ceil_expression(tomMatch1_143))) {
if (tom_equal_term_long(tom_get_slot_ceil_coef(tomMatch1_139), tom_get_slot_ceil_coef(tomMatch1_143))) {
 EList<org.polymodel.algebra.IntTerm>  tom_x4=tom_get_slice_terms(tomMatch1_120,tomMatch1_end_134 + 1,tom_get_size_terms_terms(tomMatch1_120));

debug("R-2-1-2",
((org.polymodel.algebra.IntConstraint)tom__arg));
checkEmptiness(
tom_make_qaffine(tom_append_array_terms(tom_x2,tom_append_array_terms(tom_x1,tom_empty_array_terms(2)))), 
tom_make_qaffine(tom_append_array_terms(tom_x4,tom_append_array_terms(tom_x3,tom_empty_array_terms(2)))));
return 
tom_make_eq(tom_make_qaffine(tom_append_array_terms(tom_x2,tom_append_array_terms(tom_x1,tom_empty_array_terms(2)))),tom_make_qaffine(tom_append_array_terms(tom_x4,tom_append_array_terms(tom_x3,tom_empty_array_terms(2)))));

}
}
}
}
}
tomMatch1_end_134=tomMatch1_end_134 + 1;
}
} while(!(tomMatch1_end_134 > tom_get_size_terms_terms(tomMatch1_120)));
}
}
}
}
}
}
tomMatch1_end_127=tomMatch1_end_127 + 1;
}
} while(!(tomMatch1_end_127 > tom_get_size_terms_terms(tomMatch1_117)));
}
}
}
}
}
}
}
{
if (tom_is_sort_C(tom__arg)) {
if (tom_is_sort_C(((org.polymodel.algebra.IntConstraint)tom__arg))) {
if (tom_is_fun_sym_eq(((org.polymodel.algebra.IntConstraint)((org.polymodel.algebra.IntConstraint)tom__arg)))) {
IntExpression tomMatch1_148=tom_get_slot_eq_lhs(((org.polymodel.algebra.IntConstraint)tom__arg));
IntExpression tomMatch1_149=tom_get_slot_eq_rhs(((org.polymodel.algebra.IntConstraint)tom__arg));
if (tom_is_sort_E(tomMatch1_148)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_148))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_152=tom_get_slot_qaffine_terms(tomMatch1_148);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_152))) {
int tomMatch1_159=0;
if (!(tomMatch1_159 >= tom_get_size_terms_terms(tomMatch1_152))) {
org.polymodel.algebra.IntTerm tomMatch1_166=tom_get_element_terms_terms(tomMatch1_152,tomMatch1_159);
if (tom_is_sort_T(tomMatch1_166)) {
if (tom_is_fun_sym_nceil(((org.polymodel.algebra.IntTerm)tomMatch1_166))) {
IntExpression tomMatch1_164=tom_get_slot_nceil_expression(tomMatch1_166);
if (tom_is_sort_E(tomMatch1_164)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_164))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_168=tom_get_slot_qaffine_terms(tomMatch1_164);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_168))) {
if (tomMatch1_159 + 1 >= tom_get_size_terms_terms(tomMatch1_152)) {
if (tom_is_sort_E(tomMatch1_149)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_149))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_155=tom_get_slot_qaffine_terms(tomMatch1_149);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_155))) {
int tomMatch1_162=0;
if (!(tomMatch1_162 >= tom_get_size_terms_terms(tomMatch1_155))) {
org.polymodel.algebra.IntTerm tomMatch1_173=tom_get_element_terms_terms(tomMatch1_155,tomMatch1_162);
if (tom_is_sort_T(tomMatch1_173)) {
if (tom_is_fun_sym_nceil(((org.polymodel.algebra.IntTerm)tomMatch1_173))) {
IntExpression tomMatch1_171=tom_get_slot_nceil_expression(tomMatch1_173);
if (tom_is_sort_E(tomMatch1_171)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_171))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_175=tom_get_slot_qaffine_terms(tomMatch1_171);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_175))) {
if (tom_equal_term_long(tom_get_slot_nceil_coef(tomMatch1_166), tom_get_slot_nceil_coef(tomMatch1_173))) {
if (tomMatch1_162 + 1 >= tom_get_size_terms_terms(tomMatch1_155)) {

debug("R-2-1-3",
((org.polymodel.algebra.IntConstraint)tom__arg));
return 
tom_make_eq(tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_168,0,tom_get_size_terms_terms(tomMatch1_168)),tom_empty_array_terms(1))),tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_175,0,tom_get_size_terms_terms(tomMatch1_175)),tom_empty_array_terms(1))));

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
}
}
}
}
}
}
}
}
{
if (tom_is_sort_C(tom__arg)) {
if (tom_is_sort_C(((org.polymodel.algebra.IntConstraint)tom__arg))) {
if (tom_is_fun_sym_eq(((org.polymodel.algebra.IntConstraint)((org.polymodel.algebra.IntConstraint)tom__arg)))) {
IntExpression tomMatch1_186=tom_get_slot_eq_lhs(((org.polymodel.algebra.IntConstraint)tom__arg));
IntExpression tomMatch1_187=tom_get_slot_eq_rhs(((org.polymodel.algebra.IntConstraint)tom__arg));
if (tom_is_sort_E(tomMatch1_186)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_186))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_190=tom_get_slot_qaffine_terms(tomMatch1_186);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_190))) {
int tomMatch1_197=0;
int tomMatch1_end_200=tomMatch1_197;
do {
{
if (!(tomMatch1_end_200 >= tom_get_size_terms_terms(tomMatch1_190))) {
org.polymodel.algebra.IntTerm tomMatch1_212=tom_get_element_terms_terms(tomMatch1_190,tomMatch1_end_200);
if (tom_is_sort_T(tomMatch1_212)) {
if (tom_is_fun_sym_nceil(((org.polymodel.algebra.IntTerm)tomMatch1_212))) {
IntExpression tomMatch1_210=tom_get_slot_nceil_expression(tomMatch1_212);
if (tom_is_sort_E(tomMatch1_210)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_210))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_214=tom_get_slot_qaffine_terms(tomMatch1_210);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_214))) {
if (tom_is_sort_E(tomMatch1_187)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_187))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_193=tom_get_slot_qaffine_terms(tomMatch1_187);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_193))) {
int tomMatch1_204=0;
int tomMatch1_end_207=tomMatch1_204;
do {
{
if (!(tomMatch1_end_207 >= tom_get_size_terms_terms(tomMatch1_193))) {
org.polymodel.algebra.IntTerm tomMatch1_219=tom_get_element_terms_terms(tomMatch1_193,tomMatch1_end_207);
if (tom_is_sort_T(tomMatch1_219)) {
if (tom_is_fun_sym_nceil(((org.polymodel.algebra.IntTerm)tomMatch1_219))) {
IntExpression tomMatch1_217=tom_get_slot_nceil_expression(tomMatch1_219);
if (tom_is_sort_E(tomMatch1_217)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_217))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_221=tom_get_slot_qaffine_terms(tomMatch1_217);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_221))) {
if (tom_equal_term_long(tom_get_slot_nceil_coef(tomMatch1_212), tom_get_slot_nceil_coef(tomMatch1_219))) {

debug("R-2-1-4",
((org.polymodel.algebra.IntConstraint)tom__arg));
return 
tom_make_eq(tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_214,0,tom_get_size_terms_terms(tomMatch1_214)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_190,tomMatch1_end_200 + 1,tom_get_size_terms_terms(tomMatch1_190)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_190,tomMatch1_197,tomMatch1_end_200),tom_empty_array_terms(3))))),tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_193,tomMatch1_end_207 + 1,tom_get_size_terms_terms(tomMatch1_193)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_221,0,tom_get_size_terms_terms(tomMatch1_221)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_193,tomMatch1_204,tomMatch1_end_207),tom_empty_array_terms(3))))));

}
}
}
}
}
}
}
tomMatch1_end_207=tomMatch1_end_207 + 1;
}
} while(!(tomMatch1_end_207 > tom_get_size_terms_terms(tomMatch1_193)));
}
}
}
}
}
}
}
}
}
tomMatch1_end_200=tomMatch1_end_200 + 1;
}
} while(!(tomMatch1_end_200 > tom_get_size_terms_terms(tomMatch1_190)));
}
}
}
}
}
}
}
{
if (tom_is_sort_C(tom__arg)) {
if (tom_is_sort_C(((org.polymodel.algebra.IntConstraint)tom__arg))) {
if (tom_is_fun_sym_eq(((org.polymodel.algebra.IntConstraint)((org.polymodel.algebra.IntConstraint)tom__arg)))) {
IntExpression tomMatch1_232=tom_get_slot_eq_lhs(((org.polymodel.algebra.IntConstraint)tom__arg));
IntExpression tomMatch1_233=tom_get_slot_eq_rhs(((org.polymodel.algebra.IntConstraint)tom__arg));
if (tom_is_sort_E(tomMatch1_232)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_232))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_236=tom_get_slot_qaffine_terms(tomMatch1_232);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_236))) {
int tomMatch1_243=0;
if (!(tomMatch1_243 >= tom_get_size_terms_terms(tomMatch1_236))) {
org.polymodel.algebra.IntTerm tomMatch1_250=tom_get_element_terms_terms(tomMatch1_236,tomMatch1_243);
if (tom_is_sort_T(tomMatch1_250)) {
if (tom_is_fun_sym_div(((org.polymodel.algebra.IntTerm)tomMatch1_250))) {
if (tomMatch1_243 + 1 >= tom_get_size_terms_terms(tomMatch1_236)) {
if (tom_is_sort_E(tomMatch1_233)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_233))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_239=tom_get_slot_qaffine_terms(tomMatch1_233);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_239))) {
int tomMatch1_246=0;
if (!(tomMatch1_246 >= tom_get_size_terms_terms(tomMatch1_239))) {
org.polymodel.algebra.IntTerm tomMatch1_254=tom_get_element_terms_terms(tomMatch1_239,tomMatch1_246);
if (tom_is_sort_T(tomMatch1_254)) {
if (tom_is_fun_sym_div(((org.polymodel.algebra.IntTerm)tomMatch1_254))) {
if (tom_equal_term_long(tom_get_slot_div_coef(tomMatch1_250), tom_get_slot_div_coef(tomMatch1_254))) {
if (tomMatch1_246 + 1 >= tom_get_size_terms_terms(tomMatch1_239)) {

debug("R-2-2-1",
((org.polymodel.algebra.IntConstraint)tom__arg));
return 
tom_make_eq(tom_get_slot_div_expression(tomMatch1_250),tom_get_slot_div_expression(tomMatch1_254));

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
}
}
{
if (tom_is_sort_C(tom__arg)) {
if (tom_is_sort_C(((org.polymodel.algebra.IntConstraint)tom__arg))) {
if (tom_is_fun_sym_eq(((org.polymodel.algebra.IntConstraint)((org.polymodel.algebra.IntConstraint)tom__arg)))) {
IntExpression tomMatch1_258=tom_get_slot_eq_lhs(((org.polymodel.algebra.IntConstraint)tom__arg));
IntExpression tomMatch1_259=tom_get_slot_eq_rhs(((org.polymodel.algebra.IntConstraint)tom__arg));
if (tom_is_sort_E(tomMatch1_258)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_258))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_262=tom_get_slot_qaffine_terms(tomMatch1_258);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_262))) {
int tomMatch1_269=0;
int tomMatch1_end_272=tomMatch1_269;
do {
{
 EList<org.polymodel.algebra.IntTerm>  tom_x1=tom_get_slice_terms(tomMatch1_262,tomMatch1_269,tomMatch1_end_272);
if (!(tomMatch1_end_272 >= tom_get_size_terms_terms(tomMatch1_262))) {
org.polymodel.algebra.IntTerm tomMatch1_284=tom_get_element_terms_terms(tomMatch1_262,tomMatch1_end_272);
if (tom_is_sort_T(tomMatch1_284)) {
if (tom_is_fun_sym_div(((org.polymodel.algebra.IntTerm)tomMatch1_284))) {
 EList<org.polymodel.algebra.IntTerm>  tom_x2=tom_get_slice_terms(tomMatch1_262,tomMatch1_end_272 + 1,tom_get_size_terms_terms(tomMatch1_262));
if (tom_is_sort_E(tomMatch1_259)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_259))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_265=tom_get_slot_qaffine_terms(tomMatch1_259);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_265))) {
int tomMatch1_276=0;
int tomMatch1_end_279=tomMatch1_276;
do {
{
 EList<org.polymodel.algebra.IntTerm>  tom_x3=tom_get_slice_terms(tomMatch1_265,tomMatch1_276,tomMatch1_end_279);
if (!(tomMatch1_end_279 >= tom_get_size_terms_terms(tomMatch1_265))) {
org.polymodel.algebra.IntTerm tomMatch1_288=tom_get_element_terms_terms(tomMatch1_265,tomMatch1_end_279);
if (tom_is_sort_T(tomMatch1_288)) {
if (tom_is_fun_sym_div(((org.polymodel.algebra.IntTerm)tomMatch1_288))) {
if (tom_equal_term_E(tom_get_slot_div_expression(tomMatch1_284), tom_get_slot_div_expression(tomMatch1_288))) {
if (tom_equal_term_long(tom_get_slot_div_coef(tomMatch1_284), tom_get_slot_div_coef(tomMatch1_288))) {
 EList<org.polymodel.algebra.IntTerm>  tom_x4=tom_get_slice_terms(tomMatch1_265,tomMatch1_end_279 + 1,tom_get_size_terms_terms(tomMatch1_265));

debug("R-2-2-2",
((org.polymodel.algebra.IntConstraint)tom__arg));
checkEmptiness(
tom_make_qaffine(tom_append_array_terms(tom_x2,tom_append_array_terms(tom_x1,tom_empty_array_terms(2)))), 
tom_make_qaffine(tom_append_array_terms(tom_x4,tom_append_array_terms(tom_x3,tom_empty_array_terms(2)))));
return 
tom_make_eq(tom_make_qaffine(tom_append_array_terms(tom_x2,tom_append_array_terms(tom_x1,tom_empty_array_terms(2)))),tom_make_qaffine(tom_append_array_terms(tom_x4,tom_append_array_terms(tom_x3,tom_empty_array_terms(2)))));

}
}
}
}
}
tomMatch1_end_279=tomMatch1_end_279 + 1;
}
} while(!(tomMatch1_end_279 > tom_get_size_terms_terms(tomMatch1_265)));
}
}
}
}
}
}
tomMatch1_end_272=tomMatch1_end_272 + 1;
}
} while(!(tomMatch1_end_272 > tom_get_size_terms_terms(tomMatch1_262)));
}
}
}
}
}
}
}
{
if (tom_is_sort_C(tom__arg)) {
if (tom_is_sort_C(((org.polymodel.algebra.IntConstraint)tom__arg))) {
if (tom_is_fun_sym_eq(((org.polymodel.algebra.IntConstraint)((org.polymodel.algebra.IntConstraint)tom__arg)))) {
IntExpression tomMatch1_293=tom_get_slot_eq_lhs(((org.polymodel.algebra.IntConstraint)tom__arg));
IntExpression tomMatch1_294=tom_get_slot_eq_rhs(((org.polymodel.algebra.IntConstraint)tom__arg));
if (tom_is_sort_E(tomMatch1_293)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_293))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_297=tom_get_slot_qaffine_terms(tomMatch1_293);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_297))) {
int tomMatch1_304=0;
if (!(tomMatch1_304 >= tom_get_size_terms_terms(tomMatch1_297))) {
org.polymodel.algebra.IntTerm tomMatch1_311=tom_get_element_terms_terms(tomMatch1_297,tomMatch1_304);
if (tom_is_sort_T(tomMatch1_311)) {
if (tom_is_fun_sym_ndiv(((org.polymodel.algebra.IntTerm)tomMatch1_311))) {
IntExpression tomMatch1_309=tom_get_slot_ndiv_expression(tomMatch1_311);
if (tom_is_sort_E(tomMatch1_309)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_309))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_313=tom_get_slot_qaffine_terms(tomMatch1_309);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_313))) {
if (tomMatch1_304 + 1 >= tom_get_size_terms_terms(tomMatch1_297)) {
if (tom_is_sort_E(tomMatch1_294)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_294))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_300=tom_get_slot_qaffine_terms(tomMatch1_294);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_300))) {
int tomMatch1_307=0;
if (!(tomMatch1_307 >= tom_get_size_terms_terms(tomMatch1_300))) {
org.polymodel.algebra.IntTerm tomMatch1_318=tom_get_element_terms_terms(tomMatch1_300,tomMatch1_307);
if (tom_is_sort_T(tomMatch1_318)) {
if (tom_is_fun_sym_ndiv(((org.polymodel.algebra.IntTerm)tomMatch1_318))) {
IntExpression tomMatch1_316=tom_get_slot_ndiv_expression(tomMatch1_318);
if (tom_is_sort_E(tomMatch1_316)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_316))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_320=tom_get_slot_qaffine_terms(tomMatch1_316);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_320))) {
if (tom_equal_term_long(tom_get_slot_ndiv_coef(tomMatch1_311), tom_get_slot_ndiv_coef(tomMatch1_318))) {
if (tomMatch1_307 + 1 >= tom_get_size_terms_terms(tomMatch1_300)) {

debug("R-2-2-3",
((org.polymodel.algebra.IntConstraint)tom__arg));
isEquivalent = true;
return 
tom_make_eq(tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_313,0,tom_get_size_terms_terms(tomMatch1_313)),tom_empty_array_terms(1))),tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_320,0,tom_get_size_terms_terms(tomMatch1_320)),tom_empty_array_terms(1))));

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
}
}
}
}
}
}
}
}
{
if (tom_is_sort_C(tom__arg)) {
if (tom_is_sort_C(((org.polymodel.algebra.IntConstraint)tom__arg))) {
if (tom_is_fun_sym_eq(((org.polymodel.algebra.IntConstraint)((org.polymodel.algebra.IntConstraint)tom__arg)))) {
IntExpression tomMatch1_331=tom_get_slot_eq_lhs(((org.polymodel.algebra.IntConstraint)tom__arg));
IntExpression tomMatch1_332=tom_get_slot_eq_rhs(((org.polymodel.algebra.IntConstraint)tom__arg));
if (tom_is_sort_E(tomMatch1_331)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_331))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_335=tom_get_slot_qaffine_terms(tomMatch1_331);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_335))) {
int tomMatch1_342=0;
int tomMatch1_end_345=tomMatch1_342;
do {
{
if (!(tomMatch1_end_345 >= tom_get_size_terms_terms(tomMatch1_335))) {
org.polymodel.algebra.IntTerm tomMatch1_357=tom_get_element_terms_terms(tomMatch1_335,tomMatch1_end_345);
if (tom_is_sort_T(tomMatch1_357)) {
if (tom_is_fun_sym_ndiv(((org.polymodel.algebra.IntTerm)tomMatch1_357))) {
IntExpression tomMatch1_355=tom_get_slot_ndiv_expression(tomMatch1_357);
if (tom_is_sort_E(tomMatch1_355)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_355))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_359=tom_get_slot_qaffine_terms(tomMatch1_355);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_359))) {
if (tom_is_sort_E(tomMatch1_332)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_332))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_338=tom_get_slot_qaffine_terms(tomMatch1_332);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_338))) {
int tomMatch1_349=0;
int tomMatch1_end_352=tomMatch1_349;
do {
{
if (!(tomMatch1_end_352 >= tom_get_size_terms_terms(tomMatch1_338))) {
org.polymodel.algebra.IntTerm tomMatch1_364=tom_get_element_terms_terms(tomMatch1_338,tomMatch1_end_352);
if (tom_is_sort_T(tomMatch1_364)) {
if (tom_is_fun_sym_ndiv(((org.polymodel.algebra.IntTerm)tomMatch1_364))) {
IntExpression tomMatch1_362=tom_get_slot_ndiv_expression(tomMatch1_364);
if (tom_is_sort_E(tomMatch1_362)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_362))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_366=tom_get_slot_qaffine_terms(tomMatch1_362);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_366))) {
if (tom_equal_term_long(tom_get_slot_ndiv_coef(tomMatch1_357), tom_get_slot_ndiv_coef(tomMatch1_364))) {

debug("R-2-2-4",
((org.polymodel.algebra.IntConstraint)tom__arg));
return 
tom_make_eq(tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_359,0,tom_get_size_terms_terms(tomMatch1_359)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_335,tomMatch1_end_345 + 1,tom_get_size_terms_terms(tomMatch1_335)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_335,tomMatch1_342,tomMatch1_end_345),tom_empty_array_terms(3))))),tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_338,tomMatch1_end_352 + 1,tom_get_size_terms_terms(tomMatch1_338)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_366,0,tom_get_size_terms_terms(tomMatch1_366)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_338,tomMatch1_349,tomMatch1_end_352),tom_empty_array_terms(3))))));

}
}
}
}
}
}
}
tomMatch1_end_352=tomMatch1_end_352 + 1;
}
} while(!(tomMatch1_end_352 > tom_get_size_terms_terms(tomMatch1_338)));
}
}
}
}
}
}
}
}
}
tomMatch1_end_345=tomMatch1_end_345 + 1;
}
} while(!(tomMatch1_end_345 > tom_get_size_terms_terms(tomMatch1_335)));
}
}
}
}
}
}
}
{
if (tom_is_sort_C(tom__arg)) {
if (tom_is_sort_C(((org.polymodel.algebra.IntConstraint)tom__arg))) {
if (tom_is_fun_sym_eq(((org.polymodel.algebra.IntConstraint)((org.polymodel.algebra.IntConstraint)tom__arg)))) {
IntExpression tomMatch1_377=tom_get_slot_eq_lhs(((org.polymodel.algebra.IntConstraint)tom__arg));
IntExpression tomMatch1_378=tom_get_slot_eq_rhs(((org.polymodel.algebra.IntConstraint)tom__arg));
if (tom_is_sort_E(tomMatch1_377)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_377))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_381=tom_get_slot_qaffine_terms(tomMatch1_377);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_381))) {
int tomMatch1_388=0;
if (!(tomMatch1_388 >= tom_get_size_terms_terms(tomMatch1_381))) {
org.polymodel.algebra.IntTerm tomMatch1_395=tom_get_element_terms_terms(tomMatch1_381,tomMatch1_388);
if (tom_is_sort_T(tomMatch1_395)) {
if (tom_is_fun_sym_floor(((org.polymodel.algebra.IntTerm)tomMatch1_395))) {
if (tomMatch1_388 + 1 >= tom_get_size_terms_terms(tomMatch1_381)) {
if (tom_is_sort_E(tomMatch1_378)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_378))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_384=tom_get_slot_qaffine_terms(tomMatch1_378);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_384))) {
int tomMatch1_391=0;
if (!(tomMatch1_391 >= tom_get_size_terms_terms(tomMatch1_384))) {
org.polymodel.algebra.IntTerm tomMatch1_399=tom_get_element_terms_terms(tomMatch1_384,tomMatch1_391);
if (tom_is_sort_T(tomMatch1_399)) {
if (tom_is_fun_sym_floor(((org.polymodel.algebra.IntTerm)tomMatch1_399))) {
if (tom_equal_term_long(tom_get_slot_floor_coef(tomMatch1_395), tom_get_slot_floor_coef(tomMatch1_399))) {
if (tomMatch1_391 + 1 >= tom_get_size_terms_terms(tomMatch1_384)) {

debug("R-2-3-1",
((org.polymodel.algebra.IntConstraint)tom__arg));
return 
tom_make_eq(tom_get_slot_floor_expression(tomMatch1_395),tom_get_slot_floor_expression(tomMatch1_399));

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
}
}
{
if (tom_is_sort_C(tom__arg)) {
if (tom_is_sort_C(((org.polymodel.algebra.IntConstraint)tom__arg))) {
if (tom_is_fun_sym_eq(((org.polymodel.algebra.IntConstraint)((org.polymodel.algebra.IntConstraint)tom__arg)))) {
IntExpression tomMatch1_403=tom_get_slot_eq_lhs(((org.polymodel.algebra.IntConstraint)tom__arg));
IntExpression tomMatch1_404=tom_get_slot_eq_rhs(((org.polymodel.algebra.IntConstraint)tom__arg));
if (tom_is_sort_E(tomMatch1_403)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_403))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_407=tom_get_slot_qaffine_terms(tomMatch1_403);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_407))) {
int tomMatch1_414=0;
int tomMatch1_end_417=tomMatch1_414;
do {
{
 EList<org.polymodel.algebra.IntTerm>  tom_x1=tom_get_slice_terms(tomMatch1_407,tomMatch1_414,tomMatch1_end_417);
if (!(tomMatch1_end_417 >= tom_get_size_terms_terms(tomMatch1_407))) {
org.polymodel.algebra.IntTerm tomMatch1_429=tom_get_element_terms_terms(tomMatch1_407,tomMatch1_end_417);
if (tom_is_sort_T(tomMatch1_429)) {
if (tom_is_fun_sym_floor(((org.polymodel.algebra.IntTerm)tomMatch1_429))) {
 EList<org.polymodel.algebra.IntTerm>  tom_x2=tom_get_slice_terms(tomMatch1_407,tomMatch1_end_417 + 1,tom_get_size_terms_terms(tomMatch1_407));
if (tom_is_sort_E(tomMatch1_404)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_404))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_410=tom_get_slot_qaffine_terms(tomMatch1_404);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_410))) {
int tomMatch1_421=0;
int tomMatch1_end_424=tomMatch1_421;
do {
{
 EList<org.polymodel.algebra.IntTerm>  tom_x3=tom_get_slice_terms(tomMatch1_410,tomMatch1_421,tomMatch1_end_424);
if (!(tomMatch1_end_424 >= tom_get_size_terms_terms(tomMatch1_410))) {
org.polymodel.algebra.IntTerm tomMatch1_433=tom_get_element_terms_terms(tomMatch1_410,tomMatch1_end_424);
if (tom_is_sort_T(tomMatch1_433)) {
if (tom_is_fun_sym_floor(((org.polymodel.algebra.IntTerm)tomMatch1_433))) {
if (tom_equal_term_E(tom_get_slot_floor_expression(tomMatch1_429), tom_get_slot_floor_expression(tomMatch1_433))) {
if (tom_equal_term_long(tom_get_slot_floor_coef(tomMatch1_429), tom_get_slot_floor_coef(tomMatch1_433))) {
 EList<org.polymodel.algebra.IntTerm>  tom_x4=tom_get_slice_terms(tomMatch1_410,tomMatch1_end_424 + 1,tom_get_size_terms_terms(tomMatch1_410));

debug("R-2-3-2",
((org.polymodel.algebra.IntConstraint)tom__arg));
checkEmptiness(
tom_make_qaffine(tom_append_array_terms(tom_x2,tom_append_array_terms(tom_x1,tom_empty_array_terms(2)))), 
tom_make_qaffine(tom_append_array_terms(tom_x4,tom_append_array_terms(tom_x3,tom_empty_array_terms(2)))));
return 
tom_make_eq(tom_make_qaffine(tom_append_array_terms(tom_x2,tom_append_array_terms(tom_x1,tom_empty_array_terms(2)))),tom_make_qaffine(tom_append_array_terms(tom_x4,tom_append_array_terms(tom_x3,tom_empty_array_terms(2)))));

}
}
}
}
}
tomMatch1_end_424=tomMatch1_end_424 + 1;
}
} while(!(tomMatch1_end_424 > tom_get_size_terms_terms(tomMatch1_410)));
}
}
}
}
}
}
tomMatch1_end_417=tomMatch1_end_417 + 1;
}
} while(!(tomMatch1_end_417 > tom_get_size_terms_terms(tomMatch1_407)));
}
}
}
}
}
}
}
{
if (tom_is_sort_C(tom__arg)) {
if (tom_is_sort_C(((org.polymodel.algebra.IntConstraint)tom__arg))) {
if (tom_is_fun_sym_eq(((org.polymodel.algebra.IntConstraint)((org.polymodel.algebra.IntConstraint)tom__arg)))) {
IntExpression tomMatch1_438=tom_get_slot_eq_lhs(((org.polymodel.algebra.IntConstraint)tom__arg));
IntExpression tomMatch1_439=tom_get_slot_eq_rhs(((org.polymodel.algebra.IntConstraint)tom__arg));
if (tom_is_sort_E(tomMatch1_438)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_438))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_442=tom_get_slot_qaffine_terms(tomMatch1_438);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_442))) {
int tomMatch1_449=0;
if (!(tomMatch1_449 >= tom_get_size_terms_terms(tomMatch1_442))) {
org.polymodel.algebra.IntTerm tomMatch1_456=tom_get_element_terms_terms(tomMatch1_442,tomMatch1_449);
if (tom_is_sort_T(tomMatch1_456)) {
if (tom_is_fun_sym_nfloor(((org.polymodel.algebra.IntTerm)tomMatch1_456))) {
IntExpression tomMatch1_454=tom_get_slot_nfloor_expression(tomMatch1_456);
if (tom_is_sort_E(tomMatch1_454)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_454))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_458=tom_get_slot_qaffine_terms(tomMatch1_454);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_458))) {
if (tomMatch1_449 + 1 >= tom_get_size_terms_terms(tomMatch1_442)) {
if (tom_is_sort_E(tomMatch1_439)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_439))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_445=tom_get_slot_qaffine_terms(tomMatch1_439);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_445))) {
int tomMatch1_452=0;
if (!(tomMatch1_452 >= tom_get_size_terms_terms(tomMatch1_445))) {
org.polymodel.algebra.IntTerm tomMatch1_463=tom_get_element_terms_terms(tomMatch1_445,tomMatch1_452);
if (tom_is_sort_T(tomMatch1_463)) {
if (tom_is_fun_sym_nfloor(((org.polymodel.algebra.IntTerm)tomMatch1_463))) {
IntExpression tomMatch1_461=tom_get_slot_nfloor_expression(tomMatch1_463);
if (tom_is_sort_E(tomMatch1_461)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_461))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_465=tom_get_slot_qaffine_terms(tomMatch1_461);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_465))) {
if (tom_equal_term_long(tom_get_slot_nfloor_coef(tomMatch1_456), tom_get_slot_nfloor_coef(tomMatch1_463))) {
if (tomMatch1_452 + 1 >= tom_get_size_terms_terms(tomMatch1_445)) {

debug("R-2-3-3",
((org.polymodel.algebra.IntConstraint)tom__arg));
isEquivalent = true;
return 
tom_make_eq(tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_458,0,tom_get_size_terms_terms(tomMatch1_458)),tom_empty_array_terms(1))),tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_465,0,tom_get_size_terms_terms(tomMatch1_465)),tom_empty_array_terms(1))));

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
}
}
}
}
}
}
}
}
{
if (tom_is_sort_C(tom__arg)) {
if (tom_is_sort_C(((org.polymodel.algebra.IntConstraint)tom__arg))) {
if (tom_is_fun_sym_eq(((org.polymodel.algebra.IntConstraint)((org.polymodel.algebra.IntConstraint)tom__arg)))) {
IntExpression tomMatch1_476=tom_get_slot_eq_lhs(((org.polymodel.algebra.IntConstraint)tom__arg));
IntExpression tomMatch1_477=tom_get_slot_eq_rhs(((org.polymodel.algebra.IntConstraint)tom__arg));
if (tom_is_sort_E(tomMatch1_476)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_476))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_480=tom_get_slot_qaffine_terms(tomMatch1_476);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_480))) {
int tomMatch1_487=0;
int tomMatch1_end_490=tomMatch1_487;
do {
{
if (!(tomMatch1_end_490 >= tom_get_size_terms_terms(tomMatch1_480))) {
org.polymodel.algebra.IntTerm tomMatch1_502=tom_get_element_terms_terms(tomMatch1_480,tomMatch1_end_490);
if (tom_is_sort_T(tomMatch1_502)) {
if (tom_is_fun_sym_nfloor(((org.polymodel.algebra.IntTerm)tomMatch1_502))) {
IntExpression tomMatch1_500=tom_get_slot_nfloor_expression(tomMatch1_502);
if (tom_is_sort_E(tomMatch1_500)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_500))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_504=tom_get_slot_qaffine_terms(tomMatch1_500);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_504))) {
if (tom_is_sort_E(tomMatch1_477)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_477))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_483=tom_get_slot_qaffine_terms(tomMatch1_477);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_483))) {
int tomMatch1_494=0;
int tomMatch1_end_497=tomMatch1_494;
do {
{
if (!(tomMatch1_end_497 >= tom_get_size_terms_terms(tomMatch1_483))) {
org.polymodel.algebra.IntTerm tomMatch1_509=tom_get_element_terms_terms(tomMatch1_483,tomMatch1_end_497);
if (tom_is_sort_T(tomMatch1_509)) {
if (tom_is_fun_sym_nfloor(((org.polymodel.algebra.IntTerm)tomMatch1_509))) {
IntExpression tomMatch1_507=tom_get_slot_nfloor_expression(tomMatch1_509);
if (tom_is_sort_E(tomMatch1_507)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_507))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_511=tom_get_slot_qaffine_terms(tomMatch1_507);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_511))) {
if (tom_equal_term_long(tom_get_slot_nfloor_coef(tomMatch1_502), tom_get_slot_nfloor_coef(tomMatch1_509))) {

debug("R-2-3-4",
((org.polymodel.algebra.IntConstraint)tom__arg));
return 
tom_make_eq(tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_504,0,tom_get_size_terms_terms(tomMatch1_504)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_480,tomMatch1_end_490 + 1,tom_get_size_terms_terms(tomMatch1_480)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_480,tomMatch1_487,tomMatch1_end_490),tom_empty_array_terms(3))))),tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_483,tomMatch1_end_497 + 1,tom_get_size_terms_terms(tomMatch1_483)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_511,0,tom_get_size_terms_terms(tomMatch1_511)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_483,tomMatch1_494,tomMatch1_end_497),tom_empty_array_terms(3))))));

}
}
}
}
}
}
}
tomMatch1_end_497=tomMatch1_end_497 + 1;
}
} while(!(tomMatch1_end_497 > tom_get_size_terms_terms(tomMatch1_483)));
}
}
}
}
}
}
}
}
}
tomMatch1_end_490=tomMatch1_end_490 + 1;
}
} while(!(tomMatch1_end_490 > tom_get_size_terms_terms(tomMatch1_480)));
}
}
}
}
}
}
}
{
if (tom_is_sort_C(tom__arg)) {
if (tom_is_sort_C(((org.polymodel.algebra.IntConstraint)tom__arg))) {
if (tom_is_fun_sym_eq(((org.polymodel.algebra.IntConstraint)((org.polymodel.algebra.IntConstraint)tom__arg)))) {
IntExpression tomMatch1_522=tom_get_slot_eq_lhs(((org.polymodel.algebra.IntConstraint)tom__arg));
IntExpression tomMatch1_523=tom_get_slot_eq_rhs(((org.polymodel.algebra.IntConstraint)tom__arg));
if (tom_is_sort_E(tomMatch1_522)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_522))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_526=tom_get_slot_qaffine_terms(tomMatch1_522);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_526))) {
int tomMatch1_533=0;
if (!(tomMatch1_533 >= tom_get_size_terms_terms(tomMatch1_526))) {
org.polymodel.algebra.IntTerm tomMatch1_540=tom_get_element_terms_terms(tomMatch1_526,tomMatch1_533);
if (tom_is_sort_T(tomMatch1_540)) {
if (tom_is_fun_sym_mul(((org.polymodel.algebra.IntTerm)tomMatch1_540))) {
if (tomMatch1_533 + 1 >= tom_get_size_terms_terms(tomMatch1_526)) {
if (tom_is_sort_E(tomMatch1_523)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_523))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_529=tom_get_slot_qaffine_terms(tomMatch1_523);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_529))) {
int tomMatch1_536=0;
if (!(tomMatch1_536 >= tom_get_size_terms_terms(tomMatch1_529))) {
org.polymodel.algebra.IntTerm tomMatch1_544=tom_get_element_terms_terms(tomMatch1_529,tomMatch1_536);
if (tom_is_sort_T(tomMatch1_544)) {
if (tom_is_fun_sym_mul(((org.polymodel.algebra.IntTerm)tomMatch1_544))) {
if (tom_equal_term_long(tom_get_slot_mul_coef(tomMatch1_540), tom_get_slot_mul_coef(tomMatch1_544))) {
if (tomMatch1_536 + 1 >= tom_get_size_terms_terms(tomMatch1_529)) {

debug("R-2-4-1",
((org.polymodel.algebra.IntConstraint)tom__arg));
return 
tom_make_eq(tom_get_slot_mul_expression(tomMatch1_540),tom_get_slot_mul_expression(tomMatch1_544));

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
}
}
{
if (tom_is_sort_C(tom__arg)) {
if (tom_is_sort_C(((org.polymodel.algebra.IntConstraint)tom__arg))) {
if (tom_is_fun_sym_eq(((org.polymodel.algebra.IntConstraint)((org.polymodel.algebra.IntConstraint)tom__arg)))) {
IntExpression tomMatch1_548=tom_get_slot_eq_lhs(((org.polymodel.algebra.IntConstraint)tom__arg));
IntExpression tomMatch1_549=tom_get_slot_eq_rhs(((org.polymodel.algebra.IntConstraint)tom__arg));
if (tom_is_sort_E(tomMatch1_548)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_548))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_552=tom_get_slot_qaffine_terms(tomMatch1_548);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_552))) {
int tomMatch1_559=0;
int tomMatch1_end_562=tomMatch1_559;
do {
{
 EList<org.polymodel.algebra.IntTerm>  tom_x1=tom_get_slice_terms(tomMatch1_552,tomMatch1_559,tomMatch1_end_562);
if (!(tomMatch1_end_562 >= tom_get_size_terms_terms(tomMatch1_552))) {
org.polymodel.algebra.IntTerm tomMatch1_574=tom_get_element_terms_terms(tomMatch1_552,tomMatch1_end_562);
if (tom_is_sort_T(tomMatch1_574)) {
if (tom_is_fun_sym_mul(((org.polymodel.algebra.IntTerm)tomMatch1_574))) {
 EList<org.polymodel.algebra.IntTerm>  tom_x2=tom_get_slice_terms(tomMatch1_552,tomMatch1_end_562 + 1,tom_get_size_terms_terms(tomMatch1_552));
if (tom_is_sort_E(tomMatch1_549)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_549))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_555=tom_get_slot_qaffine_terms(tomMatch1_549);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_555))) {
int tomMatch1_566=0;
int tomMatch1_end_569=tomMatch1_566;
do {
{
 EList<org.polymodel.algebra.IntTerm>  tom_x3=tom_get_slice_terms(tomMatch1_555,tomMatch1_566,tomMatch1_end_569);
if (!(tomMatch1_end_569 >= tom_get_size_terms_terms(tomMatch1_555))) {
org.polymodel.algebra.IntTerm tomMatch1_578=tom_get_element_terms_terms(tomMatch1_555,tomMatch1_end_569);
if (tom_is_sort_T(tomMatch1_578)) {
if (tom_is_fun_sym_mul(((org.polymodel.algebra.IntTerm)tomMatch1_578))) {
if (tom_equal_term_E(tom_get_slot_mul_expression(tomMatch1_574), tom_get_slot_mul_expression(tomMatch1_578))) {
if (tom_equal_term_long(tom_get_slot_mul_coef(tomMatch1_574), tom_get_slot_mul_coef(tomMatch1_578))) {
 EList<org.polymodel.algebra.IntTerm>  tom_x4=tom_get_slice_terms(tomMatch1_555,tomMatch1_end_569 + 1,tom_get_size_terms_terms(tomMatch1_555));

debug("R-2-4-2",
((org.polymodel.algebra.IntConstraint)tom__arg));
checkEmptiness(
tom_make_qaffine(tom_append_array_terms(tom_x2,tom_append_array_terms(tom_x1,tom_empty_array_terms(2)))), 
tom_make_qaffine(tom_append_array_terms(tom_x4,tom_append_array_terms(tom_x3,tom_empty_array_terms(2)))));
return 
tom_make_eq(tom_make_qaffine(tom_append_array_terms(tom_x2,tom_append_array_terms(tom_x1,tom_empty_array_terms(2)))),tom_make_qaffine(tom_append_array_terms(tom_x4,tom_append_array_terms(tom_x3,tom_empty_array_terms(2)))));

}
}
}
}
}
tomMatch1_end_569=tomMatch1_end_569 + 1;
}
} while(!(tomMatch1_end_569 > tom_get_size_terms_terms(tomMatch1_555)));
}
}
}
}
}
}
tomMatch1_end_562=tomMatch1_end_562 + 1;
}
} while(!(tomMatch1_end_562 > tom_get_size_terms_terms(tomMatch1_552)));
}
}
}
}
}
}
}
{
if (tom_is_sort_C(tom__arg)) {
if (tom_is_sort_C(((org.polymodel.algebra.IntConstraint)tom__arg))) {
if (tom_is_fun_sym_eq(((org.polymodel.algebra.IntConstraint)((org.polymodel.algebra.IntConstraint)tom__arg)))) {
IntExpression tomMatch1_583=tom_get_slot_eq_lhs(((org.polymodel.algebra.IntConstraint)tom__arg));
IntExpression tomMatch1_584=tom_get_slot_eq_rhs(((org.polymodel.algebra.IntConstraint)tom__arg));
if (tom_is_sort_E(tomMatch1_583)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_583))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_587=tom_get_slot_qaffine_terms(tomMatch1_583);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_587))) {
int tomMatch1_594=0;
if (!(tomMatch1_594 >= tom_get_size_terms_terms(tomMatch1_587))) {
org.polymodel.algebra.IntTerm tomMatch1_601=tom_get_element_terms_terms(tomMatch1_587,tomMatch1_594);
if (tom_is_sort_T(tomMatch1_601)) {
if (tom_is_fun_sym_nmul(((org.polymodel.algebra.IntTerm)tomMatch1_601))) {
IntExpression tomMatch1_599=tom_get_slot_nmul_expression(tomMatch1_601);
if (tom_is_sort_E(tomMatch1_599)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_599))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_603=tom_get_slot_qaffine_terms(tomMatch1_599);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_603))) {
if (tomMatch1_594 + 1 >= tom_get_size_terms_terms(tomMatch1_587)) {
if (tom_is_sort_E(tomMatch1_584)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_584))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_590=tom_get_slot_qaffine_terms(tomMatch1_584);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_590))) {
int tomMatch1_597=0;
if (!(tomMatch1_597 >= tom_get_size_terms_terms(tomMatch1_590))) {
org.polymodel.algebra.IntTerm tomMatch1_608=tom_get_element_terms_terms(tomMatch1_590,tomMatch1_597);
if (tom_is_sort_T(tomMatch1_608)) {
if (tom_is_fun_sym_nmul(((org.polymodel.algebra.IntTerm)tomMatch1_608))) {
IntExpression tomMatch1_606=tom_get_slot_nmul_expression(tomMatch1_608);
if (tom_is_sort_E(tomMatch1_606)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_606))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_610=tom_get_slot_qaffine_terms(tomMatch1_606);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_610))) {
if (tom_equal_term_long(tom_get_slot_nmul_coef(tomMatch1_601), tom_get_slot_nmul_coef(tomMatch1_608))) {
if (tomMatch1_597 + 1 >= tom_get_size_terms_terms(tomMatch1_590)) {

debug("R-2-4-3",
((org.polymodel.algebra.IntConstraint)tom__arg));
isEquivalent = true;
return 
tom_make_eq(tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_603,0,tom_get_size_terms_terms(tomMatch1_603)),tom_empty_array_terms(1))),tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_610,0,tom_get_size_terms_terms(tomMatch1_610)),tom_empty_array_terms(1))));

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
}
}
}
}
}
}
}
}
{
if (tom_is_sort_C(tom__arg)) {
if (tom_is_sort_C(((org.polymodel.algebra.IntConstraint)tom__arg))) {
if (tom_is_fun_sym_eq(((org.polymodel.algebra.IntConstraint)((org.polymodel.algebra.IntConstraint)tom__arg)))) {
IntExpression tomMatch1_621=tom_get_slot_eq_lhs(((org.polymodel.algebra.IntConstraint)tom__arg));
IntExpression tomMatch1_622=tom_get_slot_eq_rhs(((org.polymodel.algebra.IntConstraint)tom__arg));
if (tom_is_sort_E(tomMatch1_621)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_621))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_625=tom_get_slot_qaffine_terms(tomMatch1_621);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_625))) {
int tomMatch1_632=0;
int tomMatch1_end_635=tomMatch1_632;
do {
{
if (!(tomMatch1_end_635 >= tom_get_size_terms_terms(tomMatch1_625))) {
org.polymodel.algebra.IntTerm tomMatch1_647=tom_get_element_terms_terms(tomMatch1_625,tomMatch1_end_635);
if (tom_is_sort_T(tomMatch1_647)) {
if (tom_is_fun_sym_nmul(((org.polymodel.algebra.IntTerm)tomMatch1_647))) {
IntExpression tomMatch1_645=tom_get_slot_nmul_expression(tomMatch1_647);
if (tom_is_sort_E(tomMatch1_645)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_645))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_649=tom_get_slot_qaffine_terms(tomMatch1_645);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_649))) {
if (tom_is_sort_E(tomMatch1_622)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_622))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_628=tom_get_slot_qaffine_terms(tomMatch1_622);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_628))) {
int tomMatch1_639=0;
int tomMatch1_end_642=tomMatch1_639;
do {
{
if (!(tomMatch1_end_642 >= tom_get_size_terms_terms(tomMatch1_628))) {
org.polymodel.algebra.IntTerm tomMatch1_654=tom_get_element_terms_terms(tomMatch1_628,tomMatch1_end_642);
if (tom_is_sort_T(tomMatch1_654)) {
if (tom_is_fun_sym_nmul(((org.polymodel.algebra.IntTerm)tomMatch1_654))) {
IntExpression tomMatch1_652=tom_get_slot_nmul_expression(tomMatch1_654);
if (tom_is_sort_E(tomMatch1_652)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_652))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_656=tom_get_slot_qaffine_terms(tomMatch1_652);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_656))) {
if (tom_equal_term_long(tom_get_slot_nmul_coef(tomMatch1_647), tom_get_slot_nmul_coef(tomMatch1_654))) {

debug("R-2-4-4",
((org.polymodel.algebra.IntConstraint)tom__arg));
return 
tom_make_eq(tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_649,0,tom_get_size_terms_terms(tomMatch1_649)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_625,tomMatch1_end_635 + 1,tom_get_size_terms_terms(tomMatch1_625)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_625,tomMatch1_632,tomMatch1_end_635),tom_empty_array_terms(3))))),tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_628,tomMatch1_end_642 + 1,tom_get_size_terms_terms(tomMatch1_628)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_656,0,tom_get_size_terms_terms(tomMatch1_656)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_628,tomMatch1_639,tomMatch1_end_642),tom_empty_array_terms(3))))));

}
}
}
}
}
}
}
tomMatch1_end_642=tomMatch1_end_642 + 1;
}
} while(!(tomMatch1_end_642 > tom_get_size_terms_terms(tomMatch1_628)));
}
}
}
}
}
}
}
}
}
tomMatch1_end_635=tomMatch1_end_635 + 1;
}
} while(!(tomMatch1_end_635 > tom_get_size_terms_terms(tomMatch1_625)));
}
}
}
}
}
}
}
{
if (tom_is_sort_C(tom__arg)) {
if (tom_is_sort_C(((org.polymodel.algebra.IntConstraint)tom__arg))) {
if (tom_is_fun_sym_eq(((org.polymodel.algebra.IntConstraint)((org.polymodel.algebra.IntConstraint)tom__arg)))) {
IntExpression tomMatch1_667=tom_get_slot_eq_lhs(((org.polymodel.algebra.IntConstraint)tom__arg));
IntExpression tomMatch1_668=tom_get_slot_eq_rhs(((org.polymodel.algebra.IntConstraint)tom__arg));
if (tom_is_sort_E(tomMatch1_667)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_667))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_671=tom_get_slot_qaffine_terms(tomMatch1_667);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_671))) {
int tomMatch1_678=0;
if (!(tomMatch1_678 >= tom_get_size_terms_terms(tomMatch1_671))) {
org.polymodel.algebra.IntTerm tomMatch1_685=tom_get_element_terms_terms(tomMatch1_671,tomMatch1_678);
if (tom_is_sort_T(tomMatch1_685)) {
if (tom_is_fun_sym_mod(((org.polymodel.algebra.IntTerm)tomMatch1_685))) {
if (tomMatch1_678 + 1 >= tom_get_size_terms_terms(tomMatch1_671)) {
if (tom_is_sort_E(tomMatch1_668)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_668))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_674=tom_get_slot_qaffine_terms(tomMatch1_668);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_674))) {
int tomMatch1_681=0;
if (!(tomMatch1_681 >= tom_get_size_terms_terms(tomMatch1_674))) {
org.polymodel.algebra.IntTerm tomMatch1_689=tom_get_element_terms_terms(tomMatch1_674,tomMatch1_681);
if (tom_is_sort_T(tomMatch1_689)) {
if (tom_is_fun_sym_mod(((org.polymodel.algebra.IntTerm)tomMatch1_689))) {
if (tom_equal_term_long(tom_get_slot_mod_coef(tomMatch1_685), tom_get_slot_mod_coef(tomMatch1_689))) {
if (tomMatch1_681 + 1 >= tom_get_size_terms_terms(tomMatch1_674)) {

debug("R-2-5-1",
((org.polymodel.algebra.IntConstraint)tom__arg));
return 
tom_make_eq(tom_get_slot_mod_expression(tomMatch1_685),tom_get_slot_mod_expression(tomMatch1_689));

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
}
}
{
if (tom_is_sort_C(tom__arg)) {
if (tom_is_sort_C(((org.polymodel.algebra.IntConstraint)tom__arg))) {
if (tom_is_fun_sym_eq(((org.polymodel.algebra.IntConstraint)((org.polymodel.algebra.IntConstraint)tom__arg)))) {
IntExpression tomMatch1_693=tom_get_slot_eq_lhs(((org.polymodel.algebra.IntConstraint)tom__arg));
IntExpression tomMatch1_694=tom_get_slot_eq_rhs(((org.polymodel.algebra.IntConstraint)tom__arg));
if (tom_is_sort_E(tomMatch1_693)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_693))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_697=tom_get_slot_qaffine_terms(tomMatch1_693);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_697))) {
int tomMatch1_704=0;
int tomMatch1_end_707=tomMatch1_704;
do {
{
 EList<org.polymodel.algebra.IntTerm>  tom_x1=tom_get_slice_terms(tomMatch1_697,tomMatch1_704,tomMatch1_end_707);
if (!(tomMatch1_end_707 >= tom_get_size_terms_terms(tomMatch1_697))) {
org.polymodel.algebra.IntTerm tomMatch1_719=tom_get_element_terms_terms(tomMatch1_697,tomMatch1_end_707);
if (tom_is_sort_T(tomMatch1_719)) {
if (tom_is_fun_sym_mod(((org.polymodel.algebra.IntTerm)tomMatch1_719))) {
 EList<org.polymodel.algebra.IntTerm>  tom_x2=tom_get_slice_terms(tomMatch1_697,tomMatch1_end_707 + 1,tom_get_size_terms_terms(tomMatch1_697));
if (tom_is_sort_E(tomMatch1_694)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_694))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_700=tom_get_slot_qaffine_terms(tomMatch1_694);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_700))) {
int tomMatch1_711=0;
int tomMatch1_end_714=tomMatch1_711;
do {
{
 EList<org.polymodel.algebra.IntTerm>  tom_x3=tom_get_slice_terms(tomMatch1_700,tomMatch1_711,tomMatch1_end_714);
if (!(tomMatch1_end_714 >= tom_get_size_terms_terms(tomMatch1_700))) {
org.polymodel.algebra.IntTerm tomMatch1_723=tom_get_element_terms_terms(tomMatch1_700,tomMatch1_end_714);
if (tom_is_sort_T(tomMatch1_723)) {
if (tom_is_fun_sym_mod(((org.polymodel.algebra.IntTerm)tomMatch1_723))) {
if (tom_equal_term_E(tom_get_slot_mod_expression(tomMatch1_719), tom_get_slot_mod_expression(tomMatch1_723))) {
if (tom_equal_term_long(tom_get_slot_mod_coef(tomMatch1_719), tom_get_slot_mod_coef(tomMatch1_723))) {
 EList<org.polymodel.algebra.IntTerm>  tom_x4=tom_get_slice_terms(tomMatch1_700,tomMatch1_end_714 + 1,tom_get_size_terms_terms(tomMatch1_700));

debug("R-2-5-2",
((org.polymodel.algebra.IntConstraint)tom__arg));
checkEmptiness(
tom_make_qaffine(tom_append_array_terms(tom_x2,tom_append_array_terms(tom_x1,tom_empty_array_terms(2)))), 
tom_make_qaffine(tom_append_array_terms(tom_x4,tom_append_array_terms(tom_x3,tom_empty_array_terms(2)))));
return 
tom_make_eq(tom_make_qaffine(tom_append_array_terms(tom_x2,tom_append_array_terms(tom_x1,tom_empty_array_terms(2)))),tom_make_qaffine(tom_append_array_terms(tom_x4,tom_append_array_terms(tom_x3,tom_empty_array_terms(2)))));

}
}
}
}
}
tomMatch1_end_714=tomMatch1_end_714 + 1;
}
} while(!(tomMatch1_end_714 > tom_get_size_terms_terms(tomMatch1_700)));
}
}
}
}
}
}
tomMatch1_end_707=tomMatch1_end_707 + 1;
}
} while(!(tomMatch1_end_707 > tom_get_size_terms_terms(tomMatch1_697)));
}
}
}
}
}
}
}
{
if (tom_is_sort_C(tom__arg)) {
if (tom_is_sort_C(((org.polymodel.algebra.IntConstraint)tom__arg))) {
if (tom_is_fun_sym_eq(((org.polymodel.algebra.IntConstraint)((org.polymodel.algebra.IntConstraint)tom__arg)))) {
IntExpression tomMatch1_728=tom_get_slot_eq_lhs(((org.polymodel.algebra.IntConstraint)tom__arg));
IntExpression tomMatch1_729=tom_get_slot_eq_rhs(((org.polymodel.algebra.IntConstraint)tom__arg));
if (tom_is_sort_E(tomMatch1_728)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_728))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_732=tom_get_slot_qaffine_terms(tomMatch1_728);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_732))) {
int tomMatch1_739=0;
if (!(tomMatch1_739 >= tom_get_size_terms_terms(tomMatch1_732))) {
org.polymodel.algebra.IntTerm tomMatch1_746=tom_get_element_terms_terms(tomMatch1_732,tomMatch1_739);
if (tom_is_sort_T(tomMatch1_746)) {
if (tom_is_fun_sym_nmod(((org.polymodel.algebra.IntTerm)tomMatch1_746))) {
IntExpression tomMatch1_744=tom_get_slot_nmod_expression(tomMatch1_746);
if (tom_is_sort_E(tomMatch1_744)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_744))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_748=tom_get_slot_qaffine_terms(tomMatch1_744);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_748))) {
if (tomMatch1_739 + 1 >= tom_get_size_terms_terms(tomMatch1_732)) {
if (tom_is_sort_E(tomMatch1_729)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_729))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_735=tom_get_slot_qaffine_terms(tomMatch1_729);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_735))) {
int tomMatch1_742=0;
if (!(tomMatch1_742 >= tom_get_size_terms_terms(tomMatch1_735))) {
org.polymodel.algebra.IntTerm tomMatch1_753=tom_get_element_terms_terms(tomMatch1_735,tomMatch1_742);
if (tom_is_sort_T(tomMatch1_753)) {
if (tom_is_fun_sym_nmod(((org.polymodel.algebra.IntTerm)tomMatch1_753))) {
IntExpression tomMatch1_751=tom_get_slot_nmod_expression(tomMatch1_753);
if (tom_is_sort_E(tomMatch1_751)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_751))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_755=tom_get_slot_qaffine_terms(tomMatch1_751);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_755))) {
if (tom_equal_term_long(tom_get_slot_nmod_coef(tomMatch1_746), tom_get_slot_nmod_coef(tomMatch1_753))) {
if (tomMatch1_742 + 1 >= tom_get_size_terms_terms(tomMatch1_735)) {

debug("R-2-5-3",
((org.polymodel.algebra.IntConstraint)tom__arg));
isEquivalent = true;
return 
tom_make_eq(tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_748,0,tom_get_size_terms_terms(tomMatch1_748)),tom_empty_array_terms(1))),tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_755,0,tom_get_size_terms_terms(tomMatch1_755)),tom_empty_array_terms(1))));

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
}
}
}
}
}
}
}
}
{
if (tom_is_sort_C(tom__arg)) {
if (tom_is_sort_C(((org.polymodel.algebra.IntConstraint)tom__arg))) {
if (tom_is_fun_sym_eq(((org.polymodel.algebra.IntConstraint)((org.polymodel.algebra.IntConstraint)tom__arg)))) {
IntExpression tomMatch1_766=tom_get_slot_eq_lhs(((org.polymodel.algebra.IntConstraint)tom__arg));
IntExpression tomMatch1_767=tom_get_slot_eq_rhs(((org.polymodel.algebra.IntConstraint)tom__arg));
if (tom_is_sort_E(tomMatch1_766)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_766))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_770=tom_get_slot_qaffine_terms(tomMatch1_766);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_770))) {
int tomMatch1_777=0;
int tomMatch1_end_780=tomMatch1_777;
do {
{
if (!(tomMatch1_end_780 >= tom_get_size_terms_terms(tomMatch1_770))) {
org.polymodel.algebra.IntTerm tomMatch1_792=tom_get_element_terms_terms(tomMatch1_770,tomMatch1_end_780);
if (tom_is_sort_T(tomMatch1_792)) {
if (tom_is_fun_sym_nmod(((org.polymodel.algebra.IntTerm)tomMatch1_792))) {
IntExpression tomMatch1_790=tom_get_slot_nmod_expression(tomMatch1_792);
if (tom_is_sort_E(tomMatch1_790)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_790))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_794=tom_get_slot_qaffine_terms(tomMatch1_790);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_794))) {
if (tom_is_sort_E(tomMatch1_767)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_767))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_773=tom_get_slot_qaffine_terms(tomMatch1_767);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_773))) {
int tomMatch1_784=0;
int tomMatch1_end_787=tomMatch1_784;
do {
{
if (!(tomMatch1_end_787 >= tom_get_size_terms_terms(tomMatch1_773))) {
org.polymodel.algebra.IntTerm tomMatch1_799=tom_get_element_terms_terms(tomMatch1_773,tomMatch1_end_787);
if (tom_is_sort_T(tomMatch1_799)) {
if (tom_is_fun_sym_nmod(((org.polymodel.algebra.IntTerm)tomMatch1_799))) {
IntExpression tomMatch1_797=tom_get_slot_nmod_expression(tomMatch1_799);
if (tom_is_sort_E(tomMatch1_797)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_797))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_801=tom_get_slot_qaffine_terms(tomMatch1_797);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_801))) {
if (tom_equal_term_long(tom_get_slot_nmod_coef(tomMatch1_792), tom_get_slot_nmod_coef(tomMatch1_799))) {

debug("R-2-5-4",
((org.polymodel.algebra.IntConstraint)tom__arg));
return 
tom_make_eq(tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_794,0,tom_get_size_terms_terms(tomMatch1_794)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_770,tomMatch1_end_780 + 1,tom_get_size_terms_terms(tomMatch1_770)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_770,tomMatch1_777,tomMatch1_end_780),tom_empty_array_terms(3))))),tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_773,tomMatch1_end_787 + 1,tom_get_size_terms_terms(tomMatch1_773)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_801,0,tom_get_size_terms_terms(tomMatch1_801)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_773,tomMatch1_784,tomMatch1_end_787),tom_empty_array_terms(3))))));

}
}
}
}
}
}
}
tomMatch1_end_787=tomMatch1_end_787 + 1;
}
} while(!(tomMatch1_end_787 > tom_get_size_terms_terms(tomMatch1_773)));
}
}
}
}
}
}
}
}
}
tomMatch1_end_780=tomMatch1_end_780 + 1;
}
} while(!(tomMatch1_end_780 > tom_get_size_terms_terms(tomMatch1_770)));
}
}
}
}
}
}
}
{
if (tom_is_sort_C(tom__arg)) {
if (tom_is_sort_C(((org.polymodel.algebra.IntConstraint)tom__arg))) {
if (tom_is_fun_sym_eq(((org.polymodel.algebra.IntConstraint)((org.polymodel.algebra.IntConstraint)tom__arg)))) {
IntExpression tomMatch1_812=tom_get_slot_eq_lhs(((org.polymodel.algebra.IntConstraint)tom__arg));
IntExpression tomMatch1_813=tom_get_slot_eq_rhs(((org.polymodel.algebra.IntConstraint)tom__arg));
if (tom_is_sort_E(tomMatch1_812)) {
if (tom_is_fun_sym_min(((IntExpression)tomMatch1_812))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_816=tom_get_slot_min_expressions(tomMatch1_812);
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_816))) {
int tomMatch1_823=0;
int tomMatch1_end_826=tomMatch1_823;
do {
{
 EList<org.polymodel.algebra.IntExpression>  tom_exp1=tom_get_slice_EL(tomMatch1_816,tomMatch1_823,tomMatch1_end_826);
if (!(tomMatch1_end_826 >= tom_get_size_EL_EL(tomMatch1_816))) {
 EList<org.polymodel.algebra.IntExpression>  tom_exp2=tom_get_slice_EL(tomMatch1_816,tomMatch1_end_826 + 1,tom_get_size_EL_EL(tomMatch1_816));
if (tom_is_sort_E(tomMatch1_813)) {
if (tom_is_fun_sym_min(((IntExpression)tomMatch1_813))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_819=tom_get_slot_min_expressions(tomMatch1_813);
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_819))) {
int tomMatch1_830=0;
int tomMatch1_end_833=tomMatch1_830;
do {
{
 EList<org.polymodel.algebra.IntExpression>  tom_exp3=tom_get_slice_EL(tomMatch1_819,tomMatch1_830,tomMatch1_end_833);
if (!(tomMatch1_end_833 >= tom_get_size_EL_EL(tomMatch1_819))) {
if (tom_equal_term_E(tom_get_element_EL_EL(tomMatch1_816,tomMatch1_end_826), tom_get_element_EL_EL(tomMatch1_819,tomMatch1_end_833))) {
 EList<org.polymodel.algebra.IntExpression>  tom_exp4=tom_get_slice_EL(tomMatch1_819,tomMatch1_end_833 + 1,tom_get_size_EL_EL(tomMatch1_819));

debug("R-9",
((org.polymodel.algebra.IntConstraint)tom__arg));
checkEmptiness(
tom_make_min(tom_append_array_EL(tom_exp2,tom_append_array_EL(tom_exp1,tom_empty_array_EL(2)))), 
tom_make_min(tom_append_array_EL(tom_exp4,tom_append_array_EL(tom_exp3,tom_empty_array_EL(2)))));
return 
tom_make_eq(tom_make_min(tom_append_array_EL(tom_exp2,tom_append_array_EL(tom_exp1,tom_empty_array_EL(2)))),tom_make_min(tom_append_array_EL(tom_exp4,tom_append_array_EL(tom_exp3,tom_empty_array_EL(2)))));

}
}
tomMatch1_end_833=tomMatch1_end_833 + 1;
}
} while(!(tomMatch1_end_833 > tom_get_size_EL_EL(tomMatch1_819)));
}
}
}
}
tomMatch1_end_826=tomMatch1_end_826 + 1;
}
} while(!(tomMatch1_end_826 > tom_get_size_EL_EL(tomMatch1_816)));
}
}
}
}
}
}
}
{
if (tom_is_sort_C(tom__arg)) {
if (tom_is_sort_C(((org.polymodel.algebra.IntConstraint)tom__arg))) {
if (tom_is_fun_sym_eq(((org.polymodel.algebra.IntConstraint)((org.polymodel.algebra.IntConstraint)tom__arg)))) {
IntExpression tomMatch1_838=tom_get_slot_eq_lhs(((org.polymodel.algebra.IntConstraint)tom__arg));
IntExpression tomMatch1_839=tom_get_slot_eq_rhs(((org.polymodel.algebra.IntConstraint)tom__arg));
if (tom_is_sort_E(tomMatch1_838)) {
if (tom_is_fun_sym_max(((IntExpression)tomMatch1_838))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_842=tom_get_slot_max_expressions(tomMatch1_838);
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_842))) {
int tomMatch1_849=0;
int tomMatch1_end_852=tomMatch1_849;
do {
{
 EList<org.polymodel.algebra.IntExpression>  tom_exp1=tom_get_slice_EL(tomMatch1_842,tomMatch1_849,tomMatch1_end_852);
if (!(tomMatch1_end_852 >= tom_get_size_EL_EL(tomMatch1_842))) {
 EList<org.polymodel.algebra.IntExpression>  tom_exp2=tom_get_slice_EL(tomMatch1_842,tomMatch1_end_852 + 1,tom_get_size_EL_EL(tomMatch1_842));
if (tom_is_sort_E(tomMatch1_839)) {
if (tom_is_fun_sym_max(((IntExpression)tomMatch1_839))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_845=tom_get_slot_max_expressions(tomMatch1_839);
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_845))) {
int tomMatch1_856=0;
int tomMatch1_end_859=tomMatch1_856;
do {
{
 EList<org.polymodel.algebra.IntExpression>  tom_exp3=tom_get_slice_EL(tomMatch1_845,tomMatch1_856,tomMatch1_end_859);
if (!(tomMatch1_end_859 >= tom_get_size_EL_EL(tomMatch1_845))) {
if (tom_equal_term_E(tom_get_element_EL_EL(tomMatch1_842,tomMatch1_end_852), tom_get_element_EL_EL(tomMatch1_845,tomMatch1_end_859))) {
 EList<org.polymodel.algebra.IntExpression>  tom_exp4=tom_get_slice_EL(tomMatch1_845,tomMatch1_end_859 + 1,tom_get_size_EL_EL(tomMatch1_845));

debug("R-10",
((org.polymodel.algebra.IntConstraint)tom__arg));
checkEmptiness(
tom_make_max(tom_append_array_EL(tom_exp2,tom_append_array_EL(tom_exp1,tom_empty_array_EL(2)))), 
tom_make_max(tom_append_array_EL(tom_exp4,tom_append_array_EL(tom_exp3,tom_empty_array_EL(2)))));
return 
tom_make_eq(tom_make_max(tom_append_array_EL(tom_exp2,tom_append_array_EL(tom_exp1,tom_empty_array_EL(2)))),tom_make_max(tom_append_array_EL(tom_exp4,tom_append_array_EL(tom_exp3,tom_empty_array_EL(2)))));

}
}
tomMatch1_end_859=tomMatch1_end_859 + 1;
}
} while(!(tomMatch1_end_859 > tom_get_size_EL_EL(tomMatch1_845)));
}
}
}
}
tomMatch1_end_852=tomMatch1_end_852 + 1;
}
} while(!(tomMatch1_end_852 > tom_get_size_EL_EL(tomMatch1_842)));
}
}
}
}
}
}
}
{
if (tom_is_sort_C(tom__arg)) {
if (tom_is_sort_C(((org.polymodel.algebra.IntConstraint)tom__arg))) {
if (tom_is_fun_sym_eq(((org.polymodel.algebra.IntConstraint)((org.polymodel.algebra.IntConstraint)tom__arg)))) {
IntExpression tomMatch1_864=tom_get_slot_eq_lhs(((org.polymodel.algebra.IntConstraint)tom__arg));
IntExpression tomMatch1_865=tom_get_slot_eq_rhs(((org.polymodel.algebra.IntConstraint)tom__arg));
if (tom_is_sort_E(tomMatch1_864)) {
if (tom_is_fun_sym_sum(((IntExpression)tomMatch1_864))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_868=tom_get_slot_sum_expressions(tomMatch1_864);
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_868))) {
int tomMatch1_875=0;
int tomMatch1_end_878=tomMatch1_875;
do {
{
 EList<org.polymodel.algebra.IntExpression>  tom_exp1=tom_get_slice_EL(tomMatch1_868,tomMatch1_875,tomMatch1_end_878);
if (!(tomMatch1_end_878 >= tom_get_size_EL_EL(tomMatch1_868))) {
 EList<org.polymodel.algebra.IntExpression>  tom_exp2=tom_get_slice_EL(tomMatch1_868,tomMatch1_end_878 + 1,tom_get_size_EL_EL(tomMatch1_868));
if (tom_is_sort_E(tomMatch1_865)) {
if (tom_is_fun_sym_sum(((IntExpression)tomMatch1_865))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_871=tom_get_slot_sum_expressions(tomMatch1_865);
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_871))) {
int tomMatch1_882=0;
int tomMatch1_end_885=tomMatch1_882;
do {
{
 EList<org.polymodel.algebra.IntExpression>  tom_exp3=tom_get_slice_EL(tomMatch1_871,tomMatch1_882,tomMatch1_end_885);
if (!(tomMatch1_end_885 >= tom_get_size_EL_EL(tomMatch1_871))) {
if (tom_equal_term_E(tom_get_element_EL_EL(tomMatch1_868,tomMatch1_end_878), tom_get_element_EL_EL(tomMatch1_871,tomMatch1_end_885))) {
 EList<org.polymodel.algebra.IntExpression>  tom_exp4=tom_get_slice_EL(tomMatch1_871,tomMatch1_end_885 + 1,tom_get_size_EL_EL(tomMatch1_871));

debug("R-10",
((org.polymodel.algebra.IntConstraint)tom__arg));
checkEmptiness(
tom_make_sum(tom_append_array_EL(tom_exp2,tom_append_array_EL(tom_exp1,tom_empty_array_EL(2)))), 
tom_make_sum(tom_append_array_EL(tom_exp4,tom_append_array_EL(tom_exp3,tom_empty_array_EL(2)))));
return 
tom_make_eq(tom_make_sum(tom_append_array_EL(tom_exp2,tom_append_array_EL(tom_exp1,tom_empty_array_EL(2)))),tom_make_sum(tom_append_array_EL(tom_exp4,tom_append_array_EL(tom_exp3,tom_empty_array_EL(2)))));

}
}
tomMatch1_end_885=tomMatch1_end_885 + 1;
}
} while(!(tomMatch1_end_885 > tom_get_size_EL_EL(tomMatch1_871)));
}
}
}
}
tomMatch1_end_878=tomMatch1_end_878 + 1;
}
} while(!(tomMatch1_end_878 > tom_get_size_EL_EL(tomMatch1_868)));
}
}
}
}
}
}
}
{
if (tom_is_sort_C(tom__arg)) {
if (tom_is_sort_C(((org.polymodel.algebra.IntConstraint)tom__arg))) {
if (tom_is_fun_sym_eq(((org.polymodel.algebra.IntConstraint)((org.polymodel.algebra.IntConstraint)tom__arg)))) {
IntExpression tomMatch1_890=tom_get_slot_eq_lhs(((org.polymodel.algebra.IntConstraint)tom__arg));
IntExpression tomMatch1_891=tom_get_slot_eq_rhs(((org.polymodel.algebra.IntConstraint)tom__arg));
if (tom_is_sort_E(tomMatch1_890)) {
if (tom_is_fun_sym_prod(((IntExpression)tomMatch1_890))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_894=tom_get_slot_prod_expressions(tomMatch1_890);
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_894))) {
int tomMatch1_901=0;
int tomMatch1_end_904=tomMatch1_901;
do {
{
 EList<org.polymodel.algebra.IntExpression>  tom_exp1=tom_get_slice_EL(tomMatch1_894,tomMatch1_901,tomMatch1_end_904);
if (!(tomMatch1_end_904 >= tom_get_size_EL_EL(tomMatch1_894))) {
 EList<org.polymodel.algebra.IntExpression>  tom_exp2=tom_get_slice_EL(tomMatch1_894,tomMatch1_end_904 + 1,tom_get_size_EL_EL(tomMatch1_894));
if (tom_is_sort_E(tomMatch1_891)) {
if (tom_is_fun_sym_prod(((IntExpression)tomMatch1_891))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_897=tom_get_slot_prod_expressions(tomMatch1_891);
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_897))) {
int tomMatch1_908=0;
int tomMatch1_end_911=tomMatch1_908;
do {
{
 EList<org.polymodel.algebra.IntExpression>  tom_exp3=tom_get_slice_EL(tomMatch1_897,tomMatch1_908,tomMatch1_end_911);
if (!(tomMatch1_end_911 >= tom_get_size_EL_EL(tomMatch1_897))) {
if (tom_equal_term_E(tom_get_element_EL_EL(tomMatch1_894,tomMatch1_end_904), tom_get_element_EL_EL(tomMatch1_897,tomMatch1_end_911))) {
 EList<org.polymodel.algebra.IntExpression>  tom_exp4=tom_get_slice_EL(tomMatch1_897,tomMatch1_end_911 + 1,tom_get_size_EL_EL(tomMatch1_897));

debug("R-10",
((org.polymodel.algebra.IntConstraint)tom__arg));
checkEmptiness(
tom_make_prod(tom_append_array_EL(tom_exp2,tom_append_array_EL(tom_exp1,tom_empty_array_EL(2)))), 
tom_make_prod(tom_append_array_EL(tom_exp4,tom_append_array_EL(tom_exp3,tom_empty_array_EL(2)))));
return 
tom_make_eq(tom_make_prod(tom_append_array_EL(tom_exp2,tom_append_array_EL(tom_exp1,tom_empty_array_EL(2)))),tom_make_prod(tom_append_array_EL(tom_exp4,tom_append_array_EL(tom_exp3,tom_empty_array_EL(2)))));

}
}
tomMatch1_end_911=tomMatch1_end_911 + 1;
}
} while(!(tomMatch1_end_911 > tom_get_size_EL_EL(tomMatch1_897)));
}
}
}
}
tomMatch1_end_904=tomMatch1_end_904 + 1;
}
} while(!(tomMatch1_end_904 > tom_get_size_EL_EL(tomMatch1_894)));
}
}
}
}
}
}
}
}
return _visit_C(tom__arg,introspector);
}
}
private static  tom.library.sl.Strategy  tom_make_IsEquivalent() { 
return new IsEquivalent();
}

}
