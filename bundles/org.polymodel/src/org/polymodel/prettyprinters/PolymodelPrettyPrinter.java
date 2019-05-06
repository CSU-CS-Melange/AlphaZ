package org.polymodel.prettyprinters;

import org.polymodel.PolymodelVisitable;
import org.polymodel.algebra.prettyprinter.algebra.IVariableResolver;
import org.polymodel.algebra.prettyprinter.algebra.OUTPUT_FORMAT;

public class PolymodelPrettyPrinter {
	
	public final static String print(final PolymodelVisitable object, final OUTPUT_FORMAT format) {
		AbstractPolymodelPrettyPrinter visitor;
		switch (format) {
		case ISL:
			visitor = new ISLPolymodelPrettyPrinter();
			break;
		case LATEX:
			visitor = new LatexPolymodelPrettyPrinter();
			break;
		case ALPHABETS:
			visitor = new AlphabetsPolymodelPrettyPrinter();
			break;
		case SMT2:
			visitor = new SMT2PolymodelPrettyPrinter();
			break;
		default:
			throw new UnsupportedOperationException(
					"Default output not yet implemented");
		}
		return visitor.print(object);
	}
	
	public final static String print(final PolymodelVisitable object, final OUTPUT_FORMAT format, IVariableResolver resolver) {

		AbstractPolymodelPrettyPrinter visitor;
		switch (format) {
		case ISL:
			visitor = new ISLPolymodelPrettyPrinter(resolver);
			break;
		case LATEX:
			visitor = new LatexPolymodelPrettyPrinter(resolver);
			break;
		case ALPHABETS:
			visitor = new AlphabetsPolymodelPrettyPrinter(resolver);
			break;
		default:
			throw new UnsupportedOperationException(
					"Default output not yet implemented");
		}
		return visitor.print(object);
	}
}
