/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.distributed;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage
 * @generated
 */
public interface CDistributedFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CDistributedFactory eINSTANCE = org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.CDistributedFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Partitioning Computation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Partitioning Computation</em>'.
	 * @generated
	 */
	PartitioningComputation createPartitioningComputation();

	/**
	 * Returns a new object of class '<em>Distributed Pseudo Projection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Distributed Pseudo Projection</em>'.
	 * @generated
	 */
	DistributedPseudoProjection createDistributedPseudoProjection();

	/**
	 * Returns a new object of class '<em>MPIC Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MPIC Loop</em>'.
	 * @generated
	 */
	MPICLoop createMPICLoop();

	/**
	 * Returns a new object of class '<em>Buffer Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Buffer Mapping</em>'.
	 * @generated
	 */
	BufferMapping createBufferMapping();

	/**
	 * Returns a new object of class '<em>Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Buffer</em>'.
	 * @generated
	 */
	Buffer createBuffer();

	/**
	 * Returns a new object of class '<em>Buffer Memory Domain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Buffer Memory Domain</em>'.
	 * @generated
	 */
	BufferMemoryDomain createBufferMemoryDomain();

	/**
	 * Returns a new object of class '<em>Buffer Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Buffer Access Expression</em>'.
	 * @generated
	 */
	BufferAccessExpression createBufferAccessExpression();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CDistributedPackage getCDistributedPackage();

} //CDistributedFactory
