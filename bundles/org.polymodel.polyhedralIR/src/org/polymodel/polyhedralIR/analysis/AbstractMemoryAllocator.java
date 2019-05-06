package org.polymodel.polyhedralIR.analysis;

import org.polymodel.polyhedralIR.AffineSystem;

public abstract class AbstractMemoryAllocator {

	protected final AffineSystem system;
	
	public AbstractMemoryAllocator(AffineSystem system) {
		this.system = system;
	}
	
	protected abstract void allocate();
	

	public abstract void reflect();
}
