package org.polymodel.prdg.scheduling.farkas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.UniqueEList;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.prdg.scheduling.ScheduleTerm;

/**
 * A dedicated list to schedule terms that store all coefficients referenced by
 * affine expressions of the terms.
 * 
 * @author antoine
 * 
 */
@SuppressWarnings("serial")
public class ScheduleTermList extends ArrayList<ScheduleTerm> {

	List<Variable> coeficients = new UniqueEList<Variable>();
//test comment
	public ScheduleTermList(Collection<? extends ScheduleTerm> c) {
		for (ScheduleTerm scheduleTerm : c) {
			add(scheduleTerm);
		}
	}
	

	@Override
	public boolean add(ScheduleTerm e) {
		for (AffineTerm t : e.getExp().getTerms()) {
			if (t.getVariable() != null)
				coeficients.add(t.getVariable());
		}
		return super.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends ScheduleTerm> c) {
		boolean added = false;
		for (ScheduleTerm scheduleTerm : c) {
			added = added | add(scheduleTerm);
		}
		return added;
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException("Remove is not allowed");
	}

	public List<Variable> getCoeficients() {
		return coeficients;
	}

	public Variable[] getCoeficientsArray() {
		return coeficients.toArray(new Variable[coeficients.size()]);
	}

	public String toLatex() {
		StringBuffer sb = new StringBuffer();
		int size = size();
		for (int i = 0; i < size - 1; i++) {
			sb.append(get(i).toLatex()).append(" + ");
		}
		if (size > 0)
			sb.append(get(size - 1).toLatex());
		return sb.toString();
	}

}