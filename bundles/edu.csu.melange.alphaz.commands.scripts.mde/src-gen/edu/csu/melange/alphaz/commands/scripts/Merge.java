package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class Merge  {
	
    
	/**
	Merge two variables (of name var1Name and var2Name) into a single one.
These variables must both be locals and must have disjoint domains. The name of the merge of these two variables is "newName".
	**/
	public Merge(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="systemName") String systemName,
@IModuleArgumentName(name="var1Name") String var1Name,
@IModuleArgumentName(name="var2Name") String var2Name,
@IModuleArgumentName(name="newName") String newName) {
	    try {
		    alphaz.mde.Transformation.Merge(program,systemName,var1Name,var2Name,newName);
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
