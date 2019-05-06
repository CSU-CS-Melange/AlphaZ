package org.polymodel.polyhedralIR.polyIRCG.generator.C.simd;

import java.util.LinkedList;
import java.util.List;

import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_INS;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VType;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SIMDExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VAssignExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VBinaryExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VLoadExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VPermuteExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VRegisterExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VSetExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShiftExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShuffleExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VStoreExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.util.SimdExpSwitch;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenUtility;

/**
 * Pretty Printer for SIMD instructions. 
 * @author zouyun
 *
 */
public class ExpressionPrinterForSIMD extends SimdExpSwitch<String>{
	public static String print(SIMDExpression expr){
		return (new ExpressionPrinterForSIMD()).start(expr);
	}
	
	protected String start(SIMDExpression expr){
		return this.doSwitch(expr);
	}
	
	@Override
	public String caseVLoadExpression(VLoadExpression load) {
		//construct load.dst = _mm_ins(load.src)
		String simd_load = load.getDst().getName() + "=";	
		simd_load += SIMDInstructionUtility.getLoadInstruction(load.getVtype(), load.getSrc().isAligned());
		simd_load += "( ";
		if(load.getSrc().isIsPointer()){
			simd_load += load.getSrc().getVar().getName();
		}else{
			simd_load += "&" + load.getSrc().getVar().getName() + "(";
			List<String> params = new LinkedList<String>();
			for (AffineExpression ile : load.getSrc().getAccess().getExpressions()) {
				params.add(ile.toString(OUTPUT_FORMAT.C));
			}
			simd_load += CodeGenUtility.toStringList(params, ",") + ")";
		}
		simd_load += " )";
		
		return simd_load;
	}
	
	@Override
	public String caseVStoreExpression(VStoreExpression store) {
		//construct _mm_ins(store.dst, store.src)
		String simd_store = SIMDInstructionUtility.getStoreInstruction(store.getVtype(), store.getDst().isAligned());
		simd_store += "( ";
		if(store.getDst().isIsPointer()){
			simd_store += store.getDst().getVar().getName() + ",";
		}else {
			simd_store += "&" +store.getDst().getVar().getName() + "(";
			List<String> params = new LinkedList<String>();
			for (AffineExpression ile : store.getDst().getAccess().getExpressions()) {
				params.add(ile.toString(OUTPUT_FORMAT.C));
			}
			simd_store += CodeGenUtility.toStringList(params, ",") + ")" + ",";
		}
		simd_store += store.getSrc().getName();
		simd_store += ")";
		
		return simd_store;
	}
	
	@Override
	public String caseVBinaryExpression(VBinaryExpression binary) {
		String simd_ins = SIMDInstructionUtility.getArchimethicInstruction(binary.getVtype(), binary.getOp());
		simd_ins += "( " + doSwitch(binary.getLreg()) + " , " + doSwitch(binary.getRreg()) + " )";
		
		return simd_ins;
	}
	
	@Override
	public String caseVRegisterExpression(VRegisterExpression reg) {
		return reg.getReg().getName();
	}
	
	@Override
	public String caseVSetExpression(VSetExpression set) {
		//System.out.println("the expression type" + set.getType().getWidth());
		boolean isSingle = true;
		if(set.getValues().size() > 1)	isSingle = false;
		String simd_ins =  SIMDInstructionUtility.getSetInstruction(set.getVtype(), isSingle);
		simd_ins += "(";
		for(int i = 0; i < set.getValues().size() - 1; i++){
			simd_ins += set.getValues().get(i) + ",";
		}
		simd_ins += set.getValues().get(set.getValues().size() - 1);
		simd_ins += " )";
		return simd_ins;
	}
	
	@Override
	public String caseVAssignExpression(VAssignExpression assign) {
		String simd_ins = assign.getLreg().getName();
		simd_ins += "=";
		simd_ins += doSwitch(assign.getRexp());
		return simd_ins;
	}
	
	@Override
	public String caseVShiftExpression(VShiftExpression shift){
		//consruct shift operation according to SSE or AVX
		String simd_ins = "";
		VType exp_type = shift.getVtype();
		//emumeration according to the instruction set and data type
		if(exp_type.getIns() == SIMD_INS.AVX){	//for avx instruction set
			if(exp_type.getType().getCName() == "double"){	//4-way avx shift
				simd_ins = AVX4WayShift(shift);
			}else{
				simd_ins = AVX8WayShift(shift);
			}
		}else{	//for sse instruction set
			if(exp_type.getType().getCName() == "double"){
				simd_ins = SSE2WayShift(shift);
			}else{
				simd_ins = SSE4WayShift(shift);
			}
		}
		
		return simd_ins;
	}
	
	@Override
	public String caseVPermuteExpression(VPermuteExpression permute){
		String simd_ins = SIMDInstructionUtility.getAVXPermuteInstruction(permute.getVtype()) + "(";
		simd_ins += doSwitch(permute.getReg1()) + ", ";
		simd_ins += doSwitch(permute.getReg2()) + ", ";
		simd_ins += permute.getImm8() + " )";
		
		return simd_ins;
	}
	
	@Override
	public String caseVShuffleExpression(VShuffleExpression shuffle){
		String simd_ins = SIMDInstructionUtility.getAVXShuffleInstruction(shuffle.getVtype()) + "(";
		simd_ins += doSwitch(shuffle.getReg1()) + " , ";
		simd_ins += doSwitch(shuffle.getReg2()) + " , ";
		simd_ins += shuffle.getImm8() + " )";
		
		return simd_ins;
	}
	
	protected String AVX4WayShift(VShiftExpression shift){
		String simd_ins = "";
		String reg1_exp = doSwitch(shift.getReg1());
		String reg2_exp = doSwitch(shift.getReg2());
		if(shift.getDis() == 1){	//_mm256_shuffle(reg1, _mm256_permute(reg1, reg2, 0x21), 0x5)
			simd_ins += SIMDInstructionUtility.getAVXShuffleInstruction(shift.getVtype()) + "(";
			simd_ins += reg1_exp + ", ";
			simd_ins += SIMDInstructionUtility.getAVXPermuteInstruction(shift.getVtype()) + "(";
			simd_ins += reg1_exp + ",";
			simd_ins += reg2_exp + ", " + "0x21" + " )";
			simd_ins += ", " + "0x5" + " )";
		}else if(shift.getDis() == 2){	//_mm256_permute(reg1, reg2, 0x21)
			simd_ins += SIMDInstructionUtility.getAVXPermuteInstruction(shift.getVtype()) + "(";
			simd_ins += reg1_exp + ",";
			simd_ins += reg2_exp + ", ";
			simd_ins += "0x21" + " )";
		}else if(shift.getDis() == 3){	//_mm256_shuffer(_mm256_permute(reg1, reg2, 0x21), reg2, 0x5)
			simd_ins += SIMDInstructionUtility.getAVXShuffleInstruction(shift.getVtype()) + "(";
			simd_ins += SIMDInstructionUtility.getAVXPermuteInstruction(shift.getVtype()) + "(";
			simd_ins += reg1_exp + ",";
			simd_ins += reg2_exp + ", " + "0x21" + " )";
			simd_ins += ", " + reg2_exp + ", " + "0x5" + " )";
 		}
		
		return simd_ins;
	}
	
	protected String AVX8WayShift(VShiftExpression shift){
		String simd_ins = "";
		String reg1_exp = doSwitch(shift.getReg1());
		String reg2_exp = doSwitch(shift.getReg2());
		
		if(shift.getDis() == 1){//_mm256_shuffle(reg1, _mm256_shuffle(reg1, _mm256_permute(reg1, reg2, 0x21), 0x4E), 0x99)
			simd_ins += SIMDInstructionUtility.getAVXShuffleInstruction(shift.getVtype()) + "(";
			simd_ins += reg1_exp + ", ";
			simd_ins += SIMDInstructionUtility.getAVXShuffleInstruction(shift.getVtype()) + "(";
			simd_ins += reg1_exp + ", ";
			simd_ins += SIMDInstructionUtility.getAVXPermuteInstruction(shift.getVtype()) + "(";
			simd_ins += reg1_exp + "," + reg2_exp + ", " + "0x21" + ")";
			simd_ins += ", " + "0x4E" + ")";
			simd_ins += ", " + "0x99" + ")";
		} else if(shift.getDis() == 2) {//_mm256_shuffle(reg1, _mm256_permute(reg1, reg2, 0x21), 0x4E)
			simd_ins += SIMDInstructionUtility.getAVXShuffleInstruction(shift.getVtype()) + "(";
			simd_ins += reg1_exp + ", ";
			simd_ins += SIMDInstructionUtility.getAVXPermuteInstruction(shift.getVtype()) + "(";
			simd_ins += reg1_exp + ", " + reg2_exp + ", " + "0x21" + ")";
			simd_ins += ", " + "0x4E" + ")";
		} else if(shift.getDis() == 3){//_mm256_shuffle(_mm256_shuffle(reg1, _mm256_permute(reg1, reg2, 0x21), 0x4E), _mm256_permute(reg1, reg2, 0x21), 0x99)
			simd_ins += SIMDInstructionUtility.getAVXShuffleInstruction(shift.getVtype()) + "(";
			simd_ins += SIMDInstructionUtility.getAVXShuffleInstruction(shift.getVtype()) + "(";
			simd_ins += reg1_exp + ", ";
			simd_ins += SIMDInstructionUtility.getAVXPermuteInstruction(shift.getVtype()) + "(";
			simd_ins += reg1_exp + ", " + reg2_exp + ", " + "0x21" + ")";
			simd_ins += ", " + "0x4E" + ")";
			simd_ins += ", " + SIMDInstructionUtility.getAVXPermuteInstruction(shift.getVtype()) + "(";
			simd_ins += reg1_exp + ", " + reg2_exp + ", " + "0x21" + ")";
			simd_ins += ", " + "0x99" + ")";
		}else if(shift.getDis() == 4){//_mm256_permute(reg1, reg2, 0x21)
			simd_ins += SIMDInstructionUtility.getAVXPermuteInstruction(shift.getVtype());
			simd_ins += reg1_exp + ", " + reg2_exp + ", " + "0x21" + ")";
		}else if(shift.getDis() == 5){//_mm256_shuffle(_mm256_permute(reg1, reg2, 0x21), _mm256_shuffle(_mm256_permute(reg1, reg2, 0x21), reg2, 0x4E), 0x99)
			simd_ins += SIMDInstructionUtility.getAVXShuffleInstruction(shift.getVtype()) + "(";
			simd_ins += SIMDInstructionUtility.getAVXPermuteInstruction(shift.getVtype()) + "(";
			simd_ins += reg1_exp + ", " + reg2_exp + ", " + "0x21" + ")";
			simd_ins += SIMDInstructionUtility.getAVXShuffleInstruction(shift.getVtype()) + "(";
			simd_ins += SIMDInstructionUtility.getAVXPermuteInstruction(shift.getVtype()) + "(";
			simd_ins += reg1_exp + ", " + reg2_exp + ", " + "0x21" + ")";
			simd_ins += ", " + reg2_exp + ", " + "0x4E" + ")";
			simd_ins += ", " + "0x99" + ")";
		}else if (shift.getDis() == 6){//_mm256_shuflle(_mm256_permute(reg1, reg2, 0x21), reg2, 0x4E)
			simd_ins += SIMDInstructionUtility.getAVXShuffleInstruction(shift.getVtype()) + "(";
			simd_ins += SIMDInstructionUtility.getAVXShuffleInstruction(shift.getVtype()) + "(";
			simd_ins += reg1_exp + ", " + reg2_exp + ", " + "0x21" + ")";
			simd_ins += reg2_exp + ", " + "0x4E" + ")";
		}else if(shift.getDis() == 7){//_mm256_shffle(_mm256_shuffle(_mm256_permute(reg1, reg2, 0x21), reg2, 0x4E), reg2, 0x99)
			simd_ins += SIMDInstructionUtility.getAVXShuffleInstruction(shift.getVtype()) + "(";
			simd_ins += SIMDInstructionUtility.getAVXShuffleInstruction(shift.getVtype()) + "(";
			simd_ins += SIMDInstructionUtility.getAVXPermuteInstruction(shift.getVtype()) + "(";
			simd_ins += reg1_exp + ", " + reg2_exp + ", " + "0x21" + ")";
			simd_ins += ", " + reg2_exp + ", " + "0x4E" + ")";
			simd_ins += ", " + reg2_exp + ", " + "0x99" + ")";
		}
		
		return simd_ins;
	}
	
	protected String SSE2WayShift(VShiftExpression shift){
		String simd_ins = "";
		
		return simd_ins;
	}
	
	protected String SSE4WayShift(VShiftExpression shift){
		String simd_ins = "";
		
		return simd_ins;
	}
	
}