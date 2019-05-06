package org.polymodel.algebra.prettyprinter.algebra;

import org.polymodel.algebra.AlgebraVisitable;

public class AlgebraPrettyPrinter {
	
	public final static String print(final AlgebraVisitable object, final OUTPUT_FORMAT format) {
		AbstractPrettyPrinter visitor;
		switch (format) {
		case C:
			visitor = new CPrettyPrinter();
			break;
		case ISL:
			visitor = new ISLPrettyPrinter();
			break;
		case ALPHABETS:
			visitor = new AlphabetsPrettyPrinter();
			break;
		case LATEX:
			visitor = new LatexPrettyPrinter();
			break;
		case SMT2:
			visitor = new SMT2PrettyPrinter();
			break;
		default:
			throw new UnsupportedOperationException(
					"Default output not yet implemented");
		}
		return visitor.print(object);
	}
	

	public final static String print(final AlgebraVisitable object, final OUTPUT_FORMAT format, IVariableResolver resolver) {
		AbstractPrettyPrinter visitor;
		switch (format) {
		case C:
			visitor = new CPrettyPrinter(resolver);
			break;
		case ISL:
			visitor = new ISLPrettyPrinter(resolver);
			break;
		case ALPHABETS:
			visitor = new AlphabetsPrettyPrinter(resolver);
			break;
		case LATEX:
			visitor = new LatexPrettyPrinter(resolver);
			break;
		case SMT2:
			visitor = new SMT2PrettyPrinter(resolver);
			break;
		default:
			throw new UnsupportedOperationException(
					"Default output not yet implemented");
		}
		return visitor.print(object);
	}

}
