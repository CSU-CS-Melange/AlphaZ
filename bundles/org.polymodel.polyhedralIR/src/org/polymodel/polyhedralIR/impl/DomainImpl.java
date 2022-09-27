/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.impl;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.AbstractRelation;
import org.polymodel.DimensionsManager;
import org.polymodel.DomainDimensions;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.reductions.ReductionExpression;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.isl.ISLSet;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.PolyhedralIRFactory;
import org.polymodel.polyhedralIR.PolyhedralIRPackage;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.factory.PolyhedralIRModule;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.impl.DomainImpl#getPMdomain <em>PMdomain</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DomainImpl extends EObjectImpl implements Domain {
	/**
	 * The cached value of the '{@link #getPMdomain() <em>PMdomain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPMdomain()
	 * @generated
	 * @ordered
	 */
	protected org.polymodel.Domain pMdomain;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyhedralIRPackage.eINSTANCE.getDomain();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.polymodel.Domain getPMdomain() {
		return pMdomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPMdomain(org.polymodel.Domain newPMdomain, NotificationChain msgs) {
		org.polymodel.Domain oldPMdomain = pMdomain;
		pMdomain = newPMdomain;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.DOMAIN__PMDOMAIN, oldPMdomain, newPMdomain);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPMdomain(org.polymodel.Domain newPMdomain) {
		if (newPMdomain != pMdomain) {
			NotificationChain msgs = null;
			if (pMdomain != null)
				msgs = ((InternalEObject)pMdomain).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolyhedralIRPackage.DOMAIN__PMDOMAIN, null, msgs);
			if (newPMdomain != null)
				msgs = ((InternalEObject)newPMdomain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolyhedralIRPackage.DOMAIN__PMDOMAIN, null, msgs);
			msgs = basicSetPMdomain(newPMdomain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.DOMAIN__PMDOMAIN, newPMdomain, newPMdomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Domain union(Domain domain) {
		Domain newDomain = PolyhedralIRFactory.eINSTANCE.createDomain();
		org.polymodel.Domain dom = this.getPMdomain().union(domain.getPMdomain());
		newDomain.setPMdomain(dom);
		assert(newDomain.getPMdomain() != null);
		return newDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Domain intersection(Domain domain) {
		Domain newDomain = PolyhedralIRFactory.eINSTANCE.createDomain();
		/*try {
			org.polymodel.Domain x = this.getPMdomain();
			org.polymodel.Domain y = domain.getPMdomain();
			org.polymodel.Domain z = x.intersection(y);
		} catch (Exception e) {}*/
		newDomain.setPMdomain(this.getPMdomain().intersection(domain.getPMdomain()));
		assert(newDomain.getPMdomain() != null);
		return newDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Domain difference(Domain domain) {
		Domain newDomain = PolyhedralIRFactory.eINSTANCE.createDomain();
		newDomain.setPMdomain(this.getPMdomain().difference(domain.getPMdomain()));
		assert(newDomain.getPMdomain() != null);
		return newDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean equivalence(Domain domain) {
		return this.getPMdomain().equivalence(domain.getPMdomain());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isUniverse() {
		return this.getPMdomain().isUniverse();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isEmpty() {
		return this.getPMdomain().isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Domain image(AffineFunction T) {
		
		Domain newDomain = PolyhedralIRFactory.eINSTANCE.createDomain();
		DimensionsManager manager = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
		
		// TODO: quick fix for the bug inside image
		if (T.getExpressions().size()==0) {
			if (this.isEmpty())
				newDomain.setPMdomain(PolyhedralIRUtility.parseDomain(this.getParamNames(), "{|1=0}").getPMdomain());
			else
				newDomain.setPMdomain(PolyhedralIRUtility.parseDomain(this.getParamNames(), "{|}").getPMdomain());
			return newDomain;
		}
		
		newDomain.setPMdomain(this.getPMdomain().image(T.getPMmapping().buildRelation(manager)));
		assert(newDomain.getPMdomain() != null);
		return newDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Domain preimage(AffineFunction T) {
		Domain newDomain = PolyhedralIRFactory.eINSTANCE.createDomain();
		DimensionsManager manager = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
		
		newDomain.setPMdomain(this.getPMdomain().image(T.getPMmapping().buildRelation(manager).reverse(PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE))));
		assert(newDomain.getPMdomain() != null);
		return newDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Variable> getParams() {
		return this.getPMdomain().getDimensions().getParameters();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Variable> getIndices() {
		return this.getPMdomain().getDimensions().getIndices();
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
	public Domain contextDomain() {
		Domain newDomain = PolyhedralIRFactory.eINSTANCE.createDomain();
		newDomain.setPMdomain(this.getPMdomain());
		return newDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitDomain(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Domain transitiveClosure(AffineFunction f, Domain range) {
		return transitiveClosure(f, range, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Domain exactTransitiveClosure(AffineFunction f, Domain range) {
		return transitiveClosure(f, range, true);
	}

	private Domain transitiveClosure(AffineFunction f, Domain range, boolean exact) {
		DimensionsManager manager = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
		AbstractRelation rel = f.getPMmapping().buildRelation(manager).intersectDomain(getPMdomain()).intersectRange(range.getPMdomain());
		
		AbstractRelation closure;
		if (exact) {
			closure = rel.exactTransitiveClosure();
		} else {
			closure = rel.transitiveClosure();
		}
		
		return PolyhedralIRUserFactory.eINSTANCE.createDomain(closure.getRange());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolyhedralIRPackage.DOMAIN__PMDOMAIN:
				return basicSetPMdomain(null, msgs);
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
			case PolyhedralIRPackage.DOMAIN__PMDOMAIN:
				return getPMdomain();
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
			case PolyhedralIRPackage.DOMAIN__PMDOMAIN:
				setPMdomain((org.polymodel.Domain)newValue);
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
			case PolyhedralIRPackage.DOMAIN__PMDOMAIN:
				setPMdomain((org.polymodel.Domain)null);
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
			case PolyhedralIRPackage.DOMAIN__PMDOMAIN:
				return pMdomain != null;
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return PolyhedralIRToAlphabets.toString(this);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected String toStringList(List<?> list, char separator ) {
		StringBuffer buff = new StringBuffer();
		if(list==null) return "";
		boolean first =true;
		for (Object obj : list) {
			if (first) {
				first =false;
				buff.append(obj.toString());
			} else {
				buff.append(separator+obj.toString());
				
			}
		}
		return buff.toString();
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getDim() {
		return getParams().size() + getIndices().size();
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
	public void addDimension(String name) {
		DomainDimensions dims = getPMdomain().getDimensions();
		DimensionsManager manager = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
		
		dims.getIndices().add(manager.getDimension(dims.getIndices().size(), name));
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void addParameterDimension(String name) {
		DomainDimensions dims = getPMdomain().getDimensions();
		DimensionsManager manager = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
		dims.getParameters().add(manager.getParameter(dims.getParameters().size(), name));
//		List<List<String>> constraints = new LinkedList<List<String>>();
//		//Extract constraints on the current domain
//		//domain may be unions of polyhedron
//		for (IntConstraintSystem ilcs : getPMdomain().getPolyhedra()) {
//			List<String> pconsts = new LinkedList<String>();
//			for (IntLinearConstraint ilc : ilcs.getLinearConstraints()) {
//				pconsts.add(ilc.toString());
//			}
//			constraints.add(pconsts);
//		}
//		//Create the list of parameter indices and add the new one as well
//		List<String> params = new LinkedList<String>();
//		for (Variable iv : getParams()) {
//			params.add(iv.toString());
//		}
//		params.add(name);
//		
//		//List of indices
//		List<String> ids = new LinkedList<String>();
//		for (Variable iv : getIndices()) {
//			ids.add(iv.toString());
//		}
//		
//		//Need list of id lists for union
//		List<List<String>> idslist = new LinkedList<List<String>>();
//		for (int i = 0; i < constraints.size(); i++) {
//			idslist.add(ids);
//		}
//		
//		//Create parameter domain with no constraints, but with additional dimension
//		ParameterDomain newParam = PolyhedralIRUserFactory.eINSTANCE.createParameterDomain(params, new LinkedList<String>());
//		//Create a new domain and take its PMdomain
//		Domain newDomain = PolyhedralIRUserFactory.eINSTANCE.createDomainUnion(newParam, idslist, constraints);
//		setPMdomain(newDomain.getPMdomain());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void simplify() {
		this.setPMdomain(this.getPMdomain().simplify());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void simplifyInContext(Domain context) {
		if (this.getPMdomain() instanceof ISLSet && context.getPMdomain() instanceof ISLSet) {
			this.setPMdomain(((ISLSet)getPMdomain()).simplify(context.getPMdomain()));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Domain boundingBox() {
		Domain newDomain = PolyhedralIRFactory.eINSTANCE.createDomain();
		newDomain.setPMdomain(this.getPMdomain().boundingBox());
		return newDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Domain affineHull() {
		return PolyhedralIRUserFactory.eINSTANCE.createDomain(getPMdomain().affineHull());
	}
	
	public Domain polyhedralHull(){
		return PolyhedralIRUserFactory.eINSTANCE.createDomain(getPMdomain().polyhedralHull());
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<IntExpression> getBounds(int dim) {
		
		if (getIndices().size() < dim) {
			throw new RuntimeException("Cannot take projection of " + this + " to " + dim + "th dimension.");
		}
		
		//Take projection to the specified domain
		List<String> projExpr = new LinkedList<String>();
		projExpr.add(getIndices().get(dim).toString());
		AffineFunction projection = PolyhedralIRUtility.parseAffineFunction(getParams(), getIndices(), projExpr);
		Domain projDom = image(projection);

		//The only index left is the target
		Variable target = projDom.getIndices().get(0);

		List<IntExpression> lbs = new LinkedList<IntExpression>();
		List<IntExpression> ubs = new LinkedList<IntExpression>();

		//Iterate over all systems and collect bounds
		for (IntConstraintSystem ics : projDom.getPMdomain().getPolyhedra()) {
			IntExpression lb = ics.getLB(target);
			IntExpression ub = ics.getUB(target);
			if (lb == null || ub == null) {
				throw new RuntimeException("Infinite image is not allowed.");
			}
			lbs.add(lb);
			ubs.add(ub);
		}

		
		IntExpression lb = lbs.get(0);
		IntExpression ub = ubs.get(0);
		
		//If multiple lbs exist, take min;
		if (lbs.size() > 1) {
			ReductionExpression lmin = IntExpressionBuilder.min();
			for (IntExpression l : lbs) {
				lmin.getExpressions().add(l);
			}
			lb = lmin;
		}
		//If multiple ubs exist, take max;
		if (ubs.size() > 1) {
			ReductionExpression umax = IntExpressionBuilder.max();
			for (IntExpression u : ubs) {
				umax.getExpressions().add(u);
			}
			ub = umax;
		}
		
		EList<IntExpression> outputs = new BasicEList<IntExpression>();

		outputs.add(lb.simplify());
		outputs.add(ub.simplify());

		return outputs;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IntExpression getLowerBound(int dim) {
		
		if (getIndices().size() < dim) {
			throw new RuntimeException("Cannot take projection of " + this + " to " + dim + "th dimension.");
		}
		
		//Take projection to the specified domain
		List<String> projExpr = new LinkedList<String>();
		projExpr.add(getIndices().get(dim).toString());
		AffineFunction projection = PolyhedralIRUtility.parseAffineFunction(getParams(), getIndices(), projExpr);
		Domain projDom = image(projection);

		//The only index left is the target
		Variable target = projDom.getIndices().get(0);

		List<IntExpression> lbs = new LinkedList<IntExpression>();

		//Iterate over all systems and collect bounds
		for (IntConstraintSystem ics : projDom.getPMdomain().getPolyhedra()) {
			IntExpression lb = ics.getLB(target);
			if (lb == null) {
				throw new RuntimeException("Infinite image is not allowed.");
			}
			lbs.add(lb);
		}

		
		IntExpression lb = lbs.get(0);
		
		//If multiple lbs exist, take min;
		if (lbs.size() > 1) {
			ReductionExpression lmin = IntExpressionBuilder.min();
			for (IntExpression l : lbs) {
				lmin.getExpressions().add(l);
			}
			lb = lmin;
		}
		
		return lb.simplify();
	}

	@Override
	public Domain copy() {
		return PolyhedralIRUtility.parseDomain(this.getParamNames(), PolyhedralIRToAlphabets.toString(this));
//		return EcoreUtil.copy(this);
//		return PolyhedralIRUserFactory.eINSTANCE.createDomain(getParams(), getIndices(), getPMdomain());
	}

	@Override
	public ParameterDomain toParameterDomain() {
		return PolyhedralIRUserFactory.eINSTANCE.createParameterDomain(PolyhedralIRUtility.toParameters(getPMdomain()));
	}


} //DomainImpl
