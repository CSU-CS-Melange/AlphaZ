package edu.csu.melange.alphaz.mde.tests.polyIR;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.junit.Test;
import org.polymodel.algebra.Variable;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.factory.PolyhedralIRModule;
import org.polymodel.polyhedralIR.transformation.helper.FunctionOperations;

public class FunctionOperationsTest {
	
	
	@Test
	public void testComputeRightInverse1() {
		
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
	}

	@Test
	public void testComputeRightInverse2() {	
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
