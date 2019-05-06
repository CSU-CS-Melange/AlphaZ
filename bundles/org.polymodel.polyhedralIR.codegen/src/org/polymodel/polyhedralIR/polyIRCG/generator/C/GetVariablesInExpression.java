package org.polymodel.polyhedralIR.polyIRCG.generator.C;

import java.util.LinkedList;
import java.util.List;

import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.impl.PolyhedralIRInheritedDepthFirstVisitorImpl;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;


/**
 * Helper visitor for finding the variables with distinct memory space for a given expression
 * 
 * @author yunzou
 *
 */
public class GetVariablesInExpression extends PolyhedralIRInheritedDepthFirstVisitorImpl {
	private List<VariableDeclaration> vars = null;
	private List<MemorySpace> spaces = null;
	private TargetMapping targetMapping = null;
	
	public GetVariablesInExpression(TargetMapping _tmap){
		targetMapping = _tmap;
		
		vars = new LinkedList<VariableDeclaration>();
		spaces = new LinkedList<MemorySpace>();
	}
	
	public List<VariableDeclaration> getVars(Expression exp){
		vars.clear();
		spaces.clear();
		
		exp.accept(this);
		
		return vars;
	}
	
	@Override
	public void inVariableExpression(VariableExpression v) {
		VariableDeclaration var = v.getVarDecl();
		//check weather this variable have been added into the list
		if(!vars.contains(var)){
			//if this is new variable, check weather it is mapped to the same memory space 
			//with the variables that have already been added
			MemorySpace space = targetMapping.getMemoryMaps().get(var).getSpace();
			if(!spaces.contains(space)){
				//add the variable
				vars.add(v.getVarDecl());
				//add the new memory space used
				spaces.add(space);
			}
		}
	}
}