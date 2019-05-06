#prog = ReadAlphabets("./MatProd/matProd_SubSystem.ab");
#syst = "matProd_SubSystem";

#prog = ReadAlphabets("./ForwardSubst/ForwardSubst_SubSystem.ab");
#syst = "ForwardSubst_SubSystem";

#prog = ReadAlphabets("./BackwardSubst/BackwardSubst_SubSystem.ab");
#syst = "BackwardSubst_SubSystem";

prog = ReadAlphabets("./stencil2D_5points/stencil2D_5points_skewed.ab");
syst = "stencil2D_5points";

AShow(prog);
CheckProgram(prog);


