/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop.annotation.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.scop.ScopVisitor;
import org.polymodel.scop.annotation.AnnotationPackage;
import org.polymodel.scop.annotation.TileLoopAnnotation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tile Loop Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.scop.annotation.impl.TileLoopAnnotationImpl#getTileIndex <em>Tile Index</em>}</li>
 *   <li>{@link org.polymodel.scop.annotation.impl.TileLoopAnnotationImpl#getTileSize <em>Tile Size</em>}</li>
 *   <li>{@link org.polymodel.scop.annotation.impl.TileLoopAnnotationImpl#getOffset <em>Offset</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TileLoopAnnotationImpl extends EObjectImpl implements TileLoopAnnotation {
	/**
	 * The cached value of the '{@link #getTileIndex() <em>Tile Index</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTileIndex()
	 * @generated
	 * @ordered
	 */
	protected Variable tileIndex;

	/**
	 * The cached value of the '{@link #getTileSize() <em>Tile Size</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTileSize()
	 * @generated
	 * @ordered
	 */
	protected IntExpression tileSize;

	/**
	 * The cached value of the '{@link #getOffset() <em>Offset</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffset()
	 * @generated
	 * @ordered
	 */
	protected IntExpression offset;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TileLoopAnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnnotationPackage.Literals.TILE_LOOP_ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getTileIndex() {
		if (tileIndex != null && tileIndex.eIsProxy()) {
			InternalEObject oldTileIndex = (InternalEObject)tileIndex;
			tileIndex = (Variable)eResolveProxy(oldTileIndex);
			if (tileIndex != oldTileIndex) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AnnotationPackage.TILE_LOOP_ANNOTATION__TILE_INDEX, oldTileIndex, tileIndex));
			}
		}
		return tileIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetTileIndex() {
		return tileIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTileIndex(Variable newTileIndex) {
		Variable oldTileIndex = tileIndex;
		tileIndex = newTileIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnnotationPackage.TILE_LOOP_ANNOTATION__TILE_INDEX, oldTileIndex, tileIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntExpression getTileSize() {
		if (tileSize != null && tileSize.eIsProxy()) {
			InternalEObject oldTileSize = (InternalEObject)tileSize;
			tileSize = (IntExpression)eResolveProxy(oldTileSize);
			if (tileSize != oldTileSize) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AnnotationPackage.TILE_LOOP_ANNOTATION__TILE_SIZE, oldTileSize, tileSize));
			}
		}
		return tileSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntExpression basicGetTileSize() {
		return tileSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTileSize(IntExpression newTileSize) {
		IntExpression oldTileSize = tileSize;
		tileSize = newTileSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnnotationPackage.TILE_LOOP_ANNOTATION__TILE_SIZE, oldTileSize, tileSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntExpression getOffset() {
		if (offset != null && offset.eIsProxy()) {
			InternalEObject oldOffset = (InternalEObject)offset;
			offset = (IntExpression)eResolveProxy(oldOffset);
			if (offset != oldOffset) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AnnotationPackage.TILE_LOOP_ANNOTATION__OFFSET, oldOffset, offset));
			}
		}
		return offset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntExpression basicGetOffset() {
		return offset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOffset(IntExpression newOffset) {
		IntExpression oldOffset = offset;
		offset = newOffset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnnotationPackage.TILE_LOOP_ANNOTATION__OFFSET, oldOffset, offset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void accept(final ScopVisitor visitor) {
		visitor.visitTileLoopAnnotation(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AnnotationPackage.TILE_LOOP_ANNOTATION__TILE_INDEX:
				if (resolve) return getTileIndex();
				return basicGetTileIndex();
			case AnnotationPackage.TILE_LOOP_ANNOTATION__TILE_SIZE:
				if (resolve) return getTileSize();
				return basicGetTileSize();
			case AnnotationPackage.TILE_LOOP_ANNOTATION__OFFSET:
				if (resolve) return getOffset();
				return basicGetOffset();
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
			case AnnotationPackage.TILE_LOOP_ANNOTATION__TILE_INDEX:
				setTileIndex((Variable)newValue);
				return;
			case AnnotationPackage.TILE_LOOP_ANNOTATION__TILE_SIZE:
				setTileSize((IntExpression)newValue);
				return;
			case AnnotationPackage.TILE_LOOP_ANNOTATION__OFFSET:
				setOffset((IntExpression)newValue);
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
			case AnnotationPackage.TILE_LOOP_ANNOTATION__TILE_INDEX:
				setTileIndex((Variable)null);
				return;
			case AnnotationPackage.TILE_LOOP_ANNOTATION__TILE_SIZE:
				setTileSize((IntExpression)null);
				return;
			case AnnotationPackage.TILE_LOOP_ANNOTATION__OFFSET:
				setOffset((IntExpression)null);
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
			case AnnotationPackage.TILE_LOOP_ANNOTATION__TILE_INDEX:
				return tileIndex != null;
			case AnnotationPackage.TILE_LOOP_ANNOTATION__TILE_SIZE:
				return tileSize != null;
			case AnnotationPackage.TILE_LOOP_ANNOTATION__OFFSET:
				return offset != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case AnnotationPackage.TILE_LOOP_ANNOTATION___ACCEPT__SCOPVISITOR:
				accept((ScopVisitor)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //TileLoopAnnotationImpl
