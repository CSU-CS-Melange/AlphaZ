/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.multidim.impl;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraintSystem;
import static org.polymodel.algebra.factory.IntExpressionBuilder.eq;
import static org.polymodel.algebra.factory.IntExpressionBuilder.ge;
import static org.polymodel.algebra.factory.IntExpressionBuilder.le;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;
import static org.polymodel.prdg.scheduling.util.SchedulingToolFunctions.intersection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.Domain;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.prdg.scheduling.Dependency;
import org.polymodel.prdg.scheduling.SchedulePrototype;
import org.polymodel.prdg.scheduling.StatementSchedulePrototype;
import org.polymodel.prdg.scheduling.farkas.FarkasDependencyConstraints;
import org.polymodel.prdg.scheduling.multidim.MultidimDependency;
import org.polymodel.prdg.scheduling.multidim.MultidimPackage;
import org.polymodel.prdg.scheduling.multidim.NullifiableDependency;
import org.polymodel.prdg.scheduling.notifications.FarkasNotification;

import fr.irisa.cairn.graph.observer.INotification;
import fr.irisa.cairn.graph.observer.IObserver;
import fr.irisa.cairn.graph.observer.Observable;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Dependency</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.polymodel.prdg.scheduling.multidim.impl.MultidimDependencyImpl#getDependencies
 * <em>Dependencies</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated NOT
 */
public class MultidimDependencyImpl extends EObjectImpl implements
		MultidimDependency {

	private Observable observable = new Observable();

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}
	 * ' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<NullifiableDependency> dependencies;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MultidimDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MultidimPackage.Literals.MULTIDIM_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<NullifiableDependency> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectContainmentEList<NullifiableDependency>(
					NullifiableDependency.class, this,
					MultidimPackage.MULTIDIM_DEPENDENCY__DEPENDENCIES);
		}
		return dependencies;
	}

	private Integer lb;

	@Override
	public Integer getLb() {
		return lb;
	}

	@Override
	public void setLb(Integer lb) {
		this.lb = lb;
	}

	@Override
	public Integer getUb() {
		return ub;
	}

	@Override
	public void setUb(Integer ub) {
		this.ub = ub;
	}

	private Integer ub;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Domain computeConstraints() {

		Domain result = null;
		List<AffineTerm> onlyOneStronglySatisfiedTerms = new ArrayList<AffineTerm>();
		boolean hasNullification = false;

		for (NullifiableDependency d : dependencies) {
			EList<IntConstraint> context = new BasicEList<IntConstraint>();
			if (d.requireNullification()) {
				hasNullification = true;
				// Satisfaction variables are booleans and only one can be
				// strongly
				// satisfied
				onlyOneStronglySatisfiedTerms.add(term(d
						.getSatisfactionVariable()));

				if (hasBoundedSatisfactionVariable(d)) {
					booleanBound(d, context);
				}
				for (NullifiableDependency previous : d
						.getPreviousDimensionsDependencies()) {
					if (hasBoundedSatisfactionVariable(d)) {
						booleanBound(previous, context);
					}
				}
			}
			context.addAll(getBoundedContext(d));
			// Apply farkas lemma
			FarkasDependencyConstraints farkas = new FarkasDependencyConstraints(
					d, context);
			if (lb != null)
				farkas.setScheduleCoeficientsLowerBound(lb);
			if (ub != null)
				farkas.setScheduleCoeficientsUpperBound(ub);
			
			Domain applied = farkas.getApplied();
//			System.out.println("Constraints for "+d +": "+applied);
			result = intersection(result, applied);
		
			notify(new FarkasNotification(this, farkas));
		}
		if (hasNullification) {
			Domain stronglySatisfiedDomain = PolymodelComponent.INSTANCE
					.getFactory().createDomain(
							result.getDimensions().copy(),
							constraintSystem(eq(
									affine(onlyOneStronglySatisfiedTerms),
									affine(term(1)))));

			result = intersection(result, stronglySatisfiedDomain);
		}


		return result;
	}
	

	private List<IntConstraint> getBoundedContext(Dependency d) {
		SchedulePrototype source = d.getSource();
		SchedulePrototype reference = d.getReference();

		// Upper and lower bounds context
		List<IntConstraint> context = new ArrayList<IntConstraint>();

		if (source instanceof StatementSchedulePrototype) {
			for (Variable v : source.getCoeficients()) {
				if (source.getConstantTerm().getVar() != v) {
					if (lb != null)
						context.add(ge(affine(term(v)), affine(term(lb))));
					if (ub != null)
						context.add(le(affine(term(v)), affine(term(ub))));
				}
			}
		}
		if (reference instanceof StatementSchedulePrototype) {
			for (Variable v : reference.getCoeficients()) {
				if (reference.getConstantTerm().getVar() != v) {
					if (lb != null)
						context.add(ge(affine(term(v)), affine(term(lb))));
					if (ub != null)
						context.add(le(affine(term(v)), affine(term(ub))));
				}
			}
		}

		return context;

	}

	private void booleanBound(NullifiableDependency d,
			List<IntConstraint> constraints) {
		constraints.add(ge(affine(term(d.getSatisfactionVariable())),
				affine(term(0))));
		constraints.add(le(affine(term(d.getSatisfactionVariable())),
				affine(term(1))));
	}

	private boolean hasBoundedSatisfactionVariable(Dependency d) {
		AffineExpression exp = d.getCausalityTerm().getExp();
		return !(exp.isEquivalent(affine(term(0))) == FuzzyBoolean.YES);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Variable> getAllScheduleCoefficients() {
		EList<Variable> vars = new UniqueEList<Variable>();
		for (NullifiableDependency d : getDependencies()) {
			vars.addAll(d.getSource().getCoeficients());
			vars.addAll(d.getReference().getCoeficients());
		}
		return vars;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Variable> getAllSatisfactionVariables() {
		EList<Variable> vars = new UniqueEList<Variable>();
		for (NullifiableDependency d : getDependencies()) {
			vars.add(d.getSatisfactionVariable());
		}
		return vars;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Variable> getAllSourceCoefficients() {
		EList<Variable> vars = new UniqueEList<Variable>();
		for (NullifiableDependency d : getDependencies()) {
			vars.addAll(d.getSource().getCoeficients());
		}
		return vars;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Variable> getAllReferenceCoefficients() {
		EList<Variable> vars = new UniqueEList<Variable>();
		for (NullifiableDependency d : getDependencies()) {
			vars.addAll(d.getReference().getCoeficients());
		}
		return vars;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MultidimPackage.MULTIDIM_DEPENDENCY__DEPENDENCIES:
			return ((InternalEList<?>) getDependencies()).basicRemove(otherEnd,
					msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MultidimPackage.MULTIDIM_DEPENDENCY__DEPENDENCIES:
			return getDependencies();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MultidimPackage.MULTIDIM_DEPENDENCY__DEPENDENCIES:
			getDependencies().clear();
			getDependencies().addAll(
					(Collection<? extends NullifiableDependency>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case MultidimPackage.MULTIDIM_DEPENDENCY__DEPENDENCIES:
			getDependencies().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MultidimPackage.MULTIDIM_DEPENDENCY__DEPENDENCIES:
			return dependencies != null && !dependencies.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public void addObserver(IObserver arg0) {
		observable.addObserver(arg0);

	}

	@Override
	public boolean canBeDeliver() {
		return observable.canBeDeliver();
	}

	@Override
	public boolean containObserver(IObserver arg0) {
		return observable.containObserver(arg0);
	}

	@Override
	public Collection<IObserver> getObservers() {
		return observable.getObservers();
	}

	@Override
	public void notify(INotification arg0) {
		observable.notify(arg0);

	}

	@Override
	public boolean removeObserver(IObserver arg0) {
		return observable.removeObserver(arg0);
	}

	@Override
	public void setDeliver(boolean arg0) {
		observable.setDeliver(arg0);

	}

} // MultidimDependencyImpl
