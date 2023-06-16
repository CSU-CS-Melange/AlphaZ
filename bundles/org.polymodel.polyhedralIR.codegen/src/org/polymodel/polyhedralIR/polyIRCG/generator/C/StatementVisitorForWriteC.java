// *******************************************************************************
// Copyright (C) 2008 Sanjay Rajopadhye. All rights reserved
// Author: DaeGon Kim 
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// as published by the Free Software Foundation; either version 2
// of the License, or (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, If not, see 
// http://www.gnu.org/licenses/, or write to the Free Software 
// Foundation, Inc., 51 Franklin Street, Fifth Floor,
// Boston, MA  02110-1301, USA.
// *******************************************************************************

package org.polymodel.polyhedralIR.polyIRCG.generator.C;


import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraint;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.impl.PolyhedralIRInheritedDepthFirstVisitorImpl;
import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.Statement;
import org.polymodel.polyhedralIR.polyIRCG.C.CLoop;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenUtility;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.util.WhileSystemUtility;


public class StatementVisitorForWriteC extends PolyhedralIRInheritedDepthFirstVisitorImpl {
	protected static final PolyIRCGUserFactory _fact = PolyIRCGUserFactory.INSTANCE;

	//Input
	protected final CodeUnit unit;
	protected final TargetMapping targetMapping;
	private String verifyPrefix;
	
	//local
	protected ComputeReductionNumber reductionNumbers;
	
	/**
	 * Constructs a CodeUnit to execute a system using demand-driven code generation.
	 * WriteC is per system
	 * 
	 * @param system
	 * @param unit
	 */
	public static void construct(AffineSystem system, CodeUnit unit) {
		StatementVisitorForWriteC visitor = new StatementVisitorForWriteC(unit, system.getTargetMapping());
		system.accept(visitor);
	}
	
	protected StatementVisitorForWriteC(CodeUnit unit, TargetMapping mapping) {
		this.unit = unit;
		this.targetMapping = mapping;
		this.verifyPrefix = unit.getSystem().getName().endsWith("_verify") ? "verify_" : "";
	}

	@Override
	public void inAffineSystem(AffineSystem a) {
		reductionNumbers = new ComputeReductionNumber();
		a.accept(reductionNumbers);
		
		Function function = _fact.createFunction(a.getName(), "void");
		//This is the entry point for executing this system
		function.setEntryPoint(true);
		
		//Register all variables
		for (VariableDeclaration var : a.getInputs()) {
			function.getInputs().add(unit.findVariable(targetMapping.getMemoryMaps().get(var).getSpace().getName()));
		}
		for (VariableDeclaration var : a.getOutputs()) {
			function.getOutputs().add(unit.findVariable(targetMapping.getMemoryMaps().get(var).getSpace().getName()));
		}
		for (VariableDeclaration var : a.getLocals()) {
			function.getLocals().add(unit.findVariable(targetMapping.getMemoryMaps().get(var).getSpace().getName()));
		}
		
		//Add parameter checking
		function.getBodies().add(_fact.createParameterCheck(a.getParameters()));
		//Add malloc
		function.getBodies().add(_fact.createVariableInitialization(function));
		
		if (a.getWhileInfo() != null) { //If this is a while system
			//Add flag reset
			function.getBodies().add(_fact.createFlagVariableReset(function));
			
			AffineExpression affineLowerbound = WhileSystemUtility.historyOfCondition(a);
			
			// When to start checking the termination condition 
			function.setNumberOfTimeIterationsForFirstConditionCheck(affineLowerbound.toString());			
		}
		
		if (a.getWhileInfo() != null) { //in case of a while system
			/*
			 * Generate loops only for the duplicates of output variables which
			 * are added as local variables. The name ends with "__Wlocal__Main"
			 */
			for (VariableDeclaration var : a.getLocals()) {
				if (!var.getName().endsWith(WhileSystemUtility.WHILE_LOCAL_MAIN_VAR_POSTFIX) || 
						var.getName().startsWith(CodeGenConstantsForC.FLAG_PREFIX)) {
					continue;
				}
				
				addLoop(a, function, var);
			}
			
			/* 
			 * This is added to distinguish the loops that should appear 
			 * after the time (or while) loop.
			 */
			function.getBodies().add(_fact.createBody("//Copy output"));
			
			for (VariableDeclaration varOut : a.getOutputs()) {
				addLoopToCopyOutput(a, function, varOut);
			}
		} else {
			//Create a loop that evaluate all points of the output
			for (VariableDeclaration var : a.getOutputs()) {
				addLoop(a, function, var);
			}
		}
		
		//Add free
		function.getBodies().add(_fact.createVariableFinalization(function));
		
		unit.getFunctions().add(function);	
	}

	

	private void addLoop(AffineSystem a, Function function,
			VariableDeclaration var) {
		//Create a statement that scans an output variable, and stores 
		// the result to the memory location
		List<String> evalFuncParams = new LinkedList<String>();
		for (Variable iv : var.getDomain().getParams()) {
			evalFuncParams.add(iv.toString());
		}for (Variable iv : var.getDomain().getIndices()) {
			evalFuncParams.add(iv.toString());
		}
		Statement stmt = _fact.createStatement(
				CodeGenUtility.createStatementName(unit, 0), var.getDomain().copy(), 
				CodeGenConstantsForC.WRITEC_EVAL_PREFIX+this.verifyPrefix+var.getName()+"("+
						CodeGenUtility.toStringList(evalFuncParams, ",")+")");
		
		// Remove time domain from the statements in the loop. So that an 
		// outer loop is not generated for time loop. We are inserting this 
		// time loop manually when generating code. Check the BaseFunction.xtend
		if (unit.getSystem().getWhileInfo() != null && function.isEntryPoint()) {
			List<Variable> vl = new ArrayList<Variable>(stmt.getDomain().getIndices());
			vl.remove(0);
			//(t,i,j,...->i,j,...)
			AffineFunction af = PolyhedralIRUtility.createProjection(stmt.getDomain(), vl);
			org.polymodel.polyhedralIR.Domain newDomain = stmt.getDomain().image(af);
			
			// Above newDomain has indices names starting from t, i, ... 
			// But we do not need t as the first dimension since that is 
			// the one we just removed and this will make issues in the 
			// generated code. Therefore, we need to change the names of 
			// indices. For that we create a domain {i,j,... | 0==0} and get 
			// the intersection of this domain with newDomain. 
			// This will change the indices to i,j,...  
			org.polymodel.polyhedralIR.Domain trueDomain = 
					PolyhedralIRUserFactory.eINSTANCE.createDomain(stmt.getDomain().getParams(), 
							vl, 
							IntExpressionBuilder.constraintSystem(constraint(affine(term(0)), affine(term(0)), ComparisonOperator.EQ)));
			newDomain = trueDomain.intersection(newDomain);
			
			stmt.setDomain(newDomain);
		}
		
		addStatementToLoop(a, function, stmt);
	}
	
	private void addLoopToCopyOutput(AffineSystem a, Function function,
			VariableDeclaration varOut) {
		//Create a statement that scans an output variable, and stores the result to the memory location
		List<String> varOutIndices = new LinkedList<String>();
		for (Variable iv : varOut.getDomain().getIndices()) {
			varOutIndices.add(iv.toString());
		}
		
		VariableDeclaration varOutLocalMain = a.getVariableDeclaration(
				varOut.getName()+WhileSystemUtility.WHILE_LOCAL_MAIN_VAR_POSTFIX);
		List<String> varOutLocalMainIndices = new LinkedList<String>();
		for (Variable iv : varOutLocalMain.getDomain().getIndices()) {
			varOutLocalMainIndices.add(iv.toString());
		}
		
		Statement stmt = _fact.createStatement(
				CodeGenUtility.createStatementName(unit, 0), varOut.getDomain().copy(), 
				varOut.getName()+"("+CodeGenUtility.toStringList(varOutIndices, ",")+
					") = " + varOutLocalMain.getName()+"("+
					CodeGenUtility.toStringList(varOutLocalMainIndices, ",")+")");
		
		addStatementToLoop(a, function, stmt);
	}

	private void addStatementToLoop(AffineSystem a, Function function,
			Statement stmt) {
		CLoop loop = _fact.createCLoop(a.getParameters(), 0);
		loop.getStatements().add(stmt);
		function.getBodies().add(loop);
	}
	
	@Override
	public void outStandardEquation(StandardEquation s) {
		Function function = _fact.createFunction(
				CodeGenConstantsForC.WRITEC_EVAL_PREFIX+this.verifyPrefix+s.getVariable().getName(),
				s.getVariable().getType()
		);
		
		//Add loop indices as function parameters
		for (Variable iv : s.getVariable().getDomain().getIndices()) {
			function.getParameters().add(_fact.createBasicVariable(iv.toString(), "int"));
		}
		
		SpaceTimeLevel stlevel = targetMapping.getSpaceTimeLevel(0);
		StringBuffer sbody = new StringBuffer();
		
		//Get the access function
		AffineFunction accessFunc = stlevel.getAccessFunction(s.getVariable());
		//compose it with identity of the variable domain, just so that names match
		accessFunc = accessFunc.compose(PolyhedralIRUtility.createIdentityFunction(s.getVariable().getDomain()));
		//Pretty print the access function to pass the indices
		List<String> access = new LinkedList<String>();
		for (AffineExpression ile : accessFunc.getExpressions()) {
			access.add(ile.simplify().toString(OUTPUT_FORMAT.C));
		}
		
		String valAccess = targetMapping.getMemoryMaps().get(s.getVariable()).getSpace().getName();
		if (access.size() > 0) {
			valAccess += "("+CodeGenUtility.toStringList(access, ",")+")";
		}
		String flagAccess = CodeGenConstantsForC.FLAG_PREFIX+valAccess;
		
		//Pre compute strings for self-dependence check
		StringBuffer iterationFormat = new StringBuffer();
		for (int i = 0; i < s.getVariable().getDomain().getNIndices(); i++) {
			if (iterationFormat.length() > 0) {
				iterationFormat.append(",");
			}
			iterationFormat.append("%d");
		}
		StringBuffer iterationParams = new StringBuffer();
		for (int i = 0; i < s.getVariable().getDomain().getNIndices(); i++) {
			//Add "," from the beginning, to make it work in scalar variables
			iterationParams.append(","+s.getVariable().getDomain().getIndices().get(i).toString());
		}

		//Generate code that checks for the flag and computes the RHS of an equation
		//This code is very specific to WriteC, so not even trying to make it generic and using BasicStatement
		sbody.append(String.format("if ( %s == 'N' ) {\n", flagAccess));
		sbody.append(String.format("	%s = 'I';\n", flagAccess));
		sbody.append(String.format(	"//Body for %s\n", s.getVariable().getName()));
		sbody.append(String.format("	%s = %s;\n", valAccess,  ExpressionPrinterForWriteC.print(s.getExpression())));
		sbody.append(String.format("	%s = 'F';\n", flagAccess));
		sbody.append(String.format("} else if ( %s == 'I' ) {\n", flagAccess));
		sbody.append(String.format("	printf(\"There is a self dependence on %s at (%s) \\n\"%s);\n",
										s.getVariable().getName(), iterationFormat, iterationParams));
		sbody.append("	exit(-1);\n");
		sbody.append("}\n");
		sbody.append(String.format("return %s;", valAccess));
		
		function.getBodies().add(_fact.createBody(sbody.toString()));
		unit.getFunctions().add(function);	
	}
	@Override
	public void outReduceExpression(ReduceExpression r) {
		if (r.getContainerEquation() instanceof UseEquation)
			throw new RuntimeException("TODO: implement this method for UseEquation");
		
		Type type = r.getExpressionType();
		
		String name = CodeGenConstantsForC.getReductionFunctionName((StandardEquation) r.getContainerEquation(), reductionNumbers.getReductionNumber(r));
		
		Function function = _fact.createFunction(name, type);

		//Create domain to scan
//		Domain[] scanDoms = CodeGenUtility.createReductionScanningDomain(r, CodeGenConstantsForC.REDUCTION_PARAM_PREFIX);
		Domain[] scanDoms = CodeGenUtility.createReductionScanningDomain(r);
		ParameterDomain extendedParam = (ParameterDomain)scanDoms[0];
		Domain scanDom = scanDoms[1];
		
		//Add the parameters to function parameters
		for (int i = r.getContextDomain().getNParams(); i < extendedParam.getNParams(); i++) {
			function.getParameters().add(_fact.createBasicVariable(extendedParam.getParams().get(i).toString(), "int"));
		}
		//Loop to scan the constructed slice of the reduction
		CLoop loop = _fact.createCLoop(extendedParam, 0);
		//Reduction body
		String expr = ExpressionPrinterForWriteC.print(r.getExpr());
		//Make it accumulation
		expr = CodeGenUtilityForC.createAccumulation(r.getOP(), r.getExpressionType(), CodeGenConstantsForC.REDUCE_VAR_NAME, expr);
		loop.getStatements().add(_fact.createStatement(CodeGenUtility.createStatementName(unit, 0), scanDom, expr));

		//Create a body to initialize variable used during reduction
		Body reduceVar = _fact.createBody(r.getExpressionType() + " "+CodeGenConstantsForC.REDUCE_VAR_NAME+" = " + r.getIdentityValue()+";");
		//Body for returning the result
		Body returnStatement = _fact.createBody("return "+CodeGenConstantsForC.REDUCE_VAR_NAME+";");
		
		//Set all bodies to the function
		function.getBodies().add(reduceVar);
		function.getBodies().add(loop);
		function.getBodies().add(returnStatement);
		
		unit.getFunctions().add(function);
	}
}
