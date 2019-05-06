/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.polymodel.algebra.AlgebraPackage;
import org.polymodel.prdg.scheduling.SchedulingPackage;
import org.polymodel.prdg.scheduling.multidim.MultidimPackage;

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
 * @see org.polymodel.prdg.scheduling.structured.StructuredFactory
 * @model kind="package"
 * @generated
 */
public interface StructuredPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "structured";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.polymodel.prdg.scheduling.structured";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "structured";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StructuredPackage eINSTANCE = org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.structured.impl.ChannelImpl <em>Channel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.structured.impl.ChannelImpl
	 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getChannel()
	 * @generated
	 */
	int CHANNEL = 0;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__EDGES = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__SOURCE = 1;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__DESTINATION = 2;

	/**
	 * The feature id for the '<em><b>Schedule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__SCHEDULE = 3;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__DOMAIN = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__NAME = 5;

	/**
	 * The feature id for the '<em><b>Subscript Dimension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL__SUBSCRIPT_DIMENSION = 6;

	/**
	 * The number of structural features of the '<em>Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.structured.impl.ProcessImpl <em>Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.structured.impl.ProcessImpl
	 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getProcess()
	 * @generated
	 */
	int PROCESS = 1;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__INPUTS = 0;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__OUTPUTS = 1;

	/**
	 * The feature id for the '<em><b>Internal Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__INTERNAL_NODES = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__NAME = 3;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__CONSTRAINTS = 4;

	/**
	 * The number of structural features of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.structured.impl.ProcessNetworkImpl <em>Process Network</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.structured.impl.ProcessNetworkImpl
	 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getProcessNetwork()
	 * @generated
	 */
	int PROCESS_NETWORK = 2;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_NETWORK__PROCESSES = 0;

	/**
	 * The feature id for the '<em><b>Channels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_NETWORK__CHANNELS = 1;

	/**
	 * The feature id for the '<em><b>Prdg</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_NETWORK__PRDG = 2;

	/**
	 * The number of structural features of the '<em>Process Network</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_NETWORK_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Process Network</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_NETWORK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.structured.impl.DataPortImpl <em>Data Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.structured.impl.DataPortImpl
	 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getDataPort()
	 * @generated
	 */
	int DATA_PORT = 3;

	/**
	 * The number of structural features of the '<em>Data Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Get Channel</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT___GET_CHANNEL = 0;

	/**
	 * The number of operations of the '<em>Data Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.structured.impl.InputPortImpl <em>Input Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.structured.impl.InputPortImpl
	 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getInputPort()
	 * @generated
	 */
	int INPUT_PORT = 4;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__CHANNEL = DATA_PORT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Input Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT_FEATURE_COUNT = DATA_PORT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Channel</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT___GET_CHANNEL = DATA_PORT___GET_CHANNEL;

	/**
	 * The number of operations of the '<em>Input Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT_OPERATION_COUNT = DATA_PORT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.structured.impl.OutputPortImpl <em>Output Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.structured.impl.OutputPortImpl
	 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getOutputPort()
	 * @generated
	 */
	int OUTPUT_PORT = 5;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__CHANNEL = DATA_PORT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Output Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT_FEATURE_COUNT = DATA_PORT_FEATURE_COUNT + 1;


	/**
	 * The operation id for the '<em>Get Channel</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT___GET_CHANNEL = DATA_PORT___GET_CHANNEL;

	/**
	 * The operation id for the '<em>Get Source Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT___GET_SOURCE_NODE = DATA_PORT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Output Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT_OPERATION_COUNT = DATA_PORT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.structured.impl.ChannelSchedulePrototypeImpl <em>Channel Schedule Prototype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.structured.impl.ChannelSchedulePrototypeImpl
	 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getChannelSchedulePrototype()
	 * @generated
	 */
	int CHANNEL_SCHEDULE_PROTOTYPE = 6;

	/**
	 * The feature id for the '<em><b>Terms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_SCHEDULE_PROTOTYPE__TERMS = SchedulingPackage.SCHEDULE_PROTOTYPE__TERMS;

	/**
	 * The feature id for the '<em><b>Coeficients</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_SCHEDULE_PROTOTYPE__COEFICIENTS = SchedulingPackage.SCHEDULE_PROTOTYPE__COEFICIENTS;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_SCHEDULE_PROTOTYPE__CHANNEL = SchedulingPackage.SCHEDULE_PROTOTYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Channel Schedule Prototype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_SCHEDULE_PROTOTYPE_FEATURE_COUNT = SchedulingPackage.SCHEDULE_PROTOTYPE_FEATURE_COUNT + 1;


	/**
	 * The operation id for the '<em>Distribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_SCHEDULE_PROTOTYPE___DISTRIBUTE = SchedulingPackage.SCHEDULE_PROTOTYPE___DISTRIBUTE;

	/**
	 * The operation id for the '<em>Get Constant Term</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_SCHEDULE_PROTOTYPE___GET_CONSTANT_TERM = SchedulingPackage.SCHEDULE_PROTOTYPE___GET_CONSTANT_TERM;

	/**
	 * The operation id for the '<em>Apply</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_SCHEDULE_PROTOTYPE___APPLY__FUNCTION = SchedulingPackage.SCHEDULE_PROTOTYPE___APPLY__FUNCTION;

	/**
	 * The operation id for the '<em>Get Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_SCHEDULE_PROTOTYPE___GET_DOMAIN = SchedulingPackage.SCHEDULE_PROTOTYPE___GET_DOMAIN;

	/**
	 * The operation id for the '<em>Get Schedule Indices</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_SCHEDULE_PROTOTYPE___GET_SCHEDULE_INDICES = SchedulingPackage.SCHEDULE_PROTOTYPE___GET_SCHEDULE_INDICES;

	/**
	 * The number of operations of the '<em>Channel Schedule Prototype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_SCHEDULE_PROTOTYPE_OPERATION_COUNT = SchedulingPackage.SCHEDULE_PROTOTYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.structured.impl.ChannelDependencyImpl <em>Channel Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.structured.impl.ChannelDependencyImpl
	 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getChannelDependency()
	 * @generated
	 */
	int CHANNEL_DEPENDENCY = 7;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_DEPENDENCY__SOURCE = SchedulingPackage.DEPENDENCY__SOURCE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_DEPENDENCY__REFERENCE = SchedulingPackage.DEPENDENCY__REFERENCE;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_DEPENDENCY__CHANNEL = SchedulingPackage.DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Channel Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_DEPENDENCY_FEATURE_COUNT = SchedulingPackage.DEPENDENCY_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Terms</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_DEPENDENCY___GET_TERMS__BOOLEAN = SchedulingPackage.DEPENDENCY___GET_TERMS__BOOLEAN;

	/**
	 * The operation id for the '<em>Get Coefficients Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_DEPENDENCY___GET_COEFFICIENTS_CONTEXT = SchedulingPackage.DEPENDENCY___GET_COEFFICIENTS_CONTEXT;

	/**
	 * The number of operations of the '<em>Channel Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_DEPENDENCY_OPERATION_COUNT = SchedulingPackage.DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.structured.impl.ChannelReadDependencyImpl <em>Channel Read Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.structured.impl.ChannelReadDependencyImpl
	 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getChannelReadDependency()
	 * @generated
	 */
	int CHANNEL_READ_DEPENDENCY = 8;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_READ_DEPENDENCY__SOURCE = CHANNEL_DEPENDENCY__SOURCE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_READ_DEPENDENCY__REFERENCE = CHANNEL_DEPENDENCY__REFERENCE;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_READ_DEPENDENCY__CHANNEL = CHANNEL_DEPENDENCY__CHANNEL;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_READ_DEPENDENCY__EDGE = CHANNEL_DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Channel Read Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_READ_DEPENDENCY_FEATURE_COUNT = CHANNEL_DEPENDENCY_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Terms</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_READ_DEPENDENCY___GET_TERMS__BOOLEAN = CHANNEL_DEPENDENCY___GET_TERMS__BOOLEAN;

	/**
	 * The operation id for the '<em>Get Coefficients Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_READ_DEPENDENCY___GET_COEFFICIENTS_CONTEXT = CHANNEL_DEPENDENCY___GET_COEFFICIENTS_CONTEXT;

	/**
	 * The number of operations of the '<em>Channel Read Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_READ_DEPENDENCY_OPERATION_COUNT = CHANNEL_DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.structured.impl.ChannelWriteDependencyImpl <em>Channel Write Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.structured.impl.ChannelWriteDependencyImpl
	 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getChannelWriteDependency()
	 * @generated
	 */
	int CHANNEL_WRITE_DEPENDENCY = 9;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_WRITE_DEPENDENCY__SOURCE = CHANNEL_DEPENDENCY__SOURCE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_WRITE_DEPENDENCY__REFERENCE = CHANNEL_DEPENDENCY__REFERENCE;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_WRITE_DEPENDENCY__CHANNEL = CHANNEL_DEPENDENCY__CHANNEL;

	/**
	 * The number of structural features of the '<em>Channel Write Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_WRITE_DEPENDENCY_FEATURE_COUNT = CHANNEL_DEPENDENCY_FEATURE_COUNT + 0;


	/**
	 * The operation id for the '<em>Get Terms</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_WRITE_DEPENDENCY___GET_TERMS__BOOLEAN = CHANNEL_DEPENDENCY___GET_TERMS__BOOLEAN;

	/**
	 * The operation id for the '<em>Get Coefficients Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_WRITE_DEPENDENCY___GET_COEFFICIENTS_CONTEXT = CHANNEL_DEPENDENCY___GET_COEFFICIENTS_CONTEXT;

	/**
	 * The number of operations of the '<em>Channel Write Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_WRITE_DEPENDENCY_OPERATION_COUNT = CHANNEL_DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.structured.impl.MemoryDependencyImpl <em>Memory Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.structured.impl.MemoryDependencyImpl
	 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getMemoryDependency()
	 * @generated
	 */
	int MEMORY_DEPENDENCY = 10;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_DEPENDENCY__SOURCE = CHANNEL_DEPENDENCY__SOURCE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_DEPENDENCY__REFERENCE = CHANNEL_DEPENDENCY__REFERENCE;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_DEPENDENCY__CHANNEL = CHANNEL_DEPENDENCY__CHANNEL;

	/**
	 * The number of structural features of the '<em>Memory Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_DEPENDENCY_FEATURE_COUNT = CHANNEL_DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Terms</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_DEPENDENCY___GET_TERMS__BOOLEAN = CHANNEL_DEPENDENCY___GET_TERMS__BOOLEAN;

	/**
	 * The operation id for the '<em>Get Coefficients Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_DEPENDENCY___GET_COEFFICIENTS_CONTEXT = CHANNEL_DEPENDENCY___GET_COEFFICIENTS_CONTEXT;

	/**
	 * The operation id for the '<em>Get Channel</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_DEPENDENCY___GET_CHANNEL = CHANNEL_DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Memory Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_DEPENDENCY_OPERATION_COUNT = CHANNEL_DEPENDENCY_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.structured.impl.ChannelLinearReadDependencyImpl <em>Channel Linear Read Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.structured.impl.ChannelLinearReadDependencyImpl
	 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getChannelLinearReadDependency()
	 * @generated
	 */
	int CHANNEL_LINEAR_READ_DEPENDENCY = 20;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_LINEAR_READ_DEPENDENCY__SOURCE = CHANNEL_READ_DEPENDENCY__SOURCE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_LINEAR_READ_DEPENDENCY__REFERENCE = CHANNEL_READ_DEPENDENCY__REFERENCE;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_LINEAR_READ_DEPENDENCY__CHANNEL = CHANNEL_READ_DEPENDENCY__CHANNEL;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_LINEAR_READ_DEPENDENCY__EDGE = CHANNEL_READ_DEPENDENCY__EDGE;

	/**
	 * The feature id for the '<em><b>Subscript</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_LINEAR_READ_DEPENDENCY__SUBSCRIPT = CHANNEL_READ_DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Channel Linear Read Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_LINEAR_READ_DEPENDENCY_FEATURE_COUNT = CHANNEL_READ_DEPENDENCY_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Terms</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_LINEAR_READ_DEPENDENCY___GET_TERMS__BOOLEAN = CHANNEL_READ_DEPENDENCY___GET_TERMS__BOOLEAN;

	/**
	 * The operation id for the '<em>Get Coefficients Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_LINEAR_READ_DEPENDENCY___GET_COEFFICIENTS_CONTEXT = CHANNEL_READ_DEPENDENCY___GET_COEFFICIENTS_CONTEXT;

	/**
	 * The number of operations of the '<em>Channel Linear Read Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_LINEAR_READ_DEPENDENCY_OPERATION_COUNT = CHANNEL_READ_DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.structured.impl.LinearMemoryReadDependencyImpl <em>Linear Memory Read Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.structured.impl.LinearMemoryReadDependencyImpl
	 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getLinearMemoryReadDependency()
	 * @generated
	 */
	int LINEAR_MEMORY_READ_DEPENDENCY = 11;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_READ_DEPENDENCY__SOURCE = CHANNEL_LINEAR_READ_DEPENDENCY__SOURCE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_READ_DEPENDENCY__REFERENCE = CHANNEL_LINEAR_READ_DEPENDENCY__REFERENCE;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_READ_DEPENDENCY__CHANNEL = CHANNEL_LINEAR_READ_DEPENDENCY__CHANNEL;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_READ_DEPENDENCY__EDGE = CHANNEL_LINEAR_READ_DEPENDENCY__EDGE;

	/**
	 * The feature id for the '<em><b>Subscript</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_READ_DEPENDENCY__SUBSCRIPT = CHANNEL_LINEAR_READ_DEPENDENCY__SUBSCRIPT;

	/**
	 * The number of structural features of the '<em>Linear Memory Read Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_READ_DEPENDENCY_FEATURE_COUNT = CHANNEL_LINEAR_READ_DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Terms</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_READ_DEPENDENCY___GET_TERMS__BOOLEAN = CHANNEL_LINEAR_READ_DEPENDENCY___GET_TERMS__BOOLEAN;

	/**
	 * The operation id for the '<em>Get Coefficients Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_READ_DEPENDENCY___GET_COEFFICIENTS_CONTEXT = CHANNEL_LINEAR_READ_DEPENDENCY___GET_COEFFICIENTS_CONTEXT;

	/**
	 * The operation id for the '<em>Get Channel</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_READ_DEPENDENCY___GET_CHANNEL = CHANNEL_LINEAR_READ_DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Linear Memory Read Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_READ_DEPENDENCY_OPERATION_COUNT = CHANNEL_LINEAR_READ_DEPENDENCY_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.structured.impl.ChannelLinearWriteDependencyImpl <em>Channel Linear Write Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.structured.impl.ChannelLinearWriteDependencyImpl
	 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getChannelLinearWriteDependency()
	 * @generated
	 */
	int CHANNEL_LINEAR_WRITE_DEPENDENCY = 21;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_LINEAR_WRITE_DEPENDENCY__SOURCE = CHANNEL_WRITE_DEPENDENCY__SOURCE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_LINEAR_WRITE_DEPENDENCY__REFERENCE = CHANNEL_WRITE_DEPENDENCY__REFERENCE;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_LINEAR_WRITE_DEPENDENCY__CHANNEL = CHANNEL_WRITE_DEPENDENCY__CHANNEL;

	/**
	 * The feature id for the '<em><b>Subscript</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_LINEAR_WRITE_DEPENDENCY__SUBSCRIPT = CHANNEL_WRITE_DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Channel Linear Write Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_LINEAR_WRITE_DEPENDENCY_FEATURE_COUNT = CHANNEL_WRITE_DEPENDENCY_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Terms</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_LINEAR_WRITE_DEPENDENCY___GET_TERMS__BOOLEAN = CHANNEL_WRITE_DEPENDENCY___GET_TERMS__BOOLEAN;

	/**
	 * The operation id for the '<em>Get Coefficients Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_LINEAR_WRITE_DEPENDENCY___GET_COEFFICIENTS_CONTEXT = CHANNEL_WRITE_DEPENDENCY___GET_COEFFICIENTS_CONTEXT;

	/**
	 * The number of operations of the '<em>Channel Linear Write Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANNEL_LINEAR_WRITE_DEPENDENCY_OPERATION_COUNT = CHANNEL_WRITE_DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.structured.impl.LinearMemoryWriteDependencyImpl <em>Linear Memory Write Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.structured.impl.LinearMemoryWriteDependencyImpl
	 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getLinearMemoryWriteDependency()
	 * @generated
	 */
	int LINEAR_MEMORY_WRITE_DEPENDENCY = 12;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_WRITE_DEPENDENCY__SOURCE = CHANNEL_LINEAR_WRITE_DEPENDENCY__SOURCE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_WRITE_DEPENDENCY__REFERENCE = CHANNEL_LINEAR_WRITE_DEPENDENCY__REFERENCE;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_WRITE_DEPENDENCY__CHANNEL = CHANNEL_LINEAR_WRITE_DEPENDENCY__CHANNEL;

	/**
	 * The feature id for the '<em><b>Subscript</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_WRITE_DEPENDENCY__SUBSCRIPT = CHANNEL_LINEAR_WRITE_DEPENDENCY__SUBSCRIPT;

	/**
	 * The number of structural features of the '<em>Linear Memory Write Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_WRITE_DEPENDENCY_FEATURE_COUNT = CHANNEL_LINEAR_WRITE_DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Terms</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_WRITE_DEPENDENCY___GET_TERMS__BOOLEAN = CHANNEL_LINEAR_WRITE_DEPENDENCY___GET_TERMS__BOOLEAN;

	/**
	 * The operation id for the '<em>Get Coefficients Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_WRITE_DEPENDENCY___GET_COEFFICIENTS_CONTEXT = CHANNEL_LINEAR_WRITE_DEPENDENCY___GET_COEFFICIENTS_CONTEXT;

	/**
	 * The operation id for the '<em>Get Channel</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_WRITE_DEPENDENCY___GET_CHANNEL = CHANNEL_LINEAR_WRITE_DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Linear Memory Write Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_WRITE_DEPENDENCY_OPERATION_COUNT = CHANNEL_LINEAR_WRITE_DEPENDENCY_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.structured.impl.BoundedChannelImpl <em>Bounded Channel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.structured.impl.BoundedChannelImpl
	 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getBoundedChannel()
	 * @generated
	 */
	int BOUNDED_CHANNEL = 13;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_CHANNEL__EDGES = CHANNEL__EDGES;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_CHANNEL__SOURCE = CHANNEL__SOURCE;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_CHANNEL__DESTINATION = CHANNEL__DESTINATION;

	/**
	 * The feature id for the '<em><b>Schedule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_CHANNEL__SCHEDULE = CHANNEL__SCHEDULE;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_CHANNEL__DOMAIN = CHANNEL__DOMAIN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_CHANNEL__NAME = CHANNEL__NAME;

	/**
	 * The feature id for the '<em><b>Subscript Dimension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_CHANNEL__SUBSCRIPT_DIMENSION = CHANNEL__SUBSCRIPT_DIMENSION;

	/**
	 * The feature id for the '<em><b>Maximal Channel Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_CHANNEL__MAXIMAL_CHANNEL_SIZE = CHANNEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Size Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_CHANNEL__SIZE_VARIABLE = CHANNEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Bounding Coefficients</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_CHANNEL__BOUNDING_COEFFICIENTS = CHANNEL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Bounded Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_CHANNEL_FEATURE_COUNT = CHANNEL_FEATURE_COUNT + 3;


	/**
	 * The operation id for the '<em>Get Bounding Coefficient</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_CHANNEL___GET_BOUNDING_COEFFICIENT__INT_INT = CHANNEL_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Bounded Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_CHANNEL_OPERATION_COUNT = CHANNEL_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.structured.impl.LinearMemoryAllocationDependencyImpl <em>Linear Memory Allocation Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.structured.impl.LinearMemoryAllocationDependencyImpl
	 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getLinearMemoryAllocationDependency()
	 * @generated
	 */
	int LINEAR_MEMORY_ALLOCATION_DEPENDENCY = 14;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_ALLOCATION_DEPENDENCY__SOURCE = CHANNEL_LINEAR_READ_DEPENDENCY__SOURCE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_ALLOCATION_DEPENDENCY__REFERENCE = CHANNEL_LINEAR_READ_DEPENDENCY__REFERENCE;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_ALLOCATION_DEPENDENCY__CHANNEL = CHANNEL_LINEAR_READ_DEPENDENCY__CHANNEL;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_ALLOCATION_DEPENDENCY__EDGE = CHANNEL_LINEAR_READ_DEPENDENCY__EDGE;

	/**
	 * The feature id for the '<em><b>Subscript</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_ALLOCATION_DEPENDENCY__SUBSCRIPT = CHANNEL_LINEAR_READ_DEPENDENCY__SUBSCRIPT;

	/**
	 * The number of structural features of the '<em>Linear Memory Allocation Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_ALLOCATION_DEPENDENCY_FEATURE_COUNT = CHANNEL_LINEAR_READ_DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Terms</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_ALLOCATION_DEPENDENCY___GET_TERMS__BOOLEAN = CHANNEL_LINEAR_READ_DEPENDENCY___GET_TERMS__BOOLEAN;

	/**
	 * The operation id for the '<em>Get Coefficients Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_ALLOCATION_DEPENDENCY___GET_COEFFICIENTS_CONTEXT = CHANNEL_LINEAR_READ_DEPENDENCY___GET_COEFFICIENTS_CONTEXT;

	/**
	 * The operation id for the '<em>Get Channel</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_ALLOCATION_DEPENDENCY___GET_CHANNEL = CHANNEL_LINEAR_READ_DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Linear Memory Allocation Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_ALLOCATION_DEPENDENCY_OPERATION_COUNT = CHANNEL_LINEAR_READ_DEPENDENCY_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.structured.impl.MemoryReadDependencyImpl <em>Memory Read Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.structured.impl.MemoryReadDependencyImpl
	 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getMemoryReadDependency()
	 * @generated
	 */
	int MEMORY_READ_DEPENDENCY = 15;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_READ_DEPENDENCY__SOURCE = CHANNEL_READ_DEPENDENCY__SOURCE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_READ_DEPENDENCY__REFERENCE = CHANNEL_READ_DEPENDENCY__REFERENCE;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_READ_DEPENDENCY__CHANNEL = CHANNEL_READ_DEPENDENCY__CHANNEL;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_READ_DEPENDENCY__EDGE = CHANNEL_READ_DEPENDENCY__EDGE;

	/**
	 * The feature id for the '<em><b>Dimension Sizes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_READ_DEPENDENCY__DIMENSION_SIZES = CHANNEL_READ_DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Memory Read Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_READ_DEPENDENCY_FEATURE_COUNT = CHANNEL_READ_DEPENDENCY_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Terms</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_READ_DEPENDENCY___GET_TERMS__BOOLEAN = CHANNEL_READ_DEPENDENCY___GET_TERMS__BOOLEAN;

	/**
	 * The operation id for the '<em>Get Coefficients Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_READ_DEPENDENCY___GET_COEFFICIENTS_CONTEXT = CHANNEL_READ_DEPENDENCY___GET_COEFFICIENTS_CONTEXT;

	/**
	 * The operation id for the '<em>Get Channel</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_READ_DEPENDENCY___GET_CHANNEL = CHANNEL_READ_DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Memory Read Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_READ_DEPENDENCY_OPERATION_COUNT = CHANNEL_READ_DEPENDENCY_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.structured.impl.MemoryWriteDependencyImpl <em>Memory Write Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.structured.impl.MemoryWriteDependencyImpl
	 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getMemoryWriteDependency()
	 * @generated
	 */
	int MEMORY_WRITE_DEPENDENCY = 16;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_WRITE_DEPENDENCY__SOURCE = CHANNEL_WRITE_DEPENDENCY__SOURCE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_WRITE_DEPENDENCY__REFERENCE = CHANNEL_WRITE_DEPENDENCY__REFERENCE;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_WRITE_DEPENDENCY__CHANNEL = CHANNEL_WRITE_DEPENDENCY__CHANNEL;

	/**
	 * The number of structural features of the '<em>Memory Write Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_WRITE_DEPENDENCY_FEATURE_COUNT = CHANNEL_WRITE_DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Terms</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_WRITE_DEPENDENCY___GET_TERMS__BOOLEAN = CHANNEL_WRITE_DEPENDENCY___GET_TERMS__BOOLEAN;

	/**
	 * The operation id for the '<em>Get Coefficients Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_WRITE_DEPENDENCY___GET_COEFFICIENTS_CONTEXT = CHANNEL_WRITE_DEPENDENCY___GET_COEFFICIENTS_CONTEXT;

	/**
	 * The operation id for the '<em>Get Channel</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_WRITE_DEPENDENCY___GET_CHANNEL = CHANNEL_WRITE_DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Memory Write Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_WRITE_DEPENDENCY_OPERATION_COUNT = CHANNEL_WRITE_DEPENDENCY_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.structured.impl.MemoryAllocationDependencyImpl <em>Memory Allocation Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.structured.impl.MemoryAllocationDependencyImpl
	 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getMemoryAllocationDependency()
	 * @generated
	 */
	int MEMORY_ALLOCATION_DEPENDENCY = 17;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_ALLOCATION_DEPENDENCY__SOURCE = CHANNEL_READ_DEPENDENCY__SOURCE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_ALLOCATION_DEPENDENCY__REFERENCE = CHANNEL_READ_DEPENDENCY__REFERENCE;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_ALLOCATION_DEPENDENCY__CHANNEL = CHANNEL_READ_DEPENDENCY__CHANNEL;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_ALLOCATION_DEPENDENCY__EDGE = CHANNEL_READ_DEPENDENCY__EDGE;

	/**
	 * The number of structural features of the '<em>Memory Allocation Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_ALLOCATION_DEPENDENCY_FEATURE_COUNT = CHANNEL_READ_DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Terms</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_ALLOCATION_DEPENDENCY___GET_TERMS__BOOLEAN = CHANNEL_READ_DEPENDENCY___GET_TERMS__BOOLEAN;

	/**
	 * The operation id for the '<em>Get Coefficients Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_ALLOCATION_DEPENDENCY___GET_COEFFICIENTS_CONTEXT = CHANNEL_READ_DEPENDENCY___GET_COEFFICIENTS_CONTEXT;

	/**
	 * The operation id for the '<em>Get Channel</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_ALLOCATION_DEPENDENCY___GET_CHANNEL = CHANNEL_READ_DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Memory Allocation Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_ALLOCATION_DEPENDENCY_OPERATION_COUNT = CHANNEL_READ_DEPENDENCY_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.structured.impl.MemoryDeallocationDependencyImpl <em>Memory Deallocation Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.structured.impl.MemoryDeallocationDependencyImpl
	 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getMemoryDeallocationDependency()
	 * @generated
	 */
	int MEMORY_DEALLOCATION_DEPENDENCY = 18;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_DEALLOCATION_DEPENDENCY__SOURCE = MEMORY_DEPENDENCY__SOURCE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_DEALLOCATION_DEPENDENCY__REFERENCE = MEMORY_DEPENDENCY__REFERENCE;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_DEALLOCATION_DEPENDENCY__CHANNEL = MEMORY_DEPENDENCY__CHANNEL;

	/**
	 * The feature id for the '<em><b>Dimension Sizes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_DEALLOCATION_DEPENDENCY__DIMENSION_SIZES = MEMORY_DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Memory Deallocation Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_DEALLOCATION_DEPENDENCY_FEATURE_COUNT = MEMORY_DEPENDENCY_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Terms</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_DEALLOCATION_DEPENDENCY___GET_TERMS__BOOLEAN = MEMORY_DEPENDENCY___GET_TERMS__BOOLEAN;

	/**
	 * The operation id for the '<em>Get Coefficients Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_DEALLOCATION_DEPENDENCY___GET_COEFFICIENTS_CONTEXT = MEMORY_DEPENDENCY___GET_COEFFICIENTS_CONTEXT;

	/**
	 * The operation id for the '<em>Get Channel</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_DEALLOCATION_DEPENDENCY___GET_CHANNEL = MEMORY_DEPENDENCY___GET_CHANNEL;

	/**
	 * The number of operations of the '<em>Memory Deallocation Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_DEALLOCATION_DEPENDENCY_OPERATION_COUNT = MEMORY_DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.structured.impl.LinearDependencyImpl <em>Linear Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.structured.impl.LinearDependencyImpl
	 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getLinearDependency()
	 * @generated
	 */
	int LINEAR_DEPENDENCY = 19;

	/**
	 * The feature id for the '<em><b>Subscript</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_DEPENDENCY__SUBSCRIPT = 0;

	/**
	 * The number of structural features of the '<em>Linear Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_DEPENDENCY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Linear Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_DEPENDENCY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.structured.impl.CompositeDependencyImpl <em>Composite Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.structured.impl.CompositeDependencyImpl
	 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getCompositeDependency()
	 * @generated
	 */
	int COMPOSITE_DEPENDENCY = 22;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DEPENDENCY__SOURCE = SchedulingPackage.DEPENDENCY__SOURCE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DEPENDENCY__REFERENCE = SchedulingPackage.DEPENDENCY__REFERENCE;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DEPENDENCY__DEPENDENCIES = SchedulingPackage.DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dependency Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DEPENDENCY__DEPENDENCY_DOMAIN = SchedulingPackage.DEPENDENCY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Composite Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DEPENDENCY_FEATURE_COUNT = SchedulingPackage.DEPENDENCY_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Terms</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DEPENDENCY___GET_TERMS__BOOLEAN = SchedulingPackage.DEPENDENCY___GET_TERMS__BOOLEAN;

	/**
	 * The operation id for the '<em>Get Coefficients Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DEPENDENCY___GET_COEFFICIENTS_CONTEXT = SchedulingPackage.DEPENDENCY___GET_COEFFICIENTS_CONTEXT;

	/**
	 * The number of operations of the '<em>Composite Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_DEPENDENCY_OPERATION_COUNT = SchedulingPackage.DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.structured.impl.MultidimDeallocationDependencyImpl <em>Multidim Deallocation Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.structured.impl.MultidimDeallocationDependencyImpl
	 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getMultidimDeallocationDependency()
	 * @generated
	 */
	int MULTIDIM_DEALLOCATION_DEPENDENCY = 23;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_DEALLOCATION_DEPENDENCY__DEPENDENCIES = MultidimPackage.MULTIDIM_DEPENDENCY__DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Dimension Sizes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_DEALLOCATION_DEPENDENCY__DIMENSION_SIZES = MultidimPackage.MULTIDIM_DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Multidim Deallocation Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_DEALLOCATION_DEPENDENCY_FEATURE_COUNT = MultidimPackage.MULTIDIM_DEPENDENCY_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Compute Constraints</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_DEALLOCATION_DEPENDENCY___COMPUTE_CONSTRAINTS = MultidimPackage.MULTIDIM_DEPENDENCY___COMPUTE_CONSTRAINTS;

	/**
	 * The operation id for the '<em>Get All Schedule Coefficients</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_DEALLOCATION_DEPENDENCY___GET_ALL_SCHEDULE_COEFFICIENTS = MultidimPackage.MULTIDIM_DEPENDENCY___GET_ALL_SCHEDULE_COEFFICIENTS;

	/**
	 * The operation id for the '<em>Get All Satisfaction Variables</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_DEALLOCATION_DEPENDENCY___GET_ALL_SATISFACTION_VARIABLES = MultidimPackage.MULTIDIM_DEPENDENCY___GET_ALL_SATISFACTION_VARIABLES;

	/**
	 * The operation id for the '<em>Get All Source Coefficients</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_DEALLOCATION_DEPENDENCY___GET_ALL_SOURCE_COEFFICIENTS = MultidimPackage.MULTIDIM_DEPENDENCY___GET_ALL_SOURCE_COEFFICIENTS;

	/**
	 * The operation id for the '<em>Get All Reference Coefficients</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_DEALLOCATION_DEPENDENCY___GET_ALL_REFERENCE_COEFFICIENTS = MultidimPackage.MULTIDIM_DEPENDENCY___GET_ALL_REFERENCE_COEFFICIENTS;

	/**
	 * The operation id for the '<em>Get Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_DEALLOCATION_DEPENDENCY___GET_DOMAIN = MultidimPackage.MULTIDIM_DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Channel</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_DEALLOCATION_DEPENDENCY___GET_CHANNEL = MultidimPackage.MULTIDIM_DEPENDENCY_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Multidim Deallocation Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_DEALLOCATION_DEPENDENCY_OPERATION_COUNT = MultidimPackage.MULTIDIM_DEPENDENCY_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.structured.impl.MultidimMemoryReadDependencyComponentImpl <em>Multidim Memory Read Dependency Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.structured.impl.MultidimMemoryReadDependencyComponentImpl
	 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getMultidimMemoryReadDependencyComponent()
	 * @generated
	 */
	int MULTIDIM_MEMORY_READ_DEPENDENCY_COMPONENT = 24;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_MEMORY_READ_DEPENDENCY_COMPONENT__SOURCE = MEMORY_READ_DEPENDENCY__SOURCE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_MEMORY_READ_DEPENDENCY_COMPONENT__REFERENCE = MEMORY_READ_DEPENDENCY__REFERENCE;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_MEMORY_READ_DEPENDENCY_COMPONENT__CHANNEL = MEMORY_READ_DEPENDENCY__CHANNEL;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_MEMORY_READ_DEPENDENCY_COMPONENT__EDGE = MEMORY_READ_DEPENDENCY__EDGE;

	/**
	 * The feature id for the '<em><b>Dimension Sizes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_MEMORY_READ_DEPENDENCY_COMPONENT__DIMENSION_SIZES = MEMORY_READ_DEPENDENCY__DIMENSION_SIZES;

	/**
	 * The feature id for the '<em><b>Dimension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_MEMORY_READ_DEPENDENCY_COMPONENT__DIMENSION = MEMORY_READ_DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Multidim Memory Read Dependency Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_MEMORY_READ_DEPENDENCY_COMPONENT_FEATURE_COUNT = MEMORY_READ_DEPENDENCY_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Terms</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_MEMORY_READ_DEPENDENCY_COMPONENT___GET_TERMS__BOOLEAN = MEMORY_READ_DEPENDENCY___GET_TERMS__BOOLEAN;

	/**
	 * The operation id for the '<em>Get Coefficients Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_MEMORY_READ_DEPENDENCY_COMPONENT___GET_COEFFICIENTS_CONTEXT = MEMORY_READ_DEPENDENCY___GET_COEFFICIENTS_CONTEXT;

	/**
	 * The operation id for the '<em>Get Channel</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_MEMORY_READ_DEPENDENCY_COMPONENT___GET_CHANNEL = MEMORY_READ_DEPENDENCY___GET_CHANNEL;

	/**
	 * The number of operations of the '<em>Multidim Memory Read Dependency Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIDIM_MEMORY_READ_DEPENDENCY_COMPONENT_OPERATION_COUNT = MEMORY_READ_DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.structured.impl.BoundingCoefficientImpl <em>Bounding Coefficient</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.structured.impl.BoundingCoefficientImpl
	 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getBoundingCoefficient()
	 * @generated
	 */
	int BOUNDING_COEFFICIENT = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDING_COEFFICIENT__NAME = AlgebraPackage.VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDING_COEFFICIENT__INDEX = AlgebraPackage.VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dimension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDING_COEFFICIENT__DIMENSION = AlgebraPackage.VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bounding Coefficient</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDING_COEFFICIENT_FEATURE_COUNT = AlgebraPackage.VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDING_COEFFICIENT___ACCEPT__ALGEBRAVISITOR = AlgebraPackage.VARIABLE___ACCEPT__ALGEBRAVISITOR;

	/**
	 * The number of operations of the '<em>Bounding Coefficient</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDING_COEFFICIENT_OPERATION_COUNT = AlgebraPackage.VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.prdg.scheduling.structured.impl.LinearMemoryDeallocationDependencyImpl <em>Linear Memory Deallocation Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.prdg.scheduling.structured.impl.LinearMemoryDeallocationDependencyImpl
	 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getLinearMemoryDeallocationDependency()
	 * @generated
	 */
	int LINEAR_MEMORY_DEALLOCATION_DEPENDENCY = 26;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_DEALLOCATION_DEPENDENCY__SOURCE = MEMORY_DEPENDENCY__SOURCE;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_DEALLOCATION_DEPENDENCY__REFERENCE = MEMORY_DEPENDENCY__REFERENCE;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_DEALLOCATION_DEPENDENCY__CHANNEL = MEMORY_DEPENDENCY__CHANNEL;

	/**
	 * The feature id for the '<em><b>Subscript</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_DEALLOCATION_DEPENDENCY__SUBSCRIPT = MEMORY_DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Linear Memory Deallocation Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_DEALLOCATION_DEPENDENCY_FEATURE_COUNT = MEMORY_DEPENDENCY_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Terms</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_DEALLOCATION_DEPENDENCY___GET_TERMS__BOOLEAN = MEMORY_DEPENDENCY___GET_TERMS__BOOLEAN;

	/**
	 * The operation id for the '<em>Get Coefficients Context</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_DEALLOCATION_DEPENDENCY___GET_COEFFICIENTS_CONTEXT = MEMORY_DEPENDENCY___GET_COEFFICIENTS_CONTEXT;

	/**
	 * The operation id for the '<em>Get Channel</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_DEALLOCATION_DEPENDENCY___GET_CHANNEL = MEMORY_DEPENDENCY___GET_CHANNEL;

	/**
	 * The number of operations of the '<em>Linear Memory Deallocation Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINEAR_MEMORY_DEALLOCATION_DEPENDENCY_OPERATION_COUNT = MEMORY_DEPENDENCY_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.structured.Channel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Channel</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.Channel
	 * @generated
	 */
	EClass getChannel();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.prdg.scheduling.structured.Channel#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Edges</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.Channel#getEdges()
	 * @see #getChannel()
	 * @generated
	 */
	EReference getChannel_Edges();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.prdg.scheduling.structured.Channel#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.Channel#getSource()
	 * @see #getChannel()
	 * @generated
	 */
	EReference getChannel_Source();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.prdg.scheduling.structured.Channel#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Destination</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.Channel#getDestination()
	 * @see #getChannel()
	 * @generated
	 */
	EReference getChannel_Destination();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.prdg.scheduling.structured.Channel#getSchedule <em>Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Schedule</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.Channel#getSchedule()
	 * @see #getChannel()
	 * @generated
	 */
	EReference getChannel_Schedule();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.prdg.scheduling.structured.Channel#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domain</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.Channel#getDomain()
	 * @see #getChannel()
	 * @generated
	 */
	EReference getChannel_Domain();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.prdg.scheduling.structured.Channel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.Channel#getName()
	 * @see #getChannel()
	 * @generated
	 */
	EAttribute getChannel_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.prdg.scheduling.structured.Channel#getSubscriptDimension <em>Subscript Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Subscript Dimension</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.Channel#getSubscriptDimension()
	 * @see #getChannel()
	 * @generated
	 */
	EReference getChannel_SubscriptDimension();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.structured.Process <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.Process
	 * @generated
	 */
	EClass getProcess();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.prdg.scheduling.structured.Process#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inputs</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.Process#getInputs()
	 * @see #getProcess()
	 * @generated
	 */
	EReference getProcess_Inputs();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.prdg.scheduling.structured.Process#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outputs</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.Process#getOutputs()
	 * @see #getProcess()
	 * @generated
	 */
	EReference getProcess_Outputs();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.prdg.scheduling.structured.Process#getInternalNodes <em>Internal Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Internal Nodes</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.Process#getInternalNodes()
	 * @see #getProcess()
	 * @generated
	 */
	EReference getProcess_InternalNodes();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.prdg.scheduling.structured.Process#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.Process#getName()
	 * @see #getProcess()
	 * @generated
	 */
	EAttribute getProcess_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.prdg.scheduling.structured.Process#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constraints</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.Process#getConstraints()
	 * @see #getProcess()
	 * @generated
	 */
	EReference getProcess_Constraints();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.structured.ProcessNetwork <em>Process Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Network</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.ProcessNetwork
	 * @generated
	 */
	EClass getProcessNetwork();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.prdg.scheduling.structured.ProcessNetwork#getProcesses <em>Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Processes</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.ProcessNetwork#getProcesses()
	 * @see #getProcessNetwork()
	 * @generated
	 */
	EReference getProcessNetwork_Processes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.prdg.scheduling.structured.ProcessNetwork#getChannels <em>Channels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Channels</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.ProcessNetwork#getChannels()
	 * @see #getProcessNetwork()
	 * @generated
	 */
	EReference getProcessNetwork_Channels();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.prdg.scheduling.structured.ProcessNetwork#getPrdg <em>Prdg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Prdg</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.ProcessNetwork#getPrdg()
	 * @see #getProcessNetwork()
	 * @generated
	 */
	EReference getProcessNetwork_Prdg();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.structured.DataPort <em>Data Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Port</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.DataPort
	 * @generated
	 */
	EClass getDataPort();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.scheduling.structured.DataPort#getChannel() <em>Get Channel</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Channel</em>' operation.
	 * @see org.polymodel.prdg.scheduling.structured.DataPort#getChannel()
	 * @generated
	 */
	EOperation getDataPort__GetChannel();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.structured.InputPort <em>Input Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Port</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.InputPort
	 * @generated
	 */
	EClass getInputPort();

	/**
	 * Returns the meta object for the container reference '{@link org.polymodel.prdg.scheduling.structured.InputPort#getChannel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Channel</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.InputPort#getChannel()
	 * @see #getInputPort()
	 * @generated
	 */
	EReference getInputPort_Channel();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.structured.OutputPort <em>Output Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Port</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.OutputPort
	 * @generated
	 */
	EClass getOutputPort();

	/**
	 * Returns the meta object for the container reference '{@link org.polymodel.prdg.scheduling.structured.OutputPort#getChannel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Channel</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.OutputPort#getChannel()
	 * @see #getOutputPort()
	 * @generated
	 */
	EReference getOutputPort_Channel();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.scheduling.structured.OutputPort#getSourceNode() <em>Get Source Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Source Node</em>' operation.
	 * @see org.polymodel.prdg.scheduling.structured.OutputPort#getSourceNode()
	 * @generated
	 */
	EOperation getOutputPort__GetSourceNode();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.structured.ChannelSchedulePrototype <em>Channel Schedule Prototype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Channel Schedule Prototype</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.ChannelSchedulePrototype
	 * @generated
	 */
	EClass getChannelSchedulePrototype();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.prdg.scheduling.structured.ChannelSchedulePrototype#getChannel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Channel</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.ChannelSchedulePrototype#getChannel()
	 * @see #getChannelSchedulePrototype()
	 * @generated
	 */
	EReference getChannelSchedulePrototype_Channel();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.structured.ChannelDependency <em>Channel Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Channel Dependency</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.ChannelDependency
	 * @generated
	 */
	EClass getChannelDependency();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.prdg.scheduling.structured.ChannelDependency#getChannel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Channel</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.ChannelDependency#getChannel()
	 * @see #getChannelDependency()
	 * @generated
	 */
	EReference getChannelDependency_Channel();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.structured.ChannelReadDependency <em>Channel Read Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Channel Read Dependency</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.ChannelReadDependency
	 * @generated
	 */
	EClass getChannelReadDependency();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.prdg.scheduling.structured.ChannelReadDependency#getEdge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Edge</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.ChannelReadDependency#getEdge()
	 * @see #getChannelReadDependency()
	 * @generated
	 */
	EReference getChannelReadDependency_Edge();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.structured.ChannelWriteDependency <em>Channel Write Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Channel Write Dependency</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.ChannelWriteDependency
	 * @generated
	 */
	EClass getChannelWriteDependency();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.structured.MemoryDependency <em>Memory Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Memory Dependency</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.MemoryDependency
	 * @generated
	 */
	EClass getMemoryDependency();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.scheduling.structured.MemoryDependency#getChannel() <em>Get Channel</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Channel</em>' operation.
	 * @see org.polymodel.prdg.scheduling.structured.MemoryDependency#getChannel()
	 * @generated
	 */
	EOperation getMemoryDependency__GetChannel();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.structured.LinearMemoryReadDependency <em>Linear Memory Read Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linear Memory Read Dependency</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.LinearMemoryReadDependency
	 * @generated
	 */
	EClass getLinearMemoryReadDependency();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.structured.LinearMemoryWriteDependency <em>Linear Memory Write Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linear Memory Write Dependency</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.LinearMemoryWriteDependency
	 * @generated
	 */
	EClass getLinearMemoryWriteDependency();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.structured.BoundedChannel <em>Bounded Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bounded Channel</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.BoundedChannel
	 * @generated
	 */
	EClass getBoundedChannel();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.prdg.scheduling.structured.BoundedChannel#getMaximalChannelSize <em>Maximal Channel Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximal Channel Size</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.BoundedChannel#getMaximalChannelSize()
	 * @see #getBoundedChannel()
	 * @generated
	 */
	EAttribute getBoundedChannel_MaximalChannelSize();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.prdg.scheduling.structured.BoundedChannel#getSizeVariable <em>Size Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Size Variable</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.BoundedChannel#getSizeVariable()
	 * @see #getBoundedChannel()
	 * @generated
	 */
	EReference getBoundedChannel_SizeVariable();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.prdg.scheduling.structured.BoundedChannel#getBoundingCoefficients <em>Bounding Coefficients</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bounding Coefficients</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.BoundedChannel#getBoundingCoefficients()
	 * @see #getBoundedChannel()
	 * @generated
	 */
	EReference getBoundedChannel_BoundingCoefficients();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.scheduling.structured.BoundedChannel#getBoundingCoefficient(int, int) <em>Get Bounding Coefficient</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Bounding Coefficient</em>' operation.
	 * @see org.polymodel.prdg.scheduling.structured.BoundedChannel#getBoundingCoefficient(int, int)
	 * @generated
	 */
	EOperation getBoundedChannel__GetBoundingCoefficient__int_int();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.structured.LinearMemoryAllocationDependency <em>Linear Memory Allocation Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linear Memory Allocation Dependency</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.LinearMemoryAllocationDependency
	 * @generated
	 */
	EClass getLinearMemoryAllocationDependency();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.structured.MemoryReadDependency <em>Memory Read Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Memory Read Dependency</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.MemoryReadDependency
	 * @generated
	 */
	EClass getMemoryReadDependency();

	/**
	 * Returns the meta object for the attribute list '{@link org.polymodel.prdg.scheduling.structured.MemoryReadDependency#getDimensionSizes <em>Dimension Sizes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Dimension Sizes</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.MemoryReadDependency#getDimensionSizes()
	 * @see #getMemoryReadDependency()
	 * @generated
	 */
	EAttribute getMemoryReadDependency_DimensionSizes();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.structured.MemoryWriteDependency <em>Memory Write Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Memory Write Dependency</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.MemoryWriteDependency
	 * @generated
	 */
	EClass getMemoryWriteDependency();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.structured.MemoryAllocationDependency <em>Memory Allocation Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Memory Allocation Dependency</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.MemoryAllocationDependency
	 * @generated
	 */
	EClass getMemoryAllocationDependency();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.structured.MemoryDeallocationDependency <em>Memory Deallocation Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Memory Deallocation Dependency</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.MemoryDeallocationDependency
	 * @generated
	 */
	EClass getMemoryDeallocationDependency();

	/**
	 * Returns the meta object for the attribute list '{@link org.polymodel.prdg.scheduling.structured.MemoryDeallocationDependency#getDimensionSizes <em>Dimension Sizes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Dimension Sizes</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.MemoryDeallocationDependency#getDimensionSizes()
	 * @see #getMemoryDeallocationDependency()
	 * @generated
	 */
	EAttribute getMemoryDeallocationDependency_DimensionSizes();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.structured.LinearDependency <em>Linear Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linear Dependency</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.LinearDependency
	 * @generated
	 */
	EClass getLinearDependency();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.prdg.scheduling.structured.LinearDependency#getSubscript <em>Subscript</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Subscript</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.LinearDependency#getSubscript()
	 * @see #getLinearDependency()
	 * @generated
	 */
	EReference getLinearDependency_Subscript();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.structured.ChannelLinearReadDependency <em>Channel Linear Read Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Channel Linear Read Dependency</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.ChannelLinearReadDependency
	 * @generated
	 */
	EClass getChannelLinearReadDependency();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.structured.ChannelLinearWriteDependency <em>Channel Linear Write Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Channel Linear Write Dependency</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.ChannelLinearWriteDependency
	 * @generated
	 */
	EClass getChannelLinearWriteDependency();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.structured.CompositeDependency <em>Composite Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Dependency</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.CompositeDependency
	 * @generated
	 */
	EClass getCompositeDependency();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.prdg.scheduling.structured.CompositeDependency#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependencies</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.CompositeDependency#getDependencies()
	 * @see #getCompositeDependency()
	 * @generated
	 */
	EReference getCompositeDependency_Dependencies();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.prdg.scheduling.structured.CompositeDependency#getDependencyDomain <em>Dependency Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dependency Domain</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.CompositeDependency#getDependencyDomain()
	 * @see #getCompositeDependency()
	 * @generated
	 */
	EReference getCompositeDependency_DependencyDomain();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.structured.MultidimDeallocationDependency <em>Multidim Deallocation Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multidim Deallocation Dependency</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.MultidimDeallocationDependency
	 * @generated
	 */
	EClass getMultidimDeallocationDependency();

	/**
	 * Returns the meta object for the attribute list '{@link org.polymodel.prdg.scheduling.structured.MultidimDeallocationDependency#getDimensionSizes <em>Dimension Sizes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Dimension Sizes</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.MultidimDeallocationDependency#getDimensionSizes()
	 * @see #getMultidimDeallocationDependency()
	 * @generated
	 */
	EAttribute getMultidimDeallocationDependency_DimensionSizes();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.scheduling.structured.MultidimDeallocationDependency#getDomain() <em>Get Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Domain</em>' operation.
	 * @see org.polymodel.prdg.scheduling.structured.MultidimDeallocationDependency#getDomain()
	 * @generated
	 */
	EOperation getMultidimDeallocationDependency__GetDomain();

	/**
	 * Returns the meta object for the '{@link org.polymodel.prdg.scheduling.structured.MultidimDeallocationDependency#getChannel() <em>Get Channel</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Channel</em>' operation.
	 * @see org.polymodel.prdg.scheduling.structured.MultidimDeallocationDependency#getChannel()
	 * @generated
	 */
	EOperation getMultidimDeallocationDependency__GetChannel();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.structured.MultidimMemoryReadDependencyComponent <em>Multidim Memory Read Dependency Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multidim Memory Read Dependency Component</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.MultidimMemoryReadDependencyComponent
	 * @generated
	 */
	EClass getMultidimMemoryReadDependencyComponent();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.prdg.scheduling.structured.MultidimMemoryReadDependencyComponent#getDimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dimension</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.MultidimMemoryReadDependencyComponent#getDimension()
	 * @see #getMultidimMemoryReadDependencyComponent()
	 * @generated
	 */
	EAttribute getMultidimMemoryReadDependencyComponent_Dimension();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.structured.BoundingCoefficient <em>Bounding Coefficient</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bounding Coefficient</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.BoundingCoefficient
	 * @generated
	 */
	EClass getBoundingCoefficient();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.prdg.scheduling.structured.BoundingCoefficient#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.BoundingCoefficient#getIndex()
	 * @see #getBoundingCoefficient()
	 * @generated
	 */
	EAttribute getBoundingCoefficient_Index();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.prdg.scheduling.structured.BoundingCoefficient#getDimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dimension</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.BoundingCoefficient#getDimension()
	 * @see #getBoundingCoefficient()
	 * @generated
	 */
	EAttribute getBoundingCoefficient_Dimension();

	/**
	 * Returns the meta object for class '{@link org.polymodel.prdg.scheduling.structured.LinearMemoryDeallocationDependency <em>Linear Memory Deallocation Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linear Memory Deallocation Dependency</em>'.
	 * @see org.polymodel.prdg.scheduling.structured.LinearMemoryDeallocationDependency
	 * @generated
	 */
	EClass getLinearMemoryDeallocationDependency();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StructuredFactory getStructuredFactory();

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
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.structured.impl.ChannelImpl <em>Channel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.structured.impl.ChannelImpl
		 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getChannel()
		 * @generated
		 */
		EClass CHANNEL = eINSTANCE.getChannel();

		/**
		 * The meta object literal for the '<em><b>Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANNEL__EDGES = eINSTANCE.getChannel_Edges();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANNEL__SOURCE = eINSTANCE.getChannel_Source();

		/**
		 * The meta object literal for the '<em><b>Destination</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANNEL__DESTINATION = eINSTANCE.getChannel_Destination();

		/**
		 * The meta object literal for the '<em><b>Schedule</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANNEL__SCHEDULE = eINSTANCE.getChannel_Schedule();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANNEL__DOMAIN = eINSTANCE.getChannel_Domain();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHANNEL__NAME = eINSTANCE.getChannel_Name();

		/**
		 * The meta object literal for the '<em><b>Subscript Dimension</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANNEL__SUBSCRIPT_DIMENSION = eINSTANCE.getChannel_SubscriptDimension();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.structured.impl.ProcessImpl <em>Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.structured.impl.ProcessImpl
		 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getProcess()
		 * @generated
		 */
		EClass PROCESS = eINSTANCE.getProcess();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS__INPUTS = eINSTANCE.getProcess_Inputs();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS__OUTPUTS = eINSTANCE.getProcess_Outputs();

		/**
		 * The meta object literal for the '<em><b>Internal Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS__INTERNAL_NODES = eINSTANCE.getProcess_InternalNodes();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS__NAME = eINSTANCE.getProcess_Name();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS__CONSTRAINTS = eINSTANCE.getProcess_Constraints();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.structured.impl.ProcessNetworkImpl <em>Process Network</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.structured.impl.ProcessNetworkImpl
		 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getProcessNetwork()
		 * @generated
		 */
		EClass PROCESS_NETWORK = eINSTANCE.getProcessNetwork();

		/**
		 * The meta object literal for the '<em><b>Processes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_NETWORK__PROCESSES = eINSTANCE.getProcessNetwork_Processes();

		/**
		 * The meta object literal for the '<em><b>Channels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_NETWORK__CHANNELS = eINSTANCE.getProcessNetwork_Channels();

		/**
		 * The meta object literal for the '<em><b>Prdg</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_NETWORK__PRDG = eINSTANCE.getProcessNetwork_Prdg();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.structured.impl.DataPortImpl <em>Data Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.structured.impl.DataPortImpl
		 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getDataPort()
		 * @generated
		 */
		EClass DATA_PORT = eINSTANCE.getDataPort();

		/**
		 * The meta object literal for the '<em><b>Get Channel</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DATA_PORT___GET_CHANNEL = eINSTANCE.getDataPort__GetChannel();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.structured.impl.InputPortImpl <em>Input Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.structured.impl.InputPortImpl
		 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getInputPort()
		 * @generated
		 */
		EClass INPUT_PORT = eINSTANCE.getInputPort();

		/**
		 * The meta object literal for the '<em><b>Channel</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_PORT__CHANNEL = eINSTANCE.getInputPort_Channel();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.structured.impl.OutputPortImpl <em>Output Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.structured.impl.OutputPortImpl
		 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getOutputPort()
		 * @generated
		 */
		EClass OUTPUT_PORT = eINSTANCE.getOutputPort();

		/**
		 * The meta object literal for the '<em><b>Channel</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_PORT__CHANNEL = eINSTANCE.getOutputPort_Channel();

		/**
		 * The meta object literal for the '<em><b>Get Source Node</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OUTPUT_PORT___GET_SOURCE_NODE = eINSTANCE.getOutputPort__GetSourceNode();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.structured.impl.ChannelSchedulePrototypeImpl <em>Channel Schedule Prototype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.structured.impl.ChannelSchedulePrototypeImpl
		 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getChannelSchedulePrototype()
		 * @generated
		 */
		EClass CHANNEL_SCHEDULE_PROTOTYPE = eINSTANCE.getChannelSchedulePrototype();

		/**
		 * The meta object literal for the '<em><b>Channel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANNEL_SCHEDULE_PROTOTYPE__CHANNEL = eINSTANCE.getChannelSchedulePrototype_Channel();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.structured.impl.ChannelDependencyImpl <em>Channel Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.structured.impl.ChannelDependencyImpl
		 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getChannelDependency()
		 * @generated
		 */
		EClass CHANNEL_DEPENDENCY = eINSTANCE.getChannelDependency();

		/**
		 * The meta object literal for the '<em><b>Channel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANNEL_DEPENDENCY__CHANNEL = eINSTANCE.getChannelDependency_Channel();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.structured.impl.ChannelReadDependencyImpl <em>Channel Read Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.structured.impl.ChannelReadDependencyImpl
		 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getChannelReadDependency()
		 * @generated
		 */
		EClass CHANNEL_READ_DEPENDENCY = eINSTANCE.getChannelReadDependency();

		/**
		 * The meta object literal for the '<em><b>Edge</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANNEL_READ_DEPENDENCY__EDGE = eINSTANCE.getChannelReadDependency_Edge();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.structured.impl.ChannelWriteDependencyImpl <em>Channel Write Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.structured.impl.ChannelWriteDependencyImpl
		 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getChannelWriteDependency()
		 * @generated
		 */
		EClass CHANNEL_WRITE_DEPENDENCY = eINSTANCE.getChannelWriteDependency();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.structured.impl.MemoryDependencyImpl <em>Memory Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.structured.impl.MemoryDependencyImpl
		 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getMemoryDependency()
		 * @generated
		 */
		EClass MEMORY_DEPENDENCY = eINSTANCE.getMemoryDependency();

		/**
		 * The meta object literal for the '<em><b>Get Channel</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MEMORY_DEPENDENCY___GET_CHANNEL = eINSTANCE.getMemoryDependency__GetChannel();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.structured.impl.LinearMemoryReadDependencyImpl <em>Linear Memory Read Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.structured.impl.LinearMemoryReadDependencyImpl
		 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getLinearMemoryReadDependency()
		 * @generated
		 */
		EClass LINEAR_MEMORY_READ_DEPENDENCY = eINSTANCE.getLinearMemoryReadDependency();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.structured.impl.LinearMemoryWriteDependencyImpl <em>Linear Memory Write Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.structured.impl.LinearMemoryWriteDependencyImpl
		 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getLinearMemoryWriteDependency()
		 * @generated
		 */
		EClass LINEAR_MEMORY_WRITE_DEPENDENCY = eINSTANCE.getLinearMemoryWriteDependency();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.structured.impl.BoundedChannelImpl <em>Bounded Channel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.structured.impl.BoundedChannelImpl
		 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getBoundedChannel()
		 * @generated
		 */
		EClass BOUNDED_CHANNEL = eINSTANCE.getBoundedChannel();

		/**
		 * The meta object literal for the '<em><b>Maximal Channel Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDED_CHANNEL__MAXIMAL_CHANNEL_SIZE = eINSTANCE.getBoundedChannel_MaximalChannelSize();

		/**
		 * The meta object literal for the '<em><b>Size Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOUNDED_CHANNEL__SIZE_VARIABLE = eINSTANCE.getBoundedChannel_SizeVariable();

		/**
		 * The meta object literal for the '<em><b>Bounding Coefficients</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOUNDED_CHANNEL__BOUNDING_COEFFICIENTS = eINSTANCE.getBoundedChannel_BoundingCoefficients();

		/**
		 * The meta object literal for the '<em><b>Get Bounding Coefficient</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOUNDED_CHANNEL___GET_BOUNDING_COEFFICIENT__INT_INT = eINSTANCE.getBoundedChannel__GetBoundingCoefficient__int_int();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.structured.impl.LinearMemoryAllocationDependencyImpl <em>Linear Memory Allocation Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.structured.impl.LinearMemoryAllocationDependencyImpl
		 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getLinearMemoryAllocationDependency()
		 * @generated
		 */
		EClass LINEAR_MEMORY_ALLOCATION_DEPENDENCY = eINSTANCE.getLinearMemoryAllocationDependency();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.structured.impl.MemoryReadDependencyImpl <em>Memory Read Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.structured.impl.MemoryReadDependencyImpl
		 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getMemoryReadDependency()
		 * @generated
		 */
		EClass MEMORY_READ_DEPENDENCY = eINSTANCE.getMemoryReadDependency();

		/**
		 * The meta object literal for the '<em><b>Dimension Sizes</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMORY_READ_DEPENDENCY__DIMENSION_SIZES = eINSTANCE.getMemoryReadDependency_DimensionSizes();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.structured.impl.MemoryWriteDependencyImpl <em>Memory Write Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.structured.impl.MemoryWriteDependencyImpl
		 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getMemoryWriteDependency()
		 * @generated
		 */
		EClass MEMORY_WRITE_DEPENDENCY = eINSTANCE.getMemoryWriteDependency();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.structured.impl.MemoryAllocationDependencyImpl <em>Memory Allocation Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.structured.impl.MemoryAllocationDependencyImpl
		 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getMemoryAllocationDependency()
		 * @generated
		 */
		EClass MEMORY_ALLOCATION_DEPENDENCY = eINSTANCE.getMemoryAllocationDependency();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.structured.impl.MemoryDeallocationDependencyImpl <em>Memory Deallocation Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.structured.impl.MemoryDeallocationDependencyImpl
		 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getMemoryDeallocationDependency()
		 * @generated
		 */
		EClass MEMORY_DEALLOCATION_DEPENDENCY = eINSTANCE.getMemoryDeallocationDependency();

		/**
		 * The meta object literal for the '<em><b>Dimension Sizes</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMORY_DEALLOCATION_DEPENDENCY__DIMENSION_SIZES = eINSTANCE.getMemoryDeallocationDependency_DimensionSizes();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.structured.impl.LinearDependencyImpl <em>Linear Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.structured.impl.LinearDependencyImpl
		 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getLinearDependency()
		 * @generated
		 */
		EClass LINEAR_DEPENDENCY = eINSTANCE.getLinearDependency();

		/**
		 * The meta object literal for the '<em><b>Subscript</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINEAR_DEPENDENCY__SUBSCRIPT = eINSTANCE.getLinearDependency_Subscript();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.structured.impl.ChannelLinearReadDependencyImpl <em>Channel Linear Read Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.structured.impl.ChannelLinearReadDependencyImpl
		 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getChannelLinearReadDependency()
		 * @generated
		 */
		EClass CHANNEL_LINEAR_READ_DEPENDENCY = eINSTANCE.getChannelLinearReadDependency();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.structured.impl.ChannelLinearWriteDependencyImpl <em>Channel Linear Write Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.structured.impl.ChannelLinearWriteDependencyImpl
		 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getChannelLinearWriteDependency()
		 * @generated
		 */
		EClass CHANNEL_LINEAR_WRITE_DEPENDENCY = eINSTANCE.getChannelLinearWriteDependency();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.structured.impl.CompositeDependencyImpl <em>Composite Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.structured.impl.CompositeDependencyImpl
		 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getCompositeDependency()
		 * @generated
		 */
		EClass COMPOSITE_DEPENDENCY = eINSTANCE.getCompositeDependency();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_DEPENDENCY__DEPENDENCIES = eINSTANCE.getCompositeDependency_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Dependency Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_DEPENDENCY__DEPENDENCY_DOMAIN = eINSTANCE.getCompositeDependency_DependencyDomain();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.structured.impl.MultidimDeallocationDependencyImpl <em>Multidim Deallocation Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.structured.impl.MultidimDeallocationDependencyImpl
		 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getMultidimDeallocationDependency()
		 * @generated
		 */
		EClass MULTIDIM_DEALLOCATION_DEPENDENCY = eINSTANCE.getMultidimDeallocationDependency();

		/**
		 * The meta object literal for the '<em><b>Dimension Sizes</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIDIM_DEALLOCATION_DEPENDENCY__DIMENSION_SIZES = eINSTANCE.getMultidimDeallocationDependency_DimensionSizes();

		/**
		 * The meta object literal for the '<em><b>Get Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MULTIDIM_DEALLOCATION_DEPENDENCY___GET_DOMAIN = eINSTANCE.getMultidimDeallocationDependency__GetDomain();

		/**
		 * The meta object literal for the '<em><b>Get Channel</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MULTIDIM_DEALLOCATION_DEPENDENCY___GET_CHANNEL = eINSTANCE.getMultidimDeallocationDependency__GetChannel();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.structured.impl.MultidimMemoryReadDependencyComponentImpl <em>Multidim Memory Read Dependency Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.structured.impl.MultidimMemoryReadDependencyComponentImpl
		 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getMultidimMemoryReadDependencyComponent()
		 * @generated
		 */
		EClass MULTIDIM_MEMORY_READ_DEPENDENCY_COMPONENT = eINSTANCE.getMultidimMemoryReadDependencyComponent();

		/**
		 * The meta object literal for the '<em><b>Dimension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIDIM_MEMORY_READ_DEPENDENCY_COMPONENT__DIMENSION = eINSTANCE.getMultidimMemoryReadDependencyComponent_Dimension();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.structured.impl.BoundingCoefficientImpl <em>Bounding Coefficient</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.structured.impl.BoundingCoefficientImpl
		 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getBoundingCoefficient()
		 * @generated
		 */
		EClass BOUNDING_COEFFICIENT = eINSTANCE.getBoundingCoefficient();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDING_COEFFICIENT__INDEX = eINSTANCE.getBoundingCoefficient_Index();

		/**
		 * The meta object literal for the '<em><b>Dimension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOUNDING_COEFFICIENT__DIMENSION = eINSTANCE.getBoundingCoefficient_Dimension();

		/**
		 * The meta object literal for the '{@link org.polymodel.prdg.scheduling.structured.impl.LinearMemoryDeallocationDependencyImpl <em>Linear Memory Deallocation Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.prdg.scheduling.structured.impl.LinearMemoryDeallocationDependencyImpl
		 * @see org.polymodel.prdg.scheduling.structured.impl.StructuredPackageImpl#getLinearMemoryDeallocationDependency()
		 * @generated
		 */
		EClass LINEAR_MEMORY_DEALLOCATION_DEPENDENCY = eINSTANCE.getLinearMemoryDeallocationDependency();

	}

} //StructuredPackage
