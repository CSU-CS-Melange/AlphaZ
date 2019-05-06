package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class SetMemorySpaceForUseEquationOptimization  {
	
    
	/**
	set memory space for the input/ouput of the useEquation
	**/
	public SetMemorySpaceForUseEquationOptimization(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="label") String label,
@IModuleArgumentName(name="isInput") int isInput,
@IModuleArgumentName(name="num") int num,
@IModuleArgumentName(name="spaceName") String spaceName) {
	    try {
		    alphaz.mde.TargetMapping.setMemorySpaceForUseEquationOptimization(program,system,label,isInput,num,spaceName);
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
