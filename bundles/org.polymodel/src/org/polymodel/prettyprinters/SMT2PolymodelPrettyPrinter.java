package org.polymodel.prettyprinters;

import org.polymodel.BasicRelation;
import org.polymodel.Domain;
import org.polymodel.Function;
import org.polymodel.Label;
import org.polymodel.Relation;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.prettyprinter.algebra.IVariableResolver;
import org.polymodel.algebra.prettyprinter.algebra.SMT2PrettyPrinter;

public class SMT2PolymodelPrettyPrinter extends AbstractPolymodelPrettyPrinter {
	
	public SMT2PolymodelPrettyPrinter() {
		super(new SMT2PrettyPrinter());
	}

	public SMT2PolymodelPrettyPrinter(IVariableResolver resolver) {
		super(new SMT2PrettyPrinter(resolver));
	}

	@Override
	public void visitDomain(Domain d) {
		boolean first = true;
		if (d.getPolyhedra().size() > 1)
			buffer.append("(or ");
		for (IntConstraintSystem ics : d.getPolyhedra()) {
			if (!first) buffer.append(" ");
			printPolyhedron(d, ics);
			first = false;
		}
		if (d.getPolyhedra().size() > 1)
			buffer.append(")");
	}
	

	
	public void printPolyhedron(Domain d, IntConstraintSystem ics) {
		if (ics.getConstraints().size() > 1)
			buffer.append("(and ");
		boolean first = true;
		for (IntConstraint c : ics.getConstraints()) {
			if (!first) buffer.append(" ");
			append(c);
			first = false;
		}
		if (ics.getConstraints().size() > 1)
			buffer.append(")");
	}

	@Override
	public void visitBasicRelation(BasicRelation b) {
		int count = 0;
		if (b.getInput().getConstraints().size() > 0) count++;
		if (b.getOutput().getConstraints().size() > 0) count++;
		if (b.getRelation().getConstraints().size() > 0) count++;
		
		if (count > 1) {
			buffer.append("(and ");
		}

		append(b.getInput());
		buffer.append(" ");
		append(b.getOutput());
		buffer.append(" ");
		append(b.getRelation());
		

		if (count > 1) {
			buffer.append(")");
		}
	}

	@Override
	public void visitRelation(Relation r) {
		if (r.getBasicRelations().size() > 1)
			buffer.append("(or ");
		separate(r.getBasicRelations(), " ");
		if (r.getBasicRelations().size() > 1)
			buffer.append(")");
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
