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
import org.polymodel.isl.ISLSet;
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
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations.Constraint;

public class ReductionC extends CodeGeneratorTemplateForC{
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
		ReductionC reductionC = new ReductionC(system, options, gen_info);
		reductionC.generate(options, outDir);
		reductionC.subSystemGeneration(outDir);
	}
	
	
	protected ReductionC(AffineSystem system, CodeGenOptions options, ScanCodeGenInfo gen_info) {
		super(system.getContainerProgram());
		this.system = program.getSystem(system.getName());
		this.gen_info = gen_info;
		this.options = options;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected CODEGEN getCodeGen() {
		return CODEGEN.REDUCTION_C;
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
		
		GenerateReductionComputation(unit, odv, volFunc, boundFunc, reduction_funct);
//		GenerateScanComputation(unit, oriFunc, volFunc, boundFunc, reduction_funct, scan_funct);
		
		res.add(unit);
		
		return res;
	}
	
	protected void setTargetMapping(){
		//set target mapping for reduction system
		TargetMapping tm = TargetMappingUserFactory.createIdentityTargetMapping(gen_info.getReductionBodySystem());
		SpaceTimeLevel stlevel = tm.getSpaceTimeLevel(0);
		//set mapping for the output
		ParameterDomain paramDom = gen_info.getReductionBodySystem().getParameters();
		Domain scalarDom = PolyhedralIRUtility.parseDomain(paramDom, "{|}");
		List<VariableDeclaration> output_list = gen_info.getReductionBodySystem().getOutputs();
		Domain outputDom = gen_info.getReductionBodySystem().getLocals().get(0).getDomain();
		//create and affine function moves along the inner most dimension
		
		int dim = outputDom.getNIndices();
		if(DEBUG){
			System.out.println("number of dimensions:" + dim);
		}
		int[] constants = new int[dim];
		for(int i = 0; i < dim-1; i++){
			constants[i] = 0;
		}
		constants[dim-1] = 1;
		AffineFunction af = PolyhedralIRUtility.createUniformFunction(outputDom, constants);
		Domain outDom = outputDom.image(af);
		Domain toDom = _userFact.createDomain(((ISLSet)outDom.getPMdomain()).lexMax());
		
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
		
//		if(DEBUG){
			System.out.println("The mapping affine function:" + dep);
//		}
		
		//set up the mapping for the output value
		for(VariableDeclaration var : output_list){
			stlevel.getSpaceTimeMaps().put(var.getName(), TargetMappingUserFactory.createStandardEquationSpaceTimeMap(var, dep.copy()));
			//stlevel.getSpaceTimeMaps().put(var, TargetMappingUserFactory.createSpaceTimeMap(var, dep.copy()));
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
			tm.getMemoryMaps().put(var, 
					TargetMappingUserFactory.createMemoryMap(var, identity.copy(), modFactors, tm.getMemoryMaps().get(var).getSpace()));
		}
		
		gen_info.getReductionBodySystem().setTargetMapping(tm);
	}
	
	protected void subSystemGeneration(String outDir){
		//using scheduleC to generate code for the other 2 system
		//set up the target mapping for each system
		setTargetMapping();
		ScheduledC.generate(gen_info.getReductionBodySystem(), options, outDir);
	}
	
	/*protected Function createNewFunctionSigature( AffineSystem affine_sys){
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
	}*/
	
	protected Function GenerateReductionComputation(CodeUnit unit, OriginDomainVolume oriFunc, VolumeFunction volFunc, BoundComputation boundFunc, Function reduct){
		//reflect TargetMapping
		//for (MemorySpace ms : system.getTargetMapping().getMemorySpaces()) {
		for(MemorySpace ms: system.getTargetMapping().getMemorySpaces()){
			unit.getVariables().add(_fact.createCVariable(ms, options.flattenArrays, false));
		}
				
		//construct the function
		Function function = _fact.createFunction(system.getName(), "void");
		//Register all variables
		for (VariableDeclaration var : system.getInputs()) {
			function.getInputs().add(unit.findVariable(system.getTargetMapping().getMemoryMaps().get(var).getSpace().getName()));
		}
		for (VariableDeclaration var : system.getOutputs()) {
			function.getOutputs().add(unit.findVariable(system.getTargetMapping().getMemoryMaps().get(var).getSpace().getName()));
		}
		
		//make sure no duplicates due to multiple equations mapped to the same space
		for (VariableDeclaration var : system.getLocals()) {
			function.getLocals().add(unit.findVariable(system.getTargetMapping().getMemoryMaps().get(var).getSpace().getName()));
		}
				
		//Add parameter checking
		function.getBodies().add(_fact.createParameterCheck(system.getParameters()));
		
		ScanBody reduct_body = _fact.createScanBody(gen_info.getDomain(), volFunc, boundFunc, oriFunc, reduct, null);
				
		String nthreads = "nthreads";
		String threadnum = "thread_num";
		String begin = "begin";
		String end = "end";
		
		//set some variable name
		reduct_body.setNthreadVariableName(nthreads);
		reduct_body.setThreadNumVariableName(threadnum);
		reduct_body.setBeginVariableName(begin);
		reduct_body.setEndVariableName(end);
				
		//construct the reduction sum variable declaration
		Type type = gen_info.getReductionBodySystem().getOutputs().get(0).getType();	//get the variable type
		
		//create the parameter domain with the thread number
		List<String> paraName = new LinkedList<String>();
		paraName.add(nthreads);
		paraName.add(threadnum);
		List<String> paraCons = new LinkedList<String>();
		paraCons.add("nthreads >=1 ");
		paraCons.add("thread_num >= 0");
		ParameterDomain paraThreadsDomain = PolyhedralIRUtility.parseParameterDomain(paraName, paraCons);
		
		//create Domain for scan reduciton variables
		Domain varDomain = PolyhedralIRUtility.parseDomain(paraThreadsDomain, "{i|0<=i<nthreads}");
				
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
		
		reduct_body.getLocalScanReductionVariables().addAll(variables);
		
		//get the local reduction variables
		List<VariableDeclaration> reductionVar = gen_info.getReductionBodySystem().getOutputs();
		
		List<CodeGenVariable> redVars = ScanCUtility.createIdentityCodeGenVariables(reductionVar, options);
	
		reduct_body.getLocalReductionVariables().addAll(redVars);
		
		ScanReductionBody reduct_reduct_body = _fact.createScanReductionBody();
		
		int statementIndex = 0;
		
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
		
		reduct_reduct_body.setPreProcessLoop(preProLoop);
		
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
		
		reduct_reduct_body.getMatrixTempVariables().addAll(matTempVars);
				
		//Initialize  the matrix
		CLoop matrixInitLoop = _fact.createCLoop(paraThreadsDomain, 0);
		Domain initDomain = PolyhedralIRUtility.parseDomain(paraThreadsDomain, "{|}");
		AffineFunction RAccess = PolyhedralIRUtility.parseAffineFunction(paraThreadsDomain, "(i->0)");
		for(int i = 0; i < matrixTempVar.size(); i++){
			VariableDeclaration lvar = matrixTempVar.get(i);
			VariableDeclaration rvar = redSumVar.get(i);
		
			String exp = ScanCUtility.createAssignmentExpression(lvar, null, rvar, RAccess.copy());
			//String exp = createAssignmentExpression(lvar, null, rvar, RAccess.copy());
			matrixInitLoop.getStatements().add(_fact.createStatement(
					CodeGenUtility.createStatementName(unit, statementIndex), preProDomain.copy(), exp));
			statementIndex++;
		}
		reduct_reduct_body.setMatrixInitLoop(matrixInitLoop);
		
		CLoop scanLoop = _fact.createCLoop(paraThreadsDomain, 0);
		//create matrix multiplication form
		Domain scanDomain = PolyhedralIRUtility.parseDomain(paraThreadsDomain, "{i|1 <= i < nthreads}");
				
		AffineFunction access = PolyhedralIRUtility.parseAffineFunction(paraThreadsDomain, "(i->i)");
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
					Avector.add(matrixTempVar.get(i*m+k));
					Bvector.add(redSumVar.get(k*m+j));
				}
					
				String rexp = ScanCUtility.createVectorProductExpression(Avector, null, Bvector, access, oplus, otimes);
				String assign = ScanCUtility.createAssignmentExpression(lvar, null, rexp);
				//String rexp = createVectorProductExpression(Avector, null, Bvector, access, oplus, otimes);
				//String assign = createAssignmentExpression(lvar, null, rexp);
				scanLoop.getStatements().add(_fact.createStatement(
							CodeGenUtility.createStatementName(unit, statementIndex), scanDomain.copy(), assign));
				statementIndex++;
			}
		}
		reduct_reduct_body.setScanLoop(scanLoop);
	
		//create final value computation statement
		//output = TempMatrix*input
		CLoop postLoop = _fact.createCLoop(paraThreadsDomain, 0);
		
		List<VariableDeclaration> outputVector = gen_info.getOutputVector();
		List<VariableDeclaration> inputVector = gen_info.getInputVector();
		Domain computeDomain = PolyhedralIRUtility.parseDomain(paraThreadsDomain, "{|}");
		
		for(int i = 0; i < m-1; i++){
				Avector.clear();
				Bvector.clear();
				VariableDeclaration lvar = outputVector.get(i);
				for(int j = 0; j < m-1; j++){
					Avector.add(matrixTempVar.get(i*m+j));
					Bvector.add(inputVector.get(i*m+j));
				}
				AffineFunction b_access = PolyhedralIRUtility.createIdentityFunction(lvar.getDomain());
				String rexp = ScanCUtility.createVectorProductExpression(Avector, null, inputVector, b_access.copy(), oplus, otimes);
				//String rexp = createVectorProductExpression(Avector, null, inputVector, b_access.copy(), oplus, otimes);
				
				//add the constant part
				VariableDeclaration const_var = matrixTempVar.get(i*m + m-1);
				//String const_exp = createMemoryAccessExpression(const_var, null);
				String const_exp = ScanCUtility.createMemoryAccessExpression(const_var, null);
				
				//rexp = createBinaryExpressionForScan(rexp, oplus, const_exp);
				rexp = ScanCUtility.createBinaryExpressionForScan(rexp, oplus, const_exp);
				
				String exp = ScanCUtility.createAssignmentExpression(lvar, b_access.copy(), rexp);
				//String exp = createAssignmentExpression(lvar, b_access.copy(), rexp);
			//	System.out.println("created expression: " + exp);
				
				postLoop.getStatements().add(_fact.createStatement(
						CodeGenUtility.createStatementName(unit, statementIndex), computeDomain.copy(), exp));
				statementIndex++;
				
		}
		
		reduct_reduct_body.setPostProcessLoop(postLoop);
		
		reduct_body.setScanReductionBody(reduct_reduct_body);
		
		function.getBodies().add(reduct_body);
		
		unit.getFunctions().add(function);	
		
		return function;
		
	}
}
