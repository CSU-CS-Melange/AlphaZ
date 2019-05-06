package org.polymodel.polyhedralIR.polyIRCG.generator.C.simd.dtiler;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.simd.VRegNameConstruction;

public class DTilerVRegNameConstruction extends VRegNameConstruction{
	public List<VariableDeclaration> bufferedVars;
	public Map<String, VariableDeclaration> buffername_var_map;

	public DTilerVRegNameConstruction(){
		super();
		bufferedVars = new LinkedList<VariableDeclaration>();
	}
	
	public DTilerVRegNameConstruction(List<VariableDeclaration> _bufferedVars, Map<String, VariableDeclaration> _buffername_var_map){
		super();
		bufferedVars = _bufferedVars;
		buffername_var_map = _buffername_var_map;
	}
	
	@Override
	public String getVRegisterName(VariableDeclaration var, String stmtGroup, List<Integer> dep, List<Integer> offset){
		String regName;
		if(bufferedVars.contains(var)){
			String temp_buffer_name = DTilerBufferingUtility.getTempBufferName(var, dep.get(0));
			VariableDeclaration temp_buffer_var = buffername_var_map.get(temp_buffer_name);
			
			regName = getVRegName(temp_buffer_var, stmtGroup, dep.subList(1, dep.size()), offset.subList(1, offset.size()));
		}else{
			regName = getVRegName(var, stmtGroup, dep, offset);
		}
		
		return regName;
	}
}