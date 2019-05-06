/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.targetMapping.ParallelizationSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parallelized CLoop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.ParallelizedCLoop#getParallelizedDims <em>Parallelized Dims</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.ParallelizedCLoop#getOrderingDims <em>Ordering Dims</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.ParallelizedCLoop#getSubsystemVariables <em>Subsystem Variables</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getParallelizedCLoop()
 * @model
 * @generated
 */
public interface ParallelizedCLoop extends CLoop {
	/**
	 * Returns the value of the '<em><b>Parallelized Dims</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.targetMapping.ParallelizationSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parallelized Dims</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parallelized Dims</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getParallelizedCLoop_ParallelizedDims()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParallelizationSpecification> getParallelizedDims();

	/**
	 * Returns the value of the '<em><b>Ordering Dims</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordering Dims</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordering Dims</em>' attribute list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getParallelizedCLoop_OrderingDims()
	 * @model
	 * @generated
	 */
	EList<Integer> getOrderingDims();

	/**
	 * Returns the value of the '<em><b>Subsystem Variables</b></em>' map.
	 * The key is of type {@link K},
	 * and the value is of type {@link V},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subsystem Variables</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subsystem Variables</em>' map.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getParallelizedCLoop_SubsystemVariables()
	 * @model mapType="org.polymodel.ValueContainedMap<K, V>"
	 * @generated
	 */
	EMap<String, VariableDeclaration> getSubsystemVariables();

} // ParallelizedCLoop
