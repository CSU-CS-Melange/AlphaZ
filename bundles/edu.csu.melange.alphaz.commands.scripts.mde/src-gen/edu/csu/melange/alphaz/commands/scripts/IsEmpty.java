package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Domain;

public class IsEmpty  {
	private Boolean result;
    
	/**
	Returns true if the domain is empty.
	**/
	public IsEmpty(@IModuleArgumentName(name="domain") Domain domain) {
	    try {
		 result =     alphaz.mde.Calculator.isEmpty(domain);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		    //System.out.println("Unexpected Exception");
		    //e.printStackTrace();
		    throw new RuntimeException("Exception to terminate script");
		}
	}//function
	
    

	public Boolean compute(){
		return result;
	}
}//endclass
