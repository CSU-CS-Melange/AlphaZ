package org.polymodel.polyhedralIR.recurrence;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.DimensionsManager;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.analysis.PRDGBuilder;
import org.polymodel.polyhedralIR.factory.PolyhedralIRModule;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.transformation.Inline;
import org.polymodel.polyhedralIR.transformation.Normalize;
import org.polymodel.polyhedralIR.transformation.Split;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.adapter.PRDGAdapterComponent;
import org.polymodel.prdg.adapter.model.IPRDGAdapter;
import org.polymodel.prdg.adapter.model.IPRDGNodeAdapter;
import org.polymodel.prdg.factory.PRDGUserFactory;

import fr.irisa.cairn.graph.INode;
import fr.irisa.cairn.graph.analysis.GraphAnalysis;

public class ScanDetection {
	public static boolean DEBUG = false;
	
	protected ScanDetection(){}
	
	public static void scanDetection(Program p){
		for (AffineSystem system : p.getSystems()) {
			scanDetection(system);
		}
	}
	
	public static List<ScanInformations> scanDetection(AffineSystem s){
		//construct the PRDG for AffineSystem 
		PRDG prdg = PRDGBuilder.build(s);
		if(DEBUG){	//PRDG information
			System.out.println("PRDG for system: " + s.getName());
			System.out.println("NODES");
			for (PRDGNode node : prdg.getNodes()) {
				System.out.println(node);
			}
			System.out.println("EDGES");
			for (PRDGEdge edge : prdg.getEdges()) {
				System.out.println(edge);
			}
			System.out.println();
		}
		
		//preprocessing
		//remove the non-uniform dependence edges
		prdg = PreProcessing(s, prdg);
		
		if(DEBUG){
			System.out.println("The new PRDG");
			for (PRDGEdge edge : prdg.getEdges()) {
				System.out.println(edge);
			}
			System.out.println("Start Splitting");
		}
		
//		s = Splitting(s, prdg);
//
//		if(DEBUG){
//			System.out.println("End of splitting, the new system");
//			System.out.println(s.toString());
//		}
//		
//		prdg = PRDGBuilder.build(s);
//		
//		if(DEBUG){
//			System.out.println("Start second preprocessing");
//		}
//		
//		prdg = PreProcessing(s, prdg);
//		if(DEBUG){
//			System.out.println("End of second preprocessing");
//			System.out.println("The new PRDG");
//			for (PRDGEdge edge : prdg.getEdges()) {
//				System.out.println(edge);
//			}
//			System.out.println();
//		}
		
		IPRDGAdapter adaptedprdg = PRDGAdapterComponent.INSTANCE.build(prdg);
		List<Set<INode>> sccs = GraphAnalysis.findStronglyConnectedSets(adaptedprdg);
		//EList<PRDGEdge> edges = prdg.getEdges();
		
		if(DEBUG){
			System.out.println("There are " + sccs.size() + "  SCCS");
		}
		
		List<ScanInformations> scan_info= new LinkedList<ScanInformations>();
		//For each component 
		for(int i = 0; i < sccs.size(); i++){
			Set<INode> scc_node = sccs.get(i);
			EList<PRDGNode> node_list = new BasicEList<PRDGNode>();	//get the node in the strongly connected component
			
			System.out.println("Component " + i);
			Iterator it = scc_node.iterator();
			while (it.hasNext()) {
				PRDGNode org = ((IPRDGNodeAdapter)it.next()).getAdaptedNode();
				node_list.add(org);
				System.out.println(org);
			}
			
			boolean isNormalized = true;
			Domain scan_dom = null;
			if(node_list.size() == 1){//special check for one node
				PRDGNode cur_node = node_list.get(0);
				VariableDeclaration var = s.getVariableDeclaration(cur_node.getName());
				
				if(s.getInputs().contains(var)){//an input variable, no need for checking
					System.out.println("This component is not a scan");
					continue;
				}
				List<PRDGEdge> prev = ScanUtilities.getSourceEdgeInSCC(cur_node, prdg.getEdges(), node_list);
				if(prev.size() == 0){// no recurrence for the node
					System.out.println("This component is not a scan");
					continue;
				}
				
				scan_dom = PolyhedralIRUserFactory.eINSTANCE.createDomain(EcoreUtil.copy(prev.get(0).getDomain()));
				
			}else{
				//normalize program
				prdg = ScanNormalizationForSCC(node_list, prdg, s);
				
				//construct the new edge list 
				HashMap<PRDGNode, List<PRDGEdge>> srcEdgeMap = new HashMap<PRDGNode, List<PRDGEdge>>();
				//get the dependence edges for each node
				for(int j = 0; j < node_list.size(); j++){
					PRDGNode src_node = node_list.get(j);
					List<PRDGEdge> prev = ScanUtilities.getSourceEdgeInSCC(src_node, prdg.getEdges(), node_list);
					srcEdgeMap.put(src_node, prev);
				}
				
				//check uniDirection for every node
				if(DEBUG){
					System.out.println("Check the unidirection for each node");
				}
			
				for(int j = 0; j < node_list.size(); j++){
					List<PRDGEdge> prev = srcEdgeMap.get(srcEdgeMap.get(node_list.get(j)));
					if(!uniDirection(prev)){
						isNormalized = false;
						break;
					}
				}
				
				if(DEBUG){
					System.out.println("End of unidirection checking");
				}
				
				if(!isNormalized){
					System.out.println("This component is not a scan");
					continue;
				}
				scan_dom = PolyhedralIRUserFactory.eINSTANCE.createDomain(EcoreUtil.copy(srcEdgeMap.get(node_list.get(0)).get(0).getDomain()));
			}
		
			Normalize.normalize(s);

//			System.out.println("The system passed into check!");
//			System.out.println(s);
			//For each component do scan detection
			MatrixFormTransformation matrixTrans = new MatrixFormTransformation();
			ScanInformations info = matrixTrans.TransformToMatrixForm(s, scc_node, scan_dom);
			if(scan_info != null){
				scan_info.add(info);
			}
		}
		
		return scan_info;
	}
	

	/**
	 * Normalize the system to make all the dependence unidirectional by substitution
	 * @param node_list
	 * @param prdg
	 * @param s
	 * @return
	 */
	public static PRDG ScanNormalizationForSCC(List<PRDGNode> node_list, PRDG prdg, AffineSystem s){
		if(DEBUG){
			System.out.println("PRDG for scan normalization");
			for (PRDGEdge edge : prdg.getEdges()) {
				System.out.println(edge);
			}
			System.out.println();
		}
		
		HashMap<PRDGNode, List<PRDGEdge>> srcEdgeMap = new HashMap<PRDGNode, List<PRDGEdge>>();
		//get the dependence edges for each node
		for(int j = 0; j < node_list.size(); j++){
			PRDGNode src_node = node_list.get(j);
			List<PRDGEdge> prev = ScanUtilities.getSourceEdgeInSCC(src_node, prdg.getEdges(), node_list);
			srcEdgeMap.put(src_node, prev);
		}
		
		
		for(int j = 0; j < node_list.size(); j++){
			PRDGNode src_node = node_list.get(j);
			boolean isFinished = false;
			while(!isFinished){
				List<PRDGEdge> prev = srcEdgeMap.get(src_node);
				if(DEBUG){
					System.out.println("The edge list for node " + src_node.getName() + " before checking:" + prev.size());
					for(int k = 0; k < prev.size(); k++){
						System.out.println(prev.get(k));
					}
				}
				isFinished = true;
				//check all the dependence for x
				for(int k = 0; k < prev.size(); k++){
					PRDGEdge tmp_edge = prev.get(k);
					System.out.println("Check for edge: " + tmp_edge);
					//System.out.println(tmp_edge.getDomain());
					Domain dep_dom = PolyhedralIRUserFactory.eINSTANCE.createDomain(EcoreUtil.copy(tmp_edge.getDomain()));
					//System.out.println(dep_dom);
					AffineFunction dep_af = PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(EcoreUtil.copy(tmp_edge.getFunction().getMapping()));
					AffineFunction identity = PolyhedralIRUtility.createIdentityFunction(dep_dom.copy());
					
					
					if(dep_af.equivalence(identity)){//if it is identity, do substitution
						System.out.println("substitution normalization for edge:" + tmp_edge);
						isFinished = false;
						prev = srcEdgeMap.get(src_node);
						
						PRDGNode dst_node = tmp_edge.getDestination();
						
						//update the prev for src_node
						List<PRDGEdge> dst_prev = srcEdgeMap.get(dst_node);
						for(int l = 0; l < dst_prev.size(); l++){
							PRDGEdge t_edge = dst_prev.get(l);
							PRDGEdge new_edge = PRDGUserFactory.createPRDGEdge(src_node, t_edge.getDestination(), EcoreUtil.copy(dep_dom.copy().getPMdomain()), EcoreUtil.copy(t_edge.getFunction()));
							prdg.getEdges().add(new_edge);
							if(!prev.contains(new_edge)){
								prev.add(new_edge);
							}
						}
						prdg.getEdges().remove(tmp_edge);
						prev.remove(tmp_edge);
						srcEdgeMap.remove(src_node);
						srcEdgeMap.put(src_node, prev);
						
						//do substitute src_node using the definition of dst_node
						StandardEquation tEq = s.getEquation(src_node.getName());
						StandardEquation sEq = s.getEquation(dst_node.getName());
						
						Inline.transform(tEq, sEq, true);
						break;
					}
				}
				
				if(DEBUG){
					System.out.println("The edge list after checking");
					for(int k = 0; k < prev.size(); k++){
						System.out.println(prev.get(k));
					}
				}
			}
		}
		
		System.out.println("normalized system !");
		System.out.println(s);
		return prdg;
	}
	
	
	public static org.polymodel.Domain CompleteDependenceDomain(PRDGEdge edge){
		DimensionsManager manager = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
		
		org.polymodel.Domain dom = null;
		org.polymodel.Domain depDom = EcoreUtil.copy(edge.getDomain());
		org.polymodel.Domain InitDom = depDom.image(edge.getFunction().getMapping().buildRelation(manager));
		
		dom = depDom.union(InitDom);
		
		return dom;
	}
	
	/**
	 * PreProcessing stage: used to remove the dependence edges with non-uniform dependence with each SCC
	 * @param prdg
	 * @return
	 */
	public static PRDG PreProcessing(AffineSystem s, PRDG prdg){
		if(DEBUG){
			System.out.println("The PRDG FOR PROCESSING");
			for (PRDGEdge edge : prdg.getEdges()) {
				System.out.println(edge);
			}
			System.out.println();
		}
		
		PRDG tmp_prdg = EcoreUtil.copy(prdg);
		EList<PRDGEdge>edges = tmp_prdg.getEdges();
		IPRDGAdapter adaptedprdg = PRDGAdapterComponent.INSTANCE.build(tmp_prdg);
		List<Set<INode>> sccs = GraphAnalysis.findStronglyConnectedSets(adaptedprdg);	//get the scc components
		
		//Processing for each SCC
		for(int i = 0; i < sccs.size(); i++){
			Set<INode> scc_node = sccs.get(i);
			EList<PRDGNode> node_list = new BasicEList<PRDGNode>();

			//special check for one node
			Iterator it = scc_node.iterator();
			while (it.hasNext()) {
				PRDGNode org = ((IPRDGNodeAdapter)it.next()).getAdaptedNode();
				node_list.add(org);
			}
			
			for(int j = 0; j < node_list.size(); j++){
				PRDGNode cur_node = node_list.get(j);
				if(s.getInputs().contains(s.getVariableDeclaration(cur_node.getName()))){//dependence on input variable can be ignored
					continue;
				}
				List<PRDGEdge> dst_edges = ScanUtilities.getDestinationEdgeInSCC(cur_node, edges,node_list);
				boolean isFinished = false;
				while(!isFinished){		//processing until there is no non-uniform dependences on current nod3e
					isFinished = true;
					for(int t = 0; t < dst_edges.size(); t++){
						AffineFunction af = PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(EcoreUtil.copy(dst_edges.get(t).getFunction().getMapping()));
						if(!af.isUniform()){
							isFinished = false;
							PRDGEdge src_edge = dst_edges.get(t);
							org.polymodel.Domain dom = src_edge.getDomain();
							
							if(DEBUG){
								System.out.println("The cur source edge is " + src_edge);
							}
							
							if(dom.isEmpty()){	//if it is an empty branch
								prdg.getEdges().remove(src_edge);
								//FIXME prdg.RemoveEdge(src_edge);
								dst_edges.remove(src_edge);
							}else{//else check other edges, remove all the dependence edges in the same branch
								EList<PRDGEdge> tmp_dst_edges = new BasicEList<PRDGEdge>(dst_edges);
								for(int k = 0; k < tmp_dst_edges.size(); k++){
									PRDGEdge tmp_edge = tmp_dst_edges.get(k);
									//System.out.println("Domain information");
									//System.out.println("srouce domain:" + dom);
									//System.out.println("Edge Domain:" + tmp_edge.getDomain());
									if (tmp_edge.getDomain().getIndices().size() != dom.getNbIndices())
										continue;
									 	
									if(!(tmp_edge.getDomain().intersection(dom)).isEmpty()){
										//System.out.println("The removed edge is " + tmp_edge);
										//FIXME prdg.RemoveEdge(tmp_edge);
										prdg.getEdges().remove(tmp_edge);
										dst_edges.remove(tmp_edge);
										//System.out.println("Remove edges");
									}
								}
							}
							
							break;
						}
					}
				}
			}
		}
		
			
		return prdg;
	}
	
	
	//Do splitting for each variable
	public static AffineSystem Splitting(AffineSystem s, PRDG prdg){
		//Get the strongly connected component(SCC)
		EList<PRDGEdge>edges = prdg.getEdges();
		IPRDGAdapter adaptedprdg = PRDGAdapterComponent.INSTANCE.build(prdg);
		List<Set<INode>> sccs = GraphAnalysis.findStronglyConnectedSets(adaptedprdg);
	
		//do splitting for each SCC
		for(int i = 0; i < sccs.size(); i++){
			Set<INode> scc_node = sccs.get(i);
			EList<PRDGNode> node_list = new BasicEList<PRDGNode>();

			//special check for one node
			Iterator it = scc_node.iterator();
			while (it.hasNext()) {
				PRDGNode org = ((IPRDGNodeAdapter)it.next()).getAdaptedNode();
				node_list.add(org);
			}
			
			for(int t = 0; t < node_list.size(); t++){
				PRDGNode cur_node = node_list.get(t);
				VariableDeclaration var = s.getVariableDeclaration(cur_node.getName());
				
				//if it is an input node skip
				//no need for splitting an input variable
				if(s.getInputs().contains(var)){
					continue;
				}
				
				List<PRDGEdge> dst_edges = ScanUtilities.getDestinationEdgeInSCC(cur_node, edges, node_list);
				org.polymodel.Domain node_dom = cur_node.getDomain();
				
				//System.out.println("Do splitting for " + cur_node.getName());
				while(dst_edges.size() != 0){
					PRDGEdge ori_edge = dst_edges.get(0);
					org.polymodel.Domain dom = CompleteDependenceDomain(ori_edge);
					EList<PRDGEdge> tmp_dst_edges = new BasicEList<PRDGEdge>(dst_edges);
					
					for(int j = 0; j < tmp_dst_edges.size(); j++){
						PRDGEdge tmp_edge = tmp_dst_edges.get(j);
						if(!(tmp_edge.getDomain().intersection(dom)).isEmpty()){
							dom = dom.union(CompleteDependenceDomain(tmp_edge));
							dst_edges.remove(tmp_edge);
						}
					}
					
					if(!(node_dom.difference(dom)).isEmpty()){	//do splitting
						Domain splitDom = PolyhedralIRUserFactory.eINSTANCE.createDomain(dom);

						if(DEBUG){
							System.out.println("Do splitting for node " + cur_node.getName() + " on Domain:" + splitDom);
						}
						Split.transform(s, var, splitDom);
						node_dom = node_dom.difference(dom);
					}
				}
			}
			
		}
		
		//Normalization
		Normalize.normalize(s);
		
		return s;
	}
	
	

	/**
	 * check whether all the dependence directions are along the same direction
	 * @param edge_list
	 * @return
	 */
	private  static boolean uniDirection(List<PRDGEdge> edge_list){
		if(edge_list == null || edge_list.size() == 0){
			return true;
		}
		
		Vector<Long> depVec = null;
		Vector<Long> baseDep = new Vector<Long>();
		long gcd_tmp = 0;
		AffineFunction af = null;
		
	
		boolean OneDir = true;
		
		af = PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(EcoreUtil.copy(edge_list.get(0).getFunction().getMapping()));
		depVec = ScanUtilities.GetDepVector(af);
		
		
		//System.out.println("The dependence vector:" + depVec);
		gcd_tmp = ScanUtilities.GetGcd(depVec);
	
		//get the basic dependence vector
		for(int i = 0; i < depVec.size(); i++){
			baseDep.add(depVec.get(i)/gcd_tmp);
		}
		
		//get the uniform dependence
		for(int i = 1; i < edge_list.size(); i++){
			af = PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(EcoreUtil.copy(edge_list.get(i).getFunction().getMapping()));
			depVec = ScanUtilities.GetDepVector(af);
			gcd_tmp = ScanUtilities.GetGcd(depVec);
			
			List<Long> tmpDep = new Vector<Long>();
			for(int j = 0; j < depVec.size(); j++){
				tmpDep.add(depVec.get(j)/gcd_tmp);
			}
			
			if(!tmpDep.equals(baseDep)){
				OneDir = false;
			}
		}
		return OneDir;
	}
}
