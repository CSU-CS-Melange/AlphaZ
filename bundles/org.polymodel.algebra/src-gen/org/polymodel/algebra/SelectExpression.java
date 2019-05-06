/**
 */
package org.polymodel.algebra;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Select Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.algebra.SelectExpression#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.polymodel.algebra.SelectExpression#getThen <em>Then</em>}</li>
 *   <li>{@link org.polymodel.algebra.SelectExpression#getElse <em>Else</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.algebra.AlgebraPackage#getSelectExpression()
 * @model
 * @generated
 */
public interface SelectExpression extends IntExpression {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.algebra.IntConstraintSystem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' reference list.
	 * @see org.polymodel.algebra.AlgebraPackage#getSelectExpression_Condition()
	 * @model
	 * @generated
	 */
	EList<IntConstraintSystem> getCondition();

	/**
	 * Returns the value of the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then</em>' containment reference.
	 * @see #setThen(IntExpression)
	 * @see org.polymodel.algebra.AlgebraPackage#getSelectExpression_Then()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IntExpression getThen();

	/**
	 * Sets the value of the '{@link org.polymodel.algebra.SelectExpression#getThen <em>Then</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then</em>' containment reference.
	 * @see #getThen()
	 * @generated
	 */
	void setThen(IntExpression value);

	/**
	 * Returns the value of the '<em><b>Else</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else</em>' containment reference.
	 * @see #setElse(IntExpression)
	 * @see org.polymodel.algebra.AlgebraPackage#getSelectExpression_Else()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IntExpression getElse();

	/**
	 * Sets the value of the '{@link org.polymodel.algebra.SelectExpression#getElse <em>Else</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else</em>' containment reference.
	 * @see #getElse()
	 * @generated
	 */
	void setElse(IntExpression value);

} // SelectExpression
