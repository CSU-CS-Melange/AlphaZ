# (Un) comment one of the next two lines to choose which Alpha program 
# to process (both have the same top level system: Fib
#prog = ReadAlphabets("OSP.ab");
#CheckProgram(prog);
system = "OSP";
outDir = "./src_gen/"+system+"/WriteC";

prog = ReadAlphabets("OSP.1.ab");
CheckProgram(prog);
generateWrapper(prog, system, outDir);
generateMakefile(prog, system, outDir);
generateWriteC(prog, system, outDir);
