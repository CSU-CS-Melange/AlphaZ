/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visitable</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getPolyhedralIRVisitable()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface PolyhedralIRVisitable extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // PolyhedralIRVisitable
