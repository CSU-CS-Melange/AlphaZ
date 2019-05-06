package org.polymodel.polyhedralIR.polyIRCG.generator.C;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constant;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraint;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;
import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed.getNumberOfTiles;
import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed.getTileMemoryID;
import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForTiling.getTileIndexName;
import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForTiling.getTileSizeName;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.Variable;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.factory.TargetMappingUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.CompilationUnit;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.generator.AbstractCodeGenerator;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.PolyIRCodeGen;
import org.polymodel.polyhedralIR.polyIRCG.generator.TiledCodeGenOptions;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.targetMapping.TilingSpecification;
import org.polymodel.polyhedralIR.util.ExtendParameterDomain;

public abstract class CodeGeneratorTemplateForC extends AbstractCodeGenerator {

	protected static final PolyIRCGUserFactory _fact = PolyIRCGUserFactory.INSTANCE;
	
	protected CodeGeneratorTemplateForC(Program program) {
		super(program);
	}

	@Override
	protected void initialize() {
		//Initialize TargetMapping to null if not given
		for (AffineSystem system : program.getSystems()) {
			if (system.getTargetMapping() == null) {
				system.setTargetMapping(TargetMappingUserFactory.createIdentityTargetMapping(system));
			}
		}
	}
	
	@Override
	protected void generate(CodeGenOptions option, String outDir) {
		
		
		if (option.DEBUG) System.out.println("generate called");
		if (option.DEBUG) System.out.println("initializing codegen");
		initialize();
		// Some code generator may require pre-processing before starting code
		// generation
		generationPreProcessing();
		if (option.DEBUG) System.out.println("generationPreProcessing done");

		CompilationUnit gc = _fact.createCompilationUnit(program);
		
		if (option.DEBUG) System.out.println("getCodeUnit called");
		//Create a unit for the target system. Current CodeGen only handles code generation for a system.
		gc.getUnits().addAll(getCodeUnits());
		if (option.DEBUG) System.out.println("getCodeUnit done");
		
		if (option.DEBUG) System.out.println("Xpand called");
		PolyIRCodeGen.generate(this, option, gc, outDir);
		if (option.DEBUG) System.out.println("Xpand done");
		

		if (option.DEBUG) System.out.println("generationPostProcessing called");
		// Some code generator may require post-processing before after code generation
		generationPostProcessing();
		if (option.DEBUG) System.out.println("generationPostProcessing done");

	}
	
	@Override
	protected void generationPreProcessing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void generationPostProcessing() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Get the list of tile sizes for multipass strategy
	 */
	protected List<String> getTileSizesForMultiPass(AffineSystem system){
		List<String> tileSizes = new LinkedList<String>();
		
		SpaceTimeLevel stlevel = system.getTargetMapping().getSpaceTimeLevel(0);
		int nDim = stlevel.getNumberOfDimensions() - stlevel.getNumberOfOrderingDimensions();
		//add tile sizes for the level 1 pass
		tileSizes.add(CodeGenConstantsForTiling.getPassSizeName(1, 1));
		
		//add tiles sizes for the level 2 pass
		for(int i = 2; i < nDim; i++){
			tileSizes.add(CodeGenConstantsForTiling.getPassSizeName(i, 2));
		}
		
		//add tile sizes for the level 3 tiling
		for(int i = 1; i <= nDim; i++){
			tileSizes.add(CodeGenConstantsForTiling.getTileSizeName(i, 3));
		}
		
		return tileSizes;
	}
	
	/**
	 * Get list of tile size variables for general tiling
	 */
	public static List<String> getTileSizesForDTiling(AffineSystem system){
		List<String> tileSizes = new LinkedList<String>();
		
		SpaceTimeLevel stlevel = system.getTargetMapping().getSpaceTimeLevel(0);
		List<Integer> orderingDimensions = stlevel.getOrderingDimensions();
		for(TilingSpecification tile : stlevel.getTilingSpecifications()){
			List<Integer> orderingPrefix = tile.getOrderingPrefix();
			//ORDER DOES NOT MATTER
			for(SubTilingSpecification subtile: tile.getSubTiles()){	//the target mapping specificaiton starts from 0 to maintain the consistancy
				int start = CodeGenUtilityForC.orderingDimensionFilter(orderingDimensions, orderingPrefix, subtile.getStartDim(), true);
				int end = CodeGenUtilityForC.orderingDimensionFilter(orderingDimensions, orderingPrefix, subtile.getEndDim(), false);
				int level = subtile.getLevel();
				for(int i = start+1; i <= end+1; i++){
					tileSizes.add(getTileSizeName(orderingPrefix, i, level));
				}
			}
		}
		
		return tileSizes;
	}
	
	/**
	 * Get list of tile iterators for general tiling
	 */
	public static List<String> getTileIteratorsForDTiling(AffineSystem system){
		List<String> tileSizes = new LinkedList<String>();
		
		SpaceTimeLevel stlevel = system.getTargetMapping().getSpaceTimeLevel(0);
		List<Integer> orderingDimensions = stlevel.getOrderingDimensions();
		for(TilingSpecification tile : stlevel.getTilingSpecifications()){
			List<Integer> orderingPrefix = tile.getOrderingPrefix();
			//ORDER DOES NOT MATTER
			for(SubTilingSpecification subtile: tile.getSubTiles()){	//the target mapping specificaiton starts from 0 to maintain the consistancy
				int start = CodeGenUtilityForC.orderingDimensionFilter(orderingDimensions, orderingPrefix, subtile.getStartDim(), true);
				int end = CodeGenUtilityForC.orderingDimensionFilter(orderingDimensions, orderingPrefix, subtile.getEndDim(), false);
				int level = subtile.getLevel();
				for(int i = start+1; i <= end+1; i++){
					tileSizes.add(getTileIndexName(orderingPrefix, i, level));
				}
			}
		}
		
		return tileSizes;
	}
	
	/**
	 * Add tile size as parameters of the system
	 * 
	 * @param system
	 * @param options
	 */
	protected List<Variable> addTileSizesAsParameters(AffineSystem system, TiledCodeGenOptions options) {
		//TODO: current code generation only handles spacetime map with one level
		//this should be extended to multi-level spacetime map
		List<String> tileSizes = new LinkedList<String>(); 
		if(options.multiPassSequential || options.multiPassWavefront){
			tileSizes.addAll(getTileSizesForMultiPass(system));
		}else{
			tileSizes.addAll(getTileSizesForDTiling(system));
		}
		
		ExtendParameterDomain.addParameters(system, tileSizes);
		List<Variable> tSizes = new ArrayList<Variable>(tileSizes.size());
		int offset = system.getParameters().getNParams() - tileSizes.size();
		for (int i = 0; i < tileSizes.size(); i++) {
			tSizes.add(system.getParameters().getParams().get(offset+i));
		}

		//add constraints on the parameters so that tile sizes > 0
		for (Variable tSize : tSizes) {
			//tile sizes > 0
			system.getParameters().getPMdomain().addConstraint(
					constraint(affine(term(tSize)), constant(0), ComparisonOperator.GT)
				);
		}
		
		return tSizes;
	}
	/**
	 * Add tile indices as parameters of the system
	 * This is currently not called anywhere
	 * @param system
	 * @param options
	 */
	protected List<Variable> addTileIndicesAsParameters(AffineSystem system) {
		//this is not necessary with the new targetmapping
		//if the there is tiling specification, there is no such type called untiled in the new model
//		if (system.getTargetMapping().getTiling().getType() == TILING_TYPE.UNTILED) {
//			throw new RuntimeException("Unexpected");
//		}
		List<String> tileIndices = new LinkedList<String>(); 
		//TODO: current code generation only handles spacetime map with one level
		//this should be extended to multi-level spacetime map
		for (int i = 1; i <= system.getTargetMapping().getSpaceTimeLevel(0).getNumberOfTiledDimensions(); i++) {
			tileIndices.add(getTileIndexName(i));
		}
		ExtendParameterDomain.addParameters(system, tileIndices);
		List<Variable> tIndices = new ArrayList<Variable>(tileIndices.size());
		int offset = system.getParameters().getNParams() - tileIndices.size();
		for (int i = 0; i < tileIndices.size(); i++) {
			tIndices.add(system.getParameters().getParams().get(offset+i));
		}
		return tIndices;
	}

	protected List<Variable> addNumberOfTilesAsParameters(AffineSystem system) {
		List<String> numberOfTiles = new LinkedList<String>(); 
		for (int i = 1; i <= system.getTargetMapping().getSpaceTimeLevel(0).getNumberOfTiledDimensions(); i++) {
			numberOfTiles.add(getNumberOfTiles(i));
		}
		ExtendParameterDomain.addParameters(system, numberOfTiles);
		List<Variable> numTiles = new ArrayList<Variable>(numberOfTiles.size());
		int offset = system.getParameters().getNParams() - numberOfTiles.size();
		for (int i = 0; i < numberOfTiles.size(); i++) {
			numTiles.add(system.getParameters().getParams().get(offset+i));
		}
		return numTiles;
	}

	protected void preCheckForDTilerVecOptions(AffineSystem system, TiledCodeGenOptions options){
		//check is there intersection between the vecVar and var_dom_map configuration
		//if a variable occurs in both configuration, use the configuration in var_dom_map and remove the one in vecVar
		if(options.var_dom_map != null && options.var_dom_map.size() > 0){
			for(Map.Entry<String, Domain> var_dom_entry: options.var_dom_map.entrySet()){
				if(options.vecVar != null && options.vecVar.size() > 0 && options.vecVar.contains(var_dom_entry.getKey())){
					options.vecVar.remove(var_dom_entry);
					System.out.println("Repeated configuration for variable " + var_dom_entry.getKey() + ", and the configuration without domain is removed.");
				}
			}
		}
		//check if the number of dimensions is the same for all the vectorization variables
		int dim = -1;
		if(options.vecVar != null && options.vecVar.size() > 0){
			for(String vecVar: options.vecVar){
				VariableDeclaration var = system.getVariableDeclaration(vecVar);
				if(dim == -1){
					dim = var.getDomain().getNIndices();
				}else if(dim != var.getDomain().getNIndices()){
					throw new RuntimeException("The number of dimensions is not the same for all the variables that are configured to be vectorized.");
				}
			}
		}
		if(options.var_dom_map != null && options.var_dom_map.size() > 0){
			for(Map.Entry<String, Domain> var_dom_entry: options.var_dom_map.entrySet()){
				VariableDeclaration var = system.getVariableDeclaration(var_dom_entry.getKey());
				if(dim == -1){
					dim = var.getDomain().getNIndices();
				}else if(dim != var.getDomain().getNIndices()){
					throw new RuntimeException("The number of dimensions is not the same for all the variables that are configured to be vectorized.");
				}
			}
		}
		
		if(options.var_dom_map != null && options.var_dom_map.size() > 0){
			//process for the domain of the variable to reflect the change of basis
			for(Map.Entry<String, Domain> var_dom_entry: options.var_dom_map.entrySet()){
				AffineFunction function = system.getTargetMapping().getSpaceTimeLevel(0).getSpaceTimeMaps().get(var_dom_entry.getKey()).getMapping();
				Domain oriDom = PolyhedralIRUtility.parseDomain(system.getParameters(), var_dom_entry.getValue().toString());
				
				//System.out.println("funciton: " + function);
				//System.out.println("The original domain: " + var_dom_entry.getValue());
				Domain mappedDom = oriDom.image(function);
				var_dom_entry.setValue(mappedDom);
			}
		}
		
		//set the unroll dimension 
		options.unrollDims = new int[dim];
		for(int i = 0; i < dim; i++){
			options.unrollDims[i] = i+1;
		}
		if(options.unrollFactors == null || options.unrollFactors.length == 0){
			options.unrollFactors = new int[dim-1];
			for(int i = 0; i < dim-2; i++){
				options.unrollFactors[i] = 1;
			}
			options.unrollFactors[dim-2] = 4;
		}
		
		if(options.unrollFactors.length != dim - 1){
			throw new RuntimeException("Number of dimensions of the register block size is not the same as the data dimension of the variables.");
		}
		//attach the first dimension for time
		int[] factors = new int[dim];
		factors[0] = 1;
		for(int i = 1; i < dim; i++){
			factors[i] = options.unrollFactors[i-1];
		}
		options.unrollFactors = factors;
	}
	
	
	protected List<Variable> addTileMemoryIDAsParameters(AffineSystem system) {
		List<String> tileMIDs = new LinkedList<String>(); 
		for (int i = 1; i <= system.getTargetMapping().getSpaceTimeLevel(0).getNumberOfTiledDimensions(); i++) {
			tileMIDs.add(getTileMemoryID(i));
		}
		ExtendParameterDomain.addParameters(system, tileMIDs);
		List<Variable> tileNums = new ArrayList<Variable>(tileMIDs.size());
		int offset = system.getParameters().getNParams() - tileMIDs.size();
		for (int i = 0; i < tileMIDs.size(); i++) {
			tileNums.add(system.getParameters().getParams().get(offset+i));
		}
		return tileNums;
	}
	
	protected static void clearUnusedMemorySpace(TargetMapping tm) {
		List<MemorySpace> rmlist = new LinkedList<MemorySpace>();
		for (MemorySpace space : tm.getMemorySpaces()) {
			if (space.getMemoryMaps().size() == 0)
				rmlist.add(space);
		}
		
		tm.getMemorySpaces().removeAll(rmlist);
	}
}
