package org.polymodel.polyhedralIR.transformation.reduction;

import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.impl.PolyhedralIRInheritedDepthFirstVisitorImpl;

public class GetNthReduction extends PolyhedralIRInheritedDepthFirstVisitorImpl {
	
	public static ReduceExpression getNthReduction(StandardEquation eq, int n) {
		
		GetNthReduction v = new GetNthReduction(n);
		eq.accept(v);
		
		if (v.target == null) {
			throw new RuntimeException(n + "-th reduction does not exist in the rhs of equation : " +  eq);
		} else {
			return v.target;
		}
	}
	
	protected final int targetN;
	protected int currentN;
	protected ReduceExpression target = null;

	protected GetNthReduction(int n) {
		currentN = 0;
		targetN = n;
	}
	
	@Override
	public void visitReduceExpression(ReduceExpression re) {
		if (currentN == targetN) {
			target = re;
		} else {
			currentN++;
			super.visitReduceExpression(re);
		}
	}
}
