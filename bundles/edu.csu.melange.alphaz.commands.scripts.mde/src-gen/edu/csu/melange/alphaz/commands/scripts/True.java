package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;


public class True  {
	private Boolean result;
    
	/**
	Returning true
	**/
	public True() {
	    try {
		 result =     alphaz.mde.Utility.True();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		    //System.out.println("Unexpected Exception");
		    //e.printStackTrace();
		    throw new RuntimeException("Exception to terminate script");
		}
	}//function
	
    

	public Boolean compute(){
		return result;
	}
}//endclass
