/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.polymodel.prdg.DependenceFunction;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.PRDGSubSystemHyperEdge;
import org.polymodel.prdg.PrdgFactory;
import org.polymodel.prdg.PrdgPackage;
import org.polymodel.prdg.ProjectionFunction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PrdgFactoryImpl extends EFactoryImpl implements PrdgFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PrdgFactory init() {
		try {
			PrdgFactory thePrdgFactory = (PrdgFactory)EPackage.Registry.INSTANCE.getEFactory(PrdgPackage.eNS_URI);
			if (thePrdgFactory != null) {
				return thePrdgFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PrdgFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrdgFactoryImpl() {
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
			case PrdgPackage.PRDG_NODE: return createPRDGNode();
			case PrdgPackage.PRDG_EDGE: return createPRDGEdge();
			case PrdgPackage.PRDG: return createPRDG();
			case PrdgPackage.PROJECTION_FUNCTION: return createProjectionFunction();
			case PrdgPackage.DEPENDENCE_FUNCTION: return createDependenceFunction();
			case PrdgPackage.PRDG_SUB_SYSTEM_HYPER_EDGE: return createPRDGSubSystemHyperEdge();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PRDGNode createPRDGNode() {
		PRDGNodeImpl prdgNode = new PRDGNodeImpl();
		return prdgNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PRDGEdge createPRDGEdge() {
		PRDGEdgeImpl prdgEdge = new PRDGEdgeImpl();
		return prdgEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PRDG createPRDG() {
		PRDGImpl prdg = new PRDGImpl();
		return prdg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectionFunction createProjectionFunction() {
		ProjectionFunctionImpl projectionFunction = new ProjectionFunctionImpl();
		return projectionFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependenceFunction createDependenceFunction() {
		DependenceFunctionImpl dependenceFunction = new DependenceFunctionImpl();
		return dependenceFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PRDGSubSystemHyperEdge createPRDGSubSystemHyperEdge() {
		PRDGSubSystemHyperEdgeImpl prdgSubSystemHyperEdge = new PRDGSubSystemHyperEdgeImpl();
		return prdgSubSystemHyperEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrdgPackage getPrdgPackage() {
		return (PrdgPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PrdgPackage getPackage() {
		return PrdgPackage.eINSTANCE;
	}

} //PrdgFactoryImpl
