/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.distributed;

import org.eclipse.emf.common.util.EList;
import org.polymodel.polyhedralIR.polyIRCG.C.CLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MPIC Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.MPICLoop#getBuffers <em>Buffers</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage#getMPICLoop()
 * @model
 * @generated
 */
public interface MPICLoop extends TiledCLoop {

	/**
	 * Returns the value of the '<em><b>Buffers</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.Buffer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Buffers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffers</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage#getMPICLoop_Buffers()
	 * @model containment="true"
	 * @generated
	 */
	EList<Buffer> getBuffers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	CLoop getSendBufferCopyLoop();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	CLoop getReceiveBufferCopyLoop();
} // MPICLoop
