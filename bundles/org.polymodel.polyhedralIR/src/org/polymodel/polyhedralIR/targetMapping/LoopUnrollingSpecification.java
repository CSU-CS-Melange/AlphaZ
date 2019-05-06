/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.targetMapping;

import org.eclipse.emf.common.util.EList;
import org.polymodel.polyhedralIR.PolyhedralIRVisitable;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Unrolling Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.LoopUnrollingSpecification#getUnrollingFactors <em>Unrolling Factors</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getLoopUnrollingSpecification()
 * @model
 * @generated
 */
public interface LoopUnrollingSpecification extends FeatureSpecification, PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>Unrolling Factors</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unrolling Factors</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unrolling Factors</em>' attribute list.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getLoopUnrollingSpecification_UnrollingFactors()
	 * @model unique="false"
	 * @generated
	 */
	EList<Integer> getUnrollingFactors();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitLoopUnrollingSpecification(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // LoopUnrollingSpecification
