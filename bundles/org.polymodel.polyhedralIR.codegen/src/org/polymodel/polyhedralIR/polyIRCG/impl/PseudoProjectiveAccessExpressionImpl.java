/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.impl;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import org.eclipse.emf.ecore.EClass;
import org.polymodel.algebra.IntExpression;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;
import org.polymodel.polyhedralIR.polyIRCG.PseudoProjection;
import org.polymodel.polyhedralIR.polyIRCG.PseudoProjectiveAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGUserFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pseudo Projective Access Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class PseudoProjectiveAccessExpressionImpl extends MemoryAccessExpressionImpl implements PseudoProjectiveAccessExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PseudoProjectiveAccessExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyIRCGPackage.Literals.PSEUDO_PROJECTIVE_ACCESS_EXPRESSION;
	}
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IntExpression getIndexingExpression(int dim) {
		if (getVariable().getDomain() instanceof PseudoProjection) {
			PseudoProjection pp = (PseudoProjection)getVariable().getDomain();
			
			IntExpression indexing = affine(term(getVariable().getDomain().getIndices().get(dim)));
			if (pp.isModFactorInEffect(dim)) {
				return PolyIRCGUserFactory.INSTANCE.mod(indexing, pp.getModFactors().get(dim));
			} else {
				return indexing;
			}
			
		}
		throw new RuntimeException("PseudoProjectiveAccess not associated with PseudoProjection");
	}


} //PseudoProjectiveAccessExpressionImpl
