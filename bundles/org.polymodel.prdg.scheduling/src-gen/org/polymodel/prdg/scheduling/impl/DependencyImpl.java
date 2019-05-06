/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.impl;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraint;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.DimensionsManager;
import org.polymodel.Domain;
import org.polymodel.Function;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.prdg.scheduling.Dependency;
import org.polymodel.prdg.scheduling.SchedulePrototype;
import org.polymodel.prdg.scheduling.ScheduleTerm;
import org.polymodel.prdg.scheduling.SchedulingConcreteFactory;
import org.polymodel.prdg.scheduling.SchedulingPackage;
import org.polymodel.prdg.scheduling.util.SchedulingToolFunctions;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Dependency</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.impl.DependencyImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.impl.DependencyImpl#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DependencyImpl extends EObjectImpl implements Dependency {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected SchedulePrototype source;

	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected SchedulePrototype reference;

	protected PolymodelDefaultFactory factory;

	protected DimensionsManager dimensionsManager;
	protected SchedulingConcreteFactory schedulingConcreteFactory = PolymodelComponent.INSTANCE
			.getInstance(SchedulingConcreteFactory.class);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected DependencyImpl() {
		super();
		this.factory = PolymodelComponent.INSTANCE.getFactory();
		this.dimensionsManager = PolymodelComponent.INSTANCE
				.getDefaultDimensionsManager();
	}

	public void initialize(PolymodelDefaultFactory factory,
			DimensionsManager dimensionsManager) {
		this.factory = factory;
		this.dimensionsManager = dimensionsManager;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulingPackage.Literals.DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulePrototype getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (SchedulePrototype)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulingPackage.DEPENDENCY__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulePrototype basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(SchedulePrototype newSource) {
		SchedulePrototype oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.DEPENDENCY__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulePrototype getReference() {
		if (reference != null && reference.eIsProxy()) {
			InternalEObject oldReference = (InternalEObject)reference;
			reference = (SchedulePrototype)eResolveProxy(oldReference);
			if (reference != oldReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulingPackage.DEPENDENCY__REFERENCE, oldReference, reference));
			}
		}
		return reference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulePrototype basicGetReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setReference(SchedulePrototype newReference) {
		SchedulePrototype oldReference = reference;
		reference = newReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.DEPENDENCY__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<ScheduleTerm> getTerms(boolean constantPart) {
		if (constantPart) {
			if (terms == null) {
				terms = buildTerms(true);
			}
			return terms;
		} else {
			if (termsWithoutConstantParts == null) {
				termsWithoutConstantParts = buildTerms(false);
			}
			return termsWithoutConstantParts;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<IntConstraint> getCoefficientsContext() {
		return new BasicEList<IntConstraint>();
	}

	private EList<ScheduleTerm> terms;
	private EList<ScheduleTerm> termsWithoutConstantParts;

	protected void manageContext(
			Map<Variable, ? extends Variable> referencesVariablesMap, Domain D,
			Domain context) {
		for (IntConstraintSystem dsys : context.getPolyhedra()) {
			for (IntConstraint c : dsys.getConstraints()) {
				IntConstraint copy = c.simplify();
				SchedulingToolFunctions.substituteWithVariablesMap(
						referencesVariablesMap, copy);
				D.addConstraint(copy);
			}
		}
	}

	/**
	 * Build the constraint between the source and reference indices.
	 * 
	 * @param sourceIdx
	 *            variable of the source index
	 * @param referenceExpr
	 *            expression for the source index in function of the reference
	 * @param referencesVariablesMap
	 *            mapping of source indices
	 * @return equality constraint between the source and the reference for the
	 *         index
	 */
	protected IntConstraint buildMappingConstraint(Variable sourceIdx,
			AffineExpression referenceExpr,
			Map<Variable, ? extends Variable> referencesVariablesMap) {
		AffineExpression expression = (AffineExpression) referenceExpr.copy();
		SchedulingToolFunctions.substituteWithVariablesMap(
				referencesVariablesMap, expression);

		expression.getTerms().add(term(-1, sourceIdx));
		return constraint(expression, affine(term(0)), ComparisonOperator.EQ);
	}

	/**
	 * Build dependency schedule terms. Variables are those from the statements
	 * domains. Last scheduled term is for the constant part (no variable).
	 * 
	 * @param withPrototypesConstantPart
	 *            true if constant terms of schedule prototype are used.
	 * @return
	 */
	protected EList<ScheduleTerm> buildTerms(boolean withPrototypesConstantPart) {

		List<ScheduleTerm> sourceTerms = getSourceTerms(withPrototypesConstantPart);
		List<ScheduleTerm> referenceTerms = getReferenceTerms(withPrototypesConstantPart);

		EList<ScheduleTerm> allTerms = buildAllDependencyTerms(sourceTerms,
				referenceTerms);
		allTerms.add(getCausalityTerm());
		EList<ScheduleTerm> terms = factorize(allTerms);
		return terms;
	}

	public abstract EList<ScheduleTerm> buildAllDependencyTerms(
			List<ScheduleTerm> sourceTerms, List<ScheduleTerm> referenceTerms);

	@Override
	public ScheduleTerm getCausalityTerm() {
		return schedulingConcreteFactory
				.createScheduleConstantTerm(affine(term(-1)));
	}

	/**
	 * Factorize and simplify the list of schedule terms
	 * 
	 * @param allTerms
	 * @return
	 */
	protected EList<ScheduleTerm> factorize(EList<ScheduleTerm> allTerms) {
		EList<ScheduleTerm> terms = SchedulingToolFunctions.factorize(allTerms,
				getAllVariables());

		// Simplification
		for (ScheduleTerm term : terms) {
			term.simplify();
		}
		return terms;
	}

	/**
	 * Get all variables that will be used to factorize the terms of the
	 * dependency.
	 * 
	 * @return
	 */
	@Override
	public EList<Variable> getAllVariables() {
		UniqueEList<Variable> vars = new UniqueEList<Variable>(
				source.getScheduleIndices());
		vars.addAll(reference.getScheduleIndices());
		vars.addAll(source.getDomain().getDimensions().getParameters());
		vars.addAll(reference.getDomain().getDimensions().getParameters());
		return vars;
	}

	private List<ScheduleTerm> getReferenceTerms(
			boolean withPrototypesConstantPart) {
		List<ScheduleTerm> referenceTerms = new ArrayList<ScheduleTerm>(
				reference.getTerms());
		if (!withPrototypesConstantPart) {
			referenceTerms.remove(reference.getConstantTerm());
		}
		return referenceTerms;
	}

	private List<ScheduleTerm> getSourceTerms(boolean withPrototypesConstantPart) {
		List<ScheduleTerm> sourceTerms = new ArrayList<ScheduleTerm>(
				source.getTerms());
		if (!withPrototypesConstantPart) {
			ScheduleTerm constantTerm = source.getConstantTerm();
			sourceTerms.remove(constantTerm);
		}
		return sourceTerms;
	}

	/**
	 * Build the affine mapping that may be applied to the source schedule
	 * prototype.
	 * 
	 * @return
	 */
	protected Function buildSourceDependencyMapping(Function mapping) {

		Map<Variable, Variable> varMap = source.getScheduleIndicesMap();

		EList<Variable> indices = mapping.getDimensions().getIndices();
		List<IntExpression> exressions = new ArrayList<IntExpression>();
		for (int i = 0; i < mapping.getExpressions().size(); i++) {
			AffineExpression expression = mapping.getExpression(i).copy()
					.toAffine();
			SchedulingToolFunctions.substituteWithVariablesMap(varMap,
					expression);
			exressions.add(expression);

		}

		return factory.createFunction(indices, mapping.getDimensions()
				.getParameters(), exressions, dimensionsManager);

	}

	protected List<Variable> getParameters() {
		List<Variable> vars = new UniqueEList<Variable>(getSource().getDomain()
				.getDimensions().getParameters());
		vars.addAll(getReference().getDomain().getDimensions().getParameters());
		return vars;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulingPackage.DEPENDENCY__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case SchedulingPackage.DEPENDENCY__REFERENCE:
				if (resolve) return getReference();
				return basicGetReference();
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
			case SchedulingPackage.DEPENDENCY__SOURCE:
				setSource((SchedulePrototype)newValue);
				return;
			case SchedulingPackage.DEPENDENCY__REFERENCE:
				setReference((SchedulePrototype)newValue);
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
			case SchedulingPackage.DEPENDENCY__SOURCE:
				setSource((SchedulePrototype)null);
				return;
			case SchedulingPackage.DEPENDENCY__REFERENCE:
				setReference((SchedulePrototype)null);
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
			case SchedulingPackage.DEPENDENCY__SOURCE:
				return source != null;
			case SchedulingPackage.DEPENDENCY__REFERENCE:
				return reference != null;
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
			case SchedulingPackage.DEPENDENCY___GET_TERMS__BOOLEAN:
				return getTerms((Boolean)arguments.get(0));
			case SchedulingPackage.DEPENDENCY___GET_COEFFICIENTS_CONTEXT:
				return getCoefficientsContext();
		}
		return super.eInvoke(operationID, arguments);
	}

} // DependencyImpl
