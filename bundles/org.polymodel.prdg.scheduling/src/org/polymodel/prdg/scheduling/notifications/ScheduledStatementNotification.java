package org.polymodel.prdg.scheduling.notifications;

import org.polymodel.prdg.scheduling.ScheduledStatement;

public class ScheduledStatementNotification extends ANotification {
	private ScheduledStatement statement;

	public ScheduledStatementNotification(Object notifier,
			ScheduledStatement statement) {
		super(notifier);
		this.statement = statement;
	}

	public ScheduledStatement getStatement() {
		return statement;
	}
	
	
}
