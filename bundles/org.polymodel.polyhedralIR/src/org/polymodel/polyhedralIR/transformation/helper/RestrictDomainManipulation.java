package org.polymodel.polyhedralIR.transformation.helper;

import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.impl.PolyhedralIRDepthFirstVisitorImpl;
import org.polymodel.polyhedralIR.util.ContextDomainCalculator;

public class RestrictDomainManipulation {
	
	/**
	 * Intersect all domain of RestrictExpression with their context domain
	 * 
	 * @param syst
	 */
	public static void intersectRestrictDomainWithContext(AffineSystem syst) {
		ContextDomainCalculator.computeContextDomain(syst);
		syst.accept(new IntersectRestrictDomainWithContext());
	}
	
	public static class IntersectRestrictDomainWithContext extends PolyhedralIRDepthFirstVisitorImpl {
		
		public IntersectRestrictDomainWithContext() {
		}
		
		@Override
		public void outRestrictExpression(RestrictExpression r) {
			Domain contDom = r.getContextDomain();
			r.setRestrictDomain(contDom.copy());
		}
	} // IntersectRestrictDomainWithContext
	
	/* -------------------------------------------------------------------------------------------- */
	
	/**
	 * Use "simplify in context" to simplify the expression of all domain of RestrictExpression
	 * 
	 * @param syst
	 */
	public static void simplInContextRestrictNotFirst(AffineSystem syst) {
		syst.accept(new SimplInContextRestrictNotFirst());
	}
	
	public static class SimplInContextRestrictNotFirst extends PolyhedralIRDepthFirstVisitorImpl {
		
		Domain _context;
		
		public SimplInContextRestrictNotFirst() {
		}
		
		@Override
		public void visitStandardEquation(StandardEquation s) {
			_context = s.getVariable().getDomain();
			s.getExpression().accept(this);
		}
		
		@Override
		public void visitDependenceExpression(DependenceExpression d) {
			Domain contOld = _context;
			_context = contOld.image(d.getDep());
			d.getExpr().accept(this);
			
			_context = contOld;
		}
		
		@Override
		public void visitReduceExpression(ReduceExpression r) {
			Domain contOld = _context;
			_context = contOld.preimage(r.getProjection());
			r.getExpr().accept(this);
			
			_context = contOld;
		}
		
		
		@Override
		public void inRestrictExpression(RestrictExpression r) {
			Domain nRestrDom = r.getRestrictDomain();
			nRestrDom.simplifyInContext(_context);
			r.setRestrictDomain(nRestrDom);
		}
		
	} // SimplInContextRestrictNotFirst
	
} // RestrictDomainManipulation
