package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Domain;

public class Union  {
	private Domain result;
    
	/**
	Returns the union of two domains given.
	**/
	public Union(@IModuleArgumentName(name="domain1") Domain domain1,
@IModuleArgumentName(name="domain2") Domain domain2) {
	    try {
		 result =     alphaz.mde.Calculator.union(domain1,domain2);
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
