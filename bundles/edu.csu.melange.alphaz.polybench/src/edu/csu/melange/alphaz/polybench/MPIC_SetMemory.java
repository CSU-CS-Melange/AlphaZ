package edu.csu.melange.alphaz.polybench;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.factory.TargetMappingUserFactory;

public class MPIC_SetMemory {
	public static Program allocateAdi(Program prog) {
		Map<String, String> projections  = new TreeMap<String, String>();
		Map<String, String> modfactors = new TreeMap<String, String>();
	
		//S5 (i0,i1,i2->i0-i1,i2) mod 0
		//S0 (i0,i1,i2->i1,i0) mod 0
		//S3 (i0,i1,i2->) mod 0
		//S7_bound (i0,i1,i2->i1,i0-i2) mod 0
		//S7 (i0,i1,i2->i1,i2) mod 0
		//S6_bound (i0,i1,i2->i1,i0-i2) mod 0
		//S5_bound (i0,i1,i2->i0-i1,i1-i2) mod 0
		//S2 (i0,i1,i2->) mod 0
		//S2_bound (i0,i1,i2->i0-i1,i2) mod 0
		//S6 (i0,i1,i2->i1,i2) mod 0
		//S1 (i0,i1,i2->i1,i0) mod 0
		//S3_bound (i0,i1,i2->i0-i1,i2) mod 0
		//S1_bound (i0,i1,i2->i0-i1,i1-i2) mod 0
		//S4 (i0,i1,i2->i0,i2) mod 0

		projections.put("S0", "(i0,i1,i2->i1,i0)");
		modfactors.put("S0", "0");
		projections.put("S1", "(i0,i1,i2->i1,i0)");
		modfactors.put("S1", "0");
		projections.put("S1_bound", "(i0,i1,i2->i0-i1,i1-i2)");
		modfactors.put("S1_bound", "0");
		projections.put("S2", "(i0,i1,i2->)");
		modfactors.put("S2", "0");
		projections.put("S2_bound", "(i0,i1,i2->i0-i1,i2)");
		modfactors.put("S2_bound", "0");
		projections.put("S3", "(i0,i1,i2->)");
		modfactors.put("S3", "0");
		projections.put("S3_bound", "(i0,i1,i2->i0-i1,i2)");
		modfactors.put("S3_bound", "0");
		projections.put("S4", "(i0,i1,i2->i0,i2)");
		modfactors.put("S4", "0");
		projections.put("S5", "(i0,i1,i2->i0-i1,i2)");
		modfactors.put("S5", "0");
		projections.put("S5_bound", "(i0,i1,i2->i0-i1,i1-i2)");
		modfactors.put("S5_bound", "0");
		projections.put("S6", "(i0,i1,i2->i1,i2)");
		modfactors.put("S6", "0");
		projections.put("S6_bound", "(i0,i1,i2->i1,i0-i2)");
		modfactors.put("S6_bound", "0");
		projections.put("S7", "(i0,i1,i2->i1,i2)");
		modfactors.put("S7", "0");
		projections.put("S7_bound", "(i0,i1,i2->i1,i0-i2)");
		modfactors.put("S7_bound", "0");

		return allocate(prog, projections, modfactors);
	}

	public static Program allocateFdtd_2d(Program prog) {
		Map<String, String> projections  = new TreeMap<String, String>();
		Map<String, String> modfactors = new TreeMap<String, String>();
	
		//S3 (i0,i1,i2->i0-i1,i1-i2) mod 0
		//S2 (i0,i1,i2->i0-i1,i1-i2) mod 0
		//S1 (i0,i1,i2->i0-i1,i1-i2) mod 0
		//S0 (i0,i1,i2->) mod 0

		projections.put("S0", "(i0,i1,i2->)");
		modfactors.put("S0", "0");
		projections.put("S1", "(i0,i1,i2->i0-i1,i1-i2)");
		modfactors.put("S1", "0");
		projections.put("S2", "(i0,i1,i2->i0-i1,i1-i2)");
		modfactors.put("S2", "0");
		projections.put("S3", "(i0,i1,i2->i0-i1,i1-i2)");
		modfactors.put("S3", "0");

		return allocate(prog, projections, modfactors);
	}

	public static Program allocateFdtd_apml(Program prog) {
		Map<String, String> projections  = new TreeMap<String, String>();
		Map<String, String> modfactors = new TreeMap<String, String>();
	
		//skipping S2: no dependence
		//skipping S6: no dependence
		//S13 (i0,i1,i2->i1,i0) mod 0
		//S5 (i0,i1,i2->) mod 0
		//S14 (i0,i1,i2->i1,i0) mod 0
		//S12 (i0,i1,i2->) mod 0
		//S10 (i0,i1,i2->i1,i0) mod 0
		//S3 (i0,i1,i2->) mod 0
		//S8 (i0,i1,i2->) mod 0
		//S9 (i0,i1,i2->) mod 0
		//S1 (i0,i1,i2->) mod 0
		//S11 (i0,i1,i2->i1,i0) mod 0

		projections.put("S1", "(i0,i1,i2->)");
		modfactors.put("S1", "0");
		projections.put("S10", "(i0,i1,i2->i1,i0)");
		modfactors.put("S10", "0");
		projections.put("S11", "(i0,i1,i2->i1,i0)");
		modfactors.put("S11", "0");
		projections.put("S12", "(i0,i1,i2->)");
		modfactors.put("S12", "0");
		projections.put("S13", "(i0,i1,i2->i1,i0)");
		modfactors.put("S13", "0");
		projections.put("S14", "(i0,i1,i2->i1,i0)");
		modfactors.put("S14", "0");
		projections.put("S3", "(i0,i1,i2->)");
		modfactors.put("S3", "0");
		projections.put("S5", "(i0,i1,i2->)");
		modfactors.put("S5", "0");
		projections.put("S8", "(i0,i1,i2->)");
		modfactors.put("S8", "0");
		projections.put("S9", "(i0,i1,i2->)");
		modfactors.put("S9", "0");

		return allocate(prog, projections, modfactors);
	}

	public static Program allocateJacobi_1d_imper(Program prog) {
		Map<String, String> projections  = new TreeMap<String, String>();
		Map<String, String> modfactors = new TreeMap<String, String>();
	
		//S0 (i0,i1->) mod 0
		//S1 (i0,i1->i1-2i0) mod 0
		//S0_bound (i0,i1->) mod 0

		projections.put("S0", "(i0,i1->)");
		modfactors.put("S0", "0");
		projections.put("S0_bound", "(i0,i1->)");
		modfactors.put("S0_bound", "0");
		projections.put("S1", "(i0,i1->i1-2i0)");
		modfactors.put("S1", "0");

		return allocate(prog, projections, modfactors);
	}

	public static Program allocateJacobi_2d_imper(Program prog) {
		Map<String, String> projections  = new TreeMap<String, String>();
		Map<String, String> modfactors = new TreeMap<String, String>();
	
		//S0_bound (i0,i1,i2->) mod 0
		//S0 (i0,i1,i2->) mod 0
		//S1 (i0,i1,i2->i1-2i0,i2-2i0) mod 0

		projections.put("S0", "(i0,i1,i2->)");
		modfactors.put("S0", "0");
		projections.put("S0_bound", "(i0,i1,i2->)");
		modfactors.put("S0_bound", "0");
		projections.put("S1", "(i0,i1,i2->i1-2i0,i2-2i0)");
		modfactors.put("S1", "0");

		return allocate(prog, projections, modfactors);
	}

	public static Program allocateSeidel_2d(Program prog) {
		Map<String, String> projections  = new TreeMap<String, String>();
		Map<String, String> modfactors = new TreeMap<String, String>();
	
		//S0 (i0,i1,i2->i0-i1,i2-2i1) mod 0

		projections.put("S0", "(i0,i1,i2->i0-i1,i2-2i1)");
		modfactors.put("S0", "0");

		return allocate(prog, projections, modfactors);
	}
	
	private static Program allocate(Program prog, Map<String, String> projections, Map<String, String> modFactors) {
		
		assert(prog.getSystems().size() == 1);
		AffineSystem system = prog.getSystems().get(0);
		
		for (String var : projections.keySet()) {
			String proj = projections.get(var);
			String mod = modFactors.get(var);
			AffineFunction projFunc = PolyhedralIRUtility.parseAffineFunction(system.getParameters(), proj);
			List<IntExpression> modFactor = null;
			if (mod != null && Integer.parseInt(mod) != 0) {
				modFactor = new ArrayList<IntExpression>(projFunc.getDimRHS());
				modFactor.add(IntExpressionBuilder.constant(Integer.parseInt(mod)));
				for (int i = 1; i < projFunc.getDimRHS(); i++) {
					modFactor.add(IntExpressionBuilder.constant(0));
				}
			}
			
			TargetMappingUserFactory.createMemoryMap(system.getVariableDeclaration(var), projFunc, modFactor, 
					system.getTargetMapping().getMemorySpace(var));
		}
		
		return prog;
	}


}
