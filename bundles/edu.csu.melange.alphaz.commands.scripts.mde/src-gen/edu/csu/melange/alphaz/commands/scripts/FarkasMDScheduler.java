package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import java.util.List;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.scheduling.ScheduledStatement;

public class FarkasMDScheduler  {
	private List<ScheduledStatement> result;
    
	/**
	Farkas multi-dimensional scheduler. Uses ISL implementation.
	**/
	public FarkasMDScheduler(@IModuleArgumentName(name="prdg") PRDG prdg) {
	    try {
		 result =     alphaz.mde.Analysis.FarkasMDScheduler(prdg);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		    //System.out.println("Unexpected Exception");
		    //e.printStackTrace();
		    throw new RuntimeException("Exception to terminate script");
		}
	}//function
	
    

	public List<ScheduledStatement> compute(){
		return result;
	}
}//endclass
