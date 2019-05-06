/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.isl.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.polymodel.DimensionsManager;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.isl.ISLMap;
import org.polymodel.isl.ISLUnionMap;
import org.polymodel.isl.ISLUnionSet;
import org.polymodel.isl.IslPackage;
import org.polymodel.isl.factory.ISLNativeBinder;
import org.polymodel.prettyprinters.PolymodelPrettyPrinter;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLUnionMap;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ISL Union Map</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polymodel.isl.impl.ISLUnionMapImpl#getMaps <em>Maps</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ISLUnionMapImpl extends EObjectImpl implements ISLUnionMap {
	/**
	 * The cached value of the '{@link #getMaps() <em>Maps</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaps()
	 * @generated
	 * @ordered
	 */
	protected EList<ISLMap> maps;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ISLUnionMapImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IslPackage.Literals.ISL_UNION_MAP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ISLMap> getMaps() {
		if (maps == null) {
			maps = new EObjectResolvingEList<ISLMap>(ISLMap.class, this, IslPackage.ISL_UNION_MAP__MAPS);
		}
		return maps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ISLUnionMap lexMax(DimensionsManager manager) {

		
		List<JNIISLMap> maps = new ArrayList<JNIISLMap>();
		for (ISLMap map : getMaps()) {
			maps.add(ISLNativeBinder.jniIslMap(map));
		}
		
		JNIISLUnionMap umap = null;
		for (JNIISLMap map : maps) {
			if (umap == null)
				umap = map.toUnionMap();
			else
				umap = umap.union(map.toUnionMap());
		}
		
		return ISLNativeBinder.islUnionMap(umap.lexMin(), manager);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IslPackage.ISL_UNION_MAP__MAPS:
				return getMaps();
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
			case IslPackage.ISL_UNION_MAP__MAPS:
				getMaps().clear();
				getMaps().addAll((Collection<? extends ISLMap>)newValue);
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
			case IslPackage.ISL_UNION_MAP__MAPS:
				getMaps().clear();
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
			case IslPackage.ISL_UNION_MAP__MAPS:
				return maps != null && !maps.isEmpty();
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
			case IslPackage.ISL_UNION_MAP___LEX_MAX__DIMENSIONSMANAGER:
				return lexMax((DimensionsManager)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	public ISLUnionMap plutoScheduling(ISLUnionSet domains) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public String toString() {
		if (getMaps().size() == 0) {
			return "[]->{}";
		}
		
		StringBuffer sb = new StringBuffer("[");
		
		sb.append(toStringList(getMaps().get(0).getDimensions().getParameters()));
		
		sb.append("]");
		sb.append(" -> ");
		sb.append("{");

		Pattern pattern = Pattern.compile("(\\[.*\\]\\s*->\\s*)?\\{(.+)\\}");
		for (ISLMap map : getMaps()) {
			String mapStr = PolymodelPrettyPrinter.print(map, OUTPUT_FORMAT.ISL);
			Matcher matcher = pattern.matcher(mapStr);
			if (matcher.matches()) {
				String relationStr = matcher.group(2);
				sb.append(" ");
				sb.append(relationStr);
				sb.append(";");
			} else {
				throw new RuntimeException("Unexpected result of pretty printing a map : " + mapStr);
			}
		}
		sb.append(" }");
		
		return sb.toString();
	}
	
	private String toStringList(List<Variable> vars) {
		StringBuffer sb = new StringBuffer();
		
		for (Variable var : vars) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			sb.append(var);
		}
		
		return sb.toString();
	}

} //ISLUnionMapImpl
