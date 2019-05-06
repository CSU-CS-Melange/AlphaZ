package edu.csu.melange.alphaz.mde.core;

import java.util.Set;
import java.util.TreeSet;

import org.polymodel.polyhedralIR.Program;

public class AlphabetsParseResult {

	protected final Program program;
	protected Set<String> _parseErrors;
	
	protected AlphabetsParseResult(Program program) {
		this.program = program;
		_parseErrors = new TreeSet<>();
	}
	
	public Program getProgram() {
		return program;
	}
	
	public boolean isParsed() {
		return _parseErrors.isEmpty();
	}
	
	public String printParseErrors() {
		return _parseErrors.toString();
	}
}
