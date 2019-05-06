/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Int Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.algebra.IntTerm#getCoef <em>Coef</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.algebra.AlgebraPackage#getIntTerm()
 * @model
 * @generated NOT
 */
public interface IntTerm extends AlgebraVisitable, Comparable<IntTerm> {
	/**
	 * Returns the value of the '<em><b>Coef</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coef</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coef</em>' attribute.
	 * @see #setCoef(long)
	 * @see org.polymodel.algebra.AlgebraPackage#getIntTerm_Coef()
	 * @model dataType="org.polymodel.algebra.Value"
	 * @generated
	 */
	long getCoef();

	/**
	 * Sets the value of the '{@link org.polymodel.algebra.IntTerm#getCoef <em>Coef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Coef</em>' attribute.
	 * @see #getCoef()
	 * @generated
	 */
	void setCoef(long value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitIntTerm(this);'"
	 * @generated
	 */
	void accept(AlgebraVisitor visitor);

	/**
	 * <!-- begin-user-doc -->
	 * Returns true if two terms are equivalent.
	 * <!-- end-user-doc -->
	 * @model required="true" otherRequired="true"
	 * @generated
	 */
	boolean isEquivalent(IntTerm other);
	

} // IntTerm
