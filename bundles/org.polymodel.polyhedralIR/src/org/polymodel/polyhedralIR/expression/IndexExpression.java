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
 * A representation of the model object '<em><b>Index Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.expression.IndexExpression#getFunction <em>Function</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.expression.ExpressionPackage#getIndexExpression()
 * @model
 * @generated
 */
public interface IndexExpression extends Expression, PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' containment reference.
	 * @see #setFunction(AffineFunction)
	 * @see org.polymodel.polyhedralIR.expression.ExpressionPackage#getIndexExpression_Function()
	 * @model containment="true"
	 * @generated
	 */
	AffineFunction getFunction();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.expression.IndexExpression#getFunction <em>Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' containment reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(AffineFunction value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitIndexExpression(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // IndexExpression
