/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.expression;


import org.eclipse.emf.common.util.EList;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.PolyhedralIRVisitable;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Arg Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.expression.MultiArgExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.expression.MultiArgExpression#getExprs <em>Exprs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.expression.ExpressionPackage#getMultiArgExpression()
 * @model
 * @generated
 */
public interface MultiArgExpression extends Expression, PolyhedralIRVisitable {
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
	 * @see org.polymodel.polyhedralIR.expression.ExpressionPackage#getMultiArgExpression_Operator()
	 * @model
	 * @generated
	 */
	OP getOperator();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.expression.MultiArgExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see org.polymodel.polyhedralIR.OP
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(OP value);

	/**
	 * Returns the value of the '<em><b>Exprs</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exprs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exprs</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.expression.ExpressionPackage#getMultiArgExpression_Exprs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getExprs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitMultiArgExpression(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // MultiArgExpression
