/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.scan;

import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.FunctionParameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bound Computation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation#getLb <em>Lb</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation#getUb <em>Ub</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation#getConstantTerm <em>Constant Term</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation#getVolumeFunction <em>Volume Function</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation#getVolumeFunctionDerivative <em>Volume Function Derivative</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation#getInitialValue <em>Initial Value</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getBoundComputation()
 * @model
 * @generated
 */
public interface BoundComputation extends Body {
	/**
	 * Returns the value of the '<em><b>Lb</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lb</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lb</em>' reference.
	 * @see #setLb(AbstractVariable)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getBoundComputation_Lb()
	 * @model required="true"
	 * @generated
	 */
	AbstractVariable getLb();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation#getLb <em>Lb</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lb</em>' reference.
	 * @see #getLb()
	 * @generated
	 */
	void setLb(AbstractVariable value);

	/**
	 * Returns the value of the '<em><b>Ub</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ub</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ub</em>' reference.
	 * @see #setUb(AbstractVariable)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getBoundComputation_Ub()
	 * @model required="true"
	 * @generated
	 */
	AbstractVariable getUb();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation#getUb <em>Ub</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ub</em>' reference.
	 * @see #getUb()
	 * @generated
	 */
	void setUb(AbstractVariable value);

	/**
	 * Returns the value of the '<em><b>Constant Term</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constant Term</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant Term</em>' reference.
	 * @see #setConstantTerm(AbstractVariable)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getBoundComputation_ConstantTerm()
	 * @model required="true"
	 * @generated
	 */
	AbstractVariable getConstantTerm();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation#getConstantTerm <em>Constant Term</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constant Term</em>' reference.
	 * @see #getConstantTerm()
	 * @generated
	 */
	void setConstantTerm(AbstractVariable value);

	/**
	 * Returns the value of the '<em><b>Volume Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Volume Function</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Volume Function</em>' reference.
	 * @see #setVolumeFunction(VolumeFunction)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getBoundComputation_VolumeFunction()
	 * @model required="true"
	 * @generated
	 */
	VolumeFunction getVolumeFunction();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation#getVolumeFunction <em>Volume Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Volume Function</em>' reference.
	 * @see #getVolumeFunction()
	 * @generated
	 */
	void setVolumeFunction(VolumeFunction value);

	/**
	 * Returns the value of the '<em><b>Volume Function Derivative</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Volume Function Derivative</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Volume Function Derivative</em>' reference.
	 * @see #setVolumeFunctionDerivative(VolumeFunctionDerivative)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getBoundComputation_VolumeFunctionDerivative()
	 * @model required="true"
	 * @generated
	 */
	VolumeFunctionDerivative getVolumeFunctionDerivative();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation#getVolumeFunctionDerivative <em>Volume Function Derivative</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Volume Function Derivative</em>' reference.
	 * @see #getVolumeFunctionDerivative()
	 * @generated
	 */
	void setVolumeFunctionDerivative(VolumeFunctionDerivative value);

	/**
	 * Returns the value of the '<em><b>Initial Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Value</em>' reference.
	 * @see #setInitialValue(AbstractVariable)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getBoundComputation_InitialValue()
	 * @model required="true"
	 * @generated
	 */
	AbstractVariable getInitialValue();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation#getInitialValue <em>Initial Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Value</em>' reference.
	 * @see #getInitialValue()
	 * @generated
	 */
	void setInitialValue(AbstractVariable value);

} // BoundComputation
