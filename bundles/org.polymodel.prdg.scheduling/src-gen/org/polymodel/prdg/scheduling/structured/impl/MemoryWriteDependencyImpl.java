/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured.impl;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.ge;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.Variable;
import org.polymodel.prdg.scheduling.ScheduleTerm;
import org.polymodel.prdg.scheduling.structured.BoundedChannel;
import org.polymodel.prdg.scheduling.structured.MemoryDependency;
import org.polymodel.prdg.scheduling.structured.MemoryWriteDependency;
import org.polymodel.prdg.scheduling.structured.StructuredPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Memory Write Dependency</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class MemoryWriteDependencyImpl extends ChannelWriteDependencyImpl
		implements MemoryWriteDependency {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MemoryWriteDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructuredPackage.Literals.MEMORY_WRITE_DEPENDENCY;
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == MemoryDependency.class) {
			switch (baseOperationID) {
				case StructuredPackage.MEMORY_DEPENDENCY___GET_CHANNEL: return StructuredPackage.MEMORY_WRITE_DEPENDENCY___GET_CHANNEL;
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
			case StructuredPackage.MEMORY_WRITE_DEPENDENCY___GET_CHANNEL:
				return getChannel();
		}
		return super.eInvoke(operationID, arguments);
	}

	@Override
	public ScheduleTerm getCausalityTerm() {
		return schedulingConcreteFactory
				.createScheduleConstantTerm(affine(term(0)));
	}

	/**
	 * Allocation coefficients are greater than zero
	 */
	@Override
	public EList<IntConstraint> getCoefficientsContext() {
		EList<IntConstraint> context = new BasicEList<IntConstraint>();
		for (Variable v : getReference().getCoeficients()) {
			context.add(ge(affine(term(v)), affine(term(0))));
		}
		return context;
	}
	
	/**
	 * <!-- begin-user-doc --> Build the terms of: <br>
	 * <br>
	 * <i>Theta(Statement)-Theta(allocation,f(A,i)) >=0</i> <br>
	 * <br>
	 * Where: <li><i>Theta(allocation,f(A,i))</i>: is the date where the data
	 * i is allocated</li> <li><i>Theta(Statement)</i>: is the date where the
	 * data i is produced by a statement</li> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public EList<ScheduleTerm> buildAllDependencyTerms(
			List<ScheduleTerm> statementTerms,
			List<ScheduleTerm> allocationTerms) {
		EList<ScheduleTerm> terms = new BasicEList<ScheduleTerm>();

		
		// Add distributed statements terms
		for (ScheduleTerm sterm : statementTerms) {
			terms.addAll(sterm.distribute());
		}

		// Add negated distributed allocation, terms
		for (ScheduleTerm aterm : allocationTerms) {
			ScheduleTerm applied = aterm.negate();
			terms.addAll(applied.distribute());
		}
		return terms;
	}

	

} // MemoryWriteDependencyImpl
