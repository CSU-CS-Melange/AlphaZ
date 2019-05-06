/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.expression;

import org.polymodel.polyhedralIR.ExternalFunctionDeclaration;
import org.polymodel.polyhedralIR.PolyhedralIRVisitable;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Function Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.expression.ExternalFunctionCall#getExFunc <em>Ex Func</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.expression.ExpressionPackage#getExternalFunctionCall()
 * @model
 * @generated
 */
public interface ExternalFunctionCall extends MultiArgExpression, PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>Ex Func</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ex Func</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ex Func</em>' reference.
	 * @see #setExFunc(ExternalFunctionDeclaration)
	 * @see org.polymodel.polyhedralIR.expression.ExpressionPackage#getExternalFunctionCall_ExFunc()
	 * @model
	 * @generated
	 */
	ExternalFunctionDeclaration getExFunc();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.expression.ExternalFunctionCall#getExFunc <em>Ex Func</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ex Func</em>' reference.
	 * @see #getExFunc()
	 * @generated
	 */
	void setExFunc(ExternalFunctionDeclaration value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitExternalFunctionCall(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // ExternalFunctionCall
