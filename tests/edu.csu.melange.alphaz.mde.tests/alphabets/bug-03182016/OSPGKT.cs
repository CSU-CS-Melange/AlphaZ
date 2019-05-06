# (Un) comment one of the next two lines to choose which Alpha program 
# to process (both have the same top level system: Fib
prog = ReadAlphabets("OSPGKT.ab");
CheckProgram(prog);
system = "OSPGKT";
outDir = "./test_out/"+system;
NormalizeReduction(prog, system, "C");
Normalize(prog);
AShow(prog);
####  We will generate (untiled) scheduled code *without* seriaizing the reductions
####  And because D tilesr simply takes these loops, we should also be able to
####  generate tiled code.

####  BUT IT DID NOT WORK, so I have to serialize manually

SerializeReduction(prog, system, "NR_C", "(i,j,k -> i, j, k)");
###Split(prog, system, "C", "Cinit", "{i,j| 0<i==j<=N}");
#InlineAll(prog, system, "NR_C");
#RemoveUnusedVariables(prog, system);
#RenameVariable(prog, system, "_serNR_C", "Cacc");
#Normalize(prog);
#AShow(prog);


####  I needed to save the previous program and reread after minor edits -- ASave/AShow
####  not doing the right thing -- or maybe it was seriaize reductions adding constructs
####  that aren't easily simplified away.

#setSpaceTimeMap(prog, system, "NR_C", "(i, j, k -> N-i, j, j-i-k+1)");
#setSpaceTimeMap(prog, system, "C",	 "(i, j -> N-i, j, j-i)");

#setStatementOrdering(prog, system, "NR_C", "C");

#setMemoryMap(prog, system, "NR_C", "C", "(i, j -> i, j)");
#setMemoryMap(prog, system, "C", "C", "(i, j -> i, j)"); # Identity

#options = createTiledCGOptionForScheduledC();
#setDefaultDTilerConfiguration(prog, system, 0, 1, "openmp");
#generateScheduledCode(prog, system, outDir);

#generateWrapper(prog, system, outDir);
#generateMakefile(prog, system, outDir);
#generateWriteC(prog, system, outDir);
