package fr.irisa.cairn.jnimap.isl.jni;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.irisa.cairn.jnimap.runtime.JNIObject;


/*** PROTECTED REGION ID(ISLQPolynomial_userImport) ENABLED START ***/
/*** PROTECTED REGION END ***/

/**
 *  Automatically generated by jnimap 
 * @generated
 */
public class JNIISLQPolynomial extends JNIObject {
	
	/* @generated */
	protected JNIISLQPolynomial(long ptr) {
		/*** PROTECTED REGION ID(ISLQPolynomial_Constructor) DISABLED START ***/
		super(ptr);
		/*** PROTECTED REGION END ***/
	}
	
	/* @generated */
	protected static JNIISLQPolynomial build(long ptr) {
		return new JNIISLQPolynomial(ptr);
	}
	
	/*** PROTECTED REGION ID(ISLQPolynomial_userCode) ENABLED START ***/
	public static JNIISLQPolynomial buildRationalValue(JNIISLSpace dim, int n, int d) {
		JNIISLVal val = JNIISLVal.buildRationalValue(dim.getContext(), n, d);
		return buildFromVal(dim, val);
	}
	
	public boolean isConstant() {
		if (this.isZero() || this.isInfinity() || this.isNaN() || this.isNegInfinity())
			return true;
		
		// if the QPolynomial is zero, there is 0 terms
		if (this.getNbTerms() > 0 && this.getConstantVal().isZero())
			return false;
		
		if (this.getNbTerms() == 1 && !this.getConstantVal().isZero())
			return true;
		
		// there is only one constant term, so if the number of terms is greater
		// than one, there is at least 1 non-constant term
		if (this.getNbTerms() > 1)
			return false;

		throw new RuntimeException("Reached inconsistent state.");
	}

	public List<JNIISLTerm> getTerms() {
		ArrayList<JNIISLTerm> terms = new ArrayList<JNIISLTerm>();
		for (int i = 0; i < getNbTerms(); i++) {
			terms.add(getTermAt(i));
		}
		return terms;
	}
	
	public JNIISLQPolynomial scale(long v) {
		return scale(JNIISLVal.buildFromLong(getContext(), v));
	}
	/*** PROTECTED REGION END ***/


	
	/*************************************** 
	 *	         Static Methods            * 
	 ***************************************/
	/**
	 * isl_qpolynomial_zero_on_domain 
	 * 
	@take dim
	 * @generated
	**/
	 public static JNIISLQPolynomial buildZero(JNIISLSpace dim) { 
		/*** PROTECTED REGION ID(static_isl_qpolynomial_zero_on_domain) DISABLED START ***/
		JNIISLQPolynomial res;
		
		synchronized(LOCK) {
			checkParameters(dim);
			try {
				res = JNIISLQPolynomial.build(ISLNative.isl_qpolynomial_zero_on_domain(getNativePtr(dim)));
			} finally {
				taken(dim);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_one_on_domain 
	 * 
	@take dim
	 * @generated
	**/
	 public static JNIISLQPolynomial buildOne(JNIISLSpace dim) { 
		/*** PROTECTED REGION ID(static_isl_qpolynomial_one_on_domain) DISABLED START ***/
		JNIISLQPolynomial res;
		
		synchronized(LOCK) {
			checkParameters(dim);
			try {
				res = JNIISLQPolynomial.build(ISLNative.isl_qpolynomial_one_on_domain(getNativePtr(dim)));
			} finally {
				taken(dim);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_infty_on_domain 
	 * 
	@take dim
	 * @generated
	**/
	 public static JNIISLQPolynomial buildInfinity(JNIISLSpace dim) { 
		/*** PROTECTED REGION ID(static_isl_qpolynomial_infty_on_domain) DISABLED START ***/
		JNIISLQPolynomial res;
		
		synchronized(LOCK) {
			checkParameters(dim);
			try {
				res = JNIISLQPolynomial.build(ISLNative.isl_qpolynomial_infty_on_domain(getNativePtr(dim)));
			} finally {
				taken(dim);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_neginfty_on_domain 
	 * 
	@take dim
	 * @generated
	**/
	 public static JNIISLQPolynomial buildNegInfinity(JNIISLSpace dim) { 
		/*** PROTECTED REGION ID(static_isl_qpolynomial_neginfty_on_domain) DISABLED START ***/
		JNIISLQPolynomial res;
		
		synchronized(LOCK) {
			checkParameters(dim);
			try {
				res = JNIISLQPolynomial.build(ISLNative.isl_qpolynomial_neginfty_on_domain(getNativePtr(dim)));
			} finally {
				taken(dim);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_nan_on_domain 
	 * 
	@take dim
	 * @generated
	**/
	 public static JNIISLQPolynomial buildNaN(JNIISLSpace dim) { 
		/*** PROTECTED REGION ID(static_isl_qpolynomial_nan_on_domain) DISABLED START ***/
		JNIISLQPolynomial res;
		
		synchronized(LOCK) {
			checkParameters(dim);
			try {
				res = JNIISLQPolynomial.build(ISLNative.isl_qpolynomial_nan_on_domain(getNativePtr(dim)));
			} finally {
				taken(dim);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_val_on_domain 
	 * 
	@take dim val
	 * @generated
	**/
	 public static JNIISLQPolynomial buildFromVal(JNIISLSpace dim, JNIISLVal val) { 
		/*** PROTECTED REGION ID(static_isl_qpolynomial_val_on_domain) DISABLED START ***/
		JNIISLQPolynomial res;
		
		synchronized(LOCK) {
			checkParameters(dim, val);
			try {
				res = JNIISLQPolynomial.build(ISLNative.isl_qpolynomial_val_on_domain(getNativePtr(dim), getNativePtr(val)));
			} finally {
				taken(dim);
				taken(val);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_from_aff 
	 * 
	@take aff
	 * @generated
	**/
	 public static JNIISLQPolynomial buildFromAff(JNIISLAff aff) { 
		/*** PROTECTED REGION ID(static_isl_qpolynomial_from_aff) DISABLED START ***/
		JNIISLQPolynomial res;
		
		synchronized(LOCK) {
			checkParameters(aff);
			try {
				res = JNIISLQPolynomial.build(ISLNative.isl_qpolynomial_from_aff(getNativePtr(aff)));
			} finally {
				taken(aff);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_var_on_domain 
	 * 
	@take dim
	 * @generated
	**/
	 public static JNIISLQPolynomial buildFromVar(JNIISLSpace dim, JNIISLDimType type, int pos) { 
		/*** PROTECTED REGION ID(static_isl_qpolynomial_var_on_domain) DISABLED START ***/
		JNIISLQPolynomial res;
		
		synchronized(LOCK) {
			checkParameters(dim);
			try {
				res = JNIISLQPolynomial.build(ISLNative.isl_qpolynomial_var_on_domain(getNativePtr(dim), type.getValue(), pos));
			} finally {
				taken(dim);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_to_string 
	 * 
	 * @generated
	**/
	 public static String _toString(JNIISLQPolynomial qp, int format) { 
		/*** PROTECTED REGION ID(static_isl_qpolynomial_to_string) DISABLED START ***/
		String res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = ISLNative.isl_qpolynomial_to_string(getNativePtr(qp), format);
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
	 * isl_pw_qpolynomial_from_qpolynomial 
	 * 
	 * @take this
	 * @generated
	**/
	public JNIISLPWQPolynomial toPWQPolynomial() {
		/*** PROTECTED REGION ID(isl_pw_qpolynomial_from_qpolynomial) DISABLED START ***/
		JNIISLPWQPolynomial res;
		
		synchronized(LOCK) {
			checkParameters(this);
			try {
				res = JNIISLPWQPolynomial.build(ISLNative.isl_pw_qpolynomial_from_qpolynomial(getNativePtr(this)));
			} finally {
				taken(this);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_fold_alloc 
	 * 
	 * @take this
	 * @generated
	**/
	public JNIISLQPolynomialFold toQPolynomialFold(JNIISLFold type) {
		/*** PROTECTED REGION ID(isl_qpolynomial_fold_alloc) DISABLED START ***/
		JNIISLQPolynomialFold res;
		
		synchronized(LOCK) {
			checkParameters(this);
			try {
				res = JNIISLQPolynomialFold.build(ISLNative.isl_qpolynomial_fold_alloc(type.getValue(), getNativePtr(this)));
			} finally {
				taken(this);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_get_ctx 
	 * 
	 * @generated
	**/
	public JNIISLContext getContext() {
		/*** PROTECTED REGION ID(isl_qpolynomial_get_ctx) DISABLED START ***/
		JNIISLContext res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLContext.build(ISLNative.isl_qpolynomial_get_ctx(getNativePtr(this)));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_get_space 
	 * 
	 * @generated
	**/
	public JNIISLSpace getSpace() {
		/*** PROTECTED REGION ID(isl_qpolynomial_get_space) DISABLED START ***/
		JNIISLSpace res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLSpace.build(ISLNative.isl_qpolynomial_get_space(getNativePtr(this)));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_get_domain_space 
	 * 
	 * @generated
	**/
	public JNIISLSpace getDomainSpace() {
		/*** PROTECTED REGION ID(isl_qpolynomial_get_domain_space) DISABLED START ***/
		JNIISLSpace res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLSpace.build(ISLNative.isl_qpolynomial_get_domain_space(getNativePtr(this)));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_copy 
	 * 
	 * @generated
	**/
	public JNIISLQPolynomial copy() {
		/*** PROTECTED REGION ID(isl_qpolynomial_copy) DISABLED START ***/
		JNIISLQPolynomial res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLQPolynomial.build(ISLNative.isl_qpolynomial_copy(getNativePtr(this)));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_free 
	 * 
	 * @take this
	 * @generated
	**/
	public void free() {
		/*** PROTECTED REGION ID(isl_qpolynomial_free) DISABLED START ***/
		
		synchronized(LOCK) {
			checkParameters(this);
			try {
				ISLNative.isl_qpolynomial_free(getNativePtr(this));
			} finally {
				taken(this);
			}
		}
		
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_dim 
	 * 
	 * @generated
	**/
	public int getNbDims(JNIISLDimType type) {
		/*** PROTECTED REGION ID(isl_qpolynomial_dim) DISABLED START ***/
		int res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = ISLNative.isl_qpolynomial_dim(getNativePtr(this), type.getValue());
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_involves_dims 
	 * 
	 * @generated
	**/
	public boolean involvesDims(JNIISLDimType type, int first, int n) {
		/*** PROTECTED REGION ID(isl_qpolynomial_involves_dims) DISABLED START ***/
		boolean res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = ISLNative.isl_qpolynomial_involves_dims(getNativePtr(this), type.getValue(), first, n) != 0;
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_get_constant_val 
	 * 
	 * @generated
	**/
	public JNIISLVal getConstantVal() {
		/*** PROTECTED REGION ID(isl_qpolynomial_get_constant_val) DISABLED START ***/
		JNIISLVal res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLVal.build(ISLNative.isl_qpolynomial_get_constant_val(getNativePtr(this)));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_set_dim_name 
	 * 
	 * @take this
	 * @generated
	**/
	public JNIISLQPolynomial setDimName(JNIISLDimType type, int pos, String s) {
		/*** PROTECTED REGION ID(isl_qpolynomial_set_dim_name) DISABLED START ***/
		JNIISLQPolynomial res;
		
		synchronized(LOCK) {
			checkParameters(this);
			try {
				res = JNIISLQPolynomial.build(ISLNative.isl_qpolynomial_set_dim_name(getNativePtr(this), type.getValue(), pos, s));
			} finally {
				taken(this);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_plain_is_equal 
	 * 
	 * @generated
	**/
	public boolean isPlainEqual(JNIISLQPolynomial qp2) {
		/*** PROTECTED REGION ID(isl_qpolynomial_plain_is_equal) DISABLED START ***/
		boolean res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = ISLNative.isl_qpolynomial_plain_is_equal(getNativePtr(this), getNativePtr(qp2)) != 0;
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_is_zero 
	 * 
	 * @generated
	**/
	public boolean isZero() {
		/*** PROTECTED REGION ID(isl_qpolynomial_is_zero) DISABLED START ***/
		boolean res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = ISLNative.isl_qpolynomial_is_zero(getNativePtr(this)) != 0;
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_is_nan 
	 * 
	 * @generated
	**/
	public boolean isNaN() {
		/*** PROTECTED REGION ID(isl_qpolynomial_is_nan) DISABLED START ***/
		boolean res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = ISLNative.isl_qpolynomial_is_nan(getNativePtr(this)) != 0;
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_is_infty 
	 * 
	 * @generated
	**/
	public boolean isInfinity() {
		/*** PROTECTED REGION ID(isl_qpolynomial_is_infty) DISABLED START ***/
		boolean res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = ISLNative.isl_qpolynomial_is_infty(getNativePtr(this)) != 0;
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_is_neginfty 
	 * 
	 * @generated
	**/
	public boolean isNegInfinity() {
		/*** PROTECTED REGION ID(isl_qpolynomial_is_neginfty) DISABLED START ***/
		boolean res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = ISLNative.isl_qpolynomial_is_neginfty(getNativePtr(this)) != 0;
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_sgn 
	 * 
	 * @generated
	**/
	public int getSign() {
		/*** PROTECTED REGION ID(isl_qpolynomial_sgn) DISABLED START ***/
		int res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = ISLNative.isl_qpolynomial_sgn(getNativePtr(this));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_neg 
	 * 
	 * @take this
	 * @generated
	**/
	public JNIISLQPolynomial neg() {
		/*** PROTECTED REGION ID(isl_qpolynomial_neg) DISABLED START ***/
		JNIISLQPolynomial res;
		
		synchronized(LOCK) {
			checkParameters(this);
			try {
				res = JNIISLQPolynomial.build(ISLNative.isl_qpolynomial_neg(getNativePtr(this)));
			} finally {
				taken(this);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_add 
	 * 
	 * @take this qp2
	 * @generated
	**/
	public JNIISLQPolynomial add(JNIISLQPolynomial qp2) {
		/*** PROTECTED REGION ID(isl_qpolynomial_add) DISABLED START ***/
		JNIISLQPolynomial res;
		
		synchronized(LOCK) {
			checkParameters(this, qp2);
			try {
				res = JNIISLQPolynomial.build(ISLNative.isl_qpolynomial_add(getNativePtr(this), getNativePtr(qp2)));
			} finally {
				taken(this);
				taken(qp2);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_sub 
	 * 
	 * @take this qp2
	 * @generated
	**/
	public JNIISLQPolynomial sub(JNIISLQPolynomial qp2) {
		/*** PROTECTED REGION ID(isl_qpolynomial_sub) DISABLED START ***/
		JNIISLQPolynomial res;
		
		synchronized(LOCK) {
			checkParameters(this, qp2);
			try {
				res = JNIISLQPolynomial.build(ISLNative.isl_qpolynomial_sub(getNativePtr(this), getNativePtr(qp2)));
			} finally {
				taken(this);
				taken(qp2);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_mul 
	 * 
	 * @take this qp2
	 * @generated
	**/
	public JNIISLQPolynomial mul(JNIISLQPolynomial qp2) {
		/*** PROTECTED REGION ID(isl_qpolynomial_mul) DISABLED START ***/
		JNIISLQPolynomial res;
		
		synchronized(LOCK) {
			checkParameters(this, qp2);
			try {
				res = JNIISLQPolynomial.build(ISLNative.isl_qpolynomial_mul(getNativePtr(this), getNativePtr(qp2)));
			} finally {
				taken(this);
				taken(qp2);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_pow 
	 * 
	 * @take this
	 * @generated
	**/
	public JNIISLQPolynomial pow(int power) {
		/*** PROTECTED REGION ID(isl_qpolynomial_pow) DISABLED START ***/
		JNIISLQPolynomial res;
		
		synchronized(LOCK) {
			checkParameters(this);
			try {
				res = JNIISLQPolynomial.build(ISLNative.isl_qpolynomial_pow(getNativePtr(this), power));
			} finally {
				taken(this);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_scale_val 
	 * 
	 * @take this v
	 * @generated
	**/
	public JNIISLQPolynomial scale(JNIISLVal v) {
		/*** PROTECTED REGION ID(isl_qpolynomial_scale_val) DISABLED START ***/
		JNIISLQPolynomial res;
		
		synchronized(LOCK) {
			checkParameters(this, v);
			try {
				res = JNIISLQPolynomial.build(ISLNative.isl_qpolynomial_scale_val(getNativePtr(this), getNativePtr(v)));
			} finally {
				taken(this);
				taken(v);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_insert_dims 
	 * 
	 * @take this
	 * @generated
	**/
	public JNIISLQPolynomial insertDims(JNIISLDimType type, int first, int n) {
		/*** PROTECTED REGION ID(isl_qpolynomial_insert_dims) DISABLED START ***/
		JNIISLQPolynomial res;
		
		synchronized(LOCK) {
			checkParameters(this);
			try {
				res = JNIISLQPolynomial.build(ISLNative.isl_qpolynomial_insert_dims(getNativePtr(this), type.getValue(), first, n));
			} finally {
				taken(this);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_add_dims 
	 * 
	 * @take this
	 * @generated
	**/
	public JNIISLQPolynomial addDims(JNIISLDimType type, int n) {
		/*** PROTECTED REGION ID(isl_qpolynomial_add_dims) DISABLED START ***/
		JNIISLQPolynomial res;
		
		synchronized(LOCK) {
			checkParameters(this);
			try {
				res = JNIISLQPolynomial.build(ISLNative.isl_qpolynomial_add_dims(getNativePtr(this), type.getValue(), n));
			} finally {
				taken(this);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_move_dims 
	 * 
	 * @take this
	 * @generated
	**/
	public JNIISLQPolynomial moveDims(JNIISLDimType dst_type, int dst_pos, JNIISLDimType src_type, int src_pos, int n) {
		/*** PROTECTED REGION ID(isl_qpolynomial_move_dims) DISABLED START ***/
		JNIISLQPolynomial res;
		
		synchronized(LOCK) {
			checkParameters(this);
			try {
				res = JNIISLQPolynomial.build(ISLNative.isl_qpolynomial_move_dims(getNativePtr(this), dst_type.getValue(), dst_pos, src_type.getValue(), src_pos, n));
			} finally {
				taken(this);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_drop_dims 
	 * 
	 * @take this
	 * @generated
	**/
	public JNIISLQPolynomial dropDims(JNIISLDimType type, int first, int n) {
		/*** PROTECTED REGION ID(isl_qpolynomial_drop_dims) DISABLED START ***/
		JNIISLQPolynomial res;
		
		synchronized(LOCK) {
			checkParameters(this);
			try {
				res = JNIISLQPolynomial.build(ISLNative.isl_qpolynomial_drop_dims(getNativePtr(this), type.getValue(), first, n));
			} finally {
				taken(this);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_align_params 
	 * 
	 * @take this model
	 * @generated
	**/
	public JNIISLQPolynomial alignParams(JNIISLSpace model) {
		/*** PROTECTED REGION ID(isl_qpolynomial_align_params) DISABLED START ***/
		JNIISLQPolynomial res;
		
		synchronized(LOCK) {
			checkParameters(this, model);
			try {
				res = JNIISLQPolynomial.build(ISLNative.isl_qpolynomial_align_params(getNativePtr(this), getNativePtr(model)));
			} finally {
				taken(this);
				taken(model);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_gist 
	 * 
	 * @take this context
	 * @generated
	**/
	public JNIISLQPolynomial gist(JNIISLSet context) {
		/*** PROTECTED REGION ID(isl_qpolynomial_gist) DISABLED START ***/
		JNIISLQPolynomial res;
		
		synchronized(LOCK) {
			checkParameters(this, context);
			try {
				res = JNIISLQPolynomial.build(ISLNative.isl_qpolynomial_gist(getNativePtr(this), getNativePtr(context)));
			} finally {
				taken(this);
				taken(context);
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_get_exp_at 
	 * 
	 * @generated
	**/
	public int getExponentAt(int termPos, JNIISLDimType type, int dim) {
		/*** PROTECTED REGION ID(isl_qpolynomial_get_exp_at) DISABLED START ***/
		int res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = ISLNative.isl_qpolynomial_get_exp_at(getNativePtr(this), termPos, type.getValue(), dim);
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_numberof_terms 
	 * 
	 * @generated
	**/
	public int getNbTerms() {
		/*** PROTECTED REGION ID(isl_qpolynomial_numberof_terms) DISABLED START ***/
		int res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = ISLNative.isl_qpolynomial_numberof_terms(getNativePtr(this));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	/**
	 * isl_qpolynomial_get_term_at 
	 * 
	 * @generated
	**/
	public JNIISLTerm getTermAt(int pos) {
		/*** PROTECTED REGION ID(isl_qpolynomial_get_term_at) DISABLED START ***/
		JNIISLTerm res;
		
		synchronized(LOCK) {
			checkParameters();
			try {
				res = JNIISLTerm.build(ISLNative.isl_qpolynomial_get_term_at(getNativePtr(this), pos));
			} finally {
			}
		}
		
		return res;
		/*** PROTECTED REGION END ***/
	}
	
	
	public String toString() {
		/*** PROTECTED REGION ID(ISLQPolynomial_toString) DISABLED START ***/
			return ISLPrettyPrinter.asString(this);
		/*** PROTECTED REGION END ***/
	}
}
