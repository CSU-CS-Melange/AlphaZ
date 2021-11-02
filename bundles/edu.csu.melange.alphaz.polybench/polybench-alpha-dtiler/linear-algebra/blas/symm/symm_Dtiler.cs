# NOTE: NOT EXACT CORRESPONDANCE WITH THE POLYBENCH !!!

prog = ReadAlphabets("../../../../polybench-alpha-4.0/linear-algebra/blas/symm/symm_polybench.ab");
system = "symm";
outDir = "../../../../test-out/DTiler/"+system;

CheckProgram(prog);

#PrintAST(prog, system);

# Name of the new variable: "_ser" + (varName of container equation)
SerializeReduction(prog, "(0,0,0)", 	    "(i,j,k-> i,j,k)");     # => _sertemp2
SerializeReduction(prog, "(0,2,0,1,1,1,0)", "(i,j,k-> i,j,k)");     # => _serCout
Simplify(prog, system);

#AShow(prog, system);


# Schedule
setSpaceTimeMap(prog, system, "_sertemp2", "(i,j,k -> i, j, 0, k, 0)");
setSpaceTimeMap(prog, system, "temp2",     "(i,j -> i, j, 0, i+1, 0)");
setSpaceTimeMap(prog, system, "Ctemp",     "(i,j -> i, j, 1, 0, 0)");

setSpaceTimeMap(prog, system, "_serCout",  "(i,j,l -> l, j, 0, i, 1)");  # TODO: ???
setSpaceTimeMap(prog, system, "Cout",      "(i,j   -> i, j, 2, 0, 0)");
setOrderingDimensions(prog, system, "2,4");


# Memory map
setMemorySpace(prog, system, "temp2", "_sertemp2, temp2");
setMemoryMap(prog, system, "_sertemp2", "temp2", "(i,j,k-> i,j)");
setMemoryMap(prog, system, "temp2", "temp2", "(i,j-> i,j)");


setMemorySpace(prog, system, "tempCout", "_serCout");
setMemoryMap(prog, system, "_serCout", "tempCout", "(i,j,k->i,j)");

setMemorySpace(prog, system, "Cout", "Cout");
setMemoryMap(prog, system, "Cout", "Cout", "(i,j->i,j)");


#tile the whole program
options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, system, "sequential");


# Code Generation
generateScheduledCode(prog, system, options, outDir);
generateWrapper(prog, system, options, outDir);
generateMakefile(prog, system, outDir);

