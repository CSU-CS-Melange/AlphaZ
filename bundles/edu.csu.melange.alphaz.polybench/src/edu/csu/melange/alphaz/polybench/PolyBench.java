package edu.csu.melange.alphaz.polybench;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PolyBench {

	public static final String DATAMINING = "datamining";
	public static final String LA_KERNELS = "linear-algebra/kernels";
	public static final String LA_SOLVERS = "linear-algebra/solvers";
	public static final String MEDLEY = "medley";
	public static final String STENCILS = "stencils";
	
	@SuppressWarnings("serial")
	public static List<String> getCategories() {
		return new ArrayList<String>(){ { add(DATAMINING); add(LA_KERNELS); add(LA_SOLVERS); add(MEDLEY); add(STENCILS); } };
	}
 	
	public static List<POLYBENCH> getBench(String category) {
		List<POLYBENCH> benches = new LinkedList<POLYBENCH>();
		
		for (POLYBENCH bench : POLYBENCH.values()) {
			if (bench.category.matches(category)) {
				benches.add(bench);
			}
		}
		
		return benches;
	}
	
	public enum POLYBENCH {
		CORRELATION("correlation", DATAMINING),
		COVARIANCE("covariance", DATAMINING),
		TWOMM("2mm", LA_KERNELS),
		THREEMM("3mm", LA_KERNELS),
		ATAX("atax", LA_KERNELS),
		BICG("bicg", LA_KERNELS),
		CHOLESKY("cholesky", LA_KERNELS),
		DOITGEN("doitgen", LA_KERNELS),
		GEMM("gemm", LA_KERNELS),
		GEMVER("gemver", LA_KERNELS),
		GESUMMV("gesummv", LA_KERNELS),
		MVT("mvt", LA_KERNELS),
		SYMM("symm", LA_KERNELS),
		SYR2K("syr2k", LA_KERNELS),
		SYRK("syrk", LA_KERNELS),
		TRISOLV("trisolv", LA_KERNELS),
		TRMM("trmm", LA_KERNELS),
		
		DURBIN("durbin", LA_SOLVERS),
		DYNPROG("dynprog", LA_SOLVERS),
		GRAMSCHMIDT("gramschmidt", LA_SOLVERS),
		LU("lu", LA_SOLVERS),
		LUDCMP("ludcmp", LA_SOLVERS),
		
		FLOYD_WARSHALL("floyd-warshall", MEDLEY),
		REG_DETECT("reg_detect", MEDLEY),
		
		ADI("adi", STENCILS),
		FDTD_2D("fdtd-2d", STENCILS),
		FDTD_APML("fdtd-apml", STENCILS),
		JACOBI_1D_IMPER("jacobi-1d-imper", STENCILS),
		JACOBI_2D_IMPER("jacobi-2d-imper", STENCILS),
		SEIDEL_2D("seidel-2d", STENCILS);

		private final String name;
		private final String category;
		
		POLYBENCH(String name, String category) {
			this.name = name;
			this.category = category;
		}
		
		public String getName() {
			return name;
		}
		
		public String getCategory() {
			return category;
		}

		public String getFilePath(VARIATION var) {
			return var.path + "/" + getCategory() + "/" +getName() + "/" + getName() + ".ab";
		}

	}
	

	
	public static enum VARIATION {
		RAW("./alphabets/raw/"),
		RAW_NORMALIZED("./alphabets/raw-normalized/"),
		FIXED("./alphabets/fixed/"),
		FIXED_NORMALIZED("./alphabets/fixed-normalized/"),
		FIXED_INLINED("./alphabets/fixed-inlined/"),
		FIXED_ALIGNED("./alphabets/fixed-aligned/"),
		FIXED_HAND_ALIGNED("./alphabets/fixed-hand-aligned/"),
		FIXED_HAND_ALIGNED_PLUTO_SCHEDULED("./alphabets/fixed-hand-aligned-pluto-scheduled"),
		FIXED_UNIFORMIZED("./alphabets/fixed-uniformized"),

		MPIC_UNIFORMIZED("./alphabets/mpic-uniformized"),
		MPIC_SPLIT("./alphabets/mpic-split"),
		REF("./alphabets/ref/");
		
		public final String path;
		private VARIATION(String path) {
			this.path = path;
		}
	}
}
