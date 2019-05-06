/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.Body;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.Buffer;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.MPI.MPICUtility;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Buffer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.BufferImpl#getBufferMappings <em>Buffer Mappings</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.BufferImpl#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BufferImpl extends EObjectImpl implements Buffer {
	/**
	 * The cached value of the '{@link #getBufferMappings() <em>Buffer Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBufferMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<BufferMapping> bufferMappings;

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
	protected BufferImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CDistributedPackage.Literals.BUFFER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BufferMapping> getBufferMappings() {
		if (bufferMappings == null) {
			bufferMappings = new EObjectContainmentEList<BufferMapping>(BufferMapping.class, this, CDistributedPackage.BUFFER__BUFFER_MAPPINGS);
		}
		return bufferMappings;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CDistributedPackage.BUFFER__VARIABLE, oldVariable, variable));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CDistributedPackage.BUFFER__VARIABLE, oldVariable, variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IntExpression computeBufferSize() {
		return getVariable().getVolumeExpression(1, getVariable().getDomain().getNIndices());
	}

	
	/**
	 * Creates the domain when send/recv should occur.
	 * Corresponds to "isSenderInOutSet" and "isReceiverInOutSet" tests in the algorithm.
	 *  
	 *  receiver = [ti1, ti2, ..., tid]
	 *  sender = [ti1-ts1, ti2, ..., tid]
	 * 
	 * @param send
	 * @return
	 */
	private Domain createTransferDomain(boolean send) {

		Domain dom = null;
		TargetMapping tm = ((Body)eContainer()).getFunction().getCodeunit().getSystem().getTargetMapping();
		SpaceTimeLevel stlevel = tm.getSpaceTimeLevel(0);
		int tileDims = stlevel.getNumberOfTiledDimensions();
		List<Variable> BSparams = null;
				
		for (BufferMapping bm : getBufferMappings()) {
			if (dom == null) {
				dom = bm.getCommunicatedVariable().getVariable().getDomain().copy();
				BSparams = bm.getDomain().getParams();
			} else {
				dom = dom.union(bm.getCommunicatedVariable().getVariable().getDomain());
			}
		}
		
		dom = DomainOperations.removeOrderingDimensions(dom, stlevel.getOrderingDimensions());
		
		//convert to buffer space
		dom = MPICUtility.convertFromOStoBS(dom, dom.getParams(), BSparams, tileDims);

		List<Variable> tileSizes = MPICUtility.getTileSizesInBufferSapce(dom.getParams(), tileDims);
		//construct outset
		dom = MPICUtility.constructOutSetDomain(dom, tileSizes);
		
		//substitute constraints on indices with tile indices
		List<Variable> tileIndices = MPICUtility.getTileIndicesInBufferSapce(dom.getParams(), tileDims);
		{
			List<IntConstraintSystem> newPoly = new ArrayList<IntConstraintSystem>(dom.getPMdomain().getPolyhedra().size());
			
			for (IntConstraintSystem poly : dom.getPMdomain().getPolyhedra()) {
				for (int i = 0; i < dom.getNIndices(); i++) {
					poly = poly.substitute(dom.getIndices().get(i), tileIndices.get(i));
				}
				newPoly.add(poly);
			}
			
			
			dom = PolyhedralIRUserFactory.eINSTANCE.createDomain(dom.getParams(), dom.getIndices(), newPoly);
		}

		if (!send) {
			Variable ti1 = MPICUtility.getTileIndexInBufferSpace(dom, 0, tileDims);
			//use ti - ts for the first dimension of the receiver
			IntExpression ti1_minus_ts1 = affine(term( ti1 ), 
												term(-1, MPICUtility.getTileSizeInBufferSpace(dom, 0)));
			
			//also replace the last tid with tidNext = tid + tsd
			Variable tid = MPICUtility.getTileIndexInBufferSpace(dom, tileDims-1, tileDims);
			IntExpression tid_plus_tsd = affine(term(tid), term(MPICUtility.getTileSizeInBufferSpace(dom, tileDims-1)));
			
			List<IntConstraintSystem> polyhedra = new ArrayList<IntConstraintSystem>(dom.getPMdomain().getPolyhedra().size());
			
			for (IntConstraintSystem poly : dom.getPMdomain().getPolyhedra()) {
				poly = poly.substitute(ti1, ti1_minus_ts1);
				poly = poly.substitute(tid, tid_plus_tsd);
				polyhedra.add(poly);
			}
			dom = PolyhedralIRUserFactory.eINSTANCE.createDomain(dom.getParams(), dom.getIndices(), polyhedra);
		}
		return dom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Domain getSendDomain() {
		Domain sender = createTransferDomain(true);
		
		return sender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Domain getReceiveDomain() {
		Domain recv = createTransferDomain(false);
		
		recv.simplify();
		
		return recv;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CDistributedPackage.BUFFER__BUFFER_MAPPINGS:
				return ((InternalEList<?>)getBufferMappings()).basicRemove(otherEnd, msgs);
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
			case CDistributedPackage.BUFFER__BUFFER_MAPPINGS:
				return getBufferMappings();
			case CDistributedPackage.BUFFER__VARIABLE:
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CDistributedPackage.BUFFER__BUFFER_MAPPINGS:
				getBufferMappings().clear();
				getBufferMappings().addAll((Collection<? extends BufferMapping>)newValue);
				return;
			case CDistributedPackage.BUFFER__VARIABLE:
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
			case CDistributedPackage.BUFFER__BUFFER_MAPPINGS:
				getBufferMappings().clear();
				return;
			case CDistributedPackage.BUFFER__VARIABLE:
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
			case CDistributedPackage.BUFFER__BUFFER_MAPPINGS:
				return bufferMappings != null && !bufferMappings.isEmpty();
			case CDistributedPackage.BUFFER__VARIABLE:
				return variable != null;
		}
		return super.eIsSet(featureID);
	}

} //BufferImpl
