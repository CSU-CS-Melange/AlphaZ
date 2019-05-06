package org.polymodel.algebra.tom;
 
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.*;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.polynomials.PolynomialVariable;
import org.polymodel.algebra.quasiAffine.QuasiAffineTerm;

@SuppressWarnings("all")
public class SimplifyIntExpression  {

	%include { sl.tom }  
	%include { long.tom}     
	%include { algebra_common.tom}   
	%include { algebra_terminals.tom}    
	%include { algebra_all_ops.tom}      

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

	public static long Math_mod(long a, long b) {
		return a%b;
	}
	
	public static int Math_mul(int a, int b) {
		return a*b;
	} 

	public static int Math_floord(int a, int b) {
		return a/b;
	} 

	public static int Math_ceild(int a, int b) { 
		return (a+b-1)/b;
	} 
 
	public static IntExpression simplify(IntExpression expression) {
		try {
			if(VERBOSE) {  
				System.out.println("*** Simplifying "+expression);
			} 
			IntExpression res = `Innermost(Simplify()).visitLight(expression.copy(), tom.mapping.GenericIntrospector.INSTANCE);
			if(VERBOSE) {
				System.out.println("*** into "+res+"\n");
			}
			return res;  
		} catch(Exception e) { 
			System.err.println("Visitor failure on "+expression+ ":"+e.getMessage());
			throw new RuntimeException("Visitor failure on "+expression+ ":"+e.getMessage(),e);
			//e.printStackTrace(); 
		}
	} 
 

	public static IntExpression debug(String name, IntExpression input, IntExpression output) {
		if(VERBOSE) {
			System.out.println("rule "+name+" :\n\t"+input+" -> "+output);
		}
		return output;
	}
	public static boolean VERBOSE=false;   
	public static long ZERO=0;
	
	%strategy Simplify() extends Fail() {
		visit E {  
			in@affine(terms()) -> {
				return debug("R-1",`in,`affine(terms(constant(0)))); }
			in@affine(terms(x1*,constant(a),x2*,constant(b),x3*))  -> { 
				return debug("R0",`in,`affine(terms(x1*,x2*,x3*,constant(a+b)))); 
			}
			in@affine(terms(x1,constant(0L),x2*)) 	->  
				{ return debug("R1a",`in,`affine(terms(x1,x2*))); }
			in@affine(terms(x1*,constant(0L),x2)) 	->  
				{ return debug("R1b",`in,`affine(terms(x1*,x2))); }
			in@affine(terms(x1,term(0L,_),x2*)) -> 
				{ return debug("R2a",`in,`affine(terms(x1,x2*))); }
			in@affine(terms(x1*,term(0L,_),x2)) -> 
				{ return debug("R2b",`in,`affine(terms(x1*,x2))); }
			in@affine(terms(x1*,term(a,v),x2*,term(b,v),x3*)) -> 
				{ 
					long d=(`a)+(`b);
					if(d!=0) {
						return debug("R3",`in,`affine(terms(term(a+b,v),x1*,x2*,x3*)));
					} else {
						return debug("R3",`in,`affine(terms(x1*,x2*,x3*)));
					}
				 }
 			in@sum(EL(x1*,affine(terms(a*)),x2*,affine(terms(b*)),x3*)) -> 
 				{ return debug("R4",`in,`sum(EL(affine(terms(a*,b*)),x1*,x2*,x3*))); }
 				
			in@sum(EL(x1*,affine(terms()),x2*)) 			-> 
				{ return debug("R5",`in,`sum(EL(x1*,x2*))); }
			in@sum(EL()) -> 
				{ return debug("R6",`in,`affine(terms(constant(0L)))); }
			in@sum(EL(a)) -> 
				{ return debug("R7",`in,`a); }
			in@sum(EL(a*,sum(EL(b*)),c*)) -> 
				{ return debug("R8",`in,`sum(EL(a*,b*,c*))); }
			in@sum(EL(x1*,affine(terms(b*)),x2*,affine(terms(c*)),x3*)) -> 
				{ return debug("R20",`in,`sum(EL(x1*,x2*,x3*,affine(terms(b*,c*))))); }
			in@sum(EL(x1*,qaffine(terms(b*)),x2*,qaffine(terms(c*)),x3*)) -> 
				{ return debug("R21",`in,`sum(EL(x1*,x2*,x3*,qaffine(terms(b*,c*))))); }

 
			in@composite(op, a@affine(terms(v*)),affine(terms(constant(c)))) -> 
				{
					System.out.println("composite Unhandled operator in : " + `in);
					switch(((CompositeOperator)`op)) {
					case MOD:
						{ 
							IntExpression s = simplify(`qaffine(terms(mod(a,c))));
							return debug("R82",`in,s); 
						} 
					case DIV:
						{ return debug("R83",`in,simplify(`qaffine(terms(div(a,c))))); }
//					case CEIL:
//						return debug("R84",`in,simplify(`qaffine(terms(ceil(a,c))))); }
					case FLOOR:
						{ return debug("R85",`in,simplify(`qaffine(terms(floor(a,c))))); }
					default:
						throw new RuntimeException("Unhandled operator in : " + `in);
					} 
					
				}
			in@composite(op, a@affine(terms(constant(0L))),b) -> 
				{
					return debug("R91",`in,`affine(terms(constant(0L)))); 
				}
 
			//in@min(EL(a)) -> 
			//	{ return debug("R9",`in,`a); }
			//in@min(EL(a*,min(EL(b*)),c*)) -> 
			//	{ return debug("R10",`in,`min(EL(a,b,c))); }
			
			//in@max(EL(a)) -> 
			//	{ return debug("R11",`in,`a); }
			//in@max(EL(a*,min(EL(b*)),c*)) -> 
			//	{ return debug("R12",`in,`max(EL(a,b,c))); }



			in@qaffine(terms(op@(nceil|ndiv|nfloor|mod|nmul)(qaffine(terms(mul(aff@affine(_),a))), b)))  -> {
				switch(((QuasiAffineTerm)`op).getOperator()) {
					case CEIL:
						return debug("R13",`in,`qaffine(terms(ceil(ArithmeticOperations.scale((AffineExpression)aff, a), b))));
					case DIV:
						return debug("R13",`in,`qaffine(terms(div(ArithmeticOperations.scale((AffineExpression)aff, a), b))));
					case FLOOR:
						return debug("R13",`in,`qaffine(terms(floor(ArithmeticOperations.scale((AffineExpression)aff, a), b))));
					case MOD:
						return debug("R13",`in,`qaffine(terms(mod(ArithmeticOperations.scale((AffineExpression)aff, a), b))));
					case MUL:
						return debug("R13",`in,`qaffine(terms(mul(ArithmeticOperations.scale((AffineExpression)aff, a), b))));
					default:
						throw new RuntimeException("Unhandled operator in : " + `in);
				}
			}

			in@qaffine(terms(mul(qaffine(terms(x*)),1L)))  -> {
				return debug("R13'",`in,`qaffine(terms(x*))); }

			in@qaffine(terms(nmul(qaffine(terms(x*)),1L)))  -> {
				return debug("R13'",`in,`qaffine(terms(x*))); }

			in@sum(EL(x1*,qaffine(terms(mul(aff@affine(_),a))), x2*))  -> {
				return debug("R13",`in,`sum(EL(x1*, ArithmeticOperations.scale((AffineExpression)aff,a), x2*))); }

			in@prod(EL(x1*,qaffine(terms(mul(aff@affine(_),a))), x2*))  -> {
				return debug("R13",`in,`prod(EL(x1*, ArithmeticOperations.scale((AffineExpression)aff,a), x2*))); }

			in@max(EL(x1*,qaffine(terms(mul(aff@affine(_),a))), x2*))  -> {
				return debug("R13",`in,`max(EL(x1*, ArithmeticOperations.scale((AffineExpression)aff,a), x2*))); }

			in@min(EL(x1*,qaffine(terms(mul(aff@affine(_),a))), x2*))  -> {
				return debug("R13",`in,`min(EL(x1*, ArithmeticOperations.scale((AffineExpression)aff,a), x2*))); }


			in@qaffine(terms(mul(aff@affine(_),a)))  -> {
				if (`in.eContainer() == null)
					return debug("R13",`in,ArithmeticOperations.scale((AffineExpression)`aff, `a));
			}

		// (a)%b =(a%b)
			in@qaffine(terms(x1*,op@(floor|mod|ceil)(affine(terms(constant(a))),b),x2*))  -> {		
						long modval= 0;
						switch (((QuasiAffineTerm)`op).getOperator()) {
							case MOD:
								modval= (`a)%(`b); 
								break;  
							case FLOOR:
								modval= (`a)/(`b);
								break;
							case CEIL:
								modval= (`a + `b -1)%(`b);
								break;
							default: 
								modval= (`a)%(`b);
								break; 
						}
						long one =  1; 
						return debug("R14",`in,`qaffine(terms(x1*,mul(affine(terms(constant(modval))),one),x2*)));
			} 


			in@qaffine(terms(x1*,mul(qaffine(terms(mul(e,a))),b),x2*))  -> {
				long d = (`a)*(`b);
				if(d!=0) {
					return debug("R15prime",`in,`qaffine(terms(x1*,x2*,mul(e,d))));
				} else {
					return debug("R15prime",`in,`qaffine(terms(x1*,x2*)));
				}
			} 


			in@qaffine(terms(mul(qaffine(terms(mul(e@affine(terms(_*)),a))),b)))  -> {
				long d = (`a)*(`b);
				if(d!=0) {
					return debug("R15prime",`in,`qaffine(terms(mul(e,d))));
				} else {  
					return debug("R15prime",`in,`affine(terms()));
				}
			} 
 
			in@qaffine(terms(mul(qaffine(terms(mul(e@qaffine(terms(_*)),a))),b)))  -> {
				long d = (`a)*(`b);
				if(d!=0) {
					return debug("R15prime",`in,`qaffine(terms(mul(e,d))));
				} else {  
					return debug("R15prime",`in,`affine(terms()));
				}
			} 

			in@qaffine(terms(x1*,mul(affine(terms(_*)),0L),x2*))  -> {		
				return debug("R15",`in,`qaffine(terms(x1*,x2*)));
			} 

			in@qaffine(terms(x1*,(floor|mod|mul)(affine(terms()),_),x2*))  -> {		
				return debug("R15",`in,`qaffine(terms(x1*,x2*)));
			} 

			// (bx)%b =0
			in@qaffine(terms(x1*,mod(affine(terms(x2*,term(b,_),x3*)),b),x4*))  -> {		
				return debug("R16",`in,`qaffine(terms(x1*,mod(affine(terms(x2*,x3*)),b),x4*)));
			} 
 
			// (bx)%b =0
			in@qaffine(terms(x1*,mod(affine(terms(x2*,constant(b),x3*)),b),x4*))  -> {		
				return debug("R16bis",`in,`qaffine(terms(x1*,mod(affine(terms(x2*,x3*)),b),x4*)));
			} 

			// (bx)/b =x
			in@qaffine(terms(x1*,floor(affine(terms(x2*,term(b,a),x3*)),b),x4*))  -> {		
				return debug("R17",`in,`qaffine(terms(x1*,mul(affine(terms(term(1,a))),1),floor(affine(terms(x2*,x3*)),b),x4*)));
			} 

			// ax*ay = a*(x+y)
			in@qaffine(terms(x1*,mul(a,c),x2*,mul(b,c),x3*))  -> {		
				AffineExpression res=  ArithmeticOperations.add((AffineExpression)`a,(AffineExpression)`b);
				return debug("R22",`in,`qaffine(terms(x1*,x2*,x3*,mul(res,c))));
			}   

			in@qaffine(terms(x1*,floor(a,c),x2*,floor(b,c),x3*))  -> {		
				AffineExpression res=  ArithmeticOperations.add((AffineExpression)`a,(AffineExpression)`b);
				return debug("R23",`in,`qaffine(terms(x1*,x2*,x3*,floor(res,c))));
			} 
 
			in@qaffine(terms(
							x1*,
							mul(e0@affine(terms(_*)),a),
							x2*,
							mul(e1@affine(terms(_*)),d),
							x3*
						)
					)  -> {		  
						AffineExpression res = 
						ArithmeticOperations.add(
							ArithmeticOperations.scale((AffineExpression)`e0,`a), 
							ArithmeticOperations.scale((AffineExpression)`e1,`d)
						);
						return debug("R18",`in,`qaffine(terms(x1*,x2*,x3*,mul(res,1))));
					

					} 


			in@reduction(EL(x),_) -> {
				return debug("red(E)->E", `in, `x); 
			}
			in@sum(EL(x1*,affine(terms(a*)),x2*,affine(terms(b*)),x3*)) -> 
											{ return debug("sum0", `in, `sum(EL(affine(terms(a*,b*)),x1*,x2*,x3*))); }
			in@sum(EL(affine(a))) -> 		{ return debug("sum1", `in, `affine(a)); }
			in@sum(EL(x1*,affine(terms(term(a,v))),x2*,affine(terms(term(b,v))),x3*)) -> 
											{ return debug("sum2", `in, `sum(EL(affine(terms(term(a+b,v))),x1*,x2*,x3*))); }
			in@sum(EL(x1*,affine(terms(constant(a))),x2*,affine(terms(constant(b))),x3*)) 	-> 
											{ return debug("sum3", `in, `sum(EL(x1*,x2*,x3*,affine(terms(constant(a+b)))))); }
			in@sum(EL(y))	-> 				{ return debug("sum4", `in, `y);	}
			in@sum(EL(x1*,sum(EL(x2*)),x3*)) -> 
											{ return debug("sum5", `in, `sum(EL(x1*,x2*,x3*))); }
			in@sum(EL(x1*,affine(terms(constant(0l))),x2*)) -> 
											{ return debug("sum6", `in, `sum(EL(x1*,x2*))); }
			in@sum(EL(affine(terms(constant(a))))) -> 
											{ return debug("sum7", `in, `affine(terms(constant(a)))); }
			in@sum(EL())-> 				{ return debug("sum8", `in, `affine(terms(constant(0)))); }


				
			in@prod(EL(y))						-> { return debug("prod0", `in, `y);	}
			in@prod(EL(_*,affine(terms(constant(0l))),_*)) 	-> { return debug("prod1", `in, `affine(terms(constant(0)))); }
			in@prod(EL(x1*,affine(terms(constant(1l))),x2*)) 	-> { return debug("prod2", `in, `prod(EL(x1*,x2*))); }

			//The following two rules can create prod(..., affine(terms()), ...) which later gets converted to prod(..., 0, ...) yielding incorrect results
			//Also , PROD[2, N, N] -> SUM[PROD[2, N], 2*N] is not a correct result
			//diabling the rules due to these reasons @Tomofumi
			/*in@prod(EL(p1*, c@affine(terms(constant(x))), p2*, affine(terms(x1*, term(a,b), x2*)), p3*)) -> 
										{ return debug("prod3a", `in, `sum(EL(prod(EL(c, affine(terms(x1*,x2*)), p1*, p2*, p3*)), affine(terms(term((x)*(a), b)))))); }
			in@prod(EL(p1*, affine(terms(x1*, term(a,b), x2*)), p2*, c@affine(terms(constant(x))), p3*)) -> 
										{ return debug("prod3b", `in, `sum(EL(prod(EL(c, affine(terms(x1*,x2*)), p1*, p2*, p3*)), affine(terms(term((x)*(a), b)))))); }*/

			//constrained version of the above rules for simple cases
			in@prod(EL(affine(terms(constant(x))), affine(terms(term(a,b))))) -> { return debug("prod3xa", `in, `affine(terms(term((x)*(a), b)))); }
			in@prod(EL(affine(terms(term(a,b))), affine(terms(constant(x))))) -> { return debug("prod3xb", `in, `affine(terms(term((x)*(a), b)))); }
			
			in@prod(EL(affine(terms(constant(x))), affine(terms(x1*, term(a,b), x2*)))) -> { return debug("prod3xc", `in, `sum(EL(affine(terms(term((x)*(a), b))), prod(EL(affine(terms(constant(x))), affine(terms(x1*,x2*))))))); }
			in@prod(EL(affine(terms(x1*, term(a,b), x2*)), affine(terms(constant(x))))) -> { return debug("prod3xd", `in, `sum(EL(affine(terms(term((x)*(a), b))), prod(EL(affine(terms(constant(x))), affine(terms(x1*,x2*))))))); }


			in@prod(EL(p1*, affine(terms(constant(x))), p2*, affine(terms(constant(y))), p3*))->
											{ return debug("prod4", `in, `prod(EL(affine(terms(constant((x)*(y)))), p1*, p2*, p3*))); }
			in@prod(EL())-> 				{ return debug("prod5", `in, `affine(terms(constant(0)))); }

			in@min(EL(a))										-> { return debug("min0", `in, `a); }
			in@min(EL())										-> { return debug("min1", `in, `affine(terms(constant(0)))); }
			in@min(EL(x1*, a, x2*, a, x3*))					-> { return debug("min2", `in, `min(EL(a, x1*, x2*, x3*))); }
			in@min(EL(x1, min(EL(x2*)),x3*))				-> { return debug("min3a", `in, `min(EL(x1, x2*, x3*))); }
			in@min(EL(x1*, min(EL(x2*)),x3))				-> { return debug("min3b", `in, `min(EL(x1*, x2*, x3))); }
			in@min(EL(x1*,affine(terms(constant(a))),x2*,affine(terms(constant(b))),x3*)) 	-> 
																	{ return debug("min4", `in, `min(EL(affine(terms(constant(Math_min(a,b)))),x1*,x2*,x3*))); }
			in@min(EL(x1*, xa@affine(terms(term(c, v), constant(a))), x2*, xb@affine(terms(term(c,v), constant(b))), x3*))	
				-> { 
						if (`a<`b) { return  debug("min5a", `in, `min(EL(xa, x1*, x2*, x3*))); } else
						{ return  debug("min5b", `in, `min(EL(xb, x1*, x2*, x3*))); }
					}

			in@min(EL(x1*, xa@affine(terms(term(c, v))), x2*, xb@affine(terms(term(c,v), constant(b))), x3*))	
				-> { 
						if (`b<0) { return  debug("min6b", `in, `min(EL(xb, x1*, x2*, x3*))); } else
						{ return  debug("min6a", `in, `min(EL(xa, x1*, x2*, x3*))); }
					}

			//in@min(EL(x1*,term(a,v),x2*,term(b,v),x3*)) 		-> { return `min((term(Math_min(a,b),v),x1,x2,x3)); }
			//in@min(EL(x1*,min(x2*),x3*)) 						-> { return `min((x1,x2,x3)); }

			in@max(EL(a))										-> { return debug("max0", `in, `a); }
			in@max(EL())										-> { return debug("max1", `in, `affine(terms(constant(0)))); }
			in@max(EL(x1*, a, x2*, a, x3*))					-> { return debug("max2", `in, `max(EL(a, x1*, x2*, x3*))); }
			in@max(EL(x1, max(EL(x2*)),x3*))				-> { return debug("max3a", `in, `max(EL(x1, x2*, x3*))); }
			in@max(EL(x1*, max(EL(x2*)),x3))				-> { return debug("max3b", `in, `max(EL(x1*, x2*, x3))); }
			in@max(EL(x1*,affine(terms(constant(a))),x2*,affine(terms(constant(b))),x3*)) 	-> 
																	{ return debug("max4", `in, `max(EL(affine(terms(constant(Math_max(a,b)))),x1*,x2*,x3*))); }
		
			//simplification that involve small arithmetic comparison
			in@max(EL(x1*, xa@affine(terms(term(c,v), constant(a))), x2*, xb@affine(terms(term(c,v), constant(b))), x3*))	
				-> { 
						if (`a>`b) { return  debug("max5a", `in, `max(EL(xa, x1*, x2*, x3*))); } else
						{ return  debug("max5b", `in, `max(EL(xb, x1*, x2*, x3*))); }
				}

			in@max(EL(x1*, xa@affine(terms(term(c,v))), x2*, xb@affine(terms(term(c,v), constant(b))), x3*))	
				-> { 
						if (`b>0) { return  debug("max6b", `in, `max(EL(xb, x1*, x2*, x3*))); } else
						{ return  debug("max6a", `in, `max(EL(xa, x1*, x2*, x3*))); }
					}

			//not generic but support for two-term affine expressions -- sufficient in many cases
			in@max(EL(x1*, xa@affine(terms(term(c1,v1), term(c2,v2), constant(a))), x2*, xb@affine(terms(term(c1,v1), term(c2,v2), constant(b))), x3*))	
				-> { 
						if (`a>`b) { return  debug("max5c", `in, `max(EL(xa, x1*, x2*, x3*))); } else
						{ return  debug("max5d", `in, `max(EL(xb, x1*, x2*, x3*))); }
				}

			in@max(EL(x1*, xa@affine(terms(term(c1,v1), term(c2,v2))), x2*, xb@affine(terms(term(c1,v1), term(c2,v2), constant(b))), x3*))	
				-> { 
						if (`b>0) { return  debug("max6d", `in, `max(EL(xb, x1*, x2*, x3*))); } else
						{ return  debug("max6c", `in, `max(EL(xa, x1*, x2*, x3*))); }
					}

			//in@max(EL(x1*,term(a,v),x2*,term(b,v),x3*)) 		-> { return `max((term(Math_max(a,b),v),x1,x2,x3)); }
			//in@max(EL(term(a,v)))								-> { return `term(a,v); }
			//in@max(EL(x1*,min((x2*)),x3*))					-> { return `max((x1,x2,x3)); }

			//Polynomials
			//combine same variables within a term
			polynomial(pterms(t1*, pterm(num, den, pvars(v1*, pvar(x, ex1), v2*, pvar(x, ex2), v3*)), t2*)) -> {
				
				long numR = `num;
				long denR = `den;
				if (Math_mod(numR, denR) == 0) {
					numR = numR / denR;
					denR = 1;
				}
				return `polynomial(pterms(t1*, pterm(numR, denR, pvars(pvar(x, ex1+ex2), v1*, v2*, v3*)), t2*));
			}

			//combine two terms when variables are equal -- only for single var polynomials
			polynomial(pterms(t1*, pterm(num1, den1, pvars(var)), t2*, pterm(num2, den2, pvars(var)), t3*)) -> {
				
				long numR = `num1 * `den2 + `num2 * `den1;
				long denR = `den1 * `den2;
				if (Math_mod(numR, denR) == 0) {
					numR = numR / denR;
					denR = 1;
				}
				return `polynomial(pterms(pterm(numR, denR, pvars(var)), t1*, t2*, t3*));
			}
			
			/*
			in@polynomial(pterms(x1*, pnterm(aff@affine(terms), a), x2*)) -> {
				if (1L != `a)
					return debug("poly - R0", `in, `polynomial(terms(x1*, pnterm(ArithmeticOperations.scale((AffineExpression)aff, a), 1L), x2*)));
			}
 
			in@polynomial(pterms(x1*, pnterm(aff@affine(terms(x4*)), a), x2*,  pnterm(aff@affine(terms(x5*)), a), x3*)) -> {
				if (1L != `a)
					return debug("poly - R2", `in, `polynomial(terms(x1*, x2*, x3*, pnterm(affine(terms(x4*, x5*)), 1L))));
			}

			in@polynomial(pterms(x1*, pnterm(aff@affine(terms(constant(a))), 1L), x2*,  pterm(null, b), x3*)) -> {
				return debug("poly - R3", `in, `polynomial(terms(x1*, x2*, x3*, pterm(null, (a+b)))));
			}

			in@polynomial(pterms(pterm(null, a))) -> {
				return debug("poly - R3", `in, `affine(terms(constant(a))));
			}*/
		} 
	}
}