/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;
import org.polymodel.polyhedralIR.polyIRCG.PseudoProjection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pseudo Projection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.PseudoProjectionImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.PseudoProjectionImpl#getModFactors <em>Mod Factors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PseudoProjectionImpl extends MemoryDomainImpl implements PseudoProjection {
	/**
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected Domain domain;
	/**
	 * The cached value of the '{@link #getModFactors() <em>Mod Factors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModFactors()
	 * @generated
	 * @ordered
	 */
	protected EList<IntExpression> modFactors;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PseudoProjectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyIRCGPackage.Literals.PSEUDO_PROJECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain getDomain() {
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDomain(Domain newDomain, NotificationChain msgs) {
		Domain oldDomain = domain;
		domain = newDomain;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.PSEUDO_PROJECTION__DOMAIN, oldDomain, newDomain);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomain(Domain newDomain) {
		if (newDomain != domain) {
			NotificationChain msgs = null;
			if (domain != null)
				msgs = ((InternalEObject)domain).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolyIRCGPackage.PSEUDO_PROJECTION__DOMAIN, null, msgs);
			if (newDomain != null)
				msgs = ((InternalEObject)newDomain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolyIRCGPackage.PSEUDO_PROJECTION__DOMAIN, null, msgs);
			msgs = basicSetDomain(newDomain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.PSEUDO_PROJECTION__DOMAIN, newDomain, newDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntExpression> getModFactors() {
		if (modFactors == null) {
			modFactors = new EObjectContainmentEList<IntExpression>(IntExpression.class, this, PolyIRCGPackage.PSEUDO_PROJECTION__MOD_FACTORS);
		}
		return modFactors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getDim() {
		return getNParams() + getNIndices();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getNParams() {
		return getParams().size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getNIndices() {
		return getIndices().size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Variable> getParams() {
		return getDomain().getParams();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Variable> getIndices() {
		return getDomain().getIndices();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<IntExpression> getBounds(int dim) {
		//If mod factor is in effect for this dimension
		if (isModFactorInEffect(dim)) {
			EList<IntExpression> outputs = new BasicEList<IntExpression>();
			//LB is zero
			outputs.add(IntExpressionBuilder.constant(0));
			//UB is the mod factor - 1
			outputs.add(IntExpressionBuilder.sub(getModFactors().get(dim).copy(), IntExpressionBuilder.constant(1)));
			return outputs;
		}
		
		//When modFactor is not given or 0, then compute the bounds from domain
		return getDomain().getBounds(dim);
	}
	
	@Override
	public boolean isModFactorInEffect() {
		for (int i = 0; i < getModFactors().size(); i++) {
			if (isModFactorInEffect(i)) return true;
 		}
		return false;
	}

	/**
	 * Method to check if mod factor is used in the specified dimension
	 * 
	 * @param dim
	 * @return
	 */
	public boolean isModFactorInEffect(int dim) {
		//If mod factor exists for this dimension
		if (getModFactors().size() > dim && getModFactors().get(dim) != null) {
			//And if its not zero
			IntExpression expr = getModFactors().get(dim).copy().simplify();
			
			try {
				AffineExpression affine = expr.toAffine();
				if (affine.getTerms().size() == 1) {
					AffineTerm term = affine.getTerms().get(0);
					if (term.getVariable() == null && term.getCoef() == 0) {
						return false;
					}
				}
			//may not be affine
			} catch (Exception e) {
				//TODO what should be done if the expr is not affine.
				// I'm throwing an exception until we find what to do
				throw new RuntimeException(e);
			}
			
			return true;
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IntExpression getIndexingExpression(int dim) {
		IntExpression term = IntExpressionBuilder.affine(IntExpressionBuilder.term(getIndices().get(dim)));
		if (isModFactorInEffect(dim)) {
			//IntegerExpressionUserFactory.mod(a, scale);
			return term;
			//TODO IntegerLinearAlgebra does not handle this yet
			//return IntegerExpressionUserFactory.mod(t, scale);
		} else {
			return term;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolyIRCGPackage.PSEUDO_PROJECTION__DOMAIN:
				return basicSetDomain(null, msgs);
			case PolyIRCGPackage.PSEUDO_PROJECTION__MOD_FACTORS:
				return ((InternalEList<?>)getModFactors()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PolyIRCGPackage.PSEUDO_PROJECTION__DOMAIN:
				return getDomain();
			case PolyIRCGPackage.PSEUDO_PROJECTION__MOD_FACTORS:
				return getModFactors();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PolyIRCGPackage.PSEUDO_PROJECTION__DOMAIN:
				setDomain((Domain)newValue);
				return;
			case PolyIRCGPackage.PSEUDO_PROJECTION__MOD_FACTORS:
				getModFactors().clear();
				getModFactors().addAll((Collection<? extends IntExpression>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PolyIRCGPackage.PSEUDO_PROJECTION__DOMAIN:
				setDomain((Domain)null);
				return;
			case PolyIRCGPackage.PSEUDO_PROJECTION__MOD_FACTORS:
				getModFactors().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PolyIRCGPackage.PSEUDO_PROJECTION__DOMAIN:
				return domain != null;
			case PolyIRCGPackage.PSEUDO_PROJECTION__MOD_FACTORS:
				return modFactors != null && !modFactors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PseudoProjectionImpl
