package org.polymodel.scop.util;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.AbstractScopStatement;
import org.polymodel.scop.IScopAnnotation;
import org.polymodel.scop.ScopAssignment;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopGuard;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopStatementMacro;
import org.polymodel.scop.ScopUnscannedDomain;
import org.polymodel.scop.ScopVisitable;
import org.polymodel.scop.ScopVisitor;
import org.polymodel.scop.annotation.BarrierAnnotation;
import org.polymodel.scop.annotation.DescriptionAnnotation;
import org.polymodel.scop.annotation.ParallelBlockAnnotation;
import org.polymodel.scop.annotation.ParallelLoopAnnotation;
import org.polymodel.scop.annotation.PolyhedralDomainAnnotation;
import org.polymodel.scop.annotation.TileLoopAnnotation;

public class ScopDefaultVisitor extends EObjectImpl implements ScopVisitor {

	public void defaultIn(ScopVisitable node) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void defaultOut(ScopVisitable node) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void visitAbstractScopNode(AbstractScopNode a) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void inAbstractScopNode(AbstractScopNode a) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void outAbstractScopNode(AbstractScopNode a) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void visitIScopAnnotation(IScopAnnotation i) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void inIScopAnnotation(IScopAnnotation i) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void outIScopAnnotation(IScopAnnotation i) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void visitScopRoot(ScopRoot s) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void inScopRoot(ScopRoot s) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void outScopRoot(ScopRoot s) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void visitScopFor(ScopFor s) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void inScopFor(ScopFor s) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void outScopFor(ScopFor s) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void visitScopBlock(ScopBlock s) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void inScopBlock(ScopBlock s) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void outScopBlock(ScopBlock s) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void visitScopGuard(ScopGuard s) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void inScopGuard(ScopGuard s) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void outScopGuard(ScopGuard s) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void visitScopStatementMacro(ScopStatementMacro s) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void inScopStatementMacro(ScopStatementMacro s) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void outScopStatementMacro(ScopStatementMacro s) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void visitScopAssignment(ScopAssignment s) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void inScopAssignment(ScopAssignment s) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void outScopAssignment(ScopAssignment s) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void visitAbstractScopStatement(AbstractScopStatement a) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void inAbstractScopStatement(AbstractScopStatement a) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void outAbstractScopStatement(AbstractScopStatement a) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void visitParallelLoopAnnotation(ParallelLoopAnnotation p) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void inParallelLoopAnnotation(ParallelLoopAnnotation p) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void outParallelLoopAnnotation(ParallelLoopAnnotation p) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void visitDescriptionAnnotation(DescriptionAnnotation d) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void inDescriptionAnnotation(DescriptionAnnotation d) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void outDescriptionAnnotation(DescriptionAnnotation d) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void visitTileLoopAnnotation(TileLoopAnnotation t) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void inTileLoopAnnotation(TileLoopAnnotation t) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void outTileLoopAnnotation(TileLoopAnnotation t) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void visitParallelBlockAnnotation(ParallelBlockAnnotation p) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void inParallelBlockAnnotation(ParallelBlockAnnotation p) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void outParallelBlockAnnotation(ParallelBlockAnnotation p) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void visitPolyhedralDomainAnnotation(PolyhedralDomainAnnotation p) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void inPolyhedralDomainAnnotation(PolyhedralDomainAnnotation p) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void outPolyhedralDomainAnnotation(PolyhedralDomainAnnotation p) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void visitBarrierAnnotation(BarrierAnnotation b) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void inBarrierAnnotation(BarrierAnnotation b) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
		
	}

	public void outBarrierAnnotation(BarrierAnnotation b) {
		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void visitScopUnscannedDomain(ScopUnscannedDomain s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inScopUnscannedDomain(ScopUnscannedDomain s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void outScopUnscannedDomain(ScopUnscannedDomain s) {
		// TODO Auto-generated method stub
		
	}
}
