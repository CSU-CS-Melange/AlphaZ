package org.polymodel.polyhedralIR.convolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.OPS;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.IntegerExpression;
import org.polymodel.polyhedralIR.expression.UnaryExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;
import org.polymodel.polyhedralIR.util.ToStringComparator;


/**
 * Convolution of one data variable by constant coefficients with a fixed kernel width.
 * The width is automatically computed from data accesses, which is assumed to be 
 * uniform dependences.
 * 
 * 
 * @author tyuki
 *
 */
public class Convolution {

	protected final StandardEquation equation;         //LHS of the convolution
	protected final VariableDeclaration dataVariable;
	protected Domain domain = null;
	protected List<Integer> dimensionWiseMax = null;
	protected List<Integer> dimensionWiseMin = null;
	protected List<Integer> dimensionWiseWidth = null;
	//Arrays of coefficients and data accesses; Map is used since dimensionality of arrays are not known 
	protected SortedMap<List<Integer>, Expression> coefficients = new TreeMap<>(new ToStringComparator<List<Integer>>());
	protected SortedMap<List<Integer>, Expression> dataAccesses = new TreeMap<>(new ToStringComparator<List<Integer>>());
	
	public Convolution(StandardEquation eq, VariableDeclaration dataVar) {
		equation = eq;
		dataVariable = dataVar;
		
		final int nbIndices = equation.getVariable().getDomain().getNIndices(); 

		dimensionWiseMax = new ArrayList<Integer>(nbIndices);
		dimensionWiseMin = new ArrayList<Integer>(nbIndices);
		dimensionWiseWidth = new ArrayList<Integer>(nbIndices);
		
		for (int i = 0; i < nbIndices; i++) {
			dimensionWiseMax.add(Integer.MIN_VALUE);
			dimensionWiseMin.add(Integer.MAX_VALUE);
			dimensionWiseWidth.add(0);
		}
		
	}
	
	/**
	 * Register a new operand, an expression each for coefficient and data access.
	 * The data variable must be the same for all operands added to a convolution.
	 * 
	 * @param coefficient
	 * @param dataAccess
	 */
	public void addOperand(Expression coefficient, Expression dataAccess) {
		List<Integer> vec = findDependenceVector(dataAccess).getConstantPart();
		VariableDeclaration dataVar = ConvolutionSystemDetection.getDataVariable(dataAccess);
		
		if (!dataVar.getName().equals(dataVariable.getName())) {
			throw new RuntimeException("[Convolution] Data variable does not match: " +dataVariable.getName() + " " + dataVar.getName());
		}
		
		//If two access to the same data expression was found, merge the coefficients
		if (dataAccesses.containsKey(vec)) {
			Expression existingDataAccess = dataAccesses.get(vec);
			if (!PolyhedralIRToAlphabets.toString(dataAccess).equals(PolyhedralIRToAlphabets.toString(existingDataAccess))) {
				throw new RuntimeException("[Convolution] Data access does not match: " + PolyhedralIRToAlphabets.toString(dataAccess) + " " + PolyhedralIRToAlphabets.toString(existingDataAccess));
			}
			
			Expression newCoefExpr = PolyhedralIRUserFactory.eINSTANCE.createBinaryExpression(OP.ADD, coefficient, coefficients.get(vec));
			coefficients.put(vec, newCoefExpr);
		} else {
			dataAccesses.put(vec, dataAccess);
			coefficients.put(vec, coefficient);
		}

		
		//Update min/max/width info
		elementWiseMax(dimensionWiseMax, vec);
		elementWiseMin(dimensionWiseMin, vec);
		
		for (int i = 0; i < dimensionWiseWidth.size(); i++) {
			dimensionWiseWidth.set(i, dimensionWiseMax.get(i) - dimensionWiseMin.get(i) + 1);
		}
		
		//invalidate domain
		domain = null;
	}
	
	public StandardEquation getEquation() {
		return equation;
	}
	
	public VariableDeclaration getDataVariable() {
		return dataVariable;
	}
	
	/**
	 * Returns true if the width of convolution is 1 (and with only one dimension),
	 * and the coefficient is integer 1.
	 * 
	 * @return
	 */
	public boolean isIdentity() {
		if (coefficients.size() == 1) {
			Expression coef = coefficients.values().iterator().next();
			return (coef instanceof IntegerExpression && ((IntegerExpression) coef).getValue() == 1);
		}
		
		return false;
	}
	
	public Domain getDomain() {
		if (domain == null)
			computeDomain();
		
		return domain;
	}
	
	/**
	 * Computes the domain of convolution kernel. Domain is a derived
	 * property, computed when this method is called and invalidated
	 * by calls to addOperand.
	 * 
	 */
	private void computeDomain() {
		List<Variable> params = equation.getVariable().getDomain().getParams();
		List<Variable> indices = equation.getVariable().getDomain().getIndices();
		
		if (coefficients.size() == 0) {
			domain = PolyhedralIRUtility.createEmptyDomain(params, indices);
			return;
		}
		
		domain = PolyhedralIRUtility.createUniverseDomain(params, indices);
		
		for (int i = 0; i < indices.size(); i++) {
			IntExpression var = IntExpressionBuilder.affine(indices.get(i));
			IntConstraint lb = IntExpressionBuilder.constraint(IntExpressionBuilder.constant(dimensionWiseMin.get(i)), var, ComparisonOperator.LE);
			IntConstraint ub = IntExpressionBuilder.constraint(var.copy(), IntExpressionBuilder.constant(dimensionWiseMax.get(i)), ComparisonOperator.LE);

			domain.getPMdomain().addConstraint(lb);
			domain.getPMdomain().addConstraint(ub);
		}
	}
	
	private void elementWiseMax(List<Integer> keep, List<Integer> given) {
		assert(keep.size() == given.size());
		
		for (int i = 0; i < keep.size(); i++) {
			keep.set(i, Math.max(keep.get(i), given.get(i)));
		}
	}
	private void elementWiseMin(List<Integer> keep, List<Integer> given) {
		assert(keep.size() == given.size());
		
		for (int i = 0; i < keep.size(); i++) {
			keep.set(i, Math.min(keep.get(i), given.get(i)));
		}
	}

	/**
	 * Inspects the given expression to find the dependence function.
	 * Expected to see simple expressions that would be found as operands
	 * of convolutions; handles Unary, Dependence, and Variable expressions.
	 * 
	 * 
	 * @param expr
	 * @return
	 */
	private AffineFunction findDependenceVector(Expression expr) {
		AffineFunction dep = null;
		if (expr instanceof UnaryExpression) {
			expr = ((UnaryExpression) expr).getExpr();
		}
		if (expr instanceof DependenceExpression) {
			return  ((DependenceExpression) expr).getDep().copy();
		}
		if (expr instanceof VariableExpression) {
			Domain varDomain = ((VariableExpression) expr).getVarDecl().getDomain();
			if (dep == null) {
				return PolyhedralIRUtility.createIdentityFunction(varDomain);
			}
		}
		
		throw new RuntimeException("Not a variable access expression: " + PolyhedralIRToAlphabets.toSimplifiedString(expr));
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Widths: " + dimensionWiseWidth);
		sb.append("\n");
		sb.append("Domain: " + getDomain());
		sb.append("\n");
		sb.append("Cofficients:\n");
		sb.append(toCoefficientString());
		sb.append("Data Access:\n");
		sb.append(toDataAccessString());
		
		return sb.toString();
	}
	
	/**
	 * Returns the coefficient matrix (or array) in String representation.
	 * For 3D or higher dimensional coefficients, a sequence of matrices
	 * are given.
	 * 
	 * @return
	 */
	public String toCoefficientString() {
		return mapToString(coefficients);
	}

	/**
	 * Returns the data access function matrix (or array) in String representation.
	 * For 3D or higher dimensional accesses, a sequence of matrices
	 * are given.
	 * 
	 * @return
	 */
	public String toDataAccessString() {
		return mapToString(dataAccesses);
	}

	/**
	 * Common method for printing coefficients and data access arrays.
	 * 
	 * @param map
	 * @return
	 */
	private String mapToString(Map<List<Integer>, Expression> map) {
		int numIndices = equation.getVariable().getDomain().getNIndices();
		
		StringBuffer sb = new StringBuffer();
		
		List<Integer> outerDims = new ArrayList<Integer>(numIndices);
		for (int i = 0; i < numIndices; i++)
			outerDims.add(dimensionWiseMin.get(i));

		mapToStringRecurse(map, sb, outerDims, 0);
		
		return sb.toString();
	}

	/**
	 * Helper function for printing the arrays.
	 * Enumerates all elements of the (sparse) array by recursion.
	 * 
	 * @param map
	 * @param sb
	 * @param outerDims
	 * @param currentDim
	 */
	private void mapToStringRecurse(Map<List<Integer>, Expression> map, StringBuffer sb, List<Integer> outerDims, int currentDim) {
		int numIndices = equation.getVariable().getDomain().getNIndices();
		if (currentDim == numIndices-1) {
			sb.append(lastRowToString(map, outerDims, currentDim));
			sb.append("\n");
		} else {
			for (int i = dimensionWiseMin.get(currentDim); i <= dimensionWiseMax.get(currentDim); i++) {
				outerDims.set(currentDim, i);
				
				if (currentDim+1 == numIndices-1 && numIndices>2) {
					sb.append(outerDims.subList(0, currentDim).toString());
					sb.append("\n");
				}
				
				mapToStringRecurse(map, sb, outerDims, currentDim+1);
			}
		}
	}
	

	/**
	 * Helper function for printing the coefficients.
	 * 
	 * 
	 * @param map
	 * @param outerDims
	 * @param lastDim
	 * @return
	 */
	private String lastRowToString(Map<List<Integer>, Expression> map, List<Integer> outerDims, int lastDim) {
		StringBuffer sb = new StringBuffer("[");
		List<Integer> vec = new ArrayList<Integer>(outerDims.size()+1);
		for (int v : outerDims) {
			vec.add(v);
		}
		
		for (int i = dimensionWiseMin.get(lastDim); i <= dimensionWiseMax.get(lastDim); i++) {
			if (sb.length() > 1) sb.append(", ");
			
			vec.set(lastDim, i);
	
			if (map.containsKey(vec)) {
				sb.append(exprToString(map.get(vec)));
			} else {
				sb.append("0");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Specialized pretty printer for the limited subset of Alpha expressions
	 * expected to show up in convolutions.
	 * 
	 * @param expr
	 * @return
	 */
	private String exprToString(Expression expr) {
		if (expr instanceof BinaryExpression) {
			String lexpr = exprToString(((BinaryExpression) expr).getLexp());
			String rexpr = exprToString(((BinaryExpression) expr).getRexp());
			String op    = OPS.toString(((BinaryExpression) expr).getOperator());
			return "(" + lexpr + " " + op + " " + rexpr + ")";
		} else if (expr instanceof DependenceExpression) {
			if (((DependenceExpression) expr).getExpr() instanceof VariableExpression) {
				VariableExpression varExpr = (VariableExpression)((DependenceExpression) expr).getExpr();
				
				return varExpr.getVarDecl().getName() + ((DependenceExpression) expr).getDep().getExpressions();
			} else {
				return PolyhedralIRToAlphabets.toString(((DependenceExpression) expr).getExpr());
			}
		} else if (expr instanceof VariableExpression) {
			VariableDeclaration varDecl = ((VariableExpression) expr).getVarDecl();
			return varDecl.getName() + equation.getVariable().getDomain().getIndexNames();
		}
		
		return PolyhedralIRToAlphabets.toString(expr);
	}
	
}
