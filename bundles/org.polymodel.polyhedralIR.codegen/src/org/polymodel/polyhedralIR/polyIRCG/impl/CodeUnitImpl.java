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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.algebra.Variable;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnitHeader;
import org.polymodel.polyhedralIR.polyIRCG.CompilationUnit;
import org.polymodel.polyhedralIR.polyIRCG.CompileTimeParameter;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.FunctionSignature;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Code Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.CodeUnitImpl#getCompilationUnit <em>Compilation Unit</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.CodeUnitImpl#getSystem <em>System</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.CodeUnitImpl#getHeaders <em>Headers</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.CodeUnitImpl#getFunctions <em>Functions</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.CodeUnitImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.CodeUnitImpl#getLocalParameters <em>Local Parameters</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.CodeUnitImpl#getCompileTimeParameters <em>Compile Time Parameters</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.CodeUnitImpl#getSubsystemFunctions <em>Subsystem Functions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CodeUnitImpl extends EObjectImpl implements CodeUnit {
	/**
	 * The cached value of the '{@link #getSystem() <em>System</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystem()
	 * @generated
	 * @ordered
	 */
	protected AffineSystem system;

	/**
	 * The cached value of the '{@link #getHeaders() <em>Headers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeaders()
	 * @generated
	 * @ordered
	 */
	protected EList<CodeUnitHeader> headers;

	/**
	 * The cached value of the '{@link #getFunctions() <em>Functions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctions()
	 * @generated
	 * @ordered
	 */
	protected EList<Function> functions;

	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractVariable> variables;

	/**
	 * The cached value of the '{@link #getLocalParameters() <em>Local Parameters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> localParameters;

	/**
	 * The cached value of the '{@link #getCompileTimeParameters() <em>Compile Time Parameters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompileTimeParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<CompileTimeParameter> compileTimeParameters;

	/**
	 * The cached value of the '{@link #getSubsystemFunctions() <em>Subsystem Functions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubsystemFunctions()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionSignature> subsystemFunctions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CodeUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyIRCGPackage.Literals.CODE_UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineSystem getSystem() {
		if (system != null && system.eIsProxy()) {
			InternalEObject oldSystem = (InternalEObject)system;
			system = (AffineSystem)eResolveProxy(oldSystem);
			if (system != oldSystem) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PolyIRCGPackage.CODE_UNIT__SYSTEM, oldSystem, system));
			}
		}
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AffineSystem basicGetSystem() {
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystem(AffineSystem newSystem) {
		AffineSystem oldSystem = system;
		system = newSystem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.CODE_UNIT__SYSTEM, oldSystem, system));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CodeUnitHeader> getHeaders() {
		if (headers == null) {
			headers = new EObjectContainmentEList<CodeUnitHeader>(CodeUnitHeader.class, this, PolyIRCGPackage.CODE_UNIT__HEADERS);
		}
		return headers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Function> getFunctions() {
		if (functions == null) {
			functions = new EObjectContainmentWithInverseEList<Function>(Function.class, this, PolyIRCGPackage.CODE_UNIT__FUNCTIONS, PolyIRCGPackage.FUNCTION__CODEUNIT);
		}
		return functions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractVariable> getVariables() {
		if (variables == null) {
			variables = new EObjectWithInverseResolvingEList<AbstractVariable>(AbstractVariable.class, this, PolyIRCGPackage.CODE_UNIT__VARIABLES, PolyIRCGPackage.ABSTRACT_VARIABLE__CODEUNIT);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompilationUnit getCompilationUnit() {
		if (eContainerFeatureID() != PolyIRCGPackage.CODE_UNIT__COMPILATION_UNIT) return null;
		return (CompilationUnit)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCompilationUnit(CompilationUnit newCompilationUnit, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCompilationUnit, PolyIRCGPackage.CODE_UNIT__COMPILATION_UNIT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompilationUnit(CompilationUnit newCompilationUnit) {
		if (newCompilationUnit != eInternalContainer() || (eContainerFeatureID() != PolyIRCGPackage.CODE_UNIT__COMPILATION_UNIT && newCompilationUnit != null)) {
			if (EcoreUtil.isAncestor(this, newCompilationUnit))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCompilationUnit != null)
				msgs = ((InternalEObject)newCompilationUnit).eInverseAdd(this, PolyIRCGPackage.COMPILATION_UNIT__UNITS, CompilationUnit.class, msgs);
			msgs = basicSetCompilationUnit(newCompilationUnit, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.CODE_UNIT__COMPILATION_UNIT, newCompilationUnit, newCompilationUnit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getLocalParameters() {
		if (localParameters == null) {
			localParameters = new EObjectResolvingEList<Variable>(Variable.class, this, PolyIRCGPackage.CODE_UNIT__LOCAL_PARAMETERS);
		}
		return localParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CompileTimeParameter> getCompileTimeParameters() {
		if (compileTimeParameters == null) {
			compileTimeParameters = new EObjectResolvingEList<CompileTimeParameter>(CompileTimeParameter.class, this, PolyIRCGPackage.CODE_UNIT__COMPILE_TIME_PARAMETERS);
		}
		return compileTimeParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FunctionSignature> getSubsystemFunctions() {
		if (subsystemFunctions == null) {
			subsystemFunctions = new EObjectResolvingEList<FunctionSignature>(FunctionSignature.class, this, PolyIRCGPackage.CODE_UNIT__SUBSYSTEM_FUNCTIONS);
		}
		return subsystemFunctions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AbstractVariable findVariable(String name) {
		//Search through the list
		for (AbstractVariable var : getVariables()) {
			if (var.getName().compareTo(name) == 0) {
				return var;
			}
		}
		
		throw new RuntimeException("AbstractVariable " + name + " not found in CodeUnit " + this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CodeGenVariable findCGVariable(String name) {
		//Search through the list
		for (AbstractVariable var : getVariables()) {
			if (var instanceof CodeGenVariable) {
				CodeGenVariable cgv = (CodeGenVariable)var;
				if (cgv.getName().compareTo(name) == 0) {
					return cgv;
				}
			}
		}
		
		throw new RuntimeException("Variable " + name + " not found in CodeUnit " + this);
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
			case PolyIRCGPackage.CODE_UNIT__COMPILATION_UNIT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCompilationUnit((CompilationUnit)otherEnd, msgs);
			case PolyIRCGPackage.CODE_UNIT__FUNCTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFunctions()).basicAdd(otherEnd, msgs);
			case PolyIRCGPackage.CODE_UNIT__VARIABLES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getVariables()).basicAdd(otherEnd, msgs);
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
			case PolyIRCGPackage.CODE_UNIT__COMPILATION_UNIT:
				return basicSetCompilationUnit(null, msgs);
			case PolyIRCGPackage.CODE_UNIT__HEADERS:
				return ((InternalEList<?>)getHeaders()).basicRemove(otherEnd, msgs);
			case PolyIRCGPackage.CODE_UNIT__FUNCTIONS:
				return ((InternalEList<?>)getFunctions()).basicRemove(otherEnd, msgs);
			case PolyIRCGPackage.CODE_UNIT__VARIABLES:
				return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
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
			case PolyIRCGPackage.CODE_UNIT__COMPILATION_UNIT:
				return eInternalContainer().eInverseRemove(this, PolyIRCGPackage.COMPILATION_UNIT__UNITS, CompilationUnit.class, msgs);
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
			case PolyIRCGPackage.CODE_UNIT__COMPILATION_UNIT:
				return getCompilationUnit();
			case PolyIRCGPackage.CODE_UNIT__SYSTEM:
				if (resolve) return getSystem();
				return basicGetSystem();
			case PolyIRCGPackage.CODE_UNIT__HEADERS:
				return getHeaders();
			case PolyIRCGPackage.CODE_UNIT__FUNCTIONS:
				return getFunctions();
			case PolyIRCGPackage.CODE_UNIT__VARIABLES:
				return getVariables();
			case PolyIRCGPackage.CODE_UNIT__LOCAL_PARAMETERS:
				return getLocalParameters();
			case PolyIRCGPackage.CODE_UNIT__COMPILE_TIME_PARAMETERS:
				return getCompileTimeParameters();
			case PolyIRCGPackage.CODE_UNIT__SUBSYSTEM_FUNCTIONS:
				return getSubsystemFunctions();
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
			case PolyIRCGPackage.CODE_UNIT__COMPILATION_UNIT:
				setCompilationUnit((CompilationUnit)newValue);
				return;
			case PolyIRCGPackage.CODE_UNIT__SYSTEM:
				setSystem((AffineSystem)newValue);
				return;
			case PolyIRCGPackage.CODE_UNIT__HEADERS:
				getHeaders().clear();
				getHeaders().addAll((Collection<? extends CodeUnitHeader>)newValue);
				return;
			case PolyIRCGPackage.CODE_UNIT__FUNCTIONS:
				getFunctions().clear();
				getFunctions().addAll((Collection<? extends Function>)newValue);
				return;
			case PolyIRCGPackage.CODE_UNIT__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends AbstractVariable>)newValue);
				return;
			case PolyIRCGPackage.CODE_UNIT__LOCAL_PARAMETERS:
				getLocalParameters().clear();
				getLocalParameters().addAll((Collection<? extends Variable>)newValue);
				return;
			case PolyIRCGPackage.CODE_UNIT__COMPILE_TIME_PARAMETERS:
				getCompileTimeParameters().clear();
				getCompileTimeParameters().addAll((Collection<? extends CompileTimeParameter>)newValue);
				return;
			case PolyIRCGPackage.CODE_UNIT__SUBSYSTEM_FUNCTIONS:
				getSubsystemFunctions().clear();
				getSubsystemFunctions().addAll((Collection<? extends FunctionSignature>)newValue);
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
			case PolyIRCGPackage.CODE_UNIT__COMPILATION_UNIT:
				setCompilationUnit((CompilationUnit)null);
				return;
			case PolyIRCGPackage.CODE_UNIT__SYSTEM:
				setSystem((AffineSystem)null);
				return;
			case PolyIRCGPackage.CODE_UNIT__HEADERS:
				getHeaders().clear();
				return;
			case PolyIRCGPackage.CODE_UNIT__FUNCTIONS:
				getFunctions().clear();
				return;
			case PolyIRCGPackage.CODE_UNIT__VARIABLES:
				getVariables().clear();
				return;
			case PolyIRCGPackage.CODE_UNIT__LOCAL_PARAMETERS:
				getLocalParameters().clear();
				return;
			case PolyIRCGPackage.CODE_UNIT__COMPILE_TIME_PARAMETERS:
				getCompileTimeParameters().clear();
				return;
			case PolyIRCGPackage.CODE_UNIT__SUBSYSTEM_FUNCTIONS:
				getSubsystemFunctions().clear();
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
			case PolyIRCGPackage.CODE_UNIT__COMPILATION_UNIT:
				return getCompilationUnit() != null;
			case PolyIRCGPackage.CODE_UNIT__SYSTEM:
				return system != null;
			case PolyIRCGPackage.CODE_UNIT__HEADERS:
				return headers != null && !headers.isEmpty();
			case PolyIRCGPackage.CODE_UNIT__FUNCTIONS:
				return functions != null && !functions.isEmpty();
			case PolyIRCGPackage.CODE_UNIT__VARIABLES:
				return variables != null && !variables.isEmpty();
			case PolyIRCGPackage.CODE_UNIT__LOCAL_PARAMETERS:
				return localParameters != null && !localParameters.isEmpty();
			case PolyIRCGPackage.CODE_UNIT__COMPILE_TIME_PARAMETERS:
				return compileTimeParameters != null && !compileTimeParameters.isEmpty();
			case PolyIRCGPackage.CODE_UNIT__SUBSYSTEM_FUNCTIONS:
				return subsystemFunctions != null && !subsystemFunctions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CodeUnitImpl
