package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Program;

public class SetMemoryMap  {
	
    
	/**
	Specifies a memory map for a variable. Some variables may share the same meory map and memory space, then they can be set up using one command by providing a list of variables. 
	**/
	public SetMemoryMap(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="varList") String varList,
@IModuleArgumentName(name="memorySpace") String memorySpace,
@IModuleArgumentName(name="memoryMap") AffineFunction memoryMap,
@IModuleArgumentName(name="modFactors") String modFactors) {
	    try {
		    alphaz.mde.TargetMapping.setMemoryMap(program,system,varList,memorySpace,memoryMap,modFactors);
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
	public SetMemoryMap(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="varList") String varList,
@IModuleArgumentName(name="memorySpace") String memorySpace, @IModuleArgumentName(name="memoryMap") String memoryMap,
@IModuleArgumentName(name="modFactor") String modFactor) {
	    try {
		    alphaz.mde.TargetMapping.setMemoryMap( program, system, varList, memorySpace,  memoryMap, modFactor);
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
	public SetMemoryMap(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="varList") String varList,
@IModuleArgumentName(name="memoryMap") AffineFunction memoryMap,
@IModuleArgumentName(name="modFactors") String modFactors) {
	    try {
		    alphaz.mde.TargetMapping.setMemoryMap( program, system, varList, memoryMap, modFactors);
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
	public SetMemoryMap(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="varList") String varList,
@IModuleArgumentName(name="memoryMap") AffineFunction memoryMap) {
	    try {
		    alphaz.mde.TargetMapping.setMemoryMap( program, system, varList, memoryMap);
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
	public SetMemoryMap(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="varList") String varList,
@IModuleArgumentName(name="memorySpace") String memorySpace,
@IModuleArgumentName(name="memoryMap") AffineFunction memoryMap) {
	    try {
		    alphaz.mde.TargetMapping.setMemoryMap( program, system, varList, memorySpace, memoryMap);
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
	public SetMemoryMap(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="varList") String varList,
@IModuleArgumentName(name="memorySpace") String memorySpace, @IModuleArgumentName(name="memoryMap") String memoryMap) {
	    try {
		    alphaz.mde.TargetMapping.setMemoryMap( program, system, varList, memorySpace,  memoryMap);
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
	public SetMemoryMap(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="varList") String varList, @IModuleArgumentName(name="memoryMap") String memoryMap) {
	    try {
		    alphaz.mde.TargetMapping.setMemoryMap( program, system, varList,  memoryMap);
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
