package edu.csu.melange.alphaz.mde.tests;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.junit.Test;
import org.polymodel.DimensionsManager;
import org.polymodel.DomainDimensions;
import org.polymodel.Label;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.isl.factory.ISLNativeBinder;
import org.polymodel.matrix.Matrix;
import org.polymodel.matrix.impl.MatrixOperations;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.FastISLDomain;
import org.polymodel.polyhedralIR.FastISLMap;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicSet;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLContext;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSet;


/**
 * Quick series of test
 * 
 * @author giooss
 */
public class TestJniMapIsl {
	
	// Test to see which part of the memory allocation of the jnimap of isl is faulty... :/
	@Test
	public void testIsl() {
		// Creating a domain
		List<String> lParams = new BasicEList<String>();
		lParams.add("N");
		Domain dom1 = PolyhedralIRUtility.parseDomain(lParams, "{i,j| 0<=i<=j<N}");
		
		System.out.println(dom1.toString());
		
		// Creating another domain & intersection
		Domain dom2 = PolyhedralIRUtility.parseDomain(lParams, "{i,j| 0<=i<N && 1<=j<N}");
		Domain dom3 = dom1.intersection(dom2);
		System.out.println(dom3.toString());
		
		// Doing it a lots of time
		for (int i=0; i<3000; i++) {
			dom1.intersection(dom2);
			
			if (i%50==0)
				System.out.println("Iteration " + i);
		}
	}
	
	
	// Comparison of the isl intersection operation with a pure Java intersection operation
	@Test
	public void testIntersectionSpeed() {
		// Creating the two domains
		List<String> lParams = new BasicEList<String>();
		lParams.add("N");
		Domain dom1 = PolyhedralIRUtility.parseDomain(lParams, "{i,j| 0<=i<=j<N}");		
		Domain dom2 = PolyhedralIRUtility.parseDomain(lParams, "{i,j| 0<=i<N && 1<=j<N}");
		
		// Test run, comparing the results
		System.out.println(dom1.intersection(dom2));			// Simplification
		System.out.println(intersectionCustom(dom1, dom2));		// No simplification !!!
		System.out.println(intersectionCustomV2(dom1, dom2));	// Simplification
		System.out.println();
		
		// Timing start - 1000 iterations
		System.out.println("*** ISL Version of Intersection:");
		long starttime = System.currentTimeMillis();
		for (int i=0; i<1000; i++) {
			dom1.intersection(dom2);
		}
		long currentTime = System.currentTimeMillis() - starttime;
		System.out.println("	=> Time taken = " + currentTime + " ms");
		System.out.println();
		
		
		System.out.println("*** Custom Version of Intersection:");
		starttime = System.currentTimeMillis();
		for (int i=0; i<1000; i++) {
			//dom1.getPMdomain().toMatrices(); dom2.getPMdomain().toMatrices();
			intersectionCustom(dom1,dom2);
		}
		currentTime = System.currentTimeMillis() - starttime;
		System.out.println("	=> Time taken = " + currentTime + " ms");
		//System.out.println("	=> Time taken on tom = " + PolymodelDefaultFactory.totalTime + " ms");   // measurement
		System.out.println();
		
		
		
		System.out.println("*** Custom Version of Intersection - V2:");
		starttime = System.currentTimeMillis();
		for (int i=0; i<1000; i++)
			intersectionCustomV2(dom1,dom2);
		currentTime = System.currentTimeMillis() - starttime;
		System.out.println("	=> Time taken = " + currentTime + " ms");
		System.out.println();
		
		
		
		// *** Result: isl is MUCH faster than a custom version, for a simplified result
		
		// *** Detailed results:
		//	-> 1000 isl intersection: 677 ms
		//  -> 1000 custom intersection: 7025 ms
		//  -> 1000 custom intersection - V2: 471 ms
		//	-> 1000*2 toMatrix operations: 6859 ms
		System.out.println("*** Intersection on matrices (append):");
		Matrix mat1 = dom1.getPMdomain().toMatrices().get(0);
		Matrix mat2 = dom2.getPMdomain().toMatrices().get(0);
		
		starttime = System.currentTimeMillis();
		for (int i=0; i<1000; i++) {
			mat1.appendRow(mat2);
		}
		currentTime = System.currentTimeMillis() - starttime;
		System.out.println("	=> Time taken = " + currentTime + " ms");
		System.out.println();
		//  -> 1000 matrix append operations: 8ms
		
		
		// Using JNIISLBasicSet directly
		System.out.println("*** Intersection using JNIISLBasicSet directly:");
		JNIISLContext ctx = JNIISLContext.getCtx();
		JNIISLBasicSet bset1 = JNIISLBasicSet.buildFromString(ctx, "[N] -> { [i,j] : 0<=i<=j<N }");
		JNIISLBasicSet bset2 = JNIISLBasicSet.buildFromString(ctx, "[N] -> { [i,j] : 0<=i<N and 1<=j<N }");
		
		starttime = System.currentTimeMillis();
		for (int i=0; i<1000; i++) {
			JNIISLBasicSet bcopy1 = bset1.copy();
			JNIISLBasicSet bcopy2 = bset2.copy();
			bcopy1.intersect(bcopy2);
		}
		currentTime = System.currentTimeMillis() - starttime;
		System.out.println("	=> V1: Time taken = " + currentTime + " ms");
		
		starttime = System.currentTimeMillis();
		for (int i=0; i<1000; i++) {
			JNIISLBasicSet bcopy1 = JNIISLBasicSet.buildFromString(ctx, "[N] -> { [i,j] : 0<=i<=j<N }");
			JNIISLBasicSet bcopy2 = JNIISLBasicSet.buildFromString(ctx, "[N] -> { [i,j] : 0<=i<N and 1<=j<N }");
			bcopy1.intersect(bcopy2);
		}
		currentTime = System.currentTimeMillis() - starttime;
		System.out.println("	=> V2: Time taken = " + currentTime + " ms");
		
		System.out.println();
		
	}
	
	
	// **************************************************************************
	
	public Domain intersectionCustom(Domain dom1, Domain dom2) {
		if ( dom1.getNIndices()!=dom2.getNIndices() ) 
			throw new RuntimeException("intersection: the two domains do not have the same number of dimensions");
		if ( dom1.getNParams()!= dom2.getNParams() )
			throw new RuntimeException("intersection: the two domains do not have the same number of parameters");
		
		List<Matrix> lmat1 = dom1.getPMdomain().toMatrices();
		List<Matrix> lmat2 = dom2.getPMdomain().toMatrices();
		
		List<IntConstraintSystem> lsyst12 = new BasicEList<IntConstraintSystem>();
		for (Matrix mat1 : lmat1)
			for (Matrix mat2 : lmat2) {
				Matrix mat12 = mat1.appendRow(mat2);
				lsyst12.add(mat12.toDomain(dom1.getParams(), dom1.getIndices()));
			}
		
		Domain dom12 = PolyhedralIRUserFactory.eINSTANCE.createDomain(dom1.getParams(), dom1.getIndices(), lsyst12);
		return dom12;
	}
	
	// Intersection custom using JNIISL directly (while still translating back)
	public Domain intersectionCustomV2(Domain dom1, Domain dom2) {
		String strDom1 = printISLFormat(dom1);
		String strDom2 = printISLFormat(dom2);
		JNIISLSet set1 = JNIISLSet.buildFromString(strDom1);
		JNIISLSet set2 = JNIISLSet.buildFromString(strDom2);
		
		JNIISLSet set12 = set1.intersect(set2);
		
		// Translating back
		DomainDimensions domDim = dom1.getPMdomain().getDimensions();
		List<IntConstraintSystem> lsyst = new BasicEList<IntConstraintSystem>();
		for (JNIISLBasicSet bset : set12.getBasicSets()) {
			IntConstraintSystem syst = ISLNativeBinder.intConstraintSystem(bset,
					domDim.getIndices(), domDim.getParameters(), domDim.getExistential());
			lsyst.add(syst);
		}
		return PolyhedralIRUserFactory.eINSTANCE.createDomain(dom1.getParams(), dom1.getIndices(), lsyst);
	}
	
	public String printISLFormat(Domain dom) {
		return dom.getPMdomain().toString(OUTPUT_FORMAT.ISL);
	}
	

	// **************************************************************************
	
	@Test
	public void testIntersectionSpeedFastISLDomain() {
		JNIISLContext ctx = JNIISLContext.getCtx();
		JNIISLSet set1 = JNIISLSet.buildFromString(ctx, "[N] -> { [i,j] : 0<=i<=j<N }");
		JNIISLSet set2 = JNIISLSet.buildFromString(ctx, "[N] -> { [i,j] : 0<=i<N and 1<=j<N }");
		
		List<Variable> lparams = new BasicEList<Variable>();
		lparams.add(PolymodelComponent.INSTANCE.getDefaultDimensionsManager().getParameter(0, "N"));
		
		List<Variable> linds = new BasicEList<Variable>();
		linds.add(PolymodelComponent.INSTANCE.getDefaultDimensionsManager().getDimension(0, "i"));
		linds.add(PolymodelComponent.INSTANCE.getDefaultDimensionsManager().getDimension(1, "j"));
		
		DomainDimensions domDims = PolyhedralIRUserFactory._polyFact.createDomainDimensions(linds, lparams);
		
		FastISLDomain fdom1 = PolyhedralIRUserFactory.eINSTANCE.createFastISLDomain(domDims.copy(), set1);
		FastISLDomain fdom2 = PolyhedralIRUserFactory.eINSTANCE.createFastISLDomain(domDims.copy(), set2);
		
		// Test
		FastISLDomain fdom12 = (FastISLDomain) fdom1.intersection(fdom2);
		System.out.println(fdom12.getIslSet().toString());
		
		
		long starttime = System.currentTimeMillis();
		for (int i=0; i<1000; i++)
			fdom1.intersection(fdom2);
		long currentTime = System.currentTimeMillis() - starttime;
		System.out.println("	=> Time taken = " + currentTime + " ms");
		System.out.println();
		// 60x speedup
	}
	
	@Test
	public void testImageSpeedFastISLDomain() {
		JNIISLContext ctx = JNIISLContext.getCtx();
		JNIISLSet set = JNIISLSet.buildFromString(ctx, "[N] -> { [i,j] : 0<=i<=j<N}");
		JNIISLBasicMap map = JNIISLBasicMap.buildFromString(ctx, "[N] -> {[i,j] -> [i-j,j] : }");
		
		List<Variable> lparams = new BasicEList<Variable>();
		lparams.add(PolymodelComponent.INSTANCE.getDefaultDimensionsManager().getParameter(0, "N"));
		
		List<Variable> linds = new BasicEList<Variable>();
		linds.add(PolymodelComponent.INSTANCE.getDefaultDimensionsManager().getDimension(0, "i"));
		linds.add(PolymodelComponent.INSTANCE.getDefaultDimensionsManager().getDimension(1, "j"));
		
		DomainDimensions domDims = PolyhedralIRUserFactory._polyFact.createDomainDimensions(linds, lparams);
		
		FastISLDomain fdom = PolyhedralIRUserFactory.eINSTANCE.createFastISLDomain(domDims.copy(), set);
		FastISLMap fmap = PolyhedralIRUserFactory.eINSTANCE.createFastISLMap(domDims.copy(), map, ((Label)null), ((Label)null));
		
		List<String> paramName = new BasicEList<String>(); paramName.add("N");
		Domain dom = PolyhedralIRUtility.parseDomain(paramName, "{i,j | 0<=i<=j<N}");
		
		List<String> lStrExpr = new BasicEList<String>(); lStrExpr.add("i-j"); lStrExpr.add("j");
		AffineFunction func = PolyhedralIRUtility.parseAffineFunction(lparams, linds, lStrExpr);
		
		// Test
		FastISLDomain fdomIm = (FastISLDomain) fdom.image(fmap);
		System.out.println("Test fastISL => " + fdomIm.getIslSet().toString());
		Domain domIm = dom.image(func);
		System.out.println("Test Domain => " + domIm.toString());
		
		
		
		long starttime = System.currentTimeMillis();
		for (int i=0; i<1000; i++)
			fdom.image(fmap);
		long currentTime = System.currentTimeMillis() - starttime;
		System.out.println("	=> Time taken (fast) = " + currentTime + " ms");
		System.out.println();
		
		starttime = System.currentTimeMillis();
		for (int i=0; i<1000; i++)
			dom.image(func);
		currentTime = System.currentTimeMillis() - starttime;
		System.out.println("	=> Time taken (normal) = " + currentTime + " ms");
		System.out.println();
		// 35x speedup
	}
	
	@Test
	public void testFastISLMapConstructor() {
		DimensionsManager dimMana = PolymodelComponent.INSTANCE.getDefaultDimensionsManager();
		
		List<Variable> lparams = new BasicEList<Variable>();
		lparams.add(dimMana.getParameter(0, "N"));
		lparams.add(dimMana.getParameter(1, "M"));
		
		List<Variable> linds = new BasicEList<Variable>();
		linds.add(dimMana.getDimension(0, "i"));
		linds.add(dimMana.getDimension(1, "j"));
		
		DomainDimensions domDims = PolyhedralIRUserFactory._polyFact.createDomainDimensions(linds, lparams);
		
		List<String> lexpr = new BasicEList<String>();
		lexpr.add("N-i");
		lexpr.add("M+2j");
		
		FastISLMap fmap = PolyhedralIRUserFactory.eINSTANCE.createFastISLMap(domDims, lexpr);
		
		System.out.println(fmap.getIslMap().toString());
		
		System.out.println(fmap.toString());
		
	}
	
	@Test
	public void testFastISLDomainMatrixConstructor() {
		DimensionsManager dimMana = PolymodelComponent.INSTANCE.getDefaultDimensionsManager();
		
		List<Variable> lparams = new BasicEList<Variable>();
		lparams.add(dimMana.getParameter(0, "N"));
		lparams.add(dimMana.getParameter(1, "M"));
		
		List<Variable> linds = new BasicEList<Variable>();
		linds.add(dimMana.getDimension(0, "i"));
		linds.add(dimMana.getDimension(1, "j"));
		
		DomainDimensions domDims = PolyhedralIRUserFactory._polyFact.createDomainDimensions(linds, lparams);
		
		// 0 = eq / 1 = ineq
		long[][] matLong = {
				{0, -1, 0, 3, -1, 0},
				{1, 0, 1, -1, -2, 3}
		};
		Matrix mat = PolymodelComponent.INSTANCE.getFactory().createMatrix(matLong);
		List<Matrix> lmat = new BasicEList<Matrix>();
		lmat.add(mat);
		
		FastISLDomain dom = PolyhedralIRUserFactory.eINSTANCE.createFastISLDomain(domDims, lmat);
		
		System.out.println("dom = " + dom.toString());
		
		List<Matrix> lMatEnd = dom.toMatrix();
		System.out.println("lMatEnd = ");
		for (Matrix matEnd : lMatEnd)
			System.out.println(matEnd.toString());
	}
	
	@Test
	public void testComparisonFastISLDomainMatrixConstructor() {
		List<String> lparams = new BasicEList<String>();
		lparams.add("Nb"); lparams.add("Mb"); lparams.add("TSTEPSb"); lparams.add("Nl"); lparams.add("Ml"); lparams.add("TSTEPSl"); lparams.add("b");
		
		
		Domain dom = PolyhedralIRUtility.parseDomain(lparams, "{tBl,iBl,jBl,tLoc,iLoc,jLoc|jBl==0 && iBl==0 && tBl==0 && Ml==0 && Nl==0 && TSTEPSl==0 &&"
				+ "TSTEPSb>=2 && Nb>=2 && Mb>=2 && b>=6 && jLoc>=tLoc && b>=jLoc+1 && tLoc>=0 && iLoc>=tLoc && b>=iLoc+1}");
		
		FastISLDomain fdom = PolyhedralIRUserFactory.eINSTANCE.createFastISLDomain(dom.getPMdomain());
		
		// Check that they are the same
		System.out.println("dom = " + dom.toString());
		System.out.println("fdom = " + fdom.toString());
		// Identical => OK
		
		List<Matrix> lmatDom = dom.getPMdomain().toMatrices();
		List<Matrix> lmatFDom = fdom.toMatrix();

		System.out.println("lmatDom = " + lmatDom.toString());
		System.out.println("lmatFDom = " + lmatFDom.toString());
	}
	
	
	@Test
	public void testSpeedMatrixLongArray() {
		DimensionsManager dimMana = PolymodelComponent.INSTANCE.getDefaultDimensionsManager();
		
		List<Variable> lparams = new BasicEList<Variable>();
		lparams.add(dimMana.getParameter(0, "N"));
		lparams.add(dimMana.getParameter(1, "M"));
		
		List<Variable> linds = new BasicEList<Variable>();
		linds.add(dimMana.getDimension(0, "i"));
		linds.add(dimMana.getDimension(1, "j"));
		
		DomainDimensions domDims = PolyhedralIRUserFactory._polyFact.createDomainDimensions(linds, lparams);
		
		// 0 = eq / 1 = ineq
		long[][] matLong = {
				{0, -1, 0, 3, -1, 0},
				{1, 0, 1, -1, -2, 3}
		};
		Matrix mat = PolymodelComponent.INSTANCE.getFactory().createMatrix(matLong);
		List<Matrix> lmat = new BasicEList<Matrix>();
		lmat.add(mat);
		
		long startTime = System.currentTimeMillis();
		for (int i=0; i<1000; i++) {
			FastISLDomain dom = PolyhedralIRUserFactory.eINSTANCE.createFastISLDomain(domDims, lmat);
			dom.toMatrix();
		}
		long diffTime = System.currentTimeMillis() - startTime;
		System.out.println("*** Matrix - diffTime = " + diffTime + " ms");
		
		List<long[][]> lmatLong = new BasicEList<long[][]>();
		lmatLong.add(matLong);
		
		startTime = System.currentTimeMillis();
		for (int i=0; i<1000; i++) {
			FastISLDomain dom = PolyhedralIRUserFactory.eINSTANCE.createFastISLDomainMatLong(domDims, lmatLong);
			dom.toLongMatrix();
		}
		diffTime = System.currentTimeMillis() - startTime;
		System.out.println("*** Matrix - diffTime = " + diffTime + " ms");
		
		// Result: 282ms (Matrix) vs 176ms (long[][])
	}
	
	@Test
	public void testFastISLMapMatrixConstructor() {
		DimensionsManager dimMana = PolymodelComponent.INSTANCE.getDefaultDimensionsManager();
		
		List<Variable> lparams = new BasicEList<Variable>();
		lparams.add(dimMana.getParameter(0, "N"));
		lparams.add(dimMana.getParameter(1, "M"));
		
		List<Variable> linds = new BasicEList<Variable>();
		linds.add(dimMana.getDimension(0, "i"));
		linds.add(dimMana.getDimension(1, "j"));
		
		DomainDimensions domDims = PolyhedralIRUserFactory._polyFact.createDomainDimensions(linds, lparams);
		
		long[][] longMat = {
				{1, 0, -1, 0, 0},
				{0, 1,  0, 2, 3}
		};
		
		Matrix mat = PolymodelComponent.INSTANCE.getFactory().createMatrix(longMat);
		
		PolyhedralIRUserFactory.eINSTANCE.createFastISLMap(domDims, mat);
	}
	
	@Test
	public void testFastISLMapToMatrix() {
		DimensionsManager dimMana = PolymodelComponent.INSTANCE.getDefaultDimensionsManager();
		
		List<Variable> lparams = new BasicEList<Variable>();
		lparams.add(dimMana.getParameter(0, "N"));
		lparams.add(dimMana.getParameter(1, "M"));
		
		List<Variable> linds = new BasicEList<Variable>();
		linds.add(dimMana.getDimension(0, "i"));
		linds.add(dimMana.getDimension(1, "j"));
		
		DomainDimensions domDims = PolyhedralIRUserFactory._polyFact.createDomainDimensions(linds, lparams);
		
		List<String> lexpr = new BasicEList<String>();
		lexpr.add("N-i");
		lexpr.add("M+2j");
		
		FastISLMap fmap = PolyhedralIRUserFactory.eINSTANCE.createFastISLMap(domDims, lexpr);
		
		Matrix mat = fmap.toMatrix();
		
		System.out.println("fmap = " + fmap.toString());
		System.out.println(mat.toString());
	}
	
	@Test
	public void testSpeedFastISLMapToMatrix() {
		DimensionsManager dimMana = PolymodelComponent.INSTANCE.getDefaultDimensionsManager();
		
		List<Variable> lparams = new BasicEList<Variable>();
		lparams.add(dimMana.getParameter(0, "N"));
		lparams.add(dimMana.getParameter(1, "M"));
		
		List<Variable> linds = new BasicEList<Variable>();
		linds.add(dimMana.getDimension(0, "i"));
		linds.add(dimMana.getDimension(1, "j"));
		
		DomainDimensions domDims = PolyhedralIRUserFactory._polyFact.createDomainDimensions(linds, lparams);
		
		List<String> lexpr = new BasicEList<String>();
		lexpr.add("N-i");
		lexpr.add("M+2j");
		
		FastISLMap fmap = PolyhedralIRUserFactory.eINSTANCE.createFastISLMap(domDims, lexpr);
		
		Matrix mat = fmap.toMatrix();
		long[][] longMat = fmap.toLongMatrix();
		
		System.out.println("fmap = " + fmap.toString());
		System.out.println(mat.toString());
		System.out.println(MatrixOperations.toString(longMat));

		long startTime = System.currentTimeMillis();
		for (int i=0; i<1000; i++) {
			fmap.toMatrix();
		}
		long diffTime = System.currentTimeMillis() - startTime;
		System.out.println("*** Matrix - diffTime = " + diffTime + " ms");
		
		startTime = System.currentTimeMillis();
		for (int i=0; i<1000; i++) {
			fmap.toLongMatrix();
		}
		diffTime = System.currentTimeMillis() - startTime;
		System.out.println("*** LongMatrix - diffTime = " + diffTime + " ms");
		
		// 85 ms (Matrix) VS 9 ms (long[][])
	}
	
} // TestJniMapIsl
