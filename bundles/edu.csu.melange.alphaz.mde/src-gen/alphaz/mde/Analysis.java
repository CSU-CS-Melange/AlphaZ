package alphaz.mde;

/*PROTECTED REGION ID(Analysis_imports) ENABLED START*/
//PROTECTED IMPORTS
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polymodel.algebra.IntExpression;
import org.polymodel.algebra.affine.AffineExpression;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.PRDGBuilder;
import org.polymodel.polyhedralIR.analysis.UniquenessAndCompletenessCheck;
import org.polymodel.polyhedralIR.analysis.Verifier;
import org.polymodel.polyhedralIR.analysis.validator.ValidatorOutput;
import org.polymodel.polyhedralIR.analysis.verifier.IVerifierMessage.VERBOSITY;
import org.polymodel.polyhedralIR.analysis.verifier.VerifierOutput;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUserFactory;
import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.PRDGEdge;
import org.polymodel.prdg.PRDGNode;
import org.polymodel.prdg.PRDGSubSystemHyperEdge;
import org.polymodel.prdg.adapter.PRDGAdapterComponent;
import org.polymodel.prdg.factory.PRDGUserFactory;
import org.polymodel.prdg.scheduling.IPRDGScheduler;
import org.polymodel.prdg.scheduling.MonodimensionnalScheduler;
import org.polymodel.prdg.scheduling.ScheduledStatement;
import org.polymodel.prdg.scheduling.SchedulingException;
import org.polymodel.prdg.scheduling.SimpleSchedulePrototypeDomainBuilder;
import org.polymodel.prdg.scheduling.farkas.FarkasSchedulingDomainBuilder;
import org.polymodel.prdg.scheduling.feautrier.FeautrierISLScheduler;
import org.polymodel.prdg.scheduling.plutoisl.PlutoISLScheduler;
/*PROTECTED REGION END*/
/**
Analyses are commands that give information about the program, without modifying the program.
**/
public class Analysis {

	/**
	Constructs a PRDG for the specified AffineSystem. Input variables are excluded from the PRDG default. To override this option, set the optional argument noInput to 0.
	**/
	public static PRDG BuildPRDG(  Program program , String systemName , int noInputs ) {
		/*PROTECTED REGION ID(alphaz.mde.analysis.BuildPRDG) ENABLED START*/
		if (program.getSystem(systemName) == null) {
			throw new RuntimeException("System : " + systemName + " does not exist.");
		}
		return PRDGBuilder.build(program.getSystem(systemName), noInputs != 0);
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static PRDG BuildPRDG( Program program, String systemName) {
		return BuildPRDG( program, systemName, 1 );
	}
	


	/**
	Exports the given PRDG as a dot file.
	**/
	public static void ExportPRDG(  PRDG prdg , String filename ) {
		/*PROTECTED REGION ID(alphaz.mde.analysis.ExportPRDG) ENABLED START*/
		//make sure the file exists
		alphaz.mde.Utility.WriteToFile(filename, "");
		PRDGAdapterComponent.INSTANCE.getGraphExportService().export(filename, PRDGAdapterComponent.INSTANCE.build(prdg));
		/*PROTECTED REGION END*/
	}


	/**
	Performs uniqueness and completeness check of the program.
The program is a valid alphabets program, if it passes this check.
Details of the check can be found at {http://www.cs.colostate.edu/AlphaZ/wiki/doku.php?id=check_program}.
	**/
	public static void CheckProgram(  Program program ) {
		/*PROTECTED REGION ID(alphaz.mde.analysis.CheckProgram) ENABLED START*/
		ValidatorOutput output = UniquenessAndCompletenessCheck.validate(program);
		System.out.println(output.toString(org.polymodel.polyhedralIR.analysis.validator.IValidatorMessage.VERBOSITY.MAX));
		/*PROTECTED REGION END*/
	}


	/**
	Verifies the target mapping given to a system. The third input takes "NONE", "MIN", "MAX" to control the verbosity.
	**/
	public static void VerifyTargetMapping(  Program program , String system , String verbose ) {
		/*PROTECTED REGION ID(alphaz.mde.analysis.VerifyTargetMapping) ENABLED START*/

		if(verbose.compareToIgnoreCase("MAX") == 0) {
			VerifierOutput output = Verifier.verify(program.getSystem(system), VERBOSITY.MAX);
			System.out.println(output.toString(VERBOSITY.MAX));
		}else if(verbose.compareToIgnoreCase("MIN") == 0) {
			VerifierOutput output = Verifier.verify(program.getSystem(system), VERBOSITY.MIN);
			System.out.println(output.toString(VERBOSITY.MAX));
		}else if(verbose.compareToIgnoreCase("NONE") == 0) {
			VerifierOutput output = Verifier.verify(program.getSystem(system), VERBOSITY.NONE);
			System.out.println(output.toString(VERBOSITY.MAX));
		}
		
		/*PROTECTED REGION END*/
	}


	/**
	CheckSystem is CheckProgram applied to the specified system.
	**/
	public static void CheckSystem(  Program program , String system ) {
		/*PROTECTED REGION ID(alphaz.mde.analysis.CheckSystem) ENABLED START*/
		ValidatorOutput output = UniquenessAndCompletenessCheck.validate(program.getSystem(system));
		System.out.println(output.toString(org.polymodel.polyhedralIR.analysis.validator.IValidatorMessage.VERBOSITY.MAX));	
		/*PROTECTED REGION END*/
	}


	/**
	Farkas mono-dimensional scheduler.
	**/
	public static List<ScheduledStatement> Farkas1DScheduler(  PRDG prdg ) {
		/*PROTECTED REGION ID(alphaz.mde.analysis.Farkas1DScheduler) ENABLED START*/
		IPRDGScheduler scheduler = new MonodimensionnalScheduler(
				new FarkasSchedulingDomainBuilder(
						new SimpleSchedulePrototypeDomainBuilder()));
		try {
			EList<ScheduledStatement> stmts = scheduler.schedule(revertPRDGEdges(prdg));
			printScheduledStatements(stmts);
			return stmts;
		} catch (SchedulingException se) {
			System.err.println("SchedulingExecption: " + se.getMessage());
			return new ArrayList<ScheduledStatement>();
		}
		/*PROTECTED REGION END*/
	}


	/**
	Farkas multi-dimensional scheduler. Uses ISL implementation.
	**/
	public static List<ScheduledStatement> FarkasMDScheduler(  PRDG prdg ) {
		/*PROTECTED REGION ID(alphaz.mde.analysis.FarkasMDScheduler) ENABLED START*/
		IPRDGScheduler scheduler = new FeautrierISLScheduler();
		try {
			EList<ScheduledStatement> stmts = scheduler.schedule(revertPRDGEdges(prdg));
			printScheduledStatements(stmts);
			return stmts;
		} catch (SchedulingException se) {
			System.err.println("SchedulingExecption: " + se.getMessage());
			return new ArrayList<ScheduledStatement>();
		}
		/*PROTECTED REGION END*/
	}


	/**
	Pluto scheduler. Uses implementation in ISL.
	**/
	public static List<ScheduledStatement> PlutoScheduler(  PRDG prdg ) {
		/*PROTECTED REGION ID(alphaz.mde.analysis.PlutoScheduler) ENABLED START*/
		IPRDGScheduler scheduler = new PlutoISLScheduler();
		try {
			EList<ScheduledStatement> stmts = scheduler.schedule(prdg);
			ECollections.sort(stmts, new Comparator<ScheduledStatement>() {
				@Override
				public int compare(ScheduledStatement arg0, ScheduledStatement arg1) {
					return arg0.getStatement().getName().compareTo(arg1.getStatement().getName());
				}});
			printScheduledStatements(stmts);
			
			return stmts;
		} catch (SchedulingException se) {
			System.err.println("SchedulingExecption: " + se.getMessage());
			return new ArrayList<ScheduledStatement>();
		}
		/*PROTECTED REGION END*/
	}


	/**
	Reverts source and destination of PRDG edges to match the expected input of the scheduler.
Will be removed once PRDG is fixed.
	**/
	public static PRDG revertPRDGEdges(  PRDG prdg ) {
		/*PROTECTED REGION ID(alphaz.mde.analysis.revertPRDGEdges) ENABLED START*/
		PRDG reverted = PRDGUserFactory.createPRDG();
		for (PRDGNode node : prdg.getNodes()) {
			reverted.getNodes().add(PRDGUserFactory.createPRDGNode(node.getName(), EcoreUtil.copy(node.getDomain())));
		}
		for (PRDGEdge edge : prdg.getEdges()) {
			PRDGNode src = reverted.getNode(edge.getDestination().getName());
			PRDGNode dst = reverted.getNode(edge.getSource().getName());
			reverted.getEdges().add(PRDGUserFactory.createPRDGEdge(src, dst, EcoreUtil.copy(edge.getDomain()), EcoreUtil.copy(edge.getFunction())));
		}
		for (PRDGSubSystemHyperEdge hedge : prdg.getHedges()) {
			
			List<PRDGNode> lsrc = new BasicEList<PRDGNode>();
			for (PRDGNode origDest : hedge.getDestinations())
				lsrc.add(reverted.getNode(origDest.getName()));
			
			List<PRDGNode> ldests = new BasicEList<PRDGNode>();
			for (PRDGNode origSrc : hedge.getSources())
				ldests.add(reverted.getNode(origSrc.getName()));
			
			reverted.getHedges().add(PRDGUserFactory.createPRDGHEdge(lsrc, ldests, EcoreUtil.copy(hedge.getExtDom()), EcoreUtil.copy(hedge.getParams())));
		}
		
		return reverted;
		/*PROTECTED REGION END*/
	}


	/**
	Pretty prints scheduled statements returned by a scheduler.
	**/
	public static void printScheduledStatements(  List<ScheduledStatement> statements ) {
		/*PROTECTED REGION ID(alphaz.mde.analysis.printScheduledStatements) ENABLED START*/
		for (ScheduledStatement stmt : statements) {
			List<AffineExpression> affine = new ArrayList<AffineExpression>(stmt.getSchedule().size());
			for (IntExpression ie : stmt.getSchedule()) {
				affine.add(ie.toAffine());
			}
			
			AffineFunction f = PolyhedralIRUserFactory.eINSTANCE.createAffineFunction(stmt.getStatement().getDomain().getParams(),
					stmt.getStatement().getDomain().getIndices(),
					affine);
			System.out.println(stmt.getStatement().getName() + " " + f);
		}
		/*PROTECTED REGION END*/
	}

}//end Analysis
