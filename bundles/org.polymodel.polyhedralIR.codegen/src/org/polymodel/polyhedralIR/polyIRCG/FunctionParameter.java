/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getFunctionParameter()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface FunctionParameter extends AbstractVariable {

	/**
	 * <!-- begin-user-doc -->
	 * Returns the String to be used as the actual function parameter when the function is called.
	 * This is separated from the name for cases such as passing a scalar by reference.
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	String asParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	String asParameterType();

} // FunctionParameter
