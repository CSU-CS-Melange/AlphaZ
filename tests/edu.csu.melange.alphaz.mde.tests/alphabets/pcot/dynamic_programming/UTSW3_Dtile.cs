prog=ReadAlphabets("UTSW.ab");

CheckProgram(prog);

baseSys="UTSW";

#PrintAST(prog,sys);

outDir="./src_gen/"+baseSys+"/Dtiler/3";

#==============================================================================

setSpaceTimeMap(prog,baseSys,"Aout",		"(i  ->1,i+M,0)");
setSpaceTimeMap(prog,baseSys,"gap_penalty",	"(   ->0,   0,0)");
setSpaceTimeMap(prog,baseSys,"Table",		"(i,j->1, i+j,j)");
##or
##setSpaceTimeMap(prog,baseSys,"Table",		"(i,j->1, i,j)");

##setMemoryMap(prog,baseSys,"Aout","Aout", "(i->i)");
##setMemoryMap(prog,baseSys,"Bout","Bout", "(i->i)");
##setMemoryMap(prog,baseSys,"Table","Table", "(i,j->j)");

setOrderingDimensions(prog,baseSys,"0");
##setParallel(prog,baseSys,"","2");

options = createTiledCGOptionForScheduledC();
##tile the whole program
##setDefaultDTilerConfiguration(prog, baseSys, "sequential");
##tile only a sub band
setDefaultDTilerConfiguration(prog, baseSys, 1,1, "sequential");

#generatePCOTCode(prog, baseSys, outDir);
generateScheduledCode(prog, baseSys, outDir);
#generateWriteC(prog, baseSys, outDir);
generateWrapper(prog, baseSys, outDir);
generateMakefile(prog, baseSys, outDir);

print(baseSys+" is Done.");
#==============================================================================
