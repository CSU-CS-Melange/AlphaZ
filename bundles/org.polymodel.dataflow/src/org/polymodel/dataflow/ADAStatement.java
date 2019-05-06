/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.dataflow;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.Domain;
import org.polymodel.Function;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ADA Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.dataflow.ADAStatement#getId <em>Id</em>}</li>
 *   <li>{@link org.polymodel.dataflow.ADAStatement#getWrites <em>Writes</em>}</li>
 *   <li>{@link org.polymodel.dataflow.ADAStatement#getReads <em>Reads</em>}</li>
 *   <li>{@link org.polymodel.dataflow.ADAStatement#getParentADAInput <em>Parent ADA Input</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.dataflow.DataflowPackage#getADAStatement()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ADAStatement extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see org.polymodel.dataflow.DataflowPackage#getADAStatement_Id()
	 * @model required="true"
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link org.polymodel.dataflow.ADAStatement#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

	/**
	 * Returns the value of the '<em><b>Writes</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.dataflow.WriteAccess}.
	 * It is bidirectional and its opposite is '{@link org.polymodel.dataflow.WriteAccess#getParentADAStatement <em>Parent ADA Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Writes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Writes</em>' reference list.
	 * @see org.polymodel.dataflow.DataflowPackage#getADAStatement_Writes()
	 * @see org.polymodel.dataflow.WriteAccess#getParentADAStatement
	 * @model opposite="parentADAStatement"
	 * @generated NOT
	 */
	EList<? extends WriteAccess> getWrites();

	/**
	 * Returns the value of the '<em><b>Reads</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.dataflow.ReadAccess}.
	 * It is bidirectional and its opposite is '{@link org.polymodel.dataflow.ReadAccess#getParentADAStatement <em>Parent ADA Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reads</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reads</em>' reference list.
	 * @see org.polymodel.dataflow.DataflowPackage#getADAStatement_Reads()
	 * @see org.polymodel.dataflow.ReadAccess#getParentADAStatement
	 * @model opposite="parentADAStatement"
	 * @generated NOT
	 */
	EList<? extends ReadAccess> getReads();

	/**
	 * Returns the value of the '<em><b>Parent ADA Input</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.polymodel.dataflow.ADAInput#getAdaStatements <em>Ada Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent ADA Input</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent ADA Input</em>' reference.
	 * @see #setParentADAInput(ADAInput)
	 * @see org.polymodel.dataflow.DataflowPackage#getADAStatement_ParentADAInput()
	 * @see org.polymodel.dataflow.ADAInput#getAdaStatements
	 * @model opposite="adaStatements" required="true"
	 * @generated
	 */
	ADAInput getParentADAInput();

	/**
	 * Sets the value of the '{@link org.polymodel.dataflow.ADAStatement#getParentADAInput <em>Parent ADA Input</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent ADA Input</em>' reference.
	 * @see #getParentADAInput()
	 * @generated
	 */
	void setParentADAInput(ADAInput value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	Domain getDomain();

	/**
	 * <!-- begin-user-doc --> This method returns the schedule of the statement
	 * in the original loop. The Array Dataflow Analysis is computed according
	 * to the schedule given by this method. Following is one example of a
	 * correct identity schedule : <BR>
	 * 
	 * <PRE>
	 * S0(); // id schedule is (0,0,0)
	 * for (i = 0; i &lt; N; i++)
	 * 	S1(i); // id schedule is (1,i,0)
	 * </PRE>
	 * 
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	Function getIDSchedule();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isResolved();

} // ADAStatement
