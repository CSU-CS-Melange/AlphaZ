package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Program;

public class SetSpaceTimeMap  {
	
    
	/**
	Specifies a space time mapping of a variable at a certain level. By default (when there is no value for level), the space-time map is set up for the first level of targetMapping.
	**/
	public SetSpaceTimeMap(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="level") int level,
@IModuleArgumentName(name="varList") String varList,
@IModuleArgumentName(name="stMap") AffineFunction stMap) {
	    try {
		    alphaz.mde.TargetMapping.setSpaceTimeMap(program,system,level,varList,stMap);
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
	public SetSpaceTimeMap(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="level") int level,
@IModuleArgumentName(name="varList") String varList, @IModuleArgumentName(name="stMap") String stMap) {
	    try {
		    alphaz.mde.TargetMapping.setSpaceTimeMap( program, system, level, varList,  stMap);
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
	public SetSpaceTimeMap(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="varList") String varList, @IModuleArgumentName(name="stMap") String stMap) {
	    try {
		    alphaz.mde.TargetMapping.setSpaceTimeMap( program, system, varList,  stMap);
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
	public SetSpaceTimeMap(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="varList") String varList, @IModuleArgumentName(name="bodySTMap") String bodySTMap,
@IModuleArgumentName(name="initSTMap") String initSTMap) {
	    try {
		    alphaz.mde.TargetMapping.setSpaceTimeMap( program, system, varList,  bodySTMap, initSTMap);
		} catch (Exception e) {
			System.err.println(e.getMessage());
//		    System.out.println("Unexpected Exception");
//		    e.printStackTrace();
		    throw new RuntimeException("Exception to terminate script");
		}
	}//function
	
    

	/**
	TODO : add description (to the model)
	**/
	public SetSpaceTimeMap(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="varList") String varList, @IModuleArgumentName(name="bodySTMap") String bodySTMap,
@IModuleArgumentName(name="initSTMap") String initSTMap,
@IModuleArgumentName(name="intValue") String intValue) {
	    try {
		    alphaz.mde.TargetMapping.setSpaceTimeMap( program, system, varList,  bodySTMap, initSTMap, intValue);
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
