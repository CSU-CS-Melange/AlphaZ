prog = ReadAlphabets("../AlphabetsExamples/jacobi_1dA_1B_1_1temp_B_1_1.ab");

#Show(prog);
#CheckProgram(prog);


# -------------------- SUBSYSTEMS ----------------------------- 

# jacobi_1d_B_bl_Tile_0
subsystem0 = "jacobi_1d_B_bl_Tile_0";
setSpaceTimeMap(prog, subsystem0, "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem0, "temp_B_bl_out", "(tLoc,iLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem0, "B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)");

setMemoryMap(prog, subsystem0, "temp_B_bl_loc", "temp_B_bl_loc",  "(tLoc,iLoc->tLoc,iLoc)", "2,0");
#setMemoryMap(prog, subsystem0, "B_bl_loc", "B_bl_loc", "(tLoc,iLoc->iLoc)");



# jacobi_1d_B_bl_Tile_1
subsystem1 = "jacobi_1d_B_bl_Tile_1";
setSpaceTimeMap(prog, subsystem1, "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem1, "temp_B_bl_out", "(tLoc,iLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem1, "B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)");

setMemoryMap(prog, subsystem1, "temp_B_bl_loc", "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)", "2,0");
#setMemoryMap(prog, subsystem1, "B_bl_loc", "B_bl_loc", "(tLoc,iLoc->iLoc)");


# jacobi_1d_B_bl_Tile_2
subsystem2 = "jacobi_1d_B_bl_Tile_2";
setSpaceTimeMap(prog, subsystem2, "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem2, "temp_B_bl_out", "(tLoc,iLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem2, "B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)");

setMemoryMap(prog, subsystem2, "temp_B_bl_loc", "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)", "2,0");
#setMemoryMap(prog, subsystem2, "B_bl_loc", "B_bl_loc", "(tLoc,iLoc->iLoc)");


# jacobi_1d_B_bl_Tile_3
subsystem3 = "jacobi_1d_B_bl_Tile_3";
setSpaceTimeMap(prog, subsystem3, "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem3, "temp_B_bl_out", "(tLoc,iLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem3, "B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)");

setMemoryMap(prog, subsystem3, "temp_B_bl_loc", "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)", "2,0");
#setMemoryMap(prog, subsystem3, "B_bl_loc", "B_bl_loc", "(tLoc,iLoc->iLoc)");


# jacobi_1d_B_bl_Tile_4
subsystem4 = "jacobi_1d_B_bl_Tile_4";
setSpaceTimeMap(prog, subsystem4, "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem4, "B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)");

setMemoryMap(prog, subsystem4, "temp_B_bl_loc", "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)", "2,0");
#setMemoryMap(prog, subsystem4, "B_bl_loc", "B_bl_loc", "(tLoc,iLoc->iLoc)");


# jacobi_1d_B_bl_Tile_5
subsystem5 = "jacobi_1d_B_bl_Tile_5";
setSpaceTimeMap(prog, subsystem5, "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem5, "temp_B_bl_out", "(tLoc,iLoc->tLoc,iLoc)");

setMemoryMap(prog, subsystem5, "temp_B_bl_loc", "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)", "2,0");


# jacobi_1d_B_bl_Tile_6
subsystem6 = "jacobi_1d_B_bl_Tile_6";
setSpaceTimeMap(prog, subsystem6, "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem6, "temp_B_bl_out", "(tLoc,iLoc->tLoc,iLoc)");

setMemoryMap(prog, subsystem6, "temp_B_bl_loc", "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)", "2,0");




# jacobi_1d_B_bl_Tile_7
subsystem7 = "jacobi_1d_B_bl_Tile_7";
setSpaceTimeMap(prog, subsystem7, "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem7, "temp_B_bl_out", "(tLoc,iLoc->tLoc,iLoc)");

setMemoryMap(prog, subsystem7, "temp_B_bl_loc", "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)", "2,0");



# jacobi_1d_B_bl_Tile_8
subsystem8 = "jacobi_1d_B_bl_Tile_8";
setSpaceTimeMap(prog, subsystem8, "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem8, "temp_B_bl_out", "(tLoc,iLoc->tLoc,iLoc)");

setMemoryMap(prog, subsystem8, "temp_B_bl_loc", "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)", "2,0");



# jacobi_1d_B_bl_Tile_9
subsystem9 = "jacobi_1d_B_bl_Tile_9";
setSpaceTimeMap(prog, subsystem9, "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem9, "temp_B_bl_out", "(tLoc,iLoc->tLoc,iLoc)");

setMemoryMap(prog, subsystem9, "temp_B_bl_loc", "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)", "2,0");




# jacobi_1d_B_bl_Tile_10
subsystem10 = "jacobi_1d_B_bl_Tile_10";
setSpaceTimeMap(prog, subsystem10, "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem10, "temp_B_bl_out", "(tLoc,iLoc->tLoc,iLoc)");

setMemoryMap(prog, subsystem10, "temp_B_bl_loc", "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)", "2,0");




# jacobi_1d_B_bl_Tile_11
subsystem11 = "jacobi_1d_B_bl_Tile_11";
setSpaceTimeMap(prog, subsystem11, "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem11, "temp_B_bl_out", "(tLoc,iLoc->tLoc,iLoc)");

setMemoryMap(prog, subsystem11, "temp_B_bl_loc", "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)", "2,0");



# jacobi_1d_B_bl_Tile_12
subsystem12 = "jacobi_1d_B_bl_Tile_12";
setSpaceTimeMap(prog, subsystem12, "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem12, "temp_B_bl_out", "(tLoc,iLoc->tLoc,iLoc)");

setMemoryMap(prog, subsystem12, "temp_B_bl_loc", "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)", "2,0");



# jacobi_1d_B_bl_Tile_13
subsystem13 = "jacobi_1d_B_bl_Tile_13";
setSpaceTimeMap(prog, subsystem13, "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem13, "temp_B_bl_out", "(tLoc,iLoc->tLoc,iLoc)");

setMemoryMap(prog, subsystem13, "temp_B_bl_loc", "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)", "2,0");



# jacobi_1d_B_bl_Tile_14
subsystem14 = "jacobi_1d_B_bl_Tile_14";
setSpaceTimeMap(prog, subsystem14, "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)");
setSpaceTimeMap(prog, subsystem14, "temp_B_bl_out", "(tLoc,iLoc->tLoc,iLoc)");

setMemoryMap(prog, subsystem14, "temp_B_bl_loc", "temp_B_bl_loc", "(tLoc,iLoc->tLoc,iLoc)", "2,0");




# -------------------- MAIN SYSTEM ----------------------------- 

mainsystem = "jacobi_1d";
setSpaceTimeMap(prog,mainsystem, "temp_B_bl", "(tBl,iBl,tLoc,iLoc->tBl+iBl,tBl,1,tLoc,iLoc,0)");
setSpaceTimeMap(prog,mainsystem, "B_bl", "(tBl,iBl,tLoc,iLoc->tBl+iBl,tBl,1,tLoc,iLoc,0)");

# UseEquation0
label0 = "UseEquation_B_bl_0";
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label0, 0,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label0, 0,1, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMap(prog,mainsystem,label0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,2)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label0, 1,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,3)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label0, 1,1, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,3)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");


# UseEquation1
label1 = "UseEquation_B_bl_1";
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label1, 0,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label1, 0,1, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label1, 0,2, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMap(prog,mainsystem,label1, "(tBl,iBl->tBl+iBl,tBl,0,0,0,2)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label1, 1,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,3)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label1, 1,1, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,3)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");


# UseEquation2
label2 = "UseEquation_B_bl_2";
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label2, 0,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label2, 0,1, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label2, 0,2, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMap(prog,mainsystem,label2, "(tBl,iBl->tBl+iBl,tBl,0,0,0,2)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label2, 1,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,3)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label2, 1,1, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,3)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");


# UseEquation3
label3 = "UseEquation_B_bl_3";
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label3, 0,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label3, 0,1, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label3, 0,2, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMap(prog,mainsystem,label3, "(tBl,iBl->tBl+iBl,tBl,0,0,0,2)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label3, 1,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,3)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label3, 1,1, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,3)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");


# UseEquation4
label4 = "UseEquation_B_bl_4";
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label4, 0,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMap(prog,mainsystem,label4, "(tBl,iBl->tBl+iBl,tBl,0,0,0,2)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label4, 1,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,3)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");


# UseEquation5
label5 = "UseEquation_temp_B_bl_5";
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label5, 0,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMap(prog,mainsystem,label5, "(tBl,iBl->tBl+iBl,tBl,0,0,0,2)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label5, 1,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,3)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");


# UseEquation6
label6 = "UseEquation_temp_B_bl_6";
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label6, 0,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label6, 0,1, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMap(prog,mainsystem,label6, "(tBl,iBl->tBl+iBl,tBl,0,0,0,2)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label6, 1,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,3)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");


# UseEquation7
label7 = "UseEquation_temp_B_bl_7";
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label7, 0,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label7, 0,1, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMap(prog,mainsystem,label7, "(tBl,iBl->tBl+iBl,tBl,0,0,0,2)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label7, 1,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,3)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");


# UseEquation8
label8 = "UseEquation_temp_B_bl_8";
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label8, 0,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label8, 0,1, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMap(prog,mainsystem,label8, "(tBl,iBl->tBl+iBl,tBl,0,0,0,2)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label8, 1,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,3)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");


# UseEquation9
label9 = "UseEquation_temp_B_bl_9";
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label9, 0,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMap(prog,mainsystem,label9, "(tBl,iBl->tBl+iBl,tBl,0,0,0,2)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label9, 1,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,3)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");


# UseEquation10
label10 = "UseEquation_temp_B_bl_10";
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label10, 0,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label10, 0,1, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMap(prog,mainsystem,label10, "(tBl,iBl->tBl+iBl,tBl,0,0,0,2)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label10, 1,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,3)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");


# UseEquation11
label11 = "UseEquation_temp_B_bl_11";
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label11, 0,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label11, 0,1, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label11, 0,2, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMap(prog,mainsystem,label11, "(tBl,iBl->tBl+iBl,tBl,0,0,0,2)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label11, 1,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,3)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");


# UseEquation12
label12 = "UseEquation_temp_B_bl_12";
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label12, 0,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label12, 0,1, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label12, 0,2, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMap(prog,mainsystem,label12, "(tBl,iBl->tBl+iBl,tBl,0,0,0,2)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label12, 1,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,3)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");


# UseEquation13
label13 = "UseEquation_temp_B_bl_13";
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label13, 0,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMap(prog,mainsystem,label13, "(tBl,iBl->tBl+iBl,tBl,0,0,0,2)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label13, 1,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,3)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");

# UseEquation14
label14 = "UseEquation_temp_B_bl_14";
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label14, 0,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label14, 0,1, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label14, 0,2, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,1)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");
setSpaceTimeMap(prog,mainsystem,label14, "(tBl,iBl->tBl+iBl,tBl,0,0,0,2)");
setSpaceTimeMapForUseEquationOptimization(prog,mainsystem,label14, 1,0, "(tBl,iBl->tBl+iBl,tBl,0,0,0,0)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,3)", "(tBl,iBl->tBl+iBl,tBl,0,0,0,4)");


# Memory allocation
# by default for now

# Generation
outDir = "../test-out/J1DCART";
generateScheduledCode(prog,mainsystem,outDir);
generateWrapper(prog,mainsystem,outDir);
generateMakefile(prog,mainsystem,outDir);



