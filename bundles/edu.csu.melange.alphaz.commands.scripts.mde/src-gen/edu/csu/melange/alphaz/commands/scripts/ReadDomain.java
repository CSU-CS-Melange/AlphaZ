package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Domain;

public class ReadDomain  {
	private Domain result;
    
	/**
	Reads domain in String and returns a Domain object.
	**/
	public ReadDomain(@IModuleArgumentName(name="paramDomain") Domain paramDomain,
@IModuleArgumentName(name="domain") String domain) {
	    try {
		 result =     alphaz.mde.Calculator.readDomain(paramDomain,domain);
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
	public ReadDomain(@IModuleArgumentName(name="domain") String domain) {
	    try {
		 result =     alphaz.mde.Calculator.readDomain( domain);
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
