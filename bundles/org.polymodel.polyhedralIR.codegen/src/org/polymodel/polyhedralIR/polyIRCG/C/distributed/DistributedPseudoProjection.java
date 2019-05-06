/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.distributed;

import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.IntExpression;
import org.polymodel.polyhedralIR.polyIRCG.PseudoProjection;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Distributed Pseudo Projection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.DistributedPseudoProjection#getDistributedDims <em>Distributed Dims</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.DistributedPseudoProjection#getDistributedDimSizes <em>Distributed Dim Sizes</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage#getDistributedPseudoProjection()
 * @model
 * @generated
 */
public interface DistributedPseudoProjection extends PseudoProjection {
	/**
	 * Returns the value of the '<em><b>Distributed Dims</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distributed Dims</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distributed Dims</em>' attribute list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage#getDistributedPseudoProjection_DistributedDims()
	 * @model
	 * @generated
	 */
	EList<Integer> getDistributedDims();

	/**
	 * Returns the value of the '<em><b>Distributed Dim Sizes</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.algebra.IntExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distributed Dim Sizes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distributed Dim Sizes</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage#getDistributedPseudoProjection_DistributedDimSizes()
	 * @model containment="true"
	 * @generated
	 */
	EList<IntExpression> getDistributedDimSizes();

} // DistributedPseudoProjection
