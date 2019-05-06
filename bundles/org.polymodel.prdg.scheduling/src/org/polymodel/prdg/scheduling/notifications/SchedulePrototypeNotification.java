package org.polymodel.prdg.scheduling.notifications;

import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.scheduling.SchedulePrototype;

public class SchedulePrototypeNotification extends ANotification{
	private SchedulePrototype prototype;
	private PRDGNode node;

	
	public SchedulePrototypeNotification(Object notifier,
			SchedulePrototype prototype, PRDGNode node) {
		super(notifier);
		this.prototype = prototype;
		this.node = node;
	}


	public SchedulePrototype getPrototype() {
		return prototype;
	}


	public PRDGNode getNode() {
		return node;
	}
	
	
}
