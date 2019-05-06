package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class Simplify  {
	
    
	/**
	Simplifies the program in multiple ways. The domains are simplified by simplifyInContext (a.k.a. gist). When the domain of a reduction body is a single point, reduction is removed.
	**/
	public Simplify(@IModuleArgumentName(name="prog") Program prog,
@IModuleArgumentName(name="system") String system) {
	    try {
		    alphaz.mde.Transformation.Simplify(prog,system);
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
	public Simplify(@IModuleArgumentName(name="prog") Program prog) {
	    try {
		    alphaz.mde.Transformation.Simplify( prog);
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
