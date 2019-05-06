package org.polymodel.polyhedralIR.transformation;

import org.polymodel.Function;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.impl.PolyhedralIRInheritedDepthFirstVisitorImpl;

public class UniformizeInContext extends PolyhedralIRInheritedDepthFirstVisitorImpl {
	
	private final boolean excludeInputs;
	
	public static void apply(Program program) {
		apply(program, false);
	}
	
	public static void apply(Program program, boolean excludeInputs) {
		for (AffineSystem system : program.getSystems()) {
			apply(system, excludeInputs);
		}
	}
	
	public static void apply(AffineSystem system) {
		apply(system, false);
	}
	
	public static void apply(AffineSystem system, boolean excludeInputs) {
		system.accept(new UniformizeInContext(excludeInputs));
	}
	
	
	protected UniformizeInContext(boolean excludeInputs) {
		this.excludeInputs = excludeInputs;
	}
	
	
	@Override
	public void outDependenceExpression(DependenceExpression d) {
		if (excludeInputs && d.getExpr() instanceof VariableExpression) {
			if (((VariableExpression)d.getExpr()).getVarDecl().isInput()) {
				return;
			}
		}
		Function uniformized = d.getDep().getPMmapping().uniformizeInContext(d.getContextDomain().getPMdomain());
		d.getDep().setPMmapping(uniformized);
	}

}
