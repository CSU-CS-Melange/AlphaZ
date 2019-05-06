/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR;

import org.eclipse.emf.common.util.EList;
import org.polymodel.Function;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Affine Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.AffineFunction#getPMmapping <em>PMmapping</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getAffineFunction()
 * @model
 * @generated
 */
public interface AffineFunction extends PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>PMmapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>PMmapping</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>PMmapping</em>' containment reference.
	 * @see #setPMmapping(Function)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getAffineFunction_PMmapping()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Function getPMmapping();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.AffineFunction#getPMmapping <em>PMmapping</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PMmapping</em>' containment reference.
	 * @see #getPMmapping()
	 * @generated
	 */
	void setPMmapping(Function value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" funcRequired="true"
	 * @generated
	 */
	boolean equivalence(AffineFunction func);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	AffineFunction compose(AffineFunction f2);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Variable> getParams();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Variable> getIndices();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	int getDimLHS();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	int getDimRHS();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<AffineExpression> getExpressions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	AffineFunction copy();
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="fr.irisa.cairn.model.polymodel.EPolymodelException" namesMany="true"
	 * @generated NOT
	 */
	AffineFunction inverse();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model namesMany="true"
	 * @generated
	 */
	AffineFunction inverse(EList<String> names);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model namesMany="true"
	 * @generated
	 */
	AffineFunction inverseInContext(Domain context, EList<String> names);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isUniform();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isBijective();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isIdentity();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	int getNParams();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	int getNIndices();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitAffineFunction(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

	EList<String> getParamNames();

	EList<String> getIndexNames();
	
	EList<Integer> getConstantPart();
	
	void addParameterDimension(String name);
	void addDimension(String name);

} // AffineFunction
