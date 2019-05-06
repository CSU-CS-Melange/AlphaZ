/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.targetMapping;

import org.polymodel.polyhedralIR.PolyhedralIRVisitable;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vectorization Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getVectorizationSpecification()
 * @model
 * @generated
 */
public interface VectorizationSpecification extends FeatureSpecification, PolyhedralIRVisitable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitVectorizationSpecification(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // VectorizationSpecification
