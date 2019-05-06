prog=ReadAlphabets("SW.ab");

CheckProgram(prog);

baseSys="SW";

#PrintAST(prog,sys);

outDir="./src_gen/"+baseSys+"/scheduledC";

#==============================================================================

#1,2 tilable
setSpaceTimeMap(prog,baseSys,"Aout",		"(i  ->1,i+N,0)");
setSpaceTimeMap(prog,baseSys,"Bout",		"(i  ->1,i+M,0)");
setSpaceTimeMap(prog,baseSys,"gap_penalty",	"(   ->0,   0,0)");
setSpaceTimeMap(prog,baseSys,"Table",		"(i,j->1, i+j,j)");
#or
#setSpaceTimeMap(prog,baseSys,"Table",		"(i,j->1, i,j)");

#setMemoryMap(prog,baseSys,"Aout","Aout", "(i->i)");
#setMemoryMap(prog,baseSys,"Bout","Bout", "(i->i)");
#setMemoryMap(prog,baseSys,"Table","Table", "(i,j->j)");

setOrderingDimensions(prog,baseSys,"0");
#setParallel(prog,baseSys,"","2");

#options = createTiledCGOptionForScheduledC();
#tile only a sub band
#setDefaultDTilerConfiguration(prog, baseSys, 1, 2, "sequential");

#generatePCOTCode(prog, baseSys, outDir);

generateScheduledCode(prog, baseSys, outDir);
generateWrapper(prog, baseSys, outDir);
generateMakefile(prog, baseSys, outDir);

print(baseSys+" is Done.");
#==============================================================================
