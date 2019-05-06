/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.algebra.Variable;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.AbstractScopStatement;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopPackage;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopVisitor;
import org.polymodel.scop.util.ScopSimplify;

import fr.irisa.cairn.tools.ecore.query.EMFUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.scop.impl.ScopRootImpl#getStatements <em>Statements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScopRootImpl extends EObjectImpl implements ScopRoot {
	/**
	 * The cached value of the '{@link #getStatements() <em>Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractScopNode> statements;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScopRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScopPackage.Literals.SCOP_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractScopNode> getStatements() {
		if (statements == null) {
			statements = new EObjectContainmentEList<AbstractScopNode>(AbstractScopNode.class, this, ScopPackage.SCOP_ROOT__STATEMENTS);
		}
		return statements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ScopRoot simplify() {
		return ScopSimplify.simplify(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final ScopVisitor visitor) {
		visitor.visitScopRoot(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ScopPackage.SCOP_ROOT__STATEMENTS:
				return ((InternalEList<?>)getStatements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScopPackage.SCOP_ROOT__STATEMENTS:
				return getStatements();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ScopPackage.SCOP_ROOT__STATEMENTS:
				getStatements().clear();
				getStatements().addAll((Collection<? extends AbstractScopNode>)newValue);
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
			case ScopPackage.SCOP_ROOT__STATEMENTS:
				getStatements().clear();
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
			case ScopPackage.SCOP_ROOT__STATEMENTS:
				return statements != null && !statements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ScopPackage.SCOP_ROOT___SIMPLIFY:
				return simplify();
			case ScopPackage.SCOP_ROOT___ACCEPT__SCOPVISITOR:
				accept((ScopVisitor)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	public EList<? extends AbstractScopStatement> getAllStatements() {
		EList<AbstractScopStatement> instrs = EMFUtils.<AbstractScopStatement>eAllContentsInstancesOf(this, AbstractScopStatement.class);
		return instrs;
	}

	public EList<? extends Variable> getAllParameters() {
		EList<? extends Variable> vars = EMFUtils.<Variable>getAllReferencesOfType(this, Variable.class);
		vars.removeAll(getAllIterators());
		return vars;
	}

	public EList<? extends Variable> getAllIterators() {
		EList<Variable> res = new BasicEList<Variable>();
		EList<ScopFor> fors= EMFUtils.<ScopFor>eAllContentsInstancesOf(this, ScopFor.class);
		for (ScopFor gScopFor : fors) {
			res.add((Variable) gScopFor.getIterator());
		}
		return res;
	}

} //ScopRootImpl
