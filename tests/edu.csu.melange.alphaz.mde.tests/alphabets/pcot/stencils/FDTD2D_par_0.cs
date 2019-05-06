prog=ReadAlphabets("FDTD2D.ab");

CheckProgram(prog);

baseSys="FDTD2D";

#PrintAST(prog,sys);

outDir="./src_gen/"+baseSys+"/PCOT/parallel/0";

#==============================================================================

setSpaceTimeMap(prog,baseSys,"Ey",		"(t,i,j  ->t,i+t,j+t)");
setSpaceTimeMap(prog,baseSys,"Ex",		"(t,i,j  ->t,i+t,j+t)");
setSpaceTimeMap(prog,baseSys,"Hz",		"(t,i,j  ->t,i+t+1,j+t+1)");
setSpaceTimeMap(prog,baseSys,"Ex_out",	"(i,j	 ->T-1,i+T-1,j+T-1)");
setSpaceTimeMap(prog,baseSys,"Ey_out",	"(i,j	 ->T-1,i+T-1,j+T-1)");
setSpaceTimeMap(prog,baseSys,"Hz_out",	"(i,j	 ->T-1,i+T,j+T)");

setStatementOrdering(prog, baseSys, "Ex", "Ex_out");
setStatementOrdering(prog, baseSys, "Ey", "Ey_out");
setStatementOrdering(prog, baseSys, "Hz", "Hz_out");

setMemoryMap(prog,baseSys,"Ey","Ey", "(t,i,j->t,i,j)", "2,0,0");
setMemoryMap(prog,baseSys,"Ex","Ex", "(t,i,j->t,i,j)", "2,0,0");
setMemoryMap(prog,baseSys,"Hz","Hz", "(t,i,j->t,i,j)", "2,0,0");

options = createCGOptionsForPCOT();
setDefaultDTilerConfiguration(prog, baseSys, 0,2,"openmp");

generatePCOTCode(prog, baseSys, outDir);

#setOrderingDimensions(prog,baseSys,"0");
#setParallel(prog,baseSys,"","2");

#generateScheduledCode(prog, baseSys, outDir);

#generateWriteC(prog, baseSys, outDir);
generateWrapper(prog, baseSys, options, outDir);
generateMakefile(prog, baseSys, outDir);

print(baseSys+" is Done.");
#==============================================================================
