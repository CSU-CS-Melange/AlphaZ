/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.impl;


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.polyIRCG.BasicStatement;
import org.polymodel.polyhedralIR.polyIRCG.Loop;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;
import org.polymodel.scop.cgenerator2.MacroBodyProvider;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.BasicStatementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.BasicStatementImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.BasicStatementImpl#getContainerLoop <em>Container Loop</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.BasicStatementImpl#isInlined <em>Inlined</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.BasicStatementImpl#getScattering <em>Scattering</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.BasicStatementImpl#getStatement <em>Statement</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BasicStatementImpl extends EObjectImpl implements BasicStatement {
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
	 * The default value of the '{@link #getStatement() <em>Statement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatement()
	 * @generated
	 * @ordered
	 */
	protected static final String STATEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatement() <em>Statement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatement()
	 * @generated
	 * @ordered
	 */
	protected String statement = STATEMENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BasicStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyIRCGPackage.Literals.BASIC_STATEMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.BASIC_STATEMENT__NAME, oldName, name));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.BASIC_STATEMENT__DOMAIN, oldDomain, newDomain);
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
				msgs = ((InternalEObject)domain).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolyIRCGPackage.BASIC_STATEMENT__DOMAIN, null, msgs);
			if (newDomain != null)
				msgs = ((InternalEObject)newDomain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolyIRCGPackage.BASIC_STATEMENT__DOMAIN, null, msgs);
			msgs = basicSetDomain(newDomain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.BASIC_STATEMENT__DOMAIN, newDomain, newDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Loop getContainerLoop() {
		if (eContainerFeatureID() != PolyIRCGPackage.BASIC_STATEMENT__CONTAINER_LOOP) return null;
		return (Loop)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainerLoop(Loop newContainerLoop, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainerLoop, PolyIRCGPackage.BASIC_STATEMENT__CONTAINER_LOOP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainerLoop(Loop newContainerLoop) {
		if (newContainerLoop != eInternalContainer() || (eContainerFeatureID() != PolyIRCGPackage.BASIC_STATEMENT__CONTAINER_LOOP && newContainerLoop != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.BASIC_STATEMENT__CONTAINER_LOOP, newContainerLoop, newContainerLoop));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.BASIC_STATEMENT__INLINED, oldInlined, inlined));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.BASIC_STATEMENT__SCATTERING, oldScattering, newScattering);
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
				msgs = ((InternalEObject)scattering).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolyIRCGPackage.BASIC_STATEMENT__SCATTERING, null, msgs);
			if (newScattering != null)
				msgs = ((InternalEObject)newScattering).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolyIRCGPackage.BASIC_STATEMENT__SCATTERING, null, msgs);
			msgs = basicSetScattering(newScattering, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.BASIC_STATEMENT__SCATTERING, newScattering, newScattering));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStatement() {
		return statement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatement(String newStatement) {
		String oldStatement = statement;
		statement = newStatement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.BASIC_STATEMENT__STATEMENT, oldStatement, statement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public MacroBodyProvider getMacroBodyProvider() {
		return new org.polymodel.scop.cgenerator2.FixedStringMacro(statement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolyIRCGPackage.BASIC_STATEMENT__CONTAINER_LOOP:
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
			case PolyIRCGPackage.BASIC_STATEMENT__DOMAIN:
				return basicSetDomain(null, msgs);
			case PolyIRCGPackage.BASIC_STATEMENT__CONTAINER_LOOP:
				return basicSetContainerLoop(null, msgs);
			case PolyIRCGPackage.BASIC_STATEMENT__SCATTERING:
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
			case PolyIRCGPackage.BASIC_STATEMENT__CONTAINER_LOOP:
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
			case PolyIRCGPackage.BASIC_STATEMENT__NAME:
				return getName();
			case PolyIRCGPackage.BASIC_STATEMENT__DOMAIN:
				return getDomain();
			case PolyIRCGPackage.BASIC_STATEMENT__CONTAINER_LOOP:
				return getContainerLoop();
			case PolyIRCGPackage.BASIC_STATEMENT__INLINED:
				return isInlined();
			case PolyIRCGPackage.BASIC_STATEMENT__SCATTERING:
				return getScattering();
			case PolyIRCGPackage.BASIC_STATEMENT__STATEMENT:
				return getStatement();
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
			case PolyIRCGPackage.BASIC_STATEMENT__NAME:
				setName((String)newValue);
				return;
			case PolyIRCGPackage.BASIC_STATEMENT__DOMAIN:
				setDomain((Domain)newValue);
				return;
			case PolyIRCGPackage.BASIC_STATEMENT__CONTAINER_LOOP:
				setContainerLoop((Loop)newValue);
				return;
			case PolyIRCGPackage.BASIC_STATEMENT__INLINED:
				setInlined((Boolean)newValue);
				return;
			case PolyIRCGPackage.BASIC_STATEMENT__SCATTERING:
				setScattering((AffineFunction)newValue);
				return;
			case PolyIRCGPackage.BASIC_STATEMENT__STATEMENT:
				setStatement((String)newValue);
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
			case PolyIRCGPackage.BASIC_STATEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PolyIRCGPackage.BASIC_STATEMENT__DOMAIN:
				setDomain((Domain)null);
				return;
			case PolyIRCGPackage.BASIC_STATEMENT__CONTAINER_LOOP:
				setContainerLoop((Loop)null);
				return;
			case PolyIRCGPackage.BASIC_STATEMENT__INLINED:
				setInlined(INLINED_EDEFAULT);
				return;
			case PolyIRCGPackage.BASIC_STATEMENT__SCATTERING:
				setScattering((AffineFunction)null);
				return;
			case PolyIRCGPackage.BASIC_STATEMENT__STATEMENT:
				setStatement(STATEMENT_EDEFAULT);
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
			case PolyIRCGPackage.BASIC_STATEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PolyIRCGPackage.BASIC_STATEMENT__DOMAIN:
				return domain != null;
			case PolyIRCGPackage.BASIC_STATEMENT__CONTAINER_LOOP:
				return getContainerLoop() != null;
			case PolyIRCGPackage.BASIC_STATEMENT__INLINED:
				return inlined != INLINED_EDEFAULT;
			case PolyIRCGPackage.BASIC_STATEMENT__SCATTERING:
				return scattering != null;
			case PolyIRCGPackage.BASIC_STATEMENT__STATEMENT:
				return STATEMENT_EDEFAULT == null ? statement != null : !STATEMENT_EDEFAULT.equals(statement);
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
		result.append(", statement: ");
		result.append(statement);
		result.append(')');
		return result.toString();
	}

} //BasicStatementImpl
