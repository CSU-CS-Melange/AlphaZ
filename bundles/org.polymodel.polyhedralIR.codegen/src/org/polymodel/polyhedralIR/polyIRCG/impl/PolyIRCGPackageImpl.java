/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.polymodel.PolymodelPackage;
import org.polymodel.algebra.AlgebraPackage;
import org.polymodel.polyhedralIR.PolyhedralIRPackage;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.BasicBody;
import org.polymodel.polyhedralIR.polyIRCG.BasicCodeUnitHeader;
import org.polymodel.polyhedralIR.polyIRCG.BasicStatement;
import org.polymodel.polyhedralIR.polyIRCG.BasicVariable;
import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnitHeader;
import org.polymodel.polyhedralIR.polyIRCG.CompilationUnit;
import org.polymodel.polyhedralIR.polyIRCG.CompileTimeParameter;
import org.polymodel.polyhedralIR.polyIRCG.CustomPackStruct;
import org.polymodel.polyhedralIR.polyIRCG.CustomProviderStatement;
import org.polymodel.polyhedralIR.polyIRCG.DeclareStructs;
import org.polymodel.polyhedralIR.polyIRCG.FlagVariableReset;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.FunctionSignature;
import org.polymodel.polyhedralIR.polyIRCG.IdentityAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.Loop;
import org.polymodel.polyhedralIR.polyIRCG.MemoryAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.MemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.MergedDomainAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.MergedMemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.PackStruct;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGFactory;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;
import org.polymodel.polyhedralIR.polyIRCG.PseudoProjection;
import org.polymodel.polyhedralIR.polyIRCG.PseudoProjectiveAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.ScalarMemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.Statement;
import org.polymodel.polyhedralIR.polyIRCG.Struct;
import org.polymodel.polyhedralIR.polyIRCG.StructManagement;
import org.polymodel.polyhedralIR.polyIRCG.UnpackStruct;
import org.polymodel.polyhedralIR.polyIRCG.VariableFinalization;
import org.polymodel.polyhedralIR.polyIRCG.VariableFunctionParameter;
import org.polymodel.polyhedralIR.polyIRCG.VariableInitialization;
import org.polymodel.polyhedralIR.polyIRCG.C.CPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.CDistributedPackageImpl;
import org.polymodel.polyhedralIR.polyIRCG.C.impl.CPackageImpl;
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
import org.polymodel.scop.ScopPackage;
import org.polymodel.scop.cgenerator2.MacroBodyProvider;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PolyIRCGPackageImpl extends EPackageImpl implements PolyIRCGPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compilationUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass codeUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass codeUnitHeaderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicCodeUnitHeaderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass declareStructsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memoryDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scalarMemoryDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mergedMemoryDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pseudoProjectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bodyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicBodyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableInitializationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flagVariableResetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableFinalizationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structManagementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packStructEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customPackStructEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unpackStructEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionSignatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableFunctionParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass codeGenVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memoryAccessExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pseudoProjectiveAccessExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identityAccessExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mergedDomainAccessExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compileTimeParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customProviderStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType macroBodyProviderEDataType = null;

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
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PolyIRCGPackageImpl() {
		super(eNS_URI, PolyIRCGFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PolyIRCGPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PolyIRCGPackage init() {
		if (isInited) return (PolyIRCGPackage)EPackage.Registry.INSTANCE.getEPackage(PolyIRCGPackage.eNS_URI);

		// Obtain or create and register package
		PolyIRCGPackageImpl thePolyIRCGPackage = (PolyIRCGPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PolyIRCGPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PolyIRCGPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PolyhedralIRPackage.eINSTANCE.eClass();
		ScopPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CPackageImpl theCPackage = (CPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CPackage.eNS_URI) instanceof CPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CPackage.eNS_URI) : CPackage.eINSTANCE);
		CWrapperPackageImpl theCWrapperPackage = (CWrapperPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CWrapperPackage.eNS_URI) instanceof CWrapperPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CWrapperPackage.eNS_URI) : CWrapperPackage.eINSTANCE);
		CDistributedPackageImpl theCDistributedPackage = (CDistributedPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CDistributedPackage.eNS_URI) instanceof CDistributedPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CDistributedPackage.eNS_URI) : CDistributedPackage.eINSTANCE);
		ScanPackageImpl theScanPackage = (ScanPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ScanPackage.eNS_URI) instanceof ScanPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ScanPackage.eNS_URI) : ScanPackage.eINSTANCE);
		PcotPackageImpl thePcotPackage = (PcotPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PcotPackage.eNS_URI) instanceof PcotPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PcotPackage.eNS_URI) : PcotPackage.eINSTANCE);
		AlgebraExPackageImpl theAlgebraExPackage = (AlgebraExPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AlgebraExPackage.eNS_URI) instanceof AlgebraExPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AlgebraExPackage.eNS_URI) : AlgebraExPackage.eINSTANCE);
		SIMDPackageImpl theSIMDPackage = (SIMDPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SIMDPackage.eNS_URI) instanceof SIMDPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SIMDPackage.eNS_URI) : SIMDPackage.eINSTANCE);
		SimdExpPackageImpl theSimdExpPackage = (SimdExpPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SimdExpPackage.eNS_URI) instanceof SimdExpPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SimdExpPackage.eNS_URI) : SimdExpPackage.eINSTANCE);
		PCOTPackageImpl thePCOTPackage = (PCOTPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PCOTPackage.eNS_URI) instanceof PCOTPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PCOTPackage.eNS_URI) : PCOTPackage.eINSTANCE);

		// Create package meta-data objects
		thePolyIRCGPackage.createPackageContents();
		theCPackage.createPackageContents();
		theCWrapperPackage.createPackageContents();
		theCDistributedPackage.createPackageContents();
		theScanPackage.createPackageContents();
		thePcotPackage.createPackageContents();
		theAlgebraExPackage.createPackageContents();
		theSIMDPackage.createPackageContents();
		theSimdExpPackage.createPackageContents();
		thePCOTPackage.createPackageContents();

		// Initialize created meta-data
		thePolyIRCGPackage.initializePackageContents();
		theCPackage.initializePackageContents();
		theCWrapperPackage.initializePackageContents();
		theCDistributedPackage.initializePackageContents();
		theScanPackage.initializePackageContents();
		thePcotPackage.initializePackageContents();
		theAlgebraExPackage.initializePackageContents();
		theSIMDPackage.initializePackageContents();
		theSimdExpPackage.initializePackageContents();
		thePCOTPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePolyIRCGPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PolyIRCGPackage.eNS_URI, thePolyIRCGPackage);
		return thePolyIRCGPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompilationUnit() {
		return compilationUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompilationUnit_Program() {
		return (EReference)compilationUnitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompilationUnit_Units() {
		return (EReference)compilationUnitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCodeUnit() {
		return codeUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeUnit_System() {
		return (EReference)codeUnitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeUnit_Headers() {
		return (EReference)codeUnitEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeUnit_Functions() {
		return (EReference)codeUnitEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeUnit_Variables() {
		return (EReference)codeUnitEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeUnit_CompilationUnit() {
		return (EReference)codeUnitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeUnit_LocalParameters() {
		return (EReference)codeUnitEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeUnit_CompileTimeParameters() {
		return (EReference)codeUnitEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeUnit_SubsystemFunctions() {
		return (EReference)codeUnitEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCodeUnitHeader() {
		return codeUnitHeaderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicCodeUnitHeader() {
		return basicCodeUnitHeaderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasicCodeUnitHeader_String() {
		return (EAttribute)basicCodeUnitHeaderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeclareStructs() {
		return declareStructsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeclareStructs_Structs() {
		return (EReference)declareStructsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemoryDomain() {
		return memoryDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMemoryDomain_ZeroAligned() {
		return (EAttribute)memoryDomainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScalarMemoryDomain() {
		return scalarMemoryDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMergedMemoryDomain() {
		return mergedMemoryDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMergedMemoryDomain_MemoryDomains() {
		return (EReference)mergedMemoryDomainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPseudoProjection() {
		return pseudoProjectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPseudoProjection_Domain() {
		return (EReference)pseudoProjectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPseudoProjection_ModFactors() {
		return (EReference)pseudoProjectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBody() {
		return bodyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBody_Function() {
		return (EReference)bodyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicBody() {
		return basicBodyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasicBody_String() {
		return (EAttribute)basicBodyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableInitialization() {
		return variableInitializationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableInitialization_Inputs() {
		return (EReference)variableInitializationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableInitialization_Outputs() {
		return (EReference)variableInitializationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableInitialization_Locals() {
		return (EReference)variableInitializationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableInitialization_SpecialLocals() {
		return (EReference)variableInitializationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlagVariableReset() {
		return flagVariableResetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlagVariableReset_Outputs() {
		return (EReference)flagVariableResetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlagVariableReset_Locals() {
		return (EReference)flagVariableResetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlagVariableReset_SpecialLocals() {
		return (EReference)flagVariableResetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableFinalization() {
		return variableFinalizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableFinalization_Inputs() {
		return (EReference)variableFinalizationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableFinalization_Outputs() {
		return (EReference)variableFinalizationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableFinalization_Locals() {
		return (EReference)variableFinalizationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableFinalization_SpecialLocals() {
		return (EReference)variableFinalizationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructManagement() {
		return structManagementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructManagement_Instance() {
		return (EReference)structManagementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructManagement_Struct() {
		return (EReference)structManagementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackStruct() {
		return packStructEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomPackStruct() {
		return customPackStructEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomPackStruct_InitValues() {
		return (EAttribute)customPackStructEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnpackStruct() {
		return unpackStructEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoop() {
		return loopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoop_ParameterDomain() {
		return (EReference)loopEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoop_Statements() {
		return (EReference)loopEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoop_DeclareIterators() {
		return (EAttribute)loopEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoop_IteratorNames() {
		return (EAttribute)loopEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoop_NumConstantDimensions() {
		return (EAttribute)loopEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunction() {
		return functionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_Codeunit() {
		return (EReference)functionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunction_Name() {
		return (EAttribute)functionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunction_ReturnType() {
		return (EAttribute)functionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_Parameters() {
		return (EReference)functionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_Inputs() {
		return (EReference)functionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_Outputs() {
		return (EReference)functionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_Locals() {
		return (EReference)functionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_Bodies() {
		return (EReference)functionEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunction_EntryPoint() {
		return (EAttribute)functionEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_Signature() {
		return (EReference)functionEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunction_Inlined() {
		return (EAttribute)functionEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunction_NumberOfTimeIterationsForFirstConditionCheck() {
		return (EAttribute)functionEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_SpecialLocals() {
		return (EReference)functionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionSignature() {
		return functionSignatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunctionSignature_Name() {
		return (EAttribute)functionSignatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunctionSignature_ReturnType() {
		return (EAttribute)functionSignatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionSignature_Parameters() {
		return (EReference)functionSignatureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStruct() {
		return structEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStruct_Name() {
		return (EAttribute)structEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStruct_Members() {
		return (EReference)structEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableFunctionParameter() {
		return variableFunctionParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableFunctionParameter_Variable() {
		return (EReference)variableFunctionParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractVariable() {
		return abstractVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractVariable_Name() {
		return (EAttribute)abstractVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractVariable_Codeunit() {
		return (EReference)abstractVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractVariable_Global() {
		return (EAttribute)abstractVariableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicVariable() {
		return basicVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasicVariable_Type() {
		return (EAttribute)basicVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCodeGenVariable() {
		return codeGenVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeGenVariable_Type() {
		return (EReference)codeGenVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeGenVariable_Domain() {
		return (EReference)codeGenVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCodeGenVariable_Aligned() {
		return (EAttribute)codeGenVariableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCodeGenVariable_Flattened() {
		return (EAttribute)codeGenVariableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeGenVariable_AccessExpression() {
		return (EReference)codeGenVariableEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCodeGenVariable_Isfrontpadded() {
		return (EAttribute)codeGenVariableEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCodeGenVariable_ForntpaddingValue() {
		return (EAttribute)codeGenVariableEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStatement() {
		return statementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatement_Name() {
		return (EAttribute)statementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStatement_Domain() {
		return (EReference)statementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStatement_ContainerLoop() {
		return (EReference)statementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatement_Inlined() {
		return (EAttribute)statementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStatement_Scattering() {
		return (EReference)statementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicStatement() {
		return basicStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasicStatement_Statement() {
		return (EAttribute)basicStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemoryAccessExpression() {
		return memoryAccessExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMemoryAccessExpression_Variable() {
		return (EReference)memoryAccessExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPseudoProjectiveAccessExpression() {
		return pseudoProjectiveAccessExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentityAccessExpression() {
		return identityAccessExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMergedDomainAccessExpression() {
		return mergedDomainAccessExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMergedDomainAccessExpression_AccessExpression() {
		return (EReference)mergedDomainAccessExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMergedDomainAccessExpression_Identifier() {
		return (EAttribute)mergedDomainAccessExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompileTimeParameter() {
		return compileTimeParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompileTimeParameter_Name() {
		return (EAttribute)compileTimeParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompileTimeParameter_DefaultValue() {
		return (EAttribute)compileTimeParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomProviderStatement() {
		return customProviderStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomProviderStatement_Provider() {
		return (EAttribute)customProviderStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getMacroBodyProvider() {
		return macroBodyProviderEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolyIRCGFactory getPolyIRCGFactory() {
		return (PolyIRCGFactory)getEFactoryInstance();
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
		compilationUnitEClass = createEClass(COMPILATION_UNIT);
		createEReference(compilationUnitEClass, COMPILATION_UNIT__PROGRAM);
		createEReference(compilationUnitEClass, COMPILATION_UNIT__UNITS);

		codeUnitEClass = createEClass(CODE_UNIT);
		createEReference(codeUnitEClass, CODE_UNIT__COMPILATION_UNIT);
		createEReference(codeUnitEClass, CODE_UNIT__SYSTEM);
		createEReference(codeUnitEClass, CODE_UNIT__HEADERS);
		createEReference(codeUnitEClass, CODE_UNIT__FUNCTIONS);
		createEReference(codeUnitEClass, CODE_UNIT__VARIABLES);
		createEReference(codeUnitEClass, CODE_UNIT__LOCAL_PARAMETERS);
		createEReference(codeUnitEClass, CODE_UNIT__COMPILE_TIME_PARAMETERS);
		createEReference(codeUnitEClass, CODE_UNIT__SUBSYSTEM_FUNCTIONS);

		codeUnitHeaderEClass = createEClass(CODE_UNIT_HEADER);

		basicCodeUnitHeaderEClass = createEClass(BASIC_CODE_UNIT_HEADER);
		createEAttribute(basicCodeUnitHeaderEClass, BASIC_CODE_UNIT_HEADER__STRING);

		declareStructsEClass = createEClass(DECLARE_STRUCTS);
		createEReference(declareStructsEClass, DECLARE_STRUCTS__STRUCTS);

		functionEClass = createEClass(FUNCTION);
		createEReference(functionEClass, FUNCTION__CODEUNIT);
		createEAttribute(functionEClass, FUNCTION__NAME);
		createEAttribute(functionEClass, FUNCTION__RETURN_TYPE);
		createEReference(functionEClass, FUNCTION__PARAMETERS);
		createEReference(functionEClass, FUNCTION__INPUTS);
		createEReference(functionEClass, FUNCTION__OUTPUTS);
		createEReference(functionEClass, FUNCTION__LOCALS);
		createEReference(functionEClass, FUNCTION__SPECIAL_LOCALS);
		createEReference(functionEClass, FUNCTION__BODIES);
		createEAttribute(functionEClass, FUNCTION__ENTRY_POINT);
		createEAttribute(functionEClass, FUNCTION__INLINED);
		createEAttribute(functionEClass, FUNCTION__NUMBER_OF_TIME_ITERATIONS_FOR_FIRST_CONDITION_CHECK);
		createEReference(functionEClass, FUNCTION__SIGNATURE);

		functionSignatureEClass = createEClass(FUNCTION_SIGNATURE);
		createEAttribute(functionSignatureEClass, FUNCTION_SIGNATURE__NAME);
		createEAttribute(functionSignatureEClass, FUNCTION_SIGNATURE__RETURN_TYPE);
		createEReference(functionSignatureEClass, FUNCTION_SIGNATURE__PARAMETERS);

		structEClass = createEClass(STRUCT);
		createEAttribute(structEClass, STRUCT__NAME);
		createEReference(structEClass, STRUCT__MEMBERS);

		variableFunctionParameterEClass = createEClass(VARIABLE_FUNCTION_PARAMETER);
		createEReference(variableFunctionParameterEClass, VARIABLE_FUNCTION_PARAMETER__VARIABLE);

		abstractVariableEClass = createEClass(ABSTRACT_VARIABLE);
		createEAttribute(abstractVariableEClass, ABSTRACT_VARIABLE__NAME);
		createEReference(abstractVariableEClass, ABSTRACT_VARIABLE__CODEUNIT);
		createEAttribute(abstractVariableEClass, ABSTRACT_VARIABLE__GLOBAL);

		basicVariableEClass = createEClass(BASIC_VARIABLE);
		createEAttribute(basicVariableEClass, BASIC_VARIABLE__TYPE);

		codeGenVariableEClass = createEClass(CODE_GEN_VARIABLE);
		createEReference(codeGenVariableEClass, CODE_GEN_VARIABLE__TYPE);
		createEReference(codeGenVariableEClass, CODE_GEN_VARIABLE__DOMAIN);
		createEAttribute(codeGenVariableEClass, CODE_GEN_VARIABLE__ALIGNED);
		createEAttribute(codeGenVariableEClass, CODE_GEN_VARIABLE__FLATTENED);
		createEReference(codeGenVariableEClass, CODE_GEN_VARIABLE__ACCESS_EXPRESSION);
		createEAttribute(codeGenVariableEClass, CODE_GEN_VARIABLE__ISFRONTPADDED);
		createEAttribute(codeGenVariableEClass, CODE_GEN_VARIABLE__FORNTPADDING_VALUE);

		memoryDomainEClass = createEClass(MEMORY_DOMAIN);
		createEAttribute(memoryDomainEClass, MEMORY_DOMAIN__ZERO_ALIGNED);

		scalarMemoryDomainEClass = createEClass(SCALAR_MEMORY_DOMAIN);

		mergedMemoryDomainEClass = createEClass(MERGED_MEMORY_DOMAIN);
		createEReference(mergedMemoryDomainEClass, MERGED_MEMORY_DOMAIN__MEMORY_DOMAINS);

		pseudoProjectionEClass = createEClass(PSEUDO_PROJECTION);
		createEReference(pseudoProjectionEClass, PSEUDO_PROJECTION__DOMAIN);
		createEReference(pseudoProjectionEClass, PSEUDO_PROJECTION__MOD_FACTORS);

		bodyEClass = createEClass(BODY);
		createEReference(bodyEClass, BODY__FUNCTION);

		basicBodyEClass = createEClass(BASIC_BODY);
		createEAttribute(basicBodyEClass, BASIC_BODY__STRING);

		variableInitializationEClass = createEClass(VARIABLE_INITIALIZATION);
		createEReference(variableInitializationEClass, VARIABLE_INITIALIZATION__INPUTS);
		createEReference(variableInitializationEClass, VARIABLE_INITIALIZATION__OUTPUTS);
		createEReference(variableInitializationEClass, VARIABLE_INITIALIZATION__LOCALS);
		createEReference(variableInitializationEClass, VARIABLE_INITIALIZATION__SPECIAL_LOCALS);

		flagVariableResetEClass = createEClass(FLAG_VARIABLE_RESET);
		createEReference(flagVariableResetEClass, FLAG_VARIABLE_RESET__OUTPUTS);
		createEReference(flagVariableResetEClass, FLAG_VARIABLE_RESET__LOCALS);
		createEReference(flagVariableResetEClass, FLAG_VARIABLE_RESET__SPECIAL_LOCALS);

		variableFinalizationEClass = createEClass(VARIABLE_FINALIZATION);
		createEReference(variableFinalizationEClass, VARIABLE_FINALIZATION__INPUTS);
		createEReference(variableFinalizationEClass, VARIABLE_FINALIZATION__OUTPUTS);
		createEReference(variableFinalizationEClass, VARIABLE_FINALIZATION__LOCALS);
		createEReference(variableFinalizationEClass, VARIABLE_FINALIZATION__SPECIAL_LOCALS);

		structManagementEClass = createEClass(STRUCT_MANAGEMENT);
		createEReference(structManagementEClass, STRUCT_MANAGEMENT__INSTANCE);
		createEReference(structManagementEClass, STRUCT_MANAGEMENT__STRUCT);

		packStructEClass = createEClass(PACK_STRUCT);

		customPackStructEClass = createEClass(CUSTOM_PACK_STRUCT);
		createEAttribute(customPackStructEClass, CUSTOM_PACK_STRUCT__INIT_VALUES);

		unpackStructEClass = createEClass(UNPACK_STRUCT);

		loopEClass = createEClass(LOOP);
		createEReference(loopEClass, LOOP__PARAMETER_DOMAIN);
		createEReference(loopEClass, LOOP__STATEMENTS);
		createEAttribute(loopEClass, LOOP__DECLARE_ITERATORS);
		createEAttribute(loopEClass, LOOP__ITERATOR_NAMES);
		createEAttribute(loopEClass, LOOP__NUM_CONSTANT_DIMENSIONS);

		statementEClass = createEClass(STATEMENT);
		createEAttribute(statementEClass, STATEMENT__NAME);
		createEReference(statementEClass, STATEMENT__DOMAIN);
		createEReference(statementEClass, STATEMENT__CONTAINER_LOOP);
		createEAttribute(statementEClass, STATEMENT__INLINED);
		createEReference(statementEClass, STATEMENT__SCATTERING);

		basicStatementEClass = createEClass(BASIC_STATEMENT);
		createEAttribute(basicStatementEClass, BASIC_STATEMENT__STATEMENT);

		memoryAccessExpressionEClass = createEClass(MEMORY_ACCESS_EXPRESSION);
		createEReference(memoryAccessExpressionEClass, MEMORY_ACCESS_EXPRESSION__VARIABLE);

		pseudoProjectiveAccessExpressionEClass = createEClass(PSEUDO_PROJECTIVE_ACCESS_EXPRESSION);

		identityAccessExpressionEClass = createEClass(IDENTITY_ACCESS_EXPRESSION);

		mergedDomainAccessExpressionEClass = createEClass(MERGED_DOMAIN_ACCESS_EXPRESSION);
		createEReference(mergedDomainAccessExpressionEClass, MERGED_DOMAIN_ACCESS_EXPRESSION__ACCESS_EXPRESSION);
		createEAttribute(mergedDomainAccessExpressionEClass, MERGED_DOMAIN_ACCESS_EXPRESSION__IDENTIFIER);

		compileTimeParameterEClass = createEClass(COMPILE_TIME_PARAMETER);
		createEAttribute(compileTimeParameterEClass, COMPILE_TIME_PARAMETER__NAME);
		createEAttribute(compileTimeParameterEClass, COMPILE_TIME_PARAMETER__DEFAULT_VALUE);

		customProviderStatementEClass = createEClass(CUSTOM_PROVIDER_STATEMENT);
		createEAttribute(customProviderStatementEClass, CUSTOM_PROVIDER_STATEMENT__PROVIDER);

		// Create data types
		macroBodyProviderEDataType = createEDataType(MACRO_BODY_PROVIDER);
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
		CPackage theCPackage = (CPackage)EPackage.Registry.INSTANCE.getEPackage(CPackage.eNS_URI);
		AlgebraExPackage theAlgebraExPackage = (AlgebraExPackage)EPackage.Registry.INSTANCE.getEPackage(AlgebraExPackage.eNS_URI);
		SIMDPackage theSIMDPackage = (SIMDPackage)EPackage.Registry.INSTANCE.getEPackage(SIMDPackage.eNS_URI);
		PCOTPackage thePCOTPackage = (PCOTPackage)EPackage.Registry.INSTANCE.getEPackage(PCOTPackage.eNS_URI);
		PolyhedralIRPackage thePolyhedralIRPackage = (PolyhedralIRPackage)EPackage.Registry.INSTANCE.getEPackage(PolyhedralIRPackage.eNS_URI);
		AlgebraPackage theAlgebraPackage = (AlgebraPackage)EPackage.Registry.INSTANCE.getEPackage(AlgebraPackage.eNS_URI);
		PolymodelPackage thePolymodelPackage = (PolymodelPackage)EPackage.Registry.INSTANCE.getEPackage(PolymodelPackage.eNS_URI);
		ScopPackage theScopPackage = (ScopPackage)EPackage.Registry.INSTANCE.getEPackage(ScopPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theCPackage);
		getESubpackages().add(theAlgebraExPackage);
		getESubpackages().add(theSIMDPackage);
		getESubpackages().add(thePCOTPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		basicCodeUnitHeaderEClass.getESuperTypes().add(this.getCodeUnitHeader());
		declareStructsEClass.getESuperTypes().add(this.getCodeUnitHeader());
		basicVariableEClass.getESuperTypes().add(this.getAbstractVariable());
		codeGenVariableEClass.getESuperTypes().add(this.getAbstractVariable());
		scalarMemoryDomainEClass.getESuperTypes().add(this.getMemoryDomain());
		mergedMemoryDomainEClass.getESuperTypes().add(this.getMemoryDomain());
		pseudoProjectionEClass.getESuperTypes().add(this.getMemoryDomain());
		basicBodyEClass.getESuperTypes().add(this.getBody());
		variableInitializationEClass.getESuperTypes().add(this.getBody());
		flagVariableResetEClass.getESuperTypes().add(this.getBody());
		variableFinalizationEClass.getESuperTypes().add(this.getBody());
		structManagementEClass.getESuperTypes().add(this.getBody());
		packStructEClass.getESuperTypes().add(this.getStructManagement());
		customPackStructEClass.getESuperTypes().add(this.getStructManagement());
		unpackStructEClass.getESuperTypes().add(this.getStructManagement());
		loopEClass.getESuperTypes().add(this.getBody());
		basicStatementEClass.getESuperTypes().add(this.getStatement());
		pseudoProjectiveAccessExpressionEClass.getESuperTypes().add(this.getMemoryAccessExpression());
		identityAccessExpressionEClass.getESuperTypes().add(this.getMemoryAccessExpression());
		mergedDomainAccessExpressionEClass.getESuperTypes().add(this.getMemoryAccessExpression());
		customProviderStatementEClass.getESuperTypes().add(this.getStatement());

		// Initialize classes and features; add operations and parameters
		initEClass(compilationUnitEClass, CompilationUnit.class, "CompilationUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompilationUnit_Program(), thePolyhedralIRPackage.getProgram(), null, "program", null, 0, 1, CompilationUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompilationUnit_Units(), this.getCodeUnit(), this.getCodeUnit_CompilationUnit(), "units", null, 0, -1, CompilationUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(codeUnitEClass, CodeUnit.class, "CodeUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCodeUnit_CompilationUnit(), this.getCompilationUnit(), this.getCompilationUnit_Units(), "compilationUnit", null, 0, 1, CodeUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodeUnit_System(), thePolyhedralIRPackage.getAffineSystem(), null, "system", null, 0, 1, CodeUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodeUnit_Headers(), this.getCodeUnitHeader(), null, "headers", null, 0, -1, CodeUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodeUnit_Functions(), this.getFunction(), this.getFunction_Codeunit(), "functions", null, 0, -1, CodeUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodeUnit_Variables(), this.getAbstractVariable(), this.getAbstractVariable_Codeunit(), "variables", null, 0, -1, CodeUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodeUnit_LocalParameters(), theAlgebraPackage.getVariable(), null, "localParameters", null, 0, -1, CodeUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodeUnit_CompileTimeParameters(), this.getCompileTimeParameter(), null, "compileTimeParameters", null, 0, -1, CodeUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodeUnit_SubsystemFunctions(), this.getFunctionSignature(), null, "subsystemFunctions", null, 0, -1, CodeUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(codeUnitEClass, this.getAbstractVariable(), "findVariable", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(codeUnitEClass, this.getCodeGenVariable(), "findCGVariable", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(codeUnitHeaderEClass, CodeUnitHeader.class, "CodeUnitHeader", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(basicCodeUnitHeaderEClass, BasicCodeUnitHeader.class, "BasicCodeUnitHeader", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBasicCodeUnitHeader_String(), ecorePackage.getEString(), "string", null, 1, 1, BasicCodeUnitHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(declareStructsEClass, DeclareStructs.class, "DeclareStructs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeclareStructs_Structs(), this.getStruct(), null, "structs", null, 0, -1, DeclareStructs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionEClass, Function.class, "Function", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunction_Codeunit(), this.getCodeUnit(), this.getCodeUnit_Functions(), "codeunit", null, 0, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFunction_Name(), ecorePackage.getEString(), "name", null, 1, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFunction_ReturnType(), ecorePackage.getEString(), "returnType", null, 1, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunction_Parameters(), this.getAbstractVariable(), null, "parameters", null, 0, -1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunction_Inputs(), this.getAbstractVariable(), null, "inputs", null, 0, -1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunction_Outputs(), this.getAbstractVariable(), null, "outputs", null, 0, -1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunction_Locals(), this.getAbstractVariable(), null, "locals", null, 0, -1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunction_SpecialLocals(), this.getCodeGenVariable(), null, "specialLocals", null, 0, -1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunction_Bodies(), this.getBody(), this.getBody_Function(), "bodies", null, 0, -1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFunction_EntryPoint(), ecorePackage.getEBoolean(), "entryPoint", "false", 1, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFunction_Inlined(), ecorePackage.getEBoolean(), "inlined", null, 1, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFunction_NumberOfTimeIterationsForFirstConditionCheck(), ecorePackage.getEString(), "numberOfTimeIterationsForFirstConditionCheck", null, 0, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunction_Signature(), this.getFunctionSignature(), null, "signature", null, 0, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(functionEClass, this.getFunctionSignature(), "getDefaultFunctionSignature", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "includeSystemParams", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(functionSignatureEClass, FunctionSignature.class, "FunctionSignature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFunctionSignature_Name(), ecorePackage.getEString(), "name", null, 1, 1, FunctionSignature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFunctionSignature_ReturnType(), ecorePackage.getEString(), "returnType", null, 0, 1, FunctionSignature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionSignature_Parameters(), this.getAbstractVariable(), null, "parameters", null, 0, -1, FunctionSignature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structEClass, Struct.class, "Struct", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStruct_Name(), ecorePackage.getEString(), "name", null, 0, 1, Struct.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStruct_Members(), this.getAbstractVariable(), null, "members", null, 0, -1, Struct.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableFunctionParameterEClass, VariableFunctionParameter.class, "VariableFunctionParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableFunctionParameter_Variable(), this.getCodeGenVariable(), null, "variable", null, 0, 1, VariableFunctionParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractVariableEClass, AbstractVariable.class, "AbstractVariable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractVariable_Name(), ecorePackage.getEString(), "name", null, 1, 1, AbstractVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractVariable_Codeunit(), this.getCodeUnit(), this.getCodeUnit_Variables(), "codeunit", null, 1, 1, AbstractVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractVariable_Global(), ecorePackage.getEBoolean(), "global", "false", 1, 1, AbstractVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(abstractVariableEClass, ecorePackage.getEString(), "getTypeString", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(abstractVariableEClass, ecorePackage.getEString(), "asParameter", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(abstractVariableEClass, ecorePackage.getEString(), "asParameterType", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(abstractVariableEClass, ecorePackage.getEString(), "getPointerType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(abstractVariableEClass, ecorePackage.getEString(), "getPrintfSpecifier", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(basicVariableEClass, BasicVariable.class, "BasicVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBasicVariable_Type(), ecorePackage.getEString(), "type", null, 0, 1, BasicVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(codeGenVariableEClass, CodeGenVariable.class, "CodeGenVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCodeGenVariable_Type(), thePolyhedralIRPackage.getType(), null, "type", null, 0, 1, CodeGenVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodeGenVariable_Domain(), this.getMemoryDomain(), null, "domain", null, 0, 1, CodeGenVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeGenVariable_Aligned(), ecorePackage.getEBoolean(), "aligned", null, 1, 1, CodeGenVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeGenVariable_Flattened(), ecorePackage.getEBoolean(), "flattened", "false", 1, 1, CodeGenVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodeGenVariable_AccessExpression(), this.getMemoryAccessExpression(), null, "accessExpression", null, 1, 1, CodeGenVariable.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeGenVariable_Isfrontpadded(), ecorePackage.getEBoolean(), "isfrontpadded", null, 1, 1, CodeGenVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeGenVariable_ForntpaddingValue(), ecorePackage.getEInt(), "forntpaddingValue", null, 0, -1, CodeGenVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(codeGenVariableEClass, ecorePackage.getEString(), "getMPITypeString", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(codeGenVariableEClass, theAlgebraPackage.getIntExpression(), "getVolumeExpression", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "startingDim", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "endingDim", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(codeGenVariableEClass, theAlgebraPackage.getIntExpression(), "getModFactor", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "dim", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(memoryDomainEClass, MemoryDomain.class, "MemoryDomain", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMemoryDomain_ZeroAligned(), ecorePackage.getEBoolean(), "zeroAligned", "true", 1, 1, MemoryDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(memoryDomainEClass, ecorePackage.getEInt(), "getDim", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(memoryDomainEClass, ecorePackage.getEInt(), "getNParams", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(memoryDomainEClass, ecorePackage.getEInt(), "getNIndices", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(memoryDomainEClass, theAlgebraPackage.getVariable(), "getParams", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(memoryDomainEClass, theAlgebraPackage.getVariable(), "getIndices", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(memoryDomainEClass, theAlgebraPackage.getIntExpression(), "getBounds", 2, 2, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "dim", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(memoryDomainEClass, theAlgebraPackage.getIntExpression(), "getVolumeExpression", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "startingDim", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "endingDim", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(scalarMemoryDomainEClass, ScalarMemoryDomain.class, "ScalarMemoryDomain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mergedMemoryDomainEClass, MergedMemoryDomain.class, "MergedMemoryDomain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		EGenericType g1 = createEGenericType(thePolymodelPackage.getValueContainedMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getMemoryDomain());
		g1.getETypeArguments().add(g2);
		initEReference(getMergedMemoryDomain_MemoryDomains(), g1, null, "memoryDomains", null, 0, -1, MergedMemoryDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pseudoProjectionEClass, PseudoProjection.class, "PseudoProjection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPseudoProjection_Domain(), thePolyhedralIRPackage.getDomain(), null, "domain", null, 1, 1, PseudoProjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPseudoProjection_ModFactors(), theAlgebraPackage.getIntExpression(), null, "modFactors", null, 0, -1, PseudoProjection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bodyEClass, Body.class, "Body", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBody_Function(), this.getFunction(), this.getFunction_Bodies(), "function", null, 0, 1, Body.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(basicBodyEClass, BasicBody.class, "BasicBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBasicBody_String(), ecorePackage.getEString(), "string", null, 1, 1, BasicBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableInitializationEClass, VariableInitialization.class, "VariableInitialization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableInitialization_Inputs(), this.getAbstractVariable(), null, "inputs", null, 0, -1, VariableInitialization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableInitialization_Outputs(), this.getAbstractVariable(), null, "outputs", null, 0, -1, VariableInitialization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableInitialization_Locals(), this.getAbstractVariable(), null, "locals", null, 0, -1, VariableInitialization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableInitialization_SpecialLocals(), this.getCodeGenVariable(), null, "specialLocals", null, 0, -1, VariableInitialization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(flagVariableResetEClass, FlagVariableReset.class, "FlagVariableReset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFlagVariableReset_Outputs(), this.getAbstractVariable(), null, "outputs", null, 0, -1, FlagVariableReset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFlagVariableReset_Locals(), this.getAbstractVariable(), null, "locals", null, 0, -1, FlagVariableReset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFlagVariableReset_SpecialLocals(), this.getCodeGenVariable(), null, "specialLocals", null, 0, -1, FlagVariableReset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableFinalizationEClass, VariableFinalization.class, "VariableFinalization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableFinalization_Inputs(), this.getAbstractVariable(), null, "inputs", null, 0, -1, VariableFinalization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableFinalization_Outputs(), this.getAbstractVariable(), null, "outputs", null, 0, -1, VariableFinalization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableFinalization_Locals(), this.getAbstractVariable(), null, "locals", null, 0, -1, VariableFinalization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableFinalization_SpecialLocals(), this.getCodeGenVariable(), null, "specialLocals", null, 0, -1, VariableFinalization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structManagementEClass, StructManagement.class, "StructManagement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructManagement_Instance(), this.getAbstractVariable(), null, "instance", null, 0, 1, StructManagement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructManagement_Struct(), this.getStruct(), null, "struct", null, 0, 1, StructManagement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(packStructEClass, PackStruct.class, "PackStruct", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(customPackStructEClass, CustomPackStruct.class, "CustomPackStruct", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		initEAttribute(getCustomPackStruct_InitValues(), g1, "initValues", null, 0, 1, CustomPackStruct.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unpackStructEClass, UnpackStruct.class, "UnpackStruct", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(loopEClass, Loop.class, "Loop", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLoop_ParameterDomain(), thePolyhedralIRPackage.getParameterDomain(), null, "parameterDomain", null, 1, 1, Loop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoop_Statements(), this.getStatement(), this.getStatement_ContainerLoop(), "statements", null, 0, -1, Loop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLoop_DeclareIterators(), ecorePackage.getEBoolean(), "declareIterators", "true", 1, 1, Loop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLoop_IteratorNames(), ecorePackage.getEString(), "iteratorNames", null, 0, -1, Loop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLoop_NumConstantDimensions(), ecorePackage.getEInt(), "numConstantDimensions", "0", 1, 1, Loop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(loopEClass, ecorePackage.getEInt(), "getMaxDimension", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(loopEClass, theScopPackage.getScopRoot(), "generateScop", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(statementEClass, Statement.class, "Statement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStatement_Name(), ecorePackage.getEString(), "name", null, 1, 1, Statement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStatement_Domain(), thePolyhedralIRPackage.getDomain(), null, "domain", null, 1, 1, Statement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStatement_ContainerLoop(), this.getLoop(), this.getLoop_Statements(), "containerLoop", null, 1, 1, Statement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatement_Inlined(), ecorePackage.getEBoolean(), "inlined", null, 1, 1, Statement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStatement_Scattering(), thePolyhedralIRPackage.getAffineFunction(), null, "scattering", null, 0, 1, Statement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(statementEClass, this.getMacroBodyProvider(), "getMacroBodyProvider", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(basicStatementEClass, BasicStatement.class, "BasicStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBasicStatement_Statement(), ecorePackage.getEString(), "statement", null, 1, 1, BasicStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(memoryAccessExpressionEClass, MemoryAccessExpression.class, "MemoryAccessExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMemoryAccessExpression_Variable(), this.getCodeGenVariable(), null, "variable", null, 1, 1, MemoryAccessExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(memoryAccessExpressionEClass, theAlgebraPackage.getIntExpression(), "getIndexingExpression", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "dim", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(memoryAccessExpressionEClass, theAlgebraPackage.getIntExpression(), "getVolumeExpression", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "dim", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(memoryAccessExpressionEClass, theAlgebraPackage.getIntExpression(), "getAccessExpressions", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(pseudoProjectiveAccessExpressionEClass, PseudoProjectiveAccessExpression.class, "PseudoProjectiveAccessExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(identityAccessExpressionEClass, IdentityAccessExpression.class, "IdentityAccessExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mergedDomainAccessExpressionEClass, MergedDomainAccessExpression.class, "MergedDomainAccessExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMergedDomainAccessExpression_AccessExpression(), this.getMemoryAccessExpression(), null, "accessExpression", null, 1, 1, MergedDomainAccessExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMergedDomainAccessExpression_Identifier(), ecorePackage.getEString(), "identifier", null, 1, 1, MergedDomainAccessExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compileTimeParameterEClass, CompileTimeParameter.class, "CompileTimeParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompileTimeParameter_Name(), ecorePackage.getEString(), "name", null, 1, 1, CompileTimeParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompileTimeParameter_DefaultValue(), ecorePackage.getEString(), "defaultValue", null, 1, 1, CompileTimeParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(customProviderStatementEClass, CustomProviderStatement.class, "CustomProviderStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCustomProviderStatement_Provider(), this.getMacroBodyProvider(), "provider", null, 1, 1, CustomProviderStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(macroBodyProviderEDataType, MacroBodyProvider.class, "MacroBodyProvider", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //PolyIRCGPackageImpl
