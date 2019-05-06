package fr.irisa.cairn.jnimap.cloog.jni;

public class DefaultClastVisitor implements IClastExprVisitor,IClastStmtVisitor {

	public Object visitJNIClastBinary(JNIClastBinary expr, Object arg) {
		if(expr.getLHS()!=null) {
			expr.getLHS().accept(this,null);
		}
		return null;
	}

	public Object visitJNIClastReduction(JNIClastReduction expr,Object arg) {
		Object last= null;
		for (int i=0;i<expr.getN();i++) {
			last= expr.getElement(i).accept(this, arg);
		}
		return last;
	}

	public Object visitJNIClastName(JNIClastName expr, Object arg) {
		return expr.getName();
	}

	public Object visitJNIClastTerm(JNIClastTerm expr, Object arg) {
		return expr.getVar().accept(this, arg);
	}


	public Object visitJNIClastGuard(JNIClastGuard obj, Object arg) {
		for(int i=0;i<obj.getN();i++) {
			obj.getEquation(i).getLHS().accept(this, arg);
			obj.getEquation(i).getRHS().accept(this, arg);
		}
		return null;
	}

	public Object visitJNIClastAssignment(JNIClastAssignment obj, Object arg) {
		obj.getRHS().accept(this,arg);
		return obj.getNext().accept(this,arg);
	}

	public Object visitJNIClastUserStmt(JNIClastUserStmt obj, Object arg) {
		return obj.getSubstitutions();
	}

	public Object visitJNIClastFor(JNIClastFor obj, Object arg) {
		obj.getLB().accept(this,arg);
		obj.getUB().accept(this,arg);
		return obj.getBody().accept(this,arg);
	}

	public Object visitJNIClastRoot(JNIClastRoot obj, Object arg) {
		return obj.getNext();
	}

	public Object visitJNIClastBlock(JNIClastBlock obj, Object arg) {
		return obj.getBody();
	}

	public Object visitJNIClastExpr(JNIClastExpr expr, Object arg) {
		return null;
	}
	
	public Object visitJNIClastStmt(JNIClastStmt obj, Object arg) {
		return null;
	}

}