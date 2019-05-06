system = "GAPSerSplit";
outDir = "./src_gen/"+system+"/DTiler/0";

prog = ReadAlphabets("GAP.ab");
CheckProgram(prog);

#setSpaceTimeMap(prog, system, "lastCol", "(i, j -> i, j, max(i,j))");
#setSpaceTimeMap(prog, system, "lastRow",	 "(i, j -> i, j, max(i,j))");
setSpaceTimeMap(prog, system, "OUT",	 "( -> i, j, N)");
setSpaceTimeMap(prog, system, "D",	 "(i, j -> i, j, j)");
setSpaceTimeMap(prog, system, "D_",	 "(i, j -> i, j, i)");
setSpaceTimeMap(prog, system, "E",	 "(i, j -> i, j, j-1)");
setSpaceTimeMap(prog, system, "F",	 "(i, j -> i, j, i-1)");
setSpaceTimeMap(prog, system, "Eacc",	 "(i,j,k -> i, j, k)");
setSpaceTimeMap(prog, system, "Facc",	 "(i,j,k -> i, j, k)");

setStatementOrdering(prog, system, "Eacc", "E");
setStatementOrdering(prog, system, "Facc", "F");
#setStatementOrdering(prog, system, "D", "lastCol");
#setStatementOrdering(prog, system, "D", "lastRow");
setStatementOrdering(prog, system, "D", "lastRow");

#setMemoryMap(prog, system, "Cacc", "C", "(i, j, k -> i, j)");
#setMemoryMap(prog, system, "C", "C", "(i, j -> i, j");

options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, system, 0, 1, "openmp");

generateScheduledCode(prog, system, outDir);

generateWrapper(prog, system, outDir);
generateMakefile(prog, system, outDir);
