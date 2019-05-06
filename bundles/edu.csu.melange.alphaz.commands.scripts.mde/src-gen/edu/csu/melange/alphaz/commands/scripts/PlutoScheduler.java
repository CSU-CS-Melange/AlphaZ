package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import java.util.List;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.scheduling.ScheduledStatement;

public class PlutoScheduler  {
	private List<ScheduledStatement> result;
    
	/**
	Pluto scheduler. Uses implementation in ISL.
	**/
	public PlutoScheduler(@IModuleArgumentName(name="prdg") PRDG prdg) {
	    try {
		 result =     alphaz.mde.Analysis.PlutoScheduler(prdg);
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
