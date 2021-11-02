package edu.csu.melange.alphaz.polybench;

import java.util.List;

import org.junit.Test;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.transformation.Normalize;
import org.polymodel.polyhedralIR.transformation.UniformizeInContext;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.scheduling.ScheduledStatement;

public class ADI {

	private static final String ADI_PATH = "./alphabets/alphaz-variants/stencils/adi/";
	private static final String systemName = "adi";
	
	
	public static void main (String[] args) {
		
//		ADI adi = new ADI();
//		
//		adi.ADImodCoB();
	}

	private void genericCoB(String input, String V1, String V2, String output) {
		Program prog = alphaz.mde.Basic.ReadAlphabets(ADI_PATH + "/" + input);
		
		alphaz.mde.Transformation.CoB(prog, systemName, V1, "(t,i1,i2->t,i1,n-i2-2)");
		alphaz.mde.Transformation.CoB(prog, systemName, V2, "(t,i1,i2->t,n-i1-2,i2)");
		
		Normalize.normalize(prog);
		UniformizeInContext.apply(prog);
		
		alphaz.mde.Basic.ASave(prog, ADI_PATH + "/" + output);
		alphaz.mde.Analysis.CheckProgram(prog);

	}
	
	private void genericSchedule(String input, String output) {
		Program prog = alphaz.mde.Basic.ReadAlphabets(ADI_PATH + "/" + input);
		
		PRDG prdg = alphaz.mde.Analysis.BuildPRDG(prog, systemName);
		List<ScheduledStatement> schedules = alphaz.mde.Analysis.PlutoScheduler(prdg);
		alphaz.mde.TargetMapping.setSchedule(prog, systemName, schedules);
		alphaz.mde.Transformation.ApplySTMap(prog, systemName);

		Normalize.normalize(prog);
		
		UniformizeInContext.apply(prog);

		alphaz.mde.Basic.ASave(prog, ADI_PATH + "/" + output);
	}

	@Test
	public void ADICoB() {
		genericCoB("adi.ab", "S3", "S7", "adi.cobed.ab");
		

		Program prog = alphaz.mde.Basic.ReadAlphabets(ADI_PATH + "/" + "adi.cobed.ab");
		
		alphaz.mde.Transformation.CoB(prog, systemName, "S2", "(t,i1->t,i1,n-1)");
		alphaz.mde.Transformation.CoB(prog, systemName, "S6", "(t,i2->t,n-1,i2)");
		
		Normalize.normalize(prog);
		UniformizeInContext.apply(prog);
		
		alphaz.mde.Basic.ASave(prog, ADI_PATH + "/" + "adi.cobed.ab");
		alphaz.mde.Analysis.CheckProgram(prog);
	}
	
	@Test
	public void ADIScheduleCoBed() {
		genericSchedule("adi.cobed.ab", "adi.cobed.scheduled.ab");

//		S0 (t,i1,i2->t,i1,i2,2)
//		S1 (t,i1,i2->t,i1,i2,0)
//		S2 (i0,i1,i2->i0,i1,i2,4)
//		S3 (i0,i1,i2->i0,i1,i2,3)
//		S4 (t,i1,i2->t,i1,i2,5)
//		S5 (t,i1,i2->t,i1,i2,1)
//		S6 (i0,i1,i2->i0,i1,i2,7)
//		S7 (i0,i1,i2->i0,i1,i2,6)

	}

	@Test
	public void ADICodeGenWriteC() {
		Program prog = alphaz.mde.Basic.ReadAlphabets(ADI_PATH + "/adi.ab");
		alphaz.mde.Analysis.CheckProgram(prog);
		
		final String outDir = "./test-out/ADIwriteC/";
		
		
		alphaz.mde.CodeGen.generateMakefile(prog, systemName, outDir);
		alphaz.mde.CodeGen.generateWrapper(prog, systemName, outDir);
		alphaz.mde.CodeGen.generateWriteC(prog, systemName, outDir);
	}


	@Test
	public void ADICodeGenUOV() {
		Program prog = alphaz.mde.Basic.ReadAlphabets(ADI_PATH + "/adi.cobed.ab");
		
		final String outDir = "./test-out/ADImemFix/";
		
		CodeGenOptions options = alphaz.mde.CodeGen.createTiledCGOptionForScheduledC();

//		alphaz.mde.TargetMapping.setTiling(prog, systemName, "omp");
		alphaz.mde.TargetMapping.setStatementOrdering(prog, systemName, "S1", "S5");
		alphaz.mde.TargetMapping.setStatementOrdering(prog, systemName, "S5", "S0");
		alphaz.mde.TargetMapping.setStatementOrdering(prog, systemName, "S0", "S3");
		alphaz.mde.TargetMapping.setStatementOrdering(prog, systemName, "S3", "S2");
		alphaz.mde.TargetMapping.setStatementOrdering(prog, systemName, "S2", "S4");
		alphaz.mde.TargetMapping.setStatementOrdering(prog, systemName, "S4", "S7");
		alphaz.mde.TargetMapping.setStatementOrdering(prog, systemName, "S7", "S6");

		alphaz.mde.TargetMapping.setMemoryMap(prog, systemName, "S0,S2", "X1", "(t,i1,i2->t-i1+n,t-i2+n)");
		alphaz.mde.TargetMapping.setMemoryMap(prog, systemName, "S3", "X2", "(t,i1,i2->t-i1+n,t-i2+n)");
		alphaz.mde.TargetMapping.setMemoryMap(prog, systemName, "S1,S5", "B", "(t,i1,i2->t-i1+n,t-i2+n)");
		alphaz.mde.TargetMapping.setMemoryMap(prog, systemName, "S4,S6", "X1", "(t,i1,i2->t-i1+n,t-i2+n)");
		alphaz.mde.TargetMapping.setMemoryMap(prog, systemName, "S7", "X3", "(t,i1,i2->t-i1+n,t-i2+n)");
		
		alphaz.mde.CodeGen.generateMakefile(prog, systemName, outDir);
		alphaz.mde.CodeGen.generateWrapper(prog, systemName, options, outDir);
		alphaz.mde.CodeGen.generateScheduledCode(prog, systemName, options, outDir);
	}
	@Test
	public void ADICodeGenTimeSkewed() {
		Program prog = alphaz.mde.Basic.ReadAlphabets(ADI_PATH + "/adi.cobed.ab");
		
		final String outDir = "./test-out/ADIskew/";
		
		CodeGenOptions options = alphaz.mde.CodeGen.createTiledCGOptionForScheduledC();

//		alphaz.mde.TargetMapping.setTiling(prog, systemName, "omp");
		alphaz.mde.TargetMapping.setSpaceTimeMap(prog, systemName, "S0,S1,S2,S3,S4,S5,S6,S7", "(t,i,j->t,t+i,t+j)");
		alphaz.mde.TargetMapping.setStatementOrdering(prog, systemName, "S1", "S5");
		alphaz.mde.TargetMapping.setStatementOrdering(prog, systemName, "S5", "S0");
		alphaz.mde.TargetMapping.setStatementOrdering(prog, systemName, "S0", "S3");
		alphaz.mde.TargetMapping.setStatementOrdering(prog, systemName, "S3", "S2");
		alphaz.mde.TargetMapping.setStatementOrdering(prog, systemName, "S2", "S4");
		alphaz.mde.TargetMapping.setStatementOrdering(prog, systemName, "S4", "S7");
		alphaz.mde.TargetMapping.setStatementOrdering(prog, systemName, "S7", "S6");

		alphaz.mde.TargetMapping.setMemoryMap(prog, systemName, "S0,S2", "X1", "(t,i1,i2->i1,i2)");
		alphaz.mde.TargetMapping.setMemoryMap(prog, systemName, "S3", "X2", "(t,i1,i2->i1,i2)");
		alphaz.mde.TargetMapping.setMemoryMap(prog, systemName, "S1,S5", "B", "(t,i1,i2->i1,i2)");
		alphaz.mde.TargetMapping.setMemoryMap(prog, systemName, "S4,S6", "X1", "(t,i1,i2->i1,i2)");
		alphaz.mde.TargetMapping.setMemoryMap(prog, systemName, "S7", "X3", "(t,i1,i2->i1,i2)");
		
		alphaz.mde.CodeGen.generateMakefile(prog, systemName, outDir);
		alphaz.mde.CodeGen.generateWrapper(prog, systemName, options, outDir);
		alphaz.mde.CodeGen.generateScheduledCode(prog, systemName, options, outDir);
	}


	@Test
	public void ADImodCoB() {
		genericCoB("adi-mod.ab", "S2", "S5", "adi-mod.cobed.ab");
	}

	@Test
	public void ADImodSchedule() {
		genericSchedule("adi-mod.ab", "adi-mod.ab");
	}
	
	@Test
	public void ADImodScheduleCoBed() {
		genericSchedule("adi-mod.cobed.ab", "adi-mod.cobed.ab");
		
//		S0 (t,i1,i2->t,i1,i2,1)
//		S1 (t,i1,i2->t,i1,i2,0)
//		S2 (i0,i1,i2->i0,i1,i2,2)
//		S3 (t,i1,i2->t,i1,i2,3)
//		S4 (t,i1,i2->t,i1,i2,4)
//		S5 (i0,i1,i2->i0,i1,i2,5)

	}
	@Test
	public void ADImodCodeGen() {
		Program prog = alphaz.mde.Basic.ReadAlphabets(ADI_PATH + "/adi-mod.cobed.ab");
		
		final String outDir = "./test-out/ADImod/";
		
		CodeGenOptions options = alphaz.mde.CodeGen.createTiledCGOptionForScheduledC();
		TargetMapping tm = prog.getSystem(systemName).getTargetMapping();
//		alphaz.mde.TargetMapping.setTiling(prog, systemName, "omp");
		alphaz.mde.TargetMapping.setStatementOrdering(prog, systemName, "S1", "S0");
		alphaz.mde.TargetMapping.setStatementOrdering(prog, systemName, "S0", "S2");
		alphaz.mde.TargetMapping.setStatementOrdering(prog, systemName, "S2", "S3");
		alphaz.mde.TargetMapping.setStatementOrdering(prog, systemName, "S3", "S4");
		alphaz.mde.TargetMapping.setStatementOrdering(prog, systemName, "S4", "S5");
		
		
		alphaz.mde.CodeGen.generateMakefile(prog, systemName, outDir);
		alphaz.mde.CodeGen.generateWrapper(prog, systemName, options, outDir);
		alphaz.mde.CodeGen.generateScheduledCode(prog, systemName, options, outDir);
	}

	@Test
	public void ADIHandSchedule() {
		Program prog = alphaz.mde.Basic.ReadAlphabets(ADI_PATH+"adiEqn.ab");
		
		alphaz.mde.Analysis.CheckProgram(prog);

		alphaz.mde.Transformation.Inline(prog, systemName, "X2", "X1");
		alphaz.mde.Transformation.Inline(prog, systemName, "X1A", "X1");
		alphaz.mde.Transformation.Inline(prog, systemName, "X1A", "X3");
		alphaz.mde.Transformation.Inline(prog, systemName, "X3A", "X3");
		alphaz.mde.Transformation.Inline(prog, systemName, "X3A", "X1");
		alphaz.mde.Transformation.Inline(prog, systemName, "X4", "X3");
		
		Normalize.normalize(prog);
		UniformizeInContext.apply(prog);
		alphaz.mde.Basic.RemoveUnusedVariables(prog);
		
		alphaz.mde.Basic.ASave(prog, ADI_PATH+"adiEqn.inlined.ab");

		alphaz.mde.Transformation.CoB(prog, systemName, "X1B", "(t,i->t,i,N-1)");
		alphaz.mde.Transformation.CoB(prog, systemName, "X3B", "(t,j->t,N-1,j)");
		
		Normalize.normalize(prog);
		UniformizeInContext.apply(prog);
		
		alphaz.mde.Basic.ASave(prog, ADI_PATH+"adiEqn.cobed.ab");

		PRDG prdg = alphaz.mde.Analysis.BuildPRDG(prog, systemName);
		List<ScheduledStatement> schedules = alphaz.mde.Analysis.PlutoScheduler(prdg);
		alphaz.mde.TargetMapping.setSchedule(prog, systemName, schedules);
		alphaz.mde.Transformation.ApplySTMap(prog, systemName);

		Normalize.normalize(prog);
		
		UniformizeInContext.apply(prog);
		alphaz.mde.Basic.ASave(prog, ADI_PATH+"adiEqn.scheduled.ab");
		
		
//		X1A (t,i,j->t,i,j,0)
//		B1 (t,i,j->t,i,j,1)
//		X1B (t,i,j->t,i,j,2)
//		X2 (t,i,j->t,i,j,3)
//		Xout (i,j->T,i,j,4)
//		X3A (t,i,j->t,i,j,5)
//		B2 (t,i,j->t,i,j,6)
//		X3B (t,i,j->t,i,j,7)
//		X4 (t,i,j->t,i,j,8)
	}
	@Test
	public void ADIHandCodeGenTimeSkewed() {
		Program prog = alphaz.mde.Basic.ReadAlphabets(ADI_PATH+"adiEqn.cobed.ab");
		
		final String outDir = "./test-out/ADIEqnSkew/";
		
		CodeGenOptions options = alphaz.mde.CodeGen.createTiledCGOptionForScheduledC();

//		alphaz.mde.TargetMapping.setTiling(prog, systemName, "omp");

		alphaz.mde.TargetMapping.setSpaceTimeMap(prog, systemName, "X1A,X1B,X2,X3A,X3B,X4,B1,B2", "(t,i,j->t,t+i,t+j)");
		alphaz.mde.TargetMapping.setSpaceTimeMap(prog, systemName, "Xout", "(i,j->T,T+i,T+j)");
		
		alphaz.mde.TargetMapping.setStatementOrdering(prog, systemName, "X1A", "B1");
		alphaz.mde.TargetMapping.setStatementOrdering(prog, systemName, "B1", "X1B");
		alphaz.mde.TargetMapping.setStatementOrdering(prog, systemName, "X1B", "X2");
		alphaz.mde.TargetMapping.setStatementOrdering(prog, systemName, "X2", "Xout");
		alphaz.mde.TargetMapping.setStatementOrdering(prog, systemName, "Xout", "X3A");
		alphaz.mde.TargetMapping.setStatementOrdering(prog, systemName, "X3A", "B2");
		alphaz.mde.TargetMapping.setStatementOrdering(prog, systemName, "B2", "X3B");
		alphaz.mde.TargetMapping.setStatementOrdering(prog, systemName, "X3B", "X4");
		
		
		

		alphaz.mde.TargetMapping.setMemoryMap(prog, systemName, "X1A,X1B,X3A,X3B", "XA", "(t,i,j->i,j)");
		alphaz.mde.TargetMapping.setMemoryMap(prog, systemName, "X2,X4", "XB", "(t,i,j->i,j)");
		alphaz.mde.TargetMapping.setMemoryMap(prog, systemName, "B1,B2", "B", "(t,i,j->i,j)");
		
		alphaz.mde.CodeGen.generateMakefile(prog, systemName, outDir);
		alphaz.mde.CodeGen.generateWrapper(prog, systemName, options, outDir);
		alphaz.mde.CodeGen.generateScheduledCode(prog, systemName, options, outDir);
		
	}

	@Test
	public void ADIHandCodeGenWriteC() {
		Program prog = alphaz.mde.Basic.ReadAlphabets(ADI_PATH + "/adiEqn.ab");
		
		final String outDir = "./test-out/ADIEqnWriteC/";
		
		
		alphaz.mde.CodeGen.generateMakefile(prog, systemName, outDir);
		alphaz.mde.CodeGen.generateWrapper(prog, systemName, outDir);
		alphaz.mde.CodeGen.generateWriteC(prog, systemName, outDir);
	}

	@Test
	public void normalizeRawADImod() {
		normalizeRawADImodGeneric("");
	}
	@Test
	public void scheduleADImod() {
		scheduleRawADImodGeneric("");
	}

	
	private void normalizeRawADImodGeneric(String ver) {
		Program prog = alphaz.mde.Basic.ReadAlphabets(ADI_PATH + "/adi-mod"+ver+".raw.ab");
		Normalize.DEBUG = true;
		Normalize.normalize(prog);
		UniformizeInContext.apply(prog);
		alphaz.mde.Basic.ASave(prog, ADI_PATH+"adi-mod"+ver+".ab");
	}
	private void scheduleRawADImodGeneric(String ver) {
		Program prog = alphaz.mde.Basic.ReadAlphabets(ADI_PATH + "/adi-mod"+ver+".ab");

		PRDG prdg = alphaz.mde.Analysis.BuildPRDG(prog, systemName);
		List<ScheduledStatement> schedules = alphaz.mde.Analysis.PlutoScheduler(prdg);
		alphaz.mde.TargetMapping.setSchedule(prog, systemName, schedules);
		alphaz.mde.Transformation.ApplySTMap(prog, systemName);

		Normalize.normalize(prog);
		
		UniformizeInContext.apply(prog);
		
		alphaz.mde.Basic.ASave(prog, ADI_PATH+"adi-mod"+ver+".scheduled.ab");
		
	}
	
	
}
