package org.polymodel.algebra.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;

public class PolymodelRegexParser {
	
	

	public static void main(String[] args) {
		
		List<Variable> vars = new ArrayList<Variable>();
		vars.add(IntExpressionBuilder.var("i"));
		vars.add(IntExpressionBuilder.var("j"));
		vars.add(IntExpressionBuilder.var("k"));
		vars.add(IntExpressionBuilder.var("N"));
		vars.add(IntExpressionBuilder.var("M"));
		vars.add(IntExpressionBuilder.var("i0"));
		vars.add(IntExpressionBuilder.var("j0"));
		vars.add(IntExpressionBuilder.var("k0"));
		vars.add(IntExpressionBuilder.var("i_p"));
		vars.add(IntExpressionBuilder.var("j_p"));
		vars.add(IntExpressionBuilder.var("k_p"));

		System.out.println(parseAffineExpression("-5j+2i+5+j-j+9+0+0M", vars));
		System.out.println(parseAffineExpression("i0+j0+i_p+0j0", vars));
	}

	public static AffineExpression parseAffineExpression(String exprStr, List<Variable> vars, List<Variable> params) {
		List<Variable> combined = new ArrayList<Variable>(vars.size() + params.size());
		combined.addAll(vars);
		combined.addAll(params);
		return parseAffineExpression(exprStr, combined);
	}
	
	public static AffineExpression parseAffineExpression(String exprStr, List<Variable> vars) {
		Map<String, Variable> varMap = new TreeMap<String, Variable>();
		
		for (Variable var : vars) {
			if (varMap.containsKey(var.getName())) {
				throw new RuntimeException("Duplicate variable: " + var.getName());
			}
			varMap.put(var.getName(), var);
		}
		
		//remove spaces
		exprStr = exprStr.replaceAll("\\s", "");
		//check if input matches affine expression
		{
			if (exprStr.length() > 0 && !exprStr.matches("((\\+|-)?(\\d*)[\\w_][\\w\\d_]*)+")) {
				throw new RuntimeException("Expression " + exprStr + " is not an affine expression.");
			}
		}
		
		//parse one by one
		AffineExpression affine = IntExpressionBuilder.affine();
		Pattern pattern = Pattern.compile("(?:(\\+|-)?(\\d*)([\\w_][\\w\\d_]*)?)([\\+-].+)*");
		Matcher matcher = pattern.matcher(exprStr);
		while (matcher.matches()) {
//			System.out.println(exprStr);
//			System.out.println(matcher.groupCount());
//			System.out.println(matcher.group(1));
//			System.out.println(matcher.group(2));
//			System.out.println(matcher.group(3));
//			System.out.println(matcher.group(4));
			
			//group1 -- sign
			final long sign;
			if (matcher.group(1) == null || matcher.group(1).length() == 0 || matcher.group(1).contentEquals("+")) {
				sign = 1;
			} else {
				sign = -1;
			}
			
			//group2 -- coef
			final long coef;
			if (matcher.group(2) == null || matcher.group(2).length() == 0) {
				coef = 1;
			} else {
				coef = Long.parseLong(matcher.group(2));
			}

			//group3 -- id
			final Variable id;
			if (matcher.group(3) == null) {
				id = null;
			} else {
				id = varMap.get(matcher.group(3));
				if (id == null) throw new RuntimeException("Undefined variable: " + matcher.group(3));
			}
			
			//create term
			affine.getTerms().add(IntExpressionBuilder.term(sign*coef, id));
			
			//group4 -- remainder
			exprStr = matcher.group(4);
			
			if (exprStr == null) break;
			
			matcher = pattern.matcher(exprStr);
		}
		
		return affine;
		
	}
}
