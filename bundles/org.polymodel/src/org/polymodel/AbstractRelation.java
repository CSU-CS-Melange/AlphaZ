/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel;

import org.eclipse.emf.common.util.EList;
import org.polymodel.matrix.Matrix;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.AbstractRelation#getDimensions <em>Dimensions</em>}</li>
 *   <li>{@link org.polymodel.AbstractRelation#getBasicRelations <em>Basic Relations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.PolymodelPackage#getAbstractRelation()
 * @model abstract="true"
 * @generated
 */
public interface AbstractRelation extends PolymodelVisitable {
	/**
	 * Returns the value of the '<em><b>Dimensions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimensions</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimensions</em>' containment reference.
	 * @see #setDimensions(RelationDimensions)
	 * @see org.polymodel.PolymodelPackage#getAbstractRelation_Dimensions()
	 * @model containment="true"
	 * @generated
	 */
	RelationDimensions getDimensions();

	/**
	 * Sets the value of the '{@link org.polymodel.AbstractRelation#getDimensions <em>Dimensions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dimensions</em>' containment reference.
	 * @see #getDimensions()
	 * @generated
	 */
	void setDimensions(RelationDimensions value);

	/**
	 * Returns the value of the '<em><b>Basic Relations</b></em>' containment reference list.
	 * The list contents are of type {@link org.polymodel.BasicRelation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Basic Maps</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Basic Relations</em>' containment reference list.
	 * @see org.polymodel.PolymodelPackage#getAbstractRelation_BasicRelations()
	 * @model containment="true"
	 * @generated
	 */
	EList<BasicRelation> getBasicRelations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void accept(PolymodelVisitor visitor);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" managerRequired="true"
	 * @generated
	 */
	<T extends AbstractRelation> T reverse(DimensionsManager manager);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	<T extends AbstractRelation> T intersectDomain(Domain context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	<T extends AbstractRelation> T intersectRange(Domain context);
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	<T extends AbstractRelation> T intersection(AbstractRelation map);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	<T extends AbstractRelation> T union(AbstractRelation map);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" mapRequired="true"
	 * @generated
	 */
	<T extends AbstractRelation> T difference(AbstractRelation map);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	<T extends Function> T buildFunction();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	<T extends Domain> T getDomain();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	<T extends Domain> T getRange();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" mapRequired="true"
	 * @generated
	 */
	<T extends AbstractRelation> T applyDomain(AbstractRelation map);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" mapRequired="true"
	 * @generated
	 */
	<T extends AbstractRelation> T applyRange(AbstractRelation map);

	/**
	 * <!-- begin-user-doc -->
	 * Computes transitive closure, which may be an over approximation.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	<T extends AbstractRelation> T transitiveClosure();

	/**
	 * <!-- begin-user-doc -->
	 * Computes transitive closure, throws RuntimeException if the 
	 * computed closure is not exact.
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	<T extends AbstractRelation> T exactTransitiveClosure();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	<T extends AbstractRelation> T simplify();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Matrix> toMatrices();

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
	boolean isSingleValued();

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
	boolean equivalence(AbstractRelation map);

	//	/**
//	 * Either use PolymodelComponent.INSTANCE.getDefaultDimensionsManager()
//	 * or manage dimension management at higher level.
//	 */
//	@Deprecated
//	DimensionsManager getDimensionsManager();

	int getNbParams();
	int getNbInputs();
	int getNbOutputs();

	public void setInputLabel(Label label);
	public void setOutputLabel(Label label);
	
} // AbstractRelation
