package org.polymodel.polyhedralIR.factory;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.util.PolymodelRegexParser;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Equation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.targetMapping.CommunicatedVariableForTiledSpace;
import org.polymodel.polyhedralIR.targetMapping.CommunicationMappingForTiledSpace;
import org.polymodel.polyhedralIR.targetMapping.LoopUnrollingSpecification;
import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.ParallelizationSpecification;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap;
import org.polymodel.polyhedralIR.targetMapping.StatementPartialOrder;
import org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.targetMapping.TargetMappingFactory;
import org.polymodel.polyhedralIR.targetMapping.TilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization;
import org.polymodel.polyhedralIR.targetMapping.VectorizationSpecification;

/**
 * Separate Factory for TargetMapping.
 * 
 * @author yunzou
 *
 */
public class TargetMappingUserFactory {
	private static TargetMappingFactory fact = TargetMappingFactory.eINSTANCE;
	private static PolyhedralIRUserFactory userFact = PolyhedralIRUserFactory.eINSTANCE;

	
	public static TargetMapping createIdentityTargetMapping(AffineSystem system){
		TargetMapping mapping = fact.createTargetMapping();
		
		//get the variables in the system
		List<VariableDeclaration> vars = new LinkedList<VariableDeclaration>();
		vars.addAll(system.getInputs());
		vars.addAll(system.getLocals());
		vars.addAll(system.getOutputs());
		
		List<UseEquation> uses = new LinkedList<UseEquation>();
		uses.addAll(system.getUseEquations());
		//initialize the spacetimelevel list with only one level
		mapping.getSpaceTimeLevels().add(createIdentitySpaceTimeLevel(vars, uses));
		
		
		//create the memoryspace List, no shared memory space
		for(VariableDeclaration var : vars){
			MemorySpace space = mapping.getMemorySpace(var.getName());
			MemoryMap map = createMemoryMap(var, PolyhedralIRUtility.createIdentityFunction(var.getDomain()), null, space);
			mapping.getMemoryMaps().put(var, map);
		}
		
		return mapping;
	}
	
	/**
	 * Identity space time level includes a list of spacetimemap with identity mapping function for each variables
	 * There is no ordering dimension, no tiling, loop unrolling, vectorization and parallelization
	 * @param vars
	 * @return
	 */
	public static SpaceTimeLevel createIdentitySpaceTimeLevel(List<VariableDeclaration> vars, List<UseEquation> uses){
		//create a identity space time map for each variable
		EList<SpaceTimeMap> stmapList = new BasicEList<SpaceTimeMap>();
		for(VariableDeclaration var : vars){
			stmapList.add(createIdentityStandardEquationSpaceTimeMap(var));
		}
		
		//create identity space time map for each use equation
		for(UseEquation u : uses){
			stmapList.add(createIdentityUseEquationSpaceTimeMap(u));
		}
		
		SpaceTimeLevel stlevel = createSpaceTimeLevel(stmapList, null, null, null, null, null);
		
		return stlevel;
	}
	
	public static SpaceTimeLevel createSpaceTimeLevel(List<SpaceTimeMap> stmapList, List<Integer> ordering, List<TilingSpecification> tilingSpecList, 
			List<LoopUnrollingSpecification> unrollingSpecList, List<VectorizationSpecification> vecSpecList, List<ParallelizationSpecification> parallelSpecList){
		SpaceTimeLevel stlevel = fact.createSpaceTimeLevel();
		
		//add the corresponding value 
		stlevel.getSpaceTimeMaps().clear();
		if(stmapList != null){
			for(SpaceTimeMap stmap :stmapList){
				stlevel.getSpaceTimeMaps().put(stmap.getLabel(), stmap);
			}
		}
		
		stlevel.getOrderingDimensions().clear();
		if(ordering != null){
			stlevel.getOrderingDimensions().addAll(ordering);
		}
		
		stlevel.getTilingSpecifications().clear();
		if(tilingSpecList != null){
			stlevel.getTilingSpecifications().addAll(tilingSpecList);
		}
		
		stlevel.getLoopUnrollingSpecifications().clear();
		if(unrollingSpecList != null){
			stlevel.getLoopUnrollingSpecifications().addAll(unrollingSpecList);
		}
		
		stlevel.getVectorizationSpecifications().clear();
		if(vecSpecList != null){
			stlevel.getVectorizationSpecifications().addAll(vecSpecList);
		}
		
		stlevel.getParallelizationSpecifications().clear();
		if(parallelSpecList != null){
			stlevel.getParallelizationSpecifications().addAll(parallelSpecList);
		}
		
		return stlevel;
	}
	
	public static SpaceTimeMap createIdentityStandardEquationSpaceTimeMap(VariableDeclaration var){
		
		AffineFunction identity = PolyhedralIRUtility.createIdentityFunction(var.getDomain());
		
		SpaceTimeMap stmap = createStandardEquationSpaceTimeMap(var, identity);
		
		return stmap;
	}
	
	public static SpaceTimeMap createIdentityUseEquationSpaceTimeMap(UseEquation u){
		AffineFunction identity = PolyhedralIRUtility.createIdentityFunction(u.getExtensionDomain());
		
		SpaceTimeMap stmap = createUseEquationSpaceTimeMap(u.getLabel(), identity, u);
		
		return stmap;
	}
	
	public static SpaceTimeMap createStandardEquationSpaceTimeMap(VariableDeclaration var, AffineFunction mapping){
		SpaceTimeMap stmap = fact.createSpaceTimeMap();
		
		stmap.setLabel(var.getName());
		stmap.setMapping(mapping);
		stmap.setInverseOfMapping(mapping.inverseInContext(var.getDomain(), null));
		
		return stmap;
	}
			
	public static SpaceTimeMap createUseEquationSpaceTimeMap(String label, AffineFunction mapping, UseEquation use){
		SpaceTimeMap stmap = fact.createSpaceTimeMap();
		
		stmap.setLabel(label);
		stmap.setMapping(mapping);
		stmap.setInverseOfMapping(mapping.inverseInContext(use.getExtensionDomain(), null));
		
		return stmap;
	}
	
	public static SubTilingSpecification createSubTilingSpecification(int level, int start, int end, TILING_TYPE type){
		SubTilingSpecification subtile = fact.createSubTilingSpecification();
	
		if (start < 0 || end < 0 || end < start) {
			throw new RuntimeException("Invalid range of tiled dimensions: " + "[" + start + ", " + end + "]");
		}
		
		subtile.setLevel(level);
		subtile.setStartDim(start);
		subtile.setEndDim(end);
		
		subtile.setTilingType(type);
	
		//TODO: CURRENTLY, WE ONLY SUPPORT PARAMETERIZED TILING,
		//DIFFERETNT TILILE SIZE TYPE SHOULD BE ENABLED WHEN OTHER TYPE TILING IS ENABLED
		subtile.setTileSizeType(TILE_SIZE_TYPE.PARAMETERIZED);
		
		return subtile;
	}
	
	public static TilingSpecification createTilingSpecification(String name, List<Integer> orderingPrefix, int start, int end, int total_level) {
		TilingSpecification tspec = fact.createTilingSpecification();
		
		tspec.setIdentificationName(name);
		tspec.getOrderingPrefix().addAll(orderingPrefix);
		
		if (start < 0 || end < 0 || end < start) {
			throw new RuntimeException("Invalid range of tiled dimensions: " + "[" + start + ", " + end + "] with ordering prefix " + orderingPrefix.toString());
		}
		
		tspec.setStartDim(start);
		tspec.setEndDim(end);
		tspec.setLevels(total_level);
		
		return tspec;
	}
	
	

	public static ParallelizationSpecification createParallelizationSpecification(List<Integer> prefixVector, int dim){
		ParallelizationSpecification parallelSpec = fact.createParallelizationSpecification();
		
		parallelSpec.getOrderingPrefix().clear();
		if(prefixVector != null){
			parallelSpec.getOrderingPrefix().addAll(prefixVector);
		}
		parallelSpec.getParallelDims().add(dim);
		
		return parallelSpec;
	}

	public static ParallelizationSpecification createParallelizationSpecification(List<Integer> prefixVector, List<Integer> dims){
		ParallelizationSpecification parallelSpec = fact.createParallelizationSpecification();
		
		parallelSpec.getOrderingPrefix().clear();
		if(prefixVector != null){
			parallelSpec.getOrderingPrefix().addAll(prefixVector);
		}
		parallelSpec.getParallelDims().addAll(dims);
		
		return parallelSpec;
	}

	public static MemoryMap createIdentityMemoryMap(VariableDeclaration var, MemorySpace space) {
		return createMemoryMap(var, PolyhedralIRUtility.createIdentityFunction(var.getDomain()), null, space);
	}
	
	public static MemoryMap createMemoryMap(VariableDeclaration var, AffineFunction mapping, List<IntExpression> modFactor, MemorySpace space){
		MemoryMap mm = fact.createMemoryMap();
		
		mm.setVariable(var);
		mm.setMapping(mapping);
		
		mm.getModFactors().clear();
		if(modFactor == null){//if no modFactor, all the element is 0
			for(int i = 0; i < mapping.getDimRHS(); i++){
				mm.getModFactors().add(affine(term(0)));
			}
		}else{
			mm.getModFactors().addAll(modFactor);
		}
		
		mm.setSpace(space);
		
		return mm;
	}

//	public static MemorySpace createMemorySpace(String name){
//		MemorySpace mspace = fact.createMemorySpace();
//		
//		mspace.setName(name);
//		
//		return mspace;
//		
//	}
	
	public static StatementPartialOrder createStatementOrder(Equation predecessor, Equation successor) {
		StatementPartialOrder order = fact.createStatementPartialOrder();
		
		order.setPredecessor(predecessor);
		order.setSuccessor(successor);
		
		return order;
	}
	
	public static EList<IntExpression> createModFactor(List<Variable> params, List<Variable> indices, List<String> modFactors) {
		if (modFactors == null) {
			return null;
		}
		
		List<Variable> vars = new ArrayList<Variable>(params.size()+indices.size());
		vars.addAll(params);
		vars.addAll(indices);
		
		EList<IntExpression> exprs = new BasicEList<IntExpression>(modFactors.size());
		for (String modFactor : modFactors) {//FIXME; should be more genral than affine
			exprs.add(PolymodelRegexParser.parseAffineExpression(modFactor, vars));
		}
		
		return exprs;
	}
	
	
	public static UseEquationOptimization createUseEquationOptimization(String label, int num, boolean isInput, AffineFunction memoryMapping, String spaceName,
			AffineFunction mem_allocate_mapping, AffineFunction value_copy_mapping, AffineFunction mem_free_mapping){
		UseEquationOptimization opt = fact.createUseEquationOptimization();
		
		opt.setLabel(label);
		opt.setNum(num);
		opt.setInput(isInput);
		opt.setMemoryMappingForTemporaryVariable(memoryMapping);
		opt.setMemorySpaceNameforTemporaryVariable(spaceName);
		opt.setMemoryAllocationSpaceTimeMap(mem_allocate_mapping);
		opt.setValueCopySpaceTimeMap(value_copy_mapping);
		opt.setMemoryFreeSpaceTimeMap(mem_free_mapping);
		
		return opt;
	}
	public static CommunicationMappingForTiledSpace createCommunicationMapping() {
		return fact.createCommunicationMappingForTiledSpace();
	}

	public static CommunicatedVariableForTiledSpace createCommunicatedVariable(VariableDeclaration varDecl, int ... depths) {
		List<Integer> dList = new ArrayList<Integer>(depths.length);
		for (int depth : depths) {
			dList.add(depth);
		}
		
		return createCommunicatedVariable(varDecl, dList);
	}
	
	
	public static CommunicatedVariableForTiledSpace createCommunicatedVariable(VariableDeclaration varDecl, List<Integer> depths) {
		CommunicatedVariableForTiledSpace var = fact.createCommunicatedVariableForTiledSpace();
		
		var.setVariable(varDecl);
		var.getCommunicationDepths().clear();
		var.getCommunicationDepths().addAll(depths);
		
		return var;
	}
}
