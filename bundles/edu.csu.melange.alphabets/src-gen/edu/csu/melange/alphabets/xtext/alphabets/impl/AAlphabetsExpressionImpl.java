/**
 */
package edu.csu.melange.alphabets.xtext.alphabets.impl;

import edu.csu.melange.alphabets.xtext.alphabets.AAlphabetsExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage;

import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsVisitor;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AAlphabets Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class AAlphabetsExpressionImpl extends MinimalEObjectImpl.Container implements AAlphabetsExpression
{
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected AAlphabetsExpressionImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass()
  {
		return AlphabetsPackage.Literals.AALPHABETS_EXPRESSION;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final AlphabetsVisitor visitor) {
		visitor.visitAAlphabetsExpression(this);
	}

} //AAlphabetsExpressionImpl
