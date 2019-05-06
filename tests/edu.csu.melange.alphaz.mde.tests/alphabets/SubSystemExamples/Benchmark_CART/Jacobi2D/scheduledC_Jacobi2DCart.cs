# Parse and check the program 
#prog = ReadAlphabets("./Jacobi2D_CART.ab");
prog = ReadAlphabets("./Jacobi2D_CART_localParamMod.ab");
system = "Jacobi2DSkewed";
outDir = "./test-out/";
#CheckProgram(prog);

# Schedule:
setSpaceTimeMap(prog, system, "temp_bl", "(iBl,jBl,tBl,iLoc,jLoc,tLoc->tBl+iBl+jBl,iBl,tBl, tLoc+iLoc+jLoc,iLoc,tLoc)");
setSpaceTimeMap(prog, system, "B_bl", "(iBl,jBl,iLoc,jLoc-> Tb+iBl+jBl,iBl,Tb, iLoc+jLoc,iLoc,0)");

setParallel(prog, system, "", "2,5");

# WRONG MEM SPACE
#setMemorySpace(prog, system, "TempSpace", "temp_bl");
#setMemoryMap(prog,system,"temp_bl","TempSpace","(iBl,jBl,tBl,iLoc,jLoc,tLoc->iBl-tBl,jBl-tBl,iLoc-tLoc,jLoc-tLoc)");

# Code gen
generateScheduledCode(prog, system, outDir);
generateWrapper(prog, system, outDir);
generateMakefile(prog, system, outDir);

