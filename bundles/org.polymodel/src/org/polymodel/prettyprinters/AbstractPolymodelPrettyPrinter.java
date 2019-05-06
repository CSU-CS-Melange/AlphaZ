package org.polymodel.prettyprinters;

import org.eclipse.emf.common.util.EList;
import org.polymodel.PolymodelVisitable;
import org.polymodel.algebra.AlgebraVisitable;
import org.polymodel.algebra.prettyprinter.algebra.AbstractPrettyPrinter;
import org.polymodel.impl.PolymodelVisitorImpl;

public abstract class AbstractPolymodelPrettyPrinter extends PolymodelVisitorImpl{
	protected final StringBuffer buffer;
	protected AbstractPrettyPrinter algebraPrinter;
	
	public AbstractPolymodelPrettyPrinter(AbstractPrettyPrinter algebraPrinter){
		this.buffer = new StringBuffer();
		this.algebraPrinter = algebraPrinter;
	}
	public String print(PolymodelVisitable object){
		object.accept(this);
		return buffer.toString();
	}
	
	protected void append(AlgebraVisitable e){
		buffer.append(algebraPrinter.print(e));
		algebraPrinter.clear();
	}
	
	protected void append(EList<? extends AlgebraVisitable> elements,String separator){
		buffer.append(algebraPrinter.separate(elements, separator));
		algebraPrinter.clear();
	}
	
	protected void appendEnclosed(EList<? extends AlgebraVisitable> elements,String separator){
		buffer.append(algebraPrinter.separateEncapsulated(elements, separator));
		algebraPrinter.clear();
	}
	
	protected String separate(EList<? extends PolymodelVisitable> visitables, String separator) {
		boolean first=true;
		for (PolymodelVisitable v : visitables) {
			buffer.append((first?"":separator));
			v.accept(this);
			first=false;
		}
		return buffer.toString();
	}

	protected String separateEncapsulated(EList<? extends PolymodelVisitable> visitables, String separator) {
		boolean first=true;
		if (visitables.size() == 1)
			visitables.get(0).accept(this);
		else
			for (PolymodelVisitable v : visitables) {
				buffer.append((first?"":separator));
				buffer.append("(");
				v.accept(this);
				buffer.append(")");
				first=false;
			}
		return buffer.toString();
	}

}