/**
 */
package edu.csu.melange.alphabets.xtext.alphabets;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AUse Equation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AUseEquation#getExtDom <em>Ext Dom</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AUseEquation#getNameSubSys <em>Name Sub Sys</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AUseEquation#getParam <em>Param</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AUseEquation#getInputs <em>Inputs</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.AUseEquation#getOutputs <em>Outputs</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAUseEquation()
 * @model
 * @generated
 */
public interface AUseEquation extends AEquation, AlphabetsVisitable
{
  /**
	 * Returns the value of the '<em><b>Ext Dom</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ext Dom</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Ext Dom</em>' containment reference.
	 * @see #setExtDom(ADomain)
	 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAUseEquation_ExtDom()
	 * @model containment="true"
	 * @generated
	 */
  ADomain getExtDom();

  /**
	 * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AUseEquation#getExtDom <em>Ext Dom</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ext Dom</em>' containment reference.
	 * @see #getExtDom()
	 * @generated
	 */
  void setExtDom(ADomain value);

  /**
	 * Returns the value of the '<em><b>Name Sub Sys</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name Sub Sys</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Name Sub Sys</em>' attribute.
	 * @see #setNameSubSys(String)
	 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAUseEquation_NameSubSys()
	 * @model
	 * @generated
	 */
  String getNameSubSys();

  /**
	 * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AUseEquation#getNameSubSys <em>Name Sub Sys</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name Sub Sys</em>' attribute.
	 * @see #getNameSubSys()
	 * @generated
	 */
  void setNameSubSys(String value);

  /**
	 * Returns the value of the '<em><b>Param</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Param</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Param</em>' containment reference.
	 * @see #setParam(AIndexAffineExpressionList)
	 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAUseEquation_Param()
	 * @model containment="true"
	 * @generated
	 */
  AIndexAffineExpressionList getParam();

  /**
	 * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AUseEquation#getParam <em>Param</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Param</em>' containment reference.
	 * @see #getParam()
	 * @generated
	 */
  void setParam(AIndexAffineExpressionList value);

  /**
	 * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
	 * The list contents are of type {@link edu.csu.melange.alphabets.xtext.alphabets.AAlphabetsExpression}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inputs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' containment reference list.
	 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAUseEquation_Inputs()
	 * @model containment="true"
	 * @generated
	 */
  EList<AAlphabetsExpression> getInputs();

  /**
	 * Returns the value of the '<em><b>Outputs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Outputs</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' containment reference.
	 * @see #setOutputs(AIdentifierList)
	 * @see edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage#getAUseEquation_Outputs()
	 * @model containment="true"
	 * @generated
	 */
  AIdentifierList getOutputs();

  /**
	 * Sets the value of the '{@link edu.csu.melange.alphabets.xtext.alphabets.AUseEquation#getOutputs <em>Outputs</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outputs</em>' containment reference.
	 * @see #getOutputs()
	 * @generated
	 */
  void setOutputs(AIdentifierList value);

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitAUseEquation(this);'"
	 * @generated
	 */
	void accept(AlphabetsVisitor visitor);

} // AUseEquation
