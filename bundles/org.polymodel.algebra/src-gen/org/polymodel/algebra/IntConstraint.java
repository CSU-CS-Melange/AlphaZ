/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Int Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.algebra.IntConstraint#getLhs <em>Lhs</em>}</li>
 *   <li>{@link org.polymodel.algebra.IntConstraint#getRhs <em>Rhs</em>}</li>
 *   <li>{@link org.polymodel.algebra.IntConstraint#getComparisonOperator <em>Comparison Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.algebra.AlgebraPackage#getIntConstraint()
 * @model
 * @generated
 */
public interface IntConstraint extends AlgebraVisitable {
	/**
	 * Returns the value of the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lhs</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lhs</em>' containment reference.
	 * @see #setLhs(IntExpression)
	 * @see org.polymodel.algebra.AlgebraPackage#getIntConstraint_Lhs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IntExpression getLhs();

	/**
	 * Sets the value of the '{@link org.polymodel.algebra.IntConstraint#getLhs <em>Lhs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lhs</em>' containment reference.
	 * @see #getLhs()
	 * @generated
	 */
	void setLhs(IntExpression value);

	/**
	 * Returns the value of the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rhs</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rhs</em>' containment reference.
	 * @see #setRhs(IntExpression)
	 * @see org.polymodel.algebra.AlgebraPackage#getIntConstraint_Rhs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IntExpression getRhs();

	/**
	 * Sets the value of the '{@link org.polymodel.algebra.IntConstraint#getRhs <em>Rhs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rhs</em>' containment reference.
	 * @see #getRhs()
	 * @generated
	 */
	void setRhs(IntExpression value);

	/**
	 * Returns the value of the '<em><b>Comparison Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polymodel.algebra.ComparisonOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comparison Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comparison Operator</em>' attribute.
	 * @see org.polymodel.algebra.ComparisonOperator
	 * @see #setComparisonOperator(ComparisonOperator)
	 * @see org.polymodel.algebra.AlgebraPackage#getIntConstraint_ComparisonOperator()
	 * @model required="true"
	 * @generated
	 */
	ComparisonOperator getComparisonOperator();

	/**
	 * Sets the value of the '{@link org.polymodel.algebra.IntConstraint#getComparisonOperator <em>Comparison Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comparison Operator</em>' attribute.
	 * @see org.polymodel.algebra.ComparisonOperator
	 * @see #getComparisonOperator()
	 * @generated
	 */
	void setComparisonOperator(ComparisonOperator value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isAffine();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isQuasiAffine();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isPolynomial();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitIntConstraint(this);'"
	 * @generated
	 */
	void accept(AlgebraVisitor visitor);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" substitutedRequired="true" newVarRequired="true"
	 * @generated
	 */
	IntConstraint substitute(Variable substituted, Variable newVar);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" substitutedRequired="true" newExprRequired="true"
	 * @generated
	 */
	IntConstraint substitute(Variable substituted, IntExpression newExpr);

	IntConstraint copy();

	IntConstraint simplify();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" otherRequired="true"
	 * @generated
	 */
	FuzzyBoolean isEquivalent(IntConstraint other);

	/**
	 * Returns upper bound expression derived from this constraint for the specified variable.
	 * 
	 * @param var
	 * @return
	 */
	public IntExpression getUB(Variable var);
	
	/**
	 * Returns lower bound expression derived from this constraint for the specified variable.
	 * 
	 * @param var
	 * @return
	 */
	public IntExpression getLB(Variable var);

} // IntConstraint
