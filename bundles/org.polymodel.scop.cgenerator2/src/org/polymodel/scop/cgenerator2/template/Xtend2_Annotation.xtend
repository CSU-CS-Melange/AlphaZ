package org.polymodel.scop.cgenerator2.template

import org.polymodel.scop.IScopAnnotation
import org.polymodel.scop.annotation.ParallelLoopAnnotation
import org.polymodel.scop.annotation.ParallelBlockAnnotation
import org.polymodel.scop.annotation.BarrierAnnotation
import org.polymodel.scop.annotation.DescriptionAnnotation
import org.polymodel.scop.annotation.VectorizationAnnotation
import org.polymodel.scop.annotation.SingleAnnotation

class Xtend2_Annotation {
	
	def dispatch annotationBeforeStatement(IScopAnnotation ann) {
		
	}
	
	def dispatch annotationAfterStatement(IScopAnnotation ann) {
		
	}
	
	def dispatch annotationBeforeStatement(ParallelLoopAnnotation p) {
		'''#pragma omp parallel for «IF p.privates.size > 0»private(«p.privates.join(",", [pp|pp.toString])»)«ENDIF»«IF p.schedule != null» schedule(«p.schedule» «IF p.chunksize > 0»,«p.chunksize»«ENDIF»)«ENDIF»'''
	}
	
	def dispatch annotationBeforeStatement(ParallelBlockAnnotation p) {
		'''#pragma omp parallel «IF p.privates.size > 0»private(«p.privates.join(",", [pp|pp.toString])»)«ENDIF»'''
	}
	
	def dispatch annotationBeforeStatement(BarrierAnnotation b) {
		if (b.before) {
			'''#pragma omp barrier'''
		}
	}
	
	def dispatch annotationAfterStatement(BarrierAnnotation b) {
		if (!b.before) {
			'''#pragma omp barrier'''
		}
	}
	
	def dispatch annotationBeforeStatement(VectorizationAnnotation v){
		'''
		«IF v.ivdep»#pragma ivdep«ENDIF»
		#pragma vector always 
		'''
	}
	
	def dispatch annotationBeforeStatement(SingleAnnotation s){
		'''#pragma omp single'''
	}
	
	def dispatch annotationBeforeStatement(DescriptionAnnotation d) {
		'''//«d.description»'''
	}
}