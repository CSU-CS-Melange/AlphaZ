/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.dataflow.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.polymodel.dataflow.ADAInput;
import org.polymodel.dataflow.ADASolution;
import org.polymodel.dataflow.ADAStatement;
import org.polymodel.dataflow.Access;
import org.polymodel.dataflow.DataflowPackage;
import org.polymodel.dataflow.ReadAccess;
import org.polymodel.dataflow.ResolvedAccess;
import org.polymodel.dataflow.WriteAccess;

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
 * @see org.polymodel.dataflow.DataflowPackage
 * @generated
 */
public class DataflowSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DataflowPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataflowSwitch() {
		if (modelPackage == null) {
			modelPackage = DataflowPackage.eINSTANCE;
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
			case DataflowPackage.ADA_INPUT: {
				ADAInput adaInput = (ADAInput)theEObject;
				T result = caseADAInput(adaInput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataflowPackage.ADA_STATEMENT: {
				ADAStatement adaStatement = (ADAStatement)theEObject;
				T result = caseADAStatement(adaStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataflowPackage.ACCESS: {
				Access access = (Access)theEObject;
				T result = caseAccess(access);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataflowPackage.READ_ACCESS: {
				ReadAccess readAccess = (ReadAccess)theEObject;
				T result = caseReadAccess(readAccess);
				if (result == null) result = caseAccess(readAccess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataflowPackage.WRITE_ACCESS: {
				WriteAccess writeAccess = (WriteAccess)theEObject;
				T result = caseWriteAccess(writeAccess);
				if (result == null) result = caseAccess(writeAccess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataflowPackage.ADA_SOLUTION: {
				ADASolution adaSolution = (ADASolution)theEObject;
				T result = caseADASolution(adaSolution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DataflowPackage.RESOLVED_ACCESS: {
				ResolvedAccess resolvedAccess = (ResolvedAccess)theEObject;
				T result = caseResolvedAccess(resolvedAccess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ADA Input</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ADA Input</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseADAInput(ADAInput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ADA Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ADA Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseADAStatement(ADAStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Read Access</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Read Access</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReadAccess(ReadAccess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Write Access</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Write Access</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWriteAccess(WriteAccess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ADA Solution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ADA Solution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseADASolution(ADASolution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Access</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Access</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAccess(Access object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resolved Access</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resolved Access</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResolvedAccess(ResolvedAccess object) {
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

} //DataflowSwitch
