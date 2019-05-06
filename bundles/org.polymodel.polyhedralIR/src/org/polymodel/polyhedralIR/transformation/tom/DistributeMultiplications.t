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
import org.polymodel.polyhedralIR.expression.RealExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.MultiArgExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.expression.UnaryExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;



import tom.library.sl.VisitFailure;

public class DistributeMultiplications extends PolyhedralIRTomTransformation {

	public static void apply(Program p){
		DistributeMultiplications s = new DistributeMultiplications();
		s.transform(p);
	}

	public static void apply(AffineSystem as){
		DistributeMultiplications s = new DistributeMultiplications();
		s.transform(as);
	}

	public static void apply(StandardEquation eq){
		DistributeMultiplications s = new DistributeMultiplications();
		s.transform(eq);
	}
 
	protected DistributeMultiplications(){} 

	@Override
	protected EObject apply(EObject o) throws VisitFailure {
		
		o = `InnermostId(NormalizeBinarySubtractions()).visitLight(o, tom.mapping.GenericIntrospector.INSTANCE);
		o = `InnermostId(PropagateUnaryMinus()).visitLight(o, tom.mapping.GenericIntrospector.INSTANCE);
		o = `InnermostId(DistributeMults()).visitLight(o, tom.mapping.GenericIntrospector.INSTANCE);
		return o;
	} 
 
	%include { sl.tom } 
	%include { polyhedralIR.tom }

	%strategy NormalizeBinarySubtractions() extends Identity() {
		visit Expression {
			
			expr@binSub(exprA, exprB) -> {
				return `binAdd(exprA, unaryMinus(exprB));
			}
		}
		
	}

	%strategy PropagateUnaryMinus() extends Identity() {
		visit Expression {
			unaryMinus(unaryMinus(expr)) -> {
				return `expr;
			}
			unaryMinus(binOp(op, lexpr, rexpr)) -> {
				return `binOp(op, unaryMinus(lexpr), unaryMinus(rexpr));
			}
			binMul(unaryMinus(lexpr), unaryMinus(rexpr)) -> {
				return `binMul(lexpr, rexpr);
			}
			unaryMinus(depExpr(f, intConst(val))) -> {
				return `depExpr(f, intConst(-val));
			}
			unaryMinus(depExpr(f, realConst(val))) -> {
				return `depExpr(f, realConst(-val));
			}
		}
	}
	
	%strategy DistributeMults() extends Identity() {
		visit Expression {
			
			expr@binMul(distExpr, binAdd(exprA, exprB)) -> {
			//System.err.println(PolyhedralIRToAlphabets.toSimplifiedString(`expr));
					Expression distExprCopy = `distExpr.copy();
					return `binAdd(binMul(distExpr, exprA), binMul(distExprCopy, exprB)); }
					
		}
		
	}

/*		S3[t,i,j] = case
			{ | i==0 && j-1>=0 && t-1>=0 } : S3[t-1,i,j] - 0.699999988079071 * (S2[t,i,j+1] - S2 + S1[t,i+1,j] - S0[t,j]) ;
			{ | t-1>=0 && j-1>=0 && i-1>=0 } : S3[t-1,i,j] - 0.699999988079071 * (S2[t,i,j+1] - S2 + S1[t,i+1,j] - S1) ;
			{ | j==0 && i==0 && t-1>=0 } : S3[t-1,i,j] - 0.699999988079071 * (S2[t,i,j+1] - ex[i,j] + S1[t,i+1,j] - S0[t,j]) ;
			{ | j==0 && i-1>=0 && t-1>=0 } : S3[t-1,i,j] - 0.699999988079071 * (S2[t,i,j+1] - ex[i,j] + S1[t,i+1,j] - S1) ;
			{ | i==0 && t==0 && j-1>=0 } : hz[i,j] - 0.699999988079071 * (S2[t,i,j+1] - S2 + S1[t,i+1,j] - S0[t,j]) ;
			{ | t==0 && j-1>=0 && i-1>=0 } : hz[i,j] - 0.699999988079071 * (S2[t,i,j+1] - S2 + S1[t,i+1,j] - S1) ;
			{ | j==0 && i==0 && t==0 } : hz[i,j] - 0.699999988079071 * (S2[t,i,j+1] - ex[i,j] + S1[t,i+1,j] - S0[t,j]) ;
			{ | j==0 && t==0 && i-1>=0 } : hz[i,j] - 0.699999988079071 * (S2[t,i,j+1] - ex[i,j] + S1[t,i+1,j] - S1) ;
		esac;
*/
}