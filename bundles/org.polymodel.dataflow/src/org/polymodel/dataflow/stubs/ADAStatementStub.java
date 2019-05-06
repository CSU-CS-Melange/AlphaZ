package org.polymodel.dataflow.stubs;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.Domain;
import org.polymodel.Function;
import org.polymodel.dataflow.ADAInput;
import org.polymodel.dataflow.ADAStatement;
import org.polymodel.dataflow.Access;
import org.polymodel.dataflow.ReadAccess;
import org.polymodel.dataflow.WriteAccess;

public class ADAStatementStub extends EObjectImpl implements ADAStatement {

	private int id;
	private EList<WriteAccess> wAcesses;
	private EList<ReadAccess> rAccesses;
	private ADAInput parent;
	private Domain domain;
	private Function idSchedule;
	
	public ADAStatementStub() {
		throw new RuntimeException();
	}
	
	public ADAStatementStub(ADAInput parent, int id, Domain domain, Function idSchedule) {
		this.parent = parent;
		this.id = id;
		this.domain = domain;
		this.idSchedule = idSchedule;
		this.wAcesses = new BasicEList<>();
		this.rAccesses = new BasicEList<>();
	}
	
	public ADAStatementStub(int id, EList<WriteAccess> wAcesses, EList<ReadAccess> rAccesses, Domain domain, Function idSchedule) {
		this.id = id;
		this.wAcesses = wAcesses;
		this.rAccesses = rAccesses;
		this.domain = domain;
		this.idSchedule = idSchedule;
	}
	
	public ADAStatementStub(ADAStatement s) {
		this.id = s.getId();
		this.wAcesses = new BasicEList<WriteAccess>(s.getWrites().size());
		this.rAccesses = new BasicEList<ReadAccess>(s.getReads().size());
		for (WriteAccess w : s.getWrites()) {
			WriteAccess nw = new WriteAccessStub(w);
			nw.setParentADAStatement(this);
			wAcesses.add(nw);
		}
		for (ReadAccess r : s.getReads()) {
			ReadAccess nr = new ReadAccessStub(r);
			nr.setParentADAStatement(this);
			rAccesses.add(nr);
		}
		this.domain = s.getDomain();
		this.idSchedule = s.getIDSchedule();
		
	}

	public int getId() {
		return this.id;
	}

	public void setId(int value) {
		this.id = value;
	}

	public EList<WriteAccess> getWrites() {
		return this.wAcesses;
	}

	public EList<ReadAccess> getReads() {
		return this.rAccesses;
	}

	public ADAInput getParentADAInput() {
		return this.parent;
	}

	public void setParentADAInput(ADAInput value) {
		this.parent = value;
	}

	public Domain getDomain() {
		return this.domain;
	}

	public Function getIDSchedule() {
		return this.idSchedule;
	}

	@Override
	public String toString() {
		StringBuffer res = new StringBuffer();
		res.append("Statement S"+this.getId()+" :\n");
		res.append("  - domain : "+this.getDomain()+";\n");
		res.append("  - ID schedule : "+this.getIDSchedule()+";\n");
		res.append("  - Accesses : writes"+this.getWrites()+"; reads"+this.getReads()+";\n");
		return res.toString();
	}

	public boolean isResolved() {
		for (Access a : this.getReads())
			if (!a.isResolved())
				return false;
		for (Access a : this.getWrites())
			if (!a.isResolved())
				return false;
		return true;
	}
}