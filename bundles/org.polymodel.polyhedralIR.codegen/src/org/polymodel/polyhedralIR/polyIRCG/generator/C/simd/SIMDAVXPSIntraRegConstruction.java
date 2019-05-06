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
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VPermuteExpression;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.simdExp.VShuffleExpression;


public class SIMDAVXPSIntraRegConstruction extends SIMDIntraRegConstruction{
	public SIMDAVXPSIntraRegConstruction(VType _vtype, Domain _stmtDom, String _stmtGroup, int _stmtCount, Map<String, VRegister> _ori_reg_map, Map<VariableDeclaration, List<List<Integer>>> _var_deps_map, 
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
		
		//check 1 shuffle instruction
		if(generateWith1Shuffle(var, dep_vec, reg, regTable))	return;
		//check for distance 4
		if(generateWithDis4(var, dep_vec, reg, regTable))	return;
		//check for distance 2
		if(generateWithDis2(var, dep_vec, reg, regTable))	return;
		//check for distance 6
		if(generateWithDis6(var, dep_vec, reg, regTable))	return;
		//check for distance 1
		if(generateWithDis1(var, dep_vec, reg, regTable))	return;
		//check for distance 7
		if(generateWithDis7(var, dep_vec, reg, regTable))	return;
		//check for distance 3
		if(generateWithDis3(var, dep_vec, reg, regTable))	return;
		//check for distance 5
		if(generateWithDis5(var, dep_vec, reg, regTable))	return;
		
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
		//check whether the register can be constructed with 1 shuffle instruction
		//(1, -1)
		dep1.set(innermost_dim, innermost + 1);	
		dep2.set(innermost_dim, innermost - 1);
		reg1 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep1, var_offsets_map.get(var));
		reg2 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep2, var_offsets_map.get(var));
		//System.out.println("check for register " + reg1 + " and " + reg2);
		if((regTable.contains(reg1) || reg_map.get(reg1) != null) && (regTable.contains(reg2) || reg_map.get(reg2) != null)){
			if(reg_map.get(reg1) == null && visited.get(reg1) == 0)	constructRegister(var, dep1); 
			if(reg_map.get(reg2) == null && visited.get(reg2) == 0)	constructRegister(var, dep2);
			if(reg_map.get(reg1) != null && reg_map.get(reg2) != null){
				VShuffleExpression shuffle = _fact.createVShuffleExpression(EcoreUtil.copy(vtype), reg_map.get(reg1), reg_map.get(reg2), "0x99");
				VAssignExpression assign = _fact.createVAssignExpression(EcoreUtil.copy(vtype), reg, shuffle);
				stmts.add(_fact.createSIMDStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), assign));
				stmtCount++;
				reg_map.put(reg.getName(), reg);
				intraRegs.add(reg);
				return true;
			}
		}
		//(2, -2)
		dep1.set(innermost_dim, innermost + 2);
		dep2.set(innermost_dim, innermost - 2);
		reg1 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep1, var_offsets_map.get(var));
		reg2 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep2, var_offsets_map.get(var));
		//System.out.println("check for register " + reg1 + " and " + reg2);
		if((regTable.contains(reg1) || reg_map.get(reg1) != null) && (regTable.contains(reg2) || reg_map.get(reg2) != null)){
			if(reg_map.get(reg1) == null && visited.get(reg1) == 0)	constructRegister(var, dep1); 
			if(reg_map.get(reg2) == null && visited.get(reg2) == 0)	constructRegister(var, dep2);
			if(reg_map.get(reg1) != null && reg_map.get(reg2) != null){
				VShuffleExpression shuffle = _fact.createVShuffleExpression(EcoreUtil.copy(vtype), reg_map.get(reg1), reg_map.get(reg2), "0x4E");
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

	private boolean generateWithDis1(VariableDeclaration var, List<Integer> dep_vec, VRegister reg, List<String> regTable){
		int innermost_dim = dep_vec.size() - 1;
		int innermost = dep_vec.get(innermost_dim);
		List<Integer> dep1 = new LinkedList<Integer>();
		dep1.addAll(dep_vec);
		List<Integer> dep2 = new LinkedList<Integer>();
		dep2.addAll(dep_vec);
		
		String reg1, reg2;
		//check for distance 1
		//case 1: (-1, 3)
		dep1.set(innermost_dim, innermost + 1);
		dep2.set(innermost_dim, innermost - 3);
		reg1 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep1, var_offsets_map.get(var));
		reg2 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep2, var_offsets_map.get(var));
		//System.out.println("check for register " + reg1 + " and " + reg2);
		if((regTable.contains(reg1) || reg_map.get(reg1) != null) && (regTable.contains(reg2) || reg_map.get(reg2) != null)){
			if(reg_map.get(reg1) == null && visited.get(reg1) == 0)	constructRegister(var, dep1); 
			if(reg_map.get(reg2) == null && visited.get(reg2) == 0)	constructRegister(var, dep2);
			if(reg_map.get(reg1) != null && reg_map.get(reg2) != null){
				VShuffleExpression shuffle = _fact.createVShuffleExpression(EcoreUtil.copy(vtype), reg_map.get(reg1), reg_map.get(reg2), "0x4E");
				VShuffleExpression shuffle2 = _fact.createVShuffleExpression(EcoreUtil.copy(vtype), reg_map.get(reg1), shuffle, "0x99");
				VAssignExpression assign = _fact.createVAssignExpression(EcoreUtil.copy(vtype), reg, shuffle2);
				stmts.add(_fact.createSIMDStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), assign));
				stmtCount++;
				reg_map.put(reg.getName(), reg);
				intraRegs.add(reg);
				return true;
			}
		}
		//case 2: (-1, 7);
		dep1.set(innermost_dim, innermost + 1);
		dep2.set(innermost_dim, innermost - 7);
		reg1 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep1, var_offsets_map.get(var));
		reg2 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep2, var_offsets_map.get(var));
		//System.out.println("check for register " + reg1 + " and " + reg2);
		if((regTable.contains(reg1) || reg_map.get(reg1) != null) && (regTable.contains(reg2) || reg_map.get(reg2) != null)){
			if(reg_map.get(reg1) == null && visited.get(reg1) == 0)	constructRegister(var, dep1); 
			if(reg_map.get(reg2) == null && visited.get(reg2) == 0)	constructRegister(var, dep2);
			if(reg_map.get(reg1) != null && reg_map.get(reg2) != null){
				//construct intermediate permuted register 
				List<Integer> temp_dep = new LinkedList<Integer>();
				temp_dep.addAll(dep_vec);
				temp_dep.set(innermost_dim, innermost - 3);
				String temp_reg_name = vregNameConstructor.getVRegisterName(var, stmtGroup, temp_dep, var_offsets_map.get(var));
				VRegister temp_reg = _fact.createVRegister(EcoreUtil.copy(vtype), temp_reg_name);
				VPermuteExpression permute = _fact.createVPermuteExpression(EcoreUtil.copy(vtype), reg_map.get(reg1), reg_map.get(reg2), "0x21");
				VAssignExpression assign1 = _fact.createVAssignExpression(EcoreUtil.copy(vtype), temp_reg, permute);
				stmts.add(_fact.createSIMDStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), assign1));
				stmtCount++;
				reg_map.put(temp_reg_name, temp_reg);
				intraRegs.add(temp_reg);
				
				//construct the rest expression
				VShuffleExpression shuffle = _fact.createVShuffleExpression(EcoreUtil.copy(vtype), reg_map.get(reg1), temp_reg, "0x4E");
				VShuffleExpression shuffle2 = _fact.createVShuffleExpression(EcoreUtil.copy(vtype), reg_map.get(reg1), shuffle, "0x99");
				VAssignExpression assign2 = _fact.createVAssignExpression(EcoreUtil.copy(vtype), reg, shuffle2);
				stmts.add(_fact.createSIMDStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), assign2));
				stmtCount++;
				reg_map.put(reg.getName(), reg);
				intraRegs.add(reg);
				return true;
			}
		}
		
		return false;
	}
	
	private boolean generateWithDis2(VariableDeclaration var, List<Integer> dep_vec, VRegister reg, List<String> regTable){
		int innermost_dim = dep_vec.size() - 1;
		int innermost = dep_vec.get(innermost_dim);
		List<Integer> dep1 = new LinkedList<Integer>();
		dep1.addAll(dep_vec);
		List<Integer> dep2 = new LinkedList<Integer>();
		dep2.addAll(dep_vec);
		
		String reg1, reg2;
		//check for distance 2
		//case 1: (-2, 2) which is already checked in 1shuffle function, skip here
		//case 2: (-2, 6)
		dep1.set(innermost_dim, innermost + 2);
		dep2.set(innermost_dim, innermost - 6);
		reg1 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep1, var_offsets_map.get(var));
		reg2 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep2, var_offsets_map.get(var));
		//System.out.println("check for register " + reg1 + " and " + reg2);
		if((regTable.contains(reg1) || reg_map.get(reg1) != null) && (regTable.contains(reg2) || reg_map.get(reg2) != null)){
			if(reg_map.get(reg1) == null && visited.get(reg1) == 0)	constructRegister(var, dep1); 
			if(reg_map.get(reg2) == null && visited.get(reg2) == 0)	constructRegister(var, dep2);
			if(reg_map.get(reg1) != null && reg_map.get(reg2) != null){
				//construct intermediate permuted register 
				List<Integer> temp_dep = new LinkedList<Integer>();
				temp_dep.addAll(dep_vec);
				temp_dep.set(innermost_dim, innermost - 3);
				String temp_reg_name = vregNameConstructor.getVRegisterName(var, stmtGroup, temp_dep, var_offsets_map.get(var));
				VRegister temp_reg = _fact.createVRegister(EcoreUtil.copy(vtype), temp_reg_name);
				VPermuteExpression permute = _fact.createVPermuteExpression(EcoreUtil.copy(vtype), reg_map.get(reg1), reg_map.get(reg2), "0x21");
				VAssignExpression assign1 = _fact.createVAssignExpression(EcoreUtil.copy(vtype), temp_reg, permute);
				stmts.add(_fact.createSIMDStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), assign1));
				stmtCount++;
				reg_map.put(temp_reg_name, temp_reg);
				intraRegs.add(temp_reg);
				
				//construct the rest expression
				VShuffleExpression shuffle = _fact.createVShuffleExpression(EcoreUtil.copy(vtype), reg_map.get(reg1), temp_reg, "0x4E");
				VAssignExpression assign2 = _fact.createVAssignExpression(EcoreUtil.copy(vtype), reg, shuffle);
				stmts.add(_fact.createSIMDStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), assign2));
				stmtCount++;
				reg_map.put(reg.getName(), reg);
				intraRegs.add(reg);
				return true;
			}
		}
		
		return false;
	}
	
	private boolean generateWithDis3(VariableDeclaration var, List<Integer> dep_vec, VRegister reg, List<String> regTable){
		int innermost_dim = dep_vec.size() - 1;
		int innermost = dep_vec.get(innermost_dim);
		List<Integer> dep1 = new LinkedList<Integer>();
		dep1.addAll(dep_vec);
		List<Integer> dep2 = new LinkedList<Integer>();
		dep2.addAll(dep_vec);
		
		String reg1, reg2;
		//check for distance 1
		//case 1: (-3, 1)
		dep1.set(innermost_dim, innermost + 3);
		dep2.set(innermost_dim, innermost - 1);
		reg1 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep1, var_offsets_map.get(var));
		reg2 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep2, var_offsets_map.get(var));
		//System.out.println("check for register " + reg1 + " and " + reg2);
		if((regTable.contains(reg1) || reg_map.get(reg1) != null) && (regTable.contains(reg2) || reg_map.get(reg2) != null)){
			if(reg_map.get(reg1) == null && visited.get(reg1) == 0)	constructRegister(var, dep1); 
			if(reg_map.get(reg2) == null && visited.get(reg2) == 0)	constructRegister(var, dep2);
			if(reg_map.get(reg1) != null && reg_map.get(reg2) != null){
				VShuffleExpression shuffle = _fact.createVShuffleExpression(EcoreUtil.copy(vtype), reg_map.get(reg1), reg_map.get(reg2), "0x4E");
				VShuffleExpression shuffle2 = _fact.createVShuffleExpression(EcoreUtil.copy(vtype), shuffle, reg_map.get(reg2), "0x99");
				VAssignExpression assign = _fact.createVAssignExpression(EcoreUtil.copy(vtype), reg, shuffle2);
				stmts.add(_fact.createSIMDStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), assign));
				stmtCount++;
				reg_map.put(reg.getName(), reg);
				intraRegs.add(reg);
				return true;
			}
		}
		//case 2: (-3, 5);
		dep1.set(innermost_dim, innermost + 1);
		dep2.set(innermost_dim, innermost - 7);
		reg1 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep1, var_offsets_map.get(var));
		reg2 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep2, var_offsets_map.get(var));
		//System.out.println("check for register " + reg1 + " and " + reg2);
		if((regTable.contains(reg1) || reg_map.get(reg1) != null) && (regTable.contains(reg2) || reg_map.get(reg2) != null)){
			if(reg_map.get(reg1) == null && visited.get(reg1) == 0)	constructRegister(var, dep1); 
			if(reg_map.get(reg2) == null && visited.get(reg2) == 0)	constructRegister(var, dep2);
			if(reg_map.get(reg1) != null && reg_map.get(reg2) != null){
				//construct intermediate permuted register 
				List<Integer> temp_dep = new LinkedList<Integer>();
				temp_dep.addAll(dep_vec);
				temp_dep.set(innermost_dim, innermost - 1);
				String temp_reg_name = vregNameConstructor.getVRegisterName(var, stmtGroup, temp_dep, var_offsets_map.get(var));
				VRegister temp_reg = _fact.createVRegister(EcoreUtil.copy(vtype), temp_reg_name);
				VPermuteExpression permute = _fact.createVPermuteExpression(EcoreUtil.copy(vtype), reg_map.get(reg1), reg_map.get(reg2), "0x21");
				VAssignExpression assign1 = _fact.createVAssignExpression(EcoreUtil.copy(vtype), temp_reg, permute);
				stmts.add(_fact.createSIMDStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), assign1));
				stmtCount++;
				reg_map.put(temp_reg_name, temp_reg);
				intraRegs.add(temp_reg);
				
				//construct the rest expression
				VShuffleExpression shuffle = _fact.createVShuffleExpression(EcoreUtil.copy(vtype), reg_map.get(reg1), temp_reg, "0x4E");
				VShuffleExpression shuffle2 = _fact.createVShuffleExpression(EcoreUtil.copy(vtype), shuffle, temp_reg, "0x99");
				VAssignExpression assign2 = _fact.createVAssignExpression(EcoreUtil.copy(vtype), reg, shuffle2);
				stmts.add(_fact.createSIMDStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), assign2));
				stmtCount++;
				reg_map.put(reg.getName(), reg);
				intraRegs.add(reg);
				return true;
			}
		}
		
		return false;
	}
	
	private boolean generateWithDis4(VariableDeclaration var, List<Integer> dep_vec, VRegister reg, List<String> regTable){
		int innermost_dim = dep_vec.size() - 1;
		int innermost = dep_vec.get(innermost_dim);
		List<Integer> dep1 = new LinkedList<Integer>();
		dep1.addAll(dep_vec);
		List<Integer> dep2 = new LinkedList<Integer>();
		dep2.addAll(dep_vec);
		
		String reg1, reg2;
		//check for distance 1
		//case 1: (-4, 4)
		dep1.set(innermost_dim, innermost + 4);
		dep2.set(innermost_dim, innermost - 4);
		reg1 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep1, var_offsets_map.get(var));
		reg2 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep2, var_offsets_map.get(var));
		//System.out.println("check for register " + reg1 + " and " + reg2);
		if((regTable.contains(reg1) || reg_map.get(reg1) != null) && (regTable.contains(reg2) || reg_map.get(reg2) != null)){
			if(reg_map.get(reg1) == null && visited.get(reg1) == 0)	constructRegister(var, dep1); 
			if(reg_map.get(reg2) == null && visited.get(reg2) == 0)	constructRegister(var, dep2);
			if(reg_map.get(reg1) != null && reg_map.get(reg2) != null){
				VPermuteExpression permute  = _fact.createVPermuteExpression(EcoreUtil.copy(vtype), reg_map.get(reg1), reg_map.get(reg2), "0x21");
				VAssignExpression assign = _fact.createVAssignExpression(EcoreUtil.copy(vtype), reg, permute);
				stmts.add(_fact.createSIMDStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), assign));
				stmtCount++;
				reg_map.put(reg.getName(), reg);
				intraRegs.add(reg);
				return true;
			}
		}
		
		return false;
	}
	
	private boolean generateWithDis5(VariableDeclaration var, List<Integer> dep_vec, VRegister reg, List<String> regTable){
		int innermost_dim = dep_vec.size() - 1;
		int innermost = dep_vec.get(innermost_dim);
		List<Integer> dep1 = new LinkedList<Integer>();
		dep1.addAll(dep_vec);
		List<Integer> dep2 = new LinkedList<Integer>();
		dep2.addAll(dep_vec);
		
		String reg1, reg2;
		//check for distance 1
		//case 1: (-1, 3)
		dep1.set(innermost_dim, innermost + 1);
		dep2.set(innermost_dim, innermost - 3);
		reg1 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep1, var_offsets_map.get(var));
		reg2 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep2, var_offsets_map.get(var));
		//System.out.println("check for register " + reg1 + " and " + reg2);
		if((regTable.contains(reg1) || reg_map.get(reg1) != null) && (regTable.contains(reg2) || reg_map.get(reg2) != null)){
			if(reg_map.get(reg1) == null && visited.get(reg1) == 0)	constructRegister(var, dep1); 
			if(reg_map.get(reg2) == null && visited.get(reg2) == 0)	constructRegister(var, dep2);
			if(reg_map.get(reg1) != null && reg_map.get(reg2) != null){
				VShuffleExpression shuffle = _fact.createVShuffleExpression(EcoreUtil.copy(vtype), reg_map.get(reg1), reg_map.get(reg2), "0x4E");
				VShuffleExpression shuffle2 = _fact.createVShuffleExpression(EcoreUtil.copy(vtype), reg_map.get(reg1), shuffle, "0x99");
				VAssignExpression assign = _fact.createVAssignExpression(EcoreUtil.copy(vtype), reg, shuffle2);
				stmts.add(_fact.createSIMDStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), assign));
				stmtCount++;
				reg_map.put(reg.getName(), reg);
				intraRegs.add(reg);
				return true;
			}
		}
		//case 2: (-5, 3);
		dep1.set(innermost_dim, innermost + 5);
		dep2.set(innermost_dim, innermost - 3);
		reg1 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep1, var_offsets_map.get(var));
		reg2 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep2, var_offsets_map.get(var));
		//System.out.println("check for register " + reg1 + " and " + reg2);
		if((regTable.contains(reg1) || reg_map.get(reg1) != null) && (regTable.contains(reg2) || reg_map.get(reg2) != null)){
			if(reg_map.get(reg1) == null && visited.get(reg1) == 0)	constructRegister(var, dep1); 
			if(reg_map.get(reg2) == null && visited.get(reg2) == 0)	constructRegister(var, dep2);
			if(reg_map.get(reg1) != null && reg_map.get(reg2) != null){
				//construct intermediate permuted register 
				List<Integer> temp_dep = new LinkedList<Integer>();
				temp_dep.addAll(dep_vec);
				temp_dep.set(innermost_dim, innermost - 1);
				String temp_reg_name = vregNameConstructor.getVRegisterName(var, stmtGroup, temp_dep, var_offsets_map.get(var));
				VRegister temp_reg = _fact.createVRegister(EcoreUtil.copy(vtype), temp_reg_name);
				VPermuteExpression permute = _fact.createVPermuteExpression(EcoreUtil.copy(vtype), reg_map.get(reg1), reg_map.get(reg2), "0x21");
				VAssignExpression assign1 = _fact.createVAssignExpression(EcoreUtil.copy(vtype), temp_reg, permute);
				stmts.add(_fact.createSIMDStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), assign1));
				stmtCount++;
				reg_map.put(temp_reg_name, temp_reg);
				intraRegs.add(temp_reg);
				
				//construct the rest expression
				VShuffleExpression shuffle = _fact.createVShuffleExpression(EcoreUtil.copy(vtype), temp_reg, reg_map.get(reg2), "0x4E");
				VShuffleExpression shuffle2 = _fact.createVShuffleExpression(EcoreUtil.copy(vtype), temp_reg, shuffle, "0x99");
				VAssignExpression assign2 = _fact.createVAssignExpression(EcoreUtil.copy(vtype), reg, shuffle2);
				stmts.add(_fact.createSIMDStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), assign2));
				stmtCount++;
				reg_map.put(reg.getName(), reg);
				intraRegs.add(reg);
				return true;
			}
		}
		
		return false;
	}
	
	
	private boolean generateWithDis6(VariableDeclaration var, List<Integer> dep_vec, VRegister reg, List<String> regTable){
		int innermost_dim = dep_vec.size() - 1;
		int innermost = dep_vec.get(innermost_dim);
		List<Integer> dep1 = new LinkedList<Integer>();
		dep1.addAll(dep_vec);
		List<Integer> dep2 = new LinkedList<Integer>();
		dep2.addAll(dep_vec);
		
		String reg1, reg2;
		//check for distance 2
		//case 1: (-2, 2) which is already checked in 1shuffle function, skip here
		//case 2: (-6, 2)
		dep1.set(innermost_dim, innermost + 6);
		dep2.set(innermost_dim, innermost - 2);
		reg1 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep1, var_offsets_map.get(var));
		reg2 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep2, var_offsets_map.get(var));
		//System.out.println("check for register " + reg1 + " and " + reg2);
		if((regTable.contains(reg1) || reg_map.get(reg1) != null) && (regTable.contains(reg2) || reg_map.get(reg2) != null)){
			if(reg_map.get(reg1) == null && visited.get(reg1) == 0)	constructRegister(var, dep1); 
			if(reg_map.get(reg2) == null && visited.get(reg2) == 0)	constructRegister(var, dep2);
			if(reg_map.get(reg1) != null && reg_map.get(reg2) != null){
				//construct intermediate permuted register 
				List<Integer> temp_dep = new LinkedList<Integer>();
				temp_dep.addAll(dep_vec);
				temp_dep.set(innermost_dim, innermost - 3);
				String temp_reg_name = vregNameConstructor.getVRegisterName(var, stmtGroup, temp_dep, var_offsets_map.get(var));
				VRegister temp_reg = _fact.createVRegister(EcoreUtil.copy(vtype), temp_reg_name);
				VPermuteExpression permute = _fact.createVPermuteExpression(EcoreUtil.copy(vtype), reg_map.get(reg1), reg_map.get(reg2), "0x21");
				VAssignExpression assign1 = _fact.createVAssignExpression(EcoreUtil.copy(vtype), temp_reg, permute);
				stmts.add(_fact.createSIMDStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), assign1));
				stmtCount++;
				reg_map.put(temp_reg_name, temp_reg);
				intraRegs.add(temp_reg);
				
				//construct the rest expression
				VShuffleExpression shuffle = _fact.createVShuffleExpression(EcoreUtil.copy(vtype), temp_reg, reg_map.get(reg2), "0x4E");
				VAssignExpression assign2 = _fact.createVAssignExpression(EcoreUtil.copy(vtype), reg, shuffle);
				stmts.add(_fact.createSIMDStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), assign2));
				stmtCount++;
				reg_map.put(reg.getName(), reg);
				intraRegs.add(reg);
				return true;
			}
		}
		
		return false;
	}
	
	private boolean generateWithDis7(VariableDeclaration var, List<Integer> dep_vec, VRegister reg, List<String> regTable){
		int innermost_dim = dep_vec.size() - 1;
		int innermost = dep_vec.get(innermost_dim);
		List<Integer> dep1 = new LinkedList<Integer>();
		dep1.addAll(dep_vec);
		List<Integer> dep2 = new LinkedList<Integer>();
		dep2.addAll(dep_vec);
		
		String reg1, reg2;
		//check for distance 1
		//case 1: (-3, 1)
		dep1.set(innermost_dim, innermost + 3);
		dep2.set(innermost_dim, innermost - 1);
		reg1 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep1, var_offsets_map.get(var));
		reg2 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep2, var_offsets_map.get(var));
		//System.out.println("check for register " + reg1 + " and " + reg2);
		if((regTable.contains(reg1) || reg_map.get(reg1) != null) && (regTable.contains(reg2) || reg_map.get(reg2) != null)){
			if(reg_map.get(reg1) == null && visited.get(reg1) == 0)	constructRegister(var, dep1); 
			if(reg_map.get(reg2) == null && visited.get(reg2) == 0)	constructRegister(var, dep2);
			if(reg_map.get(reg1) != null && reg_map.get(reg2) != null){
				VShuffleExpression shuffle = _fact.createVShuffleExpression(EcoreUtil.copy(vtype), reg_map.get(reg1), reg_map.get(reg2), "0x4E");
				VShuffleExpression shuffle2 = _fact.createVShuffleExpression(EcoreUtil.copy(vtype), shuffle, reg_map.get(reg2), "0x99");
				VAssignExpression assign = _fact.createVAssignExpression(EcoreUtil.copy(vtype), reg, shuffle2);
				stmts.add(_fact.createSIMDStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), assign));
				stmtCount++;
				reg_map.put(reg.getName(), reg);
				intraRegs.add(reg);
				return true;
			}
		}
		//case 2: (-7, 1);
		dep1.set(innermost_dim, innermost + 7);
		dep2.set(innermost_dim, innermost - 1);
		reg1 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep1, var_offsets_map.get(var));
		reg2 = vregNameConstructor.getVRegisterName(var, stmtGroup, dep2, var_offsets_map.get(var));
		//System.out.println("check for register " + reg1 + " and " + reg2);
		if((regTable.contains(reg1) || reg_map.get(reg1) != null) && (regTable.contains(reg2) || reg_map.get(reg2) != null)){
			if(reg_map.get(reg1) == null && visited.get(reg1) == 0)	constructRegister(var, dep1); 
			if(reg_map.get(reg2) == null && visited.get(reg2) == 0)	constructRegister(var, dep2);
			if(reg_map.get(reg1) != null && reg_map.get(reg2) != null){
				//construct intermediate permuted register 
				List<Integer> temp_dep = new LinkedList<Integer>();
				temp_dep.addAll(dep_vec);
				temp_dep.set(innermost_dim, innermost - 1);
				String temp_reg_name = vregNameConstructor.getVRegisterName(var, stmtGroup, temp_dep, var_offsets_map.get(var));
				VRegister temp_reg = _fact.createVRegister(EcoreUtil.copy(vtype), temp_reg_name);
				VPermuteExpression permute = _fact.createVPermuteExpression(EcoreUtil.copy(vtype), reg_map.get(reg1), reg_map.get(reg2), "0x21");
				VAssignExpression assign1 = _fact.createVAssignExpression(EcoreUtil.copy(vtype), temp_reg, permute);
				stmts.add(_fact.createSIMDStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), assign1));
				stmtCount++;
				reg_map.put(temp_reg_name, temp_reg);
				intraRegs.add(temp_reg);
				
				//construct the rest expression
				VShuffleExpression shuffle = _fact.createVShuffleExpression(EcoreUtil.copy(vtype), temp_reg, reg_map.get(reg2), "0x4E");
				VShuffleExpression shuffle2 = _fact.createVShuffleExpression(EcoreUtil.copy(vtype), shuffle, reg_map.get(reg2),  "0x99");
				VAssignExpression assign2 = _fact.createVAssignExpression(EcoreUtil.copy(vtype), reg, shuffle2);
				stmts.add(_fact.createSIMDStatement(SIMDStmtConversionUtility.getVStmtName(stmtCount, stmtGroup), stmtDom.copy(), assign2));
				stmtCount++;
				reg_map.put(reg.getName(), reg);
				intraRegs.add(reg);
				return true;
			}
		}
		
		return false;
	}
}
