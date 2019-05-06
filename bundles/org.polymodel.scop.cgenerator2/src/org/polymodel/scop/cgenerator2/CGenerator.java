package org.polymodel.scop.cgenerator2;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.polymodel.algebra.IntExpression;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.cgenerator2.template.Xtend2_CGenerator;
import org.polymodel.scop.transformations.ScopNormalizeLoop;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;

/**
 * Contains two sets of methods for ScopRoot and AbstractScopNode for pretty printing Scop model.
 * The modules of Xtend2 code generation can be given as an optional argument.
 * When a Map from statement names to body is given, those statement macros are inlined at code generation time. 
 * 
 * @author yuki
 *
 */
public class CGenerator {
	
	public static CGenerator INSTANCE;
	
	protected Map<String, MacroBodyProvider> macroBody;
	
	protected CGenerator() {
		macroBody = new TreeMap<String, MacroBodyProvider>();
	}
	
	protected CGenerator(Map<String, MacroBodyProvider> macroBody) {
		this.macroBody = macroBody;
	}

	public static String generate(ScopRoot input) {
		return generate(input, null);
	}

	public static String generate(ScopRoot input, Map<String, MacroBodyProvider> macroBody) {
		return generate(null, input, macroBody);
	}
	public static String generate(AbstractModule module, ScopRoot input) {
		return generate(module, input, null);
	}
	public static String generate(AbstractModule module, ScopRoot input, Map<String, MacroBodyProvider> macroBody) {
		//check to make sure no CGenerator running at the same time
		if (INSTANCE != null) {
			throw new RuntimeException("Only one CGenerator can be active at a time.");
		}
		
		if (macroBody != null) {
			INSTANCE = new CGenerator(macroBody);
		} else {
			INSTANCE = new CGenerator();
		}
		
		final Xtend2_CGenerator instance;
		if (module != null) {
			instance = Guice.createInjector(module).getInstance(Xtend2_CGenerator.class);
		} else {
			instance = Guice.createInjector().getInstance(Xtend2_CGenerator.class);
		}
//		System.out.println(ScopPrinter.toString(input));
		String code = instance.generate(ScopNormalizeLoop.normalize(input)).toString();
		
		//unregister current instance
		INSTANCE = null;
		
		return code;
	}

	public static String generate(AbstractScopNode input) {
		return generate(input, null);
	}

	public static String generate(AbstractScopNode input, Map<String, MacroBodyProvider> macroBody) {
		return generate(null, input, macroBody);
	}
	public static String generate(AbstractModule module, AbstractScopNode input) {
		return generate(module, input, null);
	}
	public static String generate(AbstractModule module, AbstractScopNode input, Map<String, MacroBodyProvider> macroBody) {
		//check to make sure no CGenerator running at the same time
		if (INSTANCE != null) {
			throw new RuntimeException("Only one CGenerator can be active at a time.");
		}
		
		if (macroBody != null) {
			INSTANCE = new CGenerator(macroBody);
		} else {
			INSTANCE = new CGenerator();
		}
		
		final Xtend2_CGenerator instance;
		if (module != null) {
			instance = Guice.createInjector(module).getInstance(Xtend2_CGenerator.class);
		} else {
			instance = Guice.createInjector().getInstance(Xtend2_CGenerator.class);
		}
//		System.out.println(ScopPrinter.toString(input));
		String code = instance.generate(ScopNormalizeLoop.normalize(input)).toString();
		
		//unregister current instance
		INSTANCE = null;
		
		return code;
	}
	public static boolean isInlined(String name) {
		if (INSTANCE == null) return false;
		return INSTANCE.macroBody.containsKey(name);
	}
	
	public static String getMacroBody(String name, List<IntExpression> macroParams) {
		return INSTANCE.macroBody.get(name).getBody(macroParams);
	}
}

