/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGFactory
 * @model kind="package"
 * @generated
 */
public interface PolyIRCGPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "polyIRCG";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "polyIRCG";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "polyIRCG";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PolyIRCGPackage eINSTANCE = org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.CompilationUnitImpl <em>Compilation Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.CompilationUnitImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getCompilationUnit()
	 * @generated
	 */
	int COMPILATION_UNIT = 0;

	/**
	 * The feature id for the '<em><b>Program</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT__PROGRAM = 0;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT__UNITS = 1;

	/**
	 * The number of structural features of the '<em>Compilation Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_UNIT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.CodeUnitImpl <em>Code Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.CodeUnitImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getCodeUnit()
	 * @generated
	 */
	int CODE_UNIT = 1;

	/**
	 * The feature id for the '<em><b>Compilation Unit</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_UNIT__COMPILATION_UNIT = 0;

	/**
	 * The feature id for the '<em><b>System</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_UNIT__SYSTEM = 1;

	/**
	 * The feature id for the '<em><b>Headers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_UNIT__HEADERS = 2;

	/**
	 * The feature id for the '<em><b>Functions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_UNIT__FUNCTIONS = 3;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_UNIT__VARIABLES = 4;

	/**
	 * The feature id for the '<em><b>Local Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_UNIT__LOCAL_PARAMETERS = 5;

	/**
	 * The feature id for the '<em><b>Compile Time Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_UNIT__COMPILE_TIME_PARAMETERS = 6;

	/**
	 * The feature id for the '<em><b>Subsystem Functions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_UNIT__SUBSYSTEM_FUNCTIONS = 7;

	/**
	 * The number of structural features of the '<em>Code Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_UNIT_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.CodeUnitHeaderImpl <em>Code Unit Header</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.CodeUnitHeaderImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getCodeUnitHeader()
	 * @generated
	 */
	int CODE_UNIT_HEADER = 2;

	/**
	 * The number of structural features of the '<em>Code Unit Header</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_UNIT_HEADER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.BasicCodeUnitHeaderImpl <em>Basic Code Unit Header</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.BasicCodeUnitHeaderImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getBasicCodeUnitHeader()
	 * @generated
	 */
	int BASIC_CODE_UNIT_HEADER = 3;

	/**
	 * The feature id for the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_CODE_UNIT_HEADER__STRING = CODE_UNIT_HEADER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Basic Code Unit Header</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_CODE_UNIT_HEADER_FEATURE_COUNT = CODE_UNIT_HEADER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.DeclareStructsImpl <em>Declare Structs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.DeclareStructsImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getDeclareStructs()
	 * @generated
	 */
	int DECLARE_STRUCTS = 4;

	/**
	 * The feature id for the '<em><b>Structs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARE_STRUCTS__STRUCTS = CODE_UNIT_HEADER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Declare Structs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARE_STRUCTS_FEATURE_COUNT = CODE_UNIT_HEADER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.Body <em>Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.Body
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getBody()
	 * @generated
	 */
	int BODY = 16;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.BasicBodyImpl <em>Basic Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.BasicBodyImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getBasicBody()
	 * @generated
	 */
	int BASIC_BODY = 17;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.FunctionImpl <em>Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.FunctionImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getFunction()
	 * @generated
	 */
	int FUNCTION = 5;

	/**
	 * The feature id for the '<em><b>Codeunit</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__CODEUNIT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__RETURN_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__PARAMETERS = 3;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__INPUTS = 4;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__OUTPUTS = 5;

	/**
	 * The feature id for the '<em><b>Locals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__LOCALS = 6;

	/**
	 * The feature id for the '<em><b>Special Locals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__SPECIAL_LOCALS = 7;

	/**
	 * The feature id for the '<em><b>Bodies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__BODIES = 8;

	/**
	 * The feature id for the '<em><b>Entry Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__ENTRY_POINT = 9;

	/**
	 * The feature id for the '<em><b>Inlined</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__INLINED = 10;

	/**
	 * The feature id for the '<em><b>Number Of Time Iterations For First Condition Check</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__NUMBER_OF_TIME_ITERATIONS_FOR_FIRST_CONDITION_CHECK = 11;

	/**
	 * The feature id for the '<em><b>Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__SIGNATURE = 12;

	/**
	 * The number of structural features of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FEATURE_COUNT = 13;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.FunctionSignatureImpl <em>Function Signature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.FunctionSignatureImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getFunctionSignature()
	 * @generated
	 */
	int FUNCTION_SIGNATURE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_SIGNATURE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_SIGNATURE__RETURN_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_SIGNATURE__PARAMETERS = 2;

	/**
	 * The number of structural features of the '<em>Function Signature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_SIGNATURE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.AbstractVariableImpl <em>Abstract Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.AbstractVariableImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getAbstractVariable()
	 * @generated
	 */
	int ABSTRACT_VARIABLE = 9;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.StructImpl <em>Struct</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.StructImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getStruct()
	 * @generated
	 */
	int STRUCT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT__MEMBERS = 1;

	/**
	 * The number of structural features of the '<em>Struct</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.VariableFunctionParameterImpl <em>Variable Function Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.VariableFunctionParameterImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getVariableFunctionParameter()
	 * @generated
	 */
	int VARIABLE_FUNCTION_PARAMETER = 8;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FUNCTION_PARAMETER__VARIABLE = 0;

	/**
	 * The number of structural features of the '<em>Variable Function Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FUNCTION_PARAMETER_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Codeunit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__CODEUNIT = 1;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE__GLOBAL = 2;

	/**
	 * The number of structural features of the '<em>Abstract Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VARIABLE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.BasicVariableImpl <em>Basic Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.BasicVariableImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getBasicVariable()
	 * @generated
	 */
	int BASIC_VARIABLE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_VARIABLE__NAME = ABSTRACT_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Codeunit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_VARIABLE__CODEUNIT = ABSTRACT_VARIABLE__CODEUNIT;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_VARIABLE__GLOBAL = ABSTRACT_VARIABLE__GLOBAL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_VARIABLE__TYPE = ABSTRACT_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Basic Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_VARIABLE_FEATURE_COUNT = ABSTRACT_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.CodeGenVariableImpl <em>Code Gen Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.CodeGenVariableImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getCodeGenVariable()
	 * @generated
	 */
	int CODE_GEN_VARIABLE = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_GEN_VARIABLE__NAME = ABSTRACT_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Codeunit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_GEN_VARIABLE__CODEUNIT = ABSTRACT_VARIABLE__CODEUNIT;

	/**
	 * The feature id for the '<em><b>Global</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_GEN_VARIABLE__GLOBAL = ABSTRACT_VARIABLE__GLOBAL;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_GEN_VARIABLE__TYPE = ABSTRACT_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_GEN_VARIABLE__DOMAIN = ABSTRACT_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Aligned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_GEN_VARIABLE__ALIGNED = ABSTRACT_VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Flattened</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_GEN_VARIABLE__FLATTENED = ABSTRACT_VARIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Access Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_GEN_VARIABLE__ACCESS_EXPRESSION = ABSTRACT_VARIABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Isfrontpadded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_GEN_VARIABLE__ISFRONTPADDED = ABSTRACT_VARIABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Forntpadding Value</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_GEN_VARIABLE__FORNTPADDING_VALUE = ABSTRACT_VARIABLE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Code Gen Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_GEN_VARIABLE_FEATURE_COUNT = ABSTRACT_VARIABLE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.MemoryDomainImpl <em>Memory Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.MemoryDomainImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getMemoryDomain()
	 * @generated
	 */
	int MEMORY_DOMAIN = 12;

	/**
	 * The feature id for the '<em><b>Zero Aligned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_DOMAIN__ZERO_ALIGNED = 0;

	/**
	 * The number of structural features of the '<em>Memory Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_DOMAIN_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.ScalarMemoryDomainImpl <em>Scalar Memory Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.ScalarMemoryDomainImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getScalarMemoryDomain()
	 * @generated
	 */
	int SCALAR_MEMORY_DOMAIN = 13;

	/**
	 * The feature id for the '<em><b>Zero Aligned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_MEMORY_DOMAIN__ZERO_ALIGNED = MEMORY_DOMAIN__ZERO_ALIGNED;

	/**
	 * The number of structural features of the '<em>Scalar Memory Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_MEMORY_DOMAIN_FEATURE_COUNT = MEMORY_DOMAIN_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.MergedMemoryDomainImpl <em>Merged Memory Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.MergedMemoryDomainImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getMergedMemoryDomain()
	 * @generated
	 */
	int MERGED_MEMORY_DOMAIN = 14;

	/**
	 * The feature id for the '<em><b>Zero Aligned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGED_MEMORY_DOMAIN__ZERO_ALIGNED = MEMORY_DOMAIN__ZERO_ALIGNED;

	/**
	 * The feature id for the '<em><b>Memory Domains</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGED_MEMORY_DOMAIN__MEMORY_DOMAINS = MEMORY_DOMAIN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Merged Memory Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGED_MEMORY_DOMAIN_FEATURE_COUNT = MEMORY_DOMAIN_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.PseudoProjectionImpl <em>Pseudo Projection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PseudoProjectionImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getPseudoProjection()
	 * @generated
	 */
	int PSEUDO_PROJECTION = 15;

	/**
	 * The feature id for the '<em><b>Zero Aligned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDO_PROJECTION__ZERO_ALIGNED = MEMORY_DOMAIN__ZERO_ALIGNED;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDO_PROJECTION__DOMAIN = MEMORY_DOMAIN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mod Factors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDO_PROJECTION__MOD_FACTORS = MEMORY_DOMAIN_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Pseudo Projection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDO_PROJECTION_FEATURE_COUNT = MEMORY_DOMAIN_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BODY__FUNCTION = 0;

	/**
	 * The number of structural features of the '<em>Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BODY_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_BODY__FUNCTION = BODY__FUNCTION;

	/**
	 * The feature id for the '<em><b>String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_BODY__STRING = BODY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Basic Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_BODY_FEATURE_COUNT = BODY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.VariableInitializationImpl <em>Variable Initialization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.VariableInitializationImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getVariableInitialization()
	 * @generated
	 */
	int VARIABLE_INITIALIZATION = 18;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION__FUNCTION = BODY__FUNCTION;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION__INPUTS = BODY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION__OUTPUTS = BODY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Locals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION__LOCALS = BODY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Special Locals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION__SPECIAL_LOCALS = BODY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Variable Initialization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_INITIALIZATION_FEATURE_COUNT = BODY_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.FlagVariableResetImpl <em>Flag Variable Reset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.FlagVariableResetImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getFlagVariableReset()
	 * @generated
	 */
	int FLAG_VARIABLE_RESET = 19;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLAG_VARIABLE_RESET__FUNCTION = BODY__FUNCTION;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLAG_VARIABLE_RESET__OUTPUTS = BODY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Locals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLAG_VARIABLE_RESET__LOCALS = BODY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Special Locals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLAG_VARIABLE_RESET__SPECIAL_LOCALS = BODY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Flag Variable Reset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLAG_VARIABLE_RESET_FEATURE_COUNT = BODY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.VariableFinalizationImpl <em>Variable Finalization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.VariableFinalizationImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getVariableFinalization()
	 * @generated
	 */
	int VARIABLE_FINALIZATION = 20;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FINALIZATION__FUNCTION = BODY__FUNCTION;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FINALIZATION__INPUTS = BODY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FINALIZATION__OUTPUTS = BODY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Locals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FINALIZATION__LOCALS = BODY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Special Locals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FINALIZATION__SPECIAL_LOCALS = BODY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Variable Finalization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FINALIZATION_FEATURE_COUNT = BODY_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.StructManagementImpl <em>Struct Management</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.StructManagementImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getStructManagement()
	 * @generated
	 */
	int STRUCT_MANAGEMENT = 21;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT_MANAGEMENT__FUNCTION = BODY__FUNCTION;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT_MANAGEMENT__INSTANCE = BODY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Struct</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT_MANAGEMENT__STRUCT = BODY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Struct Management</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT_MANAGEMENT_FEATURE_COUNT = BODY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.PackStructImpl <em>Pack Struct</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PackStructImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getPackStruct()
	 * @generated
	 */
	int PACK_STRUCT = 22;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACK_STRUCT__FUNCTION = STRUCT_MANAGEMENT__FUNCTION;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACK_STRUCT__INSTANCE = STRUCT_MANAGEMENT__INSTANCE;

	/**
	 * The feature id for the '<em><b>Struct</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACK_STRUCT__STRUCT = STRUCT_MANAGEMENT__STRUCT;

	/**
	 * The number of structural features of the '<em>Pack Struct</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACK_STRUCT_FEATURE_COUNT = STRUCT_MANAGEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.CustomPackStructImpl <em>Custom Pack Struct</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.CustomPackStructImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getCustomPackStruct()
	 * @generated
	 */
	int CUSTOM_PACK_STRUCT = 23;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PACK_STRUCT__FUNCTION = STRUCT_MANAGEMENT__FUNCTION;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PACK_STRUCT__INSTANCE = STRUCT_MANAGEMENT__INSTANCE;

	/**
	 * The feature id for the '<em><b>Struct</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PACK_STRUCT__STRUCT = STRUCT_MANAGEMENT__STRUCT;

	/**
	 * The feature id for the '<em><b>Init Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PACK_STRUCT__INIT_VALUES = STRUCT_MANAGEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Custom Pack Struct</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PACK_STRUCT_FEATURE_COUNT = STRUCT_MANAGEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.UnpackStructImpl <em>Unpack Struct</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.UnpackStructImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getUnpackStruct()
	 * @generated
	 */
	int UNPACK_STRUCT = 24;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNPACK_STRUCT__FUNCTION = STRUCT_MANAGEMENT__FUNCTION;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNPACK_STRUCT__INSTANCE = STRUCT_MANAGEMENT__INSTANCE;

	/**
	 * The feature id for the '<em><b>Struct</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNPACK_STRUCT__STRUCT = STRUCT_MANAGEMENT__STRUCT;

	/**
	 * The number of structural features of the '<em>Unpack Struct</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNPACK_STRUCT_FEATURE_COUNT = STRUCT_MANAGEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.LoopImpl <em>Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.LoopImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getLoop()
	 * @generated
	 */
	int LOOP = 25;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.Statement <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.Statement
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getStatement()
	 * @generated
	 */
	int STATEMENT = 26;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.BasicStatementImpl <em>Basic Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.BasicStatementImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getBasicStatement()
	 * @generated
	 */
	int BASIC_STATEMENT = 27;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.MemoryAccessExpressionImpl <em>Memory Access Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.MemoryAccessExpressionImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getMemoryAccessExpression()
	 * @generated
	 */
	int MEMORY_ACCESS_EXPRESSION = 28;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.PseudoProjectiveAccessExpressionImpl <em>Pseudo Projective Access Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PseudoProjectiveAccessExpressionImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getPseudoProjectiveAccessExpression()
	 * @generated
	 */
	int PSEUDO_PROJECTIVE_ACCESS_EXPRESSION = 29;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.IdentityAccessExpressionImpl <em>Identity Access Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.IdentityAccessExpressionImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getIdentityAccessExpression()
	 * @generated
	 */
	int IDENTITY_ACCESS_EXPRESSION = 30;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.MergedDomainAccessExpressionImpl <em>Merged Domain Access Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.MergedDomainAccessExpressionImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getMergedDomainAccessExpression()
	 * @generated
	 */
	int MERGED_DOMAIN_ACCESS_EXPRESSION = 31;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.CompileTimeParameterImpl <em>Compile Time Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.CompileTimeParameterImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getCompileTimeParameter()
	 * @generated
	 */
	int COMPILE_TIME_PARAMETER = 32;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.CustomProviderStatementImpl <em>Custom Provider Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.CustomProviderStatementImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getCustomProviderStatement()
	 * @generated
	 */
	int CUSTOM_PROVIDER_STATEMENT = 33;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__FUNCTION = BODY__FUNCTION;

	/**
	 * The feature id for the '<em><b>Parameter Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__PARAMETER_DOMAIN = BODY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__STATEMENTS = BODY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Declare Iterators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__DECLARE_ITERATORS = BODY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Iterator Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__ITERATOR_NAMES = BODY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Num Constant Dimensions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__NUM_CONSTANT_DIMENSIONS = BODY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_FEATURE_COUNT = BODY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__DOMAIN = 1;

	/**
	 * The feature id for the '<em><b>Container Loop</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__CONTAINER_LOOP = 2;

	/**
	 * The feature id for the '<em><b>Inlined</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__INLINED = 3;

	/**
	 * The feature id for the '<em><b>Scattering</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__SCATTERING = 4;

	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_FEATURE_COUNT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_STATEMENT__NAME = STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_STATEMENT__DOMAIN = STATEMENT__DOMAIN;

	/**
	 * The feature id for the '<em><b>Container Loop</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_STATEMENT__CONTAINER_LOOP = STATEMENT__CONTAINER_LOOP;

	/**
	 * The feature id for the '<em><b>Inlined</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_STATEMENT__INLINED = STATEMENT__INLINED;

	/**
	 * The feature id for the '<em><b>Scattering</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_STATEMENT__SCATTERING = STATEMENT__SCATTERING;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_STATEMENT__STATEMENT = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Basic Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_ACCESS_EXPRESSION__VARIABLE = 0;

	/**
	 * The number of structural features of the '<em>Memory Access Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_ACCESS_EXPRESSION_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDO_PROJECTIVE_ACCESS_EXPRESSION__VARIABLE = MEMORY_ACCESS_EXPRESSION__VARIABLE;

	/**
	 * The number of structural features of the '<em>Pseudo Projective Access Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSEUDO_PROJECTIVE_ACCESS_EXPRESSION_FEATURE_COUNT = MEMORY_ACCESS_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTITY_ACCESS_EXPRESSION__VARIABLE = MEMORY_ACCESS_EXPRESSION__VARIABLE;

	/**
	 * The number of structural features of the '<em>Identity Access Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTITY_ACCESS_EXPRESSION_FEATURE_COUNT = MEMORY_ACCESS_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGED_DOMAIN_ACCESS_EXPRESSION__VARIABLE = MEMORY_ACCESS_EXPRESSION__VARIABLE;

	/**
	 * The feature id for the '<em><b>Access Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGED_DOMAIN_ACCESS_EXPRESSION__ACCESS_EXPRESSION = MEMORY_ACCESS_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGED_DOMAIN_ACCESS_EXPRESSION__IDENTIFIER = MEMORY_ACCESS_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Merged Domain Access Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGED_DOMAIN_ACCESS_EXPRESSION_FEATURE_COUNT = MEMORY_ACCESS_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILE_TIME_PARAMETER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILE_TIME_PARAMETER__DEFAULT_VALUE = 1;

	/**
	 * The number of structural features of the '<em>Compile Time Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILE_TIME_PARAMETER_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PROVIDER_STATEMENT__NAME = STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PROVIDER_STATEMENT__DOMAIN = STATEMENT__DOMAIN;

	/**
	 * The feature id for the '<em><b>Container Loop</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PROVIDER_STATEMENT__CONTAINER_LOOP = STATEMENT__CONTAINER_LOOP;

	/**
	 * The feature id for the '<em><b>Inlined</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PROVIDER_STATEMENT__INLINED = STATEMENT__INLINED;

	/**
	 * The feature id for the '<em><b>Scattering</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PROVIDER_STATEMENT__SCATTERING = STATEMENT__SCATTERING;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PROVIDER_STATEMENT__PROVIDER = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Custom Provider Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_PROVIDER_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '<em>Macro Body Provider</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.scop.cgenerator2.MacroBodyProvider
	 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getMacroBodyProvider()
	 * @generated
	 */
	int MACRO_BODY_PROVIDER = 34;

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.CompilationUnit <em>Compilation Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compilation Unit</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CompilationUnit
	 * @generated
	 */
	EClass getCompilationUnit();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.polyIRCG.CompilationUnit#getProgram <em>Program</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Program</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CompilationUnit#getProgram()
	 * @see #getCompilationUnit()
	 * @generated
	 */
	EReference getCompilationUnit_Program();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.polyIRCG.CompilationUnit#getUnits <em>Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Units</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CompilationUnit#getUnits()
	 * @see #getCompilationUnit()
	 * @generated
	 */
	EReference getCompilationUnit_Units();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.CodeUnit <em>Code Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code Unit</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CodeUnit
	 * @generated
	 */
	EClass getCodeUnit();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getSystem <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>System</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getSystem()
	 * @see #getCodeUnit()
	 * @generated
	 */
	EReference getCodeUnit_System();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getHeaders <em>Headers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Headers</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getHeaders()
	 * @see #getCodeUnit()
	 * @generated
	 */
	EReference getCodeUnit_Headers();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getFunctions <em>Functions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Functions</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getFunctions()
	 * @see #getCodeUnit()
	 * @generated
	 */
	EReference getCodeUnit_Functions();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Variables</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getVariables()
	 * @see #getCodeUnit()
	 * @generated
	 */
	EReference getCodeUnit_Variables();

	/**
	 * Returns the meta object for the container reference '{@link org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getCompilationUnit <em>Compilation Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Compilation Unit</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getCompilationUnit()
	 * @see #getCodeUnit()
	 * @generated
	 */
	EReference getCodeUnit_CompilationUnit();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getLocalParameters <em>Local Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Local Parameters</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getLocalParameters()
	 * @see #getCodeUnit()
	 * @generated
	 */
	EReference getCodeUnit_LocalParameters();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getCompileTimeParameters <em>Compile Time Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Compile Time Parameters</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getCompileTimeParameters()
	 * @see #getCodeUnit()
	 * @generated
	 */
	EReference getCodeUnit_CompileTimeParameters();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getSubsystemFunctions <em>Subsystem Functions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subsystem Functions</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getSubsystemFunctions()
	 * @see #getCodeUnit()
	 * @generated
	 */
	EReference getCodeUnit_SubsystemFunctions();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.CodeUnitHeader <em>Code Unit Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code Unit Header</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CodeUnitHeader
	 * @generated
	 */
	EClass getCodeUnitHeader();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.BasicCodeUnitHeader <em>Basic Code Unit Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Code Unit Header</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.BasicCodeUnitHeader
	 * @generated
	 */
	EClass getBasicCodeUnitHeader();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.BasicCodeUnitHeader#getString <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.BasicCodeUnitHeader#getString()
	 * @see #getBasicCodeUnitHeader()
	 * @generated
	 */
	EAttribute getBasicCodeUnitHeader_String();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.DeclareStructs <em>Declare Structs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Declare Structs</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.DeclareStructs
	 * @generated
	 */
	EClass getDeclareStructs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.polyIRCG.DeclareStructs#getStructs <em>Structs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Structs</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.DeclareStructs#getStructs()
	 * @see #getDeclareStructs()
	 * @generated
	 */
	EReference getDeclareStructs_Structs();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.MemoryDomain <em>Memory Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Memory Domain</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.MemoryDomain
	 * @generated
	 */
	EClass getMemoryDomain();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.MemoryDomain#isZeroAligned <em>Zero Aligned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Zero Aligned</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.MemoryDomain#isZeroAligned()
	 * @see #getMemoryDomain()
	 * @generated
	 */
	EAttribute getMemoryDomain_ZeroAligned();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.ScalarMemoryDomain <em>Scalar Memory Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scalar Memory Domain</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.ScalarMemoryDomain
	 * @generated
	 */
	EClass getScalarMemoryDomain();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.MergedMemoryDomain <em>Merged Memory Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Merged Memory Domain</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.MergedMemoryDomain
	 * @generated
	 */
	EClass getMergedMemoryDomain();

	/**
	 * Returns the meta object for the map '{@link org.polymodel.polyhedralIR.polyIRCG.MergedMemoryDomain#getMemoryDomains <em>Memory Domains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Memory Domains</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.MergedMemoryDomain#getMemoryDomains()
	 * @see #getMergedMemoryDomain()
	 * @generated
	 */
	EReference getMergedMemoryDomain_MemoryDomains();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.PseudoProjection <em>Pseudo Projection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pseudo Projection</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PseudoProjection
	 * @generated
	 */
	EClass getPseudoProjection();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.polyIRCG.PseudoProjection#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domain</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PseudoProjection#getDomain()
	 * @see #getPseudoProjection()
	 * @generated
	 */
	EReference getPseudoProjection_Domain();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.polyIRCG.PseudoProjection#getModFactors <em>Mod Factors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mod Factors</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PseudoProjection#getModFactors()
	 * @see #getPseudoProjection()
	 * @generated
	 */
	EReference getPseudoProjection_ModFactors();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.Body <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Body</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Body
	 * @generated
	 */
	EClass getBody();

	/**
	 * Returns the meta object for the container reference '{@link org.polymodel.polyhedralIR.polyIRCG.Body#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Function</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Body#getFunction()
	 * @see #getBody()
	 * @generated
	 */
	EReference getBody_Function();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.BasicBody <em>Basic Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Body</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.BasicBody
	 * @generated
	 */
	EClass getBasicBody();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.BasicBody#getString <em>String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.BasicBody#getString()
	 * @see #getBasicBody()
	 * @generated
	 */
	EAttribute getBasicBody_String();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.VariableInitialization <em>Variable Initialization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Initialization</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.VariableInitialization
	 * @generated
	 */
	EClass getVariableInitialization();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.VariableInitialization#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inputs</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.VariableInitialization#getInputs()
	 * @see #getVariableInitialization()
	 * @generated
	 */
	EReference getVariableInitialization_Inputs();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.VariableInitialization#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outputs</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.VariableInitialization#getOutputs()
	 * @see #getVariableInitialization()
	 * @generated
	 */
	EReference getVariableInitialization_Outputs();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.VariableInitialization#getLocals <em>Locals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Locals</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.VariableInitialization#getLocals()
	 * @see #getVariableInitialization()
	 * @generated
	 */
	EReference getVariableInitialization_Locals();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.VariableInitialization#getSpecialLocals <em>Special Locals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Special Locals</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.VariableInitialization#getSpecialLocals()
	 * @see #getVariableInitialization()
	 * @generated
	 */
	EReference getVariableInitialization_SpecialLocals();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.FlagVariableReset <em>Flag Variable Reset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flag Variable Reset</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.FlagVariableReset
	 * @generated
	 */
	EClass getFlagVariableReset();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.FlagVariableReset#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outputs</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.FlagVariableReset#getOutputs()
	 * @see #getFlagVariableReset()
	 * @generated
	 */
	EReference getFlagVariableReset_Outputs();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.FlagVariableReset#getLocals <em>Locals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Locals</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.FlagVariableReset#getLocals()
	 * @see #getFlagVariableReset()
	 * @generated
	 */
	EReference getFlagVariableReset_Locals();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.FlagVariableReset#getSpecialLocals <em>Special Locals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Special Locals</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.FlagVariableReset#getSpecialLocals()
	 * @see #getFlagVariableReset()
	 * @generated
	 */
	EReference getFlagVariableReset_SpecialLocals();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.VariableFinalization <em>Variable Finalization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Finalization</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.VariableFinalization
	 * @generated
	 */
	EClass getVariableFinalization();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.VariableFinalization#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inputs</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.VariableFinalization#getInputs()
	 * @see #getVariableFinalization()
	 * @generated
	 */
	EReference getVariableFinalization_Inputs();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.VariableFinalization#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outputs</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.VariableFinalization#getOutputs()
	 * @see #getVariableFinalization()
	 * @generated
	 */
	EReference getVariableFinalization_Outputs();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.VariableFinalization#getLocals <em>Locals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Locals</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.VariableFinalization#getLocals()
	 * @see #getVariableFinalization()
	 * @generated
	 */
	EReference getVariableFinalization_Locals();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.VariableFinalization#getSpecialLocals <em>Special Locals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Special Locals</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.VariableFinalization#getSpecialLocals()
	 * @see #getVariableFinalization()
	 * @generated
	 */
	EReference getVariableFinalization_SpecialLocals();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.StructManagement <em>Struct Management</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Struct Management</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.StructManagement
	 * @generated
	 */
	EClass getStructManagement();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.StructManagement#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instance</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.StructManagement#getInstance()
	 * @see #getStructManagement()
	 * @generated
	 */
	EReference getStructManagement_Instance();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.StructManagement#getStruct <em>Struct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Struct</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.StructManagement#getStruct()
	 * @see #getStructManagement()
	 * @generated
	 */
	EReference getStructManagement_Struct();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.PackStruct <em>Pack Struct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pack Struct</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PackStruct
	 * @generated
	 */
	EClass getPackStruct();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.CustomPackStruct <em>Custom Pack Struct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Custom Pack Struct</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CustomPackStruct
	 * @generated
	 */
	EClass getCustomPackStruct();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.CustomPackStruct#getInitValues <em>Init Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Init Values</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CustomPackStruct#getInitValues()
	 * @see #getCustomPackStruct()
	 * @generated
	 */
	EAttribute getCustomPackStruct_InitValues();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.UnpackStruct <em>Unpack Struct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unpack Struct</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.UnpackStruct
	 * @generated
	 */
	EClass getUnpackStruct();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.Loop <em>Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Loop
	 * @generated
	 */
	EClass getLoop();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.Loop#getParameterDomain <em>Parameter Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter Domain</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Loop#getParameterDomain()
	 * @see #getLoop()
	 * @generated
	 */
	EReference getLoop_ParameterDomain();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.polyIRCG.Loop#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Loop#getStatements()
	 * @see #getLoop()
	 * @generated
	 */
	EReference getLoop_Statements();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.Loop#isDeclareIterators <em>Declare Iterators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declare Iterators</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Loop#isDeclareIterators()
	 * @see #getLoop()
	 * @generated
	 */
	EAttribute getLoop_DeclareIterators();

	/**
	 * Returns the meta object for the attribute list '{@link org.polymodel.polyhedralIR.polyIRCG.Loop#getIteratorNames <em>Iterator Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Iterator Names</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Loop#getIteratorNames()
	 * @see #getLoop()
	 * @generated
	 */
	EAttribute getLoop_IteratorNames();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.Loop#getNumConstantDimensions <em>Num Constant Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Constant Dimensions</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Loop#getNumConstantDimensions()
	 * @see #getLoop()
	 * @generated
	 */
	EAttribute getLoop_NumConstantDimensions();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Function
	 * @generated
	 */
	EClass getFunction();

	/**
	 * Returns the meta object for the container reference '{@link org.polymodel.polyhedralIR.polyIRCG.Function#getCodeunit <em>Codeunit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Codeunit</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Function#getCodeunit()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Codeunit();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.Function#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Function#getName()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.Function#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Return Type</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Function#getReturnType()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_ReturnType();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.Function#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameters</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Function#getParameters()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Parameters();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.Function#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inputs</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Function#getInputs()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Inputs();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.Function#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outputs</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Function#getOutputs()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Outputs();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.Function#getLocals <em>Locals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Locals</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Function#getLocals()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Locals();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.polyIRCG.Function#getBodies <em>Bodies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bodies</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Function#getBodies()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Bodies();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.Function#isEntryPoint <em>Entry Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Entry Point</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Function#isEntryPoint()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_EntryPoint();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.polyIRCG.Function#getSignature <em>Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Signature</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Function#getSignature()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Signature();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.Function#isInlined <em>Inlined</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inlined</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Function#isInlined()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_Inlined();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.Function#getNumberOfTimeIterationsForFirstConditionCheck <em>Number Of Time Iterations For First Condition Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Time Iterations For First Condition Check</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Function#getNumberOfTimeIterationsForFirstConditionCheck()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_NumberOfTimeIterationsForFirstConditionCheck();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.Function#getSpecialLocals <em>Special Locals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Special Locals</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Function#getSpecialLocals()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_SpecialLocals();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.FunctionSignature <em>Function Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Signature</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.FunctionSignature
	 * @generated
	 */
	EClass getFunctionSignature();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.FunctionSignature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.FunctionSignature#getName()
	 * @see #getFunctionSignature()
	 * @generated
	 */
	EAttribute getFunctionSignature_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.FunctionSignature#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Return Type</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.FunctionSignature#getReturnType()
	 * @see #getFunctionSignature()
	 * @generated
	 */
	EAttribute getFunctionSignature_ReturnType();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.FunctionSignature#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameters</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.FunctionSignature#getParameters()
	 * @see #getFunctionSignature()
	 * @generated
	 */
	EReference getFunctionSignature_Parameters();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.Struct <em>Struct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Struct</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Struct
	 * @generated
	 */
	EClass getStruct();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.Struct#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Struct#getName()
	 * @see #getStruct()
	 * @generated
	 */
	EAttribute getStruct_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.Struct#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Members</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Struct#getMembers()
	 * @see #getStruct()
	 * @generated
	 */
	EReference getStruct_Members();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.VariableFunctionParameter <em>Variable Function Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Function Parameter</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.VariableFunctionParameter
	 * @generated
	 */
	EClass getVariableFunctionParameter();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.VariableFunctionParameter#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.VariableFunctionParameter#getVariable()
	 * @see #getVariableFunctionParameter()
	 * @generated
	 */
	EReference getVariableFunctionParameter_Variable();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.AbstractVariable <em>Abstract Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Variable</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.AbstractVariable
	 * @generated
	 */
	EClass getAbstractVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.AbstractVariable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.AbstractVariable#getName()
	 * @see #getAbstractVariable()
	 * @generated
	 */
	EAttribute getAbstractVariable_Name();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.AbstractVariable#getCodeunit <em>Codeunit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Codeunit</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.AbstractVariable#getCodeunit()
	 * @see #getAbstractVariable()
	 * @generated
	 */
	EReference getAbstractVariable_Codeunit();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.AbstractVariable#isGlobal <em>Global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Global</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.AbstractVariable#isGlobal()
	 * @see #getAbstractVariable()
	 * @generated
	 */
	EAttribute getAbstractVariable_Global();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.BasicVariable <em>Basic Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Variable</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.BasicVariable
	 * @generated
	 */
	EClass getBasicVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.BasicVariable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.BasicVariable#getType()
	 * @see #getBasicVariable()
	 * @generated
	 */
	EAttribute getBasicVariable_Type();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable <em>Code Gen Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code Gen Variable</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable
	 * @generated
	 */
	EClass getCodeGenVariable();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable#getType()
	 * @see #getCodeGenVariable()
	 * @generated
	 */
	EReference getCodeGenVariable_Type();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domain</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable#getDomain()
	 * @see #getCodeGenVariable()
	 * @generated
	 */
	EReference getCodeGenVariable_Domain();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable#isAligned <em>Aligned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Aligned</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable#isAligned()
	 * @see #getCodeGenVariable()
	 * @generated
	 */
	EAttribute getCodeGenVariable_Aligned();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable#isFlattened <em>Flattened</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Flattened</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable#isFlattened()
	 * @see #getCodeGenVariable()
	 * @generated
	 */
	EAttribute getCodeGenVariable_Flattened();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable#getAccessExpression <em>Access Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Access Expression</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable#getAccessExpression()
	 * @see #getCodeGenVariable()
	 * @generated
	 */
	EReference getCodeGenVariable_AccessExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable#isIsfrontpadded <em>Isfrontpadded</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Isfrontpadded</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable#isIsfrontpadded()
	 * @see #getCodeGenVariable()
	 * @generated
	 */
	EAttribute getCodeGenVariable_Isfrontpadded();

	/**
	 * Returns the meta object for the attribute list '{@link org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable#getForntpaddingValue <em>Forntpadding Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Forntpadding Value</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable#getForntpaddingValue()
	 * @see #getCodeGenVariable()
	 * @generated
	 */
	EAttribute getCodeGenVariable_ForntpaddingValue();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Statement
	 * @generated
	 */
	EClass getStatement();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.Statement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Statement#getName()
	 * @see #getStatement()
	 * @generated
	 */
	EAttribute getStatement_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.polyIRCG.Statement#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domain</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Statement#getDomain()
	 * @see #getStatement()
	 * @generated
	 */
	EReference getStatement_Domain();

	/**
	 * Returns the meta object for the container reference '{@link org.polymodel.polyhedralIR.polyIRCG.Statement#getContainerLoop <em>Container Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container Loop</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Statement#getContainerLoop()
	 * @see #getStatement()
	 * @generated
	 */
	EReference getStatement_ContainerLoop();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.Statement#isInlined <em>Inlined</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inlined</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Statement#isInlined()
	 * @see #getStatement()
	 * @generated
	 */
	EAttribute getStatement_Inlined();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.polyIRCG.Statement#getScattering <em>Scattering</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scattering</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.Statement#getScattering()
	 * @see #getStatement()
	 * @generated
	 */
	EReference getStatement_Scattering();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.BasicStatement <em>Basic Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Statement</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.BasicStatement
	 * @generated
	 */
	EClass getBasicStatement();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.BasicStatement#getStatement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Statement</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.BasicStatement#getStatement()
	 * @see #getBasicStatement()
	 * @generated
	 */
	EAttribute getBasicStatement_Statement();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.MemoryAccessExpression <em>Memory Access Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Memory Access Expression</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.MemoryAccessExpression
	 * @generated
	 */
	EClass getMemoryAccessExpression();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.MemoryAccessExpression#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.MemoryAccessExpression#getVariable()
	 * @see #getMemoryAccessExpression()
	 * @generated
	 */
	EReference getMemoryAccessExpression_Variable();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.PseudoProjectiveAccessExpression <em>Pseudo Projective Access Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pseudo Projective Access Expression</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PseudoProjectiveAccessExpression
	 * @generated
	 */
	EClass getPseudoProjectiveAccessExpression();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.IdentityAccessExpression <em>Identity Access Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identity Access Expression</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.IdentityAccessExpression
	 * @generated
	 */
	EClass getIdentityAccessExpression();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.MergedDomainAccessExpression <em>Merged Domain Access Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Merged Domain Access Expression</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.MergedDomainAccessExpression
	 * @generated
	 */
	EClass getMergedDomainAccessExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.polyIRCG.MergedDomainAccessExpression#getAccessExpression <em>Access Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Access Expression</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.MergedDomainAccessExpression#getAccessExpression()
	 * @see #getMergedDomainAccessExpression()
	 * @generated
	 */
	EReference getMergedDomainAccessExpression_AccessExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.MergedDomainAccessExpression#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.MergedDomainAccessExpression#getIdentifier()
	 * @see #getMergedDomainAccessExpression()
	 * @generated
	 */
	EAttribute getMergedDomainAccessExpression_Identifier();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.CompileTimeParameter <em>Compile Time Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compile Time Parameter</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CompileTimeParameter
	 * @generated
	 */
	EClass getCompileTimeParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.CompileTimeParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CompileTimeParameter#getName()
	 * @see #getCompileTimeParameter()
	 * @generated
	 */
	EAttribute getCompileTimeParameter_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.CompileTimeParameter#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CompileTimeParameter#getDefaultValue()
	 * @see #getCompileTimeParameter()
	 * @generated
	 */
	EAttribute getCompileTimeParameter_DefaultValue();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.CustomProviderStatement <em>Custom Provider Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Custom Provider Statement</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CustomProviderStatement
	 * @generated
	 */
	EClass getCustomProviderStatement();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.CustomProviderStatement#getProvider <em>Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.CustomProviderStatement#getProvider()
	 * @see #getCustomProviderStatement()
	 * @generated
	 */
	EAttribute getCustomProviderStatement_Provider();

	/**
	 * Returns the meta object for data type '{@link org.polymodel.scop.cgenerator2.MacroBodyProvider <em>Macro Body Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Macro Body Provider</em>'.
	 * @see org.polymodel.scop.cgenerator2.MacroBodyProvider
	 * @model instanceClass="org.polymodel.scop.cgenerator2.MacroBodyProvider"
	 * @generated
	 */
	EDataType getMacroBodyProvider();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PolyIRCGFactory getPolyIRCGFactory();

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
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.CompilationUnitImpl <em>Compilation Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.CompilationUnitImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getCompilationUnit()
		 * @generated
		 */
		EClass COMPILATION_UNIT = eINSTANCE.getCompilationUnit();

		/**
		 * The meta object literal for the '<em><b>Program</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPILATION_UNIT__PROGRAM = eINSTANCE.getCompilationUnit_Program();

		/**
		 * The meta object literal for the '<em><b>Units</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPILATION_UNIT__UNITS = eINSTANCE.getCompilationUnit_Units();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.CodeUnitImpl <em>Code Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.CodeUnitImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getCodeUnit()
		 * @generated
		 */
		EClass CODE_UNIT = eINSTANCE.getCodeUnit();

		/**
		 * The meta object literal for the '<em><b>System</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_UNIT__SYSTEM = eINSTANCE.getCodeUnit_System();

		/**
		 * The meta object literal for the '<em><b>Headers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_UNIT__HEADERS = eINSTANCE.getCodeUnit_Headers();

		/**
		 * The meta object literal for the '<em><b>Functions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_UNIT__FUNCTIONS = eINSTANCE.getCodeUnit_Functions();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_UNIT__VARIABLES = eINSTANCE.getCodeUnit_Variables();

		/**
		 * The meta object literal for the '<em><b>Compilation Unit</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_UNIT__COMPILATION_UNIT = eINSTANCE.getCodeUnit_CompilationUnit();

		/**
		 * The meta object literal for the '<em><b>Local Parameters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_UNIT__LOCAL_PARAMETERS = eINSTANCE.getCodeUnit_LocalParameters();

		/**
		 * The meta object literal for the '<em><b>Compile Time Parameters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_UNIT__COMPILE_TIME_PARAMETERS = eINSTANCE.getCodeUnit_CompileTimeParameters();

		/**
		 * The meta object literal for the '<em><b>Subsystem Functions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_UNIT__SUBSYSTEM_FUNCTIONS = eINSTANCE.getCodeUnit_SubsystemFunctions();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.CodeUnitHeaderImpl <em>Code Unit Header</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.CodeUnitHeaderImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getCodeUnitHeader()
		 * @generated
		 */
		EClass CODE_UNIT_HEADER = eINSTANCE.getCodeUnitHeader();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.BasicCodeUnitHeaderImpl <em>Basic Code Unit Header</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.BasicCodeUnitHeaderImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getBasicCodeUnitHeader()
		 * @generated
		 */
		EClass BASIC_CODE_UNIT_HEADER = eINSTANCE.getBasicCodeUnitHeader();

		/**
		 * The meta object literal for the '<em><b>String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASIC_CODE_UNIT_HEADER__STRING = eINSTANCE.getBasicCodeUnitHeader_String();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.DeclareStructsImpl <em>Declare Structs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.DeclareStructsImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getDeclareStructs()
		 * @generated
		 */
		EClass DECLARE_STRUCTS = eINSTANCE.getDeclareStructs();

		/**
		 * The meta object literal for the '<em><b>Structs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECLARE_STRUCTS__STRUCTS = eINSTANCE.getDeclareStructs_Structs();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.MemoryDomainImpl <em>Memory Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.MemoryDomainImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getMemoryDomain()
		 * @generated
		 */
		EClass MEMORY_DOMAIN = eINSTANCE.getMemoryDomain();

		/**
		 * The meta object literal for the '<em><b>Zero Aligned</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMORY_DOMAIN__ZERO_ALIGNED = eINSTANCE.getMemoryDomain_ZeroAligned();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.ScalarMemoryDomainImpl <em>Scalar Memory Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.ScalarMemoryDomainImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getScalarMemoryDomain()
		 * @generated
		 */
		EClass SCALAR_MEMORY_DOMAIN = eINSTANCE.getScalarMemoryDomain();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.MergedMemoryDomainImpl <em>Merged Memory Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.MergedMemoryDomainImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getMergedMemoryDomain()
		 * @generated
		 */
		EClass MERGED_MEMORY_DOMAIN = eINSTANCE.getMergedMemoryDomain();

		/**
		 * The meta object literal for the '<em><b>Memory Domains</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MERGED_MEMORY_DOMAIN__MEMORY_DOMAINS = eINSTANCE.getMergedMemoryDomain_MemoryDomains();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.PseudoProjectionImpl <em>Pseudo Projection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PseudoProjectionImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getPseudoProjection()
		 * @generated
		 */
		EClass PSEUDO_PROJECTION = eINSTANCE.getPseudoProjection();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PSEUDO_PROJECTION__DOMAIN = eINSTANCE.getPseudoProjection_Domain();

		/**
		 * The meta object literal for the '<em><b>Mod Factors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PSEUDO_PROJECTION__MOD_FACTORS = eINSTANCE.getPseudoProjection_ModFactors();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.Body <em>Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.Body
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getBody()
		 * @generated
		 */
		EClass BODY = eINSTANCE.getBody();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BODY__FUNCTION = eINSTANCE.getBody_Function();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.BasicBodyImpl <em>Basic Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.BasicBodyImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getBasicBody()
		 * @generated
		 */
		EClass BASIC_BODY = eINSTANCE.getBasicBody();

		/**
		 * The meta object literal for the '<em><b>String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASIC_BODY__STRING = eINSTANCE.getBasicBody_String();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.VariableInitializationImpl <em>Variable Initialization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.VariableInitializationImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getVariableInitialization()
		 * @generated
		 */
		EClass VARIABLE_INITIALIZATION = eINSTANCE.getVariableInitialization();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_INITIALIZATION__INPUTS = eINSTANCE.getVariableInitialization_Inputs();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_INITIALIZATION__OUTPUTS = eINSTANCE.getVariableInitialization_Outputs();

		/**
		 * The meta object literal for the '<em><b>Locals</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_INITIALIZATION__LOCALS = eINSTANCE.getVariableInitialization_Locals();

		/**
		 * The meta object literal for the '<em><b>Special Locals</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_INITIALIZATION__SPECIAL_LOCALS = eINSTANCE.getVariableInitialization_SpecialLocals();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.FlagVariableResetImpl <em>Flag Variable Reset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.FlagVariableResetImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getFlagVariableReset()
		 * @generated
		 */
		EClass FLAG_VARIABLE_RESET = eINSTANCE.getFlagVariableReset();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLAG_VARIABLE_RESET__OUTPUTS = eINSTANCE.getFlagVariableReset_Outputs();

		/**
		 * The meta object literal for the '<em><b>Locals</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLAG_VARIABLE_RESET__LOCALS = eINSTANCE.getFlagVariableReset_Locals();

		/**
		 * The meta object literal for the '<em><b>Special Locals</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLAG_VARIABLE_RESET__SPECIAL_LOCALS = eINSTANCE.getFlagVariableReset_SpecialLocals();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.VariableFinalizationImpl <em>Variable Finalization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.VariableFinalizationImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getVariableFinalization()
		 * @generated
		 */
		EClass VARIABLE_FINALIZATION = eINSTANCE.getVariableFinalization();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_FINALIZATION__INPUTS = eINSTANCE.getVariableFinalization_Inputs();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_FINALIZATION__OUTPUTS = eINSTANCE.getVariableFinalization_Outputs();

		/**
		 * The meta object literal for the '<em><b>Locals</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_FINALIZATION__LOCALS = eINSTANCE.getVariableFinalization_Locals();

		/**
		 * The meta object literal for the '<em><b>Special Locals</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_FINALIZATION__SPECIAL_LOCALS = eINSTANCE.getVariableFinalization_SpecialLocals();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.StructManagementImpl <em>Struct Management</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.StructManagementImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getStructManagement()
		 * @generated
		 */
		EClass STRUCT_MANAGEMENT = eINSTANCE.getStructManagement();

		/**
		 * The meta object literal for the '<em><b>Instance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCT_MANAGEMENT__INSTANCE = eINSTANCE.getStructManagement_Instance();

		/**
		 * The meta object literal for the '<em><b>Struct</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCT_MANAGEMENT__STRUCT = eINSTANCE.getStructManagement_Struct();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.PackStructImpl <em>Pack Struct</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PackStructImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getPackStruct()
		 * @generated
		 */
		EClass PACK_STRUCT = eINSTANCE.getPackStruct();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.CustomPackStructImpl <em>Custom Pack Struct</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.CustomPackStructImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getCustomPackStruct()
		 * @generated
		 */
		EClass CUSTOM_PACK_STRUCT = eINSTANCE.getCustomPackStruct();

		/**
		 * The meta object literal for the '<em><b>Init Values</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOM_PACK_STRUCT__INIT_VALUES = eINSTANCE.getCustomPackStruct_InitValues();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.UnpackStructImpl <em>Unpack Struct</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.UnpackStructImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getUnpackStruct()
		 * @generated
		 */
		EClass UNPACK_STRUCT = eINSTANCE.getUnpackStruct();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.LoopImpl <em>Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.LoopImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getLoop()
		 * @generated
		 */
		EClass LOOP = eINSTANCE.getLoop();

		/**
		 * The meta object literal for the '<em><b>Parameter Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP__PARAMETER_DOMAIN = eINSTANCE.getLoop_ParameterDomain();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP__STATEMENTS = eINSTANCE.getLoop_Statements();

		/**
		 * The meta object literal for the '<em><b>Declare Iterators</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOOP__DECLARE_ITERATORS = eINSTANCE.getLoop_DeclareIterators();

		/**
		 * The meta object literal for the '<em><b>Iterator Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOOP__ITERATOR_NAMES = eINSTANCE.getLoop_IteratorNames();

		/**
		 * The meta object literal for the '<em><b>Num Constant Dimensions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOOP__NUM_CONSTANT_DIMENSIONS = eINSTANCE.getLoop_NumConstantDimensions();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.FunctionImpl <em>Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.FunctionImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getFunction()
		 * @generated
		 */
		EClass FUNCTION = eINSTANCE.getFunction();

		/**
		 * The meta object literal for the '<em><b>Codeunit</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__CODEUNIT = eINSTANCE.getFunction_Codeunit();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__NAME = eINSTANCE.getFunction_Name();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__RETURN_TYPE = eINSTANCE.getFunction_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__PARAMETERS = eINSTANCE.getFunction_Parameters();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__INPUTS = eINSTANCE.getFunction_Inputs();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__OUTPUTS = eINSTANCE.getFunction_Outputs();

		/**
		 * The meta object literal for the '<em><b>Locals</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__LOCALS = eINSTANCE.getFunction_Locals();

		/**
		 * The meta object literal for the '<em><b>Bodies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__BODIES = eINSTANCE.getFunction_Bodies();

		/**
		 * The meta object literal for the '<em><b>Entry Point</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__ENTRY_POINT = eINSTANCE.getFunction_EntryPoint();

		/**
		 * The meta object literal for the '<em><b>Signature</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__SIGNATURE = eINSTANCE.getFunction_Signature();

		/**
		 * The meta object literal for the '<em><b>Inlined</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__INLINED = eINSTANCE.getFunction_Inlined();

		/**
		 * The meta object literal for the '<em><b>Number Of Time Iterations For First Condition Check</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__NUMBER_OF_TIME_ITERATIONS_FOR_FIRST_CONDITION_CHECK = eINSTANCE.getFunction_NumberOfTimeIterationsForFirstConditionCheck();

		/**
		 * The meta object literal for the '<em><b>Special Locals</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__SPECIAL_LOCALS = eINSTANCE.getFunction_SpecialLocals();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.FunctionSignatureImpl <em>Function Signature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.FunctionSignatureImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getFunctionSignature()
		 * @generated
		 */
		EClass FUNCTION_SIGNATURE = eINSTANCE.getFunctionSignature();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION_SIGNATURE__NAME = eINSTANCE.getFunctionSignature_Name();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION_SIGNATURE__RETURN_TYPE = eINSTANCE.getFunctionSignature_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_SIGNATURE__PARAMETERS = eINSTANCE.getFunctionSignature_Parameters();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.StructImpl <em>Struct</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.StructImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getStruct()
		 * @generated
		 */
		EClass STRUCT = eINSTANCE.getStruct();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCT__NAME = eINSTANCE.getStruct_Name();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCT__MEMBERS = eINSTANCE.getStruct_Members();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.VariableFunctionParameterImpl <em>Variable Function Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.VariableFunctionParameterImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getVariableFunctionParameter()
		 * @generated
		 */
		EClass VARIABLE_FUNCTION_PARAMETER = eINSTANCE.getVariableFunctionParameter();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_FUNCTION_PARAMETER__VARIABLE = eINSTANCE.getVariableFunctionParameter_Variable();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.AbstractVariableImpl <em>Abstract Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.AbstractVariableImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getAbstractVariable()
		 * @generated
		 */
		EClass ABSTRACT_VARIABLE = eINSTANCE.getAbstractVariable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_VARIABLE__NAME = eINSTANCE.getAbstractVariable_Name();

		/**
		 * The meta object literal for the '<em><b>Codeunit</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_VARIABLE__CODEUNIT = eINSTANCE.getAbstractVariable_Codeunit();

		/**
		 * The meta object literal for the '<em><b>Global</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_VARIABLE__GLOBAL = eINSTANCE.getAbstractVariable_Global();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.BasicVariableImpl <em>Basic Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.BasicVariableImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getBasicVariable()
		 * @generated
		 */
		EClass BASIC_VARIABLE = eINSTANCE.getBasicVariable();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASIC_VARIABLE__TYPE = eINSTANCE.getBasicVariable_Type();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.CodeGenVariableImpl <em>Code Gen Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.CodeGenVariableImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getCodeGenVariable()
		 * @generated
		 */
		EClass CODE_GEN_VARIABLE = eINSTANCE.getCodeGenVariable();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_GEN_VARIABLE__TYPE = eINSTANCE.getCodeGenVariable_Type();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_GEN_VARIABLE__DOMAIN = eINSTANCE.getCodeGenVariable_Domain();

		/**
		 * The meta object literal for the '<em><b>Aligned</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_GEN_VARIABLE__ALIGNED = eINSTANCE.getCodeGenVariable_Aligned();

		/**
		 * The meta object literal for the '<em><b>Flattened</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_GEN_VARIABLE__FLATTENED = eINSTANCE.getCodeGenVariable_Flattened();

		/**
		 * The meta object literal for the '<em><b>Access Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_GEN_VARIABLE__ACCESS_EXPRESSION = eINSTANCE.getCodeGenVariable_AccessExpression();

		/**
		 * The meta object literal for the '<em><b>Isfrontpadded</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_GEN_VARIABLE__ISFRONTPADDED = eINSTANCE.getCodeGenVariable_Isfrontpadded();

		/**
		 * The meta object literal for the '<em><b>Forntpadding Value</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_GEN_VARIABLE__FORNTPADDING_VALUE = eINSTANCE.getCodeGenVariable_ForntpaddingValue();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.Statement <em>Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.Statement
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getStatement()
		 * @generated
		 */
		EClass STATEMENT = eINSTANCE.getStatement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATEMENT__NAME = eINSTANCE.getStatement_Name();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATEMENT__DOMAIN = eINSTANCE.getStatement_Domain();

		/**
		 * The meta object literal for the '<em><b>Container Loop</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATEMENT__CONTAINER_LOOP = eINSTANCE.getStatement_ContainerLoop();

		/**
		 * The meta object literal for the '<em><b>Inlined</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATEMENT__INLINED = eINSTANCE.getStatement_Inlined();

		/**
		 * The meta object literal for the '<em><b>Scattering</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATEMENT__SCATTERING = eINSTANCE.getStatement_Scattering();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.BasicStatementImpl <em>Basic Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.BasicStatementImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getBasicStatement()
		 * @generated
		 */
		EClass BASIC_STATEMENT = eINSTANCE.getBasicStatement();

		/**
		 * The meta object literal for the '<em><b>Statement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASIC_STATEMENT__STATEMENT = eINSTANCE.getBasicStatement_Statement();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.MemoryAccessExpressionImpl <em>Memory Access Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.MemoryAccessExpressionImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getMemoryAccessExpression()
		 * @generated
		 */
		EClass MEMORY_ACCESS_EXPRESSION = eINSTANCE.getMemoryAccessExpression();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMORY_ACCESS_EXPRESSION__VARIABLE = eINSTANCE.getMemoryAccessExpression_Variable();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.PseudoProjectiveAccessExpressionImpl <em>Pseudo Projective Access Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PseudoProjectiveAccessExpressionImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getPseudoProjectiveAccessExpression()
		 * @generated
		 */
		EClass PSEUDO_PROJECTIVE_ACCESS_EXPRESSION = eINSTANCE.getPseudoProjectiveAccessExpression();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.IdentityAccessExpressionImpl <em>Identity Access Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.IdentityAccessExpressionImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getIdentityAccessExpression()
		 * @generated
		 */
		EClass IDENTITY_ACCESS_EXPRESSION = eINSTANCE.getIdentityAccessExpression();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.MergedDomainAccessExpressionImpl <em>Merged Domain Access Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.MergedDomainAccessExpressionImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getMergedDomainAccessExpression()
		 * @generated
		 */
		EClass MERGED_DOMAIN_ACCESS_EXPRESSION = eINSTANCE.getMergedDomainAccessExpression();

		/**
		 * The meta object literal for the '<em><b>Access Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MERGED_DOMAIN_ACCESS_EXPRESSION__ACCESS_EXPRESSION = eINSTANCE.getMergedDomainAccessExpression_AccessExpression();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MERGED_DOMAIN_ACCESS_EXPRESSION__IDENTIFIER = eINSTANCE.getMergedDomainAccessExpression_Identifier();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.CompileTimeParameterImpl <em>Compile Time Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.CompileTimeParameterImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getCompileTimeParameter()
		 * @generated
		 */
		EClass COMPILE_TIME_PARAMETER = eINSTANCE.getCompileTimeParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPILE_TIME_PARAMETER__NAME = eINSTANCE.getCompileTimeParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPILE_TIME_PARAMETER__DEFAULT_VALUE = eINSTANCE.getCompileTimeParameter_DefaultValue();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.impl.CustomProviderStatementImpl <em>Custom Provider Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.CustomProviderStatementImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getCustomProviderStatement()
		 * @generated
		 */
		EClass CUSTOM_PROVIDER_STATEMENT = eINSTANCE.getCustomProviderStatement();

		/**
		 * The meta object literal for the '<em><b>Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOM_PROVIDER_STATEMENT__PROVIDER = eINSTANCE.getCustomProviderStatement_Provider();

		/**
		 * The meta object literal for the '<em>Macro Body Provider</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.scop.cgenerator2.MacroBodyProvider
		 * @see org.polymodel.polyhedralIR.polyIRCG.impl.PolyIRCGPackageImpl#getMacroBodyProvider()
		 * @generated
		 */
		EDataType MACRO_BODY_PROVIDER = eINSTANCE.getMacroBodyProvider();

	}

} //PolyIRCGPackage
