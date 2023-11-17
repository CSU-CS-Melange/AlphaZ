package org.polymodel.polyhedralIR.util;

import java.util.LinkedList;
import java.util.List;

import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ExternalFunctionDeclaration;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.PolyhedralIRVisitable;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.ConstantExpression;
import org.polymodel.polyhedralIR.expression.ExternalFunctionCall;
import org.polymodel.polyhedralIR.expression.MultiArgExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.expression.UnaryExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.impl.PolyhedralIRInheritedDepthFirstVisitorImpl;


public class PrintAST extends PolyhedralIRInheritedDepthFirstVisitorImpl {
	protected String indent;
	protected static final String INDENT_WITH_SIBILING = "   |";
	protected static final String INDENT_LAST_CHILD = "    ";
	protected StringBuffer _output;
	
	protected List<Integer> nodeIdTracker; 
	protected int depth;
	
	protected PrintAST() {
		indent = "";
		_output = new StringBuffer();
		nodeIdTracker = new LinkedList<Integer>();
		depth = 0;
	}
	
	
	public static String print(Program program) {
		PrintAST printer = new PrintAST();
		program.accept(printer);
		return printer._output.toString();
	}
	public static String print(AffineSystem system) {
		PrintAST printer = new PrintAST();
		system.accept(printer);
		return printer._output.toString();
	}

	protected void printInt(String prefix, long val) {
		printStr(prefix, val+"");
	}
	
	protected void printReal(String prefix, double val) {
		printStr(prefix, val+"");
	}
	
	protected void printStr(String prefix, String str) {
		_output.append(indent + prefix + str + "\n"); 
	}
	
	protected void nodeTrackIn() {
		//depth starts from 1 when starting from system
		depth++;
		if (nodeIdTracker.size() < depth) {
			nodeIdTracker.add(0);
		} else {
			nodeIdTracker.set(depth-1, nodeIdTracker.get(depth-1)+1);	
		}
		printId();
	}
	
	protected void nodeTrackOut() {
		depth--;
		if (nodeIdTracker.size() > depth+1) {
			nodeIdTracker.set(depth+1, -1);
		}
	}
	
	protected void printId() {
		StringBuffer id = new StringBuffer();
		for (int i = 0; i < depth; i++) {
			if (id.length() > 0) {
				id.append(",");
			}
			id.append(nodeIdTracker.get(i));
		}
		_output.append(indent + "nodeId = ("+id+")\n"); 
	}

	@Override
	public void defaultIn(PolyhedralIRVisitable node) {
		printStr("_", node.eClass().getName());
		//indentation
		//check if its the last child or not
//		List<?extends EObject> list = null;
//		if (node instanceof Expression) {
//			list = EMFUtils.eAllContentsInstancesOf(node.eContainer(), PolyhedralIRPackage.eINSTANCE.getExpression());
//		} else if (node instanceof AffineSystem) {
//			list = EMFUtils.eAllContentsInstancesOf(node.eContainer(), PolyhedralIRPackage.eINSTANCE.getAffineSystem());
//		} else if (node instanceof StandardEquation) {
//			list = ((StandardEquation) node).getContainerSystem().getEquations();
//		}
//		if (list != null && list.indexOf(node) == list.size()-1) {
//			indent += INDENT_LAST_CHILD;
//		} else {
			indent += INDENT_WITH_SIBILING;
//		}
	}

	@Override
	public void defaultOut(PolyhedralIRVisitable node) {
		//indentation
		indent = indent.substring(0, indent.length() - INDENT_WITH_SIBILING.length());
	}

	@Override
	public void inAffineSystem(AffineSystem a) {
		defaultIn(a);
		nodeTrackIn();
		printStr("_", a.getName());
	}
	@Override
	public void outAffineSystem(AffineSystem a) {
		nodeTrackOut();
		defaultOut(a);
	}

	@Override
	public void inExternalFunctionDeclaration(ExternalFunctionDeclaration e) {
		defaultIn(e);
		printStr("+-- ", e.getName());
	}

	@Override
	public void inParameterDomain(ParameterDomain p) {
		defaultIn(p);
		printStr("+-- ", p.toString());
	}

	@Override
	public void visitVariableDeclaration(VariableDeclaration v) {
		defaultIn(v);
		printStr("+-- ", v.getName());
		printStr("+-- ", v.getDomain().toString());
		printStr("+-- ", v.getType().toString());
		defaultOut(v);
	}

	@Override
	public void inStandardEquation(StandardEquation s) {
		defaultIn(s);
		nodeTrackIn();
		printStr("+-- ", s.getVariable().getName());
	}
	
	@Override
	public void outStandardEquation(StandardEquation s) {
		nodeTrackOut();
		defaultOut(s);
	}
	
	@Override
	public void visitUseEquation(UseEquation u) {
		defaultIn(u);
		nodeTrackIn();
		
		printStr("_","UseExpression");
		printStr("+-- ", u.getSubSystem().getName());
		printStr("+-- ", "(Label = " + u.getLabel() + ")");
		printStr("+--ExtDom--", u.getExtensionDomain().toString());
		
		// Parameters
		boolean fstexpr = true;
		String paramSub = "(";
		for (AffineExpression expr : u.getParameters().getExpressions()) {
			if (fstexpr) {
				paramSub += expr.toString();
				fstexpr = false;
			} else
				paramSub += ", " + expr.toString();
		}
		paramSub += ")";
		printStr("+--paramSub--", paramSub);
		
		// Input
		printStr("+--inputs--", " [");
		int nInputs = u.getInputs().size();
		for (int i=0; i<nInputs; i++) {
			Expression expInp = u.getInputs().get(i);
			if (i==0) {
				printStr("+--", ("Input "+i));
				expInp.accept(this);
			} else {
				printStr("+--", ("Input "+i));
				expInp.accept(this);
			}
		}
		printStr("--", " ]");
		
		// Output
		String outStr = "[";
		int nOutputs = u.getOutputs().size();
		for (int i=0; i<nOutputs; i++) {
			VariableDeclaration vdecl = u.getOutputs().get(i);
			if (i==0)
				outStr += vdecl.getName();
			else
				outStr += ", " + vdecl.getName();
		}
		outStr += "]";
		printStr("+--outputs--", outStr);
		
		nodeTrackOut();
		defaultOut(u);
	}
	
	@Override
	public void inExpression(Expression e) {
		defaultIn(e);
		printStr("+--expression--", e.getExpressionDomain()+"");
		printStr("+--context--", e.getContextDomain()+"");
		nodeTrackIn();
	}
	
	@Override
	public void outExpression(Expression e) {
		nodeTrackOut();
		defaultOut(e);
	}
	
	@Override
	public void inRestrictExpression(RestrictExpression r) {
		inExpression(r);
		printStr("+-- ", r.getRestrictDomain().toString());
	}

	@Override
	public void visitAffineFunction(AffineFunction a) {
		printStr("+-- ", a.toString());
	}

	@Override
	public void inVariableExpression(VariableExpression v) {
		inExpression(v);
		printStr("+-- ", v.getVarDecl().getName());
	}

	@Override
	public void inConstantExpression(ConstantExpression i) {
		inExpression(i);
		printStr("+-- ", PolyhedralIRToAlphabets.toString(i));
	}


	@Override
	public void visitDomain(Domain d) {
		
	}

	@Override
	public void inBinaryExpression(BinaryExpression b) {
		inExpression(b);
		printStr("+-- ", b.getOperator().toString());
	}

	@Override
	public void inUnaryExpression(UnaryExpression u) {
		inExpression(u);
		printStr("+-- ", u.getOperator().toString());
	}
	
	@Override
	public void inMultiArgExpression(MultiArgExpression m) {
		inExpression(m);
		if (m instanceof ExternalFunctionCall) {
			printStr("+-- ", ((ExternalFunctionCall) m).getExFunc().getName());
		} else {
			printStr("+-- ", m.getOperator().toString());
		}
	}

	@Override
	public void inReduceExpression(ReduceExpression r) {
		inExpression(r);
		printStr("+-- ", r.getOP().toString());
	}
}
