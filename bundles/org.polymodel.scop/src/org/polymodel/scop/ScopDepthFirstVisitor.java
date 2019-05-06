/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.scop;

import org.polymodel.scop.annotation.BarrierAnnotation;
import org.polymodel.scop.annotation.DescriptionAnnotation;
import org.polymodel.scop.annotation.ParallelBlockAnnotation;
import org.polymodel.scop.annotation.ParallelLoopAnnotation;
import org.polymodel.scop.annotation.PolyhedralDomainAnnotation;
import org.polymodel.scop.annotation.TileLoopAnnotation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Depth First Visitor</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.polymodel.scop.ScopPackage#getScopDepthFirstVisitor()
 * @model
 * @generated
 */
public interface ScopDepthFirstVisitor extends ScopVisitor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body=''"
	 * @generated
	 */
	void defaultIn(ScopVisitable node);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body=''"
	 * @generated
	 */
	void defaultOut(ScopVisitable node);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAbstractScopNode(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);\noutAbstractScopNode(a);\n'"
	 * @generated
	 */
	void visitAbstractScopNode(AbstractScopNode a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAbstractScopNode(AbstractScopNode a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAbstractScopNode(AbstractScopNode a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inIScopAnnotation(i);\nfor (EObject obj : i.eContents()) \n\tif (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);\noutIScopAnnotation(i);\n'"
	 * @generated
	 */
	void visitIScopAnnotation(IScopAnnotation i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(i);'"
	 * @generated
	 */
	void inIScopAnnotation(IScopAnnotation i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(i);'"
	 * @generated
	 */
	void outIScopAnnotation(IScopAnnotation i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inScopRoot(s);\nfor (EObject obj : s.eContents()) \n\tif (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);\noutScopRoot(s);\n'"
	 * @generated
	 */
	void visitScopRoot(ScopRoot s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(s);'"
	 * @generated
	 */
	void inScopRoot(ScopRoot s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(s);'"
	 * @generated
	 */
	void outScopRoot(ScopRoot s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inScopFor(s);\nfor (EObject obj : s.eContents()) \n\tif (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);\noutScopFor(s);\n'"
	 * @generated
	 */
	void visitScopFor(ScopFor s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(s);'"
	 * @generated
	 */
	void inScopFor(ScopFor s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(s);'"
	 * @generated
	 */
	void outScopFor(ScopFor s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inScopBlock(s);\nfor (EObject obj : s.eContents()) \n\tif (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);\noutScopBlock(s);\n'"
	 * @generated
	 */
	void visitScopBlock(ScopBlock s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(s);'"
	 * @generated
	 */
	void inScopBlock(ScopBlock s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(s);'"
	 * @generated
	 */
	void outScopBlock(ScopBlock s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inScopGuard(s);\nfor (EObject obj : s.eContents()) \n\tif (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);\noutScopGuard(s);\n'"
	 * @generated
	 */
	void visitScopGuard(ScopGuard s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(s);'"
	 * @generated
	 */
	void inScopGuard(ScopGuard s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(s);'"
	 * @generated
	 */
	void outScopGuard(ScopGuard s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inScopStatementMacro(s);\nfor (EObject obj : s.eContents()) \n\tif (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);\noutScopStatementMacro(s);\n'"
	 * @generated
	 */
	void visitScopStatementMacro(ScopStatementMacro s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(s);'"
	 * @generated
	 */
	void inScopStatementMacro(ScopStatementMacro s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(s);'"
	 * @generated
	 */
	void outScopStatementMacro(ScopStatementMacro s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inScopUnscannedDomain(s);\nfor (EObject obj : s.eContents()) \n\tif (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);\noutScopUnscannedDomain(s);\n'"
	 * @generated
	 */
	void visitScopUnscannedDomain(ScopUnscannedDomain s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(s);'"
	 * @generated
	 */
	void inScopUnscannedDomain(ScopUnscannedDomain s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(s);'"
	 * @generated
	 */
	void outScopUnscannedDomain(ScopUnscannedDomain s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inScopAssignment(s);\nfor (EObject obj : s.eContents()) \n\tif (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);\noutScopAssignment(s);\n'"
	 * @generated
	 */
	void visitScopAssignment(ScopAssignment s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(s);'"
	 * @generated
	 */
	void inScopAssignment(ScopAssignment s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(s);'"
	 * @generated
	 */
	void outScopAssignment(ScopAssignment s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAbstractScopStatement(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);\noutAbstractScopStatement(a);\n'"
	 * @generated
	 */
	void visitAbstractScopStatement(AbstractScopStatement a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAbstractScopStatement(AbstractScopStatement a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAbstractScopStatement(AbstractScopStatement a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inParallelLoopAnnotation(p);\nfor (EObject obj : p.eContents()) \n\tif (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);\noutParallelLoopAnnotation(p);\n'"
	 * @generated
	 */
	void visitParallelLoopAnnotation(ParallelLoopAnnotation p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(p);'"
	 * @generated
	 */
	void inParallelLoopAnnotation(ParallelLoopAnnotation p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(p);'"
	 * @generated
	 */
	void outParallelLoopAnnotation(ParallelLoopAnnotation p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inDescriptionAnnotation(d);\nfor (EObject obj : d.eContents()) \n\tif (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);\noutDescriptionAnnotation(d);\n'"
	 * @generated
	 */
	void visitDescriptionAnnotation(DescriptionAnnotation d);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(d);'"
	 * @generated
	 */
	void inDescriptionAnnotation(DescriptionAnnotation d);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(d);'"
	 * @generated
	 */
	void outDescriptionAnnotation(DescriptionAnnotation d);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inTileLoopAnnotation(t);\nfor (EObject obj : t.eContents()) \n\tif (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);\noutTileLoopAnnotation(t);\n'"
	 * @generated
	 */
	void visitTileLoopAnnotation(TileLoopAnnotation t);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(t);'"
	 * @generated
	 */
	void inTileLoopAnnotation(TileLoopAnnotation t);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(t);'"
	 * @generated
	 */
	void outTileLoopAnnotation(TileLoopAnnotation t);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inParallelBlockAnnotation(p);\nfor (EObject obj : p.eContents()) \n\tif (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);\noutParallelBlockAnnotation(p);\n'"
	 * @generated
	 */
	void visitParallelBlockAnnotation(ParallelBlockAnnotation p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(p);'"
	 * @generated
	 */
	void inParallelBlockAnnotation(ParallelBlockAnnotation p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(p);'"
	 * @generated
	 */
	void outParallelBlockAnnotation(ParallelBlockAnnotation p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inPolyhedralDomainAnnotation(p);\nfor (EObject obj : p.eContents()) \n\tif (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);\noutPolyhedralDomainAnnotation(p);\n'"
	 * @generated
	 */
	void visitPolyhedralDomainAnnotation(PolyhedralDomainAnnotation p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(p);'"
	 * @generated
	 */
	void inPolyhedralDomainAnnotation(PolyhedralDomainAnnotation p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(p);'"
	 * @generated
	 */
	void outPolyhedralDomainAnnotation(PolyhedralDomainAnnotation p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inBarrierAnnotation(b);\nfor (EObject obj : b.eContents()) \n\tif (obj instanceof ScopVisitable) ((ScopVisitable)obj).accept(this);\noutBarrierAnnotation(b);\n'"
	 * @generated
	 */
	void visitBarrierAnnotation(BarrierAnnotation b);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(b);'"
	 * @generated
	 */
	void inBarrierAnnotation(BarrierAnnotation b);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(b);'"
	 * @generated
	 */
	void outBarrierAnnotation(BarrierAnnotation b);

} // ScopDepthFirstVisitor
