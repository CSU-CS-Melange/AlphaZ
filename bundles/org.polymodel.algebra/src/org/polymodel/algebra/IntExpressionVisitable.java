package org.polymodel.algebra;

public interface IntExpressionVisitable {
	public void accept(IntExpressionVisitor visitor);
}
