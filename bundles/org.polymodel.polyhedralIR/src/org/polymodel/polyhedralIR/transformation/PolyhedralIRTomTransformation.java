package org.polymodel.polyhedralIR.transformation;
import org.eclipse.emf.ecore.EObject;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;

import fr.irisa.cairn.tools.ecore.EcoreUpdater;
import tom.library.sl.VisitFailure;

public abstract class PolyhedralIRTomTransformation {

		protected void transform(Program p){
			gtransform(p);
		}
		protected void transform(AffineSystem s){
			gtransform(s);
		}
		protected void transform(StandardEquation eq){
			gtransform(eq);
		}
		protected void transform(Expression expr){
			gtransform(expr);
		}
		
		protected EObject gtransform(EObject e){
			EObject t;
			try {
				t = (EObject) apply(e);
				if(t != e){
					EcoreUpdater.update(e,t);
				}
				return t;
			} catch (VisitFailure e1) {
				throw new RuntimeException();
			}
		}
		
		protected abstract EObject apply(EObject o) throws VisitFailure;
}
