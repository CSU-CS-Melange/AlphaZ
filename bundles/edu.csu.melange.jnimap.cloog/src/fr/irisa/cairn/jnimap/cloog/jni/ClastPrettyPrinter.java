package fr.irisa.cairn.jnimap.cloog.jni;

public class ClastPrettyPrinter implements IClastExprVisitor,IClastStmtVisitor {

	public static String pp(JNIClastStmt stmt) {
		return ""+stmt.accept(new ClastPrettyPrinter(),null);
	}
	
	String indent;
	void incIndent() { indent += "  "; }
	void decIndent() { indent = indent.substring(0,indent.length()-2); }
	
	public ClastPrettyPrinter() {
		indent = "";
	}

	public ClastPrettyPrinter(String prefix) {
		indent = prefix+" ";
	}
	
	public Object visitJNIClastBinary(JNIClastBinary expr, Object arg) {
		if(expr.testLHS()) {
			String lhs = "";
				lhs = ""+expr.getLHS().accept(this,null);
				return lhs+" "+expr.getType().name.replace("clast_bin_", "")+" "+expr.getRHS();
		} else {
			return "??";
		}
		
		
	}

	public Object visitJNIClastReduction(JNIClastReduction expr,Object arg) {
		JNIClastRedType type = expr.getType();
		String res =type.getName().replace("clast_red_","")
				+"(";
		int n = expr.getN();
		if (n == 1)
			return expr.getElement(0).accept(this, arg);
		
		if (type.getName().equals("clast_red_sum")) {
			res = "";
			for(int i=0;i<n;i++) {
				if(i>0) {
					res += "+";
				}
				res += expr.getElement(i).accept(this, arg);
			}
			return res.replace("+-", "-");
		}
		
		for(int i=0;i<n;i++) {
			if(i>0) {
				res+=',';
			}
			res+= expr.getElement(i).accept(this, arg);
		}
		return res+")";
	}

	public Object visitJNIClastName(JNIClastName expr, Object arg) {
		String name = expr.getName();
		return name;
	}

	public Object visitJNIClastTerm(JNIClastTerm expr, Object arg) {
		int value = expr.getValue();
		if (expr.testVar()) {
			Object accept = expr.getVar().accept(this, arg);
			if(accept!=null) {
				if(value==1) 
					return accept;
				else if(value==-1) 
					return "-"+accept;
				else  
					return value+"*"+accept;
				
			}
			else
				return Integer.toString(value);
		}
		return Integer.toString(value);
	}


	public Object visitJNIClastGuard(JNIClastGuard obj, Object arg) {
		String res = indent+"if (";
		int n = obj.getN();
		for(int i=0;i<n;i++) {
			if(i>0) {
				res+=',';
			}
			JNIClastEquation equation = obj.getEquation(i);
			res+=equation.getLHS().accept(this, arg);
			int sign = equation.getSign();
			res+=sign>0?">=":"<=";
			res+=equation.getRHS().accept(this, arg);
		}
		res+=") {\n";
		incIndent();
		res+= obj.getThen().accept(this, arg);
		decIndent();
		res+="\n"+indent+"}";
		if (obj.testNext())
			res += "\n"+obj.getNext().accept(this, null);
		
		
		return res;
	}

	public Object visitJNIClastAssignment(JNIClastAssignment obj, Object arg) {
		String assign = "";
		if (obj.testLHS())
			assign = obj.getLHS()+"=";
		 assign += obj.getRHS().accept(this,arg);
		if(obj.testNext()) 
			return assign+","+obj.getNext().accept(this,null);
		else 
			return assign;
	}

	public Object visitJNIClastUserStmt(JNIClastUserStmt obj, Object arg) {
		String res;
		JNICloogStatement statement = obj.getStatement();
		res = indent+statement.getName()+":#"+statement.getNumber()+"(";
		if(obj.testSubstitutions()) {
			Object substitution = obj.getSubstitutions().accept(this, arg);
			res+=substitution+");";
		}
		res += ");";
		if (obj.testNext())
			res += "\n"+obj.getNext().accept(this, null);
		return res;
	}

	public Object visitJNIClastFor(JNIClastFor obj, Object arg) {
		String i = obj.getIterator();
		String lb = "";
		if(obj.testLB()) {
			lb = (String) obj.getLB().accept(this,arg);
		}
		String ub = "NULL";
		if(obj.testUB()) {
			ub = (String) obj.getUB().accept(this,arg);
		}
		incIndent();
		Object body = obj.getBody().accept(this, arg);
		decIndent();
		String res = indent+"for("+i+"="+lb+";"+i+"<="+ub+";"+i+"++) " +
				//"["+obj.getCloogDomain()+"]" +
				"{\n"+body+"\n"+indent+"}";

		if (obj.testNext())
			res += "\n"+obj.getNext().accept(this, null);
		
		
		return res;
	}

	public Object visitJNIClastRoot(JNIClastRoot obj, Object arg) {
		if (obj.testNext())
			return obj.getNext().accept(this,null);
		return "null";
	}
	
	public Object visitJNIClastBlock(JNIClastBlock obj, Object arg) {
		return obj.getBody();
	}

	public Object visitJNIClastExpr(JNIClastExpr expr, Object arg) {
		return "[EXPR]";
	}
	
	public Object visitJNIClastStmt(JNIClastStmt obj, Object arg) {
		return "[STMT]";
	}

}