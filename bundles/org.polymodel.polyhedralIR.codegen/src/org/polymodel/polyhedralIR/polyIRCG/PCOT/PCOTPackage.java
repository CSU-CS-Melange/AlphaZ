/**
 */
package org.polymodel.polyhedralIR.polyIRCG.PCOT;

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
 * @see org.polymodel.polyhedralIR.polyIRCG.PCOT.PCOTFactory
 * @model kind="package"
 * @generated
 */
public interface PCOTPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "PCOT";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "PCOT";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "PCOT";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PCOTPackage eINSTANCE = org.polymodel.polyhedralIR.polyIRCG.PCOT.impl.PCOTPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.impl.RecursionBodyImpl <em>Recursion Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.PCOT.impl.RecursionBodyImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.PCOT.impl.PCOTPackageImpl#getRecursionBody()
	 * @generated
	 */
	int RECURSION_BODY = 0;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_BODY__FUNCTION = PolyIRCGPackage.BODY__FUNCTION;

	/**
	 * The feature id for the '<em><b>Parallel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_BODY__PARALLEL = PolyIRCGPackage.BODY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_BODY__BASE_FUNCTION = PolyIRCGPackage.BODY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Band Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_BODY__BAND_START = PolyIRCGPackage.BODY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Band End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_BODY__BAND_END = PolyIRCGPackage.BODY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Param Struct</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_BODY__PARAM_STRUCT = PolyIRCGPackage.BODY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Local Struct</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_BODY__LOCAL_STRUCT = PolyIRCGPackage.BODY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Recur Structs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_BODY__RECUR_STRUCTS = PolyIRCGPackage.BODY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Tile Sizes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_BODY__TILE_SIZES = PolyIRCGPackage.BODY_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Recursion Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_BODY_FEATURE_COUNT = PolyIRCGPackage.BODY_FEATURE_COUNT + 8;


	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody <em>Recursion Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recursion Body</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody
	 * @generated
	 */
	EClass getRecursionBody();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#isParallel <em>Parallel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parallel</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#isParallel()
	 * @see #getRecursionBody()
	 * @generated
	 */
	EAttribute getRecursionBody_Parallel();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#getBaseFunction <em>Base Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Function</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#getBaseFunction()
	 * @see #getRecursionBody()
	 * @generated
	 */
	EReference getRecursionBody_BaseFunction();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#getBandStart <em>Band Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Band Start</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#getBandStart()
	 * @see #getRecursionBody()
	 * @generated
	 */
	EAttribute getRecursionBody_BandStart();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#getBandEnd <em>Band End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Band End</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#getBandEnd()
	 * @see #getRecursionBody()
	 * @generated
	 */
	EAttribute getRecursionBody_BandEnd();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#getParamStruct <em>Param Struct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Param Struct</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#getParamStruct()
	 * @see #getRecursionBody()
	 * @generated
	 */
	EReference getRecursionBody_ParamStruct();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#getLocalStruct <em>Local Struct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Local Struct</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#getLocalStruct()
	 * @see #getRecursionBody()
	 * @generated
	 */
	EReference getRecursionBody_LocalStruct();

	/**
	 * Returns the meta object for the reference list '{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#getRecurStructs <em>Recur Structs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Recur Structs</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#getRecurStructs()
	 * @see #getRecursionBody()
	 * @generated
	 */
	EReference getRecursionBody_RecurStructs();

	/**
	 * Returns the meta object for the attribute list '{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#getTileSizes <em>Tile Sizes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Tile Sizes</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#getTileSizes()
	 * @see #getRecursionBody()
	 * @generated
	 */
	EAttribute getRecursionBody_TileSizes();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PCOTFactory getPCOTFactory();

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
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.impl.RecursionBodyImpl <em>Recursion Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.PCOT.impl.RecursionBodyImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.PCOT.impl.PCOTPackageImpl#getRecursionBody()
		 * @generated
		 */
		EClass RECURSION_BODY = eINSTANCE.getRecursionBody();

		/**
		 * The meta object literal for the '<em><b>Parallel</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECURSION_BODY__PARALLEL = eINSTANCE.getRecursionBody_Parallel();

		/**
		 * The meta object literal for the '<em><b>Base Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECURSION_BODY__BASE_FUNCTION = eINSTANCE.getRecursionBody_BaseFunction();

		/**
		 * The meta object literal for the '<em><b>Band Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECURSION_BODY__BAND_START = eINSTANCE.getRecursionBody_BandStart();

		/**
		 * The meta object literal for the '<em><b>Band End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECURSION_BODY__BAND_END = eINSTANCE.getRecursionBody_BandEnd();

		/**
		 * The meta object literal for the '<em><b>Param Struct</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECURSION_BODY__PARAM_STRUCT = eINSTANCE.getRecursionBody_ParamStruct();

		/**
		 * The meta object literal for the '<em><b>Local Struct</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECURSION_BODY__LOCAL_STRUCT = eINSTANCE.getRecursionBody_LocalStruct();

		/**
		 * The meta object literal for the '<em><b>Recur Structs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECURSION_BODY__RECUR_STRUCTS = eINSTANCE.getRecursionBody_RecurStructs();

		/**
		 * The meta object literal for the '<em><b>Tile Sizes</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECURSION_BODY__TILE_SIZES = eINSTANCE.getRecursionBody_TileSizes();

	}

} //PCOTPackage
