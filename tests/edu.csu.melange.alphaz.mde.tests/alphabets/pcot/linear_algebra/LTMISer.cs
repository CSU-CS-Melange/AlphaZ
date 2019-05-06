prog=ReadAlphabets("LTMISer.ab");

CheckProgram(prog);

sys="LTMISer";
outDir="src_gen/"+sys+"/PCOT/0";

setSpaceTimeMap(prog,sys,"LI","(i,j->i,j,i)");
setSpaceTimeMap(prog,sys,"LITemp","(i,j,k->i,j,k)");

setStatementOrdering(prog, sys,"LITemp","LI");

setMemoryMap(prog, sys, "LITemp", "LI", "(i,j,k->i,j)");

options = createCGOptionsForPCOT();
#options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, sys, 0, 2, "sequential");


generatePCOTCode(prog, sys, outDir);
#generateWriteC(prog, sys, outDir);
generateWrapper(prog, sys, outDir);
generateMakefile(prog, sys, outDir);

print(sys+" is Done.");
#==============================================================================
