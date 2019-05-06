package org.polymodel.polyhedralIR.polyIRCG.factory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.BasicBody;
import org.polymodel.polyhedralIR.polyIRCG.BasicStatement;
import org.polymodel.polyhedralIR.polyIRCG.BasicVariable;
import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.CompilationUnit;
import org.polymodel.polyhedralIR.polyIRCG.CompileTimeParameter;
import org.polymodel.polyhedralIR.polyIRCG.CustomPackStruct;
import org.polymodel.polyhedralIR.polyIRCG.CustomProviderStatement;
import org.polymodel.polyhedralIR.polyIRCG.DeclareStructs;
import org.polymodel.polyhedralIR.polyIRCG.FlagVariableReset;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.FunctionParameter;
import org.polymodel.polyhedralIR.polyIRCG.FunctionSignature;
import org.polymodel.polyhedralIR.polyIRCG.IdentityAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.MemoryAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.MemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.MergedDomainAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.MergedMemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.PackStruct;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGFactory;
import org.polymodel.polyhedralIR.polyIRCG.PseudoProjection;
import org.polymodel.polyhedralIR.polyIRCG.PseudoProjectiveAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.ScalarMemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.Statement;
import org.polymodel.polyhedralIR.polyIRCG.Struct;
import org.polymodel.polyhedralIR.polyIRCG.UnpackStruct;
import org.polymodel.polyhedralIR.polyIRCG.VariableFinalization;
import org.polymodel.polyhedralIR.polyIRCG.VariableInitialization;
import org.polymodel.polyhedralIR.polyIRCG.C.CFactory;
import org.polymodel.polyhedralIR.polyIRCG.C.CLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.CVariable;
import org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement;
import org.polymodel.polyhedralIR.polyIRCG.C.ParallelizedCLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.ParameterCheck;
import org.polymodel.polyhedralIR.polyIRCG.C.ScopLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification;
import org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification;
import org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.Buffer;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedFactory;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.DistributedPseudoProjection;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.MPICLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.PartitioningComputation;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.OriginDomainVolume;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanFactory;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunction;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunctionDerivative;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.CWrapperFactory;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.InputInitialization;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputPrinting;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputVerification;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.SpecialVariable;
import org.polymodel.polyhedralIR.polyIRCG.PCOT.PCOTFactory;
import org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody;
import org.polymodel.polyhedralIR.polyIRCG.algebraEx.AlgebraExFactory;
import org.polymodel.polyhedralIR.polyIRCG.algebraEx.ModuloExpression;
import org.polymodel.polyhedralIR.targetMapping.CommunicatedVariableForTiledSpace;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.cgenerator2.MacroBodyProvider;


public class PolyIRCGUserFactory {

	public static final PolyIRCGUserFactory INSTANCE = new PolyIRCGUserFactory();
	
	
	private static final PolyIRCGFactory _fact = PolyIRCGFactory.eINSTANCE;
	private static final CFactory _factC = CFactory.eINSTANCE;
	private static final CWrapperFactory _factCwrapper = CWrapperFactory.eINSTANCE;
	private static final CDistributedFactory _factCdistributed = CDistributedFactory.eINSTANCE;
	private static final ScanFactory _factScan = ScanFactory.eINSTANCE;
	private static final PCOTFactory _factPCOT = PCOTFactory.eINSTANCE;

	
	/**
	 * Creates the root node of generating model.
	 * 
	 * @param program
	 * @return
	 */
	public CompilationUnit createCompilationUnit(Program program) {
		CompilationUnit gc = _fact.createCompilationUnit();
		gc.setProgram(program);
		return gc;
	}
	
	public CodeUnit createCodeUnit(AffineSystem system) {
		CodeUnit unit = _fact.createCodeUnit();
		
		unit.setSystem(system);
		
		return unit;
	}
	
	public Body createBody(String value) {
		BasicBody body = _fact.createBasicBody();
		
		body.setString(value);
		
		return body;
	}
	
	public CLoop createCLoop(ParameterDomain parameterDomain, int numConstantDims) {
		assert(parameterDomain != null);
		CLoop loop = _factC.createCLoop();
		loop.setParameterDomain(parameterDomain);
		loop.setNumConstantDimensions(numConstantDims);
		return loop;
	}
	
	public TiledCLoop createTiledCLoop(ParameterDomain parameterDomain, int numConstantDims) {
		TiledCLoop loop = _factC.createTiledCLoop();
		loop.setParameterDomain(parameterDomain);
		loop.setNumConstantDimensions(numConstantDims);
		return loop;
	}
	
	public ScopLoop createScopLoop(ScopRoot sroot) {
		ScopLoop loop = _factC.createScopLoop();
		loop.setScopRoot(sroot);
		return loop;
	}
	
	public ParallelizedCLoop createParallelizedCLoop(ParameterDomain parameterDomain, int numConstantDims){
		ParallelizedCLoop loop = _factC.createParallelizedCLoop();
		loop.setParameterDomain(parameterDomain);
		loop.setNumConstantDimensions(numConstantDims);
		
		return loop;
	}
	
	public MPICLoop createMPICLoop(ParameterDomain parameterDomain, int numConstantDims) {
		MPICLoop loop = _factCdistributed.createMPICLoop();
		loop.setParameterDomain(parameterDomain);
		loop.setNumConstantDimensions(numConstantDims);
		return loop;
	}
	
	public SubTileSpecification createSubTileSpecification(int level, int start, int end, List<Integer> tileSizes, TILING_TYPE type){
		SubTileSpecification subtile = _factC.createSubTileSpecification();
		
		subtile.setLevel(level);
		subtile.setStart(start);
		subtile.setEnd(end);
		subtile.setTileType(type);
		
		subtile.getTileSizes().addAll(tileSizes);
		
		return subtile;
	}
	
	public TileSpecification createTileSpecification(int levels, List<Integer> prefix, int start, int end, List<SubTileSpecification> subtiles){
		TileSpecification tile = _factC.createTileSpecification();
		
		tile.setLevels(levels);
		tile.getOrderingPrefix().addAll(prefix);
		tile.setStartDim(start);
		tile.setEndDim(end);
		
		
		tile.getSubTiles().addAll(subtiles);
		return tile;
	}
	
	public Buffer createBuffer(CodeGenVariable var) {
		Buffer buff = _factCdistributed.createBuffer();
		
		buff.setVariable(var);
		
		return buff;
	}
	
	public BufferMapping createBufferMapping(Domain dom, MemoryAccessExpression valueAccess, MemoryAccessExpression bufferAccess, CommunicatedVariableForTiledSpace cv) {
		BufferMapping bmap = _factCdistributed.createBufferMapping();
		
		bmap.setDomain(dom);
		bmap.setValueAccess(valueAccess);
		bmap.setBufferAccess(bufferAccess);
		bmap.setCommunicatedVariable(cv);
		
		return bmap;
	}
	
	public FunctionSignature createFunctionSignature(String name, String type) {
		FunctionSignature fs = _fact.createFunctionSignature();
		fs.setName(name);
		if (type == null) {
			fs.setReturnType("void");
		} else {
			fs.setReturnType(type);
		}
		return fs;
	}
		
	
	/**
	 * Creates a function with a name, parameter domain, and return type.
	 * If the function return type given is null, it will be translated as void in C code.
	 * Variables and Bodies of this function must be provided to be complete.
	 * 
	 * @param name
	 * @param params
	 * @param returnType
	 * @return
	 */
	public Function createFunction(String name, String returnType) {
		Function func = _fact.createFunction();
		
		func.setName(name);
		if (returnType == null) {
			func.setReturnType("void");
		} else {
			func.setReturnType(returnType);
		}
		
		return func;
	}
	public Function createFunction(String name, Type returnType) {
		if (returnType == null) {
			return createFunction(name, "void");
		} else {
			return createFunction(name, returnType.toString());
		}
	}
	
	/**
	 * Creates a PseudoProjection from MemorySpace
	 * 
	 */
	public PseudoProjection createMemoryDomain(MemorySpace space) {
		PseudoProjection pproj = _fact.createPseudoProjection();
		pproj.setZeroAligned(space.isZeroAligned());
		pproj.setDomain(space.getDomain());
		for (IntExpression expr : space.getModFactors()) {
			pproj.getModFactors().add(expr.copy());
		}
		//System.out.println("The mode factor is set: " + pproj.getModFactors().toString());
		return pproj;
	}
	

	public ScalarMemoryDomain createScalarMemoryDomain() {
		
		ScalarMemoryDomain mdom = _fact.createScalarMemoryDomain();
		
		mdom.setZeroAligned(false);
		
		return mdom;
	}
	
	public PseudoProjection createPseudoProjection(Domain dom, boolean zeroAligned) {
		PseudoProjection pproj = _fact.createPseudoProjection();
		pproj.setDomain(dom);
		pproj.setZeroAligned(zeroAligned);
		return pproj;
	}
	
	public MergedMemoryDomain createMergedMemoryDomain(Map<String, MemoryDomain> mapping) {
		MergedMemoryDomain mm = _fact.createMergedMemoryDomain();
		
		for (String key : mapping.keySet()) {
			mm.getMemoryDomains().put(key, mapping.get(key));
		}
		
		return mm;
	}
	
	public BufferMemoryDomain createBufferMemoryDomain(Map<String, MemoryDomain> mapping, Variable bufferID, IntExpression bufferingFactor) {

		BufferMemoryDomain bmd = _factCdistributed.createBufferMemoryDomain();
		
		for (String key : mapping.keySet()) {
			bmd.getMemoryDomains().put(key, mapping.get(key));
		}
		
		bmd.setBufferID(bufferID);
		bmd.setBufferingFactor(bufferingFactor);
		
		return bmd;
	}
	
	/**
	 * Create a memory access expression that is a simple identity mapping from domain.
	 * The default access when no mod factors are specified. 
	 *
	 * @param var
	 * @return
	 */
	public IdentityAccessExpression createIdentityAccessExpression(CodeGenVariable var) {
		IdentityAccessExpression iae = _fact.createIdentityAccessExpression();
		
		iae.setVariable(var);
		
		return iae;
	}
	
	/**
	 * Create a memory access expression that requires modulo to be applied.
	 * This type of MAE is created when pseudo projective domains are used.
	 *
	 * @param dom
	 * @return
	 */
	public PseudoProjectiveAccessExpression createPseudoProjectiveExpression(CodeGenVariable var) {
		if (!(var.getDomain() instanceof PseudoProjection)) {
			throw new RuntimeException("The variable must be associated with PseudoProjective domains for MemoryAccessFunction to be PseudoProjective");
		}

		PseudoProjectiveAccessExpression ppae = _fact.createPseudoProjectiveAccessExpression();
		
		ppae.setVariable(var);
		
		return ppae;
	}
	
	public MergedDomainAccessExpression createMergedDomainAccessExpression(CodeGenVariable var, String id, MemoryAccessExpression mae) {
		MergedDomainAccessExpression mdae = _fact.createMergedDomainAccessExpression();
		if (!(var.getDomain() instanceof MergedMemoryDomain)) {
			throw new RuntimeException("The variable must be associated with MergedMemoryDomain for MemoryAccessFunction to be MergedDomainAccessExpression");
		}
		
		mdae.setVariable(var);
		mdae.setIdentifier(id);
		mdae.setAccessExpression(mae);
		
		return mdae;
	}
	
	public BufferAccessExpression createBufferAccessExpression(CodeGenVariable var, String id, MemoryAccessExpression mae, Variable bufferID, IntExpression bufferingFactor) {
		BufferAccessExpression bdae = _factCdistributed.createBufferAccessExpression();
		if (!(var.getDomain() instanceof BufferMemoryDomain)) {
			throw new RuntimeException("The variable must be associated with BufferMemoryDomain for MemoryAccessFunction to be BufferAccessExpression");
		}
		bdae.setVariable(var);
		bdae.setIdentifier(id);
		bdae.setAccessExpression(mae);
		bdae.setBufferID(bufferID);
		bdae.setBufferingFactor(bufferingFactor);
		
		return bdae;
	}
	
	/**
	 * Creates a variable corresponding to a MemorySpace
	 * 
	 * @param space
	 * @param flattened
	 * @param global
	 * @return
	 */
	public CVariable createCVariable(MemorySpace space,  boolean flattened, boolean global) {
		return createCVariable(space, flattened, global, false, false, new LinkedList<Integer>());
	}
	
	public CVariable createCVariable(MemorySpace space,  boolean flattened, boolean global, boolean isFrontPadded, List<Integer> frontPaddingVal) {
		return createCVariable(space, flattened, global, false, isFrontPadded, frontPaddingVal);
	}
	
	public CVariable createCVariable(MemorySpace space,  boolean flattened, boolean global, boolean aligned,  boolean isFrontPadded, List<Integer> frontPaddingVal) {
		CVariable var = _factC.createCVariable();
		
		var.setName(space.getName());
		var.setType(space.getType());
		var.setDomain(createMemoryDomain(space));
		var.setFlattened(flattened);
		var.setGlobal(global);
		var.setAligned(aligned);
		var.setIsfrontpadded(isFrontPadded);
		var.getForntpaddingValue().addAll(frontPaddingVal);
		
		return var;
	}
	
	/**
	 * Creates a variable given variable declaration, and boolean flags necessary for memory access generation.
	 * 
	 * @param varDecl
	 * @param given
	 * @param zeroAligned
	 * @return
	 */
	public CVariable createCVariable(String name, Type type, MemoryDomain domain, boolean flattened, boolean global) {
		return createCVariable(name, type, domain, flattened, global, false, new LinkedList<Integer>());
	}
	
	public CVariable createCVariable(String name, Type type, MemoryDomain domain, boolean flattened, boolean global, boolean isFrontPadded, List<Integer> frontPaddingVal) {
		return createCVariable(name, type, domain, flattened, global, false, isFrontPadded, frontPaddingVal);
	}
	
	public CVariable createCVariable(String name, Type type, MemoryDomain domain, boolean flattened, boolean global, boolean aligned, boolean isFrontPadded, List<Integer> frontPaddingVal) {
		CVariable var = _factC.createCVariable();
		
		var.setName(name);
		var.setType(type);
		var.setDomain(domain);
		var.setFlattened(flattened);
		var.setGlobal(global);
		var.setAligned(aligned);
		var.setIsfrontpadded(isFrontPadded);
		var.getForntpaddingValue().addAll(frontPaddingVal);
		
		return var;
	}
	
	public Statement createStatement(VariableDeclaration varDecl, String name, Domain domain, CodeGenVariable var, AffineFunction access, Expression rhs) {
		EquationAsStatement stmt = _factC.createEquationAsStatement();
		
		if (rhs.getContainerEquation() instanceof UseEquation){
			Domain contextDom = rhs.getContextDomain();
			Domain extDom = ((UseEquation)rhs.getContainerEquation()).getExtensionDomain().copy();
			//get the set of new index for the subsystem
			List<Variable> index = contextDom.getIndices().subList(extDom.getNIndices(), contextDom.getNIndices());
			access = access.compose(PolyhedralIRUtility.createIdentityFunction(access.getParams(), index));
		}else{
			//compose it with identity of the variable domain, just so that names match
			access = access.compose(PolyhedralIRUtility.createIdentityFunction(((StandardEquation)rhs.getContainerEquation()).getVariable().getDomain()));
		}
		
		stmt.setVarDecl(varDecl);
		stmt.setName(name);
		stmt.setDomain(domain);
		stmt.setVariable(var);
		stmt.setAccessFunction(access);
		stmt.setRhs(rhs);
		
		return stmt;
	}
	
	public Statement createStatement(String name, Domain domain, String string) {
		BasicStatement stmt = _fact.createBasicStatement();
		
		stmt.setName(name);
		stmt.setDomain(domain);
		stmt.setStatement(string);
		
		return stmt;
	}
	
	public Statement createStatement(String name, Domain domain, MacroBodyProvider provider) {
		CustomProviderStatement stmt = _fact.createCustomProviderStatement();
		
		stmt.setName(name);
		stmt.setDomain(domain);
		stmt.setProvider(provider);
		
		return stmt;
	}
	
	public ParameterCheck createParameterCheck(ParameterDomain params) {
		ParameterCheck paramCheck = _factC.createParameterCheck();
		paramCheck.setParameterDomain(params);
		return paramCheck;
	}

	/**
	 * Create variable initialization with the given lists of variables.
	 * Can be used if some subset of the variables needs to be initialized in a particular way.
	 * 
	 * @param inputs
	 * @param outputs
	 * @param locals
	 * @return
	 */
	public VariableInitialization createVariableInitialization(List<CodeGenVariable> inputs, List<CodeGenVariable> outputs, List<CodeGenVariable> locals) {
		VariableInitialization varInit = _fact.createVariableInitialization();

		if (inputs != null) {
			varInit.getInputs().addAll(inputs);
		}
		if (outputs != null) {
			varInit.getOutputs().addAll(outputs);
		}
		if (locals != null) {
			varInit.getLocals().addAll(locals);
		}
		
		return varInit;
	}

	/**
	 * Creates VariableInitialization with all in/out/locals of the given function.
	 * 
	 * @param function
	 * @return
	 */
	public VariableInitialization createVariableInitialization(Function function) {
		VariableInitialization varInit = _fact.createVariableInitialization();

		varInit.getInputs().addAll(function.getInputs());
		varInit.getOutputs().addAll(function.getOutputs());
		varInit.getLocals().addAll(function.getLocals());
		varInit.getSpecialLocals().addAll(function.getSpecialLocals());
		
		return varInit;
	}
	
	/**
	 * Creates FlagVariableReset with all out/locals of the given function.
	 * 
	 * @param function
	 * @return
	 */
	public FlagVariableReset createFlagVariableReset(Function function) {
		FlagVariableReset varReset = _fact.createFlagVariableReset();

//		varReset.getOutputs().addAll(function.getOutputs());
		varReset.getLocals().addAll(function.getLocals());
		varReset.getSpecialLocals().addAll(function.getSpecialLocals());
		
		return varReset;
	}

	/**
	 * Create variable  finalization with the given lists of variables.
	 * Can be used if some subset of the variables needs to be finalized in a particular way.
	 * 
	 * @param inputs
	 * @param outputs
	 * @param locals
	 * @return
	 */
	public VariableFinalization createVariableFinalization(List<CodeGenVariable> inputs, List<CodeGenVariable> outputs, List<CodeGenVariable> locals) {
		VariableFinalization varFin = _fact.createVariableFinalization();

		if (inputs != null) {
			varFin.getInputs().addAll(inputs);
		}
		if (outputs != null) {
			varFin.getOutputs().addAll(outputs);
		}
		if (locals != null) {
			varFin.getLocals().addAll(locals);
		}
		
		return varFin;
	}

	/**
	 * Creates VariableFinalization with all in/out/locals of the given function.
	 * 
	 * @param function
	 * @return
	 */
	public VariableFinalization createVariableFinalization(Function function) {
		VariableFinalization varFin = _fact.createVariableFinalization();

		varFin.getInputs().addAll(function.getInputs());
		varFin.getOutputs().addAll(function.getOutputs());
		varFin.getLocals().addAll(function.getLocals());
		varFin.getSpecialLocals().addAll(function.getSpecialLocals());
		
		return varFin;
	}
	
	public SpecialVariable createSpecialVariable(VariableDeclaration var, AffineFunction access){
		SpecialVariable variable = _factCwrapper.createSpecialVariable();
		
		variable.setVarDecl(var);
		variable.setAccess(access);
		
		return variable;
	}
	
	public InputInitialization createInputInitialization(ParameterDomain param, VariableDeclaration var, AffineFunction access) {
		InputInitialization init = _factCwrapper.createInputInitialization();
		init.setParameterDomain(param);
		
		SpecialVariable variable = createSpecialVariable(var, access);
		init.setSpecialVar(variable);
		
		return init;
	}
	
	public OutputVerification createOutputVerification(ParameterDomain param, VariableDeclaration var, AffineFunction access) {
		OutputVerification ver = _factCwrapper.createOutputVerification();
		ver.setParameterDomain(param);
		
		SpecialVariable variable = createSpecialVariable(var, access);
		ver.setSpecialVar(variable);
		
		return ver;
	}
	
	public OutputPrinting createOutputPrinting(ParameterDomain param, VariableDeclaration var, AffineFunction access) {
		OutputPrinting out = _factCwrapper.createOutputPrinting();
		out.setParameterDomain(param);
		
		SpecialVariable variable = createSpecialVariable(var, access);
		out.setSpecialVar(variable);
		
		return out;
	}
	
	public PartitioningComputation createPartitioningComputation(TiledCLoop tcloop) {
		PartitioningComputation pc = _factCdistributed.createPartitioningComputation();
		
		pc.setPartitionedTile(tcloop);
		
		return pc;
	}
	/**
	 * Creates a variable that is diributed using DistributedPseudoProjective memory domain.
	 * 
	 * @param varDecl
	 * @param given
	 * @param zeroAligned
	 * @return
	 */
	public CVariable createDistributedCVariable(MemorySpace space,  boolean flattened, boolean global, List<Integer> dims, List<IntExpression> sizes) {
		CVariable var = _factC.createCVariable();
		
		var.setName(space.getName());
		var.setType(space.getType());
		var.setDomain(createDistributedPseudoProjectiveMemoryDomain(space,  dims, sizes));
//		var.setZeroAligned(space.isZeroAligned());
		var.setFlattened(flattened);
		var.setGlobal(global);
		
		return var;
	}
	/**
	 * Creates a PseudoProjection from MemorySpace
	 * 
	 */
	public DistributedPseudoProjection createDistributedPseudoProjectiveMemoryDomain(MemorySpace space,  List<Integer> dims, List<IntExpression> sizes) {
		DistributedPseudoProjection pproj = _factCdistributed.createDistributedPseudoProjection();
		pproj.setDomain(space.getDomain());
		for (IntExpression expr : space.getModFactors()) {
			pproj.getModFactors().add(expr.copy());
		}
		pproj.getDistributedDims().addAll(dims);
		pproj.getDistributedDimSizes().addAll(sizes);
		return pproj;
	}
	
	public CompileTimeParameter createCompileTimeParameter(String name, String val) {
		CompileTimeParameter ctp = _fact.createCompileTimeParameter();
		
		ctp.setName(name);
		ctp.setDefaultValue(val);
		
		return ctp;
	}
	public VolumeFunction createVolumeFunction(BasicVariable unknown){
		VolumeFunction vol = _factScan.createVolumeFunction();
		
		vol.setUnknown(unknown);
		
		return vol;
	}
	
	public VolumeFunctionDerivative createVolumeFunctionDerivative(BasicVariable unknown){
		VolumeFunctionDerivative vol = _factScan.createVolumeFunctionDerivative();
		
		vol.setUnknown(unknown);
		
		return vol;
	}
	
	public BoundComputation createBoundComputation(BasicVariable lb, BasicVariable ub, BasicVariable init, BasicVariable constantTerm, VolumeFunction vol, VolumeFunctionDerivative vol_deri){
		BoundComputation bound_function = _factScan.createBoundComputation();
		
		bound_function.setLb(lb);
		bound_function.setUb(ub);
		bound_function.setInitialValue(init);
		bound_function.setConstantTerm(constantTerm);
		
		bound_function.setVolumeFunction(vol);
		bound_function.setVolumeFunctionDerivative(vol_deri);
		
		
		return bound_function;
	}
	
	public OriginDomainVolume createOriginDomainVolume() {
		return _factScan.createOriginDomainVolume();
	}
	
	public ScanBody createScanBody(Domain domain, VolumeFunction vol, BoundComputation boundComput, OriginDomainVolume oriFunct, Function reduction, Function scan){
		ScanBody scan_body = _factScan.createScanBody();
		
		scan_body.setDomain(domain);
		scan_body.setVolumeFunction(vol);
		scan_body.setBoundComputationFunction(boundComput);
		scan_body.setOriginDomainVolume(oriFunct);
		scan_body.setLocalReductionFunction(reduction);
		scan_body.setLocalScanFunction(scan);
		
		return scan_body;
	}
	
	public ScanReductionBody createScanReductionBody(){
		ScanReductionBody red_body = _factScan.createScanReductionBody();
		
		return red_body;
	}

	public IntExpression mod(IntExpression numerator, IntExpression denominator) {
		ModuloExpression mod = AlgebraExFactory.eINSTANCE.createModuloExpression();
		mod.setNumerator(numerator.copy());
		mod.setDenominator(denominator.copy());
		return mod;
	}

	public Struct createStruct(String name, List<AbstractVariable> vars) {
		Struct s = _fact.createStruct();
		
		s.setName(name);
		s.getMembers().addAll(vars);
		
		return s;
	}
	
	public DeclareStructs createDeclareStructs(Struct  ...structs) {
		DeclareStructs ds = _fact.createDeclareStructs();
		
		for (Struct s : structs) {
			ds.getStructs().add(s);
		}
		
		return ds;
	}
	
	public PackStruct createPackStruct(Struct  s, AbstractVariable v) {
		PackStruct ps = _fact.createPackStruct();
		
		ps.setStruct(s);
		ps.setInstance(v);
		
		return ps;
	}
	public CustomPackStruct createCustomPackStruct(Struct  s, AbstractVariable v) {
		CustomPackStruct pps = _fact.createCustomPackStruct();
		
		pps.setStruct(s);
		pps.setInstance(v);
		pps.setInitValues(new HashMap<>());
		
		return pps;
	}
	public UnpackStruct createUnpackStruct(Struct  s, AbstractVariable v) {
		UnpackStruct pps = _fact.createUnpackStruct();

		pps.setStruct(s);
		pps.setInstance(v);
		
		return pps;
	}
	
	public RecursionBody createPCOTRecursionBody(Function base, int start, int end) {
		RecursionBody rb = _factPCOT.createRecursionBody();
		
		rb.setBaseFunction(base);
		rb.setBandStart(start);
		rb.setBandEnd(end);
		
		return rb;
	}

	public BasicVariable createBasicVariable(String name, String type) {
		BasicVariable bv = _fact.createBasicVariable();

		bv.setName(name);
		bv.setType(type);
		
		return bv;
	}
}
