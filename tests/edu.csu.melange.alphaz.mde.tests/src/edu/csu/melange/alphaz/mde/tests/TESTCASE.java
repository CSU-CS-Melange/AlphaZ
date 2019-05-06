package edu.csu.melange.alphaz.mde.tests;

public enum TESTCASE {
	TWOMM("2mm"),
	CHOLESKY("cholesky"),
	CHOLESKY_WITH_REDUCE("cholesky_withReduce"),
	FIBONACCI("fibonacci"),
	JACOBI_1D("jacobi_1d"),
	JACOBI_1D_IMPER("jacobi_1d_imper"),
	JACOBI_2D("jacobi_2d"),
	JACOBI_2D_IMPER("jacobi_2d_imper"),
	LUD("lud"),
	MATRIX_PRODUCT("matrix_product"),
	MATRIX_PRODUCT_WITH_REDUCE("matrix_product_withReduce"),
	MSS("mss"),
	MSS_NO_TEMP("mssNoTemp"),
	SMITH_WATERMAN("smith_waterman");
	
	public final String systemName;
	
	private TESTCASE(String systemName) {
		this.systemName = systemName;
	}

	public static final String TESTCASE_DIR = "testcases";
	
	public String getFilePath() {
		return TESTCASE_DIR + "/" + systemName + "/" + systemName+".ab";
	}
}