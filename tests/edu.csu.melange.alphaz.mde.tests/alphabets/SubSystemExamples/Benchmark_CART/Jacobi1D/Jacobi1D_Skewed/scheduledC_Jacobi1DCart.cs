# Parse and check the program 
prog = ReadAlphabets("./Jacobi1D_Skewed_CART.ab");
system = "Jacobi1DTimeSkewed";
outDir = "./test-out/";
CheckProgram(prog);

# Schedule
setSpaceTimeMap(prog, system, "temp_bl", "(iBl,tBl,iLoc,tLoc-> tBl+iBl,iBl,tLoc+iLoc,iLoc)");
setSpaceTimeMap(prog, system, "B_bl", "(iBl,iLoc-> Tb+iBl,iBl, iLoc,iLoc)");
setParallel(prog, system, "", "1,3");

# Memory
setMemorySpace(prog, system, "TempSpace", "temp_bl");
setMemoryMap(prog,system,"temp_bl","TempSpace","(iBl,tBl,iLoc,tLoc->iBl-tBl,iLoc-tLoc)");

# Code gen
generateScheduledCode(prog, system, outDir);
generateWrapper(prog, system, outDir);
generateMakefile(prog, system, outDir);
