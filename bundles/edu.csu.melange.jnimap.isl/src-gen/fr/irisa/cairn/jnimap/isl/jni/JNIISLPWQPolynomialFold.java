package fr.irisa.cairn.jnimap.isl.jni;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.irisa.cairn.jnimap.runtime.JNIObject;


/*** PROTECTED REGION ID(ISLPWQPolynomialFold_userImport) ENABLED START ***/
/*** PROTECTED REGION END ***/

/**
 *  Automatically generated by jnimap 
 * @generated
 */
public class JNIISLPWQPolynomialFold extends JNIObject {
	
	/* @generated */
	protected JNIISLPWQPolynomialFold(long ptr) {
		/*** PROTECTED REGION ID(ISLPWQPolynomialFold_Constructor) DISABLED START ***/
		super(ptr);
		/*** PROTECTED REGION END ***/
	}
	
	/* @generated */
	protected static JNIISLPWQPolynomialFold build(long ptr) {
		return new JNIISLPWQPolynomialFold(ptr);
	}
	
	/*** PROTECTED REGION ID(ISLPWQPolynomialFold_userCode) ENABLED START ***/
	public List<JNIISLQPolynomialFoldPiece> getPieces() {
		int n = this.getNbPieces();
		List<JNIISLQPolynomialFoldPiece> res = new ArrayList<JNIISLQPolynomialFoldPiece>(
				n);
		for (int i = 0; i < n; i++) {
			res.add(this.getPieceAt(i));
		}
		return res;
	}

	public List<JNIISLQPolynomialFoldPiece> getLiftedPieces() {
		int n = this.getNbLiftedPieces();
		List<JNIISLQPolynomialFoldPiece> res = new ArrayList<JNIISLQPolynomialFoldPiece>(
				n);
		for (int i = 0; i < n; i++) {
			res.add(this.getLiftedPieceAt(i));
		}
		return res;
	}
	/*** PROTECTED REGION END ***/


	
	/*************************************** 
	 *	         Static Methods            * 
	 ***************************************/
	/**
	 * isl_pw_qpolynomial_fold_zero 
	 * 
	@take dim
	 * @generated
	**/
	 public static JNIISLPWQPolynomialFold buildZero(JNIISLSpace dim, JNIISLFold type) { 
		/*** PROTECTED REGION ID(static_isl_pw_qpolynomial_fold_zero) DISABLED START ***/
		JNIISLPWQPolynomialFold res;
		
		synchronized(LOCK) {
			checkParameters(dim);
			try {
				res = JNIISLPWQPolynomialFold.build(ISLNative.isl_pw_qpolynomial_fold_zero(getNativePtr(dim), type.getValue()));
			} finally {
				taken(dim);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_to_string 
	 * 
	 * @generated
	**/
	 public static String _toString(JNIISLPWQPolynomialFold pwqpf, int format) { 
		/*** PROTECTED REGION ID(static_isl_pw_qpolynomial_fold_to_string) DISABLED START ***/
		String res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = ISLNative.isl_pw_qpolynomial_fold_to_string(getNativePtr(pwqpf), format);
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
	 * isl_pw_qpolynomial_fold_get_ctx 
	 * 
	 * @generated
	**/
	public JNIISLContext getContext() {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_get_ctx) DISABLED START ***/
		JNIISLContext res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLContext.build(ISLNative.isl_pw_qpolynomial_fold_get_ctx(getNativePtr(this)));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_get_space 
	 * 
	 * @generated
	**/
	public JNIISLSpace getSpace() {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_get_space) DISABLED START ***/
		JNIISLSpace res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLSpace.build(ISLNative.isl_pw_qpolynomial_fold_get_space(getNativePtr(this)));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_get_domain_space 
	 * 
	 * @generated
	**/
	public JNIISLSpace getDomainSpace() {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_get_domain_space) DISABLED START ***/
		JNIISLSpace res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLSpace.build(ISLNative.isl_pw_qpolynomial_fold_get_domain_space(getNativePtr(this)));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_copy 
	 * 
	 * @generated
	**/
	public JNIISLPWQPolynomialFold copy() {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_copy) DISABLED START ***/
		JNIISLPWQPolynomialFold res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLPWQPolynomialFold.build(ISLNative.isl_pw_qpolynomial_fold_copy(getNativePtr(this)));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_free 
	 * 
	 * @take this
	 * @generated
	**/
	public void free() {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_free) DISABLED START ***/
		
		synchronized(LOCK) {
			checkParameters(this);
			try {
				ISLNative.isl_pw_qpolynomial_fold_free(getNativePtr(this));
			} finally {
				taken(this);
			}
		}
		
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_plain_is_equal 
	 * 
	 * @generated
	**/
	public boolean isPlainEqual(JNIISLPWQPolynomialFold pwf2) {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_plain_is_equal) DISABLED START ***/
		boolean res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = ISLNative.isl_pw_qpolynomial_fold_plain_is_equal(getNativePtr(this), getNativePtr(pwf2)) != 0;
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_is_zero 
	 * 
	 * @generated
	**/
	public boolean isZero() {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_is_zero) DISABLED START ***/
		boolean res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = ISLNative.isl_pw_qpolynomial_fold_is_zero(getNativePtr(this)) != 0;
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_reset_space 
	 * 
	 * @take this dim
	 * @generated
	**/
	public JNIISLPWQPolynomialFold resetSpace(JNIISLSpace dim) {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_reset_space) DISABLED START ***/
		JNIISLPWQPolynomialFold res;
		
		synchronized(LOCK) {
			checkParameters(this, dim);
			try {
				res = JNIISLPWQPolynomialFold.build(ISLNative.isl_pw_qpolynomial_fold_reset_space(getNativePtr(this), getNativePtr(dim)));
			} finally {
				taken(this);
				taken(dim);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_dim 
	 * 
	 * @generated
	**/
	public int getNbDims(JNIISLDimType type) {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_dim) DISABLED START ***/
		int res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = ISLNative.isl_pw_qpolynomial_fold_dim(getNativePtr(this), type.getValue());
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_has_equal_space 
	 * 
	 * @generated
	**/
	public boolean hasEqualSpace(JNIISLPWQPolynomialFold pwf2) {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_has_equal_space) DISABLED START ***/
		boolean res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = ISLNative.isl_pw_qpolynomial_fold_has_equal_space(getNativePtr(this), getNativePtr(pwf2)) != 0;
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_set_dim_name 
	 * 
	 * @take this
	 * @generated
	**/
	public JNIISLPWQPolynomialFold setDimName(JNIISLDimType type, int pos, String s) {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_set_dim_name) DISABLED START ***/
		JNIISLPWQPolynomialFold res;
		
		synchronized(LOCK) {
			checkParameters(this);
			try {
				res = JNIISLPWQPolynomialFold.build(ISLNative.isl_pw_qpolynomial_fold_set_dim_name(getNativePtr(this), type.getValue(), pos, s));
			} finally {
				taken(this);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_domain 
	 * 
	 * @take this
	 * @generated
	**/
	public JNIISLSet domain() {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_domain) DISABLED START ***/
		JNIISLSet res;
		
		synchronized(LOCK) {
			checkParameters(this);
			try {
				res = JNIISLSet.build(ISLNative.isl_pw_qpolynomial_fold_domain(getNativePtr(this)));
			} finally {
				taken(this);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_intersect_domain 
	 * 
	 * @take this set
	 * @generated
	**/
	public JNIISLPWQPolynomialFold intersectDomain(JNIISLSet set) {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_intersect_domain) DISABLED START ***/
		JNIISLPWQPolynomialFold res;
		
		synchronized(LOCK) {
			checkParameters(this, set);
			try {
				res = JNIISLPWQPolynomialFold.build(ISLNative.isl_pw_qpolynomial_fold_intersect_domain(getNativePtr(this), getNativePtr(set)));
			} finally {
				taken(this);
				taken(set);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_intersect_params 
	 * 
	 * @take this set
	 * @generated
	**/
	public JNIISLPWQPolynomialFold intersectParams(JNIISLSet set) {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_intersect_params) DISABLED START ***/
		JNIISLPWQPolynomialFold res;
		
		synchronized(LOCK) {
			checkParameters(this, set);
			try {
				res = JNIISLPWQPolynomialFold.build(ISLNative.isl_pw_qpolynomial_fold_intersect_params(getNativePtr(this), getNativePtr(set)));
			} finally {
				taken(this);
				taken(set);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_add 
	 * 
	 * @take this pwf2
	 * @generated
	**/
	public JNIISLPWQPolynomialFold add(JNIISLPWQPolynomialFold pwf2) {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_add) DISABLED START ***/
		JNIISLPWQPolynomialFold res;
		
		synchronized(LOCK) {
			checkParameters(this, pwf2);
			try {
				res = JNIISLPWQPolynomialFold.build(ISLNative.isl_pw_qpolynomial_fold_add(getNativePtr(this), getNativePtr(pwf2)));
			} finally {
				taken(this);
				taken(pwf2);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_fold 
	 * 
	 * @take this pwf2
	 * @generated
	**/
	public JNIISLPWQPolynomialFold fold(JNIISLPWQPolynomialFold pwf2) {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_fold) DISABLED START ***/
		JNIISLPWQPolynomialFold res;
		
		synchronized(LOCK) {
			checkParameters(this, pwf2);
			try {
				res = JNIISLPWQPolynomialFold.build(ISLNative.isl_pw_qpolynomial_fold_fold(getNativePtr(this), getNativePtr(pwf2)));
			} finally {
				taken(this);
				taken(pwf2);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_add_disjoint 
	 * 
	 * @take this pwf2
	 * @generated
	**/
	public JNIISLPWQPolynomialFold addDisjoint(JNIISLPWQPolynomialFold pwf2) {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_add_disjoint) DISABLED START ***/
		JNIISLPWQPolynomialFold res;
		
		synchronized(LOCK) {
			checkParameters(this, pwf2);
			try {
				res = JNIISLPWQPolynomialFold.build(ISLNative.isl_pw_qpolynomial_fold_add_disjoint(getNativePtr(this), getNativePtr(pwf2)));
			} finally {
				taken(this);
				taken(pwf2);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_scale_val 
	 * 
	 * @take this v
	 * @generated
	**/
	public JNIISLPWQPolynomialFold scale(JNIISLVal v) {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_scale_val) DISABLED START ***/
		JNIISLPWQPolynomialFold res;
		
		synchronized(LOCK) {
			checkParameters(this, v);
			try {
				res = JNIISLPWQPolynomialFold.build(ISLNative.isl_pw_qpolynomial_fold_scale_val(getNativePtr(this), getNativePtr(v)));
			} finally {
				taken(this);
				taken(v);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_project_domain_on_params 
	 * 
	 * @take this
	 * @generated
	**/
	public JNIISLPWQPolynomialFold projectDomainOnParams() {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_project_domain_on_params) DISABLED START ***/
		JNIISLPWQPolynomialFold res;
		
		synchronized(LOCK) {
			checkParameters(this);
			try {
				res = JNIISLPWQPolynomialFold.build(ISLNative.isl_pw_qpolynomial_fold_project_domain_on_params(getNativePtr(this)));
			} finally {
				taken(this);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_drop_dims 
	 * 
	 * @take this
	 * @generated
	**/
	public JNIISLPWQPolynomialFold dropDims(JNIISLDimType type, int first, int n) {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_drop_dims) DISABLED START ***/
		JNIISLPWQPolynomialFold res;
		
		synchronized(LOCK) {
			checkParameters(this);
			try {
				res = JNIISLPWQPolynomialFold.build(ISLNative.isl_pw_qpolynomial_fold_drop_dims(getNativePtr(this), type.getValue(), first, n));
			} finally {
				taken(this);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_move_dims 
	 * 
	 * @take this
	 * @generated
	**/
	public JNIISLPWQPolynomialFold moveDims(JNIISLDimType dst_type, int dst_pos, JNIISLDimType src_type, int src_pos, int n) {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_move_dims) DISABLED START ***/
		JNIISLPWQPolynomialFold res;
		
		synchronized(LOCK) {
			checkParameters(this);
			try {
				res = JNIISLPWQPolynomialFold.build(ISLNative.isl_pw_qpolynomial_fold_move_dims(getNativePtr(this), dst_type.getValue(), dst_pos, src_type.getValue(), src_pos, n));
			} finally {
				taken(this);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_coalesce 
	 * 
	 * @take this
	 * @generated
	**/
	public JNIISLPWQPolynomialFold coalesce() {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_coalesce) DISABLED START ***/
		JNIISLPWQPolynomialFold res;
		
		synchronized(LOCK) {
			checkParameters(this);
			try {
				res = JNIISLPWQPolynomialFold.build(ISLNative.isl_pw_qpolynomial_fold_coalesce(getNativePtr(this)));
			} finally {
				taken(this);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_gist 
	 * 
	 * @take this context
	 * @generated
	**/
	public JNIISLPWQPolynomialFold gist(JNIISLSet context) {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_gist) DISABLED START ***/
		JNIISLPWQPolynomialFold res;
		
		synchronized(LOCK) {
			checkParameters(this, context);
			try {
				res = JNIISLPWQPolynomialFold.build(ISLNative.isl_pw_qpolynomial_fold_gist(getNativePtr(this), getNativePtr(context)));
			} finally {
				taken(this);
				taken(context);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_gist_params 
	 * 
	 * @take this context
	 * @generated
	**/
	public JNIISLPWQPolynomialFold gistParams(JNIISLSet context) {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_gist_params) DISABLED START ***/
		JNIISLPWQPolynomialFold res;
		
		synchronized(LOCK) {
			checkParameters(this, context);
			try {
				res = JNIISLPWQPolynomialFold.build(ISLNative.isl_pw_qpolynomial_fold_gist_params(getNativePtr(this), getNativePtr(context)));
			} finally {
				taken(this);
				taken(context);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_numberof_piece 
	 * 
	 * @generated
	**/
	public int getNbPieces() {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_numberof_piece) DISABLED START ***/
		int res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = ISLNative.isl_pw_qpolynomial_fold_numberof_piece(getNativePtr(this));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_get_piece_at 
	 * 
	 * @generated
	**/
	public JNIISLQPolynomialFoldPiece getPieceAt(int pos) {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_get_piece_at) DISABLED START ***/
		JNIISLQPolynomialFoldPiece res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLQPolynomialFoldPiece.build(ISLNative.isl_pw_qpolynomial_fold_get_piece_at(getNativePtr(this), pos));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_numberof_lifted_piece 
	 * 
	 * @generated
	**/
	public int getNbLiftedPieces() {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_numberof_lifted_piece) DISABLED START ***/
		int res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = ISLNative.isl_pw_qpolynomial_fold_numberof_lifted_piece(getNativePtr(this));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_pw_qpolynomial_fold_get_lifted_piece_at 
	 * 
	 * @generated
	**/
	public JNIISLQPolynomialFoldPiece getLiftedPieceAt(int pos) {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_fold_get_lifted_piece_at) DISABLED START ***/
		JNIISLQPolynomialFoldPiece res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLQPolynomialFoldPiece.build(ISLNative.isl_pw_qpolynomial_fold_get_lifted_piece_at(getNativePtr(this), pos));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	
	public String toString() {
		/*** PROTECTED REGION ID(ISLPWQPolynomialFold_toString) DISABLED START ***/
			return ISLPrettyPrinter.asString(this);
		/*** PROTECTED REGION END ***/
	}
}
