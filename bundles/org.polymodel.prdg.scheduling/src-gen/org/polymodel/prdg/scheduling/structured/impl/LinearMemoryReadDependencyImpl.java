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
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.prdg.scheduling.ScheduleTerm;
import org.polymodel.prdg.scheduling.structured.BoundedChannel;
import org.polymodel.prdg.scheduling.structured.LinearMemoryReadDependency;
import org.polymodel.prdg.scheduling.structured.MemoryDependency;
import org.polymodel.prdg.scheduling.structured.StructuredPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Bounded Read Dependency</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class LinearMemoryReadDependencyImpl extends ChannelLinearReadDependencyImpl
		implements LinearMemoryReadDependency {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected LinearMemoryReadDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructuredPackage.Literals.LINEAR_MEMORY_READ_DEPENDENCY;
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
				case StructuredPackage.MEMORY_DEPENDENCY___GET_CHANNEL: return StructuredPackage.LINEAR_MEMORY_READ_DEPENDENCY___GET_CHANNEL;
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
			case StructuredPackage.LINEAR_MEMORY_READ_DEPENDENCY___GET_CHANNEL:
				return getChannel();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> Build the terms of: <br>
	 * <br>
	 * <i>Theta(allocation,f(A,i) +B) + 1 - Theta(Reference) >=0</i> <br>
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

		// Add the size of channel to the allocation date = deallocation date of
		// the data
		Map<Variable, IntExpression> subscriptsMap = new HashMap<Variable, IntExpression>();
		subscriptsMap.put(
				getChannel().getSubscriptDimension(),
				IntExpressionBuilder.add(getChannel().getMaximalChannelSize(),
						subscript.copy()).toAffine());
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

	@Override
	public ScheduleTerm getCausalityTerm() {
		return schedulingConcreteFactory
				.createScheduleConstantTerm(affine(term(getAllocationDelay())));
	}

	protected int getAllocationDelay() {
		return 1;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getEdge().getSource().getName());
		sb.append("->");
		sb.append(getEdge().getDestination().getName());
		
		sb.append("(Channel ").append("Read, size").append(getChannel().getMaximalChannelSize()).append(")");
		return sb.toString();
	}
} // BoundedReadDependencyImpl
