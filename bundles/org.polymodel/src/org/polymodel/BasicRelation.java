/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel;

import org.polymodel.algebra.IntConstraintSystem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.BasicRelation#getInput <em>Input</em>}</li>
 *   <li>{@link org.polymodel.BasicRelation#getOutput <em>Output</em>}</li>
 *   <li>{@link org.polymodel.BasicRelation#getRelation <em>Relation</em>}</li>
 *   <li>{@link org.polymodel.BasicRelation#getIn <em>In</em>}</li>
 *   <li>{@link org.polymodel.BasicRelation#getOut <em>Out</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.PolymodelPackage#getBasicRelation()
 * @model
 * @generated
 */
public interface BasicRelation extends PolymodelVisitable {
	/**
	 * Returns the value of the '<em><b>Input</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' containment reference.
	 * @see #setInput(IntConstraintSystem)
	 * @see org.polymodel.PolymodelPackage#getBasicRelation_Input()
	 * @model containment="true"
	 * @generated
	 */
	IntConstraintSystem getInput();

	/**
	 * Sets the value of the '{@link org.polymodel.BasicRelation#getInput <em>Input</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' containment reference.
	 * @see #getInput()
	 * @generated
	 */
	void setInput(IntConstraintSystem value);

	/**
	 * Returns the value of the '<em><b>Output</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' containment reference.
	 * @see #setOutput(IntConstraintSystem)
	 * @see org.polymodel.PolymodelPackage#getBasicRelation_Output()
	 * @model containment="true"
	 * @generated
	 */
	IntConstraintSystem getOutput();

	/**
	 * Sets the value of the '{@link org.polymodel.BasicRelation#getOutput <em>Output</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' containment reference.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(IntConstraintSystem value);

	/**
	 * Returns the value of the '<em><b>Relation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relation</em>' containment reference.
	 * @see #setRelation(IntConstraintSystem)
	 * @see org.polymodel.PolymodelPackage#getBasicRelation_Relation()
	 * @model containment="true"
	 * @generated
	 */
	IntConstraintSystem getRelation();

	/**
	 * Sets the value of the '{@link org.polymodel.BasicRelation#getRelation <em>Relation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relation</em>' containment reference.
	 * @see #getRelation()
	 * @generated
	 */
	void setRelation(IntConstraintSystem value);

	/**
	 * Returns the value of the '<em><b>In</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In</em>' containment reference.
	 * @see #setIn(Label)
	 * @see org.polymodel.PolymodelPackage#getBasicRelation_In()
	 * @model containment="true"
	 * @generated
	 */
	Label getIn();

	/**
	 * Sets the value of the '{@link org.polymodel.BasicRelation#getIn <em>In</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In</em>' containment reference.
	 * @see #getIn()
	 * @generated
	 */
	void setIn(Label value);

	/**
	 * Returns the value of the '<em><b>Out</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out</em>' containment reference.
	 * @see #setOut(Label)
	 * @see org.polymodel.PolymodelPackage#getBasicRelation_Out()
	 * @model containment="true"
	 * @generated
	 */
	Label getOut();

	/**
	 * Sets the value of the '{@link org.polymodel.BasicRelation#getOut <em>Out</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out</em>' containment reference.
	 * @see #getOut()
	 * @generated
	 */
	void setOut(Label value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitBasicRelation(this);'"
	 * @generated
	 */
	void accept(PolymodelVisitor visitor);

} // BasicRelation
