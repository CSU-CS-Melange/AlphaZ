/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constant;
import static org.polymodel.algebra.factory.IntExpressionBuilder.constraint;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.polyIRCG.Statement;
import org.polymodel.polyhedralIR.polyIRCG.C.CLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.Buffer;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.BufferMapping;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.CDistributedPackage;
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.MPICLoop;
import org.polymodel.polyhedralIR.polyIRCG.C.impl.TiledCLoopImpl;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.MPI.BufferCopyStatementProvider;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.MPI.MPICUtility;
import org.polymodel.polyhedralIR.targetMapping.CommunicatedVariableForTiledSpace;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations;
import org.polymodel.scop.dtiler.DTilingOptions;
import org.polymodel.scop.dtiler.distributed.DTilerForMPICTileLoops;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MPIC Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.polyIRCG.C.distributed.impl.MPICLoopImpl#getBuffers <em>Buffers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MPICLoopImpl extends TiledCLoopImpl implements MPICLoop {
	/**
	 * The cached value of the '{@link #getBuffers() <em>Buffers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuffers()
	 * @generated
	 * @ordered
	 */
	protected EList<Buffer> buffers;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MPICLoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CDistributedPackage.Literals.MPIC_LOOP;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Buffer> getBuffers() {
		if (buffers == null) {
			buffers = new EObjectContainmentEList<Buffer>(Buffer.class, this, CDistributedPackage.MPIC_LOOP__BUFFERS);
		}
		return buffers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CLoop getSendBufferCopyLoop() {
		return createBufferCopyLoop(true);
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CLoop getReceiveBufferCopyLoop() {
		return createBufferCopyLoop(false);
	}

	private CLoop createBufferCopyLoop(boolean send) {
		List<Statement> stmts = new ArrayList<Statement>();
		TargetMapping tm = getFunction().getCodeunit().getSystem().getTargetMapping();
		SpaceTimeLevel stlevel = tm.getSpaceTimeLevel(0);
		int tileDims = stlevel.getNumberOfTiledDimensions();
		ParameterDomain paramDom = null;
		
		
		int count = 0;
		for (Buffer b : getBuffers()) {
			Domain transferContext = (send)?b.getSendDomain():b.getReceiveDomain();

			for (BufferMapping bm : b.getBufferMappings()) {
				count++;
				CommunicatedVariableForTiledSpace cv = bm.getCommunicatedVariable();
				
				
				//access to buffer is shifted by the tile origin, and also by tile size - communication depth if depth > 0
				AffineFunction bufferAccessFunction;
				{
					List<Variable> params = bm.getDomain().getParams();
					List<AffineExpression> exprs =  PolyhedralIRUtility.createIdentityFunction(bm.getDomain()).getExpressions();
					
					for (int d = 0; d < cv.getCommunicationDepths().size(); d++) {
						//offset by tile origin
						exprs.get(d).getTerms().add(IntExpressionBuilder.term(-1, MPICUtility.getTileIndexInBufferSpace(params, d, tileDims)));
						//depth
						if (cv.getCommunicationDepths().get(d) > 0) {
							//tile size
							exprs.get(d).getTerms().add(IntExpressionBuilder.term(-1, MPICUtility.getTileSizeInBufferSpace(params, d)));
							//depth
							exprs.get(d).getTerms().add(IntExpressionBuilder.term(cv.getCommunicationDepths().get(d)));
						}
					}
					
					//on the receiver end, also offset the access to buffer by tsd, since the scanning loop has been shifted in the last dimension
					if (!send) {
						Variable tid = MPICUtility.getTileIndexInBufferSpace(bm.getDomain(), tileDims-1, tileDims);
						Variable tsd = MPICUtility.getTileSizeInBufferSpace(bm.getDomain(), tileDims-1);
						IntExpression tid_plus_tsd = affine(term(tid), term(1, tsd));
						for (int i = 0; i < exprs.size(); i++) {
							exprs.set(i, exprs.get(i).substitute(tid, tid_plus_tsd).toAffine());
						}
					}
					
					bufferAccessFunction = PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(params, bm.getDomain().getIndices(), exprs);
				}
				
				//memory access from origIS
				AffineFunction valueAccessFunction = MPICUtility.getAccessFunctionForDistributedVariable(tm, cv.getVariable());
				
				// access to value in the receiver is shifted to [ti1-ts1,ti2,...,tid+tsd] 
				// since its value is the output of the previous tile in the first tile dimension, and the data is received for next wf time step
				// the actual shift below is only for ti1-ts1, since tid+tsd is already done by the scanning loop
				if (!send) {
					List<Variable> params = valueAccessFunction.getParams();
					List<Variable> indices = valueAccessFunction.getIndices();
					
					IntExpression ti1_minus_ts1 = affine(term(indices.get(0)), term(-1, MPICUtility.getTileSizeInOriginalSpace(params, 0, tileDims)));
					
					List<AffineExpression> aexprs = new ArrayList<AffineExpression>(valueAccessFunction.getDimRHS());
					for (IntExpression expr : valueAccessFunction.getPMmapping().getExpressions()) {
						expr = expr.substitute(indices.get(0), ti1_minus_ts1).toAffine();
						aexprs.add(expr.toAffine());
					}
					valueAccessFunction = PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(params, indices, aexprs);
				}
				
				
				Statement stmt;
				if (send) {
					Domain stmtDom = bm.getDomain().intersection(transferContext);
					stmt = PolyIRCGUserFactory.INSTANCE.createStatement("copy"+count, stmtDom, new BufferCopyStatementProvider(stlevel.getOrderingDimensions(), bufferAccessFunction, bm.getBufferAccess(), valueAccessFunction, bm.getValueAccess(), CodeGenConstantsForDistributed.sendBuffer));
				} else {
					Domain stmtDom = bm.getDomain();
					
					//replace the last tid with tidNext = tid + tsd
					Variable tid = MPICUtility.getTileIndexInBufferSpace(stmtDom, tileDims-1, tileDims);
					IntExpression tid_plus_tsd = affine(term(tid), term(MPICUtility.getTileSizeInBufferSpace(stmtDom, tileDims-1)));
					
					stmtDom = DomainOperations.substitute(stmtDom, tid, tid_plus_tsd);
					stmtDom = stmtDom.intersection(transferContext);
					stmt = PolyIRCGUserFactory.INSTANCE.createStatement("copy"+count, stmtDom, new BufferCopyStatementProvider(stlevel.getOrderingDimensions(), valueAccessFunction, bm.getValueAccess(), bufferAccessFunction, bm.getBufferAccess(), CodeGenConstantsForDistributed.recvBuffer));
				}
				stmt.setInlined(true);
				stmts.add(stmt);
				//create universe parameter domain
				if (paramDom == null) {
					paramDom = PolyhedralIRUtility.createUniverseDomain(bm.getDomain().getParams(), new ArrayList<Variable>()).toParameterDomain();
					//assert tile sizes are positive
					for (int i = 0; i < tileDims; i++) {
						paramDom.getPMdomain().addConstraint(
								constraint(affine(term(MPICUtility.getTileSizeInBufferSpace(paramDom, i))), constant(0), ComparisonOperator.GT));
					}
				}
			}
		}

		//create universe parameter domain
		if (paramDom == null) {
			paramDom = tm.getContainerSystem().getParameters().copy().toParameterDomain();
			//assert tile sizes are positive
			for (int i = 0; i < tileDims; i++) {
				paramDom.getPMdomain().addConstraint(
						constraint(affine(term(MPICUtility.getTileSizeInBufferSpace(paramDom, i))), constant(0), ComparisonOperator.GT));
			}
		}

		CLoop loop = PolyIRCGUserFactory.INSTANCE.createCLoop(paramDom, 0);
		loop.setDeclareIterators(false);
		loop.getStatements().addAll(stmts);
		
		return loop;
	}
	
	@Override
	public DTiledLoop generateDTiledLoop() {
		DTiledLoop res = super.generateDTiledLoop();
		
		//add iterator names that may be needed for buffer copies (when statement ordering dimensions are involved)
		for (int i = 1; i <= getMaxDimension() - getNumConstantDimensions(); i++) {
			getIteratorNames().add("c"+i);
		}
		
		return res;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CDistributedPackage.MPIC_LOOP__BUFFERS:
				return ((InternalEList<?>)getBuffers()).basicRemove(otherEnd, msgs);
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
			case CDistributedPackage.MPIC_LOOP__BUFFERS:
				return getBuffers();
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
			case CDistributedPackage.MPIC_LOOP__BUFFERS:
				getBuffers().clear();
				getBuffers().addAll((Collection<? extends Buffer>)newValue);
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
			case CDistributedPackage.MPIC_LOOP__BUFFERS:
				getBuffers().clear();
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
			case CDistributedPackage.MPIC_LOOP__BUFFERS:
				return buffers != null && !buffers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	protected DTilingOptions initializeDTilingOptions() {
		DTilingOptions options = super.initializeDTilingOptions();
		options.tileLoopGenerator = new DTilerForMPICTileLoops(options);
		return options;
	}
	

} //MPICLoopImpl
