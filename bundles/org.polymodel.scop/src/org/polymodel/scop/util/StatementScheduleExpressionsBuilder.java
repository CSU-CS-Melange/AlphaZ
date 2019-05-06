package org.polymodel.scop.util;

import java.util.ArrayList;
import java.util.List;

import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.quasiAffine.QuasiAffineExpression;
import org.polymodel.algebra.quasiAffine.QuasiAffineFactory;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.AbstractScopStatement;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopGuard;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopVisitable;

/**
 * 
 * Compute the original schedule expressions for a given node in a GecosScop.
 * 
 * @author amorvan
 *
 */
public class StatementScheduleExpressionsBuilder {
	
	//shortcut
	public static List<IntExpression> getSchedule(AbstractScopStatement g, int maxDepth) {
		return (new StatementScheduleExpressionsBuilder(g, maxDepth)).getSchedule();
	}
	
	private int maxDepth;
	private List<IntExpression> schedule;
	private AbstractScopStatement g;
	public StatementScheduleExpressionsBuilder(AbstractScopStatement g, int maxDepth) {
		this.maxDepth = maxDepth;
		this.g = g;
	}
	
	public List<IntExpression> getSchedule() {
		if (this.schedule == null) {
			IDScheduleBuilderVisitor privateVisitor = new IDScheduleBuilderVisitor(maxDepth);
			g.accept(privateVisitor);
			this.schedule = privateVisitor.getSchedule();
		}
		return this.schedule;
	}

	public static class IDScheduleBuilderVisitor extends ScopDefaultVisitor {
		
		private int cpt;
		protected int currentDepth;
		private AbstractScopNode previousNode;
		protected boolean bottomUp = true;
		private List<IntExpression> schedule;
		private int maxDeth;
		
		public List<IntExpression> getSchedule() {
			return schedule;
		}
		
		public IDScheduleBuilderVisitor(int maxDeth) {
			this.maxDeth = maxDeth;
			schedule = new ArrayList<IntExpression>(maxDeth);
		}
		
		@Override
		public void visitAbstractScopStatement(AbstractScopStatement g) {
			if (this.bottomUp) {
				int depth = g.getLoopDepth()*2;
				if (depth > maxDeth) throw new RuntimeException();
				if (this.schedule.isEmpty()) {
					//init schedule
					for (int i = 0; i < depth+1; i++) {
						this.schedule.add(i, IntExpressionBuilder.constant(-1));
					}
					//fill with 0 when depth is not maxDepth
					for (int i = depth+1; i < maxDeth; i++) {
						this.schedule.add(i, IntExpressionBuilder.constant(0));
					}
				}
				
				//start visit
				this.cpt = 0;
				this.currentDepth = depth;
				this.previousNode = g;
				
				((ScopVisitable)g.eContainer()).accept(this);
			} else {
				this.cpt++;
			}
		}
		
		@Override
		public void visitScopBlock(ScopBlock g) {
			if (this.bottomUp) {
				int indexOf = g.getStatements().indexOf(this.previousNode);
				if (indexOf == -1) throw new RuntimeException();
				this.bottomUp = false;
				for (int i = 0; i < indexOf; i++) {
					((ScopVisitable)(g.getStatements().get(i))).accept(this);
				}
				this.bottomUp = true;
				this.previousNode = g;
				((ScopVisitable)g.eContainer()).accept(this);
			} else {
				for (AbstractScopNode n : g.getStatements()){
					((ScopVisitable)n).accept(this);
				}
			}
		}
		
		@Override
		public void visitScopGuard(ScopGuard g) {
			if (this.bottomUp) {
				if (g.getElseBody() == this.previousNode) {
					this.bottomUp = false;
					((ScopVisitable)(g.getThenBody())).accept(this);
					this.bottomUp = true;
				}
				this.previousNode = g;
				((ScopVisitable)g.eContainer()).accept(this);
			} else {
				((ScopVisitable)(g.getThenBody())).accept(this);
				if (g.getElseBody() != null) ((ScopVisitable)(g.getElseBody())).accept(this);
			}
		}
		
		@Override
		public void visitScopFor(ScopFor g) {
			if (this.bottomUp) {
				this.schedule.set(this.currentDepth, IntExpressionBuilder.constant(this.cpt));
				
				QuasiAffineExpression expr = QuasiAffineFactory.eINSTANCE.createQuasiAffineExpression();
				expr.getTerms().add(IntExpressionBuilder.mul(IntExpressionBuilder.affine(g.getIterator()), 1));
				this.schedule.set(this.currentDepth-1, expr.simplify());
				
				this.currentDepth -= 2;
				this.cpt = 0;
				this.previousNode = g;
				((ScopVisitable)g.eContainer()).accept(this);
			} else {
				this.cpt++;
			}
		}
		
		@Override
		public void visitScopRoot(ScopRoot g) {
			//done 
			this.schedule.set(this.currentDepth, IntExpressionBuilder.constant(this.cpt));
			//System.out.println("done");
		}

	}
}
