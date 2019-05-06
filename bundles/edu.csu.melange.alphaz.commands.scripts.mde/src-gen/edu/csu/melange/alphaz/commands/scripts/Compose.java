package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.AffineFunction;

public class Compose  {
	private AffineFunction result;
    
	/**
	Returns a function, that computes function2@function1.
	**/
	public Compose(@IModuleArgumentName(name="function1") AffineFunction function1,
@IModuleArgumentName(name="function2") AffineFunction function2) {
	    try {
		 result =     alphaz.mde.Calculator.compose(function1,function2);
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
