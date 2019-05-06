/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.impl;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.Domain;
import org.polymodel.DomainDimensions;
import org.polymodel.Function;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.prettyprinter.algebra.LatexPrettyPrinter;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.matrix.Matrix;
import org.polymodel.matrix.MatrixRow;
import org.polymodel.prdg.scheduling.ScheduleCoefficient;
import org.polymodel.prdg.scheduling.SchedulePrototype;
import org.polymodel.prdg.scheduling.ScheduleTerm;
import org.polymodel.prdg.scheduling.SchedulingPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Schedule Prototype</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.impl.SchedulePrototypeImpl#getTerms <em>Terms</em>}</li>
 *   <li>{@link org.polymodel.prdg.scheduling.impl.SchedulePrototypeImpl#getCoeficients <em>Coeficients</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SchedulePrototypeImpl extends EObjectImpl implements
		SchedulePrototype {
	/**
	 * The cached value of the '{@link #getTerms() <em>Terms</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTerms()
	 * @generated
	 * @ordered
	 */
	protected EList<ScheduleTerm> terms;

	/**
	 * The cached value of the '{@link #getCoeficients() <em>Coeficients</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCoeficients()
	 * @generated
	 * @ordered
	 */
	protected EList<ScheduleCoefficient> coeficients;
	protected PolymodelDefaultFactory factory;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SchedulePrototypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulingPackage.Literals.SCHEDULE_PROTOTYPE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ScheduleTerm> getTerms() {
		if (terms == null) {
			terms = new EObjectContainmentEList<ScheduleTerm>(ScheduleTerm.class, this, SchedulingPackage.SCHEDULE_PROTOTYPE__TERMS);
		}
		return terms;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ScheduleCoefficient> getCoeficients() {
		if (coeficients == null) {
			coeficients = new EObjectContainmentWithInverseEList<ScheduleCoefficient>(ScheduleCoefficient.class, this, SchedulingPackage.SCHEDULE_PROTOTYPE__COEFICIENTS, SchedulingPackage.SCHEDULE_COEFFICIENT__OWNER);
		}
		return coeficients;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<ScheduleTerm> distribute() {
		EList<ScheduleTerm> disTerms = new BasicEList<ScheduleTerm>();
		for (ScheduleTerm term : getTerms()) {
			disTerms.addAll(term.distribute());
		}
		return disTerms;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ScheduleTerm getConstantTerm() {
		for (ScheduleTerm t : getTerms()) {
			if (t.getExp().getTerms().get(0).getVariable() == null)
				return t;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<ScheduleTerm> apply(Function mapping) {
		EList<ScheduleTerm> applied = new BasicEList<ScheduleTerm>();
		for (ScheduleTerm term : getTerms()) {
			applied.add(term.apply(mapping));
		}
		return applied;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public abstract Domain getDomain();

	public void setFactory(PolymodelDefaultFactory factory) {
		this.factory = factory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Variable> getScheduleIndices() {
		Domain domain = getDomain();
		DomainDimensions dimensions = domain.getDimensions();
		EList<Variable> indices = dimensions.getIndices();
		return indices;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulingPackage.SCHEDULE_PROTOTYPE__COEFICIENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getCoeficients()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulingPackage.SCHEDULE_PROTOTYPE__TERMS:
				return ((InternalEList<?>)getTerms()).basicRemove(otherEnd, msgs);
			case SchedulingPackage.SCHEDULE_PROTOTYPE__COEFICIENTS:
				return ((InternalEList<?>)getCoeficients()).basicRemove(otherEnd, msgs);
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
			case SchedulingPackage.SCHEDULE_PROTOTYPE__TERMS:
				return getTerms();
			case SchedulingPackage.SCHEDULE_PROTOTYPE__COEFICIENTS:
				return getCoeficients();
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
			case SchedulingPackage.SCHEDULE_PROTOTYPE__TERMS:
				getTerms().clear();
				getTerms().addAll((Collection<? extends ScheduleTerm>)newValue);
				return;
			case SchedulingPackage.SCHEDULE_PROTOTYPE__COEFICIENTS:
				getCoeficients().clear();
				getCoeficients().addAll((Collection<? extends ScheduleCoefficient>)newValue);
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
			case SchedulingPackage.SCHEDULE_PROTOTYPE__TERMS:
				getTerms().clear();
				return;
			case SchedulingPackage.SCHEDULE_PROTOTYPE__COEFICIENTS:
				getCoeficients().clear();
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
			case SchedulingPackage.SCHEDULE_PROTOTYPE__TERMS:
				return terms != null && !terms.isEmpty();
			case SchedulingPackage.SCHEDULE_PROTOTYPE__COEFICIENTS:
				return coeficients != null && !coeficients.isEmpty();
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
			case SchedulingPackage.SCHEDULE_PROTOTYPE___DISTRIBUTE:
				return distribute();
			case SchedulingPackage.SCHEDULE_PROTOTYPE___GET_CONSTANT_TERM:
				return getConstantTerm();
			case SchedulingPackage.SCHEDULE_PROTOTYPE___APPLY__FUNCTION:
				return apply((Function)arguments.get(0));
			case SchedulingPackage.SCHEDULE_PROTOTYPE___GET_DOMAIN:
				return getDomain();
			case SchedulingPackage.SCHEDULE_PROTOTYPE___GET_SCHEDULE_INDICES:
				return getScheduleIndices();
		}
		return super.eInvoke(operationID, arguments);
	}

	protected Map<Variable, Variable> varsMap = new HashMap<Variable, Variable>();

	@Override
	public Map<Variable, Variable> getScheduleIndicesMap() {
		return varsMap;
	}

	@Override
	public Variable getScheduleIndex(Variable index) {
		Variable scheduleIndexVariable = varsMap.get(index);
		if (scheduleIndexVariable == null) {
			varsMap.put(index, index);
			scheduleIndexVariable = index;
		}
		return scheduleIndexVariable;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		int size = getTerms().size();
		for (int i = 0; i < size - 1; i++) {
			sb.append(getTerms().get(i)).append(" + ");
		}
		if (size > 0)
			sb.append(getTerms().get(size - 1));
		return sb.toString();
	}

	public static String getLatexName(SchedulePrototype s) {
		StringBuffer sb = new StringBuffer();
		sb.append("\\Theta (").append(s.getName());

		EList<Variable> indices = s.getDomain().getDimensions().getIndices();
		if (indices.size() > 0)
			sb.append(",");
		for (int i = 0; i < indices.size() - 1; i++) {
			Variable variable = s.getScheduleIndex(indices.get(i));
			sb.append(LatexPrettyPrinter.latexFormatVariableName(variable.getName()))
					.append(",");
		}
		if (indices.size() > 0) {
			Variable variable = s
					.getScheduleIndex(indices.get(indices.size() - 1));
			sb.append(LatexPrettyPrinter.latexFormatVariableName(variable.getName()));
		}

		EList<Variable> parameters = s.getDomain().getDimensions()
				.getParameters();
		if (indices.size() > 0 && parameters.size() > 0)
			sb.append(",");
		for (int i = 0; i < parameters.size() - 1; i++) {
			sb.append(parameters.get(i).getName()).append(",");
		}
		if (parameters.size() > 0) {
			sb.append(parameters.get(parameters.size() - 1).getName());
		}
		sb.append(")");
		return sb.toString();
	}

	public String toLatex() {
		StringBuffer sb = new StringBuffer();
		sb.append(getLatexName(this)).append("=");
		int size = getTerms().size();
		for (int i = 0; i < size - 1; i++) {
			sb.append(getTerms().get(i).toLatex()).append(" + ");
		}
		if (size > 0)
			sb.append(getTerms().get(size - 1).toLatex());
		return sb.toString();
	}

	@Override
	public IntExpression applyScheduling(Domain d) {

		EList<Variable> indices = d.getDimensions().getIndices();
		if(d.getPolyhedra().size()>1)
			throw new IllegalArgumentException("Domain isn't a polyhedron");
		
		IntConstraintSystem system = d.getPolyhedra().get(0);
		Matrix m = factory.createMatrix(system, indices);
	
	
		Map<Variable, IntExpression> valuesMap = new HashMap<Variable, IntExpression>(getCoeficients().size());
		for (ScheduleCoefficient coef : getCoeficients()) {
			long value = findAssignedValue(coef, m, indices);
			AffineExpression affine = affine(term(value));
			valuesMap.put(coef, affine);
		}
	

		List<AffineTerm> terms = new ArrayList<AffineTerm>();
		for (ScheduleTerm scheduleTerm : getTerms()) {
			IntExpression applied = scheduleTerm.applyScheduleCoeficients(valuesMap);
			terms.addAll(applied.toAffine().getTerms());
		}
		if(terms.size()==0)
			return affine(term(0));
		return affine(terms).simplify();
	}

	private long findAssignedValue(Variable v, Matrix m, List<Variable> vars) {
		int constantCol = m.getNbCols()-1;
		for (int i = 0; i < m.getNbRows(); i++) {
			MatrixRow row = m.getRows().get(i);
			Variable assignedVariable = findAssignedVariable(row, vars);
			if (assignedVariable == v) {
				long value = -m.get(i, constantCol);
				return value;
			}
		}
		throw new RuntimeException("No value for " + v);
	}

	private Variable findAssignedVariable(MatrixRow row, List<Variable> vars) {
		for (int i = 1; i < row.getValues().size(); i++) {
			Long val = row.getValues().get(i);
			if (val != 0)
				return vars.get(i - 1);
		}
		throw new RuntimeException("No variable assigned in this row");
	}

} // SchedulePrototypeImpl
