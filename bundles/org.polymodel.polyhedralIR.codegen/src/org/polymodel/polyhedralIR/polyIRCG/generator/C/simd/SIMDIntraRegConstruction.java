package org.polymodel.polyhedralIR.polyIRCG.generator.C.simd;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDStatement;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VRegister;
import org.polymodel.polyhedralIR.polyIRCG.SIMD.VType;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGSIMDUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGUserFactory;

/**
 * Construct all the registers that is needed with the set of given registers
 * The set of given registers are initialized as reg_map
 * @author zouyun
 *
 */
public class SIMDIntraRegConstruction{
	public static final PolyIRCGSIMDUserFactory _fact = PolyIRCGSIMDUserFactory.INSTANCE;
	public static final PolyIRCGUserFactory _cgfact = PolyIRCGUserFactory.INSTANCE;
	
	protected VType vtype;		//register/SIMD instruction type
	protected int stmtCount;	//the statement count
	protected Domain stmtDom;	//the statement domain for the SIMD statement used to create the 
	protected String stmtGroup;	
	protected final VRegNameConstruction vregNameConstructor;
	
	//return variables 
	public List<SIMDStatement> stmts;	//the SIMD statements required for constructing the intermediate registers
	public List<VRegister> intraRegs;	//the intermediate registers created 
	
	//inputs
	protected Map<String, VRegister> reg_map;		//the register-name map for all the registers that have been created	
	protected Map<VariableDeclaration, List<List<Integer>>> var_deps_map;		//the memory access dependences for each variable that are corresponding to each register
	protected Map<VariableDeclaration, List<Integer>> var_offsets_map;	//the offsets used for naming creation
	protected List<VariableDeclaration> bufferedVars;	//the variables that are buffered
	
	protected Map<VariableDeclaration, List<String>> var_regname_map;	//the register name and dependence map that have to be created for each variable 
	protected Map<String, Integer> visited;		//record whether the current node is already visited, 0 -- not visited; 1 -- visited
	
	public SIMDIntraRegConstruction(VType _vtype, Domain _stmtDom, String _stmtGroup, int _stmtCount, Map<String, VRegister> _ori_reg_map, Map<VariableDeclaration, List<List<Integer>>> _var_deps_map, 
				Map<VariableDeclaration, List<Integer>> _var_offsets_map,  VRegNameConstruction _vregNameConstructor){
		vtype = _vtype;
		stmtGroup = _stmtGroup;
		stmtDom = _stmtDom;
		stmtCount = _stmtCount;
		reg_map = _ori_reg_map;
		var_deps_map = _var_deps_map;
		var_offsets_map = _var_offsets_map;
		vregNameConstructor = _vregNameConstructor;
		stmts = new LinkedList<SIMDStatement>();
		intraRegs = new LinkedList<VRegister>();
		initRegTable();
		
//		System.out.println("the initialized register ");
//		for(Map.Entry<String, VRegister> reg_entry: reg_map.entrySet()){
//			System.out.println(reg_entry.getKey());
//		}
	}
	
	private void initRegTable(){
		var_regname_map = new HashMap<VariableDeclaration, List<String>>();
		visited = new HashMap<String, Integer>();
		
		for(Map.Entry<VariableDeclaration, List<List<Integer>>> var_deps_entry: var_deps_map.entrySet()){
			VariableDeclaration var = var_deps_entry.getKey();
			List<String> regTable = new LinkedList<String>();
			for(List<Integer> dep_vec: var_deps_entry.getValue()){
				String reg_name = vregNameConstructor.getVRegisterName(var, stmtGroup, dep_vec, var_offsets_map.get(var));
				regTable.add(reg_name);
				visited.put(reg_name, 0);	
			}
			
			var_regname_map.put(var, regTable);
		}
	}
	
	
	
	public void generateIntraRegisters(){
		for(Map.Entry<VariableDeclaration, List<List<Integer>>> var_deps_entry: var_deps_map.entrySet()){
			VariableDeclaration var = var_deps_entry.getKey();
			for(List<Integer> dep_vec: var_deps_entry.getValue()){
				String regName = vregNameConstructor.getVRegisterName(var, stmtGroup, dep_vec, var_offsets_map.get(var));
				if(reg_map.get(regName) == null) {
					constructRegister(var, dep_vec);
				}
			}
		}
	}
	
	/**
	 * This function has to be override for different SIMD instruction and data type
	 * @param var
	 * @param dep_vec
	 */
	protected void constructRegister(VariableDeclaration var, List<Integer> dep_vec){
	}
}
