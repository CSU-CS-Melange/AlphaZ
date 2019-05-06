/**
 */
package org.polymodel.polyhedralIR.polyIRCG.PCOT;

import org.eclipse.emf.common.util.EList;
import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.Struct;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Recursion Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#isParallel <em>Parallel</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#getBaseFunction <em>Base Function</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#getBandStart <em>Band Start</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#getBandEnd <em>Band End</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#getParamStruct <em>Param Struct</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#getLocalStruct <em>Local Struct</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#getRecurStructs <em>Recur Structs</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#getTileSizes <em>Tile Sizes</em>}</li>
 * </ul>
 *
 * @see org.polymodel.polyhedralIR.polyIRCG.PCOT.PCOTPackage#getRecursionBody()
 * @model
 * @generated
 */
public interface RecursionBody extends Body {
	/**
	 * Returns the value of the '<em><b>Parallel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parallel</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parallel</em>' attribute.
	 * @see #setParallel(boolean)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PCOT.PCOTPackage#getRecursionBody_Parallel()
	 * @model required="true"
	 * @generated
	 */
	boolean isParallel();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#isParallel <em>Parallel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parallel</em>' attribute.
	 * @see #isParallel()
	 * @generated
	 */
	void setParallel(boolean value);

	/**
	 * Returns the value of the '<em><b>Base Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Function</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Function</em>' reference.
	 * @see #setBaseFunction(Function)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PCOT.PCOTPackage#getRecursionBody_BaseFunction()
	 * @model required="true"
	 * @generated
	 */
	Function getBaseFunction();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#getBaseFunction <em>Base Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Function</em>' reference.
	 * @see #getBaseFunction()
	 * @generated
	 */
	void setBaseFunction(Function value);

	/**
	 * Returns the value of the '<em><b>Band Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Band Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Band Start</em>' attribute.
	 * @see #setBandStart(int)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PCOT.PCOTPackage#getRecursionBody_BandStart()
	 * @model required="true"
	 * @generated
	 */
	int getBandStart();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#getBandStart <em>Band Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Band Start</em>' attribute.
	 * @see #getBandStart()
	 * @generated
	 */
	void setBandStart(int value);

	/**
	 * Returns the value of the '<em><b>Band End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Band End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Band End</em>' attribute.
	 * @see #setBandEnd(int)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PCOT.PCOTPackage#getRecursionBody_BandEnd()
	 * @model required="true"
	 * @generated
	 */
	int getBandEnd();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#getBandEnd <em>Band End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Band End</em>' attribute.
	 * @see #getBandEnd()
	 * @generated
	 */
	void setBandEnd(int value);

	/**
	 * Returns the value of the '<em><b>Param Struct</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Param Struct</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Param Struct</em>' reference.
	 * @see #setParamStruct(Struct)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PCOT.PCOTPackage#getRecursionBody_ParamStruct()
	 * @model required="true"
	 * @generated
	 */
	Struct getParamStruct();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#getParamStruct <em>Param Struct</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Param Struct</em>' reference.
	 * @see #getParamStruct()
	 * @generated
	 */
	void setParamStruct(Struct value);

	/**
	 * Returns the value of the '<em><b>Local Struct</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Struct</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Struct</em>' reference.
	 * @see #setLocalStruct(Struct)
	 * @see org.polymodel.polyhedralIR.polyIRCG.PCOT.PCOTPackage#getRecursionBody_LocalStruct()
	 * @model
	 * @generated
	 */
	Struct getLocalStruct();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.polyIRCG.PCOT.RecursionBody#getLocalStruct <em>Local Struct</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Struct</em>' reference.
	 * @see #getLocalStruct()
	 * @generated
	 */
	void setLocalStruct(Struct value);

	/**
	 * Returns the value of the '<em><b>Recur Structs</b></em>' reference list.
	 * The list contents are of type {@link org.polymodel.polyhedralIR.polyIRCG.Struct}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recur Structs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recur Structs</em>' reference list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PCOT.PCOTPackage#getRecursionBody_RecurStructs()
	 * @model required="true"
	 * @generated
	 */
	EList<Struct> getRecurStructs();

	/**
	 * Returns the value of the '<em><b>Tile Sizes</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tile Sizes</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tile Sizes</em>' attribute list.
	 * @see org.polymodel.polyhedralIR.polyIRCG.PCOT.PCOTPackage#getRecursionBody_TileSizes()
	 * @model
	 * @generated
	 */
	EList<String> getTileSizes();

} // RecursionBody
