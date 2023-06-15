prog = ReadAlphabets("../AlphabetsExamples/Stencils/Jacobi1D/jacobi_1d.ab");
system = "jacobi_1d";
outDir = "../test-out/FMPPVec/"+system;
CheckProgram(prog);

setSpaceTimeMap(prog, system, "temp_B", "(t,i->t,t+i)");
setSpaceTimeMap(prog, system, "B", "(t,i->t,t+i)");
setMemoryMap(prog, system, "temp_B", "temp_B", "(t,i->t,i)", "2,0");
setMemoryMap(prog, system, "B", "B", "(t,i->i)");

##set up dtiler vector configurations
options = createTiledCGOptionForScheduledC();
##Vectorization is currently only supported for DTiler/FMPP, where all the dimensions are tiled
##Set the vectorization strategy and  register blocks size -- we assume the outermost dimension is a time dimension
##Use naive vectorization and register block size is 2 (outermost time dimension is excluded)
setVecOptionForTiledC(options, "naive", "2");
##Set the variable for whom the computation statements have to be vectorized
##The vectorizable statement is automatically extracted, with boundary statement peeled off
setVecVarsForTiledC(prog, system, options, "temp_B");

##generate sequential multipass code
#generateFMPPCode(prog, system, "sequential", options, outDir);
##generate parallel multipass code
generateFMPPCode(prog, system, "omp", options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, options, outDir);