package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.AffineFunction;

public class Inverse  {
	private AffineFunction result;
    
	/**
	Compute the inverse of the give affine function.
	**/
	public Inverse(@IModuleArgumentName(name="function") AffineFunction function) {
	    try {
		 result =     alphaz.mde.Calculator.inverse(function);
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
