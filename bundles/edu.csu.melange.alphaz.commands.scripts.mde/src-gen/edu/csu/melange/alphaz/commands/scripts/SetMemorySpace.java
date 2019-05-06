package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class SetMemorySpace  {
	
    
	/**
	Specifies the memory space for a variable. Normally, each variable has a separate memory space. However, some variables may share the same memory space, and this can be set up once by providing a list of variable.
	**/
	public SetMemorySpace(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="space") String space,
@IModuleArgumentName(name="varList") String varList) {
	    try {
		    alphaz.mde.TargetMapping.setMemorySpace(program,system,space,varList);
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
