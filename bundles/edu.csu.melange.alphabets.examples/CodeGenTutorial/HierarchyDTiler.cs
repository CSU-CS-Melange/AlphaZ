prog = ReadAlphabets("../AlphabetsExamples/MatMult/matrix_product.ab");
system = "matrix_product";
outDir = "../test-out/DTiler/"+system;
CheckProgram(prog);

#setSpaceTimeMap(prog, system, "temp_C", "(i,j,k->i,k,j)");
#setSpaceTimeMap(prog, system, "C", "(i,j,k->i,k,j)");
setMemoryMap(prog, system, "temp_C", "C", "(i,j,k->i,j)");
setMemoryMap(prog, system, "C", "C", "(i,j,k->i,j)");

options = createTiledCGOptionForScheduledC();
#Two level tiling for the whole program 
setBandForTiling(prog, system, "band1", 2, 0, 2);
setSubTilingWithinBand(prog, system, "band1", 1, 0, 1, "sequential");
setSubTilingWithinBand(prog, system, "band1", 2, 0, 2, "openmp");

generateScheduledCode(prog, system, options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);