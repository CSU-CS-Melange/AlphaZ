package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Program;

public class SetSpaceTimeMapForMemoryFree  {
	
    
	/**
	set the space time map for the memory free statement for the input/ouput of a useEquation.
isInput -- 0, for the input of the useEquation
isInput -- 1, for the output of the useEquation
	**/
	public SetSpaceTimeMapForMemoryFree(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="label") String label,
@IModuleArgumentName(name="isInput") int isInput,
@IModuleArgumentName(name="num") int num,
@IModuleArgumentName(name="stMap") AffineFunction stMap) {
	    try {
		    alphaz.mde.TargetMapping.setSpaceTimeMapForMemoryFree(program,system,label,isInput,num,stMap);
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
	public SetSpaceTimeMapForMemoryFree(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="label") String label,
@IModuleArgumentName(name="isInput") int isInput,
@IModuleArgumentName(name="num") int num, @IModuleArgumentName(name="stMap") String stMap) {
	    try {
		    alphaz.mde.TargetMapping.setSpaceTimeMapForMemoryFree( program, system, label, isInput, num,  stMap);
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
