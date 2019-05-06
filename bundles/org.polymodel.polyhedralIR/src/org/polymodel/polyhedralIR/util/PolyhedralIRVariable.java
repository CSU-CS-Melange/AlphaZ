package org.polymodel.polyhedralIR.util;

import org.polymodel.impl.IndexDimensionImpl;

public class PolyhedralIRVariable extends IndexDimensionImpl {

	public static enum TYPE {
		PARAM, INDEX
	}
	public final TYPE type;
	private final PolyhedralIRDimensionManager manager;
	
	public PolyhedralIRVariable(TYPE type, int dim, String name, PolyhedralIRDimensionManager manager) {
		this.type = type;
		this.manager = manager;
		setDimension(dim);
		setName(name);
	}
	
	
	
//	@Override
//	public String toString() {
//		return name+"("+type+","+dimension+")";
//	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public int getDimension() {
		return dimension;
	}
	
	public PolyhedralIRDimensionManager getManager() {
		return manager;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PolyhedralIRVariable) {
			PolyhedralIRVariable o = (PolyhedralIRVariable)obj;
			return (type == o.type) && (dimension == o.dimension);//(this.manager == o.manager) && 
		} else {
			return false;
		}
	}
}
