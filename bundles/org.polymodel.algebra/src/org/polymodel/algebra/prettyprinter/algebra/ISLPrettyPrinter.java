package org.polymodel.algebra.prettyprinter.algebra;

import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.CompositeIntExpression;
import org.polymodel.algebra.CompositeOperator;
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

public class ISLPrettyPrinter extends AbstractPrettyPrinter {
	
	public ISLPrettyPrinter() {
		super();
	}

	public ISLPrettyPrinter(IVariableResolver resolver) {
		super(resolver);
	}

	public void visitIntConstraint(IntConstraint intConstraint) {
		switch (intConstraint.getComparisonOperator().getValue()) {
		case ComparisonOperator.EQ_VALUE:
			intConstraint.getLhs().accept(this);
			buffer.append(" = ");
			intConstraint.getRhs().accept(this);
			break;
		case ComparisonOperator.GT_VALUE:
			intConstraint.getLhs().accept(this);
			buffer.append(" > ");
			intConstraint.getRhs().accept(this);
			break;
		case ComparisonOperator.GE_VALUE:
			intConstraint.getLhs().accept(this);
			buffer.append(" >= ");
			intConstraint.getRhs().accept(this);
			break;
		case ComparisonOperator.LE_VALUE:
			intConstraint.getLhs().accept(this);
			buffer.append(" <= ");
			intConstraint.getRhs().accept(this);
			break;
		case ComparisonOperator.LT_VALUE:
			intConstraint.getLhs().accept(this);
			buffer.append(" < ");
			intConstraint.getRhs().accept(this);
			break;
		case ComparisonOperator.NE_VALUE:
			intConstraint.getLhs().accept(this);
			buffer.append(" != ");
			intConstraint.getRhs().accept(this);
			break;
		default:
			throw new UnsupportedOperationException("Not yet implemented");
		}
	}

	public void visitIntConstraintSystem(IntConstraintSystem i) {
		separateEncapsulated(i.getConstraints(), " and ");
	}

	public void visitAffineExpression(AffineExpression a) {
		separateAffine(a.getTerms());
	}

	public void visitAffineTerm(AffineTerm affineTerm) {
		if (Math.abs(affineTerm.getCoef()) != 1 || affineTerm.getVariable() == null) {
			buffer.append(affineTerm.getCoef());
		}
		Variable var = affineTerm.getVariable();
		if (var != null) {
			if (affineTerm.getCoef() == -1) {
				buffer.append("-");
			} else if (affineTerm.getCoef() != 1) {
				buffer.append("*");
			}
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
			System.err.println("Warning : misuse of CEIL instead of DIV in quasi affine expression "+simpleQuasiAffineTerm);
			if (simpleQuasiAffineTerm.getCoef() != 1) {
				buffer.append("[(");
				simpleQuasiAffineTerm.getExpression().accept(this);
				buffer.append(") / " + simpleQuasiAffineTerm.getCoef()+"]");
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
		separatePolynomial(p.getTerms());
	}

	public void visitPolynomialTerm(PolynomialTerm p) {
		if (p.getNumerator() == 0) {
			buffer.append("0");
			return;
		}

		if (p.getNumerator() != 1 || p.getVariables().size() == 0) {
			if (p.getNumerator() == -1 && p.getVariables().size() > 0) {
				buffer.append("-");
			} else {
				buffer.append(p.getNumerator());
			}
			if (p.getNumerator() == -1 && p.getVariables().size() > 0)
				buffer.append(" * ");
		}
		
		separate(p.getVariables(), " * ");
		
		if (p.getDenominator() != 1)
			buffer.append("/" + p.getDenominator());
	}
	
	@Override
	public void visitPolynomialVariable(PolynomialVariable p) {
		if (p.getExponent() == 0) {
			return;
		}
		p.getVariable().accept(this);
		if (p.getExponent() != 1) {
			buffer.append("^" + p.getExponent());
		}
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
		case ReductionOperator.MIN_VALUE:
			buffer.append("min(");
			this.separate(reductionExpression.getExpressions(), " , ");
			buffer.append(")");
			break;
		case ReductionOperator.MAX_VALUE:
			buffer.append("max(");
			this.separate(reductionExpression.getExpressions(), " , ");
			buffer.append(")");
			break;
		default:
			throw new UnsupportedOperationException();
		}
	}

	public void visitQuasiAffineTerm(QuasiAffineTerm q) {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	public void visitIntExpression(IntExpression ie) {
		throw new UnsupportedOperationException("Not yet implemented");
	}
	
	@Override
	public void visitCompositeIntExpression(CompositeIntExpression r) {
		buffer.append("(");
		r.getLeft().accept(this);
		buffer.append(")"+(r.getOperator()==CompositeOperator.MOD?"%":"/")+"(");
		r.getRight().accept(this);
		buffer.append(")");
//		throw new UnsupportedOperationException("Not yet Implemented");
	}

	@Override
	public void visitSelectExpression(SelectExpression ie) {
		buffer.append("(");
		for ( IntConstraintSystem ics : ie.getCondition() )
			ics.accept(this);
		buffer.append(")?(");
		ie.getThen().accept(this);
		buffer.append("):(");
		ie.getElse().accept(this);
		buffer.append(")");
	}

}
