package org.polymodel.polyhedralIR.transformation;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.ExternalFunctionDeclaration;
import org.polymodel.polyhedralIR.SIGNED;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.VariableIdentifier;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.analysis.SystemCallAnalysis;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations;
import org.polymodel.polyhedralIR.transformation.helper.FunctionOperations;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;


import tom.library.sl.VisitFailure;
/**
Change of Basis is a transformation that transforms the domain of a variable 
while preserving problem semantics by modifying other parts of the program.

The transformation adds a DependenceExpression with the given transformation T 
before every VariableExpression referring to the transformed variable, and
adds a DependenceExpression with the inverse of T before 
the original expression of the transformed variable. 

*/
public class ChangeOfBasis{
protected static final PolyhedralIRUserFactory _polyIRFact = PolyhedralIRUserFactory.eINSTANCE;
protected final SystemCallAnalysis analysis;

public static void CoB(AffineSystem system, String target, AffineFunction T) {
CoB(system, target, T, false);
}

public static void  CoB(AffineSystem system, String target, AffineFunction T, boolean force){
ChangeOfBasis s = new ChangeOfBasis(system);
if(system.getVariableDeclaration(target) == null){	//change of basis for use equation
UseEquation use = system.getUseEquation(target);
s.CoBForUseEquation(system, use, T, force);
}else{	//change of basis for variable
VariableDeclaration var = system.getVariableDeclaration(target);
s.CoBLegalityCheck(system, var, T);
s.CoBForVariable(system, var, T, force);
}
}

/**
*	Legality check for the change of basis
*	Change of Basis of the output variable of a use equation is not allowed	
*/
protected void CoBLegalityCheck(AffineSystem system, VariableDeclaration var, AffineFunction T) {
for (UseEquation use : system.getUseEquations())
for (VariableDeclaration varEq : use.getOutputs())
if (varEq.equals(var))
throw new RuntimeException("Change of Basis on the output of a UseEquation not allowed");
}

/**
* Change of Basis for the variable
*/
protected void CoBForVariable(AffineSystem system, VariableDeclaration var, AffineFunction T, boolean force){
//legality check if not force
if(!force){
VariableCoBPreCheck(system, var);
}
//call the variable transformation
Domain oldDomVarDecl = var.getDomain();
CoBVariableTransformation.CoBVariableTrans(system, var, T);
var.setDomain(var.getDomain().image(T));

//When the variable has an associated equation
if (system.getEquation(var.getName()) != null) {
//Create identity function with the new domain
AffineFunction identity = PolyhedralIRUtility.createIdentityFunction(var.getDomain());
//and compose it with the equation at the beginning of CoBed variable for consistent naming
DependenceExpression depExpr = (DependenceExpression)system.getEquation(var.getName()).getExpression();
depExpr.setDep(depExpr.getDep().compose(identity));
}

CoBVariablePostProcessing(system, var, oldDomVarDecl, T);
}

/**
* Change of Basis for a use equation
*/
protected void CoBForUseEquation(AffineSystem system, UseEquation use, AffineFunction T, boolean force){
//call the legality check if the CoB is not forced
if(!force)	UseEquationCoBPreCheck(use);

// New extension domain for the use equation
Domain newExtDom = use.getExtensionDomain().image(T);
AffineFunction Tinv = T.inverseInContext(use.getExtensionDomain(), null);

// Inputs: we build the list of expression "(f^{-1} \times Id_{d})@[...]", "d" being the dimension of the corresponding input on the subsystem
List<Expression> newInputs = new BasicEList<Expression>();
for (Expression inp : use.getInputs()) {
// Creating the affine function "(f^{-1} \times Id_{d})"
int d = inp.getContextDomain().getNIndices() - use.getExtensionDomain().getNIndices();
AffineFunction finvIdd = FunctionOperations.addLastDimensions(Tinv, d);

// Building the new input expression
DependenceExpression depExpr = _polyIRFact.createDependenceExpression(finvIdd, inp.copy());
newInputs.add(depExpr);
}

// Outputs
// A CoB with the function (f \time d) is applied to each output variable of the use equation
List<VariableDeclaration> newOutputs = new BasicEList<VariableDeclaration>();
for (VariableDeclaration oldOutput : use.getOutputs()) {
AffineFunction fOutput = FunctionOperations.addLastDimensions(T, oldOutput.getDomain().getNIndices()-use.getExtensionDomain().getNIndices());
this.CoBForVariable(system, oldOutput, fOutput, true);
newOutputs.add(oldOutput);
}

//construct the new parameters
AffineFunction parameters = (use.getParameters().compose(Tinv)).compose(PolyhedralIRUtility.createIdentityFunction(newExtDom));
// Create the UseEquation and add it to the system (while removing the old one)
UseEquation newUEq = _polyIRFact.createUseEquation(newExtDom, use.getSubSystem(), parameters, 
newInputs, newOutputs);
system.getUseEquations().add(newUEq);
system.getUseEquations().remove(use);
}

/**
* Change of Basis for the nth input expression of the use equation 
* Compose the inverse of the function T with the expression
*/
protected void UseEquationInputTransformation(AffineSystem system, UseEquation use, int n, Domain oldDomVarDecl, AffineFunction T){
//get the nth input expression
Expression exp = use.getInputs().get(n);
//construct a dependence function composed with the inverse of the function

Domain exprDomExp = exp.getExpressionDomain();
Domain oldDomVarDeclTrans = DomainOperations.translateParams(oldDomVarDecl, use.getParameters(), use.getExtensionDomain());
Domain contDomExp = exprDomExp.intersection(oldDomVarDeclTrans);
//Domain contDomExp = exp.getContextDomain();		// Note: does not work, because look at the (already transformed) var decl in the main syst


AffineFunction Tinv = T.inverseInContext(contDomExp, null);
DependenceExpression depExp = _polyIRFact.createDependenceExpression(Tinv, exp.copy());
use.getInputs().set(n, depExp);
}


/**
* Legality check for the change of basis for variables
* The change of basis is applied for the input/out variable of a system is not allowd by default
* The change of basis for the output variable of the use equation alone is not allow by default
*/
protected void VariableCoBPreCheck(AffineSystem system, VariableDeclaration target){
if(target.isInput() || target.isOutput()){
throw new RuntimeException("CoB for the variable " + target.getName() + " is changing the signature of the system! Please call the force command to force the CoB!");
}

}

/**
* 	Legality Check of the change of basis for Use Equation
* 	Change of basis for use equation whose output is also the output of the system is not allowed by default
*/
protected void UseEquationCoBPreCheck(UseEquation use){
for(VariableDeclaration var: use.getOutputs()){
if(var.isOutput()){
throw new RuntimeException("CoB for the use equation " + use.getLabel() + " is changing the signature of the system! Please call the force command to force the CoB!");	
}
}
}

/**
*	The postporcessing of CoB for variable
*	If the target Variable is the input/output variable of the subsystem, corresponding CoB 
*	is applied to the UseEquation in the calling system
* 	The CoB has to be applied until the CoB does not effect any calling system
*/
protected void CoBVariablePostProcessing(AffineSystem system, VariableDeclaration var, Domain oldDomVarDecl, AffineFunction T){
//if the variable is an input of a non-top level system 
if(var.isInput() && !this.analysis.isTopLevelSystem(system)){
//get the list of calling system
List<AffineSystem> callingSystems = this.analysis.getCallingSystems(system);
//figure out corresponding number of the input expression, start from 0
int num = 0;
for(int i = 0; i < system.getInputs().size(); i++){
if(system.getInputs().get(i).getName().contentEquals(var.getName())){
num = i;
}
}
//for each calling system apply the change of basis
for(AffineSystem syst : callingSystems){
for(UseEquation useEq : this.analysis.getUseEquations(syst, system.getName())){
//construct the function used for the CoB
AffineFunction function = FunctionOperations.translateParams(T, useEq.getParameters(), useEq.getExtensionDomain().copy());
UseEquationInputTransformation(system, useEq, num, oldDomVarDecl, function);
}
}
}

//if the variable is an output of a non-top level system
if(var.isOutput() && !this.analysis.isTopLevelSystem(system)){
OutputVariableProcessing(system, var, T);
}
}

/**
* post processing for the output variable, recursively called until it is not effect nay calling system 
*/
protected void OutputVariableProcessing(AffineSystem system, VariableDeclaration var, AffineFunction T) {
//find the number of the output variables
int num = -1;
for(int i = 0; i < system.getOutputs().size(); i++){
if(system.getOutputs().get(i).getName().contentEquals(var.getName())){
num = i;
}
}

//get the calling systems
List<AffineSystem> systems = this.analysis.getCallingSystems(system);
for(AffineSystem syst : systems){
for(UseEquation useEq : this.analysis.getUseEquations(syst, system.getName())){
//get the affine function 
AffineFunction function = FunctionOperations.translateParams(T, useEq.getParameters(), useEq.getExtensionDomain().copy());
//get the output variable in the calling system
VariableDeclaration new_var = syst.getVariableDeclaration(useEq.getOutputs().get(num).getName());
//apply the change of basis on the output variable 
CoBVariableTransformation.CoBVariableTrans(syst, new_var, function);
new_var.setDomain(new_var.getDomain().image(function));
if((new_var.isOutput())){
OutputVariableProcessing(syst, new_var, function);
}
}
}		
}

protected ChangeOfBasis(AffineSystem system){
this.analysis = new SystemCallAnalysis(system.getContainerProgram());
}

public static class CoBVariableTransformation extends PolyhedralIRTomTransformation {
protected final AffineFunction T;
protected final AffineFunction Tinv;
protected final VariableDeclaration target;

public static void CoBVariableTrans(AffineSystem system, VariableDeclaration var, AffineFunction T) {
CoBVariableTransformation s = new CoBVariableTransformation(var, T);
s.transform(system);
}

protected CoBVariableTransformation(VariableDeclaration var, AffineFunction T){
this.target = var;
this.T = T;
this.Tinv = T.inverseInContext(target.getDomain(), null);
}

@Override
protected EObject apply(EObject o) throws VisitFailure {
try{
EObject t =	
tom_make_BottomUp(tom_make_CoB(target,T,Tinv)).visitLight((AffineSystem)o, tom.mapping.GenericIntrospector.INSTANCE);
//t = `TopDown(CleanUp()).visitLight(t,new PolyIRMappingIntrospector());
return t;
}catch(ClassCastException e) {
throw new IllegalArgumentException(o+ "isn't an AffineSystem");
}
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
private static boolean tom_equal_term_boolean(boolean t1, boolean t2) {
return  t1==t2 ;
}
private static boolean tom_is_sort_boolean(boolean t) {
return  true ;
}
private static boolean tom_equal_term_int(int t1, int t2) {
return  t1==t2 ;
}
private static boolean tom_is_sort_int(int t) {
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
private static Expression tom_make_var(VariableDeclaration _varDecl) { 
return org.polymodel.polyhedralIR.internal.PolyhedralIRTomFactory.createVar(_varDecl);
}
private static VariableDeclaration tom_get_slot_var_varDecl(Expression t) {
return ((VariableExpression)t).getVarDecl();
}
private static boolean tom_is_fun_sym_eq(StandardEquation t) {
return t instanceof StandardEquation;
}
private static StandardEquation tom_make_eq(VariableDeclaration _variable, Expression _expression) { 
return org.polymodel.polyhedralIR.internal.PolyhedralIRTomFactory.createEq(_variable, _expression);
}
private static VariableDeclaration tom_get_slot_eq_variable(StandardEquation t) {
return ((StandardEquation)t).getVariable();
}
private static Expression tom_get_slot_eq_expression(StandardEquation t) {
return ((StandardEquation)t).getExpression();
}
private static Expression tom_make_depExpr(AffineFunction _dep, Expression _expr) { 
return org.polymodel.polyhedralIR.internal.PolyhedralIRTomFactory.createDepExpr(_dep, _expr);
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
public static class CoB extends tom.library.sl.AbstractStrategyBasic {
private VariableDeclaration target;
private AffineFunction T;
private AffineFunction Tinv;
public CoB(VariableDeclaration target, AffineFunction T, AffineFunction Tinv) {
super(tom_make_Identity());
this.target=target;
this.T=T;
this.Tinv=Tinv;
}
public VariableDeclaration gettarget() {
return target;
}
public AffineFunction getT() {
return T;
}
public AffineFunction getTinv() {
return Tinv;
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
if (tom_is_sort_StandardEquation(v)) {
return ((T)visit_StandardEquation(((StandardEquation)v),introspector));
}
if (!(( null  == environment))) {
return ((T)any.visit(environment,introspector));
} else {
return any.visitLight(v,introspector);
}
}
@SuppressWarnings("unchecked")
public StandardEquation _visit_StandardEquation(StandardEquation arg, tom.library.sl.Introspector introspector)
 throws tom.library.sl.VisitFailure {
if (!(( null  == environment))) {
return ((StandardEquation)any.visit(environment,introspector));
} else {
return any.visitLight(arg,introspector);
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
public StandardEquation visit_StandardEquation(StandardEquation tom__arg, tom.library.sl.Introspector introspector)
 throws tom.library.sl.VisitFailure {
{
{
if (tom_is_sort_StandardEquation(tom__arg)) {
if (tom_is_sort_StandardEquation(((StandardEquation)tom__arg))) {
if (tom_is_fun_sym_eq(((StandardEquation)((StandardEquation)tom__arg)))) {
VariableDeclaration tom_var=tom_get_slot_eq_variable(((StandardEquation)tom__arg));

//If the equation is for the target variable
if (
tom_var.equals(target)) {
//Add DependenceExpression using Tinv
return 
tom_make_eq(tom_var,tom_make_depExpr(Tinv,tom_get_slot_eq_expression(((StandardEquation)tom__arg))));
}

}
}
}
}
}
return _visit_StandardEquation(tom__arg,introspector);
}
@SuppressWarnings("unchecked")
public Expression visit_Expression(Expression tom__arg, tom.library.sl.Introspector introspector)
 throws tom.library.sl.VisitFailure {
{
{
if (tom_is_sort_Expression(tom__arg)) {
if (tom_is_sort_Expression(((Expression)tom__arg))) {
if (tom_is_fun_sym_var(((Expression)((Expression)tom__arg)))) {
VariableDeclaration tom_v=tom_get_slot_var_varDecl(((Expression)tom__arg));
if (
tom_v.equals(target)) return 
tom_make_depExpr(T.copy(),tom_make_var(tom_v)); 
}
}
}
}
}
return _visit_Expression(tom__arg,introspector);
}
}
private static  tom.library.sl.Strategy  tom_make_CoB(VariableDeclaration t0, AffineFunction t1, AffineFunction t2) { 
return new CoB(t0,t1,t2);
}

}
}
