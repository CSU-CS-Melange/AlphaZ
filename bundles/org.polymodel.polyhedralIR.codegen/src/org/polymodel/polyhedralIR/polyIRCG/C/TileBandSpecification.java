/**
 */
package org.polymodel.polyhedralIR.polyIRCG.C;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tile Band Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.TileBandSpecification#getStart <em>Start</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.TileBandSpecification#getEnd <em>End</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.TileBandSpecification#isPermuted <em>Permuted</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.TileBandSpecification#isWavefront <em>Wavefront</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getTileBandSpecification()
 * @model
 * @generated
 */
public interface TileBandSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see #setStart(int)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getTileBandSpecification_Start()
	 * @model required="true"
	 * @generated
	 */
	int getStart();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.TileBandSpecification#getStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' attribute.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(int value);

	/**
	 * Returns the value of the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' attribute.
	 * @see #setEnd(int)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getTileBandSpecification_End()
	 * @model required="true"
	 * @generated
	 */
	int getEnd();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.TileBandSpecification#getEnd <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' attribute.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(int value);

	/**
	 * Returns the value of the '<em><b>Permuted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Permuted</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Permuted</em>' attribute.
	 * @see #setPermuted(boolean)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getTileBandSpecification_Permuted()
	 * @model required="true"
	 * @generated
	 */
	boolean isPermuted();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.TileBandSpecification#isPermuted <em>Permuted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Permuted</em>' attribute.
	 * @see #isPermuted()
	 * @generated
	 */
	void setPermuted(boolean value);

	/**
	 * Returns the value of the '<em><b>Wavefront</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wavefront</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wavefront</em>' attribute.
	 * @see #setWavefront(boolean)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.CPackage#getTileBandSpecification_Wavefront()
	 * @model required="true"
	 * @generated
	 */
	boolean isWavefront();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.TileBandSpecification#isWavefront <em>Wavefront</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wavefront</em>' attribute.
	 * @see #isWavefront()
	 * @generated
	 */
	void setWavefront(boolean value);

} // TileBandSpecification
