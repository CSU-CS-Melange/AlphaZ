package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;

public class ReadFunction  {
	private AffineFunction result;
    
	/**
	Reads affine function in String and returns an AffineFunction object.
	**/
	public ReadFunction(@IModuleArgumentName(name="paramDomain") Domain paramDomain,
@IModuleArgumentName(name="function") String function) {
	    try {
		 result =     alphaz.mde.Calculator.readFunction(paramDomain,function);
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
	public ReadFunction(@IModuleArgumentName(name="function") String function) {
	    try {
		 result =     alphaz.mde.Calculator.readFunction( function);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		    //System.out.println("Unexpected Exception");
		    //e.printStackTrace();
		    throw new RuntimeException("Exception to terminate script");
		}
	}//function
	
    


	public AffineFunction compute(){
		return result;
	}
}//endclass
