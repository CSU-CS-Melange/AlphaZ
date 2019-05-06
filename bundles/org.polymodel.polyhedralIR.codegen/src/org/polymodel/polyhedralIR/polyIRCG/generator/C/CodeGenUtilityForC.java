package org.polymodel.polyhedralIR.polyIRCG.generator.C;

import java.util.List;

import org.polymodel.DimensionsManager;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.OPS;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.factory.PolyhedralIRModule;
import org.polymodel.polyhedralIR.util.PolyModelToAlphabets;

public class CodeGenUtilityForC {
	


	/**
	 * Return a C boolean expression representing constraints of the given
	 * domain.
	 */
	public static String getConstraintsInC(Domain domain, List<String> indexNames) {
		DimensionsManager manager = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
		
		StringBuffer sb = new StringBuffer();

		//Union of polyhedron
		for (IntConstraintSystem ilcs : domain.getPMdomain().getPolyhedra()) {
			//union
			if (sb.length() > 0) {
				sb.append(" || ");
			}
			sb.append("(");
			//Foreach constraint
			boolean first = true;
			for (IntConstraint ilc : ilcs.getConstraints()) {
				//intersecion
				if (!first) {
					sb.append(" && ");
				} else {
					first = false;
				}
				String str = PolyModelToAlphabets.print(ilc, OUTPUT_FORMAT.C, domain.getParamNames(), indexNames);
				sb.append(str);
//				sb.append(ilc.toString(ilc, OUTPUT_FORMAT.C, indexNames));
			}
			sb.append(")");
		}

		return sb.toString();
	}

	/**
	 * Return a C expression representing the given function
	 */
	public static String getFunctionInC(AffineFunction func) {
		StringBuffer sb = new StringBuffer();

		for (AffineExpression expr : func.getExpressions()) {
			if (sb.length() > 0) {
				sb.append(",");
			}
			sb.append(expr.toString());
		}

		return sb.toString();
	}
	

	/**
	 * Returns true if the given operator is available as infix operator in C.
	 * 
	 * @param op
	 * @return
	 */
	public static boolean isInfixInC(OP op) {
		switch (op) {
			case ADD:
			case SUB:
			case DIV:
			case MUL:
			case EQ:
			case LT:
			case LE:
			case GT:
			case GE:
			case NE:
			case AND:
			case OR:
				return true;
			case MAX:
			case MIN:
			case MOD:
				return false;
		}
		throw new RuntimeException("In isInfixInC : " + op + " is not handled");
	}
	
	public static boolean isFixedFunctionInC(OP op){
		switch (op) {
			case MAX:
			case MIN:
				return true;
			case MOD:
				return false;
		}
			
		throw new RuntimeException("In isFixedFunctionInC : " + op + " is not handled");
	}
	
	/**
	 * Returns C operator string for the given binary operator.
	 * 
	 * @param op
	 * @return
	 */
	public static String getBinaryOperatorInC(OP op) {
		switch (op) {
			case AND:
				return "&&";
			case OR:
				return "||";
			case XOR:
				return "^";
			case MOD:
				return "MOD";
			default:
				return OPS.toString(op);
		}
	}
	
	/**
	 * Returns C operator function string for a given binary operator with a given data type
	 * @param op
	 * @param type
	 * @return
	 */
	public static String getBinaryOperatorFunctionInC(OP op, Type type){
		String type_string = type.getCName().replace(' ', '_');
		String function_name = "__" + OPS.toString(op) + "_" + type_string;
		
		return function_name;
	}

	/**
	 * Returns C operator string for the given multi-arg operator.
	 * Since multi-arg operators are not generally available in C,
	 * the string returned by this method relies on the default preamble.
	 * 
	 * @param op
	 * @return
	 */
	public static String getMultiArgOperatorInC(OP op) {
		return OPS.toStringMultiArg(op);
	}
	
	
	/**
	 * 
	 * @param op
	 * @param variable
	 * @param expr
	 * @return
	 */
	public static String createAccumulation(OP op, Type type, String variable, String expr) {
		String binop = getBinaryOperatorInC(op);
		
		if (isInfixInC(op)) {
			return variable + " = ("+variable+")"+binop+"("+expr+")";
		} else {
			if(isFixedFunctionInC(op)){
				binop = getBinaryOperatorFunctionInC(op, type);
			}
			
			//use temp variable to avoid re-computation (expressions might have function calls)
			return "{" + type + " __temp__ = "+expr+"; "+ variable + " = "+binop+"("+variable+",__temp__); }";
		}
	}
	
	protected static String strMul(String str, int mul) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < mul; i++) {
			sb.append(str);
		}
		
		return sb.toString();
	}
	
	/////////////////////////////////////Utility funtion for Tiling/////
	/**
	 * Filter out the ordering dimensions with the ordering prefix
	 * @param orderingDimensions
	 * @param orderingPrefix
	 * @param start
	 * @param end
	 */
	public static int orderingDimensionFilter(List<Integer> orderingDimensions, List<Integer> orderingPrefix, int dim, boolean forward){
		int global_dim = dim;
		if(orderingPrefix.size() > 0){
			global_dim = orderingDimensions.get(orderingPrefix.size()) + dim + 1;
		}
		//move the global dimension to the first non ordering dimensions
		if(forward){
			while(orderingDimensions.contains(global_dim))	global_dim++;
		}else{
			while(orderingDimensions.contains(global_dim))	global_dim--;
		}
		
		int final_dim = global_dim;
		for(int i = 0; i < orderingDimensions.size(); i++){
			if(orderingDimensions.get(i) < global_dim)	final_dim--;
		}
		
		return final_dim;
	}
}
