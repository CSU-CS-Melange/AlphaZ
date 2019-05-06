/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.Function#getCodeunit <em>Codeunit</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.Function#getName <em>Name</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.Function#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.Function#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.Function#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.Function#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.Function#getLocals <em>Locals</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.Function#getSpecialLocals <em>Special Locals</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.Function#getBodies <em>Bodies</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.Function#isEntryPoint <em>Entry Point</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.Function#isInlined <em>Inlined</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.Function#getNumberOfTimeIterationsForFirstConditionCheck <em>Number Of Time Iterations For First Condition Check</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.Function#getSignature <em>Signature</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getFunction()
 * @model
 * @generated
 */
public interface Function extends EObject {
	/**
	 * Returns the value of the '<em><b>Codeunit</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getFunctions <em>Functions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Codeunit</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Codeunit</em>' container reference.
	 * @see #setCodeunit(CodeUnit)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getFunction_Codeunit()
	 * @see org.polymodel.polyhedralIR.polyIRCG.CodeUnit#getFunctions
	 * @model opposite="functions" transient="false"
	 * @generated
	 */
	CodeUnit getCodeunit();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.Function#getCodeunit <em>Codeunit</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Codeunit</em>' container reference.
	 * @see #getCodeunit()
	 * @generated
	 */
	void setCodeunit(CodeUnit value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getFunction_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.Function#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Return Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Type</em>' attribute.
	 * @see #setReturnType(String)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getFunction_ReturnType()
	 * @model required="true"
	 * @generated
	 */
	String getReturnType();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.Function#getReturnType <em>Return Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Type</em>' attribute.
	 * @see #getReturnType()
	 * @generated
	 */
	void setReturnType(String value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.AbstractVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getFunction_Parameters()
	 * @model
	 * @generated
	 */
	EList<AbstractVariable> getParameters();

	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.AbstractVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getFunction_Inputs()
	 * @model
	 * @generated
	 */
	EList<AbstractVariable> getInputs();

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.AbstractVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getFunction_Outputs()
	 * @model
	 * @generated
	 */
	EList<AbstractVariable> getOutputs();

	/**
	 * Returns the value of the '<em><b>Locals</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.AbstractVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Locals</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Locals</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getFunction_Locals()
	 * @model
	 * @generated
	 */
	EList<AbstractVariable> getLocals();

	/**
	 * Returns the value of the '<em><b>Bodies</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.Body}.
	 * It is bidirectional and its opposite is '{@link org.polymodel.polyhedralIR.polyIRCG.Body#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bodies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bodies</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getFunction_Bodies()
	 * @see org.polymodel.polyhedralIR.polyIRCG.Body#getFunction
	 * @model opposite="function" containment="true"
	 * @generated
	 */
	EList<Body> getBodies();

	/**
	 * Returns the value of the '<em><b>Entry Point</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Point</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Point</em>' attribute.
	 * @see #setEntryPoint(boolean)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getFunction_EntryPoint()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isEntryPoint();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.Function#isEntryPoint <em>Entry Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry Point</em>' attribute.
	 * @see #isEntryPoint()
	 * @generated
	 */
	void setEntryPoint(boolean value);

	/**
	 * Returns the value of the '<em><b>Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signature</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signature</em>' containment reference.
	 * @see #setSignature(FunctionSignature)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getFunction_Signature()
	 * @model containment="true"
	 * @generated
	 */
	FunctionSignature getSignature();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.Function#getSignature <em>Signature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signature</em>' containment reference.
	 * @see #getSignature()
	 * @generated
	 */
	void setSignature(FunctionSignature value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model includeSystemParamsRequired="true"
	 * @generated
	 */
	FunctionSignature getDefaultFunctionSignature(boolean includeSystemParams);

	/**
	 * Returns the value of the '<em><b>Inlined</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inlined</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inlined</em>' attribute.
	 * @see #setInlined(boolean)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getFunction_Inlined()
	 * @model required="true"
	 * @generated
	 */
	boolean isInlined();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.Function#isInlined <em>Inlined</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inlined</em>' attribute.
	 * @see #isInlined()
	 * @generated
	 */
	void setInlined(boolean value);

	/**
	 * Returns the value of the '<em><b>Number Of Time Iterations For First Condition Check</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Time Iterations For First Condition Check</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Time Iterations For First Condition Check</em>' attribute.
	 * @see #setNumberOfTimeIterationsForFirstConditionCheck(String)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getFunction_NumberOfTimeIterationsForFirstConditionCheck()
	 * @model
	 * @generated
	 */
	String getNumberOfTimeIterationsForFirstConditionCheck();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.Function#getNumberOfTimeIterationsForFirstConditionCheck <em>Number Of Time Iterations For First Condition Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Time Iterations For First Condition Check</em>' attribute.
	 * @see #getNumberOfTimeIterationsForFirstConditionCheck()
	 * @generated
	 */
	void setNumberOfTimeIterationsForFirstConditionCheck(String value);

	/**
	 * Returns the value of the '<em><b>Special Locals</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Special Locals</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Special Locals</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getFunction_SpecialLocals()
	 * @model
	 * @generated
	 */
	EList<CodeGenVariable> getSpecialLocals();

} // Function
