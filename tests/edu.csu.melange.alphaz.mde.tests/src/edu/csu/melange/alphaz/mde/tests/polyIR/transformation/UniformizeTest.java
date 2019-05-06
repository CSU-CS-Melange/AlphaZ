package edu.csu.melange.alphaz.mde.tests.polyIR.transformation;

import java.util.List;

import org.junit.Test;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.matrix.Matrix;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.FindUniformizationVector;
import org.polymodel.polyhedralIR.analysis.UniformizationChecks;
import org.polymodel.polyhedralIR.analysis.UniformnessCheck;
import org.polymodel.polyhedralIR.analysis.UniformnessResult;
import org.polymodel.polyhedralIR.factory.PolyhedralIRModule;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.transformation.Uniformize;
import org.polymodel.polyhedralIR.transformation.UniformizeWithPipelining;

public class UniformizeTest {

	@Test
	public void testSimple() {
		Program prog = alphaz.mde.Basic.ReadAlphabets("./alphabets/uniformization/simple.ab");
		final String systemName = "simple";
		AffineSystem system = prog.getSystem(systemName);

		Uniformize.apply(system);
		alphaz.mde.Analysis.CheckProgram(prog);
		System.out.println(prog);
		
		UniformnessResult res = UniformnessCheck.apply(system);
		assert(res.isUniform()) : res.toString();

	}

	@Test
	public void testDiagonal() {
		Uniformize.DEBUG = true;
		UniformizeWithPipelining.DEBUG = true;
		
		Program prog = alphaz.mde.Basic.ReadAlphabets("./alphabets/uniformization/diagonal.ab");
		final String systemName = "diagonal";
		AffineSystem system = prog.getSystem(systemName);

		alphaz.mde.Analysis.CheckProgram(prog);
		Uniformize.apply(system);
		alphaz.mde.Analysis.CheckProgram(prog);
		System.out.println(prog);
		
		UniformnessResult res = UniformnessCheck.apply(system);
		assert(res.isUniform()) : res.toString();

	}
	

	@Test
	public void testNullspaceFailure() {
		Program prog = alphaz.mde.Basic.ReadAlphabets("./alphabets/uniformization/nullspaceFailure.ab");
		final String systemName = "nullspaceFailure";
		AffineSystem system = prog.getSystem(systemName);
		
		AffineFunction uvSpace = FindUniformizationVector.find(system.getEquation("y"));
		System.out.println(uvSpace);
	}

	@Test
	public void testNullspaceFailure2() {
		Program prog = alphaz.mde.Basic.ReadAlphabets("./alphabets/uniformization/nullspaceFailure.ab");
		final String systemName = "nullspaceFailure2";
		AffineSystem system = prog.getSystem(systemName);
		
		AffineFunction uvSpace = FindUniformizationVector.find(system.getEquation("y"));
		System.out.println(uvSpace);
	}
	
	@Test
	public void testIdempotenceCheck() {
		ParameterDomain params = PolyhedralIRUtility.parseParameterDomain("{N|N>0}");
		AffineFunction f = PolyhedralIRUtility.parseAffineFunction(params, "(i,j,k->i-k,k-j,i-j)");
		assert(!UniformizationChecks.checkIdempotence(f));
	}
	
	@Test
	public void testVectorValidity() {
		ParameterDomain params = PolyhedralIRUtility.parseParameterDomain("{N|N>0}");
		AffineFunction f = PolyhedralIRUtility.parseAffineFunction(params, "(i,j->i+j,-i-j)");
		assert(!UniformizationChecks.checkIdempotence(f));
		assert(!UniformizationChecks.isValidUniformizationVector(new int[]{1,-1}, f));
	}

	@Test
	public void testDecomposition() {
		ParameterDomain params = PolyhedralIRUtility.parseParameterDomain("{|}");
		AffineFunction f = PolyhedralIRUtility.parseAffineFunction(params, "(i,j,k->i-k,k-j,i-j)");
		
		PolymodelDefaultFactory fact = PolymodelComponent.INSTANCE.getFactory(PolyhedralIRModule.INSTANCE);
		
		Matrix Q = f.getPMmapping().linearPart();
		Matrix I = fact.createMatrix(3, 3);
		for (int i = 0; i < 3; i++) {
			I.set(i, i, 1);
		}
		
		Matrix E = I.sub(Q);
		
		Matrix E1 = fact.createMatrix(new long[][] {
				new long[]{0,-1,1},
				new long[]{0,1,-1},
				new long[]{0,-1,1}
		});
		Matrix E2 = fact.createMatrix(new long[][] {
				new long[]{0,0,0},
				new long[]{0,0,0},
				new long[]{-1,0,0}
		});
		Matrix E3 = fact.createMatrix(new long[][] {
				new long[]{0,1,0},
				new long[]{0,1,0},
				new long[]{0,2,0}
		});

		System.out.println("E0 = Q");
		System.out.println(Q);
		System.out.println("E1");
		System.out.println(Q.add(E1));
		System.out.println("E2");
		System.out.println(Q.add(E1).add(E2));
		System.out.println("E3");
		System.out.println(Q.add(E1).add(E2).add(E3));
		
		//P -> Q
		//(i,j,k->i-k,k-j,i-j)

		//P = E3 -> E2
		//(i,j,k->i-j,0,k-2j)
		//E2 ->E1
		//(i-j,0,k-2j->i-j,0,i-2j+k)
		   //(x,y,z->x,y,z+x)
		//E1 -> E0 = Q
		//(i-j,0,i-2j+k->i-k,k-j,i-j)
		  //(x,y,z->2x-z,z-x,x)
		

		Matrix test = fact.createMatrix(new long[][] {
				new long[]{1,-1,0},
				new long[]{0,0,0},
				new long[]{1,-2,1}
		});
		
		

		AffineFunction depE2 = PolyhedralIRUtility.parseAffineFunction(params, "(i,j,k->i-j,0,k-2j)");
		AffineFunction depE1 = PolyhedralIRUtility.parseAffineFunction(params, "(i,j,k->i-j,0,i-2j+k)");
		AffineFunction depE0 = PolyhedralIRUtility.parseAffineFunction(params, "(i,j,k->i-k,k-j,i-j)");
		System.out.println(depE1.compose(depE2.inverseInContext(PolyhedralIRUtility.parseDomain("{i,j,k|j==0}"), null)));
		
		AffineFunction d1 = PolyhedralIRUtility.parseAffineFunction(params, "(i,j,k->i-j,0,k-2j)");
		AffineFunction d2 = PolyhedralIRUtility.parseAffineFunction(params, "(x,y,z->x,y,z+x)");
		AffineFunction d3 = PolyhedralIRUtility.parseAffineFunction(params, "(x,y,z->2x-z,z-x,x)");
		System.out.println(UniformizationChecks.getDependenceRank(f));
		System.out.println(UniformizationChecks.getDependenceRank(d1));
		System.out.println(UniformizationChecks.getDependenceRank(d2));
		System.out.println(UniformizationChecks.getDependenceRank(d3));

		System.out.println(E1.sub(Q));
		System.out.println(E1.sub(Q).rowRank());
		
		Matrix U = fact.createMatrix(new long[][] {
				new long[] {1,0,1},
				new long[] {-1,0,1},
				new long[] {1,1,2}
		});
		
		//E = UB
		//B = U^-1E 
		Matrix B = U.inverse().mul(E);
		System.out.println("E = UB");
		System.out.println(E + " = " + U + " x " + B + " = " +B.mul(U));
		
		
		List<Matrix> hnf = B.hermiteNormalForm();
		Matrix H = hnf.get(0);
		Matrix M = hnf.get(1);
		M.set(0, 2, 0);
		M.set(1, 2, 0);
		M.set(2, 2, 0);
		System.out.println(M);
////		//H = mU
////		//HUinv = m
////		//m = HUinv
		System.out.println(E + " = " + U + " x " + H + " x " + M + " = " +U.mul(H).mul(M));
	}
}
