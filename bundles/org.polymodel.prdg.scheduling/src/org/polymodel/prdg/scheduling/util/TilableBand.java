package org.polymodel.prdg.scheduling.util;


public class TilableBand {

	//number of prefix dimensions including non-ordering dimensions
	public final int prefixDimensions;
	//prefix of ordering dimensions
	public final long[] orderingPrefix;
	public final boolean[] tilableDimensions;
	public final int numTilableDims;
	
	public TilableBand(int prefixDimensions, long[] orderingPrefix, boolean[] tilableDimensions) {
		this.prefixDimensions = prefixDimensions;
		this.orderingPrefix = orderingPrefix;
		this.tilableDimensions = tilableDimensions;
		int num = 0;
		for (boolean b : tilableDimensions) {
			if (b) num++;
		}
		numTilableDims = num;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
	
		sb.append("prefix[");
		sb.append(toStringList(orderingPrefix));
		sb.append("]; tilable[");
		for (int d = 0; d < tilableDimensions.length; d++) {
			if (d > 0) sb.append(",");
			if (d < prefixDimensions) {
				sb.append("-"); 
			} else {
				sb.append(tilableDimensions[d]);
			}
		}
		sb.append("] ("+numTilableDims+")");
		
		return sb.toString();
	}

	/**
	 * Primitive don't work well with generics, so the following two methods are duplicated.
	 * 
	 * @param vec
	 * @return
	 */
	private String toStringList(long[] vec) {
		StringBuffer sb = new StringBuffer();
		
		for (long e : vec) {
			if (sb.length() > 0) sb.append(",");
			sb.append(e);
		}
		return sb.toString();
	}
}
