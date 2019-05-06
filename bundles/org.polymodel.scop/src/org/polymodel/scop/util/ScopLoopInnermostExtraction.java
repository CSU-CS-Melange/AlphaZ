package org.polymodel.scop.util;


import java.util.LinkedList;
import java.util.List;

import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.impl.ScopDepthFirstVisitorImpl;

public class ScopLoopInnermostExtraction {
	
	public static List<ScopFor> extractInnermostScopFors(AbstractScopNode node){
		InnermostScopForExtractor extractor = new InnermostScopForExtractor();
		node.accept(extractor);
		
		return extractor.innermostFors;
	}
	
	private static class InnermostScopForExtractor extends ScopDepthFirstVisitorImpl {
		public List<ScopFor> innermostFors = new LinkedList<ScopFor>();
		
		public InnermostScopForExtractor() {}
		
		@Override
		public void inScopFor(ScopFor s){
			InnerScopForCheck innermostChecker = new InnerScopForCheck();
			s.getBody().accept(innermostChecker);
			if(!innermostChecker.innerForFound){
				if(!innermostFors.contains(s))	innermostFors.add(s);
			}
		}
	}
	
	private static class InnerScopForCheck extends ScopDepthFirstVisitorImpl {
		public boolean innerForFound = false;
		
		public InnerScopForCheck() {}
		
		@Override
		public void inScopFor(ScopFor s){
			innerForFound = true; 
		}
	}
}
