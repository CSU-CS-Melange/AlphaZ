package org.polymodel.polyhedralIR.recurrence.bis;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.xtext.xbase.lib.Pair;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.util.VariableComparator;

/**
 * RecurrenceVariable keeps track of where the uses of recurrence
 * variable for constructing coefficient matrix and update vectors.
 * 
 * @author tyuki
 *
 */
public class RecurrenceVariable {

	public final VariableDeclaration variable;
	private long maxGCD = 0;
	protected Map<VariableDeclaration, Expression> useExpressions = new TreeMap<>(VariableComparator.INSTANCE);
	protected List<Pair<Domain, Expression>> initializations;
	
	public RecurrenceVariable(VariableDeclaration variable) {
		this.variable = variable;
	}
	
	public void addUsage(VariableDeclaration usedBy, long gcd, Expression usedBranch) {
		maxGCD = Math.max(maxGCD, gcd);
		
		if (!useExpressions.containsKey(usedBy)) {
			useExpressions.put(usedBy, usedBranch);
		} else {
			Expression prevExpr = useExpressions.get(usedBy);
			if (!prevExpr.equals(usedBranch))
				throw new RuntimeException("Unexpected case");
		}
	}
	
	public String getName() {
		return variable.getName();
	}
	
	public long getMaxGCD() {
		return maxGCD;
	}

	public Expression getUseExpression(VariableDeclaration var) {
		return useExpressions.get(var);
	}
	
	@Override
	public String toString() {
		return getName();
	}
}
