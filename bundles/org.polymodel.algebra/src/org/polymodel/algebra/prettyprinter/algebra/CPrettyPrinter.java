package org.polymodel.algebra.prettyprinter.algebra;

import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.CompositeIntExpression;
import org.polymodel.algebra.CompositeOperator;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.IntTerm;
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

public class CPrettyPrinter extends AbstractPrettyPrinter {
	
	public CPrettyPrinter() {
		super();
	}
	
	public CPrettyPrinter(IVariableResolver resolver) {
		super(resolver);
	}
	
	public void visitIntTerm(IntTerm i) {
		buffer.append(i.getCoef());
	}

	public void visitIntConstraint(IntConstraint intConstraint) {
		intConstraint = formatConstraint(intConstraint);
		
		switch (intConstraint.getComparisonOperator().getValue()) {
		case ComparisonOperator.EQ_VALUE:
			intConstraint.getLhs().accept(this);
			buffer.append(" == ");
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
		if(i.getConstraints().size()==0) buffer.append("1");
		separateEncapsulated(i.getConstraints(), " && ");
	}

	public void visitAffineExpression(AffineExpression a) {
		separateAffine(a.getTerms());
	}

	public void visitAffineTerm(AffineTerm affineTerm) {
		if (affineTerm.getCoef() == 0 && affineTerm.getVariable() != null) return;
		if (affineTerm.getCoef() == 0 && affineTerm.getVariable() == null) {buffer.append("0"); return; }
		if (affineTerm.getCoef() == -1) {
			buffer.append("-");
			if (affineTerm.getVariable() == null) {
				buffer.append("1");
			}
		} else if (affineTerm.getVariable() == null || affineTerm.getCoef() != 1) {
			buffer.append(affineTerm.getCoef());
			if (affineTerm.getVariable() != null) buffer.append("*");
		}
		Variable var = affineTerm.getVariable();
		if (var != null) {
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
			buffer.append("ceild(");
			simpleQuasiAffineTerm.getExpression().accept(this);
			buffer.append(", " + simpleQuasiAffineTerm.getCoef() + ")");
			break;
		case QuasiAffineOperator.DIV_VALUE:
			buffer.append("(");
			simpleQuasiAffineTerm.getExpression().accept(this);
			buffer.append(") / " + simpleQuasiAffineTerm.getCoef());
			break;
		case QuasiAffineOperator.FLOOR_VALUE:
			buffer.append("(");
			simpleQuasiAffineTerm.getExpression().accept(this);
			buffer.append(") / " + simpleQuasiAffineTerm.getCoef());
			break;
		case QuasiAffineOperator.MOD_VALUE:
			buffer.append("(");
			simpleQuasiAffineTerm.getExpression().accept(this);
			buffer.append(") % " + simpleQuasiAffineTerm.getCoef());
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
			buffer.append("ceild(");
			nestedQuasiAffineTerm.getExpression().accept(this);
			buffer.append(", " + nestedQuasiAffineTerm.getCoef() + ")");
			break;
		case QuasiAffineOperator.DIV_VALUE:
			buffer.append("(");
			nestedQuasiAffineTerm.getExpression().accept(this);
			buffer.append(") / " + nestedQuasiAffineTerm.getCoef());
			break;
		case QuasiAffineOperator.FLOOR_VALUE:
			buffer.append("(");
			nestedQuasiAffineTerm.getExpression().accept(this);
			buffer.append(") / " + nestedQuasiAffineTerm.getCoef());
			break;
		case QuasiAffineOperator.MOD_VALUE:
			nestedQuasiAffineTerm.getExpression().accept(this);
			buffer.append(" - " + nestedQuasiAffineTerm.getCoef() + " * ((");
			nestedQuasiAffineTerm.getExpression().accept(this);
			buffer.append(") / " + nestedQuasiAffineTerm.getCoef() + ")");
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
				buffer.append("(");
				buffer.append(p.getNumerator());
				buffer.append(")");
			}
			if (p.getNumerator() != -1 && p.getVariables().size() > 0)
				buffer.append("*");
		}
		
		separate(p.getVariables(), "*");
		
		if (p.getDenominator() != 1)
			buffer.append("/ " + p.getDenominator());
		
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
			case ReductionOperator.MAX_VALUE:
				this.separateAsNestedBinaryExpressions(
						reductionExpression.getExpressions(), ",", "max");
				break;
			case ReductionOperator.MIN_VALUE:
				this.separateAsNestedBinaryExpressions(
						reductionExpression.getExpressions(), ",", "min");
				break;
			case ReductionOperator.PROD_VALUE:
	
	//			if (reductionExpression.getExpressions().size() == 2) {
	//				specialCaseForSymbolicDivision(reductionExpression);
	//			} else {
					this.separateEncapsulated(reductionExpression.getExpressions(),
							" * ");
	//			}
				break;
			case ReductionOperator.SUM_VALUE:
				this.separate(reductionExpression.getExpressions(), " + ");
				break;
			default:
				throw new UnsupportedOperationException();
		}
	}

//	// special case to handle symbolic division FIXME
//	private void specialCaseForSymbolicDivision(
//			ReductionExpression reductionExpression) {
//
//		// affine numerator
//		IntExpression exprA = reductionExpression.getExpressions().get(0);
//		boolean specialCase = false;
//		AffineTerm aterm = null;
//		if (exprA instanceof AffineExpression) {
//			if (((AffineExpression) exprA).getTerms().size() == 1) {
//				aterm = ((AffineExpression) exprA).getTerms().get(0);
//			}
//		}
//		// some divisor with polynomial coefficient -1
//		IntExpression exprB = reductionExpression.getExpressions().get(1);
//		PolynomialTerm pterm = null;
//		if (exprB instanceof PolynomialExpression) {
//			if (((PolynomialExpression) exprB).getTerms().size() == 1) {
//				pterm = ((PolynomialExpression) exprB).getTerms().get(0);
//				if (pterm.getCoef() == -1) {
//					specialCase = true;
//				}
//			}
//		}
//		// when both conditions match
//		if (specialCase) {
//			this.visitAffineTerm(aterm);
//			buffer.append("/(");
//			if (pterm instanceof SimplePolynomialTerm) {
//				this.visitVariable(((SimplePolynomialTerm) pterm).getVariable());
//			} else if (pterm instanceof NestedPolynomialTerm) {
//				if (((NestedPolynomialTerm) pterm).getExpression() instanceof AffineExpression) {
//					this.visitAffineExpression((AffineExpression) ((NestedPolynomialTerm) pterm)
//							.getExpression());
//				} else if (((NestedPolynomialTerm) pterm).getExpression() instanceof ReductionExpression) {
//					this.visitReductionExpression((ReductionExpression) ((NestedPolynomialTerm) pterm)
//							.getExpression());
//				} else {
//					throw new RuntimeException("Not yet implemented.");
//				}
//			} else {
//				throw new RuntimeException("Not yet implemented.");
//			}
//			buffer.append(")");
//
//		} else {
//			this.separateEncapsulated(reductionExpression.getExpressions(),
//					" * ");
//		}
//	}

	public void visitQuasiAffineTerm(QuasiAffineTerm q) {
		throw new UnsupportedOperationException("Not yet implemented");
	}
	
	public void visitIntExpression(IntExpression ie) {
		buffer.append(ie.toString(OUTPUT_FORMAT.C));
	}
	
	@Override
	public void visitCompositeIntExpression(CompositeIntExpression r) {
		switch(r.getOperator().getValue()){
		case CompositeOperator.CEIL_VALUE:
			buffer.append("ceild(");
			break;
		case CompositeOperator.FLOOR_VALUE:
			buffer.append("floord(");
			break;
		case CompositeOperator.DIV_VALUE:
		case CompositeOperator.MOD_VALUE:
			break;
		default:
			throw new UnsupportedOperationException();
		}
		//append the left expression
		buffer.append("(");
		this.visitIntExpression(r.getLeft());
		buffer.append(")");
		switch(r.getOperator().getValue()){
		case CompositeOperator.DIV_VALUE:
			buffer.append("/(");
			break;
		case CompositeOperator.MOD_VALUE:
			buffer.append("%(");
			break;
		case CompositeOperator.CEIL_VALUE: 
		case CompositeOperator.FLOOR_VALUE:
			buffer.append(",(");
			break;
		default:
			throw new UnsupportedOperationException();
		}
		this.visitIntExpression(r.getRight());
		buffer.append(")");
		
		switch(r.getOperator().getValue()){
		case CompositeOperator.CEIL_VALUE:
		case CompositeOperator.FLOOR_VALUE:
			buffer.append(")");
			break;
		case CompositeOperator.DIV_VALUE:
		case CompositeOperator.MOD_VALUE:
			break;
		default:
			throw new UnsupportedOperationException();
		}
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
