/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.ExistentialVariable;
import org.polymodel.InputDimension;
import org.polymodel.OutputDimension;
import org.polymodel.PolymodelPackage;
import org.polymodel.PolymodelVisitor;
import org.polymodel.RelationDimensions;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.prettyprinters.PolymodelPrettyPrinter;

import com.google.common.collect.MapMaker;


/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Relation Dimensions</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.impl.RelationDimensionsImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.polymodel.impl.RelationDimensionsImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.polymodel.impl.RelationDimensionsImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.polymodel.impl.RelationDimensionsImpl#getExistential <em>Existential</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationDimensionsImpl extends EObjectImpl implements
		RelationDimensions {
	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<InputDimension> inputs;

	/**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputDimension> outputs;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> parameters;

	/**
	 * The cached value of the '{@link #getExistential() <em>Existential</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getExistential()
	 * @generated
	 * @ordered
	 */
	protected EList<ExistentialVariable> existential;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationDimensionsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolymodelPackage.Literals.RELATION_DIMENSIONS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputDimension> getInputs() {
		if (inputs == null) {
			inputs = new EObjectResolvingEList<InputDimension>(InputDimension.class, this, PolymodelPackage.RELATION_DIMENSIONS__INPUTS);
		}
		return inputs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutputDimension> getOutputs() {
		if (outputs == null) {
			outputs = new EObjectResolvingEList<OutputDimension>(OutputDimension.class, this, PolymodelPackage.RELATION_DIMENSIONS__OUTPUTS);
		}
		return outputs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getParameters() {
		if (parameters == null) {
			parameters = new EObjectResolvingEList<Variable>(Variable.class, this, PolymodelPackage.RELATION_DIMENSIONS__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExistentialVariable> getExistential() {
		if (existential == null) {
			existential = new EObjectContainmentEList<ExistentialVariable>(ExistentialVariable.class, this, PolymodelPackage.RELATION_DIMENSIONS__EXISTENTIAL);
		}
		return existential;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolymodelVisitor visitor) {
		visitor.visitRelationDimensions(this);
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
	public int getInputDimensionOf(Variable variable) {
		for (int i = 0; i < getInputs().size(); i++) {
			if (getInputs().get(i).equals(variable)) return i;
		}
		
		return -1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getOutputDimensionOf(Variable variable) {
		for (int i = 0; i < getOutputs().size(); i++) {
			if (getOutputs().get(i).equals(variable)) return i;
		}
		
		return -1;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolymodelPackage.RELATION_DIMENSIONS__EXISTENTIAL:
				return ((InternalEList<?>)getExistential()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PolymodelPackage.RELATION_DIMENSIONS__INPUTS:
				return getInputs();
			case PolymodelPackage.RELATION_DIMENSIONS__OUTPUTS:
				return getOutputs();
			case PolymodelPackage.RELATION_DIMENSIONS__PARAMETERS:
				return getParameters();
			case PolymodelPackage.RELATION_DIMENSIONS__EXISTENTIAL:
				return getExistential();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PolymodelPackage.RELATION_DIMENSIONS__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends InputDimension>)newValue);
				return;
			case PolymodelPackage.RELATION_DIMENSIONS__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends OutputDimension>)newValue);
				return;
			case PolymodelPackage.RELATION_DIMENSIONS__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Variable>)newValue);
				return;
			case PolymodelPackage.RELATION_DIMENSIONS__EXISTENTIAL:
				getExistential().clear();
				getExistential().addAll((Collection<? extends ExistentialVariable>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PolymodelPackage.RELATION_DIMENSIONS__INPUTS:
				getInputs().clear();
				return;
			case PolymodelPackage.RELATION_DIMENSIONS__OUTPUTS:
				getOutputs().clear();
				return;
			case PolymodelPackage.RELATION_DIMENSIONS__PARAMETERS:
				getParameters().clear();
				return;
			case PolymodelPackage.RELATION_DIMENSIONS__EXISTENTIAL:
				getExistential().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PolymodelPackage.RELATION_DIMENSIONS__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case PolymodelPackage.RELATION_DIMENSIONS__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
			case PolymodelPackage.RELATION_DIMENSIONS__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case PolymodelPackage.RELATION_DIMENSIONS__EXISTENTIAL:
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
			case PolymodelPackage.RELATION_DIMENSIONS___ACCEPT__POLYMODELVISITOR:
				accept((PolymodelVisitor)arguments.get(0));
				return null;
			case PolymodelPackage.RELATION_DIMENSIONS___GET_PARAMETER_DIMENSION_OF__VARIABLE:
				return getParameterDimensionOf((Variable)arguments.get(0));
			case PolymodelPackage.RELATION_DIMENSIONS___GET_INPUT_DIMENSION_OF__VARIABLE:
				return getInputDimensionOf((Variable)arguments.get(0));
			case PolymodelPackage.RELATION_DIMENSIONS___GET_OUTPUT_DIMENSION_OF__VARIABLE:
				return getOutputDimensionOf((Variable)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	//	@SuppressWarnings("deprecation")
	private Map<Variable, InputDimension> inputsMap = new MapMaker().weakValues()
			.makeMap();

	public InputDimension getInput(Variable v) {
		InputDimension result = inputsMap.get(v);
		if (result == null) {
			result = findInput(v);
			if(result!=null){
				inputsMap.put(v, result);
			}
		}
		return result;
	}

	private InputDimension findInput(Variable v) {
		for (InputDimension in : inputs) {
			if (in.getDimension() == v)
				return in;
		}
		return null;
	}
	
//	@SuppressWarnings("deprecation")
	private Map<Variable, OutputDimension> outputsMap = new MapMaker().weakValues()
	.makeMap();

	public OutputDimension getOutput(Variable v) {
		OutputDimension result = outputsMap.get(v);
		if (result == null) {
			result = findOutput(v);
			if(result!=null){
				outputsMap.put(v, result);
			}
		}
		return result;
	}

	
	private OutputDimension findOutput(Variable v) {
		for (OutputDimension out : outputs) {
			if (out.getDimension() == v)
				return out;
		}
		return null;
	}
	
	@Override
	public String toString() {
		StringBuffer bf = new StringBuffer();
		
		bf.append(this.getParameters());
		bf.append(" -> { ");
		bf.append(this.getInputs());
		bf.append(" -> ");
		bf.append(this.getOutputs());
		bf.append(" : ");
		bf.append(this.getExistential());
		bf.append(" }");
		
		return bf.toString();
	}
	

	public String toString(OUTPUT_FORMAT format) {
		return PolymodelPrettyPrinter.print(this, format);
	}
} // RelationDimensionsImpl
