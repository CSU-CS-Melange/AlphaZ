package org.polymodel.isl.factory;

import java.util.List;

import org.polymodel.isl.ISLMap;
import org.polymodel.isl.ISLSet;
import org.polymodel.isl.ISLUnionMap;
import org.polymodel.isl.ISLUnionSet;
import org.polymodel.isl.IslFactory;

public class ISLBuilder {
	
	public static ISLMap map() {
		return IslFactory.eINSTANCE.createISLMap();
	}

	public static ISLSet set() {
		return IslFactory.eINSTANCE.createISLSet();
	}

//	public static ISLMap map() {
//		return IslFactory.eINSTANCE.createISLMap();
//	}
//
//	public static ISLSet set() {
//		return IslFactory.eINSTANCE.createISLSet();
//	}

	public static ISLUnionMap unionMap(List<ISLMap> maps) {
		ISLUnionMap res = IslFactory.eINSTANCE.createISLUnionMap();
		res.getMaps().addAll(maps);
		return res;
	}

	public static ISLUnionSet unionSet(List<ISLSet> sets) {
		ISLUnionSet res = IslFactory.eINSTANCE.createISLUnionSet();
		res.getSets().addAll(sets);
		return res;
	}
}
