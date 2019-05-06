/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polymodel.Domain;
import org.polymodel.Function;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.prdg.DependenceFunction;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.scheduling.EdgeDependency;
import org.polymodel.prdg.scheduling.ScheduleTerm;
import org.polymodel.prdg.scheduling.SchedulingPackage;
import org.polymodel.prdg.scheduling.StatementSchedulePrototype;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Edge Dependency</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.impl.EdgeDependencyImpl#getEdge <em>Edge</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EdgeDependencyImpl extends DependencyImpl implements
		EdgeDependency {
	/**
	 * The cached value of the '{@link #getEdge() <em>Edge</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getEdge()
	 * @generated
	 * @ordered
	 */
	protected PRDGEdge edge;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgeDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulingPackage.Literals.EDGE_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PRDGEdge getEdge() {
		if (edge != null && edge.eIsProxy()) {
			InternalEObject oldEdge = (InternalEObject)edge;
			edge = (PRDGEdge)eResolveProxy(oldEdge);
			if (edge != oldEdge) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulingPackage.EDGE_DEPENDENCY__EDGE, oldEdge, edge));
			}
		}
		return edge;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PRDGEdge basicGetEdge() {
		return edge;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdge(PRDGEdge newEdge) {
		PRDGEdge oldEdge = edge;
		edge = newEdge;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.EDGE_DEPENDENCY__EDGE, oldEdge, edge));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulingPackage.EDGE_DEPENDENCY__EDGE:
				if (resolve) return getEdge();
				return basicGetEdge();
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
			case SchedulingPackage.EDGE_DEPENDENCY__EDGE:
				setEdge((PRDGEdge)newValue);
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
			case SchedulingPackage.EDGE_DEPENDENCY__EDGE:
				setEdge((PRDGEdge)null);
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
			case SchedulingPackage.EDGE_DEPENDENCY__EDGE:
				return edge != null;
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
			case SchedulingPackage.EDGE_DEPENDENCY___IS_UNIFORM:
				return isUniform();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isUniform() {
		if (edge.getFunction() instanceof DependenceFunction) {
			DependenceFunction df = (DependenceFunction) edge.getFunction();
			return df.isUniform();
		}
		throw new UnsupportedOperationException(
				"Edge of the prdg must be a dependency.");
	}

	private Domain dependencyDomain;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Domain getDependencyDomain() {
		if (dependencyDomain == null) {
			dependencyDomain = buildDependencyDomain();
		}
		return dependencyDomain;
	}

	protected Domain buildDependencyDomain() {
		Domain statementDomain = edge.getDomain().intersection(edge.getDestination().getDomain());
		Domain dependencyDomain = factory.createDomain(statementDomain
				.getDimensions().copy());
		for (IntConstraintSystem polyhedron : statementDomain.getPolyhedra()) {
			List<IntConstraint> constraints = new ArrayList<IntConstraint>();
			for (IntConstraint constraint : polyhedron.getConstraints()) {
				transformToInequations(constraints, constraint);
			}
			dependencyDomain.getPolyhedra().add(
					IntExpressionBuilder.constraintSystem(constraints));
		}
		return dependencyDomain;
	}

	protected void transformToInequations(List<IntConstraint> constraints,
			IntConstraint constraint) {
		if (constraint.getComparisonOperator() == ComparisonOperator.EQ) {
			// Build two constraints for the equivalence
			IntConstraint c1 = constraint.copy();
			c1.setComparisonOperator(ComparisonOperator.GE);
			IntConstraint c2 = constraint.copy();
			c2.setComparisonOperator(ComparisonOperator.LE);
			constraints.add(c1);
			constraints.add(c2);
		} else {
			constraints.add(constraint.copy());
		}
	}

	public EList<ScheduleTerm> buildAllDependencyTerms(
			List<ScheduleTerm> sourceTerms, List<ScheduleTerm> referenceTerms) {
		EList<ScheduleTerm> allTerms = new BasicEList<ScheduleTerm>();

		// Add distributed reference terms
		for (ScheduleTerm refTerm : referenceTerms) {
			allTerms.addAll(refTerm.distribute());
		}

		// Apply dependency mapping and distribute negated source terms
		Function sourceDependencyMapping = buildSourceDependencyMapping(edge
				.getFunction().getMapping());
		for (ScheduleTerm sourceTerm : sourceTerms) {
			ScheduleTerm appliedTerm = sourceTerm.apply(
					sourceDependencyMapping).negate();
			allTerms.addAll(appliedTerm.distribute());
		}
		return allTerms;
	}

	protected List<Variable> getParameters() {
		List<Variable> vars = new UniqueEList<Variable>(getSource()
				.getStatement().getDomain().getDimensions().getParameters());
		vars.addAll(getReference().getStatement().getDomain().getDimensions()
				.getParameters());
		return vars;
	}

	@Override
	public String toString() {
		return getSource().getStatement().getName() + "->"
				+ getReference().getStatement().getName();
	}

	@Override
	public StatementSchedulePrototype getSource() {
		return (StatementSchedulePrototype) super.getSource();
	}

	@Override
	public StatementSchedulePrototype getReference() {
		return (StatementSchedulePrototype) super.getReference();
	}

} // EdgeDependencyImpl
