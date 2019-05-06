prog=ReadAlphabets("LTMI.ab");

CheckProgram(prog);

sys="LTMI";
outDir="src_gen/"+sys;




generateScheduledCode(prog, sys, outDir);
#generateWriteC(prog, sys, outDir);
generateWrapper(prog, sys, outDir);
generateMakefile(prog, sys, outDir);

print(sys+" is Done.");
#==============================================================================
