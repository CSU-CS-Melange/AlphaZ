baseSys="OSP";

prog=ReadAlphabets(baseSys+"ser.ab");

CheckProgram(prog);


#PrintAST(prog,sys);

#outDir="./src_gen/"+baseSys+"/wc";
outDir="./src_gen/"+baseSys+"ser/DTiler/0";

#NormalizeReduction(prog, baseSys, "C");

#AShow(prog);

##SerializeReduction(prog,baseSys,"NR_C","(i,j,k->i,j,k)");
#Normalize(prog);
#AShow(prog);



setSpaceTimeMap(prog, baseSys, "C", "(i,j->N-i-1,j,i)");
setSpaceTimeMap(prog, baseSys, "NR_C", "(i,j->N-i-1,j,i)");
setSpaceTimeMap(prog, baseSys, "_serNR_C", "(i,j,k->N-i-1,j,k)");

#setSpaceTimeMap(prog, baseSys, "C", "(i,j->i+j,i,j)");
#setSpaceTimeMap(prog, baseSys, "NR_C", "(i,j->i+j,i,j)");
#setSpaceTimeMap(prog, baseSys, "_serNR_C", "(i,j,k->i+j,k,j)");


setStatementOrdering(prog,baseSys,"NR_C","C");
setStatementOrdering(prog,baseSys,"_serNR_C","NR_C");

#setMemorySpace(prog, baseSys, "CSpace", "C,NR_C");

#setMemoryMap(prog,baseSys,"C","CSpace", "(i,j->i,j)");
#setMemoryMap(prog,baseSys,"NR_C","CSpace", "(i,j->i,j)");
#setMemoryMap(prog,baseSys,"_serNR_C","_serNR_C", "(i,j,k->i,j)");



options = createTiledCGOptionForScheduledC();
setDefaultDTilerConfiguration(prog, baseSys, 2, 2, "sequential");

generateScheduledCode(prog, baseSys, outDir);

#generateWriteC(prog, baseSys, outDir);
generateWrapper(prog, baseSys, outDir);
generateMakefile(prog, baseSys, outDir);

print(baseSys+" is Done.");
#==============================================================================
