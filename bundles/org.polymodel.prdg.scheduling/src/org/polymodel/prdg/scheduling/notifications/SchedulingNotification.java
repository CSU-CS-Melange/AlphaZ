package org.polymodel.prdg.scheduling.notifications;

import org.polymodel.Domain;

public class SchedulingNotification extends ANotification{
	private Domain scheduledDomain;

	public SchedulingNotification(Object notifier, Domain scheduledDomain) {
		super(notifier);
		this.scheduledDomain = scheduledDomain;
	}

	public Domain getScheduledDomain() {
		return scheduledDomain;
	}
	
	
}
