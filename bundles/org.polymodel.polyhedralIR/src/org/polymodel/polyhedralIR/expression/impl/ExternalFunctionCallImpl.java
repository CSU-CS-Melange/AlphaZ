/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.expression.impl;


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ExternalFunctionDeclaration;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.expression.ExpressionPackage;
import org.polymodel.polyhedralIR.expression.ExternalFunctionCall;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Function Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.expression.impl.ExternalFunctionCallImpl#getExFunc <em>Ex Func</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalFunctionCallImpl extends MultiArgExpressionImpl implements ExternalFunctionCall {
	/**
	 * The cached value of the '{@link #getExFunc() <em>Ex Func</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExFunc()
	 * @generated
	 * @ordered
	 */
	protected ExternalFunctionDeclaration exFunc;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalFunctionCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionPackage.Literals.EXTERNAL_FUNCTION_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalFunctionDeclaration getExFunc() {
		if (exFunc != null && exFunc.eIsProxy()) {
			InternalEObject oldExFunc = (InternalEObject)exFunc;
			exFunc = (ExternalFunctionDeclaration)eResolveProxy(oldExFunc);
			if (exFunc != oldExFunc) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionPackage.EXTERNAL_FUNCTION_CALL__EX_FUNC, oldExFunc, exFunc));
			}
		}
		return exFunc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalFunctionDeclaration basicGetExFunc() {
		return exFunc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExFunc(ExternalFunctionDeclaration newExFunc) {
		ExternalFunctionDeclaration oldExFunc = exFunc;
		exFunc = newExFunc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.EXTERNAL_FUNCTION_CALL__EX_FUNC, oldExFunc, exFunc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitExternalFunctionCall(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionPackage.EXTERNAL_FUNCTION_CALL__EX_FUNC:
				if (resolve) return getExFunc();
				return basicGetExFunc();
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
			case ExpressionPackage.EXTERNAL_FUNCTION_CALL__EX_FUNC:
				setExFunc((ExternalFunctionDeclaration)newValue);
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
			case ExpressionPackage.EXTERNAL_FUNCTION_CALL__EX_FUNC:
				setExFunc((ExternalFunctionDeclaration)null);
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
			case ExpressionPackage.EXTERNAL_FUNCTION_CALL__EX_FUNC:
				return exFunc != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public boolean equivalence(Expression expr) {
		if (!(expr instanceof ExternalFunctionCallImpl))
			return false;
		if (this.getExFunc()!=((ExternalFunctionCall) expr).getExFunc())
			return false;
		EList<Expression> lexprthis = this.getExprs();
		EList<Expression> lexprother = ((ExternalFunctionCall) expr).getExprs();
		if (lexprthis.size() != lexprother.size())
			return false;
		for (int i=0; i<lexprthis.size(); i++)
			if (!(lexprthis.get(i).equivalence(lexprother.get(i))))
				return false;
		return true;
	}
	
	@Override
	public Type getExpressionType() {
		return this.getExFunc().getOutput();
	}
	
	
} //ExternalFunctionCallImpl
