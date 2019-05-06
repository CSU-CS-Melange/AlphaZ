package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Program;

public class AlignDimVariable  {
	private AffineFunction result;
    
	/**
	Align the bounding box of the domain of a variable with the point \vec{0}, by using a translation.
Note: might not work if the lower bound is not an affine function
Return the affine function used to perform the translation.
	**/
	public AlignDimVariable(@IModuleArgumentName(name="prog") Program prog,
@IModuleArgumentName(name="syst") String syst,
@IModuleArgumentName(name="varName") String varName) {
	    try {
		 result =     alphaz.mde.Transformation.alignDimVariable(prog,syst,varName);
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
