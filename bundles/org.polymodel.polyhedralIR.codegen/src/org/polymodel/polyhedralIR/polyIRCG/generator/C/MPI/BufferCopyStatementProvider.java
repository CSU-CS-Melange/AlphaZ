package org.polymodel.polyhedralIR.polyIRCG.generator.C.MPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.algebra.util.VariableCollector;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.polyIRCG.MemoryAccessExpression;
import org.polymodel.polyhedralIR.polyIRCG.MemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.MergedMemoryDomain;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed;
import org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForTiling;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.scop.cgenerator2.MacroBodyProvider;

/**
 * Custom MacroBodyProvider for copying values to/from buffers in MPIC.
 * accessFuncion is from iteration space to memory space mapping
 * access is from memory space to physical memory location.
 * 
 * @author yuki
 *
 */
public class BufferCopyStatementProvider implements MacroBodyProvider {

	final protected List<Integer> orderingDims;
	final protected AffineFunction writeAccessFunction;
	final protected AffineFunction readAccessFunction;
	final protected MemoryAccessExpression writeAccess;
	final protected MemoryAccessExpression readAccess;
	final protected String bufferIDreplacement;
	
	public static boolean DEBUG = false;
	
	public BufferCopyStatementProvider(List<Integer> orderingDims, AffineFunction writeAccessFunction, MemoryAccessExpression writeAccess, AffineFunction readAccessFunction, MemoryAccessExpression readAccess, String bufferIDreplacement) {
		this.orderingDims = orderingDims;
		this.writeAccessFunction = writeAccessFunction;
		this.readAccessFunction = readAccessFunction;
		this.writeAccess = writeAccess;
		this.readAccess = readAccess;
		this.bufferIDreplacement = bufferIDreplacement;
	}

	/**
	 * This processing step substitutes variables created while constructing Scop from Clast to corresponding variable
	 * used in the PolyIRCG model. This is necessary to get simplification to work.
	 * 
	 * @param macroParameters
	 * @param replacementTargets
	 * @return
	 */
	private List<IntExpression> processMacroParameters(List<IntExpression> macroParameters, List<Variable> ... replacementTargetsList) {
		
		List<IntExpression> processed = new ArrayList<IntExpression>();
		
		for (IntExpression expr : macroParameters) {
			Set<Variable> vars = VariableCollector.collect(expr);

			for (List<Variable> replacementTargets : replacementTargetsList) {
				for (Variable target : replacementTargets) {
					for (Variable v: vars) {
						if (v.getName().contentEquals(target.getName())) {
							expr = expr.substitute(v, target);
						}
					}
				}
			}
			processed.add(expr);
		}
		
		return processed;
	}
	/**
	 * Takes macro parameters and an affine function, and returns new expressions that is the result of applying the function
	 * to the given expressions. Used to take values in iteration space to memory space.
	 * 
	 * @param macroParameters
	 * @param iterationToMemory
	 * @return
	 */
	private List<IntExpression> getMemorySpaceIndices(List<IntExpression> macroParameters, AffineFunction iterationToMemory) {
		List<AffineExpression> accesses = iterationToMemory.getExpressions();
		List<IntExpression> memorySpaceIndices = new ArrayList<IntExpression>();
		for (int d = 0; d < accesses.size(); d++) {
			IntExpression expr = accesses.get(d);
			int count = 0;
			for (int i = 0; i < iterationToMemory.getNIndices(); i++) {
				//skip ordering dimensions
				while (orderingDims.contains(i)) {
					i++;
				}
				if (i >= iterationToMemory.getNIndices()) break;
				expr = expr.substitute(iterationToMemory.getIndices().get(i), macroParameters.get(count));
				count++;
			}
			memorySpaceIndices.add(expr.simplify());
		}
		
		return memorySpaceIndices;
	}
	
	private String getWriteAccessExpression(List<IntExpression> macroParameters) {
		StringBuffer sb = new StringBuffer(writeAccess.getVariable().getName());
		
		List<IntExpression> memorySpaceIndices = getMemorySpaceIndices(macroParameters, writeAccessFunction);
		List<Variable> indices = getAccessExpressionIndices(writeAccess);
		
		assert(memorySpaceIndices.size() == indices.size());
		
		sb.append("(");

		boolean first = true;
		
		for (IntExpression expr : writeAccess.getAccessExpressions()) {
			for (int i = 0; i < Math.min(memorySpaceIndices.size(), indices.size()); i++) {
				expr = expr.substitute(indices.get(i), memorySpaceIndices.get(i));
			}
			if (!first) sb.append(", ");
			sb.append(expr.simplify().toString(OUTPUT_FORMAT.C));
			
			first = false;
		}
		sb.append(")");
		
//		{
//			System.err.println("writeAccessFunction:"+writeAccessFunction);
//			System.err.println("macroParameters:"+macroParameters);
//			System.err.println("memorySpaceIndices:"+memorySpaceIndices);
////			System.err.println("WAindices:"+WAindices);
//			System.err.println("orderingDims:"+orderingDims);
//			System.err.println("WAFindices:"+writeAccessFunction.getIndices());
//			System.err.println("indices:"+indices);
//			System.err.println("WAExprs:"+writeAccess.getAccessExpressions());
//			System.err.println(sb);
//		}		
		
		return sb.toString();
	}
	
	private String getReadAccessExpression(List<IntExpression> macroParameters) {
		StringBuffer sb = new StringBuffer(readAccess.getVariable().getName());

		List<IntExpression> memorySpaceIndices = getMemorySpaceIndices(macroParameters, readAccessFunction);
		
		//indices t o replace with processed macro parameters (memory space indices)
		List<Variable> indices = getAccessExpressionIndices(readAccess);
		
		assert(memorySpaceIndices.size() == indices.size());

		sb.append("(");
		
		boolean first = true;
		for (IntExpression expr : readAccess.getAccessExpressions()) {
			for (int i = 0; i < Math.min(memorySpaceIndices.size(), indices.size()); i++) {
				expr = expr.substitute(indices.get(i), memorySpaceIndices.get(i));
			}
			if (!first) sb.append(", ");
			sb.append(expr.simplify().toString(OUTPUT_FORMAT.C));
			
			first = false;
		}
		sb.append(")");
		
		{
//			System.err.println("readAccessFunction:"+readAccessFunction);
//			System.err.println("macroParameters:"+macroParameters);
//			System.err.println("memorySpaceIndices:"+memorySpaceIndices);
//			System.err.println("orderingDims:"+orderingDims);
//			System.err.println("RAFindices:"+readAccessFunction.getIndices());
//			System.err.println("indices:"+indices);
//			System.err.println("RAExprs:"+readAccess.getAccessExpressions());
//			System.err.println(sb);
		}		
		
		return sb.toString();
	}

	/**
	 * Returns indices to be replaced by processed macro parameters (memorySpaceIndices).
	 * 
	 * @param access
	 * @return
	 */
	private List<Variable> getAccessExpressionIndices(MemoryAccessExpression access) {
		List<Variable> indices;
		MemoryDomain memoryDomain = access.getVariable().getDomain();
		//when the memory domain is MergedMemoryDomain, getIndices returns the first index only, since merged domains are linearlized
		//thus, you need to get the full indices by other means.
		if (memoryDomain instanceof MergedMemoryDomain) {
			indices = ((MergedMemoryDomain) memoryDomain).getMemoryDomains().iterator().next().getValue().getIndices();
		} else {
			indices = memoryDomain.getIndices();
		}
		
		return indices;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getBody(List<IntExpression> macroParameters) {
		List<IntExpression> WAprocessed = processMacroParameters(macroParameters, writeAccess.getVariable().getDomain().getParams(), writeAccessFunction.getIndices());
		List<IntExpression> RAprocessed = processMacroParameters(macroParameters, readAccess.getVariable().getDomain().getParams(), readAccessFunction.getIndices());
		
		StringBuffer debugStr = new StringBuffer();
		SpaceTimeLevel stlevel = writeAccess.getVariable().getCodeunit().getSystem().getTargetMapping().getSpaceTimeLevel(0);
		if (DEBUG) {
			int tileDims = stlevel.getNumberOfTiledDimensions();
			//assumes every variable is flattened
			debugStr.append("printf(\"pid:%d ti(%d");
			for (int i = 1; i < tileDims; i++) {
				debugStr.append(",%d");
			}
			debugStr.append(") ");
			debugStr.append(writeAccess.getVariable().getName()+"(%d");
			for (int i = 1; i < writeAccess.getAccessExpressions().size(); i++) {
				debugStr.append(",%d");
			}
			debugStr.append(")");
			debugStr.append(" = ");
			debugStr.append(readAccess.getVariable().getName()+"(%d");
			for (int i = 1; i < readAccess.getAccessExpressions().size(); i++) {
				debugStr.append(",%d");
			}
			debugStr.append(")");
			debugStr.append(" = "+readAccess.getVariable().getType().getCPrintfSpecifier());
			debugStr.append(" @ (%d");
			for (int i = 1; i < macroParameters.size(); i++) {
				debugStr.append(",%d");
			}
			debugStr.append(")\\n\", pid, ");
			for (int i = 1; i <= tileDims; i++) {
				debugStr.append(CodeGenConstantsForTiling.getTileIndexName(i)+", ");
			}
			debugStr.append(getWriteAccessExpression(WAprocessed).replaceFirst(writeAccess.getVariable().getName()+"\\(", "").replaceFirst("\\)$", ""));
			debugStr.append(",");
			debugStr.append(getReadAccessExpression(RAprocessed).replaceFirst(readAccess.getVariable().getName()+"\\(", "").replaceFirst("\\)$", ""));
			debugStr.append(",");
			debugStr.append(getReadAccessExpression(RAprocessed));
			for (IntExpression mp : macroParameters) {
				debugStr.append("," + mp.toString(OUTPUT_FORMAT.C));
			}
			debugStr.append("); ");
		}
		
		String str = debugStr + getWriteAccessExpression(WAprocessed) + " = " + getReadAccessExpression(RAprocessed);
		//replace bufferID with send/recv buffer 
		return str.replaceAll(CodeGenConstantsForDistributed.bufferID, bufferIDreplacement);
	}
	

}
