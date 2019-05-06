package org.polymodel.prdg.util;

import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.PRDGSubSystemHyperEdge;

public class PRDGPrettyPrinter {

	public static String pretty(PRDG prdg) {
		return pretty(prdg,"");
	}		
	
	public static String pretty(PRDG prdg, String prefix) {
		String res = "";
		res += prefix+"PRDG : nodes = {\n";
		for (PRDGNode n : prdg.getNodes()) {
			res += prefix+"\t"+n+"\n";
		}
		res += prefix+"}\n"+prefix+"edges = {\n";
		for (PRDGEdge e : prdg.getEdges()) {
			res += prefix+"\t"+pretty(e)+"\n";
		}
		res += prefix + "}\n";
		if (!prdg.getHedges().isEmpty()) {
			res += prefix + "hedges = {\n";
			for (PRDGSubSystemHyperEdge he : prdg.getHedges()) {
				res += prefix + "\t" + pretty(he) + "\n";
			}
			res += prefix+"}";
		}
		return res;
	}
	
	public static String pretty(PRDGNode node) {
		StringBuffer result = new StringBuffer(node.getName());
		result.append(", ");
		result.append(node.getDomain());
		return result.toString();
	}
	
	public static String pretty(PRDGEdge edge) {
		StringBuffer outString = new StringBuffer(edge.getSource().getName());
		outString.append(" -> ");
		outString.append(edge.getDestination().getName());
		outString.append(", with ");
		outString.append(edge.getFunction().getMapping());
		outString.append(", when ");
		outString.append(edge.getDomain());
		return outString.toString();
	}
	
	public static String pretty(PRDGSubSystemHyperEdge hedge) {
		StringBuffer outString = new StringBuffer();
		
		outString.append(" [ ");
		for (PRDGNode src : hedge.getSources())
			outString.append(src.getName() + " ");
		outString.append("] -> [ ");
		for (PRDGNode dest : hedge.getDestinations())
			outString.append(dest.getName() + " ");
		outString.append("], with parameters ");
		outString.append(hedge.getParams());
		outString.append(" , and extension domain ");
		outString.append(hedge.getExtDom());
		return outString.toString();
	}
}
