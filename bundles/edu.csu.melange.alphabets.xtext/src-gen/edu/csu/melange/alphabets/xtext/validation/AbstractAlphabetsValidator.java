/*
 * generated by Xtext
 */
package edu.csu.melange.alphabets.xtext.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;

public class AbstractAlphabetsValidator extends org.eclipse.xtext.validation.AbstractDeclarativeValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(edu.csu.melange.alphabets.xtext.alphabets.AlphabetsPackage.eINSTANCE);
		return result;
	}
}