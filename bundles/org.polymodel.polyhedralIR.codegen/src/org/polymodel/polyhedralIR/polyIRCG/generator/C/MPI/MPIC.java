package org.polymodel.polyhedralIR.polyIRCG.generator.C.MPI;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.Loop;
import org.polymodel.polyhedralIR.polyIRCG.C.CVariable;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.DistributedPseudoProjection;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.PolyIRCodeGen.CODEGEN;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.ScheduledC;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.StatementVisitorForScheduledC;
import org.polymodel.polyhedralIR.targetMapping.CommunicatedVariableForTiledSpace;
import org.polymodel.polyhedralIR.targetMapping.CommunicationMappingForTiledSpace;
import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.transformation.helper.FunctionOperations;
import org.polymodel.polyhedralIR.util.ExtendParameterDomain;

public class MPIC extends ScheduledC {
	

	public static final int NUM_EX_PARAMS = 8; //number of extended parameters 
	
	protected List<Variable> localParams;
	
	/**
	 * Static method for public access to ScheduledC code generator.
	 * 
	 * @param system
	 * @param options
	 * @param outDir
	 */
	public static void generate(AffineSystem system, CodeGenOptions options, String outDir) {
		MPIC mpiC = new MPIC(system, options);
		mpiC.generate(options, outDir);
	}

	protected MPIC(AffineSystem system, CodeGenOptions options) {
		super(system, options);
	}
	

	@Override
	protected void initialize() {
		super.initialize();
		
		//tile sizes are added in super class

		ExtendParameterDomain.addParameters(this.system, CodeGenConstantsForDistributed.numTilesPerChunk);
		ExtendParameterDomain.addParameters(this.system, CodeGenConstantsForDistributed.chunkSize);
		ExtendParameterDomain.addParameters(this.system, CodeGenConstantsForDistributed.chunkOrigin);
		ExtendParameterDomain.addParameters(this.system, CodeGenConstantsForDistributed.chunkID);
		ExtendParameterDomain.addParameters(this.system, CodeGenConstantsForDistributed.chunkMID);
		ExtendParameterDomain.addParameters(this.system, CodeGenConstantsForDistributed.chunkPerP);
		ExtendParameterDomain.addParameters(this.system, CodeGenConstantsForDistributed.bufferID);
		ExtendParameterDomain.addParameters(this.system, CodeGenConstantsForDistributed.BUFFERING_FACTOR);

		int nParams = this.system.getParameters().getNParams();
		localParams = new ArrayList<Variable>(2);
		localParams.add(this.system.getParameters().getParams().get(nParams-7));
		localParams.add(this.system.getParameters().getParams().get(nParams-6));
		localParams.add(this.system.getParameters().getParams().get(nParams-5));
		localParams.add(this.system.getParameters().getParams().get(nParams-4));
		localParams.add(this.system.getParameters().getParams().get(nParams-3));
		localParams.add(this.system.getParameters().getParams().get(nParams-2));
		localParams.add(this.system.getParameters().getParams().get(nParams-1));
	}

	
	@Override
	protected void generationPreProcessing() {
		super.generationPreProcessing();
		
		
	}
	
	@Override
	protected CODEGEN getCodeGen() {
		return CODEGEN.MPI_C;
	}
	
	@Override
	protected StatementVisitorForScheduledC getStatementVisitor(CodeUnit unit) {
		return new StatementVisitorForMPIC(unit, unit.getSystem().getTargetMapping(), options);
	}
	
	@Override
	protected List<CodeUnit> getCodeUnits() {

		List<CodeUnit> res = new Vector<CodeUnit>(1);
		CodeUnit unit = _fact.createCodeUnit(system);
		
		unit.getLocalParameters().addAll(localParams);
		final List<Variable> params = system.getParameters().getParams();
		TargetMapping tm = system.getTargetMapping();
		final SpaceTimeLevel stlevel = tm.getSpaceTimeLevel(0);
		assert(stlevel.getTilingSpecifications().size() == 1);
		final SubTilingSpecification ts = stlevel.getTilingSpecifications().get(0).getSubTiles().get(0);
		final int tileDims = stlevel.getNumberOfTiledDimensions();
		
		//reflect TargetMapping
		for (MemorySpace ms : system.getTargetMapping().getMemorySpaces()) {
			//not designed to handle multiple variables allocated to a same memory yet 
			assert(ms.getMemoryMaps().size() == 1);
			
			boolean nonLocal = false;
			for (MemoryMap mm : ms.getMemoryMaps()) {
				nonLocal |= (mm.getVariable().isInput() || mm.getVariable().isOutput());
			}
			if (!nonLocal) {

				for (MemoryMap mm : ms.getMemoryMaps()) {
					//insert chunkMID as the first dimension of memory map
					mm.setMapping(FunctionOperations.insertDimension(mm.getMapping(), affine(term(MPICUtility.getChunkMIDfromOS(params))), 0));
					//insert mod factor 0 to the first dimension as well
					mm.getModFactors().add(0, IntExpressionBuilder.constant(0));
				}
				List<Integer> dims = new ArrayList<Integer>(){ { add(0);} };
				List<IntExpression> sizes = new ArrayList<IntExpression>() { { add(affine(term(MPICUtility.getChunkPerPfromOS(params)))); } };
				
				//create distributed variable
				CVariable dcv = _fact.createDistributedCVariable(ms, options.flattenArrays, false, dims, sizes);
				DistributedPseudoProjection dpp = (DistributedPseudoProjection)dcv.getDomain();
				
				//modify the domain associated with the pseudo projection such that the domain is the projection of a chunk
				MemoryMap mm = ms.getMemoryMaps().get(0);
				CommunicationMappingForTiledSpace cm = ts.getCommunicationMapping();
				CommunicatedVariableForTiledSpace commVar = (cm==null)?null:cm.getCommunicatedVariable(mm.getVariable());
				//get the domain after CoB
				Domain dom = mm.getVariable().getDomain();
				
				dom = MPICUtility.constructOutSetDomainForSlice(dom, MPICUtility.getTileSizesInOriginalSapce(dom.getParams(), tileDims), stlevel.getOrderingDimensions());
//				System.err.println("outset:"+dom);
				
//				//find the first tiled (non-ordering) dimension
//				int dim = 0;
//				while (tm.getOrderingDimensions().contains(dim)) dim++;
//				//change the bound on first tiled dimension to be 0 <= i1 <chunkSize
//				{
//					dom = DomainOperations.removeConstraintsOnADimension(dom, dim);
//					//finally, add constraints on the added dimension
//					IntConstraint lb = constraint(constant(0), affine(term(dom.getIndices().get(dim))), ComparisonOperator.LE);
//					IntConstraint ub = constraint(affine(term(tileSizes.get(0))), affine(term(dom.getIndices().get(dim))), ComparisonOperator.GT);
//					dom.getPMdomain().addConstraint(lb);
//					dom.getPMdomain().addConstraint(ub);
//				}
//				System.err.println("slice:"+dom);
				//apply inverse of schedule
				dom = dom.image(stlevel.getSpaceTimeMaps().get(mm.getVariable().getName()).getMapping().inverse());
				
//				System.err.println("stMapInv(slice):"+dom);

				//then project
				{
					//Find the LB of each dimension, and shift the memory mapping accordingly
					Domain pDom = dom.image(mm.getMapping());
//					System.err.println("mm(stMapInv(slice)):"+pDom);
					for (int x = 0; x < pDom.getNIndices(); x++)
//						System.err.println("mm(stMapInv(slice)).bounds("+x+"):"+pDom.getBounds(x));
					//replace ts1 with chunkSize everywhere
					{
						List<IntConstraintSystem> polyhedra = new ArrayList<IntConstraintSystem>(pDom.getPMdomain().getPolyhedra().size()); 
						for (IntConstraintSystem poly : pDom.getPMdomain().getPolyhedra()) {
							polyhedra.add(poly.substitute(tileSizes.get(0), MPICUtility.getChunkSizefromOS(params)));
						}
						pDom = PolyhedralIRUserFactory.eINSTANCE.createDomain(pDom.getParams(), pDom.getIndices(), polyhedra);
					}
//					System.err.println("mm(stMapInv(slice))+chunk:"+pDom);
					
					List<AffineExpression> exprs = mm.getMapping().getExpressions();
					for (int d = 1; d < pDom.getNIndices(); d++) {
						IntExpression lb = pDom.getBounds(d).get(0);
						if (commVar != null) {
							IntExpression lbAdjust = IntExpressionBuilder.constant(-commVar.getCommunicationDepths().get(d-1));
							lb = IntExpressionBuilder.sum(lb, lbAdjust);
						}
						IntExpression expr = IntExpressionBuilder.sub(exprs.get(d), lb);
						exprs.set(d, expr.toAffine());
					}

					//reconstruct mapping
					AffineFunction newMM = PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(mm.getMapping().getParams(), mm.getMapping().getIndices(), exprs);
					
					//project with the new memory mapping
					dom = dom.image(newMM);
					//reflect
					mm.setMapping(newMM);
					dpp.setDomain(dom);
//					System.err.println("newMM:"+newMM);
//					System.err.println("memoryDom:"+dom);
				}
				
				
				unit.getVariables().add(dcv);
			} else if (ms.getMemoryMaps().size() > 0) {
				unit.getVariables().add(_fact.createCVariable(ms, options.flattenArrays, false));
			}
		}
		
		system.accept(getStatementVisitor(unit));
		
		res.add(unit);
		
		for (Function f : unit.getFunctions()) {
			for (Body b : f.getBodies()) {
				if (b instanceof Loop) {
					System.err.println(((Loop) b).getParameterDomain());
				}
			}
		}
		
		return res;
	}
}
