prog = ReadAlphabets("../AlphabetsExamples/Stencils/Jacobi2D/jacobi_2d.ab");
system = "jacobi_2d";
outDir = "../test-out/DTilerVec/"+system;
CheckProgram(prog);

setSpaceTimeMap(prog, system, "temp_B", "(t,i,j->t,t+i,t+j)");
setSpaceTimeMap(prog, system, "B", "(t,i,j->t,t+i,t+j)");
setMemoryMap(prog, system, "temp_B", "temp_B", "(t,i,j->t,i,j)", "2,0,0");
setMemoryMap(prog, system, "B", "B", "(t,i,j->i,j)");

##set up dtiler vector configurations
options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, system, "openmp");
##The default setup, the vectorization strategy is "opt nobuff", and register block size is 1,4
##The simd instruction is AVX, currently onlyl AVX is supported
setVecOptionForTiledC(options);
##Set the vectorization strategy to be mostly aligned, and register block size to be 2,2 for the data dimensions
setVecOptionForTiledC(options, "mostly aligned", "2,2");
###This command extracts the corresponding vectorization statement for temp_B automatically
#setVecVarsForTiledC(prog, system, options, "temp_B");
##Or you can use the following command to configure both the variable and dimensions
setVecVarForTiledC(prog, system, options, "temp_B", "{t,i,j|t > 0 && 1<=i<N-1 && 1 <=j<M-1}");

##generate code
generateScheduledCode(prog, system, options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, options, outDir);