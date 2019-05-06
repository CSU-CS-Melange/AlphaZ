/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.quasiAffine.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.polymodel.algebra.AlgebraVisitable;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.IntTerm;
import org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm;
import org.polymodel.algebra.quasiAffine.QuasiAffineExpression;
import org.polymodel.algebra.quasiAffine.QuasiAffinePackage;
import org.polymodel.algebra.quasiAffine.QuasiAffineTerm;
import org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.polymodel.algebra.quasiAffine.QuasiAffinePackage
 * @generated
 */
public class QuasiAffineSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QuasiAffinePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuasiAffineSwitch() {
		if (modelPackage == null) {
			modelPackage = QuasiAffinePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case QuasiAffinePackage.QUASI_AFFINE_EXPRESSION: {
				QuasiAffineExpression quasiAffineExpression = (QuasiAffineExpression)theEObject;
				T result = caseQuasiAffineExpression(quasiAffineExpression);
				if (result == null) result = caseIntExpression(quasiAffineExpression);
				if (result == null) result = caseAlgebraVisitable(quasiAffineExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QuasiAffinePackage.QUASI_AFFINE_TERM: {
				QuasiAffineTerm quasiAffineTerm = (QuasiAffineTerm)theEObject;
				T result = caseQuasiAffineTerm(quasiAffineTerm);
				if (result == null) result = caseIntTerm(quasiAffineTerm);
				if (result == null) result = caseAlgebraVisitable(quasiAffineTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QuasiAffinePackage.SIMPLE_QUASI_AFFINE_TERM: {
				SimpleQuasiAffineTerm simpleQuasiAffineTerm = (SimpleQuasiAffineTerm)theEObject;
				T result = caseSimpleQuasiAffineTerm(simpleQuasiAffineTerm);
				if (result == null) result = caseQuasiAffineTerm(simpleQuasiAffineTerm);
				if (result == null) result = caseIntTerm(simpleQuasiAffineTerm);
				if (result == null) result = caseAlgebraVisitable(simpleQuasiAffineTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QuasiAffinePackage.NESTED_QUASI_AFFINE_TERM: {
				NestedQuasiAffineTerm nestedQuasiAffineTerm = (NestedQuasiAffineTerm)theEObject;
				T result = caseNestedQuasiAffineTerm(nestedQuasiAffineTerm);
				if (result == null) result = caseQuasiAffineTerm(nestedQuasiAffineTerm);
				if (result == null) result = caseIntTerm(nestedQuasiAffineTerm);
				if (result == null) result = caseAlgebraVisitable(nestedQuasiAffineTerm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQuasiAffineExpression(QuasiAffineExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQuasiAffineTerm(QuasiAffineTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Quasi Affine Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Quasi Affine Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleQuasiAffineTerm(SimpleQuasiAffineTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nested Quasi Affine Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nested Quasi Affine Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNestedQuasiAffineTerm(NestedQuasiAffineTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlgebraVisitable(AlgebraVisitable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntExpression(IntExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int Term</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Term</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntTerm(IntTerm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //QuasiAffineSwitch
