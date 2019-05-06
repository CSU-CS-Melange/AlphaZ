package org.polymodel.dataflow.util;

import org.polymodel.dataflow.ADAInput;
import org.polymodel.dataflow.ReadAccess;

public class DataflowAnalysisCheck extends DefaultDataflowSwitch {
	
	public static boolean check(ADAInput input) {
		return new DataflowAnalysisCheck().doSwitch(input);
	}
	
	@Override
	public Boolean caseReadAccess(ReadAccess access) {
		return (access.getLastWrite() != null);
	}
}
