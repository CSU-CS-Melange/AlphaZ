/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel;

import org.eclipse.emf.ecore.EObject;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visitable</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.polymodel.PolymodelPackage#getPolymodelVisitable()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface PolymodelVisitable extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void accept(PolymodelVisitor visitor);
	
	public String toString(OUTPUT_FORMAT format);

} // PolymodelVisitable
