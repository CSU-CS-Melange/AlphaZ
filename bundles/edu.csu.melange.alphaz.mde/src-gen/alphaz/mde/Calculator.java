package alphaz.mde;

/*PROTECTED REGION ID(Calculator_imports) ENABLED START*/
//PROTECTED IMPORTS
import java.util.ArrayList;

import org.polymodel.algebra.Variable;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.util.PolymodelException;
/*PROTECTED REGION END*/
/**
Calculator interface for directly manipulating polyhedral objects.
**/
public class Calculator {

	/**
	Reads domain in String and returns a Domain object.
	**/
	public static Domain readDomain(  Domain paramDomain , String domain ) {
		/*PROTECTED REGION ID(alphaz.mde.calculator.readDomain) ENABLED START*/
		PolyhedralIRUtility.createUniverseDomain(new ArrayList<Variable>(0), new ArrayList<Variable>(0));
		return PolyhedralIRUtility.parseDomain(paramDomain.toParameterDomain(), domain);
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static Domain readDomain( String domain) {
		return readDomain( PolyhedralIRUtility.createUniverseDomain(new ArrayList<Variable>(0), new ArrayList<Variable>(0)) , domain);
	}
	


	/**
	Reads affine function in String and returns an AffineFunction object.
	**/
	public static AffineFunction readFunction(  Domain paramDomain , String function ) {
		/*PROTECTED REGION ID(alphaz.mde.calculator.readFunction) ENABLED START*/
		return PolyhedralIRUtility.parseAffineFunction(paramDomain.toParameterDomain(), function);
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static AffineFunction readFunction( String function) {
		return readFunction( PolyhedralIRUtility.createUniverseDomain(new ArrayList<Variable>(0), new ArrayList<Variable>(0)) , function);
	}
	


	/**
	Compute the inverse of the give affine function.
	**/
	public static AffineFunction inverse(  AffineFunction function ) {
		/*PROTECTED REGION ID(alphaz.mde.calculator.inverse) ENABLED START*/
		try {
			return function.inverse();
		} catch (PolymodelException e) {
			throw new RuntimeException("No inverse found.");
		}
		/*PROTECTED REGION END*/
	}


	/**
	Computes inverse of the given affine function, in the context of the given domain.
	**/
	public static AffineFunction inverseInContext(  Domain domain , AffineFunction function ) {
		/*PROTECTED REGION ID(alphaz.mde.calculator.inverseInContext) ENABLED START*/
		try {
			return function.inverseInContext(domain, null);
		} catch (PolymodelException e) {
			throw new RuntimeException("No inverse found.");
		}
		/*PROTECTED REGION END*/
	}


	/**
	Returns a function, that computes function2@function1.
	**/
	public static AffineFunction compose(  AffineFunction function1 , AffineFunction function2 ) {
		/*PROTECTED REGION ID(alphaz.mde.calculator.compose) ENABLED START*/
		return function1.compose(function2);
		/*PROTECTED REGION END*/
	}


	/**
	Returns the intersection of two domains given.
	**/
	public static Domain intersection(  Domain domain1 , Domain domain2 ) {
		/*PROTECTED REGION ID(alphaz.mde.calculator.intersection) ENABLED START*/
		return domain1.intersection(domain2);
		/*PROTECTED REGION END*/
	}


	/**
	Returns the union of two domains given.
	**/
	public static Domain union(  Domain domain1 , Domain domain2 ) {
		/*PROTECTED REGION ID(alphaz.mde.calculator.union) ENABLED START*/
		return domain1.union(domain2);
		/*PROTECTED REGION END*/
	}


	/**
	Returns a function that computes function1@function2.
	**/
	public static AffineFunction join(  AffineFunction function1 , AffineFunction function2 ) {
		/*PROTECTED REGION ID(alphaz.mde.calculator.join) ENABLED START*/
		return function2.compose(function1);
		/*PROTECTED REGION END*/
	}


	/**
	Returns true if the domain is empty.
	**/
	public static Boolean isEmpty(  Domain domain ) {
		/*PROTECTED REGION ID(alphaz.mde.calculator.isEmpty) ENABLED START*/
		return domain.isEmpty();
		/*PROTECTED REGION END*/
	}


	/**
	Returns true if the two domains/functions given are equivalent.
	**/
	public static Boolean isEquivalent(  Domain domainA , Domain domainB ) {
		/*PROTECTED REGION ID(alphaz.mde.calculator.isEquivalent) ENABLED START*/
		return domainA.equivalence(domainB);
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static Boolean isEquivalent( AffineFunction funcA, AffineFunction funcB) {
		/*PROTECTED REGION ID(alphaz.mde.calculator.isEquivalent_0) ENABLED START*/
		return funcA.equivalence(funcB);
		/*PROTECTED REGION END*/
	}


	/**
	Compute the image of the given domain by the given function.
	**/
	public static Domain image(  AffineFunction function , Domain domain ) {
		/*PROTECTED REGION ID(alphaz.mde.calculator.image) ENABLED START*/
		return domain.image(function);
		/*PROTECTED REGION END*/
	}


	/**
	Compute the pre-image of the given domain by the given function.
	**/
	public static Domain preImage(  AffineFunction function , Domain domain ) {
		/*PROTECTED REGION ID(alphaz.mde.calculator.preImage) ENABLED START*/
		return domain.preimage(function);
		/*PROTECTED REGION END*/
	}


	/**
	Returns domainA / domainB.
	**/
	public static Domain difference(  Domain domainA , Domain domainB ) {
		/*PROTECTED REGION ID(alphaz.mde.calculator.difference) ENABLED START*/
		return domainA.difference(domainB);
		/*PROTECTED REGION END*/
	}


	/**
	Takes domain and context domain, and returns the domain with constraints that are redundant with the context removed.
	**/
	public static Domain simplifyInContext(  Domain domain , Domain context ) {
		/*PROTECTED REGION ID(alphaz.mde.calculator.simplifyInContext) ENABLED START*/
		Domain simplified = domain.copy();
		simplified.simplifyInContext(context);
		return simplified;
		/*PROTECTED REGION END*/
	}

}//end Calculator
