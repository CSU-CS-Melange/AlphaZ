package commandIF.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import commandIF.BasicCommand;
import commandIF.Command;
import commandIF.Input;
import commandIF.Overloading;
import commandIF.SpecializedOverloading;
import commandIF.Type;

public class ImportResolver {
	
	private static Map<Type, String[]> _typeToImports;
	private static final String BASE = "edu.csu.melange.alphaz.mde";
	private static final String POLY_BASE = "org.polymodel.polyhedralIR";
	
	static {
		_typeToImports = new HashMap<Type, String[]>();
		
		for (Type t : commandIF.Type.VALUES) {
			switch (t) {
				case PROGRAM:
					_typeToImports.put(t, new String[]{"org.polymodel.polyhedralIR.Program"});
					break;
				case AFFINE_SYSTEM:
					_typeToImports.put(t, new String[]{"org.polymodel.polyhedralIR.AffineSystem"});
					break;
				case STANDARD_EQUATION:
					_typeToImports.put(t, new String[]{"org.polymodel.polyhedralIR.StandardEquation"});
					break;
				case EXPRESSION:
					_typeToImports.put(t, new String[]{"org.polymodel.polyhedralIR.Expression"});
					break;
				case STRING_LIST:
					_typeToImports.put(t, new String[]{"java.util.List"});
					break;
				case INT_LIST:
					_typeToImports.put(t, new String[]{"java.util.List"});
					break;
				case TARGET_MAPPING:
					_typeToImports.put(t, new String[]{POLY_BASE+".TargetMapping"});
					break;
				case SPACE_TIME_MAP:
					_typeToImports.put(t, new String[]{POLY_BASE+".SpaceTimeMap"});
					break;
				case MEMORY_SPACE:
					_typeToImports.put(t, new String[]{POLY_BASE+".MemorySpace"});
					break;
				case MEMORY_MAP:
					_typeToImports.put(t, new String[]{POLY_BASE+".MemoryMap"});
					break;
				case DIM_TYPE:
					_typeToImports.put(t, new String[]{POLY_BASE+".DIM_TYPE"});
					break;
				case CODE_GEN_OPTIONS:
					_typeToImports.put(t, new String[]{POLY_BASE+".polyIRCG.generator.CodeGenOptions"});
					break;
				case TILED_CODE_GEN_OPTIONS:
					_typeToImports.put(t, new String[]{POLY_BASE+".polyIRCG.generator.TiledCodeGenOptions"});
					break;
				case DOMAIN:
					_typeToImports.put(t, new String[]{POLY_BASE+".Domain"});
					break;
				case PARAMETER_DOMAIN:
					_typeToImports.put(t, new String[]{"org.polymodel.polyhedralIR.ParameterDomain"});
					break;
				case AFFINE_FUNCTION:
					_typeToImports.put(t, new String[]{POLY_BASE+".AffineFunction"});
					break;
				case PRDG:
					_typeToImports.put(t, new String[]{"org.polymodel.prdg.PRDG"});
					break;

				case SCHEDULED_STATEMENT:
					_typeToImports.put(t, new String[]{"org.polymodel.prdg.scheduling.ScheduledStatement"});
					break;
				case SCHEDULED_STATEMENT_LIST:
					_typeToImports.put(t, new String[]{"java.util.List", "org.polymodel.prdg.scheduling.ScheduledStatement"});
					break;
			}
		}
	}

	public static Set<String> resolve(BasicCommand command) {
		Set<String> imports = new TreeSet<String>();
		
		Set<Type> typesUsed = new TreeSet<Type>();
		
		//Collect types used from basic command
		typesUsed.add(command.getOutput());
		for (Input in : command.getInputs()) {
			typesUsed.add(in.getType());
		}
		
		//And all specialized overloadings
		recurseOnOverloads(command, typesUsed);
		
		//Map types to imports
		for (Type t : typesUsed) {
			if (_typeToImports.containsKey(t)) {
				for (String s : _typeToImports.get(t)) {
					imports.add(s);
				}
			}
		}
		
		return imports;
	}
	
	public static void recurseOnOverloads(Command command, Set<Type> typesUsed) {
		for (Overloading ol : command.getOverloads()) {
			if (ol instanceof SpecializedOverloading) {
				for (Input in : ((SpecializedOverloading)ol).getAdditionalInputs()) {
					typesUsed.add(in.getType());
				}
			}
			recurseOnOverloads(ol, typesUsed);
		}
	}
}
