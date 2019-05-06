/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.multidim.impl;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.polymodel.Domain;
import org.polymodel.algebra.Variable;
import org.polymodel.prdg.scheduling.Dependency;
import org.polymodel.prdg.scheduling.SchedulePrototype;
import org.polymodel.prdg.scheduling.ScheduleTerm;
import org.polymodel.prdg.scheduling.impl.DependencyImpl;
import org.polymodel.prdg.scheduling.multidim.MultidimPackage;
import org.polymodel.prdg.scheduling.multidim.NullifiableDependency;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Single Dimension Dependency</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.multidim.impl.NullifiableDependencyImpl#getDimension <em>Dimension</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.multidim.impl.NullifiableDependencyImpl#getPreviousDimensionsDependencies <em>Previous Dimensions Dependencies</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.multidim.impl.NullifiableDependencyImpl#getSatisfactionVariable <em>Satisfaction Variable</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.multidim.impl.NullifiableDependencyImpl#getDependency <em>Dependency</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.multidim.impl.NullifiableDependencyImpl#getK <em>K</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NullifiableDependencyImpl extends DependencyImpl implements
		NullifiableDependency {
	/**
	 * The default value of the '{@link #getDimension() <em>Dimension</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDimension()
	 * @generated
	 * @ordered
	 */
	protected static final int DIMENSION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDimension() <em>Dimension</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDimension()
	 * @generated
	 * @ordered
	 */
	protected int dimension = DIMENSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPreviousDimensionsDependencies()
	 * <em>Previous Dimensions Dependencies</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPreviousDimensionsDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<NullifiableDependency> previousDimensionsDependencies;

	/**
	 * The cached value of the '{@link #getSatisfactionVariable()
	 * <em>Satisfaction Variable</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSatisfactionVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable satisfactionVariable;

	/**
	 * The cached value of the '{@link #getDependency() <em>Dependency</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDependency()
	 * @generated
	 * @ordered
	 */
	protected Dependency dependency;

	/**
	 * The default value of the '{@link #getK() <em>K</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getK()
	 * @generated
	 * @ordered
	 */
	protected static final long K_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getK() <em>K</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getK()
	 * @generated
	 * @ordered
	 */
	protected long k = K_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected NullifiableDependencyImpl() {
		super();
	}

	public NullifiableDependencyImpl(int dimension,
			Variable satisfactionVariable, Dependency dependency, long k) {
		this.dimension = dimension;
		this.satisfactionVariable = satisfactionVariable;
		setDependency(dependency);
		this.k = k;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MultidimPackage.Literals.NULLIFIABLE_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getDimension() {
		return dimension;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDimension(int newDimension) {
		int oldDimension = dimension;
		dimension = newDimension;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MultidimPackage.NULLIFIABLE_DEPENDENCY__DIMENSION, oldDimension, dimension));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NullifiableDependency> getPreviousDimensionsDependencies() {
		if (previousDimensionsDependencies == null) {
			previousDimensionsDependencies = new EObjectResolvingEList<NullifiableDependency>(NullifiableDependency.class, this, MultidimPackage.NULLIFIABLE_DEPENDENCY__PREVIOUS_DIMENSIONS_DEPENDENCIES);
		}
		return previousDimensionsDependencies;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getSatisfactionVariable() {
		return satisfactionVariable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSatisfactionVariable(
			Variable newSatisfactionVariable, NotificationChain msgs) {
		Variable oldSatisfactionVariable = satisfactionVariable;
		satisfactionVariable = newSatisfactionVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MultidimPackage.NULLIFIABLE_DEPENDENCY__SATISFACTION_VARIABLE, oldSatisfactionVariable, newSatisfactionVariable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSatisfactionVariable(Variable newSatisfactionVariable) {
		if (newSatisfactionVariable != satisfactionVariable) {
			NotificationChain msgs = null;
			if (satisfactionVariable != null)
				msgs = ((InternalEObject)satisfactionVariable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MultidimPackage.NULLIFIABLE_DEPENDENCY__SATISFACTION_VARIABLE, null, msgs);
			if (newSatisfactionVariable != null)
				msgs = ((InternalEObject)newSatisfactionVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MultidimPackage.NULLIFIABLE_DEPENDENCY__SATISFACTION_VARIABLE, null, msgs);
			msgs = basicSetSatisfactionVariable(newSatisfactionVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MultidimPackage.NULLIFIABLE_DEPENDENCY__SATISFACTION_VARIABLE, newSatisfactionVariable, newSatisfactionVariable));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Dependency getDependency() {
		return dependency;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public NotificationChain basicSetDependency(Dependency newDependency,
			NotificationChain msgs) {
		Dependency oldDependency = dependency;
		dependency = newDependency;
		setSource(dependency.getSource());
		setReference(dependency.getReference());
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					MultidimPackage.NULLIFIABLE_DEPENDENCY__DEPENDENCY,
					oldDependency, newDependency);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDependency(Dependency newDependency) {
		if (newDependency != dependency) {
			NotificationChain msgs = null;
			if (dependency != null)
				msgs = ((InternalEObject)dependency).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MultidimPackage.NULLIFIABLE_DEPENDENCY__DEPENDENCY, null, msgs);
			if (newDependency != null)
				msgs = ((InternalEObject)newDependency).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MultidimPackage.NULLIFIABLE_DEPENDENCY__DEPENDENCY, null, msgs);
			msgs = basicSetDependency(newDependency, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MultidimPackage.NULLIFIABLE_DEPENDENCY__DEPENDENCY, newDependency, newDependency));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public long getK() {
		return k;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setK(long newK) {
		long oldK = k;
		k = newK;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MultidimPackage.NULLIFIABLE_DEPENDENCY__K, oldK, k));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public SchedulePrototype basicGetReference() {
		return dependency.getReference();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MultidimPackage.NULLIFIABLE_DEPENDENCY__SATISFACTION_VARIABLE:
				return basicSetSatisfactionVariable(null, msgs);
			case MultidimPackage.NULLIFIABLE_DEPENDENCY__DEPENDENCY:
				return basicSetDependency(null, msgs);
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
			case MultidimPackage.NULLIFIABLE_DEPENDENCY__DIMENSION:
				return getDimension();
			case MultidimPackage.NULLIFIABLE_DEPENDENCY__PREVIOUS_DIMENSIONS_DEPENDENCIES:
				return getPreviousDimensionsDependencies();
			case MultidimPackage.NULLIFIABLE_DEPENDENCY__SATISFACTION_VARIABLE:
				return getSatisfactionVariable();
			case MultidimPackage.NULLIFIABLE_DEPENDENCY__DEPENDENCY:
				return getDependency();
			case MultidimPackage.NULLIFIABLE_DEPENDENCY__K:
				return getK();
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
			case MultidimPackage.NULLIFIABLE_DEPENDENCY__DIMENSION:
				setDimension((Integer)newValue);
				return;
			case MultidimPackage.NULLIFIABLE_DEPENDENCY__PREVIOUS_DIMENSIONS_DEPENDENCIES:
				getPreviousDimensionsDependencies().clear();
				getPreviousDimensionsDependencies().addAll((Collection<? extends NullifiableDependency>)newValue);
				return;
			case MultidimPackage.NULLIFIABLE_DEPENDENCY__SATISFACTION_VARIABLE:
				setSatisfactionVariable((Variable)newValue);
				return;
			case MultidimPackage.NULLIFIABLE_DEPENDENCY__DEPENDENCY:
				setDependency((Dependency)newValue);
				return;
			case MultidimPackage.NULLIFIABLE_DEPENDENCY__K:
				setK((Long)newValue);
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
			case MultidimPackage.NULLIFIABLE_DEPENDENCY__DIMENSION:
				setDimension(DIMENSION_EDEFAULT);
				return;
			case MultidimPackage.NULLIFIABLE_DEPENDENCY__PREVIOUS_DIMENSIONS_DEPENDENCIES:
				getPreviousDimensionsDependencies().clear();
				return;
			case MultidimPackage.NULLIFIABLE_DEPENDENCY__SATISFACTION_VARIABLE:
				setSatisfactionVariable((Variable)null);
				return;
			case MultidimPackage.NULLIFIABLE_DEPENDENCY__DEPENDENCY:
				setDependency((Dependency)null);
				return;
			case MultidimPackage.NULLIFIABLE_DEPENDENCY__K:
				setK(K_EDEFAULT);
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
			case MultidimPackage.NULLIFIABLE_DEPENDENCY__DIMENSION:
				return dimension != DIMENSION_EDEFAULT;
			case MultidimPackage.NULLIFIABLE_DEPENDENCY__PREVIOUS_DIMENSIONS_DEPENDENCIES:
				return previousDimensionsDependencies != null && !previousDimensionsDependencies.isEmpty();
			case MultidimPackage.NULLIFIABLE_DEPENDENCY__SATISFACTION_VARIABLE:
				return satisfactionVariable != null;
			case MultidimPackage.NULLIFIABLE_DEPENDENCY__DEPENDENCY:
				return dependency != null;
			case MultidimPackage.NULLIFIABLE_DEPENDENCY__K:
				return k != K_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return "Nullifiable " + getDependency().getClass().getSimpleName();
	}

	@Override
	public Domain getDependencyDomain() {
		return dependency.getDependencyDomain();
	}

	@Override
	public EList<ScheduleTerm> buildAllDependencyTerms(
			List<ScheduleTerm> sourceTerms, List<ScheduleTerm> referenceTerms) {
		EList<ScheduleTerm> terms = dependency.buildAllDependencyTerms(
				sourceTerms, referenceTerms);
		if (requireNullification())
			terms.addAll(buildNullificationTerms());
		return terms;
	}

	@Override
	public EList<Variable> getAllVariables() {
		EList<Variable> allVariables = new UniqueEList<Variable>(
				dependency.getAllVariables());
//		if (requireNullification()) {
//			allVariables.add(satisfactionVariable);
//		}
		return allVariables;
	}

	/**
	 * Nullification is required only if the dependency has a non zero causality
	 * term
	 * 
	 * @return
	 */
	@Override
	public boolean requireNullification() {
		ScheduleTerm causalityTerm = dependency.getCausalityTerm();
		return !causalityTerm.isNull();
	}

	@Override
	public ScheduleTerm getCausalityTerm() {
		return schedulingConcreteFactory.createScheduleTerm(
				satisfactionVariable, dependency.getCausalityTerm().getExp());
	}

	/**
	 * Build the terms that nullify causality constraint for dimensions that are
	 * already strongly satisfied.
	 * 
	 * @return
	 */
	private List<ScheduleTerm> buildNullificationTerms() {
		List<ScheduleTerm> terms = new ArrayList<ScheduleTerm>();
		for (NullifiableDependency previous : getPreviousDimensionsDependencies()) {
			Variable previousSatisfactionVariable = previous
					.getSatisfactionVariable();
			for (Variable p : getParameters()) {
				ScheduleTerm t = schedulingConcreteFactory.createScheduleTerm(
						previousSatisfactionVariable, affine(term(k, p)));
				terms.add(t);
			}
			terms.add(schedulingConcreteFactory.createScheduleTerm(
					previousSatisfactionVariable, affine(term(k))));
		}

		return terms;
	}

} // SingleDimensionDependencyImpl
