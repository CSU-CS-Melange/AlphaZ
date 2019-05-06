prog=ReadAlphabets("Heat3D.ab");

CheckProgram(prog);

baseSys="Heat3D";

#PrintAST(prog,sys);

outDir="./src_gen/"+baseSys+"/PCOT/1";

#==============================================================================

setSpaceTimeMap(prog,baseSys,"temp",	 "(t,i,j,k ->t,t+i,t+j,t+k)");
setSpaceTimeMap(prog,baseSys,"Aout",	 "(i,j,k   ->T,  i,  j,  k)");

#AShow(prog);

setMemoryMap(prog,baseSys,"temp","temp", "(t,i,j,k ->t,  i,  j,  k)","2,0,0,0");
#setMemoryMap(prog,baseSys,"Aout","Aout", "(i,j,k->0,i,j,k)");

options = createCGOptionsForPCOT();
setDefaultDTilerConfiguration(prog, baseSys, "sequential");

generatePCOTCode(prog, baseSys, outDir);

generateWrapper(prog, baseSys, outDir);
generateMakefile(prog, baseSys, outDir);

print(baseSys+" is Done.");
#==============================================================================
