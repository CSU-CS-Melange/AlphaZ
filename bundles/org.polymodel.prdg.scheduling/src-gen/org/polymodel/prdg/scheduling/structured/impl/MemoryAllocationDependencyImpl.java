/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured.impl;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.polymodel.Domain;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.prdg.scheduling.ScheduleTerm;
import org.polymodel.prdg.scheduling.structured.BoundedChannel;
import org.polymodel.prdg.scheduling.structured.MemoryAllocationDependency;
import org.polymodel.prdg.scheduling.structured.MemoryDependency;
import org.polymodel.prdg.scheduling.structured.StructuredPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Memory Allocation Dependency</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class MemoryAllocationDependencyImpl extends ChannelReadDependencyImpl
		implements MemoryAllocationDependency {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MemoryAllocationDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructuredPackage.Literals.MEMORY_ALLOCATION_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public BoundedChannel getChannel() {
		return (BoundedChannel) channel;
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
				case StructuredPackage.MEMORY_DEPENDENCY___GET_CHANNEL: return StructuredPackage.MEMORY_ALLOCATION_DEPENDENCY___GET_CHANNEL;
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
			case StructuredPackage.MEMORY_ALLOCATION_DEPENDENCY___GET_CHANNEL:
				return getChannel();
		}
		return super.eInvoke(operationID, arguments);
	}

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
			subscriptsMap.put(dim, expression.copy());
		}

		// Add distributed statement terms
		for (ScheduleTerm sterm : statementTerms) {
			terms.addAll(sterm.distribute());
		}

		// Add applied and distributed negated allocation terms
		for (ScheduleTerm aterm : allocationTerms) {
			ScheduleTerm applied = aterm.apply(subscriptsMap).negate();
			terms.addAll(applied.distribute());
		}

		return terms;
	}

	@Override
	public ScheduleTerm getCausalityTerm() {
		return schedulingConcreteFactory
				.createScheduleConstantTerm(affine(term(0)));
	}
} // MemoryAllocationDependencyImpl
