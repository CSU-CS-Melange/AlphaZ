/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equation</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getEquation()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Equation extends PolyhedralIRVisitable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitEquation(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // Equation
