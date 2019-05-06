package org.polymodel.polyhedralIR.recurrence.bis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ExternalFunctionDeclaration;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.SIGNED;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.VariableIdentifier;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.IntegerExpression;
import org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;

import tom.library.sl.VisitFailure;


public class SimplifyCoefficient {

	
	/**
	 * Not safe to call for arbitrary expression. The given
	 * expression should not contain restrict or reduce,
	 * to avoid simplifications that modify domains.
	 */
	public static Expression simplify(Expression expr){
		try {
			SimplifyCoefficient s = new SimplifyCoefficient();
			return (Expression)s.apply(expr);
		} catch (VisitFailure vf) {
			return expr;
		}
	}
 
	protected SimplifyCoefficient(){} 

	protected EObject apply(Expression o) throws VisitFailure {
		o = `InnermostId(SimplifyCoef()).visitLight(o, tom.mapping.GenericIntrospector.INSTANCE);
		return o;
	} 
 
	%include { sl.tom } 
	%include { polyhedralIR.tom }
	
	%strategy SimplifyCoef() extends Identity() {
		visit Expression {
		

			//add by identity
			expr@binAdd(intConst(0L), rexpr) -> { return `rexpr; }
			expr@binAdd(lexpr, intConst(0L)) -> { return `lexpr; }
			
			expr@binAdd(intConst(x), intConst(y)) -> { return `intConst(x+y); }
			
			//mult by identity
			expr@binMul(intConst(1L), rexpr) -> { return `rexpr; }
			expr@binMul(lexpr, intConst(1L)) -> { return `lexpr; }

			expr@binMul(intConst(x), intConst(y)) -> { return `intConst(x * y); }
			
			//mult by 0
			expr@binMul(intConst(0L), rexpr) -> { return `intConst(0L); }
			expr@binMul(lexpr, intConst(0L)) -> { return `intConst(0L); }
		}
		
	}


	
}