package org.polymodel.algebra.tom;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.polynomials.PolynomialVariable;
import org.polymodel.algebra.reductions.ReductionExpression;

@SuppressWarnings("all")
public class ConstantIntExpression {

	%include { sl.tom }
	%include { long.tom}
	%include { algebra_common.tom}
	%include { algebra_terminals.tom}
	%include { algebra_all_ops.tom}

	private static final boolean VERBOSE = false;

	private static boolean isConstant;
	private static boolean isDecidable;

	public static FuzzyBoolean isConstant(IntExpression intExpression) {
		if (intExpression instanceof ReductionExpression) {
			FuzzyBoolean result = FuzzyBoolean.YES;
			for (IntExpression e : ((ReductionExpression) intExpression).getExpressions()) {
				FuzzyBoolean c = isConstant(e);
				if (c == FuzzyBoolean.MAYBE)
					result = FuzzyBoolean.MAYBE;
				if (c == FuzzyBoolean.NO)
					return FuzzyBoolean.NO;
			}
			return result;
		}
		try {
			isConstant = false;
			isDecidable = false;
			if(VERBOSE)
				System.out.println("*** isConstant : "+intExpression);
			`OnceBottomUp(IsConstant()).visitLight(intExpression, tom.mapping.GenericIntrospector.INSTANCE);
			if(VERBOSE)
				System.out.println("*** decidable : "+isDecidable);
			if(VERBOSE)
				System.out.println("*** constant  : "+isConstant+"\n");
			if (!isDecidable)
				return FuzzyBoolean.MAYBE;
			else if (isConstant)
				return FuzzyBoolean.YES;
			else
				return FuzzyBoolean.NO;
		} catch (tom.library.sl.VisitFailure f) {
			// Conservatively returns NO when something goes wrong
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

	%strategy IsConstant() extends Fail() {
		visit E {
			in@affine(terms(constant(_))) -> {
				debug("R-1",`in);
				isConstant = true;
				isDecidable = true;
				return `in;
			}
			in@affine(terms(term(0L,_))) -> {
				debug("R-2",`in);
				isConstant = true;
				isDecidable = true;
				return `affine(terms(constant(0L)));
			}
/*			in@affine(terms(x1*,term(0L,_),x2*)) -> {
				debug("R-3",`in);
				return `affine(terms(x1*,x2*));
			}
			in@affine(terms(_*,term(_,_),_*)) -> {
				debug("R-4",`in);
				return `in;
			}
*/
		}
	}
}