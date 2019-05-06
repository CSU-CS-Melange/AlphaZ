package org.polymodel.polyhedralIR.transformation;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.SIGNED;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ExternalFunctionDeclaration;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.VariableIdentifier;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.targetMapping.MEMORY_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILE_SIZE_TYPE;
import org.polymodel.polyhedralIR.targetMapping.TILING_TYPE;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.polyhedralIR.analysis.PRDGBuilder;
import org.polymodel.polyhedralIR.impl.PolyhedralIRInheritedDepthFirstVisitorImpl;


import tom.library.sl.VisitFailure;

/**
   Inline takes two StandardEquation as input, one as the equation to apply the transformation,
   and the other as the equation to be inlined.
   Inline replaces every VariableExpression in the target equation, referring to the equation to be inlined,
   with the expression of the equation to inline.
    
*/
public class Inline extends PolyhedralIRTomTransformation {

    protected static Inline INSTANCE;
	protected final StandardEquation _targetEq;
	protected final StandardEquation _inlineEq;
	protected static boolean CheckCounter;
	protected static int num;
	protected final Domain _inlineContext;

	//a counter used to count the occurence
	protected static int counter;

	/**
	   Inline the definition of the variable inlineEq once in all expressions of the targetEq.
	   If force is not true, equations with self depenences are not inlined. 
	*/
	public static void transform(StandardEquation targetEq, StandardEquation inlineEq, boolean force){
		INSTANCE = new Inline(targetEq, inlineEq);
		if(!force){	//check self dependence
			if(INSTANCE.selfDependenceCheck()){
				throw new RuntimeException("The specified equation have a self dependence, and cannot be inlined. Use InlineForce command to override this check.");
			}
		}
		INSTANCE.transform(targetEq);
	}

	/**
	   Inline the definition of the variable inlineEq for the specified number of times in all expressions of the targetEq.
	   If force is not true, equations with self depenences are not inlined. 
	*/
	public static void transform(StandardEquation targetEq, StandardEquation inlineEq, int number, boolean force){
		Inline ts = new Inline(targetEq, inlineEq);
		if(!force){
			if(ts.selfDependenceCheck()){
				throw new RuntimeException("The specified equation have a self dependence, and cannot be inlined. Use InlineForce command to override this check.");
			}
		}
		
		INSTANCE = new Inline(targetEq, inlineEq, number);
		INSTANCE.transform(targetEq);
		//for (int i = 0; i < number; i++) {
		 //   Inline s = new Inline(targetEq, inlineEq);
		 //   s.transform(targetEq);
        //}
	}

	/**
	   Inline the definition of the variable inlineEq once in all expressions in the system.
	   If force is not true, equations with self depenences are not inlined. 
	*/
	public static void transformAll(AffineSystem system, StandardEquation inlineEq, boolean force){
		EList<StandardEquation> equations = system.getEquations();
		List<StandardEquation> tempEquationList = new LinkedList<StandardEquation>();
		tempEquationList.addAll(equations);
		if(!force){
			//check if there exists a self dependence for the inlining equation
			Inline ts = new Inline(inlineEq, inlineEq);
			if(ts.selfDependenceCheck()){
				throw new RuntimeException("The specified equation have a self dependence, and cannot be inlined. Use InlineAllForce command to override this check.");
			}
		}
		
		//remove the inline equation itself 
		//do inline in itself at the end
		tempEquationList.remove(inlineEq);
		//loop round all the equations in the original program
		for(StandardEquation eq : tempEquationList){
			INSTANCE = new Inline(eq, inlineEq);
			INSTANCE.transform(eq);
		}
		INSTANCE = new Inline(inlineEq, inlineEq);
		INSTANCE.transform(inlineEq);
	}
	
	 //check weather their is a self dependence for the substitution equation
     private boolean selfDependenceCheck(){
    	String var = _inlineEq.getVariable().getName();
    	SelfDependenceDetection sd = new SelfDependenceDetection(var);
    	return sd.checkSelfDependence(_inlineEq.getExpression());
    }

	protected Inline(StandardEquation targetEq, StandardEquation inlineEq){
		_targetEq = targetEq;
		_inlineEq = inlineEq;
		_inlineContext = inlineEq.getExpression().getContextDomain().copy();
		CheckCounter = false;
		num = -1;
		counter = -1;

		if (_targetEq == null) {
			throw new RuntimeException("Target Equation given is null");
		}
		if (_inlineEq == null) {
			throw new RuntimeException("Equation to inline given is null");
		}
	}

	protected Inline(StandardEquation targetEq, StandardEquation inlineEq, int number){
		_targetEq = targetEq;
		_inlineEq = inlineEq;
		_inlineContext = inlineEq.getExpression().getContextDomain().copy();
		CheckCounter = true;
		num = number;
		counter = 0;

		if (_targetEq == null) {
			throw new RuntimeException("Target Equation given is null");
		}
		if (_inlineEq == null) {
			throw new RuntimeException("Equation to inline given is null");
		}
	}

	@Override
	protected EObject apply(EObject o) throws VisitFailure {
		try{
			EObject t =	`BottomUp(InlineExpr(_inlineEq.getVariable(), _inlineEq.getExpression().copy())).visitLight((StandardEquation)o, tom.mapping.GenericIntrospector.INSTANCE);
			return t;
		}catch(ClassCastException e) {
			throw new IllegalArgumentException(o+ "isn't a StandardEquation");
		}
	}

	%include { polyhedralIR.tom }
	%include { sl.tom } 
	
	%strategy InlineExpr(inlineVar : VariableDeclaration, inlineExpr : Expression) extends Identity() {		
		visit Expression {
			var@var(varDecl) -> { if (inlineVar.equals(`varDecl)) {
									counter++;
									if((CheckCounter && counter == num) || !CheckCounter){
										Domain context = INSTANCE._inlineContext.copy();
										Expression exprCopy = inlineExpr.copy();
										
										return `restrictExpr(context, exprCopy);
									}else{
										return `var;
									}
								  } else {
									return `var;
								  } }
		}
	}
	
	public class SelfDependenceDetection extends PolyhedralIRInheritedDepthFirstVisitorImpl{
	private boolean _isSelf;
	private String _variableName;

	public SelfDependenceDetection(String variableName){
		_variableName = variableName;
	}
	
	private boolean checkSelfDependence(Expression exp){
		this._isSelf = false;
		exp.accept(this);
		return this._isSelf;
	}

	@Override
	public void outVariableExpression(VariableExpression v) {
		outExpression(v);
		if(v.getVarDecl().getName().equals(this._variableName)){
			this._isSelf = true;
			return;
		}
	}
}
}

