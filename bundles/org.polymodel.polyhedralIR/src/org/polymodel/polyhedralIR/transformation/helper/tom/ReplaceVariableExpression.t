package org.polymodel.polyhedralIR.transformation.helper;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.PolyhedralIRFactory;
import org.polymodel.polyhedralIR.ExternalFunctionDeclaration;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.VariableIdentifier;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.transformation.PolyhedralIRTomTransformation;
import tom.library.sl.VisitFailure;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.SIGNED;
import org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;

/**
  Replaces every occurrence of VariableExpression with target as its referred variable 
   to VariableExpression that referres to variable replace.

  This is a helper transformation that should only be used in another transformation.
  Applying this transformation on its own is likely to break problem semantics.
 
*/
public class ReplaceVariableExpression extends PolyhedralIRTomTransformation {

private static long one = 1;

	protected final VariableDeclaration _target;
	protected final VariableDeclaration _replace;
	protected final boolean _onExpression;

	/**
	  Replaces VariableExpressions refering to target Variable with VariableExpressions to replace.
	  This transformation by itself will change the semantics of the Program.
	**/
	public static void transform(VariableDeclaration target, VariableDeclaration replace){
		ReplaceVariableExpression rve = new ReplaceVariableExpression(target, replace, false);
		rve.transform((AffineSystem)target.eContainer());
	}
	
	/**
	  Replaces VariableExpressions refering to target Variable with VariableExpressions to replace (on an expression).
	  This transformation by itself will change the semantics of the Program.
	**/
	public static void transform(Expression expr, VariableDeclaration target, VariableDeclaration replace) {
		ReplaceVariableExpression rve = new ReplaceVariableExpression(target, replace, true);
		rve.transform(expr);
	}
	
	protected ReplaceVariableExpression(VariableDeclaration target, VariableDeclaration replace, boolean onExpr) {
		_target = target;
		_replace = replace;
		_onExpression = onExpr;
	}

	@Override
	protected EObject apply(EObject o) throws VisitFailure {
		try{
			EObject t;
			if (_onExpression)
				t =	`BottomUp(Replace(_target, _replace)).visitLight((Expression)o, tom.mapping.GenericIntrospector.INSTANCE);
			else
				t =	`BottomUp(Replace(_target, _replace)).visitLight((AffineSystem)o, tom.mapping.GenericIntrospector.INSTANCE);
			return t;
		} catch(ClassCastException e) {
			if (_onExpression)
				throw new IllegalArgumentException(o+ "isn't an Expression");
			else
				throw new IllegalArgumentException(o+ "isn't an AffineSystem");
		}
	}
 
	%include { sl.tom } 
	%include { polyhedralIR.tom }
	
	%strategy Replace(target : VariableDeclaration, replace : VariableDeclaration) extends Identity() {
		visit Expression {
			v@var(decl) -> {
				if (`decl.equals(target)) {
					return `var(replace);
				} else {
					return `v;
				}
			}
		}
	}


}