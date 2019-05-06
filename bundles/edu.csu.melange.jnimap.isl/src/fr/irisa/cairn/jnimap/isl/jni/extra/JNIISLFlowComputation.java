 package fr.irisa.cairn.jnimap.isl.jni.extra;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicSet;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLConstraint;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLDimType;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSet;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionSet;

//XXX under construction. We still need to consider read and write accesses 
public class JNIISLFlowComputation {
	
	public static JNIISLUnionSet computeDomainOfProcess(JNIISLUnionMap tile, int processTileLevel, int pid) {
		return computeDomainOfProcess(tile.copy().getRange(), processTileLevel, pid);
	}
	
	public static JNIISLUnionSet computeDomainOfProcess(JNIISLUnionSet domain, int processTileLevel, int pid) {
		JNIISLUnionSet domainSet = JNIISLUnionSet.buildEmpty(domain.copy().getSpace());
		for (JNIISLSet s : domain.getSets() ) {
			JNIISLSet ns = JNIISLSet.buildEmpty(s.getSpace());
			for ( JNIISLBasicSet bs : s.getBasicSets() ) {
				JNIISLConstraint cons = JNIISLConstraint.buildEquality(bs.getSpace());
				cons = cons.setCoefficient(JNIISLDimType.isl_dim_set, processTileLevel, -1);
				cons = cons.setConstant(pid);
				bs = bs.addConstraint(cons.copy());
				ns = ns.union(bs.toSet());
			}
			domainSet = domainSet.addSet(ns);
		}
		domainSet = domainSet.coalesce();
		return domainSet;
	}

	public static JNIISLUnionMap computeFlowOutSet(JNIISLUnionMap tile, JNIISLUnionMap prdg, int processorTileLevel, 
			int sourcePid, int destPid,	int numProcesses) {
			
		/*compute the set of writes at the Source Actor */
		JNIISLUnionSet domainSet =  computeDomainOfProcess(tile.copy(), processorTileLevel, sourcePid);
		JNIISLUnionMap WriteSet = prdg.copy().intersectRange(domainSet.copy());
		
		/* Get the domain of read operation in the Destination Actor */
		JNIISLUnionSet domainRead = computeDomainOfProcess(tile.copy(), processorTileLevel, destPid);
		JNIISLUnionMap readSet = WriteSet.copy().intersectDomain(domainRead.copy());
		
		JNIISLUnionMap flowOut = readSet.copy();
		
		return flowOut;
	}
	
	
	public static JNIISLUnionMap computeFlowInSet(JNIISLUnionMap tile, JNIISLUnionMap prdg, int processorTileLevel, int sourcePid, 
			int destPid, int numProcesses) {
		
		/* Get the domain of read operation in the Destination Actor */
		JNIISLUnionSet domainRead = computeDomainOfProcess(tile.copy(), processorTileLevel, destPid);
		JNIISLUnionMap readSet = prdg.copy().intersectDomain(domainRead.copy());
		
		/*compute the set of writes at the Source Actor */
		JNIISLUnionSet domainSet =  computeDomainOfProcess(tile.copy(), processorTileLevel, sourcePid);
		JNIISLUnionMap WriteSet = prdg.copy().intersectRange(domainSet.copy());
		
		JNIISLUnionMap flowInSet = WriteSet.copy().intersect(readSet.copy());
		
		return flowInSet;
	} 
	
}