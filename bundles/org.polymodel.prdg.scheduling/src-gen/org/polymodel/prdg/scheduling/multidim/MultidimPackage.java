/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.multidim;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.polymodel.prdg.scheduling.SchedulingPackage;
import org.polymodel.prdg.scheduling.structured.StructuredPackage;

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
 * @see org.polymodel.prdg.scheduling.multidim.MultidimFactory
 * @model kind="package"
 * @generated
 */
public interface MultidimPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "multidim";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.polymodel.prdg.scheduling.structured.multidim";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "multidim";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MultidimPackage eINSTANCE = org.polymodel.prdg.scheduling.multidim.impl.MultidimPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.multidim.impl.NullifiableDependencyImpl <em>Nullifiable Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.multidim.impl.NullifiableDependencyImpl
	 * @see org.polymodel.prdg.scheduling.multidim.impl.MultidimPackageImpl#getNullifiableDependency()
	 * @generated
	 */
	int NULLIFIABLE_DEPENDENCY = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULLIFIABLE_DEPENDENCY__SOURCE = SchedulingPackage.DEPENDENCY__SOURCE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULLIFIABLE_DEPENDENCY__REFERENCE = SchedulingPackage.DEPENDENCY__REFERENCE;

	/**
	 * The feature id for the '<em><b>Dimension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULLIFIABLE_DEPENDENCY__DIMENSION = SchedulingPackage.DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Previous Dimensions Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULLIFIABLE_DEPENDENCY__PREVIOUS_DIMENSIONS_DEPENDENCIES = SchedulingPackage.DEPENDENCY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Satisfaction Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULLIFIABLE_DEPENDENCY__SATISFACTION_VARIABLE = SchedulingPackage.DEPENDENCY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Dependency</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULLIFIABLE_DEPENDENCY__DEPENDENCY = SchedulingPackage.DEPENDENCY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>K</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULLIFIABLE_DEPENDENCY__K = SchedulingPackage.DEPENDENCY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Nullifiable Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULLIFIABLE_DEPENDENCY_FEATURE_COUNT = SchedulingPackage.DEPENDENCY_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Get Terms</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULLIFIABLE_DEPENDENCY___GET_TERMS__BOOLEAN = SchedulingPackage.DEPENDENCY___GET_TERMS__BOOLEAN;

	/**
	 * The operation id for the '<em>Get Coefficients Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULLIFIABLE_DEPENDENCY___GET_COEFFICIENTS_CONTEXT = SchedulingPackage.DEPENDENCY___GET_COEFFICIENTS_CONTEXT;

	/**
	 * The number of operations of the '<em>Nullifiable Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULLIFIABLE_DEPENDENCY_OPERATION_COUNT = SchedulingPackage.DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.irisa.cairn.graph.observer.IObservable <em>IObservable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.irisa.cairn.graph.observer.IObservable
	 * @see org.polymodel.prdg.scheduling.multidim.impl.MultidimPackageImpl#getIObservable()
	 * @generated
	 */
	int IOBSERVABLE = 6;

	/**
	 * The number of structural features of the '<em>IObservable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IOBSERVABLE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>IObservable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IOBSERVABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.multidim.impl.MultidimDependencyImpl <em>Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.multidim.impl.MultidimDependencyImpl
	 * @see org.polymodel.prdg.scheduling.multidim.impl.MultidimPackageImpl#getMultidimDependency()
	 * @generated
	 */
	int MULTIDIM_DEPENDENCY = 1;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_DEPENDENCY__DEPENDENCIES = IOBSERVABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_DEPENDENCY_FEATURE_COUNT = IOBSERVABLE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Compute Constraints</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_DEPENDENCY___COMPUTE_CONSTRAINTS = IOBSERVABLE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get All Schedule Coefficients</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_DEPENDENCY___GET_ALL_SCHEDULE_COEFFICIENTS = IOBSERVABLE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Get All Satisfaction Variables</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_DEPENDENCY___GET_ALL_SATISFACTION_VARIABLES = IOBSERVABLE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get All Source Coefficients</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_DEPENDENCY___GET_ALL_SOURCE_COEFFICIENTS = IOBSERVABLE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Get All Reference Coefficients</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_DEPENDENCY___GET_ALL_REFERENCE_COEFFICIENTS = IOBSERVABLE_OPERATION_COUNT + 4;

	/**
	 * The number of operations of the '<em>Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_DEPENDENCY_OPERATION_COUNT = IOBSERVABLE_OPERATION_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.multidim.impl.MultidimSchedulePrototypeImpl <em>Schedule Prototype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.multidim.impl.MultidimSchedulePrototypeImpl
	 * @see org.polymodel.prdg.scheduling.multidim.impl.MultidimPackageImpl#getMultidimSchedulePrototype()
	 * @generated
	 */
	int MULTIDIM_SCHEDULE_PROTOTYPE = 2;

	/**
	 * The feature id for the '<em><b>Prototypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_SCHEDULE_PROTOTYPE__PROTOTYPES = 0;

	/**
	 * The feature id for the '<em><b>Scalars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_SCHEDULE_PROTOTYPE__SCALARS = 1;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_SCHEDULE_PROTOTYPE__REFERENCE = 2;

	/**
	 * The number of structural features of the '<em>Schedule Prototype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_SCHEDULE_PROTOTYPE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Schedule Prototype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_SCHEDULE_PROTOTYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.multidim.ScalarSchedulePrototype <em>Scalar Schedule Prototype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.multidim.ScalarSchedulePrototype
	 * @see org.polymodel.prdg.scheduling.multidim.impl.MultidimPackageImpl#getScalarSchedulePrototype()
	 * @generated
	 */
	int SCALAR_SCHEDULE_PROTOTYPE = 3;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_SCHEDULE_PROTOTYPE__TERMS = SchedulingPackage.SCHEDULE_PROTOTYPE__TERMS;

	/**
	 * The feature id for the '<em><b>Coeficients</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_SCHEDULE_PROTOTYPE__COEFICIENTS = SchedulingPackage.SCHEDULE_PROTOTYPE__COEFICIENTS;

	/**
	 * The number of structural features of the '<em>Scalar Schedule Prototype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_SCHEDULE_PROTOTYPE_FEATURE_COUNT = SchedulingPackage.SCHEDULE_PROTOTYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Distribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_SCHEDULE_PROTOTYPE___DISTRIBUTE = SchedulingPackage.SCHEDULE_PROTOTYPE___DISTRIBUTE;

	/**
	 * The operation id for the '<em>Get Constant Term</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_SCHEDULE_PROTOTYPE___GET_CONSTANT_TERM = SchedulingPackage.SCHEDULE_PROTOTYPE___GET_CONSTANT_TERM;

	/**
	 * The operation id for the '<em>Apply</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_SCHEDULE_PROTOTYPE___APPLY__FUNCTION = SchedulingPackage.SCHEDULE_PROTOTYPE___APPLY__FUNCTION;

	/**
	 * The operation id for the '<em>Get Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_SCHEDULE_PROTOTYPE___GET_DOMAIN = SchedulingPackage.SCHEDULE_PROTOTYPE___GET_DOMAIN;

	/**
	 * The operation id for the '<em>Get Schedule Indices</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_SCHEDULE_PROTOTYPE___GET_SCHEDULE_INDICES = SchedulingPackage.SCHEDULE_PROTOTYPE___GET_SCHEDULE_INDICES;

	/**
	 * The number of operations of the '<em>Scalar Schedule Prototype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALAR_SCHEDULE_PROTOTYPE_OPERATION_COUNT = SchedulingPackage.SCHEDULE_PROTOTYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.multidim.impl.StatementScalarSchedulePrototypeImpl <em>Statement Scalar Schedule Prototype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.multidim.impl.StatementScalarSchedulePrototypeImpl
	 * @see org.polymodel.prdg.scheduling.multidim.impl.MultidimPackageImpl#getStatementScalarSchedulePrototype()
	 * @generated
	 */
	int STATEMENT_SCALAR_SCHEDULE_PROTOTYPE = 4;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_SCALAR_SCHEDULE_PROTOTYPE__TERMS = SchedulingPackage.STATEMENT_SCHEDULE_PROTOTYPE__TERMS;

	/**
	 * The feature id for the '<em><b>Coeficients</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_SCALAR_SCHEDULE_PROTOTYPE__COEFICIENTS = SchedulingPackage.STATEMENT_SCHEDULE_PROTOTYPE__COEFICIENTS;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_SCALAR_SCHEDULE_PROTOTYPE__STATEMENT = SchedulingPackage.STATEMENT_SCHEDULE_PROTOTYPE__STATEMENT;

	/**
	 * The number of structural features of the '<em>Statement Scalar Schedule Prototype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_SCALAR_SCHEDULE_PROTOTYPE_FEATURE_COUNT = SchedulingPackage.STATEMENT_SCHEDULE_PROTOTYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Distribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_SCALAR_SCHEDULE_PROTOTYPE___DISTRIBUTE = SchedulingPackage.STATEMENT_SCHEDULE_PROTOTYPE___DISTRIBUTE;

	/**
	 * The operation id for the '<em>Get Constant Term</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_SCALAR_SCHEDULE_PROTOTYPE___GET_CONSTANT_TERM = SchedulingPackage.STATEMENT_SCHEDULE_PROTOTYPE___GET_CONSTANT_TERM;

	/**
	 * The operation id for the '<em>Apply</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_SCALAR_SCHEDULE_PROTOTYPE___APPLY__FUNCTION = SchedulingPackage.STATEMENT_SCHEDULE_PROTOTYPE___APPLY__FUNCTION;

	/**
	 * The operation id for the '<em>Get Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_SCALAR_SCHEDULE_PROTOTYPE___GET_DOMAIN = SchedulingPackage.STATEMENT_SCHEDULE_PROTOTYPE___GET_DOMAIN;

	/**
	 * The operation id for the '<em>Get Schedule Indices</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_SCALAR_SCHEDULE_PROTOTYPE___GET_SCHEDULE_INDICES = SchedulingPackage.STATEMENT_SCHEDULE_PROTOTYPE___GET_SCHEDULE_INDICES;

	/**
	 * The number of operations of the '<em>Statement Scalar Schedule Prototype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_SCALAR_SCHEDULE_PROTOTYPE_OPERATION_COUNT = SchedulingPackage.STATEMENT_SCHEDULE_PROTOTYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.multidim.impl.ChannelScalarSchedulePrototypeImpl <em>Channel Scalar Schedule Prototype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.multidim.impl.ChannelScalarSchedulePrototypeImpl
	 * @see org.polymodel.prdg.scheduling.multidim.impl.MultidimPackageImpl#getChannelScalarSchedulePrototype()
	 * @generated
	 */
	int CHANNEL_SCALAR_SCHEDULE_PROTOTYPE = 5;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_SCALAR_SCHEDULE_PROTOTYPE__TERMS = StructuredPackage.CHANNEL_SCHEDULE_PROTOTYPE__TERMS;

	/**
	 * The feature id for the '<em><b>Coeficients</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_SCALAR_SCHEDULE_PROTOTYPE__COEFICIENTS = StructuredPackage.CHANNEL_SCHEDULE_PROTOTYPE__COEFICIENTS;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_SCALAR_SCHEDULE_PROTOTYPE__CHANNEL = StructuredPackage.CHANNEL_SCHEDULE_PROTOTYPE__CHANNEL;

	/**
	 * The number of structural features of the '<em>Channel Scalar Schedule Prototype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_SCALAR_SCHEDULE_PROTOTYPE_FEATURE_COUNT = StructuredPackage.CHANNEL_SCHEDULE_PROTOTYPE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Distribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_SCALAR_SCHEDULE_PROTOTYPE___DISTRIBUTE = StructuredPackage.CHANNEL_SCHEDULE_PROTOTYPE___DISTRIBUTE;

	/**
	 * The operation id for the '<em>Get Constant Term</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_SCALAR_SCHEDULE_PROTOTYPE___GET_CONSTANT_TERM = StructuredPackage.CHANNEL_SCHEDULE_PROTOTYPE___GET_CONSTANT_TERM;

	/**
	 * The operation id for the '<em>Apply</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_SCALAR_SCHEDULE_PROTOTYPE___APPLY__FUNCTION = StructuredPackage.CHANNEL_SCHEDULE_PROTOTYPE___APPLY__FUNCTION;

	/**
	 * The operation id for the '<em>Get Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_SCALAR_SCHEDULE_PROTOTYPE___GET_DOMAIN = StructuredPackage.CHANNEL_SCHEDULE_PROTOTYPE___GET_DOMAIN;

	/**
	 * The operation id for the '<em>Get Schedule Indices</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_SCALAR_SCHEDULE_PROTOTYPE___GET_SCHEDULE_INDICES = StructuredPackage.CHANNEL_SCHEDULE_PROTOTYPE___GET_SCHEDULE_INDICES;

	/**
	 * The number of operations of the '<em>Channel Scalar Schedule Prototype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_SCALAR_SCHEDULE_PROTOTYPE_OPERATION_COUNT = StructuredPackage.CHANNEL_SCHEDULE_PROTOTYPE_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.multidim.NullifiableDependency <em>Nullifiable Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nullifiable Dependency</em>'.
	 * @see org.polymodel.prdg.scheduling.multidim.NullifiableDependency
	 * @generated
	 */
	EClass getNullifiableDependency();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.prdg.scheduling.multidim.NullifiableDependency#getDimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dimension</em>'.
	 * @see org.polymodel.prdg.scheduling.multidim.NullifiableDependency#getDimension()
	 * @see #getNullifiableDependency()
	 * @generated
	 */
	EAttribute getNullifiableDependency_Dimension();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.prdg.scheduling.multidim.NullifiableDependency#getPreviousDimensionsDependencies <em>Previous Dimensions Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Previous Dimensions Dependencies</em>'.
	 * @see org.polymodel.prdg.scheduling.multidim.NullifiableDependency#getPreviousDimensionsDependencies()
	 * @see #getNullifiableDependency()
	 * @generated
	 */
	EReference getNullifiableDependency_PreviousDimensionsDependencies();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.prdg.scheduling.multidim.NullifiableDependency#getSatisfactionVariable <em>Satisfaction Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Satisfaction Variable</em>'.
	 * @see org.polymodel.prdg.scheduling.multidim.NullifiableDependency#getSatisfactionVariable()
	 * @see #getNullifiableDependency()
	 * @generated
	 */
	EReference getNullifiableDependency_SatisfactionVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.prdg.scheduling.multidim.NullifiableDependency#getDependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dependency</em>'.
	 * @see org.polymodel.prdg.scheduling.multidim.NullifiableDependency#getDependency()
	 * @see #getNullifiableDependency()
	 * @generated
	 */
	EReference getNullifiableDependency_Dependency();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.prdg.scheduling.multidim.NullifiableDependency#getK <em>K</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>K</em>'.
	 * @see org.polymodel.prdg.scheduling.multidim.NullifiableDependency#getK()
	 * @see #getNullifiableDependency()
	 * @generated
	 */
	EAttribute getNullifiableDependency_K();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.multidim.MultidimDependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency</em>'.
	 * @see org.polymodel.prdg.scheduling.multidim.MultidimDependency
	 * @generated
	 */
	EClass getMultidimDependency();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.prdg.scheduling.multidim.MultidimDependency#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependencies</em>'.
	 * @see org.polymodel.prdg.scheduling.multidim.MultidimDependency#getDependencies()
	 * @see #getMultidimDependency()
	 * @generated
	 */
	EReference getMultidimDependency_Dependencies();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.scheduling.multidim.MultidimDependency#computeConstraints() <em>Compute Constraints</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Compute Constraints</em>' operation.
	 * @see org.polymodel.prdg.scheduling.multidim.MultidimDependency#computeConstraints()
	 * @generated
	 */
	EOperation getMultidimDependency__ComputeConstraints();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.scheduling.multidim.MultidimDependency#getAllScheduleCoefficients() <em>Get All Schedule Coefficients</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get All Schedule Coefficients</em>' operation.
	 * @see org.polymodel.prdg.scheduling.multidim.MultidimDependency#getAllScheduleCoefficients()
	 * @generated
	 */
	EOperation getMultidimDependency__GetAllScheduleCoefficients();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.scheduling.multidim.MultidimDependency#getAllSatisfactionVariables() <em>Get All Satisfaction Variables</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get All Satisfaction Variables</em>' operation.
	 * @see org.polymodel.prdg.scheduling.multidim.MultidimDependency#getAllSatisfactionVariables()
	 * @generated
	 */
	EOperation getMultidimDependency__GetAllSatisfactionVariables();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.scheduling.multidim.MultidimDependency#getAllSourceCoefficients() <em>Get All Source Coefficients</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get All Source Coefficients</em>' operation.
	 * @see org.polymodel.prdg.scheduling.multidim.MultidimDependency#getAllSourceCoefficients()
	 * @generated
	 */
	EOperation getMultidimDependency__GetAllSourceCoefficients();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.scheduling.multidim.MultidimDependency#getAllReferenceCoefficients() <em>Get All Reference Coefficients</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get All Reference Coefficients</em>' operation.
	 * @see org.polymodel.prdg.scheduling.multidim.MultidimDependency#getAllReferenceCoefficients()
	 * @generated
	 */
	EOperation getMultidimDependency__GetAllReferenceCoefficients();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.multidim.MultidimSchedulePrototype <em>Schedule Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Schedule Prototype</em>'.
	 * @see org.polymodel.prdg.scheduling.multidim.MultidimSchedulePrototype
	 * @generated
	 */
	EClass getMultidimSchedulePrototype();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.prdg.scheduling.multidim.MultidimSchedulePrototype#getPrototypes <em>Prototypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Prototypes</em>'.
	 * @see org.polymodel.prdg.scheduling.multidim.MultidimSchedulePrototype#getPrototypes()
	 * @see #getMultidimSchedulePrototype()
	 * @generated
	 */
	EReference getMultidimSchedulePrototype_Prototypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.prdg.scheduling.multidim.MultidimSchedulePrototype#getScalars <em>Scalars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scalars</em>'.
	 * @see org.polymodel.prdg.scheduling.multidim.MultidimSchedulePrototype#getScalars()
	 * @see #getMultidimSchedulePrototype()
	 * @generated
	 */
	EReference getMultidimSchedulePrototype_Scalars();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.prdg.scheduling.multidim.MultidimSchedulePrototype#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reference</em>'.
	 * @see org.polymodel.prdg.scheduling.multidim.MultidimSchedulePrototype#getReference()
	 * @see #getMultidimSchedulePrototype()
	 * @generated
	 */
	EReference getMultidimSchedulePrototype_Reference();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.multidim.ScalarSchedulePrototype <em>Scalar Schedule Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scalar Schedule Prototype</em>'.
	 * @see org.polymodel.prdg.scheduling.multidim.ScalarSchedulePrototype
	 * @generated
	 */
	EClass getScalarSchedulePrototype();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.multidim.StatementScalarSchedulePrototype <em>Statement Scalar Schedule Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement Scalar Schedule Prototype</em>'.
	 * @see org.polymodel.prdg.scheduling.multidim.StatementScalarSchedulePrototype
	 * @generated
	 */
	EClass getStatementScalarSchedulePrototype();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.multidim.ChannelScalarSchedulePrototype <em>Channel Scalar Schedule Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Channel Scalar Schedule Prototype</em>'.
	 * @see org.polymodel.prdg.scheduling.multidim.ChannelScalarSchedulePrototype
	 * @generated
	 */
	EClass getChannelScalarSchedulePrototype();

	/**
	 * Returns the meta object for class '{@link fr.irisa.cairn.graph.observer.IObservable <em>IObservable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IObservable</em>'.
	 * @see fr.irisa.cairn.graph.observer.IObservable
	 * @model instanceClass="fr.irisa.cairn.graph.observer.IObservable"
	 * @generated
	 */
	EClass getIObservable();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MultidimFactory getMultidimFactory();

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
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.multidim.impl.NullifiableDependencyImpl <em>Nullifiable Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.multidim.impl.NullifiableDependencyImpl
		 * @see org.polymodel.prdg.scheduling.multidim.impl.MultidimPackageImpl#getNullifiableDependency()
		 * @generated
		 */
		EClass NULLIFIABLE_DEPENDENCY = eINSTANCE.getNullifiableDependency();

		/**
		 * The meta object literal for the '<em><b>Dimension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NULLIFIABLE_DEPENDENCY__DIMENSION = eINSTANCE.getNullifiableDependency_Dimension();

		/**
		 * The meta object literal for the '<em><b>Previous Dimensions Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NULLIFIABLE_DEPENDENCY__PREVIOUS_DIMENSIONS_DEPENDENCIES = eINSTANCE.getNullifiableDependency_PreviousDimensionsDependencies();

		/**
		 * The meta object literal for the '<em><b>Satisfaction Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NULLIFIABLE_DEPENDENCY__SATISFACTION_VARIABLE = eINSTANCE.getNullifiableDependency_SatisfactionVariable();

		/**
		 * The meta object literal for the '<em><b>Dependency</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NULLIFIABLE_DEPENDENCY__DEPENDENCY = eINSTANCE.getNullifiableDependency_Dependency();

		/**
		 * The meta object literal for the '<em><b>K</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NULLIFIABLE_DEPENDENCY__K = eINSTANCE.getNullifiableDependency_K();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.multidim.impl.MultidimDependencyImpl <em>Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.multidim.impl.MultidimDependencyImpl
		 * @see org.polymodel.prdg.scheduling.multidim.impl.MultidimPackageImpl#getMultidimDependency()
		 * @generated
		 */
		EClass MULTIDIM_DEPENDENCY = eINSTANCE.getMultidimDependency();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTIDIM_DEPENDENCY__DEPENDENCIES = eINSTANCE.getMultidimDependency_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Compute Constraints</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MULTIDIM_DEPENDENCY___COMPUTE_CONSTRAINTS = eINSTANCE.getMultidimDependency__ComputeConstraints();

		/**
		 * The meta object literal for the '<em><b>Get All Schedule Coefficients</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MULTIDIM_DEPENDENCY___GET_ALL_SCHEDULE_COEFFICIENTS = eINSTANCE.getMultidimDependency__GetAllScheduleCoefficients();

		/**
		 * The meta object literal for the '<em><b>Get All Satisfaction Variables</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MULTIDIM_DEPENDENCY___GET_ALL_SATISFACTION_VARIABLES = eINSTANCE.getMultidimDependency__GetAllSatisfactionVariables();

		/**
		 * The meta object literal for the '<em><b>Get All Source Coefficients</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MULTIDIM_DEPENDENCY___GET_ALL_SOURCE_COEFFICIENTS = eINSTANCE.getMultidimDependency__GetAllSourceCoefficients();

		/**
		 * The meta object literal for the '<em><b>Get All Reference Coefficients</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MULTIDIM_DEPENDENCY___GET_ALL_REFERENCE_COEFFICIENTS = eINSTANCE.getMultidimDependency__GetAllReferenceCoefficients();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.multidim.impl.MultidimSchedulePrototypeImpl <em>Schedule Prototype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.multidim.impl.MultidimSchedulePrototypeImpl
		 * @see org.polymodel.prdg.scheduling.multidim.impl.MultidimPackageImpl#getMultidimSchedulePrototype()
		 * @generated
		 */
		EClass MULTIDIM_SCHEDULE_PROTOTYPE = eINSTANCE.getMultidimSchedulePrototype();

		/**
		 * The meta object literal for the '<em><b>Prototypes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTIDIM_SCHEDULE_PROTOTYPE__PROTOTYPES = eINSTANCE.getMultidimSchedulePrototype_Prototypes();

		/**
		 * The meta object literal for the '<em><b>Scalars</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTIDIM_SCHEDULE_PROTOTYPE__SCALARS = eINSTANCE.getMultidimSchedulePrototype_Scalars();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTIDIM_SCHEDULE_PROTOTYPE__REFERENCE = eINSTANCE.getMultidimSchedulePrototype_Reference();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.multidim.ScalarSchedulePrototype <em>Scalar Schedule Prototype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.multidim.ScalarSchedulePrototype
		 * @see org.polymodel.prdg.scheduling.multidim.impl.MultidimPackageImpl#getScalarSchedulePrototype()
		 * @generated
		 */
		EClass SCALAR_SCHEDULE_PROTOTYPE = eINSTANCE.getScalarSchedulePrototype();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.multidim.impl.StatementScalarSchedulePrototypeImpl <em>Statement Scalar Schedule Prototype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.multidim.impl.StatementScalarSchedulePrototypeImpl
		 * @see org.polymodel.prdg.scheduling.multidim.impl.MultidimPackageImpl#getStatementScalarSchedulePrototype()
		 * @generated
		 */
		EClass STATEMENT_SCALAR_SCHEDULE_PROTOTYPE = eINSTANCE.getStatementScalarSchedulePrototype();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.multidim.impl.ChannelScalarSchedulePrototypeImpl <em>Channel Scalar Schedule Prototype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.multidim.impl.ChannelScalarSchedulePrototypeImpl
		 * @see org.polymodel.prdg.scheduling.multidim.impl.MultidimPackageImpl#getChannelScalarSchedulePrototype()
		 * @generated
		 */
		EClass CHANNEL_SCALAR_SCHEDULE_PROTOTYPE = eINSTANCE.getChannelScalarSchedulePrototype();

		/**
		 * The meta object literal for the '{@link fr.irisa.cairn.graph.observer.IObservable <em>IObservable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.irisa.cairn.graph.observer.IObservable
		 * @see org.polymodel.prdg.scheduling.multidim.impl.MultidimPackageImpl#getIObservable()
		 * @generated
		 */
		EClass IOBSERVABLE = eINSTANCE.getIObservable();

	}

} //MultidimPackage
