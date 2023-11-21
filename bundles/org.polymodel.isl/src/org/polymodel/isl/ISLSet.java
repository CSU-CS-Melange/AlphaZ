/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.isl;

import java.util.List;
import java.util.Map;

import org.polymodel.DimensionsManager;
import org.polymodel.Domain;

import fr.irisa.cairn.jnimap.isl.jni.ISL_FORMAT;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSet;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>ISL Set</b></em>'. <!-- end-user-doc -->
 *
 *
 * @see org.polymodel.isl.IslPackage#getISLSet()
 * @model
 * @generated
 */
public interface ISLSet extends Domain {

	ISLSet coalesce();

	//already declared in superclass Domain
//	ISLSet lexmin(); //see lexMax
//	ISLSet lexmax(); //see lexMin

	public Map<ISLSet,ISLFunction> lexminFunction(DimensionsManager manager);


	ISLSet lift();


	ISLSet gist(ISLSet set);

	ISLSet boundedSimpleHull();

	ISLSet convexHull();

	int getNumberOfPoints();

	List<ISLPoint> getPoints();

	ISLSet project(int first, int n);

	String toString(ISL_FORMAT format);

	ISLMap getMapFromDomain(DimensionsManager manager);

	ISLMap getMapFromRange(DimensionsManager manager);

	ISLMap nextRelation(int depth, DimensionsManager manager);

	ISLMap nextRelation(int depth, int power, DimensionsManager manager);
	
	JNIISLSet getJNIset(); 
	
	Map<ISLSet,ISLFunction> next(int depth, DimensionsManager manager);

	Map<ISLSet,ISLFunction> next(int depth, int power, DimensionsManager manager);

	Map<ISLSet, ISLFunction> gnext(int coalescingdepth,
			DimensionsManager dimensionsManager);
	
	Map<ISLSet, ISLFunction> gnext(int coalescingdepth, int power,
			DimensionsManager dimensionsManager);
} // ISLSet
