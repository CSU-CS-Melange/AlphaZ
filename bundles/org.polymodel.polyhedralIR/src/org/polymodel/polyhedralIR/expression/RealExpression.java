/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.expression;

import org.polymodel.polyhedralIR.PolyhedralIRVisitable;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Real Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.expression.RealExpression#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.expression.ExpressionPackage#getRealExpression()
 * @model
 * @generated
 */
public interface RealExpression extends ConstantExpression, PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(double)
	 * @see org.polymodel.polyhedralIR.expression.ExpressionPackage#getRealExpression_Value()
	 * @model
	 * @generated
	 */
	double getValue();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.expression.RealExpression#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(double value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitRealExpression(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // RealExpression
