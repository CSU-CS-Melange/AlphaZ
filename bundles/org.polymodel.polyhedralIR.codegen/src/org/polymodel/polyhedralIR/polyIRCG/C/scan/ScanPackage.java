/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.scan;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;

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
 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanFactory
 * @model kind="package"
 * @generated
 */
public interface ScanPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "scan";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "scan";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "scan";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ScanPackage eINSTANCE = org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.BoundComputationImpl <em>Bound Computation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.BoundComputationImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanPackageImpl#getBoundComputation()
	 * @generated
	 */
	int BOUND_COMPUTATION = 0;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_COMPUTATION__FUNCTION = PolyIRCGPackage.BODY__FUNCTION;

	/**
	 * The feature id for the '<em><b>Lb</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_COMPUTATION__LB = PolyIRCGPackage.BODY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ub</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_COMPUTATION__UB = PolyIRCGPackage.BODY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constant Term</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_COMPUTATION__CONSTANT_TERM = PolyIRCGPackage.BODY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Volume Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_COMPUTATION__VOLUME_FUNCTION = PolyIRCGPackage.BODY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Volume Function Derivative</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_COMPUTATION__VOLUME_FUNCTION_DERIVATIVE = PolyIRCGPackage.BODY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_COMPUTATION__INITIAL_VALUE = PolyIRCGPackage.BODY_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Bound Computation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_COMPUTATION_FEATURE_COUNT = PolyIRCGPackage.BODY_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.VolumeFunctionImpl <em>Volume Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.VolumeFunctionImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanPackageImpl#getVolumeFunction()
	 * @generated
	 */
	int VOLUME_FUNCTION = 1;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLUME_FUNCTION__FUNCTION = PolyIRCGPackage.BODY__FUNCTION;

	/**
	 * The feature id for the '<em><b>Unknown</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLUME_FUNCTION__UNKNOWN = PolyIRCGPackage.BODY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Volume Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLUME_FUNCTION_FEATURE_COUNT = PolyIRCGPackage.BODY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.VolumeFunctionDerivativeImpl <em>Volume Function Derivative</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.VolumeFunctionDerivativeImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanPackageImpl#getVolumeFunctionDerivative()
	 * @generated
	 */
	int VOLUME_FUNCTION_DERIVATIVE = 2;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLUME_FUNCTION_DERIVATIVE__FUNCTION = PolyIRCGPackage.BODY__FUNCTION;

	/**
	 * The feature id for the '<em><b>Unknown</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLUME_FUNCTION_DERIVATIVE__UNKNOWN = PolyIRCGPackage.BODY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Volume Function Derivative</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOLUME_FUNCTION_DERIVATIVE_FEATURE_COUNT = PolyIRCGPackage.BODY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanBodyImpl <em>Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanBodyImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanPackageImpl#getScanBody()
	 * @generated
	 */
	int SCAN_BODY = 3;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAN_BODY__FUNCTION = PolyIRCGPackage.BODY__FUNCTION;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAN_BODY__DOMAIN = PolyIRCGPackage.BODY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Volume Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAN_BODY__VOLUME_FUNCTION = PolyIRCGPackage.BODY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Bound Computation Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAN_BODY__BOUND_COMPUTATION_FUNCTION = PolyIRCGPackage.BODY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Origin Domain Volume</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAN_BODY__ORIGIN_DOMAIN_VOLUME = PolyIRCGPackage.BODY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Local Reduction Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAN_BODY__LOCAL_REDUCTION_FUNCTION = PolyIRCGPackage.BODY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Local Scan Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAN_BODY__LOCAL_SCAN_FUNCTION = PolyIRCGPackage.BODY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Local Reduction Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAN_BODY__LOCAL_REDUCTION_VARIABLES = PolyIRCGPackage.BODY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Local Scan Reduction Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAN_BODY__LOCAL_SCAN_REDUCTION_VARIABLES = PolyIRCGPackage.BODY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Local Initial Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAN_BODY__LOCAL_INITIAL_VARIABLES = PolyIRCGPackage.BODY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Nthread Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAN_BODY__NTHREAD_VARIABLE_NAME = PolyIRCGPackage.BODY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Thread Num Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAN_BODY__THREAD_NUM_VARIABLE_NAME = PolyIRCGPackage.BODY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Begin Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAN_BODY__BEGIN_VARIABLE_NAME = PolyIRCGPackage.BODY_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>End Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAN_BODY__END_VARIABLE_NAME = PolyIRCGPackage.BODY_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Scan Reduction Body</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAN_BODY__SCAN_REDUCTION_BODY = PolyIRCGPackage.BODY_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAN_BODY_FEATURE_COUNT = PolyIRCGPackage.BODY_FEATURE_COUNT + 14;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.OriginDomainVolumeImpl <em>Origin Domain Volume</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.OriginDomainVolumeImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanPackageImpl#getOriginDomainVolume()
	 * @generated
	 */
	int ORIGIN_DOMAIN_VOLUME = 4;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGIN_DOMAIN_VOLUME__FUNCTION = PolyIRCGPackage.BODY__FUNCTION;

	/**
	 * The number of structural features of the '<em>Origin Domain Volume</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGIN_DOMAIN_VOLUME_FEATURE_COUNT = PolyIRCGPackage.BODY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanReductionBodyImpl <em>Reduction Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanReductionBodyImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanPackageImpl#getScanReductionBody()
	 * @generated
	 */
	int SCAN_REDUCTION_BODY = 5;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAN_REDUCTION_BODY__FUNCTION = PolyIRCGPackage.BODY__FUNCTION;

	/**
	 * The feature id for the '<em><b>Pre Process Loop</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAN_REDUCTION_BODY__PRE_PROCESS_LOOP = PolyIRCGPackage.BODY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scan Loop</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAN_REDUCTION_BODY__SCAN_LOOP = PolyIRCGPackage.BODY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Post Process Loop</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAN_REDUCTION_BODY__POST_PROCESS_LOOP = PolyIRCGPackage.BODY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Matrix Temp Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAN_REDUCTION_BODY__MATRIX_TEMP_VARIABLES = PolyIRCGPackage.BODY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Init Temp Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAN_REDUCTION_BODY__INIT_TEMP_VARIABLES = PolyIRCGPackage.BODY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Assignment Loop</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAN_REDUCTION_BODY__ASSIGNMENT_LOOP = PolyIRCGPackage.BODY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Init Value Update</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAN_REDUCTION_BODY__INIT_VALUE_UPDATE = PolyIRCGPackage.BODY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Init Value Copy</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAN_REDUCTION_BODY__INIT_VALUE_COPY = PolyIRCGPackage.BODY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Matrix Init Loop</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAN_REDUCTION_BODY__MATRIX_INIT_LOOP = PolyIRCGPackage.BODY_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Reduction Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAN_REDUCTION_BODY_FEATURE_COUNT = PolyIRCGPackage.BODY_FEATURE_COUNT + 9;


	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation <em>Bound Computation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bound Computation</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation
	 * @generated
	 */
	EClass getBoundComputation();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation#getLb <em>Lb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lb</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation#getLb()
	 * @see #getBoundComputation()
	 * @generated
	 */
	EReference getBoundComputation_Lb();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation#getUb <em>Ub</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ub</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation#getUb()
	 * @see #getBoundComputation()
	 * @generated
	 */
	EReference getBoundComputation_Ub();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation#getConstantTerm <em>Constant Term</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Constant Term</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation#getConstantTerm()
	 * @see #getBoundComputation()
	 * @generated
	 */
	EReference getBoundComputation_ConstantTerm();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation#getVolumeFunction <em>Volume Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Volume Function</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation#getVolumeFunction()
	 * @see #getBoundComputation()
	 * @generated
	 */
	EReference getBoundComputation_VolumeFunction();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation#getVolumeFunctionDerivative <em>Volume Function Derivative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Volume Function Derivative</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation#getVolumeFunctionDerivative()
	 * @see #getBoundComputation()
	 * @generated
	 */
	EReference getBoundComputation_VolumeFunctionDerivative();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation#getInitialValue <em>Initial Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initial Value</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.BoundComputation#getInitialValue()
	 * @see #getBoundComputation()
	 * @generated
	 */
	EReference getBoundComputation_InitialValue();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunction <em>Volume Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Volume Function</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunction
	 * @generated
	 */
	EClass getVolumeFunction();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunction#getUnknown <em>Unknown</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Unknown</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunction#getUnknown()
	 * @see #getVolumeFunction()
	 * @generated
	 */
	EReference getVolumeFunction_Unknown();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunctionDerivative <em>Volume Function Derivative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Volume Function Derivative</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunctionDerivative
	 * @generated
	 */
	EClass getVolumeFunctionDerivative();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunctionDerivative#getUnknown <em>Unknown</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Unknown</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.VolumeFunctionDerivative#getUnknown()
	 * @see #getVolumeFunctionDerivative()
	 * @generated
	 */
	EReference getVolumeFunctionDerivative_Unknown();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Body</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody
	 * @generated
	 */
	EClass getScanBody();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getDomain()
	 * @see #getScanBody()
	 * @generated
	 */
	EReference getScanBody_Domain();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getVolumeFunction <em>Volume Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Volume Function</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getVolumeFunction()
	 * @see #getScanBody()
	 * @generated
	 */
	EReference getScanBody_VolumeFunction();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getBoundComputationFunction <em>Bound Computation Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bound Computation Function</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getBoundComputationFunction()
	 * @see #getScanBody()
	 * @generated
	 */
	EReference getScanBody_BoundComputationFunction();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getOriginDomainVolume <em>Origin Domain Volume</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Origin Domain Volume</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getOriginDomainVolume()
	 * @see #getScanBody()
	 * @generated
	 */
	EReference getScanBody_OriginDomainVolume();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getLocalReductionFunction <em>Local Reduction Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Local Reduction Function</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getLocalReductionFunction()
	 * @see #getScanBody()
	 * @generated
	 */
	EReference getScanBody_LocalReductionFunction();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getLocalScanFunction <em>Local Scan Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Local Scan Function</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getLocalScanFunction()
	 * @see #getScanBody()
	 * @generated
	 */
	EReference getScanBody_LocalScanFunction();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getLocalReductionVariables <em>Local Reduction Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Local Reduction Variables</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getLocalReductionVariables()
	 * @see #getScanBody()
	 * @generated
	 */
	EReference getScanBody_LocalReductionVariables();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getLocalScanReductionVariables <em>Local Scan Reduction Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Local Scan Reduction Variables</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getLocalScanReductionVariables()
	 * @see #getScanBody()
	 * @generated
	 */
	EReference getScanBody_LocalScanReductionVariables();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getLocalInitialVariables <em>Local Initial Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Local Initial Variables</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getLocalInitialVariables()
	 * @see #getScanBody()
	 * @generated
	 */
	EReference getScanBody_LocalInitialVariables();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getNthreadVariableName <em>Nthread Variable Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nthread Variable Name</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getNthreadVariableName()
	 * @see #getScanBody()
	 * @generated
	 */
	EAttribute getScanBody_NthreadVariableName();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getThreadNumVariableName <em>Thread Num Variable Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thread Num Variable Name</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getThreadNumVariableName()
	 * @see #getScanBody()
	 * @generated
	 */
	EAttribute getScanBody_ThreadNumVariableName();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getBeginVariableName <em>Begin Variable Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Begin Variable Name</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getBeginVariableName()
	 * @see #getScanBody()
	 * @generated
	 */
	EAttribute getScanBody_BeginVariableName();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getEndVariableName <em>End Variable Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Variable Name</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getEndVariableName()
	 * @see #getScanBody()
	 * @generated
	 */
	EAttribute getScanBody_EndVariableName();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getScanReductionBody <em>Scan Reduction Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Scan Reduction Body</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanBody#getScanReductionBody()
	 * @see #getScanBody()
	 * @generated
	 */
	EReference getScanBody_ScanReductionBody();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.OriginDomainVolume <em>Origin Domain Volume</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Origin Domain Volume</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.OriginDomainVolume
	 * @generated
	 */
	EClass getOriginDomainVolume();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody <em>Reduction Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reduction Body</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody
	 * @generated
	 */
	EClass getScanReductionBody();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getPreProcessLoop <em>Pre Process Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pre Process Loop</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getPreProcessLoop()
	 * @see #getScanReductionBody()
	 * @generated
	 */
	EReference getScanReductionBody_PreProcessLoop();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getScanLoop <em>Scan Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Scan Loop</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getScanLoop()
	 * @see #getScanReductionBody()
	 * @generated
	 */
	EReference getScanReductionBody_ScanLoop();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getPostProcessLoop <em>Post Process Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Post Process Loop</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getPostProcessLoop()
	 * @see #getScanReductionBody()
	 * @generated
	 */
	EReference getScanReductionBody_PostProcessLoop();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getMatrixTempVariables <em>Matrix Temp Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Matrix Temp Variables</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getMatrixTempVariables()
	 * @see #getScanReductionBody()
	 * @generated
	 */
	EReference getScanReductionBody_MatrixTempVariables();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getInitTempVariables <em>Init Temp Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Init Temp Variables</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getInitTempVariables()
	 * @see #getScanReductionBody()
	 * @generated
	 */
	EReference getScanReductionBody_InitTempVariables();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getAssignmentLoop <em>Assignment Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Assignment Loop</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getAssignmentLoop()
	 * @see #getScanReductionBody()
	 * @generated
	 */
	EReference getScanReductionBody_AssignmentLoop();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getInitValueUpdate <em>Init Value Update</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Init Value Update</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getInitValueUpdate()
	 * @see #getScanReductionBody()
	 * @generated
	 */
	EReference getScanReductionBody_InitValueUpdate();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getInitValueCopy <em>Init Value Copy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Init Value Copy</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getInitValueCopy()
	 * @see #getScanReductionBody()
	 * @generated
	 */
	EReference getScanReductionBody_InitValueCopy();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getMatrixInitLoop <em>Matrix Init Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Matrix Init Loop</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getMatrixInitLoop()
	 * @see #getScanReductionBody()
	 * @generated
	 */
	EReference getScanReductionBody_MatrixInitLoop();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ScanFactory getScanFactory();

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
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.BoundComputationImpl <em>Bound Computation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.BoundComputationImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanPackageImpl#getBoundComputation()
		 * @generated
		 */
		EClass BOUND_COMPUTATION = eINSTANCE.getBoundComputation();

		/**
		 * The meta object literal for the '<em><b>Lb</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOUND_COMPUTATION__LB = eINSTANCE.getBoundComputation_Lb();

		/**
		 * The meta object literal for the '<em><b>Ub</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOUND_COMPUTATION__UB = eINSTANCE.getBoundComputation_Ub();

		/**
		 * The meta object literal for the '<em><b>Constant Term</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOUND_COMPUTATION__CONSTANT_TERM = eINSTANCE.getBoundComputation_ConstantTerm();

		/**
		 * The meta object literal for the '<em><b>Volume Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOUND_COMPUTATION__VOLUME_FUNCTION = eINSTANCE.getBoundComputation_VolumeFunction();

		/**
		 * The meta object literal for the '<em><b>Volume Function Derivative</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOUND_COMPUTATION__VOLUME_FUNCTION_DERIVATIVE = eINSTANCE.getBoundComputation_VolumeFunctionDerivative();

		/**
		 * The meta object literal for the '<em><b>Initial Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOUND_COMPUTATION__INITIAL_VALUE = eINSTANCE.getBoundComputation_InitialValue();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.VolumeFunctionImpl <em>Volume Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.VolumeFunctionImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanPackageImpl#getVolumeFunction()
		 * @generated
		 */
		EClass VOLUME_FUNCTION = eINSTANCE.getVolumeFunction();

		/**
		 * The meta object literal for the '<em><b>Unknown</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VOLUME_FUNCTION__UNKNOWN = eINSTANCE.getVolumeFunction_Unknown();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.VolumeFunctionDerivativeImpl <em>Volume Function Derivative</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.VolumeFunctionDerivativeImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanPackageImpl#getVolumeFunctionDerivative()
		 * @generated
		 */
		EClass VOLUME_FUNCTION_DERIVATIVE = eINSTANCE.getVolumeFunctionDerivative();

		/**
		 * The meta object literal for the '<em><b>Unknown</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VOLUME_FUNCTION_DERIVATIVE__UNKNOWN = eINSTANCE.getVolumeFunctionDerivative_Unknown();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanBodyImpl <em>Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanBodyImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanPackageImpl#getScanBody()
		 * @generated
		 */
		EClass SCAN_BODY = eINSTANCE.getScanBody();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCAN_BODY__DOMAIN = eINSTANCE.getScanBody_Domain();

		/**
		 * The meta object literal for the '<em><b>Volume Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCAN_BODY__VOLUME_FUNCTION = eINSTANCE.getScanBody_VolumeFunction();

		/**
		 * The meta object literal for the '<em><b>Bound Computation Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCAN_BODY__BOUND_COMPUTATION_FUNCTION = eINSTANCE.getScanBody_BoundComputationFunction();

		/**
		 * The meta object literal for the '<em><b>Origin Domain Volume</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCAN_BODY__ORIGIN_DOMAIN_VOLUME = eINSTANCE.getScanBody_OriginDomainVolume();

		/**
		 * The meta object literal for the '<em><b>Local Reduction Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCAN_BODY__LOCAL_REDUCTION_FUNCTION = eINSTANCE.getScanBody_LocalReductionFunction();

		/**
		 * The meta object literal for the '<em><b>Local Scan Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCAN_BODY__LOCAL_SCAN_FUNCTION = eINSTANCE.getScanBody_LocalScanFunction();

		/**
		 * The meta object literal for the '<em><b>Local Reduction Variables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCAN_BODY__LOCAL_REDUCTION_VARIABLES = eINSTANCE.getScanBody_LocalReductionVariables();

		/**
		 * The meta object literal for the '<em><b>Local Scan Reduction Variables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCAN_BODY__LOCAL_SCAN_REDUCTION_VARIABLES = eINSTANCE.getScanBody_LocalScanReductionVariables();

		/**
		 * The meta object literal for the '<em><b>Local Initial Variables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCAN_BODY__LOCAL_INITIAL_VARIABLES = eINSTANCE.getScanBody_LocalInitialVariables();

		/**
		 * The meta object literal for the '<em><b>Nthread Variable Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCAN_BODY__NTHREAD_VARIABLE_NAME = eINSTANCE.getScanBody_NthreadVariableName();

		/**
		 * The meta object literal for the '<em><b>Thread Num Variable Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCAN_BODY__THREAD_NUM_VARIABLE_NAME = eINSTANCE.getScanBody_ThreadNumVariableName();

		/**
		 * The meta object literal for the '<em><b>Begin Variable Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCAN_BODY__BEGIN_VARIABLE_NAME = eINSTANCE.getScanBody_BeginVariableName();

		/**
		 * The meta object literal for the '<em><b>End Variable Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCAN_BODY__END_VARIABLE_NAME = eINSTANCE.getScanBody_EndVariableName();

		/**
		 * The meta object literal for the '<em><b>Scan Reduction Body</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCAN_BODY__SCAN_REDUCTION_BODY = eINSTANCE.getScanBody_ScanReductionBody();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.OriginDomainVolumeImpl <em>Origin Domain Volume</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.OriginDomainVolumeImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanPackageImpl#getOriginDomainVolume()
		 * @generated
		 */
		EClass ORIGIN_DOMAIN_VOLUME = eINSTANCE.getOriginDomainVolume();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanReductionBodyImpl <em>Reduction Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanReductionBodyImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.impl.ScanPackageImpl#getScanReductionBody()
		 * @generated
		 */
		EClass SCAN_REDUCTION_BODY = eINSTANCE.getScanReductionBody();

		/**
		 * The meta object literal for the '<em><b>Pre Process Loop</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCAN_REDUCTION_BODY__PRE_PROCESS_LOOP = eINSTANCE.getScanReductionBody_PreProcessLoop();

		/**
		 * The meta object literal for the '<em><b>Scan Loop</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCAN_REDUCTION_BODY__SCAN_LOOP = eINSTANCE.getScanReductionBody_ScanLoop();

		/**
		 * The meta object literal for the '<em><b>Post Process Loop</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCAN_REDUCTION_BODY__POST_PROCESS_LOOP = eINSTANCE.getScanReductionBody_PostProcessLoop();

		/**
		 * The meta object literal for the '<em><b>Matrix Temp Variables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCAN_REDUCTION_BODY__MATRIX_TEMP_VARIABLES = eINSTANCE.getScanReductionBody_MatrixTempVariables();

		/**
		 * The meta object literal for the '<em><b>Init Temp Variables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCAN_REDUCTION_BODY__INIT_TEMP_VARIABLES = eINSTANCE.getScanReductionBody_InitTempVariables();

		/**
		 * The meta object literal for the '<em><b>Assignment Loop</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCAN_REDUCTION_BODY__ASSIGNMENT_LOOP = eINSTANCE.getScanReductionBody_AssignmentLoop();

		/**
		 * The meta object literal for the '<em><b>Init Value Update</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCAN_REDUCTION_BODY__INIT_VALUE_UPDATE = eINSTANCE.getScanReductionBody_InitValueUpdate();

		/**
		 * The meta object literal for the '<em><b>Init Value Copy</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCAN_REDUCTION_BODY__INIT_VALUE_COPY = eINSTANCE.getScanReductionBody_InitValueCopy();

		/**
		 * The meta object literal for the '<em><b>Matrix Init Loop</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCAN_REDUCTION_BODY__MATRIX_INIT_LOOP = eINSTANCE.getScanReductionBody_MatrixInitLoop();

	}

} //ScanPackage
