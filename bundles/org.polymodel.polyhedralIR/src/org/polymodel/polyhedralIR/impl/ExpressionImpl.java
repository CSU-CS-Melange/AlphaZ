/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Equation;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.PolyhedralIRPackage;
import org.polymodel.polyhedralIR.PolyhedralIRVisitor;
import org.polymodel.polyhedralIR.SIGNED;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.util.ContextDomainCalculator;
import org.polymodel.polyhedralIR.util.ExpressionDomainCalculator;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.polyhedralIR.impl.ExpressionImpl#getContextDomain <em>Context Domain</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.ExpressionImpl#getExpressionDomain <em>Expression Domain</em>}</li>
 *   <li>{@link org.polymodel.polyhedralIR.impl.ExpressionImpl#getExpressionType <em>Expression Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ExpressionImpl extends EObjectImpl implements Expression {
	/**
	 * The cached value of the '{@link #getContextDomain() <em>Context Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextDomain()
	 * @generated
	 * @ordered
	 */
	protected Domain contextDomain;
	/**
	 * The cached value of the '{@link #getExpressionDomain() <em>Expression Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionDomain()
	 * @generated
	 * @ordered
	 */
	protected Domain expressionDomain;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyhedralIRPackage.eINSTANCE.getExpression();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Domain getContextDomain() {
		//When context domain is not computed, look for the root and compute the context domain
		if (contextDomain == null) {
			Equation eq = getContainerEquation();
			if (eq == null) {
				throw new RuntimeException("Unable to compute context domain. Expression not contained by StandardEquation.");
			}
			
			AffineSystem syst;
			if (eq instanceof StandardEquation)
				syst = ((StandardEquation) eq).getContainerSystem();
			else
				syst = ((UseEquation) eq).getContainerSystem();
			
			if (syst != null) {
				if (eq instanceof StandardEquation)
					ContextDomainCalculator.computeContextDomain(((StandardEquation)eq).getExpression());
				else {
					//for (Expression InpExpr : ((UseEquation) eq).getInputs())
						ContextDomainCalculator.computeContextDomain(this);
				}
			} else {
				throw new RuntimeException("Unable to compute context domain. Expression not contained by AffineSystem.");
			}
		}
		return contextDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContextDomain(Domain newContextDomain, NotificationChain msgs) {
		Domain oldContextDomain = contextDomain;
		contextDomain = newContextDomain;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.EXPRESSION__CONTEXT_DOMAIN, oldContextDomain, newContextDomain);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextDomain(Domain newContextDomain) {
		if (newContextDomain != contextDomain) {
			NotificationChain msgs = null;
			if (contextDomain != null)
				msgs = ((InternalEObject)contextDomain).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolyhedralIRPackage.EXPRESSION__CONTEXT_DOMAIN, null, msgs);
			if (newContextDomain != null)
				msgs = ((InternalEObject)newContextDomain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolyhedralIRPackage.EXPRESSION__CONTEXT_DOMAIN, null, msgs);
			msgs = basicSetContextDomain(newContextDomain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.EXPRESSION__CONTEXT_DOMAIN, newContextDomain, newContextDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Domain getExpressionDomain() {
		//When context domain is not computed, look for the root and compute the context domain
		if (expressionDomain == null) {
			
			Equation eq = getContainerEquation();
			
			if (eq == null) {
				throw new RuntimeException("Unable to compute expression domain. Expression not contained by StandardEquation.");
			}
			AffineSystem syst;
			if (eq instanceof StandardEquation)
				syst = ((StandardEquation) eq).getContainerSystem();
			else
				syst = ((UseEquation) eq).getContainerSystem();
			
			if (syst != null) {
				if (eq instanceof StandardEquation)
					ExpressionDomainCalculator.computeExpressionDomain(syst.getParameters(), ((StandardEquation)eq).getExpression());
				else {
					for (Expression InpExpr : ((UseEquation) eq).getInputs())
						ExpressionDomainCalculator.computeExpressionDomain(syst.getParameters(), InpExpr);
				}
			} else {
				throw new RuntimeException("Unable to compute expression domain. Expression not contained by AffineSystem.");
			}
		}
		return expressionDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpressionDomain(Domain newExpressionDomain, NotificationChain msgs) {
		Domain oldExpressionDomain = expressionDomain;
		expressionDomain = newExpressionDomain;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.EXPRESSION__EXPRESSION_DOMAIN, oldExpressionDomain, newExpressionDomain);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpressionDomain(Domain newExpressionDomain) {
		if (newExpressionDomain != expressionDomain) {
			NotificationChain msgs = null;
			if (expressionDomain != null)
				msgs = ((InternalEObject)expressionDomain).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PolyhedralIRPackage.EXPRESSION__EXPRESSION_DOMAIN, null, msgs);
			if (newExpressionDomain != null)
				msgs = ((InternalEObject)newExpressionDomain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PolyhedralIRPackage.EXPRESSION__EXPRESSION_DOMAIN, null, msgs);
			msgs = basicSetExpressionDomain(newExpressionDomain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PolyhedralIRPackage.EXPRESSION__EXPRESSION_DOMAIN, newExpressionDomain, newExpressionDomain));
	}
/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getExpressionType() {
		Type expressionType = basicGetExpressionType();
		return expressionType != null && expressionType.eIsProxy() ? (Type)eResolveProxy((InternalEObject)expressionType) : expressionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetExpressionType() {
		// TODO: implement this method to return the 'Expression Type' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isSetExpressionType() {
		return false;
	}

	protected Type mergeTypes(Type type1, Type type2) {
		
		SIGNED sign = SIGNED.UNSIGNED;
		//If one of them is signed, make the merged type signed
		if (type1.getSigned() == SIGNED.SIGNED || type2.getSigned() == SIGNED.SIGNED) {
			sign = SIGNED.SIGNED;
		}
		
		//
		DATATYPE type = getCompatibleType(type1.getTypeID(), type2.getTypeID());
		
		int width = Math.max(type1.getWidth(), type2.getWidth());
		
		if (this.getContainerEquation() instanceof StandardEquation)
			return ((StandardEquation) this.getContainerEquation()).getContainerSystem().getContainerProgram().getType(sign, type, width);
		else
			return ((UseEquation) this.getContainerEquation()).getContainerSystem().getContainerProgram().getType(sign, type, width);
		
	}

	private DATATYPE getCompatibleType(DATATYPE type1, DATATYPE type2) {
		
		//If its the same, no problem
		if (type1 == type2) {
			return type1;
		}
		
		//Integer and float can be combined as float
		if ((type1 == DATATYPE.INTEGER && type2 == DATATYPE.FLOATING_POINT) || 
			(type1 == DATATYPE.FLOATING_POINT && type2 == DATATYPE.INTEGER)) {
			return DATATYPE.FLOATING_POINT;
		}
		
		throw new RuntimeException("Cannot combine types " + type1 + " and " + type2) ;
	}
	
//   private static SignedType mergeTypes(List<SignedType> types) throws alphabetsException {
//      if (types == null || types.size() == 0) {
//         throw new alphabetsException("getExpressionType : Types given are either null or has size of 0");
//      }
//
//      alphabets.Types type = types.get(0).Type;
//      alphabets.TSign sign = types.get(0).Sign;
//		
//      for (SignedType t : types) {
//         // If any one of them has a sign, then the merged type should have be signed too
//         if (t.Sign == alphabets.TSign.Yes) {
//            sign = alphabets.TSign.Yes;
//         }
//			
//         // Check for compatibility of types
//         if (!isCompatibleType(type, t.Type)) {
//            throw new alphabetsException("getExpressionType : Encountered incompatible types while merging.");
//         }
//			
//         // When they are compatible but not the same, take the larger sized one
//         if (type != t.Type) {
//            int sizeA = 0;
//            int sizeB = 0;
//				
//            // assign values to each type based on the size of the type
//            // I don't like this redundant switches, but it works for now TODO
//            switch (type) {
//            case IntT:
//            case DoubleT:
//               sizeA = 1;
//               break;
//
//            case LongT:
//               sizeA = 2;
//               break;
//
//            case LLongT:
//               sizeA = 3;
//               break;
//            }
//				
//            switch (t.Type) {
//            case IntT:
//            case DoubleT:
//               sizeB = 1;
//               break;
//
//            case LongT:
//               sizeB = 2;
//               break;
//
//            case LLongT:
//               sizeB = 3;
//               break;
//            }
//				
//            // when the new type had larger value, then use that type
//            if (sizeA < sizeB) {
//               type = t.Type;
//            }
//         }
//      }
//		
//      return new SignedType(type, sign);
//   }
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Expression copy() {
		ExpressionImpl copy = EcoreUtil.copy(this);
		
		return copy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Equation getContainerEquation() {
		EObject obj = this.eContainer();
		
		while (obj != null && obj instanceof Expression) {
			obj = obj.eContainer();
		}
		
		if (obj == null || (!(obj instanceof StandardEquation) && !(obj instanceof UseEquation))) {
			throw new RuntimeException("First non-Expression encountered by traversing eContainer was not a StandardEquation, nor a UseEquation.");
		}
		
		return (Equation)obj;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean equivalence(Expression expr) {
		throw new UnsupportedOperationException("No equivalence checking for the global Expression class");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final PolyhedralIRVisitor visitor) {
		visitor.visitExpression(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PolyhedralIRPackage.EXPRESSION__CONTEXT_DOMAIN:
				return basicSetContextDomain(null, msgs);
			case PolyhedralIRPackage.EXPRESSION__EXPRESSION_DOMAIN:
				return basicSetExpressionDomain(null, msgs);
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
			case PolyhedralIRPackage.EXPRESSION__CONTEXT_DOMAIN:
				return getContextDomain();
			case PolyhedralIRPackage.EXPRESSION__EXPRESSION_DOMAIN:
				return getExpressionDomain();
			case PolyhedralIRPackage.EXPRESSION__EXPRESSION_TYPE:
				if (resolve) return getExpressionType();
				return basicGetExpressionType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PolyhedralIRPackage.EXPRESSION__CONTEXT_DOMAIN:
				setContextDomain((Domain)newValue);
				return;
			case PolyhedralIRPackage.EXPRESSION__EXPRESSION_DOMAIN:
				setExpressionDomain((Domain)newValue);
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
			case PolyhedralIRPackage.EXPRESSION__CONTEXT_DOMAIN:
				setContextDomain((Domain)null);
				return;
			case PolyhedralIRPackage.EXPRESSION__EXPRESSION_DOMAIN:
				setExpressionDomain((Domain)null);
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
			case PolyhedralIRPackage.EXPRESSION__CONTEXT_DOMAIN:
				return contextDomain != null;
			case PolyhedralIRPackage.EXPRESSION__EXPRESSION_DOMAIN:
				return expressionDomain != null;
			case PolyhedralIRPackage.EXPRESSION__EXPRESSION_TYPE:
				return isSetExpressionType();
		}
		return super.eIsSet(featureID);
	}

} //ExpressionImpl
