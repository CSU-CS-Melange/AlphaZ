package org.polymodel.polyhedralIR.polyIRCG.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations.Constraint;

public class CodeGenUtility {

    

	/**
	 * Converts an array of Strings to a String with each element in the array delimited by the given delimiter.
	 * 
	 * @param list
	 * @param delim
	 * @return
	 */
	public static final String toStringList(Object[] list, String delim) {
		return toStringList(java.util.Arrays.asList(list), delim);
	}
	
	/**
	 * Converts an array of Strings to a String with each element in the array delimited by the given delimiter.
	 * 
	 * @param list
	 * @param delim
	 * @return
	 */
	public static final String toStringList(Object[] list, String delim, int dim) {
		if (dim > list.length) {
			throw new RuntimeException("toStringList : Invalid dimension");
		}
		List<Object> l = new Vector<Object>();
		for (int i = 0; i < dim; i++) {
			l.add(list[i]);
		}
		return toStringList(l, delim);
	}

	/**
	 * Converts an list of Objects to a String with each element in the array delimited by the given delimiter.
	 * 
	 * @param list
	 * @param delim
	 * @return
	 */
	public static final String toStringList(List<? extends Object> list, String delim) {
		StringBuffer sb = new StringBuffer();
		
		for (Object o : list) {
			if (sb.length() > 0) {
				sb.append(delim);
			}
			sb.append(o.toString());
		}
		
		return sb.toString();
	}
	
	/**
	 * Generates a string of the form op(a,op(b,op(c,....))) given a list of arguments and operator.
	 * Assumes that the given operator is associative and commutative.
	 * 
	 * @param list
	 * @param operator
	 * @return
	 */
	public static final String toNestedBinaryExpressions(List<? extends Object> list, String operator) {
		StringBuffer sb = new StringBuffer();
		
		if (list.size() == 1) {
			sb.append(list.get(0));
		} else {
			for (int i = 0; i < list.size(); i++) {
				if (i != 0) {
					sb.append(",");
				}
				if (i != list.size()-1) {
					sb.append(operator+"(");
				}
				sb.append(list.get(i).toString());
			}
			for (int i = 0; i < list.size()-1; i++){
				sb.append(")");
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * Creates a Domain that scans slices of the reduction, parameterized by the indices in result space.
	 * Returns an array with 2 elements.
	 *  1. Extended parameter domain
	 *  2. Domain that scans slices of the reduction, where slice is parameterized by the new parameters in extended parameter domain.
	 * 
	 * The scanning domain is constructed by first taking the context domain of the expression in reduction.
	 * - Add N new parameters N is the dimension of the RHS of projection.
	 * - Construct a domain that equate new parameters to the RHS of projection
	 * - Take the intersection of above
	 * 
	 * @param r
	 * @param newParamPrefix
	 * @return
	 */
//	public static final Domain[] createReductionScanningDomain(ReduceExpression r, String newParamPrefix) {
	public static final Domain[] createReductionScanningDomain(ReduceExpression r) {
		ParameterDomain param;
		if (r.getContainerEquation() instanceof StandardEquation)
			param = ((StandardEquation)r.getContainerEquation()).getContainerSystem().getParameters();
		else
			param = ((UseEquation)r.getContainerEquation()).getContainerSystem().getParameters();
		
		try {
		//identity function in the answer space for using the generic function
		AffineFunction id = PolyhedralIRUtility.createIdentityFunction(r.getContextDomain());
		
		Domain bodyDomain = r.getExpr().getContextDomain().copy();
		//rename dimensions of the reduction body to match projection function
		{
			List<Variable> origIndices = bodyDomain.getIndices();
			List<Variable> projIndices = r.getProjection().getIndices();
			assert(origIndices.size() == projIndices.size());
		
			for (int d = 0; d < origIndices.size(); d++) {
				bodyDomain = DomainOperations.substitute(bodyDomain, origIndices.get(d), IntExpressionBuilder.affine(IntExpressionBuilder.term(projIndices.get(d))));
			}
			bodyDomain.getIndices().clear();
			bodyDomain.getIndices().addAll(projIndices);
		}
	
		//First extend the body with the reduction domain as new parameters
		Domain scanDomain = DomainOperations.extendParameterDomain(bodyDomain, r.getContextDomain());
		//Then equate indices in body with indices of reduction, that are now parameters 
		DomainOperations.addConstraintsRelatingExtendedParameterIndicesAndIndices(param,
				scanDomain, new Constraint(id, r.getProjection(), ComparisonOperator.EQ));
		
		List<String> existingIndexNames = new ArrayList<String>();
		existingIndexNames.addAll(bodyDomain.getIndexNames());
		existingIndexNames.addAll(bodyDomain.getParamNames());
		
		//Extend the parameter domain with the answer space
		Domain extendedParam = DomainOperations.extendParameterDomain(param, r.getContextDomain(), existingIndexNames);
		extendedParam = extendedParam.toParameterDomain();

//		System.out.println("reductionContext:"+r.getContextDomain());
//		System.out.println("ExtendedParam:"+extendedParam);
//		System.out.println("ScanDomain:"+scanDomain);
//		System.out.println();
//		//Parameter domain needs to be extended by the indices of the result space
//		ParameterDomain extendedParam = (ParameterDomain) r.getContainerEquation().getContainerSystem().getParameters().copy();
//
//		//Extend the domain of the reduction body with the new params as well
//		Domain extendedBodyDom = r.getExpr().getContextDomain().copy();
//		
//		List<String> newParams = new Vector<String>(r.getContextDomain().getNIndices());
//		//Function parameters to the reduction evaluation function are :
//		// program parameters + new parameters (indices of the result space) 
//		for (IVariable iv : r.getContextDomain().getIndices()) {
//			String newParam = newParamPrefix+iv.toString();
//			extendedParam.addParameterDimension(newParam);
//			extendedBodyDom.addParameterDimension(newParam);
//			newParams.add(newParam);
//		}
//
//		//Equate the new parameters to the RHS of the projection function
//		// this domain restricts the space to the points that contributes to the same answer variable
//		// where the point in the answer variable is given as parameters
//		List<String> constraints = new Vector<String>(r.getProjection().getDimRHS());
//		for (int i = 0; i < r.getProjection().getDimRHS(); i++) {
//			String c = newParams.get(i) + " = " + r.getProjection().getExpressions().get(i).toString();
//			constraints.add(c);
//		}
//		//Convert IVariable to String for parsing
//		List<String> ids = new Vector<String>(r.getProjection().getDimLHS());
//		for (IVariable iv : r.getProjection().getIndices()) {
//			ids.add(iv.toString());
//		}
//		Domain functionDom = PolyhedralIRUserFactory.eINSTANCE.createDomain(extendedParam, ids, constraints);
//		
//		//Body of the evaluation of reduction
//		// take intersection of the domain of the body, and the domain created from projection
//		Domain scanDomain = extendedBodyDom.intersection(functionDom);
//		
		Domain[] outputs = new Domain[]{extendedParam, scanDomain};
		return outputs;
		} catch (RuntimeException re) {
			re.printStackTrace();
			throw re;
		}
	}

	public static String getCPrintfSpecifier(Type type) {
		return type.getCPrintfSpecifier();
	}
	
	public static String createStatementName(CodeUnit unit, int number) {
		String currentPrefix = CodeGenConstants.statementPrefix;
		String candidate;
		boolean changed;
		do {
			changed = false;
			candidate = currentPrefix + number;
			for (AbstractVariable v :unit.getVariables()) {
				//keep adding '_'s if name conflicts with some variable
				if (v.getName().compareTo(candidate) == 0) {
					currentPrefix = currentPrefix + "_";
					changed = true;
					break;
				}
			}
		} while (changed);
		
		return candidate;
	}
}
