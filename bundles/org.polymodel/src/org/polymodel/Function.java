/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.matrix.Matrix;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Function</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.polymodel.Function#getExpressionsMap <em>Expressions Map</em>}</li>
 *   <li>{@link org.polymodel.Function#getDimensions <em>Dimensions</em>}</li>
 *   <li>{@link org.polymodel.Function#getIn <em>In</em>}</li>
 *   <li>{@link org.polymodel.Function#getOut <em>Out</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.polymodel.PolymodelPackage#getFunction()
 * @model
 * @generated
 */
public interface Function extends PolymodelVisitable {

	/**
	 * Returns the value of the '<em><b>Expressions Map</b></em>' map.
	 * The key is of type {@link K},
	 * and the value is of type {@link V},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expressions Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expressions Map</em>' map.
	 * @see org.polymodel.PolymodelPackage#getFunction_ExpressionsMap()
	 * @model mapType="org.polymodel.ValueContainedMap<K, V>"
	 * @generated
	 */
	EMap<OutputDimension, IntExpression> getExpressionsMap();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expressions</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<IntExpression> getExpressions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model managerRequired="true"
	 * @generated
	 */
	<T extends Relation> T buildRelation(DimensionsManager manager);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" funcRequired="true"
	 * @generated
	 */
	boolean equivalence(Function func);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" funcRequired="true"
	 * @generated
	 */
	<T extends Function> T compose(Function func);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model managerRequired="true"
	 * @generated
	 */
	<T extends Function> T inverse(DimensionsManager manager);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model managerRequired="true"
	 * @generated
	 */
	<T extends Function> T inverseInContext(DimensionsManager manager, Domain context);

	/**
	 * <!-- begin-user-doc -->
	 * Given a function f = Ax + b, returns [A|b]
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Matrix toMatrix();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" contextRequired="true"
	 * @generated
	 */
	Function uniformizeInContext(Domain context);

	/**
	 * <!-- begin-user-doc -->
	 * Compute a nullspace in function representation.
	 * Each dimension of the result is a space described by one of the basis vectors found.
	 * 
	 * Ignores nullspace spanned by parameters (and only parameters).
	 * 
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Function nullspace();

	/**
	 * <!-- begin-user-doc -->
	 * Given function f = Ax+b, returns A
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	Matrix linearPart();

	/**
	 * <!-- begin-user-doc -->
	 * Given function f = Ax+b, where identity of parameters p are implicit
	 * and thus it actually is
	 * [I 0] [p] + [0]
	 * [0 A] [x]   [b]
	 * returns
	 * [I 0]
	 * [0 A]
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	Matrix linearPartWithParameters();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	Function linearPartAsFunction();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Long> constantPart();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isUniform();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isIdentity();

	/**
	 * Returns the value of the '<em><b>In</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In</em>' containment reference.
	 * @see #setIn(Label)
	 * @see org.polymodel.PolymodelPackage#getFunction_In()
	 * @model containment="true"
	 * @generated
	 */
	Label getIn();

	/**
	 * Sets the value of the '{@link org.polymodel.Function#getIn <em>In</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In</em>' containment reference.
	 * @see #getIn()
	 * @generated
	 */
	void setIn(Label value);

	/**
	 * Returns the value of the '<em><b>Out</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out</em>' containment reference.
	 * @see #setOut(Label)
	 * @see org.polymodel.PolymodelPackage#getFunction_Out()
	 * @model containment="true"
	 * @generated
	 */
	Label getOut();

	/**
	 * Sets the value of the '{@link org.polymodel.Function#getOut <em>Out</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out</em>' containment reference.
	 * @see #getOut()
	 * @generated
	 */
	void setOut(Label value);

	/**
	 * Returns the value of the '<em><b>Dimensions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimensions</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimensions</em>' containment reference.
	 * @see #setDimensions(DomainDimensions)
	 * @see org.polymodel.PolymodelPackage#getFunction_Dimensions()
	 * @model containment="true"
	 * @generated
	 */
	DomainDimensions getDimensions();

	/**
	 * Sets the value of the '{@link org.polymodel.Function#getDimensions <em>Dimensions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dimensions</em>' containment reference.
	 * @see #getDimensions()
	 * @generated
	 */
	void setDimensions(DomainDimensions value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitFunction(this);'"
	 * @generated
	 */
	void accept(PolymodelVisitor visitor);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	IntExpression getExpression(int position);

	/**
	 * Find the function expression associated to a variable. It first find the
	 * output variable and then build the expression that correspond to the
	 * function output.
	 * 
	 * @param v
	 * @return
	 */
	public IntExpression getExpressionFor(OutputDimension o);
	

	<T extends Function> T inverse(DimensionsManager manager, EList<String> names);
	<T extends Function> T inverseInContext(DimensionsManager manager, Domain context, EList<String> names);

	public List<Variable> getParameters();
	public List<Variable> getIndices();
	public int getDimRHS();
	public int getDimLHS();
	public Function copy();

//	/**
//	 * Either use PolymodelComponent.INSTANCE.getDefaultDimensionsManager()
//	 * or manage dimension management at higher level.
//	 */
//	@Deprecated
//	DimensionsManager getDimensionsManager();

//	/**
//	 * Get the map of applied function for each original dimension. For
//	 * example, for a map {[in_i]->[out_i]: out_i=in_i+1} the result will be
//	 * {i->i+1}.
//	 * 
//	 * @return
//	 */
//	public Map<Variable, IntExpression> getOriginalExpressionsMapping();
} // Function
