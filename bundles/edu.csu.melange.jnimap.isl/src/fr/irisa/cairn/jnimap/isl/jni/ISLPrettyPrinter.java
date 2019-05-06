package fr.irisa.cairn.jnimap.isl.jni;

 

public class ISLPrettyPrinter {

//	public static enum ISL_FORMAT {};

	
	//private static JNIISLContext context;

	public static JNIISLContext getContext() {
		return JNIISLContext.getCtx();
	}
	
	@Deprecated
	public static JNIISLSet islSet(String setTxt) {
		return JNIISLSet.buildFromString(getContext(), setTxt);
	}
//	public static JNIISLBasicSet islBasicSet(String setTxt) {
//		return new JNIISLBasicSet(setTxt, -1);
//	}

	@Deprecated
	public static JNIISLMap islMap(String setTxt) {
		return JNIISLMap.buildFromString(getContext(), setTxt);
	}

	public static String asString(JNIISLVal v) {
		return JNIISLVal._toString(v, ISL_FORMAT.ISL.ordinal());
	}

	public static String asString(JNIISLMultiVal mv) {
		return JNIISLMultiVal._toString(mv, ISL_FORMAT.ISL.ordinal());
	}

	public static String asString(JNIISLValList vlist) {
		return JNIISLValList._toString(vlist, ISL_FORMAT.ISL.ordinal());
	}

	public static String asString(JNIISLIdentifier id) {
		return JNIISLIdentifier._toString(id, ISL_FORMAT.ISL.ordinal());
	}

	public static String asString(JNIISLIdentifierList idlist) {
		return JNIISLIdentifierList._toString(idlist, ISL_FORMAT.ISL.ordinal());
	}

	public static String asString(JNIISLSet set) {
		return JNIISLSet._toString(set, ISL_FORMAT.ISL.ordinal());
	}

	public static String asString(JNIISLSet set, ISL_FORMAT format) {
		return JNIISLSet._toString(set, format.ordinal());
	}
	
	
	public static String asString(JNIISLBasicSet set) {
		return JNIISLBasicSet._toString(set, ISL_FORMAT.ISL.ordinal());
	}
	
	public static String asString(JNIISLBasicSet set, ISL_FORMAT format) {
		return JNIISLBasicSet._toString(set, format.ordinal());
	}

	public static String asString(JNIISLUnionSet jniislUnionSet) {
		return JNIISLUnionSet._toString(jniislUnionSet, ISL_FORMAT.ISL.ordinal());
	}

	public static String asString(JNIISLBasicSetList bsetlist) {
		return JNIISLBasicSetList._toString(bsetlist, ISL_FORMAT.ISL.ordinal());
	}

	public static String asString(JNIISLSetList setlist) {
		return JNIISLSetList._toString(setlist, ISL_FORMAT.ISL.ordinal());
	}

	public static String asString(JNIISLBasicMap set, ISL_FORMAT format) {
		return JNIISLBasicMap._toString(set, format.ordinal());
	}

	public static String toString(JNIISLBasicMap set) {
		return JNIISLBasicMap._toString(set, ISL_FORMAT.ISL.ordinal());
	}

	public static String asString(JNIISLBasicMap set) {
		return JNIISLBasicMap._toString(set, ISL_FORMAT.ISL.ordinal());
	}


	public static String asString(JNIISLMap set) {
		return JNIISLMap._toString(set, ISL_FORMAT.ISL.ordinal());
	}

	public static String asString(JNIISLMap set, ISL_FORMAT format) {
		return JNIISLMap._toString(set, format.ordinal());
	}

	public static String toString(JNIISLUnionMap set,ISL_FORMAT format) {
		return JNIISLUnionMap._toString(set, format.ordinal());
	}

	public static String toString(JNIISLUnionMap set) {
		return JNIISLUnionMap._toString(set, ISL_FORMAT.ISL.ordinal());
	}

	//	public static String asString2(JNIISLConstraint cstr) {
	//		return cstr._toString();
	//		
	//		
	////		JNIISLDimType isl_dim_type = JNIISLDimType.isl_dim_param;
	////		for(int i=0;i<cstr.getNumberOfCoefficientsFoDimension(isl_dim_type);i++) {
	////			
	////			long coefficientAt = cstr.getCoefficientAt(isl_dim_type, i);
	////			if (coefficientAt!=0)
	////				if(coefficientAt==1)
	////					buf.append(cstr.getNameAt(isl_dim_type, i)+" + ");
	////				else
	////					buf.append(coefficientAt+"*"+cstr.getNameAt(isl_dim_type, i)+" + ");
	////		}
	////		isl_dim_type = JNIISLDimType.isl_dim_set;
	////		for(int i=0;i<cstr.getNumberOfCoefficientsFoDimension(isl_dim_type);i++) {
	////			long coefficientAt = cstr.getCoefficientAt(isl_dim_type, i);
	////			if (coefficientAt!=0)
	////				if(coefficientAt==1)
	////					buf.append(cstr.getNameAt(isl_dim_type, i)+" + ");
	////				else
	////					buf.append(coefficientAt+"*"+cstr.getNameAt(isl_dim_type, i)+" + ");
	////		}
	////		isl_dim_type = JNIISLDimType.isl_dim_div;
	////		for(int i=0;i<cstr.getNumberOfCoefficientsFoDimension(isl_dim_type);i++) {
	////			long coefficientAt = cstr.getCoefficientAt(isl_dim_type, i);
	////			if (coefficientAt!=0)
	////				if(coefficientAt==1)
	////					buf.append("e_"+i+" + ");
	////				else
	////					buf.append(coefficientAt+"*e_"+i+" + ");
	////
	////		}
	////		if( cstr.isEquality()>0) {
	////			buf.append(cstr.getConstant()+" = 0 ");
	////		} else {
	////			buf.append(cstr.getConstant()+" >= 0 ");
	////		}
	////		//cstr.getDiv(pos)
	//	//	return  "";//buf.toString();
	//	}
	
	public static String asString(JNIISLUnionMap jniislUnionMap) {
		return JNIISLUnionMap._toString(jniislUnionMap, ISL_FORMAT.ISL.ordinal());
	}

	public static String asString(JNIISLAff aff) {
		return JNIISLAff._toString(aff, ISL_FORMAT.ISL.ordinal());
	}

	public static String asString(JNIISLPWAff pa) {
		return JNIISLPWAff._toString(pa, ISL_FORMAT.ISL.ordinal());
	}
	
	public static String asString(JNIISLMultiAff maff) {
		return JNIISLMultiAff._toString(maff, ISL_FORMAT.ISL.ordinal());
	}

	public static String asString(JNIISLPWMultiAff pma) {
		return JNIISLPWMultiAff._toString(pma, ISL_FORMAT.ISL.ordinal());
	}

	public static String asString(JNIISLMultiPWAff mpa) {
		return JNIISLMultiPWAff._toString(mpa, ISL_FORMAT.ISL.ordinal());
	}

	public static String asString(JNIISLUnionPWMultiAff upma) {
		return JNIISLUnionPWMultiAff._toString(upma, ISL_FORMAT.ISL.ordinal());
	}

	public static String asString(JNIISLTerm set) {
		return "";//set.getN()+"/"+set.getD()+"^?";
	}

	public static String asString(JNIISLConstraint cstr) {
		return JNIISLConstraint._toString(cstr, ISL_FORMAT.ISL.ordinal());
	}
	  
	
//	public static String asString2(JNIISLConstraint cstr) {
//		return cstr._toString();
//		
//		
////		JNIISLDimType isl_dim_type = JNIISLDimType.isl_dim_param;
////		for(int i=0;i<cstr.getNumberOfCoefficientsFoDimension(isl_dim_type);i++) {
////			
////			long coefficientAt = cstr.getCoefficientAt(isl_dim_type, i);
////			if (coefficientAt!=0)
////				if(coefficientAt==1)
////					buf.append(cstr.getNameAt(isl_dim_type, i)+" + ");
////				else
////					buf.append(coefficientAt+"*"+cstr.getNameAt(isl_dim_type, i)+" + ");
////		}
////		isl_dim_type = JNIISLDimType.isl_dim_set;
////		for(int i=0;i<cstr.getNumberOfCoefficientsFoDimension(isl_dim_type);i++) {
////			long coefficientAt = cstr.getCoefficientAt(isl_dim_type, i);
////			if (coefficientAt!=0)
////				if(coefficientAt==1)
////					buf.append(cstr.getNameAt(isl_dim_type, i)+" + ");
////				else
////					buf.append(coefficientAt+"*"+cstr.getNameAt(isl_dim_type, i)+" + ");
////		}
////		isl_dim_type = JNIISLDimType.isl_dim_div;
////		for(int i=0;i<cstr.getNumberOfCoefficientsFoDimension(isl_dim_type);i++) {
////			long coefficientAt = cstr.getCoefficientAt(isl_dim_type, i);
////			if (coefficientAt!=0)
////				if(coefficientAt==1)
////					buf.append("e_"+i+" + ");
////				else
////					buf.append(coefficientAt+"*e_"+i+" + ");
////
////		}
////		if( cstr.isEquality()>0) {
////			buf.append(cstr.getConstant()+" = 0 ");
////		} else {
////			buf.append(cstr.getConstant()+" >= 0 ");
////		}
////		//cstr.getDiv(pos)
//	//	return  "";//buf.toString();
//	}

	public static String asString(JNIISLPoint p) {
		return p.getCoordinates().toString();
	}

	public static String asString(JNIISLDataflowAnalysis df) {
		String string = "May dep :" +df.getMay_dep() +"\n";
		string += "May no source :" +df.getMay_no_source() +"\n";
		string += "Must dep :" +df.getMust_dep() +"\n";
		string += "Must no source :" +df.getMust_no_source() +"\n";
		return string;
	}

	public static String asString(JNIISLSpace dim) {
		String tin = dim.getTupleName(JNIISLDimType.isl_dim_in);
		String tout = dim.getTupleName(JNIISLDimType.isl_dim_out);
		tin = tin==null?"":tin;
		tout = tout==null?"":tout;
		return ""+
			dim.getNameList(JNIISLDimType.isl_dim_param)+" -> {"+
			tin+
			dim.getNameList(JNIISLDimType.isl_dim_in)+" -> "+
			tout+
			dim.getNameList(JNIISLDimType.isl_dim_out)+" :"
			;
	}

	public static String asString(JNIISLMatrix m) {

		StringBuffer res = new StringBuffer();
		res.append(m.getNbRows()+"\n"+m.getNbCols()+"\n");
		for(int i=0;i<m.getNbRows();i++) {
			for(int j=0;j<m.getNbCols();j++) {
				long val = m.getElement(i,j);
				res.append(val+" ");
				
			}
			res.append("\n");
		}
		return res.toString();
		
	}

	public static String asString(JNIISLQPolynomial qp) {
		return JNIISLQPolynomial._toString(qp, ISL_FORMAT.ISL.ordinal());
	}

	public static String asString(JNIISLQPolynomialFold set) {
		return JNIISLQPolynomialFold._toString(set, ISL_FORMAT.ISL.ordinal());
	}

	public static String asString(JNIISLPWQPolynomial set) {
		return JNIISLPWQPolynomial._toString(set, ISL_FORMAT.ISL.ordinal());
	}

	public static String asString(JNIISLPWQPolynomialFold p) {
		return JNIISLPWQPolynomialFold._toString(p, ISL_FORMAT.ISL.ordinal());
	}

	public static String asString(JNIISLSchedule s) {
		return JNIISLSchedule._toString(s, ISL_FORMAT.ISL.ordinal());
	}

	public static String asString(JNIISLASTNode b) {
		return JNIISLASTNode._toString(b);
	}

	public static String asString(JNIISLASTExpression b) {
		return JNIISLASTExpression._toString(b);
	}

	public static String asString(Object obj) {
		
		return "default:"+obj.getClass().getSimpleName();
	}

}
