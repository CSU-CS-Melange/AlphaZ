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
				EObject t =	`BottomUp(CoB(target,T,Tinv)).visitLight((AffineSystem)o, tom.mapping.GenericIntrospector.INSTANCE);
				//t = `TopDown(CleanUp()).visitLight(t,new PolyIRMappingIntrospector());
				return t;
			}catch(ClassCastException e) {
				throw new IllegalArgumentException(o+ "isn't an AffineSystem");
			}
		}
		
		%include { polyhedralIR.tom }
		%include { sl.tom }
	
		%strategy CoB(target:VariableDeclaration, T:AffineFunction, Tinv:AffineFunction) extends Identity() {
			//Visit all expressions in a system
			visit Expression {
				//When variable of VariableExpression is the target, create a DependenceExpression using T
				var(v) -> { if (`v.equals(target)) return `depExpr(T.copy(), var(v)); }
			}
			//Visit all equations
			visit StandardEquation {
				eq(var, expr) -> {
					//If the equation is for the target variable
					if (`var.equals(target)) {
						//Add DependenceExpression using Tinv
						return `eq(var, depExpr(Tinv, expr));
					}
				}
			}
		}
	}
}