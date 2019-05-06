/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.polymodel.polyhedralIR.impl;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Equation;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ExternalFunctionDeclaration;
import org.polymodel.polyhedralIR.FastISLDomain;
import org.polymodel.polyhedralIR.FastISLMap;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.PolyhedralIRInheritedDepthFirstVisitor;
import org.polymodel.polyhedralIR.PolyhedralIRPackage;
import org.polymodel.polyhedralIR.PolyhedralIRVisitable;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.TilingInformations;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.VariableIdentifier;
import org.polymodel.polyhedralIR.WhileInfo;
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
 * An implementation of the model object '<em><b>Inherited Depth First Visitor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PolyhedralIRInheritedDepthFirstVisitorImpl extends EObjectImpl implements PolyhedralIRInheritedDepthFirstVisitor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PolyhedralIRInheritedDepthFirstVisitorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolyhedralIRPackage.eINSTANCE.getPolyhedralIRInheritedDepthFirstVisitor();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void defaultIn(final PolyhedralIRVisitable node) {
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void defaultOut(final PolyhedralIRVisitable node) {
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitProgram(final Program p) {
		inProgram(p);
		for (EObject obj : p.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outProgram(p);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inProgram(final Program p) {
		defaultIn(p);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outProgram(final Program p) {
		defaultOut(p);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitExternalFunctionDeclaration(final ExternalFunctionDeclaration e) {
		inExternalFunctionDeclaration(e);
		for (EObject obj : e.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outExternalFunctionDeclaration(e);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inExternalFunctionDeclaration(final ExternalFunctionDeclaration e) {
		defaultIn(e);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outExternalFunctionDeclaration(final ExternalFunctionDeclaration e) {
		defaultOut(e);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAffineSystem(final AffineSystem a) {
		inAffineSystem(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outAffineSystem(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAffineSystem(final AffineSystem a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAffineSystem(final AffineSystem a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitVariableDeclaration(final VariableDeclaration v) {
		inVariableDeclaration(v);
		for (EObject obj : v.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outVariableDeclaration(v);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inVariableDeclaration(final VariableDeclaration v) {
		defaultIn(v);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outVariableDeclaration(final VariableDeclaration v) {
		defaultOut(v);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitVariableIdentifier(final VariableIdentifier v) {
		inVariableIdentifier(v);
		for (EObject obj : v.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outVariableIdentifier(v);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inVariableIdentifier(final VariableIdentifier v) {
		defaultIn(v);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outVariableIdentifier(final VariableIdentifier v) {
		defaultOut(v);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitEquation(final Equation e) {
		inEquation(e);
		for (EObject obj : e.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outEquation(e);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inEquation(final Equation e) {
		defaultIn(e);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outEquation(final Equation e) {
		defaultOut(e);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitUseEquation(final UseEquation u) {
		inUseEquation(u);
		for (EObject obj : u.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outUseEquation(u);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inUseEquation(final UseEquation u) {
		inEquation(u);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outUseEquation(final UseEquation u) {
		outEquation(u);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitStandardEquation(final StandardEquation s) {
		inStandardEquation(s);
		for (EObject obj : s.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outStandardEquation(s);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inStandardEquation(final StandardEquation s) {
		inEquation(s);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outStandardEquation(final StandardEquation s) {
		outEquation(s);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitDomain(final Domain d) {
		inDomain(d);
		for (EObject obj : d.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outDomain(d);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inDomain(final Domain d) {
		defaultIn(d);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outDomain(final Domain d) {
		defaultOut(d);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitParameterDomain(final ParameterDomain p) {
		inParameterDomain(p);
		for (EObject obj : p.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outParameterDomain(p);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inParameterDomain(final ParameterDomain p) {
		inDomain(p);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outParameterDomain(final ParameterDomain p) {
		outDomain(p);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitAffineFunction(final AffineFunction a) {
		inAffineFunction(a);
		for (EObject obj : a.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outAffineFunction(a);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inAffineFunction(final AffineFunction a) {
		defaultIn(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outAffineFunction(final AffineFunction a) {
		defaultOut(a);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitExpression(final Expression e) {
		inExpression(e);
		for (EObject obj : e.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outExpression(e);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inExpression(final Expression e) {
		defaultIn(e);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outExpression(final Expression e) {
		defaultOut(e);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitFastISLDomain(final FastISLDomain f) {
		inFastISLDomain(f);
		for (EObject obj : f.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outFastISLDomain(f);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inFastISLDomain(final FastISLDomain f) {
		inDomain(f);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outFastISLDomain(final FastISLDomain f) {
		outDomain(f);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitFastISLMap(final FastISLMap f) {
		inFastISLMap(f);
		for (EObject obj : f.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outFastISLMap(f);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inFastISLMap(final FastISLMap f) {
		inAffineFunction(f);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outFastISLMap(final FastISLMap f) {
		outAffineFunction(f);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitWhileInfo(final WhileInfo w) {
		inWhileInfo(w);
		for (EObject obj : w.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outWhileInfo(w);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inWhileInfo(final WhileInfo w) {
		defaultIn(w);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outWhileInfo(final WhileInfo w) {
		defaultOut(w);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitTilingInformations(final TilingInformations t) {
		inTilingInformations(t);
		for (EObject obj : t.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outTilingInformations(t);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inTilingInformations(final TilingInformations t) {
		defaultIn(t);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outTilingInformations(final TilingInformations t) {
		defaultOut(t);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitTargetMapping(final TargetMapping t) {
		inTargetMapping(t);
		for (EObject obj : t.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outTargetMapping(t);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inTargetMapping(final TargetMapping t) {
		defaultIn(t);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outTargetMapping(final TargetMapping t) {
		defaultOut(t);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitTilingSpecification(final TilingSpecification t) {
		inTilingSpecification(t);
		for (EObject obj : t.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outTilingSpecification(t);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inTilingSpecification(final TilingSpecification t) {
		inFeatureSpecification(t);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outTilingSpecification(final TilingSpecification t) {
		outFeatureSpecification(t);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitSpaceTimeMap(final SpaceTimeMap s) {
		inSpaceTimeMap(s);
		for (EObject obj : s.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outSpaceTimeMap(s);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inSpaceTimeMap(final SpaceTimeMap s) {
		defaultIn(s);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outSpaceTimeMap(final SpaceTimeMap s) {
		defaultOut(s);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitMemoryMap(final MemoryMap m) {
		inMemoryMap(m);
		for (EObject obj : m.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outMemoryMap(m);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inMemoryMap(final MemoryMap m) {
		defaultIn(m);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outMemoryMap(final MemoryMap m) {
		defaultOut(m);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitMemorySpace(final MemorySpace m) {
		inMemorySpace(m);
		for (EObject obj : m.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outMemorySpace(m);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inMemorySpace(final MemorySpace m) {
		defaultIn(m);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outMemorySpace(final MemorySpace m) {
		defaultOut(m);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitCommunicationMappingForTiledSpace(final CommunicationMappingForTiledSpace c) {
		inCommunicationMappingForTiledSpace(c);
		for (EObject obj : c.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outCommunicationMappingForTiledSpace(c);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inCommunicationMappingForTiledSpace(final CommunicationMappingForTiledSpace c) {
		defaultIn(c);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outCommunicationMappingForTiledSpace(final CommunicationMappingForTiledSpace c) {
		defaultOut(c);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitCommunicatedVariableForTiledSpace(final CommunicatedVariableForTiledSpace c) {
		inCommunicatedVariableForTiledSpace(c);
		for (EObject obj : c.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outCommunicatedVariableForTiledSpace(c);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inCommunicatedVariableForTiledSpace(final CommunicatedVariableForTiledSpace c) {
		defaultIn(c);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outCommunicatedVariableForTiledSpace(final CommunicatedVariableForTiledSpace c) {
		defaultOut(c);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitSubTilingSpecification(final SubTilingSpecification s) {
		inSubTilingSpecification(s);
		for (EObject obj : s.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outSubTilingSpecification(s);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inSubTilingSpecification(final SubTilingSpecification s) {
		defaultIn(s);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outSubTilingSpecification(final SubTilingSpecification s) {
		defaultOut(s);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitSpaceTimeLevel(final SpaceTimeLevel s) {
		inSpaceTimeLevel(s);
		for (EObject obj : s.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outSpaceTimeLevel(s);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inSpaceTimeLevel(final SpaceTimeLevel s) {
		defaultIn(s);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outSpaceTimeLevel(final SpaceTimeLevel s) {
		defaultOut(s);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitFeatureSpecification(final FeatureSpecification f) {
		inFeatureSpecification(f);
		for (EObject obj : f.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outFeatureSpecification(f);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inFeatureSpecification(final FeatureSpecification f) {
		defaultIn(f);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outFeatureSpecification(final FeatureSpecification f) {
		defaultOut(f);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitLoopUnrollingSpecification(final LoopUnrollingSpecification l) {
		inLoopUnrollingSpecification(l);
		for (EObject obj : l.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outLoopUnrollingSpecification(l);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inLoopUnrollingSpecification(final LoopUnrollingSpecification l) {
		inFeatureSpecification(l);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outLoopUnrollingSpecification(final LoopUnrollingSpecification l) {
		outFeatureSpecification(l);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitVectorizationSpecification(final VectorizationSpecification v) {
		inVectorizationSpecification(v);
		for (EObject obj : v.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outVectorizationSpecification(v);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inVectorizationSpecification(final VectorizationSpecification v) {
		inFeatureSpecification(v);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outVectorizationSpecification(final VectorizationSpecification v) {
		outFeatureSpecification(v);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitParallelizationSpecification(final ParallelizationSpecification p) {
		inParallelizationSpecification(p);
		for (EObject obj : p.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outParallelizationSpecification(p);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inParallelizationSpecification(final ParallelizationSpecification p) {
		inFeatureSpecification(p);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outParallelizationSpecification(final ParallelizationSpecification p) {
		outFeatureSpecification(p);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitStatementPartialOrder(final StatementPartialOrder s) {
		inStatementPartialOrder(s);
		for (EObject obj : s.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outStatementPartialOrder(s);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inStatementPartialOrder(final StatementPartialOrder s) {
		defaultIn(s);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outStatementPartialOrder(final StatementPartialOrder s) {
		defaultOut(s);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitUseEquationOptimization(final UseEquationOptimization u) {
		inUseEquationOptimization(u);
		for (EObject obj : u.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outUseEquationOptimization(u);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inUseEquationOptimization(final UseEquationOptimization u) {
		defaultIn(u);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outUseEquationOptimization(final UseEquationOptimization u) {
		defaultOut(u);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitCaseExpression(final CaseExpression c) {
		inCaseExpression(c);
		for (EObject obj : c.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outCaseExpression(c);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inCaseExpression(final CaseExpression c) {
		inExpression(c);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outCaseExpression(final CaseExpression c) {
		outExpression(c);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitDependenceExpression(final DependenceExpression d) {
		inDependenceExpression(d);
		for (EObject obj : d.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outDependenceExpression(d);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inDependenceExpression(final DependenceExpression d) {
		inExpression(d);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outDependenceExpression(final DependenceExpression d) {
		outExpression(d);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitIfExpression(final IfExpression i) {
		inIfExpression(i);
		for (EObject obj : i.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outIfExpression(i);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inIfExpression(final IfExpression i) {
		inExpression(i);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outIfExpression(final IfExpression i) {
		outExpression(i);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitIndexExpression(final IndexExpression i) {
		inIndexExpression(i);
		for (EObject obj : i.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outIndexExpression(i);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inIndexExpression(final IndexExpression i) {
		inExpression(i);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outIndexExpression(final IndexExpression i) {
		outExpression(i);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitReduceExpression(final ReduceExpression r) {
		inReduceExpression(r);
		for (EObject obj : r.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outReduceExpression(r);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inReduceExpression(final ReduceExpression r) {
		inExpression(r);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outReduceExpression(final ReduceExpression r) {
		outExpression(r);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitRestrictExpression(final RestrictExpression r) {
		inRestrictExpression(r);
		for (EObject obj : r.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outRestrictExpression(r);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inRestrictExpression(final RestrictExpression r) {
		inExpression(r);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outRestrictExpression(final RestrictExpression r) {
		outExpression(r);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitVariableExpression(final VariableExpression v) {
		inVariableExpression(v);
		for (EObject obj : v.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outVariableExpression(v);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inVariableExpression(final VariableExpression v) {
		inExpression(v);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outVariableExpression(final VariableExpression v) {
		outExpression(v);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitBinaryExpression(final BinaryExpression b) {
		inBinaryExpression(b);
		for (EObject obj : b.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outBinaryExpression(b);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inBinaryExpression(final BinaryExpression b) {
		inExpression(b);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outBinaryExpression(final BinaryExpression b) {
		outExpression(b);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitConstantExpression(final ConstantExpression c) {
		inConstantExpression(c);
		for (EObject obj : c.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outConstantExpression(c);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inConstantExpression(final ConstantExpression c) {
		inExpression(c);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outConstantExpression(final ConstantExpression c) {
		outExpression(c);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitBooleanExpression(final BooleanExpression b) {
		inBooleanExpression(b);
		for (EObject obj : b.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outBooleanExpression(b);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inBooleanExpression(final BooleanExpression b) {
		inConstantExpression(b);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outBooleanExpression(final BooleanExpression b) {
		outConstantExpression(b);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitIntegerExpression(final IntegerExpression i) {
		inIntegerExpression(i);
		for (EObject obj : i.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outIntegerExpression(i);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inIntegerExpression(final IntegerExpression i) {
		inConstantExpression(i);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outIntegerExpression(final IntegerExpression i) {
		outConstantExpression(i);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitRealExpression(final RealExpression r) {
		inRealExpression(r);
		for (EObject obj : r.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outRealExpression(r);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inRealExpression(final RealExpression r) {
		inConstantExpression(r);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outRealExpression(final RealExpression r) {
		outConstantExpression(r);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitMultiArgExpression(final MultiArgExpression m) {
		inMultiArgExpression(m);
		for (EObject obj : m.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outMultiArgExpression(m);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inMultiArgExpression(final MultiArgExpression m) {
		inExpression(m);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outMultiArgExpression(final MultiArgExpression m) {
		outExpression(m);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitExternalFunctionCall(final ExternalFunctionCall e) {
		inExternalFunctionCall(e);
		for (EObject obj : e.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outExternalFunctionCall(e);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inExternalFunctionCall(final ExternalFunctionCall e) {
		inMultiArgExpression(e);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outExternalFunctionCall(final ExternalFunctionCall e) {
		outMultiArgExpression(e);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitUnaryExpression(final UnaryExpression u) {
		inUnaryExpression(u);
		for (EObject obj : u.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		outUnaryExpression(u);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void inUnaryExpression(final UnaryExpression u) {
		inExpression(u);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outUnaryExpression(final UnaryExpression u) {
		outExpression(u);
		
	}

} //PolyhedralIRInheritedDepthFirstVisitorImpl
