#Splitting the D variable to i<=j and i>j so that we can avoid max expressions in the schedule
# current schedule for D is i,j,k->i,j,max(i,j)

system = "GAPSer";
outDir = "./src_gen/"+system+"/WriteC";

prog = ReadAlphabets("GAP.ab");
CheckProgram(prog);

Split(prog, system, "D", "D_", "{i,j|i>j}");

Normalize(prog);
AShow(prog, system);

