/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel;

import org.polymodel.algebra.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Index Dimension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.IndexDimension#getDimension <em>Dimension</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.PolymodelPackage#getIndexDimension()
 * @model
 * @generated
 */
public interface IndexDimension extends Variable, PolymodelVisitable {
	/**
	 * Returns the value of the '<em><b>Dimension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimension</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimension</em>' attribute.
	 * @see #setDimension(int)
	 * @see org.polymodel.PolymodelPackage#getIndexDimension_Dimension()
	 * @model
	 * @generated
	 */
	int getDimension();

	/**
	 * Sets the value of the '{@link org.polymodel.IndexDimension#getDimension <em>Dimension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dimension</em>' attribute.
	 * @see #getDimension()
	 * @generated
	 */
	void setDimension(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitIndexDimension(this);'"
	 * @generated
	 */
	void accept(PolymodelVisitor visitor);

} // IndexDimension
