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
import org.polymodel.prdg.scheduling.ScheduleTerm;
import org.polymodel.prdg.scheduling.structured.BoundedChannel;
import org.polymodel.prdg.scheduling.structured.LinearMemoryAllocationDependency;
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
public class LinearMemoryAllocationDependencyImpl extends ChannelLinearReadDependencyImpl
		implements LinearMemoryAllocationDependency {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected LinearMemoryAllocationDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructuredPackage.Literals.LINEAR_MEMORY_ALLOCATION_DEPENDENCY;
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
				case StructuredPackage.MEMORY_DEPENDENCY___GET_CHANNEL: return StructuredPackage.LINEAR_MEMORY_ALLOCATION_DEPENDENCY___GET_CHANNEL;
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
			case StructuredPackage.LINEAR_MEMORY_ALLOCATION_DEPENDENCY___GET_CHANNEL:
				return getChannel();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> Build the terms of: <br>
	 * The data has to be allocated before its read.
	 * <br>
	 * <i>Theta(allocation,f_r(A,i)) <= Theta(Reference) </i> <br>
	 * <br>
	 * Where:Theta(Reference)</i>: is the date where the data f_r(A,i) is read
	 * by a statement</li> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public EList<ScheduleTerm> buildAllDependencyTerms(
			List<ScheduleTerm> allocationTerms,
			List<ScheduleTerm> statementTerms) {

		EList<ScheduleTerm> terms = new BasicEList<ScheduleTerm>();

		Map<Variable, IntExpression> subscriptsMap = new HashMap<Variable, IntExpression>();
		subscriptsMap.put(getChannel().getSubscriptDimension(),
				subscript.copy());

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

	@Override
	public Domain getDependencyDomain() {
		return edge.getDomain();
	}

} // MemoryAllocationDependencyImpl
