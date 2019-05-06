package org.polymodel.dataflow.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.polymodel.DimensionsManager;
import org.polymodel.Domain;
import org.polymodel.DomainDimensions;
import org.polymodel.Function;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.dataflow.ADAInput;
import org.polymodel.dataflow.ADAStatement;
import org.polymodel.dataflow.ReadAccess;
import org.polymodel.dataflow.WriteAccess;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.factory.PolymodelModule;

public class ADAInputConvert {
	
	@SuppressWarnings("unchecked")
	public static ADAInput convertGScopToPlainADA(ADAInput root, PolymodelModule module) {
		PolymodelDefaultFactory factory = PolymodelComponent.INSTANCE.getFactory(module);
		DimensionsManager		manager = factory.createDimensionsManager();
		
		
		
		ADAInput input = DataflowUserFactory.createADAInputStub(manager);
		
		for (ADAStatement oldStmt : root.getAdaStatements()) {
			Domain domain = convertGScopDomainToPlainDomain(oldStmt.getDomain(), manager, factory);
			Function schedule = convertGScopFunctionToPlainDomain(oldStmt.getIDSchedule(), manager, factory);
			ADAStatement newStmt = DataflowUserFactory.createADAStatementStub(input, oldStmt.getId(), domain, schedule);
			input.getAdaStatements().add(newStmt);
			
			for (ReadAccess read : oldStmt.getReads()) {
				EList<IntExpression> accessFunc = substituteDimensions(oldStmt.getDomain().getDimensions(), newStmt.getDomain().getDimensions(), read.getIndex());
				ReadAccess newAccess = DataflowUserFactory.createReadAccessStub(newStmt, accessFunc, read.getAccessId());
				((List<ReadAccess>)newStmt.getReads()).add(newAccess);
			}
			for (WriteAccess write : oldStmt.getWrites()) {
				EList<IntExpression> accessFunc = substituteDimensions(oldStmt.getDomain().getDimensions(), newStmt.getDomain().getDimensions(), write.getIndex());
				WriteAccess newAccess = DataflowUserFactory.createWriteAccessStub(newStmt, accessFunc, write.getAccessId());
				((List<WriteAccess>)newStmt.getWrites()).add(newAccess);
			}
		}
		
		return input;
	}
	
	private static Domain convertGScopDomainToPlainDomain(Domain dom, DimensionsManager manager, PolymodelDefaultFactory factory) {
		List<Variable> indices = new ArrayList<Variable>(dom.getNbIndices());
		List<Variable> parameters = new ArrayList<Variable>(dom.getNbParams());
		IntConstraintSystem[] systems = new IntConstraintSystem[dom.getPolyhedra().size()];
		
		for (int p=0; p < dom.getPolyhedra().size(); p++) {
			systems[p] = dom.getPolyhedra().get(p).copy();
		}
		
		for (int i = 0; i < dom.getNbParams(); i++) {
			parameters.add(manager.getParameter(i, dom.getParams().get(i).getName()));
			for (int p = 0; p < systems.length; p++) {
				systems[p] = systems[p].substitute(dom.getParams().get(i), parameters.get(i));
			}
		}

		for (int i = 0; i < dom.getNbIndices(); i++) {
			indices.add(manager.getDimension(i, dom.getIndices().get(i).getName()));
			for (int p = 0; p < systems.length; p++) {
				systems[p] = systems[p].substitute(dom.getIndices().get(i), indices.get(i));
			}
		}
		
		DomainDimensions dims = factory.createDomainDimensions(indices, parameters);
		
		return factory.createDomain(dims, systems);
	}

	private static Function convertGScopFunctionToPlainDomain(Function f, DimensionsManager manager, PolymodelDefaultFactory factory) {
		List<Variable> indices = new ArrayList<Variable>(f.getIndices().size());
		List<Variable> parameters = new ArrayList<Variable>(f.getParameters().size());
		
		IntExpression[] exprs = new IntExpression[f.getDimRHS()];
		
		for (int p=0; p < f.getDimRHS(); p++) {
			exprs[p] = f.getExpression(p);
		}
		
		for (int i = 0; i < f.getParameters().size(); i++) {
			parameters.add(manager.getParameter(i, f.getParameters().get(i).getName()));
			for (int p = 0; p < exprs.length; p++) {
				exprs[p] = exprs[p].substitute(f.getParameters().get(i), parameters.get(i));
			}
		}
		for (int i = 0; i < f.getIndices().size(); i++) {
			indices.add(manager.getDimension(i, f.getIndices().get(i).getName()));
			for (int p = 0; p < exprs.length; p++) {
				exprs[p] = exprs[p].substitute(f.getIndices().get(i), indices.get(i));
			}
		}
		
		DomainDimensions dims = factory.createDomainDimensions(indices, parameters);
		
		return factory.createFunction(dims, Arrays.asList(exprs));
	}
	
	private static EList<IntExpression> substituteDimensions(DomainDimensions oldDims, DomainDimensions newDims, List<IntExpression> oldExprs) {
		assert(oldDims.getIndices().size() == newDims.getIndices().size());
		assert(oldDims.getParameters().size() == newDims.getParameters().size());
		
		EList<IntExpression> exprs = new BasicEList<IntExpression>(oldExprs.size());
		for (IntExpression expr : oldExprs) {
			exprs.add(expr.copy());
		}
		
		for (int i = 0; i < exprs.size(); i++) {
			for (int p = 0; p < oldDims.getParameters().size(); p++) {
				exprs.set(i, exprs.get(i).substitute(oldDims.getParameters().get(p), newDims.getParameters().get(p)));
			}
			for (int p = 0; p < oldDims.getIndices().size(); p++) {
				exprs.set(i, exprs.get(i).substitute(oldDims.getIndices().get(p), newDims.getIndices().get(p)));
			}
		}
		
		return exprs;
	}
}
