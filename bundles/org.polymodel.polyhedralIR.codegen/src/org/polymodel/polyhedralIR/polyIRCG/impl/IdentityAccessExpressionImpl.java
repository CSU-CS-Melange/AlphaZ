/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.impl;

import org.eclipse.emf.ecore.EClass;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.polyhedralIR.polyIRCG.IdentityAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Identity Access Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class IdentityAccessExpressionImpl extends MemoryAccessExpressionImpl implements IdentityAccessExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdentityAccessExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyIRCGPackage.Literals.IDENTITY_ACCESS_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IntExpression getIndexingExpression(int dim) {
		return IntExpressionBuilder.affine(IntExpressionBuilder.term(getVariable().getDomain().getIndices().get(dim)));
	}

} //IdentityAccessExpressionImpl
