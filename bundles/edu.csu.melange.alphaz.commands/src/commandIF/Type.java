/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package commandIF;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see commandIF.CommandIFPackage#getType()
 * @model
 * @generated
 */
public enum Type implements Enumerator {
	/**
	 * The '<em><b>Program</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROGRAM_VALUE
	 * @generated
	 * @ordered
	 */
	PROGRAM(1, "Program", "Program"), /**
	 * The '<em><b>Affine System</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AFFINE_SYSTEM_VALUE
	 * @generated
	 * @ordered
	 */
	AFFINE_SYSTEM(2, "AffineSystem", "AffineSystem"), /**
	 * The '<em><b>Standard Equation</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STANDARD_EQUATION_VALUE
	 * @generated
	 * @ordered
	 */
	STANDARD_EQUATION(3, "StandardEquation", "StandardEquation"), /**
	 * The '<em><b>Expression</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXPRESSION_VALUE
	 * @generated
	 * @ordered
	 */
	EXPRESSION(4, "Expression", "Expression"), /**
	 * The '<em><b>String</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRING_VALUE
	 * @generated
	 * @ordered
	 */
	STRING(10, "String", "String"),

	/**
	 * The '<em><b>String List</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRING_LIST_VALUE
	 * @generated
	 * @ordered
	 */
	STRING_LIST(11, "StringList", "List<String>"), /**
	 * The '<em><b>String Array</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRING_ARRAY_VALUE
	 * @generated
	 * @ordered
	 */
	STRING_ARRAY(12, "StringArray", "String[]"), /**
	 * The '<em><b>Boolean</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOOLEAN_VALUE
	 * @generated
	 * @ordered
	 */
	BOOLEAN(20, "Boolean", "Boolean"), /**
	 * The '<em><b>Int</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INT_VALUE
	 * @generated
	 * @ordered
	 */
	INT(30, "int", "int"), /**
	 * The '<em><b>Int List</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INT_LIST_VALUE
	 * @generated
	 * @ordered
	 */
	INT_LIST(31, "intList", "List<Integer>"), /**
	 * The '<em><b>Int Array</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INT_ARRAY_VALUE
	 * @generated
	 * @ordered
	 */
	INT_ARRAY(32, "intArray", "int[]"), /**
	 * The '<em><b>Target Mapping</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TARGET_MAPPING_VALUE
	 * @generated
	 * @ordered
	 */
	TARGET_MAPPING(200, "TargetMapping", "TargetMapping"), /**
	 * The '<em><b>Space Time Map</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPACE_TIME_MAP_VALUE
	 * @generated
	 * @ordered
	 */
	SPACE_TIME_MAP(201, "SpaceTimeMap", "SpaceTimeMap"), /**
	 * The '<em><b>Memory Space</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEMORY_SPACE_VALUE
	 * @generated
	 * @ordered
	 */
	MEMORY_SPACE(202, "MemorySpace", "MemorySpace"), /**
	 * The '<em><b>Memory Map</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEMORY_MAP_VALUE
	 * @generated
	 * @ordered
	 */
	MEMORY_MAP(203, "MemoryMap", "MemoryMap"), /**
	 * The '<em><b>DIM TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIM_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	DIM_TYPE(210, "DIM_TYPE", "DIM_TYPE"), /**
	 * The '<em><b>Code Gen Options</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CODE_GEN_OPTIONS_VALUE
	 * @generated
	 * @ordered
	 */
	CODE_GEN_OPTIONS(250, "CodeGenOptions", "CodeGenOptions"), /**
	 * The '<em><b>Tiled Code Gen Options</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TILED_CODE_GEN_OPTIONS_VALUE
	 * @generated
	 * @ordered
	 */
	TILED_CODE_GEN_OPTIONS(251, "TiledCodeGenOptions", "TiledCodeGenOptions"), /**
	 * The '<em><b>Void</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VOID_VALUE
	 * @generated
	 * @ordered
	 */
	VOID(400, "void", "void"), /**
	 * The '<em><b>Affine Function</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AFFINE_FUNCTION_VALUE
	 * @generated
	 * @ordered
	 */
	AFFINE_FUNCTION(500, "AffineFunction", "AffineFunction"), /**
	 * The '<em><b>Domain</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOMAIN_VALUE
	 * @generated
	 * @ordered
	 */
	DOMAIN(501, "Domain", "Domain"), /**
	 * The '<em><b>Parameter Domain</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PARAMETER_DOMAIN_VALUE
	 * @generated
	 * @ordered
	 */
	PARAMETER_DOMAIN(502, "ParameterDomain", "ParameterDomain"), /**
	 * The '<em><b>PRDG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRDG_VALUE
	 * @generated
	 * @ordered
	 */
	PRDG(503, "PRDG", "PRDG"), /**
	 * The '<em><b>Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	OBJECT(1000, "Object", "Object"), /**
	 * The '<em><b>Scheduled Statement</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCHEDULED_STATEMENT_VALUE
	 * @generated
	 * @ordered
	 */
	SCHEDULED_STATEMENT(510, "ScheduledStatement", "ScheduledStatement"), /**
	 * The '<em><b>Scheduled Statement List</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCHEDULED_STATEMENT_LIST_VALUE
	 * @generated
	 * @ordered
	 */
	SCHEDULED_STATEMENT_LIST(511, "ScheduledStatementList", "List<ScheduledStatement>");

	/**
	 * The '<em><b>Program</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Program</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROGRAM
	 * @model name="Program"
	 * @generated
	 * @ordered
	 */
	public static final int PROGRAM_VALUE = 1;

	/**
	 * The '<em><b>Affine System</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Affine System</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AFFINE_SYSTEM
	 * @model name="AffineSystem"
	 * @generated
	 * @ordered
	 */
	public static final int AFFINE_SYSTEM_VALUE = 2;

	/**
	 * The '<em><b>Standard Equation</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Standard Equation</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STANDARD_EQUATION
	 * @model name="StandardEquation"
	 * @generated
	 * @ordered
	 */
	public static final int STANDARD_EQUATION_VALUE = 3;

	/**
	 * The '<em><b>Expression</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Expression</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXPRESSION
	 * @model name="Expression"
	 * @generated
	 * @ordered
	 */
	public static final int EXPRESSION_VALUE = 4;

	/**
	 * The '<em><b>String</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>String</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STRING
	 * @model name="String"
	 * @generated
	 * @ordered
	 */
	public static final int STRING_VALUE = 10;

	/**
	 * The '<em><b>String List</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>String List</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STRING_LIST
	 * @model name="StringList" literal="List<String>"
	 * @generated
	 * @ordered
	 */
	public static final int STRING_LIST_VALUE = 11;

	/**
	 * The '<em><b>String Array</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>String Array</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STRING_ARRAY
	 * @model name="StringArray" literal="String[]"
	 * @generated
	 * @ordered
	 */
	public static final int STRING_ARRAY_VALUE = 12;

	/**
	 * The '<em><b>Boolean</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Boolean</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOOLEAN
	 * @model name="Boolean"
	 * @generated
	 * @ordered
	 */
	public static final int BOOLEAN_VALUE = 20;

	/**
	 * The '<em><b>Int</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Int</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INT
	 * @model name="int"
	 * @generated
	 * @ordered
	 */
	public static final int INT_VALUE = 30;

	/**
	 * The '<em><b>Int List</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Int List</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INT_LIST
	 * @model name="intList" literal="List<Integer>"
	 * @generated
	 * @ordered
	 */
	public static final int INT_LIST_VALUE = 31;

	/**
	 * The '<em><b>Int Array</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Int Array</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INT_ARRAY
	 * @model name="intArray" literal="int[]"
	 * @generated
	 * @ordered
	 */
	public static final int INT_ARRAY_VALUE = 32;

	/**
	 * The '<em><b>Target Mapping</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Target Mapping</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TARGET_MAPPING
	 * @model name="TargetMapping"
	 * @generated
	 * @ordered
	 */
	public static final int TARGET_MAPPING_VALUE = 200;

	/**
	 * The '<em><b>Space Time Map</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Space Time Map</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SPACE_TIME_MAP
	 * @model name="SpaceTimeMap"
	 * @generated
	 * @ordered
	 */
	public static final int SPACE_TIME_MAP_VALUE = 201;

	/**
	 * The '<em><b>Memory Space</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Memory Space</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEMORY_SPACE
	 * @model name="MemorySpace"
	 * @generated
	 * @ordered
	 */
	public static final int MEMORY_SPACE_VALUE = 202;

	/**
	 * The '<em><b>Memory Map</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Memory Map</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEMORY_MAP
	 * @model name="MemoryMap"
	 * @generated
	 * @ordered
	 */
	public static final int MEMORY_MAP_VALUE = 203;

	/**
	 * The '<em><b>DIM TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIM TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIM_TYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIM_TYPE_VALUE = 210;

	/**
	 * The '<em><b>Code Gen Options</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Code Gen Options</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CODE_GEN_OPTIONS
	 * @model name="CodeGenOptions"
	 * @generated
	 * @ordered
	 */
	public static final int CODE_GEN_OPTIONS_VALUE = 250;

	/**
	 * The '<em><b>Tiled Code Gen Options</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Tiled Code Gen Options</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TILED_CODE_GEN_OPTIONS
	 * @model name="TiledCodeGenOptions"
	 * @generated
	 * @ordered
	 */
	public static final int TILED_CODE_GEN_OPTIONS_VALUE = 251;

	/**
	 * The '<em><b>Void</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Void</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VOID
	 * @model name="void"
	 * @generated
	 * @ordered
	 */
	public static final int VOID_VALUE = 400;

	/**
	 * The '<em><b>Affine Function</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Affine Function</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AFFINE_FUNCTION
	 * @model name="AffineFunction"
	 * @generated
	 * @ordered
	 */
	public static final int AFFINE_FUNCTION_VALUE = 500;

	/**
	 * The '<em><b>Domain</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Domain</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOMAIN
	 * @model name="Domain"
	 * @generated
	 * @ordered
	 */
	public static final int DOMAIN_VALUE = 501;

	/**
	 * The '<em><b>Parameter Domain</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Parameter Domain</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PARAMETER_DOMAIN
	 * @model name="ParameterDomain"
	 * @generated
	 * @ordered
	 */
	public static final int PARAMETER_DOMAIN_VALUE = 502;

	/**
	 * The '<em><b>PRDG</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PRDG</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRDG
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PRDG_VALUE = 503;

	/**
	 * The '<em><b>Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Object</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OBJECT
	 * @model name="Object"
	 * @generated
	 * @ordered
	 */
	public static final int OBJECT_VALUE = 1000;

	/**
	 * The '<em><b>Scheduled Statement</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Scheduled Statement</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SCHEDULED_STATEMENT
	 * @model name="ScheduledStatement"
	 * @generated
	 * @ordered
	 */
	public static final int SCHEDULED_STATEMENT_VALUE = 510;

	/**
	 * The '<em><b>Scheduled Statement List</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Scheduled Statement List</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SCHEDULED_STATEMENT_LIST
	 * @model name="ScheduledStatementList" literal="List<ScheduledStatement>"
	 * @generated
	 * @ordered
	 */
	public static final int SCHEDULED_STATEMENT_LIST_VALUE = 511;

	/**
	 * An array of all the '<em><b>Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Type[] VALUES_ARRAY =
		new Type[] {
			PROGRAM,
			AFFINE_SYSTEM,
			STANDARD_EQUATION,
			EXPRESSION,
			STRING,
			STRING_LIST,
			STRING_ARRAY,
			BOOLEAN,
			INT,
			INT_LIST,
			INT_ARRAY,
			TARGET_MAPPING,
			SPACE_TIME_MAP,
			MEMORY_SPACE,
			MEMORY_MAP,
			DIM_TYPE,
			CODE_GEN_OPTIONS,
			TILED_CODE_GEN_OPTIONS,
			VOID,
			AFFINE_FUNCTION,
			DOMAIN,
			PARAMETER_DOMAIN,
			PRDG,
			OBJECT,
			SCHEDULED_STATEMENT,
			SCHEDULED_STATEMENT_LIST,
		};

	/**
	 * A public read-only list of all the '<em><b>Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Type> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Type get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Type result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Type getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Type result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Type get(int value) {
		switch (value) {
			case PROGRAM_VALUE: return PROGRAM;
			case AFFINE_SYSTEM_VALUE: return AFFINE_SYSTEM;
			case STANDARD_EQUATION_VALUE: return STANDARD_EQUATION;
			case EXPRESSION_VALUE: return EXPRESSION;
			case STRING_VALUE: return STRING;
			case STRING_LIST_VALUE: return STRING_LIST;
			case STRING_ARRAY_VALUE: return STRING_ARRAY;
			case BOOLEAN_VALUE: return BOOLEAN;
			case INT_VALUE: return INT;
			case INT_LIST_VALUE: return INT_LIST;
			case INT_ARRAY_VALUE: return INT_ARRAY;
			case TARGET_MAPPING_VALUE: return TARGET_MAPPING;
			case SPACE_TIME_MAP_VALUE: return SPACE_TIME_MAP;
			case MEMORY_SPACE_VALUE: return MEMORY_SPACE;
			case MEMORY_MAP_VALUE: return MEMORY_MAP;
			case DIM_TYPE_VALUE: return DIM_TYPE;
			case CODE_GEN_OPTIONS_VALUE: return CODE_GEN_OPTIONS;
			case TILED_CODE_GEN_OPTIONS_VALUE: return TILED_CODE_GEN_OPTIONS;
			case VOID_VALUE: return VOID;
			case AFFINE_FUNCTION_VALUE: return AFFINE_FUNCTION;
			case DOMAIN_VALUE: return DOMAIN;
			case PARAMETER_DOMAIN_VALUE: return PARAMETER_DOMAIN;
			case PRDG_VALUE: return PRDG;
			case OBJECT_VALUE: return OBJECT;
			case SCHEDULED_STATEMENT_VALUE: return SCHEDULED_STATEMENT;
			case SCHEDULED_STATEMENT_LIST_VALUE: return SCHEDULED_STATEMENT_LIST;
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
	private Type(int value, String name, String literal) {
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
	
} //Type
