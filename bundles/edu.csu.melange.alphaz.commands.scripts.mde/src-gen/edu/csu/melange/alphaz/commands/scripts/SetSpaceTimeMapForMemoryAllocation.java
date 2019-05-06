package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Program;

public class SetSpaceTimeMapForMemoryAllocation  {
	
    
	/**
	set space time map for the memory allocation statement for the input/output of the use equation.
isInput -- 0: for nTh input of the use equaiton
isInput -- 1: for nTh output of the use equation
	**/
	public SetSpaceTimeMapForMemoryAllocation(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="label") String label,
@IModuleArgumentName(name="isInput") int isInput,
@IModuleArgumentName(name="num") int num,
@IModuleArgumentName(name="stMap") AffineFunction stMap) {
	    try {
		    alphaz.mde.TargetMapping.setSpaceTimeMapForMemoryAllocation(program,system,label,isInput,num,stMap);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		    //System.out.println("Unexpected Exception");
		    //e.printStackTrace();
		    throw new RuntimeException("Exception to terminate script");
		}
	}//function
	
    
	/**
	TODO : add description (to the model)
	**/
	public SetSpaceTimeMapForMemoryAllocation(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="label") String label,
@IModuleArgumentName(name="isInput") int isInput,
@IModuleArgumentName(name="num") int num, @IModuleArgumentName(name="stMap") String stMap) {
	    try {
		    alphaz.mde.TargetMapping.setSpaceTimeMapForMemoryAllocation( program, system, label, isInput, num,  stMap);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		    //System.out.println("Unexpected Exception");
		    //e.printStackTrace();
		    throw new RuntimeException("Exception to terminate script");
		}
	}//function
	
    


	public void compute(){
		
	}
}//endclass
