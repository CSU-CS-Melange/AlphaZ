package edu.csu.melange.alphaz.mde.tests.polyIR.subsystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.junit.Test;
import org.polymodel.DimensionsManager;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.FastISLDomain;
import org.polymodel.polyhedralIR.FastISLMap;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.analysis.PRDGBuilder;
import org.polymodel.polyhedralIR.analysis.UniquenessAndCompletenessCheck;
import org.polymodel.polyhedralIR.factory.PolyhedralIRModule;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.factory.TargetMappingUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.WriteC;
import org.polymodel.polyhedralIR.targetMapping.ParallelizationSpecification;
import org.polymodel.polyhedralIR.transformation.ChangeOfBasis;
import org.polymodel.polyhedralIR.transformation.Normalize;
import org.polymodel.polyhedralIR.transformation.ParametricTiling;
import org.polymodel.polyhedralIR.transformation.helper.CARTOperations;
import org.polymodel.polyhedralIR.util.AShow;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.PRDGSubSystemHyperEdge;
import org.polymodel.prdg.factory.PRDGUserFactory;
import org.polymodel.prdg.scheduling.IPRDGScheduler;
import org.polymodel.prdg.scheduling.ScheduledStatement;
import org.polymodel.prdg.scheduling.SchedulingException;
import org.polymodel.prdg.scheduling.feautrier.FeautrierISLScheduler;

import alphaz.mde.Analysis;
import alphaz.mde.Basic;
import alphaz.mde.CodeGen;
import alphaz.mde.TargetMapping;


// WARNING! SOME TESTS ARE TAKING TOO MUCH MEMORY

public class ParametricTilingTest {
	
	// "Square" tiling for domain
	private static void parseAndGetBlockedDomain(String domStr, List<String> paramScal, List<String> blockIndName,
			List<String> localIndName, List<String> blockParamName, List<String> localParamName, List<Integer> scale, String blSizeParamName,
			int minb, List<Integer> minBlParam) {
		Domain domScal = PolyhedralIRUtility.parseDomain(paramScal, domStr);
		
		DimensionsManager _dimMana = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
		
		List<Variable> blockInd = new BasicEList<Variable>();
		for (int i=0; i<blockIndName.size(); i++)
			blockInd.add(_dimMana.getDimension(i, blockIndName.get(i)));
		List<Variable> localInd = new BasicEList<Variable>();
		for (int i=0; i<localIndName.size(); i++)
			localInd.add(_dimMana.getDimension(i+blockInd.size(), localIndName.get(i)));
		List<Variable> blockParam = new BasicEList<Variable>();
		for (int i=0; i<blockParamName.size(); i++)
			blockParam.add(_dimMana.getParameter(i, blockParamName.get(i)));
		List<Variable> localParam = new BasicEList<Variable>();
		for (int i=0; i<localParamName.size(); i++)
			localParam.add(_dimMana.getParameter(i+blockParamName.size(), localParamName.get(i)));
		Variable blSizeParam = _dimMana.getParameter(blockParamName.size()+localParamName.size(), blSizeParamName);
		
		Domain domTiled = CARTOperations.getTiledDomain(domScal, blockInd, localInd, blockParam, localParam, scale, blSizeParam, false, minb, minBlParam);
		System.out.println();
		System.out.println();
		System.out.println("**********************************************");
		System.out.println(domTiled.toString());
	}
	
	@Test
	public void test1_getTiledDomain_squareCase() {
		List<String> paramScal = new BasicEList<String>();
		paramScal.add("N");
		
		List<String> blockIndName = new BasicEList<String>();
		blockIndName.add("alpha"); blockIndName.add("beta");
		
		List<String> localIndName = new BasicEList<String>();
		localIndName.add("ii"); localIndName.add("jj");
		
		List<String> blockParamName = new BasicEList<String>();
		blockParamName.add("M");
		
		List<String> localParamName = new BasicEList<String>();
		localParamName.add("mm");
		
		List<Integer> scale = new BasicEList<Integer>();
		scale.add(1); scale.add(1);
		
		List<Integer> lMinBlParam = new BasicEList<Integer>();
		lMinBlParam.add(0);
		
		parseAndGetBlockedDomain("{i,j | N-1-i-j>=0}", paramScal, blockIndName, localIndName, blockParamName, localParamName, scale, "b", 1, lMinBlParam);
		// {alpha,beta,ii,jj|alpha+beta-M+1==0 && -ii-jj+mm+b-1>=0 && ii>=0 && jj>=0 && -ii+b-1>=0 && -jj+b-1>=0}
		//		|| {alpha,beta,ii,jj|alpha+beta-M==0 && -ii-jj+mm-1>=0 && ii>=0 && jj>=0 && -ii+b-1>=0 && -jj+b-1>=0}
		//		|| {alpha,beta,ii,jj|-alpha-beta+M-2>=0 && ii>=0 && jj>=0 && -ii+b-1>=0 && -jj+b-1>=0}
		
		// ( OLD RESULT (with mm=0): {alpha,beta,ii,jj|alpha+beta-M+1==0 && -ii-jj+b-1>=0 && ii>=0 && jj>=0}
		//		|| {alpha,beta,ii,jj|-alpha-beta+M-2>=0 && ii>=0 && jj>=0 && -ii+b-1>=0 && -jj+b-1>=0} )
	}
	
	@Test
	public void test2_getTiledDomain_squareCase() {
		List<String> paramScal2 = new BasicEList<String>();
		paramScal2.add("N");
		
		List<String> blockIndName2 = new BasicEList<String>();
		blockIndName2.add("alpha"); blockIndName2.add("beta");
		
		List<String> localIndName2 = new BasicEList<String>();
		localIndName2.add("ii"); localIndName2.add("jj");
		
		List<String> blockParamName2 = new BasicEList<String>();
		blockParamName2.add("M");
		
		List<String> localParamName2 = new BasicEList<String>();
		localParamName2.add("mm");
		
		List<Integer> scale2 = new BasicEList<Integer>();
		scale2.add(1); scale2.add(1);
		//scale2.add(2); scale2.add(1);
		
		List<Integer> lMinBlParam = new BasicEList<Integer>();
		lMinBlParam.add(0);
		
		parseAndGetBlockedDomain("{i,j | i-j>=0 && 2j-i>=0 && N-1-j>=0 }", paramScal2, blockIndName2, localIndName2,
				blockParamName2, localParamName2, scale2, "b", 1, lMinBlParam);
		// - Normal scaling factor
		// {alpha,beta,ii,jj|beta==0 && alpha==0 && M==0 && ii-jj>=0 && -jj+mm-1>=0 && -ii+2jj>=0 && -ii+b-1>=0}
		//		|| {alpha,beta,ii,jj|beta==0 && alpha==0 && ii-jj>=0 && M-1>=0 && -ii+2jj>=0 && -ii+b-1>=0}
		//		|| {alpha,beta,ii,jj|beta-M==0 && alpha-M==0 && ii-jj>=0 && M-1>=0 && jj>=0 && -ii+b-1>=0 && -jj+mm-1>=0}
		//		|| {alpha,beta,ii,jj|-alpha+beta==0 && ii-jj>=0 && alpha-1>=0 && jj>=0 && -ii+b-1>=0 && -alpha+M-1>=0}
		//		|| {alpha,beta,ii,jj|beta-M==0 && alpha-2M==0 && M-1>=0 && ii>=0 && -jj+mm-1>=0 && -ii+b-1>=0 && -jj+b-1>=0 && -ii+2jj>=0}
		//		|| {alpha,beta,ii,jj|-alpha+2beta==0 && alpha-2>=0 && ii>=0 && -alpha+2M-2>=0 && -ii+b-1>=0 && -jj+b-1>=0 && -ii+2jj>=0}
		//		|| {alpha,beta,ii,jj|beta-M==0 && alpha-2M-1==0 && M>=0 && ii>=0 && -ii+2jj-b>=0 && -jj+mm-1>=0 && -jj+b-1>=0}
		//		|| {alpha,beta,ii,jj|-alpha+2beta+1==0 && alpha-1>=0 && ii>=0 && -ii+2jj-b>=0 && -alpha+2M-1>=0 && -jj+b-1>=0}
		//		|| {alpha,beta,ii,jj|beta-M==0 && alpha-M-1>=0 && ii>=0 && jj>=0 && -ii+b-1>=0 && -jj+b-1>=0 && -alpha+2M-1>=0 && -jj+mm-1>=0}
		//		|| {alpha,beta,ii,jj|alpha-beta-1>=0 && ii>=0 && jj>=0 && -ii+b-1>=0 && -jj+b-1>=0 && -alpha+2beta-1>=0 && -beta+M-1>=0}
		
		
		// OLD RESULT (with N multiple of b):
		// - Normal scaling factor
		// {alpha,beta,ii,jj|beta==0 && alpha==0 && ii-jj>=0 && M-1>=0 && -ii+2jj>=0 && -ii+b-1>=0}
		//		|| {alpha,beta,ii,jj|-alpha+beta==0 && ii-jj>=0 && alpha-1>=0 && jj>=0 && -ii+b-1>=0 && -alpha+M-1>=0}
		//		|| {alpha,beta,ii,jj|-alpha+2beta==0 && alpha-2>=0 && ii>=0 && -alpha+2M-2>=0 && -ii+b-1>=0 && -jj+b-1>=0 && -ii+2jj>=0}
		//		|| {alpha,beta,ii,jj|-alpha+2beta+1==0 && alpha-1>=0 && ii>=0 && -ii+2jj-b>=0 && -alpha+2M-1>=0 && -jj+b-1>=0}
		//		|| {alpha,beta,ii,jj|alpha-beta-1>=0 && ii>=0 && jj>=0 && -ii+b-1>=0 && -jj+b-1>=0 && -alpha+2beta-1>=0 && -beta+M-1>=0}
		//
		// - Scaling factor: i:2 / j:1
		// {alpha,beta,ii,jj|beta==0 && alpha==0 && ii-jj>=0 && -jj+b-1>=0 && -ii+2jj>=0 && M-1>=0}
		//		|| {alpha,beta,ii,jj|-2alpha+beta==0 && ii-jj>=0 && -2alpha+M-1>=0 && jj>=0 && -ii+2b-1>=0 && -jj+b-1>=0 && alpha-1>=0}
		//		|| {alpha,beta,ii,jj|-2alpha+beta-1==0 && ii-jj-b>=0 && alpha>=0 && jj>=0 && -ii+2b-1>=0 && -2alpha+M-2>=0}
		//		|| {alpha,beta,ii,jj|-alpha+beta==0 && alpha-1>=0 && ii>=0 && -ii+2jj>=0 && -alpha+M-1>=0 && -jj+b-1>=0}
		//		|| {alpha,beta,ii,jj|2alpha-beta-1>=0 && ii>=0 && jj>=0 && -ii+2b-1>=0 && -jj+b-1>=0 && -alpha+beta-1>=0 && -beta+M-1>=0}
	}
	
	@Test
	public void test3_getTiledDomain_squareCase() {
		List<String> paramScal3 = new BasicEList<String>();
		paramScal3.add("N"); paramScal3.add("M");
		
		List<String> blockIndName3 = new BasicEList<String>();
		blockIndName3.add("alpha"); blockIndName3.add("beta");
		
		List<String> localIndName3 = new BasicEList<String>();
		localIndName3.add("ii"); localIndName3.add("jj");
		
		List<String> blockParamName3 = new BasicEList<String>();
		blockParamName3.add("Nb"); blockParamName3.add("Mb");
		
		List<String> localParamName3 = new BasicEList<String>();
		localParamName3.add("nn"); localParamName3.add("mm");
		
		List<Integer> scale3 = new BasicEList<Integer>();
		scale3.add(1); scale3.add(1);
		
		List<Integer> lMinBlParam = new BasicEList<Integer>();
		lMinBlParam.add(0); lMinBlParam.add(0);
		
		parseAndGetBlockedDomain("{i,j | 2i+j>=0 && N+M-2i>=0 }", paramScal3, blockIndName3, localIndName3,
				blockParamName3, localParamName3, scale3, "b", 1, lMinBlParam);
		// 		   {alpha,beta,ii,jj|beta+Nb+Mb==0 && 2alpha-Nb-Mb+1==0 && 2ii+jj-b>=0 && -2ii+nn+mm+b>=0 && jj>=0 && -ii+b-1>=0 && -jj+b-1>=0}
		//		|| {alpha,beta,ii,jj|beta+Nb+Mb+1==0 && 2alpha-Nb-Mb==0 && 2ii+jj-b>=0 && -2ii+nn+mm>=0 && jj>=0 && -ii+b-1>=0 && -jj+b-1>=0}
		//		|| {alpha,beta,ii,jj|beta+Nb+Mb+2==0 && 2alpha-Nb-Mb-1==0 && 2ii+jj-b>=0 && -2ii+nn+mm-b>=0 && jj>=0 && -ii+b-1>=0 && -jj+b-1>=0}
		//		|| {alpha,beta,ii,jj|2alpha+beta+1==0 && 2ii+jj-b>=0 && -2alpha+Nb+Mb-2>=0 && jj>=0 && -ii+b-1>=0 && -jj+b-1>=0}
		//		|| {alpha,beta,ii,jj|beta+Nb+Mb+1==0 && 2alpha-Nb-Mb+1==0 && 2ii+jj-2b>=0 && -jj+b-1>=0 && -2ii+nn+mm+b>=0 && -ii+b-1>=0}
		//		|| {alpha,beta,ii,jj|beta+Nb+Mb+2==0 && 2alpha-Nb-Mb==0 && 2ii+jj-2b>=0 && -jj+b-1>=0 && -2ii+nn+mm>=0 && -ii+b-1>=0}
		//		|| {alpha,beta,ii,jj|beta+Nb+Mb+3==0 && 2alpha-Nb-Mb-1==0 && 2ii+jj-2b>=0 && -jj+b-1>=0 && -2ii+nn+mm-b>=0 && -ii+b-1>=0}
		//		|| {alpha,beta,ii,jj|2alpha+beta+2==0 && 2ii+jj-2b>=0 && -jj+b-1>=0 && -2alpha+Nb+Mb-2>=0 && -ii+b-1>=0}
		//		|| {alpha,beta,ii,jj|2alpha-Nb-Mb+1==0 && beta+Nb+Mb-1>=0 && ii>=0 && jj>=0 && -ii+b-1>=0 && -jj+b-1>=0 && -2ii+nn+mm+b>=0}
		//		|| {alpha,beta,ii,jj|2alpha-Nb-Mb==0 && beta+Nb+Mb>=0 && ii>=0 && jj>=0 && -ii+b-1>=0 && -jj+b-1>=0 && -2ii+nn+mm>=0}
		//		|| {alpha,beta,ii,jj|2alpha-Nb-Mb-1==0 && beta+Nb+Mb+1>=0 && ii>=0 && jj>=0 && -ii+b-1>=0 && -jj+b-1>=0 && -2ii+nn+mm-b>=0}
		//		|| {alpha,beta,ii,jj|2alpha+beta>=0 && ii>=0 && jj>=0 && -ii+b-1>=0 && -jj+b-1>=0 && -2alpha+Nb+Mb-2>=0}
		
		
		
		// OLD RESULT (N and M multiples of b):
		// {alpha,beta,ii,jj|beta+Nb+Mb==0 && 2alpha-Nb-Mb+1==0 && 2ii+jj-b>=0 && -2ii+b>=0 && -jj+b-1>=0}
		//		|| {alpha,beta,ii,jj|2alpha+beta+1==0 && 2ii+jj-b>=0 && -2alpha+Nb+Mb-2>=0 && jj>=0 && -ii+b-1>=0 && -jj+b-1>=0}
		//		|| {alpha,beta,ii,jj|2alpha+beta+2==0 && 2ii+jj-2b>=0 && -jj+b-1>=0 && -2alpha+Nb+Mb-2>=0 && -ii+b-1>=0}
		//		|| {alpha,beta,ii,jj|2alpha-Nb-Mb+1==0 && beta+Nb+Mb-1>=0 && ii>=0 && jj>=0 && -2ii+b>=0 && -jj+b-1>=0}
		//		|| {alpha,beta,ii,jj|ii==0 && 2alpha-Nb-Mb==0 && beta+Nb+Mb>=0 && -jj+b-1>=0 && jj>=0}
		//		|| {alpha,beta,ii,jj|2alpha+beta>=0 && ii>=0 && jj>=0 && -ii+b-1>=0 && -jj+b-1>=0 && -2alpha+Nb+Mb-2>=0}
	}
	
	@Test
	public void test4_getTiledDomain_squareCase() {
		List<String> paramScal4 = new BasicEList<String>();
		List<String> blockIndName4 = new BasicEList<String>(); blockIndName4.add("alpha"); blockIndName4.add("beta");
		List<String> localIndName4 = new BasicEList<String>(); localIndName4.add("ii"); localIndName4.add("jj");
		List<String> blockParamName4 = new BasicEList<String>();
		List<String> localParamName4 = new BasicEList<String>();
		List<Integer> scale4 = new BasicEList<Integer>(); scale4.add(1); scale4.add(1);
		List<Integer> lMinBlParam = new BasicEList<Integer>();
		parseAndGetBlockedDomain("{i,j | 0<=i,j}", paramScal4, blockIndName4, localIndName4, blockParamName4, localParamName4, scale4, "b", 1, lMinBlParam);
	}
	
	@Test
	public void test5_getTiledDomain_squareCase() {
		List<String> paramScal5 = new BasicEList<String>(); paramScal5.add("N");
		List<String> blockIndName5 = new BasicEList<String>(); blockIndName5.add("tB"); blockIndName5.add("iB");
		List<String> localIndName5 = new BasicEList<String>(); localIndName5.add("tL"); localIndName5.add("iL");
		List<String> blockParamName5 = new BasicEList<String>(); blockParamName5.add("NB");
		List<String> localParamName5 = new BasicEList<String>(); localParamName5.add("Nl");
		List<Integer> scale5 = new BasicEList<Integer>(); scale5.add(1); scale5.add(1);
		List<Integer> lMinBlParam = new BasicEList<Integer>(); lMinBlParam.add(1);
		parseAndGetBlockedDomain("{t,i|t > 0 && 0==i } || {t,i|t > 0 && i==N-1 }", paramScal5, blockIndName5,
				localIndName5, blockParamName5, localParamName5, scale5, "b", 1, lMinBlParam);
		// Result:
		// {tB,iB,tL,iL|iL==0 && iB==0 && -tL+b-1>=0 && tL>=0 && tB+tL-1>=0 && tB>=0}
		//	|| {tB,iB,tL,iL|iB-NB+1==0 && iL-Nl-b+1>=0 && tL>=0 && -iL+b-1>=0 && iL>=0 && tB>=0 && -tL+b-1>=0 && tB+tL-1>=0}
		//	|| {tB,iB,tL,iL|iL-Nl+1==0 && iB-NB==0 && -Nl+b>=0 && tL>=0 && Nl-1>=0 && tB>=0 && -tL+b-1>=0 && tB+tL-1>=0}
	}
	
	@Test
	public void test6_getTiledDomain_squareCase() {
		List<String> paramScal6 = new BasicEList<String>(); paramScal6.add("N");
		List<String> blockIndName6 = new BasicEList<String>(); blockIndName6.add("tB"); blockIndName6.add("iB");
		List<String> localIndName6 = new BasicEList<String>(); localIndName6.add("tL"); localIndName6.add("iL");
		List<String> blockParamName6 = new BasicEList<String>(); blockParamName6.add("NB");
		List<String> localParamName6 = new BasicEList<String>(); localParamName6.add("Nl");
		List<Integer> scale6 = new BasicEList<Integer>(); scale6.add(1); scale6.add(1);
		List<Integer> lMinBlParam = new BasicEList<Integer>(); lMinBlParam.add(1);
		parseAndGetBlockedDomain("{t,i|t > 0 && 0==i } || {t,i|t > 0 && i==N-1 }", paramScal6, blockIndName6,
				localIndName6, blockParamName6, localParamName6, scale6, "b", 1, lMinBlParam);
	}
	
	@Test
	public void test7_getTiledDomain_squareCase() {
		List<String> paramScal7 = new BasicEList<String>(); paramScal7.add("N");
		List<String> blockIndName7 = new BasicEList<String>(); blockIndName7.add("iB"); blockIndName7.add("jB");
		List<String> localIndName7 = new BasicEList<String>(); localIndName7.add("iL"); localIndName7.add("jL");
		List<String> blockParamName7 = new BasicEList<String>(); blockParamName7.add("NB");
		List<String> localParamName7 = new BasicEList<String>(); localParamName7.add("Nl");
		List<Integer> scale7 = new BasicEList<Integer>(); scale7.add(2); scale7.add(1);
		List<Integer> lMinBlParam = new BasicEList<Integer>(); lMinBlParam.add(1);
		parseAndGetBlockedDomain("{i,j|0<=(i,j)<N }", paramScal7, blockIndName7,
				localIndName7, blockParamName7, localParamName7, scale7, "b", 3, lMinBlParam);
	}
	
	@Test
	public void test8_getTiledDomain_squareCase() {
		List<String> paramScal8 = new BasicEList<String>(); paramScal8.add("N");
		List<String> blockIndName8 = new BasicEList<String>(); blockIndName8.add("iB"); blockIndName8.add("jB"); blockIndName8.add("tB");
		List<String> localIndName8 = new BasicEList<String>(); localIndName8.add("iL"); localIndName8.add("jL"); localIndName8.add("tL");
		List<String> blockParamName8 = new BasicEList<String>(); blockParamName8.add("NB");
		List<String> localParamName8 = new BasicEList<String>(); localParamName8.add("Nl");
		List<Integer> scale8 = new BasicEList<Integer>(); scale8.add(1); scale8.add(1); scale8.add(1);
		List<Integer> lMinBlParam = new BasicEList<Integer>(); lMinBlParam.add(1);
		parseAndGetBlockedDomain("{i,j,t | 1<=t==j<i && j+N-2>=i }", paramScal8, blockIndName8,
				localIndName8, blockParamName8, localParamName8, scale8, "b", 3, lMinBlParam);
	}
	
	@Test
	public void test9_getTiledDomain_squareCase() {
		List<String> paramScal9 = new BasicEList<String>(); paramScal9.add("N");
		List<String> blockIndName9 = new BasicEList<String>(); blockIndName9.add("iB"); blockIndName9.add("jB");
		List<String> localIndName9 = new BasicEList<String>(); localIndName9.add("iL"); localIndName9.add("jL");
		List<String> blockParamName9 = new BasicEList<String>(); blockParamName9.add("NB");
		List<String> localParamName9 = new BasicEList<String>(); localParamName9.add("Nl");
		List<Integer> scale9 = new BasicEList<Integer>(); scale9.add(1); scale9.add(1);
		List<Integer> lMinBlParam = new BasicEList<Integer>(); lMinBlParam.add(1);
		parseAndGetBlockedDomain("{i,j| j<=i<2N+j && 0<=j<N }", paramScal9, blockIndName9,
				localIndName9, blockParamName9, localParamName9, scale9, "b", 1, lMinBlParam);
	}
	
	
	
	// "Square" tiling for affine function
	private static void parseAndGetBlockedFunction(List<String> funcStr, List<String> indScalName, List<String> paramScalName, List<String> blockIndName,
			List<String> localIndName, List<String> blockParamName, List<String> localParamName, List<Integer> scale, List<Integer> scaleIm,
			String blSizeParamName, int minb) {
		
		DimensionsManager _dimMana = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
		
		List<Variable> lparamScal = new BasicEList<Variable>();
		for (int i=0; i<paramScalName.size(); i++)
			lparamScal.add(_dimMana.getParameter(i, paramScalName.get(i)));
		List<Variable> lindScal = new BasicEList<Variable>();
		for (int i=0; i<indScalName.size(); i++)
			lindScal.add(_dimMana.getDimension(i, indScalName.get(i)));
		
		AffineFunction funcScal = PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(PolyhedralIRUtility.parseFunction(lparamScal, lindScal, funcStr));
		
		List<Variable> blockInd = new BasicEList<Variable>();
		for (int i=0; i<blockIndName.size(); i++)
			blockInd.add(_dimMana.getDimension(i, blockIndName.get(i)));
		List<Variable> localInd = new BasicEList<Variable>();
		for (int i=0; i<localIndName.size(); i++)
			localInd.add(_dimMana.getDimension(i+blockInd.size(), localIndName.get(i)));
		List<Variable> blockParam = new BasicEList<Variable>();
		for (int i=0; i<blockParamName.size(); i++)
			blockParam.add(_dimMana.getParameter(i, blockParamName.get(i)));
		List<Variable> localParam = new BasicEList<Variable>();
		for (int i=0; i<localParamName.size(); i++)
			localParam.add(_dimMana.getParameter(i+blockParamName.size(), localParamName.get(i)));
		Variable blSizeParam = _dimMana.getParameter(blockParamName.size()+localParamName.size(), blSizeParamName);
		
		Map<FastISLDomain,FastISLMap> funcTiled = CARTOperations.getTiledFunction(funcScal, blockInd, localInd, blockParam, localParam, scale, scaleIm,
				blSizeParam, false, minb);
		System.out.println();
		System.out.println();
		System.out.println("**********************************************");
		for (Domain cond : funcTiled.keySet())
			System.out.println("IF " + cond.toString() + " THEN " + funcTiled.get(cond).toString());
	}
	
	@Test
	public void test1_getTiledFunction_squareCase() {
		List<String> indScalName = new BasicEList<String>();
		indScalName.add("i"); indScalName.add("j");
		
		List<String> blockIndName = new BasicEList<String>();
		blockIndName.add("alpha"); blockIndName.add("beta");
		List<String> localIndName = new BasicEList<String>();
		localIndName.add("ii"); localIndName.add("jj");
		
		List<String> paramScalName = new BasicEList<String>();
		paramScalName.add("N");
		
		List<String> blockParamName = new BasicEList<String>();
		blockParamName.add("M");
		List<String> localParamName = new BasicEList<String>();
		localParamName.add("mm");
		
		List<Integer> scale = new BasicEList<Integer>();
		scale.add(1); scale.add(1);
		
		List<Integer> scaleIm = new BasicEList<Integer>();
		scaleIm.add(1); scaleIm.add(1);
		
		List<String> funcStr = new BasicEList<String>();
		funcStr.add("i+j");
		funcStr.add("N+j");
		
		parseAndGetBlockedFunction(funcStr, indScalName, paramScalName, blockIndName, localIndName, blockParamName, localParamName, scale, scaleIm, "b", 1);
		// IF {alpha,beta,ii,jj|ii+jj>=0 && jj+mm>=0 && -ii-jj+b-1>=0 && -jj-mm+b-1>=0 && ii>=0 && jj>=0 && -ii+b-1>=0 && -jj+b-1>=0} THEN (alpha,beta,ii,jj->alpha+beta,M+beta,ii+jj,mm+jj)
		// IF {alpha,beta,ii,jj|ii+jj>=0 && jj+mm-b>=0 && -ii-jj+b-1>=0 && -jj-mm+2b-1>=0 && ii>=0 && jj>=0 && -ii+b-1>=0 && -jj+b-1>=0} THEN (alpha,beta,ii,jj->alpha+beta,M+beta+1,ii+jj,mm-b+jj)
		// IF {alpha,beta,ii,jj|ii+jj-b>=0 && jj+mm-b>=0 && -ii-jj+2b-1>=0 && -jj-mm+2b-1>=0 && ii>=0 && jj>=0 && -ii+b-1>=0 && -jj+b-1>=0} THEN (alpha,beta,ii,jj->alpha+beta+1,M+beta+1,-b+ii+jj,mm-b+jj)
		// IF {alpha,beta,ii,jj|ii+jj-b>=0 && jj+mm>=0 && -ii-jj+2b-1>=0 && -jj-mm+b-1>=0 && ii>=0 && jj>=0 && -ii+b-1>=0 && -jj+b-1>=0} THEN (alpha,beta,ii,jj->alpha+beta+1,M+beta,-b+ii+jj,mm+jj)
	}
	
	@Test
	public void test2_getTiledFunction_squareCase() {
		List<String> indScalName2 = new BasicEList<String>();
		indScalName2.add("i"); indScalName2.add("j");
		
		List<String> blockIndName2 = new BasicEList<String>();
		blockIndName2.add("alpha"); blockIndName2.add("beta");
		
		List<String> localIndName2 = new BasicEList<String>();
		localIndName2.add("ii"); localIndName2.add("jj");
		
		List<String> paramScalName2 = new BasicEList<String>();
		paramScalName2.add("N");
		
		List<String> blockParamName2 = new BasicEList<String>();
		blockParamName2.add("M");
		List<String> localParamName2 = new BasicEList<String>();
		localParamName2.add("mm");
		
		List<Integer> scale2 = new BasicEList<Integer>();
		scale2.add(1); scale2.add(1);
		
		List<Integer> scaleIm2 = new BasicEList<Integer>();
		scaleIm2.add(1); scaleIm2.add(1);
		
		List<String> funcStr2 = new BasicEList<String>();
		funcStr2.add("i-1");
		funcStr2.add("j-1");
		
		parseAndGetBlockedFunction(funcStr2, indScalName2, paramScalName2, blockIndName2, localIndName2, blockParamName2, localParamName2,
				scale2, scaleIm2, "b", 1);
		// IF {alpha,beta,ii,jj|ii==0 && b-1>=0 && jj-1>=0 && -jj+b-1>=0} THEN (alpha,beta,ii,jj->alpha-1,beta,b+ii-1,jj-1)
		// IF {alpha,beta,ii,jj|jj==0 && ii-1>=0 && b-1>=0 && -ii+b-1>=0} THEN (alpha,beta,ii,jj->alpha,beta-1,ii-1,b+jj-1)
		// IF {alpha,beta,ii,jj|jj==0 && ii==0 && b-1>=0} THEN (alpha,beta,ii,jj->alpha-1,beta-1,b+ii-1,b+jj-1)
		// IF {alpha,beta,ii,jj|ii-1>=0 && jj-1>=0 && -ii+b-1>=0 && -jj+b-1>=0} THEN (alpha,beta,ii,jj->alpha,beta,ii-1,jj-1)
	}
	
	@Test
	public void test3_getTiledFunction_squareCase() {
		List<String> indScalName3 = new BasicEList<String>();
		indScalName3.add("i"); indScalName3.add("j");
		
		List<String> blockIndName3 = new BasicEList<String>();
		blockIndName3.add("alpha"); blockIndName3.add("beta");
		
		List<String> localIndName3 = new BasicEList<String>();
		localIndName3.add("ii"); localIndName3.add("jj");
		
		List<String> paramScalName3 = new BasicEList<String>();
		List<String> blockParamName3 = new BasicEList<String>();
		List<String> localParamName3 = new BasicEList<String>();
		
		List<Integer> scale3 = new BasicEList<Integer>();
		scale3.add(2); scale3.add(2);
		
		List<Integer> scaleIm3 = new BasicEList<Integer>();
		scaleIm3.add(2); scaleIm3.add(1);
		
		List<String> funcStr3 = new BasicEList<String>();
		funcStr3.add("i");
		funcStr3.add("j");
		
		parseAndGetBlockedFunction(funcStr3, indScalName3, paramScalName3, blockIndName3, localIndName3, blockParamName3, localParamName3,
				scale3, scaleIm3, "b", 3);
	}
	
	
	// "Square" tiling for parametric domain
	@Test
	public void test_paramDomainTiling() {
		
		ParameterDomain parDom = PolyhedralIRUtility.parseParameterDomain("{N,M | N>=2 && M>=2}");
		
		DimensionsManager _dimMana = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
		
		List<Variable> blockParam = new BasicEList<Variable>();
		for (int i=0; i<2; i++)
			blockParam.add(_dimMana.getDimension(i, parDom.getParamNames().get(i) + "b"));
		List<Variable> localParam = new BasicEList<Variable>();
		for (int i=0; i<2; i++)
			localParam.add(_dimMana.getDimension(i+2, parDom.getParamNames().get(i) + "l"));
		Variable blSizeParam = _dimMana.getParameter(4, "b");
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		lParamMin.add(1);
		lParamMin.add(0);
		
		
		ParameterDomain paraDomBl = CARTOperations.getTiledParameterDomain(parDom, blockParam, localParam, blSizeParam, false, 3, lParamMin);
		System.out.println();
		System.out.println();
		System.out.println("**********************************************");
		System.out.println(paraDomBl.toString());
	}
	
	/* -------------------------- */
	
	// Full program transformation (simplified version)
	private static void parseAndTransformProgram(String filename, Map<String,Map<String,List<Integer>>> lscaleInputs, boolean paramDiv,
			int minB, List<Integer> minBlParam) {
		Program program = alphaz.mde.Basic.ReadAlphabets(filename);
		
		ParametricTiling.parametricTiling_noOutlining(program, "b", lscaleInputs, paramDiv, minB, minBlParam);
		
		System.out.println(PolyhedralIRToAlphabets.toString(program));
		System.out.println();
		//Normalize.normalize(program);
		//System.out.println();
		
		System.out.println(UniquenessAndCompletenessCheck.validate(program).toString());
		System.out.println(AShow.toString(program));
	}
	
	@Test
	public void test1_transformation() {
		Map<String, Map<String,List<Integer>>> scaleInputs = new HashMap<String, Map<String,List<Integer>>>();
		List<Integer> minBlParam = new BasicEList<Integer>();
		minBlParam.add(1); minBlParam.add(1); minBlParam.add(1);
		
		parseAndTransformProgram("testcases/matrix_product_withReduce/matrix_product_withReduce.ab", scaleInputs, true, 1, minBlParam);
		
		/* SIMPLIFIED RESULT: if we assume [Pl=Ql=Rl=0] and simplify the corresponding expressions
		affine matrix_product_withReduce {Pb,Qb,Rb,b | Rb>=1 && Qb>=1 && Pb>=1}
		input
			float A_bl {iBl,kBl,iLoc,kLoc | Rb==0 && Rl>=1 && 0<=iBl<=Pb-1 && 0<=kBl<=Qb-1 && 0<=iLoc<=b-1 && 0<=kLoc<=b-1 }
					|| {iBl,kBl,iLoc,kLoc | Rb>=1 && 0<=iBl<=Pb-1 && 0<=kBl<=Qb-1 && 0<=iLoc<=b-1 && 0<=kLoc<=b-1 };
			float B_bl {kBl,jBl,kLoc,jLoc | Pb>=1 && 0<=kBl<=Qb-1 && 0<=jBl<=Rb-1 && 0<=kLoc<=b-1 && 0<=jLoc<=b-1 }
					|| {kBl,jBl,kLoc,jLoc | Pb==0 && Pl>=1 && 0<=kBl<=Qb-1 && 0<=jBl<=Rb-1 && 0<=kLoc<=b-1 && 0<=jLoc<=b-1 };
		output
			float C_bl {iBl,jBl,iLoc,jLoc | Qb>=1 && 0<=iBl<=Pb-1 && 0<=jBl<=Rb-1 && 0<=iLoc<=b-1 && 0<=jLoc<=b-1 }
					|| {iBl,jBl,iLoc,jLoc | Qb==0 && Ql>=1 && 0<=iBl<=Pb-1 && 0<=jBl<=Rb-1 && 0<=iLoc<=b-1 && 0<=jLoc<=b-1 };
		let
			C_bl[pBl,qBl,pLoc,qLoc] = reduce(+, (pBl,qBl,rBl,pLoc,qLoc,rLoc->pBl,qBl,pLoc,qLoc),
								{pBl,qBl,rBl,pLoc,qLoc,rLoc| 0 <= (pLoc,qLoc,rLoc) <= b-1 } : (A_bl[pBl,rBl,pLoc,rLoc] * B_bl[rBl,qBl,rLoc,qLoc] )
									);
		.
		*/
	}
	
	@Test
	public void test1B_transformation() {
		Map<String, Map<String,List<Integer>>> scaleInputs = new HashMap<String, Map<String,List<Integer>>>();
		List<Integer> minBlParam = new BasicEList<Integer>();
		minBlParam.add(1); minBlParam.add(1); minBlParam.add(1);
		
		parseAndTransformProgram("testcases/matrix_product/matrix_product.ab", scaleInputs, true, 2, minBlParam);
	}
	
	@Test
	public void test2_transformation() {
		Map<String, Map<String,List<Integer>>> scaleInputs2 = new HashMap<String, Map<String,List<Integer>>>();
		
		Map<String, List<Integer>> scaleChol = new HashMap<String, List<Integer>>();
		
		List<Integer> lscalesA = new BasicEList<Integer>();
		lscalesA.add(1); lscalesA.add(1);
		scaleChol.put("A", lscalesA);
		List<Integer> lscalesL = new BasicEList<Integer>();
		lscalesL.add(1); lscalesL.add(1);
		scaleChol.put("L", lscalesL);
		
		scaleInputs2.put("cholesky_withReduce", scaleChol);
		
		
		List<Integer> minBlParam = new BasicEList<Integer>();
		minBlParam.add(1);
		
		parseAndTransformProgram("testcases/cholesky_withReduce/cholesky_withReduce.ab", scaleInputs2, true, 3, minBlParam);
	}
	
	@Test
	public void test2B_transformation() {
		Map<String, Map<String,List<Integer>>> scaleInputs2 = new HashMap<String, Map<String,List<Integer>>>();
		List<Integer> minBlParam = new BasicEList<Integer>();
		minBlParam.add(1);
		
		parseAndTransformProgram("testcases/cholesky/cholesky_noReduce.ab", scaleInputs2, true, 3, minBlParam);
	}
	
	@Test
	public void test3_transformation() {
		Map<String, Map<String,List<Integer>>> scaleInputs3 = new HashMap<String, Map<String,List<Integer>>>();
		
		List<Integer> minBlParam = new BasicEList<Integer>();
		minBlParam.add(1); minBlParam.add(1);
		
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/EnerySavingExamples/jacobi_1d/jacobi_1d.ab");
		AffineFunction fSkewing = PolyhedralIRUtility.parseAffineFunction(program.getSystems().get(0).getParameters(), "(t,i->t,i+t)");
		ChangeOfBasis.CoB(program.getSystems().get(0), "temp_B", fSkewing);
		Normalize.normalize(program);
		//Program program = alphaz.mde.Basic.ReadAlphabets("testcases/jacobi_1d/jacobi_1d.ab");
		
		ParametricTiling.parametricTiling_noOutlining(program, "b", scaleInputs3, true, 6, minBlParam);
		
		System.out.println(PolyhedralIRToAlphabets.toString(program));
		System.out.println();
		//Normalize.normalize(program);
		//System.out.println();
		
		System.out.println(UniquenessAndCompletenessCheck.validate(program).toString());
		System.out.println(AShow.toString(program));
	}
	
	@Test
	public void test4_transformation() {
		Map<String, Map<String,List<Integer>>> scaleInputs4 = new HashMap<String, Map<String,List<Integer>>>();
		
		List<Integer> minBlParam = new BasicEList<Integer>();
		minBlParam.add(1); minBlParam.add(1);
		
		parseAndTransformProgram("testcases/smith_waterman/smith_waterman.ab", scaleInputs4, true, 1, minBlParam);
	}
	
	@Test
	public void test5_transformation() {
		Map<String, Map<String,List<Integer>>> scaleInputs5 = new HashMap<String, Map<String,List<Integer>>>();
		
		List<Integer> minBlParam = new BasicEList<Integer>();
		minBlParam.add(1);
		
		parseAndTransformProgram("testcases/fibonacci/fibonacci.ab", scaleInputs5, true, 1, minBlParam);
		
	}
	
	@Test
	public void test6_transformation() {
		Map<String, Map<String,List<Integer>>> scaleInputs6 = new HashMap<String, Map<String,List<Integer>>>();
		
		List<Integer> minBlParam = new BasicEList<Integer>();
		minBlParam.add(1);
		
		parseAndTransformProgram("testcases/lud/lud.ab", scaleInputs6, true, 2, minBlParam);
	}
	
	@Test
	public void test7_transformation() {
		Map<String, Map<String,List<Integer>>> scaleInputs7 = new HashMap<String, Map<String,List<Integer>>>();
		
		List<Integer> minBlParam = new BasicEList<Integer>();
		minBlParam.add(1); minBlParam.add(1);
		
		parseAndTransformProgram("alphabets/SubSystemExamples/Benchmark_CART/Jacobi1D/Jacobi1D_Skewed/Jacobi1D_Skewed.ab", scaleInputs7, true, 3, minBlParam);
	}
	
	@Test
	public void test8_transformation() {
		Map<String, Map<String,List<Integer>>> scaleInputs8 = new HashMap<String, Map<String,List<Integer>>>();
		
		List<Integer> minBlParam = new BasicEList<Integer>();
		minBlParam.add(1);
		
		parseAndTransformProgram("alphabets/SubSystemExamples/Benchmark_CART/ForwardSubst/ForwardSubst.ab", scaleInputs8, true, 1, minBlParam);
	}
	
	@Test
	public void test9_transformation() {
		Map<String, Map<String,List<Integer>>> scaleInputs9 = new HashMap<String, Map<String,List<Integer>>>();
		
		List<Integer> minBlParam = new BasicEList<Integer>();
		minBlParam.add(1);
		
		parseAndTransformProgram("alphabets/SubSystemExamples/Benchmark_CART/BackwardSubst/BackwardSubst.ab", scaleInputs9, true, 1, minBlParam);
	}
	
	@Test
	public void test10_transformation() {
		// WARNING: TAKE A LOT OF TIME (~ 1 min in my machine) / MEMORY (~ 2GB)
		
		Map<String, Map<String,List<Integer>>> scaleInputs10 = new HashMap<String, Map<String,List<Integer>>>();
		
		List<Integer> minBlParam = new BasicEList<Integer>();
		minBlParam.add(1); minBlParam.add(1); minBlParam.add(1);
		
		parseAndTransformProgram("alphabets/SubSystemExamples/Benchmark_CART/Jacobi2D/Jacobi2D_Skewed.ab", scaleInputs10, true, 3, minBlParam);
	}
	
	@Test
	public void test10B_transformation() {
		// WARNING: TAKE A LOT OF TIME (~ 1 min in my machine) / MEMORY (~ 2GB)
		
		Map<String, Map<String,List<Integer>>> scaleInputs10 = new HashMap<String, Map<String,List<Integer>>>();
		
		List<Integer> minBlParam = new BasicEList<Integer>();
		minBlParam.add(3); minBlParam.add(3); minBlParam.add(2);
		
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/SubSystemExamples/Benchmark_CART/stencil2D_5points/stencil2D_5points_skewed.ab");
		//AffineFunction fSkewing = PolyhedralIRUtility.parseAffineFunction(program.getSystems().get(0).getParameters(), "(t,i,j->t,i+t,j+t)");
		//ChangeOfBasis.CoB(program.getSystems().get(0), "temp_B", fSkewing);
		//Normalize.normalize(program);
		
		ParametricTiling.parametricTiling_noOutlining(program, "b", scaleInputs10, true, 6, minBlParam);
		
		System.out.println(PolyhedralIRToAlphabets.toString(program));
		System.out.println();
		
	}
	
	@Test
	public void test11_transformation() {
		// WARNING: TAKE A LOT OF TIME (~ 1 min in my machine) / MEMORY (~ 2GB)
		
		Map<String, Map<String,List<Integer>>> scaleInputs11 = new HashMap<String, Map<String,List<Integer>>>();
		
		List<Integer> minBlParam = new BasicEList<Integer>();
		minBlParam.add(1); minBlParam.add(1); minBlParam.add(1);
		
		parseAndTransformProgram("alphabets/SubSystemExamples/Benchmark_CART/stencil2D_5points/stencil2D_5points_skewed.ab", scaleInputs11, true, 3, minBlParam);
	}
	
	// Test proposal
	@Test
	public void testGlobalTimeTaken_J1DScheduleC() {
		int scaleI = 1;
		int scaleT = 1;
		
		Map<String, Map<String,List<Integer>>> scaleInputs7 = new HashMap<String, Map<String,List<Integer>>>();
		Map<String,List<Integer>> scaleGrp = new HashMap<String, List<Integer>>();
		
		List<Integer> lScaleTemp = new BasicEList<Integer>(); lScaleTemp.add(scaleI); lScaleTemp.add(scaleT);
		scaleGrp.put("temp", lScaleTemp);
		List<Integer> lScaleB = new BasicEList<Integer>(); lScaleB.add(scaleI);
		scaleGrp.put("B", lScaleB);
		
		scaleInputs7.put("Jacobi1D",scaleGrp);
		
		
		List<Integer> minBlParam = new BasicEList<Integer>();
		minBlParam.add(3); minBlParam.add(3);
		String nameFileCodeGen = "Jacobi1D_" + scaleI + "_" + scaleT;
		String genCodeFile = "alphabets/SubSystemExamples/Benchmark_CART/WriteCTest/GenCode/" + nameFileCodeGen + "/";
		
		
		long _starttime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/SubSystemExamples/Benchmark_CART/Jacobi1D/Jacobi1D_Skewed/Jacobi1D_Skewed.ab");
		AffineSystem syst = program.getSystems().get(0);
		String systName = syst.getName();
		
		long currentTime = System.currentTimeMillis() - _starttime;
		long mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Parsing done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		ParametricTiling.parametricTiling_noOutlining(program, "b", scaleInputs7, true, 5, minBlParam);
		
		Basic.ASave(program, genCodeFile+systName+".ab");
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Transformation done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		// *** TargetMapping: 
		org.polymodel.polyhedralIR.targetMapping.TargetMapping tm = syst.getTargetMapping();
		
		//setSpaceTimeMap(prog, syst, 0, "temp_bl", "(iBl,tBl,iLoc,tLoc-> 0,iBl+tBl,tBl,iLoc+tLoc,tLoc)");
		VariableDeclaration varDeclTempBl = syst.getVariableDeclaration("temp_bl");
		//AffineFunction stmapTempBl = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(iBl,tBl,iLoc,tLoc->0,iBl+tBl,tBl,iLoc+tLoc,tLoc)");
		AffineFunction stmapTempBl = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(iBl,tBl,iLoc,tLoc->0,tBl,iBl,tLoc,iLoc)");
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("temp_bl",
				TargetMappingUserFactory.createStandardEquationSpaceTimeMap(varDeclTempBl, stmapTempBl));

		//setSpaceTimeMap(prog, syst, 0, "B_bl", "(iBl,iLoc-> 1,iBl,iLoc,0,0)");
		VariableDeclaration varDeclBBl = syst.getVariableDeclaration("B_bl");
		AffineFunction stmapBBl = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(iBl,iLoc->1,iBl,iLoc,0,0)");
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("B_bl",
				TargetMappingUserFactory.createStandardEquationSpaceTimeMap(varDeclBBl, stmapBBl));
		
		//setOrderingDimensions(prog,syst,"0");
		tm.getSpaceTimeLevel(0).getOrderingDimensions().add(0);
		
		//setParallel(prog,syst,"0","1,3");
		//List<Integer> prefix = new BasicEList<Integer>(); prefix.add(0);
		//List<Integer> dims = new BasicEList<Integer>(); dims.add(1); dims.add(3);
		//ParallelizationSpecification parallelSpecif = TargetMappingUserFactory.createParallelizationSpecification(prefix, dims);
		//tm.getSpaceTimeLevel(0).getParallelizationSpecifications().add(parallelSpecif);
		
		// iBl,tBl%2, iLoc,tLoc
		// How to get a better memory allocation => By copying the 2 columns needed at the input of a tile in a different variable
		//		(which is kind of done during the outlining transformation)
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "TargetMapping defined" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		
		// *** ScheduleC
		CodeGenOptions options = CodeGenOptions.scheduledCDefault();
		//options.DEBUG = true;
		CodeGen.generateScheduledCode(program, systName, options, genCodeFile, false);
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Code Gen (scheduleC) done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		CodeGen.generateWrapper(program, systName, genCodeFile);
		CodeGen.generateMakefile(program, systName, genCodeFile);
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Code Gen all done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
	}
	
	@Test
	public void testGlobalTimeTaken_J2DWriteC() {
		Map<String, Map<String,List<Integer>>> scaleInputs7 = new HashMap<String, Map<String,List<Integer>>>();
		int ratioI = 1; int ratioJ = 1; int ratioK = 1;
		
		List<Integer> minBlParam = new BasicEList<Integer>();
		minBlParam.add(1); minBlParam.add(1); minBlParam.add(1);
		String nameFileCodeGen = "Jacobi2D_" + ratioI + "_" + ratioJ + "_" + ratioK;
		String genCodeFile = "alphabets/SubSystemExamples/Benchmark_CART/WriteCTest/GenCode/" + nameFileCodeGen + "/";
		
		
		long _starttime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/SubSystemExamples/Benchmark_CART/Jacobi2D_Bis/Jacobi2D_Skewed.ab");
		String systName = program.getSystems().get(0).getName();
		
		long currentTime = System.currentTimeMillis() - _starttime;
		long mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Parsing done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		ParametricTiling.parametricTiling_noOutlining(program, "b", scaleInputs7, true, 3, minBlParam);
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Transformation done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		CodeGenOptions options = CodeGenOptions.writeCDefault();
		options.DEBUG = true;
		WriteC.generate(program.getSystem(systName), options, genCodeFile);
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Code Gen (writeC) done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		CodeGen.generateWrapper(program, systName, genCodeFile);
		CodeGen.generateMakefile(program, systName, genCodeFile);
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Code Gen all done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		// ====================== RESULT ON MY MACHINE  (with no timing inside the Code gen - writeC part) ======================
		// *** Parsing done => [Current time = 1 838 ms | Memory taken = 211 MB]
		// *** Transformation done => [Current time = 7 760 ms | Memory taken = 726 MB]
		// *** Code Gen (writeC) done => [Current time = 85 336 ms | Memory taken = 785 MB]
		// *** Code Gen all done => [Current time = 120 666 ms | Memory taken = 822 MB]
		// => Physically 75% of my memory on my machine (in total, all openned applications)
		//
		// Local time inside the writeC part:
		//generate called [0 ms]
		//initializing codegen [0 ms]
		//generationPreProcessing done [727 ms]
		//getCodeUnit called [727 ms]
		//getCodeUnit done [8279 ms]
		//Xpand called [8279 ms]
		//Xpand done [47354 ms]
		//generationPostProcessing called [47354 ms]
		//generationPostProcessing done [47354 ms]
	}
	
	@Test
	public void testGlobalTimeTaken_CholeskyScheduleC() {
		Map<String, Map<String,List<Integer>>> scaleInputs7 = new HashMap<String, Map<String,List<Integer>>>();
		List<Integer> minBlParam = new BasicEList<Integer>();
		minBlParam.add(1); minBlParam.add(1);
		String nameFileCodeGen = "Cholesky_" + 1 + "_" + 1;
		String genCodeFile = "alphabets/SubSystemExamples/Benchmark_CART/WriteCTest/GenCode/" + nameFileCodeGen + "/";
		
		
		long _starttime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/SubSystemExamples/Benchmark_CART/Cholesky_with_reduce/Cholesky_with_reduce.ab");
		AffineSystem syst = program.getSystems().get(0);
		String systName = syst.getName();
		
		long currentTime = System.currentTimeMillis() - _starttime;
		long mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Parsing done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		ParametricTiling.parametricTiling_noOutlining(program, "b", scaleInputs7, true, 3, minBlParam);
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Transformation done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		// *** TargetMapping: 
		org.polymodel.polyhedralIR.targetMapping.TargetMapping tm = syst.getTargetMapping();
		
		//setSpaceTimeMap(prog, syst, 0, "L_bl", "(iBl,jBl,iLoc,jLoc-> jBl,iBl,jLoc,iLoc)");
		VariableDeclaration varDeclTempBl = syst.getVariableDeclaration("L_bl");
		AffineFunction stmapTempBl = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(iBl,jBl,iLoc,jLoc->jBl,iBl,jLoc,iLoc)");
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("L_bl",
				TargetMappingUserFactory.createStandardEquationSpaceTimeMap(varDeclTempBl, stmapTempBl));
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "TargetMapping defined" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		
		// *** ScheduleC
		CodeGen.generateScheduledCode(program, systName, genCodeFile);
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Code Gen (scheduleC) done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		CodeGen.generateWrapper(program, systName, genCodeFile);
		CodeGen.generateMakefile(program, systName, genCodeFile);
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Code Gen all done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
	}
	
	@Test
	public void testGlobalTimeTaken_MatMult() {
		Map<String, Map<String,List<Integer>>> scaleInputs = new HashMap<String, Map<String,List<Integer>>>();
		
		List<Integer> minBlParam = new BasicEList<Integer>();
		//minBlParam.add(4); minBlParam.add(4); minBlParam.add(4);
		minBlParam.add(12); minBlParam.add(12); minBlParam.add(12);
		String nameFileCodeGen = "MatMult_1_1_1";
		String genCodeFile = "alphabets/SubSystemExamples/Benchmark_CART/WriteCTest/GenCode/" + nameFileCodeGen + "/";
		
		long _starttime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("testcases/matrix_product_withReduce/matrix_product_withReduce.ab");
		//Program program = alphaz.mde.Basic.ReadAlphabets("testcases/matrix_product/matrix_product.ab");
		AffineSystem syst = program.getSystems().get(0);
		String systName = syst.getName();
		
		long currentTime = System.currentTimeMillis() - _starttime;
		long mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Parsing done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		ParametricTiling.parametricTiling_noOutlining(program, "b", scaleInputs, false, 3, minBlParam);
		
		Basic.ASave(program, genCodeFile+systName+".ab");
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Transformation done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		
		// *** TargetMapping: 
		org.polymodel.polyhedralIR.targetMapping.TargetMapping tm = syst.getTargetMapping();
		
		//* For the "reduce" code
		// setSpaceTimeMap(prog, syst, 0, "C_bl", "(iBl,tBl,iLoc,tLoc-> iBl,tBl,iLoc,tLoc)");
		VariableDeclaration varDeclTempBl = syst.getVariableDeclaration("C_bl");
		AffineFunction stmapTempBl = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(iBl,tBl,iLoc,tLoc-> iBl,tBl,iLoc,tLoc)");
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("C_bl",
				TargetMappingUserFactory.createStandardEquationSpaceTimeMap(varDeclTempBl, stmapTempBl));
		//*/
		// setSpaceTimeMap(prog, syst, 0, "C_bl", "(iBl,tBl,iLoc,tLoc-> iBl,tBl,iLoc,tLoc)");
		/*VariableDeclaration varDeclTempBl = syst.getVariableDeclaration("temp_C_bl");
		AffineFunction stmapTempBl = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(iBl,jBl,kBl,iLoc,jLoc,kLoc-> iBl,jBl,kBl,iLoc,jLoc,kLoc)");
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("temp_C_bl",
				TargetMappingUserFactory.createStandardEquationSpaceTimeMap(varDeclTempBl, stmapTempBl));
		
		VariableDeclaration varDeclCBl = syst.getVariableDeclaration("C_bl");
		AffineFunction stmapCBl = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(iBl,jBl,kBl,iLoc,jLoc,kLoc-> iBl,jBl,kBl,iLoc,jLoc,kLoc)");
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("C_bl",
				TargetMappingUserFactory.createStandardEquationSpaceTimeMap(varDeclCBl, stmapCBl));//*/
		
		
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "TargetMapping defined" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		CodeGenOptions options = CodeGenOptions.scheduledCDefault();
		//options.DEBUG = true;
		CodeGen.generateScheduledCode(program, systName, options, genCodeFile, false);
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Code Gen (scheduleC) done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		CodeGen.generateWrapper(program, systName, genCodeFile);
		CodeGen.generateMakefile(program, systName, genCodeFile);
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Code Gen all done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
	}
	
	
	// WARNING : TAKES TOO MUCH TIME AND MEMORY ( > 8GB of mem)
	@Test
	public void testGlobalTimeTaken_J2DScheduleC() {
		Map<String, Map<String,List<Integer>>> scaleInputs7 = new HashMap<String, Map<String,List<Integer>>>();
		int ratioI = 1; int ratioJ = 1; int ratioK = 1;
		
		List<Integer> minBlParam = new BasicEList<Integer>();
		minBlParam.add(1); minBlParam.add(1); minBlParam.add(1);
		String nameFileCodeGen = "Jacobi2D_" + ratioI + "_" + ratioJ + "_" + ratioK;
		String genCodeFile = "alphabets/SubSystemExamples/Benchmark_CART/WriteCTest/GenCode/" + nameFileCodeGen + "/";
		
		
		long _starttime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/SubSystemExamples/Benchmark_CART/Jacobi2D_Bis/Jacobi2D_Skewed.ab");
		AffineSystem syst = program.getSystems().get(0);
		String systName = syst.getName();
		
		long currentTime = System.currentTimeMillis() - _starttime;
		long mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Parsing done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		ParametricTiling.parametricTiling_noOutlining(program, "b", scaleInputs7, true, 3, minBlParam);
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Transformation done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		/* EXTRA => removing union of polyhedra
		for (StandardEquation stEq : syst.getEquations()) {
			if (stEq.getExpression() instanceof CaseExpression) {
				CaseExpression cExpr = (CaseExpression) stEq.getExpression();
				List<Expression> lSubExpr = cExpr.getExprs();
				
				List<Expression> lnSubExpr = new BasicEList<Expression>();
				for (Expression expr : lSubExpr) {
					RestrictExpression rExpr = (RestrictExpression) expr;
					Domain restrDom = rExpr.getRestrictDomain();
					
					if (restrDom.getPMdomain().getPolyhedra().size()==1)
						lnSubExpr.add(expr);
					else {
						for (int k=0; k<restrDom.getPMdomain().getPolyhedra().size(); k++) {
							IntConstraintSystem systConstr = restrDom.getPMdomain().getPolyhedra().get(k);
							Domain nRestrDom = PolyhedralIRUserFactory.eINSTANCE.createDomain(restrDom.getParams(), restrDom.getIndices(), systConstr.copy());
							lnSubExpr.add(PolyhedralIRUserFactory.eINSTANCE.createRestrictExpression(nRestrDom, rExpr.getExpr().copy()));
						}
					}
				}
				cExpr.getExprs().clear();
				cExpr.getExprs().addAll(lnSubExpr);
			}
		}
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Extra done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		//ContextDomainCalculator.computeContextDomain(syst); // TODO
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Context done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		//*/
		
		
		// *** TargetMapping: 
		org.polymodel.polyhedralIR.targetMapping.TargetMapping tm = syst.getTargetMapping();
		
		/* EXTRA
		VariableDeclaration varDeclTempBl = syst.getVariableDeclaration("temp_bl");
		AffineFunction stmapTempBl = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(),
				"(iBl,jBl,tBl,iLoc,jLoc,tLoc-> 0,tBl,tLoc,iBl,iLoc,jBl,jLoc)");
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("temp_bl",
				TargetMappingUserFactory.createStandardEquationSpaceTimeMap(varDeclTempBl, stmapTempBl));
		VariableDeclaration varDeclBBl = syst.getVariableDeclaration("B_bl");
		AffineFunction stmapBBl = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(iBl,jBl,iLoc,jLoc-> 1,iBl,jBl,iLoc,jLoc,0,0)");
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("B_bl",
				TargetMappingUserFactory.createStandardEquationSpaceTimeMap(varDeclBBl, stmapBBl));
		tm.getSpaceTimeLevel(0).getOrderingDimensions().add(0);
		//*/
		
		
		//*
		// setSpaceTimeMap(prog, system, "temp_bl", "(iBl,jBl,tBl,iLoc,jLoc,tLoc-> 0,tBl+iBl+jBl,iBl,tBl, tLoc+iLoc+jLoc,iLoc,tLoc)");
		VariableDeclaration varDeclTempBl = syst.getVariableDeclaration("temp_bl");
		AffineFunction stmapTempBl = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(),
				"(iBl,jBl,tBl,iLoc,jLoc,tLoc-> 0,tBl+iBl+jBl,iBl,tBl, tLoc+iLoc+jLoc,iLoc,tLoc)");
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("temp_bl",
				TargetMappingUserFactory.createStandardEquationSpaceTimeMap(varDeclTempBl, stmapTempBl));
		
		// setSpaceTimeMap(prog, system, "B_bl", "(iBl,jBl,iLoc,jLoc-> 1,iBl,jBl, iLoc,jLoc, 0,0)");
		VariableDeclaration varDeclBBl = syst.getVariableDeclaration("B_bl");
		AffineFunction stmapBBl = PolyhedralIRUtility.parseAffineFunction(syst.getParameters(), "(iBl,jBl,iLoc,jLoc-> 1,iBl,jBl, iLoc,jLoc, 0,0)");
		tm.getSpaceTimeLevel(0).getSpaceTimeMaps().put("B_bl",
				TargetMappingUserFactory.createStandardEquationSpaceTimeMap(varDeclBBl, stmapBBl));

		// setOrderingDimensions(prog, system, 0);
		tm.getSpaceTimeLevel(0).getOrderingDimensions().add(0);
		
		// setParallel(prog, system, "0", "2,3,5,6");
		List<Integer> prefix = new BasicEList<Integer>(); prefix.add(0);
		List<Integer> dims = new BasicEList<Integer>(); dims.add(2); dims.add(3); dims.add(5); dims.add(6);
		ParallelizationSpecification parallelSpecif = TargetMappingUserFactory.createParallelizationSpecification(prefix, dims);
		tm.getSpaceTimeLevel(0).getParallelizationSpecifications().add(parallelSpecif);
		//*/
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "TargetMapping defined" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		
		// *** ScheduleC
		CodeGenOptions options = CodeGenOptions.scheduledCDefault();
		options.DEBUG = true;
		CodeGen.generateScheduledCode(program, systName, options, genCodeFile, false);
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Code Gen (writeC) done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		CodeGen.generateWrapper(program, systName, genCodeFile);
		CodeGen.generateMakefile(program, systName, genCodeFile);
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Code Gen all done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		// ====================== RESULT ON MY MACHINE  ======================
		
		
	}
	
	@Test
	public void testTimeCARTTaken_J1D() {
		int scaleI = 1;
		int scaleT = 1;		// Replace "T" by "scaleT*T" inside the system
		
		Map<String, Map<String,List<Integer>>> scaleInputs7 = new HashMap<String, Map<String,List<Integer>>>();
		Map<String,List<Integer>> scaleGrp = new HashMap<String, List<Integer>>();
		
		List<Integer> lScaleTemp = new BasicEList<Integer>(); lScaleTemp.add(scaleI); lScaleTemp.add(scaleT);
		scaleGrp.put("temp", lScaleTemp);
		List<Integer> lScaleB = new BasicEList<Integer>(); lScaleB.add(scaleI);
		scaleGrp.put("B", lScaleB);
		
		scaleInputs7.put("Jacobi1D",scaleGrp);
		
		List<Integer> minBlParam = new BasicEList<Integer>();
		minBlParam.add(1); minBlParam.add(1);
		
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/SubSystemExamples/Benchmark_CART/Jacobi1D/Jacobi1D_original.ab");
		
		long _starttime = System.currentTimeMillis();
		
		ParametricTiling.parametricTiling_noOutlining(program, "b", scaleInputs7, true, 3, minBlParam);
		
		long currentTime = System.currentTimeMillis() - _starttime;
		long mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Transformation done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
	}
	
	
	/* --------------------------------------------------------- */
	/* ------------------ CART with outlining ------------------ */
	/* --------------------------------------------------------- */
	
	// CART main operations for Domain while outlining
	private static void parseAndGetBlockedDomain_Split(String domStr, List<String> paramScal, List<String> blockIndName,
			List<String> localIndName, List<String> blockParamName, List<String> localParamName, List<Integer> scale, String blSizeParamName,
			boolean paramDiv, int minb, List<Integer> lParamMin) {
		Domain domScal = PolyhedralIRUtility.parseDomain(paramScal, domStr);
		
		DimensionsManager _dimMana = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
		
		List<Variable> blockInd = new BasicEList<Variable>();
		for (int i=0; i<blockIndName.size(); i++)
			blockInd.add(_dimMana.getDimension(i, blockIndName.get(i)));
		List<Variable> localInd = new BasicEList<Variable>();
		for (int i=0; i<localIndName.size(); i++)
			localInd.add(_dimMana.getDimension(i+blockInd.size(), localIndName.get(i)));
		List<Variable> blockParam = new BasicEList<Variable>();
		for (int i=0; i<blockParamName.size(); i++)
			blockParam.add(_dimMana.getParameter(i, blockParamName.get(i)));
		List<Variable> localParam = new BasicEList<Variable>();
		for (int i=0; i<localParamName.size(); i++)
			localParam.add(_dimMana.getParameter(i+blockParamName.size(), localParamName.get(i)));
		Variable blSizeParam = _dimMana.getParameter(blockParamName.size()+localParamName.size(), blSizeParamName);
		
		List<Pair<FastISLDomain,FastISLDomain>> domTiled = CARTOperations.getTiledDomainSplit(domScal, blockInd, localInd, blockParam, localParam,
				scale, blSizeParam, paramDiv, minb, lParamMin);
		System.out.println();
		System.out.println();
		System.out.println("**********************************************");
		for (Pair<FastISLDomain,FastISLDomain> pDomBlLoc : domTiled)
			System.out.println(" * " + pDomBlLoc.getValue0().toString()+"\n\t \\crossprod " + pDomBlLoc.getValue1().toString());
		
	}
	
	@Test
	public void test1_getTiledDomain_Split() {
		List<String> paramScal = new BasicEList<String>();
		paramScal.add("N");
		
		List<String> blockIndName = new BasicEList<String>();
		blockIndName.add("alpha"); blockIndName.add("beta");
		
		List<String> localIndName = new BasicEList<String>();
		localIndName.add("ii"); localIndName.add("jj");
		
		List<String> blockParamName = new BasicEList<String>();
		blockParamName.add("M");
		
		List<String> localParamName = new BasicEList<String>();
		localParamName.add("mm");
		
		List<Integer> scale = new BasicEList<Integer>();
		scale.add(1); scale.add(1);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		lParamMin.add(1);
		
		parseAndGetBlockedDomain_Split("{i,j | N-1-i-j>=0}", paramScal, blockIndName, localIndName, blockParamName, localParamName, scale, "b",
				false, 1, lParamMin);
		// * {alpha,beta|alpha+beta==M-1 && M>=1} \crossprod {ii,jj|mm+b>=ii+jj+1 && ii>=0 && jj>=0 && b>=ii+1 && b>=jj+1 && b>=1}
		// * {alpha,beta|alpha+beta==M && M>=1} \crossprod {ii,jj|mm>=ii+jj+1 && ii>=0 && jj>=0 && b>=ii+1 && b>=jj+1 && b>=1}
		// * {alpha,beta|M>=alpha+beta+2 && M>=1} \crossprod {ii,jj|ii>=0 && jj>=0 && b>=ii+1 && b>=jj+1 && b>=1}
	}
	
	@Test
	public void test2_getTiledDomain_Split() {
		List<String> paramScal = new BasicEList<String>();
		paramScal.add("N"); paramScal.add("T");
		
		List<String> blockIndName = new BasicEList<String>();
		blockIndName.add("ib"); blockIndName.add("tb");
		
		List<String> localIndName = new BasicEList<String>();
		localIndName.add("il"); localIndName.add("tl");
		
		List<String> blockParamName = new BasicEList<String>();
		blockParamName.add("NB"); blockParamName.add("TB");
		
		List<String> localParamName = new BasicEList<String>();
		localParamName.add("NL");localParamName.add("TL");
		
		List<Integer> scale = new BasicEList<Integer>();
		scale.add(1); scale.add(1);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		lParamMin.add(1);
		lParamMin.add(0);
		
		parseAndGetBlockedDomain_Split("{i,t|i==N-1 && t>=1 && T>=t && N>=2 && T>=0}",
				paramScal, blockIndName, localIndName, blockParamName, localParamName, scale, "b", true, 3, lParamMin);
		// * {ib,tb|tb==0 && ib==NB-1 && TB>=1 && NB>=1}
		//		\crossprod {il,tl|il==b-1 && TL==0 && NL==0 && b>=tl+1 && b>=3 && tl>=1}
		// * {ib,tb|tb==TB && ib==NB-1 && TB>=1 && NB>=1}
		//		\crossprod {il,tl|tl==0 && il==b-1 && TL==0 && NL==0 && b>=3}
		// * {ib,tb|ib==NB-1 && tb>=1 && TB>=tb+1 && NB>=1 && TB>=0}
		//		\crossprod {il,tl|il==b-1 && TL==0 && NL==0 && b>=tl+1 && b>=3 && tl>=0}
	}
	
	@Test
	public void test3_getTiledDomain_Split() {
		List<String> paramScal = new BasicEList<String>();
		paramScal.add("N"); paramScal.add("T");
		
		List<String> blockIndName = new BasicEList<String>();
		blockIndName.add("ib"); blockIndName.add("tb");
		
		List<String> localIndName = new BasicEList<String>();
		localIndName.add("il"); localIndName.add("tl");
		
		List<String> blockParamName = new BasicEList<String>();
		blockParamName.add("NB"); blockParamName.add("TB");
		
		List<String> localParamName = new BasicEList<String>();
		localParamName.add("NL");localParamName.add("TL");
		
		List<Integer> scale = new BasicEList<Integer>();
		scale.add(1); scale.add(1);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		lParamMin.add(2);
		lParamMin.add(1);
		
		parseAndGetBlockedDomain_Split("{i,t|t>=1 && i>=t+1 && t+N>=i+2 && T>=3 && N>=6}",
				paramScal, blockIndName, localIndName, blockParamName, localParamName, scale, "b", true, 6, lParamMin);
	}
	
	// CART main operations for AffineFunctions while outlining
	private static void parseAndGetBlockedFunction_Split(List<String> funcStr, List<String> indScalName, List<String> paramScalName,
			List<String> blockIndName, List<String> localIndName, List<String> blockParamName, List<String> localParamName,
			List<Integer> scale, List<Integer> scaleIm,
			String blSizeParamName, boolean isDivisible, int minb, List<Integer> lParamMin) {
		
		DimensionsManager _dimMana = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
		
		List<Variable> lparamScal = new BasicEList<Variable>();
		for (int i=0; i<paramScalName.size(); i++)
			lparamScal.add(_dimMana.getParameter(i, paramScalName.get(i)));
		List<Variable> lindScal = new BasicEList<Variable>();
		for (int i=0; i<indScalName.size(); i++)
			lindScal.add(_dimMana.getDimension(i, indScalName.get(i)));
		
		AffineFunction funcScal = PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(PolyhedralIRUtility.parseFunction(lparamScal, lindScal, funcStr));
		
		List<Variable> blockInd = new BasicEList<Variable>();
		for (int i=0; i<blockIndName.size(); i++)
			blockInd.add(_dimMana.getDimension(i, blockIndName.get(i)));
		List<Variable> localInd = new BasicEList<Variable>();
		for (int i=0; i<localIndName.size(); i++)
			localInd.add(_dimMana.getDimension(i+blockInd.size(), localIndName.get(i)));
		List<Variable> blockParam = new BasicEList<Variable>();
		for (int i=0; i<blockParamName.size(); i++)
			blockParam.add(_dimMana.getParameter(i, blockParamName.get(i)));
		List<Variable> localParam = new BasicEList<Variable>();
		for (int i=0; i<localParamName.size(); i++)
			localParam.add(_dimMana.getParameter(i+blockParamName.size(), localParamName.get(i)));
		Variable blSizeParam = _dimMana.getParameter(blockParamName.size()+localParamName.size(), blSizeParamName);
		
		List<Triplet<FastISLDomain,FastISLDomain,FastISLMap>> funcTiled = CARTOperations.getTiledFunctionSplit(funcScal, blockInd, localInd,
				blockParam, localParam, scale, scaleIm, blSizeParam, isDivisible, minb, lParamMin);
		System.out.println();
		System.out.println();
		System.out.println("**********************************************");
		
		for (Triplet<FastISLDomain,FastISLDomain,FastISLMap> tDomBlLocFunc : funcTiled)
			System.out.println("IF " + tDomBlLocFunc.getValue0().toString() + " \\inter "
					+ tDomBlLocFunc.getValue1().toString() + " THEN " + tDomBlLocFunc.getValue2().toString());
	}
	
	@Test
	public void test1_getTiledFunction_Split() {
		List<String> indScalName = new BasicEList<String>();
		indScalName.add("i"); indScalName.add("j");
		
		List<String> blockIndName = new BasicEList<String>();
		blockIndName.add("alpha"); blockIndName.add("beta");
		List<String> localIndName = new BasicEList<String>();
		localIndName.add("ii"); localIndName.add("jj");
		
		List<String> paramScalName = new BasicEList<String>();
		paramScalName.add("N");
		
		List<String> blockParamName = new BasicEList<String>();
		blockParamName.add("M");
		List<String> localParamName = new BasicEList<String>();
		localParamName.add("mm");
		
		List<Integer> scale = new BasicEList<Integer>();
		scale.add(1); scale.add(1);
		
		List<Integer> scaleIm = new BasicEList<Integer>();
		scaleIm.add(1); scaleIm.add(1);
		
		List<String> funcStr = new BasicEList<String>();
		funcStr.add("i+j");
		funcStr.add("N+j");
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		lParamMin.add(0);
		
		parseAndGetBlockedFunction_Split(funcStr, indScalName, paramScalName, blockIndName, localIndName,
				blockParamName, localParamName, scale, scaleIm, "b", true, 1, lParamMin);
	}
	
	
	// CART on programs while outlining
	private static void parseAndTransformProgram_Outlining(String filename, Map<String,Map<String,List<Integer>>> lscaleInputs,
			boolean paramDiv, int minB, List<Integer> lParamMin) {
		Program program = alphaz.mde.Basic.ReadAlphabets(filename);
		ParametricTiling.parametricTiling(program, "b", lscaleInputs, paramDiv, minB, lParamMin);
		
		System.out.println(AShow.toString(program));
		System.out.println();
		System.out.println();
		System.out.println("**********************************************");
		System.out.println(UniquenessAndCompletenessCheck.validate(program).toString());
	}
	
	@Test
	public void test_CARTOutlining_program_Test1() {
		Map<String, Map<String,List<Integer>>> scaleInputs1 = new HashMap<String, Map<String,List<Integer>>>();
		List<Integer> lParamMin = new BasicEList<Integer>();
		lParamMin.add(0);
		lParamMin.add(0);
		lParamMin.add(0);
		parseAndTransformProgram_Outlining("testcases/matrix_product_withReduce/matrix_product_withReduce.ab", scaleInputs1, true, 1, lParamMin);
	}
	
	@Test
	public void test_CARTOutlining_program_Test2() {
		Map<String, Map<String,List<Integer>>> scaleInputs2 = new HashMap<String, Map<String,List<Integer>>>();
		List<Integer> lParamMin = new BasicEList<Integer>();
		lParamMin.add(2);
		lParamMin.add(1);
		parseAndTransformProgram_Outlining("alphabets/SubSystemExamples/Benchmark_CART/Jacobi1D/Jacobi1D_original.ab", scaleInputs2, true, 3, lParamMin);
	}
	
	@Test
	public void test_CARTOutlining_program_Test2B() {
		Map<String, Map<String,List<Integer>>> scaleInputs2B = new HashMap<String, Map<String,List<Integer>>>();
		List<Integer> lParamMin = new BasicEList<Integer>();
		lParamMin.add(2);
		lParamMin.add(1);
		parseAndTransformProgram_Outlining("alphabets/SubSystemExamples/Benchmark_CART/Jacobi1D/Jacobi1D_Skewed/Jacobi1D_Skewed.ab", scaleInputs2B,
				true, 3, lParamMin);
	}
	
	@Test
	public void test_CARTOutlining_program_Test3() {
		Map<String, Map<String,List<Integer>>> scaleInputs3 = new HashMap<String, Map<String,List<Integer>>>();
		
		Map<String, List<Integer>> scaleChol = new HashMap<String, List<Integer>>();
		
		List<Integer> lscalesA = new BasicEList<Integer>();
		lscalesA.add(1); lscalesA.add(1);
		scaleChol.put("A", lscalesA);
		List<Integer> lscalesL = new BasicEList<Integer>();
		lscalesL.add(1); lscalesL.add(1);
		scaleChol.put("L", lscalesL);
		
		scaleInputs3.put("cholesky_withReduce", scaleChol);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		lParamMin.add(0);
		lParamMin.add(0);
		
		parseAndTransformProgram_Outlining("testcases/cholesky_withReduce/cholesky_withReduce.ab", scaleInputs3, true, 3, lParamMin);
	}
	
	@Test
	public void test_CARTOutlining_program_Test3B() {
		Map<String, Map<String,List<Integer>>> scaleInputs3 = new HashMap<String, Map<String,List<Integer>>>();
		
		Map<String, List<Integer>> scaleChol = new HashMap<String, List<Integer>>();
		
		List<Integer> lscalesA = new BasicEList<Integer>();
		lscalesA.add(2); lscalesA.add(1);		// Test avec "1" après
		scaleChol.put("A", lscalesA);
		List<Integer> lscalesL = new BasicEList<Integer>();
		lscalesL.add(2); lscalesL.add(2);
		scaleChol.put("L", lscalesL);
		
		scaleInputs3.put("cholesky_withReduce", scaleChol);
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		lParamMin.add(0);
		lParamMin.add(0);
		
		parseAndTransformProgram_Outlining("testcases/cholesky_withReduce/cholesky_withReduce.ab", scaleInputs3, true, 3, lParamMin);
	}
	
	@Test
	public void test_CARTOutlining_program_Test4() {
		Map<String, Map<String,List<Integer>>> scaleInputs4 = new HashMap<String, Map<String,List<Integer>>>();
		
		List<Integer> lParamMin = new BasicEList<Integer>();
		lParamMin.add(2);
		
		parseAndTransformProgram_Outlining("testcases/lud/lud.ab", scaleInputs4, true, 1, lParamMin);
	}
	
	@Test
	public void test_CARTOutlining_program_Test5() {
//		Map<String, Map<String,List<Integer>>> scaleInputs5 = new HashMap<String, Map<String,List<Integer>>>();
//		List<Integer> lParamMin = new BasicEList<Integer>();
//		lParamMin.add(2);
//		lParamMin.add(2);
//		lParamMin.add(2);
//		parseAndTransformProgram_Outlining("alphabets/SubSystemExamples/Benchmark_CART/Jacobi2D/Jacobi2D_Skewed.ab", scaleInputs5, true, 6, lParamMin);
		// DOES NOT SCALE because of the expression domain !!!
		// => not possible to check program in less than 15GB of memory
	}
	
	@Test
	public void test_CARTOutlining_program_Test5B() {
//		Map<String, Map<String,List<Integer>>> scaleInputs5 = new HashMap<String, Map<String,List<Integer>>>();
//		parseAndTransformProgram_Outlining("alphabets/EnerySavingExamples/jacobi_2d/jacobi_2d.ab", scaleInputs5, true, 6);
		// DOES NOT SCALE because of the expression domain !!!
		// => not possible to check program in less than 15GB of memory
	}
	
	
	
	/* --------------------------------------------------------- */
	/* ------------------ CART with outlining ------------------ */
	/* --------------------------------------------------------- */
	private static void parseAndTransformProgram_SubSystem(String filename, Map<String,List<Integer>> lscaleInputs,
			boolean paramDiv, int minB, List<Map<String,AffineFunction>> alignmentInfo, List<Integer> lMinBlParam) {
		
		Program program = alphaz.mde.Basic.ReadAlphabets(filename);
//		String nameProg = program.getSystems().get(0).getName();
		ParametricTiling.parametricTiling_Subsystem(program, "b", lscaleInputs, paramDiv, minB, lMinBlParam, alignmentInfo);
		
		// DEBUG
		//System.out.println(AShow.toString(program));
		//System.out.println(PolyhedralIRToAlphabets.toString(program));
		
		//*
		System.out.println(AShow.toString(program));
		System.out.println();
		System.out.println();
		System.out.println("**********************************************");
		System.out.println(UniquenessAndCompletenessCheck.validate(program).toString());
		//*/
		
		/* Saving System
		String nameFile = program.getSystems().get(0).getName();
		for (String var : lscaleInputs.keySet()) {
			nameFile += var;
			for (int k : lscaleInputs.get(var))
				nameFile += "_" + k;
		}
		alphaz.mde.Utility.WriteToFile("alphabets/SubSystemExamples/Benchmark_CART/SubSystem/"+nameFile+".ab", AShow.toSimplifiedString(program));
		//*/
	}
	
	@Test
	public void test_CARTSubSystem_program_Test1() {
		Map<String,List<Integer>> scaleInputs1 = new HashMap<String,List<Integer>>();
		List<Map<String,AffineFunction>> alignmentInfo1 = new BasicEList<Map<String,AffineFunction>>();
		
		// Group 1 of alignmentInfo1: temp and B
		Map<String,AffineFunction> group1AlInfo1 = new HashMap<String,AffineFunction>();
		
		List<String> lparamStr1Temp = new BasicEList<String>(); lparamStr1Temp.add("N"); lparamStr1Temp.add("T");
		List<String> lindStr1Temp = new BasicEList<String>(); lindStr1Temp.add("i"); lindStr1Temp.add("j");
		List<String> lexprStr1Temp = new BasicEList<String>(); lexprStr1Temp.add("i"); lexprStr1Temp.add("j");
		group1AlInfo1.put("temp", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1Temp, lindStr1Temp, lexprStr1Temp));
		
		alignmentInfo1.add(group1AlInfo1);
		
		Map<String,AffineFunction> group1AlInfo2 = new HashMap<String,AffineFunction>();
		List<String> lparamStr1B= new BasicEList<String>(); lparamStr1B.add("N"); lparamStr1B.add("T");
		List<String> lindStr1B = new BasicEList<String>(); lindStr1B.add("i");
		List<String> lexprStr1B = new BasicEList<String>(); lexprStr1B.add("i");
		group1AlInfo2.put("B", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1B, lindStr1B, lexprStr1B));

		alignmentInfo1.add(group1AlInfo2);
		
		List<Integer> lMinBlParam = new BasicEList<Integer>(); lMinBlParam.add(2); lMinBlParam.add(1);
		
		parseAndTransformProgram_SubSystem("alphabets/SubSystemExamples/Benchmark_CART/Jacobi1D/Jacobi1D_Skewed/Jacobi1D_Skewed.ab",
				scaleInputs1, true, 4, alignmentInfo1, lMinBlParam);
	}
	
	@Test
	public void test_CARTSubSystem_program_Test2() {
		int scaleI = 1;
		int scaleJ = 1;
		
		Map<String,List<Integer>> scaleInputs1 = new HashMap<String,List<Integer>>();
		
		List<Integer> lScaleA = new BasicEList<Integer>();
		lScaleA.add(scaleI);
		scaleInputs1.put("A", lScaleA);
		
		List<Integer> lScaleTemp = new BasicEList<Integer>();
		lScaleTemp.add(scaleI); lScaleTemp.add(scaleJ);
		scaleInputs1.put("temp_B", lScaleTemp);
		
		List<Integer> lScaleB = new BasicEList<Integer>();
		lScaleB.add(scaleI); lScaleB.add(scaleJ);
		scaleInputs1.put("B", lScaleB);
		
		
		List<Map<String,AffineFunction>> alignmentInfo1 = new BasicEList<Map<String,AffineFunction>>();
		
		// Group 1 of alignmentInfo1: temp and B
		Map<String,AffineFunction> group1AlInfo1 = new HashMap<String,AffineFunction>();
		
		List<String> lparamStr1Temp = new BasicEList<String>(); lparamStr1Temp.add("TSTEPS"); lparamStr1Temp.add("N");
		List<String> lindStr1Temp = new BasicEList<String>(); lindStr1Temp.add("t"); lindStr1Temp.add("i");
		List<String> lexprStr1Temp = new BasicEList<String>(); lexprStr1Temp.add("t"); lexprStr1Temp.add("t+i");
		group1AlInfo1.put("temp_B", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1Temp, lindStr1Temp, lexprStr1Temp));
		
		List<String> lparamStr1B= new BasicEList<String>(); lparamStr1B.add("TSTEPS"); lparamStr1B.add("N");
		List<String> lindStr1B = new BasicEList<String>(); lindStr1B.add("t"); lindStr1B.add("i");
		List<String> lexprStr1B = new BasicEList<String>(); lexprStr1B.add("t"); lexprStr1B.add("i+t");
		group1AlInfo1.put("B", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1B, lindStr1B, lexprStr1B));
		
		alignmentInfo1.add(group1AlInfo1);
		
		List<Integer> lMinBlParam = new BasicEList<Integer>(); lMinBlParam.add(1); lMinBlParam.add(2);
		
		parseAndTransformProgram_SubSystem("alphabets/EnerySavingExamples/jacobi_1d/jacobi_1d.ab",
				scaleInputs1, true, 6, alignmentInfo1, lMinBlParam);
	}
	
	@Test
	public void test_CARTSubSystem_program_Test2B() {
		Map<String,List<Integer>> scaleInputs1 = new HashMap<String,List<Integer>>();
		
		List<Map<String,AffineFunction>> alignmentInfo1 = new BasicEList<Map<String,AffineFunction>>();
		
		// Group 1 of alignmentInfo1: temp and B
		Map<String,AffineFunction> group1AlInfo1 = new HashMap<String,AffineFunction>();
		List<String> lparamStr1Temp = new BasicEList<String>(); lparamStr1Temp.add("N"); lparamStr1Temp.add("T");
		List<String> lindStr1Temp = new BasicEList<String>(); lindStr1Temp.add("i"); lindStr1Temp.add("t");
		List<String> lexprStr1Temp = new BasicEList<String>(); lexprStr1Temp.add("i"); lexprStr1Temp.add("t");
		group1AlInfo1.put("temp", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1Temp, lindStr1Temp, lexprStr1Temp));
		alignmentInfo1.add(group1AlInfo1);
		
		Map<String,AffineFunction> group1AlInfo2 = new HashMap<String,AffineFunction>();
		List<String> lparamStr1B= new BasicEList<String>(); lparamStr1B.add("N"); lparamStr1B.add("T");
		List<String> lindStr1B = new BasicEList<String>(); lindStr1B.add("i");
		List<String> lexprStr1B = new BasicEList<String>(); lexprStr1B.add("i");
		group1AlInfo2.put("B", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1B, lindStr1B, lexprStr1B));
		alignmentInfo1.add(group1AlInfo2);
		
		List<Integer> lMinBlParam = new BasicEList<Integer>(); lMinBlParam.add(2); lMinBlParam.add(1);
		
		parseAndTransformProgram_SubSystem("alphabets/SubSystemExamples/Benchmark_CART/Jacobi1D/Jacobi1D_Skewed/Jacobi1D_Skewed.ab",
				scaleInputs1, true, 6, alignmentInfo1, lMinBlParam);
	}
	
	@Test
	public void test_CARTSubSystem_program_Test3() {
		Map<String,List<Integer>> scaleInputs1 = new HashMap<String,List<Integer>>();
		
		List<Integer> lScaleTemp = new BasicEList<Integer>();
		lScaleTemp.add(1); lScaleTemp.add(1); lScaleTemp.add(1);
		//lScaleTemp.add(2); lScaleTemp.add(2); lScaleTemp.add(1);
		scaleInputs1.put("temp_B", lScaleTemp);
		
		List<Integer> lScaleB = new BasicEList<Integer>();
		lScaleB.add(1); lScaleB.add(1); lScaleB.add(1);
		//lScaleB.add(2); lScaleB.add(2); lScaleB.add(1);
		scaleInputs1.put("B", lScaleB);
		
		
		List<Map<String,AffineFunction>> alignmentInfo1 = new BasicEList<Map<String,AffineFunction>>();
		
		// Group 1 of alignmentInfo1: temp and B
		Map<String,AffineFunction> group1AlInfo1 = new HashMap<String,AffineFunction>();
		
		List<String> lparamStr1Temp = new BasicEList<String>(); lparamStr1Temp.add("TSTEPS"); lparamStr1Temp.add("N"); lparamStr1Temp.add("M");
		List<String> lindStr1Temp = new BasicEList<String>(); lindStr1Temp.add("t"); lindStr1Temp.add("i"); lindStr1Temp.add("j");
		List<String> lexprStr1Temp = new BasicEList<String>(); lexprStr1Temp.add("t"); lexprStr1Temp.add("t+i"); lexprStr1Temp.add("t+j");
		group1AlInfo1.put("temp_B", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1Temp, lindStr1Temp, lexprStr1Temp));
		
		List<String> lparamStr1B= new BasicEList<String>(); lparamStr1B.add("TSTEPS"); lparamStr1B.add("N"); lparamStr1B.add("M");
		List<String> lindStr1B = new BasicEList<String>(); lindStr1B.add("t"); lindStr1B.add("i"); lindStr1B.add("j");
		List<String> lexprStr1B = new BasicEList<String>(); lexprStr1B.add("t"); lexprStr1B.add("i+t"); lexprStr1B.add("j+t");
		group1AlInfo1.put("B", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1B, lindStr1B, lexprStr1B));
		
		alignmentInfo1.add(group1AlInfo1);
		
		List<Integer> lMinBlParam = new BasicEList<Integer>(); lMinBlParam.add(2); lMinBlParam.add(2); lMinBlParam.add(2);
		parseAndTransformProgram_SubSystem("alphabets/SubSystemExamples/Benchmark_CART/Jacobi2D/jacobi_2d.ab",
				scaleInputs1, true, 6, alignmentInfo1, lMinBlParam);
	}
	
	@Test
	public void test_CARTSubSystem_program_Test3B() {
		Map<String,List<Integer>> scaleInputs1 = new HashMap<String,List<Integer>>();
		
		List<Map<String,AffineFunction>> alignmentInfo1 = new BasicEList<Map<String,AffineFunction>>();
		
		// Group 1 of alignmentInfo1: temp and B
		Map<String,AffineFunction> group1AlInfo1 = new HashMap<String,AffineFunction>();
		List<String> lparamStr1Temp = new BasicEList<String>(); lparamStr1Temp.add("N"); lparamStr1Temp.add("M"); lparamStr1Temp.add("T");
		List<String> lindStr1Temp = new BasicEList<String>(); lindStr1Temp.add("i"); lindStr1Temp.add("j"); lindStr1Temp.add("t");
		List<String> lexprStr1Temp = new BasicEList<String>(); lexprStr1Temp.add("i"); lexprStr1Temp.add("j"); lexprStr1Temp.add("t");
		group1AlInfo1.put("temp", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1Temp, lindStr1Temp, lexprStr1Temp));
		alignmentInfo1.add(group1AlInfo1);

		Map<String,AffineFunction> group1AlInfo2 = new HashMap<String,AffineFunction>();
		List<String> lparamStr1B= new BasicEList<String>(); lparamStr1B.add("N"); lparamStr1B.add("M"); lparamStr1B.add("T");
		List<String> lindStr1B = new BasicEList<String>(); lindStr1B.add("i"); lindStr1B.add("j");
		List<String> lexprStr1B = new BasicEList<String>(); lexprStr1B.add("i"); lexprStr1B.add("j");
		group1AlInfo2.put("B", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1B, lindStr1B, lexprStr1B));
		alignmentInfo1.add(group1AlInfo2);
		
		List<Integer> lMinBlParam = new BasicEList<Integer>(); lMinBlParam.add(3); lMinBlParam.add(3); lMinBlParam.add(2);
		
		parseAndTransformProgram_SubSystem("alphabets/SubSystemExamples/Benchmark_CART/stencil2D_5points/stencil2D_5points_skewed.ab",
				scaleInputs1, true, 6, alignmentInfo1, lMinBlParam);
	}
	
	@Test
	public void test_CARTSubSystem_program_Test4() {
		
		// Scales
		Map<String,List<Integer>> scaleInputs1 = new HashMap<String,List<Integer>>();
		List<Integer> lScaleTable = new BasicEList<Integer>(); lScaleTable.add(1); lScaleTable.add(1);
		scaleInputs1.put("FTable", lScaleTable);
		
		List<Integer> lScaleP = new BasicEList<Integer>(); lScaleP.add(1);
		scaleInputs1.put("P", lScaleP);
		
		// Alignment info
		List<Map<String,AffineFunction>> alignmentInfo1 = new BasicEList<Map<String,AffineFunction>>();
		
		Map<String,AffineFunction> group1AlInfo1 = new HashMap<String,AffineFunction>();
		
		List<String> lparamStr1FTable = new BasicEList<String>();  lparamStr1FTable.add("N");
		List<String> lindStr1FTable = new BasicEList<String>(); lindStr1FTable.add("i"); lindStr1FTable.add("j");
		List<String> lexprStr1FTable = new BasicEList<String>(); lexprStr1FTable.add("i-1"); lexprStr1FTable.add("j-1");
		group1AlInfo1.put("FTable", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1FTable, lindStr1FTable, lexprStr1FTable));
		
		alignmentInfo1.add(group1AlInfo1);

		
		
		// Min param
		List<Integer> lMinBlParam = new BasicEList<Integer>(); lMinBlParam.add(1);
		
		parseAndTransformProgram_SubSystem("alphabets/SubSystemExamples/Benchmark_CART/OSP/ReductionOSP.ab",
				scaleInputs1, true, 3, alignmentInfo1, lMinBlParam);
		
		
		// TODO: debug this !!!
		
	}
	
	@Test
	public void test_CARTSubSystem_program_Test5() {
		Map<String,List<Integer>> scaleInputs = new HashMap<String,List<Integer>>();

		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		
		Map<String,AffineFunction> groupAlInfo = new HashMap<String,AffineFunction>();
		List<String> lparamStr1Temp = new BasicEList<String>(); lparamStr1Temp.add("N");
		List<String> lindStr1Temp = new BasicEList<String>(); lindStr1Temp.add("i");
		List<String> lexprStr1Temp = new BasicEList<String>(); lexprStr1Temp.add("i");
		groupAlInfo.put("C", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1Temp, lindStr1Temp, lexprStr1Temp));
		alignmentInfo.add(groupAlInfo);
		
		List<Integer> lMinBlParam = new BasicEList<Integer>(); lMinBlParam.add(1);
		
		parseAndTransformProgram_SubSystem("alphabets/SubSystemExamples/Benchmark_CART/TestReduction.ab",
				scaleInputs, true, 2, alignmentInfo, lMinBlParam);
	}
	
	@Test
	public void test_CARTSubSystem_program_Test6() {
		Map<String,List<Integer>> scaleInputs = new HashMap<String,List<Integer>>();

		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		
		Map<String,AffineFunction> groupAlInfo = new HashMap<String,AffineFunction>();
		List<String> lparamStr1Temp = new BasicEList<String>(); lparamStr1Temp.add("P"); lparamStr1Temp.add("Q"); lparamStr1Temp.add("R");
		List<String> lindStr1Temp = new BasicEList<String>(); lindStr1Temp.add("i"); lindStr1Temp.add("j");
		List<String> lexprStr1Temp = new BasicEList<String>(); lexprStr1Temp.add("i"); lexprStr1Temp.add("j");
		groupAlInfo.put("C", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1Temp, lindStr1Temp, lexprStr1Temp));
		alignmentInfo.add(groupAlInfo);
		
		List<Integer> lMinBlParam = new BasicEList<Integer>(); lMinBlParam.add(1); lMinBlParam.add(1); lMinBlParam.add(1);
		
		parseAndTransformProgram_SubSystem("testcases/matrix_product_withReduce/matrix_product_withReduce.ab",
				scaleInputs, false, 2, alignmentInfo, lMinBlParam);
	}
	
	@Test
	public void test_CARTSubSystem_program_Test6B() {
		Map<String,List<Integer>> scaleInputs = new HashMap<String,List<Integer>>();

		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		
		Map<String,AffineFunction> groupAlInfo = new HashMap<String,AffineFunction>();
		List<String> lparamStr1Temp = new BasicEList<String>(); lparamStr1Temp.add("P"); lparamStr1Temp.add("Q"); lparamStr1Temp.add("R");
		List<String> lindStr1Temp = new BasicEList<String>(); lindStr1Temp.add("i"); lindStr1Temp.add("j"); lindStr1Temp.add("k");
		List<String> lexprStr1Temp = new BasicEList<String>(); lexprStr1Temp.add("i"); lexprStr1Temp.add("j"); lexprStr1Temp.add("k");
		groupAlInfo.put("C", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1Temp, lindStr1Temp, lexprStr1Temp));
		
		List<String> lparamStr2Temp = new BasicEList<String>(); lparamStr2Temp.add("P"); lparamStr2Temp.add("Q"); lparamStr2Temp.add("R");
		List<String> lindStr2Temp = new BasicEList<String>(); lindStr2Temp.add("i"); lindStr2Temp.add("j"); lindStr2Temp.add("k");
		List<String> lexprStr2Temp = new BasicEList<String>(); lexprStr2Temp.add("i"); lexprStr2Temp.add("j"); lexprStr2Temp.add("k");
		groupAlInfo.put("temp_C", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr2Temp, lindStr2Temp, lexprStr2Temp));
		
		alignmentInfo.add(groupAlInfo);
		
		List<Integer> lMinBlParam = new BasicEList<Integer>(); lMinBlParam.add(1); lMinBlParam.add(1); lMinBlParam.add(1);
		
		parseAndTransformProgram_SubSystem("testcases/matrix_product/matrix_product.ab",
				scaleInputs, true, 2, alignmentInfo, lMinBlParam);
	}
	
	@Test
	public void test_CARTSubSystem_program_Test7() {
		Map<String,List<Integer>> scaleInputs = new HashMap<String,List<Integer>>();
		
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		
		// LU
		Map<String,AffineFunction> groupAlInfoLU = new HashMap<String,AffineFunction>();
		List<String> lparamStr1Temp = new BasicEList<String>(); lparamStr1Temp.add("N");
		List<String> lindStr1Temp = new BasicEList<String>(); lindStr1Temp.add("i"); lindStr1Temp.add("j"); lindStr1Temp.add("k");
		List<String> lexprStr1Temp = new BasicEList<String>(); lexprStr1Temp.add("i"); lexprStr1Temp.add("j"); lexprStr1Temp.add("k");
		groupAlInfoLU.put("LU", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1Temp, lindStr1Temp, lexprStr1Temp));
		alignmentInfo.add(groupAlInfoLU);
		
		// F
		Map<String,AffineFunction> groupAlInfoF = new HashMap<String,AffineFunction>();
		List<String> lparamStr2Temp = new BasicEList<String>(); lparamStr2Temp.add("N");
		List<String> lindStr2Temp = new BasicEList<String>(); lindStr2Temp.add("i"); lindStr2Temp.add("j"); lindStr2Temp.add("k");
		List<String> lexprStr2Temp = new BasicEList<String>(); lexprStr2Temp.add("i"); lexprStr2Temp.add("j"); lexprStr2Temp.add("k");
		groupAlInfoF.put("F", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr2Temp, lindStr2Temp, lexprStr2Temp));
		alignmentInfo.add(groupAlInfoF);
		
		List<Integer> lMinBlParam = new BasicEList<Integer>(); lMinBlParam.add(1);
		
		parseAndTransformProgram_SubSystem("testcases/lud/lud.ab", scaleInputs, true, 2, alignmentInfo, lMinBlParam);
	}
	
	@Test
	public void test_CARTSubSystem_program_Test8() {
		Map<String,List<Integer>> scaleInputs = new HashMap<String,List<Integer>>();
		
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		
		// L
		Map<String,AffineFunction> groupAlInfoLU = new HashMap<String,AffineFunction>();
		List<String> lparamStr1Temp = new BasicEList<String>(); lparamStr1Temp.add("N");
		List<String> lindStr1Temp = new BasicEList<String>(); lindStr1Temp.add("i"); lindStr1Temp.add("j");
		List<String> lexprStr1Temp = new BasicEList<String>(); lexprStr1Temp.add("i"); lexprStr1Temp.add("j");
		groupAlInfoLU.put("L", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1Temp, lindStr1Temp, lexprStr1Temp));
		alignmentInfo.add(groupAlInfoLU);
		
		List<Integer> lMinBlParam = new BasicEList<Integer>(); lMinBlParam.add(3);
		
		parseAndTransformProgram_SubSystem("alphabets/SubSystemExamples/Benchmark_CART/Cholesky_with_reduce/Cholesky_with_reduce.ab",
				scaleInputs, true, 3, alignmentInfo, lMinBlParam);
		
	}
	
	@Test
	public void test_CARTSubSystem_program_Test8B() {
		Map<String,List<Integer>> scaleInputs = new HashMap<String,List<Integer>>();
		
		List<Map<String,AffineFunction>> alignmentInfo = new BasicEList<Map<String,AffineFunction>>();
		
		// L
		Map<String,AffineFunction> groupAlInfoL = new HashMap<String,AffineFunction>();
		List<String> lparamStr1Temp = new BasicEList<String>(); lparamStr1Temp.add("N");
		List<String> lindStr1Temp = new BasicEList<String>(); lindStr1Temp.add("i"); lindStr1Temp.add("j");
		List<String> lexprStr1Temp = new BasicEList<String>(); lexprStr1Temp.add("i"); lexprStr1Temp.add("j"); lexprStr1Temp.add("j");
		groupAlInfoL.put("L", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1Temp, lindStr1Temp, lexprStr1Temp));
		
		// Temp1, Temp2
		List<String> lparamStr2Temp = new BasicEList<String>(); lparamStr2Temp.add("N");
		List<String> lindStr2Temp = new BasicEList<String>(); lindStr2Temp.add("i"); lindStr2Temp.add("j"); lindStr2Temp.add("k");
		List<String> lexprStr2Temp = new BasicEList<String>(); lexprStr2Temp.add("i"); lexprStr2Temp.add("j"); lexprStr2Temp.add("k");
		groupAlInfoL.put("Temp1", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr2Temp, lindStr2Temp, lexprStr2Temp));
		
		List<String> lparamStr3Temp = new BasicEList<String>(); lparamStr3Temp.add("N");
		List<String> lindStr3Temp = new BasicEList<String>(); lindStr3Temp.add("i"); lindStr3Temp.add("j"); lindStr3Temp.add("k");
		List<String> lexprStr3Temp = new BasicEList<String>(); lexprStr3Temp.add("i"); lexprStr3Temp.add("j"); lexprStr3Temp.add("k");
		groupAlInfoL.put("Temp2", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr3Temp, lindStr3Temp, lexprStr3Temp));
		
		alignmentInfo.add(groupAlInfoL);
		
		
		List<Integer> lMinBlParam = new BasicEList<Integer>(); lMinBlParam.add(2);
		
		parseAndTransformProgram_SubSystem("testcases/cholesky/cholesky_noReduce.ab",
				scaleInputs, true, 2, alignmentInfo, lMinBlParam);
		
	}
	
	@Test
	public void test_CARTSubSystem_program_Test9() {
		Map<String,List<Integer>> scaleInputs1 = new HashMap<String,List<Integer>>();
		
		List<Integer> lScaleTemp = new BasicEList<Integer>();
		lScaleTemp.add(1); lScaleTemp.add(1); lScaleTemp.add(1);
		scaleInputs1.put("temp_B", lScaleTemp);
		
		List<Integer> lScaleB = new BasicEList<Integer>();
		lScaleB.add(1); lScaleB.add(1); lScaleB.add(1);
		scaleInputs1.put("B", lScaleB);
		
		
		List<Map<String,AffineFunction>> alignmentInfo1 = new BasicEList<Map<String,AffineFunction>>();
		
		// Group 1 of alignmentInfo1: temp and B
		Map<String,AffineFunction> group1AlInfo1 = new HashMap<String,AffineFunction>();
		
		List<String> lparamStr1Temp = new BasicEList<String>(); lparamStr1Temp.add("TSTEPS"); lparamStr1Temp.add("N"); lparamStr1Temp.add("M");
		List<String> lindStr1Temp = new BasicEList<String>(); lindStr1Temp.add("t"); lindStr1Temp.add("i"); lindStr1Temp.add("j");
		List<String> lexprStr1Temp = new BasicEList<String>(); lexprStr1Temp.add("t"); lexprStr1Temp.add("t+i"); lexprStr1Temp.add("t+j");
		group1AlInfo1.put("temp_B", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1Temp, lindStr1Temp, lexprStr1Temp));
		
		List<String> lparamStr1B= new BasicEList<String>(); lparamStr1B.add("TSTEPS"); lparamStr1B.add("N"); lparamStr1B.add("M");
		List<String> lindStr1B = new BasicEList<String>(); lindStr1B.add("t"); lindStr1B.add("i"); lindStr1B.add("j");
		List<String> lexprStr1B = new BasicEList<String>(); lexprStr1B.add("t"); lexprStr1B.add("i+t"); lexprStr1B.add("j+t");
		group1AlInfo1.put("B", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1B, lindStr1B, lexprStr1B));
		
		alignmentInfo1.add(group1AlInfo1);

		List<Integer> lMinBlParam = new BasicEList<Integer>(); lMinBlParam.add(2); lMinBlParam.add(2); lMinBlParam.add(2);
		parseAndTransformProgram_SubSystem("alphabets/SubSystemExamples/Benchmark_CART/Heat2D/heat_2d.ab",
				scaleInputs1, true, 6, alignmentInfo1, lMinBlParam);
		// heat_2d
	}
	
	@Test
	public void test_CARTSubSystem_program_Test10() {
		Map<String,List<Integer>> scaleInputs1 = new HashMap<String,List<Integer>>();
		
		List<Integer> lScaleTemp = new BasicEList<Integer>();
		lScaleTemp.add(1); lScaleTemp.add(1); lScaleTemp.add(1); lScaleTemp.add(1);
		scaleInputs1.put("temp_B", lScaleTemp);
		
		List<Integer> lScaleB = new BasicEList<Integer>();
		lScaleB.add(1); lScaleB.add(1); lScaleB.add(1); lScaleB.add(1);
		scaleInputs1.put("B", lScaleB);
		
		
		List<Map<String,AffineFunction>> alignmentInfo1 = new BasicEList<Map<String,AffineFunction>>();
		
		// Group 1 of alignmentInfo1: temp and B
		Map<String,AffineFunction> group1AlInfo1 = new HashMap<String,AffineFunction>();
		
		List<String> lparamStr1Temp = new BasicEList<String>();
			lparamStr1Temp.add("TSTEPS"); lparamStr1Temp.add("N"); lparamStr1Temp.add("M"); lparamStr1Temp.add("K");
		List<String> lindStr1Temp = new BasicEList<String>();
			lindStr1Temp.add("t"); lindStr1Temp.add("i"); lindStr1Temp.add("j"); lindStr1Temp.add("k");
		List<String> lexprStr1Temp = new BasicEList<String>();
			lexprStr1Temp.add("t"); lexprStr1Temp.add("t+i"); lexprStr1Temp.add("t+j"); lexprStr1Temp.add("t+k");
		group1AlInfo1.put("temp_B", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1Temp, lindStr1Temp, lexprStr1Temp));
		
		List<String> lparamStr1B= new BasicEList<String>();
			lparamStr1B.add("TSTEPS"); lparamStr1B.add("N"); lparamStr1B.add("M"); lparamStr1B.add("K");
		List<String> lindStr1B = new BasicEList<String>();
			lindStr1B.add("t"); lindStr1B.add("i"); lindStr1B.add("j"); lindStr1B.add("k");
		List<String> lexprStr1B = new BasicEList<String>();
			lexprStr1B.add("t"); lexprStr1B.add("i+t"); lexprStr1B.add("j+t"); lexprStr1B.add("k+t");
		group1AlInfo1.put("B", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1B, lindStr1B, lexprStr1B));
		
		alignmentInfo1.add(group1AlInfo1);

		List<Integer> lMinBlParam = new BasicEList<Integer>(); lMinBlParam.add(2); lMinBlParam.add(2); lMinBlParam.add(2); lMinBlParam.add(2);
		parseAndTransformProgram_SubSystem("alphabets/SubSystemExamples/Benchmark_CART/Heat3D/heat_3d.ab",
				scaleInputs1, true, 6, alignmentInfo1, lMinBlParam);
		// heat_3d
		
		// TODO: do the full transformation in 362s, BUT takes too much time to save
	}
	
	@Test
	public void test_CARTSubSystem_program_Test11() {
		Map<String,List<Integer>> scaleInputs1 = new HashMap<String,List<Integer>>();
		
		List<Integer> lScaleTemp = new BasicEList<Integer>();
		lScaleTemp.add(1); lScaleTemp.add(1); lScaleTemp.add(1);
		scaleInputs1.put("temp_B", lScaleTemp);
		
		List<Integer> lScaleB = new BasicEList<Integer>();
		lScaleB.add(1); lScaleB.add(1); lScaleB.add(1);
		scaleInputs1.put("B", lScaleB);
		
		
		List<Map<String,AffineFunction>> alignmentInfo1 = new BasicEList<Map<String,AffineFunction>>();
		
		// Group 1 of alignmentInfo1: temp and B
		Map<String,AffineFunction> group1AlInfo1 = new HashMap<String,AffineFunction>();
		
		List<String> lparamStr1Temp = new BasicEList<String>(); lparamStr1Temp.add("TSTEPS"); lparamStr1Temp.add("N"); lparamStr1Temp.add("M");
		List<String> lindStr1Temp = new BasicEList<String>(); lindStr1Temp.add("t"); lindStr1Temp.add("i"); lindStr1Temp.add("j");
		List<String> lexprStr1Temp = new BasicEList<String>(); lexprStr1Temp.add("t"); lexprStr1Temp.add("3t+i"); lexprStr1Temp.add("3t+j");
		group1AlInfo1.put("temp_B", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1Temp, lindStr1Temp, lexprStr1Temp));
		
		List<String> lparamStr1B= new BasicEList<String>(); lparamStr1B.add("TSTEPS"); lparamStr1B.add("N"); lparamStr1B.add("M");
		List<String> lindStr1B = new BasicEList<String>(); lindStr1B.add("t"); lindStr1B.add("i"); lindStr1B.add("j");
		List<String> lexprStr1B = new BasicEList<String>(); lexprStr1B.add("t"); lexprStr1B.add("i+3t"); lexprStr1B.add("j+3t");
		group1AlInfo1.put("B", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1B, lindStr1B, lexprStr1B));
		
		alignmentInfo1.add(group1AlInfo1);
		
		List<Integer> lMinBlParam = new BasicEList<Integer>(); lMinBlParam.add(2); lMinBlParam.add(2); lMinBlParam.add(2);
		parseAndTransformProgram_SubSystem("alphabets/SubSystemExamples/Benchmark_CART/Wave2D/wave_2d.ab",
				scaleInputs1, true, 8, alignmentInfo1, lMinBlParam);
		
		// TODO: wave_2d => does not pass... :/
		//		=> too much cases... :/
	}
	
	
	
	/* -------------------- TEST SCHEDULE C OUTLINING -------------------- */
	private List<PRDG> buildPRDGOutlinedProgram(Program program, String mainSystemName) {
		List<PRDG> retPRDG = new BasicEList<PRDG>();
		for (AffineSystem syst : program.getSystems()) {
			if (syst.getName().equals(mainSystemName)) {
				
				// Default PRDG
				PRDG prdgMain = PRDGBuilder.build(syst);
				
				// Modifications done to the PRDG:
				//		- Invert directions of arrows
				//		- functions becomes only on blocks
				//		- node only on blocks
				// THEN - Replace Hedges by normal edges
				List<PRDGEdge> lnEdge = new BasicEList<PRDGEdge>();
				for (int k=0; k<prdgMain.getEdges().size(); k++) {
					PRDGEdge OldEdge = prdgMain.getEdges().get(k);
					Domain domEdge = PolyhedralIRUserFactory.eINSTANCE.createDomain(OldEdge.getDomain());
					List<AffineExpression> lIndProjFunc = new BasicEList<AffineExpression>();
					for (int i=0; i<domEdge.getNIndices()/2; i++)
						lIndProjFunc.add(IntExpressionBuilder.affine(domEdge.getIndices().get(i)));
					AffineFunction projFunc = PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(domEdge.getParams(), domEdge.getIndices(), lIndProjFunc);
					Domain nDom = domEdge.image(projFunc);
					
					// AffineFunction: we keep only the blocked dimensions in both sides
					AffineFunction affFunc = PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(OldEdge.getFunction().getMapping());
					
					List<Variable> lVar = new BasicEList<Variable>();
					for (int i=0; i<affFunc.getNIndices()/2; i++)
						lVar.add(affFunc.getIndices().get(i));
					
					List<AffineExpression> lExpr = new BasicEList<AffineExpression>();
					for (int i=0; i<affFunc.getExpressions().size()/2; i++)
						lExpr.add(affFunc.getExpressions().get(i));
					
					AffineFunction nFunc = PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(affFunc.getParams(), lVar, lExpr);
					lnEdge.add(PRDGUserFactory.createPRDGEdge(OldEdge.getDestination(), OldEdge.getSource(), nDom.getPMdomain(), nFunc.getPMmapping()));
				}
				
				for (int k=0; k<prdgMain.getEdges().size(); k++) {
					PRDGEdge oldEdge = prdgMain.getEdges().get(k);
					oldEdge.getSource().getSources().remove(oldEdge);
					oldEdge.getDestination().getDestinations().remove(oldEdge);
				}
				prdgMain.getEdges().clear();
				
				for (int k=0; k<lnEdge.size(); k++) {
					PRDGEdge nEdge = lnEdge.get(k);
					prdgMain.getEdges().add(nEdge);
					nEdge.getDestination().getDestinations().add(nEdge);
					nEdge.getSource().getSources().add(nEdge);
				}
				
				// Hyper-edge management
				for (int k=0; k<prdgMain.getHedges().size(); k++) {
					PRDGSubSystemHyperEdge hEdge = prdgMain.getHedges().get(k);
					
					String nameFirstOutUEq = hEdge.getSources().get(0).getName();
					UseEquation uEq = null;
					for (UseEquation uEqCandidate : syst.getUseEquations())
						if (uEqCandidate.getOutputs().get(0).getName()==nameFirstOutUEq)
							uEq = uEqCandidate;
					if (uEq==null)
						throw new RuntimeException("uEq not found...");
					
					// Nodes corresponding to a UseEquation
					PRDGNode nodeUEq = PRDGUserFactory.createPRDGNode(uEq.getLabel(), uEq.getExtensionDomain().copy().getPMdomain());
					prdgMain.getNodes().add(nodeUEq);
					
					// Adding edges
					
					// Edges useEq => Output
					for (VariableDeclaration varDeclOut : uEq.getOutputs()) {
						PRDGNode dest = prdgMain.getNode(varDeclOut.getName());
						PRDGEdge nEdge = PRDGUserFactory.createPRDGEdge(
								nodeUEq, dest, uEq.getExtensionDomain().copy().getPMdomain(),
								PolyhedralIRUtility.createIdentityFunction(uEq.getExtensionDomain()).getPMmapping());
						
						// Commit
						prdgMain.getEdges().add(nEdge);
						nodeUEq.getSources().add(nEdge);
						dest.getDestinations().add(nEdge);
					}
					
					// Edges inVar => UseEq
					for (PRDGNode inputUseEqNode : hEdge.getDestinations()) {
						
						PRDGEdge nEdge = PRDGUserFactory.createPRDGEdge(inputUseEqNode, nodeUEq,
								uEq.getExtensionDomain().copy().getPMdomain(),
								PolyhedralIRUtility.createIdentityFunction(uEq.getExtensionDomain()).getPMmapping());
						prdgMain.getEdges().add(nEdge);
						inputUseEqNode.getSources().add(nEdge);
						nodeUEq.getDestinations().add(nEdge);
					}
				}
				prdgMain.getHedges().clear();
				
				for (PRDGNode node : prdgMain.getNodes()) {
					Domain oldDom = PolyhedralIRUserFactory.eINSTANCE.createDomain(node.getDomain());
					List<AffineExpression> lIndProjFunc = new BasicEList<AffineExpression>();
					for (int i=0; i<oldDom.getNIndices()/2; i++)
						lIndProjFunc.add(IntExpressionBuilder.affine(oldDom.getIndices().get(i)));
					AffineFunction projFunc = PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(oldDom.getParams(), oldDom.getIndices(), lIndProjFunc);
					Domain nDom = oldDom.image(projFunc);
					
					node.setDomain(nDom.getPMdomain());
				}
				
				retPRDG.add(prdgMain);
				
			} else {
				// Build PRDG
				PRDG prdg = PRDGBuilder.build(syst);
				
				// Revert PRDG direction of edges
				PRDG reverted = Analysis.revertPRDGEdges(prdg);
				
				retPRDG.add(reverted);
			}
		}
		return retPRDG;
	}
	
	@Test
	public void test_CARTSubSystem_J2D_FeautrierScheduler() {
		long _starttime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/SubSystemExamples/Benchmark_CART/Jacobi2D/J2D_CARTOutline.ab");
		
		long currentTime = System.currentTimeMillis() - _starttime;
		long mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Parsing done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		List<PRDG> lPrdg = buildPRDGOutlinedProgram(program, "jacobi_2d");
		
		// Scheduler
		for (int k=0; k<lPrdg.size(); k++) {
			PRDG prdg = lPrdg.get(k);
			
			IPRDGScheduler scheduler = new FeautrierISLScheduler();
			try {
				EList<ScheduledStatement> stmts = scheduler.schedule(prdg);
			} catch (SchedulingException se) {
				System.err.println("SchedulingExecption: " + se.getMessage());
			}
		}
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Scheduler done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
	}
	
	@Test
	public void test_CARTNoSubSystem_J2D_FeautrierScheduler() {
		Map<String,List<Integer>> scaleInputs1 = new HashMap<String,List<Integer>>();
		
		List<Integer> lScaleTemp = new BasicEList<Integer>();
		lScaleTemp.add(1); lScaleTemp.add(1); lScaleTemp.add(1);
		scaleInputs1.put("temp_B", lScaleTemp);
		
		List<Integer> lScaleB = new BasicEList<Integer>();
		lScaleB.add(1); lScaleB.add(1); lScaleB.add(1);
		scaleInputs1.put("B", lScaleB);
		
		
		List<Map<String,AffineFunction>> alignmentInfo1 = new BasicEList<Map<String,AffineFunction>>();
		
		// Group 1 of alignmentInfo1: temp and B
		Map<String,AffineFunction> group1AlInfo1 = new HashMap<String,AffineFunction>();
		
		List<String> lparamStr1Temp = new BasicEList<String>(); lparamStr1Temp.add("TSTEPS"); lparamStr1Temp.add("N"); lparamStr1Temp.add("M");
		List<String> lindStr1Temp = new BasicEList<String>(); lindStr1Temp.add("t"); lindStr1Temp.add("i"); lindStr1Temp.add("j");
		List<String> lexprStr1Temp = new BasicEList<String>(); lexprStr1Temp.add("t"); lexprStr1Temp.add("t+i"); lexprStr1Temp.add("t+j");
		group1AlInfo1.put("temp_B", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1Temp, lindStr1Temp, lexprStr1Temp));
		
		List<String> lparamStr1B= new BasicEList<String>(); lparamStr1B.add("TSTEPS"); lparamStr1B.add("N"); lparamStr1B.add("M");
		List<String> lindStr1B = new BasicEList<String>(); lindStr1B.add("t"); lindStr1B.add("i"); lindStr1B.add("j");
		List<String> lexprStr1B = new BasicEList<String>(); lexprStr1B.add("t"); lexprStr1B.add("i+t"); lexprStr1B.add("j+t");
		group1AlInfo1.put("B", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1B, lindStr1B, lexprStr1B));
		
		alignmentInfo1.add(group1AlInfo1);

		List<Integer> lMinBlParam = new BasicEList<Integer>(); lMinBlParam.add(2); lMinBlParam.add(2); lMinBlParam.add(2);
		
		
		long _starttime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/SubSystemExamples/Benchmark_CART/Jacobi2D/jacobi_2d.ab");
		ParametricTiling.parametricTiling_Outlining_noSubSystem(program.getSystems().get(0), "b", scaleInputs1, true, 6, lMinBlParam, alignmentInfo1);
		
		
		long currentTime = System.currentTimeMillis() - _starttime;
		long mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "System computed" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		
		// FARKAS
		// Build PRDG
		PRDG prdg = PRDGBuilder.build(program.getSystems().get(0));
		

		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "PRDG Built" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		// Revert PRDG direction of edges
		PRDG reverted = Analysis.revertPRDGEdges(prdg);
		

		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "PRDG Reverted" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		//*** PRDG Built => [Current time = 221325 ms | Memory taken = 1301 MB]
		//*** PRDG Reverted => [Current time = 221981 ms | Memory taken = 1301 MB]
		
		// Scheduler
		IPRDGScheduler scheduler = new FeautrierISLScheduler();
		try {
			EList<ScheduledStatement> stmts = scheduler.schedule(reverted);
		} catch (SchedulingException se) {
			System.err.println("SchedulingExecption: " + se.getMessage());
		}
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Scheduler done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		return;
	}
	
	// J2D - RESULT: 4.4 seconds (no SubSystem) VS 3.1 seconds (SubSystem)		==> About 30% speed-up in analysis !!!
	
	@Test
	public void test_CARTSubSystem_J1D_FeautrierScheduler() {
		long _starttime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/SubSystemExamples/Benchmark_CART/Jacobi1D/J1D_CARTOutline.ab");
		
		long currentTime = System.currentTimeMillis() - _starttime;
		long mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Parsing done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		List<PRDG> lPrdg = buildPRDGOutlinedProgram(program, "jacobi_1d");
		
		// Scheduler
		for (int k=0; k<lPrdg.size(); k++) {
			PRDG prdg = lPrdg.get(k);
			
			IPRDGScheduler scheduler = new FeautrierISLScheduler();
			try {
				EList<ScheduledStatement> stmts = scheduler.schedule(prdg);
			} catch (SchedulingException se) {
				System.err.println("SchedulingExecption: " + se.getMessage());
			}
		}
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Scheduler done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
	}
	
	@Test
	public void test_CARTNoSubSystem_J1D_FeautrierScheduler() {
		Map<String,List<Integer>> scaleInputs1 = new HashMap<String,List<Integer>>();
		
		List<Integer> lScaleTemp = new BasicEList<Integer>();
		lScaleTemp.add(1); lScaleTemp.add(1); lScaleTemp.add(1);
		scaleInputs1.put("temp_B", lScaleTemp);
		
		List<Integer> lScaleB = new BasicEList<Integer>();
		lScaleB.add(1); lScaleB.add(1); lScaleB.add(1);
		scaleInputs1.put("B", lScaleB);
		
		
		List<Map<String,AffineFunction>> alignmentInfo1 = new BasicEList<Map<String,AffineFunction>>();
		
		// Group 1 of alignmentInfo1: temp and B
		Map<String,AffineFunction> group1AlInfo1 = new HashMap<String,AffineFunction>();
		
		List<String> lparamStr1Temp = new BasicEList<String>(); lparamStr1Temp.add("TSTEPS"); lparamStr1Temp.add("N"); lparamStr1Temp.add("M");
		List<String> lindStr1Temp = new BasicEList<String>(); lindStr1Temp.add("t"); lindStr1Temp.add("i"); lindStr1Temp.add("j");
		List<String> lexprStr1Temp = new BasicEList<String>(); lexprStr1Temp.add("t"); lexprStr1Temp.add("t+i"); lexprStr1Temp.add("t+j");
		group1AlInfo1.put("temp_B", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1Temp, lindStr1Temp, lexprStr1Temp));
		
		List<String> lparamStr1B= new BasicEList<String>(); lparamStr1B.add("TSTEPS"); lparamStr1B.add("N"); lparamStr1B.add("M");
		List<String> lindStr1B = new BasicEList<String>(); lindStr1B.add("t"); lindStr1B.add("i"); lindStr1B.add("j");
		List<String> lexprStr1B = new BasicEList<String>(); lexprStr1B.add("t"); lexprStr1B.add("i+t"); lexprStr1B.add("j+t");
		group1AlInfo1.put("B", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1B, lindStr1B, lexprStr1B));
		
		alignmentInfo1.add(group1AlInfo1);

		List<Integer> lMinBlParam = new BasicEList<Integer>(); lMinBlParam.add(2); lMinBlParam.add(2); lMinBlParam.add(2);
		
		long _starttime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/SubSystemExamples/Benchmark_CART/Heat2D/heat_2d.ab");
		ParametricTiling.parametricTiling_Outlining_noSubSystem(program.getSystems().get(0), "b", scaleInputs1, true, 6, lMinBlParam, alignmentInfo1);
		
		long currentTime = System.currentTimeMillis() - _starttime;
		long mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "System computed" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		
		// FARKAS
		// Build PRDG
		PRDG prdg = PRDGBuilder.build(program.getSystems().get(0));
		

		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "PRDG Built" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		// Revert PRDG direction of edges
		PRDG reverted = Analysis.revertPRDGEdges(prdg);
		

		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "PRDG Reverted" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		//*** PRDG Built => [Current time = 221325 ms | Memory taken = 1301 MB]
		//*** PRDG Reverted => [Current time = 221981 ms | Memory taken = 1301 MB]
		
		// Scheduler
		IPRDGScheduler scheduler = new FeautrierISLScheduler();
		try {
			EList<ScheduledStatement> stmts = scheduler.schedule(reverted);
		} catch (SchedulingException se) {
			System.err.println("SchedulingExecption: " + se.getMessage());
		}
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Scheduler done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		return;
	}
	
	// J1D - RESULT: Comparable (both around 0.1 seconds)						===> No speed-up in analysis, but no loss also !!!
	
	@Test
	public void test_CARTSubSystem_H2D_FeautrierScheduler() {
		long _starttime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/SubSystemExamples/Benchmark_CART/Heat2D/heat_2dOutline.ab");
		
		long currentTime = System.currentTimeMillis() - _starttime;
		long mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Parsing done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		List<PRDG> lPrdg = buildPRDGOutlinedProgram(program, "heat_2d");
		
		// Scheduler
		for (int k=0; k<lPrdg.size(); k++) {
			PRDG prdg = lPrdg.get(k);
			
			IPRDGScheduler scheduler = new FeautrierISLScheduler();
			try {
				EList<ScheduledStatement> stmts = scheduler.schedule(prdg);
			} catch (SchedulingException se) {
				System.err.println("SchedulingExecption: " + se.getMessage());
			}
		}
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Scheduler done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
	}
	
	@Test
	public void test_CARTNoSubSystem_H2D_FeautrierScheduler() {
		Map<String,List<Integer>> scaleInputs1 = new HashMap<String,List<Integer>>();
		
		List<Integer> lScaleTemp = new BasicEList<Integer>();
		lScaleTemp.add(1); lScaleTemp.add(1); lScaleTemp.add(1);
		scaleInputs1.put("temp_B", lScaleTemp);
		
		List<Integer> lScaleB = new BasicEList<Integer>();
		lScaleB.add(1); lScaleB.add(1); lScaleB.add(1);
		scaleInputs1.put("B", lScaleB);
		
		
		List<Map<String,AffineFunction>> alignmentInfo1 = new BasicEList<Map<String,AffineFunction>>();
		
		// Group 1 of alignmentInfo1: temp and B
		Map<String,AffineFunction> group1AlInfo1 = new HashMap<String,AffineFunction>();
		
		List<String> lparamStr1Temp = new BasicEList<String>(); lparamStr1Temp.add("TSTEPS"); lparamStr1Temp.add("N"); lparamStr1Temp.add("M");
		List<String> lindStr1Temp = new BasicEList<String>(); lindStr1Temp.add("t"); lindStr1Temp.add("i"); lindStr1Temp.add("j");
		List<String> lexprStr1Temp = new BasicEList<String>(); lexprStr1Temp.add("t"); lexprStr1Temp.add("t+i"); lexprStr1Temp.add("t+j");
		group1AlInfo1.put("temp_B", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1Temp, lindStr1Temp, lexprStr1Temp));
		
		List<String> lparamStr1B= new BasicEList<String>(); lparamStr1B.add("TSTEPS"); lparamStr1B.add("N"); lparamStr1B.add("M");
		List<String> lindStr1B = new BasicEList<String>(); lindStr1B.add("t"); lindStr1B.add("i"); lindStr1B.add("j");
		List<String> lexprStr1B = new BasicEList<String>(); lexprStr1B.add("t"); lexprStr1B.add("i+t"); lexprStr1B.add("j+t");
		group1AlInfo1.put("B", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1B, lindStr1B, lexprStr1B));
		
		alignmentInfo1.add(group1AlInfo1);

		List<Integer> lMinBlParam = new BasicEList<Integer>(); lMinBlParam.add(2); lMinBlParam.add(2); lMinBlParam.add(2);
		
		long _starttime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/EnerySavingExamples/jacobi_1d/jacobi_1d.ab");
		ParametricTiling.parametricTiling_Outlining_noSubSystem(program.getSystems().get(0), "b", scaleInputs1, true, 6, lMinBlParam, alignmentInfo1);
		
		long currentTime = System.currentTimeMillis() - _starttime;
		long mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "System computed" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		
		// FARKAS
		// Build PRDG
		PRDG prdg = PRDGBuilder.build(program.getSystems().get(0));
		

		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "PRDG Built" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		// Revert PRDG direction of edges
		PRDG reverted = Analysis.revertPRDGEdges(prdg);
		

		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "PRDG Reverted" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		//*** PRDG Built => [Current time = 221325 ms | Memory taken = 1301 MB]
		//*** PRDG Reverted => [Current time = 221981 ms | Memory taken = 1301 MB]
		
		// Scheduler
		IPRDGScheduler scheduler = new FeautrierISLScheduler();
		try {
			EList<ScheduledStatement> stmts = scheduler.schedule(reverted);
		} catch (SchedulingException se) {
			System.err.println("SchedulingExecption: " + se.getMessage());
		}
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Scheduler done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		return;
	}
	
	// H2D - RESULT: 4.2 seconds (no SubSystem) VS 3.3 seconds (SubSystem)
	
	@Test
	public void test_CARTSubSystem_W2D_FeautrierScheduler() {
		
		
		// TODO
		
	}
	
	// TODO: does not pass for CART + outlining... :/
	
	// W2D - RESULT: ... .... ...
	
	
	public void test_CARTSubSystem_J2D_Ratio_FeautrierScheduler() {
		
		
		
		
		// TODO
		
		
		
		
	}
	
	
	
	
	
	
	
	
	// TODO
	
	/* -------------------- TEST CLOOG OUTLINING -------------------- */
	@Test
	public void test_CARTSubSystem_J1D_ScheduleC() {
		int ratioI = 1;
		int ratioT = 1;
		
		// WARNING: do after the test 2 of subsystem with corresponding ratio
		
		String nameFileCodeGen = "jacobi_1dA_" + ratioI + "B_"+ ratioI +"_" + ratioT + "temp_B_" + ratioI + "_" + ratioT;
		String genCodeFile ="alphabets/SubSystemExamples/Benchmark_CART/WriteCTest/" + nameFileCodeGen + "/";
		
		
		long _starttime = System.currentTimeMillis();

		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/SubSystemExamples/Benchmark_CART/SubSystem/" + nameFileCodeGen + ".ab");
		
		long currentTime = System.currentTimeMillis() - _starttime;
		long mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Parsing done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		
		// *** TARGET MAPPING ***
		
		String mainSystName = "jacobi_1d";
		
		// --- Subsystems:
		//		- 0 => 7 : temp_B_bl
		//		- 8 + 9 : B_bl
		for (AffineSystem syst : program.getSystems()) {
			if (syst.getName().equals(mainSystName))
				continue;
			
			// TODO: if scaleT!=1, then might have subsystems with 2 outputs... :/
			
			
			
			if (syst.getName().startsWith("jacobi_1d_temp_B_bl_Tile_")) {
				// *** SubSystem of temp_B_bl
				//		Commands: (for i=0 - inspired from
				//			"alphabets/SubSystemExamples/Benchmark_CART/BenchYun/outline/script/..._default.cs" )
				//subsystem0 = "jacobi_1D_temp_B_bl_Tile_0";
				//setSpaceTimeMap(prog, subsystem0, "temp_bl_loc", "(iLoc,tLoc->tLoc,iLoc)");
				//setSpaceTimeMap(prog, subsystem0, "temp_bl_out", "(iLoc,tLoc->tLoc,iLoc)");
				//setMemorySpace(prog, subsystem0, "Temp", "temp_bl_loc");
				//setMemoryMap(prog, subsystem0,"temp_bl_loc","Temp","(iLoc, tLoc->iLoc - 2tLoc + 2b)");
				String subsystName = syst.getName();
				
				TargetMapping.setSpaceTimeMap(program, subsystName, "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)");
				TargetMapping.setSpaceTimeMap(program, subsystName, "temp_B_bl_out", "(tLoc,iLoc->tLoc,iLoc)");
				
				TargetMapping.setMemorySpace(program, subsystName, "Temp", "temp_B_bl_loc");
				TargetMapping.setMemoryMap(program, subsystName, "temp_B_bl_loc","Temp","(tLoc,iLoc->iLoc - 2tLoc + 2b)");
				continue;
			}
			
			if (syst.getName().startsWith("jacobi_1d_B_bl_Tile_")) {
				// *** SubSystem of B_bl
				//subsystem13 = "jacobi_1d_B_bl_Tile_9";
				//setSpaceTimeMap(prog, subsystem13, "B_bl_loc", "(iLoc->iLoc)");
				//setSpaceTimeMap(prog, subsystem13, "B_bl_out", "(iLoc->iLoc)");
				String subsystName = syst.getName();
				
				TargetMapping.setSpaceTimeMap(program, subsystName, "B_bl_loc", "(tLoc,iLoc->iLoc,tLoc)");
				TargetMapping.setSpaceTimeMap(program, subsystName, "B_bl_out", "(tLoc,iLoc->iLoc,tLoc)");
				continue;
			}
			
			throw new RuntimeException("Error in script: unknown subsystem: " + syst.getName());
		}
		
		
		// --- Main system:
		AffineSystem mainSyst = program.getSystem(mainSystName);
		
		// For each useEquation
		for (UseEquation useEq : mainSyst.getUseEquations()) {
			//label0 = "UseEquation_temp_bl_0";
			//setSpaceTimeMap(prog, system, label0, "(iBl,tBl->iBl+tBl,tBl,0,2,0)");
			//setSpaceTimeMapForUseEquationOptimization(prog, system, label0, 0, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)",
			//		"(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
			//setSpaceTimeMapForUseEquationOptimization(prog, system, label0, 1, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)",
			//			"(iBl,tBl->iBl+tBl,tBl,0,3,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
			
			String label = useEq.getLabel();
			TargetMapping.setSpaceTimeMap(program, mainSystName, label, "(tBl,iBl->iBl+tBl,tBl,0,2,0)");
			
			for (int i=0; i<useEq.getInputs().size(); i++)
				TargetMapping.setSpaceTimeMapForUseEquationOptimization(program, mainSystName, label, 0, i,
						"(tBl,iBl->iBl+tBl,tBl,0,0,0)", "(tBl,iBl->iBl+tBl,tBl,0,1,0)", "(tBl,iBl->iBl+tBl,tBl,0,4,0)");
			for (int i=0; i<useEq.getOutputs().size(); i++)
				TargetMapping.setSpaceTimeMapForUseEquationOptimization(program, mainSystName, label, 1, i,
						"(tBl,iBl->iBl+tBl,tBl,0,0,0)", "(tBl,iBl->iBl+tBl,tBl,0,3,0)", "(tBl,iBl->iBl+tBl,tBl,0,4,0)");
		}
		
		// Main Variables
		
		// setSpaceTimeMap(prog, system, "temp_bl", "(iBl,tBl,iLoc,tLoc-> tBl+iBl,tBl,1,tLoc,iLoc)");
		// setSpaceTimeMap(prog, system, "B_bl", "(iBl,iLoc-> 2Tb+iBl,Tb,2,iLoc,0)");
		// setParallel(prog, system, "", "1");
		TargetMapping.setSpaceTimeMap(program, mainSystName, "temp_B_bl", "(tBl,iBl,tLoc,iLoc-> tBl+iBl,tBl,1,tLoc,iLoc)");
		TargetMapping.setSpaceTimeMap(program, mainSystName, "B_bl_loc", "(tBl,iBl,tLoc,iLoc-> tBl+iBl,tBl,1,tLoc,iLoc)");
		TargetMapping.setSpaceTimeMap(program, mainSystName, "B_bl", "(tBl,iBl,tLoc,iLoc-> tBl+iBl,tBl,2,tLoc,iLoc)");
		
		TargetMapping.setParallel(program, mainSystName, "", "1");
		
		// setMemorySpace(prog, system, "TempSpace", "temp_bl");
		// setMemoryMap(prog,system,"temp_bl","TempSpace","(iBl,tBl,iLoc,tLoc->iBl - tBl + Tb, iLoc, tLoc)");
		TargetMapping.setMemorySpace(program, mainSystName, "TempSpace", "temp_B_bl");
		TargetMapping.setMemoryMap(program, mainSystName, "temp_B_bl", "TempSpace", "(tBl,iBl,tLoc,iLoc->iBl - tBl + TSTEPSb, iLoc, tLoc)");
		
		// setMemorySpace(prog, system, "B_bl", "B_bl, B_bl_0");
		TargetMapping.setMemorySpace(program, mainSystName, "BSpace", "B_bl, B_bl_loc");
		
		for (UseEquation useEq : mainSyst.getUseEquations()) {
			for (VariableDeclaration outUseEq : useEq.getOutputs()) {
				if (outUseEq.getName().startsWith("temp_B_bl_")) {
					//setMemorySpace(prog, system, "TempSpace", "temp_bl_0");
					//setMemoryMap(prog,system,"temp_bl_0","TempSpace","(iBl,tBl,iLoc,tLoc->iBl - tBl + Tb, iLoc, tLoc)");
					TargetMapping.setMemorySpace(program,mainSystName, "TempSpace", outUseEq.getName());
					TargetMapping.setMemoryMap(program, mainSystName, outUseEq.getName(),
							"TempSpace", "(tBl,iBl,tLoc,iLoc->iBl - tBl + TSTEPSb, iLoc, tLoc)");
					
					continue;
				}
				
				if (outUseEq.getName().startsWith("B_bl_")) {
					TargetMapping.setMemorySpace(program,mainSystName, "BSpace", outUseEq.getName());
					continue;
				}
				
				throw new RuntimeException("Output of use equation " + outUseEq.getName() + " not recognised...");
			}
		}
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "TargetMapping done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		
		// *** CODE GENERATION ****
		// generateScheduledCode(prog, system, outDir);
		// generateWrapper(prog, system, outDir);
		// generateMakefile(prog, system, outDir);
		CodeGen.generateScheduledCode(program, mainSystName, genCodeFile);
		CodeGen.generateWrapper(program, mainSystName, genCodeFile);
		CodeGen.generateMakefile(program, mainSystName, genCodeFile);
		
		return;
	}
	
	@Test
	public void test_CARTNoSubSystem_J1D_ScheduleC() {
		int scaleI = 1;
		int scaleJ = 1;
		
		Map<String,List<Integer>> scaleInputs1 = new HashMap<String,List<Integer>>();
		
		List<Integer> lScaleA = new BasicEList<Integer>();
		lScaleA.add(scaleI);
		scaleInputs1.put("A", lScaleA);
		
		List<Integer> lScaleTemp = new BasicEList<Integer>();
		lScaleTemp.add(scaleI); lScaleTemp.add(scaleJ);
		scaleInputs1.put("temp_B", lScaleTemp);
		
		List<Integer> lScaleB = new BasicEList<Integer>();
		lScaleB.add(scaleI); lScaleB.add(scaleJ);
		scaleInputs1.put("B", lScaleB);
		
		
		List<Map<String,AffineFunction>> alignmentInfo1 = new BasicEList<Map<String,AffineFunction>>();
		
		// Group 1 of alignmentInfo1: temp and B
		Map<String,AffineFunction> group1AlInfo1 = new HashMap<String,AffineFunction>();
		
		List<String> lparamStr1Temp = new BasicEList<String>(); lparamStr1Temp.add("TSTEPS"); lparamStr1Temp.add("N");
		List<String> lindStr1Temp = new BasicEList<String>(); lindStr1Temp.add("t"); lindStr1Temp.add("i");
		List<String> lexprStr1Temp = new BasicEList<String>(); lexprStr1Temp.add("t"); lexprStr1Temp.add("t+i");
		group1AlInfo1.put("temp_B", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1Temp, lindStr1Temp, lexprStr1Temp));
		
		List<String> lparamStr1B= new BasicEList<String>(); lparamStr1B.add("TSTEPS"); lparamStr1B.add("N");
		List<String> lindStr1B = new BasicEList<String>(); lindStr1B.add("t"); lindStr1B.add("i");
		List<String> lexprStr1B = new BasicEList<String>(); lexprStr1B.add("t"); lexprStr1B.add("i+t");
		group1AlInfo1.put("B", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1B, lindStr1B, lexprStr1B));
		
		alignmentInfo1.add(group1AlInfo1);
		
		List<Integer> lMinBlParam = new BasicEList<Integer>(); lMinBlParam.add(1); lMinBlParam.add(2);
		
		
		long _starttime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/EnerySavingExamples/jacobi_1d/jacobi_1d.ab");
		ParametricTiling.parametricTiling_Outlining_noSubSystem(program.getSystems().get(0),
				"b", scaleInputs1, true, 6, lMinBlParam, alignmentInfo1);
		
		long currentTime = System.currentTimeMillis() - _starttime;
		long mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "CART done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		//System.out.println(AShow.toString(program));
		//System.out.println("**************************");
		
		// *** TARGET MAPPING ***
		String systName = program.getSystems().get(0).getName();
		
		// Inspired from "alphabets/SubSystemExamples/Benchmark_CART/BenchYun/inline/script/scheduledC_Jacobi1DCart.cs"
		//setSpaceTimeMap(prog, system, "temp_bl", "(iBl,tBl,iLoc,tLoc-> tBl+iBl,tBl,tLoc,iLoc)");
		//setSpaceTimeMap(prog, system, "B_bl", "(iBl,iLoc-> 2Tb+iBl,Tb,1,iLoc)");
		//setParallel(prog, system, "", "1");
		TargetMapping.setSpaceTimeMap(program, systName, "temp_B_bl", "(tBl,iBl,tLoc,iLoc-> tBl+iBl,tBl,tLoc,iLoc)");
		TargetMapping.setSpaceTimeMap(program, systName, "B_bl", "(tBl,iBl,tLoc,iLoc-> tBl+iBl,tBl,tLoc,iLoc)");
		TargetMapping.setParallel(program, systName, "", "1");
		
		//setMemorySpace(prog, system, "TempSpace", "temp_bl");
		//setMemoryMap(prog,system,"temp_bl","TempSpace","(iBl,tBl,iLoc,tLoc->iBl - tBl + Tb, iLoc - 2tLoc + 2b)");
		TargetMapping.setMemorySpace(program, systName, "TempSpace", "temp_B_bl");
		TargetMapping.setMemoryMap(program, systName, "temp_B_bl", "TempSpace", "(tBl,iBl,tLoc,iLoc->iBl - tBl + TSTEPSb, iLoc - 2tLoc + 2b)");
		
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "TargetMapping done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		
		// *** CODE GENERATION ****
		// generateScheduledCode(prog, system, outDir);
		// generateWrapper(prog, system, outDir);
		// generateMakefile(prog, system, outDir);
		String genCodeFile = "alphabets/SubSystemExamples/Benchmark_CART/WriteCTest/GenCode/" + systName + "_CARTnoSubsystem/";;
		CodeGen.generateScheduledCode(program, systName, genCodeFile);
		CodeGen.generateWrapper(program, systName, genCodeFile);
		CodeGen.generateMakefile(program, systName, genCodeFile);
		
		return;
	}
	
	////////////////////////
	@Test
	public void test_CARTSubSystem_J2D_ScheduleC() {
		String nameFileCodeGen = "Jacobi2DSubSyst";
		String genCodeFile = "./test-out/" + nameFileCodeGen + "/";
//		String genCodeFile = "alphabets/SubSystemExamples/Benchmark_CART/WriteCTest/GenCode/" + nameFileCodeGen + "/";
		long _starttime = System.currentTimeMillis();
		
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/SubSystemExamples/Benchmark_CART/Jacobi2D/J2D_CARTOutline.ab");
		
		long currentTime = System.currentTimeMillis() - _starttime;
		long mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Parsing done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		// *** TargetMapping of subsystem
		
		// Subsystems working on temp_B_bl
		
		for (int i=0; i<31; i++) {
			String subSystName = "jacobi_2d_temp_B_bl_Tile_" + i;
			AffineSystem subSyst_temp_i = program.getSystem(subSystName);
			
			org.polymodel.polyhedralIR.targetMapping.TargetMapping tmSubSystTempi = subSyst_temp_i.getTargetMapping();
			
			// setSpaceTimeMap(prog, system, "temp_B_bl_loc", "(iLoc,jLoc,tLoc-> 0,tLoc+iLoc+jLoc,iLoc,jLoc)");
			VariableDeclaration varDeclTempBlLoc = subSyst_temp_i.getVariableDeclaration("temp_B_bl_loc");
			AffineFunction stmapTempBlLoc = PolyhedralIRUtility.parseAffineFunction(subSyst_temp_i.getParameters(),
					"(iLoc,jLoc,tLoc-> 0,tLoc+iLoc+jLoc,iLoc,jLoc)");
			tmSubSystTempi.getSpaceTimeLevel(0).getSpaceTimeMaps().put("temp_B_bl_loc",
					TargetMappingUserFactory.createStandardEquationSpaceTimeMap(varDeclTempBlLoc, stmapTempBlLoc));
			
			// setSpaceTimeMap(prog, system, "temp_B_bl_out", "(iLoc,jLoc,tLoc-> 0,tLoc+iLoc+jLoc,iLoc,jLoc)");
			VariableDeclaration varDeclTempBlOut = subSyst_temp_i.getVariableDeclaration("temp_B_bl_out");
			AffineFunction stmapTempBlOut = PolyhedralIRUtility.parseAffineFunction(subSyst_temp_i.getParameters(),
					"(iLoc,jLoc,tLoc-> 1,tLoc+iLoc+jLoc,iLoc,jLoc)");
			tmSubSystTempi.getSpaceTimeLevel(0).getSpaceTimeMaps().put("temp_B_bl_out",
					TargetMappingUserFactory.createStandardEquationSpaceTimeMap(varDeclTempBlOut, stmapTempBlOut));
			
			// setOrderingDimensions(prog, system, 0);
			tmSubSystTempi.getSpaceTimeLevel(0).getOrderingDimensions().add(0);
			SubSystemCodeGenTest.printScript(tmSubSystTempi);
		}
		
		// Subsystems working on temp_B
		for (int i=32; i<36; i++) {
			String subSystName = "jacobi_2d_B_bl_Tile_" + i;
			AffineSystem subSyst_B_i = program.getSystem(subSystName);
			
			org.polymodel.polyhedralIR.targetMapping.TargetMapping tmSubSystBi = subSyst_B_i.getTargetMapping();
			
			// setSpaceTimeMap(prog, system, "B_bl_loc", "(iLoc,jLoc,tLoc-> 0,tLoc+iLoc+jLoc,iLoc,jLoc)");
			VariableDeclaration varDeclTempBlLoc = subSyst_B_i.getVariableDeclaration("B_bl_loc");
			AffineFunction stmapTempBlLoc = PolyhedralIRUtility.parseAffineFunction(subSyst_B_i.getParameters(),
					"(iLoc,jLoc,tLoc-> 0,tLoc+iLoc+jLoc,iLoc,jLoc)");
			tmSubSystBi.getSpaceTimeLevel(0).getSpaceTimeMaps().put("B_bl_loc",
					TargetMappingUserFactory.createStandardEquationSpaceTimeMap(varDeclTempBlLoc, stmapTempBlLoc));
			
			// setSpaceTimeMap(prog, system, "B_bl_out", "(iLoc,jLoc,tLoc-> 0,tLoc+iLoc+jLoc,iLoc,jLoc)");
			VariableDeclaration varDeclTempBlOut = subSyst_B_i.getVariableDeclaration("B_bl_out");
			AffineFunction stmapTempBlOut = PolyhedralIRUtility.parseAffineFunction(subSyst_B_i.getParameters(),
					"(iLoc,jLoc,tLoc-> 0,tLoc+iLoc+jLoc,iLoc,jLoc)");
			tmSubSystBi.getSpaceTimeLevel(0).getSpaceTimeMaps().put("B_bl_out",
						TargetMappingUserFactory.createStandardEquationSpaceTimeMap(varDeclTempBlOut, stmapTempBlOut));
			
			// setOrderingDimensions(prog, system, 0);
			tmSubSystBi.getSpaceTimeLevel(0).getOrderingDimensions().add(0);
			SubSystemCodeGenTest.printScript(tmSubSystBi);
		}
		
		
		
		// *** Main system ***
		String mainSystName = "jacobi_2d";
		AffineSystem mainSyst = program.getSystem(mainSystName);
		
		org.polymodel.polyhedralIR.targetMapping.TargetMapping tmMain = mainSyst.getTargetMapping();
		
		
		// setSpaceTimeMap(prog,mainsystem, "temp_B_bl", "(tBl,iBl,jBl,i3,i4,i5-> tBl+iBl+jBl,iBl,jBl,1,i3,i4,i5,0)");
		VariableDeclaration varDeclTempBBl = mainSyst.getVariableDeclaration("temp_B_bl");
		AffineFunction stmapTempBBl = PolyhedralIRUtility.parseAffineFunction(mainSyst.getParameters(),
				"(tBl,iBl,jBl,i3,i4,i5-> tBl+iBl+jBl,iBl,jBl,1,0, i3,i4,i5)");
		tmMain.getSpaceTimeLevel(0).getSpaceTimeMaps().put("temp_B_bl",
					TargetMappingUserFactory.createStandardEquationSpaceTimeMap(varDeclTempBBl, stmapTempBBl));
		
		// setSpaceTimeMap(prog, mainsystem, "B_bl_loc", "(tBl,iBl,jBl,tLoc,iLoc,jLoc-> tBl+iBl+jBl,iBl,jBl,1,tLoc,iLoc,jLoc,0)");
		VariableDeclaration varDeclBBlLoc = mainSyst.getVariableDeclaration("B_bl_loc");
		AffineFunction stmapBBlLoc = PolyhedralIRUtility.parseAffineFunction(mainSyst.getParameters(),
				"(tBl,iBl,jBl,tLoc,iLoc,jLoc-> tBl+iBl+jBl,iBl,jBl, 1,0, tLoc,iLoc,jLoc)");
		tmMain.getSpaceTimeLevel(0).getSpaceTimeMaps().put("B_bl_loc",
					TargetMappingUserFactory.createStandardEquationSpaceTimeMap(varDeclBBlLoc, stmapBBlLoc));
		
		// setSpaceTimeMap(prog, mainsystem, "B_bl", "(tBl,iBl,tLoc,iLoc->tBl+iBl+jBl,iBl,jBl,1,tLoc,iLoc,jLoc,0)");
		VariableDeclaration varDeclBBl = mainSyst.getVariableDeclaration("B_bl");
		AffineFunction stmapBBl = PolyhedralIRUtility.parseAffineFunction(mainSyst.getParameters(),
				"(tBl,iBl,jBl,tLoc,iLoc,jLoc-> tBl+iBl+jBl,iBl,jBl, 1,1, tLoc,iLoc,jLoc)");
		tmMain.getSpaceTimeLevel(0).getSpaceTimeMaps().put("B_bl",
					TargetMappingUserFactory.createStandardEquationSpaceTimeMap(varDeclBBl, stmapBBl));
		
		for (int i=0; i<32; i++) {
			String labelUseEq_i = "UseEquation_temp_B_bl_" + i;
			UseEquation uEqi = mainSyst.getUseEquation(labelUseEq_i);
			
			// Inputs
			for (int numInput=0; numInput<uEqi.getInputs().size(); numInput++)
				TargetMapping.setSpaceTimeMapForUseEquationOptimization(program, mainSystName, labelUseEq_i, 0, numInput,
					"(tBl,iBl,jBl->tBl+iBl+jBl,iBl,jBl,0, 0)",
					"(tBl,iBl,jBl->tBl+iBl+jBl,iBl,jBl,0, 1)",
					"(tBl,iBl,jBl->tBl+iBl+jBl,iBl,jBl,0, 4)");
			
			// Execution
			// setSpaceTimeMap(prog, mainsystem, labelUseEq, "(tBl,iBl,tLoc,iLoc->tBl+iBl,iBl,jBl,0,tLoc,iLoc,jLoc,2)");
			AffineFunction stmapUseEqi = PolyhedralIRUtility.parseAffineFunction(mainSyst.getParameters(),
					"(tBl,iBl,jBl-> tBl+iBl+jBl,iBl,jBl,0, 2,0,0,0)");
			tmMain.getSpaceTimeLevel(0).getSpaceTimeMaps().put(
					labelUseEq_i, TargetMappingUserFactory.createUseEquationSpaceTimeMap(labelUseEq_i, stmapUseEqi, uEqi));
			
			// Outputs
			for (int numOuput=0; numOuput<uEqi.getOutputs().size(); numOuput++)
				TargetMapping.setSpaceTimeMapForUseEquationOptimization(program, mainSystName, labelUseEq_i, 1, numOuput,
					"(tBl,iBl,jBl->tBl+iBl+jBl,iBl,jBl,0, 0)",
					"(tBl,iBl,jBl->tBl+iBl+jBl,iBl,jBl,0, 3)",
					"(tBl,iBl,jBl->tBl+iBl+jBl,iBl,jBl,0, 4)");
		}
		
		for (int i=32; i<36; i++) {
			String labelUseEq_i = "UseEquation_B_bl_" + i;
			UseEquation uEqi = mainSyst.getUseEquation(labelUseEq_i);
			
			// Inputs
			for (int numInput=0; numInput<uEqi.getInputs().size(); numInput++)
				TargetMapping.setSpaceTimeMapForUseEquationOptimization(program, mainSystName, labelUseEq_i, 0, numInput,
					"(tBl,iBl,jBl->tBl+iBl+jBl,iBl,jBl,0, 0)",
					"(tBl,iBl,jBl->tBl+iBl+jBl,iBl,jBl,0, 1)",
					"(tBl,iBl,jBl->tBl+iBl+jBl,iBl,jBl,0, 4)");
			
			// Execution
			// setSpaceTimeMap(prog, mainsystem, labelUseEq, "(tBl,iBl,tLoc,iLoc->tBl+iBl,iBl,jBl,0,tLoc,iLoc,jLoc,2)");
			AffineFunction stmapUseEqi = PolyhedralIRUtility.parseAffineFunction(mainSyst.getParameters(),
					"(tBl,iBl,jBl-> tBl+iBl+jBl,iBl,jBl,0, 2,0,0,0)");
			tmMain.getSpaceTimeLevel(0).getSpaceTimeMaps().put(
					labelUseEq_i, TargetMappingUserFactory.createUseEquationSpaceTimeMap(labelUseEq_i, stmapUseEqi, uEqi));
			
			// Outputs
			for (int numOuput=0; numOuput<uEqi.getOutputs().size(); numOuput++)
				TargetMapping.setSpaceTimeMapForUseEquationOptimization(program, mainSystName, labelUseEq_i, 1, numOuput,
					"(tBl,iBl,jBl->tBl+iBl+jBl,iBl,jBl,0, 0)",
					"(tBl,iBl,jBl->tBl+iBl+jBl,iBl,jBl,0, 3)",
					"(tBl,iBl,jBl->tBl+iBl+jBl,iBl,jBl,0, 4)");
		}
		
		
		// Ordering dimensions
		tmMain.getSpaceTimeLevel(0).getOrderingDimensions().add(3);
		tmMain.getSpaceTimeLevel(0).getOrderingDimensions().add(4);
		
		SubSystemCodeGenTest.printScript(tmMain);
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "TargetMapping defined" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		
		// *** ScheduleC
		CodeGenOptions options = CodeGenOptions.scheduledCDefault();
		options.DEBUG = true;
		CodeGen.generateScheduledCode(program, mainSystName, options, genCodeFile, false);
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Code Gen (scheduleC) done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		CodeGen.generateWrapper(program, mainSystName, genCodeFile);
		CodeGen.generateMakefile(program, mainSystName, genCodeFile);
		
		currentTime = System.currentTimeMillis() - _starttime;
		mem = Runtime.getRuntime().totalMemory() / 1048576;
		System.out.println("*** " + "Code Gen all done" + " => [Current time = " + currentTime + " ms | Memory taken = " + mem + " MB]");
		
		// TODO: does not work... :/
		
	}
	
	
	
	
	
	/* -------------------- BENCHMARK -------------------- */
	
	// Script to generate all the writeC codes... :/
	@Test
	public void writeCScript_Jacobi1D() {
		
		// *** AlignmentInfo
		List<Map<String,AffineFunction>> alignmentInfo1 = new BasicEList<Map<String,AffineFunction>>();
		
		// Group 1 of alignmentInfo1: temp and B
		Map<String,AffineFunction> group1AlInfo1 = new HashMap<String,AffineFunction>();
		
		List<String> lparamStr1Temp = new BasicEList<String>(); lparamStr1Temp.add("TSTEPS"); lparamStr1Temp.add("N");
		List<String> lindStr1Temp = new BasicEList<String>(); lindStr1Temp.add("t"); lindStr1Temp.add("i");
		List<String> lexprStr1Temp = new BasicEList<String>(); lexprStr1Temp.add("t"); lexprStr1Temp.add("t+i");
		group1AlInfo1.put("temp_B", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1Temp, lindStr1Temp, lexprStr1Temp));
		
		List<String> lparamStr1B= new BasicEList<String>(); lparamStr1B.add("TSTEPS"); lparamStr1B.add("N");
		List<String> lindStr1B = new BasicEList<String>(); lindStr1B.add("t"); lindStr1B.add("i");
		List<String> lexprStr1B = new BasicEList<String>(); lexprStr1B.add("t"); lexprStr1B.add("i+t");
		group1AlInfo1.put("B", PolyhedralIRUtility.parseAffineFunctionFromString(lparamStr1B, lindStr1B, lexprStr1B));
		
		alignmentInfo1.add(group1AlInfo1);
		
		// COB of the program
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/EnerySavingExamples/jacobi_1d/jacobi_1d.ab");
		for (Map<String,AffineFunction> groupAlign : alignmentInfo1)
			for (String coBInfoStr : groupAlign.keySet())
				ChangeOfBasis.CoB(program.getSystems().get(0), coBInfoStr, groupAlign.get(coBInfoStr), true);
		
		// *** RATIOS ***
		int[] ratios = {1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 16};
		
		// TODO: taking too much memory
		
		//for (int k1=0; k1<ratios.length; k1++)
		//for (int k2=0; k2<ratios.length; k2++) {
		int k1 = 0;
		int k2 = 1;
		// max: 10
		
			System.out.println("CURRENT RATIO: " + ratios[k1] + " * " + ratios[k2]);
			
			// Getting the ratios
			Map<String,List<Integer>> scaleInputs1 = new HashMap<String,List<Integer>>();
			
			List<Integer> lScaleTemp = new BasicEList<Integer>();
			lScaleTemp.add(ratios[k1]); lScaleTemp.add(ratios[k2]);
			scaleInputs1.put("temp_B", lScaleTemp);
			
			List<Integer> lScaleB = new BasicEList<Integer>();
			lScaleB.add(ratios[k1]); lScaleB.add(ratios[k2]);
			scaleInputs1.put("B", lScaleB);
			
			List<Integer> lMinBlParam = new BasicEList<Integer>(); lMinBlParam.add(2); lMinBlParam.add(2);
			
			// Launch it!
			Program progRatio = program.copy();
			AffineSystem syst = progRatio.getSystems().get(0);
			
			Normalize.normalize(syst);
			ParametricTiling.parametricTiling(syst, "b", scaleInputs1, false, 4, lMinBlParam); // Does not scale
			
			// Save it!
			String nameFile = syst.getName() + "_" + ratios[k1] + "_" + ratios[k2];
			alphaz.mde.Utility.WriteToFile("alphabets/SubSystemExamples/Benchmark_CART/WriteCTest/Alphabets/"
					+nameFile+".ab", AShow.toSimplifiedString(syst));
			
			System.out.println("ALPHABET SAVED");
			
			// Check the program
			//System.out.println(UniquenessAndCompletenessCheck.validate(program).toString());
			
			// Generate the code -- WriteC, Wrapper, Makefile
			String genCodeFile = "alphabets/SubSystemExamples/Benchmark_CART/WriteCTest/" + "GenCode/" + nameFile + "/";
			CodeGen.generateWriteC(program, syst.getName(), genCodeFile);
			CodeGen.generateWrapper(program, syst.getName(), genCodeFile);
			CodeGen.generateMakefile(program, syst.getName(), genCodeFile);
			
		//}
	}
	
	@Test
	public void tempComputation() {
		List<String> lParam = new BasicEList<String>();
		lParam.add("Nb"); lParam.add("Tb"); lParam.add("Nl"); lParam.add("Tl"); lParam.add("b");
		Domain dom1 = PolyhedralIRUtility.parseDomain(lParam,
				"{iBl,tBl, iLoc,tLoc| 0<=iBl+tBl && 0<=Nb-3iBl-3tBl-4} || " +
				"{iBl,tBl, iLoc,tLoc| iBl+tBl==-1 && 1<=Nb && 3b<=iLoc} || " +
				"{iBl,tBl, iLoc,tLoc| 0<=iBl+tBl && 3+3iBl+3tBl==Nb && iLoc<=3b} || " +
				"{iBl,tBl, iLoc,tLoc| 0<=iBl+tBl && 2+3iBl+3tBl==Nb && iLoc<=2b} || " +
				"{iBl,tBl, iLoc,tLoc| 0<=iBl+tBl && 1+3iBl+3tBl==Nb && iLoc<=b}");
		
		Domain dom2 = PolyhedralIRUtility.parseDomain(lParam,
				"{iBl,tBl, iLoc,tLoc| 0<=tBl-iBl-1 && 0<=Tb-tBl+iBl-1} || " +
				"{iBl,tBl, iLoc,tLoc| 0<=tBl-iBl-1 && 0==Tb-tBl+iBl && tLoc<=0} || " +
				"{iBl,tBl, iLoc,tLoc| iBl==tBl && 1<=Tb && 0<=tLoc} || " +
				"{iBl,tBl, iLoc,tLoc| iBl==tBl+1 && tLoc==b}");
		
		Domain dom3 = PolyhedralIRUtility.parseDomain(lParam,
				"{iBl,tBl, iLoc,tLoc| -b<tLoc<=b && tLoc<=iLoc<tLoc+4b && -tLoc<iLoc<=4b-tLoc}");	// Domain of the local tile
		
		
		Domain dom123 = dom1.intersection(dom2).intersection(dom3); dom123.simplify(); System.out.println(dom123.toString()); // Domain of 0<=i<N && 0<=t<T
		
		
		
		Domain domi0 = PolyhedralIRUtility.parseDomain(lParam, "{iBl,tBl, iLoc,tLoc| iBl+tBl+1==0 && iLoc==3b}");
		Domain dom123i0 = dom123.intersection(domi0); dom123i0.simplify(); System.out.println(dom123i0.toString());
		
		Domain domiNm1 = PolyhedralIRUtility.parseDomain(lParam,
				"{iBl,tBl, iLoc,tLoc| 3iBl+3tBl-Nb+1==0 && iLoc==b-1} || " +
				"{iBl,tBl, iLoc,tLoc| 3iBl+3tBl-Nb+2==0 && iLoc==2b-1} || " +
				"{iBl,tBl, iLoc,tLoc| 3iBl+3tBl-Nb+3==0 && iLoc==3b-1} || " +
				"{iBl,tBl, iLoc,tLoc| 3iBl+3tBl-Nb+4==0 && iLoc==4b-1}");
		Domain dom123iNm1 = dom123.intersection(domiNm1); dom123iNm1.simplify(); System.out.println(dom123iNm1.toString());
		
		Domain domigt1 = PolyhedralIRUtility.parseDomain(lParam,					// Domain of 1<=i
				"{iBl,tBl, iLoc,tLoc| 3iBl+3tBl>=0} || " +
				"{iBl,tBl, iLoc,tLoc| 3iBl+3tBl+1==0 && b-1<=iLoc} || " +
				"{iBl,tBl, iLoc,tLoc| 3iBl+3tBl+2==0 && 2b-1<=iLoc} || " +
				"{iBl,tBl, iLoc,tLoc| 3iBl+3tBl+3==0 && 3b-1<=iLoc}");
		Domain domiltNm1 = PolyhedralIRUtility.parseDomain(lParam,					// Domain of i<=N-2
				"{iBl,tBl, iLoc,tLoc| Nb-3iBl-3tBl-5>=0} || " +
				"{iBl,tBl, iLoc,tLoc| Nb-3iBl-3tBl-4==0 && iLoc<=4b-2} || " +
				"{iBl,tBl, iLoc,tLoc| Nb-3iBl-3tBl-3==0 && iLoc<=3b-2}  || " +
				"{iBl,tBl, iLoc,tLoc| Nb-3iBl-3tBl-2==0 && iLoc<=2b-2} || " +
				"{iBl,tBl, iLoc,tLoc| Nb-3iBl-3tBl-1==0 && iLoc<=b-2} || ");
		Domain dom123igt1iltNm1 = domigt1.intersection(domiltNm1).intersection(dom123); dom123igt1iltNm1.simplify(); System.out.println(dom123igt1iltNm1.toString());
		
		
		System.out.println(" ------------------------------------ ");
		
		Domain debugDom =  PolyhedralIRUtility.parseDomain(lParam,
				"{iBl,tBl,iLoc,tLoc|iLoc+tLoc==2 && Tl==0 && Nl==0 && Tb>=2 && b>=2 && tBl>=iBl+3 && iBl+tBl>=0 && b>=iLoc && Nb>=3iBl+3tBl+2 && iLoc>=1}"
				+ "|| {iBl,tBl,iLoc,tLoc|4b+tLoc==iLoc+2 && Tl==0 && Nl==0 && Tb>=2 && b>=2 && tBl>=iBl+1 && iBl+tBl>=0 && Nb+4b>=3iBl+3tBl+iLoc+6 && 4b>=iLoc+1 && iLoc>=3b && Nb>=3iBl+3tBl+4}"
				+ "|| {iBl,tBl,iLoc,tLoc|iLoc+tLoc==2 && 3iBl+3tBl==Nb-1 && Tl==0 && Nl==0 && Nb>=2 && Tb>=2 && Nb>=6iBl+4 && iLoc>=1 && b>=iLoc+2}"
				+ "|| {iBl,tBl,iLoc,tLoc|4b+tLoc==iLoc+2 && iBl+tBl==-1 && Tl==0 && Nl==0 && Nb>=2 && Tb>=2 && 0>=iBl+1 && iLoc>=3b+1 && 4b>=iLoc+1}"
				+ "|| {iBl,tBl,iLoc,tLoc|iLoc==3b && 6tBl==Nb-3 && 6iBl==Nb-3 && Tl==0 && Nl==0 && Nb>=3 && Tb>=2 && b>=2 && tLoc>=1 && b>=tLoc}"
				+ "|| {iBl,tBl,iLoc,tLoc|iLoc+tLoc==2 && Tl==0 && Nl==0 && Tb>=2 && b>=2 && tBl>=iBl+1 && tBl>=1 && iLoc>=1 && iBl>=tBl-2 && Nb>=iBl+5tBl && b>=iLoc}"
				+ "|| {iBl,tBl,iLoc,tLoc|iLoc==b && 6tBl==Nb-1 && 6iBl==Nb-1 && Tl==0 && Nl==0 && Nb>=2 && Tb>=2 && b>=2 && tLoc>=1 && b>=tLoc}"
				+ "|| {iBl,tBl,iLoc,tLoc|iLoc+tLoc==2 && 6tBl==Nb+3 && 6iBl==Nb-9 && Tl==0 && Nl==0 && Nb>=3 && Tb>=2 && b>=2 && iLoc>=1 && b>=iLoc}"
				+ "|| {iBl,tBl,iLoc,tLoc|iLoc==2b && 6tBl==Nb-2 && 6iBl==Nb-2 && Tl==0 && Nl==0 && Nb>=2 && Tb>=2 && b>=2 && tLoc>=1 && b>=tLoc}"
				+ "|| {iBl,tBl,iLoc,tLoc|tLoc==1 && iLoc==1 && 6tBl==Nb-1 && 6iBl==Nb-1 && Tl==0 && Nl==0 && Nb>=2 && Tb>=2 && b>=3}"
				+ "|| {iBl,tBl,iLoc,tLoc|iLoc==3b && 3iBl+3tBl==Nb-3 && Tl==0 && Nl==0 && Nb>=3 && Tb>=2 && b>=2 && Nb>=6iBl+6 && b>=tLoc && b+tLoc>=1}"
				+ "|| {iBl,tBl,iLoc,tLoc|iLoc==2b && 3iBl+3tBl==Nb-2 && Tl==0 && Nl==0 && Nb>=2 && Tb>=2 && b>=2 && Nb>=6iBl+5 && b>=tLoc && b+tLoc>=1}"
				+ "|| {iBl,tBl,iLoc,tLoc|iLoc==b && 3iBl+3tBl==Nb-1 && Tl==0 && Nl==0 && Nb>=2 && Tb>=2 && b>=2 && Nb>=6iBl+4 && b>=tLoc && b+tLoc>=1}"
				+ "|| {iBl,tBl,iLoc,tLoc|tLoc==1 && iLoc==1 && tBl==iBl && Tl==0 && Nl==0 && Tb>=2 && b>=2 && iBl>=0 && Nb>=6iBl+2}"
				+ "|| {iBl,tBl,iLoc,tLoc|tLoc==1 && iLoc==4b-1 && tBl==iBl && Tl==0 && Nl==0 && Tb>=2 && b>=2 && iBl>=0 && Nb>=6iBl+5}"
				+ "|| {iBl,tBl,iLoc,tLoc|iLoc+tLoc==2 && 6tBl==Nb+4 && 6iBl==Nb-8 && Tl==0 && Nl==0 && Nb>=2 && Tb>=2 && iLoc>=1 && b>=iLoc && 2b>=iLoc+2}");

		Domain domDebugi0 = dom123i0.intersection(debugDom); domDebugi0.simplify(); System.out.println("i=0 => " + domDebugi0.toString());// => No bug here
		Domain domDebugiNm1 = domiNm1.intersection(debugDom); domDebugiNm1.simplify(); System.out.println("i=N-1 => " + domDebugiNm1.toString());// => No bug here
		Domain domDebugMiddle = dom123igt1iltNm1.intersection(debugDom); domDebugMiddle.simplify(); System.out.println(" middle => " + domDebugMiddle.toString());
		
		Domain middleBranch1ExprDom =  PolyhedralIRUtility.parseDomain(lParam,
				"{iBl,tBl,iLoc,tLoc|iLoc+tLoc==1 && Tl==0 && Nl==0 && Tb>=2 && b>=2 && tBl>=iBl+2 && iBl+tBl>=1 && Nb>=3iBl+3tBl+1 && iLoc>=0 && b>=iLoc}"
				+ "|| {iBl,tBl,iLoc,tLoc|b+tLoc==1 && Tl==0 && Nl==0 && Tb>=2 && b>=2 && tBl>=iBl+3 && iBl+tBl>=0 && Nb>=3iBl+3tBl+4 && iLoc>=b+1 && 3b>=iLoc}"
				+ "|| {iBl,tBl,iLoc,tLoc|iLoc+tLoc==1 && tBl==iBl+1 && Tl==0 && Nl==0 && Tb>=2 && b>=2 && iBl>=0 && Nb>=6iBl+4 && iLoc>=0 && b>=iLoc}"
				+ "|| {iBl,tBl,iLoc,tLoc|iLoc+tLoc==1 && 3iBl+3tBl==Nb && Tl==0 && Nl==0 && Nb>=3 && Tb>=2 && b>=2 && Nb>=6iBl+6 && 0>=iLoc-1 && iLoc>=0}"
				+ "|| {iBl,tBl,iLoc,tLoc|iLoc+tLoc==1 && iBl+tBl==0 && Tl==0 && Nl==0 && Nb>=2 && Tb>=2 && b>=2 && 0>=iBl+1 && iLoc>=1 && b>=iLoc}"
				+ "|| {iBl,tBl,iLoc,tLoc|b+tLoc==1 && tBl==iBl+2 && Tl==0 && Nl==0 && Tb>=2 && b>=2 && iBl>=-1 && Nb>=6iBl+10 && iLoc>=b+1 && 3b>=iLoc}"
				+ "|| {iBl,tBl,iLoc,tLoc|b+tLoc==1 && tBl==iBl+1 && Tl==0 && Nl==0 && Tb>=2 && b>=2 && iBl>=0 && Nb>=6iBl+6 && iLoc>=b+1 && 3b>=iLoc}"
				+ "|| {iBl,tBl,iLoc,tLoc|b+tLoc==1 && 3iBl+3tBl==Nb-2 && Tl==0 && Nl==0 && Nb>=2 && Tb>=2 && b>=2 && Nb>=6iBl+11 && iLoc>=b+1 && 2b>=iLoc-1}"
				+ "|| {iBl,tBl,iLoc,tLoc|b+tLoc==1 && 3iBl+3tBl==Nb-3 && Tl==0 && Nl==0 && Nb>=3 && Tb>=2 && b>=2 && Nb>=6iBl+12 && iLoc>=b+1 && 3b>=iLoc}"
				+ "|| {iBl,tBl,iLoc,tLoc|tLoc==1 && iLoc==0 && tBl==iBl && Tl==0 && Nl==0 && Tb>=2 && b>=2 && iBl>=1 && Nb>=6iBl}"
				+ "|| {iBl,tBl,iLoc,tLoc|b+tLoc==1 && iLoc==b+1 && 3iBl+3tBl==Nb-1 && Tl==0 && Nl==0 && Nb>=2 && Tb>=2 && b>=2 && Nb>=6iBl+10}"
				+ "|| {iBl,tBl,iLoc,tLoc|iLoc+tLoc==1 && 6tBl==Nb+3 && 6iBl==Nb-3 && Tl==0 && Nl==0 && Nb>=3 && Tb>=2 && b>=2 && 0>=iLoc-1 && iLoc>=0}"
				+ "|| {iBl,tBl,iLoc,tLoc|b+tLoc==1 && 6tBl==Nb+4 && 6iBl==Nb-8 && Tl==0 && Nl==0 && Nb>=2 && Tb>=2 && b>=2 && iLoc>=b+1 && 2b>=iLoc-1}"
				+ "|| {iBl,tBl,iLoc,tLoc|b+tLoc==1 && 6tBl==Nb+3 && 6iBl==Nb-9 && Tl==0 && Nl==0 && Nb>=3 && Tb>=2 && b>=2 && iLoc>=b+1 && 3b>=iLoc}"
				+ "|| {iBl,tBl,iLoc,tLoc|b+tLoc==1 && 6tBl==Nb+1 && 6iBl==Nb-5 && Tl==0 && Nl==0 && Nb>=2 && Tb>=2 && b>=2 && iLoc>=b+1 && 2b>=iLoc-1}"
				+ "|| {iBl,tBl,iLoc,tLoc|b+tLoc==1 && iLoc==b+1 && 6tBl==Nb+5 && 6iBl==Nb-7 && Tl==0 && Nl==0 && Nb>=2 && Tb>=2 && b>=2}"
				+ "|| {iBl,tBl,iLoc,tLoc|b+tLoc==1 && iLoc==b+1 && 6tBl==Nb+2 && 6iBl==Nb-4 && Tl==0 && Nl==0 && Nb>=2 && Tb>=2 && b>=2}"
				+ "|| {iBl,tBl,iLoc,tLoc|Tl==0 && Nl==0 && Tb>=2 && b>=2 && tBl>=iBl+1 && iBl+tBl>=0 && Nb>=3iBl+3tBl+4 && iLoc>=tLoc && iLoc+tLoc>=3 && b>=tLoc && b+tLoc>=2 && 4b>=iLoc+tLoc && 4b+tLoc>=iLoc+1}"
				+ "|| {iBl,tBl,iLoc,tLoc|iBl+tBl==-1 && Tl==0 && Nl==0 && Nb>=2 && Tb>=2 && 0>=iBl+1 && iLoc>=3b+1 && 4b>=iLoc+tLoc && 4b+tLoc>=iLoc+1}"
				+ "|| {iBl,tBl,iLoc,tLoc|3iBl+3tBl==Nb-1 && Tl==0 && Nl==0 && Nb>=2 && Tb>=2 && b>=2 && Nb>=6iBl+4 && b>=iLoc-1 && iLoc>=tLoc && iLoc+tLoc>=3 && b>=tLoc}"
				+ "|| {iBl,tBl,iLoc,tLoc|tBl==iBl && Tl==0 && Nl==0 && Tb>=2 && b>=2 && iBl>=0 && Nb>=6iBl+4 && tLoc>=1 && iLoc>=tLoc && iLoc+tLoc>=3 && b>=tLoc && 4b>=iLoc+tLoc}"
				+ "|| {iBl,tBl,iLoc,tLoc|3iBl+3tBl==Nb-2 && Tl==0 && Nl==0 && Nb>=2 && Tb>=2 && b>=2 && Nb>=6iBl+5 && 2b>=iLoc-1 && iLoc>=tLoc && iLoc+tLoc>=3 && b>=tLoc && b+tLoc>=2}"
				+ "|| {iBl,tBl,iLoc,tLoc|3iBl+3tBl==Nb-3 && Tl==0 && Nl==0 && Nb>=3 && Tb>=2 && b>=2 && Nb>=6iBl+6 && 3b>=iLoc-1 && iLoc>=tLoc && iLoc+tLoc>=3 && b>=tLoc && b+tLoc>=2 && 4b>=iLoc+tLoc}"
				+ "|| {iBl,tBl,iLoc,tLoc|6tBl==Nb-1 && 6iBl==Nb-1 && Tl==0 && Nl==0 && Nb>=2 && Tb>=2 && b>=2 && b>=iLoc-1 && tLoc>=1 && iLoc>=tLoc && iLoc+tLoc>=3 && b>=tLoc}"
				+ "|| {iBl,tBl,iLoc,tLoc|6tBl==Nb-2 && 6iBl==Nb-2 && Tl==0 && Nl==0 && Nb>=2 && Tb>=2 && b>=2 && 2b>=iLoc-1 && tLoc>=1 && iLoc>=tLoc && iLoc+tLoc>=3 && b>=tLoc}"
				+ "|| {iBl,tBl,iLoc,tLoc|6tBl==Nb-3 && 6iBl==Nb-3 && Tl==0 && Nl==0 && Nb>=3 && Tb>=2 && b>=2 && 3b>=iLoc-1 && tLoc>=1 && iLoc>=tLoc && iLoc+tLoc>=3 && b>=tLoc && 4b>=iLoc+tLoc}");
		
		Domain domDebugMiddleBr1 = debugDom.difference(middleBranch1ExprDom); domDebugMiddleBr1.simplify(); System.out.println(" middle brch1 => " + domDebugMiddleBr1.toString());
		
		
		
		
	}
	
	@Test
	public void testHexagonalJ1DCheckprog() {
		Program program = alphaz.mde.Basic.ReadAlphabets("alphabets/J1DHexagonal.ab");
		//System.out.println(PolyhedralIRToAlphabets.toString(program));
		//System.out.println(PrintAST.print(program));
		System.out.println(UniquenessAndCompletenessCheck.validate(program).toString());
	}
	
	
	
} // ParametricTilingTest
