package org.polymodel.algebra.tom;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.polynomials.PolynomialExpression;
import org.polymodel.algebra.polynomials.PolynomialVariable;
import org.polymodel.algebra.quasiAffine.QuasiAffineExpression;
import org.polymodel.algebra.reductions.ReductionExpression;

@SuppressWarnings("all")
public class EquivalentIntExpression {

	%include { sl.tom }
	%include { long.tom}
	%include { algebra_common.tom}
	%include { algebra_terminals.tom}
	%include { algebra_all_ops.tom}

	private static boolean VERBOSE = false;

	private static boolean isEquivalent;
	private static boolean isDecidable;

	public static FuzzyBoolean isEquivalent(IntExpression intExpression1, IntExpression intExpression2) {
		try {
			isEquivalent = false;
			isDecidable = false; 
			if(VERBOSE)
				System.out.println("*** isEquivalent : \n\t"+intExpression1 + "\n\t" + intExpression2);
			IntConstraint intConstraint = IntExpressionBuilder.constraint(intExpression1, intExpression2, ComparisonOperator.EQ);
			`Outermost(IsEquivalent()).visitLight(intConstraint, tom.mapping.GenericIntrospector.INSTANCE);
			if(VERBOSE)
				System.out.println("*** decidable : "+isDecidable);
			if(VERBOSE)
				System.out.println("*** equivalent  : "+isEquivalent+"\n");
			if (!isDecidable)
				return FuzzyBoolean.MAYBE;
			else if (isEquivalent)
				return FuzzyBoolean.YES;
			else
				return FuzzyBoolean.NO;
		} catch(Exception e) {
			System.err.println("Visitor failure on "+intExpression1+ ":"+e.getMessage());
			throw new RuntimeException("Visitor failure on "+intExpression1+ ":"+e.getMessage(),e);
		}
	}

	private static void debug(String name, IntConstraint intConstraint) {
		if(VERBOSE)
			System.out.println("rule "+name+" :\n\t"+intConstraint);
	}

	private static void checkEmptiness(IntExpression intExpressionA, IntExpression intExpressionB) {
		if (intExpressionA instanceof QuasiAffineExpression && intExpressionB instanceof QuasiAffineExpression) {
			QuasiAffineExpression quasiAffineExpressionA = (QuasiAffineExpression)intExpressionA;
			QuasiAffineExpression quasiAffineExpressionB = (QuasiAffineExpression)intExpressionB;
			if (quasiAffineExpressionA.getTerms().isEmpty() && quasiAffineExpressionB.getTerms().isEmpty()) {
				isEquivalent = true;
				isDecidable = true;
			} else if (quasiAffineExpressionA.getTerms().isEmpty() || quasiAffineExpressionB.getTerms().isEmpty()) {
				isEquivalent = false;
				isDecidable = true;
			} else {
				isEquivalent = false;
				isDecidable = false;
			}
		}
		if (intExpressionA instanceof PolynomialExpression && intExpressionB instanceof PolynomialExpression) {
			PolynomialExpression polynomialExpressionA = (PolynomialExpression)intExpressionA;
			PolynomialExpression polynomialExpressionB = (PolynomialExpression)intExpressionB;
			if (polynomialExpressionA.getTerms().isEmpty() && polynomialExpressionB.getTerms().isEmpty()) {
				isEquivalent = true;
				isDecidable = true;
			} else if (polynomialExpressionA.getTerms().isEmpty() || polynomialExpressionB.getTerms().isEmpty()) {
				isEquivalent = false;
				isDecidable = true;
			} else {
				isEquivalent = false;
				isDecidable = false;
			}
		}
		if (intExpressionA instanceof ReductionExpression && intExpressionB instanceof ReductionExpression) {
			ReductionExpression reductionExpressionA = (ReductionExpression)intExpressionA;
			ReductionExpression reductionExpressionB = (ReductionExpression)intExpressionB;
			if (reductionExpressionA.getExpressions().isEmpty() && reductionExpressionB.getExpressions().isEmpty()) {
				isEquivalent = true;
				isDecidable = true;
			} else if (reductionExpressionA.getExpressions().isEmpty() || reductionExpressionB.getExpressions().isEmpty()) {
				isEquivalent = false;
				isDecidable = true;
			} else {
				isEquivalent = false;
				isDecidable = false;
			}
		}
	}

	%strategy IsEquivalent() extends Fail() {
		visit C {
			/* Affine part */
			in@eq(affine(terms(constant(a))), affine(terms(constant(a)))) -> {
				debug("R-1-1",`in);
				isEquivalent = true;
				isDecidable = true;
				return `eq(null, null);
			}
			in@eq(affine(terms(term(a, var))), affine(terms(term(a, var)))) -> {
				debug("R-1-1",`in);
				isEquivalent = true;
				isDecidable = true;
				return `eq(null, null);
			}
			in@eq(affine(terms(x1*, term(a, var), x2*)), affine(terms(x3*, term(a, var), x4*))) -> {
				debug("R-1-2",`in);
				return `eq(affine(terms(x1*, x2*)), affine(terms(x3*, x4*)));
			}
			/* QuasiAffine part */
			in@eq(qaffine(terms(ceil(rhs_exp, coef))), qaffine(terms(ceil(lhs_exp, coef)))) -> {
				debug("R-2-1-1",`in);
				return `eq(rhs_exp, lhs_exp);
			}
			in@eq(qaffine(terms(x1*, ceil(exp, coef), x2*)), qaffine(terms(x3*, ceil(exp, coef), x4*))) -> {
				debug("R-2-1-2",`in);
				checkEmptiness(`qaffine(terms(x1*, x2*)), `qaffine(terms(x3*, x4*)));
				return `eq(qaffine(terms(x1*, x2*)), qaffine(terms(x3*, x4*)));
			}
			in@eq(qaffine(terms(nceil(qaffine(terms(x1*)), coef))), qaffine(terms(nceil(qaffine(terms(x2*)), coef)))) -> {
				debug("R-2-1-3",`in);
				return `eq(qaffine(terms(x1*)), qaffine(terms(x2*)));
			}
			in@eq(qaffine(terms(x1*, nceil(qaffine(terms(x2*)), coef), x3*)), qaffine(terms(x4*, nceil(qaffine(terms(x5*)), coef), x6*))) -> {
				debug("R-2-1-4",`in);
				return `eq(qaffine(terms(x1*, x3*, x2*)), qaffine(terms(x4*, x5*, x6*)));
			}
			in@eq(qaffine(terms(div(rhs_exp, coef))), qaffine(terms(div(lhs_exp, coef)))) -> {
				debug("R-2-2-1",`in);
				return `eq(rhs_exp, lhs_exp);
			}
			in@eq(qaffine(terms(x1*, div(exp, coef), x2*)), qaffine(terms(x3*, div(exp, coef), x4*))) -> {
				debug("R-2-2-2",`in);
				checkEmptiness(`qaffine(terms(x1*, x2*)), `qaffine(terms(x3*, x4*)));
				return `eq(qaffine(terms(x1*, x2*)), qaffine(terms(x3*, x4*)));
			}
			in@eq(qaffine(terms(ndiv(qaffine(terms(x1*)), coef))), qaffine(terms(ndiv(qaffine(terms(x2*)), coef)))) -> {
				debug("R-2-2-3",`in);
				isEquivalent = true;
				return `eq(qaffine(terms(x1*)), qaffine(terms(x2*)));
			}
			in@eq(qaffine(terms(x1*, ndiv(qaffine(terms(x2*)), coef), x3*)), qaffine(terms(x4*, ndiv(qaffine(terms(x5*)), coef), x6*))) -> {
				debug("R-2-2-4",`in);
				return `eq(qaffine(terms(x1*, x3*, x2*)), qaffine(terms(x4*, x5*, x6*)));
			}
			in@eq(qaffine(terms(floor(rhs_exp, coef))), qaffine(terms(floor(lhs_exp, coef)))) -> {
				debug("R-2-3-1",`in);
				return `eq(rhs_exp, lhs_exp);
			}
			in@eq(qaffine(terms(x1*, floor(exp, coef), x2*)), qaffine(terms(x3*, floor(exp, coef), x4*))) -> {
				debug("R-2-3-2",`in);
				checkEmptiness(`qaffine(terms(x1*, x2*)), `qaffine(terms(x3*, x4*)));
				return `eq(qaffine(terms(x1*, x2*)), qaffine(terms(x3*, x4*)));
			}
			in@eq(qaffine(terms(nfloor(qaffine(terms(x1*)), coef))), qaffine(terms(nfloor(qaffine(terms(x2*)), coef)))) -> {
				debug("R-2-3-3",`in);
				isEquivalent = true;
				return `eq(qaffine(terms(x1*)), qaffine(terms(x2*)));
			}
			in@eq(qaffine(terms(x1*, nfloor(qaffine(terms(x2*)), coef), x3*)), qaffine(terms(x4*, nfloor(qaffine(terms(x5*)), coef), x6*))) -> {
				debug("R-2-3-4",`in);
				return `eq(qaffine(terms(x1*, x3*, x2*)), qaffine(terms(x4*, x5*, x6*)));
			}
			in@eq(qaffine(terms(mul(rhs_exp, coef))), qaffine(terms(mul(lhs_exp, coef)))) -> {
				debug("R-2-4-1",`in);
				return `eq(rhs_exp, lhs_exp);
			}
			in@eq(qaffine(terms(x1*, mul(exp, coef), x2*)), qaffine(terms(x3*, mul(exp, coef), x4*))) -> {
				debug("R-2-4-2",`in);
				checkEmptiness(`qaffine(terms(x1*, x2*)), `qaffine(terms(x3*, x4*)));
				return `eq(qaffine(terms(x1*, x2*)), qaffine(terms(x3*, x4*)));
			}
			in@eq(qaffine(terms(nmul(qaffine(terms(x1*)), coef))), qaffine(terms(nmul(qaffine(terms(x2*)), coef)))) -> {
				debug("R-2-4-3",`in);
				isEquivalent = true;
				return `eq(qaffine(terms(x1*)), qaffine(terms(x2*)));
			}
			in@eq(qaffine(terms(x1*, nmul(qaffine(terms(x2*)), coef), x3*)), qaffine(terms(x4*, nmul(qaffine(terms(x5*)), coef), x6*))) -> {
				debug("R-2-4-4",`in);
				return `eq(qaffine(terms(x1*, x3*, x2*)), qaffine(terms(x4*, x5*, x6*)));
			}
			in@eq(qaffine(terms(mod(rhs_exp, coef))), qaffine(terms(mod(lhs_exp, coef)))) -> {
				debug("R-2-5-1",`in);
				return `eq(rhs_exp, lhs_exp);
			}
			in@eq(qaffine(terms(x1*, mod(exp, coef), x2*)), qaffine(terms(x3*, mod(exp, coef), x4*))) -> {
				debug("R-2-5-2",`in);
				checkEmptiness(`qaffine(terms(x1*, x2*)), `qaffine(terms(x3*, x4*)));
				return `eq(qaffine(terms(x1*, x2*)), qaffine(terms(x3*, x4*)));
			}
			in@eq(qaffine(terms(nmod(qaffine(terms(x1*)), coef))), qaffine(terms(nmod(qaffine(terms(x2*)), coef)))) -> {
				debug("R-2-5-3",`in);
				isEquivalent = true;
				return `eq(qaffine(terms(x1*)), qaffine(terms(x2*)));
			}
			in@eq(qaffine(terms(x1*, nmod(qaffine(terms(x2*)), coef), x3*)), qaffine(terms(x4*, nmod(qaffine(terms(x5*)), coef), x6*))) -> {
				debug("R-2-5-4",`in);
				return `eq(qaffine(terms(x1*, x3*, x2*)), qaffine(terms(x4*, x5*, x6*)));
			}
			/* Polynomial part */
//			in@eq(polynomial(pterms(pterm(num, var, den))), polynomial(pterms(pterm(num, var, den)))) -> {
//				debug("R-5",`in);
//				return `eq(affine(terms(term(coef, var))), affine(terms(term(coef, var))));
//			}
//			in@eq(polynomial(terms(x1*, pterm(var, coef), x2*)), polynomial(terms(x3*, pterm(var, coef), x4*))) -> {
//				debug("R-6",`in);
//				checkEmptiness(`polynomial(terms(x1*, x2*)), `polynomial(terms(x3*, x4*)));
//				return `eq(polynomial(terms(x1*, x2*)), polynomial(terms(x3*, x4*)));
//			}
//			in@eq(polynomial(terms(pnterm(expression, coef))), polynomial(terms(pnterm(expression, coef)))) -> {
//				debug("R-7",`in);
//				isEquivalent = true;
//				return `eq(null, null);
//			}
//			/*in@eq(polynomial(terms(x1*, pnterm(expression1, coef), x2*)), polynomial(terms(x3*, pnterm(expression2, coef), x4*))) -> {
//				debug("R-8",`in);
//				EList<IntExpression> l1 = new BasicEList<IntExpression>();
//				l1.add(`expression1);
//				l1.add(`polynomial(terms(x1*, x2*)));
//				EList<IntExpression> l2 = new BasicEList<IntExpression>();
//				l1.add(`expression2);
//				l1.add(`polynomial(terms(x3*, x4*)));
//				checkEmptiness(`sum(l1), `sum(l2));
//				return `eq(sum(l1), sum(l2));
//			}*/
//			in@eq(polynomial(terms(x1*, pnterm(exp, coef), x2*)), polynomial(terms(x3*, pnterm(exp, coef), x4*))) -> {
//				debug("R-8",`in);
//				checkEmptiness(`polynomial(terms(x1*, x2*)), `polynomial(terms(x3*, x4*)));
//				return `eq(polynomial(terms(x1*, x2*)), polynomial(terms(x3*, x4*)));
//			}
			/* Reduction part */
			in@eq(min(EL(exp1*, exp, exp2*)), min(EL(exp3*, exp, exp4*))) -> {
				debug("R-9",`in);
				checkEmptiness(`min(EL(exp1*, exp2*)), `min(EL(exp3*, exp4*)));
				return `eq(min(EL(exp1*, exp2*)), min(EL(exp3*, exp4*)));
			}
			in@eq(max(EL(exp1*, exp, exp2*)), max(EL(exp3*, exp, exp4*))) -> {
				debug("R-10",`in);
				checkEmptiness(`max(EL(exp1*, exp2*)), `max(EL(exp3*, exp4*)));
				return `eq(max(EL(exp1*, exp2*)), max(EL(exp3*, exp4*)));
			}
			in@eq(sum(EL(exp1*, exp, exp2*)), sum(EL(exp3*, exp, exp4*))) -> {
				debug("R-10",`in);
				checkEmptiness(`sum(EL(exp1*, exp2*)), `sum(EL(exp3*, exp4*)));
				return `eq(sum(EL(exp1*, exp2*)), sum(EL(exp3*, exp4*)));
			}
			in@eq(prod(EL(exp1*, exp, exp2*)), prod(EL(exp3*, exp, exp4*))) -> {
				debug("R-10",`in);
				checkEmptiness(`prod(EL(exp1*, exp2*)), `prod(EL(exp3*, exp4*)));
				return `eq(prod(EL(exp1*, exp2*)), prod(EL(exp3*, exp4*)));
			}
		}
	}
}