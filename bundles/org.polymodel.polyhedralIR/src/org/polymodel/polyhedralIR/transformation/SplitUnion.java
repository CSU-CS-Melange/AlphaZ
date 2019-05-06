package org.polymodel.polyhedralIR.transformation;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.expression.CaseExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;

/**
 * Takes an expression that has a context domain represented by unions of polyhedra,
 * and creates a caseExpression such that the domains are made disjoint.
 * 
 * @author yuki
 *
 */
public class SplitUnion {
	
	private static final boolean DEBUG = true;
	
	public static Expression split(Expression expr) {
		//check if union
		if (expr.getContextDomain().getPMdomain().getPolyhedra().size() == 1) {
			return expr;
		}
		ParameterDomain params;
		if (expr.getContainerEquation() instanceof StandardEquation)
			params = ((StandardEquation) expr.getContainerEquation()).getContainerSystem().getParameters();
		else
			params = ((UseEquation) expr.getContainerEquation()).getContainerSystem().getParameters();
		
		List<Domain> domains = splitFromPolyhedra(params, expr.getContextDomain().getIndexNames(), expr.getContextDomain().getPMdomain().getPolyhedra());

		List<Domain> newDomains = new LinkedList<Domain>();
		
		while (!domains.isEmpty()) {
			Domain takeDomain = domains.remove(0);
			newDomains.add(takeDomain);
			
			List<Domain> nextDomains = new LinkedList<Domain>();
			
			for (Domain domain : domains) {
				if (domain.intersection(takeDomain).isEmpty()) {
					nextDomains.add(domain);
				} else {
					nextDomains.addAll(splitFromPolyhedra(params, domain.getIndexNames(), domain.difference(takeDomain).getPMdomain().getPolyhedra()));
				}
			}
			
			domains = nextDomains;
		}
		
		if (DEBUG) {
			Domain union = newDomains.get(0).copy();
			for (int i = 1; i < newDomains.size(); i++) {
				union = union.union(newDomains.get(i));
			}
			boolean equivalent = union.equivalence(expr.getContextDomain());
			if (!equivalent) {
				throw new RuntimeException("New set of domains not equivalent to the old domains.");
			}
		}
		
		//Create case branches using new domain
		List<Expression> exprs = new LinkedList<Expression>();
		for (Domain dom : newDomains) {
			final Expression child;
			//copy the child in case of restrict expression
			if (expr instanceof RestrictExpression) {
				child = ((RestrictExpression)expr).getExpr().copy();
			} else {
				child = expr.copy();
			}
			exprs.add(PolyhedralIRUserFactory.eINSTANCE.createRestrictExpression(dom, child));
		}
		
		CaseExpression caseExpr = PolyhedralIRUserFactory.eINSTANCE.createCaseExpression(exprs);
		
		//Replace the expression with case in the IR
		EcoreUtil.replace(expr, caseExpr);
		
		return caseExpr;
	}
	
	/**
	 * Converts polyhedra (List<IntLinearConstraintSystem>) to list of domains.
	 * 
	 */
	private static List<Domain> splitFromPolyhedra(ParameterDomain params, List<String> indexNames, List<IntConstraintSystem> polyhedra) {
		List<Domain> domains = new LinkedList<Domain>();
		for (IntConstraintSystem ics : polyhedra) {
			List<String> constraints = new LinkedList<String>();
			for (IntConstraint ic : ics.getConstraints()) {
				constraints.add(ic.toString(OUTPUT_FORMAT.ALPHABETS));
			}
			domains.add(PolyhedralIRUtility.parseDomainFromString(params, indexNames, constraints));
		}
		
		return domains;
	}

}
