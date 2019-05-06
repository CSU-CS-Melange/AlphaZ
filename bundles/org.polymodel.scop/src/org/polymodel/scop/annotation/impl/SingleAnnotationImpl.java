/**
 */
package org.polymodel.scop.annotation.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.scop.ScopVisitor;
import org.polymodel.scop.annotation.AnnotationPackage;
import org.polymodel.scop.annotation.SingleAnnotation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class SingleAnnotationImpl extends EObjectImpl implements SingleAnnotation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SingleAnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnnotationPackage.Literals.SINGLE_ANNOTATION;
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case AnnotationPackage.SINGLE_ANNOTATION___ACCEPT__SCOPVISITOR:
				accept((ScopVisitor)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //SingleAnnotationImpl
