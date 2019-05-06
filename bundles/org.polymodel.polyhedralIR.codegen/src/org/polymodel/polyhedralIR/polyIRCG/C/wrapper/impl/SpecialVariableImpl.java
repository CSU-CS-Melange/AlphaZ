/**
 */
package org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.CWrapperPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.SpecialVariable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Special Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.SpecialVariableImpl#getVarDecl <em>Var Decl</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.SpecialVariableImpl#getAccess <em>Access</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SpecialVariableImpl extends EObjectImpl implements SpecialVariable {
	/**
	 * The cached value of the '{@link #getVarDecl() <em>Var Decl</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarDecl()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclaration varDecl;

	/**
	 * The cached value of the '{@link #getAccess() <em>Access</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccess()
	 * @generated
	 * @ordered
	 */
	protected AffineFunction access;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecialVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CWrapperPackage.Literals.SPECIAL_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration getVarDecl() {
		if (varDecl != null && varDecl.eIsProxy()) {
			InternalEObject oldVarDecl = (InternalEObject)varDecl;
			varDecl = (VariableDeclaration)eResolveProxy(oldVarDecl);
			if (varDecl != oldVarDecl) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CWrapperPackage.SPECIAL_VARIABLE__VAR_DECL, oldVarDecl, varDecl));
			}
		}
		return varDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration basicGetVarDecl() {
		return varDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVarDecl(VariableDeclaration newVarDecl) {
		VariableDeclaration oldVarDecl = varDecl;
		varDecl = newVarDecl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CWrapperPackage.SPECIAL_VARIABLE__VAR_DECL, oldVarDecl, varDecl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineFunction getAccess() {
		if (access != null && access.eIsProxy()) {
			InternalEObject oldAccess = (InternalEObject)access;
			access = (AffineFunction)eResolveProxy(oldAccess);
			if (access != oldAccess) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CWrapperPackage.SPECIAL_VARIABLE__ACCESS, oldAccess, access));
			}
		}
		return access;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineFunction basicGetAccess() {
		return access;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccess(AffineFunction newAccess) {
		AffineFunction oldAccess = access;
		access = newAccess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CWrapperPackage.SPECIAL_VARIABLE__ACCESS, oldAccess, access));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<AffineExpression> getMemoryAccessExpressions() {
		//create identity function for the variable domain
		AffineFunction identity = PolyhedralIRUtility.createIdentityFunction(varDecl.getDomain());
		
		//compose the identity function and the access function to make sure that the indice names are the same
		AffineFunction memory_access = access.compose(identity);
		
		return memory_access.getExpressions();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CWrapperPackage.SPECIAL_VARIABLE__VAR_DECL:
				if (resolve) return getVarDecl();
				return basicGetVarDecl();
			case CWrapperPackage.SPECIAL_VARIABLE__ACCESS:
				if (resolve) return getAccess();
				return basicGetAccess();
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
			case CWrapperPackage.SPECIAL_VARIABLE__VAR_DECL:
				setVarDecl((VariableDeclaration)newValue);
				return;
			case CWrapperPackage.SPECIAL_VARIABLE__ACCESS:
				setAccess((AffineFunction)newValue);
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
			case CWrapperPackage.SPECIAL_VARIABLE__VAR_DECL:
				setVarDecl((VariableDeclaration)null);
				return;
			case CWrapperPackage.SPECIAL_VARIABLE__ACCESS:
				setAccess((AffineFunction)null);
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
			case CWrapperPackage.SPECIAL_VARIABLE__VAR_DECL:
				return varDecl != null;
			case CWrapperPackage.SPECIAL_VARIABLE__ACCESS:
				return access != null;
		}
		return super.eIsSet(featureID);
	}

} //SpecialVariableImpl
