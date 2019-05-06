package org.polymodel.prdg.scheduling.observers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import fr.irisa.cairn.graph.observer.INotification;
import fr.irisa.cairn.graph.observer.IObserver;

/**
 * A reflexive polymorphic observer catch notifications using a specific naming
 * convention. <br>
 * <br>
 * For example, if the observer need to catch a ''MyNotification'' then it has
 * to contain a method: <br>
 * <br>
 * <code>void notify(MyNotification n)</code>
 * 
 * @author antoine
 * 
 */
public class ReflexiveObserver implements IObserver {

	@Override
	public void notify(INotification notification) {
		try {
			Method method = this.getClass().getMethod("notify",
					notification.getClass());
			try {
				method.invoke(this, notification);
			} catch (IllegalArgumentException e) {
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			}
		} catch (SecurityException e) {
		} catch (NoSuchMethodException e) {
		}
	}

}
