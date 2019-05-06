package org.polymodel.polyhedralIR.polyIRCG.generator.C.MPI;

import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.ExpressionPrinterForScheduledC;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;

public class ExpressionPrinterForMPIC extends ExpressionPrinterForScheduledC {

	protected ExpressionPrinterForMPIC(TargetMapping tm, boolean mainFunction) {
		super(tm, mainFunction);
	}
	

	public static String print(Expression expr, Boolean mainFunction) {
		AffineSystem syst;
		if (expr.getContainerEquation() instanceof StandardEquation)
			syst = ((StandardEquation)expr.getContainerEquation()).getContainerSystem();
		else
			syst = ((UseEquation)expr.getContainerEquation()).getContainerSystem();
		
		return new ExpressionPrinterForMPIC(syst.getTargetMapping(), mainFunction).start(expr);
	}
	
	/**
	 * Shifts the access to memory by -ti
	 */
	@Override
	protected AffineFunction computeAccessFunction(int level, VariableDeclaration var) {

		if (var.isLocal()) {
			return MPICUtility.getAccessFunctionForDistributedVariable(targetMapping, var);
		} else {
			return super.computeAccessFunction(level, var);
		}
	}


}
