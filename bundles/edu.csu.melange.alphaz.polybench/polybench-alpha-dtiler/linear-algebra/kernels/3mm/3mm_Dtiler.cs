prog = ReadAlphabets("../../../../polybench-alpha-4.0/linear-algebra/kernels/3mm/3mm.ab");
system = "3mm";
outDir = "../../../../test-out/DTiler/"+system;

CheckProgram(prog);

#PrintAST(prog, system);

# Name of the new variable: "_ser" + (varName of container equation)
SerializeReduction(prog, "(0,0,0)", "(i,j,k-> i,j,k)");    # => _serE
SerializeReduction(prog, "(0,1,0)", "(i,j,k-> i,j,k)");    # => _serF
SerializeReduction(prog, "(0,2,0)", "(i,j,k-> i,j,k)");    # => _serG
Simplify(prog, system);

#AShow(prog, system);


# Schedule
setSpaceTimeMap(prog, system, "_serE",    "(i,j,k -> 0, i, j, 0, k)");
setSpaceTimeMap(prog, system, "E",        "(i,j   -> 0, i, j, 1, 0)");
setSpaceTimeMap(prog, system, "_serF",    "(i,j,k -> 1, i, j, 0, k)");
setSpaceTimeMap(prog, system, "F",        "(i,j   -> 1, i, j, 1, 0)");
setSpaceTimeMap(prog, system, "_serG",    "(i,j,k -> 1, i, j, 0, k)");
setSpaceTimeMap(prog, system, "G",        "(i,j   -> 1, i, j, 1, 0)");
setOrderingDimensions(prog, system, "0,3");


# Memory map
setMemorySpace(prog, system, "E", "_serE, E");
setMemoryMap(prog, system, "_serE", "E", "(i,j,k->i,j)");
setMemoryMap(prog, system, "E", "E", "(i,j->i,j)");

setMemorySpace(prog, system, "F", "_serF, F");
setMemoryMap(prog, system, "_serF", "F", "(i,j,k->i,j)");
setMemoryMap(prog, system, "F", "F", "(i,j->i,j)");

setMemorySpace(prog, system, "G", "_serG, G");
setMemoryMap(prog, system, "_serG", "G", "(i,j,k->i,j)");
setMemoryMap(prog, system, "G", "G", "(i,j->i,j)");

#tile the whole program
options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, system, "sequential");


# Code Generation
generateScheduledCode(prog, system, options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);

