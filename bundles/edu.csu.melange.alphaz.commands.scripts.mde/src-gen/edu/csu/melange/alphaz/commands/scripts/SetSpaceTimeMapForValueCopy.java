package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Program;

public class SetSpaceTimeMapForValueCopy  {
	
    
	/**
	set the space time map for the value copy statement for input/output of a use equation
	**/
	public SetSpaceTimeMapForValueCopy(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="label") String label,
@IModuleArgumentName(name="isInput") int isInput,
@IModuleArgumentName(name="num") int num,
@IModuleArgumentName(name="stMap") AffineFunction stMap) {
	    try {
		    alphaz.mde.TargetMapping.setSpaceTimeMapForValueCopy(program,system,label,isInput,num,stMap);
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
	public SetSpaceTimeMapForValueCopy(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="label") String label,
@IModuleArgumentName(name="isInput") int isInput,
@IModuleArgumentName(name="num") int num, @IModuleArgumentName(name="stMap") String stMap) {
	    try {
		    alphaz.mde.TargetMapping.setSpaceTimeMapForValueCopy( program, system, label, isInput, num,  stMap);
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
