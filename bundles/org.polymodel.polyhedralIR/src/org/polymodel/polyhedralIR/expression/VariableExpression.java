/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.expression;

import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.PolyhedralIRVisitable;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.expression.VariableExpression#getVarDecl <em>Var Decl</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.expression.ExpressionPackage#getVariableExpression()
 * @model
 * @generated
 */
public interface VariableExpression extends Expression, PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>Var Decl</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Decl</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var Decl</em>' reference.
	 * @see #setVarDecl(VariableDeclaration)
	 * @see org.polymodel.polyhedralIR.expression.ExpressionPackage#getVariableExpression_VarDecl()
	 * @model required="true"
	 * @generated
	 */
	VariableDeclaration getVarDecl();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.expression.VariableExpression#getVarDecl <em>Var Decl</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var Decl</em>' reference.
	 * @see #getVarDecl()
	 * @generated
	 */
	void setVarDecl(VariableDeclaration value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitVariableExpression(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // VariableExpression
