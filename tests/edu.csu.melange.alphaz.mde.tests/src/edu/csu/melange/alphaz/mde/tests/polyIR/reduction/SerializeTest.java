package edu.csu.melange.alphaz.mde.tests.polyIR.reduction;

import java.io.IOException;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.transformation.Normalize;
import org.polymodel.polyhedralIR.transformation.reduction.NormalizeReduction;
import org.polymodel.polyhedralIR.transformation.reduction.SerializeReduction;
import org.polymodel.polyhedralIR.util.AShow;

public class SerializeTest {
	
	@Test(timeout=10000) // no more than 10s //(expected=ExpectedException.class)
	public void test() throws IOException{
		test("testcases/matrix_product_withReduce/matrix_product_withReduce.ab", "matrix_product_withReduce", "C", "(i,j,k->i,j,k)");
		test("alphabets/SRexamples/SerializeTest.ab", "SRTest1", "B", "(i->i)");
//		test("tesetcases/cholesky_withReduce/cholesky_withReduce.ab", "cholesky_withReduce", "C", "(i,j,k->i,j,k)"); // TODO: bug
//		testCholesky();																								 // TODO: bug
	}
	
	public static void test(String filename, String systemName, String var, String sched) throws IOException {
		Program program = alphaz.mde.Basic.ReadAlphabets(filename);
		AffineSystem system = program.getSystem(systemName);

		System.out.println(AShow.toSimplifiedString(system));
//		System.out.println(PolyhedralIRToAlphabets.toSimplifiedString(system));
		
		StandardEquation eq = system.getEquation(var);
		
		 
		SerializeReduction.transform((ReduceExpression)eq.getExpression(), 
				PolyhedralIRUtility.parseAffineFunction(system.getParameters(), sched));
		//SerializeReduction.transform((ReduceExpression)system.getEquations().get(0).getExpression(), PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(system.getParameters(), "(i,j,k->k)"));

		Normalize.normalize(system);
		System.out.println(AShow.toSimplifiedString(system));
			
//		String outDir = "test-out/serializeTest";
//		WrapperGeneratorForC.generate(system, CodeGenOptions.writeCDefault(), outDir);
//		WriteC.generate(system, CodeGenOptions.writeCDefault(), outDir);
//		alphaz.mde.CodeGen.generateMakefile(program, system.getName(), outDir);
	}
	
	public static void testCholesky() throws IOException {
		final String filename = "testcases/cholesky_withReduce/cholesky_withReduce.ab";
		final String systemName = "cholesky_withReduce";
		
		Program program = alphaz.mde.Basic.ReadAlphabets(filename);
		AffineSystem system = program.getSystem(systemName);

		System.out.println(AShow.toSimplifiedString(system));
		
		NormalizeReduction.apply(program);
		
		System.out.println(AShow.toSimplifiedString(system));
//		System.out.println(AShow.toSimplifiedString(system));
		
		{
			StandardEquation eq = system.getEquation("NR_L");
			SerializeReduction.transform((ReduceExpression)eq.getExpression(), 
					PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i,j,k->i,j,k)"));
		}
		{
			StandardEquation eq = system.getEquation("NR_L_1");
			SerializeReduction.transform((ReduceExpression)eq.getExpression(), 
					PolyhedralIRUtility.parseAffineFunction(system.getParameters(), "(i,j,k->i,j,k)"));
		}
		//SerializeReduction.transform((ReduceExpression)system.getEquations().get(0).getExpression(), PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(system.getParameters(), "(i,j,k->k)"));
		
		Normalize.normalize(system);
		System.out.println(AShow.toSimplifiedString(system));
			
//		System.out.println(PolyhedralIRToAlphabets.toSimplifiedString(system));
//		StandardEquation eq = system.getEquation(var);
//		
//		 
//		SerializeReduction.transform((ReduceExpression)eq.getExpression(), 
//				PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(system.getParameters(), sched));
//		//SerializeReduction.transform((ReduceExpression)system.getEquations().get(0).getExpression(), PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(system.getParameters(), "(i,j,k->k)"));
//		
//		Normalize.normalize(system);
//		System.out.println(AShow.toSimplifiedString(system));
		
//		String outDir = "test-out/serializeTest";
//		WrapperGeneratorForC.generate(system, CodeGenOptions.writeCDefault(), outDir);
//		WriteC.generate(system, CodeGenOptions.writeCDefault(), outDir);
//		alphaz.mde.CodeGen.generateMakefile(program, system.getName(), outDir);
	}
	
}
