package org.polymodel.algebra.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.polymodel.algebra.AlgebraFactory;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.CompositeIntExpression;
import org.polymodel.algebra.CompositeOperator;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.SelectExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineFactory;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.polynomials.PolynomialExpression;
import org.polymodel.algebra.polynomials.PolynomialTerm;
import org.polymodel.algebra.polynomials.PolynomialVariable;
import org.polymodel.algebra.polynomials.PolynomialsFactory;
import org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm;
import org.polymodel.algebra.quasiAffine.QuasiAffineExpression;
import org.polymodel.algebra.quasiAffine.QuasiAffineFactory;
import org.polymodel.algebra.quasiAffine.QuasiAffineOperator;
import org.polymodel.algebra.quasiAffine.QuasiAffineTerm;
import org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm;
import org.polymodel.algebra.reductions.ReductionExpression;
import org.polymodel.algebra.reductions.ReductionOperator;
import org.polymodel.algebra.reductions.ReductionsFactory;
import org.polymodel.algebra.tom.Isolate;

public class IntExpressionBuilder {

	public static AlgebraFactory factory = AlgebraFactory.eINSTANCE;

	private static EObject copyIfContained(EObject a) {
		if (a != null && a.eContainer() != null) {
			Copier copier = new Copier();
			EObject res = copier.copy(a);
			copier.copyReferences();
			return res;
		} else
			return a;
	}

	public static IntExpression add(IntExpression a, int b) {
		return sum(a, affine(term(b)));
	}

	public static IntExpression add(int b, IntExpression a) {
		return sum(a, affine(term(b)));
	}
	
	public static IntExpression constant(int a) {
		return affine(term(a));
	}

	private static ReductionExpression reduction(ReductionOperator op,
			List<IntExpression> a) {
		ReductionExpression sum = ReductionsFactory.eINSTANCE
				.createReductionExpression();
		sum.setOperator(op);
		sum.getExpressions().addAll(a);
		return sum;
	}

	private static ReductionExpression reduction(ReductionOperator op,
			IntExpression... a) {
		return reduction(op, Arrays.asList(a));
	}

	public static ReductionExpression sum(IntExpression... a) {
		return reduction(ReductionOperator.SUM, a);
	}

	public static ReductionExpression sum(List<IntExpression> a) {
		return reduction(ReductionOperator.SUM, a);
	}

	public static ReductionExpression prod(List<IntExpression> a) {
		return reduction(ReductionOperator.PROD, a);
	}

	public static ReductionExpression min(List<IntExpression> a) {
		return reduction(ReductionOperator.MIN, a);
	}

	public static ReductionExpression max(List<IntExpression> a) {
		return reduction(ReductionOperator.MAX, a);
	}

	public static ReductionExpression prod(IntExpression... a) {
		return reduction(ReductionOperator.PROD, a);
	}

	public static ReductionExpression min(IntExpression... a) {
		return reduction(ReductionOperator.MIN, a);
	}

	public static ReductionExpression max(IntExpression... a) {
		return reduction(ReductionOperator.MAX, a);
	}

	public static IntExpression sub(IntExpression a, IntExpression b) {
		return sum(a, prod(b, affine(term(-1))));
	}

	public static AffineExpression affine(Variable v) {
		return affine(term(v));
	}
	
	public static AffineExpression affine(AffineTerm... a) {
		AffineExpression res = AffineFactory.eINSTANCE.createAffineExpression();
		for (AffineTerm term : a) {
			res.getTerms().add((AffineTerm) copyIfContained(term));
		}
		return res;
	}

	public static AffineExpression affine(IntExpression a) {
		IntExpression tryAsLinexp = a.simplify();
		if (tryAsLinexp == a && !(a instanceof AffineExpression)) {
			throw new RuntimeException("Cannot convert current expresion " + a
					+ "to linearexpression");

		} else {
			return (AffineExpression) tryAsLinexp;
		}
	}

	public static AffineExpression affine(List<AffineTerm> terms) {
		AffineExpression res = AffineFactory.eINSTANCE.createAffineExpression();
		for (AffineTerm a : terms) {
			res.getTerms().add((AffineTerm) copyIfContained(a));
		}
		return res;
	}

	public static AffineExpression affine() {
		AffineExpression res = AffineFactory.eINSTANCE.createAffineExpression();
		return res;
	}

	public static QuasiAffineExpression qaffine(List<QuasiAffineTerm> terms) {
		QuasiAffineExpression res = QuasiAffineFactory.eINSTANCE
				.createQuasiAffineExpression();
		for (QuasiAffineTerm a : terms) {
			res.getTerms().add((QuasiAffineTerm) copyIfContained(a));
		}
		return res;
	}

	public static QuasiAffineExpression qaffine(QuasiAffineTerm... a) {
		return qaffine(Arrays.asList(a));
	}

	public static QuasiAffineTerm qterm(AffineTerm a) {
		return mul(affine(a), 1);
	}

	public static QuasiAffineTerm mod(AffineExpression a, int scale) {
		return qterm(QuasiAffineOperator.MOD, a, scale);
	}

	public static QuasiAffineTerm mod(QuasiAffineExpression a, int scale) {
		return qterm(QuasiAffineOperator.MOD, a, scale);
	}

	public static QuasiAffineTerm floord(AffineExpression a, int scale) {
		return qterm(QuasiAffineOperator.FLOOR, a, scale);
	}

	public static QuasiAffineTerm floord(QuasiAffineExpression a, int scale) {
		return qterm(QuasiAffineOperator.FLOOR, a, scale);
	}

	public static QuasiAffineTerm div(AffineExpression a, int scale) {
		return qterm(QuasiAffineOperator.DIV, a, scale);
	}

	public static QuasiAffineTerm div(QuasiAffineExpression a, int scale) {
		return qterm(QuasiAffineOperator.DIV, a, scale);
	}

	public static QuasiAffineTerm ceild(AffineExpression a, int scale) {
		return qterm(QuasiAffineOperator.CEIL, a, scale);
	}

	public static QuasiAffineTerm ceild(QuasiAffineExpression a, int scale) {
		return qterm(QuasiAffineOperator.CEIL, a, scale);
	}

	public static QuasiAffineTerm mul(AffineExpression a, int scale) {
		return qterm(QuasiAffineOperator.MUL, a, scale);
	}

	public static QuasiAffineTerm mul(QuasiAffineExpression a, int scale) {
		return qterm(QuasiAffineOperator.MUL, a, scale);
	}

	public static QuasiAffineTerm mod(AffineExpression a, long scale) {
		return qterm(QuasiAffineOperator.MOD, a, scale);
	}

	public static QuasiAffineTerm mod(QuasiAffineExpression a, long scale) {
		return qterm(QuasiAffineOperator.MOD, a, scale);
	}

	public static QuasiAffineTerm floord(AffineExpression a, long scale) {
		return qterm(QuasiAffineOperator.FLOOR, a, scale);
	}

	public static QuasiAffineTerm floord(QuasiAffineExpression a, long scale) {
		return qterm(QuasiAffineOperator.FLOOR, a, scale);
	}

	public static QuasiAffineTerm div(AffineExpression a, long scale) {
		return qterm(QuasiAffineOperator.DIV, a, scale);
	}

	public static QuasiAffineTerm div(QuasiAffineExpression a, long scale) {
		return qterm(QuasiAffineOperator.DIV, a, scale);
	}

	public static QuasiAffineTerm ceild(AffineExpression a, long scale) {
		return qterm(QuasiAffineOperator.CEIL, a, scale);
	}

	public static QuasiAffineTerm ceild(QuasiAffineExpression a, long scale) {
		return qterm(QuasiAffineOperator.CEIL, a, scale);
	}

	public static QuasiAffineTerm mul(AffineExpression a, long scale) {
		return qterm(QuasiAffineOperator.MUL, a, scale);
	}

	public static QuasiAffineTerm mul(QuasiAffineExpression a, long scale) {
		return qterm(QuasiAffineOperator.MUL, a, scale);
	}

	private static SimpleQuasiAffineTerm qterm(QuasiAffineOperator op,
			AffineExpression a, int scale) {
		SimpleQuasiAffineTerm qt = QuasiAffineFactory.eINSTANCE
				.createSimpleQuasiAffineTerm();
		qt.setCoef(scale);
		qt.setExpression(a);
		qt.setOperator(op);
		return qt;
	}

	public static SimpleQuasiAffineTerm qterm(QuasiAffineOperator op,
			AffineExpression a, long scale) {
		SimpleQuasiAffineTerm qt = QuasiAffineFactory.eINSTANCE
				.createSimpleQuasiAffineTerm();
		qt.setCoef(scale);
		qt.setExpression(a);
		qt.setOperator(op);
		return qt;
	}

	public static NestedQuasiAffineTerm qterm(QuasiAffineOperator op,
			QuasiAffineExpression a, int scale) {
		NestedQuasiAffineTerm qt = QuasiAffineFactory.eINSTANCE
				.createNestedQuasiAffineTerm();
		qt.setCoef(scale);
		qt.setExpression(a);
		qt.setOperator(op);
		return qt;
	}

	public static NestedQuasiAffineTerm qterm(QuasiAffineOperator op,
			QuasiAffineExpression a, long scale) {
		NestedQuasiAffineTerm qt = QuasiAffineFactory.eINSTANCE
				.createNestedQuasiAffineTerm();
		qt.setCoef(scale);
		qt.setExpression(a);
		qt.setOperator(op);
		return qt;
	}

	public static AffineTerm term(long scale, Variable a) {
		AffineTerm t = AffineFactory.eINSTANCE.createAffineTerm();
		t.setVariable(a);
		t.setCoef(scale);
		return t;
	}

	public static AffineTerm neg(AffineTerm a) {
		long coef = a.getCoef();
		return term(-coef, a.getVariable());
	}

	public static AffineTerm term(Variable a) {
		return term(1, a);
	}

	public static AffineTerm term(long scale) {
		return term(scale, null);
	}

	public static Variable var(String name) {
		Variable v = factory.createVariable();
		v.setName(name);
		return v;
	}

	public static IntConstraintSystem constraintSystem(
			List<IntConstraint> constraints) {
		IntConstraintSystem res = constraintSystem();
		for (IntConstraint constr : constraints) {
			res.getConstraints().add((IntConstraint) copyIfContained(constr));
		}
		return res;
	}

	public static IntConstraintSystem constraintSystem() {
		return factory.createIntConstraintSystem();
	}

	public static IntConstraintSystem constraintSystem(
			IntConstraint... constraints) {
		return constraintSystem(Arrays.asList(constraints));
	}

	public static List<IntConstraintSystem> negate(IntConstraintSystem system) {
//		IntConstraintSystem res = AlgebraFactory.eINSTANCE
//				.createIntConstraintSystem();
//		for (IntConstraint constraint : system.getConstraints()) {
//			res.getConstraints().add(negate(constraint));
//		}
//		return res;
		List<IntConstraintSystem> tmp = new ArrayList<IntConstraintSystem>(1);
		tmp.add(system);
		return negate(tmp);
	}

	private static ComparisonOperator negate(
			ComparisonOperator comparisonComparisonOperator) {
		ComparisonOperator newComparisonOperator;
		switch (comparisonComparisonOperator) {
		case GE:
			newComparisonOperator = ComparisonOperator.LT;
			break;
		case LE:
			newComparisonOperator = ComparisonOperator.GT;
			break;
		case GT:
			newComparisonOperator = ComparisonOperator.LE;
			break;
		case LT:
			newComparisonOperator = ComparisonOperator.GE;
			break;
		case EQ:
			newComparisonOperator = ComparisonOperator.NE;
			break;
		case NE:
			newComparisonOperator = ComparisonOperator.EQ;
			break;
		default:
			throw new UnsupportedOperationException("Not yet implemented");
		}
		return newComparisonOperator;
	}

	public static IntConstraint negate(IntConstraint constraint) {
		IntConstraint res = (IntConstraint) copyIfContained(constraint);
		res.setComparisonOperator(negate(constraint.getComparisonOperator()));
		return res;
	}

	
	/*
	 * examples : 
	 * 
	 * !(i >= 0 && i < n)
	 * (i < 0) || (i >= n)
	 * 
	 * !((i >= 0) || (i < n))
	 * !(i >= 0) && !(i < n)
	 * (i < 0 && i >= n)
	 * 
	 * !((i > 0 && i < n) || (i > 0 && i < m))
	 * !(i > 0 && i < n) && !(i > 0 && i < m)
	 * (i <= 0 || i >= n) && (i <= 0 || i >= m)
	 * (i <= 0 && i <= 0) || (i <= 0 && i >= m) || (i >=n && i <= 0) || (i >= n && i >= m)
	 * 
	 * !((i > 0 && i < n) || (i > 0 && i < m && i <= p))
	 * !(i > 0 && i < n) && !(i > 0 && i < m && i <= p)
	 * (i <= 0 || i >= n) && (i <= 0 || i >= m || i > p)
	 * (i <= 0 && i <= 0) || (i <= 0 && i >= m) || (i <= 0 && i > p) || (i >=n && i <= 0) || (i >= n && i >= m) || (i >= n && i > p)
	 */
	public static List<IntConstraintSystem> negate(List<IntConstraintSystem> orig) {
		List<List<IntConstraint>> ll = new ArrayList<List<IntConstraint>>();
		for (IntConstraintSystem sysOrig : orig) {
			if (ll.size() == 0) {
				for (IntConstraint c : sysOrig.getConstraints()) {
					List<IntConstraint> l = new ArrayList<IntConstraint>();
					l.add(negate(c.copy()));
					ll.add(l);
				}
			} else {
				List<List<IntConstraint>> ll2 = new ArrayList<List<IntConstraint>>();
				for (List<IntConstraint> nl : ll) {
					for (IntConstraint c : sysOrig.getConstraints()) {
						List<IntConstraint> l = new ArrayList<IntConstraint>();
						l.add(negate(c.copy()));
						for (IntConstraint c2 : nl) {
							l.add(c2);
						}
						ll2.add(l);
					}
				}
				ll = ll2;
			}
		}
		List<IntConstraintSystem> res = new ArrayList<IntConstraintSystem>();
		for (List<IntConstraint> l : ll) {
			res.add(constraintSystem(l));
		}
		return res;
	}
	
	
	/**
	 * Replaces all the occurrences of the comparison operator "!=" by disjunctions.
	 */
	public static List<IntConstraintSystem> removeNE(List<IntConstraintSystem> orig) {
		List<List<IntConstraint>> main = new ArrayList<List<IntConstraint>>();
		for (IntConstraintSystem sysOrig : orig) {
			List<List<IntConstraint>> tmpRes = new ArrayList<List<IntConstraint>>();
			for (IntConstraint c : sysOrig.getConstraints()) {
				// currentlyTransformed contains the system(s) for the current
				// constraint. The constraint is split into 2 systems only if it
				// has a "!=" comparison operator.
				List<List<IntConstraint>> currentlyTransformed = new ArrayList<List<IntConstraint>>();
				if (c.getComparisonOperator() == ComparisonOperator.NE) {
					List<IntConstraint> l1 = new ArrayList<IntConstraint>();
					List<IntConstraint> l2 = new ArrayList<IntConstraint>();

					// given "a != b", builds "a - 1 >= b" and "b - 1 >= a"
					IntConstraint ineq1 = IntExpressionBuilder.constraint(
							IntExpressionBuilder.add(c.getLhs().copy(), -1),
							c.getRhs().copy(), ComparisonOperator.GE);
					IntConstraint ineq2 = IntExpressionBuilder.constraint(
							IntExpressionBuilder.add(c.getRhs().copy(), -1),
							c.getLhs().copy(), ComparisonOperator.GE);

					l1.add(ineq1);
					l2.add(ineq2);
					
					currentlyTransformed.add(l1);
					currentlyTransformed.add(l2);
				} else {
					List<IntConstraint> l = new ArrayList<IntConstraint>();
					l.add(c.copy());
					currentlyTransformed.add(l);
				}
				
				
				if (tmpRes.size() == 0) {
					tmpRes = currentlyTransformed;
				} else {
					// what is in tmpRes has already been transformed. Use
					// currentlyTransformed as a base, and add all the systems
					// in tmpRes
					List<List<IntConstraint>> newTmpRes = new ArrayList<List<IntConstraint>>();
					for (List<IntConstraint> ctl : currentlyTransformed) {
						for (List<IntConstraint> trl : tmpRes) {
							List<IntConstraint> copy = new ArrayList<IntConstraint>(trl.size()+ctl.size());
							for (IntConstraint c2 : trl) {
								copy.add(c2);
							}
							for (IntConstraint c2 : ctl) {
								copy.add(c2);
							}
							newTmpRes.add(copy);
						}
					}
					// use the new list as result.
					tmpRes = newTmpRes;
				}
			}
			main.addAll(tmpRes);
		}
		
		List<IntConstraintSystem> res = new ArrayList<IntConstraintSystem>();
		for (List<IntConstraint> l : main) {
			res.add(constraintSystem(l));
		}
		return res;
	}

	public static IntConstraint mul(IntConstraint constraint, int value) {
		ReductionExpression newLHS = prod(affine(term(value)),
				constraint.getLhs());
		ReductionExpression newRHS = prod(affine(term(value)),
				constraint.getRhs());
		if (value < 0) {
			ComparisonOperator opp;
			switch (constraint.getComparisonOperator()) {
			case GE:
				opp = ComparisonOperator.LE;
				break;
			case LE:
				opp = ComparisonOperator.GE;
				break;
			case GT:
				opp = ComparisonOperator.LT;
				break;
			case LT:
				opp = ComparisonOperator.GT;
				break;
			default:
				opp = constraint.getComparisonOperator();
			}
			return constraint(newLHS, newRHS, opp);
		}
		return constraint(newLHS, newRHS, constraint.getComparisonOperator());
	}

	/**
	 * Build an expression corresponding to a variable isolation. Variable is
	 * removed and other terms are negated. Input expression isn't modified.
	 * 
	 * @param expression
	 * @param var
	 *            variable to isolate
	 * @return a new expression
	 */
	public static IntExpression isolate(IntExpression exp, Variable variable) {
		// throw new UnsupportedOperationException("Not yet implemented");
		IntExpression i = Isolate.isolate(exp.copy(), variable);
		return i;
	}

	/*
	 * IntegerConstraints
	 */

	public static IntConstraint constraint(IntExpression lhs,
			IntExpression rhs, ComparisonOperator newComparisonOperator) {
		IntConstraint c = AlgebraFactory.eINSTANCE.createIntConstraint();
		c.setLhs((IntExpression) copyIfContained(lhs));
		c.setRhs((IntExpression) copyIfContained(rhs));
		c.setComparisonOperator(newComparisonOperator);
		return c;
	}

	public static IntConstraint le(IntExpression lhs, IntExpression rhs) {
		return constraint(lhs.simplify(), rhs.simplify(), ComparisonOperator.LE);
	}

	public static IntConstraint ge(IntExpression lhs, IntExpression rhs) {
		return constraint(lhs.simplify(), rhs.simplify(), ComparisonOperator.GE);
	}

	public static IntConstraint eq(IntExpression lhs, IntExpression rhs) {
		return constraint(lhs.simplify(), rhs.simplify(), ComparisonOperator.EQ);
	}

	public static IntConstraint eq(Variable var, IntExpression rhs) {
		return constraint(affine(var), rhs.simplify(), ComparisonOperator.EQ);
	}

	public static IntConstraint gt(IntExpression lhs, IntExpression rhs) {
		return constraint(lhs.simplify(), rhs.simplify(), ComparisonOperator.GT);
	}

	public static IntConstraint lt(IntExpression lhs, IntExpression rhs) {
		return constraint(lhs.simplify(), rhs.simplify(), ComparisonOperator.LT);
	}

	public static IntConstraint lez(IntExpression lhs) {
		return constraint(lhs, affine(term(0)), ComparisonOperator.LE);
	}

	public static IntConstraint gez(IntExpression lhs) {
		return constraint(lhs, affine(term(0)), ComparisonOperator.GE);
	}

	public static IntConstraint eqz(IntExpression lhs) {
		return constraint(lhs, affine(term(0)), ComparisonOperator.EQ);
	}

	public static IntConstraint gtz(IntExpression lhs) {
		return constraint(lhs, affine(term(0)), ComparisonOperator.GT);
	}

	public static IntConstraint ltz(IntExpression lhs) {
		return constraint(lhs, affine(term(0)), ComparisonOperator.LT);
	}


	public static PolynomialExpression polynomial(PolynomialTerm... a) {
		return polynomial(Arrays.asList(a));
	}

	public static PolynomialExpression polynomial(List<PolynomialTerm> a) {
		PolynomialExpression expr = PolynomialsFactory.eINSTANCE
				.createPolynomialExpression();

		expr.getTerms().addAll(a);

		return expr;
	}

	public static PolynomialTerm pterm(PolynomialVariable... vars) {
		return pterm(Arrays.asList(vars));
	}
	public static PolynomialTerm pterm(long numerator, PolynomialVariable... vars) {
		return pterm(numerator, Arrays.asList(vars));
	}
	public static PolynomialTerm pterm(long numerator, long denominator, PolynomialVariable... vars) {
		return pterm(numerator, denominator, Arrays.asList(vars));
	}

	/**
	 * Assumes numerator = 1 and denominator = 1
	 * 
	 * @param numerator
	 * @param vars
	 * @return
	 */
	public static PolynomialTerm pterm(List<PolynomialVariable> vars) {
		return pterm(1, 1, vars);
	}
	
	/**
	 * Assumes denominator = 1
	 * 
	 * @param numerator
	 * @param vars
	 * @return
	 */
	public static PolynomialTerm pterm(long numerator, List<PolynomialVariable> vars) {
		return pterm(numerator, 1, vars);
	}

	public static PolynomialTerm pterm(long numerator, long denominator, List<PolynomialVariable> vars) {
		PolynomialTerm pterm = PolynomialsFactory.eINSTANCE.createPolynomialTerm();
		
		pterm.setNumerator(numerator);
		pterm.setDenominator(denominator);
		pterm.getVariables().addAll(vars);
		
		return pterm;
	}

	/**
	 * Assumes exponent = 1
	 * 
	 * @param var
	 * @return
	 */
	public static PolynomialVariable pvar(Variable var) {
		return pvar(var, 1);
	}
	
	public static PolynomialVariable pvar(Variable var, long exponent) {
		PolynomialVariable pvar = PolynomialsFactory.eINSTANCE.createPolynomialVariable();
		
		pvar.setVariable(var);
		pvar.setExponent(exponent);
		
		return pvar; 
	}
	
	public static CompositeIntExpression symbolicDiv(IntExpression num, IntExpression dnum){
		CompositeIntExpression div = AlgebraFactory.eINSTANCE.createCompositeIntExpression();
		div.setOperator(CompositeOperator.DIV);
		div.setLeft(num);
		div.setRight(dnum);
		
		return div;
	}
	
	public static CompositeIntExpression symbolicMod(IntExpression lhs, IntExpression rhs){
		CompositeIntExpression mod = AlgebraFactory.eINSTANCE.createCompositeIntExpression();
		mod.setOperator(CompositeOperator.MOD);
		mod.setLeft(lhs);
		mod.setRight(rhs);
		
		return mod;
	}
	
	public static CompositeIntExpression symbolicCeil(IntExpression lhs, IntExpression rhs){
		CompositeIntExpression ceil = AlgebraFactory.eINSTANCE.createCompositeIntExpression();
		ceil.setOperator(CompositeOperator.CEIL);
		ceil.setLeft(lhs);
		ceil.setRight(rhs);
		
		return ceil;
	}
	
	public static CompositeIntExpression symbolicFloor(IntExpression lhs, IntExpression rhs){
		CompositeIntExpression floor = AlgebraFactory.eINSTANCE.createCompositeIntExpression();
		floor.setOperator(CompositeOperator.FLOOR);
		floor.setLeft(lhs);
		floor.setRight(rhs);

		return floor;
	}
	
	public static SelectExpression selectExpression(List<IntConstraintSystem> cond, IntExpression t, IntExpression e) {
		SelectExpression s = AlgebraFactory.eINSTANCE.createSelectExpression();
		s.getCondition().addAll(cond);
		s.setThen(t);
		s.setElse(e);
		return s;
	}

//	public static IntExpression symbolicDiv(IntExpression num,
//			IntExpression denom) {
//		return prod(num, polynomial(pterm(denom, -1)));
//	}
}
