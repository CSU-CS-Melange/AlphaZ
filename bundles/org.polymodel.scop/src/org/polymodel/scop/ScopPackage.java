/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.polymodel.scop.ScopFactory
 * @model kind="package"
 * @generated
 */
public interface ScopPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "scop";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://polymodel.scop";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "scop";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ScopPackage eINSTANCE = org.polymodel.scop.impl.ScopPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.polymodel.scop.ScopVisitable <em>Visitable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.scop.ScopVisitable
	 * @see org.polymodel.scop.impl.ScopPackageImpl#getScopVisitable()
	 * @generated
	 */
	int SCOP_VISITABLE = 10;

	/**
	 * The number of structural features of the '<em>Visitable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITABLE_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITABLE___ACCEPT__SCOPVISITOR = 0;

	/**
	 * The number of operations of the '<em>Visitable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITABLE_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.polymodel.scop.impl.AbstractScopNodeImpl <em>Abstract Scop Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.scop.impl.AbstractScopNodeImpl
	 * @see org.polymodel.scop.impl.ScopPackageImpl#getAbstractScopNode()
	 * @generated
	 */
	int ABSTRACT_SCOP_NODE = 0;

	/**
	 * The feature id for the '<em><b>Scop Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SCOP_NODE__SCOP_ANNOTATIONS = SCOP_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Scop Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SCOP_NODE_FEATURE_COUNT = SCOP_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Surrounding Iterators</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SCOP_NODE___GET_SURROUNDING_ITERATORS = SCOP_VISITABLE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Surrounding Scop Fors</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SCOP_NODE___GET_SURROUNDING_SCOP_FORS = SCOP_VISITABLE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SCOP_NODE___SIMPLIFY = SCOP_VISITABLE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Loop Depth</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SCOP_NODE___GET_LOOP_DEPTH = SCOP_VISITABLE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SCOP_NODE___ACCEPT__SCOPVISITOR = SCOP_VISITABLE_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Surrounding Scop For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SCOP_NODE___GET_SURROUNDING_SCOP_FOR = SCOP_VISITABLE_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Get Derived Constraints</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SCOP_NODE___GET_DERIVED_CONSTRAINTS = SCOP_VISITABLE_OPERATION_COUNT + 6;

	/**
	 * The number of operations of the '<em>Abstract Scop Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SCOP_NODE_OPERATION_COUNT = SCOP_VISITABLE_OPERATION_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.polymodel.scop.IScopAnnotation <em>IScop Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.scop.IScopAnnotation
	 * @see org.polymodel.scop.impl.ScopPackageImpl#getIScopAnnotation()
	 * @generated
	 */
	int ISCOP_ANNOTATION = 1;

	/**
	 * The number of structural features of the '<em>IScop Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISCOP_ANNOTATION_FEATURE_COUNT = SCOP_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISCOP_ANNOTATION___ACCEPT__SCOPVISITOR = SCOP_VISITABLE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>IScop Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISCOP_ANNOTATION_OPERATION_COUNT = SCOP_VISITABLE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.scop.impl.ScopRootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.scop.impl.ScopRootImpl
	 * @see org.polymodel.scop.impl.ScopPackageImpl#getScopRoot()
	 * @generated
	 */
	int SCOP_ROOT = 2;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_ROOT__STATEMENTS = SCOP_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_ROOT_FEATURE_COUNT = SCOP_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_ROOT___SIMPLIFY = SCOP_VISITABLE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_ROOT___ACCEPT__SCOPVISITOR = SCOP_VISITABLE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_ROOT_OPERATION_COUNT = SCOP_VISITABLE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.polymodel.scop.impl.ScopForImpl <em>For</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.scop.impl.ScopForImpl
	 * @see org.polymodel.scop.impl.ScopPackageImpl#getScopFor()
	 * @generated
	 */
	int SCOP_FOR = 3;

	/**
	 * The feature id for the '<em><b>Scop Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_FOR__SCOP_ANNOTATIONS = ABSTRACT_SCOP_NODE__SCOP_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_FOR__ITERATOR = ABSTRACT_SCOP_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>LB</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_FOR__LB = ABSTRACT_SCOP_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>UB</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_FOR__UB = ABSTRACT_SCOP_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Stride</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_FOR__STRIDE = ABSTRACT_SCOP_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_FOR__BODY = ABSTRACT_SCOP_NODE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>For</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_FOR_FEATURE_COUNT = ABSTRACT_SCOP_NODE_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Get Surrounding Iterators</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_FOR___GET_SURROUNDING_ITERATORS = ABSTRACT_SCOP_NODE___GET_SURROUNDING_ITERATORS;

	/**
	 * The operation id for the '<em>Get Surrounding Scop Fors</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_FOR___GET_SURROUNDING_SCOP_FORS = ABSTRACT_SCOP_NODE___GET_SURROUNDING_SCOP_FORS;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_FOR___SIMPLIFY = ABSTRACT_SCOP_NODE___SIMPLIFY;

	/**
	 * The operation id for the '<em>Get Loop Depth</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_FOR___GET_LOOP_DEPTH = ABSTRACT_SCOP_NODE___GET_LOOP_DEPTH;

	/**
	 * The operation id for the '<em>Get Surrounding Scop For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_FOR___GET_SURROUNDING_SCOP_FOR = ABSTRACT_SCOP_NODE___GET_SURROUNDING_SCOP_FOR;

	/**
	 * The operation id for the '<em>Get Derived Constraints</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_FOR___GET_DERIVED_CONSTRAINTS = ABSTRACT_SCOP_NODE___GET_DERIVED_CONSTRAINTS;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_FOR___ACCEPT__SCOPVISITOR = ABSTRACT_SCOP_NODE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>For</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_FOR_OPERATION_COUNT = ABSTRACT_SCOP_NODE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.scop.impl.ScopBlockImpl <em>Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.scop.impl.ScopBlockImpl
	 * @see org.polymodel.scop.impl.ScopPackageImpl#getScopBlock()
	 * @generated
	 */
	int SCOP_BLOCK = 4;

	/**
	 * The feature id for the '<em><b>Scop Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_BLOCK__SCOP_ANNOTATIONS = ABSTRACT_SCOP_NODE__SCOP_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_BLOCK__STATEMENTS = ABSTRACT_SCOP_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_BLOCK_FEATURE_COUNT = ABSTRACT_SCOP_NODE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Surrounding Iterators</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_BLOCK___GET_SURROUNDING_ITERATORS = ABSTRACT_SCOP_NODE___GET_SURROUNDING_ITERATORS;

	/**
	 * The operation id for the '<em>Get Surrounding Scop Fors</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_BLOCK___GET_SURROUNDING_SCOP_FORS = ABSTRACT_SCOP_NODE___GET_SURROUNDING_SCOP_FORS;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_BLOCK___SIMPLIFY = ABSTRACT_SCOP_NODE___SIMPLIFY;

	/**
	 * The operation id for the '<em>Get Loop Depth</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_BLOCK___GET_LOOP_DEPTH = ABSTRACT_SCOP_NODE___GET_LOOP_DEPTH;

	/**
	 * The operation id for the '<em>Get Surrounding Scop For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_BLOCK___GET_SURROUNDING_SCOP_FOR = ABSTRACT_SCOP_NODE___GET_SURROUNDING_SCOP_FOR;

	/**
	 * The operation id for the '<em>Get Derived Constraints</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_BLOCK___GET_DERIVED_CONSTRAINTS = ABSTRACT_SCOP_NODE___GET_DERIVED_CONSTRAINTS;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_BLOCK___ACCEPT__SCOPVISITOR = ABSTRACT_SCOP_NODE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_BLOCK_OPERATION_COUNT = ABSTRACT_SCOP_NODE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.scop.impl.ScopGuardImpl <em>Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.scop.impl.ScopGuardImpl
	 * @see org.polymodel.scop.impl.ScopPackageImpl#getScopGuard()
	 * @generated
	 */
	int SCOP_GUARD = 5;

	/**
	 * The feature id for the '<em><b>Scop Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_GUARD__SCOP_ANNOTATIONS = ABSTRACT_SCOP_NODE__SCOP_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Constraint Systems</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_GUARD__CONSTRAINT_SYSTEMS = ABSTRACT_SCOP_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_GUARD__THEN_BODY = ABSTRACT_SCOP_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_GUARD__ELSE_BODY = ABSTRACT_SCOP_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_GUARD_FEATURE_COUNT = ABSTRACT_SCOP_NODE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Surrounding Iterators</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_GUARD___GET_SURROUNDING_ITERATORS = ABSTRACT_SCOP_NODE___GET_SURROUNDING_ITERATORS;

	/**
	 * The operation id for the '<em>Get Surrounding Scop Fors</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_GUARD___GET_SURROUNDING_SCOP_FORS = ABSTRACT_SCOP_NODE___GET_SURROUNDING_SCOP_FORS;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_GUARD___SIMPLIFY = ABSTRACT_SCOP_NODE___SIMPLIFY;

	/**
	 * The operation id for the '<em>Get Loop Depth</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_GUARD___GET_LOOP_DEPTH = ABSTRACT_SCOP_NODE___GET_LOOP_DEPTH;

	/**
	 * The operation id for the '<em>Get Surrounding Scop For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_GUARD___GET_SURROUNDING_SCOP_FOR = ABSTRACT_SCOP_NODE___GET_SURROUNDING_SCOP_FOR;

	/**
	 * The operation id for the '<em>Get Derived Constraints</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_GUARD___GET_DERIVED_CONSTRAINTS = ABSTRACT_SCOP_NODE___GET_DERIVED_CONSTRAINTS;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_GUARD___ACCEPT__SCOPVISITOR = ABSTRACT_SCOP_NODE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_GUARD_OPERATION_COUNT = ABSTRACT_SCOP_NODE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.scop.impl.AbstractScopStatementImpl <em>Abstract Scop Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.scop.impl.AbstractScopStatementImpl
	 * @see org.polymodel.scop.impl.ScopPackageImpl#getAbstractScopStatement()
	 * @generated
	 */
	int ABSTRACT_SCOP_STATEMENT = 8;

	/**
	 * The feature id for the '<em><b>Scop Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SCOP_STATEMENT__SCOP_ANNOTATIONS = ABSTRACT_SCOP_NODE__SCOP_ANNOTATIONS;

	/**
	 * The number of structural features of the '<em>Abstract Scop Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SCOP_STATEMENT_FEATURE_COUNT = ABSTRACT_SCOP_NODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Surrounding Iterators</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SCOP_STATEMENT___GET_SURROUNDING_ITERATORS = ABSTRACT_SCOP_NODE___GET_SURROUNDING_ITERATORS;

	/**
	 * The operation id for the '<em>Get Surrounding Scop Fors</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SCOP_STATEMENT___GET_SURROUNDING_SCOP_FORS = ABSTRACT_SCOP_NODE___GET_SURROUNDING_SCOP_FORS;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SCOP_STATEMENT___SIMPLIFY = ABSTRACT_SCOP_NODE___SIMPLIFY;

	/**
	 * The operation id for the '<em>Get Loop Depth</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SCOP_STATEMENT___GET_LOOP_DEPTH = ABSTRACT_SCOP_NODE___GET_LOOP_DEPTH;

	/**
	 * The operation id for the '<em>Get Surrounding Scop For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SCOP_STATEMENT___GET_SURROUNDING_SCOP_FOR = ABSTRACT_SCOP_NODE___GET_SURROUNDING_SCOP_FOR;

	/**
	 * The operation id for the '<em>Get Derived Constraints</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SCOP_STATEMENT___GET_DERIVED_CONSTRAINTS = ABSTRACT_SCOP_NODE___GET_DERIVED_CONSTRAINTS;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SCOP_STATEMENT___ACCEPT__SCOPVISITOR = ABSTRACT_SCOP_NODE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Abstract Scop Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SCOP_STATEMENT_OPERATION_COUNT = ABSTRACT_SCOP_NODE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.scop.impl.ScopStatementMacroImpl <em>Statement Macro</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.scop.impl.ScopStatementMacroImpl
	 * @see org.polymodel.scop.impl.ScopPackageImpl#getScopStatementMacro()
	 * @generated
	 */
	int SCOP_STATEMENT_MACRO = 6;

	/**
	 * The feature id for the '<em><b>Scop Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_STATEMENT_MACRO__SCOP_ANNOTATIONS = ABSTRACT_SCOP_STATEMENT__SCOP_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Macro Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_STATEMENT_MACRO__MACRO_PARAMS = ABSTRACT_SCOP_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_STATEMENT_MACRO__NAME = ABSTRACT_SCOP_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Statement Macro</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_STATEMENT_MACRO_FEATURE_COUNT = ABSTRACT_SCOP_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Surrounding Iterators</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_STATEMENT_MACRO___GET_SURROUNDING_ITERATORS = ABSTRACT_SCOP_STATEMENT___GET_SURROUNDING_ITERATORS;

	/**
	 * The operation id for the '<em>Get Surrounding Scop Fors</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_STATEMENT_MACRO___GET_SURROUNDING_SCOP_FORS = ABSTRACT_SCOP_STATEMENT___GET_SURROUNDING_SCOP_FORS;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_STATEMENT_MACRO___SIMPLIFY = ABSTRACT_SCOP_STATEMENT___SIMPLIFY;

	/**
	 * The operation id for the '<em>Get Loop Depth</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_STATEMENT_MACRO___GET_LOOP_DEPTH = ABSTRACT_SCOP_STATEMENT___GET_LOOP_DEPTH;

	/**
	 * The operation id for the '<em>Get Surrounding Scop For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_STATEMENT_MACRO___GET_SURROUNDING_SCOP_FOR = ABSTRACT_SCOP_STATEMENT___GET_SURROUNDING_SCOP_FOR;

	/**
	 * The operation id for the '<em>Get Derived Constraints</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_STATEMENT_MACRO___GET_DERIVED_CONSTRAINTS = ABSTRACT_SCOP_STATEMENT___GET_DERIVED_CONSTRAINTS;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_STATEMENT_MACRO___ACCEPT__SCOPVISITOR = ABSTRACT_SCOP_STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Statement Macro</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_STATEMENT_MACRO_OPERATION_COUNT = ABSTRACT_SCOP_STATEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.scop.impl.ScopAssignmentImpl <em>Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.scop.impl.ScopAssignmentImpl
	 * @see org.polymodel.scop.impl.ScopPackageImpl#getScopAssignment()
	 * @generated
	 */
	int SCOP_ASSIGNMENT = 7;

	/**
	 * The feature id for the '<em><b>Scop Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_ASSIGNMENT__SCOP_ANNOTATIONS = ABSTRACT_SCOP_STATEMENT__SCOP_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>LHS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_ASSIGNMENT__LHS = ABSTRACT_SCOP_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>RHS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_ASSIGNMENT__RHS = ABSTRACT_SCOP_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_ASSIGNMENT_FEATURE_COUNT = ABSTRACT_SCOP_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Surrounding Iterators</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_ASSIGNMENT___GET_SURROUNDING_ITERATORS = ABSTRACT_SCOP_STATEMENT___GET_SURROUNDING_ITERATORS;

	/**
	 * The operation id for the '<em>Get Surrounding Scop Fors</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_ASSIGNMENT___GET_SURROUNDING_SCOP_FORS = ABSTRACT_SCOP_STATEMENT___GET_SURROUNDING_SCOP_FORS;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_ASSIGNMENT___SIMPLIFY = ABSTRACT_SCOP_STATEMENT___SIMPLIFY;

	/**
	 * The operation id for the '<em>Get Loop Depth</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_ASSIGNMENT___GET_LOOP_DEPTH = ABSTRACT_SCOP_STATEMENT___GET_LOOP_DEPTH;

	/**
	 * The operation id for the '<em>Get Surrounding Scop For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_ASSIGNMENT___GET_SURROUNDING_SCOP_FOR = ABSTRACT_SCOP_STATEMENT___GET_SURROUNDING_SCOP_FOR;

	/**
	 * The operation id for the '<em>Get Derived Constraints</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_ASSIGNMENT___GET_DERIVED_CONSTRAINTS = ABSTRACT_SCOP_STATEMENT___GET_DERIVED_CONSTRAINTS;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_ASSIGNMENT___ACCEPT__SCOPVISITOR = ABSTRACT_SCOP_STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_ASSIGNMENT_OPERATION_COUNT = ABSTRACT_SCOP_STATEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polymodel.scop.ScopVisitor <em>Visitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.scop.ScopVisitor
	 * @see org.polymodel.scop.impl.ScopPackageImpl#getScopVisitor()
	 * @generated
	 */
	int SCOP_VISITOR = 9;

	/**
	 * The number of structural features of the '<em>Visitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Default In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___DEFAULT_IN__SCOPVISITABLE = 0;

	/**
	 * The operation id for the '<em>Default Out</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___DEFAULT_OUT__SCOPVISITABLE = 1;

	/**
	 * The operation id for the '<em>Visit Abstract Scop Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___VISIT_ABSTRACT_SCOP_NODE__ABSTRACTSCOPNODE = 2;

	/**
	 * The operation id for the '<em>In Abstract Scop Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___IN_ABSTRACT_SCOP_NODE__ABSTRACTSCOPNODE = 3;

	/**
	 * The operation id for the '<em>Out Abstract Scop Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___OUT_ABSTRACT_SCOP_NODE__ABSTRACTSCOPNODE = 4;

	/**
	 * The operation id for the '<em>Visit IScop Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___VISIT_ISCOP_ANNOTATION__ISCOPANNOTATION = 5;

	/**
	 * The operation id for the '<em>In IScop Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___IN_ISCOP_ANNOTATION__ISCOPANNOTATION = 6;

	/**
	 * The operation id for the '<em>Out IScop Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___OUT_ISCOP_ANNOTATION__ISCOPANNOTATION = 7;

	/**
	 * The operation id for the '<em>Visit Scop Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___VISIT_SCOP_ROOT__SCOPROOT = 8;

	/**
	 * The operation id for the '<em>In Scop Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___IN_SCOP_ROOT__SCOPROOT = 9;

	/**
	 * The operation id for the '<em>Out Scop Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___OUT_SCOP_ROOT__SCOPROOT = 10;

	/**
	 * The operation id for the '<em>Visit Scop For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___VISIT_SCOP_FOR__SCOPFOR = 11;

	/**
	 * The operation id for the '<em>In Scop For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___IN_SCOP_FOR__SCOPFOR = 12;

	/**
	 * The operation id for the '<em>Out Scop For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___OUT_SCOP_FOR__SCOPFOR = 13;

	/**
	 * The operation id for the '<em>Visit Scop Block</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___VISIT_SCOP_BLOCK__SCOPBLOCK = 14;

	/**
	 * The operation id for the '<em>In Scop Block</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___IN_SCOP_BLOCK__SCOPBLOCK = 15;

	/**
	 * The operation id for the '<em>Out Scop Block</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___OUT_SCOP_BLOCK__SCOPBLOCK = 16;

	/**
	 * The operation id for the '<em>Visit Scop Guard</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___VISIT_SCOP_GUARD__SCOPGUARD = 17;

	/**
	 * The operation id for the '<em>In Scop Guard</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___IN_SCOP_GUARD__SCOPGUARD = 18;

	/**
	 * The operation id for the '<em>Out Scop Guard</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___OUT_SCOP_GUARD__SCOPGUARD = 19;

	/**
	 * The operation id for the '<em>Visit Scop Statement Macro</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___VISIT_SCOP_STATEMENT_MACRO__SCOPSTATEMENTMACRO = 20;

	/**
	 * The operation id for the '<em>In Scop Statement Macro</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___IN_SCOP_STATEMENT_MACRO__SCOPSTATEMENTMACRO = 21;

	/**
	 * The operation id for the '<em>Out Scop Statement Macro</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___OUT_SCOP_STATEMENT_MACRO__SCOPSTATEMENTMACRO = 22;

	/**
	 * The operation id for the '<em>Visit Scop Unscanned Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___VISIT_SCOP_UNSCANNED_DOMAIN__SCOPUNSCANNEDDOMAIN = 23;

	/**
	 * The operation id for the '<em>In Scop Unscanned Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___IN_SCOP_UNSCANNED_DOMAIN__SCOPUNSCANNEDDOMAIN = 24;

	/**
	 * The operation id for the '<em>Out Scop Unscanned Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___OUT_SCOP_UNSCANNED_DOMAIN__SCOPUNSCANNEDDOMAIN = 25;

	/**
	 * The operation id for the '<em>Visit Scop Assignment</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___VISIT_SCOP_ASSIGNMENT__SCOPASSIGNMENT = 26;

	/**
	 * The operation id for the '<em>In Scop Assignment</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___IN_SCOP_ASSIGNMENT__SCOPASSIGNMENT = 27;

	/**
	 * The operation id for the '<em>Out Scop Assignment</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___OUT_SCOP_ASSIGNMENT__SCOPASSIGNMENT = 28;

	/**
	 * The operation id for the '<em>Visit Abstract Scop Statement</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___VISIT_ABSTRACT_SCOP_STATEMENT__ABSTRACTSCOPSTATEMENT = 29;

	/**
	 * The operation id for the '<em>In Abstract Scop Statement</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___IN_ABSTRACT_SCOP_STATEMENT__ABSTRACTSCOPSTATEMENT = 30;

	/**
	 * The operation id for the '<em>Out Abstract Scop Statement</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___OUT_ABSTRACT_SCOP_STATEMENT__ABSTRACTSCOPSTATEMENT = 31;

	/**
	 * The operation id for the '<em>Visit Parallel Loop Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___VISIT_PARALLEL_LOOP_ANNOTATION__PARALLELLOOPANNOTATION = 32;

	/**
	 * The operation id for the '<em>In Parallel Loop Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___IN_PARALLEL_LOOP_ANNOTATION__PARALLELLOOPANNOTATION = 33;

	/**
	 * The operation id for the '<em>Out Parallel Loop Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___OUT_PARALLEL_LOOP_ANNOTATION__PARALLELLOOPANNOTATION = 34;

	/**
	 * The operation id for the '<em>Visit Description Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___VISIT_DESCRIPTION_ANNOTATION__DESCRIPTIONANNOTATION = 35;

	/**
	 * The operation id for the '<em>In Description Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___IN_DESCRIPTION_ANNOTATION__DESCRIPTIONANNOTATION = 36;

	/**
	 * The operation id for the '<em>Out Description Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___OUT_DESCRIPTION_ANNOTATION__DESCRIPTIONANNOTATION = 37;

	/**
	 * The operation id for the '<em>Visit Tile Loop Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___VISIT_TILE_LOOP_ANNOTATION__TILELOOPANNOTATION = 38;

	/**
	 * The operation id for the '<em>In Tile Loop Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___IN_TILE_LOOP_ANNOTATION__TILELOOPANNOTATION = 39;

	/**
	 * The operation id for the '<em>Out Tile Loop Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___OUT_TILE_LOOP_ANNOTATION__TILELOOPANNOTATION = 40;

	/**
	 * The operation id for the '<em>Visit Parallel Block Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___VISIT_PARALLEL_BLOCK_ANNOTATION__PARALLELBLOCKANNOTATION = 41;

	/**
	 * The operation id for the '<em>In Parallel Block Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___IN_PARALLEL_BLOCK_ANNOTATION__PARALLELBLOCKANNOTATION = 42;

	/**
	 * The operation id for the '<em>Out Parallel Block Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___OUT_PARALLEL_BLOCK_ANNOTATION__PARALLELBLOCKANNOTATION = 43;

	/**
	 * The operation id for the '<em>Visit Polyhedral Domain Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___VISIT_POLYHEDRAL_DOMAIN_ANNOTATION__POLYHEDRALDOMAINANNOTATION = 44;

	/**
	 * The operation id for the '<em>In Polyhedral Domain Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___IN_POLYHEDRAL_DOMAIN_ANNOTATION__POLYHEDRALDOMAINANNOTATION = 45;

	/**
	 * The operation id for the '<em>Out Polyhedral Domain Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___OUT_POLYHEDRAL_DOMAIN_ANNOTATION__POLYHEDRALDOMAINANNOTATION = 46;

	/**
	 * The operation id for the '<em>Visit Barrier Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___VISIT_BARRIER_ANNOTATION__BARRIERANNOTATION = 47;

	/**
	 * The operation id for the '<em>In Barrier Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___IN_BARRIER_ANNOTATION__BARRIERANNOTATION = 48;

	/**
	 * The operation id for the '<em>Out Barrier Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR___OUT_BARRIER_ANNOTATION__BARRIERANNOTATION = 49;

	/**
	 * The number of operations of the '<em>Visitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_VISITOR_OPERATION_COUNT = 50;

	/**
	 * The meta object id for the '{@link org.polymodel.scop.impl.ScopDepthFirstVisitorImpl <em>Depth First Visitor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.scop.impl.ScopDepthFirstVisitorImpl
	 * @see org.polymodel.scop.impl.ScopPackageImpl#getScopDepthFirstVisitor()
	 * @generated
	 */
	int SCOP_DEPTH_FIRST_VISITOR = 11;

	/**
	 * The number of structural features of the '<em>Depth First Visitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR_FEATURE_COUNT = SCOP_VISITOR_FEATURE_COUNT + 0;


	/**
	 * The operation id for the '<em>Default In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___DEFAULT_IN__SCOPVISITABLE = SCOP_VISITOR_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Default Out</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___DEFAULT_OUT__SCOPVISITABLE = SCOP_VISITOR_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Visit Abstract Scop Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___VISIT_ABSTRACT_SCOP_NODE__ABSTRACTSCOPNODE = SCOP_VISITOR_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>In Abstract Scop Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___IN_ABSTRACT_SCOP_NODE__ABSTRACTSCOPNODE = SCOP_VISITOR_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Out Abstract Scop Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___OUT_ABSTRACT_SCOP_NODE__ABSTRACTSCOPNODE = SCOP_VISITOR_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Visit IScop Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___VISIT_ISCOP_ANNOTATION__ISCOPANNOTATION = SCOP_VISITOR_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>In IScop Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___IN_ISCOP_ANNOTATION__ISCOPANNOTATION = SCOP_VISITOR_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Out IScop Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___OUT_ISCOP_ANNOTATION__ISCOPANNOTATION = SCOP_VISITOR_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Visit Scop Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_ROOT__SCOPROOT = SCOP_VISITOR_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>In Scop Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_ROOT__SCOPROOT = SCOP_VISITOR_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Out Scop Root</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_ROOT__SCOPROOT = SCOP_VISITOR_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>Visit Scop For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_FOR__SCOPFOR = SCOP_VISITOR_OPERATION_COUNT + 11;

	/**
	 * The operation id for the '<em>In Scop For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_FOR__SCOPFOR = SCOP_VISITOR_OPERATION_COUNT + 12;

	/**
	 * The operation id for the '<em>Out Scop For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_FOR__SCOPFOR = SCOP_VISITOR_OPERATION_COUNT + 13;

	/**
	 * The operation id for the '<em>Visit Scop Block</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_BLOCK__SCOPBLOCK = SCOP_VISITOR_OPERATION_COUNT + 14;

	/**
	 * The operation id for the '<em>In Scop Block</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_BLOCK__SCOPBLOCK = SCOP_VISITOR_OPERATION_COUNT + 15;

	/**
	 * The operation id for the '<em>Out Scop Block</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_BLOCK__SCOPBLOCK = SCOP_VISITOR_OPERATION_COUNT + 16;

	/**
	 * The operation id for the '<em>Visit Scop Guard</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_GUARD__SCOPGUARD = SCOP_VISITOR_OPERATION_COUNT + 17;

	/**
	 * The operation id for the '<em>In Scop Guard</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_GUARD__SCOPGUARD = SCOP_VISITOR_OPERATION_COUNT + 18;

	/**
	 * The operation id for the '<em>Out Scop Guard</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_GUARD__SCOPGUARD = SCOP_VISITOR_OPERATION_COUNT + 19;

	/**
	 * The operation id for the '<em>Visit Scop Statement Macro</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_STATEMENT_MACRO__SCOPSTATEMENTMACRO = SCOP_VISITOR_OPERATION_COUNT + 20;

	/**
	 * The operation id for the '<em>In Scop Statement Macro</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_STATEMENT_MACRO__SCOPSTATEMENTMACRO = SCOP_VISITOR_OPERATION_COUNT + 21;

	/**
	 * The operation id for the '<em>Out Scop Statement Macro</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_STATEMENT_MACRO__SCOPSTATEMENTMACRO = SCOP_VISITOR_OPERATION_COUNT + 22;

	/**
	 * The operation id for the '<em>Visit Scop Unscanned Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_UNSCANNED_DOMAIN__SCOPUNSCANNEDDOMAIN_1 = SCOP_VISITOR_OPERATION_COUNT + 23;

	/**
	 * The operation id for the '<em>In Scop Unscanned Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_UNSCANNED_DOMAIN__SCOPUNSCANNEDDOMAIN_1 = SCOP_VISITOR_OPERATION_COUNT + 24;

	/**
	 * The operation id for the '<em>Out Scop Unscanned Domain</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_UNSCANNED_DOMAIN__SCOPUNSCANNEDDOMAIN_1 = SCOP_VISITOR_OPERATION_COUNT + 25;

	/**
	 * The operation id for the '<em>Visit Scop Assignment</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_ASSIGNMENT__SCOPASSIGNMENT = SCOP_VISITOR_OPERATION_COUNT + 26;

	/**
	 * The operation id for the '<em>In Scop Assignment</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_ASSIGNMENT__SCOPASSIGNMENT = SCOP_VISITOR_OPERATION_COUNT + 27;

	/**
	 * The operation id for the '<em>Out Scop Assignment</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_ASSIGNMENT__SCOPASSIGNMENT = SCOP_VISITOR_OPERATION_COUNT + 28;

	/**
	 * The operation id for the '<em>Visit Abstract Scop Statement</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___VISIT_ABSTRACT_SCOP_STATEMENT__ABSTRACTSCOPSTATEMENT = SCOP_VISITOR_OPERATION_COUNT + 29;

	/**
	 * The operation id for the '<em>In Abstract Scop Statement</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___IN_ABSTRACT_SCOP_STATEMENT__ABSTRACTSCOPSTATEMENT = SCOP_VISITOR_OPERATION_COUNT + 30;

	/**
	 * The operation id for the '<em>Out Abstract Scop Statement</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___OUT_ABSTRACT_SCOP_STATEMENT__ABSTRACTSCOPSTATEMENT = SCOP_VISITOR_OPERATION_COUNT + 31;

	/**
	 * The operation id for the '<em>Visit Parallel Loop Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___VISIT_PARALLEL_LOOP_ANNOTATION__PARALLELLOOPANNOTATION = SCOP_VISITOR_OPERATION_COUNT + 32;

	/**
	 * The operation id for the '<em>In Parallel Loop Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___IN_PARALLEL_LOOP_ANNOTATION__PARALLELLOOPANNOTATION = SCOP_VISITOR_OPERATION_COUNT + 33;

	/**
	 * The operation id for the '<em>Out Parallel Loop Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___OUT_PARALLEL_LOOP_ANNOTATION__PARALLELLOOPANNOTATION = SCOP_VISITOR_OPERATION_COUNT + 34;

	/**
	 * The operation id for the '<em>Visit Description Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___VISIT_DESCRIPTION_ANNOTATION__DESCRIPTIONANNOTATION = SCOP_VISITOR_OPERATION_COUNT + 35;

	/**
	 * The operation id for the '<em>In Description Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___IN_DESCRIPTION_ANNOTATION__DESCRIPTIONANNOTATION = SCOP_VISITOR_OPERATION_COUNT + 36;

	/**
	 * The operation id for the '<em>Out Description Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___OUT_DESCRIPTION_ANNOTATION__DESCRIPTIONANNOTATION = SCOP_VISITOR_OPERATION_COUNT + 37;

	/**
	 * The operation id for the '<em>Visit Tile Loop Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___VISIT_TILE_LOOP_ANNOTATION__TILELOOPANNOTATION = SCOP_VISITOR_OPERATION_COUNT + 38;

	/**
	 * The operation id for the '<em>In Tile Loop Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___IN_TILE_LOOP_ANNOTATION__TILELOOPANNOTATION = SCOP_VISITOR_OPERATION_COUNT + 39;

	/**
	 * The operation id for the '<em>Out Tile Loop Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___OUT_TILE_LOOP_ANNOTATION__TILELOOPANNOTATION = SCOP_VISITOR_OPERATION_COUNT + 40;

	/**
	 * The operation id for the '<em>Visit Parallel Block Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___VISIT_PARALLEL_BLOCK_ANNOTATION__PARALLELBLOCKANNOTATION = SCOP_VISITOR_OPERATION_COUNT + 41;

	/**
	 * The operation id for the '<em>In Parallel Block Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___IN_PARALLEL_BLOCK_ANNOTATION__PARALLELBLOCKANNOTATION = SCOP_VISITOR_OPERATION_COUNT + 42;

	/**
	 * The operation id for the '<em>Out Parallel Block Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___OUT_PARALLEL_BLOCK_ANNOTATION__PARALLELBLOCKANNOTATION = SCOP_VISITOR_OPERATION_COUNT + 43;

	/**
	 * The operation id for the '<em>Visit Polyhedral Domain Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___VISIT_POLYHEDRAL_DOMAIN_ANNOTATION__POLYHEDRALDOMAINANNOTATION = SCOP_VISITOR_OPERATION_COUNT + 44;

	/**
	 * The operation id for the '<em>In Polyhedral Domain Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___IN_POLYHEDRAL_DOMAIN_ANNOTATION__POLYHEDRALDOMAINANNOTATION = SCOP_VISITOR_OPERATION_COUNT + 45;

	/**
	 * The operation id for the '<em>Out Polyhedral Domain Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___OUT_POLYHEDRAL_DOMAIN_ANNOTATION__POLYHEDRALDOMAINANNOTATION = SCOP_VISITOR_OPERATION_COUNT + 46;

	/**
	 * The operation id for the '<em>Visit Barrier Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___VISIT_BARRIER_ANNOTATION__BARRIERANNOTATION = SCOP_VISITOR_OPERATION_COUNT + 47;

	/**
	 * The operation id for the '<em>In Barrier Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___IN_BARRIER_ANNOTATION__BARRIERANNOTATION = SCOP_VISITOR_OPERATION_COUNT + 48;

	/**
	 * The operation id for the '<em>Out Barrier Annotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR___OUT_BARRIER_ANNOTATION__BARRIERANNOTATION = SCOP_VISITOR_OPERATION_COUNT + 49;

	/**
	 * The number of operations of the '<em>Depth First Visitor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_DEPTH_FIRST_VISITOR_OPERATION_COUNT = SCOP_VISITOR_OPERATION_COUNT + 50;


	/**
	 * The meta object id for the '{@link org.polymodel.scop.impl.ScopUnscannedDomainImpl <em>Unscanned Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polymodel.scop.impl.ScopUnscannedDomainImpl
	 * @see org.polymodel.scop.impl.ScopPackageImpl#getScopUnscannedDomain()
	 * @generated
	 */
	int SCOP_UNSCANNED_DOMAIN = 12;

	/**
	 * The feature id for the '<em><b>Scop Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_UNSCANNED_DOMAIN__SCOP_ANNOTATIONS = ABSTRACT_SCOP_STATEMENT__SCOP_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Macro Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_UNSCANNED_DOMAIN__MACRO_PARAMS = ABSTRACT_SCOP_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_UNSCANNED_DOMAIN__NAME = ABSTRACT_SCOP_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Schedule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_UNSCANNED_DOMAIN__SCHEDULE = ABSTRACT_SCOP_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Unscanned Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_UNSCANNED_DOMAIN_FEATURE_COUNT = ABSTRACT_SCOP_STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get Surrounding Iterators</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_UNSCANNED_DOMAIN___GET_SURROUNDING_ITERATORS = ABSTRACT_SCOP_STATEMENT___GET_SURROUNDING_ITERATORS;

	/**
	 * The operation id for the '<em>Get Surrounding Scop Fors</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_UNSCANNED_DOMAIN___GET_SURROUNDING_SCOP_FORS = ABSTRACT_SCOP_STATEMENT___GET_SURROUNDING_SCOP_FORS;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_UNSCANNED_DOMAIN___SIMPLIFY = ABSTRACT_SCOP_STATEMENT___SIMPLIFY;

	/**
	 * The operation id for the '<em>Get Loop Depth</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_UNSCANNED_DOMAIN___GET_LOOP_DEPTH = ABSTRACT_SCOP_STATEMENT___GET_LOOP_DEPTH;

	/**
	 * The operation id for the '<em>Get Surrounding Scop For</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_UNSCANNED_DOMAIN___GET_SURROUNDING_SCOP_FOR = ABSTRACT_SCOP_STATEMENT___GET_SURROUNDING_SCOP_FOR;

	/**
	 * The operation id for the '<em>Get Derived Constraints</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_UNSCANNED_DOMAIN___GET_DERIVED_CONSTRAINTS = ABSTRACT_SCOP_STATEMENT___GET_DERIVED_CONSTRAINTS;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_UNSCANNED_DOMAIN___ACCEPT__SCOPVISITOR = ABSTRACT_SCOP_STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Unscanned Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCOP_UNSCANNED_DOMAIN_OPERATION_COUNT = ABSTRACT_SCOP_STATEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '<em>JNIISL Union Map</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionMap
	 * @see org.polymodel.scop.impl.ScopPackageImpl#getJNIISLUnionMap()
	 * @generated
	 */
	int JNIISL_UNION_MAP = 13;


	/**
	 * Returns the meta object for class '{@link org.polymodel.scop.AbstractScopNode <em>Abstract Scop Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Scop Node</em>'.
	 * @see org.polymodel.scop.AbstractScopNode
	 * @generated
	 */
	EClass getAbstractScopNode();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.scop.AbstractScopNode#getScopAnnotations <em>Scop Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scop Annotations</em>'.
	 * @see org.polymodel.scop.AbstractScopNode#getScopAnnotations()
	 * @see #getAbstractScopNode()
	 * @generated
	 */
	EReference getAbstractScopNode_ScopAnnotations();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.AbstractScopNode#getSurroundingIterators() <em>Get Surrounding Iterators</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Surrounding Iterators</em>' operation.
	 * @see org.polymodel.scop.AbstractScopNode#getSurroundingIterators()
	 * @generated
	 */
	EOperation getAbstractScopNode__GetSurroundingIterators();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.AbstractScopNode#getSurroundingScopFors() <em>Get Surrounding Scop Fors</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Surrounding Scop Fors</em>' operation.
	 * @see org.polymodel.scop.AbstractScopNode#getSurroundingScopFors()
	 * @generated
	 */
	EOperation getAbstractScopNode__GetSurroundingScopFors();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.AbstractScopNode#simplify() <em>Simplify</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Simplify</em>' operation.
	 * @see org.polymodel.scop.AbstractScopNode#simplify()
	 * @generated
	 */
	EOperation getAbstractScopNode__Simplify();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.AbstractScopNode#getLoopDepth() <em>Get Loop Depth</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Loop Depth</em>' operation.
	 * @see org.polymodel.scop.AbstractScopNode#getLoopDepth()
	 * @generated
	 */
	EOperation getAbstractScopNode__GetLoopDepth();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.AbstractScopNode#accept(org.polymodel.scop.ScopVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.scop.AbstractScopNode#accept(org.polymodel.scop.ScopVisitor)
	 * @generated
	 */
	EOperation getAbstractScopNode__Accept__ScopVisitor();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.AbstractScopNode#getSurroundingScopFor() <em>Get Surrounding Scop For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Surrounding Scop For</em>' operation.
	 * @see org.polymodel.scop.AbstractScopNode#getSurroundingScopFor()
	 * @generated
	 */
	EOperation getAbstractScopNode__GetSurroundingScopFor();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.AbstractScopNode#getDerivedConstraints() <em>Get Derived Constraints</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Derived Constraints</em>' operation.
	 * @see org.polymodel.scop.AbstractScopNode#getDerivedConstraints()
	 * @generated
	 */
	EOperation getAbstractScopNode__GetDerivedConstraints();

	/**
	 * Returns the meta object for class '{@link org.polymodel.scop.IScopAnnotation <em>IScop Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IScop Annotation</em>'.
	 * @see org.polymodel.scop.IScopAnnotation
	 * @generated
	 */
	EClass getIScopAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.IScopAnnotation#accept(org.polymodel.scop.ScopVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.scop.IScopAnnotation#accept(org.polymodel.scop.ScopVisitor)
	 * @generated
	 */
	EOperation getIScopAnnotation__Accept__ScopVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.scop.ScopRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see org.polymodel.scop.ScopRoot
	 * @generated
	 */
	EClass getScopRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.scop.ScopRoot#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see org.polymodel.scop.ScopRoot#getStatements()
	 * @see #getScopRoot()
	 * @generated
	 */
	EReference getScopRoot_Statements();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopRoot#simplify() <em>Simplify</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Simplify</em>' operation.
	 * @see org.polymodel.scop.ScopRoot#simplify()
	 * @generated
	 */
	EOperation getScopRoot__Simplify();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopRoot#accept(org.polymodel.scop.ScopVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.scop.ScopRoot#accept(org.polymodel.scop.ScopVisitor)
	 * @generated
	 */
	EOperation getScopRoot__Accept__ScopVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.scop.ScopFor <em>For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For</em>'.
	 * @see org.polymodel.scop.ScopFor
	 * @generated
	 */
	EClass getScopFor();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.scop.ScopFor#getIterator <em>Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Iterator</em>'.
	 * @see org.polymodel.scop.ScopFor#getIterator()
	 * @see #getScopFor()
	 * @generated
	 */
	EReference getScopFor_Iterator();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.scop.ScopFor#getLB <em>LB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>LB</em>'.
	 * @see org.polymodel.scop.ScopFor#getLB()
	 * @see #getScopFor()
	 * @generated
	 */
	EReference getScopFor_LB();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.scop.ScopFor#getUB <em>UB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>UB</em>'.
	 * @see org.polymodel.scop.ScopFor#getUB()
	 * @see #getScopFor()
	 * @generated
	 */
	EReference getScopFor_UB();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.scop.ScopFor#getStride <em>Stride</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Stride</em>'.
	 * @see org.polymodel.scop.ScopFor#getStride()
	 * @see #getScopFor()
	 * @generated
	 */
	EReference getScopFor_Stride();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.scop.ScopFor#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.polymodel.scop.ScopFor#getBody()
	 * @see #getScopFor()
	 * @generated
	 */
	EReference getScopFor_Body();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopFor#accept(org.polymodel.scop.ScopVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.scop.ScopFor#accept(org.polymodel.scop.ScopVisitor)
	 * @generated
	 */
	EOperation getScopFor__Accept__ScopVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.scop.ScopBlock <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block</em>'.
	 * @see org.polymodel.scop.ScopBlock
	 * @generated
	 */
	EClass getScopBlock();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.scop.ScopBlock#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see org.polymodel.scop.ScopBlock#getStatements()
	 * @see #getScopBlock()
	 * @generated
	 */
	EReference getScopBlock_Statements();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopBlock#accept(org.polymodel.scop.ScopVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.scop.ScopBlock#accept(org.polymodel.scop.ScopVisitor)
	 * @generated
	 */
	EOperation getScopBlock__Accept__ScopVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.scop.ScopGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard</em>'.
	 * @see org.polymodel.scop.ScopGuard
	 * @generated
	 */
	EClass getScopGuard();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.scop.ScopGuard#getConstraintSystems <em>Constraint Systems</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraint Systems</em>'.
	 * @see org.polymodel.scop.ScopGuard#getConstraintSystems()
	 * @see #getScopGuard()
	 * @generated
	 */
	EReference getScopGuard_ConstraintSystems();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.scop.ScopGuard#getThenBody <em>Then Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then Body</em>'.
	 * @see org.polymodel.scop.ScopGuard#getThenBody()
	 * @see #getScopGuard()
	 * @generated
	 */
	EReference getScopGuard_ThenBody();

	/**
	 * Returns the meta object for the containment reference '{@link org.polymodel.scop.ScopGuard#getElseBody <em>Else Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else Body</em>'.
	 * @see org.polymodel.scop.ScopGuard#getElseBody()
	 * @see #getScopGuard()
	 * @generated
	 */
	EReference getScopGuard_ElseBody();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopGuard#accept(org.polymodel.scop.ScopVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.scop.ScopGuard#accept(org.polymodel.scop.ScopVisitor)
	 * @generated
	 */
	EOperation getScopGuard__Accept__ScopVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.scop.ScopStatementMacro <em>Statement Macro</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement Macro</em>'.
	 * @see org.polymodel.scop.ScopStatementMacro
	 * @generated
	 */
	EClass getScopStatementMacro();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.scop.ScopStatementMacro#getMacroParams <em>Macro Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Macro Params</em>'.
	 * @see org.polymodel.scop.ScopStatementMacro#getMacroParams()
	 * @see #getScopStatementMacro()
	 * @generated
	 */
	EReference getScopStatementMacro_MacroParams();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.scop.ScopStatementMacro#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polymodel.scop.ScopStatementMacro#getName()
	 * @see #getScopStatementMacro()
	 * @generated
	 */
	EAttribute getScopStatementMacro_Name();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopStatementMacro#accept(org.polymodel.scop.ScopVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.scop.ScopStatementMacro#accept(org.polymodel.scop.ScopVisitor)
	 * @generated
	 */
	EOperation getScopStatementMacro__Accept__ScopVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.scop.ScopAssignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment</em>'.
	 * @see org.polymodel.scop.ScopAssignment
	 * @generated
	 */
	EClass getScopAssignment();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.scop.ScopAssignment#getLHS <em>LHS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>LHS</em>'.
	 * @see org.polymodel.scop.ScopAssignment#getLHS()
	 * @see #getScopAssignment()
	 * @generated
	 */
	EReference getScopAssignment_LHS();

	/**
	 * Returns the meta object for the reference '{@link org.polymodel.scop.ScopAssignment#getRHS <em>RHS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>RHS</em>'.
	 * @see org.polymodel.scop.ScopAssignment#getRHS()
	 * @see #getScopAssignment()
	 * @generated
	 */
	EReference getScopAssignment_RHS();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopAssignment#accept(org.polymodel.scop.ScopVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.scop.ScopAssignment#accept(org.polymodel.scop.ScopVisitor)
	 * @generated
	 */
	EOperation getScopAssignment__Accept__ScopVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.scop.AbstractScopStatement <em>Abstract Scop Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Scop Statement</em>'.
	 * @see org.polymodel.scop.AbstractScopStatement
	 * @generated
	 */
	EClass getAbstractScopStatement();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.AbstractScopStatement#accept(org.polymodel.scop.ScopVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.scop.AbstractScopStatement#accept(org.polymodel.scop.ScopVisitor)
	 * @generated
	 */
	EOperation getAbstractScopStatement__Accept__ScopVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.scop.ScopVisitor <em>Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitor</em>'.
	 * @see org.polymodel.scop.ScopVisitor
	 * @generated
	 */
	EClass getScopVisitor();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#defaultIn(org.polymodel.scop.ScopVisitable) <em>Default In</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Default In</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#defaultIn(org.polymodel.scop.ScopVisitable)
	 * @generated
	 */
	EOperation getScopVisitor__DefaultIn__ScopVisitable();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#defaultOut(org.polymodel.scop.ScopVisitable) <em>Default Out</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Default Out</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#defaultOut(org.polymodel.scop.ScopVisitable)
	 * @generated
	 */
	EOperation getScopVisitor__DefaultOut__ScopVisitable();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#visitAbstractScopNode(org.polymodel.scop.AbstractScopNode) <em>Visit Abstract Scop Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Abstract Scop Node</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#visitAbstractScopNode(org.polymodel.scop.AbstractScopNode)
	 * @generated
	 */
	EOperation getScopVisitor__VisitAbstractScopNode__AbstractScopNode();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#inAbstractScopNode(org.polymodel.scop.AbstractScopNode) <em>In Abstract Scop Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Abstract Scop Node</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#inAbstractScopNode(org.polymodel.scop.AbstractScopNode)
	 * @generated
	 */
	EOperation getScopVisitor__InAbstractScopNode__AbstractScopNode();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#outAbstractScopNode(org.polymodel.scop.AbstractScopNode) <em>Out Abstract Scop Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Abstract Scop Node</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#outAbstractScopNode(org.polymodel.scop.AbstractScopNode)
	 * @generated
	 */
	EOperation getScopVisitor__OutAbstractScopNode__AbstractScopNode();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#visitIScopAnnotation(org.polymodel.scop.IScopAnnotation) <em>Visit IScop Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit IScop Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#visitIScopAnnotation(org.polymodel.scop.IScopAnnotation)
	 * @generated
	 */
	EOperation getScopVisitor__VisitIScopAnnotation__IScopAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#inIScopAnnotation(org.polymodel.scop.IScopAnnotation) <em>In IScop Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In IScop Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#inIScopAnnotation(org.polymodel.scop.IScopAnnotation)
	 * @generated
	 */
	EOperation getScopVisitor__InIScopAnnotation__IScopAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#outIScopAnnotation(org.polymodel.scop.IScopAnnotation) <em>Out IScop Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out IScop Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#outIScopAnnotation(org.polymodel.scop.IScopAnnotation)
	 * @generated
	 */
	EOperation getScopVisitor__OutIScopAnnotation__IScopAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#visitScopRoot(org.polymodel.scop.ScopRoot) <em>Visit Scop Root</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Scop Root</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#visitScopRoot(org.polymodel.scop.ScopRoot)
	 * @generated
	 */
	EOperation getScopVisitor__VisitScopRoot__ScopRoot();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#inScopRoot(org.polymodel.scop.ScopRoot) <em>In Scop Root</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Scop Root</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#inScopRoot(org.polymodel.scop.ScopRoot)
	 * @generated
	 */
	EOperation getScopVisitor__InScopRoot__ScopRoot();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#outScopRoot(org.polymodel.scop.ScopRoot) <em>Out Scop Root</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Scop Root</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#outScopRoot(org.polymodel.scop.ScopRoot)
	 * @generated
	 */
	EOperation getScopVisitor__OutScopRoot__ScopRoot();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#visitScopFor(org.polymodel.scop.ScopFor) <em>Visit Scop For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Scop For</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#visitScopFor(org.polymodel.scop.ScopFor)
	 * @generated
	 */
	EOperation getScopVisitor__VisitScopFor__ScopFor();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#inScopFor(org.polymodel.scop.ScopFor) <em>In Scop For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Scop For</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#inScopFor(org.polymodel.scop.ScopFor)
	 * @generated
	 */
	EOperation getScopVisitor__InScopFor__ScopFor();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#outScopFor(org.polymodel.scop.ScopFor) <em>Out Scop For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Scop For</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#outScopFor(org.polymodel.scop.ScopFor)
	 * @generated
	 */
	EOperation getScopVisitor__OutScopFor__ScopFor();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#visitScopBlock(org.polymodel.scop.ScopBlock) <em>Visit Scop Block</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Scop Block</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#visitScopBlock(org.polymodel.scop.ScopBlock)
	 * @generated
	 */
	EOperation getScopVisitor__VisitScopBlock__ScopBlock();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#inScopBlock(org.polymodel.scop.ScopBlock) <em>In Scop Block</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Scop Block</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#inScopBlock(org.polymodel.scop.ScopBlock)
	 * @generated
	 */
	EOperation getScopVisitor__InScopBlock__ScopBlock();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#outScopBlock(org.polymodel.scop.ScopBlock) <em>Out Scop Block</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Scop Block</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#outScopBlock(org.polymodel.scop.ScopBlock)
	 * @generated
	 */
	EOperation getScopVisitor__OutScopBlock__ScopBlock();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#visitScopGuard(org.polymodel.scop.ScopGuard) <em>Visit Scop Guard</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Scop Guard</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#visitScopGuard(org.polymodel.scop.ScopGuard)
	 * @generated
	 */
	EOperation getScopVisitor__VisitScopGuard__ScopGuard();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#inScopGuard(org.polymodel.scop.ScopGuard) <em>In Scop Guard</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Scop Guard</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#inScopGuard(org.polymodel.scop.ScopGuard)
	 * @generated
	 */
	EOperation getScopVisitor__InScopGuard__ScopGuard();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#outScopGuard(org.polymodel.scop.ScopGuard) <em>Out Scop Guard</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Scop Guard</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#outScopGuard(org.polymodel.scop.ScopGuard)
	 * @generated
	 */
	EOperation getScopVisitor__OutScopGuard__ScopGuard();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#visitScopStatementMacro(org.polymodel.scop.ScopStatementMacro) <em>Visit Scop Statement Macro</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Scop Statement Macro</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#visitScopStatementMacro(org.polymodel.scop.ScopStatementMacro)
	 * @generated
	 */
	EOperation getScopVisitor__VisitScopStatementMacro__ScopStatementMacro();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#inScopStatementMacro(org.polymodel.scop.ScopStatementMacro) <em>In Scop Statement Macro</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Scop Statement Macro</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#inScopStatementMacro(org.polymodel.scop.ScopStatementMacro)
	 * @generated
	 */
	EOperation getScopVisitor__InScopStatementMacro__ScopStatementMacro();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#outScopStatementMacro(org.polymodel.scop.ScopStatementMacro) <em>Out Scop Statement Macro</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Scop Statement Macro</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#outScopStatementMacro(org.polymodel.scop.ScopStatementMacro)
	 * @generated
	 */
	EOperation getScopVisitor__OutScopStatementMacro__ScopStatementMacro();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#visitScopAssignment(org.polymodel.scop.ScopAssignment) <em>Visit Scop Assignment</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Scop Assignment</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#visitScopAssignment(org.polymodel.scop.ScopAssignment)
	 * @generated
	 */
	EOperation getScopVisitor__VisitScopAssignment__ScopAssignment();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#inScopAssignment(org.polymodel.scop.ScopAssignment) <em>In Scop Assignment</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Scop Assignment</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#inScopAssignment(org.polymodel.scop.ScopAssignment)
	 * @generated
	 */
	EOperation getScopVisitor__InScopAssignment__ScopAssignment();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#outScopAssignment(org.polymodel.scop.ScopAssignment) <em>Out Scop Assignment</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Scop Assignment</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#outScopAssignment(org.polymodel.scop.ScopAssignment)
	 * @generated
	 */
	EOperation getScopVisitor__OutScopAssignment__ScopAssignment();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#visitAbstractScopStatement(org.polymodel.scop.AbstractScopStatement) <em>Visit Abstract Scop Statement</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Abstract Scop Statement</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#visitAbstractScopStatement(org.polymodel.scop.AbstractScopStatement)
	 * @generated
	 */
	EOperation getScopVisitor__VisitAbstractScopStatement__AbstractScopStatement();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#inAbstractScopStatement(org.polymodel.scop.AbstractScopStatement) <em>In Abstract Scop Statement</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Abstract Scop Statement</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#inAbstractScopStatement(org.polymodel.scop.AbstractScopStatement)
	 * @generated
	 */
	EOperation getScopVisitor__InAbstractScopStatement__AbstractScopStatement();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#outAbstractScopStatement(org.polymodel.scop.AbstractScopStatement) <em>Out Abstract Scop Statement</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Abstract Scop Statement</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#outAbstractScopStatement(org.polymodel.scop.AbstractScopStatement)
	 * @generated
	 */
	EOperation getScopVisitor__OutAbstractScopStatement__AbstractScopStatement();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#visitParallelLoopAnnotation(org.polymodel.scop.annotation.ParallelLoopAnnotation) <em>Visit Parallel Loop Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Parallel Loop Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#visitParallelLoopAnnotation(org.polymodel.scop.annotation.ParallelLoopAnnotation)
	 * @generated
	 */
	EOperation getScopVisitor__VisitParallelLoopAnnotation__ParallelLoopAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#inParallelLoopAnnotation(org.polymodel.scop.annotation.ParallelLoopAnnotation) <em>In Parallel Loop Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Parallel Loop Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#inParallelLoopAnnotation(org.polymodel.scop.annotation.ParallelLoopAnnotation)
	 * @generated
	 */
	EOperation getScopVisitor__InParallelLoopAnnotation__ParallelLoopAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#outParallelLoopAnnotation(org.polymodel.scop.annotation.ParallelLoopAnnotation) <em>Out Parallel Loop Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Parallel Loop Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#outParallelLoopAnnotation(org.polymodel.scop.annotation.ParallelLoopAnnotation)
	 * @generated
	 */
	EOperation getScopVisitor__OutParallelLoopAnnotation__ParallelLoopAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#visitDescriptionAnnotation(org.polymodel.scop.annotation.DescriptionAnnotation) <em>Visit Description Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Description Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#visitDescriptionAnnotation(org.polymodel.scop.annotation.DescriptionAnnotation)
	 * @generated
	 */
	EOperation getScopVisitor__VisitDescriptionAnnotation__DescriptionAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#inDescriptionAnnotation(org.polymodel.scop.annotation.DescriptionAnnotation) <em>In Description Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Description Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#inDescriptionAnnotation(org.polymodel.scop.annotation.DescriptionAnnotation)
	 * @generated
	 */
	EOperation getScopVisitor__InDescriptionAnnotation__DescriptionAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#outDescriptionAnnotation(org.polymodel.scop.annotation.DescriptionAnnotation) <em>Out Description Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Description Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#outDescriptionAnnotation(org.polymodel.scop.annotation.DescriptionAnnotation)
	 * @generated
	 */
	EOperation getScopVisitor__OutDescriptionAnnotation__DescriptionAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#visitTileLoopAnnotation(org.polymodel.scop.annotation.TileLoopAnnotation) <em>Visit Tile Loop Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Tile Loop Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#visitTileLoopAnnotation(org.polymodel.scop.annotation.TileLoopAnnotation)
	 * @generated
	 */
	EOperation getScopVisitor__VisitTileLoopAnnotation__TileLoopAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#inTileLoopAnnotation(org.polymodel.scop.annotation.TileLoopAnnotation) <em>In Tile Loop Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Tile Loop Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#inTileLoopAnnotation(org.polymodel.scop.annotation.TileLoopAnnotation)
	 * @generated
	 */
	EOperation getScopVisitor__InTileLoopAnnotation__TileLoopAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#outTileLoopAnnotation(org.polymodel.scop.annotation.TileLoopAnnotation) <em>Out Tile Loop Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Tile Loop Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#outTileLoopAnnotation(org.polymodel.scop.annotation.TileLoopAnnotation)
	 * @generated
	 */
	EOperation getScopVisitor__OutTileLoopAnnotation__TileLoopAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#visitParallelBlockAnnotation(org.polymodel.scop.annotation.ParallelBlockAnnotation) <em>Visit Parallel Block Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Parallel Block Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#visitParallelBlockAnnotation(org.polymodel.scop.annotation.ParallelBlockAnnotation)
	 * @generated
	 */
	EOperation getScopVisitor__VisitParallelBlockAnnotation__ParallelBlockAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#inParallelBlockAnnotation(org.polymodel.scop.annotation.ParallelBlockAnnotation) <em>In Parallel Block Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Parallel Block Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#inParallelBlockAnnotation(org.polymodel.scop.annotation.ParallelBlockAnnotation)
	 * @generated
	 */
	EOperation getScopVisitor__InParallelBlockAnnotation__ParallelBlockAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#outParallelBlockAnnotation(org.polymodel.scop.annotation.ParallelBlockAnnotation) <em>Out Parallel Block Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Parallel Block Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#outParallelBlockAnnotation(org.polymodel.scop.annotation.ParallelBlockAnnotation)
	 * @generated
	 */
	EOperation getScopVisitor__OutParallelBlockAnnotation__ParallelBlockAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#visitPolyhedralDomainAnnotation(org.polymodel.scop.annotation.PolyhedralDomainAnnotation) <em>Visit Polyhedral Domain Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Polyhedral Domain Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#visitPolyhedralDomainAnnotation(org.polymodel.scop.annotation.PolyhedralDomainAnnotation)
	 * @generated
	 */
	EOperation getScopVisitor__VisitPolyhedralDomainAnnotation__PolyhedralDomainAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#inPolyhedralDomainAnnotation(org.polymodel.scop.annotation.PolyhedralDomainAnnotation) <em>In Polyhedral Domain Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Polyhedral Domain Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#inPolyhedralDomainAnnotation(org.polymodel.scop.annotation.PolyhedralDomainAnnotation)
	 * @generated
	 */
	EOperation getScopVisitor__InPolyhedralDomainAnnotation__PolyhedralDomainAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#outPolyhedralDomainAnnotation(org.polymodel.scop.annotation.PolyhedralDomainAnnotation) <em>Out Polyhedral Domain Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Polyhedral Domain Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#outPolyhedralDomainAnnotation(org.polymodel.scop.annotation.PolyhedralDomainAnnotation)
	 * @generated
	 */
	EOperation getScopVisitor__OutPolyhedralDomainAnnotation__PolyhedralDomainAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#visitBarrierAnnotation(org.polymodel.scop.annotation.BarrierAnnotation) <em>Visit Barrier Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Barrier Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#visitBarrierAnnotation(org.polymodel.scop.annotation.BarrierAnnotation)
	 * @generated
	 */
	EOperation getScopVisitor__VisitBarrierAnnotation__BarrierAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#inBarrierAnnotation(org.polymodel.scop.annotation.BarrierAnnotation) <em>In Barrier Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Barrier Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#inBarrierAnnotation(org.polymodel.scop.annotation.BarrierAnnotation)
	 * @generated
	 */
	EOperation getScopVisitor__InBarrierAnnotation__BarrierAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#outBarrierAnnotation(org.polymodel.scop.annotation.BarrierAnnotation) <em>Out Barrier Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Barrier Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#outBarrierAnnotation(org.polymodel.scop.annotation.BarrierAnnotation)
	 * @generated
	 */
	EOperation getScopVisitor__OutBarrierAnnotation__BarrierAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#visitScopUnscannedDomain(org.polymodel.scop.ScopUnscannedDomain) <em>Visit Scop Unscanned Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Scop Unscanned Domain</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#visitScopUnscannedDomain(org.polymodel.scop.ScopUnscannedDomain)
	 * @generated
	 */
	EOperation getScopVisitor__VisitScopUnscannedDomain__ScopUnscannedDomain();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#inScopUnscannedDomain(org.polymodel.scop.ScopUnscannedDomain) <em>In Scop Unscanned Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Scop Unscanned Domain</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#inScopUnscannedDomain(org.polymodel.scop.ScopUnscannedDomain)
	 * @generated
	 */
	EOperation getScopVisitor__InScopUnscannedDomain__ScopUnscannedDomain();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitor#outScopUnscannedDomain(org.polymodel.scop.ScopUnscannedDomain) <em>Out Scop Unscanned Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Scop Unscanned Domain</em>' operation.
	 * @see org.polymodel.scop.ScopVisitor#outScopUnscannedDomain(org.polymodel.scop.ScopUnscannedDomain)
	 * @generated
	 */
	EOperation getScopVisitor__OutScopUnscannedDomain__ScopUnscannedDomain();

	/**
	 * Returns the meta object for class '{@link org.polymodel.scop.ScopVisitable <em>Visitable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitable</em>'.
	 * @see org.polymodel.scop.ScopVisitable
	 * @generated
	 */
	EClass getScopVisitable();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopVisitable#accept(org.polymodel.scop.ScopVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.scop.ScopVisitable#accept(org.polymodel.scop.ScopVisitor)
	 * @generated
	 */
	EOperation getScopVisitable__Accept__ScopVisitor();

	/**
	 * Returns the meta object for class '{@link org.polymodel.scop.ScopDepthFirstVisitor <em>Depth First Visitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Depth First Visitor</em>'.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor
	 * @generated
	 */
	EClass getScopDepthFirstVisitor();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#defaultIn(org.polymodel.scop.ScopVisitable) <em>Default In</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Default In</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#defaultIn(org.polymodel.scop.ScopVisitable)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__DefaultIn__ScopVisitable();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#defaultOut(org.polymodel.scop.ScopVisitable) <em>Default Out</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Default Out</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#defaultOut(org.polymodel.scop.ScopVisitable)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__DefaultOut__ScopVisitable();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#visitAbstractScopNode(org.polymodel.scop.AbstractScopNode) <em>Visit Abstract Scop Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Abstract Scop Node</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#visitAbstractScopNode(org.polymodel.scop.AbstractScopNode)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__VisitAbstractScopNode__AbstractScopNode();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#inAbstractScopNode(org.polymodel.scop.AbstractScopNode) <em>In Abstract Scop Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Abstract Scop Node</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#inAbstractScopNode(org.polymodel.scop.AbstractScopNode)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__InAbstractScopNode__AbstractScopNode();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#outAbstractScopNode(org.polymodel.scop.AbstractScopNode) <em>Out Abstract Scop Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Abstract Scop Node</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#outAbstractScopNode(org.polymodel.scop.AbstractScopNode)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__OutAbstractScopNode__AbstractScopNode();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#visitIScopAnnotation(org.polymodel.scop.IScopAnnotation) <em>Visit IScop Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit IScop Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#visitIScopAnnotation(org.polymodel.scop.IScopAnnotation)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__VisitIScopAnnotation__IScopAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#inIScopAnnotation(org.polymodel.scop.IScopAnnotation) <em>In IScop Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In IScop Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#inIScopAnnotation(org.polymodel.scop.IScopAnnotation)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__InIScopAnnotation__IScopAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#outIScopAnnotation(org.polymodel.scop.IScopAnnotation) <em>Out IScop Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out IScop Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#outIScopAnnotation(org.polymodel.scop.IScopAnnotation)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__OutIScopAnnotation__IScopAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#visitScopRoot(org.polymodel.scop.ScopRoot) <em>Visit Scop Root</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Scop Root</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#visitScopRoot(org.polymodel.scop.ScopRoot)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__VisitScopRoot__ScopRoot();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#inScopRoot(org.polymodel.scop.ScopRoot) <em>In Scop Root</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Scop Root</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#inScopRoot(org.polymodel.scop.ScopRoot)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__InScopRoot__ScopRoot();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#outScopRoot(org.polymodel.scop.ScopRoot) <em>Out Scop Root</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Scop Root</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#outScopRoot(org.polymodel.scop.ScopRoot)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__OutScopRoot__ScopRoot();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#visitScopFor(org.polymodel.scop.ScopFor) <em>Visit Scop For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Scop For</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#visitScopFor(org.polymodel.scop.ScopFor)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__VisitScopFor__ScopFor();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#inScopFor(org.polymodel.scop.ScopFor) <em>In Scop For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Scop For</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#inScopFor(org.polymodel.scop.ScopFor)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__InScopFor__ScopFor();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#outScopFor(org.polymodel.scop.ScopFor) <em>Out Scop For</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Scop For</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#outScopFor(org.polymodel.scop.ScopFor)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__OutScopFor__ScopFor();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#visitScopBlock(org.polymodel.scop.ScopBlock) <em>Visit Scop Block</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Scop Block</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#visitScopBlock(org.polymodel.scop.ScopBlock)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__VisitScopBlock__ScopBlock();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#inScopBlock(org.polymodel.scop.ScopBlock) <em>In Scop Block</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Scop Block</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#inScopBlock(org.polymodel.scop.ScopBlock)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__InScopBlock__ScopBlock();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#outScopBlock(org.polymodel.scop.ScopBlock) <em>Out Scop Block</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Scop Block</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#outScopBlock(org.polymodel.scop.ScopBlock)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__OutScopBlock__ScopBlock();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#visitScopGuard(org.polymodel.scop.ScopGuard) <em>Visit Scop Guard</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Scop Guard</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#visitScopGuard(org.polymodel.scop.ScopGuard)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__VisitScopGuard__ScopGuard();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#inScopGuard(org.polymodel.scop.ScopGuard) <em>In Scop Guard</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Scop Guard</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#inScopGuard(org.polymodel.scop.ScopGuard)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__InScopGuard__ScopGuard();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#outScopGuard(org.polymodel.scop.ScopGuard) <em>Out Scop Guard</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Scop Guard</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#outScopGuard(org.polymodel.scop.ScopGuard)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__OutScopGuard__ScopGuard();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#visitScopStatementMacro(org.polymodel.scop.ScopStatementMacro) <em>Visit Scop Statement Macro</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Scop Statement Macro</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#visitScopStatementMacro(org.polymodel.scop.ScopStatementMacro)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__VisitScopStatementMacro__ScopStatementMacro();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#inScopStatementMacro(org.polymodel.scop.ScopStatementMacro) <em>In Scop Statement Macro</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Scop Statement Macro</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#inScopStatementMacro(org.polymodel.scop.ScopStatementMacro)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__InScopStatementMacro__ScopStatementMacro();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#outScopStatementMacro(org.polymodel.scop.ScopStatementMacro) <em>Out Scop Statement Macro</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Scop Statement Macro</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#outScopStatementMacro(org.polymodel.scop.ScopStatementMacro)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__OutScopStatementMacro__ScopStatementMacro();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#visitScopUnscannedDomain(org.polymodel.scop.ScopUnscannedDomain) <em>Visit Scop Unscanned Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Scop Unscanned Domain</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#visitScopUnscannedDomain(org.polymodel.scop.ScopUnscannedDomain)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__VisitScopUnscannedDomain__ScopUnscannedDomain_1();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#inScopUnscannedDomain(org.polymodel.scop.ScopUnscannedDomain) <em>In Scop Unscanned Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Scop Unscanned Domain</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#inScopUnscannedDomain(org.polymodel.scop.ScopUnscannedDomain)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__InScopUnscannedDomain__ScopUnscannedDomain_1();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#outScopUnscannedDomain(org.polymodel.scop.ScopUnscannedDomain) <em>Out Scop Unscanned Domain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Scop Unscanned Domain</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#outScopUnscannedDomain(org.polymodel.scop.ScopUnscannedDomain)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__OutScopUnscannedDomain__ScopUnscannedDomain_1();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#visitScopAssignment(org.polymodel.scop.ScopAssignment) <em>Visit Scop Assignment</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Scop Assignment</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#visitScopAssignment(org.polymodel.scop.ScopAssignment)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__VisitScopAssignment__ScopAssignment();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#inScopAssignment(org.polymodel.scop.ScopAssignment) <em>In Scop Assignment</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Scop Assignment</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#inScopAssignment(org.polymodel.scop.ScopAssignment)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__InScopAssignment__ScopAssignment();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#outScopAssignment(org.polymodel.scop.ScopAssignment) <em>Out Scop Assignment</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Scop Assignment</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#outScopAssignment(org.polymodel.scop.ScopAssignment)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__OutScopAssignment__ScopAssignment();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#visitAbstractScopStatement(org.polymodel.scop.AbstractScopStatement) <em>Visit Abstract Scop Statement</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Abstract Scop Statement</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#visitAbstractScopStatement(org.polymodel.scop.AbstractScopStatement)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__VisitAbstractScopStatement__AbstractScopStatement();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#inAbstractScopStatement(org.polymodel.scop.AbstractScopStatement) <em>In Abstract Scop Statement</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Abstract Scop Statement</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#inAbstractScopStatement(org.polymodel.scop.AbstractScopStatement)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__InAbstractScopStatement__AbstractScopStatement();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#outAbstractScopStatement(org.polymodel.scop.AbstractScopStatement) <em>Out Abstract Scop Statement</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Abstract Scop Statement</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#outAbstractScopStatement(org.polymodel.scop.AbstractScopStatement)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__OutAbstractScopStatement__AbstractScopStatement();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#visitParallelLoopAnnotation(org.polymodel.scop.annotation.ParallelLoopAnnotation) <em>Visit Parallel Loop Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Parallel Loop Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#visitParallelLoopAnnotation(org.polymodel.scop.annotation.ParallelLoopAnnotation)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__VisitParallelLoopAnnotation__ParallelLoopAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#inParallelLoopAnnotation(org.polymodel.scop.annotation.ParallelLoopAnnotation) <em>In Parallel Loop Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Parallel Loop Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#inParallelLoopAnnotation(org.polymodel.scop.annotation.ParallelLoopAnnotation)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__InParallelLoopAnnotation__ParallelLoopAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#outParallelLoopAnnotation(org.polymodel.scop.annotation.ParallelLoopAnnotation) <em>Out Parallel Loop Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Parallel Loop Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#outParallelLoopAnnotation(org.polymodel.scop.annotation.ParallelLoopAnnotation)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__OutParallelLoopAnnotation__ParallelLoopAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#visitDescriptionAnnotation(org.polymodel.scop.annotation.DescriptionAnnotation) <em>Visit Description Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Description Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#visitDescriptionAnnotation(org.polymodel.scop.annotation.DescriptionAnnotation)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__VisitDescriptionAnnotation__DescriptionAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#inDescriptionAnnotation(org.polymodel.scop.annotation.DescriptionAnnotation) <em>In Description Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Description Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#inDescriptionAnnotation(org.polymodel.scop.annotation.DescriptionAnnotation)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__InDescriptionAnnotation__DescriptionAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#outDescriptionAnnotation(org.polymodel.scop.annotation.DescriptionAnnotation) <em>Out Description Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Description Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#outDescriptionAnnotation(org.polymodel.scop.annotation.DescriptionAnnotation)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__OutDescriptionAnnotation__DescriptionAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#visitTileLoopAnnotation(org.polymodel.scop.annotation.TileLoopAnnotation) <em>Visit Tile Loop Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Tile Loop Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#visitTileLoopAnnotation(org.polymodel.scop.annotation.TileLoopAnnotation)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__VisitTileLoopAnnotation__TileLoopAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#inTileLoopAnnotation(org.polymodel.scop.annotation.TileLoopAnnotation) <em>In Tile Loop Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Tile Loop Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#inTileLoopAnnotation(org.polymodel.scop.annotation.TileLoopAnnotation)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__InTileLoopAnnotation__TileLoopAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#outTileLoopAnnotation(org.polymodel.scop.annotation.TileLoopAnnotation) <em>Out Tile Loop Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Tile Loop Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#outTileLoopAnnotation(org.polymodel.scop.annotation.TileLoopAnnotation)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__OutTileLoopAnnotation__TileLoopAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#visitParallelBlockAnnotation(org.polymodel.scop.annotation.ParallelBlockAnnotation) <em>Visit Parallel Block Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Parallel Block Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#visitParallelBlockAnnotation(org.polymodel.scop.annotation.ParallelBlockAnnotation)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__VisitParallelBlockAnnotation__ParallelBlockAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#inParallelBlockAnnotation(org.polymodel.scop.annotation.ParallelBlockAnnotation) <em>In Parallel Block Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Parallel Block Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#inParallelBlockAnnotation(org.polymodel.scop.annotation.ParallelBlockAnnotation)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__InParallelBlockAnnotation__ParallelBlockAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#outParallelBlockAnnotation(org.polymodel.scop.annotation.ParallelBlockAnnotation) <em>Out Parallel Block Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Parallel Block Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#outParallelBlockAnnotation(org.polymodel.scop.annotation.ParallelBlockAnnotation)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__OutParallelBlockAnnotation__ParallelBlockAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#visitPolyhedralDomainAnnotation(org.polymodel.scop.annotation.PolyhedralDomainAnnotation) <em>Visit Polyhedral Domain Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Polyhedral Domain Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#visitPolyhedralDomainAnnotation(org.polymodel.scop.annotation.PolyhedralDomainAnnotation)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__VisitPolyhedralDomainAnnotation__PolyhedralDomainAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#inPolyhedralDomainAnnotation(org.polymodel.scop.annotation.PolyhedralDomainAnnotation) <em>In Polyhedral Domain Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Polyhedral Domain Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#inPolyhedralDomainAnnotation(org.polymodel.scop.annotation.PolyhedralDomainAnnotation)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__InPolyhedralDomainAnnotation__PolyhedralDomainAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#outPolyhedralDomainAnnotation(org.polymodel.scop.annotation.PolyhedralDomainAnnotation) <em>Out Polyhedral Domain Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Polyhedral Domain Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#outPolyhedralDomainAnnotation(org.polymodel.scop.annotation.PolyhedralDomainAnnotation)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__OutPolyhedralDomainAnnotation__PolyhedralDomainAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#visitBarrierAnnotation(org.polymodel.scop.annotation.BarrierAnnotation) <em>Visit Barrier Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Visit Barrier Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#visitBarrierAnnotation(org.polymodel.scop.annotation.BarrierAnnotation)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__VisitBarrierAnnotation__BarrierAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#inBarrierAnnotation(org.polymodel.scop.annotation.BarrierAnnotation) <em>In Barrier Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>In Barrier Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#inBarrierAnnotation(org.polymodel.scop.annotation.BarrierAnnotation)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__InBarrierAnnotation__BarrierAnnotation();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopDepthFirstVisitor#outBarrierAnnotation(org.polymodel.scop.annotation.BarrierAnnotation) <em>Out Barrier Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Out Barrier Annotation</em>' operation.
	 * @see org.polymodel.scop.ScopDepthFirstVisitor#outBarrierAnnotation(org.polymodel.scop.annotation.BarrierAnnotation)
	 * @generated
	 */
	EOperation getScopDepthFirstVisitor__OutBarrierAnnotation__BarrierAnnotation();

	/**
	 * Returns the meta object for class '{@link org.polymodel.scop.ScopUnscannedDomain <em>Unscanned Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unscanned Domain</em>'.
	 * @see org.polymodel.scop.ScopUnscannedDomain
	 * @generated
	 */
	EClass getScopUnscannedDomain();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polymodel.scop.ScopUnscannedDomain#getMacroParams <em>Macro Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Macro Params</em>'.
	 * @see org.polymodel.scop.ScopUnscannedDomain#getMacroParams()
	 * @see #getScopUnscannedDomain()
	 * @generated
	 */
	EReference getScopUnscannedDomain_MacroParams();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.scop.ScopUnscannedDomain#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polymodel.scop.ScopUnscannedDomain#getName()
	 * @see #getScopUnscannedDomain()
	 * @generated
	 */
	EAttribute getScopUnscannedDomain_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.polymodel.scop.ScopUnscannedDomain#getSchedule <em>Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Schedule</em>'.
	 * @see org.polymodel.scop.ScopUnscannedDomain#getSchedule()
	 * @see #getScopUnscannedDomain()
	 * @generated
	 */
	EAttribute getScopUnscannedDomain_Schedule();

	/**
	 * Returns the meta object for the '{@link org.polymodel.scop.ScopUnscannedDomain#accept(org.polymodel.scop.ScopVisitor) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.polymodel.scop.ScopUnscannedDomain#accept(org.polymodel.scop.ScopVisitor)
	 * @generated
	 */
	EOperation getScopUnscannedDomain__Accept__ScopVisitor();

	/**
	 * Returns the meta object for data type '{@link fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionMap <em>JNIISL Union Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>JNIISL Union Map</em>'.
	 * @see fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionMap
	 * @model instanceClass="fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionMap"
	 * @generated
	 */
	EDataType getJNIISLUnionMap();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ScopFactory getScopFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.polymodel.scop.impl.AbstractScopNodeImpl <em>Abstract Scop Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.scop.impl.AbstractScopNodeImpl
		 * @see org.polymodel.scop.impl.ScopPackageImpl#getAbstractScopNode()
		 * @generated
		 */
		EClass ABSTRACT_SCOP_NODE = eINSTANCE.getAbstractScopNode();

		/**
		 * The meta object literal for the '<em><b>Scop Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_SCOP_NODE__SCOP_ANNOTATIONS = eINSTANCE.getAbstractScopNode_ScopAnnotations();

		/**
		 * The meta object literal for the '<em><b>Get Surrounding Iterators</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_SCOP_NODE___GET_SURROUNDING_ITERATORS = eINSTANCE.getAbstractScopNode__GetSurroundingIterators();

		/**
		 * The meta object literal for the '<em><b>Get Surrounding Scop Fors</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_SCOP_NODE___GET_SURROUNDING_SCOP_FORS = eINSTANCE.getAbstractScopNode__GetSurroundingScopFors();

		/**
		 * The meta object literal for the '<em><b>Simplify</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_SCOP_NODE___SIMPLIFY = eINSTANCE.getAbstractScopNode__Simplify();

		/**
		 * The meta object literal for the '<em><b>Get Loop Depth</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_SCOP_NODE___GET_LOOP_DEPTH = eINSTANCE.getAbstractScopNode__GetLoopDepth();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_SCOP_NODE___ACCEPT__SCOPVISITOR = eINSTANCE.getAbstractScopNode__Accept__ScopVisitor();

		/**
		 * The meta object literal for the '<em><b>Get Surrounding Scop For</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_SCOP_NODE___GET_SURROUNDING_SCOP_FOR = eINSTANCE.getAbstractScopNode__GetSurroundingScopFor();

		/**
		 * The meta object literal for the '<em><b>Get Derived Constraints</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_SCOP_NODE___GET_DERIVED_CONSTRAINTS = eINSTANCE.getAbstractScopNode__GetDerivedConstraints();

		/**
		 * The meta object literal for the '{@link org.polymodel.scop.IScopAnnotation <em>IScop Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.scop.IScopAnnotation
		 * @see org.polymodel.scop.impl.ScopPackageImpl#getIScopAnnotation()
		 * @generated
		 */
		EClass ISCOP_ANNOTATION = eINSTANCE.getIScopAnnotation();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ISCOP_ANNOTATION___ACCEPT__SCOPVISITOR = eINSTANCE.getIScopAnnotation__Accept__ScopVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.scop.impl.ScopRootImpl <em>Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.scop.impl.ScopRootImpl
		 * @see org.polymodel.scop.impl.ScopPackageImpl#getScopRoot()
		 * @generated
		 */
		EClass SCOP_ROOT = eINSTANCE.getScopRoot();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOP_ROOT__STATEMENTS = eINSTANCE.getScopRoot_Statements();

		/**
		 * The meta object literal for the '<em><b>Simplify</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_ROOT___SIMPLIFY = eINSTANCE.getScopRoot__Simplify();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_ROOT___ACCEPT__SCOPVISITOR = eINSTANCE.getScopRoot__Accept__ScopVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.scop.impl.ScopForImpl <em>For</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.scop.impl.ScopForImpl
		 * @see org.polymodel.scop.impl.ScopPackageImpl#getScopFor()
		 * @generated
		 */
		EClass SCOP_FOR = eINSTANCE.getScopFor();

		/**
		 * The meta object literal for the '<em><b>Iterator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOP_FOR__ITERATOR = eINSTANCE.getScopFor_Iterator();

		/**
		 * The meta object literal for the '<em><b>LB</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOP_FOR__LB = eINSTANCE.getScopFor_LB();

		/**
		 * The meta object literal for the '<em><b>UB</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOP_FOR__UB = eINSTANCE.getScopFor_UB();

		/**
		 * The meta object literal for the '<em><b>Stride</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOP_FOR__STRIDE = eINSTANCE.getScopFor_Stride();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOP_FOR__BODY = eINSTANCE.getScopFor_Body();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_FOR___ACCEPT__SCOPVISITOR = eINSTANCE.getScopFor__Accept__ScopVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.scop.impl.ScopBlockImpl <em>Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.scop.impl.ScopBlockImpl
		 * @see org.polymodel.scop.impl.ScopPackageImpl#getScopBlock()
		 * @generated
		 */
		EClass SCOP_BLOCK = eINSTANCE.getScopBlock();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOP_BLOCK__STATEMENTS = eINSTANCE.getScopBlock_Statements();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_BLOCK___ACCEPT__SCOPVISITOR = eINSTANCE.getScopBlock__Accept__ScopVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.scop.impl.ScopGuardImpl <em>Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.scop.impl.ScopGuardImpl
		 * @see org.polymodel.scop.impl.ScopPackageImpl#getScopGuard()
		 * @generated
		 */
		EClass SCOP_GUARD = eINSTANCE.getScopGuard();

		/**
		 * The meta object literal for the '<em><b>Constraint Systems</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOP_GUARD__CONSTRAINT_SYSTEMS = eINSTANCE.getScopGuard_ConstraintSystems();

		/**
		 * The meta object literal for the '<em><b>Then Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOP_GUARD__THEN_BODY = eINSTANCE.getScopGuard_ThenBody();

		/**
		 * The meta object literal for the '<em><b>Else Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOP_GUARD__ELSE_BODY = eINSTANCE.getScopGuard_ElseBody();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_GUARD___ACCEPT__SCOPVISITOR = eINSTANCE.getScopGuard__Accept__ScopVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.scop.impl.ScopStatementMacroImpl <em>Statement Macro</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.scop.impl.ScopStatementMacroImpl
		 * @see org.polymodel.scop.impl.ScopPackageImpl#getScopStatementMacro()
		 * @generated
		 */
		EClass SCOP_STATEMENT_MACRO = eINSTANCE.getScopStatementMacro();

		/**
		 * The meta object literal for the '<em><b>Macro Params</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOP_STATEMENT_MACRO__MACRO_PARAMS = eINSTANCE.getScopStatementMacro_MacroParams();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCOP_STATEMENT_MACRO__NAME = eINSTANCE.getScopStatementMacro_Name();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_STATEMENT_MACRO___ACCEPT__SCOPVISITOR = eINSTANCE.getScopStatementMacro__Accept__ScopVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.scop.impl.ScopAssignmentImpl <em>Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.scop.impl.ScopAssignmentImpl
		 * @see org.polymodel.scop.impl.ScopPackageImpl#getScopAssignment()
		 * @generated
		 */
		EClass SCOP_ASSIGNMENT = eINSTANCE.getScopAssignment();

		/**
		 * The meta object literal for the '<em><b>LHS</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOP_ASSIGNMENT__LHS = eINSTANCE.getScopAssignment_LHS();

		/**
		 * The meta object literal for the '<em><b>RHS</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOP_ASSIGNMENT__RHS = eINSTANCE.getScopAssignment_RHS();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_ASSIGNMENT___ACCEPT__SCOPVISITOR = eINSTANCE.getScopAssignment__Accept__ScopVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.scop.impl.AbstractScopStatementImpl <em>Abstract Scop Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.scop.impl.AbstractScopStatementImpl
		 * @see org.polymodel.scop.impl.ScopPackageImpl#getAbstractScopStatement()
		 * @generated
		 */
		EClass ABSTRACT_SCOP_STATEMENT = eINSTANCE.getAbstractScopStatement();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_SCOP_STATEMENT___ACCEPT__SCOPVISITOR = eINSTANCE.getAbstractScopStatement__Accept__ScopVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.scop.ScopVisitor <em>Visitor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.scop.ScopVisitor
		 * @see org.polymodel.scop.impl.ScopPackageImpl#getScopVisitor()
		 * @generated
		 */
		EClass SCOP_VISITOR = eINSTANCE.getScopVisitor();

		/**
		 * The meta object literal for the '<em><b>Default In</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___DEFAULT_IN__SCOPVISITABLE = eINSTANCE.getScopVisitor__DefaultIn__ScopVisitable();

		/**
		 * The meta object literal for the '<em><b>Default Out</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___DEFAULT_OUT__SCOPVISITABLE = eINSTANCE.getScopVisitor__DefaultOut__ScopVisitable();

		/**
		 * The meta object literal for the '<em><b>Visit Abstract Scop Node</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___VISIT_ABSTRACT_SCOP_NODE__ABSTRACTSCOPNODE = eINSTANCE.getScopVisitor__VisitAbstractScopNode__AbstractScopNode();

		/**
		 * The meta object literal for the '<em><b>In Abstract Scop Node</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___IN_ABSTRACT_SCOP_NODE__ABSTRACTSCOPNODE = eINSTANCE.getScopVisitor__InAbstractScopNode__AbstractScopNode();

		/**
		 * The meta object literal for the '<em><b>Out Abstract Scop Node</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___OUT_ABSTRACT_SCOP_NODE__ABSTRACTSCOPNODE = eINSTANCE.getScopVisitor__OutAbstractScopNode__AbstractScopNode();

		/**
		 * The meta object literal for the '<em><b>Visit IScop Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___VISIT_ISCOP_ANNOTATION__ISCOPANNOTATION = eINSTANCE.getScopVisitor__VisitIScopAnnotation__IScopAnnotation();

		/**
		 * The meta object literal for the '<em><b>In IScop Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___IN_ISCOP_ANNOTATION__ISCOPANNOTATION = eINSTANCE.getScopVisitor__InIScopAnnotation__IScopAnnotation();

		/**
		 * The meta object literal for the '<em><b>Out IScop Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___OUT_ISCOP_ANNOTATION__ISCOPANNOTATION = eINSTANCE.getScopVisitor__OutIScopAnnotation__IScopAnnotation();

		/**
		 * The meta object literal for the '<em><b>Visit Scop Root</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___VISIT_SCOP_ROOT__SCOPROOT = eINSTANCE.getScopVisitor__VisitScopRoot__ScopRoot();

		/**
		 * The meta object literal for the '<em><b>In Scop Root</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___IN_SCOP_ROOT__SCOPROOT = eINSTANCE.getScopVisitor__InScopRoot__ScopRoot();

		/**
		 * The meta object literal for the '<em><b>Out Scop Root</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___OUT_SCOP_ROOT__SCOPROOT = eINSTANCE.getScopVisitor__OutScopRoot__ScopRoot();

		/**
		 * The meta object literal for the '<em><b>Visit Scop For</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___VISIT_SCOP_FOR__SCOPFOR = eINSTANCE.getScopVisitor__VisitScopFor__ScopFor();

		/**
		 * The meta object literal for the '<em><b>In Scop For</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___IN_SCOP_FOR__SCOPFOR = eINSTANCE.getScopVisitor__InScopFor__ScopFor();

		/**
		 * The meta object literal for the '<em><b>Out Scop For</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___OUT_SCOP_FOR__SCOPFOR = eINSTANCE.getScopVisitor__OutScopFor__ScopFor();

		/**
		 * The meta object literal for the '<em><b>Visit Scop Block</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___VISIT_SCOP_BLOCK__SCOPBLOCK = eINSTANCE.getScopVisitor__VisitScopBlock__ScopBlock();

		/**
		 * The meta object literal for the '<em><b>In Scop Block</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___IN_SCOP_BLOCK__SCOPBLOCK = eINSTANCE.getScopVisitor__InScopBlock__ScopBlock();

		/**
		 * The meta object literal for the '<em><b>Out Scop Block</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___OUT_SCOP_BLOCK__SCOPBLOCK = eINSTANCE.getScopVisitor__OutScopBlock__ScopBlock();

		/**
		 * The meta object literal for the '<em><b>Visit Scop Guard</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___VISIT_SCOP_GUARD__SCOPGUARD = eINSTANCE.getScopVisitor__VisitScopGuard__ScopGuard();

		/**
		 * The meta object literal for the '<em><b>In Scop Guard</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___IN_SCOP_GUARD__SCOPGUARD = eINSTANCE.getScopVisitor__InScopGuard__ScopGuard();

		/**
		 * The meta object literal for the '<em><b>Out Scop Guard</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___OUT_SCOP_GUARD__SCOPGUARD = eINSTANCE.getScopVisitor__OutScopGuard__ScopGuard();

		/**
		 * The meta object literal for the '<em><b>Visit Scop Statement Macro</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___VISIT_SCOP_STATEMENT_MACRO__SCOPSTATEMENTMACRO = eINSTANCE.getScopVisitor__VisitScopStatementMacro__ScopStatementMacro();

		/**
		 * The meta object literal for the '<em><b>In Scop Statement Macro</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___IN_SCOP_STATEMENT_MACRO__SCOPSTATEMENTMACRO = eINSTANCE.getScopVisitor__InScopStatementMacro__ScopStatementMacro();

		/**
		 * The meta object literal for the '<em><b>Out Scop Statement Macro</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___OUT_SCOP_STATEMENT_MACRO__SCOPSTATEMENTMACRO = eINSTANCE.getScopVisitor__OutScopStatementMacro__ScopStatementMacro();

		/**
		 * The meta object literal for the '<em><b>Visit Scop Assignment</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___VISIT_SCOP_ASSIGNMENT__SCOPASSIGNMENT = eINSTANCE.getScopVisitor__VisitScopAssignment__ScopAssignment();

		/**
		 * The meta object literal for the '<em><b>In Scop Assignment</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___IN_SCOP_ASSIGNMENT__SCOPASSIGNMENT = eINSTANCE.getScopVisitor__InScopAssignment__ScopAssignment();

		/**
		 * The meta object literal for the '<em><b>Out Scop Assignment</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___OUT_SCOP_ASSIGNMENT__SCOPASSIGNMENT = eINSTANCE.getScopVisitor__OutScopAssignment__ScopAssignment();

		/**
		 * The meta object literal for the '<em><b>Visit Abstract Scop Statement</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___VISIT_ABSTRACT_SCOP_STATEMENT__ABSTRACTSCOPSTATEMENT = eINSTANCE.getScopVisitor__VisitAbstractScopStatement__AbstractScopStatement();

		/**
		 * The meta object literal for the '<em><b>In Abstract Scop Statement</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___IN_ABSTRACT_SCOP_STATEMENT__ABSTRACTSCOPSTATEMENT = eINSTANCE.getScopVisitor__InAbstractScopStatement__AbstractScopStatement();

		/**
		 * The meta object literal for the '<em><b>Out Abstract Scop Statement</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___OUT_ABSTRACT_SCOP_STATEMENT__ABSTRACTSCOPSTATEMENT = eINSTANCE.getScopVisitor__OutAbstractScopStatement__AbstractScopStatement();

		/**
		 * The meta object literal for the '<em><b>Visit Parallel Loop Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___VISIT_PARALLEL_LOOP_ANNOTATION__PARALLELLOOPANNOTATION = eINSTANCE.getScopVisitor__VisitParallelLoopAnnotation__ParallelLoopAnnotation();

		/**
		 * The meta object literal for the '<em><b>In Parallel Loop Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___IN_PARALLEL_LOOP_ANNOTATION__PARALLELLOOPANNOTATION = eINSTANCE.getScopVisitor__InParallelLoopAnnotation__ParallelLoopAnnotation();

		/**
		 * The meta object literal for the '<em><b>Out Parallel Loop Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___OUT_PARALLEL_LOOP_ANNOTATION__PARALLELLOOPANNOTATION = eINSTANCE.getScopVisitor__OutParallelLoopAnnotation__ParallelLoopAnnotation();

		/**
		 * The meta object literal for the '<em><b>Visit Description Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___VISIT_DESCRIPTION_ANNOTATION__DESCRIPTIONANNOTATION = eINSTANCE.getScopVisitor__VisitDescriptionAnnotation__DescriptionAnnotation();

		/**
		 * The meta object literal for the '<em><b>In Description Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___IN_DESCRIPTION_ANNOTATION__DESCRIPTIONANNOTATION = eINSTANCE.getScopVisitor__InDescriptionAnnotation__DescriptionAnnotation();

		/**
		 * The meta object literal for the '<em><b>Out Description Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___OUT_DESCRIPTION_ANNOTATION__DESCRIPTIONANNOTATION = eINSTANCE.getScopVisitor__OutDescriptionAnnotation__DescriptionAnnotation();

		/**
		 * The meta object literal for the '<em><b>Visit Tile Loop Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___VISIT_TILE_LOOP_ANNOTATION__TILELOOPANNOTATION = eINSTANCE.getScopVisitor__VisitTileLoopAnnotation__TileLoopAnnotation();

		/**
		 * The meta object literal for the '<em><b>In Tile Loop Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___IN_TILE_LOOP_ANNOTATION__TILELOOPANNOTATION = eINSTANCE.getScopVisitor__InTileLoopAnnotation__TileLoopAnnotation();

		/**
		 * The meta object literal for the '<em><b>Out Tile Loop Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___OUT_TILE_LOOP_ANNOTATION__TILELOOPANNOTATION = eINSTANCE.getScopVisitor__OutTileLoopAnnotation__TileLoopAnnotation();

		/**
		 * The meta object literal for the '<em><b>Visit Parallel Block Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___VISIT_PARALLEL_BLOCK_ANNOTATION__PARALLELBLOCKANNOTATION = eINSTANCE.getScopVisitor__VisitParallelBlockAnnotation__ParallelBlockAnnotation();

		/**
		 * The meta object literal for the '<em><b>In Parallel Block Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___IN_PARALLEL_BLOCK_ANNOTATION__PARALLELBLOCKANNOTATION = eINSTANCE.getScopVisitor__InParallelBlockAnnotation__ParallelBlockAnnotation();

		/**
		 * The meta object literal for the '<em><b>Out Parallel Block Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___OUT_PARALLEL_BLOCK_ANNOTATION__PARALLELBLOCKANNOTATION = eINSTANCE.getScopVisitor__OutParallelBlockAnnotation__ParallelBlockAnnotation();

		/**
		 * The meta object literal for the '<em><b>Visit Polyhedral Domain Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___VISIT_POLYHEDRAL_DOMAIN_ANNOTATION__POLYHEDRALDOMAINANNOTATION = eINSTANCE.getScopVisitor__VisitPolyhedralDomainAnnotation__PolyhedralDomainAnnotation();

		/**
		 * The meta object literal for the '<em><b>In Polyhedral Domain Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___IN_POLYHEDRAL_DOMAIN_ANNOTATION__POLYHEDRALDOMAINANNOTATION = eINSTANCE.getScopVisitor__InPolyhedralDomainAnnotation__PolyhedralDomainAnnotation();

		/**
		 * The meta object literal for the '<em><b>Out Polyhedral Domain Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___OUT_POLYHEDRAL_DOMAIN_ANNOTATION__POLYHEDRALDOMAINANNOTATION = eINSTANCE.getScopVisitor__OutPolyhedralDomainAnnotation__PolyhedralDomainAnnotation();

		/**
		 * The meta object literal for the '<em><b>Visit Barrier Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___VISIT_BARRIER_ANNOTATION__BARRIERANNOTATION = eINSTANCE.getScopVisitor__VisitBarrierAnnotation__BarrierAnnotation();

		/**
		 * The meta object literal for the '<em><b>In Barrier Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___IN_BARRIER_ANNOTATION__BARRIERANNOTATION = eINSTANCE.getScopVisitor__InBarrierAnnotation__BarrierAnnotation();

		/**
		 * The meta object literal for the '<em><b>Out Barrier Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___OUT_BARRIER_ANNOTATION__BARRIERANNOTATION = eINSTANCE.getScopVisitor__OutBarrierAnnotation__BarrierAnnotation();

		/**
		 * The meta object literal for the '<em><b>Visit Scop Unscanned Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___VISIT_SCOP_UNSCANNED_DOMAIN__SCOPUNSCANNEDDOMAIN = eINSTANCE.getScopVisitor__VisitScopUnscannedDomain__ScopUnscannedDomain();

		/**
		 * The meta object literal for the '<em><b>In Scop Unscanned Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___IN_SCOP_UNSCANNED_DOMAIN__SCOPUNSCANNEDDOMAIN = eINSTANCE.getScopVisitor__InScopUnscannedDomain__ScopUnscannedDomain();

		/**
		 * The meta object literal for the '<em><b>Out Scop Unscanned Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITOR___OUT_SCOP_UNSCANNED_DOMAIN__SCOPUNSCANNEDDOMAIN = eINSTANCE.getScopVisitor__OutScopUnscannedDomain__ScopUnscannedDomain();

		/**
		 * The meta object literal for the '{@link org.polymodel.scop.ScopVisitable <em>Visitable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.scop.ScopVisitable
		 * @see org.polymodel.scop.impl.ScopPackageImpl#getScopVisitable()
		 * @generated
		 */
		EClass SCOP_VISITABLE = eINSTANCE.getScopVisitable();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_VISITABLE___ACCEPT__SCOPVISITOR = eINSTANCE.getScopVisitable__Accept__ScopVisitor();

		/**
		 * The meta object literal for the '{@link org.polymodel.scop.impl.ScopDepthFirstVisitorImpl <em>Depth First Visitor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.scop.impl.ScopDepthFirstVisitorImpl
		 * @see org.polymodel.scop.impl.ScopPackageImpl#getScopDepthFirstVisitor()
		 * @generated
		 */
		EClass SCOP_DEPTH_FIRST_VISITOR = eINSTANCE.getScopDepthFirstVisitor();

		/**
		 * The meta object literal for the '<em><b>Default In</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___DEFAULT_IN__SCOPVISITABLE = eINSTANCE.getScopDepthFirstVisitor__DefaultIn__ScopVisitable();

		/**
		 * The meta object literal for the '<em><b>Default Out</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___DEFAULT_OUT__SCOPVISITABLE = eINSTANCE.getScopDepthFirstVisitor__DefaultOut__ScopVisitable();

		/**
		 * The meta object literal for the '<em><b>Visit Abstract Scop Node</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___VISIT_ABSTRACT_SCOP_NODE__ABSTRACTSCOPNODE = eINSTANCE.getScopDepthFirstVisitor__VisitAbstractScopNode__AbstractScopNode();

		/**
		 * The meta object literal for the '<em><b>In Abstract Scop Node</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___IN_ABSTRACT_SCOP_NODE__ABSTRACTSCOPNODE = eINSTANCE.getScopDepthFirstVisitor__InAbstractScopNode__AbstractScopNode();

		/**
		 * The meta object literal for the '<em><b>Out Abstract Scop Node</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___OUT_ABSTRACT_SCOP_NODE__ABSTRACTSCOPNODE = eINSTANCE.getScopDepthFirstVisitor__OutAbstractScopNode__AbstractScopNode();

		/**
		 * The meta object literal for the '<em><b>Visit IScop Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___VISIT_ISCOP_ANNOTATION__ISCOPANNOTATION = eINSTANCE.getScopDepthFirstVisitor__VisitIScopAnnotation__IScopAnnotation();

		/**
		 * The meta object literal for the '<em><b>In IScop Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___IN_ISCOP_ANNOTATION__ISCOPANNOTATION = eINSTANCE.getScopDepthFirstVisitor__InIScopAnnotation__IScopAnnotation();

		/**
		 * The meta object literal for the '<em><b>Out IScop Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___OUT_ISCOP_ANNOTATION__ISCOPANNOTATION = eINSTANCE.getScopDepthFirstVisitor__OutIScopAnnotation__IScopAnnotation();

		/**
		 * The meta object literal for the '<em><b>Visit Scop Root</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_ROOT__SCOPROOT = eINSTANCE.getScopDepthFirstVisitor__VisitScopRoot__ScopRoot();

		/**
		 * The meta object literal for the '<em><b>In Scop Root</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_ROOT__SCOPROOT = eINSTANCE.getScopDepthFirstVisitor__InScopRoot__ScopRoot();

		/**
		 * The meta object literal for the '<em><b>Out Scop Root</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_ROOT__SCOPROOT = eINSTANCE.getScopDepthFirstVisitor__OutScopRoot__ScopRoot();

		/**
		 * The meta object literal for the '<em><b>Visit Scop For</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_FOR__SCOPFOR = eINSTANCE.getScopDepthFirstVisitor__VisitScopFor__ScopFor();

		/**
		 * The meta object literal for the '<em><b>In Scop For</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_FOR__SCOPFOR = eINSTANCE.getScopDepthFirstVisitor__InScopFor__ScopFor();

		/**
		 * The meta object literal for the '<em><b>Out Scop For</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_FOR__SCOPFOR = eINSTANCE.getScopDepthFirstVisitor__OutScopFor__ScopFor();

		/**
		 * The meta object literal for the '<em><b>Visit Scop Block</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_BLOCK__SCOPBLOCK = eINSTANCE.getScopDepthFirstVisitor__VisitScopBlock__ScopBlock();

		/**
		 * The meta object literal for the '<em><b>In Scop Block</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_BLOCK__SCOPBLOCK = eINSTANCE.getScopDepthFirstVisitor__InScopBlock__ScopBlock();

		/**
		 * The meta object literal for the '<em><b>Out Scop Block</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_BLOCK__SCOPBLOCK = eINSTANCE.getScopDepthFirstVisitor__OutScopBlock__ScopBlock();

		/**
		 * The meta object literal for the '<em><b>Visit Scop Guard</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_GUARD__SCOPGUARD = eINSTANCE.getScopDepthFirstVisitor__VisitScopGuard__ScopGuard();

		/**
		 * The meta object literal for the '<em><b>In Scop Guard</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_GUARD__SCOPGUARD = eINSTANCE.getScopDepthFirstVisitor__InScopGuard__ScopGuard();

		/**
		 * The meta object literal for the '<em><b>Out Scop Guard</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_GUARD__SCOPGUARD = eINSTANCE.getScopDepthFirstVisitor__OutScopGuard__ScopGuard();

		/**
		 * The meta object literal for the '<em><b>Visit Scop Statement Macro</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_STATEMENT_MACRO__SCOPSTATEMENTMACRO = eINSTANCE.getScopDepthFirstVisitor__VisitScopStatementMacro__ScopStatementMacro();

		/**
		 * The meta object literal for the '<em><b>In Scop Statement Macro</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_STATEMENT_MACRO__SCOPSTATEMENTMACRO = eINSTANCE.getScopDepthFirstVisitor__InScopStatementMacro__ScopStatementMacro();

		/**
		 * The meta object literal for the '<em><b>Out Scop Statement Macro</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_STATEMENT_MACRO__SCOPSTATEMENTMACRO = eINSTANCE.getScopDepthFirstVisitor__OutScopStatementMacro__ScopStatementMacro();

		/**
		 * The meta object literal for the '<em><b>Visit Scop Unscanned Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_UNSCANNED_DOMAIN__SCOPUNSCANNEDDOMAIN_1 = eINSTANCE.getScopDepthFirstVisitor__VisitScopUnscannedDomain__ScopUnscannedDomain_1();

		/**
		 * The meta object literal for the '<em><b>In Scop Unscanned Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_UNSCANNED_DOMAIN__SCOPUNSCANNEDDOMAIN_1 = eINSTANCE.getScopDepthFirstVisitor__InScopUnscannedDomain__ScopUnscannedDomain_1();

		/**
		 * The meta object literal for the '<em><b>Out Scop Unscanned Domain</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_UNSCANNED_DOMAIN__SCOPUNSCANNEDDOMAIN_1 = eINSTANCE.getScopDepthFirstVisitor__OutScopUnscannedDomain__ScopUnscannedDomain_1();

		/**
		 * The meta object literal for the '<em><b>Visit Scop Assignment</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_ASSIGNMENT__SCOPASSIGNMENT = eINSTANCE.getScopDepthFirstVisitor__VisitScopAssignment__ScopAssignment();

		/**
		 * The meta object literal for the '<em><b>In Scop Assignment</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_ASSIGNMENT__SCOPASSIGNMENT = eINSTANCE.getScopDepthFirstVisitor__InScopAssignment__ScopAssignment();

		/**
		 * The meta object literal for the '<em><b>Out Scop Assignment</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_ASSIGNMENT__SCOPASSIGNMENT = eINSTANCE.getScopDepthFirstVisitor__OutScopAssignment__ScopAssignment();

		/**
		 * The meta object literal for the '<em><b>Visit Abstract Scop Statement</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___VISIT_ABSTRACT_SCOP_STATEMENT__ABSTRACTSCOPSTATEMENT = eINSTANCE.getScopDepthFirstVisitor__VisitAbstractScopStatement__AbstractScopStatement();

		/**
		 * The meta object literal for the '<em><b>In Abstract Scop Statement</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___IN_ABSTRACT_SCOP_STATEMENT__ABSTRACTSCOPSTATEMENT = eINSTANCE.getScopDepthFirstVisitor__InAbstractScopStatement__AbstractScopStatement();

		/**
		 * The meta object literal for the '<em><b>Out Abstract Scop Statement</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___OUT_ABSTRACT_SCOP_STATEMENT__ABSTRACTSCOPSTATEMENT = eINSTANCE.getScopDepthFirstVisitor__OutAbstractScopStatement__AbstractScopStatement();

		/**
		 * The meta object literal for the '<em><b>Visit Parallel Loop Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___VISIT_PARALLEL_LOOP_ANNOTATION__PARALLELLOOPANNOTATION = eINSTANCE.getScopDepthFirstVisitor__VisitParallelLoopAnnotation__ParallelLoopAnnotation();

		/**
		 * The meta object literal for the '<em><b>In Parallel Loop Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___IN_PARALLEL_LOOP_ANNOTATION__PARALLELLOOPANNOTATION = eINSTANCE.getScopDepthFirstVisitor__InParallelLoopAnnotation__ParallelLoopAnnotation();

		/**
		 * The meta object literal for the '<em><b>Out Parallel Loop Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___OUT_PARALLEL_LOOP_ANNOTATION__PARALLELLOOPANNOTATION = eINSTANCE.getScopDepthFirstVisitor__OutParallelLoopAnnotation__ParallelLoopAnnotation();

		/**
		 * The meta object literal for the '<em><b>Visit Description Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___VISIT_DESCRIPTION_ANNOTATION__DESCRIPTIONANNOTATION = eINSTANCE.getScopDepthFirstVisitor__VisitDescriptionAnnotation__DescriptionAnnotation();

		/**
		 * The meta object literal for the '<em><b>In Description Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___IN_DESCRIPTION_ANNOTATION__DESCRIPTIONANNOTATION = eINSTANCE.getScopDepthFirstVisitor__InDescriptionAnnotation__DescriptionAnnotation();

		/**
		 * The meta object literal for the '<em><b>Out Description Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___OUT_DESCRIPTION_ANNOTATION__DESCRIPTIONANNOTATION = eINSTANCE.getScopDepthFirstVisitor__OutDescriptionAnnotation__DescriptionAnnotation();

		/**
		 * The meta object literal for the '<em><b>Visit Tile Loop Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___VISIT_TILE_LOOP_ANNOTATION__TILELOOPANNOTATION = eINSTANCE.getScopDepthFirstVisitor__VisitTileLoopAnnotation__TileLoopAnnotation();

		/**
		 * The meta object literal for the '<em><b>In Tile Loop Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___IN_TILE_LOOP_ANNOTATION__TILELOOPANNOTATION = eINSTANCE.getScopDepthFirstVisitor__InTileLoopAnnotation__TileLoopAnnotation();

		/**
		 * The meta object literal for the '<em><b>Out Tile Loop Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___OUT_TILE_LOOP_ANNOTATION__TILELOOPANNOTATION = eINSTANCE.getScopDepthFirstVisitor__OutTileLoopAnnotation__TileLoopAnnotation();

		/**
		 * The meta object literal for the '<em><b>Visit Parallel Block Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___VISIT_PARALLEL_BLOCK_ANNOTATION__PARALLELBLOCKANNOTATION = eINSTANCE.getScopDepthFirstVisitor__VisitParallelBlockAnnotation__ParallelBlockAnnotation();

		/**
		 * The meta object literal for the '<em><b>In Parallel Block Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___IN_PARALLEL_BLOCK_ANNOTATION__PARALLELBLOCKANNOTATION = eINSTANCE.getScopDepthFirstVisitor__InParallelBlockAnnotation__ParallelBlockAnnotation();

		/**
		 * The meta object literal for the '<em><b>Out Parallel Block Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___OUT_PARALLEL_BLOCK_ANNOTATION__PARALLELBLOCKANNOTATION = eINSTANCE.getScopDepthFirstVisitor__OutParallelBlockAnnotation__ParallelBlockAnnotation();

		/**
		 * The meta object literal for the '<em><b>Visit Polyhedral Domain Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___VISIT_POLYHEDRAL_DOMAIN_ANNOTATION__POLYHEDRALDOMAINANNOTATION = eINSTANCE.getScopDepthFirstVisitor__VisitPolyhedralDomainAnnotation__PolyhedralDomainAnnotation();

		/**
		 * The meta object literal for the '<em><b>In Polyhedral Domain Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___IN_POLYHEDRAL_DOMAIN_ANNOTATION__POLYHEDRALDOMAINANNOTATION = eINSTANCE.getScopDepthFirstVisitor__InPolyhedralDomainAnnotation__PolyhedralDomainAnnotation();

		/**
		 * The meta object literal for the '<em><b>Out Polyhedral Domain Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___OUT_POLYHEDRAL_DOMAIN_ANNOTATION__POLYHEDRALDOMAINANNOTATION = eINSTANCE.getScopDepthFirstVisitor__OutPolyhedralDomainAnnotation__PolyhedralDomainAnnotation();

		/**
		 * The meta object literal for the '<em><b>Visit Barrier Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___VISIT_BARRIER_ANNOTATION__BARRIERANNOTATION = eINSTANCE.getScopDepthFirstVisitor__VisitBarrierAnnotation__BarrierAnnotation();

		/**
		 * The meta object literal for the '<em><b>In Barrier Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___IN_BARRIER_ANNOTATION__BARRIERANNOTATION = eINSTANCE.getScopDepthFirstVisitor__InBarrierAnnotation__BarrierAnnotation();

		/**
		 * The meta object literal for the '<em><b>Out Barrier Annotation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_DEPTH_FIRST_VISITOR___OUT_BARRIER_ANNOTATION__BARRIERANNOTATION = eINSTANCE.getScopDepthFirstVisitor__OutBarrierAnnotation__BarrierAnnotation();

		/**
		 * The meta object literal for the '{@link org.polymodel.scop.impl.ScopUnscannedDomainImpl <em>Unscanned Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polymodel.scop.impl.ScopUnscannedDomainImpl
		 * @see org.polymodel.scop.impl.ScopPackageImpl#getScopUnscannedDomain()
		 * @generated
		 */
		EClass SCOP_UNSCANNED_DOMAIN = eINSTANCE.getScopUnscannedDomain();

		/**
		 * The meta object literal for the '<em><b>Macro Params</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCOP_UNSCANNED_DOMAIN__MACRO_PARAMS = eINSTANCE.getScopUnscannedDomain_MacroParams();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCOP_UNSCANNED_DOMAIN__NAME = eINSTANCE.getScopUnscannedDomain_Name();

		/**
		 * The meta object literal for the '<em><b>Schedule</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCOP_UNSCANNED_DOMAIN__SCHEDULE = eINSTANCE.getScopUnscannedDomain_Schedule();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCOP_UNSCANNED_DOMAIN___ACCEPT__SCOPVISITOR = eINSTANCE.getScopUnscannedDomain__Accept__ScopVisitor();

		/**
		 * The meta object literal for the '<em>JNIISL Union Map</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionMap
		 * @see org.polymodel.scop.impl.ScopPackageImpl#getJNIISLUnionMap()
		 * @generated
		 */
		EDataType JNIISL_UNION_MAP = eINSTANCE.getJNIISLUnionMap();

	}

} //ScopPackage
