/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.expression;

import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.PolyhedralIRVisitable;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Restrict Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.expression.RestrictExpression#getRestrictDomain <em>Restrict Domain</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.expression.RestrictExpression#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.expression.ExpressionPackage#getRestrictExpression()
 * @model
 * @generated
 */
public interface RestrictExpression extends Expression, PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>Restrict Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Restrict Domain</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Restrict Domain</em>' containment reference.
	 * @see #setRestrictDomain(Domain)
	 * @see org.polymodel.polyhedralIR.expression.ExpressionPackage#getRestrictExpression_RestrictDomain()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Domain getRestrictDomain();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.expression.RestrictExpression#getRestrictDomain <em>Restrict Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Restrict Domain</em>' containment reference.
	 * @see #getRestrictDomain()
	 * @generated
	 */
	void setRestrictDomain(Domain value);

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
	 * @see org.polymodel.polyhedralIR.expression.ExpressionPackage#getRestrictExpression_Expr()
	 * @model containment="true"
	 * @generated
	 */
	Expression getExpr();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.expression.RestrictExpression#getExpr <em>Expr</em>}' containment reference.
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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitRestrictExpression(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // RestrictExpression
