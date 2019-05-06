package org.polymodel.polyhedralIR.transformation.helper;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.polymodel.DomainDimensions;
import org.polymodel.algebra.Variable;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.FastISLMap;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.expression.BooleanExpression;
import org.polymodel.polyhedralIR.expression.ConstantExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.IntegerExpression;
import org.polymodel.polyhedralIR.expression.RealExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;

/**
 * Some helpful functions to manage constant expressions without having to differentiate between
 * 	their different kinds (boolean, real, integer)
 * 
 * @author giooss
 */
public class ConstantExpressionHelper {
	private static final PolyhedralIRUserFactory _polyIRFact = PolyhedralIRUserFactory.eINSTANCE;
	
	/**
	 * Build a constant expression, in a uniformed way.
	 * Add a dependence expression "(i->)" in front of it if "nInds>0"
	 * 
	 * @param value
	 * @param type
	 * @param lParams
	 * @param nInds
	 * @return
	 */
	public static Expression buildConstantExpression(double value, Type type, List<Variable> lParams, int nInds) {
		
		Expression exprConst = null;
		if (type.getTypeID()==DATATYPE.BOOL)
			exprConst = _polyIRFact.createBooleanExpression((value!=0));
		if (type.getTypeID()==DATATYPE.INTEGER)
			exprConst = _polyIRFact.createIntegerExpression((long) value);
		if (type.getTypeID()==DATATYPE.FLOATING_POINT)
			exprConst = _polyIRFact.createRealExpression(value);
		if (exprConst==null)
			throw new RuntimeException("buildConstantExpression : type of the expression unknown (or not managed)");
		
		if (nInds==0)
			return exprConst;
		else {
			// We add a dependence expression of the form (\vec{i}->) in front of the constant expression to make it
			//		of the same dimension of "expr"
			List<Variable> lInds = new BasicEList<Variable>();
			for (int k=0; k<nInds; k++)
				lInds.add(PolymodelComponent.INSTANCE.getDefaultDimensionsManager().getDimension(k));
			DomainDimensions domDimsDepConst = PolymodelComponent.INSTANCE.getFactory().createDomainDimensions(lInds, lParams);
			
			FastISLMap depConst = _polyIRFact.createFastISLMap(domDimsDepConst, new BasicEList<String>());
			return _polyIRFact.createDependenceExpression(depConst, exprConst);
		}
	}
	
	/**
	 * Return the "doubled" value of a dep+const expression
	 * 		Real => return its value
	 * 		Boolean => 1.0 if true, 0.0 if false
	 * 		Integer => return its value, converted to double
	 * 
	 * @param expr
	 * @return
	 */
	public static double getDoubledValue(Expression expr) {
		if (expr instanceof DependenceExpression)
			return getDoubledValue(((DependenceExpression) expr).getExpr());
		
		if (expr instanceof ConstantExpression) {
			if (expr instanceof BooleanExpression)
				return (((BooleanExpression) expr).isValue())?1:0;
			if (expr instanceof IntegerExpression)
				return ((IntegerExpression) expr).getValue();
			if (expr instanceof RealExpression)
				return ((RealExpression) expr).getValue();
			throw new RuntimeException("getDoubledValue : type of the expression unknown (or not managed)");
		}
		throw new RuntimeException("getDoubleValue : only appliable on constant expression or (dependence of)^* constant expression");
	}
	
	/**
	 * Return true is the expression is a succession of dependences, then a constant
	 * @param expr
	 * @return
	 */
	public static boolean isConstantExpressionAfterDep(Expression expr) {
		if (expr instanceof DependenceExpression)
			return isConstantExpressionAfterDep(((DependenceExpression) expr).getExpr());
		if (expr instanceof IntegerExpression)
			return true;
		if (expr instanceof RealExpression)
			return true;
		if (expr instanceof BooleanExpression)
			return true;
		return false;
	}
	
} // ConstantExpressionHelper
