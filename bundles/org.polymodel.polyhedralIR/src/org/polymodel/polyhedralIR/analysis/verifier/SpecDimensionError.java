package org.polymodel.polyhedralIR.analysis.verifier;

import org.eclipse.emf.common.util.EList;
import org.polymodel.polyhedralIR.targetMapping.StandardEquationSpaceTimeMap;


/**
 * This part only handles the space time map for standard equation now
 * TODO: This has to be modified to handle use equation
 * @author zou
 *
 */
public class SpecDimensionError extends VerifierSpecError {
	protected EList<StandardEquationSpaceTimeMap> mapping;

	public SpecDimensionError(TYPE type, EList<StandardEquationSpaceTimeMap> mapping) {
		super(type);
		this.mapping = mapping;
	}

	@Override
	public String toString(VERBOSITY verbosity) {
		StringBuffer output = new StringBuffer();
		output.append(" voilates the condition that dimensions of space time mapping should be common for all variables\n");
		
		if(verbosity == VERBOSITY.MAX) {
			for(int i = 0; i < mapping.size(); ++i) {
				StandardEquationSpaceTimeMap stmap = mapping.get(i);
				output.append(stmap.getVariable().getName() + "  " + stmap.getMapping().toString());
				output.append("\n");
			}
		}
		return output.toString();
	}

}
