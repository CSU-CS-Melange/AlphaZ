/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.distributed.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.Loop;
import org.polymodel.polyhedralIR.polyIRCG.MemoryAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.MemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.MergedDomainAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.MergedMemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.PseudoProjection;
import org.polymodel.polyhedralIR.polyIRCG.C.CLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.*;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.Buffer;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.DistributedPseudoProjection;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.MPICLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.PartitioningComputation;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage
 * @generated
 */
public class CDistributedAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CDistributedPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CDistributedAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CDistributedPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CDistributedSwitch<Adapter> modelSwitch =
		new CDistributedSwitch<Adapter>() {
			@Override
			public Adapter casePartitioningComputation(PartitioningComputation object) {
				return createPartitioningComputationAdapter();
			}
			@Override
			public Adapter caseDistributedPseudoProjection(DistributedPseudoProjection object) {
				return createDistributedPseudoProjectionAdapter();
			}
			@Override
			public Adapter caseMPICLoop(MPICLoop object) {
				return createMPICLoopAdapter();
			}
			@Override
			public Adapter caseBufferMapping(BufferMapping object) {
				return createBufferMappingAdapter();
			}
			@Override
			public Adapter caseBuffer(Buffer object) {
				return createBufferAdapter();
			}
			@Override
			public Adapter caseBufferMemoryDomain(BufferMemoryDomain object) {
				return createBufferMemoryDomainAdapter();
			}
			@Override
			public Adapter caseBufferAccessExpression(BufferAccessExpression object) {
				return createBufferAccessExpressionAdapter();
			}
			@Override
			public Adapter caseBody(Body object) {
				return createBodyAdapter();
			}
			@Override
			public Adapter caseMemoryDomain(MemoryDomain object) {
				return createMemoryDomainAdapter();
			}
			@Override
			public Adapter casePseudoProjection(PseudoProjection object) {
				return createPseudoProjectionAdapter();
			}
			@Override
			public Adapter caseLoop(Loop object) {
				return createLoopAdapter();
			}
			@Override
			public Adapter caseCLoop(CLoop object) {
				return createCLoopAdapter();
			}
			@Override
			public Adapter caseTiledCLoop(TiledCLoop object) {
				return createTiledCLoopAdapter();
			}
			@Override
			public Adapter caseMergedMemoryDomain(MergedMemoryDomain object) {
				return createMergedMemoryDomainAdapter();
			}
			@Override
			public Adapter caseMemoryAccessExpression(MemoryAccessExpression object) {
				return createMemoryAccessExpressionAdapter();
			}
			@Override
			public Adapter caseMergedDomainAccessExpression(MergedDomainAccessExpression object) {
				return createMergedDomainAccessExpressionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.PartitioningComputation <em>Partitioning Computation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.PartitioningComputation
	 * @generated
	 */
	public Adapter createPartitioningComputationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.DistributedPseudoProjection <em>Distributed Pseudo Projection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.DistributedPseudoProjection
	 * @generated
	 */
	public Adapter createDistributedPseudoProjectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.MPICLoop <em>MPIC Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.MPICLoop
	 * @generated
	 */
	public Adapter createMPICLoopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping <em>Buffer Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping
	 * @generated
	 */
	public Adapter createBufferMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.Buffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.Buffer
	 * @generated
	 */
	public Adapter createBufferAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMemoryDomain <em>Buffer Memory Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMemoryDomain
	 * @generated
	 */
	public Adapter createBufferMemoryDomainAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferAccessExpression <em>Buffer Access Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferAccessExpression
	 * @generated
	 */
	public Adapter createBufferAccessExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.polyIRCG.Body <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Body
	 * @generated
	 */
	public Adapter createBodyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.polyIRCG.MemoryDomain <em>Memory Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.polyIRCG.MemoryDomain
	 * @generated
	 */
	public Adapter createMemoryDomainAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.polyIRCG.PseudoProjection <em>Pseudo Projection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PseudoProjection
	 * @generated
	 */
	public Adapter createPseudoProjectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.polyIRCG.Loop <em>Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Loop
	 * @generated
	 */
	public Adapter createLoopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.polyIRCG.C.CLoop <em>Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CLoop
	 * @generated
	 */
	public Adapter createCLoopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop <em>Tiled CLoop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop
	 * @generated
	 */
	public Adapter createTiledCLoopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.polyIRCG.MergedMemoryDomain <em>Merged Memory Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.polyIRCG.MergedMemoryDomain
	 * @generated
	 */
	public Adapter createMergedMemoryDomainAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.polyIRCG.MemoryAccessExpression <em>Memory Access Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.polyIRCG.MemoryAccessExpression
	 * @generated
	 */
	public Adapter createMemoryAccessExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.polyIRCG.MergedDomainAccessExpression <em>Merged Domain Access Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.polyIRCG.MergedDomainAccessExpression
	 * @generated
	 */
	public Adapter createMergedDomainAccessExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //CDistributedAdapterFactory
