# Parse and check the program 
#prog = ReadAlphabets("./Jacobi2D_CART.ab");
prog = ReadAlphabets("./Jacobi2DBis_localParamMod.ab");
system = "Jacobi2DSkewed";
outDir = "./test-out/";
CheckProgram(prog);

# Schedule:
setSpaceTimeMap(prog, system, "temp_bl", "(iBl,jBl,tBl,iLoc,jLoc,tLoc-> 0,tBl+iBl+jBl,iBl,tBl, tLoc+iLoc+jLoc,iLoc,tLoc)");
setSpaceTimeMap(prog, system, "B_bl", "(iBl,jBl,iLoc,jLoc-> 1,iBl,jBl, iLoc,jLoc,0 ,0)");
setOrderingDimensions(prog, system, 0);
setParallel(prog, system, "0", "2,5");

setMemorySpace(prog, system, "TempSpace", "temp_bl");
setMemoryMap(prog,system,"temp_bl","TempSpace","(iBl,jBl,tBl,iLoc,jLoc,tLoc->iBl-2tBl+2Tb-2,jBl-2tBl+2Tb-2,iLoc-2tLoc+2b-2,jLoc-2tLoc+2b-2)");

# Code gen
generateScheduledCode(prog, system, outDir);
generateWrapper(prog, system, outDir);
generateMakefile(prog, system, outDir);

