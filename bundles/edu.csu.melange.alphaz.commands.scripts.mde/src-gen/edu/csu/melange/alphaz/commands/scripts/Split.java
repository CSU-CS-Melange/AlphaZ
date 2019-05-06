package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class Split  {
	
    
	/**
	Splits a variable into two, where the domain of two variables are disjoint and union of them is equivalent to the original domain of the variable.
If newName is not given, it creates a variable with prefix "_split" appended to the original name.
	**/
	public Split(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="systemName") String systemName,
@IModuleArgumentName(name="varName") String varName,
@IModuleArgumentName(name="newName") String newName,
@IModuleArgumentName(name="sepDomain") String sepDomain) {
	    try {
		    alphaz.mde.Transformation.Split(program,systemName,varName,newName,sepDomain);
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
	public Split(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="systemName") String systemName,
@IModuleArgumentName(name="varName") String varName,
@IModuleArgumentName(name="sepDomain") String sepDomain) {
	    try {
		    alphaz.mde.Transformation.Split( program, systemName, varName, sepDomain);
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
