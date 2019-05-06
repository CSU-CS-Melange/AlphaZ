/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Signature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.FunctionSignature#getName <em>Name</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.FunctionSignature#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.FunctionSignature#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getFunctionSignature()
 * @model
 * @generated
 */
public interface FunctionSignature extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getFunctionSignature_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.FunctionSignature#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Return Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Type</em>' attribute.
	 * @see #setReturnType(String)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getFunctionSignature_ReturnType()
	 * @model
	 * @generated
	 */
	String getReturnType();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.FunctionSignature#getReturnType <em>Return Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Type</em>' attribute.
	 * @see #getReturnType()
	 * @generated
	 */
	void setReturnType(String value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.AbstractVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getFunctionSignature_Parameters()
	 * @model
	 * @generated
	 */
	EList<AbstractVariable> getParameters();

} // FunctionSignature
