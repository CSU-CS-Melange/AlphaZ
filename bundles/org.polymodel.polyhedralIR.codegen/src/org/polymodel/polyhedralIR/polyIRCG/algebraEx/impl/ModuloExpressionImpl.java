/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.algebraEx.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polymodel.algebra.AlgebraVisitor;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.impl.IntExpressionImpl;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.polyhedralIR.polyIRCG.algebraEx.AlgebraExPackage;
import org.polymodel.polyhedralIR.polyIRCG.algebraEx.ModuloExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Modulo Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.algebraEx.impl.ModuloExpressionImpl#getNumerator <em>Numerator</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.algebraEx.impl.ModuloExpressionImpl#getDenominator <em>Denominator</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModuloExpressionImpl extends IntExpressionImpl implements ModuloExpression {
	/**
	 * The cached value of the '{@link #getNumerator() <em>Numerator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumerator()
	 * @generated
	 * @ordered
	 */
	protected IntExpression numerator;

	/**
	 * The cached value of the '{@link #getDenominator() <em>Denominator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDenominator()
	 * @generated
	 * @ordered
	 */
	protected IntExpression denominator;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModuloExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlgebraExPackage.Literals.MODULO_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntExpression getNumerator() {
		return numerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNumerator(IntExpression newNumerator, NotificationChain msgs) {
		IntExpression oldNumerator = numerator;
		numerator = newNumerator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlgebraExPackage.MODULO_EXPRESSION__NUMERATOR, oldNumerator, newNumerator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumerator(IntExpression newNumerator) {
		if (newNumerator != numerator) {
			NotificationChain msgs = null;
			if (numerator != null)
				msgs = ((InternalEObject)numerator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlgebraExPackage.MODULO_EXPRESSION__NUMERATOR, null, msgs);
			if (newNumerator != null)
				msgs = ((InternalEObject)newNumerator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlgebraExPackage.MODULO_EXPRESSION__NUMERATOR, null, msgs);
			msgs = basicSetNumerator(newNumerator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlgebraExPackage.MODULO_EXPRESSION__NUMERATOR, newNumerator, newNumerator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntExpression getDenominator() {
		return denominator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDenominator(IntExpression newDenominator, NotificationChain msgs) {
		IntExpression oldDenominator = denominator;
		denominator = newDenominator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlgebraExPackage.MODULO_EXPRESSION__DENOMINATOR, oldDenominator, newDenominator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDenominator(IntExpression newDenominator) {
		if (newDenominator != denominator) {
			NotificationChain msgs = null;
			if (denominator != null)
				msgs = ((InternalEObject)denominator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlgebraExPackage.MODULO_EXPRESSION__DENOMINATOR, null, msgs);
			if (newDenominator != null)
				msgs = ((InternalEObject)newDenominator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlgebraExPackage.MODULO_EXPRESSION__DENOMINATOR, null, msgs);
			msgs = basicSetDenominator(newDenominator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlgebraExPackage.MODULO_EXPRESSION__DENOMINATOR, newDenominator, newDenominator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AlgebraExPackage.MODULO_EXPRESSION__NUMERATOR:
				return basicSetNumerator(null, msgs);
			case AlgebraExPackage.MODULO_EXPRESSION__DENOMINATOR:
				return basicSetDenominator(null, msgs);
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
			case AlgebraExPackage.MODULO_EXPRESSION__NUMERATOR:
				return getNumerator();
			case AlgebraExPackage.MODULO_EXPRESSION__DENOMINATOR:
				return getDenominator();
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
			case AlgebraExPackage.MODULO_EXPRESSION__NUMERATOR:
				setNumerator((IntExpression)newValue);
				return;
			case AlgebraExPackage.MODULO_EXPRESSION__DENOMINATOR:
				setDenominator((IntExpression)newValue);
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
			case AlgebraExPackage.MODULO_EXPRESSION__NUMERATOR:
				setNumerator((IntExpression)null);
				return;
			case AlgebraExPackage.MODULO_EXPRESSION__DENOMINATOR:
				setDenominator((IntExpression)null);
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
			case AlgebraExPackage.MODULO_EXPRESSION__NUMERATOR:
				return numerator != null;
			case AlgebraExPackage.MODULO_EXPRESSION__DENOMINATOR:
				return denominator != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public String toString() {
		return toString(OUTPUT_FORMAT.C);
	}
	

	@Override
	public String toString(OUTPUT_FORMAT format) {
		return "MOD("+numerator.toString(format)+","+denominator.toString(format)+")";
	}

	@Override
	public void accept(AlgebraVisitor visitor) {
		visitor.visitIntExpression(this);
	}

	@Override
	public FuzzyBoolean isZero() {
		return numerator.isZero();
//		if (numerator.isZero()) return true;
//		
//		return false;
	}

	@Override
	public FuzzyBoolean isConstant() {
		if((numerator.isConstant() == FuzzyBoolean.YES) &&  (denominator.isConstant()==FuzzyBoolean.YES)){
			return FuzzyBoolean.YES;
		}else if((numerator.isConstant() == FuzzyBoolean.NO) &&  (denominator.isConstant()==FuzzyBoolean.NO)){
			return FuzzyBoolean.NO;
		}else{
			return FuzzyBoolean.MAYBE;
		}
		//return (numerator.isConstant() && denominator.isConstant());
	}

} //ModuloExpressionImpl
