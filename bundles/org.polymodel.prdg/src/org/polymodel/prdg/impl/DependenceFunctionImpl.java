/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.prdg.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.polymodel.prdg.DependenceFunction;
import org.polymodel.prdg.PrdgPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Dependence Function</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DependenceFunctionImpl extends EdgeFunctionImpl implements
		DependenceFunction {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DependenceFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PrdgPackage.Literals.DEPENDENCE_FUNCTION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isUniform() {
		throw new UnsupportedOperationException();
//		Matrix matrix = mapping.toMatrix();
//		if(matrix.getNbRows()!=mapping.getIndices().size())
//			return false;
//		int lastParameter = mapping.getParams().size();
//		for (int row = 0; row < matrix.getNbRows(); ++row) {
//			int diagonal = lastParameter+row;
//			for (int col = lastParameter; col < matrix.getNbCols() - 1; ++col) {
//				long value = matrix.get(row,col); 
//				if(col==diagonal){
//					if(value!=1)
//						return false;
//				}else{
//					if(value!=0)
//						return false;
//				}
//				
//			}
//		}
//		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case PrdgPackage.DEPENDENCE_FUNCTION___IS_UNIFORM:
				return isUniform();
		}
		return super.eInvoke(operationID, arguments);
	}

} // DependenceFunctionImpl
