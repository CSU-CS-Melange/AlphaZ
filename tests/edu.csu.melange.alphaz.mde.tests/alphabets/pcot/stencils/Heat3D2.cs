prog=ReadAlphabets("Heat3D.ab");

CheckProgram(prog);

baseSys="Heat3D";

#PrintAST(prog,sys);

outDir="./src_gen/"+baseSys+"/PCOT/2";

#==============================================================================

#1,2 tilable
setSpaceTimeMap(prog,baseSys,"temp",	 "(t,i,j,k ->t,t+i,t+j,t+k)");
setSpaceTimeMap(prog,baseSys,"Aout",	 "(i,j,k   ->T,  i,  j,  k)");

setMemoryMap(prog,baseSys,"temp","temp", "(t,i,j,k ->t,  i,  j,  k)","2,0,0,0");
#setParallel(prog, baseSys, "", "1");
options = createTiledCGOptionForScheduledC();
setBandForTiling(prog, baseSys, "b1", 1,1,1);
setBandForTiling(prog, baseSys, "b2", 1,3,3);
setSubTilingWithinBand(prog,baseSys, "b1",1,"sequential");
setSubTilingWithinBand(prog,baseSys, "b2",1,"sequential");
#setDefaultDTilerConfiguration(prog, baseSys, "sequential");


#setMemoryMap(prog,baseSys,"Aout","Aout", "(i,j,k->0,i,j,k)");

#setMemorySpace(prog, baseSys, "Ctemp", "temp, Aout");
#setOrderingDimensions(prog,baseSys,"0");
#setParallel(prog,baseSys,"","2");

generatePCOTCode(prog, baseSys, outDir);

#generateWriteC(prog, baseSys, outDir);
generateWrapper(prog, baseSys, outDir);
generateMakefile(prog, baseSys, outDir);

print(baseSys+" is Done.");
#==============================================================================
