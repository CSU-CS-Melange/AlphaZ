package org.polymodel.polyhedralIR.transformation;

import java.util.Arrays;
import java.util.List;

import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.analysis.PRDGBuilder;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;

/**
 * Removes variables from an AffineSystem after checking if no other variables depend on it in the PRDG.
 * 
 * @author yuki
 *
 */
public class RemoveVariable {
	
	/**
     * Removes variables from an AffineSystem after checking if no other variables depend on it in the PRDG.
	 * 
	 * @param system
	 * @param variables
	 */
	public static void apply(AffineSystem system, String ... variables) {
		apply(system, Arrays.asList(variables));
	}
	
	/**
     * Removes variables from an AffineSystem after checking if no other variables depend on it in the PRDG.
     *  
	 * @param system
	 * @param variables
	 */
	public static void apply(AffineSystem system, List<String> variables) {
		RemoveVariable rv = new RemoveVariable(system, variables);
		rv.run();
	}

	protected PRDG prdg;
	final protected AffineSystem system;
	final protected List<String> variables;
	
	protected RemoveVariable(AffineSystem system, List<String> variables) {
		this.system = system;
		this.variables = variables;
	}
	
	protected void run() {
		prdg = PRDGBuilder.build(system);
		
		for (String var : variables) {
			PRDGNode node = prdg.getNode(var);
			
			boolean valid = false;
			
			if (node != null) {
				//when no other nodes depend on it
				if (node.getSources().size() == 0)
					valid = true;
				//self dependence only
				else {
					valid = true;
					for (PRDGEdge e : node.getSources()) {
						if (!e.getSource().getName().contentEquals(node.getName()))
							valid = false;
					}
					
				}
			} 
			
			
			if (valid) {
				system.getEquations().remove(system.getEquation(var));
				VariableDeclaration varDecl = system.getVariableDeclaration(var);
				if (varDecl.isInput()) {
					system.getInputs().remove(varDecl);
				} else if (varDecl.isLocal()) {
					system.getLocals().remove(varDecl);
				} else {
					system.getOutputs().remove(varDecl);
				}
			} else {
				System.err.println("Variable " + var + " cannot be deleted because it is used.");
			}
		}
	}
}
