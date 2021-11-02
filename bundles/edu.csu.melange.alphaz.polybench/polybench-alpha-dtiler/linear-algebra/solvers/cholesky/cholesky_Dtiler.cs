prog = ReadAlphabets("../../../../polybench-alpha-4.0/linear-algebra/solvers/cholesky/cholesky_lessRed.ab");
system = "cholesky";
outDir = "../../../../test-out/DTiler/"+system;

CheckProgram(prog);

#PrintAST(prog, system);

# Name of the new variable: "_ser" + (varName of container equation)
SerializeReduction(prog, "(0,0,0)", "(i,j,k -> i,j,k)");    # => _sertemp
Simplify(prog, system);

#AShow(prog, system);


# Schedule
setSpaceTimeMap(prog, system, "_sertemp", "(i,j,k -> i, 0, j, k)");
setSpaceTimeMap(prog, system, "temp",     "(i,j   -> i, 1, j, 0)");
setSpaceTimeMap(prog, system, "L",        "(i,j   -> i, 2, j, 0)");
setOrderingDimensions(prog, system, "1");


# Memory map
setMemorySpace(prog, system, "L", "L, temp, _sertemp");
setMemoryMap(prog, system, "_sertemp", "L", "(i,j,k -> i,j)");
setMemoryMap(prog, system, "temp", "L",      "(i,j -> i,j)");
setMemoryMap(prog, system, "L", "L",         "(i,j   -> i,j)");


#tile the whole program
options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, system, "sequential");


# Code Generation
generateScheduledCode(prog, system, options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);

