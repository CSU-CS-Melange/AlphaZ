package org.polymodel.polyhedralIR.polyIRCG.generator.C;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.IntExpression;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.SIGNED;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.WhileInfo;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.TargetMappingUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.TiledCodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.PolyIRCodeGen.CODEGEN;
import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.util.WhileSystemUtility;

/**
 * WriteC generated demand driven C code for an AffineSystem
 * Ignores SpaceTimeMap for all variables, and MemoryMap for inputs and locals.
 * 
 * @author yuki
 *
 */
public class WriteC extends CodeGeneratorTemplateForC {
	
	private static final PolyhedralIRUserFactory _polyFact = PolyhedralIRUserFactory.eINSTANCE;
	private static final PolyIRCGUserFactory _fact = PolyIRCGUserFactory.INSTANCE;
	
	//WriteC is per system only
	protected final AffineSystem system;
	
	protected final CodeGenOptions options;
	
	/**
	 * Static method for public access to WriteC code generator.
	 * 
	 * @param system
	 * @param options
	 * @param outDir
	 */
	public static void generate(AffineSystem system, CodeGenOptions options, String outDir) {
		WriteC writeC = new WriteC(system, options);
		writeC.generate(options, outDir);
	}
	

	protected WriteC(AffineSystem system, CodeGenOptions options) {
		super(system.getContainerProgram());
		//Need to get it from program, since program is copied in the super class constructor
		this.system = program.getSystem(system.getName());
		this.options = options;
		
	}
	
	@Override
	protected void initialize() {
		if (system.getWhileInfo() != null) {
		/*
		 * Time dimension(s) is(are) already added to output and 
		 * local variables in the parser (AlphabetsToPolyIR) to 
		 * avoid parser errors due to the additional time dimension(s)
		 * in the output variables in equations and terminating 
		 * condition.   
		 * 
		 * We now going to add 2 new local variables for all the 
		 * output variables.
		 * 
		 * if there is following equation, where out is an output 
		 * variable, 
		 * 
		 * out = f(d@out, ...)
		 * 
		 * then we add new local variable "out__Wlocal"
		 * and rename the equation as follows
		 * 
		 * out__Wlocal = f(d@out_Wlocal, ...)
		 * 
		 * Then we add another local variable "out__Wlocal_Main" and
		 * add the following additional equation to the system
		 * 
		 * out__Wlocal_Main = out__Wlocal
		 * 
		 * Then remove the time dimension from the original output variables
		 * 
		 * Then we find the variables with the constant referrals on the time
		 * indices and split those variables.
		 */ 
			preProcessingForWhileSystems();
		}
		
		super.initialize();

		if(system.getTargetMapping().isTiled() || ((options instanceof TiledCodeGenOptions) && ((TiledCodeGenOptions)options).multiPassSequential) ||
				((options instanceof TiledCodeGenOptions) && ((TiledCodeGenOptions)options).multiPassWavefront)){
			addTileSizesAsParameters(system, (TiledCodeGenOptions)options);
		}

		final TargetMapping tm = system.getTargetMapping();
		final SpaceTimeLevel stlevel = tm.getSpaceTimeLevel(0);
		
		//WriteC only works for the program without useEquation
		if(system.getUseEquations().size() > 0){
			throw new RuntimeException ("WriteC can not handle programs with useEquations!");
		}
		//Set SpaceTimeMap and MemoryMap to identity, since it should be ignored in the WriteC generation
		for (VariableDeclaration var : system.getInputs()) {
			stlevel.getSpaceTimeMaps().put(var.getName(), TargetMappingUserFactory.createIdentityStandardEquationSpaceTimeMap(var));
			
			MemorySpace ms = tm.getMemorySpace(var.getName());
			tm.getMemorySpaces().add(ms);
			tm.getMemoryMaps().put(var, TargetMappingUserFactory.createIdentityMemoryMap(var, ms));
		}
		for (VariableDeclaration var : system.getOutputs()) {
			stlevel.getSpaceTimeMaps().put(var.getName(), TargetMappingUserFactory.createIdentityStandardEquationSpaceTimeMap(var));
		}
		for (VariableDeclaration var : system.getLocals()) {
			stlevel.getSpaceTimeMaps().put(var.getName(), TargetMappingUserFactory.createIdentityStandardEquationSpaceTimeMap(var));
			
			MemorySpace ms = tm.getMemorySpace(var.getName());
			tm.getMemorySpaces().add(ms);
			tm.getMemoryMaps().put(var, TargetMappingUserFactory.createIdentityMemoryMap(var, ms));
		}
		
		//add flag variables
		final Type charType = program.getType(SIGNED.SIGNED, DATATYPE.CHAR, 1);
		
		List<VariableDeclaration> vars = new ArrayList<VariableDeclaration>(system.getOutputs().size()+system.getLocals().size());
		if (system.getWhileInfo() == null) {
			vars.addAll(system.getOutputs());
		}
		vars.addAll(system.getLocals());
		
		for (VariableDeclaration var : vars) {
			final String newName = CodeGenConstantsForC.FLAG_PREFIX+tm.getMemoryMaps().get(var).getSpace().getName(); 
			//create char version of the variable
			VariableDeclaration newVar = _polyFact.createVariableDeclaration(newName, charType, var.getDomain().copy());
			system.getLocals().add(newVar);
			//set identity space time
			stlevel.getSpaceTimeMaps().put(newVar.getName(), TargetMappingUserFactory.createIdentityStandardEquationSpaceTimeMap(newVar));
			
			//use same memory mapping as original variable
			MemoryMap origMM = tm.getMemoryMaps().get(var);
			EList<IntExpression> mods = new BasicEList<IntExpression>();
			for(IntExpression expr : origMM.getModFactors()){
				mods.add(expr.copy());
			}
			MemorySpace space = tm.getMemorySpace(newName);
			MemoryMap newMM = TargetMappingUserFactory.createMemoryMap(newVar, origMM.getMapping().copy(), mods, space);
			tm.getMemoryMaps().put(newVar, newMM);
			tm.getMemorySpaces().add(space);
		}
	}


	private void preProcessingForWhileSystems() {
		/*
		 * Time dimension(s) is(are) already added to output and 
		 * local variables in the parser (AlphabetsToPolyIR) to 
		 * avoid parser errors due to the addition time dimension
		 * in the output variables in equations and terminating 
		 * condition.   
		 * 
		 * We now going to add new local variables for all the 
		 * output variables.
		 * 
		 * Then remove the time dimension from the original output variables
		 */ 
		
		WhileInfo wi = system.getWhileInfo();
		Domain timeDomain = wi.getTimeDomain();
		
		Type boolType = PolyhedralIRUserFactory.eINSTANCE.createType(DATATYPE.BOOL);
		VariableDeclaration isCond = PolyhedralIRUserFactory.eINSTANCE.
				createVariableDeclaration("isCond", boolType, EcoreUtil.copy(timeDomain));
		system.getLocals().add(isCond);
		
		StandardEquation condEq = PolyhedralIRUserFactory.eINSTANCE.createStandardEquation(isCond, wi.getCondition());
		system.getEquations().add(condEq);
		
		for (VariableDeclaration var : system.getOutputs()) {
			/* If the variable var is an output, then we rename that 
			 * variable to var.name__Wlocal (This will rename all the 
			 * occurrences of output variable.). Then we move this 
			 * variable from outputs to local variables. We make a copy 
			 * of this variable and set the original name. Then we add 
			 * another local variable "var.name__Wlocal__Main". 
			 * Finally we create an equation with 
			 * var.name__Wlocal__Main = var.name__Wlocal and add it to 
			 * the system.
			 */
			String origName = var.getName();
			String localName = origName+WhileSystemUtility.WHILE_LOCAL_VAR_POSTFIX;
			//Rename output variable to outname__Wlocal
			var.getVarID().setName(localName);
			//Remove the output var from output variables
			system.getOutputs().remove(var);
			//Add output var to local variables
			system.getLocals().add(var);
			//Create a copy of output variable
			VariableDeclaration outVar = EcoreUtil.copy(var);
			//reset the name to the original output var's name
			outVar.getVarID().setName(origName);
			//Add the copy of the variable to outputs
			system.getOutputs().add(outVar);
			
			//create a new expression with the local variable var. which is previously output variable
			VariableExpression varExp = org.polymodel.polyhedralIR.PolyhedralIRUserFactory.var(var);
			//Create new local variable to hold main local output
			VariableDeclaration localVarMain = EcoreUtil.copy(var);
			localVarMain.getVarID().setName(outVar.getName()+WhileSystemUtility.WHILE_LOCAL_MAIN_VAR_POSTFIX);
			system.getLocals().add(localVarMain);
			
			//create an equation: new_local_main_output_var = new_local_output_var 
			StandardEquation seq = PolyhedralIRUserFactory.eINSTANCE.createStandardEquation(localVarMain, varExp);
			//Add the equation to the system
			system.getEquations().add(seq);
		}
		
		for (VariableDeclaration var : system.getOutputs()) {
			/*
			 * Remove the time dimension(s) from the output variables 
			 */
			WhileSystemUtility.removeTimeDimensions(var, timeDomain);
		}
		
		/*
		
		for (VariableDeclaration var : system.getLocals()) {
			
			 * For all the local variables, we add the time dimensions as extra
			 * dimensions to the domain
			 
			Domain varD = var.getDomain();
			List<Variable> indices = varD.getIndices();
			List<Variable> params = varD.getParams();
			List<IntConstraintSystem> constraints = varD.getPMdomain().getPolyhedra();
			indices.addAll(0, timeDomain.getIndices());
			constraints.addAll(timeDomain.getPMdomain().getPolyhedra());
			
			Domain domainWithTime = PolyhedralIRUserFactory.eINSTANCE.createDomain(params, indices, constraints);
			var.setDomain(domainWithTime);
		}
		*/
		
		WhileSystemUtility.splitVariablesForWhileSystems(system);
	}


	
	@Override
	protected CODEGEN getCodeGen() {
		return CODEGEN.WRITE_C;
	}

	
	@Override
	protected List<CodeUnit> getCodeUnits() {
		clearUnusedMemorySpace(system.getTargetMapping());
		
		List<CodeUnit> res = new Vector<CodeUnit>(1);
		CodeUnit unit = _fact.createCodeUnit(system);
		//reflect TargetMapping
		for(MemorySpace ms : system.getTargetMapping().getMemorySpaces()){
			unit.getVariables().add(_fact.createCVariable(ms,  options.flattenArrays, true));
		}
		
		StatementVisitorForWriteC.construct(system, unit);
		
		res.add(unit);
		
		return res;
	}


	/* (non-Javadoc)
	 * @see org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGeneratorTemplateForC#generationPreProcessing()
	 */
	@Override
	protected void generationPreProcessing() {
		super.generationPreProcessing();
		
		WhileSystemUtility.updateTargetMappingForWhileSystems(system);
	}
	
	
	
	
}
