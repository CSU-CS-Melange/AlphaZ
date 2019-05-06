prog=ReadAlphabets("FDTD2D.ab");

CheckProgram(prog);

baseSys="FDTD2D";

#PrintAST(prog,sys);

outDir="./src_gen/"+baseSys+"/Dtiler/parallel/0";

#==============================================================================

ForceCoB(prog,baseSys,"Ey",		"(t,i,j  ->t,i+t,j+t)");
ForceCoB(prog,baseSys,"Ex",		"(t,i,j  ->t,i+t,j+t)");
ForceCoB(prog,baseSys,"Hz",		"(t,i,j  ->t,i+t+1,j+t+1)");
ForceCoB(prog,baseSys,"Ex_out",	"(i,j	 ->T-1,i+T-1,j+T-1)");
ForceCoB(prog,baseSys,"Ey_out",	"(i,j	 ->T-1,i+T-1,j+T-1)");
ForceCoB(prog,baseSys,"Hz_out",	"(i,j	 ->T-1,i+T,j+T)");

Normalize(prog);

AShow(prog);