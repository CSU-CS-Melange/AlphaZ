/**
 */
package org.polymodel.polyhedralIR.polyIRCG.C.pcot;

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
 * @see org.polymodel.polyhedralIR.polyIRCG.C.pcot.PcotFactory
 * @model kind="package"
 * @generated
 */
public interface PcotPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "pcot";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "pcot";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pcot";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PcotPackage eINSTANCE = org.polymodel.polyhedralIR.polyIRCG.C.pcot.impl.PcotPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.pcot.impl.PCOTrecursionImpl <em>PCO Trecursion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.pcot.impl.PCOTrecursionImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.pcot.impl.PcotPackageImpl#getPCOTrecursion()
	 * @generated
	 */
	int PCO_TRECURSION = 0;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCO_TRECURSION__FUNCTION = PolyIRCGPackage.BODY__FUNCTION;

	/**
	 * The feature id for the '<em><b>Recursion</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCO_TRECURSION__RECURSION = PolyIRCGPackage.BODY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>PCO Trecursion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCO_TRECURSION_FEATURE_COUNT = PolyIRCGPackage.BODY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.pcot.impl.PCOTbaseImpl <em>PCO Tbase</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.pcot.impl.PCOTbaseImpl
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.pcot.impl.PcotPackageImpl#getPCOTbase()
	 * @generated
	 */
	int PCO_TBASE = 1;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCO_TBASE__FUNCTION = PolyIRCGPackage.BODY__FUNCTION;

	/**
	 * The feature id for the '<em><b>Loop</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCO_TBASE__LOOP = PolyIRCGPackage.BODY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>PCO Tbase</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCO_TBASE_FEATURE_COUNT = PolyIRCGPackage.BODY_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.pcot.PCOTrecursion <em>PCO Trecursion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PCO Trecursion</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.pcot.PCOTrecursion
	 * @generated
	 */
	EClass getPCOTrecursion();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.pcot.PCOTrecursion#getRecursion <em>Recursion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Recursion</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.pcot.PCOTrecursion#getRecursion()
	 * @see #getPCOTrecursion()
	 * @generated
	 */
	EReference getPCOTrecursion_Recursion();

	/**
	 * Returns the meta object for class '{@link org.polymodel.polyhedralIR.polyIRCG.C.pcot.PCOTbase <em>PCO Tbase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PCO Tbase</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.pcot.PCOTbase
	 * @generated
	 */
	EClass getPCOTbase();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.polyhedralIR.polyIRCG.C.pcot.PCOTbase#getLoop <em>Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Loop</em>'.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.pcot.PCOTbase#getLoop()
	 * @see #getPCOTbase()
	 * @generated
	 */
	EReference getPCOTbase_Loop();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PcotFactory getPcotFactory();

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
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.pcot.impl.PCOTrecursionImpl <em>PCO Trecursion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.pcot.impl.PCOTrecursionImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.pcot.impl.PcotPackageImpl#getPCOTrecursion()
		 * @generated
		 */
		EClass PCO_TRECURSION = eINSTANCE.getPCOTrecursion();

		/**
		 * The meta object literal for the '<em><b>Recursion</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCO_TRECURSION__RECURSION = eINSTANCE.getPCOTrecursion_Recursion();

		/**
		 * The meta object literal for the '{@link org.polymodel.polyhedralIR.polyIRCG.C.pcot.impl.PCOTbaseImpl <em>PCO Tbase</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.pcot.impl.PCOTbaseImpl
		 * @see org.polymodel.polyhedralIR.polyIRCG.C.pcot.impl.PcotPackageImpl#getPCOTbase()
		 * @generated
		 */
		EClass PCO_TBASE = eINSTANCE.getPCOTbase();

		/**
		 * The meta object literal for the '<em><b>Loop</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PCO_TBASE__LOOP = eINSTANCE.getPCOTbase_Loop();

	}

} //PcotPackage
