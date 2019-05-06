package org.polymodel.polyhedralIR.polyIRCG.generator.C;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopGuard;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopStatementMacro;
import org.polymodel.scop.ScopUserFactory;
import org.polymodel.scop.impl.ScopDepthFirstVisitorImpl;

public class PCOTScopVisitor extends ScopDepthFirstVisitorImpl {
	
	public List<PCOTFunctionInfo> getRecursiveFuncitions() {
		return recursiveFuncitions;
	}

	private Map<Integer, List<IntExpression>> boundingBox;
	private Map<Integer, List<IntExpression>> convexHull;
	private static Map<String, Integer> loopVarNames = new HashMap<String, Integer>();
	private static int blockId = 0;
	private List<PCOTFunctionInfo> recursiveFuncitions;
	private String sysName;
	private EList<IntExpression> params;
	private EList<IntExpression> vars;
	private PCOTFunctionInfo fInfo;
//	private Domain paramDomain;
	private List<List<IntConstraintSystem>> guards;
	
	private PCOTFunctionInfo tempInfo;
	
	private int previousDepth;
	
	//this is to keeptrack of whether we have created a new recursive function info
	private int currentDepth;

//	public PCOTScopVisitor(Map<Integer, List<IntExpression>> boundingBox,
//			Map<String, Integer> loopVarNames, int blockId,
//			List<PCOTFunctionInfo> recursiveFuncitions, String sysName,
//			EList<IntExpression> params, EList<IntExpression> vars,
//			PCOTFunctionInfo fInfo) {
//		super();
//		this.boundingBox = boundingBox;
////		this.loopVarNames = loopVarNames;
////		this.blockId = blockId;
//		this.recursiveFuncitions = recursiveFuncitions;
//		this.sysName = sysName;
//		this.params = params;
//		this.vars = vars;
//		this.fInfo = fInfo;
//	}
	
	public PCOTScopVisitor(String sysName,
			EList<IntExpression> params, EList<IntExpression> vars,
			PCOTFunctionInfo fInfo) {
		super();
		this.boundingBox = fInfo.getBoundingBox();
		/*this.boundingBox = new HashMap<Integer, List<List<IntExpression>>>();
		for (Entry<Integer, List<IntExpression>> bb : fInfo.getBoundingBox().entrySet()) {
			List<List<IntExpression>> exps = new ArrayList<List<IntExpression>>();
			exps.add(bb.getValue());
			this.boundingBox.put(bb.getKey(), exps);
		}*/
//		this.loopVarNames = new HashMap<String, Integer>();
		this.recursiveFuncitions = new ArrayList<PCOTFunctionInfo>();
		this.sysName = sysName;
		this.params = params;
		this.vars = vars;
		this.fInfo = fInfo;
		this.guards = new ArrayList<List<IntConstraintSystem>>();
//		this.convexHull = new HashMap<Integer, List<IntExpression>>();
	}
	
	/*private int getPrevBandEnd() {
		return fInfo.getPreviousBand().getBandEnd();
	}*/

	private int getPrevBandStart() {
		//FIXME +1 is because the band naming is inconsistent with the rest
		return fInfo.getPreviousBand().getBandStart()+1;
	}
	
	private int getCurBandEnd() {
		//FIXME +1 is because the band naming is inconsistent with the rest
		return fInfo.getCurrentBand().getBandEnd()+1;
	}
	
	private int getCurBandStart() {
		//FIXME +1 is because the band naming is inconsistent with the rest
		return fInfo.getCurrentBand().getBandStart()+1;
	}
	
	private boolean isParallel() {
		return fInfo.getCurrentBand().isParallel();
	}
	
	public static void setBlockId(int bId) {
		blockId = bId;
	}
	
	@Override
	public void inScopRoot(ScopRoot s) {
		
	}

	@Override
	public void outScopRoot(ScopRoot s) {
		
	}

	@Override
	public void inScopFor(ScopFor s) {
		currentDepth = s.getLoopDepth()+getPrevBandStart()-1;
		final boolean isSequence = currentDepth==previousDepth;
		IntExpression upperBoundOfPreviousBlock = null;
		
		
		if (s.getLoopDepth()+getPrevBandStart()-1 > getCurBandEnd()) {
			// if current depth is > band end
			return;
		}
		// Bounds ===========================================================
		loopVarNames.put(s.getIterator().getName(), s.getLoopDepth()+getPrevBandStart()-1);
//		System.out.println("depth: " + (s.getLoopDepth()+getPrevBandStart()-1) + " :: " + s.getLB() + " :: " + s.getUB());
		
		
		
		
		IntExpression lb = s.getLB().copy().simplify();
		IntExpression ub = s.getUB().copy().simplify();
		
		if (getCurBandStart() <= s.getLoopDepth() + getPrevBandStart() - 1 
				&& s.getLoopDepth() + getPrevBandStart() - 1 <= getCurBandEnd()) {
			if (getCurBandStart() == s.getLoopDepth() + getPrevBandStart() - 1) {
				convexHull = new HashMap<Integer, List<IntExpression>>();
			}
			
			if (!isSequence) {
				List<IntExpression> prevB = convexHull.get(currentDepth);
				if (prevB != null) {				
					upperBoundOfPreviousBlock = prevB.get(1);
				}
			}
			
			
			List<IntExpression> bounds = convexHull.get(s.getLoopDepth() + getPrevBandStart() - 1);
			if (bounds == null) {
				bounds = new ArrayList<IntExpression>();				
				bounds.add(lb.copy());
				bounds.add(ub.copy());
				convexHull.put(s.getLoopDepth() + getPrevBandStart() - 1, bounds);
			} else {	
				if (isSequence) {
//					bounds.set(0, IntExpressionBuilder.min(lb.copy(),bounds.get(0)).simplify());
					bounds.set(1, ub.copy());
				} else {
					bounds.set(0, IntExpressionBuilder.min(lb.copy(),bounds.get(0)).simplify());
//					bounds.set(1, IntExpressionBuilder.max(ub.copy(),bounds.get(1)).simplify());
					if (upperBoundOfPreviousBlock == null) {
						bounds.set(1, ub.copy());
					} else {
						bounds.set(1, IntExpressionBuilder.max(ub.copy(),upperBoundOfPreviousBlock).simplify());
					}
				}
			}
		}
		
		
		if (s.getLoopDepth()+getPrevBandStart()-1 > 1) {
			//Replace the iterator variables in loop bounds by its min or max
			lb = PCOTIntExpressionVisitor.updateBounds(lb, boundingBox, loopVarNames, false);
			ub = PCOTIntExpressionVisitor.updateBounds(ub, boundingBox, loopVarNames, true);
		}
		
//		lb = replaceParamsWithItsLowerBounds(this.paramDomain, lb);
		
//		if (boundingBox.get(s.getLoopDepth()+getPrevBandStart()-1) != null) {
		List<IntExpression> oldBB = boundingBox.get(s.getLoopDepth()+getPrevBandStart()-1);
//		ReductionExpression lmin = IntExpressionBuilder.min();
//		ReductionExpression lmax = IntExpressionBuilder.max();
		if (!oldBB.isEmpty()) {
//			lmin.getExpressions().add(oldBB.get(0));
//			lmax.getExpressions().add(oldBB.get(1));
			oldBB.set(1, ub.simplify());
		} else {
			List<IntExpression> bb = new ArrayList<IntExpression>();
			bb.add(lb.simplify());
			bb.add(ub.simplify());
			
//			bb = max(bb, boundingBox.get(s.getLoopDepth()+getPrevBandStart()-1));
			
			
			
			boundingBox.put(s.getLoopDepth()+getPrevBandStart()-1, bb);
		}
//		lmin.getExpressions().add(lb.simplify());
//		lmax.getExpressions().add(ub.simplify());
//		lb = lmin.simplify();
//		ub = lmax.simplify();
////		}
//		
////		bb.add(lb.simplify());
////		bb.add(ub.simplify());
//		
//		ub = simplify(ub);
//		lb = simplify(lb);
//		
//		bb.add(lb.simplify());
//		bb.add(ub.simplify());
//		
////		bb = max(bb, boundingBox.get(s.getLoopDepth()+getPrevBandStart()-1));
//		
//		
//		
//		boundingBox.put(s.getLoopDepth()+getPrevBandStart()-1, bb);
//		System.out.println("depth: " + (s.getLoopDepth()+getPrevBandStart()-1) + " New :: " + bb.get(0) + " :: " + bb.get(1));
		
		if ((getCurBandStart()) == s.getLoopDepth() + getPrevBandStart() - 1) {
			PCOTFunctionInfo fi = 
					new PCOTFunctionInfo(fInfo.getCurrentBand(), 
							fInfo.getPreviousBand(), sysName, blockId);
			tempInfo = fi;
		}
		
		// END Bounds =======================================================
		previousDepth = currentDepth;
	}

	/*private IntExpression simplify(IntExpression bound) {
		if (bound instanceof AffineExpression) {
			return bound;
		} else if (bound instanceof ReductionExpression) {
			ReductionExpression rb = (ReductionExpression) bound;
			boolean isMax = rb.getOperator().equals(ReductionOperator.MAX);
			
			if(isMax) {
			//assuming only two exprs
				AffineExpression ub1 = rb.getExpressions().get(0).toAffine();
				AffineExpression ub2 = rb.getExpressions().get(1).toAffine();
				
				if (ub1.isConstant().equals(FuzzyBoolean.YES)) {
					AffineExpression lub2 = replaceParamsWithItsLowerBounds(paramDomain, ub2).toAffine();
					if (lub2.getConstantTerm().getCoef() >= ub1.getConstantTerm().getCoef()) {
						bound = ub2;
						return bound;
					}
				}
				
				if (ub2.isConstant().equals(FuzzyBoolean.YES)) {
					AffineExpression lub2 = replaceParamsWithItsLowerBounds(paramDomain, ub1).toAffine();
					if (lub2.getConstantTerm().getCoef() >= ub2.getConstantTerm().getCoef()) {
						bound = ub1;
						return bound;
					}
				}
				
				int nTerms1 = ub1.getTerms().size();
				int nTerms2 = ub2.getTerms().size();
				
				IntExpression diff = nTerms1 > nTerms2 ? IntExpressionBuilder.sub(ub1, ub2) : IntExpressionBuilder.sub(ub2, ub1);
				diff = diff.simplify();
				
				AffineExpression ldiff = replaceParamsWithItsLowerBounds(paramDomain, diff).toAffine();
				if (ldiff.isConstant().equals(FuzzyBoolean.YES)) {
					if (ldiff.getConstantTerm().getCoef() >= 0) {
						bound = nTerms1 > nTerms2 ? ub1 : ub2;
					} else {
						bound = nTerms1 > nTerms2 ? ub2 : ub1;
					}
				} 
			
				boolean eqExp = true;
				for (AffineTerm at : ub1.getTerms()) {
					if (at.getVariable() == null) {
						continue;
					} 
					boolean eqTermFound = false;
					for (AffineTerm atb : ub2.getTerms()) {
						if (atb.getVariable() == null) {
							continue;
						}
						
						eqTermFound = atb.isEquivalent(at);
						if (eqTermFound) {
							break;
						}
					}
					
					eqExp &= eqTermFound;
				}
				
				if (eqExp) {
					System.out.println("cub: " + ub1.toString());
					long cub = ub1.toAffine().getConstantTerm()==null?0:ub1.toAffine().getConstantTerm().getCoef();
					long coub = ub2.toAffine().getConstantTerm()==null?0:ub2.toAffine().getConstantTerm().getCoef();
					if (cub > coub) {
						bound = ub1;
					} else {
						bound = ub2;
					}
				}
				
				return bound;
 
			} else {
				Map<Integer, IntExpression> boundofBounds = new HashMap<Integer, IntExpression>();
				for (IntExpression ie : rb.getExpressions()) {
//					if (!isMax) {
					IntExpression lb = replaceParamsWithItsLowerBounds(paramDomain, ie);
					if (lb.isConstant().equals(FuzzyBoolean.YES)) {
						int coef = (int) lb.toAffine().getConstantTerm().getCoef();
						if (boundofBounds.get(coef) != null) {
							if (boundofBounds.get(coef).isConstant().equals(FuzzyBoolean.YES)) {
								continue;
							}
						}
						boundofBounds.put((int) lb.toAffine().getConstantTerm().getCoef(),ie);
					} else {
						throw new RuntimeException("Lower bound contains non-parameters");
					}
//					}
				}
				
				List<Integer> bbs = new ArrayList<Integer>(boundofBounds.keySet());
				Collections.sort(bbs);
				bound = boundofBounds.get(bbs.get(0));
				return bound;
			}
		} else {
			throw new RuntimeException(bound + " is not an AffineExpression or a ReductionExpression!" );
		}
		
	}
*/
	private Map<Integer, List<IntExpression>> copyOfMap (Map<Integer, List<IntExpression>> bb) {
		Map<Integer, List<IntExpression>> bbc = new HashMap<Integer, List<IntExpression>>();
		
		for (Entry<Integer, List<IntExpression>> entry : bb.entrySet()) {
			bbc.put(entry.getKey(), copyOfIntExpressions(entry.getValue()));
		}
		
		return bbc;
	}
	
	private List<IntExpression> copyOfIntExpressions(List<IntExpression> iexps) {
		List<IntExpression> iexpsc = new ArrayList<IntExpression>();
		
		for (IntExpression iexp : iexps) {
			iexpsc.add(iexp.copy());
		}
		
		return iexpsc;
	}

	@Override
	public void outScopFor(ScopFor s) {
		currentDepth = s.getLoopDepth()+getPrevBandStart()-1;
		if (currentDepth > getCurBandEnd()) {
			return;
		}
		
		if ((getCurBandEnd()) == s.getLoopDepth() + getPrevBandStart() - 1) {
//			PCOTFunctionInfo fi = 
//					new PCOTFunctionInfo(fInfo.getCurrentBand(), 
//							fInfo.getPreviousBand(), sysName, blockId);
//			tempInfo = fi;
			tempInfo.addInner(s);
			tempInfo.addBody(s.getBody());
			
		}
		
		
		
		if ((getCurBandStart()) == s.getLoopDepth() + getPrevBandStart() - 1) {
			//create function call
			List<IntExpression> cp = 
					new ArrayList<IntExpression>(EcoreUtil.copyAll(params));
			
			for (int dim=1; dim < getCurBandStart(); dim++) {
				cp.add(IntExpressionBuilder.affine(IntExpressionBuilder.var("c"+dim)));
			}
			
			for (int dim = getCurBandStart(); dim <= getCurBandEnd(); dim++) {
				cp.add(boundingBox.get(dim).get(0).copy());
			}
			
			for (int dim = getCurBandStart(); dim <= getCurBandEnd(); dim++) {
				cp.add(IntExpressionBuilder.add(IntExpressionBuilder.sub(
						boundingBox.get(dim).get(1).copy(), 
						boundingBox.get(dim).get(0).copy()),1).simplify());				
			}
			
			if (isParallel()) {
				cp.add(IntExpressionBuilder.constant(0));
			}
			
			cp.addAll(EcoreUtil.copyAll(vars));
			
////			PCOTFunctionInfo fi = 
////					new PCOTFunctionInfo(copyOfMap(boundingBox), 
////							fInfo.getCurrentBand(), fInfo.getPreviousBand(), 
////							sysName, blockId);
//			recursiveFuncitions.add(fi);
			
			ScopStatementMacro stmt = 
					ScopUserFactory.scopStatementMacro(
							tempInfo.getRecursiveFunctionName(), cp);
//			if (isParallel()) {
//				stmt.getScopAnnotations().add(ScopUserFactory.singleAnnotation());
//			}
			Map<Integer, List<IntExpression>> copyBoundingBox = copyOfMap(boundingBox);
			// clear bounding box
			int bbBoxSize = boundingBox.size();
			for (int dim = getCurBandStart(); dim <= bbBoxSize; dim++) {
				boundingBox.get(dim).clear();
			}
			
			
			ScopFor body = s;
			EcoreUtil.replace(s, stmt);
			tempInfo.setScopRoot(body);
			tempInfo.setOuter(body);
			tempInfo.setBoundingBox(copyBoundingBox);
			tempInfo.setConvexHull(convexHull);
			tempInfo.setLoopVars(loopVarNames);
			recursiveFuncitions.add(tempInfo);
			blockId++;
		}
		
		if (getCurBandStart() > currentDepth) {
			boundingBox.get(currentDepth).clear();
		}
		
		previousDepth = currentDepth;
	}

	@Override
	public void inScopBlock(ScopBlock s) {
		
	}

	@Override
	public void outScopBlock(ScopBlock s) {
		
	}

	@Override
	public void inScopGuard(ScopGuard s) {
		guards.add(s.getConstraintSystems());
	}

	@Override
	public void outScopGuard(ScopGuard s) {
		guards.remove(guards.size()-1);
	}

	/*public static void computeBoundingBox(ScopRoot sroot) {
		sroot.accept(new PCOTScopVisitor());
	}*/

	/*public static List<PCOTFunctionInfo> kernelMain(ScopRoot sroot,
			HierarchyBandDTilingOptions band, String funcname, 
			EList<IntExpression> params, EList<IntExpression> vars) {
		PCOTScopVisitor pv = new PCOTScopVisitor(band, funcname, 
				params, vars);
		sroot.accept(pv);
		return pv.getRecursiveFuncitions();
	}*/

	public static List<PCOTFunctionInfo> getBaseFunctionBody(String sysName, 
			EList<IntExpression> params, EList<IntExpression> vars, 
			PCOTFunctionInfo pcotFInfo) {
		PCOTScopVisitor pv = new PCOTScopVisitor(sysName, params, vars, 
				pcotFInfo);
		pcotFInfo.getScopRoot().accept(pv);
		
		return pv.getRecursiveFuncitions();
	}
	
/*	private IntExpression replaceParamsWithItsLowerBounds(Domain paramDomain,
			IntExpression lb) {
		Map<Variable, IntExpression> moreLB = new HashMap<Variable, IntExpression>();
		if (lb instanceof ReductionExpression) {
//						ReductionExpression re = lb.toReduction();
//						re.getExpressions()
			//TODO
		} else { //AffineExpression
			AffineExpression alb = lb.toAffine();
			List<AffineTerm> newTerms = new ArrayList<AffineTerm>();
			
			Domain paramDomainCopy = PolyhedralIRUserFactory._polyFact.createDomain(paramDomain);
			List<List<String>> sicss = new ArrayList<List<String>>();
			for (IntConstraintSystem ics : paramDomainCopy.getPolyhedra()) {
				List<String> sics = new ArrayList<String>();
				for (IntConstraint ic : ics.getConstraints()) {
					sics.add(ic.toString(OUTPUT_FORMAT.ALPHABETS));
				}
				for (List<IntConstraintSystem> gicss : guards) {
					for (IntConstraintSystem gics : gicss) {
						for (IntConstraint gic : gics.getConstraints()) {
							sics.add(gic.toString(OUTPUT_FORMAT.ALPHABETS));
						}
					}
				}
				
				sicss.add(sics);
			}
			paramDomainCopy = PolyhedralIRUtility.parseDomainUnion(
					paramDomainCopy.getParams(), paramDomainCopy.getIndices(), 
					sicss).getPMdomain();
//			org.polymodel.polyhderalIR.Domain ggg = PolyhedralIRUserFactory._polyFact.
//			Domain paramDomainCopy = EcoreUtil.copy(paramDomain);
			for (List<IntConstraintSystem> ics : guards) {
//				Domain temp = PolyhedralIRUserFactory.eINSTANCE.createDomain(paramDomainCopy.getParams(), paramDomainCopy.getIndices(), ics).getPMdomain();
				for (IntConstraintSystem ic : ics) {
//					paramDomainCopy.getPolyhedra().get(0).getConstraints().addAll(ic.getConstraints()); 
					for (IntConstraint c : ic.getConstraints()) {
						paramDomainCopy.addConstraint(c);
					}
				}
//				paramDomainCopy = paramDomainCopy.intersection(temp);
				
				paramDomainCopy.simplify();
			}
			
//			paramDomainCopy = paramDomainCopy.simplify();
			
			paramDomainCopy.simplify();
			
			for (AffineTerm at : alb.getTerms()) {
				Variable param = at.getVariable();
				param = getVariable(param, paramDomainCopy.getParams());
				if (param != null && !moreLB.containsKey(param)) {
					//I assume this is a program parameter.	
					
					IntExpression pexp = paramDomainCopy.getPolyhedra().get(0).getLB(param);
//								IntExpression pexp = ics.getLB(param);
//								if (pexp.isConstant().compareTo(FuzzyBoolean.YES)==0) {
//									
//								}
					moreLB.put(param, pexp);
					newTerms.addAll(pexp.toAffine().getTerms());
				} else {
					if (param == null) {
						newTerms.add(at);
					} else {
						newTerms.addAll(moreLB.get(param).toAffine().getTerms());
					}
				}
			}
			lb = IntExpressionBuilder.affine(newTerms);
		}
		return lb;
	}
*/
	/*private Variable getVariable(Variable param, EList<Variable> eList) {
		if (param == null) {
			return null;
		}
		for (Variable v : eList) {
			if (v.getName().equals(param.getName())) {
				return v;
			}
		}
		return null;
	}*/
}
