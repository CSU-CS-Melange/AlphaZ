package edu.csu.melange.alphaz.mde.tests.polyIR.transformation;

import org.junit.Test;
import org.polymodel.DimensionsManager;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.isl.ISLMap;
import org.polymodel.isl.factory.ISLNativeBinder;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.factory.PolyhedralIRModule;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;

public class DomainOperationsTest {
	

	private void domainTest(String paramStr, String domStr, String funcStr, String expectedStr) {
		ParameterDomain paramA = PolyhedralIRUtility.parseParameterDomain(paramStr);
		Domain domA = PolyhedralIRUtility.parseDomain(paramA, domStr);
		AffineFunction funcA = PolyhedralIRUtility.parseAffineFunction(paramA, funcStr);
		Domain expected = PolyhedralIRUtility.parseDomain(paramA, expectedStr);
		Domain imgA = domA.image(funcA);
		System.out.println(imgA + " : " + expected);
		assert(expected.equivalence(imgA));
	}
	
	@Test
	public void testEmptyDomains() {
		//Image of empty domain, dimension should still change 
		{
			//With parameter, projection
			domainTest("{N|N>0}", "{i,j|1=0}", "(i,j->i)", "{i|1=0}");
			//Without parameter, projection
			domainTest("{|}", "{i,j|1=0}", "(i,j->i)", "{i|1=0}");
			//With parameter, additional dimension
			domainTest("{N|N>0}", "{i,j|1=0}", "(i,j->i,j,i+j)", "{i,j,k|1=0}");
			//Without parameter, additional dimension
			domainTest("{|}", "{i,j|1=0}", "(i,j->i,j,i+j)", "{i,j,k|1=0}");
		}
	}
	
	
	// Test of the preimage method
	private void domainPreImageTest(String paramStr, String domStr, String funcStr, String expectedStr) {
		ParameterDomain paramA = PolyhedralIRUtility.parseParameterDomain(paramStr);
		Domain domA = PolyhedralIRUtility.parseDomain(paramA, domStr);
		AffineFunction funcA = PolyhedralIRUtility.parseAffineFunction(paramA, funcStr);
		Domain expected = PolyhedralIRUtility.parseDomain(paramA, expectedStr);
		Domain imgA = domA.preimage(funcA);
		System.out.println(imgA + " : " + expected);
		assert(expected.equivalence(imgA));
	}
	
	@Test
	public void preimageTest() {
		domainPreImageTest("{N,M|N-1>=0 && M-1>=0}", "{k|k>=0 && -k+M-1>=0 && N-1>=0 && M-1>=0}", "(iP,k->k)", "{iP,k|k>=0 && -k+M-1>=0 && N-1>=0 && M-1>=0}");
		
	}
	
	@Test
	public void testTransitiveClosure1() {
		testTransitiveClosureA("{|}",  "{i|0<=i<10}", "{i|0<=i<10}", "(i->i+1)", "{i|0<i<10}");
		testTransitiveClosureA("{N|}", "{i|0<=i<N}" , "{i|0<=i<N}",  "(i->i+1)", "{i|0<i<N}");
	}

	
	private void testTransitiveClosureA(String paramDomStr, String domStr, String rangeStr, String fStr, String expectedStr) {
		ParameterDomain params = PolyhedralIRUtility.parseParameterDomain(paramDomStr);
		Domain dom = PolyhedralIRUtility.parseDomain(params, domStr);
		Domain rng = PolyhedralIRUtility.parseDomain(params, rangeStr);
		AffineFunction f = PolyhedralIRUtility.parseAffineFunction(params, fStr);
		Domain expected = PolyhedralIRUtility.parseDomain(params, expectedStr);
		Domain closure = dom.transitiveClosure(f, rng);

		assert(closure.equivalence(expected)) : ( f + "*(" + dom + ") = " + closure + " != " + expected  );
	}

	@Test
	public void testTransitiveClosure2() {
		testTransitiveClosureB("{|}",  "{i|0==i}", "{i|0<=i<10}", "(i->i+1)", "{i|0<i<10}");
//		testTransitiveClosureA("{N|}", "{i|0<=i<N}" , "{i|0<=i<N}",  "(i->i+1)", "{i|0<i<N}");
	}

	private void testTransitiveClosureB(String paramDomStr, String domStr, String rangeStr, String fStr, String expectedStr) {
		DimensionsManager manager = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
		
		ISLMap map = ISLNativeBinder.createMapFromIslString("[N] -> {[i,j] -> [i',j'] : j<=i<N && j=0 & 0<=i'<N && 0<=j'<N && i-j<i'-j'}", manager);
		System.out.println(map);
		System.out.println(map.getRange().toString());
//		ParameterDomain params = PolyhedralIRUtility.parseParameterDomain(paramDomStr);
//		Domain dom = PolyhedralIRUtility.parseDomain(params, domStr);
//		Domain rng = PolyhedralIRUtility.parseDomain(params, rangeStr);
//		AffineFunction f = PolyhedralIRUtility.parseAffineFunction(params, fStr);
//		Domain expected = PolyhedralIRUtility.parseDomain(params, expectedStr);
//		
//		AbstractRelation rel = f.getPMmapping().buildRelation(manager).intersectDomain(dom.getPMdomain());
//		//.intersectRange(rng.getPMdomain());
//		
////		for (BasicRelation br : rel.getBasicRelations()) {
////			InputDimension in = rel.getDimensions().getInputs().get(0);
////			OutputDimension out = rel.getDimensions().getOutputs().get(0);
////			IntConstraint constraint = IntExpressionBuilder.constraint(affine(term(in)), affine(term(out)), ComparisonOperator.LT);
////			br.getRelation().getConstraints().add(constraint);
////		}
//		
//		AbstractRelation closure = rel.exactTransitiveClosure();
//		System.out.println(rel);
//		System.out.println(rel.getRange());
//		System.out.println(closure);
//		System.out.println(closure.getRange());
	}
}
