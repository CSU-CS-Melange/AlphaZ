package org.polymodel.dataflow.util;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.DimensionsManager;
import org.polymodel.Domain;
import org.polymodel.Function;
import org.polymodel.algebra.IntExpression;
import org.polymodel.dataflow.ADAInput;
import org.polymodel.dataflow.ADASolution;
import org.polymodel.dataflow.ADAStatement;
import org.polymodel.dataflow.Access;
import org.polymodel.dataflow.DataflowFactory;
import org.polymodel.dataflow.ReadAccess;
import org.polymodel.dataflow.ResolvedAccess;
import org.polymodel.dataflow.WriteAccess;
import org.polymodel.dataflow.stubs.ADAInputStub;
import org.polymodel.dataflow.stubs.ADAStatementStub;
import org.polymodel.dataflow.stubs.ReadAccessStub;
import org.polymodel.dataflow.stubs.WriteAccessStub;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.factory.PolymodelDefaultFactory;

public class DataflowUserFactory {

	public static DataflowFactory factory = DataflowFactory.eINSTANCE;
	public static PolymodelDefaultFactory polymodelFactory = PolymodelComponent.INSTANCE.getFactory();
	
	public static ADASolution bottomADASolution(Access a) {
		ADASolution res = factory.createADASolution();

		//If whole ADASolution is bottom, the validity domain is the whole access' statement domain.
		Domain validityDomain =  polymodelFactory.createDomain(a.getParentADAStatement().getDomain());
		
		ResolvedAccess ra = bottomResolvedAccess(a,validityDomain);
		res.getResolvedAccesses().add(ra);
		
		return res;
	}
	
	public static ResolvedAccess bottomResolvedAccess(Access a, Domain validityDomain) {
		ResolvedAccess res = factory.createResolvedAccess();
		
		//first get to initialize the list, but keep it empty
		res.getIterationVector();
		//no corresponding access
		res.setAccess(null);
		
		res.setValidityDomain(validityDomain);
		
		return res;
	}
	
	public static ResolvedAccess resolvedAccess(Access a, Domain validityDomain, List<IntExpression> iterationVector) {
		ResolvedAccess res = factory.createResolvedAccess();
		
		res.setAccess(a);
		res.setValidityDomain(validityDomain);
		for (IntExpression expr : iterationVector) {
			res.getIterationVector().add(expr.simplify());
		}
		
		return res;
	}

	public static ADASolution adaSolution(List<ResolvedAccess> resolvedAccesses) {
		ADASolution res = factory.createADASolution();
		res.getResolvedAccesses().addAll(resolvedAccesses);
		return res;
	}
	
	public static ADAInputStub createADAInputStub(DimensionsManager manager) {
		return new ADAInputStub(manager, new BasicEList<ADAStatement>());
	}
	
	public static ADAStatement createADAStatementStub(ADAInput parent, int id, Domain domain, Function idSchedule) {
		return new ADAStatementStub(parent, id, domain, idSchedule);
	}

	
	public static WriteAccess createWriteAccessStub(ADAStatement parent, EList<IntExpression> index, String accessId) {
		WriteAccess write = new WriteAccessStub(index, accessId);
		write.setParentADAStatement(parent);
		return write;
	}

	public static ReadAccess createReadAccessStub(ADAStatement parent, EList<IntExpression> index, String accessId) {
		ReadAccess read = new ReadAccessStub(index, accessId);
		read.setParentADAStatement(parent);
		return read;
	}
	
	
	
}
