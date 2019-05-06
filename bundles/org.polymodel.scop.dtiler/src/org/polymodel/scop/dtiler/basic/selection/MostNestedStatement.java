package org.polymodel.scop.dtiler.basic.selection;

import java.util.List;

import org.polymodel.scop.AbstractScopStatement;


public class MostNestedStatement implements StatementSelectionStrategy{


	@Override
	public AbstractScopStatement select(List<AbstractScopStatement> statements) {
		int max=0;
		AbstractScopStatement selected=null;
		for (AbstractScopStatement s : statements) {
			int d = s.getLoopDepth();
			if(d>max){
				max =d;
				selected= s;
			}
		}
		return selected;
	}
	
	
}
