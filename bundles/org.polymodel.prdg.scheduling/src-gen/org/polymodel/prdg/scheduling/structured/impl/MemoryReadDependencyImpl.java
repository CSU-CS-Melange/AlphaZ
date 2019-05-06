/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured.impl;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.eq;
import static org.polymodel.algebra.factory.IntExpressionBuilder.ge;
import static org.polymodel.algebra.factory.IntExpressionBuilder.gt;
import static org.polymodel.algebra.factory.IntExpressionBuilder.lt;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.polymodel.Domain;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.prdg.scheduling.ScheduleTerm;
import org.polymodel.prdg.scheduling.structured.BoundedChannel;
import org.polymodel.prdg.scheduling.structured.MemoryDependency;
import org.polymodel.prdg.scheduling.structured.MemoryReadDependency;
import org.polymodel.prdg.scheduling.structured.StructuredPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Memory Read Dependency</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.impl.MemoryReadDependencyImpl#getDimensionSizes <em>Dimension Sizes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MemoryReadDependencyImpl extends ChannelReadDependencyImpl
		implements MemoryReadDependency {
	/**
	 * The cached value of the '{@link #getDimensionSizes() <em>Dimension Sizes</em>}' attribute list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDimensionSizes()
	 * @generated
	 * @ordered
	 */
	protected EList<Long> dimensionSizes;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MemoryReadDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructuredPackage.Literals.MEMORY_READ_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Long> getDimensionSizes() {
		if (dimensionSizes == null) {
			dimensionSizes = new EDataTypeEList<Long>(Long.class, this, StructuredPackage.MEMORY_READ_DEPENDENCY__DIMENSION_SIZES);
		}
		return dimensionSizes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public BoundedChannel getChannel() {
		return (BoundedChannel) super.getChannel();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StructuredPackage.MEMORY_READ_DEPENDENCY__DIMENSION_SIZES:
				return getDimensionSizes();
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
			case StructuredPackage.MEMORY_READ_DEPENDENCY__DIMENSION_SIZES:
				getDimensionSizes().clear();
				getDimensionSizes().addAll((Collection<? extends Long>)newValue);
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
			case StructuredPackage.MEMORY_READ_DEPENDENCY__DIMENSION_SIZES:
				getDimensionSizes().clear();
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
			case StructuredPackage.MEMORY_READ_DEPENDENCY__DIMENSION_SIZES:
				return dimensionSizes != null && !dimensionSizes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == MemoryDependency.class) {
			switch (baseOperationID) {
				case StructuredPackage.MEMORY_DEPENDENCY___GET_CHANNEL: return StructuredPackage.MEMORY_READ_DEPENDENCY___GET_CHANNEL;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case StructuredPackage.MEMORY_READ_DEPENDENCY___GET_CHANNEL:
				return getChannel();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (dimensionSizes: ");
		result.append(dimensionSizes);
		result.append(')');
		return result.toString();
	}


	/**
	 * <!-- begin-user-doc --> Build the terms of: <br>
	 * <br>
	 * <i>Theta(allocation,f(A,i) +B) - Theta(Reference) >=0</i> <br>
	 * <br>
	 * Where: <li><i>Theta(allocation,f(A,i) +B)</i>: is the date where the data
	 * i is deallocated</li> <li><i>Theta(Reference)</i>: is the date where the
	 * data i is read by a statement</li> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public EList<ScheduleTerm> buildAllDependencyTerms(
			List<ScheduleTerm> allocationTerms,
			List<ScheduleTerm> statementTerms) {

		EList<ScheduleTerm> terms = new BasicEList<ScheduleTerm>();

		// Add the bounding coefficients of channel to the allocation date =
		// deallocation date of the data
		Map<Variable, IntExpression> subscriptsMap = new HashMap<Variable, IntExpression>();
		Domain refDomain = getReference().getDomain();

		for (int i = 0; i < refDomain.getNbIndices(); i++) {
			Variable dim = refDomain.getDimensions().getIndices().get(i);
			AffineExpression expression = getEdge().getFunction().getMapping()
					.getExpression(i).toAffine();
			Variable boundingCoefficient;
			boundingCoefficient = getBoundingCoefficient(i);

			List<AffineTerm> affineTerms = new ArrayList<AffineTerm>();
			affineTerms.addAll(expression.getTerms());
			affineTerms.add(term(boundingCoefficient));
			subscriptsMap.put(dim, affine(affineTerms));
		}

		// Add distributed allocation terms
		for (ScheduleTerm aterm : allocationTerms) {
			ScheduleTerm applied = aterm.apply(subscriptsMap);
			terms.addAll(applied.distribute());
		}

		// Add negated distributed statement terms
		for (ScheduleTerm sterm : statementTerms) {
			ScheduleTerm negatedTerm = sterm.negate();
			terms.addAll(negatedTerm.distribute());
		}
		return terms;
	}

	protected Domain dependencyDomain;

	/**
	 * Bounded Dependency domain is of the form : <br>
	 * <i>BD = {[i_1,...,i_k,b_1,...,b_k]: De and S_k>=b_k>=-S_k and
	 * sum(f_k*b_k)=B }</i> <br>
	 * <br>
	 * Where <i>S_k</i> is the upper bound of the dimension i_k and f_k its
	 * linearization factor. B is the maximal channel memory size.
	 */
	@Override
	public Domain getDependencyDomain() {
		if (dependencyDomain == null) {
			dependencyDomain = factory
					.createDomain(super.getDependencyDomain());
			Domain refDomain = getReference().getDomain();

			List<AffineTerm> boundingAffineTerms = new ArrayList<AffineTerm>();
			for (int i = 0; i < refDomain.getNbIndices(); i++) {
				Variable boundingCoefficient = getBoundingCoefficient(i);
				dependencyDomain.getDimensions().getIndices()
						.add(boundingCoefficient);
				long max = getDimensionSizes().get(i);
				dependencyDomain.addConstraint(gt(
						affine(term(boundingCoefficient)), affine(term(-max))));
				dependencyDomain.addConstraint(lt(
						affine(term(boundingCoefficient)), affine(term(max))));
				boundingAffineTerms.add(term(
						findLinearizationFactor(i, refDomain.getNbIndices()),
						boundingCoefficient));
			}
			dependencyDomain.addConstraint(eq(affine(boundingAffineTerms),
					affine(term(getChannel().getMaximalChannelSize()))));
			// dependencyDomain.addConstraint(ge(affine(boundingAffineTerms),affine(term(getChannel().getMaximalChannelSize()))));
		}
		return dependencyDomain.simplify();
	}

	private long findLinearizationFactor(int d, int nbDims) {
		long coef = 1;
		for (int i = d + 1; i < nbDims; i++) {
			long size = getDimensionSizes().get(i);
			coef = coef * size;
		}
		return coef;
	}

	private Variable getBoundingCoefficient(int b) {
		return getChannel().getBoundingCoefficients().get(b);
	}

	@Override
	public ScheduleTerm getCausalityTerm() {
		return schedulingConcreteFactory
				.createScheduleConstantTerm(affine(term(getAllocationDelay())));
	}

	public EList<Variable> getAllVariables() {
		UniqueEList<Variable> vars = new UniqueEList<Variable>(
				source.getScheduleIndices());
		vars.addAll(reference.getScheduleIndices());
		vars.addAll(source.getDomain().getDimensions().getParameters());
		vars.addAll(reference.getDomain().getDimensions().getParameters());
		vars.addAll(getChannel().getBoundingCoefficients());
		return vars;
	}

	protected int getAllocationDelay() {
		return 0;
	}

	/**
	 * Allocation coefficients are greater than zero
	 */
	@Override
	public EList<IntConstraint> getCoefficientsContext() {
		EList<IntConstraint> context = new BasicEList<IntConstraint>();
		for (Variable v : getSource().getCoeficients()) {
			context.add(ge(affine(term(v)), affine(term(0))));
		}
		return context;
	}

} // MemoryReadDependencyImpl
