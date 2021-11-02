prog = ReadAlphabets("../../../../polybench-alpha-4.0/linear-algebra/blas/trmm/trmm.ab");
system = "trmm";
outDir = "../../../../test-out/DTiler/"+system;

CheckProgram(prog);

#PrintAST(prog, system);

# Name of the new variable: "_ser" + (varName of container equation)
SerializeReduction(prog, "(0,0,0,1)", "(i,j,k-> i,j,k)");    # => _serBout
Simplify(prog, system);

#AShow(prog, system);


# Schedule
setSpaceTimeMap(prog, system, "_serBout", "(i,j,k -> i, j, 0, k)");
setSpaceTimeMap(prog, system, "Bout",      "(i,j   -> i, j, 1, 0)");
setOrderingDimensions(prog, system, "2");


# Memory map
setMemorySpace(prog, system, "Bout", "_serBout, Bout");
setMemoryMap(prog, system, "_serBout", "Bout", "(i,j,k->i,j)");
setMemoryMap(prog, system, "Bout", "Bout", "(i,j->i,j)");


#tile the whole program
options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, system, "sequential");


# Code Generation
generateScheduledCode(prog, system, options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);

