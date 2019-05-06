/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.scop.AbstractScopNode;
import org.polymodel.scop.AbstractScopStatement;
import org.polymodel.scop.IScopAnnotation;
import org.polymodel.scop.ScopAssignment;
import org.polymodel.scop.ScopBlock;
import org.polymodel.scop.ScopDepthFirstVisitor;
import org.polymodel.scop.ScopFor;
import org.polymodel.scop.ScopGuard;
import org.polymodel.scop.ScopPackage;
import org.polymodel.scop.ScopRoot;
import org.polymodel.scop.ScopStatementMacro;
import org.polymodel.scop.ScopUnscannedDomain;
import org.polymodel.scop.ScopVisitable;
import org.polymodel.scop.annotation.BarrierAnnotation;
import org.polymodel.scop.annotation.DescriptionAnnotation;
import org.polymodel.scop.annotation.ParallelBlockAnnotation;
import org.polymodel.scop.annotation.ParallelLoopAnnotation;
import org.polymodel.scop.annotation.PolyhedralDomainAnnotation;
import org.polymodel.scop.annotation.TileLoopAnnotation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Depth First Visitor</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ScopDepthFirstVisitorImpl extends EObjectImpl implements ScopDepthFirstVisitor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScopDepthFirstVisitorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScopPackage.Literals.SCOP_DEPTH_FIRST_VISITOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void defaultIn(final ScopVisitable node) {
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void defaultOut(final ScopVisitable node) {
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAbstractScopNode(final AbstractScopNode a) {
		inAbstractScopNode(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);
		outAbstractScopNode(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAbstractScopNode(final AbstractScopNode a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAbstractScopNode(final AbstractScopNode a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitIScopAnnotation(final IScopAnnotation i) {
		inIScopAnnotation(i);
		for (EObject obj : i.eContents()) 
			if (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);
		outIScopAnnotation(i);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inIScopAnnotation(final IScopAnnotation i) {
		defaultIn(i);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outIScopAnnotation(final IScopAnnotation i) {
		defaultOut(i);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitScopRoot(final ScopRoot s) {
		inScopRoot(s);
		for (EObject obj : s.eContents()) 
			if (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);
		outScopRoot(s);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inScopRoot(final ScopRoot s) {
		defaultIn(s);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outScopRoot(final ScopRoot s) {
		defaultOut(s);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitScopFor(final ScopFor s) {
		inScopFor(s);
		for (EObject obj : s.eContents()) 
			if (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);
		outScopFor(s);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inScopFor(final ScopFor s) {
		defaultIn(s);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outScopFor(final ScopFor s) {
		defaultOut(s);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitScopBlock(final ScopBlock s) {
		inScopBlock(s);
		for (EObject obj : s.eContents()) 
			if (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);
		outScopBlock(s);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inScopBlock(final ScopBlock s) {
		defaultIn(s);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outScopBlock(final ScopBlock s) {
		defaultOut(s);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitScopGuard(final ScopGuard s) {
		inScopGuard(s);
		for (EObject obj : s.eContents()) 
			if (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);
		outScopGuard(s);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inScopGuard(final ScopGuard s) {
		defaultIn(s);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outScopGuard(final ScopGuard s) {
		defaultOut(s);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitScopStatementMacro(final ScopStatementMacro s) {
		inScopStatementMacro(s);
		for (EObject obj : s.eContents()) 
			if (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);
		outScopStatementMacro(s);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inScopStatementMacro(final ScopStatementMacro s) {
		defaultIn(s);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outScopStatementMacro(final ScopStatementMacro s) {
		defaultOut(s);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitScopAssignment(final ScopAssignment s) {
		inScopAssignment(s);
		for (EObject obj : s.eContents()) 
			if (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);
		outScopAssignment(s);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inScopAssignment(final ScopAssignment s) {
		defaultIn(s);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outScopAssignment(final ScopAssignment s) {
		defaultOut(s);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAbstractScopStatement(final AbstractScopStatement a) {
		inAbstractScopStatement(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);
		outAbstractScopStatement(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAbstractScopStatement(final AbstractScopStatement a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAbstractScopStatement(final AbstractScopStatement a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitParallelLoopAnnotation(final ParallelLoopAnnotation p) {
		inParallelLoopAnnotation(p);
		for (EObject obj : p.eContents()) 
			if (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);
		outParallelLoopAnnotation(p);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inParallelLoopAnnotation(final ParallelLoopAnnotation p) {
		defaultIn(p);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outParallelLoopAnnotation(final ParallelLoopAnnotation p) {
		defaultOut(p);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitDescriptionAnnotation(final DescriptionAnnotation d) {
		inDescriptionAnnotation(d);
		for (EObject obj : d.eContents()) 
			if (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);
		outDescriptionAnnotation(d);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inDescriptionAnnotation(final DescriptionAnnotation d) {
		defaultIn(d);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outDescriptionAnnotation(final DescriptionAnnotation d) {
		defaultOut(d);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitTileLoopAnnotation(final TileLoopAnnotation t) {
		inTileLoopAnnotation(t);
		for (EObject obj : t.eContents()) 
			if (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);
		outTileLoopAnnotation(t);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inTileLoopAnnotation(final TileLoopAnnotation t) {
		defaultIn(t);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outTileLoopAnnotation(final TileLoopAnnotation t) {
		defaultOut(t);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitParallelBlockAnnotation(final ParallelBlockAnnotation p) {
		inParallelBlockAnnotation(p);
		for (EObject obj : p.eContents()) 
			if (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);
		outParallelBlockAnnotation(p);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inParallelBlockAnnotation(final ParallelBlockAnnotation p) {
		defaultIn(p);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outParallelBlockAnnotation(final ParallelBlockAnnotation p) {
		defaultOut(p);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitPolyhedralDomainAnnotation(final PolyhedralDomainAnnotation p) {
		inPolyhedralDomainAnnotation(p);
		for (EObject obj : p.eContents()) 
			if (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);
		outPolyhedralDomainAnnotation(p);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inPolyhedralDomainAnnotation(final PolyhedralDomainAnnotation p) {
		defaultIn(p);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outPolyhedralDomainAnnotation(final PolyhedralDomainAnnotation p) {
		defaultOut(p);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitBarrierAnnotation(final BarrierAnnotation b) {
		inBarrierAnnotation(b);
		for (EObject obj : b.eContents()) 
			if (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);
		outBarrierAnnotation(b);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inBarrierAnnotation(final BarrierAnnotation b) {
		defaultIn(b);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outBarrierAnnotation(final BarrierAnnotation b) {
		defaultOut(b);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitScopUnscannedDomain(final ScopUnscannedDomain s) {
		inScopUnscannedDomain(s);
		for (EObject obj : s.eContents()) 
			if (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);
		outScopUnscannedDomain(s);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inScopUnscannedDomain(final ScopUnscannedDomain s) {
		defaultIn(s);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outScopUnscannedDomain(final ScopUnscannedDomain s) {
		defaultOut(s);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___DEFAULT_IN__SCOPVISITABLE:
				defaultIn((ScopVisitable)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___DEFAULT_OUT__SCOPVISITABLE:
				defaultOut((ScopVisitable)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___VISIT_ABSTRACT_SCOP_NODE__ABSTRACTSCOPNODE:
				visitAbstractScopNode((AbstractScopNode)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___IN_ABSTRACT_SCOP_NODE__ABSTRACTSCOPNODE:
				inAbstractScopNode((AbstractScopNode)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___OUT_ABSTRACT_SCOP_NODE__ABSTRACTSCOPNODE:
				outAbstractScopNode((AbstractScopNode)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___VISIT_ISCOP_ANNOTATION__ISCOPANNOTATION:
				visitIScopAnnotation((IScopAnnotation)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___IN_ISCOP_ANNOTATION__ISCOPANNOTATION:
				inIScopAnnotation((IScopAnnotation)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___OUT_ISCOP_ANNOTATION__ISCOPANNOTATION:
				outIScopAnnotation((IScopAnnotation)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_ROOT__SCOPROOT:
				visitScopRoot((ScopRoot)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_ROOT__SCOPROOT:
				inScopRoot((ScopRoot)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_ROOT__SCOPROOT:
				outScopRoot((ScopRoot)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_FOR__SCOPFOR:
				visitScopFor((ScopFor)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_FOR__SCOPFOR:
				inScopFor((ScopFor)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_FOR__SCOPFOR:
				outScopFor((ScopFor)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_BLOCK__SCOPBLOCK:
				visitScopBlock((ScopBlock)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_BLOCK__SCOPBLOCK:
				inScopBlock((ScopBlock)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_BLOCK__SCOPBLOCK:
				outScopBlock((ScopBlock)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_GUARD__SCOPGUARD:
				visitScopGuard((ScopGuard)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_GUARD__SCOPGUARD:
				inScopGuard((ScopGuard)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_GUARD__SCOPGUARD:
				outScopGuard((ScopGuard)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_STATEMENT_MACRO__SCOPSTATEMENTMACRO:
				visitScopStatementMacro((ScopStatementMacro)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_STATEMENT_MACRO__SCOPSTATEMENTMACRO:
				inScopStatementMacro((ScopStatementMacro)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_STATEMENT_MACRO__SCOPSTATEMENTMACRO:
				outScopStatementMacro((ScopStatementMacro)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_UNSCANNED_DOMAIN__SCOPUNSCANNEDDOMAIN_1:
				visitScopUnscannedDomain((ScopUnscannedDomain)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_UNSCANNED_DOMAIN__SCOPUNSCANNEDDOMAIN_1:
				inScopUnscannedDomain((ScopUnscannedDomain)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_UNSCANNED_DOMAIN__SCOPUNSCANNEDDOMAIN_1:
				outScopUnscannedDomain((ScopUnscannedDomain)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___VISIT_SCOP_ASSIGNMENT__SCOPASSIGNMENT:
				visitScopAssignment((ScopAssignment)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___IN_SCOP_ASSIGNMENT__SCOPASSIGNMENT:
				inScopAssignment((ScopAssignment)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___OUT_SCOP_ASSIGNMENT__SCOPASSIGNMENT:
				outScopAssignment((ScopAssignment)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___VISIT_ABSTRACT_SCOP_STATEMENT__ABSTRACTSCOPSTATEMENT:
				visitAbstractScopStatement((AbstractScopStatement)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___IN_ABSTRACT_SCOP_STATEMENT__ABSTRACTSCOPSTATEMENT:
				inAbstractScopStatement((AbstractScopStatement)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___OUT_ABSTRACT_SCOP_STATEMENT__ABSTRACTSCOPSTATEMENT:
				outAbstractScopStatement((AbstractScopStatement)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___VISIT_PARALLEL_LOOP_ANNOTATION__PARALLELLOOPANNOTATION:
				visitParallelLoopAnnotation((ParallelLoopAnnotation)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___IN_PARALLEL_LOOP_ANNOTATION__PARALLELLOOPANNOTATION:
				inParallelLoopAnnotation((ParallelLoopAnnotation)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___OUT_PARALLEL_LOOP_ANNOTATION__PARALLELLOOPANNOTATION:
				outParallelLoopAnnotation((ParallelLoopAnnotation)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___VISIT_DESCRIPTION_ANNOTATION__DESCRIPTIONANNOTATION:
				visitDescriptionAnnotation((DescriptionAnnotation)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___IN_DESCRIPTION_ANNOTATION__DESCRIPTIONANNOTATION:
				inDescriptionAnnotation((DescriptionAnnotation)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___OUT_DESCRIPTION_ANNOTATION__DESCRIPTIONANNOTATION:
				outDescriptionAnnotation((DescriptionAnnotation)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___VISIT_TILE_LOOP_ANNOTATION__TILELOOPANNOTATION:
				visitTileLoopAnnotation((TileLoopAnnotation)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___IN_TILE_LOOP_ANNOTATION__TILELOOPANNOTATION:
				inTileLoopAnnotation((TileLoopAnnotation)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___OUT_TILE_LOOP_ANNOTATION__TILELOOPANNOTATION:
				outTileLoopAnnotation((TileLoopAnnotation)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___VISIT_PARALLEL_BLOCK_ANNOTATION__PARALLELBLOCKANNOTATION:
				visitParallelBlockAnnotation((ParallelBlockAnnotation)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___IN_PARALLEL_BLOCK_ANNOTATION__PARALLELBLOCKANNOTATION:
				inParallelBlockAnnotation((ParallelBlockAnnotation)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___OUT_PARALLEL_BLOCK_ANNOTATION__PARALLELBLOCKANNOTATION:
				outParallelBlockAnnotation((ParallelBlockAnnotation)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___VISIT_POLYHEDRAL_DOMAIN_ANNOTATION__POLYHEDRALDOMAINANNOTATION:
				visitPolyhedralDomainAnnotation((PolyhedralDomainAnnotation)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___IN_POLYHEDRAL_DOMAIN_ANNOTATION__POLYHEDRALDOMAINANNOTATION:
				inPolyhedralDomainAnnotation((PolyhedralDomainAnnotation)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___OUT_POLYHEDRAL_DOMAIN_ANNOTATION__POLYHEDRALDOMAINANNOTATION:
				outPolyhedralDomainAnnotation((PolyhedralDomainAnnotation)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___VISIT_BARRIER_ANNOTATION__BARRIERANNOTATION:
				visitBarrierAnnotation((BarrierAnnotation)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___IN_BARRIER_ANNOTATION__BARRIERANNOTATION:
				inBarrierAnnotation((BarrierAnnotation)arguments.get(0));
				return null;
			case ScopPackage.SCOP_DEPTH_FIRST_VISITOR___OUT_BARRIER_ANNOTATION__BARRIERANNOTATION:
				outBarrierAnnotation((BarrierAnnotation)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //ScopDepthFirstVisitorImpl
