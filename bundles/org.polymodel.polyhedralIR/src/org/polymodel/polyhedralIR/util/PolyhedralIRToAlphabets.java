package org.polymodel.polyhedralIR.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.isl.ISLSet;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ExternalFunctionDeclaration;
import org.polymodel.polyhedralIR.OPS;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.SIGNED;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.VariableIdentifier;
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

public class PolyhedralIRToAlphabets extends PolyhedralIRSwitch<String> {
	
	public static final String LINE_FEED = "\n";
	protected final boolean SIMPLIFY;

	protected static PolyhedralIRToAlphabets pprinter = new PolyhedralIRToAlphabets(false);
	protected static PolyhedralIRToAlphabets pprinterSimplify = new PolyhedralIRToAlphabets(true);
	protected PolyhedralIRExpressiontoAlphabets exprToString = new PolyhedralIRExpressiontoAlphabets();
	
	
	
	/**
	 * Protected constructor to force use of this class through static functions.
	 * 
	 * @param simplify
	 */
	protected PolyhedralIRToAlphabets(boolean simplify) {
		SIMPLIFY = simplify;
	}
	
	/**
	 * Prints out the given EObject (assumed to be of PolyhedralIR) as alphabets.
	 * 
	 * @param obj
	 * @return
	 */
	public static String toString(EObject obj) {
		return pprinter.doSwitch(obj);
	}

	/**
	 * Prints out the given EObject (assumed to be of PolyhedralIR) as alphabets.
	 * Domains will be simplified in context when possible.
	 * 
	 * @param obj
	 * @return
	 */
	public static String toSimplifiedString(EObject obj) {
		return pprinterSimplify.doSwitch(obj);
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

	protected static String toStringList(List list, String separator ) {
		StringBuffer buff = new StringBuffer();
		if(list==null || list.size() == 0) return "";
		boolean first =true;
		for (Object obj : list) {
			if (first) {
				first =false;
				buff.append(obj.toString());
			} else {
				buff.append(separator+obj.toString());
				
			}
		}
		return buff.toString();
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
	public String caseExternalFunctionDeclaration(ExternalFunctionDeclaration e) {
		List<String> inputs = new LinkedList<String>();
		for (Type t : e.getInputs()) {
			inputs.add(doSwitch(t));
		}
		return doSwitch(e.getOutput()) + " " + e.getName() +"("+toStringList(inputs, ",")+");";
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
		fst = true;
		for (Expression expInp : ue.getInputs()) {
			if (fst) {
				res.append(doSwitch(expInp));
				fst = false;
			} else
				res.append("," + doSwitch(expInp));
		}
		
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

		res.append(doSwitch(s.getVariable().getVarID()));
		res.append(" = ");
		res.append(doSwitch(s.getExpression()));
		res.append(";");
		
		return res.toString();
	}
	@Override
	public String caseVariableDeclaration(VariableDeclaration v) {
		StringBuffer res = new StringBuffer();
		res.append(doSwitch(v.getType()) + " " + doSwitch(v.getVarID()) + " " + doSwitch(v.getDomain()) + ";");
		return res.toString();
	}
	
	@Override
	public String caseDomain(Domain domain) {
		//Create list of parameters after toString
		List<String> indexlist = new LinkedList<String>();
		
//		if (domain.getPMdomain() == null) return " null ";
		List<IntConstraintSystem> target = domain.getPMdomain().getPolyhedra();
		
		//When it is parameter domain, show parameters on the list of indices
		if (domain instanceof ParameterDomain) {
			indexlist.addAll(domain.getParamNames());
			indexlist.addAll(domain.getIndexNames());
		//else just use the indices
		} else {
			indexlist.addAll(domain.getIndexNames());
			//simplify if possible
			target = simplifyDomain(domain);
		}

		StringBuffer indexes = new StringBuffer(toStringList(indexlist, ","));
		
		StringBuffer res = new StringBuffer();
		
//		res.append(PolymodelPrettyPrinter.print(domain.getPMdomain(), OUTPUT_FORMAT.ALPHABETS, domain.getParamNames(), domain.getIndexNames()));
		
		for (IntConstraintSystem ilcs : target) {
			if (res.length() > 0) res.append(" || ");
			res.append("{"+indexes+"|"+ilcs.toString(OUTPUT_FORMAT.ALPHABETS)+"}");
//			res.append("{"+indexes+"|"+PolymodelPrettyPrinter.print(ilcs, OUTPUT_FORMAT.ALPHABETS, domain.getPMdomain().getDimensionsManager(), domain.getParamNames(), domain.getIndexNames())+"}");
		}
		
		if (target.size() == 0) {
			res.append("{"+indexes+"|}");
		}

		return res.toString();
	}
	
	/**
	 * Simplifies the domain by its surrounding context, and returns the simplified polyhedra for printing.
	 * 
	 * @param domain
	 * @return
	 */
	protected List<IntConstraintSystem> simplifyDomain(Domain domain) {
		List<IntConstraintSystem> target = domain.getPMdomain().getPolyhedra();

		//Simplify in context before printing if possible
		if (domain.getPMdomain() instanceof ISLSet && SIMPLIFY) {
			domain.simplify();
			//When it is a domain of an expression
			if (domain.eContainer() instanceof Expression) {
				//When the parent is also an expression
				if (domain.eContainer().eContainer() instanceof Expression) {
					Domain context = ((Expression)(domain.eContainer().eContainer())).getContextDomain().copy();
					//Special case 1 : when the parent is Reduce, take pre-image by the projection
					if (domain.eContainer().eContainer() instanceof ReduceExpression) {
						context = context.preimage(((ReduceExpression)domain.eContainer().eContainer()).getProjection());
					}
					//Special case 2 : when the parent is Dependence, take image by the function
					if (domain.eContainer().eContainer() instanceof DependenceExpression) {
						context = context.image(((DependenceExpression)domain.eContainer().eContainer()).getDep());
					}
					
					//check number of dimensions
					if (context.getDim() != domain.getDim()) {
						throw new RuntimeException("Number of dimensions do not match the surrounding context.");
					}
					org.polymodel.Domain simplified = ((ISLSet)domain.getPMdomain()).simplify(context.getPMdomain());
					simplified.simplify();
					target = simplified.getPolyhedra();
				//When parent is an equation
				} else if (domain.eContainer().eContainer() instanceof StandardEquation) {
					Domain context = ((AffineSystem)(domain.eContainer().eContainer().eContainer())).getParameters().copy();
					//Match number of dimensions
					for (Variable iv : domain.getIndices()) {
						context.addDimension(iv.getName());
					}
					org.polymodel.Domain simplified = ((ISLSet)domain.getPMdomain()).simplify(context.getPMdomain());
					simplified.simplify();
					target = simplified.getPolyhedra();
				}
			//If its a domain of a variable
			} else if (domain.eContainer() instanceof VariableDeclaration) {
				Domain context = ((AffineSystem)domain.eContainer().eContainer()).getParameters().copy();
				//Match number of dimensions
				for (Variable iv : domain.getIndices()) {
					context.addDimension(iv.getName());
				}
				org.polymodel.Domain simplified = ((ISLSet)domain.getPMdomain()).simplify(context.getPMdomain());
				simplified.simplify();
				target = simplified.getPolyhedra();
			}
		}
		
		return target;
	}
	
	@Override
	public String caseAffineFunction(AffineFunction func) {
		StringBuffer res = new StringBuffer();
		
		res.append("(");
		//LHS
		res.append(toStringList(func.getPMmapping().getDimensions().getIndices(), ","));
		res.append("->");
		
		//RHS
		List<String> exprsStr = new ArrayList<String>(func.getExpressions().size());
		for (AffineExpression expr : func.getExpressions()) {
			exprsStr.add(expr.toString(OUTPUT_FORMAT.ALPHABETS));
		}
		
		res.append(toStringList(exprsStr, ","));
		
		res.append(")");
		
		return res.toString();
	}
	
	@Override
	public String caseType(Type t) {
		StringBuffer sb = new StringBuffer();
		
		final String sign;
		if (t.getSigned() == SIGNED.SIGNED) {
			sign = "";
		} else {
			sign = "unsigned ";
		}
		
		switch (t.getTypeID()) {
			case INTEGER:
				sb.append(sign);
				if (t.getWidth() == DATATYPE.INT_WIDTH) {
					sb.append("int");
				} else if (t.getWidth() == DATATYPE.LONG_WIDTH) {
					sb.append("long");
				} else if (t.getWidth() == DATATYPE.SHORT_WIDTH) {
					sb.append("short");
				}
				break;
			case FLOATING_POINT:
				if (t.getWidth() == DATATYPE.INT_WIDTH) {
					sb.append("float");
				} else if (t.getWidth() == DATATYPE.LONG_WIDTH) {
					sb.append("double");
				}
				break;
			case CHAR:
				sb.append("char");
				break;
			case BOOL:
				sb.append("bool");
				break;
		}
		return sb.toString();
	}
	
	@Override
	public String caseVariableIdentifier(VariableIdentifier v) {
		return v.getName();
	}
	
	@Override
	public String caseExpression(Expression expr) {
		return exprToString.doSwitch(expr); 
	}

	@Override
	public String defaultCase(EObject object) {
		return object.toString();
	}
	

	protected class PolyhedralIRExpressiontoAlphabets extends ExpressionSwitch<String> {
		
		
		@Override
		public String caseCaseExpression(CaseExpression c) {
			StringBuffer res = new StringBuffer();

			res.append("case");
			res.append(LINE_FEED);
			for (Expression e : c.getExprs()) {
				res.append(parentSwitch(e));
				res.append(";");
				res.append(LINE_FEED);
			}
			res.append("esac");
			
			return res.toString();
		}
		
		@Override
		public String caseDependenceExpression(DependenceExpression d) {
			StringBuffer res = new StringBuffer();
			res.append(parentSwitch(d.getDep()));
			res.append("@");
			if (d.getExpr() instanceof RestrictExpression) {
				res.append("(");
				res.append(parentSwitch(d.getExpr()));
				res.append(")");
			} else {
				res.append(parentSwitch(d.getExpr()));
			}
			
			return res.toString();
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
			
			res.append("val");
			res.append(parentSwitch(i.getFunction()));
			//res.append(")");

			return res.toString();
		}
		
		@Override
		public String caseReduceExpression(ReduceExpression r) {
			StringBuffer res = new StringBuffer();
			
			res.append("reduce(");
			res.append(OPS.toString(r.getOP()));
			res.append(", ");
			res.append(parentSwitch(r.getProjection()));
			res.append(", ");
			res.append(parentSwitch(r.getExpr()));
			res.append(")");

			return res.toString();
		}
		
		@Override
		public String caseRestrictExpression(RestrictExpression re) {
			StringBuffer res = new StringBuffer();
			res.append(parentSwitch(re.getRestrictDomain()));
			res.append(" : ");
			res.append(parentSwitch(re.getExpr()));

			if (re.eContainer() instanceof BinaryExpression) {
				return "(" + res.toString() + ")";
			} else {
				return res.toString();
			}
		}
		
		@Override
		public String caseVariableExpression(VariableExpression v) {
			return parentSwitch(v.getVarDecl().getVarID());
		}
		
		@Override
		public String caseUnaryExpression(UnaryExpression u) {
			return OPS.toString(u.getOperator()) + parentSwitch(u.getExpr());
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
		
		@Override
		public String caseIntegerExpression(IntegerExpression i) {
			if (i.getValue()>=0)
				return Long.toString(i.getValue());
			else
				return "(" + Long.toString(i.getValue()) + ")";
		}
		@Override
		public String caseRealExpression(RealExpression r) {
			if (r.getValue()>0)
				return Double.toString(r.getValue());
			else
				return "(" + Double.toString(r.getValue()) + ")";
		}
		@Override
		public String caseBooleanExpression(BooleanExpression b) {
			return b.isValue()+"";
		}

		@Override
		public String defaultCase(EObject object) {
			return object.toString();
		}
	}
}
