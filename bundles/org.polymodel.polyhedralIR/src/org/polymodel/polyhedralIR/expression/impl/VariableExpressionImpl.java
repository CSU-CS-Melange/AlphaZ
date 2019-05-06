/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.expression.impl;


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.ExpressionPackage;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.impl.ExpressionImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Variable Expression</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.expression.impl.VariableExpressionImpl#getVarDecl <em>Var Decl</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableExpressionImpl extends ExpressionImpl implements VariableExpression {
	/**
	 * The cached value of the '{@link #getVarDecl() <em>Var Decl</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getVarDecl()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclaration varDecl;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionPackage.Literals.VARIABLE_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration getVarDecl() {
		if (varDecl != null && varDecl.eIsProxy()) {
			InternalEObject oldVarDecl = (InternalEObject)varDecl;
			varDecl = (VariableDeclaration)eResolveProxy(oldVarDecl);
			if (varDecl != oldVarDecl) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionPackage.VARIABLE_EXPRESSION__VAR_DECL, oldVarDecl, varDecl));
			}
		}
		return varDecl;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration basicGetVarDecl() {
		return varDecl;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setVarDecl(VariableDeclaration newVarDecl) {
		VariableDeclaration oldVarDecl = varDecl;
		varDecl = newVarDecl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.VARIABLE_EXPRESSION__VAR_DECL, oldVarDecl, varDecl));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitVariableExpression(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionPackage.VARIABLE_EXPRESSION__VAR_DECL:
				if (resolve) return getVarDecl();
				return basicGetVarDecl();
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
			case ExpressionPackage.VARIABLE_EXPRESSION__VAR_DECL:
				setVarDecl((VariableDeclaration)newValue);
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
			case ExpressionPackage.VARIABLE_EXPRESSION__VAR_DECL:
				setVarDecl((VariableDeclaration)null);
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
			case ExpressionPackage.VARIABLE_EXPRESSION__VAR_DECL:
				return varDecl != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Type basicGetExpressionType() {
		return getVarDecl().getType();
	}
	
	@Override
	public boolean equivalence(Expression expr) {
		if (expr instanceof VariableExpression)
			return (this.getVarDecl() == ((VariableExpression) expr).getVarDecl());
		if (expr instanceof DependenceExpression)
			if (((DependenceExpression) expr).getDep().isIdentity())
				return (this.equivalence(((DependenceExpression) expr).getExpr()));
		return false;
	}
	
} // VariableExpressionImpl
