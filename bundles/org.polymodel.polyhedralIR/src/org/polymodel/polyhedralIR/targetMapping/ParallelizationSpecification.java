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
 * A representation of the model object '<em><b>Parallelization Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.ParallelizationSpecification#getParallelDims <em>Parallel Dims</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getParallelizationSpecification()
 * @model
 * @generated
 */
public interface ParallelizationSpecification extends FeatureSpecification, PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>Parallel Dims</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parallel Dims</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parallel Dims</em>' attribute list.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getParallelizationSpecification_ParallelDims()
	 * @model
	 * @generated
	 */
	EList<Integer> getParallelDims();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitParallelizationSpecification(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // ParallelizationSpecification
