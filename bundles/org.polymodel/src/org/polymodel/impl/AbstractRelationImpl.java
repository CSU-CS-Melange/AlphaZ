/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.AbstractRelation;
import org.polymodel.BasicRelation;
import org.polymodel.DimensionsManager;
import org.polymodel.Domain;
import org.polymodel.Function;
import org.polymodel.PolymodelPackage;
import org.polymodel.PolymodelVisitor;
import org.polymodel.RelationDimensions;
import org.polymodel.algebra.Variable;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.matrix.Matrix;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.impl.AbstractRelationImpl#getDimensions <em>Dimensions</em>}</li>
 *   <li>{@link org.polymodel.impl.AbstractRelationImpl#getBasicRelations <em>Basic Relations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractRelationImpl extends EObjectImpl implements AbstractRelation {
	/**
	 * The cached value of the '{@link #getDimensions() <em>Dimensions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDimensions()
	 * @generated
	 * @ordered
	 */
	protected RelationDimensions dimensions;

	/**
	 * The cached value of the '{@link #getBasicRelations() <em>Basic Relations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasicRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<BasicRelation> basicRelations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolymodelPackage.Literals.ABSTRACT_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationDimensions getDimensions() {
		return dimensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDimensions(RelationDimensions newDimensions, NotificationChain msgs) {
		RelationDimensions oldDimensions = dimensions;
		dimensions = newDimensions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolymodelPackage.ABSTRACT_RELATION__DIMENSIONS, oldDimensions, newDimensions);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDimensions(RelationDimensions newDimensions) {
		if (newDimensions != dimensions) {
			NotificationChain msgs = null;
			if (dimensions != null)
				msgs = ((InternalEObject)dimensions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolymodelPackage.ABSTRACT_RELATION__DIMENSIONS, null, msgs);
			if (newDimensions != null)
				msgs = ((InternalEObject)newDimensions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolymodelPackage.ABSTRACT_RELATION__DIMENSIONS, null, msgs);
			msgs = basicSetDimensions(newDimensions, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolymodelPackage.ABSTRACT_RELATION__DIMENSIONS, newDimensions, newDimensions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BasicRelation> getBasicRelations() {
		if (basicRelations == null) {
			basicRelations = new EObjectContainmentEList<BasicRelation>(BasicRelation.class, this, PolymodelPackage.ABSTRACT_RELATION__BASIC_RELATIONS);
		}
		return basicRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(PolymodelVisitor visitor) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends AbstractRelation> T reverse(DimensionsManager manager) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends AbstractRelation> T intersectDomain(Domain context) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends AbstractRelation> T intersectRange(Domain context) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends AbstractRelation> T intersection(AbstractRelation map) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends AbstractRelation> T union(AbstractRelation map) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends AbstractRelation> T difference(AbstractRelation map) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends Function> T buildFunction() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends Domain> T getDomain() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends Domain> T getRange() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends AbstractRelation> T applyDomain(AbstractRelation map) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends AbstractRelation> T applyRange(AbstractRelation map) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends AbstractRelation> T transitiveClosure() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends AbstractRelation> T exactTransitiveClosure() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends AbstractRelation> T simplify() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Matrix> toMatrices() { 
		EList<Matrix> mats = new BasicEList<Matrix>();
		List<Variable> vars = new ArrayList<Variable>(getNbParams()+getNbInputs()+getNbOutputs());
		vars.addAll(getDimensions().getParameters());
		vars.addAll(getDimensions().getInputs());
		vars.addAll(getDimensions().getOutputs());
		for (BasicRelation br : getBasicRelations()) {
			Matrix mat = PolymodelComponent.INSTANCE.getFactory().createMatrix(br.getInput(), vars);
			if (br.getOutput().getConstraints().size()>0)
				mat = mat.appendRow(PolymodelComponent.INSTANCE.getFactory().createMatrix(br.getOutput(), vars));
			if (br.getRelation().getConstraints().size()>0)
			mat = mat.appendRow(PolymodelComponent.INSTANCE.getFactory().createMatrix(br.getRelation(), vars));
			mats.add(mat);
		}
		
		return mats;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBijective() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSingleValued() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEmpty() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean equivalence(AbstractRelation map) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolymodelPackage.ABSTRACT_RELATION__DIMENSIONS:
				return basicSetDimensions(null, msgs);
			case PolymodelPackage.ABSTRACT_RELATION__BASIC_RELATIONS:
				return ((InternalEList<?>)getBasicRelations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PolymodelPackage.ABSTRACT_RELATION__DIMENSIONS:
				return getDimensions();
			case PolymodelPackage.ABSTRACT_RELATION__BASIC_RELATIONS:
				return getBasicRelations();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PolymodelPackage.ABSTRACT_RELATION__DIMENSIONS:
				setDimensions((RelationDimensions)newValue);
				return;
			case PolymodelPackage.ABSTRACT_RELATION__BASIC_RELATIONS:
				getBasicRelations().clear();
				getBasicRelations().addAll((Collection<? extends BasicRelation>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PolymodelPackage.ABSTRACT_RELATION__DIMENSIONS:
				setDimensions((RelationDimensions)null);
				return;
			case PolymodelPackage.ABSTRACT_RELATION__BASIC_RELATIONS:
				getBasicRelations().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PolymodelPackage.ABSTRACT_RELATION__DIMENSIONS:
				return dimensions != null;
			case PolymodelPackage.ABSTRACT_RELATION__BASIC_RELATIONS:
				return basicRelations != null && !basicRelations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case PolymodelPackage.ABSTRACT_RELATION___ACCEPT__POLYMODELVISITOR:
				accept((PolymodelVisitor)arguments.get(0));
				return null;
			case PolymodelPackage.ABSTRACT_RELATION___REVERSE__DIMENSIONSMANAGER:
				return reverse((DimensionsManager)arguments.get(0));
			case PolymodelPackage.ABSTRACT_RELATION___IS_BIJECTIVE:
				return isBijective();
			case PolymodelPackage.ABSTRACT_RELATION___IS_SINGLE_VALUED:
				return isSingleValued();
			case PolymodelPackage.ABSTRACT_RELATION___IS_EMPTY:
				return isEmpty();
			case PolymodelPackage.ABSTRACT_RELATION___EQUIVALENCE__ABSTRACTRELATION:
				return equivalence((AbstractRelation)arguments.get(0));
			case PolymodelPackage.ABSTRACT_RELATION___INTERSECT_DOMAIN__DOMAIN:
				return intersectDomain((Domain)arguments.get(0));
			case PolymodelPackage.ABSTRACT_RELATION___INTERSECT_RANGE__DOMAIN:
				return intersectRange((Domain)arguments.get(0));
			case PolymodelPackage.ABSTRACT_RELATION___INTERSECTION__ABSTRACTRELATION:
				return intersection((AbstractRelation)arguments.get(0));
			case PolymodelPackage.ABSTRACT_RELATION___UNION__ABSTRACTRELATION:
				return union((AbstractRelation)arguments.get(0));
			case PolymodelPackage.ABSTRACT_RELATION___DIFFERENCE__ABSTRACTRELATION:
				return difference((AbstractRelation)arguments.get(0));
			case PolymodelPackage.ABSTRACT_RELATION___BUILD_FUNCTION:
				return buildFunction();
			case PolymodelPackage.ABSTRACT_RELATION___GET_DOMAIN:
				return getDomain();
			case PolymodelPackage.ABSTRACT_RELATION___GET_RANGE:
				return getRange();
			case PolymodelPackage.ABSTRACT_RELATION___APPLY_DOMAIN__ABSTRACTRELATION:
				return applyDomain((AbstractRelation)arguments.get(0));
			case PolymodelPackage.ABSTRACT_RELATION___APPLY_RANGE__ABSTRACTRELATION:
				return applyRange((AbstractRelation)arguments.get(0));
			case PolymodelPackage.ABSTRACT_RELATION___TRANSITIVE_CLOSURE:
				return transitiveClosure();
			case PolymodelPackage.ABSTRACT_RELATION___EXACT_TRANSITIVE_CLOSURE:
				return exactTransitiveClosure();
			case PolymodelPackage.ABSTRACT_RELATION___SIMPLIFY:
				return simplify();
			case PolymodelPackage.ABSTRACT_RELATION___TO_MATRICES:
				return toMatrices();
		}
		return super.eInvoke(operationID, arguments);
	}

} //AbstractRelationImpl
