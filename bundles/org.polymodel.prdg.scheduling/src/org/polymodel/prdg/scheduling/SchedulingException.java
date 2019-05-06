package org.polymodel.prdg.scheduling;

public class SchedulingException extends Exception {
	private Dependency dependency;
	private static final long serialVersionUID = 6361155402615386899L;


	public SchedulingException(String arg0) {
		super(arg0);
	}
	
	public SchedulingException(Dependency d) {
		super("Unable to build a legal schedule domain for "+d);
		this.dependency=d;
	}

	public Dependency getDependency() {
		return dependency;
	}



}
