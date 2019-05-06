/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured.impl;

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
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.prdg.scheduling.ScheduleTerm;
import org.polymodel.prdg.scheduling.structured.ChannelLinearWriteDependency;
import org.polymodel.prdg.scheduling.structured.LinearDependency;
import org.polymodel.prdg.scheduling.structured.StructuredPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Channel Linear Write Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.impl.ChannelLinearWriteDependencyImpl#getSubscript <em>Subscript</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChannelLinearWriteDependencyImpl extends ChannelWriteDependencyImpl implements ChannelLinearWriteDependency {
	/**
	 * The cached value of the '{@link #getSubscript() <em>Subscript</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubscript()
	 * @generated
	 * @ordered
	 */
	protected IntExpression subscript;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChannelLinearWriteDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructuredPackage.Literals.CHANNEL_LINEAR_WRITE_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntExpression getSubscript() {
		return subscript;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubscript(IntExpression newSubscript, NotificationChain msgs) {
		IntExpression oldSubscript = subscript;
		subscript = newSubscript;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StructuredPackage.CHANNEL_LINEAR_WRITE_DEPENDENCY__SUBSCRIPT, oldSubscript, newSubscript);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubscript(IntExpression newSubscript) {
		if (newSubscript != subscript) {
			NotificationChain msgs = null;
			if (subscript != null)
				msgs = ((InternalEObject)subscript).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StructuredPackage.CHANNEL_LINEAR_WRITE_DEPENDENCY__SUBSCRIPT, null, msgs);
			if (newSubscript != null)
				msgs = ((InternalEObject)newSubscript).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StructuredPackage.CHANNEL_LINEAR_WRITE_DEPENDENCY__SUBSCRIPT, null, msgs);
			msgs = basicSetSubscript(newSubscript, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StructuredPackage.CHANNEL_LINEAR_WRITE_DEPENDENCY__SUBSCRIPT, newSubscript, newSubscript));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StructuredPackage.CHANNEL_LINEAR_WRITE_DEPENDENCY__SUBSCRIPT:
				return basicSetSubscript(null, msgs);
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
			case StructuredPackage.CHANNEL_LINEAR_WRITE_DEPENDENCY__SUBSCRIPT:
				return getSubscript();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StructuredPackage.CHANNEL_LINEAR_WRITE_DEPENDENCY__SUBSCRIPT:
				setSubscript((IntExpression)newValue);
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
			case StructuredPackage.CHANNEL_LINEAR_WRITE_DEPENDENCY__SUBSCRIPT:
				setSubscript((IntExpression)null);
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
			case StructuredPackage.CHANNEL_LINEAR_WRITE_DEPENDENCY__SUBSCRIPT:
				return subscript != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == LinearDependency.class) {
			switch (derivedFeatureID) {
				case StructuredPackage.CHANNEL_LINEAR_WRITE_DEPENDENCY__SUBSCRIPT: return StructuredPackage.LINEAR_DEPENDENCY__SUBSCRIPT;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == LinearDependency.class) {
			switch (baseFeatureID) {
				case StructuredPackage.LINEAR_DEPENDENCY__SUBSCRIPT: return StructuredPackage.CHANNEL_LINEAR_WRITE_DEPENDENCY__SUBSCRIPT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}
	
	@Override
	public EList<ScheduleTerm> buildAllDependencyTerms(
			List<ScheduleTerm> sourceTerms, List<ScheduleTerm> referenceTerms) {
		EList<ScheduleTerm> terms = new BasicEList<ScheduleTerm>();

		Map<Variable, IntExpression> subscriptsMap = new HashMap<Variable, IntExpression>();
		subscriptsMap.put(getChannel().getSubscriptDimension(), subscript);
		// Add distributed read statement terms
		for (ScheduleTerm aterm : referenceTerms) {
			terms.addAll(aterm.apply(subscriptsMap).distribute());
		}

		// Add negation of applied distributed channel terms
	
		for (ScheduleTerm sterm : sourceTerms) {
			ScheduleTerm negatedTerm = sterm.negate();
			terms.addAll(negatedTerm.distribute());
		}
		return terms;
	}

} //ChannelLinearWriteDependencyImpl
