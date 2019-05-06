package org.polymodel.polyhedralIR.polyIRCG.generator.C.scan;

import java.util.LinkedList;
import java.util.List;

import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.TargetMappingUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.BasicVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.FunctionParameter;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.OriginDomainVolume;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunction;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunctionDerivative;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.targetMapping.TargetMappingFactory;

public class ScanCUtility {

	private static final PolyIRCGUserFactory _fact = PolyIRCGUserFactory.INSTANCE;
	private static final PolyhedralIRUserFactory _userFact = PolyhedralIRUserFactory.eINSTANCE;
	
	public static OriginDomainVolume addOriginDomainVolumeFunction(CodeUnit unit){
		OriginDomainVolume odv = _fact.createOriginDomainVolume();
		
		Function function = _fact.createFunction("OriginVolume", "int");
		function.getBodies().add(odv);
		
		unit.getFunctions().add(function);
		
		return odv;
	}
	

	public static Function createNewFunctionSigature( AffineSystem affine_sys, CodeGenOptions options){
		CodeUnit unit = _fact.createCodeUnit(affine_sys);
		
		//reflect TargetMapping
		
		//for (MemorySpace ms : affine_sys.getTargetMapping().getMemorySpaces()) {
		TargetMapping tm = affine_sys.getTargetMapping();
		for(MemorySpace ms : tm.getMemorySpaces()){
			unit.getVariables().add(_fact.createCVariable(ms, options.flattenArrays, false));
		}
		//construct the function
		Function function = _fact.createFunction(affine_sys.getName(), "void");
		//Register all variables
		for (VariableDeclaration var : affine_sys.getInputs()) {
			function.getInputs().add(unit.findVariable(tm.getMemoryMaps().get(var).getSpace().getName()));
		}
		for (VariableDeclaration var : affine_sys.getOutputs()) {
			function.getOutputs().add(unit.findVariable(tm.getMemoryMaps().get(var).getSpace().getName()));
		}
		
		unit.getFunctions().add(function);
		
		//System.out.println(function.getSignature());
		
		return function;
	}
	
	public static List<CodeGenVariable> createIdentityCodeGenVariables(List<VariableDeclaration> vars, CodeGenOptions options){
		TargetMapping tm = TargetMappingFactory.eINSTANCE.createTargetMapping();
		SpaceTimeLevel stlevel = TargetMappingFactory.eINSTANCE.createSpaceTimeLevel();
		//create targetMapping for the variable declarations
		for(VariableDeclaration var: vars){
			stlevel.getSpaceTimeMaps().put(var.getName(), TargetMappingUserFactory.createIdentityStandardEquationSpaceTimeMap(var));
			tm.getMemoryMaps().put(var, TargetMappingUserFactory.createIdentityMemoryMap(var, tm.getMemorySpace(var.getName())));
		}
		tm.getSpaceTimeLevels().add(stlevel);
		
		List<CodeGenVariable> variables = new LinkedList<CodeGenVariable>();
		//Create variables based on TargetMapping
		for (MemorySpace ms : tm.getMemorySpaces()) {
			CodeGenVariable v = _fact.createCVariable(ms, options.flattenArrays, false);
			variables.add(v);
		}
		
		return variables;
	}
	
	public static VolumeFunction addVolumeFunction(CodeUnit unit){
		BasicVariable unknown = _fact.createBasicVariable("x", "int");
		VolumeFunction vf = _fact.createVolumeFunction(unknown);
		
		Function function = _fact.createFunction("Volume", "int");
		function.getBodies().add(vf);
		function.getParameters().add(unknown);
		
		unit.getFunctions().add(function);
		
		return vf;
	}

	public static VolumeFunctionDerivative addVolumeFunctionDerivative(CodeUnit unit){
		BasicVariable unknown = _fact.createBasicVariable("x", "int");
		VolumeFunctionDerivative vfd = _fact.createVolumeFunctionDerivative(unknown);
		
		Function function = _fact.createFunction("VolumePrime", "int");
		function.getBodies().add(vfd);
		function.getParameters().add(unknown);
		
		unit.getFunctions().add(function);
		
		return vfd;
	}

	
	public static BoundComputation addBoundComputation(CodeUnit unit, VolumeFunction volFunc, VolumeFunctionDerivative volFuncDeriv){
		//construct the bound computation function
		BasicVariable lb = _fact.createBasicVariable("lb", "int");
		BasicVariable ub = _fact.createBasicVariable("ub", "int");
		BasicVariable cons = _fact.createBasicVariable("constantTerm", "double");
		BasicVariable init = _fact.createBasicVariable("init", "int");

		BoundComputation bc = _fact.createBoundComputation(lb, ub, init, cons, volFunc, volFuncDeriv);
		Function function = _fact.createFunction("BoundComputation", "int");
		function.getParameters().add(lb);
		function.getParameters().add(ub);
		function.getParameters().add(cons);
		function.getParameters().add(init);
		function.getBodies().add(bc);
		
		unit.getFunctions().add(function);
		
		return bc;
	}
	
	/**
	 * Create memory access expression that access variable *var* with access function *access*
	 * @param var
	 * @param access
	 * @return
	 */
	public static String createMemoryAccessExpression(VariableDeclaration var, AffineFunction access){
		String exp = null;
		
		exp = var.getName();
		
		if(access != null){
			if(access.getDimRHS()>0){
				List<String> exprs = new LinkedList<String>();
				for (AffineExpression ae : access.getExpressions()) {
					exprs.add(ae.toString(OUTPUT_FORMAT.C));
				}
				for(String str: exprs){
					exp += "[" + str + "]";
				}
			}else{//if the access function is accessing a scalar variable, such as (i,j->)
				exp += "[0]";
			}
		}
		
		return exp;
	}
	
	/**
	 * Create assignment expression: lvar[LAccess] = rexp
	 * @param lvar
	 * @param LAccess
	 * @param rexp
	 * @return
	 */
	public static String createAssignmentExpression(VariableDeclaration lvar, AffineFunction LAccess, String rexp){
		String exp = null;
		
		//construct left hand side expression 
		String lexp = createMemoryAccessExpression(lvar, LAccess);
		
		exp = lexp + "=" + rexp;
		
		return exp;
	}
	
	/**
	 * Create assignment expression: lvar[LAccess] = rvar[RAccess]
	 * @param lvar
	 * @param LAccess
	 * @param rvar
	 * @param RAccess
	 * @return
	 */
	public static String createAssignmentExpression(VariableDeclaration lvar, AffineFunction LAccess, VariableDeclaration rvar, AffineFunction RAccess){
		String exp = null;
		
		//create the left hand side of the expression
		String lexp = createMemoryAccessExpression(lvar, LAccess);
		
		//create the right hand side of the expression
		String rexp = createMemoryAccessExpression(rvar, RAccess);
		
		exp = lexp + "=" + rexp;
		
		return exp;
	}
	
	/**
	 * Create binary expression: lexp (op) rexp
	 * @param lexp
	 * @param op
	 * @param rexp
	 * @return
	 */
	public static String createBinaryExpressionForScan(String lexp, OP op, String rexp){
		String exp = null;
		
		//enumerate the binary operator to create the expression
		switch(op){
		case ADD:
			exp = lexp +"+"+ rexp;
			break;
		case SUB:
			exp = lexp + "-" + rexp;
			break;
		case MUL:
			exp = lexp + "*" + rexp;
			break;
		case DIV:
			exp = lexp + "/" + rexp;
			break;
		case MAX:
			exp = "max(" + lexp + "," + rexp + ")";
			break;
		case MIN:
			exp = "min(" + lexp + "," + rexp + ")";
			break;
		default:
			System.out.println("There is no such operator");
			break;
		}
		
		return exp;
	}
	
	/**
	 * Create vector product expression: vector A (otimes, oplus) vector B
	 * example: (x1, x2)*{+,x}(y1, y2) = x1 x y1 + x2 x y2
	 * @param A
	 * @param Aaccess
	 * @param B
	 * @param Baccess
	 * @param oplus
	 * @param otimes
	 * @return
	 */
	public static String createVectorProductExpression(List<VariableDeclaration> A, AffineFunction Aaccess, List<VariableDeclaration> B,AffineFunction Baccess, OP oplus, OP otimes){
		String exp = null;
		
		//create otimes expressions
		List<String> exprs = new LinkedList<String>();
		for(int i = 0; i < A.size(); i++){
			VariableDeclaration a = A.get(i);
			VariableDeclaration b = B.get(i);
			
			AffineFunction aaccess;
			AffineFunction baccess;
			if(Aaccess == null){
				aaccess = null;
			}else{
				aaccess = Aaccess.copy();
			}
			
			if(Baccess == null){
				baccess = null;
			}else{
				baccess = Baccess.copy();
			}
			
			String lexp = createMemoryAccessExpression(a, aaccess);
			String rexp = createMemoryAccessExpression(b, baccess);
			
			String texp = createBinaryExpressionForScan(lexp, otimes, rexp);
			exprs.add(texp);
		}
		
		//create the final expression
		if(exprs.size() == 1){
			return exprs.get(0);
		}else{
			exp = createBinaryExpressionForScan(exprs.get(0), oplus, exprs.get(1));
			for(int i = 2; i < exprs.size(); i++){
				exp = createBinaryExpressionForScan(exp, oplus, exprs.get(i));
			}
		}
		
		return exp;
	}

	
}
