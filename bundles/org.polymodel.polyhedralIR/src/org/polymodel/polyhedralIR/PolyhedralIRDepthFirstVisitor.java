/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR;

import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.BooleanExpression;
import org.polymodel.polyhedralIR.expression.CaseExpression;
import org.polymodel.polyhedralIR.expression.ConstantExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.ExternalFunctionCall;
import org.polymodel.polyhedralIR.expression.IfExpression;
import org.polymodel.polyhedralIR.expression.IndexExpression;
import org.polymodel.polyhedralIR.expression.IntegerExpression;
import org.polymodel.polyhedralIR.expression.MultiArgExpression;
import org.polymodel.polyhedralIR.expression.RealExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.expression.RestrictExpression;
import org.polymodel.polyhedralIR.expression.UnaryExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.targetMapping.CommunicatedVariableForTiledSpace;
import org.polymodel.polyhedralIR.targetMapping.CommunicationMappingForTiledSpace;
import org.polymodel.polyhedralIR.targetMapping.FeatureSpecification;
import org.polymodel.polyhedralIR.targetMapping.LoopUnrollingSpecification;
import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.ParallelizationSpecification;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeMap;
import org.polymodel.polyhedralIR.targetMapping.StatementPartialOrder;
import org.polymodel.polyhedralIR.targetMapping.SubTilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.TargetMapping;
import org.polymodel.polyhedralIR.targetMapping.TilingSpecification;
import org.polymodel.polyhedralIR.targetMapping.UseEquationOptimization;
import org.polymodel.polyhedralIR.targetMapping.VectorizationSpecification;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Depth First Visitor</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.polymodel.polyhedralIR.PolyhedralIRPackage#getPolyhedralIRDepthFirstVisitor()
 * @model
 * @generated
 */
public interface PolyhedralIRDepthFirstVisitor extends PolyhedralIRVisitor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body=''"
	 * @generated
	 */
	void defaultIn(PolyhedralIRVisitable node);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body=''"
	 * @generated
	 */
	void defaultOut(PolyhedralIRVisitable node);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inProgram(p);\nfor (EObject obj : p.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutProgram(p);\n'"
	 * @generated
	 */
	void visitProgram(Program p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(p);'"
	 * @generated
	 */
	void inProgram(Program p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(p);'"
	 * @generated
	 */
	void outProgram(Program p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inExternalFunctionDeclaration(e);\nfor (EObject obj : e.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutExternalFunctionDeclaration(e);\n'"
	 * @generated
	 */
	void visitExternalFunctionDeclaration(ExternalFunctionDeclaration e);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(e);'"
	 * @generated
	 */
	void inExternalFunctionDeclaration(ExternalFunctionDeclaration e);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(e);'"
	 * @generated
	 */
	void outExternalFunctionDeclaration(ExternalFunctionDeclaration e);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAffineSystem(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutAffineSystem(a);\n'"
	 * @generated
	 */
	void visitAffineSystem(AffineSystem a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAffineSystem(AffineSystem a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAffineSystem(AffineSystem a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inVariableDeclaration(v);\nfor (EObject obj : v.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutVariableDeclaration(v);\n'"
	 * @generated
	 */
	void visitVariableDeclaration(VariableDeclaration v);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(v);'"
	 * @generated
	 */
	void inVariableDeclaration(VariableDeclaration v);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(v);'"
	 * @generated
	 */
	void outVariableDeclaration(VariableDeclaration v);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inVariableIdentifier(v);\nfor (EObject obj : v.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutVariableIdentifier(v);\n'"
	 * @generated
	 */
	void visitVariableIdentifier(VariableIdentifier v);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(v);'"
	 * @generated
	 */
	void inVariableIdentifier(VariableIdentifier v);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(v);'"
	 * @generated
	 */
	void outVariableIdentifier(VariableIdentifier v);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inEquation(e);\nfor (EObject obj : e.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutEquation(e);\n'"
	 * @generated
	 */
	void visitEquation(Equation e);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(e);'"
	 * @generated
	 */
	void inEquation(Equation e);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(e);'"
	 * @generated
	 */
	void outEquation(Equation e);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inUseEquation(u);\nfor (EObject obj : u.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutUseEquation(u);\n'"
	 * @generated
	 */
	void visitUseEquation(UseEquation u);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(u);'"
	 * @generated
	 */
	void inUseEquation(UseEquation u);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(u);'"
	 * @generated
	 */
	void outUseEquation(UseEquation u);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inStandardEquation(s);\nfor (EObject obj : s.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutStandardEquation(s);\n'"
	 * @generated
	 */
	void visitStandardEquation(StandardEquation s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(s);'"
	 * @generated
	 */
	void inStandardEquation(StandardEquation s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(s);'"
	 * @generated
	 */
	void outStandardEquation(StandardEquation s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inDomain(d);\nfor (EObject obj : d.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutDomain(d);\n'"
	 * @generated
	 */
	void visitDomain(Domain d);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(d);'"
	 * @generated
	 */
	void inDomain(Domain d);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(d);'"
	 * @generated
	 */
	void outDomain(Domain d);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inParameterDomain(p);\nfor (EObject obj : p.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutParameterDomain(p);\n'"
	 * @generated
	 */
	void visitParameterDomain(ParameterDomain p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(p);'"
	 * @generated
	 */
	void inParameterDomain(ParameterDomain p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(p);'"
	 * @generated
	 */
	void outParameterDomain(ParameterDomain p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inAffineFunction(a);\nfor (EObject obj : a.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutAffineFunction(a);\n'"
	 * @generated
	 */
	void visitAffineFunction(AffineFunction a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(a);'"
	 * @generated
	 */
	void inAffineFunction(AffineFunction a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(a);'"
	 * @generated
	 */
	void outAffineFunction(AffineFunction a);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inExpression(e);\nfor (EObject obj : e.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutExpression(e);\n'"
	 * @generated
	 */
	void visitExpression(Expression e);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(e);'"
	 * @generated
	 */
	void inExpression(Expression e);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(e);'"
	 * @generated
	 */
	void outExpression(Expression e);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inFastISLDomain(f);\nfor (EObject obj : f.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutFastISLDomain(f);\n'"
	 * @generated
	 */
	void visitFastISLDomain(FastISLDomain f);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(f);'"
	 * @generated
	 */
	void inFastISLDomain(FastISLDomain f);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(f);'"
	 * @generated
	 */
	void outFastISLDomain(FastISLDomain f);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inFastISLMap(f);\nfor (EObject obj : f.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutFastISLMap(f);\n'"
	 * @generated
	 */
	void visitFastISLMap(FastISLMap f);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(f);'"
	 * @generated
	 */
	void inFastISLMap(FastISLMap f);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(f);'"
	 * @generated
	 */
	void outFastISLMap(FastISLMap f);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inWhileInfo(w);\nfor (EObject obj : w.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutWhileInfo(w);\n'"
	 * @generated
	 */
	void visitWhileInfo(WhileInfo w);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(w);'"
	 * @generated
	 */
	void inWhileInfo(WhileInfo w);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(w);'"
	 * @generated
	 */
	void outWhileInfo(WhileInfo w);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inTilingInformations(t);\nfor (EObject obj : t.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutTilingInformations(t);\n'"
	 * @generated
	 */
	void visitTilingInformations(TilingInformations t);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(t);'"
	 * @generated
	 */
	void inTilingInformations(TilingInformations t);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(t);'"
	 * @generated
	 */
	void outTilingInformations(TilingInformations t);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inTargetMapping(t);\nfor (EObject obj : t.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutTargetMapping(t);\n'"
	 * @generated
	 */
	void visitTargetMapping(TargetMapping t);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(t);'"
	 * @generated
	 */
	void inTargetMapping(TargetMapping t);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(t);'"
	 * @generated
	 */
	void outTargetMapping(TargetMapping t);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inTilingSpecification(t);\nfor (EObject obj : t.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutTilingSpecification(t);\n'"
	 * @generated
	 */
	void visitTilingSpecification(TilingSpecification t);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(t);'"
	 * @generated
	 */
	void inTilingSpecification(TilingSpecification t);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(t);'"
	 * @generated
	 */
	void outTilingSpecification(TilingSpecification t);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inSpaceTimeMap(s);\nfor (EObject obj : s.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutSpaceTimeMap(s);\n'"
	 * @generated
	 */
	void visitSpaceTimeMap(SpaceTimeMap s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(s);'"
	 * @generated
	 */
	void inSpaceTimeMap(SpaceTimeMap s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(s);'"
	 * @generated
	 */
	void outSpaceTimeMap(SpaceTimeMap s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inMemoryMap(m);\nfor (EObject obj : m.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutMemoryMap(m);\n'"
	 * @generated
	 */
	void visitMemoryMap(MemoryMap m);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(m);'"
	 * @generated
	 */
	void inMemoryMap(MemoryMap m);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(m);'"
	 * @generated
	 */
	void outMemoryMap(MemoryMap m);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inMemorySpace(m);\nfor (EObject obj : m.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutMemorySpace(m);\n'"
	 * @generated
	 */
	void visitMemorySpace(MemorySpace m);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(m);'"
	 * @generated
	 */
	void inMemorySpace(MemorySpace m);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(m);'"
	 * @generated
	 */
	void outMemorySpace(MemorySpace m);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inCommunicationMappingForTiledSpace(c);\nfor (EObject obj : c.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutCommunicationMappingForTiledSpace(c);\n'"
	 * @generated
	 */
	void visitCommunicationMappingForTiledSpace(CommunicationMappingForTiledSpace c);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(c);'"
	 * @generated
	 */
	void inCommunicationMappingForTiledSpace(CommunicationMappingForTiledSpace c);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(c);'"
	 * @generated
	 */
	void outCommunicationMappingForTiledSpace(CommunicationMappingForTiledSpace c);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inCommunicatedVariableForTiledSpace(c);\nfor (EObject obj : c.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutCommunicatedVariableForTiledSpace(c);\n'"
	 * @generated
	 */
	void visitCommunicatedVariableForTiledSpace(CommunicatedVariableForTiledSpace c);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(c);'"
	 * @generated
	 */
	void inCommunicatedVariableForTiledSpace(CommunicatedVariableForTiledSpace c);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(c);'"
	 * @generated
	 */
	void outCommunicatedVariableForTiledSpace(CommunicatedVariableForTiledSpace c);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inSubTilingSpecification(s);\nfor (EObject obj : s.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutSubTilingSpecification(s);\n'"
	 * @generated
	 */
	void visitSubTilingSpecification(SubTilingSpecification s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(s);'"
	 * @generated
	 */
	void inSubTilingSpecification(SubTilingSpecification s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(s);'"
	 * @generated
	 */
	void outSubTilingSpecification(SubTilingSpecification s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inSpaceTimeLevel(s);\nfor (EObject obj : s.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutSpaceTimeLevel(s);\n'"
	 * @generated
	 */
	void visitSpaceTimeLevel(SpaceTimeLevel s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(s);'"
	 * @generated
	 */
	void inSpaceTimeLevel(SpaceTimeLevel s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(s);'"
	 * @generated
	 */
	void outSpaceTimeLevel(SpaceTimeLevel s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inFeatureSpecification(f);\nfor (EObject obj : f.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutFeatureSpecification(f);\n'"
	 * @generated
	 */
	void visitFeatureSpecification(FeatureSpecification f);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(f);'"
	 * @generated
	 */
	void inFeatureSpecification(FeatureSpecification f);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(f);'"
	 * @generated
	 */
	void outFeatureSpecification(FeatureSpecification f);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inLoopUnrollingSpecification(l);\nfor (EObject obj : l.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutLoopUnrollingSpecification(l);\n'"
	 * @generated
	 */
	void visitLoopUnrollingSpecification(LoopUnrollingSpecification l);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(l);'"
	 * @generated
	 */
	void inLoopUnrollingSpecification(LoopUnrollingSpecification l);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(l);'"
	 * @generated
	 */
	void outLoopUnrollingSpecification(LoopUnrollingSpecification l);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inVectorizationSpecification(v);\nfor (EObject obj : v.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutVectorizationSpecification(v);\n'"
	 * @generated
	 */
	void visitVectorizationSpecification(VectorizationSpecification v);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(v);'"
	 * @generated
	 */
	void inVectorizationSpecification(VectorizationSpecification v);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(v);'"
	 * @generated
	 */
	void outVectorizationSpecification(VectorizationSpecification v);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inParallelizationSpecification(p);\nfor (EObject obj : p.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutParallelizationSpecification(p);\n'"
	 * @generated
	 */
	void visitParallelizationSpecification(ParallelizationSpecification p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(p);'"
	 * @generated
	 */
	void inParallelizationSpecification(ParallelizationSpecification p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(p);'"
	 * @generated
	 */
	void outParallelizationSpecification(ParallelizationSpecification p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inStatementPartialOrder(s);\nfor (EObject obj : s.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutStatementPartialOrder(s);\n'"
	 * @generated
	 */
	void visitStatementPartialOrder(StatementPartialOrder s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(s);'"
	 * @generated
	 */
	void inStatementPartialOrder(StatementPartialOrder s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(s);'"
	 * @generated
	 */
	void outStatementPartialOrder(StatementPartialOrder s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inUseEquationOptimization(u);\nfor (EObject obj : u.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutUseEquationOptimization(u);\n'"
	 * @generated
	 */
	void visitUseEquationOptimization(UseEquationOptimization u);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(u);'"
	 * @generated
	 */
	void inUseEquationOptimization(UseEquationOptimization u);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(u);'"
	 * @generated
	 */
	void outUseEquationOptimization(UseEquationOptimization u);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inCaseExpression(c);\nfor (EObject obj : c.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutCaseExpression(c);\n'"
	 * @generated
	 */
	void visitCaseExpression(CaseExpression c);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(c);'"
	 * @generated
	 */
	void inCaseExpression(CaseExpression c);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(c);'"
	 * @generated
	 */
	void outCaseExpression(CaseExpression c);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inDependenceExpression(d);\nfor (EObject obj : d.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutDependenceExpression(d);\n'"
	 * @generated
	 */
	void visitDependenceExpression(DependenceExpression d);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(d);'"
	 * @generated
	 */
	void inDependenceExpression(DependenceExpression d);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(d);'"
	 * @generated
	 */
	void outDependenceExpression(DependenceExpression d);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inIfExpression(i);\nfor (EObject obj : i.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutIfExpression(i);\n'"
	 * @generated
	 */
	void visitIfExpression(IfExpression i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(i);'"
	 * @generated
	 */
	void inIfExpression(IfExpression i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(i);'"
	 * @generated
	 */
	void outIfExpression(IfExpression i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inIndexExpression(i);\nfor (EObject obj : i.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutIndexExpression(i);\n'"
	 * @generated
	 */
	void visitIndexExpression(IndexExpression i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(i);'"
	 * @generated
	 */
	void inIndexExpression(IndexExpression i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(i);'"
	 * @generated
	 */
	void outIndexExpression(IndexExpression i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inReduceExpression(r);\nfor (EObject obj : r.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutReduceExpression(r);\n'"
	 * @generated
	 */
	void visitReduceExpression(ReduceExpression r);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(r);'"
	 * @generated
	 */
	void inReduceExpression(ReduceExpression r);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(r);'"
	 * @generated
	 */
	void outReduceExpression(ReduceExpression r);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inRestrictExpression(r);\nfor (EObject obj : r.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutRestrictExpression(r);\n'"
	 * @generated
	 */
	void visitRestrictExpression(RestrictExpression r);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(r);'"
	 * @generated
	 */
	void inRestrictExpression(RestrictExpression r);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(r);'"
	 * @generated
	 */
	void outRestrictExpression(RestrictExpression r);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inVariableExpression(v);\nfor (EObject obj : v.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutVariableExpression(v);\n'"
	 * @generated
	 */
	void visitVariableExpression(VariableExpression v);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(v);'"
	 * @generated
	 */
	void inVariableExpression(VariableExpression v);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(v);'"
	 * @generated
	 */
	void outVariableExpression(VariableExpression v);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inBinaryExpression(b);\nfor (EObject obj : b.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutBinaryExpression(b);\n'"
	 * @generated
	 */
	void visitBinaryExpression(BinaryExpression b);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(b);'"
	 * @generated
	 */
	void inBinaryExpression(BinaryExpression b);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(b);'"
	 * @generated
	 */
	void outBinaryExpression(BinaryExpression b);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inConstantExpression(c);\nfor (EObject obj : c.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutConstantExpression(c);\n'"
	 * @generated
	 */
	void visitConstantExpression(ConstantExpression c);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(c);'"
	 * @generated
	 */
	void inConstantExpression(ConstantExpression c);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(c);'"
	 * @generated
	 */
	void outConstantExpression(ConstantExpression c);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inBooleanExpression(b);\nfor (EObject obj : b.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutBooleanExpression(b);\n'"
	 * @generated
	 */
	void visitBooleanExpression(BooleanExpression b);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(b);'"
	 * @generated
	 */
	void inBooleanExpression(BooleanExpression b);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(b);'"
	 * @generated
	 */
	void outBooleanExpression(BooleanExpression b);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inIntegerExpression(i);\nfor (EObject obj : i.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutIntegerExpression(i);\n'"
	 * @generated
	 */
	void visitIntegerExpression(IntegerExpression i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(i);'"
	 * @generated
	 */
	void inIntegerExpression(IntegerExpression i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(i);'"
	 * @generated
	 */
	void outIntegerExpression(IntegerExpression i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inRealExpression(r);\nfor (EObject obj : r.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutRealExpression(r);\n'"
	 * @generated
	 */
	void visitRealExpression(RealExpression r);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(r);'"
	 * @generated
	 */
	void inRealExpression(RealExpression r);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(r);'"
	 * @generated
	 */
	void outRealExpression(RealExpression r);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inMultiArgExpression(m);\nfor (EObject obj : m.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutMultiArgExpression(m);\n'"
	 * @generated
	 */
	void visitMultiArgExpression(MultiArgExpression m);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(m);'"
	 * @generated
	 */
	void inMultiArgExpression(MultiArgExpression m);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(m);'"
	 * @generated
	 */
	void outMultiArgExpression(MultiArgExpression m);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inExternalFunctionCall(e);\nfor (EObject obj : e.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutExternalFunctionCall(e);\n'"
	 * @generated
	 */
	void visitExternalFunctionCall(ExternalFunctionCall e);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(e);'"
	 * @generated
	 */
	void inExternalFunctionCall(ExternalFunctionCall e);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(e);'"
	 * @generated
	 */
	void outExternalFunctionCall(ExternalFunctionCall e);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='inUnaryExpression(u);\nfor (EObject obj : u.eContents()) \n\tif (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);\noutUnaryExpression(u);\n'"
	 * @generated
	 */
	void visitUnaryExpression(UnaryExpression u);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultIn(u);'"
	 * @generated
	 */
	void inUnaryExpression(UnaryExpression u);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='defaultOut(u);'"
	 * @generated
	 */
	void outUnaryExpression(UnaryExpression u);

} // PolyhedralIRDepthFirstVisitor
