package org.polymodel.prdg.scheduling.structured;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.polymodel.algebra.IntExpression;

public class SubscriptAnnotation extends AdapterImpl {
	private IntExpression subscript;

	public SubscriptAnnotation(IntExpression subscript) {
		this.subscript = subscript;
	}

	public IntExpression getSubscript() {
		return subscript;
	}
	
	
}
