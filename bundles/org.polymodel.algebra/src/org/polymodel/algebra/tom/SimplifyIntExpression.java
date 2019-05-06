package org.polymodel.algebra.tom;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.CompositeOperator;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.polynomials.PolynomialVariable;
import org.polymodel.algebra.quasiAffine.QuasiAffineTerm;

@SuppressWarnings("all")
public class SimplifyIntExpression  {


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
private static  tom.library.sl.Strategy  tom_make_Innermost( tom.library.sl.Strategy  v) { 
return ( 
tom_make_mu(tom_make_MuVar("_x"),tom_cons_list_Sequence(tom_make_All(tom_make_MuVar("_x")),tom_cons_list_Sequence(tom_make_Try(tom_cons_list_Sequence(v,tom_cons_list_Sequence(tom_make_MuVar("_x"),tom_empty_list_Sequence()))),tom_empty_list_Sequence()))))
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
private static boolean tom_is_fun_sym_pterms( EList<org.polymodel.algebra.polynomials.PolynomialTerm>  t) {
return  t instanceof EList<?> &&
 		(((EList<org.polymodel.algebra.polynomials.PolynomialTerm>)t).size() == 0 
 		|| (((EList<org.polymodel.algebra.polynomials.PolynomialTerm>)t).size()>0 && ((EList<org.polymodel.algebra.polynomials.PolynomialTerm>)t).get(0) instanceof org.polymodel.algebra.polynomials.PolynomialTerm));
}
private static  EList<org.polymodel.algebra.polynomials.PolynomialTerm>  tom_empty_array_pterms(int n) { 
return  new BasicEList<org.polymodel.algebra.polynomials.PolynomialTerm>(n) ;
}
private static  EList<org.polymodel.algebra.polynomials.PolynomialTerm>  tom_cons_array_pterms(org.polymodel.algebra.polynomials.PolynomialTerm e,  EList<org.polymodel.algebra.polynomials.PolynomialTerm>  l) { 
return  append(e,l) ;
}
private static org.polymodel.algebra.polynomials.PolynomialTerm tom_get_element_pterms_pterms( EList<org.polymodel.algebra.polynomials.PolynomialTerm>  l, int n) {
return  l.get(n) ;
}
private static int tom_get_size_pterms_pterms( EList<org.polymodel.algebra.polynomials.PolynomialTerm>  l) {
return  l.size() ;
}

  private static   EList<org.polymodel.algebra.polynomials.PolynomialTerm>  tom_get_slice_pterms( EList<org.polymodel.algebra.polynomials.PolynomialTerm>  subject, int begin, int end) {
     EList<org.polymodel.algebra.polynomials.PolynomialTerm>  result =  new BasicEList<org.polymodel.algebra.polynomials.PolynomialTerm>(end-begin) ;
    while(begin!=end) {
      result =  append( subject.get(begin) ,result) ;
      begin++;
    }
    return result;
  }

  private static   EList<org.polymodel.algebra.polynomials.PolynomialTerm>  tom_append_array_pterms( EList<org.polymodel.algebra.polynomials.PolynomialTerm>  l2,  EList<org.polymodel.algebra.polynomials.PolynomialTerm>  l1) {
    int size1 =  l1.size() ;
    int size2 =  l2.size() ;
    int index;
     EList<org.polymodel.algebra.polynomials.PolynomialTerm>  result =  new BasicEList<org.polymodel.algebra.polynomials.PolynomialTerm>(size1+size2) ;
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
  }private static boolean tom_equal_term_pvar(Object l1, Object l2) {
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
private static boolean tom_is_fun_sym_pvars( EList<org.polymodel.algebra.polynomials.PolynomialVariable>  t) {
return  t instanceof EList<?> &&
 		(((EList<org.polymodel.algebra.polynomials.PolynomialVariable>)t).size() == 0 
 		|| (((EList<org.polymodel.algebra.polynomials.PolynomialVariable>)t).size()>0 && ((EList<org.polymodel.algebra.polynomials.PolynomialVariable>)t).get(0) instanceof org.polymodel.algebra.polynomials.PolynomialVariable));
}
private static  EList<org.polymodel.algebra.polynomials.PolynomialVariable>  tom_empty_array_pvars(int n) { 
return  new BasicEList<org.polymodel.algebra.polynomials.PolynomialVariable>(n) ;
}
private static  EList<org.polymodel.algebra.polynomials.PolynomialVariable>  tom_cons_array_pvars(PolynomialVariable e,  EList<org.polymodel.algebra.polynomials.PolynomialVariable>  l) { 
return  append(e,l) ;
}
private static PolynomialVariable tom_get_element_pvars_pvars( EList<org.polymodel.algebra.polynomials.PolynomialVariable>  l, int n) {
return  l.get(n) ;
}
private static int tom_get_size_pvars_pvars( EList<org.polymodel.algebra.polynomials.PolynomialVariable>  l) {
return  l.size() ;
}

  private static   EList<org.polymodel.algebra.polynomials.PolynomialVariable>  tom_get_slice_pvars( EList<org.polymodel.algebra.polynomials.PolynomialVariable>  subject, int begin, int end) {
     EList<org.polymodel.algebra.polynomials.PolynomialVariable>  result =  new BasicEList<org.polymodel.algebra.polynomials.PolynomialVariable>(end-begin) ;
    while(begin!=end) {
      result =  append( subject.get(begin) ,result) ;
      begin++;
    }
    return result;
  }

  private static   EList<org.polymodel.algebra.polynomials.PolynomialVariable>  tom_append_array_pvars( EList<org.polymodel.algebra.polynomials.PolynomialVariable>  l2,  EList<org.polymodel.algebra.polynomials.PolynomialVariable>  l1) {
    int size1 =  l1.size() ;
    int size2 =  l2.size() ;
    int index;
     EList<org.polymodel.algebra.polynomials.PolynomialVariable>  result =  new BasicEList<org.polymodel.algebra.polynomials.PolynomialVariable>(size1+size2) ;
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
  }private static boolean tom_is_fun_sym_affine(IntExpression t) {
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
private static org.polymodel.algebra.IntTerm tom_make_term( long  _coef, org.polymodel.algebra.Variable _variable) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createTerm(_coef, _variable);
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
private static org.polymodel.algebra.IntTerm tom_make_constant( long  _coef) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createConstant(_coef);
}
private static  long  tom_get_slot_constant_coef(org.polymodel.algebra.IntTerm t) {
return ((org.polymodel.algebra.affine.AffineTerm)t).getCoef();
}
private static boolean tom_is_fun_sym_composite(IntExpression t) {
return t instanceof org.polymodel.algebra.CompositeIntExpression;
}
private static org.polymodel.algebra.CompositeOperator tom_get_slot_composite_operator(IntExpression t) {
return ((org.polymodel.algebra.CompositeIntExpression)t).getOperator();
}
private static IntExpression tom_get_slot_composite_left(IntExpression t) {
return ((org.polymodel.algebra.CompositeIntExpression)t).getLeft();
}
private static IntExpression tom_get_slot_composite_right(IntExpression t) {
return ((org.polymodel.algebra.CompositeIntExpression)t).getRight();
}
private static boolean tom_is_fun_sym_polynomial(IntExpression t) {
return t instanceof org.polymodel.algebra.polynomials.PolynomialExpression;
}
private static IntExpression tom_make_polynomial( EList<org.polymodel.algebra.polynomials.PolynomialTerm>  _terms) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createPolynomial(_terms);
}
private static  EList<org.polymodel.algebra.polynomials.PolynomialTerm>  tom_get_slot_polynomial_terms(IntExpression t) {
return enforce(((org.polymodel.algebra.polynomials.PolynomialExpression)t).getTerms());
}
private static boolean tom_is_fun_sym_pterm(org.polymodel.algebra.polynomials.PolynomialTerm t) {
return t instanceof org.polymodel.algebra.polynomials.PolynomialTerm;
}
private static org.polymodel.algebra.polynomials.PolynomialTerm tom_make_pterm( long  _numerator,  long  _denominator,  EList<org.polymodel.algebra.polynomials.PolynomialVariable>  _variables) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createPterm(_numerator, _denominator, _variables);
}
private static  long  tom_get_slot_pterm_numerator(org.polymodel.algebra.polynomials.PolynomialTerm t) {
return ((org.polymodel.algebra.polynomials.PolynomialTerm)t).getNumerator();
}
private static  long  tom_get_slot_pterm_denominator(org.polymodel.algebra.polynomials.PolynomialTerm t) {
return ((org.polymodel.algebra.polynomials.PolynomialTerm)t).getDenominator();
}
private static  EList<org.polymodel.algebra.polynomials.PolynomialVariable>  tom_get_slot_pterm_variables(org.polymodel.algebra.polynomials.PolynomialTerm t) {
return enforce(((org.polymodel.algebra.polynomials.PolynomialTerm)t).getVariables());
}
private static boolean tom_is_fun_sym_pvar(PolynomialVariable t) {
return t instanceof org.polymodel.algebra.polynomials.PolynomialVariable;
}
private static PolynomialVariable tom_make_pvar(org.polymodel.algebra.Variable _variable,  long  _exponent) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createPvar(_variable, _exponent);
}
private static org.polymodel.algebra.Variable tom_get_slot_pvar_variable(PolynomialVariable t) {
return ((org.polymodel.algebra.polynomials.PolynomialVariable)t).getVariable();
}
private static  long  tom_get_slot_pvar_exponent(PolynomialVariable t) {
return ((org.polymodel.algebra.polynomials.PolynomialVariable)t).getExponent();
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
private static org.polymodel.algebra.IntTerm tom_make_mul(IntExpression _expression,  long  _coef) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createMul(_expression, _coef);
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
private static org.polymodel.algebra.IntTerm tom_make_mod(IntExpression _expression,  long  _coef) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createMod(_expression, _coef);
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
private static org.polymodel.algebra.IntTerm tom_make_ceil(IntExpression _expression,  long  _coef) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createCeil(_expression, _coef);
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
private static org.polymodel.algebra.IntTerm tom_make_floor(IntExpression _expression,  long  _coef) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createFloor(_expression, _coef);
}
private static IntExpression tom_get_slot_floor_expression(org.polymodel.algebra.IntTerm t) {
return ((org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm)t).getExpression();
}
private static  long  tom_get_slot_floor_coef(org.polymodel.algebra.IntTerm t) {
return ((org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm)t).getCoef();
}
private static org.polymodel.algebra.IntTerm tom_make_div(IntExpression _expression,  long  _coef) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createDiv(_expression, _coef);
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
private static boolean tom_is_fun_sym_reduction(IntExpression t) {
return t instanceof org.polymodel.algebra.reductions.ReductionExpression;
}
private static  EList<org.polymodel.algebra.IntExpression>  tom_get_slot_reduction_expressions(IntExpression t) {
return enforce(((org.polymodel.algebra.reductions.ReductionExpression)t).getExpressions());
}
private static org.polymodel.algebra.reductions.ReductionOperator tom_get_slot_reduction_operator(IntExpression t) {
return ((org.polymodel.algebra.reductions.ReductionExpression)t).getOperator();
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


public static int Math_max(int a, int b) {
return Math.max(a,b);
}

public static long Math_max(long a, long b) {
return Math.max(a,b);
}  

public static int Math_min(int a, int b) {
return Math.min(a,b);
} 

public static long Math_min(long a, long b) {
return Math.min(a,b);
}

public static int Math_mod(int a, int b) {
return a%b;
} 

public static long Math_mod(long a, long b) {
return a%b;
}

public static int Math_mul(int a, int b) {
return a*b;
} 

public static int Math_floord(int a, int b) {
return a/b;
} 

public static int Math_ceild(int a, int b) { 
return (a+b-1)/b;
} 

public static IntExpression simplify(IntExpression expression) {
try {
if(VERBOSE) {  
System.out.println("*** Simplifying "+expression);
} 
IntExpression res = 
tom_make_Innermost(tom_make_Simplify()).visitLight(expression.copy(), tom.mapping.GenericIntrospector.INSTANCE);
if(VERBOSE) {
System.out.println("*** into "+res+"\n");
}
return res;  
} catch(Exception e) { 
System.err.println("Visitor failure on "+expression+ ":"+e.getMessage());
throw new RuntimeException("Visitor failure on "+expression+ ":"+e.getMessage(),e);
//e.printStackTrace(); 
}
} 


public static IntExpression debug(String name, IntExpression input, IntExpression output) {
if(VERBOSE) {
System.out.println("rule "+name+" :\n\t"+input+" -> "+output);
}
return output;
}
public static boolean VERBOSE=false;   
public static long ZERO=0;


public static class Simplify extends tom.library.sl.AbstractStrategyBasic {
public Simplify() {
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
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1=tom_get_slot_affine_terms(((IntExpression)tom__arg));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1))) {
if (0 >= tom_get_size_terms_terms(tomMatch1_1)) {

return debug("R-1",
((IntExpression)tom__arg),
tom_make_affine(tom_cons_array_terms(tom_make_constant(0),tom_empty_array_terms(1)))); 
}
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_affine(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_7=tom_get_slot_affine_terms(((IntExpression)tom__arg));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_7))) {
int tomMatch1_11=0;
int tomMatch1_end_14=tomMatch1_11;
do {
{
if (!(tomMatch1_end_14 >= tom_get_size_terms_terms(tomMatch1_7))) {
org.polymodel.algebra.IntTerm tomMatch1_22=tom_get_element_terms_terms(tomMatch1_7,tomMatch1_end_14);
if (tom_is_sort_T(tomMatch1_22)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_22))) {
int tomMatch1_15=tomMatch1_end_14 + 1;
int tomMatch1_end_18=tomMatch1_15;
do {
{
if (!(tomMatch1_end_18 >= tom_get_size_terms_terms(tomMatch1_7))) {
org.polymodel.algebra.IntTerm tomMatch1_25=tom_get_element_terms_terms(tomMatch1_7,tomMatch1_end_18);
if (tom_is_sort_T(tomMatch1_25)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_25))) {

return debug("R0",
((IntExpression)tom__arg),
tom_make_affine(tom_cons_array_terms(tom_make_constant(tom_get_slot_constant_coef(tomMatch1_22)+tom_get_slot_constant_coef(tomMatch1_25)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_7,tomMatch1_end_18 + 1,tom_get_size_terms_terms(tomMatch1_7)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_7,tomMatch1_15,tomMatch1_end_18),tom_append_array_terms(tom_get_slice_terms(tomMatch1_7,tomMatch1_11,tomMatch1_end_14),tom_empty_array_terms(4))))))); 

}
}
}
tomMatch1_end_18=tomMatch1_end_18 + 1;
}
} while(!(tomMatch1_end_18 > tom_get_size_terms_terms(tomMatch1_7)));
}
}
}
tomMatch1_end_14=tomMatch1_end_14 + 1;
}
} while(!(tomMatch1_end_14 > tom_get_size_terms_terms(tomMatch1_7)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_affine(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_28=tom_get_slot_affine_terms(((IntExpression)tom__arg));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_28))) {
int tomMatch1_32=0;
if (!(tomMatch1_32 >= tom_get_size_terms_terms(tomMatch1_28))) {
int tomMatch1_33=tomMatch1_32 + 1;
if (!(tomMatch1_33 >= tom_get_size_terms_terms(tomMatch1_28))) {
org.polymodel.algebra.IntTerm tomMatch1_37=tom_get_element_terms_terms(tomMatch1_28,tomMatch1_33);
if (tom_is_sort_T(tomMatch1_37)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_37))) {
 long  tomMatch1_36=tom_get_slot_constant_coef(tomMatch1_37);
if ( true ) {
if (tom_equal_term_long(0L, tomMatch1_36)) {
return debug("R1a",
((IntExpression)tom__arg),
tom_make_affine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_28,tomMatch1_33 + 1,tom_get_size_terms_terms(tomMatch1_28)),tom_cons_array_terms(tom_get_element_terms_terms(tomMatch1_28,tomMatch1_32),tom_empty_array_terms(2))))); 
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
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_affine(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_42=tom_get_slot_affine_terms(((IntExpression)tom__arg));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_42))) {
int tomMatch1_46=0;
int tomMatch1_end_49=tomMatch1_46;
do {
{
if (!(tomMatch1_end_49 >= tom_get_size_terms_terms(tomMatch1_42))) {
org.polymodel.algebra.IntTerm tomMatch1_53=tom_get_element_terms_terms(tomMatch1_42,tomMatch1_end_49);
if (tom_is_sort_T(tomMatch1_53)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_53))) {
 long  tomMatch1_52=tom_get_slot_constant_coef(tomMatch1_53);
if ( true ) {
if (tom_equal_term_long(0L, tomMatch1_52)) {
int tomMatch1_50=tomMatch1_end_49 + 1;
if (!(tomMatch1_50 >= tom_get_size_terms_terms(tomMatch1_42))) {
if (tomMatch1_50 + 1 >= tom_get_size_terms_terms(tomMatch1_42)) {
return debug("R1b",
((IntExpression)tom__arg),
tom_make_affine(tom_cons_array_terms(tom_get_element_terms_terms(tomMatch1_42,tomMatch1_50),tom_append_array_terms(tom_get_slice_terms(tomMatch1_42,tomMatch1_46,tomMatch1_end_49),tom_empty_array_terms(2))))); 
}
}
}
}
}
}
}
tomMatch1_end_49=tomMatch1_end_49 + 1;
}
} while(!(tomMatch1_end_49 > tom_get_size_terms_terms(tomMatch1_42)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_affine(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_58=tom_get_slot_affine_terms(((IntExpression)tom__arg));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_58))) {
int tomMatch1_62=0;
if (!(tomMatch1_62 >= tom_get_size_terms_terms(tomMatch1_58))) {
int tomMatch1_63=tomMatch1_62 + 1;
if (!(tomMatch1_63 >= tom_get_size_terms_terms(tomMatch1_58))) {
org.polymodel.algebra.IntTerm tomMatch1_68=tom_get_element_terms_terms(tomMatch1_58,tomMatch1_63);
if (tom_is_sort_T(tomMatch1_68)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_68))) {
 long  tomMatch1_66=tom_get_slot_term_coef(tomMatch1_68);
if ( true ) {
if (tom_equal_term_long(0L, tomMatch1_66)) {
return debug("R2a",
((IntExpression)tom__arg),
tom_make_affine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_58,tomMatch1_63 + 1,tom_get_size_terms_terms(tomMatch1_58)),tom_cons_array_terms(tom_get_element_terms_terms(tomMatch1_58,tomMatch1_62),tom_empty_array_terms(2))))); 
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
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_affine(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_73=tom_get_slot_affine_terms(((IntExpression)tom__arg));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_73))) {
int tomMatch1_77=0;
int tomMatch1_end_80=tomMatch1_77;
do {
{
if (!(tomMatch1_end_80 >= tom_get_size_terms_terms(tomMatch1_73))) {
org.polymodel.algebra.IntTerm tomMatch1_85=tom_get_element_terms_terms(tomMatch1_73,tomMatch1_end_80);
if (tom_is_sort_T(tomMatch1_85)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_85))) {
 long  tomMatch1_83=tom_get_slot_term_coef(tomMatch1_85);
if ( true ) {
if (tom_equal_term_long(0L, tomMatch1_83)) {
int tomMatch1_81=tomMatch1_end_80 + 1;
if (!(tomMatch1_81 >= tom_get_size_terms_terms(tomMatch1_73))) {
if (tomMatch1_81 + 1 >= tom_get_size_terms_terms(tomMatch1_73)) {
return debug("R2b",
((IntExpression)tom__arg),
tom_make_affine(tom_cons_array_terms(tom_get_element_terms_terms(tomMatch1_73,tomMatch1_81),tom_append_array_terms(tom_get_slice_terms(tomMatch1_73,tomMatch1_77,tomMatch1_end_80),tom_empty_array_terms(2))))); 
}
}
}
}
}
}
}
tomMatch1_end_80=tomMatch1_end_80 + 1;
}
} while(!(tomMatch1_end_80 > tom_get_size_terms_terms(tomMatch1_73)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_affine(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_90=tom_get_slot_affine_terms(((IntExpression)tom__arg));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_90))) {
int tomMatch1_94=0;
int tomMatch1_end_97=tomMatch1_94;
do {
{
 EList<org.polymodel.algebra.IntTerm>  tom_x1=tom_get_slice_terms(tomMatch1_90,tomMatch1_94,tomMatch1_end_97);
if (!(tomMatch1_end_97 >= tom_get_size_terms_terms(tomMatch1_90))) {
org.polymodel.algebra.IntTerm tomMatch1_106=tom_get_element_terms_terms(tomMatch1_90,tomMatch1_end_97);
if (tom_is_sort_T(tomMatch1_106)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_106))) {
 long  tom_a=tom_get_slot_term_coef(tomMatch1_106);
org.polymodel.algebra.Variable tom_v=tom_get_slot_term_variable(tomMatch1_106);
int tomMatch1_98=tomMatch1_end_97 + 1;
int tomMatch1_end_101=tomMatch1_98;
do {
{
 EList<org.polymodel.algebra.IntTerm>  tom_x2=tom_get_slice_terms(tomMatch1_90,tomMatch1_98,tomMatch1_end_101);
if (!(tomMatch1_end_101 >= tom_get_size_terms_terms(tomMatch1_90))) {
org.polymodel.algebra.IntTerm tomMatch1_110=tom_get_element_terms_terms(tomMatch1_90,tomMatch1_end_101);
if (tom_is_sort_T(tomMatch1_110)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_110))) {
 long  tom_b=tom_get_slot_term_coef(tomMatch1_110);
if (tom_equal_term_V(tom_v, tom_get_slot_term_variable(tomMatch1_110))) {
 EList<org.polymodel.algebra.IntTerm>  tom_x3=tom_get_slice_terms(tomMatch1_90,tomMatch1_end_101 + 1,tom_get_size_terms_terms(tomMatch1_90));
IntExpression tom_in=((IntExpression)tom__arg);

long d=(
tom_a)+(
tom_b);
if(d!=0) {
return debug("R3",
tom_in,
tom_make_affine(tom_append_array_terms(tom_x3,tom_append_array_terms(tom_x2,tom_append_array_terms(tom_x1,tom_cons_array_terms(tom_make_term(tom_a+tom_b,tom_v),tom_empty_array_terms(4)))))));
} else {
return debug("R3",
tom_in,
tom_make_affine(tom_append_array_terms(tom_x3,tom_append_array_terms(tom_x2,tom_append_array_terms(tom_x1,tom_empty_array_terms(3))))));
}

}
}
}
}
tomMatch1_end_101=tomMatch1_end_101 + 1;
}
} while(!(tomMatch1_end_101 > tom_get_size_terms_terms(tomMatch1_90)));
}
}
}
tomMatch1_end_97=tomMatch1_end_97 + 1;
}
} while(!(tomMatch1_end_97 > tom_get_size_terms_terms(tomMatch1_90)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_sum(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_114=tom_get_slot_sum_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_114))) {
int tomMatch1_118=0;
int tomMatch1_end_121=tomMatch1_118;
do {
{
if (!(tomMatch1_end_121 >= tom_get_size_EL_EL(tomMatch1_114))) {
IntExpression tomMatch1_129=tom_get_element_EL_EL(tomMatch1_114,tomMatch1_end_121);
if (tom_is_sort_E(tomMatch1_129)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_129))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_128=tom_get_slot_affine_terms(tomMatch1_129);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_128))) {
int tomMatch1_122=tomMatch1_end_121 + 1;
int tomMatch1_end_125=tomMatch1_122;
do {
{
if (!(tomMatch1_end_125 >= tom_get_size_EL_EL(tomMatch1_114))) {
IntExpression tomMatch1_132=tom_get_element_EL_EL(tomMatch1_114,tomMatch1_end_125);
if (tom_is_sort_E(tomMatch1_132)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_132))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_131=tom_get_slot_affine_terms(tomMatch1_132);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_131))) {
return debug("R4",
((IntExpression)tom__arg),
tom_make_sum(tom_append_array_EL(tom_get_slice_EL(tomMatch1_114,tomMatch1_end_125 + 1,tom_get_size_EL_EL(tomMatch1_114)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_114,tomMatch1_122,tomMatch1_end_125),tom_append_array_EL(tom_get_slice_EL(tomMatch1_114,tomMatch1_118,tomMatch1_end_121),tom_cons_array_EL(tom_make_affine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_131,0,tom_get_size_terms_terms(tomMatch1_131)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_128,0,tom_get_size_terms_terms(tomMatch1_128)),tom_empty_array_terms(2)))),tom_empty_array_EL(4))))))); 
}
}
}
}
tomMatch1_end_125=tomMatch1_end_125 + 1;
}
} while(!(tomMatch1_end_125 > tom_get_size_EL_EL(tomMatch1_114)));
}
}
}
}
tomMatch1_end_121=tomMatch1_end_121 + 1;
}
} while(!(tomMatch1_end_121 > tom_get_size_EL_EL(tomMatch1_114)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_sum(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_141=tom_get_slot_sum_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_141))) {
int tomMatch1_145=0;
int tomMatch1_end_148=tomMatch1_145;
do {
{
if (!(tomMatch1_end_148 >= tom_get_size_EL_EL(tomMatch1_141))) {
IntExpression tomMatch1_152=tom_get_element_EL_EL(tomMatch1_141,tomMatch1_end_148);
if (tom_is_sort_E(tomMatch1_152)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_152))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_151=tom_get_slot_affine_terms(tomMatch1_152);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_151))) {
if (0 >= tom_get_size_terms_terms(tomMatch1_151)) {
return debug("R5",
((IntExpression)tom__arg),
tom_make_sum(tom_append_array_EL(tom_get_slice_EL(tomMatch1_141,tomMatch1_end_148 + 1,tom_get_size_EL_EL(tomMatch1_141)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_141,tomMatch1_145,tomMatch1_end_148),tom_empty_array_EL(2))))); 
}
}
}
}
}
tomMatch1_end_148=tomMatch1_end_148 + 1;
}
} while(!(tomMatch1_end_148 > tom_get_size_EL_EL(tomMatch1_141)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_sum(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_157=tom_get_slot_sum_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_157))) {
if (0 >= tom_get_size_EL_EL(tomMatch1_157)) {
return debug("R6",
((IntExpression)tom__arg),
tom_make_affine(tom_cons_array_terms(tom_make_constant(0L),tom_empty_array_terms(1)))); 
}
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_sum(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_163=tom_get_slot_sum_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_163))) {
int tomMatch1_167=0;
if (!(tomMatch1_167 >= tom_get_size_EL_EL(tomMatch1_163))) {
if (tomMatch1_167 + 1 >= tom_get_size_EL_EL(tomMatch1_163)) {
return debug("R7",
((IntExpression)tom__arg),
tom_get_element_EL_EL(tomMatch1_163,tomMatch1_167)); 
}
}
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_sum(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_170=tom_get_slot_sum_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_170))) {
int tomMatch1_174=0;
int tomMatch1_end_177=tomMatch1_174;
do {
{
if (!(tomMatch1_end_177 >= tom_get_size_EL_EL(tomMatch1_170))) {
IntExpression tomMatch1_181=tom_get_element_EL_EL(tomMatch1_170,tomMatch1_end_177);
if (tom_is_sort_E(tomMatch1_181)) {
if (tom_is_fun_sym_sum(((IntExpression)tomMatch1_181))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_180=tom_get_slot_sum_expressions(tomMatch1_181);
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_180))) {
return debug("R8",
((IntExpression)tom__arg),
tom_make_sum(tom_append_array_EL(tom_get_slice_EL(tomMatch1_170,tomMatch1_end_177 + 1,tom_get_size_EL_EL(tomMatch1_170)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_180,0,tom_get_size_EL_EL(tomMatch1_180)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_170,tomMatch1_174,tomMatch1_end_177),tom_empty_array_EL(3)))))); 
}
}
}
}
tomMatch1_end_177=tomMatch1_end_177 + 1;
}
} while(!(tomMatch1_end_177 > tom_get_size_EL_EL(tomMatch1_170)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_sum(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_187=tom_get_slot_sum_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_187))) {
int tomMatch1_191=0;
int tomMatch1_end_194=tomMatch1_191;
do {
{
if (!(tomMatch1_end_194 >= tom_get_size_EL_EL(tomMatch1_187))) {
IntExpression tomMatch1_202=tom_get_element_EL_EL(tomMatch1_187,tomMatch1_end_194);
if (tom_is_sort_E(tomMatch1_202)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_202))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_201=tom_get_slot_affine_terms(tomMatch1_202);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_201))) {
int tomMatch1_195=tomMatch1_end_194 + 1;
int tomMatch1_end_198=tomMatch1_195;
do {
{
if (!(tomMatch1_end_198 >= tom_get_size_EL_EL(tomMatch1_187))) {
IntExpression tomMatch1_205=tom_get_element_EL_EL(tomMatch1_187,tomMatch1_end_198);
if (tom_is_sort_E(tomMatch1_205)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_205))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_204=tom_get_slot_affine_terms(tomMatch1_205);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_204))) {
return debug("R20",
((IntExpression)tom__arg),
tom_make_sum(tom_cons_array_EL(tom_make_affine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_204,0,tom_get_size_terms_terms(tomMatch1_204)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_201,0,tom_get_size_terms_terms(tomMatch1_201)),tom_empty_array_terms(2)))),tom_append_array_EL(tom_get_slice_EL(tomMatch1_187,tomMatch1_end_198 + 1,tom_get_size_EL_EL(tomMatch1_187)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_187,tomMatch1_195,tomMatch1_end_198),tom_append_array_EL(tom_get_slice_EL(tomMatch1_187,tomMatch1_191,tomMatch1_end_194),tom_empty_array_EL(4))))))); 
}
}
}
}
tomMatch1_end_198=tomMatch1_end_198 + 1;
}
} while(!(tomMatch1_end_198 > tom_get_size_EL_EL(tomMatch1_187)));
}
}
}
}
tomMatch1_end_194=tomMatch1_end_194 + 1;
}
} while(!(tomMatch1_end_194 > tom_get_size_EL_EL(tomMatch1_187)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_sum(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_214=tom_get_slot_sum_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_214))) {
int tomMatch1_218=0;
int tomMatch1_end_221=tomMatch1_218;
do {
{
if (!(tomMatch1_end_221 >= tom_get_size_EL_EL(tomMatch1_214))) {
IntExpression tomMatch1_229=tom_get_element_EL_EL(tomMatch1_214,tomMatch1_end_221);
if (tom_is_sort_E(tomMatch1_229)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_229))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_228=tom_get_slot_qaffine_terms(tomMatch1_229);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_228))) {
int tomMatch1_222=tomMatch1_end_221 + 1;
int tomMatch1_end_225=tomMatch1_222;
do {
{
if (!(tomMatch1_end_225 >= tom_get_size_EL_EL(tomMatch1_214))) {
IntExpression tomMatch1_232=tom_get_element_EL_EL(tomMatch1_214,tomMatch1_end_225);
if (tom_is_sort_E(tomMatch1_232)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_232))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_231=tom_get_slot_qaffine_terms(tomMatch1_232);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_231))) {
return debug("R21",
((IntExpression)tom__arg),
tom_make_sum(tom_cons_array_EL(tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_231,0,tom_get_size_terms_terms(tomMatch1_231)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_228,0,tom_get_size_terms_terms(tomMatch1_228)),tom_empty_array_terms(2)))),tom_append_array_EL(tom_get_slice_EL(tomMatch1_214,tomMatch1_end_225 + 1,tom_get_size_EL_EL(tomMatch1_214)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_214,tomMatch1_222,tomMatch1_end_225),tom_append_array_EL(tom_get_slice_EL(tomMatch1_214,tomMatch1_218,tomMatch1_end_221),tom_empty_array_EL(4))))))); 
}
}
}
}
tomMatch1_end_225=tomMatch1_end_225 + 1;
}
} while(!(tomMatch1_end_225 > tom_get_size_EL_EL(tomMatch1_214)));
}
}
}
}
tomMatch1_end_221=tomMatch1_end_221 + 1;
}
} while(!(tomMatch1_end_221 > tom_get_size_EL_EL(tomMatch1_214)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_composite(((IntExpression)((IntExpression)tom__arg)))) {
IntExpression tomMatch1_242=tom_get_slot_composite_left(((IntExpression)tom__arg));
IntExpression tomMatch1_243=tom_get_slot_composite_right(((IntExpression)tom__arg));
if (tom_is_sort_E(tomMatch1_242)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_242))) {
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tom_get_slot_affine_terms(tomMatch1_242)))) {
IntExpression tom_a=tomMatch1_242;
if (tom_is_sort_E(tomMatch1_243)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_243))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_249=tom_get_slot_affine_terms(tomMatch1_243);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_249))) {
int tomMatch1_256=0;
if (!(tomMatch1_256 >= tom_get_size_terms_terms(tomMatch1_249))) {
org.polymodel.algebra.IntTerm tomMatch1_259=tom_get_element_terms_terms(tomMatch1_249,tomMatch1_256);
if (tom_is_sort_T(tomMatch1_259)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_259))) {
 long  tom_c=tom_get_slot_constant_coef(tomMatch1_259);
if (tomMatch1_256 + 1 >= tom_get_size_terms_terms(tomMatch1_249)) {
IntExpression tom_in=((IntExpression)tom__arg);

System.out.println("composite Unhandled operator in : " + 
tom_in);
switch(((CompositeOperator)
tom_get_slot_composite_operator(((IntExpression)tom__arg)))) {
case MOD:
{ 
IntExpression s = simplify(
tom_make_qaffine(tom_cons_array_terms(tom_make_mod(tom_a,tom_c),tom_empty_array_terms(1))));
return debug("R82",
tom_in,s); 
} 
case DIV:
{ return debug("R83",
tom_in,simplify(
tom_make_qaffine(tom_cons_array_terms(tom_make_div(tom_a,tom_c),tom_empty_array_terms(1))))); }
//					case CEIL:
//						return debug("R84",`in,simplify(`qaffine(terms(ceil(a,c))))); }
case FLOOR:
{ return debug("R85",
tom_in,simplify(
tom_make_qaffine(tom_cons_array_terms(tom_make_floor(tom_a,tom_c),tom_empty_array_terms(1))))); }
default:
throw new RuntimeException("Unhandled operator in : " + 
tom_in);
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
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_composite(((IntExpression)((IntExpression)tom__arg)))) {
IntExpression tomMatch1_263=tom_get_slot_composite_left(((IntExpression)tom__arg));
if (tom_is_sort_E(tomMatch1_263)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_263))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_267=tom_get_slot_affine_terms(tomMatch1_263);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_267))) {
int tomMatch1_271=0;
if (!(tomMatch1_271 >= tom_get_size_terms_terms(tomMatch1_267))) {
org.polymodel.algebra.IntTerm tomMatch1_274=tom_get_element_terms_terms(tomMatch1_267,tomMatch1_271);
if (tom_is_sort_T(tomMatch1_274)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_274))) {
 long  tomMatch1_273=tom_get_slot_constant_coef(tomMatch1_274);
if ( true ) {
if (tom_equal_term_long(0L, tomMatch1_273)) {
if (tomMatch1_271 + 1 >= tom_get_size_terms_terms(tomMatch1_267)) {

return debug("R91",
((IntExpression)tom__arg),
tom_make_affine(tom_cons_array_terms(tom_make_constant(0L),tom_empty_array_terms(1)))); 

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
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_qaffine(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_279=tom_get_slot_qaffine_terms(((IntExpression)tom__arg));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_279))) {
int tomMatch1_283=0;
if (!(tomMatch1_283 >= tom_get_size_terms_terms(tomMatch1_279))) {
org.polymodel.algebra.IntTerm tomMatch1_287=tom_get_element_terms_terms(tomMatch1_279,tomMatch1_283);
boolean tomMatch1_306= false ;
IntExpression tomMatch1_285= null ;
org.polymodel.algebra.IntTerm tomMatch1_289= null ;
org.polymodel.algebra.IntTerm tomMatch1_290= null ;
org.polymodel.algebra.IntTerm tomMatch1_288= null ;
org.polymodel.algebra.IntTerm tomMatch1_292= null ;
org.polymodel.algebra.IntTerm tomMatch1_291= null ;
 long  tomMatch1_286= 0 ;
if (tom_is_sort_T(tomMatch1_287)) {
if (tom_is_fun_sym_nceil(((org.polymodel.algebra.IntTerm)tomMatch1_287))) {
{
tomMatch1_306= true ;
tomMatch1_288=tomMatch1_287;
tomMatch1_285=tom_get_slot_nceil_expression(tomMatch1_288);
tomMatch1_286=tom_get_slot_nceil_coef(tomMatch1_288);
}
} else {
if (tom_is_sort_T(tomMatch1_287)) {
if (tom_is_fun_sym_ndiv(((org.polymodel.algebra.IntTerm)tomMatch1_287))) {
{
tomMatch1_306= true ;
tomMatch1_289=tomMatch1_287;
tomMatch1_285=tom_get_slot_ndiv_expression(tomMatch1_289);
tomMatch1_286=tom_get_slot_ndiv_coef(tomMatch1_289);
}
} else {
if (tom_is_sort_T(tomMatch1_287)) {
if (tom_is_fun_sym_nfloor(((org.polymodel.algebra.IntTerm)tomMatch1_287))) {
{
tomMatch1_306= true ;
tomMatch1_290=tomMatch1_287;
tomMatch1_285=tom_get_slot_nfloor_expression(tomMatch1_290);
tomMatch1_286=tom_get_slot_nfloor_coef(tomMatch1_290);
}
} else {
if (tom_is_sort_T(tomMatch1_287)) {
if (tom_is_fun_sym_mod(((org.polymodel.algebra.IntTerm)tomMatch1_287))) {
{
tomMatch1_306= true ;
tomMatch1_291=tomMatch1_287;
tomMatch1_285=tom_get_slot_mod_expression(tomMatch1_291);
tomMatch1_286=tom_get_slot_mod_coef(tomMatch1_291);
}
} else {
if (tom_is_sort_T(tomMatch1_287)) {
if (tom_is_fun_sym_nmul(((org.polymodel.algebra.IntTerm)tomMatch1_287))) {
{
tomMatch1_306= true ;
tomMatch1_292=tomMatch1_287;
tomMatch1_285=tom_get_slot_nmul_expression(tomMatch1_292);
tomMatch1_286=tom_get_slot_nmul_coef(tomMatch1_292);
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
if (tomMatch1_306) {
if (tom_is_sort_E(tomMatch1_285)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_285))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_293=tom_get_slot_qaffine_terms(tomMatch1_285);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_293))) {
int tomMatch1_297=0;
if (!(tomMatch1_297 >= tom_get_size_terms_terms(tomMatch1_293))) {
org.polymodel.algebra.IntTerm tomMatch1_301=tom_get_element_terms_terms(tomMatch1_293,tomMatch1_297);
if (tom_is_sort_T(tomMatch1_301)) {
if (tom_is_fun_sym_mul(((org.polymodel.algebra.IntTerm)tomMatch1_301))) {
IntExpression tomMatch1_299=tom_get_slot_mul_expression(tomMatch1_301);
if (tom_is_sort_E(tomMatch1_299)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_299))) {
IntExpression tom_aff=tomMatch1_299;
 long  tom_a=tom_get_slot_mul_coef(tomMatch1_301);
if (tomMatch1_297 + 1 >= tom_get_size_terms_terms(tomMatch1_293)) {
 long  tom_b=tomMatch1_286;
if (tomMatch1_283 + 1 >= tom_get_size_terms_terms(tomMatch1_279)) {
IntExpression tom_in=((IntExpression)tom__arg);

switch(((QuasiAffineTerm)
tom_get_element_terms_terms(tomMatch1_279,tomMatch1_283)).getOperator()) {
case CEIL:
return debug("R13",
tom_in,
tom_make_qaffine(tom_cons_array_terms(tom_make_ceil(ArithmeticOperations.scale((AffineExpression)tom_aff,tom_a),tom_b),tom_empty_array_terms(1))));
case DIV:
return debug("R13",
tom_in,
tom_make_qaffine(tom_cons_array_terms(tom_make_div(ArithmeticOperations.scale((AffineExpression)tom_aff,tom_a),tom_b),tom_empty_array_terms(1))));
case FLOOR:
return debug("R13",
tom_in,
tom_make_qaffine(tom_cons_array_terms(tom_make_floor(ArithmeticOperations.scale((AffineExpression)tom_aff,tom_a),tom_b),tom_empty_array_terms(1))));
case MOD:
return debug("R13",
tom_in,
tom_make_qaffine(tom_cons_array_terms(tom_make_mod(ArithmeticOperations.scale((AffineExpression)tom_aff,tom_a),tom_b),tom_empty_array_terms(1))));
case MUL:
return debug("R13",
tom_in,
tom_make_qaffine(tom_cons_array_terms(tom_make_mul(ArithmeticOperations.scale((AffineExpression)tom_aff,tom_a),tom_b),tom_empty_array_terms(1))));
default:
throw new RuntimeException("Unhandled operator in : " + 
tom_in);
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
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_qaffine(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_308=tom_get_slot_qaffine_terms(((IntExpression)tom__arg));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_308))) {
int tomMatch1_312=0;
if (!(tomMatch1_312 >= tom_get_size_terms_terms(tomMatch1_308))) {
org.polymodel.algebra.IntTerm tomMatch1_316=tom_get_element_terms_terms(tomMatch1_308,tomMatch1_312);
if (tom_is_sort_T(tomMatch1_316)) {
if (tom_is_fun_sym_mul(((org.polymodel.algebra.IntTerm)tomMatch1_316))) {
IntExpression tomMatch1_314=tom_get_slot_mul_expression(tomMatch1_316);
 long  tomMatch1_315=tom_get_slot_mul_coef(tomMatch1_316);
if (tom_is_sort_E(tomMatch1_314)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_314))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_318=tom_get_slot_qaffine_terms(tomMatch1_314);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_318))) {
if ( true ) {
if (tom_equal_term_long(1L, tomMatch1_315)) {
if (tomMatch1_312 + 1 >= tom_get_size_terms_terms(tomMatch1_308)) {

return debug("R13'",
((IntExpression)tom__arg),
tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_318,0,tom_get_size_terms_terms(tomMatch1_318)),tom_empty_array_terms(1)))); 
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
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_qaffine(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_327=tom_get_slot_qaffine_terms(((IntExpression)tom__arg));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_327))) {
int tomMatch1_331=0;
if (!(tomMatch1_331 >= tom_get_size_terms_terms(tomMatch1_327))) {
org.polymodel.algebra.IntTerm tomMatch1_335=tom_get_element_terms_terms(tomMatch1_327,tomMatch1_331);
if (tom_is_sort_T(tomMatch1_335)) {
if (tom_is_fun_sym_nmul(((org.polymodel.algebra.IntTerm)tomMatch1_335))) {
IntExpression tomMatch1_333=tom_get_slot_nmul_expression(tomMatch1_335);
 long  tomMatch1_334=tom_get_slot_nmul_coef(tomMatch1_335);
if (tom_is_sort_E(tomMatch1_333)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_333))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_337=tom_get_slot_qaffine_terms(tomMatch1_333);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_337))) {
if ( true ) {
if (tom_equal_term_long(1L, tomMatch1_334)) {
if (tomMatch1_331 + 1 >= tom_get_size_terms_terms(tomMatch1_327)) {

return debug("R13'",
((IntExpression)tom__arg),
tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_337,0,tom_get_size_terms_terms(tomMatch1_337)),tom_empty_array_terms(1)))); 
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
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_sum(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_346=tom_get_slot_sum_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_346))) {
int tomMatch1_350=0;
int tomMatch1_end_353=tomMatch1_350;
do {
{
if (!(tomMatch1_end_353 >= tom_get_size_EL_EL(tomMatch1_346))) {
IntExpression tomMatch1_357=tom_get_element_EL_EL(tomMatch1_346,tomMatch1_end_353);
if (tom_is_sort_E(tomMatch1_357)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_357))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_356=tom_get_slot_qaffine_terms(tomMatch1_357);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_356))) {
int tomMatch1_360=0;
if (!(tomMatch1_360 >= tom_get_size_terms_terms(tomMatch1_356))) {
org.polymodel.algebra.IntTerm tomMatch1_364=tom_get_element_terms_terms(tomMatch1_356,tomMatch1_360);
if (tom_is_sort_T(tomMatch1_364)) {
if (tom_is_fun_sym_mul(((org.polymodel.algebra.IntTerm)tomMatch1_364))) {
IntExpression tomMatch1_362=tom_get_slot_mul_expression(tomMatch1_364);
if (tom_is_sort_E(tomMatch1_362)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_362))) {
if (tomMatch1_360 + 1 >= tom_get_size_terms_terms(tomMatch1_356)) {

return debug("R13",
((IntExpression)tom__arg),
tom_make_sum(tom_append_array_EL(tom_get_slice_EL(tomMatch1_346,tomMatch1_end_353 + 1,tom_get_size_EL_EL(tomMatch1_346)),tom_cons_array_EL(ArithmeticOperations.scale((AffineExpression)tomMatch1_362,tom_get_slot_mul_coef(tomMatch1_364)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_346,tomMatch1_350,tomMatch1_end_353),tom_empty_array_EL(3)))))); 
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
tomMatch1_end_353=tomMatch1_end_353 + 1;
}
} while(!(tomMatch1_end_353 > tom_get_size_EL_EL(tomMatch1_346)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_prod(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_370=tom_get_slot_prod_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_370))) {
int tomMatch1_374=0;
int tomMatch1_end_377=tomMatch1_374;
do {
{
if (!(tomMatch1_end_377 >= tom_get_size_EL_EL(tomMatch1_370))) {
IntExpression tomMatch1_381=tom_get_element_EL_EL(tomMatch1_370,tomMatch1_end_377);
if (tom_is_sort_E(tomMatch1_381)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_381))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_380=tom_get_slot_qaffine_terms(tomMatch1_381);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_380))) {
int tomMatch1_384=0;
if (!(tomMatch1_384 >= tom_get_size_terms_terms(tomMatch1_380))) {
org.polymodel.algebra.IntTerm tomMatch1_388=tom_get_element_terms_terms(tomMatch1_380,tomMatch1_384);
if (tom_is_sort_T(tomMatch1_388)) {
if (tom_is_fun_sym_mul(((org.polymodel.algebra.IntTerm)tomMatch1_388))) {
IntExpression tomMatch1_386=tom_get_slot_mul_expression(tomMatch1_388);
if (tom_is_sort_E(tomMatch1_386)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_386))) {
if (tomMatch1_384 + 1 >= tom_get_size_terms_terms(tomMatch1_380)) {

return debug("R13",
((IntExpression)tom__arg),
tom_make_prod(tom_append_array_EL(tom_get_slice_EL(tomMatch1_370,tomMatch1_end_377 + 1,tom_get_size_EL_EL(tomMatch1_370)),tom_cons_array_EL(ArithmeticOperations.scale((AffineExpression)tomMatch1_386,tom_get_slot_mul_coef(tomMatch1_388)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_370,tomMatch1_374,tomMatch1_end_377),tom_empty_array_EL(3)))))); 
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
tomMatch1_end_377=tomMatch1_end_377 + 1;
}
} while(!(tomMatch1_end_377 > tom_get_size_EL_EL(tomMatch1_370)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_max(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_394=tom_get_slot_max_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_394))) {
int tomMatch1_398=0;
int tomMatch1_end_401=tomMatch1_398;
do {
{
if (!(tomMatch1_end_401 >= tom_get_size_EL_EL(tomMatch1_394))) {
IntExpression tomMatch1_405=tom_get_element_EL_EL(tomMatch1_394,tomMatch1_end_401);
if (tom_is_sort_E(tomMatch1_405)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_405))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_404=tom_get_slot_qaffine_terms(tomMatch1_405);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_404))) {
int tomMatch1_408=0;
if (!(tomMatch1_408 >= tom_get_size_terms_terms(tomMatch1_404))) {
org.polymodel.algebra.IntTerm tomMatch1_412=tom_get_element_terms_terms(tomMatch1_404,tomMatch1_408);
if (tom_is_sort_T(tomMatch1_412)) {
if (tom_is_fun_sym_mul(((org.polymodel.algebra.IntTerm)tomMatch1_412))) {
IntExpression tomMatch1_410=tom_get_slot_mul_expression(tomMatch1_412);
if (tom_is_sort_E(tomMatch1_410)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_410))) {
if (tomMatch1_408 + 1 >= tom_get_size_terms_terms(tomMatch1_404)) {

return debug("R13",
((IntExpression)tom__arg),
tom_make_max(tom_append_array_EL(tom_get_slice_EL(tomMatch1_394,tomMatch1_end_401 + 1,tom_get_size_EL_EL(tomMatch1_394)),tom_cons_array_EL(ArithmeticOperations.scale((AffineExpression)tomMatch1_410,tom_get_slot_mul_coef(tomMatch1_412)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_394,tomMatch1_398,tomMatch1_end_401),tom_empty_array_EL(3)))))); 
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
tomMatch1_end_401=tomMatch1_end_401 + 1;
}
} while(!(tomMatch1_end_401 > tom_get_size_EL_EL(tomMatch1_394)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_min(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_418=tom_get_slot_min_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_418))) {
int tomMatch1_422=0;
int tomMatch1_end_425=tomMatch1_422;
do {
{
if (!(tomMatch1_end_425 >= tom_get_size_EL_EL(tomMatch1_418))) {
IntExpression tomMatch1_429=tom_get_element_EL_EL(tomMatch1_418,tomMatch1_end_425);
if (tom_is_sort_E(tomMatch1_429)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_429))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_428=tom_get_slot_qaffine_terms(tomMatch1_429);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_428))) {
int tomMatch1_432=0;
if (!(tomMatch1_432 >= tom_get_size_terms_terms(tomMatch1_428))) {
org.polymodel.algebra.IntTerm tomMatch1_436=tom_get_element_terms_terms(tomMatch1_428,tomMatch1_432);
if (tom_is_sort_T(tomMatch1_436)) {
if (tom_is_fun_sym_mul(((org.polymodel.algebra.IntTerm)tomMatch1_436))) {
IntExpression tomMatch1_434=tom_get_slot_mul_expression(tomMatch1_436);
if (tom_is_sort_E(tomMatch1_434)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_434))) {
if (tomMatch1_432 + 1 >= tom_get_size_terms_terms(tomMatch1_428)) {

return debug("R13",
((IntExpression)tom__arg),
tom_make_min(tom_append_array_EL(tom_get_slice_EL(tomMatch1_418,tomMatch1_end_425 + 1,tom_get_size_EL_EL(tomMatch1_418)),tom_cons_array_EL(ArithmeticOperations.scale((AffineExpression)tomMatch1_434,tom_get_slot_mul_coef(tomMatch1_436)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_418,tomMatch1_422,tomMatch1_end_425),tom_empty_array_EL(3)))))); 
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
tomMatch1_end_425=tomMatch1_end_425 + 1;
}
} while(!(tomMatch1_end_425 > tom_get_size_EL_EL(tomMatch1_418)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_qaffine(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_442=tom_get_slot_qaffine_terms(((IntExpression)tom__arg));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_442))) {
int tomMatch1_446=0;
if (!(tomMatch1_446 >= tom_get_size_terms_terms(tomMatch1_442))) {
org.polymodel.algebra.IntTerm tomMatch1_450=tom_get_element_terms_terms(tomMatch1_442,tomMatch1_446);
if (tom_is_sort_T(tomMatch1_450)) {
if (tom_is_fun_sym_mul(((org.polymodel.algebra.IntTerm)tomMatch1_450))) {
IntExpression tomMatch1_448=tom_get_slot_mul_expression(tomMatch1_450);
if (tom_is_sort_E(tomMatch1_448)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_448))) {
if (tomMatch1_446 + 1 >= tom_get_size_terms_terms(tomMatch1_442)) {
IntExpression tom_in=((IntExpression)tom__arg);

if (
tom_in.eContainer() == null)
return debug("R13",
tom_in,ArithmeticOperations.scale((AffineExpression)
tomMatch1_448, 
tom_get_slot_mul_coef(tomMatch1_450)));

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
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_qaffine(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_456=tom_get_slot_qaffine_terms(((IntExpression)tom__arg));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_456))) {
int tomMatch1_460=0;
int tomMatch1_end_463=tomMatch1_460;
do {
{
if (!(tomMatch1_end_463 >= tom_get_size_terms_terms(tomMatch1_456))) {
org.polymodel.algebra.IntTerm tomMatch1_468=tom_get_element_terms_terms(tomMatch1_456,tomMatch1_end_463);
boolean tomMatch1_481= false ;
IntExpression tomMatch1_466= null ;
org.polymodel.algebra.IntTerm tomMatch1_471= null ;
org.polymodel.algebra.IntTerm tomMatch1_470= null ;
 long  tomMatch1_467= 0 ;
org.polymodel.algebra.IntTerm tomMatch1_469= null ;
if (tom_is_sort_T(tomMatch1_468)) {
if (tom_is_fun_sym_floor(((org.polymodel.algebra.IntTerm)tomMatch1_468))) {
{
tomMatch1_481= true ;
tomMatch1_469=tomMatch1_468;
tomMatch1_466=tom_get_slot_floor_expression(tomMatch1_469);
tomMatch1_467=tom_get_slot_floor_coef(tomMatch1_469);
}
} else {
if (tom_is_sort_T(tomMatch1_468)) {
if (tom_is_fun_sym_mod(((org.polymodel.algebra.IntTerm)tomMatch1_468))) {
{
tomMatch1_481= true ;
tomMatch1_470=tomMatch1_468;
tomMatch1_466=tom_get_slot_mod_expression(tomMatch1_470);
tomMatch1_467=tom_get_slot_mod_coef(tomMatch1_470);
}
} else {
if (tom_is_sort_T(tomMatch1_468)) {
if (tom_is_fun_sym_ceil(((org.polymodel.algebra.IntTerm)tomMatch1_468))) {
{
tomMatch1_481= true ;
tomMatch1_471=tomMatch1_468;
tomMatch1_466=tom_get_slot_ceil_expression(tomMatch1_471);
tomMatch1_467=tom_get_slot_ceil_coef(tomMatch1_471);
}
}
}
}
}
}
}
if (tomMatch1_481) {
if (tom_is_sort_E(tomMatch1_466)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_466))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_472=tom_get_slot_affine_terms(tomMatch1_466);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_472))) {
int tomMatch1_476=0;
if (!(tomMatch1_476 >= tom_get_size_terms_terms(tomMatch1_472))) {
org.polymodel.algebra.IntTerm tomMatch1_479=tom_get_element_terms_terms(tomMatch1_472,tomMatch1_476);
if (tom_is_sort_T(tomMatch1_479)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_479))) {
 long  tom_a=tom_get_slot_constant_coef(tomMatch1_479);
if (tomMatch1_476 + 1 >= tom_get_size_terms_terms(tomMatch1_472)) {
 long  tom_b=tomMatch1_467;

long modval= 0;
switch (((QuasiAffineTerm)
tom_get_element_terms_terms(tomMatch1_456,tomMatch1_end_463)).getOperator()) {
case MOD:
modval= (
tom_a)%(
tom_b); 
break;  
case FLOOR:
modval= (
tom_a)/(
tom_b);
break;
case CEIL:
modval= (
tom_a+ 
tom_b-1)%(
tom_b);
break;
default: 
modval= (
tom_a)%(
tom_b);
break; 
}
long one =  1; 
return debug("R14",
((IntExpression)tom__arg),
tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_456,tomMatch1_end_463 + 1,tom_get_size_terms_terms(tomMatch1_456)),tom_cons_array_terms(tom_make_mul(tom_make_affine(tom_cons_array_terms(tom_make_constant(modval),tom_empty_array_terms(1))),one),tom_append_array_terms(tom_get_slice_terms(tomMatch1_456,tomMatch1_460,tomMatch1_end_463),tom_empty_array_terms(3))))));

}
}
}
}
}
}
}
}
}
tomMatch1_end_463=tomMatch1_end_463 + 1;
}
} while(!(tomMatch1_end_463 > tom_get_size_terms_terms(tomMatch1_456)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_qaffine(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_483=tom_get_slot_qaffine_terms(((IntExpression)tom__arg));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_483))) {
int tomMatch1_487=0;
int tomMatch1_end_490=tomMatch1_487;
do {
{
 EList<org.polymodel.algebra.IntTerm>  tom_x1=tom_get_slice_terms(tomMatch1_483,tomMatch1_487,tomMatch1_end_490);
if (!(tomMatch1_end_490 >= tom_get_size_terms_terms(tomMatch1_483))) {
org.polymodel.algebra.IntTerm tomMatch1_495=tom_get_element_terms_terms(tomMatch1_483,tomMatch1_end_490);
if (tom_is_sort_T(tomMatch1_495)) {
if (tom_is_fun_sym_mul(((org.polymodel.algebra.IntTerm)tomMatch1_495))) {
IntExpression tomMatch1_493=tom_get_slot_mul_expression(tomMatch1_495);
if (tom_is_sort_E(tomMatch1_493)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_493))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_497=tom_get_slot_qaffine_terms(tomMatch1_493);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_497))) {
int tomMatch1_501=0;
if (!(tomMatch1_501 >= tom_get_size_terms_terms(tomMatch1_497))) {
org.polymodel.algebra.IntTerm tomMatch1_505=tom_get_element_terms_terms(tomMatch1_497,tomMatch1_501);
if (tom_is_sort_T(tomMatch1_505)) {
if (tom_is_fun_sym_mul(((org.polymodel.algebra.IntTerm)tomMatch1_505))) {
if (tomMatch1_501 + 1 >= tom_get_size_terms_terms(tomMatch1_497)) {
 EList<org.polymodel.algebra.IntTerm>  tom_x2=tom_get_slice_terms(tomMatch1_483,tomMatch1_end_490 + 1,tom_get_size_terms_terms(tomMatch1_483));
IntExpression tom_in=((IntExpression)tom__arg);

long d = (
tom_get_slot_mul_coef(tomMatch1_505))*(
tom_get_slot_mul_coef(tomMatch1_495));
if(d!=0) {
return debug("R15prime",
tom_in,
tom_make_qaffine(tom_cons_array_terms(tom_make_mul(tom_get_slot_mul_expression(tomMatch1_505),d),tom_append_array_terms(tom_x2,tom_append_array_terms(tom_x1,tom_empty_array_terms(3))))));
} else {
return debug("R15prime",
tom_in,
tom_make_qaffine(tom_append_array_terms(tom_x2,tom_append_array_terms(tom_x1,tom_empty_array_terms(2)))));
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
tomMatch1_end_490=tomMatch1_end_490 + 1;
}
} while(!(tomMatch1_end_490 > tom_get_size_terms_terms(tomMatch1_483)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_qaffine(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_508=tom_get_slot_qaffine_terms(((IntExpression)tom__arg));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_508))) {
int tomMatch1_512=0;
if (!(tomMatch1_512 >= tom_get_size_terms_terms(tomMatch1_508))) {
org.polymodel.algebra.IntTerm tomMatch1_516=tom_get_element_terms_terms(tomMatch1_508,tomMatch1_512);
if (tom_is_sort_T(tomMatch1_516)) {
if (tom_is_fun_sym_mul(((org.polymodel.algebra.IntTerm)tomMatch1_516))) {
IntExpression tomMatch1_514=tom_get_slot_mul_expression(tomMatch1_516);
if (tom_is_sort_E(tomMatch1_514)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_514))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_518=tom_get_slot_qaffine_terms(tomMatch1_514);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_518))) {
int tomMatch1_522=0;
if (!(tomMatch1_522 >= tom_get_size_terms_terms(tomMatch1_518))) {
org.polymodel.algebra.IntTerm tomMatch1_526=tom_get_element_terms_terms(tomMatch1_518,tomMatch1_522);
if (tom_is_sort_T(tomMatch1_526)) {
if (tom_is_fun_sym_mul(((org.polymodel.algebra.IntTerm)tomMatch1_526))) {
IntExpression tomMatch1_524=tom_get_slot_mul_expression(tomMatch1_526);
if (tom_is_sort_E(tomMatch1_524)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_524))) {
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tom_get_slot_affine_terms(tomMatch1_524)))) {
if (tomMatch1_522 + 1 >= tom_get_size_terms_terms(tomMatch1_518)) {
if (tomMatch1_512 + 1 >= tom_get_size_terms_terms(tomMatch1_508)) {
IntExpression tom_in=((IntExpression)tom__arg);

long d = (
tom_get_slot_mul_coef(tomMatch1_526))*(
tom_get_slot_mul_coef(tomMatch1_516));
if(d!=0) {
return debug("R15prime",
tom_in,
tom_make_qaffine(tom_cons_array_terms(tom_make_mul(tomMatch1_524,d),tom_empty_array_terms(1))));
} else {  
return debug("R15prime",
tom_in,
tom_make_affine(tom_empty_array_terms(0)));
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
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_qaffine(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_535=tom_get_slot_qaffine_terms(((IntExpression)tom__arg));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_535))) {
int tomMatch1_539=0;
if (!(tomMatch1_539 >= tom_get_size_terms_terms(tomMatch1_535))) {
org.polymodel.algebra.IntTerm tomMatch1_543=tom_get_element_terms_terms(tomMatch1_535,tomMatch1_539);
if (tom_is_sort_T(tomMatch1_543)) {
if (tom_is_fun_sym_mul(((org.polymodel.algebra.IntTerm)tomMatch1_543))) {
IntExpression tomMatch1_541=tom_get_slot_mul_expression(tomMatch1_543);
if (tom_is_sort_E(tomMatch1_541)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_541))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_545=tom_get_slot_qaffine_terms(tomMatch1_541);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_545))) {
int tomMatch1_549=0;
if (!(tomMatch1_549 >= tom_get_size_terms_terms(tomMatch1_545))) {
org.polymodel.algebra.IntTerm tomMatch1_553=tom_get_element_terms_terms(tomMatch1_545,tomMatch1_549);
if (tom_is_sort_T(tomMatch1_553)) {
if (tom_is_fun_sym_mul(((org.polymodel.algebra.IntTerm)tomMatch1_553))) {
IntExpression tomMatch1_551=tom_get_slot_mul_expression(tomMatch1_553);
if (tom_is_sort_E(tomMatch1_551)) {
if (tom_is_fun_sym_qaffine(((IntExpression)tomMatch1_551))) {
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tom_get_slot_qaffine_terms(tomMatch1_551)))) {
if (tomMatch1_549 + 1 >= tom_get_size_terms_terms(tomMatch1_545)) {
if (tomMatch1_539 + 1 >= tom_get_size_terms_terms(tomMatch1_535)) {
IntExpression tom_in=((IntExpression)tom__arg);

long d = (
tom_get_slot_mul_coef(tomMatch1_553))*(
tom_get_slot_mul_coef(tomMatch1_543));
if(d!=0) {
return debug("R15prime",
tom_in,
tom_make_qaffine(tom_cons_array_terms(tom_make_mul(tomMatch1_551,d),tom_empty_array_terms(1))));
} else {  
return debug("R15prime",
tom_in,
tom_make_affine(tom_empty_array_terms(0)));
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
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_qaffine(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_562=tom_get_slot_qaffine_terms(((IntExpression)tom__arg));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_562))) {
int tomMatch1_566=0;
int tomMatch1_end_569=tomMatch1_566;
do {
{
if (!(tomMatch1_end_569 >= tom_get_size_terms_terms(tomMatch1_562))) {
org.polymodel.algebra.IntTerm tomMatch1_574=tom_get_element_terms_terms(tomMatch1_562,tomMatch1_end_569);
if (tom_is_sort_T(tomMatch1_574)) {
if (tom_is_fun_sym_mul(((org.polymodel.algebra.IntTerm)tomMatch1_574))) {
IntExpression tomMatch1_572=tom_get_slot_mul_expression(tomMatch1_574);
 long  tomMatch1_573=tom_get_slot_mul_coef(tomMatch1_574);
if (tom_is_sort_E(tomMatch1_572)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_572))) {
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tom_get_slot_affine_terms(tomMatch1_572)))) {
if ( true ) {
if (tom_equal_term_long(0L, tomMatch1_573)) {

return debug("R15",
((IntExpression)tom__arg),
tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_562,tomMatch1_end_569 + 1,tom_get_size_terms_terms(tomMatch1_562)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_562,tomMatch1_566,tomMatch1_end_569),tom_empty_array_terms(2)))));

}
}
}
}
}
}
}
}
tomMatch1_end_569=tomMatch1_end_569 + 1;
}
} while(!(tomMatch1_end_569 > tom_get_size_terms_terms(tomMatch1_562)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_qaffine(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_585=tom_get_slot_qaffine_terms(((IntExpression)tom__arg));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_585))) {
int tomMatch1_589=0;
int tomMatch1_end_592=tomMatch1_589;
do {
{
if (!(tomMatch1_end_592 >= tom_get_size_terms_terms(tomMatch1_585))) {
org.polymodel.algebra.IntTerm tomMatch1_597=tom_get_element_terms_terms(tomMatch1_585,tomMatch1_end_592);
boolean tomMatch1_606= false ;
org.polymodel.algebra.IntTerm tomMatch1_600= null ;
org.polymodel.algebra.IntTerm tomMatch1_599= null ;
org.polymodel.algebra.IntTerm tomMatch1_598= null ;
IntExpression tomMatch1_595= null ;
 long  tomMatch1_596= 0 ;
if (tom_is_sort_T(tomMatch1_597)) {
if (tom_is_fun_sym_floor(((org.polymodel.algebra.IntTerm)tomMatch1_597))) {
{
tomMatch1_606= true ;
tomMatch1_598=tomMatch1_597;
tomMatch1_595=tom_get_slot_floor_expression(tomMatch1_598);
tomMatch1_596=tom_get_slot_floor_coef(tomMatch1_598);
}
} else {
if (tom_is_sort_T(tomMatch1_597)) {
if (tom_is_fun_sym_mod(((org.polymodel.algebra.IntTerm)tomMatch1_597))) {
{
tomMatch1_606= true ;
tomMatch1_599=tomMatch1_597;
tomMatch1_595=tom_get_slot_mod_expression(tomMatch1_599);
tomMatch1_596=tom_get_slot_mod_coef(tomMatch1_599);
}
} else {
if (tom_is_sort_T(tomMatch1_597)) {
if (tom_is_fun_sym_mul(((org.polymodel.algebra.IntTerm)tomMatch1_597))) {
{
tomMatch1_606= true ;
tomMatch1_600=tomMatch1_597;
tomMatch1_595=tom_get_slot_mul_expression(tomMatch1_600);
tomMatch1_596=tom_get_slot_mul_coef(tomMatch1_600);
}
}
}
}
}
}
}
if (tomMatch1_606) {
if (tom_is_sort_E(tomMatch1_595)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_595))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_601=tom_get_slot_affine_terms(tomMatch1_595);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_601))) {
if (0 >= tom_get_size_terms_terms(tomMatch1_601)) {

return debug("R15",
((IntExpression)tom__arg),
tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_585,tomMatch1_end_592 + 1,tom_get_size_terms_terms(tomMatch1_585)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_585,tomMatch1_589,tomMatch1_end_592),tom_empty_array_terms(2)))));

}
}
}
}
}
}
tomMatch1_end_592=tomMatch1_end_592 + 1;
}
} while(!(tomMatch1_end_592 > tom_get_size_terms_terms(tomMatch1_585)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_qaffine(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_608=tom_get_slot_qaffine_terms(((IntExpression)tom__arg));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_608))) {
int tomMatch1_612=0;
int tomMatch1_end_615=tomMatch1_612;
do {
{
if (!(tomMatch1_end_615 >= tom_get_size_terms_terms(tomMatch1_608))) {
org.polymodel.algebra.IntTerm tomMatch1_620=tom_get_element_terms_terms(tomMatch1_608,tomMatch1_end_615);
if (tom_is_sort_T(tomMatch1_620)) {
if (tom_is_fun_sym_mod(((org.polymodel.algebra.IntTerm)tomMatch1_620))) {
IntExpression tomMatch1_618=tom_get_slot_mod_expression(tomMatch1_620);
if (tom_is_sort_E(tomMatch1_618)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_618))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_622=tom_get_slot_affine_terms(tomMatch1_618);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_622))) {
int tomMatch1_626=0;
int tomMatch1_end_629=tomMatch1_626;
do {
{
if (!(tomMatch1_end_629 >= tom_get_size_terms_terms(tomMatch1_622))) {
org.polymodel.algebra.IntTerm tomMatch1_634=tom_get_element_terms_terms(tomMatch1_622,tomMatch1_end_629);
if (tom_is_sort_T(tomMatch1_634)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_634))) {
 long  tom_b=tom_get_slot_term_coef(tomMatch1_634);
if (tom_equal_term_long(tom_b, tom_get_slot_mod_coef(tomMatch1_620))) {

return debug("R16",
((IntExpression)tom__arg),
tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_608,tomMatch1_end_615 + 1,tom_get_size_terms_terms(tomMatch1_608)),tom_cons_array_terms(tom_make_mod(tom_make_affine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_622,tomMatch1_end_629 + 1,tom_get_size_terms_terms(tomMatch1_622)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_622,tomMatch1_626,tomMatch1_end_629),tom_empty_array_terms(2)))),tom_b),tom_append_array_terms(tom_get_slice_terms(tomMatch1_608,tomMatch1_612,tomMatch1_end_615),tom_empty_array_terms(3))))));

}
}
}
}
tomMatch1_end_629=tomMatch1_end_629 + 1;
}
} while(!(tomMatch1_end_629 > tom_get_size_terms_terms(tomMatch1_622)));
}
}
}
}
}
}
tomMatch1_end_615=tomMatch1_end_615 + 1;
}
} while(!(tomMatch1_end_615 > tom_get_size_terms_terms(tomMatch1_608)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_qaffine(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_638=tom_get_slot_qaffine_terms(((IntExpression)tom__arg));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_638))) {
int tomMatch1_642=0;
int tomMatch1_end_645=tomMatch1_642;
do {
{
if (!(tomMatch1_end_645 >= tom_get_size_terms_terms(tomMatch1_638))) {
org.polymodel.algebra.IntTerm tomMatch1_650=tom_get_element_terms_terms(tomMatch1_638,tomMatch1_end_645);
if (tom_is_sort_T(tomMatch1_650)) {
if (tom_is_fun_sym_mod(((org.polymodel.algebra.IntTerm)tomMatch1_650))) {
IntExpression tomMatch1_648=tom_get_slot_mod_expression(tomMatch1_650);
if (tom_is_sort_E(tomMatch1_648)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_648))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_652=tom_get_slot_affine_terms(tomMatch1_648);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_652))) {
int tomMatch1_656=0;
int tomMatch1_end_659=tomMatch1_656;
do {
{
if (!(tomMatch1_end_659 >= tom_get_size_terms_terms(tomMatch1_652))) {
org.polymodel.algebra.IntTerm tomMatch1_663=tom_get_element_terms_terms(tomMatch1_652,tomMatch1_end_659);
if (tom_is_sort_T(tomMatch1_663)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_663))) {
 long  tom_b=tom_get_slot_constant_coef(tomMatch1_663);
if (tom_equal_term_long(tom_b, tom_get_slot_mod_coef(tomMatch1_650))) {

return debug("R16bis",
((IntExpression)tom__arg),
tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_638,tomMatch1_end_645 + 1,tom_get_size_terms_terms(tomMatch1_638)),tom_cons_array_terms(tom_make_mod(tom_make_affine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_652,tomMatch1_end_659 + 1,tom_get_size_terms_terms(tomMatch1_652)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_652,tomMatch1_656,tomMatch1_end_659),tom_empty_array_terms(2)))),tom_b),tom_append_array_terms(tom_get_slice_terms(tomMatch1_638,tomMatch1_642,tomMatch1_end_645),tom_empty_array_terms(3))))));

}
}
}
}
tomMatch1_end_659=tomMatch1_end_659 + 1;
}
} while(!(tomMatch1_end_659 > tom_get_size_terms_terms(tomMatch1_652)));
}
}
}
}
}
}
tomMatch1_end_645=tomMatch1_end_645 + 1;
}
} while(!(tomMatch1_end_645 > tom_get_size_terms_terms(tomMatch1_638)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_qaffine(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_667=tom_get_slot_qaffine_terms(((IntExpression)tom__arg));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_667))) {
int tomMatch1_671=0;
int tomMatch1_end_674=tomMatch1_671;
do {
{
if (!(tomMatch1_end_674 >= tom_get_size_terms_terms(tomMatch1_667))) {
org.polymodel.algebra.IntTerm tomMatch1_679=tom_get_element_terms_terms(tomMatch1_667,tomMatch1_end_674);
if (tom_is_sort_T(tomMatch1_679)) {
if (tom_is_fun_sym_floor(((org.polymodel.algebra.IntTerm)tomMatch1_679))) {
IntExpression tomMatch1_677=tom_get_slot_floor_expression(tomMatch1_679);
if (tom_is_sort_E(tomMatch1_677)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_677))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_681=tom_get_slot_affine_terms(tomMatch1_677);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_681))) {
int tomMatch1_685=0;
int tomMatch1_end_688=tomMatch1_685;
do {
{
if (!(tomMatch1_end_688 >= tom_get_size_terms_terms(tomMatch1_681))) {
org.polymodel.algebra.IntTerm tomMatch1_693=tom_get_element_terms_terms(tomMatch1_681,tomMatch1_end_688);
if (tom_is_sort_T(tomMatch1_693)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_693))) {
 long  tom_b=tom_get_slot_term_coef(tomMatch1_693);
if (tom_equal_term_long(tom_b, tom_get_slot_floor_coef(tomMatch1_679))) {

return debug("R17",
((IntExpression)tom__arg),
tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_667,tomMatch1_end_674 + 1,tom_get_size_terms_terms(tomMatch1_667)),tom_cons_array_terms(tom_make_floor(tom_make_affine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_681,tomMatch1_end_688 + 1,tom_get_size_terms_terms(tomMatch1_681)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_681,tomMatch1_685,tomMatch1_end_688),tom_empty_array_terms(2)))),tom_b),tom_cons_array_terms(tom_make_mul(tom_make_affine(tom_cons_array_terms(tom_make_term(1,tom_get_slot_term_variable(tomMatch1_693)),tom_empty_array_terms(1))),1),tom_append_array_terms(tom_get_slice_terms(tomMatch1_667,tomMatch1_671,tomMatch1_end_674),tom_empty_array_terms(4)))))));

}
}
}
}
tomMatch1_end_688=tomMatch1_end_688 + 1;
}
} while(!(tomMatch1_end_688 > tom_get_size_terms_terms(tomMatch1_681)));
}
}
}
}
}
}
tomMatch1_end_674=tomMatch1_end_674 + 1;
}
} while(!(tomMatch1_end_674 > tom_get_size_terms_terms(tomMatch1_667)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_qaffine(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_697=tom_get_slot_qaffine_terms(((IntExpression)tom__arg));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_697))) {
int tomMatch1_701=0;
int tomMatch1_end_704=tomMatch1_701;
do {
{
if (!(tomMatch1_end_704 >= tom_get_size_terms_terms(tomMatch1_697))) {
org.polymodel.algebra.IntTerm tomMatch1_713=tom_get_element_terms_terms(tomMatch1_697,tomMatch1_end_704);
if (tom_is_sort_T(tomMatch1_713)) {
if (tom_is_fun_sym_mul(((org.polymodel.algebra.IntTerm)tomMatch1_713))) {
 long  tom_c=tom_get_slot_mul_coef(tomMatch1_713);
int tomMatch1_705=tomMatch1_end_704 + 1;
int tomMatch1_end_708=tomMatch1_705;
do {
{
if (!(tomMatch1_end_708 >= tom_get_size_terms_terms(tomMatch1_697))) {
org.polymodel.algebra.IntTerm tomMatch1_717=tom_get_element_terms_terms(tomMatch1_697,tomMatch1_end_708);
if (tom_is_sort_T(tomMatch1_717)) {
if (tom_is_fun_sym_mul(((org.polymodel.algebra.IntTerm)tomMatch1_717))) {
if (tom_equal_term_long(tom_c, tom_get_slot_mul_coef(tomMatch1_717))) {

AffineExpression res=  ArithmeticOperations.add((AffineExpression)
tom_get_slot_mul_expression(tomMatch1_713),(AffineExpression)
tom_get_slot_mul_expression(tomMatch1_717));
return debug("R22",
((IntExpression)tom__arg),
tom_make_qaffine(tom_cons_array_terms(tom_make_mul(res,tom_c),tom_append_array_terms(tom_get_slice_terms(tomMatch1_697,tomMatch1_end_708 + 1,tom_get_size_terms_terms(tomMatch1_697)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_697,tomMatch1_705,tomMatch1_end_708),tom_append_array_terms(tom_get_slice_terms(tomMatch1_697,tomMatch1_701,tomMatch1_end_704),tom_empty_array_terms(4)))))));

}
}
}
}
tomMatch1_end_708=tomMatch1_end_708 + 1;
}
} while(!(tomMatch1_end_708 > tom_get_size_terms_terms(tomMatch1_697)));
}
}
}
tomMatch1_end_704=tomMatch1_end_704 + 1;
}
} while(!(tomMatch1_end_704 > tom_get_size_terms_terms(tomMatch1_697)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_qaffine(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_721=tom_get_slot_qaffine_terms(((IntExpression)tom__arg));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_721))) {
int tomMatch1_725=0;
int tomMatch1_end_728=tomMatch1_725;
do {
{
if (!(tomMatch1_end_728 >= tom_get_size_terms_terms(tomMatch1_721))) {
org.polymodel.algebra.IntTerm tomMatch1_737=tom_get_element_terms_terms(tomMatch1_721,tomMatch1_end_728);
if (tom_is_sort_T(tomMatch1_737)) {
if (tom_is_fun_sym_floor(((org.polymodel.algebra.IntTerm)tomMatch1_737))) {
 long  tom_c=tom_get_slot_floor_coef(tomMatch1_737);
int tomMatch1_729=tomMatch1_end_728 + 1;
int tomMatch1_end_732=tomMatch1_729;
do {
{
if (!(tomMatch1_end_732 >= tom_get_size_terms_terms(tomMatch1_721))) {
org.polymodel.algebra.IntTerm tomMatch1_741=tom_get_element_terms_terms(tomMatch1_721,tomMatch1_end_732);
if (tom_is_sort_T(tomMatch1_741)) {
if (tom_is_fun_sym_floor(((org.polymodel.algebra.IntTerm)tomMatch1_741))) {
if (tom_equal_term_long(tom_c, tom_get_slot_floor_coef(tomMatch1_741))) {

AffineExpression res=  ArithmeticOperations.add((AffineExpression)
tom_get_slot_floor_expression(tomMatch1_737),(AffineExpression)
tom_get_slot_floor_expression(tomMatch1_741));
return debug("R23",
((IntExpression)tom__arg),
tom_make_qaffine(tom_cons_array_terms(tom_make_floor(res,tom_c),tom_append_array_terms(tom_get_slice_terms(tomMatch1_721,tomMatch1_end_732 + 1,tom_get_size_terms_terms(tomMatch1_721)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_721,tomMatch1_729,tomMatch1_end_732),tom_append_array_terms(tom_get_slice_terms(tomMatch1_721,tomMatch1_725,tomMatch1_end_728),tom_empty_array_terms(4)))))));

}
}
}
}
tomMatch1_end_732=tomMatch1_end_732 + 1;
}
} while(!(tomMatch1_end_732 > tom_get_size_terms_terms(tomMatch1_721)));
}
}
}
tomMatch1_end_728=tomMatch1_end_728 + 1;
}
} while(!(tomMatch1_end_728 > tom_get_size_terms_terms(tomMatch1_721)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_qaffine(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_745=tom_get_slot_qaffine_terms(((IntExpression)tom__arg));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_745))) {
int tomMatch1_749=0;
int tomMatch1_end_752=tomMatch1_749;
do {
{
if (!(tomMatch1_end_752 >= tom_get_size_terms_terms(tomMatch1_745))) {
org.polymodel.algebra.IntTerm tomMatch1_761=tom_get_element_terms_terms(tomMatch1_745,tomMatch1_end_752);
if (tom_is_sort_T(tomMatch1_761)) {
if (tom_is_fun_sym_mul(((org.polymodel.algebra.IntTerm)tomMatch1_761))) {
IntExpression tomMatch1_759=tom_get_slot_mul_expression(tomMatch1_761);
if (tom_is_sort_E(tomMatch1_759)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_759))) {
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tom_get_slot_affine_terms(tomMatch1_759)))) {
int tomMatch1_753=tomMatch1_end_752 + 1;
int tomMatch1_end_756=tomMatch1_753;
do {
{
if (!(tomMatch1_end_756 >= tom_get_size_terms_terms(tomMatch1_745))) {
org.polymodel.algebra.IntTerm tomMatch1_768=tom_get_element_terms_terms(tomMatch1_745,tomMatch1_end_756);
if (tom_is_sort_T(tomMatch1_768)) {
if (tom_is_fun_sym_mul(((org.polymodel.algebra.IntTerm)tomMatch1_768))) {
IntExpression tomMatch1_766=tom_get_slot_mul_expression(tomMatch1_768);
if (tom_is_sort_E(tomMatch1_766)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_766))) {
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tom_get_slot_affine_terms(tomMatch1_766)))) {

AffineExpression res = 
ArithmeticOperations.add(
ArithmeticOperations.scale((AffineExpression)
tomMatch1_759,
tom_get_slot_mul_coef(tomMatch1_761)), 
ArithmeticOperations.scale((AffineExpression)
tomMatch1_766,
tom_get_slot_mul_coef(tomMatch1_768))
);
return debug("R18",
((IntExpression)tom__arg),
tom_make_qaffine(tom_cons_array_terms(tom_make_mul(res,1),tom_append_array_terms(tom_get_slice_terms(tomMatch1_745,tomMatch1_end_756 + 1,tom_get_size_terms_terms(tomMatch1_745)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_745,tomMatch1_753,tomMatch1_end_756),tom_append_array_terms(tom_get_slice_terms(tomMatch1_745,tomMatch1_749,tomMatch1_end_752),tom_empty_array_terms(4)))))));



}
}
}
}
}
}
tomMatch1_end_756=tomMatch1_end_756 + 1;
}
} while(!(tomMatch1_end_756 > tom_get_size_terms_terms(tomMatch1_745)));
}
}
}
}
}
}
tomMatch1_end_752=tomMatch1_end_752 + 1;
}
} while(!(tomMatch1_end_752 > tom_get_size_terms_terms(tomMatch1_745)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_reduction(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_780=tom_get_slot_reduction_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_780))) {
int tomMatch1_785=0;
if (!(tomMatch1_785 >= tom_get_size_EL_EL(tomMatch1_780))) {
if (tomMatch1_785 + 1 >= tom_get_size_EL_EL(tomMatch1_780)) {

return debug("red(E)->E", 
((IntExpression)tom__arg), 
tom_get_element_EL_EL(tomMatch1_780,tomMatch1_785)); 

}
}
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_sum(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_788=tom_get_slot_sum_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_788))) {
int tomMatch1_792=0;
int tomMatch1_end_795=tomMatch1_792;
do {
{
if (!(tomMatch1_end_795 >= tom_get_size_EL_EL(tomMatch1_788))) {
IntExpression tomMatch1_803=tom_get_element_EL_EL(tomMatch1_788,tomMatch1_end_795);
if (tom_is_sort_E(tomMatch1_803)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_803))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_802=tom_get_slot_affine_terms(tomMatch1_803);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_802))) {
int tomMatch1_796=tomMatch1_end_795 + 1;
int tomMatch1_end_799=tomMatch1_796;
do {
{
if (!(tomMatch1_end_799 >= tom_get_size_EL_EL(tomMatch1_788))) {
IntExpression tomMatch1_806=tom_get_element_EL_EL(tomMatch1_788,tomMatch1_end_799);
if (tom_is_sort_E(tomMatch1_806)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_806))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_805=tom_get_slot_affine_terms(tomMatch1_806);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_805))) {
return debug("sum0", 
((IntExpression)tom__arg), 
tom_make_sum(tom_append_array_EL(tom_get_slice_EL(tomMatch1_788,tomMatch1_end_799 + 1,tom_get_size_EL_EL(tomMatch1_788)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_788,tomMatch1_796,tomMatch1_end_799),tom_append_array_EL(tom_get_slice_EL(tomMatch1_788,tomMatch1_792,tomMatch1_end_795),tom_cons_array_EL(tom_make_affine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_805,0,tom_get_size_terms_terms(tomMatch1_805)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_802,0,tom_get_size_terms_terms(tomMatch1_802)),tom_empty_array_terms(2)))),tom_empty_array_EL(4))))))); 
}
}
}
}
tomMatch1_end_799=tomMatch1_end_799 + 1;
}
} while(!(tomMatch1_end_799 > tom_get_size_EL_EL(tomMatch1_788)));
}
}
}
}
tomMatch1_end_795=tomMatch1_end_795 + 1;
}
} while(!(tomMatch1_end_795 > tom_get_size_EL_EL(tomMatch1_788)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_sum(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_815=tom_get_slot_sum_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_815))) {
int tomMatch1_819=0;
if (!(tomMatch1_819 >= tom_get_size_EL_EL(tomMatch1_815))) {
IntExpression tomMatch1_822=tom_get_element_EL_EL(tomMatch1_815,tomMatch1_819);
if (tom_is_sort_E(tomMatch1_822)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_822))) {
if (tomMatch1_819 + 1 >= tom_get_size_EL_EL(tomMatch1_815)) {
return debug("sum1", 
((IntExpression)tom__arg), 
tom_make_affine(tom_get_slot_affine_terms(tomMatch1_822))); 
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
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_sum(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_825=tom_get_slot_sum_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_825))) {
int tomMatch1_829=0;
int tomMatch1_end_832=tomMatch1_829;
do {
{
if (!(tomMatch1_end_832 >= tom_get_size_EL_EL(tomMatch1_825))) {
IntExpression tomMatch1_840=tom_get_element_EL_EL(tomMatch1_825,tomMatch1_end_832);
if (tom_is_sort_E(tomMatch1_840)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_840))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_839=tom_get_slot_affine_terms(tomMatch1_840);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_839))) {
int tomMatch1_846=0;
if (!(tomMatch1_846 >= tom_get_size_terms_terms(tomMatch1_839))) {
org.polymodel.algebra.IntTerm tomMatch1_853=tom_get_element_terms_terms(tomMatch1_839,tomMatch1_846);
if (tom_is_sort_T(tomMatch1_853)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_853))) {
org.polymodel.algebra.Variable tom_v=tom_get_slot_term_variable(tomMatch1_853);
if (tomMatch1_846 + 1 >= tom_get_size_terms_terms(tomMatch1_839)) {
int tomMatch1_833=tomMatch1_end_832 + 1;
int tomMatch1_end_836=tomMatch1_833;
do {
{
if (!(tomMatch1_end_836 >= tom_get_size_EL_EL(tomMatch1_825))) {
IntExpression tomMatch1_843=tom_get_element_EL_EL(tomMatch1_825,tomMatch1_end_836);
if (tom_is_sort_E(tomMatch1_843)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_843))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_842=tom_get_slot_affine_terms(tomMatch1_843);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_842))) {
int tomMatch1_849=0;
if (!(tomMatch1_849 >= tom_get_size_terms_terms(tomMatch1_842))) {
org.polymodel.algebra.IntTerm tomMatch1_857=tom_get_element_terms_terms(tomMatch1_842,tomMatch1_849);
if (tom_is_sort_T(tomMatch1_857)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_857))) {
if (tom_equal_term_V(tom_v, tom_get_slot_term_variable(tomMatch1_857))) {
if (tomMatch1_849 + 1 >= tom_get_size_terms_terms(tomMatch1_842)) {
return debug("sum2", 
((IntExpression)tom__arg), 
tom_make_sum(tom_append_array_EL(tom_get_slice_EL(tomMatch1_825,tomMatch1_end_836 + 1,tom_get_size_EL_EL(tomMatch1_825)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_825,tomMatch1_833,tomMatch1_end_836),tom_append_array_EL(tom_get_slice_EL(tomMatch1_825,tomMatch1_829,tomMatch1_end_832),tom_cons_array_EL(tom_make_affine(tom_cons_array_terms(tom_make_term(tom_get_slot_term_coef(tomMatch1_853)+tom_get_slot_term_coef(tomMatch1_857),tom_v),tom_empty_array_terms(1))),tom_empty_array_EL(4))))))); 
}
}
}
}
}
}
}
}
}
tomMatch1_end_836=tomMatch1_end_836 + 1;
}
} while(!(tomMatch1_end_836 > tom_get_size_EL_EL(tomMatch1_825)));
}
}
}
}
}
}
}
}
tomMatch1_end_832=tomMatch1_end_832 + 1;
}
} while(!(tomMatch1_end_832 > tom_get_size_EL_EL(tomMatch1_825)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_sum(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_861=tom_get_slot_sum_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_861))) {
int tomMatch1_865=0;
int tomMatch1_end_868=tomMatch1_865;
do {
{
if (!(tomMatch1_end_868 >= tom_get_size_EL_EL(tomMatch1_861))) {
IntExpression tomMatch1_876=tom_get_element_EL_EL(tomMatch1_861,tomMatch1_end_868);
if (tom_is_sort_E(tomMatch1_876)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_876))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_875=tom_get_slot_affine_terms(tomMatch1_876);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_875))) {
int tomMatch1_882=0;
if (!(tomMatch1_882 >= tom_get_size_terms_terms(tomMatch1_875))) {
org.polymodel.algebra.IntTerm tomMatch1_888=tom_get_element_terms_terms(tomMatch1_875,tomMatch1_882);
if (tom_is_sort_T(tomMatch1_888)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_888))) {
if (tomMatch1_882 + 1 >= tom_get_size_terms_terms(tomMatch1_875)) {
int tomMatch1_869=tomMatch1_end_868 + 1;
int tomMatch1_end_872=tomMatch1_869;
do {
{
if (!(tomMatch1_end_872 >= tom_get_size_EL_EL(tomMatch1_861))) {
IntExpression tomMatch1_879=tom_get_element_EL_EL(tomMatch1_861,tomMatch1_end_872);
if (tom_is_sort_E(tomMatch1_879)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_879))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_878=tom_get_slot_affine_terms(tomMatch1_879);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_878))) {
int tomMatch1_885=0;
if (!(tomMatch1_885 >= tom_get_size_terms_terms(tomMatch1_878))) {
org.polymodel.algebra.IntTerm tomMatch1_891=tom_get_element_terms_terms(tomMatch1_878,tomMatch1_885);
if (tom_is_sort_T(tomMatch1_891)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_891))) {
if (tomMatch1_885 + 1 >= tom_get_size_terms_terms(tomMatch1_878)) {
return debug("sum3", 
((IntExpression)tom__arg), 
tom_make_sum(tom_cons_array_EL(tom_make_affine(tom_cons_array_terms(tom_make_constant(tom_get_slot_constant_coef(tomMatch1_888)+tom_get_slot_constant_coef(tomMatch1_891)),tom_empty_array_terms(1))),tom_append_array_EL(tom_get_slice_EL(tomMatch1_861,tomMatch1_end_872 + 1,tom_get_size_EL_EL(tomMatch1_861)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_861,tomMatch1_869,tomMatch1_end_872),tom_append_array_EL(tom_get_slice_EL(tomMatch1_861,tomMatch1_865,tomMatch1_end_868),tom_empty_array_EL(4))))))); 
}
}
}
}
}
}
}
}
tomMatch1_end_872=tomMatch1_end_872 + 1;
}
} while(!(tomMatch1_end_872 > tom_get_size_EL_EL(tomMatch1_861)));
}
}
}
}
}
}
}
}
tomMatch1_end_868=tomMatch1_end_868 + 1;
}
} while(!(tomMatch1_end_868 > tom_get_size_EL_EL(tomMatch1_861)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_sum(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_894=tom_get_slot_sum_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_894))) {
int tomMatch1_898=0;
if (!(tomMatch1_898 >= tom_get_size_EL_EL(tomMatch1_894))) {
if (tomMatch1_898 + 1 >= tom_get_size_EL_EL(tomMatch1_894)) {
return debug("sum4", 
((IntExpression)tom__arg), 
tom_get_element_EL_EL(tomMatch1_894,tomMatch1_898));	
}
}
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_sum(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_901=tom_get_slot_sum_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_901))) {
int tomMatch1_905=0;
int tomMatch1_end_908=tomMatch1_905;
do {
{
if (!(tomMatch1_end_908 >= tom_get_size_EL_EL(tomMatch1_901))) {
IntExpression tomMatch1_912=tom_get_element_EL_EL(tomMatch1_901,tomMatch1_end_908);
if (tom_is_sort_E(tomMatch1_912)) {
if (tom_is_fun_sym_sum(((IntExpression)tomMatch1_912))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_911=tom_get_slot_sum_expressions(tomMatch1_912);
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_911))) {
return debug("sum5", 
((IntExpression)tom__arg), 
tom_make_sum(tom_append_array_EL(tom_get_slice_EL(tomMatch1_901,tomMatch1_end_908 + 1,tom_get_size_EL_EL(tomMatch1_901)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_911,0,tom_get_size_EL_EL(tomMatch1_911)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_901,tomMatch1_905,tomMatch1_end_908),tom_empty_array_EL(3)))))); 
}
}
}
}
tomMatch1_end_908=tomMatch1_end_908 + 1;
}
} while(!(tomMatch1_end_908 > tom_get_size_EL_EL(tomMatch1_901)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_sum(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_918=tom_get_slot_sum_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_918))) {
int tomMatch1_922=0;
int tomMatch1_end_925=tomMatch1_922;
do {
{
if (!(tomMatch1_end_925 >= tom_get_size_EL_EL(tomMatch1_918))) {
IntExpression tomMatch1_929=tom_get_element_EL_EL(tomMatch1_918,tomMatch1_end_925);
if (tom_is_sort_E(tomMatch1_929)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_929))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_928=tom_get_slot_affine_terms(tomMatch1_929);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_928))) {
int tomMatch1_932=0;
if (!(tomMatch1_932 >= tom_get_size_terms_terms(tomMatch1_928))) {
org.polymodel.algebra.IntTerm tomMatch1_935=tom_get_element_terms_terms(tomMatch1_928,tomMatch1_932);
if (tom_is_sort_T(tomMatch1_935)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_935))) {
 long  tomMatch1_934=tom_get_slot_constant_coef(tomMatch1_935);
if ( true ) {
if (tom_equal_term_long(0l, tomMatch1_934)) {
if (tomMatch1_932 + 1 >= tom_get_size_terms_terms(tomMatch1_928)) {
return debug("sum6", 
((IntExpression)tom__arg), 
tom_make_sum(tom_append_array_EL(tom_get_slice_EL(tomMatch1_918,tomMatch1_end_925 + 1,tom_get_size_EL_EL(tomMatch1_918)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_918,tomMatch1_922,tomMatch1_end_925),tom_empty_array_EL(2))))); 
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
tomMatch1_end_925=tomMatch1_end_925 + 1;
}
} while(!(tomMatch1_end_925 > tom_get_size_EL_EL(tomMatch1_918)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_sum(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_940=tom_get_slot_sum_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_940))) {
int tomMatch1_944=0;
if (!(tomMatch1_944 >= tom_get_size_EL_EL(tomMatch1_940))) {
IntExpression tomMatch1_947=tom_get_element_EL_EL(tomMatch1_940,tomMatch1_944);
if (tom_is_sort_E(tomMatch1_947)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_947))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_946=tom_get_slot_affine_terms(tomMatch1_947);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_946))) {
int tomMatch1_950=0;
if (!(tomMatch1_950 >= tom_get_size_terms_terms(tomMatch1_946))) {
org.polymodel.algebra.IntTerm tomMatch1_953=tom_get_element_terms_terms(tomMatch1_946,tomMatch1_950);
if (tom_is_sort_T(tomMatch1_953)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_953))) {
if (tomMatch1_950 + 1 >= tom_get_size_terms_terms(tomMatch1_946)) {
if (tomMatch1_944 + 1 >= tom_get_size_EL_EL(tomMatch1_940)) {
return debug("sum7", 
((IntExpression)tom__arg), 
tom_make_affine(tom_cons_array_terms(tom_make_constant(tom_get_slot_constant_coef(tomMatch1_953)),tom_empty_array_terms(1)))); 
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
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_sum(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_956=tom_get_slot_sum_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_956))) {
if (0 >= tom_get_size_EL_EL(tomMatch1_956)) {
return debug("sum8", 
((IntExpression)tom__arg), 
tom_make_affine(tom_cons_array_terms(tom_make_constant(0),tom_empty_array_terms(1)))); 
}
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_prod(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_962=tom_get_slot_prod_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_962))) {
int tomMatch1_966=0;
if (!(tomMatch1_966 >= tom_get_size_EL_EL(tomMatch1_962))) {
if (tomMatch1_966 + 1 >= tom_get_size_EL_EL(tomMatch1_962)) {
return debug("prod0", 
((IntExpression)tom__arg), 
tom_get_element_EL_EL(tomMatch1_962,tomMatch1_966));	
}
}
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_prod(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_969=tom_get_slot_prod_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_969))) {
int tomMatch1_end_976=0;
do {
{
if (!(tomMatch1_end_976 >= tom_get_size_EL_EL(tomMatch1_969))) {
IntExpression tomMatch1_980=tom_get_element_EL_EL(tomMatch1_969,tomMatch1_end_976);
if (tom_is_sort_E(tomMatch1_980)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_980))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_979=tom_get_slot_affine_terms(tomMatch1_980);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_979))) {
int tomMatch1_983=0;
if (!(tomMatch1_983 >= tom_get_size_terms_terms(tomMatch1_979))) {
org.polymodel.algebra.IntTerm tomMatch1_986=tom_get_element_terms_terms(tomMatch1_979,tomMatch1_983);
if (tom_is_sort_T(tomMatch1_986)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_986))) {
 long  tomMatch1_985=tom_get_slot_constant_coef(tomMatch1_986);
if ( true ) {
if (tom_equal_term_long(0l, tomMatch1_985)) {
if (tomMatch1_983 + 1 >= tom_get_size_terms_terms(tomMatch1_979)) {
return debug("prod1", 
((IntExpression)tom__arg), 
tom_make_affine(tom_cons_array_terms(tom_make_constant(0),tom_empty_array_terms(1)))); 
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
tomMatch1_end_976=tomMatch1_end_976 + 1;
}
} while(!(tomMatch1_end_976 > tom_get_size_EL_EL(tomMatch1_969)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_prod(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_991=tom_get_slot_prod_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_991))) {
int tomMatch1_995=0;
int tomMatch1_end_998=tomMatch1_995;
do {
{
if (!(tomMatch1_end_998 >= tom_get_size_EL_EL(tomMatch1_991))) {
IntExpression tomMatch1_1002=tom_get_element_EL_EL(tomMatch1_991,tomMatch1_end_998);
if (tom_is_sort_E(tomMatch1_1002)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1002))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1001=tom_get_slot_affine_terms(tomMatch1_1002);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1001))) {
int tomMatch1_1005=0;
if (!(tomMatch1_1005 >= tom_get_size_terms_terms(tomMatch1_1001))) {
org.polymodel.algebra.IntTerm tomMatch1_1008=tom_get_element_terms_terms(tomMatch1_1001,tomMatch1_1005);
if (tom_is_sort_T(tomMatch1_1008)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_1008))) {
 long  tomMatch1_1007=tom_get_slot_constant_coef(tomMatch1_1008);
if ( true ) {
if (tom_equal_term_long(1l, tomMatch1_1007)) {
if (tomMatch1_1005 + 1 >= tom_get_size_terms_terms(tomMatch1_1001)) {
return debug("prod2", 
((IntExpression)tom__arg), 
tom_make_prod(tom_append_array_EL(tom_get_slice_EL(tomMatch1_991,tomMatch1_end_998 + 1,tom_get_size_EL_EL(tomMatch1_991)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_991,tomMatch1_995,tomMatch1_end_998),tom_empty_array_EL(2))))); 
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
tomMatch1_end_998=tomMatch1_end_998 + 1;
}
} while(!(tomMatch1_end_998 > tom_get_size_EL_EL(tomMatch1_991)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_prod(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1013=tom_get_slot_prod_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1013))) {
int tomMatch1_1017=0;
if (!(tomMatch1_1017 >= tom_get_size_EL_EL(tomMatch1_1013))) {
IntExpression tomMatch1_1021=tom_get_element_EL_EL(tomMatch1_1013,tomMatch1_1017);
if (tom_is_sort_E(tomMatch1_1021)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1021))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1020=tom_get_slot_affine_terms(tomMatch1_1021);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1020))) {
int tomMatch1_1027=0;
if (!(tomMatch1_1027 >= tom_get_size_terms_terms(tomMatch1_1020))) {
org.polymodel.algebra.IntTerm tomMatch1_1033=tom_get_element_terms_terms(tomMatch1_1020,tomMatch1_1027);
if (tom_is_sort_T(tomMatch1_1033)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_1033))) {
if (tomMatch1_1027 + 1 >= tom_get_size_terms_terms(tomMatch1_1020)) {
int tomMatch1_1018=tomMatch1_1017 + 1;
if (!(tomMatch1_1018 >= tom_get_size_EL_EL(tomMatch1_1013))) {
IntExpression tomMatch1_1024=tom_get_element_EL_EL(tomMatch1_1013,tomMatch1_1018);
if (tom_is_sort_E(tomMatch1_1024)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1024))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1023=tom_get_slot_affine_terms(tomMatch1_1024);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1023))) {
int tomMatch1_1030=0;
if (!(tomMatch1_1030 >= tom_get_size_terms_terms(tomMatch1_1023))) {
org.polymodel.algebra.IntTerm tomMatch1_1037=tom_get_element_terms_terms(tomMatch1_1023,tomMatch1_1030);
if (tom_is_sort_T(tomMatch1_1037)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_1037))) {
if (tomMatch1_1030 + 1 >= tom_get_size_terms_terms(tomMatch1_1023)) {
if (tomMatch1_1018 + 1 >= tom_get_size_EL_EL(tomMatch1_1013)) {
return debug("prod3xa", 
((IntExpression)tom__arg), 
tom_make_affine(tom_cons_array_terms(tom_make_term((tom_get_slot_constant_coef(tomMatch1_1033))*(tom_get_slot_term_coef(tomMatch1_1037)),tom_get_slot_term_variable(tomMatch1_1037)),tom_empty_array_terms(1)))); 
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
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_prod(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1040=tom_get_slot_prod_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1040))) {
int tomMatch1_1044=0;
if (!(tomMatch1_1044 >= tom_get_size_EL_EL(tomMatch1_1040))) {
IntExpression tomMatch1_1048=tom_get_element_EL_EL(tomMatch1_1040,tomMatch1_1044);
if (tom_is_sort_E(tomMatch1_1048)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1048))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1047=tom_get_slot_affine_terms(tomMatch1_1048);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1047))) {
int tomMatch1_1054=0;
if (!(tomMatch1_1054 >= tom_get_size_terms_terms(tomMatch1_1047))) {
org.polymodel.algebra.IntTerm tomMatch1_1061=tom_get_element_terms_terms(tomMatch1_1047,tomMatch1_1054);
if (tom_is_sort_T(tomMatch1_1061)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_1061))) {
if (tomMatch1_1054 + 1 >= tom_get_size_terms_terms(tomMatch1_1047)) {
int tomMatch1_1045=tomMatch1_1044 + 1;
if (!(tomMatch1_1045 >= tom_get_size_EL_EL(tomMatch1_1040))) {
IntExpression tomMatch1_1051=tom_get_element_EL_EL(tomMatch1_1040,tomMatch1_1045);
if (tom_is_sort_E(tomMatch1_1051)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1051))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1050=tom_get_slot_affine_terms(tomMatch1_1051);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1050))) {
int tomMatch1_1057=0;
if (!(tomMatch1_1057 >= tom_get_size_terms_terms(tomMatch1_1050))) {
org.polymodel.algebra.IntTerm tomMatch1_1064=tom_get_element_terms_terms(tomMatch1_1050,tomMatch1_1057);
if (tom_is_sort_T(tomMatch1_1064)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_1064))) {
if (tomMatch1_1057 + 1 >= tom_get_size_terms_terms(tomMatch1_1050)) {
if (tomMatch1_1045 + 1 >= tom_get_size_EL_EL(tomMatch1_1040)) {
return debug("prod3xb", 
((IntExpression)tom__arg), 
tom_make_affine(tom_cons_array_terms(tom_make_term((tom_get_slot_constant_coef(tomMatch1_1064))*(tom_get_slot_term_coef(tomMatch1_1061)),tom_get_slot_term_variable(tomMatch1_1061)),tom_empty_array_terms(1)))); 
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
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_prod(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1067=tom_get_slot_prod_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1067))) {
int tomMatch1_1071=0;
if (!(tomMatch1_1071 >= tom_get_size_EL_EL(tomMatch1_1067))) {
IntExpression tomMatch1_1075=tom_get_element_EL_EL(tomMatch1_1067,tomMatch1_1071);
if (tom_is_sort_E(tomMatch1_1075)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1075))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1074=tom_get_slot_affine_terms(tomMatch1_1075);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1074))) {
int tomMatch1_1081=0;
if (!(tomMatch1_1081 >= tom_get_size_terms_terms(tomMatch1_1074))) {
org.polymodel.algebra.IntTerm tomMatch1_1091=tom_get_element_terms_terms(tomMatch1_1074,tomMatch1_1081);
if (tom_is_sort_T(tomMatch1_1091)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_1091))) {
 long  tom_x=tom_get_slot_constant_coef(tomMatch1_1091);
if (tomMatch1_1081 + 1 >= tom_get_size_terms_terms(tomMatch1_1074)) {
int tomMatch1_1072=tomMatch1_1071 + 1;
if (!(tomMatch1_1072 >= tom_get_size_EL_EL(tomMatch1_1067))) {
IntExpression tomMatch1_1078=tom_get_element_EL_EL(tomMatch1_1067,tomMatch1_1072);
if (tom_is_sort_E(tomMatch1_1078)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1078))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1077=tom_get_slot_affine_terms(tomMatch1_1078);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1077))) {
int tomMatch1_1084=0;
int tomMatch1_end_1087=tomMatch1_1084;
do {
{
if (!(tomMatch1_end_1087 >= tom_get_size_terms_terms(tomMatch1_1077))) {
org.polymodel.algebra.IntTerm tomMatch1_1095=tom_get_element_terms_terms(tomMatch1_1077,tomMatch1_end_1087);
if (tom_is_sort_T(tomMatch1_1095)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_1095))) {
if (tomMatch1_1072 + 1 >= tom_get_size_EL_EL(tomMatch1_1067)) {
return debug("prod3xc", 
((IntExpression)tom__arg), 
tom_make_sum(tom_cons_array_EL(tom_make_prod(tom_cons_array_EL(tom_make_affine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_1077,tomMatch1_end_1087 + 1,tom_get_size_terms_terms(tomMatch1_1077)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_1077,tomMatch1_1084,tomMatch1_end_1087),tom_empty_array_terms(2)))),tom_cons_array_EL(tom_make_affine(tom_cons_array_terms(tom_make_constant(tom_x),tom_empty_array_terms(1))),tom_empty_array_EL(2)))),tom_cons_array_EL(tom_make_affine(tom_cons_array_terms(tom_make_term((tom_x)*(tom_get_slot_term_coef(tomMatch1_1095)),tom_get_slot_term_variable(tomMatch1_1095)),tom_empty_array_terms(1))),tom_empty_array_EL(2))))); 
}
}
}
}
tomMatch1_end_1087=tomMatch1_end_1087 + 1;
}
} while(!(tomMatch1_end_1087 > tom_get_size_terms_terms(tomMatch1_1077)));
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
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_prod(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1098=tom_get_slot_prod_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1098))) {
int tomMatch1_1102=0;
if (!(tomMatch1_1102 >= tom_get_size_EL_EL(tomMatch1_1098))) {
IntExpression tomMatch1_1106=tom_get_element_EL_EL(tomMatch1_1098,tomMatch1_1102);
if (tom_is_sort_E(tomMatch1_1106)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1106))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1105=tom_get_slot_affine_terms(tomMatch1_1106);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1105))) {
int tomMatch1_1112=0;
int tomMatch1_end_1115=tomMatch1_1112;
do {
{
if (!(tomMatch1_end_1115 >= tom_get_size_terms_terms(tomMatch1_1105))) {
org.polymodel.algebra.IntTerm tomMatch1_1123=tom_get_element_terms_terms(tomMatch1_1105,tomMatch1_end_1115);
if (tom_is_sort_T(tomMatch1_1123)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_1123))) {
int tomMatch1_1103=tomMatch1_1102 + 1;
if (!(tomMatch1_1103 >= tom_get_size_EL_EL(tomMatch1_1098))) {
IntExpression tomMatch1_1109=tom_get_element_EL_EL(tomMatch1_1098,tomMatch1_1103);
if (tom_is_sort_E(tomMatch1_1109)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1109))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1108=tom_get_slot_affine_terms(tomMatch1_1109);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1108))) {
int tomMatch1_1119=0;
if (!(tomMatch1_1119 >= tom_get_size_terms_terms(tomMatch1_1108))) {
org.polymodel.algebra.IntTerm tomMatch1_1126=tom_get_element_terms_terms(tomMatch1_1108,tomMatch1_1119);
if (tom_is_sort_T(tomMatch1_1126)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_1126))) {
 long  tom_x=tom_get_slot_constant_coef(tomMatch1_1126);
if (tomMatch1_1119 + 1 >= tom_get_size_terms_terms(tomMatch1_1108)) {
if (tomMatch1_1103 + 1 >= tom_get_size_EL_EL(tomMatch1_1098)) {
return debug("prod3xd", 
((IntExpression)tom__arg), 
tom_make_sum(tom_cons_array_EL(tom_make_prod(tom_cons_array_EL(tom_make_affine(tom_append_array_terms(tom_get_slice_terms(tomMatch1_1105,tomMatch1_end_1115 + 1,tom_get_size_terms_terms(tomMatch1_1105)),tom_append_array_terms(tom_get_slice_terms(tomMatch1_1105,tomMatch1_1112,tomMatch1_end_1115),tom_empty_array_terms(2)))),tom_cons_array_EL(tom_make_affine(tom_cons_array_terms(tom_make_constant(tom_x),tom_empty_array_terms(1))),tom_empty_array_EL(2)))),tom_cons_array_EL(tom_make_affine(tom_cons_array_terms(tom_make_term((tom_x)*(tom_get_slot_term_coef(tomMatch1_1123)),tom_get_slot_term_variable(tomMatch1_1123)),tom_empty_array_terms(1))),tom_empty_array_EL(2))))); 
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
tomMatch1_end_1115=tomMatch1_end_1115 + 1;
}
} while(!(tomMatch1_end_1115 > tom_get_size_terms_terms(tomMatch1_1105)));
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
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_prod(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1129=tom_get_slot_prod_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1129))) {
int tomMatch1_1133=0;
int tomMatch1_end_1136=tomMatch1_1133;
do {
{
if (!(tomMatch1_end_1136 >= tom_get_size_EL_EL(tomMatch1_1129))) {
IntExpression tomMatch1_1144=tom_get_element_EL_EL(tomMatch1_1129,tomMatch1_end_1136);
if (tom_is_sort_E(tomMatch1_1144)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1144))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1143=tom_get_slot_affine_terms(tomMatch1_1144);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1143))) {
int tomMatch1_1150=0;
if (!(tomMatch1_1150 >= tom_get_size_terms_terms(tomMatch1_1143))) {
org.polymodel.algebra.IntTerm tomMatch1_1156=tom_get_element_terms_terms(tomMatch1_1143,tomMatch1_1150);
if (tom_is_sort_T(tomMatch1_1156)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_1156))) {
if (tomMatch1_1150 + 1 >= tom_get_size_terms_terms(tomMatch1_1143)) {
int tomMatch1_1137=tomMatch1_end_1136 + 1;
int tomMatch1_end_1140=tomMatch1_1137;
do {
{
if (!(tomMatch1_end_1140 >= tom_get_size_EL_EL(tomMatch1_1129))) {
IntExpression tomMatch1_1147=tom_get_element_EL_EL(tomMatch1_1129,tomMatch1_end_1140);
if (tom_is_sort_E(tomMatch1_1147)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1147))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1146=tom_get_slot_affine_terms(tomMatch1_1147);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1146))) {
int tomMatch1_1153=0;
if (!(tomMatch1_1153 >= tom_get_size_terms_terms(tomMatch1_1146))) {
org.polymodel.algebra.IntTerm tomMatch1_1159=tom_get_element_terms_terms(tomMatch1_1146,tomMatch1_1153);
if (tom_is_sort_T(tomMatch1_1159)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_1159))) {
if (tomMatch1_1153 + 1 >= tom_get_size_terms_terms(tomMatch1_1146)) {
return debug("prod4", 
((IntExpression)tom__arg), 
tom_make_prod(tom_append_array_EL(tom_get_slice_EL(tomMatch1_1129,tomMatch1_end_1140 + 1,tom_get_size_EL_EL(tomMatch1_1129)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_1129,tomMatch1_1137,tomMatch1_end_1140),tom_append_array_EL(tom_get_slice_EL(tomMatch1_1129,tomMatch1_1133,tomMatch1_end_1136),tom_cons_array_EL(tom_make_affine(tom_cons_array_terms(tom_make_constant((tom_get_slot_constant_coef(tomMatch1_1156))*(tom_get_slot_constant_coef(tomMatch1_1159))),tom_empty_array_terms(1))),tom_empty_array_EL(4))))))); 
}
}
}
}
}
}
}
}
tomMatch1_end_1140=tomMatch1_end_1140 + 1;
}
} while(!(tomMatch1_end_1140 > tom_get_size_EL_EL(tomMatch1_1129)));
}
}
}
}
}
}
}
}
tomMatch1_end_1136=tomMatch1_end_1136 + 1;
}
} while(!(tomMatch1_end_1136 > tom_get_size_EL_EL(tomMatch1_1129)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_prod(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1162=tom_get_slot_prod_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1162))) {
if (0 >= tom_get_size_EL_EL(tomMatch1_1162)) {
return debug("prod5", 
((IntExpression)tom__arg), 
tom_make_affine(tom_cons_array_terms(tom_make_constant(0),tom_empty_array_terms(1)))); 
}
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_min(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1168=tom_get_slot_min_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1168))) {
int tomMatch1_1172=0;
if (!(tomMatch1_1172 >= tom_get_size_EL_EL(tomMatch1_1168))) {
if (tomMatch1_1172 + 1 >= tom_get_size_EL_EL(tomMatch1_1168)) {
return debug("min0", 
((IntExpression)tom__arg), 
tom_get_element_EL_EL(tomMatch1_1168,tomMatch1_1172)); 
}
}
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_min(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1175=tom_get_slot_min_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1175))) {
if (0 >= tom_get_size_EL_EL(tomMatch1_1175)) {
return debug("min1", 
((IntExpression)tom__arg), 
tom_make_affine(tom_cons_array_terms(tom_make_constant(0),tom_empty_array_terms(1)))); 
}
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_min(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1181=tom_get_slot_min_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1181))) {
int tomMatch1_1185=0;
int tomMatch1_end_1188=tomMatch1_1185;
do {
{
if (!(tomMatch1_end_1188 >= tom_get_size_EL_EL(tomMatch1_1181))) {
IntExpression tom_a=tom_get_element_EL_EL(tomMatch1_1181,tomMatch1_end_1188);
int tomMatch1_1189=tomMatch1_end_1188 + 1;
int tomMatch1_end_1192=tomMatch1_1189;
do {
{
if (!(tomMatch1_end_1192 >= tom_get_size_EL_EL(tomMatch1_1181))) {
if (tom_equal_term_E(tom_a, tom_get_element_EL_EL(tomMatch1_1181,tomMatch1_end_1192))) {
return debug("min2", 
((IntExpression)tom__arg), 
tom_make_min(tom_append_array_EL(tom_get_slice_EL(tomMatch1_1181,tomMatch1_end_1192 + 1,tom_get_size_EL_EL(tomMatch1_1181)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_1181,tomMatch1_1189,tomMatch1_end_1192),tom_append_array_EL(tom_get_slice_EL(tomMatch1_1181,tomMatch1_1185,tomMatch1_end_1188),tom_cons_array_EL(tom_a,tom_empty_array_EL(4))))))); 
}
}
tomMatch1_end_1192=tomMatch1_end_1192 + 1;
}
} while(!(tomMatch1_end_1192 > tom_get_size_EL_EL(tomMatch1_1181)));
}
tomMatch1_end_1188=tomMatch1_end_1188 + 1;
}
} while(!(tomMatch1_end_1188 > tom_get_size_EL_EL(tomMatch1_1181)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_min(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1197=tom_get_slot_min_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1197))) {
int tomMatch1_1201=0;
if (!(tomMatch1_1201 >= tom_get_size_EL_EL(tomMatch1_1197))) {
int tomMatch1_1202=tomMatch1_1201 + 1;
if (!(tomMatch1_1202 >= tom_get_size_EL_EL(tomMatch1_1197))) {
IntExpression tomMatch1_1206=tom_get_element_EL_EL(tomMatch1_1197,tomMatch1_1202);
if (tom_is_sort_E(tomMatch1_1206)) {
if (tom_is_fun_sym_min(((IntExpression)tomMatch1_1206))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1205=tom_get_slot_min_expressions(tomMatch1_1206);
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1205))) {
return debug("min3a", 
((IntExpression)tom__arg), 
tom_make_min(tom_append_array_EL(tom_get_slice_EL(tomMatch1_1197,tomMatch1_1202 + 1,tom_get_size_EL_EL(tomMatch1_1197)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_1205,0,tom_get_size_EL_EL(tomMatch1_1205)),tom_cons_array_EL(tom_get_element_EL_EL(tomMatch1_1197,tomMatch1_1201),tom_empty_array_EL(3)))))); 
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
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_min(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1212=tom_get_slot_min_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1212))) {
int tomMatch1_1216=0;
int tomMatch1_end_1219=tomMatch1_1216;
do {
{
if (!(tomMatch1_end_1219 >= tom_get_size_EL_EL(tomMatch1_1212))) {
IntExpression tomMatch1_1223=tom_get_element_EL_EL(tomMatch1_1212,tomMatch1_end_1219);
if (tom_is_sort_E(tomMatch1_1223)) {
if (tom_is_fun_sym_min(((IntExpression)tomMatch1_1223))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1222=tom_get_slot_min_expressions(tomMatch1_1223);
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1222))) {
int tomMatch1_1220=tomMatch1_end_1219 + 1;
if (!(tomMatch1_1220 >= tom_get_size_EL_EL(tomMatch1_1212))) {
if (tomMatch1_1220 + 1 >= tom_get_size_EL_EL(tomMatch1_1212)) {
return debug("min3b", 
((IntExpression)tom__arg), 
tom_make_min(tom_cons_array_EL(tom_get_element_EL_EL(tomMatch1_1212,tomMatch1_1220),tom_append_array_EL(tom_get_slice_EL(tomMatch1_1222,0,tom_get_size_EL_EL(tomMatch1_1222)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_1212,tomMatch1_1216,tomMatch1_end_1219),tom_empty_array_EL(3)))))); 
}
}
}
}
}
}
tomMatch1_end_1219=tomMatch1_end_1219 + 1;
}
} while(!(tomMatch1_end_1219 > tom_get_size_EL_EL(tomMatch1_1212)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_min(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1229=tom_get_slot_min_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1229))) {
int tomMatch1_1233=0;
int tomMatch1_end_1236=tomMatch1_1233;
do {
{
if (!(tomMatch1_end_1236 >= tom_get_size_EL_EL(tomMatch1_1229))) {
IntExpression tomMatch1_1244=tom_get_element_EL_EL(tomMatch1_1229,tomMatch1_end_1236);
if (tom_is_sort_E(tomMatch1_1244)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1244))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1243=tom_get_slot_affine_terms(tomMatch1_1244);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1243))) {
int tomMatch1_1250=0;
if (!(tomMatch1_1250 >= tom_get_size_terms_terms(tomMatch1_1243))) {
org.polymodel.algebra.IntTerm tomMatch1_1256=tom_get_element_terms_terms(tomMatch1_1243,tomMatch1_1250);
if (tom_is_sort_T(tomMatch1_1256)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_1256))) {
if (tomMatch1_1250 + 1 >= tom_get_size_terms_terms(tomMatch1_1243)) {
int tomMatch1_1237=tomMatch1_end_1236 + 1;
int tomMatch1_end_1240=tomMatch1_1237;
do {
{
if (!(tomMatch1_end_1240 >= tom_get_size_EL_EL(tomMatch1_1229))) {
IntExpression tomMatch1_1247=tom_get_element_EL_EL(tomMatch1_1229,tomMatch1_end_1240);
if (tom_is_sort_E(tomMatch1_1247)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1247))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1246=tom_get_slot_affine_terms(tomMatch1_1247);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1246))) {
int tomMatch1_1253=0;
if (!(tomMatch1_1253 >= tom_get_size_terms_terms(tomMatch1_1246))) {
org.polymodel.algebra.IntTerm tomMatch1_1259=tom_get_element_terms_terms(tomMatch1_1246,tomMatch1_1253);
if (tom_is_sort_T(tomMatch1_1259)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_1259))) {
if (tomMatch1_1253 + 1 >= tom_get_size_terms_terms(tomMatch1_1246)) {
return debug("min4", 
((IntExpression)tom__arg), 
tom_make_min(tom_append_array_EL(tom_get_slice_EL(tomMatch1_1229,tomMatch1_end_1240 + 1,tom_get_size_EL_EL(tomMatch1_1229)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_1229,tomMatch1_1237,tomMatch1_end_1240),tom_append_array_EL(tom_get_slice_EL(tomMatch1_1229,tomMatch1_1233,tomMatch1_end_1236),tom_cons_array_EL(tom_make_affine(tom_cons_array_terms(tom_make_constant(Math_min(tom_get_slot_constant_coef(tomMatch1_1256),tom_get_slot_constant_coef(tomMatch1_1259))),tom_empty_array_terms(1))),tom_empty_array_EL(4))))))); 
}
}
}
}
}
}
}
}
tomMatch1_end_1240=tomMatch1_end_1240 + 1;
}
} while(!(tomMatch1_end_1240 > tom_get_size_EL_EL(tomMatch1_1229)));
}
}
}
}
}
}
}
}
tomMatch1_end_1236=tomMatch1_end_1236 + 1;
}
} while(!(tomMatch1_end_1236 > tom_get_size_EL_EL(tomMatch1_1229)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_min(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1262=tom_get_slot_min_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1262))) {
int tomMatch1_1266=0;
int tomMatch1_end_1269=tomMatch1_1266;
do {
{
 EList<org.polymodel.algebra.IntExpression>  tom_x1=tom_get_slice_EL(tomMatch1_1262,tomMatch1_1266,tomMatch1_end_1269);
if (!(tomMatch1_end_1269 >= tom_get_size_EL_EL(tomMatch1_1262))) {
IntExpression tomMatch1_1277=tom_get_element_EL_EL(tomMatch1_1262,tomMatch1_end_1269);
if (tom_is_sort_E(tomMatch1_1277)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1277))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1276=tom_get_slot_affine_terms(tomMatch1_1277);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1276))) {
int tomMatch1_1283=0;
if (!(tomMatch1_1283 >= tom_get_size_terms_terms(tomMatch1_1276))) {
org.polymodel.algebra.IntTerm tomMatch1_1292=tom_get_element_terms_terms(tomMatch1_1276,tomMatch1_1283);
if (tom_is_sort_T(tomMatch1_1292)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_1292))) {
int tomMatch1_1284=tomMatch1_1283 + 1;
if (!(tomMatch1_1284 >= tom_get_size_terms_terms(tomMatch1_1276))) {
org.polymodel.algebra.IntTerm tomMatch1_1295=tom_get_element_terms_terms(tomMatch1_1276,tomMatch1_1284);
if (tom_is_sort_T(tomMatch1_1295)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_1295))) {
if (tomMatch1_1284 + 1 >= tom_get_size_terms_terms(tomMatch1_1276)) {
int tomMatch1_1270=tomMatch1_end_1269 + 1;
int tomMatch1_end_1273=tomMatch1_1270;
do {
{
 EList<org.polymodel.algebra.IntExpression>  tom_x2=tom_get_slice_EL(tomMatch1_1262,tomMatch1_1270,tomMatch1_end_1273);
if (!(tomMatch1_end_1273 >= tom_get_size_EL_EL(tomMatch1_1262))) {
IntExpression tomMatch1_1280=tom_get_element_EL_EL(tomMatch1_1262,tomMatch1_end_1273);
if (tom_is_sort_E(tomMatch1_1280)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1280))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1279=tom_get_slot_affine_terms(tomMatch1_1280);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1279))) {
int tomMatch1_1287=0;
if (!(tomMatch1_1287 >= tom_get_size_terms_terms(tomMatch1_1279))) {
org.polymodel.algebra.IntTerm tomMatch1_1299=tom_get_element_terms_terms(tomMatch1_1279,tomMatch1_1287);
if (tom_is_sort_T(tomMatch1_1299)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_1299))) {
if (tom_equal_term_long(tom_get_slot_term_coef(tomMatch1_1292), tom_get_slot_term_coef(tomMatch1_1299))) {
if (tom_equal_term_V(tom_get_slot_term_variable(tomMatch1_1292), tom_get_slot_term_variable(tomMatch1_1299))) {
int tomMatch1_1288=tomMatch1_1287 + 1;
if (!(tomMatch1_1288 >= tom_get_size_terms_terms(tomMatch1_1279))) {
org.polymodel.algebra.IntTerm tomMatch1_1302=tom_get_element_terms_terms(tomMatch1_1279,tomMatch1_1288);
if (tom_is_sort_T(tomMatch1_1302)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_1302))) {
if (tomMatch1_1288 + 1 >= tom_get_size_terms_terms(tomMatch1_1279)) {
 EList<org.polymodel.algebra.IntExpression>  tom_x3=tom_get_slice_EL(tomMatch1_1262,tomMatch1_end_1273 + 1,tom_get_size_EL_EL(tomMatch1_1262));
IntExpression tom_in=((IntExpression)tom__arg);

if (
tom_get_slot_constant_coef(tomMatch1_1295)<
tom_get_slot_constant_coef(tomMatch1_1302)) { return  debug("min5a", 
tom_in, 
tom_make_min(tom_append_array_EL(tom_x3,tom_append_array_EL(tom_x2,tom_append_array_EL(tom_x1,tom_cons_array_EL(tom_get_element_EL_EL(tomMatch1_1262,tomMatch1_end_1269),tom_empty_array_EL(4))))))); } else
{ return  debug("min5b", 
tom_in, 
tom_make_min(tom_append_array_EL(tom_x3,tom_append_array_EL(tom_x2,tom_append_array_EL(tom_x1,tom_cons_array_EL(tom_get_element_EL_EL(tomMatch1_1262,tomMatch1_end_1273),tom_empty_array_EL(4))))))); }

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
tomMatch1_end_1273=tomMatch1_end_1273 + 1;
}
} while(!(tomMatch1_end_1273 > tom_get_size_EL_EL(tomMatch1_1262)));
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
tomMatch1_end_1269=tomMatch1_end_1269 + 1;
}
} while(!(tomMatch1_end_1269 > tom_get_size_EL_EL(tomMatch1_1262)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_min(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1307=tom_get_slot_min_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1307))) {
int tomMatch1_1311=0;
int tomMatch1_end_1314=tomMatch1_1311;
do {
{
 EList<org.polymodel.algebra.IntExpression>  tom_x1=tom_get_slice_EL(tomMatch1_1307,tomMatch1_1311,tomMatch1_end_1314);
if (!(tomMatch1_end_1314 >= tom_get_size_EL_EL(tomMatch1_1307))) {
IntExpression tomMatch1_1322=tom_get_element_EL_EL(tomMatch1_1307,tomMatch1_end_1314);
if (tom_is_sort_E(tomMatch1_1322)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1322))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1321=tom_get_slot_affine_terms(tomMatch1_1322);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1321))) {
int tomMatch1_1328=0;
if (!(tomMatch1_1328 >= tom_get_size_terms_terms(tomMatch1_1321))) {
org.polymodel.algebra.IntTerm tomMatch1_1336=tom_get_element_terms_terms(tomMatch1_1321,tomMatch1_1328);
if (tom_is_sort_T(tomMatch1_1336)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_1336))) {
if (tomMatch1_1328 + 1 >= tom_get_size_terms_terms(tomMatch1_1321)) {
int tomMatch1_1315=tomMatch1_end_1314 + 1;
int tomMatch1_end_1318=tomMatch1_1315;
do {
{
 EList<org.polymodel.algebra.IntExpression>  tom_x2=tom_get_slice_EL(tomMatch1_1307,tomMatch1_1315,tomMatch1_end_1318);
if (!(tomMatch1_end_1318 >= tom_get_size_EL_EL(tomMatch1_1307))) {
IntExpression tomMatch1_1325=tom_get_element_EL_EL(tomMatch1_1307,tomMatch1_end_1318);
if (tom_is_sort_E(tomMatch1_1325)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1325))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1324=tom_get_slot_affine_terms(tomMatch1_1325);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1324))) {
int tomMatch1_1331=0;
if (!(tomMatch1_1331 >= tom_get_size_terms_terms(tomMatch1_1324))) {
org.polymodel.algebra.IntTerm tomMatch1_1340=tom_get_element_terms_terms(tomMatch1_1324,tomMatch1_1331);
if (tom_is_sort_T(tomMatch1_1340)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_1340))) {
if (tom_equal_term_long(tom_get_slot_term_coef(tomMatch1_1336), tom_get_slot_term_coef(tomMatch1_1340))) {
if (tom_equal_term_V(tom_get_slot_term_variable(tomMatch1_1336), tom_get_slot_term_variable(tomMatch1_1340))) {
int tomMatch1_1332=tomMatch1_1331 + 1;
if (!(tomMatch1_1332 >= tom_get_size_terms_terms(tomMatch1_1324))) {
org.polymodel.algebra.IntTerm tomMatch1_1343=tom_get_element_terms_terms(tomMatch1_1324,tomMatch1_1332);
if (tom_is_sort_T(tomMatch1_1343)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_1343))) {
if (tomMatch1_1332 + 1 >= tom_get_size_terms_terms(tomMatch1_1324)) {
 EList<org.polymodel.algebra.IntExpression>  tom_x3=tom_get_slice_EL(tomMatch1_1307,tomMatch1_end_1318 + 1,tom_get_size_EL_EL(tomMatch1_1307));
IntExpression tom_in=((IntExpression)tom__arg);

if (
tom_get_slot_constant_coef(tomMatch1_1343)<0) { return  debug("min6b", 
tom_in, 
tom_make_min(tom_append_array_EL(tom_x3,tom_append_array_EL(tom_x2,tom_append_array_EL(tom_x1,tom_cons_array_EL(tom_get_element_EL_EL(tomMatch1_1307,tomMatch1_end_1318),tom_empty_array_EL(4))))))); } else
{ return  debug("min6a", 
tom_in, 
tom_make_min(tom_append_array_EL(tom_x3,tom_append_array_EL(tom_x2,tom_append_array_EL(tom_x1,tom_cons_array_EL(tom_get_element_EL_EL(tomMatch1_1307,tomMatch1_end_1314),tom_empty_array_EL(4))))))); }

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
tomMatch1_end_1318=tomMatch1_end_1318 + 1;
}
} while(!(tomMatch1_end_1318 > tom_get_size_EL_EL(tomMatch1_1307)));
}
}
}
}
}
}
}
}
tomMatch1_end_1314=tomMatch1_end_1314 + 1;
}
} while(!(tomMatch1_end_1314 > tom_get_size_EL_EL(tomMatch1_1307)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_max(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1348=tom_get_slot_max_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1348))) {
int tomMatch1_1352=0;
if (!(tomMatch1_1352 >= tom_get_size_EL_EL(tomMatch1_1348))) {
if (tomMatch1_1352 + 1 >= tom_get_size_EL_EL(tomMatch1_1348)) {
return debug("max0", 
((IntExpression)tom__arg), 
tom_get_element_EL_EL(tomMatch1_1348,tomMatch1_1352)); 
}
}
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_max(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1355=tom_get_slot_max_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1355))) {
if (0 >= tom_get_size_EL_EL(tomMatch1_1355)) {
return debug("max1", 
((IntExpression)tom__arg), 
tom_make_affine(tom_cons_array_terms(tom_make_constant(0),tom_empty_array_terms(1)))); 
}
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_max(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1361=tom_get_slot_max_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1361))) {
int tomMatch1_1365=0;
int tomMatch1_end_1368=tomMatch1_1365;
do {
{
if (!(tomMatch1_end_1368 >= tom_get_size_EL_EL(tomMatch1_1361))) {
IntExpression tom_a=tom_get_element_EL_EL(tomMatch1_1361,tomMatch1_end_1368);
int tomMatch1_1369=tomMatch1_end_1368 + 1;
int tomMatch1_end_1372=tomMatch1_1369;
do {
{
if (!(tomMatch1_end_1372 >= tom_get_size_EL_EL(tomMatch1_1361))) {
if (tom_equal_term_E(tom_a, tom_get_element_EL_EL(tomMatch1_1361,tomMatch1_end_1372))) {
return debug("max2", 
((IntExpression)tom__arg), 
tom_make_max(tom_append_array_EL(tom_get_slice_EL(tomMatch1_1361,tomMatch1_end_1372 + 1,tom_get_size_EL_EL(tomMatch1_1361)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_1361,tomMatch1_1369,tomMatch1_end_1372),tom_append_array_EL(tom_get_slice_EL(tomMatch1_1361,tomMatch1_1365,tomMatch1_end_1368),tom_cons_array_EL(tom_a,tom_empty_array_EL(4))))))); 
}
}
tomMatch1_end_1372=tomMatch1_end_1372 + 1;
}
} while(!(tomMatch1_end_1372 > tom_get_size_EL_EL(tomMatch1_1361)));
}
tomMatch1_end_1368=tomMatch1_end_1368 + 1;
}
} while(!(tomMatch1_end_1368 > tom_get_size_EL_EL(tomMatch1_1361)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_max(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1377=tom_get_slot_max_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1377))) {
int tomMatch1_1381=0;
if (!(tomMatch1_1381 >= tom_get_size_EL_EL(tomMatch1_1377))) {
int tomMatch1_1382=tomMatch1_1381 + 1;
if (!(tomMatch1_1382 >= tom_get_size_EL_EL(tomMatch1_1377))) {
IntExpression tomMatch1_1386=tom_get_element_EL_EL(tomMatch1_1377,tomMatch1_1382);
if (tom_is_sort_E(tomMatch1_1386)) {
if (tom_is_fun_sym_max(((IntExpression)tomMatch1_1386))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1385=tom_get_slot_max_expressions(tomMatch1_1386);
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1385))) {
return debug("max3a", 
((IntExpression)tom__arg), 
tom_make_max(tom_append_array_EL(tom_get_slice_EL(tomMatch1_1377,tomMatch1_1382 + 1,tom_get_size_EL_EL(tomMatch1_1377)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_1385,0,tom_get_size_EL_EL(tomMatch1_1385)),tom_cons_array_EL(tom_get_element_EL_EL(tomMatch1_1377,tomMatch1_1381),tom_empty_array_EL(3)))))); 
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
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_max(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1392=tom_get_slot_max_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1392))) {
int tomMatch1_1396=0;
int tomMatch1_end_1399=tomMatch1_1396;
do {
{
if (!(tomMatch1_end_1399 >= tom_get_size_EL_EL(tomMatch1_1392))) {
IntExpression tomMatch1_1403=tom_get_element_EL_EL(tomMatch1_1392,tomMatch1_end_1399);
if (tom_is_sort_E(tomMatch1_1403)) {
if (tom_is_fun_sym_max(((IntExpression)tomMatch1_1403))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1402=tom_get_slot_max_expressions(tomMatch1_1403);
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1402))) {
int tomMatch1_1400=tomMatch1_end_1399 + 1;
if (!(tomMatch1_1400 >= tom_get_size_EL_EL(tomMatch1_1392))) {
if (tomMatch1_1400 + 1 >= tom_get_size_EL_EL(tomMatch1_1392)) {
return debug("max3b", 
((IntExpression)tom__arg), 
tom_make_max(tom_cons_array_EL(tom_get_element_EL_EL(tomMatch1_1392,tomMatch1_1400),tom_append_array_EL(tom_get_slice_EL(tomMatch1_1402,0,tom_get_size_EL_EL(tomMatch1_1402)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_1392,tomMatch1_1396,tomMatch1_end_1399),tom_empty_array_EL(3)))))); 
}
}
}
}
}
}
tomMatch1_end_1399=tomMatch1_end_1399 + 1;
}
} while(!(tomMatch1_end_1399 > tom_get_size_EL_EL(tomMatch1_1392)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_max(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1409=tom_get_slot_max_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1409))) {
int tomMatch1_1413=0;
int tomMatch1_end_1416=tomMatch1_1413;
do {
{
if (!(tomMatch1_end_1416 >= tom_get_size_EL_EL(tomMatch1_1409))) {
IntExpression tomMatch1_1424=tom_get_element_EL_EL(tomMatch1_1409,tomMatch1_end_1416);
if (tom_is_sort_E(tomMatch1_1424)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1424))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1423=tom_get_slot_affine_terms(tomMatch1_1424);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1423))) {
int tomMatch1_1430=0;
if (!(tomMatch1_1430 >= tom_get_size_terms_terms(tomMatch1_1423))) {
org.polymodel.algebra.IntTerm tomMatch1_1436=tom_get_element_terms_terms(tomMatch1_1423,tomMatch1_1430);
if (tom_is_sort_T(tomMatch1_1436)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_1436))) {
if (tomMatch1_1430 + 1 >= tom_get_size_terms_terms(tomMatch1_1423)) {
int tomMatch1_1417=tomMatch1_end_1416 + 1;
int tomMatch1_end_1420=tomMatch1_1417;
do {
{
if (!(tomMatch1_end_1420 >= tom_get_size_EL_EL(tomMatch1_1409))) {
IntExpression tomMatch1_1427=tom_get_element_EL_EL(tomMatch1_1409,tomMatch1_end_1420);
if (tom_is_sort_E(tomMatch1_1427)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1427))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1426=tom_get_slot_affine_terms(tomMatch1_1427);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1426))) {
int tomMatch1_1433=0;
if (!(tomMatch1_1433 >= tom_get_size_terms_terms(tomMatch1_1426))) {
org.polymodel.algebra.IntTerm tomMatch1_1439=tom_get_element_terms_terms(tomMatch1_1426,tomMatch1_1433);
if (tom_is_sort_T(tomMatch1_1439)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_1439))) {
if (tomMatch1_1433 + 1 >= tom_get_size_terms_terms(tomMatch1_1426)) {
return debug("max4", 
((IntExpression)tom__arg), 
tom_make_max(tom_append_array_EL(tom_get_slice_EL(tomMatch1_1409,tomMatch1_end_1420 + 1,tom_get_size_EL_EL(tomMatch1_1409)),tom_append_array_EL(tom_get_slice_EL(tomMatch1_1409,tomMatch1_1417,tomMatch1_end_1420),tom_append_array_EL(tom_get_slice_EL(tomMatch1_1409,tomMatch1_1413,tomMatch1_end_1416),tom_cons_array_EL(tom_make_affine(tom_cons_array_terms(tom_make_constant(Math_max(tom_get_slot_constant_coef(tomMatch1_1436),tom_get_slot_constant_coef(tomMatch1_1439))),tom_empty_array_terms(1))),tom_empty_array_EL(4))))))); 
}
}
}
}
}
}
}
}
tomMatch1_end_1420=tomMatch1_end_1420 + 1;
}
} while(!(tomMatch1_end_1420 > tom_get_size_EL_EL(tomMatch1_1409)));
}
}
}
}
}
}
}
}
tomMatch1_end_1416=tomMatch1_end_1416 + 1;
}
} while(!(tomMatch1_end_1416 > tom_get_size_EL_EL(tomMatch1_1409)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_max(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1442=tom_get_slot_max_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1442))) {
int tomMatch1_1446=0;
int tomMatch1_end_1449=tomMatch1_1446;
do {
{
 EList<org.polymodel.algebra.IntExpression>  tom_x1=tom_get_slice_EL(tomMatch1_1442,tomMatch1_1446,tomMatch1_end_1449);
if (!(tomMatch1_end_1449 >= tom_get_size_EL_EL(tomMatch1_1442))) {
IntExpression tomMatch1_1457=tom_get_element_EL_EL(tomMatch1_1442,tomMatch1_end_1449);
if (tom_is_sort_E(tomMatch1_1457)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1457))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1456=tom_get_slot_affine_terms(tomMatch1_1457);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1456))) {
int tomMatch1_1463=0;
if (!(tomMatch1_1463 >= tom_get_size_terms_terms(tomMatch1_1456))) {
org.polymodel.algebra.IntTerm tomMatch1_1472=tom_get_element_terms_terms(tomMatch1_1456,tomMatch1_1463);
if (tom_is_sort_T(tomMatch1_1472)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_1472))) {
int tomMatch1_1464=tomMatch1_1463 + 1;
if (!(tomMatch1_1464 >= tom_get_size_terms_terms(tomMatch1_1456))) {
org.polymodel.algebra.IntTerm tomMatch1_1475=tom_get_element_terms_terms(tomMatch1_1456,tomMatch1_1464);
if (tom_is_sort_T(tomMatch1_1475)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_1475))) {
if (tomMatch1_1464 + 1 >= tom_get_size_terms_terms(tomMatch1_1456)) {
int tomMatch1_1450=tomMatch1_end_1449 + 1;
int tomMatch1_end_1453=tomMatch1_1450;
do {
{
 EList<org.polymodel.algebra.IntExpression>  tom_x2=tom_get_slice_EL(tomMatch1_1442,tomMatch1_1450,tomMatch1_end_1453);
if (!(tomMatch1_end_1453 >= tom_get_size_EL_EL(tomMatch1_1442))) {
IntExpression tomMatch1_1460=tom_get_element_EL_EL(tomMatch1_1442,tomMatch1_end_1453);
if (tom_is_sort_E(tomMatch1_1460)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1460))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1459=tom_get_slot_affine_terms(tomMatch1_1460);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1459))) {
int tomMatch1_1467=0;
if (!(tomMatch1_1467 >= tom_get_size_terms_terms(tomMatch1_1459))) {
org.polymodel.algebra.IntTerm tomMatch1_1479=tom_get_element_terms_terms(tomMatch1_1459,tomMatch1_1467);
if (tom_is_sort_T(tomMatch1_1479)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_1479))) {
if (tom_equal_term_long(tom_get_slot_term_coef(tomMatch1_1472), tom_get_slot_term_coef(tomMatch1_1479))) {
if (tom_equal_term_V(tom_get_slot_term_variable(tomMatch1_1472), tom_get_slot_term_variable(tomMatch1_1479))) {
int tomMatch1_1468=tomMatch1_1467 + 1;
if (!(tomMatch1_1468 >= tom_get_size_terms_terms(tomMatch1_1459))) {
org.polymodel.algebra.IntTerm tomMatch1_1482=tom_get_element_terms_terms(tomMatch1_1459,tomMatch1_1468);
if (tom_is_sort_T(tomMatch1_1482)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_1482))) {
if (tomMatch1_1468 + 1 >= tom_get_size_terms_terms(tomMatch1_1459)) {
 EList<org.polymodel.algebra.IntExpression>  tom_x3=tom_get_slice_EL(tomMatch1_1442,tomMatch1_end_1453 + 1,tom_get_size_EL_EL(tomMatch1_1442));
IntExpression tom_in=((IntExpression)tom__arg);

if (
tom_get_slot_constant_coef(tomMatch1_1475)>
tom_get_slot_constant_coef(tomMatch1_1482)) { return  debug("max5a", 
tom_in, 
tom_make_max(tom_append_array_EL(tom_x3,tom_append_array_EL(tom_x2,tom_append_array_EL(tom_x1,tom_cons_array_EL(tom_get_element_EL_EL(tomMatch1_1442,tomMatch1_end_1449),tom_empty_array_EL(4))))))); } else
{ return  debug("max5b", 
tom_in, 
tom_make_max(tom_append_array_EL(tom_x3,tom_append_array_EL(tom_x2,tom_append_array_EL(tom_x1,tom_cons_array_EL(tom_get_element_EL_EL(tomMatch1_1442,tomMatch1_end_1453),tom_empty_array_EL(4))))))); }

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
tomMatch1_end_1453=tomMatch1_end_1453 + 1;
}
} while(!(tomMatch1_end_1453 > tom_get_size_EL_EL(tomMatch1_1442)));
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
tomMatch1_end_1449=tomMatch1_end_1449 + 1;
}
} while(!(tomMatch1_end_1449 > tom_get_size_EL_EL(tomMatch1_1442)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_max(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1487=tom_get_slot_max_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1487))) {
int tomMatch1_1491=0;
int tomMatch1_end_1494=tomMatch1_1491;
do {
{
 EList<org.polymodel.algebra.IntExpression>  tom_x1=tom_get_slice_EL(tomMatch1_1487,tomMatch1_1491,tomMatch1_end_1494);
if (!(tomMatch1_end_1494 >= tom_get_size_EL_EL(tomMatch1_1487))) {
IntExpression tomMatch1_1502=tom_get_element_EL_EL(tomMatch1_1487,tomMatch1_end_1494);
if (tom_is_sort_E(tomMatch1_1502)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1502))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1501=tom_get_slot_affine_terms(tomMatch1_1502);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1501))) {
int tomMatch1_1508=0;
if (!(tomMatch1_1508 >= tom_get_size_terms_terms(tomMatch1_1501))) {
org.polymodel.algebra.IntTerm tomMatch1_1516=tom_get_element_terms_terms(tomMatch1_1501,tomMatch1_1508);
if (tom_is_sort_T(tomMatch1_1516)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_1516))) {
if (tomMatch1_1508 + 1 >= tom_get_size_terms_terms(tomMatch1_1501)) {
int tomMatch1_1495=tomMatch1_end_1494 + 1;
int tomMatch1_end_1498=tomMatch1_1495;
do {
{
 EList<org.polymodel.algebra.IntExpression>  tom_x2=tom_get_slice_EL(tomMatch1_1487,tomMatch1_1495,tomMatch1_end_1498);
if (!(tomMatch1_end_1498 >= tom_get_size_EL_EL(tomMatch1_1487))) {
IntExpression tomMatch1_1505=tom_get_element_EL_EL(tomMatch1_1487,tomMatch1_end_1498);
if (tom_is_sort_E(tomMatch1_1505)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1505))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1504=tom_get_slot_affine_terms(tomMatch1_1505);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1504))) {
int tomMatch1_1511=0;
if (!(tomMatch1_1511 >= tom_get_size_terms_terms(tomMatch1_1504))) {
org.polymodel.algebra.IntTerm tomMatch1_1520=tom_get_element_terms_terms(tomMatch1_1504,tomMatch1_1511);
if (tom_is_sort_T(tomMatch1_1520)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_1520))) {
if (tom_equal_term_long(tom_get_slot_term_coef(tomMatch1_1516), tom_get_slot_term_coef(tomMatch1_1520))) {
if (tom_equal_term_V(tom_get_slot_term_variable(tomMatch1_1516), tom_get_slot_term_variable(tomMatch1_1520))) {
int tomMatch1_1512=tomMatch1_1511 + 1;
if (!(tomMatch1_1512 >= tom_get_size_terms_terms(tomMatch1_1504))) {
org.polymodel.algebra.IntTerm tomMatch1_1523=tom_get_element_terms_terms(tomMatch1_1504,tomMatch1_1512);
if (tom_is_sort_T(tomMatch1_1523)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_1523))) {
if (tomMatch1_1512 + 1 >= tom_get_size_terms_terms(tomMatch1_1504)) {
 EList<org.polymodel.algebra.IntExpression>  tom_x3=tom_get_slice_EL(tomMatch1_1487,tomMatch1_end_1498 + 1,tom_get_size_EL_EL(tomMatch1_1487));
IntExpression tom_in=((IntExpression)tom__arg);

if (
tom_get_slot_constant_coef(tomMatch1_1523)>0) { return  debug("max6b", 
tom_in, 
tom_make_max(tom_append_array_EL(tom_x3,tom_append_array_EL(tom_x2,tom_append_array_EL(tom_x1,tom_cons_array_EL(tom_get_element_EL_EL(tomMatch1_1487,tomMatch1_end_1498),tom_empty_array_EL(4))))))); } else
{ return  debug("max6a", 
tom_in, 
tom_make_max(tom_append_array_EL(tom_x3,tom_append_array_EL(tom_x2,tom_append_array_EL(tom_x1,tom_cons_array_EL(tom_get_element_EL_EL(tomMatch1_1487,tomMatch1_end_1494),tom_empty_array_EL(4))))))); }

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
tomMatch1_end_1498=tomMatch1_end_1498 + 1;
}
} while(!(tomMatch1_end_1498 > tom_get_size_EL_EL(tomMatch1_1487)));
}
}
}
}
}
}
}
}
tomMatch1_end_1494=tomMatch1_end_1494 + 1;
}
} while(!(tomMatch1_end_1494 > tom_get_size_EL_EL(tomMatch1_1487)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_max(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1528=tom_get_slot_max_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1528))) {
int tomMatch1_1532=0;
int tomMatch1_end_1535=tomMatch1_1532;
do {
{
 EList<org.polymodel.algebra.IntExpression>  tom_x1=tom_get_slice_EL(tomMatch1_1528,tomMatch1_1532,tomMatch1_end_1535);
if (!(tomMatch1_end_1535 >= tom_get_size_EL_EL(tomMatch1_1528))) {
IntExpression tomMatch1_1543=tom_get_element_EL_EL(tomMatch1_1528,tomMatch1_end_1535);
if (tom_is_sort_E(tomMatch1_1543)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1543))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1542=tom_get_slot_affine_terms(tomMatch1_1543);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1542))) {
int tomMatch1_1549=0;
if (!(tomMatch1_1549 >= tom_get_size_terms_terms(tomMatch1_1542))) {
org.polymodel.algebra.IntTerm tomMatch1_1560=tom_get_element_terms_terms(tomMatch1_1542,tomMatch1_1549);
if (tom_is_sort_T(tomMatch1_1560)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_1560))) {
int tomMatch1_1550=tomMatch1_1549 + 1;
if (!(tomMatch1_1550 >= tom_get_size_terms_terms(tomMatch1_1542))) {
org.polymodel.algebra.IntTerm tomMatch1_1564=tom_get_element_terms_terms(tomMatch1_1542,tomMatch1_1550);
if (tom_is_sort_T(tomMatch1_1564)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_1564))) {
int tomMatch1_1551=tomMatch1_1550 + 1;
if (!(tomMatch1_1551 >= tom_get_size_terms_terms(tomMatch1_1542))) {
org.polymodel.algebra.IntTerm tomMatch1_1567=tom_get_element_terms_terms(tomMatch1_1542,tomMatch1_1551);
if (tom_is_sort_T(tomMatch1_1567)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_1567))) {
if (tomMatch1_1551 + 1 >= tom_get_size_terms_terms(tomMatch1_1542)) {
int tomMatch1_1536=tomMatch1_end_1535 + 1;
int tomMatch1_end_1539=tomMatch1_1536;
do {
{
 EList<org.polymodel.algebra.IntExpression>  tom_x2=tom_get_slice_EL(tomMatch1_1528,tomMatch1_1536,tomMatch1_end_1539);
if (!(tomMatch1_end_1539 >= tom_get_size_EL_EL(tomMatch1_1528))) {
IntExpression tomMatch1_1546=tom_get_element_EL_EL(tomMatch1_1528,tomMatch1_end_1539);
if (tom_is_sort_E(tomMatch1_1546)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1546))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1545=tom_get_slot_affine_terms(tomMatch1_1546);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1545))) {
int tomMatch1_1554=0;
if (!(tomMatch1_1554 >= tom_get_size_terms_terms(tomMatch1_1545))) {
org.polymodel.algebra.IntTerm tomMatch1_1571=tom_get_element_terms_terms(tomMatch1_1545,tomMatch1_1554);
if (tom_is_sort_T(tomMatch1_1571)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_1571))) {
if (tom_equal_term_long(tom_get_slot_term_coef(tomMatch1_1560), tom_get_slot_term_coef(tomMatch1_1571))) {
if (tom_equal_term_V(tom_get_slot_term_variable(tomMatch1_1560), tom_get_slot_term_variable(tomMatch1_1571))) {
int tomMatch1_1555=tomMatch1_1554 + 1;
if (!(tomMatch1_1555 >= tom_get_size_terms_terms(tomMatch1_1545))) {
org.polymodel.algebra.IntTerm tomMatch1_1575=tom_get_element_terms_terms(tomMatch1_1545,tomMatch1_1555);
if (tom_is_sort_T(tomMatch1_1575)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_1575))) {
if (tom_equal_term_long(tom_get_slot_term_coef(tomMatch1_1564), tom_get_slot_term_coef(tomMatch1_1575))) {
if (tom_equal_term_V(tom_get_slot_term_variable(tomMatch1_1564), tom_get_slot_term_variable(tomMatch1_1575))) {
int tomMatch1_1556=tomMatch1_1555 + 1;
if (!(tomMatch1_1556 >= tom_get_size_terms_terms(tomMatch1_1545))) {
org.polymodel.algebra.IntTerm tomMatch1_1578=tom_get_element_terms_terms(tomMatch1_1545,tomMatch1_1556);
if (tom_is_sort_T(tomMatch1_1578)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_1578))) {
if (tomMatch1_1556 + 1 >= tom_get_size_terms_terms(tomMatch1_1545)) {
 EList<org.polymodel.algebra.IntExpression>  tom_x3=tom_get_slice_EL(tomMatch1_1528,tomMatch1_end_1539 + 1,tom_get_size_EL_EL(tomMatch1_1528));
IntExpression tom_in=((IntExpression)tom__arg);

if (
tom_get_slot_constant_coef(tomMatch1_1567)>
tom_get_slot_constant_coef(tomMatch1_1578)) { return  debug("max5c", 
tom_in, 
tom_make_max(tom_append_array_EL(tom_x3,tom_append_array_EL(tom_x2,tom_append_array_EL(tom_x1,tom_cons_array_EL(tom_get_element_EL_EL(tomMatch1_1528,tomMatch1_end_1535),tom_empty_array_EL(4))))))); } else
{ return  debug("max5d", 
tom_in, 
tom_make_max(tom_append_array_EL(tom_x3,tom_append_array_EL(tom_x2,tom_append_array_EL(tom_x1,tom_cons_array_EL(tom_get_element_EL_EL(tomMatch1_1528,tomMatch1_end_1539),tom_empty_array_EL(4))))))); }

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
tomMatch1_end_1539=tomMatch1_end_1539 + 1;
}
} while(!(tomMatch1_end_1539 > tom_get_size_EL_EL(tomMatch1_1528)));
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
tomMatch1_end_1535=tomMatch1_end_1535 + 1;
}
} while(!(tomMatch1_end_1535 > tom_get_size_EL_EL(tomMatch1_1528)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_max(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.IntExpression>  tomMatch1_1585=tom_get_slot_max_expressions(((IntExpression)tom__arg));
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tomMatch1_1585))) {
int tomMatch1_1589=0;
int tomMatch1_end_1592=tomMatch1_1589;
do {
{
 EList<org.polymodel.algebra.IntExpression>  tom_x1=tom_get_slice_EL(tomMatch1_1585,tomMatch1_1589,tomMatch1_end_1592);
if (!(tomMatch1_end_1592 >= tom_get_size_EL_EL(tomMatch1_1585))) {
IntExpression tomMatch1_1600=tom_get_element_EL_EL(tomMatch1_1585,tomMatch1_end_1592);
if (tom_is_sort_E(tomMatch1_1600)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1600))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1599=tom_get_slot_affine_terms(tomMatch1_1600);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1599))) {
int tomMatch1_1606=0;
if (!(tomMatch1_1606 >= tom_get_size_terms_terms(tomMatch1_1599))) {
org.polymodel.algebra.IntTerm tomMatch1_1616=tom_get_element_terms_terms(tomMatch1_1599,tomMatch1_1606);
if (tom_is_sort_T(tomMatch1_1616)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_1616))) {
int tomMatch1_1607=tomMatch1_1606 + 1;
if (!(tomMatch1_1607 >= tom_get_size_terms_terms(tomMatch1_1599))) {
org.polymodel.algebra.IntTerm tomMatch1_1620=tom_get_element_terms_terms(tomMatch1_1599,tomMatch1_1607);
if (tom_is_sort_T(tomMatch1_1620)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_1620))) {
if (tomMatch1_1607 + 1 >= tom_get_size_terms_terms(tomMatch1_1599)) {
int tomMatch1_1593=tomMatch1_end_1592 + 1;
int tomMatch1_end_1596=tomMatch1_1593;
do {
{
 EList<org.polymodel.algebra.IntExpression>  tom_x2=tom_get_slice_EL(tomMatch1_1585,tomMatch1_1593,tomMatch1_end_1596);
if (!(tomMatch1_end_1596 >= tom_get_size_EL_EL(tomMatch1_1585))) {
IntExpression tomMatch1_1603=tom_get_element_EL_EL(tomMatch1_1585,tomMatch1_end_1596);
if (tom_is_sort_E(tomMatch1_1603)) {
if (tom_is_fun_sym_affine(((IntExpression)tomMatch1_1603))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch1_1602=tom_get_slot_affine_terms(tomMatch1_1603);
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch1_1602))) {
int tomMatch1_1610=0;
if (!(tomMatch1_1610 >= tom_get_size_terms_terms(tomMatch1_1602))) {
org.polymodel.algebra.IntTerm tomMatch1_1624=tom_get_element_terms_terms(tomMatch1_1602,tomMatch1_1610);
if (tom_is_sort_T(tomMatch1_1624)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_1624))) {
if (tom_equal_term_long(tom_get_slot_term_coef(tomMatch1_1616), tom_get_slot_term_coef(tomMatch1_1624))) {
if (tom_equal_term_V(tom_get_slot_term_variable(tomMatch1_1616), tom_get_slot_term_variable(tomMatch1_1624))) {
int tomMatch1_1611=tomMatch1_1610 + 1;
if (!(tomMatch1_1611 >= tom_get_size_terms_terms(tomMatch1_1602))) {
org.polymodel.algebra.IntTerm tomMatch1_1628=tom_get_element_terms_terms(tomMatch1_1602,tomMatch1_1611);
if (tom_is_sort_T(tomMatch1_1628)) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)tomMatch1_1628))) {
if (tom_equal_term_long(tom_get_slot_term_coef(tomMatch1_1620), tom_get_slot_term_coef(tomMatch1_1628))) {
if (tom_equal_term_V(tom_get_slot_term_variable(tomMatch1_1620), tom_get_slot_term_variable(tomMatch1_1628))) {
int tomMatch1_1612=tomMatch1_1611 + 1;
if (!(tomMatch1_1612 >= tom_get_size_terms_terms(tomMatch1_1602))) {
org.polymodel.algebra.IntTerm tomMatch1_1631=tom_get_element_terms_terms(tomMatch1_1602,tomMatch1_1612);
if (tom_is_sort_T(tomMatch1_1631)) {
if (tom_is_fun_sym_constant(((org.polymodel.algebra.IntTerm)tomMatch1_1631))) {
if (tomMatch1_1612 + 1 >= tom_get_size_terms_terms(tomMatch1_1602)) {
 EList<org.polymodel.algebra.IntExpression>  tom_x3=tom_get_slice_EL(tomMatch1_1585,tomMatch1_end_1596 + 1,tom_get_size_EL_EL(tomMatch1_1585));
IntExpression tom_in=((IntExpression)tom__arg);

if (
tom_get_slot_constant_coef(tomMatch1_1631)>0) { return  debug("max6d", 
tom_in, 
tom_make_max(tom_append_array_EL(tom_x3,tom_append_array_EL(tom_x2,tom_append_array_EL(tom_x1,tom_cons_array_EL(tom_get_element_EL_EL(tomMatch1_1585,tomMatch1_end_1596),tom_empty_array_EL(4))))))); } else
{ return  debug("max6c", 
tom_in, 
tom_make_max(tom_append_array_EL(tom_x3,tom_append_array_EL(tom_x2,tom_append_array_EL(tom_x1,tom_cons_array_EL(tom_get_element_EL_EL(tomMatch1_1585,tomMatch1_end_1592),tom_empty_array_EL(4))))))); }

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
tomMatch1_end_1596=tomMatch1_end_1596 + 1;
}
} while(!(tomMatch1_end_1596 > tom_get_size_EL_EL(tomMatch1_1585)));
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
tomMatch1_end_1592=tomMatch1_end_1592 + 1;
}
} while(!(tomMatch1_end_1592 > tom_get_size_EL_EL(tomMatch1_1585)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_polynomial(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.polynomials.PolynomialTerm>  tomMatch1_1638=tom_get_slot_polynomial_terms(((IntExpression)tom__arg));
if (tom_is_fun_sym_pterms((( EList<org.polymodel.algebra.polynomials.PolynomialTerm> )tomMatch1_1638))) {
int tomMatch1_1642=0;
int tomMatch1_end_1645=tomMatch1_1642;
do {
{
if (!(tomMatch1_end_1645 >= tom_get_size_pterms_pterms(tomMatch1_1638))) {
org.polymodel.algebra.polynomials.PolynomialTerm tomMatch1_1651=tom_get_element_pterms_pterms(tomMatch1_1638,tomMatch1_end_1645);
if (tom_is_sort_pterm(tomMatch1_1651)) {
if (tom_is_fun_sym_pterm(((org.polymodel.algebra.polynomials.PolynomialTerm)tomMatch1_1651))) {
 EList<org.polymodel.algebra.polynomials.PolynomialVariable>  tomMatch1_1650=tom_get_slot_pterm_variables(tomMatch1_1651);
if (tom_is_fun_sym_pvars((( EList<org.polymodel.algebra.polynomials.PolynomialVariable> )tomMatch1_1650))) {
int tomMatch1_1654=0;
int tomMatch1_end_1657=tomMatch1_1654;
do {
{
if (!(tomMatch1_end_1657 >= tom_get_size_pvars_pvars(tomMatch1_1650))) {
PolynomialVariable tomMatch1_1666=tom_get_element_pvars_pvars(tomMatch1_1650,tomMatch1_end_1657);
if (tom_is_sort_pvar(tomMatch1_1666)) {
if (tom_is_fun_sym_pvar(((PolynomialVariable)tomMatch1_1666))) {
org.polymodel.algebra.Variable tom_x=tom_get_slot_pvar_variable(tomMatch1_1666);
int tomMatch1_1658=tomMatch1_end_1657 + 1;
int tomMatch1_end_1661=tomMatch1_1658;
do {
{
if (!(tomMatch1_end_1661 >= tom_get_size_pvars_pvars(tomMatch1_1650))) {
PolynomialVariable tomMatch1_1670=tom_get_element_pvars_pvars(tomMatch1_1650,tomMatch1_end_1661);
if (tom_is_sort_pvar(tomMatch1_1670)) {
if (tom_is_fun_sym_pvar(((PolynomialVariable)tomMatch1_1670))) {
if (tom_equal_term_V(tom_x, tom_get_slot_pvar_variable(tomMatch1_1670))) {


long numR = 
tom_get_slot_pterm_numerator(tomMatch1_1651);
long denR = 
tom_get_slot_pterm_denominator(tomMatch1_1651);
if (Math_mod(numR, denR) == 0) {
numR = numR / denR;
denR = 1;
}
return 
tom_make_polynomial(tom_append_array_pterms(tom_get_slice_pterms(tomMatch1_1638,tomMatch1_end_1645 + 1,tom_get_size_pterms_pterms(tomMatch1_1638)),tom_cons_array_pterms(tom_make_pterm(numR,denR,tom_append_array_pvars(tom_get_slice_pvars(tomMatch1_1650,tomMatch1_end_1661 + 1,tom_get_size_pvars_pvars(tomMatch1_1650)),tom_append_array_pvars(tom_get_slice_pvars(tomMatch1_1650,tomMatch1_1658,tomMatch1_end_1661),tom_append_array_pvars(tom_get_slice_pvars(tomMatch1_1650,tomMatch1_1654,tomMatch1_end_1657),tom_cons_array_pvars(tom_make_pvar(tom_x,tom_get_slot_pvar_exponent(tomMatch1_1666)+tom_get_slot_pvar_exponent(tomMatch1_1670)),tom_empty_array_pvars(4)))))),tom_append_array_pterms(tom_get_slice_pterms(tomMatch1_1638,tomMatch1_1642,tomMatch1_end_1645),tom_empty_array_pterms(3)))));

}
}
}
}
tomMatch1_end_1661=tomMatch1_end_1661 + 1;
}
} while(!(tomMatch1_end_1661 > tom_get_size_pvars_pvars(tomMatch1_1650)));
}
}
}
tomMatch1_end_1657=tomMatch1_end_1657 + 1;
}
} while(!(tomMatch1_end_1657 > tom_get_size_pvars_pvars(tomMatch1_1650)));
}
}
}
}
tomMatch1_end_1645=tomMatch1_end_1645 + 1;
}
} while(!(tomMatch1_end_1645 > tom_get_size_pterms_pterms(tomMatch1_1638)));
}
}
}
}
}
{
if (tom_is_sort_E(tom__arg)) {
if (tom_is_sort_E(((IntExpression)tom__arg))) {
if (tom_is_fun_sym_polynomial(((IntExpression)((IntExpression)tom__arg)))) {
 EList<org.polymodel.algebra.polynomials.PolynomialTerm>  tomMatch1_1674=tom_get_slot_polynomial_terms(((IntExpression)tom__arg));
if (tom_is_fun_sym_pterms((( EList<org.polymodel.algebra.polynomials.PolynomialTerm> )tomMatch1_1674))) {
int tomMatch1_1678=0;
int tomMatch1_end_1681=tomMatch1_1678;
do {
{
if (!(tomMatch1_end_1681 >= tom_get_size_pterms_pterms(tomMatch1_1674))) {
org.polymodel.algebra.polynomials.PolynomialTerm tomMatch1_1691=tom_get_element_pterms_pterms(tomMatch1_1674,tomMatch1_end_1681);
if (tom_is_sort_pterm(tomMatch1_1691)) {
if (tom_is_fun_sym_pterm(((org.polymodel.algebra.polynomials.PolynomialTerm)tomMatch1_1691))) {
 EList<org.polymodel.algebra.polynomials.PolynomialVariable>  tomMatch1_1690=tom_get_slot_pterm_variables(tomMatch1_1691);
 long  tom_den1=tom_get_slot_pterm_denominator(tomMatch1_1691);
if (tom_is_fun_sym_pvars((( EList<org.polymodel.algebra.polynomials.PolynomialVariable> )tomMatch1_1690))) {
int tomMatch1_1699=0;
if (!(tomMatch1_1699 >= tom_get_size_pvars_pvars(tomMatch1_1690))) {
PolynomialVariable tom_var=tom_get_element_pvars_pvars(tomMatch1_1690,tomMatch1_1699);
if (tomMatch1_1699 + 1 >= tom_get_size_pvars_pvars(tomMatch1_1690)) {
int tomMatch1_1682=tomMatch1_end_1681 + 1;
int tomMatch1_end_1685=tomMatch1_1682;
do {
{
if (!(tomMatch1_end_1685 >= tom_get_size_pterms_pterms(tomMatch1_1674))) {
org.polymodel.algebra.polynomials.PolynomialTerm tomMatch1_1696=tom_get_element_pterms_pterms(tomMatch1_1674,tomMatch1_end_1685);
if (tom_is_sort_pterm(tomMatch1_1696)) {
if (tom_is_fun_sym_pterm(((org.polymodel.algebra.polynomials.PolynomialTerm)tomMatch1_1696))) {
 EList<org.polymodel.algebra.polynomials.PolynomialVariable>  tomMatch1_1695=tom_get_slot_pterm_variables(tomMatch1_1696);
 long  tom_den2=tom_get_slot_pterm_denominator(tomMatch1_1696);
if (tom_is_fun_sym_pvars((( EList<org.polymodel.algebra.polynomials.PolynomialVariable> )tomMatch1_1695))) {
int tomMatch1_1702=0;
if (!(tomMatch1_1702 >= tom_get_size_pvars_pvars(tomMatch1_1695))) {
if (tom_equal_term_pvar(tom_var, tom_get_element_pvars_pvars(tomMatch1_1695,tomMatch1_1702))) {
if (tomMatch1_1702 + 1 >= tom_get_size_pvars_pvars(tomMatch1_1695)) {


long numR = 
tom_get_slot_pterm_numerator(tomMatch1_1691)* 
tom_den2+ 
tom_get_slot_pterm_numerator(tomMatch1_1696)* 
tom_den1;
long denR = 
tom_den1* 
tom_den2;
if (Math_mod(numR, denR) == 0) {
numR = numR / denR;
denR = 1;
}
return 
tom_make_polynomial(tom_append_array_pterms(tom_get_slice_pterms(tomMatch1_1674,tomMatch1_end_1685 + 1,tom_get_size_pterms_pterms(tomMatch1_1674)),tom_append_array_pterms(tom_get_slice_pterms(tomMatch1_1674,tomMatch1_1682,tomMatch1_end_1685),tom_append_array_pterms(tom_get_slice_pterms(tomMatch1_1674,tomMatch1_1678,tomMatch1_end_1681),tom_cons_array_pterms(tom_make_pterm(numR,denR,tom_cons_array_pvars(tom_var,tom_empty_array_pvars(1))),tom_empty_array_pterms(4))))));

}
}
}
}
}
}
}
tomMatch1_end_1685=tomMatch1_end_1685 + 1;
}
} while(!(tomMatch1_end_1685 > tom_get_size_pterms_pterms(tomMatch1_1674)));
}
}
}
}
}
}
tomMatch1_end_1681=tomMatch1_end_1681 + 1;
}
} while(!(tomMatch1_end_1681 > tom_get_size_pterms_pterms(tomMatch1_1674)));
}
}
}
}
}
}
return _visit_E(tom__arg,introspector);
}
}
private static  tom.library.sl.Strategy  tom_make_Simplify() { 
return new Simplify();
}

}
