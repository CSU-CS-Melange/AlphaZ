/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.targetMapping;

import org.polymodel.polyhedralIR.PolyhedralIRVisitable;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Standard Equation Space Time Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.targetMapping.StandardEquationSpaceTimeMap#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getStandardEquationSpaceTimeMap()
 * @model
 * @generated
 */
public interface StandardEquationSpaceTimeMap extends SpaceTimeMap, PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(VariableDeclaration)
	 * @see org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage#getStandardEquationSpaceTimeMap_Variable()
	 * @model required="true"
	 * @generated
	 */
	VariableDeclaration getVariable();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.targetMapping.StandardEquationSpaceTimeMap#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(VariableDeclaration value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitStandardEquationSpaceTimeMap(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

} // StandardEquationSpaceTimeMap
