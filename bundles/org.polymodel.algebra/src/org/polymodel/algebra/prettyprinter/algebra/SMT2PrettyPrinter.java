package org.polymodel.algebra.prettyprinter.algebra;

import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.quasiAffine.QuasiAffineTerm;
import org.polymodel.algebra.reductions.ReductionExpression;
import org.polymodel.algebra.reductions.ReductionOperator;

public class SMT2PrettyPrinter  extends ISLPrettyPrinter {
	
	public SMT2PrettyPrinter() {
		super();
	}

	public SMT2PrettyPrinter(IVariableResolver resolver) {
		super(resolver);
	}

	public void visitIntConstraint(IntConstraint intConstraint) {
		switch (intConstraint.getComparisonOperator().getValue()) {
		case ComparisonOperator.EQ_VALUE:
			buffer.append("(= ");
			intConstraint.getLhs().accept(this);
			buffer.append(" ");
			intConstraint.getRhs().accept(this);
			buffer.append(")");
			break;
		case ComparisonOperator.GT_VALUE:
			buffer.append("(> ");
			intConstraint.getLhs().accept(this);
			buffer.append(" ");
			intConstraint.getRhs().accept(this);
			buffer.append(")");
			break;
		case ComparisonOperator.GE_VALUE:
			buffer.append("(>= ");
			intConstraint.getLhs().accept(this);
			buffer.append(" ");
			intConstraint.getRhs().accept(this);
			buffer.append(")");
			break;
		case ComparisonOperator.LE_VALUE:
			buffer.append("(<= ");
			intConstraint.getLhs().accept(this);
			buffer.append(" ");
			intConstraint.getRhs().accept(this);
			buffer.append(")");
			break;
		case ComparisonOperator.LT_VALUE:
			buffer.append("(< ");
			intConstraint.getLhs().accept(this);
			buffer.append(" ");
			intConstraint.getRhs().accept(this);
			buffer.append(")");
			break;
		case ComparisonOperator.NE_VALUE:
			buffer.append("(!= ");
			intConstraint.getLhs().accept(this);
			buffer.append(" ");
			intConstraint.getRhs().accept(this);
			buffer.append(")");
			break;
		default:
			throw new UnsupportedOperationException("Not yet implemented");
		}
	}

	public void visitIntConstraintSystem(IntConstraintSystem i) {
		if (i.getConstraints().size() > 1)
			buffer.append("(and ");
		separate(i.getConstraints(), " ");
		if (i.getConstraints().size() > 1)
			buffer.append(")");
	}

	public void visitAffineExpression(AffineExpression a) {
		if (a.getTerms().size() > 1) {
			buffer.append("(+ ");
			separate(a.getTerms(), " ");
			buffer.append(")");
		} else {
			a.getTerms().get(0).accept(this);
		}
	}

	public void visitAffineTerm(AffineTerm affineTerm) {
		boolean useMult = false;
		
		if (affineTerm.getCoef() != 1 || affineTerm.getVariable() == null) {
			if (affineTerm.getVariable() != null) {
				useMult = true;
				buffer.append("(* ");
			}
			if (affineTerm.getCoef() < 0) {
				buffer.append("(- ");
				buffer.append(Math.abs(affineTerm.getCoef()));
				buffer.append(")");
			} else {
				buffer.append(affineTerm.getCoef());
			}
		}
		Variable var = affineTerm.getVariable();
		if (var != null) {
			if (useMult) {
				buffer.append(" ");
			}
			var.accept(this);
		}
		if (useMult) {
			buffer.append(")");
		}

	}

	public void visitReductionExpression(ReductionExpression reductionExpression) {
		switch (reductionExpression.getOperator().getValue()) {
		case ReductionOperator.PROD_VALUE:
			buffer.append("(* ");
			this.separateEncapsulated(reductionExpression.getExpressions(),
					" ");
			buffer.append(")");
			break;
		case ReductionOperator.SUM_VALUE:
			buffer.append("(+ ");
			this.separate(reductionExpression.getExpressions(), " ");
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
		buffer.append(ie.toString(OUTPUT_FORMAT.C));
	}
}
