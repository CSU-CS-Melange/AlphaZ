# (Un) comment one of the next two lines to choose which Alpha program 
# to process (both have the same top level system: Fib
prog = ReadAlphabets("OSPGKT_hand.ab");
CheckProgram(prog);
system = "OSPGKT_hand";
outDir = "./src_gen/"+system+"/DTiler/parallel/0";
#outDir = "./test_out/"+system;
AShow(prog);
#First the canoninc schedule (which is tileable, but Pluto don't know
#setSpaceTimeMap(prog, system, "Cacc",	 "(i, j, k -> 0, N-i, j, N-k)");
#setSpaceTimeMap(prog, system, "C", "(i, j -> 1, N-i, j, 0)"); # the schedule for C
#		# does not matter, since the memory space is the same as that of Cacc 
#		# and the equation for C simpliy copies Cacc 
#And now the single wavefront, which is tilable

#setSpaceTimeMap(prog, system, "Cacc",	 "(i, j, k -> 0, j-i, i, N-k)");
#setSpaceTimeMap(prog, system, "C", "(i, j -> 0, j-i, i, 0)");
#setSpaceTimeMap(prog, system, "Cacc",	 "(i, j, k -> -i,j,-i+j-k)");
#setSpaceTimeMap(prog, system, "C", "(i, j ->-i,j,-i+j)");
#setSpaceTimeMap(prog, system, "Cacc",  "(i, j, k -> 0, N-i+j-k, N-i, j)");
#setSpaceTimeMap(prog, system, "C", "(i, j -> 1, i, j, 0)");
#setSpaceTimeMap(prog, system, "Cacc",  "(i, j, k ->2N-i, j, 3N-i + j - k)");
#setSpaceTimeMap(prog, system, "C", "(i, j ->2N-i, j, 3N-i + j)");
setSpaceTimeMap(prog, system, "Cacc",  "(i, j, k ->2N-i, j, 3N-i + j - k)");
setSpaceTimeMap(prog, system, "C", "(i, j ->2N-i, j, 3N-i + j)");
#setStatementOrdering(prog, system, "NR_C", "C");

setStatementOrdering(prog, system, "Cacc", "C");

setMemoryMap(prog, system, "Cacc", "C", "(i, j, k -> i, j)");
#setMemoryMap(prog, system, "C", "C", "(i, j -> i, j)"); # Identity

options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, system, 0, 2, "openmp");
generateScheduledCode(prog, system, outDir);

#generateWrapper(prog, system, outDir);
#generateMakefile(prog, system, outDir);
#generateWriteC(prog, system, outDir);
