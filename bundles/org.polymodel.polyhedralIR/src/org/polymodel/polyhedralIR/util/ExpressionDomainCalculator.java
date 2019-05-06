package org.polymodel.polyhedralIR.util;


import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.CaseExpression;
import org.polymodel.polyhedralIR.expression.ConstantExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.IfExpression;
import org.polymodel.polyhedralIR.expression.IndexExpression;
import org.polymodel.polyhedralIR.expression.MultiArgExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.expression.UnaryExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.impl.PolyhedralIRInheritedDepthFirstVisitorImpl;

public class ExpressionDomainCalculator extends PolyhedralIRInheritedDepthFirstVisitorImpl {
	
	protected ParameterDomain paramDomain;
	
	public static void computeExpressionDomain(Program program) {
		program.accept(new ExpressionDomainCalculator());
	}
	public static void computeExpressionDomain(AffineSystem system) {
		system.accept(new ExpressionDomainCalculator());
	}
	public static void computeExpressionDomain(ParameterDomain param, Expression expr) {
		// Note: we cannot encounter a use equation => no need to have the whole program here
		expr.accept(new ExpressionDomainCalculator(param));
	}


	protected ExpressionDomainCalculator() {
		super();
	}
	
	protected ExpressionDomainCalculator(ParameterDomain param) {
		super();
		paramDomain = param;
	}
	
	@Override
	public void inAffineSystem(AffineSystem a) {
		paramDomain = a.getParameters();
	}
	
	@Override
	public void outBinaryExpression(BinaryExpression b) {
		//Expression domain of binary expression is intersection of its children
		Domain domLExprDom = b.getLexp().getExpressionDomain();
		Domain domRExprDom = b.getRexp().getExpressionDomain();
		
		/* DEBUG
		System.out.println();
		System.out.println("b = " + PolyhedralIRToAlphabets.toString(b));
		System.out.println("domLExprDom.Inds = " + domLExprDom.getIndices().toString());
		System.out.println("domLExprDom.Params = " + domLExprDom.getParams().toString());
		System.out.println("domLExprDom = " + domLExprDom.toString());
		System.out.println("domRExprDom.Inds = " + domRExprDom.getIndices().toString());
		System.out.println("domRExprDom.Params = " + domRExprDom.getParams().toString());
		System.out.println("domRExprDom = " + domRExprDom.toString());
		//*/
		b.setExpressionDomain(domLExprDom.intersection(domRExprDom));
	}
	
	@Override
	public void outCaseExpression(CaseExpression c) {
		//Create expression domain (union of all children)
		Domain dom = c.getExprs().get(0).getExpressionDomain().copy();
		for (int i = 1; i < c.getExprs().size(); i++) {
			dom = dom.union(c.getExprs().get(i).getExpressionDomain());
		}
		c.setExpressionDomain(dom);
	}
	
	@Override
	public void outConstantExpression(ConstantExpression c) {
		//Domain of constants are same as parameter domain
		c.setExpressionDomain(
				PolyhedralIRUserFactory.eINSTANCE.createFastISLDomain(
						paramDomain.getPMdomain()
				));
	}
	
	@Override
	public void outDependenceExpression(DependenceExpression d) {
		Domain exprDomSExpr = d.getExpr().getExpressionDomain();
		d.setExpressionDomain(exprDomSExpr.preimage(d.getDep()));
	}
	
	@Override
	public void outIfExpression(IfExpression i) {
		//Expression domain is intersection of its children
		i.setExpressionDomain(i.getCond().getExpressionDomain().intersection(i.getThen().getExpressionDomain()).intersection(i.getElse().getExpressionDomain()));
	}
	
	@Override
	public void outIndexExpression(IndexExpression i) {
		//Create expression domain (unconstrained domain with same number of dimensions as the LHS)
		i.setExpressionDomain(
				PolyhedralIRUserFactory.eINSTANCE.createFastISLDomain(
						PolyhedralIRUtility.createUniverseDomain(i.getFunction().getParams(), i.getFunction().getIndices()).getPMdomain()
						)
				);
	}
	
	@Override
	public void outMultiArgExpression(MultiArgExpression m) {
		//Expression domain is intersection of all children
		Domain dom = null;
		for (Expression expr : m.getExprs()) {
			if (dom == null) {
				dom = expr.getExpressionDomain().copy();
			} else {
				dom = dom.intersection(expr.getExpressionDomain());
			}
		}
		if (dom == null) {
			ParameterDomain param;
			if (m.getContainerEquation() instanceof StandardEquation)
				param = ((StandardEquation)m.getContainerEquation()).getContainerSystem().getParameters();
			else
				param = ((UseEquation)m.getContainerEquation()).getContainerSystem().getParameters();
				
			dom = PolyhedralIRUserFactory.eINSTANCE.createFastISLDomain(param.getPMdomain());
		}
		m.setExpressionDomain(dom);
	}

	@Override
	public void outReduceExpression(ReduceExpression r) {
		//Expression domain of reduction is that of its expression with the associated projection
		r.setExpressionDomain(r.getExpr().getExpressionDomain().image(r.getProjection()));
	}
	
	@Override
	public void outRestrictExpression(RestrictExpression r) {
		//Intersection of its restrict domain and its child
		Domain subExprDom = r.getExpr().getExpressionDomain();
		
		/* DEBUG
		System.out.println("\n Current Equation => " + PolyhedralIRToAlphabets.toString(r));
		
		System.out.println("=== subExprDom = " + subExprDom.toString());
		if (subExprDom instanceof FastISLDomain) {
			System.out.println("    subExprDom.islSet = " + ((FastISLDomain) subExprDom).getIslSet().toString());
			System.out.println("    subExprDom.indexes = " + subExprDom.getIndices().toString());
			System.out.println("    subExprDom.params = " + subExprDom.getParams().toString());
		}
		System.out.println("=== restrictDom = " + r.getRestrictDomain().toString());
		if (r.getRestrictDomain() instanceof FastISLDomain) {
			System.out.println("    restrictDom.islSet = " + ((FastISLDomain) r.getRestrictDomain()).getIslSet().toString());
			System.out.println("    restrictDom.indexes = " + ((FastISLDomain) r.getRestrictDomain()).getIndices().toString());
			System.out.println("    restrictDom.params = " + ((FastISLDomain) r.getRestrictDomain()).getParams().toString());
			
		}*/
		
		r.setExpressionDomain(r.getRestrictDomain().intersection(subExprDom));
	}
	
	@Override
	public void outUnaryExpression(UnaryExpression u) {
		//Expression domain of unary expression is that of its child
		u.setExpressionDomain(u.getExpr().getExpressionDomain().copy());
	}
	
	@Override
	public void outVariableExpression(VariableExpression v) {
		v.setExpressionDomain(v.getVarDecl().getDomain().copy());
	}
	
} // ExpressionDomainCalculator
