package fr.irisa.cairn.jnimap.cloog.util;

import fr.irisa.cairn.jnimap.cloog.jni.CloogException;
import fr.irisa.cairn.jnimap.cloog.jni.JNICloogOptions;
import fr.irisa.cairn.jnimap.cloog.jni.JNICloogState;

/**
 * Struct-like class for specifying CloogOptions
 * Makes creating JNICloogOptions with customized options easier.
 * 
 * @author yuki
 *
 */
public class CloogOptionSpecifier {
	
	public int l = -1;			//Last level to optimize
	public int f = 1;			//First level to optimize
	public int stop = -1;		//Level to stop code generation
	public int strides = 0;		//1 if user wants to handle non-unit strides
	public int esp = 1;			//1 if user wants to spread all equalities :  
								//i.e. when there is something like "i = 3*j + 1 ; A[i] = 0 ;"
								//     the generator will write "A[3*j + 1] = 0 ;"
//	public int csp = 1;			//Spread constant values (Cloog 0.14 only)
    public int fsp = 1;			//Level where equation spreading (esp) can begin
    public int otl = 1;			//1 if user wants to simplify loops with one iteration point
    public int block = 0;		//1 to create a block {...} per dimension
//    public int cpp = 0;			//DOES NOT EXIST
    public int compilable = 0; 	//1 to generate compilable code
    public int backtrack = 0;	//1 to perform backtracking in Quiller's algorithm

    public int save_domains = 0;    //1 to save unsimplified copy of domain.
    
    public int noblocks = 0;    //1 if I don't want to make statement blocks, 0 otherwise.
    public int noscalars = 0;   //1 if I don't want to use scalar dimensions, 0 otherwise.
    public int nosimplify = 0;  //1 if I don't want to simplify polyhedra, 0 otherwise.
    
    /*Options NOT provided by ClooG*/
    public int otlClast = 0;	//One Time Loop elimination done on the generated clast
    /**
     * Creates JNI object for the specified ClooGoption
     * 
     * @return
     * @throws CloogException
     */
    public JNICloogOptions getJNIObject(JNICloogState state) throws CloogException {
    	JNICloogOptions options = JNICloogOptions.malloc(state);
    	
    	if (otl > 0 && otlClast != 0) {
    		System.err.println("otl and otlClast is both turned on. It is not recommended to use both forms of OTL");
    	}
    	
    	options.setL(l);
    	options.setF(f);
    	options.setStop(stop);
    	options.setStrides(strides);
    	options.setEsp(esp);
    	options.setFsp(fsp);
    	options.setOtl(otl);
    	options.setBlock(block);
    	options.setCompilable(compilable);
    	options.setBacktrack(backtrack);
    	options.setSave_domains(save_domains);
    	options.setNoblocks(noblocks);
    	options.setNoscalars(noscalars);
    	options.setNosimplify(nosimplify);
    	return options;
    }
	
	
	public static CloogOptionSpecifier optionForFullyNestedLoop(int numIndices) {
		CloogOptionSpecifier spec =  new CloogOptionSpecifier();
		// Option with fully nested loops
		spec.l = -1;
		spec.f = 1;
		spec.stop = -1;
		spec.strides = 0;
		spec.esp = 1;
		spec.fsp = 1;
		spec.otl = 0;
		spec.block = 0;
		spec.compilable = 0;
		spec.backtrack = 1;
		spec.otlClast = numIndices+1;
		//JNICloogFactory.createOptions(l, f, stop, strides, esp, csp, fsp, otl, block, cpp, compilable, backtrack)
		 //JNICloogFactory.createOptions(-1, 1, -1, 0, 0, 1, 1, 0, 0, 0, 0, 1);
		return spec;	
	}

    
    public static CloogOptionSpecifier getDefault() {
    	return new CloogOptionSpecifier();
    }
}
