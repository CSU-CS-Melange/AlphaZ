/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured.impl;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polymodel.Domain;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.prdg.scheduling.ScheduleTerm;
import org.polymodel.prdg.scheduling.structured.LinearDependency;
import org.polymodel.prdg.scheduling.structured.LinearMemoryDeallocationDependency;
import org.polymodel.prdg.scheduling.structured.StructuredPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Linear Memory Deallocation Dependency</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.impl.LinearMemoryDeallocationDependencyImpl#getSubscript <em>Subscript</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinearMemoryDeallocationDependencyImpl extends
		MemoryDependencyImpl implements LinearMemoryDeallocationDependency {
	/**
	 * The cached value of the '{@link #getSubscript() <em>Subscript</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSubscript()
	 * @generated
	 * @ordered
	 */
	protected IntExpression subscript;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected LinearMemoryDeallocationDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructuredPackage.Literals.LINEAR_MEMORY_DEALLOCATION_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IntExpression getSubscript() {
		return subscript;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubscript(IntExpression newSubscript,
			NotificationChain msgs) {
		IntExpression oldSubscript = subscript;
		subscript = newSubscript;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StructuredPackage.LINEAR_MEMORY_DEALLOCATION_DEPENDENCY__SUBSCRIPT, oldSubscript, newSubscript);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubscript(IntExpression newSubscript) {
		if (newSubscript != subscript) {
			NotificationChain msgs = null;
			if (subscript != null)
				msgs = ((InternalEObject)subscript).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StructuredPackage.LINEAR_MEMORY_DEALLOCATION_DEPENDENCY__SUBSCRIPT, null, msgs);
			if (newSubscript != null)
				msgs = ((InternalEObject)newSubscript).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StructuredPackage.LINEAR_MEMORY_DEALLOCATION_DEPENDENCY__SUBSCRIPT, null, msgs);
			msgs = basicSetSubscript(newSubscript, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StructuredPackage.LINEAR_MEMORY_DEALLOCATION_DEPENDENCY__SUBSCRIPT, newSubscript, newSubscript));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StructuredPackage.LINEAR_MEMORY_DEALLOCATION_DEPENDENCY__SUBSCRIPT:
				return basicSetSubscript(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StructuredPackage.LINEAR_MEMORY_DEALLOCATION_DEPENDENCY__SUBSCRIPT:
				return getSubscript();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StructuredPackage.LINEAR_MEMORY_DEALLOCATION_DEPENDENCY__SUBSCRIPT:
				setSubscript((IntExpression)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StructuredPackage.LINEAR_MEMORY_DEALLOCATION_DEPENDENCY__SUBSCRIPT:
				setSubscript((IntExpression)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StructuredPackage.LINEAR_MEMORY_DEALLOCATION_DEPENDENCY__SUBSCRIPT:
				return subscript != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == LinearDependency.class) {
			switch (derivedFeatureID) {
				case StructuredPackage.LINEAR_MEMORY_DEALLOCATION_DEPENDENCY__SUBSCRIPT: return StructuredPackage.LINEAR_DEPENDENCY__SUBSCRIPT;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == LinearDependency.class) {
			switch (baseFeatureID) {
				case StructuredPackage.LINEAR_DEPENDENCY__SUBSCRIPT: return StructuredPackage.LINEAR_MEMORY_DEALLOCATION_DEPENDENCY__SUBSCRIPT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	@Override
	public Domain getDependencyDomain() {
		return getChannel().getDomain();
	}

	@Override
	public EList<ScheduleTerm> buildAllDependencyTerms(
			List<ScheduleTerm> deallocationTerms,
			List<ScheduleTerm> allocationTerms) {

		EList<ScheduleTerm> terms = new BasicEList<ScheduleTerm>();

		// Add the size of channel to the allocation date = deallocation date of
		// the data
		Map<Variable, IntExpression> subscriptsMap = new HashMap<Variable, IntExpression>();
		subscriptsMap.put(
				getChannel().getSubscriptDimension(),
				IntExpressionBuilder.add(getChannel().getMaximalChannelSize(),
						subscript.copy()).toAffine());
		// Add distributed deallocation terms
		for (ScheduleTerm aterm : deallocationTerms) {
			ScheduleTerm applied = aterm.apply(subscriptsMap);
			terms.addAll(applied.distribute());
		}

		// Add negated distributed allocation terms
		Map<Variable, IntExpression> subscriptsMap2 = new HashMap<Variable, IntExpression>();
		subscriptsMap2.put(getChannel().getSubscriptDimension(), subscript
				.copy().toAffine());
		for (ScheduleTerm sterm : allocationTerms) {
			ScheduleTerm negatedTerm = sterm.apply(subscriptsMap2).negate();
			terms.addAll(negatedTerm.distribute());
		}
		return terms;
	}

	@Override
	public ScheduleTerm getCausalityTerm() {
		return schedulingConcreteFactory
				.createScheduleConstantTerm(affine(term(0)));
	}

} // LinearMemoryDeallocationDependencyImpl
