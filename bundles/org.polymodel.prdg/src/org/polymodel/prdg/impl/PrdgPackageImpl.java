/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.polymodel.PolymodelPackage;
import org.polymodel.prdg.DependenceFunction;
import org.polymodel.prdg.EdgeFunction;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.PRDGSubSystemHyperEdge;
import org.polymodel.prdg.PrdgFactory;
import org.polymodel.prdg.PrdgPackage;
import org.polymodel.prdg.ProjectionFunction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PrdgPackageImpl extends EPackageImpl implements PrdgPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass prdgNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass prdgEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass prdgEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectionFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependenceFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass prdgSubSystemHyperEdgeEClass = null;

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
	 * @see org.polymodel.prdg.PrdgPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PrdgPackageImpl() {
		super(eNS_URI, PrdgFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PrdgPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PrdgPackage init() {
		if (isInited) return (PrdgPackage)EPackage.Registry.INSTANCE.getEPackage(PrdgPackage.eNS_URI);

		// Obtain or create and register package
		PrdgPackageImpl thePrdgPackage = (PrdgPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PrdgPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PrdgPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PolymodelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thePrdgPackage.createPackageContents();

		// Initialize created meta-data
		thePrdgPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePrdgPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PrdgPackage.eNS_URI, thePrdgPackage);
		return thePrdgPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPRDGNode() {
		return prdgNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPRDGNode_Prdg() {
		return (EReference)prdgNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPRDGNode_Domain() {
		return (EReference)prdgNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPRDGNode_Name() {
		return (EAttribute)prdgNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPRDGNode__GetDestinations() {
		return prdgNodeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPRDGNode__GetSources() {
		return prdgNodeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPRDGEdge() {
		return prdgEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPRDGEdge_Source() {
		return (EReference)prdgEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPRDGEdge_Destination() {
		return (EReference)prdgEdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPRDGEdge_Domain() {
		return (EReference)prdgEdgeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPRDGEdge_Function() {
		return (EReference)prdgEdgeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPRDGEdge__ToEdgeRelation__DimensionsManager() {
		return prdgEdgeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPRDG() {
		return prdgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPRDG_Nodes() {
		return (EReference)prdgEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPRDG_Edges() {
		return (EReference)prdgEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPRDG_Hedges() {
		return (EReference)prdgEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPRDG__GetNode__String() {
		return prdgEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEdgeFunction() {
		return edgeFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdgeFunction_Mapping() {
		return (EReference)edgeFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProjectionFunction() {
		return projectionFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDependenceFunction() {
		return dependenceFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDependenceFunction__IsUniform() {
		return dependenceFunctionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPRDGSubSystemHyperEdge() {
		return prdgSubSystemHyperEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPRDGSubSystemHyperEdge_Sources() {
		return (EReference)prdgSubSystemHyperEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPRDGSubSystemHyperEdge_Destinations() {
		return (EReference)prdgSubSystemHyperEdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPRDGSubSystemHyperEdge_ExtDom() {
		return (EReference)prdgSubSystemHyperEdgeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPRDGSubSystemHyperEdge_Params() {
		return (EReference)prdgSubSystemHyperEdgeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrdgFactory getPrdgFactory() {
		return (PrdgFactory)getEFactoryInstance();
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
		prdgNodeEClass = createEClass(PRDG_NODE);
		createEReference(prdgNodeEClass, PRDG_NODE__PRDG);
		createEReference(prdgNodeEClass, PRDG_NODE__DOMAIN);
		createEAttribute(prdgNodeEClass, PRDG_NODE__NAME);
		createEOperation(prdgNodeEClass, PRDG_NODE___GET_DESTINATIONS);
		createEOperation(prdgNodeEClass, PRDG_NODE___GET_SOURCES);

		prdgEdgeEClass = createEClass(PRDG_EDGE);
		createEReference(prdgEdgeEClass, PRDG_EDGE__SOURCE);
		createEReference(prdgEdgeEClass, PRDG_EDGE__DESTINATION);
		createEReference(prdgEdgeEClass, PRDG_EDGE__DOMAIN);
		createEReference(prdgEdgeEClass, PRDG_EDGE__FUNCTION);
		createEOperation(prdgEdgeEClass, PRDG_EDGE___TO_EDGE_RELATION__DIMENSIONSMANAGER);

		prdgEClass = createEClass(PRDG);
		createEReference(prdgEClass, PRDG__NODES);
		createEReference(prdgEClass, PRDG__EDGES);
		createEReference(prdgEClass, PRDG__HEDGES);
		createEOperation(prdgEClass, PRDG___GET_NODE__STRING);

		edgeFunctionEClass = createEClass(EDGE_FUNCTION);
		createEReference(edgeFunctionEClass, EDGE_FUNCTION__MAPPING);

		projectionFunctionEClass = createEClass(PROJECTION_FUNCTION);

		dependenceFunctionEClass = createEClass(DEPENDENCE_FUNCTION);
		createEOperation(dependenceFunctionEClass, DEPENDENCE_FUNCTION___IS_UNIFORM);

		prdgSubSystemHyperEdgeEClass = createEClass(PRDG_SUB_SYSTEM_HYPER_EDGE);
		createEReference(prdgSubSystemHyperEdgeEClass, PRDG_SUB_SYSTEM_HYPER_EDGE__SOURCES);
		createEReference(prdgSubSystemHyperEdgeEClass, PRDG_SUB_SYSTEM_HYPER_EDGE__DESTINATIONS);
		createEReference(prdgSubSystemHyperEdgeEClass, PRDG_SUB_SYSTEM_HYPER_EDGE__EXT_DOM);
		createEReference(prdgSubSystemHyperEdgeEClass, PRDG_SUB_SYSTEM_HYPER_EDGE__PARAMS);
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
		PolymodelPackage thePolymodelPackage = (PolymodelPackage)EPackage.Registry.INSTANCE.getEPackage(PolymodelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		projectionFunctionEClass.getESuperTypes().add(this.getEdgeFunction());
		dependenceFunctionEClass.getESuperTypes().add(this.getEdgeFunction());

		// Initialize classes, features, and operations; add parameters
		initEClass(prdgNodeEClass, PRDGNode.class, "PRDGNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPRDGNode_Prdg(), this.getPRDG(), this.getPRDG_Nodes(), "prdg", null, 0, 1, PRDGNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPRDGNode_Domain(), thePolymodelPackage.getDomain(), null, "domain", null, 0, 1, PRDGNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPRDGNode_Name(), ecorePackage.getEString(), "name", null, 0, 1, PRDGNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getPRDGNode__GetDestinations(), this.getPRDGEdge(), "getDestinations", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getPRDGNode__GetSources(), this.getPRDGEdge(), "getSources", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(prdgEdgeEClass, PRDGEdge.class, "PRDGEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPRDGEdge_Source(), this.getPRDGNode(), null, "source", null, 0, 1, PRDGEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPRDGEdge_Destination(), this.getPRDGNode(), null, "destination", null, 0, 1, PRDGEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPRDGEdge_Domain(), thePolymodelPackage.getDomain(), null, "domain", null, 0, 1, PRDGEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPRDGEdge_Function(), this.getEdgeFunction(), null, "function", null, 0, 1, PRDGEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getPRDGEdge__ToEdgeRelation__DimensionsManager(), null, "toEdgeRelation", 1, 1, IS_UNIQUE, IS_ORDERED);
		ETypeParameter t1 = addETypeParameter(op, "T");
		EGenericType g1 = createEGenericType(thePolymodelPackage.getAbstractRelation());
		t1.getEBounds().add(g1);
		addEParameter(op, thePolymodelPackage.getDimensionsManager(), "manager", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		initEClass(prdgEClass, org.polymodel.prdg.PRDG.class, "PRDG", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPRDG_Nodes(), this.getPRDGNode(), this.getPRDGNode_Prdg(), "nodes", null, 0, -1, org.polymodel.prdg.PRDG.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPRDG_Edges(), this.getPRDGEdge(), null, "edges", null, 0, -1, org.polymodel.prdg.PRDG.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPRDG_Hedges(), this.getPRDGSubSystemHyperEdge(), null, "hedges", null, 0, -1, org.polymodel.prdg.PRDG.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getPRDG__GetNode__String(), this.getPRDGNode(), "getNode", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(edgeFunctionEClass, EdgeFunction.class, "EdgeFunction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEdgeFunction_Mapping(), thePolymodelPackage.getFunction(), null, "mapping", null, 0, 1, EdgeFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(projectionFunctionEClass, ProjectionFunction.class, "ProjectionFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dependenceFunctionEClass, DependenceFunction.class, "DependenceFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getDependenceFunction__IsUniform(), ecorePackage.getEBoolean(), "isUniform", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(prdgSubSystemHyperEdgeEClass, PRDGSubSystemHyperEdge.class, "PRDGSubSystemHyperEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPRDGSubSystemHyperEdge_Sources(), this.getPRDGNode(), null, "sources", null, 0, -1, PRDGSubSystemHyperEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPRDGSubSystemHyperEdge_Destinations(), this.getPRDGNode(), null, "destinations", null, 0, -1, PRDGSubSystemHyperEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPRDGSubSystemHyperEdge_ExtDom(), thePolymodelPackage.getDomain(), null, "extDom", null, 0, 1, PRDGSubSystemHyperEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPRDGSubSystemHyperEdge_Params(), thePolymodelPackage.getFunction(), null, "params", null, 0, 1, PRDGSubSystemHyperEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //PrdgPackageImpl
