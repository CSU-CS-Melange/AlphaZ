package org.polymodel.prdg.scheduling.util;

import static org.polymodel.prdg.scheduling.util.LatexHelper.title;

import org.polymodel.prdg.scheduling.Dependency;

public abstract class ALatexDependencyPrinter {
	protected StringBuffer sb;
	
	public  String toLatex(Dependency dependency){
		this.sb =new StringBuffer();
		appendTitle(dependency);
		appendBody(dependency);
		return this.sb.toString();
	}
	
	protected abstract void appendBody(Dependency dependency);
	
	protected void appendTitle(Dependency dependency){
		this.sb.append(title(1, "Dependence $D_{" + dependency.getSource().getName() + "," + dependency.getReference().getName() + "}$"));
	}
}
