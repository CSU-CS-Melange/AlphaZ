package org.polymodel.polyhedralIR.polyIRCG.generator.C;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.CompositeIntExpression;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.affine.AffineTerm;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.algebra.impl.AlgebraVisitorImpl;
import org.polymodel.algebra.reductions.ReductionExpression;

/*
 * This class updates the iterator variables of the given bound with the bounds 
 * of the iterator 
 */
public class PCOTIntExpressionVisitor extends AlgebraVisitorImpl {

	Map<Integer, List<IntExpression>> boundingBox; //current bounding box
	Map<String, Integer> loopVarNames; // loop iterator name and the depth
	boolean isUB; //is upper bound
	
	IntExpression intExp;
	
	List<AffineTerm> tobeRemoved;
	List<AffineTerm> tobeAdded;
	private boolean isNonAffine = false;
	private List<IntExpression> newExps;
	
	public static IntExpression updateBounds(IntExpression lb,
			Map<Integer, List<IntExpression>> boundingBox,
			Map<String, Integer> loopVarNames, boolean isUB) {
		PCOTIntExpressionVisitor pcotExpVisitor = new PCOTIntExpressionVisitor(boundingBox, loopVarNames, isUB); 
		lb.accept(pcotExpVisitor);
		
		if (pcotExpVisitor.isNonAffine) {
			lb = IntExpressionBuilder.sum(lb, 
					IntExpressionBuilder.sum(pcotExpVisitor.newExps));
			pcotExpVisitor.isNonAffine = false;
		}
		
		return lb;
	}
	
	public PCOTIntExpressionVisitor(Map<Integer, List<IntExpression>> boundingBox, 
			Map<String, Integer> loopVarNames, boolean isMax) {
		this.boundingBox = boundingBox;
		this.loopVarNames = loopVarNames;
		this.isUB = isMax;
		tobeAdded = new ArrayList<AffineTerm>();
		tobeRemoved = new ArrayList<AffineTerm>();
		intExp = IntExpressionBuilder.constant(0);
		newExps = new ArrayList<IntExpression>();
	}
	
	@Override
	public void visitAffineExpression(final AffineExpression a) {
		tobeAdded.clear();
		tobeRemoved.clear();
		for(AffineTerm o: a.getTerms())
			 o.accept(this);
		
		a.getTerms().removeAll(tobeRemoved);
		a.getTerms().addAll(tobeAdded);
	}
	
	
	@Override
	public void visitAffineTerm(AffineTerm a) {
		if (a.getVariable() == null) {
			return;
		}
		
		Integer depth = loopVarNames.get(a.getVariable().getName());
		if (depth == null) {
			return;
		}
		
		if (boundingBox.get(depth).get(0) instanceof AffineExpression && 
				boundingBox.get(depth).get(1) instanceof AffineExpression) {
			// if both bound expressions are affine
			tobeRemoved.add(a);
			
			AffineExpression bound;
			if (isUB) {
				bound = a.getCoef()<0?
						IntExpressionBuilder.sub(IntExpressionBuilder.constant(0), 
								boundingBox.get(depth).get(0)).toAffine():
						a.getCoef()>0?boundingBox.get(depth).get(1).toAffine():
							IntExpressionBuilder.constant(0).toAffine();
			} else {
				bound = a.getCoef()>0?
						boundingBox.get(depth).get(0).toAffine():
						a.getCoef()<0?
								IntExpressionBuilder.sub(IntExpressionBuilder.constant(0), 
								boundingBox.get(depth).get(1)).toAffine():
									IntExpressionBuilder.constant(0).toAffine();
			}
			tobeAdded.addAll(bound.getTerms());
		} else if (boundingBox.get(depth).get(0) instanceof AffineExpression) {
			// if lower bound is affine
			
			if ((isUB && a.getCoef()<0) /*|| (!isUB && a.getCoef()>0)*/) {
				AffineExpression bound;
//				bound = boundingBox.get(depth).get(0).toAffine();
				bound = IntExpressionBuilder.sub(IntExpressionBuilder.constant(0), 
						boundingBox.get(depth).get(0)).toAffine();
				tobeAdded.addAll(bound.getTerms());
			} else if (!isUB && a.getCoef()>0){
				AffineExpression bound;
				bound = boundingBox.get(depth).get(0).toAffine();
				tobeAdded.addAll(bound.getTerms());
			} else if (a.getCoef()==0) {
				//Do nothing
			} else {
				// ub and coef > 0 or // lb and coef <= 0
				isNonAffine = true;
				AffineTerm a1 = EcoreUtil.copy(a);
				a1.setVariable(null);
				newExps.add(IntExpressionBuilder.prod(
						IntExpressionBuilder.affine(a1), 
						boundingBox.get(depth).get(1)));
			}
			tobeRemoved.add(a);
		} else if (boundingBox.get(depth).get(1) instanceof AffineExpression) {
			// if upper bound is affine

			if ((isUB && a.getCoef()>0) /*|| (!isUB && a.getCoef()<=0)*/) {
				// ub and coef > 0 or // lb and coef <= 0
				AffineExpression bound;
				bound = boundingBox.get(depth).get(1).toAffine();
				tobeAdded.addAll(bound.getTerms());
			}else if  (!isUB && a.getCoef()<0) {
				AffineExpression bound;
//				bound = boundingBox.get(depth).get(1).toAffine();
				bound = IntExpressionBuilder.sub(IntExpressionBuilder.constant(0), 
						boundingBox.get(depth).get(1)).toAffine();
				tobeAdded.addAll(bound.getTerms());
			}else if (a.getCoef()==0) {
				//Do nothing
			} else {
				
				isNonAffine = true;
				AffineTerm a1 = EcoreUtil.copy(a);
				a1.setVariable(null);
				newExps.add(IntExpressionBuilder.prod(
						IntExpressionBuilder.affine(a1), 
						boundingBox.get(depth).get(0)));
			}
			tobeRemoved.add(a);
		} else {
			// if both bounds are non affine
			isNonAffine = true;
			IntExpression bound;
			if (isUB) {
				bound = a.getCoef()<=0?
						boundingBox.get(depth).get(0):
						boundingBox.get(depth).get(1);
			} else {
				bound = a.getCoef()>0?
						boundingBox.get(depth).get(0):
						boundingBox.get(depth).get(1);
			}
			tobeRemoved.add(a);
			newExps.add(bound);
		}
	}
	
	@Override
	public void visitReductionExpression(final ReductionExpression r) {
		List<IntExpression> newRedExp = new ArrayList<IntExpression>();
		for(IntExpression o: r.getExpressions()) {
			 o.accept(this);
			 if (isNonAffine) {
				 newRedExp.add(IntExpressionBuilder.sum(o, 
							IntExpressionBuilder.sum(newExps)));
				 isNonAffine = false;
			 } else {
				 newRedExp.add(o);
			 }
		}
		r.getExpressions().clear();
		r.getExpressions().addAll(newRedExp);
	}

	@Override
	public void visitCompositeIntExpression(final CompositeIntExpression r) {
		r.getLeft().accept(this);
		r.getRight().accept(this);
			
		
	}

/*	@Override
	public void visitVariable(Variable v) {
		Integer depth = loopVarNames.get(v.getName());
		if (depth == null) {
			return;
		}
	}*/
	
}
