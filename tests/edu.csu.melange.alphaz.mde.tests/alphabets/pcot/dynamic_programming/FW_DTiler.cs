prog=ReadAlphabets("FW.ab");

CheckProgram(prog);

baseSys="FW";

#PrintAST(prog,sys);

#outDir="./src_gen/"+baseSys+"/wc";
outDir="./src_gen/"+baseSys+"/PCOT/0";

#0 tilable
setSpaceTimeMap(prog, baseSys, "paths", "(k,i,j->k,i,j)");
setSpaceTimeMap(prog, baseSys, "shortestPaths", "(i,j->N+1,i,j)");

setMemoryMap(prog,baseSys,"paths","paths", "(k,i,j->k,i,j)", "2,0,0");
#setMemoryMap(prog,baseSys,"shortestPaths","(i,j->i,j)");

#setMemorySpace(prog, baseSys, "SPaths", "paths, shortestPaths");

#setParallel(prog, baseSys, "", "0");

generateScheduledCode(prog, baseSys, outDir);

#generateWriteC(prog, baseSys, outDir);
#generateWrapper(prog, baseSys, outDir);
#generateMakefile(prog, baseSys, outDir);

print(baseSys+" is Done.");
#==============================================================================
