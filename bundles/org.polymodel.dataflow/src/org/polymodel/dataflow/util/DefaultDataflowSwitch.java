
package org.polymodel.dataflow.util;

import org.polymodel.dataflow.ADAInput;
import org.polymodel.dataflow.ADASolution;
import org.polymodel.dataflow.ADAStatement;
import org.polymodel.dataflow.Access;
import org.polymodel.dataflow.ReadAccess;
import org.polymodel.dataflow.ResolvedAccess;
import org.polymodel.dataflow.WriteAccess;



public class DefaultDataflowSwitch extends DataflowSwitch<Boolean> {
	
	
	@Override
	public Boolean caseADAInput(ADAInput input) {
		boolean res = true;
		for (ADAStatement s : input.getAdaStatements()) {
			res = doSwitch(s);
			if (!res) break;
		}
		return res;
	}
	
	@Override
	public Boolean caseADAStatement(ADAStatement stmt) {
		boolean res = true;
		for (ReadAccess a : stmt.getReads()) {
			res = doSwitch(a);
			if (!res) break;
		}
		if (res)
			for (WriteAccess a : stmt.getWrites()) {
				res = doSwitch(a);
				if (!res) break;
			}
		return res;
	}

	@Override
	public Boolean caseReadAccess(ReadAccess access) {
		boolean res = true;
		if (access.getLastWrite() != null)
			res = doSwitch(access.getLastWrite());
		return res;
	}
	
	@Override
	public Boolean caseADASolution(ADASolution solution) {
		boolean res = true;
		for (ResolvedAccess ra : solution.getResolvedAccesses()) {
			res = doSwitch(ra);
			if (!res) break;
		}
		return res;
	}
	
	@Override
	public Boolean caseResolvedAccess(ResolvedAccess access) {
		return true;
	}
	
	@Override
	public Boolean caseWriteAccess(WriteAccess access) {
		return true;
	}

	@Override
	public Boolean caseAccess(Access access) {
		throw new UnsupportedOperationException("Unsupported implementation of Access : "+access.getClass().getSimpleName());
	}
	

}