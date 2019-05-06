package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Domain;

public class Difference  {
	private Domain result;
    
	/**
	Returns domainA / domainB.
	**/
	public Difference(@IModuleArgumentName(name="domainA") Domain domainA,
@IModuleArgumentName(name="domainB") Domain domainB) {
	    try {
		 result =     alphaz.mde.Calculator.difference(domainA,domainB);
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
