package org.polymodel.polyhedralIR.polyIRCG.generator.C;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.BooleanExpression;
import org.polymodel.polyhedralIR.expression.CaseExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.ExternalFunctionCall;
import org.polymodel.polyhedralIR.expression.IfExpression;
import org.polymodel.polyhedralIR.expression.IndexExpression;
import org.polymodel.polyhedralIR.expression.IntegerExpression;
import org.polymodel.polyhedralIR.expression.MultiArgExpression;
import org.polymodel.polyhedralIR.expression.RealExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.expression.UnaryExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.expression.util.ExpressionSwitch;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenUtility;
import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations;


/**
 * Pretty Printer for expressions of PolyhedralIR targeting C. This is taken
 * from the old StatementVisitor mainly for WriteC
 * 
 * @author yuki
 * 
 */
public class ExpressionPrinterForC extends ExpressionSwitch<String> {

	protected final TargetMapping targetMapping;
	protected final boolean mainFunction;
	protected ComputeReductionNumber reductionNumbers;
	
	/*
	 * Current dependence keeps track of sequence of dependencies (as its composition)
	 * from the domain of one of the two ancestors that are closer : StandardEquation or ReduceExpression
	 * In ScheduledC generated code, access to variables are affine functions of indices of LHS domain.
	 * In WriteC generated code, the name of indices used to evaluate expressions are either
	 *  evaluation function of a variable OR
	 *  function for computing a reduction
	 * Thus, all VariableExpression and IndexExpression will use the composed function and use the names
	 * of the indices used in the domain of its ancestor.
	 */
	protected AffineFunction _currentDep = null;
	
	protected ExpressionPrinterForC(TargetMapping tm, boolean mainFunction) {
		this.targetMapping = tm;
		this.mainFunction = mainFunction;
	}
	
	/**
	 * Starts the pretty printing of PolyhedralIR Expression to C code.
	 * 
	 * @param expr
	 * @return
	 */
	protected String start(Expression expr) {
		
		reductionNumbers = new ComputeReductionNumber();
		expr.getContainerEquation().accept(reductionNumbers);
		
		//Initialize currentDep with the identity from surrounding domain
		if (_currentDep == null) {
			EObject exp = expr;
			Domain surroundingDom = null;
			while (exp.eContainer() != null) {
				exp = exp.eContainer();
				
				//Check if the given expression is a direct child of a StandardEquation or Reduce
				if (exp instanceof DependenceExpression) {
					throw new RuntimeException("ExpressionPrinterForC is only applicable to expressions that are contained by StandardEquation or ReduceExpression without any DependenceExpression in between");
				}
				//Reached StandardEquation
				if (exp instanceof StandardEquation) {
					surroundingDom = ((StandardEquation)exp).getVariable().getDomain();
					break;
				}
				//Reached Reduce
				if (exp instanceof ReduceExpression) {
					//Surrounding domain is the pre-image of reduction domain by its projection 
					surroundingDom = ((ReduceExpression)exp).getContextDomain().preimage(((ReduceExpression)exp).getProjection());
					break;
				}
				
				//reach useEquation
				if(exp instanceof UseEquation){
//					surroundingDom = expr.getContextDomain();
					surroundingDom = DomainOperations.setFirstFewDimensions(expr.getContextDomain().copy(), ((UseEquation) exp).getExtensionDomain().getIndices());
					break;
				}
				
			}
			//If no surrounding domain was found
			if (surroundingDom == null) {
				throw new RuntimeException("Did not reach StandardEquation while traversing container of " + expr);
			}
			_currentDep = PolyhedralIRUtility.createIdentityFunction(surroundingDom);
		}
		//Count number of reductions
		expr.getContainerEquation().accept((new ComputeReductionNumber()));
		
		return this.doSwitch(expr);
	}

	@Override
	public String caseCaseExpression(CaseExpression node) {
		if (node.getContainerEquation() instanceof UseEquation)
			throw new RuntimeException("TODO: implement this method for UseEquation");
		
		// Special case when there is only one case
		if (node.getExprs().size() == 1) {
			return doSwitch(node.getExprs().get(0));
		}

		StringBuffer sbody = new StringBuffer();

		// Get String for all children first
		List<String> children = new LinkedList<String>();
		for (Expression child : node.getExprs()) {
			children.add(doSwitch(child));
		}

		// For each case, use the domain and generates an if then else
		// expression
		// nested if then else is generated to cover all cases
		for (int i = 0; i < children.size() - 1; i++) {
			Domain dom = node.getExprs().get(i).getContextDomain();
			//Take the image of the by the current dependence function
			dom = dom.preimage(_currentDep);
			//remove constraints that are already checked
			{
				Domain context = ((StandardEquation)node.getContainerEquation()).getVariable().getDomain();
				if (context.getDim() == dom.getDim()) {
					dom.simplifyInContext(context);
				} else {
					
					Domain origContext = ((StandardEquation)node.getContainerEquation()).getContainerSystem().getParameters().copy();
					for (int k=0; k<dom.getNIndices(); k++)
						origContext.addDimension("z"+k);
					
					dom.simplifyInContext(origContext);
					// OLD - BUGGY (cf Polybench-Durbin after monoparametric tiling + normalization for WriteC)
					//dom.simplifyInContext(((StandardEquation)node.getContainerEquation()).getContainerSystem().getParameters());
				}
			}

			List<String> names = new LinkedList<String>();
//			names.addAll(_currentDep.getParamNames());
			names.addAll(_currentDep.getIndexNames());
			sbody.append("((" + CodeGenUtilityForC.getConstraintsInC(dom, names) + ")?" + children.get(i) + ":");
		}
		// last one
		sbody.append("(" + children.get(children.size() - 1) + ")");
		for (int i = 1; i < children.size(); i++) {
			sbody.append(")");
		}
		return sbody.toString();
	}

	@Override
	public String caseRestrictExpression(RestrictExpression node) {
		// Restrict part is taken care at the CaseExp level, so it just prints out its child
		return doSwitch(node.getExpr());
	}

	@Override
	public String caseReduceExpression(ReduceExpression node) {
		throw new RuntimeException("ReduceExpression needs special handling. Default ExpressionPrinterForC do not support it.");
	}

	@Override
	public String caseIfExpression(IfExpression node) {
		// If is implemented with the ? : syntax
		return "((" + doSwitch(node.getCond()) + ")?(" + doSwitch(node.getThen()) + "):(" + doSwitch(node.getElse()) + "))";
	}

	@Override
	public String caseExternalFunctionCall(ExternalFunctionCall node) {
		StringBuffer sbody = new StringBuffer();

		List<String> children = new LinkedList<String>();

		// Get String for all operands first
		for (Expression child : node.getExprs()) {
			children.add(doSwitch(child));
		}

		sbody.append(node.getExFunc().getName());
		sbody.append("(");
		// Then use the operands to call an external function
		for (int i = 0; i < children.size(); i++) {
			sbody.append(children.get(i));
			if (i != children.size() - 1) {
				sbody.append(",");
			}
		}
		sbody.append(")");

		return sbody.toString();
	}

	@Override
	public String caseIndexExpression(IndexExpression node) {
		AffineFunction composed = node.getFunction().compose(_currentDep);
		return CodeGenUtilityForC.getFunctionInC(composed);
	}
	
	@Override
	public String caseDependenceExpression(DependenceExpression node) {
		StringBuffer sbody = new StringBuffer();

		AffineFunction prevDep = _currentDep;
		_currentDep = node.getDep().compose(_currentDep);
		
		sbody.append(doSwitch(node.getExpr()));

		_currentDep = prevDep;

		return sbody.toString();
	}

	@Override
	public String caseVariableExpression(VariableExpression node) {
		StringBuffer sbody = new StringBuffer();
		
		//Get the memory mapping and ST
		MemoryMap mmap = targetMapping.getMemoryMaps().get(node.getVarDecl());
		if (mmap == null) {
			throw new RuntimeException("MemoryMap is not specified for variable : " + node.getVarDecl().getName());
		}
		MemorySpace ms = mmap.getSpace();
		if (ms == null) {
			throw new RuntimeException("MemorySpace is not specified for variable : " + node.getVarDecl().getName());
		}
		
		
		//scalar
		if (ms.getDomain().getNIndices() == 0) {
			//check whether the variable sharing the memory space with some input/output variable
			boolean shareSpaceWithInputOrOutput = false;
			for(MemoryMap tmap: ms.getMemoryMaps()){
				if(tmap.getVariable().isInput() || tmap.getVariable().isOutput()){
					shareSpaceWithInputOrOutput = true;
					break;
				}
			}
			//if the function is the entry point and the variable is local, then access as scalar
			if (mainFunction && node.getVarDecl().isLocal() && !shareSpaceWithInputOrOutput) {
				sbody.append(ms.getName());
			//otherwise dereference
			} else {
				sbody.append("*"+ms.getName());
			}
		//array
		} else {
			sbody.append(ms.getName());
			sbody.append("(");
			List<String> params = new LinkedList<String>(); 
			//Access Function
			//TODO: FIX: current level is olny for 0, it has to be fixed for space time hierarchy
			AffineFunction access = computeAccessFunction(0, node.getVarDecl());
			//Compose it with the dependence
			access = access.compose(_currentDep);
			//Pretty print the access function to pass the indices
			for (AffineExpression ile : access.getExpressions()) {
				params.add(ile.toString(OUTPUT_FORMAT.C));
			}
			sbody.append(CodeGenUtility.toStringList(params, ","));
			sbody.append(")");
			
			// In AlphaZ AST, identity dependence was simplified away.
			// This is not the case in PolyhedralIR
			if (_currentDep == null) {
				throw new RuntimeException("VariableExpression is not a child of a DependenceExpression. " +
						"This should not happen in PolyhedralIR");
			}
		}

		return sbody.toString();
	}

	@Override
	public String caseBinaryExpression(BinaryExpression node) {
		StringBuffer sbody = new StringBuffer();

		String lhs = doSwitch(node.getLexp());
		String rhs = doSwitch(node.getRexp());

		// When the operator is infix
		if (CodeGenUtilityForC.isInfixInC(node.getOperator())) {
			sbody.append("(" + lhs + ")");
			sbody.append(CodeGenUtilityForC.getBinaryOperatorInC(node.getOperator()));
			sbody.append("(" + rhs + ")");
			// When operator is implemented as a function call
		} else {
			if(CodeGenUtilityForC.isFixedFunctionInC(node.getOperator())){
				sbody.append(CodeGenUtilityForC.getBinaryOperatorFunctionInC(node.getOperator(), node.getExpressionType()));
			}else{
				sbody.append(CodeGenUtilityForC.getBinaryOperatorInC(node.getOperator()));
			}
			//sbody.append(CodeGenUtilityForC.getBinaryOperatorInC(node.getOperator()));
			sbody.append("(");
			sbody.append(lhs);
			sbody.append(",");
			sbody.append(rhs);
			sbody.append(")");
		}
		return sbody.toString();
	}

	@Override
	public String caseMultiArgExpression(MultiArgExpression node) {
		StringBuffer sbody = new StringBuffer();

		List<String> children = new LinkedList<String>();

		// Get the String representation of all children
		for (Expression child : node.getExprs()) {
			children.add(doSwitch(child));
		}

		// Nested implementation of multi-arg expression
		if (CodeGenUtilityForC.isInfixInC(node.getOperator())) {
			sbody.append("(");
			for (int i = 0; i < children.size(); i++) {
				if (i != children.size() - 1) {
					sbody.append(CodeGenUtilityForC.getBinaryOperatorInC(node.getOperator()));
				}
				sbody.append(children.get(i));
			}
			sbody.append(")");
			// Expression supports > 2 operands
		} else {
			String op_name = null;
			if(CodeGenUtilityForC.isFixedFunctionInC(node.getOperator())){
				op_name = CodeGenUtilityForC.getBinaryOperatorFunctionInC(node.getOperator(), node.getExpressionType());
			}else{
				op_name = CodeGenUtilityForC.getMultiArgOperatorInC(node.getOperator());
			}
			for (int i = 0; i < children.size() - 1; i++) {
				//sbody.append(CodeGenUtilityForC.getMultiArgOperatorInC(node.getOperator()));
				sbody.append(op_name);
				sbody.append("(");
				sbody.append(children.get(i));
				sbody.append(",");
			}
			sbody.append(children.get(children.size() - 1));
			for (int i = 0; i < children.size() - 1; i++) {
				sbody.append(")");
			}
		}

		return sbody.toString();
	}
	
	
	@Override
	public String caseIntegerExpression(IntegerExpression node) {
		return Long.toString(node.getValue());
	}
	
	@Override
	public String caseRealExpression(RealExpression node) {
		return Double.toString(node.getValue());
	}
	
	@Override
	public String caseBooleanExpression(BooleanExpression node) {
		if (node.isValue()) {
			return "1";
		} else {
			return "0";
		}
		//return Boolean.toString(node.isValue());
	}
	
	@Override
	public String caseUnaryExpression(UnaryExpression node) {
		switch (node.getOperator()) {
			case NEG:
				return "-("+doSwitch(node.getExpr())+")";
			case NOT:
				return "!("+doSwitch(node.getExpr())+")";
		}
		
		throw new RuntimeException("Unary expression except for negation is currently not handled.");
	}
	
	
	/**
	 * Returns a mapping from scheduled space to memory space, 
	 * the default implementation is a call to getAccessFunction in TargetMapping,
	 * which gives inverse of space time map composed with memory mapping.
	 * 
	 * Separated out so that it can be overridden to implement custom behaviors.
	 * 
	 * @param var
	 * @return
	 */
	protected AffineFunction computeAccessFunction(int level, VariableDeclaration var) {
		return targetMapping.getSpaceTimeLevel(0).getAccessFunction(var);
	}
	
}
