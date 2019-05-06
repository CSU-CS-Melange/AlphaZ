package org.polymodel.polyhedralIR.recurrence;

import java.util.List;

import org.polymodel.polyhedralIR.OP;


public class SermringUtilities{
	private static boolean DEBUG = true;
	
	//data structure for sermring
	public static class Sermring{
		public OP op1;
		public OP op2;
			
		public Sermring(){
			op1 = null;
			op2 = null;
		}
	}
	
	/**
	 * construct a possible legal sermring according to the given operator
	 * @return
	 */
	public static Sermring SermringConstruction(OP op, boolean isOtimes){
		Sermring s = new Sermring();
		if(isOtimes){
			s.op1 = op;
			switch(op){
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
			
		}
		return null;
	}
	
	public static boolean CheckSermring(Sermring s1, Sermring s2){
		if(s1.op1 != s2.op1 || s1.op2 != s2.op2){
			return false;
		}
		
		return true;
	}
	
	public static boolean CheckSermring(List<Sermring> sl, Sermring sm){
		boolean isValidate = true;
		
		Sermring temp = null;
		for(int i = 1; i < sl.size(); i++){
			temp = sl.get(i);
			if((temp.op1 != sm.op1) || (temp.op2 != sm.op2)){
				isValidate = false;
				break;
			}
		}
		
		return isValidate;
		
	}
	
	public static Sermring GetSermring(List<Sermring> sl){
		Sermring s = new Sermring();
		
		Sermring temp = sl.get(0);
		if((temp.op1 == OP.EQ) || (temp.op2 == OP.EQ)){	
			return null;
		}else{	//enumerate the possible sermrings
			if((temp.op1 == OP.MUL) && (temp.op2 == OP.ADD)){
				s.op1 = OP.MUL;
				s.op2 = OP.ADD;
				if(DEBUG){
					System.out.println("sermring is mul and and");
				}
			}else if((temp.op1 == OP.ADD) && (temp.op2 == OP.MAX)){
				s.op1 = OP.ADD;
				s.op2 = OP.MAX;
				if(DEBUG){
					System.out.println("sermring is ADD and MAX");
				}
			}else if((temp.op1 == OP.ADD) && (temp.op2 == OP.MIN)){
				s.op1 = OP.ADD;
				s.op2 = OP.MIN;
				if(DEBUG){
					System.out.println("sermring is ADD and MIN");
				}
			}else if((temp.op1 == OP.OR) && (temp.op2 == OP.AND)){
				s.op1 = OP.OR;
				s.op2 = OP.AND;
				if(DEBUG){
					System.out.println("sermring is or and and");
				}
			}else if((temp.op1 == OP.AND) && (temp.op2 == OP.OR)){
				s.op1 = OP.AND;
				s.op2 = OP.OR;
				if(DEBUG){
					System.out.println("sermring is and and or");
				}
			}else{
				return null;
			}
		}
		
		for(int i = 1; i < sl.size(); i++){
			temp = sl.get(i);
			if((temp.op1 != s.op1) || (temp.op2 != s.op2)){
				return null;
			}
		}
		
		return s;
	}
}
