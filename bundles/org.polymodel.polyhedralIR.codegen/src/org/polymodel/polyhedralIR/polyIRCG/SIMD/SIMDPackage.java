/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.CPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDFactory
 * @model kind="package"
 * @generated
 */
public interface SIMDPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "SIMD";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "SIMD";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "SIMD";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SIMDPackage eINSTANCE = org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.VTypeImpl <em>VType</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.VTypeImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDPackageImpl#getVType()
	 * @generated
	 */
	int VTYPE = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VTYPE__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VTYPE__WIDTH = 1;

	/**
	 * The feature id for the '<em><b>Ins</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VTYPE__INS = 2;

	/**
	 * The number of structural features of the '<em>VType</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VTYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.VRegisterImpl <em>VRegister</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.VRegisterImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDPackageImpl#getVRegister()
	 * @generated
	 */
	int VREGISTER = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VREGISTER__NAME = PolyIRCGPackage.ABSTRACT_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Codeunit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VREGISTER__CODEUNIT = PolyIRCGPackage.ABSTRACT_VARIABLE__CODEUNIT;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VREGISTER__GLOBAL = PolyIRCGPackage.ABSTRACT_VARIABLE__GLOBAL;

	/**
	 * The feature id for the '<em><b>Vtype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VREGISTER__VTYPE = PolyIRCGPackage.ABSTRACT_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VREGISTER__FUNCTION = PolyIRCGPackage.ABSTRACT_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>VRegister</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VREGISTER_FEATURE_COUNT = PolyIRCGPackage.ABSTRACT_VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.VRegisterInitializationImpl <em>VRegister Initialization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.VRegisterInitializationImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDPackageImpl#getVRegisterInitialization()
	 * @generated
	 */
	int VREGISTER_INITIALIZATION = 2;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VREGISTER_INITIALIZATION__FUNCTION = PolyIRCGPackage.BODY__FUNCTION;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VREGISTER_INITIALIZATION__INPUTS = PolyIRCGPackage.BODY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Locals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VREGISTER_INITIALIZATION__LOCALS = PolyIRCGPackage.BODY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VREGISTER_INITIALIZATION__OUTPUTS = PolyIRCGPackage.BODY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>VRegister Initialization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VREGISTER_INITIALIZATION_FEATURE_COUNT = PolyIRCGPackage.BODY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDStatementImpl <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDStatementImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDPackageImpl#getSIMDStatement()
	 * @generated
	 */
	int SIMD_STATEMENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_STATEMENT__NAME = PolyIRCGPackage.STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_STATEMENT__DOMAIN = PolyIRCGPackage.STATEMENT__DOMAIN;

	/**
	 * The feature id for the '<em><b>Container Loop</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_STATEMENT__CONTAINER_LOOP = PolyIRCGPackage.STATEMENT__CONTAINER_LOOP;

	/**
	 * The feature id for the '<em><b>Inlined</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_STATEMENT__INLINED = PolyIRCGPackage.STATEMENT__INLINED;

	/**
	 * The feature id for the '<em><b>Scattering</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_STATEMENT__SCATTERING = PolyIRCGPackage.STATEMENT__SCATTERING;

	/**
	 * The feature id for the '<em><b>Simd Exp</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_STATEMENT__SIMD_EXP = PolyIRCGPackage.STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_STATEMENT_FEATURE_COUNT = PolyIRCGPackage.STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.VRegFunctionParameterImpl <em>VReg Function Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.VRegFunctionParameterImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDPackageImpl#getVRegFunctionParameter()
	 * @generated
	 */
	int VREG_FUNCTION_PARAMETER = 4;

	/**
	 * The feature id for the '<em><b>Register</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VREG_FUNCTION_PARAMETER__REGISTER = 0;

	/**
	 * The number of structural features of the '<em>VReg Function Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VREG_FUNCTION_PARAMETER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDFunctionImpl <em>Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDFunctionImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDPackageImpl#getSIMDFunction()
	 * @generated
	 */
	int SIMD_FUNCTION = 5;

	/**
	 * The feature id for the '<em><b>Codeunit</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_FUNCTION__CODEUNIT = PolyIRCGPackage.FUNCTION__CODEUNIT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_FUNCTION__NAME = PolyIRCGPackage.FUNCTION__NAME;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_FUNCTION__RETURN_TYPE = PolyIRCGPackage.FUNCTION__RETURN_TYPE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_FUNCTION__PARAMETERS = PolyIRCGPackage.FUNCTION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_FUNCTION__INPUTS = PolyIRCGPackage.FUNCTION__INPUTS;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_FUNCTION__OUTPUTS = PolyIRCGPackage.FUNCTION__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Locals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_FUNCTION__LOCALS = PolyIRCGPackage.FUNCTION__LOCALS;

	/**
	 * The feature id for the '<em><b>Special Locals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_FUNCTION__SPECIAL_LOCALS = PolyIRCGPackage.FUNCTION__SPECIAL_LOCALS;

	/**
	 * The feature id for the '<em><b>Bodies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_FUNCTION__BODIES = PolyIRCGPackage.FUNCTION__BODIES;

	/**
	 * The feature id for the '<em><b>Entry Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_FUNCTION__ENTRY_POINT = PolyIRCGPackage.FUNCTION__ENTRY_POINT;

	/**
	 * The feature id for the '<em><b>Inlined</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_FUNCTION__INLINED = PolyIRCGPackage.FUNCTION__INLINED;

	/**
	 * The feature id for the '<em><b>Number Of Time Iterations For First Condition Check</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_FUNCTION__NUMBER_OF_TIME_ITERATIONS_FOR_FIRST_CONDITION_CHECK = PolyIRCGPackage.FUNCTION__NUMBER_OF_TIME_ITERATIONS_FOR_FIRST_CONDITION_CHECK;

	/**
	 * The feature id for the '<em><b>Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_FUNCTION__SIGNATURE = PolyIRCGPackage.FUNCTION__SIGNATURE;

	/**
	 * The feature id for the '<em><b>Inputsimd Regs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_FUNCTION__INPUTSIMD_REGS = PolyIRCGPackage.FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outputsimd Regs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_FUNCTION__OUTPUTSIMD_REGS = PolyIRCGPackage.FUNCTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Localsimd Regs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_FUNCTION__LOCALSIMD_REGS = PolyIRCGPackage.FUNCTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_FUNCTION_FEATURE_COUNT = PolyIRCGPackage.FUNCTION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDCLoopImpl <em>CLoop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDCLoopImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDPackageImpl#getSIMDCLoop()
	 * @generated
	 */
	int SIMD_CLOOP = 6;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_CLOOP__FUNCTION = CPackage.CLOOP__FUNCTION;

	/**
	 * The feature id for the '<em><b>Parameter Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_CLOOP__PARAMETER_DOMAIN = CPackage.CLOOP__PARAMETER_DOMAIN;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_CLOOP__STATEMENTS = CPackage.CLOOP__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Declare Iterators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_CLOOP__DECLARE_ITERATORS = CPackage.CLOOP__DECLARE_ITERATORS;

	/**
	 * The feature id for the '<em><b>Iterator Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_CLOOP__ITERATOR_NAMES = CPackage.CLOOP__ITERATOR_NAMES;

	/**
	 * The feature id for the '<em><b>Num Constant Dimensions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_CLOOP__NUM_CONSTANT_DIMENSIONS = CPackage.CLOOP__NUM_CONSTANT_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Use Macros</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_CLOOP__USE_MACROS = CPackage.CLOOP__USE_MACROS;

	/**
	 * The feature id for the '<em><b>Simd Statements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_CLOOP__SIMD_STATEMENTS = CPackage.CLOOP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CLoop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMD_CLOOP_FEATURE_COUNT = CPackage.CLOOP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.TiledSIMDCLoopImpl <em>Tiled SIMDC Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.TiledSIMDCLoopImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDPackageImpl#getTiledSIMDCLoop()
	 * @generated
	 */
	int TILED_SIMDC_LOOP = 7;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILED_SIMDC_LOOP__FUNCTION = CPackage.TILED_CLOOP__FUNCTION;

	/**
	 * The feature id for the '<em><b>Parameter Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILED_SIMDC_LOOP__PARAMETER_DOMAIN = CPackage.TILED_CLOOP__PARAMETER_DOMAIN;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILED_SIMDC_LOOP__STATEMENTS = CPackage.TILED_CLOOP__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Declare Iterators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILED_SIMDC_LOOP__DECLARE_ITERATORS = CPackage.TILED_CLOOP__DECLARE_ITERATORS;

	/**
	 * The feature id for the '<em><b>Iterator Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILED_SIMDC_LOOP__ITERATOR_NAMES = CPackage.TILED_CLOOP__ITERATOR_NAMES;

	/**
	 * The feature id for the '<em><b>Num Constant Dimensions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILED_SIMDC_LOOP__NUM_CONSTANT_DIMENSIONS = CPackage.TILED_CLOOP__NUM_CONSTANT_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Use Macros</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILED_SIMDC_LOOP__USE_MACROS = CPackage.TILED_CLOOP__USE_MACROS;

	/**
	 * The feature id for the '<em><b>Optimize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILED_SIMDC_LOOP__OPTIMIZE = CPackage.TILED_CLOOP__OPTIMIZE;

	/**
	 * The feature id for the '<em><b>Tiles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILED_SIMDC_LOOP__TILES = CPackage.TILED_CLOOP__TILES;

	/**
	 * The feature id for the '<em><b>Ordering Dimensions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILED_SIMDC_LOOP__ORDERING_DIMENSIONS = CPackage.TILED_CLOOP__ORDERING_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Optimized Point Loop</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILED_SIMDC_LOOP__OPTIMIZED_POINT_LOOP = CPackage.TILED_CLOOP__OPTIMIZED_POINT_LOOP;

	/**
	 * The feature id for the '<em><b>Simd Statements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILED_SIMDC_LOOP__SIMD_STATEMENTS = CPackage.TILED_CLOOP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tiled SIMDC Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILED_SIMDC_LOOP_FEATURE_COUNT = CPackage.TILED_CLOOP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_WIDTH <em>SIMD WIDTH</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_WIDTH
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDPackageImpl#getSIMD_WIDTH()
	 * @generated
	 */
	int SIMD_WIDTH = 8;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_INS <em>SIMD INS</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_INS
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDPackageImpl#getSIMD_INS()
	 * @generated
	 */
	int SIMD_INS = 9;


	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VType <em>VType</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VType</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.VType
	 * @generated
	 */
	EClass getVType();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.VType#getType()
	 * @see #getVType()
	 * @generated
	 */
	EReference getVType_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VType#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.VType#getWidth()
	 * @see #getVType()
	 * @generated
	 */
	EAttribute getVType_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VType#getIns <em>Ins</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ins</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.VType#getIns()
	 * @see #getVType()
	 * @generated
	 */
	EAttribute getVType_Ins();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister <em>VRegister</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VRegister</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister
	 * @generated
	 */
	EClass getVRegister();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister#getVtype <em>Vtype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Vtype</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister#getVtype()
	 * @see #getVRegister()
	 * @generated
	 */
	EReference getVRegister_Vtype();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister#getFunction()
	 * @see #getVRegister()
	 * @generated
	 */
	EReference getVRegister_Function();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegisterInitialization <em>VRegister Initialization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VRegister Initialization</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegisterInitialization
	 * @generated
	 */
	EClass getVRegisterInitialization();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegisterInitialization#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inputs</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegisterInitialization#getInputs()
	 * @see #getVRegisterInitialization()
	 * @generated
	 */
	EReference getVRegisterInitialization_Inputs();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegisterInitialization#getLocals <em>Locals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Locals</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegisterInitialization#getLocals()
	 * @see #getVRegisterInitialization()
	 * @generated
	 */
	EReference getVRegisterInitialization_Locals();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegisterInitialization#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outputs</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegisterInitialization#getOutputs()
	 * @see #getVRegisterInitialization()
	 * @generated
	 */
	EReference getVRegisterInitialization_Outputs();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDStatement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDStatement
	 * @generated
	 */
	EClass getSIMDStatement();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDStatement#getSimdExp <em>Simd Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Simd Exp</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDStatement#getSimdExp()
	 * @see #getSIMDStatement()
	 * @generated
	 */
	EReference getSIMDStatement_SimdExp();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegFunctionParameter <em>VReg Function Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VReg Function Parameter</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegFunctionParameter
	 * @generated
	 */
	EClass getVRegFunctionParameter();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegFunctionParameter#getRegister <em>Register</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Register</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegFunctionParameter#getRegister()
	 * @see #getVRegFunctionParameter()
	 * @generated
	 */
	EReference getVRegFunctionParameter_Register();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDFunction
	 * @generated
	 */
	EClass getSIMDFunction();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDFunction#getInputsimdRegs <em>Inputsimd Regs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inputsimd Regs</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDFunction#getInputsimdRegs()
	 * @see #getSIMDFunction()
	 * @generated
	 */
	EReference getSIMDFunction_InputsimdRegs();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDFunction#getOutputsimdRegs <em>Outputsimd Regs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outputsimd Regs</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDFunction#getOutputsimdRegs()
	 * @see #getSIMDFunction()
	 * @generated
	 */
	EReference getSIMDFunction_OutputsimdRegs();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDFunction#getLocalsimdRegs <em>Localsimd Regs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Localsimd Regs</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDFunction#getLocalsimdRegs()
	 * @see #getSIMDFunction()
	 * @generated
	 */
	EReference getSIMDFunction_LocalsimdRegs();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDCLoop <em>CLoop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CLoop</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDCLoop
	 * @generated
	 */
	EClass getSIMDCLoop();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDCLoop#getSimdStatements <em>Simd Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Simd Statements</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDCLoop#getSimdStatements()
	 * @see #getSIMDCLoop()
	 * @generated
	 */
	EReference getSIMDCLoop_SimdStatements();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.TiledSIMDCLoop <em>Tiled SIMDC Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tiled SIMDC Loop</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.TiledSIMDCLoop
	 * @generated
	 */
	EClass getTiledSIMDCLoop();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.TiledSIMDCLoop#getSimdStatements <em>Simd Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Simd Statements</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.TiledSIMDCLoop#getSimdStatements()
	 * @see #getTiledSIMDCLoop()
	 * @generated
	 */
	EReference getTiledSIMDCLoop_SimdStatements();

	/**
	 * Returns the meta object for enum '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_WIDTH <em>SIMD WIDTH</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>SIMD WIDTH</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_WIDTH
	 * @generated
	 */
	EEnum getSIMD_WIDTH();

	/**
	 * Returns the meta object for enum '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_INS <em>SIMD INS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>SIMD INS</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_INS
	 * @generated
	 */
	EEnum getSIMD_INS();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SIMDFactory getSIMDFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.VTypeImpl <em>VType</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.VTypeImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDPackageImpl#getVType()
		 * @generated
		 */
		EClass VTYPE = eINSTANCE.getVType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VTYPE__TYPE = eINSTANCE.getVType_Type();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VTYPE__WIDTH = eINSTANCE.getVType_Width();

		/**
		 * The meta object literal for the '<em><b>Ins</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VTYPE__INS = eINSTANCE.getVType_Ins();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.VRegisterImpl <em>VRegister</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.VRegisterImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDPackageImpl#getVRegister()
		 * @generated
		 */
		EClass VREGISTER = eINSTANCE.getVRegister();

		/**
		 * The meta object literal for the '<em><b>Vtype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VREGISTER__VTYPE = eINSTANCE.getVRegister_Vtype();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VREGISTER__FUNCTION = eINSTANCE.getVRegister_Function();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.VRegisterInitializationImpl <em>VRegister Initialization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.VRegisterInitializationImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDPackageImpl#getVRegisterInitialization()
		 * @generated
		 */
		EClass VREGISTER_INITIALIZATION = eINSTANCE.getVRegisterInitialization();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VREGISTER_INITIALIZATION__INPUTS = eINSTANCE.getVRegisterInitialization_Inputs();

		/**
		 * The meta object literal for the '<em><b>Locals</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VREGISTER_INITIALIZATION__LOCALS = eINSTANCE.getVRegisterInitialization_Locals();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VREGISTER_INITIALIZATION__OUTPUTS = eINSTANCE.getVRegisterInitialization_Outputs();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDStatementImpl <em>Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDStatementImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDPackageImpl#getSIMDStatement()
		 * @generated
		 */
		EClass SIMD_STATEMENT = eINSTANCE.getSIMDStatement();

		/**
		 * The meta object literal for the '<em><b>Simd Exp</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMD_STATEMENT__SIMD_EXP = eINSTANCE.getSIMDStatement_SimdExp();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.VRegFunctionParameterImpl <em>VReg Function Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.VRegFunctionParameterImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDPackageImpl#getVRegFunctionParameter()
		 * @generated
		 */
		EClass VREG_FUNCTION_PARAMETER = eINSTANCE.getVRegFunctionParameter();

		/**
		 * The meta object literal for the '<em><b>Register</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VREG_FUNCTION_PARAMETER__REGISTER = eINSTANCE.getVRegFunctionParameter_Register();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDFunctionImpl <em>Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDFunctionImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDPackageImpl#getSIMDFunction()
		 * @generated
		 */
		EClass SIMD_FUNCTION = eINSTANCE.getSIMDFunction();

		/**
		 * The meta object literal for the '<em><b>Inputsimd Regs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMD_FUNCTION__INPUTSIMD_REGS = eINSTANCE.getSIMDFunction_InputsimdRegs();

		/**
		 * The meta object literal for the '<em><b>Outputsimd Regs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMD_FUNCTION__OUTPUTSIMD_REGS = eINSTANCE.getSIMDFunction_OutputsimdRegs();

		/**
		 * The meta object literal for the '<em><b>Localsimd Regs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMD_FUNCTION__LOCALSIMD_REGS = eINSTANCE.getSIMDFunction_LocalsimdRegs();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDCLoopImpl <em>CLoop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDCLoopImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDPackageImpl#getSIMDCLoop()
		 * @generated
		 */
		EClass SIMD_CLOOP = eINSTANCE.getSIMDCLoop();

		/**
		 * The meta object literal for the '<em><b>Simd Statements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMD_CLOOP__SIMD_STATEMENTS = eINSTANCE.getSIMDCLoop_SimdStatements();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.TiledSIMDCLoopImpl <em>Tiled SIMDC Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.TiledSIMDCLoopImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDPackageImpl#getTiledSIMDCLoop()
		 * @generated
		 */
		EClass TILED_SIMDC_LOOP = eINSTANCE.getTiledSIMDCLoop();

		/**
		 * The meta object literal for the '<em><b>Simd Statements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TILED_SIMDC_LOOP__SIMD_STATEMENTS = eINSTANCE.getTiledSIMDCLoop_SimdStatements();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_WIDTH <em>SIMD WIDTH</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_WIDTH
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDPackageImpl#getSIMD_WIDTH()
		 * @generated
		 */
		EEnum SIMD_WIDTH = eINSTANCE.getSIMD_WIDTH();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_INS <em>SIMD INS</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_INS
		 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDPackageImpl#getSIMD_INS()
		 * @generated
		 */
		EEnum SIMD_INS = eINSTANCE.getSIMD_INS();

	}

} //SIMDPackage
