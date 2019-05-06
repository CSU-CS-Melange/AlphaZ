/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG;


import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.polyhedralIR.Program;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compilation Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.CompilationUnit#getProgram <em>Program</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.CompilationUnit#getUnits <em>Units</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getCompilationUnit()
 * @model
 * @generated
 */
public interface CompilationUnit extends EObject {
	/**
	 * Returns the value of the '<em><b>Program</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Program</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Program</em>' containment reference.
	 * @see #setProgram(Program)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getCompilationUnit_Program()
	 * @model containment="true"
	 * @generated
	 */
	Program getProgram();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.CompilationUnit#getProgram <em>Program</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Program</em>' containment reference.
	 * @see #getProgram()
	 * @generated
	 */
	void setProgram(Program value);

	/**
	 * Returns the value of the '<em><b>Units</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.CodeUnit}.
	 * It is bidirectional and its opposite is '{@link org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getCompilationUnit <em>Compilation Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Units</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Units</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getCompilationUnit_Units()
	 * @see org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getCompilationUnit
	 * @model opposite="compilationUnit" containment="true"
	 * @generated
	 */
	EList<CodeUnit> getUnits();

} // CompilationUnit
