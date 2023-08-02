package org.polymodel.polyhedralIR.codegen.xtend2;

import java.util.Map;

import org.polymodel.polyhedralIR.polyIRCG.CompilationUnit;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.modules.ABFTWrapperCModule;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;

/**
 * Entry point for Xtend2 based code gen for PolyIRCG
 * 
 * @author yuki
 *
 */
public class Xtend2CodeGen {
	
	/**
	 * Generates codes for a given compilation unit using default templates.
	 * The returned map is <Filename, Content>
	 * 
	 * @param unit
	 * @return
	 */
	public static Map<String, String> generate(CompilationUnit unit) {
		Xtend2CodeGenTop instance = Guice.createInjector().getInstance(Xtend2CodeGenTop.class);

		return instance.generate(unit);
	}
	
	/**
	 * Generates code for a given compilation unit using custom module.
	 * The returned map is <Filename, Content>
	 * 
	 * @param module
	 * @param unit
	 * @return
	 */
	public static Map<String, String> generate(AbstractModule module, CompilationUnit unit) {
		Xtend2CodeGenTop instance = Guice.createInjector(module).getInstance(Xtend2CodeGenTop.class);

		return instance.generate(unit);
	}
	
}
