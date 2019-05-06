package org.polymodel.prettyprinters;

import org.polymodel.BasicRelation;
import org.polymodel.Domain;
import org.polymodel.Function;
import org.polymodel.Label;
import org.polymodel.PolymodelVisitable;
import org.polymodel.Relation;
import org.polymodel.algebra.prettyprinter.algebra.IVariableResolver;
import org.polymodel.algebra.prettyprinter.algebra.LatexPrettyPrinter;

public class LatexPolymodelPrettyPrinter extends AbstractPolymodelPrettyPrinter {
	public LatexPolymodelPrettyPrinter() {
		super(new LatexPrettyPrinter());
	}
	public LatexPolymodelPrettyPrinter(IVariableResolver resolver) {
		super(new LatexPrettyPrinter(resolver));
	}
	protected LatexPolymodelPrettyPrinter(LatexPrettyPrinter algebraPrinter){
		super(algebraPrinter);
	}
	@Override
	public String print(PolymodelVisitable object) {
		String res = super.print(object);
		res = res.replace("+ -","-");
		return res;
	}
	@Override
	public void visitDomain(Domain d) {
		if (d.getLabel() != null) {
			buffer.append(d.getLabel());
		}else{
			buffer.append("D");
		}
		buffer.append("(");
		append(d.getDimensions().getParameters(), ",");
		append(d.getDimensions().getIndices(), ",");
		buffer.append(") : \\\\ \n");
		appendEnclosed(d.getPolyhedra(), "\\\\  or \\\\ \n");
	}

	@Override
	public void visitBasicRelation(BasicRelation b) {
		Relation relation = (Relation) b.eContainer();
//		buffer.append("{");
		if (b.getIn() != null) {
			b.getIn().accept(this);
		}
		buffer.append("[");
		append(relation.getDimensions().getInputs(), ",");
		buffer.append("] -> ");
		if (b.getOut() != null) {
			b.getOut().accept(this);
		}
		buffer.append("[");
		append(relation.getDimensions().getOutputs(), ",");
		buffer.append("] : ");
		if (b.getInput().getConstraints().size() > 0) {
			append(b.getInput());
			buffer.append(" and ");
		}
		if (b.getOutput().getConstraints().size() > 0) {
			append(b.getOutput());
			buffer.append(" and ");
		}
		append(b.getRelation());
	
//		buffer.append("}");
	}

	@Override
	public void visitRelation(Relation r) {
		buffer.append("[");
		append(r.getDimensions().getParameters(), ",");
		buffer.append("] -> {");
		separate(r.getBasicRelations(), ";");
		buffer.append("}");
	}

	@Override
	public void visitLabel(Label l) {
		buffer.append(l.getName());
	}
	
	@Override
	public void visitFunction(Function f) {
		buffer.append("[");
		append(f.getDimensions().getParameters(), ",");
		buffer.append("] -> { [");
		append(f.getDimensions().getIndices(),",");
		buffer.append("] -> [");
		append(f.getExpressions(),",");
		buffer.append("] }");
	}
}
