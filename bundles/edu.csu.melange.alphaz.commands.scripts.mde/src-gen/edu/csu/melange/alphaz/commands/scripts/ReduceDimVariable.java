package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Program;

public class ReduceDimVariable  {
	private AffineFunction result;
    
	/**
	Use the equalities of the domain of the specified variable in order to reduce its number of dimension.
Perform the corresponding change of basis and return the affine function used in this CoB.
	**/
	public ReduceDimVariable(@IModuleArgumentName(name="prog") Program prog,
@IModuleArgumentName(name="syst") String syst,
@IModuleArgumentName(name="varName") String varName) {
	    try {
		 result =     alphaz.mde.Transformation.reduceDimVariable(prog,syst,varName);
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
