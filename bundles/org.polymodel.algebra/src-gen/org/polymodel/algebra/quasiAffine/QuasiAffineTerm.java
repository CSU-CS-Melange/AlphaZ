/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.quasiAffine;

import org.polymodel.algebra.AlgebraVisitable;
import org.polymodel.algebra.AlgebraVisitor;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.IntTerm;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.algebra.quasiAffine.QuasiAffineTerm#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.algebra.quasiAffine.QuasiAffinePackage#getQuasiAffineTerm()
 * @model abstract="true"
 * @generated
 */
public interface QuasiAffineTerm extends IntTerm, AlgebraVisitable {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.polymodel.algebra.quasiAffine.QuasiAffineOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see org.polymodel.algebra.quasiAffine.QuasiAffineOperator
	 * @see #setOperator(QuasiAffineOperator)
	 * @see org.polymodel.algebra.quasiAffine.QuasiAffinePackage#getQuasiAffineTerm_Operator()
	 * @model required="true"
	 * @generated
	 */
	QuasiAffineOperator getOperator();

	IntExpression getExpression();
	/**
	 * Sets the value of the '{@link org.polymodel.algebra.quasiAffine.QuasiAffineTerm#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see org.polymodel.algebra.quasiAffine.QuasiAffineOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(QuasiAffineOperator value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitQuasiAffineTerm(this);'"
	 * @generated
	 */
	void accept(AlgebraVisitor visitor);

	QuasiAffineTerm copy();
} // QuasiAffineTerm
