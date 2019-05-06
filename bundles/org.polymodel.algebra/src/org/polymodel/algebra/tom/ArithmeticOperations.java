package org.polymodel.algebra.tom;


import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.IntTerm;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.polynomials.PolynomialExpression;
import org.polymodel.algebra.polynomials.PolynomialTerm;
import org.polymodel.algebra.polynomials.PolynomialVariable;
import org.polymodel.algebra.quasiAffine.QuasiAffineExpression;
import org.polymodel.algebra.quasiAffine.QuasiAffineTerm;
import org.polymodel.algebra.reductions.ReductionExpression;
import org.polymodel.algebra.reductions.ReductionOperator;


@SuppressWarnings("all")
public class ArithmeticOperations  {


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
private static org.polymodel.algebra.IntTerm tom_make_term( long  _coef, org.polymodel.algebra.Variable _variable) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createTerm(_coef, _variable);
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
private static boolean tom_is_fun_sym_select(IntExpression t) {
return t instanceof org.polymodel.algebra.SelectExpression;
}
private static IntExpression tom_make_select( EList<org.polymodel.algebra.IntConstraintSystem>  _condition, IntExpression _then, IntExpression _else) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createSelect(_condition, _then, _else);
}
private static  EList<org.polymodel.algebra.IntConstraintSystem>  tom_get_slot_select_condition(IntExpression t) {
return enforce(((org.polymodel.algebra.SelectExpression)t).getCondition());
}
private static IntExpression tom_get_slot_select_then(IntExpression t) {
return ((org.polymodel.algebra.SelectExpression)t).getThen();
}
private static IntExpression tom_get_slot_select_else(IntExpression t) {
return ((org.polymodel.algebra.SelectExpression)t).getElse();
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
private static org.polymodel.algebra.polynomials.PolynomialTerm tom_make_pterm( long  _numerator,  long  _denominator,  EList<org.polymodel.algebra.polynomials.PolynomialVariable>  _variables) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createPterm(_numerator, _denominator, _variables);
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
private static boolean tom_is_fun_sym_div(org.polymodel.algebra.IntTerm t) {
return t instanceof org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm && ((org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm)t).getOperator().equals(org.polymodel.algebra.quasiAffine.QuasiAffineOperator.DIV);
}
private static org.polymodel.algebra.IntTerm tom_make_div(IntExpression _expression,  long  _coef) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createDiv(_expression, _coef);
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
private static org.polymodel.algebra.IntTerm tom_make_nmul(IntExpression _expression,  long  _coef) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createNmul(_expression, _coef);
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
private static org.polymodel.algebra.IntTerm tom_make_nmod(IntExpression _expression,  long  _coef) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createNmod(_expression, _coef);
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
private static org.polymodel.algebra.IntTerm tom_make_nceil(IntExpression _expression,  long  _coef) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createNceil(_expression, _coef);
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
private static org.polymodel.algebra.IntTerm tom_make_nfloor(IntExpression _expression,  long  _coef) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createNfloor(_expression, _coef);
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
private static org.polymodel.algebra.IntTerm tom_make_ndiv(IntExpression _expression,  long  _coef) { 
return org.polymodel.algebra.internal.AlgebraTomFactory.createNdiv(_expression, _coef);
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


public static boolean VERBOSE=false;  
public static long ZERO=0; 

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

public static long Math_mul(long a, long b) {
return a*b;
} 

public static int Math_floord(int a, int b) {
return a/b;
} 

public static int Math_ceild(int a, int b) { 
return (a+b-1)/b;
} 

public static IntTerm negate(IntTerm a) {
return scale(a,-1);
}  

public static IntExpression negate(IntExpression a) {
return scale(a,-1);
}

public static AffineExpression negate(AffineExpression a) {
return ((AffineExpression) negate(((IntExpression)a)));
}

public static IntTerm scale(IntTerm a, long value) {

{
{
if (tom_is_sort_T(a)) {
if (tom_is_sort_T(((org.polymodel.algebra.IntTerm)a))) {
if (tom_is_fun_sym_term(((org.polymodel.algebra.IntTerm)((org.polymodel.algebra.IntTerm)a)))) {

return 
tom_make_term(Math_mul(value,tom_get_slot_term_coef(((org.polymodel.algebra.IntTerm)a))),tom_get_slot_term_variable(((org.polymodel.algebra.IntTerm)a)));

}
}
}
}
{
if (tom_is_sort_T(a)) {
if (tom_is_sort_T(((org.polymodel.algebra.IntTerm)a))) {
if (tom_is_fun_sym_mul(((org.polymodel.algebra.IntTerm)((org.polymodel.algebra.IntTerm)a)))) {

return 
tom_make_mul(tom_get_slot_mul_expression(((org.polymodel.algebra.IntTerm)a)).copy(),Math_mul(value,tom_get_slot_mul_coef(((org.polymodel.algebra.IntTerm)a))));

}
}
}
}
{
if (tom_is_sort_T(a)) {
if (tom_is_sort_T(((org.polymodel.algebra.IntTerm)a))) {
if (tom_is_fun_sym_mod(((org.polymodel.algebra.IntTerm)((org.polymodel.algebra.IntTerm)a)))) {

return 
tom_make_nmul(tom_make_qaffine(tom_cons_array_terms(tom_make_mod(tom_get_slot_mod_expression(((org.polymodel.algebra.IntTerm)a)).copy(),tom_get_slot_mod_coef(((org.polymodel.algebra.IntTerm)a))),tom_empty_array_terms(1))),value);

}
}
}
}
{
if (tom_is_sort_T(a)) {
if (tom_is_sort_T(((org.polymodel.algebra.IntTerm)a))) {
if (tom_is_fun_sym_floor(((org.polymodel.algebra.IntTerm)((org.polymodel.algebra.IntTerm)a)))) {

return 
tom_make_nmul(tom_make_qaffine(tom_cons_array_terms(tom_make_floor(tom_get_slot_floor_expression(((org.polymodel.algebra.IntTerm)a)).copy(),tom_get_slot_floor_coef(((org.polymodel.algebra.IntTerm)a))),tom_empty_array_terms(1))),value);

}
}
}
}
{
if (tom_is_sort_T(a)) {
if (tom_is_sort_T(((org.polymodel.algebra.IntTerm)a))) {
if (tom_is_fun_sym_ceil(((org.polymodel.algebra.IntTerm)((org.polymodel.algebra.IntTerm)a)))) {

return 
tom_make_nmul(tom_make_qaffine(tom_cons_array_terms(tom_make_ceil(tom_get_slot_ceil_expression(((org.polymodel.algebra.IntTerm)a)).copy(),tom_get_slot_ceil_coef(((org.polymodel.algebra.IntTerm)a))),tom_empty_array_terms(1))),value);

}
}
}
}
{
if (tom_is_sort_T(a)) {
if (tom_is_sort_T(((org.polymodel.algebra.IntTerm)a))) {
if (tom_is_fun_sym_div(((org.polymodel.algebra.IntTerm)((org.polymodel.algebra.IntTerm)a)))) {

return 
tom_make_nmul(tom_make_qaffine(tom_cons_array_terms(tom_make_div(tom_get_slot_div_expression(((org.polymodel.algebra.IntTerm)a)).copy(),tom_get_slot_div_coef(((org.polymodel.algebra.IntTerm)a))),tom_empty_array_terms(1))),value);

}
}
}
}
{
if (tom_is_sort_T(a)) {
if (tom_is_sort_T(((org.polymodel.algebra.IntTerm)a))) {
if (tom_is_fun_sym_nmul(((org.polymodel.algebra.IntTerm)((org.polymodel.algebra.IntTerm)a)))) {

return 
tom_make_nmul(tom_get_slot_nmul_expression(((org.polymodel.algebra.IntTerm)a)).copy(),Math_mul(value,tom_get_slot_nmul_coef(((org.polymodel.algebra.IntTerm)a))));

}
}
}
}
{
if (tom_is_sort_T(a)) {
if (tom_is_sort_T(((org.polymodel.algebra.IntTerm)a))) {
if (tom_is_fun_sym_nmod(((org.polymodel.algebra.IntTerm)((org.polymodel.algebra.IntTerm)a)))) {

return 
tom_make_nmul(tom_make_qaffine(tom_cons_array_terms(tom_make_nmod(tom_get_slot_nmod_expression(((org.polymodel.algebra.IntTerm)a)).copy(),tom_get_slot_nmod_coef(((org.polymodel.algebra.IntTerm)a))),tom_empty_array_terms(1))),value);

}
}
}
}
{
if (tom_is_sort_T(a)) {
if (tom_is_sort_T(((org.polymodel.algebra.IntTerm)a))) {
if (tom_is_fun_sym_nfloor(((org.polymodel.algebra.IntTerm)((org.polymodel.algebra.IntTerm)a)))) {

return 
tom_make_nmul(tom_make_qaffine(tom_cons_array_terms(tom_make_nfloor(tom_get_slot_nfloor_expression(((org.polymodel.algebra.IntTerm)a)).copy(),tom_get_slot_nfloor_coef(((org.polymodel.algebra.IntTerm)a))),tom_empty_array_terms(1))),value);

}
}
}
}
{
if (tom_is_sort_T(a)) {
if (tom_is_sort_T(((org.polymodel.algebra.IntTerm)a))) {
if (tom_is_fun_sym_nceil(((org.polymodel.algebra.IntTerm)((org.polymodel.algebra.IntTerm)a)))) {

return 
tom_make_nmul(tom_make_qaffine(tom_cons_array_terms(tom_make_nceil(tom_get_slot_nceil_expression(((org.polymodel.algebra.IntTerm)a)).copy(),tom_get_slot_nceil_coef(((org.polymodel.algebra.IntTerm)a))),tom_empty_array_terms(1))),value);

}
}
}
}
{
if (tom_is_sort_T(a)) {
if (tom_is_sort_T(((org.polymodel.algebra.IntTerm)a))) {
if (tom_is_fun_sym_ndiv(((org.polymodel.algebra.IntTerm)((org.polymodel.algebra.IntTerm)a)))) {

return 
tom_make_nmul(tom_make_qaffine(tom_cons_array_terms(tom_make_ndiv(tom_get_slot_ndiv_expression(((org.polymodel.algebra.IntTerm)a)).copy(),tom_get_slot_ndiv_coef(((org.polymodel.algebra.IntTerm)a))),tom_empty_array_terms(1))),value);

}
}
}
}
}

throw new RuntimeException("scaleTerm("+a+","+value+") not yet implemented");
}  

public static AffineExpression scale(AffineExpression a, long value) {
return ((AffineExpression) scale(((IntExpression)a),value));
}

public static IntExpression scale(IntExpression a, long value) {
IntExpression _a = a.copy();

{
{
if (tom_is_sort_E(_a)) {
if (tom_is_sort_E(((IntExpression)_a))) {
if (tom_is_fun_sym_affine(((IntExpression)((IntExpression)_a)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch2_1=tom_get_slot_affine_terms(((IntExpression)_a));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch2_1))) {

AffineExpression r = (AffineExpression)
tom_make_affine(tom_empty_array_terms(0));
for(IntTerm t : 
tom_get_slice_terms(tomMatch2_1,0,tom_get_size_terms_terms(tomMatch2_1))) {
r.getTerms().add((AffineTerm)scale(t,value)); 
}
return r.simplify();

}
}
}
}
}
{
if (tom_is_sort_E(_a)) {
if (tom_is_sort_E(((IntExpression)_a))) {
if (tom_is_fun_sym_qaffine(((IntExpression)((IntExpression)_a)))) {
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tom_get_slot_qaffine_terms(((IntExpression)_a))))) {

QuasiAffineExpression r = (QuasiAffineExpression)
tom_make_qaffine(tom_empty_array_terms(0));
for(QuasiAffineTerm t : ((QuasiAffineExpression)
((IntExpression)_a)).getTerms()) {
r.getTerms().add((QuasiAffineTerm) scale(t,value));
}
return r.simplify(); 

}
}
}
}
}
{
if (tom_is_sort_E(_a)) {
if (tom_is_sort_E(((IntExpression)_a))) {
if (tom_is_fun_sym_polynomial(((IntExpression)((IntExpression)_a)))) {
if (tom_is_fun_sym_pterms((( EList<org.polymodel.algebra.polynomials.PolynomialTerm> )tom_get_slot_polynomial_terms(((IntExpression)_a))))) {

PolynomialExpression polynomialExpression = (PolynomialExpression)
tom_make_polynomial(tom_empty_array_pterms(0));
for(PolynomialTerm t : ((PolynomialExpression)
((IntExpression)_a)).getTerms()) {
polynomialExpression.getTerms().add((PolynomialTerm) 
tom_make_pterm(value* t.getNumerator(),t.getDenominator(),t.getVariables()));
}
return polynomialExpression.simplify(); 

}
}
}
}
}
{
if (tom_is_sort_E(_a)) {
if (tom_is_sort_E(((IntExpression)_a))) {
if (tom_is_fun_sym_min(((IntExpression)((IntExpression)_a)))) {
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tom_get_slot_min_expressions(((IntExpression)_a))))) {

return scaleNestedExpression((ReductionExpression)
((IntExpression)_a), (ReductionExpression)
tom_make_min(tom_empty_array_EL(0)), value);

}
}
}
}
}
{
if (tom_is_sort_E(_a)) {
if (tom_is_sort_E(((IntExpression)_a))) {
if (tom_is_fun_sym_max(((IntExpression)((IntExpression)_a)))) {
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tom_get_slot_max_expressions(((IntExpression)_a))))) {

return scaleNestedExpression((ReductionExpression)
((IntExpression)_a), (ReductionExpression)
tom_make_max(tom_empty_array_EL(0)), value);

}
}
}
}
}
{
if (tom_is_sort_E(_a)) {
if (tom_is_sort_E(((IntExpression)_a))) {
if (tom_is_fun_sym_sum(((IntExpression)((IntExpression)_a)))) {
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tom_get_slot_sum_expressions(((IntExpression)_a))))) {

return scaleNestedExpression((ReductionExpression)
((IntExpression)_a), (ReductionExpression)
tom_make_sum(tom_empty_array_EL(0)), value);

}
}
}
}
}
{
if (tom_is_sort_E(_a)) {
if (tom_is_sort_E(((IntExpression)_a))) {
if (tom_is_fun_sym_prod(((IntExpression)((IntExpression)_a)))) {
if (tom_is_fun_sym_EL((( EList<org.polymodel.algebra.IntExpression> )tom_get_slot_prod_expressions(((IntExpression)_a))))) {

return scaleNestedExpression((ReductionExpression)
((IntExpression)_a), (ReductionExpression)
tom_make_prod(tom_empty_array_EL(0)), value);

}
}
}
}
}
{
if (tom_is_sort_E(_a)) {
if (tom_is_sort_E(((IntExpression)_a))) {
if (tom_is_fun_sym_select(((IntExpression)((IntExpression)_a)))) {

return 
tom_make_select(tom_get_slot_select_condition(((IntExpression)_a)),scale(tom_get_slot_select_then(((IntExpression)_a)),value),scale(tom_get_slot_select_else(((IntExpression)_a)),value));

}
}
}
}
}

throw new RuntimeException("scale("+a+","+value+") not yet implemented");
}

public static AffineExpression add(AffineExpression a,AffineExpression b) {
return ((AffineExpression)add((IntExpression)a,(IntExpression)b)); 
}

public static IntExpression add(IntExpression a,IntExpression b) {
IntExpression _a = a.copy();
IntExpression _b= b.copy() ;

{
{
if (tom_is_sort_E(_a)) {
if (tom_is_sort_E(((IntExpression)_a))) {
if (tom_is_fun_sym_affine(((IntExpression)((IntExpression)_a)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch3_2=tom_get_slot_affine_terms(((IntExpression)_a));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch3_2))) {
if (tom_is_sort_E(_b)) {
if (tom_is_sort_E(((IntExpression)_b))) {
if (tom_is_fun_sym_affine(((IntExpression)((IntExpression)_b)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch3_5=tom_get_slot_affine_terms(((IntExpression)_b));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch3_5))) {

return 
tom_make_affine(tom_append_array_terms(tom_get_slice_terms(tomMatch3_5,0,tom_get_size_terms_terms(tomMatch3_5)),tom_append_array_terms(tom_get_slice_terms(tomMatch3_2,0,tom_get_size_terms_terms(tomMatch3_2)),tom_empty_array_terms(2))));

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
if (tom_is_sort_E(_a)) {
if (tom_is_sort_E(((IntExpression)_a))) {
if (tom_is_fun_sym_affine(((IntExpression)((IntExpression)_a)))) {
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tom_get_slot_affine_terms(((IntExpression)_a))))) {
if (tom_is_sort_E(_b)) {
if (tom_is_sort_E(((IntExpression)_b))) {
if (tom_is_fun_sym_qaffine(((IntExpression)((IntExpression)_b)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch3_19=tom_get_slot_qaffine_terms(((IntExpression)_b));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch3_19))) {

QuasiAffineTerm qE = IntExpressionBuilder.mul((AffineExpression)_a, 1);  
return 
tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch3_19,0,tom_get_size_terms_terms(tomMatch3_19)),tom_cons_array_terms(qE,tom_empty_array_terms(2)))); 

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
if (tom_is_sort_E(_a)) {
if (tom_is_sort_E(((IntExpression)_a))) {
if (tom_is_fun_sym_qaffine(((IntExpression)((IntExpression)_a)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch3_30=tom_get_slot_qaffine_terms(((IntExpression)_a));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch3_30))) {
if (tom_is_sort_E(_b)) {
if (tom_is_sort_E(((IntExpression)_b))) {
if (tom_is_fun_sym_affine(((IntExpression)((IntExpression)_b)))) {
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tom_get_slot_affine_terms(((IntExpression)_b))))) {

QuasiAffineTerm qE = IntExpressionBuilder.mul((AffineExpression)_b, 1);  
return 
tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch3_30,0,tom_get_size_terms_terms(tomMatch3_30)),tom_cons_array_terms(qE,tom_empty_array_terms(2))));

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
if (tom_is_sort_E(_a)) {
if (tom_is_sort_E(((IntExpression)_a))) {
if (tom_is_fun_sym_qaffine(((IntExpression)((IntExpression)_a)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch3_44=tom_get_slot_qaffine_terms(((IntExpression)_a));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch3_44))) {
if (tom_is_sort_E(_b)) {
if (tom_is_sort_E(((IntExpression)_b))) {
if (tom_is_fun_sym_qaffine(((IntExpression)((IntExpression)_b)))) {
 EList<org.polymodel.algebra.IntTerm>  tomMatch3_47=tom_get_slot_qaffine_terms(((IntExpression)_b));
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tomMatch3_47))) {

return 
tom_make_qaffine(tom_append_array_terms(tom_get_slice_terms(tomMatch3_47,0,tom_get_size_terms_terms(tomMatch3_47)),tom_append_array_terms(tom_get_slice_terms(tomMatch3_44,0,tom_get_size_terms_terms(tomMatch3_44)),tom_empty_array_terms(2))));

}
}
}
}
}
}
}
}
}
}

throw new RuntimeException("add("+a+") not yet implemented");
}   

public static IntExpression add(long a,IntExpression b) {
return add(b,
tom_make_affine(tom_cons_array_terms(tom_make_constant(a),tom_empty_array_terms(1))));
}

public static IntExpression add(IntExpression b,long a) {
return add(b,
tom_make_affine(tom_cons_array_terms(tom_make_constant(a),tom_empty_array_terms(1))));
}

public static IntExpression sub(IntExpression a,IntExpression b) {
IntExpression _a = a.copy();
IntExpression _b= b.copy() ;

{
{
if (tom_is_sort_E(_a)) {
if (tom_is_sort_E(((IntExpression)_a))) {
if (tom_is_fun_sym_affine(((IntExpression)((IntExpression)_a)))) {
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tom_get_slot_affine_terms(((IntExpression)_a))))) {
if (tom_is_sort_E(_b)) {
if (tom_is_sort_E(((IntExpression)_b))) {
if (tom_is_fun_sym_affine(((IntExpression)((IntExpression)_b)))) {
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tom_get_slot_affine_terms(((IntExpression)_b))))) {

return add(
((IntExpression)_a), negate(
((IntExpression)_b)));

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
if (tom_is_sort_E(_a)) {
if (tom_is_sort_E(((IntExpression)_a))) {
if (tom_is_fun_sym_affine(((IntExpression)((IntExpression)_a)))) {
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tom_get_slot_affine_terms(((IntExpression)_a))))) {
if (tom_is_sort_E(_b)) {
if (tom_is_sort_E(((IntExpression)_b))) {
if (tom_is_fun_sym_qaffine(((IntExpression)((IntExpression)_b)))) {
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tom_get_slot_qaffine_terms(((IntExpression)_b))))) {

return add(
((IntExpression)_a), negate(
((IntExpression)_b)));

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
if (tom_is_sort_E(_a)) {
if (tom_is_sort_E(((IntExpression)_a))) {
if (tom_is_fun_sym_qaffine(((IntExpression)((IntExpression)_a)))) {
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tom_get_slot_qaffine_terms(((IntExpression)_a))))) {
if (tom_is_sort_E(_b)) {
if (tom_is_sort_E(((IntExpression)_b))) {
if (tom_is_fun_sym_affine(((IntExpression)((IntExpression)_b)))) {
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tom_get_slot_affine_terms(((IntExpression)_b))))) {

return add(
((IntExpression)_a), negate(
((IntExpression)_b)));

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
if (tom_is_sort_E(_a)) {
if (tom_is_sort_E(((IntExpression)_a))) {
if (tom_is_fun_sym_qaffine(((IntExpression)((IntExpression)_a)))) {
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tom_get_slot_qaffine_terms(((IntExpression)_a))))) {
if (tom_is_sort_E(_b)) {
if (tom_is_sort_E(((IntExpression)_b))) {
if (tom_is_fun_sym_qaffine(((IntExpression)((IntExpression)_b)))) {
if (tom_is_fun_sym_terms((( EList<org.polymodel.algebra.IntTerm> )tom_get_slot_qaffine_terms(((IntExpression)_b))))) {

return add(
((IntExpression)_a), negate(
((IntExpression)_b)));

}
}
}
}
}
}
}
}
}
}

throw new RuntimeException("sub("+a+") not yet implemented");
}

public static IntExpression scaleNestedExpression(ReductionExpression originalReductionExpression, ReductionExpression reductionExpression, long value) {
if (originalReductionExpression.getOperator() == ReductionOperator.PROD) {
if (originalReductionExpression.getExpressions().size() > 0) {
IntExpression intExpression = originalReductionExpression.getExpressions().get(0);
for (int i = 0; i < originalReductionExpression.getExpressions().size() && !(intExpression instanceof QuasiAffineExpression); i++)
intExpression = originalReductionExpression.getExpressions().get(i);
reductionExpression.getExpressions().add((IntExpression) scale(intExpression,value));
for (int i = 0; i < originalReductionExpression.getExpressions().size(); i++)
if (intExpression != originalReductionExpression.getExpressions().get(i))
reductionExpression.getExpressions().add(originalReductionExpression.getExpressions().get(i).copy());
}
return reductionExpression.simplify();
} else {
for(IntExpression intExpression : originalReductionExpression.getExpressions()) {
reductionExpression.getExpressions().add((IntExpression) scale(intExpression,value));
}
return reductionExpression.simplify();
}
}

public static IntExpression debug(String name, IntExpression input, IntExpression output) {
if(VERBOSE) {
System.out.println("rule "+name+" :\n\t"+input+" -> "+output);
}
return output;
}
}
