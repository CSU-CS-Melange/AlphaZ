package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class InlineAllForce  {
	
    
	/**
	Inline all the possible equations in a system even with self loop dependence once
	**/
	public InlineAllForce(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="systemName") String systemName,
@IModuleArgumentName(name="inlineEq") String inlineEq) {
	    try {
		    alphaz.mde.Transformation.InlineAllForce(program,systemName,inlineEq);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		    //System.out.println("Unexpected Exception");
		    //e.printStackTrace();
		    throw new RuntimeException("Exception to terminate script");
		}
	}//function
	
    

	public void compute(){
		
	}
}//endclass
