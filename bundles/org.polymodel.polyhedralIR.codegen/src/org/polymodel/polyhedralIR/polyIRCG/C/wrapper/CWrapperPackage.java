/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.wrapper;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
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
 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.CWrapperFactory
 * @model kind="package"
 * @generated
 */
public interface CWrapperPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "wrapper";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "wrapper";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "wrapper";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CWrapperPackage eINSTANCE = org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.CWrapperPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.InputInitializationImpl <em>Input Initialization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.InputInitializationImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.CWrapperPackageImpl#getInputInitialization()
	 * @generated
	 */
	int INPUT_INITIALIZATION = 0;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_INITIALIZATION__FUNCTION = CPackage.CLOOP__FUNCTION;

	/**
	 * The feature id for the '<em><b>Parameter Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_INITIALIZATION__PARAMETER_DOMAIN = CPackage.CLOOP__PARAMETER_DOMAIN;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_INITIALIZATION__STATEMENTS = CPackage.CLOOP__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Declare Iterators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_INITIALIZATION__DECLARE_ITERATORS = CPackage.CLOOP__DECLARE_ITERATORS;

	/**
	 * The feature id for the '<em><b>Iterator Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_INITIALIZATION__ITERATOR_NAMES = CPackage.CLOOP__ITERATOR_NAMES;

	/**
	 * The feature id for the '<em><b>Num Constant Dimensions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_INITIALIZATION__NUM_CONSTANT_DIMENSIONS = CPackage.CLOOP__NUM_CONSTANT_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Use Macros</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_INITIALIZATION__USE_MACROS = CPackage.CLOOP__USE_MACROS;

	/**
	 * The feature id for the '<em><b>Special Var</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_INITIALIZATION__SPECIAL_VAR = CPackage.CLOOP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Input Initialization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_INITIALIZATION_FEATURE_COUNT = CPackage.CLOOP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.OutputPrintingImpl <em>Output Printing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.OutputPrintingImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.CWrapperPackageImpl#getOutputPrinting()
	 * @generated
	 */
	int OUTPUT_PRINTING = 1;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PRINTING__FUNCTION = CPackage.CLOOP__FUNCTION;

	/**
	 * The feature id for the '<em><b>Parameter Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PRINTING__PARAMETER_DOMAIN = CPackage.CLOOP__PARAMETER_DOMAIN;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PRINTING__STATEMENTS = CPackage.CLOOP__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Declare Iterators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PRINTING__DECLARE_ITERATORS = CPackage.CLOOP__DECLARE_ITERATORS;

	/**
	 * The feature id for the '<em><b>Iterator Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PRINTING__ITERATOR_NAMES = CPackage.CLOOP__ITERATOR_NAMES;

	/**
	 * The feature id for the '<em><b>Num Constant Dimensions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PRINTING__NUM_CONSTANT_DIMENSIONS = CPackage.CLOOP__NUM_CONSTANT_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Use Macros</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PRINTING__USE_MACROS = CPackage.CLOOP__USE_MACROS;

	/**
	 * The feature id for the '<em><b>Special Var</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PRINTING__SPECIAL_VAR = CPackage.CLOOP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Output Printing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PRINTING_FEATURE_COUNT = CPackage.CLOOP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.OutputVerificationImpl <em>Output Verification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.OutputVerificationImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.CWrapperPackageImpl#getOutputVerification()
	 * @generated
	 */
	int OUTPUT_VERIFICATION = 2;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VERIFICATION__FUNCTION = CPackage.CLOOP__FUNCTION;

	/**
	 * The feature id for the '<em><b>Parameter Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VERIFICATION__PARAMETER_DOMAIN = CPackage.CLOOP__PARAMETER_DOMAIN;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VERIFICATION__STATEMENTS = CPackage.CLOOP__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Declare Iterators</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VERIFICATION__DECLARE_ITERATORS = CPackage.CLOOP__DECLARE_ITERATORS;

	/**
	 * The feature id for the '<em><b>Iterator Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VERIFICATION__ITERATOR_NAMES = CPackage.CLOOP__ITERATOR_NAMES;

	/**
	 * The feature id for the '<em><b>Num Constant Dimensions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VERIFICATION__NUM_CONSTANT_DIMENSIONS = CPackage.CLOOP__NUM_CONSTANT_DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Use Macros</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VERIFICATION__USE_MACROS = CPackage.CLOOP__USE_MACROS;

	/**
	 * The feature id for the '<em><b>Special Var</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VERIFICATION__SPECIAL_VAR = CPackage.CLOOP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Output Verification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VERIFICATION_FEATURE_COUNT = CPackage.CLOOP_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.SpecialVariableImpl <em>Special Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.SpecialVariableImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.CWrapperPackageImpl#getSpecialVariable()
	 * @generated
	 */
	int SPECIAL_VARIABLE = 3;

	/**
	 * The feature id for the '<em><b>Var Decl</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_VARIABLE__VAR_DECL = 0;

	/**
	 * The feature id for the '<em><b>Access</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_VARIABLE__ACCESS = 1;

	/**
	 * The number of structural features of the '<em>Special Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIAL_VARIABLE_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.wrapper.InputInitialization <em>Input Initialization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Initialization</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.InputInitialization
	 * @generated
	 */
	EClass getInputInitialization();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.wrapper.InputInitialization#getSpecialVar <em>Special Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Special Var</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.InputInitialization#getSpecialVar()
	 * @see #getInputInitialization()
	 * @generated
	 */
	EReference getInputInitialization_SpecialVar();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputPrinting <em>Output Printing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Printing</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputPrinting
	 * @generated
	 */
	EClass getOutputPrinting();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputPrinting#getSpecialVar <em>Special Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Special Var</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputPrinting#getSpecialVar()
	 * @see #getOutputPrinting()
	 * @generated
	 */
	EReference getOutputPrinting_SpecialVar();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputVerification <em>Output Verification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Verification</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputVerification
	 * @generated
	 */
	EClass getOutputVerification();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputVerification#getSpecialVar <em>Special Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Special Var</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.OutputVerification#getSpecialVar()
	 * @see #getOutputVerification()
	 * @generated
	 */
	EReference getOutputVerification_SpecialVar();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.wrapper.SpecialVariable <em>Special Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Special Variable</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.SpecialVariable
	 * @generated
	 */
	EClass getSpecialVariable();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.wrapper.SpecialVariable#getVarDecl <em>Var Decl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Var Decl</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.SpecialVariable#getVarDecl()
	 * @see #getSpecialVariable()
	 * @generated
	 */
	EReference getSpecialVariable_VarDecl();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.wrapper.SpecialVariable#getAccess <em>Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Access</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.SpecialVariable#getAccess()
	 * @see #getSpecialVariable()
	 * @generated
	 */
	EReference getSpecialVariable_Access();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CWrapperFactory getCWrapperFactory();

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
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.InputInitializationImpl <em>Input Initialization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.InputInitializationImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.CWrapperPackageImpl#getInputInitialization()
		 * @generated
		 */
		EClass INPUT_INITIALIZATION = eINSTANCE.getInputInitialization();

		/**
		 * The meta object literal for the '<em><b>Special Var</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_INITIALIZATION__SPECIAL_VAR = eINSTANCE.getInputInitialization_SpecialVar();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.OutputPrintingImpl <em>Output Printing</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.OutputPrintingImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.CWrapperPackageImpl#getOutputPrinting()
		 * @generated
		 */
		EClass OUTPUT_PRINTING = eINSTANCE.getOutputPrinting();

		/**
		 * The meta object literal for the '<em><b>Special Var</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_PRINTING__SPECIAL_VAR = eINSTANCE.getOutputPrinting_SpecialVar();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.OutputVerificationImpl <em>Output Verification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.OutputVerificationImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.CWrapperPackageImpl#getOutputVerification()
		 * @generated
		 */
		EClass OUTPUT_VERIFICATION = eINSTANCE.getOutputVerification();

		/**
		 * The meta object literal for the '<em><b>Special Var</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_VERIFICATION__SPECIAL_VAR = eINSTANCE.getOutputVerification_SpecialVar();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.SpecialVariableImpl <em>Special Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.SpecialVariableImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.wrapper.impl.CWrapperPackageImpl#getSpecialVariable()
		 * @generated
		 */
		EClass SPECIAL_VARIABLE = eINSTANCE.getSpecialVariable();

		/**
		 * The meta object literal for the '<em><b>Var Decl</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIAL_VARIABLE__VAR_DECL = eINSTANCE.getSpecialVariable_VarDecl();

		/**
		 * The meta object literal for the '<em><b>Access</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIAL_VARIABLE__ACCESS = eINSTANCE.getSpecialVariable_Access();

	}

} //CWrapperPackage
