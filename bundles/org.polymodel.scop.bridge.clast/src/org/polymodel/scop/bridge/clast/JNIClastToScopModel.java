package org.polymodel.scop.bridge.clast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm;
import org.polymodel.algebra.quasiAffine.QuasiAffineExpression;
import org.polymodel.algebra.quasiAffine.QuasiAffineOperator;
import org.polymodel.algebra.quasiAffine.QuasiAffineTerm;
import org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.AbstractScopStatement;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopStatementMacro;
import org.polymodel.scop.ScopUserFactory;
import org.polymodel.scop.annotation.AnnotationFactory;
import org.polymodel.scop.annotation.PolyhedralDomainAnnotation;

import fr.irisa.cairn.jnimap.cloog.jni.CloogException;
import fr.irisa.cairn.jnimap.cloog.jni.JNIClastAssignment;
import fr.irisa.cairn.jnimap.cloog.jni.JNIClastBinType;
import fr.irisa.cairn.jnimap.cloog.jni.JNIClastBinary;
import fr.irisa.cairn.jnimap.cloog.jni.JNIClastBlock;
import fr.irisa.cairn.jnimap.cloog.jni.JNIClastEquation;
import fr.irisa.cairn.jnimap.cloog.jni.JNIClastExpr;
import fr.irisa.cairn.jnimap.cloog.jni.JNIClastFor;
import fr.irisa.cairn.jnimap.cloog.jni.JNIClastGuard;
import fr.irisa.cairn.jnimap.cloog.jni.JNIClastName;
import fr.irisa.cairn.jnimap.cloog.jni.JNIClastRedType;
import fr.irisa.cairn.jnimap.cloog.jni.JNIClastReduction;
import fr.irisa.cairn.jnimap.cloog.jni.JNIClastRoot;
import fr.irisa.cairn.jnimap.cloog.jni.JNIClastStmt;
import fr.irisa.cairn.jnimap.cloog.jni.JNIClastTerm;
import fr.irisa.cairn.jnimap.cloog.jni.JNIClastUserStmt;
import fr.irisa.cairn.jnimap.cloog.jni.JNICloogStatement;

public class JNIClastToScopModel {
	
	protected Map<String, Variable> varMap = new HashMap<String, Variable>();
	
	public static ScopRoot adapt(JNIClastRoot r) {
		JNIClastToScopModel adapter = new JNIClastToScopModel();
		try {
			return ScopUserFactory.scopRoot(adapter.buildStmtList(r.getNext()));
		} catch (CloogException e) {
			throw new RuntimeException("Unable to adapt the statement " + r + ": " + e);
		}
	}

	/**
	 * Builds a list of ScopNodes that are connected through the linked list structure (next())
	 * This method should be called once for each statement that is the head of the linked list
	 * to convert all nodes in the linked list.
	 * 
	 * @param adapted
	 * @return
	 * @throws CloogException
	 */
	public List<AbstractScopNode> buildStmtList(JNIClastStmt adapted) throws CloogException {
		List<AbstractScopNode> res = new LinkedList<AbstractScopNode>();

		while (adapted != null) {
			res.add(buildStmt(adapted));
			if (adapted.testNext())
				adapted = adapted.getNext();
			else 
				adapted = null;
		}
		
		return res;
	}

	/**
	 * Ignores the next() chain and parses a single statement and its sub tree.
	 * 
	 * @param adapted
	 * @return
	 * @throws CloogException 
	 */
	public AbstractScopNode buildStmt(JNIClastStmt adapted) throws CloogException {
		if (adapted.isJNIClastRoot()) {
			throw new RuntimeException("JNIClastRoot should only be at the root.");
		} else if (adapted.isJNIClastGuard()) {
			return buildGuard((JNIClastGuard) adapted);
		} else if (adapted.isJNIClastFor()) {
			return buildFor((JNIClastFor) adapted);
		} else if (adapted.isJNIClastBlock()) {
			return buildBlock((JNIClastBlock) adapted);
		} else if (adapted.isJNIClastAssignment()) {
			return buildAssignement((JNIClastAssignment) adapted);
		} else if (adapted.isJNIClastUserStmt()) {
			return buildUserStmt((JNIClastUserStmt) adapted);
		} else {
			throw new RuntimeException("unknown statement type:" + adapted);
		}	
	}
	
	
	protected AbstractScopNode buildGuard(JNIClastGuard g) throws CloogException {

		IntConstraintSystem constraints = IntExpressionBuilder.constraintSystem();

		for (int i = 0; i < g.getN(); ++i) {
			constraints.getConstraints().add(buildEquation(g.getEquation(i)));
		}
		EList<IntConstraintSystem> res = new BasicEList<IntConstraintSystem>();
		res.add(constraints);
		return ScopUserFactory.scopGuard(res, ScopUserFactory.scopBlock(buildStmtList(g.getThen())), null);
	}

	
	protected AbstractScopNode buildFor(JNIClastFor f) throws CloogException {
		return ScopUserFactory.scopFor(buildVariable(f.getIterator()), buildExpr(f.getLB()), buildExpr(f.getUB()), IntExpressionBuilder.affine(IntExpressionBuilder.term(f.getStride())), ScopUserFactory.scopBlock(buildStmtList(f.getBody())));
	}

	protected AbstractScopNode buildBlock(JNIClastBlock b) throws CloogException {
		return ScopUserFactory.scopBlock(buildStmtList(b.getBody()));
	}

	protected AbstractScopNode buildAssignement(JNIClastAssignment b) throws CloogException {
		return ScopUserFactory.scopAssignment(buildVariable(b.getLHS()), buildExpr(b.getRHS()));
	}

	protected AbstractScopStatement buildUserStmt(JNIClastUserStmt b) throws CloogException {
		
		JNICloogStatement statement = null;
		if (b.testStatement()) statement = b.getStatement();
		JNIClastStmt substitutions = null; 
		if (b.testSubstitutions()) substitutions = b.getSubstitutions();
		String name = null;
		if (statement.testName()) name = statement.getName();
		ScopStatementMacro ssm = ScopUserFactory.scopStatementMacro(name, buildSubstitutions(substitutions));
		
		if (b.getCloogDomain() != null) {
			PolyhedralDomainAnnotation pda = AnnotationFactory.eINSTANCE.createPolyhedralDomainAnnotation();
			pda.setDomain(b.getCloogDomain());
			ssm.getScopAnnotations().add(pda);
		}
		
		return ssm;
	}

	protected EList<IntExpression> buildSubstitutions(JNIClastStmt stmt) throws CloogException {
		EList<IntExpression> res = new BasicEList<IntExpression>();

		if (stmt == null)
			return res;

		do {
			if (!(stmt instanceof JNIClastAssignment)) {
				throw new RuntimeException("Expecting ClastAssignment for substitutions.");
			}
			JNIClastAssignment ca = (JNIClastAssignment) stmt;
			res.add(buildExpr(ca.getRHS()));

			if (stmt.testNext())
				stmt = stmt.getNext();
			else
				stmt = null;
		} while (stmt != null);

		return res;
	}

	public IntExpression buildExpr(JNIClastExpr e) throws CloogException {
		IntExpression exp;
		if (e == null) {
			System.err.println("Error");
		}
		if (e.isJNIClastBinary()) {
			exp = buildBinary((JNIClastBinary) e);
		} else if (e.isJNIClastName()) {
			exp = IntExpressionBuilder.affine(IntExpressionBuilder.term(buildVariable((JNIClastName) e)));
		} else if (e.isJNIClastReduction()) {
			exp = buildReduction((JNIClastReduction) e);
		} else if (e.isJNIClastTerm()) {
			//exp = IntExpressionBuilder.affine(buildTerm((JNIClastTerm) e));
			exp = buildTerm((JNIClastTerm) e);
		} else {
			throw new RuntimeException("unknown expression type:" + e);
		}
		return exp.simplify();
	}

	protected IntExpression buildBinary(JNIClastBinary e) throws CloogException {

		IntExpression lhsExp = buildExpr(e.getLHS());
		int rhsVal = e.getRHS();

		switch (e.getType().getValue()) {
		case JNIClastBinType.CLAST_BIN_CDIV: {
			IntExpression expr;
			if ( lhsExp instanceof AffineExpression ) {
				expr = IntExpressionBuilder.qaffine(IntExpressionBuilder.ceild((AffineExpression)lhsExp, rhsVal));
			} else if ( lhsExp instanceof QuasiAffineExpression ){
				expr = IntExpressionBuilder.qaffine(IntExpressionBuilder.ceild((QuasiAffineExpression)lhsExp, rhsVal));
			} else {
				throw new RuntimeException("Unhandled type of JNIClastBinary");
			}
			return expr; 
		}
		case JNIClastBinType.CLAST_BIN_DIV: {
			IntExpression expr;
			if ( lhsExp instanceof AffineExpression ) {
				expr = IntExpressionBuilder.qaffine(IntExpressionBuilder.div((AffineExpression)lhsExp, rhsVal));
			} else if ( lhsExp instanceof QuasiAffineExpression ){ 
				expr = IntExpressionBuilder.qaffine(IntExpressionBuilder.div((QuasiAffineExpression)lhsExp, rhsVal));
			} else {
				throw new RuntimeException("Unhandled type of JNIClastBinary");
			}
			return expr;
		}
		case JNIClastBinType.CLAST_BIN_FDIV: {
			IntExpression expr;
			if ( lhsExp instanceof AffineExpression ) {
				expr = IntExpressionBuilder.qaffine(IntExpressionBuilder.floord((AffineExpression)lhsExp, rhsVal));
			} else if ( lhsExp instanceof QuasiAffineExpression ) {
				expr = IntExpressionBuilder.qaffine(IntExpressionBuilder.floord((QuasiAffineExpression)lhsExp, rhsVal));
			} else {
				throw new RuntimeException("Unhandled type of JNIClastBinary");
			}
			return expr;
		}
		case JNIClastBinType.CLAST_BIN_MOD: {
			IntExpression expr;
			if ( lhsExp instanceof AffineExpression ) {
				expr = IntExpressionBuilder.qaffine(IntExpressionBuilder.mod((AffineExpression)lhsExp, rhsVal));
			} else if ( lhsExp instanceof QuasiAffineExpression ) {
				expr = IntExpressionBuilder.qaffine(IntExpressionBuilder.mod((QuasiAffineExpression)lhsExp, rhsVal));
			} else {
				throw new RuntimeException("Unhandled type of JNIClastBinary");
			}
			return expr;
		}
		default:
			throw new RuntimeException("Unahndled type of JNIClastBinary");
		}
	}

	protected IntExpression buildReduction(JNIClastReduction e) throws CloogException {
		List<IntExpression> exprs = new ArrayList<IntExpression>(e.getNumberOfElement());
		for (int i = 0; i < e.getNumberOfElement(); ++i) {
			exprs.add(buildExpr(e.getElement(i)));
		}

		switch (e.getType().getValue()) {
			case JNIClastRedType.CLAST_RED_MAX:
				return IntExpressionBuilder.max(exprs);
			case JNIClastRedType.CLAST_RED_MIN:
				return IntExpressionBuilder.min(exprs);
			case JNIClastRedType.CLAST_RED_SUM: {
				List<QuasiAffineTerm> terms = new ArrayList<>();
				for ( IntExpression expr : exprs ) {
					if ( expr instanceof AffineExpression ) {
						SimpleQuasiAffineTerm t = IntExpressionBuilder.qterm(QuasiAffineOperator.MUL, (AffineExpression)expr, 1);
						terms.add(t);
					} else if ( expr instanceof QuasiAffineExpression ) {
						NestedQuasiAffineTerm t = IntExpressionBuilder.qterm(QuasiAffineOperator.MUL, (QuasiAffineExpression)expr, 1);
						terms.add(t);
					} else {
						throw new RuntimeException("Unhandled expression for SUM in JNIClastReduction");
					}
				}
				QuasiAffineExpression qexpr = IntExpressionBuilder.qaffine(terms);
				return qexpr;
			}
		}
		throw new RuntimeException("Unhandled JNIClastReduction");
		
	}

	/*protected AffineTerm buildTerm(JNIClastTerm e) throws CloogException {
		e.getVar();
		e.getValue();
		if (e.getVar() == null) {
			return IntExpressionBuilder.term(e.getValue());
		} else {
			return IntExpressionBuilder.term(e.getValue(), buildVariable(e.getVar()));
		}
	}*/
	
	protected IntExpression buildTerm(JNIClastTerm e) throws CloogException {
		
		if (!e.testVar()) {
			return IntExpressionBuilder.affine(IntExpressionBuilder.term(e.getValue()));
		} else {
			IntExpression varExpr = buildExpr(e.getVar());
			IntExpression expr;
			if ( varExpr instanceof AffineExpression )
				expr = IntExpressionBuilder.qaffine(IntExpressionBuilder.mul((AffineExpression)varExpr, e.getValue()));
			else if ( varExpr instanceof QuasiAffineExpression )
				expr = IntExpressionBuilder.qaffine(IntExpressionBuilder.mul((QuasiAffineExpression)varExpr, e.getValue()));
			else {
				throw new RuntimeException("UnHandled Type in JNIClastTerm");
			}
			return expr;
		}
	}
	
	protected Variable buildVariable(JNIClastExpr expr) {
		if (!expr.isJNIClastName()) {
			throw new RuntimeException("Expecting JNIClastName");
		}
		
		return buildVariable(((JNIClastName)expr).getName());
	}
	protected Variable buildVariable(String var) {
		if (varMap.containsKey(var)) {
			return varMap.get(var);
		}
		
		Variable newVar = IntExpressionBuilder.var(var);
		varMap.put(var, newVar);
		
		return newVar;
	}

	public IntConstraint buildEquation(JNIClastEquation e) throws CloogException {
		if (e.getSign() < 0) {
			return IntExpressionBuilder.le(buildExpr(e.getLHS()), buildExpr(e.getRHS()));
		} else if (e.getSign() > 0) {
			return IntExpressionBuilder.ge(buildExpr(e.getLHS()), buildExpr(e.getRHS()));
		} else {
			return IntExpressionBuilder.eq(buildExpr(e.getLHS()), buildExpr(e.getRHS()));
		}
	}

}
