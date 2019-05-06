package edu.csu.melange.alphaz.mde.tests.polyIR.transformation;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.junit.Test;
import org.polymodel.Function;
import org.polymodel.algebra.Variable;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.matrix.impl.MatrixOperations;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.factory.PolyhedralIRModule;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.transformation.helper.FunctionOperations;

public class FunctionOperationsTest {

	@Test
	public void testDropAffinePart1() {
		testDropAffinePart("{|}", "(i->0)", "(i->0)");
		testDropAffinePart("{N|}", "(i->0)", "(i->0)");
	}

	@Test
	public void testDropAffinePart2() {
		testDropAffinePart("{|}", "(i->i+1)", "(i->i)");
		testDropAffinePart("{N|}", "(i->i+1)", "(i->i)");
	}

	@Test
	public void testDropAffinePart3() {
		testDropAffinePart("{|}", "(i->i, 9)", "(i->i, 9)");
		testDropAffinePart("{N|}", "(i->i, N)", "(i->i, N)");
	}

	@Test
	public void testDropAffinePart4() {
		testDropAffinePart("{|}", "(i->i, i-3)", "(i->i, i)");
		testDropAffinePart("{N|}", "(i->i, N-1)", "(i->i, N)");
	}

	private void testDropAffinePart(String paramDomain, String fStr, String expectedStr) {
		ParameterDomain params = PolyhedralIRUtility.parseParameterDomain(paramDomain);
		AffineFunction f  = PolyhedralIRUtility.parseAffineFunction(params, fStr);
		AffineFunction ex = PolyhedralIRUtility.parseAffineFunction(params, expectedStr);
		
		assert(FunctionOperations.dropAffinePart(f).equivalence(ex));
	}
	
	@Test
	public void testNullspace1() {
		testNullspace("{|}", "(i,j->i,i)", "(i,j->j)");
		testNullspace("{N|N>0}", "(i,j->i,i)", "(i,j->j)");
	}
	
	@Test
	public void testNullspace2() {
		testNullspace("{|}", "(i,j,k->i,j,k)", "(i,j,k->)");
		testNullspace("{N|N>0}", "(i,j,k->i,j,k)", "(i,j,k->)");
	}

	@Test
	public void testNullspace3() {
		testNullspace("{|}", "(i,j,k->i,j,k)", "(i,j,k->)");
		testNullspace("{N|N>0}", "(i,j,k->i,j,k)", "(i,j,k->)");
	}

	@Test
	public void testNullspace4() {
		testNullspace("{|}", "(i,j,k->i,i,k)", "(i,j,k->j)");
		testNullspace("{N|N>0}", "(i,j,k->i,i,k)", "(i,j,k->j)");
	}

	@Test
	public void testNullspace5() {
		testNullspace("{|}", "(i,j->j,j)", "(i,j->i)");
		testNullspace("{N|N>0}", "(i,j->j,j)", "(i,j->i)");
	}
	
	@Test
	public void testNullspaceRaw1() {
		testNullspaceRaw(
			new long[][] {
				new long[] {1,0},
				new long[] {1,0},
			},
			new long[][] {
				new long[] {0},
				new long[] {1},
			}
		);
	}
	

	@Test
	public void testNullspaceRaw4() {
		testNullspaceRaw(
			new long[][] {
				new long[] {1,0,0},
				new long[] {1,0,0},
				new long[] {0,0,1},
			},
			new long[][] {
				new long[] {0},
				new long[] {1},
				new long[] {0},
			}
		);
	}
	
	
	private void testNullspace(String paramStr, String funcStr, String expectedStr) {
		ParameterDomain params = PolyhedralIRUtility.parseParameterDomain(paramStr);
		AffineFunction f = PolyhedralIRUtility.parseAffineFunction(params, funcStr);
		AffineFunction expected = PolyhedralIRUtility.parseAffineFunction(params, expectedStr);
		Function ns = f.getPMmapping().nullspace();
		
		assert(f.getPMmapping().nullspace().equivalence(expected.getPMmapping())) : ns + "!=" + expected.getPMmapping();
	}
	
	private void testNullspaceRaw(long[][] mat, long[][] expected) {
		long[][] ns = MatrixOperations.nullspace(mat);
		assert(MatrixOperations.isEqual(ns, expected));
	}
	
	
	@Test
	public void testComputeRightInverse() {
		
		// TEST 1: f1 : (i,j -> i)
		long[][] matLin1 = {{1, 0}};
		List<Variable> lInd1 = new BasicEList<Variable>();
		lInd1.add(PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE).getDimension(0,"i"));
		lInd1.add(PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE).getDimension(1,"j"));
		
		AffineFunction f1 = FunctionOperations.createAffineFunctionFromMatrix(new long[1][0], matLin1, new long[1],
				new BasicEList<Variable>(), lInd1);
		AffineFunction f1RInv = FunctionOperations.computeRightInverse(f1);
		
		System.out.println("The right inverse of " + f1.toString() + " is : " + f1RInv.toString());
		// => Result: (i0 -> i0,0)
		
		// TEST 2: f2 : (i,j -> i+N)
		long[][] matLin2 = {{1, 0}};
		long[][] matParam2 = {{1}};
		List<Variable> lInd2 = new BasicEList<Variable>();
		lInd2.add(PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE).getDimension(0));
		lInd2.add(PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE).getDimension(1));
		List<Variable> lParam2 = new BasicEList<Variable>();
		lParam2.add(PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE).getParameter(0));
		
		AffineFunction f2 = FunctionOperations.createAffineFunctionFromMatrix(matParam2, matLin2, new long[1],
				lParam2, lInd2);
		AffineFunction f2RInv = FunctionOperations.computeRightInverse(f2);
		
		System.out.println("The right inverse of " + f2.toString() + " is : " + f2RInv.toString());
		// => Result: (i0 -> i0-N,0)
		
		
	}
	
}
