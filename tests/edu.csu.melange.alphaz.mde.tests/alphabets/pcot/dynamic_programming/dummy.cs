prog=ReadAlphabets("dummy.ab");

CheckProgram(prog);

baseSys="dummy";

#PrintAST(prog,sys);

#outDir="./src_gen/"+baseSys+"/wc";
outDir="./src_gen/"+baseSys+"/DTiler/0";

#0 tilable
setSpaceTimeMap(prog, baseSys, "C", "(i,j->i,j)");

options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, baseSys, 0, 1, "sequential");
generateScheduledCode(prog, baseSys, outDir);

#generateWriteC(prog, baseSys, outDir);
#generateWrapper(prog, baseSys, outDir);
#generateMakefile(prog, baseSys, outDir);

print(baseSys+" is Done.");
#==============================================================================
