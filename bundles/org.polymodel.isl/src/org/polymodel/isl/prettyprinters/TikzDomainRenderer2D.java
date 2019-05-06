package org.polymodel.isl.prettyprinters;

import static org.polymodel.algebra.factory.IntExpressionBuilder.affine;
import static org.polymodel.algebra.factory.IntExpressionBuilder.ge;
import static org.polymodel.algebra.factory.IntExpressionBuilder.le;
import static org.polymodel.algebra.factory.IntExpressionBuilder.term;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.polymodel.Domain;
import org.polymodel.algebra.Variable;
import org.polymodel.factory.PolymodelComponent;
import org.polymodel.isl.ISLPoint;
import org.polymodel.isl.ISLSet;
import org.polymodel.isl.factory.ISLNativeBinder;
import org.polymodel.isl.factory.ISLPolymodelModule;

import fr.irisa.cairn.jnimap.isl.jni.JNIISLBasicSet;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLSet;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLVertex;
import fr.irisa.cairn.jnimap.isl.jni.JNIISLVertices;

/**
 * Tikz renderer for a set of unparameterized polyhedral domains.
 * 
 * @author antoine
 * 
 */
public class TikzDomainRenderer2D {
	private TikzConfig configuration;

	protected StringBuffer sb;

	public static void output(String file, Domain... domains) {
		output(file, new TikzConfig(), domains);
	}

	public static void output(String file, TikzConfig config, Domain... domains) {
		PrintStream printStream;
		try {
			printStream = new PrintStream(file);
			printStream.append(render(domains));
			printStream.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		}

	}

	public static String render(Domain... domains) {
		TikzDomainRenderer2D r = new TikzDomainRenderer2D();
		return r.render(new TikzConfig(), domains);
	}

	public String render(TikzConfig config, Domain... domains) {
		sb = new StringBuffer();
		vertexID = 0;
		this.configuration = config;
		colors(domains.length);
		header();

		for (int i = 0; i < domains.length; i++) {
			ISLSet iset = PolymodelComponent.INSTANCE.getFactory(
					ISLPolymodelModule.INSTANCE).createDomain(domains[i]);
			Variable x = iset.getDimensions().getIndices().get(0);
			iset.addConstraint(ge(affine(term(x)), affine(term(0))));
			iset.addConstraint(le(affine(term(x)),
					affine(term(configuration.xmax))));

			Variable y = iset.getDimensions().getIndices().get(1);
			iset.addConstraint(ge(affine(term(y)), affine(term(0))));
			iset.addConstraint(le(affine(term(y)),
					affine(term(configuration.ymax))));

			shape(iset, "c" + (i + 1));
		}
		grid();
		for (int i = 0; i < domains.length; i++) {
			if (domains[i].getDimensions().getParameters().size() > 0)
				throw new IllegalArgumentException(
						"Parametrized domain not supported in tikz renderer");

			ISLSet iset = PolymodelComponent.INSTANCE.getFactory(
					ISLPolymodelModule.INSTANCE).createDomain(domains[i]);
			Variable x = iset.getDimensions().getIndices().get(0);
			iset.addConstraint(ge(affine(term(x)), affine(term(0))));
			iset.addConstraint(le(affine(term(x)),
					affine(term(configuration.xmax))));

			Variable y = iset.getDimensions().getIndices().get(1);
			iset.addConstraint(ge(affine(term(y)), affine(term(0))));
			iset.addConstraint(le(affine(term(y)),
					affine(term(configuration.ymax))));

			points(iset, "c" + (i + 1));
		}
		tail();
		return sb.toString();
	}

	private List<Point> buildPoints(ISLSet domain) {
		List<ISLPoint> points = domain.getPoints();
		List<Point> results = new ArrayList<TikzDomainRenderer2D.Point>();
		for (ISLPoint point : points) {
			results.add(new Point(point.getCoordinates().get(0), point
					.getCoordinates().get(1)));
		}
		return results;
	}

	private void colors(int n) {
		for (int i = 0; i < n; i++) {
			sb.append("\\definecolor{c" + (i + 1) + "}{RGB}{"
					+ configuration.color(i) + "}\n");
		}
		if (n > configuration.colors.length)
			sb.append("\\definecolor{c" + configuration.colors.length
					+ "}{RGB}{0,0,0}");
	}

	private static class Point {
		public final long x, y;

		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}

	}

	protected void header() {
		sb.append("\\begin{tikzpicture}\n");
	}

	private void tail() {
		sb.append("\\end{tikzpicture}\n");
	}

	private void grid() {
		sb.append("	%Axis \n \\draw [<->,thick] (0," + (configuration.ymax + 1)
				+ ") node (yaxis) [above] {$" + configuration.y + "$}	|- ("
				+ (configuration.xmax + 1) + ",0) node (xaxis) [right] {$"
				+ configuration.x + "$};");
		sb.append("	%Grid	\n \\draw[step=1cm,color=lightgray,dashed] (0,0) grid ("
				+ configuration.xmax + "," + configuration.ymax + ");");

		sb.append("%Tiks");

		sb.append("\n \\foreach \\x in {0,...,"
				+ configuration.xmax
				+ "} \n \\draw (\\x,1pt) -- (\\x,-3pt) \n node[anchor=north] {\\x};");
		sb.append("\n \\foreach \\y in {1,...,"
				+ configuration.ymax
				+ "} \n \\draw (1pt,\\y) -- (-3pt,\\y) \n node[anchor=east] {\\y};");

	}

	private void points(ISLSet domain, String color) {
		List<Point> points = buildPoints(domain);
		sb.append("\n");
		for (Point point : points) {
			sb.append("\\draw[fill=" + color + "] (" + point.x + "," + point.y
					+ ") circle (0.1);");
		}
		sb.append("\n\n");
	}

	private int vertexID;

	protected void shape(ISLSet domain, String color) {
		JNIISLSet jset = ISLNativeBinder.jniIslSet(domain);
		for (JNIISLBasicSet bset : jset.getBasicSets()) {
			JNIISLVertices vertices = bset.computeVertices();
			List<String> shape = new ArrayList<String>();
			for (int i = 0; i < vertices.getNbVertex(); i++) {
				JNIISLVertex vertexAt = vertices.getVertexAt(i);
				// XXX: find a better way of getting coordinates
				long x = -vertexAt.getExpr().getAff(1).getConstant();
				long y = -vertexAt.getExpr().getAff(0).getConstant();
				sb.append("\\coordinate (V").append(++vertexID)
						.append(") at (").append(x).append(",").append(y)
						.append(");\n");
				shape.add("V" + vertexID);
			}
			sb.append("\\draw[rounded corners=0.5em,line width=1.5em,cap=round,fill, "
					+ color + "!30]");
			for (int i = 0; i < shape.size() - 1; ++i) {
				sb.append("(").append(shape.get(i)).append(") --");
			}
			if (shape.size() > 0)
				sb.append("(").append(shape.get(shape.size() - 1))
						.append(") -- cycle");
			sb.append(";\n");
		}

	}

	public static class TikzConfig {
		public int xmax = 10;
		public int ymax = 10;
		public String colors[] = { "219,144,71", "100,212,78", "255,111,111",
				"111,139,255", };
		public String x = "x";
		public String y = "y";

		public TikzConfig(int xMAX, int yMAX) {
			xmax = xMAX;
			ymax = yMAX;
		}

		public TikzConfig(int xMAX, int yMAX, String[] colors) {
			xmax = xMAX;
			ymax = yMAX;
			this.colors = colors;
		}

		public TikzConfig() {

		}

		private String color(int i) {
			if (i < colors.length)
				return colors[i];
			else
				return "0,0,0";
		}
	}

}
