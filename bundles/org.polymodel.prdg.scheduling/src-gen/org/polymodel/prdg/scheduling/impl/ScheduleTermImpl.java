/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.impl;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.mul;
import static org.polymodel.algebra.factory.IntExpressionBuilder.qaffine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.Function;
import org.polymodel.OutputDimension;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.prettyprinter.algebra.AlgebraPrettyPrinter;
import org.polymodel.algebra.prettyprinter.algebra.LatexPrettyPrinter;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.prdg.scheduling.ScheduleTerm;
import org.polymodel.prdg.scheduling.SchedulingConcreteFactory;
import org.polymodel.prdg.scheduling.SchedulingFactory;
import org.polymodel.prdg.scheduling.SchedulingPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Schedule Term</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.impl.ScheduleTermImpl#getVar <em>Var</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.impl.ScheduleTermImpl#getExp <em>Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScheduleTermImpl extends EObjectImpl implements ScheduleTerm {
	/**
	 * The cached value of the '{@link #getVar() <em>Var</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getVar()
	 * @generated
	 * @ordered
	 */
	protected Variable var;

	/**
	 * The cached value of the '{@link #getExp() <em>Exp</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getExp()
	 * @generated
	 * @ordered
	 */
	protected AffineExpression exp;

	private SchedulingConcreteFactory schedulingConcreteFactory = PolymodelComponent.INSTANCE
			.getInstance(SchedulingConcreteFactory.class);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ScheduleTermImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulingPackage.Literals.SCHEDULE_TERM;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getVar() {
		if (var != null && var.eIsProxy()) {
			InternalEObject oldVar = (InternalEObject)var;
			var = (Variable)eResolveProxy(oldVar);
			if (var != oldVar) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulingPackage.SCHEDULE_TERM__VAR, oldVar, var));
			}
		}
		return var;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetVar() {
		return var;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setVar(Variable newVar) {
		Variable oldVar = var;
		var = newVar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.SCHEDULE_TERM__VAR, oldVar, var));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AffineExpression getExp() {
		if (exp != null && exp.eIsProxy()) {
			InternalEObject oldExp = (InternalEObject)exp;
			exp = (AffineExpression)eResolveProxy(oldExp);
			if (exp != oldExp) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulingPackage.SCHEDULE_TERM__EXP, oldExp, exp));
			}
		}
		return exp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AffineExpression basicGetExp() {
		return exp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setExp(AffineExpression newExp) {
		AffineExpression oldExp = exp;
		exp = newExp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.SCHEDULE_TERM__EXP, oldExp, exp));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isConstant() {
		return var == null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<ScheduleTerm> distribute() {
		EList<ScheduleTerm> distTerms = new BasicEList<ScheduleTerm>();
		for (AffineTerm iterm : exp.getTerms()) {
			ScheduleTerm dterm = schedulingConcreteFactory.createScheduleTerm(
					var, affine(EcoreUtil.copy(iterm)));
			distTerms.add(dterm);
		}
		return distTerms;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public boolean isNull() {
		for (AffineTerm t : exp.getTerms()) {
			if (t.getCoef() != 0)
				return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void simplify() {
		AffineExpression simplified = affine(exp.simplify());
		exp = simplified;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ScheduleTerm apply(Function mapping) {
		AffineExpression copy = (AffineExpression) exp.copy();

		if (!(exp.isConstant() == FuzzyBoolean.YES)) {
			for (Entry<OutputDimension, IntExpression> entry : mapping.getExpressionsMap().entrySet()) {
				copy = (AffineExpression) copy.substitute(entry.getKey().getDimension(),
						entry.getValue());
			}
		}
		ScheduleTerm sterm = SchedulingFactory.eINSTANCE.createScheduleTerm();
		sterm.setExp((AffineExpression) copy.simplify());
		sterm.setVar(var);

		return sterm;
	}

	@Override
	public IntExpression applyScheduleCoeficients(
			Map<Variable, IntExpression> mapping) {
		EList<ScheduleTerm> distributed = this.distribute();
		List<AffineTerm> applied = new ArrayList<AffineTerm>();
		
		for (ScheduleTerm term : distributed) {
			IntExpression value = mapping.get(var);
			if(value==null)
				value = affine(term(0));
			AffineExpression affine = value.toAffine();
			if (affine.isConstant() == FuzzyBoolean.YES) {
				long coef = affine.getTerms().get(0).getCoef();
				if (coef != 0)
					applied.addAll(applyScheduleCoeficient(term, (int) coef)
							.getTerms());
			} else {
				throw new IllegalArgumentException("Can't apply " + affine
						+ " to " + var);
			}
		}
		return affine(applied);
	}

	private AffineExpression applyScheduleCoeficient(ScheduleTerm term,
			int value) {
		return qaffine(mul(term.getExp().copy().toAffine(), value)).toAffine();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ScheduleTerm negate() {
		ScheduleTerm negt = SchedulingFactory.eINSTANCE.createScheduleTerm();
		negt.setVar(getVar());
		negt.setExp(negate(getExp()));
		return negt;
	}

	private static AffineExpression negate(AffineExpression iterm) {
		AffineExpression simplified = qaffine(mul(iterm, -1)).simplify()
				.toAffine();
		return simplified;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulingPackage.SCHEDULE_TERM__VAR:
				if (resolve) return getVar();
				return basicGetVar();
			case SchedulingPackage.SCHEDULE_TERM__EXP:
				if (resolve) return getExp();
				return basicGetExp();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SchedulingPackage.SCHEDULE_TERM__VAR:
				setVar((Variable)newValue);
				return;
			case SchedulingPackage.SCHEDULE_TERM__EXP:
				setExp((AffineExpression)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SchedulingPackage.SCHEDULE_TERM__VAR:
				setVar((Variable)null);
				return;
			case SchedulingPackage.SCHEDULE_TERM__EXP:
				setExp((AffineExpression)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SchedulingPackage.SCHEDULE_TERM__VAR:
				return var != null;
			case SchedulingPackage.SCHEDULE_TERM__EXP:
				return exp != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SchedulingPackage.SCHEDULE_TERM___IS_CONSTANT:
				return isConstant();
			case SchedulingPackage.SCHEDULE_TERM___DISTRIBUTE:
				return distribute();
			case SchedulingPackage.SCHEDULE_TERM___APPLY__FUNCTION:
				return apply((Function)arguments.get(0));
			case SchedulingPackage.SCHEDULE_TERM___NEGATE:
				return negate();
			case SchedulingPackage.SCHEDULE_TERM___SIMPLIFY:
				simplify();
				return null;
			case SchedulingPackage.SCHEDULE_TERM___IS_NULL:
				return isNull();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		if (var != null) {
			sb.append(var.toString());
			sb.append("*");
		}
		if (exp != null) {
			if (exp.getTerms().size() > 1)
				sb.append("(").append(exp).append(")");
			else {
				sb.append(exp);
			}
		}
		return sb.toString();
	}

	public String toLatex() {
		StringBuffer sb = new StringBuffer();
		if (var != null) {
			sb.append(LatexPrettyPrinter.latexFormatVariableName(var.getName()));
		}
		if (exp != null) {
			String print = AlgebraPrettyPrinter.print(exp, OUTPUT_FORMAT.LATEX);
			if (exp.getTerms().size() > 1)
				sb.append("(").append(print).append(")");
			else {
				if (!print.equals("1"))
					sb.append(print);
			}
		}

		return sb.toString();
	}

	@Override
	public ScheduleTerm apply(Map<Variable, IntExpression> mapping) {
		AffineExpression copy = (AffineExpression) exp.copy();

		if (!(exp.isConstant() == FuzzyBoolean.YES)) {
			Set<Entry<Variable, IntExpression>> entrySet = mapping.entrySet();
			for (Entry<Variable, IntExpression> entry : entrySet) {
				copy = (AffineExpression) copy.substitute(entry.getKey(),
						entry.getValue());
			}
		}
		ScheduleTerm sterm = SchedulingFactory.eINSTANCE.createScheduleTerm();
		sterm.setExp((AffineExpression) copy.simplify());
		sterm.setVar(var);

		return sterm;
	}

} // ScheduleTermImpl
