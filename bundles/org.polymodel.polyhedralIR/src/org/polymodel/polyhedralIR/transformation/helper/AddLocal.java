package org.polymodel.polyhedralIR.transformation.helper;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.ExternalFunctionDeclaration;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.VariableIdentifier;
import org.polymodel.polyhedralIR.transformation.PolyhedralIRTomTransformation;
import tom.library.sl.VisitFailure;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.SIGNED;
import org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;
import org.polymodel.polyhedralIR.util.ContextDomainCalculator;
import org.polymodel.polyhedralIR.util.ExpressionDomainCalculator;
import org.polymodel.polyhedralIR.util.ExpressionFinder;

public class AddLocal {

private static PolyhedralIRUserFactory _polyIR;

/**
* Create a new local variable (of name "name_Local" and domain "dom_Local") in an affine system ("syst"), corresponding to "expr"
* Also replace all the occurence of expr by a utilisation of the new local variable.
* 
* @param syst
* @param expr
* @param name_Local
* @param dom_Local
*/
public static void addLocal(AffineSystem syst, Expression expr, String name_Local, Domain dom_Local) {
if (syst.containsVariable(name_Local))
throw new RuntimeException("addLocal: the variable " + name_Local + " already exists in the system");
_polyIR = PolyhedralIRUserFactory.eINSTANCE;

// Create the VariableDeclaration of the new Local Variable
Type type_Local = expr.getExpressionType();
VariableDeclaration varDeclLoc = _polyIR.createVariableDeclaration(name_Local, type_Local, dom_Local);
syst.getLocals().add(varDeclLoc);

// Pattern-match on other expressions
AddLocalTom.replace(syst, expr, _polyIR.createVariableExpression(varDeclLoc));

// Adding the new equation to the system
StandardEquation eqLocal = _polyIR.createStandardEquation(varDeclLoc , expr.copy());
syst.getEquations().add(eqLocal);

// Update the context/expression domain of the new system
ContextDomainCalculator.computeContextDomain(syst);
}

/**
* Add a new local variable ("varDeclLoc" and domain "dom_Local") in an affine system ("syst"), corresponding to "expr"
* Also replace all the occurence of expr by a utilisation of the new local variable.
* 
* @param syst
* @param expr
* @param varDeclLoc
* @param dom_Local
*/
public static void addLocal(AffineSystem syst, Expression expr, VariableDeclaration varDeclLoc, Domain dom_Local) {
String name_Local = varDeclLoc.getName();
if (syst.containsVariable(name_Local))
throw new RuntimeException("addLocal: the variable " + name_Local + " already exists in the system");
_polyIR = PolyhedralIRUserFactory.eINSTANCE;

syst.getLocals().add(varDeclLoc);

// Pattern-match on other expressions
AddLocalTom.replace(syst, expr, _polyIR.createVariableExpression(varDeclLoc));

// Adding the new equation to the system
StandardEquation eqLocal = _polyIR.createStandardEquation(varDeclLoc , expr.copy());
syst.getEquations().add(eqLocal);

// Update the context/expression domain of the new system
ContextDomainCalculator.computeContextDomain(syst);
}

/**
* Create a new local variable (of name "name_Local" and domain "dom_Local") in an affine system ("syst"), corresponding to "expr"
*     Also replace all the occurence of expr by a utilisation of the new local variable.
* The domain of the new local variable is the ExpressionDomain of "expr"
* 
* @param syst
* @param expr
* @param name_Local
*/
public static void addLocal(AffineSystem syst, Expression expr, String name_Local) {
ExpressionDomainCalculator.computeExpressionDomain(syst.getParameters(), expr);
addLocal(syst, expr, name_Local, expr.getExpressionDomain());
}

/**
* addLocal where the name is not specified (we will use the following name: "_Local_[k]",
*			with [k] an integer big enough to avoid a name colision)
**/
public static void addLocal(AffineSystem syst, Expression expr, Domain dom_Local) {
addLocal(syst, expr, findUniqueLocalName(syst), dom_Local);
}

/**
* Method to find a local name that was not used before
* 
* @param syst
* @return BaseLocalName
*/
private static String findUniqueLocalName(AffineSystem syst) {
int k = 0;
boolean exist = true;
while (exist) {
if (syst.containsVariable("_Local_" + k))
k++;
else
exist = false;
}

return ("_Local_" + k);
}

/**
* addLocal where the expression is specified from a sub-expression of the same system (specified by nodeId)
*
* @param syst
* @param nodeId
* @param name_Local
*/
public static void addLocal(AffineSystem syst, int[] nodeId, String name_Local) {
if (syst.containsVariable(name_Local))
throw new RuntimeException("addLocal: the variable " + name_Local + " already exists in the system");

Program prog = syst.getContainerProgram();

if (!(prog.getSystems().get(nodeId[0]).equals(syst)))
throw new RuntimeException("The specified subexpression belongs to the wrong AffineSystem.");

Expression expr = ExpressionFinder.getExpression(prog, nodeId);
Domain domExpr = expr.getContextDomain();
addLocal(syst, expr, name_Local, domExpr);	// Do not do a copy of "expr", else you won't have a containing system anymore
}

/**
* addLocalUnique : Replace only the specified location by the local variable
* 		Do not pattern-match the whole system
* 
* @param syst
* @param nodeId
* @param name_Local
*/
public static void addLocalUnique(AffineSystem syst, int[] nodeId, String name_Local) {
if (syst.containsVariable(name_Local))
throw new RuntimeException("addLocalUnique: the variable " + name_Local + " already exists in the system");

Program prog = syst.getContainerProgram();

if (!(prog.getSystems().get(nodeId[0]).equals(syst)))
throw new RuntimeException("The specified subexpression belongs to the wrong AffineSystem.");

Expression expr = ExpressionFinder.getExpression(prog, nodeId);
Domain domExpr = expr.getContextDomain();

// Create the VariableDeclaration of the new Local Variable
_polyIR = PolyhedralIRUserFactory.eINSTANCE;
Type type_Local = expr.getExpressionType();
VariableDeclaration varDeclLoc = _polyIR.createVariableDeclaration(name_Local, type_Local, domExpr);
syst.getLocals().add(varDeclLoc);

// Replacing only the specified location by the expression
int k = expr.eContainer().eContents().indexOf(expr);
ReplaceUniqueExpression.replace(syst, (Expression) expr.eContainer().eContents().get(k), _polyIR.createVariableExpression(varDeclLoc));

// Adding the new equation to the system
StandardEquation eqLocal = _polyIR.createStandardEquation(varDeclLoc, expr.copy());
syst.getEquations().add(eqLocal);

// Update the context/expression domain of the new system
ContextDomainCalculator.computeContextDomain(syst);
}

/**
* Find the expressions of lexpr inside the equations of syst, replace them by new local variables
*  and returns these local variables, while adding them to syst.
* If an expression do not appear anywhere, we throw an exception.
* 
* @param syst
* @param lexpr
* @return lLocals, the list of Local Variable created.
*/
public static List<VariableDeclaration> addLocals(AffineSystem syst, List<Expression> lexpr) {
AffineSystem origSyst = syst.copy();
PolyhedralIRUserFactory _polyIRFact = PolyhedralIRUserFactory.eINSTANCE;

// Creating the VariableDeclarations that will replace the expressions we are detecting
List<VariableDeclaration> lvarDecl = new BasicEList<VariableDeclaration>();
String BasenameVar = findUniqueLocalName(syst);
for (int k=0; k<lexpr.size(); k++) {
String nameVar = BasenameVar + "_" + k;
Type typeVar = lexpr.get(k).getExpressionType();
Domain domVar = lexpr.get(k).getContextDomain().copy();

VariableDeclaration nvarDecl = _polyIRFact.createVariableDeclaration(
nameVar, typeVar, domVar);
lvarDecl.add(nvarDecl);
}

// Add these new VariableDeclaration to the system
syst.getLocals().addAll(lvarDecl);

// ---- Pattern-match
// Pattern-matching:
//	- Replace the expressions with the locals VariableDeclaration
//	- If an expression do not appear somewhere, raise an exception
//	- To counter inclusion/equality cases, do the patern matching on the remaining expressions.
//		=> In that way, only the biggest expression will be considered and pattern matched.
for (int k=0; k<lexpr.size(); k++) {
// Pattern match the system
Expression corLocalVar = _polyIRFact.createVariableExpression(lvarDecl.get(k));
try {
AddLocalTom.replace(syst, lexpr.get(k), corLocalVar);
} catch (RuntimeException e) {
syst = origSyst;
throw new RuntimeException("AddLocal: expression lexpr.(" + k +") do not appear anywhere in the system " + syst.getName());
}

// Update the other expressions
for (int l=k+1; l<lexpr.size(); l++) {
try {
// Pattern matching inside one expression (attached to the system syst).
AddLocalTom.replace(syst, lexpr.get(l), lexpr.get(k), corLocalVar);
} catch (RuntimeException e) {
// Do nothing
}
}
}

for (int k=0; k<lexpr.size(); k++) {
StandardEquation nStdEq = _polyIRFact.createStandardEquation(lvarDecl.get(k), lexpr.get(k).copy());
syst.getEquations().add(nStdEq);
}

return lvarDecl;
}

// TODO: Other implementations to do:
// - Use a existing VariableDeclaration (need to check that it really corresponds)

// **************************************** TOM SIDE !!!
public static class AddLocalTom extends PolyhedralIRTomTransformation {
protected final Expression _target;
protected final Expression _replace;
protected static boolean _foundAtLeastOnce;
protected static boolean _expressionPatternMatch;	// = true if we are doing a pattern-match only on a expression

// Replace for affine system
public static void replace(AffineSystem syst, Expression target, Expression replace){
_foundAtLeastOnce = false;
_expressionPatternMatch = false;

AddLocalTom al = new AddLocalTom(target, replace);
al.transform(syst);
//	if (!_foundAtLeastOnce)
//		throw new RuntimeException("AddLocal: expression " + target.toString() + " not found.");
}

// Replace for expressions (the context of this expression begin given by hte AffineSystem)
public static void replace(AffineSystem syst, Expression context, Expression target, Expression replace) {
_foundAtLeastOnce = false;
_expressionPatternMatch = true;

AddLocalTom al = new AddLocalTom(target, replace);
al.transform(context);
//	if (!_foundAtLeastOnce)
//		throw new RuntimeException("AddLocal: expression " + target.toString() + " not found.");
}

protected AddLocalTom(Expression target, Expression replace) {
_target = target;
_replace = replace;
}

@Override
protected EObject apply(EObject o) throws VisitFailure {
try{
EObject t;
if (_expressionPatternMatch)
t =	
tom_make_TopDown(tom_make_ReplaceExpr(_target,_replace)).visitLight((Expression)o, tom.mapping.GenericIntrospector.INSTANCE);
else
t =	
tom_make_TopDown(tom_make_ReplaceExpr(_target,_replace)).visitLight((AffineSystem)o, tom.mapping.GenericIntrospector.INSTANCE);
return t;
} catch(ClassCastException e) {
e.printStackTrace();				
throw new IllegalArgumentException(o+ "isn't an Affine System");
}
}

// TODO: do a patern matching on each type of expression, and unroll the matching ?
// => Can manage the case "A@f1 + B@f2" <=> "A@f3 + B@f4" where (\exists f) f3 = f1 o f and f4 = f2 o f
// => Possible to use part of normalise (to expose the maximum common "f") ?


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
public static class ReplaceExpr extends tom.library.sl.AbstractStrategyBasic {
private Expression target;
private Expression replace;
public ReplaceExpr(Expression target, Expression replace) {
super(tom_make_Identity());
this.target=target;
this.replace=replace;
}
public Expression gettarget() {
return target;
}
public Expression getreplace() {
return replace;
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
if (target.equivalence(
((Expression)tom__arg))) {
_foundAtLeastOnce = true;
return 
replace.copy();
}

}
}
}
return _visit_Expression(tom__arg,introspector);
}
}
private static  tom.library.sl.Strategy  tom_make_ReplaceExpr(Expression t0, Expression t1) { 
return new ReplaceExpr(t0,t1);
}

}
}
