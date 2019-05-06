package org.polymodel.polyhedralIR.recurrence;

import java.util.List;
import java.util.Stack;

import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.ConstantExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.IntegerExpression;
import org.polymodel.polyhedralIR.expression.MultiArgExpression;
import org.polymodel.polyhedralIR.expression.UnaryExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.impl.PolyhedralIRInheritedDepthFirstVisitorImpl;
import org.polymodel.polyhedralIR.recurrence.SermringUtilities.Sermring;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;

public class CoeficientExtraction extends PolyhedralIRInheritedDepthFirstVisitorImpl {
	private VariableDeclaration target = null;
	private List<VariableDeclaration> targetVarList = null;
	private AffineFunction affineTarget = null;
	private Stack<ExpressionTuple> expStack = null;
	private boolean isVar = true;
	private Sermring s = null;
	private static boolean DEBUG = false;
	
	public CoeficientExtraction(VariableDeclaration _target, AffineFunction _affineTarget, Sermring _s, List<VariableDeclaration> _targetVarList){
		target = _target;
		if(DEBUG){
			System.out.println("current target is " + target.getName() + "with target affine function: " + _affineTarget);
		}
		affineTarget = _affineTarget;
		expStack = new Stack<ExpressionTuple>();
		s = _s;
		targetVarList = _targetVarList;
	}
	
	public CoeficientExtraction(Sermring _s, List<VariableDeclaration> _targetVarList){
		expStack = new Stack<ExpressionTuple>();
		s = _s;
		targetVarList = _targetVarList;
	}
	
	public Expression VarCoe(Expression exp){
		this.isVar = true;
		if(DEBUG){
			System.out.println(PolyhedralIRToAlphabets.toSimplifiedString(exp));
		}
		exp.accept(this);
		return this.expStack.pop().exp;
	}
	
	public Expression ConstantCoe(Expression exp){
		this.isVar = false;
		//System.out.println(PolyhedralIRToAlphabets.toSimplifiedString(exp));
		exp.accept(this);
		return this.expStack.pop().exp;
	}
	
	private Expression CreateExpression(OP op, Expression ep1, Expression ep2){
		if(ep1 instanceof IntegerExpression){
			//if ep1 == 0 and op == oplus : 0 is the identity for oplus
			if((((IntegerExpression)ep1).getValue()== 0L) && op.equals(this.s.op2)){
				return ep2;
			}else if((((IntegerExpression)ep1).getValue()==1L) && op.equals(this.s.op1)){	//if ep1 == 1 and op == otimes: 1 is the identity for otimes
				return ep2;
			}
		}
		
		if(ep2 instanceof IntegerExpression){
			//if ep2 == 0 and op == oplus : 0 is the identity for oplus
			if((((IntegerExpression)ep2).getValue() == 0L) && op.equals(this.s.op2)){
				return ep1;
			}else if((((IntegerExpression)ep2).getValue()==1L) && op.equals(this.s.op1)){	//if ep2 == 1 and op == otimes: 1 is the identity for otimes
				return ep1;
			}
		}
		
//		List<Expression> e_list = new LinkedList<Expression>();
//		e_list.add(ep1);
//		e_list.add(ep2);
//		MultiArgExpression mul_exp = PolyhedralIRUserFactory.eINSTANCE.createMultiArgExpression(op, e_list);
		BinaryExpression bin_exp = PolyhedralIRUserFactory.eINSTANCE.createBinaryExpression(op, ep1, ep2);
		return bin_exp;
	}
	
	private void ExpressionProcessing(OP op){
		ExpressionTuple et1 = this.expStack.pop();
		ExpressionTuple et2 = this.expStack.pop();
		
		if(DEBUG){
			
			System.out.println("stack size: " + this.expStack.size());
			System.out.println(PolyhedralIRToAlphabets.toSimplifiedString(et1.exp));
			System.out.println(PolyhedralIRToAlphabets.toSimplifiedString(et2.exp));
		}
		
		if(op.equals(this.s.op2)){
			if(DEBUG){
				System.out.println("same with serming2");
			}
			if(et1.isConsidered && et2.isConsidered){
				Expression exp = CreateExpression(this.s.op2, et1.exp, et2.exp);
				this.expStack.push(new ExpressionTuple(exp, true));
			}else if(et1.isConsidered){
				this.expStack.push(new ExpressionTuple(et1.exp, true));
			}else if(et2.isConsidered){
				this.expStack.push(new ExpressionTuple(et2.exp, true));
			}else{
				Expression exp = CreateExpression(this.s.op2, et1.exp, et2.exp);
				this.expStack.push(new ExpressionTuple(exp, false));
			}
		}else if(op.equals(this.s.op1)){
			if(DEBUG){
				System.out.println("same with sermring 1");
			}
			if(isVar){
				if(!(et1.isConsidered && et2.isConsidered)){
					Expression exp = CreateExpression(this.s.op1, et1.exp, et2.exp);
					//BinaryExpression bin_exp = PolyhedralIRUserFactory.eINSTANCE.createBinaryExpression(this.s.op1, et1.exp, et2.exp);
					this.expStack.push(new ExpressionTuple(exp, (et1.isConsidered || et2.isConsidered)));
				}
			}else{
				if(et1.isConsidered && et2.isConsidered){
					//BinaryExpression bin_exp = PolyhedralIRUserFactory.eINSTANCE.createBinaryExpression(this.s.op1, et1.exp, et2.exp);
					Expression exp = CreateExpression(this.s.op1, et1.exp, et2.exp);
					this.expStack.push(new ExpressionTuple(exp, true));
				}else{
					IntegerExpression e = PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(0);
					this.expStack.push(new ExpressionTuple(e, false));
				}
			}
		}else{
			if(DEBUG){
				System.out.println("inside other binary operations");
			}
			if(isVar){
				if(!(et1.isConsidered || et2.isConsidered)){
					Expression exp = CreateExpression(op, et1.exp, et2.exp);
					//BinaryExpression bin_exp = PolyhedralIRUserFactory.eINSTANCE.createBinaryExpression(b.getOperator(), et1.exp, et2.exp);
					this.expStack.push(new ExpressionTuple(exp, false));
				}
			}else{
				if(et1.isConsidered && et2.isConsidered){
					Expression exp = CreateExpression(op, et1.exp, et2.exp);
					//BinaryExpression bin_exp = PolyhedralIRUserFactory.eINSTANCE.createBinaryExpression(b.getOperator(), et1.exp, et2.exp);
					this.expStack.push(new ExpressionTuple(exp, true));
					
				}
			}
		}
	}
	
	@Override
	public void outMultiArgExpression(MultiArgExpression m) {
		outExpression(m);
		if(m.getExprs().size() > 2){	//scans only handle binary operator
			return;
		}
		
		ExpressionProcessing(m.getOperator());
	}
	
	
	@Override
	public void outBinaryExpression(BinaryExpression b) {
		outExpression(b);
		
		ExpressionProcessing(b.getOperator());
	}
	
	@Override
	public void outUnaryExpression(UnaryExpression u) {
		outExpression(u);
		
		ExpressionTuple et = this.expStack.pop();
		
		UnaryExpression e = PolyhedralIRUserFactory.eINSTANCE.createUnaryExpression(u.getOperator(), et.exp);
		
		this.expStack.push(new ExpressionTuple(e, et.isConsidered));
	}
	
	@Override
	public void outVariableExpression(VariableExpression v) {
		outExpression(v);
		if(DEBUG){
			System.out.println("Inside variable expression for " + v.getVarDecl().getName());
		}
		if(this.targetVarList.contains(v.getVarDecl())){
			if(v.getVarDecl().equals(this.target)){
				if(DEBUG){
					System.out.println("inside target variable expression");
				}
				if(isVar){
					Expression exp = (Expression)v.eContainer();
					AffineFunction af = null;
					if(exp instanceof DependenceExpression){
						af = ((DependenceExpression) exp).getDep();
					}else{
						af = PolyhedralIRUtility.createIdentityFunction(exp.getExpressionDomain());
					}
					
					if(DEBUG){
						System.out.println("depfunc:" + af);
						System.out.println("target func:" + this.affineTarget);
					}
					if(af.equivalence(this.affineTarget)){
						if(DEBUG){
							System.out.println("the same affine");
						}
						IntegerExpression e = PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(1);
						ExpressionTuple et = new ExpressionTuple(e, true);
						this.expStack.push(et);
					}else{
						IntegerExpression e = PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(0);
						ExpressionTuple et = new ExpressionTuple(e, true);
						this.expStack.push(et);
					}
				}else{
					IntegerExpression e = PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(0);
					ExpressionTuple et = new ExpressionTuple(e, false);
					this.expStack.push(et);
				}
			}else{
				if(DEBUG){
					System.out.println("inside ohter target variables");
				}
				
				IntegerExpression e = PolyhedralIRUserFactory.eINSTANCE.createIntegerExpression(0);
				if(isVar){
					this.expStack.push(new ExpressionTuple(e, true));
				}else{
					this.expStack.push(new ExpressionTuple(e, false));
				}
			}
		}else{
			if(DEBUG){
				System.out.println("inside other variable expression");
			}
			if(isVar){
				this.expStack.push(new ExpressionTuple(v, false));
			}else{
				if(DEBUG){
					System.out.println("get the constant coe for other var");
				}
				this.expStack.push(new ExpressionTuple(v, true));
			}
		}
	}
	
	@Override
	public void outConstantExpression(ConstantExpression c) {
		outExpression(c);
		if(DEBUG){
			System.out.println("in constant expression");
		}
		if(isVar){
			this.expStack.push(new ExpressionTuple(c, false));
		}else{
			this.expStack.push(new ExpressionTuple(c, true));
		}
	}
	
	private class ExpressionTuple{
		private Expression exp = null;
		private boolean isConsidered = false;
		
		public ExpressionTuple(Expression e, boolean b){
			exp = e;
			isConsidered = b;
		}
	}
}
