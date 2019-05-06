package org.polymodel.polyhedralIR.polyIRCG.factory;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDFactory;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDFunction;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDStatement;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_INS;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMD_WIDTH;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegFunctionParameter;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegisterInitialization;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VType;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.BasicMemoryAddress;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SIMDExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.SimdExpFactory;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VAssignExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VBinaryExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VLoadExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VOP;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VPermuteExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VRegisterExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VSetExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShiftExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShuffleExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VStoreExpression;

public class PolyIRCGSIMDUserFactory {
	public static final PolyIRCGSIMDUserFactory INSTANCE = new PolyIRCGSIMDUserFactory();
	
	public static final SimdExpFactory simdExpFact = SimdExpFactory.eINSTANCE;
	public static final SIMDFactory simdFact = SIMDFactory.eINSTANCE;
	
	
	//////////////////////UserFactory for SIMDExpression Creation 
	public VType createVType(Type type, int simd_width, String simd_ins){
		SIMD_WIDTH width = SIMD_WIDTH.M128;
		if(simd_width == 128){
			width = SIMD_WIDTH.M128;
		}else if(simd_width == 256){
			width = SIMD_WIDTH.M256;
		}else{
			throw new RuntimeException("Only 128 bits and 256 bits SIMD instructions are currently supported");
		}
		
		SIMD_INS ins= SIMD_INS.SSE;
		if(simd_ins.equals("SSE")){
			ins = SIMD_INS.SSE;
		}else if(simd_ins.equals("AVX")){
			ins = SIMD_INS.AVX;
		}else if(simd_ins.equals("FMA")) {
			ins = SIMD_INS.FMA;
		}else {
			throw new RuntimeException();
		}
		
		return createVType(type, width, ins);
	}
	
	public VType createVType(Type type, SIMD_WIDTH simd_width, SIMD_INS simd_ins){
		VType vtype = simdFact.createVType();
		
		vtype.setType(type);
		vtype.setWidth(simd_width);
		vtype.setIns(simd_ins);
		
		return vtype;
	}
	
	
	public VRegister createVRegister(VType type, String name){
		VRegister reg = simdFact.createVRegister();
		
		reg.setVtype(type);
		reg.setName(name);
		
		return reg;
	}
	
	public SIMDStatement createSIMDStatement(String name, Domain domain, SIMDExpression simdExp){
		SIMDStatement simdStmt = simdFact.createSIMDStatement();
		
		simdStmt.setName(name);
		simdStmt.setDomain(domain);
		simdStmt.setSimdExp(simdExp);
		
		return simdStmt;
	}
	
	public VRegisterInitialization createVRegisterInitialization(SIMDFunction func){
		VRegisterInitialization initBody = simdFact.createVRegisterInitialization();
		
		initBody.setFunction(func);
		initBody.getInputs().addAll(func.getInputsimdRegs());
		initBody.getLocals().addAll(func.getLocalsimdRegs());
		initBody.getOutputs().addAll(func.getOutputsimdRegs());
		
		return initBody;
	}
	
	public VRegFunctionParameter createVRegFunctionParameter(VRegister reg){
		VRegFunctionParameter parameter = simdFact.createVRegFunctionParameter();
		
		parameter.setRegister(reg);
		
		return parameter;
	}
	
	/*create Basic Memory address which is already a pointer that points to the right position*/
	public BasicMemoryAddress createBasicMemoryAccess(CodeGenVariable var, boolean isAligned, boolean isPointer){
		BasicMemoryAddress address = simdExpFact.createBasicMemoryAddress();
		
		address.setVar(var);
		address.setAligned(isAligned);
		address.setIsPointer(isPointer);
		
		return address;
	}
	
	/*create basic memory address which is at the position of an array*/
	public BasicMemoryAddress createBasicMemoryAccess(CodeGenVariable var, AffineFunction access, boolean isAligned){
		BasicMemoryAddress address = simdExpFact.createBasicMemoryAddress();
		
		address.setVar(var);
		address.setAccess(access);
		address.setAligned(isAligned);
		address.setIsPointer(false);
		
		return address;
	}
	
	public VAssignExpression createVAssignExpression(VType vtype, VRegister lreg, SIMDExpression exp){
		VAssignExpression assign = simdExpFact.createVAssignExpression();
		
		assign.setVtype(vtype);
		assign.setLreg(lreg);
		assign.setRexp(exp);
		
		return assign;
	}
	
	public VBinaryExpression createVBinaryExpression(VType vtype, SIMDExpression lexp, SIMDExpression rexp, VOP op){
		VBinaryExpression binary = simdExpFact.createVBinaryExpression();
		
		binary.setVtype(vtype);
		binary.setOp(op);
		binary.setLreg(lexp);
		binary.setRreg(rexp);
		
		return binary;
	}
	
	public VLoadExpression createVLoadExpression(VType vtype, VRegister reg, BasicMemoryAddress address){
		VLoadExpression load = simdExpFact.createVLoadExpression();
		
		load.setVtype(vtype);
		load.setDst(reg);
		load.setSrc(address);
		
		return load;
	}
	
	public VStoreExpression createVStoreExpression(VType vtype, VRegister reg, BasicMemoryAddress address){
		VStoreExpression store = simdExpFact.createVStoreExpression();
		
		store.setVtype(vtype);
		store.setSrc(reg);
		store.setDst(address);
		
		return store;
	}
	
	public VRegisterExpression createVRegisterExpression(VType vtype, VRegister reg){
		VRegisterExpression regExp = simdExpFact.createVRegisterExpression();
		
		regExp.setVtype(vtype);
		regExp.setReg(reg);
		
		return regExp;
	}
	
	public VSetExpression createVSetExpression(VType vtype, List<String> exps){
		VSetExpression set = simdExpFact.createVSetExpression();
		
		set.setVtype(vtype);
		set.getValues().addAll(exps);
		
		return set;
	}
	
	public VPermuteExpression createVPermuteExpression(VType vtype, VRegister reg1, VRegister reg2, String imm8){
		VRegisterExpression regExp1 = createVRegisterExpression(EcoreUtil.copy(vtype), reg1);
		VRegisterExpression regExp2 = createVRegisterExpression(EcoreUtil.copy(vtype), reg2);
		
		return createVPermuteExpression(vtype, regExp1, regExp2, imm8);
	}
	
	public VPermuteExpression createVPermuteExpression(VType vtype, SIMDExpression reg1, SIMDExpression reg2, String imm8){
		VPermuteExpression permute = simdExpFact.createVPermuteExpression();
		
		permute.setVtype(vtype);
		permute.setReg1(reg1);
		permute.setReg2(reg2);
		permute.setImm8(imm8);
		
		return permute;
	}
	
	public VShuffleExpression createVShuffleExpression(VType vtype, SIMDExpression reg1, SIMDExpression reg2, String imm8){
		VShuffleExpression shuffle = simdExpFact.createVShuffleExpression();
		
		shuffle.setVtype(vtype);
		shuffle.setReg1(reg1);
		shuffle.setReg2(reg2);
		shuffle.setImm8(imm8);
		
		return shuffle;
	}
	
	public VShuffleExpression createVShuffleExpression(VType vtype, VRegister reg1, VRegister reg2, String imm8){
		VRegisterExpression regExp1 = createVRegisterExpression(EcoreUtil.copy(vtype), reg1);
		VRegisterExpression regExp2 = createVRegisterExpression(EcoreUtil.copy(vtype), reg2);
		
		return createVShuffleExpression(vtype, regExp1, regExp2, imm8);
	}
	
	public VShuffleExpression createVShuffleExpression(VType vtype, VRegister reg1, SIMDExpression regExp2, String imm8){
		VRegisterExpression regExp1 = createVRegisterExpression(EcoreUtil.copy(vtype), reg1);
		
		return createVShuffleExpression(vtype, regExp1, regExp2, imm8);
	}
	
	public VShuffleExpression createVShuffleExpression(VType vtype, SIMDExpression regExp1, VRegister reg2, String imm8){
		VRegisterExpression regExp2 = createVRegisterExpression(EcoreUtil.copy(vtype), reg2);
		
		return createVShuffleExpression(vtype, regExp1, regExp2, imm8);
	}
	
	public VShiftExpression createVShiftExpression(VType vtype, SIMDExpression reg1, SIMDExpression reg2, int dis){
		VShiftExpression shift = simdExpFact.createVShiftExpression();
		
		shift.setVtype(vtype);
		shift.setReg1(reg1);
		shift.setReg2(reg2);
		shift.setDis(dis);
		
		return shift;
	}
	
	public VShiftExpression createVShiftExpression(VType vtype, VRegister reg1, VRegister reg2, int dis){
		VRegisterExpression regExp1 = createVRegisterExpression(EcoreUtil.copy(vtype), reg1);
		VRegisterExpression regExp2 = createVRegisterExpression(EcoreUtil.copy(vtype), reg2);
		
		return createVShiftExpression(vtype, regExp1, regExp2, dis);
	}

	 
	public SIMDFunction createSIMDFunction(String name, String returnType) {
		SIMDFunction func = simdFact.createSIMDFunction();
		
		func.setName(name);
		if (returnType == null) {
			func.setReturnType("void");
		} else {
			func.setReturnType(returnType);
		}
		
		return func;
	}
	public SIMDFunction createSIMDFunction(String name, Type returnType) {
		if (returnType == null) {
			return createSIMDFunction(name, "void");
		} else {
			return createSIMDFunction(name, returnType.toString());
		}
	}
}
