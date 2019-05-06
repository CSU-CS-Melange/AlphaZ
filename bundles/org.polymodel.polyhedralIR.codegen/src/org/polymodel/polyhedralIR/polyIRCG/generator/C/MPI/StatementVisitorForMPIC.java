package org.polymodel.polyhedralIR.polyIRCG.generator.C.MPI;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraint;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.MemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.PseudoProjection;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.Buffer;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.MPICLoop;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.TiledCodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.StatementVisitorForScheduledC;
import org.polymodel.polyhedralIR.targetMapping.CommunicatedVariableForTiledSpace;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;

public class StatementVisitorForMPIC extends StatementVisitorForScheduledC {

	protected StatementVisitorForMPIC(CodeUnit unit, TargetMapping mapping, CodeGenOptions options) {
		super(unit, mapping, options);
		
//		if (!(options instanceof DistributedCodeGenOptions)) {
//			throw new RuntimeException("Expecting DistributedCodeGenOptions");
//		}
	}
	

	@Override
	public void inAffineSystem(AffineSystem a) {
		
		Function function = _fact.createFunction(a.getName(), "void");
		unit.getFunctions().add(function);
		//This is the entry point for executing this system
		function.setEntryPoint(true);
		
		//Register all variables
		for (VariableDeclaration var : a.getInputs()) {
			CodeGenVariable v = unit.findCGVariable(targetMapping.getMemoryMaps().get(var).getSpace().getName());
			if (function.getInputs().contains(v)) continue;
			function.getInputs().add(v);
		}
		for (VariableDeclaration var : a.getOutputs()) {
			CodeGenVariable v = unit.findCGVariable(targetMapping.getMemoryMaps().get(var).getSpace().getName());
			if (function.getInputs().contains(v)) continue;
			if (function.getOutputs().contains(v)) continue;
			function.getOutputs().add(v);
		}
		//make sure no duplicates due to multiple equations mapped to the same space
		for (VariableDeclaration var : a.getLocals()) {
			CodeGenVariable v = unit.findCGVariable(targetMapping.getMemoryMaps().get(var).getSpace().getName());
			if (function.getInputs().contains(v)) continue;
			if (function.getOutputs().contains(v)) continue;
			if (function.getLocals().contains(v)) continue;
			function.getLocals().add(v);
		}
		
		//add communication buffers
		List<Buffer> buffers = addCommunicationBuffers(a, function);
		
		//Add parameter checking
		function.getBodies().add(_fact.createParameterCheck(a.getParameters()));
		//Add malloc
		function.getBodies().add(_fact.createVariableInitialization(function));

		SpaceTimeLevel stlevel = targetMapping.getSpaceTimeLevel(0);
		//Create a loop that evaluate all equations, and later visitors will fill in the loop
		MPICLoop mpiloop = _fact.createMPICLoop(a.getParameters(), stlevel.getNumberOfOrderingDimensions());
		mpiloop.getBuffers().addAll(buffers);
		//tiling type
		mpiloop.getTiles().get(0).getSubTiles().get(0).setTileType(TILING_TYPE.MPIC);
		//mpiloop.setType(TILING_TYPE.MPIC);
		//optimize?
		if (options instanceof TiledCodeGenOptions && ((TiledCodeGenOptions)options).optimized) {
			mpiloop.setOptimize(true);
		}
		//set tile sizes
		//for (int ts : targetMapping.getTiling().getTilesizes()) {
		//	mpiloop.getTileSizes().add(ts); FIXME
		//}
		mainLoop = mpiloop;
		function.getBodies().add(mainLoop);
		
		//Add free
		function.getBodies().add(_fact.createVariableFinalization(function));

	}
	
	protected List<Buffer> addCommunicationBuffers(AffineSystem a, Function function) {
		TargetMapping tm = a.getTargetMapping();
		SpaceTimeLevel stlevel = tm.getSpaceTimeLevel(0);
		List<Buffer> buffers = new ArrayList<Buffer>();
		SubTilingSpecification ts = stlevel.getTilingSpecifications().get(0).getSubTiles().get(0);
		
		if (ts.getCommunicationMapping() == null) return buffers;
		
		Variable bufferID = MPICUtility.getBufferIDfromOS(a.getParameters().getParams());
		
		//separate communicated variable by types
		Map<Type, List<CommunicatedVariableForTiledSpace>> typeMap = new HashMap<Type, List<CommunicatedVariableForTiledSpace>>();
		for (CommunicatedVariableForTiledSpace cv : ts.getCommunicationMapping().getVariables()) {
			if (!typeMap.containsKey(cv.getVariable().getType())) {
				List<CommunicatedVariableForTiledSpace> vars = new ArrayList<CommunicatedVariableForTiledSpace>();
				typeMap.put(cv.getVariable().getType(), vars);
			}
			typeMap.get(cv.getVariable().getType()).add(cv);
		}
		
		//create tile domain; domain that constraints c1,c2,...,cx within a tile offset by tile origins
		Domain tileDom = MPICUtility.createTileDomain(a);

		int tileDims = stlevel.getNumberOfTiledDimensions();
		
		//for each type
		for (Type type : typeMap.keySet()) {
			//collect memory domains for each variable with the same type
			Map<String, MemoryDomain> mergedDomains = new TreeMap<String, MemoryDomain>();
			//for each variable
			for (CommunicatedVariableForTiledSpace cv : typeMap.get(type)) {
				//PseudoProjective w.r.t. each variable
				PseudoProjection pp = _fact.createPseudoProjection(tileDom.copy(), true);
				for (int d : cv.getCommunicationDepths()) {
					pp.getModFactors().add(IntExpressionBuilder.constant(d));
				}
				mergedDomains.put(cv.getVariable().getName(), pp);
			}

			//Create variable based on collected domains
			//one buffer per data type
			String varName = type.getCName()+"_buffer";
			BufferMemoryDomain merged = _fact.createBufferMemoryDomain(mergedDomains, bufferID, affine(term(MPICUtility.getBufferingFactorfromOS(a.getParameters().getParams()))));
			//variable for buffer
			CodeGenVariable buffVar = _fact.createCVariable(varName, type, merged, true, false);
			//add it to the unit and function so that it is malloced
			function.getCodeunit().getVariables().add(buffVar);
			function.getLocals().add(buffVar);
			
			Buffer buffer = _fact.createBuffer(buffVar);
			buffers.add(buffer);
			
			//iterate over variables again to create accesses
			for (CommunicatedVariableForTiledSpace cv : typeMap.get(type)) {
				//access domain within a tile
				Domain accessDom = tileDom.copy();
				for (int i = 0; i < accessDom.getNIndices(); i++) {
					if (cv.getCommunicationDepths().get(i) <= 0) continue;
					//ti + ts - depth <= i
					{
						IntExpression lhs = affine(term(MPICUtility.getTileSizeInBufferSpace(tileDom, i)), 
													term(MPICUtility.getTileIndexInBufferSpace(tileDom, i, tileDims)), 
													term(-cv.getCommunicationDepths().get(i)));
						IntConstraint constraint = constraint(
								lhs,
								affine(term(tileDom.getIndices().get(i))),
								ComparisonOperator.LE);
						accessDom.getPMdomain().addConstraint(constraint);
					}
				}
				buffer.getBufferMappings().add(_fact.createBufferMapping(accessDom,
						_fact.createPseudoProjectiveExpression(function.getCodeunit().findCGVariable(cv.getVariable().getName())), 
						_fact.createBufferAccessExpression(buffVar, cv.getVariable().getName(),
									_fact.createIdentityAccessExpression(
											//dummy variable just for access expression, gives access for each variable within merged domain, except for the offset
											_fact.createCVariable(cv.getVariable().getName(), type, 
													_fact.createPseudoProjection(tileDom.copy(), tm.getMemoryMaps().get(cv.getVariable()).getSpace().isZeroAligned()), true ,true))
								, bufferID, affine(term(MPICUtility.getBufferingFactorfromOS(a.getParameters().getParams())))),
						cv));
			}
			
		}
		return buffers;
	}
	
	@Override
	public void outAffineSystem(AffineSystem a) {
		super.outAffineSystem(a);
		
	}
	
}
