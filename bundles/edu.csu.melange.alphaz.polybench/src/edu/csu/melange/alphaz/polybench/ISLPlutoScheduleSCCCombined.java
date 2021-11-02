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

public class ISLPlutoScheduleSCCCombined {
	
	
	public static Program schedule2mm() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S1 (i0,i1,i2->i0,i2,i1-nk,2)
		//S1_uni1A (i0,i1,i2->i0,i2,i1,3)
		//S1_uni1B (i0,i1,i2->i0,i2,nk-i1,0)
		//S3 (i,j,k->i,k,j+nk,1)
		//prefix[]; tilable[true,true,true,false] (3)

		schedules.put("S1", "(i0,i1,i2->i0,i2,i1-nk)");
		schedules.put("S1_uni1A", "(i0,i1,i2->i0,i2,i1)");
		schedules.put("S1_uni1B", "(i0,i1,i2->i0,i2,nk-i1)");
		schedules.put("S3", "(i,j,k->i,k,j+nk)");

		stmtOrders.put("S1_uni1B", "S3");
		stmtOrders.put("S3", "S1");
		stmtOrders.put("S1", "S1_uni1A");

		return schedule(POLYBENCH.TWOMM, VARIATION.FIXED_UNIFORMIZED, schedules, stmtOrders);
	}

	public static Program schedule3mm() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S1 (i0,i1,i2->i2,i1-nk,i0,3)
		//S1_uni1A (i0,i1,i2->i2,i1,i0,2)
		//S1_uni1B (i0,i1,i2->i2,nk-i1,i0,6)
		//S3 (i0,i1,i2->i2,i1,i0-nm,4)
		//S3_uni1A (i0,i1,i2->i2,i1,i0,0)
		//S3_uni1B (i0,i1,i2->i2,i1,nm-i0,5)
		//S5 (i,j,k->k,j+nk,i+nm,1)
		//prefix[]; tilable[true,true,true,false] (3)

		schedules.put("S1", "(i0,i1,i2->i2,i1-nk,i0)");
		schedules.put("S1_uni1A", "(i0,i1,i2->i2,i1,i0)");
		schedules.put("S1_uni1B", "(i0,i1,i2->i2,nk-i1,i0)");
		schedules.put("S3", "(i0,i1,i2->i2,i1,i0-nm)");
		schedules.put("S3_uni1A", "(i0,i1,i2->i2,i1,i0)");
		schedules.put("S3_uni1B", "(i0,i1,i2->i2,i1,nm-i0)");
		schedules.put("S5", "(i,j,k->k,j+nk,i+nm)");

		stmtOrders.put("S3_uni1A", "S5");
		stmtOrders.put("S5", "S1_uni1A");
		stmtOrders.put("S1_uni1A", "S1");
		stmtOrders.put("S1", "S3");
		stmtOrders.put("S3", "S3_uni1B");
		stmtOrders.put("S3_uni1B", "S1_uni1B");

		return schedule(POLYBENCH.THREEMM, VARIATION.FIXED_UNIFORMIZED, schedules, stmtOrders);
	}

	public static Program scheduleAtax() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S2 (i,j->i,j-2ny,2)
		//S2_uni1B (i,j->i,-j,0)
		//S3 (i,j->i,-j,1)
		//prefix[]; tilable[true,true,false] (2)

		schedules.put("S2", "(i,j->i,j-2ny)");
		schedules.put("S2_uni1B", "(i,j->i,-j)");
		schedules.put("S3", "(i,j->i,-j)");

		stmtOrders.put("S2_uni1B", "S3");
		stmtOrders.put("S3", "S2");

		return schedule(POLYBENCH.ATAX, VARIATION.FIXED_UNIFORMIZED, schedules, stmtOrders);
	}

	public static Program scheduleBicg() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S2 (i,j->j,i)
		//S3 (i,j->i,j)
		//prefix[]; tilable[true,true] (2)

		schedules.put("S2", "(i,j->j,i)");
		schedules.put("S3", "(i,j->i,j)");

		return schedule(POLYBENCH.BICG, VARIATION.FIXED_UNIFORMIZED, schedules, stmtOrders);
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

		return schedule(POLYBENCH.DOITGEN, VARIATION.FIXED_UNIFORMIZED, schedules, stmtOrders);
	}

	public static Program scheduleGemm() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S1 (i,j,k->i,j,k)
		//prefix[]; tilable[true,true,true] (3)

		schedules.put("S1", "(i,j,k->i,j,k)");

		return schedule(POLYBENCH.GEMM, VARIATION.FIXED_UNIFORMIZED, schedules, stmtOrders);
	}

	public static Program scheduleGemver() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S0 (i,j->j,i,2)
		//S1 (i0,i1->i1,i0,3)
		//S2 (i0,i1->i1,i0,4)
		//S2_uni1B (i0,i1->i1,2n-i0,0)
		//S3 (i,j->j,i+2n,1)
		//prefix[]; tilable[true,true,false] (2)

		schedules.put("S0", "(i,j->j,i)");
		schedules.put("S1", "(i0,i1->i1,i0)");
		schedules.put("S2", "(i0,i1->i1,i0)");
		schedules.put("S2_uni1B", "(i0,i1->i1,2n-i0)");
		schedules.put("S3", "(i,j->j,i+2n)");

		stmtOrders.put("S2_uni1B", "S3");
		stmtOrders.put("S3", "S0");
		stmtOrders.put("S0", "S1");
		stmtOrders.put("S1", "S2");

		return schedule(POLYBENCH.GEMVER, VARIATION.FIXED_UNIFORMIZED, schedules, stmtOrders);
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

		return schedule(POLYBENCH.GESUMMV, VARIATION.FIXED_UNIFORMIZED, schedules, stmtOrders);
	}

	public static Program scheduleMvt() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S0 (i,j->i,j)
		//S1 (i,j->i,j)
		//prefix[]; tilable[true,true] (2)

		schedules.put("S0", "(i,j->i,j)");
		schedules.put("S1", "(i,j->i,j)");

		return schedule(POLYBENCH.MVT, VARIATION.FIXED_UNIFORMIZED, schedules, stmtOrders);
	}

	public static Program scheduleSymm() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S1 (i,j,k->k,j,i,0)
		//S2 (i,j,k->i,j,k-2j,4)
		//S2_uni1A (i,j,k->i,j,k,2)
		//S2_uni1B (i,j,k->i,j,-k,1)
		//S3 (i0,i1,i2->i2,i1,i0,3)
		//prefix[]; tilable[true,true,true,false] (3)

		schedules.put("S1", "(i,j,k->k,j,i)");
		schedules.put("S2", "(i,j,k->i,j,k-2j)");
		schedules.put("S2_uni1A", "(i,j,k->i,j,k)");
		schedules.put("S2_uni1B", "(i,j,k->i,j,-k)");
		schedules.put("S3", "(i0,i1,i2->i2,i1,i0)");

		stmtOrders.put("S1", "S2_uni1B");
		stmtOrders.put("S2_uni1B", "S2_uni1A");
		stmtOrders.put("S2_uni1A", "S3");
		stmtOrders.put("S3", "S2");

		return schedule(POLYBENCH.SYMM, VARIATION.FIXED_UNIFORMIZED, schedules, stmtOrders);
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

		return schedule(POLYBENCH.SYR2K, VARIATION.FIXED_UNIFORMIZED, schedules, stmtOrders);
	}

	public static Program scheduleSyrk() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S1 (i,j,k->i,j,k)
		//prefix[]; tilable[true,true,true] (3)

		schedules.put("S1", "(i,j,k->i,j,k)");

		return schedule(POLYBENCH.SYRK, VARIATION.FIXED_UNIFORMIZED, schedules, stmtOrders);
	}

	public static Program scheduleTrisolv() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S1 (i,j->i,j,1)
		//S2 (i0,i1->i0,i1,2)
		//S2_uni1A (i0,i1->i0,i1,0)
		//prefix[]; tilable[true,true,false] (2)

		schedules.put("S1", "(i,j->i,j)");
		schedules.put("S2", "(i0,i1->i0,i1)");
		schedules.put("S2_uni1A", "(i0,i1->i0,i1)");

		stmtOrders.put("S2_uni1A", "S1");
		stmtOrders.put("S1", "S2");

		return schedule(POLYBENCH.TRISOLV, VARIATION.FIXED_UNIFORMIZED, schedules, stmtOrders);
	}

	public static Program scheduleDynprog() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S3 (iter,i,j,k->i,iter,j,k,1)
		//S4 (i0,i1,i2,i3->i1,i0,i2,i3,2)
		//S4_uni1A (i0,i1,i2,i3->i1,i0,i2,i3,0)
		//S5 (i0,i1,i2,i3->i1,i0,i2,i3,3)
		//prefix[]; tilable[true,true,true,true,false] (4)

		schedules.put("S3", "(iter,i,j,k->i,iter,j,k)");
		schedules.put("S4", "(i0,i1,i2,i3->i1,i0,i2,i3)");
		schedules.put("S4_uni1A", "(i0,i1,i2,i3->i1,i0,i2,i3)");
		schedules.put("S5", "(i0,i1,i2,i3->i1,i0,i2,i3)");

		stmtOrders.put("S4_uni1A", "S3");
		stmtOrders.put("S3", "S4");
		stmtOrders.put("S4", "S5");

		return schedule(POLYBENCH.DYNPROG, VARIATION.FIXED_UNIFORMIZED, schedules, stmtOrders);
	}

	public static Program scheduleGramschmidt() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S1 (i0,i1,i2->i1,i0+i1,i2-2ni,2)
		//S2 (i0,i1,i2->i1,i0+i1,i0-i1-i2,0)
		//S2_uni1B (i0,i1,i2->i1,i0+i1,-i2,1)
		//S3 (i0,i1,i2->i1,i0+i1,-i2,3)
		//S3_uni1A (i0,i1,i2->i0,i0+i1,i2,1)
		//S5 (k,j,i->k,j+k,i,2)
		//S5_uni1B (k,j,i->k,j+k,2ni-i,0)
		//S6 (k,j,i->k,j+k,i+2ni,3)
		//prefix[]; tilable[true,true,false,false] (2)

		schedules.put("S1", "(i0,i1,i2->i1,i0+i1,i2-2ni)");
		schedules.put("S2", "(i0,i1,i2->i1,i0+i1,i0-i1-i2)");
		schedules.put("S2_uni1B", "(i0,i1,i2->i1,i0+i1,-i2)");
		schedules.put("S3", "(i0,i1,i2->i1,i0+i1,-i2)");
		schedules.put("S3_uni1A", "(i0,i1,i2->i0,i0+i1,i2)");
		schedules.put("S5", "(k,j,i->k,j+k,i)");
		schedules.put("S5_uni1B", "(k,j,i->k,j+k,2ni-i)");
		schedules.put("S6", "(k,j,i->k,j+k,i+2ni)");

		stmtOrders.put("S5_uni1B", "S3_uni1A");
		stmtOrders.put("S3_uni1A", "S5");
		stmtOrders.put("S5", "S6");

		return schedule(POLYBENCH.GRAMSCHMIDT, VARIATION.FIXED_UNIFORMIZED, schedules, stmtOrders);
	}

	public static Program scheduleLu() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S0 (i0,i1,i2->i1,i0+i1,i1+i2,3)
		//S0_uni1A (i0,i1,i2->i0,i0+i1,i0+i2,1)
		//S1 (k,i,j->k,i+k,j+k,2)
		//S1_uni1A (k,i,j->k,i+k,i+j,4)
		//S1_uni2A (k,i,j->k,i+k,j+k,0)
		//prefix[]; tilable[true,true,true,false] (3)

		schedules.put("S0", "(i0,i1,i2->i1,i0+i1,i1+i2)");
		schedules.put("S0_uni1A", "(i0,i1,i2->i0,i0+i1,i0+i2)");
		schedules.put("S1", "(k,i,j->k,i+k,j+k)");
		schedules.put("S1_uni1A", "(k,i,j->k,i+k,i+j)");
		schedules.put("S1_uni2A", "(k,i,j->k,i+k,j+k)");

		stmtOrders.put("S1_uni2A", "S0_uni1A");
		stmtOrders.put("S0_uni1A", "S1");
		stmtOrders.put("S1", "S0");
		stmtOrders.put("S0", "S1_uni1A");

		return schedule(POLYBENCH.LU, VARIATION.FIXED_UNIFORMIZED, schedules, stmtOrders);
	}

	public static Program scheduleFloyd_warshall() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S0 (k,i,j->k,i,j,0)
		//S0_uni1A (k,i,j->k,i,j,0)
		//S0_uni1B (k,i,j->k,i,-j+2k,1)
		//S0_uni2A (k,i,j->k,i,j,0)
		//S0_uni2B (k,i,j->k,-i+2k,j,2)
		//prefix[]; tilable[true,false,false,false] (1)

		schedules.put("S0", "(k,i,j->k,i,j)");
		schedules.put("S0_uni1A", "(k,i,j->k,i,j)");
		schedules.put("S0_uni1B", "(k,i,j->k,i,-j+2k)");
		schedules.put("S0_uni2A", "(k,i,j->k,i,j)");
		schedules.put("S0_uni2B", "(k,i,j->k,-i+2k,j)");

		stmtOrders.put("S0_uni2A", "S0_uni1B");
		stmtOrders.put("S0_uni1B", "S0_uni2B");

		return schedule(POLYBENCH.FLOYD_WARSHALL, VARIATION.FIXED_UNIFORMIZED, schedules, stmtOrders);
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

		return schedule(POLYBENCH.REG_DETECT, VARIATION.FIXED_UNIFORMIZED, schedules, stmtOrders);
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

		return schedule(POLYBENCH.ADI, VARIATION.FIXED_UNIFORMIZED, schedules, stmtOrders);
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

		return schedule(POLYBENCH.FDTD_APML, VARIATION.FIXED_UNIFORMIZED, schedules, stmtOrders);
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

		return schedule(POLYBENCH.FDTD_2D, VARIATION.FIXED_UNIFORMIZED, schedules, stmtOrders);
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

		return schedule(POLYBENCH.JACOBI_1D_IMPER, VARIATION.FIXED_UNIFORMIZED, schedules, stmtOrders);
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

		return schedule(POLYBENCH.JACOBI_2D_IMPER, VARIATION.FIXED_UNIFORMIZED, schedules, stmtOrders);
	}

	public static Program scheduleSeidel_2d() {
		Map<String, String> schedules  = new TreeMap<String, String>();
		Map<String, String> stmtOrders = new TreeMap<String, String>();
	
		//S0 (t,i,j->t,i+t,i+j+2t)
		//prefix[]; tilable[true,true,true] (3)

		schedules.put("S0", "(t,i,j->t,i+t,i+j+2t)");

		return schedule(POLYBENCH.SEIDEL_2D, VARIATION.FIXED_UNIFORMIZED, schedules, stmtOrders);
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
