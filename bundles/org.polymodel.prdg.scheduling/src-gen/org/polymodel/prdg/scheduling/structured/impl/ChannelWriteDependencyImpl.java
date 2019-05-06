/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured.impl;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.polymodel.Domain;
import org.polymodel.prdg.scheduling.ScheduleTerm;
import org.polymodel.prdg.scheduling.StatementSchedulePrototype;
import org.polymodel.prdg.scheduling.structured.ChannelSchedulePrototype;
import org.polymodel.prdg.scheduling.structured.ChannelWriteDependency;
import org.polymodel.prdg.scheduling.structured.StructuredPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Channel Write Dependency</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ChannelWriteDependencyImpl extends ChannelDependencyImpl implements
		ChannelWriteDependency {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ChannelWriteDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructuredPackage.Literals.CHANNEL_WRITE_DEPENDENCY;
	}

	@Override
	public ChannelSchedulePrototype getReference() {
		return (ChannelSchedulePrototype) super.getReference();
	}

	@Override
	public StatementSchedulePrototype getSource() {
		return (StatementSchedulePrototype) super.getSource();
	}

	@Override
	public Domain getDependencyDomain() {
		return getSource().getDomain();
	}

	
	@Override
	public ScheduleTerm getCausalityTerm() {
		return schedulingConcreteFactory
				.createScheduleConstantTerm(affine(term(0)));
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getSource().getName());
		sb.append("(Channel ").append("Write ").append(")");
		return sb.toString();
	}


	public EList<ScheduleTerm> buildAllDependencyTerms(
			List<ScheduleTerm> sourceTerms, List<ScheduleTerm> referenceTerms) {

		EList<ScheduleTerm> terms = new BasicEList<ScheduleTerm>();

		// Add distributed read statement terms
		for (ScheduleTerm aterm : referenceTerms) {
			terms.addAll(aterm.distribute());
		}

		// Add negation of applied distributed channel terms
	
		for (ScheduleTerm sterm : sourceTerms) {
			ScheduleTerm negatedTerm = sterm.negate();
			terms.addAll(negatedTerm.distribute());
		}
		return terms;
	}
	
} // ChannelWriteDependencyImpl
