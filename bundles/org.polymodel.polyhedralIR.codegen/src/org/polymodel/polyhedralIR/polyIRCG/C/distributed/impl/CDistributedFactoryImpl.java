/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.*;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.Buffer;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedFactory;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.DistributedPseudoProjection;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.MPICLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.PartitioningComputation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CDistributedFactoryImpl extends EFactoryImpl implements CDistributedFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CDistributedFactory init() {
		try {
			CDistributedFactory theCDistributedFactory = (CDistributedFactory)EPackage.Registry.INSTANCE.getEFactory(CDistributedPackage.eNS_URI);
			if (theCDistributedFactory != null) {
				return theCDistributedFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CDistributedFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CDistributedFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CDistributedPackage.PARTITIONING_COMPUTATION: return createPartitioningComputation();
			case CDistributedPackage.DISTRIBUTED_PSEUDO_PROJECTION: return createDistributedPseudoProjection();
			case CDistributedPackage.MPIC_LOOP: return createMPICLoop();
			case CDistributedPackage.BUFFER_MAPPING: return createBufferMapping();
			case CDistributedPackage.BUFFER: return createBuffer();
			case CDistributedPackage.BUFFER_MEMORY_DOMAIN: return createBufferMemoryDomain();
			case CDistributedPackage.BUFFER_ACCESS_EXPRESSION: return createBufferAccessExpression();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartitioningComputation createPartitioningComputation() {
		PartitioningComputationImpl partitioningComputation = new PartitioningComputationImpl();
		return partitioningComputation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DistributedPseudoProjection createDistributedPseudoProjection() {
		DistributedPseudoProjectionImpl distributedPseudoProjection = new DistributedPseudoProjectionImpl();
		return distributedPseudoProjection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MPICLoop createMPICLoop() {
		MPICLoopImpl mpicLoop = new MPICLoopImpl();
		return mpicLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BufferMapping createBufferMapping() {
		BufferMappingImpl bufferMapping = new BufferMappingImpl();
		return bufferMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Buffer createBuffer() {
		BufferImpl buffer = new BufferImpl();
		return buffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BufferMemoryDomain createBufferMemoryDomain() {
		BufferMemoryDomainImpl bufferMemoryDomain = new BufferMemoryDomainImpl();
		return bufferMemoryDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BufferAccessExpression createBufferAccessExpression() {
		BufferAccessExpressionImpl bufferAccessExpression = new BufferAccessExpressionImpl();
		return bufferAccessExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CDistributedPackage getCDistributedPackage() {
		return (CDistributedPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CDistributedPackage getPackage() {
		return CDistributedPackage.eINSTANCE;
	}

} //CDistributedFactoryImpl
