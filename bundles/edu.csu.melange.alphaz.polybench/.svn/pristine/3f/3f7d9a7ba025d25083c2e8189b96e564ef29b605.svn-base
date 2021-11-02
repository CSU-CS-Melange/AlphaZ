package edu.csu.melange.alphaz.polybench.test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.UniformnessCheck;
import org.polymodel.polyhedralIR.analysis.UniformnessResult;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.transformation.ChangeOfBasis;
import org.polymodel.polyhedralIR.transformation.Normalize;
import org.polymodel.polyhedralIR.transformation.UniformizeInContext;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.scheduling.ScheduledStatement;

import edu.csu.melange.alphaz.polybench.PolyBench.POLYBENCH;
import edu.csu.melange.alphaz.polybench.PolyBench.VARIATION;

public class TempDriver {

	@Test
	public void testTemp() {
		Program prog = alphaz.mde.Basic.ReadAlphabets("./temp/temp.ab");
		String systemName = "symm";
		
		alphaz.mde.Analysis.CheckProgram(prog);
	}
	
	@Test
	public void testPRDGdirection() {
		Program prog = alphaz.mde.Basic.ReadAlphabets(POLYBENCH.BICG.getFilePath(VARIATION.FIXED_INLINED));
		String systemName = "bicg";
		
		PRDG prdg = alphaz.mde.Analysis.BuildPRDG(prog, systemName);
		List<ScheduledStatement> schedules = alphaz.mde.Analysis.PlutoScheduler(prdg);
		
		System.out.println(schedules);
	}
	
	@Test
	public void testCorrelationEmbedding() {
		Program prog = alphaz.mde.Basic.ReadAlphabets("./temp/correlationA.ab");
		String systemName = "correlation";
		
		Map<String, String> transforms = new TreeMap<String, String>();
		Map<String, String> compositions = new TreeMap<String, String>();
		
		//listed in order of possible automation
		
		//S13: (i,j,k->i,j,k) -- base 
		//S14: (i,j->i,j,n-1) -- following dependence on S13
		transforms.put("S14", "(i,j->i,j,n-1)");
		//S3: S2 o (j->j,n-1) -- following dependence on S2
		transforms.put("S3a", "(j->j,n-1)");
		compositions.put("S3a", "S2a");
		transforms.put("S3b", "(j->j,n-1)");
		compositions.put("S3b", "S2b");
		//S6: S5 o (j->j,n-1) -- following dependence on S5
		transforms.put("S6a", "(j->j,n-1)");
		compositions.put("S6a", "S5a");
		transforms.put("S6b", "(j->j,n-1)");
		compositions.put("S6b", "S5b");

		//S8: S10 o (j->0,j) -- following dependence from S10; nullspace
		transforms.put("S8a", "(j->0,j)");
		compositions.put("S8a", "S10a");
		transforms.put("S8b", "(j->0,j)");
		compositions.put("S8b", "S10b");
		
		//S9: S10 o (i,j->i,j) -- following dependence from S10; only one dependence makes it easy
		transforms.put("S9a", "(i,j->i,j)");
		compositions.put("S9a", "S10a");
		transforms.put("S9b", "(i,j->i,j)");
		compositions.put("S9b", "S10b");
		
		//S2 and S5 are transitively dependent on S9 and S10
		// S3, S6, S8 in the middle of the transitive relation must be "skipped"
		// skipping can be done because S3, S6, S8 have lower dimensions than S2, S5
		
		//S2: S5 o (j,i->j,i) OR S9 o (j,i->i,j) eventually leads to the same and can be both deduced
		transforms.put("S2a", "(j,i->i,j)");
		compositions.put("S2a", "S9a");
		transforms.put("S2b", "(j,i->i,j)");
		compositions.put("S2b", "S9b");
		//S5: S10 o (j,i->i,j)
		transforms.put("S5a", "(j,i->i,j)");
		compositions.put("S5a", "S10a");
		transforms.put("S5b", "(j,i->i,j)");
		compositions.put("S5b", "S10b");
		
		//S10: (i,j->j,0,i) and (i,j->0,j,i)
		// -- difficult case last dimensions should be i can be deduced from dependences from S13
		transforms.put("S10a", "(i,j->j,0,i)");
		transforms.put("S10b", "(i,j->0,j,i)");
		//Although it does not come into play here, cyclic dependences in compositions may become an issue
		
		embed(prog, systemName, transforms, compositions);
	}
	

	
	@Test
	public void testCorrelationEmbeddingB() {
		Program prog = alphaz.mde.Basic.ReadAlphabets("./temp/correlationB.ab");
		String systemName = "correlation";
		
		Map<String, String> transforms = new TreeMap<String, String>();
		Map<String, String> compositions = new TreeMap<String, String>();

		//listed in order of possible automation
		
		//S13: (i,j,k->i,j,k) -- base 
		//S14: (i,j->i,j,n-1) -- following dependence on S13
		transforms.put("S14", "(i,j->i,j,n-1)");
		//S3: S2 o (j->j,n-1) -- following dependence on S2
		transforms.put("S3", "(j->j,n-1)");
		compositions.put("S3", "S2");
		//S6: S5 o (j->j,n-1) -- following dependence on S5
		transforms.put("S6", "(j->j,n-1)");
		compositions.put("S6", "S5");

		//S8: S10 o (j->0,j) -- following dependence from S10; nullspace
		transforms.put("S8", "(j->0,j)");
		compositions.put("S8", "S10");
		
		//S9: S10 o (i,j->i,j) -- following dependence from S10; only one dependence makes it easy
		transforms.put("S9", "(i,j->i,j)");
		compositions.put("S9", "S10");
		
		//S2 and S5 are transitively dependent on S9 and S10
		// S3, S6, S8 in the middle of the transitive relation must be "skipped"
		// skipping can be done because S3, S6, S8 have lower dimensions than S2, S5
		
		//S2: S5 o (j,i->j,i) OR S9 o (j,i->i,j) eventually leads to the same and can be both deduced
		transforms.put("S2", "(j,i->i,j)");
		compositions.put("S2", "S9");
		//S5: S10 o (j,i->i,j)
		transforms.put("S5", "(j,i->i,j)");
		compositions.put("S5", "S10");
		
		//S10: (i,j->0,j,i) -- difficult case last dimensions should be i can be deduced from dependences from S13
		transforms.put("S10", "(i,j->j,0,i)");
		transforms.put("S10b", "(i,j->0,j,i)");
		
		//Although it does not come into play here, cyclic dependences in compositions may become an issue
		
		embed(prog, systemName, transforms, compositions);
	}


	
	private void embed(Program prog, String systemName, Map<String, String> transformsStr, Map<String, String> compositions) {

		alphaz.mde.Analysis.CheckProgram(prog);
		
		AffineSystem system = prog.getSystem(systemName);
		
		//parse given transforms
		Map<String, AffineFunction> transforms = parseTransforms(system.getParameters(), transformsStr);
		
		//apply CoB
		for (String var : transforms.keySet()) {
			ChangeOfBasis.CoB(system, var, getTransform(var, transforms, compositions));
		}
		Normalize.normalize(system);
		UniformizeInContext.apply(system);
		alphaz.mde.Basic.AShow(prog);

		alphaz.mde.Analysis.CheckProgram(prog);

		UniformnessResult res = UniformnessCheck.apply(system);
		System.out.println(res);
	}
	
	private Map<String, AffineFunction> parseTransforms(ParameterDomain params, Map<String, String> transformsStr) {
		Map<String, AffineFunction> transforms = new TreeMap<String, AffineFunction>();
		
		for (String key : transformsStr.keySet()) {
			transforms.put(key, PolyhedralIRUtility.parseAffineFunction(params, transformsStr.get(key)));
		}
		
		return transforms;
	}
	
	private AffineFunction getTransform(String variable, Map<String, AffineFunction> transforms, Map<String, String> compositions) {
		AffineFunction base = transforms.get(variable);
		assert(base != null) : "Variable: " + variable + " was not given a transform.";
		
		if (compositions.containsKey(variable)) {
			AffineFunction composeWith = getTransform(compositions.get(variable), transforms, compositions);
			return composeWith.compose(base);
		} else {
			return base;
		}
		
	}
}
