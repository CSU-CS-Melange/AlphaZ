/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.isl;

import org.polymodel.Relation;
import org.polymodel.algebra.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ISL Map</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.polymodel.isl.IslPackage#getISLMap()
 * @model
 * @generated
 */
public interface ISLMap extends Relation {
	ISLMap union(ISLMap m);
	ISLMap difference(ISLMap m);
	ISLMap intersection(ISLMap m);
	ISLMap product(ISLMap m);
	
	ISLMap lexmin();
	ISLMap lexmax();
	ISLMap projection(Variable... dimensions);
	
	
	
	ISLBasicMap affineHull();
	ISLBasicMap convexHull();
	
	boolean isSubset(ISLMap m);
} // ISLMap
