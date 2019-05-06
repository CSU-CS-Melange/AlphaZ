package org.polymodel.polyhedralIR.analysis;


import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.impl.PolyhedralIRInheritedDepthFirstVisitorImpl;
import org.polymodel.polyhedralIR.transformation.NormalizeVisitor;
import org.polymodel.prdg.EdgeFunction;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.PRDGSubSystemHyperEdge;
import org.polymodel.prdg.factory.PRDGUserFactory;

public class PRDGBuilder extends PolyhedralIRInheritedDepthFirstVisitorImpl{
	protected AffineSystem _system;
	protected PRDG _prdg;
	
	protected AffineFunction _currentDep;
	protected PRDGNode _currentNode;
	protected int _reduceNum;
	
	protected boolean noInputs = true;
	
	public static PRDG build(AffineSystem system) {
		return build(system, true);
	}
	public static PRDG build(AffineSystem system, boolean noInputs) {
		PRDGBuilder builder = new PRDGBuilder(system, noInputs);
		
		return builder._prdg;
	}
	
	
	
	// Full constructor
	protected PRDGBuilder(AffineSystem system, boolean noInputs) { 
		this.noInputs = noInputs;
		_system = EcoreUtil.copy(system);
		NormalizeVisitor.normalize(_system);
		_prdg = PRDGUserFactory.createPRDG();
		
		_system.accept(this);
	}
	
	
	
	/*********** visitor **************/
	public void visitProgram(Program p) {
		throw new RuntimeException("PRDG can only be constructed for an AffineSystem");
	}
	
	public void inAffineSystem(AffineSystem a) {
		if (!noInputs) {
			createPRDGNodes(a.getInputs());
		}
		createPRDGNodes(a.getLocals());
		createPRDGNodes(a.getOutputs());
	}
	
	@Override
	public void inStandardEquation(StandardEquation s) {
		_currentDep = PolyhedralIRUtility.createIdentityFunction(s.getVariable().getDomain());
		_currentNode = _prdg.getNode(s.getVariable().getName());
		_reduceNum = 0;
	}
	
	@Override
	public void outStandardEquation(StandardEquation s) {
		_currentDep = null;
		_currentNode = null;
		_reduceNum = 0;
	}
	
	public void visitUseEquation(UseEquation u) {
		// Creating the nodes of the inputs expressions
		List<PRDGNode> linputs = new BasicEList<PRDGNode>();
		int numInput = 0;
		for (Expression inExpr : u.getInputs()) {
			String nameInput = "useEq_" + u.getOutputs().get(0).getName() + "_input" + numInput;
			numInput++;
			
			PRDGNode inNode = PRDGUserFactory.createPRDGNode(nameInput, inExpr.getContextDomain().copy().getPMdomain());
			_prdg.getNodes().add(inNode);
			linputs.add(inNode);
			
			// Visiting the input expression
			_currentDep = PolyhedralIRUtility.createIdentityFunction(inExpr.getContextDomain());
			_currentNode = inNode;
			_reduceNum = 0;
			
			inExpr.accept(this);
			
			_currentDep = null;
			_currentNode = null;
			_reduceNum = 0;
		}
		
		// Getting the outputs
		List<PRDGNode> loutputs = new BasicEList<PRDGNode>();
		for (VariableDeclaration outVar : u.getOutputs())
			loutputs.add(_prdg.getNode(outVar.getName()));
		
		// Building the hyperedge and updating them
		//		* destinations: the nodes of input expressions
		//		* sources: the nodes of output variables
		//		* extDom/param: those from the useEquation
		PRDGSubSystemHyperEdge hypEdge = PRDGUserFactory.createPRDGHEdge(loutputs, linputs, u.getExtensionDomain().getPMdomain(), u.getParameters().getPMmapping());
		_prdg.getHedges().add(hypEdge);
	}
	
	public void visitDependenceExpression(DependenceExpression d) {
		AffineFunction temp = _currentDep;
		_currentDep = d.getDep().compose(_currentDep);
		
		visitExpression(d);

		_currentDep = temp;
	}
	
	public void visitVariableExpression(VariableExpression v) {
		EdgeFunction func = PRDGUserFactory.createDependenceFunction(_currentDep.copy().getPMmapping());
		
		if (noInputs && v.getVarDecl().isInput()) return;
		
		PRDGNode dst = _prdg.getNode(v.getVarDecl().getName());
		
		//When the parent is a dependence expression, the context domain of that dependence is what we want
		// otherwise, assume identity dependence and use the context domain of the variable
		if (v.eContainer() instanceof DependenceExpression) {
			_prdg.getEdges().add(PRDGUserFactory.createPRDGEdge(_currentNode, dst, ((DependenceExpression)v.eContainer()).getContextDomain().copy().getPMdomain(), func));
		} else {
			_prdg.getEdges().add(PRDGUserFactory.createPRDGEdge(_currentNode, dst, v.getContextDomain().copy().getPMdomain(), func));
		}
	}
	
	public void visitReduceExpression(ReduceExpression r) {
		_reduceNum++;
		
		//Node for result
		String resName = _currentNode.getName() + "_reduce" + _reduceNum + "_result";
		_prdg.getNodes().add(PRDGUserFactory.createPRDGNode(resName, r.getContextDomain().copy().getPMdomain()));
		
		//Dependence from use to the result
		EdgeFunction useToRes = PRDGUserFactory.createDependenceFunction(_currentDep.copy().getPMmapping());
		//When the parent is a dependence expression, the context domain of that dependence is what we want
		// otherwise, assume identity dependence and use the context domain of the variable
		if (r.eContainer() instanceof DependenceExpression) {
			_prdg.getEdges().add(PRDGUserFactory.createPRDGEdge(_currentNode, _prdg.getNode(resName), ((DependenceExpression)r.eContainer()).getContextDomain().copy().getPMdomain(), useToRes));
		} else {
			_prdg.getEdges().add(PRDGUserFactory.createPRDGEdge(_currentNode, _prdg.getNode(resName), r.getContextDomain().copy().getPMdomain(), useToRes));
		}
		
		//Node for body
		String bodyName = _currentNode.getName() + "_reduce" + _reduceNum + "_body";
		_prdg.getNodes().add(PRDGUserFactory.createPRDGNode(bodyName, r.getExpr().getContextDomain().copy().getPMdomain()));

		//Dependence from result to body
		EdgeFunction resToBody = PRDGUserFactory.createProjectionFunction(r.getProjection().copy().getPMmapping());
		_prdg.getEdges().add(PRDGUserFactory.createPRDGEdge(_prdg.getNode(resName), _prdg.getNode(bodyName), r.getExpr().getContextDomain().copy().getPMdomain(), resToBody));

		//Inside the reduction, dependence is from the body
		PRDGNode temp = _currentNode;
		_currentNode = _prdg.getNode(bodyName);
		//Inside the reduction, dependence starts from identity to the reduction body
		AffineFunction depTemp = _currentDep;
		_currentDep = PolyhedralIRUtility.createIdentityFunction(r.getExpr().getContextDomain());
		visitExpression(r);
		_currentDep = depTemp;
		_currentNode = temp;
		
	}
	
	protected void createPRDGNodes(EList<VariableDeclaration> vars) {
		for(VariableDeclaration var : vars) {
			_prdg.getNodes().add(PRDGUserFactory.createPRDGNode(var.getName(), var.getDomain().copy().getPMdomain()));
		}
	}
	
	
	// ------------------------------------------------------------------
	
}
