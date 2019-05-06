/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.polymodel.PolymodelPackage;
import org.polymodel.polyhedralIR.PolyhedralIRPackage;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.CFactory;
import org.polymodel.polyhedralIR.polyIRCG.C.CLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.CPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.CVariable;
import org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock;
import org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement;
import org.polymodel.polyhedralIR.polyIRCG.C.ParallelizedCLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.ParameterCheck;
import org.polymodel.polyhedralIR.polyIRCG.C.ScopLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.SubTileSpecification;
import org.polymodel.polyhedralIR.polyIRCG.C.TileSpecification;
import org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.CDistributedPackageImpl;
import org.polymodel.polyhedralIR.polyIRCG.C.pcot.PcotPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.pcot.impl.PcotPackageImpl;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanPackageImpl;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.CWrapperPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.CWrapperPackageImpl;
import org.polymodel.polyhedralIR.polyIRCG.PCOT.PCOTPackage;
import org.polymodel.polyhedralIR.polyIRCG.PCOT.impl.PCOTPackageImpl;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDPackageImpl;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpPackage;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.impl.SimdExpPackageImpl;
import org.polymodel.polyhedralIR.polyIRCG.algebraEx.AlgebraExPackage;
import org.polymodel.polyhedralIR.polyIRCG.algebraEx.impl.AlgebraExPackageImpl;
import org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl;
import org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage;
import org.polymodel.scop.ScopPackage;
import org.polymodel.scop.dtiler.DTilingOptions;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CPackageImpl extends EPackageImpl implements CPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equationAsStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterCheckEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tiledCLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parallelizedCLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scopLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dTiledLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dTiledBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subTileSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tileSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType dTilingOptionsEDataType = null;

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
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CPackageImpl() {
		super(eNS_URI, CFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CPackage init() {
		if (isInited) return (CPackage)EPackage.Registry.INSTANCE.getEPackage(CPackage.eNS_URI);

		// Obtain or create and register package
		CPackageImpl theCPackage = (CPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PolyhedralIRPackage.eINSTANCE.eClass();
		ScopPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		PolyIRCGPackageImpl thePolyIRCGPackage = (PolyIRCGPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PolyIRCGPackage.eNS_URI) instanceof PolyIRCGPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PolyIRCGPackage.eNS_URI) : PolyIRCGPackage.eINSTANCE);
		CWrapperPackageImpl theCWrapperPackage = (CWrapperPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CWrapperPackage.eNS_URI) instanceof CWrapperPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CWrapperPackage.eNS_URI) : CWrapperPackage.eINSTANCE);
		CDistributedPackageImpl theCDistributedPackage = (CDistributedPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CDistributedPackage.eNS_URI) instanceof CDistributedPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CDistributedPackage.eNS_URI) : CDistributedPackage.eINSTANCE);
		ScanPackageImpl theScanPackage = (ScanPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ScanPackage.eNS_URI) instanceof ScanPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ScanPackage.eNS_URI) : ScanPackage.eINSTANCE);
		PcotPackageImpl thePcotPackage = (PcotPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PcotPackage.eNS_URI) instanceof PcotPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PcotPackage.eNS_URI) : PcotPackage.eINSTANCE);
		AlgebraExPackageImpl theAlgebraExPackage = (AlgebraExPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AlgebraExPackage.eNS_URI) instanceof AlgebraExPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AlgebraExPackage.eNS_URI) : AlgebraExPackage.eINSTANCE);
		SIMDPackageImpl theSIMDPackage = (SIMDPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SIMDPackage.eNS_URI) instanceof SIMDPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SIMDPackage.eNS_URI) : SIMDPackage.eINSTANCE);
		SimdExpPackageImpl theSimdExpPackage = (SimdExpPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SimdExpPackage.eNS_URI) instanceof SimdExpPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SimdExpPackage.eNS_URI) : SimdExpPackage.eINSTANCE);
		PCOTPackageImpl thePCOTPackage = (PCOTPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PCOTPackage.eNS_URI) instanceof PCOTPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PCOTPackage.eNS_URI) : PCOTPackage.eINSTANCE);

		// Create package meta-data objects
		theCPackage.createPackageContents();
		thePolyIRCGPackage.createPackageContents();
		theCWrapperPackage.createPackageContents();
		theCDistributedPackage.createPackageContents();
		theScanPackage.createPackageContents();
		thePcotPackage.createPackageContents();
		theAlgebraExPackage.createPackageContents();
		theSIMDPackage.createPackageContents();
		theSimdExpPackage.createPackageContents();
		thePCOTPackage.createPackageContents();

		// Initialize created meta-data
		theCPackage.initializePackageContents();
		thePolyIRCGPackage.initializePackageContents();
		theCWrapperPackage.initializePackageContents();
		theCDistributedPackage.initializePackageContents();
		theScanPackage.initializePackageContents();
		thePcotPackage.initializePackageContents();
		theAlgebraExPackage.initializePackageContents();
		theSIMDPackage.initializePackageContents();
		theSimdExpPackage.initializePackageContents();
		thePCOTPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CPackage.eNS_URI, theCPackage);
		return theCPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEquationAsStatement() {
		return equationAsStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquationAsStatement_Variable() {
		return (EReference)equationAsStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquationAsStatement_AccessFunction() {
		return (EReference)equationAsStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquationAsStatement_Rhs() {
		return (EReference)equationAsStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquationAsStatement_VarDecl() {
		return (EReference)equationAsStatementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterCheck() {
		return parameterCheckEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterCheck_ParameterDomain() {
		return (EReference)parameterCheckEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCLoop() {
		return cLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCLoop_UseMacros() {
		return (EAttribute)cLoopEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTiledCLoop() {
		return tiledCLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTiledCLoop_Optimize() {
		return (EAttribute)tiledCLoopEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTiledCLoop_Tiles() {
		return (EReference)tiledCLoopEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTiledCLoop_OrderingDimensions() {
		return (EAttribute)tiledCLoopEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTiledCLoop_OptimizedPointLoop() {
		return (EReference)tiledCLoopEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParallelizedCLoop() {
		return parallelizedCLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParallelizedCLoop_ParallelizedDims() {
		return (EReference)parallelizedCLoopEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParallelizedCLoop_OrderingDims() {
		return (EAttribute)parallelizedCLoopEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParallelizedCLoop_SubsystemVariables() {
		return (EReference)parallelizedCLoopEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScopLoop() {
		return scopLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScopLoop_Tiles() {
		return (EReference)scopLoopEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScopLoop_ScopRoot() {
		return (EReference)scopLoopEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVariable() {
		return cVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDTiledLoop() {
		return dTiledLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDTiledLoop_Scop() {
		return (EReference)dTiledLoopEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDTiledLoop_TiledBlocks() {
		return (EReference)dTiledLoopEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDTiledLoop_DtilingOptions() {
		return (EAttribute)dTiledLoopEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDTiledLoop_GeneratorLoop() {
		return (EReference)dTiledLoopEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDTiledBlock() {
		return dTiledBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDTiledBlock_BlockStart() {
		return (EReference)dTiledBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDTiledBlock_PointLoopStart() {
		return (EReference)dTiledBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDTiledBlock_TileLoopStart() {
		return (EReference)dTiledBlockEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDTiledBlock_PerfectLoopNest() {
		return (EReference)dTiledBlockEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDTiledBlock_ContainerLoop() {
		return (EReference)dTiledBlockEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubTileSpecification() {
		return subTileSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubTileSpecification_Level() {
		return (EAttribute)subTileSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubTileSpecification_Start() {
		return (EAttribute)subTileSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubTileSpecification_End() {
		return (EAttribute)subTileSpecificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubTileSpecification_TileSizes() {
		return (EAttribute)subTileSpecificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubTileSpecification_TileType() {
		return (EAttribute)subTileSpecificationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubTileSpecification_TileIndexPrefix() {
		return (EAttribute)subTileSpecificationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSubTileSpecification_TileSizePrefix() {
		return (EAttribute)subTileSpecificationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTileSpecification() {
		return tileSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTileSpecification_Levels() {
		return (EAttribute)tileSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTileSpecification_StartDim() {
		return (EAttribute)tileSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTileSpecification_EndDim() {
		return (EAttribute)tileSpecificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTileSpecification_SubTiles() {
		return (EReference)tileSpecificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTileSpecification_OrderingPrefix() {
		return (EAttribute)tileSpecificationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDTilingOptions() {
		return dTilingOptionsEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CFactory getCFactory() {
		return (CFactory)getEFactoryInstance();
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
		equationAsStatementEClass = createEClass(EQUATION_AS_STATEMENT);
		createEReference(equationAsStatementEClass, EQUATION_AS_STATEMENT__VARIABLE);
		createEReference(equationAsStatementEClass, EQUATION_AS_STATEMENT__ACCESS_FUNCTION);
		createEReference(equationAsStatementEClass, EQUATION_AS_STATEMENT__RHS);
		createEReference(equationAsStatementEClass, EQUATION_AS_STATEMENT__VAR_DECL);

		parameterCheckEClass = createEClass(PARAMETER_CHECK);
		createEReference(parameterCheckEClass, PARAMETER_CHECK__PARAMETER_DOMAIN);

		cLoopEClass = createEClass(CLOOP);
		createEAttribute(cLoopEClass, CLOOP__USE_MACROS);

		tiledCLoopEClass = createEClass(TILED_CLOOP);
		createEAttribute(tiledCLoopEClass, TILED_CLOOP__OPTIMIZE);
		createEReference(tiledCLoopEClass, TILED_CLOOP__TILES);
		createEAttribute(tiledCLoopEClass, TILED_CLOOP__ORDERING_DIMENSIONS);
		createEReference(tiledCLoopEClass, TILED_CLOOP__OPTIMIZED_POINT_LOOP);

		parallelizedCLoopEClass = createEClass(PARALLELIZED_CLOOP);
		createEReference(parallelizedCLoopEClass, PARALLELIZED_CLOOP__PARALLELIZED_DIMS);
		createEAttribute(parallelizedCLoopEClass, PARALLELIZED_CLOOP__ORDERING_DIMS);
		createEReference(parallelizedCLoopEClass, PARALLELIZED_CLOOP__SUBSYSTEM_VARIABLES);

		scopLoopEClass = createEClass(SCOP_LOOP);
		createEReference(scopLoopEClass, SCOP_LOOP__TILES);
		createEReference(scopLoopEClass, SCOP_LOOP__SCOP_ROOT);

		cVariableEClass = createEClass(CVARIABLE);

		dTiledLoopEClass = createEClass(DTILED_LOOP);
		createEReference(dTiledLoopEClass, DTILED_LOOP__SCOP);
		createEReference(dTiledLoopEClass, DTILED_LOOP__TILED_BLOCKS);
		createEAttribute(dTiledLoopEClass, DTILED_LOOP__DTILING_OPTIONS);
		createEReference(dTiledLoopEClass, DTILED_LOOP__GENERATOR_LOOP);

		dTiledBlockEClass = createEClass(DTILED_BLOCK);
		createEReference(dTiledBlockEClass, DTILED_BLOCK__BLOCK_START);
		createEReference(dTiledBlockEClass, DTILED_BLOCK__POINT_LOOP_START);
		createEReference(dTiledBlockEClass, DTILED_BLOCK__TILE_LOOP_START);
		createEReference(dTiledBlockEClass, DTILED_BLOCK__PERFECT_LOOP_NEST);
		createEReference(dTiledBlockEClass, DTILED_BLOCK__CONTAINER_LOOP);

		subTileSpecificationEClass = createEClass(SUB_TILE_SPECIFICATION);
		createEAttribute(subTileSpecificationEClass, SUB_TILE_SPECIFICATION__LEVEL);
		createEAttribute(subTileSpecificationEClass, SUB_TILE_SPECIFICATION__START);
		createEAttribute(subTileSpecificationEClass, SUB_TILE_SPECIFICATION__END);
		createEAttribute(subTileSpecificationEClass, SUB_TILE_SPECIFICATION__TILE_SIZES);
		createEAttribute(subTileSpecificationEClass, SUB_TILE_SPECIFICATION__TILE_TYPE);
		createEAttribute(subTileSpecificationEClass, SUB_TILE_SPECIFICATION__TILE_INDEX_PREFIX);
		createEAttribute(subTileSpecificationEClass, SUB_TILE_SPECIFICATION__TILE_SIZE_PREFIX);

		tileSpecificationEClass = createEClass(TILE_SPECIFICATION);
		createEAttribute(tileSpecificationEClass, TILE_SPECIFICATION__LEVELS);
		createEAttribute(tileSpecificationEClass, TILE_SPECIFICATION__START_DIM);
		createEAttribute(tileSpecificationEClass, TILE_SPECIFICATION__END_DIM);
		createEReference(tileSpecificationEClass, TILE_SPECIFICATION__SUB_TILES);
		createEAttribute(tileSpecificationEClass, TILE_SPECIFICATION__ORDERING_PREFIX);

		// Create data types
		dTilingOptionsEDataType = createEDataType(DTILING_OPTIONS);
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
		CWrapperPackage theCWrapperPackage = (CWrapperPackage)EPackage.Registry.INSTANCE.getEPackage(CWrapperPackage.eNS_URI);
		CDistributedPackage theCDistributedPackage = (CDistributedPackage)EPackage.Registry.INSTANCE.getEPackage(CDistributedPackage.eNS_URI);
		ScanPackage theScanPackage = (ScanPackage)EPackage.Registry.INSTANCE.getEPackage(ScanPackage.eNS_URI);
		PcotPackage thePcotPackage = (PcotPackage)EPackage.Registry.INSTANCE.getEPackage(PcotPackage.eNS_URI);
		PolyIRCGPackage thePolyIRCGPackage = (PolyIRCGPackage)EPackage.Registry.INSTANCE.getEPackage(PolyIRCGPackage.eNS_URI);
		PolyhedralIRPackage thePolyhedralIRPackage = (PolyhedralIRPackage)EPackage.Registry.INSTANCE.getEPackage(PolyhedralIRPackage.eNS_URI);
		TargetMappingPackage theTargetMappingPackage = (TargetMappingPackage)EPackage.Registry.INSTANCE.getEPackage(TargetMappingPackage.eNS_URI);
		PolymodelPackage thePolymodelPackage = (PolymodelPackage)EPackage.Registry.INSTANCE.getEPackage(PolymodelPackage.eNS_URI);
		ScopPackage theScopPackage = (ScopPackage)EPackage.Registry.INSTANCE.getEPackage(ScopPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theCWrapperPackage);
		getESubpackages().add(theCDistributedPackage);
		getESubpackages().add(theScanPackage);
		getESubpackages().add(thePcotPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		equationAsStatementEClass.getESuperTypes().add(thePolyIRCGPackage.getStatement());
		parameterCheckEClass.getESuperTypes().add(thePolyIRCGPackage.getBody());
		cLoopEClass.getESuperTypes().add(thePolyIRCGPackage.getLoop());
		tiledCLoopEClass.getESuperTypes().add(this.getCLoop());
		parallelizedCLoopEClass.getESuperTypes().add(this.getCLoop());
		scopLoopEClass.getESuperTypes().add(this.getCLoop());
		cVariableEClass.getESuperTypes().add(thePolyIRCGPackage.getCodeGenVariable());

		// Initialize classes and features; add operations and parameters
		initEClass(equationAsStatementEClass, EquationAsStatement.class, "EquationAsStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEquationAsStatement_Variable(), thePolyIRCGPackage.getCodeGenVariable(), null, "variable", null, 0, 1, EquationAsStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEquationAsStatement_AccessFunction(), thePolyhedralIRPackage.getAffineFunction(), null, "accessFunction", null, 0, 1, EquationAsStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEquationAsStatement_Rhs(), thePolyhedralIRPackage.getExpression(), null, "rhs", null, 1, 1, EquationAsStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEquationAsStatement_VarDecl(), thePolyhedralIRPackage.getVariableDeclaration(), null, "varDecl", null, 1, 1, EquationAsStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterCheckEClass, ParameterCheck.class, "ParameterCheck", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterCheck_ParameterDomain(), thePolyhedralIRPackage.getParameterDomain(), null, "parameterDomain", null, 0, 1, ParameterCheck.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cLoopEClass, CLoop.class, "CLoop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCLoop_UseMacros(), ecorePackage.getEBoolean(), "useMacros", "true", 1, 1, CLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tiledCLoopEClass, TiledCLoop.class, "TiledCLoop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTiledCLoop_Optimize(), ecorePackage.getEBoolean(), "optimize", "false", 1, 1, TiledCLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTiledCLoop_Tiles(), this.getTileSpecification(), null, "tiles", null, 0, -1, TiledCLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTiledCLoop_OrderingDimensions(), ecorePackage.getEInt(), "orderingDimensions", null, 0, -1, TiledCLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTiledCLoop_OptimizedPointLoop(), this.getCLoop(), null, "optimizedPointLoop", null, 0, 1, TiledCLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(tiledCLoopEClass, ecorePackage.getEString(), "getTileIndices", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(tiledCLoopEClass, this.getDTiledLoop(), "generateDTiledLoop", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(parallelizedCLoopEClass, ParallelizedCLoop.class, "ParallelizedCLoop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParallelizedCLoop_ParallelizedDims(), theTargetMappingPackage.getParallelizationSpecification(), null, "parallelizedDims", null, 0, -1, ParallelizedCLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParallelizedCLoop_OrderingDims(), ecorePackage.getEInt(), "orderingDims", null, 0, -1, ParallelizedCLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		EGenericType g1 = createEGenericType(thePolymodelPackage.getValueContainedMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(thePolyhedralIRPackage.getVariableDeclaration());
		g1.getETypeArguments().add(g2);
		initEReference(getParallelizedCLoop_SubsystemVariables(), g1, null, "subsystemVariables", null, 0, -1, ParallelizedCLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scopLoopEClass, ScopLoop.class, "ScopLoop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScopLoop_Tiles(), this.getTileSpecification(), null, "tiles", null, 0, -1, ScopLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScopLoop_ScopRoot(), theScopPackage.getScopRoot(), null, "scopRoot", null, 0, 1, ScopLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cVariableEClass, CVariable.class, "CVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dTiledLoopEClass, DTiledLoop.class, "DTiledLoop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDTiledLoop_Scop(), theScopPackage.getScopRoot(), null, "scop", null, 1, 1, DTiledLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDTiledLoop_TiledBlocks(), this.getDTiledBlock(), this.getDTiledBlock_ContainerLoop(), "tiledBlocks", null, 0, -1, DTiledLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDTiledLoop_DtilingOptions(), this.getDTilingOptions(), "dtilingOptions", null, 0, 1, DTiledLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDTiledLoop_GeneratorLoop(), this.getTiledCLoop(), null, "generatorLoop", null, 1, 1, DTiledLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dTiledBlockEClass, DTiledBlock.class, "DTiledBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDTiledBlock_BlockStart(), theScopPackage.getAbstractScopNode(), null, "blockStart", null, 0, 1, DTiledBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDTiledBlock_PointLoopStart(), theScopPackage.getAbstractScopNode(), null, "pointLoopStart", null, 1, 1, DTiledBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDTiledBlock_TileLoopStart(), theScopPackage.getAbstractScopNode(), null, "tileLoopStart", null, 1, 1, DTiledBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDTiledBlock_PerfectLoopNest(), theScopPackage.getScopFor(), null, "perfectLoopNest", null, 1, 1, DTiledBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDTiledBlock_ContainerLoop(), this.getDTiledLoop(), this.getDTiledLoop_TiledBlocks(), "containerLoop", null, 0, 1, DTiledBlock.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subTileSpecificationEClass, SubTileSpecification.class, "SubTileSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSubTileSpecification_Level(), ecorePackage.getEInt(), "level", null, 1, 1, SubTileSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubTileSpecification_Start(), ecorePackage.getEInt(), "start", null, 1, 1, SubTileSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubTileSpecification_End(), ecorePackage.getEInt(), "end", null, 1, 1, SubTileSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubTileSpecification_TileSizes(), ecorePackage.getEInt(), "tileSizes", null, 1, -1, SubTileSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubTileSpecification_TileType(), theTargetMappingPackage.getTILING_TYPE(), "tileType", null, 1, 1, SubTileSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubTileSpecification_TileIndexPrefix(), ecorePackage.getEString(), "tileIndexPrefix", null, 1, 1, SubTileSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSubTileSpecification_TileSizePrefix(), ecorePackage.getEString(), "tileSizePrefix", null, 1, 1, SubTileSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tileSpecificationEClass, TileSpecification.class, "TileSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTileSpecification_Levels(), ecorePackage.getEInt(), "levels", null, 1, 1, TileSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTileSpecification_StartDim(), ecorePackage.getEInt(), "startDim", null, 1, 1, TileSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTileSpecification_EndDim(), ecorePackage.getEInt(), "endDim", null, 1, 1, TileSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTileSpecification_SubTiles(), this.getSubTileSpecification(), null, "subTiles", null, 0, -1, TileSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTileSpecification_OrderingPrefix(), ecorePackage.getEInt(), "orderingPrefix", null, 0, -1, TileSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(dTilingOptionsEDataType, DTilingOptions.class, "DTilingOptions", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
	}

} //CPackageImpl
