/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package commandIF;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see commandIF.CommandIFFactory
 * @model kind="package"
 * @generated
 */
public interface CommandIFPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "commandIF";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://alphaz/commandIF";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "commandIF";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommandIFPackage eINSTANCE = commandIF.impl.CommandIFPackageImpl.init();

	/**
	 * The meta object id for the '{@link commandIF.impl.CategoryImpl <em>Category</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see commandIF.impl.CategoryImpl
	 * @see commandIF.impl.CommandIFPackageImpl#getCategory()
	 * @generated
	 */
	int CATEGORY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Command Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__COMMAND_PREFIX = 2;

	/**
	 * The feature id for the '<em><b>Subcategories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__SUBCATEGORIES = 3;

	/**
	 * The feature id for the '<em><b>Commands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__COMMANDS = 4;

	/**
	 * The number of structural features of the '<em>Category</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link commandIF.impl.CommandImpl <em>Command</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see commandIF.impl.CommandImpl
	 * @see commandIF.impl.CommandIFPackageImpl#getCommand()
	 * @generated
	 */
	int COMMAND = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Overloads</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND__OVERLOADS = 1;

	/**
	 * The feature id for the '<em><b>User Command</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND__USER_COMMAND = 2;

	/**
	 * The number of structural features of the '<em>Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link commandIF.impl.BasicCommandImpl <em>Basic Command</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see commandIF.impl.BasicCommandImpl
	 * @see commandIF.impl.CommandIFPackageImpl#getBasicCommand()
	 * @generated
	 */
	int BASIC_COMMAND = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMMAND__DESCRIPTION = COMMAND__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Overloads</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMMAND__OVERLOADS = COMMAND__OVERLOADS;

	/**
	 * The feature id for the '<em><b>User Command</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMMAND__USER_COMMAND = COMMAND__USER_COMMAND;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMMAND__NAME = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMMAND__INPUTS = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMMAND__OUTPUT = COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Basic Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMMAND_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link commandIF.impl.OverloadingImpl <em>Overloading</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see commandIF.impl.OverloadingImpl
	 * @see commandIF.impl.CommandIFPackageImpl#getOverloading()
	 * @generated
	 */
	int OVERLOADING = 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVERLOADING__DESCRIPTION = COMMAND__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Overloads</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVERLOADING__OVERLOADS = COMMAND__OVERLOADS;

	/**
	 * The feature id for the '<em><b>User Command</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVERLOADING__USER_COMMAND = COMMAND__USER_COMMAND;

	/**
	 * The feature id for the '<em><b>Over Loaded Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVERLOADING__OVER_LOADED_INPUTS = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Overloading</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVERLOADING_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link commandIF.impl.SpecializedOverloadingImpl <em>Specialized Overloading</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see commandIF.impl.SpecializedOverloadingImpl
	 * @see commandIF.impl.CommandIFPackageImpl#getSpecializedOverloading()
	 * @generated
	 */
	int SPECIALIZED_OVERLOADING = 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZED_OVERLOADING__DESCRIPTION = OVERLOADING__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Overloads</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZED_OVERLOADING__OVERLOADS = OVERLOADING__OVERLOADS;

	/**
	 * The feature id for the '<em><b>User Command</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZED_OVERLOADING__USER_COMMAND = OVERLOADING__USER_COMMAND;

	/**
	 * The feature id for the '<em><b>Over Loaded Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZED_OVERLOADING__OVER_LOADED_INPUTS = OVERLOADING__OVER_LOADED_INPUTS;

	/**
	 * The feature id for the '<em><b>Additional Inputs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZED_OVERLOADING__ADDITIONAL_INPUTS = OVERLOADING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Specialized Overloading</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZED_OVERLOADING_FEATURE_COUNT = OVERLOADING_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link commandIF.impl.InputImpl <em>Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see commandIF.impl.InputImpl
	 * @see commandIF.impl.CommandIFPackageImpl#getInput()
	 * @generated
	 */
	int INPUT = 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT__DEFAULT_VALUE = 2;

	/**
	 * The number of structural features of the '<em>Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link commandIF.Type <em>Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see commandIF.Type
	 * @see commandIF.impl.CommandIFPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 6;


	/**
	 * Returns the meta object for class '{@link commandIF.Category <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Category</em>'.
	 * @see commandIF.Category
	 * @generated
	 */
	EClass getCategory();

	/**
	 * Returns the meta object for the attribute '{@link commandIF.Category#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see commandIF.Category#getName()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_Name();

	/**
	 * Returns the meta object for the attribute '{@link commandIF.Category#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see commandIF.Category#getDescription()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_Description();

	/**
	 * Returns the meta object for the attribute '{@link commandIF.Category#getCommandPrefix <em>Command Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Command Prefix</em>'.
	 * @see commandIF.Category#getCommandPrefix()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_CommandPrefix();

	/**
	 * Returns the meta object for the containment reference list '{@link commandIF.Category#getSubcategories <em>Subcategories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subcategories</em>'.
	 * @see commandIF.Category#getSubcategories()
	 * @see #getCategory()
	 * @generated
	 */
	EReference getCategory_Subcategories();

	/**
	 * Returns the meta object for the containment reference list '{@link commandIF.Category#getCommands <em>Commands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Commands</em>'.
	 * @see commandIF.Category#getCommands()
	 * @see #getCategory()
	 * @generated
	 */
	EReference getCategory_Commands();

	/**
	 * Returns the meta object for class '{@link commandIF.BasicCommand <em>Basic Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Command</em>'.
	 * @see commandIF.BasicCommand
	 * @generated
	 */
	EClass getBasicCommand();

	/**
	 * Returns the meta object for the attribute '{@link commandIF.BasicCommand#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see commandIF.BasicCommand#getName()
	 * @see #getBasicCommand()
	 * @generated
	 */
	EAttribute getBasicCommand_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link commandIF.BasicCommand#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inputs</em>'.
	 * @see commandIF.BasicCommand#getInputs()
	 * @see #getBasicCommand()
	 * @generated
	 */
	EReference getBasicCommand_Inputs();

	/**
	 * Returns the meta object for the attribute '{@link commandIF.BasicCommand#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output</em>'.
	 * @see commandIF.BasicCommand#getOutput()
	 * @see #getBasicCommand()
	 * @generated
	 */
	EAttribute getBasicCommand_Output();

	/**
	 * Returns the meta object for class '{@link commandIF.Command <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Command</em>'.
	 * @see commandIF.Command
	 * @generated
	 */
	EClass getCommand();

	/**
	 * Returns the meta object for the attribute '{@link commandIF.Command#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see commandIF.Command#getDescription()
	 * @see #getCommand()
	 * @generated
	 */
	EAttribute getCommand_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link commandIF.Command#getOverloads <em>Overloads</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Overloads</em>'.
	 * @see commandIF.Command#getOverloads()
	 * @see #getCommand()
	 * @generated
	 */
	EReference getCommand_Overloads();

	/**
	 * Returns the meta object for the attribute '{@link commandIF.Command#isUserCommand <em>User Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Command</em>'.
	 * @see commandIF.Command#isUserCommand()
	 * @see #getCommand()
	 * @generated
	 */
	EAttribute getCommand_UserCommand();

	/**
	 * Returns the meta object for class '{@link commandIF.Overloading <em>Overloading</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Overloading</em>'.
	 * @see commandIF.Overloading
	 * @generated
	 */
	EClass getOverloading();

	/**
	 * Returns the meta object for the reference list '{@link commandIF.Overloading#getOverLoadedInputs <em>Over Loaded Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Over Loaded Inputs</em>'.
	 * @see commandIF.Overloading#getOverLoadedInputs()
	 * @see #getOverloading()
	 * @generated
	 */
	EReference getOverloading_OverLoadedInputs();

	/**
	 * Returns the meta object for class '{@link commandIF.SpecializedOverloading <em>Specialized Overloading</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specialized Overloading</em>'.
	 * @see commandIF.SpecializedOverloading
	 * @generated
	 */
	EClass getSpecializedOverloading();

	/**
	 * Returns the meta object for the containment reference list '{@link commandIF.SpecializedOverloading#getAdditionalInputs <em>Additional Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Additional Inputs</em>'.
	 * @see commandIF.SpecializedOverloading#getAdditionalInputs()
	 * @see #getSpecializedOverloading()
	 * @generated
	 */
	EReference getSpecializedOverloading_AdditionalInputs();

	/**
	 * Returns the meta object for class '{@link commandIF.Input <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input</em>'.
	 * @see commandIF.Input
	 * @generated
	 */
	EClass getInput();

	/**
	 * Returns the meta object for the attribute '{@link commandIF.Input#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see commandIF.Input#getType()
	 * @see #getInput()
	 * @generated
	 */
	EAttribute getInput_Type();

	/**
	 * Returns the meta object for the attribute '{@link commandIF.Input#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see commandIF.Input#getName()
	 * @see #getInput()
	 * @generated
	 */
	EAttribute getInput_Name();

	/**
	 * Returns the meta object for the attribute '{@link commandIF.Input#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see commandIF.Input#getDefaultValue()
	 * @see #getInput()
	 * @generated
	 */
	EAttribute getInput_DefaultValue();

	/**
	 * Returns the meta object for enum '{@link commandIF.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type</em>'.
	 * @see commandIF.Type
	 * @generated
	 */
	EEnum getType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CommandIFFactory getCommandIFFactory();

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
		 * The meta object literal for the '{@link commandIF.impl.CategoryImpl <em>Category</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see commandIF.impl.CategoryImpl
		 * @see commandIF.impl.CommandIFPackageImpl#getCategory()
		 * @generated
		 */
		EClass CATEGORY = eINSTANCE.getCategory();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__NAME = eINSTANCE.getCategory_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__DESCRIPTION = eINSTANCE.getCategory_Description();

		/**
		 * The meta object literal for the '<em><b>Command Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__COMMAND_PREFIX = eINSTANCE.getCategory_CommandPrefix();

		/**
		 * The meta object literal for the '<em><b>Subcategories</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATEGORY__SUBCATEGORIES = eINSTANCE.getCategory_Subcategories();

		/**
		 * The meta object literal for the '<em><b>Commands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATEGORY__COMMANDS = eINSTANCE.getCategory_Commands();

		/**
		 * The meta object literal for the '{@link commandIF.impl.BasicCommandImpl <em>Basic Command</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see commandIF.impl.BasicCommandImpl
		 * @see commandIF.impl.CommandIFPackageImpl#getBasicCommand()
		 * @generated
		 */
		EClass BASIC_COMMAND = eINSTANCE.getBasicCommand();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASIC_COMMAND__NAME = eINSTANCE.getBasicCommand_Name();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_COMMAND__INPUTS = eINSTANCE.getBasicCommand_Inputs();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASIC_COMMAND__OUTPUT = eINSTANCE.getBasicCommand_Output();

		/**
		 * The meta object literal for the '{@link commandIF.impl.CommandImpl <em>Command</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see commandIF.impl.CommandImpl
		 * @see commandIF.impl.CommandIFPackageImpl#getCommand()
		 * @generated
		 */
		EClass COMMAND = eINSTANCE.getCommand();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND__DESCRIPTION = eINSTANCE.getCommand_Description();

		/**
		 * The meta object literal for the '<em><b>Overloads</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMAND__OVERLOADS = eINSTANCE.getCommand_Overloads();

		/**
		 * The meta object literal for the '<em><b>User Command</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND__USER_COMMAND = eINSTANCE.getCommand_UserCommand();

		/**
		 * The meta object literal for the '{@link commandIF.impl.OverloadingImpl <em>Overloading</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see commandIF.impl.OverloadingImpl
		 * @see commandIF.impl.CommandIFPackageImpl#getOverloading()
		 * @generated
		 */
		EClass OVERLOADING = eINSTANCE.getOverloading();

		/**
		 * The meta object literal for the '<em><b>Over Loaded Inputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OVERLOADING__OVER_LOADED_INPUTS = eINSTANCE.getOverloading_OverLoadedInputs();

		/**
		 * The meta object literal for the '{@link commandIF.impl.SpecializedOverloadingImpl <em>Specialized Overloading</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see commandIF.impl.SpecializedOverloadingImpl
		 * @see commandIF.impl.CommandIFPackageImpl#getSpecializedOverloading()
		 * @generated
		 */
		EClass SPECIALIZED_OVERLOADING = eINSTANCE.getSpecializedOverloading();

		/**
		 * The meta object literal for the '<em><b>Additional Inputs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIALIZED_OVERLOADING__ADDITIONAL_INPUTS = eINSTANCE.getSpecializedOverloading_AdditionalInputs();

		/**
		 * The meta object literal for the '{@link commandIF.impl.InputImpl <em>Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see commandIF.impl.InputImpl
		 * @see commandIF.impl.CommandIFPackageImpl#getInput()
		 * @generated
		 */
		EClass INPUT = eINSTANCE.getInput();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT__TYPE = eINSTANCE.getInput_Type();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT__NAME = eINSTANCE.getInput_Name();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT__DEFAULT_VALUE = eINSTANCE.getInput_DefaultValue();

		/**
		 * The meta object literal for the '{@link commandIF.Type <em>Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see commandIF.Type
		 * @see commandIF.impl.CommandIFPackageImpl#getType()
		 * @generated
		 */
		EEnum TYPE = eINSTANCE.getType();

	}

} //CommandIFPackage
