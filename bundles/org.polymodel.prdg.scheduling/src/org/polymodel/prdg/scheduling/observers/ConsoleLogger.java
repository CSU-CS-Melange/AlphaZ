package org.polymodel.prdg.scheduling.observers;

import org.polymodel.prdg.scheduling.Dependency;
import org.polymodel.prdg.scheduling.notifications.EdgeDependenciesNotification;
import org.polymodel.prdg.scheduling.notifications.SchedulePrototypeNotification;
import org.polymodel.prdg.scheduling.notifications.ScheduledStatementNotification;
import org.polymodel.prdg.scheduling.notifications.SchedulingNotification;

public class ConsoleLogger extends ReflexiveObserver{
	private void verbose(int tab, String s){
		System.out.print("\n");
		for (int i = 0; i < tab; i++) {
			System.out.print("\t");
		}
		System.out.print(s);
		
	}
	
	private void verbose(String s){
		verbose(0, s);
	}
	
	public void notify(SchedulePrototypeNotification notif){
		verbose("Schedule prototype for "+notif.getNode().getName()+": "+notif.getPrototype());
	}
	
	
	public void notify(EdgeDependenciesNotification notif){
		verbose("Dependencies for "+notif.getEdge());
		for (Dependency d : notif.getDependencies()) {
			verbose(1,">"+d.getClass().getSimpleName()+" :: "+ d.getTerms(true));
		}
	}
	
	public void notify(SchedulingNotification notif){
		verbose("Scheduling solution is: "+notif.getScheduledDomain());
	}
	
	public void notify(ScheduledStatementNotification notif){
		verbose(1,"> Theta("+notif.getStatement().getStatement().getName()+") =" +
				" "+notif.getStatement().getSchedule());
	}
}
