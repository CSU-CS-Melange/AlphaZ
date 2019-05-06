/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.DimensionsManager;
import org.polymodel.Domain;
import org.polymodel.DomainDimensions;
import org.polymodel.Function;
import org.polymodel.IndexDimension;
import org.polymodel.Label;
import org.polymodel.OutputDimension;
import org.polymodel.PolymodelPackage;
import org.polymodel.PolymodelVisitor;
import org.polymodel.Relation;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.matrix.Matrix;
import org.polymodel.matrix.MatrixRow;
import org.polymodel.matrix.impl.MatrixOperations;
import org.polymodel.matrix.impl.PolymodelMatrixOperation;
import org.polymodel.prettyprinters.PolymodelPrettyPrinter;


/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Function</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.impl.FunctionImpl#getExpressionsMap <em>Expressions Map</em>}</li>
 *   <li>{@link org.polymodel.impl.FunctionImpl#getDimensions <em>Dimensions</em>}</li>
 *   <li>{@link org.polymodel.impl.FunctionImpl#getIn <em>In</em>}</li>
 *   <li>{@link org.polymodel.impl.FunctionImpl#getOut <em>Out</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionImpl extends EObjectImpl implements Function {

	private PolymodelDefaultFactory factory;
	
	
	public PolymodelDefaultFactory getFactory() {
		return factory;
	}

	public void setFactory(PolymodelDefaultFactory factory) {
		this.factory = factory;
	}
	
	/**
	 * The cached value of the '{@link #getExpressionsMap() <em>Expressions Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionsMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<OutputDimension, IntExpression> expressionsMap;
	/**
	 * The cached value of the '{@link #getDimensions() <em>Dimensions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDimensions()
	 * @generated
	 * @ordered
	 */
	protected DomainDimensions dimensions;
	/**
	 * The cached value of the '{@link #getIn() <em>In</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIn()
	 * @generated
	 * @ordered
	 */
	protected Label in;
	/**
	 * The cached value of the '{@link #getOut() <em>Out</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOut()
	 * @generated
	 * @ordered
	 */
	protected Label out;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolymodelPackage.Literals.FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<OutputDimension, IntExpression> getExpressionsMap() {
		if (expressionsMap == null) {
			expressionsMap = new EcoreEMap<OutputDimension,IntExpression>(PolymodelPackage.Literals.VALUE_CONTAINED_MAP, ValueContainedMapImpl.class, this, PolymodelPackage.FUNCTION__EXPRESSIONS_MAP);
		}
		return expressionsMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns list of copies of the expressions involved in the function.
	 * <!-- end-user-doc -->
	 * @generated Not
	 */
	public EList<IntExpression> getExpressions() {
		EList<IntExpression> res = new BasicEList<IntExpression>(this.getExpressionsMap().size());
		for (Entry<OutputDimension, IntExpression> e : this.getExpressionsMap()) {
			res.add(e.getValue().copy());
		}
		return res;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public <T extends Relation> T buildRelation(DimensionsManager manager) {
		return getFactory().createRelation(manager, this);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean equivalence(Function func) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends Function> T compose(Function func) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public <T extends Function> T inverse(DimensionsManager manager) {
		return inverse(manager, null);
	}
	
	public <T extends Function> T inverse(DimensionsManager manager, EList<String> names) {
		return inverseInContext(manager, null, names);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public <T extends Function> T inverseInContext(DimensionsManager manager, Domain context) {
		return inverseInContext(manager, context, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Matrix toMatrix() {
		final int nbParam = getDimensions().getParameters().size();
		final int nbIndices = getDimensions().getIndices().size();

		Matrix mat = getFactory().createMatrix(getExpressions().size(), nbParam+nbIndices+1);
		
		for (int r = 0; r < getExpressions().size(); r++) {
			//Only handles affine
			AffineExpression expr = (AffineExpression) getExpression(r).toAffine().simplify();
			
			//parameters come first
			for (int pi = 0; pi < nbParam; pi++) {
				AffineTerm term = expr.getTerm( getDimensions().getParameters().get(pi) );
				if (term != null) {
					mat.set(r, pi, term.getCoef());
				}
			}
			//indices next; offset by nbParam
			for (int i = 0; i < nbIndices; i++) {
				AffineTerm term = expr.getTerm( getDimensions().getIndices().get(i) );
				if (term != null) {
					mat.set(r, i+nbParam, term.getCoef());
				}
			}
			//constant
			AffineTerm cTerm = expr.getTerm(null);
			if (cTerm != null) {
				mat.set(r, nbParam+nbIndices, cTerm.getCoef());
			}
		}
		
		return mat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Quick implementation of best effort uniformization of functions using equalities in the context domain.
	 * Uniformization here is an effort to make function of the form (i,j,k->i+a,j+b,k+c,..), 
	 * and it will work even if there are more/less dimensions in the RHS compared to LHS.
	 * It will only "uniformize" up to the dimension in the LHS.
	 * (sometimes, schedules use last dimension for statement ordering, but the dependencies are still uniform mod that)
	 * 
	 * It is sloppy since it uses Gaussian elimination, which does not work in general for integer matrices.
	 * There is a naive check for rational solutions and if its find, it gives up trying to uniformize.
	 * 
	 * The basic algorithm is to formulate a desired combination of parameters/indices to make a dimension of the RHS uniform,
	 * and use rank to check if it can be expressed as linear combinations of equality constraints.
	 * If it is, it uses the result to apply the necessary substitutions. 
	 * In the first step while checking for rank, constant part is ignored, and is used in the latter part during the substitution.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Function uniformizeInContext(Domain context) {
		if (this.getExpressions().size() == 0) {
			return getFactory().createFunction(this);
		}
		
		PolymodelDefaultFactory fact = getFactory();

		Matrix fMat = this.toMatrix();
		
		//use affine hull to get equalities from context
		Domain affineHull = context.affineHull();
		assert(affineHull.getPolyhedra().size() == 1);
		Matrix equalities;
		{
			Matrix hullMat = affineHull.toMatrices().get(0);
			equalities = fact.createMatrix(hullMat.getNbRows(), hullMat.getNbCols()-1);
			for (int r = 0; r < equalities.getNbRows(); r++) {
				for (int c = 0; c < equalities.getNbCols(); c++) {
					equalities.set(r, c, hullMat.get(r, c+1));
				}
			}
		}

		int nbParams = context.getNbParams();
//		int nbIndices = context.getNbParams();
		int nbRHS = this.getExpressions().size();
	
		//create matrix representation of functions with the implicit parameters
		Matrix combinedMat = fact.createMatrix(nbParams+fMat.getNbRows(), fMat.getNbCols());
		//implicit identity of the parameters
		for (int i = 0; i < nbParams; i++) {
			combinedMat.set(i, i, 1);
		}
		//copy function equalities
		for (int i = 0; i < fMat.getNbRows(); i++) {
			MatrixRow row = fMat.getRows().get(i);
			for (int j = 0; j < row.getSize(); j++) {
				combinedMat.set(i+nbParams, j, row.get(j));
			}
		}
		
//		System.out.println(func);
//		System.out.println(context);
//		
//		System.out.println(fMat);
//		System.out.println(equalities);
//		System.out.println(combinedMat);

		Matrix newFmat = this.toMatrix();
	
		//iterate over rows that correspond to RHS 
		for (int r = nbParams; r < nbParams+nbRHS; r++) {
			MatrixRow row = combinedMat.getRows().get(r);
			boolean uniform = true;
			MatrixRow desired = fact.createMatrixRow(row.getSize());
			for (int c = 0; c < row.getSize()-1 ; c++) {
				if (c==r && row.get(c) != 1) {
					uniform = false;
					desired.set(c, 1 - row.get(c));
				}
				if (c!=r && row.get(c) != 0) {
					uniform = false;
					desired.set(c, -row.get(c));
				}
			}
			
			if (uniform) continue;
			
			//append desired matrix with equalities to get matrix for testing linear independence
			Matrix testMat = EcoreUtil.copy(equalities);
			testMat.getRows().add(desired);
			//ignore constants
			for (int tr = 0; tr < testMat.getNbRows()-1; tr++) {
				testMat.set(tr, testMat.getNbCols()-1, 0);
			}
			double[][] A = MatrixOperations.toDoubleMatrix(PolymodelMatrixOperation.toMatrix(testMat));
			List<double[][]> gauss = MatrixOperations.gaussRow(A);
			
//			double[][] G = gauss.get(0);
			double[][] U = gauss.get(1);
			int rank = gauss.get(2)[0].length;
			
			//if its full row rank, not possible
			if (rank == testMat.getNbRows()) continue;

			
			double[][] Uinv = MatrixOperations.inverse(U);
			long[] substitution = new long[row.getSize()];
			
			boolean rationalDetected = false;
			for (int sc = 0; sc < Uinv[testMat.getNbRows()-1].length-1; sc++) {
				double multiplier = Uinv[testMat.getNbRows()-1][sc];
				//check integer (FIXME sloppy)
				if (!(Math.abs(multiplier - (long)multiplier) < 0.000001)) {
					rationalDetected = true;
					break;
				}
				
				long coef = (long)multiplier;
				
				for (int tc = 0; tc < fMat.getNbCols(); tc++) {
					substitution[tc] -= coef * equalities.get(sc, tc);
				}
				
			}

			//do not update the function if problem detected for gaussian part
			if (rationalDetected) continue;

			for (int tc = 0; tc < fMat.getNbCols(); tc++) {
				newFmat.set(r-nbParams, tc, newFmat.get(r-nbParams, tc) + substitution[tc]);
			}
			
//			System.out.println("G:");
//			MatrixOperations.printMatrix(G);
//			System.out.println("U:");
//			MatrixOperations.printMatrix(U);
//			System.out.println("U.G:");
//			MatrixOperations.printMatrix(MatrixOperations.matrixMultiplication(U, G));
//			System.out.println("Uinv:");
//			MatrixOperations.printMatrix(Uinv);
//			System.out.println("Uinv.A:");
//			MatrixOperations.printMatrix(MatrixOperations.matrixMultiplication(Uinv, MatrixOperations.toDoubleMatrix(toMatrix(testMat))));
//			System.out.println("sub:");
//			MatrixOperations.printMatrix(substitution);
//			System.out.println("newFmat:");
//			System.out.println(newFmat);
			
		}
		
		EList<Variable> params = getDimensions().getParameters();
		EList<Variable> indices = getDimensions().getIndices();
		
		return fact.createFunction(indices, params, newFmat.toFunction(params, indices));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Function nullspace() {
		Matrix mat = linearPartWithParameters();

		Matrix basis = mat.nullspace();
		
		if (basis.getNbRows() == 0 || basis.getNbCols() == 0) {
			return getFactory().createFunction(getDimensions(), new ArrayList<IntExpression>());
		}
		basis = basis.transpose();
		
		//add constant part
		for (MatrixRow row : basis.getRows()) {
			row.getValues().add(0l);
		}
		
		//the case where no nullspace is found
		if (basis.getNbRows() == 1) {
			boolean allZero = true;
			for (long v : basis.getRows().get(0).getValues()) {
				if (v != 0) {
					allZero = false;
					break;
				}
			}
			if (allZero) {
				return getFactory().createFunction(getDimensions(), new ArrayList<IntExpression>());
			}
		}

		return getFactory().createFunction(getDimensions(), basis.toFunction(getDimensions().getParameters(), getDimensions().getIndices()));
	}

	/**
	 * <!-- begin-user-doc -->
	 * Simplify matrix format with constant column removed.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Matrix linearPart() {
		Matrix mat = toMatrix();
		
		for (MatrixRow row : mat.getRows()) {
			row.getValues().remove(row.getSize()-1);
		}

		return mat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Adds identity sub-matrix in the upper-left for identity of parameters,
	 * usually not explicitly represented in polymodel.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Matrix linearPartWithParameters() {
		Matrix mat = linearPart();
		
		int numParams = getDimensions().getParameters().size();
		for (int i = numParams-1; i >= 0; i--) {
			MatrixRow row = getFactory().createMatrixRow(mat.getNbCols());
			row.set(i, 1);
			mat.getRows().add(0, row);
		}
		
		return mat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Function linearPartAsFunction() {
		List<IntExpression> exprs = new ArrayList<IntExpression>(getExpressions().size());
		for (IntExpression expr : getExpressions()) {
			AffineExpression affine = expr.toAffine();
			if (affine.getTerm(null) != null) {
				affine.getTerms().remove(affine.getTerm(null));
			}
			exprs.add(affine);
		}
		
		return getFactory().createFunction(getDimensions(), exprs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Long> constantPart() {
		EList<Long> res = new BasicEList<Long>();
		
		Matrix mat = toMatrix();
		
		for (MatrixRow row : mat.getRows()) {
			res.add(row.getValues().get(row.getSize()-1));
		}

		return res;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isUniform() {
		if (getDimensions().getIndices().size() != getExpressions().size()) {
			return false;
		}
		
		//implemented in 5min. probably not very robust
		for (int i = 0; i < getDimensions().getIndices().size(); i++) {
			Variable iv = getDimensions().getIndices().get(i);
			//check that index dimension is correct
			if (iv instanceof IndexDimension) {
				if (((IndexDimension)iv).getDimension() != i) {
					throw new RuntimeException("Assumes indices are ordered.");
				}
			}
			//the expression should be affine
			AffineExpression ie = getExpression(i).copy().toAffine();
			
			boolean found = false;
			for (AffineTerm term : ie.getTerms()) {
				if (term.getVariable() != null) {
					if ( term.getVariable().equals(iv)) {
						found = true;
					} else if (term.getCoef() != 0) {
						return false;
					}
				}
			}

			//var must be used once
			if (!found) return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isIdentity() {
		List<IntExpression> exprs = new ArrayList<IntExpression>(getDimensions().getIndices().size());
		
		for (Variable var : getDimensions().getIndices()) {
			exprs.add(IntExpressionBuilder.affine(IntExpressionBuilder.term(var)));
		}
		Function id = getFactory().createFunction(getDimensions().copy(), exprs);
		if (this.getIn() != null)
			id.setIn(this.getIn().copy());
		if (this.getOut() != null)
			id.setOut(this.getOut().copy());
		return id.equivalence(this);
	}

	private <T extends Function> T inverseMatToFunction(DimensionsManager manager, Matrix inverse, EList<Variable> invIndices) {
		final int nbParam = getDimensions().getParameters().size();
		
		Matrix invMat = getFactory().createMatrix(0, inverse.getNbCols());
		//Remove rows that correspond to implicit identity of parameters
		//isCheck used to check is the implicit identity of parameter i is removed
		boolean[] isCheck = new boolean[nbParam];
		for(int t = 0; t < nbParam; t++){
			isCheck[t] = false;
		}
		for (MatrixRow row : inverse.getRows()) {
			int numValues=0;
			long value=0;
			int loc=0;
			for (int i = 0; i < row.getSize(); i++) {
				if (row.get(i) != 0) {
					numValues++;
					value = row.get(i);
					loc = i;
				}
			}
			//if it meets the criteria for parameter identity
			if (!(numValues == 1 && value == 1L && 0<= loc && loc < nbParam )) {
				invMat.getRows().add(EcoreUtil.copy(row));
			}else{
				if(!isCheck[loc]){	//it is an implicit identity of parameter loc
					isCheck[loc] = true;
				}else{
					invMat.getRows().add(EcoreUtil.copy(row));
				}
			}
		}
		
		DomainDimensions dims = getFactory().createDomainDimensions(invIndices, getDimensions().getParameters());
	 
		T invF =  getFactory().createFunction(dims, invMat.toFunction(dims.getParameters(), dims.getIndices()), manager);
		
		if (getIn() != null)
			invF.setOut(getIn().copy());

		if (getOut() != null)
			invF.setIn(getOut().copy());
		
		return invF;
		
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public <T extends Function> T inverseInContext(DimensionsManager manager, Domain context, EList<String> names) {
		final int nbParam = getDimensions().getParameters().size();
//		final int nbIndices = getDimensions().getIndices().size();
		Matrix thisMat = this.toMatrix();
		int numInvIndices = thisMat.getNbRows();
		
		//Matrix form of the mapping, add the implicit identity of parameters
		int nColumn = thisMat.getNbCols();
		if(nColumn == 0){	//there is no expression for the indices part
			 nColumn = getDimensions().getParameters().size() + getDimensions().getIndices().size() + 1;
		}
		Matrix Tmat = getFactory().createMatrix(nbParam,nColumn);
		for (int i = 0; i < nbParam; i++) {
			Tmat.set(i, i, 1);
		}
		Tmat.getRows().addAll(thisMat.getRows());
		
		//construct names, size corresponds to the destination dimension
		EList<Variable> invIndices = new BasicEList<Variable>(numInvIndices);
		
		if (names == null) {
			for (int i = 0; i < numInvIndices; i++) {
				invIndices.add(manager.getDimension(i));
			}
		} else {
			for (int i = 0; i < Math.min(numInvIndices,  names.size()); i++) {
				invIndices.add(manager.getDimension(i, names.get(i)));
			}
			for (int i = names.size(); i < numInvIndices; i++) {
				invIndices.add(manager.getDimension(i));
			}
		}
		
		//When context is not given simply take the inverse with no context
		if (context == null) {
			Matrix inverse = Tmat.inverseInContext(null);
			if (inverse == null) {
				throw new RuntimeException("No inverse found for function:" + this);
			}
			return inverseMatToFunction(manager, inverse, invIndices);
		} else {
			//Find inverseInContext for all polyhedron consisting the union of context
			T invF = null;
			Domain nContext = context.detectEqualities();
			if (nContext.getPolyhedra().size()>1)
				nContext = nContext.affineHull();
			// All which matter in the context are their equality => can manage union of polyhedra
			//			by taking the affineHull...
			
			for (Matrix mat : nContext.toMatrices()) {		// Should have only one element
				//Extract equalities
				Matrix eqs = getFactory().createMatrix(0, 0);
				for (MatrixRow row : mat.getRows()) {
					if (row.get(0) == 0) {
						//copy the row without the first column
						MatrixRow eqRow = getFactory().createMatrixRow(row.getSize()-1);
						for (int i = 1; i < row.getSize(); i++) {
							eqRow.set(i-1, row.get(i));
						}
						eqs.getRows().add(eqRow);
					}
				}
				Matrix invMat = Tmat.inverseInContext(eqs);
				if (invMat == null) {
					throw new RuntimeException("No inverse found for function:" + this);
				}
				//if (invF == null) {
					invF = inverseMatToFunction(manager, invMat, invIndices);
				//} else {
				//	Function invF2 = inverseMatToFunction(manager, invMat, invIndices);
				//	if (!invF.equivalence(invF2)) {
						// Should not be a failure state
				//		throw new RuntimeException("Two inverses found in each polyhedron for unions of polyhedra is not equivalent.");
				//	}
				//}
			}
			
			return invF;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Label getIn() {
		return in;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIn(Label newIn, NotificationChain msgs) {
		Label oldIn = in;
		in = newIn;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolymodelPackage.FUNCTION__IN, oldIn, newIn);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIn(Label newIn) {
		if (newIn != in) {
			NotificationChain msgs = null;
			if (in != null)
				msgs = ((InternalEObject)in).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolymodelPackage.FUNCTION__IN, null, msgs);
			if (newIn != null)
				msgs = ((InternalEObject)newIn).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolymodelPackage.FUNCTION__IN, null, msgs);
			msgs = basicSetIn(newIn, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolymodelPackage.FUNCTION__IN, newIn, newIn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Label getOut() {
		return out;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOut(Label newOut, NotificationChain msgs) {
		Label oldOut = out;
		out = newOut;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolymodelPackage.FUNCTION__OUT, oldOut, newOut);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOut(Label newOut) {
		if (newOut != out) {
			NotificationChain msgs = null;
			if (out != null)
				msgs = ((InternalEObject)out).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolymodelPackage.FUNCTION__OUT, null, msgs);
			if (newOut != null)
				msgs = ((InternalEObject)newOut).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolymodelPackage.FUNCTION__OUT, null, msgs);
			msgs = basicSetOut(newOut, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolymodelPackage.FUNCTION__OUT, newOut, newOut));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainDimensions getDimensions() {
		return dimensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDimensions(DomainDimensions newDimensions, NotificationChain msgs) {
		DomainDimensions oldDimensions = dimensions;
		dimensions = newDimensions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolymodelPackage.FUNCTION__DIMENSIONS, oldDimensions, newDimensions);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDimensions(DomainDimensions newDimensions) {
		if (newDimensions != dimensions) {
			NotificationChain msgs = null;
			if (dimensions != null)
				msgs = ((InternalEObject)dimensions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolymodelPackage.FUNCTION__DIMENSIONS, null, msgs);
			if (newDimensions != null)
				msgs = ((InternalEObject)newDimensions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolymodelPackage.FUNCTION__DIMENSIONS, null, msgs);
			msgs = basicSetDimensions(newDimensions, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolymodelPackage.FUNCTION__DIMENSIONS, newDimensions, newDimensions));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolymodelVisitor visitor) {
		visitor.visitFunction(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IntExpression getExpression(int position) {
		return this.getExpressions().get(position);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolymodelPackage.FUNCTION__EXPRESSIONS_MAP:
				return ((InternalEList<?>)getExpressionsMap()).basicRemove(otherEnd, msgs);
			case PolymodelPackage.FUNCTION__DIMENSIONS:
				return basicSetDimensions(null, msgs);
			case PolymodelPackage.FUNCTION__IN:
				return basicSetIn(null, msgs);
			case PolymodelPackage.FUNCTION__OUT:
				return basicSetOut(null, msgs);
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
			case PolymodelPackage.FUNCTION__EXPRESSIONS_MAP:
				if (coreType) return getExpressionsMap();
				else return getExpressionsMap().map();
			case PolymodelPackage.FUNCTION__DIMENSIONS:
				return getDimensions();
			case PolymodelPackage.FUNCTION__IN:
				return getIn();
			case PolymodelPackage.FUNCTION__OUT:
				return getOut();
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
			case PolymodelPackage.FUNCTION__EXPRESSIONS_MAP:
				((EStructuralFeature.Setting)getExpressionsMap()).set(newValue);
				return;
			case PolymodelPackage.FUNCTION__DIMENSIONS:
				setDimensions((DomainDimensions)newValue);
				return;
			case PolymodelPackage.FUNCTION__IN:
				setIn((Label)newValue);
				return;
			case PolymodelPackage.FUNCTION__OUT:
				setOut((Label)newValue);
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
			case PolymodelPackage.FUNCTION__EXPRESSIONS_MAP:
				getExpressionsMap().clear();
				return;
			case PolymodelPackage.FUNCTION__DIMENSIONS:
				setDimensions((DomainDimensions)null);
				return;
			case PolymodelPackage.FUNCTION__IN:
				setIn((Label)null);
				return;
			case PolymodelPackage.FUNCTION__OUT:
				setOut((Label)null);
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
			case PolymodelPackage.FUNCTION__EXPRESSIONS_MAP:
				return expressionsMap != null && !expressionsMap.isEmpty();
			case PolymodelPackage.FUNCTION__DIMENSIONS:
				return dimensions != null;
			case PolymodelPackage.FUNCTION__IN:
				return in != null;
			case PolymodelPackage.FUNCTION__OUT:
				return out != null;
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
			case PolymodelPackage.FUNCTION___ACCEPT__POLYMODELVISITOR:
				accept((PolymodelVisitor)arguments.get(0));
				return null;
			case PolymodelPackage.FUNCTION___GET_EXPRESSION__INT:
				return getExpression((Integer)arguments.get(0));
			case PolymodelPackage.FUNCTION___GET_EXPRESSIONS:
				return getExpressions();
			case PolymodelPackage.FUNCTION___BUILD_RELATION__DIMENSIONSMANAGER:
				return buildRelation((DimensionsManager)arguments.get(0));
			case PolymodelPackage.FUNCTION___EQUIVALENCE__FUNCTION:
				return equivalence((Function)arguments.get(0));
			case PolymodelPackage.FUNCTION___COMPOSE__FUNCTION:
				return compose((Function)arguments.get(0));
			case PolymodelPackage.FUNCTION___INVERSE__DIMENSIONSMANAGER:
				return inverse((DimensionsManager)arguments.get(0));
			case PolymodelPackage.FUNCTION___INVERSE_IN_CONTEXT__DIMENSIONSMANAGER_DOMAIN:
				return inverseInContext((DimensionsManager)arguments.get(0), (Domain)arguments.get(1));
			case PolymodelPackage.FUNCTION___TO_MATRIX:
				return toMatrix();
			case PolymodelPackage.FUNCTION___UNIFORMIZE_IN_CONTEXT__DOMAIN:
				return uniformizeInContext((Domain)arguments.get(0));
			case PolymodelPackage.FUNCTION___NULLSPACE:
				return nullspace();
			case PolymodelPackage.FUNCTION___LINEAR_PART:
				return linearPart();
			case PolymodelPackage.FUNCTION___LINEAR_PART_WITH_PARAMETERS:
				return linearPartWithParameters();
			case PolymodelPackage.FUNCTION___LINEAR_PART_AS_FUNCTION:
				return linearPartAsFunction();
			case PolymodelPackage.FUNCTION___CONSTANT_PART:
				return constantPart();
			case PolymodelPackage.FUNCTION___IS_UNIFORM:
				return isUniform();
			case PolymodelPackage.FUNCTION___IS_IDENTITY:
				return isIdentity();
		}
		return super.eInvoke(operationID, arguments);
	}

	public IntExpression getExpressionFor(OutputDimension v) {
		return this.getExpressionsMap().get(v);
	}
	
	@Override
	public String toString() {
		String res = "";
		res += this.getDimensions().getParameters() + " -> { ";
		String nameIn = "";
		if (this.getIn() != null) nameIn = this.getIn().getName();
		String nameOut = "";
		if (this.getOut() != null) nameOut = this.getOut().getName();
		res += nameIn+this.getDimensions().getIndices() + " -> "+nameOut+"[";
		
		boolean first = true;
		for (IntExpression expressionFor : this.getExpressions()) {
			if (first) first = false;
			else res += ", ";
			if (expressionFor.toString().isEmpty()) {
				res += "0";
			}
			else res += expressionFor.toString().replace("(in)", "");
		}
		res += "] }";
		return res;	
	}
	
	/**
	 * function instance compatible with the used polyhedral library.
	 * 
	 * @param <F>
	 * @param f
	 * @param type
	 *            function type of the library
	 * @return f if the function is already an instance of the library function,
	 *         else it returns a new function of type F
	 */
	@SuppressWarnings("unchecked")
	protected <F extends Function> F getLibraryRelation(Function f, Class<F> type) {
		if (type.isInstance(f)) {
			return (F) f;
		} else {
			F res = getFactory().createFunction(f);
			return res;
		}
	}

	public String toString(OUTPUT_FORMAT format) {
		return PolymodelPrettyPrinter.print(this, format);
	}
	

	/**
	 * Either use PolymodelComponent.INSTANCE.getDefaultDimensionsManager()
	 * or manage dimension management at higher level.
	 */
	@Deprecated
	public DimensionsManager getDimensionsManager() {
		
		DimensionsManager paramDM = null;
		for (Variable param : dimensions.getParameters()) {
			DimensionsManager DM = (DimensionsManager)param.eContainer();
			if (paramDM == null) {
				paramDM = DM;
			} else {
				assert(paramDM.equals(DM));
			}
		}

		DimensionsManager indicesDM = null;
		for (Variable index : dimensions.getIndices()) {
			DimensionsManager DM = (DimensionsManager)index.eContainer();
			if (indicesDM == null) {
				indicesDM = DM;
			} else {
				assert(indicesDM.equals(DM));
			}
		}
		
		if (paramDM != null && indicesDM != null) {
			assert(paramDM.equals(indicesDM));
		}
		
		if (paramDM == null) {
			return indicesDM;
		} else {
			return paramDM;
		}
	}

	@Override
	public int getDimRHS() {
		return getExpressions().size();
	}

	@Override
	public int getDimLHS() {
		return getIndices().size();
	}

	@Override
	public List<Variable> getParameters() {
		return getDimensions().getParameters();
	}

	@Override
	public List<Variable> getIndices() {
		return getDimensions().getIndices();
	}

	@Override
	public Function copy() {
		return EcoreUtil.copy(this);
	}
} // FunctionImpl
