package org.polymodel.polyhedralIR.polyIRCG.generator.C.scan;

import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.expression.CaseExpression;
import org.polymodel.polyhedralIR.impl.PolyhedralIRInheritedDepthFirstVisitorImpl;
import org.polymodel.polyhedralIR.polyIRCG.CodeGenVariable;
import org.polymodel.polyhedralIR.polyIRCG.CodeUnit;
import org.polymodel.polyhedralIR.polyIRCG.Function;
import org.polymodel.polyhedralIR.polyIRCG.Statement;
import org.polymodel.polyhedralIR.polyIRCG.C.CLoop;
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenUtility;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;

public class StatementVisitorForScanC extends PolyhedralIRInheritedDepthFirstVisitorImpl{
	protected static final PolyIRCGUserFactory _fact = PolyIRCGUserFactory.INSTANCE;

	//Input
	protected final CodeUnit unit;
	protected AffineSystem system;
	protected Function function;
	protected CLoop mainLoop;
	
	public static void construct(AffineSystem system, Function function, CodeUnit unit, CLoop loop) {
		StatementVisitorForScanC visitor = new StatementVisitorForScanC(system, function, unit, loop);
		system.accept(visitor);
	}
	
	protected StatementVisitorForScanC(AffineSystem system ,  Function function, CodeUnit unit, CLoop loop) {
		this.unit = unit;
		this.function = function;
		this.system = system;
		this.mainLoop = loop;
	}
	
	@Override
	public void inStandardEquation(StandardEquation s) {

		TargetMapping tm = system.getTargetMapping();
		MemorySpace space = tm.getMemoryMaps().get(system.getVariableDeclaration(s.getVariable().getName())).getSpace();
		
		System.out.println(mainLoop.getFunction().getCodeunit());
		System.out.println(tm);
		System.out.println(tm.getMemorySpaces());
		System.out.println(s.getVariable().getName());
		//system.getTargetMapping().get
		System.out.println(space);
		//Find CodeGenVariable for this equation
		CodeGenVariable var = mainLoop.getFunction().getCodeunit().findCGVariable(space.getName());
		AffineFunction access = tm.getSpaceTimeLevel(0).getAccessFunction(system.getVariableDeclaration(s.getVariable().getName()));
		
		//When case is used
		if (s.getExpression() instanceof CaseExpression) {
			CaseExpression caseExpr = (CaseExpression)s.getExpression();
			//Execute different branches as different statements
			for (Expression expr : caseExpr.getExprs()) {
				Statement stmt = _fact.createStatement(
						((StandardEquation) expr.getContainerEquation()).getVariable(),
						CodeGenUtility.createStatementName(unit, mainLoop.getStatements().size()), 
						expr.getContextDomain().copy(), var, access, expr);
				mainLoop.getStatements().add(stmt);
			}
		} else {
			Statement stmt = _fact.createStatement(
					s.getVariable(),
					CodeGenUtility.createStatementName(unit, mainLoop.getStatements().size()), s.getExpression().getContextDomain().copy(), var, access, s.getExpression());
			mainLoop.getStatements().add(stmt);
		}
	}
	
	@Override
	public void inUseEquation(UseEquation u) {
		// TODO
		throw new UnsupportedOperationException("TODO: implement this method for subsystems");
	}
	
}
