package edu.csu.melange.alphaz.mde.tests.polyIR.analysis;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.DetectTilableBands;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.factory.TargetMappingUserFactory;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap;

import edu.csu.melange.alphaz.mde.tests.TESTCASE;

public class DetectTilableBandsTest {

	@Test
	public void testStencil1D() {
		Program prog = alphaz.mde.Basic.ReadAlphabets(TESTCASE.JACOBI_1D.getFilePath());
		AffineSystem system = prog.getSystem(TESTCASE.JACOBI_1D.systemName);

		detect(system);
	}

	@Test
	public void testStencil1DSkewed() {
		Program prog = alphaz.mde.Basic.ReadAlphabets(TESTCASE.JACOBI_1D.getFilePath());
		AffineSystem system = prog.getSystem(TESTCASE.JACOBI_1D.systemName);

		setSTMap(system, "temp_B", "(t,i->t,t+i,0)");
		setSTMap(system, "B", "(t,i->t,t+i,1)");

		detect(system);
	}
	

	@Test
	public void testStencil1DwithOrdering() {
		Program prog = alphaz.mde.Basic.ReadAlphabets(TESTCASE.JACOBI_1D.getFilePath());
		AffineSystem system = prog.getSystem(TESTCASE.JACOBI_1D.systemName);

		setSTMap(system, "temp_B", "(t,i->t,0,i)");
		setSTMap(system, "B", "(t,i->t,1,i)");
		
		detect(system);
	}


	@Test
	public void testStencil2D() {
		Program prog = alphaz.mde.Basic.ReadAlphabets(TESTCASE.JACOBI_2D.getFilePath());
		AffineSystem system = prog.getSystem(TESTCASE.JACOBI_2D.systemName);
		
		detect(system);
	}

	@Test
	public void testStencil2DSkewed() {
		Program prog = alphaz.mde.Basic.ReadAlphabets(TESTCASE.JACOBI_2D.getFilePath());
		AffineSystem system = prog.getSystem(TESTCASE.JACOBI_2D.systemName);
		
		setSTMap(system, "temp_B", "(t,i,j->t,t+i,t+j)");
		setSTMap(system, "B", "(t,i,j->t,t+i,t+j)");
		
		detect(system);
	}
	
	private void detect(AffineSystem system) {
		System.out.println(DetectTilableBands.detect(system));
	}
	
	
	private void setSTMap(AffineSystem system, String varName, String stMapStr) {
		SpaceTimeLevel stlevel = system.getTargetMapping().getSpaceTimeLevel(0);
		SpaceTimeMap stMap = TargetMappingUserFactory.createStandardEquationSpaceTimeMap(
				system.getVariableDeclaration(varName), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), stMapStr));
		stlevel.getSpaceTimeMaps().put(stMap.getLabel(), stMap);
	}
}
