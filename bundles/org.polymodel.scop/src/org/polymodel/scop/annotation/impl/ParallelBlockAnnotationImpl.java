/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop.annotation.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.polymodel.scop.ScopVisitor;
import org.polymodel.scop.annotation.AnnotationPackage;
import org.polymodel.scop.annotation.ParallelBlockAnnotation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parallel Block Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.scop.annotation.impl.ParallelBlockAnnotationImpl#getPrivates <em>Privates</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParallelBlockAnnotationImpl extends EObjectImpl implements ParallelBlockAnnotation {
	/**
	 * The cached value of the '{@link #getPrivates() <em>Privates</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrivates()
	 * @generated
	 * @ordered
	 */
	protected EList<String> privates;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParallelBlockAnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnnotationPackage.Literals.PARALLEL_BLOCK_ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getPrivates() {
		if (privates == null) {
			privates = new EDataTypeUniqueEList<String>(String.class, this, AnnotationPackage.PARALLEL_BLOCK_ANNOTATION__PRIVATES);
		}
		return privates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final ScopVisitor visitor) {
		visitor.visitParallelBlockAnnotation(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AnnotationPackage.PARALLEL_BLOCK_ANNOTATION__PRIVATES:
				return getPrivates();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AnnotationPackage.PARALLEL_BLOCK_ANNOTATION__PRIVATES:
				getPrivates().clear();
				getPrivates().addAll((Collection<? extends String>)newValue);
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
			case AnnotationPackage.PARALLEL_BLOCK_ANNOTATION__PRIVATES:
				getPrivates().clear();
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
			case AnnotationPackage.PARALLEL_BLOCK_ANNOTATION__PRIVATES:
				return privates != null && !privates.isEmpty();
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
			case AnnotationPackage.PARALLEL_BLOCK_ANNOTATION___ACCEPT__SCOPVISITOR:
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
		result.append(" (privates: ");
		result.append(privates);
		result.append(')');
		return result.toString();
	}

} //ParallelBlockAnnotationImpl
