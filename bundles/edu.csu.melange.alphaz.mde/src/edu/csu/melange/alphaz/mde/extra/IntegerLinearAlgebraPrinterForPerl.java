package edu.csu.melange.alphaz.mde.extra;

import org.eclipse.emf.ecore.EObject;
import org.polymodel.IndexDimension;

/**
 * This class is no longer functional as we switched to org.polymodel
 * 
 * @author yuki
 *
 */
public class IntegerLinearAlgebraPrinterForPerl /*extends IntegerLinearAlgebraPrinter*/ {
	
//	private static final IntegerLinearAlgebraPrinterForPerl INSTANCE = new IntegerLinearAlgebraPrinterForPerl(FORMAT.C);
//
//	protected IntegerLinearAlgebraPrinterForPerl(FORMAT format) {
//		super(format);
//	}
//	
//	public static String toString(EObject obj) {
//		return INSTANCE.doSwitch(obj);
//	}
//
//	
//	@Override
//	public String caseIntTermExpression(IntTermExpression o) {
//		if (o.getValue() == 0) return "0";
//		StringBuffer buf = new StringBuffer();
//		if (o.getValue() < 0) {
//			buf.append("-");
//		}
//		int abs = Math.abs(o.getValue());
//		if (o.getVar() == null) {
//			buf.append(abs);
//		} else {
//			if (abs==1) {
//				
//			} else {
//				buf.append(abs+"*");
//			}
//			String name ="";
//			if (useNames && o.getVar() instanceof IndexDimension) {
//				name = "$"+((IndexDimension)o.getVar()).getDimName(names);
//			} else {
//				name = "$"+o.getVar().toString();
//			}
//			if(name.toUpperCase().equals("MAX") || name.toUpperCase().equals("MIN")) {
//				name="_"+name;
//			}
//			buf.append(name);
//
//		}
//		return buf.toString();
//	}
}
