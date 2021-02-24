package org.polymodel.isl.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.AbstractRelation;
import org.polymodel.BasicRelation;
import org.polymodel.DimensionsManager;
import org.polymodel.Domain;
import org.polymodel.DomainDimensions;
import org.polymodel.ExistentialVariable;
import org.polymodel.Function;
import org.polymodel.InputDimension;
import org.polymodel.Label;
import org.polymodel.OutputDimension;
import org.polymodel.RelationDimensions;
import org.polymodel.algebra.AlgebraFactory;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.SelectExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.polynomials.PolynomialExpression;
import org.polymodel.algebra.polynomials.PolynomialTerm;
import org.polymodel.algebra.polynomials.PolynomialVariable;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.algebra.quasiAffine.NestedQuasiAffineTerm;
import org.polymodel.algebra.quasiAffine.QuasiAffineExpression;
import org.polymodel.algebra.quasiAffine.QuasiAffineFactory;
import org.polymodel.algebra.quasiAffine.QuasiAffineOperator;
import org.polymodel.algebra.quasiAffine.QuasiAffineTerm;
import org.polymodel.algebra.quasiAffine.SimpleQuasiAffineTerm;
import org.polymodel.algebra.reductions.ReductionExpression;
import org.polymodel.algebra.reductions.ReductionOperator;
import org.polymodel.algebra.tom.RemoveRightSideTransformation;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.isl.ISLBasicMap;
import org.polymodel.isl.ISLMap;
import org.polymodel.isl.ISLPoint;
import org.polymodel.isl.ISLSet;
import org.polymodel.isl.ISLUnionMap;
import org.polymodel.isl.ISLUnionSet;
import org.polymodel.isl.IslFactory;
import org.polymodel.prettyprinters.PolymodelPrettyPrinter;

import fr.irisa.cairn.jnimap.isl.jni.ISLFactory;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLAff;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicSet;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLConstraint;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLContext;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLDimType;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLLocalSpace;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMatrix;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMultiAff;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLPoint;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLQPolynomial;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSet;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSpace;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLTerm;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionSet;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLVal;

public class ISLNativeBinder {
	
	private static final boolean DEBUG = false;
	private static final void debug(String str) {
		if(DEBUG)
			System.out.println(str);
	}
	
	private static List<Variable> getParameterVariables(List<String> names, DimensionsManager manager) {
		List<Variable> params = new ArrayList<Variable>(names.size());
		for (int i = 0; i < names.size(); i++) {
			String name = names.get(i);
			if (name == null) {
				params.add(manager.getParameter(i));
			} else {
				params.add(manager.getParameter(i, name));
			}
		}
		return params;
	}

	private static List<Variable> getDimensionVariables(List<String> names, DimensionsManager manager) {
		List<Variable> vars = new ArrayList<Variable>(names.size());

		for (int i = 0; i < names.size(); i++) {
			String name =names.get(i);
			if (name == null) {
				vars.add(manager.getDimension(i));
			} else {
				vars.add(manager.getDimension(i, name));
			}
		}
		
		return vars;
	}

	
	public static ISLSet createSetFromIslString(String input, DimensionsManager manager) {
		JNIISLSet set = ISLFactory.islSet(input);

		List<Variable> params = getParameterVariables(set.getParametersNames(), manager);
		List<Variable> indices = getDimensionVariables(set.getIndicesNames(), manager);
		
		return islSet(set, indices, params);
	}
	
	public static ISLMap createMapFromIslString(String input, DimensionsManager manager) {
		JNIISLMap map = ISLFactory.islMap(input);
		
		List<Variable> params = getParameterVariables(map.getParametersNames(), manager);
		List<Variable> inputs = getDimensionVariables(map.getDomainNames(), manager);
		List<Variable> outputs = getDimensionVariables(map.getRangeNames(), manager);
		
		return islMap(map, manager.getInputsDimensionsFor(inputs), 
							manager.getOutputsDimensionsFor(outputs), params);
	}
	

//	public static ISLFunction createFunctionFromIslString(String input, DimensionsManager manager) {
//		JNIISLMap map = ISLFactory.islMap(input);
//
//		List<Variable> params = getParameterVariables(map.getParametersNames(), manager);
//		List<Variable> inputs = getDimensionVariables(map.getDomainNames(), manager);
//		List<Variable> outputs = getDimensionVariables(map.getRangeNames(), manager);
//		
//		return islFunction(map, manager.getInputsDimensionsFor(inputs), 
//				manager.getOutputsDimensionsFor(outputs), params);
//	}

	public static ISLSet createSetFromIslString(String input,
			List<Variable> indices, List<Variable> parameters) {
		return islSet(ISLFactory.islSet(input), indices, parameters);
	}

	public static ISLMap createMapFromIslString(String input,
			List<InputDimension> inputs, List<OutputDimension> outputs,
			List<Variable> parameters) {
		return islMap(ISLFactory.islMap(input), inputs, outputs, parameters);
	}

//	public static ISLFunction createFunctionFromIslString(String input,
//			List<InputDimension> inputs, List<OutputDimension> outputs,
//			List<Variable> parameters) {
//		return islFunction(ISLFactory.islMap(input), inputs, outputs, parameters);
//	}
	
	public static JNIISLSet jniIslSet(ISLSet set) {
		String s = PolymodelPrettyPrinter.print(set, OUTPUT_FORMAT.ISL);
		return ISLFactory.islSet(s);
	}
	
	public static JNIISLSet jniIslSet(Domain dom) {
		String s = PolymodelPrettyPrinter.print(dom, OUTPUT_FORMAT.ISL);
		return ISLFactory.islSet(s);
	}

	/*
	public static JNIISLSet jniIslSetNoString(Domain set) {
		JNIISLSpace space = jniIslSpace(set.getDimensions());
		JNIISLSet res = null;

		//convert ReductionExpressions in polyhedra
		EList<IntConstraintSystem> polyhedra = convertReductionExpr(set.getPolyhedra());

		for (IntConstraintSystem sys : polyhedra) {
			JNIISLBasicSet bset = jniIslBasicSetNoString(sys,space,set.getDimensions());
			if (res == null) res = bset.toSet();
			else res = res.union(bset.toSet());
		}
		if (res == null)
			res = JNIISLSet.buildUniverse(space);
		if (set.getLabel() != null) 
			res = res.setTupleName(set.getLabel().getName());
//		Label label = set.getLabel();
//		String name = label.getName();
//		res.setTupleName(name);
		return res;
	}
	*/
	

	public static JNIISLBasicSet jniIslBasicSetNoString(Domain set) {
		if (set.getPolyhedra().size() > 1) {
			throw new RuntimeException("Number of Polyhedral must be 1 to be converted to BasicSet");
		}
		
		JNIISLSpace space = jniIslSpace(set.getDimensions());
		EList<IntConstraintSystem> polyhedra = convertReductionExpr(set.getPolyhedra());
		
		IntConstraintSystem poly = polyhedra.get(0);

		return jniIslBasicSetNoString(poly,space,set.getDimensions());
	}
	
	/*private static JNIISLBasicSet jniIslBasicSetNoString(
			IntConstraintSystem sys, JNIISLSpace space, DomainDimensions dims) {
		JNIISLBasicSet bset = JNIISLBasicSet.universe(space.copy());
		
		for (IntConstraint c : sys.getConstraints()) {
			JNIISLLocalSpace ls = JNIISLLocalSpace.fromSpace(space.copy());
			c = RemoveRightSideTransformation.transform(c.simplify()).simplify();
			
			JNIISLConstraint jc = (c.getComparisonOperator() == ComparisonOperator.EQ)?
					JNIISLConstraint.equality(ls):
					JNIISLConstraint.inEquality(ls);
					
			IntExpression lhs = c.getLhs().simplify();
			AffineExpression affine = lhs.toAffine();
			if (affine == null) {
				throw new RuntimeException(lhs.toString(OUTPUT_FORMAT.ISL)+" is not affine.");
			}
			for (AffineTerm t : affine.getTerms()) {
				if (t.getVariable() == null) jc.setConstant((int)t.getCoef());
				else {
					int ipos = dims.getDimensionOf(t.getVariable());
					if (ipos == -1) {
						int ppos = dims.getParameterDimensionOf(t.getVariable());
						if (ppos == -1) throw new RuntimeException("Variable is neither an index nor a parameter."); 
						else {
							jc.setCoef(JNIISLDimType.isl_dim_param, ppos, (int)t.getCoef());
						}
					} else {
						jc.setCoef(JNIISLDimType.isl_dim_set, ipos, (int)t.getCoef());
					}
				}
			}
			bset = bset.addConstraint(jc);
		}
		return bset;
	}*/
	
	private static JNIISLBasicSet jniIslBasicSetNoString(
			IntConstraintSystem sys, JNIISLSpace space, DomainDimensions dims) {
	
		JNIISLContext ctx = JNIISLContext.getCtx();
		List<long[]> matrixEq = new ArrayList<>();
		List<long[]> matrixInEq = new ArrayList<>();
		List<Variable> outputs = new ArrayList<Variable>();
		
		List<IntConstraint> constraints = new ArrayList<IntConstraint>();
		constraints.addAll(sys.getConstraints());
		
		convertReductionExpr(constraints);
		
		convertAffineExprToMatrix(constraints, matrixEq, matrixInEq, dims.getIndices(), outputs, dims.getParameters(), dims.getExistential());
		
		int totalCol = convertQuasiAffineExprToMatrix(constraints, matrixEq, matrixInEq, space, dims.getIndices(), outputs, dims.getParameters(), dims.getExistential(), false);
		
//		convertOtherExprToMatrix(constraints, matrixEq, matrixInEq, dims.getIndices(), outputs, dims.getParameters(), dims.getExistential());
	
		JNIISLMatrix jniIslMatrixEq = JNIISLMatrix.build(ctx, matrixEq.size(), totalCol);
		JNIISLMatrix jniIslMatrixInEq = JNIISLMatrix.build(ctx, matrixInEq.size(), totalCol);
		int currRowEq = 0;
		int currRowInEq = 0;
		for ( long[] row : matrixEq ) {
			for ( int i = 0; i < totalCol; i++  ) {
				if ( i < row.length )
					jniIslMatrixEq = jniIslMatrixEq.setElement(currRowEq, i, row[i]);
				else
					jniIslMatrixEq = jniIslMatrixEq.setElement(currRowEq, i, 0);
			}
			currRowEq++;
		}
		for ( long[] row : matrixInEq ) {
			for ( int i = 0; i < totalCol; i++  ) {
				if ( i < row.length )
					jniIslMatrixInEq = jniIslMatrixInEq.setElement(currRowInEq, i, row[i]);
				else
					jniIslMatrixInEq = jniIslMatrixInEq.setElement(currRowInEq, i, 0);
			}
			currRowInEq++;
		}
		JNIISLBasicSet bs = JNIISLBasicSet.fromConstraintMatrices(space.copy(), jniIslMatrixEq, jniIslMatrixInEq, JNIISLDimType.isl_dim_cst, JNIISLDimType.isl_dim_param, JNIISLDimType.isl_dim_set, JNIISLDimType.isl_dim_div);

		
		return bs;
	}

	public static JNIISLSpace jniIslSpace(DomainDimensions dimensions) {
		List<Variable> indices = dimensions.getIndices();
		List<Variable> params = dimensions.getParameters();
		JNIISLSpace res = JNIISLSpace.allocSet(params.size(), indices.size());
		for (int i = 0; i < indices.size(); i++) {
			res = res.setName(JNIISLDimType.isl_dim_set, i, indices.get(i).getName());
		}
		for (int i = 0; i < params.size(); i++) {
			res = res.setName(JNIISLDimType.isl_dim_param, i, params.get(i).getName());
		}
		return res;
	}

	public static JNIISLSpace jniIslSpace(RelationDimensions dimensions) {
		List<Variable> params = dimensions.getParameters();
		List<InputDimension> inputDims = dimensions.getInputs();
		List<Variable> input = new ArrayList<Variable>(inputDims.size());
		for (InputDimension d : inputDims) 
			input.add(d.getDimension());
		List<OutputDimension> outputDims = dimensions.getOutputs();
		List<Variable> output = new ArrayList<Variable>(outputDims.size());
		for (OutputDimension d : outputDims) 
			output.add(d.getDimension());
		return jniIslMapSpace(input, output, params,null,null);
	}
	
	private static JNIISLSpace jniIslMapSpace(List<? extends Variable> input, List<? extends Variable> output, List<? extends Variable> params, String in, String out) {
		JNIISLSpace res = JNIISLSpace.alloc(params.size(), input.size(), output.size());
		for (int i = 0; i < input.size(); i++) {
			res = res.setName(JNIISLDimType.isl_dim_in, i, input.get(i).getName());
		}
		for (int i = 0; i < output.size(); i++) {
			res = res.setName(JNIISLDimType.isl_dim_out, i, output.get(i).getName());
		}
		for (int i = 0; i < params.size(); i++) {
			res = res.setName(JNIISLDimType.isl_dim_param, i, params.get(i).getName());
		}
		if (in != null)
			res = res.setTupleName(JNIISLDimType.isl_dim_in, in);
		if (out != null)
			res = res.setTupleName(JNIISLDimType.isl_dim_out, out);
		return res;
	}

	public static JNIISLBasicMap jniIslBasicMap(ISLBasicMap map) {
		String s = PolymodelPrettyPrinter.print(map, OUTPUT_FORMAT.ISL);
		return ISLFactory.islBasicMap(s);
	}

	public static JNIISLMap jniIslMap(ISLMap map) {
		String s = PolymodelPrettyPrinter.print(map, OUTPUT_FORMAT.ISL);
		JNIISLMap islMap = ISLFactory.islMap(s);
		return islMap;
	}

	public static JNIISLMap jniIslMap(AbstractRelation map) {
		String s = PolymodelPrettyPrinter.print(map, OUTPUT_FORMAT.ISL);
		return ISLFactory.islMap(s);
	}
	


	public static JNIISLMap jniIslMapNoString(AbstractRelation map) {
		JNIISLSpace space = jniIslSpace(map.getDimensions());
		JNIISLMap res = null;
		try {
			for (BasicRelation bmap : map.getBasicRelations()) {
				List<IntConstraint> constraints = new ArrayList<IntConstraint>();
				constraints.addAll(bmap.getInput().getConstraints());
				constraints.addAll(bmap.getOutput().getConstraints());
				constraints.addAll(bmap.getRelation().getConstraints());
				JNIISLBasicMap bm = jniIslBasicMapNoString(constraints, space.copy(), map.getDimensions());
				if (bmap.getIn() != null) bm = bm.setTupleName(JNIISLDimType.isl_dim_in,bmap.getIn().getName());
				if (bmap.getOut() != null) bm = bm.setTupleName(JNIISLDimType.isl_dim_out,bmap.getOut().getName());
				if (res == null) res = bm.toMap();
				else res = res.union(bm.toMap());
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage() +" in public static JNIISLMap jniIslMapNoString(map)");
		}
		
		return res;
	}

		
	public static JNIISLBasicMap jniIslBasicMapNoString(Function f) {
		boolean verbose = false;
		if (verbose) System.out.println("input polymodel function : "+f);
		List<Variable> inputs = f.getDimensions().getIndices();
		List<Variable> params = f.getDimensions().getParameters();
		int size = f.getExpressionsMap().size();
		List<OutputDimension> outputDims = new ArrayList<OutputDimension>(size);
		List<Variable> outputs = new ArrayList<Variable>(outputDims.size());

		List<IntConstraint> sys = new ArrayList<IntConstraint>(f.getExpressions().size());
		for (Entry<OutputDimension, IntExpression> e : f.getExpressionsMap()) {
			outputDims.add(e.getKey());
			outputs.add(e.getKey());
			
			sys.add(IntExpressionBuilder.constraint(e.getValue(), IntExpressionBuilder.affine(e.getKey()), ComparisonOperator.EQ));
		}
		String inName = f.getIn() == null?null:f.getIn().getName();
		String outName = f.getOut() == null?null:f.getOut().getName();
		JNIISLSpace space = jniIslMapSpace(inputs,outputs,params,inName,outName);
		
		JNIISLBasicMap bmap = jniIslBasicMapNoString(sys, space, params, inputs, outputs, f.getDimensions().getExistential());
		
		return bmap;

//		if (verbose) System.out.println("output isl space  : "+space);
//		JNIISLBasicMap bmap = JNIISLBasicMap.universe(space.copy());
//		for (Entry<OutputDimension, IntExpression> e : f.getExpressionsMap()) {
//			JNIISLLocalSpace ls = JNIISLLocalSpace.fromSpace(space.copy());
//			
//			JNIISLConstraint jc = JNIISLConstraint.equality(ls);
//			
//			OutputDimension output = e.getKey();
//			jc.setCoef(JNIISLDimType.isl_dim_out, outputDims.indexOf(output), -1);
//
//			AffineExpression expr = e.getValue().toAffine();
//			for (AffineTerm t : expr.getTerms()) {
//				Variable variable = t.getVariable();
//				if (variable == null) jc.setConstant((int)t.getCoef());
//				else {
//					int ipos;
//					JNIISLDimType type;
//					if (inputs.contains(variable)) {
//						ipos = inputs.indexOf(variable);
//						type = JNIISLDimType.isl_dim_in;
//					} else if (params.contains(variable)) {
//						ipos = params.indexOf(variable);
//						type = JNIISLDimType.isl_dim_param;
//					} else {
//						throw new RuntimeException("problem with variable : "+variable+" ("+variable.getClass().getSimpleName()+") in expression :"+expr);
//					}
//					jc.setCoef(type, ipos, (int)t.getCoef());
//				}
//			}
//			bmap = bmap.addConstraint(jc);
//		}
//		if (verbose) System.out.println("output isl basic map  : "+bmap);
//		return bmap;
	}
	
	public static JNIISLMap jniIslMapNoString(Function f) {
		JNIISLBasicMap jniIslBasicMapNoString = jniIslBasicMapNoString(f);
		JNIISLMap fromBasicMap = jniIslBasicMapNoString.toMap();
		return fromBasicMap;
	}


	private static JNIISLAff handleNestedQuasiAffineTerms ( NestedQuasiAffineTerm t, JNIISLAff aff, 
			JNIISLLocalSpace ls, List<? extends Variable> inputs, List<? extends Variable> outputs, 
			List<? extends Variable> parameters, List<ExistentialVariable> existentialVars) {
		QuasiAffineExpression qaffExpr = t.getExpression();
		for (QuasiAffineTerm qt : qaffExpr.getTerms() ) {
			if ( qt instanceof SimpleQuasiAffineTerm) {
				SimpleQuasiAffineTerm st = (SimpleQuasiAffineTerm)qt;
				JNIISLAff aff1 = JNIISLAff.buildZero(ls.copy());
				aff1 = handleSimpleQuasiAffineTerms (st, aff1, inputs, outputs, parameters, existentialVars);
				aff = aff.add(aff1);
			} else {
				NestedQuasiAffineTerm nt = (NestedQuasiAffineTerm)qt;
				JNIISLAff aff1 = JNIISLAff.buildZero(ls.copy());
				aff1 = handleNestedQuasiAffineTerms (nt, aff1, ls, inputs, outputs, parameters, existentialVars);
				aff = aff.add(aff1);
			}
		}
		QuasiAffineOperator op = t.getOperator();
		switch ( op ) {
			case MUL:
				aff = aff.scale(t.getCoef());
			break;
			case DIV:
				aff = aff.div(t.getCoef());
			break;
			case MOD:
				aff = aff.mod(t.getCoef());
			break;
			case CEIL:
				aff = aff.div(t.getCoef());
				aff = aff.ceil();
			break;
			case FLOOR:
				aff = aff.div(t.getCoef());
				aff = aff.floor();
			break;
		}
		return aff;
	}
	
	private static JNIISLAff handleSimpleQuasiAffineTerms ( SimpleQuasiAffineTerm st, JNIISLAff aff, 
			List<? extends Variable> inputs, List<? extends Variable> outputs, 
			List<? extends Variable> parameters, List<ExistentialVariable> existentialVars) {
		AffineExpression expr = st.getExpression();
		for ( AffineTerm t : expr.getTerms() ) {
			if (t.getVariable() == null) 
				aff = aff.setConstant((int)t.getCoef());
			else {
				//need to use getXXXDimensionOf, since EList.contains do not call equals.
				int ipos;
				JNIISLDimType type;
				if (getDimensionOf(inputs, t.getVariable()) >= 0) {
					ipos = getDimensionOf(inputs, t.getVariable());
					type = JNIISLDimType.isl_dim_in;
				} else if (getDimensionOf(outputs, t.getVariable()) >= 0) {
					ipos = getDimensionOf(outputs, t.getVariable()) + inputs.size();
					type = JNIISLDimType.isl_dim_in; 
				} else if (getDimensionOf(parameters, t.getVariable()) >= 0) {
					ipos = getDimensionOf(parameters, t.getVariable());
					type = JNIISLDimType.isl_dim_param;
				} else if (getDimensionOf(existentialVars, t.getVariable()) >= 0)  {
					ipos = getDimensionOf(existentialVars, t.getVariable());
					type = JNIISLDimType.isl_dim_div;
				} else {
					throw new RuntimeException("problem with variable : "+t.getVariable()+" ("+t.getVariable().getClass().getSimpleName()+") in expression :"+expr);
				}
				aff = aff.setCoefficient(type, ipos, (int)t.getCoef());
			}
		}
		QuasiAffineOperator op = st.getOperator();
		switch ( op ) {
			case MUL:
				aff = aff.scale((int)st.getCoef());
			break;
			case DIV:
				aff = aff.div(st.getCoef());
			break;
			case MOD:
				aff = aff.mod((int) st.getCoef());
			break;
			case CEIL:
				aff = aff.div(st.getCoef());
				aff = aff.ceil();
			break;
			case FLOOR:
				aff = aff.div(st.getCoef());
				aff = aff.floor();
			break;
		}
		return aff;
	}
	
	private static int getDimensionOf(List<? extends Variable> list, Variable var) {
		int ipos = -1;
		for (int index = 0; index < list.size(); index++) {
			Variable iVar = list.get(index);
			if (iVar.equals(var)) {
				ipos = index;
				break;
			}
			if (iVar instanceof InputDimension) {
				iVar = ((InputDimension) iVar).getDimension();
			} else if (iVar instanceof OutputDimension) {
				iVar = ((OutputDimension) iVar).getDimension();
			}

			if (iVar.equals(var)) {
				ipos = index;
				break;
			}
		}
		return ipos;
	}
	
	private static int getPosition(AffineTerm t, List<? extends Variable> inputs, List<? extends Variable> outputs, List<? extends Variable> parameters, 
			List<ExistentialVariable> existentialVars) {
		final int inSize = inputs.size();
		final int outSize = outputs.size();
		final int paramSize = parameters.size();
		
		int ipos;
		Variable variable = t.getVariable();
		if (variable == null) ipos = 0;
		else {
			if (getDimensionOf(inputs, variable) >= 0) {
				ipos = getDimensionOf(inputs, variable) + 1 + paramSize;	
			} else if (getDimensionOf(outputs, variable) >= 0) {
				ipos = getDimensionOf(outputs, variable) + 1 + paramSize + inSize;
			} else if (getDimensionOf(parameters, variable) >= 0) {
				ipos = getDimensionOf(parameters, variable) + 1;
			} else if ( getDimensionOf(existentialVars, variable) >= 0){
				ipos = getDimensionOf(existentialVars, variable) + 1 + paramSize + inSize + outSize;
			} else {
				System.err.println(inputs);
				System.err.println(outputs);
				System.err.println(parameters);
				throw new RuntimeException("[ISLNativeBinder.getPosition] problem with variable : "+variable+" ("+variable.getClass().getSimpleName()+") in expression :"+t);
			}
		}
		
		return ipos;
	}
	
	//XXX quick and dirty hack !
	private static EList<IntConstraintSystem> convertReductionExpr(EList<IntConstraintSystem> polyhedra) {
		debug("Converting Polyhedra: " + polyhedra);
		EList<IntConstraintSystem> resPoly = new BasicEList<IntConstraintSystem>();

		for(IntConstraintSystem sys : polyhedra) {
			debug("   Converting Sys: " + sys);
			EList<IntConstraint> communSys = new BasicEList<IntConstraint>();
			Map<IntConstraintSystem, IntConstraintSystem> disjonctions = new HashMap<IntConstraintSystem, IntConstraintSystem>();
			
			for(IntConstraint c : sys.getConstraints()) {
				debug("      Converting constraint: " + c);

				if(!_convertSelectInIntConstraint(c, communSys, disjonctions))
					if(!_convertReductionsInIntConstraint(c, communSys, disjonctions))
						communSys.add(c);
			}
			debug("   |=> communSys: " + communSys);
			debug("   |=> disjonctions: " + disjonctions);
			
			if(disjonctions.isEmpty())
				resPoly.add(IntExpressionBuilder.constraintSystem(communSys));
			else {
				// dispatch disjonctions
				for(IntConstraintSystem key : disjonctions.keySet()) {
					IntConstraintSystem val = disjonctions.get(key);
					
					for(IntConstraint c : communSys) {
						key.getConstraints().add(c.copy());
						val.getConstraints().add(c.copy());
					}
					resPoly.add(key);
					resPoly.add(val);
				}
			}
		}
		
		debug("|=>RES: " + resPoly);
		
		return resPoly;
	}

	private static boolean _convertSelectInIntConstraint(IntConstraint c, EList<IntConstraint> communSys, Map<IntConstraintSystem, IntConstraintSystem> disjonctions) {
		if(c.getRhs() instanceof SelectExpression) {
			SelectExpression rhs = (SelectExpression) c.getRhs();
			debug("         Converting SelectExpression: " + rhs);
			
			EList<IntConstraintSystem> conditionSys = convertReductionExpr(rhs.getCondition());
			
//			IntConstraintSystem condition = conditionSys.get(0);
			IntExpression a = rhs.getThen();
			IntExpression b = rhs.getElse();
			
			for(IntConstraintSystem condition : conditionSys) {
				// conditionTrue = condition and x_a
				List<IntConstraint> conditionTrue = new ArrayList<>();
				condition.getConstraints().stream().forEach(ic -> conditionTrue.add(ic.copy()));
				IntConstraint x_a = IntExpressionBuilder.constraint(c.getLhs().copy(), a.copy(), c.getComparisonOperator());
				conditionTrue.add(x_a);
				
				List<IntConstraint> conditionFalse = new ArrayList<>();
				condition.getConstraints().stream()
					.map(ic -> ic.copy()) //copy constraint
					.peek(copy -> copy.setComparisonOperator(ComparisonOperator.getOpposite(c.getComparisonOperator()))) //inverse
					.forEach(copy -> conditionFalse.add(copy));
				IntConstraint x_b = IntExpressionBuilder.constraint(c.getLhs().copy(), b.copy(), c.getComparisonOperator());
				conditionFalse.add(x_b);
				
				disjonctions.put(
						IntExpressionBuilder.constraintSystem(conditionTrue), 
						IntExpressionBuilder.constraintSystem(conditionFalse)
				);
			}
			
			return true;
		}
		return false;
	}

	private static boolean _convertReductionsInIntConstraint(IntConstraint c, EList<IntConstraint> communSys, Map<IntConstraintSystem, IntConstraintSystem> disjonctions) {
		if(c.getRhs() instanceof ReductionExpression && c.getLhs() instanceof ReductionExpression)
			c = RemoveRightSideTransformation.transform(c); //XXX
		
		if(c.getLhs() instanceof ReductionExpression) { 
			//swap lhs <-> rhs
			IntExpression rhs = c.getRhs();
			c.setRhs(c.getLhs());
			c.setLhs(rhs);
			c.setComparisonOperator(ComparisonOperator.negateOperator(c.getComparisonOperator()));
		}
		
		
		if(c.getRhs() instanceof ReductionExpression) {
			ReductionExpression rhs = (ReductionExpression) c.getRhs();
			debug("         Converting Reduction: " + rhs);
			
			boolean noDisjonction = false;
			ReductionOperator operator = rhs.getOperator();
			
//			if(operator == ReductionOperator.SUM) {
//				ReductionExpression red = (ReductionExpression)rhs.copy();
//				List<AffineTerm> aterms = new ArrayList<AffineTerm>();
//				List<QuasiAffineTerm> qterms = new ArrayList<QuasiAffineTerm>();
//				List<ReductionExpression> rterms = new ArrayList<ReductionExpression>();
//				for (IntExpression e : red.getExpressions()) {
//					if(e instanceof ReductionExpression)
//						rterms.add((ReductionExpression) e);
//					else if(e instanceof QuasiAffineExpression)
//						qterms.addAll(((QuasiAffineExpression) e).getTerms());
//					else if(e instanceof AffineExpression )
//						aterms.addAll(((AffineExpression) e).getTerms());
//					else
//						throw new UnsupportedOperationException("Not supported. expr:" + e);
//				}
//				if(rterms.isEmpty()) {
//					if(qterms.isEmpty()) {
////						return IntExpressionBuilder.affine(aterms);
//					}
//					else {
//						for(AffineTerm a : aterms)
//							qterms.add(IntExpressionBuilder.qterm(a));
////						return IntExpressionBuilder.qaffine(qterms);
//					}
//				}
//				else {
//					
//				}
//			}
			
			if(operator == ReductionOperator.MAX) {
				noDisjonction = (c.getComparisonOperator().equals(ComparisonOperator.GE) || c.getComparisonOperator().equals(ComparisonOperator.GT));
			}
			else if(operator == ReductionOperator.MIN) {
				noDisjonction = (c.getComparisonOperator().equals(ComparisonOperator.LE) || c.getComparisonOperator().equals(ComparisonOperator.LT));
			}	
			else {
				return false; //XXX
			}
			
			if(noDisjonction) {
				/* 
				 * x >(=) MAX(a, b, ...) <=> {x >(=) a and x >(=) b and x >(=) ...}
				 * x <(=) MIN(a, b, ...) <=> {x <(=) a and x <(=) b and x <(=) ...} 
				 */
				for(IntExpression expr : rhs.getExpressions()) {
					debug("        expr: " + expr);
					IntConstraint newC = IntExpressionBuilder.constraint(c.getLhs().copy(), expr, c.getComparisonOperator());
					debug("        => " + newC);
					communSys.add(newC); 
				}
			}
			else {
				/*
				 * x <(=) MAX(a, b, ...) <=> {x <(=) a} or {x <(=) b} or ...
				 * x >(=) MIN(a, b, ...) <=> {x >(=) a} or {x >(=) b} or ... 
				 */
				//TODO support non-binary MIN/MAX: convert it to binary
				if(rhs.getExpressions().size() > 2)
					throw new RuntimeException("non-binary MIN/MAX Not yet implemented!");
				
				IntExpression a = rhs.getExpressions().get(0);
				IntExpression b = rhs.getExpressions().get(1);
				IntConstraint x_a = IntExpressionBuilder.constraint(c.getLhs().copy(), a.copy(), c.getComparisonOperator());
				IntConstraint x_b = IntExpressionBuilder.constraint(c.getLhs().copy(), b.copy(), c.getComparisonOperator());
				disjonctions.put(IntExpressionBuilder.constraintSystem(x_a), IntExpressionBuilder.constraintSystem(x_b));
			}
			return true;
		}
		
		return false;
	}
	
	private static void convertAffineExprToMatrix(List<IntConstraint>sys, List<long[]> matrixEq, List<long[]> matrixInEq, 
			List<? extends Variable> inputs, List<? extends Variable> outputs, List<? extends Variable> parameters, 
			List<ExistentialVariable> existentialVars) {
		int ncol = inputs.size() + outputs.size() + parameters.size() + existentialVars.size() + 1;
		List<IntConstraint> processedList = new ArrayList<IntConstraint>();
		
		for (IntConstraint c : sys) {
			
			if (!((c.getLhs() instanceof AffineExpression && c.getRhs() instanceof AffineExpression) || 
				  (c.getLhs() instanceof AffineExpression && c.getRhs() == null) || 
				  (c.getLhs() == null && c.getRhs() instanceof AffineExpression))) {
				continue;
			}
			processedList.add(c);

			AffineExpression lhs = (AffineExpression)c.getLhs();
			AffineExpression rhs = (AffineExpression)c.getRhs();

			if (lhs == null && rhs == null)
				continue;
			
			final int coefMultiplierLHS;
			final int coefMultiplierRHS;
			final int constantOffset;
			
			switch (c.getComparisonOperator()) {
				case EQ:
				case GE:
					coefMultiplierLHS = 1;
					coefMultiplierRHS = -1;
					constantOffset = 0;
					break;
				case GT:
					coefMultiplierLHS = 1;
					coefMultiplierRHS = -1;
					constantOffset = -1;
					break;
				case LE:
					coefMultiplierLHS = -1;
					coefMultiplierRHS = 1;
					constantOffset = 0;
					break;
				case LT:
					coefMultiplierLHS = -1;
					coefMultiplierRHS = 1;
					constantOffset = -1;
					break;
				default:
					throw new RuntimeException("Unhandled operator: " + c.getComparisonOperator());
			}

			long[] row = new long[ncol];
			row[0] = constantOffset;
			if (lhs != null)
				for (AffineTerm t : lhs.getTerms()) {
					int coef = (int)t.getCoef();
					int ipos = getPosition(t, inputs, outputs, parameters, existentialVars);
					row[ipos] += coefMultiplierLHS*coef;
				}
			if (rhs != null)
				for (AffineTerm t : rhs.getTerms()) {
					int coef = (int)t.getCoef();
					int ipos = getPosition(t, inputs, outputs, parameters, existentialVars);
					row[ipos] += coefMultiplierRHS*coef;
				}
			if (c.getComparisonOperator() == ComparisonOperator.EQ) {
				matrixEq.add(row);
			} else {
				matrixInEq.add(row);
			}
		}
		sys.removeAll(processedList);
		
	}

	private static int convertQuasiAffineExprToMatrix(List<IntConstraint>sys, List<long[]> matrixEq, List<long[]> matrixInEq, 
			JNIISLSpace space, List<? extends Variable> inputs, List<? extends Variable> outputs, 
			List<? extends Variable> parameters, List<ExistentialVariable> existentialVars, boolean isMapSpace) {
		int niocol = inputs.size() + outputs.size() + parameters.size() + 1;
		int totalCol = niocol + existentialVars.size();
		List<IntConstraint> processedList = new ArrayList<IntConstraint>();
		JNIISLSpace setSpace = space.copy();
		if ( isMapSpace ) {
			setSpace = space.copy().wrap();
		}
		JNIISLBasicSet bs = JNIISLBasicSet.buildUniverse(setSpace.copy());
		for (IntConstraint c : sys) {
			if (!(c.getLhs() instanceof QuasiAffineExpression || c.getRhs() instanceof QuasiAffineExpression)) 
				continue;
			processedList.add(c);
			JNIISLLocalSpace ls = JNIISLLocalSpace.fromSpace(setSpace.copy());
			JNIISLAff aff = JNIISLAff.buildZero(ls.copy());
			if ( c.getLhs() instanceof QuasiAffineExpression ) {
				aff = handleQuasiAffineExprs((QuasiAffineExpression)c.getLhs(), ls, aff, inputs, outputs, parameters, existentialVars);
			} else if ( c.getLhs() instanceof AffineExpression ) {
				aff = handleAffineExprs((AffineExpression)c.getLhs(), aff, inputs, outputs, parameters, existentialVars);
			}
			else { //ReductionExpression
				System.err.println("FIXME: ISLNativeBinder: ReductionExpression not handled !");
			}
			JNIISLAff aff1 = JNIISLAff.buildZero(ls.copy());
			if ( c.getRhs() instanceof QuasiAffineExpression )
				aff1 = handleQuasiAffineExprs((QuasiAffineExpression)c.getRhs(), ls, aff1, inputs, outputs, parameters, existentialVars);
			else
				aff1 = handleAffineExprs((AffineExpression)c.getRhs(), aff1, inputs, outputs, parameters, existentialVars);
			aff1 = aff1.scale(-1);
			
			aff = aff.add(aff1);
			
			if (c.getComparisonOperator() == ComparisonOperator.EQ) {
				JNIISLConstraint isl_con = aff.copy().toEqualityConstraint();
				bs = bs.addConstraint(isl_con);
			} else {
				if (c.getComparisonOperator() == ComparisonOperator.LE)
					aff = aff.scale(-1);
				JNIISLConstraint isl_con = aff.copy().toInequalityConstraint();
				bs = bs.addConstraint(isl_con);
			}
		}
		JNIISLMatrix meq, mIneq;
		if ( isMapSpace ) {
			JNIISLBasicMap b = bs.unwrap();
			meq = b.getEqualityMatrix(JNIISLDimType.isl_dim_cst, JNIISLDimType.isl_dim_param, JNIISLDimType.isl_dim_in, JNIISLDimType.isl_dim_out, JNIISLDimType.isl_dim_div);
			mIneq = b.getInequalityMatrix(JNIISLDimType.isl_dim_cst, JNIISLDimType.isl_dim_param, JNIISLDimType.isl_dim_in, JNIISLDimType.isl_dim_out, JNIISLDimType.isl_dim_div);
		} else {
			meq = bs.getEqualityMatrix(JNIISLDimType.isl_dim_cst, JNIISLDimType.isl_dim_param, JNIISLDimType.isl_dim_set, JNIISLDimType.isl_dim_div);
			mIneq = bs.getInequalityMatrix(JNIISLDimType.isl_dim_cst, JNIISLDimType.isl_dim_param, JNIISLDimType.isl_dim_set, JNIISLDimType.isl_dim_div);
		}
		int numDiv = meq.getNbCols() - niocol;
		for ( int i = 0; i < meq.getNbRows(); i++ ) {
			long[] row = new long[totalCol + numDiv];
			for ( int j = 0; j < niocol; j++) {
				row[j] = meq.getElement(i, j);
			}
			/* other Divterms wont participate in this */
			for (int j = niocol ; j < totalCol; j++) {
				row[j] = 0;
			}
			/* Divterms of this expression. Output dimension is last and can be ignored*/
			for ( int j = totalCol; j < totalCol + numDiv; j++ ) {
				row[j] = meq.getElement(i, j - totalCol + niocol);
			}
			matrixEq.add(row);
		}
		for ( int i = 0; i < mIneq.getNbRows(); i++ ) {
			long[] row = new long[totalCol + numDiv];
			for ( int j = 0; j < niocol; j++) {
				row[j] = mIneq.getElement(i, j);
			}
			/* other Divterms wont participate in this */
			for (int j = niocol ; j < totalCol; j++) {
				row[j] = 0;
			}
			/* Divterms of this expression. Output dimension is last and can be ignored*/
			for ( int j = totalCol; j < totalCol + numDiv; j++ ) {
				row[j] = mIneq.getElement(i, j - totalCol + niocol);
			}
			matrixInEq.add(row);
		}
		totalCol += numDiv;
		sys.removeAll(processedList);
		return totalCol;
		
	}
	
	public static JNIISLAff handleQuasiAffineExprs (QuasiAffineExpression qaffExpr, JNIISLLocalSpace ls, JNIISLAff aff, List<? extends Variable> inputs, List<? extends Variable> outputs, 
			List<? extends Variable> parameters, List<ExistentialVariable> existentialVars) {
		for (QuasiAffineTerm qt : qaffExpr.getTerms() ) {
			if ( qt instanceof SimpleQuasiAffineTerm) {
				SimpleQuasiAffineTerm st = (SimpleQuasiAffineTerm)qt;
				JNIISLAff aff1 = JNIISLAff.buildZero(ls.copy());
				aff1 = handleSimpleQuasiAffineTerms (st, aff1, inputs, outputs, parameters, existentialVars);
				aff = aff.add(aff1);
			} else {
				NestedQuasiAffineTerm nt = (NestedQuasiAffineTerm)qt;
				JNIISLAff aff1 = JNIISLAff.buildZero(ls.copy());
				aff1 = handleNestedQuasiAffineTerms (nt, aff1, ls, inputs, outputs, parameters, existentialVars);
				aff = aff.add(aff1);
			}
		}
		return aff;
	}
	
	public static JNIISLAff handleAffineExprs(AffineExpression expr, JNIISLAff aff, List<? extends Variable> inputs, List<? extends Variable> outputs, 
			List<? extends Variable> parameters, List<ExistentialVariable> existentialVars) {
		for (AffineTerm t : expr.getTerms()) {
			if (t.getVariable() == null) 
				aff = aff.setConstant((int)t.getCoef());
			else {
				//need to use getXXXDimensionOf, since EList.contains do not call equals.
				int ipos;
				JNIISLDimType type;
				if (getDimensionOf(inputs, t.getVariable()) >= 0) {
					ipos = getDimensionOf(inputs, t.getVariable());
					type = JNIISLDimType.isl_dim_in;
				} else if (getDimensionOf(outputs, t.getVariable()) >= 0) {
					ipos = getDimensionOf(outputs, t.getVariable()) + inputs.size();
					type = JNIISLDimType.isl_dim_in; 
				} else if (getDimensionOf(parameters, t.getVariable()) >= 0) {
					ipos = getDimensionOf(parameters, t.getVariable());
					type = JNIISLDimType.isl_dim_param;
				} else if (getDimensionOf(existentialVars, t.getVariable()) >= 0)  {
					ipos = getDimensionOf(existentialVars, t.getVariable());
					type = JNIISLDimType.isl_dim_div;
				} else {
					throw new RuntimeException("problem with variable : "+t.getVariable()+" ("+t.getVariable().getClass().getSimpleName()+") in expression :"+expr);
				}
				aff = aff.setCoefficient(type, ipos, (int)t.getCoef());
			}
		}
		return aff;
	}
	
	private static JNIISLBasicMap jniIslBasicMapNoString(List<IntConstraint> constraints,
			JNIISLSpace space, List<? extends Variable> params, List<? extends Variable> inputs, List<? extends Variable> outputs, List<ExistentialVariable> existential) {
		JNIISLContext ctx = JNIISLContext.getCtx();
		List<long[]> matrixEq = new ArrayList<>();
		List<long[]> matrixInEq = new ArrayList<>();
		List<IntConstraint> sys = new ArrayList<IntConstraint>();
		sys.addAll(constraints);
		convertReductionExpr(sys);
		
		convertAffineExprToMatrix(sys, matrixEq, matrixInEq, inputs, outputs, params, existential);
		
		int totalCol = convertQuasiAffineExprToMatrix(sys, matrixEq, matrixInEq, space, inputs, outputs, params, existential, true);
		
//		convertOtherExprToMatrix(sys, matrixEq, matrixInEq, inputs, outputs, params, existential);
		
		JNIISLMatrix jniIslMatrixEq = JNIISLMatrix.build(ctx, matrixEq.size(), totalCol);
		JNIISLMatrix jniIslMatrixInEq = JNIISLMatrix.build(ctx, matrixInEq.size(), totalCol);
		int currRowEq = 0;
		int currRowInEq = 0;
		for ( long[] row : matrixEq ) {
			for ( int i = 0; i < totalCol; i++  ) {
				if ( i < row.length )
					jniIslMatrixEq = jniIslMatrixEq.setElement(currRowEq, i, row[i]);
				else
					jniIslMatrixEq = jniIslMatrixEq.setElement(currRowEq, i, 0);
			}
			currRowEq++;
		}
		for ( long[] row : matrixInEq ) {
			for ( int i = 0; i < totalCol; i++  ) {
				if ( i < row.length )
					jniIslMatrixInEq = jniIslMatrixInEq.setElement(currRowInEq, i, row[i]);
				else
					jniIslMatrixInEq = jniIslMatrixInEq.setElement(currRowInEq, i, 0);
			}
			currRowInEq++;
		}
		JNIISLBasicMap bmap = JNIISLBasicMap.fromConstraintMatrices(space.copy(), jniIslMatrixEq, jniIslMatrixInEq, JNIISLDimType.isl_dim_cst, JNIISLDimType.isl_dim_param, JNIISLDimType.isl_dim_in, JNIISLDimType.isl_dim_out, JNIISLDimType.isl_dim_div);
		return bmap;
	}
	

//	private static void convertOtherExprToMatrix(List<IntConstraint> sys,
//			List<int[]> matrixEq, List<int[]> matrixInEq,
//			List<? extends Variable> inputs, List<? extends Variable> outputs,
//			List<? extends Variable> params,
//			List<ExistentialVariable> existential) {
//		for (IntConstraint c : sys) {
//			IntExpression lhs = c.getLhs();
//			IntExpression rhs = c.getRhs();
//			AffineExpression aff_lhs = convertToAffExpr(lhs);
//			AffineExpression aff_rhs = convertToAffExpr(rhs);
//			if ( aff_lhs == null || aff_rhs == null ) {
//				throw new UnsupportedOperationException("Only affine and QuasiAffine Expressions are handled."
//						+ " LHS and RHS types + " + c.getLhs().getClass() + "  " + c.getRhs());
//			}
//			IntConstraint newCons = IntExpressionBuilder.constraint(aff_lhs, aff_rhs, c.getComparisonOperator());
//			List<IntConstraint> list = new ArrayList<IntConstraint>();
//			list.add(newCons);
//			convertAffineExprToMatrix(list, matrixEq, matrixInEq, inputs, outputs, params, existential);
//			
//		}
//	}
	
	private static void convertReductionExpr(List<IntConstraint> sys) {
		for (IntConstraint c : sys) {
			IntExpression lhs = c.getLhs();
			IntExpression rhs = c.getRhs();
			IntExpression aff_lhs = convertReductionToAffOrQaffExpr(lhs);
			IntExpression aff_rhs = convertReductionToAffOrQaffExpr(rhs);
			if ( aff_lhs == null || aff_rhs == null ) {
				throw new UnsupportedOperationException("Couldn't convert Reduction Expressions: " + c.getLhs() + "  and/or  " + c.getRhs());
			}
			IntConstraint newCons = IntExpressionBuilder.constraint(aff_lhs, aff_rhs, c.getComparisonOperator());
			sys.set(sys.indexOf(c), newCons);
		}
	}

	private static IntExpression convertReductionToAffOrQaffExpr(IntExpression lhs) {
		if (! (lhs instanceof ReductionExpression))
			return lhs; 
				
		if(((ReductionExpression)lhs).getOperator() != ReductionOperator.SUM)
			throw new UnsupportedOperationException("Reduction Expressions other than SUM are not supported yet! expr:" + lhs);
		
		ReductionExpression red = (ReductionExpression)lhs.copy();
		List<AffineTerm> aterms = new ArrayList<AffineTerm>();
		List<QuasiAffineTerm> qterms = new ArrayList<QuasiAffineTerm>();
		for (IntExpression e : red.getExpressions()) {
			IntExpression ne = e;
			if(e instanceof ReductionExpression)
				ne = convertReductionToAffOrQaffExpr(e);
			
			if(ne instanceof QuasiAffineExpression) {
				qterms.addAll(((QuasiAffineExpression) ne).getTerms());
			}
			else if(ne instanceof AffineExpression ) {
				aterms.addAll(((AffineExpression) ne).getTerms());
			} 
			else {
				throw new UnsupportedOperationException("Not supported. expr:" + ne);
			}
		}
		
		if(!qterms.isEmpty()) {
			for(AffineTerm a : aterms)
				qterms.add(IntExpressionBuilder.qterm(a));
			
			return IntExpressionBuilder.qaffine(qterms);
		}
		return IntExpressionBuilder.affine(aterms);
	}

	private static JNIISLBasicMap jniIslBasicMapNoString(List<IntConstraint> sys,
			JNIISLSpace space, RelationDimensions dims) {
		return jniIslBasicMapNoString(sys, space, dims.getParameters(), dims.getInputs(), dims.getOutputs(), dims.getExistential());
	} 
	
	public static JNIISLUnionMap jniIslUnionMap(AbstractRelation map) {
		String s = PolymodelPrettyPrinter.print(map, OUTPUT_FORMAT.ISL);
		return ISLFactory.islUnionMap(s);
	}

	public static JNIISLUnionMap jniIslUnionMap(ISLUnionMap umap) {
		JNIISLUnionMap res = null;
		for (ISLMap map : umap.getMaps()) {
			JNIISLMap jmap = jniIslMapNoString(map);
			if (res == null) res = jmap.toUnionMap();
			else res = res.union(jmap.toUnionMap());
		}
		if (res == null) {
			throw new RuntimeException();
		}
		return res;
	}

	public static JNIISLUnionSet jniIslUnionSet(ISLUnionSet uset) {
		JNIISLUnionSet res = null;
		for (ISLSet set : uset.getSets()) {
			JNIISLSet jset = jniIslSet(set);
			if (res == null) res = jset.toUnionSet();
			else res = res.union(jset.toUnionSet());
		}
		if (res == null) {
			throw new RuntimeException();
		}
		return res;
	}

	public static JNIISLPoint jniIslPoint(ISLPoint point) {
		return null;
	}

	public static ISLPoint point(JNIISLPoint p) {
		ISLPoint point = IslFactory.eINSTANCE.createISLPoint();
		point.getCoordinates().addAll(p.getCoordinates());
		return point;
	}


	public static ISLSet islSet(JNIISLSet set,DomainDimensions dimensions) {
		return islSet(set, dimensions.getIndices(), dimensions.getParameters());
	}
	
	public static ISLSet islSet(JNIISLBasicSet bset, List<? extends Variable> indices,
			List<? extends Variable> parameters) {
		JNIISLSet set = bset.toSet();
		return islSet(set, indices, parameters);
	}
	
	public static ISLSet islSet(JNIISLBasicSet bset,
			DomainDimensions dimensions) {
		JNIISLSet set = bset.toSet();
		return islSet(set,dimensions.getIndices(), dimensions.getParameters());
	}
	
	public static ISLSet islSet(JNIISLSet set, DimensionsManager dim) {
		List<Variable> indices = new ArrayList<Variable>(set.getNbDims());
		List<Variable> parameters = new ArrayList<Variable>(set.getNbParams());
		
		for (int i = 0; i < set.getNbDims(); i++) {
			indices.add(dim.getDimension(i, set.getIndicesNames().get(i)));
		}
		for (int i = 0; i < set.getNbParams(); i++) {
			parameters.add(dim.getParameter(i, set.getParametersNames().get(i)));
		}

		return islSet(set, indices, parameters);
	}
	
	public static <T extends ISLSet> T islSet(JNIISLSet set, List<? extends Variable> indices,
			List<? extends Variable> parameters) {
		JNIISLSet newSet = set.copy().computeDivs();
		if (newSet == null)
			System.out.println(set);
		List<IntConstraintSystem> polyhedra = new ArrayList<IntConstraintSystem>();
		List<ExistentialVariable> divTerms = new ArrayList<ExistentialVariable>();
		//empty domains do not have any basic sets
		if (newSet.isEmpty()) {
			polyhedra.add(IntExpressionBuilder.constraintSystem(
					IntExpressionBuilder.constraint(IntExpressionBuilder.constant(1), IntExpressionBuilder.constant(0), ComparisonOperator.EQ)));
		} else {
			List<JNIISLBasicSet> basicSets = newSet.getBasicSets();
			for (JNIISLBasicSet jniislBasicSet : basicSets) {
				IntConstraintSystem intConstraintSystem = intConstraintSystem(jniislBasicSet, indices, parameters, divTerms);
				polyhedra.add(intConstraintSystem);
			}
		}
		
			T result = factory().createDomain(indices, parameters, divTerms, polyhedra);
		if (newSet.getTupleName() != null) {
			result.setLabel(factory().createLabel(newSet.getTupleName()));
		}
		
		newSet.free();

		return result;
	} 
	
	
	
	
	public static IntConstraintSystem intConstraintSystem(JNIISLBasicSet set,
			List<? extends Variable> inputs, List<? extends Variable> parameters, List<ExistentialVariable> existentialVars) {
		List<OutputDimension> outputs = new ArrayList<OutputDimension>();
		List<IntConstraint> constraints = new ArrayList<IntConstraint>();
	
		JNIISLMatrix matrix = set.getEqualityMatrix(JNIISLDimType.isl_dim_cst, JNIISLDimType.isl_dim_param, JNIISLDimType.isl_dim_set, 
				JNIISLDimType.isl_dim_div);
		long divPos = (set.getSpace().getNbDims(JNIISLDimType.isl_dim_set) + set.getSpace().getNbDims(JNIISLDimType.isl_dim_param) + 1);
		//populateDivTerms(matrix, (int) divPos, inputs, outputs, parameters, existentialVars);
		int numDiv = (int)(matrix.getNbCols() - divPos);
		populateDivTermsLocalSpace(set, (int) numDiv, inputs, outputs, parameters, existentialVars);
			
		for ( int i = 0; i < matrix.getNbRows(); i++ ) {
			IntConstraint c = constraint(matrix, i, inputs, outputs, parameters, existentialVars, true);
			constraints.add(c);
		}

		matrix = set.getInequalityMatrix(JNIISLDimType.isl_dim_cst, JNIISLDimType.isl_dim_param, 
					JNIISLDimType.isl_dim_set, JNIISLDimType.isl_dim_div);

		for ( int i = 0; i < matrix.getNbRows(); i++ ) {
			IntConstraint c = constraint(matrix, i, inputs, outputs, parameters, existentialVars, false);
			constraints.add(c);
		}
		
		IntConstraintSystem system = IntExpressionBuilder.constraintSystem(constraints); 
		return system;
	}
	
	/*public static <T extends ISLSet> T islSet(JNIISLSet set, List<? extends Variable> indices,
			List<? extends Variable> parameters) {
		List<IntConstraintSystem> polyhedra = new ArrayList<IntConstraintSystem>();
		//empty domains do not have any basic sets
		if (set.isEmpty() == 1) {
			polyhedra.add(IntExpressionBuilder.constraintSystem(
					IntExpressionBuilder.constraint(IntExpressionBuilder.constant(1), IntExpressionBuilder.constant(0), ComparisonOperator.EQ)));
		} else {
			List<JNIISLBasicSet> basicSets = set.getBasicSets();
			for (JNIISLBasicSet jniislBasicSet : basicSets) {
				IntConstraintSystem intConstraintSystem = intConstraintSystem(
						jniislBasicSet.getConstraints(), new ArrayList<Variable>(),indices, parameters);
						//jniislBasicSet.getConstraints(), indices,indices, parameters);
				polyhedra.add(intConstraintSystem);
			}
		}
		T result = factory().createDomain(indices, parameters, polyhedra);
		if (set.getTupleName() != null) {
			result.setLabel(factory().createLabel(set.getTupleName()));
		}
		return result;
	} */

	

	private static PolymodelDefaultFactory factory() {
		return PolymodelComponent.INSTANCE
				.getFactory(ISLPolymodelModule.INSTANCE);
	}
	
	public static ISLMap islMap(JNIISLMap map, DimensionsManager manager) {
		List<Variable> inputVars = getDimensionVariables(map.getDomainNames(), manager);
		List<Variable> outputVars = getDimensionVariables(map.getRangeNames(), manager);
		List<Variable> params = getParameterVariables(map.getParametersNames(), manager);
				
		List<InputDimension> inputs = manager.getInputsDimensionsFor(inputVars);
		List<OutputDimension> outputs = manager.getOutputsDimensionsFor(outputVars);
		
		
		return islMap(map, inputs, outputs, params);
	}


	public static <T extends AbstractRelation> T islMap(JNIISLMap map, List<InputDimension> inputs,
			List<OutputDimension> outputs, List<Variable> parameters) {
		List<ExistentialVariable> existentialVars = new ArrayList<ExistentialVariable>();
		RelationDimensions createRelationDimensions = factory().createRelationDimensions(inputs, outputs, parameters, existentialVars);
		T relation = factory().createRelation(createRelationDimensions);
//		Label a = factory().createLabel("");
//		a.copy();
//		relation.getBasicRelations();
		if (!map.isEmpty()) 
			for (JNIISLBasicMap bmap : map.getBasicMaps()) {
				ISLBasicMap islBasicMap = islBasicMap(bmap, inputs, outputs,parameters, relation.getDimensions().getExistential());
				relation.getBasicRelations().add(islBasicMap);
			}
		else {
			ISLBasicMap emptyBasicRelation = emptyBasicRelation();
			String inName = map.getTupleName(JNIISLDimType.isl_dim_in);
			if (inName != null) emptyBasicRelation.setIn(factory().createLabel(inName));
			String outName = map.getTupleName(JNIISLDimType.isl_dim_out);
			if (outName != null) emptyBasicRelation.setOut(factory().createLabel(outName ));
			relation.getBasicRelations().add(emptyBasicRelation);
		}
		return relation;
	}

	public static ISLBasicMap emptyBasicRelation() {
		IntConstraint c = IntExpressionBuilder.constraint(
				IntExpressionBuilder.constant(0), 
				IntExpressionBuilder.constant(1), 
				ComparisonOperator.EQ);
		IntConstraintSystem system = IntExpressionBuilder.constraintSystem(c);
		ISLBasicMap result = factory().createBasicRelation(
				IntExpressionBuilder.constraintSystem(), 
				IntExpressionBuilder.constraintSystem(),
				system);
		
		return result;
	}
	
	private static boolean isInputConstraint(JNIISLMatrix matrix, int i, int inSize, int outSize, int paramSize) {
		for ( int j = 1 + paramSize + inSize; j < 1 + paramSize + inSize + outSize; j++) {
			long coef = matrix.getElement(i, j);
			if ( coef != 0)
				return false;
		}
		return true;
	}
	
	private static boolean isOutputConstraint(JNIISLMatrix matrix, int i, int inSize, int outSize, int paramSize) {
		for ( int j = 1 + paramSize; j < 1 + paramSize + inSize; j++) {
			long coef = matrix.getElement(i, j);
			if ( coef != 0)
				return false;
		}
		return true;
	}
	
	private static void populateDivTermsLocalSpace(JNIISLBasicSet set, int numDiv, List<? extends Variable> inputs,
			List<OutputDimension> outputs, List<? extends Variable> parameters,
			List<ExistentialVariable> existentialVars) {
//		List<QuasiAffineTerm> divTerms = new ArrayList<QuasiAffineTerm>();
		//if ( numDiv != set.copy().getConstraintAt(0).copy().getNbDim(JNIISLDimType.isl_dim_div) )
		//	throw new UnsupportedOperationException("We do not handle if the there are existential variables defined per constraint");

		for ( int i = 0; i < numDiv; i++ ) {
			ExistentialVariable e;
			if (existentialVars.size() > i)
				e = existentialVars.get(i);
			else  {
				String name = "e"+i;
				e = factory().createExistentialVariable(name);
			}
			JNIISLAff aff = set.copy().getConstraintAt(0).getDivAt(i);
			AffineExpression expr = convertToAffineExpr(aff, inputs, outputs, parameters, existentialVars);
			SimpleQuasiAffineTerm tmp = QuasiAffineFactory.eINSTANCE
						.createSimpleQuasiAffineTerm();
			tmp.setOperator(QuasiAffineOperator.FLOOR);
			tmp.setCoef(aff.getDenominator());
			tmp.setExpression(expr);
			IntExpression def = IntExpressionBuilder.qaffine(tmp);
			e.setDefinition(def);
			existentialVars.add(e);
		}
		
	}

	/**
	 * I believe this method works with isl_val, but not thoroughly tested.
	 * 
	 * @param aff
	 * @param inputs
	 * @param outputs
	 * @param parameters
	 * @param existentialVars
	 * @return
	 */
	private static AffineExpression convertToAffineExpr(JNIISLAff aff,
			List<? extends Variable> inputs, List<OutputDimension> outputs,
			List<? extends Variable> parameters, List<ExistentialVariable> existentialVars) {
		
		List<AffineTerm> list = new ArrayList<AffineTerm>();
		for ( int col = 0; col < aff.getNbDims(JNIISLDimType.isl_dim_in); col++) {
			long coef = aff.getNumerator(JNIISLDimType.isl_dim_in, col); 
			if ( coef  == 0)
				continue;
			Variable var = inputs.get(col);
			AffineTerm term = IntExpressionBuilder.term(coef, var);
			list.add(term);
		}
		for ( int col = 0; col < aff.getNbDims(JNIISLDimType.isl_dim_param); col++) {
			long coef = aff.getNumerator(JNIISLDimType.isl_dim_param, col);
			if ( coef  == 0)
				continue;
			Variable var = parameters.get(col);
			AffineTerm term = IntExpressionBuilder.term(coef, var);
			list.add(term);
		}
		for ( int col = 0; col < aff.getNbDims(JNIISLDimType.isl_dim_div); col++) {
			long coef = aff.getNumerator(JNIISLDimType.isl_dim_div, col);
			if ( coef  == 0)
				continue;
			Variable var = existentialVars.get(col);
			AffineTerm term = IntExpressionBuilder.term(coef, var);
			list.add(term);
		}
		if (!aff.getConstantVal().isZero()) {
			AffineTerm term = IntExpressionBuilder.term(aff.getConstantVal().getNumerator());
			list.add(term);
		}
		AffineExpression expr = IntExpressionBuilder.affine(list);
		return expr;
	}

	private static void populateDivTerms(JNIISLMatrix matrix, int divStartPos, List<? extends Variable> inputs, List<OutputDimension> outputs,
			List<? extends Variable> parameters, List<ExistentialVariable> existential) {
		/* Sort the rows of matrix so as to avoid multiple passes or recursion when creating quasi-affine terms*/
		int numDiv = matrix.getNbCols() - divStartPos; 
		int[] divOrder = new int[numDiv];
		int[] divProcessed = new int[numDiv];
		int[] divIndex = new int[numDiv];
		int currentOrderIndex = 0; 
		int numDivDef = 0;
		List<QuasiAffineTerm> divTerms = new ArrayList<QuasiAffineTerm>();
		for ( int i = 0; i < numDiv; i++ ) {
			String name = "e"+i;
			ExistentialVariable e = factory().createExistentialVariable(name);
			existential.add(e);
		}

		/* Find the order in which DivTerms have to be visited */
		for ( int i = 0; i < numDiv; i++ ) {
			divOrder[i] = -1; divProcessed[i] = -1; divIndex[i] = -1;
			divTerms.add(null);
		}    
		while ( currentOrderIndex < numDiv ) {
			boolean changes = false;
			for (int i = 0; i < matrix.getNbRows(); i++) {
				int numDivs = 0; 
				int indexDiv = -1;
				for ( int j = divStartPos; j < matrix.getNbCols(); j++) {
					long coef = matrix.getElement(i, j);
					if ( coef != 0) { 
						if ( divProcessed[j-divStartPos] == -1) {
							numDivs++;
							indexDiv = j - divStartPos;
						}    
					}    
				}    
				if ( numDivs == 1 ) {
					/* If there is only one unprocessed Div add it to the divOrder List */
					divProcessed[indexDiv] = 1; 
					divOrder[currentOrderIndex] = i; 
					divIndex[currentOrderIndex] = indexDiv;
					currentOrderIndex++;
					changes = true;
					numDivDef++;
				}    
			}
			if ( !changes && (currentOrderIndex < numDiv)) {
			//	throw new RuntimeException("can not find definition of " + (numDiv - currentOrderIndex) +  
				//		" Div Variables");
				break;
			}
		}    

		for ( int i = 0; i < numDivDef; i++) {
			int row = divOrder[i];
			int index = divIndex[i];
			List<AffineTerm> list = new ArrayList<AffineTerm>();
			for ( int col = 0; col < matrix.getNbCols(); col++) {
				if ( col == (index + divStartPos) )
					continue;
				long coef = matrix.getElement(row, col);
				if ( coef == 0)
					continue;
				if ( col == 0 ) {
					AffineTerm cstTerm = IntExpressionBuilder.term(coef);
					list.add(cstTerm);
				} else if ( col < (parameters.size() + 1)) {
					Variable var = parameters.get(col-1);
					AffineTerm term = IntExpressionBuilder.term(coef, var);
					list.add(term); 
				} else if ( col < (parameters.size() + 1) + inputs.size() ) {
					Variable var = inputs.get(col-1-parameters.size());
					AffineTerm term = IntExpressionBuilder.term(coef, var);
					list.add(term);
				} else if ( col < (parameters.size() + 1) + inputs.size() + outputs.size()) {
					Variable var = outputs.get(col-1-parameters.size()-inputs.size());
					AffineTerm term = IntExpressionBuilder.term(coef, var);
					list.add(term);
				} else {
					Variable var = existential.get(col-1-parameters.size()-inputs.size()-outputs.size());
					AffineTerm term = IntExpressionBuilder.term(coef, var);
					list.add(term);
				}
			}
			long coef = matrix.getElement(row, index+divStartPos);
			AffineExpression expr = IntExpressionBuilder.affine(list);
			SimpleQuasiAffineTerm tmp = QuasiAffineFactory.eINSTANCE
						.createSimpleQuasiAffineTerm();
			tmp.setOperator(QuasiAffineOperator.FLOOR);
			tmp.setCoef(coef);
			tmp.setExpression(expr);
			IntExpression def = IntExpressionBuilder.qaffine(tmp);
			existential.get(index).setDefinition(def);
		}
		

	}
            

	
	
	public static ISLBasicMap islBasicMap(JNIISLBasicMap map,
			List<InputDimension> inputs, List<OutputDimension> outputs,
			List<Variable> parameters, List<ExistentialVariable> existentialVars) {
		List<IntConstraint> inConstraints = new ArrayList<IntConstraint>();
		List<IntConstraint> outConstraints = new ArrayList<IntConstraint>();
		List<IntConstraint> relationConstraints = new ArrayList<IntConstraint>();
		
		JNIISLMatrix matrix = map.getEqualityMatrix(JNIISLDimType.isl_dim_cst, JNIISLDimType.isl_dim_param, JNIISLDimType.isl_dim_in, 
				JNIISLDimType.isl_dim_out, JNIISLDimType.isl_dim_div);
		long divPos = map.getSpace().getNbDims(JNIISLDimType.isl_dim_param) + map.getSpace().getNbDims(JNIISLDimType.isl_dim_in) + 
				map.getSpace().getNbDims(JNIISLDimType.isl_dim_out) + 1; 
		populateDivTerms(matrix, (int)divPos, inputs, outputs, parameters, existentialVars);
			
		for ( int i = 0; i < matrix.getNbRows(); i++ ) {
			IntConstraint c = constraint(matrix, i, inputs, outputs, parameters, existentialVars, true);
			if ( isInputConstraint(matrix, i, inputs.size(), outputs.size(), parameters.size()) ) {
				inConstraints.add(c);
			} else if ( isOutputConstraint(matrix, i, inputs.size(), outputs.size(), parameters.size())) {
				outConstraints.add(c);
			} else {
				relationConstraints.add(c);
			}
		}
		
		matrix = map.getInequalityMatrix(JNIISLDimType.isl_dim_cst, JNIISLDimType.isl_dim_param, JNIISLDimType.isl_dim_in, 
				JNIISLDimType.isl_dim_out, JNIISLDimType.isl_dim_div);
		for ( int i = 0; i < matrix.getNbRows(); i++ ) {
			IntConstraint c = constraint(matrix, i, inputs, outputs, parameters, existentialVars, false);
			if ( isInputConstraint(matrix, i, inputs.size(), outputs.size(), parameters.size()) ) {
				inConstraints.add(c);
			} else if ( isOutputConstraint(matrix, i, inputs.size(), outputs.size(), parameters.size())) {
				outConstraints.add(c);
			} else {
				relationConstraints.add(c);
			}
		}
		
		IntConstraintSystem inSystem = IntExpressionBuilder.constraintSystem(inConstraints); 
		IntConstraintSystem outSystem = IntExpressionBuilder.constraintSystem(outConstraints);
		IntConstraintSystem relationSystem = IntExpressionBuilder.constraintSystem(relationConstraints);
		
		ISLBasicMap result = factory().createBasicRelation(inSystem, outSystem,
				relationSystem);
		Label inLbl = factory().createLabel(
				map.getTupleName(JNIISLDimType.isl_dim_in));
		Label outLbl = factory().createLabel(
				map.getTupleName(JNIISLDimType.isl_dim_out));
		if (inLbl.getName() != null && inLbl.getName().length() > 0)
			result.setIn(inLbl);
		if (outLbl.getName() != null && outLbl.getName().length() > 0)
			result.setOut(outLbl);
		return result;
	}

	
	public static ISLUnionMap islUnionMap(List<ISLMap> maps) {
		ISLUnionMap umap = IslFactory.eINSTANCE.createISLUnionMap();
		
		umap.getMaps().addAll(maps);
		
		return umap;
	}
	
	public static ISLUnionMap islUnionMap(JNIISLUnionMap jniumap, DimensionsManager manager) {
		ISLUnionMap umap = IslFactory.eINSTANCE.createISLUnionMap();
		
		for (JNIISLMap jnimap : jniumap.getMaps()) {
			ISLMap map = islMap(jnimap, manager);
			umap.getMaps().add(map);
		}
		
		return umap;
	}
	
	/**
	 * Creates a ISLFunction from the given isl_map and dimensions/parameters.
	 * The isl_map has to be singleValued and convex.
	 * @param function
	 * @param inputs
	 * @param outputs
	 * @param params
	 * @return
	 */
	public static <T extends Function> T islFunction(JNIISLMap function, List<? extends Variable> inputs,
			List<? extends OutputDimension> outputs, List<? extends Variable> params, String in, String out) {
		if (!function.isSingleValued()) {
			throw new IllegalArgumentException(function+" is not a function (it is not single valued).");
		}
		if (function.getNbBasicMaps() > 1) {
			throw new IllegalArgumentException(function+" is not convex.");
		}
		if (function.isEmpty()) {
			return emptyFunction(inputs, outputs, params);
		}
		
		JNIISLBasicMap func = function.getBasicMapAt(0);
		
		
		Map<JNIISLSet, JNIISLMultiAff> closedFormRelation = func.getClosedFormRelation();
		if (closedFormRelation.size() != 1) {
			throw new RuntimeException("Function is not convex or not single valued (or both).");
		}
		JNIISLSet set = closedFormRelation.keySet().iterator().next();
		if (set.getNbBasicSets() != 1)
			throw new RuntimeException("Function is empty.");
		JNIISLBasicSet bset = set.getBasicSetAt(0);
		if (!bset.isUniverse()) {
			throw new RuntimeException(function+" has validity domain.");
		}
		
		
		JNIISLMultiAff jniislMultiAff = closedFormRelation.get(set);
		List<IntExpression> list = exprList(jniislMultiAff, inputs, params);
		
		T res = factory().createFunction(inputs, outputs, params,list,in,out);
		
		return res;
	}
	
	/**
	 * Builds a list of expressions from given isl_multi_affine. The expressions
	 * in the multi_aff should be function of given inputs/params.
	 * 
	 * @param maff
	 * @param inputs
	 * @param params
	 * @return
	 */
	public static List<IntExpression> exprList(JNIISLMultiAff maff, List<? extends Variable> inputs,
			List<? extends Variable> params) {
		List<IntExpression> list = new ArrayList<IntExpression>();
		for (JNIISLAff aff : maff.getAffs()) {
			IntExpression expr = aff(aff, inputs, params).simplify();
			list.add(expr.simplify());
		}
		return list;
	}
	
	//TODO
	private static <T extends Function> T emptyFunction(List<? extends Variable> inputs,
			List<? extends OutputDimension> outputs, List<? extends Variable> params) {
		throw new UnsupportedOperationException("Unimplemented yet.");
	}

	/*public static ISLBasicMap islBasicMap(JNIISLBasicMap map,
				List<InputDimension> inputs, List<OutputDimension> outputs,
				List<Variable> parameters) {
			List<Variable> indices = new ArrayList<Variable>();
			indices.addAll(inputs);
			indices.addAll(outputs);
	
			List<JNIISLConstraint> inConstraints = new ArrayList<JNIISLConstraint>();
			List<JNIISLConstraint> outConstraints = new ArrayList<JNIISLConstraint>();
			List<JNIISLConstraint> relationConstraints = new ArrayList<JNIISLConstraint>();
			for (JNIISLConstraint c : map.getConstraints()) {
				if (isInputConstraint(c, inputs, outputs))
					inConstraints.add(c);
				else if (isOutputConstraint(c, inputs, outputs)) {
					outConstraints.add(c);
				} else {
					relationConstraints.add(c);
				}
			}
	
			IntConstraintSystem inSystem = intConstraintSystem(inConstraints,
					inputs, outputs, parameters);
			IntConstraintSystem outSystem = intConstraintSystem(outConstraints,
					inputs, outputs, parameters);
			IntConstraintSystem relationSystem = intConstraintSystem(
					relationConstraints, inputs, outputs, parameters);
			ISLBasicMap result = factory().createBasicRelation(inSystem, outSystem,
					relationSystem);
			Label inLbl = factory().createLabel(
					map.getTupleName(JNIISLDimType.isl_dim_in));
			Label outLbl = factory().createLabel(
					map.getTupleName(JNIISLDimType.isl_dim_out));
			if (inLbl.getName() != null && inLbl.getName().length() > 0)
				result.setIn(inLbl);
			if (outLbl.getName() != null && outLbl.getName().length() > 0)
				result.setOut(outLbl);
			return result;
		} */
	
	public static IntConstraint constraint(JNIISLMatrix matrix, int row, List<? extends Variable> inputs, List<OutputDimension> outputs,
			List<? extends Variable> parameters, List<ExistentialVariable> existentialVars, boolean equality) {
		List<AffineTerm> list = new ArrayList<AffineTerm>();
		List<QuasiAffineTerm> qlist = new ArrayList<QuasiAffineTerm>();
		
		for ( int col = 0; col < matrix.getNbCols(); col++) {
			long coef = matrix.getElement(row, col);
			if ( coef == 0)
				continue;
			if ( col == 0 ) {
				AffineTerm cstTerm = IntExpressionBuilder.term(coef);
				list.add(cstTerm);
			} else if ( col < (parameters.size() + 1)) {
				Variable var = parameters.get(col-1);
				AffineTerm term = IntExpressionBuilder.term(coef, var);
				list.add(term);
			} else if ( col < (parameters.size() + 1) + inputs.size() ) {
				Variable var = inputs.get(col-1-parameters.size());
				AffineTerm term = IntExpressionBuilder.term(coef, var);
				list.add(term);
			} else if ( col < (parameters.size() + 1) + inputs.size() + outputs.size()) {
				Variable var = outputs.get(col-1-parameters.size()-inputs.size());
				AffineTerm term = IntExpressionBuilder.term(coef, var);
				list.add(term);
			} else {
//				int index = 
//						(col-1-parameters.size()-inputs.size()-outputs.size());
				Variable var = existentialVars.get(col-1-parameters.size()-inputs.size()-outputs.size());
				AffineTerm term = IntExpressionBuilder.term(coef, var);
				list.add(term);
				/*if ( existentialVars.get(index).getDefinition() == null ) {
					Variable var = existentialVars.get(col-1-parameters.size()-inputs.size()-outputs.size());
					AffineTerm term = IntExpressionBuilder.term(coef, var);
					list.add(term);
				} else {
					IntExpression e = existentialVars.get(index).getDefinition().copy();
					QuasiAffineTerm t = IntExpressionBuilder.qterm(QuasiAffineOperator.MUL, (QuasiAffineExpression)e, coef);
					qlist.add(t);
				} */
			}
			
		}
		IntConstraint res = AlgebraFactory.eINSTANCE.createIntConstraint();
		res.setComparisonOperator(equality?ComparisonOperator.EQ:ComparisonOperator.GE);
		res.setRhs(IntExpressionBuilder.affine(IntExpressionBuilder.term(0)));
		
		if (list.size() == 0) {
			list.add(IntExpressionBuilder.term(0));
		}

		AffineExpression expr = IntExpressionBuilder.affine(list);
		if ( !qlist.isEmpty() ) {
			QuasiAffineTerm t = IntExpressionBuilder.qterm(QuasiAffineOperator.MUL, expr, 1);
			qlist.add(t);
			QuasiAffineExpression qexpr = IntExpressionBuilder.qaffine(qlist);
			res.setLhs(qexpr);
		} else {
			res.setLhs(expr);
		}
		return res;
	}
	
//	public static IntConstraint constraint(JNIISLConstraint constraint,
//			List<? extends Variable> inputs, List<? extends Variable> outputs,
//			List<? extends Variable> parameters) {
//
//		List<AffineTerm> list = new ArrayList<AffineTerm>();
//		
//
//		// 1. get constant
//		long cst = constraint.getConstant();
//		if (cst != 0) {
//			AffineTerm cstTerm = IntExpressionBuilder.term(cst);
//			list.add(cstTerm);
//		}
//
//		// 2.1. inspect variables "out"
//		int n = constraint.getNbDims(JNIISLDimType.isl_dim_out);
//		for (int i = 0; i < n; i++) {
//			long c = constraint.getCoefficientAt(JNIISLDimType.isl_dim_out, i);
//			if (c != 0) {
//				Variable var = outputs.get(i);
//				AffineTerm term = IntExpressionBuilder.term(c, var);
//				list.add(term);
//			}
//		}
//
//		// 2.2. inspect variables "in"
//		n = constraint.getNbDims(JNIISLDimType.isl_dim_in);
//		for (int i = 0; i < n; i++) {
//			long c = constraint.getCoefficientAt(JNIISLDimType.isl_dim_in, i);
//			if (c != 0) {
//				Variable var = inputs.get(i);
//				AffineTerm term = IntExpressionBuilder.term(c, var);
//				list.add(term);
//			}
//		}
//
//		// 3. inspect parameters
//		n = constraint.getNbDims(JNIISLDimType.isl_dim_param);
//		for (int i = 0; i < n; i++) {
//			long c = constraint.getCoefficientAt(JNIISLDimType.isl_dim_param, i);
//			if (c != 0) {
//				Variable var = parameters.get(i);
//				AffineTerm term = IntExpressionBuilder.term(c, var);
//				list.add(term);
//			}
//		}
//
//		// 4. inspect divs
//		n = constraint.getNbDims(JNIISLDimType.isl_dim_div);
//		int nbDivs = n;
//		List<QuasiAffineTerm> qlist = new ArrayList<QuasiAffineTerm>(n);
//		for (int i = 0; i < n; i++) {
//			long c = constraint.getCoefficientAt(JNIISLDimType.isl_dim_div, i);
//			if (c != 0) {
//				JNIISLAff child = constraint.getDivAt(i);
//				QuasiAffineTerm divTerm = div(child, /*inputs, /*/outputs,
//						parameters);
//
//				// if coef != 1, embed term in an MUL QuasiAffineExpression
//				if (c != 1) {
//					QuasiAffineExpression expr = IntExpressionBuilder
//							.qaffine(divTerm);
//					NestedQuasiAffineTerm tmp = QuasiAffineFactory.eINSTANCE
//							.createNestedQuasiAffineTerm();
//					tmp.setCoef(c);
//					tmp.setOperator(QuasiAffineOperator.MUL);
//					tmp.setExpression(expr);
//					divTerm = tmp;
//				}
//
//				qlist.add(divTerm);
//			} else {
//				nbDivs--;
//			}
//		}
//
//		IntConstraint res = AlgebraFactory.eINSTANCE.createIntConstraint();
//		res.setComparisonOperator((!constraint.isEquality())? 
//				ComparisonOperator.GE:
//				ComparisonOperator.EQ);
//		res.setRhs(IntExpressionBuilder.affine(IntExpressionBuilder.term(0)));
//
//		if (nbDivs > 0) {
//			QuasiAffineExpression expr = IntExpressionBuilder.qaffine(qlist);
//			for (AffineTerm t : list) {
//				expr.getTerms().add(IntExpressionBuilder.qterm(t));
//			}
//			res.setLhs(expr);
//		} else {
//			AffineExpression expr = IntExpressionBuilder.affine(list);
//			res.setLhs(expr);
//		}
//
//		return res;
//	}

	public static QuasiAffineTerm div(JNIISLAff div,
			List<? extends Variable> variables, // List<? extends Variable> outputs,
			List<? extends Variable> parameters) {
		if (variables.size() == 0) {
			System.err.println("problem");
			System.err.println(div);
			System.err.println(variables);
			throw new RuntimeException(""+div);
		}
		QuasiAffineTerm res;

		List<AffineTerm> list = new ArrayList<AffineTerm>();

		// 0. get denominator
		long denom =div.getDenominator();
		// 1. get constant
		
		long cst = div.getConstantVal().getNumerator();
		if (cst != 0) {
			AffineTerm cstTerm = IntExpressionBuilder.term(cst);
			list.add(cstTerm);
		}

		// 2.1. inspect variables "out"
//		int n = div.getNbDim(JNIISLDimType.isl_dim_out);
//		for (int i = 0; i < n; i++) {
//			int c = div.getCoefficientAt(JNIISLDimType.isl_dim_out, i);
//			if (c != 0) {
//				Variable var = outputs.get(i);
//				AffineTerm term = IntExpressionBuilder.term(c, var);
//				list.add(term);
//			}
//		}

		// 2.2. inspect variables "in"
		int n = div.getNbDims(JNIISLDimType.isl_dim_in);
		for (int i = 0; i < n; i++) {
			JNIISLVal cval = div.getCoefficientVal(JNIISLDimType.isl_dim_in, i);
			long c = getValidCoefficient(div, denom, cval);
			if (c != 0) {
				Variable var = variables.get(i);
				AffineTerm term = IntExpressionBuilder.term(c, var);
				list.add(term);
			}
		}

		// 3. inspect parameters
		n = div.getNbDims(JNIISLDimType.isl_dim_param);
		for (int i = 0; i < n; i++) {
			JNIISLVal cval = div.getCoefficientVal(JNIISLDimType.isl_dim_param, i);
			long c = getValidCoefficient(div, denom, cval);
			if (c != 0) {
				Variable var = parameters.get(i);
				AffineTerm term = IntExpressionBuilder.term(c, var);
				list.add(term);
			}
		}

		// 4. inspect divs
		n = div.getNbDims(JNIISLDimType.isl_dim_div);
		int nbDivs = n;
		List<QuasiAffineTerm> qlist = new ArrayList<QuasiAffineTerm>(n);
		for (int i = 0; i < n; i++) {
			long c = div.getCoefficientVal(JNIISLDimType.isl_dim_div, i).asLong();
			if (c != 0) {
				JNIISLAff child = div.copy().getDiv(i);
				QuasiAffineTerm divTerm = div(child, variables, //outputs,
						parameters);

				// if coef != 1, embed term in an MUL QuasiAffineExpression
				if (c != 1) {
					QuasiAffineExpression expr = IntExpressionBuilder
							.qaffine(divTerm);
					NestedQuasiAffineTerm tmp = QuasiAffineFactory.eINSTANCE
							.createNestedQuasiAffineTerm();
					tmp.setCoef(c);
					tmp.setOperator(QuasiAffineOperator.MUL);
					tmp.setExpression(expr);
					divTerm = tmp;
				}

				qlist.add(divTerm);
			} else {
				nbDivs--;
			}
		}

		// 5. get denominator
		long denum = div.getDenominator();

		// 6. build term depending on the number of divs
		if (nbDivs > 0) {
			NestedQuasiAffineTerm tmp = QuasiAffineFactory.eINSTANCE
					.createNestedQuasiAffineTerm();
			tmp.setOperator(QuasiAffineOperator.FLOOR);
			tmp.setCoef(denum);
			QuasiAffineExpression expr = IntExpressionBuilder.qaffine(qlist);
			for (AffineTerm t : list) {
				expr.getTerms().add(IntExpressionBuilder.qterm(t));
			}
			tmp.setExpression(expr);
			res = tmp;
		} else {
			SimpleQuasiAffineTerm tmp = QuasiAffineFactory.eINSTANCE
					.createSimpleQuasiAffineTerm();
			tmp.setOperator(QuasiAffineOperator.FLOOR);
			tmp.setCoef(denum);
			tmp.setExpression(IntExpressionBuilder.affine(list));
			res = tmp;
		}

		return res;
	}

	private static long getValidCoefficient(JNIISLAff div, long denom, JNIISLVal cval) {
		long c = 0;
		if(cval.isRational() && (cval.getNumerator()!=0)) {
			long denominator = cval.getDenominator();
			if (denominator==denom) {
				c= cval.getNumerator();
			} else {
				if((denom % denominator)==0) {
					c= cval.getNumerator() * (denom/denominator);
				} else {
					throw new UnsupportedOperationException("JNIISLAff "+div+ " with several distinct denominator values");
					
				}
			}
			
		} else {
			c = cval.asLong();
		}
		return c;
	}

	public static QuasiAffineExpression aff(JNIISLAff aff,
			List<? extends Variable> variables, // List<? extends Variable> outputs,
			List<? extends Variable> parameters) {
		QuasiAffineExpression res = QuasiAffineFactory.eINSTANCE
				.createQuasiAffineExpression();
		// 1. inspect divs
		int nbDivs = aff.getNbDims(JNIISLDimType.isl_dim_div);
		for (int i = 0; i < nbDivs; i++) {
			long c = aff.getCoefficientVal(JNIISLDimType.isl_dim_div, i).asLong();
			if (c != 0) {
				JNIISLAff child = aff.getDiv(i);
				QuasiAffineTerm divTerm = div(child, variables, //outputs,
						parameters);

				// if coef != 1, embed term in an MUL QuasiAffineExpression
				if (c != 1) {
					QuasiAffineExpression expr = IntExpressionBuilder
							.qaffine(divTerm);
					NestedQuasiAffineTerm tmp = QuasiAffineFactory.eINSTANCE
							.createNestedQuasiAffineTerm();
					tmp.setCoef(c);
					tmp.setOperator(QuasiAffineOperator.MUL);
					tmp.setExpression(expr);
					divTerm = tmp;
				}

				res.getTerms().add(divTerm);
			}
		}

		// 2.1. inspect variables "in"
		int nbVarsIn = aff.getNbDims(JNIISLDimType.isl_dim_in);
		for (int i = 0; i < nbVarsIn; i++) {
			long c = aff.getCoefficientVal(JNIISLDimType.isl_dim_in, i).asLong();
			if (c != 0) {
				Variable var = variables.get(i);
				QuasiAffineTerm term = IntExpressionBuilder.mul(
						IntExpressionBuilder.affine(IntExpressionBuilder.term(
								c, var)), 1);
				res.getTerms().add(term);
			}
		}

		// 2.2. inspect variables "out"
//		int nbVarsOut = aff.getNbDim(JNIISLDimType.isl_dim_out);
//		for (int i = 0; i < nbVarsOut; i++) {
//			int c = aff.getCoefficientAt(JNIISLDimType.isl_dim_out, i);
//			if (c != 0) {
//				Variable var = outputs.get(i);
//				QuasiAffineTerm term = IntExpressionBuilder.mul(
//						IntExpressionBuilder.affine(IntExpressionBuilder.term(
//								c, var)), 1);
//				res.getTerms().add(term);
//			}
//		}

		// 3. inspect parameters
		int nbParams = aff.getNbDims(JNIISLDimType.isl_dim_param);
		for (int i = 0; i < nbParams; i++) {
			long c = aff.getCoefficientVal(JNIISLDimType.isl_dim_param, i).asLong();
			if (c != 0) {
				Variable var = parameters.get(i);
				QuasiAffineTerm term = IntExpressionBuilder.mul(
						IntExpressionBuilder.affine(IntExpressionBuilder.term(
								c, var)), 1);
				res.getTerms().add(term);
			}
		}

		// 4. get constant
		long cst = aff.getConstant();
		if (cst != 0 || res.getTerms().size() == 0) {
			QuasiAffineTerm cstTerm = IntExpressionBuilder
					.mul(IntExpressionBuilder.affine(IntExpressionBuilder
							.term(cst)), 1);
			res.getTerms().add(cstTerm);
		}

		// 5. simplify
		// res = res.simplify();

		return res;
	}

//	public static IntConstraintSystem intConstraintSystem(
//			List<JNIISLConstraint> constraints,
//			List<? extends Variable> inputs, List<? extends Variable> outputs,
//			List<? extends Variable> parameters) {
//		List<IntConstraint> res = new ArrayList<IntConstraint>();
//		for (JNIISLConstraint c : constraints) {
//			IntConstraint ic = constraint(c, inputs, outputs, parameters);
//			res.add(ic);
//		}
//		return IntExpressionBuilder.constraintSystem(res);
//	}

//	public static IntConstraintSystem intConstraintSystem(
//			List<JNIISLConstraint> constraints,
//			List<? extends Variable> dimensions,
//			List<? extends Variable> parameters) {
//		return intConstraintSystem(constraints, new ArrayList<Variable>(),
//				dimensions, parameters);
//	}

	public static Map<ISLSet, List<IntExpression>> mapping(
			JNIISLBasicMap bmap, List<? extends Variable> vars, //List<Variable> output,
			List<? extends Variable> parameters) {
		Map<ISLSet, List<IntExpression>> res = new LinkedHashMap<ISLSet, List<IntExpression>>();
		Map<JNIISLSet, JNIISLMultiAff> map = bmap.getClosedFormRelation();
		for (Entry<JNIISLSet, JNIISLMultiAff> entry : map.entrySet()) {
			List<IntExpression> list = exprList(entry.getValue(),vars, parameters);
				//new ArrayList<IntExpression>();
//			for (JNIISLAffine aff : entry.getValue().getAffines()) {
//				IntExpression expr = aff(aff, vars, parameters).simplify();
//				list.add(expr.simplify());
//			}
			ISLSet islSet = islSet(entry.getKey(),vars,parameters);
			res.put(islSet, list);
		}
		return res;
	}

	static boolean isInputConstraint(JNIISLConstraint c,
			List<InputDimension> inputs, List<OutputDimension> outputs) {
		for (int i = 0; i < outputs.size(); i++) {
			if (c.getCoefficientAt(JNIISLDimType.isl_dim_out, i) != 0)
				return false;
		}
		return true;
	}

	static boolean isOutputConstraint(JNIISLConstraint c,
			List<InputDimension> inputs, List<OutputDimension> outputs) {
		for (int i = 0; i < inputs.size(); i++) {
			if (c.getCoefficientAt(JNIISLDimType.isl_dim_in, i) != 0)
				return false;
		}
		return true;
	}
	
	public static PolynomialExpression polynomial(JNIISLQPolynomial poly, DomainDimensions dims) {
		
		if (poly == null) {
			return IntExpressionBuilder.polynomial(IntExpressionBuilder.pterm(0, 1, IntExpressionBuilder.pvar(null, 0)));
		}
		
		List<PolynomialTerm> terms = new ArrayList<PolynomialTerm>(poly.getNbTerms());		
		
		for (int i = 0; i < poly.getNbTerms(); i++) {
			JNIISLTerm term = poly.getTermAt(i);
			long numerator = term.getNumerator();
			long denominator = term.getDenominator();
			
			List<PolynomialVariable> pvars = new LinkedList<PolynomialVariable>();
			
			for (int p = 0; p < term.getNbDims(JNIISLDimType.isl_dim_param); p++) {
				int exp = poly.getExponentAt(i, JNIISLDimType.isl_dim_param, p);
				if (exp != 0) {
					pvars.add(IntExpressionBuilder.pvar(dims.getParameters().get(p), exp));
				}
			}
			for (int x = 0; x < term.getNbDims(JNIISLDimType.isl_dim_set); x++) {
				int exp = poly.getExponentAt(i, JNIISLDimType.isl_dim_set, x);
				if (exp != 0) {
					pvars.add(IntExpressionBuilder.pvar(dims.getIndices().get(x), exp));
				}
			}
			
			terms.add(IntExpressionBuilder.pterm(numerator, denominator, pvars));
		}

		return IntExpressionBuilder.polynomial(terms);
	}
}
