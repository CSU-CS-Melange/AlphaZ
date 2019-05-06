/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.DimensionsManager;
import org.polymodel.IndexDimension;
import org.polymodel.InputDimension;
import org.polymodel.OutputDimension;
import org.polymodel.PolymodelFactory;
import org.polymodel.PolymodelPackage;
import org.polymodel.PolymodelVisitor;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.prettyprinters.PolymodelPrettyPrinter;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Dimensions Manager</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.impl.DimensionsManagerImpl#getDimensions <em>Dimensions</em>}</li>
 *   <li>{@link org.polymodel.impl.DimensionsManagerImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.polymodel.impl.DimensionsManagerImpl#getInputsDimensions <em>Inputs Dimensions</em>}</li>
 *   <li>{@link org.polymodel.impl.DimensionsManagerImpl#getOutputsDimensions <em>Outputs Dimensions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DimensionsManagerImpl extends EObjectImpl implements
		DimensionsManager {
	/**
	 * The cached value of the '{@link #getDimensions() <em>Dimensions</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDimensions()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> dimensions;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> parameters;

	/**
	 * The cached value of the '{@link #getInputsDimensions()
	 * <em>Inputs Dimensions</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInputsDimensions()
	 * @generated
	 * @ordered
	 */
	protected EList<InputDimension> inputsDimensions;

	/**
	 * The cached value of the '{@link #getOutputsDimensions()
	 * <em>Outputs Dimensions</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOutputsDimensions()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputDimension> outputsDimensions;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected DimensionsManagerImpl() {
		super();
		this.positionToDimMap = new HashMap<Integer, IndexDimension>();
		this.dimToInputMap = new HashMap<Variable, InputDimension>();
		this.dimToOutputMap = new HashMap<Variable, OutputDimension>();
		this.dimensionsComparator = new IndexDimensionComparator();
		this.nameToParam = new HashMap<Integer, IndexDimension>();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolymodelPackage.Literals.DIMENSIONS_MANAGER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getDimensions() {
		if (dimensions == null) {
			dimensions = new EObjectContainmentEList<Variable>(Variable.class, this, PolymodelPackage.DIMENSIONS_MANAGER__DIMENSIONS);
		}
		return dimensions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Variable>(Variable.class, this, PolymodelPackage.DIMENSIONS_MANAGER__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputDimension> getInputsDimensions() {
		if (inputsDimensions == null) {
			inputsDimensions = new EObjectContainmentEList<InputDimension>(InputDimension.class, this, PolymodelPackage.DIMENSIONS_MANAGER__INPUTS_DIMENSIONS);
		}
		return inputsDimensions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutputDimension> getOutputsDimensions() {
		if (outputsDimensions == null) {
			outputsDimensions = new EObjectContainmentEList<OutputDimension>(OutputDimension.class, this, PolymodelPackage.DIMENSIONS_MANAGER__OUTPUTS_DIMENSIONS);
		}
		return outputsDimensions;
	}

	protected Comparator<Variable> dimensionsComparator;

	private Map<Integer, IndexDimension> positionToDimMap;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Variable getDimension(int position) {
		return getDimension(position, "j" + position);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Variable getDimension(int position, String name) {
		IndexDimension d = positionToDimMap.get(position);
		if (d == null || !d.getName().equals(name)) {
			d = PolymodelFactory.eINSTANCE.createIndexDimension();
			d.setDimension(position);
			d.setName(name);
			positionToDimMap.put(position, d);
			getDimensions().add(d);
			ECollections.sort(getDimensions(), dimensionsComparator);
		}
		
		return d;
	}

	private Map<Variable, InputDimension> dimToInputMap;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public InputDimension getInputDimension(Variable var) {
		InputDimension inputDimension = dimToInputMap.get(var);
		if (inputDimension == null) {
			inputDimension = PolymodelFactory.eINSTANCE.createInputDimension();
			inputDimension.setDimension(var);
			inputDimension.setName("in_"+var.getName());
			dimToInputMap.put(var, inputDimension);
			getInputsDimensions().add(inputDimension);
		}
		return inputDimension;
	}
	

	public List<InputDimension> getInputsDimensionsFor(List<? extends Variable> dims){
		List<InputDimension> idims = new BasicEList<InputDimension>();
		for (Variable v : dims) {
			idims.add(getInputDimension(v));
		}
		return idims;
	}

	private Map<Variable, OutputDimension> dimToOutputMap;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public OutputDimension getOutputDimension(Variable var) {
		OutputDimension outputDimension = dimToOutputMap.get(var);
		if (outputDimension == null) {
			outputDimension = PolymodelFactory.eINSTANCE
					.createOutputDimension();
			outputDimension.setDimension(var);
			outputDimension.setName("out_"+var.getName());
			dimToOutputMap.put(var, outputDimension);
			getOutputsDimensions().add(outputDimension);

		}
		return outputDimension;
	}
	

	public List<OutputDimension> getOutputsDimensionsFor(List<? extends Variable> dims){
		List<OutputDimension> odims = new BasicEList<OutputDimension>();
		for (Variable v : dims) {
			odims.add(getOutputDimension(v));
		}
		return odims;
	}

	private Map<Integer,IndexDimension> nameToParam;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Variable getParameter(int position) {
		return getParameter(position, "p"+position);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Variable getParameter(int position, String name) {
		IndexDimension d = nameToParam.get(position);
		if (d == null) {
			d = PolymodelFactory.eINSTANCE.createIndexDimension();
			d.setDimension(position);
			d.setName(name);
			nameToParam.put(position, d);
			getParameters().add(d);
			ECollections.sort(getParameters(), dimensionsComparator);
		}
		return d;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolymodelVisitor visitor) {
		visitor.visitDimensionsManager(this);
	}

	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolymodelPackage.DIMENSIONS_MANAGER__DIMENSIONS:
				return ((InternalEList<?>)getDimensions()).basicRemove(otherEnd, msgs);
			case PolymodelPackage.DIMENSIONS_MANAGER__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case PolymodelPackage.DIMENSIONS_MANAGER__INPUTS_DIMENSIONS:
				return ((InternalEList<?>)getInputsDimensions()).basicRemove(otherEnd, msgs);
			case PolymodelPackage.DIMENSIONS_MANAGER__OUTPUTS_DIMENSIONS:
				return ((InternalEList<?>)getOutputsDimensions()).basicRemove(otherEnd, msgs);
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
			case PolymodelPackage.DIMENSIONS_MANAGER__DIMENSIONS:
				return getDimensions();
			case PolymodelPackage.DIMENSIONS_MANAGER__PARAMETERS:
				return getParameters();
			case PolymodelPackage.DIMENSIONS_MANAGER__INPUTS_DIMENSIONS:
				return getInputsDimensions();
			case PolymodelPackage.DIMENSIONS_MANAGER__OUTPUTS_DIMENSIONS:
				return getOutputsDimensions();
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
			case PolymodelPackage.DIMENSIONS_MANAGER__DIMENSIONS:
				getDimensions().clear();
				getDimensions().addAll((Collection<? extends Variable>)newValue);
				return;
			case PolymodelPackage.DIMENSIONS_MANAGER__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Variable>)newValue);
				return;
			case PolymodelPackage.DIMENSIONS_MANAGER__INPUTS_DIMENSIONS:
				getInputsDimensions().clear();
				getInputsDimensions().addAll((Collection<? extends InputDimension>)newValue);
				return;
			case PolymodelPackage.DIMENSIONS_MANAGER__OUTPUTS_DIMENSIONS:
				getOutputsDimensions().clear();
				getOutputsDimensions().addAll((Collection<? extends OutputDimension>)newValue);
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
			case PolymodelPackage.DIMENSIONS_MANAGER__DIMENSIONS:
				getDimensions().clear();
				return;
			case PolymodelPackage.DIMENSIONS_MANAGER__PARAMETERS:
				getParameters().clear();
				return;
			case PolymodelPackage.DIMENSIONS_MANAGER__INPUTS_DIMENSIONS:
				getInputsDimensions().clear();
				return;
			case PolymodelPackage.DIMENSIONS_MANAGER__OUTPUTS_DIMENSIONS:
				getOutputsDimensions().clear();
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
			case PolymodelPackage.DIMENSIONS_MANAGER__DIMENSIONS:
				return dimensions != null && !dimensions.isEmpty();
			case PolymodelPackage.DIMENSIONS_MANAGER__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case PolymodelPackage.DIMENSIONS_MANAGER__INPUTS_DIMENSIONS:
				return inputsDimensions != null && !inputsDimensions.isEmpty();
			case PolymodelPackage.DIMENSIONS_MANAGER__OUTPUTS_DIMENSIONS:
				return outputsDimensions != null && !outputsDimensions.isEmpty();
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
			case PolymodelPackage.DIMENSIONS_MANAGER___GET_DIMENSION__INT:
				return getDimension((Integer)arguments.get(0));
			case PolymodelPackage.DIMENSIONS_MANAGER___GET_DIMENSION__INT_STRING:
				return getDimension((Integer)arguments.get(0), (String)arguments.get(1));
			case PolymodelPackage.DIMENSIONS_MANAGER___GET_INPUT_DIMENSION__VARIABLE:
				return getInputDimension((Variable)arguments.get(0));
			case PolymodelPackage.DIMENSIONS_MANAGER___GET_OUTPUT_DIMENSION__VARIABLE:
				return getOutputDimension((Variable)arguments.get(0));
			case PolymodelPackage.DIMENSIONS_MANAGER___GET_PARAMETER__INT:
				return getParameter((Integer)arguments.get(0));
			case PolymodelPackage.DIMENSIONS_MANAGER___GET_PARAMETER__INT_STRING:
				return getParameter((Integer)arguments.get(0), (String)arguments.get(1));
			case PolymodelPackage.DIMENSIONS_MANAGER___ACCEPT__POLYMODELVISITOR:
				accept((PolymodelVisitor)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	private static class IndexDimensionComparator implements
			Comparator<Variable> {

		private Integer evaluate(Variable v) {
			return ((IndexDimension) v).getDimension();
		}

		public int compare(Variable arg0, Variable arg1) {
			return evaluate(arg0).compareTo(evaluate(arg1));
		}
	}

	public List<Variable> getAllVariables() {
		List<Variable> allVariables = new ArrayList<Variable>(getParameters());
		allVariables.addAll(getDimensions());
		return allVariables;
	}

	public String toString(OUTPUT_FORMAT format) {
		return PolymodelPrettyPrinter.print(this, format);
	}

} // DimensionsManagerImpl
