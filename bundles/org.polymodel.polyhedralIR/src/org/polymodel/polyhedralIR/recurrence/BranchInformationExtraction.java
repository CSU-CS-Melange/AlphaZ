package org.polymodel.polyhedralIR.recurrence;

import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.MultiArgExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.impl.PolyhedralIRInheritedDepthFirstVisitorImpl;
import org.polymodel.polyhedralIR.recurrence.SermringUtilities.Sermring;

public class BranchInformationExtraction extends PolyhedralIRInheritedDepthFirstVisitorImpl {
	private List<VariableDeclaration> targetVarList = null;
	private List<Sermring> serm_list = null;
	private HashMap<VariableDeclaration, List<AffineFunction>> cur_varFuncMap = null;
	private int count;
	private static boolean DEBUG = false;
	
	public BranchInformationExtraction(List<VariableDeclaration> _target_variable_list){
		targetVarList = _target_variable_list;
		serm_list = new BasicEList<Sermring>();
		cur_varFuncMap = new HashMap<VariableDeclaration, List<AffineFunction>>();
		//create a list for each variable
		for(int i = 0; i < _target_variable_list.size(); i++){
			cur_varFuncMap.put(_target_variable_list.get(i), new BasicEList<AffineFunction>());
		}
		count = 0;
	}
	
	public void InformationExtraction(Expression exp){
		//System.out.println(PolyhedralIRToAlphabets.toSimplifiedString(exp));
		exp.accept(this);
	}
	
	public List<Sermring> getSermringList(){
		return serm_list;
	}
	
	public HashMap<VariableDeclaration, List<AffineFunction>> getVariableFunctionMap(){
		return cur_varFuncMap;
	}
	
	//get the uniform depedence of the recurrence variable
	@Override
 	public void inVariableExpression(VariableExpression v) {
		inExpression(v);
		VariableDeclaration var_tmp = v.getVarDecl();
		if(targetVarList.contains(var_tmp)){
			count++;
			Expression e = null;
			Expression exp = (Expression)v.eContainer();
			if(exp instanceof DependenceExpression){
				cur_varFuncMap.get(var_tmp).add(((DependenceExpression) exp).getDep().copy());
				e = exp;
			}else{
				AffineFunction identity = PolyhedralIRUtility.createIdentityFunction(exp.getExpressionDomain().copy());
				cur_varFuncMap.get(var_tmp).add(identity);
				e = v;
			}
				
				//get the two operator 
				Sermring s = new Sermring();
				Expression e1 = null;
				Expression e2 = null;
				
				if(e.eContainer() == null){
					s.op1 = OP.MUL;
					s.op2 = OP.ADD;
				}else{
					e1 = (Expression)e.eContainer();
					if(e1 instanceof BinaryExpression){
						s.op1 = ((BinaryExpression) e1).getOperator();
					}else if(e1 instanceof MultiArgExpression){
						if(DEBUG){
							System.out.println("inside MultArg expression");
						}
						
						s.op1 = ((MultiArgExpression) e1).getOperator();
					}else{
						s.op1 = OP.EQ;
						s.op2 = OP.EQ;
					}
				}
				
				if(s.op2 == null){
					if(e1.eContainer() == null){
						switch(s.op1){
						case MUL:
							s.op2 = OP.ADD;
							break;
						case ADD:
							s.op2 = s.op1;
							s.op1 = OP.MUL;
							break;
						case MAX:
							s.op2 = s.op1;
							s.op1 = OP.ADD;
							break;
						case MIN:
							s.op2 = s.op1;
							s.op1 = OP.ADD;
							break;
						case OR:
							s.op2 = OP.AND;
							break;
						case AND:
							s.op2 = OP.OR;
							break;
						default:
							s.op2 = OP.EQ;
							break;
						}
					}else{
						e2 = (Expression)e1.eContainer();
						if(e2 instanceof BinaryExpression){
							s.op2 = ((BinaryExpression) e2).getOperator();
						}else if(e2 instanceof MultiArgExpression){
							s.op2 = ((MultiArgExpression) e2).getOperator();
						}else{
							switch(s.op1){
							case MUL:
								s.op2 = OP.ADD;
								break;
							case ADD:
								s.op2 = s.op1;
								s.op1 = OP.MUL;
								break;
							case MAX:
								s.op2 = s.op1;
								s.op1 = OP.ADD;
								break;
							case MIN:
								s.op2 = s.op1;
								s.op1 = OP.ADD;
								break;
							case OR:
								s.op2 = OP.AND;
								break;
							case AND:
								s.op2 = OP.OR;
								break;
							default:
								s.op2 = OP.EQ;
								break;
							}
						}
					}
				}
				
				if(s.op1 == s.op2){
					switch(s.op2){
					case ADD:
						s.op1 = OP.MUL;
						break;
					case MAX:
						s.op1 = OP.ADD;
						break;
					case MIN:
						s.op1 = OP.ADD;
						break;
					case OR:
						s.op1 = OP.AND;
						break;
					case AND:
						s.op1 = OP.OR;
						break;
					default:
						s.op1 = OP.EQ;
						break;
					}
				}
				serm_list.add(s);
			}
		}
}
