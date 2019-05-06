/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.isl.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Vector;

import org.eclipse.emf.ecore.EClass;
import org.polymodel.DimensionsManager;
import org.polymodel.DomainDimensions;
import org.polymodel.Function;
import org.polymodel.OutputDimension;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.impl.FunctionImpl;
import org.polymodel.isl.ISLFunction;
import org.polymodel.isl.ISLMap;
import org.polymodel.isl.IslPackage;
import org.polymodel.isl.factory.ISLNativeBinder;
import org.polymodel.isl.factory.ISLPolymodelModule;

import fr.irisa.cairn.jnimap.isl.jni.ISL_FORMAT;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLDimType;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMap;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>ISL Function</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ISLFunctionImpl extends FunctionImpl implements ISLFunction {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ISLFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IslPackage.Literals.ISL_FUNCTION;
	}
	
	public ISLMap getMap(DimensionsManager manager) {
		return getFactory().createRelation(manager, this);
	}

	public ISLFunction simplify() {
		JNIISLMap tm = ISLNativeBinder.jniIslMapNoString(this);
		tm = tm.coalesce();
		List<Variable> inputs = this.getDimensions().getIndices();
		List<Variable> params = this.getDimensions().getParameters();
		List<OutputDimension> outputs = new ArrayList<OutputDimension>();
		for (Entry<OutputDimension, IntExpression> e : this.getExpressionsMap()) {
			outputs.add(e.getKey());
		}
		
		String in = null;
		if (this.getIn() != null)
			in = this.getIn().getName();
		String out = null;
		if (this.getOut() != null)
			in = this.getOut().getName();
		
		return ISLNativeBinder.islFunction(tm, inputs, outputs, params, in, out);
		
//		ISLMap t = getFactory().createRelation(this);
//		return t.simplify().buildFunction();
	}
	
	@Override
	public boolean equivalence(Function f) {
		JNIISLMap tm = ISLNativeBinder.jniIslMapNoString(this);
		JNIISLMap fm = ISLNativeBinder.jniIslMapNoString(f);
		return tm.equivalence(fm);
		
//		ISLMap t = getFactory().createRelation(this);
//		ISLMap ma = getFactory().createRelation(f);
//		return ma.equivalence(t);
	}

	@Override
	public <T extends Function> T compose(Function f) {
		if (f.getExpressions().size() != this.getDimensions().getIndices().size()) 
			throw new IllegalArgumentException("Can not compose "+this+" with "+f);
		
		JNIISLMap map1 = ISLNativeBinder.jniIslMapNoString(this);
		JNIISLMap map2 = ISLNativeBinder.jniIslMapNoString(f);
		JNIISLMap mapC = map2.applyRange(map1);
		
		List<Variable> inputs = f.getDimensions().getIndices();
		List<Variable> params = this.getDimensions().getParameters();
		List<OutputDimension> outputs = new ArrayList<OutputDimension>();
		for (Entry<OutputDimension, IntExpression> e : this.getExpressionsMap()) {
			outputs.add(e.getKey());
		}
		
		String in = null;
		if (f.getIn() != null)
			in = f.getIn().getName();
		String out = null;
		if (this.getOut() != null)
			in = this.getOut().getName();
		
		T res = ISLNativeBinder.islFunction(mapC,inputs, outputs, params, in, out);
		return res;
//		JNIISLMap map1 = ISLNativeBinder.jniIslMap(getFactory().createRelation(this));
//		JNIISLMap map2 = ISLNativeBinder.jniIslMap(getFactory().createRelation(f));
//		JNIISLMap mapC = JNIISLMap.applyRange(map2, map1);
//		//Preserve old names for the LHS
//		return retreiveFunction(mapC, f.getDimensions());
	}
	

	@Override
	public PolymodelDefaultFactory getFactory() {
		return PolymodelComponent.INSTANCE.getFactory(ISLPolymodelModule.INSTANCE);
	}
	
	/**
	 * Converts back JNIISLMap object to AffineMapping using the params/indices given.
	 * 
	 * @param params
	 * @param indices
	 * @param map
	 * @return
	 */ 
	public ISLFunction retreiveFunction(DimensionsManager manager, JNIISLMap map, DomainDimensions dims) {
		String islText = map.toString(ISL_FORMAT.POLYLIB); 
		String[] lines = islText.split("\r|\n");
		
		if (lines.length == 1) {
			throw new RuntimeException("Empty map: " + map);
		}

//		System.out.println(map);
//		System.out.println(islText);
//		System.out.println(dims.getParameters());
//		System.out.println(dims.getIndices());

		String[] sizeRow = lines[2].split("\\s+");
		int nRow = Integer.parseInt(sizeRow[0]);
//		int lhsDim = (int)map.getNbDim(JNIISLDimType.isl_dim_in);
		int rhsDim = (int)map.getNbDims(JNIISLDimType.isl_dim_out);

		//Create separate list to make access easier
		List<Variable> ids = new LinkedList<Variable>();
		//Parameters are after indices in polylib format
		for (Variable i : dims.getIndices()) {
			ids.add(i);
		}
		for (Variable p : dims.getParameters()) {
			ids.add(p);
		}
		
		//Initialize expression list with the number of dimensions
		List<IntExpression> expressions = new Vector<IntExpression>(nRow);
		for (int i = 0; i < nRow; i++) {
			expressions.add(null);
		}
		
		//Construct expressions from polylib format
		for (int r = 0 ; r < nRow; r++) {
			String[] row = lines[3+r].split("\\s+");
			//skip domain constraints
			if (Integer.parseInt(row[0]) == 1) {
				continue;
			}
			int exprColStart = rhsDim + 1; //1 is for the eq/ineq in the head
			
			AffineExpression expr = IntExpressionBuilder.affine();
			//Find out which dimension this row is about
			//ISL output does not guarantee any ordering
			int dim = -1;
			boolean negate = false;
			for (int i = 0; i < rhsDim; i++) {
				if (Integer.parseInt(row[1+i]) != 0) {
					dim = i;
					//if the target is 1, all other columns have to be negated
					if (Integer.parseInt(row[1+i]) == 1) {
						negate = true;
					}
					break;
				}
			}
			//if the equality does not correspond to the function, ignore
			if (dim == -1) continue;
			
			//Parameters eq/en indices params 1
			for (int i = exprColStart; i < row.length-1; i++) {
				Variable id = ids.get(i-exprColStart);
				long coef = Long.parseLong(row[i]);
				if (negate) coef = -coef;
				expr.getTerms().add(IntExpressionBuilder.term(coef, id));
			}
			//Constant part
			long constant = Long.parseLong(row[row.length-1]);
			if (negate) constant = -constant;
			if (constant != 0) {
				expr.getTerms().add(IntExpressionBuilder.term(constant));
			}
			
			expressions.set(dim,expr.simplify());
		}
		
		return getFactory().createFunction(dims.getIndices(), dims.getParameters(), expressions, manager);
	}
	
	
} // ISLFunctionImpl
