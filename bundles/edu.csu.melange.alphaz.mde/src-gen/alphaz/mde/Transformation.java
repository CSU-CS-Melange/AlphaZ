package alphaz.mde;

/*PROTECTED REGION ID(Transformation_imports) ENABLED START*/
//PROTECTED IMPORTS
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Equation;
import org.polymodel.polyhedralIR.Expression;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.StandardEquation;
import org.polymodel.polyhedralIR.UseEquation;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.recurrence.ReductionDetection;
import org.polymodel.polyhedralIR.targetMapping.MemoryMap;
import org.polymodel.polyhedralIR.targetMapping.MemorySpace;
import org.polymodel.polyhedralIR.targetMapping.SpaceTimeLevel;
import org.polymodel.polyhedralIR.transformation.ChangeOfBasis;
import org.polymodel.polyhedralIR.transformation.Inline;
import org.polymodel.polyhedralIR.transformation.ReduceDimensionVariable;
import org.polymodel.polyhedralIR.transformation.Split;
import org.polymodel.polyhedralIR.transformation.SplitUnion;
import org.polymodel.polyhedralIR.util.ExpressionFinder;

import edu.csu.melange.alphaz.mde.core.AlphabetsToPolyhedralIR;
/*PROTECTED REGION END*/
/**
Transformations are commands that modify the program in some way.
**/
public class Transformation {

	/**
	Change of Basis transforms the domain of a variable to the image by the given function, while adding necessary dependence expressions to maintain the original semantics of the program. Details can be found at {http://www.cs.colostate.edu/AlphaZ/wiki/doku.php?id=change_of_basis}.
	**/
	public static void CoB(  Program program , String systemName , String varName , AffineFunction function ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.CoB) ENABLED START*/
		ChangeOfBasis.CoB(program.getSystem(systemName), varName, function);
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void CoB( Program program, String systemName, String varName,  String function) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.CoB_0) ENABLED START*/
		ChangeOfBasis.CoB(program.getSystem(systemName), varName, 
				PolyhedralIRUtility.parseAffineFunction(program.getSystem(systemName).getParameters(), function));
		/*PROTECTED REGION END*/
	}


	/**
	Force the change of basis even if the CoB is for input/output of a system.
	**/
	public static void ForceCoB(  Program program , String systemName , String targetName , AffineFunction function ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.ForceCoB) ENABLED START*/
		ChangeOfBasis.CoB(program.getSystem(systemName), targetName, function, true);
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void ForceCoB( Program program, String systemName, String targetName,  String function) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.ForceCoB_0) ENABLED START*/
		ChangeOfBasis.CoB(program.getSystem(systemName), targetName,
				PolyhedralIRUtility.parseAffineFunction(program.getSystem(systemName).getParameters(), function), true);
		/*PROTECTED REGION END*/
	}


	/**
	Splits a variable into two, where the domain of two variables are disjoint and union of them is equivalent to the original domain of the variable.
If newName is not given, it creates a variable with prefix "_split" appended to the original name.
	**/
	public static void Split(  Program program , String systemName , String varName , String newName , String sepDomain ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.Split) ENABLED START*/
		if (program.getSystem(systemName) == null) {
			throw new RuntimeException("System : " + systemName + " does not exist.");
		}
		AffineSystem system = program.getSystem(systemName);
		VariableDeclaration target = system.getVariableDeclaration(varName);
		Split.transform(system, target, Utility.readDomain(system.getParameters(), sepDomain), newName);
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void Split( Program program, String systemName, String varName, String sepDomain) {
		Split( program, systemName, varName, null , sepDomain);
	}
	


	/**
	Merge two variables (of name var1Name and var2Name) into a single one.
These variables must both be locals and must have disjoint domains. The name of the merge of these two variables is "newName".
	**/
	public static void Merge(  Program program , String systemName , String var1Name , String var2Name , String newName ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.Merge) ENABLED START*/
		AffineSystem syst = program.getSystem(systemName);
		VariableDeclaration var1 = syst.getVariableDeclaration(var1Name);
		VariableDeclaration var2 = syst.getVariableDeclaration(var2Name);
		org.polymodel.polyhedralIR.transformation.Merge.transform(syst, var1, var2, newName);
		/*PROTECTED REGION END*/
	}


	/**
	Inlines the nth(number) reference to inlineEq in the definition of targetEq once. If the number is not specified, all references to inlineEq are inlined.
	**/
	public static void Inline(  Program program , String systemName , String targetEq , String inlineEq , int number ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.Inline) ENABLED START*/
		if (program.getSystem(systemName) == null) {
			throw new RuntimeException("System : " + systemName + " does not exist.");
		}
		StandardEquation tEq = program.getSystem(systemName).getEquation(targetEq);
		StandardEquation sEq = program.getSystem(systemName).getEquation(inlineEq);
		if(number == -1){
			org.polymodel.polyhedralIR.transformation.Inline.transform(tEq, sEq, false);
		}else{
			org.polymodel.polyhedralIR.transformation.Inline.transform(tEq, sEq, number, false);
		}
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void Inline( Program program, String systemName, String targetEq, String inlineEq) {
		Inline( program, systemName, targetEq, inlineEq, 1 );
	}
	


	/**
	Simplifies the program in multiple ways. The domains are simplified by simplifyInContext (a.k.a. gist). When the domain of a reduction body is a single point, reduction is removed.
	**/
	public static void Simplify(  Program prog , String system ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.Simplify) ENABLED START*/
		if (system == null) {
			org.polymodel.polyhedralIR.transformation.Simplify.simplify(prog);
		} else {
			org.polymodel.polyhedralIR.transformation.Simplify.simplify(prog.getSystem(system));
		}
		
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void Simplify( Program prog) {
		Simplify( prog, null );
	}
	


	/**
	Takes an alphabetes program and converts it to a program that computes the fastest possible schedule (free shcedule).
This transformation DOES NOT preserve the original semantics, but instead creates a new Program object.

Implemented by Alex Klein as a class project in cs560@spring11
	**/
	public static Program createFreeScheduler(  Program program , String newProgPrefix ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.createFreeScheduler) ENABLED START*/
		//TODO
		throw new UnsupportedOperationException();
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static Program createFreeScheduler( Program program) {
		return createFreeScheduler( program, "" );
	}
	


	/**
	Replace an expression that has unions of polyhedra as its context domain with a case expression that splits the union into multiple disjiont polyhedra.
	**/
	public static void SplitUnion(  Program prog , String nodeID ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.SplitUnion) ENABLED START*/
		SplitUnion.split(ExpressionFinder.getExpression(prog, nodeID));
		/*PROTECTED REGION END*/
	}


	/**
	Applies sequence of CoBs using STMap given for each variable.
This is identical to the pre-processing step of ScheduledC code generator, where all variables are mapped to a common space so that ordering of iterations can be defined.
Assumes correct schedule [TODO:run verifier before applying the transformation once the verifier is fixed]
All STMaps and MemoryMaps given for the system will also be transformed appropriately.
	**/
	public static void ApplySTMap(  Program program , String systemName ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.ApplySTMap) ENABLED START*/
		AffineSystem system = program.getSystem(systemName);
		org.polymodel.polyhedralIR.targetMapping.TargetMapping tm = system.getTargetMapping();
		SpaceTimeLevel stlevel = tm.getSpaceTimeLevel(0);
		
		//basic checks
		int dimRHS = -1;
		for (VariableDeclaration var : system.getLocals()) {
			if (stlevel.getSpaceTimeMaps().get(var.getName()) == null) throw new RuntimeException("SpaceTimeMap must be specified for all local/output variables");
			if (dimRHS == -1) {
				dimRHS = stlevel.getSpaceTimeMaps().get(var.getName()).getMapping().getDimRHS();
			}
			if (stlevel.getSpaceTimeMaps().get(var.getName()).getMapping().getDimRHS() != dimRHS) {
				throw new RuntimeException("All SpaceTimeMaps at one level must have same number of dimensions in the RHS");
			}
		}
		for (VariableDeclaration var : system.getOutputs()) {
			if (stlevel.getSpaceTimeMaps().get(var.getName()) == null) throw new RuntimeException("SpaceTimeMap must be specified for all local/output variables");
			if (dimRHS == -1) {
				dimRHS = stlevel.getSpaceTimeMaps().get(var.getName()).getMapping().getDimRHS();
			}
			if (stlevel.getSpaceTimeMaps().get(var.getName()).getMapping().getDimRHS() != dimRHS) {
				throw new RuntimeException("All SpaceTimeMaps at one level must have same number of dimensions in the RHS");
			}
		}
		
		for(UseEquation use : system.getUseEquations()){
			if(stlevel.getSpaceTimeMaps().get(use.getLabel()) == null) throw new RuntimeException("SpaceTimeMap must be specified for all the subsystem call");
			if(dimRHS == -1){
				dimRHS = stlevel.getSpaceTimeMaps().get(use.getLabel()).getMapping().getDimRHS();
			}else if(stlevel.getSpaceTimeMaps().get(use.getLabel()).getMapping().getDimRHS() != dimRHS){
				throw new RuntimeException("All SpaceTimeMaps at one level must have the same number of dimensions in the RHS");
			}
		}
		//ApplyCoB to variables and memory maps
		for (VariableDeclaration var : system.getLocals()) {
			AffineFunction STmapInverse = stlevel.getSpaceTimeMaps().get(var.getName()).getMapping().inverseInContext(var.getDomain(), null);
			Transformation.CoB(program, systemName, var.getName(), stlevel.getSpaceTimeMaps().get(var.getName()).getMapping());
			MemoryMap mmap = tm.getMemoryMaps().get(var);
			mmap.setMapping(mmap.getMapping().compose(STmapInverse));
			stlevel.getSpaceTimeMaps().get(var.getName()).setMapping(PolyhedralIRUtility.createIdentityFunction(var.getDomain()));
		}
		for (VariableDeclaration var : system.getOutputs()) {
			AffineFunction STmapInverse = stlevel.getSpaceTimeMaps().get(var.getName()).getMapping().inverseInContext(var.getDomain(), null);
			Transformation.CoB(program, systemName, var.getName(), stlevel.getSpaceTimeMaps().get(var.getName()).getMapping());

			MemoryMap mmap = tm.getMemoryMaps().get(var);
			mmap.setMapping(mmap.getMapping().compose(STmapInverse));
			stlevel.getSpaceTimeMaps().get(var.getName()).setMapping(PolyhedralIRUtility.createIdentityFunction(var.getDomain()));
		}
		
		//TODO for use Equations
		for(UseEquation use : system.getUseEquations()){
		}
		
		
		/*PROTECTED REGION END*/
	}


	/**
	Attempts to uniformize all dependencies when possible.
	**/
	public static void UniformizeInContext(  Program prog , String system , int excludeInputs ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.UniformizeInContext) ENABLED START*/
		if (system == null) {
			org.polymodel.polyhedralIR.transformation.UniformizeInContext.apply(prog, excludeInputs != 0);
		} else {
			org.polymodel.polyhedralIR.transformation.UniformizeInContext.apply(prog.getSystem(system), excludeInputs != 0);
		}
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void UniformizeInContext( Program prog) {
		UniformizeInContext( prog, null , 1 );
	}
	


	/**
	TODO : add description (to the model)
	**/
	public static void UniformizeInContext( Program prog, String system) {
		UniformizeInContext( prog, system, 1 );
	}
	


	/**
	Force the inline action even if there is a self loop dependence
	**/
	public static void InlineForce(  Program program , String systemName , String targetEq , String inlineEq , int number ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.InlineForce) ENABLED START*/
		if(program.getSystem(systemName) == null){
			throw new RuntimeException("System : " + systemName + " does not exist.");
		}
		
		StandardEquation tEq = program.getSystem(systemName).getEquation(targetEq);
		StandardEquation sEq = program.getSystem(systemName).getEquation(inlineEq);
		if(number == -1){
			Inline.transform(tEq, sEq, true);
		}else{
			Inline.transform(tEq, sEq, number, true);
		}
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void InlineForce( Program program, String systemName, String targetEq, String inlineEq) {
		InlineForce( program, systemName, targetEq, inlineEq, 1 );
	}
	


	/**
	Inline all the possible equation in a system when there is no self loop dependence
	**/
	public static void InlineAll(  Program program , String systemName , String inlineEq ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.InlineAll) ENABLED START*/
		if(program.getSystem(systemName) == null){
			throw new RuntimeException("System : " + systemName + " does not exist.");
		}
		
		AffineSystem system = program.getSystem(systemName);
		StandardEquation sEq = system.getEquation(inlineEq);
		Inline.transformAll(system, sEq, false);
		/*PROTECTED REGION END*/
	}


	/**
	Inline all the possible equations in a system even with self loop dependence once
	**/
	public static void InlineAllForce(  Program program , String systemName , String inlineEq ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.InlineAllForce) ENABLED START*/
		if(program.getSystem(systemName) == null){
			throw new RuntimeException("System : " + systemName + " does not exist.");
		}
		
		AffineSystem system = program.getSystem(systemName);
		StandardEquation sEq = system.getEquation(inlineEq);
		Inline.transformAll(system, sEq, true);
		/*PROTECTED REGION END*/
	}


	/**
	Inline the subsystem used by the UseEquation specified by nodeID
	**/
	public static void InlineSubSystem(  Program program , String systemName , String label ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.InlineSubSystem) ENABLED START*/
		// Parsing of nodeID
//		nodeID = nodeID.trim();
//		nodeID = nodeID.replaceAll("^\\(|\\)$|\\t", "");
//		String[] ids = nodeID.split("\\s*,\\s*");
//		int[] target = new int[ids.length];
//		for (int i = 0; i < ids.length; i++) {
//			target[i] = Integer.parseInt(ids[i]);
//		}
//		if (target.length!=2)
//			throw new RuntimeException("nodeID must point to a UseEquation and must be of size 2");
//		
//		assert(target[0]>=0 && target[0]<program.getSystems().size());
//		AffineSystem syst = program.getSystems().get(target[0]);
//		assert(target[1]>=syst.getEquations().size() && target[1]<syst.getEquations().size()+syst.getUseEquations().size());
//		UseEquation ueq = syst.getUseEquations().get(target[1]-syst.getEquations().size());
		
		AffineSystem sys = program.getSystem(systemName);
		UseEquation ueq = sys.getUseEquation(label);
		if(ueq == null){
			throw new RuntimeException("UseEquation : " + label + " does not exist.");
		}else{
			org.polymodel.polyhedralIR.transformation.InlineSubSystem.inline(ueq);
		}
		/*PROTECTED REGION END*/
	}


	/**
	Outline a list of equations of a given system. These equation are defined through a list of variable ("listEquations") that corresponds to the variable of a StandardEquation or to the output of a UseEquation.
[V1] The created use equation will have no extension domain, and only variable expressions as inputs.
	**/
	public static void OutlineSubSystem(  Program program , String system , String listEquations ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.OutlineSubSystem) ENABLED START*/
		AffineSystem syst = program.getSystem(system);
		String[] lStreq = listEquations.split("\\s*,\\s*");
		
		List<Equation> leq = new BasicEList<Equation>();
		for (int k=0; k<lStreq.length; k++) {
			VariableDeclaration varDecl = syst.getVariableDeclaration(lStreq[k]);
			for (StandardEquation seq : syst.getEquations())
				if (seq.getVariable().equals(varDecl))
					leq.add(seq);
			for (UseEquation ueq : syst.getUseEquations())
				if (ueq.getOutputs().contains(varDecl) && !(leq.contains(ueq)))
					leq.add(ueq);
		}
		org.polymodel.polyhedralIR.transformation.OutlineSubSystem.outline(program, syst, leq);
		/*PROTECTED REGION END*/
	}


	/**
	Adds a local variable (of name specified by "nameLocal") for the expression "expr" and replace each occurrence of this expression in the considered system.
"expr" can be specified through a expression of the system (located in "nodeID"), or through an external expression "expr" whose list of indexes is "lInds".
	**/
	public static void AddLocal(  Program program , String system , String nameLocal , String nodeID ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.AddLocal) ENABLED START*/
		AffineSystem syst = program.getSystem(system);
		nodeID = nodeID.trim();
		nodeID = nodeID.replaceAll("^\\(|\\)$|\\t", "");
		String[] ids = nodeID.split("\\s*,\\s*");
		int[] target = new int[ids.length];
		for (int i = 0; i < ids.length; i++) {
			target[i] = Integer.parseInt(ids[i]);
		}
		org.polymodel.polyhedralIR.transformation.helper.AddLocal.addLocal(syst, target, nameLocal);
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void AddLocal( Program program, String system, String nameLocal,  String expr, String lInds) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.AddLocal_0) ENABLED START*/
		AffineSystem syst = program.getSystem(system);
		String[] freeIndsTab = lInds.split("\\s*,\\s*");
		List<String> freeInds = new BasicEList<String>();
		for (int k=0; k<freeIndsTab.length; k++)
			freeInds.add(freeIndsTab[k]);
		Expression exprRead = AlphabetsToPolyhedralIR.readExpression(expr, syst, freeInds);
		org.polymodel.polyhedralIR.transformation.helper.AddLocal.addLocal(syst, exprRead, nameLocal);
		/*PROTECTED REGION END*/
	}


	/**
	Replace only the expression (specified by the location "nodeID") by a new local variable (of name "nameLocal").
	**/
	public static void AddLocalUnique(  Program program , String system , String nameLocal , String nodeID ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.AddLocalUnique) ENABLED START*/
		AffineSystem syst = program.getSystem(system);
		nodeID = nodeID.trim();
		nodeID = nodeID.replaceAll("^\\(|\\)$|\\t", "");
		String[] ids = nodeID.split("\\s*,\\s*");
		int[] target = new int[ids.length];
		for (int i = 0; i < ids.length; i++) {
			target[i] = Integer.parseInt(ids[i]);
		}
		org.polymodel.polyhedralIR.transformation.helper.AddLocal.addLocalUnique(syst, target, nameLocal);
		/*PROTECTED REGION END*/
	}


	/**
	Detects simple reductions in the program and exposes as reduce expressions.
	**/
	public static void DetectReductions(  Program prog , String system ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.DetectReductions) ENABLED START*/
		AffineSystem affineSystem = prog.getSystem(system);
		ReductionDetection.detect(affineSystem);
		/*PROTECTED REGION END*/
	}


	/**
	Use the equalities of the domain of the specified variable in order to reduce its number of dimension.
Perform the corresponding change of basis and return the affine function used in this CoB.
	**/
	public static AffineFunction reduceDimVariable(  Program prog , String syst , String varName ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.reduceDimVariable) ENABLED START*/
		AffineSystem affSyst = prog.getSystem(syst);
		VariableDeclaration varDecl = affSyst.getVariableDeclaration(varName);
		return ReduceDimensionVariable.reduceDimVariable(affSyst, varDecl);
		/*PROTECTED REGION END*/
	}


	/**
	Align the bounding box of the domain of a variable with the point \vec{0}, by using a translation.
Note: might not work if the lower bound is not an affine function
Return the affine function used to perform the translation.
	**/
	public static AffineFunction alignDimVariable(  Program prog , String syst , String varName ) {
		/*PROTECTED REGION ID(alphaz.mde.transformation.alignDimVariable) ENABLED START*/
		AffineSystem affSyst = prog.getSystem(syst);
		VariableDeclaration varDecl = affSyst.getVariableDeclaration(varName);
		return ReduceDimensionVariable.alignDimVariable(affSyst, varDecl);
		/*PROTECTED REGION END*/
	}

}//end Transformation
