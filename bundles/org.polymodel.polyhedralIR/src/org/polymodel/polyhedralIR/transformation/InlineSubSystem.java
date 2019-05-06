package org.polymodel.polyhedralIR.transformation;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.Type;
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
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.impl.PolyhedralIRDepthFirstVisitorImpl;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations;
import org.polymodel.polyhedralIR.transformation.helper.FunctionOperations;
import org.polymodel.polyhedralIR.util.ContextDomainCalculator;
import org.polymodel.polyhedralIR.util.ExpressionDomainCalculator;

public class InlineSubSystem {
	
	protected PolyhedralIRUserFactory _polyIRFact;	// User factory for poly IR
	protected AffineSystem _subsystem;				// Copy of the inlined subsystem
	protected AffineSystem _mainsystem;				// Main system, where the inlining happens
	protected UseEquation _inlinedUseEquation;		// Inlined UseEquation
	protected String _subsystem_suffix;				// Used suffix for local variable introduced during inlining
													// Form:  _[Subsystem_name]_[NotusedNumber]
	
	
	/**
	 * Method that inline a given UseEquation.
	 * @param ueq
	 */
	public static void inline(UseEquation ueq) {
		InlineSubSystem s = new InlineSubSystem(ueq);
		s._subsystem_suffix = s.findSuffix();
		
		// --- Building the new variable declarations: "ssInputs_decl" and "ssLocals_decl"
		Domain extDom = s._inlinedUseEquation.getExtensionDomain();
		
		EList<VariableDeclaration> ssInputs_decl = new BasicEList<VariableDeclaration>();
		for (VariableDeclaration inpDecl : s._subsystem.getInputs()) {
			String name_inp = inpDecl.getName();
			Type type_inp = inpDecl.getType();
			Domain dom_inp = inpDecl.getDomain();
			Domain nDomDecl = DomainOperations.translateParams(dom_inp, s._inlinedUseEquation.getParameters(), extDom);
			ssInputs_decl.add(
				s._polyIRFact.createVariableDeclaration(name_inp + s._subsystem_suffix, type_inp, nDomDecl));
		}
		
		EList<VariableDeclaration> ssLocals_decl = new BasicEList<VariableDeclaration>();
		for (VariableDeclaration locDecl : s._subsystem.getLocals()) {
			String name_loc = locDecl.getName();
			Type type_loc = locDecl.getType();
			Domain dom_loc = locDecl.getDomain();
			Domain nDomDecl = DomainOperations.translateParams(dom_loc, s._inlinedUseEquation.getParameters(), extDom);
			ssLocals_decl.add(
				s._polyIRFact.createVariableDeclaration(name_loc + s._subsystem_suffix, type_loc, nDomDecl));
		}
		s._mainsystem.getLocals().addAll(ssInputs_decl);
		s._mainsystem.getLocals().addAll(ssLocals_decl);
		
		
		// --- Building the new list of equations (Standard and Use)
		for (int k=0; k<s._subsystem.getInputs().size(); k++) {
			Expression inpUse_expr = s._inlinedUseEquation.getInputs().get(k).copy();
			String inpUse_varName = s._subsystem.getInputs().get(k).getName();
			VariableDeclaration inpUse_var = s._mainsystem.getVariableDeclaration(inpUse_varName+s._subsystem_suffix);
			
			StandardEquation inpUse_StEq = s._polyIRFact.createStandardEquation(inpUse_var, inpUse_expr);
			s._mainsystem.getEquations().add(inpUse_StEq);
		}
		
		s._mainsystem.getUseEquations().remove(s._inlinedUseEquation);
		s._subsystem.accept(new InlineSubSystemVisitor(ueq, s._subsystem_suffix, s._mainsystem));
		s._mainsystem.getEquations().addAll(s._subsystem.getEquations());
		s._mainsystem.getUseEquations().addAll(s._subsystem.getUseEquations());
		
		// We recompute the expression and context domain (for consistency)
		ExpressionDomainCalculator.computeExpressionDomain(s._mainsystem);
		ContextDomainCalculator.computeContextDomain(s._mainsystem.getContainerProgram());
	}
	
	/**
	 * Constructor - Initialization
	 * @param ueq
	 */
	protected InlineSubSystem(UseEquation ueq) {
		this._inlinedUseEquation =ueq;
		this._subsystem = ueq.getSubSystem().copy();
		this._mainsystem = ueq.getContainerSystem();
		this._polyIRFact = PolyhedralIRUserFactory.eINSTANCE;
	}
	
	/**
	 * Method that find a suffix for the inlined variables.
	 * 
	 * @return _subsystem_suffix
	 */
	protected String findSuffix() {
		// To find if a suffix was used, we try one integer, and if there is a colision, then we try the next one, etc etc
		int tested_suffix = 0;
		boolean namingColision = true;
		
		while (namingColision) {
			namingColision = false;
			String cand_suffix = "_" + _subsystem.getName() + "_" + tested_suffix;
			
			for (VariableDeclaration var : _subsystem.getInputs()) {
				String strCandidate = var.getName() + cand_suffix;
				//try {
				if(_mainsystem.getVariableDeclaration(strCandidate) != null){
					namingColision = true;
					break;
				}
				//	_mainsystem.getVariableDeclaration(strCandidate);
				//	namingColision = true;
				//} catch (RuntimeException e) { } // No colision here => Continue
			}
			
			for (VariableDeclaration var : _subsystem.getLocals()) {
				String strCandidate = var.getName() + cand_suffix;
				if(_mainsystem.getVariableDeclaration(strCandidate) != null){
					namingColision = true;
					break;
				}
//				try {
//					_mainsystem.getVariableDeclaration(strCandidate);
//					namingColision = true;
//				} catch (RuntimeException e) { } // No colision here => Continue
			}
			
			if (namingColision)	// This number was probably used in a previous inline => increment it
				tested_suffix++;
		}
		
		return "_" + _subsystem.getName() + "_" + tested_suffix;
	}
	
	
	// ------------------------ Visitor on the subsystem's equations ------------------------
	
	/**
	 * This visitor transforms the equations of the subsystem into inlined equations.
	 */
	private static class InlineSubSystemVisitor extends PolyhedralIRDepthFirstVisitorImpl {
		protected UseEquation _ueq;
		protected String _suffix;
		protected AffineSystem _mainsystem;
		
		protected Expression _subExprToBeReplaced;	// Expression which should replace the subexpression
		
		public InlineSubSystemVisitor(UseEquation ueq, String suffix, AffineSystem mainSyst) {
			this._ueq = ueq;
			this._suffix = suffix;
			this._mainsystem = mainSyst;
			this._subExprToBeReplaced = null;
		}
		
		// Modifications done by this visitor:
		//   - Add dimensions (for the extension domain) everywhere (domains and functions)
		//		=> EXCEPTION: ConstantExpression => we add a dependence "(i_ExtDom -> )" before the constant...
		//   - Replace the variable name by the new local variables
		//	 - Replace the output names by the name of the variable declaration specified in the UseEquation
		
		public void outRestrictExpression(RestrictExpression re) {
			Domain nrestDom = DomainOperations.translateParams(re.getRestrictDomain(), _ueq.getParameters(), 
					_ueq.getExtensionDomain());
			nrestDom.simplify();
			
			_subExprToBeReplaced = PolyhedralIRUserFactory.eINSTANCE.createRestrictExpression(nrestDom, _subExprToBeReplaced);
		}
		
		public void outReduceExpression(ReduceExpression re) {
			AffineFunction proj = re.getProjection();
			AffineFunction nproj = FunctionOperations.translateParams(proj, _ueq.getParameters(), _ueq.getExtensionDomain());
			_subExprToBeReplaced = PolyhedralIRUserFactory.eINSTANCE.createReduceExpression(re.getOP(), nproj, _subExprToBeReplaced);
		}

		@Override
		public void outDependenceExpression(DependenceExpression de) {
			AffineFunction dep = de.getDep();
			AffineFunction ndep = FunctionOperations.translateParams(dep, _ueq.getParameters(), _ueq.getExtensionDomain());
			
			_subExprToBeReplaced = PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(ndep, _subExprToBeReplaced);
		}
		
		public void outVariableExpression(VariableExpression ve) {
			_subExprToBeReplaced = PolyhedralIRUserFactory.eINSTANCE.createVariableExpression(findCorrVarDecl(ve.getVarDecl()));
		}
		
		@Override
		public void outIndexExpression(IndexExpression ie) {
			AffineFunction func = ie.getFunction();
			AffineFunction nfunc = FunctionOperations.translateParams(func, _ueq.getParameters(), _ueq.getExtensionDomain());
			_subExprToBeReplaced = PolyhedralIRUserFactory.eINSTANCE.createIndexExpression(nfunc);
		}
		
		@Override
		public void outBooleanExpression(BooleanExpression be) {
			// We add a dependence (i_ExtDom -> ) in front of the constantExpression
			AffineFunction dep = PolyhedralIRUtility.parseAffineFunctionFromString(_ueq.getExtensionDomain().getParamNames(),
					_ueq.getExtensionDomain().getIndexNames(), new BasicEList<String>());
			_subExprToBeReplaced = PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(dep,
					PolyhedralIRUserFactory.eINSTANCE.createBooleanExpression(be.isValue())
					);
		}
		
		@Override
		public void outIntegerExpression(IntegerExpression ie) {
			// We add a dependence (i_ExtDom -> ) in front of the constantExpression
			AffineFunction dep = PolyhedralIRUtility.parseAffineFunctionFromString(_ueq.getExtensionDomain().getParamNames(),
					_ueq.getExtensionDomain().getIndexNames(), new BasicEList<String>());
			_subExprToBeReplaced = PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(dep,
					PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(ie.getValue())
					);
		}
		
		@Override
		public void outRealExpression(RealExpression re) {
			// We add a dependence (i_ExtDom -> ) in front of the constantExpression
			AffineFunction dep = PolyhedralIRUtility.parseAffineFunctionFromString(_ueq.getExtensionDomain().getParamNames(),
					_ueq.getExtensionDomain().getIndexNames(), new BasicEList<String>());
			_subExprToBeReplaced = PolyhedralIRUserFactory.eINSTANCE.createDependenceExpression(dep,
					PolyhedralIRUserFactory.eINSTANCE.createRealExpression(re.getValue())
					);
		}
		
		
		/* Simple propagation */
		@Override
		public void visitCaseExpression(CaseExpression ce) {
			List<Expression> lSExpr = new BasicEList<>();
			
			for (Expression sExpr : ce.getExprs()) {
				sExpr.accept(this);
				lSExpr.add(_subExprToBeReplaced);
			}
			_subExprToBeReplaced = PolyhedralIRUserFactory.eINSTANCE.createCaseExpression(lSExpr);
		}
		
		@Override
		public void visitIfExpression(IfExpression ie) {
			ie.getCond().accept(this);
			Expression eCond = _subExprToBeReplaced;
			ie.getThen().accept(this);
			Expression eThen = _subExprToBeReplaced;
			ie.getElse().accept(this);
			Expression eElse = _subExprToBeReplaced;
			_subExprToBeReplaced = PolyhedralIRUserFactory.eINSTANCE.createIfExpression(eCond, eThen, eElse);			
		}
		
		@Override
		public void outUnaryExpression(UnaryExpression ue) {
			_subExprToBeReplaced = PolyhedralIRUserFactory.eINSTANCE.createUnaryExpression(ue.getOperator(), _subExprToBeReplaced);
		}
		
		@Override
		public void visitBinaryExpression(BinaryExpression be) {
			be.getLexp().accept(this);
			Expression lExpr = _subExprToBeReplaced;
			be.getRexp().accept(this);
			Expression rExpr = _subExprToBeReplaced;
			_subExprToBeReplaced = PolyhedralIRUserFactory.eINSTANCE.createBinaryExpression(be.getOperator(), lExpr, rExpr);
		}
		
		@Override
		public void visitMultiArgExpression(MultiArgExpression me) {
			List<Expression> lSExpr = new BasicEList<Expression>();
			for (Expression sExpr : me.getExprs()) {
				sExpr.accept(this);
				lSExpr.add(_subExprToBeReplaced);
			}
			_subExprToBeReplaced = PolyhedralIRUserFactory.eINSTANCE.createMultiArgExpression(me.getOperator(), lSExpr);
		}
		
		@Override
		public void visitExternalFunctionCall(ExternalFunctionCall efc) {
			List<Expression> lSExpr = new BasicEList<Expression>();
			for (Expression sExpr : efc.getExprs()) {
				sExpr.accept(this);
				lSExpr.add(_subExprToBeReplaced);
			}
			_subExprToBeReplaced = PolyhedralIRUserFactory.eINSTANCE.createExternalFunctionCall(efc.getExFunc(), lSExpr);
		}
		
		/* ------------------------------------------------------------ */
		
		@Override
		public void outStandardEquation(StandardEquation seq) {
			VariableDeclaration vardecl = seq.getVariable();
			seq.setVariable(findCorrVarDecl(vardecl));
			seq.setExpression(_subExprToBeReplaced);
		}
		
		@Override
		public void visitUseEquation(UseEquation ueq) {
			
			// Change the inputs
			List<Expression> lnInput = new BasicEList<Expression>();
			for (Expression input : ueq.getInputs()) {
				input.accept(this);
				lnInput.add(_subExprToBeReplaced);
			}
			
			// Change the outputs
			EList<VariableDeclaration> loutput = ueq.getOutputs();
			EList<VariableDeclaration> nloutput = new BasicEList<VariableDeclaration>();
			for (VariableDeclaration declOut : loutput)
				nloutput.add(findCorrVarDecl(declOut));
			loutput = nloutput;
		}
		
		/**
		 * Method to find the corresponding VariableDeclaration after the inlining of a subsystem.
		 * 
		 * @param vd
		 * @return
		 */
		private VariableDeclaration findCorrVarDecl(VariableDeclaration vd) {
			String vdName = vd.getName();
			VariableDeclaration vdSs = _ueq.getSubSystem().getVariableDeclaration(vdName);
			
			if (_ueq.getSubSystem().isOutput(vdSs)) {	// Case of an output
				int k = _ueq.getSubSystem().getOutputs().indexOf(vdSs);
				return _ueq.getOutputs().get(k);
			} else {	// Case of  local variable
				return _mainsystem.getVariableDeclaration(vdName + _suffix);
			}
		}
		
		
	} // InlineSubSystemVisitor
	
} // InlineSubSystem
