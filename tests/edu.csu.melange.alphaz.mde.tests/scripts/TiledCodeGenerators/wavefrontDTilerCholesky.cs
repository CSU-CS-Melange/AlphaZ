prog = ReadAlphabets("../../testcases/cholesky/cholesky.ab");
system = "cholesky";
#system = "CholeskySerialized";
outDir = "../../test-out/"+system;
CheckProgram(prog);

#NormalizeReduction(prog);
#SerializeReduction(prog, system, "NR_L", "(i,j,k->i,j,k)");
#SerializeReduction(prog, system, "NR_L_1", "(i,j,k->i,j,k)");

#Normalize(prog);
#Simplify(prog, system);
#Normalize(prog);

#AShow(prog);

options = createTiledCGOptionForScheduledC();
setCGOptionFlattenArrays(options, 1);
#setTiledCGOptionOptimize(options, 1);		//current not available
#tile all the dimension with DTiler
setDefaultDTilerConfiguration(prog, system, "openmp");

generateScheduledCode(prog, system, options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);