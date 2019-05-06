package org.polymodel.scop.util;

import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopVisitable;
import org.polymodel.scop.impl.ScopDepthFirstVisitorImpl;

public class ScopPrinter extends ScopDepthFirstVisitorImpl {
	
	private StringBuffer buffer;
	
	protected ScopPrinter() {
		buffer = new StringBuffer();
	}
	
	public static String toString(ScopVisitable v) {
		ScopPrinter printer = new ScopPrinter();
		v.accept(printer);
		return printer.buffer.toString();
	}
	
	@Override
	public void defaultIn(ScopVisitable node) {
		buffer.append(node.toString()+"\n");
	}
	
	@Override
	public void inScopBlock(ScopBlock s) {
		buffer.append("{\n");
	}
	
	@Override
	public void outScopBlock(ScopBlock s) {
		buffer.append("}\n");
	}
	
//	@Override
//	public void inScopFor(ScopFor s) {
//		System.out.println(s);
//		System.out.println(s.getScopAnnotations());
//	}
//
//	@Override
//	public void inScopBlock(ScopBlock s) {
//		System.out.println(s);
//		System.out.println(s.getStatements());
//	}

}
