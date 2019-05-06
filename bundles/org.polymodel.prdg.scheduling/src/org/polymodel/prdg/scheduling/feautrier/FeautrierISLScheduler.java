package org.polymodel.prdg.scheduling.feautrier;

import org.polymodel.prdg.scheduling.AdvancedISLScheduler;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLSchedule.JNIISLSchedulingOptions;

public class FeautrierISLScheduler extends AdvancedISLScheduler {

	public FeautrierISLScheduler() {
		super();
		options.setAlgorithm(JNIISLSchedulingOptions.ISL_SCHEDULE_ALGORITHM_FEAUTRIER);
	}
	
}
