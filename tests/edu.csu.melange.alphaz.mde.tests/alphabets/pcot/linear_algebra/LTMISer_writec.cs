prog=ReadAlphabets("LTMISer.ab");

CheckProgram(prog);

sys="LTMISer";
outDir="src_gen/"+sys+"/WriteC";

generateWriteC(prog, sys, outDir);
generateWrapper(prog, sys, outDir);
generateMakefile(prog, sys, outDir);

print(sys+" is Done.");
#==============================================================================
