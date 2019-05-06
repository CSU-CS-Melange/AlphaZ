package org.polymodel.polyhedralIR.polyIRCG.generator.C.scan;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.factory.TargetMappingUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.C.CLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.OriginDomainVolume;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunction;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunctionDerivative;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenUtility;
import org.polymodel.polyhedralIR.polyIRCG.generator.PolyIRCodeGen.CODEGEN;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGeneratorTemplateForC;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.ScheduledC;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.scan.ScanCodeGenInfo.scanOutput;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations.Constraint;


public class ScanC extends CodeGeneratorTemplateForC{
	private boolean DEBUG = false;
	//WriteC is per system only
	protected final AffineSystem system;
	private static final PolyIRCGUserFactory _fact = PolyIRCGUserFactory.INSTANCE;
	private static final PolyhedralIRUserFactory _userFact = PolyhedralIRUserFactory.eINSTANCE;
	private ScanCodeGenInfo gen_info;
	protected final CodeGenOptions options;
	
	
	/**
	 * Static method for public access to WriteC code generator.
	 * 
	 * @param system
	 * @param options
	 * @param outDir
	 */
	public static void generate(AffineSystem system, CodeGenOptions options, String outDir, ScanCodeGenInfo gen_info) {
		ScanC scanC = new ScanC(system, options, gen_info);
		scanC.generate(options, outDir);
		scanC.subSystemGeneration(outDir);
	}
	
	
	protected ScanC(AffineSystem system, CodeGenOptions options, ScanCodeGenInfo gen_info) {
		super(system.getContainerProgram());
		this.system = program.getSystem(system.getName());
		this.gen_info = gen_info;
		this.options = options;
		// TODO Auto-generated constructor stub
	}


	@Override
	protected CODEGEN getCodeGen() {
		return CODEGEN.SCAN_C;
	}

	@Override
	protected List<CodeUnit> getCodeUnits() {
		List<CodeUnit> res = new Vector<CodeUnit>(1);
		CodeUnit unit = _fact.createCodeUnit(system);

		OriginDomainVolume odv = ScanCUtility.addOriginDomainVolumeFunction(unit);
		
		VolumeFunction volFunc = ScanCUtility.addVolumeFunction(unit);
		
		VolumeFunctionDerivative volFuncDerivative = ScanCUtility.addVolumeFunctionDerivative(unit);
		
		BoundComputation boundFunc = ScanCUtility.addBoundComputation(unit, volFunc, volFuncDerivative);
	
		Function reduction_funct = ScanCUtility.createNewFunctionSigature( gen_info.getReductionBodySystem(), options);
		
		Function scan_funct = ScanCUtility.createNewFunctionSigature( gen_info.getScanBodySystem(), options);
		
		GenerateScanComputation(unit, odv, volFunc, boundFunc, reduction_funct, scan_funct);
		
		res.add(unit);
		
		return res;
	}
	
	protected void setTargetMapping(){
		//set target mapping for reduction system
		TargetMapping tm = TargetMappingUserFactory.createIdentityTargetMapping(gen_info.getReductionBodySystem());
		//set mapping for the output
		ParameterDomain paramDom = gen_info.getReductionBodySystem().getParameters();
		Domain scalarDom = PolyhedralIRUtility.parseDomain(paramDom, "{|}");
		List<VariableDeclaration> output_list = gen_info.getReductionBodySystem().getOutputs();
		Domain outputDom = gen_info.getReductionBodySystem().getLocals().get(0).getDomain();
		//create and affine function moves along the inner most dimension
		
		int dim = outputDom.getNIndices();
		System.out.println("number of dimensions:" + dim);
		int[] constants = new int[dim];
		for(int i = 0; i < dim-1; i++){
			constants[i] = 0;
		}
		constants[dim-1] = 1;
		AffineFunction af = PolyhedralIRUtility.createUniformFunction(outputDom, constants);
		Domain outDom = outputDom.image(af);
		Domain toDom = _userFact.createDomain((org.polymodel.Domain)(outDom.getPMdomain()).lexMax());
		
		//find the dependence function
		AffineFunction dep = null;
		Map<Domain, AffineFunction> quast = DomainOperations.findDependencies(paramDom, scalarDom, toDom, new LinkedList<Constraint>(), null);
		Set s = quast.entrySet();
		Iterator it= s.iterator();
		while(it.hasNext()){
			Map.Entry m =(Map.Entry)it.next();
		    Domain key=(Domain)m.getKey();
		    AffineFunction value=(AffineFunction)m.getValue();
		    if(DEBUG){
		    	System.out.println("key: " + key + " dependence: " + value);
		    }
		    if(!key.intersection(scalarDom).isEmpty() && value != null){
		    	dep = value;
		    	break;
		    }
		}
		
		if(DEBUG){
			System.out.println("The mapping affine function:" + dep);
		}
		
		//set up the mapping for the output value
		for(VariableDeclaration var : output_list){
			tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put(var.getName(), 
					TargetMappingUserFactory.createStandardEquationSpaceTimeMap(var, dep.copy()));

		}
		
		//set up the memory mapping for the local matrix value
		List<VariableDeclaration> local_list = gen_info.getReductionBodySystem().getLocals();

		AffineFunction identity = PolyhedralIRUtility.createIdentityFunction(outputDom);
		
		for(VariableDeclaration var: local_list){
		//	System.out.println("set the memory map for " + var.getName());
			EList<IntExpression> modFactors = new BasicEList<IntExpression>();
			for(int i = 0; i < dim; i++){
				modFactors.add(IntExpressionBuilder.constant(2));
			}
//			//FIXME this doesn't make sense
//			tm.setMemorySpace(tm.getMemorySpace(var).getName(), var);
		}
		
		gen_info.getReductionBodySystem().setTargetMapping(tm);
		
		//set up identity mapping for scan system
		tm =  TargetMappingUserFactory.createIdentityTargetMapping(gen_info.getScanBodySystem());
		gen_info.getScanBodySystem().setTargetMapping(tm);
	}
	
	protected void subSystemGeneration(String outDir){
		//using scheduleC to generate code for the other 2 system
		//set up the target mapping for each system
		setTargetMapping();
		ScheduledC.generate(gen_info.getReductionBodySystem(), options, outDir);
		ScheduledC.generate(gen_info.getScanBodySystem(), options, outDir);
		//for reduction system 
		/*AffineSystem cur_sys = gen_info.getReductionBodySystem();
		TargetMapping tm =  TargetMappingFactory.createIdentityTargetMapping(cur_sys);
		tm.setSpaceTimeMap(cur_sys.getVariableDeclaration("MResult00"), PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(cur_sys.getParameters(), "(->N, M+1)"));
		tm.setSpaceTimeMap(cur_sys.getVariableDeclaration("MResult01"), PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(cur_sys.getParameters(), "(->N, M+1)"));
		tm.setSpaceTimeMap(cur_sys.getVariableDeclaration("MResult10"), PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(cur_sys.getParameters(), "(->N, M+1)"));
		tm.setSpaceTimeMap(cur_sys.getVariableDeclaration("MResult11"), PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(cur_sys.getParameters(), "(->N, M+1)"));
		cur_sys.setTargetMapping(tm);
		ScheduledC.generate(cur_sys, options, outDir);*/
		
		//cur_sys = gen_info.getScanBodySystem();
		//tm =  TargetMappingFactory.createIdentityTargetMapping(cur_sys);
		//cur_sys.setTargetMapping(tm);
		//ScheduledC.generate(cur_sys, options, outDir);
	}
	
/*	protected Function createNewFunctionSigature( AffineSystem affine_sys){
		CodeUnit unit = _fact.createCodeUnit(affine_sys);
		
		//reflect TargetMapping
//		for (MemorySpace ms : affine_sys.getTargetMapping().getMemorySpaces()) {
//			unit.getVariables().add(_fact.createCVariable(ms, options.flattenArrays, false));
//		}
		for(MemorySpace ms : affine_sys.getTargetMapping().getMemorySpaces()){
			unit.getVariables().add(_fact.createCVariable(ms, options.flattenArrays, false));
		}
		
		//construct the function
		Function function = _fact.createFunction(affine_sys.getName(), "void");
		//Register all variables
		for (VariableDeclaration var : affine_sys.getInputs()) {
			function.getInputs().add(unit.findVariable(affine_sys.getTargetMapping().getMemorySpace(var).getName()));
		}
		for (VariableDeclaration var : affine_sys.getOutputs()) {
			function.getOutputs().add(unit.findVariable(affine_sys.getTargetMapping().getMemorySpace(var).getName()));
		}
		
		unit.getFunctions().add(function);
		
		//System.out.println(function.getSignature());
		
		return function;
	}*/
	
	protected Function GenerateScanComputation(CodeUnit unit, OriginDomainVolume oriFunc, VolumeFunction volFunc, BoundComputation boundFunc, Function reduct, Function scan){
		//TargetMappingSetting();
		//reflect TargetMapping
		
		//for (MemorySpace ms : system.getTargetMapping().getMemorySpaces()) {
		for(MemorySpace ms : system.getTargetMapping().getMemorySpaces()){
			unit.getVariables().add(_fact.createCVariable(ms, options.flattenArrays, false));
		}
		
		//construct the function
		Function function = _fact.createFunction(system.getName(), "void");
		//This is the entry point for executing this system
		//function.setEntryPoint(true);
		
		//Register all variables
		for (VariableDeclaration var : system.getInputs()) {
			function.getInputs().add(unit.findVariable(system.getTargetMapping().getMemorySpace(var.getName()).getName()));
		}
		for (VariableDeclaration var : system.getOutputs()) {
			function.getOutputs().add(unit.findVariable(system.getTargetMapping().getMemorySpace(var.getName()).getName()));
		}
		//TODO
		//make sure no duplicates due to multiple equations mapped to the same space
		/*for (VariableDeclaration var : system.getLocals()) {
			function.getLocals().add(unit.findVariable(system.getTargetMapping().getMemorySpace(var).getName()));
		}*/
		
		//Add parameter checking
		function.getBodies().add(_fact.createParameterCheck(system.getParameters()));
		
		ScanBody scan_body = _fact.createScanBody(gen_info.getDomain(), volFunc, boundFunc, oriFunc, reduct, scan);
		
		String nthreads = "nthreads";
		String threadnum = "thread_num";
		String begin = "begin";
		String end = "end";
		
		//set some variable name
		scan_body.setNthreadVariableName(nthreads);
		scan_body.setThreadNumVariableName(threadnum);
		scan_body.setBeginVariableName(begin);
		scan_body.setEndVariableName(end);
		
		//construct the reduction sum variable declaration
		Type type = gen_info.getReductionBodySystem().getOutputs().get(0).getType();	//get the variable type
		//create the parameter domain the thread number
		
		//create parameter domain for the scan body
		List<String> paraName = new LinkedList<String>();
		paraName.add(nthreads);
		paraName.add(threadnum);
		List<String> paraCons = new LinkedList<String>();
		paraCons.add("nthreads >=1 ");
		paraCons.add("thread_num >= 0");
		ParameterDomain paraThreadsDomain = PolyhedralIRUtility.parseParameterDomain(paraName, paraCons);
		//create Domain for scan reduciton variables
		Domain varDomain = PolyhedralIRUtility.parseDomain(paraThreadsDomain, "{i|0<=i<nthreads}");
		
		//ParameterDomain param = gen_info.getReductionBodySystem().getParameters();
		//Domain scalarDom = _userFact.createDomain(param, "{|}");
		List<VariableDeclaration> redSumVar = new LinkedList<VariableDeclaration>();
		
		int m = gen_info.getSize();
		for(int i = 0; i < m; i++){
			for(int j = 0; j < m; j++){
				String var_name = "redSum"+i+j;
				VariableDeclaration var = _userFact.createVariableDeclaration(var_name, type, varDomain.copy());
				redSumVar.add(var);
			}
		}
		
		List<CodeGenVariable> variables = ScanCUtility.createIdentityCodeGenVariables(redSumVar, options);
	
			
		scan_body.getLocalScanReductionVariables().addAll(variables);
		
		//get the local reduction variables
		List<VariableDeclaration> reductionVar = gen_info.getReductionBodySystem().getOutputs();
		
		List<CodeGenVariable> redVars = ScanCUtility.createIdentityCodeGenVariables(reductionVar, options);
		
		scan_body.getLocalReductionVariables().addAll(redVars);
		
		ScanReductionBody scan_red_body = _fact.createScanReductionBody();
		
		int statementIndex = 0;
		
		CLoop initValueCopyBack = _fact.createCLoop(paraThreadsDomain, 0);
		Domain copyBackDom = PolyhedralIRUtility.parseDomain(paraThreadsDomain, "{|}");
		//create the initial value updating assignemnt 
		List<scanOutput> scanInitOutVec = gen_info.getInitScanOutVector();
		List<VariableDeclaration> scanInitVec = gen_info.getInputVector();
		for(int i = 0; i < scanInitVec.size(); i++){
			scanOutput out = scanInitOutVec.get(i);
			VariableDeclaration lvar = out.getVar();
			AffineFunction left = out.getFunc();
			
			VariableDeclaration rvar = scanInitVec.get(i);
			AffineFunction right = PolyhedralIRUtility.createIdentityFunction(rvar.getDomain());
			
			String exp = ScanCUtility.createAssignmentExpression(lvar, left, rvar, right);
			//String exp = createAssignmentExpression(lvar, left, rvar, right);
			
			initValueCopyBack.getStatements().add(_fact.createStatement(
					CodeGenUtility.createStatementName(unit, statementIndex), copyBackDom.copy(), exp));
			statementIndex++;
		}
		
		scan_red_body.setInitValueCopy(initValueCopyBack);
		
		CLoop preProLoop = _fact.createCLoop(paraThreadsDomain, 0);
		//create assignement statement to get the reduction value
		AffineFunction LAccess = PolyhedralIRUtility.parseAffineFunction(paraThreadsDomain, "(i->thread_num)");
		if(DEBUG){
			System.out.println("The LAccess: " + LAccess);
		}
		
		Domain preProDomain = PolyhedralIRUtility.parseDomain(paraThreadsDomain, "{|}");
		
		for(int i = 0; i < redSumVar.size(); i++){
			VariableDeclaration lvar = redSumVar.get(i);
			VariableDeclaration rvar = reductionVar.get(i);
			//AffineFunction RAccess = _userFact.createIdentityFunction(reductionVar.get(i).getDomain());
			
			String exp = ScanCUtility.createAssignmentExpression(lvar, LAccess.copy(), rvar, null);
			//String exp = createAssignmentExpression(lvar, LAccess.copy(), rvar, null);
			preProLoop.getStatements().add(_fact.createStatement(
					CodeGenUtility.createStatementName(unit, statementIndex), preProDomain.copy(), exp));
			statementIndex++;
		}
		
		scan_red_body.setPreProcessLoop(preProLoop);
		
		//create matrix temporary variables
		Domain tempVarDomain = PolyhedralIRUtility.parseDomain(paraThreadsDomain, "{|}");
		LinkedList<VariableDeclaration> matrixTempVar = new LinkedList<VariableDeclaration>();
		for(int i = 0; i < m; i++){
			for(int j = 0; j < m; j++){
				String var_name = "matrixTemp" + i + j;
				VariableDeclaration var = _userFact.createVariableDeclaration(var_name, type, tempVarDomain.copy());
				matrixTempVar.add(var);
			}
		}
		
		List<CodeGenVariable> matTempVars = ScanCUtility.createIdentityCodeGenVariables(matrixTempVar, options);
		
		scan_red_body.getMatrixTempVariables().addAll(matTempVars);
		
		CLoop scanLoop = _fact.createCLoop(paraThreadsDomain, 0);
		//create matrix multiplication form
		Domain scanDomain = PolyhedralIRUtility.parseDomain(paraThreadsDomain, "{i|2 <= i < nthreads}");
		
		AffineFunction Aaccess = PolyhedralIRUtility.parseAffineFunction(paraThreadsDomain, "(i->i)");
		AffineFunction Baccess = PolyhedralIRUtility.parseAffineFunction(paraThreadsDomain, "(i->i-1)");
		//AffineFunction access = _userFact.createIdentityFunction(tempVarDomain.copy());
		OP oplus = gen_info.getOPlus();
		OP otimes = gen_info.getOTimes();
		List<VariableDeclaration> Avector = new LinkedList<VariableDeclaration>();
		List<VariableDeclaration> Bvector = new LinkedList<VariableDeclaration>();
		for(int i = 0; i < m; i++){
			for(int j = 0; j < m; j++){
				Avector.clear();
				Bvector.clear();
				VariableDeclaration lvar = matrixTempVar.get(i*m+j);
				for(int k = 0; k < m; k++){
					Avector.add(redSumVar.get(i*m+k));
					Bvector.add(redSumVar.get(k*m+j));
				}
				
				String rexp = ScanCUtility.createVectorProductExpression(Avector, Aaccess, Bvector, Baccess, oplus, otimes);
				String assign = ScanCUtility.createAssignmentExpression(lvar, null, rexp);
				//String rexp = createVectorProductExpression(Avector, Aaccess, Bvector, Baccess, oplus, otimes);
				//String assign = createAssignmentExpression(lvar, null, rexp);
				scanLoop.getStatements().add(_fact.createStatement(
						CodeGenUtility.createStatementName(unit, statementIndex), scanDomain.copy(), assign));
				statementIndex++;
			}
		}
		
		//create assignment statement, matrix copy back
		AffineFunction Laccess = PolyhedralIRUtility.parseAffineFunction(paraThreadsDomain, "(i->i)");
		//AffineFunction Raccess = _userFact.createAffineFunction(paraThreadsDomain, "(->)");
		for(int i = 0; i < m; i++){
			for(int j = 0; j < m; j++){
				VariableDeclaration lvar = redSumVar.get(i*m+j);
				VariableDeclaration rvar = matrixTempVar.get(i*m + j);
				
				String exp = ScanCUtility.createAssignmentExpression(lvar, Laccess, rvar, null);
//				String exp = createAssignmentExpression(lvar, Laccess, rvar, null);
				scanLoop.getStatements().add(_fact.createStatement(
						CodeGenUtility.createStatementName(unit, statementIndex), scanDomain.copy(), exp));
				statementIndex++;
			}
		}
		
		scan_red_body.setScanLoop(scanLoop);
		
		//create the initial value updating assignemnt 
		List<scanOutput> out_vec = gen_info.getScanOutVector();
		List<VariableDeclaration> init_vec = gen_info.getInputVector();
		Domain initUpdateDom = PolyhedralIRUtility.parseDomain(paraThreadsDomain, "{|}");
		
		//create the assignment loop
		CLoop initUpdateLoop = _fact.createCLoop(paraThreadsDomain, 0);
		
		for(int i = 0; i < init_vec.size(); i++){
			scanOutput out = out_vec.get(i);
			VariableDeclaration rvar = out.getVar();
			AffineFunction right = out.getFunc();
			
			VariableDeclaration lvar = init_vec.get(i);
			AffineFunction left = PolyhedralIRUtility.createIdentityFunction(lvar.getDomain());
			
			String exp = ScanCUtility.createAssignmentExpression(lvar, left, rvar, right);
			//String exp = createAssignmentExpression(lvar, left, rvar, right);
			
			initUpdateLoop.getStatements().add(_fact.createStatement(
					CodeGenUtility.createStatementName(unit, statementIndex), initUpdateDom.copy(), exp));
			statementIndex++;
		}
		scan_red_body.setInitValueUpdate(initUpdateLoop);
		
		//create post processing
		//create temporary initial variables
		
		List<VariableDeclaration> outputVector = gen_info.getOutputVector();
		
		List<CodeGenVariable> tempInitVars = ScanCUtility.createIdentityCodeGenVariables(outputVector, options);
		
		scan_red_body.getInitTempVariables().addAll(tempInitVars);
		
		List<VariableDeclaration> inputVector = gen_info.getInputVector();
		Domain assignDomain = PolyhedralIRUtility.parseDomain(paraThreadsDomain, "{|}");
		
		//create the assignment loop
		CLoop assignLoop = _fact.createCLoop(paraThreadsDomain, 0);
		
		for(int i = 0; i < m-1; i++){
			VariableDeclaration lvar = outputVector.get(i);
			//AffineFunction left = _userFact.createIdentityFunction(lvar.getDomain());
			VariableDeclaration rvar = inputVector.get(i);
			AffineFunction right = PolyhedralIRUtility.createIdentityFunction(rvar.getDomain());
			
			String exp = ScanCUtility.createAssignmentExpression(lvar, null, rvar, right);
//			String exp = createAssignmentExpression(lvar, null, rvar, right);
			
			assignLoop.getStatements().add(_fact.createStatement(
					CodeGenUtility.createStatementName(unit, statementIndex), assignDomain.copy(), exp));
			statementIndex++;
		}
		
		scan_red_body.setAssignmentLoop(assignLoop);
		CLoop postLoop = _fact.createCLoop(paraThreadsDomain, 0);
		
		//create the matrix vector computation
		//get the input vector list
		List<VariableDeclaration> a_vector = new LinkedList<VariableDeclaration>();
		AffineFunction a_access = PolyhedralIRUtility.parseAffineFunction(paraThreadsDomain, "(i->thread_num)");
		AffineFunction b_access = PolyhedralIRUtility.parseAffineFunction(paraThreadsDomain, "(->)");
		//AffineFunction l_access = _userFact.createAffineFunction(paraThreadsDomain, "(->)");
		Domain postDomain = PolyhedralIRUtility.parseDomain(paraThreadsDomain, "{|}");
		for(int i = 0; i < m-1; i++){
			a_vector.clear();
			VariableDeclaration lvar = outputVector.get(i);
			for(int j = 0; j < m-1; j++){
				a_vector.add(redSumVar.get(i*m+j));
			}
			
			String rexp = ScanCUtility.createVectorProductExpression(a_vector, a_access, inputVector, b_access, oplus, otimes);
			//String rexp = createVectorProductExpression(a_vector, a_access, inputVector, b_access, oplus, otimes);
			
			//add the constant part
			VariableDeclaration const_var = redSumVar.get(i*m + m-1);
			//String const_exp = createMemoryAccessExpression(const_var, a_access.copy());
			String const_exp = ScanCUtility.createMemoryAccessExpression(const_var, a_access.copy());
			
			rexp = ScanCUtility.createBinaryExpressionForScan(rexp, oplus, const_exp);
			//rexp = createBinaryExpressionForScan(rexp, oplus, const_exp);
			
			String exp = ScanCUtility.createAssignmentExpression(lvar, null, rexp);
			//String exp = createAssignmentExpression(lvar, null, rexp);
			
			postLoop.getStatements().add(_fact.createStatement(
					CodeGenUtility.createStatementName(unit, statementIndex), postDomain.copy(), exp));
			statementIndex++;
			
		}
		
		/*List<VariableDeclaration> inputInitList = gen_info.getUpdatingVector();
		//copy the value back
		for(int i = 1; i < m; i++){
			VariableDeclaration lvar = inputInitList.get(i-1);
			AffineFunction left = _userFact.createIdentityFunction(lvar.getDomain());
			VariableDeclaration rvar = initVarList.get(i-1);
			AffineFunction right = _userFact.createIdentityFunction(rvar.getDomain());
			
			String exp = createAssignmentExpression(lvar, left, rvar, right);
			
			postLoop.getStatements().add(_fact.createStatement(
					CodeGenUtility.createStatementName(unit, statementIndex), postDomain.copy(), exp));
			statementIndex++;
		}*/
		scan_red_body.setPostProcessLoop(postLoop);
		
		scan_body.setScanReductionBody(scan_red_body);
		
		
		function.getBodies().add(scan_body);
		
		unit.getFunctions().add(function);	
		
		return function;
	}
}
