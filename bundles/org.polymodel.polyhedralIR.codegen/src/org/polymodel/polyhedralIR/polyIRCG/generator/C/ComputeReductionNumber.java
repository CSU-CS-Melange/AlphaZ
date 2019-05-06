package org.polymodel.polyhedralIR.polyIRCG.generator.C;

import java.util.HashMap;
import java.util.Map;

import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.impl.PolyhedralIRInheritedDepthFirstVisitorImpl;


/**
 * Helper visitor for finding out reduction number of an equation.
 * This visitor assigns a number for each ReduceExpression, that uniquely identifies each ReduceExpression within an equation.
 * 
 * @author yuki
 *
 */
public class ComputeReductionNumber extends PolyhedralIRInheritedDepthFirstVisitorImpl {
	private int reductionNum = 0;
	protected Map<ReduceExpression, Integer> reductionNumber = new HashMap<ReduceExpression, Integer>();
	
	@Override
	public void inStandardEquation(StandardEquation s) {
		reductionNum = 0;
	}
	
	@Override
	public void inReduceExpression(ReduceExpression r) {
		reductionNum++;
		reductionNumber.put(r, reductionNum);
	}
	
	public int getReductionNumber(ReduceExpression re) {
		return reductionNumber.get(re);
	}
}