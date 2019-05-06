/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.targetMapping.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.polyhedralIR.PolyhedralIRVisitable;
import org.polymodel.polyhedralIR.targetMapping.CommunicatedVariableForTiledSpace;
import org.polymodel.polyhedralIR.targetMapping.CommunicationMappingForTiledSpace;
import org.polymodel.polyhedralIR.targetMapping.FeatureSpecification;
import org.polymodel.polyhedralIR.targetMapping.LoopUnrollingSpecification;
import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.ParallelizationSpecification;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap;
import org.polymodel.polyhedralIR.targetMapping.StatementPartialOrder;
import org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage;
import org.polymodel.polyhedralIR.targetMapping.TilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization;
import org.polymodel.polyhedralIR.targetMapping.VectorizationSpecification;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage
 * @generated
 */
public class TargetMappingAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TargetMappingPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetMappingAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TargetMappingPackage.eINSTANCE;
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
	protected TargetMappingSwitch<Adapter> modelSwitch =
		new TargetMappingSwitch<Adapter>() {
			@Override
			public Adapter caseTargetMapping(TargetMapping object) {
				return createTargetMappingAdapter();
			}
			@Override
			public Adapter caseSpaceTimeLevel(SpaceTimeLevel object) {
				return createSpaceTimeLevelAdapter();
			}
			@Override
			public Adapter caseSpaceTimeMap(SpaceTimeMap object) {
				return createSpaceTimeMapAdapter();
			}
			@Override
			public Adapter caseFeatureSpecification(FeatureSpecification object) {
				return createFeatureSpecificationAdapter();
			}
			@Override
			public Adapter caseTilingSpecification(TilingSpecification object) {
				return createTilingSpecificationAdapter();
			}
			@Override
			public Adapter caseLoopUnrollingSpecification(LoopUnrollingSpecification object) {
				return createLoopUnrollingSpecificationAdapter();
			}
			@Override
			public Adapter caseVectorizationSpecification(VectorizationSpecification object) {
				return createVectorizationSpecificationAdapter();
			}
			@Override
			public Adapter caseParallelizationSpecification(ParallelizationSpecification object) {
				return createParallelizationSpecificationAdapter();
			}
			@Override
			public Adapter caseMemoryMap(MemoryMap object) {
				return createMemoryMapAdapter();
			}
			@Override
			public Adapter caseMemorySpace(MemorySpace object) {
				return createMemorySpaceAdapter();
			}
			@Override
			public Adapter caseStatementPartialOrder(StatementPartialOrder object) {
				return createStatementPartialOrderAdapter();
			}
			@Override
			public Adapter caseUseEquationOptimization(UseEquationOptimization object) {
				return createUseEquationOptimizationAdapter();
			}
			@Override
			public Adapter caseCommunicationMappingForTiledSpace(CommunicationMappingForTiledSpace object) {
				return createCommunicationMappingForTiledSpaceAdapter();
			}
			@Override
			public Adapter caseCommunicatedVariableForTiledSpace(CommunicatedVariableForTiledSpace object) {
				return createCommunicatedVariableForTiledSpaceAdapter();
			}
			@Override
			public Adapter caseSubTilingSpecification(SubTilingSpecification object) {
				return createSubTilingSpecificationAdapter();
			}
			@Override
			public Adapter casePolyhedralIRVisitable(PolyhedralIRVisitable object) {
				return createPolyhedralIRVisitableAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.targetMapping.TargetMapping <em>Target Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMapping
	 * @generated
	 */
	public Adapter createTargetMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel <em>Space Time Level</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel
	 * @generated
	 */
	public Adapter createSpaceTimeLevelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap <em>Space Time Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap
	 * @generated
	 */
	public Adapter createSpaceTimeMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.targetMapping.FeatureSpecification <em>Feature Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.targetMapping.FeatureSpecification
	 * @generated
	 */
	public Adapter createFeatureSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.targetMapping.TilingSpecification <em>Tiling Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.targetMapping.TilingSpecification
	 * @generated
	 */
	public Adapter createTilingSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.targetMapping.LoopUnrollingSpecification <em>Loop Unrolling Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.targetMapping.LoopUnrollingSpecification
	 * @generated
	 */
	public Adapter createLoopUnrollingSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.targetMapping.VectorizationSpecification <em>Vectorization Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.targetMapping.VectorizationSpecification
	 * @generated
	 */
	public Adapter createVectorizationSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.targetMapping.ParallelizationSpecification <em>Parallelization Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.targetMapping.ParallelizationSpecification
	 * @generated
	 */
	public Adapter createParallelizationSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.targetMapping.MemoryMap <em>Memory Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.targetMapping.MemoryMap
	 * @generated
	 */
	public Adapter createMemoryMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.targetMapping.MemorySpace <em>Memory Space</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.targetMapping.MemorySpace
	 * @generated
	 */
	public Adapter createMemorySpaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.targetMapping.StatementPartialOrder <em>Statement Partial Order</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.targetMapping.StatementPartialOrder
	 * @generated
	 */
	public Adapter createStatementPartialOrderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization <em>Use Equation Optimization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization
	 * @generated
	 */
	public Adapter createUseEquationOptimizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.targetMapping.CommunicationMappingForTiledSpace <em>Communication Mapping For Tiled Space</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.targetMapping.CommunicationMappingForTiledSpace
	 * @generated
	 */
	public Adapter createCommunicationMappingForTiledSpaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.targetMapping.CommunicatedVariableForTiledSpace <em>Communicated Variable For Tiled Space</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.targetMapping.CommunicatedVariableForTiledSpace
	 * @generated
	 */
	public Adapter createCommunicatedVariableForTiledSpaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification <em>Sub Tiling Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification
	 * @generated
	 */
	public Adapter createSubTilingSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polymodel.polyhedralIR.PolyhedralIRVisitable <em>Visitable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polymodel.polyhedralIR.PolyhedralIRVisitable
	 * @generated
	 */
	public Adapter createPolyhedralIRVisitableAdapter() {
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

} //TargetMappingAdapterFactory
