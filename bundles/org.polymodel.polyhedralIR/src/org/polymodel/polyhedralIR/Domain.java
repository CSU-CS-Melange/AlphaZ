/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR;

import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.Domain#getPMdomain <em>PMdomain</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getDomain()
 * @model
 * @generated
 */
public interface Domain extends PolyhedralIRVisitable {
	/**
	 * Returns the value of the '<em><b>PMdomain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>PMdomain</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>PMdomain</em>' containment reference.
	 * @see #setPMdomain(org.polymodel.Domain)
	 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getDomain_PMdomain()
	 * @model containment="true" required="true"
	 * @generated
	 */
	org.polymodel.Domain getPMdomain();

	/**
	 * Sets the value of the '{@link org.polymodel.polyhedralIR.Domain#getPMdomain <em>PMdomain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PMdomain</em>' containment reference.
	 * @see #getPMdomain()
	 * @generated
	 */
	void setPMdomain(org.polymodel.Domain value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	Domain union(Domain domain);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	Domain intersection(Domain domain);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	Domain difference(Domain domain);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean equivalence(Domain domain);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isUniverse();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isEmpty();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	Domain image(AffineFunction T);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	Domain preimage(AffineFunction T);

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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitDomain(this);'"
	 * @generated
	 */
	void accept(PolyhedralIRVisitor visitor);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" fRequired="true" rangeRequired="true"
	 * @generated
	 */
	Domain transitiveClosure(AffineFunction f, Domain range);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" fRequired="true" rangeRequired="true"
	 * @generated
	 */
	Domain exactTransitiveClosure(AffineFunction f, Domain range);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	int getDim();
	
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
	 * @model nameRequired="true"
	 * @generated
	 */
	void addDimension(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nameRequired="true"
	 * @generated
	 */
	void addParameterDimension(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void simplify();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model contextRequired="true"
	 * @generated
	 */
	void simplifyInContext(Domain context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	Domain boundingBox();
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	Domain affineHull();
	
	Domain polyhedralHull();
	Domain copy();
	
	ParameterDomain toParameterDomain();

	/**
	 * <!-- begin-user-doc -->
	 * Given a target dimension, computes the lower and upper bounds as expressions of parameter and min/max, cield/floord.
	 * First element of the result array is LB and second is the UB.
	 * <!-- end-user-doc -->
	 * @model lower="2" upper="2" dimRequired="true"
	 * @generated
	 */
	EList<IntExpression> getBounds(int dim);

	IntExpression getLowerBound(int dim);
	
	EList<String> getParamNames();
	EList<String> getIndexNames();
	
	

} // Domain
