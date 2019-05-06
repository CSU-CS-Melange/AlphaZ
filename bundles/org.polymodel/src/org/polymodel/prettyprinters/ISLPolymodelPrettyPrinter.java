package org.polymodel.prettyprinters;

import java.util.List;

import org.polymodel.AbstractRelation;
import org.polymodel.BasicRelation;
import org.polymodel.Domain;
import org.polymodel.Function;
import org.polymodel.Label;
import org.polymodel.Relation;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.prettyprinter.algebra.ISLPrettyPrinter;
import org.polymodel.algebra.prettyprinter.algebra.IVariableResolver;

public class ISLPolymodelPrettyPrinter extends AbstractPolymodelPrettyPrinter {

	public ISLPolymodelPrettyPrinter() {
		super(new ISLPrettyPrinter());
	}

	public ISLPolymodelPrettyPrinter(IVariableResolver resolver) {
		super(new ISLPrettyPrinter(resolver));
	}
	
	public String printAsUnionMap(List<Relation> object, String sep) {
		buffer.append("[");

		boolean first=true;
		for(Relation o : object) {
			if(first) {
				first=false;
				append(o.getDimensions().getParameters(), ",");
				buffer.append("] -> {");
			} else {
				buffer.append(sep);
			}
			for(BasicRelation br : o.getBasicRelations()) {
				br.accept(this);
			}
			//buffer.append(separate(o.getBasicRelations(), ";\n"));
		}
		buffer.append("}");
		return buffer.toString();
	}

	@Override
	public void visitDomain(Domain d) {
		buffer.append("[");
		append(d.getDimensions().getParameters(), ",");
		buffer.append("] -> {");
		boolean noneLabel = d.getLabel() != null && d.getLabel().getName().contentEquals(Label.isl_id_none);
		boolean zeroDimensions = d.getDimensions().getIndices().size()==0;
		if (d.getLabel() != null && ! noneLabel) {
			buffer.append(d.getLabel());
		}
		if(!(zeroDimensions && noneLabel)) {
			buffer.append("[");
			append(d.getDimensions().getIndices(), ",");
			buffer.append("] ");
		}
		buffer.append(": ");
		appendEnclosed(d.getPolyhedra(), " or ");
		buffer.append("}");
	}

	@Override
	public void visitBasicRelation(BasicRelation b) {
		AbstractRelation relation = (AbstractRelation) b.eContainer();
//		buffer.append("{");
		if (b.getIn() != null && !b.getIn().getName().matches("#none")) {
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
		boolean needAnd = false;
		
		IntConstraintSystem input = b.getInput();
		if (input.getConstraints().size() > 0) {
			append(input);
			needAnd = true;
		}
		IntConstraintSystem output = b.getOutput();
		if (output.getConstraints().size() > 0) {
			if (needAnd) {
				buffer.append(" and ");
			}
			append(output);
			needAnd = true;
		}
		IntConstraintSystem rel = b.getRelation();
		if (rel!=null && rel.getConstraints().size() > 0) {
			if (needAnd) {
				buffer.append(" and ");
			}
			append(rel);
		}
	
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
	// static JNIISLMap map0 =
	// islMap("{ S1[i,j] -> [k] : 0<=i<8 & 0<=j<8 & k=8i+j }");

	// JNIISLSet set1 =
	// islSet("[M] -> { S[i, j] : i <= -1 + M and M >= 2 and i >= 0 and j >= 0 and j <= -1 + M and j <= M - i	}");

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
