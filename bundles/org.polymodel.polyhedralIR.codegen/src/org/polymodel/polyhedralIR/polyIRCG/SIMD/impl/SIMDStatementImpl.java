/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.polyIRCG.Loop;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDStatement;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SIMDExpression;
import org.polymodel.scop.cgenerator2.MacroBodyProvider;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDStatementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDStatementImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDStatementImpl#getContainerLoop <em>Container Loop</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDStatementImpl#isInlined <em>Inlined</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDStatementImpl#getScattering <em>Scattering</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.SIMD.impl.SIMDStatementImpl#getSimdExp <em>Simd Exp</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SIMDStatementImpl extends EObjectImpl implements SIMDStatement {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	 * The default value of the '{@link #isInlined() <em>Inlined</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInlined()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INLINED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInlined() <em>Inlined</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInlined()
	 * @generated
	 * @ordered
	 */
	protected boolean inlined = INLINED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getScattering() <em>Scattering</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScattering()
	 * @generated
	 * @ordered
	 */
	protected AffineFunction scattering;

	/**
	 * The cached value of the '{@link #getSimdExp() <em>Simd Exp</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimdExp()
	 * @generated
	 * @ordered
	 */
	protected SIMDExpression simdExp;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SIMDStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SIMDPackage.Literals.SIMD_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SIMDPackage.SIMD_STATEMENT__NAME, oldName, name));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SIMDPackage.SIMD_STATEMENT__DOMAIN, oldDomain, newDomain);
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
				msgs = ((InternalEObject)domain).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SIMDPackage.SIMD_STATEMENT__DOMAIN, null, msgs);
			if (newDomain != null)
				msgs = ((InternalEObject)newDomain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SIMDPackage.SIMD_STATEMENT__DOMAIN, null, msgs);
			msgs = basicSetDomain(newDomain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SIMDPackage.SIMD_STATEMENT__DOMAIN, newDomain, newDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Loop getContainerLoop() {
		if (eContainerFeatureID() != SIMDPackage.SIMD_STATEMENT__CONTAINER_LOOP) return null;
		return (Loop)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainerLoop(Loop newContainerLoop, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainerLoop, SIMDPackage.SIMD_STATEMENT__CONTAINER_LOOP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainerLoop(Loop newContainerLoop) {
		if (newContainerLoop != eInternalContainer() || (eContainerFeatureID() != SIMDPackage.SIMD_STATEMENT__CONTAINER_LOOP && newContainerLoop != null)) {
			if (EcoreUtil.isAncestor(this, newContainerLoop))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainerLoop != null)
				msgs = ((InternalEObject)newContainerLoop).eInverseAdd(this, PolyIRCGPackage.LOOP__STATEMENTS, Loop.class, msgs);
			msgs = basicSetContainerLoop(newContainerLoop, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SIMDPackage.SIMD_STATEMENT__CONTAINER_LOOP, newContainerLoop, newContainerLoop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInlined() {
		return inlined;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInlined(boolean newInlined) {
		boolean oldInlined = inlined;
		inlined = newInlined;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SIMDPackage.SIMD_STATEMENT__INLINED, oldInlined, inlined));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineFunction getScattering() {
		return scattering;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScattering(AffineFunction newScattering, NotificationChain msgs) {
		AffineFunction oldScattering = scattering;
		scattering = newScattering;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SIMDPackage.SIMD_STATEMENT__SCATTERING, oldScattering, newScattering);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScattering(AffineFunction newScattering) {
		if (newScattering != scattering) {
			NotificationChain msgs = null;
			if (scattering != null)
				msgs = ((InternalEObject)scattering).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SIMDPackage.SIMD_STATEMENT__SCATTERING, null, msgs);
			if (newScattering != null)
				msgs = ((InternalEObject)newScattering).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SIMDPackage.SIMD_STATEMENT__SCATTERING, null, msgs);
			msgs = basicSetScattering(newScattering, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SIMDPackage.SIMD_STATEMENT__SCATTERING, newScattering, newScattering));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIMDExpression getSimdExp() {
		if (simdExp != null && simdExp.eIsProxy()) {
			InternalEObject oldSimdExp = (InternalEObject)simdExp;
			simdExp = (SIMDExpression)eResolveProxy(oldSimdExp);
			if (simdExp != oldSimdExp) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SIMDPackage.SIMD_STATEMENT__SIMD_EXP, oldSimdExp, simdExp));
			}
		}
		return simdExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIMDExpression basicGetSimdExp() {
		return simdExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimdExp(SIMDExpression newSimdExp) {
		SIMDExpression oldSimdExp = simdExp;
		simdExp = newSimdExp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SIMDPackage.SIMD_STATEMENT__SIMD_EXP, oldSimdExp, simdExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MacroBodyProvider getMacroBodyProvider() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SIMDPackage.SIMD_STATEMENT__CONTAINER_LOOP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainerLoop((Loop)otherEnd, msgs);
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
			case SIMDPackage.SIMD_STATEMENT__DOMAIN:
				return basicSetDomain(null, msgs);
			case SIMDPackage.SIMD_STATEMENT__CONTAINER_LOOP:
				return basicSetContainerLoop(null, msgs);
			case SIMDPackage.SIMD_STATEMENT__SCATTERING:
				return basicSetScattering(null, msgs);
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
			case SIMDPackage.SIMD_STATEMENT__CONTAINER_LOOP:
				return eInternalContainer().eInverseRemove(this, PolyIRCGPackage.LOOP__STATEMENTS, Loop.class, msgs);
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
			case SIMDPackage.SIMD_STATEMENT__NAME:
				return getName();
			case SIMDPackage.SIMD_STATEMENT__DOMAIN:
				return getDomain();
			case SIMDPackage.SIMD_STATEMENT__CONTAINER_LOOP:
				return getContainerLoop();
			case SIMDPackage.SIMD_STATEMENT__INLINED:
				return isInlined();
			case SIMDPackage.SIMD_STATEMENT__SCATTERING:
				return getScattering();
			case SIMDPackage.SIMD_STATEMENT__SIMD_EXP:
				if (resolve) return getSimdExp();
				return basicGetSimdExp();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SIMDPackage.SIMD_STATEMENT__NAME:
				setName((String)newValue);
				return;
			case SIMDPackage.SIMD_STATEMENT__DOMAIN:
				setDomain((Domain)newValue);
				return;
			case SIMDPackage.SIMD_STATEMENT__CONTAINER_LOOP:
				setContainerLoop((Loop)newValue);
				return;
			case SIMDPackage.SIMD_STATEMENT__INLINED:
				setInlined((Boolean)newValue);
				return;
			case SIMDPackage.SIMD_STATEMENT__SCATTERING:
				setScattering((AffineFunction)newValue);
				return;
			case SIMDPackage.SIMD_STATEMENT__SIMD_EXP:
				setSimdExp((SIMDExpression)newValue);
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
			case SIMDPackage.SIMD_STATEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SIMDPackage.SIMD_STATEMENT__DOMAIN:
				setDomain((Domain)null);
				return;
			case SIMDPackage.SIMD_STATEMENT__CONTAINER_LOOP:
				setContainerLoop((Loop)null);
				return;
			case SIMDPackage.SIMD_STATEMENT__INLINED:
				setInlined(INLINED_EDEFAULT);
				return;
			case SIMDPackage.SIMD_STATEMENT__SCATTERING:
				setScattering((AffineFunction)null);
				return;
			case SIMDPackage.SIMD_STATEMENT__SIMD_EXP:
				setSimdExp((SIMDExpression)null);
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
			case SIMDPackage.SIMD_STATEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SIMDPackage.SIMD_STATEMENT__DOMAIN:
				return domain != null;
			case SIMDPackage.SIMD_STATEMENT__CONTAINER_LOOP:
				return getContainerLoop() != null;
			case SIMDPackage.SIMD_STATEMENT__INLINED:
				return inlined != INLINED_EDEFAULT;
			case SIMDPackage.SIMD_STATEMENT__SCATTERING:
				return scattering != null;
			case SIMDPackage.SIMD_STATEMENT__SIMD_EXP:
				return simdExp != null;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", inlined: ");
		result.append(inlined);
		result.append(')');
		return result.toString();
	}

} //SIMDStatementImpl
