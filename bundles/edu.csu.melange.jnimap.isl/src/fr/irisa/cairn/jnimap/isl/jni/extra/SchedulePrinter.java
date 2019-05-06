package fr.irisa.cairn.jnimap.isl.jni.extra;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLSchedule;

public class SchedulePrinter {

	public static int indent;
	public static void printSchedule(JNIISLSchedule schedule) {
		indent = 0;
		System.out.println("*************************");
		System.out.println("Print Schedule : "+schedule);
		System.out.println("Map : "+schedule.getMap());
		System.out.println("*************************");
//Band were removed in ISL 0.19		
//		List<JNIISLBand> bandForest = schedule.getBandForest().asJavaList();
//		for (JNIISLBand band : bandForest) { 
//			printBand(band);
//			
//		}
//		System.out.println("*************************");
	}
}
