prog = ReadAlphabets("../../../../polybench-alpha-4.0/linear-algebra/blas/syrk/syrk.ab");
system = "syrk";
outDir = "../../../../test-out/DTiler/"+system;

CheckProgram(prog);

#PrintAST(prog, system);

# Name of the new variable: "_ser" + (varName of container equation)
SerializeReduction(prog, "(0,0,0,0,1)", "(i,j,k-> i,j,k)");    # => _serCout
Simplify(prog, system);

#AShow(prog, system);


# Schedule
setSpaceTimeMap(prog, system, "_serCout", "(i,j,k -> i, 0, k, j)");
setSpaceTimeMap(prog, system, "Cout",      "(i,j   -> i, 1, j, 0)");
setOrderingDimensions(prog, system, "1");


# Memory map
setMemorySpace(prog, system, "Cout", "_serCout, Cout");
setMemoryMap(prog, system, "_serCout", "Cout", "(i,j,k->i,j)");
setMemoryMap(prog, system, "Cout", "Cout", "(i,j->i,j)");


#tile the whole program
options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, system, "sequential");


# Code Generation
generateScheduledCode(prog, system, options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);

