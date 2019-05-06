/**
 */
package org.polymodel.polyhedralIR.impl;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.polymodel.DimensionsManager;
import org.polymodel.DomainDimensions;
import org.polymodel.Function;
import org.polymodel.Label;
import org.polymodel.OutputDimension;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.isl.factory.ISLNativeBinder;
import org.polymodel.matrix.Matrix;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.FastISLMap;
import org.polymodel.polyhedralIR.PolyhedralIRPackage;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLConstraint;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLDimType;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMatrix;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fast ISL Map</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.impl.FastISLMapImpl#getIslMap <em>Isl Map</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.FastISLMapImpl#getDomDims <em>Dom Dims</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.FastISLMapImpl#getLabelIn <em>Label In</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.FastISLMapImpl#getLabelOut <em>Label Out</em>}</li>
 * </ul>
 * </p>
 *
 * @generated NOT
 */
public class FastISLMapImpl extends AffineFunctionImpl implements FastISLMap {
	
	private static final DimensionsManager _dimMana = PolymodelComponent.INSTANCE.getDefaultDimensionsManager();
	
	
	/**
	 * The default value of the '{@link #getIslMap() <em>Isl Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIslMap()
	 * @generated NOT
	 * @ordered
	 */
	protected static final JNIISLBasicMap ISL_MAP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIslMap() <em>Isl Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIslMap()
	 * @generated NOT
	 * @ordered
	 */
	protected JNIISLBasicMap islMap = ISL_MAP_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDomDims() <em>Dom Dims</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomDims()
	 * @generated
	 * @ordered
	 */
	protected DomainDimensions domDims;

	/**
	 * The cached value of the '{@link #getLabelIn() <em>Label In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabelIn()
	 * @generated
	 * @ordered
	 */
	protected Label labelIn;

	/**
	 * The cached value of the '{@link #getLabelOut() <em>Label Out</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabelOut()
	 * @generated
	 * @ordered
	 */
	protected Label labelOut;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FastISLMapImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyhedralIRPackage.eINSTANCE.getFastISLMap();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JNIISLBasicMap getIslMap() {
		return islMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIslMap(JNIISLBasicMap newIslMap) {
		JNIISLBasicMap oldIslMap = islMap;
		islMap = newIslMap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.FAST_ISL_MAP__ISL_MAP, oldIslMap, islMap));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainDimensions getDomDims() {
		if (domDims != null && domDims.eIsProxy()) {
			InternalEObject oldDomDims = (InternalEObject)domDims;
			domDims = (DomainDimensions)eResolveProxy(oldDomDims);
			if (domDims != oldDomDims) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PolyhedralIRPackage.FAST_ISL_MAP__DOM_DIMS, oldDomDims, domDims));
			}
		}
		return domDims;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainDimensions basicGetDomDims() {
		return domDims;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomDims(DomainDimensions newDomDims) {
		DomainDimensions oldDomDims = domDims;
		domDims = newDomDims;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.FAST_ISL_MAP__DOM_DIMS, oldDomDims, domDims));
	}
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Label getLabelIn() {
		if (labelIn != null && labelIn.eIsProxy()) {
			InternalEObject oldLabelIn = (InternalEObject)labelIn;
			labelIn = (Label)eResolveProxy(oldLabelIn);
			if (labelIn != oldLabelIn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PolyhedralIRPackage.FAST_ISL_MAP__LABEL_IN, oldLabelIn, labelIn));
			}
		}
		return labelIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Label basicGetLabelIn() {
		return labelIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabelIn(Label newLabelIn) {
		Label oldLabelIn = labelIn;
		labelIn = newLabelIn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.FAST_ISL_MAP__LABEL_IN, oldLabelIn, labelIn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Label getLabelOut() {
		if (labelOut != null && labelOut.eIsProxy()) {
			InternalEObject oldLabelOut = (InternalEObject)labelOut;
			labelOut = (Label)eResolveProxy(oldLabelOut);
			if (labelOut != oldLabelOut) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PolyhedralIRPackage.FAST_ISL_MAP__LABEL_OUT, oldLabelOut, labelOut));
			}
		}
		return labelOut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Label basicGetLabelOut() {
		return labelOut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabelOut(Label newLabelOut) {
		Label oldLabelOut = labelOut;
		labelOut = newLabelOut;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.FAST_ISL_MAP__LABEL_OUT, oldLabelOut, labelOut));
	}

	// --------------------------------------------------------------------------------
	
	@Override
	public boolean equivalence(AffineFunction func) {
		if (!(func instanceof FastISLMap))
			return super.equivalence(func);
		
		FastISLMap fmap = (FastISLMap) func;
		
		JNIISLBasicMap islMap1 = this.getIslMap();
		JNIISLBasicMap islMap2 = fmap.getIslMap();
		
		return islMap1.isEqual(islMap2);
	}
	
	@Override
	public AffineFunction compose(AffineFunction func2) {
		if (!(func2 instanceof FastISLMap))
			return super.compose(func2);
		
		FastISLMap fmap2 = (FastISLMap) func2;
		
		JNIISLBasicMap islMap1 = this.getIslMap().copy();
		JNIISLBasicMap islMap2 = fmap2.getIslMap().copy();
		
		JNIISLBasicMap islMapResult = islMap2.applyRange(islMap1);
		
		FastISLMap funcResult = PolyhedralIRUserFactory.eINSTANCE.createFastISLMap(fmap2.getDomDims(), islMapResult, labelIn, labelOut);
		return funcResult;
	}
	
	@Override
	public AffineFunction copy() {
		FastISLMap funcResult = PolyhedralIRUserFactory.eINSTANCE.createFastISLMap(this.domDims, this.islMap.copy(), this.labelIn, this.labelOut);
		
		return funcResult;
	}
	
	@Override
	public AffineFunction inverse(EList<String> lStr) {
		assert(lStr.size()==this.getDimRHS());
		
		JNIISLBasicMap map = islMap.copy();
		
		JNIISLBasicMap invMap = map.reverse();
		
		List<Variable> lInds = new BasicEList<Variable>();
		for (int i=0; i<invMap.getNbDims(JNIISLDimType.isl_dim_out); i++)
			lInds.add(_dimMana.getDimension(i, lStr.get(i)));
		
		DomainDimensions nDomDims = PolyhedralIRUserFactory._polyFact.createDomainDimensions(lInds, this.domDims.getParameters());
		FastISLMap fFuncRes = PolyhedralIRUserFactory.eINSTANCE.createFastISLMap(nDomDims, invMap, this.labelOut, this.labelIn);
		// TODO: not sure about labels... :/
		
		return fFuncRes;
	}
	
	@Override
	public AffineFunction inverseInContext(Domain context, EList<String> lStr) {
		return super.inverseInContext(context, lStr);
		// TODO: current implementation involves polymodel matrices (thus PMDomain) / improvement possible to get ISL matrices instead
	}
	
	
	@Override
	public boolean isUniform() {
		// TODO: currently implemented by looking at terms. Can probably be improved by using ISL matrices
		return super.isUniform();
	}
	
	@Override
	public boolean isBijective() {
		JNIISLBasicMap bmap = this.islMap.copy();
		return bmap.toMap().isBijective();
	}
	
	@Override
	public boolean isIdentity() {
		// Note: will ignore the other constraints on the input/output domains, and will check that the function
		//		value is ID on these domains
		if (this.getIslMap().getNbDims(JNIISLDimType.isl_dim_in)!=this.getIslMap().getNbDims(JNIISLDimType.isl_dim_out))
			return false;
		JNIISLBasicMap idMap = JNIISLBasicMap.buildIdentity(this.getIslMap().getSpace());
		return this.getIslMap().copy().isSubset(idMap);
	}
	
	@Override
	public EList<Variable> getParams() {
		return this.domDims.getParameters();
	}
	
	@Override
	public EList<Variable> getIndices() {
		return this.domDims.getIndices();
	}
	
	@Override
	public void addDimension(String varName) {
		JNIISLBasicMap bmap =  this.islMap.copy();
		JNIISLMap map = bmap.toMap().addDims(JNIISLDimType.isl_dim_in, 1);
		map = map.setDimName(JNIISLDimType.isl_dim_in, map.getNbDims(JNIISLDimType.isl_dim_in)-1, varName);
		JNIISLBasicMap nbmap = map.getBasicMaps().get(0);
		
		List<Variable> nlVars = new BasicEList<Variable>();
		nlVars.addAll(this.domDims.getIndices());
		nlVars.add(PolymodelComponent.INSTANCE.getDefaultDimensionsManager().getDimension(this.domDims.getIndices().size(), varName));
		DomainDimensions nDomDims = PolyhedralIRUserFactory._polyFact.createDomainDimensions(nlVars, this.domDims.getParameters());
		
		// Propagating the changes
		setDomDims(nDomDims);
		setIslMap(nbmap);
	}
	
	@Override
	public void addParameterDimension(String paramName) {
		JNIISLBasicMap bmap =  this.islMap.copy();
		JNIISLMap map = bmap.toMap().addDims(JNIISLDimType.isl_dim_param, 1);
		map = map.setDimName(JNIISLDimType.isl_dim_param, map.getNbDims(JNIISLDimType.isl_dim_param)-1, paramName);
		JNIISLBasicMap nbmap = map.getBasicMaps().get(0);
		
		List<Variable> nlParams = new BasicEList<Variable>();
		nlParams.addAll(this.domDims.getParameters());
		nlParams.add(PolymodelComponent.INSTANCE.getDefaultDimensionsManager().getParameter(this.domDims.getParameters().size(), paramName));
		DomainDimensions nDomDims = PolyhedralIRUserFactory._polyFact.createDomainDimensions(this.domDims.getIndices(), nlParams);
		
		// Propagating the changes
		setDomDims(nDomDims);
		setIslMap(nbmap);
	}
	
	@Override
	public EList<AffineExpression> getExpressions() {
		return super.getExpressions();			// Need to build the PMmapping on this one => no choice... :/
	}
	
	
	@Override
	public int getDimLHS() {
		return this.getNParams() + this.getNIndices();
	}
	
	@Override
	public int getDimRHS() {
		return this.islMap.getNbDims(JNIISLDimType.isl_dim_out);
	}
	
	@Override
	public int getNParams() {
		return this.islMap.getNbDims(JNIISLDimType.isl_dim_param);
	}
	
	@Override
	public int getNIndices() {
		return this.islMap.getNbDims(JNIISLDimType.isl_dim_in);
	}
	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Matrix toMatrix() {
		if (islMap.getNbDims(JNIISLDimType.isl_dim_div)!=0)
			throw new RuntimeException("Existential variables in the mapping");
		
		JNIISLMatrix matEq = this.islMap.getEqualityMatrix(JNIISLDimType.isl_dim_param, JNIISLDimType.isl_dim_in, JNIISLDimType.isl_dim_cst,
				JNIISLDimType.isl_dim_div, JNIISLDimType.isl_dim_out);
		
		// We ignore the inequalities (no inequalities with our usage of AffineFunction)
		int nRows = matEq.getNbRows();
		
		if (nRows!=this.islMap.getNbDims(JNIISLDimType.isl_dim_out))
			throw new RuntimeException("Number of rows does not match the number of output dimensions");
		
		// ASSUMPTION: the submatrix under isl_dim_out is the horizontal symmetry of Id
		int nColsMatRet = matEq.getNbCols()-nRows;
		Matrix matRet = PolymodelComponent.INSTANCE.getFactory().createMatrix(nRows, nColsMatRet);
		
		for (int i=0; i<nRows; i++) {
			// Copy the matrix in inverse order (minus because this is an equality)
			for (int j=0; j<nColsMatRet; j++)
				matRet.set(nRows-1-i, j, -matEq.getElement(i, j));
			
			// Check the assumption on the last column
			for (int j=0; j<nRows; j++)
				if (j==i) {
					if (matEq.getElement(nRows-1-i,nColsMatRet+j)!=1)
						throw new RuntimeException("Error: assumption on matEq is wrong for the " + (nRows-i) + " th row of the anti-diagonal part");
				} else {
					if (matEq.getElement(nRows-1-i, nColsMatRet+j)!=0)
						throw new RuntimeException("Error: the matrix matEq do not have a diagonal component at its end");
				}
		}
		
		return matRet;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public long[][] toLongMatrix() {
		if (islMap.getNbDims(JNIISLDimType.isl_dim_div)!=0)
			throw new RuntimeException("Existential variables in the mapping");
		
		JNIISLMatrix matEq = this.islMap.getEqualityMatrix(JNIISLDimType.isl_dim_param, JNIISLDimType.isl_dim_in, JNIISLDimType.isl_dim_cst,
				JNIISLDimType.isl_dim_div, JNIISLDimType.isl_dim_out);
		
		// We ignore the inequalities (no inequalities with our usage of AffineFunction)
		int nRows = matEq.getNbRows();
		
		if (nRows!=this.islMap.getNbDims(JNIISLDimType.isl_dim_out))
			throw new RuntimeException("Number of rows does not match the number of output dimensions");
		
		// ASSUMPTION: the submatrix under isl_dim_out is the horizontal symmetry of Id
		int nColsMatRet = matEq.getNbCols()-nRows;
		long[][] matRet = new long[nRows][nColsMatRet];
		
		for (int i=0; i<nRows; i++) {
			// Copy the matrix in inverse order (minus because this is an equality)
			for (int j=0; j<nColsMatRet; j++)
				matRet[nRows-1-i][j] = -matEq.getElement(i, j);
			
			// Check the assumption on the last column
			for (int j=0; j<nRows; j++)
				if (j==i) {
					if (matEq.getElement(nRows-1-i,nColsMatRet+j)!=1)
						throw new RuntimeException("Error: assumption on matEq is wrong for the " + (nRows-i) + " th row of the anti-diagonal part");
				} else {
					if (matEq.getElement(nRows-1-i, nColsMatRet+j)!=0)
						throw new RuntimeException("Error: the matrix matEq do not have a diagonal component at its end");
				}
		}
		
		return matRet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}
	
	@Override
	public Function getPMmapping() {
		List<OutputDimension> outputs = new BasicEList<OutputDimension>();
		int nbOut = islMap.getNbDims(JNIISLDimType.isl_dim_out);
		for (int i=0; i<nbOut; i++)
			outputs.add(_dimMana.getOutputDimension(_dimMana.getDimension(i)));
		
		String in = null;
		if (labelIn != null)
			in = this.labelIn.getName();
		String out = null;
		if (this.labelOut != null)
			in = this.labelOut.getName();
		
		// We remove the validity domain of islMap
		JNIISLBasicMap islbMap = this.islMap.copy();
		
		JNIISLBasicMap nIslbMap = JNIISLBasicMap.buildUniverse(islbMap.getSpace());
		for (int k=0; k<islbMap.getNumberOfConstraints(); k++) {
			JNIISLConstraint constr = islbMap.getConstraints().get(k);
			if (constr.isEquality() && constr.involvesDims(JNIISLDimType.isl_dim_out, 0, constr.getNbDims(JNIISLDimType.isl_dim_out)))
				nIslbMap = nIslbMap.addConstraint(constr);
		}
		
		// TODO: note: this is not perfect (might remove too much, ie if o1=i1, i1=i2 and o2=i2, removing i1=i2 delete informations)
		
		Function res = ISLNativeBinder.islFunction(nIslbMap.toMap(), this.domDims.getIndices(), outputs, this.domDims.getParameters(),
				in, out);
		return res;
		
	}
	
	// --------------------------------------------------------------------------------
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitFastISLMap(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PolyhedralIRPackage.FAST_ISL_MAP__ISL_MAP:
				return getIslMap();
			case PolyhedralIRPackage.FAST_ISL_MAP__DOM_DIMS:
				if (resolve) return getDomDims();
				return basicGetDomDims();
			case PolyhedralIRPackage.FAST_ISL_MAP__LABEL_IN:
				if (resolve) return getLabelIn();
				return basicGetLabelIn();
			case PolyhedralIRPackage.FAST_ISL_MAP__LABEL_OUT:
				if (resolve) return getLabelOut();
				return basicGetLabelOut();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PolyhedralIRPackage.FAST_ISL_MAP__ISL_MAP:
				setIslMap((JNIISLBasicMap)newValue);
				return;
			case PolyhedralIRPackage.FAST_ISL_MAP__DOM_DIMS:
				setDomDims((DomainDimensions)newValue);
				return;
			case PolyhedralIRPackage.FAST_ISL_MAP__LABEL_IN:
				setLabelIn((Label)newValue);
				return;
			case PolyhedralIRPackage.FAST_ISL_MAP__LABEL_OUT:
				setLabelOut((Label)newValue);
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
			case PolyhedralIRPackage.FAST_ISL_MAP__ISL_MAP:
				setIslMap(ISL_MAP_EDEFAULT);
				return;
			case PolyhedralIRPackage.FAST_ISL_MAP__DOM_DIMS:
				setDomDims((DomainDimensions)null);
				return;
			case PolyhedralIRPackage.FAST_ISL_MAP__LABEL_IN:
				setLabelIn((Label)null);
				return;
			case PolyhedralIRPackage.FAST_ISL_MAP__LABEL_OUT:
				setLabelOut((Label)null);
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
			case PolyhedralIRPackage.FAST_ISL_MAP__ISL_MAP:
				return ISL_MAP_EDEFAULT == null ? islMap != null : !ISL_MAP_EDEFAULT.equals(islMap);
			case PolyhedralIRPackage.FAST_ISL_MAP__DOM_DIMS:
				return domDims != null;
			case PolyhedralIRPackage.FAST_ISL_MAP__LABEL_IN:
				return labelIn != null;
			case PolyhedralIRPackage.FAST_ISL_MAP__LABEL_OUT:
				return labelOut != null;
		}
		return super.eIsSet(featureID);
	}

	

} //FastISLMapImpl
