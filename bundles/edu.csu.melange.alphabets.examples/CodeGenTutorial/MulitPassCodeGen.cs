prog = ReadAlphabets("../AlphabetsExamples/Stencils/Jacobi1D/jacobi_1d.ab");
system = "jacobi_1d";
outDir = "../test-out/DTiler/"+system;
CheckProgram(prog);

setSpaceTimeMap(prog, system, "temp_B", "(t,i->t,t+i)");
setSpaceTimeMap(prog, system, "B", "(t,i->t,t+i)");
setMemoryMap(prog, system, "temp_B", "temp_B", "(t,i->t,i)", "2,0");
setMemoryMap(prog, system, "B", "B", "(t,i->i)");

##set up dtiler vector configurations
options = createTiledCGOptionForScheduledC();
setVecOptionForTiledC(options);

##generate sequential multipass code
#generateFMPPCode(prog, system, "sequential", options, outDir);
##generate parallel multipass code
generateFMPPCode(prog, system, "omp", options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);