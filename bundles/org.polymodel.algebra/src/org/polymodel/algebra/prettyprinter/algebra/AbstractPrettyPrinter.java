package org.polymodel.algebra.prettyprinter.algebra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.*;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.AlgebraVisitable;
import org.polymodel.algebra.AlgebraVisitor;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntTerm;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.polynomials.PolynomialTerm;

public abstract class AbstractPrettyPrinter extends EObjectImpl implements AlgebraVisitor{
	

	protected StringBuffer buffer;
	protected IVariableResolver varResolver;

	public AbstractPrettyPrinter(){
		this.buffer = new StringBuffer();
		varResolver = new DefaultVariableResolver();
	}
	
	public AbstractPrettyPrinter(IVariableResolver resolver){
		this.buffer = new StringBuffer();
		varResolver = resolver;
	}

	public void visitIntTerm(IntTerm i) {
		buffer.append(i.getCoef());
	}

	protected String resolveVariable(Variable v) {
		return varResolver.resolve(v);
	}
	
	public void visitVariable(Variable v) {
		buffer.append(resolveVariable(v));
	}

	
	public String print(AlgebraVisitable object){
		clear();
		object.accept(this);
		return buffer.toString();
	}
	
	public void clear(){
		buffer = new StringBuffer();
	}
	
	public String separate(EList<? extends AlgebraVisitable> intExpressions, String separator) {
		boolean first=true;
		for (AlgebraVisitable algebraVisitable : intExpressions) {
			buffer.append((first?"":separator));
			algebraVisitable.accept(this);
			first=false;
		}
		return buffer.toString();
	}

	public String separateEncapsulated(EList<? extends AlgebraVisitable> intExpressions, String separator) {
		boolean first=true;
		if (intExpressions.size() == 1)
			intExpressions.get(0).accept(this);
		else
			for (AlgebraVisitable algebraVisitable : intExpressions) {
				buffer.append((first?"":separator));
				boolean no_enclose = algebraVisitable instanceof AffineExpression && 
						((AffineExpression)algebraVisitable).getTerms().size()==1 && 
						((AffineExpression)algebraVisitable).getTerms().get(0).getVariable() == null;
				if (! no_enclose) { 
					buffer.append("("); 
				}
				// add existential clauses if needed
				// this is a hack
				// LOUIS - HACK
				if (Pattern.compile(".*[^a-z]e[0-9][0-9]*.*").matcher(algebraVisitable.toString()).matches() && 
						this instanceof ISLPrettyPrinter &&
						algebraVisitable instanceof IntConstraint) {
					List<String> existentialVars = new ArrayList<>();
					for (int i=0; i<5; i++) {
						if (Pattern.compile(".*[^a-z]e"+i+"[^0-9].*").matcher(algebraVisitable.toString()).matches())
							existentialVars.add("e"+i);
					}
					
					buffer.append("exists " + String.join(", ", existentialVars) + " : ");
				}
				algebraVisitable.accept(this);
				if (! no_enclose) { 
					buffer.append(")"); 
				}
				first=false;
			}
		return buffer.toString();
	}
	
	public String separateAsNestedBinaryExpressions(EList<? extends AlgebraVisitable> intExpressions, String separator, String operator) {
		if (intExpressions.size() == 1)
			intExpressions.get(0).accept(this);
		else {
			for (int i = 0; i < intExpressions.size(); i++) {
				if (i>0) buffer.append(separator);
				if (i < intExpressions.size()-1) buffer.append(operator + "(");
				AlgebraVisitable algebraVisitable = intExpressions.get(i);
				algebraVisitable.accept(this);
			}
			for (int i = 0; i < intExpressions.size()-1; i++) {
				 buffer.append(")");
			}
		}
		return buffer.toString();
	}

	public String toString() {
		return buffer.toString();
	}
	


	/**
	 * Comparator to sort variables in affine expressions.
	 * Makes constant last.
	 * 
	 * @author yuki
	 *
	 */
	private class AffineTermSorter implements Comparator<AffineTerm> {

		public int compare(AffineTerm o1, AffineTerm o2) {
			if (o1.getVariable() == null && o2.getVariable() == null) {
				return (int)(o1.getCoef()-o2.getCoef());
			} else if (o1.getVariable() == null && o2.getVariable() != null) {
				return 1;
			} else if (o1.getVariable() != null && o2.getVariable() == null) {
				return -1;
			} else {
				return 0;
			}
		}
		
	}
	
	public String separateAffine(EList<AffineTerm> affineTerms) {
		boolean first=true;
		ECollections.sort(affineTerms, new AffineTermSorter());
		for (AffineTerm term : affineTerms) {
			if (!first && (term.getCoef() > 0 || (term.getCoef() >= 0 && term.getVariable() == null))) {
				buffer.append("+");
			}
			term.accept(this);
			if (term.getCoef() != 0) {
				first=false;
			}
		}
		return buffer.toString();
	}
	
	public String separatePolynomial(EList<PolynomialTerm> polynomialTerms) {
		boolean first=true;
		for (PolynomialTerm term : polynomialTerms) {
			double coef = (double)term.getNumerator() / (double)term.getDenominator();
			if (coef != 0) { 
				if (!first) {
					if (coef > 0)
						buffer.append(" +");
					buffer.append(" ");
				}
				term.accept(this);
				first=false;
			}
		}
		if (first) {
			buffer.append("0");
		}
		return buffer.toString();
		
	}

	/**
	 * Formats an IntConstraint so that it is more "readable".
	 * 
	 * @param ic
	 * @return
	 */
	protected IntConstraint formatConstraint(IntConstraint ic) {
		AffineExpression lhs = ic.getLhs().toAffine();
		AffineExpression rhs = ic.getRhs().toAffine();
		
		if (lhs == null || rhs == null) return ic;

		List<AffineTerm> newLHS = new LinkedList<AffineTerm>();
		List<AffineTerm> newRHS = new LinkedList<AffineTerm>();
		
		long constant = 0;
		//move to RHS if the coefficient is negative
		for (AffineTerm term : lhs.getTerms()) {
			if (term.getVariable() == null) {
				constant -= term.getCoef();
			} else if (term.getCoef() < 0) {
				newRHS.add(IntExpressionBuilder.term(-term.getCoef(), term.getVariable()));
			} else {
				newLHS.add(EcoreUtil.copy(term));
			}
		}

		//move to LHS if the coefficient is negative
		for (AffineTerm term : rhs.getTerms()) {
			if (term.getVariable() == null) {
				constant += term.getCoef();
			} else if (term.getCoef() < 0) {
				newLHS.add(IntExpressionBuilder.term(-term.getCoef(), term.getVariable()));
			} else {
				newRHS.add(EcoreUtil.copy(term));
			}
		}
		
		if (constant != 0)
			newRHS.add(IntExpressionBuilder.term(constant));
		
		if (newLHS.isEmpty()) {
			newLHS.add(IntExpressionBuilder.term(0));
		}
		if (newRHS.isEmpty()) {
			newRHS.add(IntExpressionBuilder.term(0));
		}
		
		IntConstraint newIC = IntExpressionBuilder.constraint(IntExpressionBuilder.affine(newLHS), IntExpressionBuilder.affine(newRHS), ic.getComparisonOperator());
		
		return newIC;
	}
}
