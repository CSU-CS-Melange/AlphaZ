package alphaz.mde;

/*PROTECTED REGION ID(Basic_imports) ENABLED START*/
//PROTECTED IMPORTS
import java.io.IOException;

import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.transformation.Normalize;
import org.polymodel.polyhedralIR.transformation.NormalizeVisitor;
import org.polymodel.polyhedralIR.util.AShow;
import org.polymodel.polyhedralIR.util.PolyhedralIRToAlphabets;
import org.polymodel.polyhedralIR.util.PrintAST;

import edu.csu.melange.alphabets.xtext.AlphabetsModelReader;
import edu.csu.melange.alphaz.mde.core.AlphabetsParseResult;
import edu.csu.melange.alphaz.mde.core.AlphabetsToPolyhedralIR;
/*PROTECTED REGION END*/
/**
Commands for basic operations such as reading alphabets files and printing out different views of the program.
**/
public class Basic {

	/**
	Outputs the program to the specified file with array syntax.
When filename is not specified, saves as "original_filename-ASave.ab".
	**/
	public static void ASave(  Program program , String filename ) {
		/*PROTECTED REGION ID(alphaz.mde.basic.ASave) ENABLED START*/
		alphaz.mde.Utility.WriteToFile(filename, AShow.toSimplifiedString(program));
		try {
			AlphabetsModelReader.formatFile(filename);
		} catch (Exception e) {
			
		}
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void ASave( Program program) {
		ASave( program, program.getFilename()+"-ASave.ab" );
	}
	


	/**
	Outputs the result of AShow to the specified file.
When filename is not specified, saves as "original_filename-ASave.ab".
	**/
	public static void ASaveSystem(  Program program , String system , String filename ) {
		/*PROTECTED REGION ID(alphaz.mde.basic.ASaveSystem) ENABLED START*/
		alphaz.mde.Utility.WriteToFile(filename, AShow(program, system));
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void ASaveSystem( Program program, String system) {
		ASaveSystem( program, system, program.getFilename()+"-ASave.ab" );
	}
	


	/**
	Prints out the program using array notation.
Prints out the entire program when target system is unspecified.

	**/
	public static String AShow(  Program program , String system ) {
		/*PROTECTED REGION ID(alphaz.mde.basic.AShow) ENABLED START*/
		String output;
		if (system == null) {
			output = AShow.toSimplifiedString(program);
		} else {
			if (program.getSystem(system) == null) {
				throw new RuntimeException("System : " + system + " does not exist.");
			}
			output = AShow.toSimplifiedString(program.getSystem(system));
		}
		System.out.println(output);
		return output;
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static String AShow( Program program) {
		return AShow( program, null );
	}
	


	/**
	Saves the output of show to the specified file.
When output filename is unspecified, saves to "original_filename-Show.ab".
	**/
	public static void Save(  Program program , String filename ) {
		/*PROTECTED REGION ID(alphaz.mde.basic.Save) ENABLED START*/
		alphaz.mde.Utility.WriteToFile(filename, PolyhedralIRToAlphabets.toString(program));
		try {
			AlphabetsModelReader.formatFile(filename);
		} catch (Exception e) {
			
		}
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void Save( Program program) {
		Save( program, program.getFilename()+"-Save.ab" );
	}
	


	/**
	Saves the output of show to the specified file.
When output filename is unspecified, saves to "original_filename-Show.ab".
	**/
	public static void SaveSystem(  Program program , String system , String filename ) {
		/*PROTECTED REGION ID(alphaz.mde.basic.SaveSystem) ENABLED START*/
		alphaz.mde.Utility.WriteToFile(filename, PolyhedralIRToAlphabets.toString(program.getSystem(system)));
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void SaveSystem( Program program, String system) {
		SaveSystem( program, system, program.getFilename()+"-Save.ab" );
	}
	


	/**
	Pretty prints the program using alpha-purist syntax.
Prints out the entire program when target system is unspecified.
	**/
	public static String Show(  Program program , String system ) {
		/*PROTECTED REGION ID(alphaz.mde.basic.Show) ENABLED START*/
		String output;
		if (system == null) {
			output = PolyhedralIRToAlphabets.toSimplifiedString(program);
		} else {
			if (program.getSystem(system) == null) {
				throw new RuntimeException("System : " + system + " does not exist.");
			}
			output = PolyhedralIRToAlphabets.toSimplifiedString(program.getSystem(system));
		}
		System.out.println(output);
		return output;
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static String Show( Program program) {
		return Show( program, null );
	}
	


	/**
	Normalizes the program. Normalization rules are described in more detail at: {http://www.cs.colostate.edu/AlphaZ/wiki/doku.php?id=normalize}.
	**/
	public static void Normalize(  Program program ) {
		/*PROTECTED REGION ID(alphaz.mde.basic.Normalize) ENABLED START*/
		//Normalize.normalize(program);		// Old version of normalize
		NormalizeVisitor.normalize(program);
		//EfficientNormalize.normalize(program);
		/*PROTECTED REGION END*/
	}


	/**
	Prints out the AST of the program.
Prints out the entire program when target system is unspecified.
	**/
	public static String PrintAST(  Program program , String system ) {
		/*PROTECTED REGION ID(alphaz.mde.basic.PrintAST) ENABLED START*/
		String output;
		if (system == null) {
			output = PrintAST.print(program);
		} else {
			if (program.getSystem(system) == null) {
				throw new RuntimeException("System : " + system + " does not exist.");
			}
			output = PrintAST.print(program.getSystem(system));
		}
		System.out.println(output);
		return output;
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static String PrintAST( Program program) {
		return PrintAST( program, null );
	}
	


	/**
	Parses the given alphabets program and returns a Program object.
	**/
	public static Program ReadAlphabets(  String file ) {
		/*PROTECTED REGION ID(alphaz.mde.basic.ReadAlphabets) ENABLED START*/
		try {
			AlphabetsParseResult result = AlphabetsToPolyhedralIR.readAlphabets(file);
			if (result.isParsed()) {
				return result.getProgram();
			} else {
				System.err.println(result.printParseErrors());
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("IOException : " + e.getMessage());
		}
		/*PROTECTED REGION END*/
	}


	/**
	Renames an AffineSystem.
	**/
	public static void RenameSystem(  Program program , String system , String newSystemName ) {
		/*PROTECTED REGION ID(alphaz.mde.basic.RenameSystem) ENABLED START*/
		program.getSystem(system).setName(newSystemName);
		/*PROTECTED REGION END*/
	}


	/**
	Renames a variable.
	**/
	public static void RenameVariable(  Program program , String system , String varName , String newVarName ) {
		/*PROTECTED REGION ID(alphaz.mde.basic.RenameVariable) ENABLED START*/
		program.getSystem(system).getVariableDeclaration(varName).getVarID().setName(newVarName);
		/*PROTECTED REGION END*/
	}


	/**
	Removes unused variables and equations. Unused variables are variables that is not used by the definition of output.
	**/
	public static void RemoveUnusedVariables(  Program program , String system ) {
		/*PROTECTED REGION ID(alphaz.mde.basic.RemoveUnusedVariables) ENABLED START*/
		if (system == null) {
			org.polymodel.polyhedralIR.transformation.RemoveUnusedVariables.apply(program);
		} else {
			org.polymodel.polyhedralIR.transformation.RemoveUnusedVariables.apply(program.getSystem(system));
		}
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void RemoveUnusedVariables( Program program) {
		RemoveUnusedVariables( program, null );
	}
	

}//end Basic
