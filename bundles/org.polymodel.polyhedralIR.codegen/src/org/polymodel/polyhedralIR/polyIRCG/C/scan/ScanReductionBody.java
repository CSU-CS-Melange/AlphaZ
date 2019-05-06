/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.scan;

import org.eclipse.emf.common.util.EList;
import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.C.CLoop;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reduction Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getPreProcessLoop <em>Pre Process Loop</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getScanLoop <em>Scan Loop</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getPostProcessLoop <em>Post Process Loop</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getMatrixTempVariables <em>Matrix Temp Variables</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getInitTempVariables <em>Init Temp Variables</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getAssignmentLoop <em>Assignment Loop</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getInitValueUpdate <em>Init Value Update</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getInitValueCopy <em>Init Value Copy</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getMatrixInitLoop <em>Matrix Init Loop</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getScanReductionBody()
 * @model
 * @generated
 */
public interface ScanReductionBody extends Body {
	/**
	 * Returns the value of the '<em><b>Pre Process Loop</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre Process Loop</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pre Process Loop</em>' reference.
	 * @see #setPreProcessLoop(CLoop)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getScanReductionBody_PreProcessLoop()
	 * @model required="true"
	 * @generated
	 */
	CLoop getPreProcessLoop();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getPreProcessLoop <em>Pre Process Loop</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pre Process Loop</em>' reference.
	 * @see #getPreProcessLoop()
	 * @generated
	 */
	void setPreProcessLoop(CLoop value);

	/**
	 * Returns the value of the '<em><b>Scan Loop</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scan Loop</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scan Loop</em>' reference.
	 * @see #setScanLoop(CLoop)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getScanReductionBody_ScanLoop()
	 * @model required="true"
	 * @generated
	 */
	CLoop getScanLoop();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getScanLoop <em>Scan Loop</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scan Loop</em>' reference.
	 * @see #getScanLoop()
	 * @generated
	 */
	void setScanLoop(CLoop value);

	/**
	 * Returns the value of the '<em><b>Post Process Loop</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Post Process Loop</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Post Process Loop</em>' reference.
	 * @see #setPostProcessLoop(CLoop)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getScanReductionBody_PostProcessLoop()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CLoop getPostProcessLoop();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getPostProcessLoop <em>Post Process Loop</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Post Process Loop</em>' reference.
	 * @see #getPostProcessLoop()
	 * @generated
	 */
	void setPostProcessLoop(CLoop value);

	/**
	 * Returns the value of the '<em><b>Matrix Temp Variables</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matrix Temp Variables</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matrix Temp Variables</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getScanReductionBody_MatrixTempVariables()
	 * @model
	 * @generated
	 */
	EList<CodeGenVariable> getMatrixTempVariables();

	/**
	 * Returns the value of the '<em><b>Init Temp Variables</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Temp Variables</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Temp Variables</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getScanReductionBody_InitTempVariables()
	 * @model required="true"
	 * @generated
	 */
	EList<CodeGenVariable> getInitTempVariables();

	/**
	 * Returns the value of the '<em><b>Assignment Loop</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assignment Loop</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assignment Loop</em>' reference.
	 * @see #setAssignmentLoop(CLoop)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getScanReductionBody_AssignmentLoop()
	 * @model required="true"
	 * @generated
	 */
	CLoop getAssignmentLoop();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getAssignmentLoop <em>Assignment Loop</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assignment Loop</em>' reference.
	 * @see #getAssignmentLoop()
	 * @generated
	 */
	void setAssignmentLoop(CLoop value);

	/**
	 * Returns the value of the '<em><b>Init Value Update</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Value Update</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Value Update</em>' reference.
	 * @see #setInitValueUpdate(CLoop)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getScanReductionBody_InitValueUpdate()
	 * @model required="true"
	 * @generated
	 */
	CLoop getInitValueUpdate();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getInitValueUpdate <em>Init Value Update</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Value Update</em>' reference.
	 * @see #getInitValueUpdate()
	 * @generated
	 */
	void setInitValueUpdate(CLoop value);

	/**
	 * Returns the value of the '<em><b>Init Value Copy</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Value Copy</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Value Copy</em>' reference.
	 * @see #setInitValueCopy(CLoop)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getScanReductionBody_InitValueCopy()
	 * @model required="true"
	 * @generated
	 */
	CLoop getInitValueCopy();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getInitValueCopy <em>Init Value Copy</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Value Copy</em>' reference.
	 * @see #getInitValueCopy()
	 * @generated
	 */
	void setInitValueCopy(CLoop value);

	/**
	 * Returns the value of the '<em><b>Matrix Init Loop</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matrix Init Loop</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matrix Init Loop</em>' reference.
	 * @see #setMatrixInitLoop(CLoop)
	 * @see org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanPackage#getScanReductionBody_MatrixInitLoop()
	 * @model
	 * @generated
	 */
	CLoop getMatrixInitLoop();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.C.scan.ScanReductionBody#getMatrixInitLoop <em>Matrix Init Loop</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matrix Init Loop</em>' reference.
	 * @see #getMatrixInitLoop()
	 * @generated
	 */
	void setMatrixInitLoop(CLoop value);

} // ScanReductionBody
