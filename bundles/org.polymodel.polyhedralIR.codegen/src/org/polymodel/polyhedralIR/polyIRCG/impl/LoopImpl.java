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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.Loop;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;
import org.polymodel.polyhedralIR.polyIRCG.Statement;
import org.polymodel.polyhedralIR.polyIRCG.generator.ScopGenerator;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.util.ScopLoopIteratorUtil;

import fr.irisa.cairn.jnimap.cloog.util.CloogOptionSpecifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.LoopImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.LoopImpl#getParameterDomain <em>Parameter Domain</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.LoopImpl#getStatements <em>Statements</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.LoopImpl#isDeclareIterators <em>Declare Iterators</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.LoopImpl#getIteratorNames <em>Iterator Names</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.LoopImpl#getNumConstantDimensions <em>Num Constant Dimensions</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class LoopImpl extends EObjectImpl implements Loop {
	/**
	 * The cached value of the '{@link #getParameterDomain() <em>Parameter Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterDomain()
	 * @generated
	 * @ordered
	 */
	protected ParameterDomain parameterDomain;

	/**
	 * The cached value of the '{@link #getStatements() <em>Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<Statement> statements;

	/**
	 * The default value of the '{@link #isDeclareIterators() <em>Declare Iterators</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeclareIterators()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DECLARE_ITERATORS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isDeclareIterators() <em>Declare Iterators</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeclareIterators()
	 * @generated
	 * @ordered
	 */
	protected boolean declareIterators = DECLARE_ITERATORS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIteratorNames() <em>Iterator Names</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIteratorNames()
	 * @generated
	 * @ordered
	 */
	protected EList<String> iteratorNames;

	/**
	 * The default value of the '{@link #getNumConstantDimensions() <em>Num Constant Dimensions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumConstantDimensions()
	 * @generated
	 * @ordered
	 */
	protected static final int NUM_CONSTANT_DIMENSIONS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumConstantDimensions() <em>Num Constant Dimensions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumConstantDimensions()
	 * @generated
	 * @ordered
	 */
	protected int numConstantDimensions = NUM_CONSTANT_DIMENSIONS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyIRCGPackage.Literals.LOOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getFunction() {
		if (eContainerFeatureID() != PolyIRCGPackage.LOOP__FUNCTION) return null;
		return (Function)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFunction(Function newFunction, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFunction, PolyIRCGPackage.LOOP__FUNCTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunction(Function newFunction) {
		if (newFunction != eInternalContainer() || (eContainerFeatureID() != PolyIRCGPackage.LOOP__FUNCTION && newFunction != null)) {
			if (EcoreUtil.isAncestor(this, newFunction))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFunction != null)
				msgs = ((InternalEObject)newFunction).eInverseAdd(this, PolyIRCGPackage.FUNCTION__BODIES, Function.class, msgs);
			msgs = basicSetFunction(newFunction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.LOOP__FUNCTION, newFunction, newFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterDomain getParameterDomain() {
		if (parameterDomain != null && parameterDomain.eIsProxy()) {
			InternalEObject oldParameterDomain = (InternalEObject)parameterDomain;
			parameterDomain = (ParameterDomain)eResolveProxy(oldParameterDomain);
			if (parameterDomain != oldParameterDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PolyIRCGPackage.LOOP__PARAMETER_DOMAIN, oldParameterDomain, parameterDomain));
			}
		}
		return parameterDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterDomain basicGetParameterDomain() {
		return parameterDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterDomain(ParameterDomain newParameterDomain) {
		ParameterDomain oldParameterDomain = parameterDomain;
		parameterDomain = newParameterDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.LOOP__PARAMETER_DOMAIN, oldParameterDomain, parameterDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Statement> getStatements() {
		if (statements == null) {
			statements = new EObjectContainmentWithInverseEList<Statement>(Statement.class, this, PolyIRCGPackage.LOOP__STATEMENTS, PolyIRCGPackage.STATEMENT__CONTAINER_LOOP);
		}
		return statements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDeclareIterators() {
		return declareIterators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclareIterators(boolean newDeclareIterators) {
		boolean oldDeclareIterators = declareIterators;
		declareIterators = newDeclareIterators;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.LOOP__DECLARE_ITERATORS, oldDeclareIterators, declareIterators));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getIteratorNames() {
		if (iteratorNames == null) {
			iteratorNames = new EDataTypeUniqueEList<String>(String.class, this, PolyIRCGPackage.LOOP__ITERATOR_NAMES);
		}
		return iteratorNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Maximum number of dimensions without counting the parameters.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getMaxDimension() {
		int max = 0;
		
		for (Statement stmt : getStatements()) {
			max = Math.max(max, stmt.getDomain().getIndices().size());
		}
		
		return max;
	}

/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ScopRoot generateScop() {
		CloogOptionSpecifier options = CloogOptionSpecifier.getDefault();
		options.backtrack = 1; //turn back track on so that if conditions are moved out of the loop body
		ScopRoot scop = ScopGenerator.generateScop(getParameterDomain(), getIteratorNames(), getStatements(), options);
		
		//match the iterator names with the generated loop
		getIteratorNames().clear();
		getIteratorNames().addAll(ScopLoopIteratorUtil.iteratorNameList(scop));
		
		return scop;
	}

/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumConstantDimensions() {
		return numConstantDimensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumConstantDimensions(int newNumConstantDimensions) {
		int oldNumConstantDimensions = numConstantDimensions;
		numConstantDimensions = newNumConstantDimensions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.LOOP__NUM_CONSTANT_DIMENSIONS, oldNumConstantDimensions, numConstantDimensions));
	}

	//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public EList<String> getIndices() {
//		EList<String> indices = new BasicEList<String>();
//		for (int i = 0; i < getMaxDimension(); i++) {
//			indices.add(this.getLoopIndexPrefix()+(i+1));
//		}
//		return indices;
//	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolyIRCGPackage.LOOP__FUNCTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFunction((Function)otherEnd, msgs);
			case PolyIRCGPackage.LOOP__STATEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStatements()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolyIRCGPackage.LOOP__FUNCTION:
				return basicSetFunction(null, msgs);
			case PolyIRCGPackage.LOOP__STATEMENTS:
				return ((InternalEList<?>)getStatements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case PolyIRCGPackage.LOOP__FUNCTION:
				return eInternalContainer().eInverseRemove(this, PolyIRCGPackage.FUNCTION__BODIES, Function.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PolyIRCGPackage.LOOP__FUNCTION:
				return getFunction();
			case PolyIRCGPackage.LOOP__PARAMETER_DOMAIN:
				if (resolve) return getParameterDomain();
				return basicGetParameterDomain();
			case PolyIRCGPackage.LOOP__STATEMENTS:
				return getStatements();
			case PolyIRCGPackage.LOOP__DECLARE_ITERATORS:
				return isDeclareIterators();
			case PolyIRCGPackage.LOOP__ITERATOR_NAMES:
				return getIteratorNames();
			case PolyIRCGPackage.LOOP__NUM_CONSTANT_DIMENSIONS:
				return getNumConstantDimensions();
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
			case PolyIRCGPackage.LOOP__FUNCTION:
				setFunction((Function)newValue);
				return;
			case PolyIRCGPackage.LOOP__PARAMETER_DOMAIN:
				setParameterDomain((ParameterDomain)newValue);
				return;
			case PolyIRCGPackage.LOOP__STATEMENTS:
				getStatements().clear();
				getStatements().addAll((Collection<? extends Statement>)newValue);
				return;
			case PolyIRCGPackage.LOOP__DECLARE_ITERATORS:
				setDeclareIterators((Boolean)newValue);
				return;
			case PolyIRCGPackage.LOOP__ITERATOR_NAMES:
				getIteratorNames().clear();
				getIteratorNames().addAll((Collection<? extends String>)newValue);
				return;
			case PolyIRCGPackage.LOOP__NUM_CONSTANT_DIMENSIONS:
				setNumConstantDimensions((Integer)newValue);
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
			case PolyIRCGPackage.LOOP__FUNCTION:
				setFunction((Function)null);
				return;
			case PolyIRCGPackage.LOOP__PARAMETER_DOMAIN:
				setParameterDomain((ParameterDomain)null);
				return;
			case PolyIRCGPackage.LOOP__STATEMENTS:
				getStatements().clear();
				return;
			case PolyIRCGPackage.LOOP__DECLARE_ITERATORS:
				setDeclareIterators(DECLARE_ITERATORS_EDEFAULT);
				return;
			case PolyIRCGPackage.LOOP__ITERATOR_NAMES:
				getIteratorNames().clear();
				return;
			case PolyIRCGPackage.LOOP__NUM_CONSTANT_DIMENSIONS:
				setNumConstantDimensions(NUM_CONSTANT_DIMENSIONS_EDEFAULT);
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
			case PolyIRCGPackage.LOOP__FUNCTION:
				return getFunction() != null;
			case PolyIRCGPackage.LOOP__PARAMETER_DOMAIN:
				return parameterDomain != null;
			case PolyIRCGPackage.LOOP__STATEMENTS:
				return statements != null && !statements.isEmpty();
			case PolyIRCGPackage.LOOP__DECLARE_ITERATORS:
				return declareIterators != DECLARE_ITERATORS_EDEFAULT;
			case PolyIRCGPackage.LOOP__ITERATOR_NAMES:
				return iteratorNames != null && !iteratorNames.isEmpty();
			case PolyIRCGPackage.LOOP__NUM_CONSTANT_DIMENSIONS:
				return numConstantDimensions != NUM_CONSTANT_DIMENSIONS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (declareIterators: ");
		result.append(declareIterators);
		result.append(", iteratorNames: ");
		result.append(iteratorNames);
		result.append(", numConstantDimensions: ");
		result.append(numConstantDimensions);
		result.append(')');
		return result.toString();
	}

} //LoopImpl
