package edu.csu.melange.alphaz.mde.core;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.algebra.util.PolymodelRegexParser;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.matrix.Matrix;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.DATATYPE;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.SIGNED;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.Type;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.VariableIdentifier;
import org.polymodel.polyhedralIR.expression.BinaryExpression;
import org.polymodel.polyhedralIR.expression.BooleanExpression;
import org.polymodel.polyhedralIR.expression.DependenceExpression;
import org.polymodel.polyhedralIR.expression.IfExpression;
import org.polymodel.polyhedralIR.expression.IntegerExpression;
import org.polymodel.polyhedralIR.expression.RealExpression;
import org.polymodel.polyhedralIR.expression.ReduceExpression;
import org.polymodel.polyhedralIR.expression.UnaryExpression;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations;
import org.polymodel.polyhedralIR.transformation.helper.ReplaceVariableExpression;
import org.polymodel.polyhedralIR.util.ContextDomainCalculator;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;

import com.google.inject.Injector;

import edu.csu.melange.alphabets.xtext.AlphabetsModelReader;
import edu.csu.melange.alphabets.xtext.AlphabetsStandaloneSetup;
import edu.csu.melange.alphabets.xtext.alphabets.AAdditiveExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AAffineSystem;
import edu.csu.melange.alphabets.xtext.alphabets.AAlphabetsExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AAndExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ABooleanExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ACaseExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ADependenceExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ADependenceInArrayNotation;
import edu.csu.melange.alphabets.xtext.alphabets.ADomain;
import edu.csu.melange.alphabets.xtext.alphabets.AEquation;
import edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionCall;
import edu.csu.melange.alphabets.xtext.alphabets.AExternalFunctionDeclaration;
import edu.csu.melange.alphabets.xtext.alphabets.AFunction;
import edu.csu.melange.alphabets.xtext.alphabets.AFunctionInArrayNotation;
import edu.csu.melange.alphabets.xtext.alphabets.AIfExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AIndexExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AInputDeclaration;
import edu.csu.melange.alphabets.xtext.alphabets.AIntegerExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ALocalDeclaration;
import edu.csu.melange.alphabets.xtext.alphabets.AMinMaxExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AModuloExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AMultiArgArithmeticExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AMultiArgLogicalExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AMultiplicativeExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ANegateExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ANotExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AOrExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AOutputDeclaration;
import edu.csu.melange.alphabets.xtext.alphabets.APolyhedron;
import edu.csu.melange.alphabets.xtext.alphabets.AProgram;
import edu.csu.melange.alphabets.xtext.alphabets.ARealExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AReduceExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ARelationalExpression;
import edu.csu.melange.alphabets.xtext.alphabets.ARestrictExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AStandardEquation;
import edu.csu.melange.alphabets.xtext.alphabets.AType;
import edu.csu.melange.alphabets.xtext.alphabets.AUseEquation;
import edu.csu.melange.alphabets.xtext.alphabets.AVariableDeclaration;
import edu.csu.melange.alphabets.xtext.alphabets.AVariableExpression;
import edu.csu.melange.alphabets.xtext.alphabets.AlphabetsVisitable;
import edu.csu.melange.alphabets.xtext.alphabets.impl.AlphabetsDepthFirstVisitorImpl;

/**
 * Generates Polyhedral IR from alphabets parsed using xtext. This visitor is
 * expected to be applied to the root model only (AProgram).
 * 
 * 
 * TODO Book keeping of current domain is not complete. The domain will change
 * after dependence expression, but computing new domain requires taking the
 * image of the current domain with the dependence function. polymodel currently
 * lacks the methods to do this.
 * 
 * @author Tomofumi Yuki
 * 
 */
public class AlphabetsToPolyhedralIR extends AlphabetsDepthFirstVisitorImpl {

	private PolyhedralIRUserFactory _polyIRFact;

	private AlphabetsParseResult parseResult;
	
	private Program _program;
	private AffineSystem _currentSystem;
	private Expression _currentExpression;
	
	// Current Domain is used to keep track of the names of the indices. Its constraints should not be used
	// Also, it should only be used in equations written in AShow form
	private Domain _currentDomain;
	private ParameterDomain _parameterDomain;				// Parameter domain of _currentSystem (has only parameters)
	private List<String> _currentAShowIndices;				// Indices that might be introduced by the left-hand side of a StandardEquation
	private AStandardEquation _currentEquation;				// Only used for "AShowErrorMessage"
	
	// For the parsing of inputs in a useEquation
	//private Domain _currentExtDom;		// Equal to the extension domain while parsing the inputs of a use equation, null else.
	//private boolean _isUseEquation;		// True iff we are parsing an input expression of a use equation.

	public static AlphabetsParseResult readAlphabets(String file) throws IOException {
		AProgram start = AlphabetsModelReader.loadModel(file);
		
		AlphabetsToPolyhedralIR visitor = new AlphabetsToPolyhedralIR();
		start.accept(visitor);

		Program program = visitor.parseResult.program;
		program.setFilename((new File(file)).getName());
		
		if (visitor.parseResult.isParsed()) {
			ContextDomainCalculator.computeContextDomain(program);
		}
		return visitor.parseResult;
	}
	
	/**
	 * Parse the string of an Expression in Alphabet syntax.
	 * 
	 * @param strExpr
	 * @param affsyst
	 * @param indexes
	 * @return expr
	 */
	public static Expression readExpression(String strExpr, AffineSystem affsyst, List<String> freeInds) {
		/* ** Step 1: create a dummy system to surround the specified expression, where:
			- Variables declarations (as inputs): copy of all the variable declarations of "affsyst"
			- Single output (named "Local_[k]" with [k] big enough)
			- Single StandardEquation "Local_[k] = strExpr"
		  => Create the corresponding string and parse it!
		*/
		String systExpr = "affine systParsed " + affsyst.getParameters().toString() + "\n";
		systExpr += "input\n";
		
		List<VariableDeclaration> lvarDeclOrig = new BasicEList<VariableDeclaration>();
		lvarDeclOrig.addAll(affsyst.getInputs());
		lvarDeclOrig.addAll(affsyst.getOutputs());
		lvarDeclOrig.addAll(affsyst.getLocals());
		for (VariableDeclaration vardecl : lvarDeclOrig) {
			systExpr += "\t" + PolyhedralIRToAlphabets.toString(vardecl) + "\n";
		}
		
		systExpr += "output\n";
		String localVarName = findFreshLocalVarName(affsyst);
		String listInds = new String();
		for (int k=0; k<freeInds.size(); k++) {
			if (k==0)
				listInds += freeInds.get(k);
			else
				listInds += "," + freeInds.get(k);
		}
		systExpr += "\t long " + localVarName + " {"+ listInds + "|};\n"; // Dummy type + Dummy domain
		systExpr += "let\n";
		systExpr += "\t " + localVarName + "[" + listInds + "] = " + strExpr + ";\n";
		systExpr +=".\n";
		
		// DEBUG
		//System.out.println(systExpr);
		
		// ** Step 2: parsing "systExpr"
		InputStream inpStr;
		try {
			inpStr = new ByteArrayInputStream(systExpr.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			throw new RuntimeException("Unexpected problem of encoding :\n" + systExpr);
		}
		
		
		final Injector injector = new AlphabetsStandaloneSetup().createInjectorAndDoEMFRegistration();
        final ResourceSet set = injector.getInstance(XtextResourceSet.class);
		URI uri = URI.createURI("systExprToParse.ab");
        Resource res = set.createResource(uri);
		
		AProgram dummyAProg;
		try {
			res.load(inpStr, null);
			EObject root = res.getContents().get(0);
	 		dummyAProg = (AProgram) root;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("We should not search for an external ressource to be loaded...");
		}
		
		
		// ** Step 3: Convert the AProgram into a Program
		// 				and extract the expression from dummyProg
		AlphabetsToPolyhedralIR visitor = new AlphabetsToPolyhedralIR();
		dummyAProg.accept(visitor);
		Program dummyProg = visitor._program;
		Expression dummyExpr = dummyProg.getSystem("systParsed").getEquations().get(0).getExpression();
		
		// ** Step 4: Replace the VariableDeclaration reference used in dummyExpr with the correct ones
		for (VariableDeclaration varDeclDummy : dummyProg.getSystem("systParsed").getInputs())
			ReplaceVariableExpression.transform(dummyExpr, varDeclDummy, affsyst.getVariableDeclaration(varDeclDummy.getName()));
		
		return dummyExpr;
	}
	/* --- If we got a way to use Alphabet's lexer to get a "AAlphabetsExpression aExpr",
	 * the following code is cleaner for readExpression:
	[Include the way to get aExpr (AAlphabetsExpression)]
	
	AlphabetsToPolyhedralIR visitor = new AlphabetsToPolyhedralIR();
	visitor.initReadExpr(prog, affsyst,freeInds);
	aExpr.accept(visitor);
	return visitor._currentExpression;
	
	[Where]
	
	private void initReadExpr(Program prog, String affsyst, List<String> indexes) {
		_program = prog;
		_currentSystem = prog.getSystem(affsyst);
		
		_parameterDomain = _currentSystem.getParameters();
		_currentAShowIndices = indexes;
		
		// For _currentDomain, we create a domain with only the "_parameterDomain"'s constraints
		String lindexes = new String();
		for (int i=0; i<indexes.size(); i++) {
			if (i==0)
				lindexes += indexes.get(0);
			else
				lindexes += "," + indexes.get(i);
		}
		_currentDomain = PolyhedralIRUtility.parseDomain(_parameterDomain, "{"+ lindexes +"|}");
	}
	*/
	
	/**
	 * Find the first "Local_[k]" which is not used in the system "syst"
	 * 
	 * @param syst
	 * @return "Local_[k]"
	 */
	private static String findFreshLocalVarName (AffineSystem syst) {
		String basestr = "Local_";
		int k=0;
		while (syst.containsVariable(basestr+k))
			k++;
		return (basestr +k);
	}
	
	protected AlphabetsToPolyhedralIR() {
		_polyIRFact = PolyhedralIRUserFactory.eINSTANCE;
	}

	/**
	 * Parses a parameter domain, that does not have any surrounding domain.
	 * 
	 * @param domain
	 * @return
	 */
	private ParameterDomain parseParameterDomain(ADomain domain) {
		List<List<String>> ids = new LinkedList<List<String>>();
		List<List<String>> constraints = new LinkedList<List<String>>();
		
		for (APolyhedron poly : domain.getPolyhedra()) {
			ids.add(Arrays.asList(poly.getIndexes().getIds().toArray(new String[0])));
			constraints.add(Arrays.asList(poly.getConstraints().toArray(new String[0])));
		}
		ParameterDomain param =  PolyhedralIRUtility.parseParameterDomainUnion(ids, constraints);
		return param;
	}

	/**
	 * Parses a domain with one outerDomain surrounding it.
	 * 
	 * @param outerDomain
	 * @param domain
	 * @return
	 */
	private Domain parseVariableDomain(ADomain domain) {
		List<List<String>> ids = new LinkedList<List<String>>();
		List<List<String>> constraints = new LinkedList<List<String>>();

		// Scalar
		if (domain == null) {
			return PolyhedralIRUtility.createUniverseDomain(_parameterDomain.getParams(), _parameterDomain.getIndices());
		}

		// Add a list for each polyhedron
		for (APolyhedron poly : domain.getPolyhedra()) {
			// Indexes
			if (poly.getIndexes() == null) {
				ids.add(new LinkedList<String>());
			} else {
				ids.add(poly.getIndexes().getIds());
			}
			// Constraints
			if (poly.getConstraints() == null) {
				constraints.add(new LinkedList<String>());
			} else {
				constraints.add(poly.getConstraints());
			}
		}
		return PolyhedralIRUtility.parseDomainUnionFromString(_parameterDomain, ids, constraints);
	}

	private Domain parseRestrictDomain(Domain outerDomain, ADomain domain) {
		List<List<String>> ids = new LinkedList<List<String>>();
		List<List<String>> constraints = new LinkedList<List<String>>();

		// Add a list for each polyhedron
		for (APolyhedron poly : domain.getPolyhedra()) {
			// Indexes
			// Show case
			if (poly.getIndexes() != null && poly.getIndexes().getIds().size() > 0) {
				ids.add(poly.getIndexes().getIds());
				// AShow case
			} else {
				if (_currentAShowIndices == null) {
					AShowErrorMessageRestrict();
				}
				ids.add(_currentAShowIndices);
			}
			// Constraints
			if (poly.getConstraints() == null) {
				constraints.add(new LinkedList<String>());
			} else {
				constraints.add(poly.getConstraints());
			}
		}
		Domain ret = PolyhedralIRUtility.parseDomainUnionFromString(_parameterDomain, ids, constraints);

		return ret;
	}

	/**
	 * Parses input variable declarations. There are no special handling at the
	 * moment, directly passes on to the generic declaration parser.
	 * 
	 * @param decls
	 * @return
	 */
	private List<VariableDeclaration> parseInputDeclarations(EList<AInputDeclaration> decls) {
		List<VariableDeclaration> res = new LinkedList<VariableDeclaration>();
		for (AVariableDeclaration decl : decls) {
			res.addAll(parseVariableDeclaration(decl));
		}
		return res;
	}

	private List<VariableDeclaration> parseOutputDeclarations(EList<AOutputDeclaration> decls) {
		List<VariableDeclaration> res = new LinkedList<VariableDeclaration>();
		for (AVariableDeclaration decl : decls) {
			res.addAll(parseVariableDeclaration(decl));
		}
		return res;
	}

	private List<VariableDeclaration> parseLocalDeclarations(EList<ALocalDeclaration> decls) {
		List<VariableDeclaration> res = new LinkedList<VariableDeclaration>();
		for (AVariableDeclaration decl : decls) {
			res.addAll(parseVariableDeclaration(decl));
		}
		return res;
	}

	/**
	 * Parses a variable declaration. The returned list may contain more than
	 * one element, because the syntax allows for multiple variable (with same
	 * type and domain) to be declared together. However, the domain model
	 * created will be separate.
	 * 
	 * @param decl
	 * @return
	 */
	private List<VariableDeclaration> parseVariableDeclaration(AVariableDeclaration decl) {
		List<VariableDeclaration> res = new LinkedList<VariableDeclaration>();

		Type type = parseType(decl.getType());
		// A declaration may be for multiple identifiers
		for (String id : decl.getIdentifierList().getIdentifiers()) {
			// domain should be different for each variable
			try {
				Domain domain = parseVariableDomain(decl.getDomain());
				VariableIdentifier var = _polyIRFact.createVariableIdentifier(id);
				res.add(_polyIRFact.createVariableDeclaration(var, type, domain));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Failed to parse the domain of variable " + decl.getIdentifierList().getIdentifiers());
			}
		}
		return res;
	}

	private AffineFunction parseFunction(AFunction func) {
		if (func.getFunc() == null)
			return PolyhedralIRUtility.parseAffineFunction(_parameterDomain, func.getIndexes().getIds(), new LinkedList<String>());
		else
			return PolyhedralIRUtility.parseAffineFunction(_parameterDomain, func.getIndexes().getIds(), func.getFunc().getExprs());
	}

	private Type parseType(AType vt) {
		SIGNED signed = SIGNED.SIGNED;
		DATATYPE type;
		int width;

		if (vt.getUnsigned() != null && vt.getUnsigned().compareTo("unsigned") == 0) {
			signed = SIGNED.UNSIGNED;
		}

		// Hopefully replaced with switch with java 1.7 TODO
		if (vt.getType().compareTo("short") == 0) {
			type = DATATYPE.INTEGER;
			width = DATATYPE.SHORT_WIDTH;
		} else if (vt.getType().compareTo("int") == 0) {
			type = DATATYPE.INTEGER;
			width = DATATYPE.INT_WIDTH;
		} else if (vt.getType().compareTo("long") == 0) {
			type = DATATYPE.INTEGER;
			width = DATATYPE.LONG_WIDTH;
		} else if (vt.getType().compareTo("float") == 0) {
			type = DATATYPE.FLOATING_POINT;
			width = DATATYPE.INT_WIDTH;
		} else if (vt.getType().compareTo("double") == 0) {
			type = DATATYPE.FLOATING_POINT;
			width = DATATYPE.LONG_WIDTH;
		} else if (vt.getType().compareTo("bool") == 0) {
			type = DATATYPE.BOOL;
			signed = SIGNED.UNSIGNED;
			width = 1;
		} else if (vt.getType().compareTo("char") == 0) {
			type = DATATYPE.CHAR;
			width = 1;
		} else {
			throw new UnsupportedOperationException("Unsuppoted type : " + vt.getType());
		}

		return _program.getType(signed, type, width);
	}
	
	private void AShowErrorMessage(String message) {
		String locStr = String.format("\tat system:%s equation:%s", _currentSystem.getName(), _currentEquation.getVar());
		throw new AlphabetsException("Indices must be named on LHS for using AShow syntax:\n" + locStr + " "+message);
	}

	private void AShowErrorMessageRestrict() {
		AShowErrorMessage("while parsing restrict expression.");
	}
	private void AShowErrorMessageDependence() {
		AShowErrorMessage("while parsing dependence in array notation.");
	}
	private void AShowErrorMessageReduce() {
		AShowErrorMessage("while parsing projection function of reduce expression.");
	}
	@Override
	public void defaultIn(AlphabetsVisitable node) {
		// System.out.println(node);
	}

	/**
	 * In the root node, initialize the root node of the polyIR
	 * We also initialize the AffineSystems and the input declarations
	 */
	@Override
	public void inAProgram(AProgram p) {
		_program = _polyIRFact.createProgram();
		 parseResult = new AlphabetsParseResult(_program);
		
		// To be able to link system with UseEquation, we do a first pass where we build partially all the affine systems
		for (AAffineSystem aaf : p.getSystems()) {
			ParameterDomain params;
			try {
				params = parseParameterDomain(aaf.getParameters());
			} catch (RuntimeException re) {
				parseResult._parseErrors.add("Error parsing parameter domain: " + re.getMessage());
				return;
			}
			AffineSystem afTemp = _polyIRFact.createAffineSystem(aaf.getName(), params);
			
			// To be able to have a _currentDomain during the parsing of the input expression in the "use" equation, we also build the input declarations
			_parameterDomain = afTemp.getParameters();
			afTemp.getInputs().addAll(parseInputDeclarations(aaf.getInputDeclarations()));
			afTemp.getOutputs().addAll(parseOutputDeclarations(aaf.getOutputDeclarations()));
			_parameterDomain = null;
			
			_program.getSystems().add(afTemp);
		}
	}

	@Override
	public void visitAExternalFunctionDeclaration(AExternalFunctionDeclaration e) {
		List<Type> inputs = new LinkedList<Type>();
		for (AType type : e.getInputs()) {
			inputs.add(parseType(type));
		}
		_program.getExternalFunctionDeclarations().add(_polyIRFact.createExternalFunctionDeclaration(e.getName().getName(), parseType(e.getOutput()), inputs));
	}

	/**
	 * When a system is encountered, create the system, parse parameter and
	 * variable declarations, and then traverse each equation.
	 * 
	 */
	@Override
	public void visitAAffineSystem(AAffineSystem a) {
		try {
			// We get the already-built affine system and work on it
			_currentSystem = _program.getSystem(a.getName());
		
			// set outer domain
			_currentDomain = _currentSystem.getParameters().copy();
			_parameterDomain = _currentSystem.getParameters();
			// variables
			// _currentSystem.getInputs().addAll(parseInputDeclarations(a.getInputDeclarations()));	// Done in "inProgram()"
			_currentSystem.getLocals().addAll(parseLocalDeclarations(a.getLocalvarDeclarations()));
			//_currentSystem.getOutputs().addAll(parseOutputDeclarations(a.getOutputDeclarations())); // Also done in "inProgram()"
			
			// go down further only if its equations
			for (AEquation eq : a.getEquations()) {
				eq.accept(this);
			}
		} catch (RuntimeException re) {
			parseResult._parseErrors.add(re.getMessage());
			return;
		} finally {
			// reset domain
			_currentDomain = null;
			_parameterDomain = null;
		}
	}
	
	/**
	 * Case of a Use Equation
	 */
	@Override
	public void visitAUseEquation(AUseEquation ueq) {
		
		// -- Extension domain
		ParameterDomain locParamDomain = (ParameterDomain) _parameterDomain.copy();
		Domain extdom = _polyIRFact.createDomain(_parameterDomain.getParams(), new BasicEList<Variable>(), locParamDomain.getPMdomain().getPolyhedra());
		List<Variable> indExtDom = new BasicEList<Variable>();
		if (ueq.getExtDom()!= null) {
			extdom = parseVariableDomain(ueq.getExtDom());		// Note: extdom has only variable
			indExtDom = extdom.getIndices();
		}
		
		// -- Reference to the sub-system (which is already -at least partially- built during the preprocessing step (cf "inAProgram") )
		if (!_program.isContainingSystem(ueq.getNameSubSys()))
			throw new AlphabetsException("The subsystem " + ueq.getNameSubSys() + " does not exist");
		AffineSystem subsyst = _program.getSystem(ueq.getNameSubSys());
		
		
		// -- Parameters of the sub-system
		List<AffineExpression> laeparams = new BasicEList<AffineExpression>();
		for (String affExpr : ueq.getParam().getExprs())
			laeparams.add(PolymodelRegexParser.parseAffineExpression(affExpr, indExtDom, _parameterDomain.getParams()));
		AffineFunction params = _polyIRFact.createAffineFunction(_parameterDomain.getParams(), indExtDom, laeparams);
		
		if (params.getExpressions().size()!=subsyst.getParameters().getNParams())
			throw new AlphabetsException("ERROR: In system \"" + _currentSystem.getName() + "\", the number of parameters in the use equation calling \"" +
							subsyst.getName() + "\" do not match (" + params.getExpressions().size() + " when " + subsyst.getParameters().getNParams() + "was expected)");
		
		// -- Outputs of the sub-system
		List<VariableDeclaration> outputs = new BasicEList<VariableDeclaration>();
		for (int i=0; i<ueq.getOutputs().getIdentifiers().size(); i++)
			outputs.add(_currentSystem.getVariableDeclaration(ueq.getOutputs().getIdentifiers().get(i)));
		if (ueq.getOutputs().getIdentifiers().size()!=subsyst.getOutputs().size())
			throw new AlphabetsException("ERROR: In system \"" + _currentSystem.getName() + "\", the number of outputs in the use equation calling \"" +
							subsyst.getName() + "\" do not match (" + ueq.getOutputs().getIdentifiers().size() +
							" when " + subsyst.getOutputs().size() + "was expected)");
		
		// -- Inputs of the sub-system
		//_isUseEquation = true;
		//_currentExtDom = extdom;
		
		if (ueq.getInputs().size()!=subsyst.getInputs().size())
			throw new AlphabetsException("ERROR: In system \"" + _currentSystem.getName() + "\", the number of inputs in the use equation calling \"" +
							subsyst.getName() + "\" do not match (" + ueq.getInputs().size() +
							" when " + subsyst.getInputs().size() + "was expected)");
		
		List<Expression> inputs = new BasicEList<Expression>();
		for (int i=0; i<ueq.getInputs().size(); i++) {
			
			// Update _currentDomain, using the definition in the subsystem
			// Intuition: the input part of the use equation is equivalent with definition of inputs of the sub-system,
			//				using the expressions in the "use" equation
			// To be able to get the domain of the input, we need to pre-build this part in the AST (in "inAProgram")
			// Then, we translate the parameters of this domain into those from the current affine system.
			Domain currentDomain_unTransl = subsyst.getInputs().get(i).getDomain();
			_currentDomain = DomainOperations.translateParams(currentDomain_unTransl, params, extdom);
			
			// _currentAShowIndices = null : no indices are introduced by a lhs...
			
			// --- The following is the translation from one representation to another, and is actually disabled
			// Note: the following rewriting rules are applied inside the input expressions (to go back to Florent's definition):
			// * Dependance:  (i_{1..n} -> f_{1..m})@...	=>	(iExtDom_{1..k}, i_{1..n} -> iExtDom_{1..k}, f_{1..m})@...
			//				If sub-expression is a variable, apply the variable rule now => contatenation of the 2 dependance.
			// * Variable: Var	=>	(iExtDom_{1..k}, i_{1..n} -> i_{1..n})@Var
			//			EXCEPT if the upper node is a dependance function => concatenation of the 2 dependances node (and already done at the dependance level)
			// * Restriction: D: ...	=>	Z^k \times D : ...
			// * Reduce: reduce(op, p, ... ) => reduce(op, Id_{k} \times p, ...)
			// * Case/Op/Constant: No change needed
			// These rules are applied while building the AST of the input expressions, and are triggered by "(_isUseEquation == true)"
			
			// Visiting the input expressions
			(ueq.getInputs().get(i)).accept(this);
			inputs.add(EcoreUtil.copy(_currentExpression));
		}
		
		// Reinitializations
		_currentDomain = _currentSystem.getParameters();
		//_currentExtDom = null;
		//_isUseEquation = false;
		
		
		// -- Building the UseEquation
		UseEquation eq = _polyIRFact.createUseEquation(extdom, subsyst,	params, inputs, outputs);
		_currentSystem.getUseEquations().add(eq);
	}
	
	@Override
	public void visitAStandardEquation(AStandardEquation se) {
		// set domain
		_currentDomain = _currentSystem.getVariableDeclaration(se.getVar()).getDomain().copy();
		
		_currentEquation = se;
		
		
		// Manage the case where the left hand side of an equation is a constant (in this case, se.getIndexes() is null)
		if (_currentDomain.getNIndices()==0)
			_currentAShowIndices = new ArrayList<String>();
		
		
		// In AShow syntax, rename the domain with indices used in the LHS
		if (se.getIndexes() != null) {
			if (_currentDomain.getNIndices() != se.getIndexes().getIds().size()) {
				parseResult._parseErrors.add("Number of indices given in LHS of equation \""+_currentEquation.getVar() + "\" does not match its declaration.");
				return;
//				throw new AlphabetsException("Number of indices given in LHS of equation:"+_currentEquation.getVar() + " does not match its declaration.");
			}
			
			List<Matrix> lMat = _currentDomain.getPMdomain().toMatrices();
			EList<Variable> lnParam = _currentDomain.getParams();
			EList<Variable> lnInds = new BasicEList<Variable>();
			for (int k=0; k<_currentDomain.getNIndices(); k++)
				lnInds.add(PolymodelComponent.INSTANCE.getDefaultDimensionsManager().getDimension(k, se.getIndexes().getIds().get(k)));
			List<IntConstraintSystem> lSyst = new BasicEList<IntConstraintSystem>();
			for (Matrix mat : lMat)
				lSyst.add(mat.toDomain(lnParam, lnInds));
			_currentDomain = _polyIRFact.createDomain(lnParam, lnInds, lSyst);
			
			// OLD -> BUGGY !!!
			//for (int i=0; i<_currentDomain.getNIndices(); i++) {
			//	IndexDimension id = (IndexDimension) _currentDomain.getIndices().get(i);
			//	id.setName(se.getIndexes().getIds().get(i));
			//}
			
			_currentAShowIndices = se.getIndexes().getIds();
		}
		
		// traverse further
		se.getExpr().accept(this);
		
		// add the result to the expression of SE
		StandardEquation eq = _polyIRFact.createStandardEquation(_currentSystem.getVariableDeclaration(se.getVar()), _currentExpression);
		_currentSystem.getEquations().add(eq);
		
		// reset domain
		_currentDomain = _currentSystem.getParameters();
		_currentEquation = null;
		_currentAShowIndices = null;
	}
	
	
	
	/* --- Expression parsing part --- */
	
	/**
	 * Traverses each case and adds it as a list.
	 * 
	 */
	@Override
	public void visitACaseExpression(ACaseExpression c) {
		List<Expression> exprs = new LinkedList<Expression>();
		for (AAlphabetsExpression e : c.getExprs()) {
			e.accept(this);
			exprs.add(_currentExpression);
		}
		_currentExpression = _polyIRFact.createCaseExpression(exprs);
	}

	/**
	 * 
	 * TODO domain probably will change, and function is not used as of now
	 */
	@Override
	public void visitADependenceExpression(ADependenceExpression d) {
		
		AffineFunction dep;
		//if (!_isUseEquation) {		// Case of a standard equation
			if (d.getFunc().getFunc() == null) { 		// When rhs is null, create a dependence to null dimensions
				dep = PolyhedralIRUtility.parseAffineFunction(_parameterDomain, d.getFunc().getIndexes().getIds(), new LinkedList<String>());
			} else { 									// Else treat as dependence normally
				dep = parseFunction(d.getFunc());
			}
		/*} else {					// Case of the input of a use equation
			// Rewriting rules to apply:
			// 1) If the subexpression is a variable, build the node ( i_{ED}, i -> dep(i) ) @ Var (Var being built while visiting this subexpression)
			// 2) Else, build the dependance (i_{ED}, i -> i_{ED}, dep(i)) and continue with the parsing of the subexpression.
			
			List<String> lindLDep = _currentExtDom.getIndexNames();	// Left indexes for the dependence function
			lindLDep.addAll(d.getFunc().getIndexes().getIds());
			
			List<String> lexprRDep = new BasicEList<String>();	// Begining of the right expression (the "i_{ED}" part)
			for (Variable var : _currentExtDom.getIndices())
				lexprRDep.add(var.getName());
			
		 	if (d.getFunc().getFunc() == null) {
		 		if (d.getExpr() instanceof AVariableExpression)		// 1)
		 			dep = PolyhedralIRUtility.parseAffineFunction(_parameterDomain, lindLDep, new LinkedList<String>());
		 		else {												// 2)
		 			dep = PolyhedralIRUtility.parseAffineFunction(_parameterDomain, lindLDep, lexprRDep);
		 		}
		 	} else {
		 		if (d.getExpr() instanceof AVariableExpression) 	// 1)
		 			dep = PolyhedralIRUtility.parseAffineFunction(_parameterDomain, lindLDep, d.getFunc().getFunc().getExprs());
		 		else {												// 2)
		 			lexprRDep.addAll(d.getFunc().getFunc().getExprs());
		 			dep = PolyhedralIRUtility.parseAffineFunction(_parameterDomain, lindLDep, lexprRDep);
		 		}
		 	}
		}*/
		
		// Construct the new domain
		Domain orig = _currentDomain;

		_currentDomain = _currentDomain.image(dep);

		// Parse its child
		d.getExpr().accept(this);
		Expression expr = _currentExpression;

		// Get back to the domain that was current when entering this node
		_currentDomain = orig;

		// When parsing constants, null dimensional function is already added, so check for that
		/*if (expr instanceof DependenceExpression && ((DependenceExpression) expr).getDep().getPMmapping().getExpressions().size() == 0
				&& ((DependenceExpression) expr).getExpr() instanceof ConstantExpression) {
			return;
		} A use case where it is needed ?*/
		
		// If its not constant, create the dependence expression
		DependenceExpression de = _polyIRFact.createDependenceExpression(dep, expr);
		_currentExpression = de;
	}

	/**
	 * 
	 * 
	 */
	@Override
	public void visitAIfExpression(AIfExpression i) {

		i.getCond().accept(this);
		Expression condExpr = _currentExpression;

		i.getThen().accept(this);
		Expression thenExpr = _currentExpression;

		i.getElse().accept(this);
		Expression elseExpr = _currentExpression;
		IfExpression ie = _polyIRFact.createIfExpression(condExpr, thenExpr, elseExpr);

		_currentExpression = ie;
	}

	@Override
	public void visitAIndexExpression(AIndexExpression i) {
		String[] expr = new String[] { i.getFunc().replaceAll("\\[|\\]", "") };
		if (i.getIndexes() == null) {
			//AShow syntax
			if (_currentAShowIndices == null) {
				throw new AlphabetsException("Indices must be named on LHS for using AShow syntax.");
			}
			_currentExpression = _polyIRFact.createIndexExpression(PolyhedralIRUtility.parseAffineFunction(_parameterDomain, _currentAShowIndices,
					Arrays.asList(expr)));
		} else {
			_currentExpression = _polyIRFact.createIndexExpression(PolyhedralIRUtility.parseAffineFunction(_parameterDomain, i.getIndexes().getIds(),
					Arrays.asList(expr)));
		}
	}

	@Override
	public void visitAReduceExpression(AReduceExpression r) {
		Domain orig = _currentDomain;

		List<String> origAShowIndices = null;
		if (_currentAShowIndices != null) {
			origAShowIndices = new ArrayList<String>(_currentAShowIndices.size());
			origAShowIndices.addAll(_currentAShowIndices);
		}
		
		AffineFunction projection;
		// When its in Show form
		if (r.getProjection() instanceof AFunction) {
			AFunction proj = (AFunction) r.getProjection();
			// Parse projection function
			projection = parseFunction(proj);
			// construct the domain of reduction
			_currentDomain = PolyhedralIRUtility.parseDomainFromString(_parameterDomain, proj.getIndexes().getIds(), new LinkedList<String>());
			
			//names are now in new scope
			_currentAShowIndices = proj.getIndexes().getIds();
			// In AShow syntax
		} else if (r.getProjection() instanceof AFunctionInArrayNotation) {
			if (_currentAShowIndices == null) {
				_currentAShowIndices = new ArrayList<String>();
			}
			
			// Dimension of surrounding domain
			AFunctionInArrayNotation proj = (AFunctionInArrayNotation) r.getProjection();
			// Get the new dimensions of reduction
			List<String> newIds = new LinkedList<String>();
			for (String id : proj.getNewIds().getExprs()) {
				newIds.add(id);
			}
			_currentAShowIndices.addAll(newIds);
			
			// infer lhs and rhs of the projection 
			StringBuffer rhs = new StringBuffer();
			for (Variable iv : _currentDomain.getIndices()) {
				if (rhs.length() > 0) {
					rhs.append(",");
				}
				rhs.append(iv.toString());
			}
			StringBuffer lhs = new StringBuffer(rhs);
			for (String id : newIds) {
				if (lhs.length() > 0) {
					lhs.append(",");
				}
				lhs.append(id);
			}
			
			// Construct the projection function
			String projStr = String.format("(%s->%s)", lhs, rhs);
			
			// Construct the reduction domain
			_currentDomain = PolyhedralIRUtility.parseDomainFromString(_parameterDomain, _currentAShowIndices, new LinkedList<String>());

			// Parse projection function
			projection = PolyhedralIRUtility.parseAffineFunction(_parameterDomain, projStr);
			
		} else {
			throw new RuntimeException("Unhandled projection : " + r.getProjection());
		}
		
		
		/*if (_isUseEquation) {
			// Rewriting rules to apply:
			// - Change the projection function into: (i_{ED}, i -> i_{ED}, projection(i) )
			
			// todo: Rewrite this part... ??? :P
			// First get a test case on this
			List<Variable> lindLProj = new BasicEList<Variable>();
			Domain dummyCurrentExtDom = _currentExtDom.copy();
			for (Variable indProj : projection.getIndices())
				dummyCurrentExtDom.addDimension(indProj.getName());
			lindLProj.addAll(dummyCurrentExtDom.getIndices());
			// Cf comment in "visitADependenceExpression"
			
			List<AffineExpression> lexprRProj = new BasicEList<AffineExpression>();
			for (Variable var : _currentExtDom.getIndices())
				lexprRProj.add(IntExpressionBuilder.affine(var));
			projection = _polyIRFact.createAffineFunction(projection.getParams(), lindLProj, lexprRProj);
			
		}*/
		
		
		r.getExpr().accept(this);
		Expression expr = _currentExpression;

		ReduceExpression re = _polyIRFact.createReduceExpression(_program.getBinaryOperator(r.getOp()), projection, expr);

		_currentDomain = orig;
		_currentAShowIndices = origAShowIndices;

		_currentExpression = re;
	}

	@Override
	public void visitARestrictExpression(ARestrictExpression r) {
		
		Domain restrictDomain = parseRestrictDomain(_currentDomain, r.getDomain());
		
		/*if (_isUseEquation) {
			// Rewriting rules to apply:
			// - Change the restriction domain into: (ED \times D)
			
			// For this: Extend ED with |D| indices, then replace the indices of D by those of the extended ED, then intersect both set
			Domain dummyED = _currentExtDom.copy();
			List<Variable> lindRestDom = restrictDomain.getIndices();
			for (Variable var : lindRestDom)
				dummyED.addDimension(var.getName());
			
			List<IntExpression> lnewindRestDom = new BasicEList<IntExpression>();
			int begInd = dummyED.getNIndices() - lindRestDom.size();
			for (int k=0; k<lindRestDom.size(); k++)
				lnewindRestDom.add((IntExpression) dummyED.getIndices().get(begInd + k));
			Domain extendedRestrDom = substituteDomain(restrictDomain, lindRestDom, lnewindRestDom, restrictDomain.getParams(), dummyED.getIndices());
			restrictDomain = dummyED.intersection(extendedRestrDom);
		}*/
		
		// set domain
		Domain tempDom = _currentDomain;
		_currentDomain = restrictDomain.copy();

		// parse its child
		r.getExpr().accept(this);

		// Create expression
		_currentExpression = _polyIRFact.createRestrictExpression(restrictDomain, _currentExpression);

		// reset domain
		_currentDomain = tempDom;
	}

	@Override
	public void visitAVariableExpression(AVariableExpression v) {
		VariableDeclaration varDecl = _currentSystem.getVariableDeclaration(v.getVar());
		
		if (varDecl == null) {
			parseResult._parseErrors.add("Variable " + v.getVar() + " is not declared in the equation of Variable \"" + _currentEquation.getVar() + "\".");
			return;
		}
		int outerDim = _currentDomain.getIndices().size();
		int varDim = varDecl.getDomain().getIndices().size();

		VariableExpression ve = _polyIRFact.createVariableExpression(varDecl);

		_currentExpression = ve;
		
		// Handling of scalar
		// When outerDim is greater than the variable, need dependence but legal iff varDim is null
		// This only happens in AShow syntax
		if (outerDim > varDim && varDim == 0) {
			_currentExpression = _polyIRFact.createDependenceExpression(
					PolyhedralIRUtility.parseAffineFunction(varDecl.getDomain().getParams(), _currentDomain.getIndices(), new LinkedList<String>()),
					_currentExpression);
		} else {
			// If access to the variable does not have any dependence, create identity dependence
			// This only happens in Show syntax
			if (!(v.eContainer() instanceof ADependenceExpression)) {
				_currentExpression = _polyIRFact.createDependenceExpression(PolyhedralIRUtility.createIdentityFunction(varDecl.getDomain()), _currentExpression);
			}
		}
		
		
		// Case of inputs inside a use equation
		/*if (_isUseEquation && !(v.eContainer() instanceof ADependenceExpression)) {
			// Rewriting rules to apply:
			// 1) If the container expression is a dependance, do nothing (just keep "Var") => Work already done
			// 2) Else, build the dependance node (i_{ED}, i -> i) @ Var
			// By the previous construction, we know that _currentExpression is a DependenceExpression
			// 		=> we have to replace its dependence by a correct one
			if (!(_currentExpression instanceof DependenceExpression))
				throw new RuntimeException("_currentExpression should be a DependenceExpression, but is not...");
			
			AffineFunction dep = ((DependenceExpression) _currentExpression).getDep();
			Expression expr = ((DependenceExpression) _currentExpression).getExpr();
			
			List<String> lindDep = new BasicEList<String>();
			lindDep.addAll(_currentExtDom.getIndexNames());
			lindDep.addAll(dep.getIndexNames());
			
			// Expressions might vary depending on the "Handling of scalar" part
			List<String> lexprDep = new BasicEList<String>();
			if (dep.getExpressions().size()!=0)
				lexprDep.addAll(varDecl.getDomain().getIndexNames());
			AffineFunction newdep = PolyhedralIRUtility.parseAffineFunction(_parameterDomain, lindDep, lexprDep);
			
			_currentExpression = _polyIRFact.createDependenceExpression(newdep, expr);
		}*/
		
	}

	@Override
	public void visitANotExpression(ANotExpression n) {

		n.getExpr().accept(this);
		UnaryExpression ue = _polyIRFact.createUnaryExpression(_program.getUnaryOperator(n.getOp()), _currentExpression);

		_currentExpression = ue;
	}

	@Override
	public void visitANegateExpression(ANegateExpression n) {

		n.getExpr().accept(this);
		UnaryExpression ue = _polyIRFact.createUnaryExpression(_program.getUnaryOperator(n.getOp()), _currentExpression);

		_currentExpression = ue;
	}

	@Override
	public void visitADependenceInArrayNotation(ADependenceInArrayNotation d) {
		if (_currentAShowIndices == null) {
			AShowErrorMessageDependence();
		}
		if (_currentSystem.getVariableDeclaration(d.getVar()) == null) {
			parseResult._parseErrors.add("Use of undeclared variable \"" + d.getVar() + "\": " + d.getVar()+d.getDep().getExprs());
			return;
		}
		if (_currentSystem.getVariableDeclaration(d.getVar()).getDomain().getNIndices() != d.getDep().getExprs().size()) {
			parseResult._parseErrors.add("Number of dimensions in the RHS of dependence \"" + d.getVar()+d.getDep().getExprs() + "\" does not match the variable declaration.");
			return;
		}
		
		AffineFunction dep = PolyhedralIRUtility.parseAffineFunction(_parameterDomain, _currentAShowIndices, d.getDep().getExprs());

		if (_currentSystem.getVariableDeclaration(d.getVar())==null) {
			parseResult._parseErrors.add("Variable unknown \"" + d.getVar() + "\" in the equation of Variable \"" + _currentEquation.getVar() + "\"");
			return;
		}
		
		VariableExpression ve = _polyIRFact.createVariableExpression(_currentSystem.getVariableDeclaration(d.getVar()));
		DependenceExpression de = _polyIRFact.createDependenceExpression(dep, ve);

		_currentExpression = de;
	}

	@Override
	public void visitAIntegerExpression(AIntegerExpression i) {
		
		// Expression of the dependence is integer value
		IntegerExpression ie = _polyIRFact.createIntegerExpression( (long) i.getValue());

		// In polyIR, there is a dependence to null dimension before constants
		// when its given in the file
		if (i.eContainer() instanceof ADependenceExpression && _currentDomain.getNIndices() == 0) {
			_currentExpression = ie;
			// else construct one
		} else {
			DependenceExpression de = _polyIRFact.createDependenceExpression(
			// The dependence function is -> null
					PolyhedralIRUtility.parseAffineFunction(_currentDomain.getParams(), _currentDomain.getIndices(), new LinkedList<String>()), ie);
			_currentExpression = de;
		}
	}

	@Override
	public void visitABooleanExpression(ABooleanExpression b) {
		// Expression of the dependence is boolean value
		BooleanExpression be = _polyIRFact.createBooleanExpression(b.getValue());
		// In polyIR, there is a dependence to null dimension before constants
		// when its given in the file
		if (b.eContainer() instanceof ADependenceExpression && _currentDomain.getNIndices() == 0) {
			_currentExpression = be;
			// else construct one
		} else {
			DependenceExpression de = _polyIRFact.createDependenceExpression(
			// The dependence function is -> null
					PolyhedralIRUtility.parseAffineFunction(_currentDomain.getParams(), _currentDomain.getIndices(), new LinkedList<String>()), be);
			_currentExpression = de;
		}
	}

	@Override
	public void visitARealExpression(ARealExpression r) {
		// Expression of the dependence is real value
		RealExpression re = _polyIRFact.createRealExpression(Double.parseDouble(r.getValue()));
		// In polyIR, there is a dependence to null dimension before constants
		// when its given in the file
		if (r.eContainer() instanceof ADependenceExpression && _currentDomain.getNIndices() == 0) {
			_currentExpression = re;
			// else construct one
		} else {
			DependenceExpression de = _polyIRFact.createDependenceExpression(
			// The dependence function is -> null
					PolyhedralIRUtility.parseAffineFunction(_currentDomain.getParams(), _currentDomain.getIndices(), new LinkedList<String>()), re);
			_currentExpression = de;
		}
	}

	@Override
	public void visitAMultiArgArithmeticExpression(AMultiArgArithmeticExpression m) {
		// Traverse all expressions
		List<Expression> exprs = new LinkedList<Expression>();
		for (AAlphabetsExpression e : m.getExprs()) {
			e.accept(this);
			exprs.add(_currentExpression);
		}
		_currentExpression = _polyIRFact.createMultiArgExpression(_program.getMultiArgOperator(m.getOp()), exprs);
	}

	@Override
	public void visitAMultiArgLogicalExpression(AMultiArgLogicalExpression m) {

		// Traverse all expressions
		List<Expression> exprs = new LinkedList<Expression>();
		for (AAlphabetsExpression e : m.getExprs()) {
			e.accept(this);
			exprs.add(_currentExpression);
		}

		_currentExpression = _polyIRFact.createMultiArgExpression(_program.getMultiArgOperator(m.getOp()), exprs);
	}

	@Override
	public void visitAExternalFunctionCall(AExternalFunctionCall e) {

		// Traverse all expressions
		List<Expression> exprs = new LinkedList<Expression>();
		for (AAlphabetsExpression ae : e.getExprs()) {
			ae.accept(this);
			exprs.add(_currentExpression);
		}
		_currentExpression = _polyIRFact.createExternalFunctionCall(_program, e.getFunc(), exprs);
	}

	/**
	 * Helper for all binary expression cases.
	 * 
	 * @param op
	 * @param left
	 * @param right
	 * @return
	 */
	private BinaryExpression BinaryExpressionVisited(String op, AAlphabetsExpression left, AAlphabetsExpression right) {

		left.accept(this);
		Expression lhs = _currentExpression;

		right.accept(this);
		Expression rhs = _currentExpression;
		BinaryExpression be = _polyIRFact.createBinaryExpression(_program.getBinaryOperator(op), lhs, rhs);

		return be;
	}

	@Override
	public void visitAAndExpression(AAndExpression a) {
		_currentExpression = BinaryExpressionVisited(a.getOperator(), a.getLeft(), a.getRight());
	}

	@Override
	public void visitARelationalExpression(ARelationalExpression r) {
		_currentExpression = BinaryExpressionVisited(r.getOperator(), r.getLeft(), r.getRight());
	}

	@Override
	public void visitAAdditiveExpression(AAdditiveExpression a) {
		_currentExpression = BinaryExpressionVisited(a.getOp(), a.getLeft(), a.getRight());
	}

	@Override
	public void visitAMultiplicativeExpression(AMultiplicativeExpression m) {
		_currentExpression = BinaryExpressionVisited(m.getOp(), m.getLeft(), m.getRight());
	}

	@Override
	public void visitAModuloExpression(AModuloExpression m) {
		_currentExpression = BinaryExpressionVisited(m.getOp(), m.getLeft(), m.getRight());
	}
	
	@Override
	public void visitAMinMaxExpression(AMinMaxExpression a) {
		_currentExpression = BinaryExpressionVisited(a.getOp(), a.getLeft(), a.getRight());
	}
	
	@Override
	public void visitAOrExpression(AOrExpression a) {
		_currentExpression = BinaryExpressionVisited(a.getOperator(), a.getLeft(), a.getRight());
	}
	
} // AlphabetsToPolyhedralIR
