/**
 */
package org.polymodel.scop.annotation.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.scop.ScopVisitor;
import org.polymodel.scop.annotation.AnnotationPackage;
import org.polymodel.scop.annotation.VectorizationAnnotation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Vectorization Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.scop.annotation.impl.VectorizationAnnotationImpl#isIvdep <em>Ivdep</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VectorizationAnnotationImpl extends EObjectImpl implements VectorizationAnnotation {
	/**
	 * The default value of the '{@link #isIvdep() <em>Ivdep</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIvdep()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IVDEP_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIvdep() <em>Ivdep</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIvdep()
	 * @generated
	 * @ordered
	 */
	protected boolean ivdep = IVDEP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VectorizationAnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnnotationPackage.Literals.VECTORIZATION_ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIvdep() {
		return ivdep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIvdep(boolean newIvdep) {
		boolean oldIvdep = ivdep;
		ivdep = newIvdep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnnotationPackage.VECTORIZATION_ANNOTATION__IVDEP, oldIvdep, ivdep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final ScopVisitor visitor) {
		visitor.visitIScopAnnotation(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AnnotationPackage.VECTORIZATION_ANNOTATION__IVDEP:
				return isIvdep();
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
			case AnnotationPackage.VECTORIZATION_ANNOTATION__IVDEP:
				setIvdep((Boolean)newValue);
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
			case AnnotationPackage.VECTORIZATION_ANNOTATION__IVDEP:
				setIvdep(IVDEP_EDEFAULT);
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
			case AnnotationPackage.VECTORIZATION_ANNOTATION__IVDEP:
				return ivdep != IVDEP_EDEFAULT;
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
			case AnnotationPackage.VECTORIZATION_ANNOTATION___ACCEPT__SCOPVISITOR:
				accept((ScopVisitor)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (ivdep: ");
		result.append(ivdep);
		result.append(')');
		return result.toString();
	}

} //VectorizationAnnotationImpl
