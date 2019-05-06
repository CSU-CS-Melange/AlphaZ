package org.polymodel.dataflow.stubs;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.algebra.IntExpression;
import org.polymodel.dataflow.ADAStatement;
import org.polymodel.dataflow.ReadAccess;
import org.polymodel.dataflow.WriteAccess;

public class WriteAccessStub extends EObjectImpl implements WriteAccess {
	
	private EList<IntExpression> index;
	private String accessId;
	private ADAStatement parent;
	
	public WriteAccessStub(EList<IntExpression> index, String accessId) {
		this.index = index;
		this.accessId = accessId;
	}
	
	public WriteAccessStub(WriteAccess w) {
		this.accessId = w.getAccessId();
		this.index = new BasicEList<IntExpression>(w.getIndex().size());
		for (IntExpression e : w.getIndex()) {
			this.index.add(e.copy());
		}
	}

	public EList<IntExpression> getIndex() {
		return this.index;
	}

	public String getAccessId() {
		return this.accessId;
	}

	public ADAStatement getParentADAStatement() {
		return this.parent;
	}

	public void setParentADAStatement(ADAStatement value) {
		this.parent = value;
	}
	
	public EList<ReadAccess> getAllReadCandidates() {
		EList<ReadAccess> res = new BasicEList<ReadAccess>();
		String st = this.getAccessId();
		for (ADAStatement s : this.getParentADAStatement().getParentADAInput().getAdaStatements()) {
			for (ReadAccess r : s.getReads()) {
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
		return true;
	}
}