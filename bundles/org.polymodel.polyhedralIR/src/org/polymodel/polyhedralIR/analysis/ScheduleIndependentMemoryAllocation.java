package org.polymodel.polyhedralIR.analysis;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.matrix.operations.MatrixOperations;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.analysis.AccessCollector.VariableAccess;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;


/**
 * Implementation of Schedule-Independent Storage Mapping for Loops [Strout, et. al ASPLOS1998]
 * 
 * In addition to the projection, it adds offsets based on the bounds of the variable domains so that the 
 * array index are always positive.
 * 
 * usage : 
 *  call findMemoryAllocation to get an instance of this class that contains the result of finding the memory allocation. 
 * 
 * @author yuki
 *
 */
public class ScheduleIndependentMemoryAllocation extends AbstractMemoryAllocator {

	public static boolean DEBUG = false;
	
	private static void debug(String message) {
		if (DEBUG) System.out.println("[UOV Allocation] " + message);
	}
	
	public static ScheduleIndependentMemoryAllocation allocate(AffineSystem system) {
		return allocate(system, false);
	}
	
	public static ScheduleIndependentMemoryAllocation allocate(AffineSystem system, boolean fullyTiled) {
		ScheduleIndependentMemoryAllocation sima = new ScheduleIndependentMemoryAllocation(system, fullyTiled);
		
		sima.allocate();
		
		return sima;
	}
	
	private final boolean fullyTiled;
	
	protected AccessCollector accessCollector;
	protected Map<VariableDeclaration, AffineFunction> projectionFunctions;
	protected Map<VariableDeclaration, Integer> modFactors;
	protected Map<VariableDeclaration, int[]> occupancyVectors; 
	protected Map<VariableDeclaration, int[][]> projectionVectors; 

	protected ScheduleIndependentMemoryAllocation(AffineSystem system, boolean fullyTiled) {
		super(system);
		this.fullyTiled = fullyTiled;
	}
	
	public AffineFunction getProjectionFunction(VariableDeclaration varDecl) {
		return projectionFunctions.get(varDecl); 
	}
	
	public int getModFactor(VariableDeclaration varDecl) {
		return modFactors.get(varDecl);
	}
	
	public int[] getOccupancyVector(VariableDeclaration varDecl) {
		return occupancyVectors.get(varDecl);
	}
	
	public int[][] getProjectionVector(VariableDeclaration varDecl) {
		return projectionVectors.get(varDecl);
	}
	
	public EList<IntExpression> getModFactors(VariableDeclaration varDecl) {
		return getModFactors(projectionFunctions.get(varDecl), varDecl.getDomain(), modFactors.get(varDecl));
	}
	
	public static EList<IntExpression> getModFactors(AffineFunction projection, Domain domain, int modFactor) {
		EList<IntExpression> mods = new BasicEList<IntExpression>(projection.getDimRHS());
		
		
		Domain projDom = domain.image(projection);
		
		for (int dim = 0; dim < projDom.getNIndices(); dim++) {
			mods.add(projDom.getBounds(dim).get(1));
		}
		
		//mod factor for the first dimension
		if (modFactor > 1) {
			mods.set(0, affine(term(modFactor)));
		}
		
		return mods;
	}
	
	public List<VariableAccess> getAccesses(VariableDeclaration varDecl) {
		return accessCollector.getAccesses(varDecl);
	}
	
	@Override
	protected void allocate() {
		projectionFunctions = new HashMap<VariableDeclaration, AffineFunction>();
		modFactors = new HashMap<VariableDeclaration, Integer>();
		occupancyVectors = new HashMap<VariableDeclaration,  int[]>();
		projectionVectors = new HashMap<VariableDeclaration,  int[][]>();
		
		//collect all accesses for each variable
		AccessCollector ac = AccessCollector.collect(system);
		//for each local variable, find the memory allocation
		for (VariableDeclaration var : system.getLocals()) {
			debug("Finding Allocation for " + var.getName());
			
			SortedSet<AffineFunction>  dependenceSet = ac.getUniqueDependences(var);
			
			if (dependenceSet.isEmpty()) {
				System.err.println("skipping " + var.getName() + ": no dependence");
				continue;
			}
			
			Set<int[]> dependenceVectorSet = new TreeSet<int[]> (new DependenceVectorComparator());

			
			boolean uniform = true;
			for (AffineFunction f : dependenceSet) {
				if (!f.isUniform()) {
					uniform = false;
					break;
//					throw new RuntimeException("Only uniform dependencies are handled: " + f);
				}
				List<Integer> constantPart = f.getConstantPart();
				int[] ov = new int[constantPart.size()];
				for (int i = 0; i < constantPart.size(); i++) {
					ov[i] -= constantPart.get(i);
				}
				dependenceVectorSet.add(ov);
				
			}
			if (!uniform) {
				System.err.println("skipping " + var.getName() + ": not uniform");
				continue;
			}

			debug(" Dependence Set: " + dependenceSet);
			debug(" Dependence Vector Set: " + printVectorSet(dependenceVectorSet));
						
			int[] UOV = new int[dependenceSet.first().getDimRHS()];
			
			if (fullyTiled) {
				for (int[] ov : dependenceVectorSet) {
					for (int i = 0; i < UOV.length; i++) {
						UOV[i] = Math.max(UOV[i], ov[i]);
					}
				}
			} else {
				for (int[] ov : dependenceVectorSet) {
					for (int i = 0; i < UOV.length; i++) {
						UOV[i] += ov[i];
					}
				}
			}
			
			debug(" Trivial OV: " + toStringList(UOV));

			int gcd = 0;
			for (int ov : UOV) {
				gcd = gcd(gcd, ov);
			}
			
			long[][] ov2 = new long[1][UOV.length];
			for (int dim = 0; dim < UOV.length; dim++) {
				ov2[0][dim] = UOV[dim];
			}
			
			//take the kernel to find a projection function
			// transpose so that each row becomes a dimension of the projection
			long[][] kerOV = MatrixOperations.transpose(MatrixOperations.nullspace(ov2));
			
//			debug("kerOV:\n" + MatrixOperations.toString(kerOV));
			

			//store the vectors
			occupancyVectors.put(var, UOV);
			//convert to int
			int[][] kerOVint = new int[kerOV.length][kerOV[0].length];
			for (int i = 0; i < kerOV.length; i++) {
				for (int j = 0; j < kerOV[i].length; j++) {
					kerOVint[i][j] = (int)kerOV[i][j];
				}
			}
			projectionVectors.put(var, kerOVint);
			
			//mod factor
			int modFactor = 0;
			for (int ov : UOV) {
				modFactor = gcd(modFactor, ov);
			}
			if (Math.abs(modFactor) > 1) modFactor = Math.abs(modFactor); else modFactor = 0;
			
			//create projection
			final AffineFunction projection;
			if (gcd == 0) {
				projection = PolyhedralIRUtility.createProjection(var.getDomain(), new ArrayList<Variable>());
			} else {
				projection = createProjectionFunction(UOV, kerOVint, modFactor, var);
			}
			projectionFunctions.put(var, projection);

			debug(" Mapping: " + projection + " mod " + modFactor);
			
			//mod factors
			modFactors.put(var, modFactor);
		}
	}
	
	public static AffineFunction createProjectionFunction(int[] OV, int[][] kerOV, int modFactor, VariableDeclaration varDecl) {
		List<Variable> params = varDecl.getDomain().getParams();
		List<Variable> indices = varDecl.getDomain().getIndices();
		List<AffineExpression> exprs = new ArrayList<AffineExpression>(kerOV.length);
		
		if (modFactor != 0) {
			AffineExpression expr = IntExpressionBuilder.affine();
			
			for (int i = 0; i < OV.length; i++) {
				if (OV[i] != 0) {
					expr.getTerms().add(IntExpressionBuilder.term(OV[i], indices.get(i)));
				}
			}
			
			exprs.add(expr);
		}
		
		for (int[] ker : kerOV) {
			AffineExpression expr = IntExpressionBuilder.affine();
			
			for (int i = 0; i < ker.length; i++) {
				if (ker[i] != 0) {
					expr.getTerms().add(IntExpressionBuilder.term(ker[i], indices.get(i)));
				}
			}
			
			exprs.add(expr);
		}
		
		return PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(params, indices, exprs);
	}
//	
//	public static AffineFunction createProjectionFunction(int[] OV, int[][] kerOV, int modFactor, VariableDeclaration varDecl) {
//		List<List<IntExpression>> bounds = new ArrayList<List<IntExpression>>(varDecl.getDomain().getNIndices());
//		for (int dim = 0; dim < varDecl.getDomain().getNIndices(); dim++) {
//			bounds.add(varDecl.getDomain().getBounds(dim));
//		}
//		return createProjectionFunction(OV, kerOV, modFactor, varDecl, bounds);
//	}
//	
//	/**
//	 * Creates a projection function based on the kernel of the occupancy vector, variable declaration and UB/LB of the domain.
//	 * UB/LB is necessary to avoid taking mods with negative number, which has undefined behavior in C.
//	 * When an index used in the projection has a positive coefficient, the LB of that dimension is subtracted,
//	 * and the upper bound is added with negative coefficients.
//	 *  
//	 * When modFactor is specified, adds an extra dimension in the beginning for adding the mod. 
//	 * 
//	 * @param kerOV
//	 * @param modFactor
//	 * @param varDecl
//	 * @param bounds
//	 * @return
//	 */
//	public static AffineFunction createProjectionFunction(int[] OV, int[][] kerOV, int modFactor, VariableDeclaration varDecl, List<List<IntExpression>> bounds) {
//		List<String> exprs = new ArrayList<String>(kerOV.length+1);
//		
//		if (modFactor != 0) {
//			exprs.add(constructExpression(OV, varDecl.getDomain().getIndexNames(), bounds));
//		}
//		for (int dim = 0; dim < kerOV.length; dim++) {
//			exprs.add(constructExpression(kerOV[dim], varDecl.getDomain().getIndexNames(), bounds));
//		}
//		return PolyhedralIRUtility.parseAffineFunction(varDecl.getDomain().getParams(), varDecl.getDomain().getIndices(), exprs);
//	}
//	
//	private static String constructExpression(int[] vec, List<String> indexNames, List<List<IntExpression>> bounds) {
//		StringBuffer expr = new StringBuffer();
//
//		//kerOV[i] is the coefficient of the projection function of the ith index
//		for (int i = 0; i < vec.length; i++) {
//			if (expr.length() > 0 && vec[i] > 0) {
//				expr.append("+");
//			}
//			if (vec[i] != 0) {
//				expr.append(vec[i]+indexNames.get(i));
//			}
//			//offsets
//			//positive coefficient -> subtract LB
//			if (vec[i] > 0) {
//				IntExpression lb = bounds.get(i).get(0);
//				lb = IntExpressionBuilder.prod(lb, IntExpressionBuilder.affine(IntExpressionBuilder.term((int)(vec[i]*-1))));
//				lb = lb.simplify();
//				String lbStr = lb.toString(OUTPUT_FORMAT.ALPHABETS);
//				if (lbStr.matches("^-.+")) {
//					expr.append(lbStr);
//				} else {
//					expr.append("+"+lbStr);
//				}
//			//negative coefficient -> add UB
//			} else if (vec[i] < 0) {
//				IntExpression ub = bounds.get(i).get(1);
//				ub = IntExpressionBuilder.prod(ub, IntExpressionBuilder.affine(IntExpressionBuilder.term((int)(vec[i]*-1))));
//				ub = ub.simplify();
//				String ubStr = ub.toString(OUTPUT_FORMAT.ALPHABETS);
//				if (ubStr.matches("^-.+")) {
//					expr.append(ubStr);
//				} else {
//					expr.append("+"+ubStr);
//				}
//			}
//		}
//		return expr.toString();
//	}
	
	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	@Override
	public void reflect() {
		// TODO Auto-generated method stub
		
	}
	
	private static String printVectorSet(Set<int[]> set) {
		StringBuffer sb = new StringBuffer();
		sb.append("<");
		for (int[] vector : set) {
			if (sb.length() > 1) sb.append(", ");
			sb.append(toStringList(vector));
		}
		sb.append(">");
		return sb.toString();
	}
	
	private static String toStringList(int[] vec) {
		StringBuffer sb = new StringBuffer();

		sb.append("[");
		for (int v : vec) {
			if (sb.length() > 1) sb.append(", ");
			sb.append(v);
		}
		sb.append("]");	
			
		return sb.toString();
	}
	
	private static class DependenceVectorComparator implements Comparator<int[]> {

		@Override
		public int compare(int[] arg0, int[] arg1) {
			if (arg0.length != arg1.length) {
				throw new RuntimeException("Illegal Input");
			}

			int valA = 0;
			int valB = 0;
			
			for (int i = 0; i < arg0.length; i++) {
				int multiplier = (int)Math.pow(10, i);
				valA += arg0[i] * multiplier;
				valB += arg1[i] * multiplier;
			}
			
			return valA - valB;
		}
		
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		for (VariableDeclaration v : projectionFunctions.keySet()) {
			sb.append(v.getName());
			sb.append(" ");
			sb.append(projectionFunctions.get(v));
			sb.append(" mod ");
			sb.append(modFactors.get(v));
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
