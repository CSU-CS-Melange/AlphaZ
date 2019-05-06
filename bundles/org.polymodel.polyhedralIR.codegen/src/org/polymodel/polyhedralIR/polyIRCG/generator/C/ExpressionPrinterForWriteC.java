package org.polymodel.polyhedralIR.polyIRCG.generator.C;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.factory.TargetMappingUserFactory;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenUtility;
import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;

/**
 * Pretty Printer for expressions of PolyhedralIR targeting C. This is taken
 * from the old StatementVisitor mainly for WriteC
 * 
 * @author yuki
 * 
 */
public class ExpressionPrinterForWriteC extends ExpressionPrinterForC {
	
	protected ExpressionPrinterForWriteC(TargetMapping tm) {
		super(tm, false);
	}

	public static String print(Expression expr) {
		AffineSystem syst;
		if (expr.getContainerEquation() instanceof StandardEquation)
			syst = ((StandardEquation) expr.getContainerEquation()).getContainerSystem();
		else
			syst = ((UseEquation) expr.getContainerEquation()).getContainerSystem();
		
		return new ExpressionPrinterForWriteC(syst.getTargetMapping()).start(expr);
	}
	
	@Override
	public String caseVariableExpression(VariableExpression node) {
		//Get the memory mapping and ST
		MemoryMap mmap = targetMapping.getMemoryMaps().get(node.getVarDecl());
		if (mmap == null) {
			throw new RuntimeException("MemoryMap is not specified for variable : " + node.getVarDecl().getName());
		}
		MemorySpace ms = mmap.getSpace();
		if (ms == null) {
			throw new RuntimeException("MemorySpace is not specified for variable : " + node.getVarDecl().getName());
		}
		
		
		//If its an input variable, then use the regular access to memory
		AffineSystem syst;
		if (node.getContainerEquation() instanceof StandardEquation)
			syst = ((StandardEquation) node.getContainerEquation()).getContainerSystem();
		else
			syst = ((UseEquation) node.getContainerEquation()).getContainerSystem();
		
		if (syst.isInput(node.getVarDecl())) {
			//scalars are not dereferenced, since they are always global
			if (ms.getDomain().getNIndices() == 0) {
				return ms.getName();
			}
			return super.caseVariableExpression(node);
		}
		
		//Else append print list of parameters and indices
		List<String> names = node.getContextDomain().getParamNames();
		
		
		//reuses the base printer and replaces the reference to variable with evaluation
		final String original;
		final String replace;
		if (ms.getDomain().getNIndices() == 0) {
			//scalars are dereferenced in the original 
			original = "\\*"+ms.getName();
			replace = String.format("%s%s\\(%s)", CodeGenConstantsForC.WRITEC_EVAL_PREFIX, ms.getName(), CodeGenUtility.toStringList(names, ","));
		} else {
			//Add prefix to make it evaluation function
			original = ms.getName()+"\\(";
			//variables have other indices following
			replace = String.format("%s%s\\(%s,", CodeGenConstantsForC.WRITEC_EVAL_PREFIX, ms.getName(), CodeGenUtility.toStringList(names, ","));
		}
		
		
		//Use the same pretty printing, but with memory mapping ignored
		EList<IntExpression> mods = new BasicEList<IntExpression>();
		for (int i = 0; i < node.getContextDomain().getNIndices(); i++) {
			mods.add(IntExpressionBuilder.constant(0));
		}
		//use a dummy mapping with identity
		MemoryMap dummy = TargetMappingUserFactory.createMemoryMap(node.getVarDecl(), PolyhedralIRUtility.createIdentityFunction(node.getContextDomain()), mods, ms);
		targetMapping.getMemoryMaps().put(node.getVarDecl(),  dummy);
		
		String forC = super.caseVariableExpression(node);
		
		//restore the original memory map
		targetMapping.getMemoryMaps().put(node.getVarDecl(), mmap);
		
		return forC.replaceFirst(original, replace);
	}
	
	@Override
	public String caseReduceExpression(ReduceExpression node) {
		if (node.getContainerEquation() instanceof UseEquation)
			throw new RuntimeException("TODO: implement this method for UseEquation");
		
		StringBuffer sbody = new StringBuffer();
		String name = CodeGenConstantsForC.getReductionFunctionName((StandardEquation) node.getContainerEquation(), reductionNumbers.getReductionNumber(node));
		sbody.append(name);
		
		//Call evaluation function of the reduce
		//function parameters are program parameters + indices of the result space
		sbody.append("(");
		List<String> fparams = new LinkedList<String>(); 
		//Get program parameters from the domain
		for (Variable iv : node.getContextDomain().getParams()) {
			fparams.add(iv.toString());
		}
		
		//pretty print the dependence function to pass the indices	
		for (AffineExpression ile : _currentDep.getExpressions()) {
			fparams.add(ile.toString());
		}
		sbody.append(CodeGenUtility.toStringList(fparams, ","));
		sbody.append(")");

		return sbody.toString();
	}
	
}
