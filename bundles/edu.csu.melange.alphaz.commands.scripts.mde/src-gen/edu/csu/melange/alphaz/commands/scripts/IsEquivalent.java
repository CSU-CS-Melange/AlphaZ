package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;

public class IsEquivalent  {
	private Boolean result;
    
	/**
	Returns true if the two domains/functions given are equivalent.
	**/
	public IsEquivalent(@IModuleArgumentName(name="domainA") Domain domainA,
@IModuleArgumentName(name="domainB") Domain domainB) {
	    try {
		 result =     alphaz.mde.Calculator.isEquivalent(domainA,domainB);
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
	public IsEquivalent(@IModuleArgumentName(name="funcA") AffineFunction funcA,
@IModuleArgumentName(name="funcB") AffineFunction funcB) {
	    try {
		 result =     alphaz.mde.Calculator.isEquivalent( funcA, funcB);
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
