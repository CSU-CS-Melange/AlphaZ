
package org.polymodel.prdg.adapter.examples;




import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.PrdgFactory;
import org.polymodel.prdg.adapter.PRDGAdapterComponent;
import org.polymodel.prdg.adapter.model.IPRDGAdapter;

public class PRDGExample {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PRDG ex = buildExample();
		
		//Build the IGraph adapter from the adapted PRDG
		IPRDGAdapter adapter = PRDGAdapterComponent.INSTANCE.build(ex);
		
		
		//DOT export using injected providers
		PRDGAdapterComponent.INSTANCE.getGraphExportService().export("test2.dot", adapter);
	}
	
	public static PRDG buildExample(){
		PRDG prdg = PrdgFactory.eINSTANCE.createPRDG();
		PRDGNode s1 = PrdgFactory.eINSTANCE.createPRDGNode();
		s1.setName("s1");
		
		PRDGNode s2 = PrdgFactory.eINSTANCE.createPRDGNode();
		s2.setName("s2");
		prdg.getNodes().add(s1);
		prdg.getNodes().add(s2);
		
		PRDGEdge dep = PrdgFactory.eINSTANCE.createPRDGEdge();
		dep.setSource(s1);
		dep.setDestination(s2);
		prdg.getEdges().add(dep);
		
		PRDGEdge dep2 = PrdgFactory.eINSTANCE.createPRDGEdge();
		dep2.setSource(s1);
		dep2.setDestination(s1);
		prdg.getEdges().add(dep2);

		return prdg;
	}

	
}
