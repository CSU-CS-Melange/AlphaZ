/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.targetMapping.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polymodel.polyhedralIR.targetMapping.CommunicatedVariableForTiledSpace;
import org.polymodel.polyhedralIR.targetMapping.CommunicationMappingForTiledSpace;
import org.polymodel.polyhedralIR.targetMapping.LoopUnrollingSpecification;
import org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE;
import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.ParallelizationSpecification;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap;
import org.polymodel.polyhedralIR.targetMapping.StatementPartialOrder;
import org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.targetMapping.TargetMappingFactory;
import org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage;
import org.polymodel.polyhedralIR.targetMapping.TilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization;
import org.polymodel.polyhedralIR.targetMapping.VectorizationSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TargetMappingFactoryImpl extends EFactoryImpl implements TargetMappingFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TargetMappingFactory init() {
		try {
			TargetMappingFactory theTargetMappingFactory = (TargetMappingFactory)EPackage.Registry.INSTANCE.getEFactory(TargetMappingPackage.eNS_URI);
			if (theTargetMappingFactory != null) {
				return theTargetMappingFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TargetMappingFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetMappingFactoryImpl() {
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
			case TargetMappingPackage.TARGET_MAPPING: return createTargetMapping();
			case TargetMappingPackage.SPACE_TIME_LEVEL: return createSpaceTimeLevel();
			case TargetMappingPackage.SPACE_TIME_MAP: return createSpaceTimeMap();
			case TargetMappingPackage.TILING_SPECIFICATION: return createTilingSpecification();
			case TargetMappingPackage.LOOP_UNROLLING_SPECIFICATION: return createLoopUnrollingSpecification();
			case TargetMappingPackage.VECTORIZATION_SPECIFICATION: return createVectorizationSpecification();
			case TargetMappingPackage.PARALLELIZATION_SPECIFICATION: return createParallelizationSpecification();
			case TargetMappingPackage.MEMORY_MAP: return createMemoryMap();
			case TargetMappingPackage.MEMORY_SPACE: return createMemorySpace();
			case TargetMappingPackage.STATEMENT_PARTIAL_ORDER: return createStatementPartialOrder();
			case TargetMappingPackage.USE_EQUATION_OPTIMIZATION: return createUseEquationOptimization();
			case TargetMappingPackage.COMMUNICATION_MAPPING_FOR_TILED_SPACE: return createCommunicationMappingForTiledSpace();
			case TargetMappingPackage.COMMUNICATED_VARIABLE_FOR_TILED_SPACE: return createCommunicatedVariableForTiledSpace();
			case TargetMappingPackage.SUB_TILING_SPECIFICATION: return createSubTilingSpecification();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case TargetMappingPackage.TILING_TYPE:
				return createTILING_TYPEFromString(eDataType, initialValue);
			case TargetMappingPackage.TILE_SIZE_TYPE:
				return createTILE_SIZE_TYPEFromString(eDataType, initialValue);
			case TargetMappingPackage.MEMORY_TYPE:
				return createMEMORY_TYPEFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case TargetMappingPackage.TILING_TYPE:
				return convertTILING_TYPEToString(eDataType, instanceValue);
			case TargetMappingPackage.TILE_SIZE_TYPE:
				return convertTILE_SIZE_TYPEToString(eDataType, instanceValue);
			case TargetMappingPackage.MEMORY_TYPE:
				return convertMEMORY_TYPEToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetMapping createTargetMapping() {
		TargetMappingImpl targetMapping = new TargetMappingImpl();
		return targetMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpaceTimeLevel createSpaceTimeLevel() {
		SpaceTimeLevelImpl spaceTimeLevel = new SpaceTimeLevelImpl();
		return spaceTimeLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpaceTimeMap createSpaceTimeMap() {
		SpaceTimeMapImpl spaceTimeMap = new SpaceTimeMapImpl();
		return spaceTimeMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TilingSpecification createTilingSpecification() {
		TilingSpecificationImpl tilingSpecification = new TilingSpecificationImpl();
		return tilingSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopUnrollingSpecification createLoopUnrollingSpecification() {
		LoopUnrollingSpecificationImpl loopUnrollingSpecification = new LoopUnrollingSpecificationImpl();
		return loopUnrollingSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VectorizationSpecification createVectorizationSpecification() {
		VectorizationSpecificationImpl vectorizationSpecification = new VectorizationSpecificationImpl();
		return vectorizationSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParallelizationSpecification createParallelizationSpecification() {
		ParallelizationSpecificationImpl parallelizationSpecification = new ParallelizationSpecificationImpl();
		return parallelizationSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryMap createMemoryMap() {
		MemoryMapImpl memoryMap = new MemoryMapImpl();
		return memoryMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemorySpace createMemorySpace() {
		MemorySpaceImpl memorySpace = new MemorySpaceImpl();
		return memorySpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatementPartialOrder createStatementPartialOrder() {
		StatementPartialOrderImpl statementPartialOrder = new StatementPartialOrderImpl();
		return statementPartialOrder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseEquationOptimization createUseEquationOptimization() {
		UseEquationOptimizationImpl useEquationOptimization = new UseEquationOptimizationImpl();
		return useEquationOptimization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommunicationMappingForTiledSpace createCommunicationMappingForTiledSpace() {
		CommunicationMappingForTiledSpaceImpl communicationMappingForTiledSpace = new CommunicationMappingForTiledSpaceImpl();
		return communicationMappingForTiledSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommunicatedVariableForTiledSpace createCommunicatedVariableForTiledSpace() {
		CommunicatedVariableForTiledSpaceImpl communicatedVariableForTiledSpace = new CommunicatedVariableForTiledSpaceImpl();
		return communicatedVariableForTiledSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubTilingSpecification createSubTilingSpecification() {
		SubTilingSpecificationImpl subTilingSpecification = new SubTilingSpecificationImpl();
		return subTilingSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TILING_TYPE createTILING_TYPEFromString(EDataType eDataType, String initialValue) {
		TILING_TYPE result = TILING_TYPE.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTILING_TYPEToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TILE_SIZE_TYPE createTILE_SIZE_TYPEFromString(EDataType eDataType, String initialValue) {
		TILE_SIZE_TYPE result = TILE_SIZE_TYPE.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTILE_SIZE_TYPEToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MEMORY_TYPE createMEMORY_TYPEFromString(EDataType eDataType, String initialValue) {
		MEMORY_TYPE result = MEMORY_TYPE.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMEMORY_TYPEToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetMappingPackage getTargetMappingPackage() {
		return (TargetMappingPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TargetMappingPackage getPackage() {
		return TargetMappingPackage.eINSTANCE;
	}

} //TargetMappingFactoryImpl
