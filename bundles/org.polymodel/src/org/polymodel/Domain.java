/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel;

import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.Variable;
import org.polymodel.matrix.Matrix;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Domain</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.Domain#getPolyhedra <em>Polyhedra</em>}</li>
 *   <li>{@link org.polymodel.Domain#getDimensions <em>Dimensions</em>}</li>
 *   <li>{@link org.polymodel.Domain#getLabel <em>Label</em>}</li>
 * </ul>
 *
 * @see org.polymodel.PolymodelPackage#getDomain()
 * @model
 * @generated
 */
public interface Domain extends PolymodelVisitable {
	/**
	 * Returns the value of the '<em><b>Polyhedra</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.algebra.IntConstraintSystem}.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Polyhedra</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Polyhedra</em>' containment reference list.
	 * @see org.polymodel.PolymodelPackage#getDomain_Polyhedra()
	 * @model containment="true"
	 * @generated
	 */
	EList<IntConstraintSystem> getPolyhedra();

	/**
	 * Returns the value of the '<em><b>Dimensions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimensions</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimensions</em>' containment reference.
	 * @see #setDimensions(DomainDimensions)
	 * @see org.polymodel.PolymodelPackage#getDomain_Dimensions()
	 * @model containment="true"
	 * @generated
	 */
	DomainDimensions getDimensions();

	/**
	 * Sets the value of the '{@link org.polymodel.Domain#getDimensions <em>Dimensions</em>}' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Dimensions</em>' containment reference.
	 * @see #getDimensions()
	 * @generated
	 */
	void setDimensions(DomainDimensions value);

	/**
	 * Returns the value of the '<em><b>Label</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Label</em>' reference.
	 * @see #setLabel(Label)
	 * @see org.polymodel.PolymodelPackage#getDomain_Label()
	 * @model
	 * @generated
	 */
	Label getLabel();

	/**
	 * Sets the value of the '{@link org.polymodel.Domain#getLabel <em>Label</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' containment reference.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(Label value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	<T extends Domain> T union(Domain domain);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	<T extends Domain> T image(AbstractRelation relation);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	<T extends Domain> T difference(Domain domain);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	<T extends Domain> T intersection(Domain domain);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isEmpty();

	/**
	 * <!-- begin-user-doc -->
	 * Simplifies domain in the given context.
	 * Simplify in context (ISL/Omega gist) removes redundant constraints (those that are also in the context) from the domain.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	<T extends Domain> T simplify(Domain context);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	<T extends Domain> T simplify();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model
	 * @generated NOT
	 */
	Domain boundingBox();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean equivalence(Domain domain);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitDomain(this);'"
	 * @generated
	 */
	void accept(PolymodelVisitor visitor);

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
	 * @model
	 * @generated
	 */
	<T extends Domain> T lexMin();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	<T extends Domain> T lexMax();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	<T extends Domain> T detectEqualities();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	<T extends Domain> T affineHull();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	<T extends Domain> T polyhedralHull();

	/**
	 * Project out the domain for an array of dimensions.
	 * 
	 * @param dimensions
	 * @return
	 */
	<T extends Domain> T projection(Variable... dimensions);

	/**
	 * Add a copy of a constraint to all polyhedra of the domain.
	 * 
	 * @param c
	 */
	void addConstraint(IntConstraint c);
	
//	/**
//	 * Either use PolymodelComponent.INSTANCE.getDefaultDimensionsManager()
//	 * or manage dimension management at higher level.
//	 */
//	@Deprecated
//	DimensionsManager getDimensionsManager();

	int getNbParams();
	int getNbIndices();
	EList<Variable> getParams();
	EList<Variable> getIndices();
	
	IntConstraintSystem[] applySimplify();
	
	/**
	 * Returns matrices in polylib format. One matrix per polyhedron.
	 * 
	 * @return
	 */
	EList<Matrix> toMatrices();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	<T extends Domain> T complement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	<T extends Domain> T cartesianProduct(Domain domain);
	
	<T extends Domain> T copy();
} // Domain
