/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.Domain;
import org.polymodel.prdg.scheduling.Dependency;
import org.polymodel.prdg.scheduling.ScheduleTerm;
import org.polymodel.prdg.scheduling.impl.DependencyImpl;
import org.polymodel.prdg.scheduling.structured.CompositeDependency;
import org.polymodel.prdg.scheduling.structured.StructuredPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Composite Dependency</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.impl.CompositeDependencyImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.impl.CompositeDependencyImpl#getDependencyDomain <em>Dependency Domain</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeDependencyImpl extends DependencyImpl implements
		CompositeDependency {
	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}
	 * ' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<Dependency> dependencies;

	/**
	 * The cached value of the '{@link #getDependencyDomain() <em>Dependency Domain</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDependencyDomain()
	 * @generated
	 * @ordered
	 */
	protected Domain dependencyDomain;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructuredPackage.Literals.COMPOSITE_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Dependency> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectContainmentEList<Dependency>(Dependency.class, this, StructuredPackage.COMPOSITE_DEPENDENCY__DEPENDENCIES);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Domain getDependencyDomain() {
		if (dependencyDomain != null && dependencyDomain.eIsProxy()) {
			InternalEObject oldDependencyDomain = (InternalEObject)dependencyDomain;
			dependencyDomain = (Domain)eResolveProxy(oldDependencyDomain);
			if (dependencyDomain != oldDependencyDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StructuredPackage.COMPOSITE_DEPENDENCY__DEPENDENCY_DOMAIN, oldDependencyDomain, dependencyDomain));
			}
		}
		return dependencyDomain;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Domain basicGetDependencyDomain() {
		return dependencyDomain;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependencyDomain(Domain newDependencyDomain) {
		Domain oldDependencyDomain = dependencyDomain;
		dependencyDomain = newDependencyDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StructuredPackage.COMPOSITE_DEPENDENCY__DEPENDENCY_DOMAIN, oldDependencyDomain, dependencyDomain));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StructuredPackage.COMPOSITE_DEPENDENCY__DEPENDENCIES:
				return ((InternalEList<?>)getDependencies()).basicRemove(otherEnd, msgs);
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
			case StructuredPackage.COMPOSITE_DEPENDENCY__DEPENDENCIES:
				return getDependencies();
			case StructuredPackage.COMPOSITE_DEPENDENCY__DEPENDENCY_DOMAIN:
				if (resolve) return getDependencyDomain();
				return basicGetDependencyDomain();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StructuredPackage.COMPOSITE_DEPENDENCY__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection<? extends Dependency>)newValue);
				return;
			case StructuredPackage.COMPOSITE_DEPENDENCY__DEPENDENCY_DOMAIN:
				setDependencyDomain((Domain)newValue);
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
			case StructuredPackage.COMPOSITE_DEPENDENCY__DEPENDENCIES:
				getDependencies().clear();
				return;
			case StructuredPackage.COMPOSITE_DEPENDENCY__DEPENDENCY_DOMAIN:
				setDependencyDomain((Domain)null);
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
			case StructuredPackage.COMPOSITE_DEPENDENCY__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
			case StructuredPackage.COMPOSITE_DEPENDENCY__DEPENDENCY_DOMAIN:
				return dependencyDomain != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public EList<ScheduleTerm> buildAllDependencyTerms(
			List<ScheduleTerm> sourceTerms, List<ScheduleTerm> referenceTerms) {
		throw new UnsupportedOperationException(
				"Can't build terms on a composite dependency");
	}

} // CompositeDependencyImpl
