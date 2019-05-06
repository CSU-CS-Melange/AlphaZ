package org.polymodel.polyhedralIR.polyIRCG.generator.C.simd;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VType;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VAssignExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShiftExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShuffleExpression;


public class SIMDAVXPDIntraRegConstruction extends SIMDIntraRegConstruction{
	public SIMDAVXPDIntraRegConstruction(VType _vtype, Domain _stmtDom, String _stmtGroup, int _stmtCount, Map<String, VRegister> _ori_reg_map, Map<VariableDeclaration, List<List<Integer>>> _var_deps_map, 
				Map<VariableDeclaration, List<Integer>> _var_offsets_map, VRegNameConstruction _vregNameConstructor){
		super(_vtype, _stmtDom, _stmtGroup, _stmtCount, _ori_reg_map, _var_deps_map, _var_offsets_map, _vregNameConstructor);
	}
	
	@Override
	protected void constructRegister(VariableDeclaration var, List<Integer> dep_vec){
		List<String> regTable = var_regname_map.get(var);
		String regName = vregNameConstructor.getVRegisterName(var, stmtGroup, dep_vec, var_offsets_map.get(var));
		visited.put(regName, 1);
		//System.out.println("construct register " + regName);
		VRegister reg = _fact.createVRegister(EcoreUtil.copy(vtype), regName);
		
		if(generateWith1Shuffle(var, dep_vec, reg, regTable))	return;
		if(generateWithDis2(var, dep_vec, reg, regTable))	return;
		if(generateWithDis1(var, dep_vec, reg, regTable))	return;
		if(generateWithDis3(var, dep_vec, reg, regTable))	return;
		
		throw new RuntimeException("register " + regName + " can not be constructed with existing registers."); 
	}
	
	private boolean generateWith1Shuffle(VariableDeclaration var, List<Integer> dep_vec, VRegister reg,  List<String> regTable){
		int innermost_dim = dep_vec.size() - 1;
		int innermost = dep_vec.get(innermost_dim);
	
		List<Integer> dep1 = new LinkedList<Integer>();
		dep1.addAll(dep_vec);
		List<Integer> dep2 = new LinkedList<Integer>();
		dep2.addAll(dep_vec);
		
		String reg1, reg2;
		//check whether the register can be constructed with 1 shuffle instruction: (-1, 1)
		dep1.set(innermost_dim, innermost + 1);	
		dep2.set(innermost_dim, innermost - 1);
		reg1 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep1, var_offsets_map.get(var));
		reg2 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep2, var_offsets_map.get(var));
		//System.out.println("check for register " + reg1 + " and " + reg2);
		if((regTable.contains(reg1) || reg_map.get(reg1) != null) && (regTable.contains(reg2) || reg_map.get(reg2) != null)){
			if(reg_map.get(reg1) == null && visited.get(reg1) == 0)	constructRegister(var, dep1); 
			if(reg_map.get(reg2) == null && visited.get(reg2) == 0)	constructRegister(var, dep2);
			if(reg_map.get(reg1) != null && reg_map.get(reg2) != null){
				VShuffleExpression shuffle = _fact.createVShuffleExpression(EcoreUtil.copy(vtype), reg_map.get(reg1), reg_map.get(reg2), "0x5");
				VAssignExpression assign = _fact.createVAssignExpression(EcoreUtil.copy(vtype), reg, shuffle);
				stmts.add(_fact.createSIMDStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), assign));
				stmtCount++;
				reg_map.put(reg.getName(), reg);
				intraRegs.add(reg);
				return true;
			}
		}
		return false;
	}
	
	private boolean generateWithDis1(VariableDeclaration var, List<Integer> dep_vec, VRegister reg,  List<String> regTable){
		int innermost_dim = dep_vec.size() - 1;
		int innermost = dep_vec.get(innermost_dim);
	
		List<Integer> dep1 = new LinkedList<Integer>();
		dep1.addAll(dep_vec);
		List<Integer> dep2 = new LinkedList<Integer>();
		dep2.addAll(dep_vec);
		
		String reg1, reg2;
		//(-1, 3)
		dep1.set(innermost_dim, innermost + 1);	
		dep2.set(innermost_dim, innermost - 3);	
		reg1 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep1, var_offsets_map.get(var));
		reg2 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep2, var_offsets_map.get(var));
		//System.out.println("check for register " + reg1 + " and " + reg2);
		if((regTable.contains(reg1) || reg_map.get(reg1) != null) && (regTable.contains(reg2) || reg_map.get(reg2) != null)){
			int dis = 1;
			
			if(reg_map.get(reg1) == null && visited.get(reg1) == 0)	constructRegister(var, dep1);
			if(reg_map.get(reg2) == null && visited.get(reg2) == 0)	constructRegister(var, dep2);
			if(reg_map.get(reg1) != null && reg_map.get(reg2) != null){
				VShiftExpression shift = _fact.createVShiftExpression(EcoreUtil.copy(vtype), reg_map.get(reg1), reg_map.get(reg2), dis);
				VAssignExpression assign = _fact.createVAssignExpression(EcoreUtil.copy(vtype), reg, shift);
				stmts.add(_fact.createSIMDStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), assign));
				stmtCount++;
				reg_map.put(reg.getName(), reg);
				intraRegs.add(reg);
				return true;
			}
		}
		return false;
	}
	
	private boolean generateWithDis2(VariableDeclaration var, List<Integer> dep_vec, VRegister reg,  List<String> regTable){
		int innermost_dim = dep_vec.size() - 1;
		int innermost = dep_vec.get(innermost_dim);
	
		List<Integer> dep1 = new LinkedList<Integer>();
		dep1.addAll(dep_vec);
		List<Integer> dep2 = new LinkedList<Integer>();
		dep2.addAll(dep_vec);
		
		String reg1, reg2;
		//(-2, 2)
		dep1.set(innermost_dim, innermost + 2);
		dep2.set(innermost_dim, innermost - 2);
		reg1 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep1, var_offsets_map.get(var));
		reg2 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep2, var_offsets_map.get(var));
		//System.out.println("check fro registers " + reg1 + " and " + reg2);
		if((regTable.contains(reg1) || reg_map.get(reg1) != null) && (regTable.contains(reg2) || reg_map.get(reg2) != null)){
			int dis = 2;

			if(reg_map.get(reg1) == null && visited.get(reg1) == 0)	constructRegister(var, dep1);
			if(reg_map.get(reg2) == null && visited.get(reg2) == 0)	constructRegister(var, dep2);
			if(reg_map.get(reg1) != null && reg_map.get(reg2) != null){
				VShiftExpression shift = _fact.createVShiftExpression(EcoreUtil.copy(vtype), reg_map.get(reg1), reg_map.get(reg2), dis);
				VAssignExpression assign = _fact.createVAssignExpression(EcoreUtil.copy(vtype), reg, shift);
				stmts.add(_fact.createSIMDStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), assign));
				stmtCount++;
				reg_map.put(reg.getName(), reg);
				intraRegs.add(reg);
				return true;
			}
		}
		return false;
	}
	
	private boolean generateWithDis3(VariableDeclaration var, List<Integer> dep_vec, VRegister reg,  List<String> regTable){
		int innermost_dim = dep_vec.size() - 1;
		int innermost = dep_vec.get(innermost_dim);
	
		List<Integer> dep1 = new LinkedList<Integer>();
		dep1.addAll(dep_vec);
		List<Integer> dep2 = new LinkedList<Integer>();
		dep2.addAll(dep_vec);
		
		String reg1, reg2;
		//(-3, 1)
		dep1.set(innermost_dim, innermost + 3);
		dep2.set(innermost_dim, innermost - 1);
		reg1 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep1, var_offsets_map.get(var));
		reg2 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep2, var_offsets_map.get(var));
		//System.out.println("check for registers " + reg1 + " and " + reg2);
		if((regTable.contains(reg1) || reg_map.get(reg1) != null) && (regTable.contains(reg2) || reg_map.get(reg2) != null)){
			int dis = 3;

			if(reg_map.get(reg1) == null && visited.get(reg1) == 0)	constructRegister(var, dep1);
			if(reg_map.get(reg2) == null && visited.get(reg2) == 0)	constructRegister(var, dep2);
			if(reg_map.get(reg1) != null && reg_map.get(reg2) != null){
				VShiftExpression shift = _fact.createVShiftExpression(EcoreUtil.copy(vtype), reg_map.get(reg1), reg_map.get(reg2), dis);
				VAssignExpression assign = _fact.createVAssignExpression(EcoreUtil.copy(vtype), reg, shift);
				stmts.add(_fact.createSIMDStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), assign));
				stmtCount++;
				reg_map.put(reg.getName(), reg);
				intraRegs.add(reg);
				return true;
			}
		}
		return false;
	}
}
