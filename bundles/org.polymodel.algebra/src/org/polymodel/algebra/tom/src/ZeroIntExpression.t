package org.polymodel.algebra.tom;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.polynomials.PolynomialVariable;

@SuppressWarnings("all")
public class ZeroIntExpression {

	%include { sl.tom }
	%include { long.tom}
	%include { algebra_common.tom}
	%include { algebra_terminals.tom}
	%include { algebra_all_ops.tom}

	private static boolean VERBOSE = false;

	private static boolean isZero;
	private static boolean isDecidable;

	public static FuzzyBoolean isZero(IntExpression intExpression) {
		try {
			isZero = false;
			isDecidable = false;
			if(VERBOSE)
				System.out.println("*** isZero : "+intExpression);
			FuzzyBoolean fuzzyBoolean = ConstantIntExpression.isConstant(intExpression);
			if (fuzzyBoolean == FuzzyBoolean.MAYBE)
				return FuzzyBoolean.MAYBE;
			else if (fuzzyBoolean == FuzzyBoolean.NO)
				return FuzzyBoolean.NO;

			`OnceBottomUp(IsZero()).visitLight(intExpression, tom.mapping.GenericIntrospector.INSTANCE);
			if(VERBOSE)
				System.out.println("*** decidable : "+isDecidable);
			if(VERBOSE)
				System.out.println("*** zero  : "+isZero+"\n");
			if (!isDecidable)
				return FuzzyBoolean.MAYBE;
			else if (isZero)
				return FuzzyBoolean.YES;
			else
				return FuzzyBoolean.NO;
		} catch(Exception e) {
			System.err.println("Visitor failure on "+intExpression+ ":"+e.getMessage());
			throw new RuntimeException("Visitor failure on "+intExpression+ ":"+e.getMessage(),e);
		}
	}

	private static void debug(String name, IntExpression intExpression) {
		if(VERBOSE)
			System.out.println("rule "+name+" :\n\t"+intExpression);
	}

	%strategy IsZero() extends Fail() {
		visit E {
			in@affine(terms(constant(0L))) -> {
				debug("R-1",`in);
				isZero = true;
				isDecidable = true;
				return `in;
			}
			in@affine(terms(constant(_))) -> {
				debug("R-2",`in);
				return `in;
			}
			in@affine(terms(term(0L,_))) -> {
				debug("R-3",`in);
				isZero = true;
				isDecidable = true;
				return `affine(terms(constant(0L)));
			}
			in@affine(terms(x1*,term(0L,_),x2*)) -> {
				debug("R-4",`in);
				return `affine(terms(x1*,x2*));
			}
			/*in -> {
				debug("R-3",`in);
				return `in;
			}*/
		}
	}
}