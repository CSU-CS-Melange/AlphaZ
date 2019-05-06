/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.quasiAffine;

import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.AlgebraVisitable;
import org.polymodel.algebra.AlgebraVisitor;
import org.polymodel.algebra.IntExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.algebra.quasiAffine.QuasiAffineExpression#getTerms <em>Terms</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.algebra.quasiAffine.QuasiAffinePackage#getQuasiAffineExpression()
 * @model
 * @generated
 */
public interface QuasiAffineExpression extends IntExpression, AlgebraVisitable {
	/**
	 * Returns the value of the '<em><b>Terms</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.algebra.quasiAffine.QuasiAffineTerm}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Terms</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Terms</em>' containment reference list.
	 * @see org.polymodel.algebra.quasiAffine.QuasiAffinePackage#getQuasiAffineExpression_Terms()
	 * @model containment="true"
	 * @generated
	 */
	EList<QuasiAffineTerm> getTerms();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitQuasiAffineExpression(this);'"
	 * @generated
	 */
	void accept(AlgebraVisitor visitor);

} // QuasiAffineExpression
