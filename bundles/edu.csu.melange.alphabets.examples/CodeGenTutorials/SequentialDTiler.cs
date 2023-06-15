prog = ReadAlphabets("../AlphabetsExamples/MatMult/matrix_product.ab");
system = "matrix_product";
outDir = "../test-out/DTiler/"+system;
CheckProgram(prog);

#setSpaceTimeMap(prog, system, "temp_C", "(i,j,k->i,k,j)");
#setSpaceTimeMap(prog, system, "C", "(i,j,k->i,k,j)");
setMemoryMap(prog, system, "temp_C", "C", "(i,j,k->i,j)");
setMemoryMap(prog, system, "C", "C", "(i,j,k->i,j)");

options = createTiledCGOptionForScheduledC();
#tile the whole program
#setDefaultDTilerConfiguration(prog, system, "sequential");
#tile only a sub band
setDefaultDTilerConfiguration(prog, system, 1, 2, "sequential");

generateScheduledCode(prog, system, options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);