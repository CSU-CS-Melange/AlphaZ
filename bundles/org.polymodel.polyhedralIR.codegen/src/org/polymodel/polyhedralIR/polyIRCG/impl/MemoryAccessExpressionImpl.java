/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.reductions.ReductionExpression;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.MemoryAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.PolyIRCGPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Memory Access Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.impl.MemoryAccessExpressionImpl#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MemoryAccessExpressionImpl extends EObjectImpl implements MemoryAccessExpression {
	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected CodeGenVariable variable;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MemoryAccessExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyIRCGPackage.Literals.MEMORY_ACCESS_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeGenVariable getVariable() {
		if (variable != null && variable.eIsProxy()) {
			InternalEObject oldVariable = (InternalEObject)variable;
			variable = (CodeGenVariable)eResolveProxy(oldVariable);
			if (variable != oldVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PolyIRCGPackage.MEMORY_ACCESS_EXPRESSION__VARIABLE, oldVariable, variable));
			}
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeGenVariable basicGetVariable() {
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariable(CodeGenVariable newVariable) {
		CodeGenVariable oldVariable = variable;
		variable = newVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyIRCGPackage.MEMORY_ACCESS_EXPRESSION__VARIABLE, oldVariable, variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntExpression getIndexingExpression(int dim) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IntExpression getVolumeExpression(int dim) {
		return getVariable().getVolumeExpression(dim, getVariable().getDomain().getNIndices());
	}

	protected EList<IntExpression> arrayIndexing1D(boolean disableZeroAlignment) {
		EList<IntExpression> exprs = new BasicEList<IntExpression>();
		
		ReductionExpression sum = IntExpressionBuilder.sum();
		for (int d = 0; d < getVariable().getDomain().getNIndices(); d++) {
			sum.getExpressions().add(IntExpressionBuilder.prod(handleZeroAlignment(d, handleFrontPadding(d, getIndexingExpression(d)), disableZeroAlignment), getVolumeExpression(d+1)));
		}

		exprs.add(sum.simplify());
		
		return exprs;
	}
	private EList<IntExpression> arrayIndexingMD(boolean disableZeroAlignment) {
		EList<IntExpression> exprs = new BasicEList<IntExpression>();

		for (int d = 0; d < getVariable().getDomain().getNIndices(); d++) {
			exprs.add(handleZeroAlignment(d, handleFrontPadding(d,getIndexingExpression(d)), disableZeroAlignment));
		}
		
		return exprs;
	}
	
	protected IntExpression handleZeroAlignment(int dim, IntExpression indexing, boolean disableZeroAlignment) {
		if (!getVariable().getDomain().isZeroAligned() && !disableZeroAlignment) {
			IntExpression lb = getVariable().getDomain().getBounds(dim).get(0);
			return IntExpressionBuilder.sub(indexing.copy(), lb).simplify();
		}
		
		return indexing;
	}
	
	protected IntExpression handleFrontPadding(int dim, IntExpression indexing){
		if(getVariable().isIsfrontpadded()){
			return IntExpressionBuilder.add(indexing.copy(), getVariable().getForntpaddingValue().get(dim)).simplify();
		}
		
		return indexing;
	}
	
	
	@Override
	public EList<IntExpression> getAccessExpressions() {
		EList<IntExpression> exprs = new BasicEList<IntExpression>();
		
		//scalar case
		if (org.polymodel.polyhedralIR.codegen.xtend2.Utility.isScalar(getVariable())) {
			return exprs; 
		}
		
		if (getVariable().isFlattened()) {
			return arrayIndexing1D(false);
		} else {
			return arrayIndexingMD(false);
		}
	}

//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public IntExpression getFlattenedIndexingExpression() {
//		StringBuffer sb = new StringBuffer();
//	
//		for (int dim = 0; dim < getVariable().getDomain().getNIndices(); dim++) {
//			if (sb.length() > 0) sb.append("+");
//			sb.append(getIndexingExpression(dim));
//			if (dim < getVariable().getDomain().getNIndices()-1) {
//				sb.append("*");
//				sb.append(getVolumeExpression(dim+1));
//			}
//		}
//		
//		return sb.toString();
//	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PolyIRCGPackage.MEMORY_ACCESS_EXPRESSION__VARIABLE:
				if (resolve) return getVariable();
				return basicGetVariable();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PolyIRCGPackage.MEMORY_ACCESS_EXPRESSION__VARIABLE:
				setVariable((CodeGenVariable)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PolyIRCGPackage.MEMORY_ACCESS_EXPRESSION__VARIABLE:
				setVariable((CodeGenVariable)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PolyIRCGPackage.MEMORY_ACCESS_EXPRESSION__VARIABLE:
				return variable != null;
		}
		return super.eIsSet(featureID);
	}

} //MemoryAccessExpressionImpl
