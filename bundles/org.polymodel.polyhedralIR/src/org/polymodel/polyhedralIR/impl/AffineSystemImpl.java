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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.PolyhedralIRPackage;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.TilingInformations;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.WhileInfo;
import org.polymodel.polyhedralIR.factory.TargetMappingUserFactory;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.targetMapping.TargetMappingPackage;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Affine System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.impl.AffineSystemImpl#getContainerProgram <em>Container Program</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.AffineSystemImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.AffineSystemImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.AffineSystemImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.AffineSystemImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.AffineSystemImpl#getLocals <em>Locals</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.AffineSystemImpl#getEquations <em>Equations</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.AffineSystemImpl#getUseEquations <em>Use Equations</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.AffineSystemImpl#getTargetMapping <em>Target Mapping</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.AffineSystemImpl#getWhileInfo <em>While Info</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.AffineSystemImpl#getTilingInfo <em>Tiling Info</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AffineSystemImpl extends EObjectImpl implements AffineSystem {
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
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected ParameterDomain parameters;

	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableDeclaration> inputs;

	/**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableDeclaration> outputs;

	/**
	 * The cached value of the '{@link #getLocals() <em>Locals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocals()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableDeclaration> locals;

	/**
	 * The cached value of the '{@link #getEquations() <em>Equations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquations()
	 * @generated
	 * @ordered
	 */
	protected EList<StandardEquation> equations;

	/**
	 * The cached value of the '{@link #getUseEquations() <em>Use Equations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseEquations()
	 * @generated
	 * @ordered
	 */
	protected EList<UseEquation> useEquations;

	/**
	 * The cached value of the '{@link #getTargetMapping() <em>Target Mapping</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetMapping()
	 * @generated
	 * @ordered
	 */
	protected TargetMapping targetMapping;

	/**
	 * The cached value of the '{@link #getWhileInfo() <em>While Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhileInfo()
	 * @generated
	 * @ordered
	 */
	protected WhileInfo whileInfo;

	/**
	 * The cached value of the '{@link #getTilingInfo() <em>Tiling Info</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTilingInfo()
	 * @generated
	 * @ordered
	 */
	protected TilingInformations tilingInfo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AffineSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyhedralIRPackage.eINSTANCE.getAffineSystem();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Program getContainerProgram() {
		if (eContainerFeatureID() != PolyhedralIRPackage.AFFINE_SYSTEM__CONTAINER_PROGRAM) return null;
		return (Program)eInternalContainer();
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
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.AFFINE_SYSTEM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterDomain getParameters() {
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParameters(ParameterDomain newParameters, NotificationChain msgs) {
		ParameterDomain oldParameters = parameters;
		parameters = newParameters;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.AFFINE_SYSTEM__PARAMETERS, oldParameters, newParameters);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameters(ParameterDomain newParameters) {
		if (newParameters != parameters) {
			NotificationChain msgs = null;
			if (parameters != null)
				msgs = ((InternalEObject)parameters).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolyhedralIRPackage.AFFINE_SYSTEM__PARAMETERS, null, msgs);
			if (newParameters != null)
				msgs = ((InternalEObject)newParameters).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolyhedralIRPackage.AFFINE_SYSTEM__PARAMETERS, null, msgs);
			msgs = basicSetParameters(newParameters, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.AFFINE_SYSTEM__PARAMETERS, newParameters, newParameters));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableDeclaration> getInputs() {
		if (inputs == null) {
			inputs = new EObjectContainmentEList<VariableDeclaration>(VariableDeclaration.class, this, PolyhedralIRPackage.AFFINE_SYSTEM__INPUTS);
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
			outputs = new EObjectContainmentEList<VariableDeclaration>(VariableDeclaration.class, this, PolyhedralIRPackage.AFFINE_SYSTEM__OUTPUTS);
		}
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableDeclaration> getLocals() {
		if (locals == null) {
			locals = new EObjectContainmentEList<VariableDeclaration>(VariableDeclaration.class, this, PolyhedralIRPackage.AFFINE_SYSTEM__LOCALS);
		}
		return locals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StandardEquation> getEquations() {
		if (equations == null) {
			equations = new EObjectContainmentWithInverseEList<StandardEquation>(StandardEquation.class, this, PolyhedralIRPackage.AFFINE_SYSTEM__EQUATIONS, PolyhedralIRPackage.STANDARD_EQUATION__CONTAINER_SYSTEM);
		}
		return equations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseEquation> getUseEquations() {
		if (useEquations == null) {
			useEquations = new EObjectContainmentWithInverseEList<UseEquation>(UseEquation.class, this, PolyhedralIRPackage.AFFINE_SYSTEM__USE_EQUATIONS, PolyhedralIRPackage.USE_EQUATION__CONTAINER_SYSTEM);
		}
		return useEquations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Creates identity target mapping if not specified yet.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TargetMapping getTargetMapping() {
		if (targetMapping == null) {
			TargetMapping tm = TargetMappingUserFactory.createIdentityTargetMapping(this);
			setTargetMapping(tm);
		}
		return targetMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetMapping(TargetMapping newTargetMapping, NotificationChain msgs) {
		TargetMapping oldTargetMapping = targetMapping;
		targetMapping = newTargetMapping;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.AFFINE_SYSTEM__TARGET_MAPPING, oldTargetMapping, newTargetMapping);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetMapping(TargetMapping newTargetMapping) {
		if (newTargetMapping != targetMapping) {
			NotificationChain msgs = null;
			if (targetMapping != null)
				msgs = ((InternalEObject)targetMapping).eInverseRemove(this, TargetMappingPackage.TARGET_MAPPING__CONTAINER_SYSTEM, TargetMapping.class, msgs);
			if (newTargetMapping != null)
				msgs = ((InternalEObject)newTargetMapping).eInverseAdd(this, TargetMappingPackage.TARGET_MAPPING__CONTAINER_SYSTEM, TargetMapping.class, msgs);
			msgs = basicSetTargetMapping(newTargetMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.AFFINE_SYSTEM__TARGET_MAPPING, newTargetMapping, newTargetMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WhileInfo getWhileInfo() {
		return whileInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhileInfo(WhileInfo newWhileInfo, NotificationChain msgs) {
		WhileInfo oldWhileInfo = whileInfo;
		whileInfo = newWhileInfo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.AFFINE_SYSTEM__WHILE_INFO, oldWhileInfo, newWhileInfo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhileInfo(WhileInfo newWhileInfo) {
		if (newWhileInfo != whileInfo) {
			NotificationChain msgs = null;
			if (whileInfo != null)
				msgs = ((InternalEObject)whileInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolyhedralIRPackage.AFFINE_SYSTEM__WHILE_INFO, null, msgs);
			if (newWhileInfo != null)
				msgs = ((InternalEObject)newWhileInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolyhedralIRPackage.AFFINE_SYSTEM__WHILE_INFO, null, msgs);
			msgs = basicSetWhileInfo(newWhileInfo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.AFFINE_SYSTEM__WHILE_INFO, newWhileInfo, newWhileInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TilingInformations getTilingInfo() {
		if (tilingInfo != null && tilingInfo.eIsProxy()) {
			InternalEObject oldTilingInfo = (InternalEObject)tilingInfo;
			tilingInfo = (TilingInformations)eResolveProxy(oldTilingInfo);
			if (tilingInfo != oldTilingInfo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PolyhedralIRPackage.AFFINE_SYSTEM__TILING_INFO, oldTilingInfo, tilingInfo));
			}
		}
		return tilingInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TilingInformations basicGetTilingInfo() {
		return tilingInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTilingInfo(TilingInformations newTilingInfo) {
		TilingInformations oldTilingInfo = tilingInfo;
		tilingInfo = newTilingInfo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.AFFINE_SYSTEM__TILING_INFO, oldTilingInfo, tilingInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public VariableDeclaration getVariableDeclaration(String name) {
		for (VariableDeclaration var : getInputs()) {
			if (var.getVarID().getName().compareTo(name) == 0) {
				return var;
			}
		}
		for (VariableDeclaration var : getLocals()) {
			if (var.getVarID().getName().compareTo(name) == 0) {
				return var;
			}
		}
		for (VariableDeclaration var : getOutputs()) {
			if (var.getVarID().getName().compareTo(name) == 0) {
				return var;
			}
		}
		
		//throw new RuntimeException("Variable " + name + " is not declared.");
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public StandardEquation getEquation(String name) {
		VariableDeclaration varDecl = getVariableDeclaration(name);
		for (StandardEquation eq : getEquations()) {
			if (eq.getVariable().equals(varDecl)) {
				return eq;
			}
		}
		
		//throw new RuntimeException("No standard equation for variable " + varDecl + " found.");
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * The use equation should be identified with the label instead of the output variable
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public UseEquation getUseEquation(String name) {
		
		for(UseEquation eq : getUseEquations()){
			if(eq.getLabel().contentEquals(name)){
				return eq;
			}
		}
		
		throw new RuntimeException("No use equation " + name  + "found");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean containsVariable(String varName) {
		for (VariableDeclaration var : getInputs()) {
			if (var.getName().compareTo(varName) == 0) {
				return true;
			}
		}
		for (VariableDeclaration var : getOutputs()) {
			if (var.getName().compareTo(varName) == 0) {
				return true;
			}
		}
		for (VariableDeclaration var : getLocals()) {
			if (var.getName().compareTo(varName) == 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * EcoreUtil.copy
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AffineSystem copy() {
		AffineSystem copy = EcoreUtil.copy(this);

//		Map<String, VariableDeclaration> orig = new TreeMap<String, VariableDeclaration>();
//		Map<String, VariableDeclaration> copied = new TreeMap<String, VariableDeclaration>();
//
//		for (VariableDeclaration var : this.getInputs()) orig.put(var.getName(), var);
//		for (VariableDeclaration var : this.getOutputs()) orig.put(var.getName(), var);
//		for (VariableDeclaration var : this.getLocals()) orig.put(var.getName(), var);
//
//		for (VariableDeclaration var : getInputs()) copied.put(var.getName(), var);
//		for (VariableDeclaration var : getOutputs()) copied.put(var.getName(), var);
//		for (VariableDeclaration var : getLocals()) copied.put(var.getName(), var);
//		
//		
//		for (String key : orig.keySet()) {
//			EcoreUtil.replace(orig.get(key), copied.get(key));
//		}
//		
		return copy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public UseEquation findLabel(String label) {
		for (UseEquation ueq : this.getUseEquations())
			if (ueq.getLabel().compareTo(label)==0)
				return ueq;
		throw new RuntimeException("No UseEquation with the label" + label +" was found");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isInput(VariableDeclaration var) {
		return getInputs().contains(var);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isOutput(VariableDeclaration var) {
		return getOutputs().contains(var);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isLocal(VariableDeclaration var) {
		return getLocals().contains(var);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitAffineSystem(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolyhedralIRPackage.AFFINE_SYSTEM__CONTAINER_PROGRAM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, PolyhedralIRPackage.AFFINE_SYSTEM__CONTAINER_PROGRAM, msgs);
			case PolyhedralIRPackage.AFFINE_SYSTEM__EQUATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEquations()).basicAdd(otherEnd, msgs);
			case PolyhedralIRPackage.AFFINE_SYSTEM__USE_EQUATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUseEquations()).basicAdd(otherEnd, msgs);
			case PolyhedralIRPackage.AFFINE_SYSTEM__TARGET_MAPPING:
				if (targetMapping != null)
					msgs = ((InternalEObject)targetMapping).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolyhedralIRPackage.AFFINE_SYSTEM__TARGET_MAPPING, null, msgs);
				return basicSetTargetMapping((TargetMapping)otherEnd, msgs);
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
			case PolyhedralIRPackage.AFFINE_SYSTEM__CONTAINER_PROGRAM:
				return eBasicSetContainer(null, PolyhedralIRPackage.AFFINE_SYSTEM__CONTAINER_PROGRAM, msgs);
			case PolyhedralIRPackage.AFFINE_SYSTEM__PARAMETERS:
				return basicSetParameters(null, msgs);
			case PolyhedralIRPackage.AFFINE_SYSTEM__INPUTS:
				return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
			case PolyhedralIRPackage.AFFINE_SYSTEM__OUTPUTS:
				return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
			case PolyhedralIRPackage.AFFINE_SYSTEM__LOCALS:
				return ((InternalEList<?>)getLocals()).basicRemove(otherEnd, msgs);
			case PolyhedralIRPackage.AFFINE_SYSTEM__EQUATIONS:
				return ((InternalEList<?>)getEquations()).basicRemove(otherEnd, msgs);
			case PolyhedralIRPackage.AFFINE_SYSTEM__USE_EQUATIONS:
				return ((InternalEList<?>)getUseEquations()).basicRemove(otherEnd, msgs);
			case PolyhedralIRPackage.AFFINE_SYSTEM__TARGET_MAPPING:
				return basicSetTargetMapping(null, msgs);
			case PolyhedralIRPackage.AFFINE_SYSTEM__WHILE_INFO:
				return basicSetWhileInfo(null, msgs);
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
			case PolyhedralIRPackage.AFFINE_SYSTEM__CONTAINER_PROGRAM:
				return eInternalContainer().eInverseRemove(this, PolyhedralIRPackage.PROGRAM__SYSTEMS, Program.class, msgs);
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
			case PolyhedralIRPackage.AFFINE_SYSTEM__CONTAINER_PROGRAM:
				return getContainerProgram();
			case PolyhedralIRPackage.AFFINE_SYSTEM__NAME:
				return getName();
			case PolyhedralIRPackage.AFFINE_SYSTEM__PARAMETERS:
				return getParameters();
			case PolyhedralIRPackage.AFFINE_SYSTEM__INPUTS:
				return getInputs();
			case PolyhedralIRPackage.AFFINE_SYSTEM__OUTPUTS:
				return getOutputs();
			case PolyhedralIRPackage.AFFINE_SYSTEM__LOCALS:
				return getLocals();
			case PolyhedralIRPackage.AFFINE_SYSTEM__EQUATIONS:
				return getEquations();
			case PolyhedralIRPackage.AFFINE_SYSTEM__USE_EQUATIONS:
				return getUseEquations();
			case PolyhedralIRPackage.AFFINE_SYSTEM__TARGET_MAPPING:
				return getTargetMapping();
			case PolyhedralIRPackage.AFFINE_SYSTEM__WHILE_INFO:
				return getWhileInfo();
			case PolyhedralIRPackage.AFFINE_SYSTEM__TILING_INFO:
				if (resolve) return getTilingInfo();
				return basicGetTilingInfo();
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
			case PolyhedralIRPackage.AFFINE_SYSTEM__NAME:
				setName((String)newValue);
				return;
			case PolyhedralIRPackage.AFFINE_SYSTEM__PARAMETERS:
				setParameters((ParameterDomain)newValue);
				return;
			case PolyhedralIRPackage.AFFINE_SYSTEM__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends VariableDeclaration>)newValue);
				return;
			case PolyhedralIRPackage.AFFINE_SYSTEM__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends VariableDeclaration>)newValue);
				return;
			case PolyhedralIRPackage.AFFINE_SYSTEM__LOCALS:
				getLocals().clear();
				getLocals().addAll((Collection<? extends VariableDeclaration>)newValue);
				return;
			case PolyhedralIRPackage.AFFINE_SYSTEM__EQUATIONS:
				getEquations().clear();
				getEquations().addAll((Collection<? extends StandardEquation>)newValue);
				return;
			case PolyhedralIRPackage.AFFINE_SYSTEM__USE_EQUATIONS:
				getUseEquations().clear();
				getUseEquations().addAll((Collection<? extends UseEquation>)newValue);
				return;
			case PolyhedralIRPackage.AFFINE_SYSTEM__TARGET_MAPPING:
				setTargetMapping((TargetMapping)newValue);
				return;
			case PolyhedralIRPackage.AFFINE_SYSTEM__WHILE_INFO:
				setWhileInfo((WhileInfo)newValue);
				return;
			case PolyhedralIRPackage.AFFINE_SYSTEM__TILING_INFO:
				setTilingInfo((TilingInformations)newValue);
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
			case PolyhedralIRPackage.AFFINE_SYSTEM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PolyhedralIRPackage.AFFINE_SYSTEM__PARAMETERS:
				setParameters((ParameterDomain)null);
				return;
			case PolyhedralIRPackage.AFFINE_SYSTEM__INPUTS:
				getInputs().clear();
				return;
			case PolyhedralIRPackage.AFFINE_SYSTEM__OUTPUTS:
				getOutputs().clear();
				return;
			case PolyhedralIRPackage.AFFINE_SYSTEM__LOCALS:
				getLocals().clear();
				return;
			case PolyhedralIRPackage.AFFINE_SYSTEM__EQUATIONS:
				getEquations().clear();
				return;
			case PolyhedralIRPackage.AFFINE_SYSTEM__USE_EQUATIONS:
				getUseEquations().clear();
				return;
			case PolyhedralIRPackage.AFFINE_SYSTEM__TARGET_MAPPING:
				setTargetMapping((TargetMapping)null);
				return;
			case PolyhedralIRPackage.AFFINE_SYSTEM__WHILE_INFO:
				setWhileInfo((WhileInfo)null);
				return;
			case PolyhedralIRPackage.AFFINE_SYSTEM__TILING_INFO:
				setTilingInfo((TilingInformations)null);
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
			case PolyhedralIRPackage.AFFINE_SYSTEM__CONTAINER_PROGRAM:
				return getContainerProgram() != null;
			case PolyhedralIRPackage.AFFINE_SYSTEM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PolyhedralIRPackage.AFFINE_SYSTEM__PARAMETERS:
				return parameters != null;
			case PolyhedralIRPackage.AFFINE_SYSTEM__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case PolyhedralIRPackage.AFFINE_SYSTEM__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
			case PolyhedralIRPackage.AFFINE_SYSTEM__LOCALS:
				return locals != null && !locals.isEmpty();
			case PolyhedralIRPackage.AFFINE_SYSTEM__EQUATIONS:
				return equations != null && !equations.isEmpty();
			case PolyhedralIRPackage.AFFINE_SYSTEM__USE_EQUATIONS:
				return useEquations != null && !useEquations.isEmpty();
			case PolyhedralIRPackage.AFFINE_SYSTEM__TARGET_MAPPING:
				return targetMapping != null;
			case PolyhedralIRPackage.AFFINE_SYSTEM__WHILE_INFO:
				return whileInfo != null;
			case PolyhedralIRPackage.AFFINE_SYSTEM__TILING_INFO:
				return tilingInfo != null;
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
		/*
		String input ;
		String output ;
		String params ;
		try {
			input = PrettyPrinter.separate((List)getInputs(), ",");
		} catch (Exception e) {
			input = "Error :"+e.getMessage();
		}
		try {
			output = PrettyPrinter.separate((List)getOutputs(), ",");
		} catch (Exception e) {
			output = "Error :"+e.getMessage();
		}
		try {
			params = PrettyPrinter.separate((List)getParameters(), ",");
		} catch (Exception e) {
			params = "Error :"+e.getMessage();
		}
		return "affine system " + name + "[" + params +"] : {"+input+"} returns {"+output+"}";*/
	}

} //AffineSystemImpl
