/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG;


import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.algebra.Variable;
import org.polymodel.polyhedralIR.AffineSystem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Code Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getCompilationUnit <em>Compilation Unit</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getSystem <em>System</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getHeaders <em>Headers</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getFunctions <em>Functions</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getLocalParameters <em>Local Parameters</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getCompileTimeParameters <em>Compile Time Parameters</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getSubsystemFunctions <em>Subsystem Functions</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getCodeUnit()
 * @model
 * @generated
 */
public interface CodeUnit extends EObject {
	/**
	 * Returns the value of the '<em><b>System</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System</em>' reference.
	 * @see #setSystem(AffineSystem)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getCodeUnit_System()
	 * @model
	 * @generated
	 */
	AffineSystem getSystem();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getSystem <em>System</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System</em>' reference.
	 * @see #getSystem()
	 * @generated
	 */
	void setSystem(AffineSystem value);

	/**
	 * Returns the value of the '<em><b>Headers</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.CodeUnitHeader}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Headers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Headers</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getCodeUnit_Headers()
	 * @model containment="true"
	 * @generated
	 */
	EList<CodeUnitHeader> getHeaders();

	/**
	 * Returns the value of the '<em><b>Functions</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.Function}.
	 * It is bidirectional and its opposite is '{@link org.polymodel.polyhedralIR.polyIRCG.Function#getCodeunit <em>Codeunit</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Functions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Functions</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getCodeUnit_Functions()
	 * @see org.polymodel.polyhedralIR.polyIRCG.Function#getCodeunit
	 * @model opposite="codeunit" containment="true"
	 * @generated
	 */
	EList<Function> getFunctions();

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.AbstractVariable}.
	 * It is bidirectional and its opposite is '{@link org.polymodel.polyhedralIR.polyIRCG.AbstractVariable#getCodeunit <em>Codeunit</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getCodeUnit_Variables()
	 * @see org.polymodel.polyhedralIR.polyIRCG.AbstractVariable#getCodeunit
	 * @model opposite="codeunit"
	 * @generated
	 */
	EList<AbstractVariable> getVariables();

	/**
	 * Returns the value of the '<em><b>Compilation Unit</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.polymodel.polyhedralIR.polyIRCG.CompilationUnit#getUnits <em>Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compilation Unit</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compilation Unit</em>' container reference.
	 * @see #setCompilationUnit(CompilationUnit)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getCodeUnit_CompilationUnit()
	 * @see org.polymodel.polyhedralIR.polyIRCG.CompilationUnit#getUnits
	 * @model opposite="units" transient="false"
	 * @generated
	 */
	CompilationUnit getCompilationUnit();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getCompilationUnit <em>Compilation Unit</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compilation Unit</em>' container reference.
	 * @see #getCompilationUnit()
	 * @generated
	 */
	void setCompilationUnit(CompilationUnit value);

	/**
	 * Returns the value of the '<em><b>Local Parameters</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.algebra.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Parameters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Parameters</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getCodeUnit_LocalParameters()
	 * @model
	 * @generated
	 */
	EList<Variable> getLocalParameters();

	/**
	 * Returns the value of the '<em><b>Compile Time Parameters</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.CompileTimeParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compile Time Parameters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compile Time Parameters</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getCodeUnit_CompileTimeParameters()
	 * @model
	 * @generated
	 */
	EList<CompileTimeParameter> getCompileTimeParameters();

	/**
	 * Returns the value of the '<em><b>Subsystem Functions</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.FunctionSignature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subsystem Functions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subsystem Functions</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getCodeUnit_SubsystemFunctions()
	 * @model
	 * @generated
	 */
	EList<FunctionSignature> getSubsystemFunctions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	AbstractVariable findVariable(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	CodeGenVariable findCGVariable(String name);

} // CodeUnit
