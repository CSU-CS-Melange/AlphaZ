/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.polymodel.polyhedralIR.PolyhedralIRFactory
 * @model kind="package"
 * @generated
 */
public interface PolyhedralIRPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "polyhedralIR";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "polyhedralIR";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "polyhedralIR";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PolyhedralIRPackage eINSTANCE = org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.PolyhedralIRVisitable <em>Visitable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.PolyhedralIRVisitable
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getPolyhedralIRVisitable()
	 * @generated
	 */
	int POLYHEDRAL_IR_VISITABLE = 18;

	/**
	 * The number of structural features of the '<em>Visitable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.impl.ProgramImpl <em>Program</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.impl.ProgramImpl
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getProgram()
	 * @generated
	 */
	int PROGRAM = 0;

	/**
	 * The feature id for the '<em><b>External Function Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__EXTERNAL_FUNCTION_DECLARATIONS = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Systems</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__SYSTEMS = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__TYPES = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Program</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM_FEATURE_COUNT = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.impl.ExternalFunctionDeclarationImpl <em>External Function Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.impl.ExternalFunctionDeclarationImpl
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getExternalFunctionDeclaration()
	 * @generated
	 */
	int EXTERNAL_FUNCTION_DECLARATION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FUNCTION_DECLARATION__NAME = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FUNCTION_DECLARATION__INPUTS = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FUNCTION_DECLARATION__OUTPUT = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>External Function Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_FUNCTION_DECLARATION_FEATURE_COUNT = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.impl.AffineSystemImpl <em>Affine System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.impl.AffineSystemImpl
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getAffineSystem()
	 * @generated
	 */
	int AFFINE_SYSTEM = 2;

	/**
	 * The feature id for the '<em><b>Container Program</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_SYSTEM__CONTAINER_PROGRAM = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_SYSTEM__NAME = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_SYSTEM__PARAMETERS = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_SYSTEM__INPUTS = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_SYSTEM__OUTPUTS = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Locals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_SYSTEM__LOCALS = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Equations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_SYSTEM__EQUATIONS = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Use Equations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_SYSTEM__USE_EQUATIONS = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Target Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_SYSTEM__TARGET_MAPPING = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>While Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_SYSTEM__WHILE_INFO = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Tiling Info</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_SYSTEM__TILING_INFO = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Affine System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_SYSTEM_FEATURE_COUNT = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 11;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.impl.TypeImpl
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 3;

	/**
	 * The feature id for the '<em><b>Signed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__SIGNED = 0;

	/**
	 * The feature id for the '<em><b>Type ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__TYPE_ID = 1;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__WIDTH = 2;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.impl.VariableDeclarationImpl
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getVariableDeclaration()
	 * @generated
	 */
	int VARIABLE_DECLARATION = 4;

	/**
	 * The feature id for the '<em><b>Var ID</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__VAR_ID = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__TYPE = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__DOMAIN = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_FEATURE_COUNT = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.impl.VariableIdentifierImpl <em>Variable Identifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.impl.VariableIdentifierImpl
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getVariableIdentifier()
	 * @generated
	 */
	int VARIABLE_IDENTIFIER = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_IDENTIFIER__NAME = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Identifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_IDENTIFIER_FEATURE_COUNT = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.Equation <em>Equation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.Equation
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getEquation()
	 * @generated
	 */
	int EQUATION = 6;

	/**
	 * The number of structural features of the '<em>Equation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_FEATURE_COUNT = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.impl.UseEquationImpl <em>Use Equation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.impl.UseEquationImpl
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getUseEquation()
	 * @generated
	 */
	int USE_EQUATION = 7;

	/**
	 * The feature id for the '<em><b>Extension Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_EQUATION__EXTENSION_DOMAIN = EQUATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_EQUATION__PARAMETERS = EQUATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_EQUATION__INPUTS = EQUATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_EQUATION__OUTPUTS = EQUATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Sub System</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_EQUATION__SUB_SYSTEM = EQUATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Container System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_EQUATION__CONTAINER_SYSTEM = EQUATION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_EQUATION__LABEL = EQUATION_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Use Equation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_EQUATION_FEATURE_COUNT = EQUATION_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.impl.StandardEquationImpl <em>Standard Equation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.impl.StandardEquationImpl
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getStandardEquation()
	 * @generated
	 */
	int STANDARD_EQUATION = 8;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_EQUATION__VARIABLE = EQUATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_EQUATION__EXPRESSION = EQUATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Container System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_EQUATION__CONTAINER_SYSTEM = EQUATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Standard Equation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_EQUATION_FEATURE_COUNT = EQUATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.impl.DomainImpl <em>Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.impl.DomainImpl
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getDomain()
	 * @generated
	 */
	int DOMAIN = 9;

	/**
	 * The feature id for the '<em><b>PMdomain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__PMDOMAIN = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_FEATURE_COUNT = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.impl.ParameterDomainImpl <em>Parameter Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.impl.ParameterDomainImpl
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getParameterDomain()
	 * @generated
	 */
	int PARAMETER_DOMAIN = 10;

	/**
	 * The feature id for the '<em><b>PMdomain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DOMAIN__PMDOMAIN = DOMAIN__PMDOMAIN;

	/**
	 * The number of structural features of the '<em>Parameter Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DOMAIN_FEATURE_COUNT = DOMAIN_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.impl.AffineFunctionImpl <em>Affine Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.impl.AffineFunctionImpl
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getAffineFunction()
	 * @generated
	 */
	int AFFINE_FUNCTION = 11;

	/**
	 * The feature id for the '<em><b>PMmapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_FUNCTION__PMMAPPING = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Affine Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFINE_FUNCTION_FEATURE_COUNT = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.impl.ExpressionImpl
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 12;

	/**
	 * The feature id for the '<em><b>Context Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__CONTEXT_DOMAIN = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__EXPRESSION_DOMAIN = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Expression Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__EXPRESSION_TYPE = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.impl.FastISLDomainImpl <em>Fast ISL Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.impl.FastISLDomainImpl
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getFastISLDomain()
	 * @generated
	 */
	int FAST_ISL_DOMAIN = 13;

	/**
	 * The feature id for the '<em><b>PMdomain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAST_ISL_DOMAIN__PMDOMAIN = DOMAIN__PMDOMAIN;

	/**
	 * The feature id for the '<em><b>Isl Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAST_ISL_DOMAIN__ISL_SET = DOMAIN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dom Dims</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAST_ISL_DOMAIN__DOM_DIMS = DOMAIN_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Fast ISL Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAST_ISL_DOMAIN_FEATURE_COUNT = DOMAIN_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.impl.FastISLMapImpl <em>Fast ISL Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.impl.FastISLMapImpl
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getFastISLMap()
	 * @generated
	 */
	int FAST_ISL_MAP = 14;

	/**
	 * The feature id for the '<em><b>PMmapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAST_ISL_MAP__PMMAPPING = AFFINE_FUNCTION__PMMAPPING;

	/**
	 * The feature id for the '<em><b>Isl Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAST_ISL_MAP__ISL_MAP = AFFINE_FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dom Dims</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAST_ISL_MAP__DOM_DIMS = AFFINE_FUNCTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Label In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAST_ISL_MAP__LABEL_IN = AFFINE_FUNCTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Label Out</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAST_ISL_MAP__LABEL_OUT = AFFINE_FUNCTION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Fast ISL Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FAST_ISL_MAP_FEATURE_COUNT = AFFINE_FUNCTION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.impl.WhileInfoImpl <em>While Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.impl.WhileInfoImpl
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getWhileInfo()
	 * @generated
	 */
	int WHILE_INFO = 15;

	/**
	 * The feature id for the '<em><b>Time Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_INFO__TIME_DOMAIN = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_INFO__CONDITION = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Container System</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_INFO__CONTAINER_SYSTEM = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>While Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_INFO_FEATURE_COUNT = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.impl.TilingInformationsImpl <em>Tiling Informations</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.impl.TilingInformationsImpl
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getTilingInformations()
	 * @generated
	 */
	int TILING_INFORMATIONS = 16;

	/**
	 * The feature id for the '<em><b>Ratios</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILING_INFORMATIONS__RATIOS = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Min Param Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILING_INFORMATIONS__MIN_PARAM_VALUES = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tile Groups</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILING_INFORMATIONS__TILE_GROUPS = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Cob Preprocess</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILING_INFORMATIONS__COB_PREPROCESS = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Tiling Informations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TILING_INFORMATIONS_FEATURE_COUNT = POLYHEDRAL_IR_VISITABLE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.PolyhedralIRVisitor <em>Visitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.PolyhedralIRVisitor
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getPolyhedralIRVisitor()
	 * @generated
	 */
	int POLYHEDRAL_IR_VISITOR = 17;

	/**
	 * The number of structural features of the '<em>Visitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYHEDRAL_IR_VISITOR_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.impl.PolyhedralIRDepthFirstVisitorImpl <em>Depth First Visitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRDepthFirstVisitorImpl
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getPolyhedralIRDepthFirstVisitor()
	 * @generated
	 */
	int POLYHEDRAL_IR_DEPTH_FIRST_VISITOR = 19;

	/**
	 * The number of structural features of the '<em>Depth First Visitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYHEDRAL_IR_DEPTH_FIRST_VISITOR_FEATURE_COUNT = POLYHEDRAL_IR_VISITOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.impl.PolyhedralIRInheritedDepthFirstVisitorImpl <em>Inherited Depth First Visitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRInheritedDepthFirstVisitorImpl
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getPolyhedralIRInheritedDepthFirstVisitor()
	 * @generated
	 */
	int POLYHEDRAL_IR_INHERITED_DEPTH_FIRST_VISITOR = 20;

	/**
	 * The number of structural features of the '<em>Inherited Depth First Visitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYHEDRAL_IR_INHERITED_DEPTH_FIRST_VISITOR_FEATURE_COUNT = POLYHEDRAL_IR_VISITOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.SIGNED <em>SIGNED</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.SIGNED
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getSIGNED()
	 * @generated
	 */
	int SIGNED = 21;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.DATATYPE <em>DATATYPE</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.DATATYPE
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getDATATYPE()
	 * @generated
	 */
	int DATATYPE = 22;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.OP <em>OP</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.OP
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getOP()
	 * @generated
	 */
	int OP = 23;


	/**
	 * The meta object id for the '<em>JNIISL Set</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getJNIISLSet()
	 * @generated
	 */
	int JNIISL_SET = 24;

	/**
	 * The meta object id for the '<em>JNIISL Basic Map</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getJNIISLBasicMap()
	 * @generated
	 */
	int JNIISL_BASIC_MAP = 25;

	/**
	 * The meta object id for the '<em>long Matrix</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getlongMatrix()
	 * @generated
	 */
	int LONG_MATRIX = 26;

	/**
	 * The meta object id for the '<em>List String</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see org.polymodel.polyhedralIR.impl.PolyhedralIRPackageImpl#getListString()
	 * @generated
	 */
	int LIST_STRING = 27;

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.Program <em>Program</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Program</em>'.
	 * @see org.polymodel.polyhedralIR.Program
	 * @generated
	 */
	EClass getProgram();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.Program#getExternalFunctionDeclarations <em>External Function Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>External Function Declarations</em>'.
	 * @see org.polymodel.polyhedralIR.Program#getExternalFunctionDeclarations()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_ExternalFunctionDeclarations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.Program#getSystems <em>Systems</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Systems</em>'.
	 * @see org.polymodel.polyhedralIR.Program#getSystems()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_Systems();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.Program#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see org.polymodel.polyhedralIR.Program#getTypes()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_Types();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.ExternalFunctionDeclaration <em>External Function Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Function Declaration</em>'.
	 * @see org.polymodel.polyhedralIR.ExternalFunctionDeclaration
	 * @generated
	 */
	EClass getExternalFunctionDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.ExternalFunctionDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polymodel.polyhedralIR.ExternalFunctionDeclaration#getName()
	 * @see #getExternalFunctionDeclaration()
	 * @generated
	 */
	EAttribute getExternalFunctionDeclaration_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.ExternalFunctionDeclaration#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inputs</em>'.
	 * @see org.polymodel.polyhedralIR.ExternalFunctionDeclaration#getInputs()
	 * @see #getExternalFunctionDeclaration()
	 * @generated
	 */
	EReference getExternalFunctionDeclaration_Inputs();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.ExternalFunctionDeclaration#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Output</em>'.
	 * @see org.polymodel.polyhedralIR.ExternalFunctionDeclaration#getOutput()
	 * @see #getExternalFunctionDeclaration()
	 * @generated
	 */
	EReference getExternalFunctionDeclaration_Output();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.AffineSystem <em>Affine System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Affine System</em>'.
	 * @see org.polymodel.polyhedralIR.AffineSystem
	 * @generated
	 */
	EClass getAffineSystem();

	/**
	 * Returns the meta object for the container reference '{@link org.polymodel.polyhedralIR.AffineSystem#getContainerProgram <em>Container Program</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container Program</em>'.
	 * @see org.polymodel.polyhedralIR.AffineSystem#getContainerProgram()
	 * @see #getAffineSystem()
	 * @generated
	 */
	EReference getAffineSystem_ContainerProgram();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.AffineSystem#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polymodel.polyhedralIR.AffineSystem#getName()
	 * @see #getAffineSystem()
	 * @generated
	 */
	EAttribute getAffineSystem_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.AffineSystem#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parameters</em>'.
	 * @see org.polymodel.polyhedralIR.AffineSystem#getParameters()
	 * @see #getAffineSystem()
	 * @generated
	 */
	EReference getAffineSystem_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.AffineSystem#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see org.polymodel.polyhedralIR.AffineSystem#getInputs()
	 * @see #getAffineSystem()
	 * @generated
	 */
	EReference getAffineSystem_Inputs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.AffineSystem#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outputs</em>'.
	 * @see org.polymodel.polyhedralIR.AffineSystem#getOutputs()
	 * @see #getAffineSystem()
	 * @generated
	 */
	EReference getAffineSystem_Outputs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.AffineSystem#getLocals <em>Locals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Locals</em>'.
	 * @see org.polymodel.polyhedralIR.AffineSystem#getLocals()
	 * @see #getAffineSystem()
	 * @generated
	 */
	EReference getAffineSystem_Locals();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.AffineSystem#getEquations <em>Equations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Equations</em>'.
	 * @see org.polymodel.polyhedralIR.AffineSystem#getEquations()
	 * @see #getAffineSystem()
	 * @generated
	 */
	EReference getAffineSystem_Equations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.AffineSystem#getUseEquations <em>Use Equations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Use Equations</em>'.
	 * @see org.polymodel.polyhedralIR.AffineSystem#getUseEquations()
	 * @see #getAffineSystem()
	 * @generated
	 */
	EReference getAffineSystem_UseEquations();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.AffineSystem#getTargetMapping <em>Target Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target Mapping</em>'.
	 * @see org.polymodel.polyhedralIR.AffineSystem#getTargetMapping()
	 * @see #getAffineSystem()
	 * @generated
	 */
	EReference getAffineSystem_TargetMapping();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.AffineSystem#getWhileInfo <em>While Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>While Info</em>'.
	 * @see org.polymodel.polyhedralIR.AffineSystem#getWhileInfo()
	 * @see #getAffineSystem()
	 * @generated
	 */
	EReference getAffineSystem_WhileInfo();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.AffineSystem#getTilingInfo <em>Tiling Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tiling Info</em>'.
	 * @see org.polymodel.polyhedralIR.AffineSystem#getTilingInfo()
	 * @see #getAffineSystem()
	 * @generated
	 */
	EReference getAffineSystem_TilingInfo();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see org.polymodel.polyhedralIR.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.Type#getSigned <em>Signed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Signed</em>'.
	 * @see org.polymodel.polyhedralIR.Type#getSigned()
	 * @see #getType()
	 * @generated
	 */
	EAttribute getType_Signed();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.Type#getTypeID <em>Type ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type ID</em>'.
	 * @see org.polymodel.polyhedralIR.Type#getTypeID()
	 * @see #getType()
	 * @generated
	 */
	EAttribute getType_TypeID();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.Type#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.polymodel.polyhedralIR.Type#getWidth()
	 * @see #getType()
	 * @generated
	 */
	EAttribute getType_Width();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration</em>'.
	 * @see org.polymodel.polyhedralIR.VariableDeclaration
	 * @generated
	 */
	EClass getVariableDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.VariableDeclaration#getVarID <em>Var ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Var ID</em>'.
	 * @see org.polymodel.polyhedralIR.VariableDeclaration#getVarID()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EReference getVariableDeclaration_VarID();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.VariableDeclaration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.polymodel.polyhedralIR.VariableDeclaration#getType()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EReference getVariableDeclaration_Type();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.VariableDeclaration#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domain</em>'.
	 * @see org.polymodel.polyhedralIR.VariableDeclaration#getDomain()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EReference getVariableDeclaration_Domain();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.VariableIdentifier <em>Variable Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Identifier</em>'.
	 * @see org.polymodel.polyhedralIR.VariableIdentifier
	 * @generated
	 */
	EClass getVariableIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.VariableIdentifier#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polymodel.polyhedralIR.VariableIdentifier#getName()
	 * @see #getVariableIdentifier()
	 * @generated
	 */
	EAttribute getVariableIdentifier_Name();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.Equation <em>Equation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equation</em>'.
	 * @see org.polymodel.polyhedralIR.Equation
	 * @generated
	 */
	EClass getEquation();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.UseEquation <em>Use Equation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Equation</em>'.
	 * @see org.polymodel.polyhedralIR.UseEquation
	 * @generated
	 */
	EClass getUseEquation();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.UseEquation#getExtensionDomain <em>Extension Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extension Domain</em>'.
	 * @see org.polymodel.polyhedralIR.UseEquation#getExtensionDomain()
	 * @see #getUseEquation()
	 * @generated
	 */
	EReference getUseEquation_ExtensionDomain();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.UseEquation#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parameters</em>'.
	 * @see org.polymodel.polyhedralIR.UseEquation#getParameters()
	 * @see #getUseEquation()
	 * @generated
	 */
	EReference getUseEquation_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.polyhedralIR.UseEquation#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see org.polymodel.polyhedralIR.UseEquation#getInputs()
	 * @see #getUseEquation()
	 * @generated
	 */
	EReference getUseEquation_Inputs();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.UseEquation#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outputs</em>'.
	 * @see org.polymodel.polyhedralIR.UseEquation#getOutputs()
	 * @see #getUseEquation()
	 * @generated
	 */
	EReference getUseEquation_Outputs();

	/**
	 * Returns the meta object for the container reference '{@link org.polymodel.polyhedralIR.UseEquation#getContainerSystem <em>Container System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container System</em>'.
	 * @see org.polymodel.polyhedralIR.UseEquation#getContainerSystem()
	 * @see #getUseEquation()
	 * @generated
	 */
	EReference getUseEquation_ContainerSystem();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.UseEquation#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.polymodel.polyhedralIR.UseEquation#getLabel()
	 * @see #getUseEquation()
	 * @generated
	 */
	EAttribute getUseEquation_Label();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.UseEquation#getSubSystem <em>Sub System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sub System</em>'.
	 * @see org.polymodel.polyhedralIR.UseEquation#getSubSystem()
	 * @see #getUseEquation()
	 * @generated
	 */
	EReference getUseEquation_SubSystem();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.StandardEquation <em>Standard Equation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Standard Equation</em>'.
	 * @see org.polymodel.polyhedralIR.StandardEquation
	 * @generated
	 */
	EClass getStandardEquation();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.StandardEquation#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see org.polymodel.polyhedralIR.StandardEquation#getVariable()
	 * @see #getStandardEquation()
	 * @generated
	 */
	EReference getStandardEquation_Variable();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.StandardEquation#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.polymodel.polyhedralIR.StandardEquation#getExpression()
	 * @see #getStandardEquation()
	 * @generated
	 */
	EReference getStandardEquation_Expression();

	/**
	 * Returns the meta object for the container reference '{@link org.polymodel.polyhedralIR.StandardEquation#getContainerSystem <em>Container System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container System</em>'.
	 * @see org.polymodel.polyhedralIR.StandardEquation#getContainerSystem()
	 * @see #getStandardEquation()
	 * @generated
	 */
	EReference getStandardEquation_ContainerSystem();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.Domain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain</em>'.
	 * @see org.polymodel.polyhedralIR.Domain
	 * @generated
	 */
	EClass getDomain();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.Domain#getPMdomain <em>PMdomain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>PMdomain</em>'.
	 * @see org.polymodel.polyhedralIR.Domain#getPMdomain()
	 * @see #getDomain()
	 * @generated
	 */
	EReference getDomain_PMdomain();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.ParameterDomain <em>Parameter Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Domain</em>'.
	 * @see org.polymodel.polyhedralIR.ParameterDomain
	 * @generated
	 */
	EClass getParameterDomain();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.AffineFunction <em>Affine Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Affine Function</em>'.
	 * @see org.polymodel.polyhedralIR.AffineFunction
	 * @generated
	 */
	EClass getAffineFunction();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.AffineFunction#getPMmapping <em>PMmapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>PMmapping</em>'.
	 * @see org.polymodel.polyhedralIR.AffineFunction#getPMmapping()
	 * @see #getAffineFunction()
	 * @generated
	 */
	EReference getAffineFunction_PMmapping();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see org.polymodel.polyhedralIR.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.Expression#getContextDomain <em>Context Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Context Domain</em>'.
	 * @see org.polymodel.polyhedralIR.Expression#getContextDomain()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_ContextDomain();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.Expression#getExpressionDomain <em>Expression Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression Domain</em>'.
	 * @see org.polymodel.polyhedralIR.Expression#getExpressionDomain()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_ExpressionDomain();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.Expression#getExpressionType <em>Expression Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expression Type</em>'.
	 * @see org.polymodel.polyhedralIR.Expression#getExpressionType()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_ExpressionType();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.FastISLDomain <em>Fast ISL Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fast ISL Domain</em>'.
	 * @see org.polymodel.polyhedralIR.FastISLDomain
	 * @generated
	 */
	EClass getFastISLDomain();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.FastISLDomain#getIslSet <em>Isl Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Isl Set</em>'.
	 * @see org.polymodel.polyhedralIR.FastISLDomain#getIslSet()
	 * @see #getFastISLDomain()
	 * @generated
	 */
	EAttribute getFastISLDomain_IslSet();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.FastISLDomain#getDomDims <em>Dom Dims</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dom Dims</em>'.
	 * @see org.polymodel.polyhedralIR.FastISLDomain#getDomDims()
	 * @see #getFastISLDomain()
	 * @generated
	 */
	EReference getFastISLDomain_DomDims();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.FastISLMap <em>Fast ISL Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fast ISL Map</em>'.
	 * @see org.polymodel.polyhedralIR.FastISLMap
	 * @generated
	 */
	EClass getFastISLMap();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.FastISLMap#getIslMap <em>Isl Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Isl Map</em>'.
	 * @see org.polymodel.polyhedralIR.FastISLMap#getIslMap()
	 * @see #getFastISLMap()
	 * @generated
	 */
	EAttribute getFastISLMap_IslMap();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.FastISLMap#getDomDims <em>Dom Dims</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dom Dims</em>'.
	 * @see org.polymodel.polyhedralIR.FastISLMap#getDomDims()
	 * @see #getFastISLMap()
	 * @generated
	 */
	EReference getFastISLMap_DomDims();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.FastISLMap#getLabelIn <em>Label In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Label In</em>'.
	 * @see org.polymodel.polyhedralIR.FastISLMap#getLabelIn()
	 * @see #getFastISLMap()
	 * @generated
	 */
	EReference getFastISLMap_LabelIn();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.FastISLMap#getLabelOut <em>Label Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Label Out</em>'.
	 * @see org.polymodel.polyhedralIR.FastISLMap#getLabelOut()
	 * @see #getFastISLMap()
	 * @generated
	 */
	EReference getFastISLMap_LabelOut();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.WhileInfo <em>While Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>While Info</em>'.
	 * @see org.polymodel.polyhedralIR.WhileInfo
	 * @generated
	 */
	EClass getWhileInfo();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.WhileInfo#getTimeDomain <em>Time Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Time Domain</em>'.
	 * @see org.polymodel.polyhedralIR.WhileInfo#getTimeDomain()
	 * @see #getWhileInfo()
	 * @generated
	 */
	EReference getWhileInfo_TimeDomain();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.polyhedralIR.WhileInfo#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.polymodel.polyhedralIR.WhileInfo#getCondition()
	 * @see #getWhileInfo()
	 * @generated
	 */
	EReference getWhileInfo_Condition();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.WhileInfo#getContainerSystem <em>Container System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Container System</em>'.
	 * @see org.polymodel.polyhedralIR.WhileInfo#getContainerSystem()
	 * @see #getWhileInfo()
	 * @generated
	 */
	EReference getWhileInfo_ContainerSystem();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.TilingInformations <em>Tiling Informations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tiling Informations</em>'.
	 * @see org.polymodel.polyhedralIR.TilingInformations
	 * @generated
	 */
	EClass getTilingInformations();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.TilingInformations#getRatios <em>Ratios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ratios</em>'.
	 * @see org.polymodel.polyhedralIR.TilingInformations#getRatios()
	 * @see #getTilingInformations()
	 * @generated
	 */
	EAttribute getTilingInformations_Ratios();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.TilingInformations#getMinParamValues <em>Min Param Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Param Values</em>'.
	 * @see org.polymodel.polyhedralIR.TilingInformations#getMinParamValues()
	 * @see #getTilingInformations()
	 * @generated
	 */
	EAttribute getTilingInformations_MinParamValues();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.TilingInformations#getTileGroups <em>Tile Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tile Groups</em>'.
	 * @see org.polymodel.polyhedralIR.TilingInformations#getTileGroups()
	 * @see #getTilingInformations()
	 * @generated
	 */
	EAttribute getTilingInformations_TileGroups();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.TilingInformations#getCobPreprocess <em>Cob Preprocess</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cob Preprocess</em>'.
	 * @see org.polymodel.polyhedralIR.TilingInformations#getCobPreprocess()
	 * @see #getTilingInformations()
	 * @generated
	 */
	EAttribute getTilingInformations_CobPreprocess();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.PolyhedralIRVisitor <em>Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitor</em>'.
	 * @see org.polymodel.polyhedralIR.PolyhedralIRVisitor
	 * @generated
	 */
	EClass getPolyhedralIRVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.PolyhedralIRVisitable <em>Visitable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitable</em>'.
	 * @see org.polymodel.polyhedralIR.PolyhedralIRVisitable
	 * @generated
	 */
	EClass getPolyhedralIRVisitable();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.PolyhedralIRDepthFirstVisitor <em>Depth First Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Depth First Visitor</em>'.
	 * @see org.polymodel.polyhedralIR.PolyhedralIRDepthFirstVisitor
	 * @generated
	 */
	EClass getPolyhedralIRDepthFirstVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.PolyhedralIRInheritedDepthFirstVisitor <em>Inherited Depth First Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inherited Depth First Visitor</em>'.
	 * @see org.polymodel.polyhedralIR.PolyhedralIRInheritedDepthFirstVisitor
	 * @generated
	 */
	EClass getPolyhedralIRInheritedDepthFirstVisitor();

	/**
	 * Returns the meta object for enum '{@link org.polymodel.polyhedralIR.SIGNED <em>SIGNED</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>SIGNED</em>'.
	 * @see org.polymodel.polyhedralIR.SIGNED
	 * @generated
	 */
	EEnum getSIGNED();

	/**
	 * Returns the meta object for enum '{@link org.polymodel.polyhedralIR.DATATYPE <em>DATATYPE</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>DATATYPE</em>'.
	 * @see org.polymodel.polyhedralIR.DATATYPE
	 * @generated
	 */
	EEnum getDATATYPE();

	/**
	 * Returns the meta object for enum '{@link org.polymodel.polyhedralIR.OP <em>OP</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>OP</em>'.
	 * @see org.polymodel.polyhedralIR.OP
	 * @generated
	 */
	EEnum getOP();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>JNIISL Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>JNIISL Set</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getJNIISLSet();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>JNIISL Basic Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>JNIISL Basic Map</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object"
	 * @generated
	 */
	EDataType getJNIISLBasicMap();

	/**
	 * Returns the meta object for data type '<em>long Matrix</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>long Matrix</em>'.
	 * @model instanceClass="long[][]"
	 * @generated
	 */
	EDataType getlongMatrix();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>List String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>List String</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object<java.lang.Object>"
	 * @generated
	 */
	EDataType getListString();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PolyhedralIRFactory getPolyhedralIRFactory();

} //PolyhedralIRPackage
