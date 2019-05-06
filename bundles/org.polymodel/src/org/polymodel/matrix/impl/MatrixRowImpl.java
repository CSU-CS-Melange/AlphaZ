/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.matrix.impl;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraint;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.matrix.MatrixPackage;
import org.polymodel.matrix.MatrixRow;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Row</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.matrix.impl.MatrixRowImpl#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MatrixRowImpl extends EObjectImpl implements MatrixRow {
	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList<Long> values;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MatrixRowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MatrixPackage.Literals.MATRIX_ROW;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Long> getValues() {
		if (values == null) {
			values = new EDataTypeEList<Long>(Long.class, this,
					MatrixPackage.MATRIX_ROW__VALUES);
		}
		return values;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public int getSize() {
		return getValues().size();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public IntConstraint toConstraint(EList<Variable> variables) {
		AffineTerm terms[] = new AffineTerm[variables.size() + 1];
		for (int i = 1; i < values.size() - 1; ++i) {
			long value = values.get(i);
			if (value != 0) {
				terms[i - 1] = term(value, variables.get(i - 1));

			}
		}
		long value = values.get(values.size() - 1);
		if (value != 0) {
			terms[variables.size()] = term(value);
		}

		AffineExpression expression = affine(terms);
		boolean isineq = true;

		if (values.get(0) == 0) {
			// Equality
			isineq = false;
		} else {
			isineq = true;
		}

		return constraint(expression, affine(term(0)),
				isineq ? ComparisonOperator.GE : ComparisonOperator.EQ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public long get(int col) {
		return values.get(col);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void set(int col, long value) {
		values.set(col, value);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MatrixPackage.MATRIX_ROW__VALUES:
				return getValues();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MatrixPackage.MATRIX_ROW__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends Long>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MatrixPackage.MATRIX_ROW__VALUES:
				getValues().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MatrixPackage.MATRIX_ROW__VALUES:
				return values != null && !values.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MatrixPackage.MATRIX_ROW___GET_SIZE:
				return getSize();
			case MatrixPackage.MATRIX_ROW___TO_CONSTRAINT__ELIST:
				return toConstraint((EList<Variable>)arguments.get(0));
			case MatrixPackage.MATRIX_ROW___GET__INT:
				return get((Integer)arguments.get(0));
			case MatrixPackage.MATRIX_ROW___SET__INT_LONG:
				set((Integer)arguments.get(0), (Long)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer();
		if (getSize() > 0) {
			for (int i = 0; i < getSize() - 1; i++) {
				result.append(getValues().get(i)).append("\t");
			}
			result.append(getValues().get(getSize() - 1));
		}

		return result.toString();
	}
	
	public IntConstraint toConstraint(List<Variable> params, List<Variable> indices) {

		AffineExpression expr = IntExpressionBuilder.affine();
		for (int i = 1; i < getSize() - 1; i++) {
			if (i - 1 < params.size()) {
				expr.getTerms().add(IntExpressionBuilder.term(get(i), params.get(i - 1)));
			} else {
				expr.getTerms().add(IntExpressionBuilder.term(get(i), indices.get(i - 1 - params.size())));
			}
		}
		// constant
		expr.getTerms().add(IntExpressionBuilder.term(get(getSize() - 1)));

		// polylib format
		ComparisonOperator op = ComparisonOperator.GE;
		if (get(0) == 0)
			op = ComparisonOperator.EQ;

		return IntExpressionBuilder.constraint(expr, affine(term(0)), op);
	} 

} // MatrixRowImpl
