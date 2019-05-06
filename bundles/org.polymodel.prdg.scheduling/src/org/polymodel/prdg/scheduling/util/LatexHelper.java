package org.polymodel.prdg.scheduling.util;

public class LatexHelper {

	public static String header() {
		StringBuffer sb = new StringBuffer();
		sb.append("\\documentclass[a4paper,11pt]{article} "
				+ "\n"
				+ "\\usepackage[a4paper]{geometry} "
				+ "\n"
				+ "\\geometry{verbose,tmargin=4cm,bmargin=4cm,lmargin=2cm,rmargin=2cm} "
				+ "\n" + "\\usepackage{pst-node} " + "\n"
				+ "\\usepackage[utf8]{inputenc} " + "\n"
				+ "\\usepackage[T1] {fontenc} " + "\n"
				+ "\\usepackage{amsmath} " + "\n" + "\\usepackage{amsfonts} "
				+ "\n" + "\\usepackage{amssymb} " + "\n"
				+ "\\usepackage{listings} " + "\n" + "\\usepackage{blkarray} "
				+ "\n" + "\\usepackage{pstricks} " + "\n"
				+ "\n" + "\\usepackage{breqn} " + "\n"
				+ "\\begin{document} " + "\n");
		return sb.toString();
	}

	public static String equation(String content) {
		StringBuffer sb = new StringBuffer();
		sb.append("\\begin{equation}\n");
		sb.append(content);
		sb.append("\\end{equation}\n");
		return sb.toString();
	}

	/**
	 * Latex title in function of its level. First level is 1 and corresponds to
	 * a section.
	 * 
	 * @param level
	 * @param title
	 * @return
	 */
	public static String title(int level, String title) {
		StringBuffer sb = new StringBuffer();
		switch (level) {
		case 1:
			sb.append("\\section");
			break;
		case 2:
			sb.append("\\subsection");
			break;
		case 3:
			sb.append("\\subsubsection");
			break;
		case 4:
			sb.append("\\paragraph");
			break;
		default:
			throw new IllegalArgumentException("Non valid section level: "
					+ level);
		}
		sb.append("{").append(title).append("}\n");
		return sb.toString();
	}


	
	public static String end() {
		StringBuffer sb = new StringBuffer();
		sb.append("\\end{document} " + "\n");
		return sb.toString();
	}

}
