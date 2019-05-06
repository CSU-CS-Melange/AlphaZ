/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.*;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SIMDExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VAssignExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VBinaryExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VLoadExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VPermuteExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VRegisterExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VSetExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShiftExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShuffleExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VStoreExpression;

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
 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage
 * @generated
 */
public class SimdExpSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SimdExpPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimdExpSwitch() {
		if (modelPackage == null) {
			modelPackage = SimdExpPackage.eINSTANCE;
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
			case SimdExpPackage.SIMD_EXPRESSION: {
				SIMDExpression simdExpression = (SIMDExpression)theEObject;
				T result = caseSIMDExpression(simdExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SimdExpPackage.BASIC_MEMORY_ADDRESS: {
				BasicMemoryAddress basicMemoryAddress = (BasicMemoryAddress)theEObject;
				T result = caseBasicMemoryAddress(basicMemoryAddress);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SimdExpPackage.VLOAD_EXPRESSION: {
				VLoadExpression vLoadExpression = (VLoadExpression)theEObject;
				T result = caseVLoadExpression(vLoadExpression);
				if (result == null) result = caseSIMDExpression(vLoadExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SimdExpPackage.VSTORE_EXPRESSION: {
				VStoreExpression vStoreExpression = (VStoreExpression)theEObject;
				T result = caseVStoreExpression(vStoreExpression);
				if (result == null) result = caseSIMDExpression(vStoreExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SimdExpPackage.VBINARY_EXPRESSION: {
				VBinaryExpression vBinaryExpression = (VBinaryExpression)theEObject;
				T result = caseVBinaryExpression(vBinaryExpression);
				if (result == null) result = caseSIMDExpression(vBinaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SimdExpPackage.VSHIFT_EXPRESSION: {
				VShiftExpression vShiftExpression = (VShiftExpression)theEObject;
				T result = caseVShiftExpression(vShiftExpression);
				if (result == null) result = caseSIMDExpression(vShiftExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SimdExpPackage.VREGISTER_EXPRESSION: {
				VRegisterExpression vRegisterExpression = (VRegisterExpression)theEObject;
				T result = caseVRegisterExpression(vRegisterExpression);
				if (result == null) result = caseSIMDExpression(vRegisterExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SimdExpPackage.VASSIGN_EXPRESSION: {
				VAssignExpression vAssignExpression = (VAssignExpression)theEObject;
				T result = caseVAssignExpression(vAssignExpression);
				if (result == null) result = caseSIMDExpression(vAssignExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SimdExpPackage.VSET_EXPRESSION: {
				VSetExpression vSetExpression = (VSetExpression)theEObject;
				T result = caseVSetExpression(vSetExpression);
				if (result == null) result = caseSIMDExpression(vSetExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SimdExpPackage.VPERMUTE_EXPRESSION: {
				VPermuteExpression vPermuteExpression = (VPermuteExpression)theEObject;
				T result = caseVPermuteExpression(vPermuteExpression);
				if (result == null) result = caseSIMDExpression(vPermuteExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SimdExpPackage.VSHUFFLE_EXPRESSION: {
				VShuffleExpression vShuffleExpression = (VShuffleExpression)theEObject;
				T result = caseVShuffleExpression(vShuffleExpression);
				if (result == null) result = caseSIMDExpression(vShuffleExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SIMD Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SIMD Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSIMDExpression(SIMDExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Basic Memory Address</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic Memory Address</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBasicMemoryAddress(BasicMemoryAddress object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VLoad Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VLoad Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVLoadExpression(VLoadExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VStore Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VStore Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVStoreExpression(VStoreExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VBinary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VBinary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVBinaryExpression(VBinaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VShift Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VShift Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVShiftExpression(VShiftExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VRegister Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VRegister Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVRegisterExpression(VRegisterExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VAssign Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VAssign Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVAssignExpression(VAssignExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VSet Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VSet Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVSetExpression(VSetExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VPermute Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VPermute Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVPermuteExpression(VPermuteExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VShuffle Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VShuffle Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVShuffleExpression(VShuffleExpression object) {
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

} //SimdExpSwitch
