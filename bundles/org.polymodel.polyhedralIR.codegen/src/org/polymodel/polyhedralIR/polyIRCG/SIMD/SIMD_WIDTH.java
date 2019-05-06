/**
 */
package org.polymodel.polyhedralIR.polyIRCG.SIMD;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>SIMD WIDTH</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.polymodel.polyhedralIR.polyIRCG.SIMD.SIMDPackage#getSIMD_WIDTH()
 * @model
 * @generated
 */
public enum SIMD_WIDTH implements Enumerator {
	/**
	 * The '<em><b>M128</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #M128_VALUE
	 * @generated
	 * @ordered
	 */
	M128(0, "M128", "M128"),

	/**
	 * The '<em><b>M256</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #M256_VALUE
	 * @generated
	 * @ordered
	 */
	M256(1, "M256", "M256");

	/**
	 * The '<em><b>M128</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>M128</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #M128
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int M128_VALUE = 0;

	/**
	 * The '<em><b>M256</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>M256</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #M256
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int M256_VALUE = 1;

	/**
	 * An array of all the '<em><b>SIMD WIDTH</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SIMD_WIDTH[] VALUES_ARRAY =
		new SIMD_WIDTH[] {
			M128,
			M256,
		};

	/**
	 * A public read-only list of all the '<em><b>SIMD WIDTH</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SIMD_WIDTH> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>SIMD WIDTH</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SIMD_WIDTH get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SIMD_WIDTH result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>SIMD WIDTH</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SIMD_WIDTH getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SIMD_WIDTH result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>SIMD WIDTH</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static SIMD_WIDTH get(int value) {
		switch (value) {
			case M128_VALUE: return M128;
			case M256_VALUE: return M256;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private SIMD_WIDTH(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //SIMD_WIDTH
