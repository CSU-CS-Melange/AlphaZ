package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.AffineFunction;

public class Join  {
	private AffineFunction result;
    
	/**
	Returns a function that computes function1@function2.
	**/
	public Join(@IModuleArgumentName(name="function1") AffineFunction function1,
@IModuleArgumentName(name="function2") AffineFunction function2) {
	    try {
		 result =     alphaz.mde.Calculator.join(function1,function2);
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
