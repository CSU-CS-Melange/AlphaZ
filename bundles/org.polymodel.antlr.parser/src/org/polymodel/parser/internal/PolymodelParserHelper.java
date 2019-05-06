package org.polymodel.parser.internal;

import java.util.List;

import org.polymodel.Domain;
import org.polymodel.Relation;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.Variable;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.factory.PolymodelDefaultFactory;

public class PolymodelParserHelper {

	static PolymodelDefaultFactory factory = PolymodelComponent.INSTANCE.getFactory();
	
	public static Domain domain(List<Variable> paramIds,List<Variable> setIds,List<IntConstraintSystem> systemUnion) {
		return factory.createDomain(setIds,paramIds, systemUnion.toArray(new IntConstraintSystem[systemUnion.size()]));
	}

	public static Relation relation(List<Variable> params,List<Variable> in, List<Variable> out, List<IntConstraintSystem> systemUnion) {
//		RelationDimensions rdims = factory.createRelationDimensions(inputs(i, j), outputs(i));
		return null;
	}

}
