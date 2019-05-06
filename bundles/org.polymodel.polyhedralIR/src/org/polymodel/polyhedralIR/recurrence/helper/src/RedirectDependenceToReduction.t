package org.polymodel.polyhedralIR.recurrence.helper;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.BasicEList;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ExternalFunctionDeclaration;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.SIGNED;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.VariableIdentifier;
import org.polymodel.polyhedralIR.expression.*;
import org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;

//import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;

import tom.library.sl.VisitFailure;

public class RedirectDependenceToReduction {

	protected final VariableDeclaration reduceVar;
	protected final VariableDeclaration originalVar;
	protected final AffineFunction projection;

	public static void apply(AffineSystem system, VariableDeclaration reduceVar, VariableDeclaration originalVar, AffineFunction projection) {
		RedirectDependenceToReduction rdtr = new RedirectDependenceToReduction(reduceVar, originalVar, projection);
		rdtr.apply(system);
	}

	protected RedirectDependenceToReduction(VariableDeclaration redVar, VariableDeclaration origVar, AffineFunction proj) {
		reduceVar = redVar;
		originalVar = origVar;
		projection = proj;
	}

	protected void apply(AffineSystem system) {
		try {
			`BottomUp(replace(reduceVar, originalVar, projection)).visitLight(system, tom.mapping.GenericIntrospector.INSTANCE);
		} catch (VisitFailure e) {
			e.printStackTrace();
		}
	}
 
	%include { sl.tom } 
	%include { polyhedralIR.tom }
	
	%strategy replace(redVar : VariableDeclaration, origVar : VariableDeclaration, proj : AffineFunction) extends Identity() {
		visit Expression {
			depExpr@depExpr(f, var(v)) ->{
				if (`v.equals(origVar)) {
					return `depExpr(proj.compose(f), var(redVar));
				} else {
					return `depExpr;
				}
			}
		}
	}


}