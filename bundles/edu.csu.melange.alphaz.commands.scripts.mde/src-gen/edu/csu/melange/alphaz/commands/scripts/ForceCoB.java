package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Program;

public class ForceCoB  {
	
    
	/**
	Force the change of basis even if the CoB is for input/output of a system.
	**/
	public ForceCoB(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="systemName") String systemName,
@IModuleArgumentName(name="targetName") String targetName,
@IModuleArgumentName(name="function") AffineFunction function) {
	    try {
		    alphaz.mde.Transformation.ForceCoB(program,systemName,targetName,function);
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
	public ForceCoB(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="systemName") String systemName,
@IModuleArgumentName(name="targetName") String targetName, @IModuleArgumentName(name="function") String function) {
	    try {
		    alphaz.mde.Transformation.ForceCoB( program, systemName, targetName,  function);
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
