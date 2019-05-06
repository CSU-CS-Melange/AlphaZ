package org.polymodel.polyhedralIR.transformation.helper;

import org.eclipse.emf.common.util.EList; 
import org.eclipse.emf.ecore.EObject;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.ExternalFunctionDeclaration;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.VariableIdentifier;
import org.polymodel.polyhedralIR.transformation.PolyhedralIRTomTransformation;
import tom.library.sl.VisitFailure;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.SIGNED;
import org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;

public class ReplaceUniqueExpression extends PolyhedralIRTomTransformation {
	protected final Expression _target;
	protected final Expression _replace;
	protected static boolean _foundAtLeastOnce;
	
	public static void replace(AffineSystem syst, Expression target, Expression replace){
		_foundAtLeastOnce = false;
		
		ReplaceUniqueExpression al = new ReplaceUniqueExpression(target, replace);
		al.transform(syst);
		if (!_foundAtLeastOnce)
			throw new RuntimeException("AddLocalTomEqual: expression " + target.toString() + " not found.");
	}
	
	protected ReplaceUniqueExpression(Expression target, Expression replace) {
		_target = target;
		_replace = replace;
	}
	
	@Override
	protected EObject apply(EObject o) throws VisitFailure {
		try{
		EObject t =	`TopDown(ReplaceExpr(_target, _replace)).visitLight((AffineSystem)o, tom.mapping.GenericIntrospector.INSTANCE);
			return t;
		} catch(ClassCastException e) {
			e.printStackTrace();
			
			throw new IllegalArgumentException(o+ "isn't an Affine System");
		}
	}
	
	%include { sl.tom }
	%include { polyhedralIR.tom }
	
	%strategy ReplaceExpr(target : Expression, replace : Expression) extends Identity() {
		visit Expression {
			context@_ -> { if (target.equals(`context)) {
							_foundAtLeastOnce = true;
							return `replace.copy();
						}
				}
		}
	}
} // ReplaceUniqueExpression
