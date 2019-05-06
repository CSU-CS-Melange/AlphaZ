package fr.irisa.cairn.jnimap.isl.jni;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.irisa.cairn.jnimap.runtime.JNIObject;


/*** PROTECTED REGION ID(ISLASTBuild_userImport) ENABLED START ***/
	/*
		Put you custom import here ....
	*/
/*** PROTECTED REGION END ***/

/**
 *  Automatically generated by jnimap 
 * @generated
 */
public class JNIISLASTBuild extends JNIObject {
	
	
	/* @generated */
	protected JNIISLASTBuild(long ptr) {
		/*** PROTECTED REGION ID(ISLASTBuild_Constructor) DISABLED START ***/
		super(ptr);
		/*** PROTECTED REGION END ***/
	}
	
	
	/* @generated */
	static JNIISLASTBuild build(long ptr) {
		{
			return new JNIISLASTBuild(ptr);
		}
	}
	
	
	
	
	/*** PROTECTED REGION ID(ISLASTBuild_userCode) ENABLED START ***/
	@Deprecated
	public JNIISLContext getCtx() {
		return getContext();
	}
	/*** PROTECTED REGION END ***/

	/*************************************** 
	 *	     Struct Field Accessors        * 
	 ***************************************/

	
	/*************************************** 
	 *	         Static Methods            * 
	 ***************************************/
	/**
	 * isl_ast_build_from_context 
	 * 
	@take set
	 * @generated
	**/
	 public static JNIISLASTBuild buildFromContext(JNIISLSet set) { 
		/*** PROTECTED REGION ID(static_isl_ast_build_from_context) DISABLED START ***/
		JNIISLASTBuild res;
		
		synchronized(LOCK) {
			checkParameters(set);
			try {
				res = JNIISLASTBuild.build(ISLNative.isl_ast_build_from_context(getNativePtr(set)));
			} finally {
				taken(set);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_options_set_ast_build_exploit_nested_bounds 
	 * 
	 * @generated
	**/
	 public static int setExploitNestedBounds(JNIISLContext ctx, int val) { 
		/*** PROTECTED REGION ID(static_isl_options_set_ast_build_exploit_nested_bounds) DISABLED START ***/
		int res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = ISLNative.isl_options_set_ast_build_exploit_nested_bounds(getNativePtr(ctx), val);
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_options_get_ast_build_exploit_nested_bounds 
	 * 
	 * @generated
	**/
	 public static int getExploitNestedBounds(JNIISLContext ctx) { 
		/*** PROTECTED REGION ID(static_isl_options_get_ast_build_exploit_nested_bounds) DISABLED START ***/
		int res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = ISLNative.isl_options_get_ast_build_exploit_nested_bounds(getNativePtr(ctx));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_options_set_ast_build_atomic_upper_bound 
	 * 
	 * @generated
	**/
	 public static int setAtomicUpperBound(JNIISLContext ctx, int val) { 
		/*** PROTECTED REGION ID(static_isl_options_set_ast_build_atomic_upper_bound) DISABLED START ***/
		int res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = ISLNative.isl_options_set_ast_build_atomic_upper_bound(getNativePtr(ctx), val);
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_options_get_ast_build_atomic_upper_bound 
	 * 
	 * @generated
	**/
	 public static int getAtomicUpperBound(JNIISLContext ctx) { 
		/*** PROTECTED REGION ID(static_isl_options_get_ast_build_atomic_upper_bound) DISABLED START ***/
		int res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = ISLNative.isl_options_get_ast_build_atomic_upper_bound(getNativePtr(ctx));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_options_set_ast_build_separation_bounds 
	 * 
	 * @generated
	**/
	 public static int setSeparationBounds(JNIISLContext ctx, int val) { 
		/*** PROTECTED REGION ID(static_isl_options_set_ast_build_separation_bounds) DISABLED START ***/
		int res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = ISLNative.isl_options_set_ast_build_separation_bounds(getNativePtr(ctx), val);
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_options_get_ast_build_separation_bounds 
	 * 
	 * @generated
	**/
	 public static int getSeparationBounds(JNIISLContext ctx) { 
		/*** PROTECTED REGION ID(static_isl_options_get_ast_build_separation_bounds) DISABLED START ***/
		int res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = ISLNative.isl_options_get_ast_build_separation_bounds(getNativePtr(ctx));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	
	/*************************************** 
	 *	         Member Methods            * 
	 ***************************************/
	/**
	 * isl_ast_build_get_ctx 
	 * 
	 * @generated
	**/
	public JNIISLContext getContext() {
		/*** PROTECTED REGION ID(isl_ast_build_get_ctx) DISABLED START ***/
		JNIISLContext res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLContext.build(ISLNative.isl_ast_build_get_ctx(getNativePtr(this)));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_ast_build_copy 
	 * 
	 * @generated
	**/
	public JNIISLASTBuild copy() {
		/*** PROTECTED REGION ID(isl_ast_build_copy) DISABLED START ***/
		JNIISLASTBuild res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLASTBuild.build(ISLNative.isl_ast_build_copy(getNativePtr(this)));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_ast_build_free 
	 * 
	 * @take this
	 * @generated
	**/
	public void free() {
		/*** PROTECTED REGION ID(isl_ast_build_free) DISABLED START ***/
		
		synchronized(LOCK) {
			checkParameters(this);
			try {
				ISLNative.isl_ast_build_free(getNativePtr(this));
			} finally {
				taken(this);
			}
		}
		
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_ast_build_set_options 
	 * 
	 * @take this opts
	 * @generated
	**/
	public JNIISLASTBuild setOptions(JNIISLUnionMap opts) {
		/*** PROTECTED REGION ID(isl_ast_build_set_options) DISABLED START ***/
		JNIISLASTBuild res;
		
		synchronized(LOCK) {
			checkParameters(this, opts);
			try {
				res = JNIISLASTBuild.build(ISLNative.isl_ast_build_set_options(getNativePtr(this), getNativePtr(opts)));
			} finally {
				taken(this);
				taken(opts);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_ast_build_get_schedule 
	 * 
	 * @generated
	**/
	public JNIISLUnionMap getSchedule() {
		/*** PROTECTED REGION ID(isl_ast_build_get_schedule) DISABLED START ***/
		JNIISLUnionMap res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLUnionMap.build(ISLNative.isl_ast_build_get_schedule(getNativePtr(this)));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_ast_build_get_schedule_space 
	 * 
	 * @generated
	**/
	public JNIISLSpace getScheduleSpace() {
		/*** PROTECTED REGION ID(isl_ast_build_get_schedule_space) DISABLED START ***/
		JNIISLSpace res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLSpace.build(ISLNative.isl_ast_build_get_schedule_space(getNativePtr(this)));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_ast_build_restrict 
	 * 
	 * @take this set
	 * @generated
	**/
	public JNIISLASTBuild restrict(JNIISLSet set) {
		/*** PROTECTED REGION ID(isl_ast_build_restrict) DISABLED START ***/
		JNIISLASTBuild res;
		
		synchronized(LOCK) {
			checkParameters(this, set);
			try {
				res = JNIISLASTBuild.build(ISLNative.isl_ast_build_restrict(getNativePtr(this), getNativePtr(set)));
			} finally {
				taken(this);
				taken(set);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_ast_build_set_iterators 
	 * 
	 * @take this iterators
	 * @generated
	**/
	public JNIISLASTBuild unroll(JNIISLIdentifierList iterators) {
		/*** PROTECTED REGION ID(isl_ast_build_set_iterators) DISABLED START ***/
		JNIISLASTBuild res;
		
		synchronized(LOCK) {
			checkParameters(this, iterators);
			try {
				res = JNIISLASTBuild.build(ISLNative.isl_ast_build_set_iterators(getNativePtr(this), getNativePtr(iterators)));
			} finally {
				taken(this);
				taken(iterators);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_ast_build_node_from_schedule_map 
	 * 
	 * @take schedule
	 * @generated
	**/
	public JNIISLASTNode generate(JNIISLUnionMap schedule) {
		/*** PROTECTED REGION ID(isl_ast_build_node_from_schedule_map) DISABLED START ***/
		JNIISLASTNode res;
		
		synchronized(LOCK) {
			checkParameters(schedule);
			try {
				res = JNIISLASTNode.build(ISLNative.isl_ast_build_node_from_schedule_map(getNativePtr(this), getNativePtr(schedule)));
			} finally {
				taken(schedule);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_ast_build_node_from_schedule 
	 * 
	 * @take schedule
	 * @generated
	**/
	public JNIISLASTNode generate(JNIISLSchedule schedule) {
		/*** PROTECTED REGION ID(isl_ast_build_node_from_schedule) DISABLED START ***/
		JNIISLASTNode res;
		
		synchronized(LOCK) {
			checkParameters(schedule);
			try {
				res = JNIISLASTNode.build(ISLNative.isl_ast_build_node_from_schedule(getNativePtr(this), getNativePtr(schedule)));
			} finally {
				taken(schedule);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_ast_build_node_from_schedule_map_EX 
	 * 
	 * @take schedule
	 * @generated
	**/
	public JNIISLASTNode generateWithExpansionNodes(JNIISLUnionMap schedule, String exName) {
		/*** PROTECTED REGION ID(isl_ast_build_node_from_schedule_map_EX) DISABLED START ***/
		JNIISLASTNode res;
		
		synchronized(LOCK) {
			checkParameters(schedule);
			try {
				res = JNIISLASTNode.build(ISLNative.isl_ast_build_node_from_schedule_map_EX(getNativePtr(this), getNativePtr(schedule), exName));
			} finally {
				taken(schedule);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_ast_build_node_from_schedule_EX 
	 * 
	 * @take schedule
	 * @generated
	**/
	public JNIISLASTNode generateWithExpansionNodes(JNIISLSchedule schedule, String exName) {
		/*** PROTECTED REGION ID(isl_ast_build_node_from_schedule_EX) DISABLED START ***/
		JNIISLASTNode res;
		
		synchronized(LOCK) {
			checkParameters(schedule);
			try {
				res = JNIISLASTNode.build(ISLNative.isl_ast_build_node_from_schedule_EX(getNativePtr(this), getNativePtr(schedule), exName));
			} finally {
				taken(schedule);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	
	public String toString() {
		/*** PROTECTED REGION ID(ISLASTBuild_toString) DISABLED START ***/
			return ISLPrettyPrinter.asString(this);
		/*** PROTECTED REGION END ***/
	}
}