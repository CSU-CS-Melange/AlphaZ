package org.polymodel.algebra.internal;

import java.util.List;


/* PROTECTED REGION ID(algebra_tom_factory_imports) ENABLED START */
// protected imports, you should add here required imports that won't be removed after regeneration of the maping code
/* PROTECTED REGION END */

/**
* Factory used by TOM for algebra mapping.
* It shouldn't be visible outside of the plugin
* -- Generated by TOM mapping EMF generator --
*/

public class AlgebraTomFactory {

	/* PROTECTED REGION ID(algebra_tom_factory_members) ENABLED START */
	/* PROTECTED REGION END */
	
 	public static org.polymodel.algebra.AlgebraFactory algebraFactory = org.polymodel.algebra.AlgebraFactory.eINSTANCE;
 	public static org.polymodel.algebra.affine.AffineFactory affineFactory = org.polymodel.algebra.affine.AffineFactory.eINSTANCE;
 	public static org.polymodel.algebra.quasiAffine.QuasiAffineFactory quasiAffineFactory = org.polymodel.algebra.quasiAffine.QuasiAffineFactory.eINSTANCE;
 	public static org.polymodel.algebra.reductions.ReductionsFactory reductionsFactory = org.polymodel.algebra.reductions.ReductionsFactory.eINSTANCE;
 	public static org.polymodel.algebra.polynomials.PolynomialsFactory polynomialsFactory = org.polymodel.algebra.polynomials.PolynomialsFactory.eINSTANCE;


	// User operators

	/** Module base **/
	// CreateOperatorWithParameters var
	public static org.polymodel.algebra.Variable createVar(String _name) {
		org.polymodel.algebra.Variable o = algebraFactory.createVariable();
		o.setName(_name);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_var) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters composite
	public static org.polymodel.algebra.CompositeIntExpression createComposite(org.polymodel.algebra.CompositeOperator _operator, org.polymodel.algebra.IntExpression _left, org.polymodel.algebra.IntExpression _right) {
		org.polymodel.algebra.CompositeIntExpression o = algebraFactory.createCompositeIntExpression();
		o.setOperator((org.polymodel.algebra.CompositeOperator) _operator);
		o.setLeft((org.polymodel.algebra.IntExpression) _left);
		o.setRight((org.polymodel.algebra.IntExpression) _right);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_composite) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters select
	public static org.polymodel.algebra.SelectExpression createSelect(List<org.polymodel.algebra.IntConstraintSystem> _condition, org.polymodel.algebra.IntExpression _then, org.polymodel.algebra.IntExpression _else) {
		org.polymodel.algebra.SelectExpression o = algebraFactory.createSelectExpression();
		for(int i=0; i<_condition.size(); i++) {
			o.getCondition().add((org.polymodel.algebra.IntConstraintSystem) _condition.get(i));
		}
		o.setThen((org.polymodel.algebra.IntExpression) _then);
		o.setElse((org.polymodel.algebra.IntExpression) _else);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_select) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	/** Module affine **/
	// CreateOperatorWithParameters affine
	public static org.polymodel.algebra.affine.AffineExpression createAffine(List<org.polymodel.algebra.IntTerm> _terms) {
		org.polymodel.algebra.affine.AffineExpression o = affineFactory.createAffineExpression();
		for(int i=0; i<_terms.size(); i++) {
			o.getTerms().add((org.polymodel.algebra.affine.AffineTerm) _terms.get(i));
		}
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_affine) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters term
	public static org.polymodel.algebra.affine.AffineTerm createTerm(long _coef, org.polymodel.algebra.Variable _variable) {
		org.polymodel.algebra.affine.AffineTerm o = affineFactory.createAffineTerm();
		o.setCoef(_coef);
		o.setVariable((org.polymodel.algebra.Variable) _variable);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_term) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters constant
	public static org.polymodel.algebra.affine.AffineTerm createConstant(long _coef) {
		org.polymodel.algebra.affine.AffineTerm o = affineFactory.createAffineTerm();
		o.setCoef(_coef);
		o.setVariable(null);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_constant) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	/** Module quasiaffine **/
	// CreateOperatorWithParameters qaffine
	public static org.polymodel.algebra.quasiAffine.QuasiAffineExpression createQaffine(List<org.polymodel.algebra.IntTerm> _terms) {
		org.polymodel.algebra.quasiAffine.QuasiAffineExpression o = quasiAffineFactory.createQuasiAffineExpression();
		for(int i=0; i<_terms.size(); i++) {
			o.getTerms().add((org.polymodel.algebra.quasiAffine.QuasiAffineTerm) _terms.get(i));
		}
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_qaffine) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters qterm
	public static org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm createQterm(org.polymodel.algebra.IntExpression _expression) {
		org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm o = quasiAffineFactory.createSimpleQuasiAffineTerm();
		o.setExpression((org.polymodel.algebra.affine.AffineExpression) _expression);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_qterm) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters mul
	public static org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm createMul(org.polymodel.algebra.IntExpression _expression, long _coef) {
		org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm o = quasiAffineFactory.createSimpleQuasiAffineTerm();
		o.setExpression((org.polymodel.algebra.affine.AffineExpression) _expression);
		o.setCoef(_coef);
		o.setOperator(org.polymodel.algebra.quasiAffine.QuasiAffineOperator.MUL);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_mul) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters mod
	public static org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm createMod(org.polymodel.algebra.IntExpression _expression, long _coef) {
		org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm o = quasiAffineFactory.createSimpleQuasiAffineTerm();
		o.setExpression((org.polymodel.algebra.affine.AffineExpression) _expression);
		o.setCoef(_coef);
		o.setOperator(org.polymodel.algebra.quasiAffine.QuasiAffineOperator.MOD);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_mod) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters ceil
	public static org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm createCeil(org.polymodel.algebra.IntExpression _expression, long _coef) {
		org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm o = quasiAffineFactory.createSimpleQuasiAffineTerm();
		o.setExpression((org.polymodel.algebra.affine.AffineExpression) _expression);
		o.setCoef(_coef);
		o.setOperator(org.polymodel.algebra.quasiAffine.QuasiAffineOperator.CEIL);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_ceil) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters floor
	public static org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm createFloor(org.polymodel.algebra.IntExpression _expression, long _coef) {
		org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm o = quasiAffineFactory.createSimpleQuasiAffineTerm();
		o.setExpression((org.polymodel.algebra.affine.AffineExpression) _expression);
		o.setCoef(_coef);
		o.setOperator(org.polymodel.algebra.quasiAffine.QuasiAffineOperator.FLOOR);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_floor) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters div
	public static org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm createDiv(org.polymodel.algebra.IntExpression _expression, long _coef) {
		org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm o = quasiAffineFactory.createSimpleQuasiAffineTerm();
		o.setExpression((org.polymodel.algebra.affine.AffineExpression) _expression);
		o.setCoef(_coef);
		o.setOperator(org.polymodel.algebra.quasiAffine.QuasiAffineOperator.DIV);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_div) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters nqterm
	public static org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm createNqterm(org.polymodel.algebra.IntExpression _expression) {
		org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm o = quasiAffineFactory.createNestedQuasiAffineTerm();
		o.setExpression((org.polymodel.algebra.quasiAffine.QuasiAffineExpression) _expression);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_nqterm) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters nmul
	public static org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm createNmul(org.polymodel.algebra.IntExpression _expression, long _coef) {
		org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm o = quasiAffineFactory.createNestedQuasiAffineTerm();
		o.setExpression((org.polymodel.algebra.quasiAffine.QuasiAffineExpression) _expression);
		o.setCoef(_coef);
		o.setOperator(org.polymodel.algebra.quasiAffine.QuasiAffineOperator.MUL);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_nmul) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters nmod
	public static org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm createNmod(org.polymodel.algebra.IntExpression _expression, long _coef) {
		org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm o = quasiAffineFactory.createNestedQuasiAffineTerm();
		o.setExpression((org.polymodel.algebra.quasiAffine.QuasiAffineExpression) _expression);
		o.setCoef(_coef);
		o.setOperator(org.polymodel.algebra.quasiAffine.QuasiAffineOperator.MOD);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_nmod) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters nceil
	public static org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm createNceil(org.polymodel.algebra.IntExpression _expression, long _coef) {
		org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm o = quasiAffineFactory.createNestedQuasiAffineTerm();
		o.setExpression((org.polymodel.algebra.quasiAffine.QuasiAffineExpression) _expression);
		o.setCoef(_coef);
		o.setOperator(org.polymodel.algebra.quasiAffine.QuasiAffineOperator.CEIL);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_nceil) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters nfloor
	public static org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm createNfloor(org.polymodel.algebra.IntExpression _expression, long _coef) {
		org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm o = quasiAffineFactory.createNestedQuasiAffineTerm();
		o.setExpression((org.polymodel.algebra.quasiAffine.QuasiAffineExpression) _expression);
		o.setCoef(_coef);
		o.setOperator(org.polymodel.algebra.quasiAffine.QuasiAffineOperator.FLOOR);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_nfloor) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters ndiv
	public static org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm createNdiv(org.polymodel.algebra.IntExpression _expression, long _coef) {
		org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm o = quasiAffineFactory.createNestedQuasiAffineTerm();
		o.setExpression((org.polymodel.algebra.quasiAffine.QuasiAffineExpression) _expression);
		o.setCoef(_coef);
		o.setOperator(org.polymodel.algebra.quasiAffine.QuasiAffineOperator.DIV);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_ndiv) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	/** Module reductions **/
	// CreateOperatorWithParameters reduction
	public static org.polymodel.algebra.reductions.ReductionExpression createReduction(List<org.polymodel.algebra.IntExpression> _expressions, org.polymodel.algebra.reductions.ReductionOperator _operator) {
		org.polymodel.algebra.reductions.ReductionExpression o = reductionsFactory.createReductionExpression();
		for(int i=0; i<_expressions.size(); i++) {
			o.getExpressions().add((org.polymodel.algebra.IntExpression) _expressions.get(i));
		}
		o.setOperator((org.polymodel.algebra.reductions.ReductionOperator) _operator);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_reduction) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters prod
	public static org.polymodel.algebra.reductions.ReductionExpression createProd(List<org.polymodel.algebra.IntExpression> _expressions) {
		org.polymodel.algebra.reductions.ReductionExpression o = reductionsFactory.createReductionExpression();
		for(int i=0; i<_expressions.size(); i++) {
			o.getExpressions().add((org.polymodel.algebra.IntExpression) _expressions.get(i));
		}
		o.setOperator(org.polymodel.algebra.reductions.ReductionOperator.PROD);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_prod) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters sum
	public static org.polymodel.algebra.reductions.ReductionExpression createSum(List<org.polymodel.algebra.IntExpression> _expressions) {
		org.polymodel.algebra.reductions.ReductionExpression o = reductionsFactory.createReductionExpression();
		for(int i=0; i<_expressions.size(); i++) {
			o.getExpressions().add((org.polymodel.algebra.IntExpression) _expressions.get(i));
		}
		o.setOperator(org.polymodel.algebra.reductions.ReductionOperator.SUM);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_sum) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters max
	public static org.polymodel.algebra.reductions.ReductionExpression createMax(List<org.polymodel.algebra.IntExpression> _expressions) {
		org.polymodel.algebra.reductions.ReductionExpression o = reductionsFactory.createReductionExpression();
		for(int i=0; i<_expressions.size(); i++) {
			o.getExpressions().add((org.polymodel.algebra.IntExpression) _expressions.get(i));
		}
		o.setOperator(org.polymodel.algebra.reductions.ReductionOperator.MAX);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_max) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters min
	public static org.polymodel.algebra.reductions.ReductionExpression createMin(List<org.polymodel.algebra.IntExpression> _expressions) {
		org.polymodel.algebra.reductions.ReductionExpression o = reductionsFactory.createReductionExpression();
		for(int i=0; i<_expressions.size(); i++) {
			o.getExpressions().add((org.polymodel.algebra.IntExpression) _expressions.get(i));
		}
		o.setOperator(org.polymodel.algebra.reductions.ReductionOperator.MIN);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_min) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	/** Module polynomial **/
	// CreateOperatorWithParameters polynomial
	public static org.polymodel.algebra.polynomials.PolynomialExpression createPolynomial(List<org.polymodel.algebra.polynomials.PolynomialTerm> _terms) {
		org.polymodel.algebra.polynomials.PolynomialExpression o = polynomialsFactory.createPolynomialExpression();
		for(int i=0; i<_terms.size(); i++) {
			o.getTerms().add((org.polymodel.algebra.polynomials.PolynomialTerm) _terms.get(i));
		}
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_polynomial) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters pterm
	public static org.polymodel.algebra.polynomials.PolynomialTerm createPterm(long _numerator, long _denominator, List<org.polymodel.algebra.polynomials.PolynomialVariable> _variables) {
		org.polymodel.algebra.polynomials.PolynomialTerm o = polynomialsFactory.createPolynomialTerm();
		o.setNumerator(_numerator);
		o.setDenominator(_denominator);
		for(int i=0; i<_variables.size(); i++) {
			o.getVariables().add((org.polymodel.algebra.polynomials.PolynomialVariable) _variables.get(i));
		}
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_pterm) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters pvar
	public static org.polymodel.algebra.polynomials.PolynomialVariable createPvar(org.polymodel.algebra.Variable _variable, long _exponent) {
		org.polymodel.algebra.polynomials.PolynomialVariable o = polynomialsFactory.createPolynomialVariable();
		o.setVariable((org.polymodel.algebra.Variable) _variable);
		o.setExponent(_exponent);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_pvar) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	/** Module domains **/
	// CreateOperatorWithParameters contraint
	public static org.polymodel.algebra.IntConstraint createContraint(org.polymodel.algebra.IntExpression _lhs, org.polymodel.algebra.ComparisonOperator _comparisonOperator, org.polymodel.algebra.IntExpression _rhs) {
		org.polymodel.algebra.IntConstraint o = algebraFactory.createIntConstraint();
		o.setLhs((org.polymodel.algebra.IntExpression) _lhs);
		o.setComparisonOperator((org.polymodel.algebra.ComparisonOperator) _comparisonOperator);
		o.setRhs((org.polymodel.algebra.IntExpression) _rhs);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_contraint) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters eq
	public static org.polymodel.algebra.IntConstraint createEq(org.polymodel.algebra.IntExpression _lhs, org.polymodel.algebra.IntExpression _rhs) {
		org.polymodel.algebra.IntConstraint o = algebraFactory.createIntConstraint();
		o.setLhs((org.polymodel.algebra.IntExpression) _lhs);
		o.setRhs((org.polymodel.algebra.IntExpression) _rhs);
		o.setComparisonOperator(org.polymodel.algebra.ComparisonOperator.EQ);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_eq) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters ne
	public static org.polymodel.algebra.IntConstraint createNe(org.polymodel.algebra.IntExpression _lhs, org.polymodel.algebra.IntExpression _rhs) {
		org.polymodel.algebra.IntConstraint o = algebraFactory.createIntConstraint();
		o.setLhs((org.polymodel.algebra.IntExpression) _lhs);
		o.setRhs((org.polymodel.algebra.IntExpression) _rhs);
		o.setComparisonOperator(org.polymodel.algebra.ComparisonOperator.NE);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_ne) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters ge
	public static org.polymodel.algebra.IntConstraint createGe(org.polymodel.algebra.IntExpression _lhs, org.polymodel.algebra.IntExpression _rhs) {
		org.polymodel.algebra.IntConstraint o = algebraFactory.createIntConstraint();
		o.setLhs((org.polymodel.algebra.IntExpression) _lhs);
		o.setRhs((org.polymodel.algebra.IntExpression) _rhs);
		o.setComparisonOperator(org.polymodel.algebra.ComparisonOperator.GE);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_ge) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters le
	public static org.polymodel.algebra.IntConstraint createLe(org.polymodel.algebra.IntExpression _lhs, org.polymodel.algebra.IntExpression _rhs) {
		org.polymodel.algebra.IntConstraint o = algebraFactory.createIntConstraint();
		o.setLhs((org.polymodel.algebra.IntExpression) _lhs);
		o.setRhs((org.polymodel.algebra.IntExpression) _rhs);
		o.setComparisonOperator(org.polymodel.algebra.ComparisonOperator.LE);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_le) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters gt
	public static org.polymodel.algebra.IntConstraint createGt(org.polymodel.algebra.IntExpression _lhs, org.polymodel.algebra.IntExpression _rhs) {
		org.polymodel.algebra.IntConstraint o = algebraFactory.createIntConstraint();
		o.setLhs((org.polymodel.algebra.IntExpression) _lhs);
		o.setRhs((org.polymodel.algebra.IntExpression) _rhs);
		o.setComparisonOperator(org.polymodel.algebra.ComparisonOperator.GT);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_gt) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters lt
	public static org.polymodel.algebra.IntConstraint createLt(org.polymodel.algebra.IntExpression _lhs, org.polymodel.algebra.IntExpression _rhs) {
		org.polymodel.algebra.IntConstraint o = algebraFactory.createIntConstraint();
		o.setLhs((org.polymodel.algebra.IntExpression) _lhs);
		o.setRhs((org.polymodel.algebra.IntExpression) _rhs);
		o.setComparisonOperator(org.polymodel.algebra.ComparisonOperator.LT);
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_lt) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}
	
	// CreateOperatorWithParameters system
	public static org.polymodel.algebra.IntConstraintSystem createSystem(List<org.polymodel.algebra.IntConstraint> _constraints) {
		org.polymodel.algebra.IntConstraintSystem o = algebraFactory.createIntConstraintSystem();
		for(int i=0; i<_constraints.size(); i++) {
			o.getConstraints().add((org.polymodel.algebra.IntConstraint) _constraints.get(i));
		}
		
		/* PROTECTED REGION ID(algebra_tom_factory_class_op_system) ENABLED START */
		/* PROTECTED REGION END */
		
		return o;
	}

	/*
	* Default TOM operators for algebra mapping. Each class that has a terminal type has also a default create function.
	*/
	
}
