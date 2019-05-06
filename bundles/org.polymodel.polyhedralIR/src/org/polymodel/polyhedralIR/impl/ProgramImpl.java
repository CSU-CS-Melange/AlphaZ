/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.ExternalFunctionDeclaration;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.OPS;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.PolyhedralIRFactory;
import org.polymodel.polyhedralIR.PolyhedralIRPackage;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.SIGNED;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.impl.ProgramImpl#getExternalFunctionDeclarations <em>External Function Declarations</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.ProgramImpl#getSystems <em>Systems</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.ProgramImpl#getTypes <em>Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProgramImpl extends EObjectImpl implements Program {
	/**
	 * The cached value of the '{@link #getExternalFunctionDeclarations() <em>External Function Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalFunctionDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<ExternalFunctionDeclaration> externalFunctionDeclarations;

	/**
	 * The cached value of the '{@link #getSystems() <em>Systems</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystems()
	 * @generated
	 * @ordered
	 */
	protected EList<AffineSystem> systems;

	/**
	 * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<Type> types;
	
	protected String filename;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProgramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyhedralIRPackage.eINSTANCE.getProgram();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExternalFunctionDeclaration> getExternalFunctionDeclarations() {
		if (externalFunctionDeclarations == null) {
			externalFunctionDeclarations = new EObjectContainmentEList<ExternalFunctionDeclaration>(ExternalFunctionDeclaration.class, this, PolyhedralIRPackage.PROGRAM__EXTERNAL_FUNCTION_DECLARATIONS);
		}
		return externalFunctionDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AffineSystem> getSystems() {
		if (systems == null) {
			systems = new EObjectContainmentWithInverseEList<AffineSystem>(AffineSystem.class, this, PolyhedralIRPackage.PROGRAM__SYSTEMS, PolyhedralIRPackage.AFFINE_SYSTEM__CONTAINER_PROGRAM);
		}
		return systems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> getTypes() {
		if (types == null) {
			types = new EObjectContainmentEList<Type>(Type.class, this, PolyhedralIRPackage.PROGRAM__TYPES);
		}
		return types;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Type getType(SIGNED signed, DATATYPE type, int width) {
		Type ntype = PolyhedralIRFactory.eINSTANCE.createType();
		
		ntype.setSigned(signed);
		ntype.setTypeID(type);
		ntype.setWidth(width);
		
		for (Type t : getTypes()) {
			if (t.getSigned() == ntype.getSigned() && 
				t.getTypeID() == ntype.getTypeID() &&
				t.getWidth() == ntype.getWidth()) {
				return t;
			}
		}
		
		getTypes().add(ntype);
		
		return ntype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public OP getBinaryOperator(String op) {
		
		if (op.compareTo(OPS.ADD_STR) == 0) {
			return OP.ADD;
		} else if (op.compareTo(OPS.SUB_STR) == 0) {
			return OP.SUB;
		} else if (op.compareTo(OPS.MUL_STR) == 0) {
			return OP.MUL;
		} else if (op.compareTo(OPS.DIV_STR) == 0) {
			return OP.DIV;
		} else if (op.compareTo(OPS.MOD_STR) == 0) {
			return OP.MOD;
		} else if (op.compareTo(OPS.MAX_STR) == 0) {
			return OP.MAX;
		} else if (op.compareTo(OPS.MIN_STR) == 0) {
			return OP.MIN;
		} else if (op.compareTo(OPS.AND_STR) == 0) {
			return OP.AND;
		} else if (op.compareTo(OPS.OR_STR) == 0) {
			return OP.OR;
		} else if (op.compareTo(OPS.NAND_STR) == 0) {
			return OP.NAND;
		} else if (op.compareTo(OPS.NOR_STR) == 0) {
			return OP.NOR;
		} else if (op.compareTo(OPS.XOR_STR) == 0) {
			return OP.XOR;
		} else if (op.compareTo(OPS.EQ_STR) == 0) {
			return OP.EQ;
		} else if (op.compareTo(OPS.NE_STR) == 0) {
			return OP.NE;
		} else if (op.compareTo(OPS.GT_STR) == 0) {
			return OP.GT;
		} else if (op.compareTo(OPS.GE_STR) == 0) {
			return OP.GE;
		} else if (op.compareTo(OPS.LT_STR) == 0) {
			return OP.LT;
		} else if (op.compareTo(OPS.LE_STR) == 0) {
			return OP.LE;
		}
		
		throw new RuntimeException("Operator " + op + " does not exist.");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public OP getUnaryOperator(String op) {
		if (op.compareTo(OPS.NOT_STR) == 0) {
			return OP.NOT;
		} else if (op.compareTo(OPS.NEG_STR) == 0) {
			return OP.NEG;
		}

		throw new RuntimeException("Operator " + op + " does not exist.");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public OP getMultiArgOperator(String op) {
		if (op.compareTo(OPS.ADD_MULTI_STR) == 0) {
			return OP.ADD;
		} else if (op.compareTo(OPS.MUL_MULTI_STR) == 0) {
			return OP.MUL;
		} else if (op.compareTo(OPS.MAX_MULTI_STR) == 0) {
			return OP.MAX;
		} else if (op.compareTo(OPS.MIN_MULTI_STR) == 0) {
			return OP.MIN;
		} else if (op.compareTo(OPS.AND_MULTI_STR) == 0) {
			return OP.AND;
		} else if (op.compareTo(OPS.OR_MULTI_STR) == 0) {
			return OP.OR;
		}

		throw new RuntimeException("Operator " + op + " does not exist.");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public OP getExternalFunctionOperator() {
		return OP.EXTERNAL_FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Currently only checks for name
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ExternalFunctionDeclaration getExternalFunctionDeclaration(String name, Type output, EList<Type> inputs) {
		for (ExternalFunctionDeclaration efd : getExternalFunctionDeclarations()) {
			//Check name
			if (efd.getName().compareTo(name) == 0 /*&& efd.getOutput().equals(output)*/) {
				return efd;
			}
		}
		
		throw new RuntimeException("Declaration of external function " + name + " not found.");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AffineSystem getSystem(String systemName) {
		for (AffineSystem system : getSystems()) {
			if (system.getName().compareTo(systemName) == 0) {
				return system;
			}
		}
		
		throw new RuntimeException("System " + systemName + " was not found.");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ParameterDomain getParameterDomain(String systemName) {
		for (AffineSystem system : getSystems()) {
			if (system.getName().compareTo(systemName) == 0) {
				return system.getParameters();
			}
		}
		
		throw new RuntimeException("System " + systemName + " was not found.");
	}

	/**
	 * <!-- begin-user-doc -->
	 * EcoreUtil.copy
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Program copy() {
		// Guillaume: EcoreUtil.copy() does not work on ExternalFunctionDeclaration (for unknown reason)
		// => doing it the old way...
		
		Program copy = PolyhedralIRFactory.eINSTANCE.createProgram();
		for (AffineSystem syst : this.getSystems())
			copy.getSystems().add(syst.copy());
		for (Type t : this.getTypes())
			copy.getTypes().add(EcoreUtil.copy(t));
		for (ExternalFunctionDeclaration extFunc : this.getExternalFunctionDeclarations()) {
			ExternalFunctionDeclaration extFuncCopy = PolyhedralIRFactory.eINSTANCE.createExternalFunctionDeclaration();
			extFuncCopy.setName(extFunc.getName());
			extFuncCopy.setOutput(EcoreUtil.copy(extFuncCopy.getOutput()));
			for (Type t : extFunc.getInputs())
				extFuncCopy.getInputs().add(EcoreUtil.copy(t));
			copy.getExternalFunctionDeclarations().add(extFuncCopy);
		}
		//Program copy = EcoreUtil.copy(this);
		
//		Map<String, ExternalFunctionDeclaration> orig = new TreeMap<String, ExternalFunctionDeclaration>();
//		Map<String, ExternalFunctionDeclaration> copied = new TreeMap<String, ExternalFunctionDeclaration>();
//		
//		//copy external functions and initialize the map for later replacement in systems
//		for (ExternalFunctionDeclaration efd : this.getExternalFunctionDeclarations()) {
//			orig.put(efd.getName(), efd);
//			ExternalFunctionDeclaration efdCopy = EcoreUtil.copy(efd); 
//			copied.put(efd.getName(), efdCopy);
//			copy.getExternalFunctionDeclarations().add(efdCopy);
//		}
//
//		//copy systems
//		for (AffineSystem system : this.getSystems()) {
//			AffineSystem systemCopy = system.copy();
//			copy.getSystems().add(systemCopy);
//		}
//		
//		//replace external functions
//		for (String key : orig.keySet()) {
//			EcoreUtil.replace(orig.get(key), copied.get(key));
//		}
//		
		return copy;
	}

	/**
	 * Check if a AffineSystem of name "name" exists in the program
	 * @generated NOT
	 */
	public boolean isContainingSystem(String name) {
		boolean res = false;
		
		for (AffineSystem afSys : getSystems()) {
			if (afSys.getName().equals(name)) {
				res = true;
				break;
			}
		}
		
		return res;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitProgram(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolyhedralIRPackage.PROGRAM__SYSTEMS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSystems()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolyhedralIRPackage.PROGRAM__EXTERNAL_FUNCTION_DECLARATIONS:
				return ((InternalEList<?>)getExternalFunctionDeclarations()).basicRemove(otherEnd, msgs);
			case PolyhedralIRPackage.PROGRAM__SYSTEMS:
				return ((InternalEList<?>)getSystems()).basicRemove(otherEnd, msgs);
			case PolyhedralIRPackage.PROGRAM__TYPES:
				return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PolyhedralIRPackage.PROGRAM__EXTERNAL_FUNCTION_DECLARATIONS:
				return getExternalFunctionDeclarations();
			case PolyhedralIRPackage.PROGRAM__SYSTEMS:
				return getSystems();
			case PolyhedralIRPackage.PROGRAM__TYPES:
				return getTypes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PolyhedralIRPackage.PROGRAM__EXTERNAL_FUNCTION_DECLARATIONS:
				getExternalFunctionDeclarations().clear();
				getExternalFunctionDeclarations().addAll((Collection<? extends ExternalFunctionDeclaration>)newValue);
				return;
			case PolyhedralIRPackage.PROGRAM__SYSTEMS:
				getSystems().clear();
				getSystems().addAll((Collection<? extends AffineSystem>)newValue);
				return;
			case PolyhedralIRPackage.PROGRAM__TYPES:
				getTypes().clear();
				getTypes().addAll((Collection<? extends Type>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PolyhedralIRPackage.PROGRAM__EXTERNAL_FUNCTION_DECLARATIONS:
				getExternalFunctionDeclarations().clear();
				return;
			case PolyhedralIRPackage.PROGRAM__SYSTEMS:
				getSystems().clear();
				return;
			case PolyhedralIRPackage.PROGRAM__TYPES:
				getTypes().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PolyhedralIRPackage.PROGRAM__EXTERNAL_FUNCTION_DECLARATIONS:
				return externalFunctionDeclarations != null && !externalFunctionDeclarations.isEmpty();
			case PolyhedralIRPackage.PROGRAM__SYSTEMS:
				return systems != null && !systems.isEmpty();
			case PolyhedralIRPackage.PROGRAM__TYPES:
				return types != null && !types.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public String getFilename() {
		if (filename == null) {
			if (this.getSystems().size() > 0) {
				filename = this.getSystems().get(0).getName();
			} else {
				filename = "unnamed";
			}
		}
		return filename;
	}

	@Override
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	@Override
	public String toString() {
		return PolyhedralIRToAlphabets.toString(this);
	}

} //ProgramImpl
