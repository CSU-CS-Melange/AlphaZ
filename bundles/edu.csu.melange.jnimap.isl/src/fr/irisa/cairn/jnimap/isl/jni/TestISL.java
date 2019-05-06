package fr.irisa.cairn.jnimap.isl.jni;

import static fr.irisa.cairn.jnimap.isl.jni.ISLFactory.islSet;
import static fr.irisa.cairn.jnimap.isl.jni.ISLFactory.islUnionMap;
import fr.irisa.cairn.jnimap.runtime.JNIObject;

/**
 * Simply create an isl_set and print it. Make sure bindings are present and
 * working.
 */
public class TestISL extends JNIObject {
	protected TestISL(long ptr) {
		super(ptr);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		testPbWrap();
//		testPrint2();
//		testISLVal();
//		testISLOthers();
//		JNIISLContext.realloc();
//
//		JNIISLSet set = islSet("[]-> { [i] : 0 <= i <= 5  && (exists a: 4a = i)}").coalesce();
//		System.out.println(set);
//		System.out.println(set.getPoints());
//		
//		String s = "{ [i] : exists (e0 = floor((i)/4): 4e0 = i and i >= 0 and i <= 5) }";
//		JNIISLSet set2 = islSet(s).coalesce();
//		System.out.println(set2);
//		System.out.println(set2.getPoints());
//		
//		System.out.println(set.isEqual(set2));
		
		JNIISLSet set = ISLFactory.islSet("[N,N']->{ :N>0 and N'>0}");
		System.out.println(set.getParametersNames());
		
		
	}
	
	private static void testISLVal() {
		JNIISLVal val = JNIISLVal.buildRationalValue(JNIISLContext.getCtx(), 2, 7);
		
		System.out.println(val);

	}
	private static void testPbWrap () {
		JNIISLUnionMap umap =  islUnionMap( " { S0[P_j, P_i, i, j] -> [o0 = 0, o1 = P_j, o2 = 0, o3 = P_i, o4 = 0, o5 = i, o6 = 0, o7 = j, o8 = 0] : 0 <= P_j <= 3 and 0 <= P_i <= 1 and i >= 32P_j and 0 <= i <= 99 and i <= 32 + 32P_j and j > 32P_i and 0 < j <= 48 and j <= 31 + 32P_i; S1[P_j, P_i, i, j] -> [o0 = 0, o1 = P_j, o2 = 0, o3 = P_i, o4 = 1, o5 = i, o6 = 0, o7 = j, o8 = 0] : 0 <= P_j <= 3 and 0 <= P_i <= 1 and i > 32P_j and 0 < i <= 98 and i <= 31 + 32P_j and j > 32P_i and 0 < j <= 48 and j <= 31 + 32P_i };");
		
		JNIISLSet context = islSet("[] -> {:}");
		JNIISLASTBuild build = JNIISLASTBuild.buildFromContext(context);
		JNIISLASTNode root = JNIISLASTNode.buildFromSchedule(build, umap);
		if (root.isJNIISLASTForNode()) {
//			JNIISLASTExpression ite = (new JNIISLASTForNode(root.nativePtr)).getIterator();
			JNIISLASTExpression inc = (new JNIISLASTForNode(getNativePtr(root))).getInc();
			
			System.out.println(inc.isJNIISLASTLiteral());
		}
		System.out.println(root);
	}
	private static void testISLOthers() {
		//JNIISLSet context = islSet("[M,N]-> { : M>=1 & N >= 1 }");
		JNIISLSet context = islSet("[N, M] -> {  : M >= 5 }");
		
		JNIISLSet set = islSet("[M,N]-> { [i,j] : 0 <= i < M & 0 <= j< N & i = j }");

		JNIISLSet copy = set.copy();
		System.out.println("lexmin = "+copy.testttt());
		
		System.out.println(set);
		System.out.println(set.toString(ISL_FORMAT.POLYLIB));

		//Constraint("[n] -> { [i_outer, i_inner_outer, i_inner_inner] : exists (e0 = [(i_inner_inner)/256]: 256e0 <= i_inner_inner and 256e0 >= -255 + i_inner_inner and 1024i_outer >= -2048 + n) }")

	//	JNIISLUnionMap umap =  islUnionMap( "[N,M] -> { A[i,j] -> [i,j] : 0 <= i <= N and 0 <= j <= M }");
		JNIISLUnionMap umap =  islUnionMap( "[N, M] -> { " +
				"S0[in_i,in_j] -> S0[out_c1,out_c2] : (in_j >= 0) and (-1 + M + -1*in_j >= 0) and (-1 + in_i >= 0) and (-2 + N + -1*in_i >= 0) and (-1*in_j + out_c2 = 0) and (-1*in_i + out_c1 = 0); " +
				"S1[in_i,in_j] -> S1[out_c1,out_c2] : (-1 + in_j >= 0) and (-2 + M + -1*in_j >= 0) and (-1 + in_i >= 0) and (-2 + N + -1*in_i >= 0) and (-2 + -1*in_j + out_c2 = 0) and (-1*in_i + out_c1 = 0); " +
				"}");

		JNIISLASTBuild build = JNIISLASTBuild.buildFromContext(context);
		JNIISLASTNode root = JNIISLASTNode.buildFromSchedule(build, umap);
		if (root.isJNIISLASTForNode()) {
//			JNIISLASTExpression ite = (new JNIISLASTForNode(root.nativePtr)).getIterator();
			JNIISLASTExpression inc = (new JNIISLASTForNode(getNativePtr(root))).getInc();
			
			System.out.println(inc.isJNIISLASTLiteral());
		}
		System.out.println(root);
		
	}

	public static void testPrint2() {
		JNIISLContext.recordStdoutStart();
		JNIISLContext.recordStderrStart();
		try {
		JNIISLSet map = ISLFactory.islSet("[N] -> { [i,j] -> [i',j'] : idfsfd}");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String out = JNIISLContext.recordStdoutEnd();
		String err = JNIISLContext.recordStderrEnd();
		System.out.println(out);
		System.out.println(err);
		JNIISLSet map = ISLFactory.islSet("[N] -> { [i,j] -> [i',j'] : afad}");
	}

}
