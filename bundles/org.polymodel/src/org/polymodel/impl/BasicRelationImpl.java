/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.BasicRelation;
import org.polymodel.Label;
import org.polymodel.PolymodelPackage;
import org.polymodel.PolymodelVisitor;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.prettyprinters.PolymodelPrettyPrinter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.impl.BasicRelationImpl#getInput <em>Input</em>}</li>
 *   <li>{@link org.polymodel.impl.BasicRelationImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link org.polymodel.impl.BasicRelationImpl#getRelation <em>Relation</em>}</li>
 *   <li>{@link org.polymodel.impl.BasicRelationImpl#getIn <em>In</em>}</li>
 *   <li>{@link org.polymodel.impl.BasicRelationImpl#getOut <em>Out</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BasicRelationImpl extends EObjectImpl implements BasicRelation {
	/**
	 * The cached value of the '{@link #getInput() <em>Input</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected IntConstraintSystem input;

	/**
	 * The cached value of the '{@link #getOutput() <em>Output</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutput()
	 * @generated
	 * @ordered
	 */
	protected IntConstraintSystem output;

	/**
	 * The cached value of the '{@link #getRelation() <em>Relation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelation()
	 * @generated
	 * @ordered
	 */
	protected IntConstraintSystem relation;

	/**
	 * The cached value of the '{@link #getIn() <em>In</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIn()
	 * @generated
	 * @ordered
	 */
	protected Label in;

	/**
	 * The cached value of the '{@link #getOut() <em>Out</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOut()
	 * @generated
	 * @ordered
	 */
	protected Label out;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BasicRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolymodelPackage.Literals.BASIC_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntConstraintSystem getInput() {
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInput(IntConstraintSystem newInput, NotificationChain msgs) {
		IntConstraintSystem oldInput = input;
		input = newInput;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolymodelPackage.BASIC_RELATION__INPUT, oldInput, newInput);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInput(IntConstraintSystem newInput) {
		if (newInput != input) {
			NotificationChain msgs = null;
			if (input != null)
				msgs = ((InternalEObject)input).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolymodelPackage.BASIC_RELATION__INPUT, null, msgs);
			if (newInput != null)
				msgs = ((InternalEObject)newInput).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolymodelPackage.BASIC_RELATION__INPUT, null, msgs);
			msgs = basicSetInput(newInput, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolymodelPackage.BASIC_RELATION__INPUT, newInput, newInput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntConstraintSystem getOutput() {
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutput(IntConstraintSystem newOutput, NotificationChain msgs) {
		IntConstraintSystem oldOutput = output;
		output = newOutput;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolymodelPackage.BASIC_RELATION__OUTPUT, oldOutput, newOutput);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutput(IntConstraintSystem newOutput) {
		if (newOutput != output) {
			NotificationChain msgs = null;
			if (output != null)
				msgs = ((InternalEObject)output).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolymodelPackage.BASIC_RELATION__OUTPUT, null, msgs);
			if (newOutput != null)
				msgs = ((InternalEObject)newOutput).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolymodelPackage.BASIC_RELATION__OUTPUT, null, msgs);
			msgs = basicSetOutput(newOutput, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolymodelPackage.BASIC_RELATION__OUTPUT, newOutput, newOutput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntConstraintSystem getRelation() {
		return relation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRelation(IntConstraintSystem newRelation, NotificationChain msgs) {
		IntConstraintSystem oldRelation = relation;
		relation = newRelation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolymodelPackage.BASIC_RELATION__RELATION, oldRelation, newRelation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelation(IntConstraintSystem newRelation) {
		if (newRelation != relation) {
			NotificationChain msgs = null;
			if (relation != null)
				msgs = ((InternalEObject)relation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolymodelPackage.BASIC_RELATION__RELATION, null, msgs);
			if (newRelation != null)
				msgs = ((InternalEObject)newRelation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolymodelPackage.BASIC_RELATION__RELATION, null, msgs);
			msgs = basicSetRelation(newRelation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolymodelPackage.BASIC_RELATION__RELATION, newRelation, newRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Label getIn() {
		return in;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIn(Label newIn, NotificationChain msgs) {
		Label oldIn = in;
		in = newIn;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolymodelPackage.BASIC_RELATION__IN, oldIn, newIn);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIn(Label newIn) {
		if (newIn != in) {
			NotificationChain msgs = null;
			if (in != null)
				msgs = ((InternalEObject)in).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolymodelPackage.BASIC_RELATION__IN, null, msgs);
			if (newIn != null)
				msgs = ((InternalEObject)newIn).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolymodelPackage.BASIC_RELATION__IN, null, msgs);
			msgs = basicSetIn(newIn, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolymodelPackage.BASIC_RELATION__IN, newIn, newIn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Label getOut() {
		return out;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOut(Label newOut, NotificationChain msgs) {
		Label oldOut = out;
		out = newOut;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolymodelPackage.BASIC_RELATION__OUT, oldOut, newOut);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOut(Label newOut) {
		if (newOut != out) {
			NotificationChain msgs = null;
			if (out != null)
				msgs = ((InternalEObject)out).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolymodelPackage.BASIC_RELATION__OUT, null, msgs);
			if (newOut != null)
				msgs = ((InternalEObject)newOut).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolymodelPackage.BASIC_RELATION__OUT, null, msgs);
			msgs = basicSetOut(newOut, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolymodelPackage.BASIC_RELATION__OUT, newOut, newOut));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolymodelVisitor visitor) {
		visitor.visitBasicRelation(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolymodelPackage.BASIC_RELATION__INPUT:
				return basicSetInput(null, msgs);
			case PolymodelPackage.BASIC_RELATION__OUTPUT:
				return basicSetOutput(null, msgs);
			case PolymodelPackage.BASIC_RELATION__RELATION:
				return basicSetRelation(null, msgs);
			case PolymodelPackage.BASIC_RELATION__IN:
				return basicSetIn(null, msgs);
			case PolymodelPackage.BASIC_RELATION__OUT:
				return basicSetOut(null, msgs);
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
			case PolymodelPackage.BASIC_RELATION__INPUT:
				return getInput();
			case PolymodelPackage.BASIC_RELATION__OUTPUT:
				return getOutput();
			case PolymodelPackage.BASIC_RELATION__RELATION:
				return getRelation();
			case PolymodelPackage.BASIC_RELATION__IN:
				return getIn();
			case PolymodelPackage.BASIC_RELATION__OUT:
				return getOut();
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
			case PolymodelPackage.BASIC_RELATION__INPUT:
				setInput((IntConstraintSystem)newValue);
				return;
			case PolymodelPackage.BASIC_RELATION__OUTPUT:
				setOutput((IntConstraintSystem)newValue);
				return;
			case PolymodelPackage.BASIC_RELATION__RELATION:
				setRelation((IntConstraintSystem)newValue);
				return;
			case PolymodelPackage.BASIC_RELATION__IN:
				setIn((Label)newValue);
				return;
			case PolymodelPackage.BASIC_RELATION__OUT:
				setOut((Label)newValue);
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
			case PolymodelPackage.BASIC_RELATION__INPUT:
				setInput((IntConstraintSystem)null);
				return;
			case PolymodelPackage.BASIC_RELATION__OUTPUT:
				setOutput((IntConstraintSystem)null);
				return;
			case PolymodelPackage.BASIC_RELATION__RELATION:
				setRelation((IntConstraintSystem)null);
				return;
			case PolymodelPackage.BASIC_RELATION__IN:
				setIn((Label)null);
				return;
			case PolymodelPackage.BASIC_RELATION__OUT:
				setOut((Label)null);
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
			case PolymodelPackage.BASIC_RELATION__INPUT:
				return input != null;
			case PolymodelPackage.BASIC_RELATION__OUTPUT:
				return output != null;
			case PolymodelPackage.BASIC_RELATION__RELATION:
				return relation != null;
			case PolymodelPackage.BASIC_RELATION__IN:
				return in != null;
			case PolymodelPackage.BASIC_RELATION__OUT:
				return out != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case PolymodelPackage.BASIC_RELATION___ACCEPT__POLYMODELVISITOR:
				accept((PolymodelVisitor)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	public String toString(OUTPUT_FORMAT format) {
		return PolymodelPrettyPrinter.print(this, format);
	}

} //BasicRelationImpl
