prog=ReadAlphabets("Heat3D.ab");

CheckProgram(prog);

baseSys="Heat3D";

#PrintAST(prog,sys);

outDir="./src_gen/"+baseSys+"/WriteC";

#==============================================================================


generateWriteC(prog, baseSys, outDir);

generateWrapper(prog, baseSys, outDir);
generateMakefile(prog, baseSys, outDir);

print(baseSys+" is Done.");
#==============================================================================
