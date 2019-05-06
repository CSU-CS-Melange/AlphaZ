package org.polymodel.polyhedralIR.transformation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.polymodel.algebra.FuzzyBoolean;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.IndexExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.impl.PolyhedralIRDepthFirstVisitorImpl;

/***
 * Assumes Normalized program
 * 
 * @author yuki
 *
 */
public class InlineConstants {

	public static boolean DEBUG = false;
	
	protected final AffineSystem targetSystem;
	
	//protected to hide constructor of the class
	protected InlineConstants(AffineSystem targetSystem) {
		this.targetSystem = targetSystem;
	}

	public static List<String> apply(AffineSystem system) {
		InlineConstants inline = new InlineConstants(system);
		return inline.run();
	}
	
	private List<String> run() {
		FindCandidateEquations findCandidates = new FindCandidateEquations();

		if (DEBUG) System.out.println("===InlineConstants: " + targetSystem.getName() + " ==="); 

		targetSystem.accept(findCandidates);
		
		for (InlineCandidate ic : findCandidates.candidates)
			Inline.transformAll(targetSystem, ic.equation, false);
		
		
		List<String> inlinedEqs = new ArrayList<String>(findCandidates.candidates.size());
		for (InlineCandidate ic : findCandidates.candidates) {
			inlinedEqs.add(ic.equation.toString());
		}
		
		RemoveVariable.apply(targetSystem, inlinedEqs);
		
		return inlinedEqs;
	}

	
	private class FindCandidateEquations extends PolyhedralIRDepthFirstVisitorImpl {
		
		protected List<InlineCandidate> candidates = new LinkedList<InlineCandidate>();
		
		protected StandardEquation currentEquation = null;
		protected boolean invalid = false;
		
		protected FindCandidateEquations() {
			
		}
		
		@Override
		public void inStandardEquation(StandardEquation s) {
			currentEquation = s;
			invalid = false;

			if (DEBUG) System.out.println("Starting Equation: " + currentEquation.getVariable().getName()); 
		}
		
		@Override
		public void visitStandardEquation(StandardEquation s) {
			//output variables cannot be fully inlined
			if (s.getVariable().isOutput()) return;
			
			//if its scalar, inline it without question
			if (s.getVariable().getDomain().getNIndices() == 0) {
				inStandardEquation(s);
				outStandardEquation(s);
			} else {
				super.visitStandardEquation(s);
			}
		}
		
		@Override
		public void outStandardEquation(StandardEquation s) {
			if (!invalid) {
				candidates.add(new InlineCandidate(currentEquation));
			}

			if (DEBUG) System.out.println("Exiting Equation: " + currentEquation.getVariable().getName() + " invalid:" + invalid);
			
			currentEquation = null;
			invalid = false;
		}
		
		@Override
		public void inVariableExpression(VariableExpression v) {
			//scalar inputs are always inlined when possible
			if (v.getVarDecl().isInput() && v.getVarDecl().getDomain().getNIndices() == 0) {
				return;
			}
			//Heuristic choice:
			if (v.eContainer() instanceof DependenceExpression) {
				AffineFunction dep = ((DependenceExpression)v.eContainer()).getDep();
				
				//System.err.println(v.getVarDecl().getName() + "["+v.getVarDecl().isInput()+"]"+dep + " " + dep.isBijective() + " " + dep.isIdentity());
				
				//
				if (v.getVarDecl().isInput() && !dep.isBijective()) {
					invalid = true;
					if (DEBUG) 
						System.out.println("\tInvalid Flagged at " + v.getVarDecl().getName() + " not bijective");
				} else if (!v.getVarDecl().isInput() && !dep.isIdentity()) {
					invalid = true;
					if (DEBUG) 
						System.out.println("\tInvalid Flagged at " + v.getVarDecl().getName() + " not identity");
				}
			}
			//if the containing expression is not dependence, its identity => bijective
		}
		
		@Override
		public void inIndexExpression(IndexExpression i) {
			if (!(i.getFunction().getExpressions().get(0).toAffine().isConstant()==FuzzyBoolean.YES)) {
				invalid = true;
				if (DEBUG) 
					System.out.println("\tInvalid Flagged at val" + i.getFunction() + " not constant");
			}
		}
		
		
	}
	
	protected class InlineCandidate {
		protected final StandardEquation equation;
		protected int operationCount;
		
		protected InlineCandidate(StandardEquation eq) {
			equation = eq;
		}
		
		@Override
		public String toString() {
			return equation.getVariable().getName();
		}
	}
}
