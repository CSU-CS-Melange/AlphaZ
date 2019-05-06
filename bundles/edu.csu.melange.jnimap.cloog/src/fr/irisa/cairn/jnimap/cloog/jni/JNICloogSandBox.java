package fr.irisa.cairn.jnimap.cloog.jni;

import fr.irisa.cairn.jnimap.cloog.util.CloogOptionSpecifier;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLContext;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSet;

public class JNICloogSandBox {
//	final static String[] example9 = {
//		"[N,P]-> { [] :  N>0 & P>0}",
//		"[N,P] -> { " + "S2[i,j,k] -> [ss0, s0,s1,s2,s3] : " + "i-P< 0  & i>= 0  & j-N< 0  & j>= 0  & "
//				+ "k-P< 0  & k>= 0  & " + "16ss0+s0=i & " + "i-16 < 16ss0 <= i &  " + "0 <= s0 < 16 & " + "s1=j & "
//				+ "s2=k & " + "s3=1" + "}" };

	final static String[] example9 = {
		"[N,P]-> { [] :  N>0 & P>0}",
		"[N,P] -> { " + "S2[i,j,k] -> [ss0, s0,s1,s2,s3] : " + "i-P< 0  & i>= 0  & j-N< 0  & j>= 0  & "
				+ "k-P< 0  & k>= 0  & " + "ss0=[i/16] & " + "s0=i-16*[i/16] &  " + "0 <= s0 < 16 & " + "s1=j & "
				+ "s2=k & " + "s3=1" + "}" };

	private static void testCloogCall(String[] test) {
		System.out.println("*********************************************");
		JNICloogState state = JNICloogState.malloc();
		JNICloogOptions options = null;
		try {
			options = CloogOptionSpecifier.getDefault().getJNIObject(state);
		} catch (CloogException e) {
			e.printStackTrace();
		}
		options.setF(9);
		options.setL(-1);
		JNIClastRoot root = (JNIClastRoot) JNIClastRoot.fromUnionMap(state, options, test[0], test[1]);
//		JNIClastAssignment root = (JNIClastAssignment)JNIClastRoot.fromUnionMap(state, options, test[0], test[1]);
		root.pprint(options);
		System.out.println(ClastPrettyPrinter.pp(root));
		// ClastRoot clastRoot = JNIClastToModel.adapt((JNIClastRoot) root);
		// assertNotNull("Null ClastStmt", clastRoot);
		// ClastSerializer.saveClast("test", clastRoot, true);
		state.free();
	}

	public static void main(String[] args) {
		testCloogCall(example9);
	}
}
