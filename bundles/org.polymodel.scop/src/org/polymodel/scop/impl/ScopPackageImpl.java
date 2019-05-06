/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.polymodel.algebra.AlgebraPackage;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.AbstractScopStatement;
import org.polymodel.scop.IScopAnnotation;
import org.polymodel.scop.ScopAssignment;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopDepthFirstVisitor;
import org.polymodel.scop.ScopFactory;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopGuard;
import org.polymodel.scop.ScopPackage;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopStatementMacro;
import org.polymodel.scop.ScopUnscannedDomain;
import org.polymodel.scop.ScopVisitable;
import org.polymodel.scop.ScopVisitor;
import org.polymodel.scop.annotation.AnnotationPackage;
import org.polymodel.scop.annotation.impl.AnnotationPackageImpl;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionMap;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ScopPackageImpl extends EPackageImpl implements ScopPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractScopNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iScopAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scopRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scopForEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scopBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scopGuardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scopStatementMacroEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scopAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractScopStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scopVisitorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scopVisitableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scopDepthFirstVisitorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scopUnscannedDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType jniislUnionMapEDataType = null;

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
	 * @see org.polymodel.scop.ScopPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ScopPackageImpl() {
		super(eNS_URI, ScopFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ScopPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated NOT
	 */
	public static ScopPackage init() {
		if (isInited) return (ScopPackage)EPackage.Registry.INSTANCE.getEPackage(ScopPackage.eNS_URI);

		// Obtain or create and register package
		ScopPackageImpl theScopPackage = (ScopPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ScopPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ScopPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		AlgebraPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		//AnnotationPackageImpl theAnnotationPackage = (AnnotationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AnnotationPackage.eNS_URI) instanceof AnnotationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AnnotationPackage.eNS_URI) : AnnotationPackage.eINSTANCE);
		AnnotationPackageImpl theAnnotationPackage = (AnnotationPackageImpl)(AnnotationPackage.eINSTANCE);

		// Create package meta-data objects
		theScopPackage.createPackageContents();
		theAnnotationPackage.createPackageContents();

		// Initialize created meta-data
		theScopPackage.initializePackageContents();
		theAnnotationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theScopPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ScopPackage.eNS_URI, theScopPackage);
		return theScopPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractScopNode() {
		return abstractScopNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractScopNode_ScopAnnotations() {
		return (EReference)abstractScopNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractScopNode__GetSurroundingIterators() {
		return abstractScopNodeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractScopNode__GetSurroundingScopFors() {
		return abstractScopNodeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractScopNode__Simplify() {
		return abstractScopNodeEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractScopNode__GetLoopDepth() {
		return abstractScopNodeEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractScopNode__Accept__ScopVisitor() {
		return abstractScopNodeEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractScopNode__GetSurroundingScopFor() {
		return abstractScopNodeEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractScopNode__GetDerivedConstraints() {
		return abstractScopNodeEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIScopAnnotation() {
		return iScopAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIScopAnnotation__Accept__ScopVisitor() {
		return iScopAnnotationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScopRoot() {
		return scopRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScopRoot_Statements() {
		return (EReference)scopRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopRoot__Simplify() {
		return scopRootEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopRoot__Accept__ScopVisitor() {
		return scopRootEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScopFor() {
		return scopForEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScopFor_Iterator() {
		return (EReference)scopForEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScopFor_LB() {
		return (EReference)scopForEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScopFor_UB() {
		return (EReference)scopForEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScopFor_Stride() {
		return (EReference)scopForEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScopFor_Body() {
		return (EReference)scopForEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopFor__Accept__ScopVisitor() {
		return scopForEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScopBlock() {
		return scopBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScopBlock_Statements() {
		return (EReference)scopBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopBlock__Accept__ScopVisitor() {
		return scopBlockEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScopGuard() {
		return scopGuardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScopGuard_ConstraintSystems() {
		return (EReference)scopGuardEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScopGuard_ThenBody() {
		return (EReference)scopGuardEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScopGuard_ElseBody() {
		return (EReference)scopGuardEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopGuard__Accept__ScopVisitor() {
		return scopGuardEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScopStatementMacro() {
		return scopStatementMacroEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScopStatementMacro_MacroParams() {
		return (EReference)scopStatementMacroEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScopStatementMacro_Name() {
		return (EAttribute)scopStatementMacroEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopStatementMacro__Accept__ScopVisitor() {
		return scopStatementMacroEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScopAssignment() {
		return scopAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScopAssignment_LHS() {
		return (EReference)scopAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScopAssignment_RHS() {
		return (EReference)scopAssignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopAssignment__Accept__ScopVisitor() {
		return scopAssignmentEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractScopStatement() {
		return abstractScopStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractScopStatement__Accept__ScopVisitor() {
		return abstractScopStatementEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScopVisitor() {
		return scopVisitorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__DefaultIn__ScopVisitable() {
		return scopVisitorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__DefaultOut__ScopVisitable() {
		return scopVisitorEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__VisitAbstractScopNode__AbstractScopNode() {
		return scopVisitorEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__InAbstractScopNode__AbstractScopNode() {
		return scopVisitorEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__OutAbstractScopNode__AbstractScopNode() {
		return scopVisitorEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__VisitIScopAnnotation__IScopAnnotation() {
		return scopVisitorEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__InIScopAnnotation__IScopAnnotation() {
		return scopVisitorEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__OutIScopAnnotation__IScopAnnotation() {
		return scopVisitorEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__VisitScopRoot__ScopRoot() {
		return scopVisitorEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__InScopRoot__ScopRoot() {
		return scopVisitorEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__OutScopRoot__ScopRoot() {
		return scopVisitorEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__VisitScopFor__ScopFor() {
		return scopVisitorEClass.getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__InScopFor__ScopFor() {
		return scopVisitorEClass.getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__OutScopFor__ScopFor() {
		return scopVisitorEClass.getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__VisitScopBlock__ScopBlock() {
		return scopVisitorEClass.getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__InScopBlock__ScopBlock() {
		return scopVisitorEClass.getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__OutScopBlock__ScopBlock() {
		return scopVisitorEClass.getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__VisitScopGuard__ScopGuard() {
		return scopVisitorEClass.getEOperations().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__InScopGuard__ScopGuard() {
		return scopVisitorEClass.getEOperations().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__OutScopGuard__ScopGuard() {
		return scopVisitorEClass.getEOperations().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__VisitScopStatementMacro__ScopStatementMacro() {
		return scopVisitorEClass.getEOperations().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__InScopStatementMacro__ScopStatementMacro() {
		return scopVisitorEClass.getEOperations().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__OutScopStatementMacro__ScopStatementMacro() {
		return scopVisitorEClass.getEOperations().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__VisitScopAssignment__ScopAssignment() {
		return scopVisitorEClass.getEOperations().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__InScopAssignment__ScopAssignment() {
		return scopVisitorEClass.getEOperations().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__OutScopAssignment__ScopAssignment() {
		return scopVisitorEClass.getEOperations().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__VisitAbstractScopStatement__AbstractScopStatement() {
		return scopVisitorEClass.getEOperations().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__InAbstractScopStatement__AbstractScopStatement() {
		return scopVisitorEClass.getEOperations().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__OutAbstractScopStatement__AbstractScopStatement() {
		return scopVisitorEClass.getEOperations().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__VisitParallelLoopAnnotation__ParallelLoopAnnotation() {
		return scopVisitorEClass.getEOperations().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__InParallelLoopAnnotation__ParallelLoopAnnotation() {
		return scopVisitorEClass.getEOperations().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__OutParallelLoopAnnotation__ParallelLoopAnnotation() {
		return scopVisitorEClass.getEOperations().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__VisitDescriptionAnnotation__DescriptionAnnotation() {
		return scopVisitorEClass.getEOperations().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__InDescriptionAnnotation__DescriptionAnnotation() {
		return scopVisitorEClass.getEOperations().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__OutDescriptionAnnotation__DescriptionAnnotation() {
		return scopVisitorEClass.getEOperations().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__VisitTileLoopAnnotation__TileLoopAnnotation() {
		return scopVisitorEClass.getEOperations().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__InTileLoopAnnotation__TileLoopAnnotation() {
		return scopVisitorEClass.getEOperations().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__OutTileLoopAnnotation__TileLoopAnnotation() {
		return scopVisitorEClass.getEOperations().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__VisitParallelBlockAnnotation__ParallelBlockAnnotation() {
		return scopVisitorEClass.getEOperations().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__InParallelBlockAnnotation__ParallelBlockAnnotation() {
		return scopVisitorEClass.getEOperations().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__OutParallelBlockAnnotation__ParallelBlockAnnotation() {
		return scopVisitorEClass.getEOperations().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__VisitPolyhedralDomainAnnotation__PolyhedralDomainAnnotation() {
		return scopVisitorEClass.getEOperations().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__InPolyhedralDomainAnnotation__PolyhedralDomainAnnotation() {
		return scopVisitorEClass.getEOperations().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__OutPolyhedralDomainAnnotation__PolyhedralDomainAnnotation() {
		return scopVisitorEClass.getEOperations().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__VisitBarrierAnnotation__BarrierAnnotation() {
		return scopVisitorEClass.getEOperations().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__InBarrierAnnotation__BarrierAnnotation() {
		return scopVisitorEClass.getEOperations().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__OutBarrierAnnotation__BarrierAnnotation() {
		return scopVisitorEClass.getEOperations().get(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__VisitScopUnscannedDomain__ScopUnscannedDomain() {
		return scopVisitorEClass.getEOperations().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__InScopUnscannedDomain__ScopUnscannedDomain() {
		return scopVisitorEClass.getEOperations().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitor__OutScopUnscannedDomain__ScopUnscannedDomain() {
		return scopVisitorEClass.getEOperations().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScopVisitable() {
		return scopVisitableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopVisitable__Accept__ScopVisitor() {
		return scopVisitableEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScopDepthFirstVisitor() {
		return scopDepthFirstVisitorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__DefaultIn__ScopVisitable() {
		return scopDepthFirstVisitorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__DefaultOut__ScopVisitable() {
		return scopDepthFirstVisitorEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__VisitAbstractScopNode__AbstractScopNode() {
		return scopDepthFirstVisitorEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__InAbstractScopNode__AbstractScopNode() {
		return scopDepthFirstVisitorEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__OutAbstractScopNode__AbstractScopNode() {
		return scopDepthFirstVisitorEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__VisitIScopAnnotation__IScopAnnotation() {
		return scopDepthFirstVisitorEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__InIScopAnnotation__IScopAnnotation() {
		return scopDepthFirstVisitorEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__OutIScopAnnotation__IScopAnnotation() {
		return scopDepthFirstVisitorEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__VisitScopRoot__ScopRoot() {
		return scopDepthFirstVisitorEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__InScopRoot__ScopRoot() {
		return scopDepthFirstVisitorEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__OutScopRoot__ScopRoot() {
		return scopDepthFirstVisitorEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__VisitScopFor__ScopFor() {
		return scopDepthFirstVisitorEClass.getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__InScopFor__ScopFor() {
		return scopDepthFirstVisitorEClass.getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__OutScopFor__ScopFor() {
		return scopDepthFirstVisitorEClass.getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__VisitScopBlock__ScopBlock() {
		return scopDepthFirstVisitorEClass.getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__InScopBlock__ScopBlock() {
		return scopDepthFirstVisitorEClass.getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__OutScopBlock__ScopBlock() {
		return scopDepthFirstVisitorEClass.getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__VisitScopGuard__ScopGuard() {
		return scopDepthFirstVisitorEClass.getEOperations().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__InScopGuard__ScopGuard() {
		return scopDepthFirstVisitorEClass.getEOperations().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__OutScopGuard__ScopGuard() {
		return scopDepthFirstVisitorEClass.getEOperations().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__VisitScopStatementMacro__ScopStatementMacro() {
		return scopDepthFirstVisitorEClass.getEOperations().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__InScopStatementMacro__ScopStatementMacro() {
		return scopDepthFirstVisitorEClass.getEOperations().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__OutScopStatementMacro__ScopStatementMacro() {
		return scopDepthFirstVisitorEClass.getEOperations().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__VisitScopUnscannedDomain__ScopUnscannedDomain_1() {
		return scopDepthFirstVisitorEClass.getEOperations().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__InScopUnscannedDomain__ScopUnscannedDomain_1() {
		return scopDepthFirstVisitorEClass.getEOperations().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__OutScopUnscannedDomain__ScopUnscannedDomain_1() {
		return scopDepthFirstVisitorEClass.getEOperations().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__VisitScopAssignment__ScopAssignment() {
		return scopDepthFirstVisitorEClass.getEOperations().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__InScopAssignment__ScopAssignment() {
		return scopDepthFirstVisitorEClass.getEOperations().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__OutScopAssignment__ScopAssignment() {
		return scopDepthFirstVisitorEClass.getEOperations().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__VisitAbstractScopStatement__AbstractScopStatement() {
		return scopDepthFirstVisitorEClass.getEOperations().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__InAbstractScopStatement__AbstractScopStatement() {
		return scopDepthFirstVisitorEClass.getEOperations().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__OutAbstractScopStatement__AbstractScopStatement() {
		return scopDepthFirstVisitorEClass.getEOperations().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__VisitParallelLoopAnnotation__ParallelLoopAnnotation() {
		return scopDepthFirstVisitorEClass.getEOperations().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__InParallelLoopAnnotation__ParallelLoopAnnotation() {
		return scopDepthFirstVisitorEClass.getEOperations().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__OutParallelLoopAnnotation__ParallelLoopAnnotation() {
		return scopDepthFirstVisitorEClass.getEOperations().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__VisitDescriptionAnnotation__DescriptionAnnotation() {
		return scopDepthFirstVisitorEClass.getEOperations().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__InDescriptionAnnotation__DescriptionAnnotation() {
		return scopDepthFirstVisitorEClass.getEOperations().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__OutDescriptionAnnotation__DescriptionAnnotation() {
		return scopDepthFirstVisitorEClass.getEOperations().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__VisitTileLoopAnnotation__TileLoopAnnotation() {
		return scopDepthFirstVisitorEClass.getEOperations().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__InTileLoopAnnotation__TileLoopAnnotation() {
		return scopDepthFirstVisitorEClass.getEOperations().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__OutTileLoopAnnotation__TileLoopAnnotation() {
		return scopDepthFirstVisitorEClass.getEOperations().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__VisitParallelBlockAnnotation__ParallelBlockAnnotation() {
		return scopDepthFirstVisitorEClass.getEOperations().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__InParallelBlockAnnotation__ParallelBlockAnnotation() {
		return scopDepthFirstVisitorEClass.getEOperations().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__OutParallelBlockAnnotation__ParallelBlockAnnotation() {
		return scopDepthFirstVisitorEClass.getEOperations().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__VisitPolyhedralDomainAnnotation__PolyhedralDomainAnnotation() {
		return scopDepthFirstVisitorEClass.getEOperations().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__InPolyhedralDomainAnnotation__PolyhedralDomainAnnotation() {
		return scopDepthFirstVisitorEClass.getEOperations().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__OutPolyhedralDomainAnnotation__PolyhedralDomainAnnotation() {
		return scopDepthFirstVisitorEClass.getEOperations().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__VisitBarrierAnnotation__BarrierAnnotation() {
		return scopDepthFirstVisitorEClass.getEOperations().get(47);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__InBarrierAnnotation__BarrierAnnotation() {
		return scopDepthFirstVisitorEClass.getEOperations().get(48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopDepthFirstVisitor__OutBarrierAnnotation__BarrierAnnotation() {
		return scopDepthFirstVisitorEClass.getEOperations().get(49);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScopUnscannedDomain() {
		return scopUnscannedDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScopUnscannedDomain_MacroParams() {
		return (EReference)scopUnscannedDomainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScopUnscannedDomain_Name() {
		return (EAttribute)scopUnscannedDomainEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScopUnscannedDomain_Schedule() {
		return (EAttribute)scopUnscannedDomainEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getScopUnscannedDomain__Accept__ScopVisitor() {
		return scopUnscannedDomainEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getJNIISLUnionMap() {
		return jniislUnionMapEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopFactory getScopFactory() {
		return (ScopFactory)getEFactoryInstance();
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
		abstractScopNodeEClass = createEClass(ABSTRACT_SCOP_NODE);
		createEReference(abstractScopNodeEClass, ABSTRACT_SCOP_NODE__SCOP_ANNOTATIONS);
		createEOperation(abstractScopNodeEClass, ABSTRACT_SCOP_NODE___GET_SURROUNDING_ITERATORS);
		createEOperation(abstractScopNodeEClass, ABSTRACT_SCOP_NODE___GET_SURROUNDING_SCOP_FORS);
		createEOperation(abstractScopNodeEClass, ABSTRACT_SCOP_NODE___SIMPLIFY);
		createEOperation(abstractScopNodeEClass, ABSTRACT_SCOP_NODE___GET_LOOP_DEPTH);
		createEOperation(abstractScopNodeEClass, ABSTRACT_SCOP_NODE___ACCEPT__SCOPVISITOR);
		createEOperation(abstractScopNodeEClass, ABSTRACT_SCOP_NODE___GET_SURROUNDING_SCOP_FOR);
		createEOperation(abstractScopNodeEClass, ABSTRACT_SCOP_NODE___GET_DERIVED_CONSTRAINTS);

		iScopAnnotationEClass = createEClass(ISCOP_ANNOTATION);
		createEOperation(iScopAnnotationEClass, ISCOP_ANNOTATION___ACCEPT__SCOPVISITOR);

		scopRootEClass = createEClass(SCOP_ROOT);
		createEReference(scopRootEClass, SCOP_ROOT__STATEMENTS);
		createEOperation(scopRootEClass, SCOP_ROOT___SIMPLIFY);
		createEOperation(scopRootEClass, SCOP_ROOT___ACCEPT__SCOPVISITOR);

		scopForEClass = createEClass(SCOP_FOR);
		createEReference(scopForEClass, SCOP_FOR__ITERATOR);
		createEReference(scopForEClass, SCOP_FOR__LB);
		createEReference(scopForEClass, SCOP_FOR__UB);
		createEReference(scopForEClass, SCOP_FOR__STRIDE);
		createEReference(scopForEClass, SCOP_FOR__BODY);
		createEOperation(scopForEClass, SCOP_FOR___ACCEPT__SCOPVISITOR);

		scopBlockEClass = createEClass(SCOP_BLOCK);
		createEReference(scopBlockEClass, SCOP_BLOCK__STATEMENTS);
		createEOperation(scopBlockEClass, SCOP_BLOCK___ACCEPT__SCOPVISITOR);

		scopGuardEClass = createEClass(SCOP_GUARD);
		createEReference(scopGuardEClass, SCOP_GUARD__CONSTRAINT_SYSTEMS);
		createEReference(scopGuardEClass, SCOP_GUARD__THEN_BODY);
		createEReference(scopGuardEClass, SCOP_GUARD__ELSE_BODY);
		createEOperation(scopGuardEClass, SCOP_GUARD___ACCEPT__SCOPVISITOR);

		scopStatementMacroEClass = createEClass(SCOP_STATEMENT_MACRO);
		createEReference(scopStatementMacroEClass, SCOP_STATEMENT_MACRO__MACRO_PARAMS);
		createEAttribute(scopStatementMacroEClass, SCOP_STATEMENT_MACRO__NAME);
		createEOperation(scopStatementMacroEClass, SCOP_STATEMENT_MACRO___ACCEPT__SCOPVISITOR);

		scopAssignmentEClass = createEClass(SCOP_ASSIGNMENT);
		createEReference(scopAssignmentEClass, SCOP_ASSIGNMENT__LHS);
		createEReference(scopAssignmentEClass, SCOP_ASSIGNMENT__RHS);
		createEOperation(scopAssignmentEClass, SCOP_ASSIGNMENT___ACCEPT__SCOPVISITOR);

		abstractScopStatementEClass = createEClass(ABSTRACT_SCOP_STATEMENT);
		createEOperation(abstractScopStatementEClass, ABSTRACT_SCOP_STATEMENT___ACCEPT__SCOPVISITOR);

		scopVisitorEClass = createEClass(SCOP_VISITOR);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___DEFAULT_IN__SCOPVISITABLE);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___DEFAULT_OUT__SCOPVISITABLE);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___VISIT_ABSTRACT_SCOP_NODE__ABSTRACTSCOPNODE);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___IN_ABSTRACT_SCOP_NODE__ABSTRACTSCOPNODE);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___OUT_ABSTRACT_SCOP_NODE__ABSTRACTSCOPNODE);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___VISIT_ISCOP_ANNOTATION__ISCOPANNOTATION);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___IN_ISCOP_ANNOTATION__ISCOPANNOTATION);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___OUT_ISCOP_ANNOTATION__ISCOPANNOTATION);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___VISIT_SCOP_ROOT__SCOPROOT);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___IN_SCOP_ROOT__SCOPROOT);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___OUT_SCOP_ROOT__SCOPROOT);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___VISIT_SCOP_FOR__SCOPFOR);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___IN_SCOP_FOR__SCOPFOR);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___OUT_SCOP_FOR__SCOPFOR);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___VISIT_SCOP_BLOCK__SCOPBLOCK);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___IN_SCOP_BLOCK__SCOPBLOCK);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___OUT_SCOP_BLOCK__SCOPBLOCK);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___VISIT_SCOP_GUARD__SCOPGUARD);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___IN_SCOP_GUARD__SCOPGUARD);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___OUT_SCOP_GUARD__SCOPGUARD);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___VISIT_SCOP_STATEMENT_MACRO__SCOPSTATEMENTMACRO);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___IN_SCOP_STATEMENT_MACRO__SCOPSTATEMENTMACRO);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___OUT_SCOP_STATEMENT_MACRO__SCOPSTATEMENTMACRO);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___VISIT_SCOP_UNSCANNED_DOMAIN__SCOPUNSCANNEDDOMAIN);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___IN_SCOP_UNSCANNED_DOMAIN__SCOPUNSCANNEDDOMAIN);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___OUT_SCOP_UNSCANNED_DOMAIN__SCOPUNSCANNEDDOMAIN);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___VISIT_SCOP_ASSIGNMENT__SCOPASSIGNMENT);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___IN_SCOP_ASSIGNMENT__SCOPASSIGNMENT);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___OUT_SCOP_ASSIGNMENT__SCOPASSIGNMENT);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___VISIT_ABSTRACT_SCOP_STATEMENT__ABSTRACTSCOPSTATEMENT);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___IN_ABSTRACT_SCOP_STATEMENT__ABSTRACTSCOPSTATEMENT);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___OUT_ABSTRACT_SCOP_STATEMENT__ABSTRACTSCOPSTATEMENT);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___VISIT_PARALLEL_LOOP_ANNOTATION__PARALLELLOOPANNOTATION);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___IN_PARALLEL_LOOP_ANNOTATION__PARALLELLOOPANNOTATION);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___OUT_PARALLEL_LOOP_ANNOTATION__PARALLELLOOPANNOTATION);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___VISIT_DESCRIPTION_ANNOTATION__DESCRIPTIONANNOTATION);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___IN_DESCRIPTION_ANNOTATION__DESCRIPTIONANNOTATION);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___OUT_DESCRIPTION_ANNOTATION__DESCRIPTIONANNOTATION);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___VISIT_TILE_LOOP_ANNOTATION__TILELOOPANNOTATION);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___IN_TILE_LOOP_ANNOTATION__TILELOOPANNOTATION);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___OUT_TILE_LOOP_ANNOTATION__TILELOOPANNOTATION);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___VISIT_PARALLEL_BLOCK_ANNOTATION__PARALLELBLOCKANNOTATION);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___IN_PARALLEL_BLOCK_ANNOTATION__PARALLELBLOCKANNOTATION);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___OUT_PARALLEL_BLOCK_ANNOTATION__PARALLELBLOCKANNOTATION);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___VISIT_POLYHEDRAL_DOMAIN_ANNOTATION__POLYHEDRALDOMAINANNOTATION);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___IN_POLYHEDRAL_DOMAIN_ANNOTATION__POLYHEDRALDOMAINANNOTATION);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___OUT_POLYHEDRAL_DOMAIN_ANNOTATION__POLYHEDRALDOMAINANNOTATION);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___VISIT_BARRIER_ANNOTATION__BARRIERANNOTATION);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___IN_BARRIER_ANNOTATION__BARRIERANNOTATION);
		createEOperation(scopVisitorEClass, SCOP_VISITOR___OUT_BARRIER_ANNOTATION__BARRIERANNOTATION);

		scopVisitableEClass = createEClass(SCOP_VISITABLE);
		createEOperation(scopVisitableEClass, SCOP_VISITABLE___ACCEPT__SCOPVISITOR);

		scopDepthFirstVisitorEClass = createEClass(SCOP_DEPTH_FIRST_VISITOR);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___DEFAULT_IN__SCOPVISITABLE);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___DEFAULT_OUT__SCOPVISITABLE);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___VISIT_ABSTRACT_SCOP_NODE__ABSTRACTSCOPNODE);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___IN_ABSTRACT_SCOP_NODE__ABSTRACTSCOPNODE);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___OUT_ABSTRACT_SCOP_NODE__ABSTRACTSCOPNODE);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___VISIT_ISCOP_ANNOTATION__ISCOPANNOTATION);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___IN_ISCOP_ANNOTATION__ISCOPANNOTATION);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___OUT_ISCOP_ANNOTATION__ISCOPANNOTATION);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_ROOT__SCOPROOT);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_ROOT__SCOPROOT);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_ROOT__SCOPROOT);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_FOR__SCOPFOR);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_FOR__SCOPFOR);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_FOR__SCOPFOR);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_BLOCK__SCOPBLOCK);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_BLOCK__SCOPBLOCK);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_BLOCK__SCOPBLOCK);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_GUARD__SCOPGUARD);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_GUARD__SCOPGUARD);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_GUARD__SCOPGUARD);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_STATEMENT_MACRO__SCOPSTATEMENTMACRO);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_STATEMENT_MACRO__SCOPSTATEMENTMACRO);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_STATEMENT_MACRO__SCOPSTATEMENTMACRO);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_UNSCANNED_DOMAIN__SCOPUNSCANNEDDOMAIN_1);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_UNSCANNED_DOMAIN__SCOPUNSCANNEDDOMAIN_1);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_UNSCANNED_DOMAIN__SCOPUNSCANNEDDOMAIN_1);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_ASSIGNMENT__SCOPASSIGNMENT);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_ASSIGNMENT__SCOPASSIGNMENT);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_ASSIGNMENT__SCOPASSIGNMENT);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___VISIT_ABSTRACT_SCOP_STATEMENT__ABSTRACTSCOPSTATEMENT);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___IN_ABSTRACT_SCOP_STATEMENT__ABSTRACTSCOPSTATEMENT);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___OUT_ABSTRACT_SCOP_STATEMENT__ABSTRACTSCOPSTATEMENT);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___VISIT_PARALLEL_LOOP_ANNOTATION__PARALLELLOOPANNOTATION);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___IN_PARALLEL_LOOP_ANNOTATION__PARALLELLOOPANNOTATION);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___OUT_PARALLEL_LOOP_ANNOTATION__PARALLELLOOPANNOTATION);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___VISIT_DESCRIPTION_ANNOTATION__DESCRIPTIONANNOTATION);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___IN_DESCRIPTION_ANNOTATION__DESCRIPTIONANNOTATION);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___OUT_DESCRIPTION_ANNOTATION__DESCRIPTIONANNOTATION);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___VISIT_TILE_LOOP_ANNOTATION__TILELOOPANNOTATION);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___IN_TILE_LOOP_ANNOTATION__TILELOOPANNOTATION);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___OUT_TILE_LOOP_ANNOTATION__TILELOOPANNOTATION);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___VISIT_PARALLEL_BLOCK_ANNOTATION__PARALLELBLOCKANNOTATION);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___IN_PARALLEL_BLOCK_ANNOTATION__PARALLELBLOCKANNOTATION);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___OUT_PARALLEL_BLOCK_ANNOTATION__PARALLELBLOCKANNOTATION);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___VISIT_POLYHEDRAL_DOMAIN_ANNOTATION__POLYHEDRALDOMAINANNOTATION);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___IN_POLYHEDRAL_DOMAIN_ANNOTATION__POLYHEDRALDOMAINANNOTATION);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___OUT_POLYHEDRAL_DOMAIN_ANNOTATION__POLYHEDRALDOMAINANNOTATION);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___VISIT_BARRIER_ANNOTATION__BARRIERANNOTATION);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___IN_BARRIER_ANNOTATION__BARRIERANNOTATION);
		createEOperation(scopDepthFirstVisitorEClass, SCOP_DEPTH_FIRST_VISITOR___OUT_BARRIER_ANNOTATION__BARRIERANNOTATION);

		scopUnscannedDomainEClass = createEClass(SCOP_UNSCANNED_DOMAIN);
		createEReference(scopUnscannedDomainEClass, SCOP_UNSCANNED_DOMAIN__MACRO_PARAMS);
		createEAttribute(scopUnscannedDomainEClass, SCOP_UNSCANNED_DOMAIN__NAME);
		createEAttribute(scopUnscannedDomainEClass, SCOP_UNSCANNED_DOMAIN__SCHEDULE);
		createEOperation(scopUnscannedDomainEClass, SCOP_UNSCANNED_DOMAIN___ACCEPT__SCOPVISITOR);

		// Create data types
		jniislUnionMapEDataType = createEDataType(JNIISL_UNION_MAP);
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
		AnnotationPackage theAnnotationPackage = (AnnotationPackage)EPackage.Registry.INSTANCE.getEPackage(AnnotationPackage.eNS_URI);
		AlgebraPackage theAlgebraPackage = (AlgebraPackage)EPackage.Registry.INSTANCE.getEPackage(AlgebraPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theAnnotationPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		abstractScopNodeEClass.getESuperTypes().add(this.getScopVisitable());
		iScopAnnotationEClass.getESuperTypes().add(this.getScopVisitable());
		scopRootEClass.getESuperTypes().add(this.getScopVisitable());
		scopForEClass.getESuperTypes().add(this.getAbstractScopNode());
		scopForEClass.getESuperTypes().add(this.getScopVisitable());
		scopBlockEClass.getESuperTypes().add(this.getAbstractScopNode());
		scopBlockEClass.getESuperTypes().add(this.getScopVisitable());
		scopGuardEClass.getESuperTypes().add(this.getAbstractScopNode());
		scopGuardEClass.getESuperTypes().add(this.getScopVisitable());
		scopStatementMacroEClass.getESuperTypes().add(this.getAbstractScopStatement());
		scopStatementMacroEClass.getESuperTypes().add(this.getScopVisitable());
		scopAssignmentEClass.getESuperTypes().add(this.getAbstractScopStatement());
		scopAssignmentEClass.getESuperTypes().add(this.getScopVisitable());
		abstractScopStatementEClass.getESuperTypes().add(this.getAbstractScopNode());
		abstractScopStatementEClass.getESuperTypes().add(this.getScopVisitable());
		scopDepthFirstVisitorEClass.getESuperTypes().add(this.getScopVisitor());
		scopUnscannedDomainEClass.getESuperTypes().add(this.getAbstractScopStatement());
		scopUnscannedDomainEClass.getESuperTypes().add(this.getScopVisitable());

		// Initialize classes, features, and operations; add parameters
		initEClass(abstractScopNodeEClass, AbstractScopNode.class, "AbstractScopNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractScopNode_ScopAnnotations(), this.getIScopAnnotation(), null, "scopAnnotations", null, 0, -1, AbstractScopNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAbstractScopNode__GetSurroundingIterators(), theAlgebraPackage.getVariable(), "getSurroundingIterators", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAbstractScopNode__GetSurroundingScopFors(), this.getScopFor(), "getSurroundingScopFors", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAbstractScopNode__Simplify(), this.getAbstractScopNode(), "simplify", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAbstractScopNode__GetLoopDepth(), ecorePackage.getEInt(), "getLoopDepth", 1, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getAbstractScopNode__Accept__ScopVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAbstractScopNode__GetSurroundingScopFor(), this.getScopFor(), "getSurroundingScopFor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAbstractScopNode__GetDerivedConstraints(), theAlgebraPackage.getIntConstraintSystem(), "getDerivedConstraints", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(iScopAnnotationEClass, IScopAnnotation.class, "IScopAnnotation", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getIScopAnnotation__Accept__ScopVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(scopRootEClass, ScopRoot.class, "ScopRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScopRoot_Statements(), this.getAbstractScopNode(), null, "statements", null, 0, -1, ScopRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getScopRoot__Simplify(), this.getScopRoot(), "simplify", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopRoot__Accept__ScopVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(scopForEClass, ScopFor.class, "ScopFor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScopFor_Iterator(), theAlgebraPackage.getVariable(), null, "iterator", null, 1, 1, ScopFor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScopFor_LB(), theAlgebraPackage.getIntExpression(), null, "LB", null, 1, 1, ScopFor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScopFor_UB(), theAlgebraPackage.getIntExpression(), null, "UB", null, 1, 1, ScopFor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScopFor_Stride(), theAlgebraPackage.getIntExpression(), null, "stride", null, 1, 1, ScopFor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScopFor_Body(), this.getAbstractScopNode(), null, "body", null, 0, 1, ScopFor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getScopFor__Accept__ScopVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(scopBlockEClass, ScopBlock.class, "ScopBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScopBlock_Statements(), this.getAbstractScopNode(), null, "statements", null, 0, -1, ScopBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getScopBlock__Accept__ScopVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(scopGuardEClass, ScopGuard.class, "ScopGuard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScopGuard_ConstraintSystems(), theAlgebraPackage.getIntConstraintSystem(), null, "constraintSystems", null, 1, -1, ScopGuard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScopGuard_ThenBody(), this.getAbstractScopNode(), null, "thenBody", null, 1, 1, ScopGuard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScopGuard_ElseBody(), this.getAbstractScopNode(), null, "elseBody", null, 0, 1, ScopGuard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getScopGuard__Accept__ScopVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(scopStatementMacroEClass, ScopStatementMacro.class, "ScopStatementMacro", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScopStatementMacro_MacroParams(), theAlgebraPackage.getIntExpression(), null, "macroParams", null, 0, -1, ScopStatementMacro.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScopStatementMacro_Name(), ecorePackage.getEString(), "name", null, 1, 1, ScopStatementMacro.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getScopStatementMacro__Accept__ScopVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(scopAssignmentEClass, ScopAssignment.class, "ScopAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScopAssignment_LHS(), theAlgebraPackage.getVariable(), null, "LHS", null, 1, 1, ScopAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getScopAssignment_RHS(), theAlgebraPackage.getIntExpression(), null, "RHS", null, 1, 1, ScopAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getScopAssignment__Accept__ScopVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(abstractScopStatementEClass, AbstractScopStatement.class, "AbstractScopStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getAbstractScopStatement__Accept__ScopVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(scopVisitorEClass, ScopVisitor.class, "ScopVisitor", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getScopVisitor__DefaultIn__ScopVisitable(), null, "defaultIn", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopVisitable(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__DefaultOut__ScopVisitable(), null, "defaultOut", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopVisitable(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__VisitAbstractScopNode__AbstractScopNode(), null, "visitAbstractScopNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAbstractScopNode(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__InAbstractScopNode__AbstractScopNode(), null, "inAbstractScopNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAbstractScopNode(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__OutAbstractScopNode__AbstractScopNode(), null, "outAbstractScopNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAbstractScopNode(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__VisitIScopAnnotation__IScopAnnotation(), null, "visitIScopAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIScopAnnotation(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__InIScopAnnotation__IScopAnnotation(), null, "inIScopAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIScopAnnotation(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__OutIScopAnnotation__IScopAnnotation(), null, "outIScopAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIScopAnnotation(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__VisitScopRoot__ScopRoot(), null, "visitScopRoot", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopRoot(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__InScopRoot__ScopRoot(), null, "inScopRoot", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopRoot(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__OutScopRoot__ScopRoot(), null, "outScopRoot", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopRoot(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__VisitScopFor__ScopFor(), null, "visitScopFor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopFor(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__InScopFor__ScopFor(), null, "inScopFor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopFor(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__OutScopFor__ScopFor(), null, "outScopFor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopFor(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__VisitScopBlock__ScopBlock(), null, "visitScopBlock", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopBlock(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__InScopBlock__ScopBlock(), null, "inScopBlock", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopBlock(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__OutScopBlock__ScopBlock(), null, "outScopBlock", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopBlock(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__VisitScopGuard__ScopGuard(), null, "visitScopGuard", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopGuard(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__InScopGuard__ScopGuard(), null, "inScopGuard", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopGuard(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__OutScopGuard__ScopGuard(), null, "outScopGuard", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopGuard(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__VisitScopStatementMacro__ScopStatementMacro(), null, "visitScopStatementMacro", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopStatementMacro(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__InScopStatementMacro__ScopStatementMacro(), null, "inScopStatementMacro", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopStatementMacro(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__OutScopStatementMacro__ScopStatementMacro(), null, "outScopStatementMacro", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopStatementMacro(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__VisitScopUnscannedDomain__ScopUnscannedDomain(), null, "visitScopUnscannedDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopUnscannedDomain(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__InScopUnscannedDomain__ScopUnscannedDomain(), null, "inScopUnscannedDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopUnscannedDomain(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__OutScopUnscannedDomain__ScopUnscannedDomain(), null, "outScopUnscannedDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopUnscannedDomain(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__VisitScopAssignment__ScopAssignment(), null, "visitScopAssignment", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopAssignment(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__InScopAssignment__ScopAssignment(), null, "inScopAssignment", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopAssignment(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__OutScopAssignment__ScopAssignment(), null, "outScopAssignment", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopAssignment(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__VisitAbstractScopStatement__AbstractScopStatement(), null, "visitAbstractScopStatement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAbstractScopStatement(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__InAbstractScopStatement__AbstractScopStatement(), null, "inAbstractScopStatement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAbstractScopStatement(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__OutAbstractScopStatement__AbstractScopStatement(), null, "outAbstractScopStatement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAbstractScopStatement(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__VisitParallelLoopAnnotation__ParallelLoopAnnotation(), null, "visitParallelLoopAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getParallelLoopAnnotation(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__InParallelLoopAnnotation__ParallelLoopAnnotation(), null, "inParallelLoopAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getParallelLoopAnnotation(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__OutParallelLoopAnnotation__ParallelLoopAnnotation(), null, "outParallelLoopAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getParallelLoopAnnotation(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__VisitDescriptionAnnotation__DescriptionAnnotation(), null, "visitDescriptionAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getDescriptionAnnotation(), "d", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__InDescriptionAnnotation__DescriptionAnnotation(), null, "inDescriptionAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getDescriptionAnnotation(), "d", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__OutDescriptionAnnotation__DescriptionAnnotation(), null, "outDescriptionAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getDescriptionAnnotation(), "d", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__VisitTileLoopAnnotation__TileLoopAnnotation(), null, "visitTileLoopAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getTileLoopAnnotation(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__InTileLoopAnnotation__TileLoopAnnotation(), null, "inTileLoopAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getTileLoopAnnotation(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__OutTileLoopAnnotation__TileLoopAnnotation(), null, "outTileLoopAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getTileLoopAnnotation(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__VisitParallelBlockAnnotation__ParallelBlockAnnotation(), null, "visitParallelBlockAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getParallelBlockAnnotation(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__InParallelBlockAnnotation__ParallelBlockAnnotation(), null, "inParallelBlockAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getParallelBlockAnnotation(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__OutParallelBlockAnnotation__ParallelBlockAnnotation(), null, "outParallelBlockAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getParallelBlockAnnotation(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__VisitPolyhedralDomainAnnotation__PolyhedralDomainAnnotation(), null, "visitPolyhedralDomainAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getPolyhedralDomainAnnotation(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__InPolyhedralDomainAnnotation__PolyhedralDomainAnnotation(), null, "inPolyhedralDomainAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getPolyhedralDomainAnnotation(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__OutPolyhedralDomainAnnotation__PolyhedralDomainAnnotation(), null, "outPolyhedralDomainAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getPolyhedralDomainAnnotation(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__VisitBarrierAnnotation__BarrierAnnotation(), null, "visitBarrierAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getBarrierAnnotation(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__InBarrierAnnotation__BarrierAnnotation(), null, "inBarrierAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getBarrierAnnotation(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopVisitor__OutBarrierAnnotation__BarrierAnnotation(), null, "outBarrierAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getBarrierAnnotation(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(scopVisitableEClass, ScopVisitable.class, "ScopVisitable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getScopVisitable__Accept__ScopVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(scopDepthFirstVisitorEClass, ScopDepthFirstVisitor.class, "ScopDepthFirstVisitor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getScopDepthFirstVisitor__DefaultIn__ScopVisitable(), null, "defaultIn", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopVisitable(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__DefaultOut__ScopVisitable(), null, "defaultOut", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopVisitable(), "node", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__VisitAbstractScopNode__AbstractScopNode(), null, "visitAbstractScopNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAbstractScopNode(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__InAbstractScopNode__AbstractScopNode(), null, "inAbstractScopNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAbstractScopNode(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__OutAbstractScopNode__AbstractScopNode(), null, "outAbstractScopNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAbstractScopNode(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__VisitIScopAnnotation__IScopAnnotation(), null, "visitIScopAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIScopAnnotation(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__InIScopAnnotation__IScopAnnotation(), null, "inIScopAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIScopAnnotation(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__OutIScopAnnotation__IScopAnnotation(), null, "outIScopAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIScopAnnotation(), "i", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__VisitScopRoot__ScopRoot(), null, "visitScopRoot", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopRoot(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__InScopRoot__ScopRoot(), null, "inScopRoot", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopRoot(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__OutScopRoot__ScopRoot(), null, "outScopRoot", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopRoot(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__VisitScopFor__ScopFor(), null, "visitScopFor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopFor(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__InScopFor__ScopFor(), null, "inScopFor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopFor(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__OutScopFor__ScopFor(), null, "outScopFor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopFor(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__VisitScopBlock__ScopBlock(), null, "visitScopBlock", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopBlock(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__InScopBlock__ScopBlock(), null, "inScopBlock", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopBlock(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__OutScopBlock__ScopBlock(), null, "outScopBlock", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopBlock(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__VisitScopGuard__ScopGuard(), null, "visitScopGuard", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopGuard(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__InScopGuard__ScopGuard(), null, "inScopGuard", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopGuard(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__OutScopGuard__ScopGuard(), null, "outScopGuard", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopGuard(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__VisitScopStatementMacro__ScopStatementMacro(), null, "visitScopStatementMacro", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopStatementMacro(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__InScopStatementMacro__ScopStatementMacro(), null, "inScopStatementMacro", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopStatementMacro(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__OutScopStatementMacro__ScopStatementMacro(), null, "outScopStatementMacro", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopStatementMacro(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__VisitScopUnscannedDomain__ScopUnscannedDomain_1(), null, "visitScopUnscannedDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopUnscannedDomain(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__InScopUnscannedDomain__ScopUnscannedDomain_1(), null, "inScopUnscannedDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopUnscannedDomain(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__OutScopUnscannedDomain__ScopUnscannedDomain_1(), null, "outScopUnscannedDomain", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopUnscannedDomain(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__VisitScopAssignment__ScopAssignment(), null, "visitScopAssignment", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopAssignment(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__InScopAssignment__ScopAssignment(), null, "inScopAssignment", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopAssignment(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__OutScopAssignment__ScopAssignment(), null, "outScopAssignment", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopAssignment(), "s", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__VisitAbstractScopStatement__AbstractScopStatement(), null, "visitAbstractScopStatement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAbstractScopStatement(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__InAbstractScopStatement__AbstractScopStatement(), null, "inAbstractScopStatement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAbstractScopStatement(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__OutAbstractScopStatement__AbstractScopStatement(), null, "outAbstractScopStatement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAbstractScopStatement(), "a", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__VisitParallelLoopAnnotation__ParallelLoopAnnotation(), null, "visitParallelLoopAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getParallelLoopAnnotation(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__InParallelLoopAnnotation__ParallelLoopAnnotation(), null, "inParallelLoopAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getParallelLoopAnnotation(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__OutParallelLoopAnnotation__ParallelLoopAnnotation(), null, "outParallelLoopAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getParallelLoopAnnotation(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__VisitDescriptionAnnotation__DescriptionAnnotation(), null, "visitDescriptionAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getDescriptionAnnotation(), "d", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__InDescriptionAnnotation__DescriptionAnnotation(), null, "inDescriptionAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getDescriptionAnnotation(), "d", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__OutDescriptionAnnotation__DescriptionAnnotation(), null, "outDescriptionAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getDescriptionAnnotation(), "d", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__VisitTileLoopAnnotation__TileLoopAnnotation(), null, "visitTileLoopAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getTileLoopAnnotation(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__InTileLoopAnnotation__TileLoopAnnotation(), null, "inTileLoopAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getTileLoopAnnotation(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__OutTileLoopAnnotation__TileLoopAnnotation(), null, "outTileLoopAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getTileLoopAnnotation(), "t", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__VisitParallelBlockAnnotation__ParallelBlockAnnotation(), null, "visitParallelBlockAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getParallelBlockAnnotation(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__InParallelBlockAnnotation__ParallelBlockAnnotation(), null, "inParallelBlockAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getParallelBlockAnnotation(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__OutParallelBlockAnnotation__ParallelBlockAnnotation(), null, "outParallelBlockAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getParallelBlockAnnotation(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__VisitPolyhedralDomainAnnotation__PolyhedralDomainAnnotation(), null, "visitPolyhedralDomainAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getPolyhedralDomainAnnotation(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__InPolyhedralDomainAnnotation__PolyhedralDomainAnnotation(), null, "inPolyhedralDomainAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getPolyhedralDomainAnnotation(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__OutPolyhedralDomainAnnotation__PolyhedralDomainAnnotation(), null, "outPolyhedralDomainAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getPolyhedralDomainAnnotation(), "p", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__VisitBarrierAnnotation__BarrierAnnotation(), null, "visitBarrierAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getBarrierAnnotation(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__InBarrierAnnotation__BarrierAnnotation(), null, "inBarrierAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getBarrierAnnotation(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getScopDepthFirstVisitor__OutBarrierAnnotation__BarrierAnnotation(), null, "outBarrierAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theAnnotationPackage.getBarrierAnnotation(), "b", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(scopUnscannedDomainEClass, ScopUnscannedDomain.class, "ScopUnscannedDomain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScopUnscannedDomain_MacroParams(), theAlgebraPackage.getIntExpression(), null, "macroParams", null, 0, -1, ScopUnscannedDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScopUnscannedDomain_Name(), ecorePackage.getEString(), "name", null, 1, 1, ScopUnscannedDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScopUnscannedDomain_Schedule(), this.getJNIISLUnionMap(), "schedule", null, 0, 1, ScopUnscannedDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getScopUnscannedDomain__Accept__ScopVisitor(), null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScopVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize data types
		initEDataType(jniislUnionMapEDataType, JNIISLUnionMap.class, "JNIISLUnionMap", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ScopPackageImpl
