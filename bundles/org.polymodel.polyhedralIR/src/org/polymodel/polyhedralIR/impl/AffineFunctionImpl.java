/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.DimensionsManager;
import org.polymodel.Function;
import org.polymodel.IndexDimension;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.PolyhedralIRFactory;
import org.polymodel.polyhedralIR.PolyhedralIRPackage;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.factory.PolyhedralIRModule;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;
import org.polymodel.util.PolymodelException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Affine Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.impl.AffineFunctionImpl#getPMmapping <em>PMmapping</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AffineFunctionImpl extends EObjectImpl implements AffineFunction {
	/**
	 * The cached value of the '{@link #getPMmapping() <em>PMmapping</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPMmapping()
	 * @generated
	 * @ordered
	 */
	protected Function pMmapping;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AffineFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyhedralIRPackage.eINSTANCE.getAffineFunction();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getPMmapping() {
		return pMmapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPMmapping(Function newPMmapping, NotificationChain msgs) {
		Function oldPMmapping = pMmapping;
		pMmapping = newPMmapping;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.AFFINE_FUNCTION__PMMAPPING, oldPMmapping, newPMmapping);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPMmapping(Function newPMmapping) {
		if (newPMmapping != pMmapping) {
			NotificationChain msgs = null;
			if (pMmapping != null)
				msgs = ((InternalEObject)pMmapping).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolyhedralIRPackage.AFFINE_FUNCTION__PMMAPPING, null, msgs);
			if (newPMmapping != null)
				msgs = ((InternalEObject)newPMmapping).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolyhedralIRPackage.AFFINE_FUNCTION__PMMAPPING, null, msgs);
			msgs = basicSetPMmapping(newPMmapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.AFFINE_FUNCTION__PMMAPPING, newPMmapping, newPMmapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean equivalence(AffineFunction func) {
		return getPMmapping().equivalence(func.getPMmapping());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AffineFunction compose(AffineFunction f2) {
		AffineFunction newFunc = PolyhedralIRFactory.eINSTANCE.createAffineFunction();
		newFunc.setPMmapping(this.getPMmapping().compose(f2.getPMmapping()));
		return newFunc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Variable> getParams() {
		return getPMmapping().getDimensions().getParameters();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Variable> getIndices() {
		return getPMmapping().getDimensions().getIndices();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getDimLHS() {
		return getParams().size() + getIndices().size(); 
	}
	
	@Override
	public EList<String> getParamNames() {
		EList<String> names = new BasicEList<String>();
		for (Variable iv : getParams()) {
			names.add(iv.getName());
		}
		return names;
	}

	@Override
	public EList<String> getIndexNames() {
		EList<String> names = new BasicEList<String>();
		for (Variable iv : getIndices()) {
			names.add(iv.getName());
		}
		return names;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getDimRHS() {
		return getPMmapping().getExpressionsMap().size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<AffineExpression> getExpressions() {
		EList<IntExpression> exprs = getPMmapping().getExpressions();
		EList<AffineExpression> affineExprs = new BasicEList<AffineExpression>(exprs.size());
		
		for (IntExpression expr: exprs) {
			affineExprs.add((AffineExpression) expr.toAffine().simplify());
		}
		
		return affineExprs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AffineFunction copy() {
		return PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(getParams(), getIndices(), getExpressions());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AffineFunction inverse() throws PolymodelException {
		return inverseInContext(null, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AffineFunction inverse(EList<String> names) throws PolymodelException {
		return inverseInContext(null, names);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AffineFunction inverseInContext(Domain context, EList<String> names) throws PolymodelException {
		//avoid errors later in the chain
		if (getDimLHS() - this.getParams().size() == 0 && getDimRHS() == 0) {
			return this.copy();
		}
		
		DimensionsManager manager = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
		
		Function inverse;
		if (context != null) {
			inverse = getPMmapping().inverseInContext(manager, context.getPMdomain(), names);
		} else {
			inverse = getPMmapping().inverseInContext(manager, null, names);
		}
		
		return PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(inverse);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isUniform() {
		if (getDimLHS() - getParams().size() != getDimRHS()) {
			return false;
		}
		
		//implemented in 5min. probably not very robust
		for (int i = 0; i < getDimRHS(); i++) {
			Variable iv = getIndices().get(i);
			//check that index dimension is correct
			if (iv instanceof IndexDimension) {
				if (((IndexDimension)iv).getDimension() != i) {
					throw new RuntimeException("Assumes indices are ordered.");
				}
			}
			//the expression should be affine
			AffineExpression ie = getExpressions().get(i).copy().toAffine();
			
			boolean found = false;
			for (AffineTerm term : ie.getTerms()) {
				if (term.getVariable() != null) {
					if ( term.getVariable().equals(iv)) {
						found = true;
					} else if (term.getCoef() != 0) {
						return false;
					}
				}
			}

			//var must be used once
			if (!found) return false;
		}
		return true;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isBijective() {
		DimensionsManager manager = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
		return getPMmapping().buildRelation(manager).isBijective();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isIdentity() {
		AffineFunction identity = PolyhedralIRUtility.createIdentityFunction(getParams(), getIndices());
		return identity.equivalence(this);
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

	@Override
	public EList<Integer> getConstantPart() {
		EList<Integer> constants = new BasicEList<Integer>();
		for (int i = 0; i < getDimRHS(); i++) {
			constants.add(0);
		}
		
		int d = 0;
		for (AffineExpression ile : getExpressions()) {
			for (AffineTerm term : ile.getTerms()) {
				if (term.getVariable() == null) {
					constants.set(d, (int)(constants.get(d) + term.getCoef()));
				}
			}
			d++;
		}
		
		return constants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitAffineFunction(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolyhedralIRPackage.AFFINE_FUNCTION__PMMAPPING:
				return basicSetPMmapping(null, msgs);
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
			case PolyhedralIRPackage.AFFINE_FUNCTION__PMMAPPING:
				return getPMmapping();
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
			case PolyhedralIRPackage.AFFINE_FUNCTION__PMMAPPING:
				setPMmapping((Function)newValue);
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
			case PolyhedralIRPackage.AFFINE_FUNCTION__PMMAPPING:
				setPMmapping((Function)null);
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
			case PolyhedralIRPackage.AFFINE_FUNCTION__PMMAPPING:
				return pMmapping != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public void addParameterDimension(String name) {
		DimensionsManager manager = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
		Variable newParam = manager.getParameter(this.getParams().size(), name);
		
		getPMmapping().getDimensions().getParameters().add(newParam);
		
	}
	@Override
	public void addDimension(String name) {
		DimensionsManager manager = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
		Variable newDim = manager.getDimension(this.getIndices().size(), name);
		
		getPMmapping().getDimensions().getIndices().add(newDim);
		
	}
	
	/**
	 * @generated NOT
	 */
	@Override 
	public String toString() {
		return PolyhedralIRToAlphabets.toString(this);
	}

} //AffineFunctionImpl
