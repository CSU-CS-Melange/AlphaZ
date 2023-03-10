package tom.mapping.introspectors.algebra.reductions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.polymodel.algebra.reductions.ReductionsPackage;

import tom.library.sl.Introspector;
import tom.mapping.IntrospectorManager;


/* PROTECTED REGION ID(introspector_imports) ENABLED START */
// protected imports
/* PROTECTED REGION END */

/**
* TOM introspector for algebra.
* -- Autogenerated by TOM mapping EMF genrator --
*/

public class ReductionsIntrospector implements Introspector {
	
	public static final ReductionsIntrospector INSTANCE = new ReductionsIntrospector();
	
	static {
		IntrospectorManager.INSTANCE.register(ReductionsPackage.eINSTANCE, INSTANCE);
	}

	/* PROTECTED REGION ID(introspector_members) ENABLED START */
	/* PROTECTED REGION END */
	
	protected ReductionsIntrospector() {}
	
	public Object getChildAt(Object o, int i) {
		return getChildren(o)[i];
	}
	
	public int getChildCount(Object o) {
		return getChildren(o).length;
	}
	
	@SuppressWarnings("unchecked")
	public Object[] getChildren(Object arg0) {
		List<Object> l = new ArrayList<Object>();
		if (arg0 instanceof List) {
			// Children of a list are its content
			for(Object object : (List<Object>) arg0) {
				l.add(object);
			}
			return l.toArray();
		}
		return ReductionsChildrenGetter.INSTANCE.children(arg0);
	}
	
	private static class ReductionsChildrenGetter extends org.polymodel.algebra.reductions.util.ReductionsSwitch<Object[]> {
		public final static ReductionsChildrenGetter INSTANCE = new ReductionsChildrenGetter();
		
		private ReductionsChildrenGetter(){}
		
		public Object[] children(Object i) {
			Object[] children = doSwitch((EObject) i);
			return children != null ? children : new Object[0];
		}
		
		public Object[] caseReductionExpression(org.polymodel.algebra.reductions.ReductionExpression o) {
			List<Object> l = new ArrayList<Object>();
			if (o.getExpressions() != null)
				l.add(o.getExpressions());
			
			/*PROTECTED REGION ID(getter_reductions_ReductionExpression) ENABLED START*/
			/*PROTECTED REGION END*/
			
			return l.toArray();
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T> T setChildren(T arg0, Object[] arg1) {
		if (arg0 instanceof List) {
			// If object is a list then content of the original list has to be replaced
			List<Object> list = (List<Object>) arg0;
			list.clear();
			for (int i = 0; i < arg1.length; i++) {
				list.add(arg1[i]);
			}
			return arg0;
		} else {
			return (T) ReductionsChildrenSetter.INSTANCE.set(arg0, arg1);
		}
	}
	
	private static class ReductionsChildrenSetter extends org.polymodel.algebra.reductions.util.ReductionsSwitch<Object> {
		public final static ReductionsChildrenSetter INSTANCE = new ReductionsChildrenSetter();
		
		private ReductionsChildrenSetter(){}
		
		public Object set(Object i, Object[] children) {
			return doSwitch((EObject) i);
		}
	}

	public <T> T setChildAt(T o, int i, Object obj) {
		throw new RuntimeException("Not implemented");
	}
}
