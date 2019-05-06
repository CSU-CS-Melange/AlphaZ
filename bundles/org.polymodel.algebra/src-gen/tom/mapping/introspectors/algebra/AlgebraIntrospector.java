package tom.mapping.introspectors.algebra;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.polymodel.algebra.AlgebraPackage;

import tom.library.sl.Introspector;
import tom.mapping.IntrospectorManager;


/* PROTECTED REGION ID(introspector_imports) ENABLED START */
// protected imports
/* PROTECTED REGION END */

/**
* TOM introspector for algebra.
* -- Autogenerated by TOM mapping EMF genrator --
*/

public class AlgebraIntrospector implements Introspector {
	
	public static final AlgebraIntrospector INSTANCE = new AlgebraIntrospector();
	
	static {
		IntrospectorManager.INSTANCE.register(AlgebraPackage.eINSTANCE, INSTANCE);
	}

	/* PROTECTED REGION ID(introspector_members) ENABLED START */
	/* PROTECTED REGION END */
	
	protected AlgebraIntrospector() {}
	
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
		return AlgebraChildrenGetter.INSTANCE.children(arg0);
	}
	
	private static class AlgebraChildrenGetter extends org.polymodel.algebra.util.AlgebraSwitch<Object[]> {
		public final static AlgebraChildrenGetter INSTANCE = new AlgebraChildrenGetter();
		
		private AlgebraChildrenGetter(){}
		
		public Object[] children(Object i) {
			Object[] children = doSwitch((EObject) i);
			return children != null ? children : new Object[0];
		}
		
		public Object[] caseIntConstraint(org.polymodel.algebra.IntConstraint o) {
			List<Object> l = new ArrayList<Object>();
			if (o.getLhs() != null)
				l.add(o.getLhs());
			if (o.getRhs() != null)
				l.add(o.getRhs());
			
			/*PROTECTED REGION ID(getter_algebra_IntConstraint) ENABLED START*/
			/*PROTECTED REGION END*/
			
			return l.toArray();
		}
		
		public Object[] caseIntConstraintSystem(org.polymodel.algebra.IntConstraintSystem o) {
			List<Object> l = new ArrayList<Object>();
			if (o.getConstraints() != null)
				l.add(o.getConstraints());
			
			/*PROTECTED REGION ID(getter_algebra_IntConstraintSystem) ENABLED START*/
			/*PROTECTED REGION END*/
			
			return l.toArray();
		}
		
		public Object[] caseCompositeIntExpression(org.polymodel.algebra.CompositeIntExpression o) {
			List<Object> l = new ArrayList<Object>();
			if (o.getLeft() != null)
				l.add(o.getLeft());
			if (o.getRight() != null)
				l.add(o.getRight());
			
			/*PROTECTED REGION ID(getter_algebra_CompositeIntExpression) ENABLED START*/
			/*PROTECTED REGION END*/
			
			return l.toArray();
		}
		
		public Object[] caseSelectExpression(org.polymodel.algebra.SelectExpression o) {
			List<Object> l = new ArrayList<Object>();
			if (o.getCondition() != null)
				l.add(o.getCondition());
			if (o.getThen() != null)
				l.add(o.getThen());
			if (o.getElse() != null)
				l.add(o.getElse());
			
			/*PROTECTED REGION ID(getter_algebra_SelectExpression) ENABLED START*/
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
			return (T) AlgebraChildrenSetter.INSTANCE.set(arg0, arg1);
		}
	}
	
	private static class AlgebraChildrenSetter extends org.polymodel.algebra.util.AlgebraSwitch<Object> {
		public final static AlgebraChildrenSetter INSTANCE = new AlgebraChildrenSetter();
		
		private Object[] children;
		private AlgebraChildrenSetter(){}
		
		public Object set(Object i, Object[] children) {
			this.children = children;
			return doSwitch((EObject) i);
		}
		
		public Object caseIntConstraint(org.polymodel.algebra.IntConstraint o) {
			o.setLhs((org.polymodel.algebra.IntExpression)children[0]);
			o.setRhs((org.polymodel.algebra.IntExpression)children[1]);
		
			/*PROTECTED REGION ID(setter_algebra_IntConstraint) ENABLED START*/
			/*PROTECTED REGION END*/
		
			return o;
		}
		
		public Object caseCompositeIntExpression(org.polymodel.algebra.CompositeIntExpression o) {
			o.setLeft((org.polymodel.algebra.IntExpression)children[0]);
			o.setRight((org.polymodel.algebra.IntExpression)children[1]);
		
			/*PROTECTED REGION ID(setter_algebra_CompositeIntExpression) ENABLED START*/
			/*PROTECTED REGION END*/
		
			return o;
		}
		
		public Object caseSelectExpression(org.polymodel.algebra.SelectExpression o) {
			o.setThen((org.polymodel.algebra.IntExpression)children[0]);
			o.setElse((org.polymodel.algebra.IntExpression)children[1]);
		
			/*PROTECTED REGION ID(setter_algebra_SelectExpression) ENABLED START*/
			/*PROTECTED REGION END*/
		
			return o;
		}
	}

	public <T> T setChildAt(T o, int i, Object obj) {
		throw new RuntimeException("Not implemented");
	}
}