package org.polymodel.dataflow.stubs;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.algebra.IntExpression;
import org.polymodel.dataflow.ADAInput;
import org.polymodel.dataflow.ADASolution;
import org.polymodel.dataflow.ADAStatement;
import org.polymodel.dataflow.ReadAccess;
import org.polymodel.dataflow.WriteAccess;

public class ReadAccessStub extends EObjectImpl implements ReadAccess {

	private EList<IntExpression> index;
	private String accessId;
	private ADASolution lastWrite;
	private ADAStatement parent;
	
	public ReadAccessStub(EList<IntExpression> index, String accessId) {
		this.index = index;
		this.accessId = accessId;
		this.lastWrite = null;
	}
	
	public ReadAccessStub(ReadAccess r) {
		this.accessId = r.getAccessId();
		this.index = new BasicEList<IntExpression>(r.getIndex().size());
		for (IntExpression e : r.getIndex()) {
			this.index.add(e.copy());
		}
	}

	public EList<IntExpression> getIndex() {
		return this.index;
	}

	public String getAccessId() {
		return this.accessId;
	}

	public ADASolution getLastWrite() {
		return this.lastWrite;
	}

	public void setLastWrite(ADASolution value) {
		this.lastWrite = value;
	}

	public ADAStatement getParentADAStatement() {
		return this.parent;
	}

	public void setParentADAStatement(ADAStatement value) {
		this.parent = value;
	}

	public EList<WriteAccess> getAllWriteCandidates() {
		EList<WriteAccess> res = new BasicEList<WriteAccess>();
		String st = this.getAccessId();
		ADAStatement parentADAStatement = this.getParentADAStatement();
		ADAInput parentADAInput = parentADAStatement.getParentADAInput();
		EList<ADAStatement> adaStatements = parentADAInput.getAdaStatements();
		for (ADAStatement s : adaStatements) {
			for (WriteAccess r : s.getWrites()) {
				if (r.getAccessId().compareTo(st)==0) res.add(r);
			}
		}
		return res;
	}

	@Override
	public String toString() {
		return this.getAccessId()+this.getIndex();
	}

	public boolean isResolved() {
		return this.getLastWrite() != null;
	}
}