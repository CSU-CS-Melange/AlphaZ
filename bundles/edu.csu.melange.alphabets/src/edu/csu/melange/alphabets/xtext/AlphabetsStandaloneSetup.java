
package edu.csu.melange.alphabets.xtext;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class AlphabetsStandaloneSetup extends AlphabetsStandaloneSetupGenerated{

	public static void doSetup() {
		new AlphabetsStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

