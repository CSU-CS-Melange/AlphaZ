package org.polymodel.polyhedralIR.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.polymodel.DimensionsManager;
import org.polymodel.DomainDimensions;
import org.polymodel.Function;
import org.polymodel.Label;
import org.polymodel.OutputDimension;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.factory.PolymodelDefaultFactory;
import org.polymodel.isl.factory.ISLNativeBinder;
import org.polymodel.isl.factory.ISLPolymodelModule;
import org.polymodel.matrix.Matrix;
import org.polymodel.matrix.MatrixRow;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ExternalFunctionDeclaration;
import org.polymodel.polyhedralIR.FastISLDomain;
import org.polymodel.polyhedralIR.FastISLMap;
import org.polymodel.polyhedralIR.OP;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.PolyhedralIRFactory;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.SIGNED;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.VariableIdentifier;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.BooleanExpression;
import org.polymodel.polyhedralIR.expression.CaseExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.ExpressionFactory;
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

import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicMap;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicSet;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLContext;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLDimType;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSet;

public class PolyhedralIRUserFactory {
	
	public static enum BACKEND {ISL, POLYLIB};

	private static PolyhedralIRFactory fact = PolyhedralIRFactory.eINSTANCE;
	private static ExpressionFactory factExpr = ExpressionFactory.eINSTANCE;
	public static PolymodelDefaultFactory _polyFact = PolymodelComponent.INSTANCE.getFactory(ISLPolymodelModule.INSTANCE);
	
	private final BACKEND _backend;
	
	private static String LabelUseEquationPrefix = "UseEquation_";
	
	public static PolyhedralIRUserFactory eINSTANCE = new PolyhedralIRUserFactory(BACKEND.ISL);
	
	public static void selectBackEnd(BACKEND backend) {
		eINSTANCE = new PolyhedralIRUserFactory(backend);
	}
	
	
	/**
	 * Constructs the factory using a backend for polyhedral operations.
	 * 
	 * @param backend
	 */
	protected PolyhedralIRUserFactory(BACKEND backend) {
		_backend = backend;
		switch (_backend) {
			case ISL:
				PolymodelComponent.INSTANCE.setDefaultModule(PolyhedralIRModule.INSTANCE);
				_polyFact = PolymodelComponent.INSTANCE.getFactory(PolyhedralIRModule.INSTANCE);
				break;
//			case POLYLIB:
//				_polyFact = PolylibDefaultFactory.INSTANCE;
//				break;
			default:
				break;
		}
	}
	
	public ParameterDomain createParameterDomain(org.polymodel.Domain domain) {
		assert(domain != null);
		
		if (domain.getDimensions().getIndices().size() != 0) throw new RuntimeException("Parameter dimensions cannot have non-parameter dimensions."); 
		
		ParameterDomain dom = fact.createParameterDomain();
		
		dom.setPMdomain(domain);
		
		return dom;
	}
	
	public Domain createDomain(org.polymodel.Domain domain) {
		assert(domain != null);
		
		Domain dom = fact.createDomain();
		dom.setPMdomain(domain);
		
		return dom;
	}
	
	public Domain createDomain(List<Variable> params, List<Variable> indices, List<IntConstraintSystem> systems) {
		DomainDimensions dims = _polyFact.createDomainDimensions(indices, params);
		if (systems == null)
			return createDomain(_polyFact.createDomain(dims, IntExpressionBuilder.constraintSystem()));
		return createDomain(_polyFact.createDomain(dims, systems));
		
	}
	
	public Domain createDomain(List<Variable> params, List<Variable> indices, IntConstraintSystem... systems) {
		return createDomain(params, indices, Arrays.asList(systems));
	}
	
	//	/**
	//	 * Creates a new IndexDimension with the specified name.
	//	 * 
	//	 * @param dom
	//	 * @param name
	//	 * @return
	//	 */
	//	public IndexDimension createNewDimension(Domain dom, String name) {
	//		//I don't know who did it, but do not change this to getDim()+1, it messes up many things
	//		return _polyFact.createIndexDimension(dom.getDim(), name);
	//	}
	//
	//	/**
	//	 * Creates a new IndexDimension with the specified name.
	//	 * 
	//	 * @param dom
	//	 * @param name
	//	 * @return
	//	 */
	//	public IndexDimension createNewDimension(AffineFunction func, String name) {
	//		//I don't know who did it, but do not change this to getDimLHS()+1, it messes up many things
	//		return _polyFact.createIndexDimension(func.getDimLHS(), name);
	//	}
	
	
		public Domain createDomainFromConstraints(List<Variable> params, List<Variable> indices, List<List<IntConstraint>> constraintsList) {
			List<IntConstraintSystem> systems = new ArrayList<IntConstraintSystem>(constraintsList.size());
			
			for (List<IntConstraint> constraints : constraintsList) {
				systems.add(IntExpressionBuilder.constraintSystem(constraints));
			}
			
			return createDomain(_polyFact.createDomain(indices, params, systems));
		}


	public Program createProgram() {
		return fact.createProgram();
	}
	
	public ExternalFunctionDeclaration createExternalFunctionDeclaration(String name, Type output, List<Type> inputs) {
		ExternalFunctionDeclaration ef = fact.createExternalFunctionDeclaration();
		
		ef.setName(name);
		ef.setOutput(output);
		
		ef.getInputs().addAll(inputs);
		//ef.getInputs().
		
		return ef;
	}
	
	/**
	 * Creates an AffineSystem with the given name and parameters.
	 * Variables and equations should be added later.
	 * 
	 * @param name
	 * @param domain
	 * @return
	 */
	public AffineSystem createAffineSystem(String name, ParameterDomain domain) {
		AffineSystem a = fact.createAffineSystem();
		a.setName(name);
		a.setParameters(domain);
		return a;
	}

	/**
	 * Creates an equation that defines the given variable using the given expression.
	 * Expression is expected to be fully constructed.
	 * 
	 * @param var
	 * @param expr
	 * @return
	 */
	public StandardEquation createStandardEquation(VariableDeclaration var, Expression expr) {
		StandardEquation eq = fact.createStandardEquation();
		eq.setVariable(var);
		eq.setExpression(expr);
		return eq;
	}
	
	/**
	 * Create a use equation.
	 * 
	 * @param extDom
	 * @param subSysName
	 * @param params
	 * @param inputs
	 * @param outputs
	 * @return
	 */
	public UseEquation createUseEquation(Domain extDom, AffineSystem subSys, AffineFunction params,
			List<Expression> inputs, List<VariableDeclaration> outputs) {
		if (outputs.size()==0)
			throw new RuntimeException("UseEquation need at least one output");
		
		UseEquation ueq = fact.createUseEquation();
		ueq.setExtensionDomain(extDom);
		ueq.setSubSystem(subSys);
		ueq.setParameters(params);
		ueq.getInputs().addAll(inputs);
		ueq.getOutputs().addAll(outputs);
		ueq.setLabel(LabelUseEquationPrefix + outputs.get(0).getName());
		return ueq;
	}
	
	public VariableDeclaration createVariableDeclaration(VariableIdentifier var, Type type, Domain domain) {
		VariableDeclaration decl = fact.createVariableDeclaration();
		decl.setVarID(var);
		decl.setType(type);
		decl.setDomain(domain);
		assert(!(domain instanceof ParameterDomain));
		return decl;
	}
	public VariableDeclaration createVariableDeclaration(String name, Type type, Domain domain) {
		return createVariableDeclaration(createVariableIdentifier(name), type, domain);
	}
	
	public Type createType(DATATYPE type) {
		return createType(type, SIGNED.SIGNED);
	}
	
	public Type createType(DATATYPE type, SIGNED s) {
		return createType(type, s, 32);
	}

	public Type createType(DATATYPE type, SIGNED s, int width) {
		Type t = fact.createType();
		t.setTypeID(type);
		t.setSigned(s);
		t.setWidth(width);
		return t;
	}
	
	public VariableIdentifier createVariableIdentifier(String name) {
		VariableIdentifier var = fact.createVariableIdentifier();
		var.setName(name);
		return var;
	}
	
	public CaseExpression createCaseExpression(List<? extends Expression> exprs) {
		//Check list
		if (exprs.size() == 0) throw new RuntimeException("Expecting non-empty list of Expressions as children of CaseExpression.");
		
		CaseExpression c = factExpr.createCaseExpression();
		c.getExprs().addAll(exprs);
		
		return c;
	}
	
	public DependenceExpression createDependenceExpression(AffineFunction dep, Expression expr) {
		DependenceExpression de = factExpr.createDependenceExpression();
		de.setDep(dep);
		de.setExpr(expr);
		
		
		return de;
	}
	
	public IfExpression createIfExpression(Expression condExpr, Expression thenExpr, Expression elseExpr) {
		IfExpression ie = factExpr.createIfExpression();
		ie.setCond(condExpr);
		ie.setThen(thenExpr);
		ie.setElse(elseExpr);

		
		return ie;
	}
	
	public IndexExpression createIndexExpression(AffineFunction func) {
		IndexExpression ie = factExpr.createIndexExpression();
		ie.setFunction(func);
		

		return ie;
	}
	
	public ReduceExpression createReduceExpression(OP op, AffineFunction projection, Expression expr) {
		ReduceExpression re = factExpr.createReduceExpression();
		
		re.setOP(op);
		re.setProjection(projection);
		re.setExpr(expr);

		
		return re;
	}
	public RestrictExpression createRestrictExpression(Domain restrictDomain, Expression expr) {
		RestrictExpression re = factExpr.createRestrictExpression();
		re.setRestrictDomain(restrictDomain);
		re.setExpr(expr);

		return re;
	}
	
	public VariableExpression createVariableExpression(VariableDeclaration var) {
		VariableExpression ve = factExpr.createVariableExpression();
		
		ve.setVarDecl(var);
		
		return ve;
	}
	
	public BinaryExpression createBinaryExpression(OP op, Expression lhs, Expression rhs) {
		BinaryExpression be = ExpressionFactory.eINSTANCE.createBinaryExpression();
		be.setOperator(op);
		be.setLexp(lhs);
		be.setRexp(rhs);
		

		return be;
	}
	
	public UnaryExpression createUnaryExpression(OP op, Expression expr) {
		UnaryExpression ue = factExpr.createUnaryExpression();
		ue.setOperator(op);
		ue.setExpr(expr);

		return ue;
	}
	
	
	public IntegerExpression createIntegerExpression(long value) {
		IntegerExpression ie = factExpr.createIntegerExpression();
		ie.setValue(value);

		return ie;
	}
	
	public IntegerExpression createIntegerExpression(ParameterDomain dom, int value) {
		IntegerExpression ie = factExpr.createIntegerExpression();
		ie.setValue(value);
		ie.setExpressionDomain(dom);
		return ie;
	}

	public RealExpression createRealExpression(double value) {
		RealExpression re = factExpr.createRealExpression();
		re.setValue(value);
		return re;
	}
	

	public BooleanExpression createBooleanExpression(String value) {
		return createBooleanExpression(value.compareTo("true") == 0);
	}
	
	public BooleanExpression createBooleanExpression(boolean value) {
		BooleanExpression be = factExpr.createBooleanExpression();
		be.setValue(value);

		return be;
	}
	
	public MultiArgExpression createMultiArgExpression(OP op, List<Expression> exprs) {
		MultiArgExpression mae = ExpressionFactory.eINSTANCE.createMultiArgExpression();
		mae.setOperator(op);
		mae.getExprs().addAll(exprs);

		return mae;
	}
	
	public ExternalFunctionCall createExternalFunctionCall(ExternalFunctionDeclaration declaration, List<Expression> exprs){
		ExternalFunctionCall efc = factExpr.createExternalFunctionCall();
		efc.setOperator(OP.EXTERNAL_FUNCTION);
		efc.setExFunc(declaration);
		efc.getExprs().addAll(exprs);
		
		return efc;
	}
	public ExternalFunctionCall createExternalFunctionCall(Program program, String name, List<Expression> exprs) {
		ExternalFunctionCall efc = factExpr.createExternalFunctionCall();

		if (program.getExternalFunctionDeclaration(name, null, null) == null) {
			throw new RuntimeException("Corresponding declaration for external function : " + name + " was not found.");
		}
		
		efc.setOperator(program.getExternalFunctionOperator());
		efc.setExFunc(program.getExternalFunctionDeclaration(name, null, null));
		efc.getExprs().addAll(exprs);
		
		return efc;
	}
	
	
	public AffineFunction createAffineFunction(Function mapping) {
		assert(mapping != null);
		AffineFunction func = fact.createAffineFunction();
		func.setPMmapping(mapping);
		return func;
	}
	
	public AffineFunction createAffineFunction(List<Variable> params, List<Variable> vars, List<AffineExpression> exprs) {
		DimensionsManager manager = PolymodelComponent.INSTANCE.getDefaultDimensionsManager(PolyhedralIRModule.INSTANCE);
		List<IntExpression> intExprs = new ArrayList<IntExpression>(exprs.size());
		
		for (AffineExpression expr : exprs) {
			intExprs.add(expr);
		}

		List<OutputDimension> outDims = new ArrayList<OutputDimension>(exprs.size());
		for (int i = 0; i < Math.min(exprs.size(), vars.size()); i++) {
			outDims.add(manager.getOutputDimension(vars.get(i)));
		}
		for (int i = vars.size(); i < exprs.size(); i++) {
			outDims.add(manager.getOutputDimension(manager.getDimension(i)));
		}

		
		return createAffineFunction(_polyFact.createFunction(vars, outDims, params, intExprs));
	}
//	/**
//	 * Creates a new IndexDimension with the specified name.
//	 * 
//	 * @param dom
//	 * @param name
//	 * @return
//	 */
//	public IndexDimension createNewDimension(Domain dom, String name) {
//		//I don't know who did it, but do not change this to getDim()+1, it messes up many things
//		return _polyFact.createIndexDimension(dom.getDim(), name);
//	}
//
//	/**
//	 * Creates a new IndexDimension with the specified name.
//	 * 
//	 * @param dom
//	 * @param name
//	 * @return
//	 */
//	public IndexDimension createNewDimension(AffineFunction func, String name) {
//		//I don't know who did it, but do not change this to getDimLHS()+1, it messes up many things
//		return _polyFact.createIndexDimension(func.getDimLHS(), name);
//	}
	
	
	// FastISLDomain - FastISLMap constructors
	public FastISLDomain createFastISLDomain(JNIISLSet set) {
		List<Variable> lInds = new BasicEList<Variable>();
		for (int k=0; k<set.getNbDims(JNIISLDimType.isl_dim_set); k++)
			lInds.add(PolymodelComponent.INSTANCE.getDefaultDimensionsManager().getDimension(k));
		
		List<Variable> lParams = new BasicEList<Variable>();
		for (int k=0; k<set.getNbDims(JNIISLDimType.isl_dim_param); k++)
			lParams.add(PolymodelComponent.INSTANCE.getDefaultDimensionsManager().getParameter(k,set.getDimName(JNIISLDimType.isl_dim_param, k)));
		
		DomainDimensions domDims = _polyFact.createDomainDimensions(lInds, lParams);
		return createFastISLDomain(domDims, set);
	}
	
	public FastISLDomain createFastISLDomain(DomainDimensions domDims, JNIISLSet set) {
		FastISLDomain fdom = fact.createFastISLDomain();
		fdom.setDomDims(domDims);
		fdom.setIslSet(set);
		
		return fdom;
	}
	
	public FastISLDomain createFastISLDomain(org.polymodel.Domain dom) {
		JNIISLSet set = ISLNativeBinder.jniIslSet(dom);
		return createFastISLDomain(dom.getDimensions(), set);
	}
	
	public FastISLDomain createFastISLDomain(List<Variable> lparams, List<Variable> lind, List<Matrix> lmat) {
		DomainDimensions domDims = _polyFact.createDomainDimensions(lind, lparams);
		return createFastISLDomain(domDims,lmat);
	}
	
	public FastISLDomain createFastISLDomain(DomainDimensions domDims, List<Matrix> lmat) {
		List<Variable> lparams = domDims.getParameters();
		List<Variable> linds = domDims.getIndices();
		int nParam = lparams.size();
		int nInds = linds.size();
		
		String strISLDom = "[";
		for (int i=0; i<nParam; i++)
			if (i==0)
				strISLDom += lparams.get(i).getName();
			else
				strISLDom += "," + lparams.get(i).getName();
		strISLDom += "] -> { [";
		// Indices
		for (int i=0; i<nInds; i++)
			if (i==0)
				strISLDom += linds.get(i).getName();
			else
				strISLDom += "," + linds.get(i).getName();
		strISLDom += "] : ";
		
		if (lmat.isEmpty()) {
			strISLDom += " 1=0 }";
			JNIISLSet islSet = JNIISLSet.buildFromString(JNIISLContext.getCtx(), strISLDom);

			System.out.println("islSet = " + islSet.toString());
			
			
			FastISLDomain fdom = createFastISLDomain(domDims, islSet);
			
			// TODO: bug. Empty in isl is not coded like in AlphaZ... :/
			
			System.out.println("fdom = " + fdom.toString());
			
			// TODO: still does not work...(simplified ??? :/ )
			
			return fdom;
		}
		
		String strISLDomSuffix = strISLDom;
		
		// Build the constraints from the matrix mat
		List<JNIISLBasicSet> lbsets = new BasicEList<JNIISLBasicSet>();
		for (Matrix mat: lmat) {
			strISLDom = strISLDomSuffix;
			
		for (int i=0; i<mat.getNbRows(); i++) {
			MatrixRow mRow = mat.getRows().get(i);
			
			if (i>0)
				strISLDom += " && ";
			
			boolean isEquality = (mRow.get(0)==0);		// 1=inequality / 0 = equality
			
			boolean firstNonZeroValue = true;
			
			// Parameters
			for (int j=0; j<nParam; j++) {
				long coeff = mRow.get(j+1);
				if (coeff==0)
					continue;
				if (coeff>0) {
					if (!firstNonZeroValue)
						strISLDom += " + ";
					else
						firstNonZeroValue = false;
					strISLDom += coeff + "*" + lparams.get(j).getName();
				} else {
					if (firstNonZeroValue)
						firstNonZeroValue = false;
					strISLDom += "-" + (-coeff) + "*" + lparams.get(j).getName();
				}
			}
			
			// Indices
			for (int j=0; j<nInds; j++) {
				long coeff = mRow.get(j+nParam+1);
				if (coeff==0)
					continue;
				if (coeff>0) {
					if (!firstNonZeroValue)
						strISLDom += " + ";
					else
						firstNonZeroValue = false;
					strISLDom += coeff + "*" + linds.get(j).getName();
				} else {
					if (firstNonZeroValue)
						firstNonZeroValue = false;
					strISLDom += "-" + (-coeff) + "*" + linds.get(j).getName();
				}
			}
			
			// Constant
			long coeff = mRow.get(nParam+nInds+1);
			if (coeff>0) {
				if (!firstNonZeroValue)
					strISLDom += " + ";
				else
					firstNonZeroValue = false;
				strISLDom += coeff;
			}
			if (coeff<0) {
				if (firstNonZeroValue)
					firstNonZeroValue = false;
				strISLDom += "-" + (-coeff);
			}
			
			// If we have an empty line
			if (firstNonZeroValue)
				strISLDom += "0";
			
			if (isEquality)
				strISLDom += " = 0";
			else
				strISLDom += " >= 0";
			
		}
		strISLDom += " }";
		
		JNIISLBasicSet islbSet = JNIISLBasicSet.buildFromString(JNIISLContext.getCtx(), strISLDom);
		lbsets.add(islbSet);
		}
		
		JNIISLSet islSet = lbsets.get(0).toSet();
		for (int i=1; i<lbsets.size(); i++)
			islSet = islSet.union(lbsets.get(i).toSet());
		return createFastISLDomain(domDims, islSet);
	}
	
	public FastISLDomain createFastISLDomainMatLong(List<Variable> lparams, List<Variable> lind, List<long[][]> lmat) {
		DomainDimensions domDims = _polyFact.createDomainDimensions(lind, lparams);
		return createFastISLDomainMatLong(domDims,lmat);
	}
	
	public FastISLDomain createFastISLDomainMatLong(DomainDimensions domDims, List<long[][]> lmat) {
		List<Variable> lparams = domDims.getParameters();
		List<Variable> linds = domDims.getIndices();
		int nParam = lparams.size();
		int nInds = linds.size();
		
		
		String strISLDom = "[";
		for (int i=0; i<nParam; i++)
			if (i==0)
				strISLDom += lparams.get(i).getName();
			else
				strISLDom += "," + lparams.get(i).getName();
		strISLDom += "] -> { [";
		// Indices
		for (int i=0; i<nInds; i++)
			if (i==0)
				strISLDom += linds.get(i).getName();
			else
				strISLDom += "," + linds.get(i).getName();
		strISLDom += "] : ";

		String strISLDomSuffix = strISLDom;
		
		// Build the constraints from the matrix mat
		List<JNIISLBasicSet> lbsets = new BasicEList<JNIISLBasicSet>();
		for (long[][] mat: lmat) {
			strISLDom = strISLDomSuffix;
		for (int i=0; i<mat.length; i++) {
			
			if (i>0)
				strISLDom += " && ";
			
			boolean isEquality = (mat[i][0]==0);		// 1=inequality / 0 = equality
			
			boolean firstNonZeroValue = true;
			
			// Parameters
			for (int j=0; j<nParam; j++) {
				long coeff = mat[i][j+1];
				if (coeff==0)
					continue;
				if (coeff>0) {
					if (!firstNonZeroValue)
						strISLDom += " + ";
					else
						firstNonZeroValue = false;
					strISLDom += coeff + "*" + lparams.get(j).getName();
				} else {
					if (firstNonZeroValue)
						firstNonZeroValue = false;
					strISLDom += "-" + (-coeff) + "*" + lparams.get(j).getName();
				}
			}
			
			// Indices
			for (int j=0; j<nInds; j++) {
				long coeff = mat[i][j+nParam+1];
				if (coeff==0)
					continue;
				if (coeff>0) {
					if (!firstNonZeroValue)
						strISLDom += " + ";
					else
						firstNonZeroValue = false;
					strISLDom += coeff + "*" + linds.get(j).getName();
				} else {
					if (firstNonZeroValue)
						firstNonZeroValue = false;
					strISLDom += "-" + (-coeff) + "*" + linds.get(j).getName();
				}
			}
			
			// Constant
			long coeff = mat[i][nParam+nInds+1];
			if (coeff>0) {
				if (!firstNonZeroValue)
					strISLDom += " + ";
				else
					firstNonZeroValue = false;
				strISLDom += coeff;
			}
			if (coeff<0) {
				if (firstNonZeroValue)
					firstNonZeroValue = false;
				strISLDom += "-" + (-coeff);
			}
			
			// If we have an empty line
			if (firstNonZeroValue)
				strISLDom += "0";
			
			if (isEquality)
				strISLDom += " = 0";
			else
				strISLDom += " >= 0";
			
		}
		strISLDom += " }";
		
		JNIISLBasicSet islbSet = JNIISLBasicSet.buildFromString(JNIISLContext.getCtx(), strISLDom);
		lbsets.add(islbSet);
		}
		
		// DEBUG
		//System.out.println(strISLDom);
		
		JNIISLSet islSet = lbsets.get(0).toSet();
		for (int i=1; i<lbsets.size(); i++)
			islSet = islSet.union(lbsets.get(i).toSet());
		return PolyhedralIRUserFactory.eINSTANCE.createFastISLDomain(domDims, islSet);
	}
	
	
	public FastISLMap createFastISLMap(JNIISLBasicMap map) {
		List<Variable> lInds = new BasicEList<Variable>();
		for (int k=0; k<map.getNbDims(JNIISLDimType.isl_dim_in); k++)
			lInds.add(PolymodelComponent.INSTANCE.getDefaultDimensionsManager().getDimension(k));
		
		List<Variable> lParams = new BasicEList<Variable>();
		for (int k=0; k<map.getNbDims(JNIISLDimType.isl_dim_param); k++)
			lParams.add(PolymodelComponent.INSTANCE.getDefaultDimensionsManager().getParameter(k,map.getDimName(JNIISLDimType.isl_dim_param, k)));
		
		DomainDimensions domDims = _polyFact.createDomainDimensions(lInds, lParams);
		return createFastISLMap(domDims, map, (Label) null, (Label) null);
	}
	
	public FastISLMap createFastISLMap(DomainDimensions domDims, JNIISLBasicMap map, Label in, Label out) {
		FastISLMap fmap = fact.createFastISLMap();
		fmap.setDomDims(domDims);
		fmap.setIslMap(map);
		fmap.setLabelIn(in);
		fmap.setLabelOut(out);
		
		return fmap;
	}
	
	public FastISLMap createFastISLMap(Function func) {
		JNIISLBasicMap fmap = ISLNativeBinder.jniIslBasicMapNoString(func);
		return createFastISLMap(func.getDimensions(), fmap, func.getIn(), func.getOut());
	}
	
	public FastISLMap createFastISLMap(List<Variable> lparams, List<Variable> linds, List<String> lexpr) {
		DomainDimensions domDims = _polyFact.createDomainDimensions(linds, lparams);
		return createFastISLMap(domDims, lexpr);
	}
	
	public FastISLMap createFastISLMap(DomainDimensions domDims, List<String> lexpr) {
		
		List<Variable> lparams = domDims.getParameters();
		List<Variable> linds = domDims.getIndices();
		
		// Parameters
		String strISLMap = "[";
		for (int i=0; i<lparams.size(); i++)
			if (i==0)
				strISLMap += lparams.get(i).getName();
			else
				strISLMap += "," + lparams.get(i).getName();
		strISLMap += "] -> { [";
		// Indices
		for (int i=0; i<linds.size(); i++)
			if (i==0)
				strISLMap += linds.get(i).getName();
			else
				strISLMap += "," + linds.get(i).getName();
		strISLMap += "] -> [";
		// Expression
		for (int i=0; i<lexpr.size(); i++)
			if (i==0)
				strISLMap += lexpr.get(i);
			else
				strISLMap += "," + lexpr.get(i);
		strISLMap += "] }";

		JNIISLBasicMap islMap = JNIISLBasicMap.buildFromString(JNIISLContext.getCtx(), strISLMap);
		
		return createFastISLMap(domDims, islMap, null, null);
	}
	
	public FastISLMap createFastISLMap(List<Variable> lparams, List<Variable> linds, Matrix mat) {
		DomainDimensions domDims = _polyFact.createDomainDimensions(linds, lparams);
		return createFastISLMap(domDims, mat);
	}
	
	public FastISLMap createFastISLMapWithConstraintsOnInputDim(DomainDimensions domDims, List<String> lexpr, List<String> lConstrIn) {
		
		List<Variable> lparams = domDims.getParameters();
		List<Variable> linds = domDims.getIndices();
		
		// Parameters
		String strISLMap = "[";
		for (int i=0; i<lparams.size(); i++)
			if (i==0)
				strISLMap += lparams.get(i).getName();
			else
				strISLMap += "," + lparams.get(i).getName();
		strISLMap += "] -> { [";
		// Indices
		for (int i=0; i<linds.size(); i++) {
			if (i!=0)
				strISLMap += ",";
			strISLMap += linds.get(i).getName();
		}
		strISLMap += "] -> [";
		// Expression
		for (int i=0; i<lexpr.size(); i++)
			if (i==0)
				strISLMap += lexpr.get(i);
			else
				strISLMap += "," + lexpr.get(i);
		strISLMap += "] ";
		
		if (lConstrIn.size()>0) {
			strISLMap += ": ";
			for (int i=0; i<lConstrIn.size(); i++) {
				String constrInStr = lConstrIn.get(i);
				if (i!=0)
					strISLMap += " and ";
				strISLMap += constrInStr;
			}
		}
		
		strISLMap += " }";
		
		JNIISLBasicMap islMap = JNIISLBasicMap.buildFromString(JNIISLContext.getCtx(), strISLMap);

		return createFastISLMap(domDims, islMap, null, null);
	}
	
	
	public FastISLMap createFastISLMap(DomainDimensions domDims, Matrix mat) {
		List<Variable> linds = domDims.getIndices();
		List<Variable> lparams = domDims.getParameters();
		int nInds = linds.size();
		int nParam = lparams.size();
		
		List<String> lStrFunc = new BasicEList<String>();
		for (int i=0; i<mat.getNbRows(); i++) {
			MatrixRow mRow = mat.getRows().get(i);
			String strRow = "";
			
			boolean firstNonZeroValue = true;
			
			// Parameters
			for (int j=0; j<nParam; j++) {
				long coeff = mRow.get(j);
				if (coeff==0)
					continue;
				if (coeff>0) {
					if (!firstNonZeroValue)
						strRow += " + ";
					else
						firstNonZeroValue = false;
					strRow += coeff + "*" + lparams.get(j).getName();
				} else {
					if (firstNonZeroValue)
						firstNonZeroValue = false;
					strRow += "-" + (-coeff) + "*" + lparams.get(j).getName();
				}
			}
			
			// Indices
			for (int j=0; j<nInds; j++) {
				long coeff = mRow.get(j+nParam);
				if (coeff==0)
					continue;
				if (coeff>0) {
					if (!firstNonZeroValue)
						strRow += " + ";
					else
						firstNonZeroValue = false;
					strRow += coeff + "*" + linds.get(j).getName();
				} else {
					if (firstNonZeroValue)
						firstNonZeroValue = false;
					strRow += "-" + (-coeff) + "*" + linds.get(j).getName();
				}
			}
			
			// Constant
			long coeff = mRow.get(nParam+nInds);
			if (coeff>0) {
				if (!firstNonZeroValue)
					strRow += " + ";
				else
					firstNonZeroValue = false;
				strRow += coeff;
			}
			if (coeff<0) {
				if (firstNonZeroValue)
					firstNonZeroValue = false;
				strRow += "-" + (-coeff);
			}
			
			// If we have an empty line
			if (firstNonZeroValue)
				strRow += "0";
			
			lStrFunc.add(strRow);
		}
		
		// DEBUG
		//for (String str : lStrFunc)
		//	System.out.println(str);
		
		return createFastISLMap(domDims, lStrFunc);
	}
	
	public FastISLMap createFastISLMapMatLong(List<Variable> lparams, List<Variable> lind, long[][] longmat) {
		DomainDimensions domDims = _polyFact.createDomainDimensions(lind, lparams);
		return createFastISLMapMatLong(domDims,longmat);
	}
	
	public FastISLMap createFastISLMapMatLong(DomainDimensions domDims, long[][] longmat) {
		List<Variable> linds = domDims.getIndices();
		List<Variable> lparams = domDims.getParameters();
		int nInds = linds.size();
		int nParam = lparams.size();
		
		List<String> lStrFunc = new BasicEList<String>();
		for (int i=0; i<longmat.length; i++) {
			String strRow = "";
			
			boolean firstNonZeroValue = true;
			
			// Parameters
			for (int j=0; j<nParam; j++) {
				long coeff = longmat[i][j];
				if (coeff==0)
					continue;
				if (coeff>0) {
					if (!firstNonZeroValue)
						strRow += " + ";
					else
						firstNonZeroValue = false;
					strRow += coeff + "*" + lparams.get(j).getName();
				} else {
					if (firstNonZeroValue)
						firstNonZeroValue = false;
					strRow += "-" + (-coeff) + "*" + lparams.get(j).getName();
				}
			}
			
			// Indices
			for (int j=0; j<nInds; j++) {
				long coeff = longmat[i][j+nParam];
				if (coeff==0)
					continue;
				if (coeff>0) {
					if (!firstNonZeroValue)
						strRow += " + ";
					else
						firstNonZeroValue = false;
					strRow += coeff + "*" + linds.get(j).getName();
				} else {
					if (firstNonZeroValue)
						firstNonZeroValue = false;
					strRow += "-" + (-coeff) + "*" + linds.get(j).getName();
				}
			}
			
			// Constant
			long coeff = longmat[i][nParam+nInds];
			if (coeff>0) {
				if (!firstNonZeroValue)
					strRow += " + ";
				else
					firstNonZeroValue = false;
				strRow += coeff;
			}
			if (coeff<0) {
				if (firstNonZeroValue)
					firstNonZeroValue = false;
				strRow += "-" + (-coeff);
			}
			
			// If we have an empty line
			if (firstNonZeroValue)
				strRow += "0";
			
			lStrFunc.add(strRow);
		}
		
		// DEBUG
		//for (String str : lStrFunc)
		//	System.out.println(str);
		
		return createFastISLMap(domDims, lStrFunc);
	}
	
}
