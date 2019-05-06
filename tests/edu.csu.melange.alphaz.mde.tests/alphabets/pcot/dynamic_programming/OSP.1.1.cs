# (Un) comment one of the next two lines to choose which Alpha program 
# to process (both have the same top level system: Fib
#prog = ReadAlphabets("OSP.ab");
system = "OSP";
outDir = "./src_gen/"+system+"/PCOT/1";
#outDir = "./test_out/"+system;
#CheckProgram(prog);
#NormalizeReduction(prog, system, "C");
#SerializeReduction(prog, system, "NR_C", "(i,j,k -> i, j, k)");
###Split(prog, system, "C", "Cinit", "{i,j| 0<i==j<=N}");
#InlineAll(prog, system, "NR_C");
#RemoveUnusedVariables(prog, system);
#RenameVariable(prog, system, "_serNR_C", "Cacc");
#Normalize(prog);
#AShow(prog);

#ASave(prog, "OSP.1.ab");

####  I needed to save the previous program and reread after minor edits -- ASave/AShow
####  not doing the right thing -- or maybe it was seriaize reductions adding constructs
####  that aren't easily simplified away.
prog = ReadAlphabets("OSP.1.ab");
CheckProgram(prog);

AShow(prog);

setSpaceTimeMap(prog, system, "Cacc", "(i, j, k -> N-i+j, j, k)");
setSpaceTimeMap(prog, system, "C",	 "(i, j -> N-i+j, j, j)");

#setStatementOrdering(prog, system, "temp", "Aout");

setMemoryMap(prog, system, "Cacc", "Cacc", "(i, j, k -> i, j)");
#setMemoryMap(prog, system, "C", "C", "(i, j -> i, j");

#options = createCGOptionsForPCOT();
options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, system, 0, 1, "sequential");
#generateScheduledCode(prog, system, outDir);
generatePCOTCode(prog, system, outDir);
generateWrapper(prog, system, outDir);
generateMakefile(prog, system, outDir);
#generateWriteC(prog, system, outDir);
