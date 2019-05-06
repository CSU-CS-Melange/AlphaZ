package org.polymodel.polyhedralIR.recurrence.bis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Pair;
import org.polymodel.Relation;
import org.polymodel.algebra.Variable;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OPS;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.analysis.PRDGBuilder;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.BooleanExpression;
import org.polymodel.polyhedralIR.expression.CaseExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.IfExpression;
import org.polymodel.polyhedralIR.expression.IntegerExpression;
import org.polymodel.polyhedralIR.expression.RealExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.expression.UnaryExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.expression.util.ExpressionSwitch;
import org.polymodel.polyhedralIR.factory.PolyhedralIRModule;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.transformation.Inline;
import org.polymodel.polyhedralIR.transformation.RemoveUnusedVariables;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;

public class ReductionDetection {
	
	private static final PolyhedralIRUserFactory polyFact = PolyhedralIRUserFactory.eINSTANCE;

	public static boolean DEBUG = false;
	
	protected AffineSystem system;
	protected PRDG prdg;

	protected ReductionDetection(AffineSystem system) {
		this.system = system;
	}
	

	public static void detect(AffineSystem s){
		ReductionDetection rd = new ReductionDetection(s);
		rd.detect();
	}
	
	private static void debug(Object content) {
		if (DEBUG) {
			System.out.println("[ReductionDetection] " + content);
		}
	}
	
	protected void detect() {
		List<StateVectorUpdateForm> scans = ScanDetection.detect(system);

		
		prdg = PRDGBuilder.build(system);
		
		for (StateVectorUpdateForm svu : scans) {
			inspectScan(svu);
		}
	}
	
	protected void inspectScan(StateVectorUpdateForm svu) {
		if (svu.recurrenceVariables.size() != 1)
			return;
		
		RecurrenceVariable rv = svu.recurrenceVariables.get(0);
		
		if (rv.getMaxGCD() > 1) 
			return;
		
		Domain useDomain = null;
		
		for (PRDGEdge useEdge : prdg.getNode(rv.getName()).getSources()) {
			//skip self edge
			if (useEdge.getSource().getName().contentEquals(rv.getName()))
				continue;
			
			Domain dom = polyFact.createDomain(useEdge.getDomain());
			AffineFunction f = polyFact.createAffineFunction(useEdge.getFunction().getMapping());
			
			dom = dom.image(f);
			if (useDomain == null) {
				useDomain = dom;
			} else {
				useDomain = useDomain.union(dom);
			}
		}
		useDomain.simplify();

		AffineFunction scanDirection;
		{
			//have to reverse to get dependence
			List<Long> reverseDir = new ArrayList<Long>(svu.scanDirection.size());
			for (Long d : svu.scanDirection) {
				reverseDir.add(-d);
			}
			scanDirection = PolyhedralIRUtility.createUniformFunction(svu.scanDomain, reverseDir);
		}
		
		Domain shiftedScanDomain = svu.scanDomain.image(scanDirection);
		Domain scanIntersectUse = shiftedScanDomain.intersection(useDomain);
		
		debug("useDomain    : " + useDomain);
		debug("scanDomain   : " + svu.scanDomain);
		debug("scanDirection: " + scanDirection);
		debug("scanDir(scan): " + shiftedScanDomain);
		debug("scan' ^ use  : " + scanIntersectUse);
		
		if (!scanIntersectUse.isEmpty()) {
			debug("Intermediate values are used, not a reduction.");
			return;
		}
		
		boolean equivalent = true;
		Expression constantCoef = svu.coefMatrix.get(0).get(svu.coefMatrix.get(0).size()-1);
		for (Pair<Domain, Expression> init : rv.initializations) {
			equivalent &= equivalenceInContext(init.getKey(), constantCoef, init.getValue());
		}
		
		if (!equivalent) {
			debug("Initialization expressions do not match the constant coefficient.");
			return;
		}
		
		Domain reductionDomain = svu.scanDomain.copy();
		for (Pair<Domain, Expression> init : rv.initializations) {
			reductionDomain = reductionDomain.union(init.getKey());
		}
		debug("reduceDomain : " + reductionDomain);

		AffineFunction projection;
		{
			List<Variable> targets = new ArrayList<Variable>(scanDirection.getDimRHS());
			for (int i=0; i < reductionDomain.getNIndices(); i++) {
				if (svu.scanDirection.get(i) == 0) {
					targets.add(reductionDomain.getIndices().get(i));
				}
			}
			projection = PolyhedralIRUtility.createProjection(reductionDomain, targets);
		}
		
		debug("projection   : " + projection);
		
		insertReduction(svu, projection, reductionDomain, rv, constantCoef);
	}
	
	private void insertReduction(StateVectorUpdateForm svu, AffineFunction projection, Domain reductionDomain, RecurrenceVariable rv, Expression constantCoef) {
		ReduceExpression    reduceExpr = polyFact.createReduceExpression(svu.semiring.oplus, projection, constantCoef.copy());
		VariableDeclaration reduceVar  = polyFact.createVariableDeclaration(rv.getName()+"_reduce", rv.variable.getType(), reductionDomain.image(projection));
		StandardEquation    reduceEq   = polyFact.createStandardEquation(reduceVar, reduceExpr);
		system.getLocals().add(reduceVar);
		system.getEquations().add(reduceEq);
		
		DependenceExpression subExpr = polyFact.createDependenceExpression(projection.copy(), 
											polyFact.createVariableExpression(reduceVar));
		system.getEquation(rv.getName()).setExpression(subExpr);

		Inline.transformAll(system, system.getEquation(rv.getName()), false);
		RemoveUnusedVariables.apply(system);
	}
	
	private boolean equivalenceInContext(Domain context, Expression exprA, Expression exprB) {
		ExpressionEquivalenceInContext eeic = new ExpressionEquivalenceInContext(context);
		
		if (exprA.getClass() != exprB.getClass())
			return false;
		
		if (exprA instanceof BinaryExpression) {
			boolean LLRR = equivalenceInContext(context, ((BinaryExpression) exprA).getLexp(), ((BinaryExpression) exprB).getLexp()) && equivalenceInContext(context, ((BinaryExpression) exprA).getRexp(), ((BinaryExpression) exprB).getRexp());
			
			if (LLRR) return true;
			
			boolean LRRL = equivalenceInContext(context, ((BinaryExpression) exprA).getLexp(), ((BinaryExpression) exprB).getRexp()) && equivalenceInContext(context, ((BinaryExpression) exprA).getRexp(), ((BinaryExpression) exprB).getLexp());
			

			if (LRRL) return true;
		} else {
			String Astr = eeic.expressionPrinter.doSwitch(exprA);
			String Bstr = eeic.expressionPrinter.doSwitch(exprB);
			
			return Astr.contentEquals(Bstr);
		}
		
		return false;
	}
	
	public class ExpressionEquivalenceInContext {

		protected PrintExpressionWithContext expressionPrinter = new PrintExpressionWithContext();
		protected Domain context;


		
		public ExpressionEquivalenceInContext(Domain context) {
			this.context = context;
		}
		private class PrintExpressionWithContext extends ExpressionSwitch<String> {
			
			@Override
			public String caseCaseExpression(CaseExpression c) {
				throw new RuntimeException("CaseExpression is not handled");
			}

			@Override
			public String caseIfExpression(IfExpression i) {
				throw new RuntimeException("IfExpression is not handled");
			}
			
			
			@Override
			public String caseDependenceExpression(DependenceExpression d) {
				StringBuffer res = new StringBuffer();
				AffineFunction f = d.getDep();
				Relation r = f.getPMmapping().buildRelation(PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE));
				r = r.intersectDomain(context.getPMdomain());
				f = polyFact.createAffineFunction(r.buildFunction());;
				res.append(f);
				res.append("@");
				if (d.getExpr() instanceof RestrictExpression) {
					res.append("(");
					res.append(doSwitch(d.getExpr()));
					res.append(")");
				} else {
					res.append(doSwitch(d.getExpr()));
				}
				
				return res.toString();
			}
			
			@Override
			public String caseVariableExpression(VariableExpression v) {
				return v.getVarDecl().getName();
			}
			
			@Override
			public String caseUnaryExpression(UnaryExpression u) {
				return OPS.toString(u.getOperator()) + doSwitch(u.getExpr());
			}
			
			@Override
			public String caseBinaryExpression(BinaryExpression b) {
				return "(" + doSwitch(b.getLexp()) +" "+ OPS.toString(b.getOperator()) +" "+ doSwitch(b.getRexp()) + ")";
			}
			@Override
			public String caseIntegerExpression(IntegerExpression i) {
				return Long.toString(i.getValue());
			}
			@Override
			public String caseRealExpression(RealExpression r) {
				return Double.toString(r.getValue());
			}
			@Override
			public String caseBooleanExpression(BooleanExpression b) {
				return b.isValue()+"";
			}

			@Override
			public String defaultCase(EObject object) {
				throw new RuntimeException("Unhandled expression type: " + object.getClass());
			}
		}
		
	}
		
}
