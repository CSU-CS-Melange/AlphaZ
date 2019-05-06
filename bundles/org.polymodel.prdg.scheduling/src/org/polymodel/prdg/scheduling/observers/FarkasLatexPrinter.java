package org.polymodel.prdg.scheduling.observers;

import static org.polymodel.prdg.scheduling.util.LatexHelper.end;
import static org.polymodel.prdg.scheduling.util.LatexHelper.header;
import static org.polymodel.prdg.scheduling.util.LatexHelper.title;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.polymodel.Domain;
import org.polymodel.algebra.IntConstraint;
import org.polymodel.algebra.IntConstraintSystem;
import org.polymodel.algebra.Variable;
import org.polymodel.algebra.prettyprinter.algebra.AlgebraPrettyPrinter;
import org.polymodel.algebra.prettyprinter.algebra.LatexPrettyPrinter;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.isl.ISLSet;
import org.polymodel.matrix.Matrix;
import org.polymodel.prdg.scheduling.Dependency;
import org.polymodel.prdg.scheduling.farkas.FarkasBuilder;
import org.polymodel.prdg.scheduling.farkas.FarkasDependencyConstraints;
import org.polymodel.prdg.scheduling.impl.SchedulePrototypeImpl;
import org.polymodel.prdg.scheduling.internal.FastJNIIslSet;
import org.polymodel.prdg.scheduling.notifications.FarkasNotification;

import fr.irisa.cairn.graph.observer.INotification;
import fr.irisa.cairn.graph.observer.IObserver;
import fr.irisa.cairn.jnimap.isl.jni.ISL_FORMAT;

public class FarkasLatexPrinter implements IObserver {
	private List<FarkasDependencyConstraints> dependencies;
	private Map<String, String> variablesNamesMapping = new HashMap<String, String>();

	public FarkasLatexPrinter() {
		this.dependencies = new ArrayList<FarkasDependencyConstraints>();
	}

	public void addVariableRenaming(String old, String name) {
		this.variablesNamesMapping.put(old, name);
	}

	public Map<String, String> getVariablesNamesMapping() {
		return variablesNamesMapping;
	}

	public void setVariablesNamesMapping(
			Map<String, String> variablesNamesMapping) {
		this.variablesNamesMapping = variablesNamesMapping;
	}

	public void print(String file) {
		StringBuffer sb = new StringBuffer();
		sb.append(header());
		for (FarkasDependencyConstraints d : dependencies) {

			String depID = "D_{" + d.getDependency().getSource().getName()
					+ "->" + d.getDependency().getReference().getName() + "}";

			sb.append(title(1, " Dependency $" + depID + "$ ("
					+ d.getDependency().getClass().getSimpleName()+","+d.getDependency()+ ")"));
			sb.append(toLatex(d));

		}
		sb.append(end());

		try {
			PrintStream fileOutputStream = new PrintStream(new File(file));
			String content = sb.toString();
			for (Entry<String, String> e : variablesNamesMapping.entrySet()) {
				content = content.replace(e.getKey(), e.getValue());
			}
			fileOutputStream.append(content);
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected String toLatex(FarkasDependencyConstraints fd) {
		Dependency d = fd.getDependency();
		String depID = "D_{" + d.getSource().getName() + "->"
				+ d.getReference().getName() + "}";

		StringBuffer sb = new StringBuffer();

		// Print dependency domain
		sb.append("\n\n Domain of the dependency: \n");
		sb.append("\\begin{equation}\n");
		ISLSet domain = (ISLSet) d.getDependencyDomain();
		sb.append(depID).append(":");
		sb.append(domain.toString(ISL_FORMAT.LATEX));
		sb.append("\\end{equation}\n");

		// Print schedule prototypes
		sb.append("The schedule prototypes of the reference and the source are:  \n");
		sb.append("\\begin{equation}\n");
		sb.append(d.getSource().toLatex()).append("\\\\ \n");
		sb.append("\\end{equation}\n");
		sb.append("\\begin{equation}\n");
		sb.append(d.getReference().toLatex()).append("\\\\ \n");
		sb.append("\\end{equation}\n");

		// Print terms
		sb.append("The schedules must satisfy the constraint: \n");
		sb.append("\\begin{equation}\n");
		sb.append(SchedulePrototypeImpl.getLatexName(d.getReference()))
				.append("-")
				.append(SchedulePrototypeImpl.getLatexName(d.getSource()))
				.append("-1 \\ge 0 ");
		sb.append("\\end{equation}\n");
		if (fd.isRequireFarkasLemma()) {
			sb.append("\n\n Causality of the dependency can be written as a sum of schedule terms:  \n");
			sb.append("\\begin{equation}\n");
			sb.append(fd.getScheduleTerms().toLatex()).append("\\\\ \n");
			sb.append("\\end{equation}\n");

			sb.append("The dependency domain corresponds to the following matrix");
			printMatrix(fd, sb);

			sb.append("\n\n There exist some non negative Farkas multipliers terms such that:  \n");
			sb.append("\\begin{dmath}\n");
			sb.append(fd.getFarkasTerms().toLatex()).append("\\\\ \n");
			sb.append("\\end{dmath}\n");

			// Print equation system
			sb.append("\n\n Thus, schedule terms and Farkas terms are equivalent if and only if the following equations are satisfied: \n");
			sb.append("\\begin{equation}\n");
			sb.append(AlgebraPrettyPrinter.print(fd.getEquations(),
					OUTPUT_FORMAT.LATEX));
			sb.append("\\end{equation}\n");

			// Print applied constraints
			sb.append("\n\n Constraints after farkas multipliers elimination are:");
		} else {
			sb.append("\n\n The dependency is uniform, thus Farkas lemma isn't required and constraints for the dependency are: \n");
		}
		FastJNIIslSet applied = FastJNIIslSet.buildFrom(fd.getApplied());
		sb.append("\\begin{dmath}\n");
	
		String domainString = applied.getJNIset().toString(ISL_FORMAT.LATEX);
		domainString = LatexPrettyPrinter.formatLatexVariables(domainString, applied.getDimensions().getIndices());
		sb.append(domainString);
		sb.append("\n\\end{dmath}");
//		for (IntConstraintSystem s : applied.getPolyhedra()) {
//			sb.append("\\begin{equation}\n");
//			sb.append(AlgebraPrettyPrinter.print(s, OUTPUT_FORMAT.LATEX));
//			sb.append("\\end{equation}\n");
//			
//		}
		return sb.toString();
	}

	public static void printMatrix(FarkasDependencyConstraints fd,
			StringBuffer sb) {
		List<Variable> allVariables = new ArrayList<Variable>();
		Domain domain = fd.getDependency().getDependencyDomain();
		allVariables.addAll(domain.getDimensions().getIndices());
		allVariables.addAll(domain.getDimensions().getParameters());
		IntConstraintSystem polyhedron = domain.getPolyhedra().get(0);
		polyhedron = FarkasBuilder.transformToInequationsSystem(polyhedron);
		Matrix matrix = PolymodelComponent.INSTANCE.getFactory().createMatrix(
				polyhedron, allVariables);
		sb.append("\n\\begin{center}\n");
		sb.append("\n\n$\\bordermatrix{\n &e");
		for (Variable v : allVariables) {
			sb.append("&")
					.append(LatexPrettyPrinter.latexFormatVariableName(v.getName()));
		}
		sb.append("&1 \\cr \n");
		LatexPrettyPrinter algebraPrettyPrinter = new LatexPrettyPrinter(false);

		for (int i = 0; i < matrix.getNbRows(); ++i) {
			IntConstraint rowConstraint = polyhedron
					.getConstraints().get(i);
			String constraint = algebraPrettyPrinter.print(rowConstraint);
			algebraPrettyPrinter.clear();
			sb.append(constraint);
			sb.append("::\\lambda_{" + (i + 1) + "}");
			for (int c = 0; c < matrix.getNbCols(); ++c) {
				sb.append("&").append(matrix.get(i, c));
			}
			sb.append("\\cr\n");
		}
		sb.append("}$\n\n");
		sb.append("\\end{center}\n");
	}

	@Override
	public void notify(INotification notification) {
		if (notification instanceof FarkasNotification) {
			this.dependencies.add(((FarkasNotification) notification)
					.getFarkasDependencyConstraints());
		}

	}
}
