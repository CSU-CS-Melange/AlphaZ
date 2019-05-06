package edu.csu.melange.alphaz.mde.tests.core;

import org.javatuples.Pair;
import org.junit.Test;
import org.polymodel.matrix.MatrixFactory;
import org.polymodel.matrix.impl.MatrixOperations;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;

import alphaz.mde.Calculator;

public class CalculatorTest {

//	public static void main(String[] args) throws IOException {
////		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/paramUnion.ab");
////		System.out.println(program);
//		identityFunction();
//		boundsTest();
//
////		ParameterDomain param = PolyhedralIRUserFactory.eINSTANCE.createParameterDomain("{N|N>0}");
////		Domain dom = PolyhedralIRUserFactory.eINSTANCE.createDomain(param, "{i,j|i==j}");
////		AffineFunction func = PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(param, "(i,j->i)");
////		EList<String> names = new BasicEList<String>();
////		names.add("x");
////		names.add("y");
////		System.out.println(func.getPMmapping().inverseInContext(dom.getPMdomain()));
////		System.out.println(func.getPMmapping().inverse(names));
//	}
	
	@Test
	public void testParsing() {
		parseDomainTest("{N,i,j|0<=(i,j)<N}", "{N,i,j|i>=0 && N-i-1>=0 && j>=0 && N-j-1>=0}");
		parseDomainTest("{N,i,j|0>=i && i < N-j && j>0 && j < N+i}", "{N,i,j|-i>=0 && N-i-j-1>=0 && j-1>=0 && N+i-j-1>=0}");
		
		parseFunctionTest("(i,j->)");
		parseFunctionTest("(i,j->i-j+100)");
		parseFunctionTest("(i,j->j,i)");
	}
	
	private void parseDomainTest(String domStr, String expected) {
		Domain domain = Calculator.readDomain(domStr);
		System.out.println(expected + " == " + domain.toString());
		assert(expected.contentEquals(domain.toString()));
	}
	
	private void parseFunctionTest(String funcStr) {
		AffineFunction func = Calculator.readFunction(funcStr);
		System.out.println(funcStr + " == " + func.toString());
		assert(funcStr.contentEquals(func.toString()));
	}

	@Test
	public void testFunctionEquivalence() {
		functionEquivalenceTest("(i,j->)", "(x,y->)", true);
		functionEquivalenceTest("(i,j->j,i)", "(j,i->j,i)", false);
	}
	
	private void functionEquivalenceTest(String funcAstr, String funcBstr, boolean expected) {
		AffineFunction funcA = Calculator.readFunction(funcAstr);
		AffineFunction funcB = Calculator.readFunction(funcBstr);
		boolean equiv  = funcA.equivalence(funcB);
		System.out.println(equiv + " == " + expected);
		assert(equiv == expected);
	}

	@Test
	public void testCompose() {
		composeTest("(x,y->y,x)", "(i,j->i+j,j)", "(i,j->j,i+j)");
		composeTest("{N,a,b,c,d,e|N>0}", "(x,y->y,x)", "(i,j->i+j,j)", "(i,j->j,i+j)");
	}
	
	private void composeTest(String fAstr, String fBstr, String expectedStr) {
		AffineFunction fA = Calculator.readFunction(fAstr);
		AffineFunction fB = Calculator.readFunction(fBstr);
		AffineFunction fC = fA.compose(fB);
		AffineFunction expected = Calculator.readFunction(expectedStr);
		System.out.println(fC);
		assert(expected.equivalence(fC));
	}
	
	private void composeTest(String paramDomStr, String fAstr, String fBstr, String expectedStr) {
		Domain paramDom = Calculator.readDomain(paramDomStr); 
		AffineFunction fA = Calculator.readFunction(paramDom, fAstr);
		AffineFunction fB = Calculator.readFunction(paramDom, fBstr);
		AffineFunction fC = fA.compose(fB);
		AffineFunction expected = Calculator.readFunction(expectedStr);
		System.out.println(fC);
		assert(expected.equivalence(fC));
	}

	@Test
	public void testInverseInContext() {
		inverseInContextTest("{N|}", "(i,j->j,i)", "{i,j|}", "(a,b->b,a)");
		inverseInContextTest("{N|}", "(i,j->i)", "{i,j|j==0}", "(a->a,0)");
		//inverseInContextTest("{N|}", "(i,j->0,i0,j)", "{i0,i1,i2|i0==0 && i1>=0 && -i1+N-1>=0 && i2>=0 && -i2+N-1>=0 && N-1>=0}", "(i0,i1,i2->i1,i2)");
	}
	
	private void inverseInContextTest(String paramStr, String funcStr, String contextStr, String expectedStr) {
		Domain param = Calculator.readDomain(paramStr);
		AffineFunction func = Calculator.readFunction(param, funcStr);
		Domain context = Calculator.readDomain(param, contextStr);
		AffineFunction expected = Calculator.readFunction(param, expectedStr);
		AffineFunction inv = Calculator.inverseInContext(context, func);
		System.out.println(inv);
		assert(expected.equivalence(inv));
	}
	
//	private static void boundsTest() {
//
//
//
//		ParameterDomain param = PolyhedralIRUtility.parseParameterDomain("{N|N>0}");
//		Domain dom = PolyhedralIRUtility.parseDomain(param, "{i,j,k|0<=(i,j,k)<N}");
////		Domain dom = PolyhedralIRUserFactory.eINSTANCE.createDomain(param, "{i,j|i==N && 2j==10}");
////		Domain dom = PolyhedralIRUserFactory.eINSTANCE.createDomain(param, "{i,j|0<=2i<N && 2j==i}");
//		System.out.println(dom);
////		System.out.println(dom.boundingBox());
////		Domain dom = alphaz.mde.Calculator.readDomain("{i|0<=i<10}");
////		AffineFunction func = alphaz.mde.Calculator.readFunction("(i,j->j)");
////		
////		System.out.println(dom.preimage(func));
////		
////		System.out.println(dom.boundingBox());
////		System.out.println(dom.getBounds(0));
////		System.out.println(dom.getBounds(1));
//	}
	
	// TODO: bug to be solved here (determinant=0 mismanaged)
	@Test
	public void HNFTest() {
		long[][] A = {{3,5,0},
				{-2,0,5},
				{0,-2,-3}};
		Pair<long[][],long[][]> pHU = MatrixOperations.HNFTransformation(A);
		
		System.out.println(pHU.getValue0().toString());
		
	}
	
	
	
}
