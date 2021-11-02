package edu.csu.melange.alphaz.polybench;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;
import org.polymodel.polyhedralIR.AffineFunction;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.ParameterDomain;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.analysis.UniformnessCheck;
import org.polymodel.polyhedralIR.analysis.UniformnessResult;
import org.polymodel.polyhedralIR.factory.PolyhedralIRUtility;
import org.polymodel.polyhedralIR.transformation.ChangeOfBasis;
import org.polymodel.polyhedralIR.transformation.Normalize;
import org.polymodel.polyhedralIR.transformation.UniformizeInContext;

import edu.csu.melange.alphaz.polybench.PolyBench.POLYBENCH;
import edu.csu.melange.alphaz.polybench.PolyBench.VARIATION;

/**
 * Algorithm:
 * 
 * Input: 
 *   - G : PRDG (excluding inputs)
 *   - Gn: nodes in G
 *   - Ge: edges in G
 * Output:
 *   - Affine transformation T for each node in the PRDG, or each variable in the system
 *   - If applicable, a node may also be associated with another node such that the transforms are composed in the end.
 * 
 * The reason for using composition is because there are many cases where embedding is easy to find out "locally".
 * For example, if a variable X[i] depends on Y[i,n], it is clear that X will be properly aligned with Y with
 * the transform (i->i,n). However, the system may contain additional dimensions, and figuring out the rest of the dimension
 * from the point of view of X can be difficult. If Y also have a similar dependence patter Y[i,j] = Z[i,j,n-1], and
 * the maximum number of dimensions in the system is 3, the final embedding transforms for X and Y are:
 *   T_X = (i->i,n,n) and T_Y (i,j->i,j,n), and T_X can easily be deduced through (i,j->i,j,n) o (i->i,n).
 * 
 * Steps:
 *   1. Find base variables denotes as Base:
 *     Base are defined as the variables with maximum number of dimensions in the starting program.
 *     These variables are not transformed during embedding, and are used to derive transforms of other variables.
 *   2. For each node n in Gn/Base,
 *     - check if n depends on Base
 *     - if it does, use the dependence function as the transform
 *       - when there are multiple dependences with different linear parts:
 *         - first try uniformize in context to reflect equalities
 *         - if linear parts are still incompatible, select one using general criteria listed below
 *       - otherwise, the difference in constant part does not influence the result
 *   3. For each node in Gn/Base
 *     - skip if transform is already given
 *     - check if n depends on m where the number of dimensions, dim(x), are dim(n) < dim(m)
 *       - if it does, then use the composition T_m o f, where T_m is the transform of m (which may not be defined yet),
 *          and f is the dependence function.
 *          - when there are multiple candidates, apply the rules in Step 2
 *     - check if n depends on m and only m where the number of dimensions are dim(n) <= dim(m)
 *        - if the dependences on m all share a common linear part A, then use f = Ax as the local transform,
 *          composed with the transform of m.
 *          
 *   The above steps are relatively straight-forward, and usually do not have much conflicting candidates.
 *   Even when it does, the possible candidates are likely to produce similar result (in terms of uniformizability)       
 *          
 *   4. For each node in Gn/Base
 *     - skip if transform is already given
 *     - check the number of dependences (with different linear parts) to n from some node m where dim(n)<=dim(m) 
 *       - if the number of dependences is 1 then select the (local) transform 
 *         as detailed below, and compose it with the transform of m
 *       - else if the number of dependence is greater than 1 use general criteria to select some transform
 *       - else there must be a dependence such that dim(n) > dim(m); or else the variable is not used
 *         - follow the dependence to m until some node x where dim(n)<=dim(x) is reached
 *           then select the transform as detailed below
 *       - note that in the above, there is a chance that cyclic composition is introduced
 *         if such case is encountered, follow the dependence to a different node instead of composing
 *         (fdtd-apml)
 *    
 * 
 * General Criteria:
 *   - When there are multiple conflicting candidates, then it is preferable to select
 *      transforms that embeds the variable along some boundary.
 *      
 * Selecting Transforms:
 *   There are a number of algebraic analysis to guide the selection of transforms.
 *     - If X is used by Y with a dependence function f, where dim(X) < dim(Y), and
 *       if one of the basis vector of the null space of f is a unit vector (all zero but one element),
 *       then the dimension corresponding to the non-zero element should be the dimension where the domain of X
 *       after the transform have equalities.
 *       
 *       Example: Y[i,j] = X[i], then f = (i,j->i) and null(f) is spanned by [0,1].
 *         This rules out transforms for X such as (i->0,i), but favor (i->i,0),
 *         since the 2nd dimension is irrelevant to the dependence from Y to X.
 *         
 *       When there are multiple dependences, intersection of the nullspaces can be used.
 *       
 *     - If X is used by Y with a dependence function f, where dim(X) = dim(Y), and
 *       and Y is some permutation function, then the inverse of f, f^-1, may be used
 *       to align the axes.
 *     
 *       Example: Y[i,j] = X[j,i], then f = (i,j->j,i), then the transform (x,y->y,x) = f^-1
 *         will align the two dimensions and make the dependence uniform. 
 * 
 *
 * @author yuki
 *
 */
public class HandEmbedding {

	@Test
	public void embedCorrelation() {
		Map<String, String> transforms = new TreeMap<String, String>();
		Map<String, String> compositions = new TreeMap<String, String>();
		
		//listed in order of possible automation
		
		//S13: (i,j,k->i,j,k) -- base 
		//S14: (i,j->i,j,n-1) -- following dependence on S13
		transforms.put("S14", "(i,j->i,j,n-1)");
		//S3: S2 o (j->j,n-1) -- following dependence on S2
		transforms.put("S3", "(j->j,n-1)");
		compositions.put("S3", "S2");
		//S6: S5 o (j->j,n-1) -- following dependence on S5
		transforms.put("S6", "(j->j,n-1)");
		compositions.put("S6", "S5");

		//S8: S10 o (j->0,j) -- following dependence from S10; nullspace
		transforms.put("S8", "(j->0,j)");
		compositions.put("S8", "S10");
		
		//S9: S10 o (i,j->i,j) -- following dependence from S10; only one dependence makes it easy
		transforms.put("S9", "(i,j->i,j)");
		compositions.put("S9", "S10");
		
		//S2 and S5 are transitively dependent on S9 and S10
		// S3, S6, S8 in the middle of the transitive relation must be "skipped"
		// skipping can be done because S3, S6, S8 have lower dimensions than S2, S5
		
		//S2: S5 o (j,i->j,i) OR S9 o (j,i->i,j) eventually leads to the same and can be both deduced
		transforms.put("S2", "(j,i->i,j)");
		compositions.put("S2", "S9");
		//S5: S10 o (j,i->i,j)
		transforms.put("S5", "(j,i->i,j)");
		compositions.put("S5", "S10");
		
		//S10: (i,j->j,0,i) or (i,j->0,j,i) -- difficult case last dimensions should be i can be deduced from dependences from S13
		transforms.put("S10", "(i,j->j,0,i)");
		
		//Although it does not come into play here, cyclic dependences in compositions may become an issue
		
		embed(POLYBENCH.CORRELATION, transforms, compositions);
	}
	
	@Test
	public void embedCovariance() {
		Map<String, String> transforms = new TreeMap<String, String>();
		Map<String, String> compositions = new TreeMap<String, String>();
		
		//listed in order of possible automation
		//S5: (i,j,k->i,j,k) -- base 
		
		//S6: (i,j->i,j,n-1) -- following dependence on S5
		transforms.put("S6", "(i,j->i,j,n-1)");
		
		//S2: S1 o (j->j,n-1) -- following dependence on S1
		transforms.put("S2", "(j->j,n-1)");
		compositions.put("S2", "S1");
		
		//S1 is transitively used by S3 through S2, where S2 has lower dimensions than S1
		//S1: S3 o (i,j->j,i)
		transforms.put("S1", "(i,j->j,i)");
		compositions.put("S1", "S3");
		
		//S3: (i,j->0,j,i) -- difficult case last dimensions should be i can be deduced from dependences from S5
		// similar to S10 in correlation
		transforms.put("S3", "(i,j->0,j,i)");
		
		embed(POLYBENCH.COVARIANCE, transforms, compositions);
	}
	
	@Test
	public void embed2mm() {
		Map<String, String> transforms = new TreeMap<String, String>();
		Map<String, String> compositions = new TreeMap<String, String>();
		
		//This is NOT embedding, and is not part of the algorithm yet FIXME
		//2mm is already uniform, but a CoB can decrease the dependence rank
		
		//S1
		transforms.put("S1", "(i,j,k->i,k,j)");
		
		embed(POLYBENCH.TWOMM, transforms, compositions);
	}
	

	
	@Test
	public void embed3mm() {
		Map<String, String> transforms = new TreeMap<String, String>();
		Map<String, String> compositions = new TreeMap<String, String>();
		
		//This is NOT embedding, and is not part of the algorithm yet FIXME
		//3mm is already uniform, but a CoB can decrease the dependence rank

		//S1
		transforms.put("S1", "(i,j,k->i,k,j)");

		//S3
		transforms.put("S3", "(i,j,k->k,j,i)");
		
		embed(POLYBENCH.THREEMM, transforms, compositions);
	}
	
	@Test
	public void emebedCholesky() {
		Map<String, String> transforms = new TreeMap<String, String>();
		Map<String, String> compositions = new TreeMap<String, String>();
		
		//listed in order of possible automation
		//S4: (i,j,k->i,j,k) -- base
		
		//S5: (i,j->i,j,i-1) -- dependence on S4
		transforms.put("S5", "(i,j->i,j,i-1)");
		
		//S2: S1 o (i->i,i-1) -- dependence on S1
		transforms.put("S2", "(i->i,i-1)");
		compositions.put("S2", "S1");
		
		//S1: S5 o (i,j->j,i) -- dependence on S5
		transforms.put("S1", "(i,j->j,i)");
		compositions.put("S1", "S5");
		
		embed(POLYBENCH.CHOLESKY, transforms, compositions);
	}
	
	@Test
	public void embedDoitgen() {
		//Simple implementation works
		
		Map<String, String> transforms = new TreeMap<String, String>();
		Map<String, String> compositions = new TreeMap<String, String>();
		
		//listed in order of possible automation
		//S1: (r,q,p,s->r,q,p,s) -- base
		
		//S2: (r,q,p->r,q,p,np-1) -- dependence on S1
		transforms.put("S2", "(r,q,p->r,q,p,np-1)");
		
		embed(POLYBENCH.DOITGEN, transforms, compositions);
	}
	
	@Test
	public void embedGemver() {
		//Simple implementation works
		
		Map<String, String> transforms = new TreeMap<String, String>();
		Map<String, String> compositions = new TreeMap<String, String>();
		
		//listed in order of possible automation
		//S0: (i,j->i,j) -- base
		//S1: (i,j->i,j) -- base
		//S3: (i,j->i,j) -- base
		
		//S2: (i->i,n-1) -- dependence on S1
		transforms.put("S2", "(i->i,n-1)");

		//The following is NOT part of the algorithm yet FIXME
		//S1 needs to be permuted, and S2 needs to now compose with the permutation
		transforms.put("S1", "(i,j->j,i)");
		compositions.put("S2",  "S1");
		
		embed(POLYBENCH.GEMVER, transforms, compositions);
	}
	
	@Test
	public void embedGesummv() {
		//Simple implementation works
		
		Map<String, String> transforms = new TreeMap<String, String>();
		Map<String, String> compositions = new TreeMap<String, String>();
		
		//listed in order of possible automation
		//S2: (i,j->i,j) -- base
		//S3: (i,j->i,j) -- base
		
		//S4: (i->i,n-1) -- dependence on S2/S3
		transforms.put("S4", "(i->i,n-1)");
		
		embed(POLYBENCH.GESUMMV, transforms, compositions);
	}
	

	@Test
	public void embedSymm() {
		//Simple implementation works
		
		Map<String, String> transforms = new TreeMap<String, String>();
		Map<String, String> compositions = new TreeMap<String, String>();
		
		//listed in order of possible automation
		//S1: (i,j,k->i,j,k) -- base
		//S2: (i,j,k->i,j,k) -- base
		
		//S3: (i,j->i,j,i) -- dependence on S1
		// OR
		//S3: (i,j->i,j,j-2) -- dependence on S2
		transforms.put("S3", "(i,j->i,j,i)");
	
		
		embed(POLYBENCH.SYMM, transforms, compositions);
	}
	
	@Test
	public void embedTrisolv() {
		//Simple implementation works
		
		Map<String, String> transforms = new TreeMap<String, String>();
		Map<String, String> compositions = new TreeMap<String, String>();
		
		//listed in order of possible automation
		//S1: (i,j->i,j) -- base
		
		//S2: (i->i,i-1) -- dependence on S1
		transforms.put("S2", "(i->i,i-1)");
	
		
		embed(POLYBENCH.TRISOLV, transforms, compositions);
	}
	
	@Test
	public void embedDurbin() {
		Map<String, String> transforms = new TreeMap<String, String>();
		Map<String, String> compositions = new TreeMap<String, String>();
		
		//base
		//S5, S7
		
		//S6: (k->k,k-1) -- dependence on S5
		transforms.put("S6", "(k->k,k-1)");

		//S9: (i->n-1,i) -- dependence on S7
		transforms.put("S9", "(i->n-1,i)");
		
		//S3: S6 o (k->k) -- transitive
		transforms.put("S3", "(k->k)");
		compositions.put("S3", "S6");

		embed(POLYBENCH.DURBIN, transforms, compositions);
	}
	
	@Test
	public void embedDynprog() {
		Map<String, String> transforms = new TreeMap<String, String>();
		Map<String, String> compositions = new TreeMap<String, String>();
		
		//base
		//S3
		
		//S4: (iter,i,j->iter,i,j,j-1) -- dependence on S3
		transforms.put("S4", "(iter,i,j->iter,i,j,j-1)");

		//S5: S4 o (iter->iter,0,length-1) -- dependence on S4
		transforms.put("S5", "(iter->iter,0,length-1)");
		compositions.put("S5", "S4");

		embed(POLYBENCH.DYNPROG, transforms, compositions);
	}
	
	@Test
	public void embedGramschmidt() {
		Map<String, String> transforms = new TreeMap<String, String>();
		Map<String, String> compositions = new TreeMap<String, String>();
		
		//base
		//S5, S6
		
		//S1: (k,i->k-1,k,i) -- dependence on S6
		transforms.put("S1", "(k,i->k-1,k,i)");
		
		//S3: (k,i->k-1,k,i) -- dependence on S6
		transforms.put("S3", "(k,i->k-1,k,i)");
		
		//S2: S1 o (k->k,ni-1) -- only dependence
		transforms.put("S2", "(k->k,ni-1)");
		compositions.put("S2", "S1");
		
		embed(POLYBENCH.GRAMSCHMIDT, transforms, compositions);
	}

	@Test
	public void embedLU() {
		Map<String, String> transforms = new TreeMap<String, String>();
		Map<String, String> compositions = new TreeMap<String, String>();
		
		//base
		//S1
		
		//S0: (k,j->k-1,k,j) OR (k,j->k-1,k,k) -- dependence on S1
		transforms.put("S0", "(k,j->k-1,k,j)");

		embed(POLYBENCH.LU, transforms, compositions);
	}
	
	@Test
	public void embedLUD() {
		Map<String, String> transforms = new TreeMap<String, String>();
		Map<String, String> compositions = new TreeMap<String, String>();
		
		//base
		//S2, S5
		
		//S3: (i,j->i,j,i-1) -- dependence on S2
		transforms.put("S3", "(k,j->k-1,k,j)");
		
		//S6: (i,j->i,j,i) -- dependence on S5; note that 2 of 3 dependences on S5 have equalities leading to the same function
		transforms.put("S6", "(i,j->i,j,i)");
		
		//S10: S9 o (i->i,i-1) -- dependence on S9
		transforms.put("S10", "(i->i,i-1)");
		compositions.put("S10", "S9");
		
		//S9: S3 o (i,j->j,i) -- only a single dependence on S3; others are dependence on lower dimensions or self-dependence
		transforms.put("S9", "(i,j->j,i)");
		compositions.put("S9", "S3");
		
		//S12: S10 o (i->n-i-1) -- only a single dependence on S10
		transforms.put("S12", "(i->n-i-1)");
		compositions.put("S12", "S10");
		
		//S14: S13 o (i->i,n) OR S6 o (i->n-i-2,n-i-1) -- dependence on S13 or S6 both do NOT lead to the same but are similar
//		transforms.put("S14", "(i->n-i-1)");
//		compositions.put("S14", "S10");
		transforms.put("S14", "(i->n-i-2,n-i-1)");
		compositions.put("S14", "S6");

		//S13: S6 o (i,j->n-i-2,j) -- dependence on S6; out of the many, one from the most general branch of the case
		transforms.put("S13", "(i,j->n-i-2,j)");
		compositions.put("S13", "S6");

		embed(POLYBENCH.LUDCMP, transforms, compositions);
	}
	
	@Test
	public void embedRegDetect() {
		Map<String, String> transforms = new TreeMap<String, String>();
		Map<String, String> compositions = new TreeMap<String, String>();
		
		//base
		//S0, S2
		
		//S1: (t,j,i->t,j,i,0) -- dependence on S0
		transforms.put("S1", "(t,j,i->t,j,i,0)");
		
		//S3: (t,j,i->t,j,i,length-1) -- dependence on S2
		transforms.put("S3", "(t,j,i->t,j,i,length-1)");
		
		//S4: S3 o (t,i->t,0,i) -- dependence on S3
		transforms.put("S4", "(t,i->t,0,i)");
		compositions.put("S4", "S3");

		//S5: S3 o (t,j,i->t,j,i) -- dependence on S3
		transforms.put("S5", "(t,j,i->t,j,i)");
		compositions.put("S5", "S3");

		embed(POLYBENCH.REG_DETECT, transforms, compositions);
	}
	
	@Test
	public void embedADI() {

		Map<String, String> transforms = new TreeMap<String, String>();
		Map<String, String> compositions = new TreeMap<String, String>();
		
		//base
		//S0, S1, S3, S4, S5, S7
		
		//S2: (t,i->t,i1,n-1) -- dependence on S0/S1
		transforms.put("S2", "(t,i->t,i,n-1)");
		
		//S6: (t,i->t,n-1,i) -- dependence on S2
		transforms.put("S6", "(t,i->t,n-1,i)");
		
		//S3, S7 un-reversing
		transforms.put("S3", "(t,i,j->t,i,n-j-2)");
		transforms.put("S7", "(t,i,j->t,n-i-2,j)");
		
		embed(POLYBENCH.ADI, transforms, compositions);
	}
	
	@Test
	public void embedFDTD2D() {

		Map<String, String> transforms = new TreeMap<String, String>();
		Map<String, String> compositions = new TreeMap<String, String>();
		
		//base
		//S0, S1, S2, S3
		
		//S0: (t,i->t,i1,n-1) -- dependence from S3, all cases have i==0
		transforms.put("S0", "(t,j->t,0,j)");
		
		embed(POLYBENCH.FDTD_2D, transforms, compositions);
	}
	
	@Test
	public void embedFDTDapml() {

		Map<String, String> transforms = new TreeMap<String, String>();
		Map<String, String> compositions = new TreeMap<String, String>();
		
		//base
		//S1, S2, S3, S8, S9, S10, S11
		
		//S6: S5 o (iz,iy->iz,iy) -- only dependence is to S5
		transforms.put("S6", "(iz,iy->iz,iy)");
		compositions.put("S6", "S5");
		
		//S13: S12 o (iz,iy->iz,iy) -- only dependence is to S12
		transforms.put("S13", "(iz,iy->iz,iy)");
		compositions.put("S13", "S12");
		
		//S14: S13 o (iz,iy->iz,iy) -- only dependence is to S13
		transforms.put("S14", "(iz,iy->iz,iy)");
		compositions.put("S14", "S13");
		
		//dependences chaining to S5 and S12 are not used -- probably outputs
		transforms.put("S5", "(iz,iy->iz,iy,0)");
		transforms.put("S12", "(iz,iy->iz,iy,0)");
		
		embed(POLYBENCH.FDTD_APML, transforms, compositions);
	}
	
	private void embed(POLYBENCH bench, Map<String, String> transformsStr, Map<String, String> compositions) {
		System.out.print(bench.getName() + ": ");
		String file = bench.getFilePath(VARIATION.FIXED_INLINED);
		Program prog = alphaz.mde.Basic.ReadAlphabets(file);
		AffineSystem system = prog.getSystem(bench.getName());
		alphaz.mde.Analysis.CheckProgram(prog);
		
		//parse given transforms
		Map<String, AffineFunction> transforms = parseTransforms(system.getParameters(), transformsStr);
		
		//apply CoB
		for (String var : transforms.keySet()) {
			ChangeOfBasis.CoB(system, var, getTransform(var, transforms, compositions));
		}
		Normalize.normalize(system);
		UniformizeInContext.apply(system);
		alphaz.mde.Basic.ASave(prog, bench.getFilePath(VARIATION.FIXED_HAND_ALIGNED));

		alphaz.mde.Analysis.CheckProgram(prog);
		UniformnessResult res = UniformnessCheck.apply(system);
		System.out.println(res);
	}
	
	private Map<String, AffineFunction> parseTransforms(ParameterDomain params, Map<String, String> transformsStr) {
		Map<String, AffineFunction> transforms = new TreeMap<String, AffineFunction>();
		
		for (String key : transformsStr.keySet()) {
			transforms.put(key, PolyhedralIRUtility.parseAffineFunction(params, transformsStr.get(key)));
		}
		
		return transforms;
	}
	
	private AffineFunction getTransform(String variable, Map<String, AffineFunction> transforms, Map<String, String> compositions) {
		AffineFunction base = transforms.get(variable);
		assert(base != null) : "Variable: " + variable + " was not given a transform.";
		
		if (compositions.containsKey(variable)) {
			AffineFunction composeWith = getTransform(compositions.get(variable), transforms, compositions);
			return composeWith.compose(base);
		} else {
			return base;
		}
		
	}
}
