package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class CreateFreeScheduler  {
	private Program result;
    
	/**
	Takes an alphabetes program and converts it to a program that computes the fastest possible schedule (free shcedule).
This transformation DOES NOT preserve the original semantics, but instead creates a new Program object.

Implemented by Alex Klein as a class project in cs560@spring11
	**/
	public CreateFreeScheduler(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="newProgPrefix") String newProgPrefix) {
	    try {
		 result =     alphaz.mde.Transformation.createFreeScheduler(program,newProgPrefix);
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
	public CreateFreeScheduler(@IModuleArgumentName(name="program") Program program) {
	    try {
		 result =     alphaz.mde.Transformation.createFreeScheduler( program);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		    //System.out.println("Unexpected Exception");
		    //e.printStackTrace();
		    throw new RuntimeException("Exception to terminate script");
		}
	}//function
	
    


	public Program compute(){
		return result;
	}
}//endclass
