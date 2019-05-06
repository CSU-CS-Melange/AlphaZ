package org.polymodel.polyhedralIR.codegen.xtend2.MPIC

import org.polymodel.polyhedralIR.codegen.xtend2.BaseFunction
import org.polymodel.polyhedralIR.polyIRCG.Function
import static extension org.polymodel.polyhedralIR.codegen.xtend2.Indexed.*
import static extension org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForDistributed.*
import static extension org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForTiling.*
import static extension org.polymodel.polyhedralIR.codegen.xtend2.Utility.*
import org.polymodel.polyhedralIR.AffineSystem
import org.polymodel.polyhedralIR.VariableDeclaration
import org.polymodel.polyhedralIR.Domain
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility
import java.util.ArrayList
import org.polymodel.algebra.Variable
import java.util.List
import org.polymodel.algebra.factory.IntExpressionBuilder
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations

class MPICFunction extends BaseFunction {
	
	override functionBody(Function func) '''
		int «numP», «pid»;
		MPI_Comm_size(MPI_COMM_WORLD,&«numP»);
		MPI_Comm_rank(MPI_COMM_WORLD,&«pid»);
		
		//Source and Destination should be the neighbor in our scheme
		int _src_ = «pid»-1;
		if (_src_ < 0) _src_ = «numP»-1;
		int _dst_ = «pid»+1;
		if (_dst_ >= «numP») _dst_ = 0;
		
		«func.codeunit.system.generateNumberOfTilesComputation»
		
		«func.codeunit.system.generateChunkSizeComputation»
		
		«super.functionBody(func)»
	'''
		
//		//number of buffers w/o double buffering
//		«val numTiles = system.targetMapping.tiling.numberOfTiledDimensions»
//		«var i = 2»
//		«var tiles = newArrayList()»
//		«while (i < numTiles) {
//			tiles.add(i);
//			i = i+1	
//		}»
//		#ifndef «BUFFERING_FACTOR»
//			int «BUFFERING_FACTOR» = «chunkPerP» «tiles.join(" * ", " * ", "", [t|tileSizePrefix+t])»;
//		#endif


	def generateChunkSizeComputation(AffineSystem system) '''
		//default chunk size is computed when given chunk size is invalid
		if («numTilesPerChunk» <= 0) {
			«numTilesPerChunk» = ceild(«numTilesPrefix»1, «numP»);
		}
		
		int «chunkSize» = «numTilesPerChunk» * «tileSizePrefix»1;
		
		//number of chunks per processor
		int «chunkPerP» = ceild(«numTilesPrefix»1, «numTilesPerChunk»);
		
		#ifdef DEBUG
			printf("«pid»:%d «numTilesPerChunk»:%d «chunkPerP»:%d\n", «pid», «numTilesPerChunk», «chunkPerP»);
		#endif
	'''
//		if («chunkSizeT» <= 0) {
//			«chunkSizeT» = ceild(«chunkSizeP», «numT»); 
//		}
/*
			 */	
			 
	//System should be CoBed by now
	def generateNumberOfTilesComputation(AffineSystem system) {
		var Domain udom = null;
		//collect union
		for (VariableDeclaration v : system.locals + system.outputs) {
			if (udom == null) {
				udom = v.domain.copy
			} else {
				udom = udom.union(v.domain)
			}
		}
		//project and simplify
		val orderingDim = system.targetMapping.getSpaceTimeLevel(0).getOrderingDimensions()
		udom = DomainOperations::removeOrderingDimensions(udom, orderingDim)
		udom.simplify
		
		var res = '''//number of tiles'''
		//for each dimension, compute ceild((UBx - LBx), tsx)
		for (i : udom.indices.indexed) {
			val lbub = udom.getBounds(i.index0)
			//add 1 since index starts from 0
			val size = IntExpressionBuilder::sum(IntExpressionBuilder::sub(lbub.get(1), lbub.get(0)), IntExpressionBuilder::constant(1));
			res = '''
					«res»
					int «numTilesPrefix»«i.index1» = ceild(«size.toCString», «getTileSizeName(i.index1)»);
				'''
		}
		
		return res
	}
			 
//	def dispatch generateNumberOfTilesComputation(ScopFor sf) '''
//		int «numTilesPrefix»«sf.loopDepth» = ceild(«sf.UB.toCString» - «sf.LB.toCString», «getTileSizeName(sf.loopDepth)»);
//		«IF sf.body != null»«sf.body.generateNumberOfTilesComputation»«ENDIF»
//	'''
//	
//	def dispatch generateNumberOfTilesComputation(ScopBlock sb) {
//		sb.statements.head.generateNumberOfTilesComputation
//	}
}