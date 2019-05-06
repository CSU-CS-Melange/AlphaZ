package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Domain;

public class SimplifyInContext  {
	private Domain result;
    
	/**
	Takes domain and context domain, and returns the domain with constraints that are redundant with the context removed.
	**/
	public SimplifyInContext(@IModuleArgumentName(name="domain") Domain domain,
@IModuleArgumentName(name="context") Domain context) {
	    try {
		 result =     alphaz.mde.Calculator.simplifyInContext(domain,context);
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
