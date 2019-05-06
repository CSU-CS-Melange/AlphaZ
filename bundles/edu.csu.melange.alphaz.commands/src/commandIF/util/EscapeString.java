package commandIF.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Defines a static method for escaping String for latex 
 * 
 * @author yuki
 *
 */
public class EscapeString {

	public static String latex(String str) {
		str = str.replaceAll("_", "\\\\_");
		
		StringBuffer res = new StringBuffer();
		
		String[] lines = str.split("(\r|\n)+");
		
 		Pattern pattern = Pattern.compile(".*\"(.+)\".*");
 		
 		for (String line : lines) {
			Matcher matcher = pattern.matcher(line);
			while (matcher.matches()) {
				line = line.replace("\""+matcher.group(1)+"\"", "``"+matcher.group(1)+"''");
				matcher = pattern.matcher(line);
			}
			
			if (res.length() > 0) res.append("\n");
			res.append(line);
 		}
		
		return res.toString();
	}
	
	public static String java(String str) {
		return str.replaceAll("\\\\url", "");
	}
	
	public static void main(String[] args) {
		String str = "When filename is not specified, \\url{saves} as \"original_.ab\".";
//		String out1 = latex(str);
		String out2 = java(str);
		System.err.println(out2);
	}
	
}
