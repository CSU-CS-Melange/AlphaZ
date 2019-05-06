prog=ReadAlphabets("FDTD2D.ab");

CheckProgram(prog);

baseSys="FDTD2D";

outDir="./src_gen/"+baseSys+"/writeC";

#==============================================================================

generateWriteC(prog, baseSys, outDir);
generateWrapper(prog, baseSys, outDir);
generateMakefile(prog, baseSys, outDir);

print(baseSys+" is Done.");
#==============================================================================
