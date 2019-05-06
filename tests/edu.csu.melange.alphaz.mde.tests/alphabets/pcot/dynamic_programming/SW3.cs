prog=ReadAlphabets("SW.ab");

CheckProgram(prog);

baseSys="SW";

#PrintAST(prog,sys);

outDir="./src_gen/"+baseSys+"/PCOT/3";

#==============================================================================

setSpaceTimeMap(prog,baseSys,"Aout",		"(i  ->1,i+N,0)");
setSpaceTimeMap(prog,baseSys,"Bout",		"(i  ->1,i+M,0)");
setSpaceTimeMap(prog,baseSys,"gap_penalty",	"(   ->0,   0,0)");
setSpaceTimeMap(prog,baseSys,"Table",		"(i,j->1, i+j,j)");
##or
##setSpaceTimeMap(prog,baseSys,"Table",		"(i,j->1, i,j)");

setOrderingDimensions(prog,baseSys,"0");

options = createCGOptionsForPCOT();
#options = createTiledCGOptionForScheduledC();
##tile the whole program
##setDefaultDTilerConfiguration(prog, baseSys, "sequential");
##tile only a sub band
setDefaultDTilerConfiguration(prog, baseSys, 1, 2, "sequential");

generatePCOTCode(prog, baseSys, outDir);
#generateWrapper(prog, baseSys, outDir);
#generateMakefile(prog, baseSys, outDir);

print(baseSys+" is Done.");
#==============================================================================
