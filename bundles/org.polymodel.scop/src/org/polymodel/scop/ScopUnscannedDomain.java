/**
 */
package org.polymodel.scop;

import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.IntExpression;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unscanned Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.scop.ScopUnscannedDomain#getMacroParams <em>Macro Params</em>}</li>
 *   <li>{@link org.polymodel.scop.ScopUnscannedDomain#getName <em>Name</em>}</li>
 *   <li>{@link org.polymodel.scop.ScopUnscannedDomain#getSchedule <em>Schedule</em>}</li>
 * </ul>
 *
 * @see org.polymodel.scop.ScopPackage#getScopUnscannedDomain()
 * @model
 * @generated
 */
public interface ScopUnscannedDomain extends AbstractScopStatement, ScopVisitable {
	/**
	 * Returns the value of the '<em><b>Macro Params</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.algebra.IntExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Macro Params</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Macro Params</em>' containment reference list.
	 * @see org.polymodel.scop.ScopPackage#getScopUnscannedDomain_MacroParams()
	 * @model containment="true"
	 * @generated
	 */
	EList<IntExpression> getMacroParams();

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
	 * @see org.polymodel.scop.ScopPackage#getScopUnscannedDomain_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.polymodel.scop.ScopUnscannedDomain#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Schedule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schedule</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schedule</em>' attribute.
	 * @see #setSchedule(JNIISLUnionMap)
	 * @see org.polymodel.scop.ScopPackage#getScopUnscannedDomain_Schedule()
	 * @model dataType="org.polymodel.scop.JNIISLUnionMap"
	 * @generated
	 */
	JNIISLUnionMap getSchedule();

	/**
	 * Sets the value of the '{@link org.polymodel.scop.ScopUnscannedDomain#getSchedule <em>Schedule</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule</em>' attribute.
	 * @see #getSchedule()
	 * @generated
	 */
	void setSchedule(JNIISLUnionMap value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitScopUnscannedDomain(this);'"
	 * @generated
	 */
	void accept(ScopVisitor visitor);

} // ScopUnscannedDomain
