//// *******************************************************************************
//// Copyright (C) 2008 Sanjay Rajopadhye. All rights reserved
//// Author: DaeGon Kim 
////
//// This program is free software; you can redistribute it and/or
//// modify it under the terms of the GNU General Public License
//// as published by the Free Software Foundation; either version 2
//// of the License, or (at your option) any later version.
////
//// This program is distributed in the hope that it will be useful,
//// but WITHOUT ANY WARRANTY; without even the implied warranty of
//// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//// GNU General Public License for more details.
////
//// You should have received a copy of the GNU General Public License
//// along with this program; if not, If not, see 
//// http://www.gnu.org/licenses/, or write to the Free Software 
//// Foundation, Inc., 51 Franklin Street, Fifth Floor,
//// Boston, MA  02110-1301, USA.
//// *******************************************************************************
//
//package org.polymodel.polyhedralIR.polyIRCG.generator;
//
//import java.util.Comparator;
//import java.util.LinkedList;
//import java.util.List;
//
//import org.polymodel.polyhedralIR.ParameterDomain;
//import org.polymodel.polyhedralIR.polyIRCG.Statement;
//import org.polymodel.polyhedralIR.polyIRCG.C.CLoop;
//import org.polymodel.scop.ScopRoot;
//import org.polymodel.scop.bridge.clast.JNIClastToScopModel;
//
//import fr.irisa.cairn.jnimap.cloog.jni.ClastPrettyPrinter;
//import fr.irisa.cairn.jnimap.cloog.jni.JNIClastRoot;
//import fr.irisa.cairn.jnimap.cloog.jni.JNIClastStmt;
//import fr.irisa.cairn.jnimap.cloog.jni.JNIClastToModel;
//import fr.irisa.cairn.jnimap.cloog.jni.JNICloogInput;
//import fr.irisa.cairn.jnimap.cloog.jni.JNICloogOptions;
//import fr.irisa.cairn.jnimap.cloog.jni.JNICloogState;
//import fr.irisa.cairn.jnimap.cloog.util.CloogOptionSpecifier;
//import fr.irisa.cairn.model.polymodel.util.PolyModelToISLString;
//import fr.irisa.cairn.model.polymodel.util.PolyModelToISLString.CloogInputDomain;
//import fr.irisa.cairn.model.polymodel.util.PolyModelToISLString.NAMING_SCHEME;
//
//public class ClastGenerator {
//
//	/**
//	 * Generates Clast from statements and surrounding domains
//	 * 
//	 * @param params
//	 * @param indexNames
//	 * @param statements
//	 * @param options
//	 * @return
//	 */
//	public static ClastRoot generateClast(ParameterDomain params, List<String> indexNames, List<Statement> statements, CloogOptionSpecifier options) {
//
//		try {
//			JNICloogState state = new JNICloogState();
//			JNICloogOptions opt = options.getJNIObject(state);
//			String context = PolyModelToISLString.toString(params.getPMdomain(), NAMING_SCHEME.GIVEN_NAME);
//			List<CloogInputDomain> cids = new LinkedList<CloogInputDomain>();
//			int num = 0;
//			for (Statement statement : statements) {
//				cids.add(new CloogInputDomain(statement.getDomain().getPMdomain(), statement.getName(), num));
//				num++;
//			}
//						
//			String union_domain = PolyModelToISLString.toCloogInputString(cids, NAMING_SCHEME.GIVEN_NAME);
//
////			System.out.println(context);
////			System.out.println(union_domain);
//			
//			JNICloogInput input = new JNICloogInput(state, context, union_domain.toString(), opt);
//			
//			JNIClastStmt root = input.generate(opt);
//			
////			root.pprint(opt);
//			System.out.println(ClastPrettyPrinter.pp(root));
//			
//			ScopRoot sroot = JNIClastToScopModel.adapt((JNIClastRoot) root);
//			System.out.println(org.polymodel.scop.cgenerator.CGenerator.generate(sroot));
//
//			ClastRoot clastRoot = JNIClastToModel.adapt((JNIClastRoot) root);
//			
//			if (options.otlClast != 0) {
//				clastRoot = ClastRemoveOTL.removeOTL(clastRoot, options.otlClast);
//			}
//			
//			//rename loop iterators
//			if (indexNames.size() > 0) {
//				LoopIteratorUtil.renameIterators(clastRoot, indexNames);
//			}
//			
//			return clastRoot;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new RuntimeException("Failed to generate Clast.");
//		}
//	}
//	
//	/**
//	 * Generates ClooG Loop with default Options
//	 * 
//	 * @param params
//	 * @param indexNames
//	 * @param statements
//	 * @return
//	 */
//	public static ClastRoot generateClast(ParameterDomain params, List<String> indexNames, List<Statement> statements) {
//		try {
//			return generateClast(params, indexNames, statements, CloogOptionSpecifier.getDefault());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new RuntimeException("Failed to create JNICloogOptions.");
//		}
//	}
//	
//	/**
//	 * Return a scanning loops as CLooG AST (Clast)
//	 */
//	public static ClastRoot generateClast(CLoop poly) {
//		return generateClast(poly.getParameterDomain(), poly.getIteratorNames(), poly.getStatements());
//	}
//	public static ClastRoot generateClast(CLoop poly, CloogOptionSpecifier options) {
//		return generateClast(poly.getParameterDomain(), poly.getIteratorNames(), poly.getStatements(), options);
//	}
//	
//	private static class StatementComparator implements Comparator<Statement> {
//
//		@Override
//		public int compare(Statement o1, Statement o2) {
//			return o1.getName().compareTo(o2.getName());
//		}
//
//	}
//	
//	private static class ClastLoopParallelizer extends ClastVisitorImpl {
//		protected List<Integer> loopIdTracker = new LinkedList<Integer>(); 
//		protected int depth = -1;
//		
//		protected void loopTrackIn() {
//			//depth starts from 1 when starting from system
//			depth++;
//			if (loopIdTracker.size() <= depth) {
//				loopIdTracker.add(0);
//			} else {
//				loopIdTracker.set(depth, loopIdTracker.get(depth)+1);	
//			}
//			printId();
//		}
//		
//		protected void loopTrackOut() {
//			if (loopIdTracker.size() > depth) {
//				loopIdTracker.set(depth, -1);
//			}
//			depth--;
//		}
//		protected void printId() {
//			StringBuffer id = new StringBuffer();
//			for (int i = 0; i <= depth; i++) {
//				if (id.length() > 0) {
//					id.append(",");
//				}
//				id.append(loopIdTracker.get(i));
//			}
//			System.out.println("loopId = ("+id+")\n"); 
//		}
//		
//		@Override
//		public void visitClastFor(ClastFor c) {
//			loopTrackIn();
//			super.visitClastFor(c);
//			loopTrackOut();
//		}
//	}
//}
