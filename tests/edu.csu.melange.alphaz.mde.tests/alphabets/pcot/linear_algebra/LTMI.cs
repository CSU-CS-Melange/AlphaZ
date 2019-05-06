prog=ReadAlphabets("LTMI.ab");

CheckProgram(prog);

sys="LTMI";
outDir="src_gen/"+sys;

NormalizeReduction(prog, sys,"LI");

AShow(prog);

SerializeReduction(prog, sys, "NR_LI", "(i,j,k->i,j,k)");

AShow(prog);


#generateScheduledCode(prog, sys, outDir);
#generateWriteC(prog, sys, outDir);
##generateWrapper(prog, sys, outDir);
#generateMakefile(prog, sys, outDir);

print(sys+" is Done.");
#==============================================================================
