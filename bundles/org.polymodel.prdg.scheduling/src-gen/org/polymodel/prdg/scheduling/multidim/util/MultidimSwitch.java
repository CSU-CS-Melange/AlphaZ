/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.multidim.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.polymodel.prdg.scheduling.Dependency;
import org.polymodel.prdg.scheduling.SchedulePrototype;
import org.polymodel.prdg.scheduling.StatementSchedulePrototype;
import org.polymodel.prdg.scheduling.multidim.ChannelScalarSchedulePrototype;
import org.polymodel.prdg.scheduling.multidim.MultidimDependency;
import org.polymodel.prdg.scheduling.multidim.MultidimPackage;
import org.polymodel.prdg.scheduling.multidim.MultidimSchedulePrototype;
import org.polymodel.prdg.scheduling.multidim.NullifiableDependency;
import org.polymodel.prdg.scheduling.multidim.ScalarSchedulePrototype;
import org.polymodel.prdg.scheduling.multidim.StatementScalarSchedulePrototype;
import org.polymodel.prdg.scheduling.structured.ChannelSchedulePrototype;

import fr.irisa.cairn.graph.observer.IObservable;

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
 * @see org.polymodel.prdg.scheduling.multidim.MultidimPackage
 * @generated
 */
public class MultidimSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MultidimPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultidimSwitch() {
		if (modelPackage == null) {
			modelPackage = MultidimPackage.eINSTANCE;
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
			case MultidimPackage.NULLIFIABLE_DEPENDENCY: {
				NullifiableDependency nullifiableDependency = (NullifiableDependency)theEObject;
				T result = caseNullifiableDependency(nullifiableDependency);
				if (result == null) result = caseDependency(nullifiableDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MultidimPackage.MULTIDIM_DEPENDENCY: {
				MultidimDependency multidimDependency = (MultidimDependency)theEObject;
				T result = caseMultidimDependency(multidimDependency);
				if (result == null) result = caseIObservable(multidimDependency);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MultidimPackage.MULTIDIM_SCHEDULE_PROTOTYPE: {
				MultidimSchedulePrototype multidimSchedulePrototype = (MultidimSchedulePrototype)theEObject;
				T result = caseMultidimSchedulePrototype(multidimSchedulePrototype);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MultidimPackage.SCALAR_SCHEDULE_PROTOTYPE: {
				ScalarSchedulePrototype scalarSchedulePrototype = (ScalarSchedulePrototype)theEObject;
				T result = caseScalarSchedulePrototype(scalarSchedulePrototype);
				if (result == null) result = caseSchedulePrototype(scalarSchedulePrototype);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MultidimPackage.STATEMENT_SCALAR_SCHEDULE_PROTOTYPE: {
				StatementScalarSchedulePrototype statementScalarSchedulePrototype = (StatementScalarSchedulePrototype)theEObject;
				T result = caseStatementScalarSchedulePrototype(statementScalarSchedulePrototype);
				if (result == null) result = caseStatementSchedulePrototype(statementScalarSchedulePrototype);
				if (result == null) result = caseScalarSchedulePrototype(statementScalarSchedulePrototype);
				if (result == null) result = caseSchedulePrototype(statementScalarSchedulePrototype);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MultidimPackage.CHANNEL_SCALAR_SCHEDULE_PROTOTYPE: {
				ChannelScalarSchedulePrototype channelScalarSchedulePrototype = (ChannelScalarSchedulePrototype)theEObject;
				T result = caseChannelScalarSchedulePrototype(channelScalarSchedulePrototype);
				if (result == null) result = caseChannelSchedulePrototype(channelScalarSchedulePrototype);
				if (result == null) result = caseScalarSchedulePrototype(channelScalarSchedulePrototype);
				if (result == null) result = caseSchedulePrototype(channelScalarSchedulePrototype);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MultidimPackage.IOBSERVABLE: {
				IObservable iObservable = (IObservable)theEObject;
				T result = caseIObservable(iObservable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nullifiable Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nullifiable Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNullifiableDependency(NullifiableDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultidimDependency(MultidimDependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Schedule Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Schedule Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultidimSchedulePrototype(MultidimSchedulePrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scalar Schedule Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scalar Schedule Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScalarSchedulePrototype(ScalarSchedulePrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement Scalar Schedule Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement Scalar Schedule Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatementScalarSchedulePrototype(StatementScalarSchedulePrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Channel Scalar Schedule Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Channel Scalar Schedule Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChannelScalarSchedulePrototype(ChannelScalarSchedulePrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IObservable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IObservable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIObservable(IObservable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependency</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependency(Dependency object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Schedule Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Schedule Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSchedulePrototype(SchedulePrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement Schedule Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement Schedule Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatementSchedulePrototype(StatementSchedulePrototype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Channel Schedule Prototype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Channel Schedule Prototype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChannelSchedulePrototype(ChannelSchedulePrototype object) {
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

} //MultidimSwitch
