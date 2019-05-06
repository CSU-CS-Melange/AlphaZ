/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.Variable;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.IScopAnnotation;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopPackage;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopVisitor;
import org.polymodel.scop.util.ScopLoopIteratorUtil;
import org.polymodel.scop.util.ScopNodeConstraintsBuilder;
import org.polymodel.scop.util.ScopSimplify;

import fr.irisa.cairn.tools.ecore.query.EMFUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Scop Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.scop.impl.AbstractScopNodeImpl#getScopAnnotations <em>Scop Annotations</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractScopNodeImpl extends EObjectImpl implements AbstractScopNode {
	/**
	 * The cached value of the '{@link #getScopAnnotations() <em>Scop Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScopAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<IScopAnnotation> scopAnnotations;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractScopNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScopPackage.Literals.ABSTRACT_SCOP_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IScopAnnotation> getScopAnnotations() {
		if (scopAnnotations == null) {
			scopAnnotations = new EObjectContainmentEList<IScopAnnotation>(IScopAnnotation.class, this, ScopPackage.ABSTRACT_SCOP_NODE__SCOP_ANNOTATIONS);
		}
		return scopAnnotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Variable> getSurroundingIterators() {
		return ScopLoopIteratorUtil.getSurroundingIterators(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ScopFor> getSurroundingScopFors() {
		return ScopLoopIteratorUtil.getSurroundingScopFors(this);
	}
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AbstractScopNode simplify() {
		return ScopSimplify.simplify(this);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getLoopDepth() {
		return ScopLoopIteratorUtil.getLoopDepth(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final ScopVisitor visitor) {
		visitor.visitAbstractScopNode(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ScopFor getSurroundingScopFor() {
		EObject obj = eContainer();
		while (obj != null) {
			if (obj instanceof ScopFor) {
				return (ScopFor)obj;
			}
			obj = obj.eContainer();
		}
		
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ScopPackage.ABSTRACT_SCOP_NODE__SCOP_ANNOTATIONS:
				return ((InternalEList<?>)getScopAnnotations()).basicRemove(otherEnd, msgs);
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
			case ScopPackage.ABSTRACT_SCOP_NODE__SCOP_ANNOTATIONS:
				return getScopAnnotations();
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
			case ScopPackage.ABSTRACT_SCOP_NODE__SCOP_ANNOTATIONS:
				getScopAnnotations().clear();
				getScopAnnotations().addAll((Collection<? extends IScopAnnotation>)newValue);
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
			case ScopPackage.ABSTRACT_SCOP_NODE__SCOP_ANNOTATIONS:
				getScopAnnotations().clear();
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
			case ScopPackage.ABSTRACT_SCOP_NODE__SCOP_ANNOTATIONS:
				return scopAnnotations != null && !scopAnnotations.isEmpty();
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
			case ScopPackage.ABSTRACT_SCOP_NODE___GET_SURROUNDING_ITERATORS:
				return getSurroundingIterators();
			case ScopPackage.ABSTRACT_SCOP_NODE___GET_SURROUNDING_SCOP_FORS:
				return getSurroundingScopFors();
			case ScopPackage.ABSTRACT_SCOP_NODE___SIMPLIFY:
				return simplify();
			case ScopPackage.ABSTRACT_SCOP_NODE___GET_LOOP_DEPTH:
				return getLoopDepth();
			case ScopPackage.ABSTRACT_SCOP_NODE___ACCEPT__SCOPVISITOR:
				accept((ScopVisitor)arguments.get(0));
				return null;
			case ScopPackage.ABSTRACT_SCOP_NODE___GET_SURROUNDING_SCOP_FOR:
				return getSurroundingScopFor();
			case ScopPackage.ABSTRACT_SCOP_NODE___GET_DERIVED_CONSTRAINTS:
				return getDerivedConstraints();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<IntConstraintSystem> getDerivedConstraints() {
		return new BasicEList<IntConstraintSystem>(ScopNodeConstraintsBuilder.getConstraints(this));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public <T extends ScopRoot> T getScopRoot() {
		return (T) EMFUtils.<ScopRoot>eContainerTypeSelect(this, ScopRoot.class);
	}

	

} //AbstractScopNodeImpl
