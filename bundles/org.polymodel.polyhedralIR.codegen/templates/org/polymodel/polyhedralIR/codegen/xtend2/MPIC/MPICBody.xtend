package org.polymodel.polyhedralIR.codegen.xtend2.MPIC

import com.google.inject.Inject
import org.polymodel.polyhedralIR.codegen.xtend2.BaseBody
import org.polymodel.polyhedralIR.codegen.xtend2.BaseDomain
import org.polymodel.polyhedralIR.codegen.xtend2.BaseMemoryAllocation
import org.polymodel.polyhedralIR.codegen.xtend2.BaseStatement
import org.polymodel.polyhedralIR.polyIRCG.C.distributed.MPICLoop
import org.polymodel.scop.cgenerator2.template.Xtend2_CGenerator
import org.polymodel.polyhedralIR.polyIRCG.C.TiledCLoop
import org.polymodel.scop.ScopRoot
import org.polymodel.scop.ScopGuard
import org.polymodel.scop.ScopBlock
import org.polymodel.scop.AbstractScopNode
import org.polymodel.scop.ScopFor
import static extension org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed.*
import static extension org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForTiling.*
import static extension org.polymodel.polyhedralIR.codegen.xtend2.Utility.*
import static extension org.polymodel.polyhedralIR.codegen.xtend2.Indexed.*
import org.polymodel.scop.cgenerator2.CGenerator
import org.polymodel.polyhedralIR.polyIRCG.generator.modules.CGeneratorForMPIC
import org.polymodel.polyhedralIR.codegen.xtend2.BaseFunction
import org.polymodel.scop.dtiler.basic.DTilerTileLoops
import org.polymodel.scop.dtiler.basic.DTilerPointLoops
import org.polymodel.scop.dtiler.DTilingOptions
import org.polymodel.polyhedralIR.polyIRCG.C.DTiledBlock
import org.polymodel.polyhedralIR.polyIRCG.C.DTiledLoop
import org.polymodel.polyhedralIR.polyIRCG.factory.PolyIRCGUserFactory
import org.polymodel.scop.cgenerator2.FixedStringMacro
import org.polymodel.scop.cgenerator2.MacroBodyProvider
import java.util.Map
import java.util.HashMap


class MPICBody extends BaseBody {
	
	@Inject extension BaseStatement stmtExtensions
	@Inject extension BaseDomain domainExtensions
	
	
	def dispatch code(MPICLoop body) '''
		«body.statements.join("\n", [s|s.statementDefine])»
		{
		
			int «sendBuffer», «recvBuffer»;
			MPI_Request «requests»[2];
			«requests»[0] = NULL;
			«requests»[1] = NULL;
			«sendBuffer» = 0;
			«recvBuffer» = 1;
			//Domain
			«FOR stmt : body.statements»
				//«stmt.domain»
			«ENDFOR»

			«body.generateLoopNest»
		}
		«body.statements.join("\n", [s|s.statementUndefine])»
	'''
	
	def generateLoopNest(MPICLoop l) '''
		«val tiled = l.generateDTiledLoop»
		«IF l.declareIterators && l.iteratorNames.size > 0»
			int «l.iteratorNames.join(",", [n|n])»;
		«ENDIF»
		«tiled.scop.generate(tiled)»
	'''
	
	
	
	def generate(DTiledLoop tiled) '''
		«tiled.scop.generate(tiled)»
	'''
	
	
	/**
	 * Branch code generation to customized code gen once its in the tiled block.
	 * ScopBlock and ScopGuard that separates tilable blocks are generated like the normal generation.
	 * Although the rule is re-defined here. 
	 */
	def branchGenerator(AbstractScopNode node, DTiledLoop tiled) {
		val block = tiled.tiledBlocks.filter([e|e.blockStart == node]);
		if (block.size > 0) {
			node.customGenerate(block.head);
		} else {
			node.generate(tiled);
		}
	}
	
	def generate(AbstractScopNode node, CharSequence recvStartBody, CharSequence recvEndBody, CharSequence sendBody) {
		var module = new CGeneratorForMPIC();
		var stmtBody = new HashMap<String, MacroBodyProvider>()
		stmtBody.put(recvStartFunctionName, new FixedStringMacro(recvStartBody.toString));
		stmtBody.put(recvEndFunctionName, new FixedStringMacro(recvEndBody.toString));
		stmtBody.put(sendFunctionName, new FixedStringMacro(sendBody.toString));
		CGenerator::generate(module, node, stmtBody);
	}
	
	def generate(ScopRoot sr, DTiledLoop tiled) '''
		«FOR node : sr.statements»
			«node.branchGenerator(tiled)»
		«ENDFOR»
	'''
	
	def dispatch generate(ScopGuard s, DTiledLoop tiled) '''
		«IF s.constraintSystems.size>0»
			if («s.constraintSystems.join(" || ", [cs|cs.simplify.toCString])») {
				«s.thenBody.branchGenerator(tiled)»
			}«IF s.elseBody != null» else {
				«s.elseBody.branchGenerator(tiled)»
			}«ENDIF»
		«ELSE»
			«s.thenBody.branchGenerator(tiled)»
		«ENDIF»
		
	'''
	def dispatch generate(ScopBlock sg, DTiledLoop tiled) '''
		{
			«FOR node : sg.statements»
				«node.branchGenerator(tiled)»
			«ENDFOR»
		}
	'''
	
	def customGenerate(AbstractScopNode n, DTiledBlock tb) '''
		{
			«tb.tileLoopStart.generate(tb.receiveStart, tb.receiveEnd, tb.sendBody)»
		}
	'''
	
	
//	//assumes the given loop is perfectnest
//	def dispatch generateNumberOfTilesComputation(ScopFor sf) '''
//		int «numTilesPrefix»«sf.loopDepth» = ceild(«sf.UB.toCString» - «sf.LB.toCString», «getTileSizeName(sf.loopDepth)»);
//		«IF sf.body != null»«sf.body.generateNumberOfTilesComputation»«ENDIF»
//	'''
//	
//	def dispatch generateNumberOfTilesComputation(ScopBlock sb) {
//		sb.statements.head.generateNumberOfTilesComputation
//	}
	
	
	def receiveStart(DTiledBlock tb) '''
		«val opts = tb.containerLoop.dtilingOptions»
		«val tcl = tb.containerLoop.generatorLoop as MPICLoop»
«««		«val tm = tcl.function.codeunit.system.targetMapping»
		//Initiate receive if the sender of the next tile is in the outset
		{
			//receive happens in the first tile in the chunk only
			if («opts.getTileIndex(1)» == «chunkOrigin») {
				//Receive Buffer
				«FOR b : tcl.buffers»
					if («b.receiveDomain.printConstraints») {
						MPI_Irecv(&«b.variable.name»(«recvBuffer», 0), «b.computeBufferSize.toCString», «b.variable.MPITypeString», _src_, 0, MPI_COMM_WORLD, &«requests»[«recvBuffer»]);
					}
				«ENDFOR»
			}
		}
	'''
	def receiveEnd(DTiledBlock tb) '''
		«val opts = tb.containerLoop.dtilingOptions»
		«val tcl = tb.containerLoop.generatorLoop as MPICLoop»
«««		«val tm = tcl.function.codeunit.system.targetMapping»
		//Wait on the issued Irecv, and copy values to local memory
		{
			//when in the first chunk
			if («opts.getTileIndex(1)» == «chunkOrigin») {
				//Receive Buffer
				«FOR b : tcl.buffers»
					if («b.receiveDomain.printConstraints») {
						MPI_Wait(&«requests»[«recvBuffer»], NULL);
						«requests»[«sendBuffer»] = NULL;
					}
				«ENDFOR»
				//Copy to Local Memory
				«tcl.receiveBufferCopyLoop.generateLoopNest»
			}
		}
	'''
	
	def sendBody(DTiledBlock tb) '''
		«val opts = tb.containerLoop.dtilingOptions»
		«val tcl = tb.containerLoop.generatorLoop as MPICLoop»
«««		«val tm = tcl.function.codeunit.system.targetMapping»
		//Send code
		{
			//send happens in the last tile of a chunk only
			if ((«opts.getTileIndex(1)» == «chunkOrigin»+(«numTilesPerChunk»-1)*«opts.getTileSize(1)»)) {
				
				«FOR b : tcl.buffers»
					if («b.sendDomain.printConstraints») {
						//wait for send buffer to be available before copying in 
						if («requests»[«sendBuffer»] != NULL) {
							MPI_Wait(&«requests»[«sendBuffer»], NULL);
							«requests»[«sendBuffer»] = NULL;
						}
					}
				«ENDFOR»
				//Copy from Local Memory
				«tcl.sendBufferCopyLoop.generateLoopNest»
				//Send Buffer
				«FOR b : tcl.buffers»
					if («b.sendDomain.printConstraints») {
						MPI_Isend(&«b.variable.name»(«sendBuffer», 0), «b.computeBufferSize.toCString», «b.variable.MPITypeString», _dst_, 0, MPI_COMM_WORLD, &«requests»[«sendBuffer»]);
					}
				«ENDFOR»
			}
		}
	'''
}