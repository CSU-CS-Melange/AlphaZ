package org.polymodel.algebra.tom;


import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.IntTerm;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.polynomials.PolynomialExpression;
import org.polymodel.algebra.polynomials.PolynomialTerm;
import org.polymodel.algebra.polynomials.PolynomialVariable;
import org.polymodel.algebra.quasiAffine.QuasiAffineExpression;
import org.polymodel.algebra.quasiAffine.QuasiAffineTerm;
import org.polymodel.algebra.reductions.ReductionExpression;
import org.polymodel.algebra.reductions.ReductionOperator;


@SuppressWarnings("all")
public class ArithmeticOperations  {

	%include { sl.tom }
	%include { long.tom}     

	%include { algebra_common.tom}   
	%include { algebra_terminals.tom}
	%include { algebra_all_ops.tom}          
    
	public static boolean VERBOSE=false;  
	public static long ZERO=0; 
    
	public static int Math_max(int a, int b) {
		return Math.max(a,b);
	}  

	public static long Math_max(long a, long b) {
		return Math.max(a,b);
	}  

	public static int Math_min(int a, int b) {
		return Math.min(a,b);
	} 

	public static long Math_min(long a, long b) {
		return Math.min(a,b);
	}

	public static int Math_mod(int a, int b) {
		return a%b;
	} 
	
	public static long Math_mul(long a, long b) {
		return a*b;
	} 

	public static int Math_floord(int a, int b) {
		return a/b;
	} 

	public static int Math_ceild(int a, int b) { 
		return (a+b-1)/b;
	} 

	public static IntTerm negate(IntTerm a) {
		return scale(a,-1);
	}  

	public static IntExpression negate(IntExpression a) {
		return scale(a,-1);
	}

	public static AffineExpression negate(AffineExpression a) {
		return ((AffineExpression) negate(((IntExpression)a)));
	}
  
	public static IntTerm scale(IntTerm a, long value) {
		%match( a ) {
			term(c,v) -> {
				return `term(Math_mul(value, c),v);
			} 
			mul(e,coef) -> {
				return `mul(e.copy(),Math_mul(value, coef));
			}
			mod(e,coef) -> {
				return `nmul(qaffine(terms(mod(e.copy(),coef))),value);
			}
			floor(e,coef) -> {
				return `nmul(qaffine(terms(floor(e.copy(),coef))),value);
			}
			ceil(e,coef) -> {
				return `nmul(qaffine(terms(ceil(e.copy(),coef))),value);
			}

			div(e,coef) -> {  
				return `nmul(qaffine(terms(div(e.copy(),coef))),value);
			}

			nmul(e,coef) -> {
				return `nmul(e.copy(),Math_mul(value, coef));
			}
			nmod(e,coef) -> {
				return `nmul(qaffine(terms(nmod(e.copy(),coef))),value);
			}
			nfloor(e,coef) -> {
				return `nmul(qaffine(terms(nfloor(e.copy(),coef))),value);
			}
			nceil(e,coef) -> {
				return `nmul(qaffine(terms(nceil(e.copy(),coef))),value);
			}

			ndiv(e,coef) -> {  
				return `nmul(qaffine(terms(ndiv(e.copy(),coef))),value);
			}
			
		}
		throw new RuntimeException("scaleTerm("+a+","+value+") not yet implemented");
	}  

	public static AffineExpression scale(AffineExpression a, long value) {
		return ((AffineExpression) scale(((IntExpression)a),value));
	}

	public static IntExpression scale(IntExpression a, long value) {
		IntExpression _a = a.copy();
		%match(_a) {
			affine(terms(x1*)) -> {
				AffineExpression r = (AffineExpression)`affine(terms());
				for(IntTerm t : `x1) {
					r.getTerms().add((AffineTerm)scale(t,value)); 
				}
				return r.simplify();
			}
			x@qaffine(terms(_*)) -> {
				QuasiAffineExpression r = (QuasiAffineExpression)`qaffine(terms());
				for(QuasiAffineTerm t : ((QuasiAffineExpression)`x).getTerms()) {
					r.getTerms().add((QuasiAffineTerm) scale(t,value));
				}
				return r.simplify(); 
			}
			x@polynomial(pterms(_*)) -> {
				PolynomialExpression polynomialExpression = (PolynomialExpression)`polynomial(pterms());
				for(PolynomialTerm t : ((PolynomialExpression)`x).getTerms()) {
					polynomialExpression.getTerms().add((PolynomialTerm) `pterm(value * t.getNumerator(), t.getDenominator(), t.getVariables()));
				}
				return polynomialExpression.simplify(); 
			}
			x@min(EL(_*)) -> {
				return scaleNestedExpression((ReductionExpression)`x, (ReductionExpression)`min(EL()), value);
			}
			x@max(EL(_*)) -> {
				return scaleNestedExpression((ReductionExpression)`x, (ReductionExpression)`max(EL()), value);
			}
			x@sum(EL(_*)) -> {
				return scaleNestedExpression((ReductionExpression)`x, (ReductionExpression)`sum(EL()), value);
			}
			x@prod(EL(_*)) -> {
				return scaleNestedExpression((ReductionExpression)`x, (ReductionExpression)`prod(EL()), value);
			}
			select(cond,t,e) -> {
				return `select(cond,scale(t,value),scale(e,value));
			}
		}
		throw new RuntimeException("scale("+a+","+value+") not yet implemented");
	}

	public static AffineExpression add(AffineExpression a,AffineExpression b) {
		return ((AffineExpression)add((IntExpression)a,(IntExpression)b)); 
	}

	public static IntExpression add(IntExpression a,IntExpression b) {
		IntExpression _a = a.copy();
		IntExpression _b= b.copy() ;
		%match(_a,_b) {
			affine(terms(x1*)),affine(terms(x2*)) -> {
				return `affine(terms(x1*,x2*));
			}
			affine(terms(_*)),qaffine(terms(x2*)) -> {
				QuasiAffineTerm qE = IntExpressionBuilder.mul((AffineExpression)_a, 1);  
				return `qaffine(terms(qE, x2*)); 
			}
			qaffine(terms(x2*)),affine(terms(_*)) -> {
				QuasiAffineTerm qE = IntExpressionBuilder.mul((AffineExpression)_b, 1);  
				return `qaffine(terms(qE, x2*));
			}
			qaffine(terms(x1*)),qaffine(terms(x2*)) -> {
				return `qaffine(terms(x1*, x2*));
			}
		}
		throw new RuntimeException("add("+a+") not yet implemented");
	}   

	public static IntExpression add(long a,IntExpression b) {
		return add(b,`affine(terms(constant(a))));
	}
 
	public static IntExpression add(IntExpression b,long a) {
		return add(b,`affine(terms(constant(a))));
	}

	public static IntExpression sub(IntExpression a,IntExpression b) {
		IntExpression _a = a.copy();
		IntExpression _b= b.copy() ;
		%match(_a,_b) {
			x@affine(terms(_*)),y@affine(terms(_*)) -> {
				return add(`x, negate(`y));
			}
			x@affine(terms(_*)),y@qaffine(terms(_*)) -> {
				return add(`x, negate(`y));
			}
			x@qaffine(terms(_*)),y@affine(terms(_*)) -> {
				return add(`x, negate(`y));
			}
			x@qaffine(terms(_*)),y@qaffine(terms(_*)) -> {
				return add(`x, negate(`y));
			}
		}
		throw new RuntimeException("sub("+a+") not yet implemented");
	}

	public static IntExpression scaleNestedExpression(ReductionExpression originalReductionExpression, ReductionExpression reductionExpression, long value) {
		if (originalReductionExpression.getOperator() == ReductionOperator.PROD) {
			if (originalReductionExpression.getExpressions().size() > 0) {
				IntExpression intExpression = originalReductionExpression.getExpressions().get(0);
				for (int i = 0; i < originalReductionExpression.getExpressions().size() && !(intExpression instanceof QuasiAffineExpression); i++)
					intExpression = originalReductionExpression.getExpressions().get(i);
				reductionExpression.getExpressions().add((IntExpression) scale(intExpression,value));
				for (int i = 0; i < originalReductionExpression.getExpressions().size(); i++)
					if (intExpression != originalReductionExpression.getExpressions().get(i))
						reductionExpression.getExpressions().add(originalReductionExpression.getExpressions().get(i).copy());
			}
			return reductionExpression.simplify();
		} else {
			for(IntExpression intExpression : originalReductionExpression.getExpressions()) {
				reductionExpression.getExpressions().add((IntExpression) scale(intExpression,value));
			}
			return reductionExpression.simplify();
		}
	}

	public static IntExpression debug(String name, IntExpression input, IntExpression output) {
		if(VERBOSE) {
			System.out.println("rule "+name+" :\n\t"+input+" -> "+output);
		}
		return output;
	}
}