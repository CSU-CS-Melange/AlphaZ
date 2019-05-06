package org.polymodel.prdg.scheduling.notifications;

import fr.irisa.cairn.graph.observer.INotification;

public abstract class ANotification implements INotification {
	private Object notifier;

	public ANotification(Object notifier) {
		this.notifier = notifier;
	}

	@Override
	public Object getNotifier() {
		return notifier;
	}

}
