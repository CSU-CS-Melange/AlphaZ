package org.polymodel.polyhedralIR.analysis;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.factory.IntExpressionBuilder;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.PolyhedralIRVisitable;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.analysis.validator.ExpressionDomainEmptyWarning;
import org.polymodel.polyhedralIR.analysis.validator.ExpressionOverDefinedError;
import org.polymodel.polyhedralIR.analysis.validator.IValidatorMessage;
import org.polymodel.polyhedralIR.analysis.validator.IValidatorMessage.TYPE;
import org.polymodel.polyhedralIR.analysis.validator.SubSystemIncompatibleDefinitionDimensionError;
import org.polymodel.polyhedralIR.analysis.validator.SubSystemIncompatibleDefinitionDomainError;
import org.polymodel.polyhedralIR.analysis.validator.SubSystemIncompatibleParameterDomainError;
import org.polymodel.polyhedralIR.analysis.validator.ValidatorOutput;
import org.polymodel.polyhedralIR.analysis.validator.VariableMultipleDefinitionError;
import org.polymodel.polyhedralIR.analysis.validator.VariableNotDefinedAtAllError;
import org.polymodel.polyhedralIR.analysis.validator.VariableNotDefinedError;
import org.polymodel.polyhedralIR.analysis.validator.VariableNotDefinedForParamError;
import org.polymodel.polyhedralIR.analysis.validator.VariableNotDefinedWarning;
import org.polymodel.polyhedralIR.analysis.validator.VariableNotUsedWarning;
import org.polymodel.polyhedralIR.analysis.validator.VariableRepeatedlyDeclaredError;
import org.polymodel.polyhedralIR.analysis.validator.VariableShouldNotBeDefinedError;
import org.polymodel.polyhedralIR.expression.CaseExpression;
import org.polymodel.polyhedralIR.expression.ExternalFunctionCall;
import org.polymodel.polyhedralIR.expression.VariableExpression;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.impl.PolyhedralIRInheritedDepthFirstVisitorImpl;
import org.polymodel.polyhedralIR.transformation.helper.DomainOperations;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;

public class UniquenessAndCompletenessCheck extends PolyhedralIRInheritedDepthFirstVisitorImpl{
	protected PolyhedralIRUserFactory _polyIRFact;
	protected ParameterDomain _paramDomain;
	protected boolean _expDomainEmpty = false;
	
	protected ValidatorOutput _output = new ValidatorOutput();
	protected List<IValidatorMessage> _errors = null;
	protected List<VariableDeclaration> _inputs_locals = new LinkedList<VariableDeclaration>();
	// _inputs_locals: input and local variables that have not been used in other expressions, yet.
	
	protected UniquenessAndCompletenessCheck() {
		_polyIRFact = PolyhedralIRUserFactory.eINSTANCE;
	}
	
	public static ValidatorOutput validate(Program program) {
		UniquenessAndCompletenessCheck validator = new UniquenessAndCompletenessCheck();
		program.accept(validator);
		
		return validator._output;
	}
	
	public static ValidatorOutput validate(AffineSystem system) {
		UniquenessAndCompletenessCheck validator = new UniquenessAndCompletenessCheck();
		system.accept(validator);
		
		return validator._output;
	}
	
	public void visitAffineSystem(AffineSystem a) {
		inAffineSystem(a);
		
		_errors = new LinkedList<IValidatorMessage>();
		_paramDomain = a.getParameters();
		_inputs_locals.clear();
		_inputs_locals.addAll(a.getInputs());
		_inputs_locals.addAll(a.getLocals());
		
		
		//FIRST CHECK WEATHER THE VARIABLES IS REPEATEDLY DECLARED
		variableDeclarationCheck(a);
		// locals_outputs: Local and output variables whose standard equation has not been encountered, yet.
		List<VariableDeclaration> locals_outputs = new LinkedList<VariableDeclaration>(a.getLocals());
		locals_outputs.addAll(a.getOutputs());
		
		// If a variable is not defined for some points in the parameter domain
		for (VariableDeclaration var : locals_outputs) {
			Domain dom = var.getDomain().copy();
			AffineFunction function = PolyhedralIRUtility.parseAffineFunction(
					dom.getParams(), dom.getIndices(), new LinkedList<String>()); //projection function
			dom = dom.image(function);
			
			Domain d1 = _paramDomain.difference(dom);
			d1.simplify();
			if(!d1.isEmpty())
				_errors.add(new VariableNotDefinedWarning(TYPE.WARNING,EcoreUtil.copy(var), d1.copy()));
		}
		
		// Multiple definitions for a variable
		for (StandardEquation equation : a.getEquations()) {
			if (locals_outputs.contains(equation.getVariable())) {
				locals_outputs.remove(equation.getVariable());
				visitStandardEquation(equation);
			} else {
				if(!a.getLocals().contains(equation.getVariable()) && !a.getOutputs().contains(equation.getVariable())){
					if(a.getInputs().contains(equation.getVariable())) {
						_errors.add(new VariableShouldNotBeDefinedError(TYPE.ERROR, equation.getVariable()));
					} else {
						// Variable not declared at all: should already raise an error during the construction of the AST
						new RuntimeException("Error:: variable not declared but has an equation");
					}
				} else {
					// multiple equations for the same variable.
					_errors.add(new VariableMultipleDefinitionError(TYPE.ERROR, equation.getVariable()));
				}
			}
		}
		
		for (UseEquation equation : a.getUseEquations()) {
			boolean everythingIsAlright = true;
			
			// We have to check that all the outputs of the UseEquation have not been defined yet
			for (VariableDeclaration outSubSyst : equation.getOutputs()) {
				if (locals_outputs.contains(outSubSyst))
					locals_outputs.remove(outSubSyst);
				else {
					everythingIsAlright = false;	// Oh no! :(
					
					if(!a.getLocals().contains(outSubSyst) && !a.getOutputs().contains(outSubSyst)) {
						if (a.getInputs().contains(outSubSyst))
							_errors.add(new VariableShouldNotBeDefinedError(TYPE.ERROR, outSubSyst));
						else			// Cannot happen
							new RuntimeException("Error:: variable not declared but is an output of a subsystem");
					} else // multiple definitions, and the variable has been removed previously
						_errors.add(new VariableMultipleDefinitionError(TYPE.ERROR, outSubSyst));
				}
			}
			
			if (everythingIsAlright)
				visitUseEquation(equation);
		}
		
		
		// Check if variable is not used in any equation in the system
		if(!_inputs_locals.isEmpty()){
			for(VariableDeclaration var : _inputs_locals){
				_errors.add(new VariableNotUsedWarning(TYPE.WARNING, var));			
			}
		}
		
		// Check if there is variables that are never defined
		if (!locals_outputs.isEmpty()) {
			for (VariableDeclaration var: locals_outputs) {
				_errors.add(new VariableNotDefinedAtAllError(TYPE.ERROR, var));
			}
		}
		
		
		// Cycle detection inside the subsystem call: cf outProgram
		// => Not checked if we only check on a single affine system
		
		_output.addMessages(a, _errors);
		
		outAffineSystem(a);	
	}
	
	public void visitStandardEquation(StandardEquation s) {
		inStandardEquation(s);
		
		Domain domain = s.getVariable().getDomain().copy();
		if(domain.getNIndices() == 0){//scalar domain
			//construct a scalar domain with the system parameters
			domain = domain.intersection(s.getContainerSystem().getParameters());
		}
		Domain expr_domain = s.getExpression().getExpressionDomain().copy();
		
		//there are one special case for the external function call, get the context domain
		if(s.getExpression() instanceof ExternalFunctionCall){
			expr_domain = s.getExpression().getContextDomain().copy();
		}
		
		Domain diff = domain.difference(expr_domain);
		diff.simplify();
		
		if(!diff.isEmpty()) {
			// Note: In the case of "_paramDomain = null", this error is not redundant...
			_errors.add(new VariableNotDefinedError(TYPE.ERROR, EcoreUtil.copy(s.getVariable()), EcoreUtil.copy(diff)));
			
			AffineFunction projFunction = PolyhedralIRUtility.parseAffineFunction(diff.getParams(), diff.getIndices(), new LinkedList<String>());
			Domain temp_dom = diff.image(projFunction); //Projection of the (declared domain - expression domain) on the parameter space
			Domain param_diff = _paramDomain.intersection(temp_dom);
			param_diff.simplify();
			diff.simplifyInContext(s.getVariable().getDomain());
			
			if(!param_diff.isEmpty()) {
				_errors.add(new VariableNotDefinedForParamError(TYPE.ERROR, EcoreUtil.copy(param_diff), s.getVariable(), EcoreUtil.copy(diff)));
			}
		}
			
		for (EObject obj : s.eContents()) 
			if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		
		outStandardEquation(s);
	}
	
	/** Already checked during the construction of the AST:
	- Does the subsystem exists?
	- Right number of input? output? parameters?
	*/
	public void visitUseEquation(UseEquation u) {
		inUseEquation(u);
		
		// Visiting the input expressions
		AffineSystem subsyst = u.getSubSystem();
		for (Expression expInp : u.getInputs())
			expInp.accept(this);
		
		// Check: f(Dext) \subset P_sub ? <=> Is P_sub \ f(Dext) empty ?
		Domain Dext = u.getExtensionDomain();
		AffineFunction f = _polyIRFact.createAffineFunction(
				u.getContainerSystem().getParameters().getParams(), Dext.getIndices(), u.getParameters().getExpressions());
		Domain fDext = Dext.image(f);
		
		// Translation of the parameter domain P_sub with indexes (to be able to take the difference with f(Dext))
		List<IntExpression> indParam = new BasicEList<IntExpression>();
		Domain dummyDom = _polyIRFact.createDomain(new BasicEList<Variable>(), new BasicEList<Variable>(), new BasicEList<IntConstraintSystem>());
		for (int k =0; k<subsyst.getParameters().getNParams(); k++) {
			Variable var = subsyst.getParameters().getParams().get(k);
			dummyDom.addDimension(var.getName());
			indParam.add(IntExpressionBuilder.affine(dummyDom.getIndices().get(k)));
		}
		Domain diffInd = substituteDomain((Domain) subsyst.getParameters(), subsyst.getParameters().getParams(), indParam,
				_paramDomain.getParams(), dummyDom.getIndices());
		// TODO: simple way to remove this last "subsituteDomain" call ?
		
		
		Domain diff = fDext.difference(diffInd);
		ParameterDomain paramDom = u.getContainerSystem().getParameters();
		List<IntConstraintSystem> lSystParamDom = paramDom.getPMdomain().getPolyhedra();
		List<IntConstraintSystem> nlSystParamDom = new BasicEList<IntConstraintSystem>();
		for (IntConstraintSystem syst : lSystParamDom)
			nlSystParamDom.add(syst.copy());
		Domain domParamDom = _polyIRFact.createDomain(diff.getParams(), diff.getIndices(), nlSystParamDom);
		diff = diff.intersection(domParamDom);
		
		if (!diff.isEmpty())
			_errors.add(new SubSystemIncompatibleParameterDomainError(TYPE.WARNING, u, diff));
		
		
		
		// Compatibility check of the definition domains of the input/output variables of the subsystem (to be able to plug everything)
		// The conditions are $D^{(out)}_{(glob)} \subset (ED \times D^{(out)}_{(ss)})$
		//				  and (ED \times $D^{(in)}_{(ss)}) \subset D^{(in)}_{(glob)}$
		//			with ED the extension domain.
		List<VariableDeclaration> loutGlob = u.getOutputs();
		List<VariableDeclaration> loutSs = subsyst.getOutputs();
		for (int i=0; i<loutGlob.size(); i++) {
			Domain DoutGlob = loutGlob.get(i).getDomain();
			Domain DoutSs_untransl = loutSs.get(i).getDomain();
			
			// Case where the dimensions are incompatible
			if (DoutGlob.getNIndices() != DoutSs_untransl.getNIndices() + u.getExtensionDomain().getNIndices()) {
				_errors.add(new SubSystemIncompatibleDefinitionDimensionError(TYPE.ERROR, u, loutGlob.get(i).getName(),
						DoutGlob.getNIndices(),DoutSs_untransl.getNIndices() + u.getExtensionDomain().getNIndices()));
				break;
			}
			
			Domain DoutSs = DomainOperations.translateParams(DoutSs_untransl, u.getParameters(), u.getExtensionDomain());
			Domain Ddiff = DoutGlob.difference(DoutSs);
			
			/* DEBUG
			System.out.println("[CheckProg] DoutGlob = " + DoutGlob.toString());
			System.out.println("[CheckProg] DoutSs_untransl = " + DoutSs_untransl.toString());
			System.out.println("[CheckProg] DoutSs = " + DoutSs.toString());
			System.out.println("[CheckProg] Ddiff = " + Ddiff.toString());
			System.out.println();
			//*/
			
			if (!Ddiff.isEmpty())
				_errors.add(new SubSystemIncompatibleDefinitionDomainError(TYPE.ERROR, loutGlob.get(i).getName(), loutSs.get(i).getName(), u.getOutputs().get(0).getName(), Ddiff));
		}
		
		List<Expression> linGlob = u.getInputs();
		List<VariableDeclaration> linSs = subsyst.getInputs();
		for (int i=0; i<linGlob.size(); i++) {
			Domain DinGlob = linGlob.get(i).getContextDomain();
			Domain DinSs_untransl = linSs.get(i).getDomain();
			
			// Case where the dimensions are incompatible
			if (DinGlob.getNIndices() != DinSs_untransl.getNIndices() + u.getExtensionDomain().getNIndices()) {
				_errors.add(new SubSystemIncompatibleDefinitionDimensionError(TYPE.ERROR, u, "variable " + loutGlob.get(i).getName(),
						DinGlob.getNIndices(), DinSs_untransl.getNIndices() + u.getExtensionDomain().getNIndices()));
				break;
			}
			
			Domain DinSs = DomainOperations.translateParams(DinSs_untransl, u.getParameters(), u.getExtensionDomain());
			
			/* DEBUG
			System.out.println("DEBUG: DinSs_untransl = " + DinSs_untransl.toString());
			System.out.println("DEBUG: DinSs = " + DinSs.toString());
			System.out.println("DEBUG: DinGlob = " + DinGlob.toString());
			System.out.println();//*/
			
			
			Domain Ddiff = DinSs.difference(DinGlob);
			if (!Ddiff.isEmpty())
				_errors.add(new SubSystemIncompatibleDefinitionDomainError(TYPE.ERROR, "input number " + i, linSs.get(i).getName(), u.getOutputs().get(0).getName(), Ddiff));
		}
		
		outUseEquation(u);
	}
	
	@Override
	public void outProgram(Program p) {
		
		// -- Cycle detection of subsystem call (inside "Use equations")
		/*IGraphFactory fact_graph = IGraphFactory.instance;
		
		// We build the graph of affine system
		IGraph gr = fact_graph.createGraph(true);
		List<INode> lnode = new BasicEList<INode>();
		for (int i=0; i<p.getSystems().size(); i++) {
			INode nodeSys = fact_graph.createNode();
			lnode.add(nodeSys);
			gr.addNode(nodeSys);
		}
		
		for (int i=0; i<p.getSystems().size(); i++) {
			AffineSystem afi = p.getSystems().get(i);
			for (UseEquation ueq : afi.getUseEquations()) {
				AffineSystem afj = ueq.getSubSystem();
				int j = p.getSystems().indexOf(afj);
				if (j==-1)
					throw new RuntimeException("[Cycle detection] Subsystem do not appear in the program");
				IEdge eij = fact_graph.connect(lnode.get(i), lnode.get(j));
				gr.addEdge(eij);
			}
		}
		
		// Cycle detection
		Analysis<INode,IEdge> an = new Analysis<INode, IEdge>();
		Set<INode> cycle = an.findCycle(gr);
		if (cycle!=null) {			// Cycle detected in the calls to the subsystems
			INode[] tcycle = new INode[1];
			tcycle = cycle.toArray(tcycle);
			
			// We build the String that describe the cycle
			String strcycle = "[ ";
			for (int k=0; k<tcycle.length; k++) {
				int indSyst = lnode.indexOf(tcycle[k]);
				strcycle += p.getSystems().get(indSyst).getName() + " ";
			}
			strcycle += "]";
			
			List<IValidatorMessage> lmcycle = new BasicEList<IValidatorMessage>();
			lmcycle.add(new SubSystemCycleError(TYPE.ERROR, strcycle));
			
			_output.addMessages(p.getSystems().get(0), lmcycle);
		}*/
		
	}
	
	public void visitCaseExpression(CaseExpression c) {
		inCaseExpression(c);
		
		EList<Expression> list =  c.getExprs();
		for (int i = 0; i < list.size(); ++i) {
			Expression exp1 = list.get(i);
			Domain dom1 = exp1.getContextDomain().copy();
			
			if (i != list.size() - 1) {
				for (Expression exp2 : list.subList(i + 1, list.size())) {
					Domain dom2 = exp2.getContextDomain().copy();
					
					if (!dom1.intersection(dom2).isEmpty()) {
						if (c.eContainer() instanceof StandardEquation) {
							
							VariableDeclaration var = ((StandardEquation)c.eContainer()).getVariable();
							Domain temp_dom1 = dom1.copy();
							temp_dom1.simplifyInContext(var.getDomain());
							
							Domain temp_dom2 = dom2.copy();
							temp_dom2.simplifyInContext(var.getDomain());							
							
							// Since this is expression for standard equation, its simplified in the context of the domain of the equation.
							_errors.add(new ExpressionOverDefinedError(TYPE.ERROR, c, temp_dom1, temp_dom2));
						} else {
							_errors.add(new ExpressionOverDefinedError(TYPE.ERROR, c, dom1, dom2));
						}
					}
				}
			}
		}
		
		visitExpression(c);
		outCaseExpression(c);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void outExpression(Expression e) {
		if(e.getExpressionDomain().isEmpty()) {
			if(!_expDomainEmpty)
				_errors.add(new ExpressionDomainEmptyWarning(TYPE.WARNING,  PolyhedralIRToAlphabets.toSimplifiedString(e)));
			_expDomainEmpty = true;
		} else
			_expDomainEmpty = false;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visitVariableExpression(VariableExpression v) {
		inVariableExpression(v);
		
		// --- A VariableExpression do not contains anything: the following part is useless
		//for (EObject obj : v.eContents()) 
		//	if (obj instanceof PolyhedralIRVisitable) ((PolyhedralIRVisitable)obj).accept(this);
		
		if(_inputs_locals.contains(v.getVarDecl()))
			_inputs_locals.remove(v.getVarDecl());
		
		outVariableExpression(v);
	}
	
	
	private void variableDeclarationCheck(AffineSystem system){
		List<VariableDeclaration> vars = new LinkedList<VariableDeclaration>();
		vars.addAll(system.getInputs());
		vars.addAll(system.getLocals());
		vars.addAll(system.getOutputs());
	
		//get the list of vars for check
		List<VariableDeclaration> checkVars = new LinkedList<VariableDeclaration>();
		checkVars.addAll(vars);
		for(VariableDeclaration var: checkVars){
			//check the occurrence of the variable name
			List<VariableDeclaration> repeatedVars = new LinkedList<VariableDeclaration>();
			for(VariableDeclaration temp_var: vars){
				if(temp_var.getName().contentEquals(var.getName())){
					repeatedVars.add(temp_var);
				}
			}
			if(repeatedVars.size() > 1){//if the variable name is repeatedly used in multiple palce
				_errors.add(new VariableRepeatedlyDeclaredError(TYPE.ERROR, EcoreUtil.copy(var)));
				//remove the repeatedly declaration
				for(int i = 1; i < repeatedVars.size(); i++){
					vars.remove(repeatedVars.get(i));
				}
			}
		}
	}
	/**
	 * Private method to be able to substitute a serie of variable with a serie of expression in the constraints of the domain dom
	 * 		lreplaced.get(i) is replaced by lreplacing.get(i)
	 * 
	 * WARNING: A wrong specification do not garanty coherence of the result !
	 * 
	 * Use of this method should be replaced by the application of an image everytime needed.
	 * 
	 * @param lreplaced
	 * @param lreplacing
	 * @param lFinalParam: parameter list of the returned domain
	 * @param lFinalInd: indice list of the returned domain
	 * @return
	 */
	private Domain substituteDomain(Domain dom, List<Variable> lreplaced, List<IntExpression> lreplacing, List<Variable> lFinalParam, List<Variable> lFinalInd) {
		if (lreplaced.size() != lreplacing.size())
			throw new RuntimeException("substituteDomain: lreplaced.size() = " + lreplaced.size() + " != " + lreplacing.size() + " = lreplacing.size()");
		
		// Substitution 1: To avoid already-translated expressions being retransformed, we go a first shifting of the variable,
		// such that the dimensions of the new variables won't correspond to any translated variable:
		//		lreplaced => lreplacedBis (then: => lreplacing)
		Domain dummyDom = dom.copy();
		for (int k=dummyDom.getNIndices(); k<lFinalInd.size(); k++)
			dummyDom.addDimension("dummy" + k);
		for (int k=0; k<lreplaced.size(); k++) {
			dummyDom.addDimension(lreplaced.get(k).getName());
		}
		
		List<Variable> lreplacedBis = new BasicEList<Variable>();
		List<Variable> lindDummyDom = dummyDom.getIndices();
		for (int k=0; k<lreplaced.size(); k++) {
			lreplacedBis.add(lindDummyDom.get(k+lFinalInd.size()));
		}
		
		List<IntConstraintSystem> lpoly = dom.getPMdomain().getPolyhedra();
		List<IntConstraintSystem> nlpolyTemp = new BasicEList<IntConstraintSystem>();
		for (IntConstraintSystem poly : lpoly) {
			IntConstraintSystem npoly = poly.copy();
			for (int i=0; i<lreplaced.size(); i++) {
				npoly = npoly.substitute(lreplaced.get(i), lreplacedBis.get(i));
			}
			nlpolyTemp.add(npoly);
		}
		
		// Substitution 2
		List<IntConstraintSystem> nlpoly = new BasicEList<IntConstraintSystem>();
		for (IntConstraintSystem poly : nlpolyTemp) {
			IntConstraintSystem npoly = poly.copy();
			for (int i=0; i<lreplaced.size(); i++) {
				npoly = npoly.substitute(lreplacedBis.get(i), lreplacing.get(i));
			}
			nlpoly.add(npoly);
		}
		
		// We rebuild the domain
		return PolyhedralIRUserFactory.eINSTANCE.createDomain(lFinalParam, lFinalInd, nlpoly);
	}
	
} // UniquenessAndCompletenessCheck
