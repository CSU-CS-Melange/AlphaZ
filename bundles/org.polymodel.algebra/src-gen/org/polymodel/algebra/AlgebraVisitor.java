/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.algebra;

import org.eclipse.emf.ecore.EObject;
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
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visitor</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.polymodel.algebra.AlgebraPackage#getAlgebraVisitor()
 * @model abstract="true"
 * @generated
 */
public interface AlgebraVisitor extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void visitIntTerm(IntTerm i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void visitVariable(Variable v);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='i.getLhs().accept(this);\ni.getRhs().accept(this);\n'"
	 * @generated
	 */
	void visitIntConstraint(IntConstraint i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='for(IntConstraint o: i.getConstraints())\n\t o.accept(this);\n'"
	 * @generated
	 */
	void visitIntConstraintSystem(IntConstraintSystem i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='for(AffineTerm o: a.getTerms())\n\t o.accept(this);\n'"
	 * @generated
	 */
	void visitAffineExpression(AffineExpression a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void visitAffineTerm(AffineTerm a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='for(QuasiAffineTerm o: q.getTerms())\n\t o.accept(this);\n'"
	 * @generated
	 */
	void visitQuasiAffineExpression(QuasiAffineExpression q);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='throw new UnsupportedOperationException();'"
	 * @generated
	 */
	void visitQuasiAffineTerm(QuasiAffineTerm q);
/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='q.getExpression().accept(this);\n'"
	 * @generated
	 */
	void visitSimpleQuasiAffineTerm(SimpleQuasiAffineTerm q);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='q.getExpression().accept(this);\n'"
	 * @generated
	 */
	void visitNestedQuasiAffineTerm(NestedQuasiAffineTerm q);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='for(PolynomialTerm o: p.getTerms())\n\t o.accept(this);\n'"
	 * @generated
	 */
	void visitPolynomialExpression(PolynomialExpression p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='for(PolynomialVariable o: p.getVariables())\n\t o.accept(this);\n'"
	 * @generated
	 */
	void visitPolynomialTerm(PolynomialTerm p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void visitPolynomialVariable(PolynomialVariable p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='for(IntExpression o: r.getExpressions())\n\t o.accept(this);\n'"
	 * @generated
	 */
	void visitReductionExpression(ReductionExpression r);

	/**
	 * <!-- begin-user-doc -->
	 * This case is for extension of expressions outside of this plug-in.
	 * Specifically, it allows for custom expressions to be added outside, and still use
	 * the pretty printer in this project for the most part.
	 * 
	 * Custom extensions of IntExpression should implement toString(OUTPUT_FORMAT) so that it does not 
	 * cause stack overflow due to recursively calling the pretty printer.
	 * (Default behavior of terms are to call pretty printers in this plug-in)
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void visitIntExpression(IntExpression ie);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='r.getLeft().accept(this);\nr.getRight().accept(this);\n\t\n'"
	 * @generated
	 */
	void visitCompositeIntExpression(CompositeIntExpression r);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void visitSelectExpression(SelectExpression ie);

} // AlgebraVisitor
