package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;

public class InverseInContext  {
	private AffineFunction result;
    
	/**
	Computes inverse of the given affine function, in the context of the given domain.
	**/
	public InverseInContext(@IModuleArgumentName(name="domain") Domain domain,
@IModuleArgumentName(name="function") AffineFunction function) {
	    try {
		 result =     alphaz.mde.Calculator.inverseInContext(domain,function);
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
