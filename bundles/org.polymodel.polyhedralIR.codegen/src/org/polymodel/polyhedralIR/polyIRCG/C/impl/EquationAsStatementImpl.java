/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.Loop;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.CPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.EquationAsStatement;
import org.polymodel.scop.cgenerator2.MacroBodyProvider;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equation As Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.EquationAsStatementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.EquationAsStatementImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.EquationAsStatementImpl#getContainerLoop <em>Container Loop</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.EquationAsStatementImpl#isInlined <em>Inlined</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.EquationAsStatementImpl#getScattering <em>Scattering</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.EquationAsStatementImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.EquationAsStatementImpl#getAccessFunction <em>Access Function</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.EquationAsStatementImpl#getRhs <em>Rhs</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.impl.EquationAsStatementImpl#getVarDecl <em>Var Decl</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EquationAsStatementImpl extends EObjectImpl implements EquationAsStatement {
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
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected CodeGenVariable variable;

	/**
	 * The cached value of the '{@link #getAccessFunction() <em>Access Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessFunction()
	 * @generated
	 * @ordered
	 */
	protected AffineFunction accessFunction;

	/**
	 * The cached value of the '{@link #getRhs() <em>Rhs</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRhs()
	 * @generated
	 * @ordered
	 */
	protected Expression rhs;

	/**
	 * The cached value of the '{@link #getVarDecl() <em>Var Decl</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarDecl()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclaration varDecl;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EquationAsStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CPackage.Literals.EQUATION_AS_STATEMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.EQUATION_AS_STATEMENT__NAME, oldName, name));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CPackage.EQUATION_AS_STATEMENT__DOMAIN, oldDomain, newDomain);
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
				msgs = ((InternalEObject)domain).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CPackage.EQUATION_AS_STATEMENT__DOMAIN, null, msgs);
			if (newDomain != null)
				msgs = ((InternalEObject)newDomain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CPackage.EQUATION_AS_STATEMENT__DOMAIN, null, msgs);
			msgs = basicSetDomain(newDomain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.EQUATION_AS_STATEMENT__DOMAIN, newDomain, newDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Loop getContainerLoop() {
		if (eContainerFeatureID() != CPackage.EQUATION_AS_STATEMENT__CONTAINER_LOOP) return null;
		return (Loop)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainerLoop(Loop newContainerLoop, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainerLoop, CPackage.EQUATION_AS_STATEMENT__CONTAINER_LOOP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainerLoop(Loop newContainerLoop) {
		if (newContainerLoop != eInternalContainer() || (eContainerFeatureID() != CPackage.EQUATION_AS_STATEMENT__CONTAINER_LOOP && newContainerLoop != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.EQUATION_AS_STATEMENT__CONTAINER_LOOP, newContainerLoop, newContainerLoop));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.EQUATION_AS_STATEMENT__INLINED, oldInlined, inlined));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CPackage.EQUATION_AS_STATEMENT__SCATTERING, oldScattering, newScattering);
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
				msgs = ((InternalEObject)scattering).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CPackage.EQUATION_AS_STATEMENT__SCATTERING, null, msgs);
			if (newScattering != null)
				msgs = ((InternalEObject)newScattering).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CPackage.EQUATION_AS_STATEMENT__SCATTERING, null, msgs);
			msgs = basicSetScattering(newScattering, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.EQUATION_AS_STATEMENT__SCATTERING, newScattering, newScattering));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeGenVariable getVariable() {
		if (variable != null && variable.eIsProxy()) {
			InternalEObject oldVariable = (InternalEObject)variable;
			variable = (CodeGenVariable)eResolveProxy(oldVariable);
			if (variable != oldVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CPackage.EQUATION_AS_STATEMENT__VARIABLE, oldVariable, variable));
			}
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeGenVariable basicGetVariable() {
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariable(CodeGenVariable newVariable) {
		CodeGenVariable oldVariable = variable;
		variable = newVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.EQUATION_AS_STATEMENT__VARIABLE, oldVariable, variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineFunction getAccessFunction() {
		return accessFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAccessFunction(AffineFunction newAccessFunction, NotificationChain msgs) {
		AffineFunction oldAccessFunction = accessFunction;
		accessFunction = newAccessFunction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CPackage.EQUATION_AS_STATEMENT__ACCESS_FUNCTION, oldAccessFunction, newAccessFunction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccessFunction(AffineFunction newAccessFunction) {
		if (newAccessFunction != accessFunction) {
			NotificationChain msgs = null;
			if (accessFunction != null)
				msgs = ((InternalEObject)accessFunction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CPackage.EQUATION_AS_STATEMENT__ACCESS_FUNCTION, null, msgs);
			if (newAccessFunction != null)
				msgs = ((InternalEObject)newAccessFunction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CPackage.EQUATION_AS_STATEMENT__ACCESS_FUNCTION, null, msgs);
			msgs = basicSetAccessFunction(newAccessFunction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.EQUATION_AS_STATEMENT__ACCESS_FUNCTION, newAccessFunction, newAccessFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getRhs() {
		if (rhs != null && rhs.eIsProxy()) {
			InternalEObject oldRhs = (InternalEObject)rhs;
			rhs = (Expression)eResolveProxy(oldRhs);
			if (rhs != oldRhs) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CPackage.EQUATION_AS_STATEMENT__RHS, oldRhs, rhs));
			}
		}
		return rhs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression basicGetRhs() {
		return rhs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRhs(Expression newRhs) {
		Expression oldRhs = rhs;
		rhs = newRhs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.EQUATION_AS_STATEMENT__RHS, oldRhs, rhs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration getVarDecl() {
		if (varDecl != null && varDecl.eIsProxy()) {
			InternalEObject oldVarDecl = (InternalEObject)varDecl;
			varDecl = (VariableDeclaration)eResolveProxy(oldVarDecl);
			if (varDecl != oldVarDecl) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CPackage.EQUATION_AS_STATEMENT__VAR_DECL, oldVarDecl, varDecl));
			}
		}
		return varDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration basicGetVarDecl() {
		return varDecl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVarDecl(VariableDeclaration newVarDecl) {
		VariableDeclaration oldVarDecl = varDecl;
		varDecl = newVarDecl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CPackage.EQUATION_AS_STATEMENT__VAR_DECL, oldVarDecl, varDecl));
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
			case CPackage.EQUATION_AS_STATEMENT__CONTAINER_LOOP:
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
			case CPackage.EQUATION_AS_STATEMENT__DOMAIN:
				return basicSetDomain(null, msgs);
			case CPackage.EQUATION_AS_STATEMENT__CONTAINER_LOOP:
				return basicSetContainerLoop(null, msgs);
			case CPackage.EQUATION_AS_STATEMENT__SCATTERING:
				return basicSetScattering(null, msgs);
			case CPackage.EQUATION_AS_STATEMENT__ACCESS_FUNCTION:
				return basicSetAccessFunction(null, msgs);
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
			case CPackage.EQUATION_AS_STATEMENT__CONTAINER_LOOP:
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
			case CPackage.EQUATION_AS_STATEMENT__NAME:
				return getName();
			case CPackage.EQUATION_AS_STATEMENT__DOMAIN:
				return getDomain();
			case CPackage.EQUATION_AS_STATEMENT__CONTAINER_LOOP:
				return getContainerLoop();
			case CPackage.EQUATION_AS_STATEMENT__INLINED:
				return isInlined();
			case CPackage.EQUATION_AS_STATEMENT__SCATTERING:
				return getScattering();
			case CPackage.EQUATION_AS_STATEMENT__VARIABLE:
				if (resolve) return getVariable();
				return basicGetVariable();
			case CPackage.EQUATION_AS_STATEMENT__ACCESS_FUNCTION:
				return getAccessFunction();
			case CPackage.EQUATION_AS_STATEMENT__RHS:
				if (resolve) return getRhs();
				return basicGetRhs();
			case CPackage.EQUATION_AS_STATEMENT__VAR_DECL:
				if (resolve) return getVarDecl();
				return basicGetVarDecl();
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
			case CPackage.EQUATION_AS_STATEMENT__NAME:
				setName((String)newValue);
				return;
			case CPackage.EQUATION_AS_STATEMENT__DOMAIN:
				setDomain((Domain)newValue);
				return;
			case CPackage.EQUATION_AS_STATEMENT__CONTAINER_LOOP:
				setContainerLoop((Loop)newValue);
				return;
			case CPackage.EQUATION_AS_STATEMENT__INLINED:
				setInlined((Boolean)newValue);
				return;
			case CPackage.EQUATION_AS_STATEMENT__SCATTERING:
				setScattering((AffineFunction)newValue);
				return;
			case CPackage.EQUATION_AS_STATEMENT__VARIABLE:
				setVariable((CodeGenVariable)newValue);
				return;
			case CPackage.EQUATION_AS_STATEMENT__ACCESS_FUNCTION:
				setAccessFunction((AffineFunction)newValue);
				return;
			case CPackage.EQUATION_AS_STATEMENT__RHS:
				setRhs((Expression)newValue);
				return;
			case CPackage.EQUATION_AS_STATEMENT__VAR_DECL:
				setVarDecl((VariableDeclaration)newValue);
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
			case CPackage.EQUATION_AS_STATEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CPackage.EQUATION_AS_STATEMENT__DOMAIN:
				setDomain((Domain)null);
				return;
			case CPackage.EQUATION_AS_STATEMENT__CONTAINER_LOOP:
				setContainerLoop((Loop)null);
				return;
			case CPackage.EQUATION_AS_STATEMENT__INLINED:
				setInlined(INLINED_EDEFAULT);
				return;
			case CPackage.EQUATION_AS_STATEMENT__SCATTERING:
				setScattering((AffineFunction)null);
				return;
			case CPackage.EQUATION_AS_STATEMENT__VARIABLE:
				setVariable((CodeGenVariable)null);
				return;
			case CPackage.EQUATION_AS_STATEMENT__ACCESS_FUNCTION:
				setAccessFunction((AffineFunction)null);
				return;
			case CPackage.EQUATION_AS_STATEMENT__RHS:
				setRhs((Expression)null);
				return;
			case CPackage.EQUATION_AS_STATEMENT__VAR_DECL:
				setVarDecl((VariableDeclaration)null);
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
			case CPackage.EQUATION_AS_STATEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CPackage.EQUATION_AS_STATEMENT__DOMAIN:
				return domain != null;
			case CPackage.EQUATION_AS_STATEMENT__CONTAINER_LOOP:
				return getContainerLoop() != null;
			case CPackage.EQUATION_AS_STATEMENT__INLINED:
				return inlined != INLINED_EDEFAULT;
			case CPackage.EQUATION_AS_STATEMENT__SCATTERING:
				return scattering != null;
			case CPackage.EQUATION_AS_STATEMENT__VARIABLE:
				return variable != null;
			case CPackage.EQUATION_AS_STATEMENT__ACCESS_FUNCTION:
				return accessFunction != null;
			case CPackage.EQUATION_AS_STATEMENT__RHS:
				return rhs != null;
			case CPackage.EQUATION_AS_STATEMENT__VAR_DECL:
				return varDecl != null;
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

} //EquationAsStatementImpl
