package org.polymodel.prdg.adapter.builder;




import java.util.HashSet;
import java.util.Set;

import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.adapter.model.IPRDGAdapter;
import org.polymodel.prdg.adapter.model.IPRDGEdgeAdapter;
import org.polymodel.prdg.adapter.model.IPRDGNodeAdapter;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Builder of the graph adapter.
 *
 * @author <your name>
 *
 */
 @Singleton
public class  AdapterBuilder{
	@Inject
	AdapterFactory factory;

	
	//private Set<PRDG> visitedsGraph;
	private Set<PRDGNode> visitedsNode;
	private Set<PRDGEdge> visitedsEdge;
	
	@Inject
	protected AdapterBuilder() {
	
	//	this.visitedsGraph = new HashSet<PRDG>();
		this.visitedsNode = new HashSet<PRDGNode>();
		this.visitedsEdge = new HashSet<PRDGEdge>();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	public IPRDGAdapter buildGraphAdapter(PRDG adapted) {
		
		
		IPRDGAdapter graphAdapter = factory.createGraphAdapter(adapted, true);
		
initGraphAdapter(graphAdapter
, adapted   );

		;
		return graphAdapter;
	}
	
private void initGraphAdapter(IPRDGAdapter graphAdapter, PRDG adapted   ) {



for(PRDGNode e: adapted. getNodes() ){


IPRDGAdapter container = graphAdapter;

	buildNodeAdapter(container, e
);
}



;


for(PRDGEdge e: adapted. getEdges() ){


IPRDGAdapter container = graphAdapter;

	buildInternalEdge(container, e
);
}



 
}



	
	


	public void buildNodeAdapter(IPRDGAdapter graphAdapter, PRDGNode adapted ) {
		
		
		IPRDGNodeAdapter nodeAdapter = null;
		if (!this.visitedsNode.contains(adapted)) {
			this.visitedsNode.add(adapted);
				nodeAdapter = factory.createNodeAdapter(adapted);
			graphAdapter.addNode(nodeAdapter);
		
initNodeAdapter(graphAdapter
, nodeAdapter , adapted   );

		}
	}
	
private void initNodeAdapter(IPRDGAdapter graphAdapter, IPRDGNodeAdapter nodeAdapter , PRDGNode adapted   ) {
	 
}



	
	

		
	
	
	

	private void buildEdgeAdapter(IPRDGAdapter graphAdapter, PRDGEdge adapted  ) {
		
		
		


		IPRDGEdgeAdapter edgeAdapter = null;
initEdgeAdapter(graphAdapter
, edgeAdapter , adapted   );

		
		 
		IPRDGNodeAdapter sourceAdapter = graphAdapter.getAdapterNode(adapted. getSource() ); //sourceExpression
		IPRDGNodeAdapter sinkAdapter = graphAdapter.getAdapterNode(adapted. getDestination() ); //sourceExpression
		
		
		edgeAdapter =factory.connect( adapted,  sourceAdapter, sinkAdapter);
		
		
	}
	
	private void buildInternalEdge(IPRDGAdapter graphAdapter, PRDGEdge adapted  ) {
		
			if (!this.visitedsEdge.contains(adapted)) {
				this.visitedsEdge.add(adapted);
					buildEdgeAdapter(graphAdapter, adapted  );
				}
		
	}
	
private void initEdgeAdapter(IPRDGAdapter graphAdapter, IPRDGEdgeAdapter edgeAdapter , PRDGEdge adapted   ) {
	 
}

	
	
	

	



}

