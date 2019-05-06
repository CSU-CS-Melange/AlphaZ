package fr.irisa.cairn.jnimap.isl.jni;

import java.util.Collection;

public class ISLFactory {

	public static final int ISL_FORMAT_ISL=0;
	public static final int ISL_FORMAT_POLYLIB=1;
	public static final int ISL_FORMAT_POLYLIB_CONSTRAINTS=2;
	public static final int ISL_FORMAT_OMEGA=3;
	public static final int ISL_FORMAT_C	=		4;
	public static final int ISL_FORMAT_LATEX=		5;

	public static JNIISLContext getContext() {
		return JNIISLContext.getCtx();
	}
	
	public static JNIISLSet islSet(String setTxt) {
		if (setTxt == null) throw new RuntimeException("Cannot build JNIISLSet from null string.");
		
		return JNIISLTools.recordError(
				()->JNIISLSet.buildFromString(getContext(), setTxt),
				(err)->new ISLErrorException(err, "Cannot build JNIISLSet from " + setTxt + "\nisl error: " + err)
			);
	}

	public static JNIISLUnionMap islUnionMap(String mapTxt) {
		if (mapTxt == null) throw new RuntimeException("Cannot build JNIISLUnionMap from null string.");
		
		return JNIISLTools.recordError(
				()->JNIISLUnionMap.buildFromString(getContext(), mapTxt),
				(err)->new ISLErrorException(err, "Cannot build JNIISLUnionMap from " + mapTxt + "\nisl error: " + err)
			);
	}

	public static JNIISLUnionSet islUnionSet(String setTxt) {
		if (setTxt == null) throw new RuntimeException("Cannot build JNIISLUnionSet from null string.");
		
		return JNIISLTools.recordError(
				()->JNIISLUnionSet.buildFromString(getContext(), setTxt),
				(err)->new ISLErrorException(err, "Cannot build JNIISLUnionSet from " + setTxt + "\nisl error: " + err)
			);
	}

	public static JNIISLBasicSet islBasicSet(String bsetTxt) {
		if (bsetTxt == null) throw new RuntimeException("Cannot build JNIISLBasicSet from null string.");
		
		return JNIISLTools.recordError(
				()->JNIISLBasicSet.buildFromString(getContext(), bsetTxt),
				(err)->new ISLErrorException(err, "Cannot build JNIISLMap from " + bsetTxt + "\nisl error: " + err)
			);
	}

//	public static JNIISLBasicMap islBasicMap(String bsetTxt) {
//		return new JNIISLBasicMap(getContext(), bsetTxt,-1);
//	}

	public static JNIISLMap islMap(String mapStr) {
		if (mapStr == null) throw new RuntimeException("Cannot build JNIISLMap from null string.");

		return JNIISLTools.recordError(
				()->JNIISLMap.buildFromString(getContext(), mapStr),
				(err)->new ISLErrorException(err, "Cannot build JNIISLMap from "+mapStr + "\nisl error: " + err)
			);
		
	}
	
	public static JNIISLBasicMap islBasicMap(String bmapStr) {
		if (bmapStr == null) throw new RuntimeException("Cannot build JNIISLBasicMap from null string.");
		
		return JNIISLTools.recordError(
				()->JNIISLBasicMap.buildFromString(getContext(), bmapStr),
				(err)->new ISLErrorException(err, "Cannot build JNIISLBasicMap from "+bmapStr + "\nisl error: " + err)
			);
	}

	public static JNIISLAff islAff(String affTxt) {
		if (affTxt == null) throw new RuntimeException("Cannot build JNIISLAff from null string.");
		
		return JNIISLTools.recordError(
				()->JNIISLAff.buildFromString(getContext(), affTxt),
				(err)->new ISLErrorException(err, "Cannot build JNIISLAff from "+affTxt + "\nisl error: " + err)
			);
	}
	
	public static JNIISLMultiAff islMultiAff(String multiaffTxt) {
		if (multiaffTxt == null) throw new RuntimeException("Cannot build JNIISLMultiAff from null string.");

		return JNIISLTools.recordError(
				()->JNIISLMultiAff.buildFromString(getContext(), multiaffTxt),
				(err)->new ISLErrorException(err, "Cannot build JNIISLMultiAff from "+multiaffTxt + "\nisl error: " + err)
			);
	}

	public static JNIISLPWQPolynomial islPWQPolynomial(String pwqpStr) {
		if (pwqpStr == null) throw new RuntimeException("Cannot build JNIISLPWQPolynomial from null string.");

		return JNIISLTools.recordError(
				()->JNIISLPWQPolynomial.buildFromString(getContext(), pwqpStr),
				(err)->new ISLErrorException(err, "Cannot build JNIISLPWQPolynomial from "+pwqpStr + "\nisl error: " + err)
			);
	}
	
	public static JNIISLVector islVector(Collection<Integer> values) {
		return JNIISLVector.buildFrom(getContext(), values);
	}

	public static String asString(JNIISLSet set) {
		return JNIISLSet._toString(set, ISL_FORMAT_ISL);
	}
	
	public static String asString(JNIISLMap set) {
		return JNIISLMap._toString(set, ISL_FORMAT_ISL);
	}

	public static String asString(JNIISLBasicSet set) {
		return JNIISLBasicSet._toString(set, ISL_FORMAT_ISL);
	}
	
	public static String asString(JNIISLBasicMap map) {
		return JNIISLBasicMap._toString(map, ISL_FORMAT_ISL);
	}

}
