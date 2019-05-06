package fr.irisa.cairn.jnimap.isl.jni.extra;

import fr.irisa.cairn.jnimap.isl.jni.ISLFactory;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionMap;

public class TestTiling {
	
	
	public void tileBand() {
		
	//	String plutoScheduleStr = "[N, M, b, omega] -> { S2[i, j] -> [i, j, 2] : j >= 1 and j <= -1 + M and i >= 1 and i <= -1 + N; S1[i, j] -> [i, j, 1] : j >= 1 and j <= -1 + M and i >= 1 and i <= -1 + N; S0[i, j] -> [i, j, 0] : j >= 1 and j <= -1 + M and i >= 1 and i <= -1 + N }";
		String plutoScheduleStr = "[N, M] -> { S0[i, j] -> [i, j] : j >= 1 and j <= -1 + M and i >= 1 and i <= -1 + N }";
		String prdgStr = "[N, M] -> { S0[i, j] -> S0[i-1, j] : (i <= -1 + N and i >= 1 and j >= 10 and j <= -1 + M) ; " +
							"S0[i, j] -> S0[i, j-1] : i <= -1 + N and i >= 1 and j >= 1 and j <= -1 + M; }";
		
		int[] tileSize = {3, 3};
		int numProcessors = 3;
		int outerTileLevel = 0;
		int innerTileLevel = 1;
		JNIISLScheduleTiling.debug = true;
		
		JNIISLUnionMap prdg = ISLFactory.islUnionMap(prdgStr);
		JNIISLUnionMap plutoSchedule = ISLFactory.islUnionMap(plutoScheduleStr);
		
		JNIISLUnionMap tile = JNIISLScheduleTiling.tileBand(plutoSchedule, outerTileLevel, innerTileLevel, tileSize, 2, numProcessors);
		JNIISLUnionMap prdgTransD = prdg.copy().applyDomain(tile.copy());
		JNIISLUnionMap prdgTrans = prdgTransD.copy().applyRange(tile.copy());
		prdgTrans = prdgTrans.coalesce();
		
		for ( int i = 0; i < numProcessors; i++) {
			for ( int j = 0; j < numProcessors; j++ ) {
				JNIISLUnionMap flowIn = JNIISLFlowComputation.computeFlowInSet(tile.copy(), prdgTrans.copy(), outerTileLevel + 1, i, j, numProcessors);
				System.out.println(" flowIn at Processor " + i + ": " + flowIn);
			}
        }
		
		
		for ( int i = 0; i < numProcessors; i++) {
			for ( int j = 0; j < numProcessors; j++ ) {
				JNIISLUnionMap flowOut = JNIISLFlowComputation.computeFlowOutSet(tile.copy(), 
						prdgTrans.copy(), outerTileLevel + 1, i, j, numProcessors);
				System.out.println(" flowOut at Processor " + i + " to " + j + ": " + flowOut);
			}
		}
	}
	
	public static void main(String[] args) {
		TestTiling t = new TestTiling();
		t.tileBand();
	}
	
		
}