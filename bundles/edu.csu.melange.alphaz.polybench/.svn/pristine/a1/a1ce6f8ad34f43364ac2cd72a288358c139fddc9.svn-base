package edu.csu.melange.alphaz.polybench;
import java.util.Map;
import java.util.TreeMap;

import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.UniquenessAndCompletenessCheck;
import org.polymodel.polyhedralIR.analysis.validator.IValidatorMessage.VERBOSITY;
import org.polymodel.polyhedralIR.analysis.validator.ValidatorOutput;

import edu.csu.melange.alphaz.polybench.PolyBench.POLYBENCH;
import edu.csu.melange.alphaz.polybench.PolyBench.VARIATION;


public class ISLPlutoScheduleSCCCombinedHandAligned {
	public static Program scheduleCorrelation() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S10 (i0,i1,i2->i0,i1,i2+n,1)
		//S13 (j1,j2,i->j2,j1,i+n,2)
		//S14 (i0,i1,i2->i0+i1,i1,3i2,8)
		//S2 (i0,i1,i2->i0,i1,i2-n,6)
		//S3 (i0,i1,i2->i0,i1,i2-n,7)
		//S5 (i0,i1,i2->i0,i1,i2,3)
		//S6 (i0,i1,i2->i0,i1,i2,4)
		//S8 (i0,i1,i2->i0,i1,i2+n,0)
		//S9 (i0,i1,i2->i0,i1,i2,5)
		//prefix[]; tilable[true,true,true,false] (3)

		schedules.put("S10", "(i0,i1,i2->i0,i1,i2+n)");
		schedules.put("S13", "(j1,j2,i->j2,j1,i+n)");
		schedules.put("S14", "(i0,i1,i2->i0+i1,i1,3i2)");
		schedules.put("S2", "(i0,i1,i2->i0,i1,i2-n)");
		schedules.put("S3", "(i0,i1,i2->i0,i1,i2-n)");
		schedules.put("S5", "(i0,i1,i2->i0,i1,i2)");
		schedules.put("S6", "(i0,i1,i2->i0,i1,i2)");
		schedules.put("S8", "(i0,i1,i2->i0,i1,i2+n)");
		schedules.put("S9", "(i0,i1,i2->i0,i1,i2)");

		stmtOrders.put("S8", "S10");
		stmtOrders.put("S10", "S13");
		stmtOrders.put("S13", "S5");
		stmtOrders.put("S5", "S6");
		stmtOrders.put("S6", "S9");
		stmtOrders.put("S9", "S2");
		stmtOrders.put("S2", "S3");
		stmtOrders.put("S3", "S14");

		return schedule(POLYBENCH.CORRELATION, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program scheduleCovariance() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S1 (i0,i1,i2->i0,i1,i2-n,3)
		//S2 (i0,i1,i2->i0,i1,i2-n,4)
		//S3 (i0,i1,i2->i0,i1,i2,0)
		//S5 (j1,j2,i->j1,j2,i,1)
		//S6 (i0,i1,i2->i1,i0+i1,i2,2)
		//prefix[]; tilable[true,true,true,false] (3)

		schedules.put("S1", "(i0,i1,i2->i0,i1,i2-n)");
		schedules.put("S2", "(i0,i1,i2->i0,i1,i2-n)");
		schedules.put("S3", "(i0,i1,i2->i0,i1,i2)");
		schedules.put("S5", "(j1,j2,i->j1,j2,i)");
		schedules.put("S6", "(i0,i1,i2->i1,i0+i1,i2)");

		stmtOrders.put("S3", "S5");
		stmtOrders.put("S5", "S6");
		stmtOrders.put("S6", "S1");
		stmtOrders.put("S1", "S2");

		return schedule(POLYBENCH.COVARIANCE, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program schedule2mm() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S1 (i0,i1,i2->i0,i1+i2,i2,1)
		//S3 (i,j,k->i,k+nk,j+k,0)
		//prefix[]; tilable[true,true,true,false] (3)

		schedules.put("S1", "(i0,i1,i2->i0,i1+i2,i2)");
		schedules.put("S3", "(i,j,k->i,k+nk,j+k)");

		stmtOrders.put("S3", "S1");

		return schedule(POLYBENCH.TWOMM, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program schedule3mm() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S1 (i0,i1,i2->i1+i2-nk,i0,i2,1)
		//S3 (i0,i1,i2->i0+i2-nm,i1,i2,2)
		//S5 (i,j,k->k,i+j,i+k,0)
		//prefix[]; tilable[true,true,true,false] (3)

		schedules.put("S1", "(i0,i1,i2->i1+i2-nk,i0,i2)");
		schedules.put("S3", "(i0,i1,i2->i0+i2-nm,i1,i2)");
		schedules.put("S5", "(i,j,k->k,i+j,i+k)");

		stmtOrders.put("S5", "S1");
		stmtOrders.put("S1", "S3");

		return schedule(POLYBENCH.THREEMM, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program scheduleAtax() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S2 (i,j->i,j,1)
		//S3 (i,j->i,j+ny,0)
		//prefix[]; tilable[true,true,false] (2)

		schedules.put("S2", "(i,j->i,j)");
		schedules.put("S3", "(i,j->i,j+ny)");

		stmtOrders.put("S3", "S2");

		return schedule(POLYBENCH.ATAX, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program scheduleBicg() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S2 (i,j->j,i)
		//S3 (i,j->i,j)
		//prefix[]; tilable[true,true] (2)

		schedules.put("S2", "(i,j->j,i)");
		schedules.put("S3", "(i,j->i,j)");

		return schedule(POLYBENCH.BICG, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program scheduleCholesky() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S1 (i0,i1,i2->i2,i1,i0,2)
		//S2 (i0,i1,i2->i2,i1,i0,3)
		//S4 (i,j,k->k,j,i,0)
		//S5 (i0,i1,i2->i2,i1,i0,1)
		//prefix[]; tilable[true,true,true,false] (3)

		schedules.put("S1", "(i0,i1,i2->i2,i1,i0)");
		schedules.put("S2", "(i0,i1,i2->i2,i1,i0)");
		schedules.put("S4", "(i,j,k->k,j,i)");
		schedules.put("S5", "(i0,i1,i2->i2,i1,i0)");

		stmtOrders.put("S4", "S5");
		stmtOrders.put("S5", "S1");
		stmtOrders.put("S1", "S2");

		return schedule(POLYBENCH.CHOLESKY, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program scheduleDoitgen() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S1 (r,q,p,s->r,q,p,s,0)
		//S2 (i0,i1,i2,i3->i0,i1,i2,i3,1)
		//prefix[]; tilable[true,true,true,true,true] (5)

		schedules.put("S1", "(r,q,p,s->r,q,p,s)");
		schedules.put("S2", "(i0,i1,i2,i3->i0,i1,i2,i3)");

		stmtOrders.put("S1", "S2");

		return schedule(POLYBENCH.DOITGEN, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program scheduleGemm() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S1 (i,j,k->i,j,k)
		//prefix[]; tilable[true,true,true] (3)

		schedules.put("S1", "(i,j,k->i,j,k)");

		return schedule(POLYBENCH.GEMM, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program scheduleGemver() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S0 (i,j->j,i,1)
		//S1 (i0,i1->i1,i0,2)
		//S2 (i0,i1->i1,i0,3)
		//S3 (i,j->j,i+n,0)
		//prefix[]; tilable[true,true,false] (2)

		schedules.put("S0", "(i,j->j,i)");
		schedules.put("S1", "(i0,i1->i1,i0)");
		schedules.put("S2", "(i0,i1->i1,i0)");
		schedules.put("S3", "(i,j->j,i+n)");

		stmtOrders.put("S3", "S0");
		stmtOrders.put("S0", "S1");
		stmtOrders.put("S1", "S2");

		return schedule(POLYBENCH.GEMVER, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program scheduleGesummv() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S2 (i,j->i,j,1)
		//S3 (i,j->i,j,0)
		//S4 (i0,i1->i0,i1,2)
		//prefix[]; tilable[true,true,true] (3)

		schedules.put("S2", "(i,j->i,j)");
		schedules.put("S3", "(i,j->i,j)");
		schedules.put("S4", "(i0,i1->i0,i1)");

		stmtOrders.put("S3", "S2");
		stmtOrders.put("S2", "S4");

		return schedule(POLYBENCH.GESUMMV, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program scheduleMvt() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S0 (i,j->i,j)
		//S1 (i,j->i,j)
		//prefix[]; tilable[true,true] (2)

		schedules.put("S0", "(i,j->i,j)");
		schedules.put("S1", "(i,j->i,j)");

		return schedule(POLYBENCH.MVT, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program scheduleSymm() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S1 (i,j,k->k,j,i,0)
		//S2 (i,j,k->i,j,i-j+k,2)
		//S3 (i0,i1,i2->i2,i1,i0,1)
		//prefix[]; tilable[true,true,true,false] (3)

		schedules.put("S1", "(i,j,k->k,j,i)");
		schedules.put("S2", "(i,j,k->i,j,i-j+k)");
		schedules.put("S3", "(i0,i1,i2->i2,i1,i0)");

		stmtOrders.put("S1", "S3");
		stmtOrders.put("S3", "S2");

		return schedule(POLYBENCH.SYMM, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program scheduleSyr2k() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S1 (i,j,k->i,j,k,0)
		//S2 (i,j,k->i,j,k,1)
		//prefix[]; tilable[true,true,true,false] (3)

		schedules.put("S1", "(i,j,k->i,j,k)");
		schedules.put("S2", "(i,j,k->i,j,k)");

		stmtOrders.put("S1", "S2");

		return schedule(POLYBENCH.SYR2K, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program scheduleSyrk() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S1 (i,j,k->i,j,k)
		//prefix[]; tilable[true,true,true] (3)

		schedules.put("S1", "(i,j,k->i,j,k)");

		return schedule(POLYBENCH.SYRK, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program scheduleTrisolv() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S1 (i,j->j,i,0)
		//S2 (i0,i1->i1,i0,1)
		//prefix[]; tilable[true,true,false] (2)

		schedules.put("S1", "(i,j->j,i)");
		schedules.put("S2", "(i0,i1->i1,i0)");

		stmtOrders.put("S1", "S2");

		return schedule(POLYBENCH.TRISOLV, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program scheduleTrmm() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S0 (i,j,k->j+k,i,i+j)
		//prefix[]; tilable[true,true,true] (3)

		schedules.put("S0", "(i,j,k->j+k,i,i+j)");

		return schedule(POLYBENCH.TRMM, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program scheduleDurbin() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S3 (i0,i1->i1,i0,3)
		//S5 (k,i->k,i,0)
		//S6 (i0,i1->i0,i1,4)
		//S7 (k,i->k,i+k,1)
		//S9 (i0,i1->i0,i0+i1,2)
		//prefix[]; tilable[true,false,false] (1)

		schedules.put("S3", "(i0,i1->i1,i0)");
		schedules.put("S5", "(k,i->k,i)");
		schedules.put("S6", "(i0,i1->i0,i1)");
		schedules.put("S7", "(k,i->k,i+k)");
		schedules.put("S9", "(i0,i1->i0,i0+i1)");

		stmtOrders.put("S5", "S7");
		stmtOrders.put("S7", "S9");
		stmtOrders.put("S9", "S3");
		stmtOrders.put("S3", "S6");

		return schedule(POLYBENCH.DURBIN, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program scheduleDynprog() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S3 (iter,i,j,k->i,iter,k,j,0)
		//S4 (i0,i1,i2,i3->i1,i0,i3,i2,1)
		//S5 (i0,i1,i2,i3->i1,i0,i3,i2,2)
		//prefix[]; tilable[true,true,true,true,false] (4)

		schedules.put("S3", "(iter,i,j,k->i,iter,k,j)");
		schedules.put("S4", "(i0,i1,i2,i3->i1,i0,i3,i2)");
		schedules.put("S5", "(i0,i1,i2,i3->i1,i0,i3,i2)");

		stmtOrders.put("S3", "S4");
		stmtOrders.put("S4", "S5");

		return schedule(POLYBENCH.DYNPROG, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program scheduleGramschmidt() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S1 (i0,i1,i2->i1,i0+i1,i2,0)
		//S2 (i0,i1,i2->i1,i0+i1,i2,1)
		//S3 (i0,i1,i2->i1,i0+i1,i2+ni,2)
		//S5 (k,j,i->k,j+k,i,0)
		//S6 (k,j,i->k,j+k,i+ni,1)
		//prefix[]; tilable[true,true,false,false] (2)

		schedules.put("S1", "(i0,i1,i2->i1,i0+i1,i2)");
		schedules.put("S2", "(i0,i1,i2->i1,i0+i1,i2)");
		schedules.put("S3", "(i0,i1,i2->i1,i0+i1,i2+ni)");
		schedules.put("S5", "(k,j,i->k,j+k,i)");
		schedules.put("S6", "(k,j,i->k,j+k,i+ni)");

		stmtOrders.put("S5", "S6");
		stmtOrders.put("S6", "S3");

		return schedule(POLYBENCH.GRAMSCHMIDT, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program scheduleLu() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S0 (i0,i1,i2->i0,i1,i2,1)
		//S1 (k,i,j->k,i,j,0)
		//prefix[]; tilable[true,true,true,false] (3)

		schedules.put("S0", "(i0,i1,i2->i0,i1,i2)");
		schedules.put("S1", "(k,i,j->k,i,j)");

		stmtOrders.put("S1", "S0");

		return schedule(POLYBENCH.LU, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program scheduleLudcmp() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S10 (i0,i1,i2->i1,i2,i0,0)
		//S12 (i0,i1,i2->i2,i1+i2-i0,i0,0)
		//S13 (i0,i1,i2->i0-i2+n,2n-i2,i1,1)
		//S14 (i0,i1,i2->i0-i2+n,2n-i2,i1-i2+n,0)
		//S2 (i,j,k->k,j,i,0)
		//S3 (i0,i1,i2->i0,i2,i1,1)
		//S5 (i,j,k->k,j,i,0)
		//S6 (i0,i1,i2->i0,i1,i2,1)
		//S9 (i0,i1,i2->i0,i2,i1,2)
		//prefix[]; tilable[true,true,false,false] (2)

		schedules.put("S10", "(i0,i1,i2->i1,i2,i0)");
		schedules.put("S12", "(i0,i1,i2->i2,i1+i2-i0,i0)");
		schedules.put("S13", "(i0,i1,i2->i0-i2+n,2n-i2,i1)");
		schedules.put("S14", "(i0,i1,i2->i0-i2+n,2n-i2,i1-i2+n)");
		schedules.put("S2", "(i,j,k->k,j,i)");
		schedules.put("S3", "(i0,i1,i2->i0,i2,i1)");
		schedules.put("S5", "(i,j,k->k,j,i)");
		schedules.put("S6", "(i0,i1,i2->i0,i1,i2)");
		schedules.put("S9", "(i0,i1,i2->i0,i2,i1)");

		stmtOrders.put("S5", "S6");
		stmtOrders.put("S6", "S9");

		return schedule(POLYBENCH.LUDCMP, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program scheduleFloyd_warshall() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S0 (k,i,j->k,i,j)
		//prefix[]; tilable[true,false,false] (1)

		schedules.put("S0", "(k,i,j->k,i,j)");

		return schedule(POLYBENCH.FLOYD_WARSHALL, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program scheduleReg_detect() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S0 (t,j,i,cnt->t,-i+j,i,cnt,0)
		//S1 (i0,i1,i2,i3->i0,i1-i2,i2,i3,2)
		//S2 (t,j,i,cnt->t,-i+j,i,cnt,1)
		//S3 (i0,i1,i2,i3->i0,i1-i2,i2,i3,3)
		//S4 (i0,i1,i2,i3->i0,-i2,i1+i2,i3,4)
		//S5 (i0,i1,i2,i3->i0,i1-i2,i2,i3,5)
		//prefix[]; tilable[true,true,true,true,false] (4)

		schedules.put("S0", "(t,j,i,cnt->t,-i+j,i,cnt)");
		schedules.put("S1", "(i0,i1,i2,i3->i0,i1-i2,i2,i3)");
		schedules.put("S2", "(t,j,i,cnt->t,-i+j,i,cnt)");
		schedules.put("S3", "(i0,i1,i2,i3->i0,i1-i2,i2,i3)");
		schedules.put("S4", "(i0,i1,i2,i3->i0,-i2,i1+i2,i3)");
		schedules.put("S5", "(i0,i1,i2,i3->i0,i1-i2,i2,i3)");

		stmtOrders.put("S0", "S2");
		stmtOrders.put("S2", "S1");
		stmtOrders.put("S1", "S3");
		stmtOrders.put("S3", "S4");
		stmtOrders.put("S4", "S5");

		return schedule(POLYBENCH.REG_DETECT, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program scheduleAdi() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S0 (t,i1,i2->t,i1,i2,2)
		//S1 (t,i1,i2->t,i1,i2,0)
		//S2 (i0,i1,i2->i0,i1,i2,4)
		//S3 (i0,i1,i2->i0,i1,i2,3)
		//S4 (t,i1,i2->t,i1,i2,5)
		//S5 (t,i1,i2->t,i1,i2,1)
		//S6 (i0,i1,i2->i0,i1,i2,7)
		//S7 (i0,i1,i2->i0,i1,i2,6)
		//prefix[]; tilable[true,true,true,false] (3)

		schedules.put("S0", "(t,i1,i2->t,i1,i2)");
		schedules.put("S1", "(t,i1,i2->t,i1,i2)");
		schedules.put("S2", "(i0,i1,i2->i0,i1,i2)");
		schedules.put("S3", "(i0,i1,i2->i0,i1,i2)");
		schedules.put("S4", "(t,i1,i2->t,i1,i2)");
		schedules.put("S5", "(t,i1,i2->t,i1,i2)");
		schedules.put("S6", "(i0,i1,i2->i0,i1,i2)");
		schedules.put("S7", "(i0,i1,i2->i0,i1,i2)");

		stmtOrders.put("S1", "S5");
		stmtOrders.put("S5", "S0");
		stmtOrders.put("S0", "S3");
		stmtOrders.put("S3", "S2");
		stmtOrders.put("S2", "S4");
		stmtOrders.put("S4", "S7");
		stmtOrders.put("S7", "S6");

		return schedule(POLYBENCH.ADI, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program scheduleFdtd_2d() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S0 (i0,i1,i2->i0,i0+i1,i0+i1-i2,2)
		//S1 (t,i,j->t,-i+t,-i-j+t,0)
		//S2 (t,i,j->t,-i+t,-i-j+t,1)
		//S3 (t,i,j->t,-i+t,-i-j+t,3)
		//prefix[]; tilable[true,true,true,false] (3)

		schedules.put("S0", "(i0,i1,i2->i0,i0+i1,i0+i1-i2)");
		schedules.put("S1", "(t,i,j->t,-i+t,-i-j+t)");
		schedules.put("S2", "(t,i,j->t,-i+t,-i-j+t)");
		schedules.put("S3", "(t,i,j->t,-i+t,-i-j+t)");

		stmtOrders.put("S1", "S2");
		stmtOrders.put("S2", "S0");
		stmtOrders.put("S0", "S3");

		return schedule(POLYBENCH.FDTD_2D, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program scheduleFdtd_apml() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S1 (iz,iy,ix->iz,ix,iy,0)
		//S10 (iz,iy,ix->iz,ix,iy,5)
		//S11 (iz,iy,ix->iz,ix,iy,4)
		//S12 (i0,i1,i2->i0,i2,i1,0)
		//S13 (i0,i1,i2->i0,i2,i1,1)
		//S14 (i0,i1,i2->i0,i2,i1,2)
		//S2 (iz,iy,ix->iz,ix,iy,6)
		//S3 (iz,iy,ix->iz,ix,iy,1)
		//S5 (i0,i1,i2->i0,i1,i2,0)
		//S6 (i0,i1,i2->i0,i1,i2,1)
		//S8 (iz,iy,ix->iz,ix,iy,2)
		//S9 (iz,iy,ix->iz,ix,iy,3)
		//prefix[]; tilable[true,true,true,true] (4)

		schedules.put("S1", "(iz,iy,ix->iz,ix,iy)");
		schedules.put("S10", "(iz,iy,ix->iz,ix,iy)");
		schedules.put("S11", "(iz,iy,ix->iz,ix,iy)");
		schedules.put("S12", "(i0,i1,i2->i0,i2,i1)");
		schedules.put("S13", "(i0,i1,i2->i0,i2,i1)");
		schedules.put("S14", "(i0,i1,i2->i0,i2,i1)");
		schedules.put("S2", "(iz,iy,ix->iz,ix,iy)");
		schedules.put("S3", "(iz,iy,ix->iz,ix,iy)");
		schedules.put("S5", "(i0,i1,i2->i0,i1,i2)");
		schedules.put("S6", "(i0,i1,i2->i0,i1,i2)");
		schedules.put("S8", "(iz,iy,ix->iz,ix,iy)");
		schedules.put("S9", "(iz,iy,ix->iz,ix,iy)");

		stmtOrders.put("S5", "S6");
		stmtOrders.put("S6", "S8");
		stmtOrders.put("S8", "S9");
		stmtOrders.put("S9", "S11");
		stmtOrders.put("S11", "S10");
		stmtOrders.put("S10", "S2");

		return schedule(POLYBENCH.FDTD_APML, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program scheduleJacobi_1d_imper() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S0 (t,i->t,i+t,0)
		//S1 (t,j->t,j+t,1)
		//prefix[]; tilable[true,true,false] (2)

		schedules.put("S0", "(t,i->t,i+t)");
		schedules.put("S1", "(t,j->t,j+t)");

		stmtOrders.put("S0", "S1");

		return schedule(POLYBENCH.JACOBI_1D_IMPER, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program scheduleJacobi_2d_imper() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S0 (t,i,j->t,i+t,i+j+t,0)
		//S1 (t,i,j->t,i+t,i+j+t,1)
		//prefix[]; tilable[true,true,true,false] (3)

		schedules.put("S0", "(t,i,j->t,i+t,i+j+t)");
		schedules.put("S1", "(t,i,j->t,i+t,i+j+t)");

		stmtOrders.put("S0", "S1");

		return schedule(POLYBENCH.JACOBI_2D_IMPER, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}

	public static Program scheduleSeidel_2d() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S0 (t,i,j->t,i+t,i+j+2t)
		//prefix[]; tilable[true,true,true] (3)

		schedules.put("S0", "(t,i,j->t,i+t,i+j+2t)");

		return schedule(POLYBENCH.SEIDEL_2D, VARIATION.FIXED_HAND_ALIGNED, schedules, stmtOrders);
	}


	private static Program schedule(POLYBENCH bench, VARIATION var, Map<String, String> schedules, Map<String, String> stmtOrders) {
		Program prog = alphaz.mde.Basic.ReadAlphabets(bench.getFilePath(var));
		
		checkProgram(prog);
		
		AffineSystem system = prog.getSystem(bench.getName());
		
		//schedules 
		for (String stmt : schedules.keySet()) {
			alphaz.mde.TargetMapping.setSpaceTimeMap(prog, system.getName(), stmt, schedules.get(stmt));
		}
		
		//orders
		for (String pred : stmtOrders.keySet()) {
			alphaz.mde.TargetMapping.setStatementOrdering(prog, system.getName(), pred, stmtOrders.get(pred));
		}
		
		return prog;
	}

	private static void checkProgram(Program prog) {
		ValidatorOutput out = UniquenessAndCompletenessCheck.validate(prog);
		assert(out.isValid()) : out.toString(VERBOSITY.MAX);
	}
}