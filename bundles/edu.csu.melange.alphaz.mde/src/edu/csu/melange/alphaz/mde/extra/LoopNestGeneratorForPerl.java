package edu.csu.melange.alphaz.mde.extra;

import java.util.HashMap;
import java.util.Map;

import org.polymodel.scop.ScopRoot;

public class LoopNestGeneratorForPerl {
	
	private static final String perlTemplate = "perl::template::pgenerator::generate";

	private static Map<String,String> nameToBody = new HashMap<String,String>();
	
	/**
	 * Optional generator that let you specify mapping from statement numbers to statement names.
	 * 
	 * @param input
	 * @param stmtNames
	 * @return
	 */
	public static String generate(ScopRoot input, Map<String,String> stmtBody) {
		nameToBody = stmtBody;
		
		throw new UnsupportedOperationException("Not yet implemented for Scop");
		
//		List<PostProcessor> pp = new LinkedList<PostProcessor>();
//		pp.add(new CBeautifier());
//		Map<String,String> generated = XpandCodeGenerator.generate(perlTemplate, input, new EPackage[] {ClastPackage.eINSTANCE}, pp);
//
//		return generated.values().iterator().next();
	}
	public static String getStatementBody(String name) {
		if (nameToBody.containsKey(name)) {
			return nameToBody.get(name);
		} else {
			return name;
		}
	}
}