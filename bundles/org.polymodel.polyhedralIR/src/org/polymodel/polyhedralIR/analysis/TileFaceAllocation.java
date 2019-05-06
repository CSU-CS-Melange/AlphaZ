//This class is obsolete

//package org.polymodel.polyhedralIR.analysis;
//
//import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
//import static org.polymodel.algebra.factory.IntExpressionBuilder.term;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import org.eclipse.emf.common.util.BasicEList;
//import org.eclipse.emf.common.util.EList;
//import org.polymodel.algebra.IntExpression;
//import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
//import org.polymodel.matrix.operations.MatrixOperations;
//import org.polymodel.polyhedralIR.AffineFunction;
//import org.polymodel.polyhedralIR.AffineSystem;
//import org.polymodel.polyhedralIR.StandardEquation;
//import org.polymodel.polyhedralIR.UseEquation;
//import org.polymodel.polyhedralIR.VariableDeclaration;
//import org.polymodel.polyhedralIR.expression.DependenceExpression;
//import org.polymodel.polyhedralIR.expression.VariableExpression;
//import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
//import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
//import org.polymodel.polyhedralIR.impl.PolyhedralIRInheritedDepthFirstVisitorImpl;
//import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
//import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
//import org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap;
//import org.polymodel.polyhedralIR.targetMapping.StatementPartialOrder;
//import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
//import org.polymodel.polyhedralIR.transformation.Normalize;
///**
// * Assumes system after applying STmap as CoB.
// * 
// * @author yuki
// *
// */
//public class TileFaceAllocation implements IMemoryAllocation {
//	
//	private static final boolean DEBUG = true;
//	
//	protected static PolyhedralIRUserFactory _fact = PolyhedralIRUserFactory.eINSTANCE;
//	
//	protected final AffineSystem targetSystem;
//	protected Map<VariableDeclaration, AllocationsPerVariable> allocations = new HashMap<VariableDeclaration, AllocationsPerVariable>();
//	
//	//functions to remove ordering dimensions from dependencies
//	protected AffineFunction rmOrderingFuncRHS;
//	protected AffineFunction rmOrderingFuncLHS;
//	
//	protected TileFaceAllocation(AffineSystem targetSystem) {
//		this.targetSystem = targetSystem;
//	}
//	
//	public static TileFaceAllocation findMemoryAllocation(AffineSystem system) {
//		TileFaceAllocation tfa = new TileFaceAllocation(system);
//		
//		tfa.find();
//		
//		return tfa;
//	}
//	
//	public Set<VariableDeclaration> getKeySet() {
//		return allocations.keySet();
//	}
//	
//	public AllocationsPerVariable getAllocations(VariableDeclaration var) {
//		return allocations.get(var);
//	}
//	
//	public AffineFunction removeOrderingDimensions(AffineFunction dep) {
//		return rmOrderingFuncRHS.compose(dep.compose(rmOrderingFuncLHS));
//	}
//	
//	
//	protected void find() {
//		
//		AccessCollector ac = AccessCollector.collect(targetSystem);
//		
//		TargetMapping tm = targetSystem.getTargetMapping();
//		SpaceTimeLevel stlevel = tm.getSpaceTimeLevel(0);
//
//		//TODO: Currently we are only using one level of the spacetime map
//		//should be extended to hierarchy
//		List<Integer> orderingDims = stlevel.getOrderingDimensions();
//		
//		//for each local memory
//		for (VariableDeclaration local : targetSystem.getLocals()) {
//			final int totalDims = stlevel.getNumberOfDimensions();
//			
//			//maximum length of uniform dependencies along each axis
//			int[] maxLength = new int[totalDims];
//			
//			//the dimensions where projection is required
//			boolean[] LTpreservedDims = new boolean[totalDims];
//		
//			//required mod factors for projections along each dimension
//			int[] modVector = new int[totalDims];
//			
//			//SpaceTimeMap stMap = tm.getSpaceTimeMap(local);
//			SpaceTimeMap stMap = stlevel.getSpaceTimeMap(local);
//			//construct functions to remove ordering dimensions
//			List<String> rmOrderingFuncRHSExpr = new ArrayList<String>(stMap.getMapping().getDimLHS());
//			List<String> rmOrderingFuncLHSExpr = new ArrayList<String>(stMap.getMapping().getDimLHS());
//			EList<Integer> orderings = stlevel.getOrderingDimensions();
//			if((orderings == null) || (orderings.size() == 0)){	//if no ordering dimension is specified
//				for(int i = 0; i < stMap.getMapping().getDimRHS(); i++){
//					rmOrderingFuncRHSExpr.add(stMap.getMapping().getIndexNames().get(i));
//					rmOrderingFuncLHSExpr.add(stMap.getMapping().getIndexNames().get(i));
//				}
//			}else{
//				for(int i = 0; i < totalDims; i++){
//					if(orderings.contains(i)){	//if true: ordering dimension
//						rmOrderingFuncLHSExpr.add("0");	
//					}else{
//						rmOrderingFuncRHSExpr.add(stMap.getMapping().getIndexNames().get(i));
//						rmOrderingFuncLHSExpr.add(stMap.getMapping().getIndexNames().get(i));
//					}
//				}
//			}
////			for (int i = 0; i < stMap.getMapping().getDimRHS(); i++) {
////				if (stMap.getDimTypes().get(i) == DIM_TYPE.ORDERING) {
////					rmOrderingFuncLHSExpr.add("0");
////				} else {
////					rmOrderingFuncRHSExpr.add(stMap.getMapping().getIndexNames().get(i));
////					rmOrderingFuncLHSExpr.add(stMap.getMapping().getIndexNames().get(i));
////				}
////			}
//			
//			rmOrderingFuncRHS = PolyhedralIRUtility.parseAffineFunction(stMap.getMapping().getParams(), stMap.getMapping().getIndices(), rmOrderingFuncRHSExpr);
//			rmOrderingFuncLHS = PolyhedralIRUtility.parseAffineFunction(targetSystem.getParameters(), rmOrderingFuncRHSExpr, rmOrderingFuncLHSExpr);
//			
//			//constant number of delays necessary 
//			int[] delayLengths = new int[totalDims];
//			
//			//find the maximum length per each dimension and the dimension that satisfied the dep
//			for (AffineFunction dep : ac.getUniqueDependencies(local)) {
//				if (!removeOrderingDimensions(dep).isUniform()) {
//					throw new RuntimeException("Only uniform depdendence is allowed.");
//				}
//				List<Integer> cpart = dep.getConstantPart();
//				
//				//
//				int preservedDim = -1;
//				for (int i = 0; i < maxLength.length; i++) {
//					//skip ordering dims
//					if (orderingDims.contains(i)) continue;
//					
//					maxLength[i] = Math.max(maxLength[i], Math.abs(cpart.get(i)));
//					//first non-zero dimension is where the LT is preserved for that dependence
//					if (preservedDim == -1 && cpart.get(i) != 0) {
//						preservedDim = i;
//						LTpreservedDims[i] = true;
//					} else if (preservedDim >= 0) {
//						delayLengths[i] = Math.max(delayLengths[i], -cpart.get(i));
//					}
//				}
//			}
//			
//			//all dimensions with delays have to be preserved as well
//			for (int dim = 0; dim < delayLengths.length; dim++) {
//				//skip ordering dims
//				if (orderingDims.contains(dim)) continue;
//				
//				if (delayLengths[dim] != 0) LTpreservedDims[dim] = true;
//			}
//			
//			//mod factor is the max of the maximum length along each axis and the shift factors for that dimension
//			for (int i = 0; i < modVector.length; i++) {
//				modVector[i] = Math.max(maxLength[i], Math.abs(delayLengths[i]));
//			}
//			
//			AllocationsPerVariable apv = new AllocationsPerVariable(local, orderingDims, modVector, delayLengths, LTpreservedDims);
//			allocations.put(local, apv);
//			
//			if (DEBUG) {
//				System.out.println("===Allocation for " + local.getName()+"===");
//				for (int i = 0; i < apv.projections.size(); i++) {
//					System.out.print("dim " + i + ": ");
//					if (apv.orderingDims.contains(i)) {
//						System.out.println("ordering dim");
//					} else {
////					if (apv.LTpreservedDims[i]) {
//						System.out.println(apv.projections.get(i) + " delay:" + apv.delayLengths[i]);
////					} else {
////						System.out.println("not projected" + " delay:" + apv.shiftFactors[i]);
////					}
//					}
//				}
//			}
//		}
//	}
//	
//	@Override
//	public void reflect() {
//		if (DEBUG) {
//			System.out.println();
//			System.out.println("Before reflecting TileFaceAllocation");
//			System.out.println(targetSystem);
//		}
//
//		//normalize first
//		Normalize.normalize(targetSystem);
//		
//		TargetMapping tm = targetSystem.getTargetMapping();
//		SpaceTimeLevel stlevel = tm.getSpaceTimeLevel(0);
//
//		for (VariableDeclaration var : allocations.keySet()) {
//			AllocationsPerVariable apv = allocations.get(var);
//			StandardEquation curEq = targetSystem.getEquation(var.getName());
//				
//			StandardEquation prevEq = null;
//			//add new copied variables with the same expression
//			for (int dim = 0; dim < apv.readVariable.size(); dim++) {
//				VariableDeclaration readVar = apv.readVariable.get(dim);
//				VariableDeclaration writeVar = apv.writeVariable.get(dim);
//				VariableDeclaration delayVar = apv.delayedReadVariable.get(dim);
//				if (readVar == null || writeVar == null || delayVar == null) continue;
//				
//				final DependenceExpression depExpr;
//				//when its shifted, the dependence is not identity
//				//the shift in dependence is required for mod factors
//				int nextNonOrderingDim = dim+1;
//				while (apv.orderingDims.contains(nextNonOrderingDim)) {
//					nextNonOrderingDim++;
//				}
//				if (nextNonOrderingDim < apv.delayLengths.length && apv.delayLengths[nextNonOrderingDim] > 0) {
////					int[] shiftVec = new int[apv.shiftFactors.length];
////					for (int x = dim+1; x < shiftVec.length; x++) {
////						shiftVec[x] = apv.shiftFactors[x];
////					}
//					AffineFunction dep = PolyhedralIRUtility.createIdentityFunction(readVar.getDomain());
////					AffineFunction dep = PolyhedralIRUserFactory.eINSTANCE.createUniformFunction(readVar.getDomain(), shiftVec);
//					depExpr = _fact.createDependenceExpression(dep, _fact.createVariableExpression(apv.delayedReadVariable.get(nextNonOrderingDim)));
//				} else {
//					//dependence on the original variable
//					depExpr = _fact.createDependenceExpression(PolyhedralIRUtility.createIdentityFunction(var.getDomain()), _fact.createVariableExpression(var));
//				}
//
//				targetSystem.getLocals().add(readVar);
//				targetSystem.getLocals().add(writeVar);
//				targetSystem.getLocals().add(delayVar);
//				//copy the result of the original equation
//				StandardEquation copyEq = _fact.createStandardEquation(writeVar, depExpr);
//				targetSystem.getEquations().add(copyEq);
//				
//				//set target mapping
//				//identity schedule
////				tm.setSpaceTimeMap(readVar, PolyhedralIRUtility.createIdentityFunction(readVar.getDomain()));
////				tm.setSpaceTimeMap(writeVar, PolyhedralIRUtility.createIdentityFunction(writeVar.getDomain()));
////				tm.setSpaceTimeMap(delayVar, PolyhedralIRUtility.createIdentityFunction(delayVar.getDomain()));
////				stlevel.getT
//				stlevel.setSpaceTimeMap(0, readVar, PolyhedralIRUtility.createIdentityFunction(readVar.getDomain()));
//				stlevel.setSpaceTimeMap(0, writeVar, PolyhedralIRUtility.createIdentityFunction(writeVar.getDomain()));
//				tmstlevelSpaceTimeMap(0, delayVar, PolyhedralIRUtility.createIdentityFunction(delayVar.getDomain()));
//				
//				//same dim type, this is not needed for the new target mapping
////				EList<DIM_TYPE> dimTypes = tm.getSpaceTimeMap(var).getDimTypes();
////				for (int d = 0; d < dimTypes.size(); d++) {
////					tm.setDimensionType(readVar, d, dimTypes.get(d));
////					tm.setDimensionType(writeVar, d, dimTypes.get(d));
////					tm.setDimensionType(delayVar, d, dimTypes.get(d));
////				}
//				
//				//projection
//				//copy mod factor
//				EList<IntExpression> modFactorCopyW = new BasicEList<IntExpression>();
//				EList<IntExpression> modFactorCopyD = new BasicEList<IntExpression>();
//				for (IntExpression expr : apv.modFactors.get(dim)) {
//					modFactorCopyW.add(expr.copy());
//					modFactorCopyD.add(expr.copy());
//				}
//				
//				//shift for delaying
//				//When writing, the writing is shifted by the shift factor in the next dimension
//				//However, because the shifting causes negative indexing into arrays, the shifting is "undone"
//				//as a result, the reading is shifted by the shift factor to the opposite direction
//				
//				//To avoid the need to have preambles, extra space is allocated such that delaying can happen even in the boundaries.
//				//Therefore, the write and read are shifted by the shift factor
//				
//				//delay is the unchanged projection
//				AffineFunction delayMap = apv.projections.get(dim).copy();
//				//reading is shifted by the delays
//				int[] readShift = new int[apv.delayLengths.length];
//				for (int x = dim+1; x < readShift.length; x++) {
//					readShift[x] = apv.delayLengths[x];
//				}
//				//write is shifted by the projected dimension only
//				int[] writeShift = new int[apv.delayLengths.length];
//				writeShift[dim] = apv.delayLengths[dim];
//
//				AffineFunction readShiftAF = PolyhedralIRUtility.createUniformFunction(readVar.getDomain(), readShift);
//				AffineFunction writeShiftAF = PolyhedralIRUtility.createUniformFunction(writeVar.getDomain(), writeShift);
//				tm.setMemoryMap(readVar, apv.projections.get(dim).compose(readShiftAF), apv.modFactors.get(dim));
//				tm.setMemoryMap(writeVar, apv.projections.get(dim).compose(writeShiftAF), modFactorCopyW);
//				tm.setMemoryMap(delayVar, delayMap.copy(), modFactorCopyD);
//				EList<VariableDeclaration> shareSpaceVars = new BasicEList<VariableDeclaration>();
//				shareSpaceVars.add(readVar);
//				shareSpaceVars.add(delayVar);
//				shareSpaceVars.add(writeVar);
//				tm.setMemorySpace(readVar.getName(), shareSpaceVars);
////				tm.setMemoryMap(TargetMappingUserFactory.createIdentityMemorySpace(readVar), readVar, apv.projections.get(dim).compose(readShiftAF), apv.modFactors.get(dim));
////				MemorySpace space = tm.getMemorySpace(readVar.getName());
////				tm.setMemoryMap(space, writeVar, apv.projections.get(dim).compose(writeShiftAF), modFactorCopyW);
////				tm.setMemoryMap(space, delayVar, delayMap.copy(), modFactorCopyD);
//				
//				
////				//shift factor is specified for the dimension one inner than the projection direction 
////				if (dim+1 < apv.shiftFactors.length && apv.shiftFactors[dim+1] < 0) {
////					//the allocation for read variable is modified because the delaying causes the memory to have LB less than 0 and requires shifting both memory allocations up anyway
////					int[] shiftVec = new int[apv.shiftFactors.length];
//////					shiftVec[dim+1] = -apv.shiftFactors[dim+1];
////					//I DO need to shift the read in all dimensions (or shift the write in all dimensions) 
////					for (int x = dim+1; x < shiftVec.length; x++) {
////						shiftVec[x] = -apv.shiftFactors[x];
////					}
////					AffineFunction shift = PolyhedralIRUserFactory.eINSTANCE.createUniformFunction(readVar.getDomain(), shiftVec);
////					tm.setMemoryMap(TargetMappingFactory.createIdentityMemorySpace(readVar), readVar, apv.projections.get(dim).compose(shift), apv.modFactors.get(dim));
////					MemorySpace space = tm.getMemorySpace(readVar.getName());
////					tm.setMemoryMap(space, writeVar, apv.projections.get(dim).copy(), modFactorCopyW);
////					tm.setMemoryMap(space, delayVar, apv.projections.get(dim).copy(), modFactorCopyD);
////				//projection in the inner most dimension is treated differently
////				//read and write are both shifted, but the delay is not
////				} else if (dim+1 == apv.shiftFactors.length) {
////					int[] shiftVec = new int[apv.shiftFactors.length];
////					shiftVec[dim] = -apv.shiftFactors[dim]; 
////					AffineFunction shift = PolyhedralIRUserFactory.eINSTANCE.createUniformFunction(readVar.getDomain(), shiftVec);
////					tm.setMemoryMap(TargetMappingFactory.createIdentityMemorySpace(readVar), readVar, apv.projections.get(dim).compose(shift), apv.modFactors.get(dim));
////					
////					MemorySpace space = tm.getMemorySpace(readVar.getName());
////					tm.setMemoryMap(space, writeVar, apv.projections.get(dim).compose(shift), modFactorCopyW);
////					tm.setMemoryMap(space, delayVar, apv.projections.get(dim).copy(), modFactorCopyD);
////				} else {
////					tm.setMemoryMap(TargetMappingFactory.createIdentityMemorySpace(readVar), readVar, apv.projections.get(dim), apv.modFactors.get(dim));
////					MemorySpace space = tm.getMemorySpace(readVar.getName());
////					tm.setMemoryMap(space, writeVar, apv.projections.get(dim).copy(), modFactorCopyW);
////					tm.setMemoryMap(space, delayVar, apv.projections.get(dim).copy(), modFactorCopyD);
////				}
//				
//				//specify statement ordering such that original is before the copy
//				tm.setStatementOrder(curEq, copyEq);
//				
//				//the projection along outer ones are always before the current
//				if (prevEq != null) {
//					tm.setStatementOrder(prevEq, curEq);
//				}
//				//keep track of the equation created this iteration for the next
//				prevEq = curEq;
//			}
//			//rename all dependence to the current equation to the appropriate projection
//			VariableRenamer vr = new VariableRenamer(apv);
//			targetSystem.accept(vr);
//			//set the original variable to have scalar memory
////			tm.setMemoryMap(TargetMappingUserFactory.createIdentityMemorySpace(var), var, PolyhedralIRUtility.parseAffineFunction(var.getDomain().getParams(), var.getDomain().getIndices(), new ArrayList<String>()), null);
//			tm.setMemoryMap(var, PolyhedralIRUtility.parseAffineFunction(var.getDomain().getParams(), var.getDomain().getIndices(), new ArrayList<String>()), null);
//			tm.setMemorySpace(var.getName(), var);
//		}
//		
//		Normalize.normalize(targetSystem);
//		if (DEBUG) {
//			System.out.println("After reflecting TileFaceAllocation");
//			System.out.println(targetSystem);
//			for(MemoryMap mMap: targetSystem.getTargetMapping().getMemoryMaps()){
//				System.out.println("Variable: " + mMap.getVariable().getName() + " Mapping: " + mMap.getMapping() + " Mods: " + mMap.getModFactors());
//			}
////			for (MemorySpace space : targetSystem.getTargetMapping().getMemorySpaces()) {
////				for (MemoryMap map : space.getMemoryMaps()) {
////					System.out.println(map);
////				}
////			}
//		}
//	}
//	
//	public class AllocationsPerVariable {
//		public final VariableDeclaration variable;
//		public final List<Integer> orderingDims;
//		public final int[] modVector;
//		public final int[] delayLengths;
//		public final boolean[] LTpreservedDims;
//		public final List<AffineFunction> projections;
//		public final List<EList<IntExpression>> modFactors;
//		public final List<VariableDeclaration> readVariable;
//		public final List<VariableDeclaration> writeVariable;
//		public final List<VariableDeclaration> delayedReadVariable;
//		
//		protected AllocationsPerVariable(VariableDeclaration variable, List<Integer> orderingDims, int[] modVector, int[] delayLengths, boolean[] LTpreservedDims) {
//			this.variable = variable;
//			this.orderingDims = orderingDims;
//			this.modVector = modVector;
//			this.delayLengths = delayLengths;
//			this.LTpreservedDims = LTpreservedDims;
//			
//			//initialize the projections for each dimensions that is necessary (=LTpreserved)
//			projections = new ArrayList<AffineFunction>(modVector.length);
//			modFactors = new ArrayList<EList<IntExpression>>(modVector.length);
//			readVariable = new ArrayList<VariableDeclaration>(modVector.length);
//			writeVariable = new ArrayList<VariableDeclaration>(modVector.length);
//			delayedReadVariable = new ArrayList<VariableDeclaration>(modVector.length);
//			//
//			int dimWOordering = -1;
//			for (int d = 0; d < LTpreservedDims.length; d++) {
//				//keep track the dimension without ordering
//				if (!orderingDims.contains(d)) {
//					dimWOordering++;
//				}
//				
//				//if the projection is required to preserve the dependence or delay length is required
//				if (LTpreservedDims[d] || delayLengths[d] != 0) {
//					long[][] projDirection = new long[1][LTpreservedDims.length-orderingDims.size()];
//					projDirection[0][dimWOordering] = 1;
//					//find the kernel and transpose to make each row a dimension of the projection function
//					long[][] kerProjDir = MatrixOperations.transpose(MatrixOperations.nullspace(projDirection));
//					
//					//sort the matrix such that its in the order from 0th dim projection to nth dim
//					long[][] sortedKerProjDir = sortMatrixByNonZeroColumnDimension(kerProjDir);
//					
//					//index names without the ordering dimensions
//					List<String> indexNames = rmOrderingFuncLHS.getIndexNames();
//					
//					List<String> exprs = new ArrayList<String>(sortedKerProjDir.length);
//					for (int i = 0; i < sortedKerProjDir.length; i++) {
//						StringBuffer expr = new StringBuffer();
//						for (int j = 0; j < sortedKerProjDir[i].length; j++) {
//							if (sortedKerProjDir[i][j] > 0) {
//								if (expr.length() > 0) {
//									expr.append("+");
//								}
//								expr.append(sortedKerProjDir[i][j]+indexNames.get(j));
//							} else if (sortedKerProjDir[i][j] < 0) {
//								expr.append(sortedKerProjDir[i][j]+indexNames.get(j));
//							}
//						}
//						
//						exprs.add(expr.toString());
//					}
//
//					//mod factors
//					EList<IntExpression> modFactor = new BasicEList<IntExpression>();
//					//dimensions of the projections are 0
//					for (int i = 0; i < exprs.size(); i++) {
//						modFactor.add(affine(term(0)));
//					}
//					//if this axis requires mod factor, add another dimension for the mod
//					if (modVector[d] > 1) {
//						modFactor.add(0, affine(term(modVector[d])));
//						exprs.add(0, variable.getDomain().getIndexNames().get(d));
//					}
//
//					AffineFunction proj = PolyhedralIRUtility.parseAffineFunction(variable.getDomain().getParams(), variable.getDomain().getIndices(), exprs);
//										
//					VariableDeclaration readVar = _fact.createVariableDeclaration(variable.getName() + "_p_"+variable.getDomain().getIndexNames().get(d), variable.getType(), variable.getDomain().copy());
//					VariableDeclaration writeVar = _fact.createVariableDeclaration(variable.getName() + "_p_"+variable.getDomain().getIndexNames().get(d)+"_write", variable.getType(), variable.getDomain().copy());
//					VariableDeclaration delayVar = _fact.createVariableDeclaration(variable.getName() + "_p_"+variable.getDomain().getIndexNames().get(d)+"_delay", variable.getType(), variable.getDomain().copy());
//					projections.add(proj);
//					modFactors.add(modFactor);
//					readVariable.add(readVar);
//					writeVariable.add(writeVar);
//					delayedReadVariable.add(delayVar);
//					
//					if (DEBUG) {
//						System.out.println(readVar + " : " + proj);
//					}
//				} else {
//					projections.add(null);
//					modFactors.add(null);
//					readVariable.add(null);
//					writeVariable.add(null);
//					delayedReadVariable.add(null);
//				}
//			}
//		}
//
//		/**
//		 * Returns the dimension of the canonic projections that preserves the lieftime for the given dependence.
//		 * When looking at the constant part of the uniform dependence, its the first non-zero dimension starting from the outer-most dimensions.
//		 * 
//		 * Returns -1 when the dependence is satisfied by statement ordering for an identity dependence. 
//		 * In such cases, the dependence should refer to the scalar value stored temporarily.
//		 * 
//		 * @param var
//		 * @param dependence
//		 * @return
//		 */
//		public int getLifeTimePreservedDimension(VariableDeclaration source, VariableDeclaration dest, AffineFunction dependence) {
//			int depLevel = getDependenceLevel(source, dest, dependence);
//			
//			if (depLevel >= 0) return depLevel;
//			
//			//identity dependence on CoBed space is 
//			if (source.equals(variable)) {
//				System.err.println("Any projection should work for identity dependence on the same variable. Not thought through this case yet.");
//				return 0;
//			} else {
//				for (StatementPartialOrder pso : targetSystem.getTargetMapping().getStatementOrderings()) {
//					VariableDeclaration succ = pso.getSuccessor().getVariable();
//					VariableDeclaration pred = pso.getPredecessor().getVariable();
//					
//					if (succ.getName().contentEquals(source.getName()) && pred.getName().contentEquals(variable.getName())) {
//						return -1;
//					}
//				}
//				throw new RuntimeException("Identity dependence from another variable relies on statement ordering. Statement ordering was not specified.");
//			}
//		}
//		
//		private int getDependenceLevel(VariableDeclaration source, VariableDeclaration dest, AffineFunction dep) {
//			if (!removeOrderingDimensions(dep).isUniform()) {
//				throw new RuntimeException("Only uniform depdendence is allowed.");
//			}
//			
//			List<Integer> cpart = dep.getConstantPart();
//			
//			for (int dim = 0; dim < cpart.size(); dim++) {
//				//ordering dimensions are special, look at the constant
//				if (orderingDims.contains(dim)) {
//					int srcConst = Integer.parseInt(source.getDomain().getBounds(dim).get(0).toString(OUTPUT_FORMAT.C));
//					int dstConst = Integer.parseInt(  dest.getDomain().getBounds(dim).get(0).toString(OUTPUT_FORMAT.C));
//					if (srcConst > dstConst) {
//						int level = dim-1;
//						while (orderingDims.contains(level)) {
//							level--;
//						}
//						if (level == -1) {
//							throw new RuntimeException("Dependence carried by outermost ordering dimension.");
//						}
//						return level;
//					}
//				} else if (cpart.get(dim) != 0) {
//					return dim;
//				}
//			}
//			
//			return -1;
////			System.out.println(dep);
////			System.out.println(cpart);
////			throw new RuntimeException("Dependence Level undefined");
//		}
////		
////		private boolean doesDependenceCrossOrderingDimension(VariableDeclaration source, VariableDeclaration dest, int dim) {
////			int srcConst = Integer.parseInt(source.getDomain().getBounds(dim).get(0).toString(OUTPUT_FORMAT.C));
////			int dstConst = Integer.parseInt(  dest.getDomain().getBounds(dim).get(0).toString(OUTPUT_FORMAT.C));
////			return (srcConst > dstConst);
////		}
//		
//		/**
//		 * 
//		 * @param mat
//		 * @return
//		 */
//		private long[][] sortMatrixByNonZeroColumnDimension(long[][] mat) {
//			//find the firstNZs
//			List<Integer> firstNZ = new ArrayList<Integer>(mat.length);
//			for (int i = 0; i < mat.length; i++) {
//				for (int j = 0; j < mat[i].length; j++) {
//					if (mat[i][j] != 0) {
//						firstNZ.add(j);
//						break;
//					}
//				}
//				if (firstNZ.size() <= i) {
//					throw new RuntimeException("Every row of the set of kernel basis vectors should have a non-zero.");
//				}
//			}
//			
//			//then create a new matrix with the rows with ascending order of the non-zero column
//			long[][] sortedKerProjDir = new long[mat.length][mat[0].length];
//			int current = 0;
//			for (int i = 0; i < mat[0].length; i++) {
//				int row = firstNZ.indexOf(i);
//				if (row >= 0) {
//					sortedKerProjDir[current] = mat[row];
//					current++;
//				}
//			}
//			
//			return sortedKerProjDir;
////			MatrixOperations.printMatrix(mat);
//		}
//	}
//
//	protected class VariableRenamer extends PolyhedralIRInheritedDepthFirstVisitorImpl {
//		
//		protected AllocationsPerVariable targetVariable;
//		
//		protected VariableRenamer(AllocationsPerVariable targetVariable) {
//			this.targetVariable = targetVariable;
//		}
//		
//		@Override
//		public void visitStandardEquation(StandardEquation s) {
//			//skip the variable itself
//			if (targetVariable.readVariable.contains(s.getVariable())) {
////				targetVariable.writeVariable.contains(s.getVar())) {
////				return;
//			} else {
//				super.visitStandardEquation(s);
//			}
//		}
//		
//		@Override
//		public void inVariableExpression(VariableExpression v) {
//			
//			// TODO
//			if (v.getContainerEquation() instanceof UseEquation)
//				throw new RuntimeException("Todo: implement that for UseEquation");
//			
//			if (v.getVarDecl().equals(targetVariable.variable)) {
//				final AffineFunction dep;
//				if (v.eContainer() instanceof DependenceExpression) {
//					dep = ((DependenceExpression)v.eContainer()).getDep();
//				} else {
//					dep = PolyhedralIRUtility.createIdentityFunction(v.getContextDomain());
//				}
//				int dim = targetVariable.getLifeTimePreservedDimension(((StandardEquation) v.getContainerEquation()).getVariable(), v.getVarDecl(), dep);
//				
////				System.err.println(v.getContainerEquation().getVar().getName() + "->" + v.getVarDecl().getName() + " @ " + dep + " : " + dim);
//				
//				//dim == -1 is special cased
//				if (dim == -1) {
//					//don't change the variable label
//				} else if (targetVariable.readVariable.get(dim) == null) {
//					throw new RuntimeException("Life time preserved dimension " + dim + " is not stored for variable " + v.getVarDecl().getName());
//				} else {
//					v.setVarDecl(targetVariable.readVariable.get(dim));
//				}
//			} 
//		}
//	}
//}
