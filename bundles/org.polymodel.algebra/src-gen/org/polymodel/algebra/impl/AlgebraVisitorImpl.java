/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.algebra.AlgebraPackage;
import org.polymodel.algebra.AlgebraVisitable;
import org.polymodel.algebra.AlgebraVisitor;
import org.polymodel.algebra.CompositeIntExpression;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.IntTerm;
import org.polymodel.algebra.SelectExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.polynomials.PolynomialExpression;
import org.polymodel.algebra.polynomials.PolynomialTerm;
import org.polymodel.algebra.polynomials.PolynomialVariable;
import org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm;
import org.polymodel.algebra.quasiAffine.QuasiAffineExpression;
import org.polymodel.algebra.quasiAffine.QuasiAffineTerm;
import org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm;
import org.polymodel.algebra.reductions.ReductionExpression;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Visitor</b></em>'. Visit also all visitable contained objects of each
 * visited object. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class AlgebraVisitorImpl extends EObjectImpl implements
		AlgebraVisitor {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected AlgebraVisitorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlgebraPackage.Literals.ALGEBRA_VISITOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void visitIntExpression(IntExpression i) {
		for (EObject obj : i.eContents()) {
			if (obj instanceof AlgebraVisitable) {
				((AlgebraVisitable)obj).accept(this);
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitCompositeIntExpression(final CompositeIntExpression r) {
		r.getLeft().accept(this);
		r.getRight().accept(this);
			
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitSelectExpression(SelectExpression ie) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case AlgebraPackage.ALGEBRA_VISITOR___VISIT_INT_TERM__INTTERM:
				visitIntTerm((IntTerm)arguments.get(0));
				return null;
			case AlgebraPackage.ALGEBRA_VISITOR___VISIT_VARIABLE__VARIABLE:
				visitVariable((Variable)arguments.get(0));
				return null;
			case AlgebraPackage.ALGEBRA_VISITOR___VISIT_INT_CONSTRAINT__INTCONSTRAINT:
				visitIntConstraint((IntConstraint)arguments.get(0));
				return null;
			case AlgebraPackage.ALGEBRA_VISITOR___VISIT_INT_CONSTRAINT_SYSTEM__INTCONSTRAINTSYSTEM:
				visitIntConstraintSystem((IntConstraintSystem)arguments.get(0));
				return null;
			case AlgebraPackage.ALGEBRA_VISITOR___VISIT_AFFINE_EXPRESSION__AFFINEEXPRESSION:
				visitAffineExpression((AffineExpression)arguments.get(0));
				return null;
			case AlgebraPackage.ALGEBRA_VISITOR___VISIT_AFFINE_TERM__AFFINETERM:
				visitAffineTerm((AffineTerm)arguments.get(0));
				return null;
			case AlgebraPackage.ALGEBRA_VISITOR___VISIT_QUASI_AFFINE_EXPRESSION__QUASIAFFINEEXPRESSION:
				visitQuasiAffineExpression((QuasiAffineExpression)arguments.get(0));
				return null;
			case AlgebraPackage.ALGEBRA_VISITOR___VISIT_QUASI_AFFINE_TERM__QUASIAFFINETERM:
				visitQuasiAffineTerm((QuasiAffineTerm)arguments.get(0));
				return null;
			case AlgebraPackage.ALGEBRA_VISITOR___VISIT_SIMPLE_QUASI_AFFINE_TERM__SIMPLEQUASIAFFINETERM:
				visitSimpleQuasiAffineTerm((SimpleQuasiAffineTerm)arguments.get(0));
				return null;
			case AlgebraPackage.ALGEBRA_VISITOR___VISIT_NESTED_QUASI_AFFINE_TERM__NESTEDQUASIAFFINETERM:
				visitNestedQuasiAffineTerm((NestedQuasiAffineTerm)arguments.get(0));
				return null;
			case AlgebraPackage.ALGEBRA_VISITOR___VISIT_POLYNOMIAL_EXPRESSION__POLYNOMIALEXPRESSION:
				visitPolynomialExpression((PolynomialExpression)arguments.get(0));
				return null;
			case AlgebraPackage.ALGEBRA_VISITOR___VISIT_POLYNOMIAL_TERM__POLYNOMIALTERM:
				visitPolynomialTerm((PolynomialTerm)arguments.get(0));
				return null;
			case AlgebraPackage.ALGEBRA_VISITOR___VISIT_POLYNOMIAL_VARIABLE__POLYNOMIALVARIABLE:
				visitPolynomialVariable((PolynomialVariable)arguments.get(0));
				return null;
			case AlgebraPackage.ALGEBRA_VISITOR___VISIT_REDUCTION_EXPRESSION__REDUCTIONEXPRESSION:
				visitReductionExpression((ReductionExpression)arguments.get(0));
				return null;
			case AlgebraPackage.ALGEBRA_VISITOR___VISIT_INT_EXPRESSION__INTEXPRESSION:
				visitIntExpression((IntExpression)arguments.get(0));
				return null;
			case AlgebraPackage.ALGEBRA_VISITOR___VISIT_COMPOSITE_INT_EXPRESSION__COMPOSITEINTEXPRESSION:
				visitCompositeIntExpression((CompositeIntExpression)arguments.get(0));
				return null;
			case AlgebraPackage.ALGEBRA_VISITOR___VISIT_SELECT_EXPRESSION__SELECTEXPRESSION:
				visitSelectExpression((SelectExpression)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void visitIntTerm(IntTerm i) {
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void visitVariable(Variable v) {
	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void visitIntConstraint(final IntConstraint i) {
		i.getLhs().accept(this);
		i.getRhs().accept(this);
		
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void visitIntConstraintSystem(final IntConstraintSystem i) {
		for(IntConstraint o: i.getConstraints())
			 o.accept(this);
		
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAffineExpression(final AffineExpression a) {
		for(AffineTerm o: a.getTerms())
			 o.accept(this);
		
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void visitAffineTerm(AffineTerm a) {
		if (a.getVariable() != null)
			a.getVariable().accept(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void visitQuasiAffineExpression(final QuasiAffineExpression q) {
		for(QuasiAffineTerm o: q.getTerms())
			 o.accept(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitQuasiAffineTerm(final QuasiAffineTerm q) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitSimpleQuasiAffineTerm(final SimpleQuasiAffineTerm q) {
		q.getExpression().accept(this);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitNestedQuasiAffineTerm(final NestedQuasiAffineTerm q) {
		q.getExpression().accept(this);
		
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void visitPolynomialExpression(final PolynomialExpression p) {
		for(PolynomialTerm o: p.getTerms())
			 o.accept(this);
		
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void visitPolynomialTerm(PolynomialTerm p) {
	
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitPolynomialVariable(PolynomialVariable p) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void visitReductionExpression(final ReductionExpression r) {
		for(IntExpression o: r.getExpressions())
			 o.accept(this);
		
	}
	

} // AlgebraVisitorImpl
