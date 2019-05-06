package fr.irisa.cairn.jnimap.isl.jni.memorylayout;

import java.util.ArrayList;
import java.util.List;

import fr.irisa.cairn.jnimap.isl.jni.ISLFactory;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLDimType;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSet;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSpace;

/**
 * @deprecated : use {@link ISLMemoryLayoutTools}
 */
@Deprecated
public class ISLArrayContractTools {
	
	private static final boolean VERBOSE = false;
	private static void debug(String string) {
		if(VERBOSE)
			System.out.println(string);
		
	}


	public static JNIISLMap buildDeltaMap(JNIISLMap CS) {
		List<String> params= CS.getSpace().getNameList(JNIISLDimType.isl_dim_param);
		List<String> in = CS.getSpace().getNameList(JNIISLDimType.isl_dim_in);
		List<String> out = CS.getSpace().getNameList(JNIISLDimType.isl_dim_out);
		List<String> inout = new ArrayList<String>(in);
		inout.addAll(out);
		if(in.size()!=out.size()) throw new UnsupportedOperationException("CS "+CS+" shoudl have an even dnumer of dimension");
		String res="";
		res +=params+"-> { ";
		
		res +="[";
		for (int i = 0; i < in.size(); i++) {
			if(i!=0) res += " , ";
			res +=in.get(i);
		}
		res +=",";
		for (int i = 0; i < in.size(); i++) {
			if(i!=0) res += " , ";
			res +=in.get(i)+"'";
		}
		res += "] -> [";
		for (int i = 0; i < in.size(); i++) {
			if(i!=0) res += " , ";
			res +="d"+i;
		}
		res += "] : ";

		
		
		for (int i = 0; i < in.size(); i++) {
			if(i!=0) res += " & ";
			res +="d"+i +"=" +in.get(i)+"-"+out.get(i)+"'";
		}
		res +="}";
		System.out.println(res);
		return ISLFactory.islMap(res);
	}

	
	public static JNIISLSet buildDSSet(JNIISLMap readMap,JNIISLMap writeMap) {

		
		JNIISLSpace space = readMap.copy().getDomain().getSpace();
		JNIISLMap lexLT = JNIISLMap.lexLT(space.copy());
		JNIISLMap lexLE = JNIISLMap.lexLE(space.copy());
		JNIISLMap lexGE = JNIISLMap.lexGE(space.copy());

		/* Relation that maps a write at (i,j,k) to addr to all (i',j',k') in the 
		   domain that read to the same memory location */
		JNIISLMap reverse = readMap.copy().reverse();
		JNIISLMap writeToReadMap = JNIISLMap.applyRange(writeMap.copy(), reverse.copy());

		/* Relation that maps a write at (i,j,k) to addr to all points (i',j',k') in the 
		   domain that precede a read to the same memory location */
		writeToReadMap = JNIISLMap.applyRange(writeToReadMap.copy(), lexLE.copy());

		/* Refine the relation to keep only the points (i',j',k') that are performed after 
		 * the write (i,j,k) according to lexicographical order */
		JNIISLMap useMap =JNIISLMap.intersect(writeToReadMap.copy(),lexGE.copy());
		
		/* Relation that maps a write at (i,j,k) to addr to all (i',j',k') in the 
		   domain that write to the same memory location */
		JNIISLMap writeMapreverse = writeMap.copy().reverse();
		JNIISLMap redefmap = JNIISLMap.applyRange(writeMap.copy(), writeMapreverse);
		/* Refine the relation to keep only the writes (i',j',k') that are performed after 
		 * the write (i,j,k) according to lexicographical order */
		redefmap =JNIISLMap.intersect(redefmap.copy(),lexLT.copy());
		
		/* Find in the first write (i',j',k') @ addr addr occurring after write at (i,j,k) @addr according 
		 * to lexicographical order  */
		JNIISLMap nextWrite = redefmap.copy().lexMin();
		JNIISLMap liverange = null;
		if (!nextWrite.isEmpty()) {
			JNIISLSet subset = useMap.copy().getDomain().subtract(nextWrite.copy().getDomain());
			useMap= useMap.copy().intersectDomain(subset);
			/* Builds the relation that contains all the points in the domain that are lexicographically between 
			 * these a write(i,j,k) at addr and its first subsequent write according to lexicographical order  */
			nextWrite = nextWrite.applyRange(lexGE.copy());
			nextWrite = JNIISLMap.intersect(nextWrite.copy(),lexLT.copy()).simplify();

			
			/* Builds the relation that maps a write (i,j,k) to all the reads (i',j',k') that will read 
			 * the value produced at (i,j,k). This relation is the *live range* of a value, and corresponds 
			 * to the conflict set */
			liverange = JNIISLMap.union(useMap.copy(), nextWrite.copy());
		} else {
			liverange = useMap.copy();
		}
		liverange = liverange.intersectRange(readMap.copy().getDomain());
		JNIISLMap conflict =liverange.copy();
		

		conflict = JNIISLMap.union(conflict.copy(), conflict.copy().reverse());
		debug("Conflict Set "+conflict);

		// FIXME : the flatten/warps looses domain information
		JNIISLSet wrap = conflict.copy().wrap();
		JNIISLSet DS = wrap.flatten();
		
		JNIISLMap deltaMap = ISLArrayContractTools.buildDeltaMap(conflict);
		DS = DS.copy().apply(deltaMap.copy());
		debug("DS="+DS.copy());
		
		return DS;
	}
	


}
