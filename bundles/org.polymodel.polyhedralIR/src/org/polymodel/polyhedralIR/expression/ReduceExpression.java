/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.expression;

import org.polymodel.algebra.IntExpression;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.PolyhedralIRVisitable;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reduce Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.expression.ReduceExpression#getOP <em>OP</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.expression.ReduceExpression#getProjection <em>Projection</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.expression.ReduceExpression#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.expression.ExpressionPackage#getReduceExpression()
 * @model
 * @generated
 */
public interface ReduceExpression extends Expression, PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>OP</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polymodel.polyhedralIR.OP}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>OP</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>OP</em>' attribute.
	 * @see org.polymodel.polyhedralIR.OP
	 * @see #setOP(OP)
	 * @see org.polymodel.polyhedralIR.expression.ExpressionPackage#getReduceExpression_OP()
	 * @model
	 * @generated
	 */
	OP getOP();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.expression.ReduceExpression#getOP <em>OP</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>OP</em>' attribute.
	 * @see org.polymodel.polyhedralIR.OP
	 * @see #getOP()
	 * @generated
	 */
	void setOP(OP value);

	/**
	 * Returns the value of the '<em><b>Projection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Projection</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projection</em>' containment reference.
	 * @see #setProjection(AffineFunction)
	 * @see org.polymodel.polyhedralIR.expression.ExpressionPackage#getReduceExpression_Projection()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AffineFunction getProjection();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.expression.ReduceExpression#getProjection <em>Projection</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Projection</em>' containment reference.
	 * @see #getProjection()
	 * @generated
	 */
	void setProjection(AffineFunction value);

	/**
	 * Returns the value of the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expr</em>' containment reference.
	 * @see #setExpr(Expression)
	 * @see org.polymodel.polyhedralIR.expression.ExpressionPackage#getReduceExpression_Expr()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getExpr();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.expression.ReduceExpression#getExpr <em>Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr</em>' containment reference.
	 * @see #getExpr()
	 * @generated
	 */
	void setExpr(Expression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	IntExpression getIdentityValue();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitReduceExpression(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // ReduceExpression
