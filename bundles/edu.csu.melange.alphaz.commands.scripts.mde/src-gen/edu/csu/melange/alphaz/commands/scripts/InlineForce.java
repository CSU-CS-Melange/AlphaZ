package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class InlineForce  {
	
    
	/**
	Force the inline action even if there is a self loop dependence
	**/
	public InlineForce(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="systemName") String systemName,
@IModuleArgumentName(name="targetEq") String targetEq,
@IModuleArgumentName(name="inlineEq") String inlineEq,
@IModuleArgumentName(name="number") int number) {
	    try {
		    alphaz.mde.Transformation.InlineForce(program,systemName,targetEq,inlineEq,number);
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
	public InlineForce(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="systemName") String systemName,
@IModuleArgumentName(name="targetEq") String targetEq,
@IModuleArgumentName(name="inlineEq") String inlineEq) {
	    try {
		    alphaz.mde.Transformation.InlineForce( program, systemName, targetEq, inlineEq);
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
