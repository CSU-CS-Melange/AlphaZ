package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;

public class PreImage  {
	private Domain result;
    
	/**
	Compute the pre-image of the given domain by the given function.
	**/
	public PreImage(@IModuleArgumentName(name="function") AffineFunction function,
@IModuleArgumentName(name="domain") Domain domain) {
	    try {
		 result =     alphaz.mde.Calculator.preImage(function,domain);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		    //System.out.println("Unexpected Exception");
		    //e.printStackTrace();
		    throw new RuntimeException("Exception to terminate script");
		}
	}//function
	
    

	public Domain compute(){
		return result;
	}
}//endclass
