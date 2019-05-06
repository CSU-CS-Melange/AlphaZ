prog=ReadAlphabets("SW.ab");

CheckProgram(prog);

baseSys="SW";

#PrintAST(prog,sys);

outDir="./src_gen/"+baseSys+"/PCOT/2";

#==============================================================================

#1,2 tilable
setSpaceTimeMap(prog,baseSys,"Aout",		"(i  ->i+N-1,N-1)");
setSpaceTimeMap(prog,baseSys,"Bout",		"(i  ->i+M-1,i)");
setSpaceTimeMap(prog,baseSys,"gap_penalty",	"(   ->0,0)");
setSpaceTimeMap(prog,baseSys,"Table",		"(i,j->i+j,j)");

setStatementOrdering(prog, baseSys,"gap_penalty", "Table");
setStatementOrdering(prog, baseSys,"Table", "Aout");
setStatementOrdering(prog, baseSys,"Table", "Bout");
#setSpaceTimeMap(prog,baseSys,"Aout",		"(i  ->2,i,0)");
#setSpaceTimeMap(prog,baseSys,"Bout",		"(i  ->2,i,0)");
#setSpaceTimeMap(prog,baseSys,"gap_penalty",	"(   ->0,   0,0)");
#setSpaceTimeMap(prog,baseSys,"Table",		"(i,j->1, i+j,j)");
##or
##setSpaceTimeMap(prog,baseSys,"Table",		"(i,j->1, i,j)");

##setMemoryMap(prog,baseSys,"Aout","Aout", "(i->i)");
##setMemoryMap(prog,baseSys,"Bout","Bout", "(i->i)");
##setMemoryMap(prog,baseSys,"Table","Table", "(i,j->j)");

#setOrderingDimensions(prog,baseSys,"0");
##setParallel(prog,baseSys,"","2");

options = createCGOptionsForPCOT();
#options = createTiledCGOptionForScheduledC();
##tile the whole program
##setDefaultDTilerConfiguration(prog, baseSys, "sequential");
##tile only a sub band
setDefaultDTilerConfiguration(prog, baseSys, 0, 1, "sequential");

generatePCOTCode(prog, baseSys, outDir);

#generateWriteC(prog, baseSys, outDir);
#generateWrapper(prog, baseSys, outDir);
#generateMakefile(prog, baseSys, outDir);

print(baseSys+" is Done.");
#==============================================================================
