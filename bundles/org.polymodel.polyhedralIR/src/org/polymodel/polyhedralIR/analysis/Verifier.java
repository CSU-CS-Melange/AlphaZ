package org.polymodel.polyhedralIR.analysis;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.verifier.IVerifierMessage;
import org.polymodel.polyhedralIR.analysis.verifier.IVerifierMessage.VERBOSITY;
import org.polymodel.polyhedralIR.analysis.verifier.VerifierOutput;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.prdg.PRDG;

public class Verifier {
	private static PolyhedralIRUserFactory userFact_ = PolyhedralIRUserFactory.eINSTANCE;
	protected final Program containerProgram;
	protected final AffineSystem affineSystem_;
	protected final TargetMapping targetMapping_;
	protected PRDG prdg_;
	protected List<IVerifierMessage> errors_ = new LinkedList<IVerifierMessage>();
	protected VERBOSITY verbosity_;

	protected static enum STATUS {
		SATISFIED, NOTSATISFIED, INVALID
	};

	private static final boolean DEBUG_ = false;

	public static VerifierOutput verify(AffineSystem system, VERBOSITY verbosity) {
		try {
			Verifier verifier = new Verifier(system, verbosity);
			throw new UnsupportedOperationException("Verifier does not work with new TargetMapping");
//			return verifier.run();
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	protected Verifier(AffineSystem system, VERBOSITY verbosity) {
		containerProgram = userFact_.createProgram();
		affineSystem_ = EcoreUtil.copy(system);
		targetMapping_ = affineSystem_.getTargetMapping();
		containerProgram.getSystems().add(affineSystem_);
		verbosity_ = verbosity;
	}

	protected PRDG constructPRDG(AffineSystem system) {
		return PRDGBuilder.build(system);
	}

//	private VerifierOutput run() {
//		errors_.clear();	//clear the error list
//
//		Program normalizedProgram = userFact_.createProgram();
//		AffineSystem normalizedAffineSystem = EcoreUtil.copy(affineSystem_);
//		normalizedProgram.getSystems().add(normalizedAffineSystem);
//		NormalizeReduction.apply(normalizedAffineSystem);
//		
//		//if no reduction embeded in a reduction
//		if (affineSystem_.getEquations().size() == normalizedAffineSystem.getEquations().size()) {
//
//			prdg_ = constructPRDG(affineSystem_);
//			EList<PRDGNode> node_list = new BasicEList<PRDGNode>(prdg_.getNodes());
//			EList<PRDGEdge> edge_list = new BasicEList<PRDGEdge>(prdg_.getEdges());
//
//			if (true == basicSyntacticCheck()) {
//
//				if (positivityCheck(node_list)) {	//check the positive condition of the scheduling function
//					causalityCheck(edge_list);	//check the causality condition
//
//					if (!edge_list.isEmpty()) {
//						for (PRDGEdge edge : edge_list) {
//							errors_.add(new CausalityConditionError(TYPE.TIME, edge));
//						}
//					} else {
//						memoryMapCheck();
//						tilingCheck();
//					}
//				}
//			}
//		} else {
//			errors_.add(new UnNormalizedAffineSystem(affineSystem_.getName()));
//		}
//
//		return new VerifierOutput(errors_);
//	}
//
//	protected boolean tilingCheck() {
//
//		TilingSpecification tiling_spec = targetMapping_.getTiling();
//
//		if (targetMapping_.isTiled()) {
//			// TODO: get which dimensions in the target mapping specification
//			// need to be tiled
//			int tiling_start_dim = 0;
//			int tiling_end_dim = targetMapping_.getNumerOfDimensions();
//
//			EList<PRDGEdge> edgeList = new BasicEList<PRDGEdge>(prdg_.getEdges());
//
//			//all the dimensions before tiling must satisfy the legality condition
//			for (PRDGEdge edge : prdg_.getEdges()) {
//				if (verifyLegality(edge, tiling_start_dim)) {
//					edgeList.remove(edge);
//				}
//			}
//
//			EList<PRDGEdge> failed_list = new BasicEList<PRDGEdge>();
//
//			for (PRDGEdge edge : edgeList) {
//				if (false == verifyPermutablity(edge, tiling_start_dim, tiling_end_dim)) {
//					failed_list.add(edge);
//				}
//			}
//
//			if (failed_list.size() > 0) {
//
//				for (PRDGEdge edge : failed_list) {
//					errors_.add(new TilingError(TYPE.TILING, edge));
//				}
//
//				return false;
//			}
//		}
//		return true;
//	}
//
//	protected boolean verifyPermutablity(PRDGEdge edge, int tiling_start_dim, int tiling_end_dim) {
//
//		if (DEBUG_) {
//			System.out.println(edge.getSource().getName() + "->" + edge.getDestination().getName() + " : " + edge.getFunction().getMapping());
//		}
//
//		if (!hasReduceTempNode(edge)) {
//			SpaceTimeMap srcSpaceTimeMap = getSpaceTimeMap(edge.getSource());
//			SpaceTimeMap dstSpaceTimeMap = getSpaceTimeMap(edge.getDestination());
//
//			if (srcSpaceTimeMap == null) {
//				PRDGNode reduceVarNode = getReductionVariableNode(edge.getSource());
//				srcSpaceTimeMap = getSpaceTimeMap(reduceVarNode);
//			}
//
//			if (dstSpaceTimeMap == null) {
//				PRDGNode reduceBodyNode = getReductionBodyNode(edge.getDestination());
//				dstSpaceTimeMap = getSpaceTimeMap(reduceBodyNode);
//			}
//
//			Domain problemDomain = getProblemDomain(edge);
//			List<AffineExpression> diffSpaceTimeMapExprList = getDiffSpaceTimeMapExpressionList(problemDomain, srcSpaceTimeMap, dstSpaceTimeMap, edge);
//
//			for (int dim = tiling_start_dim; dim < tiling_end_dim; ++dim) {
//				DIM_TYPE dimType = srcSpaceTimeMap.getType(dim);
//
//				if (dimType == DIM_TYPE.PARALLEL) {
//					if (sameProcessor(EcoreUtil.copy(problemDomain), diffSpaceTimeMapExprList, dim) == STATUS.INVALID) {
//						return false;
//					}
//				} else if (dimType == DIM_TYPE.SEQUENTIAL) {
//					if (checkCausality(EcoreUtil.copy(problemDomain), diffSpaceTimeMapExprList, dim) == STATUS.INVALID) {
//						return false;
//					}
//				}
//			}
//		}
//
//		return true;
//	}
//
//	protected STATUS sameProcessor(Domain problemDomain, List<AffineExpression> diffSpaceTimeMapExprList, int dim) {
//		STATUS satisfied = STATUS.INVALID;
//
//		IntConstraint affineForm = constraint(diffSpaceTimeMapExprList.get(dim), constant(0), ComparisonOperator.GE);
////		IntConstraint affineForm = linConstraint((diffSpaceTimeMapExprList.get(dim)), ComparisonOperator.GE);
//
//		if (satisfies(problemDomain.getPMdomain(), affineForm)) {
//			affineForm = mul(affineForm, -1);
//			// affineForm = negate(affineForm);
//			affineForm.setComparisonOperator(ComparisonOperator.GE);
//			if (satisfies(problemDomain.getPMdomain(), affineForm)) {
//				satisfied = STATUS.SATISFIED;
//			}
//		}
//
//		return satisfied;
//	}
//
//	protected STATUS checkCausality(Domain problemDomain, List<AffineExpression> diffSpaceTimeMapExprList, int dim) {
//		STATUS satisfied = STATUS.INVALID;
//
//		IntConstraint affineForm = constraint(diffSpaceTimeMapExprList.get(dim), constant(0), ComparisonOperator.GE);
////		IntConstraint affineForm = linConstraint((diffSpaceTimeMapExprList.get(dim)), ComparisonOperator.GE);
//
//		if (satisfies(problemDomain.getPMdomain(), affineForm)) {
//			satisfied = STATUS.SATISFIED;
//		}
//
//		return satisfied;
//	}
//
//	/*
//	 * check whether the space time map is specified in a legal way
//	 * the number of dimension 
//	 * the statement order
//	 * */
//	protected boolean basicSyntacticCheck() {
//		boolean isValid = true;
//
//		if (targetMapping_.getSpaceTimeMaps().size() > 0) {
//			List<SpaceTimeMap> spaceTimeMapList = new LinkedList<SpaceTimeMap>();
//			
//			//get the space time map for statements
//			for (SpaceTimeMap spaceTimeMap : targetMapping_.getSpaceTimeMaps()) {
//				if (!spaceTimeMap.getVariable().isInput()) {
//					spaceTimeMapList.add(spaceTimeMap);
//				}
//			}
//
//			if (spaceTimeMapList.size() > 0) {
//				{
//					SpaceTimeMap firstSpaceTimeMap = spaceTimeMapList.get(0);
//
//					if (DEBUG_) {
//						System.out.println(firstSpaceTimeMap.getVariable() + " : " + firstSpaceTimeMap.getMapping());
//					}
//
//					for (SpaceTimeMap nextSpaceTimeMap : spaceTimeMapList.subList(1, spaceTimeMapList.size())) {
//
//						if (DEBUG_) {
//							System.out.println(nextSpaceTimeMap.getVariable() + " : " + nextSpaceTimeMap.getMapping());
//						}
//
//						if (firstSpaceTimeMap.getDimTypes().size() == nextSpaceTimeMap.getDimTypes().size()) { //space time map must have the same number of dimension on the right hand side
//
//							//for each dimension, check the legality
//							for (int j = 0; j < firstSpaceTimeMap.getDimTypes().size(); ++j) {
//								// this looks little complex, but its
//								// exclusive-OR logic
//								if (!((firstSpaceTimeMap.getType(j) == DIM_TYPE.ORDERING) == (nextSpaceTimeMap.getType(j) == DIM_TYPE.ORDERING))) { //
//									isValid = false;
//								}
//							}
//						} else {
//							isValid = false;
//						}
//					}
//				}
//
//				if (isValid) {
//					for (int i = 0; i < spaceTimeMapList.size(); ++i) {
//						SpaceTimeMap spaceTimeMap = spaceTimeMapList.get(i);
//						
//						//for each pair of space time map
//						for (int j = i + 1; j < spaceTimeMapList.size(); ++j) {
//							SpaceTimeMap nextSpaceTimeMap = spaceTimeMapList.get(j);
//							
//							//for each dimension
//							for (int k = 0; k < spaceTimeMap.getDimTypes().size(); ++k) {
//								if (spaceTimeMap.getType(k) != nextSpaceTimeMap.getType(k)) {
//									EList<Integer> constList = spaceTimeMap.getMapping().getConstantPart();
//									EList<Integer> nextConstList = nextSpaceTimeMap.getMapping().getConstantPart();
//
//									boolean loopsOrdered = false;
//									
//									//different statement must have different order 
//									//at the same dimension
//									for (int m = 0; m < k; ++m) {
//										if (spaceTimeMap.getType(m) == DIM_TYPE.ORDERING) {
//											if (constList.get(m).compareTo(nextConstList.get(m)) != 0) {
//												loopsOrdered = true;
//												break;
//											}
//										}
//									}
//
//									if (loopsOrdered == false) {
//										isValid = false;
//										break;
//									}
//								}
//							}
//						}
//					}
//				}// if(isValid)
//			}
//
//			if (!isValid) {
//				errors_.add(new SpecDimensionError(TYPE.SPEC, targetMapping_.getSpaceTimeMaps()));
//			}
//
//		}
//		return isValid;
//	}
//	
//	/*
//	 * check the positive condition for the schedule of each node
//	 */
//	protected boolean positivityCheck(List<PRDGNode> nodeList) {
//		boolean ret_val = true;
//		if (DEBUG_) {
//			System.out.println("=== areSpaceTimeMapsNonNegative ===");
//		}
//		for (PRDGNode node : nodeList) {
//			ret_val &= positivityCheck(node);
//		}
//
//		return ret_val;
//	}
//
//	/*
//	 * check that EACH component of the space-time map is non-negative for all points in the domain of node
//	 */
//	protected boolean positivityCheck(PRDGNode node) {
//
//		boolean ret_val = true;
//
//		SpaceTimeMap spaceTimeMap = getSpaceTimeMap(node);
//
//		if (DEBUG_) {
//			System.out.println(node + " : " + ((spaceTimeMap == null) ? null : spaceTimeMap.getMapping()));
//		}
//
//		if (spaceTimeMap != null) {
//			for (int dim = 0; dim < spaceTimeMap.getDimTypes().size(); ++dim) {
//				
//				//form the constraint (f(z) >= 0)
//				IntConstraint affineForm = constraint(spaceTimeMap.getMapping().getExpressions().get(dim), constant(0), ComparisonOperator.GE);
//				
//				//check the emptiness of negation of the constraint (affineForm) on its own definition domain
//				boolean ret = satisfies(node.getDomain(), affineForm);
//
//				if (!ret) {	//construct the error message
//					TYPE type = TYPE.ORDERING;
//					if (targetMapping_.getDimensionType(affineSystem_.getVariableDeclaration(node.getName()), dim) == DIM_TYPE.SEQUENTIAL) {
//						type = TYPE.TIME;
//					} else if (targetMapping_.getDimensionType(affineSystem_.getVariableDeclaration(node.getName()), dim) == DIM_TYPE.PARALLEL) {
//						type = TYPE.PROCESSOR;
//					}
//					errors_.add(new NonNegativityError(type, node.getDomain(), node, spaceTimeMap.getMapping(), dim));
//				}
//
//				ret_val &= ret;
//			}
//		}
//
//		return ret_val;
//	}
//
//	/*
//	 * verify the legality for each dependence edge
//	 */
//	protected void causalityCheck(EList<PRDGEdge> edgeList) {
//
//		EList<PRDGEdge> tempList = new BasicEList<PRDGEdge>(edgeList);
//		
//		//verify the causality condition for each edge
//		for (PRDGEdge edge : tempList) {
//			if (causalityCheck(edge)) {
//				edgeList.remove(edge);
//			}
//		}
//		
//		//check the statement ordering for each edge ??
//		tempList = new BasicEList<PRDGEdge>(edgeList);
//		for (PRDGEdge edge : tempList) {
//
//			if (checkStatementOrdering(edge.getSource().getName(), edge.getDestination().getName())) {
//				edgeList.remove(edge);
//			}
//		}
//	}
//
//	/*
//	 * check whether the dependence is for the reduce expression after normalization
//	 */
//	boolean hasReduceTempNode(PRDGEdge edge) {
//		if (!isVariable(edge.getSource().getName()) || !isVariable(edge.getDestination().getName())) {
//			if (edge.getFunction() instanceof ProjectionFunction) {
//				return true;
//			} else if (isVariable(edge.getSource().getName())) {
//				return true;
//			}
//		}
//
//		return false;
//	}
//
//	/*
//	 * verify the causality condition for each edge
//	 * returns true for valid or invalid edges, for unsatisfied edges, its false
//	 */
//	protected boolean causalityCheck(PRDGEdge edge) {
//
//		if (DEBUG_) {
//			System.out.println(edge.getSource().getName() + "->" + edge.getDestination().getName() + " : " + edge.getFunction().getMapping());
//		}
//
//		if (!hasReduceTempNode(edge)) {// the dependence does not involve a reduce expression
//			SpaceTimeMap srcSpaceTimeMap = getSpaceTimeMap(edge.getSource());
//			SpaceTimeMap dstSpaceTimeMap = getSpaceTimeMap(edge.getDestination());
//			
//			if (srcSpaceTimeMap == null) {
//				PRDGNode reduceVarNode = getReductionVariableNode(edge.getSource());
//				srcSpaceTimeMap = getSpaceTimeMap(reduceVarNode);
//			}
//
//			/*the following situation does not look like it will occur*/
//			if (dstSpaceTimeMap == null) {
//				PRDGNode reduceBodyNode = getReductionBodyNode(edge.getDestination());
//				dstSpaceTimeMap = getSpaceTimeMap(reduceBodyNode);
//			}
//
//			//construct domain {edge.src (z), edge.dst (z'), z' = f(z)}
//			Domain problemDomain = getProblemDomain(edge);
//			//get the list of affine expressions for each dimension 
//			List<AffineExpression> diffSpaceTimeMapExprList = getDiffSpaceTimeMapExpressionList(problemDomain, srcSpaceTimeMap, dstSpaceTimeMap, edge);
//			
//			//for each dimension
//			for (int dim = 0; dim < srcSpaceTimeMap.getDimTypes().size(); ++dim) {
//
//				if (srcSpaceTimeMap.getType(dim) == dstSpaceTimeMap.getType(dim)) {
//					DIM_TYPE dimType = srcSpaceTimeMap.getType(dim);
//
//					if (dimType == DIM_TYPE.ORDERING) {
//						if (checkStatementOrdering(EcoreUtil.copy(problemDomain), diffSpaceTimeMapExprList, edge, dim) != STATUS.NOTSATISFIED) {
//							return true;
//						}
//					} else if (dimType == DIM_TYPE.PARALLEL) {
//						if (sameProcessor(EcoreUtil.copy(problemDomain), diffSpaceTimeMapExprList, edge, dim) == STATUS.INVALID) {
//							return true;
//						}
//					} else {
//						if (checkCausality(EcoreUtil.copy(problemDomain), diffSpaceTimeMapExprList, edge, dim) != STATUS.NOTSATISFIED) {
//							return true;
//						}
//					}
//				} else {
//					errors_.add(new EdgeDimensionError(TYPE.SPEC, edge, dim));
//					return true;
//				}
//			}
//		} else {	
//			return true;
//		}
//
//		return false;
//	}
//
//	protected boolean verifyLegality(PRDGEdge edge, int last_dim) {
//
//		if (DEBUG_) {
//			System.out.println(edge.getSource().getName() + "->" + edge.getDestination().getName() + " : " + edge.getFunction().getMapping());
//		}
//
//		if (!hasReduceTempNode(edge)) {
//			SpaceTimeMap srcSpaceTimeMap = getSpaceTimeMap(edge.getSource());
//			SpaceTimeMap dstSpaceTimeMap = getSpaceTimeMap(edge.getDestination());
//
//			if (srcSpaceTimeMap == null) {
//				PRDGNode reduceVarNode = getReductionVariableNode(edge.getSource());
//				srcSpaceTimeMap = getSpaceTimeMap(reduceVarNode);
//			}
//
//			if (dstSpaceTimeMap == null) {
//				PRDGNode reduceBodyNode = getReductionBodyNode(edge.getDestination());
//				dstSpaceTimeMap = getSpaceTimeMap(reduceBodyNode);
//			}
//
//			Domain problemDomain = getProblemDomain(edge);
//			List<AffineExpression> diffSpaceTimeMapExprList = getDiffSpaceTimeMapExpressionList(problemDomain, srcSpaceTimeMap, dstSpaceTimeMap, edge);
//
//			for (int dim = 0; dim < last_dim; ++dim) {
//
//				DIM_TYPE dimType = srcSpaceTimeMap.getType(dim);
//
//				if (dimType == DIM_TYPE.ORDERING) {
//					if (checkStatementOrdering(EcoreUtil.copy(problemDomain), diffSpaceTimeMapExprList, edge, dim) != STATUS.NOTSATISFIED) {
//						return true;
//					}
//				} else if (dimType == DIM_TYPE.PARALLEL) {
//					if (sameProcessor(EcoreUtil.copy(problemDomain), diffSpaceTimeMapExprList, edge, dim) == STATUS.INVALID) {
//						return true;
//					}
//				} else {
//					if (checkCausality(EcoreUtil.copy(problemDomain), diffSpaceTimeMapExprList, edge, dim) != STATUS.NOTSATISFIED) {
//						return true;
//					}
//				}
//			}
//		} else {
//			return true;
//		}
//
//		return false;
//	}
//
//	private boolean checkStatementOrdering(String s1, String s2) {
//
//		for (PartialStatementOrder ordering : targetMapping_.getStatementOrdering()) {
//			String statement1 = ordering.getPredecessor().getVariable().getName();
//			String statement2 = ordering.getSuccessor().getVariable().getName();
//
//			if ((statement2.compareTo(s1) == 0) && (statement1.compareTo(s2) == 0)) {
//				return true;
//			}
//		}
//
//		return false;
//	}
//
//	private STATUS checkStatementOrdering(Domain problemDomain, List<AffineExpression> diffSpaceTimeMapExprList, PRDGEdge edge, int dim) {
//		STATUS satisfied = STATUS.INVALID;
//
//		//f(z) - f(z') > 0
//		IntConstraint affineForm = constraint(diffSpaceTimeMapExprList.get(dim), constant(0), ComparisonOperator.GT);
//
//		if (satisfies(problemDomain.getPMdomain(), affineForm)) {
//			satisfied = STATUS.SATISFIED;
//		} else {
//			affineForm.setComparisonOperator(ComparisonOperator.GE);
//			if (satisfies(problemDomain.getPMdomain(), affineForm)) {
//				satisfied = STATUS.NOTSATISFIED;
//			}
//		}
//
//		if (satisfied == STATUS.INVALID) {
//			errors_.add(new CausalityConditionError(TYPE.ORDERING, edge, dim));
//		}
//
//		return satisfied;
//	}
//
//	protected STATUS sameProcessor(Domain problemDomain, List<AffineExpression> diffSpaceTimeMapExprList, PRDGEdge edge, int dim) {
//		STATUS satisfied = STATUS.INVALID;
//
//		for (int i = 0; i < dim; ++i) {
//			IntConstraint equalityConstraint = constraint(diffSpaceTimeMapExprList.get(i), constant(0), ComparisonOperator.EQ);
//			problemDomain.getPMdomain().addConstraint(equalityConstraint);
//		}
//
//		IntConstraint affineForm = constraint(diffSpaceTimeMapExprList.get(dim), constant(0), ComparisonOperator.GE);
//
//		//check f(z) - f(z') >= 0 
//		if (satisfies(problemDomain.getPMdomain(), affineForm)) {//if empty
//			affineForm = mul(affineForm, -1);	//f(z) - f(z') <= 0
//			// affineForm = negate(affineForm);
//			affineForm.setComparisonOperator(ComparisonOperator.GE); //why negate again ??
//			if (satisfies(problemDomain.getPMdomain(), affineForm)) {
//				satisfied = STATUS.NOTSATISFIED;
//			}
//		}
//
//		if (satisfied == STATUS.INVALID) {
//			errors_.add(new CausalityConditionError(TYPE.PROCESSOR, edge, dim));
//		}
//
//		return satisfied;
//	}
//
//	protected STATUS checkCausality(Domain problemDomain, List<AffineExpression> diffSpaceTimeMapExprList, PRDGEdge edge, int dim) {
//		STATUS satisfied = STATUS.INVALID;
//
//		for (int i = 0; i < dim; ++i) {
//			IntConstraint equalityConstraint = constraint((diffSpaceTimeMapExprList.get(i)), constant(0), ComparisonOperator.EQ);
//			problemDomain.getPMdomain().addConstraint(equalityConstraint);
//		}
//
//		IntConstraint affineForm = constraint((diffSpaceTimeMapExprList.get(dim)), constant(0), ComparisonOperator.GT);
//
//		if (satisfies(problemDomain.getPMdomain(), affineForm)) {
//			satisfied = STATUS.SATISFIED;
//		} else {
//			affineForm.setComparisonOperator(ComparisonOperator.GE);
//			if (satisfies(problemDomain.getPMdomain(), affineForm)) {
//				satisfied = STATUS.NOTSATISFIED;
//			}
//		}
//
//		if (satisfied == STATUS.INVALID) {
//			errors_.add(new CausalityConditionError(TYPE.TIME, edge, dim));
//		}
//
//		return satisfied;
//	}
//
//	protected void memoryMapCheck() {
//
//		for (MemorySpace memorySpace : targetMapping_.getMemorySpaces()) {
//
//			// if (isValidMemorySpace(memorySpace)) {
//			for (MemoryMap memoryMap : memorySpace.getMemoryMaps()) {
//
//				verifyMemoryMap(memoryMap);	//no shared space
//				verifyMemoryMap(memoryMap, memorySpace);	//with shared space
//			}
//			// }
//		}
//	}
//
//	/*
//	 * All memory maps in a memory space should be same
//	 */
//	private boolean isValidMemorySpace(MemorySpace memorySpace) {
//
//		if (memorySpace.getMemoryMaps().size() > 0) {
//
//			MemoryMap memoryMap = memorySpace.getMemoryMaps().get(0);
//
//			for (MemoryMap nextMemoryMap : memorySpace.getMemoryMaps().subList(1, memorySpace.getMemoryMaps().size())) {
//				if (!memoryMap.getMapping().equivalence(nextMemoryMap.getMapping())) {
//					return false;
//				}
//			}
//		}
//		return true;
//	}
//
//	private void verifyMemoryMap(MemoryMap memoryMap, MemorySpace memorySpace) {
//
//		for (MemoryMap nextMemoryMap : memorySpace.getMemoryMaps()) {
//			if (!memoryMap.equals(nextMemoryMap)) {
//				verifyMemoryMap(memoryMap, nextMemoryMap);
//			}
//		}
//	}
//
//	private void verifyMemoryMap(MemoryMap memoryMap, MemoryMap nextMemoryMap) {
//
//		for (PRDGEdge edge : prdg_.getNode(memoryMap.getVariable().getName()).getSources()) {
//
//			if (!isValidMemoryMap(nextMemoryMap, memoryMap, edge)) {
//				errors_.add(new MemoryMapError(TYPE.MEMORY, edge, memoryMap));
//			}
//		}
//	}
//
//	protected void verifyMemoryMap(MemoryMap memoryMap) {
//
//		if (memoryMap.getMapping().getIndices().size() != memoryMap.getMapping().getDimRHS()) {
//
//			if (!hasWriteConflicts(memoryMap)) {
//				//get the PRDG edges whose destination is the current node
//				for (PRDGEdge edge : prdg_.getNode(memoryMap.getVariable().getName()).getSources()) {
//
//					if (!isValidMemoryMap(memoryMap, edge)) {
//						errors_.add(new MemoryMapError(TYPE.MEMORY, edge, memoryMap));
//					}
//				}
//			} else {
//				errors_.add(new WriteConflictsError(TYPE.MEMORY, prdg_.getNode(memoryMap.getVariable().getName()), memoryMap));
//			}
//		}
//
//	}
//
//	/**
//	 * check the whether two memory accesses access the same memory location 
//	 * at the same time (write conflict)
//	 * @param memoryMap
//	 * @return
//	 */
//	protected boolean hasWriteConflicts(MemoryMap memoryMap) {
//		boolean has_write_conflicts = false;
//		
//		PRDGNode node = prdg_.getNode(memoryMap.getVariable().getName());
//		ParameterDomain paramDomain = affineSystem_.getParameters();
//
//		//construct the domain {dom, dom'}
//		Domain problemDomain = DomainOperations.mergeDomains(userFact_.createDomain(EcoreUtil.copy(node.getDomain())),
//				userFact_.createDomain(EcoreUtil.copy(node.getDomain())));
//		//the index for z'
//		List<Variable> indicesList = problemDomain.getIndices().subList(node.getDomain().getNbIndices(), problemDomain.getNIndices());
//		//create list of affine expressions that are the same as the list of the indices
//		List<AffineExpression> identity = new ArrayList<AffineExpression>(indicesList.size());
//		for (Variable v : indicesList) {
//			identity.add(affine(term(1, v)));
//		}
//
//		//create an idetity memory map
//		AffineFunction memory_map2 = memoryMap.getMapping().compose(userFact_.createAffineFunction(paramDomain.getParams(), indicesList, identity));
//		
//		
//		//z' = f(z)
//		DomainOperations.addConstraintsRelatingTwoSetsOfIndices(problemDomain, new Constraint(memoryMap.getMapping(), memory_map2, ComparisonOperator.EQ));
//
//		//get the scheduling function for the current node
//		SpaceTimeMap stmap = targetMapping_.getSpaceTimeMap(affineSystem_.getVariableDeclaration(node.getName()));
//
//		//why loop over every indices
//		for (int i = 0; i < indicesList.size(); ++i) { // loop through each index of z'
////			String str = node.getDomain().getDimensions().getIndices().get(i) + " - " + indicesList.get(i) + " > 0 ";
//			/*
//			 * condition f(z) - f(z') > 0
//			 * at dimension i, f(z) = stmap(i) = az + b
//			 * a(z) + b - az' -b = a(z - z') > 0
//			 * z - z' > 0
//			 */
//			IntConstraint constraint = constraint(
//							affine(term(1, node.getDomain().getDimensions().getIndices().get(i))), //z
//							affine(term(1, indicesList.get(i))), //z'
//						ComparisonOperator.GT);
//
//			Domain new_domain = addConstraintToDomain(problemDomain, constraint);
//			if (new_domain != null) {
//				if (true == hasSameSchedule(paramDomain, new_domain, indicesList, stmap)) {
//					has_write_conflicts = true;
//					break;
//				}
//			}
//
////			str = node.getDomain().getIndices().get(i) + " - " + indicesList.get(i) + " = 0 ";
//			constraint = constraint(
//					affine(term(1, node.getDomain().getDimensions().getIndices().get(i))), 
//					affine(term(1, indicesList.get(i))), 
//				ComparisonOperator.EQ);
//			problemDomain = addConstraintToDomain(problemDomain, constraint);
//
//			if (problemDomain == null) {
//				throw new RuntimeException("checkWriteConflicts:: when extended domain is null");
//			}
//		}
//
//		return has_write_conflicts;
//	}
//
//	/**
//	 * check the emptiness of the domain with a constraint
//	 * @param domain
//	 * @param constr
//	 * @return
//	 */
//	private Domain addConstraintToDomain(Domain domain, IntConstraint constr) {
//		Domain newDomain = EcoreUtil.copy(domain);
//
//		for (IntConstraintSystem polyhedron : newDomain.getPMdomain().getPolyhedra()) {
//			polyhedron.getConstraints().add(EcoreUtil.copy(constr));
//		}
//
//		if (newDomain.isEmpty()) {
//			return null;
//		} else {
//			return newDomain;
//		}
//	}
//
//	// same time
//	private boolean hasSameSchedule(ParameterDomain paramDomain, Domain domain, List<Variable> indexList, SpaceTimeMap spaceTimeMap) {
//		boolean same = false;
//
//		List<AffineExpression> identity = new ArrayList<AffineExpression>(indexList.size());
//		for (Variable v : indexList) {
//			identity.add(affine(term(1, v)));
//		}
//		
//		AffineFunction spaceTimeMap2 = spaceTimeMap.getMapping().compose(userFact_.createAffineFunction(paramDomain.getParams(), indexList, identity));
//		List<AffineExpression> expressionList = getAffineExpressionList(domain, spaceTimeMap.getMapping(), spaceTimeMap2);
//
//		for (int i = 0; i < spaceTimeMap.getMapping().getDimRHS(); ++i) {
//			IntConstraint constr = constraint(expressionList.get(i), constant(0), ComparisonOperator.EQ);
//			domain = addConstraintToDomain(domain, constr);
//
//			if (domain == null) {
//				if (spaceTimeMap.getType(i) == DIM_TYPE.SEQUENTIAL) {
//					same = false;
//					break;
//				} else if (spaceTimeMap.getType(i) == DIM_TYPE.PARALLEL) {
//					same = true;
//					break;
//				}
//			}
//		}
//
//		return same;
//	}
//
//	//legality of memory mapping specification with shared space
//	private boolean isValidMemoryMap(MemoryMap nextMemoryMap, MemoryMap memoryMap, PRDGEdge edge) {
//
//		if (DEBUG_) {
//			System.out.println(edge.getSource().getName() + "->" + edge.getDestination().getName() + " : " + edge.getFunction().getMapping());
//		}
//
//		PRDGNode overWriteNode = prdg_.getNode(nextMemoryMap.getVariable().getName());
//
//		SpaceTimeMap overWriteSpaceTimeMap = getSpaceTimeMap(overWriteNode);
//		SpaceTimeMap srcSpaceTimeMap = getSpaceTimeMap(edge.getSource());
//		SpaceTimeMap dstSpaceTimeMap = getSpaceTimeMap(edge.getDestination());
//
//		if ((srcSpaceTimeMap == null) || (dstSpaceTimeMap == null) || (overWriteSpaceTimeMap == null)) {
//			return false;
//		}
//
//		Domain problemDomain = DomainOperations.mergeDomains(userFact_.createDomain(EcoreUtil.copy(overWriteNode.getDomain())),
//				userFact_.createDomain(EcoreUtil.copy(edge.getDomain())));
//
//		AffineFunction depedenceFunction = userFact_.createAffineFunction(EcoreUtil.copy(edge.getFunction().getMapping()));
//
//		DomainOperations.addConstraintsRelatingTwoSetsOfIndices(problemDomain,
//				new Constraint(nextMemoryMap.getMapping(), memoryMap.getMapping().compose(depedenceFunction), ComparisonOperator.EQ));
//
//		boolean isProblemDomainEmpty = true;
//
//		if (!problemDomain.isEmpty()) {
//			List<AffineExpression> diffSpaceTimeMapExprList = getAffineExpressionList(problemDomain, overWriteSpaceTimeMap.getMapping(), dstSpaceTimeMap
//					.getMapping().compose(depedenceFunction));
//
//			for (int i = 0; i < overWriteSpaceTimeMap.getMapping().getDimRHS(); ++i) {
//
//				if ((overWriteSpaceTimeMap.getType(i) == DIM_TYPE.SEQUENTIAL) || (overWriteSpaceTimeMap.getType(i) == DIM_TYPE.ORDERING)) {
//					//phi_c(z) - phi_b(f(z)) > 0
//					IntConstraint constr = constraint(diffSpaceTimeMapExprList.get(i), constant(0), ComparisonOperator.GT);
//
//					if (!isEmpty(problemDomain.getPMdomain(), constr)) {
//						problemDomain.getPMdomain().addConstraint(constr);
//						isProblemDomainEmpty = false;
//						break;
//					} else {
//						constr = constraint(diffSpaceTimeMapExprList.get(i), constant(0), ComparisonOperator.GE);
//
//						if (!isEmpty(problemDomain.getPMdomain(), constr)) {
//							problemDomain.getPMdomain().addConstraint(constr);
//						} else {
//							break;
//						}
//					}
//
//				} else if (overWriteSpaceTimeMap.getType(i) == DIM_TYPE.PARALLEL) {
//					IntConstraint constr = constraint(diffSpaceTimeMapExprList.get(i), constant(0), ComparisonOperator.EQ);
//
//					if (!isEmpty(problemDomain.getPMdomain(), constr)) {
//						problemDomain.getPMdomain().addConstraint(constr);
//					} else {
//						break;
//					}
//				}
//			}
//
//			if (isProblemDomainEmpty) {
//				if (checkStatementOrdering(overWriteNode.getName(), edge.getSource().getName())) {
//					isProblemDomainEmpty = false;
//				}
//			}
//		}// if(!problemDomain.isEmpty())
//
//		if (!isProblemDomainEmpty) {
//
//			List<AffineExpression> diffSpaceTimeMapExprList = getAffineExpressionList(problemDomain, overWriteSpaceTimeMap.getMapping(),
//					srcSpaceTimeMap.getMapping());
//
//			for (int i = 0; i < overWriteSpaceTimeMap.getMapping().getDimRHS(); ++i) {
//
//				if ((overWriteSpaceTimeMap.getType(i) == DIM_TYPE.SEQUENTIAL) || (overWriteSpaceTimeMap.getType(i) == DIM_TYPE.ORDERING)) {
//
//					IntConstraint affineForm = constraint(diffSpaceTimeMapExprList.get(i), constant(0), ComparisonOperator.GT);
//
//					if (satisfies(problemDomain.getPMdomain(), affineForm)) {
//						return true;
//					} else {
//						affineForm = constraint(diffSpaceTimeMapExprList.get(i), constant(0), ComparisonOperator.GE);
//
//						if (satisfies(problemDomain.getPMdomain(), affineForm)) {
//							problemDomain.getPMdomain().addConstraint(affineForm);
//						} else {
//							return false;
//						}
//					}
//
//				} else if (overWriteSpaceTimeMap.getType(i) == DIM_TYPE.PARALLEL) {
//
//					IntConstraint affineForm = constraint(diffSpaceTimeMapExprList.get(i), constant(0), ComparisonOperator.EQ);
//
//					if (satisfies(problemDomain.getPMdomain(), affineForm)) {
//						problemDomain.getPMdomain().addConstraint(affineForm);
//					} else {
//						return false;
//					}
//
//					if (i == (dstSpaceTimeMap.getDimTypes().size() - 1)) {
//						return false;
//					}
//				}
//			}// if(!isProblemDomainEmpty)
//		}
//
//		return true;
//	}
//
//	//legality of the memory mapping with no shared space
//	private boolean isValidMemoryMap(MemoryMap memoryMap, PRDGEdge edge) {
//
//		if (DEBUG_) {
//			System.out.println(edge.getSource().getName() + "->" + edge.getDestination().getName() + " : " + edge.getFunction().getMapping() + "domain: " + edge.getDomain());
//		}
//
//		SpaceTimeMap srcSpaceTimeMap = getSpaceTimeMap(edge.getSource());
//		SpaceTimeMap dstSpaceTimeMap = getSpaceTimeMap(edge.getDestination());
//
//		if ((srcSpaceTimeMap == null) || (dstSpaceTimeMap == null)) {
//			return false;
//		}
//
//		//construct domain {destDom, edgeDom}
//		Domain problemDomain = DomainOperations.mergeDomains(userFact_.createDomain(EcoreUtil.copy(edge.getDestination().getDomain())),
//				userFact_.createDomain(EcoreUtil.copy(edge.getDomain())));
//		//get the dependence function
//		AffineFunction depedenceFunction = userFact_.createAffineFunction(EcoreUtil.copy(edge.getFunction().getMapping()));
//
//		//m(z) = m(f(z'))
//		DomainOperations.addConstraintsRelatingTwoSetsOfIndices(problemDomain,
//				new Constraint(memoryMap.getMapping(), memoryMap.getMapping().compose(depedenceFunction), ComparisonOperator.EQ));
//
//		boolean isProblemDomainEmpty = true;
//
//		/*
//		 * Construct domain:{z, z'| z in D(dst), z' in D(edge), m(f(z')) = m(z), theta(z) >  theta(f(z'))}
//		 */
//		//theta(z) - theta(f(z'))
//		List<AffineExpression> diffSpaceTimeMapExprList = getAffineExpressionList(problemDomain, dstSpaceTimeMap.getMapping(), dstSpaceTimeMap.getMapping()
//				.compose(depedenceFunction));
//		
//		List<Domain> overWritingDomainList = new LinkedList<Domain>();
//		for(int i = 0; i < dstSpaceTimeMap.getMapping().getDimRHS(); ++i){
//			if((dstSpaceTimeMap.getType(i) == DIM_TYPE.SEQUENTIAL) || (dstSpaceTimeMap.getType(i) == DIM_TYPE.ORDERING)){
//				Domain tempDom = userFact_.createDomain(EcoreUtil.copy(problemDomain.getPMdomain()));
//				for(int j = 0; j < i; ++j){
//					//add constraint theta_j(z) - theta_j(f(z')) = 0
//					IntConstraint constr = constraint(diffSpaceTimeMapExprList.get(j), constant(0), ComparisonOperator.EQ);
//					tempDom.getPMdomain().addConstraint(constr);
//				}
//				
//				//add constraint theta_i(z) - theta_i(f(z')) > 0
//				IntConstraint dimIconstraint = constraint(diffSpaceTimeMapExprList.get(i), constant(0), ComparisonOperator.GT);
//				tempDom.getPMdomain().addConstraint(dimIconstraint);
//				
//				overWritingDomainList.add(tempDom);
//			}
//		}
//		
//		//check emptyness for each dimension on the list of overwritting domain
//		List<AffineExpression> diffDstSrcSpaceTime = getAffineExpressionList(problemDomain, dstSpaceTimeMap.getMapping(), srcSpaceTimeMap.getMapping());	
//		for(int i = 0; i < dstSpaceTimeMap.getMapping().getDimRHS(); ++i){
//			if((dstSpaceTimeMap.getType(i) == DIM_TYPE.SEQUENTIAL) || (dstSpaceTimeMap.getType(i) == DIM_TYPE.ORDERING)){
//				//construct the constraints theta_src_j(z) = theta_dst_j(z)
//				List<IntConstraint> constraintList = new LinkedList<IntConstraint>();
//				for(int j = 0; j < i; ++j){
//					IntConstraint constr = constraint(diffDstSrcSpaceTime.get(j), constant(0), ComparisonOperator.EQ);
//					constraintList.add(constr);
//				}
//				//add constraint theta_dst_i(z) > theta_src_i(z)
//				IntConstraint dimIconstraint = constraint(diffDstSrcSpaceTime.get(i), constant(0), ComparisonOperator.GT);
//				constraintList.add(dimIconstraint);
//				
//				//for each possible overwriting domain, check the emptyness by intersect with the constraint
//				for(int j = 0; j < overWritingDomainList.size(); ++j){
//					Domain tempDom = userFact_.createDomain(EcoreUtil.copy(overWritingDomainList.get(j).getPMdomain()));
//					if(!EmptynessCheck(tempDom, constraintList)){
//						return false;
//					}
//				}
//			}
//		}
//		
//		/*if (!problemDomain.isEmpty()) {
//			//phi(z) - phi(f(z))
//			List<AffineExpression> diffSpaceTimeMapExprList = getAffineExpressionList(problemDomain, dstSpaceTimeMap.getMapping(), dstSpaceTimeMap.getMapping()
//					.compose(depedenceFunction));
//			
//			System.out.println("diff space time map list: " + diffSpaceTimeMapExprList.toString());
//
//			//for each dimension
//			for (int i = 0; i < dstSpaceTimeMap.getMapping().getDimRHS(); ++i) {
//
//				if (dstSpaceTimeMap.getType(i) == DIM_TYPE.SEQUENTIAL) {
//					
//					//phi(z) - phi(f(z)) > 0
//					IntConstraint constr = constraint(diffSpaceTimeMapExprList.get(i), constant(0), ComparisonOperator.GT);
//					System.out.println("The adding constraint: " + constr.toString());
//					if (!isEmpty(problemDomain.getPMdomain(), constr)) {
//						problemDomain.getPMdomain().addConstraint(constr);
//						System.out.println("greater, new problem domain: " + problemDomain);
//						isProblemDomainEmpty = false;
//						break;
//					} else {
//						constr = constraint(diffSpaceTimeMapExprList.get(i), constant(0), ComparisonOperator.GE);
//						
//						if (!isEmpty(problemDomain.getPMdomain(), constr)) {
//							problemDomain.getPMdomain().addConstraint(constr);
//							System.out.println("GE, new problem domain: " + problemDomain);
//						} else {
//							break;
//						}
//					}
//
//				} else if (dstSpaceTimeMap.getType(i) == DIM_TYPE.PARALLEL) {
//					IntConstraint constr = constraint(diffSpaceTimeMapExprList.get(i), constant(0), ComparisonOperator.EQ);
//
//					if (!isEmpty(problemDomain.getPMdomain(), constr)) {
//						problemDomain.getPMdomain().addConstraint(constr);
//					} else {
//						break;
//					}
//				}
//			}// if(!problemDomain.isEmpty())
//		}*/
//		//System.out.println("problem domain: " + problemDomain);
//		//Here is wrong the dst should execute before the src
//		/*if (!isProblemDomainEmpty) {
//
//			List<AffineExpression> diffSpaceTimeMapExprList = getAffineExpressionList(problemDomain, dstSpaceTimeMap.getMapping(), srcSpaceTimeMap.getMapping());	
//			
//			for (int i = 0; i < dstSpaceTimeMap.getMapping().getDimRHS(); ++i) {
//
//				if ((dstSpaceTimeMap.getType(i) == DIM_TYPE.SEQUENTIAL) || (dstSpaceTimeMap.getType(i) == DIM_TYPE.ORDERING)) {
//					
//					IntConstraint affineForm = constraint(diffSpaceTimeMapExprList.get(i), constant(0), ComparisonOperator.GT);
//					System.out.println("affine constraint for dimension " + i + ": " + affineForm.toString());
//					if (satisfies(problemDomain.getPMdomain(), affineForm)) {
//						System.out.println("statisfied at dimension " + i);
//						return true;
//					} else {
//						affineForm = constraint(diffSpaceTimeMapExprList.get(i), constant(0), ComparisonOperator.GE);
//
//						if (satisfies(problemDomain.getPMdomain(), affineForm)) {
//							problemDomain.getPMdomain().addConstraint(affineForm);
//							System.out.println("not statisfied, new domain: " + problemDomain);
//						} else {
//							return false;
//						}
//					}
//
//				} else if (dstSpaceTimeMap.getType(i) == DIM_TYPE.PARALLEL) {
//
//					IntConstraint affineForm = constraint(diffSpaceTimeMapExprList.get(i), constant(0), ComparisonOperator.EQ);
//
//					if (satisfies(problemDomain.getPMdomain(), affineForm)) {
//						problemDomain.getPMdomain().addConstraint(affineForm);
//					} else {
//						return false;
//					}
//
//					if (i == (dstSpaceTimeMap.getDimTypes().size() - 1)) {
//						return false;
//					}
//				}
//			}// if(!isProblemDomainEmpty)
//		}*/
//
//		return true;
//	}
//
//	protected boolean isEmpty(org.polymodel.Domain domain, IntConstraint affineForm) {
//
//		org.polymodel.Domain tempDomain = EcoreUtil.copy(domain);
//		tempDomain.addConstraint(affineForm);
//
//		return tempDomain.isEmpty();
//	}
//	
//	
//	protected boolean EmptynessCheck(Domain domain, List<IntConstraint> constraintList){
//		org.polymodel.Domain tempDomain = EcoreUtil.copy(domain.getPMdomain());
//		for(int i = 0; i < constraintList.size(); i++){
//			tempDomain.addConstraint(negate(constraintList.get(i).copy()));
//		}
//		return tempDomain.isEmpty();
//	}
//
//	
//	/*
//	 * check wether the negiation of the constraint (IntConstraint) is empty on the 
//	 * domain  (domain)
//	 * return true if the domain it is empty, otherwise return fasle
//	 */
//	protected boolean satisfies(org.polymodel.Domain domain, IntConstraint affineForm) {
//
//		org.polymodel.Domain tempDomain = EcoreUtil.copy(domain);
//		tempDomain.addConstraint(negate(affineForm));
//
//		return tempDomain.isEmpty();
//	}
//	
//	
//	/**
//	 * construct a new domain that contains {src, dst, z = f(z)}
//	 * @param edge
//	 * @return
//	 */
//	private Domain getProblemDomain(PRDGEdge edge) {
//
//		org.polymodel.Domain srcDomain = edge.getDomain();
//		org.polymodel.Domain dstDomain = null;
//
//		AffineFunction depedenceFunction = userFact_.createAffineFunction(EcoreUtil.copy(edge.getFunction().getMapping()));
//		AffineFunction dstFunction = null;
//		
//		if (null != getSpaceTimeMap(edge.getDestination())) {
//			dstDomain = edge.getDestination().getDomain();
//			dstFunction = PolyhedralIRUtility.createIdentityFunction(userFact_.createDomain(EcoreUtil.copy(edge.getDestination().getDomain())));
//		} else {
//			dstDomain = getReductionExpressionDomain(edge.getDestination());
//			dstFunction = getProjectionFunction(edge.getDestination());
//		}
//
//		Domain problemDomain = DomainOperations.mergeDomains(userFact_.createDomain(EcoreUtil.copy(srcDomain)),
//				userFact_.createDomain(EcoreUtil.copy(dstDomain)));
//		DomainOperations.addConstraintsRelatingTwoSetsOfIndices(problemDomain, new Constraint(depedenceFunction, dstFunction, ComparisonOperator.EQ));
//
//		return problemDomain;
//	}
//
//	private AffineFunction getProjectionFunction(PRDGNode reduceVarNode) {
//		PRDGNode reduceTempNode = reduceVarNode.getDestinations().get(0).getDestination();
//		EdgeFunction projectionFunction = reduceTempNode.getDestinations().get(0).getFunction();
//
//		return userFact_.createAffineFunction(EcoreUtil.copy(projectionFunction.getMapping()));
//	}
//
//	private org.polymodel.Domain getReductionExpressionDomain(PRDGNode reduceNode) {
//		PRDGNode reduceTemp = reduceNode.getDestinations().get(0).getDestination();
//		PRDGNode reduceExpression = reduceTemp.getDestinations().get(0).getDestination();
//
//		return reduceExpression.getDomain();
//	}
//
//	/*
//	 * 
//	 * */
//	private List<AffineExpression> getDiffSpaceTimeMapExpressionList(Domain domain, SpaceTimeMap srcSpaceTimeMap, SpaceTimeMap dstSpaceTimeMap, PRDGEdge edge) {
//
//		AffineFunction srcAffineFunction = null;
//
//		if (edge.getSource().getDomain().getNbIndices() != srcSpaceTimeMap.getMapping().getIndices().size()) {//if the mapping is specified for the reduction body
//
//			PRDGNode reduceVarNode = getReductionVariableNode(edge.getSource());
//			AffineFunction projectionFunction = getProjectionFunction(reduceVarNode);		
//			srcAffineFunction = srcSpaceTimeMap.getMapping().compose(projectionFunction);		
//		} else {
//			srcAffineFunction = srcSpaceTimeMap.getMapping();
//		}
//
//		return getAffineExpressionList(domain, srcAffineFunction, dstSpaceTimeMap.getMapping());
//
//	}
//
//	/*
//	 * check if the variable(name) is one the variables in the original system
//	 */
//	private boolean isVariable(String name) {
//
//		for (VariableDeclaration var : affineSystem_.getInputs()) {
//			if (var.getVarID().getName().compareTo(name) == 0) {
//				return true;
//			}
//		}
//		for (VariableDeclaration var : affineSystem_.getLocals()) {
//			if (var.getVarID().getName().compareTo(name) == 0) {
//				return true;
//			}
//		}
//		for (VariableDeclaration var : affineSystem_.getOutputs()) {
//			if (var.getVarID().getName().compareTo(name) == 0) {
//				return true;
//			}
//		}
//
//		return false;
//	}
//
//	private SpaceTimeMap getSpaceTimeMap(PRDGNode node) {
//
//		if (isVariable(node.getName())) {//get the spacetime map for the node if it is not a reduce body node
//			SpaceTimeMap spaceTimeMap = targetMapping_.getSpaceTimeMap(affineSystem_.getVariableDeclaration(node.getName()));
//
//			if (node.getDomain().getNbIndices() == spaceTimeMap.getMapping().getIndices().size()) {
//				return spaceTimeMap;
//			} else {
//				// this exception should be relaxed by distinguishing schedules
//				// given for reduction body TODO
//				// throw new
//				// RuntimeException("Number of indices of the variable "+node.getName()+" does not match that of the space time mapping given.");
//				return null;
//			}
//		} else {
//			if (node.getSources().size() == 1) {
//
//				if (isVariable(node.getSources().get(0).getSource().getName())) {
//					return null;
//				} else {
//					PRDGNode reduceTemp = node.getSources().get(0).getSource();
//					SpaceTimeMap spaceTimeMap = targetMapping_.getSpaceTimeMap(affineSystem_.getVariableDeclaration(reduceTemp.getSources().get(0).getSource()
//							.getName()));
//
//					if (node.getDomain().getNbIndices() == spaceTimeMap.getMapping().getIndices().size()) {
//						return spaceTimeMap;
//					} else {
//						return null;
//					}
//				}
//			} else {
//				throw new RuntimeException("Unexpected case. Not a variable or reduction body.");
//			}
//		}
//	}
//
//	private PRDGNode getReductionBodyNode(PRDGNode reduceVarNode) {
//		PRDGNode reduceTempNode = reduceVarNode.getDestinations().get(0).getDestination();
//		return reduceTempNode.getDestinations().get(0).getDestination();
//	}
//
//	private PRDGNode getReductionVariableNode(PRDGNode reduceBodyNode) {
//		PRDGNode reduceTempNode = reduceBodyNode.getSources().get(0).getSource();
//		return reduceTempNode.getSources().get(0).getSource();
//	}
//
//	/*
//	 * construct the causality condition expression for each dimension
//	 * f1(i) -  f2(i)
//	 */
//	public List<AffineExpression> getAffineExpressionList(Domain inputDom, AffineFunction f1, AffineFunction f2) {
//		// check on inputs
//		if (f1.getDimRHS() != f2.getDimRHS()) {
//			throw new RuntimeException("Dimensionality of RHS of the two functions given must be equal.");
//		}
//		if (f1.getIndices().size() + f2.getIndices().size() != inputDom.getNIndices()) {
//			throw new RuntimeException("Number of indices used in two functions given must match the number of indices in input domain.");
//		}
//
//		// create two functions to relate indices on input domain with the two
//		// functions given
//		// Input domain has dimensions for P + z + z', so we need :
//		// fa(z+z') = z and fb(z+z') = z', so that it can be composed with the
//		// two functions given, which is :
//		// f1(z) = ? and f2(z') = ?
//
//		// First function, sublist of 0 to numIndices(f1) -- sublist is
//		// inclusive to exclusive
//		List<Variable> sublistA = inputDom.getIndices().subList(0, f1.getIndices().size());
//		List<AffineExpression> identity = new ArrayList<AffineExpression>(sublistA.size());
//		for (Variable v : sublistA) {
//			identity.add(affine(term(v)));
//		}
//		AffineFunction fa = userFact_.createAffineFunction(inputDom.getParams(), inputDom.getIndices(), identity);
//
//		// Second function, sublist of numIndices(f1) to numIndices(f2)
//		List<String> sublistB = inputDom.getIndexNames().subList(f1.getIndices().size(), f1.getIndices().size() + f2.getIndices().size());
//		AffineFunction fb = PolyhedralIRUtility.parseAffineFunction(inputDom.getParams(), inputDom.getIndices(), sublistB);
//
//		AffineFunction domToZ = f1.compose(fa);
//		AffineFunction domToZp = f2.compose(fb);
//
//		// Create IntConstraint for each dimension on the RHS
//		// relate the result of the compose functions to each other using the
//		// given operator
//		List<AffineExpression> exp_list = new LinkedList<AffineExpression>();
//		for (int d = 0; d < f1.getDimRHS(); d++) {
//			exp_list.add(affine(sub(domToZ.getExpressions().get(d), domToZp.getExpressions().get(d))));
//		}
//
//		return exp_list;
//	}
//
//	/*
//	 * remove edges in which destination is an input variables.
//	 */
//	protected PRDG prunePrdg(PRDG prdg) {
//		EList<PRDGNode> new_list = new BasicEList<PRDGNode>();
//		
//		System.out.println("information of the prdgnode");
//		for(PRDGNode tnode : prdg.getNodes()){
//			System.out.println("PRDGNode : " + tnode.getName());
//		}
//		System.out.println("the dependence edges");
//		for(PRDGEdge edge : prdg.getEdges()){
//			System.out.println("dependence from " + edge.getSource().getName()  +  " to " + edge.getDestination().getName());
//		}
//
//		/*for (VariableDeclaration input : affineSystem_.getInputs()) {
//			PRDGNode node = prdg.getNode(input.getName());
//			pruneEdgeList(prdg, node);
//			new_list.add(node);
//		}*/
//
//		prdg.getNodes().removeAll(new_list);
//
//		return prdg;
//	}
//
//	/*
//	 * Remove edges where producers(To) are input variables(node)
//	 */
//	protected void pruneEdgeList(PRDG prdg, PRDGNode node) {
//		EList<PRDGEdge> new_list = new BasicEList<PRDGEdge>();
//
//		for (PRDGEdge edge : prdg.getEdges()) {
//			if (edge.getDestination().equals(node)) {
//				new_list.add(edge);
//			}
//		}
//
//		prdg.getEdges().removeAll(new_list);
//	}

}