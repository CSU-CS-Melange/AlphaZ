package org.polymodel.polyhedralIR.polyIRCG.generator.C.MPI;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constant;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraint;
import static org.polymodel.algebra.factory.IntExpressionBuilder.sum;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.ArrayList;
import java.util.List;

import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.reductions.ReductionExpression;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForTiling;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations;
import org.polymodel.polyhedralIR.transformation.helper.FunctionOperations;

/**
 * MPIC uses some conventions while code generation. This class
 * provides methods for following such conventions, so that the
 * generator need minimal change when the conventions need to be
 * modified.
 * 
 * MPIC extends the parameter domain of the original system by:
 *  - tile sizes
 *  - chunkSize
 *  - chunkID, chunkMID
 * in the above order.
 * 
 * When generating code for copying values to/from buffers, and 
 * also to define the domain of send/recv, the parameter domain in
 * use is different from that of the system.
 * The parameter domain for these domains are:
 *   - tile sizes
 *   - tile indices (origins)
 *   - problem parameters (original parameters)
 * 
 * @author yuki
 *
 */
public class MPICUtility {

	

	
	/**
	 * Creates a domain that defines a tile with symbolic bounds.
	 * points in a tile z is constrained to be ti <= zi < ti+ts
	 * in all dimensions.
	 * 
	 * Also adds chunkOrigin as the first parameter
	 * 
	 * The parameters of the created domain follows the convention
	 * for buffers.
	 * 
	 * @param a
	 * @return
	 */
	public static Domain createTileDomain(AffineSystem a) {

		ParameterDomain paramDomain = a.getParameters();
		
		//create domain of a tile
		int tileDims = a.getTargetMapping().getSpaceTimeLevel(0).getNumberOfTiledDimensions();
		List<String> params = new ArrayList<String>(tileDims*2+1);
		List<String> indices = new ArrayList<String>(tileDims);
		

		params.add(CodeGenConstantsForDistributed.chunkOrigin);
		
		for (int i = 1; i <= tileDims; i++) {
			params.add(CodeGenConstantsForTiling.getTileSizeName(i));
			indices.add("c"+i);
		}
		//tile origins as parameters
		for (int i = 1; i <= tileDims; i++) {
			params.add(CodeGenConstantsForTiling.getTileIndexName(i));
		}
		//add program parameters in the end (remove tile size and chunk size parameters that are previously added)
		params.addAll(paramDomain.getParamNames().subList(0, paramDomain.getNParams()-tileDims-MPIC.NUM_EX_PARAMS));
		
		Domain tileDom = PolyhedralIRUtility.parseDomainFromString(params, indices, new ArrayList<String>());
		for (int i = 0; i < tileDom.getNIndices(); i++) {
			//i < ti + ts
			IntExpression ti_plus_ts = affine(term(getTileIndexInBufferSpace(tileDom, i, tileDims)), term(getTileSizeInBufferSpace(tileDom, i)));
			tileDom.getPMdomain().addConstraint(
					constraint(affine(term(tileDom.getIndices().get(i))), 
							ti_plus_ts, 
							ComparisonOperator.LT));
			//ti <= i
			tileDom.getPMdomain().addConstraint(
					constraint(affine(term(getTileIndexInBufferSpace(tileDom, i, tileDims))),
							affine(term(tileDom.getIndices().get(i))), 
							ComparisonOperator.LE));
			//1 <= ts
			tileDom.getPMdomain().addConstraint(
					constraint(constant(1),
							affine(term(getTileSizeInBufferSpace(tileDom, i))), 
							ComparisonOperator.LE));
		}

		return tileDom;
	}
	
	/**
	 * Returns i-th tile size (starts from 0, but the name is from 1) for the buffer space.
	 * Equivalent to getParams().get(i).
	 * 
	 * @param domainInBufferSpace
	 * @param i
	 * @return
	 */
	public static Variable getTileSizeInBufferSpace(Domain domainInBufferSpace, int i) {
		return getTileSizeInBufferSpace(domainInBufferSpace.getParams(), i);
	}

	/**
	 * Returns i-th tile size (starts from 0, but the name is from 1) for the buffer space.
	 * Equivalent to get(i).
	 * 
	 * @param domainInBufferSpace
	 * @param i
	 * @return
	 */
	public static Variable getTileSizeInBufferSpace(List<Variable> paramsInBufferSpace, int i) {
		return paramsInBufferSpace.get(i+1);
	}

	/**
	 * Returns i-th tile index (starts from 0, but the name is from 1) for the buffer space.
	 * Equivalent to getParams().get(i+tileDims).
	 * 
	 * @param domainInBufferSpace
	 * @param i
	 * @return
	 */
	public static Variable getTileIndexInBufferSpace(Domain domainInBufferSpace, int i, int tileDims) {
		return getTileIndexInBufferSpace(domainInBufferSpace.getParams(), i, tileDims);
	}

	/**
	 * Returns i-th tile index (starts from 0, but the name is from 1) for the buffer space.
	 * Equivalent to get(i+tileDims).
	 * 
	 * @param domainInBufferSpace
	 * @param i
	 * @return
	 */
	public static Variable getTileIndexInBufferSpace(List<Variable> paramsInBufferSpace, int i, int tileDims) {
		return paramsInBufferSpace.get(i+tileDims+1);
	}
	
	public static int getNumOriginalParameters(List<Variable> paramsInOriginalSpace, int tileDims) {
		return paramsInOriginalSpace.size() - tileDims - MPIC.NUM_EX_PARAMS; 
	}
	
	public static Variable getTileSizeInOriginalSpace(List<Variable> paramsInOriginalSpace, int i, int tileDims) {
		return paramsInOriginalSpace.get(paramsInOriginalSpace.size()-tileDims-MPIC.NUM_EX_PARAMS+i);
	}

	/**
	 * Replaces problem parameters in an expression using parameters from 
	 * original iteration space to that using buffer space.
	 * All original parameters (NParams - tilesizes - exteneded params (chunkSize, etc)
	 * are replaced with parameters in the buffer space after tile size and tile indices (tileDims*2)
	 * 
	 * @param expr
	 * @param paramsInOS
	 * @param paramsInBS
	 * @param tileDims
	 * @return
	 */
	public static IntExpression replaceParamsOStoBS(IntExpression expr, List<Variable> paramsInOS, List<Variable> paramsInBS, int tileDims) {
		for (int d = 0; d < paramsInOS.size()-tileDims-MPIC.NUM_EX_PARAMS; d++) {
			expr = expr.substitute(paramsInOS.get(d), paramsInBS.get(getStartingIndexOfOriginalParams(tileDims)+d));
		}
		return expr;
	}
	
	private static int getStartingIndexOfOriginalParams(int tileDims) {
		return tileDims*2 + 1;
	}
	
	public static Domain convertFromOStoBS(Domain OSdom, List<Variable> paramsInOS, List<Variable> paramsInBS, int tileDims) {
		List<IntConstraintSystem> polyhedra = new ArrayList<IntConstraintSystem>(OSdom.getPMdomain().getPolyhedra().size());
		for (IntConstraintSystem ics : OSdom.getPMdomain().getPolyhedra()) {
			for (int d = 0; d < paramsInOS.size()-tileDims-MPIC.NUM_EX_PARAMS; d++) {
				ics = ics.substitute(paramsInOS.get(d), paramsInBS.get(getStartingIndexOfOriginalParams(tileDims)+d));
			}
			polyhedra.add(ics);
		}
		
		return PolyhedralIRUserFactory.eINSTANCE.createDomain(paramsInBS, OSdom.getIndices(), polyhedra);
	}
	
	public static List<Variable> getTileSizesInBufferSapce(List<Variable> paramsInBS, int tileDims) {
		int start = 1;
		return paramsInBS.subList(start, start+tileDims);
	}
	public static List<Variable> getTileIndicesInBufferSapce(List<Variable> paramsInBS, int tileDims) {
		int start = tileDims+1;
		return paramsInBS.subList(start, start+tileDims);
	}
	public static List<Variable> getTileSizesInOriginalSapce(List<Variable> paramsInOS, int tileDims) {
		int start = paramsInOS.size()-tileDims-MPIC.NUM_EX_PARAMS;
		return paramsInOS.subList(start, start+tileDims);
	}
	
	/**
	 * Constructs approximated outset from a given domain.
	 * The implementation projects out variables from inner most dimension to outer, 
	 * compute the bounds per dimension, and apply shift_down/up as described in DTiling.
	 * 
	 * The projection part is really the loop generation step, so its similar to generating loop
	 * and then using the method used in DTiling. 
	 * 
	 * Input domain is assumed to be the domain without ordering dimensions.
	 * 
	 * @param dom
	 * @param tileDims
	 * @return
	 */
	public static Domain constructOutSetDomain(Domain dom, List<Variable> tileSizes) {
		return constructOutSetDomain(dom, tileSizes, null);
	}
	
	/**
	 * Constructs approximated outset from a given domain.
	 * The implementation projects out variables from inner most dimension to outer, 
	 * compute the bounds per dimension, and apply shift_down/up as described in DTiling.
	 * 
	 * The projection part is really the loop generation step, so its similar to generating loop
	 * and then using the method used in DTiling. 
	 * 
	 * @param dom
	 * @param tileSizes
	 * @param orderingDims
	 * @return
	 */
	public static Domain constructOutSetDomain(Domain dom, List<Variable> tileSizes, List<Integer> orderingDims) {
		return constructOutSetDomainInternal(dom, tileSizes, orderingDims, false);
	}
	
	/**
	 * Constructs approximated outset but with the outer-most tile dimension constrained to be 0 <= ti1 < ts1.
	 * 
	 * @param dom
	 * @param tileSizes
	 * @param orderingDims
	 * @return
	 */
	public static Domain constructOutSetDomainForSlice(Domain dom, List<Variable> tileSizes, List<Integer> orderingDims) {
		return constructOutSetDomainInternal(dom, tileSizes, orderingDims, true);
	}
	

	/**
	 * 
	 * 
	 * @param dom
	 * @param tileSizes
	 * @param orderingDims
	 * @param slicedTile
	 * @return
	 */
	private static Domain constructOutSetDomainInternal(Domain dom, List<Variable> tileSizes, List<Integer> orderingDims, boolean slicedTile) {
		
		//starts out with universe
		Domain outSetDom = PolyhedralIRUtility.createUniverseDomain(dom.getParams(), dom.getIndices());
		
		//get the parameter domain
		Domain paramConstraints = DomainOperations.removeConstraintsOnIndices(dom);
		
		int currentTileDim = tileSizes.size();
		//collect LB/UB constraints from unions of polyhedra
		//reverse order since inner variables are projected out in turn
		for (int i = dom.getNIndices()-1; i >=0; i--) {
			
			final Variable v = dom.getIndices().get(i);
			
			//skip ordering dims
			if (orderingDims == null || !orderingDims.contains(i)) {
				currentTileDim--;
				//iterate over each polyhedron forming the union
				for (int p = 0; p < dom.getPMdomain().getPolyhedra().size(); p++) {
					IntConstraintSystem poly = dom.getPMdomain().getPolyhedra().get(p);
					
					//initialize new polyhedron
					if (outSetDom.getPMdomain().getPolyhedra().size() <= p) {
						outSetDom.getPMdomain().getPolyhedra().add(IntExpressionBuilder.constraintSystem());
					}
					
					if (slicedTile && currentTileDim == 0) {
						IntExpression lb = constant(0);
						IntExpression ub = affine(term(tileSizes.get(0)));
						
						//apply LB/UB to the index
						IntExpression ti = affine(term(outSetDom.getIndices().get(i)));
						IntConstraint lbConstraint = constraint(lb, ti.copy(), ComparisonOperator.LE);
						IntConstraint ubConstraint = constraint(ub, ti, ComparisonOperator.GE);
						
						//add the constraints to the corresponding polyhedron
						outSetDom.getPMdomain().getPolyhedra().get(p).getConstraints().add(lbConstraint.simplify());
						outSetDom.getPMdomain().getPolyhedra().get(p).getConstraints().add(ubConstraint.simplify());
					} else {
						//collect LB/UB coefficients for shift_down/up
						long[] lbCoefs = new long[dom.getNIndices()];
						long[] ubCoefs = new long[dom.getNIndices()];
		
						IntExpression lb = poly.getLB(v);
						IntExpression ub = poly.getUB(v);
	
						//also collect coefficients of LB/UB for each outer loop indices
						//used for shift_down/up operations
						for (int d = 0; d < i; d++) {
							AffineTerm lbTerm = lb.toAffine().getTerm(outSetDom.getIndices().get(d));
							AffineTerm ubTerm = ub.toAffine().getTerm(outSetDom.getIndices().get(d));
							if (lbTerm != null) {
								lbCoefs[d] = lbTerm.getCoef();
							}
							if (ubTerm != null) {
								ubCoefs[d] = ubTerm.getCoef();
							}
						}
		
						//wrap LB/UB with summation for adding shift_down/up expressions
						lb = sum(lb);
						ub = sum(ub);
		
						//apply shift_down to LB and shift_up to UB (like DTiling)
						for (int d = 0; d < i; d++) {
							int tileDim = 0;
							for (int x = 0; x < d; x++) {
								if (orderingDims == null || !orderingDims.contains(x)) {
									tileDim++;
								}
							}
							//shift down only on negative coefs
							if (lbCoefs[d] < 0) {
								//coef * (ts - 1) = coef*ts - coef
								((ReductionExpression)lb).getExpressions().add(affine(term(lbCoefs[d], tileSizes.get(tileDim)), term(-lbCoefs[d])));
							}
							//shift up only on positive coefs
							if (ubCoefs[d] > 0) {
								((ReductionExpression)ub).getExpressions().add(affine(term(ubCoefs[d], tileSizes.get(tileDim)), term(-ubCoefs[d])));
							}
						}
						//-(sk-1) is always applied to LB
						IntExpression ntsp1 = affine(term(-1, tileSizes.get(currentTileDim)), term(1));
						((ReductionExpression)lb).getExpressions().add(ntsp1);
						
						//apply LB/UB to the index
						IntExpression ti = affine(term(outSetDom.getIndices().get(i)));
						IntConstraint lbConstraint = constraint(lb, ti.copy(), ComparisonOperator.LE);
						IntConstraint ubConstraint = constraint(ub, ti, ComparisonOperator.GE);
						
						//add the constraints to the corresponding polyhedron
						outSetDom.getPMdomain().getPolyhedra().get(p).getConstraints().add(lbConstraint.simplify());
						outSetDom.getPMdomain().getPolyhedra().get(p).getConstraints().add(ubConstraint.simplify());
					}
				}
			}

			//project out innermost
			dom = PolyhedralIRUserFactory.eINSTANCE.createDomain(dom.getPMdomain().projection(v));
			
		}
		
		return outSetDom.intersection(paramConstraints);
	}

	public static Variable getNumTilesPerChunk(List<Variable> paramsInOS) {
		return paramsInOS.get(paramsInOS.size()-MPIC.NUM_EX_PARAMS);
	}
	public static Variable getChunkSizefromOS(List<Variable> paramsInOS) {
		return paramsInOS.get(paramsInOS.size()-MPIC.NUM_EX_PARAMS+1);
	}
	public static Variable getChunkOriginfromOS(List<Variable> paramsInOS) {
		return paramsInOS.get(paramsInOS.size()-MPIC.NUM_EX_PARAMS+2);
	}
	public static Variable getChunkIDfromOS(List<Variable> paramsInOS) {
		return paramsInOS.get(paramsInOS.size()-MPIC.NUM_EX_PARAMS+3);
	}
	public static Variable getChunkMIDfromOS(List<Variable> paramsInOS) {
		return paramsInOS.get(paramsInOS.size()-MPIC.NUM_EX_PARAMS+4);
	}
	public static Variable getChunkPerPfromOS(List<Variable> paramsInOS) {
		return paramsInOS.get(paramsInOS.size()-MPIC.NUM_EX_PARAMS+5);
	}
	public static Variable getBufferIDfromOS(List<Variable> paramsInOS) {
		return paramsInOS.get(paramsInOS.size()-MPIC.NUM_EX_PARAMS+6);
	}
	public static Variable getBufferingFactorfromOS(List<Variable> paramsInOS) {
		return paramsInOS.get(paramsInOS.size()-MPIC.NUM_EX_PARAMS+7);
	}
	

	public static Variable getChunkOriginfromBS(List<Variable> paramsInBS) {
		return paramsInBS.get(0);
	}
	
	/**
	 * Returns an affine function for accessing variables distributed over processors.
	 * The access function is usually inverse of stMap composed with memory mapping,
	 * but here the points in the iteration space (after stMap inverse) must be shifted by chunk origin.
	 * 
	 * Simply composing with the default access function produce is not possible since the order matters.
	 * memMap o stMapInv o shift vs memMap o shift o stMapInv
	 * 
	 * The reason for this process is because the memory is allocated for a slice of tiles 
	 * (chunk of tiles assigned to a virtual processor). Since all slices have different points,
	 * points must be offset to a common coordinate (chunk origin = origin of the coordinates)
	 * so that the same memory mapping function can be applied.
	 * 
	 * @param targetMapping
	 * @param var
	 * @return
	 */
	public static AffineFunction getAccessFunctionForDistributedVariable(TargetMapping targetMapping, VariableDeclaration var) {
		assert(var.isLocal());

		AffineFunction stMapInv = targetMapping.getSpaceTimeLevel(0).getSpaceTimeMaps().get(var.getName()).getMapping().inverse();
		
		AffineFunction memMap = targetMapping.getMemoryMaps().get(var).getMapping();

		List<Variable> params = var.getDomain().getParams();
		//indices in the original iteration space (after stMap inverse)
		List<Variable> indicesIS = var.getDomain().getIndices().subList(0, stMapInv.getDimRHS());
		AffineTerm term = term(-1, MPICUtility.getChunkOriginfromOS(params));
		AffineFunction shift = FunctionOperations.createShiftFunction(params, indicesIS, term, 0);
		
		AffineFunction f = shift.compose(stMapInv);
		return memMap.compose(f);
	}
}
