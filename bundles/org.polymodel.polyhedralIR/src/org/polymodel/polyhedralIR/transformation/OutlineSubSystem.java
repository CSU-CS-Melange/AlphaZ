package org.polymodel.polyhedralIR.transformation;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Equation;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.impl.PolyhedralIRDepthFirstVisitorImpl;
import org.polymodel.polyhedralIR.transformation.helper.AddLocal;
import org.polymodel.polyhedralIR.transformation.helper.GetAccessedVarDecl;
import org.polymodel.polyhedralIR.transformation.helper.ReplaceVariableExpression;

public class OutlineSubSystem {
	
	/* Different versions of outlining (in increasing complexity):
	 - Version 1: No extension domain - the inputs are all variables
	 - Version 1.5: No extension domain - the inputs can be expressions (specified as a list of inputs)
	 
	 TODO [To be implemented]
	 - Version 2: With an extension domain, but with the dimensions specified and placed as the first dimensions of the outlined variables
	 - Version 3: With an extension domain - we have to find these dimensions + a correct CoB to place them correctly...
	*/
	
	/**
	 * Outlining V1 : No extension domain. Moreover, the input expression of the constructed UseEquation will be
	 * 		only variables.
	 * 
	 * @param prog : the program that contains the system sys
	 * @param syst : the affine system in which we are doing the outlining
	 * @param leq : the list of equation to outline (UseEquations and StandardEquations)
	 */
	public static void outline(Program prog, AffineSystem syst, List<Equation> leq) {
		// Checking containement of the inputs
		if (!prog.getSystems().contains(syst))
			throw new RuntimeException("Outlining: the program do not contains the affine system");
		for (Equation eq:leq) {
			if (eq instanceof StandardEquation)
				if (!syst.getEquations().contains(eq))
					throw new RuntimeException("The StEquation " + eq.toString() + " is not a subequation of the system");
			if (eq instanceof UseEquation)
				if (!syst.getUseEquations().contains(eq))
					throw new RuntimeException("The UseEquation " + eq.toString() + " is not a subequation of the system");
		}
		
		
		/* Note about the variable declaration of the outlined subsystem:
		   - The inputs are used by lEq, but not defined by these equations				=> lInputMain
		   - The outputs are defined inside lEq, and used outside these equations		=> lOutputMain
		   - The locals are defined inside lEq, and not used outside 					=> lLocalMain
		*/
		List<VariableDeclaration> lAccessedEq = GetAccessedVarDecl.getAccessedVarDecl(leq);
		List<VariableDeclaration> lDefinedEq = new BasicEList<VariableDeclaration>();
		for (Equation eq : leq) {
			if (eq instanceof StandardEquation)
				lDefinedEq.add(((StandardEquation) eq).getVariable());
			if (eq instanceof UseEquation)
				lDefinedEq.addAll( ((UseEquation) eq).getOutputs());
		}
		List<Equation> leqCompl = new BasicEList<Equation>();
		for (StandardEquation seq : syst.getEquations()) {
			if (!leq.contains(seq))
				leqCompl.add(seq);
		}
		for (UseEquation ueq : syst.getUseEquations()) {
			if (!leq.contains(ueq))
				leqCompl.add(ueq);
		}
		List<VariableDeclaration> lAccessedOutside = GetAccessedVarDecl.getAccessedVarDecl(leqCompl);
		lAccessedOutside.addAll(syst.getOutputs());
		
		List<VariableDeclaration> lInputMain = new BasicEList<VariableDeclaration>();
		for (VariableDeclaration varAcc : lAccessedEq) {
			if (!lDefinedEq.contains(varAcc))
				lInputMain.add(varAcc);
		}
		List<VariableDeclaration> lOutputMain = new BasicEList<VariableDeclaration>();
		List<VariableDeclaration> lLocalMain = new BasicEList<VariableDeclaration>();
		for (VariableDeclaration varDef : lDefinedEq) {
			if (lAccessedOutside.contains(varDef))
				lOutputMain.add(varDef);
			else
				lLocalMain.add(varDef);
		}
		
		
		/* Building the outlined system
		 - Name (be careful that it does no overlap with another existing system in the program)
		 - Copy the inputs/outputs/locals declarations
		 - Copy leq to get the new lists of StandardEquation/UseEquation (while replacing the variable declaration by correct ones)
		 - Copy the ParameterDomain of the original system
		*/
		PolyhedralIRUserFactory _polyIR = PolyhedralIRUserFactory.eINSTANCE;
		String nameOutlined = findOutlinedName(prog, syst.getName());
		ParameterDomain paramDomOutlined = (ParameterDomain) syst.getParameters().copy();
		AffineSystem systOutlined = _polyIR.createAffineSystem(nameOutlined, paramDomOutlined);
		
		List<VariableDeclaration> lInputOutlined = systOutlined.getInputs();
		for (VariableDeclaration varInp : lInputMain)
			lInputOutlined.add(_polyIR.createVariableDeclaration(varInp.getName(), varInp.getType(), varInp.getDomain().copy()));
		List<VariableDeclaration> lOutputOutlined = systOutlined.getOutputs();
		for (VariableDeclaration varOut : lOutputMain)
			lOutputOutlined.add(_polyIR.createVariableDeclaration(varOut.getName(), varOut.getType(), varOut.getDomain().copy()));
		List<VariableDeclaration> lLocalOutlined = systOutlined.getLocals();
		for (VariableDeclaration varLoc : lLocalMain)
			lLocalOutlined.add(_polyIR.createVariableDeclaration(varLoc.getName(), varLoc.getType(), varLoc.getDomain().copy()));
		
		// Visitor creation
		List<VariableDeclaration> lVarMain = new BasicEList<VariableDeclaration>();
		lVarMain.addAll(lInputMain);
		lVarMain.addAll(lOutputMain);
		lVarMain.addAll(lLocalMain);
		List<VariableDeclaration> lVarNew = new BasicEList<VariableDeclaration>();
		lVarNew.addAll(lInputOutlined);
		lVarNew.addAll(lOutputOutlined);
		lVarNew.addAll(lLocalOutlined);
		UpdateOutlinedEquationVisitor visitor = new UpdateOutlinedEquationVisitor(lVarMain, lVarNew);
		
		List<StandardEquation> lseqOutlined = systOutlined.getEquations();
		List<UseEquation> lueqOutlined = systOutlined.getUseEquations();
		for (Equation eqMain : leq) {
			if (eqMain instanceof StandardEquation) {
				Expression expr = ((StandardEquation) eqMain).getExpression().copy();
				expr.accept(visitor);
				
				int k = lVarMain.indexOf(((StandardEquation) eqMain).getVariable());
				lseqOutlined.add(_polyIR.createStandardEquation(lVarNew.get(k), expr));
			} else if (eqMain instanceof UseEquation) {
				Domain extDomOutlined = ((UseEquation) eqMain).getExtensionDomain().copy();
				AffineSystem subSyst = ((UseEquation) eqMain).getSubSystem();
				AffineFunction paramsOutlined = ((UseEquation) eqMain).getParameters().copy();
				
				List<Expression> linputsOutlined = new BasicEList<Expression>();
				for (Expression inpExp : ((UseEquation) eqMain).getInputs()) {
					Expression cpInpExp = inpExp.copy();
					cpInpExp.accept(visitor);
					linputsOutlined.add(cpInpExp);
				}
				List<VariableDeclaration> loutputsOutlined = new BasicEList<VariableDeclaration>();
				for (VariableDeclaration varOut : ((UseEquation) eqMain).getOutputs()) {
					int k = lVarMain.indexOf(varOut);
					loutputsOutlined.add(lVarNew.get(k));
				}
				
				lueqOutlined.add(_polyIR.createUseEquation(extDomOutlined, subSyst, paramsOutlined,
						linputsOutlined, loutputsOutlined));
			} else
				throw new RuntimeException("Equation is not a StandardEquation and not a UseEquation");
		}
		
		prog.getSystems().add(systOutlined);
		
		
		/* Updating the main system:
		 - Remove all the Equation of the system that are inside leq
		 - Add a new UseEquation to the outlined system
		 - Clean the local variable (those corresponding to lLocalSs)
		*/
		// Removing the StandardEquation of leq
		List<StandardEquation> removeStEq = new BasicEList<StandardEquation>();
		for (StandardEquation stEq : syst.getEquations()) {
			if (leq.contains(stEq))
				removeStEq.add(stEq);
		}
		for (StandardEquation stEq : removeStEq)
			syst.getEquations().remove(stEq);
		
		// Removing the UseEquation of leq
		List<UseEquation> removeUseEq = new BasicEList<UseEquation>();
		for (UseEquation uEq : syst.getUseEquations()) {
			if (leq.contains(uEq))
				removeUseEq.add(uEq);
		}
		for (UseEquation uEq : removeUseEq)
			syst.getUseEquations().remove(uEq);
		
		// Adding the UseEquation for the outline
		//   Note: empty extension domain / same parameters
		Domain extDom = _polyIR.createDomain(syst.getParameters().getParams(), new BasicEList<Variable>(), new BasicEList<IntConstraintSystem>());
		
		List<AffineExpression> exprParamOutline = new BasicEList<AffineExpression>();
		for (Variable var : syst.getParameters().getParams())
			exprParamOutline.add(IntExpressionBuilder.affine(var));
		
		AffineFunction paramOutline = _polyIR.createAffineFunction(syst.getParameters().getParams(), new BasicEList<Variable>(), exprParamOutline);
		
		List<Expression> lInputMainExpr = new BasicEList<Expression>();
		for (VariableDeclaration var : lInputMain)
			lInputMainExpr.add(_polyIR.createVariableExpression(var));
		
		UseEquation ueqOutline = _polyIR.createUseEquation(extDom, systOutlined, paramOutline, lInputMainExpr, lOutputMain);
		syst.getUseEquations().add(ueqOutline);
		
		
		// Cleaning the local variable of system
		// TODO: when the PRDG will be working, use "RemoveUnusedVariables.apply(syst);"
		List<Equation> leqStUse = new BasicEList<Equation>();
		leqStUse.addAll(syst.getEquations());
		leqStUse.addAll(syst.getUseEquations());
		List<VariableDeclaration> lUsedMain = GetAccessedVarDecl.getAccessedVarDecl(leqStUse);
		List<VariableDeclaration> toBeRemoved = new BasicEList<VariableDeclaration>();
		for (VariableDeclaration var : syst.getLocals()) {
			if (!lUsedMain.contains(var))
				toBeRemoved.add(var);
		}
		for (int k=0; k<toBeRemoved.size(); k++)
			syst.getLocals().remove(toBeRemoved.get(k));
	}
	
	/**
	 * Outlining V1.5 : No extension domain, specify the input expressions of the constructed UseEquation
	 * 
	 * @param prog : the program that contains the system sys
	 * @param syst : the affine system in which we are doing the outlining
	 * @param leq : the list of equation to outline (UseEquations and StandardEquations)
	 * @param inputsUse : the input expressions of the created use (calling the outlined subsystem)
	 * 				=> these expressions should be subexpressions of leq.
	 */
	public static void outline(Program prog, AffineSystem syst, List<Equation> leq, List<Expression> inputsUse) {
		// Outlining with only variable as input expressions
		String outSystName = findOutlinedName(prog,syst.getName());
		outline(prog,syst,leq);
		if (inputsUse==null)
			return;
		
		// Getting the created AffineSystem and the UseEquation
		AffineSystem outLinedSyst = prog.getSystem(outSystName);
		UseEquation outLinedUseEq = null;
		for (UseEquation ueq : syst.getUseEquations())
			if (ueq.getSubSystem().getName().compareTo(outSystName)==0)
				outLinedUseEq = ueq;
		assert(outLinedUseEq!=null);	// By construction, we should find a unique UseEquation (to the new subsystem) in the main system
		
		// Check that the given expression only have input variables
		List<VariableDeclaration> lvarAccessed = GetAccessedVarDecl.getAccessedVarDeclExpr(inputsUse);		
		if (outLinedSyst.getInputs().containsAll(lvarAccessed))
			throw new RuntimeException("One of the expression uses illegal variables");
		
		// Update the variableDeclaration of "inputsUse"'s expressions
		for (Expression inpUseExpr : inputsUse) {
			List<VariableDeclaration> laccessed = GetAccessedVarDecl.getAccessedVarDecl(inpUseExpr);
			for (VariableDeclaration target : laccessed) {
				VariableDeclaration replace = outLinedSyst.getVariableDeclaration(target.getName());
				ReplaceVariableExpression.transform(inpUseExpr, target, replace);
			}
		}
		
		// We find the inputs expressions in the outlined system
		List<VariableDeclaration> newInputs = AddLocal.addLocals(outLinedSyst, inputsUse);
		List<Equation> eqtoRemove = new BasicEList<Equation>();
		for (VariableDeclaration nInput : newInputs)
			eqtoRemove.add(outLinedSyst.getEquation(nInput.getName()));
		outLinedSyst.getEquations().removeAll(eqtoRemove);
		
		// We make them inputs, and change the useEquation of the main system
		outLinedSyst.getInputs().addAll(newInputs);
		outLinedUseEq.getInputs().addAll(inputsUse);
		outLinedSyst.getLocals().removeAll(newInputs);
		
		
		// Cleaning the unuseful variable inputs (in the UseEquation and the outlined system)
		List<Equation> leqSubSyst = new BasicEList<Equation>();
		leqSubSyst.addAll(outLinedSyst.getEquations());
		leqSubSyst.addAll(outLinedSyst.getUseEquations());
		List<VariableDeclaration> usedVar = GetAccessedVarDecl.getAccessedVarDecl(leqSubSyst);
		
		List<VariableDeclaration> unusedInputs = new BasicEList<VariableDeclaration>();
		List<Expression> lexprRemoved  = new BasicEList<Expression>();
		for (int k=0; k<outLinedSyst.getInputs().size(); k++) {
			if (!usedVar.contains(outLinedSyst.getInputs().get(k))) {
				unusedInputs.add(outLinedSyst.getInputs().get(k));
				lexprRemoved.add(outLinedUseEq.getInputs().get(k));
			}
		}
		
		outLinedSyst.getInputs().removeAll(unusedInputs);
		outLinedUseEq.getInputs().removeAll(lexprRemoved);
	}
	
	/**
	 * Method to find a correct name for the outlined subsystem
	 * 
	 * @param prog
	 * @param systName
	 * @return
	 */
	private static String findOutlinedName(Program prog, String systName) {
		String outlinedName = systName + "_outlined";
		
		int k = 0;
		boolean exist = true;
		while (exist) {
			if (prog.isContainingSystem(outlinedName + k))
				k++;
			else
				exist = false;
		}
		return outlinedName+k;
	}
	
	// ------------------------ Visitor on the expressions ------------------------
	private static class UpdateOutlinedEquationVisitor extends PolyhedralIRDepthFirstVisitorImpl {
		
		// Replace the old VariableDeclaration by the new ones
		protected List<VariableDeclaration> _oldVars;
		protected List<VariableDeclaration> _newVars;
		
		public UpdateOutlinedEquationVisitor(List<VariableDeclaration> lVarMain, List<VariableDeclaration> lVarNew) {
			if (lVarMain.size()!=lVarNew.size())
				throw new RuntimeException("Error to be debugged: lVarMain and lVarNew have different sizes");
			
			this._oldVars = lVarMain;
			this._newVars = lVarNew;
		}
		
		@Override
		public void inVariableExpression(VariableExpression ve) {
			int k = _oldVars.indexOf(ve.getVarDecl());
			VariableDeclaration nVarDecl = _newVars.get(k);
			ve.setVarDecl(nVarDecl);
		}
		
		
	} // UpdateOutlinedEquationVisitor
	
} // OutlineSubSystem
