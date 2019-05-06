package org.polymodel.polyhedralIR.codegen.xtend2.MPIC

import org.polymodel.scop.cgenerator2.template.Xtend2_Annotation
import org.polymodel.scop.annotation.BarrierAnnotation;

class CAnnotationForMPIC extends Xtend2_Annotation {
	
	override dispatch annotationBeforeStatement(BarrierAnnotation ba) {
		if (ba.before) {
			if (ba.type == 0) {
				super.annotationBeforeStatement(ba)
			} else {
				'''MPI_Barrier(MPI_COMM_WORLD);'''
			}
		}
	}
	override dispatch annotationAfterStatement(BarrierAnnotation ba) {
		if (!ba.before) {
			if (ba.type == 0) {
				super.annotationBeforeStatement(ba)
			} else {
				'''MPI_Barrier(MPI_COMM_WORLD);'''
			}
		}
	}
	
}