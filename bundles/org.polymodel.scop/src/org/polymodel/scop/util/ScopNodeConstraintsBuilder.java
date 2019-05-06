package org.polymodel.scop.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.ExistentialVariable;
import org.polymodel.algebra.AlgebraUserFactory;
import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.AbstractScopStatement;
import org.polymodel.scop.ScopAssignment;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopGuard;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopStatementMacro;
import org.polymodel.scop.ScopVisitable;

/**
 * 
 * This class builds a List<IntConstraintSystem> for a given AbstractScopNode.
 * Each system in the list is one conjunction of the disjunctions (or the
 * conjunction if there is no disjunction). This class removes NE operators by
 * disjunctions. It also manage else part of guards. During the construction, it
 * is also assumed that the ScopFors cannot represent disjunctions.
 * 
 * @authors sderrien, amorvan
 * 
 */

public class ScopNodeConstraintsBuilder {
	
	public static List<IntConstraintSystem> getConstraints(ScopVisitable n) {
		return (new ScopNodeConstraintsBuilder(n)).getConstraints();
	}
	
	private ScopVisitable n;
	public ScopNodeConstraintsBuilder(ScopVisitable n) {
		this.n = n;
	}
	
	public List<IntConstraintSystem> getConstraints() {
		ConstraintsBuilderVisitor v = new ConstraintsBuilderVisitor();
		this.n.accept(v);
		List<IntConstraintSystem> constraints = v.getConstraints();
		return constraints;
	}
	
	/**
	 * Bottom-Up visitor.
	 */
	private class ConstraintsBuilderVisitor extends ScopDefaultVisitor {

		private List<IntConstraintSystem> list;
		private AbstractScopNode previous;
		public ConstraintsBuilderVisitor() {
			this.list = new BasicEList<IntConstraintSystem>();
			this.previous = null;
		}
		
		public List<IntConstraintSystem> getConstraints() {
			return this.list;
		}
		
		@Override
		public void visitAbstractScopStatement(AbstractScopStatement a) {
			this.previous = a;
			EObject eContainer2 = a.eContainer();
			if (eContainer2 instanceof ScopVisitable)
				((ScopVisitable)eContainer2).accept(this);
			else 
				throw new RuntimeException("Cannot visit "+eContainer2.toString()+" ("+eContainer2.getClass().getSimpleName()+")");
		}

		@Override
		public void visitScopAssignment(ScopAssignment s) {
			this.previous = s;
			((ScopVisitable)s.eContainer()).accept(this);
		}
		
		@Override
		public void visitScopStatementMacro(ScopStatementMacro s) {
			this.previous = s;
			((ScopVisitable)s.eContainer()).accept(this);
		}
		
		@Override
		public void visitScopBlock(ScopBlock s) {
			this.previous = s;
			ScopVisitable container = (ScopVisitable)s.eContainer();
			container.accept(this);
		}
		
		@Override
		public void visitScopGuard(ScopGuard g) {
			List<IntConstraintSystem> guardSystems = g.getConstraintSystems();
			
			if (previous != null && previous == g.getElseBody()) {
				guardSystems = IntExpressionBuilder.negate(guardSystems);
			}
			
			guardSystems = IntExpressionBuilder.removeNE(guardSystems);
			
			if (this.list.size() == 0) {
				this.list = new ArrayList<IntConstraintSystem>(guardSystems.size());
				for (IntConstraintSystem sys : guardSystems) {
					this.list.add(sys.copy());
				}
			}
			else {
				EList<IntConstraintSystem> newRes = new BasicEList<IntConstraintSystem>();
				for (IntConstraintSystem sysOrig : this.list) {
					for(IntConstraintSystem sysGuard : guardSystems) {
						List<IntConstraint> l = new ArrayList<IntConstraint>();
						for (IntConstraint c : sysOrig.getConstraints()) {
							l.add(c.copy());
						}
						for (IntConstraint c : sysGuard.getConstraints()) {
							l.add(c.copy());
						}
						IntConstraintSystem tmpSys = AlgebraUserFactory.intConstraintSystem(l);
						newRes.add(tmpSys);
					}
					
				}
				this.list = newRes;
			}
			this.previous = g;
			//Containment may be missing while tom transformation
			if (g.eContainer() != null) {
				((ScopVisitable)g.eContainer()).accept(this);
			}
		}
		
		@Override
		public void visitScopFor(ScopFor f) {
			IntExpression stride = f.getStride();
			if (!(stride.isConstant() == FuzzyBoolean.YES))
				throw new UnsupportedOperationException("Stride is not constant. This results in non-affine constraints and cannot be handled by the polyhedral model.");
			
			long strideValue = stride.toAffine().getConstantTerm().getCoef();
			
			IntExpression lb2 = f.getLB().copy();
			IntExpression ub2 = f.getUB().copy();

			if (strideValue < 0) {
				IntExpression tmp = lb2;
				lb2 = ub2;
				ub2 = tmp;
			}
			IntConstraint eq = null;
			if (!(stride.isEquivalent(IntExpressionBuilder.constant(1)) == FuzzyBoolean.YES)) {
				String name = "stride"+f.getLoopDepth();
				ExistentialVariable existantial = PolymodelComponent.INSTANCE.getFactory().createExistentialVariable(name);
				eq = IntExpressionBuilder.eq(IntExpressionBuilder.affine(IntExpressionBuilder.term(strideValue, existantial)), IntExpressionBuilder.affine(IntExpressionBuilder.term(f.getIterator())));
			}
			
			IntConstraint lb = IntExpressionBuilder.ge(IntExpressionBuilder.affine(IntExpressionBuilder.term(f.getIterator())),lb2);
			IntConstraint ub = IntExpressionBuilder.le(IntExpressionBuilder.affine(IntExpressionBuilder.term(f.getIterator())),ub2);
			
			//recursively build constraint systems for containers 
			if (this.list.size() == 0) {
				List<IntConstraint> l = new ArrayList<IntConstraint>();
				
				l.add(lb);
				l.add(ub);
				if (eq != null)
					l.add(eq);
				IntConstraintSystem intConstraintSystem = AlgebraUserFactory.intConstraintSystem(l);
				this.list.add(intConstraintSystem);
			} else 
				for (IntConstraintSystem system : this.list) {
					system.getConstraints().add(lb.copy());
					system.getConstraints().add(ub.copy());
					if (eq != null)
						system.getConstraints().add(eq.copy());
				}
			this.previous = f;
			ScopVisitable container = (ScopVisitable)f.eContainer();
			container.accept(this);
		}
		
		@Override
		public void visitScopRoot(ScopRoot s) {
			//done
		}
	}
}

