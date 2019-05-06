package fr.irisa.cairn.jnimap.cloog.jni;

import fr.irisa.cairn.jnimap.cloog.jni.platform.*;
import fr.irisa.cairn.jnimap.isl.jni.ISLNative;

public class CloogNative {

	private static final String arch = System.getProperty("sun.arch.data.model");

	private static JNICloogAbstractPlatform loader ;

	private static boolean loaded = false;
	public static void loadLibrary() {
		if (loaded) return;
		ISLNative.loadLibrary();
		String osName = System.getProperty("os.name");
		String arch   = System.getProperty("sun.arch.data.model");
		if (osName.equals("Linux")) {
			if (arch.equals("32")) {
				loader = new JNICloogLinux_32();
			} else {
				loader = new JNICloogLinux_64();
			}
		} else if (osName.equals("Windows XP")) {
			loader = new JNICloogCygwin_32();
		} else if (osName.equals("Mac OS X")) {
			if (arch.equals("32")) {
				loader = new JNICloogMacosx_32();
			} else {
				loader = new JNICloogMacosx_64();
			} 
		} else  {
			throw new RuntimeException("Unsupported Operating system : " + osName+"_"+arch);
		}
		loader.loadPlatformLibraries();
		loaded = true;
	}
	
	static {
		loadLibrary();
	}

	public static native long derefPointer(long ptr);
	
	
	/*************************************************************
	 *	                     USER MODULES                        *
	 *************************************************************/
	 
	 public static class UserModules {
	 	// UserModule : addons
	 	public static native long cloog_clast_from_union_map(long state, long opts, String context, String union_map_str);
	 	public static native long cloog_clast_from_set(long state, long opts, String context, String set_str);
	 	public static native long cloog_input_read_from_isl_union_map_str(long ctx, long state, String context, String union_map_str);
	 	public static native long cloog_input_read_from_isl_set_str(long ctx, long state, String context, String set_str);
	 	public static native void clast_print(long stmt, long opts);
	 	public static native long clast_reduction_get_element(long stmt, int offset);
	 	public static native int clast_reduction_get_number_of_elements(long stmt);
	 	public static native int clast_binary_get_value(long stmt);
	 	public static native int clast_term_get_value(long stmt);
	 	public static native String clast_user_stmt_get_cloog_domain(long stmt);
	 	public static native String clast_for_get_cloog_domain(long stmt);
	 	public static native int clast_for_get_stride(long stmt);
	 	public static native long clast_guard_get_equation(long stmt, int offset);
	 	public static native int clast_guard_get_n(long stmt);
	 	public static native String get_scalar(long names, int index);
	 	public static native String get_scattering(long names, int index);
	 	public static native String get_parameter(long names, int index);
	 	public static native String get_iterator(long names, int index);
	 	public static native int is_clast_guard(long stmt);
	 	public static native int is_clast_for(long stmt);
	 	public static native int is_clast_assignment(long stmt);
	 	public static native int is_clast_user_stmt(long stmt);
	 	public static native int is_clast_block(long stmt);
	 	public static native int is_clast_root(long stmt);
	 	public static native int is_clast_expr_binary(long expr);
	 	public static native int is_clast_expr_term(long expr);
	 	public static native int is_clast_expr_reduction(long expr);
	 	public static native int is_clast_expr_name(long expr);
	}
	
	/*************************************************************
	 *	                        METHODS                          *
	 *************************************************************/
	 public static native long cloog_input_read_from_isl_union_map_str(long ctx, long state, String context, String union_domain);
	 public static native long cloog_input_read_from_isl_set_str(long ctx, long state, String context, String union_domain);
	 public static native long cloog_clast_create_from_input(long input, long opts);
	 public static native long cloog_state_malloc();
	 public static native long cloog_clast_from_union_map(long state, long opts, String context, String union_map_str);
	 public static native long cloog_clast_from_set(long state, long opts, String context, String set_str);
	 public static native int is_clast_root(long stmt);
	 public static native void clast_print(long stmt, long opts);
	 public static native long cloog_options_malloc(long state);
	 public static native int is_clast_guard(long stmt);
	 public static native long clast_guard_get_equation(long stmt, int offset);
	 public static native int is_clast_for(long stmt);
	 public static native String clast_for_get_cloog_domain(long stmt);
	 public static native int clast_for_get_stride(long stmt);
	 public static native int is_clast_assignment(long stmt);
	 public static native int is_clast_user_stmt(long stmt);
	 public static native String clast_user_stmt_get_cloog_domain(long stmt);
	 public static native int is_clast_block(long stmt);
	 public static native int is_clast_expr_binary(long exp);
	 public static native int clast_binary_get_value(long stmt);
	 public static native int is_clast_expr_term(long exp);
	 public static native int clast_term_get_value(long stmt);
	 public static native int is_clast_expr_name(long exp);
	 public static native int is_clast_expr_reduction(long exp);
	 public static native long clast_reduction_get_element(long stmt, int offset);
	 public static native int clast_reduction_get_number_of_elements(long stmt);
	 public static native String get_scalar(long names, int index);
	 public static native String get_scattering(long names, int index);
	 public static native String get_parameter(long names, int index);
	 public static native String get_iterator(long names, int index);
	 
	/*************************************************************
	 *	                    CLASS MAPPING                        *
	 *************************************************************/
	 // getter for ClastName.name
	 public static native String clast_name_get_name(long ptr);
	 // tester for ClastName.name
	 public static native int clast_name_test_name(long ptr);
	 // setter for ClastName.name
	 public static native void clast_name_set_name(long ptr, String value);
	 // getter for ClastTerm.var
	 public static native long clast_term_get_var(long ptr);
	 // tester for ClastTerm.var
	 public static native int clast_term_test_var(long ptr);
	 // setter for ClastTerm.var
	 public static native void clast_term_set_var(long ptr, long value);
	 // getter for ClastReduction.type
	 public static native int clast_reduction_get_type(long ptr);
	 // tester for ClastReduction.type
	 public static native int clast_reduction_test_type(long ptr);
	 // setter for ClastReduction.type
	 public static native void clast_reduction_set_type(long ptr, int value);
	 // getter for ClastReduction.n
	 public static native int clast_reduction_get_n(long ptr);
	 // tester for ClastReduction.n
	 public static native int clast_reduction_test_n(long ptr);
	 // setter for ClastReduction.n
	 public static native void clast_reduction_set_n(long ptr, int value);
	 // getter for ClastBinary.type
	 public static native int clast_binary_get_type(long ptr);
	 // tester for ClastBinary.type
	 public static native int clast_binary_test_type(long ptr);
	 // setter for ClastBinary.type
	 public static native void clast_binary_set_type(long ptr, int value);
	 // getter for ClastBinary.LHS
	 public static native long clast_binary_get_LHS(long ptr);
	 // tester for ClastBinary.LHS
	 public static native int clast_binary_test_LHS(long ptr);
	 // setter for ClastBinary.LHS
	 public static native void clast_binary_set_LHS(long ptr, long value);
	 // getter for ClastStmt.op
	 public static native long clast_stmt_get_op(long ptr);
	 // tester for ClastStmt.op
	 public static native int clast_stmt_test_op(long ptr);
	 // setter for ClastStmt.op
	 public static native void clast_stmt_set_op(long ptr, long value);
	 // getter for ClastStmt.next
	 public static native long clast_stmt_get_next(long ptr);
	 // tester for ClastStmt.next
	 public static native int clast_stmt_test_next(long ptr);
	 // setter for ClastStmt.next
	 public static native void clast_stmt_set_next(long ptr, long value);
	 // getter for ClastAssignment.LHS
	 public static native String clast_assignment_get_LHS(long ptr);
	 // tester for ClastAssignment.LHS
	 public static native int clast_assignment_test_LHS(long ptr);
	 // setter for ClastAssignment.LHS
	 public static native void clast_assignment_set_LHS(long ptr, String value);
	 // getter for ClastAssignment.RHS
	 public static native long clast_assignment_get_RHS(long ptr);
	 // tester for ClastAssignment.RHS
	 public static native int clast_assignment_test_RHS(long ptr);
	 // setter for ClastAssignment.RHS
	 public static native void clast_assignment_set_RHS(long ptr, long value);
	 // getter for ClastRoot.names
	 public static native long clast_root_get_names(long ptr);
	 // tester for ClastRoot.names
	 public static native int clast_root_test_names(long ptr);
	 // setter for ClastRoot.names
	 public static native void clast_root_set_names(long ptr, long value);
	 // getter for ClastBlock.body
	 public static native long clast_block_get_body(long ptr);
	 // tester for ClastBlock.body
	 public static native int clast_block_test_body(long ptr);
	 // setter for ClastBlock.body
	 public static native void clast_block_set_body(long ptr, long value);
	 // getter for CloogStatement.name
	 public static native String cloogstatement_get_name(long ptr);
	 // tester for CloogStatement.name
	 public static native int cloogstatement_test_name(long ptr);
	 // setter for CloogStatement.name
	 public static native void cloogstatement_set_name(long ptr, String value);
	 // getter for CloogStatement.number
	 public static native int cloogstatement_get_number(long ptr);
	 // tester for CloogStatement.number
	 public static native int cloogstatement_test_number(long ptr);
	 // setter for CloogStatement.number
	 public static native void cloogstatement_set_number(long ptr, int value);
	 // getter for ClastUserStmt.statement
	 public static native long clast_user_stmt_get_statement(long ptr);
	 // tester for ClastUserStmt.statement
	 public static native int clast_user_stmt_test_statement(long ptr);
	 // setter for ClastUserStmt.statement
	 public static native void clast_user_stmt_set_statement(long ptr, long value);
	 // getter for ClastUserStmt.substitutions
	 public static native long clast_user_stmt_get_substitutions(long ptr);
	 // tester for ClastUserStmt.substitutions
	 public static native int clast_user_stmt_test_substitutions(long ptr);
	 // setter for ClastUserStmt.substitutions
	 public static native void clast_user_stmt_set_substitutions(long ptr, long value);
	 // getter for ClastFor.iterator
	 public static native String clast_for_get_iterator(long ptr);
	 // tester for ClastFor.iterator
	 public static native int clast_for_test_iterator(long ptr);
	 // setter for ClastFor.iterator
	 public static native void clast_for_set_iterator(long ptr, String value);
	 // getter for ClastFor.LB
	 public static native long clast_for_get_LB(long ptr);
	 // tester for ClastFor.LB
	 public static native int clast_for_test_LB(long ptr);
	 // setter for ClastFor.LB
	 public static native void clast_for_set_LB(long ptr, long value);
	 // getter for ClastFor.UB
	 public static native long clast_for_get_UB(long ptr);
	 // tester for ClastFor.UB
	 public static native int clast_for_test_UB(long ptr);
	 // setter for ClastFor.UB
	 public static native void clast_for_set_UB(long ptr, long value);
	 // getter for ClastFor.body
	 public static native long clast_for_get_body(long ptr);
	 // tester for ClastFor.body
	 public static native int clast_for_test_body(long ptr);
	 // setter for ClastFor.body
	 public static native void clast_for_set_body(long ptr, long value);
	 // getter for ClastEquation.LHS
	 public static native long clast_equation_get_LHS(long ptr);
	 // tester for ClastEquation.LHS
	 public static native int clast_equation_test_LHS(long ptr);
	 // setter for ClastEquation.LHS
	 public static native void clast_equation_set_LHS(long ptr, long value);
	 // getter for ClastEquation.RHS
	 public static native long clast_equation_get_RHS(long ptr);
	 // tester for ClastEquation.RHS
	 public static native int clast_equation_test_RHS(long ptr);
	 // setter for ClastEquation.RHS
	 public static native void clast_equation_set_RHS(long ptr, long value);
	 // getter for ClastEquation.sign
	 public static native int clast_equation_get_sign(long ptr);
	 // tester for ClastEquation.sign
	 public static native int clast_equation_test_sign(long ptr);
	 // setter for ClastEquation.sign
	 public static native void clast_equation_set_sign(long ptr, int value);
	 // getter for ClastGuard.then
	 public static native long clast_guard_get_then(long ptr);
	 // tester for ClastGuard.then
	 public static native int clast_guard_test_then(long ptr);
	 // setter for ClastGuard.then
	 public static native void clast_guard_set_then(long ptr, long value);
	 // getter for ClastGuard.n
	 public static native int clast_guard_get_n(long ptr);
	 // tester for ClastGuard.n
	 public static native int clast_guard_test_n(long ptr);
	 // setter for ClastGuard.n
	 public static native void clast_guard_set_n(long ptr, int value);
	 // getter for CloogNames.nb_scalars
	 public static native int cloognames_get_nb_scalars(long ptr);
	 // tester for CloogNames.nb_scalars
	 public static native int cloognames_test_nb_scalars(long ptr);
	 // setter for CloogNames.nb_scalars
	 public static native void cloognames_set_nb_scalars(long ptr, int value);
	 // getter for CloogNames.nb_scattering
	 public static native int cloognames_get_nb_scattering(long ptr);
	 // tester for CloogNames.nb_scattering
	 public static native int cloognames_test_nb_scattering(long ptr);
	 // setter for CloogNames.nb_scattering
	 public static native void cloognames_set_nb_scattering(long ptr, int value);
	 // getter for CloogNames.nb_iterators
	 public static native int cloognames_get_nb_iterators(long ptr);
	 // tester for CloogNames.nb_iterators
	 public static native int cloognames_test_nb_iterators(long ptr);
	 // setter for CloogNames.nb_iterators
	 public static native void cloognames_set_nb_iterators(long ptr, int value);
	 // getter for CloogNames.nb_parameters
	 public static native int cloognames_get_nb_parameters(long ptr);
	 // tester for CloogNames.nb_parameters
	 public static native int cloognames_test_nb_parameters(long ptr);
	 // setter for CloogNames.nb_parameters
	 public static native void cloognames_set_nb_parameters(long ptr, int value);
	 // getter for CloogOptions.l
	 public static native int cloogoptions_get_l(long ptr);
	 // tester for CloogOptions.l
	 public static native int cloogoptions_test_l(long ptr);
	 // setter for CloogOptions.l
	 public static native void cloogoptions_set_l(long ptr, int value);
	 // getter for CloogOptions.f
	 public static native int cloogoptions_get_f(long ptr);
	 // tester for CloogOptions.f
	 public static native int cloogoptions_test_f(long ptr);
	 // setter for CloogOptions.f
	 public static native void cloogoptions_set_f(long ptr, int value);
	 // getter for CloogOptions.stop
	 public static native int cloogoptions_get_stop(long ptr);
	 // tester for CloogOptions.stop
	 public static native int cloogoptions_test_stop(long ptr);
	 // setter for CloogOptions.stop
	 public static native void cloogoptions_set_stop(long ptr, int value);
	 // getter for CloogOptions.strides
	 public static native int cloogoptions_get_strides(long ptr);
	 // tester for CloogOptions.strides
	 public static native int cloogoptions_test_strides(long ptr);
	 // setter for CloogOptions.strides
	 public static native void cloogoptions_set_strides(long ptr, int value);
	 // getter for CloogOptions.sh
	 public static native int cloogoptions_get_sh(long ptr);
	 // tester for CloogOptions.sh
	 public static native int cloogoptions_test_sh(long ptr);
	 // setter for CloogOptions.sh
	 public static native void cloogoptions_set_sh(long ptr, int value);
	 // getter for CloogOptions.esp
	 public static native int cloogoptions_get_esp(long ptr);
	 // tester for CloogOptions.esp
	 public static native int cloogoptions_test_esp(long ptr);
	 // setter for CloogOptions.esp
	 public static native void cloogoptions_set_esp(long ptr, int value);
	 // getter for CloogOptions.fsp
	 public static native int cloogoptions_get_fsp(long ptr);
	 // tester for CloogOptions.fsp
	 public static native int cloogoptions_test_fsp(long ptr);
	 // setter for CloogOptions.fsp
	 public static native void cloogoptions_set_fsp(long ptr, int value);
	 // getter for CloogOptions.otl
	 public static native int cloogoptions_get_otl(long ptr);
	 // tester for CloogOptions.otl
	 public static native int cloogoptions_test_otl(long ptr);
	 // setter for CloogOptions.otl
	 public static native void cloogoptions_set_otl(long ptr, int value);
	 // getter for CloogOptions.block
	 public static native int cloogoptions_get_block(long ptr);
	 // tester for CloogOptions.block
	 public static native int cloogoptions_test_block(long ptr);
	 // setter for CloogOptions.block
	 public static native void cloogoptions_set_block(long ptr, int value);
	 // getter for CloogOptions.compilable
	 public static native int cloogoptions_get_compilable(long ptr);
	 // tester for CloogOptions.compilable
	 public static native int cloogoptions_test_compilable(long ptr);
	 // setter for CloogOptions.compilable
	 public static native void cloogoptions_set_compilable(long ptr, int value);
	 // getter for CloogOptions.callable
	 public static native int cloogoptions_get_callable(long ptr);
	 // tester for CloogOptions.callable
	 public static native int cloogoptions_test_callable(long ptr);
	 // setter for CloogOptions.callable
	 public static native void cloogoptions_set_callable(long ptr, int value);
	 // getter for CloogOptions.language
	 public static native int cloogoptions_get_language(long ptr);
	 // tester for CloogOptions.language
	 public static native int cloogoptions_test_language(long ptr);
	 // setter for CloogOptions.language
	 public static native void cloogoptions_set_language(long ptr, int value);
	 // getter for CloogOptions.save_domains
	 public static native int cloogoptions_get_save_domains(long ptr);
	 // tester for CloogOptions.save_domains
	 public static native int cloogoptions_test_save_domains(long ptr);
	 // setter for CloogOptions.save_domains
	 public static native void cloogoptions_set_save_domains(long ptr, int value);
	 // getter for CloogOptions.quiet
	 public static native int cloogoptions_get_quiet(long ptr);
	 // tester for CloogOptions.quiet
	 public static native int cloogoptions_test_quiet(long ptr);
	 // setter for CloogOptions.quiet
	 public static native void cloogoptions_set_quiet(long ptr, int value);
	 // getter for CloogOptions.leaks
	 public static native int cloogoptions_get_leaks(long ptr);
	 // tester for CloogOptions.leaks
	 public static native int cloogoptions_test_leaks(long ptr);
	 // setter for CloogOptions.leaks
	 public static native void cloogoptions_set_leaks(long ptr, int value);
	 // getter for CloogOptions.backtrack
	 public static native int cloogoptions_get_backtrack(long ptr);
	 // tester for CloogOptions.backtrack
	 public static native int cloogoptions_test_backtrack(long ptr);
	 // setter for CloogOptions.backtrack
	 public static native void cloogoptions_set_backtrack(long ptr, int value);
	 // getter for CloogOptions.override
	 public static native int cloogoptions_get_override(long ptr);
	 // tester for CloogOptions.override
	 public static native int cloogoptions_test_override(long ptr);
	 // setter for CloogOptions.override
	 public static native void cloogoptions_set_override(long ptr, int value);
	 // getter for CloogOptions.structure
	 public static native int cloogoptions_get_structure(long ptr);
	 // tester for CloogOptions.structure
	 public static native int cloogoptions_test_structure(long ptr);
	 // setter for CloogOptions.structure
	 public static native void cloogoptions_set_structure(long ptr, int value);
	 // getter for CloogOptions.noblocks
	 public static native int cloogoptions_get_noblocks(long ptr);
	 // tester for CloogOptions.noblocks
	 public static native int cloogoptions_test_noblocks(long ptr);
	 // setter for CloogOptions.noblocks
	 public static native void cloogoptions_set_noblocks(long ptr, int value);
	 // getter for CloogOptions.noscalars
	 public static native int cloogoptions_get_noscalars(long ptr);
	 // tester for CloogOptions.noscalars
	 public static native int cloogoptions_test_noscalars(long ptr);
	 // setter for CloogOptions.noscalars
	 public static native void cloogoptions_set_noscalars(long ptr, int value);
	 // getter for CloogOptions.nosimplify
	 public static native int cloogoptions_get_nosimplify(long ptr);
	 // tester for CloogOptions.nosimplify
	 public static native int cloogoptions_test_nosimplify(long ptr);
	 // setter for CloogOptions.nosimplify
	 public static native void cloogoptions_set_nosimplify(long ptr, int value);
	


}
