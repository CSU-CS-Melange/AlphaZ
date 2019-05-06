# Parse and check the program 
prog = ReadAlphabets("../J1DSkewed_outline.ab");
outDir = "../test-out/CARTOutlinedDefaultParallel/";
CheckProgram(prog);

##################################### set up schedule for each subtile #########################
#####Jacobi1D_temp_bl_Tile_0
subsystem0 = "Jacobi1D_temp_bl_Tile_0";
setSpaceTimeMap(prog, subsystem0, "temp_bl_loc", "(iLoc,tLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem0, "temp_bl_out", "(iLoc,tLoc->tLoc,iLoc)");

setMemorySpace(prog, subsystem0, "Temp", "temp_bl_loc");
setMemoryMap(prog, subsystem0,"temp_bl_loc","Temp","(iLoc, tLoc->iLoc - 2tLoc + 2b)");

#####Jacobi1D_temp_bl_Tile_1
subsystem1 = "Jacobi1D_temp_bl_Tile_1";
setSpaceTimeMap(prog, subsystem1, "temp_bl_loc", "(iLoc,tLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem1, "temp_bl_out", "(iLoc,tLoc->tLoc,iLoc)");

setMemorySpace(prog, subsystem1, "Temp", "temp_bl_loc");
setMemoryMap(prog, subsystem1,"temp_bl_loc","Temp","(iLoc, tLoc->iLoc - 2tLoc + 2b)");

#####Jacobi1D_temp_bl_Tile_2
subsystem2 = "Jacobi1D_temp_bl_Tile_2";
setSpaceTimeMap(prog, subsystem2, "temp_bl_loc", "(iLoc,tLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem2, "temp_bl_out", "(iLoc,tLoc->tLoc,iLoc)");

setMemorySpace(prog, subsystem2, "Temp", "temp_bl_loc");
setMemoryMap(prog, subsystem2,"temp_bl_loc","Temp","(iLoc, tLoc->iLoc-2tLoc + 2b)");

#####Jacobi1D_temp_bl_Tile_3
subsystem3 = "Jacobi1D_temp_bl_Tile_3";
setSpaceTimeMap(prog, subsystem3, "temp_bl_loc", "(tLoc,iLoc->tLoc,iLoc)");

#####Jacobi1D_temp_bl_Tile_4
subsystem4 = "Jacobi1D_temp_bl_Tile_4";
setSpaceTimeMap(prog, subsystem4, "temp_bl_loc", "(iLoc,tLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem4, "temp_bl_out", "(iLoc,tLoc->tLoc,iLoc)");

setMemorySpace(prog, subsystem4, "Temp", "temp_bl_loc");
setMemoryMap(prog, subsystem4,"temp_bl_loc","Temp","(iLoc, tLoc->iLoc-2tLoc + 2b)");

#####Jacobi1D_temp_bl_Tile_5
subsystem5 = "Jacobi1D_temp_bl_Tile_5";
setSpaceTimeMap(prog, subsystem5, "temp_bl_loc", "(iLoc,tLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem5, "temp_bl_out", "(iLoc,tLoc->tLoc,iLoc)");

setMemorySpace(prog, subsystem5, "Temp", "temp_bl_loc");
setMemoryMap(prog, subsystem5,"temp_bl_loc","Temp","(iLoc, tLoc->iLoc-2tLoc + 2b)");

#####Jacobi1D_temp_bl_Tile_6
subsystem6 = "Jacobi1D_temp_bl_Tile_6";
setSpaceTimeMap(prog, subsystem6, "temp_bl_loc", "(iLoc,tLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem6, "temp_bl_out", "(iLoc,tLoc->tLoc,iLoc)");

setMemorySpace(prog, subsystem6, "Temp", "temp_bl_loc");
setMemoryMap(prog, subsystem6,"temp_bl_loc","Temp","(iLoc, tLoc->iLoc-2tLoc + 2b)");

#####Jacobi1D_temp_bl_Tile_7
subsystem7 = "Jacobi1D_temp_bl_Tile_7";
setSpaceTimeMap(prog, subsystem7, "temp_bl_loc", "(iLoc,tLoc->tLoc,iLoc)");

#####Jacobi1D_temp_bl_Tile_8
subsystem8 = "Jacobi1D_temp_bl_Tile_8";
setSpaceTimeMap(prog, subsystem8, "temp_bl_loc", "(iLoc,tLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem8, "temp_bl_out", "(iLoc,tLoc->tLoc,iLoc)");

setMemorySpace(prog, subsystem8, "Temp", "temp_bl_loc");
setMemoryMap(prog, subsystem8,"temp_bl_loc","Temp","(iLoc, tLoc->iLoc-2tLoc + 2b)");

#####Jacobi1D_temp_bl_Tile_9
subsystem9 = "Jacobi1D_temp_bl_Tile_9";
setSpaceTimeMap(prog, subsystem9, "temp_bl_loc", "(tLoc,iLoc->tLoc,iLoc)");

#####Jacobi1D_temp_bl_Tile_10
subsystem10 = "Jacobi1D_temp_bl_Tile_10";
setSpaceTimeMap(prog, subsystem10, "temp_bl_loc", "(iLoc,tLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem10, "temp_bl_out", "(iLoc,tLoc->tLoc,iLoc)");

setMemorySpace(prog, subsystem10, "Temp", "temp_bl_loc");
setMemoryMap(prog, subsystem10, "temp_bl_loc","Temp","(iLoc, tLoc->iLoc-2tLoc + 2b)");

#####Jacobi1D_temp_bl_Tile_11
subsystem11 = "Jacobi1D_temp_bl_Tile_11";
setSpaceTimeMap(prog, subsystem11, "temp_bl_loc", "(iLoc,tLoc->tLoc,iLoc)");

#####Jacobi1D_temp_bl_Tile_12
subsystem12 = "Jacobi1D_temp_bl_Tile_12";
setSpaceTimeMap(prog, subsystem12, "temp_bl_loc", "(iLoc,tLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem12, "temp_bl_out", "(iLoc,tLoc->tLoc,iLoc)");

setMemorySpace(prog, subsystem12, "Temp", "temp_bl_loc");
setMemoryMap(prog, subsystem12, "temp_bl_loc","Temp","(iLoc, tLoc->iLoc-2tLoc + 2b)");

#####Jacobi1D_B_bl_Tile_0
subsystem13 = "Jacobi1D_B_bl_Tile_0";
setSpaceTimeMap(prog, subsystem13, "B_bl_loc", "(iLoc->iLoc)");

#######################set up schedule for the main system#####################
system = "Jacobi1D";

# Use equation schedule
label0 = "UseEquation_temp_bl_0";
setSpaceTimeMap(prog, system, label0, "(iBl,tBl->iBl+tBl,tBl,0,2,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label0, 0, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label0, 1, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,3,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");

label1 = "UseEquation_temp_bl_1";
setSpaceTimeMap(prog, system, label1, "(iBl,tBl->iBl+tBl,tBl,0,2,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label1, 0, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label1, 0, 1, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label1, 1, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,3,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");

label2 = "UseEquation_temp_bl_2";
setSpaceTimeMap(prog, system, label2, "(iBl,tBl->iBl+tBl,tBl,0,2,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label2, 0, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label2, 0, 1, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label2, 1, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,3,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");

label3 = "UseEquation_temp_bl_3";
setSpaceTimeMap(prog, system, label3, "(iBl,tBl->iBl+tBl,tBl,0,2,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label3, 0, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label3, 0, 1, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label3, 1, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,3,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");

label4 = "UseEquation_temp_bl_4";
setSpaceTimeMap(prog, system, label4, "(iBl,tBl->iBl+tBl,tBl,0,2,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label4, 0, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label4, 0, 1, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label4, 1, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,3,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");

label5 = "UseEquation_temp_bl_5";
setSpaceTimeMap(prog, system, label5, "(iBl,tBl->iBl+tBl,tBl,0,2,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label5, 0, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label5, 1, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,3,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");

label6 = "UseEquation_temp_bl_6";
setSpaceTimeMap(prog, system, label6, "(iBl,tBl->iBl+tBl,tBl,0,2,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label6, 0, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label6, 1, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,3,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");

label7 = "UseEquation_temp_bl_7";
setSpaceTimeMap(prog, system, label7, "(iBl,tBl->iBl+tBl,tBl,0,2,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label7, 0, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label7, 0, 1, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label7, 1, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,3,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");

label8 = "UseEquation_temp_bl_8";
setSpaceTimeMap(prog, system, label8, "(iBl,tBl->iBl+tBl,tBl,0,2,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label8, 0, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label8, 0, 1, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label8, 0, 2, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label8, 1, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,3,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");

label9 = "UseEquation_temp_bl_9";
setSpaceTimeMap(prog, system, label9, "(iBl,tBl->iBl+tBl,tBl,0,2,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label9, 0, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label9, 0, 1, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label9, 1, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,3,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");

label10 = "UseEquation_temp_bl_10";
setSpaceTimeMap(prog, system, label10, "(iBl,tBl->iBl+tBl,tBl,0,2,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label10, 0, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label10, 0, 1, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label10, 0, 2, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label10, 1, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,3,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");

label11 = "UseEquation_temp_bl_11";
setSpaceTimeMap(prog, system, label11, "(iBl,tBl->iBl+tBl,tBl,0,2,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label11, 0, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label11, 0, 1, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label11, 1, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,3,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");

label12 = "UseEquation_temp_bl_12";
setSpaceTimeMap(prog, system, label12, "(iBl,tBl->iBl+tBl,tBl,0,2,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label12, 0, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label12, 0, 1, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label12, 0, 2, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,1,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label12, 1, 0, "(iBl,tBl->iBl+tBl,tBl,0,0,0)", "(iBl,tBl->iBl+tBl,tBl,0,3,0)", "(iBl,tBl->iBl+tBl,tBl,0,4,0)");

label13 = "UseEquation_B_bl_0";
setSpaceTimeMap(prog, system, label13, "(iBl->iBl+2Tb,Tb,1,2,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label13, 0, 0, "(iBl->iBl+2Tb,Tb,1,0,0)", "(iBl->iBl+2Tb,Tb,1,1,0)", "(iBl->iBl+2Tb,Tb,1,4,0)");
setSpaceTimeMapForUseEquationOptimization(prog, system, label13, 1, 0, "(iBl->iBl+2Tb,Tb,1,0,0)", "(iBl->iBl+2Tb,Tb,1,3,0)", "(iBl->iBl+2Tb,Tb,1,4,0)");

# Schedule
setSpaceTimeMap(prog, system, "temp_bl", "(iBl,tBl,iLoc,tLoc-> tBl+iBl,tBl,1,tLoc,iLoc)");
setSpaceTimeMap(prog, system, "B_bl", "(iBl,iLoc-> 2Tb+iBl,Tb,2,iLoc,0)");
setParallel(prog, system, "", "1");

# Memory
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
#generateWrapper(prog, system, outDir);
generateMakefile(prog, system, outDir);
