/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.impl;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.algebra.Variable;
import org.polymodel.polyhedralIR.polyIRCG.AbstractVariable;
import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.CompileTimeParameter;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.FunctionSignature;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGUserFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.FunctionImpl#getCodeunit <em>Codeunit</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.FunctionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.FunctionImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.FunctionImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.FunctionImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.FunctionImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.FunctionImpl#getLocals <em>Locals</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.FunctionImpl#getSpecialLocals <em>Special Locals</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.FunctionImpl#getBodies <em>Bodies</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.FunctionImpl#isEntryPoint <em>Entry Point</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.FunctionImpl#isInlined <em>Inlined</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.FunctionImpl#getNumberOfTimeIterationsForFirstConditionCheck <em>Number Of Time Iterations For First Condition Check</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.FunctionImpl#getSignature <em>Signature</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunctionImpl extends EObjectImpl implements Function {
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
	 * The default value of the '{@link #getReturnType() <em>Return Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturnType()
	 * @generated
	 * @ordered
	 */
	protected static final String RETURN_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturnType()
	 * @generated
	 * @ordered
	 */
	protected String returnType = RETURN_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractVariable> parameters;

	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractVariable> inputs;

	/**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractVariable> outputs;

	/**
	 * The cached value of the '{@link #getLocals() <em>Locals</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocals()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractVariable> locals;

	/**
	 * The cached value of the '{@link #getSpecialLocals() <em>Special Locals</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecialLocals()
	 * @generated
	 * @ordered
	 */
	protected EList<CodeGenVariable> specialLocals;

	/**
	 * The cached value of the '{@link #getBodies() <em>Bodies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodies()
	 * @generated
	 * @ordered
	 */
	protected EList<Body> bodies;

	/**
	 * The default value of the '{@link #isEntryPoint() <em>Entry Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEntryPoint()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENTRY_POINT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEntryPoint() <em>Entry Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEntryPoint()
	 * @generated
	 * @ordered
	 */
	protected boolean entryPoint = ENTRY_POINT_EDEFAULT;

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
	 * The default value of the '{@link #getNumberOfTimeIterationsForFirstConditionCheck() <em>Number Of Time Iterations For First Condition Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfTimeIterationsForFirstConditionCheck()
	 * @generated
	 * @ordered
	 */
	protected static final String NUMBER_OF_TIME_ITERATIONS_FOR_FIRST_CONDITION_CHECK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNumberOfTimeIterationsForFirstConditionCheck() <em>Number Of Time Iterations For First Condition Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfTimeIterationsForFirstConditionCheck()
	 * @generated
	 * @ordered
	 */
	protected String numberOfTimeIterationsForFirstConditionCheck = NUMBER_OF_TIME_ITERATIONS_FOR_FIRST_CONDITION_CHECK_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSignature() <em>Signature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignature()
	 * @generated
	 * @ordered
	 */
	protected FunctionSignature signature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyIRCGPackage.Literals.FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeUnit getCodeunit() {
		if (eContainerFeatureID() != PolyIRCGPackage.FUNCTION__CODEUNIT) return null;
		return (CodeUnit)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCodeunit(CodeUnit newCodeunit, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCodeunit, PolyIRCGPackage.FUNCTION__CODEUNIT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCodeunit(CodeUnit newCodeunit) {
		if (newCodeunit != eInternalContainer() || (eContainerFeatureID() != PolyIRCGPackage.FUNCTION__CODEUNIT && newCodeunit != null)) {
			if (EcoreUtil.isAncestor(this, newCodeunit))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCodeunit != null)
				msgs = ((InternalEObject)newCodeunit).eInverseAdd(this, PolyIRCGPackage.CODE_UNIT__FUNCTIONS, CodeUnit.class, msgs);
			msgs = basicSetCodeunit(newCodeunit, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.FUNCTION__CODEUNIT, newCodeunit, newCodeunit));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.FUNCTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReturnType() {
		return returnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturnType(String newReturnType) {
		String oldReturnType = returnType;
		returnType = newReturnType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.FUNCTION__RETURN_TYPE, oldReturnType, returnType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractVariable> getParameters() {
		if (parameters == null) {
			parameters = new EObjectResolvingEList<AbstractVariable>(AbstractVariable.class, this, PolyIRCGPackage.FUNCTION__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractVariable> getInputs() {
		if (inputs == null) {
			inputs = new EObjectResolvingEList<AbstractVariable>(AbstractVariable.class, this, PolyIRCGPackage.FUNCTION__INPUTS);
		}
		return inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractVariable> getOutputs() {
		if (outputs == null) {
			outputs = new EObjectResolvingEList<AbstractVariable>(AbstractVariable.class, this, PolyIRCGPackage.FUNCTION__OUTPUTS);
		}
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractVariable> getLocals() {
		if (locals == null) {
			locals = new EObjectResolvingEList<AbstractVariable>(AbstractVariable.class, this, PolyIRCGPackage.FUNCTION__LOCALS);
		}
		return locals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Body> getBodies() {
		if (bodies == null) {
			bodies = new EObjectContainmentWithInverseEList<Body>(Body.class, this, PolyIRCGPackage.FUNCTION__BODIES, PolyIRCGPackage.BODY__FUNCTION);
		}
		return bodies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEntryPoint() {
		return entryPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntryPoint(boolean newEntryPoint) {
		boolean oldEntryPoint = entryPoint;
		entryPoint = newEntryPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.FUNCTION__ENTRY_POINT, oldEntryPoint, entryPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public FunctionSignature getSignature() {
		if (signature == null) {
			setSignature(getDefaultFunctionSignature(true));
		}
		
		return signature;
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSignature(FunctionSignature newSignature, NotificationChain msgs) {
		FunctionSignature oldSignature = signature;
		signature = newSignature;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.FUNCTION__SIGNATURE, oldSignature, newSignature);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignature(FunctionSignature newSignature) {
		if (newSignature != signature) {
			NotificationChain msgs = null;
			if (signature != null)
				msgs = ((InternalEObject)signature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolyIRCGPackage.FUNCTION__SIGNATURE, null, msgs);
			if (newSignature != null)
				msgs = ((InternalEObject)newSignature).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolyIRCGPackage.FUNCTION__SIGNATURE, null, msgs);
			msgs = basicSetSignature(newSignature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.FUNCTION__SIGNATURE, newSignature, newSignature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public FunctionSignature getDefaultFunctionSignature(boolean includeSystemParams) {

		FunctionSignature fs = PolyIRCGUserFactory.INSTANCE.createFunctionSignature(getName(), getReturnType());

		if (includeSystemParams) {
			//Parameters
			for (Variable iv : getCodeunit().getSystem().getParameters().getParams()) {
				boolean found = false;
				//skip local parameters if the function is the entry point
				// FIXME use of contains not possible
				if (this.isEntryPoint()) {
					for (Variable lparam : getCodeunit().getLocalParameters()) {
						if (iv.toString().compareTo(lparam.toString()) == 0) {
							found = true;
							break;
						}
					}
				}
				for (CompileTimeParameter ctp : getCodeunit().getCompileTimeParameters()) {
					if (ctp.getName().compareTo(iv.toString()) == 0) {
						found = true;
						break;
					}
				}
				if (!found) {
					//FIXME
					//assumes default name is used for tile size, tile size need to be int not long for icc to work
					//long is used so that address computation is performed with long without casting 
					if (iv.toString().matches("ts\\d+")) {
						fs.getParameters().add(PolyIRCGUserFactory.INSTANCE.createBasicVariable(iv.toString(), "int"));
					} else {
						fs.getParameters().add(PolyIRCGUserFactory.INSTANCE.createBasicVariable(iv.toString(), "long"));
					}
				}
			}
		}
		
		//Custom parameters
		for (AbstractVariable fp : getParameters()) {
			fs.getParameters().add(fp);
		}
 		
		
		//Inputs and outputs to this function
		List<AbstractVariable> inouts = new LinkedList<AbstractVariable>();
		inouts.addAll(getInputs());
		inouts.addAll(getOutputs());
		for (AbstractVariable v : inouts) {
			fs.getParameters().add(v);
		}
		
		return fs;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.FUNCTION__INLINED, oldInlined, inlined));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNumberOfTimeIterationsForFirstConditionCheck() {
		return numberOfTimeIterationsForFirstConditionCheck;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfTimeIterationsForFirstConditionCheck(String newNumberOfTimeIterationsForFirstConditionCheck) {
		String oldNumberOfTimeIterationsForFirstConditionCheck = numberOfTimeIterationsForFirstConditionCheck;
		numberOfTimeIterationsForFirstConditionCheck = newNumberOfTimeIterationsForFirstConditionCheck;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.FUNCTION__NUMBER_OF_TIME_ITERATIONS_FOR_FIRST_CONDITION_CHECK, oldNumberOfTimeIterationsForFirstConditionCheck, numberOfTimeIterationsForFirstConditionCheck));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CodeGenVariable> getSpecialLocals() {
		if (specialLocals == null) {
			specialLocals = new EObjectResolvingEList<CodeGenVariable>(CodeGenVariable.class, this, PolyIRCGPackage.FUNCTION__SPECIAL_LOCALS);
		}
		return specialLocals;
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
			case PolyIRCGPackage.FUNCTION__CODEUNIT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCodeunit((CodeUnit)otherEnd, msgs);
			case PolyIRCGPackage.FUNCTION__BODIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBodies()).basicAdd(otherEnd, msgs);
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
			case PolyIRCGPackage.FUNCTION__CODEUNIT:
				return basicSetCodeunit(null, msgs);
			case PolyIRCGPackage.FUNCTION__BODIES:
				return ((InternalEList<?>)getBodies()).basicRemove(otherEnd, msgs);
			case PolyIRCGPackage.FUNCTION__SIGNATURE:
				return basicSetSignature(null, msgs);
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
			case PolyIRCGPackage.FUNCTION__CODEUNIT:
				return eInternalContainer().eInverseRemove(this, PolyIRCGPackage.CODE_UNIT__FUNCTIONS, CodeUnit.class, msgs);
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
			case PolyIRCGPackage.FUNCTION__CODEUNIT:
				return getCodeunit();
			case PolyIRCGPackage.FUNCTION__NAME:
				return getName();
			case PolyIRCGPackage.FUNCTION__RETURN_TYPE:
				return getReturnType();
			case PolyIRCGPackage.FUNCTION__PARAMETERS:
				return getParameters();
			case PolyIRCGPackage.FUNCTION__INPUTS:
				return getInputs();
			case PolyIRCGPackage.FUNCTION__OUTPUTS:
				return getOutputs();
			case PolyIRCGPackage.FUNCTION__LOCALS:
				return getLocals();
			case PolyIRCGPackage.FUNCTION__SPECIAL_LOCALS:
				return getSpecialLocals();
			case PolyIRCGPackage.FUNCTION__BODIES:
				return getBodies();
			case PolyIRCGPackage.FUNCTION__ENTRY_POINT:
				return isEntryPoint();
			case PolyIRCGPackage.FUNCTION__INLINED:
				return isInlined();
			case PolyIRCGPackage.FUNCTION__NUMBER_OF_TIME_ITERATIONS_FOR_FIRST_CONDITION_CHECK:
				return getNumberOfTimeIterationsForFirstConditionCheck();
			case PolyIRCGPackage.FUNCTION__SIGNATURE:
				return getSignature();
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
			case PolyIRCGPackage.FUNCTION__CODEUNIT:
				setCodeunit((CodeUnit)newValue);
				return;
			case PolyIRCGPackage.FUNCTION__NAME:
				setName((String)newValue);
				return;
			case PolyIRCGPackage.FUNCTION__RETURN_TYPE:
				setReturnType((String)newValue);
				return;
			case PolyIRCGPackage.FUNCTION__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends AbstractVariable>)newValue);
				return;
			case PolyIRCGPackage.FUNCTION__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends AbstractVariable>)newValue);
				return;
			case PolyIRCGPackage.FUNCTION__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends AbstractVariable>)newValue);
				return;
			case PolyIRCGPackage.FUNCTION__LOCALS:
				getLocals().clear();
				getLocals().addAll((Collection<? extends AbstractVariable>)newValue);
				return;
			case PolyIRCGPackage.FUNCTION__SPECIAL_LOCALS:
				getSpecialLocals().clear();
				getSpecialLocals().addAll((Collection<? extends CodeGenVariable>)newValue);
				return;
			case PolyIRCGPackage.FUNCTION__BODIES:
				getBodies().clear();
				getBodies().addAll((Collection<? extends Body>)newValue);
				return;
			case PolyIRCGPackage.FUNCTION__ENTRY_POINT:
				setEntryPoint((Boolean)newValue);
				return;
			case PolyIRCGPackage.FUNCTION__INLINED:
				setInlined((Boolean)newValue);
				return;
			case PolyIRCGPackage.FUNCTION__NUMBER_OF_TIME_ITERATIONS_FOR_FIRST_CONDITION_CHECK:
				setNumberOfTimeIterationsForFirstConditionCheck((String)newValue);
				return;
			case PolyIRCGPackage.FUNCTION__SIGNATURE:
				setSignature((FunctionSignature)newValue);
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
			case PolyIRCGPackage.FUNCTION__CODEUNIT:
				setCodeunit((CodeUnit)null);
				return;
			case PolyIRCGPackage.FUNCTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PolyIRCGPackage.FUNCTION__RETURN_TYPE:
				setReturnType(RETURN_TYPE_EDEFAULT);
				return;
			case PolyIRCGPackage.FUNCTION__PARAMETERS:
				getParameters().clear();
				return;
			case PolyIRCGPackage.FUNCTION__INPUTS:
				getInputs().clear();
				return;
			case PolyIRCGPackage.FUNCTION__OUTPUTS:
				getOutputs().clear();
				return;
			case PolyIRCGPackage.FUNCTION__LOCALS:
				getLocals().clear();
				return;
			case PolyIRCGPackage.FUNCTION__SPECIAL_LOCALS:
				getSpecialLocals().clear();
				return;
			case PolyIRCGPackage.FUNCTION__BODIES:
				getBodies().clear();
				return;
			case PolyIRCGPackage.FUNCTION__ENTRY_POINT:
				setEntryPoint(ENTRY_POINT_EDEFAULT);
				return;
			case PolyIRCGPackage.FUNCTION__INLINED:
				setInlined(INLINED_EDEFAULT);
				return;
			case PolyIRCGPackage.FUNCTION__NUMBER_OF_TIME_ITERATIONS_FOR_FIRST_CONDITION_CHECK:
				setNumberOfTimeIterationsForFirstConditionCheck(NUMBER_OF_TIME_ITERATIONS_FOR_FIRST_CONDITION_CHECK_EDEFAULT);
				return;
			case PolyIRCGPackage.FUNCTION__SIGNATURE:
				setSignature((FunctionSignature)null);
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
			case PolyIRCGPackage.FUNCTION__CODEUNIT:
				return getCodeunit() != null;
			case PolyIRCGPackage.FUNCTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PolyIRCGPackage.FUNCTION__RETURN_TYPE:
				return RETURN_TYPE_EDEFAULT == null ? returnType != null : !RETURN_TYPE_EDEFAULT.equals(returnType);
			case PolyIRCGPackage.FUNCTION__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case PolyIRCGPackage.FUNCTION__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case PolyIRCGPackage.FUNCTION__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
			case PolyIRCGPackage.FUNCTION__LOCALS:
				return locals != null && !locals.isEmpty();
			case PolyIRCGPackage.FUNCTION__SPECIAL_LOCALS:
				return specialLocals != null && !specialLocals.isEmpty();
			case PolyIRCGPackage.FUNCTION__BODIES:
				return bodies != null && !bodies.isEmpty();
			case PolyIRCGPackage.FUNCTION__ENTRY_POINT:
				return entryPoint != ENTRY_POINT_EDEFAULT;
			case PolyIRCGPackage.FUNCTION__INLINED:
				return inlined != INLINED_EDEFAULT;
			case PolyIRCGPackage.FUNCTION__NUMBER_OF_TIME_ITERATIONS_FOR_FIRST_CONDITION_CHECK:
				return NUMBER_OF_TIME_ITERATIONS_FOR_FIRST_CONDITION_CHECK_EDEFAULT == null ? numberOfTimeIterationsForFirstConditionCheck != null : !NUMBER_OF_TIME_ITERATIONS_FOR_FIRST_CONDITION_CHECK_EDEFAULT.equals(numberOfTimeIterationsForFirstConditionCheck);
			case PolyIRCGPackage.FUNCTION__SIGNATURE:
				return signature != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", returnType: ");
		result.append(returnType);
		result.append(", entryPoint: ");
		result.append(entryPoint);
		result.append(", inlined: ");
		result.append(inlined);
		result.append(", numberOfTimeIterationsForFirstConditionCheck: ");
		result.append(numberOfTimeIterationsForFirstConditionCheck);
		result.append(')');
		return result.toString();
	}

} //FunctionImpl
