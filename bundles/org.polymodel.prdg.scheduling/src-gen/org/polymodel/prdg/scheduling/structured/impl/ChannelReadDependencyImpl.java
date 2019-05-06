/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured.impl;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polymodel.Domain;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.scheduling.ScheduleTerm;
import org.polymodel.prdg.scheduling.StatementSchedulePrototype;
import org.polymodel.prdg.scheduling.structured.ChannelReadDependency;
import org.polymodel.prdg.scheduling.structured.ChannelSchedulePrototype;
import org.polymodel.prdg.scheduling.structured.StructuredPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Channel Read Dependency</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.prdg.scheduling.structured.impl.ChannelReadDependencyImpl#getEdge <em>Edge</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChannelReadDependencyImpl extends ChannelDependencyImpl implements
		ChannelReadDependency {
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
	protected ChannelReadDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructuredPackage.Literals.CHANNEL_READ_DEPENDENCY;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StructuredPackage.CHANNEL_READ_DEPENDENCY__EDGE, oldEdge, edge));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StructuredPackage.CHANNEL_READ_DEPENDENCY__EDGE, oldEdge, edge));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StructuredPackage.CHANNEL_READ_DEPENDENCY__EDGE:
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
			case StructuredPackage.CHANNEL_READ_DEPENDENCY__EDGE:
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
			case StructuredPackage.CHANNEL_READ_DEPENDENCY__EDGE:
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
			case StructuredPackage.CHANNEL_READ_DEPENDENCY__EDGE:
				return edge != null;
		}
		return super.eIsSet(featureID);
	}

	private Domain domain;
	@Override
	public Domain getDependencyDomain() {
		if(domain==null){
			domain = edge.getDomain().intersection(edge.getDestination().getDomain());
		}
		return domain;
	}

	@Override
	public StatementSchedulePrototype getReference() {
		return (StatementSchedulePrototype) super.getReference();
	}

	@Override
	public ChannelSchedulePrototype getSource() {
		return (ChannelSchedulePrototype) super.getSource();
	}

	@Override
	public ScheduleTerm getCausalityTerm() {
		return schedulingConcreteFactory
				.createScheduleConstantTerm(affine(term(-1)));
	}

	public EList<ScheduleTerm> buildAllDependencyTerms(
			List<ScheduleTerm> sourceTerms, List<ScheduleTerm> referenceTerms) {

		EList<ScheduleTerm> terms = new BasicEList<ScheduleTerm>();

		// Add distributed read statement terms
		for (ScheduleTerm aterm : referenceTerms) {
			terms.addAll(aterm.distribute());
		}

		// Apply the edge function
		Map<Variable, IntExpression> subscriptsMap = new HashMap<Variable, IntExpression>();
		Domain refDomain = getReference().getDomain();
		for (int i = 0; i < refDomain.getNbIndices(); i++) {
			Variable dim = refDomain.getDimensions().getIndices().get(i);
			AffineExpression expression = getEdge().getFunction().getMapping()
					.getExpression(i).copy().toAffine();
			subscriptsMap.put(dim, expression);
		}

		for (ScheduleTerm sterm : sourceTerms) {
			ScheduleTerm negatedTerm = sterm.negate().apply(subscriptsMap);
			terms.addAll(negatedTerm.distribute());
		}
		return terms;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getEdge().getSource().getName());
		sb.append("->");
		sb.append(getEdge().getDestination().getName());

		sb.append("(Channel ").append("Read").append(")");
		return sb.toString();
	}
} // ChannelReadDependencyImpl
