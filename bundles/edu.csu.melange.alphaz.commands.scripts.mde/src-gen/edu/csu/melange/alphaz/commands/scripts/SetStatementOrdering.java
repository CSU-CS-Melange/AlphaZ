package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import org.polymodel.polyhedralIR.Program;

public class SetStatementOrdering  {
	
    
	/**
	Specifies the ordering of the statements (alphabets variables) in the generated code. This is similar to adding an additional ordering dimensions to the last dimension of space-time mapping, and providing ordering information.
AlphaZ provides an alternative to such specification by allowing the user to specify partial orderings between statements.
A total order is deduced at the time of code generation.
	**/
	public SetStatementOrdering(@IModuleArgumentName(name="program") Program program,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="predecessor") String predecessor,
@IModuleArgumentName(name="successor") String successor) {
	    try {
		    alphaz.mde.TargetMapping.setStatementOrdering(program,system,predecessor,successor);
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
