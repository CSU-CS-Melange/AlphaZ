prog=ReadAlphabets("Heat3D.ab");

CheckProgram(prog);

baseSys="Heat3D";

#PrintAST(prog,sys);

outDir="./src_gen/"+baseSys+"/PCOT/0";

#==============================================================================

setSpaceTimeMap(prog,baseSys,"temp",	 "(t,i,j,k ->t  ,t+i,t+j,t+k)");
setSpaceTimeMap(prog,baseSys,"Aout",	 "(i,j,k   ->T-1,T-1+i,T-1+j,T-1+k)");

setStatementOrdering(prog, baseSys, "temp", "Aout");

setMemoryMap(prog,baseSys,"temp","temp", "(t,i,j,k ->t,  i,  j,  k)","2,0,0,0");

options = createCGOptionsForPCOT();
setDefaultDTilerConfiguration(prog, baseSys, "sequential");

generatePCOTCode(prog, baseSys, outDir);

generateWrapper(prog, baseSys, outDir);
generateMakefile(prog, baseSys, outDir);

print(baseSys+" is Done.");
#==============================================================================
