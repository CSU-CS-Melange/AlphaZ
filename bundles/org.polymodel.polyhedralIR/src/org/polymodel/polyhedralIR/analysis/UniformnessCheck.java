package org.polymodel.polyhedralIR.analysis;

import java.util.ArrayList;
import java.util.List;

import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.transformation.UniformizeInContext;
import org.polymodel.prdg.PRDG;

/**
 * This analysis checks if a given system is SURE.
 * The analysis operates on the PRDG of the system.
 * 
 * The analysis also gives additional information such as:
 *  - the dependence rank of a dependence f = Ax+b; rank(I-A) for each edge
 *  - the maximum subset of dimensions that are uniform 
 * 
 * @author yuki
 *
 */
public class UniformnessCheck {

	

	public static UniformnessResult apply(AffineSystem system) {
		UniformnessCheck check = new UniformnessCheck(system, true);
		return check.run();
	}

	protected final AffineSystem targetSystem;
	protected final boolean noInputs;
	
	protected UniformnessCheck(AffineSystem targetSystem, boolean noInputs) {
		this.targetSystem = targetSystem.copy();
		this.noInputs = noInputs;
	}
	
	private UniformnessResult run() {
		//check dimensions of programs before creating PRDG  
		List<VariableDeclaration> variables = new ArrayList<VariableDeclaration>(
				targetSystem.getLocals().size() + targetSystem.getOutputs().size() + (noInputs?0:targetSystem.getInputs().size())
			);
		
		if (!noInputs) variables.addAll(targetSystem.getInputs());
		variables.addAll(targetSystem.getLocals());
		variables.addAll(targetSystem.getOutputs());
		
		int dim = -1;
		for (VariableDeclaration var : variables) {
			if (dim == -1) {
				dim = var.getDomain().getNIndices();
			} else {
				if (dim != var.getDomain().getNIndices()) {
					return new UniformnessResult(null);
				}
			}
		}
		
		//if dimension check passes, construct PRDG after uniformizing in context.
		UniformizeInContext.apply(targetSystem);

		PRDG prdg = PRDGBuilder.build(targetSystem, noInputs);
		return UniformnessResult.create(prdg);
	}
}
