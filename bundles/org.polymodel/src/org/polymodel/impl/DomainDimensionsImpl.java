/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.DomainDimensions;
import org.polymodel.ExistentialVariable;
import org.polymodel.PolymodelPackage;
import org.polymodel.PolymodelVisitor;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.prettyprinters.PolymodelPrettyPrinter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain Dimensions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.impl.DomainDimensionsImpl#getIndices <em>Indices</em>}</li>
 *   <li>{@link org.polymodel.impl.DomainDimensionsImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.polymodel.impl.DomainDimensionsImpl#getExistential <em>Existential</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DomainDimensionsImpl extends EObjectImpl implements DomainDimensions {
	/**
	 * The cached value of the '{@link #getIndices() <em>Indices</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndices()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> indices;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> parameters;

	/**
	 * The cached value of the '{@link #getExistential() <em>Existential</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExistential()
	 * @generated
	 * @ordered
	 */
	protected EList<ExistentialVariable> existential;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainDimensionsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolymodelPackage.Literals.DOMAIN_DIMENSIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getIndices() {
		if (indices == null) {
			indices = new EObjectResolvingEList<Variable>(Variable.class, this, PolymodelPackage.DOMAIN_DIMENSIONS__INDICES);
		}
		return indices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getParameters() {
		if (parameters == null) {
			parameters = new EObjectResolvingEList<Variable>(Variable.class, this, PolymodelPackage.DOMAIN_DIMENSIONS__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExistentialVariable> getExistential() {
		if (existential == null) {
			existential = new EObjectContainmentEList<ExistentialVariable>(ExistentialVariable.class, this, PolymodelPackage.DOMAIN_DIMENSIONS__EXISTENTIAL);
		}
		return existential;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DomainDimensions copy() {
		DomainDimensions copy = new DomainDimensionsImpl();
		copy.getIndices().addAll(getIndices());
		copy.getParameters().addAll(getParameters());
		
		for (ExistentialVariable ev : getExistential())
			copy.getExistential().add(EcoreUtil.copy(ev));
		
		return copy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolymodelVisitor visitor) {
		visitor.visitDomainDimensions(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getParameterDimensionOf(Variable variable) {
		for (int i = 0; i < getParameters().size(); i++) {
			if (getParameters().get(i).equals(variable)) return i;
		}
		
		return -1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getDimensionOf(Variable variable) {
		for (int i = 0; i < getIndices().size(); i++) {
			if (getIndices().get(i).equals(variable)) return i;
		}
		
		return -1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolymodelPackage.DOMAIN_DIMENSIONS__EXISTENTIAL:
				return ((InternalEList<?>)getExistential()).basicRemove(otherEnd, msgs);
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
			case PolymodelPackage.DOMAIN_DIMENSIONS__INDICES:
				return getIndices();
			case PolymodelPackage.DOMAIN_DIMENSIONS__PARAMETERS:
				return getParameters();
			case PolymodelPackage.DOMAIN_DIMENSIONS__EXISTENTIAL:
				return getExistential();
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
			case PolymodelPackage.DOMAIN_DIMENSIONS__INDICES:
				getIndices().clear();
				getIndices().addAll((Collection<? extends Variable>)newValue);
				return;
			case PolymodelPackage.DOMAIN_DIMENSIONS__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Variable>)newValue);
				return;
			case PolymodelPackage.DOMAIN_DIMENSIONS__EXISTENTIAL:
				getExistential().clear();
				getExistential().addAll((Collection<? extends ExistentialVariable>)newValue);
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
			case PolymodelPackage.DOMAIN_DIMENSIONS__INDICES:
				getIndices().clear();
				return;
			case PolymodelPackage.DOMAIN_DIMENSIONS__PARAMETERS:
				getParameters().clear();
				return;
			case PolymodelPackage.DOMAIN_DIMENSIONS__EXISTENTIAL:
				getExistential().clear();
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
			case PolymodelPackage.DOMAIN_DIMENSIONS__INDICES:
				return indices != null && !indices.isEmpty();
			case PolymodelPackage.DOMAIN_DIMENSIONS__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case PolymodelPackage.DOMAIN_DIMENSIONS__EXISTENTIAL:
				return existential != null && !existential.isEmpty();
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
			case PolymodelPackage.DOMAIN_DIMENSIONS___COPY:
				return copy();
			case PolymodelPackage.DOMAIN_DIMENSIONS___ACCEPT__POLYMODELVISITOR:
				accept((PolymodelVisitor)arguments.get(0));
				return null;
			case PolymodelPackage.DOMAIN_DIMENSIONS___GET_PARAMETER_DIMENSION_OF__VARIABLE:
				return getParameterDimensionOf((Variable)arguments.get(0));
			case PolymodelPackage.DOMAIN_DIMENSIONS___GET_DIMENSION_OF__VARIABLE:
				return getDimensionOf((Variable)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	public String toString(OUTPUT_FORMAT format) {
		return PolymodelPrettyPrinter.print(this, format);
	}
} //DomainDimensionsImpl
