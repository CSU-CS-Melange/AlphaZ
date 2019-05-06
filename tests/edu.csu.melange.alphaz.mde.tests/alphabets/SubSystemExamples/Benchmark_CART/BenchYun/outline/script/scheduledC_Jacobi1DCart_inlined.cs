# Parse and check the program 
prog = ReadAlphabets("../J1DSkewed_inlined.ab");
outDir = "../test-out/CARTInlined/";
CheckProgram(prog);

system = "Jacobi1D";

setSpaceTimeMap(prog, system, "temp_bl_loc_Jacobi1D_temp_bl_Tile_0_0", "(iBl,tBl,iLoc,tLoc->iBl+tBl,tBl,0,tLoc,iLoc)");
setSpaceTimeMap(prog, system, "temp_bl_loc_Jacobi1D_temp_bl_Tile_1_0", "(iBl,tBl,iLoc,tLoc->iBl+tBl,tBl,0,tLoc,iLoc)");
setSpaceTimeMap(prog, system, "temp_bl_loc_Jacobi1D_temp_bl_Tile_2_0", "(iBl,tBl,iLoc,tLoc->iBl+tBl,tBl,0,tLoc,iLoc)");
setSpaceTimeMap(prog, system, "temp_bl_loc_Jacobi1D_temp_bl_Tile_4_0", "(iBl,tBl,iLoc,tLoc->iBl+tBl,tBl,0,tLoc,iLoc)");
setSpaceTimeMap(prog, system, "temp_bl_loc_Jacobi1D_temp_bl_Tile_5_0", "(iBl,tBl,iLoc,tLoc->iBl+tBl,tBl,0,tLoc,iLoc)");
setSpaceTimeMap(prog, system, "temp_bl_loc_Jacobi1D_temp_bl_Tile_6_0", "(iBl,tBl,iLoc,tLoc->iBl+tBl,tBl,0,tLoc,iLoc)");
setSpaceTimeMap(prog, system, "temp_bl_loc_Jacobi1D_temp_bl_Tile_8_0", "(iBl,tBl,iLoc,tLoc->iBl+tBl,tBl,0,tLoc,iLoc)");
setSpaceTimeMap(prog, system, "temp_bl_loc_Jacobi1D_temp_bl_Tile_10_0", "(iBl,tBl,iLoc,tLoc->iBl+tBl,tBl,0,tLoc,iLoc)");
setSpaceTimeMap(prog, system, "temp_bl_loc_Jacobi1D_temp_bl_Tile_12_0", "(iBl,tBl,iLoc,tLoc->iBl+tBl,tBl,0,tLoc,iLoc)");
setSpaceTimeMap(prog, system, "temp_bl_0", "(iBl,tBl,iLoc,tLoc->iBl+tBl,tBl,0,tLoc,iLoc)");
setSpaceTimeMap(prog, system, "temp_bl_1", "(iBl,tBl,iLoc,tLoc->iBl+tBl,tBl,0,tLoc,iLoc)");
setSpaceTimeMap(prog, system, "temp_bl_2", "(iBl,tBl,iLoc,tLoc->iBl+tBl,tBl,0,tLoc,iLoc)");
setSpaceTimeMap(prog, system, "temp_bl_3", "(iBl,tBl,iLoc,tLoc->iBl+tBl,tBl,0,tLoc,iLoc)");
setSpaceTimeMap(prog, system, "temp_bl_4", "(iBl,tBl,iLoc,tLoc->iBl+tBl,tBl,0,tLoc,iLoc)");
setSpaceTimeMap(prog, system, "temp_bl_5", "(iBl,tBl,iLoc,tLoc->iBl+tBl,tBl,0,tLoc,iLoc)");
setSpaceTimeMap(prog, system, "temp_bl_6", "(iBl,tBl,iLoc,tLoc->iBl+tBl,tBl,0,tLoc,iLoc)");
setSpaceTimeMap(prog, system, "temp_bl_7", "(iBl,tBl,iLoc,tLoc->iBl+tBl,tBl,0,tLoc,iLoc)");
setSpaceTimeMap(prog, system, "temp_bl_8", "(iBl,tBl,iLoc,tLoc->iBl+tBl,tBl,0,tLoc,iLoc)");
setSpaceTimeMap(prog, system, "temp_bl_9", "(iBl,tBl,iLoc,tLoc->iBl+tBl,tBl,0,tLoc,iLoc)");
setSpaceTimeMap(prog, system, "temp_bl_10", "(iBl,tBl,iLoc,tLoc->iBl+tBl,tBl,0,tLoc,iLoc)");
setSpaceTimeMap(prog, system, "temp_bl_11", "(iBl,tBl,iLoc,tLoc->iBl+tBl,tBl,0,tLoc,iLoc)");
setSpaceTimeMap(prog, system, "temp_bl_12", "(iBl,tBl,iLoc,tLoc->iBl+tBl,tBl,0,tLoc,iLoc)");

setSpaceTimeMap(prog, system, "temp_bl", "(iBl,tBl,iLoc,tLoc->iBl+tBl,tBl,1,tLoc,iLoc)");
setSpaceTimeMap(prog, system, "B_bl_0", "(iBl,iLoc-> 2Tb+iBl,Tb,2,iLoc,0)");
setSpaceTimeMap(prog, system, "B_bl", "(iBl,iLoc-> 2Tb+iBl,Tb,2,iLoc,1)");

setParallel(prog, system, "", "1");

setMemorySpace(prog, system, "temp_tile_0", "temp_bl_loc_Jacobi1D_temp_bl_Tile_0_0");
setMemoryMap(prog, system,"temp_bl_loc_Jacobi1D_temp_bl_Tile_0_0","temp_tile_0","(iBl,tBl,iLoc,tLoc->iBl-tBl+Tb,iLoc-2tLoc+2b)");

setMemorySpace(prog, system, "temp_tile_1", "temp_bl_loc_Jacobi1D_temp_bl_Tile_1_0");
setMemoryMap(prog, system,"temp_bl_loc_Jacobi1D_temp_bl_Tile_1_0","temp_tile_1","(iBl,tBl,iLoc,tLoc->iBl-tBl+Tb,iLoc-2tLoc+2b)");

setMemorySpace(prog, system, "temp_tile_2", "temp_bl_loc_Jacobi1D_temp_bl_Tile_2_0");
setMemoryMap(prog, system,"temp_bl_loc_Jacobi1D_temp_bl_Tile_2_0","temp_tile_2","(iBl,tBl,iLoc,tLoc->iBl-tBl+Tb,iLoc-2tLoc+2b)");

setMemorySpace(prog, system, "temp_tile_4", "temp_bl_loc_Jacobi1D_temp_bl_Tile_4_0");
setMemoryMap(prog, system,"temp_bl_loc_Jacobi1D_temp_bl_Tile_4_0","temp_tile_4","(iBl,tBl,iLoc,tLoc->iBl-tBl+Tb,iLoc-2tLoc+2b)");

setMemorySpace(prog, system, "temp_tile_5", "temp_bl_loc_Jacobi1D_temp_bl_Tile_5_0");
setMemoryMap(prog, system,"temp_bl_loc_Jacobi1D_temp_bl_Tile_5_0","temp_tile_5","(iBl,tBl,iLoc,tLoc->iBl-tBl+Tb,iLoc-2tLoc+2b)");

setMemorySpace(prog, system, "temp_tile_6", "temp_bl_loc_Jacobi1D_temp_bl_Tile_6_0");
setMemoryMap(prog, system,"temp_bl_loc_Jacobi1D_temp_bl_Tile_6_0","temp_tile_6","(iBl,tBl,iLoc,tLoc->iBl-tBl+Tb,iLoc-2tLoc+2b)");

setMemorySpace(prog, system, "temp_tile_8", "temp_bl_loc_Jacobi1D_temp_bl_Tile_8_0");
setMemoryMap(prog, system,"temp_bl_loc_Jacobi1D_temp_bl_Tile_8_0","temp_tile_8","(iBl,tBl,iLoc,tLoc->iBl-tBl+Tb,iLoc-2tLoc+2b)");

setMemorySpace(prog, system, "temp_tile_10", "temp_bl_loc_Jacobi1D_temp_bl_Tile_10_0");
setMemoryMap(prog, system,"temp_bl_loc_Jacobi1D_temp_bl_Tile_10_0","temp_tile_10","(iBl,tBl,iLoc,tLoc->iBl-tBl+Tb,iLoc-2tLoc+2b)");

setMemorySpace(prog, system, "temp_tile_12", "temp_bl_loc_Jacobi1D_temp_bl_Tile_12_0");
setMemoryMap(prog, system,"temp_bl_loc_Jacobi1D_temp_bl_Tile_12_0","temp_tile_12","(iBl,tBl,iLoc,tLoc->iBl-tBl+Tb,iLoc-2tLoc+2b)");

setMemorySpace(prog, system, "TempSpace", "temp_bl");
setMemoryMap(prog,system,"temp_bl","TempSpace","(iBl,tBl,iLoc,tLoc->iBl - tBl + Tb, iLoc, tLoc)");
setMemorySpace(prog, system, "TempSpace", "temp_bl_0");
setMemoryMap(prog,system,"temp_bl_0","TempSpace","(iBl,tBl,iLoc,tLoc->iBl - tBl + Tb, iLoc, tLoc)");
setMemorySpace(prog, system, "TempSpace", "temp_bl_1");
setMemoryMap(prog,system,"temp_bl_1","TempSpace","(iBl,tBl,iLoc,tLoc->iBl - tBl + Tb, iLoc, tLoc)");
setMemorySpace(prog, system, "TempSpace", "temp_bl_2");
setMemoryMap(prog,system,"temp_bl_2","TempSpace","(iBl,tBl,iLoc,tLoc->iBl - tBl + Tb, iLoc, tLoc)");
setMemorySpace(prog, system, "TempSpace", "temp_bl_3");
setMemoryMap(prog,system,"temp_bl_3","TempSpace","(iBl,tBl,iLoc,tLoc->iBl - tBl + Tb, iLoc, tLoc)");
setMemorySpace(prog, system, "TempSpace", "temp_bl_4");
setMemoryMap(prog,system,"temp_bl_4","TempSpace","(iBl,tBl,iLoc,tLoc->iBl - tBl + Tb, iLoc, tLoc)");
setMemorySpace(prog, system, "TempSpace", "temp_bl_5");
setMemoryMap(prog,system,"temp_bl_5","TempSpace","(iBl,tBl,iLoc,tLoc->iBl - tBl + Tb, iLoc, tLoc)");
setMemorySpace(prog, system, "TempSpace", "temp_bl_6");
setMemoryMap(prog,system,"temp_bl_6","TempSpace","(iBl,tBl,iLoc,tLoc->iBl - tBl + Tb, iLoc, tLoc)");
setMemorySpace(prog, system, "TempSpace", "temp_bl_7");
setMemoryMap(prog,system,"temp_bl_7","TempSpace","(iBl,tBl,iLoc,tLoc->iBl - tBl + Tb, iLoc, tLoc)");
setMemorySpace(prog, system, "TempSpace", "temp_bl_8");
setMemoryMap(prog,system,"temp_bl_8","TempSpace","(iBl,tBl,iLoc,tLoc->iBl - tBl + Tb, iLoc, tLoc)");
setMemorySpace(prog, system, "TempSpace", "temp_bl_9");
setMemoryMap(prog,system,"temp_bl_9","TempSpace","(iBl,tBl,iLoc,tLoc->iBl - tBl + Tb, iLoc, tLoc)");
setMemorySpace(prog, system, "TempSpace", "temp_bl_10");
setMemoryMap(prog,system,"temp_bl_10","TempSpace","(iBl,tBl,iLoc,tLoc->iBl - tBl + Tb, iLoc, tLoc)");
setMemorySpace(prog, system, "TempSpace", "temp_bl_11");
setMemoryMap(prog,system,"temp_bl_11","TempSpace","(iBl,tBl,iLoc,tLoc->iBl - tBl + Tb, iLoc, tLoc)");
setMemorySpace(prog, system, "TempSpace", "temp_bl_12");
setMemoryMap(prog,system,"temp_bl_12","TempSpace","(iBl,tBl,iLoc,tLoc->iBl - tBl + Tb, iLoc, tLoc)");

setMemorySpace(prog, system, "B_bl", "B_bl, B_bl_0");

# Code gen
generateScheduledCode(prog, system, outDir);
generateWrapper(prog, system, outDir);
generateMakefile(prog, system, outDir);
