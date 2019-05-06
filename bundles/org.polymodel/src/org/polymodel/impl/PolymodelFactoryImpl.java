/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polymodel.BasicRelation;
import org.polymodel.DimensionsManager;
import org.polymodel.Domain;
import org.polymodel.DomainDimensions;
import org.polymodel.ExistentialVariable;
import org.polymodel.Function;
import org.polymodel.IndexDimension;
import org.polymodel.InputDimension;
import org.polymodel.Label;
import org.polymodel.OutputDimension;
import org.polymodel.PolymodelFactory;
import org.polymodel.PolymodelPackage;
import org.polymodel.Relation;
import org.polymodel.RelationDimensions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PolymodelFactoryImpl extends EFactoryImpl implements PolymodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PolymodelFactory init() {
		try {
			PolymodelFactory thePolymodelFactory = (PolymodelFactory)EPackage.Registry.INSTANCE.getEFactory(PolymodelPackage.eNS_URI);
			if (thePolymodelFactory != null) {
				return thePolymodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PolymodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolymodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PolymodelPackage.DOMAIN: return createDomain();
			case PolymodelPackage.DIMENSIONS_MANAGER: return createDimensionsManager();
			case PolymodelPackage.EXISTENTIAL_VARIABLE: return createExistentialVariable();
			case PolymodelPackage.DOMAIN_DIMENSIONS: return createDomainDimensions();
			case PolymodelPackage.INDEX_DIMENSION: return createIndexDimension();
			case PolymodelPackage.RELATION_DIMENSIONS: return createRelationDimensions();
			case PolymodelPackage.BASIC_RELATION: return createBasicRelation();
			case PolymodelPackage.RELATION: return createRelation();
			case PolymodelPackage.FUNCTION: return createFunction();
			case PolymodelPackage.VALUE_CONTAINED_MAP: return (EObject)createValueContainedMap();
			case PolymodelPackage.LABEL: return createLabel();
			case PolymodelPackage.INPUT_DIMENSION: return createInputDimension();
			case PolymodelPackage.OUTPUT_DIMENSION: return createOutputDimension();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain createDomain() {
		DomainImpl domain = new DomainImpl();
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DimensionsManager createDimensionsManager() {
		DimensionsManagerImpl dimensionsManager = new DimensionsManagerImpl();
		return dimensionsManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExistentialVariable createExistentialVariable() {
		ExistentialVariableImpl existentialVariable = new ExistentialVariableImpl();
		return existentialVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainDimensions createDomainDimensions() {
		DomainDimensionsImpl domainDimensions = new DomainDimensionsImpl();
		return domainDimensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexDimension createIndexDimension() {
		IndexDimensionImpl indexDimension = new IndexDimensionImpl();
		return indexDimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationDimensions createRelationDimensions() {
		RelationDimensionsImpl relationDimensions = new RelationDimensionsImpl();
		return relationDimensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicRelation createBasicRelation() {
		BasicRelationImpl basicRelation = new BasicRelationImpl();
		return basicRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function createFunction() {
		FunctionImpl function = new FunctionImpl();
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <K, V> Map.Entry<K, V> createValueContainedMap() {
		ValueContainedMapImpl<K, V> valueContainedMap = new ValueContainedMapImpl<K, V>();
		return valueContainedMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation createRelation() {
		RelationImpl relation = new RelationImpl();
		return relation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Label createLabel() {
		LabelImpl label = new LabelImpl();
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputDimension createInputDimension() {
		InputDimensionImpl inputDimension = new InputDimensionImpl();
		return inputDimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputDimension createOutputDimension() {
		OutputDimensionImpl outputDimension = new OutputDimensionImpl();
		return outputDimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolymodelPackage getPolymodelPackage() {
		return (PolymodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PolymodelPackage getPackage() {
		return PolymodelPackage.eINSTANCE;
	}

} //PolymodelFactoryImpl
