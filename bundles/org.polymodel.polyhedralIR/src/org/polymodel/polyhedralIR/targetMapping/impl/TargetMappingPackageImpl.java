/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.targetMapping.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.polymodel.PolymodelPackage;
import org.polymodel.algebra.AlgebraPackage;
import org.polymodel.polyhedralIR.PolyhedralIRPackage;
import org.polymodel.polyhedralIR.expression.ExpressionPackage;
import org.polymodel.polyhedralIR.expression.impl.ExpressionPackageImpl;
import org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl;
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
import org.polymodel.polyhedralIR.targetMapping.TargetMappingFactory;
import org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage;
import org.polymodel.polyhedralIR.targetMapping.TilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization;
import org.polymodel.polyhedralIR.targetMapping.VectorizationSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TargetMappingPackageImpl extends EPackageImpl implements TargetMappingPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass spaceTimeLevelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass spaceTimeMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tilingSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopUnrollingSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vectorizationSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parallelizationSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memoryMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memorySpaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statementPartialOrderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass useEquationOptimizationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass communicationMappingForTiledSpaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass communicatedVariableForTiledSpaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subTilingSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum tilinG_TYPEEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum tilE_SIZE_TYPEEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum memorY_TYPEEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TargetMappingPackageImpl() {
		super(eNS_URI, TargetMappingFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link TargetMappingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TargetMappingPackage init() {
		if (isInited) return (TargetMappingPackage)EPackage.Registry.INSTANCE.getEPackage(TargetMappingPackage.eNS_URI);

		// Obtain or create and register package
		TargetMappingPackageImpl theTargetMappingPackage = (TargetMappingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TargetMappingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TargetMappingPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PolymodelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		PolyhedralIRPackageImpl thePolyhedralIRPackage = (PolyhedralIRPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PolyhedralIRPackage.eNS_URI) instanceof PolyhedralIRPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PolyhedralIRPackage.eNS_URI) : PolyhedralIRPackage.eINSTANCE);
		ExpressionPackageImpl theExpressionPackage = (ExpressionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExpressionPackage.eNS_URI) instanceof ExpressionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExpressionPackage.eNS_URI) : ExpressionPackage.eINSTANCE);

		// Create package meta-data objects
		theTargetMappingPackage.createPackageContents();
		thePolyhedralIRPackage.createPackageContents();
		theExpressionPackage.createPackageContents();

		// Initialize created meta-data
		theTargetMappingPackage.initializePackageContents();
		thePolyhedralIRPackage.initializePackageContents();
		theExpressionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTargetMappingPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TargetMappingPackage.eNS_URI, theTargetMappingPackage);
		return theTargetMappingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetMapping() {
		return targetMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTargetMapping_ContainerSystem() {
		return (EReference)targetMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTargetMapping_SpaceTimeLevels() {
		return (EReference)targetMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTargetMapping_MemoryMaps() {
		return (EReference)targetMappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTargetMapping_MemorySpaces() {
		return (EReference)targetMappingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTargetMapping_StatementOrderings() {
		return (EReference)targetMappingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTargetMapping_UseEquationOptimizations() {
		return (EReference)targetMappingEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpaceTimeLevel() {
		return spaceTimeLevelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpaceTimeLevel_SpaceTimeMaps() {
		return (EReference)spaceTimeLevelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSpaceTimeLevel_OrderingDimensions() {
		return (EAttribute)spaceTimeLevelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpaceTimeLevel_TilingSpecifications() {
		return (EReference)spaceTimeLevelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpaceTimeLevel_LoopUnrollingSpecifications() {
		return (EReference)spaceTimeLevelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpaceTimeLevel_VectorizationSpecifications() {
		return (EReference)spaceTimeLevelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpaceTimeLevel_ParallelizationSpecifications() {
		return (EReference)spaceTimeLevelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpaceTimeLevel_ContainerTM() {
		return (EReference)spaceTimeLevelEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpaceTimeMap() {
		return spaceTimeMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpaceTimeMap_Mapping() {
		return (EReference)spaceTimeMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpaceTimeMap_InverseOfMapping() {
		return (EReference)spaceTimeMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSpaceTimeMap_Label() {
		return (EAttribute)spaceTimeMapEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureSpecification() {
		return featureSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureSpecification_OrderingPrefix() {
		return (EAttribute)featureSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTilingSpecification() {
		return tilingSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTilingSpecification_StartDim() {
		return (EAttribute)tilingSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTilingSpecification_EndDim() {
		return (EAttribute)tilingSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTilingSpecification_Levels() {
		return (EAttribute)tilingSpecificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTilingSpecification_SubTiles() {
		return (EReference)tilingSpecificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTilingSpecification_IdentificationName() {
		return (EAttribute)tilingSpecificationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopUnrollingSpecification() {
		return loopUnrollingSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoopUnrollingSpecification_UnrollingFactors() {
		return (EAttribute)loopUnrollingSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVectorizationSpecification() {
		return vectorizationSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParallelizationSpecification() {
		return parallelizationSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParallelizationSpecification_ParallelDims() {
		return (EAttribute)parallelizationSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemoryMap() {
		return memoryMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMemoryMap_Variable() {
		return (EReference)memoryMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMemoryMap_Mapping() {
		return (EReference)memoryMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMemoryMap_ModFactors() {
		return (EReference)memoryMapEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMemoryMap_Space() {
		return (EReference)memoryMapEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemorySpace() {
		return memorySpaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMemorySpace_Name() {
		return (EAttribute)memorySpaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMemorySpace_Type() {
		return (EReference)memorySpaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMemorySpace_Domain() {
		return (EReference)memorySpaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMemorySpace_ZeroAligned() {
		return (EAttribute)memorySpaceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMemorySpace_ContainerTM() {
		return (EReference)memorySpaceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStatementPartialOrder() {
		return statementPartialOrderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStatementPartialOrder_Predecessor() {
		return (EReference)statementPartialOrderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStatementPartialOrder_Successor() {
		return (EReference)statementPartialOrderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUseEquationOptimization() {
		return useEquationOptimizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUseEquationOptimization_Label() {
		return (EAttribute)useEquationOptimizationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUseEquationOptimization_Input() {
		return (EAttribute)useEquationOptimizationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUseEquationOptimization_Num() {
		return (EAttribute)useEquationOptimizationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseEquationOptimization_MemoryMappingForTemporaryVariable() {
		return (EReference)useEquationOptimizationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUseEquationOptimization_MemorySpaceNameforTemporaryVariable() {
		return (EAttribute)useEquationOptimizationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseEquationOptimization_MemoryAllocationSpaceTimeMap() {
		return (EReference)useEquationOptimizationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseEquationOptimization_ValueCopySpaceTimeMap() {
		return (EReference)useEquationOptimizationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseEquationOptimization_MemoryFreeSpaceTimeMap() {
		return (EReference)useEquationOptimizationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommunicationMappingForTiledSpace() {
		return communicationMappingForTiledSpaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommunicationMappingForTiledSpace_Variables() {
		return (EReference)communicationMappingForTiledSpaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommunicatedVariableForTiledSpace() {
		return communicatedVariableForTiledSpaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommunicatedVariableForTiledSpace_Variable() {
		return (EReference)communicatedVariableForTiledSpaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommunicatedVariableForTiledSpace_CommunicationDepths() {
		return (EAttribute)communicatedVariableForTiledSpaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubTilingSpecification() {
		return subTilingSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubTilingSpecification_TileSizes() {
		return (EAttribute)subTilingSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubTilingSpecification_TileSizeType() {
		return (EAttribute)subTilingSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubTilingSpecification_TilingType() {
		return (EAttribute)subTilingSpecificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubTilingSpecification_StartDim() {
		return (EAttribute)subTilingSpecificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubTilingSpecification_Level() {
		return (EAttribute)subTilingSpecificationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubTilingSpecification_CommunicationMapping() {
		return (EReference)subTilingSpecificationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubTilingSpecification_EndDim() {
		return (EAttribute)subTilingSpecificationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTILING_TYPE() {
		return tilinG_TYPEEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTILE_SIZE_TYPE() {
		return tilE_SIZE_TYPEEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMEMORY_TYPE() {
		return memorY_TYPEEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetMappingFactory getTargetMappingFactory() {
		return (TargetMappingFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		targetMappingEClass = createEClass(TARGET_MAPPING);
		createEReference(targetMappingEClass, TARGET_MAPPING__CONTAINER_SYSTEM);
		createEReference(targetMappingEClass, TARGET_MAPPING__SPACE_TIME_LEVELS);
		createEReference(targetMappingEClass, TARGET_MAPPING__MEMORY_MAPS);
		createEReference(targetMappingEClass, TARGET_MAPPING__MEMORY_SPACES);
		createEReference(targetMappingEClass, TARGET_MAPPING__STATEMENT_ORDERINGS);
		createEReference(targetMappingEClass, TARGET_MAPPING__USE_EQUATION_OPTIMIZATIONS);

		spaceTimeLevelEClass = createEClass(SPACE_TIME_LEVEL);
		createEReference(spaceTimeLevelEClass, SPACE_TIME_LEVEL__SPACE_TIME_MAPS);
		createEAttribute(spaceTimeLevelEClass, SPACE_TIME_LEVEL__ORDERING_DIMENSIONS);
		createEReference(spaceTimeLevelEClass, SPACE_TIME_LEVEL__TILING_SPECIFICATIONS);
		createEReference(spaceTimeLevelEClass, SPACE_TIME_LEVEL__LOOP_UNROLLING_SPECIFICATIONS);
		createEReference(spaceTimeLevelEClass, SPACE_TIME_LEVEL__VECTORIZATION_SPECIFICATIONS);
		createEReference(spaceTimeLevelEClass, SPACE_TIME_LEVEL__PARALLELIZATION_SPECIFICATIONS);
		createEReference(spaceTimeLevelEClass, SPACE_TIME_LEVEL__CONTAINER_TM);

		spaceTimeMapEClass = createEClass(SPACE_TIME_MAP);
		createEReference(spaceTimeMapEClass, SPACE_TIME_MAP__MAPPING);
		createEReference(spaceTimeMapEClass, SPACE_TIME_MAP__INVERSE_OF_MAPPING);
		createEAttribute(spaceTimeMapEClass, SPACE_TIME_MAP__LABEL);

		featureSpecificationEClass = createEClass(FEATURE_SPECIFICATION);
		createEAttribute(featureSpecificationEClass, FEATURE_SPECIFICATION__ORDERING_PREFIX);

		tilingSpecificationEClass = createEClass(TILING_SPECIFICATION);
		createEAttribute(tilingSpecificationEClass, TILING_SPECIFICATION__START_DIM);
		createEAttribute(tilingSpecificationEClass, TILING_SPECIFICATION__END_DIM);
		createEAttribute(tilingSpecificationEClass, TILING_SPECIFICATION__LEVELS);
		createEReference(tilingSpecificationEClass, TILING_SPECIFICATION__SUB_TILES);
		createEAttribute(tilingSpecificationEClass, TILING_SPECIFICATION__IDENTIFICATION_NAME);

		loopUnrollingSpecificationEClass = createEClass(LOOP_UNROLLING_SPECIFICATION);
		createEAttribute(loopUnrollingSpecificationEClass, LOOP_UNROLLING_SPECIFICATION__UNROLLING_FACTORS);

		vectorizationSpecificationEClass = createEClass(VECTORIZATION_SPECIFICATION);

		parallelizationSpecificationEClass = createEClass(PARALLELIZATION_SPECIFICATION);
		createEAttribute(parallelizationSpecificationEClass, PARALLELIZATION_SPECIFICATION__PARALLEL_DIMS);

		memoryMapEClass = createEClass(MEMORY_MAP);
		createEReference(memoryMapEClass, MEMORY_MAP__VARIABLE);
		createEReference(memoryMapEClass, MEMORY_MAP__MAPPING);
		createEReference(memoryMapEClass, MEMORY_MAP__MOD_FACTORS);
		createEReference(memoryMapEClass, MEMORY_MAP__SPACE);

		memorySpaceEClass = createEClass(MEMORY_SPACE);
		createEAttribute(memorySpaceEClass, MEMORY_SPACE__NAME);
		createEReference(memorySpaceEClass, MEMORY_SPACE__TYPE);
		createEReference(memorySpaceEClass, MEMORY_SPACE__DOMAIN);
		createEAttribute(memorySpaceEClass, MEMORY_SPACE__ZERO_ALIGNED);
		createEReference(memorySpaceEClass, MEMORY_SPACE__CONTAINER_TM);

		statementPartialOrderEClass = createEClass(STATEMENT_PARTIAL_ORDER);
		createEReference(statementPartialOrderEClass, STATEMENT_PARTIAL_ORDER__PREDECESSOR);
		createEReference(statementPartialOrderEClass, STATEMENT_PARTIAL_ORDER__SUCCESSOR);

		useEquationOptimizationEClass = createEClass(USE_EQUATION_OPTIMIZATION);
		createEAttribute(useEquationOptimizationEClass, USE_EQUATION_OPTIMIZATION__LABEL);
		createEAttribute(useEquationOptimizationEClass, USE_EQUATION_OPTIMIZATION__INPUT);
		createEAttribute(useEquationOptimizationEClass, USE_EQUATION_OPTIMIZATION__NUM);
		createEReference(useEquationOptimizationEClass, USE_EQUATION_OPTIMIZATION__MEMORY_MAPPING_FOR_TEMPORARY_VARIABLE);
		createEAttribute(useEquationOptimizationEClass, USE_EQUATION_OPTIMIZATION__MEMORY_SPACE_NAMEFOR_TEMPORARY_VARIABLE);
		createEReference(useEquationOptimizationEClass, USE_EQUATION_OPTIMIZATION__MEMORY_ALLOCATION_SPACE_TIME_MAP);
		createEReference(useEquationOptimizationEClass, USE_EQUATION_OPTIMIZATION__VALUE_COPY_SPACE_TIME_MAP);
		createEReference(useEquationOptimizationEClass, USE_EQUATION_OPTIMIZATION__MEMORY_FREE_SPACE_TIME_MAP);

		communicationMappingForTiledSpaceEClass = createEClass(COMMUNICATION_MAPPING_FOR_TILED_SPACE);
		createEReference(communicationMappingForTiledSpaceEClass, COMMUNICATION_MAPPING_FOR_TILED_SPACE__VARIABLES);

		communicatedVariableForTiledSpaceEClass = createEClass(COMMUNICATED_VARIABLE_FOR_TILED_SPACE);
		createEReference(communicatedVariableForTiledSpaceEClass, COMMUNICATED_VARIABLE_FOR_TILED_SPACE__VARIABLE);
		createEAttribute(communicatedVariableForTiledSpaceEClass, COMMUNICATED_VARIABLE_FOR_TILED_SPACE__COMMUNICATION_DEPTHS);

		subTilingSpecificationEClass = createEClass(SUB_TILING_SPECIFICATION);
		createEAttribute(subTilingSpecificationEClass, SUB_TILING_SPECIFICATION__TILE_SIZES);
		createEAttribute(subTilingSpecificationEClass, SUB_TILING_SPECIFICATION__TILE_SIZE_TYPE);
		createEAttribute(subTilingSpecificationEClass, SUB_TILING_SPECIFICATION__TILING_TYPE);
		createEAttribute(subTilingSpecificationEClass, SUB_TILING_SPECIFICATION__START_DIM);
		createEAttribute(subTilingSpecificationEClass, SUB_TILING_SPECIFICATION__LEVEL);
		createEReference(subTilingSpecificationEClass, SUB_TILING_SPECIFICATION__COMMUNICATION_MAPPING);
		createEAttribute(subTilingSpecificationEClass, SUB_TILING_SPECIFICATION__END_DIM);

		// Create enums
		tilinG_TYPEEEnum = createEEnum(TILING_TYPE);
		tilE_SIZE_TYPEEEnum = createEEnum(TILE_SIZE_TYPE);
		memorY_TYPEEEnum = createEEnum(MEMORY_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		PolyhedralIRPackage thePolyhedralIRPackage = (PolyhedralIRPackage)EPackage.Registry.INSTANCE.getEPackage(PolyhedralIRPackage.eNS_URI);
		PolymodelPackage thePolymodelPackage = (PolymodelPackage)EPackage.Registry.INSTANCE.getEPackage(PolymodelPackage.eNS_URI);
		AlgebraPackage theAlgebraPackage = (AlgebraPackage)EPackage.Registry.INSTANCE.getEPackage(AlgebraPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		targetMappingEClass.getESuperTypes().add(thePolyhedralIRPackage.getPolyhedralIRVisitable());
		spaceTimeLevelEClass.getESuperTypes().add(thePolyhedralIRPackage.getPolyhedralIRVisitable());
		spaceTimeMapEClass.getESuperTypes().add(thePolyhedralIRPackage.getPolyhedralIRVisitable());
		featureSpecificationEClass.getESuperTypes().add(thePolyhedralIRPackage.getPolyhedralIRVisitable());
		tilingSpecificationEClass.getESuperTypes().add(this.getFeatureSpecification());
		tilingSpecificationEClass.getESuperTypes().add(thePolyhedralIRPackage.getPolyhedralIRVisitable());
		loopUnrollingSpecificationEClass.getESuperTypes().add(this.getFeatureSpecification());
		loopUnrollingSpecificationEClass.getESuperTypes().add(thePolyhedralIRPackage.getPolyhedralIRVisitable());
		vectorizationSpecificationEClass.getESuperTypes().add(this.getFeatureSpecification());
		vectorizationSpecificationEClass.getESuperTypes().add(thePolyhedralIRPackage.getPolyhedralIRVisitable());
		parallelizationSpecificationEClass.getESuperTypes().add(this.getFeatureSpecification());
		parallelizationSpecificationEClass.getESuperTypes().add(thePolyhedralIRPackage.getPolyhedralIRVisitable());
		memoryMapEClass.getESuperTypes().add(thePolyhedralIRPackage.getPolyhedralIRVisitable());
		memorySpaceEClass.getESuperTypes().add(thePolyhedralIRPackage.getPolyhedralIRVisitable());
		statementPartialOrderEClass.getESuperTypes().add(thePolyhedralIRPackage.getPolyhedralIRVisitable());
		useEquationOptimizationEClass.getESuperTypes().add(thePolyhedralIRPackage.getPolyhedralIRVisitable());
		communicationMappingForTiledSpaceEClass.getESuperTypes().add(thePolyhedralIRPackage.getPolyhedralIRVisitable());
		communicatedVariableForTiledSpaceEClass.getESuperTypes().add(thePolyhedralIRPackage.getPolyhedralIRVisitable());
		subTilingSpecificationEClass.getESuperTypes().add(thePolyhedralIRPackage.getPolyhedralIRVisitable());

		// Initialize classes and features; add operations and parameters
		initEClass(targetMappingEClass, TargetMapping.class, "TargetMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTargetMapping_ContainerSystem(), thePolyhedralIRPackage.getAffineSystem(), thePolyhedralIRPackage.getAffineSystem_TargetMapping(), "containerSystem", null, 1, 1, TargetMapping.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTargetMapping_SpaceTimeLevels(), this.getSpaceTimeLevel(), this.getSpaceTimeLevel_ContainerTM(), "spaceTimeLevels", null, 0, -1, TargetMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		EGenericType g1 = createEGenericType(thePolymodelPackage.getValueContainedMap());
		EGenericType g2 = createEGenericType(thePolyhedralIRPackage.getVariableDeclaration());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getMemoryMap());
		g1.getETypeArguments().add(g2);
		initEReference(getTargetMapping_MemoryMaps(), g1, null, "memoryMaps", null, 0, -1, TargetMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTargetMapping_MemorySpaces(), this.getMemorySpace(), this.getMemorySpace_ContainerTM(), "memorySpaces", null, 0, -1, TargetMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTargetMapping_StatementOrderings(), this.getStatementPartialOrder(), null, "statementOrderings", null, 0, -1, TargetMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTargetMapping_UseEquationOptimizations(), this.getUseEquationOptimization(), null, "useEquationOptimizations", null, 0, -1, TargetMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(targetMappingEClass, this.getSpaceTimeLevel(), "getSpaceTimeLevel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "level", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(targetMappingEClass, thePolyhedralIRPackage.getEquation(), "getStatementTotalOrder", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(targetMappingEClass, ecorePackage.getEBoolean(), "isTiled", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(targetMappingEClass, this.getMemorySpace(), "getMemorySpace", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(targetMappingEClass, this.getUseEquationOptimization(), "getUseEquationOptimizations", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "label", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(targetMappingEClass, this.getUseEquationOptimization(), "getUseEquationOptimization", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "label", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "num", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isInput", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(targetMappingEClass, ecorePackage.getEBoolean(), "isParallelized", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(targetMappingEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePolyhedralIRPackage.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(spaceTimeLevelEClass, SpaceTimeLevel.class, "SpaceTimeLevel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(thePolymodelPackage.getValueContainedMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getSpaceTimeMap());
		g1.getETypeArguments().add(g2);
		initEReference(getSpaceTimeLevel_SpaceTimeMaps(), g1, null, "spaceTimeMaps", null, 0, -1, SpaceTimeLevel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSpaceTimeLevel_OrderingDimensions(), ecorePackage.getEInt(), "orderingDimensions", null, 0, -1, SpaceTimeLevel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpaceTimeLevel_TilingSpecifications(), this.getTilingSpecification(), null, "tilingSpecifications", null, 0, -1, SpaceTimeLevel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpaceTimeLevel_LoopUnrollingSpecifications(), this.getLoopUnrollingSpecification(), null, "loopUnrollingSpecifications", null, 0, -1, SpaceTimeLevel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpaceTimeLevel_VectorizationSpecifications(), this.getVectorizationSpecification(), null, "vectorizationSpecifications", null, 0, -1, SpaceTimeLevel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpaceTimeLevel_ParallelizationSpecifications(), this.getParallelizationSpecification(), null, "parallelizationSpecifications", null, 0, -1, SpaceTimeLevel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpaceTimeLevel_ContainerTM(), this.getTargetMapping(), this.getTargetMapping_SpaceTimeLevels(), "containerTM", null, 1, 1, SpaceTimeLevel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(spaceTimeLevelEClass, ecorePackage.getEInt(), "getNumberOfOrderingDimensions", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(spaceTimeLevelEClass, ecorePackage.getEInt(), "getNumberOfTiledDimensions", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(spaceTimeLevelEClass, ecorePackage.getEInt(), "getNumberOfParallelDimensions", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(spaceTimeLevelEClass, ecorePackage.getEInt(), "getNumberOfSequentialDimensions", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(spaceTimeLevelEClass, ecorePackage.getEInt(), "getNumberOfDimensions", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(spaceTimeLevelEClass, thePolyhedralIRPackage.getAffineFunction(), "getAccessFunction", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePolyhedralIRPackage.getVariableDeclaration(), "variable", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(spaceTimeLevelEClass, this.getTilingSpecification(), "getTilingSpecification", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "bandName", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(spaceTimeLevelEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePolyhedralIRPackage.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(spaceTimeMapEClass, SpaceTimeMap.class, "SpaceTimeMap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpaceTimeMap_Mapping(), thePolyhedralIRPackage.getAffineFunction(), null, "mapping", null, 1, 1, SpaceTimeMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpaceTimeMap_InverseOfMapping(), thePolyhedralIRPackage.getAffineFunction(), null, "inverseOfMapping", null, 1, 1, SpaceTimeMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSpaceTimeMap_Label(), ecorePackage.getEString(), "label", null, 1, 1, SpaceTimeMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(spaceTimeMapEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePolyhedralIRPackage.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(featureSpecificationEClass, FeatureSpecification.class, "FeatureSpecification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeatureSpecification_OrderingPrefix(), ecorePackage.getEInt(), "orderingPrefix", null, 0, -1, FeatureSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(featureSpecificationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePolyhedralIRPackage.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(tilingSpecificationEClass, TilingSpecification.class, "TilingSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTilingSpecification_StartDim(), ecorePackage.getEInt(), "startDim", null, 1, 1, TilingSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTilingSpecification_EndDim(), ecorePackage.getEInt(), "endDim", null, 1, 1, TilingSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTilingSpecification_Levels(), ecorePackage.getEInt(), "levels", null, 1, 1, TilingSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTilingSpecification_SubTiles(), this.getSubTilingSpecification(), null, "subTiles", null, 0, -1, TilingSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTilingSpecification_IdentificationName(), ecorePackage.getEString(), "identificationName", null, 1, 1, TilingSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(tilingSpecificationEClass, this.getSubTilingSpecification(), "getSubTile", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "level", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(tilingSpecificationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePolyhedralIRPackage.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(loopUnrollingSpecificationEClass, LoopUnrollingSpecification.class, "LoopUnrollingSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLoopUnrollingSpecification_UnrollingFactors(), ecorePackage.getEInt(), "unrollingFactors", null, 0, -1, LoopUnrollingSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(loopUnrollingSpecificationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePolyhedralIRPackage.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(vectorizationSpecificationEClass, VectorizationSpecification.class, "VectorizationSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(vectorizationSpecificationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePolyhedralIRPackage.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(parallelizationSpecificationEClass, ParallelizationSpecification.class, "ParallelizationSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParallelizationSpecification_ParallelDims(), ecorePackage.getEInt(), "parallelDims", null, 0, -1, ParallelizationSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(parallelizationSpecificationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePolyhedralIRPackage.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(memoryMapEClass, MemoryMap.class, "MemoryMap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMemoryMap_Variable(), thePolyhedralIRPackage.getVariableDeclaration(), null, "variable", null, 1, 1, MemoryMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMemoryMap_Mapping(), thePolyhedralIRPackage.getAffineFunction(), null, "mapping", null, 1, 1, MemoryMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMemoryMap_ModFactors(), theAlgebraPackage.getIntExpression(), null, "modFactors", null, 0, -1, MemoryMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMemoryMap_Space(), this.getMemorySpace(), null, "space", null, 1, 1, MemoryMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(memoryMapEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePolyhedralIRPackage.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(memorySpaceEClass, MemorySpace.class, "MemorySpace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMemorySpace_Name(), ecorePackage.getEString(), "name", null, 1, 1, MemorySpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMemorySpace_Type(), thePolyhedralIRPackage.getType(), null, "type", null, 1, 1, MemorySpace.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getMemorySpace_Domain(), thePolyhedralIRPackage.getDomain(), null, "domain", null, 1, 1, MemorySpace.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getMemorySpace_ZeroAligned(), ecorePackage.getEBoolean(), "zeroAligned", "true", 1, 1, MemorySpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMemorySpace_ContainerTM(), this.getTargetMapping(), this.getTargetMapping_MemorySpaces(), "containerTM", null, 1, 1, MemorySpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(memorySpaceEClass, theAlgebraPackage.getIntExpression(), "getModFactors", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(memorySpaceEClass, this.getMemoryMap(), "getMemoryMaps", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(memorySpaceEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePolyhedralIRPackage.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(statementPartialOrderEClass, StatementPartialOrder.class, "StatementPartialOrder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStatementPartialOrder_Predecessor(), thePolyhedralIRPackage.getEquation(), null, "predecessor", null, 1, 1, StatementPartialOrder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStatementPartialOrder_Successor(), thePolyhedralIRPackage.getEquation(), null, "successor", null, 1, 1, StatementPartialOrder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(statementPartialOrderEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePolyhedralIRPackage.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(useEquationOptimizationEClass, UseEquationOptimization.class, "UseEquationOptimization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUseEquationOptimization_Label(), ecorePackage.getEString(), "label", null, 1, 1, UseEquationOptimization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUseEquationOptimization_Input(), ecorePackage.getEBoolean(), "input", null, 1, 1, UseEquationOptimization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUseEquationOptimization_Num(), ecorePackage.getEInt(), "num", null, 1, 1, UseEquationOptimization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUseEquationOptimization_MemoryMappingForTemporaryVariable(), thePolyhedralIRPackage.getAffineFunction(), null, "MemoryMappingForTemporaryVariable", null, 1, 1, UseEquationOptimization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUseEquationOptimization_MemorySpaceNameforTemporaryVariable(), ecorePackage.getEString(), "MemorySpaceNameforTemporaryVariable", null, 1, 1, UseEquationOptimization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUseEquationOptimization_MemoryAllocationSpaceTimeMap(), thePolyhedralIRPackage.getAffineFunction(), null, "memoryAllocationSpaceTimeMap", null, 0, 1, UseEquationOptimization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUseEquationOptimization_ValueCopySpaceTimeMap(), thePolyhedralIRPackage.getAffineFunction(), null, "valueCopySpaceTimeMap", null, 0, 1, UseEquationOptimization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUseEquationOptimization_MemoryFreeSpaceTimeMap(), thePolyhedralIRPackage.getAffineFunction(), null, "memoryFreeSpaceTimeMap", null, 0, 1, UseEquationOptimization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(useEquationOptimizationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePolyhedralIRPackage.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(communicationMappingForTiledSpaceEClass, CommunicationMappingForTiledSpace.class, "CommunicationMappingForTiledSpace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCommunicationMappingForTiledSpace_Variables(), this.getCommunicatedVariableForTiledSpace(), null, "variables", null, 0, -1, CommunicationMappingForTiledSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(communicationMappingForTiledSpaceEClass, this.getCommunicatedVariableForTiledSpace(), "getCommunicatedVariable", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePolyhedralIRPackage.getVariableDeclaration(), "variable", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(communicationMappingForTiledSpaceEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePolyhedralIRPackage.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(communicatedVariableForTiledSpaceEClass, CommunicatedVariableForTiledSpace.class, "CommunicatedVariableForTiledSpace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCommunicatedVariableForTiledSpace_Variable(), thePolyhedralIRPackage.getVariableDeclaration(), null, "variable", null, 1, 1, CommunicatedVariableForTiledSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommunicatedVariableForTiledSpace_CommunicationDepths(), ecorePackage.getEInt(), "communicationDepths", null, 0, -1, CommunicatedVariableForTiledSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(communicatedVariableForTiledSpaceEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePolyhedralIRPackage.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(subTilingSpecificationEClass, SubTilingSpecification.class, "SubTilingSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSubTilingSpecification_TileSizes(), ecorePackage.getEInt(), "tileSizes", null, 0, -1, SubTilingSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubTilingSpecification_TileSizeType(), this.getTILE_SIZE_TYPE(), "tileSizeType", null, 1, 1, SubTilingSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubTilingSpecification_TilingType(), this.getTILING_TYPE(), "tilingType", null, 1, 1, SubTilingSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubTilingSpecification_StartDim(), ecorePackage.getEInt(), "startDim", null, 1, 1, SubTilingSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubTilingSpecification_Level(), ecorePackage.getEInt(), "level", null, 1, 1, SubTilingSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSubTilingSpecification_CommunicationMapping(), this.getCommunicationMappingForTiledSpace(), null, "communicationMapping", null, 1, 1, SubTilingSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubTilingSpecification_EndDim(), ecorePackage.getEInt(), "endDim", null, 1, 1, SubTilingSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(subTilingSpecificationEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, thePolyhedralIRPackage.getPolyhedralIRVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(tilinG_TYPEEEnum, org.polymodel.polyhedralIR.targetMapping.TILING_TYPE.class, "TILING_TYPE");
		addEEnumLiteral(tilinG_TYPEEEnum, org.polymodel.polyhedralIR.targetMapping.TILING_TYPE.SEQUENTIAL);
		addEEnumLiteral(tilinG_TYPEEEnum, org.polymodel.polyhedralIR.targetMapping.TILING_TYPE.OMPWAVEFRONT);
		addEEnumLiteral(tilinG_TYPEEEnum, org.polymodel.polyhedralIR.targetMapping.TILING_TYPE.PGAS);
		addEEnumLiteral(tilinG_TYPEEEnum, org.polymodel.polyhedralIR.targetMapping.TILING_TYPE.MPIC);

		initEEnum(tilE_SIZE_TYPEEEnum, org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE.class, "TILE_SIZE_TYPE");
		addEEnumLiteral(tilE_SIZE_TYPEEEnum, org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE.PARAMETERIZED);
		addEEnumLiteral(tilE_SIZE_TYPEEEnum, org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE.FIXED);
		addEEnumLiteral(tilE_SIZE_TYPEEEnum, org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE.PARAMETER_FIX);

		initEEnum(memorY_TYPEEEnum, org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE.class, "MEMORY_TYPE");
		addEEnumLiteral(memorY_TYPEEEnum, org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE.HOST);
		addEEnumLiteral(memorY_TYPEEEnum, org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE.DEVICE_GLOBAL);
		addEEnumLiteral(memorY_TYPEEEnum, org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE.SHARED);
		addEEnumLiteral(memorY_TYPEEEnum, org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE.REGISTER);
		addEEnumLiteral(memorY_TYPEEEnum, org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE.CACHED);
		addEEnumLiteral(memorY_TYPEEEnum, org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE.CONSTANT);
		addEEnumLiteral(memorY_TYPEEEnum, org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE.TEXTURE);
	}

} //TargetMappingPackageImpl
