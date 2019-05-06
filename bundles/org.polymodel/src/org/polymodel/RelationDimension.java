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
 * A '<em><b>Relation Dimension</b></em>' is used in a {@link Relation} and refer an original
 * dimension contained by a {@link DimensionsManager}.
 * 
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.RelationDimension#getDimension <em>Dimension</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.PolymodelPackage#getRelationDimension()
 * @model abstract="true"
 * @generated
 */
public interface RelationDimension extends Variable, PolymodelVisitable {
	/**
	 * Returns the value of the '<em><b>Dimension</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimension</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimension</em>' reference.
	 * @see #setDimension(Variable)
	 * @see org.polymodel.PolymodelPackage#getRelationDimension_Dimension()
	 * @model
	 * @generated
	 */
	Variable getDimension();

	/**
	 * Sets the value of the '{@link org.polymodel.RelationDimension#getDimension <em>Dimension</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dimension</em>' reference.
	 * @see #getDimension()
	 * @generated
	 */
	void setDimension(Variable value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void accept(PolymodelVisitor visitor);

} // RelationDimension
