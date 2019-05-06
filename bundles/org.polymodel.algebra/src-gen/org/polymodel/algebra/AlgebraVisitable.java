/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra;

import org.eclipse.emf.ecore.EObject;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visitable</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.polymodel.algebra.AlgebraPackage#getAlgebraVisitable()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface AlgebraVisitable extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void accept(AlgebraVisitor visitor);

	public String toString(OUTPUT_FORMAT format);

} // AlgebraVisitable
