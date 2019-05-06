package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class SetOrderingDimensions  {
	
    
	/**
	specify which dimension is the ordering dimension for each level of the targetMapping. Dimension starts with zero. If no value is specified for the targetMapping level, it is the first level by default. 
	**/
	public SetOrderingDimensions(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="level") int level,
@IModuleArgumentName(name="dims") String dims) {
	    try {
		    alphaz.mde.TargetMapping.setOrderingDimensions(program,system,level,dims);
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
	public SetOrderingDimensions(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="level") int level, @IModuleArgumentName(name="dim") int dim) {
	    try {
		    alphaz.mde.TargetMapping.setOrderingDimensions( program, system, level,  dim);
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
	public SetOrderingDimensions(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="dims") String dims) {
	    try {
		    alphaz.mde.TargetMapping.setOrderingDimensions( program, system, dims);
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
	public SetOrderingDimensions(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system, @IModuleArgumentName(name="dim") int dim) {
	    try {
		    alphaz.mde.TargetMapping.setOrderingDimensions( program, system,  dim);
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
