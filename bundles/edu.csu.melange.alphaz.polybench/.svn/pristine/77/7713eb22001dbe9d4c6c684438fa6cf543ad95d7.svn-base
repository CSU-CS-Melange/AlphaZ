prog = ReadAlphabets("../../../../polybench-alpha-4.0/linear-algebra/solvers/lu/lu.ab");
system = "lu";
outDir = "../../../../test-out/DTiler/"+system;

CheckProgram(prog);

#PrintAST(prog, system);

# Name of the new variable: "_ser" + (varName of container equation)
SerializeReduction(prog, "(0,0,0,1,0,1)", 	  "(i,j,k -> i,j,k)");    # => _serU
SerializeReduction(prog, "(0,1,0,1,0,0,1)",   "(i,j,k -> i,j,k)");    # => _serL
Simplify(prog, system);

#AShow(prog, system);


# Schedule
setSpaceTimeMap(prog, system, "_serU", "(i,j,k -> i, 0, j, k)");
setSpaceTimeMap(prog, system, "U",     "(i,j   -> i, 1, j, 0)");
setSpaceTimeMap(prog, system, "_serL", "(i,j,k -> i, 2, j, k)");
setSpaceTimeMap(prog, system, "L",     "(i,j   -> i, 3, j, 0)");

setOrderingDimensions(prog, system, "1");


# Memory map
setMemorySpace(prog, system, "temp", "_serL, _serU");
setMemoryMap(prog, system, "_serL", "temp", "(i,j,k -> i,j)");
setMemoryMap(prog, system, "_serU", "temp", "(i,j,k -> i,j)");


setMemorySpace(prog, system, "L", "L");
setMemoryMap(prog, system, "L", "L", "(i,j -> i,j)");


setMemorySpace(prog, system, "U", "U");
setMemoryMap(prog, system, "U", "U", "(i,j -> i,j)");

# OLD
#setMemorySpace(prog, system, "A", "L, U");
#setMemoryMap(prog, system, "L", "A", "(i,j -> i,j)");
#setMemoryMap(prog, system, "U", "A", "(i,j -> i,j)");



#tile the whole program
options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, system, "sequential");


# Code Generation
generateScheduledCode(prog, system, options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);

