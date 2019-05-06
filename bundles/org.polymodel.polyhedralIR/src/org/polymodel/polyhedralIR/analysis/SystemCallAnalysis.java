package org.polymodel.polyhedralIR.analysis;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.UseEquation;

import fr.irisa.cairn.graph.IEdge;
import fr.irisa.cairn.graph.INode;
import fr.irisa.cairn.graph.implement.Edge;
import fr.irisa.cairn.graph.implement.Graph;
import fr.irisa.cairn.graph.implement.Node;
import fr.irisa.cairn.graph.implement.Port;

public class SystemCallAnalysis {
	
	public static SystemCallAnalysis analyze(Program p) {
		SystemCallAnalysis sca = new SystemCallAnalysis(p);
		sca.analyze();
		return sca;
	}
	
	public static boolean DEBUG = false;
	
	private static void debug(String message) {
		if (DEBUG) System.out.println("[System Call Analysis] " + message);
	}

	protected Program program;
	protected Graph graph;
	protected Map<AffineSystem, Node> systemToNode;
	
	
	public SystemCallAnalysis(Program program) {
		this.program = program;
		analyze();
	}
	
	private void analyze() {
		graph = new Graph(true);

		systemToNode = new HashMap<AffineSystem, Node>();
		
		//first create all nodes
		for (AffineSystem system : program.getSystems()) {
			Node node = new Node();
			node.setLabel(system.getName());
			graph.addNode(node);
			systemToNode.put(system, node);
		}
	
		//then edges
		for (AffineSystem system : program.getSystems()) {
			for (UseEquation use : system.getUseEquations()) {
				Node src = systemToNode.get(system);
				Node dst = systemToNode.get(program.getSystem(use.getSubSystem().getName()));
				Port srcp = new Port();
				Port dstp = new Port();
				src.addOutputPort(srcp);
				dst.addInputPort(dstp);
				Edge edge = new Edge(srcp, dstp);
				graph.addEdge(edge);
			}
		}
		
		for(IEdge edge: graph.getEdges()){
			
		}
	}
	
	public Graph getGraph(){
		return graph;
	}
	
	public boolean isTopLevelSystem(AffineSystem system){
		Node node = systemToNode.get(program.getSystem(system.getName()));
		if(node.getIncomingEdges().size() == 0){
			return true;
		}else{
			return false;
		}
	}
	
	public List<AffineSystem> getTopLevelSystems(){
		List<AffineSystem> topLevelSystems = new LinkedList<AffineSystem>();
		
		//get the list of node who does not have incoming edges
		List<INode> srcNodes = new LinkedList<INode>();
		for(INode node : graph.getNodes()){
			if(node.getIncomingEdges().size() == 0){
				srcNodes.add(node);
			}
		}
		
		//convert the node to list of affineSystems
		for(INode node : srcNodes){
			topLevelSystems.add(program.getSystem(node.getLabel()));
		}

		return topLevelSystems;
	}
	
	/**
	 * Get the list of systems that are calling the AffineSystem(system)
	 * @param system
	 * @return
	 */
	public List<AffineSystem> getCallingSystems(AffineSystem system){
		List<AffineSystem> callingSystems = new LinkedList<AffineSystem>();
		
		//get the source nodes for the system
		List<INode> srcNodes = new LinkedList<INode>();
		for(IEdge edge : graph.getEdges()){
			if(edge.getSinkPort().getNode().getLabel().contentEquals(system.getName())){
				srcNodes.add(edge.getSourcePort().getNode());
			}
		}
		
		//convert the list of nodes into systems
		for(INode node : srcNodes){
			if(!callingSystems.contains(program.getSystem(node.getLabel()))){
				callingSystems.add(program.getSystem(node.getLabel()));
			}
		}

		return callingSystems;
	}
	
	/**
	 * get the useEquations in the system that are using the subSystem with name (useSystemName)
	 * @param system
	 * @param useSystemName
	 * @return
	 */
	public List<UseEquation> getUseEquations(AffineSystem system, String useSystemName){
		List<UseEquation> equations = new LinkedList<UseEquation>();
		for(UseEquation useEq: system.getUseEquations()){
			if(useEq.getSubSystem().getName().contentEquals(useSystemName)){
				equations.add(useEq);
			}
		}
		return equations;
	}
	
	/**
	 * get the all the subsystem that is used in the current system (the systems that are necessary to compile the current system)
	 * @param system
	 * @return
	 */
	public static List<AffineSystem> getUsedSystems(AffineSystem system){
		List<AffineSystem> usedSystems = new LinkedList<AffineSystem>();
		List<AffineSystem> tempSystems = new LinkedList<AffineSystem>();
		
		usedSystems.add(system);
		tempSystems.add(system);
		
		while(tempSystems.size() > 0){
			LinkedList<AffineSystem> temp = new LinkedList<AffineSystem>();
			for(AffineSystem sys : tempSystems){
				for(UseEquation use : sys.getUseEquations()){
					if(!usedSystems.contains(use.getSubSystem())){
						usedSystems.add(use.getSubSystem());
						temp.add(use.getSubSystem());
					}
				}
			}
			tempSystems.clear();
			tempSystems.addAll(temp);
		}
		return usedSystems;
	}

}
