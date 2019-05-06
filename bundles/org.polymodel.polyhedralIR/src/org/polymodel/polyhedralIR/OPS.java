package org.polymodel.polyhedralIR;

public class OPS {



	//Binary
	public static final String ADD_STR = "+";
	public static final String SUB_STR = "-";
	public static final String MUL_STR = "*";
	public static final String DIV_STR = "/";
	public static final String MOD_STR = "%";
	public static final String MAX_STR = "max";
	public static final String MIN_STR = "min";
	public static final String AND_STR = "and";
	public static final String OR_STR = "or";
	public static final String NAND_STR = "nand";
	public static final String NOR_STR = "nor";
	public static final String XOR_STR = "xor";
	public static final String EQ_STR = "==";
	public static final String NE_STR = "!=";
	public static final String LT_STR = "<";
	public static final String LE_STR = "<=";
	public static final String GT_STR = ">";
	public static final String GE_STR = ">=";
	
	//Unary
	public static final String NOT_STR = "not";
	public static final String NEG_STR = "-";
	
	//Multi
	public static final String ADD_MULTI_STR = "+";
	public static final String MUL_MULTI_STR = "*";
	public static final String MAX_MULTI_STR = "max";
	public static final String MIN_MULTI_STR = "min";
	public static final String AND_MULTI_STR = "and";
	public static final String OR_MULTI_STR = "or";
	
	public static String toString(OP op) {
		switch (op) {
			case ADD:
				return ADD_STR;
			case SUB:
				return SUB_STR;
			case MUL:
				return MUL_STR;
			case DIV:
				return DIV_STR;
			case MOD:
				return MOD_STR;
			case MAX:
				return MAX_STR;
			case MIN:
				return MIN_STR;
			case AND:
				return AND_STR;
			case OR:
				return OR_STR;
			case NAND:
				return NAND_STR;
			case NOR:
				return NOR_STR;
			case XOR:
				return XOR_STR;
			case EQ:
				return EQ_STR;
			case NE:
				return NE_STR;
			case GT:
				return GT_STR;
			case GE:
				return GE_STR;
			case LT:
				return LT_STR;
			case LE:
				return LE_STR;
			case NEG:
				return NEG_STR;
			case NOT:
				return NOT_STR;
					
		}
		
		throw new RuntimeException("Operator " + op + " does not exist.");
	}
	
	public static String toStringMultiArg(OP op) {
		switch (op) {
			case ADD:
				return ADD_MULTI_STR;
			case MUL:
				return MUL_MULTI_STR;
			case MAX:
				return MAX_MULTI_STR;
			case MIN:
				return MIN_MULTI_STR;
			case AND:
				return AND_MULTI_STR;
			case OR:
				return OR_MULTI_STR;
		}
		
		throw new RuntimeException("Operator " + op + " does not exist.");
	}

}
