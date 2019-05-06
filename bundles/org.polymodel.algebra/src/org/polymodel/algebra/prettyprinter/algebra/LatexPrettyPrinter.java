package org.polymodel.algebra.prettyprinter.algebra;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.polymodel.algebra.AlgebraVisitable;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.CompositeIntExpression;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.SelectExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.polynomials.PolynomialExpression;
import org.polymodel.algebra.polynomials.PolynomialTerm;
import org.polymodel.algebra.polynomials.PolynomialVariable;
import org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm;
import org.polymodel.algebra.quasiAffine.QuasiAffineExpression;
import org.polymodel.algebra.quasiAffine.QuasiAffineOperator;
import org.polymodel.algebra.quasiAffine.QuasiAffineTerm;
import org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm;
import org.polymodel.algebra.reductions.ReductionExpression;
import org.polymodel.algebra.reductions.ReductionOperator;

public class LatexPrettyPrinter extends AbstractPrettyPrinter {
	private boolean inSystem = true;
	private Map<String, String> variablesNamesMapping=new HashMap<String, String>();
	
	public LatexPrettyPrinter() {
		this(true);
	}
	
	public LatexPrettyPrinter(IVariableResolver resolver) {
		super(resolver);
	}

	public LatexPrettyPrinter(boolean inSystem) {
		this.inSystem = inSystem;
	}

	
	public Map<String, String> getVariablesNamesMapping() {
		return variablesNamesMapping;
	}

	public void setVariablesNamesMapping(Map<String, String> variablesNamesMapping) {
		this.variablesNamesMapping = variablesNamesMapping;
	}

	@Override
	public String print(AlgebraVisitable object) {
		String res = super.print(object);
		res = res.replace("+ -", "-");
		for(Entry<String, String> e: variablesNamesMapping.entrySet()){
			res = res.replace(e.getKey(), e.getValue());
		}
		return res;
	}

	
	public void addVariableRenaming(String old, String name){
		this.variablesNamesMapping.put(old, name);
	}
	
	
	@Override
	protected String resolveVariable(Variable v) {
		return latexFormatVariableName(super.resolveVariable(v));
	}

	public static String latexFormatVariableName(String vName) {
		String tmp = vName.replace("___", "\\rightarrow ");
		tmp =formatExposant(tmp);
		return tmp;
	}
	
	public static String formatLatexVariables(String s,List<Variable> vars){
		String res = s;
		for(Variable v: vars){
			res = res.replace(v.getName(), latexFormatVariableName(v.getName()));
		}
		return res;
	}
	
	private static String formatExposant(String name) {
		StringBuffer buffer = new StringBuffer();
		String[] split = name.split("__");
		if (split.length > 1) {
			if (isLatexVariable(split[0]))
				buffer.append("\\");
			buffer.append(split[0]);
			String[] split2 = split[1].split("_");
			buffer.append("^{").append(split2[0]).append("}");

			for (int i = 1; i < split2.length; i++) {
				buffer.append("_" + "{").append(split2[i]);
			}
			for (int i = 1; i < split2.length; i++) {
				buffer.append("}");
			}
		} else {
			return format(split[0], "_", "_");
		}
		return buffer.toString();
	}

	private static String format(String name, String key, String symbol) {
		StringBuffer buffer = new StringBuffer();
		String[] split = name.split(key);
		if (isLatexVariable(split[0]))
			buffer.append("\\");
		buffer.append(split[0]);
		for (int i = 1; i < split.length; i++) {
			buffer.append(symbol + "{").append(split[i]);
		}
		for (int i = 1; i < split.length; i++) {
			buffer.append("}");
		}
		return buffer.toString();
	}

	private static boolean isLatexVariable(String s) {
		for (String v : LATEX_VARIABLES) {
			if (v.equals(s))
				return true;
		}
		return false;
	}

	private final static String[] LATEX_VARIABLES = { "alpha", "mu", "theta",
			"gamma", "lambda", "delta", "phi","beta"};

	private String separator(IntConstraint c) {
		if (inSystem && (c.eContainer() instanceof IntConstraintSystem))
			return " & ";
		return " ";
	}

	public void visitIntConstraint(IntConstraint c) {
		if (c.eContainer() instanceof IntConstraintSystem) {
			switch (c.getComparisonOperator().getValue()) {
			case ComparisonOperator.EQ_VALUE:
				c.getLhs().accept(this);
				buffer.append(separator(c) + "=" + separator(c));
				c.getRhs().accept(this);
				break;
			case ComparisonOperator.GT_VALUE:
				c.getLhs().accept(this);
				buffer.append(separator(c) + ">" + separator(c));
				c.getRhs().accept(this);
				break;
			case ComparisonOperator.GE_VALUE:
				c.getLhs().accept(this);
				buffer.append(separator(c) + "\\ge" + separator(c));
				c.getRhs().accept(this);
				break;
			case ComparisonOperator.LE_VALUE:
				c.getLhs().accept(this);
				buffer.append(separator(c) + "\\le" + separator(c));
				c.getRhs().accept(this);
				break;
			case ComparisonOperator.LT_VALUE:
				c.getLhs().accept(this);
				buffer.append(separator(c) + "<" + separator(c));
				c.getRhs().accept(this);
				break;
			case ComparisonOperator.NE_VALUE:
				c.getLhs().accept(this);
				buffer.append(separator(c) + "\\ne" + separator(c));
				c.getRhs().accept(this);
				break;
			default:
				throw new UnsupportedOperationException("Not yet implemented");
			}
		}
	}

	public void visitIntConstraintSystem(IntConstraintSystem i) {
		buffer.append("\\left \\{ \n" + "\\begin{array}{r c l}\n");
		separate(i.getConstraints(), " \\\\ \n ");
		buffer.append("\\end{array}\n" + "\\right.");
	}

	public void visitAffineExpression(AffineExpression a) {
		separate(a.getTerms(), " + ");
	}

	public void visitAffineTerm(AffineTerm affineTerm) {
		if (Math.abs(affineTerm.getCoef()) != 1
				|| affineTerm.getVariable() == null) {
			if (affineTerm.getCoef() < 1000)
				buffer.append(affineTerm.getCoef());
			else
				buffer.append("K");
		}
		Variable var = affineTerm.getVariable();
		if (var != null) {
			if (affineTerm.getCoef() == -1)
				buffer.append("-");
			var.accept(this);
		}
	}

	public void visitQuasiAffineExpression(QuasiAffineExpression q) {
		separate(q.getTerms(), " + ");
	}

	public void visitSimpleQuasiAffineTerm(
			SimpleQuasiAffineTerm simpleQuasiAffineTerm) {
		switch (simpleQuasiAffineTerm.getOperator().getValue()) {
		case QuasiAffineOperator.CEIL_VALUE:
			buffer.append("[");
			simpleQuasiAffineTerm.getExpression().accept(this);
			buffer.append(" / " + simpleQuasiAffineTerm.getCoef() + "] + "
					+ (simpleQuasiAffineTerm.getCoef() - 1));
			break;
		case QuasiAffineOperator.DIV_VALUE:
			if (simpleQuasiAffineTerm.getCoef() != 1) {
				buffer.append("(");
				simpleQuasiAffineTerm.getExpression().accept(this);
				buffer.append(") / " + simpleQuasiAffineTerm.getCoef());
			} else {
				simpleQuasiAffineTerm.getExpression().accept(this);
			}
			break;
		case QuasiAffineOperator.FLOOR_VALUE:
			buffer.append("[(");
			simpleQuasiAffineTerm.getExpression().accept(this);
			buffer.append(") / " + simpleQuasiAffineTerm.getCoef() + "]");
			break;
		case QuasiAffineOperator.MOD_VALUE:
			simpleQuasiAffineTerm.getExpression().accept(this);
			buffer.append(" - " + simpleQuasiAffineTerm.getCoef() + " * [(");
			simpleQuasiAffineTerm.getExpression().accept(this);
			buffer.append(") / " + simpleQuasiAffineTerm.getCoef() + "]");
			break;
		case QuasiAffineOperator.MUL_VALUE:
			buffer.append("(");
			simpleQuasiAffineTerm.getExpression().accept(this);
			buffer.append(") * " + simpleQuasiAffineTerm.getCoef());
			break;
		default:
			throw new UnsupportedOperationException();
		}
	}

	public void visitNestedQuasiAffineTerm(
			NestedQuasiAffineTerm nestedQuasiAffineTerm) {
		switch (nestedQuasiAffineTerm.getOperator().getValue()) {
		case QuasiAffineOperator.CEIL_VALUE:
			buffer.append("[");
			nestedQuasiAffineTerm.getExpression().accept(this);
			buffer.append(" / " + nestedQuasiAffineTerm.getCoef() + "] + "
					+ (nestedQuasiAffineTerm.getCoef() - 1));
			break;
		case QuasiAffineOperator.DIV_VALUE:
			buffer.append("(");
			nestedQuasiAffineTerm.getExpression().accept(this);
			buffer.append(") / " + nestedQuasiAffineTerm.getCoef());
			break;
		case QuasiAffineOperator.FLOOR_VALUE:
			buffer.append("[(");
			nestedQuasiAffineTerm.getExpression().accept(this);
			buffer.append(") / " + nestedQuasiAffineTerm.getCoef() + "]");
			break;
		case QuasiAffineOperator.MOD_VALUE:
			nestedQuasiAffineTerm.getExpression().accept(this);
			buffer.append(" - " + nestedQuasiAffineTerm.getCoef() + " * [(");
			nestedQuasiAffineTerm.getExpression().accept(this);
			buffer.append(") / " + nestedQuasiAffineTerm.getCoef() + "]");
			break;
		case QuasiAffineOperator.MUL_VALUE:
			buffer.append("(");
			nestedQuasiAffineTerm.getExpression().accept(this);
			buffer.append(") * " + nestedQuasiAffineTerm.getCoef());
			break;
		default:
			throw new UnsupportedOperationException();
		}
	}

	public void visitPolynomialExpression(PolynomialExpression p) {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	public void visitPolynomialTerm(PolynomialTerm p) {
		throw new UnsupportedOperationException("Not yet implemented");
	}
	
	@Override
	public void visitPolynomialVariable(PolynomialVariable p) {
		throw new UnsupportedOperationException("Not yet implemented");
	}
	public void visitReductionExpression(ReductionExpression reductionExpression) {
		switch (reductionExpression.getOperator().getValue()) {
		case ReductionOperator.PROD_VALUE:
			this.separateEncapsulated(reductionExpression.getExpressions(),
					" * ");
			break;
		case ReductionOperator.SUM_VALUE:
			this.separate(reductionExpression.getExpressions(), " + ");
			break;
		default:
			throw new UnsupportedOperationException();
		}
	}

	public void visitQuasiAffineTerm(QuasiAffineTerm q) {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	public void visitIntExpression(IntExpression ie) {
		buffer.append(ie.toString(OUTPUT_FORMAT.LATEX));
	}
	
	@Override
	public void visitCompositeIntExpression(CompositeIntExpression r) {
		throw new UnsupportedOperationException("Not yet Implemented");
	}

	@Override
	public void visitSelectExpression(SelectExpression ie) {
		throw new UnsupportedOperationException("Not yet Implemented");
	}

}
