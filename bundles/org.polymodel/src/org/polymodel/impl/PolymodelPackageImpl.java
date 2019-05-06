/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.polymodel.AbstractRelation;
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
import org.polymodel.PolymodelVisitable;
import org.polymodel.PolymodelVisitor;
import org.polymodel.Relation;
import org.polymodel.RelationDimension;
import org.polymodel.RelationDimensions;
import org.polymodel.algebra.AlgebraPackage;
import org.polymodel.matrix.MatrixPackage;
import org.polymodel.matrix.impl.MatrixPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PolymodelPackageImpl extends EPackageImpl implements PolymodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dimensionsManagerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass existentialVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainDimensionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass indexDimensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationDimensionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueContainedMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass labelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationDimensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputDimensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputDimensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass polymodelVisitorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass polymodelVisitableEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.polymodel.PolymodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PolymodelPackageImpl() {
		super(eNS_URI, PolymodelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link PolymodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PolymodelPackage init() {
		if (isInited) return (PolymodelPackage)EPackage.Registry.INSTANCE.getEPackage(PolymodelPackage.eNS_URI);

		// Obtain or create and register package
		PolymodelPackageImpl thePolymodelPackage = (PolymodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PolymodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PolymodelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		AlgebraPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		MatrixPackageImpl theMatrixPackage = (MatrixPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MatrixPackage.eNS_URI) instanceof MatrixPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MatrixPackage.eNS_URI) : MatrixPackage.eINSTANCE);

		// Create package meta-data objects
		thePolymodelPackage.createPackageContents();
		theMatrixPackage.createPackageContents();

		// Initialize created meta-data
		thePolymodelPackage.initializePackageContents();
		theMatrixPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePolymodelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PolymodelPackage.eNS_URI, thePolymodelPackage);
		return thePolymodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomain() {
		return domainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomain_Polyhedra() {
		return (EReference)domainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomain_Dimensions() {
		return (EReference)domainEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomain_Label() {
		return (EReference)domainEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDomain__Union__Domain() {
		return domainEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDomain__Image__AbstractRelation() {
		return domainEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDomain__Difference__Domain() {
		return domainEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDomain__Intersection__Domain() {
		return domainEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDomain__IsEmpty() {
		return domainEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDomain__Simplify__Domain() {
		return domainEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDomain__Simplify() {
		return domainEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDomain__BoundingBox() {
		return domainEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDomain__Equivalence__Domain() {
		return domainEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDomain__Accept__PolymodelVisitor() {
		return domainEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDomain__IsUniverse() {
		return domainEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDomain__LexMin() {
		return domainEClass.getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDomain__LexMax() {
		return domainEClass.getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDomain__DetectEqualities() {
		return domainEClass.getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDomain__AffineHull() {
		return domainEClass.getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDomain__PolyhedralHull() {
		return domainEClass.getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDomain__ToMatrices() {
		return domainEClass.getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDomain__Complement() {
		return domainEClass.getEOperations().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDomain__CartesianProduct__Domain() {
		return domainEClass.getEOperations().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDimensionsManager() {
		return dimensionsManagerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDimensionsManager_Dimensions() {
		return (EReference)dimensionsManagerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDimensionsManager_Parameters() {
		return (EReference)dimensionsManagerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDimensionsManager_InputsDimensions() {
		return (EReference)dimensionsManagerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDimensionsManager_OutputsDimensions() {
		return (EReference)dimensionsManagerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDimensionsManager__GetDimension__int() {
		return dimensionsManagerEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDimensionsManager__GetDimension__int_String() {
		return dimensionsManagerEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDimensionsManager__GetInputDimension__Variable() {
		return dimensionsManagerEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDimensionsManager__GetOutputDimension__Variable() {
		return dimensionsManagerEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDimensionsManager__GetParameter__int() {
		return dimensionsManagerEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDimensionsManager__GetParameter__int_String() {
		return dimensionsManagerEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDimensionsManager__Accept__PolymodelVisitor() {
		return dimensionsManagerEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractRelation() {
		return abstractRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractRelation_Dimensions() {
		return (EReference)abstractRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractRelation_BasicRelations() {
		return (EReference)abstractRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractRelation__Accept__PolymodelVisitor() {
		return abstractRelationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractRelation__Reverse__DimensionsManager() {
		return abstractRelationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractRelation__IsBijective() {
		return abstractRelationEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractRelation__IsSingleValued() {
		return abstractRelationEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractRelation__IsEmpty() {
		return abstractRelationEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractRelation__Equivalence__AbstractRelation() {
		return abstractRelationEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractRelation__IntersectDomain__Domain() {
		return abstractRelationEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractRelation__IntersectRange__Domain() {
		return abstractRelationEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractRelation__Intersection__AbstractRelation() {
		return abstractRelationEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractRelation__Union__AbstractRelation() {
		return abstractRelationEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractRelation__Difference__AbstractRelation() {
		return abstractRelationEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractRelation__BuildFunction() {
		return abstractRelationEClass.getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractRelation__GetDomain() {
		return abstractRelationEClass.getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractRelation__GetRange() {
		return abstractRelationEClass.getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractRelation__ApplyDomain__AbstractRelation() {
		return abstractRelationEClass.getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractRelation__ApplyRange__AbstractRelation() {
		return abstractRelationEClass.getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractRelation__TransitiveClosure() {
		return abstractRelationEClass.getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractRelation__ExactTransitiveClosure() {
		return abstractRelationEClass.getEOperations().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractRelation__Simplify() {
		return abstractRelationEClass.getEOperations().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractRelation__ToMatrices() {
		return abstractRelationEClass.getEOperations().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExistentialVariable() {
		return existentialVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExistentialVariable_Definition() {
		return (EReference)existentialVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExistentialVariable_Domain() {
		return (EReference)existentialVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExistentialVariable__Accept__PolymodelVisitor() {
		return existentialVariableEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomainDimensions() {
		return domainDimensionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainDimensions_Indices() {
		return (EReference)domainDimensionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainDimensions_Parameters() {
		return (EReference)domainDimensionsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainDimensions_Existential() {
		return (EReference)domainDimensionsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDomainDimensions__Copy() {
		return domainDimensionsEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDomainDimensions__Accept__PolymodelVisitor() {
		return domainDimensionsEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDomainDimensions__GetParameterDimensionOf__Variable() {
		return domainDimensionsEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDomainDimensions__GetDimensionOf__Variable() {
		return domainDimensionsEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIndexDimension() {
		return indexDimensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndexDimension_Dimension() {
		return (EAttribute)indexDimensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIndexDimension__Accept__PolymodelVisitor() {
		return indexDimensionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationDimensions() {
		return relationDimensionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationDimensions_Inputs() {
		return (EReference)relationDimensionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationDimensions_Outputs() {
		return (EReference)relationDimensionsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationDimensions_Parameters() {
		return (EReference)relationDimensionsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationDimensions_Existential() {
		return (EReference)relationDimensionsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationDimensions__Accept__PolymodelVisitor() {
		return relationDimensionsEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationDimensions__GetParameterDimensionOf__Variable() {
		return relationDimensionsEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationDimensions__GetInputDimensionOf__Variable() {
		return relationDimensionsEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationDimensions__GetOutputDimensionOf__Variable() {
		return relationDimensionsEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicRelation() {
		return basicRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicRelation_Input() {
		return (EReference)basicRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicRelation_Output() {
		return (EReference)basicRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicRelation_Relation() {
		return (EReference)basicRelationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicRelation_In() {
		return (EReference)basicRelationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicRelation_Out() {
		return (EReference)basicRelationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBasicRelation__Accept__PolymodelVisitor() {
		return basicRelationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunction() {
		return functionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_ExpressionsMap() {
		return (EReference)functionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_In() {
		return (EReference)functionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_Out() {
		return (EReference)functionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFunction__Accept__PolymodelVisitor() {
		return functionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFunction__GetExpression__int() {
		return functionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFunction__GetExpressions() {
		return functionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFunction__BuildRelation__DimensionsManager() {
		return functionEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFunction__Equivalence__Function() {
		return functionEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFunction__Compose__Function() {
		return functionEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFunction__Inverse__DimensionsManager() {
		return functionEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFunction__InverseInContext__DimensionsManager_Domain() {
		return functionEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFunction__ToMatrix() {
		return functionEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFunction__UniformizeInContext__Domain() {
		return functionEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFunction__Nullspace() {
		return functionEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFunction__LinearPart() {
		return functionEClass.getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFunction__LinearPartWithParameters() {
		return functionEClass.getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFunction__LinearPartAsFunction() {
		return functionEClass.getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFunction__ConstantPart() {
		return functionEClass.getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFunction__IsUniform() {
		return functionEClass.getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFunction__IsIdentity() {
		return functionEClass.getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_Dimensions() {
		return (EReference)functionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueContainedMap() {
		return valueContainedMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValueContainedMap_Key() {
		return (EReference)valueContainedMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValueContainedMap_Value() {
		return (EReference)valueContainedMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelation() {
		return relationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelation__Accept__PolymodelVisitor() {
		return relationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLabel() {
		return labelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLabel_Name() {
		return (EAttribute)labelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLabel__Accept__PolymodelVisitor() {
		return labelEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationDimension() {
		return relationDimensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationDimension_Dimension() {
		return (EReference)relationDimensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationDimension__Accept__PolymodelVisitor() {
		return relationDimensionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputDimension() {
		return inputDimensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInputDimension__Accept__PolymodelVisitor() {
		return inputDimensionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputDimension() {
		return outputDimensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOutputDimension__Accept__PolymodelVisitor() {
		return outputDimensionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPolymodelVisitor() {
		return polymodelVisitorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPolymodelVisitor__VisitDomain__Domain() {
		return polymodelVisitorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPolymodelVisitor__VisitDimensionsManager__DimensionsManager() {
		return polymodelVisitorEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPolymodelVisitor__VisitExistentialVariable__ExistentialVariable() {
		return polymodelVisitorEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPolymodelVisitor__VisitDomainDimensions__DomainDimensions() {
		return polymodelVisitorEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPolymodelVisitor__VisitIndexDimension__IndexDimension() {
		return polymodelVisitorEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPolymodelVisitor__VisitRelationDimensions__RelationDimensions() {
		return polymodelVisitorEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPolymodelVisitor__VisitBasicRelation__BasicRelation() {
		return polymodelVisitorEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPolymodelVisitor__VisitFunction__Function() {
		return polymodelVisitorEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPolymodelVisitor__VisitRelation__Relation() {
		return polymodelVisitorEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPolymodelVisitor__VisitLabel__Label() {
		return polymodelVisitorEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPolymodelVisitor__VisitInputDimension__InputDimension() {
		return polymodelVisitorEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPolymodelVisitor__VisitOutputDimension__OutputDimension() {
		return polymodelVisitorEClass.getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPolymodelVisitable() {
		return polymodelVisitableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPolymodelVisitable__Accept__PolymodelVisitor() {
		return polymodelVisitableEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolymodelFactory getPolymodelFactory() {
		return (PolymodelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		domainEClass = createEClass(DOMAIN);
		createEReference(domainEClass, DOMAIN__POLYHEDRA);
		createEReference(domainEClass, DOMAIN__DIMENSIONS);
		createEReference(domainEClass, DOMAIN__LABEL);
		createEOperation(domainEClass, DOMAIN___UNION__DOMAIN);
		createEOperation(domainEClass, DOMAIN___IMAGE__ABSTRACTRELATION);
		createEOperation(domainEClass, DOMAIN___DIFFERENCE__DOMAIN);
		createEOperation(domainEClass, DOMAIN___INTERSECTION__DOMAIN);
		createEOperation(domainEClass, DOMAIN___IS_EMPTY);
		createEOperation(domainEClass, DOMAIN___SIMPLIFY__DOMAIN);
		createEOperation(domainEClass, DOMAIN___SIMPLIFY);
		createEOperation(domainEClass, DOMAIN___BOUNDING_BOX);
		createEOperation(domainEClass, DOMAIN___EQUIVALENCE__DOMAIN);
		createEOperation(domainEClass, DOMAIN___ACCEPT__POLYMODELVISITOR);
		createEOperation(domainEClass, DOMAIN___IS_UNIVERSE);
		createEOperation(domainEClass, DOMAIN___LEX_MIN);
		createEOperation(domainEClass, DOMAIN___LEX_MAX);
		createEOperation(domainEClass, DOMAIN___DETECT_EQUALITIES);
		createEOperation(domainEClass, DOMAIN___AFFINE_HULL);
		createEOperation(domainEClass, DOMAIN___POLYHEDRAL_HULL);
		createEOperation(domainEClass, DOMAIN___TO_MATRICES);
		createEOperation(domainEClass, DOMAIN___COMPLEMENT);
		createEOperation(domainEClass, DOMAIN___CARTESIAN_PRODUCT__DOMAIN);

		dimensionsManagerEClass = createEClass(DIMENSIONS_MANAGER);
		createEReference(dimensionsManagerEClass, DIMENSIONS_MANAGER__DIMENSIONS);
		createEReference(dimensionsManagerEClass, DIMENSIONS_MANAGER__PARAMETERS);
		createEReference(dimensionsManagerEClass, DIMENSIONS_MANAGER__INPUTS_DIMENSIONS);
		createEReference(dimensionsManagerEClass, DIMENSIONS_MANAGER__OUTPUTS_DIMENSIONS);
		createEOperation(dimensionsManagerEClass, DIMENSIONS_MANAGER___GET_DIMENSION__INT);
		createEOperation(dimensionsManagerEClass, DIMENSIONS_MANAGER___GET_DIMENSION__INT_STRING);
		createEOperation(dimensionsManagerEClass, DIMENSIONS_MANAGER___GET_INPUT_DIMENSION__VARIABLE);
		createEOperation(dimensionsManagerEClass, DIMENSIONS_MANAGER___GET_OUTPUT_DIMENSION__VARIABLE);
		createEOperation(dimensionsManagerEClass, DIMENSIONS_MANAGER___GET_PARAMETER__INT);
		createEOperation(dimensionsManagerEClass, DIMENSIONS_MANAGER___GET_PARAMETER__INT_STRING);
		createEOperation(dimensionsManagerEClass, DIMENSIONS_MANAGER___ACCEPT__POLYMODELVISITOR);

		abstractRelationEClass = createEClass(ABSTRACT_RELATION);
		createEReference(abstractRelationEClass, ABSTRACT_RELATION__DIMENSIONS);
		createEReference(abstractRelationEClass, ABSTRACT_RELATION__BASIC_RELATIONS);
		createEOperation(abstractRelationEClass, ABSTRACT_RELATION___ACCEPT__POLYMODELVISITOR);
		createEOperation(abstractRelationEClass, ABSTRACT_RELATION___REVERSE__DIMENSIONSMANAGER);
		createEOperation(abstractRelationEClass, ABSTRACT_RELATION___IS_BIJECTIVE);
		createEOperation(abstractRelationEClass, ABSTRACT_RELATION___IS_SINGLE_VALUED);
		createEOperation(abstractRelationEClass, ABSTRACT_RELATION___IS_EMPTY);
		createEOperation(abstractRelationEClass, ABSTRACT_RELATION___EQUIVALENCE__ABSTRACTRELATION);
		createEOperation(abstractRelationEClass, ABSTRACT_RELATION___INTERSECT_DOMAIN__DOMAIN);
		createEOperation(abstractRelationEClass, ABSTRACT_RELATION___INTERSECT_RANGE__DOMAIN);
		createEOperation(abstractRelationEClass, ABSTRACT_RELATION___INTERSECTION__ABSTRACTRELATION);
		createEOperation(abstractRelationEClass, ABSTRACT_RELATION___UNION__ABSTRACTRELATION);
		createEOperation(abstractRelationEClass, ABSTRACT_RELATION___DIFFERENCE__ABSTRACTRELATION);
		createEOperation(abstractRelationEClass, ABSTRACT_RELATION___BUILD_FUNCTION);
		createEOperation(abstractRelationEClass, ABSTRACT_RELATION___GET_DOMAIN);
		createEOperation(abstractRelationEClass, ABSTRACT_RELATION___GET_RANGE);
		createEOperation(abstractRelationEClass, ABSTRACT_RELATION___APPLY_DOMAIN__ABSTRACTRELATION);
		createEOperation(abstractRelationEClass, ABSTRACT_RELATION___APPLY_RANGE__ABSTRACTRELATION);
		createEOperation(abstractRelationEClass, ABSTRACT_RELATION___TRANSITIVE_CLOSURE);
		createEOperation(abstractRelationEClass, ABSTRACT_RELATION___EXACT_TRANSITIVE_CLOSURE);
		createEOperation(abstractRelationEClass, ABSTRACT_RELATION___SIMPLIFY);
		createEOperation(abstractRelationEClass, ABSTRACT_RELATION___TO_MATRICES);

		existentialVariableEClass = createEClass(EXISTENTIAL_VARIABLE);
		createEReference(existentialVariableEClass, EXISTENTIAL_VARIABLE__DEFINITION);
		createEReference(existentialVariableEClass, EXISTENTIAL_VARIABLE__DOMAIN);
		createEOperation(existentialVariableEClass, EXISTENTIAL_VARIABLE___ACCEPT__POLYMODELVISITOR);

		domainDimensionsEClass = createEClass(DOMAIN_DIMENSIONS);
		createEReference(domainDimensionsEClass, DOMAIN_DIMENSIONS__INDICES);
		createEReference(domainDimensionsEClass, DOMAIN_DIMENSIONS__PARAMETERS);
		createEReference(domainDimensionsEClass, DOMAIN_DIMENSIONS__EXISTENTIAL);
		createEOperation(domainDimensionsEClass, DOMAIN_DIMENSIONS___COPY);
		createEOperation(domainDimensionsEClass, DOMAIN_DIMENSIONS___ACCEPT__POLYMODELVISITOR);
		createEOperation(domainDimensionsEClass, DOMAIN_DIMENSIONS___GET_PARAMETER_DIMENSION_OF__VARIABLE);
		createEOperation(domainDimensionsEClass, DOMAIN_DIMENSIONS___GET_DIMENSION_OF__VARIABLE);

		indexDimensionEClass = createEClass(INDEX_DIMENSION);
		createEAttribute(indexDimensionEClass, INDEX_DIMENSION__DIMENSION);
		createEOperation(indexDimensionEClass, INDEX_DIMENSION___ACCEPT__POLYMODELVISITOR);

		relationDimensionsEClass = createEClass(RELATION_DIMENSIONS);
		createEReference(relationDimensionsEClass, RELATION_DIMENSIONS__INPUTS);
		createEReference(relationDimensionsEClass, RELATION_DIMENSIONS__OUTPUTS);
		createEReference(relationDimensionsEClass, RELATION_DIMENSIONS__PARAMETERS);
		createEReference(relationDimensionsEClass, RELATION_DIMENSIONS__EXISTENTIAL);
		createEOperation(relationDimensionsEClass, RELATION_DIMENSIONS___ACCEPT__POLYMODELVISITOR);
		createEOperation(relationDimensionsEClass, RELATION_DIMENSIONS___GET_PARAMETER_DIMENSION_OF__VARIABLE);
		createEOperation(relationDimensionsEClass, RELATION_DIMENSIONS___GET_INPUT_DIMENSION_OF__VARIABLE);
		createEOperation(relationDimensionsEClass, RELATION_DIMENSIONS___GET_OUTPUT_DIMENSION_OF__VARIABLE);

		basicRelationEClass = createEClass(BASIC_RELATION);
		createEReference(basicRelationEClass, BASIC_RELATION__INPUT);
		createEReference(basicRelationEClass, BASIC_RELATION__OUTPUT);
		createEReference(basicRelationEClass, BASIC_RELATION__RELATION);
		createEReference(basicRelationEClass, BASIC_RELATION__IN);
		createEReference(basicRelationEClass, BASIC_RELATION__OUT);
		createEOperation(basicRelationEClass, BASIC_RELATION___ACCEPT__POLYMODELVISITOR);

		relationEClass = createEClass(RELATION);
		createEOperation(relationEClass, RELATION___ACCEPT__POLYMODELVISITOR);

		functionEClass = createEClass(FUNCTION);
		createEReference(functionEClass, FUNCTION__EXPRESSIONS_MAP);
		createEReference(functionEClass, FUNCTION__DIMENSIONS);
		createEReference(functionEClass, FUNCTION__IN);
		createEReference(functionEClass, FUNCTION__OUT);
		createEOperation(functionEClass, FUNCTION___ACCEPT__POLYMODELVISITOR);
		createEOperation(functionEClass, FUNCTION___GET_EXPRESSION__INT);
		createEOperation(functionEClass, FUNCTION___GET_EXPRESSIONS);
		createEOperation(functionEClass, FUNCTION___BUILD_RELATION__DIMENSIONSMANAGER);
		createEOperation(functionEClass, FUNCTION___EQUIVALENCE__FUNCTION);
		createEOperation(functionEClass, FUNCTION___COMPOSE__FUNCTION);
		createEOperation(functionEClass, FUNCTION___INVERSE__DIMENSIONSMANAGER);
		createEOperation(functionEClass, FUNCTION___INVERSE_IN_CONTEXT__DIMENSIONSMANAGER_DOMAIN);
		createEOperation(functionEClass, FUNCTION___TO_MATRIX);
		createEOperation(functionEClass, FUNCTION___UNIFORMIZE_IN_CONTEXT__DOMAIN);
		createEOperation(functionEClass, FUNCTION___NULLSPACE);
		createEOperation(functionEClass, FUNCTION___LINEAR_PART);
		createEOperation(functionEClass, FUNCTION___LINEAR_PART_WITH_PARAMETERS);
		createEOperation(functionEClass, FUNCTION___LINEAR_PART_AS_FUNCTION);
		createEOperation(functionEClass, FUNCTION___CONSTANT_PART);
		createEOperation(functionEClass, FUNCTION___IS_UNIFORM);
		createEOperation(functionEClass, FUNCTION___IS_IDENTITY);

		valueContainedMapEClass = createEClass(VALUE_CONTAINED_MAP);
		createEReference(valueContainedMapEClass, VALUE_CONTAINED_MAP__KEY);
		createEReference(valueContainedMapEClass, VALUE_CONTAINED_MAP__VALUE);

		labelEClass = createEClass(LABEL);
		createEAttribute(labelEClass, LABEL__NAME);
		createEOperation(labelEClass, LABEL___ACCEPT__POLYMODELVISITOR);

		relationDimensionEClass = createEClass(RELATION_DIMENSION);
		createEReference(relationDimensionEClass, RELATION_DIMENSION__DIMENSION);
		createEOperation(relationDimensionEClass, RELATION_DIMENSION___ACCEPT__POLYMODELVISITOR);

		inputDimensionEClass = createEClass(INPUT_DIMENSION);
		createEOperation(inputDimensionEClass, INPUT_DIMENSION___ACCEPT__POLYMODELVISITOR);

		outputDimensionEClass = createEClass(OUTPUT_DIMENSION);
		createEOperation(outputDimensionEClass, OUTPUT_DIMENSION___ACCEPT__POLYMODELVISITOR);

		polymodelVisitorEClass = createEClass(POLYMODEL_VISITOR);
		createEOperation(polymodelVisitorEClass, POLYMODEL_VISITOR___VISIT_DOMAIN__DOMAIN);
		createEOperation(polymodelVisitorEClass, POLYMODEL_VISITOR___VISIT_DIMENSIONS_MANAGER__DIMENSIONSMANAGER);
		createEOperation(polymodelVisitorEClass, POLYMODEL_VISITOR___VISIT_EXISTENTIAL_VARIABLE__EXISTENTIALVARIABLE);
		createEOperation(polymodelVisitorEClass, POLYMODEL_VISITOR___VISIT_DOMAIN_DIMENSIONS__DOMAINDIMENSIONS);
		createEOperation(polymodelVisitorEClass, POLYMODEL_VISITOR___VISIT_INDEX_DIMENSION__INDEXDIMENSION);
		createEOperation(polymodelVisitorEClass, POLYMODEL_VISITOR___VISIT_RELATION_DIMENSIONS__RELATIONDIMENSIONS);
		createEOperation(polymodelVisitorEClass, POLYMODEL_VISITOR___VISIT_BASIC_RELATION__BASICRELATION);
		createEOperation(polymodelVisitorEClass, POLYMODEL_VISITOR___VISIT_FUNCTION__FUNCTION);
		createEOperation(polymodelVisitorEClass, POLYMODEL_VISITOR___VISIT_RELATION__RELATION);
		createEOperation(polymodelVisitorEClass, POLYMODEL_VISITOR___VISIT_LABEL__LABEL);
		createEOperation(polymodelVisitorEClass, POLYMODEL_VISITOR___VISIT_INPUT_DIMENSION__INPUTDIMENSION);
		createEOperation(polymodelVisitorEClass, POLYMODEL_VISITOR___VISIT_OUTPUT_DIMENSION__OUTPUTDIMENSION);

		polymodelVisitableEClass = createEClass(POLYMODEL_VISITABLE);
		createEOperation(polymodelVisitableEClass, POLYMODEL_VISITABLE___ACCEPT__POLYMODELVISITOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		MatrixPackage theMatrixPackage = (MatrixPackage)EPackage.Registry.INSTANCE.getEPackage(MatrixPackage.eNS_URI);
		AlgebraPackage theAlgebraPackage = (AlgebraPackage)EPackage.Registry.INSTANCE.getEPackage(AlgebraPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theMatrixPackage);

		// Create type parameters
		ETypeParameter valueContainedMapEClass_K = addETypeParameter(valueContainedMapEClass, "K");
		ETypeParameter valueContainedMapEClass_V = addETypeParameter(valueContainedMapEClass, "V");

		// Set bounds for type parameters

		// Add supertypes to classes
		domainEClass.getESuperTypes().add(this.getPolymodelVisitable());
		dimensionsManagerEClass.getESuperTypes().add(this.getPolymodelVisitable());
		abstractRelationEClass.getESuperTypes().add(this.getPolymodelVisitable());
		existentialVariableEClass.getESuperTypes().add(theAlgebraPackage.getVariable());
		existentialVariableEClass.getESuperTypes().add(this.getPolymodelVisitable());
		domainDimensionsEClass.getESuperTypes().add(this.getPolymodelVisitable());
		indexDimensionEClass.getESuperTypes().add(theAlgebraPackage.getVariable());
		indexDimensionEClass.getESuperTypes().add(this.getPolymodelVisitable());
		relationDimensionsEClass.getESuperTypes().add(this.getPolymodelVisitable());
		basicRelationEClass.getESuperTypes().add(this.getPolymodelVisitable());
		relationEClass.getESuperTypes().add(this.getAbstractRelation());
		relationEClass.getESuperTypes().add(this.getPolymodelVisitable());
		functionEClass.getESuperTypes().add(this.getPolymodelVisitable());
		labelEClass.getESuperTypes().add(this.getPolymodelVisitable());
		relationDimensionEClass.getESuperTypes().add(theAlgebraPackage.getVariable());
		relationDimensionEClass.getESuperTypes().add(this.getPolymodelVisitable());
		inputDimensionEClass.getESuperTypes().add(this.getRelationDimension());
		inputDimensionEClass.getESuperTypes().add(this.getPolymodelVisitable());
		outputDimensionEClass.getESuperTypes().add(this.getRelationDimension());
		outputDimensionEClass.getESuperTypes().add(this.getPolymodelVisitable());

		// Initialize classes, features, and operations; add parameters
		initEClass(domainEClass, Domain.class, "Domain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDomain_Polyhedra(), theAlgebraPackage.getIntConstraintSystem(), null, "polyhedra", null, 0, -1, Domain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomain_Dimensions(), this.getDomainDimensions(), null, "dimensions", null, 0, 1, Domain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomain_Label(), this.getLabel(), null, "label", null, 0, 1, Domain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getDomain__Union__Domain(), null, "union", 0, 1, IS_UNIQUE, IS_ORDERED);
		ETypeParameter t1 = addETypeParameter(op, "T");
		EGenericType g1 = createEGenericType(this.getDomain());
		t1.getEBounds().add(g1);
		addEParameter(op, this.getDomain(), "domain", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getDomain__Image__AbstractRelation(), null, "image", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getDomain());
		t1.getEBounds().add(g1);
		addEParameter(op, this.getAbstractRelation(), "relation", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getDomain__Difference__Domain(), null, "difference", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getDomain());
		t1.getEBounds().add(g1);
		addEParameter(op, this.getDomain(), "domain", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getDomain__Intersection__Domain(), null, "intersection", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getDomain());
		t1.getEBounds().add(g1);
		addEParameter(op, this.getDomain(), "domain", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEOperation(getDomain__IsEmpty(), ecorePackage.getEBoolean(), "isEmpty", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDomain__Simplify__Domain(), null, "simplify", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getDomain());
		t1.getEBounds().add(g1);
		addEParameter(op, this.getDomain(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getDomain__Simplify(), null, "simplify", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getDomain());
		t1.getEBounds().add(g1);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getDomain__BoundingBox(), null, "boundingBox", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getDomain());
		t1.getEBounds().add(g1);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getDomain__Equivalence__Domain(), ecorePackage.getEBoolean(), "equivalence", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDomain(), "domain", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDomain__Accept__PolymodelVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolymodelVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getDomain__IsUniverse(), ecorePackage.getEBoolean(), "isUniverse", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDomain__LexMin(), null, "lexMin", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getDomain());
		t1.getEBounds().add(g1);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getDomain__LexMax(), null, "lexMax", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getDomain());
		t1.getEBounds().add(g1);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getDomain__DetectEqualities(), null, "detectEqualities", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getDomain());
		t1.getEBounds().add(g1);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getDomain__AffineHull(), null, "affineHull", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getDomain());
		t1.getEBounds().add(g1);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getDomain__PolyhedralHull(), null, "polyhedralHull", 1, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getDomain());
		t1.getEBounds().add(g1);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEOperation(getDomain__ToMatrices(), theMatrixPackage.getMatrix(), "toMatrices", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDomain__Complement(), null, "complement", 1, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getDomain());
		t1.getEBounds().add(g1);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getDomain__CartesianProduct__Domain(), null, "cartesianProduct", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getDomain());
		t1.getEBounds().add(g1);
		addEParameter(op, this.getDomain(), "domain", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(dimensionsManagerEClass, DimensionsManager.class, "DimensionsManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDimensionsManager_Dimensions(), theAlgebraPackage.getVariable(), null, "dimensions", null, 0, -1, DimensionsManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDimensionsManager_Parameters(), theAlgebraPackage.getVariable(), null, "parameters", null, 0, -1, DimensionsManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDimensionsManager_InputsDimensions(), this.getInputDimension(), null, "inputsDimensions", null, 0, -1, DimensionsManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDimensionsManager_OutputsDimensions(), this.getOutputDimension(), null, "outputsDimensions", null, 0, -1, DimensionsManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getDimensionsManager__GetDimension__int(), theAlgebraPackage.getVariable(), "getDimension", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "position", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDimensionsManager__GetDimension__int_String(), theAlgebraPackage.getVariable(), "getDimension", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "position", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDimensionsManager__GetInputDimension__Variable(), this.getInputDimension(), "getInputDimension", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAlgebraPackage.getVariable(), "var", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDimensionsManager__GetOutputDimension__Variable(), this.getOutputDimension(), "getOutputDimension", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAlgebraPackage.getVariable(), "var", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDimensionsManager__GetParameter__int(), theAlgebraPackage.getVariable(), "getParameter", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "position", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDimensionsManager__GetParameter__int_String(), theAlgebraPackage.getVariable(), "getParameter", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "position", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDimensionsManager__Accept__PolymodelVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolymodelVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(abstractRelationEClass, AbstractRelation.class, "AbstractRelation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractRelation_Dimensions(), this.getRelationDimensions(), null, "dimensions", null, 0, 1, AbstractRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractRelation_BasicRelations(), this.getBasicRelation(), null, "basicRelations", null, 0, -1, AbstractRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getAbstractRelation__Accept__PolymodelVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolymodelVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAbstractRelation__Reverse__DimensionsManager(), null, "reverse", 1, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getAbstractRelation());
		t1.getEBounds().add(g1);
		addEParameter(op, this.getDimensionsManager(), "manager", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEOperation(getAbstractRelation__IsBijective(), ecorePackage.getEBoolean(), "isBijective", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAbstractRelation__IsSingleValued(), ecorePackage.getEBoolean(), "isSingleValued", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAbstractRelation__IsEmpty(), ecorePackage.getEBoolean(), "isEmpty", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAbstractRelation__Equivalence__AbstractRelation(), ecorePackage.getEBoolean(), "equivalence", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAbstractRelation(), "map", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getAbstractRelation__IntersectDomain__Domain(), null, "intersectDomain", 1, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getAbstractRelation());
		t1.getEBounds().add(g1);
		addEParameter(op, this.getDomain(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getAbstractRelation__IntersectRange__Domain(), null, "intersectRange", 1, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getAbstractRelation());
		t1.getEBounds().add(g1);
		addEParameter(op, this.getDomain(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getAbstractRelation__Intersection__AbstractRelation(), null, "intersection", 1, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getAbstractRelation());
		t1.getEBounds().add(g1);
		addEParameter(op, this.getAbstractRelation(), "map", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getAbstractRelation__Union__AbstractRelation(), null, "union", 1, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getAbstractRelation());
		t1.getEBounds().add(g1);
		addEParameter(op, this.getAbstractRelation(), "map", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getAbstractRelation__Difference__AbstractRelation(), null, "difference", 1, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getAbstractRelation());
		t1.getEBounds().add(g1);
		addEParameter(op, this.getAbstractRelation(), "map", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getAbstractRelation__BuildFunction(), null, "buildFunction", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getFunction());
		t1.getEBounds().add(g1);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getAbstractRelation__GetDomain(), null, "getDomain", 1, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getDomain());
		t1.getEBounds().add(g1);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getAbstractRelation__GetRange(), null, "getRange", 1, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getDomain());
		t1.getEBounds().add(g1);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getAbstractRelation__ApplyDomain__AbstractRelation(), null, "applyDomain", 1, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getAbstractRelation());
		t1.getEBounds().add(g1);
		addEParameter(op, this.getAbstractRelation(), "map", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getAbstractRelation__ApplyRange__AbstractRelation(), null, "applyRange", 1, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getAbstractRelation());
		t1.getEBounds().add(g1);
		addEParameter(op, this.getAbstractRelation(), "map", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getAbstractRelation__TransitiveClosure(), null, "transitiveClosure", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getAbstractRelation());
		t1.getEBounds().add(g1);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getAbstractRelation__ExactTransitiveClosure(), null, "exactTransitiveClosure", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getAbstractRelation());
		t1.getEBounds().add(g1);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getAbstractRelation__Simplify(), null, "simplify", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getAbstractRelation());
		t1.getEBounds().add(g1);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEOperation(getAbstractRelation__ToMatrices(), theMatrixPackage.getMatrix(), "toMatrices", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(existentialVariableEClass, ExistentialVariable.class, "ExistentialVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExistentialVariable_Definition(), theAlgebraPackage.getIntExpression(), null, "definition", null, 0, 1, ExistentialVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExistentialVariable_Domain(), this.getDomain(), null, "domain", null, 0, 1, ExistentialVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getExistentialVariable__Accept__PolymodelVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolymodelVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(domainDimensionsEClass, DomainDimensions.class, "DomainDimensions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDomainDimensions_Indices(), theAlgebraPackage.getVariable(), null, "indices", null, 0, -1, DomainDimensions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainDimensions_Parameters(), theAlgebraPackage.getVariable(), null, "parameters", null, 0, -1, DomainDimensions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainDimensions_Existential(), this.getExistentialVariable(), null, "existential", null, 0, -1, DomainDimensions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getDomainDimensions__Copy(), this.getDomainDimensions(), "copy", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDomainDimensions__Accept__PolymodelVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolymodelVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDomainDimensions__GetParameterDimensionOf__Variable(), ecorePackage.getEInt(), "getParameterDimensionOf", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAlgebraPackage.getVariable(), "variable", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDomainDimensions__GetDimensionOf__Variable(), ecorePackage.getEInt(), "getDimensionOf", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAlgebraPackage.getVariable(), "variable", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(indexDimensionEClass, IndexDimension.class, "IndexDimension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIndexDimension_Dimension(), ecorePackage.getEInt(), "dimension", null, 0, 1, IndexDimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getIndexDimension__Accept__PolymodelVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolymodelVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(relationDimensionsEClass, RelationDimensions.class, "RelationDimensions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationDimensions_Inputs(), this.getInputDimension(), null, "inputs", null, 0, -1, RelationDimensions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationDimensions_Outputs(), this.getOutputDimension(), null, "outputs", null, 0, -1, RelationDimensions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationDimensions_Parameters(), theAlgebraPackage.getVariable(), null, "parameters", null, 0, -1, RelationDimensions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationDimensions_Existential(), this.getExistentialVariable(), null, "existential", null, 0, -1, RelationDimensions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getRelationDimensions__Accept__PolymodelVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolymodelVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getRelationDimensions__GetParameterDimensionOf__Variable(), ecorePackage.getEInt(), "getParameterDimensionOf", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAlgebraPackage.getVariable(), "variable", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getRelationDimensions__GetInputDimensionOf__Variable(), ecorePackage.getEInt(), "getInputDimensionOf", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAlgebraPackage.getVariable(), "variable", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getRelationDimensions__GetOutputDimensionOf__Variable(), ecorePackage.getEInt(), "getOutputDimensionOf", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAlgebraPackage.getVariable(), "variable", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(basicRelationEClass, BasicRelation.class, "BasicRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBasicRelation_Input(), theAlgebraPackage.getIntConstraintSystem(), null, "input", null, 0, 1, BasicRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBasicRelation_Output(), theAlgebraPackage.getIntConstraintSystem(), null, "output", null, 0, 1, BasicRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBasicRelation_Relation(), theAlgebraPackage.getIntConstraintSystem(), null, "relation", null, 0, 1, BasicRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBasicRelation_In(), this.getLabel(), null, "in", null, 0, 1, BasicRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBasicRelation_Out(), this.getLabel(), null, "out", null, 0, 1, BasicRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getBasicRelation__Accept__PolymodelVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolymodelVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(relationEClass, Relation.class, "Relation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getRelation__Accept__PolymodelVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolymodelVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(functionEClass, Function.class, "Function", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getValueContainedMap());
		EGenericType g2 = createEGenericType(this.getOutputDimension());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theAlgebraPackage.getIntExpression());
		g1.getETypeArguments().add(g2);
		initEReference(getFunction_ExpressionsMap(), g1, null, "expressionsMap", null, 0, -1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunction_Dimensions(), this.getDomainDimensions(), null, "dimensions", null, 0, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunction_In(), this.getLabel(), null, "in", null, 0, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunction_Out(), this.getLabel(), null, "out", null, 0, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getFunction__Accept__PolymodelVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolymodelVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getFunction__GetExpression__int(), theAlgebraPackage.getIntExpression(), "getExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "position", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getFunction__GetExpressions(), theAlgebraPackage.getIntExpression(), "getExpressions", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getFunction__BuildRelation__DimensionsManager(), null, "buildRelation", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getRelation());
		t1.getEBounds().add(g1);
		addEParameter(op, this.getDimensionsManager(), "manager", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getFunction__Equivalence__Function(), ecorePackage.getEBoolean(), "equivalence", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFunction(), "func", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getFunction__Compose__Function(), null, "compose", 1, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getFunction());
		t1.getEBounds().add(g1);
		addEParameter(op, this.getFunction(), "func", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getFunction__Inverse__DimensionsManager(), null, "inverse", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getFunction());
		t1.getEBounds().add(g1);
		addEParameter(op, this.getDimensionsManager(), "manager", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = initEOperation(getFunction__InverseInContext__DimensionsManager_Domain(), null, "inverseInContext", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(this.getFunction());
		t1.getEBounds().add(g1);
		addEParameter(op, this.getDimensionsManager(), "manager", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDomain(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEOperation(getFunction__ToMatrix(), theMatrixPackage.getMatrix(), "toMatrix", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getFunction__UniformizeInContext__Domain(), this.getFunction(), "uniformizeInContext", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDomain(), "context", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getFunction__Nullspace(), this.getFunction(), "nullspace", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getFunction__LinearPart(), theMatrixPackage.getMatrix(), "linearPart", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getFunction__LinearPartWithParameters(), theMatrixPackage.getMatrix(), "linearPartWithParameters", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getFunction__LinearPartAsFunction(), this.getFunction(), "linearPartAsFunction", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getFunction__ConstantPart(), ecorePackage.getELong(), "constantPart", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getFunction__IsUniform(), ecorePackage.getEBoolean(), "isUniform", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getFunction__IsIdentity(), ecorePackage.getEBoolean(), "isIdentity", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(valueContainedMapEClass, Map.Entry.class, "ValueContainedMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(valueContainedMapEClass_K);
		initEReference(getValueContainedMap_Key(), g1, null, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(valueContainedMapEClass_V);
		initEReference(getValueContainedMap_Value(), g1, null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(labelEClass, Label.class, "Label", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLabel_Name(), ecorePackage.getEString(), "name", null, 0, 1, Label.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getLabel__Accept__PolymodelVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolymodelVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(relationDimensionEClass, RelationDimension.class, "RelationDimension", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationDimension_Dimension(), theAlgebraPackage.getVariable(), null, "dimension", null, 0, 1, RelationDimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getRelationDimension__Accept__PolymodelVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolymodelVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(inputDimensionEClass, InputDimension.class, "InputDimension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getInputDimension__Accept__PolymodelVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolymodelVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(outputDimensionEClass, OutputDimension.class, "OutputDimension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getOutputDimension__Accept__PolymodelVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolymodelVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(polymodelVisitorEClass, PolymodelVisitor.class, "PolymodelVisitor", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getPolymodelVisitor__VisitDomain__Domain(), null, "visitDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDomain(), "d", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPolymodelVisitor__VisitDimensionsManager__DimensionsManager(), null, "visitDimensionsManager", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDimensionsManager(), "d", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPolymodelVisitor__VisitExistentialVariable__ExistentialVariable(), null, "visitExistentialVariable", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getExistentialVariable(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPolymodelVisitor__VisitDomainDimensions__DomainDimensions(), null, "visitDomainDimensions", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDomainDimensions(), "d", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPolymodelVisitor__VisitIndexDimension__IndexDimension(), null, "visitIndexDimension", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIndexDimension(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPolymodelVisitor__VisitRelationDimensions__RelationDimensions(), null, "visitRelationDimensions", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRelationDimensions(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPolymodelVisitor__VisitBasicRelation__BasicRelation(), null, "visitBasicRelation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBasicRelation(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPolymodelVisitor__VisitFunction__Function(), null, "visitFunction", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getFunction(), "f", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPolymodelVisitor__VisitRelation__Relation(), null, "visitRelation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRelation(), "r", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPolymodelVisitor__VisitLabel__Label(), null, "visitLabel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getLabel(), "l", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPolymodelVisitor__VisitInputDimension__InputDimension(), null, "visitInputDimension", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getInputDimension(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPolymodelVisitor__VisitOutputDimension__OutputDimension(), null, "visitOutputDimension", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOutputDimension(), "o", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(polymodelVisitableEClass, PolymodelVisitable.class, "PolymodelVisitable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getPolymodelVisitable__Accept__PolymodelVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPolymodelVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //PolymodelPackageImpl
