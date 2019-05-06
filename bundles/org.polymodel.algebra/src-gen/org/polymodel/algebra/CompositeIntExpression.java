/**
 */
package org.polymodel.algebra;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Int Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.algebra.CompositeIntExpression#getLeft <em>Left</em>}</li>
 *   <li>{@link org.polymodel.algebra.CompositeIntExpression#getRight <em>Right</em>}</li>
 *   <li>{@link org.polymodel.algebra.CompositeIntExpression#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.algebra.AlgebraPackage#getCompositeIntExpression()
 * @model
 * @generated
 */
public interface CompositeIntExpression extends IntExpression {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(IntExpression)
	 * @see org.polymodel.algebra.AlgebraPackage#getCompositeIntExpression_Left()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IntExpression getLeft();

	/**
	 * Sets the value of the '{@link org.polymodel.algebra.CompositeIntExpression#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(IntExpression value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(IntExpression)
	 * @see org.polymodel.algebra.AlgebraPackage#getCompositeIntExpression_Right()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IntExpression getRight();

	/**
	 * Sets the value of the '{@link org.polymodel.algebra.CompositeIntExpression#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(IntExpression value);

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polymodel.algebra.CompositeOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see org.polymodel.algebra.CompositeOperator
	 * @see #setOperator(CompositeOperator)
	 * @see org.polymodel.algebra.AlgebraPackage#getCompositeIntExpression_Operator()
	 * @model required="true"
	 * @generated
	 */
	CompositeOperator getOperator();

	/**
	 * Sets the value of the '{@link org.polymodel.algebra.CompositeIntExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see org.polymodel.algebra.CompositeOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(CompositeOperator value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitCompositeIntExpression(this);'"
	 * @generated
	 */
	void accept(AlgebraVisitor visitor);

} // CompositeIntExpression
