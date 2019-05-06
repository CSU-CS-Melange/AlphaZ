package alphaz.mde;

/*PROTECTED REGION ID(Utility_imports) ENABLED START*/
//PROTECTED IMPORTS
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.Domain;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
/*PROTECTED REGION END*/
/**
Commands for mostly internal use by other commands, such as common method for writing string to a file.
**/
public class Utility {

	/**
	TODO : add description (to the model)
	**/
	public static AffineFunction readFunction(  ParameterDomain paramDomain , String function ) {
		/*PROTECTED REGION ID(alphaz.mde.utility.readFunction) ENABLED START*/
		return PolyhedralIRUtility.parseAffineFunction(paramDomain, function);
		/*PROTECTED REGION END*/
	}


	/**
	Returning true
	**/
	public static Boolean True( ) {
		/*PROTECTED REGION ID(alphaz.mde.utility.True) ENABLED START*/
		return true;
		/*PROTECTED REGION END*/
	}


	/**
	Returning false
	**/
	public static Boolean False( ) {
		/*PROTECTED REGION ID(alphaz.mde.utility.False) ENABLED START*/
		return false;
		/*PROTECTED REGION END*/
	}


	/**
	TODO : add description (to the model)
	**/
	public static Domain readDomain(  ParameterDomain paramDomain , String domain ) {
		/*PROTECTED REGION ID(alphaz.mde.utility.readDomain) ENABLED START*/
		return PolyhedralIRUtility.parseDomain(paramDomain, domain);
		/*PROTECTED REGION END*/
	}


	/**
	TODO : add description (to the model)
	**/
	public static void WriteToFile(  String filename , String content ) {
		/*PROTECTED REGION ID(alphaz.mde.utility.WriteToFile) ENABLED START*/
		String fname = filename;
		if (!filename.startsWith("/") && !filename.startsWith("./") && !filename.startsWith("../")) {
			fname = "./"+filename;
		}
		
		File file = new File(fname);
		if (!file.exists() && !(new File(file.getParent()).exists())) {
			new File(file.getParent()).mkdirs();
		}
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(content);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			throw new RuntimeException("Error while writing to " + fname);
		}
		/*PROTECTED REGION END*/
	}


	/**
	Print the given Affine Function, Boolean, Domain or String
	**/
	public static void print( ) {
		/*PROTECTED REGION ID(alphaz.mde.utility.print) ENABLED START*/
		//TODO
		throw new UnsupportedOperationException();
		/*PROTECTED REGION END*/
	}

	/**
	TODO : add description (to the model)
	**/
	public static void print( Domain domain) {
		/*PROTECTED REGION ID(alphaz.mde.utility.print_0) ENABLED START*/
		System.out.println(domain);
		/*PROTECTED REGION END*/
	}


	/**
	TODO : add description (to the model)
	**/
	public static void print( AffineFunction func) {
		/*PROTECTED REGION ID(alphaz.mde.utility.print_1) ENABLED START*/
		System.out.println(func);
		/*PROTECTED REGION END*/
	}


	/**
	TODO : add description (to the model)
	**/
	public static void print( String str) {
		/*PROTECTED REGION ID(alphaz.mde.utility.print_2) ENABLED START*/
		System.out.println(str);
		/*PROTECTED REGION END*/
	}


	/**
	TODO : add description (to the model)
	**/
	public static void print( Boolean boolValue) {
		/*PROTECTED REGION ID(alphaz.mde.utility.print_3) ENABLED START*/
		System.out.println(boolValue);
		/*PROTECTED REGION END*/
	}


	/**
	Converts input String of the form "a, b, c" to String[] {"a", "b", "c"}.
	**/
	public static String[] stringListToArray(  String list ) {
		/*PROTECTED REGION ID(alphaz.mde.utility.stringListToArray) ENABLED START*/
		if (list == null) {return new String[]{};}
		list = list.replaceAll("\\s+", "");
		list = list.replaceAll("^\\(", "");
		list = list.replaceAll("\\)$", "");
		return list.split(",");
		/*PROTECTED REGION END*/
	}


	/**
	Converts comma delimited list of integers in string to integer list.
	**/
	public static List<Integer> parseIntegerArray(  String list ) {
		/*PROTECTED REGION ID(alphaz.mde.utility.parseIntegerArray) ENABLED START*/
		if(list.contentEquals("")){
			List<Integer> intList = new ArrayList<Integer>();
			return intList;
		}else if (list.matches("\\s*((\\+|-)?\\d+)(\\s*,\\s*(\\+|-)?\\d+)*\\s*")) {
			String[] split = list.split("\\s*,\\s*");
			List<Integer> intList = new ArrayList<Integer>(split.length);
			
			for (String s : split) {
				intList.add(Integer.parseInt(s));
			}
			
			return intList;
			
		} else {
			throw new RuntimeException("Input is not a comma delimited list of integers: " + list);
		}
		/*PROTECTED REGION END*/
	}

}//end Utility
