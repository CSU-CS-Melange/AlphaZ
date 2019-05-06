package org.polymodel.polyhedralIR.transformation;

import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.algebra.ComparisonOperator;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.isl.ISLSet;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.ExternalFunctionDeclaration;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.SIGNED;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.VariableIdentifier;
import org.polymodel.polyhedralIR.expression.CaseExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.IndexExpression;
import org.polymodel.polyhedralIR.expression.IntegerExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.MultiArgExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import tom.mapping.introspectors.polyhedralIR.expression.ExpressionIntrospector;
import org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations;

import tom.library.sl.VisitFailure;

public class ExtractMultiArgExpressions extends PolyhedralIRTomTransformation {

	private static boolean modified = false;

	public static void apply(Program p){
		ExtractMultiArgExpressions s = new ExtractMultiArgExpressions();
		s.transform(p);
	}

	public static void apply(AffineSystem as){
		ExtractMultiArgExpressions s = new ExtractMultiArgExpressions();
		s.transform(as);
	}

	public static void apply(StandardEquation eq){
		ExtractMultiArgExpressions s = new ExtractMultiArgExpressions();
		s.transform(eq);
	}
 
	protected ExtractMultiArgExpressions(){} 

	@Override
	protected EObject apply(EObject o) throws VisitFailure {
		modified = true;
		while (modified) {
			modified = false;
			o = `InnermostId(ExtractMultiArg()).visitLight(o, tom.mapping.GenericIntrospector.INSTANCE);
		}
		return o;
	} 
 
	%include { sl.tom } 
	%include { polyhedralIR.tom }
	
	%strategy ExtractMultiArg() extends Identity() {
		visit Expression {
			
			expr@binOp(op, marg@multOp(op, exprs), rexpr) -> {
					(`exprs).add(`rexpr); 
					return `marg; }
			expr@binOp(op, lexpr, marg@multOp(op, exprs)) -> {
					(`exprs).add(0, `lexpr); 
					return `marg; }

			expr@binAdd(binAdd(exprA, exprB), rexpr) -> { return `multOp(OP.ADD, exprList(exprA, exprB, rexpr)); }
			expr@binAdd(lexpr, binAdd(exprA, exprB)) -> { return `multOp(OP.ADD, exprList(lexpr, exprA, exprB)); }
			
			expr@multOp(op, exprList(exprA*, multOp(op, exprs), exprB*)) -> { 
				return `multOp(op, mergeExprs(exprA, exprs, exprB));
			}
			expr@multOp(op, exprList(exprA*, binOp(op, lexpr, rexpr), exprB*)) -> { 
				return `multOp(op, mergeExprs(exprA, lexpr, rexpr, exprB));
			}
			
			//not really legal to do it for multiply without checking operator precedence
			//expr@binMul(binMul(exprA, exprB), rexpr) -> { return `multOp(OP.MUL, exprList(exprA, exprB, rexpr)); }
			//expr@binMul(lexpr, binMul(exprA, exprB)) -> { return `multOp(OP.MUL, exprList(lexpr, exprA, exprB)); }
		}
		
	}

	public static EList<Expression> mergeExprs(EList<Expression> listA, EList<Expression> listB, EList<Expression> listC) {
		listA.addAll(listB);
		listA.addAll(listC);
		return listA;
	}

	public static EList<Expression> mergeExprs(EList<Expression> listA, Expression exprA, Expression exprB, EList<Expression> listC) {
		listA.add(exprA);
		listA.add(exprB);
		listA.addAll(listC);
		return listA;
	}
}