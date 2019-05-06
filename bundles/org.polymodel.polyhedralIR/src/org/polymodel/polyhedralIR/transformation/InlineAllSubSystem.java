package org.polymodel.polyhedralIR.transformation;

import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.UseEquation;

public class InlineAllSubSystem {
	
	// TODO: check that we do not have an infinite inlining ?
	// (until then, do not expose that to the user)
	
	/**
	 * Method that inline all the use equation inside a program
	 * @param ueq
	 */
	public static void inlineAll(Program prog) {
		for (AffineSystem afsyst : prog.getSystems()) {			// The number of systems do not change
			while (!afsyst.getUseEquations().isEmpty()) {		// This set might increase while inlining
				UseEquation ueq = afsyst.getUseEquations().get(0);
				InlineSubSystem.inline(ueq);
			}
		}
	}
	
}
