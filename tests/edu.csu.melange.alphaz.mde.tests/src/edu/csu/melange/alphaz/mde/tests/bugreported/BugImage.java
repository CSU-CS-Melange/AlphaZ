package edu.csu.melange.alphaz.mde.tests.bugreported;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.junit.Assert;
import org.junit.Test;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;

public class BugImage {
	
	
	@Test
	public void testBug() {
		ParameterDomain paramDom = PolyhedralIRUtility
				.parseParameterDomain("{Tb,Nb,Tl,Nl,b| Nb>=1 && Tb>=1}");
		
		List<String> lParam = paramDom.getParamNames();
		Domain dom = PolyhedralIRUtility.parseDomain(lParam, 
				"{t,i | t==Tb && i==Nb && Nb>=1 && Tb>=1}");
		
		List<String> lInd = new BasicEList<String>();
		lInd.add("t");
		lInd.add("i");
		List<String> lExpr = new BasicEList<String>();
		lExpr.add("Tl");
		lExpr.add("Nl");
		lExpr.add("b");
		AffineFunction affFunc = PolyhedralIRUtility.parseAffineFunction(paramDom, lInd, lExpr);
		
		System.out.println(dom.toString());
		System.out.println(affFunc.toString());
		
		// BUG HERE, but only on department machine... :/
		// Works fine on my machine (don't know why)
			// This works on department machines. At least on my machine (Waruna)
		Domain domIm = dom.image(affFunc);
		
		System.out.println(domIm.toString());
		
		Domain expected = PolyhedralIRUtility.parseDomain(lParam, 
				"{t,i,j|j==b && i==Nl && t==Tl && Nb>=1 && Tb>=1}");
		
		Assert.assertTrue("There is an issue with the calculation of the image" 
						  + " of a domain over a given function!", 
						  domIm.equivalence(expected));
	}
	
	@Test
	public void test2() {
		ParameterDomain paramDom = PolyhedralIRUtility
				.parseParameterDomain("{TSTEPSb,Nb,TSTEPSl,Nl,b| }");
		System.out.println(paramDom.toString());
		List<String> lParam = paramDom.getParamNames();
		Domain dom = PolyhedralIRUtility.parseDomain(lParam, 
				"{tBl,iBl,tLoc,iLoc|tLoc==0 && 2iBl==Nb-1 && tBl==0 && Nl==0 "
				+ "&& TSTEPSl==0 && Nb>=3 && b>=6 && b>=iLoc+1 && TSTEPSb>=1 "
				+ "&& iLoc>=0 && 2b>=iLoc+1}");
		System.out.println(dom.toString());
		
		List<String> lInd = new BasicEList<String>();
		lInd.add("tBl");
		lInd.add("iBl");
		lInd.add("tLoc");
		lInd.add("iLoc");
		List<String> lExpr = new BasicEList<String>();
		lExpr.add("-tBl+2iBl");
		lExpr.add("-tLoc+iLoc");
		AffineFunction affFunc = PolyhedralIRUtility.parseAffineFunction(paramDom, lInd, lExpr);
		
		System.out.println(dom.toString());
		System.out.println(affFunc.toString());
		
		// Existential remains (because of parameters => normal...) => WORKS !!!
		// TODO: check how existential variables are managed... :/
		Domain domIm = dom.image(affFunc);
		
		
		System.out.println(domIm.toString());
		
		Domain expected = PolyhedralIRUtility.parseDomain(lParam, 
				"{tBl,iBl|tBl==Nb-1 && Nl==0 && TSTEPSl==0 && "
				+ "Nb>=3 && b>=6 && b>=iBl+1 && TSTEPSb>=1 && "
				+ "iBl>=0 && 2b>=iBl+1}");
		
		System.out.println(expected.toString());
		Assert.assertTrue("There is an issue with the calculation of the image of" 
						   + " a domain over a given function!\n got: " + 
						   domIm.toString() + "\n expected: " + expected.toString() + 
						   "\n Comment from Guillaume: Existential remains (because of" 
						   +" parameters => normal...) => WORKS !!!\n" 
						   + "TODO: check how existential variables are managed... :/", 
						   domIm.equivalence(expected));
	}
	
	@Test
	public void test3() {
		ParameterDomain paramDom = PolyhedralIRUtility
				.parseParameterDomain("{TSTEPSb,Nb,TSTEPSl,Nl,b| }");
		
		List<String> lParam = paramDom.getParamNames();
		Domain dom = PolyhedralIRUtility.parseDomain(lParam,
				"{tBl,iBl,tLoc,iLoc|tLoc==b-1 && 2iBl==Nb+tBl && Nl==0 "
				+ "&& TSTEPSl==0 && Nb>=1 && b>=6 && tBl>=1 && TSTEPSb>=tBl+1 "
				+ "&& iLoc>=0 && b>=iLoc+2}");
		
		List<String> lInd = new BasicEList<String>();
		lInd.add("tBl");
		lInd.add("iBl");
		lInd.add("tLoc");
		lInd.add("iLoc");
		List<String> lExpr = new BasicEList<String>();
		AffineFunction affFunc = PolyhedralIRUtility
				.parseAffineFunction(paramDom, lInd, lExpr);
		
		System.out.println(dom.toString());
		System.out.println(affFunc.toString());
		
		// TODO: Problem here... :/
		// TODO: reason: if TSTEPSb=0 (=> tBl=1), existence depends on the parity of Nb... :/
		Domain domIm = null;
		try {
			domIm = dom.image(affFunc);
			System.out.println(domIm.toString());
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
			Assert.fail("Exception is thrown while computing image of " 
					+ dom.toString() + " over function: " + affFunc.toString() 
					+ "\n Error message: " + e.getMessage() + "\n stack trace" 
					+ e.toString() + "\nComment from Guillaume: TODO: reason: "
					+ "if TSTEPSb=0 (=> tBl=1), existence depends on the "
					+ "parity of Nb... :/");
		}
		 
		// TODO add the expected domain result
		/*Domain expected = PolyhedralIRUtility.parseDomain(lParam, 
				"expected domain here");
		
		System.out.println(expected.toString());
		Assert.assertTrue("There is an issue with the calculation of the image of" 
						   + " a domain over a given function!\n got: " + 
						   domIm==null?"":domIm.toString() + "\n expected: " 
						   + expected.toString(), 
						   domIm==null?false:domIm.equivalence(expected));
		*/
	}
	
	@Test
	public void test4() {
		ParameterDomain paramDom = PolyhedralIRUtility
				.parseParameterDomain("{TSTEPSb,Nb,Mb,TSTEPSl,Nl,Ml,b| }");
		
		List<String> lParam = paramDom.getParamNames();
		Domain dom = PolyhedralIRUtility.parseDomain(lParam,
				"{tBl,iBl,jBl,tLoc,iLoc,jLoc|jBl==2tBl+1 && 2iBl==Nb+2tBl-1"
				+ "&& Ml==0 && Nl==0 && TSTEPSl==0 && Mb==2 && Nb>=3 && TSTEPSb>=2"
				+ "&& b>=6 && tBl>=1 && TSTEPSb>=2tBl+2 && tLoc>=0 && iLoc>=0 && b+tLoc>=iLoc+1"
				+ "&& 2b>=iLoc+1 && jLoc>=0 && b+jLoc>=tLoc && b>=jLoc+1 && Ml==0 && Nl==0"
				+ "&& TSTEPSl==0 && TSTEPSb>=2 && Nb>=2 && Mb>=2 && b>=6}");
		
		List<String> lInd = new BasicEList<String>();
		lInd.add("tBl");
		lInd.add("iBl");
		lInd.add("jBl");
		lInd.add("tLoc");
		lInd.add("iLoc");
		lInd.add("jLoc");
		List<String> lExpr = new BasicEList<String>();
		lExpr.add("tLoc");
		lExpr.add("iLoc");
		lExpr.add("jLoc");
		AffineFunction affFunc = PolyhedralIRUtility
				.parseAffineFunction(paramDom, lInd, lExpr);
		
		System.out.println(dom.toString());
		System.out.println(affFunc.toString());
		
		// TODO: Problem here... :/
		// TODO: reason: if TSTEPSb=0 (=> tBl=1), existence depends on the parity of Nb... :/
		Domain domIm = null;
		try {
			domIm = dom.image(affFunc);
			System.out.println(domIm.toString());
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
			Assert.fail("Exception is thrown while computing image of " 
					+ dom.toString() + " over function: " + affFunc.toString() 
					+ "\n Error message: " + e.getMessage() + "\n stack trace" 
					+ e.toString());
		}
		 
		// TODO add the expected domain result
		/*Domain expected = PolyhedralIRUtility.parseDomain(lParam, 
				"expected domain here");
		
		System.out.println(expected.toString());
		Assert.assertTrue("There is an issue with the calculation of the image of" 
						   + " a domain over a given function!\n got: " + 
						   domIm==null?"":domIm.toString() + "\n expected: " 
						   + expected.toString(), 
						   domIm==null?false:domIm.equivalence(expected));
		*/
	}
	
	
	
	
	
}

