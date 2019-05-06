package edu.csu.melange.alphaz.commands.scripts;
import fr.irisa.r2d2.gecos.framework.IModuleArgumentName;
import java.util.List;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.prdg.scheduling.ScheduledStatement;

public class SetSchedule  {
	
    
	/**
	Applies schedules found by a scheduler (such as Farkas scheduler) to target mapping.
	**/
	public SetSchedule(@IModuleArgumentName(name="prog") Program prog,
@IModuleArgumentName(name="system") String system,
@IModuleArgumentName(name="schedules") List<ScheduledStatement> schedules) {
	    try {
		    alphaz.mde.TargetMapping.setSchedule(prog,system,schedules);
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
