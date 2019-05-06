package org.polymodel.polyhedralIR.util;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.polymodel.DimensionsManager;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ExternalFunctionDeclaration;
import org.polymodel.polyhedralIR.OPS;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.ConstantExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.ExternalFunctionCall;
import org.polymodel.polyhedralIR.expression.IfExpression;
import org.polymodel.polyhedralIR.expression.IndexExpression;
import org.polymodel.polyhedralIR.expression.MultiArgExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.expression.UnaryExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRModule;

public class AShow  extends PolyhedralIRToAlphabets {
	
	
	private static AShow ashow = new AShow(false);
	private static AShow ashowSimplify = new AShow(true);
	private PolyhedralIRExpressionAShow exprAShow = new PolyhedralIRExpressionAShow();
	
	protected List<String> _currentNames;
	protected ParameterDomain _parameterDoman;
	
	protected AShow(boolean simplify) {
		super(simplify);
	}

	
	/**
	 * Method for the expression switch to call doSwitch of this class.
	 * 
	 * @param obj
	 * @return
	 */
	protected String parentSwitch(EObject obj) {
		return this.doSwitch(obj);
	}
	
	/**
	 * Prints out a Program in AShow syntax.
	 * 
	 * @param program
	 * @return
	 */
	public static String toString(EObject obj) {
		if (obj instanceof Program || obj instanceof AffineSystem) {
			return ashow.doSwitch(obj);
		} else {
			throw new RuntimeException("AShow only accepts Program or AffineSystem");
		}
	}

	/**
	 * Prints out an AffineSystem in AShow syntax.
	 * 
	 * @param program
	 * @return
	 */
	public static String toSimplifiedString(EObject obj) {
		if (obj instanceof Program || obj instanceof AffineSystem) {
			return ashowSimplify.doSwitch(obj);
		} else {
			throw new RuntimeException("AShow only accepts Program or AffineSystem");
		}
	}
	
	@Override
	public String caseProgram(Program p) {
		StringBuffer res = new StringBuffer();
		
		//External functions
		for (ExternalFunctionDeclaration efd : p.getExternalFunctionDeclarations()) {
			res.append(this.doSwitch(efd));
			res.append(LINE_FEED);
		}
		
		//Systems
		for (AffineSystem a : p.getSystems()) {
			res.append(this.doSwitch(a));
			res.append(LINE_FEED);
		}
		
		return res.toString();
	}
	
	@Override
	public String caseAffineSystem(AffineSystem a) {
		StringBuffer res = new StringBuffer();
		res.append("affine " + a.getName() + " " + doSwitch(a.getParameters()));
		res.append(LINE_FEED);
		res.append("input");
		res.append(LINE_FEED);
		for (VariableDeclaration decl : a.getInputs()) {
			res.append(doSwitch(decl));
			res.append(LINE_FEED);
		}
		res.append("output");
		res.append(LINE_FEED);
		for (VariableDeclaration decl : a.getOutputs()) {
			res.append(doSwitch(decl));
			res.append(LINE_FEED);
		}
		res.append("local");
		res.append(LINE_FEED);
		for (VariableDeclaration decl : a.getLocals()) {
			res.append(doSwitch(decl));
			res.append(LINE_FEED);
		}
		res.append("let");
		res.append(LINE_FEED);
		for (StandardEquation e : a.getEquations()) {
			res.append(doSwitch(e));
			res.append(LINE_FEED);
		}
		for (UseEquation e : a.getUseEquations()) {
			res.append(doSwitch(e));
			res.append(LINE_FEED);
		}
		res.append(".");

		return res.toString();
	}
	
	@Override
	public String caseUseEquation(UseEquation ue) {
		
		_parameterDoman = ue.getContainerSystem().getParameters();
		
		StringBuffer res = new StringBuffer();
		
		res.append("use ");
		if (ue.getExtensionDomain().getNIndices()!=0)
			res.append(doSwitch(ue.getExtensionDomain()) + " ");
		res.append(ue.getSubSystem().getName() + "[");
		
		boolean fst = true;
		for (AffineExpression aexp : ue.getParameters().getExpressions()) {
			if (fst) {
				res.append(aexp.toString(OUTPUT_FORMAT.ALPHABETS));
				fst = false;
			} else
				res.append("," + aexp.toString(OUTPUT_FORMAT.ALPHABETS));
		}
		
		res.append("] (");
		
		_currentNames = new LinkedList<String>();
		//_currentNames.addAll(ue.getContainerSystem().getParameters().getParamNames());
		_currentNames.addAll(ue.getExtensionDomain().getIndexNames());
		fst = true;
		for (Expression expInp : ue.getInputs()) {
			if (fst) {
				res.append(PolyhedralIRToAlphabets.toString(expInp));	// OLD: doSwitch(expInp)
				fst = false;
			} else
				res.append("," + PolyhedralIRToAlphabets.toString(expInp));	// OLD: doSwitch(expInp)
		}
		
		_currentNames = null;
		
		res.append(") returns (");
		fst = true;
		for (VariableDeclaration vdOut : ue.getOutputs()) {
			if (fst) {
				res.append(vdOut.getName());
				fst = false;
			} else
				res.append("," + vdOut.getName());
		}
		res.append(");");
		
		return res.toString();
	}
	
	@Override
	public String caseStandardEquation(StandardEquation s) {
		StringBuffer res = new StringBuffer();
		
		_currentNames = new LinkedList<String>();
		_parameterDoman = s.getContainerSystem().getParameters();
//		_currentNames.addAll(s.getVariable().getDomain().getParamNames());
		_currentNames.addAll(s.getVariable().getDomain().getIndexNames());
		

		res.append(doSwitch(s.getVariable().getVarID()));
		res.append("[");
		res.append(toStringList(s.getVariable().getDomain().getIndexNames(), ","));
		res.append("]");
		res.append(" = ");
		res.append(doSwitch(s.getExpression()));
		res.append(";");
		
		_currentNames = null;
		
		return res.toString();
	}

	protected String printAShowDomain(Domain domain) {
		List<IntConstraintSystem> target = domain.getPMdomain().getPolyhedra();
		
		if (!(domain instanceof ParameterDomain)) {
			//simplify if possible
			target = simplifyDomain(domain);
		}
		
		StringBuffer res = new StringBuffer();
		
		for (IntConstraintSystem ilcs : target) {
			if (res.length() > 0) res.append(" || ");
			res.append("{|"+ilcs.toString(OUTPUT_FORMAT.ALPHABETS)+"}");
		}
		
		if (target.size() == 0) {
			res.append("{|}");
		}

		return res.toString();
	}
	
	@Override
	public String caseAffineFunction(AffineFunction func) {
		StringBuffer res = new StringBuffer();
		
		res.append("(");
		//LHS
		res.append(toStringList(func.getPMmapping().getDimensions().getIndices(), ","));
		res.append("->");
		
		//RHS
		List<IntExpression> rhs = func.getPMmapping().getExpressions();
		res.append(toStringList(rhs, ","));
		
		res.append(")");
		
		return res.toString();
	}
	
	@Override
	public String caseExpression(Expression expr) {
		return exprAShow.doSwitch(expr); 
	}

	@Override
	public String defaultCase(EObject object) {
		return object.toString();
	}

	protected class PolyhedralIRExpressionAShow extends PolyhedralIRExpressiontoAlphabets {
		@Override
		public String caseDependenceExpression(DependenceExpression d) {
			//Dependence stays in AShow syntax iff the next expression is Variable or Constant
			if (d.getExpr() instanceof VariableExpression || d.getExpr() instanceof ConstantExpression) {// || d.getExpr() instanceof ReduceExpression) {
				StringBuffer res = new StringBuffer();
				res.append(parentSwitch(d.getExpr()));
				//print out [] if the function is 1D or more
				if (d.getDep().getDimRHS() > 0) {
					res.append("[");
					List<String> exprs = new LinkedList<String>();
					for (AffineExpression ile : d.getDep().getExpressions()) {
						DimensionsManager dm = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);

						exprs.add(PolyModelToAlphabets.print(ile, OUTPUT_FORMAT.ALPHABETS, _parameterDoman.getParamNames(), _currentNames));
//						exprs.add(IntegerLinearAlgebraPrinter.toString(ile, FORMAT.ALPHABETS, _currentNames));
					}
					res.append(toStringList(exprs, ","));
					res.append("]");
				}

				return res.toString();
			} else {
				//Switch to Show syntax
				if (SIMPLIFY) {
					return PolyhedralIRToAlphabets.toSimplifiedString(d);
				} else {
					return PolyhedralIRToAlphabets.toString(d);
				}
			}
		}
		
		@Override
		public String caseIfExpression(IfExpression i) {
			StringBuffer res = new StringBuffer();
			
			res.append("if (");
			res.append(parentSwitch(i.getCond()));
			res.append(") then (" );
			res.append(parentSwitch(i.getThen()));
			res.append(") else (" );
			res.append(parentSwitch(i.getElse()));
			res.append(")");

			return res.toString();
		}
		
		@Override
		public String caseIndexExpression(IndexExpression i) {
			StringBuffer res = new StringBuffer();
			
			if (i.getFunction().getDimRHS() != 1) {
				throw new RuntimeException("Expecting one-dimensional function for IndexExpression");
			}
			
			res.append("[");
			res.append(PolyModelToAlphabets.print(i.getFunction().getExpressions().get(0), OUTPUT_FORMAT.ALPHABETS, _parameterDoman.getParamNames(), _currentNames));
//			res.append(PolyModelToAlphabets.print(i.getFunction().getExpressions().get(0), OUTPUT_FORMAT.ALPHABETS, PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE), _parameterDoman.getParamNames(), _currentNames));
			res.append("]");

			return res.toString();
		}
		
		@Override
		public String caseReduceExpression(ReduceExpression r) {
			StringBuffer res = new StringBuffer();
			
			List<String> temp = new LinkedList<String>();
			for (String name : _currentNames) {
				temp.add(name);
			}
			_currentNames.clear();
//			_currentNames.addAll(r.getProjection().getParamNames());
			_currentNames.addAll(r.getProjection().getIndexNames()); 
				
			res.append("reduce(");
			res.append(OPS.toString(r.getOP()));
			res.append(", ");
			res.append(parentSwitch(r.getProjection()));
			res.append(", ");
			res.append(parentSwitch(r.getExpr()));
			res.append(")");
			
			_currentNames = temp; 

			return res.toString();
		}
		
		/**
		 * Check if two domains share the same index names, and number of dimensions.
		 * 
		 * @param domA
		 * @param domB
		 * @return
		 */
		protected boolean checkIndexNameEquivalence(List<String> names, Domain dom) {
			if ((dom.getNIndices()) != names.size()) return false;
			
			for (int i = 0; i < dom.getNIndices(); i++) {
				if (names.get(i).compareTo(dom.getIndexNames().get(i)) != 0) return false;
			}
			
			return true;
		}
		
		@Override
		public String caseRestrictExpression(RestrictExpression re) {
			if (checkIndexNameEquivalence(_currentNames, re.getRestrictDomain())) {
				StringBuffer res = new StringBuffer();
				res.append(printAShowDomain(re.getRestrictDomain()));
				res.append(" : ");
				res.append(parentSwitch(re.getExpr()));

				if (re.eContainer() instanceof BinaryExpression) {
					return "(" + res.toString() + ")";
				} else {
					return res.toString();
				}
			} else {
				//Switch to AShow syntax
				if (SIMPLIFY) {
					return PolyhedralIRToAlphabets.toSimplifiedString(re);
				} else {
					return PolyhedralIRToAlphabets.toString(re);
				}
			}
		}
		
		@Override
		public String caseUnaryExpression(UnaryExpression u) {
			return OPS.toString(u.getOperator()) + "("+ parentSwitch(u.getExpr()) + ")";
		}
		
		@Override
		public String caseBinaryExpression(BinaryExpression b) {
			return "(" + parentSwitch(b.getLexp()) +" "+ OPS.toString(b.getOperator()) +" "+ parentSwitch(b.getRexp()) + ")";
		}
		
		@Override
		public String caseMultiArgExpression(MultiArgExpression m) {
			StringBuffer res;
			
			//Use the function name in case of external function
			if (m instanceof ExternalFunctionCall) {
				res = new StringBuffer(((ExternalFunctionCall)m).getExFunc().getName());
			} else {
				res = new StringBuffer(OPS.toStringMultiArg(m.getOperator()));
			}

			res.append("(");
			boolean first = true;
			for (Expression e : m.getExprs()) {
				if (first) {
					first = false;
				} else {
					res.append(",");
				}
				
				res.append(parentSwitch(e));
			}
			res.append(")");
			
			return res.toString();
		}
	}
}
