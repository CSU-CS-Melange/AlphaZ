package org.polymodel.scop.dtiler.basic.selection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.scop.AbstractScopStatement;
import org.polymodel.scop.ScopFor;


public class LargestVolumeStatement implements StatementSelectionStrategy{


	@Override
	public AbstractScopStatement select(List<AbstractScopStatement> statements) {
		List<LoopVolumeApproximation> approx = new ArrayList<LoopVolumeApproximation>(statements.size());
		for (AbstractScopStatement s : statements) {
			approx.add(new LoopVolumeApproximation(s));
		}
		Collections.sort(approx);
		return approx.get(approx.size()-1).statement;
	}
	
	private class LoopVolumeApproximation implements Comparable<LoopVolumeApproximation> {
		public final AbstractScopStatement statement;
		private int[] paramCountList;
		private int[] constantSize;
		
		private LoopVolumeApproximation(AbstractScopStatement s) {
			statement = s;
			List<ScopFor> loops = s.getSurroundingScopFors();
			paramCountList = new int[loops.size()];
			constantSize = new int[loops.size()];
			
			for (int i = 0; i < loops.size(); i++) {
				IntExpression lb = EcoreUtil.copy(loops.get(i).getLB());
				IntExpression ub = EcoreUtil.copy(loops.get(i).getUB());
				
				//negate lb
				lb = IntExpressionBuilder.prod(IntExpressionBuilder.affine(IntExpressionBuilder.term(-1)), lb);
				//add them together and simplify
				IntExpression expr = IntExpressionBuilder.sum(lb, ub).simplify();
				AffineExpression aff = expr.toAffine();
				if (aff != null) {
					for (AffineTerm term : aff.getTerms()) {
						if (term.getVariable() == null) {
							constantSize[i] += term.getCoef();
						} else {
							paramCountList[i] += term.getCoef();
						}
					}
				}
			}
		}

		@Override
		public int compareTo(LoopVolumeApproximation o) {
			if (paramCountList.length != o.paramCountList.length || 
				constantSize.length != o.constantSize.length) {
				throw new RuntimeException("Incompatible LoopVolumeApproximations");
			}
			
			for (int i = 0; i < paramCountList.length; i++) {
				if (paramCountList[i] != o.paramCountList[i]) {
					return paramCountList[i] - o.paramCountList[i];
				}
				if (constantSize[i] != o.constantSize[i]) {
					return constantSize[i] - o.constantSize[i];
				}
			}
			
			return 0;
		}
	}
	
}
