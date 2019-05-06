package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.prdg.PRDG;

public class BuildPRDG  {
	private PRDG result;
    
	/**
	Constructs a PRDG for the specified AffineSystem. Input variables are excluded from the PRDG default. To override this option, set the optional argument noInput to 0.
	**/
	public BuildPRDG(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="systemName") String systemName,
@IModuleArgumentName(name="noInputs") int noInputs) {
	    try {
		 result =     alphaz.mde.Analysis.BuildPRDG(program,systemName,noInputs);
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
	public BuildPRDG(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="systemName") String systemName) {
	    try {
		 result =     alphaz.mde.Analysis.BuildPRDG( program, systemName);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		    //System.out.println("Unexpected Exception");
		    //e.printStackTrace();
		    throw new RuntimeException("Exception to terminate script");
		}
	}//function
	
    


	public PRDG compute(){
		return result;
	}
}//endclass
