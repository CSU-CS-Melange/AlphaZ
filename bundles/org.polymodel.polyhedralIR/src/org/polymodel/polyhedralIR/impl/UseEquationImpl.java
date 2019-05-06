/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.PolyhedralIRPackage;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Use Equation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.impl.UseEquationImpl#getExtensionDomain <em>Extension Domain</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.UseEquationImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.UseEquationImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.UseEquationImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.UseEquationImpl#getSubSystem <em>Sub System</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.UseEquationImpl#getContainerSystem <em>Container System</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.UseEquationImpl#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UseEquationImpl extends EObjectImpl implements UseEquation {
	/**
	 * The cached value of the '{@link #getExtensionDomain() <em>Extension Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionDomain()
	 * @generated
	 * @ordered
	 */
	protected Domain extensionDomain;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected AffineFunction parameters;

	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> inputs;

	/**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableDeclaration> outputs;

	/**
	 * The cached value of the '{@link #getSubSystem() <em>Sub System</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubSystem()
	 * @generated
	 * @ordered
	 */
	protected AffineSystem subSystem;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UseEquationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyhedralIRPackage.eINSTANCE.getUseEquation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain getExtensionDomain() {
		return extensionDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtensionDomain(Domain newExtensionDomain, NotificationChain msgs) {
		Domain oldExtensionDomain = extensionDomain;
		extensionDomain = newExtensionDomain;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.USE_EQUATION__EXTENSION_DOMAIN, oldExtensionDomain, newExtensionDomain);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtensionDomain(Domain newExtensionDomain) {
		if (newExtensionDomain != extensionDomain) {
			NotificationChain msgs = null;
			if (extensionDomain != null)
				msgs = ((InternalEObject)extensionDomain).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolyhedralIRPackage.USE_EQUATION__EXTENSION_DOMAIN, null, msgs);
			if (newExtensionDomain != null)
				msgs = ((InternalEObject)newExtensionDomain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolyhedralIRPackage.USE_EQUATION__EXTENSION_DOMAIN, null, msgs);
			msgs = basicSetExtensionDomain(newExtensionDomain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.USE_EQUATION__EXTENSION_DOMAIN, newExtensionDomain, newExtensionDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineFunction getParameters() {
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParameters(AffineFunction newParameters, NotificationChain msgs) {
		AffineFunction oldParameters = parameters;
		parameters = newParameters;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.USE_EQUATION__PARAMETERS, oldParameters, newParameters);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameters(AffineFunction newParameters) {
		if (newParameters != parameters) {
			NotificationChain msgs = null;
			if (parameters != null)
				msgs = ((InternalEObject)parameters).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolyhedralIRPackage.USE_EQUATION__PARAMETERS, null, msgs);
			if (newParameters != null)
				msgs = ((InternalEObject)newParameters).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolyhedralIRPackage.USE_EQUATION__PARAMETERS, null, msgs);
			msgs = basicSetParameters(newParameters, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.USE_EQUATION__PARAMETERS, newParameters, newParameters));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getInputs() {
		if (inputs == null) {
			inputs = new EObjectContainmentEList<Expression>(Expression.class, this, PolyhedralIRPackage.USE_EQUATION__INPUTS);
		}
		return inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableDeclaration> getOutputs() {
		if (outputs == null) {
			outputs = new EObjectResolvingEList<VariableDeclaration>(VariableDeclaration.class, this, PolyhedralIRPackage.USE_EQUATION__OUTPUTS);
		}
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineSystem getContainerSystem() {
		if (eContainerFeatureID() != PolyhedralIRPackage.USE_EQUATION__CONTAINER_SYSTEM) return null;
		return (AffineSystem)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.USE_EQUATION__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineSystem getSubSystem() {
		if (subSystem != null && subSystem.eIsProxy()) {
			InternalEObject oldSubSystem = (InternalEObject)subSystem;
			subSystem = (AffineSystem)eResolveProxy(oldSubSystem);
			if (subSystem != oldSubSystem) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PolyhedralIRPackage.USE_EQUATION__SUB_SYSTEM, oldSubSystem, subSystem));
			}
		}
		return subSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineSystem basicGetSubSystem() {
		return subSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubSystem(AffineSystem newSubSystem) {
		AffineSystem oldSubSystem = subSystem;
		subSystem = newSubSystem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.USE_EQUATION__SUB_SYSTEM, oldSubSystem, subSystem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitUseEquation(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolyhedralIRPackage.USE_EQUATION__CONTAINER_SYSTEM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, PolyhedralIRPackage.USE_EQUATION__CONTAINER_SYSTEM, msgs);
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
			case PolyhedralIRPackage.USE_EQUATION__EXTENSION_DOMAIN:
				return basicSetExtensionDomain(null, msgs);
			case PolyhedralIRPackage.USE_EQUATION__PARAMETERS:
				return basicSetParameters(null, msgs);
			case PolyhedralIRPackage.USE_EQUATION__INPUTS:
				return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
			case PolyhedralIRPackage.USE_EQUATION__CONTAINER_SYSTEM:
				return eBasicSetContainer(null, PolyhedralIRPackage.USE_EQUATION__CONTAINER_SYSTEM, msgs);
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
			case PolyhedralIRPackage.USE_EQUATION__CONTAINER_SYSTEM:
				return eInternalContainer().eInverseRemove(this, PolyhedralIRPackage.AFFINE_SYSTEM__USE_EQUATIONS, AffineSystem.class, msgs);
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
			case PolyhedralIRPackage.USE_EQUATION__EXTENSION_DOMAIN:
				return getExtensionDomain();
			case PolyhedralIRPackage.USE_EQUATION__PARAMETERS:
				return getParameters();
			case PolyhedralIRPackage.USE_EQUATION__INPUTS:
				return getInputs();
			case PolyhedralIRPackage.USE_EQUATION__OUTPUTS:
				return getOutputs();
			case PolyhedralIRPackage.USE_EQUATION__SUB_SYSTEM:
				if (resolve) return getSubSystem();
				return basicGetSubSystem();
			case PolyhedralIRPackage.USE_EQUATION__CONTAINER_SYSTEM:
				return getContainerSystem();
			case PolyhedralIRPackage.USE_EQUATION__LABEL:
				return getLabel();
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
			case PolyhedralIRPackage.USE_EQUATION__EXTENSION_DOMAIN:
				setExtensionDomain((Domain)newValue);
				return;
			case PolyhedralIRPackage.USE_EQUATION__PARAMETERS:
				setParameters((AffineFunction)newValue);
				return;
			case PolyhedralIRPackage.USE_EQUATION__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends Expression>)newValue);
				return;
			case PolyhedralIRPackage.USE_EQUATION__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends VariableDeclaration>)newValue);
				return;
			case PolyhedralIRPackage.USE_EQUATION__SUB_SYSTEM:
				setSubSystem((AffineSystem)newValue);
				return;
			case PolyhedralIRPackage.USE_EQUATION__LABEL:
				setLabel((String)newValue);
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
			case PolyhedralIRPackage.USE_EQUATION__EXTENSION_DOMAIN:
				setExtensionDomain((Domain)null);
				return;
			case PolyhedralIRPackage.USE_EQUATION__PARAMETERS:
				setParameters((AffineFunction)null);
				return;
			case PolyhedralIRPackage.USE_EQUATION__INPUTS:
				getInputs().clear();
				return;
			case PolyhedralIRPackage.USE_EQUATION__OUTPUTS:
				getOutputs().clear();
				return;
			case PolyhedralIRPackage.USE_EQUATION__SUB_SYSTEM:
				setSubSystem((AffineSystem)null);
				return;
			case PolyhedralIRPackage.USE_EQUATION__LABEL:
				setLabel(LABEL_EDEFAULT);
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
			case PolyhedralIRPackage.USE_EQUATION__EXTENSION_DOMAIN:
				return extensionDomain != null;
			case PolyhedralIRPackage.USE_EQUATION__PARAMETERS:
				return parameters != null;
			case PolyhedralIRPackage.USE_EQUATION__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case PolyhedralIRPackage.USE_EQUATION__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
			case PolyhedralIRPackage.USE_EQUATION__SUB_SYSTEM:
				return subSystem != null;
			case PolyhedralIRPackage.USE_EQUATION__CONTAINER_SYSTEM:
				return getContainerSystem() != null;
			case PolyhedralIRPackage.USE_EQUATION__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
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
		result.append(" (label: ");
		result.append(label);
		result.append(')');
		return result.toString();
	}

} //UseEquationImpl
