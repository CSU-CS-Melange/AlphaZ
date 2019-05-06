/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG;

import org.eclipse.emf.common.util.EList;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.scop.ScopRoot;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.Loop#getParameterDomain <em>Parameter Domain</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.Loop#getStatements <em>Statements</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.Loop#isDeclareIterators <em>Declare Iterators</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.Loop#getIteratorNames <em>Iterator Names</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.Loop#getNumConstantDimensions <em>Num Constant Dimensions</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getLoop()
 * @model abstract="true"
 * @generated
 */
public interface Loop extends Body {
	/**
	 * Returns the value of the '<em><b>Parameter Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Domain</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Domain</em>' reference.
	 * @see #setParameterDomain(ParameterDomain)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getLoop_ParameterDomain()
	 * @model required="true"
	 * @generated
	 */
	ParameterDomain getParameterDomain();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.Loop#getParameterDomain <em>Parameter Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Domain</em>' reference.
	 * @see #getParameterDomain()
	 * @generated
	 */
	void setParameterDomain(ParameterDomain value);

	/**
	 * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.Statement}.
	 * It is bidirectional and its opposite is '{@link org.polymodel.polyhedralIR.polyIRCG.Statement#getContainerLoop <em>Container Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statements</em>' containment reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getLoop_Statements()
	 * @see org.polymodel.polyhedralIR.polyIRCG.Statement#getContainerLoop
	 * @model opposite="containerLoop" containment="true"
	 * @generated
	 */
	EList<Statement> getStatements();

	/**
	 * Returns the value of the '<em><b>Declare Iterators</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declare Iterators</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declare Iterators</em>' attribute.
	 * @see #setDeclareIterators(boolean)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getLoop_DeclareIterators()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isDeclareIterators();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.Loop#isDeclareIterators <em>Declare Iterators</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declare Iterators</em>' attribute.
	 * @see #isDeclareIterators()
	 * @generated
	 */
	void setDeclareIterators(boolean value);

	/**
	 * Returns the value of the '<em><b>Iterator Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterator Names</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterator Names</em>' attribute list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getLoop_IteratorNames()
	 * @model ordered="false"
	 * @generated
	 */
	EList<String> getIteratorNames();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	int getMaxDimension();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	ScopRoot generateScop();

	/**
	 * Returns the value of the '<em><b>Num Constant Dimensions</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Constant Dimensions</em>' attribute.
	 * @see #setNumConstantDimensions(int)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage#getLoop_NumConstantDimensions()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getNumConstantDimensions();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.Loop#getNumConstantDimensions <em>Num Constant Dimensions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Constant Dimensions</em>' attribute.
	 * @see #getNumConstantDimensions()
	 * @generated
	 */
	void setNumConstantDimensions(int value);

} // Loop
