package edu.csu.melange.alphaz.mde.tests.polyIR.reduction;

import java.io.IOException;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.transformation.Normalize;
import org.polymodel.polyhedralIR.transformation.Simplify;
import org.polymodel.polyhedralIR.util.AShow;

public class ScalarReductionDetectionTest {
	
	@Test(timeout=10000) // no more than 10s //(expected=ExpectedException.class)
	public void test() throws IOException{
		test("alphabets/SRexamples/ScalarReduction.ab", "ScalarReduction");
	}
	
	public static void test(String filename, String systemName) throws IOException {
		Program program = alphaz.mde.Basic.ReadAlphabets(filename);
		AffineSystem system = program.getSystem(systemName);
		
//		System.out.println(PrintAST.print(system));
		System.out.println(system);
		Simplify.simplify(system);
		Normalize.normalize(system);
		
		System.out.println(AShow.toSimplifiedString(system));
			

		//Domain ans = fact.createDomain(system.getParameters(), "{i,j|-i+j== 0 && N-3>= 0 && N-i-1>= 0 && i>= 0}");
//		Domain ctx = fact.createDomain(system.getParameters(), "{i,j,k|-i+k== 0 && -i+j== 0 && N-3>= 0 && N-i-1>= 0 && i>= 0}");
//		
//		Domain prob = DomainOperations.extendParameterDomain(ctx, ctx);
//		DomainOperations.addConstraintsRelatingExtendedParameterIndicesAndIndices(system.getParameters(), prob, 
//				new DomainOperations.Constraint(fact.createAffineFunction(system.getParameters(), "(i,j,k->i,j)"),
//												fact.createAffineFunction(system.getParameters(), "(i,j,k->i,j)"), Operator.EQ));
//		
//		System.out.println(prob);
//		PolyhedralDomain max = ((ISLSet)prob.getPMdomain()).lexMax();
//		PolyhedralDomain min = ((ISLSet)prob.getPMdomain()).lexMin();
//		System.out.println(max);
//		System.out.println(min);
//		System.out.println(max.equivalence(min));
		
		
//		System.out.println(AShow.toSimplifiedString(system));
		//System.out.println(PrintAST.print(system));
		
//		Domain ans = fact.createDomain(system.getParameters(), "{i,j|i==j && -i+j>= 0 && i>= 0 && N-j-1>= 0}");
//		System.out.println(ans);
//		Domain dom = fact.createDomain(system.getParameters(), "{i,j,k|-i+k== 0 && -i+j== 0 && N-3>= 0 && N-i-1>= 0 && i>= 0}");
//		System.out.println(dom);
//		//((ISLSet)dom.getPMdomain()).;
//		Map<Domain,AffineFunction> quast = DomainOperations.findDependencies(system.getParameters(), ans, dom, 
//				new Constraint(fact.createIdentityFunction(ans), fact.createAffineFunction(system.getParameters(), "(i,j,k->i,j)"), Operator.EQ), null);
//		for (Domain d : quast.keySet()) {
//			System.out.println(d + " : " + quast.get(d));
//		}
	}
}
