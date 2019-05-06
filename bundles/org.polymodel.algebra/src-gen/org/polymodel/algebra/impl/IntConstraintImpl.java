/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.impl;

import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.polymodel.algebra.AlgebraPackage;
import org.polymodel.algebra.AlgebraVisitor;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.polynomials.PolynomialExpression;
import org.polymodel.algebra.prettyprinter.algebra.AlgebraPrettyPrinter;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.algebra.quasiAffine.QuasiAffineExpression;
import org.polymodel.algebra.quasiAffine.QuasiAffineTerm;
import org.polymodel.algebra.reductions.ReductionExpression;
import org.polymodel.algebra.tom.Isolate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Int Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.algebra.impl.IntConstraintImpl#getLhs <em>Lhs</em>}</li>
 *   <li>{@link org.polymodel.algebra.impl.IntConstraintImpl#getRhs <em>Rhs</em>}</li>
 *   <li>{@link org.polymodel.algebra.impl.IntConstraintImpl#getComparisonOperator <em>Comparison Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IntConstraintImpl extends EObjectImpl implements IntConstraint {
	/**
	 * The cached value of the '{@link #getLhs() <em>Lhs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLhs()
	 * @generated
	 * @ordered
	 */
	protected IntExpression lhs;

	/**
	 * The cached value of the '{@link #getRhs() <em>Rhs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRhs()
	 * @generated
	 * @ordered
	 */
	protected IntExpression rhs;

	/**
	 * The default value of the '{@link #getComparisonOperator() <em>Comparison Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComparisonOperator()
	 * @generated
	 * @ordered
	 */
	protected static final ComparisonOperator COMPARISON_OPERATOR_EDEFAULT = ComparisonOperator.EQ;

	/**
	 * The cached value of the '{@link #getComparisonOperator() <em>Comparison Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComparisonOperator()
	 * @generated
	 * @ordered
	 */
	protected ComparisonOperator comparisonOperator = COMPARISON_OPERATOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlgebraPackage.Literals.INT_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntExpression getLhs() {
		return lhs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLhs(IntExpression newLhs, NotificationChain msgs) {
		IntExpression oldLhs = lhs;
		lhs = newLhs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlgebraPackage.INT_CONSTRAINT__LHS, oldLhs, newLhs);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLhs(IntExpression newLhs) {
		if (newLhs != lhs) {
			NotificationChain msgs = null;
			if (lhs != null)
				msgs = ((InternalEObject)lhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlgebraPackage.INT_CONSTRAINT__LHS, null, msgs);
			if (newLhs != null)
				msgs = ((InternalEObject)newLhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlgebraPackage.INT_CONSTRAINT__LHS, null, msgs);
			msgs = basicSetLhs(newLhs, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlgebraPackage.INT_CONSTRAINT__LHS, newLhs, newLhs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntExpression getRhs() {
		return rhs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRhs(IntExpression newRhs, NotificationChain msgs) {
		IntExpression oldRhs = rhs;
		rhs = newRhs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlgebraPackage.INT_CONSTRAINT__RHS, oldRhs, newRhs);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRhs(IntExpression newRhs) {
		if (newRhs != rhs) {
			NotificationChain msgs = null;
			if (rhs != null)
				msgs = ((InternalEObject)rhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlgebraPackage.INT_CONSTRAINT__RHS, null, msgs);
			if (newRhs != null)
				msgs = ((InternalEObject)newRhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlgebraPackage.INT_CONSTRAINT__RHS, null, msgs);
			msgs = basicSetRhs(newRhs, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlgebraPackage.INT_CONSTRAINT__RHS, newRhs, newRhs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComparisonOperator getComparisonOperator() {
		return comparisonOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComparisonOperator(ComparisonOperator newComparisonOperator) {
		ComparisonOperator oldComparisonOperator = comparisonOperator;
		comparisonOperator = newComparisonOperator == null ? COMPARISON_OPERATOR_EDEFAULT : newComparisonOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlgebraPackage.INT_CONSTRAINT__COMPARISON_OPERATOR, oldComparisonOperator, comparisonOperator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public boolean isAffine() {
		return rhs instanceof AffineExpression && lhs instanceof AffineExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public boolean isQuasiAffine() {
		return rhs instanceof QuasiAffineExpression && lhs instanceof QuasiAffineExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public boolean isPolynomial() {
		return rhs instanceof PolynomialExpression && lhs instanceof PolynomialExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final AlgebraVisitor visitor) {
		visitor.visitIntConstraint(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IntConstraint substitute(Variable substituted, Variable newVar) {
		IntExpression lhs = getLhs().substitute(substituted, newVar);
		IntExpression rhs2 = getRhs();
		IntExpression rhs = rhs2.substitute(substituted, newVar);
		return IntExpressionBuilder.constraint(lhs,rhs, getComparisonOperator());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IntConstraint substitute(Variable substituted, IntExpression newExpr) {
		return IntExpressionBuilder.constraint(getLhs().substitute(substituted, newExpr),
				getRhs().substitute(substituted, newExpr), getComparisonOperator());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AlgebraPackage.INT_CONSTRAINT__LHS:
				return basicSetLhs(null, msgs);
			case AlgebraPackage.INT_CONSTRAINT__RHS:
				return basicSetRhs(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AlgebraPackage.INT_CONSTRAINT__LHS:
				return getLhs();
			case AlgebraPackage.INT_CONSTRAINT__RHS:
				return getRhs();
			case AlgebraPackage.INT_CONSTRAINT__COMPARISON_OPERATOR:
				return getComparisonOperator();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AlgebraPackage.INT_CONSTRAINT__LHS:
				setLhs((IntExpression)newValue);
				return;
			case AlgebraPackage.INT_CONSTRAINT__RHS:
				setRhs((IntExpression)newValue);
				return;
			case AlgebraPackage.INT_CONSTRAINT__COMPARISON_OPERATOR:
				setComparisonOperator((ComparisonOperator)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AlgebraPackage.INT_CONSTRAINT__LHS:
				setLhs((IntExpression)null);
				return;
			case AlgebraPackage.INT_CONSTRAINT__RHS:
				setRhs((IntExpression)null);
				return;
			case AlgebraPackage.INT_CONSTRAINT__COMPARISON_OPERATOR:
				setComparisonOperator(COMPARISON_OPERATOR_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AlgebraPackage.INT_CONSTRAINT__LHS:
				return lhs != null;
			case AlgebraPackage.INT_CONSTRAINT__RHS:
				return rhs != null;
			case AlgebraPackage.INT_CONSTRAINT__COMPARISON_OPERATOR:
				return comparisonOperator != COMPARISON_OPERATOR_EDEFAULT;
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
			case AlgebraPackage.INT_CONSTRAINT___IS_AFFINE:
				return isAffine();
			case AlgebraPackage.INT_CONSTRAINT___IS_QUASI_AFFINE:
				return isQuasiAffine();
			case AlgebraPackage.INT_CONSTRAINT___IS_POLYNOMIAL:
				return isPolynomial();
			case AlgebraPackage.INT_CONSTRAINT___ACCEPT__ALGEBRAVISITOR:
				accept((AlgebraVisitor)arguments.get(0));
				return null;
			case AlgebraPackage.INT_CONSTRAINT___SUBSTITUTE__VARIABLE_VARIABLE:
				return substitute((Variable)arguments.get(0), (Variable)arguments.get(1));
			case AlgebraPackage.INT_CONSTRAINT___SUBSTITUTE__VARIABLE_INTEXPRESSION:
				return substitute((Variable)arguments.get(0), (IntExpression)arguments.get(1));
			case AlgebraPackage.INT_CONSTRAINT___SIMPLIFY:
				return simplify();
			case AlgebraPackage.INT_CONSTRAINT___IS_EQUIVALENT__INTCONSTRAINT:
				return isEquivalent((IntConstraint)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(getLhs().toString());
		switch (getComparisonOperator()) {
		case EQ:
			stringBuffer.append(" == ");
			break;
		case GE:
			stringBuffer.append(" >= ");
			break;
		case GT:
			stringBuffer.append(" > ");
			break;
		case LE:
			stringBuffer.append(" <= ");
			break;
		case LT:
			stringBuffer.append(" < ");
			break;
		case NE:
			stringBuffer.append(" != ");
			break;
		}
		stringBuffer.append(getRhs().toString());
		return stringBuffer.toString();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IntConstraint copy() {
		Copier copier = new Copier();
		IntConstraint  res = (IntConstraint) copier.copy(this);
		copier.copyReferences();
		return res;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IntConstraint simplify() {
		return IntExpressionBuilder.constraint(getLhs().simplify(), getRhs().simplify(), getComparisonOperator());	
	}

	/**
	 * <!-- begin-user-doc -->
	 * Current implementation check if LHS==LHS and RHS == RHS and OP == OP and nothing else.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public FuzzyBoolean isEquivalent(IntConstraint other) {
		FuzzyBoolean lhsEquivalency = null;
		FuzzyBoolean rhsEquivalency = null;
		// Get equivalence between RHS and LHS
		if (this.getComparisonOperator() == other.getComparisonOperator()) {
			lhsEquivalency = this.getLhs().simplify().isEquivalent(other.getLhs().simplify());
			rhsEquivalency = this.getRhs().simplify().isEquivalent(other.getRhs().simplify());
		} else if (this.getComparisonOperator() == ComparisonOperator.getOpposite(other.getComparisonOperator())) {
			lhsEquivalency = this.getLhs().simplify().isEquivalent(other.getRhs().simplify());
			rhsEquivalency = this.getRhs().simplify().isEquivalent(other.getLhs().simplify());
		}
		
		// Check equivalence between RHS and LHS
		if (lhsEquivalency != null && rhsEquivalency != null) {
			if (lhsEquivalency == FuzzyBoolean.YES) { 
				return rhsEquivalency;
			} else if (lhsEquivalency == FuzzyBoolean.MAYBE) { 
				if (rhsEquivalency == FuzzyBoolean.YES || rhsEquivalency == FuzzyBoolean.MAYBE)
					return FuzzyBoolean.MAYBE;
				else
					return FuzzyBoolean.NO;
			}
		}
		return FuzzyBoolean.NO;
	}


	public String toString(OUTPUT_FORMAT format) {
		return AlgebraPrettyPrinter.print(this, format);
	}
	

	
	private long getCoefficientOf(Variable var) {
		return getCoefficientOfIn(var, allToLHS().simplify().getLhs());
	}

	private long getCoefficientOfIn(Variable var,IntExpression expr) {
		long targetCoef = 0;
	
		if(expr.toAffine() != null){
			AffineExpression affine = expr.toAffine();
			for (AffineTerm term : affine.getTerms()) {
				if (term.getVariable() != null && term.getVariable().equals(var)) {
					targetCoef = term.getCoef();
					break;
				}
			}
		}	
		else if(expr.toQuasiAffine() != null){
			QuasiAffineExpression qaffine = expr.toQuasiAffine();
			for (QuasiAffineTerm term : qaffine.getTerms()) {
				targetCoef = getCoefficientOfIn(var, term.getExpression());
				if (targetCoef != 0) {
					break;
				}
			}
		}
		else if(expr.toReduction() != null){
			ReductionExpression red = expr.toReduction();
			for (IntExpression e : red.getExpressions()) {
				targetCoef = getCoefficientOfIn(var, e);
				if (targetCoef != 0) {
					break; 
				}
			}
		}
		else {
			throw new RuntimeException("polynomial expressions are not handled at the moment.");
		}
		
		return targetCoef;
	}

	/**
	 * Returns the expression with the term that multiplies the Variable specified removed.
	 * If the negate flag is true, negates all other terms.
	 * 
	 * @param var
	 * @param negate
	 * @return
	 */
	private AffineExpression getExpressionWithout(Variable var, boolean negate) {
		long targetCoef = 0;

		//Construct the term without the target variable
		AffineExpression Bexpr = IntExpressionBuilder.affine();

		IntExpression expr = allToLHS().simplify().getLhs();
		
		try {
			AffineExpression affine = expr.toAffine();
			for (AffineTerm term : affine.getTerms()) {
				//Constant
				if (term.getVariable() == null) {
					Bexpr.getTerms().add(term( term.getCoef(), term.getVariable()));
				//linear term
				} else if (!term.getVariable().equals(var)) {
					Bexpr.getTerms().add(term( term.getCoef(), term.getVariable()));
				//When it is the target variable, keep track of its coefficient
				} else {
					targetCoef = term.getCoef();
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("Only affine expressions are handled at the moment.");
		}
		
		//If the target was not involved in the expression, skip
		if (targetCoef == 0) {
			return null;
		}
		
		//When no term is set, give 0
		if (Bexpr.getTerms().size() == 0) {
			Bexpr.getTerms().add(IntExpressionBuilder.term(0));
		}
		
		//When specified negate all terms
		//This is for lower bounds
		if (negate) {
			for (AffineTerm term : Bexpr.getTerms()) {
				term.setCoef(term.getCoef()*-1);
			}
		}
		
		
		return Bexpr;
	}
	
	/**
	 * The semantics of this function is not very well defined, and more 
	 * importantly its scope of application is somewhat unclear. 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Deprecated
	public IntExpression getUB(Variable var) {		
		IntConstraint constraint = Isolate.isolateToLhs(this, var); //this will isolate var on Lhs and scale its coef to 1
		//if the constraint does not involve the target variable
		if(constraint == null) return null;
		ComparisonOperator op = constraint.getComparisonOperator();
		if(op == ComparisonOperator.LE || op == ComparisonOperator.EQ)
			return constraint.getRhs();
		else if (op == ComparisonOperator.LT) {
			return IntExpressionBuilder.add(constraint.getRhs(), -1);
		} 
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IntExpression getLB(Variable var) {
		
		//First get the coefficient of the target variable
		long targetCoef = getCoefficientOf(var);
		
		//If the target is not involved or not relevant for lower bound, return null
		if (targetCoef <= 0 && getComparisonOperator() != ComparisonOperator.EQ) {
			return null;
		}
		
		//Otherwise, get the term without the target variable
		//negate if the operator is not equality
		AffineExpression expr;
		if ((getComparisonOperator() == ComparisonOperator.EQ && targetCoef > 0) || (getComparisonOperator() != ComparisonOperator.EQ && targetCoef > 0)) {
			expr = getExpressionWithout(var, true);
		} else {
			expr = getExpressionWithout(var, false);
		}
		
		//If the coefficient is larger than one, divide and take the ceiling
		if (Math.abs(targetCoef) > 1) {
			return IntExpressionBuilder.qaffine(IntExpressionBuilder.floord(expr, targetCoef));
		}
		
		return expr;
		
		//TODO
//		IntConstraint constraint = Isolate.isolateToLhs(this, var); //this will isolate var on Lhs and scale its coef to 1
//		ComparisonOperator op = constraint.getComparisonOperator();
//		if(op == ComparisonOperator.GE || op == ComparisonOperator.EQ)
//			return constraint.getRhs();
//		else if (op == ComparisonOperator.GT) {
//			return IntExpressionBuilder.add(constraint.getRhs(), 1);
//		} 
//		return null;
	}
	
	/**
	 * Moves RHS to LHS so that the RHS expression is 0.
	 * 
	 * @return
	 */
	private IntConstraint allToLHS() {
		IntConstraint expr = this.copy();
		
		expr.setLhs(IntExpressionBuilder.sub(expr.getLhs(), expr.getRhs()));
		expr.setRhs(IntExpressionBuilder.constant(0));
		
		return expr;
	}

} //IntConstraintImpl
