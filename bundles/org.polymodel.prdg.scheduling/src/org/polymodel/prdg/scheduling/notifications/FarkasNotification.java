package org.polymodel.prdg.scheduling.notifications;

import org.polymodel.prdg.scheduling.farkas.FarkasDependencyConstraints;

import fr.irisa.cairn.graph.observer.INotification;

public class FarkasNotification implements INotification {
	private Object notifier;
	private FarkasDependencyConstraints farkasDependencyConstraints;
	
	
	public FarkasNotification(Object notifier,
			FarkasDependencyConstraints farkasDependencyConstraints) {
		this.notifier = notifier;
		this.farkasDependencyConstraints = farkasDependencyConstraints;
	}


	public FarkasDependencyConstraints getFarkasDependencyConstraints() {
		return farkasDependencyConstraints;
	}


	@Override
	public Object getNotifier() {
		return notifier;
	}

}
