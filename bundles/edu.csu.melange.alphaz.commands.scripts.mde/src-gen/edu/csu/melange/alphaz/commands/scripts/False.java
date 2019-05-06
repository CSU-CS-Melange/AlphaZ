package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;


public class False  {
	private Boolean result;
    
	/**
	Returning false
	**/
	public False() {
	    try {
		 result =     alphaz.mde.Utility.False();
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
