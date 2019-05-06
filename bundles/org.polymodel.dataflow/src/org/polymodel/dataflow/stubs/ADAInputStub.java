package org.polymodel.dataflow.stubs;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.DimensionsManager;
import org.polymodel.dataflow.ADAInput;
import org.polymodel.dataflow.ADAStatement;

public class ADAInputStub extends EObjectImpl implements ADAInput {

	private DimensionsManager manager;
	private EList<ADAStatement> statements;
	
	public ADAInputStub(DimensionsManager manager, EList<ADAStatement> statements) {
		this.manager = manager;
		this.statements = statements;
	}

	/**
	 * Constructor to build a copy of the original ADAInput, but using Stubs.
	 * Mainly used to transform the ADAInput without impacting the underlying
	 * structure when manipulating classes that inherits ADAInput.
	 * 
	 * @param manager
	 * @param original
	 */
	public ADAInputStub(ADAInput original) {
		this.manager = original.getDimensionsManager();
		this.statements = new BasicEList<ADAStatement>(original.getAdaStatements().size());
		for (ADAStatement s : original.getAdaStatements()) {
			ADAStatementStub adaStatementStub = new ADAStatementStub(s);
			adaStatementStub.setParentADAInput(this);
			statements.add(adaStatementStub);
		}
	}
	
	public EList<ADAStatement> getAdaStatements() {
		return this.statements;
	}

	public DimensionsManager getDimensionsManager() {
		return this.manager;
	}

	@Override
	public String toString() {
		StringBuffer res = new StringBuffer("ADAInput : \n");
		for (ADAStatement s : this.getAdaStatements()) {
			res.append(s.toString());
		}
		return res.toString();
	}

	public ADAStatement getStatementByID(int id) {
		if (id >= this.getAdaStatements().size())
			throw new IllegalArgumentException("ID can not be greater than the number of statements.");
		for (ADAStatement stmt : this.getAdaStatements()) {
			if (stmt.getId() == id) return stmt;
		}
		throw new RuntimeException("No statement found with ID = "+id);
	}
	
	public boolean isResolved() {
		for (ADAStatement stmt : this.getAdaStatements())
			if (!stmt.isResolved())
				return false;
		return true;
	}
}