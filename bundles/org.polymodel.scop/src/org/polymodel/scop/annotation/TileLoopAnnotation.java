/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop.annotation;

import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.scop.IScopAnnotation;
import org.polymodel.scop.ScopVisitable;
import org.polymodel.scop.ScopVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tile Loop Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polymodel.scop.annotation.TileLoopAnnotation#getTileIndex <em>Tile Index</em>}</li>
 *   <li>{@link org.polymodel.scop.annotation.TileLoopAnnotation#getTileSize <em>Tile Size</em>}</li>
 *   <li>{@link org.polymodel.scop.annotation.TileLoopAnnotation#getOffset <em>Offset</em>}</li>
 * </ul>
 *
 * @see org.polymodel.scop.annotation.AnnotationPackage#getTileLoopAnnotation()
 * @model
 * @generated
 */
public interface TileLoopAnnotation extends IScopAnnotation, ScopVisitable {
	/**
	 * Returns the value of the '<em><b>Tile Index</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tile Index</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tile Index</em>' reference.
	 * @see #setTileIndex(Variable)
	 * @see org.polymodel.scop.annotation.AnnotationPackage#getTileLoopAnnotation_TileIndex()
	 * @model required="true"
	 * @generated
	 */
	Variable getTileIndex();

	/**
	 * Sets the value of the '{@link org.polymodel.scop.annotation.TileLoopAnnotation#getTileIndex <em>Tile Index</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tile Index</em>' reference.
	 * @see #getTileIndex()
	 * @generated
	 */
	void setTileIndex(Variable value);

	/**
	 * Returns the value of the '<em><b>Tile Size</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tile Size</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tile Size</em>' reference.
	 * @see #setTileSize(IntExpression)
	 * @see org.polymodel.scop.annotation.AnnotationPackage#getTileLoopAnnotation_TileSize()
	 * @model required="true"
	 * @generated
	 */
	IntExpression getTileSize();

	/**
	 * Sets the value of the '{@link org.polymodel.scop.annotation.TileLoopAnnotation#getTileSize <em>Tile Size</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tile Size</em>' reference.
	 * @see #getTileSize()
	 * @generated
	 */
	void setTileSize(IntExpression value);

	/**
	 * Returns the value of the '<em><b>Offset</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset</em>' reference.
	 * @see #setOffset(IntExpression)
	 * @see org.polymodel.scop.annotation.AnnotationPackage#getTileLoopAnnotation_Offset()
	 * @model
	 * @generated
	 */
	IntExpression getOffset();

	/**
	 * Sets the value of the '{@link org.polymodel.scop.annotation.TileLoopAnnotation#getOffset <em>Offset</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' reference.
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(IntExpression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='visitor.visitTileLoopAnnotation(this);'"
	 * @generated
	 */
	void accept(ScopVisitor visitor);

} // TileLoopAnnotation
