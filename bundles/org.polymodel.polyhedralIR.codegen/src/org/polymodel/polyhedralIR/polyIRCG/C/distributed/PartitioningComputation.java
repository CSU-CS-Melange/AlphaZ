/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.distributed;

import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Partitioning Computation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.PartitioningComputation#getPartitionedTile <em>Partitioned Tile</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage#getPartitioningComputation()
 * @model
 * @generated
 */
public interface PartitioningComputation extends Body {
	/**
	 * Returns the value of the '<em><b>Partitioned Tile</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partitioned Tile</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partitioned Tile</em>' reference.
	 * @see #setPartitionedTile(TiledCLoop)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage#getPartitioningComputation_PartitionedTile()
	 * @model required="true"
	 * @generated
	 */
	TiledCLoop getPartitionedTile();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.PartitioningComputation#getPartitionedTile <em>Partitioned Tile</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partitioned Tile</em>' reference.
	 * @see #getPartitionedTile()
	 * @generated
	 */
	void setPartitionedTile(TiledCLoop value);

} // PartitioningComputation
