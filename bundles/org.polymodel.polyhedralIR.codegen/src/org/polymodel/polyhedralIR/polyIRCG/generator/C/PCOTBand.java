package org.polymodel.polyhedralIR.polyIRCG.generator.C;

import java.util.ArrayList;
import java.util.List;

import org.polymodel.scop.dtiler.basic.DTilerWaveFrontTileLoops;
import org.polymodel.scop.dtiler.hierarchy.HierarchyDTilingOptions.HierarchyBandDTilingOptions;

public class PCOTBand {
	private int startDim;
	private int endDim;
	private boolean isParallel;
	
	public PCOTBand(int startDim, int endDim, boolean isParallel) {
		super();
		this.startDim = startDim;
		this.endDim = endDim;
		this.isParallel = isParallel;
	}
	public int getBandStart() {
		return startDim;
	}
	public void setBandStart(int startDim) {
		this.startDim = startDim;
	}
	public int getBandEnd() {
		return endDim;
	}
	public void setBandEnd(int endDim) {
		this.endDim = endDim;
	}
	public boolean isParallel() {
		return isParallel;
	}
	public void setParallel(boolean isParallel) {
		this.isParallel = isParallel;
	}
	
	public static PCOTBand getBand(HierarchyBandDTilingOptions b) {
		PCOTBand band = new PCOTBand(b.getBandStart(), b.getBandEnd(), 
				b.getDTilingOption(1).tileLoopGenerator instanceof DTilerWaveFrontTileLoops);
		
		return band;
	}
	
	public String toString() {
		return "band: " + startDim + "-" + endDim + " : " + isParallel;
	}
	public int size() {
		return endDim-startDim+1;
	}
	
	public List<String> getLoopIterators() {
		List<String> loopIterators = new ArrayList<String>(size());
		
		for (int d=startDim; d<=endDim; d++) {
			loopIterators.add("c"+d);
		}
		
		return loopIterators;
	}
}
