package org.polymodel.polyhedralIR.transformation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.analysis.PRDGBuilder;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;

public class RemoveUnusedVariables {

	
	public static Set<String> apply(Program prog) {
		Set<String> result = null;
		for (AffineSystem system : prog.getSystems()) {
			Set<String> sres = apply(system);
			if (result == null) {
				result = new TreeSet<String>();
			}
			for (String rmVar : sres) {
				result.add( system.getName() + " : " + rmVar);
			}
		}
		return result;
	}
	
	public static Set<String> apply(AffineSystem system) {
		//Uses PRDG
		PRDG prdg = PRDGBuilder.build(system);
		
		//initialize used nodes with output variables
		Set<PRDGNode> usedNodes = new HashSet<PRDGNode>();
		for (VariableDeclaration output : system.getOutputs()) {
			usedNodes.add(prdg.getNode(output.getName()));
		}
		
		int nodeCount = -1;
		while (nodeCount < usedNodes.size()) {
			//set nodeCount to the current size, so the search terminates when no more variables were added to the used set
			nodeCount = usedNodes.size();
			
			List<PRDGNode> newNodes = new LinkedList<PRDGNode>();
			for (PRDGNode node : usedNodes) {
				for (PRDGEdge edge : node.getDestinations()) {
					newNodes.add(edge.getDestination());
				}
			}
			usedNodes.addAll(newNodes);
		}
		
		//construct the list of variables to remove
		Set<VariableDeclaration> rmList = new HashSet<VariableDeclaration>();
		Set<String> rmListStr = new TreeSet<String>();

		for (VariableDeclaration local : system.getLocals()) {
			if (!usedNodes.contains(prdg.getNode(local.getName()))) {
				rmList.add(local);
				rmListStr.add(local.getName());
			}
		}
		
		//remove
		for (VariableDeclaration rm : rmList) {
			system.getEquations().remove(system.getEquation(rm.getName()));
			system.getLocals().remove(rm);
		}
		
		return rmListStr;
	}
}
