#prog = ReadAlphabets("./Skewed_Forward_substitution_blocked.ab");
#prog = ReadAlphabets("./Cholesky_blocked.ab");
#prog = ReadAlphabets("./test.ab");
#prog = ReadAlphabets("./Jacobi1Dskewed.ab");
#prog = ReadAlphabets("./Jacobi2D.ab");
prog = ReadAlphabets("./ForwardSubst.ab");
syst = "ForwardSubst";

#CoB(prog, syst, "temp", "(i,j,t->i+t,j+t,t)" );
#Normalize(prog);
#Simplify(prog,syst);
AShow(prog);

CheckProgram(prog);


