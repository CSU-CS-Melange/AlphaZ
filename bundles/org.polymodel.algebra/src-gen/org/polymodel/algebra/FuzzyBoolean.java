/**
 */
package org.polymodel.algebra;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Fuzzy Boolean</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.polymodel.algebra.AlgebraPackage#getFuzzyBoolean()
 * @model
 * @generated
 */
public enum FuzzyBoolean implements Enumerator {
	/**
	 * The '<em><b>Yes</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #YES_VALUE
	 * @generated
	 * @ordered
	 */
	YES(0, "yes", "yes"),

	/**
	 * The '<em><b>No</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NO_VALUE
	 * @generated
	 * @ordered
	 */
	NO(1, "no", "no"),

	/**
	 * The '<em><b>Maybe</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAYBE_VALUE
	 * @generated
	 * @ordered
	 */
	MAYBE(2, "maybe", "maybe");

	/**
	 * The '<em><b>Yes</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Yes</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #YES
	 * @model name="yes"
	 * @generated
	 * @ordered
	 */
	public static final int YES_VALUE = 0;

	/**
	 * The '<em><b>No</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>No</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NO
	 * @model name="no"
	 * @generated
	 * @ordered
	 */
	public static final int NO_VALUE = 1;

	/**
	 * The '<em><b>Maybe</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Maybe</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAYBE
	 * @model name="maybe"
	 * @generated
	 * @ordered
	 */
	public static final int MAYBE_VALUE = 2;

	/**
	 * An array of all the '<em><b>Fuzzy Boolean</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final FuzzyBoolean[] VALUES_ARRAY =
		new FuzzyBoolean[] {
			YES,
			NO,
			MAYBE,
		};

	/**
	 * A public read-only list of all the '<em><b>Fuzzy Boolean</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<FuzzyBoolean> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Fuzzy Boolean</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FuzzyBoolean get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FuzzyBoolean result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Fuzzy Boolean</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FuzzyBoolean getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FuzzyBoolean result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Fuzzy Boolean</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FuzzyBoolean get(int value) {
		switch (value) {
			case YES_VALUE: return YES;
			case NO_VALUE: return NO;
			case MAYBE_VALUE: return MAYBE;
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
	private FuzzyBoolean(int value, String name, String literal) {
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
	
} //FuzzyBoolean
