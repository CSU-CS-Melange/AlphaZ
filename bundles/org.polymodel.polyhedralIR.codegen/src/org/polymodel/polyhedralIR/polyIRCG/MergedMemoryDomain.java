/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG;

import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Merged Memory Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.MergedMemoryDomain#getMemoryDomains <em>Memory Domains</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getMergedMemoryDomain()
 * @model
 * @generated
 */
public interface MergedMemoryDomain extends MemoryDomain {
	/**
	 * Returns the value of the '<em><b>Memory Domains</b></em>' map.
	 * The key is of type {@link K},
	 * and the value is of type {@link V},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Memory Domains</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Memory Domains</em>' map.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getMergedMemoryDomain_MemoryDomains()
	 * @model mapType="org.polymodel.ValueContainedMap&lt;K, V&gt;"
	 * @generated
	 */
	EMap<String, MemoryDomain> getMemoryDomains();

} // MergedMemoryDomain
