package org.polymodel.polyhedralIR.transformation.reduction;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.EList;

import tom.library.sl.VisitFailure;

import java.util.List;
import java.util.LinkedList;

import org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;
import org.polymodel.polyhedralIR.*;
import org.polymodel.polyhedralIR.expression.*;
import org.polymodel.polyhedralIR.transformation.PolyhedralIRTomTransformation;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;

/**
 PermutationCaseReduce looks for CaseExpression inside ReduceExpression, 
 and transforms the program s.t. CaseExpression is outside ReduceExpressions.

*/
public class PermutationCaseReduce extends PolyhedralIRTomTransformation {

	private static final boolean DEBUG = false;
	private static boolean modified = false;

	public static void caseReduce(Program p){
		PermutationCaseReduce cr = new PermutationCaseReduce();
		cr.transform(p);
	}
	public static void caseReduce(AffineSystem s){
		PermutationCaseReduce cr = new PermutationCaseReduce();
		cr.transform(s);
	} 
	public static void caseReduce(StandardEquation eq){
		PermutationCaseReduce cr = new PermutationCaseReduce();
		cr.transform(eq);
	}

	protected PermutationCaseReduce(){} 

	@Override
	protected EObject apply(EObject o) throws VisitFailure {
		try{
			EObject t =	`BottomUp(CaseReduce()).visitLight(o, tom.mapping.GenericIntrospector.INSTANCE);
			if(DEBUG){
				System.out.println(t.toString());
			}
			while(modified){
				modified = false;
				o = t;
				t = `BottomUp(CaseReduce()).visitLight(o, tom.mapping.GenericIntrospector.INSTANCE);
				if(DEBUG){
					System.out.println(t.toString());
				}
			}

			return t;
		}catch(Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Error while processing input : " + o);
		}
	}
  
	%include { sl.tom }
	%include { polyhedralIR.tom }
	
	%strategy CaseReduce() extends Identity() {
		visit Expression {
			redExp@reduce(op, proj, caseExpr(_)) -> { return applyCaseReduce((ReduceExpression)`redExp); }
		}
	}

	public static Expression applyCaseReduce(ReduceExpression redExpr) {
		modified = true;
        // get child expressions
        CaseExpression caseExpr = (CaseExpression)redExpr.getExpr();
        OP op = redExpr.getOP();
        AffineFunction proj = redExpr.getProjection();
        
        //When there is only one branch in case
        if (caseExpr.getExprs().size() == 1) {
        	if(DEBUG){
        		System.out.println("There is only one branch");
        	}
        	return PolyhedralIRUserFactory.eINSTANCE.createReduceExpression(op, proj, caseExpr.getExprs().get(0).copy());
        }

        //Compute the domain of each branch projected to the answer space of the reduction
        List<Domain> projectedDomains = new LinkedList<Domain>();
        for (Expression e : caseExpr.getExprs()) {
        	if(DEBUG){
        		System.out.println("project function:" + proj);
        		System.out.println("contextDomain:" + e.getContextDomain());
        		System.out.println("Image:" + e.getContextDomain().image(proj));
        	}
        	Domain D = e.getContextDomain().image(proj);
        	D.simplify();
        	projectedDomains.add(D);
        }

        //First branch will be peeled out
        Domain D1 = projectedDomains.get(0).copy();
        
        if(DEBUG){
        	System.out.println("D1:" + D1);
        }

        //the union of the remaining branch
        Domain D2 = projectedDomains.get(1).copy();
        for(int i = 2; i < projectedDomains.size(); i++){
        	D2 = D2.union(projectedDomains.get(i).copy());
        }
        D2.simplify();
        
        if(DEBUG){
        	System.out.println("D2:" + D2);
        }
        
        // Fix (Guillaume)
        if (D1.isEmpty() && D2.isEmpty()) {
        	// The expression is not reachable => We can return anything (as soon as it is syntactically coherent)
        	return PolyhedralIRUserFactory.eINSTANCE.createReduceExpression(op, proj, caseExpr.getExprs().get(0).copy());
        }
        
        
        //construct reduction with the first expression
        Expression peelOutExpr = caseExpr.getExprs().get(0).copy();
        ReduceExpression red1 = PolyhedralIRUserFactory.eINSTANCE.createReduceExpression(op, proj.copy(), peelOutExpr);

        //Construct the reduction with case, but with one less branch
       	List<Expression> remainingBranch = new LinkedList<Expression>();
       	for (int i = 1; i < caseExpr.getExprs().size(); i++) {
       		remainingBranch.add(caseExpr.getExprs().get(i).copy());
       	}
       	CaseExpression newCase = PolyhedralIRUserFactory.eINSTANCE.createCaseExpression(remainingBranch);
		ReduceExpression red2 = PolyhedralIRUserFactory.eINSTANCE.createReduceExpression(op, proj.copy(), newCase);

        // create the expressions for new case
        List<Expression> newExprs = new LinkedList<Expression>();

        //get D12
        Domain intersect = D1.copy();
        intersect = intersect.intersection(D2);

        if(DEBUG){
        	System.out.println("D12:" + intersect);
        }

       	//Compute the domain and new expression of the first branch, which will be peeled out
       	Domain peelOutDom = projectedDomains.get(0).copy();

        peelOutDom = peelOutDom.difference(intersect);
        peelOutDom.simplify();

        if(DEBUG){
        	System.out.println("D1 - D12:" + peelOutDom);
        }

       	//If it can be peeled out
       	if (!peelOutDom.isEmpty()) {
       		newExprs.add(PolyhedralIRUserFactory.eINSTANCE.createRestrictExpression(peelOutDom, red1.copy()));
       	}
       	

       	//compute the domain for the remaining branch
       	Domain remainingDom = D2.copy();
       	remainingDom = remainingDom.difference(intersect);

       	if(DEBUG){
       		System.out.println("D2 - D12:" + remainingDom.toString());
       	}
       	
       	//If there is remaining
       	if (!remainingDom.isEmpty()) {
       		newExprs.add(PolyhedralIRUserFactory.eINSTANCE.createRestrictExpression(remainingDom, red2.copy()));
       	}
       	
       	
       	//When union is not empty, create a branch of the form 'peeledOutExpr + reduce(op, proj, caseExpr)'
       	if (!intersect.isEmpty()) {
			//Combine the two with reduction operator, and put it in the outer case expression
       		Expression combined = PolyhedralIRUserFactory.eINSTANCE.createBinaryExpression(op, red1.copy(), red2.copy());
			newExprs.add(PolyhedralIRUserFactory.eINSTANCE.createRestrictExpression(intersect, combined));
       	}
       	
        // create new case exp if there are multiple branches
        if (newExprs.size() > 1) {
        	return PolyhedralIRUserFactory.eINSTANCE.createCaseExpression(newExprs);
        } else {
        	return newExprs.get(0);
        }
	}
	
}