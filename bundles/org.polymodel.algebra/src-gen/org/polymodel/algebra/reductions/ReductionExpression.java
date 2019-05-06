/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.reductions;

import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.AlgebraVisitable;
import org.polymodel.algebra.AlgebraVisitor;
import org.polymodel.algebra.IntExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reduction Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.algebra.reductions.ReductionExpression#getExpressions <em>Expressions</em>}</li>
 *   <li>{@link org.polymodel.algebra.reductions.ReductionExpression#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.algebra.reductions.ReductionsPackage#getReductionExpression()
 * @model
 * @generated
 */
public interface ReductionExpression extends IntExpression, AlgebraVisitable {
	/**
	 * Returns the value of the '<em><b>Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.algebra.IntExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expressions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expressions</em>' containment reference list.
	 * @see org.polymodel.algebra.reductions.ReductionsPackage#getReductionExpression_Expressions()
	 * @model containment="true"
	 * @generated
	 */
	EList<IntExpression> getExpressions();

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polymodel.algebra.reductions.ReductionOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see org.polymodel.algebra.reductions.ReductionOperator
	 * @see #setOperator(ReductionOperator)
	 * @see org.polymodel.algebra.reductions.ReductionsPackage#getReductionExpression_Operator()
	 * @model required="true"
	 * @generated
	 */
	ReductionOperator getOperator();

	/**
	 * Sets the value of the '{@link org.polymodel.algebra.reductions.ReductionExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see org.polymodel.algebra.reductions.ReductionOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(ReductionOperator value);


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitReductionExpression(this);'"
	 * @generated
	 */
	void accept(AlgebraVisitor visitor);

} // ReductionExpression
