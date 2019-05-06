/**
 */
package edu.csu.melange.alphabets.xtext.alphabets.impl;

import edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem;
import edu.csu.melange.alphabets.xtext.alphabets.ADomain;
import edu.csu.melange.alphabets.xtext.alphabets.AEquation;
import edu.csu.melange.alphabets.xtext.alphabets.AInputDeclaration;
import edu.csu.melange.alphabets.xtext.alphabets.ALocalDeclaration;
import edu.csu.melange.alphabets.xtext.alphabets.AOutputDeclaration;
import edu.csu.melange.alphabets.xtext.alphabets.AWhileDeclaration;
import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage;

import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsVisitor;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AAffine System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AAffineSystemImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AAffineSystemImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AAffineSystemImpl#getInputDeclarations <em>Input Declarations</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AAffineSystemImpl#getOutputDeclarations <em>Output Declarations</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AAffineSystemImpl#getLocalvarDeclarations <em>Localvar Declarations</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AAffineSystemImpl#getWhileDeclaration <em>While Declaration</em>}</li>
 *   <li>{@link edu.csu.melange.alphabets.xtext.alphabets.impl.AAffineSystemImpl#getEquations <em>Equations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AAffineSystemImpl extends MinimalEObjectImpl.Container implements AAffineSystem
{
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
  protected ADomain parameters;

  /**
	 * The cached value of the '{@link #getInputDeclarations() <em>Input Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getInputDeclarations()
	 * @generated
	 * @ordered
	 */
  protected EList<AInputDeclaration> inputDeclarations;

  /**
	 * The cached value of the '{@link #getOutputDeclarations() <em>Output Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getOutputDeclarations()
	 * @generated
	 * @ordered
	 */
  protected EList<AOutputDeclaration> outputDeclarations;

  /**
	 * The cached value of the '{@link #getLocalvarDeclarations() <em>Localvar Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLocalvarDeclarations()
	 * @generated
	 * @ordered
	 */
  protected EList<ALocalDeclaration> localvarDeclarations;

  /**
	 * The cached value of the '{@link #getWhileDeclaration() <em>While Declaration</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getWhileDeclaration()
	 * @generated
	 * @ordered
	 */
  protected AWhileDeclaration whileDeclaration;

  /**
	 * The cached value of the '{@link #getEquations() <em>Equations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getEquations()
	 * @generated
	 * @ordered
	 */
  protected EList<AEquation> equations;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected AAffineSystemImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass()
  {
		return AlphabetsPackage.Literals.AAFFINE_SYSTEM;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getName()
  {
		return name;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setName(String newName)
  {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AAFFINE_SYSTEM__NAME, oldName, name));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ADomain getParameters()
  {
		return parameters;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetParameters(ADomain newParameters, NotificationChain msgs)
  {
		ADomain oldParameters = parameters;
		parameters = newParameters;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AAFFINE_SYSTEM__PARAMETERS, oldParameters, newParameters);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setParameters(ADomain newParameters)
  {
		if (newParameters != parameters) {
			NotificationChain msgs = null;
			if (parameters != null)
				msgs = ((InternalEObject)parameters).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AAFFINE_SYSTEM__PARAMETERS, null, msgs);
			if (newParameters != null)
				msgs = ((InternalEObject)newParameters).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AAFFINE_SYSTEM__PARAMETERS, null, msgs);
			msgs = basicSetParameters(newParameters, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AAFFINE_SYSTEM__PARAMETERS, newParameters, newParameters));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<AInputDeclaration> getInputDeclarations()
  {
		if (inputDeclarations == null) {
			inputDeclarations = new EObjectContainmentEList<AInputDeclaration>(AInputDeclaration.class, this, AlphabetsPackage.AAFFINE_SYSTEM__INPUT_DECLARATIONS);
		}
		return inputDeclarations;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<AOutputDeclaration> getOutputDeclarations()
  {
		if (outputDeclarations == null) {
			outputDeclarations = new EObjectContainmentEList<AOutputDeclaration>(AOutputDeclaration.class, this, AlphabetsPackage.AAFFINE_SYSTEM__OUTPUT_DECLARATIONS);
		}
		return outputDeclarations;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<ALocalDeclaration> getLocalvarDeclarations()
  {
		if (localvarDeclarations == null) {
			localvarDeclarations = new EObjectContainmentEList<ALocalDeclaration>(ALocalDeclaration.class, this, AlphabetsPackage.AAFFINE_SYSTEM__LOCALVAR_DECLARATIONS);
		}
		return localvarDeclarations;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AWhileDeclaration getWhileDeclaration()
  {
		return whileDeclaration;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetWhileDeclaration(AWhileDeclaration newWhileDeclaration, NotificationChain msgs)
  {
		AWhileDeclaration oldWhileDeclaration = whileDeclaration;
		whileDeclaration = newWhileDeclaration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AAFFINE_SYSTEM__WHILE_DECLARATION, oldWhileDeclaration, newWhileDeclaration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setWhileDeclaration(AWhileDeclaration newWhileDeclaration)
  {
		if (newWhileDeclaration != whileDeclaration) {
			NotificationChain msgs = null;
			if (whileDeclaration != null)
				msgs = ((InternalEObject)whileDeclaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AAFFINE_SYSTEM__WHILE_DECLARATION, null, msgs);
			if (newWhileDeclaration != null)
				msgs = ((InternalEObject)newWhileDeclaration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlphabetsPackage.AAFFINE_SYSTEM__WHILE_DECLARATION, null, msgs);
			msgs = basicSetWhileDeclaration(newWhileDeclaration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphabetsPackage.AAFFINE_SYSTEM__WHILE_DECLARATION, newWhileDeclaration, newWhileDeclaration));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<AEquation> getEquations()
  {
		if (equations == null) {
			equations = new EObjectContainmentEList<AEquation>(AEquation.class, this, AlphabetsPackage.AAFFINE_SYSTEM__EQUATIONS);
		}
		return equations;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final AlphabetsVisitor visitor) {
		visitor.visitAAffineSystem(this);
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case AlphabetsPackage.AAFFINE_SYSTEM__PARAMETERS:
				return basicSetParameters(null, msgs);
			case AlphabetsPackage.AAFFINE_SYSTEM__INPUT_DECLARATIONS:
				return ((InternalEList<?>)getInputDeclarations()).basicRemove(otherEnd, msgs);
			case AlphabetsPackage.AAFFINE_SYSTEM__OUTPUT_DECLARATIONS:
				return ((InternalEList<?>)getOutputDeclarations()).basicRemove(otherEnd, msgs);
			case AlphabetsPackage.AAFFINE_SYSTEM__LOCALVAR_DECLARATIONS:
				return ((InternalEList<?>)getLocalvarDeclarations()).basicRemove(otherEnd, msgs);
			case AlphabetsPackage.AAFFINE_SYSTEM__WHILE_DECLARATION:
				return basicSetWhileDeclaration(null, msgs);
			case AlphabetsPackage.AAFFINE_SYSTEM__EQUATIONS:
				return ((InternalEList<?>)getEquations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
		switch (featureID) {
			case AlphabetsPackage.AAFFINE_SYSTEM__NAME:
				return getName();
			case AlphabetsPackage.AAFFINE_SYSTEM__PARAMETERS:
				return getParameters();
			case AlphabetsPackage.AAFFINE_SYSTEM__INPUT_DECLARATIONS:
				return getInputDeclarations();
			case AlphabetsPackage.AAFFINE_SYSTEM__OUTPUT_DECLARATIONS:
				return getOutputDeclarations();
			case AlphabetsPackage.AAFFINE_SYSTEM__LOCALVAR_DECLARATIONS:
				return getLocalvarDeclarations();
			case AlphabetsPackage.AAFFINE_SYSTEM__WHILE_DECLARATION:
				return getWhileDeclaration();
			case AlphabetsPackage.AAFFINE_SYSTEM__EQUATIONS:
				return getEquations();
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
  public void eSet(int featureID, Object newValue)
  {
		switch (featureID) {
			case AlphabetsPackage.AAFFINE_SYSTEM__NAME:
				setName((String)newValue);
				return;
			case AlphabetsPackage.AAFFINE_SYSTEM__PARAMETERS:
				setParameters((ADomain)newValue);
				return;
			case AlphabetsPackage.AAFFINE_SYSTEM__INPUT_DECLARATIONS:
				getInputDeclarations().clear();
				getInputDeclarations().addAll((Collection<? extends AInputDeclaration>)newValue);
				return;
			case AlphabetsPackage.AAFFINE_SYSTEM__OUTPUT_DECLARATIONS:
				getOutputDeclarations().clear();
				getOutputDeclarations().addAll((Collection<? extends AOutputDeclaration>)newValue);
				return;
			case AlphabetsPackage.AAFFINE_SYSTEM__LOCALVAR_DECLARATIONS:
				getLocalvarDeclarations().clear();
				getLocalvarDeclarations().addAll((Collection<? extends ALocalDeclaration>)newValue);
				return;
			case AlphabetsPackage.AAFFINE_SYSTEM__WHILE_DECLARATION:
				setWhileDeclaration((AWhileDeclaration)newValue);
				return;
			case AlphabetsPackage.AAFFINE_SYSTEM__EQUATIONS:
				getEquations().clear();
				getEquations().addAll((Collection<? extends AEquation>)newValue);
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
  public void eUnset(int featureID)
  {
		switch (featureID) {
			case AlphabetsPackage.AAFFINE_SYSTEM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AlphabetsPackage.AAFFINE_SYSTEM__PARAMETERS:
				setParameters((ADomain)null);
				return;
			case AlphabetsPackage.AAFFINE_SYSTEM__INPUT_DECLARATIONS:
				getInputDeclarations().clear();
				return;
			case AlphabetsPackage.AAFFINE_SYSTEM__OUTPUT_DECLARATIONS:
				getOutputDeclarations().clear();
				return;
			case AlphabetsPackage.AAFFINE_SYSTEM__LOCALVAR_DECLARATIONS:
				getLocalvarDeclarations().clear();
				return;
			case AlphabetsPackage.AAFFINE_SYSTEM__WHILE_DECLARATION:
				setWhileDeclaration((AWhileDeclaration)null);
				return;
			case AlphabetsPackage.AAFFINE_SYSTEM__EQUATIONS:
				getEquations().clear();
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
  public boolean eIsSet(int featureID)
  {
		switch (featureID) {
			case AlphabetsPackage.AAFFINE_SYSTEM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AlphabetsPackage.AAFFINE_SYSTEM__PARAMETERS:
				return parameters != null;
			case AlphabetsPackage.AAFFINE_SYSTEM__INPUT_DECLARATIONS:
				return inputDeclarations != null && !inputDeclarations.isEmpty();
			case AlphabetsPackage.AAFFINE_SYSTEM__OUTPUT_DECLARATIONS:
				return outputDeclarations != null && !outputDeclarations.isEmpty();
			case AlphabetsPackage.AAFFINE_SYSTEM__LOCALVAR_DECLARATIONS:
				return localvarDeclarations != null && !localvarDeclarations.isEmpty();
			case AlphabetsPackage.AAFFINE_SYSTEM__WHILE_DECLARATION:
				return whileDeclaration != null;
			case AlphabetsPackage.AAFFINE_SYSTEM__EQUATIONS:
				return equations != null && !equations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String toString()
  {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //AAffineSystemImpl
