package org.polymodel.polyhedralIR.recurrence.bis;

import org.polymodel.polyhedralIR.OP;

public class Semiring{
	public final OP oplus;
	public final OP otimes;
		
	protected Semiring(OP oplus, OP otimes){
		this.oplus = oplus;
		this.otimes = otimes;
	}
	
	public static Semiring constructSemiring(OP op, boolean isOtimes){
		OP op1 = null, op2 = null;
		
		if (isOtimes) {
			op1 = op;
			switch(op){
			case MUL:
				op2 = OP.ADD;
				break;
			case ADD:
				op2 = op1;
				op1 = OP.MUL;
				break;
			case MAX:
				op2 = op1;
				op1 = OP.ADD;
				break;
			case MIN:
				op2 = op1;
				op1 = OP.ADD;
				break;
			case OR:
				op2 = OP.AND;
				break;
			case AND:
				op2 = OP.OR;
				break;
			default:
				op2 = OP.EQ;
				break;
			}
		}
		
		if (op1 == null || op2 == null)
			return null;

		return new Semiring(op1, op2);
	}
	
	@Override
	public String toString() {
		return "(" + oplus + ", " + otimes + ")";
	}
	
	public static Semiring findPossibleSemiring(OP oplus, OP otimes) {
		if ((oplus == null && otimes == OP.ADD)||
			(oplus == OP.ADD && otimes == null)) {
			oplus = OP.ADD;
			otimes = OP.MUL;
		}
		
		//enumerate the possible semirings
		if (((oplus == OP.ADD) && (otimes == OP.MUL)) ||
			((oplus == OP.MAX) && (otimes == OP.ADD)) ||
			((oplus == OP.MIN) && (otimes == OP.ADD)) ||
			((oplus == OP.OR)  && (otimes == OP.AND))) {
			return new Semiring(oplus, otimes);
		}

		return null;
	}
}
	
