/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.scan.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.*;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.OriginDomainVolume;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunction;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunctionDerivative;

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
 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage
 * @generated
 */
public class ScanSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ScanPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScanSwitch() {
		if (modelPackage == null) {
			modelPackage = ScanPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
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
			case ScanPackage.BOUND_COMPUTATION: {
				BoundComputation boundComputation = (BoundComputation)theEObject;
				T result = caseBoundComputation(boundComputation);
				if (result == null) result = caseBody(boundComputation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScanPackage.VOLUME_FUNCTION: {
				VolumeFunction volumeFunction = (VolumeFunction)theEObject;
				T result = caseVolumeFunction(volumeFunction);
				if (result == null) result = caseBody(volumeFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScanPackage.VOLUME_FUNCTION_DERIVATIVE: {
				VolumeFunctionDerivative volumeFunctionDerivative = (VolumeFunctionDerivative)theEObject;
				T result = caseVolumeFunctionDerivative(volumeFunctionDerivative);
				if (result == null) result = caseBody(volumeFunctionDerivative);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScanPackage.SCAN_BODY: {
				ScanBody scanBody = (ScanBody)theEObject;
				T result = caseScanBody(scanBody);
				if (result == null) result = caseBody(scanBody);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScanPackage.ORIGIN_DOMAIN_VOLUME: {
				OriginDomainVolume originDomainVolume = (OriginDomainVolume)theEObject;
				T result = caseOriginDomainVolume(originDomainVolume);
				if (result == null) result = caseBody(originDomainVolume);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ScanPackage.SCAN_REDUCTION_BODY: {
				ScanReductionBody scanReductionBody = (ScanReductionBody)theEObject;
				T result = caseScanReductionBody(scanReductionBody);
				if (result == null) result = caseBody(scanReductionBody);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bound Computation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bound Computation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoundComputation(BoundComputation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Volume Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Volume Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVolumeFunction(VolumeFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Volume Function Derivative</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Volume Function Derivative</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVolumeFunctionDerivative(VolumeFunctionDerivative object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Body</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Body</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScanBody(ScanBody object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Origin Domain Volume</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Origin Domain Volume</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOriginDomainVolume(OriginDomainVolume object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reduction Body</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reduction Body</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScanReductionBody(ScanReductionBody object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Body</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Body</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBody(Body object) {
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

} //ScanSwitch
