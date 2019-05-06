# Parse and check the program 
prog = ReadAlphabets("../J1DSkewed_inline.ab");
system = "Jacobi1D";
outDir = "../test-out/CART/";
CheckProgram(prog);

# Schedule
setSpaceTimeMap(prog, system, "temp_bl", "(iBl,tBl,iLoc,tLoc-> tBl+iBl,tBl,tLoc,iLoc)");
setSpaceTimeMap(prog, system, "B_bl", "(iBl,iLoc-> 2Tb+iBl,Tb,1,iLoc)");
setParallel(prog, system, "", "1");

# Memory
setMemorySpace(prog, system, "TempSpace", "temp_bl");
setMemoryMap(prog,system,"temp_bl","TempSpace","(iBl,tBl,iLoc,tLoc->iBl - tBl + Tb, iLoc - 2tLoc + 2b)");

# Code gen
generateScheduledCode(prog, system, outDir);
#generateWrapper(prog, system, outDir);
#generateMakefile(prog, system, outDir);
