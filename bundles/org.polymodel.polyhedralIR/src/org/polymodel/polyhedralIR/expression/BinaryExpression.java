/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.expression;

import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.PolyhedralIRVisitable;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.expression.BinaryExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.expression.BinaryExpression#getLexp <em>Lexp</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.expression.BinaryExpression#getRexp <em>Rexp</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.expression.ExpressionPackage#getBinaryExpression()
 * @model
 * @generated
 */
public interface BinaryExpression extends Expression, PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polymodel.polyhedralIR.OP}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see org.polymodel.polyhedralIR.OP
	 * @see #setOperator(OP)
	 * @see org.polymodel.polyhedralIR.expression.ExpressionPackage#getBinaryExpression_Operator()
	 * @model
	 * @generated
	 */
	OP getOperator();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.expression.BinaryExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see org.polymodel.polyhedralIR.OP
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(OP value);

	/**
	 * Returns the value of the '<em><b>Lexp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lexp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lexp</em>' containment reference.
	 * @see #setLexp(Expression)
	 * @see org.polymodel.polyhedralIR.expression.ExpressionPackage#getBinaryExpression_Lexp()
	 * @model containment="true"
	 * @generated
	 */
	Expression getLexp();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.expression.BinaryExpression#getLexp <em>Lexp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lexp</em>' containment reference.
	 * @see #getLexp()
	 * @generated
	 */
	void setLexp(Expression value);

	/**
	 * Returns the value of the '<em><b>Rexp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rexp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rexp</em>' containment reference.
	 * @see #setRexp(Expression)
	 * @see org.polymodel.polyhedralIR.expression.ExpressionPackage#getBinaryExpression_Rexp()
	 * @model containment="true"
	 * @generated
	 */
	Expression getRexp();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.expression.BinaryExpression#getRexp <em>Rexp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rexp</em>' containment reference.
	 * @see #getRexp()
	 * @generated
	 */
	void setRexp(Expression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitBinaryExpression(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // BinaryExpression
