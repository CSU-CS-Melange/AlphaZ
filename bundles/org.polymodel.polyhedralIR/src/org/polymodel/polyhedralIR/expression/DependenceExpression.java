/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.expression;

import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.PolyhedralIRVisitable;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependence Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.expression.DependenceExpression#getDep <em>Dep</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.expression.DependenceExpression#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.expression.ExpressionPackage#getDependenceExpression()
 * @model
 * @generated
 */
public interface DependenceExpression extends Expression, PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>Dep</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dep</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dep</em>' containment reference.
	 * @see #setDep(AffineFunction)
	 * @see org.polymodel.polyhedralIR.expression.ExpressionPackage#getDependenceExpression_Dep()
	 * @model containment="true"
	 * @generated
	 */
	AffineFunction getDep();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.expression.DependenceExpression#getDep <em>Dep</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dep</em>' containment reference.
	 * @see #getDep()
	 * @generated
	 */
	void setDep(AffineFunction value);

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
	 * @see org.polymodel.polyhedralIR.expression.ExpressionPackage#getDependenceExpression_Expr()
	 * @model containment="true"
	 * @generated
	 */
	Expression getExpr();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.expression.DependenceExpression#getExpr <em>Expr</em>}' containment reference.
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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitDependenceExpression(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // DependenceExpression
