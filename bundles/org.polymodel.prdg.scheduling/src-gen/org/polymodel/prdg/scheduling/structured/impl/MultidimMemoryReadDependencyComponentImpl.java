/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.scheduling.structured.impl;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraintSystem;
import static org.polymodel.algebra.factory.IntExpressionBuilder.gt;
import static org.polymodel.algebra.factory.IntExpressionBuilder.lt;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polymodel.Domain;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.prdg.scheduling.ScheduleTerm;
import org.polymodel.prdg.scheduling.structured.BoundingCoefficient;
import org.polymodel.prdg.scheduling.structured.MultidimMemoryReadDependencyComponent;
import org.polymodel.prdg.scheduling.structured.StructuredPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Multidim Memory Read Dependency Component</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.polymodel.prdg.scheduling.structured.impl.MultidimMemoryReadDependencyComponentImpl#getDimension
 * <em>Dimension</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MultidimMemoryReadDependencyComponentImpl extends
		MemoryReadDependencyImpl implements
		MultidimMemoryReadDependencyComponent {
	/**
	 * The default value of the '{@link #getDimension() <em>Dimension</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDimension()
	 * @generated
	 * @ordered
	 */
	protected static final int DIMENSION_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getDimension() <em>Dimension</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDimension()
	 * @generated
	 * @ordered
	 */
	protected int dimension = DIMENSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MultidimMemoryReadDependencyComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructuredPackage.Literals.MULTIDIM_MEMORY_READ_DEPENDENCY_COMPONENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getDimension() {
		return dimension;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDimension(int newDimension) {
		int oldDimension = dimension;
		dimension = newDimension;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StructuredPackage.MULTIDIM_MEMORY_READ_DEPENDENCY_COMPONENT__DIMENSION, oldDimension, dimension));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StructuredPackage.MULTIDIM_MEMORY_READ_DEPENDENCY_COMPONENT__DIMENSION:
				return getDimension();
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
			case StructuredPackage.MULTIDIM_MEMORY_READ_DEPENDENCY_COMPONENT__DIMENSION:
				setDimension((Integer)newValue);
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
			case StructuredPackage.MULTIDIM_MEMORY_READ_DEPENDENCY_COMPONENT__DIMENSION:
				setDimension(DIMENSION_EDEFAULT);
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
			case StructuredPackage.MULTIDIM_MEMORY_READ_DEPENDENCY_COMPONENT__DIMENSION:
				return dimension != DIMENSION_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (dimension: ");
		result.append(dimension);
		result.append(')');
		return result.toString();
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
			Variable boundingCoefficient;
			boundingCoefficient = getChannel().getBoundingCoefficient(i,
					dimension);

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

	public Domain getDependencyDomain() {
		if (dependencyDomain == null) {
			dependencyDomain = factory.createDomain(new ArrayList<Variable>(),
					constraintSystem());
			Domain refDomain = getReference().getDomain();

			for (int i = 0; i < refDomain.getNbIndices(); i++) {
				BoundingCoefficient boundingCoefficient = getChannel()
						.getBoundingCoefficient(i, dimension);
				dependencyDomain.getDimensions().getIndices()
						.add(boundingCoefficient);
				long max = getDimensionSizes().get(i);
				dependencyDomain.addConstraint(gt(
						affine(term(boundingCoefficient)), affine(term(-max))));
				dependencyDomain.addConstraint(lt(
						affine(term(boundingCoefficient)), affine(term(max))));
			}
		}
		return dependencyDomain.simplify();
	}
} // MultidimMemoryReadDependencyComponentImpl
